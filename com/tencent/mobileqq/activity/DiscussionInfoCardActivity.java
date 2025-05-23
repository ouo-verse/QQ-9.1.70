package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.config.AppSetting;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.j;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.widget.FollowImageTextView;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.h;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import cooperation.qzone.QZoneShareManager;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DiscussionInfoCardActivity extends IphoneTitleBarActivity implements View.OnClickListener, ShareActionSheet.OnItemClickListener {
    static IPatchRedirector $redirector_;
    private final int A0;
    private final int B0;
    private final int C0;
    private final int D0;
    private final int E0;
    private final int F0;
    protected final int G0;
    protected final int H0;
    protected final int I0;
    protected final int J0;
    protected final int K0;
    protected DiscussionInfo L0;
    protected QQProgressDialog M0;
    protected Dialog N0;
    protected ShareActionSheet O0;
    protected WXShareHelper.a P0;
    protected String Q0;
    protected long R0;
    protected String S0;
    protected String T0;
    protected boolean U0;
    private List<DiscussionMemberInfo> V0;
    protected String W0;
    MqqHandler X0;
    com.tencent.mobileqq.app.ar Y0;
    com.tencent.mobileqq.discussion.observer.a Z0;

    /* renamed from: a0, reason: collision with root package name */
    private DiscussionHandler f175551a0;

    /* renamed from: a1, reason: collision with root package name */
    ProfileCardObserver f175552a1;

    /* renamed from: b0, reason: collision with root package name */
    private com.tencent.mobileqq.app.n f175553b0;

    /* renamed from: b1, reason: collision with root package name */
    com.tencent.mobileqq.troop.api.observer.b f175554b1;

    /* renamed from: c0, reason: collision with root package name */
    private MyGridView f175555c0;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f175556d0;

    /* renamed from: e0, reason: collision with root package name */
    private View f175557e0;

    /* renamed from: f0, reason: collision with root package name */
    protected FollowImageTextView f175558f0;

    /* renamed from: g0, reason: collision with root package name */
    private FormSimpleItem f175559g0;

    /* renamed from: h0, reason: collision with root package name */
    private FormSimpleItem f175560h0;

    /* renamed from: i0, reason: collision with root package name */
    private FormSimpleItem f175561i0;

    /* renamed from: j0, reason: collision with root package name */
    private FormSimpleItem f175562j0;

    /* renamed from: k0, reason: collision with root package name */
    private FormSwitchItem f175563k0;

    /* renamed from: l0, reason: collision with root package name */
    private FormSwitchItem f175564l0;

    /* renamed from: m0, reason: collision with root package name */
    private n f175565m0;

    /* renamed from: n0, reason: collision with root package name */
    private QQProgressDialog f175566n0;

    /* renamed from: o0, reason: collision with root package name */
    View f175567o0;

    /* renamed from: p0, reason: collision with root package name */
    private String f175568p0;

    /* renamed from: q0, reason: collision with root package name */
    private String f175569q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f175570r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f175571s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f175572t0;

    /* renamed from: u0, reason: collision with root package name */
    private int f175573u0;

    /* renamed from: v0, reason: collision with root package name */
    private int f175574v0;

    /* renamed from: w0, reason: collision with root package name */
    private int f175575w0;

    /* renamed from: x0, reason: collision with root package name */
    private int f175576x0;

    /* renamed from: y0, reason: collision with root package name */
    private Intent f175577y0;

    /* renamed from: z0, reason: collision with root package name */
    private long f175578z0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends com.tencent.mobileqq.app.ar {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionInfoCardActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetComment(boolean z16, String str, String str2, byte b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, str2, Byte.valueOf(b16));
                return;
            }
            if (z16) {
                DiscussionInfoCardActivity.this.J3();
                DiscussionInfoCardActivity discussionInfoCardActivity = DiscussionInfoCardActivity.this;
                discussionInfoCardActivity.K3(discussionInfoCardActivity.f175568p0);
                DiscussionInfoCardActivity.this.f175565m0.notifyDataSetChanged();
                return;
            }
            QQProgressDialog qQProgressDialog = DiscussionInfoCardActivity.this.M0;
            if (qQProgressDialog != null && qQProgressDialog.isShowing() && !DiscussionInfoCardActivity.this.isFinishing()) {
                DiscussionInfoCardActivity.this.M0.dismiss();
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
                return;
            }
            if (z16) {
                DiscussionInfo discussionInfo = DiscussionInfoCardActivity.this.L0;
                if (discussionInfo != null && discussionInfo.ownerUin != null) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(DiscussionInfoCardActivity.this.L0.ownerUin + ""), "DiscussionInfoCardActivity");
                    if (friendsSimpleInfoWithUid != null) {
                        DiscussionInfoCardActivity.this.W0 = friendsSimpleInfoWithUid.p();
                        return;
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionInfoCardActivity", 2, "onUpdateFriendInfo get owner name failed");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends com.tencent.mobileqq.discussion.observer.a {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                Dialog dialog = DiscussionInfoCardActivity.this.N0;
                if (dialog != null && dialog.isShowing() && DiscussionInfoCardActivity.this.N0.getWindow() != null) {
                    DiscussionInfoCardActivity.this.N0.dismiss();
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.DiscussionInfoCardActivity$b$b, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        class DialogInterfaceOnClickListenerC7098b implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f175595d;

            DialogInterfaceOnClickListenerC7098b(String str) {
                this.f175595d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) str);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                if (com.tencent.mobileqq.app.n.y()) {
                    DiscussionInfoCardActivity.this.f175553b0.d(this.f175595d);
                    RecentUserProxy m3 = DiscussionInfoCardActivity.this.app.getProxyManager().m();
                    m3.delRecentUser(m3.findRecentUserByUin(this.f175595d, 3000));
                    Intent intent = new Intent();
                    intent.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
                    DiscussionInfoCardActivity.this.setResult(-1, intent);
                    DiscussionInfoCardActivity.this.finish();
                }
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionInfoCardActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void f(boolean z16, int i3, long j3, ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), arrayList);
            } else if (z16 && j3 == Long.valueOf(DiscussionInfoCardActivity.this.f175569q0).longValue()) {
                DiscussionInfoCardActivity.this.l3();
                DiscussionInfoCardActivity discussionInfoCardActivity = DiscussionInfoCardActivity.this;
                discussionInfoCardActivity.showToast(2, discussionInfoCardActivity.getString(R.string.f170041dp));
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void g(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str);
                return;
            }
            if (DiscussionInfoCardActivity.this.f175569q0.equals(str)) {
                if (z16) {
                    DiscussionInfo h16 = DiscussionInfoCardActivity.this.f175553b0.h(str);
                    if (h16 != null) {
                        DiscussionInfoCardActivity.this.f175568p0 = h16.discussionName;
                        DiscussionInfoCardActivity discussionInfoCardActivity = DiscussionInfoCardActivity.this;
                        discussionInfoCardActivity.K3(discussionInfoCardActivity.f175568p0);
                    }
                    if (DiscussionInfoCardActivity.this.f175566n0 != null && DiscussionInfoCardActivity.this.f175566n0.isShowing() && !DiscussionInfoCardActivity.this.isFinishing()) {
                        DiscussionInfoCardActivity.this.f175566n0.setMessage(DiscussionInfoCardActivity.this.getString(R.string.f170714zq));
                        DiscussionInfoCardActivity.this.f175566n0.setTipImageView(R.drawable.f160604l9);
                        DiscussionInfoCardActivity.this.f175566n0.showProgerss(false);
                        DiscussionInfoCardActivity.this.X0.sendEmptyMessageDelayed(17, 1500L);
                        return;
                    }
                    return;
                }
                DiscussionInfoCardActivity discussionInfoCardActivity2 = DiscussionInfoCardActivity.this;
                discussionInfoCardActivity2.K3(discussionInfoCardActivity2.f175568p0);
                if (DiscussionInfoCardActivity.this.f175566n0 != null && DiscussionInfoCardActivity.this.f175566n0.isShowing() && !DiscussionInfoCardActivity.this.isFinishing()) {
                    DiscussionInfoCardActivity.this.f175566n0.setMessage(DiscussionInfoCardActivity.this.getString(R.string.f170712zo));
                    DiscussionInfoCardActivity.this.f175566n0.setTipImageView(R.drawable.f160604l9);
                    DiscussionInfoCardActivity.this.f175566n0.showProgerss(false);
                    DiscussionInfoCardActivity.this.X0.sendEmptyMessageDelayed(17, 1500L);
                }
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void h(boolean z16, Long l3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), l3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionInfoCardActivity", 2, "onCollectDiscussion isSuccess:" + z16 + " uin:" + l3);
            }
            if (z16 && l3 != null && String.valueOf(l3).equals(DiscussionInfoCardActivity.this.f175569q0)) {
                ReportController.o(DiscussionInfoCardActivity.this.app, "CliOper", "", "", "discuss", "discuss_common", 0, 0, "", "", "", "");
                if (!DiscussionInfoCardActivity.this.isFinishing()) {
                    SharedPreferences sharedPreferences = DiscussionInfoCardActivity.this.app.getApp().getSharedPreferences(DiscussionInfoCardActivity.this.app.getCurrentAccountUin(), 0);
                    if (sharedPreferences.getBoolean(AppConstants.Preferences.MULTI_CHAT_SET_COMMON_USE_KEY, true)) {
                        DiscussionInfoCardActivity discussionInfoCardActivity = DiscussionInfoCardActivity.this;
                        discussionInfoCardActivity.N0 = DialogUtil.createCustomDialog(discussionInfoCardActivity, 230, discussionInfoCardActivity.getString(R.string.cdu), DiscussionInfoCardActivity.this.getString(R.string.cdt), R.string.cancel, R.string.hsi, new a(), (DialogInterface.OnClickListener) null);
                        DiscussionInfoCardActivity.this.N0.show();
                        sharedPreferences.edit().putBoolean(AppConstants.Preferences.MULTI_CHAT_SET_COMMON_USE_KEY, false).commit();
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void n(boolean z16, int i3, long j3, String str, String str2, long j16) {
            String qqStr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), str, str2, Long.valueOf(j16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionInfoCardActivity", 2, "onGetFlyTicket: " + z16);
            }
            if (!z16) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        qqStr = HardCodeUtil.qqStr(R.string.lnw);
                    } else {
                        qqStr = HardCodeUtil.qqStr(R.string.lo7);
                    }
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.loa);
                }
                DiscussionInfoCardActivity.this.showToast(R.drawable.f160601l6, qqStr);
                return;
            }
            SharedPreferences.Editor edit = DiscussionInfoCardActivity.this.getSharedPreferences("qrcode", 0).edit();
            edit.putLong("discussionvalidtime" + DiscussionInfoCardActivity.this.f175569q0, j3);
            edit.putString("discussion" + DiscussionInfoCardActivity.this.f175569q0, str2);
            edit.putString("discussionfullSig" + DiscussionInfoCardActivity.this.f175569q0, str);
            edit.commit();
            DiscussionInfoCardActivity discussionInfoCardActivity = DiscussionInfoCardActivity.this;
            discussionInfoCardActivity.R0 = j3;
            discussionInfoCardActivity.S0 = str2;
            discussionInfoCardActivity.T0 = str;
            discussionInfoCardActivity.U0 = true;
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void o(Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) objArr);
                return;
            }
            String str = (String) objArr[0];
            int intValue = ((Integer) objArr[1]).intValue();
            String str2 = (String) objArr[2];
            if (str2 == null || str2.trim().equals("")) {
                str2 = DiscussionInfoCardActivity.this.getString(R.string.f171021bp4);
            }
            String str3 = str2;
            if (DiscussionInfoCardActivity.this.f175569q0.equals(str) && !DiscussionInfoCardActivity.this.isFinishing()) {
                if (10001 != intValue && 10002 != intValue) {
                    DiscussionInfoCardActivity.this.showToast(1, str3);
                } else {
                    DialogUtil.createCustomDialog(DiscussionInfoCardActivity.this, 230, null, str3, new DialogInterfaceOnClickListenerC7098b(str), null).show();
                }
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void q(boolean z16, Long l3, Long l16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), l3, l16);
                return;
            }
            if (z16 && l3 != null && String.valueOf(l3).equals(DiscussionInfoCardActivity.this.f175569q0)) {
                DiscussionInfoCardActivity.this.l3();
            } else {
                DiscussionInfoCardActivity discussionInfoCardActivity = DiscussionInfoCardActivity.this;
                QQToast.makeText(discussionInfoCardActivity, 1, discussionInfoCardActivity.getString(R.string.ati), 0).show(DiscussionInfoCardActivity.this.getTitleBarHeight());
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void r(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str);
                return;
            }
            if (DiscussionInfoCardActivity.this.f175569q0.equals(str)) {
                if (z16) {
                    if (DiscussionInfoCardActivity.this.f175566n0 != null && DiscussionInfoCardActivity.this.f175566n0.isShowing() && !DiscussionInfoCardActivity.this.isFinishing()) {
                        DiscussionInfoCardActivity.this.f175566n0.setMessage(DiscussionInfoCardActivity.this.getString(R.string.b1d));
                        DiscussionInfoCardActivity.this.f175566n0.setTipImageView(R.drawable.f160604l9);
                        DiscussionInfoCardActivity.this.f175566n0.showProgerss(false);
                        DiscussionInfoCardActivity.this.X0.sendEmptyMessageDelayed(16, 1500L);
                        return;
                    }
                    return;
                }
                if (DiscussionInfoCardActivity.this.f175566n0 != null && DiscussionInfoCardActivity.this.f175566n0.isShowing() && !DiscussionInfoCardActivity.this.isFinishing()) {
                    DiscussionInfoCardActivity.this.f175566n0.setMessage(DiscussionInfoCardActivity.this.getString(R.string.b1a));
                    DiscussionInfoCardActivity.this.f175566n0.setTipImageView(R.drawable.f160601l6);
                    DiscussionInfoCardActivity.this.f175566n0.showProgerss(false);
                    DiscussionInfoCardActivity.this.X0.sendEmptyMessageDelayed(17, 1500L);
                }
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void s(boolean z16, Long l3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), l3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionInfoCardActivity", 2, "onUncollectDiscussion isSuccess:" + z16 + " uin:" + l3);
            }
            if (z16 && l3 != null) {
                String.valueOf(l3).equals(DiscussionInfoCardActivity.this.f175569q0);
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void w(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), obj);
                return;
            }
            ArrayList arrayList = (ArrayList) obj;
            int indexOf = arrayList.indexOf(DiscussionInfoCardActivity.this.f175569q0);
            if (indexOf != -1) {
                Boolean bool = (Boolean) arrayList.get(indexOf + 1);
                if (z16 && bool.booleanValue()) {
                    DiscussionInfoCardActivity discussionInfoCardActivity = DiscussionInfoCardActivity.this;
                    discussionInfoCardActivity.L0 = discussionInfoCardActivity.f175553b0.h(DiscussionInfoCardActivity.this.f175569q0);
                    DiscussionInfoCardActivity.this.l3();
                    DiscussionInfoCardActivity.this.J3();
                    DiscussionInfoCardActivity.this.L3();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends ProfileCardObserver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionInfoCardActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        protected void onGetProfileCard(boolean z16, Object obj) {
            Card card;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (obj instanceof Card) {
                card = (Card) obj;
            } else {
                card = null;
            }
            if (z16 && card != null && DiscussionInfoCardActivity.this.f175565m0 != null) {
                DiscussionInfoCardActivity.this.f175565m0.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d implements WXShareHelper.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionInfoCardActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseResp);
                return;
            }
            String str = DiscussionInfoCardActivity.this.Q0;
            if (str != null && str.equals(baseResp.transaction) && (i3 = baseResp.errCode) != -2) {
                if (i3 != 0) {
                    com.tencent.biz.qrcode.util.h.T(1, R.string.hit);
                } else {
                    com.tencent.biz.qrcode.util.h.T(2, R.string.hj9);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f175599d;

        e(ActionSheet actionSheet) {
            this.f175599d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionInfoCardActivity.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 0) {
                if (NetworkUtil.isNetSupport(DiscussionInfoCardActivity.this.getActivity())) {
                    ReportController.o(DiscussionInfoCardActivity.this.app, "CliOper", "", "", "0X80040EA", "0X80040EA", 0, 0, "", "", "", "");
                    ReportController.o(DiscussionInfoCardActivity.this.app, "CliOper", "", "", "0X8006669", "0X8006669", 0, 0, "", "", "", "");
                    DiscussionInfoCardActivity.this.f175551a0.g4(Long.valueOf(DiscussionInfoCardActivity.this.f175569q0).longValue());
                    DiscussionInfoCardActivity discussionInfoCardActivity = DiscussionInfoCardActivity.this;
                    discussionInfoCardActivity.s3(discussionInfoCardActivity.getString(R.string.b1b));
                    DiscussionInfoCardActivity.this.f175566n0.show();
                } else {
                    DiscussionInfoCardActivity discussionInfoCardActivity2 = DiscussionInfoCardActivity.this;
                    discussionInfoCardActivity2.showToast(1, discussionInfoCardActivity2.getString(R.string.cjm));
                }
            }
            this.f175599d.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class f extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionInfoCardActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void j(boolean z16, int i3, String str, String str2, Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2, bool);
                return;
            }
            DiscussionInfoCardActivity.this.p3();
            if (z16) {
                if (bool.booleanValue()) {
                    DiscussionInfoCardActivity.this.C3();
                    return;
                }
                return;
            }
            QQToast.makeText(DiscussionInfoCardActivity.this, i3, 0).show(DiscussionInfoCardActivity.this.getTitleBarHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionInfoCardActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                DiscussionInfoCardActivity.this.F3();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionInfoCardActivity.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FollowImageTextView followImageTextView;
            float f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent != null && (followImageTextView = DiscussionInfoCardActivity.this.f175558f0) != null) {
                if (motionEvent.getAction() == 0) {
                    f16 = 0.5f;
                } else {
                    f16 = 1.0f;
                }
                followImageTextView.setAlpha(f16);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionInfoCardActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            String str;
            String str2;
            String str3;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                if (AppSetting.f99565y) {
                    DiscussionInfoCardActivity.this.f175564l0.setContentDescription(DiscussionInfoCardActivity.this.getString(R.string.ats));
                }
                DiscussionMemberInfo l3 = DiscussionInfoCardActivity.this.f175553b0.l(DiscussionInfoCardActivity.this.f175569q0, DiscussionInfoCardActivity.this.app.getCurrentAccountUin());
                if (l3 != null) {
                    byte b16 = l3.flag;
                    if (z16) {
                        l3.flag = (byte) (b16 | 1);
                    } else {
                        l3.flag = (byte) (b16 & (-2));
                    }
                    byte b17 = l3.flag;
                    if (b16 != b17) {
                        byte b18 = (byte) (b17 & 1);
                        if (QLog.isDevelopLevel()) {
                            QLog.d("DiscussionInfoCardActivity", 4, "DiscussionMemberInfo.flag changed save now:" + ((int) l3.flag) + " flag:" + ((int) b18));
                        }
                        DiscussionInfoCardActivity.this.f175551a0.n4(Long.valueOf(DiscussionInfoCardActivity.this.f175569q0).longValue(), b18, l3.flag);
                        if (z16) {
                            str3 = "msg_open";
                        } else {
                            str3 = "msg_close";
                        }
                        DiscussionInfoCardActivity discussionInfoCardActivity = DiscussionInfoCardActivity.this;
                        com.tencent.mobileqq.utils.eu.g("Grp_Dis_set", "Dis_info", str3, 0, 0, DiscussionInfoCardActivity.this.f175569q0, DiscussionInfoCardActivity.j3(discussionInfoCardActivity.app, discussionInfoCardActivity.L0));
                    }
                    QQAppInterface qQAppInterface = DiscussionInfoCardActivity.this.app;
                    if (z16) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    ReportController.o(qQAppInterface, "CliOper", "", "", "0X800629B", "0X800629B", 0, 0, str, "", "", "");
                    QQAppInterface qQAppInterface2 = DiscussionInfoCardActivity.this.app;
                    if (z16) {
                        str2 = "1";
                    } else {
                        str2 = "0";
                    }
                    ReportController.o(qQAppInterface2, "CliOper", "", "", "0X8006679", "0X8006679", 0, 0, str2, "", "", "");
                    ReportController.o(DiscussionInfoCardActivity.this.app, "CliOper", "", "", "0X8006668", "0X8006668", 0, 0, "", "", "", "");
                }
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionInfoCardActivity.this);
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
                if (AppSetting.f99565y) {
                    DiscussionInfoCardActivity.this.f175563k0.setContentDescription(DiscussionInfoCardActivity.this.getString(R.string.bnr));
                }
                boolean b46 = DiscussionInfoCardActivity.this.f175551a0.b4(DiscussionInfoCardActivity.this.L0);
                DiscussionInfoCardActivity.this.f175551a0.p4(DiscussionInfoCardActivity.this.L0, !b46);
                com.tencent.mobileqq.statistics.q f16 = new com.tencent.mobileqq.statistics.q(DiscussionInfoCardActivity.this.app).i("dc00899").a("Grp_Dis_set").f("Dis_info");
                if (b46) {
                    str = "Clk_unstick";
                } else {
                    str = "Clk_stick";
                }
                f16.d(str).g();
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class k implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f175605d;

        k(ActionSheet actionSheet) {
            this.f175605d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionInfoCardActivity.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        DiscussionInfoCardActivity.this.G3();
                    }
                } else {
                    DiscussionInfoCardActivity discussionInfoCardActivity = DiscussionInfoCardActivity.this;
                    String str = discussionInfoCardActivity.L0.uin;
                    Bundle G = NewReportPlugin.G(discussionInfoCardActivity.f175569q0, 3000);
                    DiscussionInfoCardActivity discussionInfoCardActivity2 = DiscussionInfoCardActivity.this;
                    NewReportPlugin.S(discussionInfoCardActivity2, discussionInfoCardActivity2.f175569q0, "", "", str, DiscussionInfoCardActivity.this.app.getCurrentAccountUin(), 22001, null, G);
                    DiscussionInfoCardActivity discussionInfoCardActivity3 = DiscussionInfoCardActivity.this;
                    com.tencent.mobileqq.utils.eu.g("Grp_Dis_set", "Dis_info", "clk_report", 0, 0, DiscussionInfoCardActivity.this.f175569q0, DiscussionInfoCardActivity.j3(discussionInfoCardActivity3.app, discussionInfoCardActivity3.L0));
                }
            } else {
                DiscussionInfoCardActivity.this.z3();
            }
            ActionSheet actionSheet = this.f175605d;
            if (actionSheet != null && actionSheet.isShowing() && !DiscussionInfoCardActivity.this.isFinishing()) {
                this.f175605d.dismiss();
                this.f175605d.cancel();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class l implements h.a {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionInfoCardActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.h.a
        public void a(Dialog dialog, View view, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, dialog, view, Boolean.valueOf(z16));
                return;
            }
            DiscussionInfoCardActivity.this.app.getMessageFacade().q(DiscussionInfoCardActivity.this.f175569q0, 3000);
            DiscussionInfoCardActivity.this.app.getMessageFacade().m0(DiscussionInfoCardActivity.this.f175569q0, 3000);
            MqqHandler handler = DiscussionInfoCardActivity.this.app.getHandler(Conversation.class);
            Message obtainMessage = handler.obtainMessage(1017);
            obtainMessage.obj = DiscussionInfoCardActivity.this.f175569q0;
            obtainMessage.arg1 = 3000;
            handler.sendMessage(obtainMessage);
            DiscussionInfoCardActivity discussionInfoCardActivity = DiscussionInfoCardActivity.this;
            QQToast.makeText(discussionInfoCardActivity, 2, discussionInfoCardActivity.getString(R.string.a3m), 0).show();
            View view2 = DiscussionInfoCardActivity.this.f175567o0;
            if (view2 != null) {
                ((TextView) view2.findViewById(R.id.title)).setTextColor(Color.parseColor("#cccccc"));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class m extends MqqHandler {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionInfoCardActivity.this);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 != 16711681) {
                    if (i3 != 16) {
                        if (i3 == 17 && DiscussionInfoCardActivity.this.f175566n0 != null && DiscussionInfoCardActivity.this.f175566n0.isShowing() && !DiscussionInfoCardActivity.this.isFinishing()) {
                            DiscussionInfoCardActivity.this.f175566n0.dismiss();
                            return;
                        }
                        return;
                    }
                    if (DiscussionInfoCardActivity.this.f175566n0 != null && DiscussionInfoCardActivity.this.f175566n0.isShowing()) {
                        DiscussionInfoCardActivity.this.f175566n0.dismiss();
                    }
                    Intent intent = new Intent();
                    intent.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
                    DiscussionInfoCardActivity.this.setResult(-1, intent);
                    DiscussionInfoCardActivity.this.finish();
                    return;
                }
                if (DiscussionInfoCardActivity.this.f175570r0 == 0) {
                    String str = (String) message.obj;
                    if (DiscussionInfoCardActivity.this.f175569q0 != null && str != null && DiscussionInfoCardActivity.this.f175569q0.equals(str)) {
                        DiscussionInfoCardActivity.this.finish();
                        return;
                    }
                    return;
                }
                return;
            }
            if (DiscussionInfoCardActivity.this.f175570r0 == 3000) {
                DiscussionInfoCardActivity discussionInfoCardActivity = DiscussionInfoCardActivity.this;
                if (discussionInfoCardActivity.L0 != null) {
                    discussionInfoCardActivity.K3(discussionInfoCardActivity.f175568p0);
                } else {
                    discussionInfoCardActivity.f175558f0.setText(discussionInfoCardActivity.getString(R.string.f171130ce0));
                    if (AppSetting.f99565y) {
                        DiscussionInfoCardActivity.this.f175558f0.setContentDescription(HardCodeUtil.qqStr(R.string.lnx) + DiscussionInfoCardActivity.this.getString(R.string.f171130ce0) + HardCodeUtil.qqStr(R.string.lnp));
                    }
                }
            }
            ArrayList arrayList = (ArrayList) message.obj;
            int size = arrayList.size();
            DiscussionInfoCardActivity.this.f175556d0.setText(HardCodeUtil.qqStr(R.string.lnr) + size + HardCodeUtil.qqStr(R.string.lns));
            DiscussionInfoCardActivity.this.f175555c0.setPadding(DiscussionInfoCardActivity.this.f175572t0, DiscussionInfoCardActivity.this.f175574v0, DiscussionInfoCardActivity.this.f175573u0, DiscussionInfoCardActivity.this.f175575w0);
            DiscussionInfoCardActivity.this.V0 = arrayList;
            if (DiscussionInfoCardActivity.this.f175565m0 == null) {
                DiscussionInfoCardActivity.this.f175565m0 = new n();
                DiscussionInfoCardActivity.this.f175555c0.setAdapter((ListAdapter) DiscussionInfoCardActivity.this.f175565m0);
            } else {
                DiscussionInfoCardActivity.this.f175565m0.notifyDataSetChanged();
            }
            removeMessages(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private class n extends BaseAdapter {
        static IPatchRedirector $redirector_;

        public n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionInfoCardActivity.this);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (DiscussionInfoCardActivity.this.V0 == null) {
                return 1;
            }
            return 1 + DiscussionInfoCardActivity.this.V0.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            if (DiscussionInfoCardActivity.this.V0 != null && i3 < DiscussionInfoCardActivity.this.V0.size()) {
                return DiscussionInfoCardActivity.this.V0.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            o oVar;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view3 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                if (view == null) {
                    view2 = DiscussionInfoCardActivity.this.getLayoutInflater().inflate(R.layout.f167752g4, (ViewGroup) null);
                    oVar = new o();
                    oVar.f175610a = (QQProAvatarView) view2.findViewById(R.id.icon);
                    oVar.f175611b = (TextView) view2.findViewById(R.id.f5e);
                    view2.setTag(oVar);
                } else {
                    oVar = (o) view.getTag();
                    view2 = view;
                }
                view2.setVisibility(0);
                view2.setFocusable(false);
                TextView textView = oVar.f175611b;
                QQProAvatarView qQProAvatarView = oVar.f175610a;
                if (i3 == getCount() - 1) {
                    String string = DiscussionInfoCardActivity.this.getString(R.string.bzl);
                    textView.setText(string);
                    textView.setTextColor(DiscussionInfoCardActivity.this.getResources().getColor(R.color.skin_blue));
                    qQProAvatarView.setBackgroundDrawable(null);
                    qQProAvatarView.setImageResource(R.drawable.f160463hm);
                    qQProAvatarView.setTag(string);
                    if (DiscussionInfoCardActivity.this.L0.isDiscussHrMeeting() && QAVHrMeeting.m(DiscussionInfoCardActivity.this.L0.mSelfRight)) {
                        qQProAvatarView.setEnabled(false);
                    } else {
                        qQProAvatarView.setEnabled(true);
                    }
                } else {
                    String str = "";
                    if (i3 > getCount() - 1) {
                        textView.setText("");
                        qQProAvatarView.setBackgroundDrawable(null);
                        qQProAvatarView.setImageDrawable(null);
                    } else {
                        qQProAvatarView.setImageResource(R.drawable.abe);
                        textView.setTextColor(DiscussionInfoCardActivity.this.getResources().getColor(R.color.skin_black));
                        String str2 = ((DiscussionMemberInfo) DiscussionInfoCardActivity.this.V0.get(i3)).memberUin;
                        oVar.f175612c = str2;
                        DiscussionInfoCardActivity discussionInfoCardActivity = DiscussionInfoCardActivity.this;
                        String n3 = com.tencent.mobileqq.utils.ac.n(discussionInfoCardActivity.app, discussionInfoCardActivity.f175569q0, str2);
                        if (TextUtils.isEmpty(str2)) {
                            if (n3 != null) {
                                str = n3;
                            }
                            textView.setText(str);
                            qQProAvatarView.setImageDrawable(BaseImageUtil.getDefaultFaceDrawable());
                        } else {
                            if (TextUtils.isEmpty(n3) && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2), "DiscussionInfoCardActivity")) {
                                n3 = com.tencent.mobileqq.utils.ac.F(DiscussionInfoCardActivity.this.app, str2);
                            }
                            if (TextUtils.isEmpty(n3)) {
                                n3 = str2;
                            }
                            textView.setText(n3);
                            oVar.f175610a.x(1, str2, null);
                            qQProAvatarView.setTag(str2);
                            qQProAvatarView.setTag(R.id.jax, n3);
                        }
                    }
                }
                if (AppSetting.f99565y) {
                    ViewCompat.setImportantForAccessibility(qQProAvatarView, 2);
                }
                qQProAvatarView.setOnClickListener(DiscussionInfoCardActivity.this);
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class o {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public QQProAvatarView f175610a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f175611b;

        /* renamed from: c, reason: collision with root package name */
        public String f175612c;

        /* renamed from: d, reason: collision with root package name */
        public int f175613d;

        public o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f175613d = 1;
            }
        }
    }

    public DiscussionInfoCardActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f175571s0 = false;
        this.f175572t0 = 0;
        this.f175573u0 = 0;
        this.f175574v0 = 0;
        this.f175575w0 = 0;
        this.f175576x0 = 4;
        this.A0 = 0;
        this.B0 = 1;
        this.C0 = 2;
        this.D0 = 3;
        this.E0 = 8;
        this.F0 = 9;
        this.G0 = 10;
        this.H0 = 11;
        this.I0 = 0;
        this.J0 = 1;
        this.K0 = 2;
        this.U0 = false;
        this.X0 = new m();
        this.Y0 = new a();
        this.Z0 = new b();
        this.f175552a1 = new c();
        this.f175554b1 = new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C3() {
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
        m3.putExtra("uin", this.f175569q0);
        m3.putExtra("uinname", this.f175568p0);
        m3.putExtra("uintype", this.f175570r0);
        m3.putExtra("isNeedUpdate", this.f175571s0);
        startActivity(m3);
    }

    private void D3() {
        ReportController.o(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
        IConfigProxy iConfigProxy = VasLongToggle.VAS_BGSHOP_KRCONFIG;
        if (iConfigProxy.isEnable(false)) {
            String stringData = iConfigProxy.getStringData("");
            if (!TextUtils.isEmpty(stringData)) {
                HashMap hashMap = new HashMap();
                hashMap.put("frienduin", this.f175569q0);
                hashMap.put("uintype", String.valueOf(this.f175570r0));
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openKuiklySchema(this, stringData, hashMap);
                return;
            }
        }
        Intent intent = new Intent();
        intent.putExtra(VasWebviewConstants.KEY_VAS_USE_PREWEBVIEW, true);
        intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
        intent.putExtra("show_right_close_button", false);
        intent.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_AIO_BACKGROUND_SETTING);
        intent.putExtra("chatbg_intent_frinedUin", this.f175569q0);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("uintype", this.f175570r0);
        intent.putExtra("bg_replace_entrance", 62);
        VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.getMarketUrl(this, "background", ""), 33554432L, intent, true, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F3() {
        ReportController.o(this.app, "CliOper", "", "", "0X80040F4", "0X80040F4", 0, 0, "", "", "", "");
        com.tencent.mobileqq.utils.eu.g("Grp_Dis_set", "Dis_info", "clk_editName", 0, 0, this.f175569q0, j3(this.app, this.L0));
        Intent intent = new Intent(this, (Class<?>) EditActivity.class);
        this.f175577y0 = intent;
        intent.putExtra("title", R.string.atv);
        this.f175577y0.putExtra("limit", 48);
        this.f175577y0.putExtra("action", 102);
        this.f175577y0.putExtra("current", this.f175568p0);
        this.f175577y0.putExtra("canPostNull", false);
        this.f175577y0.putExtra("multiLine", false);
        startActivityForResult(this.f175577y0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G3() {
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
        actionSheet.setMainTitle(R.string.b19);
        actionSheet.addButton(getString(R.string.b18));
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new e(actionSheet));
        if (!actionSheet.isShowing()) {
            actionSheet.show();
        }
        com.tencent.mobileqq.utils.eu.g("Grp_Dis_set", "Dis_info", "clk_quitgrp", 0, 0, this.f175569q0, j3(this.app, this.L0));
    }

    private void H3() {
        ReportController.o(this.app, "CliOper", "", "", "discuss", "dis_mng_mber", 0, 0, "", "", "", "");
        com.tencent.mobileqq.utils.eu.g("Grp_Dis_set", "Dis_info", "clk_delMber", 0, 0, this.f175569q0);
        Intent intent = new Intent();
        intent.putExtra("troop_uin", this.f175569q0);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 1);
        intent.putExtra("param_is_pop_up_style", true);
        RouteUtils.startActivityForResult(this, intent, "/troop/memberlist/TroopMemberList", 9);
    }

    private void I3() {
        FileManagerReporter.addData("0X8004E02");
        ReportController.o(this.app, "dc00898", "", "", "0X8007124", "0X8007124", 0, 0, "", "", "", "");
        com.tencent.mobileqq.utils.eu.g("Grp_Dis_set", "Dis_info", "clk_file", 0, 0, this.f175569q0, j3(this.app, this.L0));
        Intent intent = new Intent(this, (Class<?>) ChatHistoryFileActivity.class);
        intent.putExtra("tab_tab_type", 0);
        intent.putExtra("uin", this.f175569q0);
        intent.putExtra("uintype", this.f175570r0);
        intent.putExtra("uinname", this.f175568p0);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K3(CharSequence charSequence) {
        this.f175558f0.setText(charSequence);
        if (AppSetting.f99565y) {
            this.f175558f0.setContentDescription(HardCodeUtil.qqStr(R.string.lny) + ((Object) charSequence) + HardCodeUtil.qqStr(R.string.lo9));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L3() {
        com.tencent.mobileqq.app.n nVar = this.f175553b0;
        if (nVar != null) {
            DiscussionMemberInfo l3 = nVar.l(this.f175569q0, this.app.getCurrentAccountUin());
            if (l3 != null) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("DiscussionInfoCardActivity", 4, "DiscussionMemberInfo.flag:" + ((int) l3.flag));
                }
                FormSwitchItem formSwitchItem = this.f175564l0;
                if (formSwitchItem != null) {
                    boolean z16 = false;
                    formSwitchItem.setVisibility(0);
                    FormSwitchItem formSwitchItem2 = this.f175564l0;
                    if ((l3.flag & 1) != 0) {
                        z16 = true;
                    }
                    formSwitchItem2.setChecked(z16);
                    return;
                }
                return;
            }
            FormSwitchItem formSwitchItem3 = this.f175564l0;
            if (formSwitchItem3 != null) {
                formSwitchItem3.setVisibility(8);
            }
        }
    }

    private void i3(MyGridView myGridView) {
        int i3 = getResources().getDisplayMetrics().widthPixels;
        float f16 = this.mDensity;
        int i16 = (int) (66.0f * f16);
        int i17 = (int) (50.0f * f16);
        int i18 = i3 - ((int) (f16 * 20.0f));
        int i19 = i18 / (((int) (f16 * 20.0f)) + i17);
        int i26 = i18 - (i19 * i16);
        int i27 = i16 - i17;
        int i28 = ((i26 - i27) / (i19 + 1)) + (i27 / 2);
        int i29 = (int) (f16 * 20.0f);
        this.f175572t0 = i28;
        this.f175573u0 = i28;
        this.f175574v0 = i29;
        this.f175575w0 = i29;
        this.f175576x0 = i19;
        myGridView.setPadding(i28, i29, i28, i29);
        View view = this.f175557e0;
        if (view != null) {
            view.setBackgroundResource(R.drawable.common_strip_setting_bottom);
        }
    }

    private void initView() {
        this.mDensity = getResources().getDisplayMetrics().density;
        this.f175569q0 = this.f175577y0.getStringExtra("uin");
        String stringExtra = this.f175577y0.getStringExtra("uinname");
        this.f175568p0 = stringExtra;
        if (stringExtra == null) {
            this.f175568p0 = this.f175569q0;
        }
        this.f175570r0 = this.f175577y0.getIntExtra("uintype", -1);
        com.tencent.mobileqq.app.n nVar = (com.tencent.mobileqq.app.n) this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        this.f175553b0 = nVar;
        this.L0 = nVar.h(this.f175569q0);
        r3();
        setContentBackgroundResource(R.drawable.bg_texture);
    }

    public static String j3(QQAppInterface qQAppInterface, DiscussionInfo discussionInfo) {
        if (qQAppInterface == null || discussionInfo == null) {
            return "";
        }
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        if (TextUtils.isEmpty(currentAccountUin)) {
            return "";
        }
        if (discussionInfo.isOwnerOrInheritOwner(currentAccountUin)) {
            return "0";
        }
        return "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l3() {
        n3(false);
    }

    private synchronized void n3(boolean z16) {
        if (Thread.currentThread() == getMainLooper().getThread()) {
            ThreadManagerV2.post(new Runnable(z16) { // from class: com.tencent.mobileqq.activity.DiscussionInfoCardActivity.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f175591d;

                {
                    this.f175591d = z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, DiscussionInfoCardActivity.this, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    ArrayList<DiscussionMemberInfo> m3 = DiscussionInfoCardActivity.this.f175553b0.m(DiscussionInfoCardActivity.this.f175569q0);
                    DiscussionInfoCardActivity.this.B3(m3);
                    if (this.f175591d) {
                        try {
                            DiscussionHandler.c cVar = new DiscussionHandler.c();
                            cVar.f194618a = String.valueOf(DiscussionInfoCardActivity.this.f175569q0);
                            cVar.f194620c = m3.size();
                            DiscussionInfoCardActivity.this.f175551a0.T2(cVar);
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d("DiscussionInfoCardActivity", 2, "initDiscussionView getDiscussInfo error disUin=" + DiscussionInfoCardActivity.this.f175569q0, e16);
                            }
                        }
                    }
                }
            }, 5, null, false);
        } else {
            ArrayList<DiscussionMemberInfo> m3 = this.f175553b0.m(this.f175569q0);
            B3(m3);
            if (z16) {
                try {
                    DiscussionHandler.c cVar = new DiscussionHandler.c();
                    cVar.f194618a = String.valueOf(this.f175569q0);
                    cVar.f194620c = m3.size();
                    this.f175551a0.T2(cVar);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("DiscussionInfoCardActivity", 2, "initDiscussionView getDiscussInfo error disUin=" + this.f175569q0, e16);
                    }
                }
            }
        }
    }

    private void notifyUpdatePage() {
        MqqHandler handler;
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null && (handler = qQAppInterface.getHandler(Conversation.class)) != null) {
            handler.sendEmptyMessage(1009);
        }
    }

    private void preloadWebProcess() {
        ((IWebProcessManagerService) this.app.getRuntimeService(IWebProcessManagerService.class, "")).startWebProcessUnderStrategy(19, null);
    }

    private void r3() {
        QQAppInterface qQAppInterface;
        QQAppInterface qQAppInterface2;
        XListView xListView = (XListView) View.inflate(this, R.layout.f168229pt, null);
        try {
            xListView.setBackgroundResource(R.drawable.bg_texture);
        } catch (Throwable th5) {
            QLog.i("DiscussionInfoCardActivity", 1, th5.toString());
        }
        xListView.setDivider(null);
        xListView.setVerticalScrollBarEnabled(false);
        xListView.setPadding(0, 0, 0, 0);
        View inflate = View.inflate(this, R.layout.f167751g3, null);
        xListView.setAdapter((ListAdapter) new XSimpleListAdapter(inflate));
        setContentView(xListView);
        this.f175563k0 = (FormSwitchItem) inflate.findViewById(R.id.jt_);
        this.f175557e0 = inflate.findViewById(R.id.f164992bm2);
        TextView textView = (TextView) inflate.findViewById(R.id.eom);
        this.f175556d0 = textView;
        textView.setCompoundDrawables(null, null, null, null);
        this.f175557e0.setClickable(false);
        MyGridView myGridView = (MyGridView) inflate.findViewById(R.id.eok);
        this.f175555c0 = myGridView;
        myGridView.setFadingEdgeLength(0);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.f167023k14);
        FollowImageTextView followImageTextView = (FollowImageTextView) inflate.findViewById(R.id.k0i);
        this.f175558f0 = followImageTextView;
        followImageTextView.setTextColor(getResources().getColor(R.color.skin_black_group_item));
        this.f175558f0.setTextSize(1, 23.0f);
        this.f175558f0.setMaxLines(2);
        this.f175558f0.setMaxWidth(((int) com.tencent.mobileqq.utils.ah.M()) - UIUtils.b(this, 88.5f));
        this.f175558f0.setFollowImageResource(R.drawable.qb_troop_name_edit_icon);
        this.f175558f0.setFollowImageVisibility(0);
        this.f175558f0.setFollowImageWH(UIUtils.b(this, 14.0f), UIUtils.b(this, 15.0f));
        this.f175560h0 = (FormSimpleItem) inflate.findViewById(R.id.chatHistory);
        this.f175561i0 = (FormSimpleItem) inflate.findViewById(R.id.i0w);
        FormSimpleItem formSimpleItem = (FormSimpleItem) inflate.findViewById(R.id.ioy);
        this.f175562j0 = formSimpleItem;
        formSimpleItem.setVisibility(0);
        this.f175564l0 = (FormSwitchItem) inflate.findViewById(R.id.bma);
        this.f175559g0 = (FormSimpleItem) inflate.findViewById(R.id.em6);
        i3(this.f175555c0);
        this.f175560h0.setOnClickListener(this);
        this.f175561i0.setOnClickListener(this);
        this.f175562j0.setOnClickListener(this);
        this.f175558f0.setOnClickListener(new g());
        this.f175558f0.setOnTouchListener(new h());
        imageView.setOnClickListener(this);
        this.f175564l0.setOnCheckedChangeListener(new i());
        setTitle(R.string.a1o);
        setLeftViewName(R.string.f170549u3);
        this.rightViewImg.setVisibility(0);
        this.rightViewImg.setOnClickListener(this);
        this.rightViewImg.setBackgroundResource(R.drawable.header_btn_more_nor);
        if (this.L0 == null) {
            showToast(1, getString(R.string.ate));
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionInfoCardActivity", 2, "initDiscussionView mDiscussionInfo is null,try to get getDiscuss");
            }
            this.f175551a0.R2(this.app.getLongAccountUin());
            finish();
            return;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.L0.ownerUin);
        if (TextUtils.isEmpty(this.W0) && this.L0.ownerUin != null && !((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "DiscussionInfoCardActivity") && (qQAppInterface2 = this.app) != null) {
            ((FriendListHandler) qQAppInterface2.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.L0.ownerUin + "", false);
        }
        K3(this.f175568p0);
        if (QLog.isDevelopLevel()) {
            QLog.d("DiscussionInfoCardActivity", 4, "DiscussionInfo.DiscussionFlag:" + this.L0.DiscussionFlag);
        }
        L3();
        QQAppInterface qQAppInterface3 = this.app;
        if (qQAppInterface3 != null) {
            this.f175551a0 = (DiscussionHandler) qQAppInterface3.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
        }
        this.f175563k0.setChecked(this.f175551a0.b4(this.L0));
        this.f175563k0.setOnCheckedChangeListener(new j());
        if (this.L0 != null && (qQAppInterface = this.app) != null && qQAppInterface.getCurrentAccountUin() != null) {
            if (t3(this.L0.inheritOwnerUin) && this.app.getCurrentAccountUin().equals(this.L0.inheritOwnerUin)) {
                this.f175559g0.setOnClickListener(this);
                this.f175559g0.setVisibility(0);
            } else if (!t3(this.L0.inheritOwnerUin) && this.app.getCurrentAccountUin().equals(this.L0.ownerUin)) {
                this.f175559g0.setOnClickListener(this);
                this.f175559g0.setVisibility(0);
            } else {
                this.f175559g0.setVisibility(8);
            }
        } else {
            this.f175559g0.setVisibility(8);
        }
        if (AppSetting.f99565y) {
            this.rightViewImg.setContentDescription(getString(R.string.epf));
            this.f175559g0.setContentDescription(HardCodeUtil.qqStr(R.string.lo_));
            this.f175560h0.setContentDescription(getString(R.string.a0y));
            this.f175561i0.setContentDescription(getString(R.string.a0v));
            this.f175562j0.setContentDescription(getString(R.string.hfe));
            this.f175563k0.setContentDescription(getString(R.string.dsq));
            this.f175564l0.setContentDescription(getString(R.string.ats));
        }
        n3(true);
        View findViewById = inflate.findViewById(R.id.aye);
        this.f175567o0 = findViewById;
        findViewById.setOnClickListener(this);
        this.f175567o0.setBackgroundResource(R.drawable.common_strip_setting_bottom);
        this.f175567o0.findViewById(R.id.info).setVisibility(4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f175567o0.getLayoutParams();
        layoutParams.topMargin = com.tencent.mobileqq.util.x.c(this, 30.0f);
        this.f175567o0.setLayoutParams(layoutParams);
        TextView textView2 = (TextView) this.f175567o0.findViewById(R.id.title);
        textView2.setText(HardCodeUtil.qqStr(R.string.lnl));
        QQAppInterface qQAppInterface4 = this.app;
        if (qQAppInterface4 != null) {
            List<ChatMessage> l16 = qQAppInterface4.getMessageFacade().l1(this.f175569q0, 3000);
            if (l16 != null && !l16.isEmpty()) {
                textView2.setTextColor(Color.parseColor("#00b6f9"));
                return;
            } else {
                textView2.setTextColor(Color.parseColor("#cccccc"));
                return;
            }
        }
        textView2.setTextColor(Color.parseColor("#cccccc"));
    }

    @SuppressLint({"NewApi"})
    public static void v3(QQAppInterface qQAppInterface, long j3, String str, String str2) {
        ReportController.o(qQAppInterface, "CliOper", "", "", "discuss", WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, 0, 0, "", "", "", "");
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X800666F", "0X800666F", 0, 0, "", "", "", "");
        BaseApplication context = BaseApplication.getContext();
        if (str != null && str.length() > 0 && j3 > 0) {
            ClipboardMonitor.setPrimaryClip((ClipboardManager) context.getSystemService("clipboard"), ClipData.newPlainText("discussion_url", HardCodeUtil.qqStr(R.string.f171886lo0) + str2 + "\u3011:\n" + str));
            QQToast.makeText(context, 2, HardCodeUtil.qqStr(R.string.lnn), 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        QQToast.makeText(context, 2, HardCodeUtil.qqStr(R.string.lo8), 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    public static void w3(QQAppInterface qQAppInterface, Activity activity, int i3, String str, String str2, String str3, long j3, QQProgressDialog qQProgressDialog) {
        if (str != null && str.length() > 0) {
            if (qQProgressDialog != null) {
                try {
                    qQProgressDialog.show();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("DiscussionInfoCardActivity", 2, e16.toString());
                    }
                }
            }
            ReportController.o(qQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, "2", "", "", "");
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X800666B", "0X800666B", 0, 0, "", "", "", "");
            ThreadManagerV2.post(new Runnable(j3, qQAppInterface, str2, str3, str, activity, i3, qQProgressDialog) { // from class: com.tencent.mobileqq.activity.DiscussionInfoCardActivity.16
                static IPatchRedirector $redirector_;
                final /* synthetic */ int C;
                final /* synthetic */ QQProgressDialog D;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f175579d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f175580e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f175581f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f175582h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f175583i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ Activity f175584m;

                {
                    this.f175579d = j3;
                    this.f175580e = qQAppInterface;
                    this.f175581f = str2;
                    this.f175582h = str3;
                    this.f175583i = str;
                    this.f175584m = activity;
                    this.C = i3;
                    this.D = qQProgressDialog;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), qQAppInterface, str2, str3, str, activity, Integer.valueOf(i3), qQProgressDialog);
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:96:0x0100, code lost:
                
                    if (r0.startsWith("https://") != false) goto L64;
                 */
                /* JADX WARN: Removed duplicated region for block: B:18:0x0107  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x014f  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x019e  */
                /* JADX WARN: Removed duplicated region for block: B:35:0x01c2  */
                /* JADX WARN: Removed duplicated region for block: B:38:0x0209  */
                /* JADX WARN: Removed duplicated region for block: B:43:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
                /* JADX WARN: Type inference failed for: r7v12, types: [boolean] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    String str4;
                    DiscussionInfo h16;
                    com.tencent.mobileqq.structmsg.a c16;
                    QQProgressDialog qQProgressDialog2;
                    String str5;
                    BufferedOutputStream bufferedOutputStream;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    String str6 = null;
                    OutputStream outputStream = null;
                    boolean z16 = false;
                    if (1 == this.f175579d) {
                        if (com.tencent.mobileqq.util.cu.e()) {
                            str5 = AppConstants.PATH_HEAD_HD;
                        } else {
                            str5 = "/data/data/com.tencent.mobileqq/files/head/_hd/";
                        }
                        str4 = str5 + "default_discussion_icon.png";
                        File file = new File(str4);
                        ?? exists = file.exists();
                        try {
                            if (exists == 0) {
                                try {
                                    file.createNewFile();
                                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 8192);
                                } catch (IOException e17) {
                                    e = e17;
                                    bufferedOutputStream = null;
                                } catch (Throwable th5) {
                                    th = th5;
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (IOException e18) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("DiscussionInfoCardActivity", 2, e18.getMessage(), e18);
                                            }
                                        }
                                    }
                                    throw th;
                                }
                                try {
                                    z16 = ((BitmapDrawable) BaseImageUtil.getDefaultDiscusionFaceDrawable()).getBitmap().compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
                                    if (!z16) {
                                        str4 = null;
                                    }
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (IOException e19) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("DiscussionInfoCardActivity", 2, e19.getMessage(), e19);
                                        }
                                    }
                                } catch (IOException e26) {
                                    e = e26;
                                    if (QLog.isColorLevel()) {
                                        e.printStackTrace();
                                    }
                                    if (bufferedOutputStream != null) {
                                        try {
                                            bufferedOutputStream.close();
                                        } catch (IOException e27) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("DiscussionInfoCardActivity", 2, e27.getMessage(), e27);
                                            }
                                        }
                                    }
                                    str4 = null;
                                    if (!z16) {
                                    }
                                    AbsShareMsg a16 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(15).d(HardCodeUtil.qqStr(R.string.f171890lo4) + this.f175582h).j(this.f175583i).a();
                                    com.tencent.mobileqq.app.n nVar = (com.tencent.mobileqq.app.n) this.f175580e.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                                    h16 = nVar.h(this.f175581f);
                                    if (h16 != null) {
                                    }
                                    if (TextUtils.isEmpty(str6)) {
                                    }
                                    com.tencent.mobileqq.structmsg.view.ag agVar = new com.tencent.mobileqq.structmsg.view.ag();
                                    agVar.C(1);
                                    agVar.s(this.f175584m.getString(R.string.dsl));
                                    a16.addItem(agVar);
                                    c16 = com.tencent.mobileqq.structmsg.h.c(2);
                                    if (c16 != null) {
                                    }
                                    Intent intent = new Intent();
                                    intent.putExtra("forward_type", -3);
                                    intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, a16.getBytes());
                                    ForwardBaseOption.startForwardActivityForResult(this.f175584m, intent, this.C);
                                    qQProgressDialog2 = this.D;
                                    if (qQProgressDialog2 != null) {
                                    }
                                }
                                if (!z16) {
                                    str4 = "";
                                }
                                AbsShareMsg a162 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(15).d(HardCodeUtil.qqStr(R.string.f171890lo4) + this.f175582h).j(this.f175583i).a();
                                com.tencent.mobileqq.app.n nVar2 = (com.tencent.mobileqq.app.n) this.f175580e.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                                h16 = nVar2.h(this.f175581f);
                                if (h16 != null) {
                                    String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(h16.ownerUin);
                                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "DiscussionInfoCardActivity");
                                    DiscussionMemberInfo l3 = nVar2.l(this.f175581f, h16.ownerUin);
                                    if (l3 != null) {
                                        str6 = com.tencent.mobileqq.utils.ac.m(l3, this.f175580e);
                                    } else if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "DiscussionInfoCardActivity")) {
                                        str6 = com.tencent.mobileqq.utils.ac.y(this.f175580e, h16.ownerUin);
                                    } else if (friendsSimpleInfoWithUid != null) {
                                        str6 = friendsSimpleInfoWithUid.p();
                                    } else {
                                        str6 = h16.ownerUin;
                                    }
                                }
                                if (TextUtils.isEmpty(str6)) {
                                    str6 = HardCodeUtil.qqStr(R.string.f171887lo1);
                                }
                                com.tencent.mobileqq.structmsg.view.ag agVar2 = new com.tencent.mobileqq.structmsg.view.ag();
                                agVar2.C(1);
                                agVar2.s(this.f175584m.getString(R.string.dsl));
                                a162.addItem(agVar2);
                                c16 = com.tencent.mobileqq.structmsg.h.c(2);
                                if (c16 != null) {
                                    c16.p(str4, ForwardUtils.r(this.f175580e, this.f175582h, this.f175581f), HardCodeUtil.qqStr(R.string.lnt) + str6, 1);
                                    a162.addItem(c16);
                                }
                                Intent intent2 = new Intent();
                                intent2.putExtra("forward_type", -3);
                                intent2.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, a162.getBytes());
                                ForwardBaseOption.startForwardActivityForResult(this.f175584m, intent2, this.C);
                                qQProgressDialog2 = this.D;
                                if (qQProgressDialog2 != null && qQProgressDialog2.isShowing()) {
                                    this.D.dismiss();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            outputStream = exists;
                        }
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f175580e.getCustomFaceFilePath(101, this.f175581f, 0));
                        ArrayList<String> batchUploadImages = QZoneShareManager.batchUploadImages(arrayList, this.f175580e.getCurrentAccountUin(), "1");
                        if (batchUploadImages != null && batchUploadImages.size() > 0) {
                            str4 = batchUploadImages.get(0);
                            if (!TextUtils.isEmpty(str4)) {
                                if (!str4.startsWith("http://")) {
                                }
                            }
                            if (!z16) {
                            }
                            AbsShareMsg a1622 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(15).d(HardCodeUtil.qqStr(R.string.f171890lo4) + this.f175582h).j(this.f175583i).a();
                            com.tencent.mobileqq.app.n nVar22 = (com.tencent.mobileqq.app.n) this.f175580e.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                            h16 = nVar22.h(this.f175581f);
                            if (h16 != null) {
                            }
                            if (TextUtils.isEmpty(str6)) {
                            }
                            com.tencent.mobileqq.structmsg.view.ag agVar22 = new com.tencent.mobileqq.structmsg.view.ag();
                            agVar22.C(1);
                            agVar22.s(this.f175584m.getString(R.string.dsl));
                            a1622.addItem(agVar22);
                            c16 = com.tencent.mobileqq.structmsg.h.c(2);
                            if (c16 != null) {
                            }
                            Intent intent22 = new Intent();
                            intent22.putExtra("forward_type", -3);
                            intent22.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, a1622.getBytes());
                            ForwardBaseOption.startForwardActivityForResult(this.f175584m, intent22, this.C);
                            qQProgressDialog2 = this.D;
                            if (qQProgressDialog2 != null) {
                                return;
                            } else {
                                return;
                            }
                        }
                        str4 = null;
                        if (!z16) {
                        }
                        AbsShareMsg a16222 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(15).d(HardCodeUtil.qqStr(R.string.f171890lo4) + this.f175582h).j(this.f175583i).a();
                        com.tencent.mobileqq.app.n nVar222 = (com.tencent.mobileqq.app.n) this.f175580e.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                        h16 = nVar222.h(this.f175581f);
                        if (h16 != null) {
                        }
                        if (TextUtils.isEmpty(str6)) {
                        }
                        com.tencent.mobileqq.structmsg.view.ag agVar222 = new com.tencent.mobileqq.structmsg.view.ag();
                        agVar222.C(1);
                        agVar222.s(this.f175584m.getString(R.string.dsl));
                        a16222.addItem(agVar222);
                        c16 = com.tencent.mobileqq.structmsg.h.c(2);
                        if (c16 != null) {
                        }
                        Intent intent222 = new Intent();
                        intent222.putExtra("forward_type", -3);
                        intent222.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, a16222.getBytes());
                        ForwardBaseOption.startForwardActivityForResult(this.f175584m, intent222, this.C);
                        qQProgressDialog2 = this.D;
                        if (qQProgressDialog2 != null) {
                        }
                    }
                    z16 = true;
                    if (!z16) {
                    }
                    AbsShareMsg a162222 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(15).d(HardCodeUtil.qqStr(R.string.f171890lo4) + this.f175582h).j(this.f175583i).a();
                    com.tencent.mobileqq.app.n nVar2222 = (com.tencent.mobileqq.app.n) this.f175580e.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                    h16 = nVar2222.h(this.f175581f);
                    if (h16 != null) {
                    }
                    if (TextUtils.isEmpty(str6)) {
                    }
                    com.tencent.mobileqq.structmsg.view.ag agVar2222 = new com.tencent.mobileqq.structmsg.view.ag();
                    agVar2222.C(1);
                    agVar2222.s(this.f175584m.getString(R.string.dsl));
                    a162222.addItem(agVar2222);
                    c16 = com.tencent.mobileqq.structmsg.h.c(2);
                    if (c16 != null) {
                    }
                    Intent intent2222 = new Intent();
                    intent2222.putExtra("forward_type", -3);
                    intent2222.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, a162222.getBytes());
                    ForwardBaseOption.startForwardActivityForResult(this.f175584m, intent2222, this.C);
                    qQProgressDialog2 = this.D;
                    if (qQProgressDialog2 != null) {
                    }
                }
            }, 5, null, true);
        }
    }

    public static void x3(QQAppInterface qQAppInterface, Activity activity, String str, String str2, String str3) {
        ReportController.o(qQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, "3", "", "", "");
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X800666C", "0X800666C", 0, 0, "", "", "", "");
        ThreadManagerV2.post(new Runnable(str2, activity, str, String.format(activity.getString(R.string.asr), str3), qQAppInterface) { // from class: com.tencent.mobileqq.activity.DiscussionInfoCardActivity.17
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f175585d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Activity f175586e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f175587f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f175588h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f175589i;

            {
                this.f175585d = str2;
                this.f175586e = activity;
                this.f175587f = str;
                this.f175588h = r8;
                this.f175589i = qQAppInterface;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str2, activity, str, r8, qQAppInterface);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String str4 = "temp_discuss_link_share_" + this.f175585d + ".png";
                Activity activity2 = this.f175586e;
                this.f175586e.runOnUiThread(new Runnable(com.tencent.biz.qrcode.util.h.P(activity2, str4, com.tencent.mobileqq.troopshare.e.B(this.f175587f, activity2.getResources()))) { // from class: com.tencent.mobileqq.activity.DiscussionInfoCardActivity.17.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f175590d;

                    {
                        this.f175590d = r5;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass17.this, (Object) r5);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (AnonymousClass17.this.f175586e.isFinishing()) {
                            return;
                        }
                        if (TextUtils.isEmpty(this.f175590d)) {
                            QQToast.makeText(AnonymousClass17.this.f175586e, 1, R.string.g2q, 0).show(AnonymousClass17.this.f175586e.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                            return;
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (!TextUtils.isEmpty(this.f175590d)) {
                            arrayList.add(this.f175590d);
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("title", AnonymousClass17.this.f175588h);
                        bundle.putString("desc", "");
                        bundle.putLong("req_share_id", 0L);
                        bundle.putString("detail_url", AnonymousClass17.this.f175587f);
                        bundle.putStringArrayList("image_url", arrayList);
                        AnonymousClass17 anonymousClass17 = AnonymousClass17.this;
                        QZoneShareManager.jumpToQzoneShare(anonymousClass17.f175589i, anonymousClass17.f175586e, bundle, null);
                        if (QLog.isColorLevel()) {
                            QLog.i("DiscussionInfoCardActivity", 2, "shareToQzone.title:" + AnonymousClass17.this.f175588h + " filePath:" + this.f175590d + " shareLink:" + AnonymousClass17.this.f175587f + " desc:");
                        }
                    }
                });
            }
        }, 5, null, false);
    }

    protected void A3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (this.M0 == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
            this.M0 = qQProgressDialog;
            qQProgressDialog.setMessage(R.string.i9h);
        }
        if (!this.M0.isShowing()) {
            this.M0.show();
        }
    }

    void B3(List<DiscussionMemberInfo> list) {
        boolean z16;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            DiscussionMemberInfo discussionMemberInfo = null;
            for (int i3 = 0; i3 < list.size(); i3++) {
                DiscussionMemberInfo discussionMemberInfo2 = list.get(i3);
                if (discussionMemberInfo2 != null) {
                    DiscussionInfo discussionInfo = this.L0;
                    if (discussionInfo != null && discussionMemberInfo2.memberUin != null) {
                        if ((t3(discussionInfo.inheritOwnerUin) && discussionMemberInfo2.memberUin.equals(this.L0.inheritOwnerUin)) || (!t3(this.L0.inheritOwnerUin) && discussionMemberInfo2.memberUin.equals(this.L0.ownerUin))) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            discussionMemberInfo = new DiscussionMemberInfo();
                            discussionMemberInfo.memberUin = discussionMemberInfo2.memberUin;
                            discussionMemberInfo.memberName = com.tencent.mobileqq.utils.ac.m(discussionMemberInfo2, this.app);
                        }
                    }
                    DiscussionMemberInfo discussionMemberInfo3 = new DiscussionMemberInfo();
                    discussionMemberInfo3.memberUin = discussionMemberInfo2.memberUin;
                    String m3 = com.tencent.mobileqq.utils.ac.m(discussionMemberInfo2, this.app);
                    discussionMemberInfo3.memberName = m3;
                    discussionMemberInfo3.discussionUin = ChnToSpell.d(m3, 1);
                    arrayList.add(discussionMemberInfo3);
                }
            }
            Collections.sort(arrayList, new j.b());
            if (discussionMemberInfo != null) {
                arrayList.add(0, discussionMemberInfo);
            }
            if (arrayList.size() > 0 && !this.X0.hasMessages(0)) {
                this.X0.obtainMessage(0, arrayList).sendToTarget();
            }
        }
    }

    protected void J3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        DiscussionInfo discussionInfo = this.L0;
        if (discussionInfo != null) {
            this.f175568p0 = discussionInfo.discussionName;
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("DiscussionInfoCardActivity", 2, "requestCode = " + i3 + ", resultCode = " + i16 + ", data = " + intent);
        }
        if (-1 == i16) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 10) {
                                if (i3 != 11) {
                                    if (i3 == 1000) {
                                        setResult(-1);
                                        this.f175571s0 = true;
                                        return;
                                    }
                                    return;
                                }
                                Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
                                m3.putExtras(new Bundle(intent.getExtras()));
                                ForwardUtils.p(this.app, this, ForwardUtils.n0(m3), m3);
                                return;
                            }
                            addObserver(this.Z0);
                            return;
                        }
                        n nVar = this.f175565m0;
                        if (nVar != null) {
                            nVar.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    int intExtra = intent.getIntExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, -1);
                    if (intExtra != 0) {
                        if (intExtra != 1) {
                            return;
                        }
                    } else {
                        ReportController.o(this.app, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
                    }
                    Intent m16 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
                    String str2 = intent.getLongExtra("roomId", 0L) + "";
                    m16.putExtra("uin", str2);
                    m16.putExtra("uintype", 3000);
                    m16.putExtra("uinname", com.tencent.mobileqq.utils.ac.p(this.app, getApplicationContext(), str2));
                    m16.putExtra("isBack2Root", true);
                    startActivity(m16);
                    finish();
                    return;
                }
                C3();
                finish();
                return;
            }
            if (intent == null) {
                str = "";
            } else {
                str = intent.getStringExtra("result");
            }
            if (str != null && !str.equals("") && !str.equals(this.f175568p0)) {
                if (NetworkUtil.isNetSupport(this)) {
                    this.f175551a0.I2(Long.valueOf(this.f175569q0).longValue(), str);
                    K3(str);
                    s3(getString(R.string.f170713zp));
                    this.f175566n0.show();
                    return;
                }
                showToast(1, getString(R.string.cjm));
                return;
            }
            return;
        }
        if (i16 == 0 && 3 == i3) {
            if (intent != null && intent.getBooleanExtra("finchat", false)) {
                finish();
            }
            n nVar2 = this.f175565m0;
            if (nVar2 != null) {
                nVar2.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        this.f175577y0 = getIntent();
        this.f175551a0 = (DiscussionHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
        addObserver(this.Y0);
        addObserver(this.Z0);
        addObserver(this.f175552a1);
        addObserver(this.f175554b1);
        this.app.setHandler(DiscussionInfoCardActivity.class, this.X0);
        initView();
        preloadWebProcess();
        com.tencent.mobileqq.utils.eu.g("Grp_Dis_set", "Dis_info", "exp", 0, 0, this.f175569q0, j3(this.app, this.L0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnDestroy();
        try {
            QQProgressDialog qQProgressDialog = this.f175566n0;
            if (qQProgressDialog != null && qQProgressDialog.isShowing() && !isFinishing()) {
                this.f175566n0.dismiss();
                this.f175566n0 = null;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        removeObserver(this.Y0);
        removeObserver(this.Z0);
        removeObserver(this.f175552a1);
        removeObserver(this.f175554b1);
        this.app.removeHandler(DiscussionInfoCardActivity.class);
        Dialog dialog = this.N0;
        if (dialog != null && dialog.isShowing() && this.N0.getWindow() != null) {
            this.N0.dismiss();
        }
        if (this.P0 != null) {
            WXShareHelper.b0().q0(this.P0);
            this.P0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            notifyUpdatePage();
            super.doOnPause();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else if (System.currentTimeMillis() - this.f175578z0 >= 1000) {
            this.f175578z0 = System.currentTimeMillis();
            int id5 = view.getId();
            if (id5 == R.id.f167023k14) {
                y3();
            } else if (id5 == R.id.chatHistory) {
                E3();
            } else if (id5 == R.id.i0w) {
                I3();
            } else if (id5 == R.id.ioy) {
                D3();
            } else if (id5 == R.id.em6) {
                H3();
            } else if (id5 == R.id.ivTitleBtnRightImage) {
                ActionSheet create = ActionSheet.create(this);
                create.addButton(getString(R.string.dsx));
                create.addButton(R.string.f170689yn);
                create.addButton(getString(R.string.drl), 3);
                create.addButton(R.string.cancel);
                create.setOnButtonClickListener(new k(create));
                create.show();
                com.tencent.mobileqq.utils.eu.g("Grp_Dis_set", "Dis_info", "clk_upright", 0, 0, this.f175569q0, j3(this.app, this.L0));
            } else if (id5 == R.id.aye) {
                List<ChatMessage> l16 = this.app.getMessageFacade().l1(this.f175569q0, 3000);
                if (l16 != null && !l16.isEmpty()) {
                    com.tencent.mobileqq.widget.h hVar = new com.tencent.mobileqq.widget.h(this, this.app, false);
                    hVar.S(new l());
                    hVar.W(2);
                } else {
                    QQToast.makeText(this, 1, getString(R.string.i4x), 0).show();
                }
            } else {
                u3(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        int i3;
        String str;
        Bitmap bitmap;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) actionSheetItem, (Object) shareActionSheet);
            return;
        }
        if (!this.U0) {
            showToast(R.drawable.f160601l6, HardCodeUtil.qqStr(R.string.lo5));
            this.O0.dismiss();
            return;
        }
        this.O0.dismiss();
        int i17 = actionSheetItem.action;
        if (i17 != 1) {
            int i18 = 0;
            if (i17 != 2) {
                if (i17 != 3) {
                    if (i17 != 9 && i17 != 10) {
                        if (i17 == 23) {
                            y3();
                            return;
                        }
                        return;
                    }
                    if (!WXShareHelper.b0().e0()) {
                        i3 = R.string.f173257ih1;
                    } else if (!WXShareHelper.b0().f0()) {
                        i3 = R.string.f173258ih2;
                    } else {
                        i3 = -1;
                    }
                    if (i3 != -1) {
                        com.tencent.biz.qrcode.util.h.T(1, i3);
                        return;
                    }
                    if (this.P0 == null) {
                        this.P0 = new d();
                        WXShareHelper.b0().A(this.P0);
                    }
                    QQAppInterface qQAppInterface = this.app;
                    if (i17 == 9) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    ReportController.o(qQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, str, "", "", "");
                    if (i17 == 9) {
                        ReportController.o(this.app, "CliOper", "", "", "0X800666D", "0X800666D", 0, 0, "", "", "", "");
                    } else {
                        ReportController.o(this.app, "CliOper", "", "", "0X800666E", "0X800666E", 0, 0, "", "", "", "");
                    }
                    this.Q0 = String.valueOf(System.currentTimeMillis());
                    Drawable V2 = this.f175551a0.V2(this.f175569q0, true);
                    if (V2 instanceof BitmapDrawable) {
                        bitmap = ((BitmapDrawable) V2).getBitmap();
                    } else {
                        bitmap = null;
                    }
                    Bitmap r16 = com.tencent.mobileqq.troopshare.e.r(bitmap);
                    WXShareHelper b06 = WXShareHelper.b0();
                    String str2 = this.Q0;
                    String r17 = ForwardUtils.r(this.app, this.f175568p0, this.f175569q0);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(HardCodeUtil.qqStr(R.string.lno));
                    QQAppInterface qQAppInterface2 = this.app;
                    DiscussionInfo discussionInfo = this.L0;
                    sb5.append(com.tencent.mobileqq.utils.ac.l(qQAppInterface2, discussionInfo.uin, discussionInfo.ownerUin));
                    String sb6 = sb5.toString();
                    String str3 = this.S0;
                    if (i17 == 9) {
                        i16 = 0;
                    } else {
                        i16 = 1;
                    }
                    b06.L0(str2, r17, r16, sb6, str3, i16);
                    return;
                }
                x3(this.app, this, this.S0, this.f175569q0, this.f175568p0);
                return;
            }
            A3();
            ArrayList<DiscussionMemberInfo> m3 = this.f175553b0.m(this.f175569q0);
            if (m3 != null) {
                i18 = m3.size();
            }
            w3(this.app, this, 11, this.T0, this.f175569q0, this.f175568p0, i18, this.M0);
            return;
        }
        v3(this.app, this.R0, this.S0, this.f175568p0);
    }

    protected void p3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.M0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.M0.dismiss();
        }
    }

    void s3(String str) {
        QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.f175566n0 = qQProgressDialog;
        qQProgressDialog.setContentView(R.layout.bwu);
        if (str != null && !"".equals(str.trim())) {
            this.f175566n0.setMessage(str);
        } else {
            this.f175566n0.setMessage(getString(R.string.hex));
        }
    }

    void showToast(int i3, String str) {
        QQToast.makeText(this, i3, str, 0).show(getTitleBarHeight());
    }

    boolean t3(String str) {
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            return true;
        }
        return false;
    }

    public void u3(View view) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            return;
        }
        String str = (String) view.getTag();
        String str2 = (String) view.getTag(R.id.jax);
        if (str == null) {
            return;
        }
        if (this.L0.isDiscussHrMeeting() && !str.equals(getString(R.string.bzl))) {
            return;
        }
        if (str.equals(getString(R.string.bzl))) {
            if (3000 == this.f175570r0) {
                Intent intent = new Intent();
                Map<String, DiscussionMemberInfo> n3 = ((com.tencent.mobileqq.app.n) this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).n(this.f175569q0);
                if (n3 != null) {
                    intent.putStringArrayListExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT, new ArrayList<>(n3.keySet()));
                }
                intent.putExtra(ISelectMemberActivityConstants.PARAM_GROUPCODE, this.f175569q0);
                intent.putExtra("param_type", 3000);
                intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 1);
                if (n3 != null) {
                    i3 = n3.size();
                } else {
                    i3 = 0;
                }
                intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 100 - i3);
                ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this, intent, 2);
                ReportController.o(this.app, "CliOper", "", "", "0X800629A", "0X800629A", 0, 0, "", "", "", "");
                com.tencent.mobileqq.utils.eu.g("Grp_Dis_set", "Dis_info", "clk_invite_new", 0, 0, this.f175569q0, j3(this.app, this.L0));
                return;
            }
            return;
        }
        if (str.equals(this.app.getCurrentAccountUin())) {
            AllInOne allInOne = new AllInOne(str, 0);
            allInOne.lastActivity = 5;
            allInOne.profileEntryType = 57;
            ProfileUtils.openProfileCardForResult(this, allInOne, 3);
        } else if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "DiscussionInfoCardActivity")) {
            AllInOne allInOne2 = new AllInOne(str, 45);
            allInOne2.nickname = com.tencent.mobileqq.utils.ac.Q(this.app, str, 0);
            int i16 = this.f175570r0;
            if (3000 != i16) {
                allInOne2.preWinUin = str;
                allInOne2.preWinType = i16;
            }
            allInOne2.discussUin = this.f175569q0;
            allInOne2.lastActivity = 5;
            allInOne2.profileEntryType = 57;
            ProfileUtils.openProfileCardForResult(this, allInOne2, 3);
        } else {
            AllInOne allInOne3 = new AllInOne(str, 46);
            int i17 = this.f175570r0;
            if (i17 == 3000) {
                allInOne3.f260789pa = 46;
            } else if (i17 == 1000) {
                allInOne3.f260789pa = 22;
                allInOne3.troopUin = getIntent().getStringExtra("troop_uin");
            } else if (i17 == 1001) {
                allInOne3.f260789pa = 42;
            } else if (i17 == 10002) {
                allInOne3.f260789pa = 86;
            } else if (i17 == 1005) {
                allInOne3.f260789pa = 2;
            } else if (i17 == 1023) {
                allInOne3.f260789pa = 74;
            } else {
                allInOne3.f260789pa = 19;
            }
            allInOne3.nickname = str2;
            allInOne3.preWinUin = str;
            int i18 = this.f175570r0;
            allInOne3.preWinType = i18;
            if (3000 == i18) {
                allInOne3.discussUin = this.f175569q0;
            } else if (1000 == i18) {
                allInOne3.troopUin = getIntent().getStringExtra("troop_uin");
            }
            allInOne3.lastActivity = 5;
            allInOne3.profileEntryType = 57;
            ProfileUtils.openProfileCardForResult(this, allInOne3, 3);
        }
        com.tencent.mobileqq.utils.eu.g("Grp_Dis_set", "Dis_info", "clk_mberHead", 0, 0, this.f175569q0, j3(this.app, this.L0));
    }

    protected void y3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        ReportController.o(this.app, "CliOper", "", "", "0X8006670", "0X8006670", 0, 0, "", "", "", "");
        com.tencent.mobileqq.utils.eu.g("Grp_Dis_set", "Dis_info", "clk_qrcode", 0, 0, this.f175569q0, j3(this.app, this.L0));
        Intent intent = new Intent(getActivity(), (Class<?>) QRDisplayActivity.class);
        this.f175577y0 = intent;
        intent.putExtra("title", HardCodeUtil.qqStr(R.string.lnq));
        this.f175577y0.putExtra("uin", this.f175569q0);
        this.f175577y0.putExtra("nick", this.f175568p0);
        this.f175577y0.putExtra("type", 5);
        Drawable V2 = this.f175551a0.V2(this.f175569q0, true);
        if (V2 instanceof BitmapDrawable) {
            this.f175577y0.putExtra(PreDetect.FACE_DETECT, ((BitmapDrawable) V2).getBitmap());
        }
        removeObserver(this.Z0);
        startActivityForResult(this.f175577y0, 10);
    }

    protected void z3() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ReportController.o(this.app, "CliOper", "", this.f175569q0, "discuss", "discuss_QR", 0, 0, "", "", "", "");
        com.tencent.mobileqq.utils.eu.g("Grp_Dis_set", "Dis_info", "clk_share", 0, 0, this.f175569q0, j3(this.app, this.L0));
        if (this.O0 == null) {
            ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
            param.context = this;
            param.isCancelable = false;
            ShareActionSheetV2 shareActionSheetV2 = new ShareActionSheetV2(param);
            this.O0 = shareActionSheetV2;
            shareActionSheetV2.setActionSheetTitle(getString(R.string.hja));
            this.O0.setActionSheetItems(com.tencent.mobileqq.troopshare.e.y(this, true));
            this.O0.setItemClickListenerV2(this);
        }
        try {
            this.O0.show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + e16);
            }
        }
        SharedPreferences sharedPreferences = getSharedPreferences("qrcode", 0);
        this.R0 = sharedPreferences.getLong("discussionvalidtime" + this.f175569q0, 0L);
        this.S0 = sharedPreferences.getString("discussion" + this.f175569q0, null);
        this.T0 = sharedPreferences.getString("discussionfullSig" + this.f175569q0, null);
        if (this.R0 - (System.currentTimeMillis() / 1000) > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.S0 != null && this.T0 != null && z16) {
            this.U0 = true;
        } else {
            if (QLog.isDevelopLevel()) {
                QLog.d("DiscussionInfoCardActivity", 4, "qrcode url not valid");
            }
            this.U0 = false;
            this.f175551a0.Y2(Long.parseLong(this.f175569q0), true);
        }
        ReportController.o(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
    }

    private void E3() {
    }
}
