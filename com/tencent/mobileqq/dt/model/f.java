package com.tencent.mobileqq.dt.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.mobileocr.WeOcr;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dt.api.ScanPicData;
import com.tencent.mobileqq.dt.web.O3BusinessHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanCacheApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.soload.api.ISoLoaderService;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0002J*\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/dt/model/f;", "", "", "scanUrl", "Lcom/tencent/mobileqq/dt/model/c;", "picData", "", "resCode", "Lcom/tencent/mobileqq/soload/biz/entity/LoadExtResult;", "loadExtResult", "", "f", "path", "d", "ocrData", "detectModelPath", "recogModelPath", "labelPath", "k", "url", "Lcom/tencent/mobileqq/dt/data/f;", DownloadInfo.spKey_Config, "", "c", "Lcom/tencent/mobileqq/dt/web/O3BusinessHandler;", "e", "Lcom/tencent/mobileqq/dt/api/ScanPicData;", "data", tl.h.F, "Lcom/tencent/mobileqq/dt/api/e;", "g", "<init>", "()V", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f203845a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25042);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f203845a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean c(String url, com.tencent.mobileqq.dt.data.f config) {
        try {
            return config.a().contains(new URL(url).getHost());
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final c d(String path) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(path);
        } catch (Exception e16) {
            e = e16;
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
        try {
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
                Intrinsics.checkNotNullExpressionValue(decodeStream, "decodeStream(inputStream)");
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    QLog.e("ScanSecurityHandler", 1, "close exception", e17);
                }
                int width = decodeStream.getWidth();
                int height = decodeStream.getHeight();
                int i3 = width * height;
                int[] iArr = new int[i3];
                decodeStream.getPixels(iArr, 0, width, 0, 0, width, height);
                decodeStream.recycle();
                int i16 = i3 * 3;
                byte[] bArr = new byte[i16];
                for (int i17 = 0; i17 < i3; i17++) {
                    int i18 = iArr[i17];
                    int i19 = i17 * 3;
                    bArr[i19] = (byte) Color.red(i18);
                    bArr[i19 + 1] = (byte) Color.green(i18);
                    bArr[i19 + 2] = (byte) Color.blue(i18);
                }
                ByteBuffer imgBuffer = ByteBuffer.allocateDirect(i16);
                imgBuffer.put(bArr);
                imgBuffer.rewind();
                Intrinsics.checkNotNullExpressionValue(imgBuffer, "imgBuffer");
                return new c(imgBuffer, width, height);
            } catch (Throwable th6) {
                th = th6;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e18) {
                        QLog.e("ScanSecurityHandler", 1, "close exception", e18);
                    }
                }
                throw th;
            }
        } catch (Exception e19) {
            e = e19;
            QLog.e("ScanSecurityHandler", 1, "decode img error", e);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e26) {
                    QLog.e("ScanSecurityHandler", 1, "close exception", e26);
                }
            }
            return null;
        }
    }

    private final O3BusinessHandler e() {
        AppInterface a16 = WebCheck.a();
        if (a16 == null) {
            QLog.e("ScanSecurityHandler", 1, "reportScanData appInterface is null");
            return null;
        }
        BusinessHandler businessHandler = a16.getBusinessHandler(O3BusinessHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.dt.web.O3BusinessHandler");
        return (O3BusinessHandler) businessHandler;
    }

    private final void f(String scanUrl, c picData, int resCode, LoadExtResult loadExtResult) {
        boolean z16;
        boolean z17;
        if (resCode != 0) {
            return;
        }
        String soLoadPath = loadExtResult.getSoLoadPath();
        boolean z18 = false;
        if (soLoadPath != null && soLoadPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("ScanSecurityHandler", 1, "so path is empty");
            return;
        }
        String relatedFilesFolder = loadExtResult.getRelatedFilesFolder();
        if (relatedFilesFolder != null && relatedFilesFolder.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            QLog.e("ScanSecurityHandler", 1, "ocrPath path is empty");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(relatedFilesFolder);
        String str = File.separator;
        sb5.append(str);
        sb5.append("libMobileOCRJNI.so");
        String sb6 = sb5.toString();
        try {
            System.load(soLoadPath);
            System.load(sb6);
            String k3 = k(picData, relatedFilesFolder + str + "FPOCRDet.xnet", relatedFilesFolder + str + "FPOCRRecog.xnet", relatedFilesFolder + str + "RecDict");
            if (k3 == null || k3.length() == 0) {
                z18 = true;
            }
            if (z18) {
                QLog.e("ScanSecurityHandler", 1, "result is empty");
                return;
            }
            O3BusinessHandler e16 = e();
            if (e16 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ocrText", k3);
                jSONObject.put("scanUrl", scanUrl);
                Unit unit = Unit.INSTANCE;
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026Url)\n        }.toString()");
                e16.D2("reportCameraScanner", jSONObject2, null);
            }
        } catch (Throwable th5) {
            QLog.e("ScanSecurityHandler", 1, "load so error", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final com.tencent.mobileqq.dt.api.e data, final c cVar, final int i3, final LoadExtResult loadExtResult) {
        Intrinsics.checkNotNullParameter(data, "$data");
        QLog.i("ScanSecurityHandler", 1, "download MobileOCR " + loadExtResult.getVer() + TokenParser.SP + i3);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.dt.model.e
            @Override // java.lang.Runnable
            public final void run() {
                f.j(com.tencent.mobileqq.dt.api.e.this, cVar, i3, loadExtResult);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(com.tencent.mobileqq.dt.api.e data, c cVar, int i3, LoadExtResult loadExtResult) {
        Intrinsics.checkNotNullParameter(data, "$data");
        f fVar = f203845a;
        String str = data.f203665b;
        Intrinsics.checkNotNullExpressionValue(str, "data.scanUrl");
        Intrinsics.checkNotNullExpressionValue(loadExtResult, "loadExtResult");
        fVar.f(str, cVar, i3, loadExtResult);
    }

    private final synchronized String k(c ocrData, String detectModelPath, String recogModelPath, String labelPath) {
        String nProcess;
        long nInit = WeOcr.nInit(detectModelPath, recogModelPath, labelPath);
        nProcess = WeOcr.nProcess(nInit, ocrData.a(), ocrData.b(), ocrData.c());
        WeOcr.nRelease(nInit);
        if (QLog.isColorLevel()) {
            QLog.i("ScanSecurityHandler", 1, "mobileOcr result is " + nProcess);
        }
        return nProcess;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004d A[Catch: all -> 0x00db, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000c, B:11:0x0011, B:13:0x0022, B:15:0x0028, B:18:0x003d, B:20:0x0041, B:25:0x004d, B:28:0x0063, B:32:0x007c, B:36:0x009a), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0063 A[Catch: all -> 0x00db, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000c, B:11:0x0011, B:13:0x0022, B:15:0x0028, B:18:0x003d, B:20:0x0041, B:25:0x004d, B:28:0x0063, B:32:0x007c, B:36:0x009a), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void g(@NotNull final com.tencent.mobileqq.dt.api.e data) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.dt.data.f config = g.b();
        if (config.c() && config.b()) {
            String str = data.f203665b;
            Intrinsics.checkNotNullExpressionValue(str, "data.scanUrl");
            Intrinsics.checkNotNullExpressionValue(config, "config");
            if (c(str, config)) {
                String filePath = data.f203664a;
                if (filePath != null && filePath.length() != 0) {
                    z16 = false;
                    if (!z16) {
                        QLog.i("ScanSecurityHandler", 1, "scanSecurity error filePath is empty");
                        ((IScanCacheApi) QRoute.api(IScanCacheApi.class)).clear();
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
                    final c d16 = d(filePath);
                    ((IScanCacheApi) QRoute.api(IScanCacheApi.class)).clear();
                    if (d16 == null) {
                        return;
                    }
                    QLog.i("ScanSecurityHandler", 1, "start download MobileOCR");
                    ((ISoLoaderService) QRoute.api(ISoLoaderService.class)).download("MobileOCR", new OnLoadListener() { // from class: com.tencent.mobileqq.dt.model.d
                        @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
                        public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                            f.i(com.tencent.mobileqq.dt.api.e.this, d16, i3, loadExtResult);
                        }
                    });
                    return;
                }
                z16 = true;
                if (!z16) {
                }
            }
        }
        QLog.i("ScanSecurityHandler", 1, "scanSecurity forbid isOpen " + config.c() + " ocrEnable " + config.b() + " url " + data.f203665b);
        ((IScanCacheApi) QRoute.api(IScanCacheApi.class)).clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(@NotNull ScanPicData data) {
        int i3;
        Integer intOrNull;
        byte[] hexToBytes;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.dt.data.f config = g.b();
        if (config.c()) {
            String k3 = data.k();
            Intrinsics.checkNotNullExpressionValue(k3, "data.scanUrl");
            Intrinsics.checkNotNullExpressionValue(config, "config");
            if (c(k3, config)) {
                if ((data.l() == 3 || data.l() == 4 || data.l() == 12) && TextUtils.isEmpty(data.j())) {
                    QLog.i("ScanSecurityHandler", 1, "scanSecurity scene " + data.l() + " fobid");
                    return;
                }
                if (data.l() == 11 && (hexToBytes = PkgTools.hexToBytes(data.b())) != null) {
                    data.q(new String(hexToBytes, Charsets.UTF_8));
                }
                if (QLog.isColorLevel()) {
                    QLog.i("ScanSecurityHandler", 1, "ScanPicData is " + data);
                }
                O3BusinessHandler e16 = e();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cmd", "ReportPressScanner");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scan_pic_file_id", data.c());
                jSONObject2.put("jump_target_url", data.k());
                jSONObject2.put("scenes", data.l());
                jSONObject2.put("scan_pic_url", data.j());
                jSONObject2.put("guild_id", data.f());
                jSONObject2.put("group_id", data.e());
                jSONObject2.put("passive_uin", data.m());
                String storeId = data.n();
                if (storeId != null) {
                    Intrinsics.checkNotNullExpressionValue(storeId, "storeId");
                    intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(storeId);
                    if (intOrNull != null) {
                        i3 = intOrNull.intValue();
                        jSONObject2.put("store_id", i3);
                        jSONObject2.put("channel_id", data.a());
                        jSONObject2.put("md5", data.g());
                        Unit unit = Unit.INSTANCE;
                        jSONObject.put("data", jSONObject2.toString());
                        String jSONObject3 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject3, "JSONObject().apply {\n   \u2026g())\n        }.toString()");
                        if (e16 == null) {
                            e16.D2("reportPressScanner", jSONObject3, null);
                            return;
                        }
                        return;
                    }
                }
                i3 = 0;
                jSONObject2.put("store_id", i3);
                jSONObject2.put("channel_id", data.a());
                jSONObject2.put("md5", data.g());
                Unit unit2 = Unit.INSTANCE;
                jSONObject.put("data", jSONObject2.toString());
                String jSONObject32 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject32, "JSONObject().apply {\n   \u2026g())\n        }.toString()");
                if (e16 == null) {
                }
            }
        }
        QLog.i("ScanSecurityHandler", 1, "scanSecurity forbid isOpen " + config.c() + " url " + data.k());
    }
}
