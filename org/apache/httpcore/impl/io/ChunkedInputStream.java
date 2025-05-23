package org.apache.httpcore.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.httpcore.ConnectionClosedException;
import org.apache.httpcore.Header;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.MalformedChunkCodingException;
import org.apache.httpcore.TruncatedChunkException;
import org.apache.httpcore.config.MessageConstraints;
import org.apache.httpcore.io.BufferInfo;
import org.apache.httpcore.io.SessionInputBuffer;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.CharArrayBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ChunkedInputStream extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private static final int CHUNK_CRLF = 3;
    private static final int CHUNK_DATA = 2;
    private static final int CHUNK_INVALID = Integer.MAX_VALUE;
    private static final int CHUNK_LEN = 1;
    private final CharArrayBuffer buffer;
    private long chunkSize;
    private boolean closed;
    private final MessageConstraints constraints;
    private boolean eof;
    private Header[] footers;

    /* renamed from: in, reason: collision with root package name */
    private final SessionInputBuffer f423546in;
    private long pos;
    private int state;

    public ChunkedInputStream(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints) {
        this.eof = false;
        this.closed = false;
        this.footers = new Header[0];
        this.f423546in = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
        this.pos = 0L;
        this.buffer = new CharArrayBuffer(16);
        this.constraints = messageConstraints == null ? MessageConstraints.DEFAULT : messageConstraints;
        this.state = 1;
    }

    private long getChunkSize() throws IOException {
        int i3 = this.state;
        if (i3 != 1) {
            if (i3 == 3) {
                this.buffer.clear();
                if (this.f423546in.readLine(this.buffer) != -1) {
                    if (this.buffer.isEmpty()) {
                        this.state = 1;
                    } else {
                        throw new MalformedChunkCodingException("Unexpected content at the end of chunk");
                    }
                } else {
                    throw new MalformedChunkCodingException("CRLF expected at end of chunk");
                }
            } else {
                throw new IllegalStateException("Inconsistent codec state");
            }
        }
        this.buffer.clear();
        if (this.f423546in.readLine(this.buffer) != -1) {
            int indexOf = this.buffer.indexOf(59);
            if (indexOf < 0) {
                indexOf = this.buffer.length();
            }
            String substringTrimmed = this.buffer.substringTrimmed(0, indexOf);
            try {
                return Long.parseLong(substringTrimmed, 16);
            } catch (NumberFormatException unused) {
                throw new MalformedChunkCodingException("Bad chunk header: " + substringTrimmed);
            }
        }
        throw new ConnectionClosedException("Premature end of chunk coded message body: closing chunk expected");
    }

    private void nextChunk() throws IOException {
        if (this.state != Integer.MAX_VALUE) {
            try {
                long chunkSize = getChunkSize();
                this.chunkSize = chunkSize;
                if (chunkSize >= 0) {
                    this.state = 2;
                    this.pos = 0L;
                    if (chunkSize == 0) {
                        this.eof = true;
                        parseTrailerHeaders();
                        return;
                    }
                    return;
                }
                throw new MalformedChunkCodingException("Negative chunk size");
            } catch (MalformedChunkCodingException e16) {
                this.state = Integer.MAX_VALUE;
                throw e16;
            }
        }
        throw new MalformedChunkCodingException("Corrupt data stream");
    }

    private void parseTrailerHeaders() throws IOException {
        try {
            this.footers = AbstractMessageParser.parseHeaders(this.f423546in, this.constraints.getMaxHeaderCount(), this.constraints.getMaxLineLength(), null);
        } catch (HttpException e16) {
            MalformedChunkCodingException malformedChunkCodingException = new MalformedChunkCodingException("Invalid footer: " + e16.getMessage());
            malformedChunkCodingException.initCause(e16);
            throw malformedChunkCodingException;
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.f423546in instanceof BufferInfo) {
            return (int) Math.min(((BufferInfo) r0).length(), this.chunkSize - this.pos);
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            try {
                if (!this.eof && this.state != Integer.MAX_VALUE) {
                    do {
                    } while (read(new byte[2048]) >= 0);
                }
            } finally {
                this.eof = true;
                this.closed = true;
            }
        }
    }

    public Header[] getFooters() {
        return (Header[]) this.footers.clone();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!this.closed) {
            if (this.eof) {
                return -1;
            }
            if (this.state != 2) {
                nextChunk();
                if (this.eof) {
                    return -1;
                }
            }
            int read = this.f423546in.read();
            if (read != -1) {
                long j3 = this.pos + 1;
                this.pos = j3;
                if (j3 >= this.chunkSize) {
                    this.state = 3;
                }
            }
            return read;
        }
        throw new IOException("Attempted read from closed stream.");
    }

    public ChunkedInputStream(SessionInputBuffer sessionInputBuffer) {
        this(sessionInputBuffer, null);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        if (!this.closed) {
            if (this.eof) {
                return -1;
            }
            if (this.state != 2) {
                nextChunk();
                if (this.eof) {
                    return -1;
                }
            }
            int read = this.f423546in.read(bArr, i3, (int) Math.min(i16, this.chunkSize - this.pos));
            if (read != -1) {
                long j3 = this.pos + read;
                this.pos = j3;
                if (j3 >= this.chunkSize) {
                    this.state = 3;
                }
                return read;
            }
            this.eof = true;
            throw new TruncatedChunkException("Truncated chunk (expected size: %,d; actual size: %,d)", Long.valueOf(this.chunkSize), Long.valueOf(this.pos));
        }
        throw new IOException("Attempted read from closed stream.");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
