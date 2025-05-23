package org.apache.commons.io;

import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class FileSystemUtils {
    private static final String DF;
    private static final int INIT_PROBLEM = -1;
    private static final FileSystemUtils INSTANCE = new FileSystemUtils();
    private static final int OS;
    private static final int OTHER = 0;
    private static final int POSIX_UNIX = 3;
    private static final int UNIX = 2;
    private static final int WINDOWS = 1;

    static {
        int i3;
        String property;
        String str = "df";
        try {
            property = System.getProperty("os.name");
        } catch (Exception unused) {
            i3 = -1;
        }
        if (property != null) {
            String lowerCase = property.toLowerCase(Locale.ENGLISH);
            if (lowerCase.contains("windows")) {
                i3 = 1;
            } else {
                if (!lowerCase.contains("linux") && !lowerCase.contains("mpe/ix") && !lowerCase.contains(ResourceAttributes.OsTypeValues.FREEBSD) && !lowerCase.contains(ResourceAttributes.OsTypeValues.OPENBSD) && !lowerCase.contains("irix") && !lowerCase.contains("digital unix") && !lowerCase.contains(SemanticAttributes.NetTransportValues.UNIX) && !lowerCase.contains("mac os x")) {
                    if (!lowerCase.contains("sun os") && !lowerCase.contains("sunos") && !lowerCase.contains(ResourceAttributes.OsTypeValues.SOLARIS)) {
                        if (!lowerCase.contains("hp-ux") && !lowerCase.contains(ResourceAttributes.OsTypeValues.AIX)) {
                            i3 = 0;
                        }
                        i3 = 3;
                    }
                    str = "/usr/xpg4/bin/df";
                    i3 = 3;
                }
                i3 = 2;
            }
            OS = i3;
            DF = str;
            return;
        }
        throw new IOException("os.name not found");
    }

    @Deprecated
    public static long freeSpace(String str) throws IOException {
        return INSTANCE.freeSpaceOS(str, OS, false, -1L);
    }

    @Deprecated
    public static long freeSpaceKb(String str) throws IOException {
        return freeSpaceKb(str, -1L);
    }

    long freeSpaceOS(String str, int i3, boolean z16, long j3) throws IOException {
        if (str != null) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            return freeSpaceUnix(str, z16, true, j3);
                        }
                        throw new IllegalStateException("Exception caught when determining operating system");
                    }
                    return freeSpaceUnix(str, z16, false, j3);
                }
                long freeSpaceWindows = freeSpaceWindows(str, j3);
                if (z16) {
                    return freeSpaceWindows / 1024;
                }
                return freeSpaceWindows;
            }
            throw new IllegalStateException("Unsupported operating system");
        }
        throw new IllegalArgumentException("Path must not be null");
    }

    long freeSpaceUnix(String str, boolean z16, boolean z17, long j3) throws IOException {
        String[] strArr;
        if (!str.isEmpty()) {
            String str2 = "-";
            if (z16) {
                str2 = "-k";
            }
            if (z17) {
                str2 = str2 + "P";
            }
            if (str2.length() > 1) {
                strArr = new String[]{DF, str2, str};
            } else {
                strArr = new String[]{DF, str};
            }
            List<String> performCommand = performCommand(strArr, 3, j3);
            if (performCommand.size() >= 2) {
                StringTokenizer stringTokenizer = new StringTokenizer(performCommand.get(1), " ");
                if (stringTokenizer.countTokens() < 4) {
                    if (stringTokenizer.countTokens() == 1 && performCommand.size() >= 3) {
                        stringTokenizer = new StringTokenizer(performCommand.get(2), " ");
                    } else {
                        throw new IOException("Command line '" + DF + "' did not return data as expected for path '" + str + "'- check path is valid");
                    }
                } else {
                    stringTokenizer.nextToken();
                }
                stringTokenizer.nextToken();
                stringTokenizer.nextToken();
                return parseBytes(stringTokenizer.nextToken(), str);
            }
            throw new IOException("Command line '" + DF + "' did not return info as expected for path '" + str + "'- response was " + performCommand);
        }
        throw new IllegalArgumentException("Path must not be empty");
    }

    long freeSpaceWindows(String str, long j3) throws IOException {
        String normalize = FilenameUtils.normalize(str, false);
        if (normalize != null) {
            if (normalize.length() > 0 && normalize.charAt(0) != '\"') {
                normalize = "\"" + normalize + "\"";
            }
            List<String> performCommand = performCommand(new String[]{"cmd.exe", "/C", "dir /a /-c " + normalize}, Integer.MAX_VALUE, j3);
            for (int size = performCommand.size() - 1; size >= 0; size--) {
                String str2 = performCommand.get(size);
                if (str2.length() > 0) {
                    return parseDir(str2, normalize);
                }
            }
            throw new IOException("Command line 'dir /-c' did not return any info for path '" + normalize + "'");
        }
        throw new IllegalArgumentException(str);
    }

    Process openProcess(String[] strArr) throws IOException {
        return RuntimeMonitor.exec(Runtime.getRuntime(), strArr);
    }

    long parseBytes(String str, String str2) throws IOException {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong >= 0) {
                return parseLong;
            }
            throw new IOException("Command line '" + DF + "' did not find free space in response for path '" + str2 + "'- check path is valid");
        } catch (NumberFormatException e16) {
            throw new IOException("Command line '" + DF + "' did not return numeric data as expected for path '" + str2 + "'- check path is valid", e16);
        }
    }

    long parseDir(String str, String str2) throws IOException {
        int i3;
        int i16;
        int i17;
        int length = str.length();
        while (true) {
            length--;
            i3 = 0;
            if (length >= 0) {
                if (Character.isDigit(str.charAt(length))) {
                    i16 = length + 1;
                    break;
                }
            } else {
                i16 = 0;
                break;
            }
        }
        while (true) {
            if (length >= 0) {
                char charAt = str.charAt(length);
                if (!Character.isDigit(charAt) && charAt != ',' && charAt != '.') {
                    i17 = length + 1;
                    break;
                }
                length--;
            } else {
                i17 = 0;
                break;
            }
        }
        if (length >= 0) {
            StringBuilder sb5 = new StringBuilder(str.substring(i17, i16));
            while (i3 < sb5.length()) {
                if (sb5.charAt(i3) == ',' || sb5.charAt(i3) == '.') {
                    sb5.deleteCharAt(i3);
                    i3--;
                }
                i3++;
            }
            return parseBytes(sb5.toString(), str2);
        }
        throw new IOException("Command line 'dir /-c' did not return valid info for path '" + str2 + "'");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0130  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    List<String> performCommand(String[] strArr, int i3, long j3) throws IOException {
        Process process;
        OutputStream outputStream;
        InputStream inputStream;
        InputStream inputStream2;
        ?? r75;
        ?? r76;
        Thread start;
        ArrayList arrayList = new ArrayList(20);
        InputStream inputStream3 = null;
        try {
            start = ThreadMonitor.start(j3);
            process = openProcess(strArr);
        } catch (InterruptedException e16) {
            e = e16;
            inputStream = null;
            outputStream = null;
            inputStream2 = null;
            r75 = 0;
        } catch (Throwable th5) {
            th = th5;
            process = null;
            outputStream = null;
        }
        try {
            inputStream = process.getInputStream();
        } catch (InterruptedException e17) {
            e = e17;
            inputStream = null;
            outputStream = null;
        } catch (Throwable th6) {
            th = th6;
            outputStream = null;
            inputStream2 = outputStream;
            r76 = inputStream2;
            IOUtils.closeQuietly(inputStream3);
            IOUtils.closeQuietly(outputStream);
            IOUtils.closeQuietly(inputStream2);
            IOUtils.closeQuietly((Reader) r76);
            if (process != null) {
            }
            throw th;
        }
        try {
            outputStream = process.getOutputStream();
            try {
                inputStream2 = process.getErrorStream();
                try {
                    r75 = new BufferedReader(new InputStreamReader(inputStream, Charset.defaultCharset()));
                } catch (InterruptedException e18) {
                    e = e18;
                    r75 = 0;
                } catch (Throwable th7) {
                    th = th7;
                    r75 = 0;
                }
            } catch (InterruptedException e19) {
                e = e19;
                inputStream2 = null;
                r75 = inputStream2;
                inputStream3 = process;
                r75 = r75;
                try {
                    throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr) + " timeout=" + j3, e);
                } catch (Throwable th8) {
                    th = th8;
                    process = inputStream3;
                    inputStream3 = inputStream;
                    r76 = r75;
                    IOUtils.closeQuietly(inputStream3);
                    IOUtils.closeQuietly(outputStream);
                    IOUtils.closeQuietly(inputStream2);
                    IOUtils.closeQuietly((Reader) r76);
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            } catch (Throwable th9) {
                th = th9;
                inputStream2 = null;
                r75 = inputStream2;
                inputStream3 = inputStream;
                r76 = r75;
                IOUtils.closeQuietly(inputStream3);
                IOUtils.closeQuietly(outputStream);
                IOUtils.closeQuietly(inputStream2);
                IOUtils.closeQuietly((Reader) r76);
                if (process != null) {
                }
                throw th;
            }
            try {
                for (String readLine = r75.readLine(); readLine != null && arrayList.size() < i3; readLine = r75.readLine()) {
                    arrayList.add(readLine.toLowerCase(Locale.ENGLISH).trim());
                }
                process.waitFor();
                ThreadMonitor.stop(start);
                if (process.exitValue() == 0) {
                    if (!arrayList.isEmpty()) {
                        r75.close();
                        inputStream.close();
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                                outputStream = null;
                            } catch (InterruptedException e26) {
                                e = e26;
                                inputStream = null;
                                r75 = 0;
                                inputStream3 = process;
                                r75 = r75;
                                throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr) + " timeout=" + j3, e);
                            } catch (Throwable th10) {
                                th = th10;
                                r76 = 0;
                                IOUtils.closeQuietly(inputStream3);
                                IOUtils.closeQuietly(outputStream);
                                IOUtils.closeQuietly(inputStream2);
                                IOUtils.closeQuietly((Reader) r76);
                                if (process != null) {
                                }
                                throw th;
                            }
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                            inputStream2 = null;
                        }
                        IOUtils.closeQuietly((InputStream) null);
                        IOUtils.closeQuietly(outputStream);
                        IOUtils.closeQuietly(inputStream2);
                        IOUtils.closeQuietly((Reader) null);
                        process.destroy();
                        return arrayList;
                    }
                    throw new IOException("Command line did not return any info for command " + Arrays.asList(strArr));
                }
                throw new IOException("Command line returned OS error code '" + process.exitValue() + "' for command " + Arrays.asList(strArr));
            } catch (InterruptedException e27) {
                e = e27;
            } catch (Throwable th11) {
                th = th11;
                inputStream3 = inputStream;
                r76 = r75;
                IOUtils.closeQuietly(inputStream3);
                IOUtils.closeQuietly(outputStream);
                IOUtils.closeQuietly(inputStream2);
                IOUtils.closeQuietly((Reader) r76);
                if (process != null) {
                }
                throw th;
            }
        } catch (InterruptedException e28) {
            e = e28;
            outputStream = null;
            inputStream2 = outputStream;
            r75 = inputStream2;
            inputStream3 = process;
            r75 = r75;
            throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr) + " timeout=" + j3, e);
        } catch (Throwable th12) {
            th = th12;
            outputStream = null;
            inputStream2 = null;
        }
    }

    @Deprecated
    public static long freeSpaceKb(String str, long j3) throws IOException {
        return INSTANCE.freeSpaceOS(str, OS, true, j3);
    }

    @Deprecated
    public static long freeSpaceKb() throws IOException {
        return freeSpaceKb(-1L);
    }

    @Deprecated
    public static long freeSpaceKb(long j3) throws IOException {
        return freeSpaceKb(new File(".").getAbsolutePath(), j3);
    }
}
