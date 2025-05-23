package com.tencent.mobileqq.chat.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.newsetting.business.view.c2c.MessageNotifySettingView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasWebUrl;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupWxNotifyStatusRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupWxNotifyStatus;
import com.tencent.qqnt.kernel.nativeinterface.GroupWxNotifyStatusItem;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupWxNotifyStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.PrivacySetting;
import com.tencent.qqnt.kernel.nativeinterface.RelationFlag;
import com.tencent.qqnt.kernel.nativeinterface.SettingKeyForStr;
import com.tencent.qqnt.kernel.nativeinterface.StatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.be;
import com.tencent.qqnt.kernel.nativeinterface.bp;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.qqnt.troop.i;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MessageNotificationSettingFragment extends IphoneTitleBarFragment implements MessageNotificationSettingManager.c {
    static IPatchRedirector $redirector_;
    private ar C;
    private QQAppInterface D;
    private FriendListHandler E;
    private String F;
    private String G;
    private int H;
    private FriendsManager I;
    private MessageNotificationSettingManager J;
    private TroopManager K;
    private MessageNotifySettingView L;
    private com.tencent.mobileqq.activity.newsetting.business.group.c2c.message.b M;
    private com.tencent.mobileqq.activity.newsetting.business.group.c2c.message.c N;
    private com.tencent.mobileqq.activity.newsetting.business.group.c2c.message.d P;
    private com.tencent.mobileqq.activity.newsetting.business.group.c2c.message.a Q;
    private com.tencent.mobileqq.activity.newsetting.business.group.c2c.message.e R;
    private com.tencent.mobileqq.activity.newsetting.business.group.c2c.message.f S;
    private CompoundButton.OnCheckedChangeListener T;
    private CompoundButton.OnCheckedChangeListener U;
    private CompoundButton.OnCheckedChangeListener V;
    private CompoundButton.OnCheckedChangeListener W;
    private CompoundButton.OnCheckedChangeListener X;
    private long Y;
    private IKernelProfileListener Z;

    /* renamed from: a0, reason: collision with root package name */
    private IKernelSettingListener f201257a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f201258b0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements IOperateCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MessageNotificationSettingFragment.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent groupService, modifyWxNotifyStatus " + MessageNotificationSettingFragment.this.G, "result" + i3, "errMsg" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b extends ar {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MessageNotificationSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetMessageNotification(boolean z16, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), objArr);
                return;
            }
            QLog.d("MessageNotificationSettingFragment", 2, "onSetMessageNotification: invoked. ", " isSuccess: ", Boolean.valueOf(z16), " data: " + objArr);
            if (z16 && objArr != null && objArr.length == 3) {
                String[] strArr = (String[]) objArr[0];
                boolean[] zArr = (boolean[]) objArr[1];
                if (strArr != null && strArr.length >= 1 && zArr != null && zArr.length >= 1) {
                    String str = strArr[0];
                    boolean z17 = zArr[0];
                    ((Integer) objArr[2]).intValue();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c implements hx3.b<com.tencent.qqnt.ntrelation.otherinfo.bean.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f201277a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f201278b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f201279c;

        c(String str, boolean z16, boolean z17) {
            this.f201277a = str;
            this.f201278b = z16;
            this.f201279c = z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MessageNotificationSettingFragment.this, str, Boolean.valueOf(z16), Boolean.valueOf(z17));
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.a> eVar) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
                MessageNotificationSettingFragment.this.E.setMessageNotificationSetting(3, new String[]{this.f201277a}, new boolean[]{this.f201278b}, new com.tencent.qqnt.ntrelation.otherinfo.bean.a[]{eVar.b().get(0)});
                if (this.f201279c) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                ReportController.o(null, "dc00898", "", "", "0X800A3CA", "0X800A3CA", i3, 0, "", "", "", "");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MessageNotificationSettingFragment", 2, "[handleVibrate]: info is null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class d implements hx3.b<com.tencent.qqnt.ntrelation.otherinfo.bean.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f201281a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f201282b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f201283c;

        d(String str, boolean z16, boolean z17) {
            this.f201281a = str;
            this.f201282b = z16;
            this.f201283c = z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MessageNotificationSettingFragment.this, str, Boolean.valueOf(z16), Boolean.valueOf(z17));
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.a> eVar) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
                MessageNotificationSettingFragment.this.E.setMessageNotificationSetting(2, new String[]{this.f201281a}, new boolean[]{this.f201282b}, new com.tencent.qqnt.ntrelation.otherinfo.bean.a[]{eVar.b().get(0)});
                if (this.f201283c) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                ReportController.o(null, "dc00898", "", "", "0X800A3C9", "0X800A3C9", i3, 0, "", "", "", "");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MessageNotificationSettingFragment", 2, "[handleSound]: info is null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class e implements hx3.b<com.tencent.qqnt.ntrelation.otherinfo.bean.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f201285a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f201286b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f201287c;

        e(String str, boolean z16, boolean z17) {
            this.f201285a = str;
            this.f201286b = z16;
            this.f201287c = z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MessageNotificationSettingFragment.this, str, Boolean.valueOf(z16), Boolean.valueOf(z17));
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.a> eVar) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
                MessageNotificationSettingFragment.this.E.setMessageNotificationSetting(1, new String[]{this.f201285a}, new boolean[]{this.f201286b}, new com.tencent.qqnt.ntrelation.otherinfo.bean.a[]{eVar.b().get(0)});
                if (this.f201287c) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                ReportController.o(null, "dc00898", "", "", "0X800A3C8", "0X800A3C8", i3, 0, "", "", "", "");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MessageNotificationSettingFragment", 2, "[handlePreview]: info is null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class f implements IOperateCallback {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MessageNotificationSettingFragment.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            } else {
                QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent kernelSettingService, result: ", Integer.valueOf(i3), " errMsg: ", str);
            }
        }
    }

    public MessageNotificationSettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.T = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.chat.ui.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                MessageNotificationSettingFragment.this.ci(compoundButton, z16);
            }
        };
        this.U = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.chat.ui.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                MessageNotificationSettingFragment.this.di(compoundButton, z16);
            }
        };
        this.V = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.chat.ui.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                MessageNotificationSettingFragment.this.ei(compoundButton, z16);
            }
        };
        this.W = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.chat.ui.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                MessageNotificationSettingFragment.this.fi(compoundButton, z16);
            }
        };
        this.X = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.chat.ui.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                MessageNotificationSettingFragment.this.gi(compoundButton, z16);
            }
        };
        this.Y = 0L;
        this.Z = new IKernelProfileListener() { // from class: com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MessageNotificationSettingFragment.this);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
            public void onProfileSimpleChanged(HashMap<String, UserSimpleInfo> hashMap) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) hashMap);
                    return;
                }
                if (hashMap.containsKey(MessageNotificationSettingFragment.this.G)) {
                    UserSimpleInfo userSimpleInfo = hashMap.get(MessageNotificationSettingFragment.this.G);
                    if (userSimpleInfo == null) {
                        QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent onProfileSimpleChanged fail kernel info null");
                        return;
                    }
                    if (userSimpleInfo.relationFlags == null) {
                        QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent onProfileSimpleChanged fail kernel relationFlags null");
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable(userSimpleInfo, !r2.getWxMsgNotifyClosed()) { // from class: com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment.6.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ UserSimpleInfo f201265d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ boolean f201266e;

                            {
                                this.f201265d = userSimpleInfo;
                                this.f201266e = r7;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, this, AnonymousClass6.this, userSimpleInfo, Boolean.valueOf(r7));
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (MessageNotificationSettingFragment.this.S == null) {
                                    QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent onProfileSimpleChanged fail");
                                    return;
                                }
                                QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent profileService , getWxNotifyStatus" + this.f201265d);
                                com.tencent.mobileqq.activity.newsetting.custom.config.b j3 = MessageNotificationSettingFragment.this.S.j();
                                if (j3 != null && j3.W() != this.f201266e) {
                                    j3.h0(8);
                                    j3.e0(null);
                                    j3.a0(this.f201266e);
                                    j3.e0(MessageNotificationSettingFragment.this.X);
                                }
                            }
                        });
                    }
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
            public /* synthetic */ void onSelfStatusChanged(StatusInfo statusInfo) {
                be.b(this, statusInfo);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
            public /* synthetic */ void onStatusAsyncFieldUpdate(HashMap hashMap) {
                be.c(this, hashMap);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
            public /* synthetic */ void onStatusUpdate(HashMap hashMap) {
                be.d(this, hashMap);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
            public /* synthetic */ void onStrangerRemarkChanged(HashMap hashMap) {
                be.e(this, hashMap);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
            public /* synthetic */ void onUserDetailInfoChanged(UserDetailInfo userDetailInfo) {
                be.f(this, userDetailInfo);
            }
        };
        this.f201257a0 = new IKernelSettingListener() { // from class: com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MessageNotificationSettingFragment.this);
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
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) hashMap);
                    return;
                }
                SettingKeyForStr settingKeyForStr = SettingKeyForStr.KWXMSGNOTIFYINFO;
                if (hashMap.containsKey(settingKeyForStr)) {
                    QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent kernelSettingService container wxInfo");
                    String str = hashMap.get(settingKeyForStr);
                    QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent kernelSettingService onStrSettingChanged, json content" + str);
                    if (str != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("status")) {
                                i3 = jSONObject.getInt("status");
                            } else {
                                i3 = 0;
                            }
                            if (jSONObject.has("nick")) {
                                jSONObject.getString("nick");
                            } else {
                                MessageNotificationSettingFragment.this.getString(R.string.f174902x4);
                            }
                            QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent kernelSettingService onStrSettingChanged, json result" + str);
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable(i3) { // from class: com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment.8.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ int f201273d;

                                {
                                    this.f201273d = i3;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this, i3);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    if (MessageNotificationSettingFragment.this.S == null) {
                                        QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent kernelSettingService onStrSettingChanged, null msgWeChatAgentGroup");
                                        return;
                                    }
                                    com.tencent.mobileqq.activity.newsetting.custom.config.b j3 = MessageNotificationSettingFragment.this.S.j();
                                    if (j3 == null) {
                                        QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent kernelSettingService onStrSettingChanged, null mWeChatMsgAgentConfig");
                                        return;
                                    }
                                    if (MessageNotificationSettingFragment.this.Yh()) {
                                        j3.h0(8);
                                        QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent kernelSettingService onStrSettingChanged, isRobotUin mWeChatMsgAgentConfig");
                                        return;
                                    }
                                    int i16 = this.f201273d;
                                    if (i16 == 0) {
                                        j3.h0(8);
                                    } else if (i16 == 1) {
                                        j3.h0(0);
                                    } else if (i16 == 2) {
                                        j3.h0(8);
                                    }
                                    MessageNotificationSettingFragment.this.f201258b0--;
                                    if (MessageNotificationSettingFragment.this.f201258b0 == 0) {
                                        MessageNotificationSettingFragment.this.pi();
                                    }
                                }
                            });
                        } catch (Exception e16) {
                            QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent kernelSettingService onStrSettingChanged, json fail" + e16);
                        }
                    }
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
            public /* synthetic */ void onVerifyInfoChange(int i3) {
                bp.f(this, i3);
            }
        };
        this.f201258b0 = 2;
    }

    private void Hh() {
        b bVar = new b();
        this.C = bVar;
        this.D.addObserver(bVar);
        this.J.V(this);
    }

    private void Ih() {
        y profileService = ((IKernelService) this.D.getRuntimeService(IKernelService.class, "")).getProfileService();
        if (profileService == null) {
            QLog.d("MessageNotificationSettingFragment", 1, "IProfileService register, profileService is null");
        } else {
            profileService.D0(this.Z);
            QLog.d("MessageNotificationSettingFragment", 1, "IProfileService unregister success");
        }
    }

    private void Jh() {
        IKernelSettingService settingService = ((IKernelService) this.D.getRuntimeService(IKernelService.class, "")).getSettingService();
        if (settingService == null) {
            QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent kernelSettingService unregister, settingService is null");
        } else {
            settingService.removeKernelSettingListener(this.Y);
            QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent kernelSettingService unregister sucess");
        }
    }

    private void Kh() {
        int i3 = this.H;
        if (i3 == 1) {
            Jh();
            return;
        }
        if (i3 == 0) {
            if (Yh()) {
                QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent isRobotUin null unregister");
            } else {
                Jh();
                Ih();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh(boolean z16, int i3, int i16) {
        QLog.i("MessageNotificationSettingFragment", 1, "[handSetGroupMsgMaskV2_4Result]isSuccess:" + z16 + ",op:" + i3 + ",type:" + Integer.toHexString(i16));
        if (z16) {
            this.J.U(this.F, i3, i16);
        }
    }

    private void Mh(CompoundButton compoundButton, boolean z16, String str, boolean z17, boolean z18, int i3, int i16) {
        IKernelBuddyService buddyService = ((IKernelService) this.D.getRuntimeService(IKernelService.class, "")).getWrapperSession().getBuddyService();
        if (buddyService == null) {
            QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent buddyService get fail, buddyService is null");
        } else if (TextUtils.isEmpty(this.G)) {
            QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent null uid fail");
        } else {
            buddyService.setWXMsgNotify("chatSettingFragment", this.G, !z16, new IOperateCallback() { // from class: com.tencent.mobileqq.chat.ui.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i17, String str2) {
                    MessageNotificationSettingFragment.this.Zh(i17, str2);
                }
            });
        }
    }

    private void Nh() {
        String buildTraceDetailUrl = com.tencent.mobileqq.vip.api.e.a().buildTraceDetailUrl(((IVasWebUrl) QRoute.api(IVasWebUrl.class)).getUrl("call"), IVipTraceDetailReport.FROM.FUN_CALL_SETTING);
        com.tencent.qqnt.notification.report.h.g("pg_bas_msg_push_set", "em_bas_ring_tone");
        if (this.H == 0) {
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(getContext(), buildTraceDetailUrl + "&friend=" + this.F);
            return;
        }
        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(getContext(), buildTraceDetailUrl);
    }

    private void Oh(CompoundButton compoundButton, boolean z16, String str, boolean z17, boolean z18, int i3, int i16) {
        IKernelGroupService groupService = ((IKernelService) this.D.getRuntimeService(IKernelService.class, "")).getWrapperSession().getGroupService();
        if (groupService == null) {
            QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent groupService get fail, groupService is null");
            return;
        }
        GroupWxNotifyStatus groupWxNotifyStatus = GroupWxNotifyStatus.KDISABLE;
        if (z16) {
            groupWxNotifyStatus = GroupWxNotifyStatus.KENABLE;
        }
        groupService.modifyWxNotifyStatus(Long.parseLong(str), groupWxNotifyStatus, new a());
    }

    private void Ph(CompoundButton compoundButton, boolean z16, String str, boolean z17, boolean z18, int i3, int i16) {
        int i17 = 1;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            notifyUser(R.string.b3j, 1);
            this.M.j().e0(null);
            this.M.j().a0(!compoundButton.isChecked());
            this.M.j().e0(this.V);
            return;
        }
        if (z18) {
            qi(i3, 1024, i16);
            if (!z16) {
                i17 = 2;
            }
            ReportController.o(null, "dc00898", "", "", "0X800A3CB", "0X800A3CB", i17, 0, "", "", "", "");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).getOtherInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "MessageNotificationSettingFragment", new e(str, z17, z16));
    }

    private void Qh(CompoundButton compoundButton, boolean z16, String str, boolean z17, boolean z18, int i3, int i16) {
        int i17 = 1;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            notifyUser(R.string.b3j, 1);
            this.N.j().e0(null);
            this.N.j().a0(!compoundButton.isChecked());
            this.N.j().e0(this.U);
            return;
        }
        if (z16) {
            this.P.j().h0(0);
            this.Q.j().h0(0);
        } else {
            this.P.j().h0(8);
            this.Q.j().h0(8);
        }
        if (z18) {
            qi(i3, 2048, i16);
            if (!z16) {
                i17 = 2;
            }
            ReportController.o(null, "dc00898", "", "", "0X800A3CC", "0X800A3CC", i17, 0, "", "", "", "");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).getOtherInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "MessageNotificationSettingFragment", new d(str, z17, z16));
    }

    private void Rh() {
        String str;
        int i3 = this.H;
        boolean z16 = true;
        if (i3 == 0) {
            ReportController.o(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 1, 0, "", "", "", "");
            VasWebviewUtil.reportCommercialDrainage(this.D.getCurrentAccountUin(), "bell", "C2C_click", "", 1, 0, 0, "", "", "");
        } else if (i3 == 1) {
            ReportController.o(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 3, 0, "", "", "", "");
            VasWebviewUtil.reportCommercialDrainage(this.D.getCurrentAccountUin(), "bell", "group_click", "", 1, 0, 0, "", "", "");
        }
        Intent intent = new Intent(getBaseActivity(), (Class<?>) QQBrowserActivity.class);
        String url = IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.SPECIALCARE_MALL_URL);
        if (this.H != 1) {
            z16 = false;
        }
        if (z16) {
            str = "3";
        } else {
            str = "2";
        }
        String buildTraceDetailUrl = com.tencent.mobileqq.vip.api.e.a().buildTraceDetailUrl(url.replace("[uid]", this.F).replace("[lType]", str), IVipTraceDetailReport.FROM.SPECIALCARE_MALL_C2C_NOTIFICATION);
        intent.putExtra("url", buildTraceDetailUrl);
        startActivity(intent);
        VasLogReporter.getNotificationSound().report("open SoundShop url : " + buildTraceDetailUrl, VasLogReportProxy.LEVEL.HIGHEST);
    }

    private void Sh(com.tencent.mobileqq.activity.newsetting.custom.group.a aVar, CompoundButton compoundButton, boolean z16) {
        boolean z17 = true;
        if (this.H != 1) {
            z17 = false;
        }
        boolean z18 = z17;
        int serverTime = (int) NetConnInfoCenter.getServerTime();
        if (aVar instanceof com.tencent.mobileqq.activity.newsetting.business.group.c2c.message.b) {
            Ph(compoundButton, z16, this.F, z16, z18, z16 ? 1 : 0, serverTime);
            return;
        }
        if (aVar instanceof com.tencent.mobileqq.activity.newsetting.business.group.c2c.message.c) {
            Qh(compoundButton, z16, this.F, z16, z18, z16 ? 1 : 0, serverTime);
        } else if (aVar instanceof com.tencent.mobileqq.activity.newsetting.business.group.c2c.message.e) {
            Th(compoundButton, z16, this.F, z16, z18, z16 ? 1 : 0, serverTime);
        } else if (aVar instanceof com.tencent.mobileqq.activity.newsetting.business.group.c2c.message.f) {
            Uh(compoundButton, z16, this.F, z16, z18, z16 ? 1 : 0, serverTime);
        }
    }

    private void Th(CompoundButton compoundButton, boolean z16, String str, boolean z17, boolean z18, int i3, int i16) {
        int i17 = 1;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            notifyUser(R.string.b3j, 1);
            this.R.j().e0(null);
            this.R.j().a0(!compoundButton.isChecked());
            this.R.j().e0(this.W);
            return;
        }
        if (z18) {
            qi(i3, 4096, i16);
            if (!z16) {
                i17 = 2;
            }
            ReportController.o(null, "dc00898", "", "", "0X800A3CD", "0X800A3CD", i17, 0, "", "", "", "");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).getOtherInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "MessageNotificationSettingFragment", new c(str, z17, z16));
    }

    private void Uh(CompoundButton compoundButton, boolean z16, String str, boolean z17, boolean z18, int i3, int i16) {
        String str2;
        String str3;
        int i17 = this.H;
        if (i17 == 1) {
            Oh(compoundButton, z16, this.F, z16, z18, i3, i16);
        } else if (i17 == 0) {
            Mh(compoundButton, z16, this.F, z16, z18, i3, i16);
        }
        HashMap hashMap = new HashMap();
        if (this.H == 1) {
            str2 = "grp";
        } else {
            str2 = "clt";
        }
        hashMap.put("aio_type", str2);
        if (z16) {
            str3 = "2";
        } else {
            str3 = "1";
        }
        hashMap.put("after_click_state", str3);
        String str4 = this.F;
        if (str4 == null) {
            str4 = "";
        }
        hashMap.put("touin", str4);
        com.tencent.qqnt.notification.report.h.h("pg_bas_msg_push_set", "em_bas_message_assistant_entry", hashMap, hashMap);
    }

    private void Vh() {
        boolean z16;
        boolean z17;
        boolean z18 = true;
        ExtensionInfo I = this.I.I(this.F, true);
        if (I == null) {
            QLog.d("MessageNotificationSettingFragment", 1, "initViews: invoked. ", " extensionInfo: ", I);
            return;
        }
        com.tencent.mobileqq.activity.newsetting.custom.config.b j3 = this.M.j();
        if (I.messageEnablePreviewNew == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        j3.a0(z16);
        com.tencent.mobileqq.activity.newsetting.custom.config.b j16 = this.N.j();
        if (I.messageEnableSoundNew == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        j16.a0(z17);
        com.tencent.mobileqq.activity.newsetting.custom.config.b j17 = this.R.j();
        if (I.messageEnableVibrateNew != 0) {
            z18 = false;
        }
        j17.a0(z18);
        if (I.messageEnableSoundNew == 0) {
            this.P.j().h0(0);
            this.Q.j().h0(0);
            com.tencent.qqnt.notification.report.h.k("pg_bas_msg_push_set", "em_bas_ring_tone");
        } else {
            this.P.j().h0(8);
            this.Q.j().h0(8);
        }
    }

    private void Wh() {
        TroopInfo k3 = this.K.k(this.F);
        if (k3 == null) {
            QLog.d("MessageNotificationSettingFragment", 1, "initViews: invoked. ", " troopInfo: ", k3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessageNotificationSettingFragment", 2, "initViews: invoked. ", " troopInfo.cmdUinFlagEx2: ", Long.valueOf(k3.cmdUinFlagEx2));
        }
        this.M.j().a0(ii(k3));
        this.N.j().a0(ji(k3));
        this.R.j().a0(ki(k3));
        if (ji(k3)) {
            this.P.j().h0(0);
            this.Q.j().h0(0);
            com.tencent.qqnt.notification.report.h.k("pg_bas_msg_push_set", "em_bas_ring_tone");
        } else {
            this.P.j().h0(8);
            this.Q.j().h0(8);
        }
    }

    private void Xh() {
        com.tencent.mobileqq.activity.newsetting.business.group.c2c.message.f fVar = this.S;
        if (fVar == null) {
            QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent initWeChatMsgAgentConfig fail");
            return;
        }
        com.tencent.mobileqq.activity.newsetting.custom.config.b j3 = fVar.j();
        if (j3 == null) {
            QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent initWeChatMsgAgentConfig fail");
            return;
        }
        j3.h0(8);
        if (TextUtils.isEmpty(this.G)) {
            QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent null uid fail");
            return;
        }
        int i3 = this.H;
        if (i3 == 1) {
            j3.a0(false);
            j3.e0(this.X);
            this.S.h(getString(R.string.f174932x7));
            return;
        }
        if (i3 == 0) {
            if (Yh()) {
                j3.h0(8);
                return;
            }
            this.S.h(getString(R.string.f174922x6));
            y profileService = ((IKernelService) this.D.getRuntimeService(IKernelService.class, "")).getProfileService();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(this.G);
            HashMap<String, RelationFlag> relationFlag = profileService.getRelationFlag("", arrayList);
            if (relationFlag.containsKey(this.G)) {
                if (relationFlag.get(this.G) != null) {
                    j3.a0(!r1.getWxMsgNotifyClosed());
                } else {
                    QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent onProfileSimpleChanged fail kernel relationFlags null");
                }
            }
            j3.e0(this.X);
            int i16 = this.f201258b0 - 1;
            this.f201258b0 = i16;
            if (i16 == 0) {
                pi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Yh() {
        if (this.D != null && !TextUtils.isEmpty(this.F)) {
            return ((ITroopRobotService) this.D.getRuntimeService(ITroopRobotService.class, "")).isRobotUin(this.F);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Zh(int i3, String str) {
        QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent buddyService, setWXMsgNotify " + this.G, "result" + i3, "errMsg" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ai(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Rh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bi(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Nh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ci(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Sh(this.M, compoundButton, z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void di(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Sh(this.N, compoundButton, z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ei(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Sh(this.P, compoundButton, z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void fi(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Sh(this.R, compoundButton, z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gi(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        com.tencent.mobileqq.activity.newsetting.business.group.c2c.message.f fVar = this.S;
        if (fVar != null) {
            Sh(fVar, compoundButton, z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    public static void hi(Activity activity, Intent intent) {
        PublicFragmentActivity.start(activity, intent, MessageNotificationSettingFragment.class);
    }

    private boolean ii(TroopInfo troopInfo) {
        if (troopInfo == null) {
            return true;
        }
        return !TroopInfo.isCmdUinFlagEx2Open(troopInfo.cmdUinFlagEx2, 1024);
    }

    private void initData() {
        Intent intent = getBaseActivity().getIntent();
        if (intent != null) {
            this.F = intent.getStringExtra("uin");
            this.G = intent.getStringExtra(AppConstants.Key.UID);
            this.H = intent.getIntExtra("uintype", -1);
            if (this.G == null && !TextUtils.isEmpty(this.F)) {
                if (this.H == 1) {
                    this.G = this.F;
                } else {
                    this.G = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.F);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("MessageNotificationSettingFragment", 2, "initData . ", " mUin: " + this.F, " mUinType: " + this.H);
        }
        TextUtils.isEmpty(this.F);
        this.J.f(this.F, this.H);
        int i3 = this.H;
        if (i3 == 0) {
            ReportController.o(null, "dc00898", "", "", "0X800A3C7", "0X800A3C7", 1, 0, "", "", "", "");
        } else if (i3 == 1) {
            ReportController.o(null, "dc00898", "", "", "0X800A3C7", "0X800A3C7", 2, 0, "", "", "", "");
        }
        oi();
    }

    private void initViews() {
        String str;
        HashMap hashMap = new HashMap();
        if (this.H == 1) {
            str = "grp";
        } else {
            str = "clt";
        }
        hashMap.put("aio_type", str);
        String str2 = this.F;
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("touin", str2);
        com.tencent.qqnt.notification.report.h.p("pg_bas_msg_push_set", hashMap);
        MessageNotifySettingView messageNotifySettingView = (MessageNotifySettingView) $(R.id.z5j);
        this.L = messageNotifySettingView;
        this.M = messageNotifySettingView.k();
        this.N = this.L.l();
        this.P = this.L.m();
        this.Q = this.L.j();
        this.R = this.L.n();
        this.S = this.L.p();
        this.M.j().e0(this.T);
        this.N.j().e0(this.U);
        this.P.j().g0(new View.OnClickListener() { // from class: com.tencent.mobileqq.chat.ui.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageNotificationSettingFragment.this.ai(view);
            }
        });
        this.Q.j().g0(new View.OnClickListener() { // from class: com.tencent.mobileqq.chat.ui.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageNotificationSettingFragment.this.bi(view);
            }
        });
        this.R.j().e0(this.W);
        setTitle(getString(R.string.f235197b0));
        int i3 = this.H;
        if (i3 == 0) {
            Vh();
        } else if (i3 == 1) {
            Wh();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.R.j().h0(8);
        }
        int i16 = this.H;
        if (i16 == 0) {
            VasWebviewUtil.reportCommercialDrainage(this.D.getCurrentAccountUin(), "bell", "C2C_show", "", 1, 0, 0, "", "", "");
        } else if (i16 == 1) {
            VasWebviewUtil.reportCommercialDrainage(this.D.getCurrentAccountUin(), "bell", "group_show", "", 1, 0, 0, "", "", "");
        }
        Xh();
    }

    private boolean ji(TroopInfo troopInfo) {
        if (troopInfo == null) {
            return true;
        }
        return !TroopInfo.isCmdUinFlagEx2Open(troopInfo.cmdUinFlagEx2, 2048);
    }

    private boolean ki(TroopInfo troopInfo) {
        if (troopInfo == null) {
            return true;
        }
        return !TroopInfo.isCmdUinFlagEx2Open(troopInfo.cmdUinFlagEx2, 4096);
    }

    private void li() {
        IKernelGroupService groupService = ((IKernelService) this.D.getRuntimeService(IKernelService.class, "")).getWrapperSession().getGroupService();
        if (groupService == null) {
            QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent groupService get fail, groupService is null");
            return;
        }
        long parseLong = Long.parseLong(this.F);
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(parseLong));
        groupService.getWxNotifyStatus(arrayList, new IGetGroupWxNotifyStatusCallback(parseLong) { // from class: com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment.7
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f201268a;

            {
                this.f201268a = parseLong;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, MessageNotificationSettingFragment.this, Long.valueOf(parseLong));
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupWxNotifyStatusCallback
            public void onResult(int i3, String str, GetGroupWxNotifyStatusRsp getGroupWxNotifyStatusRsp) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, getGroupWxNotifyStatusRsp);
                    return;
                }
                QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent groupService , getWxNotifyStatus" + i3, "errMsg" + str, "rsp" + getGroupWxNotifyStatusRsp);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(getGroupWxNotifyStatusRsp) { // from class: com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment.7.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ GetGroupWxNotifyStatusRsp f201270d;

                    {
                        this.f201270d = getGroupWxNotifyStatusRsp;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this, (Object) getGroupWxNotifyStatusRsp);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (MessageNotificationSettingFragment.this.S == null) {
                            QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent groupService , msgWeChatAgentGroup null");
                            return;
                        }
                        com.tencent.mobileqq.activity.newsetting.custom.config.b j3 = MessageNotificationSettingFragment.this.S.j();
                        if (j3 == null) {
                            QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent groupService , mWeChatMsgAgentConfig null");
                            return;
                        }
                        j3.e0(null);
                        Iterator<GroupWxNotifyStatusItem> it = this.f201270d.items.iterator();
                        while (it.hasNext()) {
                            GroupWxNotifyStatusItem next = it.next();
                            if (next.groupCode == AnonymousClass7.this.f201268a) {
                                if (next.getStatus() == GroupWxNotifyStatus.KENABLE) {
                                    j3.a0(true);
                                } else {
                                    j3.a0(false);
                                }
                            }
                        }
                        j3.e0(MessageNotificationSettingFragment.this.X);
                        MessageNotificationSettingFragment.this.f201258b0--;
                        if (MessageNotificationSettingFragment.this.f201258b0 == 0) {
                            MessageNotificationSettingFragment.this.pi();
                        }
                    }
                });
            }
        });
    }

    private void mi() {
        IKernelSettingService settingService = ((IKernelService) this.D.getRuntimeService(IKernelService.class, "")).getSettingService();
        if (settingService == null) {
            QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent kernelSettingService register, settingService is null");
            return;
        }
        this.Y = settingService.addKernelSettingListener(this.f201257a0);
        QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent kernelSettingService register suc id" + this.Y);
        ArrayList<SettingKeyForStr> arrayList = new ArrayList<>();
        arrayList.add(SettingKeyForStr.KWXMSGNOTIFYINFO);
        settingService.getSettingForStr(arrayList, new f());
    }

    private void ni() {
        y profileService = ((IKernelService) this.D.getRuntimeService(IKernelService.class, "")).getProfileService();
        if (profileService == null) {
            QLog.d("MessageNotificationSettingFragment", 1, "IProfileService register, profileService is null");
        } else {
            profileService.r0(this.Z);
        }
    }

    private void notifyUser(int i3, int i16) {
        QQToast.makeText(BaseApplication.getContext(), i16, i3, 0).show();
    }

    private void oi() {
        int i3 = this.H;
        if (i3 == 1) {
            mi();
            li();
        } else if (i3 == 0) {
            if (Yh()) {
                QLog.d("MessageNotificationSettingFragment", 1, "WeChatMsgAgent isRobotUin null register");
            } else {
                mi();
                ni();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi() {
        String str;
        String str2;
        com.tencent.mobileqq.activity.newsetting.custom.config.b j3 = this.S.j();
        if (j3 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (this.H == 1) {
            str = "grp";
        } else {
            str = "clt";
        }
        hashMap.put("aio_type", str);
        if (j3.W()) {
            str2 = "2";
        } else {
            str2 = "1";
        }
        hashMap.put("after_click_state", str2);
        String str3 = this.F;
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("touin", str3);
        com.tencent.qqnt.notification.report.h.l("pg_bas_msg_push_set", "em_bas_message_assistant_entry", hashMap, hashMap);
    }

    private void qi(int i3, int i16, int i17) {
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).setGroupMsgMaskV2_4(this.F, this.D.getCurrentUid(), i3, i16, i17, this, new i(i3, i16) { // from class: com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment.3
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f201259a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f201260b;

            {
                this.f201259a = i3;
                this.f201260b = i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, MessageNotificationSettingFragment.this, Integer.valueOf(i3), Integer.valueOf(i16));
                }
            }

            @Override // com.tencent.qqnt.troop.i
            public void onResult(boolean z16, int i18, @NonNull String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i18), str);
                } else {
                    ThreadManager.getUIHandler().post(new Runnable(z16) { // from class: com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment.3.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f201262d;

                        {
                            this.f201262d = z16;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass3.this, Boolean.valueOf(z16));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                MessageNotificationSettingFragment.this.Lh(this.f201262d, anonymousClass3.f201259a, anonymousClass3.f201260b);
                            }
                        }
                    });
                }
            }
        });
    }

    protected final <T extends View> T $(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        return (T) ((IphoneTitleBarFragment) this).mContentView.findViewById(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.fol;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        HashMap hashMap = new HashMap();
        if (this.H == 1) {
            str = "grp";
        } else {
            str = "clt";
        }
        hashMap.put("aio_type", str);
        String str2 = this.F;
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("touin", str2);
        com.tencent.qqnt.notification.report.h.t("pg_bas_msg_push_set", hashMap);
        Kh();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroyView();
        this.D.removeObserver(this.C);
        this.J.P(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        int i16 = this.H;
        if (i16 == 0) {
            int a16 = com.tencent.mobileqq.notification.util.a.a(this.F);
            QLog.i("MessageNotificationSettingFragment", 1, "onResume friendRingId is " + a16);
            String v3 = this.J.v(a16, this.F, this.H);
            this.P.j().f0(v3);
            this.P.j().c0(getString(R.string.im6) + v3);
            QLog.i("MessageNotificationSettingFragment", 1, "init sound config,uin:" + this.F + ",ringId:" + a16 + "ringName:" + v3);
            QQAppInterface qQAppInterface = this.D;
            this.Q.j().f0(VipFunCallUtil.getFunCallName(this.D, VipFunCallUtil.getResIdByUin(qQAppInterface, qQAppInterface.getAccount(), 6, false, this.F)));
            com.tencent.mobileqq.activity.newsetting.custom.config.b j3 = this.Q.j();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u6765\u7535\u94c3\u58f0");
            sb5.append(v3);
            j3.c0(sb5.toString());
            return;
        }
        if (i16 == 1) {
            TroopInfo k3 = this.K.k(this.F);
            if (k3 == null) {
                QLog.d("MessageNotificationSettingFragment", 1, "onResume: invoked. ", " troopInfo: ", k3);
                i3 = 0;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("MessageNotificationSettingFragment", 2, "onResume: invoked. ", " troopInfo.cmdUinFlagEx2: ", Long.valueOf(k3.cmdUinFlagEx2));
                }
                i3 = (int) k3.udwCmdUinRingtoneID;
            }
            String v16 = this.J.v(i3, null, -1);
            this.P.j().f0(v16);
            this.P.j().c0(getString(R.string.im6) + v16);
            QLog.i("MessageNotificationSettingFragment", 1, "init sound config,uin:" + this.F + ",ringId:" + i3 + "ringName:" + v16);
            QQAppInterface qQAppInterface2 = this.D;
            this.Q.j().f0(VipFunCallUtil.getFunCallName(this.D, VipFunCallUtil.getResIdByUin(qQAppInterface2, qQAppInterface2.getAccount(), 6, false, this.D.getAccount())));
            com.tencent.mobileqq.activity.newsetting.custom.config.b j16 = this.Q.j();
            StringBuilder sb6 = new StringBuilder();
            sb6.append("\u6765\u7535\u94c3\u58f0");
            sb6.append(v16);
            j16.c0(sb6.toString());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        super.onViewCreated(view, bundle);
        QQAppInterface qQAppInterface = getBaseActivity().app;
        this.D = qQAppInterface;
        this.E = (FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        this.I = (FriendsManager) this.D.getManager(QQManagerFactory.FRIENDS_MANAGER);
        this.K = (TroopManager) this.D.getManager(QQManagerFactory.TROOP_MANAGER);
        this.J = MessageNotificationSettingManager.l(this.D);
        initData();
        initViews();
        Hh();
    }

    @Override // com.tencent.mobileqq.chat.MessageNotificationSettingManager.c
    public void r8(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        QLog.i("MessageNotificationSettingFragment", 1, "onRingDownloaded ringId is " + i3);
        String v3 = this.J.v(i3, this.F, this.H);
        this.P.j().f0(v3);
        this.P.j().c0(getString(R.string.im6) + v3);
    }
}
