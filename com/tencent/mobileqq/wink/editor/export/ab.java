package com.tencent.mobileqq.wink.editor.export;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.export.compress.base.WinkBaseVideoCompressResultListener;
import com.tencent.mobileqq.wink.editor.export.p;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.wink.utils.ay;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tavcut.core.render.exporter.ExportOutput;
import cooperation.qqcircle.report.QCircleWeakNetReporter;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ab implements d {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.wink.editor.export.compress.base.a f320176a;

    /* renamed from: b, reason: collision with root package name */
    private long f320177b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a extends WinkBaseVideoCompressResultListener {
        a(String str, ab abVar, ExportOutput exportOutput, WinkExportParams winkExportParams, long j3, String str2, int i3, c cVar) {
            super(str, abVar, exportOutput, winkExportParams, j3, str2, i3, cVar);
        }

        @Override // com.tencent.mobileqq.wink.editor.export.compress.base.WinkBaseVideoCompressResultListener
        protected boolean j(@Nullable ExportErrorCode exportErrorCode) {
            boolean g16 = n63.c.f418525a.g(this.winkExportParams);
            w53.b.f("WinkPublish-Export-WinkVideoCompressTask", "doStartInternal, onInterceptCallbackError, type: " + this.type + ", isEnableSoftCompress: " + g16);
            if (g16 && this.type != 5) {
                ab.this.i(5, this.exportOutput, this.winkExportParams, this.callback);
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.wink.editor.export.compress.base.WinkBaseVideoCompressResultListener
        protected boolean k() {
            int b16 = ay.f326693a.b("qqcircle_wink_compress_filesize_threshold", 50);
            if (this.winkExportParams.b().fileSize > 0 && this.winkExportParams.b().fileSize < b16 * 1024 * 1024) {
                w53.b.f("WinkPublish-Export-WinkVideoCompressTask", "compress error, upload origin file, size:" + this.winkExportParams.b().fileSize);
                return true;
            }
            return false;
        }
    }

    public static WinkExportParams d(LocalMediaInfo localMediaInfo, String str, String str2, String str3) {
        j.n(localMediaInfo);
        WinkExportParams winkExportParams = new WinkExportParams(str, str2, str3);
        winkExportParams.p(localMediaInfo);
        winkExportParams.q(300);
        winkExportParams.m(0);
        winkExportParams.G = 1;
        return winkExportParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i3, ExportOutput exportOutput, WinkExportParams winkExportParams, c cVar) {
        long currentTimeMillis = System.currentTimeMillis();
        String s16 = WinkExportUtils.s(winkExportParams.D, winkExportParams.E);
        if (i3 == 5) {
            this.f320176a = new o63.b();
        } else if (i3 == 4) {
            this.f320176a = new com.tencent.mobileqq.wink.editor.export.compress.c();
        } else {
            this.f320176a = new p63.b();
        }
        this.f320177b = exportOutput.getVideoBitRate();
        this.f320176a.a(new a(this.f320176a.b(), this, exportOutput, winkExportParams, currentTimeMillis, s16, i3, cVar));
        this.f320176a.c(winkExportParams.b().path, s16, exportOutput.convertToExportConfig());
        h(winkExportParams, true, false, i3);
    }

    private ExportOutput j(LocalMediaInfo localMediaInfo, WinkExportParams winkExportParams) {
        int i3;
        int i16;
        int x16;
        boolean z16;
        WinkExportUtils.m(localMediaInfo);
        int i17 = localMediaInfo.mediaWidth;
        int i18 = localMediaInfo.mediaHeight;
        long j3 = localMediaInfo.mDuration;
        int i19 = localMediaInfo.rotation;
        if (i19 != 90 && i19 != 270) {
            i16 = i17;
            i3 = i18;
        } else {
            i3 = i17;
            i16 = i18;
        }
        ExportOutput exportOutput = new ExportOutput(i16, i3);
        p.ExportResolutionData b16 = p.f320241a.b(i16, i3, j3, winkExportParams);
        w53.b.f("WinkPublish-Export-WinkVideoCompressTask", "getExportConfig, resolutionData: " + b16);
        int b17 = b16.b();
        exportOutput.setResolutionLevel(b17);
        if (winkExportParams.e() > 0) {
            x16 = winkExportParams.e();
        } else {
            x16 = j.x(localMediaInfo.path);
        }
        if (x16 > 60) {
            x16 = 60;
        }
        if (x16 <= 0) {
            x16 = 30;
        }
        exportOutput.setFrameRate(x16);
        boolean z17 = false;
        if (winkExportParams.c() > uq3.c.K4()) {
            exportOutput.setVideoBitRate(winkExportParams.c());
        } else {
            if (b17 >= 300) {
                z16 = true;
            } else {
                z16 = false;
            }
            j.Q(exportOutput, z16, x16);
        }
        if (winkExportParams.a() > 0) {
            exportOutput.setFormatInteger("i-frame-interval", winkExportParams.a());
        }
        if (winkExportParams.g() && WinkExportUtils.M()) {
            z17 = true;
        }
        if (z17) {
            exportOutput.setOutputVideoMimeType("video/hevc");
        } else {
            exportOutput.setOutputVideoMimeType("video/avc");
        }
        VideoFormatInfo y16 = e93.i.y(localMediaInfo);
        if (y16 == null && j.F(winkExportParams)) {
            localMediaInfo = WinkExportUtils.d(localMediaInfo.path);
            y16 = e93.i.y(localMediaInfo);
        }
        if (j.h(localMediaInfo, y16, z17, winkExportParams)) {
            j.m(y16, exportOutput, z17, winkExportParams);
        }
        WinkExportUtils.l(exportOutput, winkExportParams.D, 1);
        return exportOutput;
    }

    @Override // com.tencent.mobileqq.wink.editor.export.d
    public void a(ExportOutput exportOutput, WinkEditDataWrapper winkEditDataWrapper, WinkExportParams winkExportParams, c cVar) {
        int i3;
        if (q.d(winkExportParams)) {
            i3 = 4;
        } else {
            i3 = 1;
        }
        int a16 = n63.c.f418525a.a(i3);
        if (a16 != i3) {
            w53.b.f("WinkPublish-Export-WinkVideoCompressTask", "start, debugType != type, debugType: " + a16 + ", type: " + i3);
            i3 = a16;
        }
        i(i3, exportOutput, winkExportParams, cVar);
    }

    @Override // com.tencent.mobileqq.wink.editor.export.d
    public boolean b(WinkExportParams winkExportParams, c cVar) {
        w53.b.f("WinkPublish-Export-WinkVideoCompressTask", "start, winkExportParams: " + winkExportParams);
        if (cVar == null) {
            w53.b.c("WinkPublish-Export-WinkVideoCompressTask", "start, error, callback is null");
            return false;
        }
        if (winkExportParams == null) {
            w53.b.c("WinkPublish-Export-WinkVideoCompressTask", "start, error, winkExportParams is null ");
            cVar.c("", new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_PARAMS_ERROR, "winkExportParams is null"));
            return false;
        }
        if (!TextUtils.isEmpty(winkExportParams.E) && !TextUtils.isEmpty(winkExportParams.D)) {
            LocalMediaInfo b16 = winkExportParams.b();
            if (b16 == null) {
                w53.b.c("WinkPublish-Export-WinkVideoCompressTask", "start, error, originLocalMediaInfo is null");
                cVar.c(winkExportParams.E, new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_PARAMS_ERROR, "originLocalMediaInfo is null"));
                return false;
            }
            if (!FileUtils.fileExists(b16.path)) {
                w53.b.c("WinkPublish-Export-WinkVideoCompressTask", "start, error, file not exist");
                cVar.c(winkExportParams.E, new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_FILE_NOT_EXIST, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST));
                return false;
            }
            boolean c16 = n63.c.f418525a.c();
            w53.b.a("WinkPublish-Export-WinkVideoCompressTask", "start, isDebugForceCompress: " + c16);
            String str = winkExportParams.E;
            if (b16._id != 0) {
                str = b16._id + "";
            }
            LocalMediaInfo q16 = WinkExportUtils.q(str);
            WinkExportParams r16 = WinkExportUtils.r(str);
            if (!c16 && q16 != null && winkExportParams.equals(r16)) {
                w53.b.a("WinkPublish-Export-WinkVideoCompressTask", "start, has already compressed");
                cVar.d(winkExportParams.E, q16, true);
                f(winkExportParams, q16, true, true, 0L, -1, 0L);
                return true;
            }
            ExportOutput j3 = j(b16, winkExportParams);
            b16.mediaBitrate = WinkExportUtils.p(b16);
            if (!c16 && winkExportParams.j()) {
                long j16 = b16.mediaBitrate;
                if (j16 > 0 && j16 <= j3.getVideoBitRate()) {
                    w53.b.a("WinkPublish-Export-WinkVideoCompressTask", "start, originLocalMediaInfo.mediaBitrate: " + b16.mediaBitrate + ", winkExportParams.mVideoBitRate: " + winkExportParams.f323990e + ", exportOutput.getVideoBitRate: " + j3.getVideoBitRate() + ", no need compress");
                    LocalMediaInfo d16 = WinkExportUtils.d(b16.path);
                    cVar.d(winkExportParams.E, d16, false);
                    f(winkExportParams, d16, false, false, 0L, -1, 0L);
                    return true;
                }
            }
            try {
                a(j3, null, winkExportParams, cVar);
                return true;
            } catch (Exception e16) {
                w53.b.d("WinkPublish-Export-WinkVideoCompressTask", "start, error ", e16);
                cVar.c(winkExportParams.E, new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_PARAMS_ERROR, "exception:" + e16));
                return false;
            }
        }
        w53.b.c("WinkPublish-Export-WinkVideoCompressTask", "start, error, mMissionID or mBusinessName is null or empty ");
        cVar.c(winkExportParams.E, new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_PARAMS_ERROR, "mMissionID or mBusinessName is null or empty"));
        return false;
    }

    @Override // com.tencent.mobileqq.wink.editor.export.d
    public void cancel() {
        QLog.d("WinkPublish-Export-WinkVideoCompressTask", 1, "[cancel]");
        com.tencent.mobileqq.wink.editor.export.compress.base.a aVar = this.f320176a;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    public void e(WinkExportParams winkExportParams, boolean z16, boolean z17, int i3) {
        w53.b.c("WinkPublish-Export-WinkVideoCompressTask", "[doCompressCancel]");
        try {
            JsonObject a16 = WinkExportUtils.a(z16, z17, i3, winkExportParams.H);
            ExportErrorCode exportErrorCode = new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_CANCEL_CALLBACK, null);
            WinkExportUtils.k(winkExportParams, "E_VIDEO_EXPORT_RESULT", exportErrorCode.transformedCode(), exportErrorCode.getMessage(), "", "", "", "", "", winkExportParams.E, a16);
        } catch (Exception e16) {
            w53.b.e("WinkPublish-Export-WinkVideoCompressTask", e16);
        }
    }

    public void f(WinkExportParams winkExportParams, LocalMediaInfo localMediaInfo, boolean z16, boolean z17, long j3, int i3, long j16) {
        QLog.d("WinkPublish-Export-WinkVideoCompressTask", 1, "[doCompressCompleted], missionId: " + winkExportParams.E);
        if (z16 && !z17) {
            try {
                WinkExportUtils.U(winkExportParams.E, localMediaInfo, winkExportParams);
                String str = winkExportParams.E;
                if (winkExportParams.I._id != 0) {
                    str = winkExportParams.I._id + "";
                }
                WinkExportUtils.T(str, localMediaInfo, winkExportParams);
            } catch (Exception e16) {
                w53.b.e("WinkPublish-Export-WinkVideoCompressTask", e16);
                return;
            }
        }
        JsonObject a16 = WinkExportUtils.a(z16, z17, i3, winkExportParams.H);
        a16.addProperty(QCircleWeakNetReporter.KEY_COST, String.valueOf(j3));
        a16.addProperty("videoAheadTime", String.valueOf(j16));
        a16.addProperty("newAudioEncode", String.valueOf(EncoderWriter.USE_NEW_AUDIO_ENCODE));
        a16.addProperty("preAudioDecode", String.valueOf(EncoderWriter.PRE_DECODE_AUDIO));
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(WinkExportUtils.n(localMediaInfo));
        a16.add("mediainfo", jsonArray);
        WinkExportUtils.k(winkExportParams, "E_VIDEO_EXPORT_RESULT", 0L, "", localMediaInfo.mediaWidth + HippyTKDListViewAdapter.X + localMediaInfo.mediaHeight, String.valueOf(localMediaInfo.mediaBitrate), String.valueOf(localMediaInfo.fileSize), String.valueOf(localMediaInfo.mDuration / 1000), String.valueOf(localMediaInfo.path), String.valueOf(j3), a16);
    }

    public void g(WinkExportParams winkExportParams, ExportErrorCode exportErrorCode, boolean z16, boolean z17, int i3) {
        w53.b.c("WinkPublish-Export-WinkVideoCompressTask", "[doCompressError]");
        try {
            WinkExportUtils.k(winkExportParams, "E_VIDEO_EXPORT_RESULT", exportErrorCode.transformedCode(), exportErrorCode.getMessage(), "", "", "", "", "", winkExportParams.E, WinkExportUtils.a(z16, z17, i3, winkExportParams.H));
        } catch (Exception e16) {
            w53.b.e("WinkPublish-Export-WinkVideoCompressTask", e16);
        }
    }

    public void h(WinkExportParams winkExportParams, boolean z16, boolean z17, int i3) {
        QLog.d("WinkPublish-Export-WinkVideoCompressTask", 1, "[doCompressStart]");
        try {
            winkExportParams.o();
            JsonObject a16 = WinkExportUtils.a(z16, z17, i3, winkExportParams.H);
            a16.addProperty("id", String.valueOf(winkExportParams.K));
            a16.addProperty("duration", String.valueOf(winkExportParams.b().mDuration));
            a16.addProperty("newAudioEncode", String.valueOf(EncoderWriter.USE_NEW_AUDIO_ENCODE));
            a16.addProperty("preAudioDecode", String.valueOf(EncoderWriter.PRE_DECODE_AUDIO));
            JsonArray jsonArray = new JsonArray();
            jsonArray.add(WinkExportUtils.n(winkExportParams.b()));
            a16.add("mediainfo", jsonArray);
            WinkExportUtils.k(winkExportParams, "E_VIDEO_EXPORT_START", 0L, "", "", "", "", "", "", winkExportParams.E, a16);
        } catch (Exception e16) {
            w53.b.e("WinkPublish-Export-WinkVideoCompressTask", e16);
        }
    }

    public long k() {
        return this.f320177b;
    }
}
