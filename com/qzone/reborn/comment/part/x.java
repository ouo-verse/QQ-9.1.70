package com.qzone.reborn.comment.part;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.widget.QZoneCommentEditText;
import com.qzone.util.ToastUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 <2\u00020\u0001:\u0001=B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\tJ\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/qzone/reborn/comment/part/x;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "H9", "K9", "F9", "E9", "", "bDirect", "L9", "onInitView", "checked", "J9", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "d", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "getInitParams", "()Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "e", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "mEtInput", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "mPrivateCommentArea", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", tl.h.F, "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "mPrivateCommentIcon", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mPrivateCommentText", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mPrivateCommentVipIcon", "Landroid/view/ViewGroup;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", "mQQVideoSyncContainer", "Ldd/b;", "D", "Ldd/b;", "mInputViewModel", "E", "Z", "mCanOpenVipActivity", "<init>", "(Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;)V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class x extends com.qzone.reborn.base.k {

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup mQQVideoSyncContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private dd.b mInputViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mCanOpenVipActivity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZoneCommentPanelParams initParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneCommentEditText mEtInput;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mPrivateCommentArea;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QUICheckBox mPrivateCommentIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mPrivateCommentText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mPrivateCommentVipIcon;

    public x(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        this.initParams = initParams;
        this.mCanOpenVipActivity = true;
    }

    private final void E9() {
        QUICheckBox qUICheckBox = this.mPrivateCommentIcon;
        QUICheckBox qUICheckBox2 = null;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrivateCommentIcon");
            qUICheckBox = null;
        }
        if (qUICheckBox.isChecked()) {
            J9(false);
        } else {
            J9(true);
        }
        xc.f fVar = (xc.f) getIocInterface(xc.f.class);
        if (fVar != null) {
            QUICheckBox qUICheckBox3 = this.mPrivateCommentIcon;
            if (qUICheckBox3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPrivateCommentIcon");
            } else {
                qUICheckBox2 = qUICheckBox3;
            }
            fVar.a(qUICheckBox2.isChecked());
        }
    }

    private final void F9() {
        if (this.initParams.getShowPrivateComment() == 1) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastPrivateSetting", "\u79c1\u5bc6\u56de\u590d\u4e0d\u53ef\u8bbe\u7f6e\u516c\u5f00"));
            return;
        }
        if (!LoginData.getInstance().isQzoneVip()) {
            L9(false);
        } else if (!u5.b.D("private_comment_is_ever_used", false)) {
            u5.b.o0("private_comment_is_ever_used", true);
            DialogUtil.createCustomDialog(getContext(), 230, (String) null, getContext().getResources().getString(R.string.goe), (String) null, com.qzone.util.l.a(R.string.f171965mf1), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.comment.part.w
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    x.G9(x.this, dialogInterface, i3);
                }
            }, (DialogInterface.OnClickListener) null).show();
        } else {
            E9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(x this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(x this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void K9() {
        LinearLayout linearLayout = this.mPrivateCommentArea;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrivateCommentArea");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        if (this.initParams.getShowPrivateComment() == 1) {
            J9(true);
        }
        if (FontSettingManager.getFontLevel() > 17.0f) {
            ImageView imageView = this.mPrivateCommentVipIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPrivateCommentVipIcon");
                imageView = null;
            }
            imageView.setVisibility(8);
        }
        LinearLayout linearLayout3 = this.mPrivateCommentArea;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrivateCommentArea");
        } else {
            linearLayout2 = linearLayout3;
        }
        fo.c.n(linearLayout2, "em_qz_private_comment");
    }

    private final void L9(boolean bDirect) {
        if (this.mCanOpenVipActivity) {
            this.mCanOpenVipActivity = false;
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "HuangzuanPaySuccess", "\u652f\u4ed8\u6210\u529f\uff0c\u53ef\u4ee5\u4f7f\u7528\u79c1\u5bc6\u8bc4\u8bba");
            String string = getContext().getString(R.string.god);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026simipinglun_open_vip_tip)");
            Intent intent = new Intent();
            intent.putExtra("aid", "jhan_simipinglun");
            intent.putExtra("direct_go", false);
            intent.putExtra("dialog_title", string);
            intent.putExtra("success_tips", config);
            intent.putExtra("dialog_msg", getContext().getString(R.string.god));
            intent.putExtra("pay_directgo", bDirect);
            VipComponentProxy.f50997g.getUiInterface().goOpenYellowVip(getContext(), intent, 10001);
        }
    }

    public final void J9(boolean checked) {
        QUICheckBox qUICheckBox = this.mPrivateCommentIcon;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrivateCommentIcon");
            qUICheckBox = null;
        }
        qUICheckBox.setChecked(checked);
        if (checked) {
            com.qzone.adapter.feedcomponent.i.H().W1("357", "1", "1");
        } else {
            com.qzone.adapter.feedcomponent.i.H().W1("357", "1", "2");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (10001 == requestCode) {
            this.mCanOpenVipActivity = true;
            if (requestCode == -1) {
                J9(true);
            }
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
        K9();
    }

    private final void H9(View rootView) {
        View findViewById = rootView.findViewById(R.id.ms_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026zone_comment_panel_input)");
        this.mEtInput = (QZoneCommentEditText) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f162818msf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026mment_panel_private_area)");
        this.mPrivateCommentArea = (LinearLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.msj);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026mment_panel_private_icon)");
        this.mPrivateCommentIcon = (QUICheckBox) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.msl);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026mment_panel_private_text)");
        this.mPrivateCommentText = (TextView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.msn);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026t_panel_private_vip_icon)");
        this.mPrivateCommentVipIcon = (ImageView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.mso);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026panel_qq_video_sync_tips)");
        this.mQQVideoSyncContainer = (ViewGroup) findViewById6;
        LinearLayout linearLayout = this.mPrivateCommentArea;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrivateCommentArea");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.comment.part.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x.I9(x.this, view);
            }
        });
    }
}
