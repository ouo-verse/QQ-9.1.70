package com.tencent.mobileqq.multishare.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.multishare.fragment.MultiShareBottomDialogFragment;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.inputview.QUIMultiLineInputView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0001]B\u0007\u00a2\u0006\u0004\bZ\u0010[J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010%R\u001a\u00105\u001a\b\u0012\u0004\u0012\u000202018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R$\u0010C\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010G\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010>\u001a\u0004\bE\u0010@\"\u0004\bF\u0010BR$\u0010K\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010>\u001a\u0004\bI\u0010@\"\u0004\bJ\u0010BR\"\u0010Q\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010;\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010Y\u001a\u0004\u0018\u00010R8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010X\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/multishare/part/MultiSharePreviewPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "", "P9", "initViewModel", "", "isClickable", "X9", "Y9", "S9", "M9", "ba", "aa", "", "O9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "d", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "sendBtn", "Lcom/tencent/mobileqq/widget/inputview/QUIMultiLineInputView;", "e", "Lcom/tencent/mobileqq/widget/inputview/QUIMultiLineInputView;", "editTextView", "f", "Landroid/view/View;", "dividerView", "Landroid/widget/FrameLayout;", tl.h.F, "Landroid/widget/FrameLayout;", "shareSendContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "i", "Landroidx/constraintlayout/widget/ConstraintLayout;", "previewLayout", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/LinearLayout;", "actionsLayout", BdhLogUtil.LogTag.Tag_Conn, "previewInsideLayout", "", "Lcom/tencent/mobileqq/multishare/bean/a;", "D", "Ljava/util/List;", "chosenUserBeans", "Landroid/content/Intent;", "E", "Landroid/content/Intent;", "forwardIntent", UserInfo.SEX_FEMALE, "Z", "hasInitPreview", "G", "Ljava/lang/String;", "getMsgHint", "()Ljava/lang/String;", "V9", "(Ljava/lang/String;)V", "msgHint", "H", "getSendBtnText", "Z9", "sendBtnText", "I", "getPreLeaveMsg", "W9", "preLeaveMsg", "J", "N9", "()Z", "T9", "(Z)V", "alwaysShowPreviewLayout", "Lj92/a;", "K", "Lj92/a;", "getMsgChecker", "()Lj92/a;", "U9", "(Lj92/a;)V", "msgChecker", "<init>", "()V", "L", "a", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class MultiSharePreviewPart extends Part implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private FrameLayout previewInsideLayout;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.multishare.bean.a> chosenUserBeans;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Intent forwardIntent;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean hasInitPreview;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private String msgHint;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private String sendBtnText;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private String preLeaveMsg;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean alwaysShowPreviewLayout;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private j92.a msgChecker;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUIButton sendBtn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUIMultiLineInputView editTextView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View dividerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FrameLayout shareSendContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ConstraintLayout previewLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LinearLayout actionsLayout;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/multishare/part/MultiSharePreviewPart$a;", "", "", "ITEM_SIZE", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.multishare.part.MultiSharePreviewPart$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ProfileContants.FIELD_EXTEND_FRIEND_QUESTION);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MultiSharePreviewPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.chosenUserBeans = new ArrayList();
        }
    }

    private final void M9() {
        DialogFragment dialogFragment;
        Object partHost = getPartHost();
        if (partHost instanceof DialogFragment) {
            dialogFragment = (DialogFragment) partHost;
        } else {
            dialogFragment = null;
        }
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String O9() {
        boolean z16;
        String str = this.sendBtnText;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            String qqStr = HardCodeUtil.qqStr(R.string.f169482ig);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.multi_share_send)");
            return qqStr;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9() {
        MultiShareBottomDialogFragment multiShareBottomDialogFragment;
        j92.c cVar;
        Unit unit;
        MultiShareBottomDialogFragment multiShareBottomDialogFragment2;
        if (this.hasInitPreview) {
            return;
        }
        IPartHost partHost = getPartHost();
        if (partHost instanceof MultiShareBottomDialogFragment) {
            multiShareBottomDialogFragment = (MultiShareBottomDialogFragment) partHost;
        } else {
            multiShareBottomDialogFragment = null;
        }
        if (multiShareBottomDialogFragment != null) {
            cVar = multiShareBottomDialogFragment.th();
        } else {
            cVar = null;
        }
        if (cVar != null) {
            FrameLayout frameLayout = this.previewInsideLayout;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previewInsideLayout");
                frameLayout = null;
            }
            frameLayout.setVisibility(0);
            FrameLayout frameLayout2 = this.previewInsideLayout;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previewInsideLayout");
                frameLayout2 = null;
            }
            frameLayout2.addView(cVar.create());
            this.hasInitPreview = true;
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            FrameLayout frameLayout3 = this.previewInsideLayout;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previewInsideLayout");
                frameLayout3 = null;
            }
            frameLayout3.setVisibility(8);
        }
        IPartHost partHost2 = getPartHost();
        if (partHost2 instanceof MultiShareBottomDialogFragment) {
            multiShareBottomDialogFragment2 = (MultiShareBottomDialogFragment) partHost2;
        } else {
            multiShareBottomDialogFragment2 = null;
        }
        if (multiShareBottomDialogFragment2 != null) {
            multiShareBottomDialogFragment2.Bh(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void S9() {
        MultiShareBottomDialogFragment multiShareBottomDialogFragment;
        j92.b sh5;
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.multishare.bean.a aVar : this.chosenUserBeans) {
            arrayList.add(new ResultRecord(aVar.d(), aVar.c(), aVar.e(), aVar.b()));
        }
        QUIMultiLineInputView qUIMultiLineInputView = this.editTextView;
        QUIMultiLineInputView qUIMultiLineInputView2 = null;
        if (qUIMultiLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editTextView");
            qUIMultiLineInputView = null;
        }
        String valueOf = String.valueOf(qUIMultiLineInputView.d());
        j92.a aVar2 = this.msgChecker;
        if (aVar2 != null && !aVar2.c(arrayList, valueOf)) {
            return;
        }
        IPartHost partHost = getPartHost();
        if (partHost instanceof MultiShareBottomDialogFragment) {
            multiShareBottomDialogFragment = (MultiShareBottomDialogFragment) partHost;
        } else {
            multiShareBottomDialogFragment = null;
        }
        if (multiShareBottomDialogFragment != null && (sh5 = multiShareBottomDialogFragment.sh()) != null) {
            sh5.e(arrayList, valueOf);
        }
        QUIMultiLineInputView qUIMultiLineInputView3 = this.editTextView;
        if (qUIMultiLineInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editTextView");
        } else {
            qUIMultiLineInputView2 = qUIMultiLineInputView3;
        }
        qUIMultiLineInputView2.p();
        M9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(boolean isClickable) {
        QUIButton qUIButton = this.sendBtn;
        QUIButton qUIButton2 = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
            qUIButton = null;
        }
        qUIButton.setClickable(isClickable);
        if (isClickable) {
            QUIButton qUIButton3 = this.sendBtn;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
            } else {
                qUIButton2 = qUIButton3;
            }
            qUIButton2.o();
            return;
        }
        QUIButton qUIButton4 = this.sendBtn;
        if (qUIButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
        } else {
            qUIButton2 = qUIButton4;
        }
        qUIButton2.setBackgroundDisabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9() {
        QUIButton qUIButton = this.sendBtn;
        QUIButton qUIButton2 = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
            qUIButton = null;
        }
        if (!qUIButton.m()) {
            QUIButton qUIButton3 = this.sendBtn;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
            } else {
                qUIButton2 = qUIButton3;
            }
            qUIButton2.r();
        }
    }

    private final void aa() {
        int i3;
        int i16;
        com.tencent.mobileqq.multishare.util.c cVar = com.tencent.mobileqq.multishare.util.c.f251800a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!cVar.g(context)) {
            return;
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int i17 = -2;
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (cVar.d(context2)) {
            QUIButton qUIButton = this.sendBtn;
            if (qUIButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
                qUIButton = null;
            }
            int dip2px = ViewUtils.dip2px(20.0f);
            ViewGroup.LayoutParams layoutParams = qUIButton.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            }
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams2 = qUIButton.getLayoutParams();
                if (layoutParams2 != null) {
                    i16 = layoutParams2.width;
                } else {
                    i16 = -2;
                }
                ViewGroup.LayoutParams layoutParams3 = qUIButton.getLayoutParams();
                if (layoutParams3 != null) {
                    i17 = layoutParams3.height;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, i17);
            }
            if (dip2px != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = dip2px;
                qUIButton.setLayoutParams(marginLayoutParams);
                return;
            }
            return;
        }
        QUIButton qUIButton2 = this.sendBtn;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
            qUIButton2 = null;
        }
        int dip2px2 = ViewUtils.dip2px(4.0f);
        ViewGroup.LayoutParams layoutParams4 = qUIButton2.getLayoutParams();
        if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams4;
        }
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams5 = qUIButton2.getLayoutParams();
            if (layoutParams5 != null) {
                i3 = layoutParams5.width;
            } else {
                i3 = -2;
            }
            ViewGroup.LayoutParams layoutParams6 = qUIButton2.getLayoutParams();
            if (layoutParams6 != null) {
                i17 = layoutParams6.height;
            }
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, i17);
        }
        if (dip2px2 != marginLayoutParams.bottomMargin) {
            marginLayoutParams.bottomMargin = dip2px2;
            qUIButton2.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba() {
        com.tencent.mobileqq.multishare.util.c cVar = com.tencent.mobileqq.multishare.util.c.f251800a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!cVar.g(context)) {
            return;
        }
        FrameLayout frameLayout = this.shareSendContainer;
        ConstraintLayout constraintLayout = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareSendContainer");
            frameLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
        layoutParams2.bottomToBottom = 0;
        FrameLayout frameLayout2 = this.shareSendContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareSendContainer");
            frameLayout2 = null;
        }
        frameLayout2.setLayoutParams(layoutParams2);
        ConstraintLayout constraintLayout2 = this.previewLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewLayout");
            constraintLayout2 = null;
        }
        ViewGroup.LayoutParams layoutParams3 = constraintLayout2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        layoutParams4.height = -1;
        ConstraintLayout constraintLayout3 = this.previewLayout;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewLayout");
        } else {
            constraintLayout = constraintLayout3;
        }
        constraintLayout.setLayoutParams(layoutParams4);
        aa();
    }

    private final void initViewModel() {
        com.tencent.mobileqq.multishare.viewmodel.a aVar = (com.tencent.mobileqq.multishare.viewmodel.a) getViewModel(com.tencent.mobileqq.multishare.viewmodel.a.class);
        MutableLiveData<List<com.tencent.mobileqq.multishare.bean.a>> L1 = aVar.L1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<List<? extends com.tencent.mobileqq.multishare.bean.a>, Unit> function1 = new Function1<List<? extends com.tencent.mobileqq.multishare.bean.a>, Unit>() { // from class: com.tencent.mobileqq.multishare.part.MultiSharePreviewPart$initViewModel$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MultiSharePreviewPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.multishare.bean.a> list) {
                invoke2((List<com.tencent.mobileqq.multishare.bean.a>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<com.tencent.mobileqq.multishare.bean.a> it) {
                List list;
                String O9;
                List list2;
                List list3;
                ConstraintLayout constraintLayout;
                LinearLayout linearLayout;
                Intent intent;
                QUIButton qUIButton;
                QUIButton qUIButton2;
                ConstraintLayout constraintLayout2;
                LinearLayout linearLayout2;
                QUIMultiLineInputView qUIMultiLineInputView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                list = MultiSharePreviewPart.this.chosenUserBeans;
                list.clear();
                O9 = MultiSharePreviewPart.this.O9();
                QUIButton qUIButton3 = null;
                if (it.isEmpty()) {
                    qUIButton2 = MultiSharePreviewPart.this.sendBtn;
                    if (qUIButton2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
                        qUIButton2 = null;
                    }
                    qUIButton2.s();
                    MultiSharePreviewPart.this.X9(false);
                    if (!MultiSharePreviewPart.this.N9()) {
                        constraintLayout2 = MultiSharePreviewPart.this.previewLayout;
                        if (constraintLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("previewLayout");
                            constraintLayout2 = null;
                        }
                        constraintLayout2.setVisibility(8);
                        linearLayout2 = MultiSharePreviewPart.this.actionsLayout;
                        if (linearLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("actionsLayout");
                            linearLayout2 = null;
                        }
                        linearLayout2.setVisibility(0);
                        qUIMultiLineInputView = MultiSharePreviewPart.this.editTextView;
                        if (qUIMultiLineInputView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("editTextView");
                            qUIMultiLineInputView = null;
                        }
                        qUIMultiLineInputView.p();
                        InputMethodUtil.hide(MultiSharePreviewPart.this.getActivity());
                    }
                } else {
                    list2 = MultiSharePreviewPart.this.chosenUserBeans;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    list2.addAll(it);
                    Context context = MultiSharePreviewPart.this.getContext();
                    list3 = MultiSharePreviewPart.this.chosenUserBeans;
                    O9 = O9 + context.getString(R.string.f169492ih, Integer.valueOf(list3.size()));
                    constraintLayout = MultiSharePreviewPart.this.previewLayout;
                    if (constraintLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("previewLayout");
                        constraintLayout = null;
                    }
                    constraintLayout.setVisibility(0);
                    linearLayout = MultiSharePreviewPart.this.actionsLayout;
                    if (linearLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionsLayout");
                        linearLayout = null;
                    }
                    linearLayout.setVisibility(8);
                    MultiSharePreviewPart.this.ba();
                    intent = MultiSharePreviewPart.this.forwardIntent;
                    if (intent != null) {
                        MultiSharePreviewPart.this.X9(true);
                    } else {
                        O9 = HardCodeUtil.qqStr(R.string.f169452id);
                        Intrinsics.checkNotNullExpressionValue(O9, "qqStr(R.string.multi_share_loading)");
                        MultiSharePreviewPart.this.Y9();
                    }
                }
                qUIButton = MultiSharePreviewPart.this.sendBtn;
                if (qUIButton == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
                } else {
                    qUIButton3 = qUIButton;
                }
                qUIButton3.setText(O9);
            }
        };
        L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.multishare.part.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MultiSharePreviewPart.Q9(Function1.this, obj);
            }
        });
        MutableLiveData<Intent> M1 = aVar.M1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Intent, Unit> function12 = new Function1<Intent, Unit>() { // from class: com.tencent.mobileqq.multishare.part.MultiSharePreviewPart$initViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MultiSharePreviewPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                invoke2(intent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Intent intent) {
                QUIButton qUIButton;
                String O9;
                List list;
                QUIButton qUIButton2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
                    return;
                }
                MultiSharePreviewPart.this.forwardIntent = intent;
                qUIButton = MultiSharePreviewPart.this.sendBtn;
                QUIButton qUIButton3 = null;
                if (qUIButton == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
                    qUIButton = null;
                }
                qUIButton.s();
                O9 = MultiSharePreviewPart.this.O9();
                Context context = MultiSharePreviewPart.this.getContext();
                list = MultiSharePreviewPart.this.chosenUserBeans;
                String str = O9 + context.getString(R.string.f169492ih, Integer.valueOf(list.size()));
                qUIButton2 = MultiSharePreviewPart.this.sendBtn;
                if (qUIButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
                } else {
                    qUIButton3 = qUIButton2;
                }
                qUIButton3.setText(str);
                MultiSharePreviewPart.this.X9(true);
                MultiSharePreviewPart.this.P9();
            }
        };
        M1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.multishare.part.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MultiSharePreviewPart.R9(Function1.this, obj);
            }
        });
    }

    public final boolean N9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.alwaysShowPreviewLayout;
    }

    public final void T9(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.alwaysShowPreviewLayout = z16;
        }
    }

    public final void U9(@Nullable j92.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) aVar);
        } else {
            this.msgChecker = aVar;
        }
    }

    public final void V9(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.msgHint = str;
        }
    }

    public final void W9(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.preLeaveMsg = str;
        }
    }

    public final void Z9(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.sendBtnText = str;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f166347zj0) {
                S9();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        boolean z16;
        MultiShareBottomDialogFragment multiShareBottomDialogFragment;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.ziv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.multi_share_divider)");
        this.dividerView = findViewById;
        View findViewById2 = rootView.findViewById(R.id.f166350zj3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026lti_share_send_container)");
        this.shareSendContainer = (FrameLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.ziz);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026lti_share_preview_layout)");
        this.previewLayout = (ConstraintLayout) findViewById3;
        com.tencent.mobileqq.multishare.util.c cVar = com.tencent.mobileqq.multishare.util.c.f251800a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ConstraintLayout constraintLayout = this.previewLayout;
        ConstraintLayout constraintLayout2 = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewLayout");
            constraintLayout = null;
        }
        cVar.i(context, constraintLayout);
        View findViewById4 = rootView.findViewById(R.id.ziq);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026lti_share_actions_layout)");
        this.actionsLayout = (LinearLayout) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.ziy);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026re_preview_inside_layout)");
        this.previewInsideLayout = (FrameLayout) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f166347zj0);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.multi_share_send)");
        this.sendBtn = (QUIButton) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.zix);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026_share_preview_edit_text)");
        QUIMultiLineInputView qUIMultiLineInputView = (QUIMultiLineInputView) findViewById7;
        this.editTextView = qUIMultiLineInputView;
        if (qUIMultiLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editTextView");
            qUIMultiLineInputView = null;
        }
        qUIMultiLineInputView.setStyle(2);
        String str = this.msgHint;
        boolean z17 = true;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            QUIMultiLineInputView qUIMultiLineInputView2 = this.editTextView;
            if (qUIMultiLineInputView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editTextView");
                qUIMultiLineInputView2 = null;
            }
            qUIMultiLineInputView2.setHint(this.msgHint);
        }
        String str2 = this.preLeaveMsg;
        if (str2 != null && str2.length() != 0) {
            z17 = false;
        }
        if (!z17) {
            QUIMultiLineInputView qUIMultiLineInputView3 = this.editTextView;
            if (qUIMultiLineInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editTextView");
                qUIMultiLineInputView3 = null;
            }
            qUIMultiLineInputView3.setContentText(this.preLeaveMsg);
        }
        X9(false);
        QUIButton qUIButton = this.sendBtn;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(this);
        initViewModel();
        P9();
        IPartHost partHost = getPartHost();
        if (partHost instanceof MultiShareBottomDialogFragment) {
            multiShareBottomDialogFragment = (MultiShareBottomDialogFragment) partHost;
        } else {
            multiShareBottomDialogFragment = null;
        }
        if (multiShareBottomDialogFragment != null) {
            intent = multiShareBottomDialogFragment.rh();
        } else {
            intent = null;
        }
        this.forwardIntent = intent;
        if (this.alwaysShowPreviewLayout) {
            LinearLayout linearLayout = this.actionsLayout;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionsLayout");
                linearLayout = null;
            }
            linearLayout.setVisibility(8);
            ConstraintLayout constraintLayout3 = this.previewLayout;
            if (constraintLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previewLayout");
            } else {
                constraintLayout2 = constraintLayout3;
            }
            constraintLayout2.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        QUIButton qUIButton = this.sendBtn;
        QUIMultiLineInputView qUIMultiLineInputView = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
            qUIButton = null;
        }
        qUIButton.s();
        QUIMultiLineInputView qUIMultiLineInputView2 = this.editTextView;
        if (qUIMultiLineInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editTextView");
        } else {
            qUIMultiLineInputView = qUIMultiLineInputView2;
        }
        qUIMultiLineInputView.p();
        InputMethodUtil.hide(activity);
    }
}
