package com.tencent.mobileqq.signature;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import b03.c;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.signature.SignTextEditFragment;
import com.tencent.mobileqq.signature.pay.SignPayEventReceiver;
import com.tencent.mobileqq.signature.topic.a;
import com.tencent.mobileqq.signature.view.AdComponent;
import com.tencent.mobileqq.signature.view.ShopHalfScreenFloatingView;
import com.tencent.mobileqq.signature.view.TopicEditTextView;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.base.VasQPublicBaseFragment;
import com.tencent.mobileqq.vas.inject.ISignatureStatusManager;
import com.tencent.mobileqq.vas.pendant.drawable.bean.AvatarPendantItem;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.SignJsPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.publish.api.IWinkDraft;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.util.WinkCommonUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.state.data.SquareJSConst;
import com.tencent.util.CommonMMKVUtils;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.Pair;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SignTextEditFragment extends VasQPublicBaseFragment implements Handler.Callback, View.OnClickListener, TextWatcher, a.b {
    static IPatchRedirector $redirector_;

    /* renamed from: u0, reason: collision with root package name */
    public static boolean f288334u0;
    private SignatureShopControl E;
    private SignPayEventReceiver F;
    private ShopHalfScreenFloatingView G;
    public RichStatus H;
    public RichStatus I;
    public TopicEditTextView J;
    public Button K;
    public ImageView L;
    public TextView M;
    TextView N;
    TextView P;
    View Q;
    TextView R;
    TextView S;
    CheckBox T;
    ViewGroup U;
    View V;
    TextView W;
    private Button X;
    private CheckBox Y;
    private URLDrawable Z;

    /* renamed from: a0, reason: collision with root package name */
    private URLDrawable f288335a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f288336b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f288337c0;

    /* renamed from: d0, reason: collision with root package name */
    int f288338d0;

    /* renamed from: e0, reason: collision with root package name */
    int f288339e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f288340f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f288341g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f288342h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f288343i0;

    /* renamed from: j0, reason: collision with root package name */
    private String f288344j0;

    /* renamed from: k0, reason: collision with root package name */
    private String f288345k0;

    /* renamed from: l0, reason: collision with root package name */
    Handler f288346l0;

    /* renamed from: m0, reason: collision with root package name */
    Handler f288347m0;

    /* renamed from: n0, reason: collision with root package name */
    boolean f288348n0;

    /* renamed from: o0, reason: collision with root package name */
    public ISignatureStatusManager f288349o0;

    /* renamed from: p0, reason: collision with root package name */
    private WinkPublishServiceProxy2 f288350p0;

    /* renamed from: q0, reason: collision with root package name */
    Observer f288351q0;

    /* renamed from: r0, reason: collision with root package name */
    private final ITaskListener.Stub f288352r0;

    /* renamed from: s0, reason: collision with root package name */
    CompoundButton.OnCheckedChangeListener f288353s0;

    /* renamed from: t0, reason: collision with root package name */
    Runnable f288354t0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            dialogInterface.dismiss();
            SignTextEditFragment.this.H.clear();
            SignTextEditFragment.this.Th(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b extends ITaskListener.Stub {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void v(TaskInfo taskInfo) {
            if (taskInfo.isSuccess()) {
                ((IWinkDraft) QRoute.api(IWinkDraft.class)).delete(WinkCommonUtil.getCurrentAccountLong(), taskInfo.getMissionId());
                QLog.d(QPublicBaseFragment.TAG, 1, "sign video publish success");
                QQToast.makeText(BaseApplication.getContext(), 2, com.dataline.util.j.d(BaseApplication.getContext().getString(R.string.f238917l2)), 1).show();
                HashMap hashMap = new HashMap();
                hashMap.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_AVATAR_VIDEO_SHARE_XSJ_FINISH_TOAST);
                hashMap.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_CAMERA_SIGN_VIDEO_PREVIEW_PAGE);
                VideoReport.reportEvent("ev_xsj_camera_action", null, hashMap);
                return;
            }
            QLog.d(QPublicBaseFragment.TAG, 1, "sign video publish fail");
            QQToast.makeText(BaseApplication.getContext(), 2, R.string.f240927qh, 1).show();
        }

        @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
        public void onTaskChange(final TaskInfo taskInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) taskInfo);
            } else {
                if (!taskInfo.isFinish()) {
                    return;
                }
                QLog.d(QPublicBaseFragment.TAG, 1, "isFinish true");
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.signature.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        SignTextEditFragment.b.v(TaskInfo.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b03.d f288364d;

        c(b03.d dVar) {
            this.f288364d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this, (Object) dVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
                com.tencent.mobileqq.signature.pay.b.a(this.f288364d.f27640e, SignTextEditFragment.this.getActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class e implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SignTextEditFragment.this.ii();
                SignTextEditFragment.this.ai(compoundButton, z16);
            } else {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class f extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onAllGranted();
            if (QLog.isColorLevel()) {
                QLog.d(QPublicBaseFragment.TAG, 2, "requestPermission user grant");
            }
            SignTextEditFragment.this.fi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class g implements ISignatureStatusManager.ISignatureStatusListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.vas.inject.ISignatureStatusManager.ISignatureStatusListener
        public void onChangeStatus(int i3, RichStatus richStatus, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), richStatus, obj);
            }
        }

        @Override // com.tencent.mobileqq.vas.inject.ISignatureStatusManager.ISignatureStatusListener
        public void onGetSyncShuoShuo(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            } else {
                SignTextEditFragment.this.T.setChecked(z16);
                SignTextEditFragment.this.ii();
            }
        }

        @Override // com.tencent.mobileqq.vas.inject.ISignatureStatusManager.ISignatureStatusListener
        public void onSetSyncShuoShuo(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            } else {
                if (SignTextEditFragment.this.getActivity() == null) {
                    return;
                }
                if (i3 == -1) {
                    QQToast.makeText(SignTextEditFragment.this.getActivity(), "\u8bbe\u7f6e\u4fee\u6539\u5931\u8d25", 1).show();
                }
                SignTextEditFragment.this.T.setChecked(z16);
                SignTextEditFragment.this.ii();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class h implements TextView.OnEditorActionListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this);
            }
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, this, textView, Integer.valueOf(i3), keyEvent)).booleanValue();
            } else if (keyEvent != null && keyEvent.getKeyCode() == 66) {
                InputMethodUtil.hide(textView);
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class i implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class j implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                CommonMMKVUtils.putBoolean("sp_key_sign_is_sync_qcircle", z16, true);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class k implements com.tencent.mobileqq.signature.pay.a {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.signature.pay.a
        public void onPaySuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                SignTextEditFragment.this.f288346l0.sendEmptyMessageDelayed(8, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class l implements c.g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AvatarPendantItem f288374a;

        l(AvatarPendantItem avatarPendantItem) {
            this.f288374a = avatarPendantItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this, (Object) avatarPendantItem);
            }
        }

        @Override // b03.c.g
        public void a(b03.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
            } else {
                if (SignTextEditFragment.this.E == null) {
                    return;
                }
                SignTextEditFragment.this.E.o(true, dVar, 0, this.f288374a);
            }
        }

        @Override // b03.c.g
        public void onError(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class m implements Observer {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this);
            }
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            String str;
            Bundle bundle;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) observable, obj);
                return;
            }
            if (obj instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) obj;
                if (arrayList.size() > 2 && ((Integer) arrayList.get(0)).intValue() == 6) {
                    int intValue = ((Integer) arrayList.get(1)).intValue();
                    if (arrayList.size() >= 3 && (arrayList.get(2) instanceof HashMap) && (bundle = (Bundle) ((HashMap) arrayList.get(2)).get(SignJsPlugin.CHANGE_STATUS_CALLBACK_DATA)) != null) {
                        str = bundle.getString("errorDesc");
                    } else {
                        str = "";
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(QPublicBaseFragment.TAG, 2, "publishToast : ret = " + intValue + " serverWording " + str);
                    }
                    SignTextEditFragment.this.Vh(intValue, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class n implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            dialogInterface.dismiss();
            RichStatus richStatus = new RichStatus(null);
            richStatus.copyFrom(SignTextEditFragment.this.H);
            SignTextEditFragment.this.f288347m0.obtainMessage(6, richStatus).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class o implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SignTextEditFragment.this.f288344j0 = "";
                dialogInterface.dismiss();
                SignTextEditFragment.this.f288347m0.obtainMessage(6, null).sendToTarget();
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class p implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50371);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            f288334u0 = false;
        }
    }

    public SignTextEditFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f288340f0 = false;
        this.f288341g0 = -1;
        this.f288342h0 = 0;
        this.f288343i0 = false;
        this.f288346l0 = new Handler(Looper.getMainLooper(), this);
        this.f288347m0 = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        this.f288349o0 = new com.tencent.mobileqq.signature.c().f288430a;
        this.f288350p0 = null;
        this.f288351q0 = new m();
        this.f288352r0 = new b();
        this.f288353s0 = new e();
        this.f288354t0 = new Runnable() { // from class: com.tencent.mobileqq.signature.SignTextEditFragment.16
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                SignTextEditFragment signTextEditFragment = SignTextEditFragment.this;
                ISignatureStatusManager iSignatureStatusManager = signTextEditFragment.f288349o0;
                if (iSignatureStatusManager != null) {
                    iSignatureStatusManager.setSyncShuoShuo(signTextEditFragment.T.isChecked());
                }
            }
        };
    }

    private void Dh() {
        Intent intent = new Intent();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        intent.putExtra("key_uin", peekAppRuntime.getCurrentAccountUin());
        intent.putExtra("key_uin_name", ((AppInterface) peekAppRuntime).getCurrentNickname());
        intent.putExtra("key_open_via", "history-geqian");
        try {
            int i3 = PublicFragmentActivity.f176716c0;
            intent.setClass(getActivity(), PublicFragmentActivity.class);
            intent.putExtra("public_fragment_class", SignatureHistoryFragment.class.getName());
            getActivity().startActivity(intent);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    private boolean Eh() {
        ISignatureStatusManager iSignatureStatusManager = this.f288349o0;
        if (iSignatureStatusManager == null) {
            return false;
        }
        return iSignatureStatusManager.getSyncShuoShuo();
    }

    private boolean Gh() {
        String plainText;
        Bundle arguments = getArguments();
        try {
            this.H = (RichStatus) arguments.getSerializable(SquareJSConst.Params.PARAMS_RICH_STATUS);
            RichStatus richStatus = new RichStatus(null);
            this.I = richStatus;
            richStatus.copyFrom(this.H);
            this.I.tplId = 1;
            RichStatus richStatus2 = this.H;
            if (richStatus2 != null) {
                richStatus2.actionText = null;
                richStatus2.actionId = 0;
            }
            this.f288345k0 = arguments.getString("template_info_text");
            int i3 = arguments.getInt("from_type");
            com.tencent.mobileqq.signature.report.a.c().f288443k = "" + i3;
            SignatureManagerForTool.j().addObserver(this.f288351q0);
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(arguments.getInt("from_type"));
                RichStatus richStatus3 = this.H;
                if (richStatus3 == null) {
                    plainText = "null";
                } else {
                    plainText = richStatus3.getPlainText();
                }
                objArr[1] = plainText;
                QLog.i(QPublicBaseFragment.TAG, 2, String.format("initData from=%d status=%s", objArr));
            }
            if (this.H == null) {
                this.H = new RichStatus(null);
            }
            RichStatus richStatus4 = this.H;
            if (richStatus4.tplId < 1) {
                richStatus4.tplId = 1;
            }
            this.I.tplId = richStatus4.tplId;
            SignatureManagerForTool.j().l(this.H.tplId);
            Hh();
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(QPublicBaseFragment.TAG, 2, e16.getMessage(), e16);
            }
            return false;
        }
    }

    private void Hh() {
        g gVar = new g();
        ISignatureStatusManager iSignatureStatusManager = this.f288349o0;
        if (iSignatureStatusManager == null) {
            return;
        }
        iSignatureStatusManager.addSyncShuoShuoListener(gVar);
    }

    private void Ih(View view, boolean z16) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        if (!sa0.b.e()) {
            return;
        }
        TextView textView = this.N;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.P;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        View view2 = this.Q;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        Button button = (Button) view.findViewById(R.id.f100195ru);
        this.X = (Button) view.findViewById(R.id.ytg);
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f67163cl);
        if (viewStub == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.T = (CheckBox) inflate.findViewById(R.id.f85414ow);
        this.Y = (CheckBox) inflate.findViewById(R.id.f85384ot);
        View findViewById = inflate.findViewById(R.id.f85434oy);
        TextView textView3 = (TextView) inflate.findViewById(R.id.f85374os);
        TextView textView4 = (TextView) inflate.findViewById(R.id.f85424ox);
        TextView textView5 = (TextView) inflate.findViewById(R.id.f85394ou);
        TextView textView6 = (TextView) inflate.findViewById(R.id.f85404ov);
        button.setVisibility(0);
        this.X.setVisibility(0);
        findViewById.setVisibility(0);
        this.Y.setOnClickListener(this);
        button.setOnClickListener(this);
        this.X.setOnClickListener(this);
        textView4.setOnClickListener(this);
        textView5.setOnClickListener(this);
        textView6.setOnClickListener(this);
        boolean z17 = CommonMMKVUtils.getBoolean("sp_key_sign_is_sync_qcircle", false, true);
        this.T.setChecked(Eh());
        this.T.setOnCheckedChangeListener(this.f288353s0);
        this.Y.setChecked(z17);
        this.Y.setOnCheckedChangeListener(new j());
        button.setCompoundDrawables(this.Z, null, null, null);
        int i27 = R.drawable.kxj;
        if (z16) {
            i3 = R.drawable.kxj;
        } else {
            i3 = R.drawable.kxr;
        }
        button.setBackgroundResource(i3);
        int i28 = -1;
        if (z16) {
            i16 = -1;
        } else {
            i16 = -16777216;
        }
        button.setTextColor(i16);
        this.X.setCompoundDrawables(this.f288335a0, null, null, null);
        Button button2 = this.X;
        if (z16) {
            i17 = R.drawable.kxj;
        } else {
            i17 = R.drawable.kxr;
        }
        button2.setBackgroundResource(i17);
        Button button3 = this.X;
        if (z16) {
            i18 = -1;
        } else {
            i18 = -16777216;
        }
        button3.setTextColor(i18);
        if (!z16) {
            i27 = R.drawable.kxr;
        }
        findViewById.setBackgroundResource(i27);
        if (z16) {
            i19 = -1;
        } else {
            i19 = -16777216;
        }
        textView3.setTextColor(i19);
        if (z16) {
            i26 = -1;
        } else {
            i26 = -16777216;
        }
        textView4.setTextColor(i26);
        if (!z16) {
            i28 = -16777216;
        }
        textView5.setTextColor(i28);
        textView5.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f181523e0));
        VideoReport.setElementId(textView6, WinkDaTongReportConstant.ElementId.EM_BAS_PREVIEW);
        VideoReport.setElementClickPolicy(textView6, ClickPolicy.REPORT_ALL);
    }

    private boolean Jh(int i3) {
        Editable editableText = this.J.getEditableText();
        if (i3 >= 0 && editableText.length() > i3 && editableText.charAt(i3) == '#' && com.tencent.mobileqq.signature.topic.c.g(editableText, i3) == null) {
            return true;
        }
        return false;
    }

    private void Kh(String str) {
        if (sa0.b.f()) {
            Bundle bundle = new Bundle();
            bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
            bundle.putString("app_key", "00000QG6YX3X0LZH");
            bundle.putString(QQWinkConstants.WinkLowLevelTemplateShareConstant.TEMPLATE_SIGN_TEXT, str);
            bundle.putString(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_FROM_TYPE, QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_SIGN);
            bundle.putString(QQWinkConstants.WINK_PUBLISH_TASK_ID, "gexingqianming");
            ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToSignShareWindow(getActivity(), bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lh(WinkPublishServiceProxy2 winkPublishServiceProxy2) {
        QLog.d(QPublicBaseFragment.TAG, 1, "bind success :$service");
        winkPublishServiceProxy2.addTaskListener(this.f288352r0);
        this.f288350p0 = winkPublishServiceProxy2;
    }

    private void Mh(RichStatus richStatus) {
        if (richStatus != null && !richStatus.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.i(QPublicBaseFragment.TAG, 2, String.format("mergeByDraft draft=%s", richStatus));
            }
            RichStatus richStatus2 = this.H;
            if (richStatus2 != null) {
                richStatus2.ensureContent();
                if (richStatus.plainText != null) {
                    this.H.plainText.clear();
                    this.H.plainText.addAll(richStatus.plainText);
                }
                List<Pair<Integer, String>> list = this.H.topics;
                if (list != null && richStatus.topics != null) {
                    list.clear();
                    this.H.topics.addAll(richStatus.topics);
                }
                List<Pair<Integer, Integer>> list2 = this.H.topicsPos;
                if (list2 != null && richStatus.topicsPos != null) {
                    list2.clear();
                    this.H.topicsPos.addAll(richStatus.topicsPos);
                }
                RichStatus richStatus3 = this.H;
                richStatus3.locationText = richStatus.locationText;
                richStatus3.tplId = richStatus.tplId;
                this.f288343i0 = true;
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(QPublicBaseFragment.TAG, 2, String.format("mergeByDraft empty", new Object[0]));
        }
    }

    private void Nh(ISignatureStatusManager.TopicInfo topicInfo) {
        if (topicInfo == null) {
            return;
        }
        if (Jh(this.f288341g0)) {
            Rh(topicInfo.topicId, topicInfo.topicStr, this.f288341g0, 0);
        } else {
            Qh(topicInfo.topicId, topicInfo.topicStr, this.f288341g0);
        }
        this.f288337c0 = topicInfo.topicId;
        Oh(-1, 0, "");
    }

    private void Oh(int i3, int i16, String str) {
        if (i3 == this.f288341g0 && i16 == this.f288342h0) {
            if (QLog.isColorLevel()) {
                QLog.i(QPublicBaseFragment.TAG, 2, "onAtKeyChanged return");
            }
        } else {
            if (QLog.isDevelopLevel()) {
                QLog.i(QPublicBaseFragment.TAG, 2, String.format("onAtKeyChanged [%d, %d, [%s] ]", Integer.valueOf(i3), Integer.valueOf(i16), str));
            }
            this.f288341g0 = i3;
            this.f288342h0 = i16;
        }
    }

    private void Ph() {
        SignatureShopControl signatureShopControl = this.E;
        if (signatureShopControl == null) {
            return;
        }
        AvatarPendantItem j3 = signatureShopControl.j();
        if (f288334u0) {
            b03.c.d(9, j3.itemId, new l(j3));
            return;
        }
        com.tencent.mobileqq.signature.report.a.c().f(145, 0, j3, "3001007");
        Th(true);
        SignatureShopControl signatureShopControl2 = this.E;
        if (signatureShopControl2 == null) {
            return;
        }
        signatureShopControl2.o(false, null, 0, null);
        this.E.l(null);
    }

    private void Sh() {
        int i3;
        if (this.K == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        CheckBox checkBox = this.T;
        int i16 = 0;
        if (checkBox != null && checkBox.isChecked()) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        CheckBox checkBox2 = this.Y;
        if (checkBox2 != null && checkBox2.isChecked()) {
            i16 = 1;
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.IS_SYNC_QZONE, Integer.valueOf(i3));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.IS_SYNC_XSJ, Integer.valueOf(i16));
        hashMap.put("topic_id", String.valueOf(this.f288337c0));
        hashMap.put("is_location", Integer.valueOf(!TextUtils.isEmpty(this.f288344j0) ? 1 : 0));
        VideoReport.reportEvent("ev_sign_release", this.K, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Th(boolean z16) {
        int i3;
        AvatarPendantItem j3 = this.E.j();
        if (j3.itemId == 0) {
            j3.itemId = this.H.tplId;
            j3.name = SignatureManagerForTool.j().l(j3.itemId).name;
        }
        if (this.J.getText().length() == 0) {
            i3 = 0;
        } else {
            i3 = j3.itemId;
        }
        b03.c.d(9, i3, new c.g(j3, z16) { // from class: com.tencent.mobileqq.signature.SignTextEditFragment.14
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AvatarPendantItem f288355a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f288356b;

            {
                this.f288355a = j3;
                this.f288356b = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SignTextEditFragment.this, j3, Boolean.valueOf(z16));
                }
            }

            @Override // b03.c.g
            public void a(b03.d dVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
                    return;
                }
                if (dVar.f27638c == 0) {
                    com.tencent.mobileqq.signature.report.a.c().f(113, 0, this.f288355a, "3001007");
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("my_signature", SignTextEditFragment.this.H);
                    QIPCClientHelper.getInstance().callServer("VasFontIPCModule", "action_change_status", bundle, SignatureManagerForTool.j().f288384d);
                    return;
                }
                if (!this.f288356b) {
                    com.tencent.mobileqq.signature.report.a.c().f(109, 0, SignTextEditFragment.this.E.j(), "3001007");
                    SignTextEditFragment.this.f288346l0.post(new Runnable(dVar) { // from class: com.tencent.mobileqq.signature.SignTextEditFragment.14.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ b03.d f288358d;

                        {
                            this.f288358d = dVar;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass14.this, (Object) dVar);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                SignTextEditFragment.this.ci(this.f288358d);
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }

            @Override // b03.c.g
            public void onError(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                }
            }
        });
    }

    private RichStatus Wh() {
        RichStatus richStatus;
        try {
            richStatus = (RichStatus) FileUtils.readObject("file_richstatus_draft_" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin());
        } catch (Exception e16) {
            e16.printStackTrace();
            richStatus = null;
        }
        if (QLog.isColorLevel()) {
            QLog.i(QPublicBaseFragment.TAG, 2, String.format("readDraft %s", richStatus));
        }
        return richStatus;
    }

    private void Xh() {
        WinkPublishHelper2.INSTANCE.bindService(1, new WinkPublishHelper2.Callback() { // from class: com.tencent.mobileqq.signature.a
            @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
            public final void onServiceConnected(WinkPublishServiceProxy2 winkPublishServiceProxy2) {
                SignTextEditFragment.this.Lh(winkPublishServiceProxy2);
            }
        });
    }

    private boolean Yh(RichStatus richStatus) {
        String str = this.f288344j0;
        if (richStatus == null) {
            richStatus = new RichStatus(null);
            richStatus.setEmptyStatus(true);
            str = "";
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        FileUtils.writeObject("file_richstatus_draft_" + peekAppRuntime.getCurrentAccountUin(), richStatus);
        String account = peekAppRuntime.getAccount();
        if (account == null) {
            account = "noLogin";
        }
        peekAppRuntime.getApp().getSharedPreferences(account, 4).edit().putString("sign_location_id_draft_" + peekAppRuntime.getCurrentAccountUin(), str).commit();
        if (QLog.isColorLevel()) {
            QLog.i(QPublicBaseFragment.TAG, 2, String.format("saveDraft %s", richStatus.getPlainText()));
        }
        return true;
    }

    @SuppressLint({"WrongConstant"})
    private void Zh() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            qBaseActivity.setRequestedOrientation(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(CompoundButton compoundButton, boolean z16) {
        if (getQBaseActivity() == null) {
            return;
        }
        if (NetworkUtil.isNetSupport(compoundButton.getContext())) {
            if (AppSetting.f99565y) {
                this.T.setContentDescription("\u4e2a\u6027\u7b7e\u540d\u540c\u6b65\u5230\u8bf4\u8bf4");
            }
            if (this.f288349o0 != null) {
                this.f288346l0.removeCallbacks(this.f288354t0);
                this.f288346l0.postDelayed(this.f288354t0, 500L);
                return;
            }
            return;
        }
        QQToast.makeText(compoundButton.getContext(), R.string.cjl, 1).show();
        this.T.setChecked(!z16);
        ii();
    }

    private void bi(RichStatus richStatus) {
        int totalLenForShow;
        if (richStatus == null) {
            totalLenForShow = 0;
        } else {
            totalLenForShow = richStatus.getTotalLenForShow();
        }
        this.R.setText(totalLenForShow + "/80");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(b03.d dVar) {
        AvatarPendantItem j3 = this.E.j();
        if (j3 == null) {
            return;
        }
        int i3 = dVar.f27638c;
        String str = "";
        if (i3 == 2002) {
            str = "" + (j3.price / 100) + "\u5143\u8d2d\u4e70";
        } else if (i3 == 4002) {
            str = "\u5f00\u901a\u4f1a\u5458";
        } else if (i3 == 5002) {
            str = "\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458";
        } else if (i3 == 14002) {
            str = "\u7eed\u8d39\u8d85\u7ea7\u4f1a\u5458";
        } else if (i3 == 15002) {
            str = "\u7eed\u8d39\u4f1a\u5458";
        }
        String str2 = str;
        DialogUtil.createCustomDialog(getActivity(), 230, (String) null, "\u4f60\u5f53\u524d\u53d1\u5e03\u5185\u5bb9\u5305\u542b\u672a\u8d2d\u4e70\u88c5\u626e\u300a" + j3.name + "\u300b, \u8bf7\u5148\u8d2d\u4e70", "\u6682\u4e0d\u8d2d\u4e70", str2, new c(dVar), new d()).show();
    }

    private void di(View view) {
        DialogUtil.createCenterTextDialog(view.getContext(), 230, "\u6e29\u99a8\u63d0\u793a", "\u5f53\u524d\u5904\u4e8e\"\u4f53\u9a8c\u6a21\u5f0f\"\uff0c\u4e0d\u5c55\u793a\u88c5\u626e\u3002\u70b9\u51fb\"\u7acb\u5373\u5207\u6362\"\uff0c\u53ef\u5207\u6362\u4e3a\"\u666e\u901a\u6a21\u5f0f\"\n", "\u6211\u77e5\u9053\u4e86", "\u7acb\u5373\u5207\u6362", new DialogInterface.OnClickListener(view) { // from class: com.tencent.mobileqq.signature.SignTextEditFragment.19
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f288360d;

            {
                this.f288360d = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this, (Object) view);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    ThemeSwitcher.startSwitch(ThemeUtil.getThemeId(), ThemeReporter.FROM_SIMPLE, new ThemeSwitchCallback() { // from class: com.tencent.mobileqq.signature.SignTextEditFragment.19.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass19.this);
                            }
                        }

                        @Override // com.tencent.mobileqq.vas.theme.ThemeSwitchCallback, com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
                        public boolean postSwitch(int i16) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, i16)).booleanValue();
                            }
                            if (i16 == 0) {
                                QQToast.makeText(AnonymousClass19.this.f288360d.getContext(), "\u5df2\u5f00\u542f\u666e\u901a\u6a21\u5f0f", 0).show();
                            }
                            return false;
                        }
                    });
                    dialogInterface.dismiss();
                }
            }
        }, new i()).show();
    }

    private String getMissionId() {
        if (TextUtils.isEmpty(this.f288336b0)) {
            this.f288336b0 = "QCIRCLE_" + UUID.randomUUID();
        }
        return this.f288336b0;
    }

    private void gi(boolean z16) {
        CheckBox checkBox;
        if (FastClickUtils.isFastDoubleClick("QPublicBaseFragment syncQCircle", 500L)) {
            return;
        }
        if (getContext() != null && this.J != null && (checkBox = this.Y) != null) {
            if (!checkBox.isChecked() && z16) {
                QLog.d(QPublicBaseFragment.TAG, 1, "[syncQCircle] sync qcircle btn is not checked.");
                return;
            }
            ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToWinkEditorAfterProcessContentForQQSign(getContext(), "QCIRCLE", getMissionId(), this.J.getText().toString(), null, "gexingqianming", z16);
            QLog.d(QPublicBaseFragment.TAG, 1, "[syncQCircle] jumpToWinkEditor, isPublish: " + z16);
            return;
        }
        QLog.e(QPublicBaseFragment.TAG, 1, "[syncQCircle] view is null.");
    }

    private void hi() {
        WinkPublishServiceProxy2 winkPublishServiceProxy2 = this.f288350p0;
        if (winkPublishServiceProxy2 != null) {
            winkPublishServiceProxy2.removeTaskListener(this.f288352r0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ii() {
        CheckBox checkBox = this.T;
        if (checkBox == null) {
            return;
        }
        Drawable drawable = checkBox.getResources().getDrawable(R.drawable.list_checkbox_multi);
        Drawable drawable2 = this.T.getResources().getDrawable(R.drawable.list_checkbox_selected);
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null);
        if (this.T.isChecked()) {
            this.T.setButtonDrawable(drawable2);
            return;
        }
        if (!isNowThemeIsNight) {
            drawable.setColorFilter(-16777216, PorterDuff.Mode.MULTIPLY);
        }
        this.T.setButtonDrawable(drawable);
    }

    private void init(View view) {
        if (!Gh()) {
            getActivity().finish();
            return;
        }
        initView(view);
        boolean simpleUISwitch = SimpleUIUtil.getSimpleUISwitch();
        boolean isNowElderMode = SimpleUIUtil.isNowElderMode();
        if (simpleUISwitch && !isNowElderMode) {
            di(view);
            return;
        }
        com.tencent.mobileqq.signature.report.a.c().l();
        com.tencent.mobileqq.signature.report.a.c().m(101);
        com.tencent.mobileqq.signature.report.a.c().k(101);
        com.tencent.mobileqq.signature.report.a.c().e(101);
        com.tencent.mobileqq.signature.report.a.c().p(101);
        com.tencent.mobileqq.signature.report.a.c().g(101);
        com.tencent.mobileqq.signature.report.a.c().j(101);
        com.tencent.mobileqq.signature.report.a.c().i(101);
    }

    private void initView(View view) {
        String str;
        Zh();
        setStatusBarImmersive();
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(view.getContext());
        View findViewById = view.findViewById(R.id.kgv);
        this.V = findViewById;
        findViewById.setPadding(0, statusBarHeight, 0, 0);
        this.V.getLayoutParams().height = ViewUtils.dpToPx(326.0f) + statusBarHeight;
        new AdComponent().d((ViewGroup) view);
        this.U = (ViewGroup) view.findViewById(R.id.f85354oq);
        SignatureShopControl signatureShopControl = new SignatureShopControl(view.getContext());
        this.E = signatureShopControl;
        signatureShopControl.f288392b = 9;
        signatureShopControl.k(this);
        this.U.addView(this.E.i());
        this.E.p();
        this.G = (ShopHalfScreenFloatingView) view.findViewById(R.id.f66733bf);
        this.N = (TextView) view.findViewById(R.id.l8d);
        this.P = (TextView) view.findViewById(R.id.l8c);
        this.Q = view.findViewById(R.id.f166115bl4);
        this.S = (TextView) view.findViewById(R.id.e_5);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.f164754zz);
        this.T = checkBox;
        checkBox.setChecked(Eh());
        this.T.setOnCheckedChangeListener(this.f288353s0);
        ii();
        this.Q.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.P.setOnClickListener(this);
        ImageView imageView = (ImageView) view.findViewById(R.id.f85344op);
        this.L = imageView;
        imageView.setOnClickListener(this);
        Button button = (Button) view.findViewById(R.id.tie);
        this.K = button;
        button.setOnClickListener(this);
        VideoReport.setElementId(this.K, "em_sign_release");
        VideoReport.setPageId(this.K, "pg_user_sign");
        TextView textView = (TextView) view.findViewById(R.id.f165694xa0);
        this.W = textView;
        textView.setOnClickListener(this);
        TopicEditTextView topicEditTextView = (TopicEditTextView) view.findViewById(R.id.btq);
        this.J = topicEditTextView;
        topicEditTextView.setMovementMethod(com.tencent.mobileqq.signature.view.b.getInstance());
        this.J.addTextChangedListener(this);
        this.J.setOnEditorActionListener(new h());
        this.J.setOnClickListener(this);
        TextView textView2 = (TextView) view.findViewById(R.id.ufj);
        this.M = textView2;
        textView2.setClickable(false);
        this.R = (TextView) view.findViewById(R.id.lpq);
        this.f288347m0.sendEmptyMessage(0);
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null);
        URLDrawable drawable = URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/350e32e1-45e4-4bb3-97ca-a534d0754d64.png", (URLDrawable.URLDrawableOptions) null);
        this.Z = URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/arno/qq_sign_topic.png", (URLDrawable.URLDrawableOptions) null);
        this.f288335a0 = URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/arno/qzone_location_normal.png", (URLDrawable.URLDrawableOptions) null);
        URLDrawable drawable2 = URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/arno/guild_right_arrow.png", (URLDrawable.URLDrawableOptions) null);
        drawable2.setBounds(new Rect(0, 0, ViewUtils.dip2px(16.0f), ViewUtils.dip2px(16.0f)));
        this.W.setCompoundDrawables(null, null, drawable2, null);
        if (isNowThemeIsNight) {
            this.Z.setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
            this.f288335a0.setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
            drawable.setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
            this.N.setBackgroundResource(R.drawable.kxl);
            this.N.setTextColor(-1);
            this.P.setBackgroundResource(R.drawable.kxn);
            this.P.setTextColor(-1);
            this.Q.setBackgroundResource(R.drawable.kxp);
            this.S.setTextColor(-1);
            view.setBackgroundColor(-16777216);
            this.R.setTextColor(Color.parseColor("#7cffffff"));
            this.W.setTextColor(Color.parseColor("#7cffffff"));
            str = "https://tianquan.gtimg.cn/uncategorized/arno/avatarstore_header_night_bg.png";
        } else {
            view.setBackgroundColor(-1);
            this.Z.setColorFilter(-16777216, PorterDuff.Mode.MULTIPLY);
            this.f288335a0.setColorFilter(-16777216, PorterDuff.Mode.MULTIPLY);
            drawable.setColorFilter(-16777216, PorterDuff.Mode.MULTIPLY);
            this.N.setBackgroundResource(R.drawable.kxk);
            this.N.setTextColor(-16777216);
            this.P.setBackgroundResource(R.drawable.kxm);
            this.P.setTextColor(-16777216);
            this.Q.setBackgroundResource(R.drawable.kxo);
            this.S.setTextColor(-16777216);
            this.R.setTextColor(Color.parseColor("#7c121212"));
            this.W.setTextColor(Color.parseColor("#7c121212"));
            str = "https://tianquan.gtimg.cn/uncategorized/arno/avatarstore_header_bg.png";
        }
        this.Z.setBounds(new Rect(0, 0, ViewUtils.dip2px(16.0f), ViewUtils.dip2px(16.0f)));
        this.N.setCompoundDrawables(this.Z, null, null, null);
        this.f288335a0.setBounds(new Rect(0, 0, ViewUtils.dip2px(16.0f), ViewUtils.dip2px(16.0f)));
        this.P.setCompoundDrawables(this.f288335a0, null, null, null);
        this.L.setImageDrawable(drawable);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable3 = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable3;
        obtain.mFailedDrawable = drawable3;
        this.V.setBackground(URLDrawable.getDrawable(str, obtain));
        li();
        registerReceiver();
        Ih(view, isNowThemeIsNight);
    }

    private void ji(String str) {
        Button button = this.X;
        if (button == null) {
            return;
        }
        button.setText(str);
    }

    private void ki() {
        if (!isAdded()) {
            return;
        }
        if (TextUtils.isEmpty(this.H.locationText)) {
            this.P.setText("\u6dfb\u52a0\u5730\u70b9");
            ji(com.tencent.biz.qqcircle.utils.h.a(R.string.f227786rz));
        } else {
            this.P.setText(this.H.locationText);
            ji(this.H.locationText);
        }
    }

    private void mi(boolean z16) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.i(QPublicBaseFragment.TAG, 2, "updateSignViewShow");
        }
        RichStatus richStatus = this.H;
        if (richStatus == null) {
            return;
        }
        CharSequence spannableStringWithoutAction = richStatus.toSpannableStringWithoutAction(null);
        bi(this.H);
        if (TextUtils.isEmpty(spannableStringWithoutAction)) {
            if (!TextUtils.isEmpty(this.f288345k0)) {
                spannableStringWithoutAction = this.f288345k0;
                if (z16) {
                    this.f288345k0 = null;
                }
            }
            this.H.ensureContent();
            RichStatus richStatus2 = this.H;
            if (richStatus2.tplId != 0) {
                richStatus2.plainText.set(0, spannableStringWithoutAction.toString());
            }
        }
        int i3 = 1;
        if (QLog.isColorLevel()) {
            QLog.i(QPublicBaseFragment.TAG, 2, String.format("updateSignViewShow content=%s", spannableStringWithoutAction));
        }
        this.J.setText(new QQText(spannableStringWithoutAction, 1, 20));
        TopicEditTextView topicEditTextView = this.J;
        topicEditTextView.setSelection(topicEditTextView.getEditableText().length());
        InputMethodUtil.show(this.J);
        int i16 = this.H.tplId;
        if (i16 > 0) {
            i3 = i16;
        }
        SignatureTemplateInfo l3 = SignatureManagerForTool.j().l(i3);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        if (!"1".equals(l3.f307842id)) {
            VasResDrawable Fh = Fh(i3);
            if (Fh != null) {
                this.J.setBackground(Fh);
            }
        } else if (!TextUtils.isEmpty(l3.dot9png)) {
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            this.J.setBackground(URLDrawable.getDrawable(SignatureManagerForTool.k(0, l3.dot9png), obtain));
        }
        if (!TextUtils.isEmpty(l3.fontColor)) {
            this.J.setTextColor(Color.parseColor(l3.fontColor));
            this.M.setTextColor(Color.parseColor(l3.fontColor));
        } else {
            this.M.setTextColor(R.color.al6);
        }
        if (TextUtils.isEmpty(l3.defText)) {
            str = "\u7f16\u8f91\u4e2a\u7b7e\uff0c\u5c55\u793a\u6211\u7684\u72ec\u7279\u6001\u5ea6";
        } else {
            str = l3.defText;
        }
        this.M.setText(str);
        if (TextUtils.isEmpty(this.J.getText())) {
            this.M.setVisibility(0);
        } else {
            this.M.setVisibility(8);
        }
        ki();
    }

    private void registerReceiver() {
        SignPayEventReceiver signPayEventReceiver = new SignPayEventReceiver();
        this.F = signPayEventReceiver;
        signPayEventReceiver.b();
        this.F.a(new k());
    }

    private void setStatusBarImmersive() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && ImmersiveUtils.isSupporImmersive() == 1) {
            if (SystemBarActivityModule.getSystemBarComp(qBaseActivity) == null) {
                SystemBarActivityModule.setImmersiveStatus(qBaseActivity, 0);
                return;
            }
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusColor(0);
        }
    }

    private void unRegisterReceiver() {
        SignPayEventReceiver signPayEventReceiver = this.F;
        if (signPayEventReceiver != null) {
            signPayEventReceiver.c();
        }
    }

    public boolean Ch(RichStatus richStatus, RichStatus richStatus2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) richStatus, (Object) richStatus2)).booleanValue();
        }
        if (richStatus == null || richStatus2 == null) {
            return false;
        }
        if ((TextUtils.isEmpty(richStatus.toSpannableStringWithoutAction().toString()) && TextUtils.isEmpty(richStatus2.toSpannableStringWithoutAction().toString())) || richStatus.tplId != richStatus2.tplId || richStatus.actionId != richStatus2.actionId || richStatus.actionText != richStatus2.actionText || richStatus.dataText != richStatus2.dataText || !richStatus.toSpannableStringWithoutAction().toString().equals(richStatus2.toSpannableStringWithoutAction().toString()) || richStatus.locationText != richStatus2.locationText) {
            return false;
        }
        return true;
    }

    public VasResDrawable Fh(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (VasResDrawable) iPatchRedirector.redirect((short) 23, (Object) this, i3);
        }
        ISignatureStatusManager iSignatureStatusManager = this.f288349o0;
        if (iSignatureStatusManager == null) {
            return null;
        }
        return iSignatureStatusManager.getVasResDrawable(i3);
    }

    public void Qh(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(QPublicBaseFragment.TAG, 2, String.format("onTagSelectedInsert(%d,%s) index=%d selStart=%d", Integer.valueOf(i3), str, Integer.valueOf(this.f288341g0), Integer.valueOf(i16)));
        }
        if (com.tencent.mobileqq.signature.topic.c.a(str) && i3 >= 0) {
            int length = this.J.getText().length();
            if (i16 < 0) {
                if (this.J.getSelectionStart() >= 0) {
                    i16 = this.J.getSelectionStart();
                } else {
                    i16 = 0;
                }
            } else if (i16 > length) {
                i16 = length;
            }
            Editable text = this.J.getText();
            if (text.length() + str.length() > 80) {
                Message message = new Message();
                message.what = 3;
                this.f288346l0.sendMessage(message);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            com.tencent.mobileqq.richstatus.topic.a aVar = new com.tencent.mobileqq.richstatus.topic.a(null, com.tencent.mobileqq.signature.topic.c.c(-11692801, -2142399233), new Pair(Integer.valueOf(i3), str));
            if (i16 > 0) {
                spannableStringBuilder.insert(0, text.subSequence(0, i16));
            }
            if (text.length() > i16) {
                spannableStringBuilder.insert(spannableStringBuilder.length(), text.subSequence(i16, text.length()));
            }
            spannableStringBuilder.insert(i16, (CharSequence) str);
            spannableStringBuilder.setSpan(aVar, i16, str.length() + i16, 33);
            if (QLog.isDevelopLevel()) {
                QLog.i(QPublicBaseFragment.TAG, 2, String.format("onTagSelectedInsert [%d dstLen=%d] [src=%s,dst=%s]", Integer.valueOf(i16), Integer.valueOf(spannableStringBuilder.length()), text.toString(), spannableStringBuilder.toString()));
            }
            this.f288340f0 = true;
            text.delete(0, text.length());
            text.insert(0, spannableStringBuilder);
            this.f288340f0 = false;
            if (i16 >= 0 && str.length() + i16 <= this.J.getEditableText().length()) {
                this.J.setSelection(i16 + str.length());
            } else {
                TopicEditTextView topicEditTextView = this.J;
                topicEditTextView.setSelection(topicEditTextView.getEditableText().length());
            }
        }
    }

    public void Rh(int i3, String str, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(QPublicBaseFragment.TAG, 2, String.format("onTagSelectedReplace[%d,%s] index=%d len=%d", Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17)));
        }
        int length = this.J.getText().length();
        if (i16 >= length || !Jh(i16)) {
            return;
        }
        if ((length - i17) + str.length() > 80) {
            Message message = new Message();
            message.what = 3;
            this.f288346l0.sendMessage(message);
            return;
        }
        Editable editableText = this.J.getEditableText();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (i16 > 0) {
            spannableStringBuilder.insert(0, editableText.subSequence(0, i16));
        }
        int i18 = i17 + i16 + 1;
        if (editableText.length() > i18) {
            spannableStringBuilder.insert(spannableStringBuilder.length(), editableText.subSequence(i18, editableText.length()));
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(QPublicBaseFragment.TAG, 2, String.format("onTagSelectedReplace remove before=%s after=%s", editableText, spannableStringBuilder));
        }
        this.f288340f0 = true;
        editableText.delete(0, editableText.length());
        editableText.insert(0, spannableStringBuilder);
        this.f288340f0 = false;
        Qh(i3, str, i16 + 1);
    }

    public void Uh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.H == null) {
            return;
        }
        f288334u0 = false;
        if (QLog.isColorLevel()) {
            QLog.d(QPublicBaseFragment.TAG, 1, "publishRichStatus");
        }
        if (!NetworkUtil.isNetSupport(getActivity())) {
            QQToast.makeText(getActivity(), R.string.bqf, 0).show();
            return;
        }
        if (this.H.getTotalLenForShow() > 80) {
            Message message = new Message();
            message.what = 4;
            this.f288346l0.sendMessage(message);
        } else if (this.H.bOnlyHasTopic()) {
            this.f288346l0.sendEmptyMessage(5);
        } else if (this.J.getText().length() == 0) {
            DialogUtil.createCustomDialog(getActivity(), 230, "\u6e29\u99a8\u63d0\u793a", "\u4f60\u5f53\u524d\u5df2\u5220\u9664\u4e86\u7b7e\u540d\uff0c\u786e\u8ba4\u662f\u5426\u8981\u6e05\u9664\uff1f", "\u6e05\u9664\u7b7e\u540d", "\u7ee7\u7eed\u7f16\u8f91", new p(), new a()).show();
        } else {
            Th(false);
        }
    }

    public void Vh(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) str);
            return;
        }
        if (i3 != 100 && i3 != 1) {
            if (i3 == 0) {
                this.I.clear();
                this.I.tplId = 1;
                li();
                if (TextUtils.isEmpty(str)) {
                    str = "\u6e05\u9664\u7b7e\u540d\u6210\u529f";
                }
                QQToast.makeText(BaseApplication.context, 2, str, 0).show();
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = "\u53d1\u5e03\u5931\u8d25";
            }
            QQToast.makeText(BaseApplication.context, 1, str, 0).show();
            return;
        }
        this.I.copyFrom(this.H);
        li();
        if (TextUtils.isEmpty(str)) {
            str = "\u53d1\u5e03\u6210\u529f";
        }
        QQToast.makeText(BaseApplication.context, 2, str, 0).show();
        Kh(this.J.getText().toString());
        gi(true);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) editable);
            return;
        }
        String obj = editable.toString();
        if (obj.length() == 0) {
            this.M.setVisibility(0);
        } else {
            this.M.setVisibility(8);
        }
        if (obj.equals(this.H.toSpannableStringWithoutAction().toString())) {
            if (QLog.isColorLevel()) {
                QLog.d(QPublicBaseFragment.TAG, 2, "afterTextChanged text not changed");
                return;
            }
            return;
        }
        this.f288343i0 |= true;
        this.H.ensureContent();
        this.H.plainText.set(0, com.tencent.mobileqq.signature.topic.c.d(editable));
        this.H.topics.clear();
        this.H.topics.addAll(com.tencent.mobileqq.signature.topic.c.e(editable));
        this.H.topicsPos.clear();
        this.H.topicsPos.addAll(com.tencent.mobileqq.signature.topic.c.f(editable));
        bi(this.H);
        int totalLenForShow = 80 - this.H.getTotalLenForShow();
        if (totalLenForShow < 0) {
            com.tencent.mobileqq.signature.topic.c.h(editable, totalLenForShow, this.f288338d0, this.f288339e0);
            Message message = new Message();
            message.what = 4;
            this.f288346l0.sendMessage(message);
            this.H.plainText.set(0, com.tencent.mobileqq.signature.topic.c.d(editable));
            this.H.topics.clear();
            this.H.topics.addAll(com.tencent.mobileqq.signature.topic.c.e(editable));
            this.H.topicsPos.clear();
            this.H.topicsPos.addAll(com.tencent.mobileqq.signature.topic.c.f(editable));
        }
        if (QLog.isDebugVersion()) {
            QLog.i(QPublicBaseFragment.TAG, 2, String.format("afterTextChanged [%s]", this.H.getPlainText()));
        }
        if (!this.f288340f0) {
            int selectionStart = this.J.getSelectionStart();
            int b16 = com.tencent.mobileqq.signature.topic.c.b(this.J.getEditableText(), selectionStart);
            int i3 = (selectionStart - 1) - b16;
            if (i3 < 0) {
                i3 = 0;
            }
            if (b16 >= 0 && i3 > 0) {
                str = this.J.getEditableText().subSequence(b16 + 1, selectionStart).toString();
            } else {
                str = "";
            }
            if (QLog.isColorLevel()) {
                QLog.i(QPublicBaseFragment.TAG, 2, String.format("------------------[selStart=%d, indexAt=%d, len=%d key=[%s] ]", Integer.valueOf(selectionStart), Integer.valueOf(b16), Integer.valueOf(i3), str));
            }
            Oh(b16, i3, str);
        }
        li();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.f288338d0 = i3;
            this.f288339e0 = i17;
        }
    }

    void ei() {
        InputMethodUtil.hide(this.J);
        if (Build.VERSION.SDK_INT > 23) {
            QBaseActivity qBaseActivity = getQBaseActivity();
            if (qBaseActivity == null) {
                return;
            }
            QQPermissionFactory.getQQPermission(qBaseActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_SIGN_TEXT_EDIT_LOCATION, QQPermissionConstants.Business.SCENE.START_LOC_SELECTION)).requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 2, new f());
            return;
        }
        fi();
    }

    void fi() {
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        userInfo.qzone_uin = peekAppRuntime.getCurrentAccountUin();
        userInfo.nickname = ((AppInterface) peekAppRuntime).getCurrentNickname();
        if (TextUtils.isEmpty(this.f288344j0)) {
            String string = peekAppRuntime.getPreferences().getString("sign_location_id_draft_" + peekAppRuntime.getCurrentAccountUin(), "");
            this.f288344j0 = string;
            if (TextUtils.isEmpty(string)) {
                this.f288344j0 = peekAppRuntime.getPreferences().getString(SignJsPlugin.LOCATION_SP_KEY + peekAppRuntime.getCurrentAccountUin(), "");
            }
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f288344j0)) {
            bundle.putInt("key_lbs_state", 1);
            bundle.putString("key_current_poi_id", this.f288344j0);
        }
        QZoneHelper.forwardToMoodSelectLocation(getActivity(), userInfo, 18, bundle);
        getActivity().overridePendingTransition(R.anim.f154424l, 0);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) message)).booleanValue();
        }
        boolean z16 = true;
        switch (message.what) {
            case 0:
                this.f288346l0.obtainMessage(2, Wh()).sendToTarget();
                break;
            case 1:
                Yh((RichStatus) message.obj);
                break;
            case 2:
                RichStatus richStatus = (RichStatus) message.obj;
                Mh(richStatus);
                if (richStatus != null) {
                    z16 = false;
                }
                mi(z16);
                break;
            case 3:
                if (getActivity() != null) {
                    QQToast.makeText(getActivity(), 1, "\u5b57\u6570\u5df2\u5230\u8fbe\u4e0a\u9650\uff0c\u65e0\u6cd5\u6dfb\u52a0\u6807\u7b7e", 1).show();
                    break;
                }
                break;
            case 4:
                if (getActivity() != null) {
                    QQToast.makeText(getActivity(), 1, "\u8d85\u8fc7\u5b57\u6570\u4e0a\u9650\uff01", 1).show();
                    break;
                }
                break;
            case 5:
                if (getActivity() != null) {
                    QQToast.makeText(getActivity(), "\u9700\u8981\u8f93\u5165\u6587\u5b57\u624d\u80fd\u53d1\u5e03\u54e6\uff5e", 1).show();
                    break;
                }
                break;
            case 6:
                Yh((RichStatus) message.obj);
                this.f288346l0.sendEmptyMessage(7);
                break;
            case 7:
                if (getActivity() != null) {
                    getActivity().finish();
                    break;
                }
                break;
            case 8:
                Ph();
                break;
        }
        return false;
    }

    public void li() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.K.post(new Runnable() { // from class: com.tencent.mobileqq.signature.SignTextEditFragment.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SignTextEditFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    SignTextEditFragment signTextEditFragment = SignTextEditFragment.this;
                    if (!signTextEditFragment.Ch(signTextEditFragment.I, signTextEditFragment.H)) {
                        SignTextEditFragment.this.f288343i0 = true;
                    } else {
                        SignTextEditFragment.this.f288343i0 = false;
                    }
                    if (SignTextEditFragment.this.f288343i0) {
                        SignTextEditFragment.this.K.setEnabled(true);
                        SignTextEditFragment.this.K.setAlpha(1.0f);
                    } else {
                        SignTextEditFragment.this.K.setEnabled(false);
                        SignTextEditFragment.this.K.setAlpha(0.5f);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.i(QPublicBaseFragment.TAG, 2, String.format("onActivityResult requestCode=0x%x resultCode=%d", Integer.valueOf(i3), Integer.valueOf(i16)));
        }
        if (i3 == 17) {
            if (i16 == -1 && intent != null) {
                int intExtra = intent.getIntExtra("key_sign_topic_id", -1);
                String stringExtra = intent.getStringExtra("key_sign_topic_name");
                if (intExtra > 0 && !TextUtils.isEmpty(stringExtra)) {
                    Qh(intExtra, stringExtra, this.f288341g0);
                }
            }
            this.f288341g0 = -1;
            this.f288342h0 = 0;
            li();
            return;
        }
        if (i3 == 18) {
            if (intent != null) {
                LbsDataV2.PoiInfo poiInfo = (LbsDataV2.PoiInfo) intent.getParcelableExtra(QZoneHelper.INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI);
                RichStatus richStatus = this.H;
                String str = richStatus.locationText;
                if (poiInfo == null) {
                    richStatus.locationText = "";
                } else if (poiInfo.poiName.equals("\u4e0d\u663e\u793a")) {
                    this.H.locationText = "";
                    this.f288344j0 = "";
                } else {
                    this.H.locationText = poiInfo.poiName;
                    this.f288344j0 = poiInfo.poiId;
                }
                if (!Utils.p(str, this.H.locationText)) {
                    this.f288343i0 = true;
                    mi(false);
                }
            }
            li();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("publish_ever", this.f288348n0);
        activity.setResult(-1, intent);
        int length = this.J.getText().length();
        if (QLog.isColorLevel()) {
            QLog.i(QPublicBaseFragment.TAG, 2, String.format("onBackEvent len=%d bChanged=%b bPublishEver=%b", Integer.valueOf(length), Boolean.valueOf(this.f288343i0), Boolean.valueOf(this.f288348n0)));
        }
        if (this.f288343i0 && length > 0 && isAdded()) {
            DialogUtil.createNoTitleDialog(getActivity(), "\u662f\u5426\u4fdd\u7559\u6b64\u6b21\u7f16\u8f91\uff1f", R.string.f214505t3, R.string.f214495t2, new n(), new o()).show();
        } else if (length != 0 && (this.f288343i0 || !this.f288348n0)) {
            activity.finish();
        } else {
            this.f288347m0.obtainMessage(6, null).sendToTarget();
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 != R.id.l8d && id5 != R.id.f100195ru) {
                if (id5 != R.id.l8c && id5 != R.id.ytg) {
                    if (id5 != R.id.f166115bl4 && id5 != R.id.f85424ox) {
                        if (id5 == R.id.f85344op) {
                            onBackEvent();
                            com.tencent.mobileqq.signature.report.a.c().k(102);
                        } else if (id5 == R.id.tie) {
                            Uh();
                            Sh();
                        } else if (id5 == R.id.f165694xa0) {
                            Dh();
                            com.tencent.mobileqq.signature.report.a.c().e(102);
                        } else if (id5 == R.id.btq) {
                            if (TextUtils.isEmpty(this.J.getText())) {
                                this.J.setSelection(0);
                                this.J.setCursorVisible(true);
                            }
                        } else if (id5 == R.id.f85394ou) {
                            CheckBox checkBox = this.Y;
                            if (checkBox != null) {
                                checkBox.setChecked(!checkBox.isChecked());
                            }
                        } else if (id5 == R.id.f85404ov) {
                            gi(false);
                        }
                    } else {
                        this.T.setChecked(!r0.isChecked());
                        ii();
                        com.tencent.mobileqq.signature.report.a.c().j(102);
                    }
                } else {
                    ei();
                    com.tencent.mobileqq.signature.report.a.c().g(102);
                }
            } else {
                this.f288341g0 = this.J.getSelectionStart();
                ShopHalfScreenFloatingView shopHalfScreenFloatingView = this.G;
                if (!shopHalfScreenFloatingView.f288472w0) {
                    shopHalfScreenFloatingView.S(this, this.U.getHeight());
                }
                this.G.U(ShopHalfScreenFloatingView.f288467x0);
                InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                com.tencent.mobileqq.signature.report.a.c().p(102);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            inflate = (View) iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
        } else {
            inflate = layoutInflater.inflate(R.layout.hhi, viewGroup, false);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.vas.base.VasQPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        unRegisterReceiver();
        SignatureManagerForTool.j().deleteObserver(this.f288351q0);
        ShopHalfScreenFloatingView shopHalfScreenFloatingView = this.G;
        if (shopHalfScreenFloatingView != null) {
            shopHalfScreenFloatingView.onDestroy();
        }
        ISignatureStatusManager iSignatureStatusManager = this.f288349o0;
        if (iSignatureStatusManager != null) {
            iSignatureStatusManager.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.vas.base.VasQPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            super.onPause();
            hi();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onPostThemeChanged();
            setStatusBarImmersive();
        }
    }

    @Override // com.tencent.mobileqq.vas.base.VasQPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            super.onResume();
            Xh();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) bundle);
        } else {
            super.onViewCreated(view, bundle);
            init(view);
        }
    }

    @Override // com.tencent.mobileqq.signature.topic.a.b
    public void rf(ISignatureStatusManager.TopicInfo topicInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) topicInfo);
        } else {
            Nh(topicInfo);
            li();
        }
    }

    @Override // com.tencent.mobileqq.vas.base.VasQPublicBaseFragment
    @NonNull
    protected String rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "vas_sign_text_edit";
    }
}
