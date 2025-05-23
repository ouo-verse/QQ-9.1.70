package com.tencent.mobileqq.forward;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardD55Manager;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.feed.api.GuildShareParamUtil;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.guild.util.IGuildFeedsHomeJumpApi;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.report.OpenSdkShareReporterProxy;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import common.config.service.QzoneConfig;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.api.ProcessConstant;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$ImageInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$ReqBody;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardSdkShareOption extends ForwardSdkBaseOption implements al {
    static IPatchRedirector $redirector_;

    /* renamed from: c0, reason: collision with root package name */
    private static final String f210836c0;
    private boolean T;
    private boolean U;
    private long V;
    private ForwardMultServerShare W;
    private final b.a X;
    private ForwardD55Manager.a Y;

    @SuppressLint({"HandlerLeak"})
    private Handler Z;

    /* renamed from: a0, reason: collision with root package name */
    protected com.tencent.biz.common.util.i f210837a0;

    /* renamed from: b0, reason: collision with root package name */
    protected QQCustomDialog f210838b0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.forward.ForwardSdkShareOption$7, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass7 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f210854d;
        final /* synthetic */ ForwardSdkShareOption this$0;

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            OpenID R0 = this.this$0.app.getMsgCache().R0(this.f210854d);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("-->handleAccountDiff--readDb: ");
            if (R0 == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i("ForwardOption.ForwardSdkShareOption", 2, sb5.toString());
            Handler handler = this.this$0.f210822i;
            if (handler != null) {
                handler.sendEmptyMessage(1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkShareOption.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (ForwardSdkShareOption.this.isSdkShare) {
                ReportCenter.f().q(ForwardSdkShareOption.this.app.getAccount(), "", String.valueOf(ForwardSdkShareOption.this.appid), "1000", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE, "0", false, true);
            }
            Intent intent = new Intent();
            intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", Long.valueOf(ForwardSdkShareOption.this.appid), "addToQQFavorites")));
            intent.setPackage(ForwardSdkShareOption.this.mActivity.getIntent().getStringExtra("pkg_name"));
            PendingIntent activity = PendingIntent.getActivity(ForwardSdkShareOption.this.mActivity, 0, intent, 335544320);
            Intent intent2 = new Intent();
            intent2.putExtra(AppConstants.Key.SHARE_FLAG, true);
            if (ForwardSdkShareOption.this.appid > 0) {
                intent2.putExtra(AppConstants.Key.ACTIVITY_FINISH_RUN_PENDING_INTENT, activity);
            }
            ForwardSdkShareOption forwardSdkShareOption = ForwardSdkShareOption.this;
            QfavHelper.i(forwardSdkShareOption.mActivity, forwardSdkShareOption.app.getAccount(), intent2, -1, true);
            cooperation.qqfav.d.g(ForwardSdkShareOption.this.app, 2, 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkShareOption.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (ForwardSdkShareOption.this.isSdkShare) {
                ReportCenter.f().q(ForwardSdkShareOption.this.app.getAccount(), "", String.valueOf(ForwardSdkShareOption.this.appid), "1000", "51", "0", false, true);
            }
            ForwardSdkShareOption forwardSdkShareOption = ForwardSdkShareOption.this;
            ForwardSdkBaseOption.F(forwardSdkShareOption.mActivity, true, "addToQQFavorites", forwardSdkShareOption.f210818d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkShareOption.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            Activity activity = ForwardSdkShareOption.this.mActivity;
            if (activity instanceof DirectForwardActivity) {
                activity.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements ForwardD55Manager.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkShareOption.this);
            }
        }

        @Override // com.tencent.mobileqq.forward.ForwardD55Manager.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> mD55ResultListener onResult");
            ((u) ForwardSdkShareOption.this.app.getManager(QQManagerFactory.SDK_SHARE)).c().k(null);
            ForwardSdkShareOption.this.hideProgressDialog();
            ForwardSdkShareOption.this.preloadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f210859d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f210860e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f210861f;

        e(String str, String str2, String str3) {
            this.f210859d = str;
            this.f210860e = str2;
            this.f210861f = str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ForwardSdkShareOption.this, str, str2, str3);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bundle)).booleanValue();
            }
            if (!TextUtils.isEmpty(str)) {
                QLog.e("ForwardOption.ForwardSdkShareOption", 1, "onError msg =", str);
            }
            return super.onError(i3, str, bundle);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            ForwardStatisticsReporter.k("KEY_STAGE_2_IMAGE_B77", z16);
            if (bundle != null) {
                long j3 = bundle.getLong("0xb77_9_sendTime", -1L);
                QLog.d("ForwardOption.ForwardSdkShareOption", 1, "handleGetMessageState currentRequestTime =", Long.valueOf(ForwardSdkShareOption.this.V), ", sendStamp = ", Long.valueOf(j3));
                if (j3 == -1 || j3 != ForwardSdkShareOption.this.V) {
                    ForwardSdkShareOption.this.d0(ForwardSdkShareOption.f210836c0, this.f210859d);
                    return;
                }
            }
            ReportController.o(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + i3, "4", this.f210860e, this.f210861f);
            QLog.d("ForwardOption.ForwardSdkShareOption", 1, "\u5927\u56fe\u53d1\u9001\u6d88\u606f\u540e\u5ba2\u6237\u7aef\u6536\u5230\u56de\u8c03=0X8009C94, errorCode=", Integer.valueOf(i3), ", fileType=4, toType=", this.f210860e, ", title=", this.f210861f);
            if (i3 != 0 || bArr == null) {
                ForwardSdkShareOption.this.d0((String) ForwardUtils.b0(bArr)[2], this.f210859d);
            } else {
                ForwardSdkShareOption.this.d0("", this.f210859d);
            }
            ForwardSdkShareOption.this.sendMessageOnConfirm();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class f extends Handler {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkShareOption.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 == 0) {
                QQToast.makeText(ForwardSdkShareOption.this.mActivity, HardCodeUtil.qqStr(R.string.mqm), 0).show();
            } else if (1 == i3) {
                ForwardSdkShareOption.this.mActivity.setResult(-1);
                ForwardSdkShareOption.this.mActivity.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class g extends com.tencent.biz.common.util.i {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkShareOption.this);
            }
        }

        @Override // com.tencent.biz.common.util.i
        protected void a(boolean z16, OpenID openID) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), openID);
                return;
            }
            if (!ForwardSdkShareOption.this.mActivity.isFinishing()) {
                ForwardSdkShareOption forwardSdkShareOption = ForwardSdkShareOption.this;
                if (!forwardSdkShareOption.f210823m) {
                    forwardSdkShareOption.hideProgressDialog();
                    Handler handler = ForwardSdkShareOption.this.f210822i;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                    if (z16 && openID != null && openID.openID != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ForwardOption.ForwardSdkShareOption", 2, "openIdObserver success");
                        }
                        if (!openID.openID.equals(ForwardSdkShareOption.this.f210819e)) {
                            if (QLog.isColorLevel()) {
                                QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->onGetOpenId--openid doesn't equal current openid");
                            }
                            ForwardSdkShareOption.this.p0();
                            return;
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("ForwardOption.ForwardSdkShareOption", 2, "openIdObserver fail");
                    }
                    ForwardSdkShareOption.this.q0();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSdkShareOption.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            boolean z16;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 == 1) {
                ForwardSdkShareOption.this.q0();
                StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                QQAppInterface qQAppInterface = ForwardSdkShareOption.this.app;
                statisticCollector.reportActionCountCliOper(qQAppInterface, qQAppInterface.getAccount(), "", "multi_account", "click_next", 0, 1, 0);
                return;
            }
            if (i3 == 0) {
                Intent intent = ForwardSdkShareOption.this.mIntent;
                if (intent != null && intent.getBooleanExtra(AppConstants.Key.FORWARD_MINI_PROGRAM_ARK_FROM_SDK, false)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16 && ForwardSdkShareOption.b0()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    ForwardSdkShareOption forwardSdkShareOption = ForwardSdkShareOption.this;
                    ForwardSdkBaseOption.F(forwardSdkShareOption.mActivity, false, "shareToQQ", forwardSdkShareOption.f210818d);
                    ForwardSdkShareOption.this.mActivity.moveTaskToBack(true);
                }
                ForwardSdkShareOption.this.mActivity.setResult(0);
                StatisticCollector statisticCollector2 = StatisticCollector.getInstance(BaseApplication.getContext());
                QQAppInterface qQAppInterface2 = ForwardSdkShareOption.this.app;
                statisticCollector2.reportActionCountCliOper(qQAppInterface2, qQAppInterface2.getAccount(), "", "multi_account", "click_cancel", 0, 1, 0);
                ForwardSdkShareOption.this.mActivity.finish();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72202);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 42)) {
            redirector.redirect((short) 42);
        } else {
            f210836c0 = HardCodeUtil.qqStr(R.string.f172006mq0);
        }
    }

    public ForwardSdkShareOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this.V = -1L;
        this.Y = new d();
        this.Z = new f();
        this.f210837a0 = new g();
        this.f210838b0 = null;
        this.W = new ForwardMultServerShare(this.mExtraData);
        this.X = OpenSdkShareReporterProxy.e(this.mExtraData.getLong("req_share_id"));
    }

    private boolean N() {
        return !this.mExtraData.getBoolean(AppConstants.Key.FORWARD_MINI_PROGRAM_ARK_FROM_SDK);
    }

    private void O() {
        String valueOf = String.valueOf(this.f210818d);
        boolean z16 = true;
        if (!this.f210821h) {
            z16 = true ^ Y(valueOf);
        }
        if (z16) {
            q0();
        }
    }

    private boolean P() {
        this.f210818d = this.mExtraData.getLong("req_share_id");
        ForwardD55Manager c16 = ((u) this.app.getManager(QQManagerFactory.SDK_SHARE)).c();
        if (c16.h()) {
            QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> isForbid");
            D(c16.f(), true);
            return true;
        }
        if (c16.l()) {
            QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> usedCachedAppInfo");
            this.J = c16.d(this.f210818d);
            return false;
        }
        if (c16.g()) {
            QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> hasValidAppInfo");
            this.J = c16.e();
            l();
            return false;
        }
        QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> waiting d55 back");
        c16.k(this.Y);
        showProgressDialog(R.string.h5l);
        return true;
    }

    private boolean Q() {
        boolean z16;
        boolean z17;
        String string = this.mExtraData.getString("uin");
        int i3 = this.mExtraData.getInt("uintype");
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.k(string) && i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Intent f06 = f0();
        int intExtra = f06.getIntExtra("dataline_forward_type", -1);
        ArrayList parcelableArrayListExtra = f06.getParcelableArrayListExtra("fileinfo_array");
        ArrayList<String> stringArrayListExtra = f06.getStringArrayListExtra("dataline_forward_pathlist");
        if (intExtra == -1 && stringArrayListExtra == null && parcelableArrayListExtra == null) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z16 && z17) {
            return true;
        }
        return false;
    }

    private int R(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return 1;
        }
        if (arrayList.size() > 5) {
            if (QLog.isColorLevel()) {
                QLog.e(ProcessConstant.QQFAV, 2, "gotoQfavShareMsg|image type.more than 5");
            }
            return 3;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (QfavUtil.E(next, -1L)) {
                if (QLog.isColorLevel()) {
                    QLog.i(ProcessConstant.QQFAV, 2, "gotoQfavShareMsg|image type.picture too big [" + next + "]");
                }
                cooperation.qqfav.d.c(null, "Net_AddFav", 8, 3, -3);
                return 2;
            }
        }
        return 0;
    }

    private boolean S(AbsStructMsg absStructMsg) {
        List<AbsStructMsgElement> structMsgItemLists;
        if ((absStructMsg instanceof StructMsgForGeneralShare) && (structMsgItemLists = ((StructMsgForGeneralShare) absStructMsg).getStructMsgItemLists()) != null) {
            for (int i3 = 0; i3 < structMsgItemLists.size(); i3++) {
                AbsStructMsgElement absStructMsgElement = structMsgItemLists.get(i3);
                if (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.view.u) {
                    int i16 = ((com.tencent.mobileqq.structmsg.view.u) absStructMsgElement).R0;
                    if (i16 == 1 || i16 == 3) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    private SharePublishGuildFeedParam U(long j3, String str, String str2) {
        JSONObject jSONObject;
        if (GuildShareParamUtil.c(j3)) {
            String string = this.mExtraData.getString("title", "");
            String string2 = this.mExtraData.getString("desc", "");
            try {
                jSONObject = new JSONObject(this.mExtraData.getString("forward_ark_app_meta", "")).optJSONObject("detail_1");
            } catch (JSONException e16) {
                QLog.e("ForwardOption.ForwardSdkShareOption", 1, "forwardToGuildFeed error", e16);
                jSONObject = null;
            }
            if (jSONObject == null) {
                QLog.w("ForwardOption.ForwardSdkShareOption", 1, "forwardToGuildFeed metaDetail is null");
                return null;
            }
            String optString = jSONObject.optString("url");
            if (optString.startsWith("m.q.qq.com")) {
                optString = "https://" + optString;
            }
            return new SharePublishGuildFeedParam.ThirdVideoParam(str, string, string2, str2, optString, GuildShareParamUtil.b(j3));
        }
        return new SharePublishGuildFeedParam.LinkTypeParam(str2, str, this.mExtraData.getString("title", ""), this.mExtraData.getString("desc", ""));
    }

    private String X() {
        int i3;
        List<ResultRecord> multiTarget = getMultiTarget();
        if (multiTarget != null) {
            i3 = multiTarget.size();
        } else {
            i3 = 0;
        }
        return Integer.toString(i3);
    }

    private boolean Y(String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d("ForwardOption.ForwardSdkShareOption", 4, "handleAccountDiff appId: " + str + ", mShareUin: " + StringUtil.getSimpleUinForPrint(this.f210820f) + ", mShareOpenId: " + this.f210819e + ", mFromLogin: " + this.f210821h);
        }
        if (!TextUtils.isEmpty(this.f210820f) && !this.f210820f.equals(this.app.getAccount())) {
            QLog.i("ForwardOption.ForwardSdkShareOption", 1, "-->handleAccountDiff--share uin doesn't equal current uin: " + StringUtil.getSimpleUinForPrint(this.f210820f) + "," + StringUtil.getSimpleUinForPrint(this.app.getAccount()));
            p0();
            return true;
        }
        return false;
    }

    private boolean Z() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return false;
        }
        return activity.getSharedPreferences("mobileQQ", 0).getBoolean("favorites_first_share_" + this.app.getAccount(), true);
    }

    private static boolean a0() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("opensdk_forward_jump_aio_multiple_task_switch", true);
        QLog.d("ForwardOption.ForwardSdkShareOption", 1, "isMultipleTaskSwitchOn isSwitchOn: " + isSwitchOn);
        return isSwitchOn;
    }

    public static boolean b0() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("opensdk_forward_account_cancel_switch", false);
        QLog.d("ForwardOption.ForwardSdkShareOption", 2, "isOpenSdkForwardSwitchOn isSwitchOn: " + isSwitchOn);
        return isSwitchOn;
    }

    private Bundle c0() {
        long j3 = this.mExtraData.getLong("req_share_id");
        String string = this.mExtraData.getString("pkg_name", "");
        Intent intent = new Intent();
        ForwardUtils.g(this.mActivity, string, intent, j3);
        Bundle extras = intent.getExtras();
        extras.putString("app_name", this.mExtraData.getString("app_name", ""));
        return extras;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("action_notify_aio_activity");
        intent.putExtra("key_share_image_by_server", str2);
        this.mActivity.sendBroadcast(intent);
        i.b().c(str2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e0(Bundle bundle, ad.a aVar, String str, String str2, String str3) {
        Bundle bundle2;
        oidb_cmd0xb77$ImageInfo oidb_cmd0xb77_imageinfo;
        AppRuntime runtime;
        Object obj = aVar.f258608l;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            if (iArr.length == 5) {
                oidb_cmd0xb77_imageinfo = new oidb_cmd0xb77$ImageInfo();
                oidb_cmd0xb77_imageinfo.md5.set(aVar.f258603g);
                oidb_cmd0xb77_imageinfo.uuid.set(aVar.f258602f);
                oidb_cmd0xb77_imageinfo.file_size.set(iArr[0]);
                oidb_cmd0xb77_imageinfo.img_type.set(iArr[1]);
                oidb_cmd0xb77_imageinfo.width.set(iArr[2]);
                oidb_cmd0xb77_imageinfo.height.set(iArr[3]);
                oidb_cmd0xb77_imageinfo.original.set(iArr[4]);
                oidb_cmd0xb77_imageinfo.file_id.set((int) aVar.f258604h);
                bundle2 = bundle;
                oidb_cmd0xb77$ReqBody h16 = x.h(bundle2, null, null, oidb_cmd0xb77_imageinfo);
                runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime != null) {
                    QLog.e("ForwardOption.ForwardSdkShareOption", 1, "send runtime = null ");
                    d0(f210836c0, str2);
                    return;
                }
                Bundle bundle3 = new Bundle();
                long currentTimeMillis = System.currentTimeMillis();
                this.V = currentTimeMillis;
                bundle3.putLong("0xb77_9_sendTime", currentTimeMillis);
                if (QLog.isColorLevel()) {
                    QLog.i("ForwardOption.ForwardSdkShareOption", 2, "sendOIDBRequest ");
                }
                ForwardStatisticsReporter.m("KEY_STAGE_2_IMAGE_B77");
                ProtoUtils.c(runtime, new e(str2, str, str3), h16.toByteArray(), "OidbSvc.0xb77_9", 2935, 9, bundle3, 0L);
                return;
            }
        }
        bundle2 = bundle;
        oidb_cmd0xb77_imageinfo = null;
        oidb_cmd0xb77$ReqBody h162 = x.h(bundle2, null, null, oidb_cmd0xb77_imageinfo);
        runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
        }
    }

    private Intent f0() {
        Intent intent = new Intent();
        String string = this.mExtraData.getString("image_url");
        String string2 = this.mExtraData.getString("qqfav_extra_multi_pic_path_list");
        boolean z16 = this.mExtraData.getBoolean("qqfav_extra_multi_pic");
        boolean z17 = this.mExtraData.getBoolean("qdshare_file");
        int i3 = this.mExtraData.getInt(AppConstants.Key.SHARE_REQ_TYPE);
        if (this.mActivity instanceof LiteActivity) {
            if (i3 != 1) {
                if (i3 != 5) {
                    if (i3 == 6 && z17) {
                        intent.putExtra("dataline_forward_type", 100);
                        if (string2 != null && !TextUtils.isEmpty(string2)) {
                            intent.putExtra("dataline_forward_path", string2);
                        } else {
                            intent.putExtra("dataline_forward_path", string);
                        }
                    }
                } else {
                    intent.putExtra("dataline_forward_type", 101);
                    intent.putExtra("dataline_forward_path", string);
                }
            } else if (z16) {
                intent.putExtra("dataline_forward_type", 101);
                if (string2 != null && !TextUtils.isEmpty(string2)) {
                    intent.putExtra("dataline_forward_path", string2);
                } else {
                    intent.putExtra("dataline_forward_path", string);
                }
            }
        } else if (i3 == 5) {
            intent.putExtra("dataline_forward_type", 101);
            intent.putExtra("dataline_forward_path", string);
        }
        return intent;
    }

    private void g0(Intent intent) {
        String str;
        String string = this.mExtraData.getString("detail_url");
        String string2 = this.mExtraData.getString("pkg_name");
        String string3 = this.mExtraData.getString("app_name");
        String string4 = this.mExtraData.getString(AppConstants.Key.SHARE_REQ_AUDIO_URL);
        String string5 = this.mExtraData.getString("image_url");
        String string6 = this.mExtraData.getString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL);
        this.mExtraData.getBoolean("qqfav_extra_multi_pic");
        this.mExtraData.getString("qqfav_extra_multi_pic_path_list");
        this.mExtraData.getBoolean("qdshare_file");
        intent.getStringExtra(IProfileProtocolConst.PARAM_TARGET_UIN);
        if (this.mExtraData.getInt(AppConstants.Key.SHARE_REQ_TYPE) == 5) {
            intent.putExtra("dataline_forward_type", 101);
            intent.putExtra("dataline_forward_path", string5);
        } else {
            if (TextUtils.isEmpty(string)) {
                if (!HttpUtil.isValidUrl(string6)) {
                    str = HardCodeUtil.qqStr(R.string.mpu);
                } else {
                    str = string6;
                }
            } else {
                str = string;
            }
            intent.putExtra("dataline_forward_type", 102);
            intent.putExtra("dataline_forward_text", str);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("isBack2Root", false);
        bundle.putBoolean(AppConstants.Key.SHARE_FLAG, true);
        bundle.putLong(AppConstants.Key.SHARE_RES_ID, com.tencent.mobileqq.utils.h.e(this.f210818d));
        bundle.putString(AppConstants.Key.SHARE_RES_PKG_NAME, string2);
        bundle.putString(AppConstants.Key.SHARE_RES_DETAIL_URL, string);
        bundle.putString("app_name", string3);
        bundle.putString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, string6);
        bundle.putString("image_url", string5);
        if (!TextUtils.isEmpty(string4)) {
            bundle.putString(AppConstants.Key.SHARE_REQ_AUDIO_URL, string4);
        }
        int intExtra = intent.getIntExtra("dataline_forward_type", 102);
        String stringExtra = intent.getStringExtra("dataline_forward_path");
        if (intExtra == 101 && FileManagerUtil.getFileType(stringExtra) != 0) {
            intent.putExtra("dataline_forward_path", stringExtra + ".jpg");
            ThreadManagerV2.excute(new Runnable(stringExtra, intent, bundle, string2) { // from class: com.tencent.mobileqq.forward.ForwardSdkShareOption.10
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f210839d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Intent f210840e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Bundle f210841f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f210842h;

                {
                    this.f210839d = stringExtra;
                    this.f210840e = intent;
                    this.f210841f = bundle;
                    this.f210842h = string2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ForwardSdkShareOption.this, stringExtra, intent, bundle, string2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.mobileqq.filemanager.util.q.b(new File(this.f210839d), new File(this.f210839d + ".jpg"));
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.forward.ForwardSdkShareOption.10.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass10.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                                ForwardSdkShareOption.this.T(anonymousClass10.f210840e, anonymousClass10.f210841f, anonymousClass10.f210842h);
                            }
                        }
                    });
                }
            }, 64, null, false);
            return;
        }
        T(intent, bundle, string2);
    }

    private void h0(String str) {
        String str2;
        int u16 = u();
        if (this.K == 5) {
            com.tencent.biz.common.util.k.j(this.app, null, "connect_sharepic", "pageview", this.f210818d, u16, "");
        } else {
            com.tencent.biz.common.util.k.i(this.app, null, "pageview", this.f210818d, u16, "");
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).reportToAds(this.app, "sha_pageview", 1, "", "", str);
        int i3 = this.K;
        if (i3 == 1) {
            str2 = "1";
        } else if (i3 == 2) {
            str2 = "3";
        } else if (i3 == 5) {
            str2 = "2";
        } else {
            str2 = "4";
        }
        ReportCenter.f().o(this.app.getAccount(), this.f210819e, str, "10", "11", "0", str2, "0", "0", false, true);
        ReportController.o(this.app, "CliOper", "", "", "0X8005A0F", "0X8005A0F", 0, 0, "1", "", "", "");
    }

    private void i0() {
        ArrayList arrayList = new ArrayList();
        List<ResultRecord> multiTarget = getMultiTarget();
        if (multiTarget != null && !multiTarget.isEmpty()) {
            for (ResultRecord resultRecord : multiTarget) {
                arrayList.add(new b.ShareTarget(resultRecord.uinType, resultRecord.uin));
            }
        } else {
            String string = this.mExtraData.getString("uin");
            int i3 = this.mExtraData.getInt("uintype");
            QLog.d("ForwardOption.ForwardSdkShareOption", 4, "reportShareTargetList: friendUin: " + string + ", uinType: " + i3);
            if (!TextUtils.isEmpty(string)) {
                arrayList.add(new b.ShareTarget(i3, string));
            } else {
                QLog.e("ForwardOption.ForwardSdkShareOption", 1, "reportShareTargetList: friendUin is empty ");
            }
        }
        OpenSdkShareReporterProxy.g(this.f210818d, arrayList);
        OpenSdkShareReporterProxy.d().g(this.X);
    }

    private void j0(Dialog dialog) {
        Object valueOf;
        if (dialog == null) {
            return;
        }
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing()) {
            try {
                dialog.show();
                return;
            } catch (Exception e16) {
                QLog.e("ForwardOption.ForwardSdkShareOption", 1, "showAccountConfirm exception", e16);
                return;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("showAccountConfirm error: ");
        Activity activity2 = this.mActivity;
        if (activity2 == null) {
            valueOf = "null";
        } else {
            valueOf = Boolean.valueOf(activity2.isFinishing());
        }
        sb5.append(valueOf);
        QLog.e("ForwardOption.ForwardSdkShareOption", 1, sb5.toString());
    }

    private String k0(Bundle bundle, String str) {
        String string = bundle.getString("title");
        String string2 = bundle.getString("desc");
        String str2 = "";
        if (!TextUtils.isEmpty(string)) {
            str2 = "" + string;
        }
        if (!TextUtils.isEmpty(string2)) {
            if (!TextUtils.isEmpty(str2)) {
                string2 = (str2 + "\n") + string2;
            }
        } else {
            string2 = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(string2)) {
                return (string2 + "\n") + str;
            }
            return str;
        }
        return string2;
    }

    private void m0(long j3, String str) {
        n0(j3, str, this.mExtraData.getString("uin"), this.mExtraData.getInt("uintype"), this.mExtraData.getString("troop_uin"), true);
        ForwardUtils.l(this.mActivity);
    }

    private void n0(long j3, String str, String str2, int i3, String str3, boolean z16) {
        Intent V;
        AbsStructMsg absStructMsg;
        QLog.d("ForwardOption.ForwardSdkShareOption", 1, "-->handleMessage--appid = ", Long.valueOf(j3), ", pkgNmae = ", str);
        int i16 = this.mExtraData.getInt("forward_type", -1);
        if (i3 == 10014) {
            V = W();
        } else {
            V = V();
        }
        Intent intent = V;
        intent.putExtra("k_from_login", true);
        if (i16 == 11) {
            ForwardUtils.g(this.mActivity, str, intent, this.mExtraData.getLong("req_share_id"));
            String string = this.mExtraData.getString("video_url");
            String string2 = this.mExtraData.getString("detail_url");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                String b16 = com.tencent.mobileqq.structmsg.d.b(string2);
                if (!TextUtils.isEmpty(b16)) {
                    ReportController.o(null, "CliOper", "", "", "0X8005F53", "0X8005F53", 0, 0, com.tencent.mobileqq.structmsg.d.d(i3) + "", "", b16, "");
                }
            }
        }
        String l3 = Long.toString(System.currentTimeMillis());
        AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(this.mExtraData);
        if (e16 != null && this.app != null) {
            if (e16 instanceof StructMsgForImageShare) {
                if (x.l() && i16 == 11) {
                    intent.putExtra("key_share_image_by_server", l3);
                    String r16 = jq3.a.r(i3);
                    String str4 = ((AbsShareMsg) e16).mContentTitle;
                    jq3.a.k(e16, i3, j3);
                    absStructMsg = e16;
                    ThreadManagerV2.post(new Runnable(absStructMsg, str2, i3, r16, l3, str4) { // from class: com.tencent.mobileqq.forward.ForwardSdkShareOption.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ AbsStructMsg f210844d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ String f210845e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ int f210846f;

                        /* renamed from: h, reason: collision with root package name */
                        final /* synthetic */ String f210847h;

                        /* renamed from: i, reason: collision with root package name */
                        final /* synthetic */ String f210848i;

                        /* renamed from: m, reason: collision with root package name */
                        final /* synthetic */ String f210849m;

                        /* compiled from: P */
                        /* renamed from: com.tencent.mobileqq.forward.ForwardSdkShareOption$2$a */
                        /* loaded from: classes12.dex */
                        class a implements com.tencent.mobileqq.pic.ad {
                            static IPatchRedirector $redirector_;

                            a() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // com.tencent.mobileqq.pic.ad
                            public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    return (MessageRecord) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_richtext);
                                }
                                return null;
                            }

                            @Override // com.tencent.mobileqq.pic.ad
                            public void q(ad.a aVar) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
                                    return;
                                }
                                ForwardStatisticsReporter.c("KEY_STAGE_2_UPLOAD_IMAGE");
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                ForwardSdkShareOption forwardSdkShareOption = ForwardSdkShareOption.this;
                                forwardSdkShareOption.e0(forwardSdkShareOption.mExtraData, aVar, anonymousClass2.f210847h, anonymousClass2.f210848i, anonymousClass2.f210849m);
                            }

                            @Override // com.tencent.mobileqq.pic.ad
                            public void r(ad.a aVar) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
                                } else if (aVar != null && QLog.isColorLevel()) {
                                    QLog.d("ForwardOption.ForwardSdkShareOption", 2, "upCallBack updateMsg info =", aVar.toString());
                                }
                            }
                        }

                        {
                            this.f210844d = absStructMsg;
                            this.f210845e = str2;
                            this.f210846f = i3;
                            this.f210847h = r16;
                            this.f210848i = l3;
                            this.f210849m = str4;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, ForwardSdkShareOption.this, absStructMsg, str2, Integer.valueOf(i3), r16, l3, str4);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                ForwardStatisticsReporter.m("KEY_STAGE_2_UPLOAD_IMAGE");
                                StructMsgForImageShare.sendAndUploadImageShare(ForwardSdkShareOption.this.app, (StructMsgForImageShare) this.f210844d, this.f210845e, this.f210846f, null, 0, new a(), true);
                            }
                        }
                    }, 8, null, false);
                } else {
                    ThreadManagerV2.post(new Runnable(e16, str2, i3) { // from class: com.tencent.mobileqq.forward.ForwardSdkShareOption.3
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ AbsStructMsg f210851d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ String f210852e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ int f210853f;

                        {
                            this.f210851d = e16;
                            this.f210852e = str2;
                            this.f210853f = i3;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, ForwardSdkShareOption.this, e16, str2, Integer.valueOf(i3));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                StructMsgForImageShare.sendAndUploadImageShare(ForwardSdkShareOption.this.app, (StructMsgForImageShare) this.f210851d, this.f210852e, this.f210853f, null, 0);
                            }
                        }
                    }, 8, null, false);
                    absStructMsg = e16;
                }
            } else if (i16 == 11) {
                this.mExtraData.putBoolean(AppConstants.Key.SHARE_SEND_MSG_BY_SERVER, true);
                intent.putExtra("key_b77_sdk_share", l3);
                absStructMsg = e16;
                new ForwardSDKB77Sender().e(this.app, (AbsShareMsg) e16, this.mActivity, this.mExtraData, l3);
            } else {
                absStructMsg = e16;
                l0(absStructMsg, str2, i3, str3);
            }
            intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, absStructMsg.getBytes());
            ForwardUtils.f0(i3, intent, this.mExtraData);
            if (z16) {
                if (a0() && w.b(this.mActivity)) {
                    intent.addFlags(134217728);
                }
                ForwardUtils.d0(intent.getExtras());
                this.mActivity.startActivity(intent);
            }
        }
    }

    private void o0() {
        if (needSendMessage()) {
            sendMessage2TargetOnConfirm(this.mExtraData.getString("uin"), this.mExtraData.getString("troop_uin"), this.mExtraData.getInt("uintype"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        if (this.U) {
            this.mExtraData.putString("uin", "-1010");
            this.mExtraData.putInt("uintype", -1);
            this.mExtraData.putInt("key_forward_ability_type", com.tencent.mobileqq.forward.e.R3.intValue());
            buildConfirmDialog();
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardSdkBaseOption
    public void A() {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        if (isMultiTarget2Send() && this.isSdkShare) {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            if (getMultiTargetWithoutDataLine() == null) {
                size = 0;
            } else {
                size = getMultiTargetWithoutDataLine().size();
            }
            ForwardUtils.h0(qQAppInterface, "0X800A739", Integer.toString(size));
        }
    }

    public void T(Intent intent, Bundle bundle, String str) {
        String n3;
        String i3;
        String f16;
        String j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, intent, bundle, str);
            return;
        }
        com.tencent.mobileqq.forward.b bVar = this.J;
        if (bVar != null) {
            if (bVar.n() == null) {
                n3 = "";
            } else {
                n3 = this.J.n();
            }
            bundle.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL, n3);
            if (this.J.i() == null) {
                i3 = "";
            } else {
                i3 = this.J.i();
            }
            bundle.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, i3);
            if (this.J.f() == null) {
                f16 = "";
            } else {
                f16 = this.J.f();
            }
            bundle.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME, f16);
            if (this.J.j() == null) {
                j3 = "";
            } else {
                j3 = this.J.j();
            }
            bundle.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA, j3);
        }
        Intent intent2 = new Intent();
        intent2.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", Long.valueOf(this.f210818d), "shareToQQ")));
        intent2.setPackage(str);
        intent.putExtra(AppConstants.Key.ACTIVITY_FINISH_RUN_PENDING_INTENT, PendingIntent.getActivity(this.mActivity, 0, intent2, 335544320));
        Activity activity = this.mActivity;
        if ((activity instanceof IphoneTitleBarActivity) && !(activity instanceof LiteActivity)) {
            ((IphoneTitleBarActivity) activity).setTitle((CharSequence) null);
        }
        intent.setFlags(67108864);
        intent.addFlags(268435456);
        intent.putExtras(bundle);
        String stringExtra = intent.getStringExtra(IProfileProtocolConst.PARAM_TARGET_UIN);
        if (intent.getBooleanExtra("forward_jump_to_data_line_aio", false)) {
            navigateToAIO(stringExtra, intent.getExtras());
            C(0, "", "");
        }
    }

    protected Intent V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Intent) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        Intent aliasIntent = SplashActivity.getAliasIntent(this.mActivity);
        if (!this.mExtraData.getBoolean("share_from_aio", false)) {
            Intent m3 = BaseAIOUtils.m(aliasIntent, new int[]{2});
            this.mExtraData.remove("share_from_aio");
            return m3;
        }
        Intent m16 = BaseAIOUtils.m(aliasIntent, null);
        m16.putExtra("share_from_aio", true);
        return m16;
    }

    protected Intent W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Intent) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (!this.mExtraData.getBoolean("share_from_aio", false)) {
            this.mExtraData.remove("share_from_aio");
        } else {
            this.mExtraData.putBoolean("share_from_aio", true);
        }
        if (((IGuildFeedsHomeJumpApi) QRoute.api(IGuildFeedsHomeJumpApi.class)).isJumpFeedsHome()) {
            return ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatActivityIntent(this.mActivity, new com.tencent.mobileqq.guild.api.i().f(this.mExtraData.getString("guild_id", "")).b(this.mExtraData.getString("uin", "")).d(com.tencent.guild.aio.factory.a.class.getName()).e(null).a());
        }
        return ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatPieIntent(this.mActivity, new LaunchGuildChatPieParam().l(this.mExtraData.getString("guild_id", "")).b(this.mExtraData.getString("uin", "")).k(null).r(false).o(1).f(true).a());
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ void a(Activity activity, String str, int i3, com.tencent.mobileqq.guild.feed.api.g gVar) {
        ak.a(this, activity, str, i3, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean addStructView(QQCustomDialog qQCustomDialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) qQCustomDialog)).booleanValue();
        }
        if (this.G == null) {
            if (!(this.mActivity instanceof LiteActivity)) {
                s();
            }
            Bundle bundle = new Bundle(this.mExtraData);
            String string = this.mExtraData.getString("image_url");
            if (!TextUtils.isEmpty(string)) {
                bundle.putString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, string);
            }
            AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(bundle);
            if (!AbsShareMsg.class.isInstance(e16)) {
                if (QLog.isColorLevel()) {
                    QLog.e("ForwardOption.ForwardSdkShareOption", 2, "-->preloadData--structMsg is not an instance of AbsShareMsg");
                }
                C(-1, HardCodeUtil.qqStr(R.string.mpx), HardCodeUtil.qqStr(R.string.mqn));
                try {
                    com.tencent.open.business.viareport.c.a().b(1, "SHARE_CHECK_AGENT", this.app.getCurrentAccountUin(), String.valueOf(this.f210818d), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "\u7c7b\u578b\u9519\u8bef");
                } catch (Exception unused) {
                }
                return false;
            }
            this.G = (AbsShareMsg) e16;
        }
        boolean S = S(this.G);
        if (!this.mExtraData.getBoolean("key_sdk_share_pure_text")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            AbsShareMsg absShareMsg = this.G;
            if (absShareMsg instanceof StructMsgForGeneralShare) {
                if (!S) {
                    layoutParams.setMargins(BaseAIOUtils.f(-15.0f, this.mActivity.getResources()), 0, BaseAIOUtils.f(-15.0f, this.mActivity.getResources()), BaseAIOUtils.f(5.0f, this.mActivity.getResources()));
                } else {
                    layoutParams.setMargins(0, 0, 0, 0);
                    if (!this.mExtraData.getBoolean("is_ark_display_share") || !this.mExtraData.getBoolean(AppConstants.Key.FORWARD_ARK_FROM_SDK)) {
                        qQCustomDialog.adjustMessageTopBottomMargin(0.0f, 0.0f);
                    }
                }
            } else if (absShareMsg instanceof StructMsgForAudioShare) {
                layoutParams.setMargins(0, BaseAIOUtils.f(5.0f, this.mActivity.getResources()), 0, BaseAIOUtils.f(10.0f, this.mActivity.getResources()));
            } else if (absShareMsg instanceof StructMsgForImageShare) {
                layoutParams.setMargins(BaseAIOUtils.f(-10.0f, this.mActivity.getResources()), 0, BaseAIOUtils.f(-7.5f, this.mActivity.getResources()), 0);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardSdkShareOption", 2, "updateImageView addStructView");
            }
            this.F = new ForwardSdkBaseOption.g(this.mActivity);
            if ((!this.mExtraData.getBoolean("is_ark_display_share") || !this.mExtraData.getBoolean(AppConstants.Key.FORWARD_ARK_FROM_SDK)) && !this.mExtraData.getBoolean(AppConstants.Key.FORWARD_MINI_PROGRAM_ARK_FROM_SDK)) {
                qQCustomDialog.addView(this.F.b(), layoutParams);
                AbsShareMsg absShareMsg2 = this.G;
                if (!(absShareMsg2 instanceof StructMsgForImageShare) && !S) {
                    addSourceNameView(absShareMsg2.mSourceName, qQCustomDialog);
                    return true;
                }
                return true;
            }
            if (this.mExtraData.getInt(AppConstants.Key.SHARE_REQ_TYPE) == 5) {
                qQCustomDialog.addView(this.F.b(), layoutParams);
                AbsShareMsg absShareMsg3 = this.G;
                if (!(absShareMsg3 instanceof StructMsgForImageShare) && !S) {
                    addSourceNameView(absShareMsg3.mSourceName, qQCustomDialog);
                    return true;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected boolean allowQZoneAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.T;
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ boolean b() {
        return ak.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (allowDiscussAbility()) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.Q3);
        }
        if (allowTroopAbility()) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.P3);
        }
        if (allowFriendAbility()) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.O3);
        }
        if (allowPhoneContactAbility()) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.U3);
        }
        if (allowQZoneAbility()) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.R3);
        }
        if (N()) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.S3);
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.X3);
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.f211017e4);
        }
        addFavoriteAbility();
        if (super.allowSmartDeviceAbility()) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.W3);
        }
        if (!TextUtils.isEmpty(this.mExtraData.getString("detail_url"))) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.Z3);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardSdkBaseOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int i3, Bundle bundle) {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3, (Object) bundle);
            return;
        }
        super.buildForwardDialog(i3, bundle);
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        if (qQCustomDialog != null) {
            viewGroup = qQCustomDialog.getRootView();
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            OpenSdkShareReporterProxy.d().b(this.mConfirmDialog.getRootView(), this.X);
        } else {
            QLog.e("ForwardOption.ForwardSdkShareOption", 1, "buildForwardDialog getDialogView return null");
        }
    }

    @Override // com.tencent.mobileqq.forward.al
    @Nullable
    public SharePublishGuildFeedParam c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (SharePublishGuildFeedParam) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        String string = this.mExtraData.getString("detail_url", "");
        String string2 = this.mExtraData.getString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, "");
        if (TextUtils.isEmpty(string2)) {
            string2 = this.mExtraData.getString("image_url", "");
        }
        if (TextUtils.isEmpty(string)) {
            QLog.w("ForwardOption.ForwardSdkShareOption", 1, "forwardToGuildFeed extraData: " + this.mExtraData);
            return null;
        }
        SharePublishGuildFeedParam U = U(this.mExtraData.getLong("req_share_id"), string2, string);
        if (U != null) {
            U.setShowDefaultShareResultToast(false);
            U.getEditorLaunchOption().setSuccessAction(1);
            U.getEditorLaunchOption().setBackToThirdAppExtras(c0());
            U.getEditorLaunchOption().setRedirectWithNewTask(Boolean.TRUE);
        }
        return U;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void endForwardCallback(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, z16);
            return;
        }
        ForwardSdkBaseOption.F(this.mActivity, z16, "shareToQQ", this.f210818d);
        if (!z16) {
            this.mActivity.findViewById(android.R.id.content);
            OpenSdkShareReporterProxy.d().d(this.X);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        super.forwardOnCancel();
        String string = this.mExtraData.getString(AppConstants.Key.SHARE_REQ_ARK_INFO);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("app");
                String optString2 = jSONObject.optString("view");
                String optString3 = jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                    com.tencent.mobileqq.ark.g.b(this.app, optString, "AIOArkSdkSendClosed", 1, 0, 0L, 0L, 0L, optString2, "");
                }
            } catch (JSONException unused) {
            }
        }
        if (isMultiTarget2Send()) {
            ForwardUtils.h0(this.app, "0X800A736", X());
        }
        ReportController.o(this.app, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
        if (this.mIntent.getBooleanExtra(AppConstants.Key.FORWARD_MINI_PROGRAM_ARK_FROM_SDK, false)) {
            ReportController.o(this.app, "dc00898", "", "", "0X8009F7B", "0X8009F7B", 0, 0, "2", "", "", "");
        }
        if (!this.mIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false) && !this.mIntent.getBooleanExtra("qqfav_extra_from_system_share", false)) {
            super.forwardOnCancel();
            Activity activity = this.mActivity;
            if (activity instanceof LiteActivity) {
                long j3 = this.f210818d;
                if (j3 != 0) {
                    ForwardSdkBaseOption.F(activity, false, "sendToMyComputer", j3);
                }
            }
        } else {
            ForwardSdkBaseOption.F(this.mActivity, false, "addToQQFavorites", this.f210818d);
        }
        OpenSdkShareReporterProxy.d().e(this.X);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnConfirm() {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (!isMultiTarget2Send() && Q()) {
            forwardToDataLine(com.tencent.mobileqq.forward.e.S3.intValue());
            return;
        }
        reportSendAction();
        ForwardStatisticsReporter.m("KEY_STAGE_2_TOTAL");
        long j3 = this.mExtraData.getLong("req_share_id");
        String string = this.mExtraData.getString("pkg_name");
        String string2 = this.mExtraData.getString("detail_url");
        this.mExtraData.putBoolean("isBack2Root", false);
        this.mExtraData.putLong(AppConstants.Key.SHARE_RES_ID, j3);
        this.mExtraData.putString(AppConstants.Key.SHARE_RES_PKG_NAME, string);
        String inputValue = this.mConfirmDialog.getInputValue();
        this.mExtraData.putString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE_FOR_SERVER, inputValue);
        this.mExtraData.putString(AppConstants.Key.SHARE_MSG_INPUT_VALUE, inputValue);
        this.mExtraData.putString(AppConstants.Key.SHARE_RES_DETAIL_URL, string2);
        boolean z17 = com.tencent.mobileqq.structmsg.i.e(this.mExtraData) instanceof StructMsgForImageShare;
        if (z17) {
            this.mExtraData.putString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE, this.mConfirmDialog.getInputValue());
            this.mIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 147);
        }
        if (isMultiTarget2Send()) {
            this.mExtraData.putInt(AppConstants.Key.SHARE_SDK_SHARE_TYPE, 2);
            if (TextUtils.isEmpty(inputValue)) {
                str = "2";
            } else {
                str = "1";
            }
            ForwardUtils.h0(this.app, "0X800A735", X(), str);
            if (this.mExtraData.getInt("forward_type", -1) == 11) {
                if (z17 && x.l()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean z18 = !z17;
                if (!z16 && !z18) {
                    this.C = this.mConfirmDialog.getInputValue();
                    super.forwardOnConfirm();
                } else {
                    this.W.B(getMultiTargetWithoutDataLine());
                }
            } else if (this.mExtraData.getBoolean(AppConstants.Key.FORWARD_ARK_FROM_SDK)) {
                for (ResultRecord resultRecord : this.mExtraData.getParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET)) {
                    if (needSendMessage()) {
                        sendMessage2TargetOnConfirm(resultRecord.uin, resultRecord.groupUin, resultRecord.getUinType());
                    }
                    n0(j3, string, resultRecord.uin, resultRecord.getUinType(), resultRecord.groupUin, false);
                }
            } else {
                this.C = this.mConfirmDialog.getInputValue();
                super.forwardOnConfirm();
            }
        } else {
            this.mExtraData.putInt(AppConstants.Key.SHARE_SDK_SHARE_TYPE, 1);
            if (this.mExtraData.getBoolean(AppConstants.Key.FORWARD_ARK_FROM_SDK)) {
                o0();
                m0(j3, string);
            } else {
                ReportController.o(this.app, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
                if (this.fromCreateDiscussion) {
                    ReportController.o(this.app, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
                    this.fromCreateDiscussion = false;
                }
                this.C = this.mConfirmDialog.getInputValue();
                super.forwardToTarget();
                if (this.mExtraData.getBoolean(AppConstants.Key.FORWARD_MINI_PROGRAM_ARK_FROM_SDK)) {
                    o0();
                }
                Bundle bundle = new Bundle();
                bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                bundle.putString("act_type", "82");
                bundle.putString("intext_1", "" + com.tencent.open.agent.report.e.b(this.K));
                bundle.putString("intext_2", "" + com.tencent.open.agent.report.e.c(this.mExtraData.getInt("uintype"), this.mExtraData.getString("uin")));
                bundle.putString("intext_3", "0");
                ReportCenter.f().m(bundle, "", this.app.getCurrentAccountUin(), false, true);
            }
        }
        if (this.mIntent.getBooleanExtra(AppConstants.Key.FORWARD_MINI_PROGRAM_ARK_FROM_SDK, false)) {
            ReportController.o(this.app, "dc00898", "", "", "0X8009F7B", "0X8009F7B", 0, 0, "1", "", "", "");
        }
        i0();
        OpenSdkShareReporterProxy.d().a(this.X);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardToDataLine(int i3) {
        String str;
        String str2;
        String str3;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
            return;
        }
        String string = this.mExtraData.getString("detail_url");
        String string2 = this.mExtraData.getString("pkg_name");
        String string3 = this.mExtraData.getString("app_name");
        String string4 = this.mExtraData.getString(AppConstants.Key.SHARE_REQ_AUDIO_URL);
        String string5 = this.mExtraData.getString("image_url");
        String string6 = this.mExtraData.getString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL);
        Intent intent = new Intent(this.mActivity, (Class<?>) LiteActivity.class);
        boolean z16 = this.mExtraData.getBoolean("qqfav_extra_multi_pic");
        String string7 = this.mExtraData.getString("qqfav_extra_multi_pic_path_list");
        boolean z17 = this.mExtraData.getBoolean("qdshare_file");
        if (i3 == com.tencent.mobileqq.forward.e.X3.intValue()) {
            intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, AppConstants.DATALINE_IPAD_UIN);
            intent.putExtra("device_type", 1);
        } else if (i3 == com.tencent.mobileqq.forward.e.f211017e4.intValue()) {
            intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, AppConstants.DATALINE_PHONE_UIN);
            intent.putExtra("device_type", 1);
        } else {
            intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, AppConstants.DATALINE_PC_UIN);
            intent.putExtra("device_type", 0);
        }
        if (this.mActivity instanceof LiteActivity) {
            int i16 = this.mExtraData.getInt(AppConstants.Key.SHARE_REQ_TYPE);
            str2 = "app_name";
            str = string2;
            str3 = string6;
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 5) {
                        if (i16 != 6) {
                            intent.putExtra("dataline_forward_type", 102);
                            intent.putExtra("dataline_forward_text", HardCodeUtil.qqStr(R.string.f172008mq2));
                        } else if (z17) {
                            intent.putExtra("dataline_forward_type", 100);
                            if (string7 != null && !TextUtils.isEmpty(string7)) {
                                intent.putExtra("dataline_forward_path", string7);
                            } else {
                                intent.putExtra("dataline_forward_path", string5);
                            }
                        } else {
                            String k06 = k0(this.mExtraData, "");
                            intent.putExtra("dataline_forward_type", 102);
                            intent.putExtra("dataline_forward_text", k06);
                            ReportController.o(this.app, "CliOper", "", "", "0X8004931", "0X8004931", 0, 0, "", "", "", "");
                            x("qqdataline", "shareFromMigSdk|report send text:0X8004931.");
                        }
                    } else {
                        intent.putExtra("dataline_forward_type", 101);
                        QLog.d("ForwardOption.ForwardSdkShareOption", 1, "forwardToDataline 1 filePath: " + string5);
                        intent.putExtra("dataline_forward_path", string5);
                    }
                } else {
                    String k07 = k0(this.mExtraData, string4);
                    intent.putExtra("dataline_forward_type", 102);
                    intent.putExtra("dataline_forward_text", k07);
                    ReportController.o(this.app, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
                    x("qqdataline", "shareFromMigSdk|report send link:0X800492E.");
                }
            } else if (z16) {
                intent.putExtra("dataline_forward_type", 101);
                if (string7 != null && !TextUtils.isEmpty(string7)) {
                    intent.putExtra("dataline_forward_path", string7);
                    QLog.d("ForwardOption.ForwardSdkShareOption", 1, "forwardToDataline 2 filePath: " + string7);
                } else {
                    intent.putExtra("dataline_forward_path", string5);
                    QLog.d("ForwardOption.ForwardSdkShareOption", 1, "forwardToDataline 3 filePath: " + string5);
                }
            } else {
                String k08 = k0(this.mExtraData, string);
                intent.putExtra("dataline_forward_type", 102);
                intent.putExtra("dataline_forward_text", k08);
                ReportController.o(this.app, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
                x("qqdataline", "shareFromMigSdk|report send link:0X800492E.");
            }
        } else {
            str = string2;
            str2 = "app_name";
            str3 = string6;
            if (this.mExtraData.getInt(AppConstants.Key.SHARE_REQ_TYPE) == 5) {
                intent.putExtra("dataline_forward_type", 101);
                intent.putExtra("dataline_forward_path", string5);
            } else {
                if (TextUtils.isEmpty(string)) {
                    if (!HttpUtil.isValidUrl(str3)) {
                        str4 = HardCodeUtil.qqStr(R.string.mpu);
                    } else {
                        str4 = str3;
                    }
                } else {
                    str4 = string;
                }
                intent.putExtra("dataline_forward_type", 102);
                intent.putExtra("dataline_forward_text", str4);
            }
        }
        Bundle bundle = this.mExtraData;
        bundle.putBoolean("isBack2Root", false);
        bundle.putBoolean(AppConstants.Key.SHARE_FLAG, true);
        bundle.putLong(AppConstants.Key.SHARE_RES_ID, com.tencent.mobileqq.utils.h.e(this.f210818d));
        bundle.putString(AppConstants.Key.SHARE_RES_PKG_NAME, str);
        bundle.putString(AppConstants.Key.SHARE_RES_DETAIL_URL, string);
        bundle.putString(str2, string3);
        bundle.putString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, str3);
        bundle.putString("image_url", string5);
        if (!TextUtils.isEmpty(string4)) {
            bundle.putString(AppConstants.Key.SHARE_REQ_AUDIO_URL, string4);
        }
        this.mExtraData.putAll(intent.getExtras());
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardToQQStory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getDialogContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        String str = this.mForwardText;
        if (!TextUtils.isEmpty(str) && com.tencent.biz.common.util.j.d(str, "UTF-8") > 105) {
            str = com.tencent.biz.common.util.j.f(str, 105, "UTF-8", MiniBoxNoticeInfo.APPNAME_SUFFIX);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardSdkShareOption", 2, "DialogContent:mForwardText=" + str);
        }
        return str;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public int getDialogLeftBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        if (!this.mIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false) && !this.mIntent.getBooleanExtra("qqfav_extra_from_system_share", false)) {
            return super.getDialogLeftBtn();
        }
        return R.string.cancel;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public int getDialogRightBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        if (!this.mIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false) && !this.mIntent.getBooleanExtra("qqfav_extra_from_system_share", false)) {
            return super.getDialogRightBtn();
        }
        return R.string.eyb;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getDialogTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        if (!this.mIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false) && !this.mIntent.getBooleanExtra("qqfav_extra_from_system_share", false)) {
            if (this.f210818d == 55901189) {
                return null;
            }
            return super.getDialogTitle();
        }
        return this.mActivity.getResources().getString(R.string.exv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public int getEditTextType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }
        int i3 = this.mExtraData.getInt("key_forward_ability_type");
        if (i3 == com.tencent.mobileqq.forward.e.T3.intValue()) {
            return 0;
        }
        if (i3 == com.tencent.mobileqq.forward.e.R3.intValue()) {
            return 1;
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : list) {
            if (recentUser != null && !Utils.J(recentUser.uin) && recentUser.getType() != 1020 && recentUser.getType() != 1008 && recentUser.getType() != 1005 && recentUser.getType() != 1009 && recentUser.getType() != 1021 && recentUser.getType() != 1001 && recentUser.getType() != 10002 && recentUser.getType() != 10004 && recentUser.getType() != 1022 && recentUser.getType() != 7000 && recentUser.getType() != 6004 && (recentUser.getType() != 1 || !isHotChat(recentUser.uin))) {
                if (recentUser.getType() != 1006 || isSupportAbility(com.tencent.mobileqq.forward.e.U3)) {
                    if (recentUser.getType() != 9501 && (recentUser.getType() != 0 || !CrmUtils.v(this.app, recentUser.uin, recentUser.getType()))) {
                        if ((recentUser.getType() != 1004 && recentUser.getType() != 1000) || this.mSurpportTroopDiscussionTmpConv) {
                            arrayList.add(recentUser);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean handleQZoneClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        com.tencent.open.agent.report.c.b(this.X);
        return super.handleQZoneClick();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void initContext(QQAppInterface qQAppInterface, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) activity);
        } else {
            super.initContext(qQAppInterface, activity);
            this.W.r(qQAppInterface, activity);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isFromLimit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isSupportMultipleForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return true;
    }

    protected boolean l0(AbsStructMsg absStructMsg, String str, int i3, String str2) {
        ArkAppMessage arkAppMessage;
        ArkAppMessage arkAppMessage2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, absStructMsg, str, Integer.valueOf(i3), str2)).booleanValue();
        }
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = i3;
        sessionInfo.f179557e = str;
        sessionInfo.f179559f = str2;
        if (i3 >= 0 && !TextUtils.isEmpty(str)) {
            String string = this.mExtraData.getString("forward_ark_app_name");
            String string2 = this.mExtraData.getString("forward_ark_app_view");
            String string3 = this.mExtraData.getString("forward_ark_biz_src", "");
            String string4 = this.mExtraData.getString(AppConstants.Key.FORWARD_ARK_APP_DESC);
            String string5 = this.mExtraData.getString("forward_ark_app_ver");
            String string6 = this.mExtraData.getString("forward_ark_app_prompt");
            String string7 = this.mExtraData.getString("forward_ark_app_meta");
            String string8 = this.mExtraData.getString(AppConstants.Key.FORWARD_ARK_APP_CONFIG);
            String string9 = this.mExtraData.getString(AppConstants.Key.FORWARD_ARK_APP_COMPAT);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                if (this.mExtraData.getBoolean(AppConstants.Key.FORWARD_ARK_APP_DIRECT)) {
                    ReportCenter.f().q(this.app.getCurrentAccountUin(), "", "0", TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID, "2006", "0", false, true);
                }
                ArkAppMessage arkAppMessage3 = new ArkAppMessage(string6, string, string3, string4, string2, string5, string7, string8, string9);
                ArkAppMessage arkAppMessage4 = (ArkAppMessage) com.tencent.mobileqq.ark.e.a(2, string, this.mExtraData, arkAppMessage3);
                if (arkAppMessage4 == null) {
                    arkAppMessage = arkAppMessage3;
                } else {
                    arkAppMessage = arkAppMessage4;
                }
                String string10 = this.mExtraData.getString(AppConstants.Key.FORWARD_APPID_ARK_FROM_SDK);
                String string11 = this.mExtraData.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME);
                String string12 = this.mExtraData.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION_DATA);
                String string13 = this.mExtraData.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA);
                String string14 = this.mExtraData.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL);
                if (!TextUtils.isEmpty(string10)) {
                    arkAppMessage.appId = string10;
                    arkAppMessage.mSourceName = string11;
                    arkAppMessage.mSourceActionData = string12;
                    arkAppMessage.mSource_A_ActionData = string13;
                    arkAppMessage.mSourceUrl = string14;
                }
                if (absStructMsg != null) {
                    int i16 = sessionInfo.f179555d;
                    if (i16 != 1000 && i16 != 1004 && i16 != 1020) {
                        str3 = this.app.getCurrentAccountUin();
                    } else {
                        str3 = sessionInfo.f179559f;
                    }
                    String str4 = str3;
                    QQAppInterface qQAppInterface = this.app;
                    String currentAccountUin = qQAppInterface.getCurrentAccountUin();
                    String str5 = sessionInfo.f179557e;
                    int i17 = sessionInfo.f179555d;
                    int i18 = MobileQQServiceBase.seq;
                    MobileQQServiceBase.seq = i18 + 1;
                    arkAppMessage2 = arkAppMessage3;
                    arkAppMessage.containStructMsg = com.tencent.mobileqq.service.message.q.A(qQAppInterface, currentAccountUin, str5, str4, i17, i18, absStructMsg);
                } else {
                    arkAppMessage2 = arkAppMessage3;
                }
                if (!TextUtils.isEmpty(arkAppMessage2.appName) && !TextUtils.isEmpty(arkAppMessage2.appView) && !TextUtils.isEmpty(arkAppMessage2.metaList)) {
                    com.tencent.mobileqq.ark.g.b(this.app, arkAppMessage2.appName, "AIOArkSdkSendMessage", 1, 0, 0L, 0L, 0L, arkAppMessage2.appView, "");
                }
                com.tencent.mobileqq.forward.utils.f.f211079a.g(sessionInfo, arkAppMessage);
                return true;
            }
            if (this.mExtraData.getBoolean(AppConstants.Key.FORWARD_ARK_APP_DIRECT)) {
                ReportCenter.f().q(this.app.getCurrentAccountUin(), "", "0", TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID, "2006", "1", false, true);
            }
            return false;
        }
        if (this.mExtraData.getBoolean(AppConstants.Key.FORWARD_ARK_APP_DIRECT)) {
            ReportCenter.f().q(this.app.getCurrentAccountUin(), "", "0", TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID, "2006", "1", false, true);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean needSendMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onActivityCreated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onActivityCreated();
        if (this.isSdkShare) {
            jq3.a.i(this.app);
            VideoReport.addToDetectionWhitelist(this.mActivity);
            OpenSdkShareReporterProxy.d().i(this.mActivity.findViewById(android.R.id.content), this.X);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardSdkBaseOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        super.onDestroy();
        this.app.removeObserver(this.f210837a0);
        com.tencent.biz.widgets.f fVar = this.mResultDlg;
        if (fVar != null && fVar.isShowing()) {
            this.mResultDlg.dismiss();
        }
        com.tencent.biz.widgets.f fVar2 = this.D;
        if (fVar2 != null && fVar2.isShowing()) {
            this.D.dismiss();
        }
        Handler handler = this.f210822i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.Z;
        if (handler2 != null) {
            handler2.removeMessages(0);
            this.Z = null;
        }
    }

    protected void p0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        QLog.d("ForwardOption.ForwardSdkShareOption", 1, "showAccountConfirm");
        StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
        QQAppInterface qQAppInterface = this.app;
        statisticCollector.reportActionCountCliOper(qQAppInterface, qQAppInterface.getAccount(), "", "multi_account", "push_login_window", 0, 1, 0);
        QQCustomDialog qQCustomDialog = this.f210838b0;
        if (qQCustomDialog != null) {
            if (!qQCustomDialog.isShowing()) {
                j0(this.f210838b0);
                return;
            }
            return;
        }
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.mActivity, 230);
            this.f210838b0 = createCustomDialog;
            createCustomDialog.setMessage(R.string.d65);
            this.f210838b0.setTitle(R.string.b1v);
            h hVar = new h();
            this.f210838b0.setNegativeButton(R.string.cancel, hVar);
            this.f210838b0.setPositiveButton(R.string.hin, hVar);
            j0(this.f210838b0);
            return;
        }
        QLog.d("ForwardOption.ForwardSdkShareOption", 1, "showAccountConfirm-->(mActivity == null || mActivity.isFinishing())");
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void preForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardSdkBaseOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        boolean z16 = false;
        if (this.mExtraData.getBoolean("enable_d55", false) && P()) {
            return false;
        }
        boolean preloadData = super.preloadData();
        boolean booleanExtra = this.mIntent.getBooleanExtra("k_qzone", false);
        this.T = booleanExtra;
        if (booleanExtra && this.mIntent.getBooleanExtra("k_send", true)) {
            z16 = true;
        }
        this.U = z16;
        if (preloadData) {
            com.tencent.open.business.viareport.c.a().b(0, "SHARE_CHECK_AGENT", this.app.getCurrentAccountUin(), String.valueOf(this.f210818d), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
        }
        try {
            this.mExtraData.putInt("emoInputType", 1);
        } catch (ArrayIndexOutOfBoundsException e16) {
            QLog.e("ForwardOption.ForwardSdkShareOption", 1, "preloadData mExtraData.putInt error : ", e16);
        }
        O();
        h0(String.valueOf(this.f210818d));
        z("KEY_STAGE_1_TOTAL", true);
        return preloadData;
    }

    @Override // com.tencent.mobileqq.forward.ForwardSdkBaseOption
    protected boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        Object obj = ForwardSdkBaseOption.S;
        synchronized (obj) {
            if (this.I) {
                QLog.d("ForwardOption.ForwardSdkShareOption", 1, "-->sdk_share, checkAppinfoLocked, getappinfo already executing...");
                try {
                    obj.wait(20000L);
                } catch (InterruptedException e16) {
                    QLog.e("ForwardOption.ForwardSdkShareOption", 1, "check app info locked ex", e16);
                }
            } else if (this.J == null) {
                this.I = true;
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String string = this.mExtraData.getString("pkg_name");
                String o16 = com.tencent.open.agent.util.g.o(this.mActivity, string, currentTimeMillis + "");
                QLog.d("ForwardOption.ForwardSdkShareOption", 1, "-->sdk_share, checkAppinfoLocked, sign: " + o16 + ", appinfo is null.");
                ForwardStatisticsReporter.m("KEY_GET_APP_INFO");
                QQAppInterface qQAppInterface = this.app;
                Share.n(qQAppInterface, this.mActivity, qQAppInterface.getCurrentAccountUin(), this.f210818d, o16, currentTimeMillis, this.Q, string);
                try {
                    obj.wait(20000L);
                } catch (InterruptedException e17) {
                    QLog.e("ForwardOption.ForwardSdkShareOption", 1, "check app info locked ex", e17);
                }
            }
        }
        if (this.J == null) {
            QLog.d("ForwardOption.ForwardSdkShareOption", 1, "-->sdk_share, response is null.");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(11:8|(9:(1:(1:12))(1:34)|13|14|15|(1:17)(1:(1:27)(2:28|(1:30)(1:31)))|(3:(1:23)(1:(1:25))|20|21)|19|20|21)|35|13|14|15|(0)(0)|(0)|19|20|21) */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean realForwardTo() {
        int i3;
        int i16;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        int i17 = this.mExtraData.getInt("uintype");
        String string = this.mExtraData.getString("uin");
        m();
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 == 3000) {
                    i3 = 3;
                }
            } else {
                i3 = 2;
            }
            com.tencent.open.business.viareport.c.a().b(0, "SHARE_TO_QQ", this.app.getCurrentAccountUin(), String.valueOf(this.f210818d), String.valueOf(i3), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
            i16 = this.K;
            if (i16 != 1) {
                str = "1";
            } else if (i16 == 2) {
                str = "3";
            } else if (i16 == 5) {
                str = "2";
            } else {
                str = "4";
            }
            if (i17 != 0) {
                if (1 == i17) {
                    str2 = "2";
                } else if (3000 == i17) {
                    str2 = "3";
                }
                ReportCenter.f().o(this.app.getAccount(), "", this.f210818d + "", "10", "12", "0", str, string, str2, false, true);
                return true;
            }
            str2 = "1";
            ReportCenter.f().o(this.app.getAccount(), "", this.f210818d + "", "10", "12", "0", str, string, str2, false, true);
            return true;
        }
        i3 = 1;
        com.tencent.open.business.viareport.c.a().b(0, "SHARE_TO_QQ", this.app.getCurrentAccountUin(), String.valueOf(this.f210818d), String.valueOf(i3), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
        i16 = this.K;
        if (i16 != 1) {
        }
        if (i17 != 0) {
        }
        str2 = "1";
        ReportCenter.f().o(this.app.getAccount(), "", this.f210818d + "", "10", "12", "0", str, string, str2, false, true);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0208  */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int realShareToQfav() {
        String str;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, (Object) this)).intValue();
        }
        long j3 = 0;
        try {
            j3 = Long.valueOf(this.app.getAccount()).longValue();
            str = this.app.getCurrentNickname();
        } catch (Exception e16) {
            e16.printStackTrace();
            str = "";
        }
        String string = this.mExtraData.getString("app_name");
        int i26 = 1;
        int i27 = -1;
        if (this.mExtraData.getBoolean("key_sdk_share_pure_text")) {
            x("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--pure text share");
            if (TextUtils.isEmpty(this.mExtraData.getString("qqfav_extra_richmedia_title")) && TextUtils.isEmpty(this.mExtraData.getString("qqfav_extra_mixed_msg"))) {
                i16 = 0;
            } else {
                if (TextUtils.isEmpty(this.mExtraData.getString("qqfav_extra_richmedia_title"))) {
                    this.mExtraData.getString("qqfav_extra_mixed_msg");
                } else {
                    this.mExtraData.getString("qqfav_extra_richmedia_title");
                }
                if (QfavBuilder.h0(null, false, this.mExtraData.getString("qqfav_extra_richmedia_title"), this.mExtraData.getString("qqfav_extra_mixed_msg"), true, this.f210818d, string).B(j3, str).f(this.mActivity, this.app.getAccount(), -1, null, !Z())) {
                    i27 = 0;
                }
                i16 = 0;
            }
        } else {
            int i28 = 3;
            if (this.G instanceof StructMsgForImageShare) {
                x("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--image share");
                com.tencent.mobileqq.structmsg.view.e s16 = QfavUtil.s((StructMsgForImageShare) this.G);
                if (s16 != null) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(s16.R0);
                    int R = R(arrayList);
                    if (R != 0) {
                        i27 = R;
                    } else if (QfavBuilder.h0(arrayList, true, this.mIntent.getStringExtra("qqfav_extra_richmedia_title"), this.mIntent.getStringExtra("qqfav_extra_mixed_msg"), true, this.f210818d, string).B(j3, str).e(this.mActivity, this.app.getAccount(), -1, null)) {
                        i27 = 0;
                    }
                }
                i16 = 1;
                i3 = 3;
            } else if (this.mIntent.getBooleanExtra("qqfav_extra_pic_share", false)) {
                x("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--extra pic share");
                ArrayList<String> stringArrayList = this.mExtraData.getStringArrayList("qqfav_extra_multi_pic_path_list");
                boolean booleanExtra = this.mIntent.getBooleanExtra("qqfav_extra_only_pic", true);
                if (stringArrayList != null && !stringArrayList.isEmpty()) {
                    int R2 = R(stringArrayList);
                    if (R2 != 0) {
                        i27 = R2;
                    } else if (QfavBuilder.h0(stringArrayList, booleanExtra, this.mIntent.getStringExtra("qqfav_extra_richmedia_title"), this.mIntent.getStringExtra("qqfav_extra_mixed_msg"), true, this.f210818d, string).B(j3, str).e(this.mActivity, this.app.getAccount(), -1, null)) {
                        i27 = 0;
                    }
                    if (!booleanExtra || 1 != stringArrayList.size()) {
                        i28 = 8;
                    }
                    i19 = stringArrayList.size();
                    i26 = i28;
                } else {
                    i26 = 8;
                    i19 = 0;
                }
                i16 = i19;
            } else if (this.G != null) {
                x("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--default share");
                byte[] g16 = QfavUtil.g(this.G.getXmlBytes());
                AbsShareMsg absShareMsg = this.G;
                if (absShareMsg instanceof StructMsgForAudioShare) {
                    i17 = 10;
                    i18 = 2;
                } else {
                    i17 = 2;
                    i18 = 0;
                }
                i3 = i17;
                i16 = 0;
                if (QfavBuilder.Z(i18, absShareMsg.mContentTitle, absShareMsg.mMsgUrl, absShareMsg.mSourceName, absShareMsg.mContentSummary, absShareMsg.mContentCover, absShareMsg.mContentSrc, g16, true, this.f210818d).B(j3, str).e(this.mActivity, this.app.getAccount(), -1, null)) {
                    i27 = 0;
                }
            } else {
                i3 = -1;
                i16 = 0;
            }
            if (i27 == 0) {
                cooperation.qqfav.d.d(this.app, "User_AddFav", i3, 0, 69, i16, "", "");
            }
            return i27;
        }
        i3 = i26;
        if (i27 == 0) {
        }
        return i27;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void reportForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
            return;
        }
        super.reportForward();
        if (isMultiTarget2Send()) {
            ForwardUtils.h0(this.app, "0X800A734", X());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void sendDatalineMultiple(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) intent);
        } else {
            super.sendDatalineMultiple(intent);
            g0(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void sendDatalineSingle(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) intent);
        } else {
            super.sendDatalineSingle(intent);
            g0(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void showQfavResultDialog(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, i3);
            return;
        }
        boolean z16 = false;
        if (!this.mIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false) && !this.mIntent.getBooleanExtra("qqfav_extra_from_system_share", false)) {
            super.showQfavResultDialog(i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->showQfavResultDialog--ret = " + i3);
        }
        if (i3 == 0) {
            SharedPreferences sharedPreferences = this.mActivity.getSharedPreferences("mobileQQ", 0);
            String str = "favorites_first_share_" + this.app.getAccount();
            boolean z17 = sharedPreferences.getBoolean(str, true);
            if (!z17) {
                QfavUtil.Q(this.mActivity, R.string.f171444f03, 2);
            } else {
                sharedPreferences.edit().putBoolean(str, false).commit();
                String string = this.mActivity.getString(R.string.f171443f02);
                String string2 = this.mExtraData.getString("app_name");
                StringBuilder sb5 = new StringBuilder();
                sb5.append(string);
                if (TextUtils.isEmpty(string2)) {
                    string2 = this.mActivity.getString(R.string.ezu);
                }
                sb5.append(string2);
                String sb6 = sb5.toString();
                Activity activity = this.mActivity;
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, activity.getResources().getString(R.string.hjc), this.mActivity.getResources().getString(R.string.ezw), sb6, this.mActivity.getResources().getString(R.string.cou), new a(), new b());
                createCustomDialog.setOnDismissListener(new c());
                if (!this.mActivity.isFinishing()) {
                    this.mConfirmDialog.setOnDismissListener(null);
                    createCustomDialog.show();
                }
            }
            z16 = z17;
        } else if (2 == i3) {
            QfavUtil.Q(this.mActivity, R.string.cwk, 1);
        } else if (3 == i3) {
            QfavUtil.Q(this.mActivity, R.string.f171442f01, 1);
        } else {
            QfavUtil.Q(this.mActivity, R.string.ezv, 1);
        }
        if (!z16) {
            ForwardSdkBaseOption.F(this.mActivity, true, "addToQQFavorites", this.f210818d);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardSdkBaseOption
    public int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        AbsShareMsg absShareMsg = this.G;
        if (absShareMsg != null) {
            return absShareMsg.mMsgServiceID;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.forward.ForwardSdkBaseOption
    public void y() {
        super.y();
        if (isMultiTarget2Send() && this.isSdkShare) {
            ForwardUtils.l(this.mActivity);
        }
    }
}
