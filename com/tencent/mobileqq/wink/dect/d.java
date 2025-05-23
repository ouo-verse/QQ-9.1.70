package com.tencent.mobileqq.wink.dect;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.WorkerThread;
import com.gyailib.library.GYAIVideoClassify;
import com.gyailib.library.GYVideoClassifyResult;
import com.tencent.hippy.qq.adapter.image.decoder.ImageDetector;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.dect.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0015\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/dect/d;", "Lcom/tencent/mobileqq/wink/dect/FrameLabelDetector;", "Lcom/tencent/videocut/model/MediaModel;", "mediaModel", "", "", "j", "Landroid/graphics/Bitmap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "width", "height", "", "l", "type", "Lcom/tencent/mobileqq/wink/dect/b;", "result", "", "k", "f", "Ljava/util/List;", "imageMediaModels", "<init>", "(Ljava/util/List;)V", "g", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d extends FrameLabelDetector {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<MediaModel> imageMediaModels;

    public d(@NotNull List<MediaModel> imageMediaModels) {
        Intrinsics.checkNotNullParameter(imageMediaModels, "imageMediaModels");
        this.imageMediaModels = imageMediaModels;
    }

    @WorkerThread
    private final List<String> j(MediaModel mediaModel) {
        List<String> emptyList;
        List<String> emptyList2;
        GYVideoClassifyResult gYVideoClassifyResult = new GYVideoClassifyResult();
        try {
            Bitmap m3 = m(mediaModel);
            if (m3 == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
            GYAIVideoClassify i3 = i();
            if (i3 != null) {
                i3.forwardDetect(m3, gYVideoClassifyResult, 1);
            }
            GYAIVideoClassify i16 = i();
            if (i16 != null) {
                i16.getResult(gYVideoClassifyResult);
            }
            m3.recycle();
            QLog.i(ImageDetector.TAG, 4, "Classify Image Success result = " + gYVideoClassifyResult.classifyName);
            return FrameLabelDetector.INSTANCE.b(gYVideoClassifyResult);
        } catch (Throwable unused) {
            QLog.e(ImageDetector.TAG, 4, "Detect image error");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    private final float l(int width, int height) {
        float f16;
        if (width < height) {
            f16 = width;
        } else {
            f16 = height;
        }
        return f16 / 320;
    }

    private final Bitmap m(MediaModel mediaModel) {
        String str;
        ResourceModel resourceModel = mediaModel.videos.get(0).resource;
        if (resourceModel != null && (str = resourceModel.path) != null) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str, new BitmapFactory.Options());
            float l3 = l(decodeFile.getWidth(), decodeFile.getHeight());
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, (int) (decodeFile.getWidth() / l3), (int) (decodeFile.getHeight() / l3), false);
            decodeFile.recycle();
            return createScaledBitmap;
        }
        return null;
    }

    public void k(int type, @NotNull b result) {
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.i(ImageDetector.TAG, 4, "Classify Image Start ==============");
        if (!FrameLabelDetector.INSTANCE.a()) {
            b.a.a(result, null, "bundles not ready", 1, null);
            f();
            return;
        }
        HashMap hashMap = new HashMap();
        for (MediaModel mediaModel : this.imageMediaModels) {
            List<String> j3 = j(mediaModel);
            String str = mediaModel.id;
            if (str == null) {
                str = "";
            }
            hashMap.put(str, j3);
        }
        result.a(hashMap);
    }
}
