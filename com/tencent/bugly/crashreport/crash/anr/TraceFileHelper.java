package com.tencent.bugly.crashreport.crash.anr;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.bugly.proguard.av;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TraceFileHelper {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f97906a;

        /* renamed from: b, reason: collision with root package name */
        public String f97907b;

        /* renamed from: c, reason: collision with root package name */
        public long f97908c;

        /* renamed from: d, reason: collision with root package name */
        public Map<String, String[]> f97909d;
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        boolean a(long j3);

        boolean a(long j3, long j16, String str);

        boolean a(String str, int i3, String str2, String str3);
    }

    private static Object[] a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            for (Pattern pattern : patternArr) {
                if (pattern.matcher(readLine).matches()) {
                    return new Object[]{pattern, readLine};
                }
            }
        }
    }

    private static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    public static a readFirstDumpInfo(String str, final boolean z16) {
        if (str == null) {
            av.e("path:%s", str);
            return null;
        }
        final a aVar = new a();
        readTraceFile(str, new b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.2
            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(String str2, int i3, String str3, String str4) {
                av.c("new thread %s", str2);
                a aVar2 = a.this;
                if (aVar2.f97909d == null) {
                    aVar2.f97909d = new HashMap();
                }
                a.this.f97909d.put(str2, new String[]{str3, str4, String.valueOf(i3)});
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j3, long j16, String str2) {
                av.c("new process %s", str2);
                a aVar2 = a.this;
                aVar2.f97906a = j3;
                aVar2.f97907b = str2;
                aVar2.f97908c = j16;
                return z16;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j3) {
                av.c("process end %d", Long.valueOf(j3));
                return false;
            }
        });
        if (aVar.f97906a > 0 && aVar.f97908c > 0 && aVar.f97907b != null) {
            return aVar;
        }
        av.e("first dump error %s", aVar.f97906a + " " + aVar.f97908c + " " + aVar.f97907b);
        return null;
    }

    public static a readTargetDumpInfo(final String str, String str2, final boolean z16) {
        if (str != null && str2 != null) {
            final a aVar = new a();
            readTraceFile(str2, new b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.1
                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(String str3, int i3, String str4, String str5) {
                    av.c("new thread %s", str3);
                    a aVar2 = a.this;
                    if (aVar2.f97906a > 0 && aVar2.f97908c > 0 && aVar2.f97907b != null) {
                        if (aVar2.f97909d == null) {
                            aVar2.f97909d = new HashMap();
                        }
                        a.this.f97909d.put(str3, new String[]{str4, str5, String.valueOf(i3)});
                    }
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(long j3, long j16, String str3) {
                    av.c("new process %s", str3);
                    if (!str3.equals(str)) {
                        return true;
                    }
                    a aVar2 = a.this;
                    aVar2.f97906a = j3;
                    aVar2.f97907b = str3;
                    aVar2.f97908c = j16;
                    return z16;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(long j3) {
                    av.c("process end %d", Long.valueOf(j3));
                    a aVar2 = a.this;
                    return aVar2.f97906a <= 0 || aVar2.f97908c <= 0 || aVar2.f97907b == null;
                }
            });
            if (aVar.f97906a > 0 && aVar.f97908c > 0 && aVar.f97907b != null) {
                return aVar;
            }
        }
        return null;
    }

    public static void readTraceFile(String str, b bVar) {
        Throwable th5;
        if (str != null && bVar != null) {
            File file = new File(str);
            if (!file.exists()) {
                return;
            }
            file.lastModified();
            file.length();
            int i3 = 0;
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    try {
                        Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                        Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                        Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                        Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                        while (true) {
                            Pattern[] patternArr = new Pattern[1];
                            patternArr[i3] = compile;
                            Object[] a16 = a(bufferedReader2, patternArr);
                            if (a16 != null) {
                                Pattern[] patternArr2 = new Pattern[1];
                                patternArr2[i3] = compile3;
                                Object[] a17 = a(bufferedReader2, patternArr2);
                                if (a17 == null) {
                                    av.d("Failed to find process name.", new Object[i3]);
                                    try {
                                        bufferedReader2.close();
                                        return;
                                    } catch (IOException e16) {
                                        if (!av.a(e16)) {
                                            e16.printStackTrace();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                String[] split = a16[1].toString().split("\\s");
                                long parseLong = Long.parseLong(split[2]);
                                long time = simpleDateFormat.parse(split[4] + " " + split[5]).getTime();
                                Matcher matcher = compile3.matcher(a17[1].toString());
                                matcher.find();
                                matcher.group(1);
                                SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                                if (!bVar.a(parseLong, time, matcher.group(1))) {
                                    try {
                                        bufferedReader2.close();
                                        return;
                                    } catch (IOException e17) {
                                        if (!av.a(e17)) {
                                            e17.printStackTrace();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                while (true) {
                                    Object[] a18 = a(bufferedReader2, compile4, compile2);
                                    if (a18 == null) {
                                        break;
                                    }
                                    if (a18[0] == compile4) {
                                        String obj = a18[1].toString();
                                        Matcher matcher2 = Pattern.compile("\".+\"").matcher(obj);
                                        matcher2.find();
                                        String group = matcher2.group();
                                        String substring = group.substring(1, group.length() - 1);
                                        obj.contains("NATIVE");
                                        Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(obj);
                                        matcher3.find();
                                        String group2 = matcher3.group();
                                        bVar.a(substring, Integer.parseInt(group2.substring(group2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1)), a(bufferedReader2), b(bufferedReader2));
                                    } else if (!bVar.a(Long.parseLong(a18[1].toString().split("\\s")[2]))) {
                                        try {
                                            bufferedReader2.close();
                                            return;
                                        } catch (IOException e18) {
                                            if (!av.a(e18)) {
                                                e18.printStackTrace();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                simpleDateFormat = simpleDateFormat2;
                                i3 = 0;
                            } else {
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (IOException e19) {
                                    if (!av.a(e19)) {
                                        e19.printStackTrace();
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                    } catch (Exception e26) {
                        e = e26;
                        bufferedReader = bufferedReader2;
                        if (!av.a(e)) {
                            e.printStackTrace();
                        }
                        av.d("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e27) {
                                if (!av.a(e27)) {
                                    e27.printStackTrace();
                                }
                            }
                        }
                    } catch (Throwable th6) {
                        th5 = th6;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                throw th5;
                            } catch (IOException e28) {
                                if (!av.a(e28)) {
                                    e28.printStackTrace();
                                    throw th5;
                                }
                                throw th5;
                            }
                        }
                        throw th5;
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                }
            } catch (Exception e29) {
                e = e29;
            }
        }
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < 3; i3++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }
}
