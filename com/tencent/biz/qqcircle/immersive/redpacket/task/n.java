package com.tencent.biz.qqcircle.immersive.redpacket.task;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.util.Size;
import com.tencent.biz.qqcircle.immersive.redpacket.bean.QFSRedPacketPreviewBean;
import com.tencent.biz.qqcircle.immersive.redpacket.task.o;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import com.tencent.mobileqq.wink.listener.GenerateListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\t\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0016J\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016R\u0014\u0010\u0012\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/n;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/e;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/a;", "data", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", "callback", "", "g", "Lcom/tencent/biz/qqcircle/immersive/redpacket/bean/QFSRedPacketPreviewBean;", "previewBean", "Landroid/graphics/Rect;", "j", "", "i", "a", tl.h.F, "b", "Ljava/lang/String;", "coverDir", "", "c", "Ljava/util/Map;", "localCoverResult", "()Ljava/lang/String;", "tag", "<init>", "()V", "d", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class n extends e<AddRedPacketCoverData> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final IWinkAPI f89561e;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String coverDir = com.tencent.mobileqq.qcircle.api.constant.a.f261581f + "redpacket/";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> localCoverResult = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"com/tencent/biz/qqcircle/immersive/redpacket/task/n$b", "Lcom/tencent/mobileqq/wink/listener/GenerateListener;", "", "frameNum", "", "frameTs", "Landroid/graphics/Bitmap;", "croppedBitmap", "", "onCropFrame", "", "outputPath", "onEncoded", "", "t", "onError", "", "a", "Z", "genFailed", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements GenerateListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private volatile boolean genFailed;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AddRedPacketCoverData f89566c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o<AddRedPacketCoverData> f89567d;

        b(AddRedPacketCoverData addRedPacketCoverData, o<AddRedPacketCoverData> oVar) {
            this.f89566c = addRedPacketCoverData;
            this.f89567d = oVar;
        }

        @Override // com.tencent.mobileqq.wink.listener.GenerateListener
        public void beforeCaptureFrame(int i3, long j3) {
            GenerateListener.DefaultImpls.beforeCaptureFrame(this, i3, j3);
        }

        @Override // com.tencent.mobileqq.wink.listener.GenerateListener
        public void beforeEncode() {
            GenerateListener.DefaultImpls.beforeEncode(this);
        }

        @Override // com.tencent.mobileqq.wink.listener.GenerateListener
        public void onAddFrame(int i3) {
            GenerateListener.DefaultImpls.onAddFrame(this, i3);
        }

        @Override // com.tencent.mobileqq.wink.listener.GenerateListener
        public void onCaptureFrame(int i3, long j3, @Nullable Bitmap bitmap) {
            GenerateListener.DefaultImpls.onCaptureFrame(this, i3, j3, bitmap);
        }

        @Override // com.tencent.mobileqq.wink.listener.GenerateListener
        public void onCropFrame(int frameNum, long frameTs, @Nullable Bitmap croppedBitmap) {
            String str;
            GenerateListener.DefaultImpls.onCropFrame(this, frameNum, frameTs, croppedBitmap);
            if (frameNum == 0 && croppedBitmap != null) {
                File k3 = com.tencent.biz.qqcircle.immersive.redpacket.util.d.k(com.tencent.biz.qqcircle.immersive.redpacket.util.d.f89585a, n.this.i(), croppedBitmap, 0, 4, null);
                if (k3 != null) {
                    str = k3.getAbsolutePath();
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "failed";
                }
                QLog.d("GenerateApngProcess", 1, "doProcess, onCropFrame, coverPath:" + str + ", genFailed:" + this.genFailed);
                if (this.genFailed) {
                    return;
                }
                n.this.localCoverResult.put("static_cover", str);
                n.this.g(this.f89566c, this.f89567d);
            }
        }

        @Override // com.tencent.mobileqq.wink.listener.GenerateListener
        public void onEncoded(@NotNull String outputPath) {
            Intrinsics.checkNotNullParameter(outputPath, "outputPath");
            QLog.d("GenerateApngProcess", 1, "doProcess, onEncoded, outputPath:" + outputPath + ", genFailed:" + this.genFailed);
            if (this.genFailed) {
                return;
            }
            n.this.localCoverResult.put("apng_cover", outputPath);
            n.this.g(this.f89566c, this.f89567d);
        }

        @Override // com.tencent.mobileqq.wink.listener.GenerateListener
        public void onError(@NotNull Throwable t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            QLog.w("GenerateApngProcess", 1, "doProcess, onError ", t16);
            this.genFailed = true;
            n.this.localCoverResult.put("static_cover", "failed");
            n.this.localCoverResult.put("apng_cover", "failed");
            n.this.g(this.f89566c, this.f89567d);
        }

        @Override // com.tencent.mobileqq.wink.listener.GenerateListener
        public void onRelease() {
            GenerateListener.DefaultImpls.onRelease(this);
        }
    }

    static {
        QRouteApi api = QRoute.api(IWinkAPI.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IWinkAPI::class.java)");
        f89561e = (IWinkAPI) api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(AddRedPacketCoverData data, o<AddRedPacketCoverData> callback) {
        boolean z16;
        QLog.d("GenerateApngProcess", 1, "checkLocalCoverResult, localCoverResult:" + this.localCoverResult);
        String str = this.localCoverResult.get("static_cover");
        String str2 = this.localCoverResult.get("apng_cover");
        if (!Intrinsics.areEqual(str, "default") && !Intrinsics.areEqual(str2, "default")) {
            boolean z17 = false;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && !Intrinsics.areEqual(str, "failed")) {
                if (str2 == null || str2.length() == 0) {
                    z17 = true;
                }
                if (!z17 && !Intrinsics.areEqual(str2, "failed")) {
                    data.l(str);
                    data.i(str2);
                    callback.onSuccess(data);
                    return;
                }
            }
            o.a.a(callback, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i() {
        return this.coverDir + "red_packet_cover_" + System.currentTimeMillis() + ".jpeg";
    }

    private final Rect j(QFSRedPacketPreviewBean previewBean) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(previewBean.getLocalVideoPath());
            String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
            Intrinsics.checkNotNull(extractMetadata);
            int parseInt = Integer.parseInt(extractMetadata);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
            Intrinsics.checkNotNull(extractMetadata2);
            int parseInt2 = Integer.parseInt(extractMetadata2);
            mediaMetadataRetriever.release();
            QLog.d("GenerateApngProcess", 1, "getOutputRect, videoWidth:" + parseInt + ", videoHeight:" + parseInt2);
            float f16 = (float) parseInt;
            float f17 = (float) parseInt2;
            if ((1.0f * f16) / f17 > 0.8556701f) {
                float f18 = (f16 - (f17 * 0.8556701f)) / 2;
                Rect rect = new Rect((int) f18, 0, (int) (f16 - f18), parseInt2);
                QLog.d("GenerateApngProcess", 1, "getOutputRect, ret1:" + rect);
                return rect;
            }
            float f19 = (f17 - (f16 / 0.8556701f)) / 2;
            Rect rect2 = new Rect(0, (int) f19, parseInt, (int) (f17 - f19));
            QLog.d("GenerateApngProcess", 1, "getOutputRect, ret2:" + rect2);
            return rect2;
        } catch (Throwable th5) {
            QLog.w("GenerateApngProcess", 1, "getOutputRect, error ", th5);
            return null;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.p
    @NotNull
    public String a() {
        return "GenerateApngProcess";
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.e
    @NotNull
    public String c() {
        return "GenerateApngProcess";
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.p
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull AddRedPacketCoverData data, @NotNull o<AddRedPacketCoverData> callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("GenerateApngProcess", 1, "doProcess, data:" + data);
        d.a(this.localCoverResult, new String[]{"static_cover", "apng_cover"}, "default");
        f89561e.generateApng(data.getPreviewBean().getLocalVideoPath(), null, null, data.getStartTime(), 2000000L, new Size(332, 388), j(data.getPreviewBean()), null, 100, new b(data, callback), "redpacket");
    }
}
