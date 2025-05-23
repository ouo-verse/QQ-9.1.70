package com.tencent.luggage.wxa.bf;

import com.tencent.luggage.wxa.xd.o;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l0 extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 51;
    public static final String NAME = "saveFile";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f122545a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f122546b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f122547c;

        public a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
            this.f122545a = dVar;
            this.f122546b = jSONObject;
            this.f122547c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f122545a.isRunning()) {
                return;
            }
            o.a a16 = l0.a(this.f122545a, this.f122546b);
            com.tencent.luggage.wxa.af.c cVar = a16.f144874c;
            if (cVar != null) {
                this.f122545a.a(this.f122547c, l0.this.makeReturnJson(cVar, a16.f144872a));
            } else {
                this.f122545a.a(this.f122547c, l0.this.makeReturnJson(a16.f144873b, a16.f144872a));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f122549a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.rc.l.values().length];
            f122549a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f122549a[com.tencent.luggage.wxa.rc.l.ERR_PARENT_DIR_NOT_EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f122549a[com.tencent.luggage.wxa.rc.l.ERR_IS_DIRECTORY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f122549a[com.tencent.luggage.wxa.rc.l.ERR_EXCEED_DIRECTORY_MAX_SIZE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f122549a[com.tencent.luggage.wxa.rc.l.ERR_NAME_TOO_LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f122549a[com.tencent.luggage.wxa.rc.l.OK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static o.a a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        String optString = jSONObject.optString("tempFilePath");
        String optString2 = jSONObject.optString("filePath");
        if (com.tencent.luggage.wxa.tn.w0.c(optString)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSaveFile", "temp localId is null or nil");
            return new o.a(com.tencent.luggage.wxa.af.d.E, new Object[0]);
        }
        com.tencent.luggage.wxa.cp.v absoluteFile = dVar.getFileSystem().getAbsoluteFile(optString);
        if (absoluteFile != null && absoluteFile.e()) {
            com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
            com.tencent.luggage.wxa.af.c a16 = a(dVar, absoluteFile, optString2, iVar);
            HashMap hashMap = new HashMap();
            if (FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS.equals(a16.f121278b)) {
                hashMap.put("savedFilePath", iVar.f141499a);
            }
            return new o.a(a16, new Object[0]).a(hashMap);
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSaveFile", "fail tempFilePath file not exist");
        return new o.a(com.tencent.luggage.wxa.af.d.E, new Object[0]);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.bf.b.f122521b.execute(new a(dVar, jSONObject, i3));
    }

    public static com.tencent.luggage.wxa.af.c a(com.tencent.luggage.wxa.xd.d dVar, com.tencent.luggage.wxa.cp.v vVar, String str, com.tencent.luggage.wxa.tk.i iVar) {
        boolean z16;
        if (vVar != null && vVar.e()) {
            com.tencent.luggage.wxa.rc.l isdir = dVar.getFileSystem().isdir(str);
            if (isdir != com.tencent.luggage.wxa.rc.l.OK) {
                try {
                    com.tencent.luggage.wxa.tk.i iVar2 = new com.tencent.luggage.wxa.tk.i();
                    com.tencent.luggage.wxa.rc.l saveFile = dVar.getFileSystem().saveFile(vVar, str, iVar2);
                    if (iVar != null) {
                        iVar.f141499a = iVar2.f141499a;
                    }
                    z16 = false;
                    isdir = saveFile;
                } catch (Exception e16) {
                    return new com.tencent.luggage.wxa.af.c(-1, "fail:saveFile exception: " + e16.toString());
                }
            } else {
                z16 = true;
            }
            switch (b.f122549a[isdir.ordinal()]) {
                case 1:
                    return com.tencent.luggage.wxa.af.d.f121283e;
                case 2:
                    return a(com.tencent.luggage.wxa.af.d.f121280b, str);
                case 3:
                    return a(com.tencent.luggage.wxa.af.d.f121297s, str);
                case 4:
                    return com.tencent.luggage.wxa.af.d.f121291m;
                case 5:
                    return com.tencent.luggage.wxa.af.d.f121288j;
                case 6:
                    if (z16) {
                        return a(com.tencent.luggage.wxa.af.d.f121297s, str);
                    }
                    return com.tencent.luggage.wxa.af.e.f121305a;
                default:
                    return new com.tencent.luggage.wxa.af.c(-1, "fail " + isdir.name());
            }
        }
        return com.tencent.luggage.wxa.af.d.f121280b;
    }

    public static com.tencent.luggage.wxa.af.c a(com.tencent.luggage.wxa.af.c cVar, String str) {
        return new com.tencent.luggage.wxa.af.c(cVar.f121277a, String.format("%s, \"%s\"", cVar.f121278b, str));
    }
}
