package com.tencent.mobileqq.wink.picker.qcircle.sticker;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetBackgroundMaskRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.Rect;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.widget.Switch;
import e93.i;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 f2\u00020\u00012\u00020\u0002:\u0001gB\u0007\u00a2\u0006\u0004\bd\u0010eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\"\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\u001a\u0010#\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\"\u001a\u00020!H\u0002J(\u0010)\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'H\u0002J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0014H\u0002J\b\u0010,\u001a\u00020\u0005H\u0002R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R \u00104\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0019018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010/R\u001b\u0010?\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001d\u0010D\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010<\u001a\u0004\bB\u0010CR\u001d\u0010G\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010<\u001a\u0004\bF\u0010CR\u001d\u0010L\u001a\u0004\u0018\u00010H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010<\u001a\u0004\bJ\u0010KR\u001d\u0010P\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010<\u001a\u0004\bN\u0010OR\u001d\u0010S\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010<\u001a\u0004\bR\u0010OR\u001d\u0010X\u001a\u0004\u0018\u00010T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010<\u001a\u0004\bV\u0010WR\u001d\u0010[\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010<\u001a\u0004\bZ\u0010OR\u001d\u0010^\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\\\u0010<\u001a\u0004\b]\u0010OR\u001d\u0010c\u001a\u0004\u0018\u00010_8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b`\u0010<\u001a\u0004\ba\u0010b\u00a8\u0006h"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/sticker/QCircleMakeStickerMediaPreviewFragment;", "Lcom/tencent/mobileqq/wink/picker/core/fragment/WinkMediaPickerChildFragment;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "Landroid/content/Context;", "context", "", "onAttach", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "type", "", "isSuccess", "", "data", "onUpdate", "Landroid/graphics/Bitmap;", "resultBmp", "Zh", "bi", "Hh", "ci", "ai", "maskBitmap", "Lcamera/MOBILE_QQ_MATERIAL_INTERFACE/Rect;", CanvasView.ACTION_RECT, "Wh", "originBitmap", "imageWidth", "imageHeight", "", "maskPixels", "Lh", "success", "Fh", "Eh", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "E", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "currentMediaInfo", "", UserInfo.SEX_FEMALE, "Ljava/util/Map;", "customStickerResultCache", "G", "Landroid/graphics/Bitmap;", "previewBmp", "H", "customStickerResultMediaInfo", "Lcom/tencent/mobileqq/wink/picker/qcircle/sticker/QCircleMakeStickerPreviewServiceHandler;", "I", "Lkotlin/Lazy;", "Rh", "()Lcom/tencent/mobileqq/wink/picker/qcircle/sticker/QCircleMakeStickerPreviewServiceHandler;", "serviceHandler", "Landroid/widget/ImageView;", "J", "Oh", "()Landroid/widget/ImageView;", "previewerImg", "K", "Mh", "foregroundPreviewer", "Lcom/tencent/widget/Switch;", "L", "Qh", "()Lcom/tencent/widget/Switch;", "removeBackgroundSwitcher", "M", "Gh", "()Landroid/view/View;", "backBtn", "N", "Kh", "confirmButton", "Landroid/widget/TextView;", "P", "Ph", "()Landroid/widget/TextView;", "removeBackgroundBtn", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ih", "bottomLayout", BdhLogUtil.LogTag.Tag_Req, "Nh", "previewRvContainer", "Lcom/tencent/mobileqq/wink/picker/qcircle/sticker/RouteTraceView;", ExifInterface.LATITUDE_SOUTH, "Jh", "()Lcom/tencent/mobileqq/wink/picker/qcircle/sticker/RouteTraceView;", "boundTraceView", "<init>", "()V", "U", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleMakeStickerMediaPreviewFragment extends WinkMediaPickerChildFragment implements BusinessObserver {

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private LocalMediaInfo currentMediaInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Bitmap previewBmp;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private LocalMediaInfo customStickerResultMediaInfo;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy serviceHandler;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy previewerImg;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy foregroundPreviewer;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy removeBackgroundSwitcher;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy backBtn;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy confirmButton;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy removeBackgroundBtn;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy bottomLayout;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy previewRvContainer;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy boundTraceView;

    @NotNull
    public Map<Integer, View> T = new LinkedHashMap();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Map<LocalMediaInfo, Bitmap> customStickerResultCache = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/sticker/QCircleMakeStickerMediaPreviewFragment$a;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "previewMedia", "Lcom/tencent/mobileqq/wink/picker/qcircle/sticker/QCircleMakeStickerMediaPreviewFragment;", "a", "", "ARG_PREVIEW_MEDIA", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.qcircle.sticker.QCircleMakeStickerMediaPreviewFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QCircleMakeStickerMediaPreviewFragment a(@NotNull LocalMediaInfo previewMedia) {
            Intrinsics.checkNotNullParameter(previewMedia, "previewMedia");
            QCircleMakeStickerMediaPreviewFragment qCircleMakeStickerMediaPreviewFragment = new QCircleMakeStickerMediaPreviewFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("previewMedia", previewMedia);
            qCircleMakeStickerMediaPreviewFragment.setArguments(bundle);
            return qCircleMakeStickerMediaPreviewFragment;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/picker/qcircle/sticker/QCircleMakeStickerMediaPreviewFragment$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (QCircleMakeStickerMediaPreviewFragment.this.Oh() != null) {
                ImageView Oh = QCircleMakeStickerMediaPreviewFragment.this.Oh();
                if (Oh != null) {
                    Oh.setAlpha(1.0f);
                }
                ImageView Oh2 = QCircleMakeStickerMediaPreviewFragment.this.Oh();
                if (Oh2 != null) {
                    Oh2.setVisibility(4);
                }
                ImageView Mh = QCircleMakeStickerMediaPreviewFragment.this.Mh();
                if (Mh != null) {
                    Mh.setAlpha(1.0f);
                }
                View Kh = QCircleMakeStickerMediaPreviewFragment.this.Kh();
                if (Kh != null) {
                    Kh.setClickable(true);
                }
                Switch Qh = QCircleMakeStickerMediaPreviewFragment.this.Qh();
                if (Qh != null) {
                    Qh.setEnabled(true);
                }
                animation.removeAllListeners();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (QCircleMakeStickerMediaPreviewFragment.this.Oh() != null) {
                ImageView Oh = QCircleMakeStickerMediaPreviewFragment.this.Oh();
                if (Oh != null) {
                    Oh.setVisibility(4);
                }
                ImageView Oh2 = QCircleMakeStickerMediaPreviewFragment.this.Oh();
                if (Oh2 != null) {
                    Oh2.setAlpha(1.0f);
                }
                ImageView Mh = QCircleMakeStickerMediaPreviewFragment.this.Mh();
                if (Mh != null) {
                    Mh.setAlpha(1.0f);
                }
                View Kh = QCircleMakeStickerMediaPreviewFragment.this.Kh();
                if (Kh != null) {
                    Kh.setClickable(true);
                }
                Switch Qh = QCircleMakeStickerMediaPreviewFragment.this.Qh();
                if (Qh != null) {
                    Qh.setEnabled(true);
                }
                animation.removeAllListeners();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ImageView Mh = QCircleMakeStickerMediaPreviewFragment.this.Mh();
            if (Mh != null) {
                Mh.setAlpha(0.6f);
            }
            ImageView Mh2 = QCircleMakeStickerMediaPreviewFragment.this.Mh();
            if (Mh2 != null) {
                Mh2.setVisibility(0);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/picker/qcircle/sticker/QCircleMakeStickerMediaPreviewFragment$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (QCircleMakeStickerMediaPreviewFragment.this.Oh() != null) {
                ImageView Oh = QCircleMakeStickerMediaPreviewFragment.this.Oh();
                if (Oh != null) {
                    Oh.setAlpha(1.0f);
                }
                ImageView Oh2 = QCircleMakeStickerMediaPreviewFragment.this.Oh();
                if (Oh2 != null) {
                    Oh2.setVisibility(0);
                }
                View Kh = QCircleMakeStickerMediaPreviewFragment.this.Kh();
                if (Kh != null) {
                    Kh.setClickable(true);
                }
                Switch Qh = QCircleMakeStickerMediaPreviewFragment.this.Qh();
                if (Qh != null) {
                    Qh.setEnabled(true);
                }
                Switch Qh2 = QCircleMakeStickerMediaPreviewFragment.this.Qh();
                if (Qh2 != null) {
                    Qh2.setChecked(false);
                }
                animation.removeAllListeners();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (QCircleMakeStickerMediaPreviewFragment.this.Oh() != null) {
                ImageView Oh = QCircleMakeStickerMediaPreviewFragment.this.Oh();
                if (Oh != null) {
                    Oh.setAlpha(1.0f);
                }
                ImageView Oh2 = QCircleMakeStickerMediaPreviewFragment.this.Oh();
                if (Oh2 != null) {
                    Oh2.setVisibility(0);
                }
                View Kh = QCircleMakeStickerMediaPreviewFragment.this.Kh();
                if (Kh != null) {
                    Kh.setClickable(true);
                }
                Switch Qh = QCircleMakeStickerMediaPreviewFragment.this.Qh();
                if (Qh != null) {
                    Qh.setEnabled(true);
                }
                Switch Qh2 = QCircleMakeStickerMediaPreviewFragment.this.Qh();
                if (Qh2 != null) {
                    Qh2.setChecked(false);
                }
                animation.removeAllListeners();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ImageView Mh = QCircleMakeStickerMediaPreviewFragment.this.Mh();
            if (Mh != null) {
                Mh.setAlpha(0.6f);
            }
            ImageView Mh2 = QCircleMakeStickerMediaPreviewFragment.this.Mh();
            if (Mh2 != null) {
                Mh2.setVisibility(8);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/picker/qcircle/sticker/QCircleMakeStickerMediaPreviewFragment$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            View Kh = QCircleMakeStickerMediaPreviewFragment.this.Kh();
            if (Kh != null) {
                Kh.setClickable(true);
            }
            Switch Qh = QCircleMakeStickerMediaPreviewFragment.this.Qh();
            if (Qh != null) {
                Qh.setEnabled(true);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (QCircleMakeStickerMediaPreviewFragment.this.Oh() != null) {
                ImageView Oh = QCircleMakeStickerMediaPreviewFragment.this.Oh();
                if (Oh != null) {
                    Oh.setAlpha(0.6f);
                }
                QCircleMakeStickerMediaPreviewFragment.this.ai();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (QCircleMakeStickerMediaPreviewFragment.this.Oh() != null) {
                ImageView Oh = QCircleMakeStickerMediaPreviewFragment.this.Oh();
                if (Oh != null) {
                    Oh.setAlpha(1.0f);
                }
                View Kh = QCircleMakeStickerMediaPreviewFragment.this.Kh();
                if (Kh != null) {
                    Kh.setClickable(false);
                }
                Switch Qh = QCircleMakeStickerMediaPreviewFragment.this.Qh();
                if (Qh != null) {
                    Qh.setEnabled(false);
                }
            }
        }
    }

    public QCircleMakeStickerMediaPreviewFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QCircleMakeStickerPreviewServiceHandler>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.sticker.QCircleMakeStickerMediaPreviewFragment$serviceHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QCircleMakeStickerPreviewServiceHandler invoke() {
                BusinessHandler businessHandler = com.tencent.mobileqq.wink.b.a().getBusinessHandler(QCircleMakeStickerPreviewServiceHandler.class.getName());
                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wink.picker.qcircle.sticker.QCircleMakeStickerPreviewServiceHandler");
                return (QCircleMakeStickerPreviewServiceHandler) businessHandler;
            }
        });
        this.serviceHandler = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.sticker.QCircleMakeStickerMediaPreviewFragment$previewerImg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ImageView invoke() {
                View view = QCircleMakeStickerMediaPreviewFragment.this.getView();
                if (view != null) {
                    return (ImageView) view.findViewById(R.id.f27470gb);
                }
                return null;
            }
        });
        this.previewerImg = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.sticker.QCircleMakeStickerMediaPreviewFragment$foregroundPreviewer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ImageView invoke() {
                View view = QCircleMakeStickerMediaPreviewFragment.this.getView();
                if (view != null) {
                    return (ImageView) view.findViewById(R.id.vdu);
                }
                return null;
            }
        });
        this.foregroundPreviewer = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Switch>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.sticker.QCircleMakeStickerMediaPreviewFragment$removeBackgroundSwitcher$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Switch invoke() {
                View view = QCircleMakeStickerMediaPreviewFragment.this.getView();
                if (view != null) {
                    return (Switch) view.findViewById(R.id.f72833rx);
                }
                return null;
            }
        });
        this.removeBackgroundSwitcher = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.sticker.QCircleMakeStickerMediaPreviewFragment$backBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                View view = QCircleMakeStickerMediaPreviewFragment.this.getView();
                if (view != null) {
                    return view.findViewById(R.id.t2c);
                }
                return null;
            }
        });
        this.backBtn = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.sticker.QCircleMakeStickerMediaPreviewFragment$confirmButton$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                View view = QCircleMakeStickerMediaPreviewFragment.this.getView();
                if (view != null) {
                    return view.findViewById(R.id.b7n);
                }
                return null;
            }
        });
        this.confirmButton = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.sticker.QCircleMakeStickerMediaPreviewFragment$removeBackgroundBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final TextView invoke() {
                View view = QCircleMakeStickerMediaPreviewFragment.this.getView();
                if (view != null) {
                    return (TextView) view.findViewById(R.id.f72823rw);
                }
                return null;
            }
        });
        this.removeBackgroundBtn = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.sticker.QCircleMakeStickerMediaPreviewFragment$bottomLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                View view = QCircleMakeStickerMediaPreviewFragment.this.getView();
                if (view != null) {
                    return view.findViewById(R.id.abw);
                }
                return null;
            }
        });
        this.bottomLayout = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.sticker.QCircleMakeStickerMediaPreviewFragment$previewRvContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                View view = QCircleMakeStickerMediaPreviewFragment.this.getView();
                if (view != null) {
                    return view.findViewById(R.id.f27050f7);
                }
                return null;
            }
        });
        this.previewRvContainer = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<RouteTraceView>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.sticker.QCircleMakeStickerMediaPreviewFragment$boundTraceView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final RouteTraceView invoke() {
                View view = QCircleMakeStickerMediaPreviewFragment.this.getView();
                if (view != null) {
                    return (RouteTraceView) view.findViewById(R.id.tbb);
                }
                return null;
            }
        });
        this.boundTraceView = lazy10;
    }

    private final void Eh() {
        Iterator<Bitmap> it = this.customStickerResultCache.values().iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
        this.customStickerResultCache.clear();
        Bitmap bitmap = this.previewBmp;
        if (bitmap != null) {
            Intrinsics.checkNotNull(bitmap);
            if (!bitmap.isRecycled()) {
                Bitmap bitmap2 = this.previewBmp;
                Intrinsics.checkNotNull(bitmap2);
                bitmap2.recycle();
            }
        }
    }

    private final void Fh(boolean success) {
        int i3;
        RouteTraceView Jh = Jh();
        if (Jh != null) {
            Jh.setVisibility(8);
        }
        TextView Ph = Ph();
        if (Ph != null) {
            Ph.setText(R.string.f239037ld);
        }
        View Ih = Ih();
        if (Ih != null) {
            Ih.setAlpha(1.0f);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet animatorSet2 = new AnimatorSet();
        View Nh = Nh();
        int i16 = 0;
        if (Nh != null) {
            View Nh2 = Nh();
            if (Nh2 != null) {
                i3 = Nh2.getMeasuredWidth();
            } else {
                i3 = 0;
            }
            Nh.setPivotX(i3 / 2.0f);
        }
        View Nh3 = Nh();
        if (Nh3 != null) {
            View Nh4 = Nh();
            if (Nh4 != null) {
                i16 = Nh4.getMeasuredHeight();
            }
            Nh3.setPivotY(i16 / 2.0f);
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(Nh(), BasicAnimation.KeyPath.SCALE_X, 0.8f, 1.0f).setDuration(500L);
        Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(previewRvContain\u2026.8f, 1f).setDuration(500)");
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(Nh(), BasicAnimation.KeyPath.SCALE_Y, 0.8f, 1.0f).setDuration(500L);
        Intrinsics.checkNotNullExpressionValue(duration2, "ofFloat(previewRvContain\u2026.8f, 1f).setDuration(500)");
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(Mh(), com.tencent.luggage.wxa.c8.c.f123400v, 0.6f, 1.0f, 0.6f, 1.0f).setDuration(1500L);
        Intrinsics.checkNotNullExpressionValue(duration3, "ofFloat(foregroundPrevie\u20266f, 1f).setDuration(1500)");
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(Oh(), com.tencent.luggage.wxa.c8.c.f123400v, 0.6f, 0.0f).setDuration(500L);
        Intrinsics.checkNotNullExpressionValue(duration4, "ofFloat(previewerImg, \"a\u2026.6f, 0f).setDuration(500)");
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(Oh(), com.tencent.luggage.wxa.c8.c.f123400v, 0.6f, 1.0f).setDuration(500L);
        Intrinsics.checkNotNullExpressionValue(duration5, "ofFloat(previewerImg, \"a\u2026.6f, 1f).setDuration(500)");
        animatorSet.play(duration).with(duration2).after(duration4).after(duration3);
        animatorSet2.play(duration).with(duration2).after(duration5);
        duration4.addListener(new b());
        animatorSet2.addListener(new c());
        if (success) {
            animatorSet.start();
        } else {
            animatorSet2.start();
        }
    }

    private final View Gh() {
        return (View) this.backBtn.getValue();
    }

    private final void Hh() {
        String str;
        List<String> mutableListOf;
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(getContext(), R.string.f241287rg, 0).show();
            Switch Qh = Qh();
            if (Qh != null) {
                Qh.setChecked(false);
                return;
            }
            return;
        }
        ci();
        QCircleMakeStickerPreviewServiceHandler Rh = Rh();
        String[] strArr = new String[1];
        LocalMediaInfo localMediaInfo = this.currentMediaInfo;
        if (localMediaInfo != null) {
            str = localMediaInfo.path;
        } else {
            str = null;
        }
        strArr[0] = str;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(strArr);
        Rh.t3(mutableListOf);
    }

    private final View Ih() {
        return (View) this.bottomLayout.getValue();
    }

    private final RouteTraceView Jh() {
        return (RouteTraceView) this.boundTraceView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View Kh() {
        return (View) this.confirmButton.getValue();
    }

    private final Bitmap Lh(Bitmap originBitmap, int imageWidth, int imageHeight, int[] maskPixels) {
        Bitmap resultBitmap = Bitmap.createBitmap(imageWidth, imageHeight, Bitmap.Config.ARGB_8888);
        int[] iArr = new int[imageWidth * imageHeight];
        originBitmap.getPixels(iArr, 0, imageWidth, 0, 0, imageWidth, imageHeight);
        int length = maskPixels.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = maskPixels[i3];
            if (i16 == -16777216) {
                iArr[i3] = 0;
            } else {
                int argb = Color.argb((((Color.red(i16) * 38) + (Color.green(i16) * 75)) + (Color.blue(i16) * 15)) >> 7, 255, 255, 255);
                maskPixels[i3] = argb;
                iArr[i3] = argb & iArr[i3];
            }
        }
        resultBitmap.setPixels(iArr, 0, imageWidth, 0, 0, imageWidth, imageHeight);
        Intrinsics.checkNotNullExpressionValue(resultBitmap, "resultBitmap");
        return resultBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView Mh() {
        return (ImageView) this.foregroundPreviewer.getValue();
    }

    private final View Nh() {
        return (View) this.previewRvContainer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView Oh() {
        return (ImageView) this.previewerImg.getValue();
    }

    private final TextView Ph() {
        return (TextView) this.removeBackgroundBtn.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Switch Qh() {
        return (Switch) this.removeBackgroundSwitcher.getValue();
    }

    private final QCircleMakeStickerPreviewServiceHandler Rh() {
        return (QCircleMakeStickerPreviewServiceHandler) this.serviceHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(QCircleMakeStickerMediaPreviewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.getContext(), HardCodeUtil.qqStr(R.string.f240377p0), 0).show();
        this$0.Fh(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(QCircleMakeStickerMediaPreviewFragment this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            Bitmap bitmap = this$0.customStickerResultCache.get(this$0.currentMediaInfo);
            if (bitmap != null && !bitmap.isRecycled()) {
                this$0.Zh(bitmap);
            } else {
                this$0.Hh();
            }
        } else {
            this$0.bi();
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(QCircleMakeStickerMediaPreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(QCircleMakeStickerMediaPreviewFragment this$0, View view) {
        LocalMediaInfo localMediaInfo;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Switch Qh = this$0.Qh();
        boolean z16 = false;
        if (Qh != null && Qh.isChecked()) {
            z16 = true;
        }
        if (z16) {
            localMediaInfo = this$0.customStickerResultMediaInfo;
        } else {
            localMediaInfo = this$0.currentMediaInfo;
        }
        if (localMediaInfo != null) {
            Intent intent = new Intent();
            intent.putExtra(QQWinkConstants.CUSTOM_STICKER_PHOTO_PATH, localMediaInfo.path);
            intent.putExtra(QQWinkConstants.CUSTOM_STICKER_PHOTO_WIDTH, localMediaInfo.mediaWidth);
            intent.putExtra(QQWinkConstants.CUSTOM_STICKER_PHOTO_HEIGHT, localMediaInfo.mediaHeight);
            intent.putExtra(QQWinkConstants.CUSTOM_STICKER_IS_SEGMENT, localMediaInfo.isSegment);
            this$0.getHostActivity().setResult(-1, intent);
        }
        this$0.getHostActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Wh(Bitmap maskBitmap, Rect rect) {
        LocalMediaInfo localMediaInfo = this.currentMediaInfo;
        if (localMediaInfo == null) {
            return;
        }
        Bitmap c16 = com.tencent.mobileqq.wink.utils.f.c(localMediaInfo.path);
        int width = c16.getWidth();
        int height = c16.getHeight();
        Intrinsics.checkNotNull(maskBitmap);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(maskBitmap, width, height, false);
        int[] iArr = new int[width * height];
        createScaledBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        Bitmap Lh = Lh(c16, width, height, iArr);
        this.previewBmp = Lh;
        double d16 = width;
        int i3 = (int) (rect.ScaleOffsetX * d16);
        double d17 = height;
        int i16 = (int) (rect.ScaleOffsetY * d17);
        int i17 = (int) (d16 * rect.ScaleWidth);
        int i18 = (int) (d17 * rect.ScaleHeight);
        Intrinsics.checkNotNull(Lh);
        Bitmap createBitmap = Bitmap.createBitmap(Lh, i3, i16, i17, i18);
        if (i17 > i18) {
            height = (i18 * width) / i17;
        } else {
            width = (i17 * height) / i18;
        }
        Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(createBitmap, width, height, true);
        createBitmap.recycle();
        String str = u53.e.f438384a + File.separator + localMediaInfo._id + ".png";
        if (BitmapUtils.saveBitmap2PNG(createScaledBitmap2, str) == BitmapUtils.SAVE_STATUS.SAVE_SUCCESS) {
            LocalMediaInfo a16 = i.a(localMediaInfo);
            a16.path = str;
            a16.mediaWidth = width;
            a16.mediaHeight = height;
            a16.isSegment = true;
            this.customStickerResultMediaInfo = a16;
            Map<LocalMediaInfo, Bitmap> map = this.customStickerResultCache;
            Bitmap bitmap = this.previewBmp;
            Intrinsics.checkNotNull(bitmap);
            map.put(localMediaInfo, bitmap);
            getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.sticker.f
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleMakeStickerMediaPreviewFragment.Yh(QCircleMakeStickerMediaPreviewFragment.this);
                }
            });
        } else {
            w53.b.c("QCircleMakeStickerMediaPreviewFragment", "[setForegroundMask] save bitmap failed!");
            getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.sticker.g
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleMakeStickerMediaPreviewFragment.Xh(QCircleMakeStickerMediaPreviewFragment.this);
                }
            });
        }
        createScaledBitmap.recycle();
        c16.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(QCircleMakeStickerMediaPreviewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Fh(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(QCircleMakeStickerMediaPreviewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView Mh = this$0.Mh();
        if (Mh != null) {
            Bitmap bitmap = this$0.previewBmp;
            if (bitmap != null) {
                Mh.setImageBitmap(bitmap);
            }
            this$0.Fh(true);
        }
    }

    private final void Zh(Bitmap resultBmp) {
        ImageView Oh = Oh();
        if (Oh != null) {
            Oh.setVisibility(4);
        }
        ImageView Mh = Mh();
        if (Mh != null) {
            Mh.setVisibility(0);
        }
        ImageView Mh2 = Mh();
        if (Mh2 != null) {
            Mh2.setImageBitmap(resultBmp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai() {
        int i3;
        int i16;
        Matrix matrix;
        int i17;
        Drawable drawable;
        android.graphics.Rect bounds;
        Drawable drawable2;
        android.graphics.Rect bounds2;
        RouteTraceView Jh = Jh();
        int i18 = 0;
        if (Jh != null) {
            Jh.setVisibility(0);
        }
        ImageView Oh = Oh();
        if (Oh != null && (drawable2 = Oh.getDrawable()) != null && (bounds2 = drawable2.getBounds()) != null) {
            i3 = bounds2.width();
        } else {
            i3 = 0;
        }
        ImageView Oh2 = Oh();
        if (Oh2 != null && (drawable = Oh2.getDrawable()) != null && (bounds = drawable.getBounds()) != null) {
            i16 = bounds.height();
        } else {
            i16 = 0;
        }
        ImageView Oh3 = Oh();
        if (Oh3 != null) {
            matrix = Oh3.getImageMatrix();
        } else {
            matrix = null;
        }
        float[] fArr = new float[10];
        if (matrix != null) {
            matrix.getValues(fArr);
        }
        int i19 = (int) (i3 * fArr[0]);
        int i26 = (int) (i16 * fArr[4]);
        ImageView Oh4 = Oh();
        if (Oh4 != null) {
            i17 = Oh4.getMeasuredHeight();
        } else {
            i17 = 0;
        }
        ImageView Oh5 = Oh();
        if (Oh5 != null) {
            i18 = Oh5.getMeasuredWidth();
        }
        RectF rectF = new RectF((i18 - i19) / 2, (i17 - i26) / 2, (i18 + i19) / 2, (i17 + i26) / 2);
        RouteTraceView Jh2 = Jh();
        if (Jh2 != null) {
            Jh2.setAttachRect(rectF);
        }
        RouteTraceView Jh3 = Jh();
        if (Jh3 != null) {
            Jh3.h();
        }
    }

    private final void bi() {
        ImageView Oh = Oh();
        if (Oh != null) {
            Oh.setVisibility(0);
        }
        ImageView Mh = Mh();
        if (Mh != null) {
            Mh.setVisibility(4);
        }
    }

    private final void ci() {
        int i3;
        int i16;
        TextView Ph = Ph();
        if (Ph != null) {
            Ph.setText(R.string.f239047le);
        }
        View Ih = Ih();
        if (Ih != null) {
            Ih.setAlpha(0.5f);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        View Nh = Nh();
        if (Nh != null) {
            View Nh2 = Nh();
            if (Nh2 != null) {
                i16 = Nh2.getMeasuredWidth();
            } else {
                i16 = 0;
            }
            Nh.setPivotX(i16 / 2.0f);
        }
        View Nh3 = Nh();
        if (Nh3 != null) {
            View Nh4 = Nh();
            if (Nh4 != null) {
                i3 = Nh4.getMeasuredHeight();
            } else {
                i3 = 0;
            }
            Nh3.setPivotY(i3 / 2.0f);
        }
        ImageView Oh = Oh();
        if (Oh != null) {
            Oh.setVisibility(0);
        }
        animatorSet.playTogether(ObjectAnimator.ofFloat(Oh(), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.6f).setDuration(500L), ObjectAnimator.ofFloat(Nh(), BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.8f).setDuration(500L), ObjectAnimator.ofFloat(Nh(), BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.8f).setDuration(500L));
        animatorSet.addListener(new d());
        animatorSet.start();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment
    public void _$_clearFindViewByIdCache() {
        this.T.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168627g42;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Bundle arguments = getArguments();
        LocalMediaInfo localMediaInfo = null;
        if (arguments != null) {
            serializable = arguments.getSerializable("previewMedia");
        } else {
            serializable = null;
        }
        if (serializable instanceof LocalMediaInfo) {
            localMediaInfo = (LocalMediaInfo) serializable;
        }
        this.currentMediaInfo = localMediaInfo;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.tencent.mobileqq.wink.b.a().addDefaultObservers(this);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.tencent.mobileqq.wink.b.a().removeObserver(this);
        Eh();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
        if (2 == type) {
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type camera.MOBILE_QQ_MATERIAL_INTERFACE.GetBackgroundMaskRsp");
            GetBackgroundMaskRsp getBackgroundMaskRsp = (GetBackgroundMaskRsp) data;
            if (isSuccess && getBackgroundMaskRsp.Images.size() > 0) {
                byte[] bArr = getBackgroundMaskRsp.Images.get(0);
                Rect rect = getBackgroundMaskRsp.Rects[0];
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                Intrinsics.checkNotNullExpressionValue(rect, "rect");
                Wh(decodeByteArray, rect);
                return;
            }
            getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.sticker.e
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleMakeStickerMediaPreviewFragment.Sh(QCircleMakeStickerMediaPreviewFragment.this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        ImageView Oh;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LocalMediaInfo localMediaInfo = this.currentMediaInfo;
        if (localMediaInfo != null && (Oh = Oh()) != null) {
            ViewExKt.l(Oh, localMediaInfo);
        }
        Switch Qh = Qh();
        if (Qh != null) {
            Qh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.sticker.b
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    QCircleMakeStickerMediaPreviewFragment.Th(QCircleMakeStickerMediaPreviewFragment.this, compoundButton, z16);
                }
            });
        }
        View Gh = Gh();
        if (Gh != null) {
            Gh.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.sticker.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QCircleMakeStickerMediaPreviewFragment.Uh(QCircleMakeStickerMediaPreviewFragment.this, view2);
                }
            });
        }
        View Kh = Kh();
        if (Kh != null) {
            Kh.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.sticker.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QCircleMakeStickerMediaPreviewFragment.Vh(QCircleMakeStickerMediaPreviewFragment.this, view2);
                }
            });
        }
    }
}
