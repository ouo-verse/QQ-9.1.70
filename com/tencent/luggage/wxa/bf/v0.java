package com.tencent.luggage.wxa.bf;

import com.tencent.mobileqq.app.face.FaceConstant;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class v0 extends d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f122593a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.rc.l.values().length];
            f122593a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f122593a[com.tencent.luggage.wxa.rc.l.ERR_PARENT_DIR_NOT_EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f122593a[com.tencent.luggage.wxa.rc.l.ERR_FS_NOT_MOUNTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f122593a[com.tencent.luggage.wxa.rc.l.RET_ALREADY_EXISTS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f122593a[com.tencent.luggage.wxa.rc.l.ERR_SYMLINK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f122593a[com.tencent.luggage.wxa.rc.l.ERR_EXCEED_DIRECTORY_MAX_SIZE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f122593a[com.tencent.luggage.wxa.rc.l.OK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.tencent.luggage.wxa.bf.d
    public f a(com.tencent.luggage.wxa.xd.d dVar, String str, JSONObject jSONObject) {
        com.tencent.luggage.wxa.rc.l writeFile;
        String optString = jSONObject.optString("destPath");
        Locale locale = Locale.US;
        String format = String.format(locale, "fail no such file or directory, copyFile \"%s\" -> \"%s\"", str, optString);
        String format2 = String.format(locale, "fail permission denied, copyFile \"%s\" -> \"%s\"", str, optString);
        com.tencent.luggage.wxa.cp.v absoluteFile = dVar.getFileSystem().getAbsoluteFile(str);
        boolean canSaveToLocal = dVar.getFileSystem().canSaveToLocal(str);
        if (absoluteFile != null && absoluteFile.e() && absoluteFile.q()) {
            if (com.tencent.luggage.wxa.rc.m.a(absoluteFile)) {
                return new f("fail \"%s\" not a regular file", str);
            }
            writeFile = dVar.getFileSystem().copyTo(optString, absoluteFile, false);
        } else {
            if (!canSaveToLocal) {
                return new f(format2, new Object[0]);
            }
            com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
            dVar.getFileSystem().readFile(str, iVar);
            if (iVar.f141499a == null) {
                return new f(format, new Object[0]);
            }
            com.tencent.luggage.wxa.h6.a aVar = new com.tencent.luggage.wxa.h6.a((ByteBuffer) iVar.f141499a);
            writeFile = dVar.getFileSystem().writeFile(optString, aVar, false);
            com.tencent.luggage.wxa.tn.w0.a((Closeable) aVar);
        }
        switch (a.f122593a[writeFile.ordinal()]) {
            case 1:
                return new f(format2, new Object[0]);
            case 2:
                return new f(format, new Object[0]);
            case 3:
                return new f("fail sdcard not mounted", new Object[0]);
            case 4:
                return new f("fail illegal operation on a directory, open \"%s\"", optString);
            case 5:
                return new f("fail \"%s\" is not a regular file", optString);
            case 6:
                return new f("fail the maximum size of the file storage limit is exceeded", new Object[0]);
            case 7:
                return new f(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]);
            default:
                return new f("fail " + writeFile.name(), new Object[0]);
        }
    }

    @Override // com.tencent.luggage.wxa.bf.d
    public String a(JSONObject jSONObject) {
        return jSONObject.optString("srcPath");
    }
}
