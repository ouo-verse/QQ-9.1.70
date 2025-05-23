package com.tencent.mobileqq.unifiedebug;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.unifiedebug.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C8876a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f305796a;

        /* renamed from: b, reason: collision with root package name */
        public List<String> f305797b;

        /* renamed from: c, reason: collision with root package name */
        public String f305798c;

        public C8876a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public static C8876a a(String str) {
        return b(new String[]{str});
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0166, code lost:
    
        if (r7 != null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0168, code lost:
    
        r7.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x016b, code lost:
    
        r14 = r6;
        r6 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0144, code lost:
    
        if (r7 != null) goto L104;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01a5 A[Catch: IOException -> 0x01a1, TryCatch #14 {IOException -> 0x01a1, blocks: (B:115:0x019d, B:103:0x01a5, B:105:0x01aa), top: B:114:0x019d }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01aa A[Catch: IOException -> 0x01a1, TRY_LEAVE, TryCatch #14 {IOException -> 0x01a1, blocks: (B:115:0x019d, B:103:0x01a5, B:105:0x01aa), top: B:114:0x019d }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x019d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015a A[Catch: IOException -> 0x0156, TryCatch #2 {IOException -> 0x0156, blocks: (B:82:0x0152, B:69:0x015a, B:71:0x015f), top: B:81:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015f A[Catch: IOException -> 0x0156, TRY_LEAVE, TryCatch #2 {IOException -> 0x0156, blocks: (B:82:0x0152, B:69:0x015a, B:71:0x015f), top: B:81:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0152 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0138 A[Catch: IOException -> 0x0134, TryCatch #4 {IOException -> 0x0134, blocks: (B:98:0x0130, B:89:0x0138, B:91:0x013d), top: B:97:0x0130 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x013d A[Catch: IOException -> 0x0134, TRY_LEAVE, TryCatch #4 {IOException -> 0x0134, blocks: (B:98:0x0130, B:89:0x0138, B:91:0x013d), top: B:97:0x0130 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0130 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C8876a b(String[] strArr) {
        Process process;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        int i3;
        BufferedReader bufferedReader3;
        StringBuilder sb5;
        DataOutputStream dataOutputStream;
        int i16;
        int i17;
        C8876a c8876a = new C8876a();
        boolean z16 = false;
        if (strArr != null && strArr.length != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("UnifiedCommandUtil", 2, "execute command start : " + strArr);
            }
            ArrayList arrayList = new ArrayList();
            DataOutputStream dataOutputStream2 = null;
            int i18 = -1;
            try {
                try {
                    process = RuntimeMonitor.exec(Runtime.getRuntime(), "sh");
                } catch (IOException e16) {
                    e = e16;
                    process = null;
                    bufferedReader = null;
                } catch (Exception e17) {
                    e = e17;
                    process = null;
                    bufferedReader = null;
                } catch (Throwable th5) {
                    th = th5;
                    process = null;
                    bufferedReader = null;
                }
                try {
                    dataOutputStream = new DataOutputStream(process.getOutputStream());
                } catch (IOException e18) {
                    e = e18;
                    bufferedReader = null;
                    bufferedReader2 = bufferedReader;
                    i3 = i18;
                    bufferedReader3 = bufferedReader2;
                    e.printStackTrace();
                    if (dataOutputStream2 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                } catch (Exception e19) {
                    e = e19;
                    bufferedReader = null;
                    bufferedReader2 = bufferedReader;
                    i3 = i18;
                    bufferedReader3 = bufferedReader2;
                    e.printStackTrace();
                    if (dataOutputStream2 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    bufferedReader = null;
                    bufferedReader2 = bufferedReader;
                    if (dataOutputStream2 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                    if (process != null) {
                    }
                }
                try {
                    try {
                        for (String str : strArr) {
                            if (str != null) {
                                dataOutputStream.write(str.getBytes());
                                dataOutputStream.writeBytes("\n");
                                dataOutputStream.flush();
                            }
                        }
                        dataOutputStream.writeBytes("exit\n");
                        dataOutputStream.flush();
                        i18 = process.waitFor();
                        sb5 = new StringBuilder();
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                            try {
                                bufferedReader2 = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                                while (true) {
                                    try {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine == null) {
                                            break;
                                        }
                                        arrayList.add(readLine);
                                        if (QLog.isColorLevel()) {
                                            QLog.d("UnifiedCommandUtil", 2, "command line item : " + readLine);
                                        }
                                    } catch (IOException e26) {
                                        i17 = i18;
                                        bufferedReader3 = sb5;
                                        e = e26;
                                        dataOutputStream2 = dataOutputStream;
                                        i3 = i17;
                                        e.printStackTrace();
                                        if (dataOutputStream2 != null) {
                                        }
                                        if (bufferedReader != null) {
                                        }
                                        if (bufferedReader2 != null) {
                                        }
                                    } catch (Exception e27) {
                                        i16 = i18;
                                        bufferedReader3 = sb5;
                                        e = e27;
                                        dataOutputStream2 = dataOutputStream;
                                        i3 = i16;
                                        e.printStackTrace();
                                        if (dataOutputStream2 != null) {
                                        }
                                        if (bufferedReader != null) {
                                        }
                                        if (bufferedReader2 != null) {
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        dataOutputStream2 = dataOutputStream;
                                        if (dataOutputStream2 != null) {
                                            try {
                                                dataOutputStream2.close();
                                            } catch (IOException e28) {
                                                e28.printStackTrace();
                                                if (process != null) {
                                                    process.destroy();
                                                    throw th;
                                                }
                                                throw th;
                                            }
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (bufferedReader2 != null) {
                                            bufferedReader2.close();
                                        }
                                        if (process != null) {
                                        }
                                    }
                                }
                                while (true) {
                                    String readLine2 = bufferedReader2.readLine();
                                    if (readLine2 != null) {
                                        sb5.append(readLine2);
                                    } else {
                                        try {
                                            break;
                                        } catch (IOException e29) {
                                            e29.printStackTrace();
                                        }
                                    }
                                }
                                dataOutputStream.close();
                                bufferedReader.close();
                                bufferedReader2.close();
                                process.destroy();
                            } catch (IOException e36) {
                                i17 = i18;
                                bufferedReader3 = sb5;
                                e = e36;
                                bufferedReader2 = null;
                            } catch (Exception e37) {
                                i16 = i18;
                                bufferedReader3 = sb5;
                                e = e37;
                                bufferedReader2 = null;
                            } catch (Throwable th8) {
                                th = th8;
                                bufferedReader2 = null;
                            }
                        } catch (IOException e38) {
                            bufferedReader2 = null;
                            dataOutputStream2 = dataOutputStream;
                            i3 = i18;
                            bufferedReader3 = sb5;
                            e = e38;
                            bufferedReader = null;
                        } catch (Exception e39) {
                            bufferedReader2 = null;
                            dataOutputStream2 = dataOutputStream;
                            i3 = i18;
                            bufferedReader3 = sb5;
                            e = e39;
                            bufferedReader = null;
                        }
                    } catch (IOException e46) {
                        e = e46;
                        bufferedReader = null;
                        bufferedReader2 = null;
                        dataOutputStream2 = dataOutputStream;
                        i3 = i18;
                        bufferedReader3 = bufferedReader2;
                        e.printStackTrace();
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (IOException e47) {
                                e47.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                    } catch (Exception e48) {
                        e = e48;
                        bufferedReader = null;
                        bufferedReader2 = null;
                        dataOutputStream2 = dataOutputStream;
                        i3 = i18;
                        bufferedReader3 = bufferedReader2;
                        e.printStackTrace();
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (IOException e49) {
                                e49.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("UnifiedCommandUtil", 2, String.format(Locale.CHINA, "execute command end, errorMsg:%s, and status %d: ", sb5, Integer.valueOf(i18)));
                    }
                    if (i18 == 0) {
                        z16 = true;
                    }
                    c8876a.f305796a = z16;
                    c8876a.f305797b = arrayList;
                    if (sb5 != 0) {
                        c8876a.f305798c = sb5.toString();
                    }
                    return c8876a;
                } catch (Throwable th9) {
                    th = th9;
                    bufferedReader = null;
                    bufferedReader2 = null;
                }
            } catch (Throwable th10) {
                th = th10;
            }
        } else {
            c8876a.f305796a = false;
            return c8876a;
        }
    }
}
