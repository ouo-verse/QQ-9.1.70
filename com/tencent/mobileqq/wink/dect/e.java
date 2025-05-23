package com.tencent.mobileqq.wink.dect;

import android.graphics.Bitmap;
import com.gyailib.library.GYAIVideoClassify;
import com.gyailib.library.GYVideoClassifyResult;
import com.tencent.hippy.qq.adapter.image.decoder.ImageDetector;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.dect.b;
import com.tencent.mobileqq.wink.l;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.light.device.OfflineConfig;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\f\b\u0016\u0018\u0000 )2\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J6\u0010\u0013\u001a*\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000ej\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010`\u00122\u0006\u0010\r\u001a\u00020\u0006R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/wink/dect/e;", "Lcom/tencent/mobileqq/wink/dect/FrameLabelDetector;", "Lcom/tencent/mobileqq/wink/dect/b;", "result", "", "j", "", "type", DomainData.DOMAIN_NAME, "Lcom/gyailib/library/GYVideoClassifyResult;", "classifyResult", "k", "e", "totalFrames", "Ljava/util/HashMap;", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "", "", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/videocut/model/MediaModel;", "f", "Lcom/tencent/videocut/model/MediaModel;", "mediaModel", "g", "I", "l", "()I", "setDetectType", "(I)V", "detectType", "", h.F, "Z", "getDestoryed", "()Z", "setDestoryed", "(Z)V", "destoryed", "<init>", "(Lcom/tencent/videocut/model/MediaModel;)V", "i", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class e extends FrameLabelDetector {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediaModel mediaModel;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int detectType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile boolean destoryed;

    public e(@NotNull MediaModel mediaModel) {
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        this.mediaModel = mediaModel;
    }

    private final void j(b result) {
        Map<String, ? extends List<String>> mapOf;
        GYVideoClassifyResult gYVideoClassifyResult = new GYVideoClassifyResult();
        if (!l.g()) {
            QLog.e(ImageDetector.TAG, 1, "tavKit so load failed.");
            b.a.a(result, null, "tavKit so load failed.", 1, null);
        } else {
            k(result, gYVideoClassifyResult);
        }
        GYAIVideoClassify i3 = i();
        if (i3 != null) {
            i3.getResult(gYVideoClassifyResult);
        }
        QLog.d(ImageDetector.TAG, 4, "on get classify result: " + gYVideoClassifyResult.classifyName + "," + gYVideoClassifyResult.classifyType);
        List<String> b16 = FrameLabelDetector.INSTANCE.b(gYVideoClassifyResult);
        if (b16.isEmpty()) {
            b.a.a(result, null, null, 3, null);
            return;
        }
        result.d(b16);
        result.b(gYVideoClassifyResult);
        String str = this.mediaModel.id;
        if (str == null) {
            str = "";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(str, b16));
        result.a(mapOf);
    }

    @Override // com.tencent.mobileqq.wink.dect.FrameLabelDetector
    public void e() {
        super.e();
        this.destoryed = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k(@NotNull b result, @NotNull GYVideoClassifyResult classifyResult) {
        int i3;
        FrameExtractor frameExtractor;
        Bitmap c16;
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(classifyResult, "classifyResult");
        if (OfflineConfig.getPhonePerfLevel(BaseApplication.context) <= 2 && this.detectType == c.INSTANCE.b()) {
            ms.a.f(ImageDetector.TAG, "labelDetect :detect from catch when smart filter");
            i3 = 4;
        } else {
            i3 = 8;
        }
        for (Map.Entry<ClipSource, List<Long>> entry : m(i3).entrySet()) {
            ClipSource key = entry.getKey();
            List<Long> value = entry.getValue();
            FrameExtractor frameExtractor2 = null;
            try {
                QLog.d(ImageDetector.TAG, 4, "Detecting video " + key.getPath());
                frameExtractor = new FrameExtractor(key);
            } catch (Exception e16) {
                e = e16;
                frameExtractor = null;
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                Iterator<T> it = value.iterator();
                while (it.hasNext()) {
                    long longValue = ((Number) it.next()).longValue();
                    if (!this.destoryed && (c16 = frameExtractor.c(longValue)) != null) {
                        QLog.d(ImageDetector.TAG, 4, "forward detecting");
                        GYAIVideoClassify i16 = i();
                        if (i16 != null) {
                            i16.forwardDetect(c16, classifyResult, 0);
                        }
                        c16.recycle();
                    }
                }
            } catch (Exception e17) {
                e = e17;
                try {
                    QLog.e(ImageDetector.TAG, 4, "on get classify error: " + e);
                    b.a.a(result, e, null, 2, null);
                    if (frameExtractor != null) {
                        frameExtractor.e();
                    }
                } catch (Throwable th6) {
                    th = th6;
                    frameExtractor2 = frameExtractor;
                    if (frameExtractor2 != null) {
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                frameExtractor2 = frameExtractor;
                try {
                    QLog.e(ImageDetector.TAG, 4, "on get classify throwable: " + th);
                    if (frameExtractor2 != null) {
                        frameExtractor2.e();
                    }
                } catch (Throwable th8) {
                    th = th8;
                    if (frameExtractor2 != null) {
                        frameExtractor2.e();
                    }
                    throw th;
                }
            }
            frameExtractor.e();
        }
    }

    /* renamed from: l, reason: from getter */
    public final int getDetectType() {
        return this.detectType;
    }

    @NotNull
    public final HashMap<ClipSource, List<Long>> m(int totalFrames) {
        long j3;
        ms.a.f(ImageDetector.TAG, "labelDetect :getFrameTimestamps " + totalFrames);
        Iterator<T> it = this.mediaModel.videos.iterator();
        long j16 = 0;
        long j17 = 0L;
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null) {
                j3 = resourceModel.selectDuration;
            } else {
                j3 = 0;
            }
            j17 += j3;
        }
        long j18 = j17 / (totalFrames + 1);
        HashMap<ClipSource, List<Long>> hashMap = new HashMap<>();
        long j19 = 0;
        for (ClipSource clipSource : com.tencent.videocut.render.extension.e.B(this.mediaModel.videos, false, null, 3, null)) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                long j26 = j16 - j19;
                if (j26 < clipSource.getDuration()) {
                    arrayList.add(Long.valueOf(j26));
                    j16 += j18;
                }
            }
            hashMap.put(clipSource, arrayList);
            j19 += clipSource.getDuration();
        }
        return hashMap;
    }

    public void n(int type, @NotNull b result) {
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.i(ImageDetector.TAG, 4, "Classify Video Start ============== " + this.mediaModel.id);
        this.detectType = type;
        if (!FrameLabelDetector.INSTANCE.a()) {
            b.a.a(result, null, "bundles not ready", 1, null);
            f();
        } else {
            j(result);
        }
    }
}
