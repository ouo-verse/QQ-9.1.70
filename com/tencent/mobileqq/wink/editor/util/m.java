package com.tencent.mobileqq.wink.editor.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.ads.data.AdParam;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.RectF;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.device.OfflineConfig;
import org.light.lightAssetKit.components.Size;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\u0014\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u001e\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\r2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0015\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017J\u0016\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004J$\u0010\"\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002J\u0014\u0010#\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u0006\u0010$\u001a\u00020\u0019R\u0016\u0010&\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010%R\u0016\u0010(\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010%R$\u0010.\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b8B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00101\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b8B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/m;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/videocut/model/SizeF;", "o", "Landroid/content/Context;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "width", "height", "Lkotlin/Pair;", "a", "g", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "t", "l", "Lcom/tencent/videocut/model/MediaModel;", "mediaModel", "Lorg/light/lightAssetKit/components/Size;", "j", "k", "renderSize", AdParam.SCREENSIZE, "p", "", "Lcom/tencent/videocut/model/MediaClip;", "clips", "d", "c", "b", "I", "screenHeight", "screenWidth", "statusBarHeight", "value", "e", "()I", "r", "(I)V", "playerHeight", "i", ReportConstant.COSTREPORT_PREFIX, "playerWidth", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int screenHeight;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int screenWidth;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f322645a = new m();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int statusBarHeight = DisplayUtil.getTopHeight(BaseApplication.getContext());

    m() {
    }

    private final Pair<Integer, Integer> a(float width, float height) {
        Pair h16 = h(this, null, 1, null);
        int intValue = ((Number) h16.component1()).intValue();
        int intValue2 = ((Number) h16.component2()).intValue();
        if (3 * width <= 2 * height) {
            int i3 = (int) ((intValue * height) / width);
            if (i3 < intValue2) {
                intValue = (int) ((width * intValue2) / height);
            } else {
                intValue2 = i3;
            }
            return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf((int) (intValue * q())));
    }

    private final int e() {
        return AECameraPrefsUtil.c().d("sp_key_player_height", 0, 0);
    }

    @JvmStatic
    public static final int f(@Nullable Context context) {
        return f322645a.g(context).getSecond().intValue();
    }

    public static /* synthetic */ Pair h(m mVar, Context context, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            context = null;
        }
        return mVar.g(context);
    }

    private final int i() {
        return AECameraPrefsUtil.c().d("sp_key_player_width", 0, 0);
    }

    @JvmStatic
    public static final int m(@Nullable Context context) {
        if (statusBarHeight <= 0 && context != null) {
            statusBarHeight = DisplayUtil.getTopHeight(context);
        }
        return statusBarHeight;
    }

    public static /* synthetic */ int n(Context context, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            context = null;
        }
        return m(context);
    }

    @JvmStatic
    @NotNull
    public static final SizeF o() {
        m mVar = f322645a;
        return new SizeF(mVar.i(), mVar.e(), null, 4, null);
    }

    private final float q() {
        if (e() != 0 && e() != 0) {
            return e() / i();
        }
        return 1.7777778f;
    }

    private final void r(int i3) {
        AECameraPrefsUtil.c().i("sp_key_player_height", i3, 0);
    }

    private final void s(int i3) {
        AECameraPrefsUtil.c().i("sp_key_player_width", i3, 0);
    }

    @NotNull
    public final Size b() {
        int roundToInt;
        int roundToInt2;
        boolean z16;
        if (u53.i.f438433f == null) {
            int phonePerfLevel = OfflineConfig.getPhonePerfLevel(BaseApplication.getContext());
            int highQualityEditDeviceLevel = QzoneConfig.getHighQualityEditDeviceLevel();
            if (phonePerfLevel >= highQualityEditDeviceLevel) {
                z16 = true;
            } else {
                z16 = false;
            }
            u53.i.f438433f = Boolean.valueOf(z16);
            w53.b.c("WinkEditorRenderSizeHelper", "[wns][getDefaultMediaSize] phoneLevel=" + phonePerfLevel + ", highQualityDeviceLevel=" + highQualityEditDeviceLevel);
        }
        Boolean isOpenHighQualityEdit = u53.i.f438433f;
        Intrinsics.checkNotNullExpressionValue(isOpenHighQualityEdit, "isOpenHighQualityEdit");
        if (isOpenHighQualityEdit.booleanValue()) {
            w53.b.c("WinkEditorRenderSizeHelper", "[wns][getDefaultMediaSize] return 1080p");
            roundToInt2 = MathKt__MathJVMKt.roundToInt(q() * 1080);
            return new Size(1080, roundToInt2);
        }
        float q16 = q();
        w53.b.c("WinkEditorRenderSizeHelper", "[wns][getDefaultMediaSize] return 720p");
        roundToInt = MathKt__MathJVMKt.roundToInt(q16 * 720);
        return new Size(720, roundToInt);
    }

    @NotNull
    public final SizeF c(@NotNull List<? extends MediaClip> clips) {
        Object next;
        float f16;
        SizeF sizeF;
        float f17;
        SizeF sizeF2;
        RectF rectF;
        RectF rectF2;
        RectF rectF3;
        Intrinsics.checkNotNullParameter(clips, "clips");
        Iterator<T> it = clips.iterator();
        SizeF sizeF3 = null;
        if (!it.hasNext()) {
            next = null;
        } else {
            next = it.next();
            if (it.hasNext()) {
                ResourceModel resourceModel = ((MediaClip) next).resource;
                if (resourceModel != null && (rectF2 = resourceModel.picClipRect) != null) {
                    f16 = Math.abs((rectF2.bottom - rectF2.top) / (rectF2.right - rectF2.left));
                } else if (resourceModel != null && (sizeF = resourceModel.size) != null) {
                    f16 = Math.abs(sizeF.height / sizeF.width);
                } else {
                    f16 = 0.0f;
                }
                do {
                    Object next2 = it.next();
                    ResourceModel resourceModel2 = ((MediaClip) next2).resource;
                    if (resourceModel2 != null && (rectF = resourceModel2.picClipRect) != null) {
                        f17 = Math.abs((rectF.bottom - rectF.top) / (rectF.right - rectF.left));
                    } else if (resourceModel2 != null && (sizeF2 = resourceModel2.size) != null) {
                        f17 = Math.abs(sizeF2.height / sizeF2.width);
                    } else {
                        f17 = 0.0f;
                    }
                    if (Float.compare(f16, f17) < 0) {
                        next = next2;
                        f16 = f17;
                    }
                } while (it.hasNext());
            }
        }
        MediaClip mediaClip = (MediaClip) next;
        if (mediaClip != null) {
            ResourceModel resourceModel3 = mediaClip.resource;
            if (resourceModel3 != null && (rectF3 = resourceModel3.picClipRect) != null) {
                return new SizeF(rectF3.right - rectF3.left, rectF3.bottom - rectF3.top, null, 4, null);
            }
            if (resourceModel3 != null) {
                sizeF3 = resourceModel3.size;
            }
            if (sizeF3 == null) {
                return new SizeF(0.0f, 0.0f, null, 7, null);
            }
            return sizeF3;
        }
        return new SizeF(0.0f, 0.0f, null, 7, null);
    }

    @NotNull
    public final SizeF d(@NotNull List<? extends MediaClip> clips, float width, float height) {
        boolean z16;
        Intrinsics.checkNotNullParameter(clips, "clips");
        float f16 = width;
        float f17 = height;
        for (MediaClip mediaClip : clips) {
            boolean z17 = true;
            if (com.tencent.videocut.render.extension.e.o(mediaClip).width == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (com.tencent.videocut.render.extension.e.o(mediaClip).height != 0.0f) {
                    z17 = false;
                }
                if (!z17 && (com.tencent.videocut.render.extension.e.o(mediaClip).width * 1.0f) / com.tencent.videocut.render.extension.e.o(mediaClip).height < (1.0f * f16) / f17) {
                    f16 = com.tencent.videocut.render.extension.e.o(mediaClip).width;
                    f17 = com.tencent.videocut.render.extension.e.o(mediaClip).height;
                }
            }
        }
        return new SizeF(f16, f17, null, 4, null);
    }

    @NotNull
    public final Pair<Integer, Integer> g(@Nullable Context context) {
        int dimensionPixelSize = MobileQQ.sMobileQQ.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.dje);
        int m3 = (screenHeight - dimensionPixelSize) - m(context);
        int i3 = screenWidth;
        if (m3 > 0 && i3 > 0) {
            r(m3);
            s(i3);
            return new Pair<>(Integer.valueOf(i3), Integer.valueOf(m3));
        }
        if (i() > 0 && e() > 0) {
            return new Pair<>(Integer.valueOf(i()), Integer.valueOf(e()));
        }
        return new Pair<>(Integer.valueOf(DisplayUtil.getScreenWidth()), Integer.valueOf((DisplayUtil.getScreenHeight() - dimensionPixelSize) - statusBarHeight));
    }

    @NotNull
    public final Size j(@NotNull MediaModel mediaModel) {
        SizeF o16;
        float f16;
        SizeF sizeF;
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        BackgroundModel backgroundModel = mediaModel.backgroundModel;
        if (backgroundModel == null || (o16 = backgroundModel.renderSize) == null) {
            o16 = com.tencent.videocut.render.extension.e.o(mediaModel.videos.get(0));
        }
        float f17 = o16.width;
        BackgroundModel backgroundModel2 = mediaModel.backgroundModel;
        if (backgroundModel2 != null && (sizeF = backgroundModel2.renderSize) != null) {
            f16 = sizeF.height;
        } else {
            f16 = com.tencent.videocut.render.extension.e.o(mediaModel.videos.get(0)).height;
        }
        SizeF d16 = d(mediaModel.videos, f17, f16);
        Pair<Integer, Integer> a16 = a(d16.width, d16.height);
        return new Size(a16.getFirst().intValue(), a16.getSecond().intValue());
    }

    @NotNull
    public final Size k(@NotNull MediaModel mediaModel) {
        SizeF o16;
        float f16;
        SizeF sizeF;
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        BackgroundModel backgroundModel = mediaModel.backgroundModel;
        if (backgroundModel == null || (o16 = backgroundModel.renderSize) == null) {
            o16 = com.tencent.videocut.render.extension.e.o(mediaModel.videos.get(0));
        }
        float f17 = o16.width;
        BackgroundModel backgroundModel2 = mediaModel.backgroundModel;
        if (backgroundModel2 != null && (sizeF = backgroundModel2.renderSize) != null) {
            f16 = sizeF.height;
        } else {
            f16 = com.tencent.videocut.render.extension.e.o(mediaModel.videos.get(0)).height;
        }
        SizeF d16 = d(mediaModel.videos, f17, f16);
        return new Size((int) d16.width, (int) d16.height);
    }

    public final int l() {
        if (RFWApplication.getApplication().getResources().getConfiguration().orientation == 2) {
            return RFWApplication.getApplication().getResources().getDisplayMetrics().heightPixels;
        }
        return RFWApplication.getApplication().getResources().getDisplayMetrics().widthPixels;
    }

    @NotNull
    public final SizeF p(@NotNull SizeF renderSize, @NotNull SizeF screenSize) {
        Pair pair;
        Pair pair2;
        Intrinsics.checkNotNullParameter(renderSize, "renderSize");
        Intrinsics.checkNotNullParameter(screenSize, "screenSize");
        float f16 = renderSize.width;
        float f17 = 3;
        float f18 = f16 * f17;
        float f19 = renderSize.height;
        if (f18 < f19) {
            pair2 = new Pair(Float.valueOf(screenSize.height * (f16 / f19)), Float.valueOf(screenSize.height));
        } else {
            if (f17 * f16 <= 2 * f19) {
                float f26 = screenSize.width;
                float f27 = screenSize.height;
                if (f26 / f27 < f16 / f19) {
                    pair2 = new Pair(Float.valueOf(f27 * (f16 / f19)), Float.valueOf(screenSize.height));
                } else {
                    pair = new Pair(Float.valueOf(f26), Float.valueOf(screenSize.width / (renderSize.width / renderSize.height)));
                }
            } else {
                pair = new Pair(Float.valueOf(screenSize.width), Float.valueOf(screenSize.width / (renderSize.width / renderSize.height)));
            }
            pair2 = pair;
        }
        return new SizeF(((Number) pair2.component1()).floatValue(), ((Number) pair2.component2()).floatValue(), null, 4, null);
    }

    public final void t(@Nullable View rootView, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        screenWidth = l();
        int screenHeight2 = DisplayUtil.getScreenHeight(activity);
        screenHeight = screenHeight2;
        w53.b.a("WinkEditorRenderSizeHelper", "setScreenSize screenWidth " + screenWidth + " screenHeight " + screenHeight2);
        if (rootView != null) {
            w53.b.c("WinkEditorRenderSizeHelper", "rootWidth=" + rootView.getWidth() + ", rootHeight=" + rootView.getHeight() + ", screenWidth=" + screenWidth + ", screenHeight=" + screenHeight);
        }
    }
}
