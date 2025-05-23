package com.tencent.mobileqq.wink.editor.filter;

import android.graphics.Bitmap;
import com.gyailib.library.GYAIVideoClassify;
import com.gyailib.library.GYVideoClassifyResult;
import com.tencent.hippy.qq.adapter.image.decoder.ImageDetector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.light.device.OfflineConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J6\u0010\u000f\u001a*\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\nj\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f`\u000e2\u0006\u0010\t\u001a\u00020\bR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/filter/q;", "Lcom/tencent/mobileqq/wink/dect/e;", "Lcom/tencent/mobileqq/wink/dect/b;", "result", "Lcom/gyailib/library/GYVideoClassifyResult;", "classifyResult", "", "k", "", "totalFrames", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/wink/editor/filter/a;", "", "", "Lkotlin/collections/HashMap;", "o", "Lcom/tencent/videocut/model/MediaModel;", "j", "Lcom/tencent/videocut/model/MediaModel;", "getMediaModel", "()Lcom/tencent/videocut/model/MediaModel;", "mediaModel", "<init>", "(Lcom/tencent/videocut/model/MediaModel;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class q extends com.tencent.mobileqq.wink.dect.e {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediaModel mediaModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@NotNull MediaModel mediaModel) {
        super(mediaModel);
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        this.mediaModel = mediaModel;
    }

    @Override // com.tencent.mobileqq.wink.dect.e
    public void k(@NotNull com.tencent.mobileqq.wink.dect.b result, @NotNull GYVideoClassifyResult classifyResult) {
        int i3;
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(classifyResult, "classifyResult");
        if (OfflineConfig.getPhonePerfLevel(BaseApplication.context) <= 2 && getDetectType() == com.tencent.mobileqq.wink.dect.c.INSTANCE.b()) {
            ms.a.f(ImageDetector.TAG, "labelDetect :detect from catch when smart filter");
            i3 = 4;
        } else {
            i3 = 8;
        }
        for (Map.Entry<a, List<Long>> entry : o(i3).entrySet()) {
            a key = entry.getKey();
            List<Long> value = entry.getValue();
            i iVar = null;
            try {
                try {
                    QLog.d(ImageDetector.TAG, 4, "Detecting video " + key.getClipSource().getPath());
                    i iVar2 = new i(key);
                    try {
                        Iterator<T> it = value.iterator();
                        while (it.hasNext()) {
                            Bitmap b16 = iVar2.b(((Number) it.next()).longValue());
                            if (b16 != null) {
                                QLog.d(ImageDetector.TAG, 4, "forward detecting");
                                GYAIVideoClassify i16 = i();
                                if (i16 != null) {
                                    i16.forwardDetect(b16, classifyResult, 0);
                                }
                                b16.recycle();
                            }
                        }
                        iVar2.c();
                    } catch (Exception e16) {
                        e = e16;
                        iVar = iVar2;
                        super.k(result, classifyResult);
                        QLog.e(ImageDetector.TAG, 4, "SmartFilterVideoLabelDetector on get classify error: " + e);
                        if (iVar != null) {
                            iVar.c();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        iVar = iVar2;
                        if (iVar != null) {
                            iVar.c();
                        }
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    @NotNull
    public final HashMap<a, List<Long>> o(int totalFrames) {
        SizeF sizeF;
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
        HashMap<a, List<Long>> hashMap = new HashMap<>();
        long j19 = 0;
        for (MediaClip mediaClip : this.mediaModel.videos) {
            ClipSource A = com.tencent.videocut.render.extension.e.A(mediaClip, false, null, 3, null);
            if (A != null) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    long j26 = j16 - j19;
                    if (j26 >= A.getDuration()) {
                        break;
                    }
                    arrayList.add(Long.valueOf(j26));
                    j16 += j18;
                }
                ResourceModel resourceModel2 = mediaClip.resource;
                if (resourceModel2 != null && (sizeF = resourceModel2.size) != null) {
                    hashMap.put(new a(A, sizeF), arrayList);
                }
                j19 += A.getDuration();
            }
        }
        return hashMap;
    }
}
