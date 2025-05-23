package com.tencent.mobileqq.activity.selectmember;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.NearFieldDiscussHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bw;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.createtroopblacklist.CreateTroopUnblockType;
import com.tencent.mobileqq.troop.createtroopblacklist.api.ICreateTroopBlackListUtilApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.widget.verifycode.VerifyCodeView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import tencent.im.nearfield_discuss.nearfield_discuss$BusiRespHead;
import tencent.im.nearfield_discuss.nearfield_discuss$GPS;
import tencent.im.nearfield_discuss.nearfield_discuss$LBSInfo;
import tencent.im.nearfield_discuss.nearfield_discuss$UserProfile;

/* compiled from: P */
@RoutePage(desc = "\u9762\u5bf9\u9762\u5efa\u7fa4", path = RouterConstants.UI_ROUTE_FACE2FACE_DISCUSSION)
/* loaded from: classes10.dex */
public class CreateFaceToFaceDiscussionActivity extends LbsBaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final String CREATE_BTN_ELEMENT_ID = "em_group_create_chat_now";
    public static final int CREATE_FAILED_FACE = 10007;
    private static final int CREATE_FAILED_TIME = 10006;
    public static final int DIGITAL_KEYBOARD_HEIGHT = 200;
    public static final int FROM_ADD_CONTACT = 2;
    public static final int FROM_CREATE_TROOP = 1;
    private static final String PAGE_ID = "pg_group_create_chat_facetoface";
    public static final String TAG = "CreateFaceToFaceDiscussionActivity";
    private static final int TYPE_ENTER_DISCUSSION = 0;
    private static final int TYPE_ENTER_TROOP = 1;
    private static final int TYPE_EXIT_HALL = 4;
    private static final int TYPE_GET_MEMBERLIST = 3;
    private static final int TYPE_GET_MEMBERLIST_FIRST = 2;
    public static final int TYPE_NEW_TROOP = 2;
    final int MAX_MEMBERS_COUNT;
    final int MEMBERS_COUNT_THREE_LINE;
    final int MSG_SHOW_TOAST;
    final int MSG_WHAT;
    final int MSG_WHAT_TRY_AGAIN;
    int TYPE_DISCUSS;
    LinearLayout bottomLayout;
    LinearLayout contentLayout;
    int createSource;
    StringBuffer digits;

    /* renamed from: fm, reason: collision with root package name */
    FriendsManager f186158fm;
    int fromSource;
    boolean isEnteredHall;
    boolean isExitedHall;
    boolean isFirstEnterHall;
    boolean isTroop;
    Context mContext;
    Button mCreateTroopBtn;
    private Runnable mGetSelfNickRunnable;
    g mGridViewAdapter;
    GridView mGridview;
    Handler mHandler;
    long mInterval;
    nearfield_discuss$LBSInfo mLBSInfo;
    TranslateAnimation mLayoutAnimation;
    List<nearfield_discuss$UserProfile> mMemberList;
    private bw mNearFieldDisObsever;
    BroadcastReceiver mNetWorkReceiver;
    Drawable mProgressDrawable;
    QQProgressDialog mQQProgressDialog;
    nearfield_discuss$UserProfile mSelf;
    int mSessionId;
    TextView mTextviewTipContent;
    TextView mTextviewTipTitle;
    TranslateAnimation mTranslateAnimation;
    private VerifyCodeView mVerifyCodeView;
    View progress;

    /* renamed from: sb, reason: collision with root package name */
    StringBuilder f186159sb;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CreateFaceToFaceDiscussionActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (NetworkUtil.isNetSupport(CreateFaceToFaceDiscussionActivity.this.mContext)) {
                CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity = CreateFaceToFaceDiscussionActivity.this;
                if (createFaceToFaceDiscussionActivity.isEnteredHall && createFaceToFaceDiscussionActivity.isResume()) {
                    if (CreateFaceToFaceDiscussionActivity.this.mHandler.hasMessages(0)) {
                        CreateFaceToFaceDiscussionActivity.this.mHandler.removeMessages(0);
                    }
                    CreateFaceToFaceDiscussionActivity.this.mHandler.sendEmptyMessage(0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements VerifyCodeView.OnInputListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CreateFaceToFaceDiscussionActivity.this);
            }
        }

        @Override // com.tencent.widget.verifycode.VerifyCodeView.OnInputListener
        public void onInputFinish(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                CreateFaceToFaceDiscussionActivity.this.showReadyJoinMember(str);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CreateFaceToFaceDiscussionActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity = CreateFaceToFaceDiscussionActivity.this;
                if (createFaceToFaceDiscussionActivity.isEnteredHall) {
                    ReportController.o(createFaceToFaceDiscussionActivity.app, "CliOper", "", "", "0X80041AE", "0X80041AE", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(createFaceToFaceDiscussionActivity.app, "CliOper", "", "", "0X80041A9", "0X80041A9", 0, 0, "", "", "", "");
                }
                ReportController.o(CreateFaceToFaceDiscussionActivity.this.app, "dc00899", "Grp_create_new", "", "suc_create", "clk_cancel", 0, 0, "", "" + CreateFaceToFaceDiscussionActivity.this.createSource, "", "");
                CreateFaceToFaceDiscussionActivity.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d extends Handler {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CreateFaceToFaceDiscussionActivity.this);
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
                CreateFaceToFaceDiscussionActivity.this.oneWayRequest(3);
                Message obtainMessage = CreateFaceToFaceDiscussionActivity.this.mHandler.obtainMessage(0);
                CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity = CreateFaceToFaceDiscussionActivity.this;
                createFaceToFaceDiscussionActivity.mHandler.sendMessageDelayed(obtainMessage, createFaceToFaceDiscussionActivity.mInterval);
                return;
            }
            if (1 == i3) {
                CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity2 = CreateFaceToFaceDiscussionActivity.this;
                if (!createFaceToFaceDiscussionActivity2.isEnteredHall) {
                    StringBuffer stringBuffer = createFaceToFaceDiscussionActivity2.digits;
                    stringBuffer.delete(0, stringBuffer.length());
                    return;
                }
                return;
            }
            if (2 == i3) {
                QQToast.makeText(BaseApplication.getContext(), message.arg1, message.arg2, 0).show();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class e extends bw {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CreateFaceToFaceDiscussionActivity.this);
            }
        }

        private void d(CreateTroopUnblockType createTroopUnblockType) {
            QLog.i(CreateFaceToFaceDiscussionActivity.TAG, 1, "[showCreateTroopSecurityDialog] start. type: " + createTroopUnblockType.name());
            com.tencent.mobileqq.troop.createtroopblacklist.api.a aVar = new com.tencent.mobileqq.troop.createtroopblacklist.api.a();
            aVar.g(createTroopUnblockType);
            ((ICreateTroopBlackListUtilApi) QRoute.api(ICreateTroopBlackListUtilApi.class)).showCreateTroopSecurityDialog(CreateFaceToFaceDiscussionActivity.this.getActivity(), aVar);
        }

        @Override // com.tencent.mobileqq.app.bw
        protected void a(boolean z16, List<nearfield_discuss$UserProfile> list, int i3, int i16, nearfield_discuss$BusiRespHead nearfield_discuss_busiresphead, int i17, int i18, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), list, Integer.valueOf(i3), Integer.valueOf(i16), nearfield_discuss_busiresphead, Integer.valueOf(i17), Integer.valueOf(i18), Long.valueOf(j3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(CreateFaceToFaceDiscussionActivity.TAG, 2, "NearFieldDiscussObserver isSuccess = " + z16 + " ; interval = " + i3);
            }
            if (z16) {
                if (i3 > 0) {
                    CreateFaceToFaceDiscussionActivity.this.mInterval = i3 * 1000;
                }
                if (nearfield_discuss_busiresphead != null && nearfield_discuss_busiresphead.int32_reply_code.get() != 0) {
                    if (!CreateFaceToFaceDiscussionActivity.this.isEnteredHall) {
                        QQToast.makeText(CreateFaceToFaceDiscussionActivity.this.mContext, nearfield_discuss_busiresphead.str_result.get(), 0).show();
                        ((Animatable) CreateFaceToFaceDiscussionActivity.this.mProgressDrawable).stop();
                        CreateFaceToFaceDiscussionActivity.this.progress.setVisibility(4);
                        if (CreateFaceToFaceDiscussionActivity.this.mHandler.hasMessages(1)) {
                            CreateFaceToFaceDiscussionActivity.this.mHandler.removeMessages(1);
                        }
                        CreateFaceToFaceDiscussionActivity.this.mHandler.sendEmptyMessageDelayed(1, 600L);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(CreateFaceToFaceDiscussionActivity.TAG, 2, "head.int32_reply_code = " + nearfield_discuss_busiresphead.int32_reply_code.get());
                        return;
                    }
                    return;
                }
                if (i18 != 0) {
                    if (i18 != 1) {
                        if (i18 == 2) {
                            CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity = CreateFaceToFaceDiscussionActivity.this;
                            createFaceToFaceDiscussionActivity.isTroop = true;
                            createFaceToFaceDiscussionActivity.mCreateTroopBtn.setVisibility(0);
                            CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity2 = CreateFaceToFaceDiscussionActivity.this;
                            createFaceToFaceDiscussionActivity2.mCreateTroopBtn.setText(createFaceToFaceDiscussionActivity2.getString(R.string.hcr));
                            CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity3 = CreateFaceToFaceDiscussionActivity.this;
                            createFaceToFaceDiscussionActivity3.mCreateTroopBtn.setContentDescription(createFaceToFaceDiscussionActivity3.getString(R.string.hcr));
                        }
                    } else {
                        CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity4 = CreateFaceToFaceDiscussionActivity.this;
                        createFaceToFaceDiscussionActivity4.isTroop = false;
                        createFaceToFaceDiscussionActivity4.mCreateTroopBtn.setVisibility(0);
                        CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity5 = CreateFaceToFaceDiscussionActivity.this;
                        createFaceToFaceDiscussionActivity5.mCreateTroopBtn.setText(createFaceToFaceDiscussionActivity5.getString(R.string.hcq));
                        CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity6 = CreateFaceToFaceDiscussionActivity.this;
                        createFaceToFaceDiscussionActivity6.mCreateTroopBtn.setContentDescription(createFaceToFaceDiscussionActivity6.getString(R.string.hcq));
                    }
                } else {
                    CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity7 = CreateFaceToFaceDiscussionActivity.this;
                    createFaceToFaceDiscussionActivity7.mTextviewTipTitle.setText(createFaceToFaceDiscussionActivity7.getString(R.string.f224846k1));
                    CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity8 = CreateFaceToFaceDiscussionActivity.this;
                    createFaceToFaceDiscussionActivity8.mTextviewTipContent.setText(createFaceToFaceDiscussionActivity8.getString(R.string.f224856k2));
                    CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity9 = CreateFaceToFaceDiscussionActivity.this;
                    createFaceToFaceDiscussionActivity9.mTextviewTipContent.setContentDescription(createFaceToFaceDiscussionActivity9.getString(R.string.f224856k2));
                    CreateFaceToFaceDiscussionActivity.this.mCreateTroopBtn.setText(HardCodeUtil.qqStr(R.string.f171816l53));
                    CreateFaceToFaceDiscussionActivity.this.mCreateTroopBtn.setContentDescription(HardCodeUtil.qqStr(R.string.f171816l53));
                }
                CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity10 = CreateFaceToFaceDiscussionActivity.this;
                List<nearfield_discuss$UserProfile> list2 = createFaceToFaceDiscussionActivity10.mMemberList;
                if (list2 == null) {
                    createFaceToFaceDiscussionActivity10.mMemberList = new ArrayList();
                } else {
                    list2.clear();
                }
                CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity11 = CreateFaceToFaceDiscussionActivity.this;
                createFaceToFaceDiscussionActivity11.mMemberList.add(createFaceToFaceDiscussionActivity11.mSelf);
                if (list != null) {
                    CreateFaceToFaceDiscussionActivity.this.mMemberList.addAll(list);
                }
                if (list == null && QLog.isColorLevel()) {
                    QLog.i(CreateFaceToFaceDiscussionActivity.TAG, 2, "usrList == null");
                }
                g gVar = CreateFaceToFaceDiscussionActivity.this.mGridViewAdapter;
                if (gVar != null) {
                    gVar.notifyDataSetChanged();
                    CreateFaceToFaceDiscussionActivity.this.mGridview.setVisibility(0);
                }
                CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity12 = CreateFaceToFaceDiscussionActivity.this;
                if (createFaceToFaceDiscussionActivity12.isFirstEnterHall) {
                    createFaceToFaceDiscussionActivity12.isFirstEnterHall = false;
                    createFaceToFaceDiscussionActivity12.uiChange();
                    Message obtainMessage = CreateFaceToFaceDiscussionActivity.this.mHandler.obtainMessage(0);
                    CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity13 = CreateFaceToFaceDiscussionActivity.this;
                    createFaceToFaceDiscussionActivity13.mHandler.sendMessageDelayed(obtainMessage, createFaceToFaceDiscussionActivity13.mInterval);
                }
            } else {
                CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity14 = CreateFaceToFaceDiscussionActivity.this;
                if (!createFaceToFaceDiscussionActivity14.isEnteredHall) {
                    QQToast.makeText(createFaceToFaceDiscussionActivity14.mContext, HardCodeUtil.qqStr(R.string.f171814l51), 1).show();
                    if (CreateFaceToFaceDiscussionActivity.this.mHandler.hasMessages(1)) {
                        CreateFaceToFaceDiscussionActivity.this.mHandler.removeMessages(1);
                    }
                    CreateFaceToFaceDiscussionActivity.this.mHandler.sendEmptyMessageDelayed(1, 600L);
                }
            }
            ((Animatable) CreateFaceToFaceDiscussionActivity.this.mProgressDrawable).stop();
            CreateFaceToFaceDiscussionActivity.this.progress.setBackgroundDrawable(null);
            CreateFaceToFaceDiscussionActivity.this.progress.setVisibility(8);
        }

        @Override // com.tencent.mobileqq.app.bw
        protected void b(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            com.tencent.mobileqq.service.nearfield.a aVar = (com.tencent.mobileqq.service.nearfield.a) obj;
            int d16 = aVar.d();
            int b16 = aVar.b();
            int c16 = aVar.c();
            QQProgressDialog qQProgressDialog = CreateFaceToFaceDiscussionActivity.this.mQQProgressDialog;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
                CreateFaceToFaceDiscussionActivity.this.mQQProgressDialog = null;
            }
            if (QLog.isColorLevel()) {
                QLog.d(CreateFaceToFaceDiscussionActivity.TAG, 2, "onGetNearFieldDiscussInfo " + z16 + " mSessionId=" + CreateFaceToFaceDiscussionActivity.this.mSessionId + " sessionId=" + d16);
            }
            if (z16) {
                String a16 = aVar.a();
                if (d16 == CreateFaceToFaceDiscussionActivity.this.mSessionId) {
                    if (b16 == 0 && DiscussionInfo.isValidDisUin(a16)) {
                        CreateFaceToFaceDiscussionActivity.this.finish();
                        CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity = CreateFaceToFaceDiscussionActivity.this;
                        String p16 = ac.p(createFaceToFaceDiscussionActivity.app, createFaceToFaceDiscussionActivity.getActivity().getApplicationContext(), a16);
                        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(CreateFaceToFaceDiscussionActivity.this.getActivity()), null);
                        m3.putExtra("uin", a16);
                        m3.putExtra("uintype", 3000);
                        m3.putExtra("uinname", p16);
                        m3.putExtra("isBack2Root", true);
                        CreateFaceToFaceDiscussionActivity.this.startActivity(m3);
                        return;
                    }
                    if (b16 != 2 && b16 != 1) {
                        CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity2 = CreateFaceToFaceDiscussionActivity.this;
                        createFaceToFaceDiscussionActivity2.showToast(1, createFaceToFaceDiscussionActivity2.getString(R.string.b3g));
                        return;
                    }
                    CreateFaceToFaceDiscussionActivity.this.finish();
                    Intent m16 = BaseAIOUtils.m(SplashActivity.getAliasIntent(CreateFaceToFaceDiscussionActivity.this.getActivity()), null);
                    m16.putExtra("uin", a16);
                    m16.putExtra("uintype", 1);
                    StringBuilder sb5 = new StringBuilder();
                    QQAppInterface qQAppInterface = CreateFaceToFaceDiscussionActivity.this.app;
                    sb5.append(ac.f(qQAppInterface, qQAppInterface.getCurrentAccountUin()));
                    sb5.append(HardCodeUtil.qqStr(R.string.f171817l54));
                    m16.putExtra("uinname", sb5.toString());
                    m16.putExtra("isBack2Root", true);
                    CreateFaceToFaceDiscussionActivity.this.startActivity(m16);
                    ReportController.o(CreateFaceToFaceDiscussionActivity.this.app, "dc00899", "Grp_create", "", "f2f", "cre_suc", 0, 0, a16, "", "", "");
                    return;
                }
                return;
            }
            if (d16 == CreateFaceToFaceDiscussionActivity.this.mSessionId) {
                QLog.w(CreateFaceToFaceDiscussionActivity.TAG, 1, "[onGetNearFieldDiscussInfo] failed. resultCode: " + c16);
                if (c16 != 10006) {
                    if (c16 != 10007) {
                        CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity3 = CreateFaceToFaceDiscussionActivity.this;
                        createFaceToFaceDiscussionActivity3.showToast(1, createFaceToFaceDiscussionActivity3.getString(R.string.b3g));
                        return;
                    } else {
                        d(CreateTroopUnblockType.FACE);
                        return;
                    }
                }
                d(CreateTroopUnblockType.TIME);
            }
        }

        @Override // com.tencent.mobileqq.app.bw
        protected void c(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(CreateFaceToFaceDiscussionActivity.TAG, 2, "on push | isSuccess = " + z16);
            }
            if (z16) {
                int intValue = ((Integer) ((Object[]) obj)[0]).intValue();
                CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity = CreateFaceToFaceDiscussionActivity.this;
                if (intValue == createFaceToFaceDiscussionActivity.mSessionId && createFaceToFaceDiscussionActivity.isResume()) {
                    if (CreateFaceToFaceDiscussionActivity.this.mHandler.hasMessages(0)) {
                        CreateFaceToFaceDiscussionActivity.this.mHandler.removeMessages(0);
                    }
                    CreateFaceToFaceDiscussionActivity.this.mHandler.sendEmptyMessage(0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f186167a;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    CreateFaceToFaceDiscussionActivity.this.finish();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        f(int i3) {
            this.f186167a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CreateFaceToFaceDiscussionActivity.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                CreateFaceToFaceDiscussionActivity.this.oneWayRequestInner(this.f186167a);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
            } else {
                super.onDenied(list, list2);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) permissionRequestDialog, (Object) list);
            } else {
                super.onDialogShow(permissionRequestDialog, list);
                permissionRequestDialog.setOnDisAllowClickListener(new a());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private class g extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        LayoutInflater f186170d;

        /* renamed from: e, reason: collision with root package name */
        h f186171e;

        public g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CreateFaceToFaceDiscussionActivity.this);
            } else {
                this.f186170d = LayoutInflater.from(CreateFaceToFaceDiscussionActivity.this.mContext);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            List<nearfield_discuss$UserProfile> list = CreateFaceToFaceDiscussionActivity.this.mMemberList;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            List<nearfield_discuss$UserProfile> list = CreateFaceToFaceDiscussionActivity.this.mMemberList;
            if (list == null) {
                return null;
            }
            return list.get(i3);
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
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = this.f186170d.inflate(R.layout.f168811av3, (ViewGroup) null);
                    h hVar = new h();
                    this.f186171e = hVar;
                    hVar.f186174b = (QQProAvatarView) view.findViewById(R.id.icon);
                    this.f186171e.f186175c = (TextView) view.findViewById(R.id.f5e);
                    view.setTag(this.f186171e);
                    if (FontSettingManager.isFontSizeLarge()) {
                        FontSettingManager.resetViewSize2Normal(CreateFaceToFaceDiscussionActivity.this.mContext, view);
                    }
                }
                if (i3 < CreateFaceToFaceDiscussionActivity.this.mMemberList.size()) {
                    CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity = CreateFaceToFaceDiscussionActivity.this;
                    createFaceToFaceDiscussionActivity.fillData(view, createFaceToFaceDiscussionActivity.mMemberList.get(i3));
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class h {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f186173a;

        /* renamed from: b, reason: collision with root package name */
        QQProAvatarView f186174b;

        /* renamed from: c, reason: collision with root package name */
        TextView f186175c;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CreateFaceToFaceDiscussionActivity.this);
            }
        }
    }

    public CreateFaceToFaceDiscussionActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.digits = new StringBuffer(4);
        this.isExitedHall = false;
        this.mSessionId = -1;
        this.isTroop = true;
        this.TYPE_DISCUSS = 0;
        this.MSG_WHAT = 0;
        this.MSG_WHAT_TRY_AGAIN = 1;
        this.MSG_SHOW_TOAST = 2;
        this.mInterval = 60000L;
        this.MAX_MEMBERS_COUNT = 50;
        this.MEMBERS_COUNT_THREE_LINE = 11;
        this.createSource = 7;
        this.fromSource = 1;
        this.mGetSelfNickRunnable = new Runnable() { // from class: com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CreateFaceToFaceDiscussionActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                QQAppInterface qQAppInterface;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity = CreateFaceToFaceDiscussionActivity.this;
                nearfield_discuss$UserProfile nearfield_discuss_userprofile = createFaceToFaceDiscussionActivity.mSelf;
                if (nearfield_discuss_userprofile != null && (qQAppInterface = createFaceToFaceDiscussionActivity.app) != null) {
                    nearfield_discuss_userprofile.str_nick.set(qQAppInterface.getCurrentNickname());
                }
            }
        };
        this.mHandler = new d();
        this.mNearFieldDisObsever = new e();
        this.isFirstEnterHall = true;
        this.f186159sb = new StringBuilder();
        this.mMemberList = new ArrayList();
    }

    private void enterDiscussOrTroop() {
        if (NetworkUtil.isNetSupport(this)) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            this.mQQProgressDialog = qQProgressDialog;
            qQProgressDialog.setMessage(R.string.i6c);
            this.mQQProgressDialog.show();
            oneWayRequest(this.isTroop ? 1 : 0);
            return;
        }
        showToast(1, getString(R.string.cjm));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillData(View view, nearfield_discuss$UserProfile nearfield_discuss_userprofile) {
        String valueOf = String.valueOf(nearfield_discuss_userprofile.uint64_uin.get());
        String str = nearfield_discuss_userprofile.str_nick.get();
        h hVar = (h) view.getTag();
        hVar.f186174b.x(1, valueOf, new e.a().g(100).a());
        if (this.f186158fm == null) {
            this.f186158fm = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        }
        if (valueOf != null && this.f186158fm.c0(valueOf)) {
            str = ac.F(this.app, valueOf);
        } else if (!this.f186158fm.c0(valueOf)) {
            String noFriendRemark = ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).getNoFriendRemark(valueOf);
            if (!TextUtils.isEmpty(noFriendRemark)) {
                str = noFriendRemark;
            }
        }
        hVar.f186175c.setText(str);
        ViewCompat.setImportantForAccessibility(hVar.f186175c, 2);
        ViewCompat.setImportantForAccessibility(hVar.f186174b, 2);
        ViewCompat.setImportantForAccessibility(view, 1);
        view.setContentDescription(str);
        hVar.f186173a = valueOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public nearfield_discuss$LBSInfo generateLbsInfo(SosoLbsInfo sosoLbsInfo) {
        StringBuffer stringBuffer = new StringBuffer();
        if (sosoLbsInfo == null) {
            return this.mLBSInfo;
        }
        nearfield_discuss$LBSInfo nearfield_discuss_lbsinfo = new nearfield_discuss$LBSInfo();
        nearfield_discuss$GPS nearfield_discuss_gps = new nearfield_discuss$GPS();
        nearfield_discuss_gps.int32_lat.set((int) (sosoLbsInfo.mLocation.mLat02 * 1000000.0d));
        nearfield_discuss_gps.int32_lon.set((int) (sosoLbsInfo.mLocation.mLon02 * 1000000.0d));
        nearfield_discuss_gps.int32_alt.set(-1);
        nearfield_discuss_gps.eType.set(1);
        nearfield_discuss_lbsinfo.msg_gps.set(nearfield_discuss_gps);
        stringBuffer.append(" GPS: ");
        stringBuffer.append(sosoLbsInfo.mLocation.mLat02 * 1000000.0d);
        stringBuffer.append(",");
        stringBuffer.append(sosoLbsInfo.mLocation.mLon02 * 1000000.0d);
        this.mLBSInfo = nearfield_discuss_lbsinfo;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, stringBuffer.toString());
        }
        return nearfield_discuss_lbsinfo;
    }

    private void getSelfNickname(nearfield_discuss$UserProfile nearfield_discuss_userprofile) {
        if (nearfield_discuss_userprofile == null) {
            return;
        }
        String account = this.app.getAccount();
        String A = ac.A(this.app, account);
        nearfield_discuss_userprofile.str_nick.set(A);
        if (TextUtils.isEmpty(A) || TextUtils.equals(A, account)) {
            ThreadManager.getSubThreadHandler().post(this.mGetSelfNickRunnable);
        }
    }

    private void initQUITitle() {
        this.quiSecNavBar.setCenterText(getString(R.string.f170105g7));
        this.quiSecNavBar.setLeftType(1);
        this.quiSecNavBar.setLeftText(HardCodeUtil.qqStr(R.string.cancel));
        this.quiSecNavBar.setBaseClickListener(BaseAction.ACTION_LEFT_TEXT, new c());
    }

    private void initUi() {
        this.progress = findViewById(R.id.g2d);
        this.mProgressDrawable = getResources().getDrawable(R.drawable.common_loading6);
        this.contentLayout = (LinearLayout) findViewById(R.id.b9t);
        Button button = (Button) findViewById(R.id.bbt);
        this.mCreateTroopBtn = button;
        button.setOnClickListener(this);
        this.mTextviewTipContent = (TextView) findViewById(R.id.f96005gi);
        this.mTextviewTipTitle = (TextView) findViewById(R.id.f96015gj);
        this.mTextviewTipContent.setText(getString(R.string.f224856k2));
        this.mTextviewTipContent.setContentDescription(getString(R.string.f224856k2));
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.acy);
        this.bottomLayout = linearLayout;
        linearLayout.setVisibility(4);
        this.mVerifyCodeView = (VerifyCodeView) findViewById(R.id.f116536z0);
        if (FontSettingManager.isFontSizeLarge()) {
            FontSettingManager.resetViewSize2Normal(this.mContext, this.mVerifyCodeView);
        }
        this.mVerifyCodeView.setOnInputListener(new b());
        initQUITitle();
        reportDT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$oneWayRequest$1(QQPermission qQPermission, int i3, DialogInterface dialogInterface, int i16) {
        qQPermission.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 2, new f(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$oneWayRequest$2(DialogInterface dialogInterface, int i3) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showReadyJoinMember$0() {
        this.mVerifyCodeView.reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oneWayRequest(final int i3) {
        final QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_TROOP, QQPermissionConstants.Business.SCENE.QQ_TROOP_FACE_TO_FACE_CREATE));
        boolean z16 = true;
        if (qQPermission != null && qQPermission.hasPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
            z16 = false;
        }
        if (z16) {
            oneWayRequestInner(i3);
            return;
        }
        QQCustomDialog createCenterTextDialog = DialogUtil.createCenterTextDialog(this, 0, getString(R.string.f174892x3), getString(R.string.f174862x0), getString(R.string.f174882x2), getString(R.string.f174872x1), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.selectmember.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                CreateFaceToFaceDiscussionActivity.this.lambda$oneWayRequest$1(qQPermission, i3, dialogInterface, i16);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.selectmember.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                CreateFaceToFaceDiscussionActivity.this.lambda$oneWayRequest$2(dialogInterface, i16);
            }
        });
        createCenterTextDialog.setCancelable(false);
        createCenterTextDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oneWayRequestInner(int i3) {
        ThreadManagerV2.post(new Runnable(i3) { // from class: com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity.9
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f186160d;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity$9$a */
            /* loaded from: classes10.dex */
            class a extends SosoInterfaceOnLocationListener {
                static IPatchRedirector $redirector_;

                a(int i3, boolean z16, boolean z17, long j3, boolean z18, boolean z19, String str) {
                    super(i3, z16, z17, j3, z18, z19, str);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, AnonymousClass9.this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), Boolean.valueOf(z18), Boolean.valueOf(z19), str);
                    }
                }

                @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
                public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) sosoLbsInfo);
                        return;
                    }
                    if (i3 == 0 && sosoLbsInfo != null) {
                        nearfield_discuss$LBSInfo generateLbsInfo = CreateFaceToFaceDiscussionActivity.this.generateLbsInfo(sosoLbsInfo);
                        NearFieldDiscussHandler nearFieldDiscussHandler = (NearFieldDiscussHandler) CreateFaceToFaceDiscussionActivity.this.app.getBusinessHandler(BusinessHandlerFactory.NEARFIELD_DISCUSS_HANDLER);
                        AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                        int i16 = anonymousClass9.f186160d;
                        if (i16 != 0) {
                            if (i16 != 1) {
                                if (i16 != 2) {
                                    if (i16 != 3) {
                                        if (i16 == 4) {
                                            nearFieldDiscussHandler.D2(CreateFaceToFaceDiscussionActivity.this.digits.toString(), CreateFaceToFaceDiscussionActivity.this.mSessionId, generateLbsInfo);
                                            return;
                                        }
                                        return;
                                    }
                                    nearFieldDiscussHandler.E2(CreateFaceToFaceDiscussionActivity.this.digits.toString(), CreateFaceToFaceDiscussionActivity.this.mSessionId, generateLbsInfo, false);
                                    return;
                                }
                                nearFieldDiscussHandler.E2(CreateFaceToFaceDiscussionActivity.this.digits.toString(), CreateFaceToFaceDiscussionActivity.this.mSessionId, generateLbsInfo, true);
                                return;
                            }
                            String stringBuffer = CreateFaceToFaceDiscussionActivity.this.digits.toString();
                            CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity = CreateFaceToFaceDiscussionActivity.this;
                            nearFieldDiscussHandler.F2(stringBuffer, createFaceToFaceDiscussionActivity.mSessionId, generateLbsInfo, 2, createFaceToFaceDiscussionActivity.createSource);
                            return;
                        }
                        String stringBuffer2 = CreateFaceToFaceDiscussionActivity.this.digits.toString();
                        CreateFaceToFaceDiscussionActivity createFaceToFaceDiscussionActivity2 = CreateFaceToFaceDiscussionActivity.this;
                        nearFieldDiscussHandler.F2(stringBuffer2, createFaceToFaceDiscussionActivity2.mSessionId, generateLbsInfo, createFaceToFaceDiscussionActivity2.TYPE_DISCUSS, createFaceToFaceDiscussionActivity2.createSource);
                        return;
                    }
                    QLog.e(CreateFaceToFaceDiscussionActivity.TAG, 1, "[onLocationFinish] failed. errCode:" + i3);
                    Message obtainMessage = CreateFaceToFaceDiscussionActivity.this.mHandler.obtainMessage(2);
                    obtainMessage.arg1 = 1;
                    obtainMessage.arg2 = R.string.fko;
                    obtainMessage.sendToTarget();
                }
            }

            {
                this.f186160d = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) CreateFaceToFaceDiscussionActivity.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new a(0, true, false, 60000L, false, false, CreateFaceToFaceDiscussionActivity.TAG));
                }
            }
        }, 8, null, false);
    }

    private void reportDT() {
        VideoReport.setPageId(this.contentLayout, PAGE_ID);
        HashMap hashMap = new HashMap();
        hashMap.put(IFileBrowserService.FILE_BROWSER_PAGE_FROM, String.valueOf(this.fromSource));
        VideoReport.setPageParams(this.contentLayout, PageParams.builder().setBasicParams(hashMap).build());
        VideoReport.setPageReportPolicy(this.contentLayout, PageReportPolicy.REPORT_ALL);
        VideoReport.reportPgIn(this.contentLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showReadyJoinMember(String str) {
        this.digits = new StringBuffer(str);
        if (!str.equals("1234") && !str.equals("1111") && !str.equals("2222") && !str.equals("3333") && !str.equals("0000")) {
            this.progress.setVisibility(0);
            this.progress.setBackgroundDrawable(this.mProgressDrawable);
            ((Animatable) this.mProgressDrawable).start();
            if (NetworkUtil.isNetSupport(this)) {
                oneWayRequest(2);
                this.isExitedHall = true;
                return;
            }
            showToast(1, getString(R.string.cjm));
            VerifyCodeView verifyCodeView = this.mVerifyCodeView;
            if (verifyCodeView != null) {
                verifyCodeView.reset();
            }
            ((Animatable) this.mProgressDrawable).stop();
            this.progress.setVisibility(4);
            if (this.mHandler.hasMessages(1)) {
                this.mHandler.removeMessages(1);
            }
            this.mHandler.sendEmptyMessageDelayed(1, 600L);
            return;
        }
        if (this.mHandler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
        this.mHandler.sendEmptyMessageDelayed(1, 600L);
        QQToast.makeText(this.mContext, getString(R.string.i3h), 0).show();
        ReportController.o(this.app, "CliOper", "", "", "0X80041AD", "0X80041AD", 0, 0, "", "", "", "");
        VerifyCodeView verifyCodeView2 = this.mVerifyCodeView;
        if (verifyCodeView2 != null) {
            verifyCodeView2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.selectmember.a
                @Override // java.lang.Runnable
                public final void run() {
                    CreateFaceToFaceDiscussionActivity.this.lambda$showReadyJoinMember$0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uiChange() {
        String str;
        this.isEnteredHall = true;
        this.bottomLayout.setVisibility(0);
        if (TextUtils.isDigitsOnly(this.digits.toString())) {
            str = this.digits.toString();
        } else {
            str = "";
        }
        ReportController.o(this.app, "CliOper", "", "", "0X80041AA", "0X80041AA", 0, 0, str, "", "", "");
    }

    @Override // com.tencent.mobileqq.activity.LbsBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.LbsBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle)).booleanValue();
        }
        setTheme(R.style.f173428d2);
        super.doOnCreate(bundle);
        com.tencent.relation.common.utils.a.a(this, -1, 1);
        setContentView(R.layout.by8);
        this.mContext = getApplicationContext();
        int intExtra = getIntent().getIntExtra("create_source", 7);
        this.createSource = intExtra;
        if (intExtra == 4 || intExtra == 5) {
            this.fromSource = 2;
        }
        initUi();
        this.app.addObserver(this.mNearFieldDisObsever);
        this.mSessionId = Math.abs(new Random().nextInt());
        this.mGridViewAdapter = new g();
        GridView gridView = (GridView) findViewById(R.id.cx6);
        this.mGridview = gridView;
        gridView.setAdapter((ListAdapter) this.mGridViewAdapter);
        nearfield_discuss$UserProfile nearfield_discuss_userprofile = new nearfield_discuss$UserProfile();
        this.mSelf = nearfield_discuss_userprofile;
        nearfield_discuss_userprofile.uint64_uin.set(Long.parseLong(this.app.getAccount()));
        getSelfNickname(this.mSelf);
        this.isEnteredHall = false;
        this.mNetWorkReceiver = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.mNetWorkReceiver, intentFilter);
        checkLbsOnlySystemSwitch(new Runnable() { // from class: com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CreateFaceToFaceDiscussionActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        ReportController.o(this.app, "dc00899", "Grp_create_new", "", "face_create", "exp", 0, 0, "", "" + this.createSource, "", "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.LbsBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.doOnDestroy();
        this.app.removeObserver(this.mNearFieldDisObsever);
        this.mHandler.removeMessages(1);
        ThreadManager.getSubThreadHandler().removeCallbacks(this.mGetSelfNickRunnable);
        if (this.isExitedHall && NetworkUtil.isNetSupport(this)) {
            oneWayRequest(4);
        }
        try {
            unregisterReceiver(this.mNetWorkReceiver);
        } catch (Exception unused) {
        }
        VideoReport.reportPgOut(this.contentLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4) {
            if (this.isEnteredHall) {
                ReportController.o(this.app, "CliOper", "", "", "0X80041AE", "0X80041AE", 0, 0, "", "", "", "");
            } else {
                ReportController.o(this.app, "CliOper", "", "", "0X80041A9", "0X80041A9", 0, 0, "", "", "", "");
            }
            finish();
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.doOnPause();
        if (this.isEnteredHall && this.mHandler.hasMessages(0)) {
            this.mHandler.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.doOnResume();
        if (this.isEnteredHall) {
            if (this.mHandler.hasMessages(0)) {
                this.mHandler.removeMessages(0);
            }
            this.mHandler.sendEmptyMessage(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.doOnStart();
        getWindow().setSoftInputMode(16);
        VerifyCodeView verifyCodeView = this.mVerifyCodeView;
        if (verifyCodeView != null) {
            verifyCodeView.requestFocus();
            ((InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(this.mVerifyCodeView, 1);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.finish();
            overridePendingTransition(0, R.anim.f154423k);
        }
    }

    String getDescription() {
        StringBuilder sb5 = this.f186159sb;
        sb5.delete(0, sb5.length());
        int length = this.digits.length();
        if (length > 0) {
            for (int i3 = 0; i3 < length; i3++) {
                this.f186159sb.append(this.digits.charAt(i3));
                if (i3 < length - 1) {
                    this.f186159sb.append('\uff0c');
                }
            }
        }
        return this.f186159sb.toString();
    }

    @Override // com.tencent.mobileqq.activity.LbsBaseActivity
    protected void notifyShowLbsEnableDlg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            ReportController.o(this.app, "CliOper", "", "", "0X80041AB", "0X80041AB", 0, 0, "", "", "", "");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else if (view.getId() == R.id.bbt) {
            int i3 = 1;
            QLog.i(TAG, 1, "[onClick] create_troop_btn");
            this.isExitedHall = false;
            enterDiscussOrTroop();
            HashMap hashMap = new HashMap();
            hashMap.put("dt_pgid", PAGE_ID);
            hashMap.put("pgid", PAGE_ID);
            hashMap.put(IFileBrowserService.FILE_BROWSER_PAGE_FROM, Integer.valueOf(this.fromSource));
            HashMap hashMap2 = new HashMap();
            if (this.mCreateTroopBtn.getText().equals("\u52a0\u5165\u7fa4\u804a")) {
                i3 = 2;
            }
            hashMap2.put("btn_state", Integer.valueOf(i3));
            hashMap2.putAll(hashMap);
            hashMap2.put("cur_pg", hashMap);
            hashMap2.put("dt_eid", CREATE_BTN_ELEMENT_ID);
            hashMap2.put("eid", CREATE_BTN_ELEMENT_ID);
            VideoReport.reportEvent("clck", hashMap2);
            if (this.mMemberList.size() == 0) {
                ReportController.o(this.app, "dc00899", "Grp_create_new", "", "suc_create", "clk_now", 0, 0, "", "" + this.createSource, "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.LbsBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.activity.LbsBaseActivity
    protected void onEnableClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            ReportController.o(this.app, "CliOper", "", "", "0X80041AC", "0X80041AC", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }
}
