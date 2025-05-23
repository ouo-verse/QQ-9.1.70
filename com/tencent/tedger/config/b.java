package com.tencent.tedger.config;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tedgecontext.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f375143a;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements FilenameFilter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) str)).booleanValue();
            }
            return str.endsWith(".version");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18349);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f375143a = "TEdge_tab_module_";
        }
    }

    public static boolean a(String str, c cVar, com.tencent.tedgecontext.a aVar) {
        File[] listFiles;
        byte[] bArr;
        if (!TextUtils.isEmpty(str) && cVar != null && aVar != null) {
            File file = new File(str);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles(new a())) != null && listFiles.length != 0) {
                BufferedReader bufferedReader = null;
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(listFiles[0]));
                        try {
                            String readLine = bufferedReader2.readLine();
                            try {
                                bufferedReader2.close();
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                            if (TextUtils.isEmpty(readLine)) {
                                return false;
                            }
                            List<com.tencent.tedger.outapi.beans.a> e17 = aVar.h().e(f375143a + aVar.p(), null, true);
                            if (e17 != null && e17.size() > 0 && (bArr = e17.get(0).f375274b) != null) {
                                String str2 = new String(bArr);
                                if (!TextUtils.isEmpty(str2) && str2.equals(readLine)) {
                                    return false;
                                }
                            }
                            ArrayList arrayList = new ArrayList();
                            com.tencent.tedger.outapi.beans.a aVar2 = new com.tencent.tedger.outapi.beans.a();
                            aVar2.f375274b = readLine.getBytes();
                            aVar2.f375273a = "version";
                            aVar2.f375275c = System.currentTimeMillis();
                            arrayList.add(aVar2);
                            aVar.h().d(f375143a + aVar.p(), null, null);
                            aVar.h().b(f375143a + aVar.p(), arrayList);
                            return true;
                        } catch (IOException e18) {
                            e = e18;
                            bufferedReader = bufferedReader2;
                            cVar.f("EdgeModelUtils", 17, "checkModelVersion have error: " + e);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e19) {
                                    e19.printStackTrace();
                                }
                            }
                            return false;
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e26) {
                                    e26.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (IOException e27) {
                    e = e27;
                }
            }
        }
        return false;
    }
}
