package com.qzone.reborn.comment.part;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.reborn.comment.widget.QZoneCommentEditText;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 +2\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/comment/part/ax;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "G9", "I9", "", "content", "J9", "E9", "K9", "Lxc/h;", "F9", "D9", "onInitView", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "d", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "getInitParams", "()Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "e", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "mEtInput", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "f", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mBtnSend", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", tl.h.F, "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "mForwardCommentIcon", "Ldd/b;", "i", "Ldd/b;", "mInputViewModel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lxc/h;", "mSendReportIoc", "<init>", "(Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ax extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZoneCommentPanelParams initParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneCommentEditText mEtInput;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUIButton mBtnSend;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QUICheckBox mForwardCommentIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private dd.b mInputViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private xc.h mSendReportIoc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/comment/part/ax$b", "Landroid/view/View$AccessibilityDelegate;", "Landroid/view/View;", "host", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "", "onInitializeAccessibilityNodeInfo", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends View.AccessibilityDelegate {
        b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setSelected(false);
        }
    }

    public ax(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        this.initParams = initParams;
    }

    private final String E9() {
        QZoneCommentEditText qZoneCommentEditText = this.mEtInput;
        QZoneCommentEditText qZoneCommentEditText2 = null;
        if (qZoneCommentEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText = null;
        }
        Editable text = qZoneCommentEditText.getText();
        if (text instanceof QQTextBuilder) {
            String plainText = ((QQTextBuilder) text).toPlainText();
            Intrinsics.checkNotNullExpressionValue(plainText, "text.toPlainText()");
            return plainText;
        }
        QZoneCommentEditText qZoneCommentEditText3 = this.mEtInput;
        if (qZoneCommentEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
        } else {
            qZoneCommentEditText2 = qZoneCommentEditText3;
        }
        return qZoneCommentEditText2.getEditableText().toString();
    }

    private final xc.h F9() {
        if (this.mSendReportIoc == null) {
            this.mSendReportIoc = (xc.h) getIocInterface(xc.h.class);
        }
        return this.mSendReportIoc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(ax this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void I9() {
        CharSequence trim;
        trim = StringsKt__StringsKt.trim((CharSequence) E9());
        String obj = trim.toString();
        QZoneCommentEditText qZoneCommentEditText = this.mEtInput;
        dd.b bVar = null;
        if (qZoneCommentEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText = null;
        }
        Editable editableText = qZoneCommentEditText.getEditableText();
        int length = editableText != null ? editableText.length() : 0;
        if ((obj.length() == 0) && !this.initParams.getIsAllowEmpty()) {
            dd.b bVar2 = this.mInputViewModel;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
                bVar2 = null;
            }
            ArrayList<String> R1 = bVar2.R1();
            if (R1 == null || R1.isEmpty()) {
                com.qzone.reborn.util.o.f59556a.b(com.qzone.reborn.configx.g.f53821a.m().j());
                return;
            }
        }
        if (length > this.initParams.getMaxInputLength()) {
            com.qzone.reborn.util.o.f59556a.b(com.qzone.util.l.a(R.string.m5r));
            return;
        }
        String J9 = J9(obj);
        dd.b bVar3 = this.mInputViewModel;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
            bVar3 = null;
        }
        bVar3.N1();
        dd.b bVar4 = this.mInputViewModel;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
        } else {
            bVar = bVar4;
        }
        bVar.O1(1);
        K9(J9);
    }

    private final String J9(String content) {
        dd.b bVar = this.mInputViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
            bVar = null;
        }
        String splash2Emo = QzoneEmotionUtils.splash2Emo(bVar.P1(content));
        Intrinsics.checkNotNullExpressionValue(splash2Emo, "splash2Emo(result)");
        String a16 = com.qzone.util.g.a(splash2Emo);
        Intrinsics.checkNotNullExpressionValue(a16, "replaceEmojiText(result)");
        return a16;
    }

    private final void K9(String content) {
        D9();
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean = new QZoneCommentPanelResultBean();
        qZoneCommentPanelResultBean.C(content);
        dd.b bVar = this.mInputViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
            bVar = null;
        }
        qZoneCommentPanelResultBean.y(bVar.R1());
        qZoneCommentPanelResultBean.A(this.initParams.getFeedsId());
        qZoneCommentPanelResultBean.D(this.initParams.getPosition());
        qZoneCommentPanelResultBean.v(this.initParams.getCacheUniKey());
        qZoneCommentPanelResultBean.s(this.initParams.getAutoSaveUgcKey());
        qZoneCommentPanelResultBean.u(this.initParams.getCacheFeedsKey());
        boolean z16 = false;
        qZoneCommentPanelResultBean.x(false);
        QUICheckBox qUICheckBox = this.mForwardCommentIcon;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardCommentIcon");
            qUICheckBox = null;
        }
        if (qUICheckBox.isChecked() && !TextUtils.isEmpty(content)) {
            z16 = true;
        }
        qZoneCommentPanelResultBean.w(z16);
        qZoneCommentPanelResultBean.B(null);
        qZoneCommentPanelResultBean.F(null);
        qZoneCommentPanelResultBean.t(null);
        QLog.i("QzoneForwardPanelSendPart", 4, "[sendForwardContent] resultBean:" + qZoneCommentPanelResultBean);
        Intent intent = new Intent();
        intent.putExtra("comment_panel_result_bean", qZoneCommentPanelResultBean);
        Activity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        Activity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(dd.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneInputViewModel::class.java)");
        this.mInputViewModel = (dd.b) viewModel;
        G9(rootView);
    }

    private final void G9(View rootView) {
        View findViewById = rootView.findViewById(R.id.ms_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026zone_comment_panel_input)");
        this.mEtInput = (QZoneCommentEditText) findViewById;
        View findViewById2 = rootView.findViewById(R.id.mst);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026e_comment_panel_send_btn)");
        this.mBtnSend = (QUIButton) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.mrp);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026forward_and_comment_icon)");
        this.mForwardCommentIcon = (QUICheckBox) findViewById3;
        QUIButton qUIButton = this.mBtnSend;
        QUIButton qUIButton2 = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSend");
            qUIButton = null;
        }
        qUIButton.setAccessibilityDelegate(new b());
        QUIButton qUIButton3 = this.mBtnSend;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSend");
            qUIButton3 = null;
        }
        qUIButton3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.comment.part.aw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ax.H9(ax.this, view);
            }
        });
        xc.h F9 = F9();
        if (F9 != null) {
            QUIButton qUIButton4 = this.mBtnSend;
            if (qUIButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtnSend");
            } else {
                qUIButton2 = qUIButton4;
            }
            F9.P8(qUIButton2, 1, 1);
        }
    }

    private final void D9() {
    }
}
