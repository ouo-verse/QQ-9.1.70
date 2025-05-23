package com.tencent.mobileqq.settings.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.utils.DateUtil;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.av.utils.AVUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.VibrateNewFragment;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.newsetting.business.view.MsgNotifySettingView;
import com.tencent.mobileqq.activity.newsetting.business.view.NotifyPushSettingView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ForegroundNotifyManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.NumberWheelView;
import com.tencent.mobileqq.app.utils.TimeWheelPanel;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.profilecommon.processor.QZoneSwitchProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.settings.message.NotifyPushSettingFragment;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.bf;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.PrivacySetting;
import com.tencent.qqnt.kernel.nativeinterface.SettingKeyForStr;
import com.tencent.qqnt.kernel.nativeinterface.bp;
import com.tencent.util.BadgeUtils;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.VerticalGallery;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

/* loaded from: classes18.dex */
public class NotifyPushSettingFragment extends IphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    private QQAppInterface C;
    String D;
    private com.tencent.mobileqq.activity.newsetting.custom.config.b E;
    private com.tencent.mobileqq.activity.newsetting.custom.config.b F;
    private com.tencent.mobileqq.activity.newsetting.custom.config.b G;
    private com.tencent.mobileqq.activity.newsetting.custom.config.b H;
    private com.tencent.mobileqq.activity.newsetting.custom.config.b I;
    private com.tencent.mobileqq.activity.newsetting.custom.config.b J;
    private com.tencent.mobileqq.activity.newsetting.custom.config.b K;
    private com.tencent.mobileqq.widget.listitem.c L;
    private com.tencent.mobileqq.activity.newsetting.custom.config.b M;
    private com.tencent.mobileqq.activity.newsetting.custom.config.b N;
    private com.tencent.mobileqq.widget.listitem.c<c.a.g, c.b.C8994b> P;
    CompoundButton.OnCheckedChangeListener Q;
    private l R;
    private com.tencent.mobileqq.message.newmsg.a S;
    private ForegroundNotifyManager T;
    private final AtomicBoolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f286960a0;

    /* renamed from: b0, reason: collision with root package name */
    private final com.tencent.mobileqq.qdispatchqueue.h f286961b0;

    /* renamed from: c0, reason: collision with root package name */
    private final CompoundButton.OnCheckedChangeListener f286962c0;

    /* renamed from: d0, reason: collision with root package name */
    private NotifyPushSettingView f286963d0;

    /* renamed from: e0, reason: collision with root package name */
    private View.OnClickListener f286964e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f286965f0;

    /* renamed from: g0, reason: collision with root package name */
    private Long f286966g0;

    /* renamed from: h0, reason: collision with root package name */
    private IKernelSettingListener f286967h0;

    /* renamed from: i0, reason: collision with root package name */
    CompoundButton.OnCheckedChangeListener f286968i0;

    /* renamed from: j0, reason: collision with root package name */
    private final CardObserver f286969j0;

    /* renamed from: k0, reason: collision with root package name */
    private final MqqWeakReferenceHandler f286970k0;

    /* renamed from: l0, reason: collision with root package name */
    public BroadcastReceiver f286971l0;

    /* renamed from: m0, reason: collision with root package name */
    private final CompoundButton.OnCheckedChangeListener f286972m0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a extends CardObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifyPushSettingFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            QQToast.makeText(NotifyPushSettingFragment.this.getBaseActivity(), 1, HardCodeUtil.qqStr(R.string.otc), 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            NotifyPushSettingFragment.this.E.f0(str);
            NotifyPushSettingFragment.this.Ui(!r6.Ci(), false);
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetPCActiveState(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (z16) {
                Message obtainMessage = NotifyPushSettingFragment.this.f286970k0.obtainMessage();
                obtainMessage.what = 10000;
                obtainMessage.obj = Boolean.valueOf(z17);
                NotifyPushSettingFragment.this.f286970k0.sendMessage(obtainMessage);
                QLog.i("CardObserver_onGetPCActiveState", 1, "Succeeded to Get PC Active State with Msg");
                return;
            }
            QLog.i("CardObserver_onGetPCActiveState", 1, "Failed to Get PC Active State with Msg");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.CardObserver
        public void onSetNotDisturb(boolean z16, final String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2);
                return;
            }
            super.onSetNotDisturb(z16, str, str2);
            if (!"not_disturb_from_notify_push_setting_activity".equals(str2)) {
                if (QLog.isColorLevel()) {
                    QLog.d("IphoneTitleBarFragment", 4, "onSetNotDisturb NOT FROM THIS" + str2);
                    return;
                }
                return;
            }
            NotifyPushSettingFragment.this.U.set(false);
            if (!z16) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.settings.message.ai
                    @Override // java.lang.Runnable
                    public final void run() {
                        NotifyPushSettingFragment.a.this.b(str);
                    }
                });
                return;
            }
            MqqHandler handler = NotifyPushSettingFragment.this.C.getHandler(Conversation.class);
            if (handler != null) {
                Conversation.updateDonDisturb(handler, NotifyPushSettingFragment.this.getBaseActivity());
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetPCActiveState(boolean z16, boolean z17, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str, str2);
                return;
            }
            if (z16) {
                SettingCloneUtil.writeValue(NotifyPushSettingFragment.this.getBaseActivity(), NotifyPushSettingFragment.this.D, (String) null, AppConstants.QQSETTING_PCACTIVE_KEY, z17);
                QLog.i("CardObserver_onSetPCActiveState", 1, "Set the PC Active State " + z16);
                return;
            }
            Message obtainMessage = NotifyPushSettingFragment.this.f286970k0.obtainMessage();
            obtainMessage.what = 10001;
            obtainMessage.obj = str2;
            NotifyPushSettingFragment.this.f286970k0.sendMessage(obtainMessage);
            QQToast.makeText(NotifyPushSettingFragment.this.getBaseActivity(), str, 0).show(5);
            QLog.i("SetPCActiveState_Failure", 1, "Failed to set PC Active State " + str);
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetShowPushNotice(boolean z16, boolean z17) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (z16) {
                SettingCloneUtil.writeValue(NotifyPushSettingFragment.this.getBaseActivity(), NotifyPushSettingFragment.this.D, (String) null, AppConstants.QQSETTING_SHOW_PUSH_MESSAGE, z17);
                QLog.i("CardObserver_onSetShowPushNotice", 1, "Set show push notice");
                if (z17) {
                    str = "0X8009520";
                } else {
                    str = "0X800951F";
                }
                String str2 = str;
                ReportController.o(null, "dc00898", "", "", str2, str2, 0, 1, "", "", "", "");
                return;
            }
            Message obtainMessage = NotifyPushSettingFragment.this.f286970k0.obtainMessage();
            obtainMessage.what = 10004;
            obtainMessage.obj = Boolean.valueOf(z17);
            NotifyPushSettingFragment.this.f286970k0.sendMessage(obtainMessage);
            QQToast.makeText(NotifyPushSettingFragment.this.C.getApp(), 1, NotifyPushSettingFragment.this.getString(R.string.hhc), 0).show(5);
            QLog.i("onSetShowPushNotice_Failure", 1, "Failed to set push notice");
        }
    }

    /* loaded from: classes18.dex */
    class b implements Handler.Callback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifyPushSettingFragment.this);
            }
        }

        @Override // android.os.Handler.Callback
        public synchronized boolean handleMessage(@NonNull Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            int i3 = message.what;
            if (i3 != 10000) {
                if (i3 != 10001) {
                    if (i3 != 10004) {
                        return false;
                    }
                    NotifyPushSettingFragment.this.G.a0(((Boolean) message.obj).booleanValue());
                } else {
                    NotifyPushSettingFragment.this.Gi((String) message.obj);
                }
            } else {
                NotifyPushSettingFragment.this.H.a0(((Boolean) message.obj).booleanValue());
            }
            return true;
        }
    }

    /* loaded from: classes18.dex */
    class c extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifyPushSettingFragment.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            if ("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive".equals(action)) {
                NotifyPushSettingFragment.this.Gi(intent.getStringExtra("uin"));
                return;
            }
            if ("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive".equals(action)) {
                String stringExtra = intent.getStringExtra("uin");
                boolean booleanExtra = intent.getBooleanExtra("configPCActive", false);
                if (NotifyPushSettingFragment.this.C.getAccount().equals(stringExtra) && NotifyPushSettingFragment.this.H != null) {
                    if (booleanExtra) {
                        NotifyPushSettingFragment.this.H.h0(0);
                    } else {
                        NotifyPushSettingFragment.this.H.h0(8);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class d implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifyPushSettingFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(boolean z16) {
            SettingCloneUtil.writeValue(NotifyPushSettingFragment.this.C.getApp(), NotifyPushSettingFragment.this.C.getCurrentUin(), (String) null, AppConstants.TOP_MSG_NOTIFICATION_KEY, z16);
            ao.a(NotifyPushSettingFragment.this.C, "0X800B845", z16);
            if (QLog.isColorLevel()) {
                QLog.i("IphoneTitleBarFragment", 2, "update top msg notification switch to " + z16);
            }
            NotifyPushSettingFragment.Ni("em_bas_top_message_alert_switch", z16);
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, final boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else if (NotifyPushSettingFragment.this.Yi()) {
                NotifyPushSettingFragment.Ti(NotifyPushSettingFragment.this.K);
            } else {
                boolean areNotificationsEnabled = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplication.getContext());
                com.tencent.mobileqq.message.newmsg.a d16 = com.tencent.mobileqq.message.newmsg.a.d(NotifyPushSettingFragment.this.C);
                if (!areNotificationsEnabled && d16 != null) {
                    d16.o(NotifyPushSettingFragment.this.getBaseActivity());
                    NotifyPushSettingFragment.this.K.e0(null);
                    NotifyPushSettingFragment.this.K.a0(true ^ NotifyPushSettingFragment.this.K.W());
                    NotifyPushSettingFragment.this.K.e0(NotifyPushSettingFragment.this.f286972m0);
                } else {
                    NotifyPushSettingFragment.this.f286961b0.post(new Runnable() { // from class: com.tencent.mobileqq.settings.message.aj
                        @Override // java.lang.Runnable
                        public final void run() {
                            NotifyPushSettingFragment.d.this.b(z16);
                        }
                    });
                }
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* loaded from: classes18.dex */
    class e implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifyPushSettingFragment.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                int netWorkType = HttpUtil.getNetWorkType();
                if (netWorkType != -1) {
                    i3 = netWorkType;
                }
                if (i3 != 0) {
                    NotifyPushSettingFragment.this.Ui(z16, true);
                    if (z16) {
                        String str = HardCodeUtil.qqStr(R.string.f172248ot3) + l.N(3600000L);
                        NotifyPushSettingFragment.this.E.f0(str);
                        NotifyPushSettingFragment.this.U.set(true);
                        ((CardHandler) NotifyPushSettingFragment.this.C.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).W4((int) (NetConnInfoCenter.getServerTime() + 3600), "", "not_disturb_from_notify_push_setting_activity");
                        HashMap hashMap = new HashMap();
                        hashMap.put("disturb_time", str);
                        NotifyPushSettingFragment.Si("em_bas_not_disturb_time", Boolean.valueOf(NotifyPushSettingFragment.this.E.W()), hashMap);
                    } else {
                        String V = NotifyPushSettingFragment.this.E.V();
                        NotifyPushSettingFragment.this.U.set(true);
                        ((CardHandler) NotifyPushSettingFragment.this.C.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).W4(0, V, "not_disturb_from_notify_push_setting_activity");
                    }
                    ao.a(NotifyPushSettingFragment.this.C, "0X800B849", z16);
                    NotifyPushSettingFragment.Ni("em_bas_not_disturb_mode", z16);
                    NotifyPushSettingFragment.this.Ei(z16, false);
                } else {
                    QQToast.makeText(NotifyPushSettingFragment.this.getBaseActivity(), 1, R.string.dqp, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    NotifyPushSettingFragment.this.Ui(!z16, false);
                }
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class f implements bf {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f286983a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f286984b;

        f(int i3, boolean z16) {
            this.f286983a = i3;
            this.f286984b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NotifyPushSettingFragment.this, Integer.valueOf(i3), Boolean.valueOf(z16));
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
            int i19 = this.f286983a / 2;
            if (i16 <= 0) {
                f16 = 0.0f;
            } else if (i16 < i19) {
                f16 = (i16 * 1.0f) / i19;
            } else {
                f16 = 1.0f;
            }
            if (this.f286984b) {
                NotifyPushSettingFragment.this.quiSecNavBar.setTitleBlurAlpha(f16);
            } else {
                NotifyPushSettingFragment.this.quiSecNavBar.setTitleAlpha(f16);
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
    /* loaded from: classes18.dex */
    public class g implements IOperateCallback {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifyPushSettingFragment.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            } else {
                QLog.d("IphoneTitleBarFragment", 1, "kernelSettingService, result: ", Integer.valueOf(i3), " errMsg: ", str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class h implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f286987d;

        h(String str) {
            this.f286987d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifyPushSettingFragment.this, (Object) str);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                if (!NotifyPushSettingFragment.qi()) {
                    NotifyPushSettingFragment.this.Zi(z16);
                } else {
                    NotifyPushSettingFragment.this.N.a0(false);
                    NotifyPushSettingFragment.this.N.h0(8);
                }
                SettingCloneUtil.writeValue(BaseApplication.getContext(), this.f286987d, NotifyPushSettingFragment.this.getString(R.string.f173079h50), AppConstants.QQSETTING_NOTIFY_SHOWCONTENT_KEY, z16);
                ReportController.o(NotifyPushSettingFragment.this.C, "CliOper", "", "", "Setting_tab", "Clk_hide_text", 0, z16 ? 1 : 0, String.valueOf(z16 ? 1 : 0), "", "", "");
                com.tencent.qqnt.notification.report.h.w("pg_bas_message_notification", "em_bas_notification_message_preview_switch", Boolean.valueOf(z16));
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class i implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f286989d;

        i(String str) {
            this.f286989d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifyPushSettingFragment.this, (Object) str);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            String str;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                SettingCloneUtil.writeValue(BaseApplication.getContext(), this.f286989d, NotifyPushSettingFragment.this.getString(R.string.receive_msg_whenexit), AppConstants.QQSETTING_LOCKSCREENMSG_WHENEXIST_KEY, z16);
                QQAppInterface qQAppInterface = NotifyPushSettingFragment.this.C;
                if (z16) {
                    str = "1";
                } else {
                    str = "0";
                }
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X80040D9", "0X80040D9", 0, 0, str, "", "", "");
                if (QLog.isDevelopLevel()) {
                    QLog.i("qqls", 4, "collectPerformance qqls setting isChecked=" + z16);
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_ls_setting", z16 + "");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(NotifyPushSettingFragment.this.C.getCurrentAccountUin(), StatisticCollector.QQLS_SETTING_REPORT_TAG, true, 0L, 0L, hashMap, "");
                com.tencent.qqnt.notification.report.h.w("pg_bas_message_notification", "em_bas_message_lock_screen", Boolean.valueOf(z16));
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class j implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifyPushSettingFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(ActionSheet actionSheet, View view, int i3) {
            String str;
            if (i3 != 0) {
                if (i3 == 1) {
                    NotifyPushSettingFragment.this.Fi(false);
                    actionSheet.dismiss();
                    str = "2";
                } else {
                    str = "3";
                }
            } else {
                NotifyPushSettingFragment.this.J.a0(true);
                NotifyPushSettingFragment.this.Ei(true, true);
                actionSheet.dismiss();
                str = "1";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("msg_notify_type", str);
            NotifyPushSettingFragment.Ii("em_bas_message_notification_type", hashMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(ActionSheet actionSheet, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            NotifyPushSettingFragment.this.J.a0(true);
            actionSheet.dismiss();
            HashMap hashMap = new HashMap();
            hashMap.put("msg_notify_type", "3");
            NotifyPushSettingFragment.Ii("em_bas_message_notification_type", hashMap);
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g() {
            NotifyPushSettingFragment.this.J.a0(true);
            HashMap hashMap = new HashMap();
            hashMap.put("msg_notify_type", "3");
            NotifyPushSettingFragment.Ii("em_bas_message_notification_type", hashMap);
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else if (NotifyPushSettingFragment.this.Yi()) {
                NotifyPushSettingFragment.Ti(NotifyPushSettingFragment.this.J);
            } else if (!NotifyPushSettingFragment.this.bi()) {
                NotifyPushSettingFragment.this.S.o(NotifyPushSettingFragment.this.getQBaseActivity());
                NotifyPushSettingFragment.this.J.e0(null);
                NotifyPushSettingFragment.this.J.a0(true ^ NotifyPushSettingFragment.this.J.W());
                NotifyPushSettingFragment.this.J.e0(NotifyPushSettingFragment.this.f286968i0);
            } else if (z16 || !ABTestController.getInstance().getExpEntity("exp_qq_notification_unsub_reconfirm").isExperiment()) {
                NotifyPushSettingFragment.this.Fi(z16);
            } else {
                final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(NotifyPushSettingFragment.this.getActivity(), null);
                actionSheet.addButton(R.string.f171542o1);
                actionSheet.addButton(R.string.f227756rw, 3);
                actionSheet.setMainTitle(R.string.f227766rx);
                actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.settings.message.ak
                    @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                    public final void onClick(View view, int i3) {
                        NotifyPushSettingFragment.j.this.e(actionSheet, view, i3);
                    }
                });
                actionSheet.addCancelButton(R.string.cancel);
                actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.al
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NotifyPushSettingFragment.j.this.f(actionSheet, view);
                    }
                });
                actionSheet.setOnDismissListener(new ActionSheet.OnDismissListener() { // from class: com.tencent.mobileqq.settings.message.am
                    @Override // com.tencent.widget.ActionSheet.OnDismissListener
                    public final void onDismiss() {
                        NotifyPushSettingFragment.j.this.g();
                    }
                });
                actionSheet.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mobileqq.settings.message.an
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        NotifyPushSettingFragment.Xh("em_bas_message_selection_panel");
                    }
                });
                actionSheet.show();
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class k implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final com.tencent.mobileqq.activity.newsetting.custom.config.b<?, ?> f286992d;

        /* renamed from: e, reason: collision with root package name */
        private final CompoundButton.OnCheckedChangeListener f286993e;

        k(com.tencent.mobileqq.activity.newsetting.custom.config.b<?, ?> bVar, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NotifyPushSettingFragment.this, bVar, onCheckedChangeListener);
            } else {
                this.f286992d = bVar;
                this.f286993e = onCheckedChangeListener;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.mobileqq.activity.newsetting.custom.config.b<?, ?> bVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (NotifyPushSettingFragment.this.Ci()) {
                NotifyPushSettingFragment.this.Xi(view);
            } else if (AppSetting.f99565y && (bVar = this.f286992d) != null) {
                bVar.a0(!bVar.W());
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f286993e;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(null, this.f286992d.W());
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes18.dex */
    public static class l extends ReportDialog implements View.OnClickListener, TimeWheelPanel.b, DialogInterface.OnCancelListener, DialogInterface.OnShowListener {
        static IPatchRedirector $redirector_;
        private final Context C;
        private TimeWheelPanel D;
        private final View E;
        private TextView F;
        private final a G;
        private final QQAppInterface H;
        private AtomicBoolean I;
        private boolean J;

        /* loaded from: classes18.dex */
        public interface a {
            void a(String str);
        }

        public l(Context context, QQAppInterface qQAppInterface, a aVar) {
            super(context, R.style.f173751jn);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, aVar);
                return;
            }
            this.J = false;
            requestWindowFeature(1);
            this.H = qQAppInterface;
            this.G = aVar;
            this.C = context;
            View inflate = getLayoutInflater().inflate(R.layout.arx, (ViewGroup) null);
            this.E = inflate;
            setContentView(inflate);
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 81;
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.f173752jo);
            window.setFlags(16777216, 16777216);
            setCancelable(true);
            setCanceledOnTouchOutside(true);
            initUI();
        }

        public static String N(long j3) {
            return O(j3, false);
        }

        public static String O(long j3, boolean z16) {
            boolean is24HourFormat = DateFormat.is24HourFormat(BaseApplication.getContext());
            long currentTimeMillis = System.currentTimeMillis() + j3;
            if (!is24HourFormat && !z16) {
                String format = new SimpleDateFormat("hh:mm").format(new Date(currentTimeMillis));
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(currentTimeMillis);
                if (calendar.get(9) == 0) {
                    return HardCodeUtil.qqStr(R.string.ot8) + format;
                }
                return HardCodeUtil.qqStr(R.string.otg) + format;
            }
            return new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR).format(new Date(currentTimeMillis));
        }

        private void initUI() {
            View view = this.E;
            if (view == null) {
                return;
            }
            TimeWheelPanel timeWheelPanel = (TimeWheelPanel) view.findViewById(R.id.fi6);
            this.D = timeWheelPanel;
            timeWheelPanel.h(0, 24, 60, 0);
            this.D.e(true);
            this.D.setViewVisibility(0, 8);
            this.D.setViewVisibility(3, 0);
            this.D.setScrollerStateListener(this);
            TextView textView = (TextView) this.E.findViewById(R.id.f164723ap3);
            TextView textView2 = (TextView) this.E.findViewById(R.id.b7v);
            this.F = textView2;
            textView2.setTextColor(getContext().getResources().getColor(R.color.skin_color_button_white));
            textView.setClickable(true);
            this.F.setClickable(true);
            textView.setOnClickListener(this);
            this.F.setOnClickListener(this);
            textView.setFocusable(true);
            this.F.setFocusable(true);
            this.F.setEnabled(false);
            this.F.setTextColor(getContext().getResources().getColor(R.color.ais));
            if (this.C != null) {
                String qqStr = HardCodeUtil.qqStr(R.string.j6l);
                String qqStr2 = HardCodeUtil.qqStr(R.string.ot6);
                textView.setContentDescription(qqStr);
                this.F.setContentDescription(qqStr2);
            }
            i(null, null);
            setOnCancelListener(this);
        }

        public void P(AtomicBoolean atomicBoolean) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) atomicBoolean);
            } else {
                this.I = atomicBoolean;
            }
        }

        public void Q(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, j3);
                return;
            }
            if (((((int) j3) % 86400) % 3600) % 60 != 0) {
                j3 += 60;
            }
            TimeWheelPanel timeWheelPanel = this.D;
            int i3 = (int) j3;
            timeWheelPanel.E = i3 / 86400;
            int i16 = i3 % 86400;
            timeWheelPanel.F = i16 / 3600;
            timeWheelPanel.G = (i16 % 3600) / 60;
            timeWheelPanel.setValues(true);
            this.D.setEndTime(HardCodeUtil.qqStr(R.string.f172248ot3) + N(this.D.g() * 1000), HardCodeUtil.qqStr(R.string.f172248ot3) + O(this.D.g() * 1000, true));
        }

        @Override // com.tencent.mobileqq.app.utils.TimeWheelPanel.b
        public void i(NumberWheelView numberWheelView, VerticalGallery verticalGallery) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) numberWheelView, (Object) verticalGallery);
                return;
            }
            if (numberWheelView != null) {
                this.J = true;
            }
            if (this.D.g() == 0) {
                this.F.setEnabled(false);
                this.F.setTextColor(getContext().getResources().getColor(R.color.ais));
            } else if (this.J) {
                this.F.setEnabled(true);
                this.F.setTextColor(getContext().getResources().getColor(R.color.ak_));
            }
            this.D.setEndTime(HardCodeUtil.qqStr(R.string.f172248ot3) + N(this.D.g() * 1000), HardCodeUtil.qqStr(R.string.f172248ot3) + O(this.D.g() * 1000, true));
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) dialogInterface);
            } else {
                this.D.h(0, 24, 60, 0);
                i(null, null);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            } else {
                int id5 = view.getId();
                if (id5 == R.id.f164723ap3) {
                    dismiss();
                    onCancel(null);
                } else if (id5 == R.id.b7v) {
                    dismiss();
                    long g16 = this.D.g() / 60;
                    String str = HardCodeUtil.qqStr(R.string.f172248ot3) + N(this.D.g() * 1000);
                    a aVar = this.G;
                    if (aVar != null) {
                        aVar.a(str);
                    }
                    this.I.set(true);
                    ((CardHandler) this.H.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).W4((int) (NetConnInfoCenter.getServerTime() + this.D.g()), "", "not_disturb_from_notify_push_setting_activity");
                    this.D.h(0, 24, 60, 0);
                    i(null, null);
                    ReportController.o(this.H, "CliOper", "", "", "0X8009DD2", "0X8009DD2", 0, 1, g16 + "", "0", "", "");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) dialogInterface);
            } else {
                this.J = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class m {
        static IPatchRedirector $redirector_;

        private static void a(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("param_action", str);
            QQBeaconReport.report("", "turn_off_disturb_mode_dialog", hashMap);
        }

        public static void b() {
            a("click");
        }

        public static void c() {
            a("show");
        }
    }

    public NotifyPushSettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.D = "";
        this.U = new AtomicBoolean(false);
        this.V = false;
        this.W = true;
        this.X = true;
        this.Y = false;
        this.Z = false;
        this.f286960a0 = false;
        this.f286961b0 = com.tencent.mobileqq.qdispatchqueue.d.a("NotifyPushSetting");
        this.f286962c0 = new e();
        this.f286964e0 = new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotifyPushSettingFragment.this.yi(view);
            }
        };
        this.f286965f0 = 0;
        this.f286966g0 = 0L;
        this.f286967h0 = new IKernelSettingListener() { // from class: com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NotifyPushSettingFragment.this);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
            public /* synthetic */ void onBufferSettingChanged(HashMap hashMap) {
                bp.a(this, hashMap);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
            public /* synthetic */ void onCleanCacheProgressChanged(int i3, int i16) {
                bp.b(this, i3, i16);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
            public /* synthetic */ void onNumSettingChanged(HashMap hashMap) {
                bp.c(this, hashMap);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
            public /* synthetic */ void onPrivacySettingChanged(PrivacySetting privacySetting) {
                bp.d(this, privacySetting);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
            public void onStrSettingChanged(HashMap<SettingKeyForStr, String> hashMap) {
                int i3;
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) hashMap);
                    return;
                }
                SettingKeyForStr settingKeyForStr = SettingKeyForStr.KWXMSGNOTIFYINFO;
                if (hashMap.containsKey(settingKeyForStr)) {
                    QLog.d("IphoneTitleBarFragment", 1, "WeChatMsgAgent kernelSettingService container wxInfo");
                    String str2 = hashMap.get(settingKeyForStr);
                    QLog.d("IphoneTitleBarFragment", 1, "WeChatMsgAgent kernelSettingService onStrSettingChanged, json content" + str2);
                    if (str2 != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            if (jSONObject.has("status")) {
                                i3 = jSONObject.getInt("status");
                            } else {
                                i3 = 0;
                            }
                            if (jSONObject.has("nick")) {
                                str = jSONObject.getString("nick");
                            } else {
                                str = null;
                            }
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable(str2, i3, str) { // from class: com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.3.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ String f286974d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ int f286975e;

                                /* renamed from: f, reason: collision with root package name */
                                final /* synthetic */ String f286976f;

                                {
                                    this.f286974d = str2;
                                    this.f286975e = i3;
                                    this.f286976f = str;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, this, AnonymousClass3.this, str2, Integer.valueOf(i3), str);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    QLog.d("IphoneTitleBarFragment", 1, "WeChatMsgAgent kernelSettingService onStrSettingChanged, json result" + this.f286974d);
                                    NotifyPushSettingFragment.this.f286965f0 = this.f286975e;
                                    NotifyPushSettingFragment.this.bj(this.f286975e, this.f286976f);
                                }
                            });
                        } catch (Exception e16) {
                            QLog.d("IphoneTitleBarFragment", 1, "WeChatMsgAgent kernelSettingService onStrSettingChanged, json fail " + e16);
                        }
                    }
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
            public /* synthetic */ void onVerifyInfoChange(int i3) {
                bp.f(this, i3);
            }
        };
        this.f286968i0 = new j();
        this.f286969j0 = new a();
        this.f286970k0 = new MqqWeakReferenceHandler(new b());
        this.f286971l0 = new c();
        this.f286972m0 = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bi(DialogInterface dialogInterface, int i3) {
        m.b();
        int netWorkType = HttpUtil.getNetWorkType();
        if (netWorkType == -1) {
            netWorkType = 2;
        }
        if (netWorkType == 0) {
            QQToast.makeText(getBaseActivity(), 1, R.string.dqp, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        if (this.U.compareAndSet(true, true)) {
            QQToast.makeText(getBaseActivity(), 1, R.string.f3c, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        Ui(false, true);
        String V = this.E.V();
        this.E.f0("");
        this.U.set(true);
        ((CardHandler) this.C.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).W4(0, V, "not_disturb_from_notify_push_setting_activity");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ci() {
        return this.P.O().getIsChecked();
    }

    private void Di() {
        com.tencent.mobileqq.wechatMsgAgent.a aVar = (com.tencent.mobileqq.wechatMsgAgent.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("105418");
        if (aVar == null) {
            QLog.d("IphoneTitleBarFragment", 1, "WeChatMsgAgent WeChatAgentConfigData null");
            return;
        }
        if (!aVar.f315066d) {
            QLog.d("IphoneTitleBarFragment", 1, "WeChatMsgAgent WeChatAgentConfigData close");
        }
        aVar.f315068f.length();
        try {
            String str = "weixin://biz/qq/msghelper/";
            if (aVar.f315067e.length() > 0) {
                str = aVar.f315067e;
            }
            Uri parse = Uri.parse(str);
            QLog.d("IphoneTitleBarFragment", 1, "WeChatMsgAgent open url " + parse);
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.addFlags(335544320);
            intent.setData(parse);
            startActivity(intent);
            QLog.d("IphoneTitleBarFragment", 1, "WeChatMsgAgent open schema " + str);
        } catch (Exception e16) {
            QLog.d("IphoneTitleBarFragment", 1, "WeChatMsgAgent open api error" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ei(boolean z16, boolean z17) {
        int netWorkType = HttpUtil.getNetWorkType();
        if (netWorkType == -1) {
            netWorkType = 2;
        }
        if (netWorkType == 0) {
            QQToast.makeText(getBaseActivity(), 1, R.string.dqp, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            Ui(!z16, false);
            return;
        }
        Ui(z16, true);
        if (z16) {
            this.E.f0(HardCodeUtil.qqStr(R.string.f172248ot3) + l.N(3600000L));
            this.U.set(true);
            ((CardHandler) this.C.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).W4((int) (NetConnInfoCenter.getServerTime() + 3600), "", "not_disturb_from_notify_push_setting_activity");
        } else {
            String V = this.E.V();
            this.U.set(true);
            ((CardHandler) this.C.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).W4(0, V, "not_disturb_from_notify_push_setting_activity");
        }
        if (z17) {
            QQToast.makeText(getBaseActivity(), 0, R.string.f171532o0, 0).show(getBaseActivity().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
        ao.a(this.C, "0X800B849", z16);
        Ni("em_bas_not_disturb_mode", z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fi(boolean z16) {
        if (z16) {
            if (!this.K.Y()) {
                Ri("em_bas_top_message_alert_switch", Boolean.valueOf(this.K.W()));
            }
            this.K.h0(0);
            if (!this.Z) {
                this.Z = true;
                ReportController.y(this.C, "0X800B7E1");
            }
        } else {
            this.K.h0(8);
        }
        if (ForegroundNotifyManager.b(this.C).v()) {
            this.K.h0(8);
        }
        SettingCloneUtil.writeValue(this.C.getApp(), this.C.getCurrentUin(), (String) null, AppConstants.NEW_MSG_NOTIFICATION_KEY, z16);
        com.tencent.mobileqq.pushnotice.c.f(z16);
        ao.a(this.C, "0X800B844", z16);
        Ni("em_bas_new_message_notification_switch", z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Gi(String str) {
        boolean readValue = SettingCloneUtil.readValue((Context) getBaseActivity(), str, (String) null, AppConstants.QQSETTING_PCACTIVE_KEY, false);
        this.V = true;
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar = this.H;
        if (bVar != null) {
            bVar.a0(readValue);
        }
        this.V = false;
    }

    private void Hi() {
        IKernelSettingService settingService = ((IKernelService) this.C.getRuntimeService(IKernelService.class, "")).getSettingService();
        if (settingService == null) {
            QLog.d("IphoneTitleBarFragment", 1, "kernelSettingService register, settingService is null");
            return;
        }
        this.f286966g0 = Long.valueOf(settingService.addKernelSettingListener(this.f286967h0));
        QLog.d("IphoneTitleBarFragment", 1, "kernelSettingService register suc id" + this.f286966g0);
        ArrayList<SettingKeyForStr> arrayList = new ArrayList<>();
        arrayList.add(SettingKeyForStr.KWXMSGNOTIFYINFO);
        settingService.getSettingForStr(arrayList, new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Ii(String str, Map<String, String> map) {
        com.tencent.qqnt.notification.report.h.h("pg_bas_message_notification", str, null, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Ji(String str) {
        com.tencent.qqnt.notification.report.h.k("pg_bas_message_notification", str);
    }

    private static void Ki(String str, Map<String, String> map) {
        com.tencent.qqnt.notification.report.h.l("pg_bas_message_notification", str, map, map);
    }

    private void Li() {
        ReportController.y(this.C, "0X800B7E0");
        ReportController.y(this.C, "0X800B7E2");
        ReportController.y(this.C, "0X800B7E4");
        ReportController.y(this.C, "0X800B7E7");
        ReportController.y(this.C, "0X800B7E8");
        ReportController.y(this.C, "0X800B7EA");
        if (!this.Z && this.K.Y()) {
            this.Z = true;
            ReportController.y(this.C, "0X800B7E1");
        }
        ABTestController.getInstance().getExpEntity("exp_qq_notification_unsub_reconfirm").reportExpExposure();
    }

    public static void Mi(final QQAppInterface qQAppInterface, final String str) {
        qQAppInterface.execute(new Runnable() { // from class: com.tencent.mobileqq.settings.message.z
            @Override // java.lang.Runnable
            public final void run() {
                NotifyPushSettingFragment.zi(QQAppInterface.this, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Ni(String str, boolean z16) {
        com.tencent.qqnt.notification.report.h.w("pg_bas_message_notification", str, Boolean.valueOf(z16));
    }

    private static void Oi(String str, boolean z16, Map<String, String> map) {
        com.tencent.qqnt.notification.report.h.y("pg_bas_message_notification", str, Boolean.valueOf(z16), null, map);
    }

    private static void Pi(String str) {
        com.tencent.qqnt.notification.report.h.w("pg_bas_message_notification", str, null);
    }

    private static void Qi(String str) {
        com.tencent.qqnt.notification.report.h.B("pg_bas_message_notification", str, null);
    }

    private static void Ri(String str, Boolean bool) {
        com.tencent.qqnt.notification.report.h.B("pg_bas_message_notification", str, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Si(String str, Boolean bool, Map<String, String> map) {
        com.tencent.qqnt.notification.report.h.C("pg_bas_message_notification", str, bool, null, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Ti(com.tencent.mobileqq.activity.newsetting.custom.config.b<?, ?> bVar) {
        bVar.a0(!bVar.W());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ui(boolean z16, boolean z17) {
        this.P.O().f(null);
        this.P.O().e(z16);
        this.P.O().f(this.f286962c0);
        int i3 = 0;
        if (z17) {
            if (z16) {
                this.E.h0(0);
                if (!this.f286960a0) {
                    this.f286960a0 = true;
                    ReportController.y(this.C, "0X800B7E6");
                }
            } else {
                this.E.h0(8);
            }
        } else if (z16) {
            this.E.h0(0);
            if (!this.f286960a0) {
                this.f286960a0 = true;
                ReportController.y(this.C, "0X800B7E6");
            }
        } else {
            this.E.h0(8);
        }
        this.Y = z16;
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar = this.K;
        if (!this.J.W()) {
            i3 = 8;
        }
        bVar.h0(i3);
        aj();
        ForegroundNotifyManager foregroundNotifyManager = this.T;
        if (foregroundNotifyManager != null && foregroundNotifyManager.v()) {
            this.K.h0(8);
        }
    }

    private void Vi(boolean z16) {
        this.J.t(!z16);
        this.K.t(!z16);
        this.I.t(!z16);
    }

    private void Wi(int i3, boolean z16) {
        this.P.p(z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void Xh(String str) {
        Ji(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xi(View view) {
        if (!Ci()) {
            return;
        }
        DialogUtil.createCustomDialog(getBaseActivity(), 230).setMessage(R.string.f170922mc).setPositiveButton(R.string.zsf, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.ag
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                NotifyPushSettingFragment.this.Bi(dialogInterface, i3);
            }
        }).setNegativeButton(R.string.f241727sn, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.ah
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                NotifyPushSettingFragment.Ai(dialogInterface, i3);
            }
        }).show();
        m.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Yi() {
        if (Ci()) {
            Xi(((IphoneTitleBarFragment) this).mContentView);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zi(boolean z16) {
        if (z16) {
            this.N.h0(0);
        } else {
            this.N.h0(8);
        }
    }

    private void aj() {
        if (!this.S.b()) {
            Vi(false);
        } else {
            Vi(!this.Y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(int i3, String str) {
        com.tencent.mobileqq.activity.newsetting.business.group.notify.a j3 = this.f286963d0.j();
        if (j3 == null) {
            QLog.d("IphoneTitleBarFragment", 1, "WeChatMsgAgent update null new group");
            return;
        }
        com.tencent.mobileqq.widget.listitem.c n3 = j3.n();
        this.L = n3;
        if (n3 != null) {
            if (i3 != 0 && i3 != 2) {
                if (i3 == 1) {
                    if (str != null && str.length() > 0) {
                        j3.q(getString(R.string.f174912x5, di(str, 6)));
                    } else {
                        j3.q(getString(R.string.f174902x4));
                    }
                    this.L.p(true);
                    return;
                }
                return;
            }
            j3.q(getString(R.string.f174902x4));
            this.L.p(true);
        }
    }

    private void ci() {
        IKernelSettingService settingService = ((IKernelService) this.C.getRuntimeService(IKernelService.class, "")).getSettingService();
        if (settingService == null) {
            QLog.d("IphoneTitleBarFragment", 1, "kernelSettingService unregister, settingService is null");
        } else {
            settingService.removeKernelSettingListener(this.f286966g0.longValue());
            QLog.d("IphoneTitleBarFragment", 1, "kernelSettingService unregister sucess");
        }
    }

    public static String di(String str, int i3) {
        if (str.length() > i3) {
            return str.substring(0, i3 - 3) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return str;
    }

    public static int ei(Context context, String str, String str2) {
        return context.getSharedPreferences("mobileQQ", 0).getInt(str + str2, 0);
    }

    private void fi() {
        boolean j3 = AVUtil.j(this.C.getCurrentAccountUin());
        this.I = this.f286963d0.j().j();
        Ri("em_bas_voice_and_video_call_alerts", Boolean.valueOf(j3));
        this.I.h0(0);
        this.I.a0(j3);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.settings.message.ae
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                NotifyPushSettingFragment.this.ti(compoundButton, z16);
            }
        };
        this.Q = onCheckedChangeListener;
        this.I.e0(onCheckedChangeListener);
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar = this.I;
        bVar.x(new k(bVar, this.Q));
    }

    private void gi() {
        BounceScrollView bounceScrollView;
        if (!needBlur() || this.quiSecNavBar == null) {
            return;
        }
        BounceScrollView bounceScrollView2 = (BounceScrollView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.adr);
        NotifyPushSettingView notifyPushSettingView = this.f286963d0;
        QUISettingsRecyclerView e16 = notifyPushSettingView.e(notifyPushSettingView);
        e16.setClipToPadding(false);
        int b16 = com.tencent.biz.qui.quisecnavbar.e.b(((IphoneTitleBarFragment) this).mContentView.getContext());
        e16.setPadding(0, b16, 0, 0);
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

    private void hi() {
        int i3;
        String currentUin = this.C.getCurrentUin();
        boolean readValue = SettingCloneUtil.readValue((Context) BaseApplication.getContext(), currentUin, getString(R.string.f173079h50), AppConstants.QQSETTING_NOTIFY_SHOWCONTENT_KEY, true);
        this.M = this.f286963d0.j().l();
        this.N = this.f286963d0.j().k();
        this.M.a0(readValue);
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar = this.N;
        if (this.M.W()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        bVar.h0(i3);
        Ri("em_bas_notification_message_preview_switch", Boolean.valueOf(this.M.W()));
        this.M.e0(new h(currentUin));
        boolean readValue2 = SettingCloneUtil.readValue((Context) BaseApplication.getContext(), currentUin, getString(R.string.f171097c62), AppConstants.QQSETTING_LOCKSCREENMSG_WHENEXIST_KEY, true);
        this.N.a0(readValue2);
        if (qi()) {
            this.N.a0(false);
            this.N.h0(8);
        } else {
            Zi(readValue);
            Ri("em_bas_message_lock_screen", Boolean.valueOf(readValue2));
        }
        this.N.e0(new i(currentUin));
    }

    private void ii() {
        this.P = ((MsgNotifySettingView) this.f286963d0).n().j();
        if (ea.P1(getBaseActivity(), "open_don_disturb", this.D) != 1 && !FriendsStatusUtil.c(getBaseActivity())) {
            Wi(8, false);
            this.E.h0(8);
        } else {
            Wi(0, true);
            this.E.h0(0);
            if (!this.f286960a0) {
                this.f286960a0 = true;
                ReportController.y(this.C, "0X800B7E6");
            }
            Ri("em_bas_not_disturb_mode", Boolean.valueOf(Ci()));
            if (FriendsStatusUtil.c(getBaseActivity())) {
                String V = this.E.V();
                HashMap hashMap = new HashMap();
                hashMap.put("finalTime", V);
                Si("em_bas_not_disturb_time", Boolean.valueOf(this.E.W()), hashMap);
            }
            ReportController.y(this.C, "0X800B7E5");
        }
        boolean c16 = FriendsStatusUtil.c(getBaseActivity());
        this.Y = c16;
        Ui(c16, false);
    }

    private void ji() {
        this.F = ((MsgNotifySettingView) this.f286963d0).n().m();
        Qi("em_bas_vibrating_switch");
        this.F.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.af
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotifyPushSettingFragment.this.ui(view);
            }
        });
    }

    private void ki() {
        com.tencent.mobileqq.activity.newsetting.custom.config.b l3 = ((MsgNotifySettingView) this.f286963d0).n().l();
        Qi("em_bas_sound");
        l3.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotifyPushSettingFragment.this.vi(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(String str) {
        ((MsgNotifySettingView) this.f286963d0).n().k().f0(str);
    }

    private void li() {
        boolean g16 = this.S.g();
        this.J = this.f286963d0.j().m();
        Ri("em_bas_new_message_notification_switch", Boolean.valueOf(g16));
        this.J.a0(g16);
        this.J.e0(this.f286968i0);
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar = this.J;
        bVar.x(new k(bVar, this.f286968i0));
        Intent intent = requireActivity().getIntent();
        if (intent != null && intent.getBooleanExtra("auto_open_interval_msg_switch", false)) {
            this.J.a0(true);
            com.tencent.mobileqq.app.msgnotify.a.f196345a.r();
            QQToast.makeText(getContext(), 0, "\u6d88\u606f\u63a8\u9001\u5df2\u5f00\u542f", 0).show();
        }
    }

    private void mi() {
        com.tencent.mobileqq.activity.newsetting.custom.config.b k3 = ((MsgNotifySettingView) this.f286963d0).n().k();
        this.E = k3;
        k3.x(this.f286964e0);
    }

    private void ni() {
        int i3;
        com.tencent.mobileqq.activity.newsetting.custom.config.b j3 = this.f286963d0.k().j();
        this.K = j3;
        j3.x(new k(j3, this.f286972m0));
        if (this.J.W()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        this.K.h0(i3);
        ForegroundNotifyManager foregroundNotifyManager = this.T;
        if (foregroundNotifyManager != null) {
            this.K.a0(foregroundNotifyManager.D());
            this.K.e0(this.f286972m0);
            if (this.T.v()) {
                this.K.h0(8);
            }
        }
        if (i3 == 0) {
            Ri("em_bas_top_message_alert_switch", Boolean.valueOf(this.K.W()));
        }
    }

    private void oi() {
        this.f286963d0 = (NotifyPushSettingView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.zgb);
        li();
        ni();
        hi();
        fi();
        ki();
        ji();
        mi();
        ii();
        pi();
        gi();
    }

    private void pi() {
        Hi();
        final com.tencent.mobileqq.activity.newsetting.business.group.notify.a j3 = this.f286963d0.j();
        int i3 = 1;
        if (j3 == null) {
            QLog.d("IphoneTitleBarFragment", 1, "WeChatMsgAgent new WeChatAgentConfigData null");
            return;
        }
        com.tencent.mobileqq.widget.listitem.c n3 = j3.n();
        this.L = n3;
        if (n3 != null) {
            HashMap hashMap = new HashMap();
            if (this.f286965f0 == 0) {
                i3 = 0;
            }
            hashMap.put("message_assistant_status", String.valueOf(i3));
            Ki("em_bas_message_assistant_entry", hashMap);
            final boolean isShowWechatGuildSettingItemRedDot = ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).isShowWechatGuildSettingItemRedDot();
            if (this.L.O() instanceof c.b.C8995c) {
                ((c.b.C8995c) this.L.O()).e(isShowWechatGuildSettingItemRedDot);
            }
            if (isShowWechatGuildSettingItemRedDot) {
                this.L.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.settings.message.ac
                    @Override // com.tencent.mobileqq.widget.listitem.g
                    public final void M(View view) {
                        NotifyPushSettingFragment.wi(view);
                    }
                });
            }
            this.L.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.ad
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NotifyPushSettingFragment.this.xi(isShowWechatGuildSettingItemRedDot, j3, view);
                }
            });
        }
    }

    public static boolean qi() {
        return new File(Environment.getRootDirectory() + "/etc/permissions", "com.lenovo.keyguard.xml").exists();
    }

    public static boolean ri() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        if (waitAppRuntime instanceof QQAppInterface) {
            return SettingCloneUtil.readValue((Context) BaseApplication.getContext(), ((QQAppInterface) waitAppRuntime).getCurrentUin(), "\u901a\u77e5\u663e\u793a\u6d88\u606f\u5185\u5bb9", AppConstants.QQSETTING_NOTIFY_SHOWCONTENT_KEY, true);
        }
        return false;
    }

    public static boolean si() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        if (!(waitAppRuntime instanceof QQAppInterface)) {
            return false;
        }
        int P1 = ea.P1(BaseApplication.getContext(), "open_don_disturb", ((QQAppInterface) waitAppRuntime).getCurrentUin());
        boolean c16 = FriendsStatusUtil.c(BaseApplication.getContext());
        if (P1 != 1 && !c16) {
            return false;
        }
        return FriendsStatusUtil.c(BaseApplication.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ti(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (QLog.isColorLevel()) {
            QLog.d("IphoneTitleBarFragment", 2, "avCallOnCheckedChangeListener: invoked. ", " isChecked:", Boolean.valueOf(z16));
        }
        if (Yi()) {
            Ti(this.I);
        } else if (!this.S.b()) {
            this.S.o(getBaseActivity());
            this.I.e0(null);
            com.tencent.mobileqq.activity.newsetting.custom.config.b bVar = this.I;
            bVar.a0(true ^ bVar.W());
            this.I.e0(this.Q);
        } else {
            AVUtil.s(this.C.getCurrentAccountUin(), z16);
            ao.a(this.C, "0X800B846", z16);
            Ni("em_bas_voice_and_video_call_alerts", z16);
            if (QLog.isColorLevel()) {
                QLog.d("IphoneTitleBarFragment", 2, "isChecked[" + z16 + "]");
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ui(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Pi("em_bas_vibrating_switch");
        PublicFragmentActivity.start(getBaseActivity(), VibrateNewFragment.class);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void vi(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Pi("em_bas_sound");
        ((ISettingApi) QRoute.api(ISettingApi.class)).startSoundAndVibratePage(getBaseActivity(), new Intent());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void wi(View view) {
        ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).report(IWeChatGuildApi.BIZ_TYPE_WX.SETTING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xi(boolean z16, com.tencent.mobileqq.activity.newsetting.business.group.notify.a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int i3 = 0;
        if (z16) {
            ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).reportClik(IWeChatGuildApi.BIZ_TYPE_WX.SETTING);
            if (this.L.O() instanceof c.b.C8995c) {
                ((c.b.C8995c) this.L.O()).e(false);
                aVar.p();
            }
            ((ConfigHandler) this.C.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).z3(Boolean.FALSE);
        }
        HashMap hashMap = new HashMap();
        if (this.f286965f0 != 0) {
            i3 = 1;
        }
        hashMap.put("message_assistant_status", String.valueOf(i3));
        Ii("em_bas_message_assistant_entry", hashMap);
        Di();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yi(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ReportController.y(this.C, "0X800B84A");
        if (this.R == null) {
            ((MsgNotifySettingView) this.f286963d0).n().k();
            l lVar = new l(getBaseActivity(), this.C, new l.a() { // from class: com.tencent.mobileqq.settings.message.aa
                @Override // com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.l.a
                public final void a(String str) {
                    NotifyPushSettingFragment.this.lambda$new$0(str);
                }
            });
            this.R = lVar;
            lVar.P(this.U);
            HashMap hashMap = new HashMap();
            hashMap.put("disturb_time", this.E.V());
            Oi("em_bas_not_disturb_time", this.E.W(), hashMap);
        }
        if (this.Y) {
            this.R.Q(SettingCloneUtil.readValueForInt(getBaseActivity().getApplicationContext(), null, AppConstants.Preferences.NO_DISTURB_MODE, AppConstants.QQSETTING_NODISTURB_MODE_KEY, Integer.MAX_VALUE) - ((int) NetConnInfoCenter.getServerTime()));
        }
        this.R.show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void zi(QQAppInterface qQAppInterface, String str) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        String str2;
        if (QLog.isDevelopLevel()) {
            QLog.i("ReportController", 4, "reportSettingStatusDaily run");
        }
        HashMap hashMap = new HashMap();
        if (qQAppInterface.getALLGeneralSettingVibrate() == 1) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        hashMap.put("Clk_notice_shake", Integer.valueOf(i3));
        if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingVibrate(qQAppInterface) == 1) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        hashMap.put("Clk_notice_grpshake", Integer.valueOf(i16));
        if (qQAppInterface.getALLGeneralSettingRing() == 1) {
            i17 = 1;
        } else {
            i17 = 0;
        }
        hashMap.put("Clk_notice_sound", Integer.valueOf(i17));
        if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingRing(qQAppInterface) == 1) {
            i18 = 1;
        } else {
            i18 = 0;
        }
        hashMap.put("Clk_notice_gupsound", Integer.valueOf(i18));
        hashMap.put("Clk_night_mode", Integer.valueOf(FriendsStatusUtil.c(qQAppInterface.getApp()) ? 1 : 0));
        hashMap.put("Clk_hide_text", Integer.valueOf(qQAppInterface.isShowMsgContent() ? 1 : 0));
        hashMap.put("Led_blinking", Integer.valueOf(SettingCloneUtil.readValue((Context) qQAppInterface.getApp(), str, qQAppInterface.getApp().getString(R.string.h4s), AppConstants.QQSETTING_NOTIFY_BLNCONTROL_KEY, true) ? 1 : 0));
        if (QZoneSwitchProcessor.a(str) > 0) {
            i19 = 1;
        } else {
            i19 = 0;
        }
        hashMap.put("Clk_about_me", Integer.valueOf(i19));
        try {
            for (String str3 : hashMap.keySet()) {
                ReportController.o(qQAppInterface, "CliStatus", "", "", "Setting_tab", str3, 0, 0, String.valueOf(hashMap.get(str3)), "", "", "");
            }
        } catch (Exception e16) {
            QLog.e("NotifyPushSettingFragment", 1, "reportSettingStatusDaily", e16);
        }
        if (SettingCloneUtil.readValue((Context) qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin(), (String) null, AppConstants.QQSETTING_PCACTIVE_KEY, false)) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        ReportController.o(qQAppInterface, "CliStatus", "", "", "0X8004971", "0X8004971", 0, 0, str2, "", "", "");
    }

    public boolean bi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        boolean areNotificationsEnabled = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplication.getContext());
        if (QLog.isColorLevel()) {
            QLog.d("IphoneTitleBarFragment", 2, "systemNotificationEnabled: invoked. ", " enable: ", Boolean.valueOf(areNotificationsEnabled));
        }
        return areNotificationsEnabled;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        setTitle(getResources().getString(R.string.f225746mg));
        com.tencent.qqnt.notification.report.h.o("pg_bas_message_notification");
        QQAppInterface qQAppInterface = this.C;
        if (qQAppInterface != null) {
            this.D = qQAppInterface.getCurrentAccountUin();
            this.S = com.tencent.mobileqq.message.newmsg.a.d(this.C);
            this.T = ForegroundNotifyManager.b(this.C);
        }
        oi();
        QQAppInterface qQAppInterface2 = this.C;
        if (qQAppInterface2 != null) {
            qQAppInterface2.addObserver(this.f286969j0, true);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
        intentFilter.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive");
        getBaseActivity().registerReceiver(this.f286971l0, intentFilter);
        aj();
        Li();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.gyz;
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public boolean needBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
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

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
            this.C = (QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = this.C;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f286969j0);
            if (BadgeUtils.j(this.C.getApplication())) {
                BadgeUtils.d();
            }
        }
        this.S.n();
        this.T.w();
        ci();
        getBaseActivity().unregisterReceiver(this.f286971l0);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            super.onDestroyView();
            com.tencent.qqnt.notification.report.h.s("pg_bas_message_notification");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onPause();
        this.C.getApp().sendBroadcast(new Intent("tencent.notify.activity.setting"), "com.tencent.msg.permission.pushnotify");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onResume();
        if (this.Y) {
            this.E.f0(HardCodeUtil.qqStr(R.string.f172248ot3) + l.N((SettingCloneUtil.readValueForInt(getBaseActivity().getApplicationContext(), null, AppConstants.Preferences.NO_DISTURB_MODE, AppConstants.QQSETTING_NODISTURB_MODE_KEY, Integer.MAX_VALUE) - ((int) NetConnInfoCenter.getServerTime())) * 1000));
        }
        aj();
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ai(DialogInterface dialogInterface, int i3) {
    }
}
