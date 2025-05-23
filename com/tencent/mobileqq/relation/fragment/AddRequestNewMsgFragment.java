package com.tencent.mobileqq.relation.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.addfriend.api.IFriendRequestApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.guild.api.IGuildAddQQFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.qzonefeeds.AddFriendShowQZoneFeedsPart;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.ay;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mobileqq.widget.AddRequestTabContainer;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.TempChatPrepareInfo;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.UiThreadUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import tencent.im.s2c.frdsysmsg.FrdSysMsg$AddtionInfo;
import tencent.mobileim.structmsg.structmsg$AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg$StructMsg;
import tencent.mobileim.structmsg.structmsg$SystemMsg;
import tencent.mobileim.structmsg.structmsg$SystemMsgAction;
import tencent.mobileim.structmsg.structmsg$SystemMsgActionInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AddRequestNewMsgFragment extends QIphoneTitleBarFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private TextView C;
    private TextView D;
    private Button E;
    private Button F;
    private ViewGroup G;
    private QQAppInterface H;
    private Context I;
    private QQProgressDialog J;
    private QQCustomDialog K;
    private AddRequestTabContainer L;
    private structmsg$StructMsg M;
    private SysSuspiciousMsg N;
    private boolean P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;
    private int W;
    private int X;
    private int Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f280600a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f280601b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f280602c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f280603d0;

    /* renamed from: e0, reason: collision with root package name */
    private Serializable f280604e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f280605f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f280606g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f280607h0;

    /* renamed from: i0, reason: collision with root package name */
    private long f280608i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f280609j0;

    /* renamed from: k0, reason: collision with root package name */
    private long f280610k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f280611l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f280612m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f280613n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f280614o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f280615p0;

    /* renamed from: q0, reason: collision with root package name */
    private ar f280616q0;

    /* renamed from: r0, reason: collision with root package name */
    private bs f280617r0;

    /* renamed from: s0, reason: collision with root package name */
    com.tencent.mobileqq.addfriend.observer.a f280618s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f280619t0;

    /* renamed from: u0, reason: collision with root package name */
    com.tencent.mobileqq.discussion.observer.a f280620u0;

    /* renamed from: v0, reason: collision with root package name */
    private Runnable f280621v0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestNewMsgFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                AddRequestNewMsgFragment.this.K.dismiss();
                AddRequestNewMsgFragment.this.f280606g0 = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f280627d;

        b(ActionSheet actionSheet) {
            this.f280627d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestNewMsgFragment.this, (Object) actionSheet);
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
                if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                    NewReportPlugin.T(AddRequestNewMsgFragment.this.getQBaseActivity(), AddRequestNewMsgFragment.this.R, null, AddRequestNewMsgFragment.this.H.getCurrentAccountUin(), 20010, null);
                } else {
                    QQToast.makeText(AddRequestNewMsgFragment.this.I, R.string.f171139ci4, 0).show(AddRequestNewMsgFragment.this.getTitleBarHeight());
                }
            }
            this.f280627d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class c implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f280629d;

        c(ActionSheet actionSheet) {
            this.f280629d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestNewMsgFragment.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 0) {
                if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                    long currStructMsgKey = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
                    AddRequestNewMsgFragment.this.M = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(currStructMsgKey));
                    if (AddRequestNewMsgFragment.this.M != null) {
                        int i17 = AddRequestNewMsgFragment.this.M.msg_type.get();
                        long j3 = AddRequestNewMsgFragment.this.M.msg_seq.get();
                        long j16 = AddRequestNewMsgFragment.this.M.req_uin.get();
                        int i18 = AddRequestNewMsgFragment.this.M.f436065msg.sub_type.get();
                        int i19 = AddRequestNewMsgFragment.this.M.f436065msg.src_id.get();
                        int i26 = AddRequestNewMsgFragment.this.M.f436065msg.sub_src_id.get();
                        int i27 = AddRequestNewMsgFragment.this.M.f436065msg.group_msg_type.get();
                        List<structmsg$SystemMsgAction> list = AddRequestNewMsgFragment.this.M.f436065msg.actions.get();
                        if (list != null && 1 < list.size()) {
                            list.get(1).action_info.get().blacklist.set(true);
                            AddRequestNewMsgFragment.this.f280619t0 = true;
                            AddRequestNewMsgFragment.this.H.getMsgHandler().m3().r0(i17, j3, j16, i18, i19, i26, i27, list.get(1).action_info.get(), 1, null, false);
                            AddRequestNewMsgFragment.this.showProgressDialog();
                        } else {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("shield, ");
                            if (list != null) {
                                i16 = list.size();
                            } else {
                                i16 = -1;
                            }
                            sb5.append(i16);
                            QLog.d("Q.systemmsg.AddRequestNewMsgFragment", 1, sb5.toString());
                        }
                    } else {
                        QLog.d("Q.systemmsg.AddRequestNewMsgFragment", 1, "shield");
                    }
                } else {
                    QQToast.makeText(AddRequestNewMsgFragment.this.I, R.string.f171139ci4, 0).show(AddRequestNewMsgFragment.this.getTitleBarHeight());
                }
            }
            this.f280629d.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class d extends ar {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestNewMsgFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        public void onAgreeSuspiciousMsg(boolean z16, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.systemmsg.AddRequestNewMsgFragment", 2, "onAgreeSuspiciousMsg " + z16 + " " + i3 + " " + j3);
            }
            if (AddRequestNewMsgFragment.this.N != null && AddRequestNewMsgFragment.this.N.uin == j3) {
                AddRequestNewMsgFragment.this.dismissProgressDialog();
                if (z16) {
                    QQToast.makeText(AddRequestNewMsgFragment.this.getActivity(), HardCodeUtil.qqStr(R.string.j4o), 0).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("base_uin", String.valueOf(AddRequestNewMsgFragment.this.N.uin));
                    bundle.putString("base_nick", AddRequestNewMsgFragment.this.N.nick);
                    bundle.putString("verfy_msg", AddRequestNewMsgFragment.this.N.f203119msg);
                    bundle.putBoolean("param_go_back_after_setting_done", AddRequestNewMsgFragment.this.f280615p0);
                    AutoRemarkActivity.startRemarkAfterAgree(AddRequestNewMsgFragment.this.getQBaseActivity(), 0, AddRequestNewMsgFragment.this.N.uin + "", 0L, bundle);
                    return;
                }
                QQToast.makeText(AddRequestNewMsgFragment.this.getActivity(), HardCodeUtil.qqStr(R.string.j4p), 0).show();
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateAnswerAddedFriend(boolean z16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AddRequestNewMsgFragment.this.dismissProgressDialog();
                if (!z16) {
                    AddRequestNewMsgFragment addRequestNewMsgFragment = AddRequestNewMsgFragment.this;
                    addRequestNewMsgFragment.showToast(addRequestNewMsgFragment.getString(R.string.he7));
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("base_uin", str);
                String str2 = AddRequestNewMsgFragment.this.S;
                if (TextUtils.isEmpty(AddRequestNewMsgFragment.this.S)) {
                    str2 = AddRequestNewMsgFragment.this.R;
                }
                bundle.putString("base_nick", str2);
                bundle.putInt("verfy_type", AddRequestNewMsgFragment.this.W);
                bundle.putString("verfy_msg", AddRequestNewMsgFragment.this.U);
                if (AddRequestNewMsgFragment.this.f280604e0 == null) {
                    z17 = false;
                }
                bundle.putBoolean("isFromWzry", z17);
                bundle.putBoolean("param_go_back_after_setting_done", AddRequestNewMsgFragment.this.f280615p0);
                AutoRemarkActivity.startRemarkAfterAgree(AddRequestNewMsgFragment.this.getQBaseActivity(), 0, str, 0L, bundle);
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class e extends bs {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestNewMsgFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bs
        public void onSendSystemMsgActionError(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                AddRequestNewMsgFragment.this.dismissProgressDialog();
                QQToast.makeText(AddRequestNewMsgFragment.this.I, 1, AddRequestNewMsgFragment.this.getString(R.string.huv), 0).show(AddRequestNewMsgFragment.this.getTitleBarHeight());
                AddRequestNewMsgFragment.this.f280619t0 = false;
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bs
        public void onSendSystemMsgActionFin(boolean z16, String str, int i3, String str2, int i16, int i17, String str3, String str4, int i18) {
            String str5;
            String string;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AddRequestNewMsgFragment.this.dismissProgressDialog();
                if (QLog.isColorLevel()) {
                    QLog.d("Q.systemmsg.AddRequestNewMsgFragment", 2, cq.w(String.format("onSendSystemMsgActionFin isSuc=%s actionType=%s msgDetail=%s resultCode=%s", Boolean.valueOf(z16), Integer.valueOf(i3), str2, Integer.valueOf(i16)), 2));
                }
                long currStructMsgKey = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
                if (!TextUtils.isEmpty(str)) {
                    try {
                        currStructMsgKey = Long.parseLong(str);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
                structmsg$StructMsg structMsgFromMap = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(currStructMsgKey));
                if (!z16) {
                    if (!TextUtils.isEmpty(str3)) {
                        string = str3;
                    } else {
                        string = AddRequestNewMsgFragment.this.getResources().getString(R.string.he7);
                    }
                    QQToast.makeText(AddRequestNewMsgFragment.this.I, 1, string, 0).show(AddRequestNewMsgFragment.this.getTitleBarHeight());
                    if (com.tencent.mobileqq.systemmsg.a.e(structMsgFromMap, i17, str2, str4)) {
                        AddRequestNewMsgFragment.this.getQBaseActivity().finish();
                    }
                } else {
                    com.tencent.mobileqq.systemmsg.a.d(structMsgFromMap, i3, str2, i16);
                    if (AddRequestNewMsgFragment.this.f280619t0 && structMsgFromMap != null) {
                        structMsgFromMap.f436065msg.friend_info.msg_blacklist.setHasFlag(false);
                    }
                    if (i3 == 1) {
                        AddRequestNewMsgFragment.this.getQBaseActivity().setResult(-1);
                        AddRequestNewMsgFragment.this.getQBaseActivity().finish();
                        str5 = AddRequestNewMsgFragment.this.getResources().getString(R.string.f170974bd4);
                    } else if (i3 == 0 && structMsgFromMap != null) {
                        String string2 = AddRequestNewMsgFragment.this.getResources().getString(R.string.bcs);
                        Bundle bundle = new Bundle();
                        bundle.putString("base_uin", String.valueOf(structMsgFromMap.req_uin.get()));
                        String str6 = AddRequestNewMsgFragment.this.S;
                        if (TextUtils.isEmpty(AddRequestNewMsgFragment.this.S)) {
                            str6 = AddRequestNewMsgFragment.this.R;
                        }
                        bundle.putString("base_nick", str6);
                        bundle.putInt("verfy_type", AddRequestNewMsgFragment.this.W);
                        bundle.putString("verfy_msg", AddRequestNewMsgFragment.this.U);
                        if (AddRequestNewMsgFragment.this.f280604e0 == null) {
                            z17 = false;
                        }
                        bundle.putBoolean("isFromWzry", z17);
                        bundle.putBoolean("param_go_back_after_setting_done", AddRequestNewMsgFragment.this.f280615p0);
                        AutoRemarkActivity.startRemarkAfterAgree(AddRequestNewMsgFragment.this.getQBaseActivity(), 0, String.valueOf(structMsgFromMap.req_uin.get()), currStructMsgKey, bundle);
                        str5 = string2;
                    } else {
                        str5 = null;
                    }
                    QQToast.makeText(AddRequestNewMsgFragment.this.I, 2, str5, 0).show(AddRequestNewMsgFragment.this.getTitleBarHeight());
                }
                AddRequestNewMsgFragment.this.f280619t0 = false;
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2, Integer.valueOf(i16), Integer.valueOf(i17), str3, str4, Integer.valueOf(i18));
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class f extends com.tencent.mobileqq.addfriend.observer.a {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestNewMsgFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.observer.a
        public void a(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, obj);
                return;
            }
            if (obj != null) {
                List<AddRequestTabContainer.a> a16 = AddRequestTabContainer.a.a((List) obj);
                AddRequestNewMsgFragment.this.L.setSimpleTheme(AddRequestNewMsgFragment.this.f280613n0);
                AddRequestNewMsgFragment.this.L.setNightTheme(AddRequestNewMsgFragment.this.f280612m0);
                AddRequestNewMsgFragment.this.L.setData(a16);
                return;
            }
            QLog.d("Q.systemmsg.AddRequestNewMsgFragment", 1, "getAddFriendRequestTag fail");
            if (AddRequestNewMsgFragment.this.L != null) {
                AddRequestNewMsgFragment.this.L.setVisibility(8);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.observer.a
        public void b(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
                return;
            }
            if (!(obj instanceof String)) {
                return;
            }
            TextView textView = (TextView) AddRequestNewMsgFragment.this.findViewById(R.id.nickname);
            String str = (String) obj;
            if (!TextUtils.isEmpty(str) && textView != null) {
                textView.setText(str);
                AddRequestNewMsgFragment.this.S = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class g implements IOperateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Intent f280634a;

        g(Intent intent) {
            this.f280634a = intent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestNewMsgFragment.this, (Object) intent);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            if (i3 != 0) {
                QLog.e("Q.systemmsg.AddRequestNewMsgFragment", 1, "msgService.prepareTempChat is error, errorMsg is " + str);
                return;
            }
            if (AddRequestNewMsgFragment.this.I == null) {
                QLog.e("Q.systemmsg.AddRequestNewMsgFragment", 1, "msgService.prepareTempChat is error, mContext is invalid!");
            } else {
                AddRequestNewMsgFragment.this.I.startActivity(this.f280634a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class h implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestNewMsgFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            AddRequestNewMsgFragment addRequestNewMsgFragment = AddRequestNewMsgFragment.this;
            boolean z16 = true;
            if (i3 != 1) {
                z16 = false;
            }
            addRequestNewMsgFragment.f280606g0 = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class i implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestNewMsgFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            AddRequestNewMsgFragment addRequestNewMsgFragment = AddRequestNewMsgFragment.this;
            if (addRequestNewMsgFragment.bi(addRequestNewMsgFragment.f280606g0)) {
                AddRequestNewMsgFragment.this.showProgressDialog();
                AddRequestNewMsgFragment addRequestNewMsgFragment2 = AddRequestNewMsgFragment.this;
                addRequestNewMsgFragment2.f280619t0 = addRequestNewMsgFragment2.f280606g0;
            }
            AddRequestNewMsgFragment.this.K.dismiss();
            AddRequestNewMsgFragment.this.f280606g0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class j extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public int f280638d;

        /* renamed from: e, reason: collision with root package name */
        public String f280639e;

        /* renamed from: f, reason: collision with root package name */
        public Bundle f280640f;

        public j(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, bundle);
                return;
            }
            this.f280638d = i3;
            this.f280639e = str;
            this.f280640f = bundle;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Context context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            if (view != null) {
                context = view.getContext();
            } else {
                context = null;
            }
            if (context == null) {
                return;
            }
            int i3 = this.f280638d;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            ((IGuildAddQQFriendApi) QRoute.api(IGuildAddQQFriendApi.class)).jumpToGuild(context, this.f280640f.getString("key_guild_url"));
                            return;
                        }
                        return;
                    }
                    try {
                        AllInOne allInOne = new AllInOne(this.f280640f.getString("key_profile_uin"), this.f280640f.getInt("key_profile_pa", 25));
                        allInOne.profileEntryType = 109;
                        allInOne.chatAbility = this.f280640f.getInt("key_profile_chatability");
                        ProfileUtils.openProfileCard(context, allInOne);
                        return;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
                try {
                    Intent intent = new Intent(context, (Class<?>) DiscussionInfoCardActivity.class);
                    intent.putExtras(this.f280640f);
                    context.startActivity(intent);
                    return;
                } catch (Exception e17) {
                    e17.printStackTrace();
                    return;
                }
            }
            TroopUtils.I(context, this.f280640f, 2);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
            } else {
                textPaint.setColor(-12541697);
            }
        }
    }

    public AddRequestNewMsgFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.M = null;
        this.N = null;
        this.P = false;
        this.T = null;
        this.U = "";
        this.V = "";
        this.X = 3041;
        this.Y = 0;
        this.Z = null;
        this.f280600a0 = null;
        this.f280601b0 = null;
        this.f280602c0 = null;
        this.f280603d0 = null;
        this.f280610k0 = 0L;
        this.f280611l0 = null;
        this.f280612m0 = false;
        this.f280613n0 = false;
        this.f280614o0 = false;
        this.f280615p0 = false;
        this.f280616q0 = new d();
        this.f280617r0 = new e();
        this.f280618s0 = new f();
        this.f280619t0 = false;
        this.f280620u0 = new com.tencent.mobileqq.discussion.observer.a() { // from class: com.tencent.mobileqq.relation.fragment.AddRequestNewMsgFragment.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddRequestNewMsgFragment.this);
                }
            }

            @Override // com.tencent.mobileqq.discussion.observer.a
            protected void f(boolean z16, int i3, long j3, ArrayList<String> arrayList) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), arrayList);
                } else if (z16 && j3 == AddRequestNewMsgFragment.this.f280610k0 && AddRequestNewMsgFragment.this.f280610k0 != 0) {
                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.relation.fragment.AddRequestNewMsgFragment.6.3
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                AddRequestNewMsgFragment.this.ii();
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.discussion.observer.a
            protected void g(boolean z16, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), str);
                } else if (z16 && AddRequestNewMsgFragment.this.f280610k0 != 0 && String.valueOf(AddRequestNewMsgFragment.this.f280610k0).equals(str)) {
                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.relation.fragment.AddRequestNewMsgFragment.6.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                AddRequestNewMsgFragment.this.ii();
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.discussion.observer.a
            protected void w(boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), obj);
                } else if (AddRequestNewMsgFragment.this.f280610k0 != 0 && z16 && (obj instanceof ArrayList) && ((ArrayList) obj).contains(Long.valueOf(AddRequestNewMsgFragment.this.f280610k0))) {
                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.relation.fragment.AddRequestNewMsgFragment.6.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                AddRequestNewMsgFragment.this.ii();
                            }
                        }
                    });
                }
            }
        };
        this.f280621v0 = new Runnable() { // from class: com.tencent.mobileqq.relation.fragment.AddRequestNewMsgFragment.11
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddRequestNewMsgFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    FragmentActivity activity = AddRequestNewMsgFragment.this.getActivity();
                    if (activity != null && !activity.isFinishing()) {
                        if (AddRequestNewMsgFragment.this.J == null) {
                            AddRequestNewMsgFragment.this.J = new QQProgressDialog(AddRequestNewMsgFragment.this.I);
                        }
                        AddRequestNewMsgFragment.this.J.setMessage(R.string.hex);
                        if (!AddRequestNewMsgFragment.this.J.isShowing()) {
                            AddRequestNewMsgFragment.this.J.show();
                            return;
                        }
                        return;
                    }
                    QLog.e("Q.systemmsg.AddRequestNewMsgFragment", 1, "showProgressDialog activity is null or finish");
                } catch (Exception e16) {
                    QLog.e("Q.systemmsg.AddRequestNewMsgFragment", 1, "showProgressDialog error", e16);
                }
            }
        };
    }

    private void Sh() {
        this.f280612m0 = QQTheme.isNowThemeIsNight();
        this.f280613n0 = SimpleUIUtil.getSimpleUISwitch();
    }

    private void Uh() {
        structmsg$SystemMsg structmsg_systemmsg;
        structmsg$SystemMsg structmsg_systemmsg2;
        structmsg$SystemMsg structmsg_systemmsg3;
        structmsg$SystemMsg structmsg_systemmsg4;
        Intent intent = getActivity().getIntent();
        Serializable serializableExtra = intent.getSerializableExtra("msg_extra");
        if (serializableExtra instanceof SysSuspiciousMsg) {
            this.P = true;
            this.N = (SysSuspiciousMsg) serializableExtra;
            this.Q = getString(R.string.hug);
            this.R = String.valueOf(this.N.uin);
            SysSuspiciousMsg sysSuspiciousMsg = this.N;
            this.S = sysSuspiciousMsg.nick;
            this.U = sysSuspiciousMsg.f203119msg;
            this.V = sysSuspiciousMsg.source;
            this.f280600a0 = sysSuspiciousMsg.entity_category;
            this.f280601b0 = sysSuspiciousMsg.entity_name;
            this.f280602c0 = sysSuspiciousMsg.entity_url;
            this.f280607h0 = intent.getIntExtra(QQHealthReportApiImpl.MSG_TYPE_KEY, -1006);
            return;
        }
        structmsg$StructMsg structMsgFromMap = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(((INewFriendApi) QRoute.api(INewFriendApi.class)).getCurrStructMsgKey()));
        this.M = structMsgFromMap;
        if (structMsgFromMap != null && (structmsg_systemmsg4 = structMsgFromMap.f436065msg) != null && structmsg_systemmsg4.uint32_source_flag.get() == 8) {
            this.f280610k0 = this.M.f436065msg.uint64_discuss_uin.get();
        }
        structmsg$StructMsg structmsg_structmsg = this.M;
        if (structmsg_structmsg != null && (structmsg_systemmsg3 = structmsg_structmsg.f436065msg) != null && structmsg_systemmsg3.bytes_name_more.has()) {
            this.T = new String(this.M.f436065msg.bytes_name_more.get().toByteArray());
        }
        this.Q = intent.getStringExtra("msg_title");
        this.R = intent.getStringExtra("infouin");
        this.S = intent.getStringExtra("strNickName");
        this.U = intent.getStringExtra("verify_msg");
        this.W = intent.getIntExtra("verify_type", 1);
        this.V = intent.getStringExtra("msg_source");
        this.X = intent.getIntExtra("msg_source_id", 3041);
        this.Y = intent.getIntExtra("msg_sub_source_id", 0);
        this.Z = intent.getStringExtra("info_dealwith_msg");
        this.f280607h0 = intent.getIntExtra(QQHealthReportApiImpl.MSG_TYPE_KEY, -1006);
        this.f280608i0 = intent.getLongExtra("msg_troopuin", 0L);
        if (intent.hasExtra(IProfileCardConst.KEY_WZRY_DATA)) {
            this.f280604e0 = intent.getSerializableExtra(IProfileCardConst.KEY_WZRY_DATA);
        }
        structmsg$StructMsg structmsg_structmsg2 = this.M;
        if (structmsg_structmsg2 != null && (structmsg_systemmsg2 = structmsg_structmsg2.f436065msg) != null && TextUtils.isEmpty(structmsg_systemmsg2.msg_additional.get())) {
            this.U = this.M.f436065msg.msg_describe.get();
        }
        FrdSysMsg$AddtionInfo frdSysMsg$AddtionInfo = new FrdSysMsg$AddtionInfo();
        try {
            structmsg$StructMsg structmsg_structmsg3 = this.M;
            if (structmsg_structmsg3 != null && (structmsg_systemmsg = structmsg_structmsg3.f436065msg) != null && structmsg_systemmsg.has() && this.M.f436065msg.bytes_addtion.has()) {
                frdSysMsg$AddtionInfo.mergeFrom(this.M.f436065msg.bytes_addtion.get().toByteArray());
                this.f280600a0 = frdSysMsg$AddtionInfo.str_entity_category.get();
                this.f280601b0 = frdSysMsg$AddtionInfo.str_entity_name.get();
                this.f280602c0 = frdSysMsg$AddtionInfo.str_entity_url.get();
            }
        } catch (InvalidProtocolBufferMicroException unused) {
            QLog.d("Q.systemmsg.AddRequestNewMsgFragment", 1, "decode FrdSysMsg.AddtionInfo failed!");
        }
        this.f280615p0 = intent.getBooleanExtra("param_go_back_after_setting_done", false);
        structmsg$StructMsg structmsg_structmsg4 = this.M;
        if (structmsg_structmsg4 != null && structmsg_structmsg4.f436065msg != null) {
            this.f280609j0 = ((IGuildAddQQFriendApi) QRoute.api(IGuildAddQQFriendApi.class)).isFromGuild(this.M.f436065msg.src_id.get(), this.M.f436065msg.sub_src_id.get());
        }
    }

    private int Vh() {
        Resources resources;
        Context context = this.I;
        if (context != null) {
            resources = context.getResources();
        } else {
            resources = null;
        }
        if (resources == null) {
            return 0;
        }
        int dimension = (int) resources.getDimension(R.dimen.f158169bx3);
        int dimension2 = (int) resources.getDimension(R.dimen.f158166bx0);
        int dimension3 = (int) resources.getDimension(R.dimen.f158167bx1);
        return (ViewUtils.getScreenWidth() - (((((dimension * 2) + dimension2) + dimension3) + ((int) resources.getDimension(R.dimen.f158168bx2))) + ((int) resources.getDimension(R.dimen.bwz)))) - 2;
    }

    private void Wh() {
        int i3;
        boolean z16 = false;
        if (!NetworkUtil.isNetSupport(this.I)) {
            QQToast.makeText(this.I, getString(R.string.f171137ci2), 0).show(getTitleBarHeight());
            return;
        }
        structmsg$StructMsg structMsgFromMap = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(((INewFriendApi) QRoute.api(INewFriendApi.class)).getCurrStructMsgKey()));
        if (structMsgFromMap != null) {
            int i16 = structMsgFromMap.msg_type.get();
            long j3 = structMsgFromMap.msg_seq.get();
            long j16 = structMsgFromMap.req_uin.get();
            int i17 = structMsgFromMap.f436065msg.sub_type.get();
            int i18 = structMsgFromMap.f436065msg.src_id.get();
            int i19 = structMsgFromMap.f436065msg.sub_src_id.get();
            int i26 = structMsgFromMap.f436065msg.group_msg_type.get();
            List<structmsg$SystemMsgAction> list = structMsgFromMap.f436065msg.actions.get();
            if (list != null && list.size() > 0) {
                structmsg$SystemMsgActionInfo structmsg_systemmsgactioninfo = list.get(0).action_info.get();
                structmsg_systemmsgactioninfo.remark.set("");
                structmsg_systemmsgactioninfo.group_id.set(0);
                structmsg$AddFrdSNInfo structmsg_addfrdsninfo = new structmsg$AddFrdSNInfo();
                structmsg_addfrdsninfo.uint32_not_see_dynamic.set(0);
                structmsg_addfrdsninfo.uint32_set_sn.set(0);
                structmsg_systemmsgactioninfo.addFrdSNInfo.set(structmsg_addfrdsninfo);
                this.H.getMsgHandler().m3().r0(i16, j3, j16, i17, i18, i19, i26, structmsg_systemmsgactioninfo, 0, structMsgFromMap, false);
                z16 = true;
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("agree, ");
                if (list != null) {
                    i3 = list.size();
                } else {
                    i3 = -1;
                }
                sb5.append(i3);
                QLog.d("Q.systemmsg.AddRequestNewMsgFragment", 1, sb5.toString());
            }
        } else {
            QLog.d("Q.systemmsg.AddRequestNewMsgFragment", 1, "agree");
        }
        if (z16) {
            showProgressDialog();
        }
    }

    private void Xh() {
        if (!NetworkUtil.isNetSupport(this.I)) {
            QQToast.makeText(this.I, getString(R.string.f171137ci2), 0).show(getTitleBarHeight());
            return;
        }
        if (this.K == null) {
            this.K = DialogUtil.createDialogWithCheckBox(this.I, 0, getString(R.string.ykr), null, getString(R.string.ykq), false, getString(R.string.cancel), getString(R.string.f171151ok), new h(), new i(), new a());
        }
        if (!this.K.isShowing()) {
            this.K.show();
        }
    }

    private void Yh() {
        Intent aliasIntent;
        int i3;
        int i16 = this.X;
        if (i16 == 3999) {
            i16 = 3041;
        }
        this.X = i16;
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.R);
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "Q.systemmsg.AddRequestNewMsgFragment");
        boolean isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "Q.systemmsg.AddRequestNewMsgFragment");
        if (this.f280615p0) {
            aliasIntent = new Intent(this.I, (Class<?>) ChatActivity.class);
        } else {
            aliasIntent = SplashActivity.getAliasIntent(this.I);
        }
        Intent m3 = BaseAIOUtils.m(aliasIntent, null);
        m3.putExtra("uin", this.R);
        m3.putExtra(AppConstants.Key.ADD_FRIEND_SOURCE_ID, this.X);
        if (isFriend) {
            if (friendsSimpleInfoWithUid != null) {
                m3.putExtra(AppConstants.Key.CSPECIAL_FLAG, (int) friendsSimpleInfoWithUid.e().byteValue());
                m3.putExtra("uinname", friendsSimpleInfoWithUid.m());
            }
        } else {
            String b16 = ay.b(this.R);
            if (TextUtils.isEmpty(b16)) {
                b16 = this.S;
            }
            m3.putExtra("uinname", b16);
            m3.putExtra(IProfileCardConst.KEY_WZRY_DATA, this.f280604e0);
        }
        if (isFriend) {
            i3 = 0;
        } else {
            int i17 = this.X;
            if (i17 != 2007 && i17 != 3007 && i17 != 4007) {
                if (i17 != 2019 && i17 != 3019) {
                    i3 = 1022;
                } else {
                    i3 = 1010;
                }
            } else {
                i3 = 1001;
            }
        }
        m3.putExtra("uintype", i3);
        m3.putExtra("key_need_prepare", true);
        ai(m3);
    }

    private void Zh() {
        ((FriendListHandler) this.H.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).agreeSuspiciousMsg(this.N.uin);
    }

    private void ai(Intent intent) {
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.R);
        if (TextUtils.isEmpty(uidFromUin)) {
            QLog.e("Q.systemmsg.AddRequestNewMsgFragment", 1, "prepareTempChatAndEnterChat is error! peerUid is invalid!");
            return;
        }
        intent.putExtra("key_peerId", uidFromUin);
        w msgService = ((IKernelService) this.H.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.e("Q.systemmsg.AddRequestNewMsgFragment", 1, "prepareTempChatAndEnterChat is error! msgService is invalid!");
        } else {
            msgService.prepareTempChat(new TempChatPrepareInfo(101, uidFromUin, intent.getStringExtra("uinname"), "", new byte[0], this.H.getCurrentUid(), "", null), new g(intent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bi(boolean z16) {
        boolean z17;
        structmsg$StructMsg structMsgFromMap = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(((INewFriendApi) QRoute.api(INewFriendApi.class)).getCurrStructMsgKey()));
        this.M = structMsgFromMap;
        if (structMsgFromMap != null) {
            int i3 = structMsgFromMap.msg_type.get();
            long j3 = this.M.msg_seq.get();
            long j16 = this.M.req_uin.get();
            int i16 = this.M.f436065msg.sub_type.get();
            int i17 = this.M.f436065msg.src_id.get();
            int i18 = this.M.f436065msg.sub_src_id.get();
            int i19 = this.M.f436065msg.group_msg_type.get();
            List<structmsg$SystemMsgAction> list = this.M.f436065msg.actions.get();
            if (list != null && list.size() >= 1) {
                structmsg$SystemMsgActionInfo structmsg_systemmsgactioninfo = list.get(1).action_info.get();
                if (z16) {
                    structmsg_systemmsgactioninfo.blacklist.set(true);
                }
                this.H.getMsgHandler().m3().r0(i3, j3, j16, i16, i17, i18, i19, structmsg_systemmsgactioninfo, 1, null, false);
                z17 = true;
                if (QLog.isColorLevel()) {
                    QLog.d("Q.systemmsg.AddRequestNewMsgFragment", 2, String.format("sendRefuseRequest withShield=%s hasSendRequest=%s", Boolean.valueOf(z16), Boolean.valueOf(z17)));
                }
                return z17;
            }
        }
        z17 = false;
        if (QLog.isColorLevel()) {
        }
        return z17;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b0, code lost:
    
        if (((com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService.class)).isFriend(((com.tencent.relation.common.api.IRelationNTUinAndUidApi) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.relation.common.api.IRelationNTUinAndUidApi.class)).getUidFromUin(r7.R), "Q.systemmsg.AddRequestNewMsgFragment") == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void ci() {
        boolean z16;
        TextView textView = (TextView) findViewById(R.id.is_);
        View findViewById = findViewById(R.id.f163904bu);
        structmsg$StructMsg structmsg_structmsg = this.M;
        if (structmsg_structmsg != null && structmsg_structmsg.f436065msg.has() && this.M.f436065msg.get() != null && this.M.f436065msg.actions.has() && this.M.f436065msg.actions.get() != null) {
            z16 = true;
            if (this.M.f436065msg.actions.get().size() > 1 && this.M.f436065msg.friend_info.has() && this.M.f436065msg.friend_info.msg_blacklist.has() && this.M.f436065msg.friend_info.msg_blacklist.get().length() > 0) {
                this.f280605f0 = this.M.f436065msg.friend_info.msg_blacklist.get();
            }
        }
        z16 = false;
        if (z16) {
            findViewById.setVisibility(0);
            textView.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
            textView.setVisibility(8);
        }
    }

    private void di() {
        structmsg$SystemMsg structmsg_systemmsg;
        List<structmsg$SystemMsgAction> list;
        Button button = (Button) findViewById(R.id.f164076jc);
        Button button2 = (Button) findViewById(R.id.i5s);
        if (this.P) {
            button2.setVisibility(8);
            button.setVisibility(0);
            return;
        }
        button.setVisibility(8);
        button2.setVisibility(8);
        structmsg$StructMsg structmsg_structmsg = this.M;
        if (structmsg_structmsg != null && (structmsg_systemmsg = structmsg_structmsg.f436065msg) != null && structmsg_systemmsg.actions.get() != null && (list = this.M.f436065msg.actions.get()) != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                String str = list.get(i3).detail_name.get();
                if (i3 == 0) {
                    button.setVisibility(0);
                    button.setText(str);
                } else if (i3 == 1) {
                    button2.setVisibility(0);
                    button2.setText(str);
                }
            }
        }
        if (this.W == 2) {
            button2.setVisibility(8);
        }
        button2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissProgressDialog() {
        UiThreadUtil.remove(this.f280621v0);
        try {
            FragmentActivity activity = getActivity();
            if (activity != null && !activity.isFinishing()) {
                QQProgressDialog qQProgressDialog = this.J;
                if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                    this.J.dismiss();
                    return;
                }
                return;
            }
            QLog.e("Q.systemmsg.AddRequestNewMsgFragment", 1, "dismissProgressDialog activity is null or finish");
        } catch (Exception e16) {
            QLog.e("Q.systemmsg.AddRequestNewMsgFragment", 1, "dismissProgressDialog error", e16);
        }
    }

    private void ei() {
        int i3;
        structmsg$SystemMsg structmsg_systemmsg;
        if (this.f280614o0) {
            return;
        }
        TextView textView = (TextView) findViewById(R.id.gxw);
        structmsg$StructMsg structmsg_structmsg = this.M;
        if (structmsg_structmsg != null && (structmsg_systemmsg = structmsg_structmsg.f436065msg) != null && structmsg_systemmsg.uint32_source_flag.has()) {
            i3 = this.M.f436065msg.uint32_source_flag.get();
        } else {
            i3 = 0;
        }
        if ((i3 & 32) == 32) {
            textView.setVisibility(0);
            this.f280614o0 = true;
        } else {
            textView.setVisibility(8);
        }
    }

    private void fi() {
        String str;
        View findViewById = findViewById(R.id.zgf);
        TextView textView = (TextView) findViewById.findViewById(R.id.f58132p7);
        ImageView imageView = (ImageView) findViewById.findViewById(R.id.f58122p6);
        if (!TextUtils.isEmpty(this.f280600a0)) {
            findViewById.setVisibility(0);
            if (TextUtils.isEmpty(this.f280601b0)) {
                str = "";
            } else {
                str = this.f280601b0;
            }
            textView.setText(str);
            if (!TextUtils.isEmpty(this.f280601b0) && !TextUtils.isEmpty(this.f280602c0)) {
                this.f280603d0 = this.f280602c0;
                imageView.setVisibility(0);
                return;
            }
            return;
        }
        findViewById.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends View> T findViewById(@IdRes int i3) {
        return (T) ((QIphoneTitleBarFragment) this).mContentView.findViewById(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTitleBarHeight() {
        return getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    private void gi() {
        if (this.f280614o0) {
            return;
        }
        TextView textView = (TextView) findViewById(R.id.f1c);
        if (!TextUtils.isEmpty(this.Z)) {
            textView.setText(this.Z);
            textView.setVisibility(0);
            this.f280614o0 = true;
            return;
        }
        textView.setVisibility(8);
    }

    private void hi() {
        boolean z16;
        FaceDrawable faceDrawable;
        ImageView imageView = (ImageView) findViewById(R.id.c0o);
        int i3 = this.X;
        if (i3 != 3007 && i3 != 3019 && i3 != 2007 && i3 != 4007 && i3 != 2019) {
            z16 = false;
        } else {
            z16 = !((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.R), "Q.systemmsg.AddRequestNewMsgFragment");
        }
        if (z16) {
            faceDrawable = FaceDrawable.getStrangerFaceDrawable((AppInterface) this.H, 200, this.R, true);
        } else {
            faceDrawable = FaceDrawable.getFaceDrawable(this.H, 1, this.R);
        }
        imageView.setBackgroundDrawable(faceDrawable);
    }

    private void initDtReport() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.titleRoot, "pg_user_request");
        VideoReport.setPageParams(this.titleRoot, "user_request_sourceid", Integer.valueOf(this.X));
        VideoReport.setPageParams(this.titleRoot, "user_request_subsourceid", Integer.valueOf(this.Y));
        VideoReport.setPageParams(this.titleRoot, "to_uin", this.R);
        VideoReport.setPageParams(this.titleRoot, "recommend_reason", this.V);
        TextView textView = (TextView) findViewById(R.id.i7i);
        this.C = textView;
        VideoReport.setElementId(textView, "em_user_request_respond");
        TextView textView2 = this.C;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(textView2, clickPolicy);
        TextView textView3 = this.C;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_FIRST;
        VideoReport.setElementExposePolicy(textView3, exposurePolicy);
        TextView textView4 = (TextView) this.titleRoot.findViewById(R.id.ivTitleBtnLeft);
        this.D = textView4;
        VideoReport.setElementId(textView4, "em_user_request_back");
        VideoReport.setElementClickPolicy(this.D, clickPolicy);
        VideoReport.setElementExposePolicy(this.D, exposurePolicy);
        Button button = (Button) findViewById(R.id.i5s);
        this.E = button;
        VideoReport.setElementId(button, "em_user_request_reject");
        VideoReport.setElementClickPolicy(this.E, clickPolicy);
        VideoReport.setElementExposePolicy(this.E, exposurePolicy);
        Button button2 = (Button) findViewById(R.id.f164076jc);
        this.F = button2;
        VideoReport.setElementId(button2, "em_user_request_agree");
        VideoReport.setElementClickPolicy(this.F, clickPolicy);
        VideoReport.setElementExposePolicy(this.F, exposurePolicy);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.alp);
        this.G = viewGroup;
        VideoReport.setElementId(viewGroup, "em_user_request_top_info");
        VideoReport.setElementClickPolicy(this.G, clickPolicy);
        VideoReport.setElementExposePolicy(this.G, exposurePolicy);
    }

    private void initView() {
        if (((QIphoneTitleBarFragment) this).mContentView == null) {
            return;
        }
        findViewById(R.id.alp).setOnClickListener(this);
        findViewById(R.id.i7i).setOnClickListener(this);
        findViewById(R.id.zgf).setOnClickListener(this);
        findViewById(R.id.f164076jc).setOnClickListener(this);
        findViewById(R.id.i5s).setOnClickListener(this);
        findViewById(R.id.is_).setOnClickListener(this);
        findViewById(R.id.f163905bv).setOnClickListener(this);
        findViewById(R.id.gxw).setOnClickListener(this);
        ni();
        oi();
        hi();
        ji();
        li();
        pi();
        ki();
        ii();
        fi();
        di();
        ci();
        gi();
        mi();
        ei();
        Sh();
        if (AppSetting.f99565y) {
            AccessibilityUtil.n(findViewById(R.id.adr), false);
            AccessibilityUtil.o(findViewById(R.id.i7i));
        }
    }

    private void ji() {
        String str;
        TextView textView = (TextView) findViewById(R.id.nickname);
        TextView textView2 = (TextView) findViewById(R.id.zqz);
        if (!TextUtils.isEmpty(this.S)) {
            textView.setText(this.S);
        } else {
            textView.setText(this.R);
        }
        if (!TextUtils.isEmpty(this.T)) {
            str = this.T;
        } else {
            str = this.R;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "0")) {
            textView2.setVisibility(0);
            textView2.setText("(" + tr2.g.f(18, str) + ")");
            int desiredWidth = (int) Layout.getDesiredWidth(textView2.getText(), textView2.getPaint());
            int desiredWidth2 = (int) Layout.getDesiredWidth(textView.getText(), textView.getPaint());
            int Vh = Vh();
            if (desiredWidth2 + desiredWidth > Vh) {
                textView.setMaxWidth(Vh - desiredWidth);
                textView2.setMinWidth(desiredWidth);
                return;
            }
            return;
        }
        textView2.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void ki() {
        boolean z16;
        TextView textView = (TextView) findViewById(R.id.i7i);
        structmsg$StructMsg structmsg_structmsg = this.M;
        if (structmsg_structmsg != null && structmsg_structmsg.f436065msg.has()) {
            switch (this.M.f436065msg.sub_type.get()) {
                case 1:
                case 2:
                case 3:
                case 9:
                case 10:
                    z16 = true;
                    break;
            }
            if (!z16) {
                textView.setVisibility(0);
                return;
            } else {
                textView.setVisibility(8);
                return;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    private void li() {
        this.L = (AddRequestTabContainer) findViewById(R.id.j_a);
    }

    private void mi() {
        if (this.f280614o0) {
            return;
        }
        TextView textView = (TextView) findViewById(R.id.jmn);
        int i3 = this.X;
        if (i3 != 3014 && i3 != 2014) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            this.f280614o0 = true;
        }
    }

    private void ni() {
        setTitle(this.Q);
    }

    private void oi() {
        if (!this.P) {
            return;
        }
        TextView textView = (TextView) findViewById(R.id.f166996mb3);
        if (!TextUtils.isEmpty(this.N.reason)) {
            textView.setVisibility(0);
            textView.setText(this.N.reason);
        } else {
            textView.setVisibility(8);
        }
        Drawable drawable = getResources().getDrawable(R.drawable.qzone_commo_black_tips_icon_caution);
        drawable.setBounds(0, 0, ViewUtils.dip2px(16.0f), ViewUtils.dip2px(16.0f));
        textView.setCompoundDrawablePadding(ViewUtils.dip2px(5.0f));
        textView.setCompoundDrawables(drawable, null, null, null);
    }

    private void pi() {
        View findViewById = findViewById(R.id.knm);
        TextView textView = (TextView) findViewById(R.id.knl);
        if (!TextUtils.isEmpty(this.U)) {
            findViewById.setVisibility(0);
            textView.setText(this.U);
        } else {
            findViewById.setVisibility(8);
        }
    }

    private void qi() {
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.I, null);
        actionSheet.addButton(getString(R.string.f170689yn), 3);
        actionSheet.setOnButtonClickListener(new b(actionSheet));
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog() {
        UiThreadUtil.runOnUiThread(this.f280621v0, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        if (!getQBaseActivity().isResume()) {
            return;
        }
        QQToast.makeText(this.I, str, 0).show(getTitleBarHeight());
        getQBaseActivity().finish();
    }

    public void Th() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (this.H != null && !TextUtils.isEmpty(this.R)) {
            ((IFriendRequestApi) QRoute.api(IFriendRequestApi.class)).friendRequestTag(this.H, Long.parseLong(this.R));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AddFriendShowQZoneFeedsPart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        initView();
        initDtReport();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return R.layout.h5e;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void ii() {
        String str;
        String str2;
        String str3;
        String str4;
        Resources resources;
        String str5;
        long j3;
        String str6;
        structmsg$StructMsg structmsg_structmsg;
        String str7;
        String str8;
        boolean z16;
        int i3;
        structmsg$SystemMsg structmsg_systemmsg;
        structmsg$StructMsg structmsg_structmsg2;
        structmsg$SystemMsg structmsg_systemmsg2;
        structmsg$StructMsg structmsg_structmsg3;
        structmsg$SystemMsg structmsg_systemmsg3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        TextView textView = (TextView) findViewById(R.id.f1z);
        textView.setSingleLine(false);
        Resources resources2 = textView.getContext().getResources();
        String str9 = this.V;
        long j16 = this.f280610k0;
        if (j16 != 0) {
            String q16 = ac.q(this.H, String.valueOf(j16));
            this.f280611l0 = q16;
            if (!TextUtils.isEmpty(q16) && !TextUtils.isEmpty(this.V)) {
                str9 = String.format(Locale.getDefault(), "%s-%s", this.V, this.f280611l0);
            }
        }
        if (this.f280609j0 && (structmsg_structmsg3 = this.M) != null && (structmsg_systemmsg3 = structmsg_structmsg3.f436065msg) != null) {
            String stringUtf8 = structmsg_systemmsg3.bytes_source_desc.get().toStringUtf8();
            String[] split = stringUtf8.split(ContainerUtils.FIELD_DELIMITER);
            if (split != null && split.length > 6) {
                String str10 = split[6];
                str = str10;
                str9 = String.format(Locale.getDefault(), HardCodeUtil.qqStr(R.string.f213515qe), str10);
                str2 = stringUtf8;
            } else {
                str2 = stringUtf8;
                str = null;
            }
        } else {
            str = null;
            str2 = null;
        }
        if (Utils.p(str9, textView.getText().toString())) {
            return;
        }
        if (!TextUtils.isEmpty(str9)) {
            SpannableString spannableString = new SpannableString(str9);
            structmsg$StructMsg structmsg_structmsg4 = this.M;
            if (structmsg_structmsg4 != null && (structmsg_systemmsg2 = structmsg_structmsg4.f436065msg) != null) {
                str3 = structmsg_systemmsg2.group_name.get();
                long j17 = this.M.f436065msg.group_code.get();
                if (j17 != 0) {
                    str4 = Long.toString(j17);
                    if (TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3) && str9.contains(str3)) {
                        int indexOf = str9.indexOf(str3);
                        resources = resources2;
                        spannableString.setSpan(new j(1, "Q.systemmsg.AddRequestNewMsgFragment", aq.b(str4, 101)), indexOf, indexOf + str3.length(), 33);
                        structmsg$StructMsg structmsg_structmsg5 = this.M;
                        if (structmsg_structmsg5 != null && structmsg_structmsg5.f436065msg != null && QLog.isColorLevel()) {
                            QLog.i("Q.systemmsg.AddRequestNewMsgFragment", 2, String.format("setMsgSourceInfo [type:%s, tag:%s, param:%s, src_id:%s, sub_src_id:%s, str:%s]", 1, str3, str4, Integer.valueOf(this.M.f436065msg.src_id.get()), Integer.valueOf(this.M.f436065msg.sub_src_id.get()), str9));
                        }
                    } else {
                        resources = resources2;
                    }
                    str5 = this.f280611l0;
                    j3 = this.f280610k0;
                    if (j3 == 0) {
                        str6 = Long.toString(j3);
                    } else {
                        str6 = null;
                    }
                    if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str5) && str9.contains(str5)) {
                        int indexOf2 = str9.indexOf(str5);
                        int length = str5.length() + indexOf2;
                        Bundle bundle = new Bundle();
                        bundle.putString("uin", str6);
                        bundle.putString("uinname", this.f280611l0);
                        bundle.putInt("uintype", 3000);
                        spannableString.setSpan(new j(2, "Q.systemmsg.AddRequestNewMsgFragment", bundle), indexOf2, length, 33);
                        structmsg_structmsg2 = this.M;
                        if (structmsg_structmsg2 != null && structmsg_structmsg2.f436065msg != null && QLog.isColorLevel()) {
                            QLog.i("Q.systemmsg.AddRequestNewMsgFragment", 2, String.format("setMsgSourceInfo [type:%s, tag:%s, param:%s, src_id:%s, sub_src_id:%s, str:%s]", 2, str5, str6, Integer.valueOf(this.M.f436065msg.src_id.get()), Integer.valueOf(this.M.f436065msg.sub_src_id.get()), str9));
                        }
                    }
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && str9.contains(str)) {
                        int indexOf3 = str9.indexOf(str);
                        int length2 = str.length() + indexOf3;
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("key_guild_url", str2);
                        spannableString.setSpan(new j(4, "Q.systemmsg.AddRequestNewMsgFragment", bundle2), indexOf3, length2, 33);
                    }
                    structmsg_structmsg = this.M;
                    if (structmsg_structmsg == null && (structmsg_systemmsg = structmsg_structmsg.f436065msg) != null) {
                        str7 = structmsg_systemmsg.action_uin_nick.get();
                        long j18 = this.M.f436065msg.action_uin.get();
                        if (j18 != 0) {
                            str8 = Long.toString(j18);
                            if (TextUtils.isEmpty(str8) && !TextUtils.isEmpty(str7) && str9.contains(str7)) {
                                int indexOf4 = str9.indexOf(str7);
                                int length3 = str7.length() + indexOf4;
                                if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str8), "Q.systemmsg.AddRequestNewMsgFragment")) {
                                    i3 = 1;
                                } else {
                                    i3 = 25;
                                }
                                Bundle bundle3 = new Bundle();
                                bundle3.putString("key_profile_uin", str8);
                                bundle3.putInt("key_profile_pa", i3);
                                z16 = true;
                                bundle3.putInt("key_profile_chatability", 1);
                                spannableString.setSpan(new j(3, "Q.systemmsg.AddRequestNewMsgFragment", bundle3), indexOf4, length3, 33);
                            } else {
                                z16 = true;
                            }
                            textView.setClickable(z16);
                            textView.setFocusable(z16);
                            textView.setMovementMethod(LinkMovementMethod.getInstance());
                            textView.setText(spannableString);
                            textView.setLinkTextColor(resources.getColorStateList(R.color.aew));
                            return;
                        }
                    } else {
                        str7 = null;
                    }
                    str8 = null;
                    if (TextUtils.isEmpty(str8)) {
                    }
                    z16 = true;
                    textView.setClickable(z16);
                    textView.setFocusable(z16);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    textView.setText(spannableString);
                    textView.setLinkTextColor(resources.getColorStateList(R.color.aew));
                    return;
                }
            } else {
                str3 = null;
            }
            str4 = null;
            if (TextUtils.isEmpty(str4)) {
            }
            resources = resources2;
            str5 = this.f280611l0;
            j3 = this.f280610k0;
            if (j3 == 0) {
            }
            if (!TextUtils.isEmpty(str6)) {
                int indexOf22 = str9.indexOf(str5);
                int length4 = str5.length() + indexOf22;
                Bundle bundle4 = new Bundle();
                bundle4.putString("uin", str6);
                bundle4.putString("uinname", this.f280611l0);
                bundle4.putInt("uintype", 3000);
                spannableString.setSpan(new j(2, "Q.systemmsg.AddRequestNewMsgFragment", bundle4), indexOf22, length4, 33);
                structmsg_structmsg2 = this.M;
                if (structmsg_structmsg2 != null) {
                    QLog.i("Q.systemmsg.AddRequestNewMsgFragment", 2, String.format("setMsgSourceInfo [type:%s, tag:%s, param:%s, src_id:%s, sub_src_id:%s, str:%s]", 2, str5, str6, Integer.valueOf(this.M.f436065msg.src_id.get()), Integer.valueOf(this.M.f436065msg.sub_src_id.get()), str9));
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                int indexOf32 = str9.indexOf(str);
                int length22 = str.length() + indexOf32;
                Bundle bundle22 = new Bundle();
                bundle22.putString("key_guild_url", str2);
                spannableString.setSpan(new j(4, "Q.systemmsg.AddRequestNewMsgFragment", bundle22), indexOf32, length22, 33);
            }
            structmsg_structmsg = this.M;
            if (structmsg_structmsg == null) {
            }
            str7 = null;
            str8 = null;
            if (TextUtils.isEmpty(str8)) {
            }
            z16 = true;
            textView.setClickable(z16);
            textView.setFocusable(z16);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(spannableString);
            textView.setLinkTextColor(resources.getColorStateList(R.color.aew));
            return;
        }
        textView.setText(str9);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        QBaseActivity qBaseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else if (i3 == 0 && i16 == -1 && (qBaseActivity = getQBaseActivity()) != null) {
            qBaseActivity.finish();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        VideoReport.reportEvent("dt_clck", this.D, null);
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.alp) {
                Intent intent = getActivity().getIntent();
                intent.putExtra(IProfileCardConst.KEY_WZRY_DATA, this.f280604e0);
                intent.putExtra(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 56);
                ((INewFriendApi) QRoute.api(INewFriendApi.class)).openProfileCard(this.H, this.I, this.R, this.f280608i0, this.f280607h0, this.X, intent);
                VideoReport.reportEvent("dt_clck", this.G, null);
            } else if (id5 == R.id.i7i) {
                Yh();
                VideoReport.reportEvent("dt_clck", this.C, null);
            } else if (id5 == R.id.zgf) {
                if (!TextUtils.isEmpty(this.f280603d0)) {
                    this.I.startActivity(new Intent(this.I, (Class<?>) QQBrowserActivity.class).putExtra("url", this.f280603d0));
                }
            } else if (id5 == R.id.f164076jc) {
                if (this.P) {
                    Zh();
                } else {
                    Wh();
                }
                VideoReport.reportEvent("dt_clck", this.F, null);
            } else if (id5 == R.id.i5s) {
                Xh();
                VideoReport.reportEvent("dt_clck", this.E, null);
            } else if (id5 == R.id.is_) {
                ri();
            } else if (id5 == R.id.f163905bv) {
                qi();
            } else if (id5 == R.id.gxw && com.tencent.mobileqq.webview.util.w.a(1500L)) {
                Intent intent2 = new Intent(this.I, (Class<?>) QQBrowserActivity.class);
                intent2.putExtra("url", "https://ti.qq.com/friendship_auth/index.html?_wv=3&adtag=cloneAddRequest#clone_setting");
                startActivity(intent2);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        this.H = (QQAppInterface) getQBaseActivity().getAppRuntime();
        this.I = getQBaseActivity();
        Uh();
        if (this.f280610k0 != 0) {
            this.H.addObserver(this.f280620u0, true);
        }
        this.H.addObserver(this.f280617r0);
        this.H.addObserver(this.f280616q0);
        this.H.addObserver(this.f280618s0);
        Th();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        this.H.removeHandler(getClass());
        bs bsVar = this.f280617r0;
        if (bsVar != null) {
            this.H.removeObserver(bsVar);
        }
        ar arVar = this.f280616q0;
        if (arVar != null) {
            this.H.removeObserver(arVar);
        }
        com.tencent.mobileqq.addfriend.observer.a aVar = this.f280618s0;
        if (aVar != null) {
            this.H.removeObserver(aVar);
        }
        if (this.f280610k0 != 0) {
            this.H.removeObserver(this.f280620u0);
        }
    }

    void ri() {
        String string;
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.I, null);
        if (!TextUtils.isEmpty(this.f280605f0)) {
            string = this.f280605f0;
        } else {
            string = getString(R.string.hgp);
        }
        actionSheet.setMainTitle(string);
        actionSheet.addButton(getString(R.string.hk9), 3);
        actionSheet.setOnButtonClickListener(new c(actionSheet));
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.show();
    }
}
