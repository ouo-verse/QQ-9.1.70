package com.tencent.videocut.render;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.videocut.model.BackgroundFillMode;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.RatioType;
import com.tencent.videocut.model.RectF;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.render.model.RatioTypeEnum;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.components.Size;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\b\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\u0016\u0010\n\u001a\u0004\u0018\u00010\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u001a,\u0010\u000e\u001a\u0004\u0018\u00010\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u001a$\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u001a4\u0010\u0013\u001a\u0004\u0018\u00010\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011\"\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0019"}, d2 = {"", "ratio", "", "maxSize", "Lcom/tencent/videocut/model/SizeF;", "a", "j", "", "Lcom/tencent/videocut/model/MediaClip;", "videos", "i", "fillScale", "Lcom/tencent/videocut/model/BackgroundModel;", "referenceBackgroundModel", "d", "renderSize", "b", "", "isUsingTemplate", "f", "", "Ljava/lang/String;", "getDEFAULT_COLOR_BACKGROUND_ID", "()Ljava/lang/String;", "DEFAULT_COLOR_BACKGROUND_ID", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    private static final String f384147a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59669);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        f384147a = uuid;
    }

    @NotNull
    public static final SizeF a(float f16, int i3) {
        if (f16 <= 0.0f) {
            float f17 = i3;
            return new SizeF(f17, f17, null, 4, null);
        }
        if (f16 > 1.0f) {
            float f18 = i3;
            return new SizeF(f18, f18 / f16, null, 4, null);
        }
        float f19 = i3;
        return new SizeF(f19 * f16, f19, null, 4, null);
    }

    @NotNull
    public static final BackgroundModel b(@NotNull SizeF renderSize, float f16, @Nullable BackgroundModel backgroundModel) {
        String str;
        String str2;
        BackgroundFillMode backgroundFillMode;
        Intrinsics.checkNotNullParameter(renderSize, "renderSize");
        if (backgroundModel == null || (str = backgroundModel.id) == null) {
            str = f384147a;
        }
        String str3 = str;
        RatioType type = RatioTypeEnum.ORIGINAL.getType();
        if (backgroundModel == null || (str2 = backgroundModel.bgColor) == null) {
            str2 = "#ff000000";
        }
        String str4 = str2;
        if (backgroundModel == null || (backgroundFillMode = backgroundModel.bgFillMode) == null) {
            backgroundFillMode = BackgroundFillMode.SOLID_COLOR;
        }
        return new BackgroundModel(str3, renderSize, backgroundFillMode, str4, null, type, null, null, f16, 0, null, 1744, null);
    }

    public static /* synthetic */ BackgroundModel c(SizeF sizeF, float f16, BackgroundModel backgroundModel, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f16 = 1.0f;
        }
        if ((i3 & 4) != 0) {
            backgroundModel = null;
        }
        return b(sizeF, f16, backgroundModel);
    }

    @Nullable
    public static final BackgroundModel d(@NotNull List<? extends MediaClip> videos, float f16, @Nullable BackgroundModel backgroundModel) {
        String str;
        String str2;
        BackgroundFillMode backgroundFillMode;
        Intrinsics.checkNotNullParameter(videos, "videos");
        SizeF i3 = i(videos);
        if (i3 != null) {
            if (backgroundModel == null || (str = backgroundModel.id) == null) {
                str = f384147a;
            }
            String str3 = str;
            RatioType type = RatioTypeEnum.ORIGINAL.getType();
            if (backgroundModel == null || (str2 = backgroundModel.bgColor) == null) {
                str2 = "#ff000000";
            }
            String str4 = str2;
            if (backgroundModel == null || (backgroundFillMode = backgroundModel.bgFillMode) == null) {
                backgroundFillMode = BackgroundFillMode.SOLID_COLOR;
            }
            return new BackgroundModel(str3, i3, backgroundFillMode, str4, null, type, null, null, f16, 0, null, 1744, null);
        }
        return null;
    }

    public static /* synthetic */ BackgroundModel e(List list, float f16, BackgroundModel backgroundModel, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f16 = 1.0f;
        }
        if ((i3 & 4) != 0) {
            backgroundModel = null;
        }
        return d(list, f16, backgroundModel);
    }

    @Nullable
    public static final BackgroundModel f(@NotNull List<? extends MediaClip> videos, float f16, @Nullable BackgroundModel backgroundModel, boolean z16) {
        Object next;
        float f17;
        float f18;
        RectF rectF;
        RectF rectF2;
        ResourceModel resourceModel;
        RectF rectF3;
        SizeF sizeF;
        BackgroundModel copy;
        BackgroundModel copy2;
        Intrinsics.checkNotNullParameter(videos, "videos");
        Iterator<T> it = videos.iterator();
        if (!it.hasNext()) {
            next = null;
        } else {
            next = it.next();
            if (it.hasNext()) {
                ResourceModel resourceModel2 = ((MediaClip) next).resource;
                if (resourceModel2 != null && (rectF2 = resourceModel2.picClipRect) != null) {
                    f17 = h(rectF2);
                } else {
                    f17 = 500.0f;
                }
                do {
                    Object next2 = it.next();
                    ResourceModel resourceModel3 = ((MediaClip) next2).resource;
                    if (resourceModel3 != null && (rectF = resourceModel3.picClipRect) != null) {
                        f18 = h(rectF);
                    } else {
                        f18 = 500.0f;
                    }
                    if (Float.compare(f17, f18) > 0) {
                        next = next2;
                        f17 = f18;
                    }
                } while (it.hasNext());
            }
        }
        MediaClip mediaClip = (MediaClip) next;
        if (mediaClip == null || (resourceModel = mediaClip.resource) == null || (rectF3 = resourceModel.picClipRect) == null) {
            return null;
        }
        float h16 = h(rectF3);
        if (z16) {
            if (backgroundModel != null) {
                copy2 = backgroundModel.copy((r24 & 1) != 0 ? backgroundModel.id : null, (r24 & 2) != 0 ? backgroundModel.renderSize : null, (r24 & 4) != 0 ? backgroundModel.bgFillMode : null, (r24 & 8) != 0 ? backgroundModel.bgColor : null, (r24 & 16) != 0 ? backgroundModel.bgPagPath : null, (r24 & 32) != 0 ? backgroundModel.ratioType : null, (r24 & 64) != 0 ? backgroundModel.resPack : null, (r24 & 128) != 0 ? backgroundModel.categoryId : null, (r24 & 256) != 0 ? backgroundModel.fillScale : 0.0f, (r24 & 512) != 0 ? backgroundModel.imageEffect : 0, (r24 & 1024) != 0 ? backgroundModel.unknownFields() : null);
                return copy2;
            }
            return null;
        }
        Size b16 = com.tencent.mobileqq.wink.editor.util.m.f322645a.b();
        if (h16 > 0.6666667f) {
            w53.b.f("[createRenderSizeChangedBackgroundModel]", ">2:3 newRenderSize = " + b16.width + " " + b16.height);
            sizeF = new SizeF((float) b16.width, (float) b16.height, null, 4, null);
        } else {
            w53.b.f("[createRenderSizeChangedBackgroundModel]", "<2:3 newRenderSize = " + b16.width + " " + b16.height);
            if (b16.width / h16 > 1920.0f) {
                sizeF = new SizeF(1920 * h16, 1920.0f, null, 4, null);
            } else {
                int i3 = b16.width;
                sizeF = new SizeF(i3, i3 / h16, null, 4, null);
            }
        }
        if (backgroundModel != null) {
            copy = backgroundModel.copy((r24 & 1) != 0 ? backgroundModel.id : null, (r24 & 2) != 0 ? backgroundModel.renderSize : sizeF, (r24 & 4) != 0 ? backgroundModel.bgFillMode : null, (r24 & 8) != 0 ? backgroundModel.bgColor : null, (r24 & 16) != 0 ? backgroundModel.bgPagPath : null, (r24 & 32) != 0 ? backgroundModel.ratioType : null, (r24 & 64) != 0 ? backgroundModel.resPack : null, (r24 & 128) != 0 ? backgroundModel.categoryId : null, (r24 & 256) != 0 ? backgroundModel.fillScale : f16, (r24 & 512) != 0 ? backgroundModel.imageEffect : 0, (r24 & 1024) != 0 ? backgroundModel.unknownFields() : null);
            return copy;
        }
        return null;
    }

    public static /* synthetic */ BackgroundModel g(List list, float f16, BackgroundModel backgroundModel, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f16 = 1.0f;
        }
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        return f(list, f16, backgroundModel, z16);
    }

    private static final float h(RectF rectF) {
        return Math.abs(((rectF.right - rectF.left) * 1.0f) / (rectF.bottom - rectF.top));
    }

    @Nullable
    public static final SizeF i(@NotNull List<? extends MediaClip> videos) {
        Object firstOrNull;
        ResourceModel resourceModel;
        SizeF sizeF;
        Intrinsics.checkNotNullParameter(videos, "videos");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) videos);
        MediaClip mediaClip = (MediaClip) firstOrNull;
        if (mediaClip != null && (resourceModel = mediaClip.resource) != null && (sizeF = resourceModel.size) != null) {
            float f16 = sizeF.height;
            if (f16 > 0.0f) {
                return a(sizeF.width / f16, j());
            }
            return null;
        }
        return null;
    }

    private static final int j() {
        com.tencent.mobileqq.wink.editor.util.m mVar = com.tencent.mobileqq.wink.editor.util.m.f322645a;
        return Math.max(mVar.b().width, mVar.b().height);
    }
}
