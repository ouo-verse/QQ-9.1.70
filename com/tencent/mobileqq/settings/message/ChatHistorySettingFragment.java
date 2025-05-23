package com.tencent.mobileqq.settings.message;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupMigrateFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCAuthFragment;
import com.tencent.mobileqq.profilecommon.processor.ChatHistoryProfileCommonProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.settings.message.ChatHistorySettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.bf;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.ICanImportCallback;
import com.tencent.qqnt.msg.migration.NTMsgMigrationManager;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ChatHistorySettingFragment extends IphoneTitleBarFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    static IPatchRedirector $redirector_;
    private static int U;
    private QQAppInterface C;
    private String D;
    private BounceScrollView E;
    private FormSwitchItem F;
    private FormSimpleItem G;
    private View H;
    private View I;
    protected FormSimpleItem J;
    protected FormSimpleItem K;
    QQProgressDialog L;
    private com.tencent.qqnt.msg.migration.a M;
    private long N;
    private SVIPObserver P;
    com.tencent.mobileqq.troop.roamsetting.b Q;
    ar R;
    private QQProgressDialog S;
    Handler T;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistorySettingFragment.this);
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
    class b extends SVIPObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistorySettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onGetRoamType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ChatHistorySettingFragment.this.Wh();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c extends com.tencent.mobileqq.troop.roamsetting.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistorySettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.roamsetting.b
        protected void b(boolean z16, String str, Map<String, Integer> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, map);
                return;
            }
            if (!TextUtils.isEmpty(str) && str.startsWith(AppConstants.RoamingMapPath.C2C_ROAMING_MSG)) {
                if (QLog.isColorLevel()) {
                    QLog.d("SecuritySettingActivity", 2, "onSetGeneralSettingsC2CRoaming issuc =" + z16);
                }
                ChatHistorySettingFragment.this.Eh();
                BaseActivity baseActivity = ChatHistorySettingFragment.this.getBaseActivity();
                if (baseActivity == null) {
                    QLog.e("ChatHistorySettingFragment", 1, "onSetGeneralSettingsC2CRoaming: activity is null");
                    return;
                }
                if (z16) {
                    QQToast.makeText(baseActivity.getApplicationContext(), 2, R.string.d0h, 0).show(ChatHistorySettingFragment.this.getBaseActivity().getTitleBarHeight());
                    return;
                }
                if (ChatHistorySettingFragment.this.F != null) {
                    ChatHistorySettingFragment.this.F.setOnCheckedChangeListener(null);
                    FormSwitchItem formSwitchItem = ChatHistorySettingFragment.this.F;
                    if (ChatHistorySettingFragment.this.C.getC2CRoamingSetting() != 1) {
                        z17 = false;
                    }
                    formSwitchItem.setChecked(z17);
                    ChatHistorySettingFragment.this.F.setOnCheckedChangeListener(ChatHistorySettingFragment.this);
                }
                QQToast.makeText(baseActivity.getApplicationContext(), R.string.d0f, 0).show(baseActivity.getTitleBarHeight());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class d extends ar {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistorySettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetMessageRaoam(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else if (z16) {
                ChatHistorySettingFragment.this.Wh();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class e extends Handler {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistorySettingFragment.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            QQProgressDialog qQProgressDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 == 1 && (qQProgressDialog = ChatHistorySettingFragment.this.L) != null && qQProgressDialog.isShowing()) {
                    ChatHistorySettingFragment.this.L.cancel();
                    ChatHistorySettingFragment chatHistorySettingFragment = ChatHistorySettingFragment.this;
                    chatHistorySettingFragment.L.setMessage(chatHistorySettingFragment.getString(R.string.a3f));
                    ChatHistorySettingFragment.this.L.setBackAndSearchFilter(true);
                    ChatHistorySettingFragment.this.L.showTipImageView(false);
                    ChatHistorySettingFragment.this.L.showProgerss(true);
                    return;
                }
                return;
            }
            if (ChatHistorySettingFragment.this.getBaseActivity() != null && !ChatHistorySettingFragment.this.getBaseActivity().isFinishing()) {
                ChatHistorySettingFragment chatHistorySettingFragment2 = ChatHistorySettingFragment.this;
                chatHistorySettingFragment2.L.setMessage(chatHistorySettingFragment2.getString(R.string.a3d));
                ChatHistorySettingFragment.this.L.setTipImageView(R.drawable.setting_icons_correct);
                ChatHistorySettingFragment.this.L.showProgerss(false);
            }
            ChatHistorySettingFragment.this.T.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class f implements bf {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f286937a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f286938b;

        f(int i3, boolean z16) {
            this.f286937a = i3;
            this.f286938b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ChatHistorySettingFragment.this, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void a(View view, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, view, Float.valueOf(f16), Float.valueOf(f17));
            }
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void b(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, i3);
            }
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void c(View view, int i3, int i16, int i17, int i18) {
            float f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            int i19 = this.f286937a / 2;
            if (i16 <= 0) {
                f16 = 0.0f;
            } else if (i16 < i19) {
                f16 = (i16 * 1.0f) / i19;
            } else {
                f16 = 1.0f;
            }
            if (this.f286938b) {
                ChatHistorySettingFragment.this.quiSecNavBar.setTitleBlurAlpha(f16);
            } else {
                ChatHistorySettingFragment.this.quiSecNavBar.setTitleAlpha(f16);
            }
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void d(View view, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, view, Float.valueOf(f16), Float.valueOf(f17));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class g implements com.tencent.qqnt.msg.migration.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FormSimpleItem f286940a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NTMsgMigrationManager f286941b;

        g(FormSimpleItem formSimpleItem, NTMsgMigrationManager nTMsgMigrationManager) {
            this.f286940a = formSimpleItem;
            this.f286941b = nTMsgMigrationManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ChatHistorySettingFragment.this, formSimpleItem, nTMsgMigrationManager);
            }
        }

        @Override // com.tencent.qqnt.msg.migration.a
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            float b06 = NTMsgMigrationManager.X().b0();
            if (b06 == 0.0f) {
                this.f286940a.setRightText(ChatHistorySettingFragment.this.getString(R.string.f171862ow));
                return;
            }
            this.f286940a.setRightText(ChatHistorySettingFragment.this.getString(R.string.f171862ow) + this.f286941b.d0(b06));
        }

        @Override // com.tencent.qqnt.msg.migration.a
        public void b(float f16, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Boolean.valueOf(z16));
                return;
            }
            this.f286940a.setRightText(ChatHistorySettingFragment.this.getString(R.string.f171862ow) + this.f286941b.d0(f16));
        }

        @Override // com.tencent.qqnt.msg.migration.a
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                this.f286940a.setRightText("");
            }
        }

        @Override // com.tencent.qqnt.msg.migration.a
        public void d(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else {
                this.f286940a.setRightText("");
            }
        }

        @Override // com.tencent.qqnt.msg.migration.a
        public void e(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, z16);
                return;
            }
            FormSwitchItem formSwitchItem = (FormSwitchItem) ((IphoneTitleBarFragment) ChatHistorySettingFragment.this).mContentView.findViewById(R.id.f622330_);
            if (formSwitchItem.getVisibility() == 0) {
                formSwitchItem.setChecked(true);
            }
        }

        @Override // com.tencent.qqnt.msg.migration.a
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.f286940a.setRightText("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class h implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistorySettingFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.y(ChatHistorySettingFragment.this.C, "0X800B876");
                int Kh = ChatHistorySettingFragment.this.Kh();
                if (Kh != 0) {
                    if (Kh == 1) {
                        ChatHistorySettingFragment.this.Qh();
                    } else if (Kh == 2) {
                        ChatHistorySettingFragment.this.Th();
                    } else {
                        QLog.d("ChatHistorySettingFragment", 1, "Get MsgImport status error");
                    }
                } else {
                    com.tencent.mobileqq.msgbackup.authentication.a.d().h(1);
                    QPublicFragmentActivity.startForResult(ChatHistorySettingFragment.this.getActivity(), (Class<? extends QPublicBaseFragment>) MsgBackupPCAuthFragment.class, 1000);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistorySettingFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ChatHistorySettingFragment.this.Oh(NTMsgMigrationManager.X());
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class j implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistorySettingFragment.this);
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
    public class k implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistorySettingFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.y(ChatHistorySettingFragment.this.C, "0X800B875");
                int Kh = ChatHistorySettingFragment.this.Kh();
                if (Kh != 0) {
                    if (Kh == 1) {
                        ChatHistorySettingFragment.this.Sh();
                    } else if (Kh == 2) {
                        ChatHistorySettingFragment.this.Th();
                    } else {
                        QLog.e("ChatHistorySettingFragment", 1, "Get MsgImport status error");
                    }
                } else {
                    QPublicFragmentActivity.startForResult(ChatHistorySettingFragment.this.getBaseActivity(), (Class<? extends QPublicBaseFragment>) MsgBackupMigrateFragment.class, 1000);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class l implements ICanImportCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f286947a;

        l(CountDownLatch countDownLatch) {
            this.f286947a = countDownLatch;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistorySettingFragment.this, (Object) countDownLatch);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ICanImportCallback
        public void onResult(int i3, String str, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
                return;
            }
            QLog.d("ChatHistorySettingFragment", 1, "canProcessDataMigration result = ", Integer.valueOf(i3), " errMsg = ", str);
            ChatHistorySettingFragment.U = i3;
            this.f286947a.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class m implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistorySettingFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ChatHistorySettingFragment.this.Oh(NTMsgMigrationManager.X());
            dialogInterface.dismiss();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75104);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            U = 0;
        }
    }

    public ChatHistorySettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.D = "";
        this.N = 0L;
        this.P = new b();
        this.Q = new c();
        this.R = new d();
        this.T = new e();
    }

    private void Fh(boolean z16) {
        int i3;
        int i16;
        QLog.d("ChatHistorySettingFragment", 2, "hideSyncMsgGetView hidden:" + z16);
        FormSwitchItem formSwitchItem = this.F;
        int i17 = 0;
        if (z16) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        formSwitchItem.setVisibility(i3);
        FormSimpleItem formSimpleItem = this.G;
        if (z16) {
            i16 = 0;
        } else {
            i16 = 3;
        }
        formSimpleItem.setBgType(i16);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.G.getLayoutParams();
        if (z16) {
            i17 = wn0.a.f445842a.b(12);
        }
        marginLayoutParams.topMargin = i17;
        this.G.setLayoutParams(marginLayoutParams);
    }

    private void Gh() {
        BounceScrollView bounceScrollView;
        if (!needBlur() || this.quiSecNavBar == null) {
            return;
        }
        View view = ((IphoneTitleBarFragment) this).mContentView;
        if (!(view instanceof BounceScrollView)) {
            return;
        }
        BounceScrollView bounceScrollView2 = (BounceScrollView) view;
        int b16 = com.tencent.biz.qui.quisecnavbar.e.b(bounceScrollView2.getContext());
        bounceScrollView2.setPadding(0, b16, 0, 0);
        bounceScrollView2.setClipToPadding(false);
        boolean isSettingPageNavNeedBlur = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedBlur();
        boolean isSettingPageNavNeedAlpha = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedAlpha();
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (isSettingPageNavNeedBlur) {
            bounceScrollView = bounceScrollView2;
        } else {
            bounceScrollView = null;
        }
        qUISecNavBar.setBlur(isSettingPageNavNeedBlur, bounceScrollView);
        if (!isSettingPageNavNeedAlpha) {
            return;
        }
        if (isSettingPageNavNeedBlur) {
            this.quiSecNavBar.setTitleBlurAlpha(0.0f);
        } else {
            this.quiSecNavBar.setTitleAlpha(0.0f);
        }
        bounceScrollView2.setScrollListener(new f(b16, isSettingPageNavNeedBlur));
    }

    private void Hh() {
        FormSimpleItem formSimpleItem = (FormSimpleItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f6222309);
        formSimpleItem.setVisibility(0);
        final NTMsgMigrationManager X = NTMsgMigrationManager.X();
        if (X.v0()) {
            formSimpleItem.setRightText(getString(R.string.f171862ow) + X.c0());
        }
        formSimpleItem.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatHistorySettingFragment.this.Lh(X, view);
            }
        });
        g gVar = new g(formSimpleItem, X);
        this.M = gVar;
        X.K(gVar);
        FormSwitchItem formSwitchItem = (FormSwitchItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f622330_);
        if (NTMsgMigrationManager.X().D0()) {
            formSimpleItem.setBgType(1);
            formSwitchItem.setVisibility(0);
            formSwitchItem.setChecked(NTMsgMigrationManager.X().U(this.D));
            formSwitchItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.settings.message.b
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    ChatHistorySettingFragment.this.Mh(compoundButton, z16);
                }
            });
        }
    }

    private void Ih() {
        FormSimpleItem formSimpleItem = (FormSimpleItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.m5d);
        this.K = formSimpleItem;
        formSimpleItem.setContentDescription(getString(R.string.ijf));
        this.K.setOnClickListener(new h());
        ReportController.y(this.C, "0X800B812");
    }

    private void Jh() {
        FormSimpleItem formSimpleItem = (FormSimpleItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.m5e);
        this.J = formSimpleItem;
        formSimpleItem.setContentDescription(getString(R.string.ije));
        ReportController.y(this.C, "0X800B811");
        this.J.setOnClickListener(new k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Kh() {
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            QLog.e("ChatHistorySettingFragment", 1, "kernelMsgService is null");
            return U;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        QLog.d("ChatHistorySettingFragment", 1, "CountDownLatch start: ", Long.valueOf(System.currentTimeMillis()));
        e16.canProcessDataMigration(new l(countDownLatch));
        try {
            countDownLatch.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e17) {
            QLog.e("ChatHistorySettingFragment", 1, "InterruptedException: ", e17);
        }
        QLog.d("ChatHistorySettingFragment", 1, "CountDownLatch time: ", Long.valueOf(Long.valueOf(System.currentTimeMillis()).longValue() - valueOf.longValue()));
        QLog.d("ChatHistorySettingFragment", 1, "isMsgImportDone resultCode: ", Integer.valueOf(U));
        return U;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lh(NTMsgMigrationManager nTMsgMigrationManager, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!nTMsgMigrationManager.w0()) {
            QQToast.makeText(getContext(), 1, R.string.f172042pd, 0).show();
        } else if (!nTMsgMigrationManager.v0()) {
            Oh(nTMsgMigrationManager);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Mh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        NTMsgMigrationManager.X().e1(this.D, z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Nh(NTMsgMigrationManager nTMsgMigrationManager, String str, int i3, String str2, int i16) {
        QLog.d("ChatHistorySettingFragment", 1, "initNtMsgMigration canImportOldDbMsg " + i3 + " " + str2 + " level=" + i16);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(i3, nTMsgMigrationManager, i16, str) { // from class: com.tencent.mobileqq.settings.message.ChatHistorySettingFragment.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f286928d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ NTMsgMigrationManager f286929e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f286930f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f286931h;

            {
                this.f286928d = i3;
                this.f286929e = nTMsgMigrationManager;
                this.f286930f = i16;
                this.f286931h = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ChatHistorySettingFragment.this, Integer.valueOf(i3), nTMsgMigrationManager, Integer.valueOf(i16), str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (ChatHistorySettingFragment.this.getActivity() != null && !ChatHistorySettingFragment.this.getActivity().isFinishing()) {
                    int i17 = this.f286928d;
                    if (i17 != 3 && i17 != 2) {
                        str3 = "2";
                    } else {
                        str3 = "1";
                    }
                    ReportController.o(null, "dc00898", "", "", "0X800C4D6", "0X800C4D6", NTMsgMigrationManager.X().h0(), 0, str3, "", "", "");
                    int i18 = this.f286928d;
                    if (i18 != 3 && i18 != 2) {
                        QQToast.makeText(ChatHistorySettingFragment.this.getContext(), 0, R.string.f171872ox, 0).show();
                        this.f286929e.o1(this.f286930f);
                        this.f286929e.m1(this.f286931h, false);
                        this.f286929e.U0(this.f286931h);
                        this.f286929e.F1(this.f286931h);
                        if (this.f286928d == 1) {
                            this.f286929e.k0(this.f286931h);
                            return;
                        } else {
                            this.f286929e.G0(this.f286931h, false, false);
                            return;
                        }
                    }
                    QQToast.makeText(ChatHistorySettingFragment.this.getContext(), 0, R.string.f171842ou, 0).show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh(final NTMsgMigrationManager nTMsgMigrationManager) {
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            return;
        }
        final String currentAccountUin = this.C.getCurrentAccountUin();
        if (TextUtils.isEmpty(currentAccountUin)) {
            return;
        }
        QLog.d("NTMsgMigration.Manager", 1, "onClickImport");
        e16.canImportOldDbMsg(new ICanImportCallback() { // from class: com.tencent.mobileqq.settings.message.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.ICanImportCallback
            public final void onResult(int i3, String str, int i16) {
                ChatHistorySettingFragment.this.Nh(nTMsgMigrationManager, currentAccountUin, i3, str, i16);
            }
        });
    }

    private void Ph() {
        ReportController.y(this.C, "0X800B813");
        ReportController.y(this.C, "0X800B815");
        ReportController.y(this.C, "0X800B816");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh() {
        DialogUtil.createCustomDialog(getContext(), 231, (String) null, getString(R.string.zd8), getString(R.string.zd_), getString(R.string.zd9), new i(), new j()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh() {
        DialogUtil.createCustomDialog(getContext(), 231, (String) null, getString(R.string.f16526282), getString(R.string.zd_), getString(R.string.zd9), new m(), new a()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Th() {
        QLog.d("ChatHistorySettingFragment", 1, "showMsgImportProgressTip");
        QQToast.makeText(getContext(), getString(R.string.f168352fe), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uh(boolean z16) {
        QQProgressDialog qQProgressDialog = this.L;
        if (qQProgressDialog != null) {
            if (z16 && !qQProgressDialog.isShowing()) {
                this.L.show();
            } else if (!z16 && this.L.isShowing()) {
                this.L.dismiss();
            }
        }
    }

    private void Vh(boolean z16) {
        QLog.d("ChatHistorySettingFragment", 2, "showSyncMsgGetViewIfNeed isSyncSwitchOpen:" + z16);
        boolean z17 = false;
        if (z16) {
            boolean isFeatureSwitchEnable = ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("QQ_c2c_chat_record_hidden_switch", false);
            QLog.d("ChatHistorySettingFragment", 2, "showSyncMsgGetViewIfNeed featureEnable:" + isFeatureSwitchEnable);
            Fh(isFeatureSwitchEnable);
            return;
        }
        if (QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt(ChatHistoryProfileCommonProcessor.f260937a + "_" + this.D, 0) == 1) {
            z17 = true;
        }
        QLog.d("ChatHistorySettingFragment", 2, "showSyncMsgGetViewIfNeed isFlagEnable:" + z17);
        Fh(z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wh() {
        String string;
        if (getBaseActivity() == null) {
            QLog.e("ChatHistorySettingFragment", 1, "syncMessageRoamFlag: activity is null");
            return;
        }
        SharedPreferences sharedPreferences = this.C.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
        if (sharedPreferences == null) {
            QLog.e("ChatHistorySettingFragment", 1, "syncMessageRoamFlag: pref is null");
            return;
        }
        int i3 = sharedPreferences.getInt("message_roam_flag" + this.C.getCurrentAccountUin(), 0);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            string = null;
                        } else {
                            string = getResources().getString(R.string.g3r);
                        }
                    } else {
                        string = getResources().getString(R.string.g3p);
                    }
                } else {
                    string = getResources().getString(R.string.g3q);
                }
            } else {
                string = getResources().getString(R.string.g3s);
            }
        } else {
            string = getResources().getString(R.string.f172963g45);
        }
        if (!TextUtils.isEmpty(string)) {
            this.G.setRightText(string);
        } else if (QLog.isColorLevel()) {
            QLog.d("QQSettingMsgHistoryActivity", 2, "messge roam flag is error ,is : " + i3);
        }
    }

    private void Xh() {
        int i3;
        Intent intent = getBaseActivity().getIntent();
        if (intent != null && intent.hasExtra("set_display_type")) {
            i3 = intent.getIntExtra("set_display_type", 0);
        } else {
            i3 = 0;
        }
        if (i3 == 2) {
            this.F.setVisibility(8);
            this.G.setVisibility(8);
        } else {
            this.F.setVisibility(0);
            this.G.setVisibility(0);
            ReportController.y(this.C, "0X800B814");
        }
    }

    private void initUI() {
        boolean z16;
        this.E = (BounceScrollView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ii_);
        this.D = this.C.getCurrentAccountUin();
        this.F = (FormSwitchItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.qq_setting_sync_msg_switch);
        if (this.C.getC2CRoamingSetting() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.F.setChecked(z16);
        this.F.setOnCheckedChangeListener(this);
        FormSimpleItem formSimpleItem = (FormSimpleItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.eqs);
        this.G = formSimpleItem;
        formSimpleItem.setRightTextColor(2);
        this.G.setOnClickListener(this);
        this.H = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.delRecentList);
        this.I = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.delChatHistory);
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.H.setContentDescription(getString(R.string.ajt));
        this.I.setContentDescription(getString(R.string.ajf));
        Hh();
        Jh();
        Ih();
        this.C.addObserver(this.Q);
        this.C.addObserver(this.R);
        this.C.addObserver(this.P);
        Xh();
        Vh(z16);
        if (VersionUtils.isGingerBread()) {
            this.E.setOverScrollMode(0);
        }
        if (this.L == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
            this.L = qQProgressDialog;
            qQProgressDialog.setMessage(getString(R.string.a3f));
            this.L.setCanceledOnTouchOutside(true);
            this.L.setBackAndSearchFilter(true);
            this.L.showTipImageView(false);
            this.L.showProgerss(true);
        }
        Ph();
    }

    void Eh() {
        try {
            QQProgressDialog qQProgressDialog = this.S;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
                this.S.cancel();
                this.S = null;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    void Rh(String str) {
        if (this.S == null) {
            this.S = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
        }
        this.S.setCancelable(true);
        this.S.setMessage(str);
        this.S.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        if (getBaseActivity().getAppRuntime() instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) getBaseActivity().getAppRuntime();
            this.C = qQAppInterface;
            if (qQAppInterface != null) {
                initUI();
                Gh();
            }
        }
        setTitle(getBaseActivity().getString(R.string.zk7));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.h3n;
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public boolean needBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (1000 == i3 && i16 == 1001) {
            if (getBaseActivity() != null) {
                getBaseActivity().setResult(1001);
            }
            onBackEvent();
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, compoundButton, Boolean.valueOf(z16));
        } else if (!NetworkUtil.isNetSupport(this.C.getApplication().getApplicationContext())) {
            QQToast.makeText(getBaseActivity().getApplicationContext(), R.string.f171139ci4, 1).show();
            this.F.setOnCheckedChangeListener(null);
            FormSwitchItem formSwitchItem = this.F;
            if (this.C.getC2CRoamingSetting() == 1) {
                z17 = true;
            }
            formSwitchItem.setChecked(z17);
            this.F.setOnCheckedChangeListener(this);
        } else {
            ao.a(this.C, "0X800B877", z16);
            Rh(getBaseActivity().getApplication().getResources().getString(R.string.hfh));
            this.C.setC2CRoamingSetting(z16 ? 1 : 0);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        int i16;
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else if (view.getId() == R.id.eqs) {
            String url = IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.VIP_CHAT_ROAM_CELL);
            if (TextUtils.isEmpty(url)) {
                QLog.e("ChatHistorySettingFragment", 1, "gotoRoamMessageSettingUrl ! url empty");
            } else {
                if (url.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    str = url + "&ADTAG=msgRoam";
                } else {
                    str = url + "?ADTAG=msgRoam";
                }
                String buildTraceDetailUrl = ((IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class)).buildTraceDetailUrl(str, IVipTraceDetailReport.FROM.SETTING_CHAT_HISTORY_ROAM);
                if (QLog.isColorLevel()) {
                    QLog.i("ChatHistorySettingFragment", 2, "message_roam_setting pageUrl:" + buildTraceDetailUrl);
                }
                if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                    ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(getContext(), buildTraceDetailUrl);
                } else {
                    Intent intent = new Intent(getBaseActivity(), (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", buildTraceDetailUrl);
                    startActivity(intent);
                }
                ReportController.y(this.C, "0X800B878");
            }
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = currentTimeMillis - this.N;
            if (!getBaseActivity().isFinishing() && j3 >= 500) {
                this.N = currentTimeMillis;
                ActionSheet.OnButtonClickListener onButtonClickListener = null;
                ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(getBaseActivity(), null);
                int id5 = view.getId();
                if (id5 == R.id.delRecentList) {
                    onButtonClickListener = new ActionSheet.OnButtonClickListener(actionSheet) { // from class: com.tencent.mobileqq.settings.message.ChatHistorySettingFragment.11
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ ActionSheet f286922d;

                        /* compiled from: P */
                        /* renamed from: com.tencent.mobileqq.settings.message.ChatHistorySettingFragment$11$1, reason: invalid class name */
                        /* loaded from: classes18.dex */
                        class AnonymousClass1 implements Runnable {
                            static IPatchRedirector $redirector_;

                            AnonymousClass1() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass11.this);
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static /* synthetic */ Unit b(Boolean bool) {
                                return null;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                    return;
                                }
                                ChatHistorySettingFragment.this.C.getMsgHandler().c5(true);
                                ChatHistorySettingNTHelper.e(ChatHistorySettingFragment.this.getLifecycle(), new Function1() { // from class: com.tencent.mobileqq.settings.message.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit b16;
                                        b16 = ChatHistorySettingFragment.AnonymousClass11.AnonymousClass1.b((Boolean) obj);
                                        return b16;
                                    }
                                });
                                ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).clearSubAccountAssistantTime();
                                ChatHistorySettingFragment.this.T.sendEmptyMessageDelayed(0, 1000L);
                                MqqHandler handler = ChatHistorySettingFragment.this.C.getHandler(Conversation.class);
                                if (handler != null) {
                                    handler.sendEmptyMessage(1009);
                                }
                            }
                        }

                        {
                            this.f286922d = actionSheet;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistorySettingFragment.this, (Object) actionSheet);
                            }
                        }

                        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                        public void onClick(View view2, int i17) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view2, i17);
                                return;
                            }
                            ReportController.y(ChatHistorySettingFragment.this.C, "0X800B879");
                            if (!ChatHistorySettingFragment.this.getBaseActivity().isFinishing()) {
                                this.f286922d.cancel();
                                ChatHistorySettingFragment.this.Uh(true);
                            }
                            ThreadManagerV2.excute(new AnonymousClass1(), 64, null, true);
                        }
                    };
                    i3 = R.string.ajt;
                    i16 = R.string.a3e;
                } else if (id5 == R.id.delChatHistory) {
                    onButtonClickListener = new ActionSheet.OnButtonClickListener(actionSheet) { // from class: com.tencent.mobileqq.settings.message.ChatHistorySettingFragment.12
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ ActionSheet f286925d;

                        {
                            this.f286925d = actionSheet;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistorySettingFragment.this, (Object) actionSheet);
                            }
                        }

                        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                        public void onClick(View view2, int i17) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view2, i17);
                                return;
                            }
                            ReportController.y(ChatHistorySettingFragment.this.C, "0X800B87A");
                            if (!ChatHistorySettingFragment.this.getBaseActivity().isFinishing()) {
                                this.f286925d.cancel();
                                ChatHistorySettingFragment.this.Uh(true);
                            }
                            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.settings.message.ChatHistorySettingFragment.12.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass12.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    ChatHistorySettingNTHelper.f(ChatHistorySettingFragment.this.getLifecycle());
                                    ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).clearSubAccountAssistantTime();
                                    ChatHistorySettingFragment.this.T.sendEmptyMessageDelayed(0, 1000L);
                                }
                            }, 64, null, true);
                        }
                    };
                    i3 = R.string.zqo;
                    i16 = R.string.zqp;
                } else {
                    i3 = 0;
                    i16 = 0;
                }
                actionSheet.addButton(i3, 3);
                actionSheet.addCancelButton(getString(R.string.cancel));
                actionSheet.setOnButtonClickListener(onButtonClickListener);
                actionSheet.setMainTitle(i16);
                actionSheet.show();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public View onCreateCenterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return super.onCreateCenterView();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.L;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            Uh(false);
        }
        QQAppInterface qQAppInterface = this.C;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.Q);
            this.C.removeObserver(this.R);
            this.C.removeObserver(this.P);
        }
        this.T.removeCallbacksAndMessages(null);
        super.onDestroy();
        QQSettingMsgHistoryActivity.H2();
        com.tencent.mobileqq.qrscan.utils.b.c(getBaseActivity());
        if (this.M != null) {
            NTMsgMigrationManager.X().X0(this.M);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            super.onResume();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onStart();
        if (this.C != null) {
            Wh();
            ((com.tencent.mobileqq.apollo.handler.b) this.C.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).j2(new String[]{this.C.getCurrentAccountUin()}, new int[]{42255});
        }
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }
}
