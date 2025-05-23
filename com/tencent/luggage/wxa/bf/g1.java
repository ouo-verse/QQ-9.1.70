package com.tencent.luggage.wxa.bf;

import com.tencent.mobileqq.app.face.FaceConstant;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g1 extends d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f122543a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.rc.l.values().length];
            f122543a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f122543a[com.tencent.luggage.wxa.rc.l.ERR_IS_FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f122543a[com.tencent.luggage.wxa.rc.l.ERR_OP_FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f122543a[com.tencent.luggage.wxa.rc.l.ERR_PARENT_DIR_NOT_EXISTS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f122543a[com.tencent.luggage.wxa.rc.l.RET_ALREADY_EXISTS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f122543a[com.tencent.luggage.wxa.rc.l.ERR_EXCEED_DIRECTORY_MAX_SIZE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f122543a[com.tencent.luggage.wxa.rc.l.ERR_BAD_ZIP_FILE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f122543a[com.tencent.luggage.wxa.rc.l.ERR_WRITE_ZIP_ENTRY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f122543a[com.tencent.luggage.wxa.rc.l.OK.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00b4  */
    @Override // com.tencent.luggage.wxa.bf.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f a(com.tencent.luggage.wxa.xd.d dVar, String str, JSONObject jSONObject) {
        boolean z16;
        String optString = jSONObject.optString("targetDirectory", "");
        int i3 = a.f122543a[dVar.getFileSystem().isdir(optString).ordinal()];
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            com.tencent.luggage.wxa.cp.v absoluteFile = dVar.getFileSystem().getAbsoluteFile(str);
            if (absoluteFile != null && absoluteFile.e()) {
                if (absoluteFile.p() || com.tencent.luggage.wxa.rc.m.a(absoluteFile)) {
                    return new f("fail permission denied, open \"%s\"", str);
                }
                z16 = false;
            } else {
                if (dVar.getFileSystem().access(str) == com.tencent.luggage.wxa.rc.l.OK) {
                    com.tencent.luggage.wxa.cp.v allocTempFile = dVar.getFileSystem().allocTempFile(URLEncoder.encode(str));
                    if (allocTempFile != null) {
                        com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
                        dVar.getFileSystem().readFile(str, iVar);
                        try {
                            Channels.newChannel(com.tencent.luggage.wxa.cp.x.b(allocTempFile)).write((ByteBuffer) iVar.f141499a);
                            absoluteFile = new com.tencent.luggage.wxa.cp.v(allocTempFile.g());
                            z16 = true;
                        } catch (IOException e16) {
                            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.FileSystem.UnitUnzip", "copy ByteBuffer failed e = %s", e16);
                            absoluteFile = null;
                        }
                        if (absoluteFile == null) {
                            return new f("fail no such file \"%s\"", str);
                        }
                    } else {
                        return new f("fail allocTempFile failed", new Object[0]);
                    }
                }
                z16 = false;
                if (absoluteFile == null) {
                }
            }
            try {
                com.tencent.luggage.wxa.rc.l unzip = dVar.getFileSystem().unzip(optString, absoluteFile);
                if (z16) {
                    com.tencent.luggage.wxa.cp.x.c(absoluteFile.g());
                }
                int i16 = a.f122543a[unzip.ordinal()];
                if (i16 != 1) {
                    switch (i16) {
                        case 4:
                            return new f("fail no such file or directory, open \"%s\"", str);
                        case 5:
                            return new f("fail illegal operation on a filePath, open \"%s\"", str);
                        case 6:
                            return new f("fail the maximum size of the file storage limit is exceeded", new Object[0]);
                        case 7:
                            return new f("fail read zip data", new Object[0]);
                        case 8:
                            return new f("fail write entry", new Object[0]);
                        case 9:
                            return new f(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]);
                        default:
                            return new f("fail " + unzip.name(), new Object[0]);
                    }
                }
                return new f("fail permission denied, open \"%s\"", str);
            } catch (Exception e17) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.FileSystem.UnitUnzip", e17, "write zip stream", new Object[0]);
                return new f("fail read zip data", new Object[0]);
            }
        }
        return new f(String.format("fail permission denied, open \"%s\"", optString), new Object[0]);
    }

    @Override // com.tencent.luggage.wxa.bf.d
    public String a(JSONObject jSONObject) {
        return jSONObject.optString("zipFilePath");
    }
}
