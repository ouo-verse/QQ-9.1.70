package com.qzone.reborn.comment.part;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.bean.QZoneMenuModeView;
import com.qzone.reborn.comment.utils.QZoneSwitchKeyboardHelper;
import com.qzone.reborn.comment.widget.QZoneCommentEditText;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
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
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 N2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001OB\u000f\u0012\u0006\u0010,\u001a\u00020(\u00a2\u0006\u0004\bL\u0010MJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016J\u001c\u0010$\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010'\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%H\u0016R\u0017\u0010,\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010)\u001a\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010/R\u0016\u00108\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006P"}, d2 = {"Lcom/qzone/reborn/comment/part/av;", "Lcom/qzone/reborn/base/k;", "Lcom/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper$b;", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "H9", "J9", "D9", "G9", "", "Lcom/qzone/reborn/comment/bean/QZoneMenuModeView;", "F9", "()[Lcom/qzone/reborn/comment/bean/QZoneMenuModeView;", "L9", "view", "K9", "", "E9", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "d", "x3", "h5", "onKeyboardHide", "", "keyboardHeight", "M", "Landroid/view/MotionEvent;", "event", "onTouch", "Landroid/view/ViewGroup;", "layoutView", "i4", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "getInitParams", "()Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mEmoIcon", "f", "Landroid/view/ViewGroup;", "mEmoPanel", tl.h.F, "mAtIcon", "i", "Landroid/view/View;", "mPanelTopShadow", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/LinearLayout;", "mPanelInputArea", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "mEtInput", "Ldd/b;", "D", "Ldd/b;", "mInputViewModel", "Lcom/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper;", "E", "Lcom/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper;", "mKeyboardUtil", UserInfo.SEX_FEMALE, "Z", "mIsAdjustInputPadding", "<init>", "(Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;)V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class av extends com.qzone.reborn.base.k implements QZoneSwitchKeyboardHelper.b, View.OnTouchListener {
    private static final int H = ViewUtils.dpToPx(16.0f);
    private static final int I = ViewUtils.dpToPx(10.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneCommentEditText mEtInput;

    /* renamed from: D, reason: from kotlin metadata */
    private dd.b mInputViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private QZoneSwitchKeyboardHelper mKeyboardUtil;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mIsAdjustInputPadding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZoneCommentPanelParams initParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mEmoIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mEmoPanel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mAtIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View mPanelTopShadow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mPanelInputArea;

    public av(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        this.initParams = initParams;
    }

    private final void D9() {
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
            ImageView imageView2 = this.mAtIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAtIcon");
                imageView2 = null;
            }
            if (imageView2.getVisibility() == 8) {
                LinearLayout linearLayout2 = this.mPanelInputArea;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPanelInputArea");
                } else {
                    linearLayout = linearLayout2;
                }
                int i3 = H;
                linearLayout.setPadding(i3, I, i3, 0);
            }
        }
    }

    private final boolean E9() {
        return this.initParams.getIsShare() && com.qzone.reborn.a.c(com.qzone.reborn.a.f52169a, "exp_qzone_share_sheet", null, 2, null);
    }

    private final QZoneMenuModeView[] F9() {
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
        } else {
            viewGroup = viewGroup2;
        }
        arrayList.add(new QZoneMenuModeView(imageView, viewGroup));
        Object[] array = arrayList.toArray(new QZoneMenuModeView[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (QZoneMenuModeView[]) array;
    }

    private final void G9(View rootView) {
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
        qZoneSwitchKeyboardHelper2.A(F9());
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
    public static final void I9(av this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void J9() {
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

    private final void K9(View view) {
        xc.h hVar;
        if (E9() && (hVar = (xc.h) getIocInterface(xc.h.class)) != null) {
            hVar.s5("dt_clck", view, 1, 1);
        }
    }

    private final void L9() {
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
        } else {
            imageView2 = imageView3;
        }
        imageView2.setContentDescription(com.qzone.util.l.a(R.string.gq9));
    }

    @Override // com.qzone.reborn.comment.utils.QZoneSwitchKeyboardHelper.b
    public void M(int keyboardHeight) {
        L9();
    }

    @Override // com.qzone.reborn.comment.utils.QZoneSwitchKeyboardHelper.b
    public void i4(ViewGroup layoutView) {
        xc.c cVar;
        L9();
        ViewGroup viewGroup = this.mEmoPanel;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmoPanel");
            viewGroup = null;
        }
        if (!Intrinsics.areEqual(layoutView, viewGroup) || (cVar = (xc.c) getIocInterface(xc.c.class)) == null) {
            return;
        }
        cVar.J0(layoutView);
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
        H9(rootView);
        G9(rootView);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        D9();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        xc.e eVar = (xc.e) getIocInterface(xc.e.class);
        if (eVar != null) {
            eVar.c3(view);
        }
        if (com.qzone.reborn.util.e.a("QzoneForwardPanelOperatePart")) {
            return false;
        }
        QZoneCommentEditText qZoneCommentEditText = this.mEtInput;
        if (qZoneCommentEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText = null;
        }
        K9(qZoneCommentEditText);
        return false;
    }

    private final void H9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f162815ms2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026e_comment_panel_emo_icon)");
        this.mEmoIcon = (ImageView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f162816ms3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026e_comment_panel_emo_view)");
        this.mEmoPanel = (ViewGroup) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.mrx);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026ne_comment_panel_at_icon)");
        this.mAtIcon = (ImageView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.msy);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026comment_panel_top_shadow)");
        this.mPanelTopShadow = findViewById4;
        View findViewById5 = rootView.findViewById(R.id.ms_);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026zone_comment_panel_input)");
        this.mEtInput = (QZoneCommentEditText) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.msa);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026comment_panel_input_area)");
        this.mPanelInputArea = (LinearLayout) findViewById6;
        View view = this.mPanelTopShadow;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelTopShadow");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.comment.part.au
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                av.I9(av.this, view3);
            }
        });
        String a16 = com.qzone.util.l.a(R.string.f172997gd2);
        View view3 = this.mPanelTopShadow;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelTopShadow");
        } else {
            view2 = view3;
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
