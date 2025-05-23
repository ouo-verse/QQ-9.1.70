package com.tencent.mobileqq.ad.debug;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b&\u0018\u0000 F2\u00020\u0001:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0014J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010)\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010$R\u0016\u0010+\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010$R\u0016\u0010-\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010$R\u0016\u0010/\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010$R\u0016\u00101\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010\u0016R\u0016\u00103\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010\u0016R\u0016\u00105\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010\u0016R\u0016\u00107\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u0010\u001aR\u0016\u00109\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u0010\u001aR\u0016\u0010;\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010\u001aR\u0016\u0010=\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010\u0016R\u0016\u0010?\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010\u001aR\u0016\u0010A\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010\u0016R\u0016\u0010C\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010\u001a\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/ad/debug/RewardAdDebugFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initViews", "Fh", "Eh", "", "inputStr", "", Element.ELEMENT_NAME_MIN, "max", "default", "Vh", "getContentLayoutId", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "mVasAdRewardTypeInput", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "mVasAdRewardTypeConfirm", "E", "mVasRewardAdReq", UserInfo.SEX_FEMALE, "mVasRewardAdShow", "G", "mVasRewardAdReport", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "H", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "mGdtVideoViewVolumeOnSwitch", "I", "mGdtMvNativeSwitch", "J", "mGdtMvStyleSwitch", "K", "mGdtMvBottomClickModeSwitch", "L", "mGdtMvEndCardClickModeSwitch", "M", "mGdtMvNoneButtonStyleSwitch", "N", "mGdtMvStyleInput", "P", "mGdtMvBottomClickModeInput", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mGdtMvEndCardClickModeInput", BdhLogUtil.LogTag.Tag_Req, "mGdtMvStyleText", ExifInterface.LATITUDE_SOUTH, "mGdtMvBottomClickModeText", "T", "mGdtMvEndCardClickModeText", "U", "mGdtMvDebugMiniAppIdPortraitInput", "V", "mGdtMvDebugMiniAppPortraitStart", "W", "mGdtMvDebugMiniAppIdLandscapeInput", "X", "mGdtMvDebugMiniAppLandscapeStart", "<init>", "()V", "Y", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class RewardAdDebugFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private QUISingleLineInputView mVasAdRewardTypeInput;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mVasAdRewardTypeConfirm;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView mVasRewardAdReq;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mVasRewardAdShow;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mVasRewardAdReport;

    /* renamed from: H, reason: from kotlin metadata */
    private FormSwitchItem mGdtVideoViewVolumeOnSwitch;

    /* renamed from: I, reason: from kotlin metadata */
    private FormSwitchItem mGdtMvNativeSwitch;

    /* renamed from: J, reason: from kotlin metadata */
    private FormSwitchItem mGdtMvStyleSwitch;

    /* renamed from: K, reason: from kotlin metadata */
    private FormSwitchItem mGdtMvBottomClickModeSwitch;

    /* renamed from: L, reason: from kotlin metadata */
    private FormSwitchItem mGdtMvEndCardClickModeSwitch;

    /* renamed from: M, reason: from kotlin metadata */
    private FormSwitchItem mGdtMvNoneButtonStyleSwitch;

    /* renamed from: N, reason: from kotlin metadata */
    private QUISingleLineInputView mGdtMvStyleInput;

    /* renamed from: P, reason: from kotlin metadata */
    private QUISingleLineInputView mGdtMvBottomClickModeInput;

    /* renamed from: Q, reason: from kotlin metadata */
    private QUISingleLineInputView mGdtMvEndCardClickModeInput;

    /* renamed from: R, reason: from kotlin metadata */
    private TextView mGdtMvStyleText;

    /* renamed from: S, reason: from kotlin metadata */
    private TextView mGdtMvBottomClickModeText;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView mGdtMvEndCardClickModeText;

    /* renamed from: U, reason: from kotlin metadata */
    private QUISingleLineInputView mGdtMvDebugMiniAppIdPortraitInput;

    /* renamed from: V, reason: from kotlin metadata */
    private TextView mGdtMvDebugMiniAppPortraitStart;

    /* renamed from: W, reason: from kotlin metadata */
    private QUISingleLineInputView mGdtMvDebugMiniAppIdLandscapeInput;

    /* renamed from: X, reason: from kotlin metadata */
    private TextView mGdtMvDebugMiniAppLandscapeStart;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/ad/debug/RewardAdDebugFragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "a", "", "TAG", "Ljava/lang/String;", "TITLE", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ad.debug.RewardAdDebugFragment$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@Nullable Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            } else if (activity == null) {
                QLog.e("RewardAdDebugFragment", 1, "start error");
            } else {
                QPublicFragmentActivity.start(activity, RewardAdDebugFragment.class);
            }
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27835);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RewardAdDebugFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void Eh() {
        QUISingleLineInputView qUISingleLineInputView = this.mVasAdRewardTypeInput;
        QUISingleLineInputView qUISingleLineInputView2 = null;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVasAdRewardTypeInput");
            qUISingleLineInputView = null;
        }
        qUISingleLineInputView.setContentText(String.valueOf(a.f186830a.l()));
        QUISingleLineInputView qUISingleLineInputView3 = this.mVasAdRewardTypeInput;
        if (qUISingleLineInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVasAdRewardTypeInput");
            qUISingleLineInputView3 = null;
        }
        qUISingleLineInputView3.setPromptText("\u8bf7\u8f93\u5165rewardType\u5e76\u786e\u8ba4");
        QUISingleLineInputView qUISingleLineInputView4 = this.mVasAdRewardTypeInput;
        if (qUISingleLineInputView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVasAdRewardTypeInput");
            qUISingleLineInputView4 = null;
        }
        qUISingleLineInputView4.setShowWordCount(false);
        QUISingleLineInputView qUISingleLineInputView5 = this.mGdtMvStyleInput;
        if (qUISingleLineInputView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvStyleInput");
            qUISingleLineInputView5 = null;
        }
        qUISingleLineInputView5.setPromptText("1:\u9759\u6001\u5361\u7247,3:\u70b9\u6ed1\u5361\u7247");
        QUISingleLineInputView qUISingleLineInputView6 = this.mGdtMvStyleInput;
        if (qUISingleLineInputView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvStyleInput");
            qUISingleLineInputView6 = null;
        }
        qUISingleLineInputView6.setShowWordCount(false);
        QUISingleLineInputView qUISingleLineInputView7 = this.mGdtMvBottomClickModeInput;
        if (qUISingleLineInputView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvBottomClickModeInput");
            qUISingleLineInputView7 = null;
        }
        qUISingleLineInputView7.setPromptText("1:\u6309\u94ae,2:\u5361\u7247,3:\u5143\u7d20,4:\u5168\u5c4f");
        QUISingleLineInputView qUISingleLineInputView8 = this.mGdtMvBottomClickModeInput;
        if (qUISingleLineInputView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvBottomClickModeInput");
            qUISingleLineInputView8 = null;
        }
        qUISingleLineInputView8.setShowWordCount(false);
        QUISingleLineInputView qUISingleLineInputView9 = this.mGdtMvEndCardClickModeInput;
        if (qUISingleLineInputView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvEndCardClickModeInput");
            qUISingleLineInputView9 = null;
        }
        qUISingleLineInputView9.setPromptText("1:\u6309\u94ae,2:\u5361\u7247,3:\u5143\u7d20,4:\u5168\u5c4f");
        QUISingleLineInputView qUISingleLineInputView10 = this.mGdtMvEndCardClickModeInput;
        if (qUISingleLineInputView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvEndCardClickModeInput");
            qUISingleLineInputView10 = null;
        }
        qUISingleLineInputView10.setShowWordCount(false);
        QUISingleLineInputView qUISingleLineInputView11 = this.mGdtMvDebugMiniAppIdPortraitInput;
        if (qUISingleLineInputView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvDebugMiniAppIdPortraitInput");
            qUISingleLineInputView11 = null;
        }
        qUISingleLineInputView11.setPromptText("\u5c0f\u7a0b\u5e8f/\u5c0f\u6e38\u620f appid");
        QUISingleLineInputView qUISingleLineInputView12 = this.mGdtMvDebugMiniAppIdPortraitInput;
        if (qUISingleLineInputView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvDebugMiniAppIdPortraitInput");
            qUISingleLineInputView12 = null;
        }
        qUISingleLineInputView12.setContentText("1110905462");
        QUISingleLineInputView qUISingleLineInputView13 = this.mGdtMvDebugMiniAppIdPortraitInput;
        if (qUISingleLineInputView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvDebugMiniAppIdPortraitInput");
            qUISingleLineInputView13 = null;
        }
        qUISingleLineInputView13.setShowWordCount(false);
        QUISingleLineInputView qUISingleLineInputView14 = this.mGdtMvDebugMiniAppIdLandscapeInput;
        if (qUISingleLineInputView14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvDebugMiniAppIdLandscapeInput");
            qUISingleLineInputView14 = null;
        }
        qUISingleLineInputView14.setPromptText("\u5c0f\u7a0b\u5e8f/\u5c0f\u6e38\u620f appid");
        QUISingleLineInputView qUISingleLineInputView15 = this.mGdtMvDebugMiniAppIdLandscapeInput;
        if (qUISingleLineInputView15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvDebugMiniAppIdLandscapeInput");
            qUISingleLineInputView15 = null;
        }
        qUISingleLineInputView15.setContentText("1109836759");
        QUISingleLineInputView qUISingleLineInputView16 = this.mGdtMvDebugMiniAppIdLandscapeInput;
        if (qUISingleLineInputView16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvDebugMiniAppIdLandscapeInput");
        } else {
            qUISingleLineInputView2 = qUISingleLineInputView16;
        }
        qUISingleLineInputView2.setShowWordCount(false);
    }

    private final void Fh() {
        w.f186844a.e();
        TextView textView = this.mVasAdRewardTypeConfirm;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVasAdRewardTypeConfirm");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.ad.debug.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RewardAdDebugFragment.Gh(RewardAdDebugFragment.this, view);
            }
        });
        TextView textView3 = this.mVasRewardAdReq;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVasRewardAdReq");
            textView3 = null;
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.ad.debug.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RewardAdDebugFragment.Hh(RewardAdDebugFragment.this, view);
            }
        });
        TextView textView4 = this.mVasRewardAdShow;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVasRewardAdShow");
            textView4 = null;
        }
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.ad.debug.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RewardAdDebugFragment.Nh(RewardAdDebugFragment.this, view);
            }
        });
        TextView textView5 = this.mVasRewardAdReport;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVasRewardAdReport");
            textView5 = null;
        }
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.ad.debug.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RewardAdDebugFragment.Oh(RewardAdDebugFragment.this, view);
            }
        });
        FormSwitchItem formSwitchItem = this.mGdtVideoViewVolumeOnSwitch;
        if (formSwitchItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtVideoViewVolumeOnSwitch");
            formSwitchItem = null;
        }
        a aVar = a.f186830a;
        formSwitchItem.setChecked(aVar.j());
        FormSwitchItem formSwitchItem2 = this.mGdtVideoViewVolumeOnSwitch;
        if (formSwitchItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtVideoViewVolumeOnSwitch");
            formSwitchItem2 = null;
        }
        formSwitchItem2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.ad.debug.v
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                RewardAdDebugFragment.Ph(compoundButton, z16);
            }
        });
        FormSwitchItem formSwitchItem3 = this.mGdtMvNativeSwitch;
        if (formSwitchItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvNativeSwitch");
            formSwitchItem3 = null;
        }
        formSwitchItem3.setChecked(aVar.i());
        FormSwitchItem formSwitchItem4 = this.mGdtMvNativeSwitch;
        if (formSwitchItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvNativeSwitch");
            formSwitchItem4 = null;
        }
        formSwitchItem4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.ad.debug.i
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                RewardAdDebugFragment.Qh(compoundButton, z16);
            }
        });
        FormSwitchItem formSwitchItem5 = this.mGdtMvStyleSwitch;
        if (formSwitchItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvStyleSwitch");
            formSwitchItem5 = null;
        }
        formSwitchItem5.setChecked(aVar.f());
        FormSwitchItem formSwitchItem6 = this.mGdtMvStyleSwitch;
        if (formSwitchItem6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvStyleSwitch");
            formSwitchItem6 = null;
        }
        formSwitchItem6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.ad.debug.j
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                RewardAdDebugFragment.Rh(compoundButton, z16);
            }
        });
        FormSwitchItem formSwitchItem7 = this.mGdtMvBottomClickModeSwitch;
        if (formSwitchItem7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvBottomClickModeSwitch");
            formSwitchItem7 = null;
        }
        formSwitchItem7.setChecked(aVar.b());
        FormSwitchItem formSwitchItem8 = this.mGdtMvBottomClickModeSwitch;
        if (formSwitchItem8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvBottomClickModeSwitch");
            formSwitchItem8 = null;
        }
        formSwitchItem8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.ad.debug.k
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                RewardAdDebugFragment.Sh(compoundButton, z16);
            }
        });
        FormSwitchItem formSwitchItem9 = this.mGdtMvEndCardClickModeSwitch;
        if (formSwitchItem9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvEndCardClickModeSwitch");
            formSwitchItem9 = null;
        }
        formSwitchItem9.setChecked(aVar.d());
        FormSwitchItem formSwitchItem10 = this.mGdtMvEndCardClickModeSwitch;
        if (formSwitchItem10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvEndCardClickModeSwitch");
            formSwitchItem10 = null;
        }
        formSwitchItem10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.ad.debug.l
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                RewardAdDebugFragment.Th(compoundButton, z16);
            }
        });
        FormSwitchItem formSwitchItem11 = this.mGdtMvNoneButtonStyleSwitch;
        if (formSwitchItem11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvNoneButtonStyleSwitch");
            formSwitchItem11 = null;
        }
        formSwitchItem11.setChecked(aVar.h());
        FormSwitchItem formSwitchItem12 = this.mGdtMvNoneButtonStyleSwitch;
        if (formSwitchItem12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvNoneButtonStyleSwitch");
            formSwitchItem12 = null;
        }
        formSwitchItem12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.ad.debug.m
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                RewardAdDebugFragment.Uh(compoundButton, z16);
            }
        });
        TextView textView6 = this.mGdtMvStyleText;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvStyleText");
            textView6 = null;
        }
        textView6.setText("\u8bbe\u7f6e\u6fc0\u52b1\u5e7f\u544a\u6837\u5f0f:" + aVar.g());
        TextView textView7 = this.mGdtMvStyleText;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvStyleText");
            textView7 = null;
        }
        textView7.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.ad.debug.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RewardAdDebugFragment.Ih(RewardAdDebugFragment.this, view);
            }
        });
        TextView textView8 = this.mGdtMvBottomClickModeText;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvBottomClickModeText");
            textView8 = null;
        }
        textView8.setText("\u8bbe\u7f6eBottomCard\u70b9\u51fb\u533a\u57df:" + aVar.c());
        TextView textView9 = this.mGdtMvBottomClickModeText;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvBottomClickModeText");
            textView9 = null;
        }
        textView9.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.ad.debug.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RewardAdDebugFragment.Jh(RewardAdDebugFragment.this, view);
            }
        });
        TextView textView10 = this.mGdtMvEndCardClickModeText;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvEndCardClickModeText");
            textView10 = null;
        }
        textView10.setText("\u8bbe\u7f6eEndCard\u70b9\u51fb\u533a\u57df:" + aVar.e());
        TextView textView11 = this.mGdtMvEndCardClickModeText;
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvEndCardClickModeText");
            textView11 = null;
        }
        textView11.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.ad.debug.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RewardAdDebugFragment.Kh(RewardAdDebugFragment.this, view);
            }
        });
        TextView textView12 = this.mGdtMvDebugMiniAppPortraitStart;
        if (textView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvDebugMiniAppPortraitStart");
            textView12 = null;
        }
        textView12.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.ad.debug.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RewardAdDebugFragment.Lh(RewardAdDebugFragment.this, view);
            }
        });
        TextView textView13 = this.mGdtMvDebugMiniAppLandscapeStart;
        if (textView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvDebugMiniAppLandscapeStart");
        } else {
            textView2 = textView13;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.ad.debug.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RewardAdDebugFragment.Mh(RewardAdDebugFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(RewardAdDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUISingleLineInputView qUISingleLineInputView = this$0.mVasAdRewardTypeInput;
        TextView textView = null;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVasAdRewardTypeInput");
            qUISingleLineInputView = null;
        }
        int Vh = this$0.Vh(String.valueOf(qUISingleLineInputView.d()), 0, 1000, 0);
        a.f186830a.w(Vh);
        TextView textView2 = this$0.mVasAdRewardTypeConfirm;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVasAdRewardTypeConfirm");
        } else {
            textView = textView2;
        }
        textView.setText("\u8bbe\u7f6erewardType:" + Vh);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(RewardAdDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w wVar = w.f186844a;
        TextView textView = this$0.mVasRewardAdReq;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVasRewardAdReq");
            textView = null;
        }
        wVar.g(textView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(RewardAdDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUISingleLineInputView qUISingleLineInputView = this$0.mGdtMvStyleInput;
        TextView textView = null;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvStyleInput");
            qUISingleLineInputView = null;
        }
        int Vh = this$0.Vh(String.valueOf(qUISingleLineInputView.d()), 1, 5, 1);
        a.f186830a.r(Vh);
        TextView textView2 = this$0.mGdtMvStyleText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvStyleText");
        } else {
            textView = textView2;
        }
        textView.setText("\u8bbe\u7f6e\u6fc0\u52b1\u5e7f\u544a\u6837\u5f0f:" + Vh);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(RewardAdDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUISingleLineInputView qUISingleLineInputView = this$0.mGdtMvBottomClickModeInput;
        TextView textView = null;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvBottomClickModeInput");
            qUISingleLineInputView = null;
        }
        int Vh = this$0.Vh(String.valueOf(qUISingleLineInputView.d()), 1, 4, 1);
        a.f186830a.n(Vh);
        TextView textView2 = this$0.mGdtMvBottomClickModeText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvBottomClickModeText");
        } else {
            textView = textView2;
        }
        textView.setText("\u8bbe\u7f6eBottomCard\u70b9\u51fb\u533a\u57df:" + Vh);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(RewardAdDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUISingleLineInputView qUISingleLineInputView = this$0.mGdtMvEndCardClickModeInput;
        TextView textView = null;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvEndCardClickModeInput");
            qUISingleLineInputView = null;
        }
        int Vh = this$0.Vh(String.valueOf(qUISingleLineInputView.d()), 1, 4, 1);
        a.f186830a.p(Vh);
        TextView textView2 = this$0.mGdtMvEndCardClickModeText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvEndCardClickModeText");
        } else {
            textView = textView2;
        }
        textView.setText("\u8bbe\u7f6eEndCard\u70b9\u51fb\u533a\u57df:" + Vh);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(RewardAdDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUISingleLineInputView qUISingleLineInputView = this$0.mGdtMvDebugMiniAppIdPortraitInput;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvDebugMiniAppIdPortraitInput");
            qUISingleLineInputView = null;
        }
        String str = "https://m.q.qq.com/a/p/" + String.valueOf(qUISingleLineInputView.d());
        if (!TextUtils.isEmpty(str)) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(this$0.getContext(), str, 2016, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(RewardAdDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUISingleLineInputView qUISingleLineInputView = this$0.mGdtMvDebugMiniAppIdLandscapeInput;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGdtMvDebugMiniAppIdLandscapeInput");
            qUISingleLineInputView = null;
        }
        String str = "https://m.q.qq.com/a/p/" + String.valueOf(qUISingleLineInputView.d());
        if (!TextUtils.isEmpty(str)) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(this$0.getContext(), str, 2016, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(RewardAdDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w wVar = w.f186844a;
        FragmentActivity activity = this$0.getActivity();
        TextView textView = this$0.mVasRewardAdReq;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVasRewardAdReq");
            textView = null;
        }
        TextView textView3 = this$0.mVasRewardAdShow;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVasRewardAdShow");
            textView3 = null;
        }
        TextView textView4 = this$0.mVasRewardAdReport;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVasRewardAdReport");
        } else {
            textView2 = textView4;
        }
        wVar.h(activity, textView, textView3, textView2);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(RewardAdDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w wVar = w.f186844a;
        TextView textView = this$0.mVasRewardAdReport;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVasRewardAdReport");
            textView = null;
        }
        wVar.f(textView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        a.f186830a.u(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        a.f186830a.t(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        a.f186830a.q(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        a.f186830a.m(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        a.f186830a.o(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        a.f186830a.s(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final int Vh(String inputStr, int min, int max, int r65) {
        if (TextUtils.isEmpty(inputStr)) {
            return r65;
        }
        boolean z16 = true;
        try {
            int parseInt = Integer.parseInt(inputStr);
            if (min > parseInt || parseInt > max) {
                z16 = false;
            }
            if (z16) {
                return parseInt;
            }
            return r65;
        } catch (Throwable th5) {
            QLog.e("RewardAdDebugFragment", 1, "parseInputInt error:", th5);
            return r65;
        }
    }

    private final void initViews(View rootView) {
        View findViewById = rootView.findViewById(R.id.f58782qy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026ad_vas_reward_type_input)");
        this.mVasAdRewardTypeInput = (QUISingleLineInputView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f58772qx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026_vas_reward_type_confirm)");
        this.mVasAdRewardTypeConfirm = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f58752qv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026.qq_ad_vas_reward_ad_req)");
        this.mVasRewardAdReq = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f58762qw);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026qq_ad_vas_reward_ad_show)");
        this.mVasRewardAdShow = (TextView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f58742qu);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026_ad_vas_reward_ad_report)");
        this.mVasRewardAdReport = (TextView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f58562qc);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026eo_view_volume_on_switch)");
        this.mGdtVideoViewVolumeOnSwitch = (FormSwitchItem) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f58662qm);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026q_ad_gdtmv_native_switch)");
        this.mGdtMvNativeSwitch = (FormSwitchItem) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.f58702qq);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.\u2026qq_ad_gdtmv_style_switch)");
        this.mGdtMvStyleSwitch = (FormSwitchItem) findViewById8;
        View findViewById9 = rootView.findViewById(R.id.f58582qe);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.\u2026bottom_click_mode_switch)");
        this.mGdtMvBottomClickModeSwitch = (FormSwitchItem) findViewById9;
        View findViewById10 = rootView.findViewById(R.id.f58612qh);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "rootView.findViewById(R.\u2026d_card_click_mode_switch)");
        this.mGdtMvEndCardClickModeSwitch = (FormSwitchItem) findViewById10;
        View findViewById11 = rootView.findViewById(R.id.f58652ql);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "rootView.findViewById(R.\u2026ative_none_button_switch)");
        this.mGdtMvNoneButtonStyleSwitch = (FormSwitchItem) findViewById11;
        View findViewById12 = rootView.findViewById(R.id.f58692qp);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "rootView.findViewById(R.\u2026.qq_ad_gdtmv_style_input)");
        this.mGdtMvStyleInput = (QUISingleLineInputView) findViewById12;
        View findViewById13 = rootView.findViewById(R.id.f58572qd);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "rootView.findViewById(R.\u2026_bottom_click_mode_input)");
        this.mGdtMvBottomClickModeInput = (QUISingleLineInputView) findViewById13;
        View findViewById14 = rootView.findViewById(R.id.f58602qg);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "rootView.findViewById(R.\u2026nd_card_click_mode_input)");
        this.mGdtMvEndCardClickModeInput = (QUISingleLineInputView) findViewById14;
        View findViewById15 = rootView.findViewById(R.id.f58712qr);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "rootView.findViewById(R.id.qq_ad_gdtmv_style_text)");
        this.mGdtMvStyleText = (TextView) findViewById15;
        View findViewById16 = rootView.findViewById(R.id.f58592qf);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "rootView.findViewById(R.\u2026v_bottom_click_mode_text)");
        this.mGdtMvBottomClickModeText = (TextView) findViewById16;
        View findViewById17 = rootView.findViewById(R.id.f58622qi);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "rootView.findViewById(R.\u2026end_card_click_mode_text)");
        this.mGdtMvEndCardClickModeText = (TextView) findViewById17;
        View findViewById18 = rootView.findViewById(R.id.f58642qk);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "rootView.findViewById(R.\u2026mini_appid_input_portait)");
        this.mGdtMvDebugMiniAppIdPortraitInput = (QUISingleLineInputView) findViewById18;
        View findViewById19 = rootView.findViewById(R.id.f58682qo);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "rootView.findViewById(R.\u2026_start_mini_game_portait)");
        this.mGdtMvDebugMiniAppPortraitStart = (TextView) findViewById19;
        View findViewById20 = rootView.findViewById(R.id.f58632qj);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "rootView.findViewById(R.\u2026ni_appid_input_landscape)");
        this.mGdtMvDebugMiniAppIdLandscapeInput = (QUISingleLineInputView) findViewById20;
        View findViewById21 = rootView.findViewById(R.id.f58672qn);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "rootView.findViewById(R.\u2026tart_mini_game_landscape)");
        this.mGdtMvDebugMiniAppLandscapeStart = (TextView) findViewById21;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.h1f;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle("\u6fc0\u52b1\u5e7f\u544a\u6d4b\u8bd5");
        initViews(view);
        Fh();
        Eh();
    }
}
