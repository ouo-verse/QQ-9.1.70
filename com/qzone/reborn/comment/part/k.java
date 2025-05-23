package com.qzone.reborn.comment.part;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneFontPanel;
import com.qzone.common.activities.base.QZoneFontTabView;
import com.qzone.common.activities.base.QZoneSuperFontPanel;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.publish.service.PersonalFontService;
import com.qzone.publish.ui.model.PersonalFontData;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.widget.QZoneCommentEditText;
import com.qzone.widget.RedDotImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qzonehub.api.font.IFontManager;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001/B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/qzone/reborn/comment/part/k;", "Lcom/qzone/reborn/base/k;", "Lxc/d;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "J9", "F9", "M9", "", "I9", "Lcom/qzone/publish/ui/model/PersonalFontData$FontInfo;", "fontInfo", "K9", "", MessageForRichState.SIGN_MSG_FONT_ID, "L9", "onInitView", "O", "Landroid/view/ViewGroup;", "layoutView", "B0", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "d", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "getInitParams", "()Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "e", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "mEtInput", "Lcom/qzone/widget/RedDotImageView;", "f", "Lcom/qzone/widget/RedDotImageView;", "mFontIcon", "Lcom/qzone/common/activities/base/QZoneFontTabView;", tl.h.F, "Lcom/qzone/common/activities/base/QZoneFontTabView;", "mFontPanelView", "Ldd/b;", "i", "Ldd/b;", "mInputViewModel", "<init>", "(Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class k extends com.qzone.reborn.base.k implements xc.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZoneCommentPanelParams initParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneCommentEditText mEtInput;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RedDotImageView mFontIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneFontTabView mFontPanelView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private dd.b mInputViewModel;
    private static final int C = (int) (ViewUtils.getScreenWidth() * 0.67f);
    private static final int D = ViewUtils.dpToPx(37.0f);

    public k(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        this.initParams = initParams;
    }

    private final void F9() {
        QZoneFontTabView qZoneFontTabView;
        QZoneCommentEditText qZoneCommentEditText;
        QZoneFontTabView qZoneFontTabView2 = this.mFontPanelView;
        RedDotImageView redDotImageView = null;
        if (qZoneFontTabView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
            qZoneFontTabView2 = null;
        }
        qZoneFontTabView2.setIsActionPanel(true);
        QZoneFontTabView qZoneFontTabView3 = this.mFontPanelView;
        if (qZoneFontTabView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
            qZoneFontTabView = null;
        } else {
            qZoneFontTabView = qZoneFontTabView3;
        }
        Activity activity = getActivity();
        QZoneCommentEditText qZoneCommentEditText2 = this.mEtInput;
        if (qZoneCommentEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText = null;
        } else {
            qZoneCommentEditText = qZoneCommentEditText2;
        }
        qZoneFontTabView.o(activity, null, qZoneCommentEditText, LoginData.getInstance().getUin());
        if (this.initParams.getSelectFontId() > 0) {
            QZoneFontTabView qZoneFontTabView4 = this.mFontPanelView;
            if (qZoneFontTabView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
                qZoneFontTabView4 = null;
            }
            qZoneFontTabView4.setSelectFontId(this.initParams.getSelectFontId());
        }
        QZoneFontTabView qZoneFontTabView5 = this.mFontPanelView;
        if (qZoneFontTabView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
            qZoneFontTabView5 = null;
        }
        qZoneFontTabView5.f(false, this.initParams.getIsFromDIY());
        QZoneFontTabView qZoneFontTabView6 = this.mFontPanelView;
        if (qZoneFontTabView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
            qZoneFontTabView6 = null;
        }
        qZoneFontTabView6.setFontItemClickListener(new QZoneFontPanel.e() { // from class: com.qzone.reborn.comment.part.i
            @Override // com.qzone.common.activities.base.QZoneFontPanel.e
            public final void a(PersonalFontData.FontInfo fontInfo) {
                k.G9(k.this, fontInfo);
            }
        });
        if (!PersonalFontService.K().M()) {
            QZoneFontTabView qZoneFontTabView7 = this.mFontPanelView;
            if (qZoneFontTabView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
                qZoneFontTabView7 = null;
            }
            QZoneFontPanel qZoneFontPanel = qZoneFontTabView7.f45368i;
            if (qZoneFontPanel != null) {
                qZoneFontPanel.d0(true);
            }
        }
        QZoneFontTabView qZoneFontTabView8 = this.mFontPanelView;
        if (qZoneFontTabView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
            qZoneFontTabView8 = null;
        }
        QZoneFontPanel qZoneFontPanel2 = qZoneFontTabView8.f45368i;
        if (qZoneFontPanel2 != null) {
            qZoneFontPanel2.setReportCallback(new QZoneFontPanel.f() { // from class: com.qzone.reborn.comment.part.j
                @Override // com.qzone.common.activities.base.QZoneFontPanel.f
                public final void a() {
                    k.H9();
                }
            });
        }
        QZoneFontTabView qZoneFontTabView9 = this.mFontPanelView;
        if (qZoneFontTabView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
            qZoneFontTabView9 = null;
        }
        ViewGroup.LayoutParams layoutParams = qZoneFontTabView9.getLayoutParams();
        int i3 = C;
        layoutParams.height = i3;
        if (!this.initParams.getIsFromDIY() && this.initParams.getEnableSuperFont()) {
            QZoneFontTabView qZoneFontTabView10 = this.mFontPanelView;
            if (qZoneFontTabView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
                qZoneFontTabView10 = null;
            }
            qZoneFontTabView10.h();
            QZoneFontTabView qZoneFontTabView11 = this.mFontPanelView;
            if (qZoneFontTabView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
                qZoneFontTabView11 = null;
            }
            qZoneFontTabView11.setSuperFontItemClickListener(new b());
            QZoneFontTabView qZoneFontTabView12 = this.mFontPanelView;
            if (qZoneFontTabView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
                qZoneFontTabView12 = null;
            }
            qZoneFontTabView12.getLayoutParams().height = i3 + D;
        }
        RedDotImageView redDotImageView2 = this.mFontIcon;
        if (redDotImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontIcon");
        } else {
            redDotImageView = redDotImageView2;
        }
        fo.c.n(redDotImageView, "em_qz_font");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(k this$0, PersonalFontData.FontInfo fontInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K9(fontInfo);
    }

    private final String I9() {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if ((r0 != null && r0.fontFormatType == 4) != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void L9(int fontId) {
        QZoneFontTabView qZoneFontTabView = this.mFontPanelView;
        dd.b bVar = null;
        if (qZoneFontTabView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
            qZoneFontTabView = null;
        }
        QZoneFontPanel qZoneFontPanel = qZoneFontTabView.f45368i;
        PersonalFontData.FontInfo R = qZoneFontPanel != null ? qZoneFontPanel.R() : null;
        if (!(R != null && R.fontFormatType == 3)) {
        }
        QZoneFontTabView qZoneFontTabView2 = this.mFontPanelView;
        if (qZoneFontTabView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
            qZoneFontTabView2 = null;
        }
        QZoneFontPanel qZoneFontPanel2 = qZoneFontTabView2.f45368i;
        if (qZoneFontPanel2 != null) {
            qZoneFontPanel2.y0();
        }
        if (fontId > 0) {
            dd.b bVar2 = this.mInputViewModel;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
            } else {
                bVar = bVar2;
            }
            bVar.a2();
            xc.i iVar = (xc.i) getIocInterface(xc.i.class);
            if (iVar != null) {
                iVar.n3();
            }
        }
        xc.b bVar3 = (xc.b) getIocInterface(xc.b.class);
        if (bVar3 != null) {
            bVar3.O();
        }
    }

    private final void M9() {
        QZoneFontTabView qZoneFontTabView = this.mFontPanelView;
        RedDotImageView redDotImageView = null;
        if (qZoneFontTabView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
            qZoneFontTabView = null;
        }
        if (qZoneFontTabView.f45368i == null) {
            return;
        }
        QZoneFontTabView qZoneFontTabView2 = this.mFontPanelView;
        if (qZoneFontTabView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
            qZoneFontTabView2 = null;
        }
        QZoneFontPanel qZoneFontPanel = qZoneFontTabView2.f45368i;
        Intrinsics.checkNotNull(qZoneFontPanel);
        if (LocalMultiProcConfig.getLong(LocalMultiProcConfig.QZONE_FONT_RED_DOT, -1L) < qZoneFontPanel.O()) {
            RedDotImageView redDotImageView2 = this.mFontIcon;
            if (redDotImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFontIcon");
            } else {
                redDotImageView = redDotImageView2;
            }
            redDotImageView.h(true);
        }
    }

    @Override // xc.d
    public void B0(ViewGroup layoutView) {
        RedDotImageView redDotImageView = this.mFontIcon;
        RedDotImageView redDotImageView2 = null;
        if (redDotImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontIcon");
            redDotImageView = null;
        }
        redDotImageView.setImageResource(R.drawable.qui_keyboard_circle);
        RedDotImageView redDotImageView3 = this.mFontIcon;
        if (redDotImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontIcon");
            redDotImageView3 = null;
        }
        redDotImageView3.setContentDescription(com.qzone.util.l.a(R.string.f2202768o));
        QZoneFontTabView qZoneFontTabView = this.mFontPanelView;
        if (qZoneFontTabView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
            qZoneFontTabView = null;
        }
        qZoneFontTabView.setVisibility(0);
        if (!PersonalFontService.K().M()) {
            QZoneFontTabView qZoneFontTabView2 = this.mFontPanelView;
            if (qZoneFontTabView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
                qZoneFontTabView2 = null;
            }
            QZoneFontPanel qZoneFontPanel = qZoneFontTabView2.f45368i;
            if (qZoneFontPanel != null) {
                qZoneFontPanel.d0(true);
            }
        }
        long j3 = LocalMultiProcConfig.getLong(LocalMultiProcConfig.QZONE_FONT_RED_DOT, -1L);
        QZoneFontTabView qZoneFontTabView3 = this.mFontPanelView;
        if (qZoneFontTabView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
            qZoneFontTabView3 = null;
        }
        QZoneFontPanel qZoneFontPanel2 = qZoneFontTabView3.f45368i;
        long O = qZoneFontPanel2 != null ? qZoneFontPanel2.O() : 0L;
        RedDotImageView redDotImageView4 = this.mFontIcon;
        if (redDotImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontIcon");
            redDotImageView4 = null;
        }
        if (redDotImageView4.f() && O > j3) {
            LocalMultiProcConfig.putLong(LocalMultiProcConfig.QZONE_FONT_RED_DOT, O);
        }
        RedDotImageView redDotImageView5 = this.mFontIcon;
        if (redDotImageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontIcon");
            redDotImageView5 = null;
        }
        redDotImageView5.h(false);
        RedDotImageView redDotImageView6 = this.mFontIcon;
        if (redDotImageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontIcon");
        } else {
            redDotImageView2 = redDotImageView6;
        }
        redDotImageView2.clearAsyncImage();
    }

    @Override // xc.d
    public void O() {
        QZoneFontTabView qZoneFontTabView = this.mFontPanelView;
        QZoneFontTabView qZoneFontTabView2 = null;
        if (qZoneFontTabView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
            qZoneFontTabView = null;
        }
        QZoneSuperFontPanel qZoneSuperFontPanel = qZoneFontTabView.f45369m;
        if (qZoneSuperFontPanel != null) {
            qZoneSuperFontPanel.l0();
        }
        QZoneFontTabView qZoneFontTabView3 = this.mFontPanelView;
        if (qZoneFontTabView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
        } else {
            qZoneFontTabView2 = qZoneFontTabView3;
        }
        QZoneFontPanel qZoneFontPanel = qZoneFontTabView2.f45368i;
        if (qZoneFontPanel != null) {
            qZoneFontPanel.y0();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(dd.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneInputViewModel::class.java)");
        this.mInputViewModel = (dd.b) viewModel;
        registerIoc(this, xc.d.class);
        J9(rootView);
        F9();
        M9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9() {
        ClickReport.c(431, 9, "1", true, new String[0]);
    }

    private final void J9(View rootView) {
        View findViewById = rootView.findViewById(R.id.ms_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026zone_comment_panel_input)");
        this.mEtInput = (QZoneCommentEditText) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f162817ms4);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026_comment_panel_font_icon)");
        this.mFontIcon = (RedDotImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.ms6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026ment_panel_font_tab_view)");
        this.mFontPanelView = (QZoneFontTabView) findViewById3;
        RedDotImageView redDotImageView = this.mFontIcon;
        RedDotImageView redDotImageView2 = null;
        if (redDotImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontIcon");
            redDotImageView = null;
        }
        redDotImageView.setVisibility(0);
        RedDotImageView redDotImageView3 = this.mFontIcon;
        if (redDotImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontIcon");
        } else {
            redDotImageView2 = redDotImageView3;
        }
        redDotImageView2.setOffSet(ViewUtils.dpToPx(6.0f), ViewUtils.dpToPx(2.0f));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
    
        if ((r6 != null && r6.fontFormatType == 4) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void K9(PersonalFontData.FontInfo fontInfo) {
        if (!(fontInfo != null && fontInfo.fontFormatType == 3)) {
        }
        QZoneFontTabView qZoneFontTabView = this.mFontPanelView;
        if (qZoneFontTabView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFontPanelView");
            qZoneFontTabView = null;
        }
        QZoneSuperFontPanel qZoneSuperFontPanel = qZoneFontTabView.f45369m;
        if (qZoneSuperFontPanel != null) {
            qZoneSuperFontPanel.l0();
        }
        ((IFontManager) QRoute.api(IFontManager.class)).setDefaultSuperFont(LoginData.getInstance().getUin(), null);
        if (fontInfo != null && fontInfo.f51895id > 0) {
            dd.b bVar = this.mInputViewModel;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
                bVar = null;
            }
            bVar.a2();
            xc.i iVar = (xc.i) getIocInterface(xc.i.class);
            if (iVar != null) {
                iVar.n3();
            }
        }
        xc.b bVar2 = (xc.b) getIocInterface(xc.b.class);
        if (bVar2 != null) {
            bVar2.O();
        }
        if (TextUtils.isEmpty(I9())) {
            return;
        }
        int i3 = fontInfo != null ? fontInfo.f51895id : -1;
        int i16 = fontInfo != null ? fontInfo.fontFormatType : -1;
        String str = fontInfo != null ? fontInfo.fontUrl : null;
        Intent intent = new Intent("FeedActionPanelActivity.font_select");
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, i3);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE, i16);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL, str);
        getActivity().sendBroadcast(intent);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/comment/part/k$b", "Lcom/qzone/common/activities/base/QZoneSuperFontPanel$c;", "", MessageForRichState.SIGN_MSG_FONT_ID, "", NodeProps.ON_CLICK, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QZoneSuperFontPanel.c {
        b() {
        }

        @Override // com.qzone.common.activities.base.QZoneSuperFontPanel.c
        public void onClick(int fontId) {
            k.this.L9(fontId);
        }

        @Override // com.qzone.common.activities.base.QZoneSuperFontPanel.c
        public void a(int fontId) {
        }
    }
}
