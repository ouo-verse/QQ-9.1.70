package com.tencent.richframework.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.core.view.ScrollingView;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.biz.richframework.util.RFWImageUtil;
import com.tencent.biz.richframework.util.RFWNetworkUtils;
import com.tencent.mobileqq.R;
import com.tencent.richframework.gallery.anim.RFWTransAnimBean;
import com.tencent.richframework.gallery.anim.TransitionAnimUtil;
import com.tencent.richframework.gallery.bean.RFWLayerInitBean;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.datacenter.ExtraDataStore;
import com.tencent.richframework.gallery.datacenter.ExtraDataWrapper;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\\\u0010\u0012\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0007Jf\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0007JD\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u001e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007J\u001a\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u001eH\u0002J.\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010\u001c\u001a\u00020\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010'\u001a\u00020&H\u0007J\u0018\u0010+\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u0005H\u0007\u00a8\u0006."}, d2 = {"Lcom/tencent/richframework/gallery/RFWLayerLaunchUtil;", "", "Landroid/widget/ImageView;", "imageView", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "allMediaInfo", "", "currentIndex", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/activity/CompatPublicActivity;", "activityClass", "Lcom/tencent/richframework/gallery/RFWLayerFragment;", "fragmentClass", "Landroid/os/Bundle;", "customBundle", "requestCode", "", "jumpToGallery", "Landroid/content/Context;", "context", "Lcom/tencent/biz/richframework/compat/CompatPublicFragment;", "Lkotlin/Triple;", "Landroid/content/Intent;", "Ljava/util/UUID;", "generateLaunchIntent", "bundle", "addExtraDataToStore", "uuid", "storeGlobalParams", "Landroid/view/View;", "targetView", "getAllParentScrollableView", "view", "Landroid/graphics/Rect;", "getViewRect", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;", "picInfo", "", "withVisibleCheck", "Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean;", "getTransAnimBean", "enterMediaInfo", "isEnterDrawableHasCut", "<init>", "()V", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerLaunchUtil {

    @NotNull
    public static final RFWLayerLaunchUtil INSTANCE = new RFWLayerLaunchUtil();

    RFWLayerLaunchUtil() {
    }

    @JvmStatic
    public static final void addExtraDataToStore(@NotNull Bundle bundle, @NotNull List<? extends RFWLayerItemMediaInfo> allMediaInfo) {
        String mediaId;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(allMediaInfo, "allMediaInfo");
        ExtraDataStore extraDataStore = new ExtraDataStore();
        for (RFWLayerItemMediaInfo rFWLayerItemMediaInfo : allMediaInfo) {
            Object extraData = rFWLayerItemMediaInfo.getExtraData();
            if (extraData != null && (mediaId = rFWLayerItemMediaInfo.getMediaId()) != null) {
                extraDataStore.addData(new ExtraDataWrapper(mediaId, extraData));
            }
        }
        String valueOf = String.valueOf(extraDataStore.getStoreTag());
        RFWLayerDataCenter.INSTANCE.addDataStore(valueOf, extraDataStore);
        bundle.putString("EXTRA_STORE_KEY", valueOf);
    }

    private final Triple<Intent, RFWLayerItemMediaInfo, UUID> generateLaunchIntent(int currentIndex, List<? extends RFWLayerItemMediaInfo> allMediaInfo, ImageView imageView, Bundle customBundle) {
        RFWTransAnimBean transitionBean;
        Intent intent = new Intent();
        RFWLayerInitBean rFWLayerInitBean = new RFWLayerInitBean();
        rFWLayerInitBean.setEnterPos(currentIndex);
        rFWLayerInitBean.setRichMediaDataList(allMediaInfo);
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = allMediaInfo.get(currentIndex);
        UUID uuid = UUID.randomUUID();
        if (imageView != null) {
            Object tag = imageView.getTag(R.id.f100755tc);
            if (tag instanceof Integer) {
                rFWLayerInitBean.setMTransAnimBeanCreatorId(((Number) tag).intValue());
            }
            Intrinsics.checkNotNullExpressionValue(uuid, "uuid");
            rFWLayerInitBean.setTransitionBean(getTransAnimBean(uuid, imageView, allMediaInfo.get(currentIndex).getLayerPicInfo(), false));
            if (customBundle != null && (transitionBean = rFWLayerInitBean.getTransitionBean()) != null) {
                transitionBean.setCarvedAnimOpen(customBundle.getBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN));
            }
            Object tag2 = imageView.getTag(R.id.xs5);
            if (tag2 instanceof Boolean) {
                intent.putExtra(RFWLaunchKey.KEY_IS_VIDEO_MUTE, ((Boolean) tag2).booleanValue());
            }
        }
        if (customBundle != null) {
            intent.putExtras(customBundle);
        }
        intent.putExtra(RFWLaunchKey.KEY_INIT_BEAN, rFWLayerInitBean);
        return new Triple<>(intent, rFWLayerItemMediaInfo, uuid);
    }

    private final List<View> getAllParentScrollableView(View targetView) {
        ArrayList arrayList = new ArrayList();
        Object parent = targetView.getParent();
        if (parent instanceof ScrollingView) {
            arrayList.add((View) parent);
        } else if (parent instanceof View) {
            arrayList.addAll(getAllParentScrollableView((View) parent));
        }
        return arrayList;
    }

    @JvmStatic
    @Nullable
    public static final RFWTransAnimBean getTransAnimBean(@NotNull UUID uuid, @Nullable ImageView imageView, @Nullable RFWLayerPicInfo picInfo, boolean withVisibleCheck) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (imageView == null || imageView.getDrawable() == null || (imageView.getDrawable() instanceof ColorDrawable)) {
            return null;
        }
        RFWLayerLaunchUtil rFWLayerLaunchUtil = INSTANCE;
        Rect viewRect = rFWLayerLaunchUtil.getViewRect(imageView);
        RFWLog.i("RFWLayerLaunchUtil", RFWLog.USR, "imageViewRect:" + viewRect);
        int width = viewRect.left + (viewRect.width() / 2);
        int height = viewRect.top + (viewRect.height() / 2);
        if (withVisibleCheck) {
            List<View> allParentScrollableView = rFWLayerLaunchUtil.getAllParentScrollableView(imageView);
            if (!allParentScrollableView.isEmpty()) {
                Iterator<View> it = allParentScrollableView.iterator();
                while (it.hasNext()) {
                    Rect viewRect2 = INSTANCE.getViewRect(it.next());
                    boolean contains = viewRect2.contains(width, height, width, height);
                    RFWLog.i("RFWLayerLaunchUtil", RFWLog.USR, "scrollViewRect:" + viewRect2 + " isVisibleHalf:" + contains);
                    if (!contains) {
                        return null;
                    }
                }
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Object systemService = imageView.getContext().getSystemService("window");
                if (systemService != null) {
                    ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
                    Rect rect = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
                    boolean contains2 = rect.contains(width, height, width, height);
                    RFWLog.i("RFWLayerLaunchUtil", RFWLog.USR, "visibleFrame:" + rect + " isVisibleHalf:" + contains2);
                    if (!contains2) {
                        return null;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
                }
            }
        }
        INSTANCE.storeGlobalParams(uuid, imageView);
        Rect imageVisibleRect = RFWImageUtil.getImageVisibleRect(imageView, imageView.getScaleType());
        Intrinsics.checkNotNullExpressionValue(imageVisibleRect, "RFWImageUtil.getImageVis\u2026iew, imageView.scaleType)");
        return new RFWTransAnimBean().setLayoutRect(new RFWTransAnimBean.SourceRect(viewRect.left, viewRect.top, viewRect.right, viewRect.bottom)).setUUid(uuid).setImageRect(new RFWTransAnimBean.SourceRect(imageVisibleRect)).setScaleType(imageView.getScaleType()).setLayerPicInfo(picInfo).setTransitionDelayTimeMs(0).setTransitionDurationMs(150).setFadeCoverTimeMs(0);
    }

    private final Rect getViewRect(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        return new Rect(i3, iArr[1], view.getWidth() + i3, iArr[1] + view.getHeight());
    }

    @JvmStatic
    public static final boolean isEnterDrawableHasCut(@NotNull UUID uuid, @NotNull RFWLayerItemMediaInfo enterMediaInfo) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(enterMediaInfo, "enterMediaInfo");
        TransitionAnimUtil.TransViewAndDrawable transViewAndDrawable = TransitionAnimUtil.INSTANCE.getTransViewAndDrawable(uuid);
        if (!(transViewAndDrawable.getCoverDrawable() instanceof BitmapDrawable) || enterMediaInfo.getLayerPicInfo() == null) {
            return false;
        }
        Drawable coverDrawable = transViewAndDrawable.getCoverDrawable();
        if (coverDrawable != null) {
            Bitmap enterBitmap = ((BitmapDrawable) coverDrawable).getBitmap();
            Intrinsics.checkNotNullExpressionValue(enterBitmap, "enterBitmap");
            int height = enterBitmap.getHeight();
            int width = enterBitmap.getWidth();
            float f16 = (height * 1.0f) / width;
            RFWLayerPicInfo layerPicInfo = enterMediaInfo.getLayerPicInfo();
            Intrinsics.checkNotNull(layerPicInfo);
            int height2 = layerPicInfo.getCurrentPicInfo().getHeight();
            RFWLayerPicInfo layerPicInfo2 = enterMediaInfo.getLayerPicInfo();
            Intrinsics.checkNotNull(layerPicInfo2);
            int width2 = layerPicInfo2.getCurrentPicInfo().getWidth();
            if (height2 == 0 || width2 == 0) {
                return false;
            }
            float f17 = (height2 * 1.0f) / width2;
            RFWLog.i("RFWLayerLaunchUtil", RFWLog.USR, " preHeight:" + height + ", preWidth: " + width + ", targetHeight:" + height2 + " targetWidth:" + width2);
            if (Math.abs(f17 - f16) <= 0.01f) {
                return false;
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
    }

    @JvmStatic
    @JvmOverloads
    public static final void jumpToGallery(@Nullable Context context, @Nullable ImageView imageView, @NotNull List<? extends RFWLayerItemMediaInfo> list, int i3, @NotNull Class<? extends CompatPublicActivity> cls, @NotNull Class<? extends CompatPublicFragment> cls2, @Nullable Bundle bundle) {
        jumpToGallery$default(context, imageView, list, i3, cls, cls2, bundle, 0, 128, null);
    }

    public static /* synthetic */ void jumpToGallery$default(ImageView imageView, List list, int i3, Class cls, Class cls2, Bundle bundle, int i16, int i17, Object obj) {
        if ((i17 & 64) != 0) {
            i16 = Integer.MIN_VALUE;
        }
        jumpToGallery(imageView, (List<? extends RFWLayerItemMediaInfo>) list, i3, (Class<? extends CompatPublicActivity>) cls, (Class<? extends RFWLayerFragment>) cls2, bundle, i16);
    }

    private final void storeGlobalParams(UUID uuid, ImageView imageView) {
        if (imageView != null) {
            TransitionAnimUtil.TransViewAndDrawable transViewAndDrawable = TransitionAnimUtil.INSTANCE.getTransViewAndDrawable(uuid);
            transViewAndDrawable.setEnterImageView(imageView);
            transViewAndDrawable.saveCoverDrawable(imageView.getDrawable());
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void jumpToGallery(@Nullable ImageView imageView, @NotNull List<? extends RFWLayerItemMediaInfo> list, int i3, @NotNull Class<? extends CompatPublicActivity> cls, @NotNull Class<? extends RFWLayerFragment> cls2, @Nullable Bundle bundle) {
        jumpToGallery$default(imageView, list, i3, cls, cls2, bundle, 0, 64, null);
    }

    public static /* synthetic */ void jumpToGallery$default(Context context, ImageView imageView, List list, int i3, Class cls, Class cls2, Bundle bundle, int i16, int i17, Object obj) {
        jumpToGallery(context, imageView, list, i3, cls, cls2, bundle, (i17 & 128) != 0 ? Integer.MIN_VALUE : i16);
    }

    @JvmStatic
    @JvmOverloads
    public static final void jumpToGallery(@Nullable ImageView imageView, @NotNull List<? extends RFWLayerItemMediaInfo> allMediaInfo, int currentIndex, @NotNull Class<? extends CompatPublicActivity> activityClass, @NotNull Class<? extends RFWLayerFragment> fragmentClass, @Nullable Bundle customBundle, int requestCode) {
        Intrinsics.checkNotNullParameter(allMediaInfo, "allMediaInfo");
        Intrinsics.checkNotNullParameter(activityClass, "activityClass");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        jumpToGallery(imageView != null ? imageView.getContext() : null, imageView, allMediaInfo, currentIndex, activityClass, fragmentClass, customBundle, requestCode);
    }

    @JvmStatic
    @JvmOverloads
    public static final void jumpToGallery(@Nullable Context context, @Nullable ImageView imageView, @NotNull List<? extends RFWLayerItemMediaInfo> allMediaInfo, int currentIndex, @NotNull Class<? extends CompatPublicActivity> activityClass, @NotNull Class<? extends CompatPublicFragment> fragmentClass, @Nullable Bundle customBundle, int requestCode) {
        Intrinsics.checkNotNullParameter(allMediaInfo, "allMediaInfo");
        Intrinsics.checkNotNullParameter(activityClass, "activityClass");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        if (FastClickUtils.isFastDoubleClick("RFWLayerLaunchUtil")) {
            return;
        }
        Triple<Intent, RFWLayerItemMediaInfo, UUID> generateLaunchIntent = INSTANCE.generateLaunchIntent(currentIndex, allMediaInfo, imageView, customBundle);
        Intent component1 = generateLaunchIntent.component1();
        RFWLayerItemMediaInfo component2 = generateLaunchIntent.component2();
        UUID component3 = generateLaunchIntent.component3();
        if (requestCode != Integer.MIN_VALUE) {
            if (context instanceof Activity) {
                CompatPublicActivity.Launcher.startForResult((Activity) context, component1, activityClass, fragmentClass, requestCode);
            } else {
                throw new RuntimeException("requestCode is :" + requestCode + ", except context is Activity, but is " + context);
            }
        } else {
            CompatPublicActivity.Launcher.start(context, component1, activityClass, fragmentClass);
        }
        if (context instanceof Activity) {
            if (imageView != null && (!isEnterDrawableHasCut(component3, component2) || RFWNetworkUtils.isNetworkAvailable(context))) {
                ((Activity) context).overridePendingTransition(0, 0);
            } else {
                ((Activity) context).overridePendingTransition(R.anim.f155044v5, R.anim.f155045v6);
            }
        }
    }
}
