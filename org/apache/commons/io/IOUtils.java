package org.apache.commons.io;

import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.io.output.StringBuilderWriter;

/* compiled from: P */
/* loaded from: classes29.dex */
public class IOUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final char DIR_SEPARATOR = File.separatorChar;
    public static final char DIR_SEPARATOR_UNIX = '/';
    public static final char DIR_SEPARATOR_WINDOWS = '\\';
    public static final int EOF = -1;
    public static final String LINE_SEPARATOR;
    public static final String LINE_SEPARATOR_UNIX = "\n";
    public static final String LINE_SEPARATOR_WINDOWS = "\r\n";
    private static final int SKIP_BUFFER_SIZE = 2048;
    private static byte[] SKIP_BYTE_BUFFER;
    private static char[] SKIP_CHAR_BUFFER;

    static {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter(4);
        try {
            PrintWriter printWriter = new PrintWriter(stringBuilderWriter);
            try {
                printWriter.println();
                LINE_SEPARATOR = stringBuilderWriter.toString();
                printWriter.close();
                stringBuilderWriter.close();
            } finally {
            }
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    stringBuilderWriter.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }

    public static BufferedReader buffer(Reader reader) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    }

    public static void close(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    @Deprecated
    public static void closeQuietly(Reader reader) {
        closeQuietly((Closeable) reader);
    }

    public static boolean contentEquals(InputStream inputStream, InputStream inputStream2) throws IOException {
        if (inputStream == inputStream2) {
            return true;
        }
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        if (!(inputStream2 instanceof BufferedInputStream)) {
            inputStream2 = new BufferedInputStream(inputStream2);
        }
        for (int read = inputStream.read(); -1 != read; read = inputStream.read()) {
            if (read != inputStream2.read()) {
                return false;
            }
        }
        return inputStream2.read() == -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        if (r2 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean contentEqualsIgnoreEOL(Reader reader, Reader reader2) throws IOException {
        if (reader == reader2) {
            return true;
        }
        BufferedReader bufferedReader = toBufferedReader(reader);
        BufferedReader bufferedReader2 = toBufferedReader(reader2);
        String readLine = bufferedReader.readLine();
        String readLine2 = bufferedReader2.readLine();
        while (readLine != null && readLine2 != null && readLine.equals(readLine2)) {
            readLine = bufferedReader.readLine();
            readLine2 = bufferedReader2.readLine();
        }
        return readLine.equals(readLine2);
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        long copyLarge = copyLarge(inputStream, outputStream);
        if (copyLarge > TTL.MAX_VALUE) {
            return -1;
        }
        return (int) copyLarge;
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream) throws IOException {
        return copy(inputStream, outputStream, 4096);
    }

    public static LineIterator lineIterator(Reader reader) {
        return new LineIterator(reader);
    }

    public static int read(Reader reader, char[] cArr, int i3, int i16) throws IOException {
        if (i16 < 0) {
            throw new IllegalArgumentException("Length must not be negative: " + i16);
        }
        int i17 = i16;
        while (i17 > 0) {
            int read = reader.read(cArr, (i16 - i17) + i3, i17);
            if (-1 == read) {
                break;
            }
            i17 -= read;
        }
        return i16 - i17;
    }

    public static void readFully(Reader reader, char[] cArr, int i3, int i16) throws IOException {
        int read = read(reader, cArr, i3, i16);
        if (read == i16) {
            return;
        }
        throw new EOFException("Length to read: " + i16 + " actual: " + read);
    }

    @Deprecated
    public static List<String> readLines(InputStream inputStream) throws IOException {
        return readLines(inputStream, Charset.defaultCharset());
    }

    public static byte[] resourceToByteArray(String str) throws IOException {
        return resourceToByteArray(str, null);
    }

    public static String resourceToString(String str, Charset charset) throws IOException {
        return resourceToString(str, charset, null);
    }

    public static URL resourceToURL(String str) throws IOException {
        return resourceToURL(str, null);
    }

    public static long skip(InputStream inputStream, long j3) throws IOException {
        if (j3 >= 0) {
            if (SKIP_BYTE_BUFFER == null) {
                SKIP_BYTE_BUFFER = new byte[2048];
            }
            long j16 = j3;
            while (j16 > 0) {
                long read = inputStream.read(SKIP_BYTE_BUFFER, 0, (int) Math.min(j16, 2048L));
                if (read < 0) {
                    break;
                }
                j16 -= read;
            }
            return j3 - j16;
        }
        throw new IllegalArgumentException("Skip count must be non-negative, actual: " + j3);
    }

    public static void skipFully(InputStream inputStream, long j3) throws IOException {
        if (j3 >= 0) {
            long skip = skip(inputStream, j3);
            if (skip == j3) {
                return;
            }
            throw new EOFException("Bytes to skip: " + j3 + " actual: " + skip);
        }
        throw new IllegalArgumentException("Bytes to skip must not be negative: " + j3);
    }

    public static InputStream toBufferedInputStream(InputStream inputStream) throws IOException {
        return ByteArrayOutputStream.toBufferedInputStream(inputStream);
    }

    public static BufferedReader toBufferedReader(Reader reader) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            copy(inputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
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

    @Deprecated
    public static char[] toCharArray(InputStream inputStream) throws IOException {
        return toCharArray(inputStream, Charset.defaultCharset());
    }

    @Deprecated
    public static InputStream toInputStream(CharSequence charSequence) {
        return toInputStream(charSequence, Charset.defaultCharset());
    }

    @Deprecated
    public static String toString(InputStream inputStream) throws IOException {
        return toString(inputStream, Charset.defaultCharset());
    }

    public static void write(byte[] bArr, OutputStream outputStream) throws IOException {
        if (bArr != null) {
            outputStream.write(bArr);
        }
    }

    public static void writeChunked(byte[] bArr, OutputStream outputStream) throws IOException {
        if (bArr != null) {
            int length = bArr.length;
            int i3 = 0;
            while (length > 0) {
                int min = Math.min(length, 4096);
                outputStream.write(bArr, i3, min);
                length -= min;
                i3 += min;
            }
        }
    }

    @Deprecated
    public static void writeLines(Collection<?> collection, String str, OutputStream outputStream) throws IOException {
        writeLines(collection, str, outputStream, Charset.defaultCharset());
    }

    public static BufferedReader buffer(Reader reader, int i3) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i3);
    }

    @Deprecated
    public static void closeQuietly(Writer writer) {
        closeQuietly((Closeable) writer);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, int i3) throws IOException {
        return copyLarge(inputStream, outputStream, new byte[i3]);
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j3 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j3;
            }
            outputStream.write(bArr, 0, read);
            j3 += read;
        }
    }

    public static LineIterator lineIterator(InputStream inputStream, Charset charset) throws IOException {
        return new LineIterator(new InputStreamReader(inputStream, Charsets.toCharset(charset)));
    }

    public static List<String> readLines(InputStream inputStream, Charset charset) throws IOException {
        return readLines(new InputStreamReader(inputStream, Charsets.toCharset(charset)));
    }

    public static byte[] resourceToByteArray(String str, ClassLoader classLoader) throws IOException {
        return toByteArray(resourceToURL(str, classLoader));
    }

    public static String resourceToString(String str, Charset charset, ClassLoader classLoader) throws IOException {
        return toString(resourceToURL(str, classLoader), charset);
    }

    public static URL resourceToURL(String str, ClassLoader classLoader) throws IOException {
        URL resource = classLoader == null ? IOUtils.class.getResource(str) : classLoader.getResource(str);
        if (resource != null) {
            return resource;
        }
        throw new IOException("Resource not found: " + str);
    }

    public static InputStream toBufferedInputStream(InputStream inputStream, int i3) throws IOException {
        return ByteArrayOutputStream.toBufferedInputStream(inputStream, i3);
    }

    public static BufferedReader toBufferedReader(Reader reader, int i3) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i3);
    }

    public static char[] toCharArray(InputStream inputStream, Charset charset) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        copy(inputStream, charArrayWriter, charset);
        return charArrayWriter.toCharArray();
    }

    public static InputStream toInputStream(CharSequence charSequence, Charset charset) {
        return toInputStream(charSequence.toString(), charset);
    }

    public static String toString(InputStream inputStream, Charset charset) throws IOException {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        try {
            copy(inputStream, stringBuilderWriter, charset);
            String stringBuilderWriter2 = stringBuilderWriter.toString();
            stringBuilderWriter.close();
            return stringBuilderWriter2;
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    stringBuilderWriter.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }

    @Deprecated
    public static void write(byte[] bArr, Writer writer) throws IOException {
        write(bArr, writer, Charset.defaultCharset());
    }

    public static void writeLines(Collection<?> collection, String str, OutputStream outputStream, Charset charset) throws IOException {
        if (collection == null) {
            return;
        }
        if (str == null) {
            str = LINE_SEPARATOR;
        }
        Charset charset2 = Charsets.toCharset(charset);
        for (Object obj : collection) {
            if (obj != null) {
                outputStream.write(obj.toString().getBytes(charset2));
            }
            outputStream.write(str.getBytes(charset2));
        }
    }

    public static BufferedWriter buffer(Writer writer) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer);
    }

    @Deprecated
    public static void closeQuietly(InputStream inputStream) {
        closeQuietly((Closeable) inputStream);
    }

    @Deprecated
    public static void copy(InputStream inputStream, Writer writer) throws IOException {
        copy(inputStream, writer, Charset.defaultCharset());
    }

    public static LineIterator lineIterator(InputStream inputStream, String str) throws IOException {
        return lineIterator(inputStream, Charsets.toCharset(str));
    }

    public static int read(Reader reader, char[] cArr) throws IOException {
        return read(reader, cArr, 0, cArr.length);
    }

    public static void readFully(Reader reader, char[] cArr) throws IOException {
        readFully(reader, cArr, 0, cArr.length);
    }

    public static InputStream toInputStream(CharSequence charSequence, String str) throws IOException {
        return toInputStream(charSequence, Charsets.toCharset(str));
    }

    public static void write(byte[] bArr, Writer writer, Charset charset) throws IOException {
        if (bArr != null) {
            writer.write(new String(bArr, Charsets.toCharset(charset)));
        }
    }

    public static BufferedWriter buffer(Writer writer, int i3) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i3);
    }

    @Deprecated
    public static void closeQuietly(OutputStream outputStream) {
        closeQuietly((Closeable) outputStream);
    }

    public static void copy(InputStream inputStream, Writer writer, Charset charset) throws IOException {
        copy(new InputStreamReader(inputStream, Charsets.toCharset(charset)), writer);
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, long j3, long j16) throws IOException {
        return copyLarge(inputStream, outputStream, j3, j16, new byte[4096]);
    }

    public static int read(InputStream inputStream, byte[] bArr, int i3, int i16) throws IOException {
        if (i16 < 0) {
            throw new IllegalArgumentException("Length must not be negative: " + i16);
        }
        int i17 = i16;
        while (i17 > 0) {
            int read = inputStream.read(bArr, (i16 - i17) + i3, i17);
            if (-1 == read) {
                break;
            }
            i17 -= read;
        }
        return i16 - i17;
    }

    public static void readFully(InputStream inputStream, byte[] bArr, int i3, int i16) throws IOException {
        int read = read(inputStream, bArr, i3, i16);
        if (read == i16) {
            return;
        }
        throw new EOFException("Length to read: " + i16 + " actual: " + read);
    }

    public static List<String> readLines(InputStream inputStream, String str) throws IOException {
        return readLines(inputStream, Charsets.toCharset(str));
    }

    public static void skipFully(ReadableByteChannel readableByteChannel, long j3) throws IOException {
        if (j3 >= 0) {
            long skip = skip(readableByteChannel, j3);
            if (skip == j3) {
                return;
            }
            throw new EOFException("Bytes to skip: " + j3 + " actual: " + skip);
        }
        throw new IllegalArgumentException("Bytes to skip must not be negative: " + j3);
    }

    @Deprecated
    public static InputStream toInputStream(String str) {
        return toInputStream(str, Charset.defaultCharset());
    }

    public static void write(byte[] bArr, Writer writer, String str) throws IOException {
        write(bArr, writer, Charsets.toCharset(str));
    }

    public static void writeChunked(char[] cArr, Writer writer) throws IOException {
        if (cArr != null) {
            int length = cArr.length;
            int i3 = 0;
            while (length > 0) {
                int min = Math.min(length, 4096);
                writer.write(cArr, i3, min);
                length -= min;
                i3 += min;
            }
        }
    }

    public static BufferedOutputStream buffer(OutputStream outputStream) {
        outputStream.getClass();
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream);
    }

    @Deprecated
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, long j3, long j16, byte[] bArr) throws IOException {
        long j17 = 0;
        if (j3 > 0) {
            skipFully(inputStream, j3);
        }
        if (j16 == 0) {
            return 0L;
        }
        int length = bArr.length;
        int i3 = (j16 <= 0 || j16 >= ((long) length)) ? length : (int) j16;
        while (i3 > 0) {
            int read = inputStream.read(bArr, 0, i3);
            if (-1 == read) {
                break;
            }
            outputStream.write(bArr, 0, read);
            j17 += read;
            if (j16 > 0) {
                i3 = (int) Math.min(j16 - j17, length);
            }
        }
        return j17;
    }

    public static List<String> readLines(Reader reader) throws IOException {
        BufferedReader bufferedReader = toBufferedReader(reader);
        ArrayList arrayList = new ArrayList();
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            arrayList.add(readLine);
        }
        return arrayList;
    }

    public static long skip(ReadableByteChannel readableByteChannel, long j3) throws IOException {
        if (j3 >= 0) {
            ByteBuffer allocate = ByteBuffer.allocate((int) Math.min(j3, 2048L));
            long j16 = j3;
            while (j16 > 0) {
                allocate.position(0);
                allocate.limit((int) Math.min(j16, 2048L));
                int read = readableByteChannel.read(allocate);
                if (read == -1) {
                    break;
                }
                j16 -= read;
            }
            return j3 - j16;
        }
        throw new IllegalArgumentException("Skip count must be non-negative, actual: " + j3);
    }

    public static char[] toCharArray(InputStream inputStream, String str) throws IOException {
        return toCharArray(inputStream, Charsets.toCharset(str));
    }

    public static InputStream toInputStream(String str, Charset charset) {
        return new ByteArrayInputStream(str.getBytes(Charsets.toCharset(charset)));
    }

    public static void write(char[] cArr, Writer writer) throws IOException {
        if (cArr != null) {
            writer.write(cArr);
        }
    }

    @Deprecated
    public static void closeQuietly(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            closeQuietly(closeable);
        }
    }

    public static void copy(InputStream inputStream, Writer writer, String str) throws IOException {
        copy(inputStream, writer, Charsets.toCharset(str));
    }

    public static int read(InputStream inputStream, byte[] bArr) throws IOException {
        return read(inputStream, bArr, 0, bArr.length);
    }

    public static void readFully(InputStream inputStream, byte[] bArr) throws IOException {
        readFully(inputStream, bArr, 0, bArr.length);
    }

    public static char[] toCharArray(Reader reader) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        copy(reader, charArrayWriter);
        return charArrayWriter.toCharArray();
    }

    public static InputStream toInputStream(String str, String str2) throws IOException {
        return new ByteArrayInputStream(str.getBytes(Charsets.toCharset(str2)));
    }

    @Deprecated
    public static void write(char[] cArr, OutputStream outputStream) throws IOException {
        write(cArr, outputStream, Charset.defaultCharset());
    }

    public static BufferedOutputStream buffer(OutputStream outputStream, int i3) {
        outputStream.getClass();
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i3);
    }

    public static int copy(Reader reader, Writer writer) throws IOException {
        long copyLarge = copyLarge(reader, writer);
        if (copyLarge > TTL.MAX_VALUE) {
            return -1;
        }
        return (int) copyLarge;
    }

    public static int read(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        int remaining = byteBuffer.remaining();
        while (byteBuffer.remaining() > 0 && -1 != readableByteChannel.read(byteBuffer)) {
        }
        return remaining - byteBuffer.remaining();
    }

    public static byte[] readFully(InputStream inputStream, int i3) throws IOException {
        byte[] bArr = new byte[i3];
        readFully(inputStream, bArr, 0, i3);
        return bArr;
    }

    public static void skipFully(Reader reader, long j3) throws IOException {
        long skip = skip(reader, j3);
        if (skip == j3) {
            return;
        }
        throw new EOFException("Chars to skip: " + j3 + " actual: " + skip);
    }

    public static byte[] toByteArray(InputStream inputStream, long j3) throws IOException {
        if (j3 <= TTL.MAX_VALUE) {
            return toByteArray(inputStream, (int) j3);
        }
        throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + j3);
    }

    public static void write(char[] cArr, OutputStream outputStream, Charset charset) throws IOException {
        if (cArr != null) {
            outputStream.write(new String(cArr).getBytes(Charsets.toCharset(charset)));
        }
    }

    public static void writeLines(Collection<?> collection, String str, OutputStream outputStream, String str2) throws IOException {
        writeLines(collection, str, outputStream, Charsets.toCharset(str2));
    }

    @Deprecated
    public static void closeQuietly(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
        }
    }

    @Deprecated
    public static void copy(Reader reader, OutputStream outputStream) throws IOException {
        copy(reader, outputStream, Charset.defaultCharset());
    }

    public static String toString(InputStream inputStream, String str) throws IOException {
        return toString(inputStream, Charsets.toCharset(str));
    }

    public static void write(char[] cArr, OutputStream outputStream, String str) throws IOException {
        write(cArr, outputStream, Charsets.toCharset(str));
    }

    public static void writeLines(Collection<?> collection, String str, Writer writer) throws IOException {
        if (collection == null) {
            return;
        }
        if (str == null) {
            str = LINE_SEPARATOR;
        }
        for (Object obj : collection) {
            if (obj != null) {
                writer.write(obj.toString());
            }
            writer.write(str);
        }
    }

    public static BufferedInputStream buffer(InputStream inputStream) {
        inputStream.getClass();
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream);
    }

    @Deprecated
    public static void closeQuietly(Selector selector) {
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean contentEquals(Reader reader, Reader reader2) throws IOException {
        if (reader == reader2) {
            return true;
        }
        BufferedReader bufferedReader = toBufferedReader(reader);
        BufferedReader bufferedReader2 = toBufferedReader(reader2);
        for (int read = bufferedReader.read(); -1 != read; read = bufferedReader.read()) {
            if (read != bufferedReader2.read()) {
                return false;
            }
        }
        return bufferedReader2.read() == -1;
    }

    public static void copy(Reader reader, OutputStream outputStream, Charset charset) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, Charsets.toCharset(charset));
        copy(reader, outputStreamWriter);
        outputStreamWriter.flush();
    }

    public static void readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        int remaining = byteBuffer.remaining();
        int read = read(readableByteChannel, byteBuffer);
        if (read == remaining) {
            return;
        }
        throw new EOFException("Length to read: " + remaining + " actual: " + read);
    }

    public static byte[] toByteArray(InputStream inputStream, int i3) throws IOException {
        if (i3 < 0) {
            throw new IllegalArgumentException("Size must be equal or greater than zero: " + i3);
        }
        int i16 = 0;
        if (i3 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i3];
        while (i16 < i3) {
            int read = inputStream.read(bArr, i16, i3 - i16);
            if (read == -1) {
                break;
            }
            i16 += read;
        }
        if (i16 == i3) {
            return bArr;
        }
        throw new IOException("Unexpected read size. current: " + i16 + ", expected: " + i3);
    }

    public static String toString(Reader reader) throws IOException {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        try {
            copy(reader, stringBuilderWriter);
            String stringBuilderWriter2 = stringBuilderWriter.toString();
            stringBuilderWriter.close();
            return stringBuilderWriter2;
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    stringBuilderWriter.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }

    public static void write(CharSequence charSequence, Writer writer) throws IOException {
        if (charSequence != null) {
            write(charSequence.toString(), writer);
        }
    }

    @Deprecated
    public static void closeQuietly(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long copyLarge(Reader reader, Writer writer) throws IOException {
        return copyLarge(reader, writer, new char[4096]);
    }

    public static long skip(Reader reader, long j3) throws IOException {
        if (j3 >= 0) {
            if (SKIP_CHAR_BUFFER == null) {
                SKIP_CHAR_BUFFER = new char[2048];
            }
            long j16 = j3;
            while (j16 > 0) {
                long read = reader.read(SKIP_CHAR_BUFFER, 0, (int) Math.min(j16, 2048L));
                if (read < 0) {
                    break;
                }
                j16 -= read;
            }
            return j3 - j16;
        }
        throw new IllegalArgumentException("Skip count must be non-negative, actual: " + j3);
    }

    @Deprecated
    public static void write(CharSequence charSequence, OutputStream outputStream) throws IOException {
        write(charSequence, outputStream, Charset.defaultCharset());
    }

    public static BufferedInputStream buffer(InputStream inputStream, int i3) {
        inputStream.getClass();
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i3);
    }

    public static long copyLarge(Reader reader, Writer writer, char[] cArr) throws IOException {
        long j3 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j3;
            }
            writer.write(cArr, 0, read);
            j3 += read;
        }
    }

    public static void write(CharSequence charSequence, OutputStream outputStream, Charset charset) throws IOException {
        if (charSequence != null) {
            write(charSequence.toString(), outputStream, charset);
        }
    }

    public static void copy(Reader reader, OutputStream outputStream, String str) throws IOException {
        copy(reader, outputStream, Charsets.toCharset(str));
    }

    public static void write(CharSequence charSequence, OutputStream outputStream, String str) throws IOException {
        write(charSequence, outputStream, Charsets.toCharset(str));
    }

    public static long copyLarge(Reader reader, Writer writer, long j3, long j16) throws IOException {
        return copyLarge(reader, writer, j3, j16, new char[4096]);
    }

    @Deprecated
    public static byte[] toByteArray(Reader reader) throws IOException {
        return toByteArray(reader, Charset.defaultCharset());
    }

    public static void write(String str, Writer writer) throws IOException {
        if (str != null) {
            writer.write(str);
        }
    }

    public static long copyLarge(Reader reader, Writer writer, long j3, long j16, char[] cArr) throws IOException {
        long j17 = 0;
        if (j3 > 0) {
            skipFully(reader, j3);
        }
        if (j16 == 0) {
            return 0L;
        }
        int length = cArr.length;
        if (j16 > 0 && j16 < cArr.length) {
            length = (int) j16;
        }
        while (length > 0) {
            int read = reader.read(cArr, 0, length);
            if (-1 == read) {
                break;
            }
            writer.write(cArr, 0, read);
            j17 += read;
            if (j16 > 0) {
                length = (int) Math.min(j16 - j17, cArr.length);
            }
        }
        return j17;
    }

    public static byte[] toByteArray(Reader reader, Charset charset) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            copy(reader, byteArrayOutputStream, charset);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
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

    @Deprecated
    public static void write(String str, OutputStream outputStream) throws IOException {
        write(str, outputStream, Charset.defaultCharset());
    }

    @Deprecated
    public static String toString(URI uri) throws IOException {
        return toString(uri, Charset.defaultCharset());
    }

    public static void write(String str, OutputStream outputStream, Charset charset) throws IOException {
        if (str != null) {
            outputStream.write(str.getBytes(Charsets.toCharset(charset)));
        }
    }

    public static String toString(URI uri, Charset charset) throws IOException {
        return toString(uri.toURL(), Charsets.toCharset(charset));
    }

    public static void write(String str, OutputStream outputStream, String str2) throws IOException {
        write(str, outputStream, Charsets.toCharset(str2));
    }

    public static String toString(URI uri, String str) throws IOException {
        return toString(uri, Charsets.toCharset(str));
    }

    @Deprecated
    public static void write(StringBuffer stringBuffer, Writer writer) throws IOException {
        if (stringBuffer != null) {
            writer.write(stringBuffer.toString());
        }
    }

    @Deprecated
    public static String toString(URL url) throws IOException {
        return toString(url, Charset.defaultCharset());
    }

    @Deprecated
    public static void write(StringBuffer stringBuffer, OutputStream outputStream) throws IOException {
        write(stringBuffer, outputStream, (String) null);
    }

    public static String toString(URL url, Charset charset) throws IOException {
        InputStream openStream = url.openStream();
        try {
            String iOUtils = toString(openStream, charset);
            if (openStream != null) {
                openStream.close();
            }
            return iOUtils;
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                if (openStream != null) {
                    try {
                        openStream.close();
                    } catch (Throwable th7) {
                        th5.addSuppressed(th7);
                    }
                }
                throw th6;
            }
        }
    }

    @Deprecated
    public static void write(StringBuffer stringBuffer, OutputStream outputStream, String str) throws IOException {
        if (stringBuffer != null) {
            outputStream.write(stringBuffer.toString().getBytes(Charsets.toCharset(str)));
        }
    }

    public static byte[] toByteArray(Reader reader, String str) throws IOException {
        return toByteArray(reader, Charsets.toCharset(str));
    }

    @Deprecated
    public static byte[] toByteArray(String str) throws IOException {
        return str.getBytes(Charset.defaultCharset());
    }

    public static byte[] toByteArray(URI uri) throws IOException {
        return toByteArray(uri.toURL());
    }

    public static byte[] toByteArray(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        try {
            return toByteArray(openConnection);
        } finally {
            close(openConnection);
        }
    }

    public static String toString(URL url, String str) throws IOException {
        return toString(url, Charsets.toCharset(str));
    }

    @Deprecated
    public static String toString(byte[] bArr) throws IOException {
        return new String(bArr, Charset.defaultCharset());
    }

    public static byte[] toByteArray(URLConnection uRLConnection) throws IOException {
        InputStream inputStream = uRLConnection.getInputStream();
        try {
            byte[] byteArray = toByteArray(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
            return byteArray;
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th7) {
                        th5.addSuppressed(th7);
                    }
                }
                throw th6;
            }
        }
    }

    public static String toString(byte[] bArr, String str) throws IOException {
        return new String(bArr, Charsets.toCharset(str));
    }
}
