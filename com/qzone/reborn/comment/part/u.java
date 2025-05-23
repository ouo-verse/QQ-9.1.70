package com.qzone.reborn.comment.part;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.bean.QZoneMenuModeView;
import com.qzone.reborn.comment.utils.QZoneSwitchKeyboardHelper;
import com.qzone.reborn.comment.widget.QZoneCommentEditText;
import com.qzone.widget.RedDotImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 j2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001kB\u000f\u0012\u0006\u0010-\u001a\u00020)\u00a2\u0006\u0004\bh\u0010iJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0016J\u001c\u0010%\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010(\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010&H\u0016R\u0017\u0010-\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010*\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u00104R\u0016\u0010<\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00107R\u0016\u0010>\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u00104R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u00107R\u0016\u0010F\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u00104R\u0016\u0010H\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u00107R\u0016\u0010J\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u00104R\u0016\u0010L\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u00107R\u0016\u0010O\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010NR\u0016\u0010S\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010NR\u0016\u0010T\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u00104R\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010g\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010f\u00a8\u0006l"}, d2 = {"Lcom/qzone/reborn/comment/part/u;", "Lcom/qzone/reborn/base/k;", "Lcom/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper$b;", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "K9", "P9", "Q9", "G9", "J9", "", "Lcom/qzone/reborn/comment/bean/QZoneMenuModeView;", "I9", "()[Lcom/qzone/reborn/comment/bean/QZoneMenuModeView;", "S9", "view", "R9", "", "H9", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "d", "x3", "h5", "onKeyboardHide", "", "keyboardHeight", "M", "Landroid/view/MotionEvent;", "event", "onTouch", "Landroid/view/ViewGroup;", "layoutView", "i4", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "getInitParams", "()Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mDebugText", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mEmoIcon", tl.h.F, "Landroid/view/ViewGroup;", "mEmoPanel", "i", "mImageIcon", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mImagePanel", BdhLogUtil.LogTag.Tag_Conn, "mAtIcon", "Lcom/qzone/widget/RedDotImageView;", "D", "Lcom/qzone/widget/RedDotImageView;", "mFontIcon", "E", "mFontPanel", UserInfo.SEX_FEMALE, "mBarrageEffectIcon", "G", "mBarrageEffectPanel", "H", "mShareIcon", "I", "mSharePanel", "J", "Landroid/view/View;", "mPanelHeadArea", "K", "mPanelTopShadow", "L", "mPanelTopCloseView", "mLogoIcon", "Landroid/widget/LinearLayout;", "N", "Landroid/widget/LinearLayout;", "mPanelInputArea", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "P", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "mEtInput", "Ldd/b;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ldd/b;", "mInputViewModel", "Lcom/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper;", BdhLogUtil.LogTag.Tag_Req, "Lcom/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper;", "mKeyboardUtil", ExifInterface.LATITUDE_SOUTH, "Z", "mIsAdjustInputPadding", "<init>", "(Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;)V", "T", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class u extends com.qzone.reborn.base.k implements QZoneSwitchKeyboardHelper.b, View.OnTouchListener {
    private static final int U = ViewUtils.dpToPx(16.0f);
    private static final int V = ViewUtils.dpToPx(10.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView mAtIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private RedDotImageView mFontIcon;

    /* renamed from: E, reason: from kotlin metadata */
    private ViewGroup mFontPanel;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView mBarrageEffectIcon;

    /* renamed from: G, reason: from kotlin metadata */
    private ViewGroup mBarrageEffectPanel;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView mShareIcon;

    /* renamed from: I, reason: from kotlin metadata */
    private ViewGroup mSharePanel;

    /* renamed from: J, reason: from kotlin metadata */
    private View mPanelHeadArea;

    /* renamed from: K, reason: from kotlin metadata */
    private View mPanelTopShadow;

    /* renamed from: L, reason: from kotlin metadata */
    private View mPanelTopCloseView;

    /* renamed from: M, reason: from kotlin metadata */
    private ImageView mLogoIcon;

    /* renamed from: N, reason: from kotlin metadata */
    private LinearLayout mPanelInputArea;

    /* renamed from: P, reason: from kotlin metadata */
    private QZoneCommentEditText mEtInput;

    /* renamed from: Q, reason: from kotlin metadata */
    private dd.b mInputViewModel;

    /* renamed from: R, reason: from kotlin metadata */
    private QZoneSwitchKeyboardHelper mKeyboardUtil;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean mIsAdjustInputPadding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZoneCommentPanelParams initParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mDebugText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mEmoIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mEmoPanel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mImageIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mImagePanel;

    public u(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        this.initParams = initParams;
    }

    private final void G9() {
        if (this.mIsAdjustInputPadding) {
            return;
        }
        this.mIsAdjustInputPadding = true;
        ImageView imageView = this.mEmoIcon;
        LinearLayout linearLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmoIcon");
            imageView = null;
        }
        if (imageView.getVisibility() == 8) {
            RedDotImageView redDotImageView = this.mFontIcon;
            if (redDotImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFontIcon");
                redDotImageView = null;
            }
            if (redDotImageView.getVisibility() == 8) {
                ImageView imageView2 = this.mImageIcon;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mImageIcon");
                    imageView2 = null;
                }
                if (imageView2.getVisibility() == 8) {
                    ImageView imageView3 = this.mAtIcon;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAtIcon");
                        imageView3 = null;
                    }
                    if (imageView3.getVisibility() == 8) {
                        ImageView imageView4 = this.mBarrageEffectIcon;
                        if (imageView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mBarrageEffectIcon");
                            imageView4 = null;
                        }
                        if (imageView4.getVisibility() == 8) {
                            LinearLayout linearLayout2 = this.mPanelInputArea;
                            if (linearLayout2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mPanelInputArea");
                            } else {
                                linearLayout = linearLayout2;
                            }
                            int i3 = U;
                            linearLayout.setPadding(i3, V, i3, 0);
                        }
                    }
                }
            }
        }
    }

    private final boolean H9() {
        return this.initParams.getIsShare() && com.qzone.reborn.a.c(com.qzone.reborn.a.f52169a, "exp_qzone_share_sheet", null, 2, null);
    }

    private final QZoneMenuModeView[] I9() {
        ArrayList arrayList = new ArrayList();
        ImageView imageView = this.mEmoIcon;
        ViewGroup viewGroup = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmoIcon");
            imageView = null;
        }
        ViewGroup viewGroup2 = this.mEmoPanel;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmoPanel");
            viewGroup2 = null;
        }
        arrayList.add(new QZoneMenuModeView(imageView, viewGroup2));
        RedDotImageView redDotImageView = this.mFontIcon;
        if (redDotImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontIcon");
            redDotImageView = null;
        }
        ViewGroup viewGroup3 = this.mFontPanel;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontPanel");
            viewGroup3 = null;
        }
        arrayList.add(new QZoneMenuModeView(redDotImageView, viewGroup3));
        ImageView imageView2 = this.mBarrageEffectIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBarrageEffectIcon");
            imageView2 = null;
        }
        ViewGroup viewGroup4 = this.mBarrageEffectPanel;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBarrageEffectPanel");
            viewGroup4 = null;
        }
        arrayList.add(new QZoneMenuModeView(imageView2, viewGroup4));
        ImageView imageView3 = this.mShareIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareIcon");
            imageView3 = null;
        }
        ViewGroup viewGroup5 = this.mSharePanel;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSharePanel");
        } else {
            viewGroup = viewGroup5;
        }
        arrayList.add(new QZoneMenuModeView(imageView3, viewGroup));
        Object[] array = arrayList.toArray(new QZoneMenuModeView[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (QZoneMenuModeView[]) array;
    }

    private final void J9(View rootView) {
        if (getActivity() == null) {
            return;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        QZoneSwitchKeyboardHelper qZoneSwitchKeyboardHelper = new QZoneSwitchKeyboardHelper(rootView, activity);
        this.mKeyboardUtil = qZoneSwitchKeyboardHelper;
        Intrinsics.checkNotNull(qZoneSwitchKeyboardHelper);
        qZoneSwitchKeyboardHelper.s(!this.initParams.getShowSharePanel());
        QZoneSwitchKeyboardHelper qZoneSwitchKeyboardHelper2 = this.mKeyboardUtil;
        Intrinsics.checkNotNull(qZoneSwitchKeyboardHelper2);
        qZoneSwitchKeyboardHelper2.A(I9());
        QZoneSwitchKeyboardHelper qZoneSwitchKeyboardHelper3 = this.mKeyboardUtil;
        Intrinsics.checkNotNull(qZoneSwitchKeyboardHelper3);
        qZoneSwitchKeyboardHelper3.v();
        QZoneSwitchKeyboardHelper qZoneSwitchKeyboardHelper4 = this.mKeyboardUtil;
        Intrinsics.checkNotNull(qZoneSwitchKeyboardHelper4);
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        qZoneSwitchKeyboardHelper4.g(hostFragment);
        QZoneSwitchKeyboardHelper qZoneSwitchKeyboardHelper5 = this.mKeyboardUtil;
        Intrinsics.checkNotNull(qZoneSwitchKeyboardHelper5);
        qZoneSwitchKeyboardHelper5.y(this);
        QZoneSwitchKeyboardHelper qZoneSwitchKeyboardHelper6 = this.mKeyboardUtil;
        Intrinsics.checkNotNull(qZoneSwitchKeyboardHelper6);
        qZoneSwitchKeyboardHelper6.t(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(u this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(u this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(u this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(u this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void P9() {
        QZoneSwitchKeyboardHelper qZoneSwitchKeyboardHelper = this.mKeyboardUtil;
        if (qZoneSwitchKeyboardHelper != null) {
            qZoneSwitchKeyboardHelper.B();
        }
        ImageView imageView = this.mLogoIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLogoIcon");
            imageView = null;
        }
        R9(imageView);
    }

    private final void Q9() {
        dd.b bVar = this.mInputViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
            bVar = null;
        }
        bVar.e2(1);
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void R9(View view) {
        xc.h hVar;
        if (H9() && (hVar = (xc.h) getIocInterface(xc.h.class)) != null) {
            hVar.s5("dt_clck", view, 1, 1);
        }
    }

    private final void S9() {
        ImageView imageView = this.mEmoIcon;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmoIcon");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.qui_emoticon);
        ImageView imageView3 = this.mEmoIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmoIcon");
            imageView3 = null;
        }
        imageView3.setContentDescription(com.qzone.util.l.a(R.string.gq9));
        RedDotImageView redDotImageView = this.mFontIcon;
        if (redDotImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontIcon");
            redDotImageView = null;
        }
        redDotImageView.setImageResource(R.drawable.qui_aa_method);
        RedDotImageView redDotImageView2 = this.mFontIcon;
        if (redDotImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontIcon");
            redDotImageView2 = null;
        }
        redDotImageView2.setContentDescription(com.qzone.util.l.a(R.string.gqw));
        ImageView imageView4 = this.mBarrageEffectIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBarrageEffectIcon");
            imageView4 = null;
        }
        imageView4.setImageResource(R.drawable.qui_special_effect);
        ImageView imageView5 = this.mBarrageEffectIcon;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBarrageEffectIcon");
        } else {
            imageView2 = imageView5;
        }
        imageView2.setContentDescription(com.qzone.util.l.a(R.string.gqb));
    }

    @Override // com.qzone.reborn.comment.utils.QZoneSwitchKeyboardHelper.b
    public void M(int keyboardHeight) {
        S9();
    }

    @Override // com.qzone.reborn.comment.utils.QZoneSwitchKeyboardHelper.b
    public void i4(ViewGroup layoutView) {
        xc.b bVar;
        S9();
        ViewGroup viewGroup = this.mEmoPanel;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmoPanel");
            viewGroup = null;
        }
        if (Intrinsics.areEqual(layoutView, viewGroup)) {
            xc.c cVar = (xc.c) getIocInterface(xc.c.class);
            if (cVar != null) {
                cVar.J0(layoutView);
                return;
            }
            return;
        }
        ViewGroup viewGroup3 = this.mFontPanel;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontPanel");
            viewGroup3 = null;
        }
        if (Intrinsics.areEqual(layoutView, viewGroup3)) {
            xc.d dVar = (xc.d) getIocInterface(xc.d.class);
            if (dVar != null) {
                dVar.B0(layoutView);
                return;
            }
            return;
        }
        ViewGroup viewGroup4 = this.mBarrageEffectPanel;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBarrageEffectPanel");
        } else {
            viewGroup2 = viewGroup4;
        }
        if (!Intrinsics.areEqual(layoutView, viewGroup2) || (bVar = (xc.b) getIocInterface(xc.b.class)) == null) {
            return;
        }
        bVar.i0(layoutView);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        QZoneSwitchKeyboardHelper qZoneSwitchKeyboardHelper = this.mKeyboardUtil;
        if (qZoneSwitchKeyboardHelper != null) {
            qZoneSwitchKeyboardHelper.m();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(dd.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneInputViewModel::class.java)");
        this.mInputViewModel = (dd.b) viewModel;
        K9(rootView);
        J9(rootView);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        G9();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        xc.e eVar = (xc.e) getIocInterface(xc.e.class);
        if (eVar != null) {
            eVar.c3(view);
        }
        if (com.qzone.reborn.util.e.a("QZoneCommentPanelOperatePart")) {
            return false;
        }
        QZoneCommentEditText qZoneCommentEditText = this.mEtInput;
        if (qZoneCommentEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText = null;
        }
        R9(qZoneCommentEditText);
        return false;
    }

    private final void K9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f162815ms2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026e_comment_panel_emo_icon)");
        this.mEmoIcon = (ImageView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f162816ms3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026e_comment_panel_emo_view)");
        this.mEmoPanel = (ViewGroup) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.ms8);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026comment_panel_image_icon)");
        this.mImageIcon = (ImageView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.ms9);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026nt_panel_image_tips_grid)");
        this.mImagePanel = (ViewGroup) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.mrx);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026ne_comment_panel_at_icon)");
        this.mAtIcon = (ImageView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f162817ms4);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026_comment_panel_font_icon)");
        this.mFontIcon = (RedDotImageView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.ms6);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026ment_panel_font_tab_view)");
        this.mFontPanel = (ViewGroup) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.mry);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.\u2026anel_barrage_effect_icon)");
        this.mBarrageEffectIcon = (ImageView) findViewById8;
        View findViewById9 = rootView.findViewById(R.id.mrz);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.\u2026anel_barrage_effect_view)");
        this.mBarrageEffectPanel = (ViewGroup) findViewById9;
        View findViewById10 = rootView.findViewById(R.id.msv);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "rootView.findViewById(R.\u2026comment_panel_share_icon)");
        this.mShareIcon = (ImageView) findViewById10;
        View findViewById11 = rootView.findViewById(R.id.msw);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "rootView.findViewById(R.\u2026comment_panel_share_view)");
        this.mSharePanel = (ViewGroup) findViewById11;
        View findViewById12 = rootView.findViewById(R.id.f162814ms1);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "rootView.findViewById(R.\u2026comment_panel_debug_text)");
        this.mDebugText = (TextView) findViewById12;
        View findViewById13 = rootView.findViewById(R.id.ms7);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "rootView.findViewById(R.\u2026_comment_panel_head_area)");
        this.mPanelHeadArea = findViewById13;
        View findViewById14 = rootView.findViewById(R.id.msu);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "rootView.findViewById(R.\u2026mment_panel_shadow_close)");
        this.mPanelTopCloseView = findViewById14;
        View findViewById15 = rootView.findViewById(R.id.msy);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "rootView.findViewById(R.\u2026comment_panel_top_shadow)");
        this.mPanelTopShadow = findViewById15;
        View findViewById16 = rootView.findViewById(R.id.ms_);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "rootView.findViewById(R.\u2026zone_comment_panel_input)");
        this.mEtInput = (QZoneCommentEditText) findViewById16;
        View findViewById17 = rootView.findViewById(R.id.msc);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "rootView.findViewById(R.\u2026_comment_panel_logo_icon)");
        this.mLogoIcon = (ImageView) findViewById17;
        View findViewById18 = rootView.findViewById(R.id.msa);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "rootView.findViewById(R.\u2026comment_panel_input_area)");
        this.mPanelInputArea = (LinearLayout) findViewById18;
        View view = this.mPanelHeadArea;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelHeadArea");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.comment.part.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                u.L9(u.this, view3);
            }
        });
        View view3 = this.mPanelTopShadow;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelTopShadow");
            view3 = null;
        }
        view3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.comment.part.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                u.M9(u.this, view4);
            }
        });
        View view4 = this.mPanelTopCloseView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelTopCloseView");
            view4 = null;
        }
        view4.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.comment.part.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                u.N9(u.this, view5);
            }
        });
        ImageView imageView = this.mLogoIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLogoIcon");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.comment.part.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                u.O9(u.this, view5);
            }
        });
        ImageView imageView2 = this.mLogoIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLogoIcon");
            imageView2 = null;
        }
        imageView2.setVisibility(H9() ? 0 : 8);
        String a16 = com.qzone.util.l.a(R.string.f172997gd2);
        View view5 = this.mPanelHeadArea;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelHeadArea");
            view5 = null;
        }
        AccessibilityUtil.p(view5, a16);
        View view6 = this.mPanelTopShadow;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelTopShadow");
            view6 = null;
        }
        AccessibilityUtil.p(view6, a16);
        View view7 = this.mPanelTopCloseView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelTopCloseView");
        } else {
            view2 = view7;
        }
        AccessibilityUtil.p(view2, a16);
    }

    @Override // com.qzone.reborn.comment.utils.QZoneSwitchKeyboardHelper.b
    public void d() {
    }

    @Override // com.qzone.reborn.comment.utils.QZoneSwitchKeyboardHelper.b
    public void h5() {
    }

    @Override // com.qzone.reborn.comment.utils.QZoneSwitchKeyboardHelper.b
    public void onKeyboardHide() {
    }

    @Override // com.qzone.reborn.comment.utils.QZoneSwitchKeyboardHelper.b
    public void x3() {
    }
}
