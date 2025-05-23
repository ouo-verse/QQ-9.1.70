package com.tencent.libra.util.apng.decode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class APNGParser {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class FormatException extends IOException {
        FormatException() {
            super("APNG Format error");
        }
    }

    public static boolean a(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception unused) {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            boolean b16 = b(new t01.e(fileInputStream));
            try {
                fileInputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            return b16;
        } catch (Exception unused2) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                    return false;
                } catch (IOException e17) {
                    e17.printStackTrace();
                    return false;
                }
            }
            return false;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean b(t01.d dVar) {
        h11.a aVar;
        if (dVar instanceof h11.a) {
            aVar = (h11.a) dVar;
        } else {
            aVar = new h11.a(dVar);
        }
        try {
            if (!aVar.b("\u0089PNG") || !aVar.b("\r\n\u001a\n")) {
                throw new FormatException();
            }
            while (aVar.available() > 0) {
                if (d(aVar) instanceof a) {
                    return true;
                }
            }
            return false;
        } catch (IOException e16) {
            if (!(e16 instanceof FormatException)) {
                e16.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public static List<b> c(h11.a aVar) throws IOException {
        if (aVar.b("\u0089PNG") && aVar.b("\r\n\u001a\n")) {
            ArrayList arrayList = new ArrayList();
            while (aVar.available() > 0) {
                arrayList.add(d(aVar));
            }
            return arrayList;
        }
        throw new FormatException();
    }

    private static b d(h11.a aVar) throws IOException {
        b bVar;
        int position = aVar.position();
        int d16 = aVar.d();
        int c16 = aVar.c();
        if (c16 == a.f118814g) {
            bVar = new a();
        } else if (c16 == c.f118821n) {
            bVar = new c();
        } else if (c16 == d.f118831f) {
            bVar = new d();
        } else if (c16 == e.f118833e) {
            bVar = new e();
        } else if (c16 == f.f118834e) {
            bVar = new f();
        } else if (c16 == g.f118835h) {
            bVar = new g();
        } else {
            bVar = new b();
        }
        bVar.f118820d = position;
        bVar.f118818b = c16;
        bVar.f118817a = d16;
        bVar.c(aVar);
        bVar.f118819c = aVar.d();
        return bVar;
    }
}
