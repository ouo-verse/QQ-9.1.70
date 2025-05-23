package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c$CardInfo;
import tencent.im.s2c.frdsysmsg.FrdSysMsg$AddtionInfo;
import tencent.mobileim.structmsg.structmsg$AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg$StructMsg;
import tencent.mobileim.structmsg.structmsg$SystemMsg;
import tencent.mobileim.structmsg.structmsg$SystemMsgAction;
import tencent.mobileim.structmsg.structmsg$SystemMsgActionInfo;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AddRequestActivity extends DialogBaseActivity implements AppConstants, View.OnClickListener {
    static IPatchRedirector $redirector_;
    private TextView A0;
    View B0;
    URLImageView C0;
    structmsg$StructMsg D0;
    long E0;
    String F0;
    String G0;
    private QQCustomDialog H0;
    private boolean I0;
    private boolean J0;
    protected float K0;
    protected float L0;
    View.OnClickListener M0;
    View.OnClickListener N0;
    View.OnClickListener O0;
    private com.tencent.mobileqq.app.ar P0;
    private com.tencent.mobileqq.app.bs Q0;
    CardObserver R0;
    private boolean S0;
    com.tencent.mobileqq.discussion.observer.a T0;

    /* renamed from: a0, reason: collision with root package name */
    private long f174792a0;

    /* renamed from: b0, reason: collision with root package name */
    private long f174793b0;

    /* renamed from: c0, reason: collision with root package name */
    String f174794c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f174795d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f174796e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f174797f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f174798g0;

    /* renamed from: h0, reason: collision with root package name */
    private long f174799h0;

    /* renamed from: i0, reason: collision with root package name */
    private Serializable f174800i0;

    /* renamed from: j0, reason: collision with root package name */
    Button f174801j0;

    /* renamed from: k0, reason: collision with root package name */
    Button f174802k0;

    /* renamed from: l0, reason: collision with root package name */
    Button f174803l0;

    /* renamed from: m0, reason: collision with root package name */
    TextView f174804m0;

    /* renamed from: n0, reason: collision with root package name */
    QQCustomDialog f174805n0;

    /* renamed from: o0, reason: collision with root package name */
    Dialog f174806o0;

    /* renamed from: p0, reason: collision with root package name */
    CardHandler f174807p0;

    /* renamed from: q0, reason: collision with root package name */
    private final int f174808q0;

    /* renamed from: r0, reason: collision with root package name */
    int f174809r0;

    /* renamed from: s0, reason: collision with root package name */
    byte[] f174810s0;

    /* renamed from: t0, reason: collision with root package name */
    public long f174811t0;

    /* renamed from: u0, reason: collision with root package name */
    public String f174812u0;

    /* renamed from: v0, reason: collision with root package name */
    private TextView f174813v0;

    /* renamed from: w0, reason: collision with root package name */
    private TextView f174814w0;

    /* renamed from: x0, reason: collision with root package name */
    private TextView f174815x0;

    /* renamed from: y0, reason: collision with root package name */
    TextView f174816y0;

    /* renamed from: z0, reason: collision with root package name */
    TextView f174817z0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.AddRequestActivity$10, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass10 extends com.tencent.mobileqq.app.ar {
        static IPatchRedirector $redirector_;

        AnonymousClass10() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateAnswerAddedFriend(boolean z16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
                return;
            }
            if (AddRequestActivity.this.dismissProgressDialog()) {
                if (!z16) {
                    AddRequestActivity addRequestActivity = AddRequestActivity.this;
                    addRequestActivity.showToast(R.drawable.f160601l6, addRequestActivity.getString(R.string.he7));
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("base_uin", str);
                String str2 = AddRequestActivity.this.f174812u0;
                if (TextUtils.isEmpty(str2)) {
                    str2 = AddRequestActivity.this.f174794c0;
                }
                bundle.putString("base_nick", str2);
                bundle.putInt("verfy_type", AddRequestActivity.this.f174797f0);
                bundle.putString("verfy_msg", AddRequestActivity.this.f174795d0);
                if (AddRequestActivity.this.f174800i0 == null) {
                    z17 = false;
                }
                bundle.putBoolean("isFromWzry", z17);
                AutoRemarkActivity.startRemarkAfterAgree(AddRequestActivity.this, 0, str, 0L, bundle);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
            } else if (z16 && (str2 = AddRequestActivity.this.f174794c0) != null && str2.equals(str)) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.AddRequestActivity.10.1
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
                            return;
                        }
                        Card r16 = ((FriendsManager) AddRequestActivity.this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(AddRequestActivity.this.f174794c0);
                        if (r16 != null) {
                            AddRequestActivity.this.runOnUiThread(new Runnable(r16) { // from class: com.tencent.mobileqq.activity.AddRequestActivity.10.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ Card f174822d;

                                {
                                    this.f174822d = r16;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) r16);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    structmsg$SystemMsg structmsg_systemmsg;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    structmsg$StructMsg structmsg_structmsg = AddRequestActivity.this.D0;
                                    if (structmsg_structmsg != null && (structmsg_systemmsg = structmsg_structmsg.f436065msg) != null && structmsg_systemmsg.friend_info.has() && AddRequestActivity.this.D0.f436065msg.friend_info.msg_joint_friend.has()) {
                                        AddRequestActivity.this.A0.setText(AddRequestActivity.this.D0.f436065msg.friend_info.msg_joint_friend.get());
                                        AddRequestActivity.this.A0.setVisibility(0);
                                    } else {
                                        AddRequestActivity.this.A0.setVisibility(8);
                                        AddRequestActivity.this.v3(this.f174822d);
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.d("Q.systemmsg.AddRequestActivity", 2, "Card find Uin :" + AddRequestActivity.this.f174794c0 + "age:" + ((int) this.f174822d.age) + "gender:" + ((int) this.f174822d.shGender));
                                    }
                                }
                            });
                        }
                    }
                }, 5, null, true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                AddRequestActivity.this.f174805n0.cancel();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                long longValue = Long.valueOf(AddRequestActivity.this.app.getCurrentAccountUin()).longValue();
                AddRequestActivity.this.showDialog(2);
                AddRequestActivity addRequestActivity = AddRequestActivity.this;
                addRequestActivity.f174807p0.I4(longValue, Long.valueOf(addRequestActivity.f174794c0).longValue(), 1);
                return;
            }
            QQToast.makeText(AddRequestActivity.this, R.string.f171139ci4, 0).show(AddRequestActivity.this.getTitleBarHeight());
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends com.tencent.mobileqq.app.bs {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onInsertIntoBlackList(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            Dialog dialog = AddRequestActivity.this.f174806o0;
            if (dialog != null && dialog.isShowing()) {
                AddRequestActivity.this.dismissDialog(2);
            }
            AddRequestActivity addRequestActivity = AddRequestActivity.this;
            addRequestActivity.showToast(R.drawable.f160604l9, addRequestActivity.getString(R.string.hk8));
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onRemoveFromBlackList(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
                return;
            }
            Dialog dialog = AddRequestActivity.this.f174806o0;
            if (dialog != null && dialog.isShowing()) {
                AddRequestActivity.this.dismissDialog(2);
            }
            AddRequestActivity addRequestActivity = AddRequestActivity.this;
            addRequestActivity.showToast(R.drawable.f160604l9, addRequestActivity.getString(R.string.hjt));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bs
        public void onSendSystemMsgActionError(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                return;
            }
            if (AddRequestActivity.this.dismissProgressDialog()) {
                QQToast.makeText(AddRequestActivity.this, 1, AddRequestActivity.this.getString(R.string.huv), 0).show(AddRequestActivity.this.getTitleBarHeight());
            } else if (QLog.isColorLevel()) {
                QLog.d("Q.systemmsg.AddRequestActivity", 2, "onSendSystemMsgActionError");
            }
            AddRequestActivity.this.S0 = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bs
        public void onSendSystemMsgActionFin(boolean z16, String str, int i3, String str2, int i16, int i17, String str3, String str4, int i18) {
            String str5;
            String string;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2, Integer.valueOf(i16), Integer.valueOf(i17), str3, str4, Integer.valueOf(i18));
                return;
            }
            if (!AddRequestActivity.this.dismissProgressDialog()) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.systemmsg.AddRequestActivity", 2, "onSendSystemMsgActionFin");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.systemmsg.AddRequestActivity", 2, String.format("onSendSystemMsgActionFin isSuc=%s actionType=%s msgDetail=%s resultCode=%s", Boolean.valueOf(z16), Integer.valueOf(i3), str2, Integer.valueOf(i16)));
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
                    string = AddRequestActivity.this.getResources().getString(R.string.he7);
                }
                QQToast.makeText(AddRequestActivity.this, 1, string, 0).show(AddRequestActivity.this.getTitleBarHeight());
                if (com.tencent.mobileqq.systemmsg.a.e(structMsgFromMap, i17, str2, str4)) {
                    AddRequestActivity.this.finish();
                }
            } else {
                com.tencent.mobileqq.systemmsg.a.d(structMsgFromMap, i3, str2, i16);
                if (AddRequestActivity.this.S0 && structMsgFromMap != null) {
                    structMsgFromMap.f436065msg.friend_info.msg_blacklist.setHasFlag(false);
                }
                if (i3 == 1) {
                    AddRequestActivity.this.setResult(-1);
                    AddRequestActivity.this.finish();
                    str5 = AddRequestActivity.this.getResources().getString(R.string.f170974bd4);
                } else if (i3 == 0 && structMsgFromMap != null) {
                    String string2 = AddRequestActivity.this.getResources().getString(R.string.bcs);
                    Bundle bundle = new Bundle();
                    bundle.putString("base_uin", String.valueOf(structMsgFromMap.req_uin.get()));
                    String str6 = AddRequestActivity.this.f174812u0;
                    if (TextUtils.isEmpty(str6)) {
                        str6 = AddRequestActivity.this.f174794c0;
                    }
                    bundle.putString("base_nick", str6);
                    bundle.putInt("verfy_type", AddRequestActivity.this.f174797f0);
                    bundle.putString("verfy_msg", AddRequestActivity.this.f174795d0);
                    if (AddRequestActivity.this.f174800i0 == null) {
                        z17 = false;
                    }
                    bundle.putBoolean("isFromWzry", z17);
                    AutoRemarkActivity.startRemarkAfterAgree(AddRequestActivity.this, 0, String.valueOf(structMsgFromMap.req_uin.get()), currStructMsgKey, bundle);
                    str5 = string2;
                } else {
                    str5 = null;
                }
                QQToast.makeText(AddRequestActivity.this, 2, str5, 0).show(AddRequestActivity.this.getTitleBarHeight());
            }
            AddRequestActivity.this.S0 = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d extends CardObserver {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onImpeach(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            if (!AddRequestActivity.this.f174794c0.equals(str)) {
                return;
            }
            if (z16) {
                AddRequestActivity addRequestActivity = AddRequestActivity.this;
                addRequestActivity.showToast(R.drawable.f160604l9, addRequestActivity.getString(R.string.f170692yq));
            } else {
                AddRequestActivity addRequestActivity2 = AddRequestActivity.this;
                addRequestActivity2.showToast(R.drawable.f160601l6, addRequestActivity2.getString(R.string.f170690yo));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            AddRequestActivity addRequestActivity = AddRequestActivity.this;
            boolean z16 = true;
            if (i3 != 1) {
                z16 = false;
            }
            addRequestActivity.I0 = z16;
            ReportController.o(AddRequestActivity.this.app, "dc00898", "", "", "0X800B084", "0X800B084", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            AddRequestActivity addRequestActivity = AddRequestActivity.this;
            if (addRequestActivity.i3(addRequestActivity.I0)) {
                AddRequestActivity.this.showProgressDialog(R.string.hex, 1000L, false);
                AddRequestActivity addRequestActivity2 = AddRequestActivity.this;
                addRequestActivity2.S0 = addRequestActivity2.I0;
            }
            AddRequestActivity.this.H0.dismiss();
            AddRequestActivity.this.I0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                AddRequestActivity.this.H0.dismiss();
                AddRequestActivity.this.I0 = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Intent intent = AddRequestActivity.this.getIntent();
                intent.putExtra(IProfileCardConst.KEY_WZRY_DATA, AddRequestActivity.this.f174800i0);
                INewFriendApi iNewFriendApi = (INewFriendApi) QRoute.api(INewFriendApi.class);
                AddRequestActivity addRequestActivity = AddRequestActivity.this;
                QQAppInterface qQAppInterface = addRequestActivity.app;
                String str = addRequestActivity.f174794c0;
                long j3 = addRequestActivity.f174799h0;
                AddRequestActivity addRequestActivity2 = AddRequestActivity.this;
                iNewFriendApi.openProfileCard(qQAppInterface, addRequestActivity, str, j3, addRequestActivity2.f174809r0, addRequestActivity2.f174798g0, intent);
                if (AddRequestActivity.this.f174800i0 != null) {
                    ReportController.o(AddRequestActivity.this.app, "CliOper", "", "", "0X800843E", "0X800843E", 0, 0, "", "", "", "");
                }
                ReportController.o(AddRequestActivity.this.app, "CliOper", "", "", "0X800AA42", "0X800AA42", 0, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f174836d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f174837e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f174838f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f174839h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f174840i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f174841m;

        i(String str, Activity activity, QQAppInterface qQAppInterface, String str2, String str3, String str4) {
            this.f174836d = str;
            this.f174837e = activity;
            this.f174838f = qQAppInterface;
            this.f174839h = str2;
            this.f174840i = str3;
            this.f174841m = str4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, activity, qQAppInterface, str2, str3, str4);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!TextUtils.isEmpty(this.f174836d)) {
                this.f174837e.startActivity(new Intent(this.f174837e, (Class<?>) QQBrowserActivity.class).putExtra("url", this.f174836d));
                ReportController.o(this.f174838f, "dc00898", "", "", "0X800B757", "0X800B757", 0, 0, this.f174839h, this.f174840i, "", "");
                if (QLog.isColorLevel()) {
                    QLog.d(this.f174841m, 2, "setEntityInfo jumpurl:" + this.f174836d);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class j implements IAddAcceptBlockStrategy.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean[] f174842a;

        j(boolean[] zArr) {
            this.f174842a = zArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this, (Object) zArr);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
        public void onSuccess() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AddRequestActivity addRequestActivity = AddRequestActivity.this;
            if (addRequestActivity.f174809r0 == -1011) {
                FriendListHandler friendListHandler = (FriendListHandler) addRequestActivity.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                long parseLong = Long.parseLong(AddRequestActivity.this.f174794c0);
                AddRequestActivity addRequestActivity2 = AddRequestActivity.this;
                friendListHandler.confirmContactFriend(0, parseLong, addRequestActivity2.f174811t0, addRequestActivity2.f174810s0, (byte) 0, addRequestActivity2.f174812u0, addRequestActivity2.f174793b0, AddRequestActivity.this.f174792a0);
                this.f174842a[0] = true;
            } else {
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
                        AddRequestActivity.this.app.getMsgHandler().m3().r0(i16, j3, j16, i17, i18, i19, i26, structmsg_systemmsgactioninfo, 0, structMsgFromMap, false);
                        this.f174842a[0] = true;
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("agree, ");
                        if (list != null) {
                            i3 = list.size();
                        } else {
                            i3 = -1;
                        }
                        sb5.append(i3);
                        QLog.d("Q.systemmsg.AddRequestActivity", 1, sb5.toString());
                    }
                } else {
                    QLog.d("Q.systemmsg.AddRequestActivity", 1, "agree");
                }
            }
            ReportController.o(AddRequestActivity.this.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
            if (AddRequestActivity.this.f174800i0 != null) {
                ReportController.o(AddRequestActivity.this.app, "CliOper", "", "", "0X800843F", "0X800843F", 0, 0, "", "", "", "");
            }
            ReportController.o(AddRequestActivity.this.app, "CliOper", "", "", "0X800AA41", "0X800AA41", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class k implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f174844d;

        k(ActionSheet actionSheet) {
            this.f174844d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this, (Object) actionSheet);
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
                    AddRequestActivity addRequestActivity = AddRequestActivity.this;
                    NewReportPlugin.T(addRequestActivity, addRequestActivity.f174794c0, null, addRequestActivity.app.getCurrentAccountUin(), 20010, null);
                } else {
                    QQToast.makeText(AddRequestActivity.this, R.string.f171139ci4, 0).show(AddRequestActivity.this.getTitleBarHeight());
                }
            }
            this.f174844d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class l implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f174846d;

        l(ActionSheet actionSheet) {
            this.f174846d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this, (Object) actionSheet);
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
                    AddRequestActivity.this.D0 = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(currStructMsgKey));
                    structmsg$StructMsg structmsg_structmsg = AddRequestActivity.this.D0;
                    if (structmsg_structmsg != null) {
                        int i17 = structmsg_structmsg.msg_type.get();
                        long j3 = AddRequestActivity.this.D0.msg_seq.get();
                        long j16 = AddRequestActivity.this.D0.req_uin.get();
                        int i18 = AddRequestActivity.this.D0.f436065msg.sub_type.get();
                        int i19 = AddRequestActivity.this.D0.f436065msg.src_id.get();
                        int i26 = AddRequestActivity.this.D0.f436065msg.sub_src_id.get();
                        int i27 = AddRequestActivity.this.D0.f436065msg.group_msg_type.get();
                        List<structmsg$SystemMsgAction> list = AddRequestActivity.this.D0.f436065msg.actions.get();
                        if (list != null && 1 < list.size()) {
                            list.get(1).action_info.get().blacklist.set(true);
                            AddRequestActivity.this.S0 = true;
                            AddRequestActivity.this.app.getMsgHandler().m3().r0(i17, j3, j16, i18, i19, i26, i27, list.get(1).action_info.get(), 1, null, false);
                            AddRequestActivity.this.showProgressDialog(R.string.hex, 1000L, false);
                        } else {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("shield, ");
                            if (list != null) {
                                i16 = list.size();
                            } else {
                                i16 = -1;
                            }
                            sb5.append(i16);
                            QLog.d("Q.systemmsg.AddRequestActivity", 1, sb5.toString());
                        }
                    } else {
                        QLog.d("Q.systemmsg.AddRequestActivity", 1, "shield");
                    }
                } else {
                    QQToast.makeText(AddRequestActivity.this, R.string.f171139ci4, 0).show(AddRequestActivity.this.getTitleBarHeight());
                }
                ReportController.o(AddRequestActivity.this.app, "CliOper", "", "", "Verification_msg", "Vfc_shield_clk", 0, 0, "", "", "", "");
                ReportController.o(AddRequestActivity.this.app, "CliOper", "", "", "0X800AA45", "0X800AA45", 0, 0, "", "", "", "");
            }
            this.f174846d.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class m implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(AddRequestActivity.this.app, "CliOper", "", "", "0X800AA46", "0X800AA46", 0, 0, "", "", "", "");
                AddRequestActivity.this.t3();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class n implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AddRequestActivity.this.u3();
                ReportController.o(AddRequestActivity.this.app, "CliOper", "", "", "0X800AA44", "0X800AA44", 0, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class o implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            int i16;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(AddRequestActivity.this.app, "CliOper", "", "", "Verification_msg", "Vfc_answ_clk", 0, 0, "", "", "", "");
                AddRequestActivity addRequestActivity = AddRequestActivity.this;
                if (addRequestActivity.f174798g0 != 3999) {
                    i3 = AddRequestActivity.this.f174798g0;
                } else {
                    i3 = 3041;
                }
                addRequestActivity.f174798g0 = i3;
                String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(AddRequestActivity.this.f174794c0);
                boolean isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "Q.systemmsg.AddRequestActivity");
                Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(AddRequestActivity.this), null);
                m3.putExtra("uin", AddRequestActivity.this.f174794c0);
                m3.putExtra(AppConstants.Key.ADD_FRIEND_SOURCE_ID, AddRequestActivity.this.f174798g0);
                if (isFriend) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "Q.systemmsg.AddRequestActivity");
                    if (friendsSimpleInfoWithUid != null) {
                        m3.putExtra(AppConstants.Key.CSPECIAL_FLAG, (int) friendsSimpleInfoWithUid.e().byteValue());
                        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
                        aVar.c(1);
                        aVar.d(uidFromUin);
                        m3.putExtra("uinname", ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar));
                    }
                } else {
                    m3.putExtra("uinname", AddRequestActivity.this.f174812u0);
                    m3.putExtra(IProfileCardConst.KEY_WZRY_DATA, AddRequestActivity.this.f174800i0);
                }
                if (isFriend) {
                    i16 = 0;
                } else if (AddRequestActivity.this.f174798g0 != 2007 && AddRequestActivity.this.f174798g0 != 3007 && AddRequestActivity.this.f174798g0 != 4007) {
                    if (AddRequestActivity.this.f174798g0 != 2019 && AddRequestActivity.this.f174798g0 != 3019) {
                        i16 = 1022;
                    } else {
                        i16 = 1010;
                    }
                } else {
                    i16 = 1001;
                }
                m3.putExtra("uintype", i16);
                AddRequestActivity.this.startActivity(m3);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class p extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public int f174851d;

        /* renamed from: e, reason: collision with root package name */
        public String f174852e;

        /* renamed from: f, reason: collision with root package name */
        public Bundle f174853f;

        public p(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AddRequestActivity.this, Integer.valueOf(i3), str, bundle);
                return;
            }
            this.f174851d = i3;
            this.f174852e = str;
            this.f174853f = bundle;
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
            int i3 = this.f174851d;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        try {
                            AllInOne allInOne = new AllInOne(this.f174853f.getString("key_profile_uin"), this.f174853f.getInt("key_profile_pa", 25));
                            allInOne.profileEntryType = 109;
                            allInOne.chatAbility = this.f174853f.getInt("key_profile_chatability");
                            ProfileUtils.openProfileCard(context, allInOne);
                            return;
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                try {
                    Intent intent = new Intent(context, (Class<?>) DiscussionInfoCardActivity.class);
                    intent.putExtras(this.f174853f);
                    context.startActivity(intent);
                    return;
                } catch (Exception e17) {
                    e17.printStackTrace();
                    return;
                }
            }
            TroopUtils.I(context, this.f174853f, 2);
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

    public AddRequestActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f174795d0 = "";
        this.f174796e0 = "";
        this.f174798g0 = BuddySource.DEFAULT;
        this.f174808q0 = 0;
        this.D0 = null;
        this.E0 = 0L;
        this.F0 = null;
        this.G0 = null;
        this.J0 = false;
        this.M0 = new m();
        this.N0 = new n();
        this.O0 = new o();
        this.P0 = new AnonymousClass10();
        this.Q0 = new c();
        this.R0 = new d();
        this.S0 = false;
        this.T0 = new com.tencent.mobileqq.discussion.observer.a() { // from class: com.tencent.mobileqq.activity.AddRequestActivity.15
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this);
                }
            }

            @Override // com.tencent.mobileqq.discussion.observer.a
            protected void f(boolean z16, int i3, long j3, ArrayList<String> arrayList) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), arrayList);
                    return;
                }
                if (z16) {
                    AddRequestActivity addRequestActivity = AddRequestActivity.this;
                    long j16 = addRequestActivity.E0;
                    if (j3 == j16 && j16 != 0) {
                        addRequestActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.AddRequestActivity.15.3
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass15.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    AddRequestActivity addRequestActivity2 = AddRequestActivity.this;
                                    addRequestActivity2.p3((TextView) addRequestActivity2.findViewById(R.id.f1z));
                                }
                            }
                        });
                    }
                }
            }

            @Override // com.tencent.mobileqq.discussion.observer.a
            protected void g(boolean z16, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), str);
                    return;
                }
                if (z16) {
                    long j3 = AddRequestActivity.this.E0;
                    if (j3 != 0 && String.valueOf(j3).equals(str)) {
                        AddRequestActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.AddRequestActivity.15.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass15.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    AddRequestActivity addRequestActivity = AddRequestActivity.this;
                                    addRequestActivity.p3((TextView) addRequestActivity.findViewById(R.id.f1z));
                                }
                            }
                        });
                    }
                }
            }

            @Override // com.tencent.mobileqq.discussion.observer.a
            protected void w(boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), obj);
                    return;
                }
                long j3 = AddRequestActivity.this.E0;
                if (j3 != 0 && z16 && (obj instanceof ArrayList) && ((ArrayList) obj).contains(Long.valueOf(j3))) {
                    AddRequestActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.AddRequestActivity.15.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass15.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                AddRequestActivity addRequestActivity = AddRequestActivity.this;
                                addRequestActivity.p3((TextView) addRequestActivity.findViewById(R.id.f1z));
                            }
                        }
                    });
                }
            }
        };
    }

    private void d3() {
        String str;
        if (!TextUtils.isEmpty(this.f174812u0)) {
            this.f174816y0.setText(this.f174812u0);
        } else {
            this.f174816y0.setText(this.f174794c0);
        }
        if (!TextUtils.isEmpty(this.G0)) {
            str = this.G0;
        } else {
            str = this.f174794c0;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "0")) {
            this.f174817z0.setVisibility(0);
            this.f174817z0.setText("(" + tr2.g.f(18, str) + ")");
            int desiredWidth = (int) Layout.getDesiredWidth(this.f174817z0.getText(), this.f174817z0.getPaint());
            int desiredWidth2 = (int) Layout.getDesiredWidth(this.f174816y0.getText(), this.f174816y0.getPaint());
            int screenWidth = ViewUtils.getScreenWidth() - ViewUtils.dip2px(130.0f);
            if (desiredWidth2 + desiredWidth > screenWidth) {
                this.f174816y0.setMaxWidth(screenWidth - desiredWidth);
                this.f174817z0.setMinWidth(desiredWidth);
                return;
            }
            return;
        }
        this.f174817z0.setVisibility(8);
    }

    private void e3() {
        FriendListHandler friendListHandler;
        if (this.app == null || TextUtils.isEmpty(this.f174794c0) || (friendListHandler = (FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)) == null) {
            return;
        }
        friendListHandler.getFriendInfo(this.f174794c0);
    }

    private void f3() {
        if (this.H0 == null) {
            this.H0 = DialogUtil.createDialogWithCheckBox(this, 0, getString(R.string.ykr), null, getString(R.string.ykq), false, getString(R.string.cancel), getString(R.string.f171151ok), new e(), new f(), new g());
        }
        if (!this.H0.isShowing()) {
            try {
                this.H0.show();
                ReportController.o(this.app, "dc00898", "", "", "0X800B083", "0X800B083", 0, 0, "", "", "", "");
            } catch (Exception e16) {
                QLog.e("Q.systemmsg.AddRequestActivity", 1, "handleRefuseClicked show dialog fail.", e16);
            }
        }
    }

    private void g3() {
        LinearLayout linearLayout;
        boolean z16;
        BusinessCard businessCard;
        List<structmsg$SystemMsgAction> list;
        this.B0 = findViewById(R.id.isx);
        this.C0 = (URLImageView) findViewById(R.id.alw);
        structmsg$StructMsg structmsg_structmsg = this.D0;
        BusinessCard businessCard2 = null;
        if (structmsg_structmsg != null && structmsg_structmsg.f436065msg.req_uin_business_card.has() && this.D0.f436065msg.card_switch.has()) {
            structmsg$SystemMsg structmsg_systemmsg = this.D0.f436065msg;
            if (structmsg_systemmsg != null && structmsg_systemmsg.actions.get() != null && (list = this.D0.f436065msg.actions.get()) != null && list.size() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.D0.f436065msg.card_switch.get() == 1 && z16) {
                Oidb_0x43c$CardInfo oidb_0x43c$CardInfo = new Oidb_0x43c$CardInfo();
                try {
                    oidb_0x43c$CardInfo.mergeFrom(this.D0.f436065msg.req_uin_business_card.get().toByteArray());
                    businessCard = new BusinessCard();
                } catch (InvalidProtocolBufferMicroException unused) {
                }
                try {
                    com.tencent.mobileqq.businessCard.b.b(businessCard, oidb_0x43c$CardInfo);
                    businessCard2 = businessCard;
                } catch (InvalidProtocolBufferMicroException unused2) {
                    businessCard2 = businessCard;
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.systemmsg.AddRequestActivity", 2, "decode CardInfo failed!");
                    }
                    linearLayout = (LinearLayout) findViewById(R.id.f166333f20);
                    if (businessCard2 == null) {
                    }
                    linearLayout.setBackgroundResource(R.drawable.f160561ka);
                }
            }
        }
        linearLayout = (LinearLayout) findViewById(R.id.f166333f20);
        if (businessCard2 == null && !TextUtils.isEmpty(businessCard2.picUrl)) {
            linearLayout.setBackgroundResource(R.drawable.f160561ka);
            this.B0.setVisibility(0);
            this.C0.setVisibility(0);
            int c16 = getResources().getDisplayMetrics().widthPixels - (com.tencent.mobileqq.util.x.c(this, 15.0f) * 2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.C0.getLayoutParams();
            layoutParams.width = c16;
            layoutParams.height = (c16 * 600) / 1000;
            this.C0.setLayoutParams(layoutParams);
            BusinessCardUtils.f(businessCard2.picUrl, this.C0, 1000, 600);
            return;
        }
        linearLayout.setBackgroundResource(R.drawable.f160561ka);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i3(boolean z16) {
        boolean z17;
        structmsg$StructMsg structMsgFromMap = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(((INewFriendApi) QRoute.api(INewFriendApi.class)).getCurrStructMsgKey()));
        this.D0 = structMsgFromMap;
        if (structMsgFromMap != null) {
            int i3 = structMsgFromMap.msg_type.get();
            long j3 = this.D0.msg_seq.get();
            long j16 = this.D0.req_uin.get();
            int i16 = this.D0.f436065msg.sub_type.get();
            int i17 = this.D0.f436065msg.src_id.get();
            int i18 = this.D0.f436065msg.sub_src_id.get();
            int i19 = this.D0.f436065msg.group_msg_type.get();
            List<structmsg$SystemMsgAction> list = this.D0.f436065msg.actions.get();
            if (list != null && list.size() >= 1) {
                structmsg$SystemMsgActionInfo structmsg_systemmsgactioninfo = list.get(1).action_info.get();
                if (z16) {
                    structmsg_systemmsgactioninfo.blacklist.set(true);
                }
                this.app.getMsgHandler().m3().r0(i3, j3, j16, i16, i17, i18, i19, structmsg_systemmsgactioninfo, 1, null, false);
                z17 = true;
                if (QLog.isColorLevel()) {
                    QLog.d("Q.systemmsg.AddRequestActivity", 2, String.format("sendRefuseRequest withShield=%s hasSendRequest=%s", Boolean.valueOf(z16), Boolean.valueOf(z17)));
                }
                return z17;
            }
        }
        z17 = false;
        if (QLog.isColorLevel()) {
        }
        return z17;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0573  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j3(boolean z16) {
        TextView textView;
        boolean z17;
        int i3;
        int i16;
        String str;
        structmsg$StructMsg structmsg_structmsg;
        TextView textView2;
        int i17;
        int i18;
        structmsg$StructMsg structmsg_structmsg2;
        boolean z18;
        structmsg$StructMsg structmsg_structmsg3;
        structmsg$StructMsg structmsg_structmsg4;
        boolean z19;
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid;
        int i19;
        FaceDrawable faceDrawable;
        structmsg$SystemMsg structmsg_systemmsg;
        structmsg$SystemMsg structmsg_systemmsg2;
        structmsg$SystemMsg structmsg_systemmsg3;
        List<structmsg$SystemMsgAction> list;
        int i26;
        structmsg$SystemMsg structmsg_systemmsg4;
        PBBytesField pBBytesField;
        structmsg$SystemMsg structmsg_systemmsg5;
        h3();
        this.f174813v0 = (TextView) findViewById(R.id.alo);
        this.f174814w0 = (TextView) findViewById(R.id.alm);
        this.f174815x0 = (TextView) findViewById(R.id.aln);
        TextView textView3 = (TextView) findViewById(R.id.f1z);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.knn);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.f166333f20);
        ImageView imageView = (ImageView) findViewById(R.id.c0o);
        this.f174816y0 = (TextView) findViewById(R.id.nickname);
        this.f174817z0 = (TextView) findViewById(R.id.zqz);
        TextView textView4 = (TextView) findViewById(R.id.knu);
        this.f174801j0 = (Button) findViewById(R.id.f164076jc);
        this.f174802k0 = (Button) findViewById(R.id.i5s);
        this.f174803l0 = (Button) findViewById(R.id.i7v);
        TextView textView5 = (TextView) findViewById(R.id.is_);
        this.f174804m0 = textView5;
        textView5.setOnClickListener(this.N0);
        structmsg$StructMsg structmsg_structmsg5 = this.D0;
        if (structmsg_structmsg5 != null && (structmsg_systemmsg5 = structmsg_structmsg5.f436065msg) != null && TextUtils.isEmpty(structmsg_systemmsg5.msg_additional.get())) {
            this.f174795d0 = this.D0.f436065msg.msg_describe.get();
        }
        TextPaint paint = textView4.getPaint();
        if (paint == null) {
            paint = new TextPaint(1);
            paint.density = this.mDensity;
        }
        if (this.L0 - paint.measureText(this.f174795d0) > 30.0f) {
            textView4.setText(this.f174795d0);
            textView = textView4;
            z17 = true;
        } else {
            linearLayout = (LinearLayout) findViewById(R.id.knm);
            TextView textView6 = (TextView) findViewById(R.id.knl);
            this.f174803l0 = (Button) findViewById(R.id.i7i);
            textView = textView6;
            z17 = false;
        }
        linearLayout.setVisibility(0);
        this.f174803l0.setOnClickListener(this.O0);
        String str2 = this.f174795d0;
        if (str2 != null && !str2.equals("")) {
            String str3 = this.f174796e0;
            if (str3 != null && !str3.equals("")) {
                linearLayout.setBackgroundResource(R.drawable.f160561ka);
                if (linearLayout.getVisibility() != 0) {
                    linearLayout.setVisibility(0);
                }
                p3(textView3);
                if (linearLayout2.getVisibility() != 0) {
                    linearLayout2.setVisibility(0);
                }
                linearLayout2.setBackgroundResource(R.drawable.f160561ka);
            } else {
                linearLayout.setBackgroundResource(R.drawable.f160540jm);
                linearLayout.setVisibility(0);
                linearLayout2.setVisibility(8);
            }
        } else {
            String str4 = this.f174795d0;
            if (str4 == null || str4.equals("")) {
                String str5 = this.f174796e0;
                if (str5 != null && !str5.equals("")) {
                    linearLayout.setVisibility(8);
                    p3(textView3);
                    if (linearLayout2.getVisibility() != 0) {
                        linearLayout2.setVisibility(0);
                    }
                    linearLayout2.setBackgroundResource(R.drawable.f160540jm);
                } else {
                    ViewGroup viewGroup = (ViewGroup) findViewById(R.id.alp);
                    viewGroup.setBackgroundResource(R.drawable.common_strip_setting_bg);
                    viewGroup.setVisibility(0);
                    linearLayout.setVisibility(8);
                    linearLayout2.setVisibility(8);
                }
            }
        }
        FrdSysMsg$AddtionInfo frdSysMsg$AddtionInfo = new FrdSysMsg$AddtionInfo();
        try {
            structmsg$StructMsg structmsg_structmsg6 = this.D0;
            if (structmsg_structmsg6 == null || (structmsg_systemmsg4 = structmsg_structmsg6.f436065msg) == null || !structmsg_systemmsg4.has() || (pBBytesField = this.D0.f436065msg.bytes_addtion) == null || !pBBytesField.has()) {
                i3 = 2;
                i16 = 8;
                str = "";
            } else {
                frdSysMsg$AddtionInfo.mergeFrom(this.D0.f436065msg.bytes_addtion.get().toByteArray());
                i3 = 2;
                i16 = 8;
                str = "";
                try {
                    l3(this.app, this, (LinearLayout) findViewById(R.id.zgf), "Q.systemmsg.AddRequestActivity", frdSysMsg$AddtionInfo.str_entity_category.get(), frdSysMsg$AddtionInfo.str_entity_name.get(), frdSysMsg$AddtionInfo.str_entity_url.get(), this.J0 ? "1" : "2", "1");
                } catch (InvalidProtocolBufferMicroException unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.systemmsg.AddRequestActivity", i3, "decode FrdSysMsg.AddtionInfo failed!");
                    }
                    this.f174801j0.setVisibility(i16);
                    this.f174802k0.setVisibility(i16);
                    structmsg_structmsg = this.D0;
                    if (structmsg_structmsg != null) {
                        while (i26 < list.size()) {
                        }
                    }
                    this.f174802k0.setVisibility(i16);
                    textView2 = (TextView) findViewById(R.id.jmn);
                    i17 = this.f174798g0;
                    if (i17 == 3014) {
                    }
                    textView2.setVisibility(0);
                    TextView textView7 = (TextView) findViewById(R.id.gxw);
                    structmsg$StructMsg structmsg_structmsg7 = this.D0;
                    if (structmsg_structmsg7 == null) {
                    }
                    if ((i18 & 32) == 32) {
                    }
                    Object[] objArr = new Object[i3];
                    objArr[0] = "uint32_source_flag=";
                    objArr[1] = Integer.valueOf(i18);
                    QLog.d("Q.systemmsg.AddRequestActivity", 1, objArr);
                    ((TextView) findViewById(R.id.f163905bv)).setOnClickListener(this.M0);
                    TextView textView8 = (TextView) findViewById(R.id.f163904bu);
                    QLog.isColorLevel();
                    structmsg_structmsg2 = this.D0;
                    if (structmsg_structmsg2 != null) {
                        if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f174794c0), "Q.systemmsg.AddRequestActivity")) {
                        }
                    }
                    z18 = false;
                    if (!z18) {
                    }
                    structmsg_structmsg3 = this.D0;
                    if (structmsg_structmsg3 != null) {
                    }
                    this.A0 = (TextView) findViewById(R.id.b6c);
                    structmsg_structmsg4 = this.D0;
                    if (structmsg_structmsg4 == null) {
                    }
                    z19 = false;
                    this.A0.setVisibility(i16);
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.AddRequestActivity.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                AddRequestActivity.this.runOnUiThread(new Runnable(((FriendsManager) AddRequestActivity.this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(AddRequestActivity.this.f174794c0)) { // from class: com.tencent.mobileqq.activity.AddRequestActivity.1.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ Card f174818d;

                                    {
                                        this.f174818d = r5;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) r5);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                        } else {
                                            AddRequestActivity.this.v3(this.f174818d);
                                        }
                                    }
                                });
                            }
                        }
                    }, 5, null, true);
                    String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f174794c0);
                    friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "Q.systemmsg.AddRequestActivity");
                    if (friendsSimpleInfoWithUid != null) {
                    }
                    e3();
                    d3();
                    i19 = this.f174798g0;
                    if (i19 != 3007) {
                    }
                    z19 = true;
                    if (z19) {
                    }
                    imageView.setBackgroundDrawable(faceDrawable);
                    ((ViewGroup) findViewById(R.id.alp)).setOnClickListener(new h());
                    textView.setText(StringUtil.trimUnreadableInFriendRequest(this.f174795d0));
                    if (this.f174797f0 == i3) {
                    }
                    this.f174801j0.setOnClickListener(this);
                    this.f174802k0.setOnClickListener(this);
                    s3(z17);
                    if (this.f174801j0.getVisibility() == 0) {
                    }
                    if (this.f174802k0.getVisibility() == 0) {
                    }
                    ReportController.o(this.app, "CliOper", "", "", "0X800AA3F", "0X800AA3F", 0, 0, "", "", "", "");
                }
            }
        } catch (InvalidProtocolBufferMicroException unused2) {
            i3 = 2;
            i16 = 8;
            str = "";
        }
        this.f174801j0.setVisibility(i16);
        this.f174802k0.setVisibility(i16);
        structmsg_structmsg = this.D0;
        if (structmsg_structmsg != null && (structmsg_systemmsg3 = structmsg_structmsg.f436065msg) != null && structmsg_systemmsg3.actions.get() != null && (list = this.D0.f436065msg.actions.get()) != null && list.size() > 0) {
            for (i26 = 0; i26 < list.size(); i26++) {
                list.get(i26).detail_name.get();
                if (i26 == 0) {
                    this.f174801j0.setVisibility(0);
                    this.f174801j0.setText(list.get(i26).detail_name.get());
                } else if (i26 == 1) {
                    this.f174802k0.setVisibility(0);
                    this.f174802k0.setText(list.get(i26).detail_name.get());
                }
            }
        }
        this.f174802k0.setVisibility(i16);
        textView2 = (TextView) findViewById(R.id.jmn);
        i17 = this.f174798g0;
        if (i17 == 3014 && i17 != 2014) {
            textView2.setVisibility(i16);
        } else {
            textView2.setVisibility(0);
        }
        TextView textView72 = (TextView) findViewById(R.id.gxw);
        structmsg$StructMsg structmsg_structmsg72 = this.D0;
        i18 = (structmsg_structmsg72 == null && (structmsg_systemmsg2 = structmsg_structmsg72.f436065msg) != null && structmsg_systemmsg2.uint32_source_flag.has()) ? this.D0.f436065msg.uint32_source_flag.get() : 0;
        if ((i18 & 32) == 32) {
            this.J0 = true;
            textView72.setText(R.string.f169993q6);
            textView72.setVisibility(0);
            textView72.setOnClickListener(this);
            ReportController.o(this.app, "CliOper", "", "", "0X800AA3D", "0X800AA3D", 0, 0, "", "", "", "");
        }
        Object[] objArr2 = new Object[i3];
        objArr2[0] = "uint32_source_flag=";
        objArr2[1] = Integer.valueOf(i18);
        QLog.d("Q.systemmsg.AddRequestActivity", 1, objArr2);
        ((TextView) findViewById(R.id.f163905bv)).setOnClickListener(this.M0);
        TextView textView82 = (TextView) findViewById(R.id.f163904bu);
        QLog.isColorLevel();
        structmsg_structmsg2 = this.D0;
        if (structmsg_structmsg2 != null && structmsg_structmsg2.f436065msg.has() && this.D0.f436065msg.get() != null && this.D0.f436065msg.actions.has() && this.D0.f436065msg.actions.get() != null && this.D0.f436065msg.actions.get().size() > 1 && this.D0.f436065msg.friend_info.has() && this.D0.f436065msg.friend_info.msg_blacklist.has() && this.D0.f436065msg.friend_info.msg_blacklist.get().length() > 0) {
            if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f174794c0), "Q.systemmsg.AddRequestActivity")) {
                this.f174804m0.setVisibility(0);
                textView82.setVisibility(0);
                this.f174804m0.setTag(this.D0.f436065msg.friend_info.msg_blacklist.get());
                ReportController.o(this.app, "CliOper", "", "", "0X800AA43", "0X800AA43", 0, 0, "", "", "", "");
                z18 = true;
                if (!z18) {
                    this.f174804m0.setVisibility(i16);
                    textView82.setVisibility(i16);
                }
                structmsg_structmsg3 = this.D0;
                if (structmsg_structmsg3 != null && structmsg_structmsg3.f436065msg.has()) {
                    switch (this.D0.f436065msg.sub_type.get()) {
                        case 1:
                        case 2:
                        case 3:
                        case 9:
                        case 10:
                            this.f174803l0.setVisibility(0);
                            break;
                        case 4:
                        case 5:
                        default:
                            this.f174803l0.setVisibility(i16);
                            break;
                        case 6:
                        case 7:
                        case 8:
                            this.f174803l0.setVisibility(i16);
                            break;
                    }
                }
                this.A0 = (TextView) findViewById(R.id.b6c);
                structmsg_structmsg4 = this.D0;
                if (structmsg_structmsg4 == null && (structmsg_systemmsg = structmsg_structmsg4.f436065msg) != null && structmsg_systemmsg.friend_info.has() && this.D0.f436065msg.friend_info.msg_joint_friend.has()) {
                    this.A0.setText(this.D0.f436065msg.friend_info.msg_joint_friend.get());
                    z19 = false;
                    this.A0.setVisibility(0);
                } else {
                    z19 = false;
                    this.A0.setVisibility(i16);
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.AddRequestActivity.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                AddRequestActivity.this.runOnUiThread(new Runnable(((FriendsManager) AddRequestActivity.this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(AddRequestActivity.this.f174794c0)) { // from class: com.tencent.mobileqq.activity.AddRequestActivity.1.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ Card f174818d;

                                    {
                                        this.f174818d = r5;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) r5);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                        } else {
                                            AddRequestActivity.this.v3(this.f174818d);
                                        }
                                    }
                                });
                            }
                        }
                    }, 5, null, true);
                }
                String uidFromUin2 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f174794c0);
                friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin2, "Q.systemmsg.AddRequestActivity");
                if (friendsSimpleInfoWithUid != null || friendsSimpleInfoWithUid.c() == null || friendsSimpleInfoWithUid.c().length() == 0) {
                    e3();
                }
                d3();
                i19 = this.f174798g0;
                if ((i19 != 3007 || i19 == 3019 || i19 == 2007 || i19 == 4007 || i19 == 2019) && !((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin2, "Q.systemmsg.AddRequestActivity")) {
                    z19 = true;
                }
                if (z19) {
                    faceDrawable = FaceDrawable.getStrangerFaceDrawable((AppInterface) this.app, 200, this.f174794c0, true);
                } else {
                    faceDrawable = FaceDrawable.getFaceDrawable(this.app, 1, this.f174794c0);
                }
                imageView.setBackgroundDrawable(faceDrawable);
                ((ViewGroup) findViewById(R.id.alp)).setOnClickListener(new h());
                textView.setText(StringUtil.trimUnreadableInFriendRequest(this.f174795d0));
                if (this.f174797f0 == i3) {
                    this.f174802k0.setVisibility(i16);
                } else {
                    String str6 = this.f174795d0;
                    if (str6 == null || str.equals(str6)) {
                        textView.setVisibility(i16);
                    }
                }
                this.f174801j0.setOnClickListener(this);
                this.f174802k0.setOnClickListener(this);
                s3(z17);
                if (this.f174801j0.getVisibility() == 0) {
                    ReportController.o(this.app, "CliOper", "", "", "0X800AA40", "0X800AA40", 0, 0, "", "", "", "");
                }
                if (this.f174802k0.getVisibility() == 0) {
                    ReportController.o(this.app, "CliOper", "", "", "0X800AD03", "0X800AD03", 0, 0, "", "", "", "");
                }
                ReportController.o(this.app, "CliOper", "", "", "0X800AA3F", "0X800AA3F", 0, 0, "", "", "", "");
            }
        }
        z18 = false;
        if (!z18) {
        }
        structmsg_structmsg3 = this.D0;
        if (structmsg_structmsg3 != null) {
            switch (this.D0.f436065msg.sub_type.get()) {
            }
        }
        this.A0 = (TextView) findViewById(R.id.b6c);
        structmsg_structmsg4 = this.D0;
        if (structmsg_structmsg4 == null) {
        }
        z19 = false;
        this.A0.setVisibility(i16);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.AddRequestActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddRequestActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    AddRequestActivity.this.runOnUiThread(new Runnable(((FriendsManager) AddRequestActivity.this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(AddRequestActivity.this.f174794c0)) { // from class: com.tencent.mobileqq.activity.AddRequestActivity.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Card f174818d;

                        {
                            this.f174818d = r5;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) r5);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                AddRequestActivity.this.v3(this.f174818d);
                            }
                        }
                    });
                }
            }
        }, 5, null, true);
        String uidFromUin22 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f174794c0);
        friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin22, "Q.systemmsg.AddRequestActivity");
        if (friendsSimpleInfoWithUid != null) {
        }
        e3();
        d3();
        i19 = this.f174798g0;
        if (i19 != 3007) {
        }
        z19 = true;
        if (z19) {
        }
        imageView.setBackgroundDrawable(faceDrawable);
        ((ViewGroup) findViewById(R.id.alp)).setOnClickListener(new h());
        textView.setText(StringUtil.trimUnreadableInFriendRequest(this.f174795d0));
        if (this.f174797f0 == i3) {
        }
        this.f174801j0.setOnClickListener(this);
        this.f174802k0.setOnClickListener(this);
        s3(z17);
        if (this.f174801j0.getVisibility() == 0) {
        }
        if (this.f174802k0.getVisibility() == 0) {
        }
        ReportController.o(this.app, "CliOper", "", "", "0X800AA3F", "0X800AA3F", 0, 0, "", "", "", "");
    }

    public static void l3(QQAppInterface qQAppInterface, Activity activity, LinearLayout linearLayout, String str, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        String str8;
        if (qQAppInterface != null && activity != null) {
            if (linearLayout != null) {
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("setEntityInfo category:");
                    sb5.append(str2);
                    sb5.append(",name:");
                    str7 = str3;
                    sb5.append(str7);
                    sb5.append(",url:");
                    sb5.append(str4);
                    QLog.d(str, 2, sb5.toString());
                } else {
                    str7 = str3;
                }
                TextView textView = (TextView) linearLayout.findViewById(R.id.f58132p7);
                ImageView imageView = (ImageView) linearLayout.findViewById(R.id.f58122p6);
                if (!TextUtils.isEmpty(str2)) {
                    linearLayout.setVisibility(0);
                    if (TextUtils.isEmpty(str3)) {
                        str8 = "";
                    } else {
                        str8 = str7;
                    }
                    textView.setText(str8);
                    ReportController.o(qQAppInterface, "dc00898", "", "", "0X800B756", "0X800B756", 0, 0, str5, str6, "", "");
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                        imageView.setVisibility(0);
                        linearLayout.setOnClickListener(new i(str4, activity, qQAppInterface, str5, str6, str));
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, "setEntityInfo null");
        }
    }

    private void n3() {
        TextView textView = (TextView) findViewById(R.id.zgq);
        textView.setContentDescription(textView.getText().toString() + ((TextView) findViewById(R.id.f1z)).getText().toString());
    }

    private void r3(boolean z16) {
        TextView textView;
        TextView textView2;
        if (z16) {
            textView = (TextView) findViewById(R.id.f116606z7);
            textView2 = (TextView) findViewById(R.id.knu);
        } else {
            textView = (TextView) findViewById(R.id.f116576z4);
            textView2 = (TextView) findViewById(R.id.knl);
        }
        textView.setContentDescription(textView.getText().toString() + textView2.getText().toString());
    }

    private void s3(boolean z16) {
        structmsg$SystemMsg structmsg_systemmsg;
        TextView textView;
        structmsg$StructMsg structmsg_structmsg = this.D0;
        if (structmsg_structmsg != null && (structmsg_systemmsg = structmsg_structmsg.f436065msg) != null && !TextUtils.isEmpty(structmsg_systemmsg.msg_additional.get())) {
            if (z16) {
                textView = (TextView) findViewById(R.id.f116606z7);
            } else {
                textView = (TextView) findViewById(R.id.f116576z4);
            }
            textView.setText(R.string.f160751vv);
        }
        r3(z16);
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else if (i3 == 0 && i16 == -1) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        structmsg$SystemMsg structmsg_systemmsg;
        structmsg$SystemMsg structmsg_systemmsg2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        this.D0 = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(((INewFriendApi) QRoute.api(INewFriendApi.class)).getCurrStructMsgKey()));
        this.f174792a0 = getIntent().getLongExtra("infoid", 0L);
        this.f174794c0 = getIntent().getStringExtra("infouin");
        this.f174793b0 = getIntent().getLongExtra("infotime", 0L);
        this.f174795d0 = getIntent().getStringExtra("verify_msg");
        this.f174797f0 = getIntent().getIntExtra("verify_type", 1);
        this.f174796e0 = getIntent().getStringExtra("msg_source");
        this.f174798g0 = getIntent().getIntExtra("msg_source_id", 3041);
        structmsg$StructMsg structmsg_structmsg = this.D0;
        if (structmsg_structmsg != null && (structmsg_systemmsg2 = structmsg_structmsg.f436065msg) != null && structmsg_systemmsg2.uint32_source_flag.get() == 8) {
            this.E0 = this.D0.f436065msg.uint64_discuss_uin.get();
        }
        structmsg$StructMsg structmsg_structmsg2 = this.D0;
        if (structmsg_structmsg2 != null && (structmsg_systemmsg = structmsg_structmsg2.f436065msg) != null && structmsg_systemmsg.bytes_name_more.has()) {
            this.G0 = new String(this.D0.f436065msg.bytes_name_more.get().toByteArray());
        }
        this.f174809r0 = getIntent().getIntExtra(QQHealthReportApiImpl.MSG_TYPE_KEY, -1006);
        this.f174810s0 = getIntent().getByteArrayExtra(PreloadTRTCPlayerParams.KEY_SIG);
        this.f174811t0 = getIntent().getLongExtra("lToMobile", 0L);
        this.f174812u0 = getIntent().getStringExtra("strNickName");
        String stringExtra = getIntent().getStringExtra("info_dealwith_msg");
        this.f174799h0 = getIntent().getLongExtra("msg_troopuin", 0L);
        String stringExtra2 = getIntent().getStringExtra("msg_title");
        if (getIntent().hasExtra(IProfileCardConst.KEY_WZRY_DATA)) {
            this.f174800i0 = getIntent().getSerializableExtra(IProfileCardConst.KEY_WZRY_DATA);
        }
        super.setContentView(R.layout.b37);
        View findViewById = findViewById(R.id.adt);
        if (findViewById != null) {
            findViewById.setBackgroundResource(R.drawable.bg_texture_theme_version2);
        }
        TextView textView = (TextView) findViewById(R.id.f1c);
        if (stringExtra != null && !stringExtra.equals("")) {
            textView.setText(stringExtra);
            textView.setVisibility(0);
        }
        setTitle(stringExtra2);
        j3(true);
        g3();
        this.f174807p0 = (CardHandler) this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (this.E0 != 0) {
            addObserver(this.T0, true);
        }
        addObserver(this.Q0);
        addObserver(this.R0);
        addObserver(this.P0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnDestroy();
        this.app.removeHandler(getClass());
        com.tencent.mobileqq.app.bs bsVar = this.Q0;
        if (bsVar != null) {
            removeObserver(bsVar);
        }
        CardObserver cardObserver = this.R0;
        if (cardObserver != null) {
            removeObserver(cardObserver);
        }
        com.tencent.mobileqq.app.ar arVar = this.P0;
        if (arVar != null) {
            removeObserver(arVar);
        }
        if (this.E0 != 0) {
            removeObserver(this.T0);
        }
    }

    public void h3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mDensity = getResources().getDisplayMetrics().density;
        this.K0 = Math.min(r0.widthPixels, r0.heightPixels);
        this.L0 = (this.K0 - (getResources().getDimensionPixelSize(R.dimen.f159028ub) * 1)) - (this.mDensity * 175.0f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else if (!NetworkUtil.isNetSupport(this)) {
            QQToast.makeText(this, getString(R.string.f171137ci2), 0).show(getTitleBarHeight());
        } else {
            boolean[] zArr = {false};
            if (view == this.f174801j0) {
                ((IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class)).checkAccountIdentity(this.app, 10005, this, new j(zArr));
            } else if (view == this.f174802k0) {
                f3();
                ReportController.o(this.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "0", "", "", "");
                if (this.f174800i0 != null) {
                    ReportController.o(this.app, "CliOper", "", "", "0X8008440", "0X8008440", 0, 0, "", "", "", "");
                }
                ReportController.o(this.app, "CliOper", "", "", "0X800AD04", "0X800AD04", 0, 0, "", "", "", "");
            } else if (view.getId() == R.id.gxw && com.tencent.mobileqq.webview.util.w.a(1500L)) {
                Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", "https://ti.qq.com/friendship_auth/index.html?_wv=3&adtag=cloneAddRequest#clone_setting");
                startActivity(intent);
                ReportController.o(this.app, "CliOper", "", "", "0X800AA3E", "0X800AA3E", 0, 0, "", "", "", "");
            }
            if (zArr[0]) {
                showProgressDialog(R.string.hex, 1000L, false);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Dialog) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        if (i3 != 1) {
            if (i3 != 2) {
                return super.onCreateDialog(i3);
            }
            ReportDialog reportDialog = new ReportDialog(this, R.style.qZoneInputDialog);
            this.f174806o0 = reportDialog;
            reportDialog.setContentView(R.layout.account_wait);
            ((TextView) this.f174806o0.findViewById(R.id.dialogText)).setText(R.string.f170691yp);
            return this.f174806o0;
        }
        QQCustomDialog negativeButton = DialogUtil.createCustomDialog(this, 230).setTitle(getString(R.string.f170684yh)).setMessage(R.string.f170682yf).setPositiveButton(R.string.f170683yg, new b()).setNegativeButton(R.string.f170647xd, new a());
        this.f174805n0 = negativeButton;
        return negativeButton;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void p3(TextView textView) {
        String str;
        String str2;
        String str3;
        long j3;
        String str4;
        structmsg$StructMsg structmsg_structmsg;
        String str5;
        String str6;
        boolean z16;
        int i3;
        structmsg$SystemMsg structmsg_systemmsg;
        structmsg$StructMsg structmsg_structmsg2;
        structmsg$StructMsg structmsg_structmsg3;
        structmsg$SystemMsg structmsg_systemmsg2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) textView);
            return;
        }
        if (textView == null) {
            return;
        }
        textView.setSingleLine(false);
        Resources resources = textView.getContext().getResources();
        String str7 = this.f174796e0;
        long j16 = this.E0;
        if (j16 != 0) {
            String q16 = com.tencent.mobileqq.utils.ac.q(this.app, String.valueOf(j16));
            this.F0 = q16;
            if (!TextUtils.isEmpty(q16) && !TextUtils.isEmpty(this.f174796e0)) {
                str7 = String.format(Locale.getDefault(), "%s-%s", this.f174796e0, this.F0);
            }
        }
        if (Utils.p(str7, textView.getText().toString())) {
            return;
        }
        if (!TextUtils.isEmpty(str7)) {
            SpannableString spannableString = new SpannableString(str7);
            structmsg$StructMsg structmsg_structmsg4 = this.D0;
            if (structmsg_structmsg4 != null && (structmsg_systemmsg2 = structmsg_structmsg4.f436065msg) != null) {
                str = structmsg_systemmsg2.group_name.get();
                long j17 = this.D0.f436065msg.group_code.get();
                if (j17 != 0) {
                    str2 = Long.toString(j17);
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && str7.contains(str)) {
                        int indexOf = str7.indexOf(str);
                        spannableString.setSpan(new p(1, "Q.systemmsg.AddRequestActivity", com.tencent.mobileqq.troop.utils.aq.b(str2, 101)), indexOf, indexOf + str.length(), 33);
                        structmsg_structmsg3 = this.D0;
                        if (structmsg_structmsg3 != null && structmsg_structmsg3.f436065msg != null && QLog.isColorLevel()) {
                            QLog.i("Q.systemmsg.AddRequestActivity", 2, String.format("setMsgSourceInfo [type:%s, tag:%s, param:%s, src_id:%s, sub_src_id:%s, str:%s]", 1, str, str2, Integer.valueOf(this.D0.f436065msg.src_id.get()), Integer.valueOf(this.D0.f436065msg.sub_src_id.get()), str7));
                        }
                    }
                    str3 = this.F0;
                    j3 = this.E0;
                    if (j3 == 0) {
                        str4 = Long.toString(j3);
                    } else {
                        str4 = null;
                    }
                    if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3) && str7.contains(str3)) {
                        int indexOf2 = str7.indexOf(str3);
                        int length = str3.length() + indexOf2;
                        Bundle bundle = new Bundle();
                        bundle.putString("uin", str4);
                        bundle.putString("uinname", this.F0);
                        bundle.putInt("uintype", 3000);
                        spannableString.setSpan(new p(2, "Q.systemmsg.AddRequestActivity", bundle), indexOf2, length, 33);
                        structmsg_structmsg2 = this.D0;
                        if (structmsg_structmsg2 != null && structmsg_structmsg2.f436065msg != null && QLog.isColorLevel()) {
                            QLog.i("Q.systemmsg.AddRequestActivity", 2, String.format("setMsgSourceInfo [type:%s, tag:%s, param:%s, src_id:%s, sub_src_id:%s, str:%s]", 2, str3, str4, Integer.valueOf(this.D0.f436065msg.src_id.get()), Integer.valueOf(this.D0.f436065msg.sub_src_id.get()), str7));
                        }
                    }
                    structmsg_structmsg = this.D0;
                    if (structmsg_structmsg == null && (structmsg_systemmsg = structmsg_structmsg.f436065msg) != null) {
                        str5 = structmsg_systemmsg.action_uin_nick.get();
                        long j18 = this.D0.f436065msg.action_uin.get();
                        if (j18 != 0) {
                            str6 = Long.toString(j18);
                            if (TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str5) && str7.contains(str5)) {
                                int indexOf3 = str7.indexOf(str5);
                                int length2 = str5.length() + indexOf3;
                                if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str6), "Q.systemmsg.AddRequestActivity")) {
                                    i3 = 1;
                                } else {
                                    i3 = 25;
                                }
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("key_profile_uin", str6);
                                bundle2.putInt("key_profile_pa", i3);
                                z16 = true;
                                bundle2.putInt("key_profile_chatability", 1);
                                spannableString.setSpan(new p(3, "Q.systemmsg.AddRequestActivity", bundle2), indexOf3, length2, 33);
                            } else {
                                z16 = true;
                            }
                            textView.setClickable(z16);
                            textView.setFocusable(z16);
                            textView.setMovementMethod(LinkMovementMethod.getInstance());
                            textView.setText(spannableString);
                            textView.setLinkTextColor(resources.getColorStateList(R.color.aew));
                        }
                    } else {
                        str5 = null;
                    }
                    str6 = null;
                    if (TextUtils.isEmpty(str6)) {
                    }
                    z16 = true;
                    textView.setClickable(z16);
                    textView.setFocusable(z16);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    textView.setText(spannableString);
                    textView.setLinkTextColor(resources.getColorStateList(R.color.aew));
                }
            } else {
                str = null;
            }
            str2 = null;
            if (!TextUtils.isEmpty(str2)) {
                int indexOf4 = str7.indexOf(str);
                spannableString.setSpan(new p(1, "Q.systemmsg.AddRequestActivity", com.tencent.mobileqq.troop.utils.aq.b(str2, 101)), indexOf4, indexOf4 + str.length(), 33);
                structmsg_structmsg3 = this.D0;
                if (structmsg_structmsg3 != null) {
                    QLog.i("Q.systemmsg.AddRequestActivity", 2, String.format("setMsgSourceInfo [type:%s, tag:%s, param:%s, src_id:%s, sub_src_id:%s, str:%s]", 1, str, str2, Integer.valueOf(this.D0.f436065msg.src_id.get()), Integer.valueOf(this.D0.f436065msg.sub_src_id.get()), str7));
                }
            }
            str3 = this.F0;
            j3 = this.E0;
            if (j3 == 0) {
            }
            if (!TextUtils.isEmpty(str4)) {
                int indexOf22 = str7.indexOf(str3);
                int length3 = str3.length() + indexOf22;
                Bundle bundle3 = new Bundle();
                bundle3.putString("uin", str4);
                bundle3.putString("uinname", this.F0);
                bundle3.putInt("uintype", 3000);
                spannableString.setSpan(new p(2, "Q.systemmsg.AddRequestActivity", bundle3), indexOf22, length3, 33);
                structmsg_structmsg2 = this.D0;
                if (structmsg_structmsg2 != null) {
                    QLog.i("Q.systemmsg.AddRequestActivity", 2, String.format("setMsgSourceInfo [type:%s, tag:%s, param:%s, src_id:%s, sub_src_id:%s, str:%s]", 2, str3, str4, Integer.valueOf(this.D0.f436065msg.src_id.get()), Integer.valueOf(this.D0.f436065msg.sub_src_id.get()), str7));
                }
            }
            structmsg_structmsg = this.D0;
            if (structmsg_structmsg == null) {
            }
            str5 = null;
            str6 = null;
            if (TextUtils.isEmpty(str6)) {
            }
            z16 = true;
            textView.setClickable(z16);
            textView.setFocusable(z16);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(spannableString);
            textView.setLinkTextColor(resources.getColorStateList(R.color.aew));
        } else {
            textView.setText(str7);
        }
        String charSequence = textView.getText().toString();
        QQAppInterface qQAppInterface = this.app;
        if (charSequence == null) {
            charSequence = "null";
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X800AA3F", "0X800AA3F", 0, 0, "", "", charSequence, "");
        n3();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity
    public void showToast(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) str);
        } else {
            if (!isResume()) {
                return;
            }
            QQToast.makeText(this, str, 0).show(getTitleBarHeight());
            finish();
        }
    }

    void t3() {
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
        actionSheet.addButton(getString(R.string.f170689yn), 3);
        actionSheet.setOnButtonClickListener(new k(actionSheet));
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.show();
    }

    void u3() {
        String string;
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
        if (this.f174804m0.getTag() instanceof String) {
            string = (String) this.f174804m0.getTag();
        } else {
            string = getString(R.string.hgp);
        }
        actionSheet.setMainTitle(string);
        actionSheet.addButton(getString(R.string.hk9), 3);
        actionSheet.setOnButtonClickListener(new l(actionSheet));
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.show();
    }

    void v3(Card card) {
        String str;
        String str2;
        String str3;
        if (card != null) {
            short s16 = card.shGender;
            boolean z16 = true;
            if (s16 != 0 && s16 != 1) {
                s16 = -1;
            }
            if (s16 == 0) {
                str = getString(R.string.c7_);
                this.f174813v0.setVisibility(0);
            } else if (s16 == 1) {
                str = getString(R.string.b5e);
                this.f174813v0.setVisibility(0);
            } else {
                this.f174813v0.setVisibility(8);
                str = "";
            }
            this.f174813v0.setText(str);
            byte b16 = card.age;
            if (b16 > 0) {
                str2 = ((int) b16) + getString(R.string.htz);
                this.f174814w0.setVisibility(0);
            } else {
                this.f174814w0.setVisibility(8);
                str2 = "";
            }
            this.f174814w0.setText(str2);
            String str4 = card.strProvince;
            if (str4 == null || str4.length() <= 0) {
                str3 = "";
            } else {
                str3 = "" + card.strProvince;
            }
            String str5 = card.strCity;
            if (str5 != null && str5.length() > 0) {
                str3 = str3 + "" + card.strCity;
            }
            this.f174815x0.setText(str3);
            if (this.f174800i0 != null) {
                this.f174814w0.setVisibility(8);
                this.f174815x0.setVisibility(8);
            }
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[1];
                if (("age:" + ((int) card.age) + "gender:" + ((int) card.shGender) + ",isFromWzry=" + this.f174800i0) == null) {
                    z16 = false;
                }
                objArr[0] = Boolean.valueOf(z16);
                QLog.d("Q.systemmsg.AddRequestActivity", 2, objArr);
                return;
            }
            return;
        }
        e3();
    }
}
