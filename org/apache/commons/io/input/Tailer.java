package org.apache.commons.io.input;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import org.apache.commons.io.FileUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Tailer implements Runnable {
    private static final int DEFAULT_BUFSIZE = 4096;
    private static final Charset DEFAULT_CHARSET = Charset.defaultCharset();
    private static final int DEFAULT_DELAY_MILLIS = 1000;
    private static final String RAF_MODE = "r";
    private final Charset cset;
    private final long delayMillis;
    private final boolean end;
    private final File file;
    private final byte[] inbuf;
    private final TailerListener listener;
    private final boolean reOpen;
    private volatile boolean run;

    public Tailer(File file, TailerListener tailerListener) {
        this(file, tailerListener, 1000L);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j3, boolean z16, int i3) {
        return create(file, tailerListener, j3, z16, false, i3);
    }

    private long readLines(RandomAccessFile randomAccessFile) throws IOException {
        int read;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(64);
        try {
            long filePointer = randomAccessFile.getFilePointer();
            long j3 = filePointer;
            boolean z16 = false;
            while (getRun() && (read = randomAccessFile.read(this.inbuf)) != -1) {
                for (int i3 = 0; i3 < read; i3++) {
                    byte b16 = this.inbuf[i3];
                    if (b16 != 10) {
                        if (b16 != 13) {
                            if (z16) {
                                this.listener.handle(new String(byteArrayOutputStream.toByteArray(), this.cset));
                                byteArrayOutputStream.reset();
                                filePointer = i3 + j3 + 1;
                                z16 = false;
                            }
                            byteArrayOutputStream.write(b16);
                        } else {
                            if (z16) {
                                byteArrayOutputStream.write(13);
                            }
                            z16 = true;
                        }
                    } else {
                        this.listener.handle(new String(byteArrayOutputStream.toByteArray(), this.cset));
                        byteArrayOutputStream.reset();
                        filePointer = i3 + j3 + 1;
                        z16 = false;
                    }
                }
                j3 = randomAccessFile.getFilePointer();
            }
            randomAccessFile.seek(filePointer);
            TailerListener tailerListener = this.listener;
            if (tailerListener instanceof TailerListenerAdapter) {
                ((TailerListenerAdapter) tailerListener).endOfFileReached();
            }
            byteArrayOutputStream.close();
            return filePointer;
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }

    public long getDelay() {
        return this.delayMillis;
    }

    public File getFile() {
        return this.file;
    }

    protected boolean getRun() {
        return this.run;
    }

    @Override // java.lang.Runnable
    public void run() {
        RandomAccessFile randomAccessFile;
        long readLines;
        long lastModified;
        RandomAccessFile randomAccessFile2 = null;
        long j3 = 0;
        long j16 = 0;
        while (getRun() && randomAccessFile2 == null) {
            try {
                try {
                    try {
                        randomAccessFile2 = new RandomAccessFile(this.file, RAF_MODE);
                    } catch (FileNotFoundException unused) {
                        this.listener.fileNotFound();
                    }
                    if (randomAccessFile2 == null) {
                        LockMethodProxy.sleep(this.delayMillis);
                    } else {
                        if (this.end) {
                            j16 = this.file.length();
                        } else {
                            j16 = 0;
                        }
                        j3 = this.file.lastModified();
                        randomAccessFile2.seek(j16);
                    }
                } catch (InterruptedException e16) {
                    e = e16;
                } catch (Exception e17) {
                    e = e17;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
        while (getRun()) {
            boolean isFileNewer = FileUtils.isFileNewer(this.file, j3);
            long length = this.file.length();
            if (length < j16) {
                this.listener.fileRotated();
                try {
                    randomAccessFile = new RandomAccessFile(this.file, RAF_MODE);
                } catch (Throwable th6) {
                    th = th6;
                    randomAccessFile = randomAccessFile2;
                }
                try {
                    try {
                        readLines(randomAccessFile2);
                    } catch (IOException e18) {
                        this.listener.handle(e18);
                    }
                    if (randomAccessFile2 != null) {
                        try {
                            try {
                                randomAccessFile2.close();
                            } catch (InterruptedException e19) {
                                e = e19;
                                randomAccessFile2 = randomAccessFile;
                                Thread.currentThread().interrupt();
                                this.listener.handle(e);
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (IOException e26) {
                                        e = e26;
                                        this.listener.handle(e);
                                        stop();
                                    }
                                }
                                stop();
                            } catch (Exception e27) {
                                e = e27;
                                randomAccessFile2 = randomAccessFile;
                                this.listener.handle(e);
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (IOException e28) {
                                        e = e28;
                                        this.listener.handle(e);
                                        stop();
                                    }
                                }
                                stop();
                            } catch (Throwable th7) {
                                th = th7;
                                randomAccessFile2 = randomAccessFile;
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (IOException e29) {
                                        this.listener.handle(e29);
                                    }
                                }
                                stop();
                                throw th;
                            }
                        } catch (FileNotFoundException unused2) {
                            j16 = 0;
                            randomAccessFile2 = randomAccessFile;
                            this.listener.fileNotFound();
                            LockMethodProxy.sleep(this.delayMillis);
                        }
                    }
                    j16 = 0;
                    randomAccessFile2 = randomAccessFile;
                } catch (Throwable th8) {
                    th = th8;
                    try {
                        throw th;
                    } catch (Throwable th9) {
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (Throwable th10) {
                                try {
                                    th.addSuppressed(th10);
                                } catch (FileNotFoundException unused3) {
                                    randomAccessFile2 = randomAccessFile;
                                    this.listener.fileNotFound();
                                    LockMethodProxy.sleep(this.delayMillis);
                                }
                            }
                        }
                        throw th9;
                        break;
                    }
                }
            } else {
                if (length > j16) {
                    readLines = readLines(randomAccessFile2);
                    lastModified = this.file.lastModified();
                } else {
                    if (isFileNewer) {
                        randomAccessFile2.seek(0L);
                        readLines = readLines(randomAccessFile2);
                        lastModified = this.file.lastModified();
                    }
                    if (this.reOpen && randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                    LockMethodProxy.sleep(this.delayMillis);
                    if (getRun() && this.reOpen) {
                        randomAccessFile = new RandomAccessFile(this.file, RAF_MODE);
                        randomAccessFile.seek(j16);
                        randomAccessFile2 = randomAccessFile;
                    }
                }
                long j17 = readLines;
                j3 = lastModified;
                j16 = j17;
                if (this.reOpen) {
                    randomAccessFile2.close();
                }
                LockMethodProxy.sleep(this.delayMillis);
                if (getRun()) {
                    randomAccessFile = new RandomAccessFile(this.file, RAF_MODE);
                    randomAccessFile.seek(j16);
                    randomAccessFile2 = randomAccessFile;
                }
            }
        }
        if (randomAccessFile2 != null) {
            try {
                randomAccessFile2.close();
            } catch (IOException e36) {
                e = e36;
                this.listener.handle(e);
                stop();
            }
        }
        stop();
    }

    public void stop() {
        this.run = false;
    }

    public Tailer(File file, TailerListener tailerListener, long j3) {
        this(file, tailerListener, j3, false);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j3, boolean z16, boolean z17, int i3) {
        return create(file, DEFAULT_CHARSET, tailerListener, j3, z16, z17, i3);
    }

    public Tailer(File file, TailerListener tailerListener, long j3, boolean z16) {
        this(file, tailerListener, j3, z16, 4096);
    }

    public static Tailer create(File file, Charset charset, TailerListener tailerListener, long j3, boolean z16, boolean z17, int i3) {
        Tailer tailer = new Tailer(file, charset, tailerListener, j3, z16, z17, i3);
        BaseThread baseThread = new BaseThread(tailer);
        baseThread.setDaemon(true);
        baseThread.start();
        return tailer;
    }

    public Tailer(File file, TailerListener tailerListener, long j3, boolean z16, boolean z17) {
        this(file, tailerListener, j3, z16, z17, 4096);
    }

    public Tailer(File file, TailerListener tailerListener, long j3, boolean z16, int i3) {
        this(file, tailerListener, j3, z16, false, i3);
    }

    public Tailer(File file, TailerListener tailerListener, long j3, boolean z16, boolean z17, int i3) {
        this(file, DEFAULT_CHARSET, tailerListener, j3, z16, z17, i3);
    }

    public Tailer(File file, Charset charset, TailerListener tailerListener, long j3, boolean z16, boolean z17, int i3) {
        this.run = true;
        this.file = file;
        this.delayMillis = j3;
        this.end = z16;
        this.inbuf = new byte[i3];
        this.listener = tailerListener;
        tailerListener.init(this);
        this.reOpen = z17;
        this.cset = charset;
    }

    public static Tailer create(File file, TailerListener tailerListener, long j3, boolean z16) {
        return create(file, tailerListener, j3, z16, 4096);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j3, boolean z16, boolean z17) {
        return create(file, tailerListener, j3, z16, z17, 4096);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j3) {
        return create(file, tailerListener, j3, false);
    }

    public static Tailer create(File file, TailerListener tailerListener) {
        return create(file, tailerListener, 1000L, false);
    }
}
