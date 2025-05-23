package com.tencent.luggage.wxa.bf;

import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c1 extends d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f122532a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.rc.l.values().length];
            f122532a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f122532a[com.tencent.luggage.wxa.rc.l.ERR_PARENT_DIR_NOT_EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f122532a[com.tencent.luggage.wxa.rc.l.ERR_FS_NOT_MOUNTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f122532a[com.tencent.luggage.wxa.rc.l.OK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.tencent.luggage.wxa.bf.d
    public f a(com.tencent.luggage.wxa.xd.d dVar, String str, JSONObject jSONObject) {
        com.tencent.luggage.wxa.rc.r fileSystem = dVar.getFileSystem();
        if (fileSystem == null) {
            return new f("fail:internal error", new Object[0]);
        }
        String optString = jSONObject.optString("newPath");
        Locale locale = Locale.US;
        String format = String.format(locale, "fail no such file or directory, rename \"%s\" -> \"%s\"", str, optString);
        String format2 = String.format(locale, "fail permission denied, rename \"%s\" -> \"%s\"", str, optString);
        if (!fileSystem.canRenameFile(str)) {
            return new f(format2, new Object[0]);
        }
        com.tencent.luggage.wxa.cp.v absoluteFile = dVar.getFileSystem().getAbsoluteFile(str, true);
        if (absoluteFile != null && absoluteFile.e()) {
            if (com.tencent.luggage.wxa.rc.m.a(absoluteFile)) {
                return new f("fail \"%s\" not a regular file", str);
            }
            com.tencent.luggage.wxa.rc.l copyTo = dVar.getFileSystem().copyTo(optString, absoluteFile, true);
            int i3 = a.f122532a[copyTo.ordinal()];
            if (i3 == 1) {
                return new f(format2, new Object[0]);
            }
            if (i3 == 2) {
                return new f(format, new Object[0]);
            }
            if (i3 == 3) {
                return new f("fail sdcard not mounted", new Object[0]);
            }
            if (i3 != 4) {
                return new f("fail " + copyTo.name(), new Object[0]);
            }
            return new f(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]);
        }
        return new f(format, new Object[0]);
    }

    @Override // com.tencent.luggage.wxa.bf.d
    public String a(JSONObject jSONObject) {
        return jSONObject.optString("oldPath");
    }
}
