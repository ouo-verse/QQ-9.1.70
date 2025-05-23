package com.qzone.reborn.comment.part;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.ViewModel;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneBarrageEffectPanel;
import com.qzone.publish.service.QzoneBarrageEffectService;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.widget.QZoneCommentEditText;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qzonehub.api.font.IFontManager;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.font.DefaultBarrageEffectInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001)B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/comment/part/d;", "Lcom/qzone/reborn/base/k;", "Lxc/b;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "E9", "D9", "", MessageForRichState.SIGN_MSG_FONT_ID, "F9", "onInitView", "O", "Landroid/view/ViewGroup;", "layoutView", "i0", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "d", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "getInitParams", "()Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "e", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "mEtInput", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mBarrageEffectIcon", "Lcom/qzone/common/activities/base/QZoneBarrageEffectPanel;", tl.h.F, "Lcom/qzone/common/activities/base/QZoneBarrageEffectPanel;", "mBarragePanelView", "Ldd/b;", "i", "Ldd/b;", "mInputViewModel", "<init>", "(Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d extends com.qzone.reborn.base.k implements xc.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZoneCommentPanelParams initParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneCommentEditText mEtInput;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mBarrageEffectIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneBarrageEffectPanel mBarragePanelView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private dd.b mInputViewModel;
    private static final int C = (int) (ViewUtils.getScreenWidth() * 0.67f);

    public d(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        this.initParams = initParams;
    }

    private final void D9() {
        QZoneBarrageEffectPanel qZoneBarrageEffectPanel = this.mBarragePanelView;
        ImageView imageView = null;
        if (qZoneBarrageEffectPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBarragePanelView");
            qZoneBarrageEffectPanel = null;
        }
        Activity activity = getActivity();
        QZoneCommentEditText qZoneCommentEditText = this.mEtInput;
        if (qZoneCommentEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText = null;
        }
        qZoneBarrageEffectPanel.H(activity, qZoneCommentEditText, LoginData.getInstance().getUin());
        QZoneBarrageEffectPanel qZoneBarrageEffectPanel2 = this.mBarragePanelView;
        if (qZoneBarrageEffectPanel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBarragePanelView");
            qZoneBarrageEffectPanel2 = null;
        }
        qZoneBarrageEffectPanel2.setBackgroundResId(R.color.qui_common_bg_bottom_light);
        QZoneBarrageEffectPanel qZoneBarrageEffectPanel3 = this.mBarragePanelView;
        if (qZoneBarrageEffectPanel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBarragePanelView");
            qZoneBarrageEffectPanel3 = null;
        }
        qZoneBarrageEffectPanel3.setItemBackgroundDrawable(R.drawable.f143927);
        QZoneBarrageEffectPanel qZoneBarrageEffectPanel4 = this.mBarragePanelView;
        if (qZoneBarrageEffectPanel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBarragePanelView");
            qZoneBarrageEffectPanel4 = null;
        }
        qZoneBarrageEffectPanel4.getLayoutParams().height = C;
        if (this.initParams.getSelectFontId() > 0) {
            QZoneBarrageEffectPanel qZoneBarrageEffectPanel5 = this.mBarragePanelView;
            if (qZoneBarrageEffectPanel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBarragePanelView");
                qZoneBarrageEffectPanel5 = null;
            }
            qZoneBarrageEffectPanel5.d0(this.initParams.getSelectFontId());
        }
        DefaultBarrageEffectInfo defaultBarrageEffectInfo = ((IFontManager) QRoute.api(IFontManager.class)).getDefaultBarrageEffectInfo(LoginData.getInstance().getUin());
        if (defaultBarrageEffectInfo != null && defaultBarrageEffectInfo.itemId > 0) {
            this.initParams.setMaxInputLength(QZoneConfigHelper.Y());
        }
        QZoneBarrageEffectPanel qZoneBarrageEffectPanel6 = this.mBarragePanelView;
        if (qZoneBarrageEffectPanel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBarragePanelView");
            qZoneBarrageEffectPanel6 = null;
        }
        qZoneBarrageEffectPanel6.setFontItemClickListener(new b());
        if (!QzoneBarrageEffectService.G().H()) {
            QZoneBarrageEffectPanel qZoneBarrageEffectPanel7 = this.mBarragePanelView;
            if (qZoneBarrageEffectPanel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBarragePanelView");
                qZoneBarrageEffectPanel7 = null;
            }
            qZoneBarrageEffectPanel7.U(true);
        }
        ImageView imageView2 = this.mBarrageEffectIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBarrageEffectIcon");
        } else {
            imageView = imageView2;
        }
        fo.c.n(imageView, "em_qz_bubble");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(int fontId) {
        if (fontId <= 0) {
            dd.b bVar = this.mInputViewModel;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
                bVar = null;
            }
            bVar.a2();
            xc.i iVar = (xc.i) getIocInterface(xc.i.class);
            if (iVar != null) {
                iVar.n3();
                return;
            }
            return;
        }
        this.initParams.setMaxInputLength(QZoneConfigHelper.Y());
        xc.i iVar2 = (xc.i) getIocInterface(xc.i.class);
        if (iVar2 != null) {
            iVar2.n3();
        }
        xc.d dVar = (xc.d) getIocInterface(xc.d.class);
        if (dVar != null) {
            dVar.O();
        }
    }

    @Override // xc.b
    public void O() {
        QZoneBarrageEffectPanel qZoneBarrageEffectPanel = this.mBarragePanelView;
        if (qZoneBarrageEffectPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBarragePanelView");
            qZoneBarrageEffectPanel = null;
        }
        qZoneBarrageEffectPanel.k0();
    }

    @Override // xc.b
    public void i0(ViewGroup layoutView) {
        ImageView imageView = this.mBarrageEffectIcon;
        QZoneBarrageEffectPanel qZoneBarrageEffectPanel = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBarrageEffectIcon");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.qui_keyboard_circle);
        ImageView imageView2 = this.mBarrageEffectIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBarrageEffectIcon");
            imageView2 = null;
        }
        imageView2.setContentDescription(com.qzone.util.l.a(R.string.f2202768o));
        QZoneBarrageEffectPanel qZoneBarrageEffectPanel2 = this.mBarragePanelView;
        if (qZoneBarrageEffectPanel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBarragePanelView");
        } else {
            qZoneBarrageEffectPanel = qZoneBarrageEffectPanel2;
        }
        qZoneBarrageEffectPanel.setVisibility(0);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(dd.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneInputViewModel::class.java)");
        this.mInputViewModel = (dd.b) viewModel;
        registerIoc(this, xc.b.class);
        E9(rootView);
        D9();
    }

    private final void E9(View rootView) {
        View findViewById = rootView.findViewById(R.id.ms_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026zone_comment_panel_input)");
        this.mEtInput = (QZoneCommentEditText) findViewById;
        View findViewById2 = rootView.findViewById(R.id.mry);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026anel_barrage_effect_icon)");
        this.mBarrageEffectIcon = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.mrz);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026anel_barrage_effect_view)");
        this.mBarragePanelView = (QZoneBarrageEffectPanel) findViewById3;
        ImageView imageView = this.mBarrageEffectIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBarrageEffectIcon");
            imageView = null;
        }
        imageView.setVisibility(0);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/comment/part/d$b", "Lcom/qzone/common/activities/base/QZoneBarrageEffectPanel$b;", "", MessageForRichState.SIGN_MSG_FONT_ID, "", NodeProps.ON_CLICK, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QZoneBarrageEffectPanel.b {
        b() {
        }

        @Override // com.qzone.common.activities.base.QZoneBarrageEffectPanel.b
        public void onClick(int fontId) {
            d.this.F9(fontId);
        }

        @Override // com.qzone.common.activities.base.QZoneBarrageEffectPanel.b
        public void a(int fontId) {
        }
    }
}
