package com.tencent.mobileqq.wifiphoto.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifiphoto.data.WifiPhotoInfo;
import com.tencent.mobileqq.wifiphoto.fragment.RequestApplyFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernel.nativeinterface.AuthorizationStatus;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.util.UiThreadUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@RoutePage(desc = "PC\u7aef\u53d1\u8d77\u6388\u6743\u8bf7\u6c42\u9875", path = "/wifi_photo/request_apply")
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u001c\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0014\u0010\u0015\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J$\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/wifiphoto/fragment/RequestApplyFragment;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "Landroid/content/Intent;", "intent", "", "dealIntent", "checkPermission", "refreshState", "initWifiPhotoInfo", "refreshInitState", "accessRequest", "fixFoldDeviceUi", "refreshConnectedState", "", "showDialog", "", "errorCode", "refreshDisconnectState", "showDisconnectDialog", "Landroid/view/View;", "visibility", "recordTimeAndShow", "reportViewDuration", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "onNewIntent", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lm53/h;", "binding", "Lm53/h;", "Lcom/tencent/mobileqq/wifiphoto/data/WifiPhotoInfo;", "wifiPhotoInfo", "Lcom/tencent/mobileqq/wifiphoto/data/WifiPhotoInfo;", "<init>", "()V", "Companion", "a", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class RequestApplyFragment extends QBaseFragment {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String ERROR_CODE = "ERROR_CODE";

    @NotNull
    public static final String INFO_KEY = "INFO_KEY";

    @NotNull
    public static final String NEED_REPORT_KEY = "NEED_REPORT_KEY";
    public static final int STATE_CONNECTED = 2;
    public static final int STATE_DISCONNECT = 3;
    public static final int STATE_INIT = 1;

    @NotNull
    private static final String TAG = "WifiPhotoActivity";
    private m53.h binding;

    @Nullable
    private WifiPhotoInfo wifiPhotoInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wifiphoto/fragment/RequestApplyFragment$a;", "", "", RequestApplyFragment.ERROR_CODE, "Ljava/lang/String;", RequestApplyFragment.INFO_KEY, RequestApplyFragment.NEED_REPORT_KEY, "", "STATE_CONNECTED", "I", "STATE_DISCONNECT", "STATE_INIT", "TAG", "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wifiphoto.fragment.RequestApplyFragment$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25518);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RequestApplyFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void accessRequest() {
        com.tencent.mobileqq.wifiphoto.impl.global.f.e(com.tencent.mobileqq.wifiphoto.impl.global.f.f317624a, AuthorizationStatus.KFULLACCESS, 0, new IOperateCallback() { // from class: com.tencent.mobileqq.wifiphoto.fragment.s
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                RequestApplyFragment.accessRequest$lambda$8(RequestApplyFragment.this, i3, str);
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accessRequest$lambda$8(final RequestApplyFragment this$0, final int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            BannerManager.l().K(com.tencent.mobileqq.banner.d.f200256i, 2);
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.wifiphoto.fragment.j
                @Override // java.lang.Runnable
                public final void run() {
                    RequestApplyFragment.accessRequest$lambda$8$lambda$6(RequestApplyFragment.this);
                }
            });
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.wifiphoto.fragment.m
                @Override // java.lang.Runnable
                public final void run() {
                    RequestApplyFragment.accessRequest$lambda$8$lambda$7(RequestApplyFragment.this, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accessRequest$lambda$8$lambda$6(RequestApplyFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.requireActivity(), "\u6388\u6743\u6210\u529f", 0).show();
        this$0.refreshConnectedState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accessRequest$lambda$8$lambda$7(RequestApplyFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.refreshDisconnectState(false, i3);
    }

    private final void checkPermission() {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.DATALINE, QQPermissionConstants.Business.SCENE.DATALINE_EXPORT_PHOTO));
        if (qQPermission != null && qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            qQPermission.requestPermissions(QQPermissionConstants.Permission.GROUP_STORAGE, 2, new b());
        } else {
            accessRequest();
        }
    }

    private final void dealIntent(Intent intent) {
        refreshState(intent);
        if (intent.getBooleanExtra(NEED_REPORT_KEY, false)) {
            com.tencent.mobileqq.wifiphoto.data.a.i();
        }
    }

    private final void fixFoldDeviceUi() {
        if (!com.tencent.mobileqq.pad.c.e(requireActivity())) {
            QLog.i(TAG, 1, "is not need fix fold device open bug!");
            return;
        }
        m53.h hVar = this.binding;
        m53.h hVar2 = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar = null;
        }
        ViewGroup.LayoutParams layoutParams = hVar.f416252b.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = ViewUtils.dpToPx(80.0f);
        m53.h hVar3 = this.binding;
        if (hVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            hVar2 = hVar3;
        }
        hVar2.f416252b.setLayoutParams(layoutParams2);
    }

    private final void initWifiPhotoInfo(Intent intent) {
        WifiPhotoInfo wifiPhotoInfo = (WifiPhotoInfo) intent.getParcelableExtra(INFO_KEY);
        this.wifiPhotoInfo = wifiPhotoInfo;
        if (wifiPhotoInfo != null) {
            m53.h hVar = this.binding;
            m53.h hVar2 = null;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                hVar = null;
            }
            hVar.f416264n.setText(wifiPhotoInfo.b());
            m53.h hVar3 = this.binding;
            if (hVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                hVar3 = null;
            }
            hVar3.f416264n.setContentDescription(wifiPhotoInfo.b());
            m53.h hVar4 = this.binding;
            if (hVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                hVar4 = null;
            }
            hVar4.f416262l.setText(wifiPhotoInfo.a());
            m53.h hVar5 = this.binding;
            if (hVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                hVar2 = hVar5;
            }
            hVar2.f416262l.setContentDescription(wifiPhotoInfo.a());
        }
    }

    private final void recordTimeAndShow(View view, int i3) {
        view.setVisibility(i3);
        if (i3 == 0) {
            view.setTag(Long.valueOf(System.currentTimeMillis()));
        }
    }

    private final void refreshConnectedState() {
        reportViewDuration();
        m53.h hVar = this.binding;
        m53.h hVar2 = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar = null;
        }
        hVar.f416256f.setVisibility(8);
        m53.h hVar3 = this.binding;
        if (hVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar3 = null;
        }
        hVar3.f416257g.setVisibility(0);
        m53.h hVar4 = this.binding;
        if (hVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar4 = null;
        }
        hVar4.f416252b.setVisibility(8);
        m53.h hVar5 = this.binding;
        if (hVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar5 = null;
        }
        hVar5.f416255e.setVisibility(8);
        m53.h hVar6 = this.binding;
        if (hVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar6 = null;
        }
        hVar6.f416260j.setText(R.string.z5p);
        m53.h hVar7 = this.binding;
        if (hVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar7 = null;
        }
        TextView textView = hVar7.f416260j;
        m53.h hVar8 = this.binding;
        if (hVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar8 = null;
        }
        textView.setContentDescription(hVar8.f416260j.getText());
        SpannableString spannableString = new SpannableString("\u4e3a\u4fdd\u8bc1\u7535\u8111\u7a33\u5b9a\u5bfc\u51fa\u624b\u673a\u76f8\u518c\uff0c\u8fde\u63a5\u8fc7\u7a0b\u4e2d\u624b\u673a\u8bf7\u52ff\u5207\u6362\u7f51\u7edc\u3001\u7184\u5c4f\u6216\u79bb\u5f00QQ\u754c\u9762\u3002");
        spannableString.setSpan(new StyleSpan(1), 19, 38, 33);
        spannableString.setSpan(new ForegroundColorSpan(ie0.a.f().g(getContext(), R.color.qui_common_text_primary, 1000)), 19, 38, 33);
        m53.h hVar9 = this.binding;
        if (hVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar9 = null;
        }
        hVar9.f416265o.setText(spannableString);
        m53.h hVar10 = this.binding;
        if (hVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar10 = null;
        }
        TextView textView2 = hVar10.f416265o;
        m53.h hVar11 = this.binding;
        if (hVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar11 = null;
        }
        textView2.setContentDescription(hVar11.f416265o.getText());
        m53.h hVar12 = this.binding;
        if (hVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar12 = null;
        }
        QUIButton qUIButton = hVar12.f416253c;
        Intrinsics.checkNotNullExpressionValue(qUIButton, "binding.btnDisconnect");
        recordTimeAndShow(qUIButton, 0);
        m53.h hVar13 = this.binding;
        if (hVar13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar13 = null;
        }
        QUIButton qUIButton2 = hVar13.f416253c;
        Intrinsics.checkNotNullExpressionValue(qUIButton2, "binding.btnDisconnect");
        com.tencent.mobileqq.wifiphoto.data.a.c("em_bas_disconnect", qUIButton2);
        m53.h hVar14 = this.binding;
        if (hVar14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            hVar2 = hVar14;
        }
        hVar2.f416253c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wifiphoto.fragment.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RequestApplyFragment.refreshConnectedState$lambda$12(RequestApplyFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshConnectedState$lambda$12(final RequestApplyFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQCustomDialog qQCustomDialog = new QQCustomDialog(this$0.requireActivity());
        Window window = qQCustomDialog.getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        Window window2 = qQCustomDialog.getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
        qQCustomDialog.setContentView(R.layout.custom_dialog);
        qQCustomDialog.setTitle(R.string.zrs);
        qQCustomDialog.setMessage(R.string.zrr);
        qQCustomDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wifiphoto.fragment.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RequestApplyFragment.refreshConnectedState$lambda$12$lambda$10(dialogInterface, i3);
            }
        }).setPositiveButton(R.string.znf, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wifiphoto.fragment.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RequestApplyFragment.refreshConnectedState$lambda$12$lambda$11(RequestApplyFragment.this, dialogInterface, i3);
            }
        }).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshConnectedState$lambda$12$lambda$11(RequestApplyFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wifiphoto.impl.global.f.f317624a.B();
        BannerManager.l().N(com.tencent.mobileqq.banner.d.f200256i, 0, -1);
        QQToast.makeText(this$0.requireActivity(), 1, "\u8fde\u63a5\u5df2\u65ad\u5f00", 0).show();
        this$0.requireActivity().finish();
    }

    private final void refreshDisconnectState(boolean showDialog, int errorCode) {
        QLog.i(TAG, 1, "refreshDisconnectState showDialog: " + showDialog + ", errorCode: " + errorCode);
        reportViewDuration();
        m53.h hVar = null;
        if (errorCode != 9998) {
            if (errorCode != 9999 && errorCode != 70001) {
                m53.h hVar2 = this.binding;
                if (hVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    hVar2 = null;
                }
                hVar2.f416259i.setText(R.string.z5u);
            } else {
                m53.h hVar3 = this.binding;
                if (hVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    hVar3 = null;
                }
                hVar3.f416259i.setText(R.string.f238747kl);
            }
        } else {
            m53.h hVar4 = this.binding;
            if (hVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                hVar4 = null;
            }
            hVar4.f416259i.setText(R.string.f238737kk);
        }
        m53.h hVar5 = this.binding;
        if (hVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar5 = null;
        }
        TextView textView = hVar5.f416259i;
        m53.h hVar6 = this.binding;
        if (hVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar6 = null;
        }
        textView.setContentDescription(hVar6.f416259i.getText());
        m53.h hVar7 = this.binding;
        if (hVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar7 = null;
        }
        hVar7.f416256f.setVisibility(0);
        m53.h hVar8 = this.binding;
        if (hVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar8 = null;
        }
        hVar8.f416266p.setVisibility(0);
        m53.h hVar9 = this.binding;
        if (hVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar9 = null;
        }
        hVar9.f416258h.setVisibility(0);
        m53.h hVar10 = this.binding;
        if (hVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar10 = null;
        }
        hVar10.f416259i.setVisibility(0);
        m53.h hVar11 = this.binding;
        if (hVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar11 = null;
        }
        hVar11.f416254d.setVisibility(0);
        m53.h hVar12 = this.binding;
        if (hVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar12 = null;
        }
        hVar12.f416257g.setVisibility(8);
        m53.h hVar13 = this.binding;
        if (hVar13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar13 = null;
        }
        hVar13.f416269s.setVisibility(8);
        m53.h hVar14 = this.binding;
        if (hVar14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar14 = null;
        }
        hVar14.f416260j.setVisibility(8);
        m53.h hVar15 = this.binding;
        if (hVar15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar15 = null;
        }
        hVar15.f416267q.setVisibility(8);
        m53.h hVar16 = this.binding;
        if (hVar16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar16 = null;
        }
        hVar16.f416261k.setVisibility(8);
        m53.h hVar17 = this.binding;
        if (hVar17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar17 = null;
        }
        hVar17.f416262l.setVisibility(8);
        m53.h hVar18 = this.binding;
        if (hVar18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar18 = null;
        }
        hVar18.f416268r.setVisibility(8);
        m53.h hVar19 = this.binding;
        if (hVar19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar19 = null;
        }
        hVar19.f416265o.setVisibility(8);
        m53.h hVar20 = this.binding;
        if (hVar20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar20 = null;
        }
        hVar20.f416252b.setVisibility(8);
        m53.h hVar21 = this.binding;
        if (hVar21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar21 = null;
        }
        hVar21.f416255e.setVisibility(8);
        m53.h hVar22 = this.binding;
        if (hVar22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar22 = null;
        }
        hVar22.f416253c.setVisibility(8);
        m53.h hVar23 = this.binding;
        if (hVar23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar23 = null;
        }
        QUIButton qUIButton = hVar23.f416254d;
        Intrinsics.checkNotNullExpressionValue(qUIButton, "binding.btnGetIt");
        recordTimeAndShow(qUIButton, 0);
        m53.h hVar24 = this.binding;
        if (hVar24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            hVar = hVar24;
        }
        hVar.f416254d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wifiphoto.fragment.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RequestApplyFragment.refreshDisconnectState$lambda$13(RequestApplyFragment.this, view);
            }
        });
        if (showDialog) {
            showDisconnectDialog(errorCode);
        }
    }

    static /* synthetic */ void refreshDisconnectState$default(RequestApplyFragment requestApplyFragment, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = false;
        }
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        requestApplyFragment.refreshDisconnectState(z16, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshDisconnectState$lambda$13(RequestApplyFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void refreshInitState() {
        reportViewDuration();
        m53.h hVar = this.binding;
        m53.h hVar2 = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar = null;
        }
        hVar.f416256f.setVisibility(8);
        m53.h hVar3 = this.binding;
        if (hVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar3 = null;
        }
        hVar3.f416257g.setVisibility(0);
        m53.h hVar4 = this.binding;
        if (hVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar4 = null;
        }
        hVar4.f416253c.setVisibility(8);
        m53.h hVar5 = this.binding;
        if (hVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar5 = null;
        }
        QUIButton qUIButton = hVar5.f416252b;
        Intrinsics.checkNotNullExpressionValue(qUIButton, "binding.btnApply");
        recordTimeAndShow(qUIButton, 0);
        m53.h hVar6 = this.binding;
        if (hVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar6 = null;
        }
        hVar6.f416255e.setVisibility(0);
        m53.h hVar7 = this.binding;
        if (hVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar7 = null;
        }
        hVar7.f416260j.setText(R.string.f170418z60);
        m53.h hVar8 = this.binding;
        if (hVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar8 = null;
        }
        TextView textView = hVar8.f416260j;
        m53.h hVar9 = this.binding;
        if (hVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar9 = null;
        }
        textView.setContentDescription(hVar9.f416260j.getText());
        m53.h hVar10 = this.binding;
        if (hVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar10 = null;
        }
        hVar10.f416265o.setText(R.string.f170420z62);
        m53.h hVar11 = this.binding;
        if (hVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar11 = null;
        }
        TextView textView2 = hVar11.f416265o;
        m53.h hVar12 = this.binding;
        if (hVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar12 = null;
        }
        textView2.setContentDescription(hVar12.f416265o.getText());
        m53.h hVar13 = this.binding;
        if (hVar13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar13 = null;
        }
        hVar13.f416252b.setEnabled(true);
        m53.h hVar14 = this.binding;
        if (hVar14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar14 = null;
        }
        QUIButton qUIButton2 = hVar14.f416252b;
        Intrinsics.checkNotNullExpressionValue(qUIButton2, "binding.btnApply");
        com.tencent.mobileqq.wifiphoto.data.a.c("em_bas_authorization_button", qUIButton2);
        m53.h hVar15 = this.binding;
        if (hVar15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar15 = null;
        }
        hVar15.f416252b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wifiphoto.fragment.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RequestApplyFragment.refreshInitState$lambda$2(RequestApplyFragment.this, view);
            }
        });
        m53.h hVar16 = this.binding;
        if (hVar16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar16 = null;
        }
        QUIButton qUIButton3 = hVar16.f416255e;
        Intrinsics.checkNotNullExpressionValue(qUIButton3, "binding.btnReject");
        com.tencent.mobileqq.wifiphoto.data.a.c("em_bas_reject", qUIButton3);
        m53.h hVar17 = this.binding;
        if (hVar17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            hVar2 = hVar17;
        }
        hVar2.f416255e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wifiphoto.fragment.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RequestApplyFragment.refreshInitState$lambda$5(RequestApplyFragment.this, view);
            }
        });
        fixFoldDeviceUi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshInitState$lambda$2(RequestApplyFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wifiphoto.impl.global.f fVar = com.tencent.mobileqq.wifiphoto.impl.global.f.f317624a;
        if (fVar.E() != -1) {
            this$0.refreshDisconnectState(false, fVar.E());
        } else {
            m53.h hVar = this$0.binding;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                hVar = null;
            }
            hVar.f416252b.setEnabled(false);
            this$0.checkPermission();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshInitState$lambda$5(final RequestApplyFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.wifiphoto.fragment.q
            @Override // java.lang.Runnable
            public final void run() {
                RequestApplyFragment.refreshInitState$lambda$5$lambda$3(RequestApplyFragment.this);
            }
        });
        com.tencent.mobileqq.wifiphoto.impl.global.f.f317624a.J(10003, new IOperateCallback() { // from class: com.tencent.mobileqq.wifiphoto.fragment.r
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                RequestApplyFragment.refreshInitState$lambda$5$lambda$4(RequestApplyFragment.this, i3, str);
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshInitState$lambda$5$lambda$3(RequestApplyFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.requireActivity(), 1, "\u6388\u6743\u7533\u8bf7\u5df2\u62d2\u7edd", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshInitState$lambda$5$lambda$4(RequestApplyFragment this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireActivity().finish();
    }

    private final void refreshState(Intent intent) {
        int E;
        com.tencent.mobileqq.wifiphoto.impl.global.f fVar = com.tencent.mobileqq.wifiphoto.impl.global.f.f317624a;
        int F = fVar.F();
        boolean z16 = true;
        if (F != 1) {
            if (F != 2) {
                if (F == 3) {
                    if (intent.getIntExtra(ERROR_CODE, -1) > 0) {
                        E = intent.getIntExtra(ERROR_CODE, -1);
                    } else {
                        E = fVar.E();
                    }
                    if (E == 9998 || E == 9999) {
                        z16 = false;
                    }
                    refreshDisconnectState(z16, E);
                    return;
                }
                return;
            }
            initWifiPhotoInfo(intent);
            refreshConnectedState();
            return;
        }
        initWifiPhotoInfo(intent);
        refreshInitState();
    }

    private final void reportViewDuration() {
        QUIButton qUIButton;
        int i3;
        m53.h hVar = this.binding;
        Long l3 = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar = null;
        }
        if (hVar.f416252b.getVisibility() == 0) {
            m53.h hVar2 = this.binding;
            if (hVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                hVar2 = null;
            }
            qUIButton = hVar2.f416252b;
            i3 = 1;
        } else {
            m53.h hVar3 = this.binding;
            if (hVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                hVar3 = null;
            }
            if (hVar3.f416253c.getVisibility() == 0) {
                m53.h hVar4 = this.binding;
                if (hVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    hVar4 = null;
                }
                qUIButton = hVar4.f416253c;
                i3 = 2;
            } else {
                m53.h hVar5 = this.binding;
                if (hVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    hVar5 = null;
                }
                if (hVar5.f416254d.getVisibility() == 0) {
                    m53.h hVar6 = this.binding;
                    if (hVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        hVar6 = null;
                    }
                    qUIButton = hVar6.f416254d;
                    i3 = 3;
                } else {
                    return;
                }
            }
        }
        Intrinsics.checkNotNullExpressionValue(qUIButton, "if (binding.btnApply.vis\u2026         return\n        }");
        long currentTimeMillis = System.currentTimeMillis();
        Object tag = qUIButton.getTag();
        if (tag instanceof Long) {
            l3 = (Long) tag;
        }
        if (l3 != null) {
            long longValue = currentTimeMillis - l3.longValue();
            QLog.i(TAG, 1, "report type: " + i3 + ", duration: " + longValue);
            com.tencent.mobileqq.wifiphoto.data.a.h(i3, longValue);
        }
    }

    private final void showDisconnectDialog(int errorCode) {
        int i3;
        int i16;
        QQCustomDialog qQCustomDialog = new QQCustomDialog(requireActivity());
        Window window = qQCustomDialog.getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        Window window2 = qQCustomDialog.getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
        qQCustomDialog.setContentView(R.layout.custom_dialog);
        if (errorCode == 20003) {
            i3 = R.string.zrt;
        } else {
            i3 = R.string.zrv;
        }
        qQCustomDialog.setTitle(i3);
        if (errorCode == 70001) {
            i16 = R.string.f172572qt;
        } else {
            i16 = R.string.zru;
        }
        qQCustomDialog.setMessage(i16);
        qQCustomDialog.setPositiveButton(R.string.f1380608j, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wifiphoto.fragment.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i17) {
                RequestApplyFragment.showDisconnectDialog$lambda$15$lambda$14(RequestApplyFragment.this, dialogInterface, i17);
            }
        });
        qQCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDisconnectDialog$lambda$15$lambda$14(RequestApplyFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        return com.tencent.biz.richframework.compat.f.b(this, i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(Activity activity) {
        com.tencent.biz.richframework.compat.f.c(this, activity);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isSupportScreenShot() {
        return com.tencent.biz.richframework.compat.f.d(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isWrapContent() {
        return com.tencent.biz.richframework.compat.f.e(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needImmersive() {
        return com.tencent.biz.richframework.compat.f.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needStatusTrans() {
        return com.tencent.biz.richframework.compat.f.g(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            root = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            m53.h g16 = m53.h.g(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater)");
            this.binding = g16;
            Intent intent = requireActivity().getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "requireActivity().intent");
            dealIntent(intent);
            m53.h hVar = this.binding;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                hVar = null;
            }
            root = hVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onDestroy();
            reportViewDuration();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        super.onNewIntent(intent);
        if (intent != null) {
            dealIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onPause();
            com.tencent.mobileqq.wifiphoto.data.a.g(false, this, "pg_bas_mobile_album_licensing");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public /* bridge */ /* synthetic */ void onPostThemeChanged() {
        com.tencent.biz.richframework.compat.f.k(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onPreThemeChanged() {
        com.tencent.biz.richframework.compat.f.l(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onResume();
            com.tencent.mobileqq.wifiphoto.data.a.g(true, this, "pg_bas_mobile_album_licensing");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean overrideFinish() {
        return com.tencent.biz.richframework.compat.f.o(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wifiphoto/fragment/RequestApplyFragment$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RequestApplyFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                RequestApplyFragment.this.accessRequest();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@NotNull List<String> permissions, @NotNull List<Integer> results) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) permissions, (Object) results);
                return;
            }
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(results, "results");
            super.onDenied(permissions, results);
            com.tencent.mobileqq.wifiphoto.impl.global.f.f317624a.J(60001, new IOperateCallback() { // from class: com.tencent.mobileqq.wifiphoto.fragment.v
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RequestApplyFragment.b.b(i3, str);
                }
            });
            RequestApplyFragment.refreshDisconnectState$default(RequestApplyFragment.this, false, 0, 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(int i3, String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshConnectedState$lambda$12$lambda$10(DialogInterface dialogInterface, int i3) {
    }
}
