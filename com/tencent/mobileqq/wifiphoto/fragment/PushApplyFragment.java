package com.tencent.mobileqq.wifiphoto.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifiphoto.IWifiPhotoTempApi;
import com.tencent.mobileqq.wifiphoto.data.WifiPhotoInfo;
import com.tencent.mobileqq.wifiphoto.fragment.PushApplyFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernel.nativeinterface.AuthorizationStatus;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoPreCheckCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoPreCheckInfo;
import com.tencent.util.LoadingUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RoutePage(desc = "\u4e3b\u52a8\u5411PC\u7aef\u53d1\u8d77\u76f8\u518c\u6388\u6743\u8bf7\u6c42", path = "/wifi_photo/push_apply")
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0001$\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/wifiphoto/fragment/PushApplyFragment;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "Landroid/content/Intent;", "intent", "", "dealIntent", "", "isError", "", "tips", "tips2", "refreshPage", "checkPermission", "accessRequest", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "newIntent", "onNewIntent", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lm53/g;", "binding", "Lm53/g;", "", "source", "I", "Landroid/app/Dialog;", "dialog", "Landroid/app/Dialog;", "com/tencent/mobileqq/wifiphoto/fragment/PushApplyFragment$receiver$1", "receiver", "Lcom/tencent/mobileqq/wifiphoto/fragment/PushApplyFragment$receiver$1;", "<init>", "()V", "Companion", "a", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class PushApplyFragment extends QBaseFragment {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String ACCESS_RESULT_ACTION = "wifi.photo.access.result";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "PushApplyFragment";
    private m53.g binding;

    @Nullable
    private Dialog dialog;

    @NotNull
    private final PushApplyFragment$receiver$1 receiver;
    private int source;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wifiphoto/fragment/PushApplyFragment$a;", "", "", "ACCESS_RESULT_ACTION", "Ljava/lang/String;", "TAG", "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wifiphoto.fragment.PushApplyFragment$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25474);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.mobileqq.wifiphoto.fragment.PushApplyFragment$receiver$1] */
    public PushApplyFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.receiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.wifiphoto.fragment.PushApplyFragment$receiver$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PushApplyFragment.this);
                    }
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                    WifiPhotoInfo wifiPhotoInfo;
                    m53.g gVar;
                    m53.g gVar2;
                    m53.g gVar3;
                    m53.g gVar4;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                        return;
                    }
                    if (intent != null) {
                        Parcelable parcelableExtra = intent.getParcelableExtra(RequestApplyFragment.INFO_KEY);
                        m53.g gVar5 = null;
                        if (parcelableExtra instanceof WifiPhotoInfo) {
                            wifiPhotoInfo = (WifiPhotoInfo) parcelableExtra;
                        } else {
                            wifiPhotoInfo = null;
                        }
                        QLog.i(PushApplyFragment.TAG, 1, "receive request visit album. " + wifiPhotoInfo);
                        if (wifiPhotoInfo != null) {
                            gVar = PushApplyFragment.this.binding;
                            if (gVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                gVar = null;
                            }
                            gVar.f416243g.setText(wifiPhotoInfo.b());
                            gVar2 = PushApplyFragment.this.binding;
                            if (gVar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                gVar2 = null;
                            }
                            gVar2.f416243g.setContentDescription(wifiPhotoInfo.b());
                            gVar3 = PushApplyFragment.this.binding;
                            if (gVar3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                gVar3 = null;
                            }
                            gVar3.f416241e.setText(wifiPhotoInfo.a());
                            gVar4 = PushApplyFragment.this.binding;
                            if (gVar4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                            } else {
                                gVar5 = gVar4;
                            }
                            gVar5.f416241e.setContentDescription(wifiPhotoInfo.a());
                        }
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void accessRequest() {
        com.tencent.mobileqq.wifiphoto.impl.global.f.f317624a.d(AuthorizationStatus.KFULLACCESS, this.source, new IOperateCallback() { // from class: com.tencent.mobileqq.wifiphoto.fragment.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                PushApplyFragment.accessRequest$lambda$8(PushApplyFragment.this, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accessRequest$lambda$8(final PushApplyFragment this$0, final int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wifiphoto.fragment.h
            @Override // java.lang.Runnable
            public final void run() {
                PushApplyFragment.accessRequest$lambda$8$lambda$7(i3, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accessRequest$lambda$8$lambda$7(int i3, PushApplyFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            BannerManager.l().K(com.tencent.mobileqq.banner.d.f200256i, 2);
            QQToast.makeText(this$0.requireActivity(), "\u6388\u6743\u6210\u529f", 0).show();
            com.tencent.mobileqq.wifiphoto.impl.global.f fVar = com.tencent.mobileqq.wifiphoto.impl.global.f.f317624a;
            FragmentActivity requireActivity = this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            com.tencent.mobileqq.wifiphoto.impl.global.f.D(fVar, requireActivity, "/wifi_photo/request_apply", 0, 0, 12, null);
            return;
        }
        m53.g gVar = this$0.binding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            gVar = null;
        }
        gVar.f416238b.setEnabled(true);
        QQToast.makeText(this$0.requireActivity(), "\u6388\u6743\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", 0).show();
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
        this.source = intent.getIntExtra("SOURCE_KEY", 0);
        if (this.dialog == null) {
            this.dialog = LoadingUtil.createLoadingDialog(requireActivity(), "", true);
        }
        Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.show();
        }
        com.tencent.mobileqq.wifiphoto.impl.global.f.f317624a.I(new IKernelWiFiPhotoPreCheckCallback() { // from class: com.tencent.mobileqq.wifiphoto.fragment.g
            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoPreCheckCallback
            public final void onResult(WiFiPhotoPreCheckInfo wiFiPhotoPreCheckInfo) {
                PushApplyFragment.dealIntent$lambda$4(PushApplyFragment.this, wiFiPhotoPreCheckInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dealIntent$lambda$4(final PushApplyFragment this$0, final WiFiPhotoPreCheckInfo wiFiPhotoPreCheckInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(TAG, 1, "pre check result " + wiFiPhotoPreCheckInfo);
        Long l3 = wiFiPhotoPreCheckInfo.retCode;
        if (l3 == null || l3.longValue() != 0) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wifiphoto.fragment.b
                @Override // java.lang.Runnable
                public final void run() {
                    PushApplyFragment.dealIntent$lambda$4$lambda$1(PushApplyFragment.this, wiFiPhotoPreCheckInfo);
                }
            });
        } else {
            com.tencent.mobileqq.wifiphoto.impl.global.f.f317624a.L(new IOperateCallback() { // from class: com.tencent.mobileqq.wifiphoto.fragment.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    PushApplyFragment.dealIntent$lambda$4$lambda$3(PushApplyFragment.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dealIntent$lambda$4$lambda$1(PushApplyFragment this$0, WiFiPhotoPreCheckInfo wiFiPhotoPreCheckInfo) {
        Long l3;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.dialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        Long l16 = wiFiPhotoPreCheckInfo.retCode;
        if ((l16 == null || l16.longValue() != 100009) && ((l3 = wiFiPhotoPreCheckInfo.retCode) == null || l3.longValue() != 100014)) {
            str = wiFiPhotoPreCheckInfo.compatWording;
            Intrinsics.checkNotNullExpressionValue(str, "it.compatWording");
            str2 = null;
        } else {
            str = this$0.getString(R.string.zwd);
            Intrinsics.checkNotNullExpressionValue(str, "getString(R.string.expor\u2026ile_error_in_export_file)");
            str2 = this$0.getString(R.string.zwo);
        }
        this$0.refreshPage(true, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dealIntent$lambda$4$lambda$3(final PushApplyFragment this$0, final int i3, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(TAG, 1, "request visit local album result: " + i3 + " " + str);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wifiphoto.fragment.f
            @Override // java.lang.Runnable
            public final void run() {
                PushApplyFragment.dealIntent$lambda$4$lambda$3$lambda$2(PushApplyFragment.this, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dealIntent$lambda$4$lambda$3$lambda$2(PushApplyFragment this$0, int i3, String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.dialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        if (i3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        refreshPage$default(this$0, z16, str, null, 4, null);
    }

    private final void refreshPage(boolean isError, String tips, String tips2) {
        boolean z16;
        m53.g gVar = null;
        if (isError) {
            m53.g gVar2 = this.binding;
            if (gVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                gVar2 = null;
            }
            gVar2.f416250n.setVisibility(8);
            m53.g gVar3 = this.binding;
            if (gVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                gVar3 = null;
            }
            gVar3.f416244h.setVisibility(8);
            m53.g gVar4 = this.binding;
            if (gVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                gVar4 = null;
            }
            gVar4.f416247k.setVisibility(8);
            m53.g gVar5 = this.binding;
            if (gVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                gVar5 = null;
            }
            gVar5.f416240d.setVisibility(8);
            m53.g gVar6 = this.binding;
            if (gVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                gVar6 = null;
            }
            gVar6.f416241e.setVisibility(8);
            m53.g gVar7 = this.binding;
            if (gVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                gVar7 = null;
            }
            gVar7.f416248l.setVisibility(8);
            m53.g gVar8 = this.binding;
            if (gVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                gVar8 = null;
            }
            gVar8.f416246j.setVisibility(8);
            m53.g gVar9 = this.binding;
            if (gVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                gVar9 = null;
            }
            gVar9.f416238b.setVisibility(8);
            m53.g gVar10 = this.binding;
            if (gVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                gVar10 = null;
            }
            gVar10.f416249m.setVisibility(0);
            m53.g gVar11 = this.binding;
            if (gVar11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                gVar11 = null;
            }
            gVar11.f416245i.setVisibility(0);
            m53.g gVar12 = this.binding;
            if (gVar12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                gVar12 = null;
            }
            TextView textView = gVar12.f416245i;
            if (tips != null && tips.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                tips = "\u7533\u8bf7\u6388\u6743\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5";
            }
            textView.setText(tips);
            m53.g gVar13 = this.binding;
            if (gVar13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                gVar13 = null;
            }
            TextView textView2 = gVar13.f416245i;
            m53.g gVar14 = this.binding;
            if (gVar14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                gVar14 = null;
            }
            textView2.setContentDescription(gVar14.f416245i.getText());
            if (tips2 != null) {
                m53.g gVar15 = this.binding;
                if (gVar15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    gVar15 = null;
                }
                gVar15.f416239c.setVisibility(0);
                m53.g gVar16 = this.binding;
                if (gVar16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    gVar16 = null;
                }
                gVar16.f416239c.setText(tips2);
                m53.g gVar17 = this.binding;
                if (gVar17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    gVar = gVar17;
                }
                gVar.f416239c.setContentDescription(tips2);
                return;
            }
            return;
        }
        m53.g gVar18 = this.binding;
        if (gVar18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            gVar18 = null;
        }
        gVar18.f416249m.setVisibility(8);
        m53.g gVar19 = this.binding;
        if (gVar19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            gVar19 = null;
        }
        gVar19.f416245i.setVisibility(8);
        m53.g gVar20 = this.binding;
        if (gVar20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            gVar20 = null;
        }
        gVar20.f416250n.setBackgroundResource(R.drawable.qui_computer_to_phone);
        m53.g gVar21 = this.binding;
        if (gVar21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            gVar21 = null;
        }
        gVar21.f416244h.setText(R.string.f170905zw2);
        m53.g gVar22 = this.binding;
        if (gVar22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            gVar22 = null;
        }
        TextView textView3 = gVar22.f416244h;
        m53.g gVar23 = this.binding;
        if (gVar23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            gVar23 = null;
        }
        textView3.setContentDescription(gVar23.f416244h.getText());
        m53.g gVar24 = this.binding;
        if (gVar24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            gVar24 = null;
        }
        gVar24.f416239c.setVisibility(8);
        m53.g gVar25 = this.binding;
        if (gVar25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            gVar25 = null;
        }
        VideoReport.setPageId(gVar25.f416238b, "pg_bas_export_photo_authorization");
        m53.g gVar26 = this.binding;
        if (gVar26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            gVar26 = null;
        }
        VideoReport.setElementId(gVar26.f416238b, "em_bas_authorized_computer_access");
        m53.g gVar27 = this.binding;
        if (gVar27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            gVar = gVar27;
        }
        gVar.f416238b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wifiphoto.fragment.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushApplyFragment.refreshPage$lambda$6(PushApplyFragment.this, view);
            }
        });
    }

    static /* synthetic */ void refreshPage$default(PushApplyFragment pushApplyFragment, boolean z16, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        pushApplyFragment.refreshPage(z16, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshPage$lambda$6(PushApplyFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (((IWifiPhotoTempApi) QRoute.api(IWifiPhotoTempApi.class)).isPcLock()) {
            QQToast.makeText(this$0.requireContext(), "QQ\u5728\u7535\u8111\u4e0a\u5df2\u9501\u5b9a\uff0c\u8bf7\u89e3\u9501\u540e\u91cd\u8bd5", 0).show();
        } else if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(this$0.requireContext(), "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5", 0).show();
        } else {
            m53.g gVar = this$0.binding;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                gVar = null;
            }
            gVar.f416238b.setEnabled(false);
            this$0.checkPermission();
        }
        EventCollector.getInstance().onViewClicked(view);
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
            m53.g g16 = m53.g.g(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater)");
            this.binding = g16;
            Intent intent = requireActivity().getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "requireActivity().intent");
            dealIntent(intent);
            requireActivity().registerReceiver(this.receiver, new IntentFilter(ACCESS_RESULT_ACTION));
            m53.g gVar = this.binding;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                gVar = null;
            }
            root = gVar.getRoot();
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
            return;
        }
        super.onDestroy();
        requireActivity().unregisterReceiver(this.receiver);
        Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent newIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) newIntent);
            return;
        }
        super.onNewIntent(newIntent);
        if (newIntent != null) {
            dealIntent(newIntent);
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
            return;
        }
        super.onPause();
        m53.g gVar = this.binding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            gVar = null;
        }
        View view = gVar.f416250n;
        Intrinsics.checkNotNullExpressionValue(view, "binding.vIconApplyPermission");
        com.tencent.mobileqq.wifiphoto.data.a.g(false, view, "pg_bas_export_photo_authorization");
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
            return;
        }
        super.onResume();
        m53.g gVar = this.binding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            gVar = null;
        }
        View view = gVar.f416250n;
        Intrinsics.checkNotNullExpressionValue(view, "binding.vIconApplyPermission");
        com.tencent.mobileqq.wifiphoto.data.a.g(true, view, "pg_bas_export_photo_authorization");
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

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wifiphoto/fragment/PushApplyFragment$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PushApplyFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                PushApplyFragment.this.accessRequest();
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
            PushApplyFragment.this.requireActivity().finish();
            com.tencent.mobileqq.wifiphoto.impl.global.f.f317624a.J(60001, new IOperateCallback() { // from class: com.tencent.mobileqq.wifiphoto.fragment.i
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    PushApplyFragment.b.b(i3, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(int i3, String str) {
        }
    }
}
