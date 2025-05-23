package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.phonecontact.api.IContactSyncService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import common.config.service.QzoneConfig;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ContactSyncJumpActivity extends BaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private IPhoneContactService f175468a0;

    /* renamed from: b0, reason: collision with root package name */
    private IContactSyncService f175469b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f175470c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f175471d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f175472e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f175473f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f175474g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f175475h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f175476i0;

    /* renamed from: j0, reason: collision with root package name */
    private ChatActivityUtils.u f175477j0;

    /* renamed from: k0, reason: collision with root package name */
    private com.tencent.mobileqq.app.ar f175478k0;

    /* renamed from: l0, reason: collision with root package name */
    private Handler f175479l0;

    /* renamed from: m0, reason: collision with root package name */
    Dialog f175480m0;

    /* renamed from: n0, reason: collision with root package name */
    int f175481n0;

    /* renamed from: o0, reason: collision with root package name */
    private DialogInterface.OnCancelListener f175482o0;

    /* renamed from: p0, reason: collision with root package name */
    private com.tencent.mobileqq.phonecontact.observer.b f175483p0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements ChatActivityUtils.u {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactSyncJumpActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.u
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                ContactSyncJumpActivity.this.finish();
            }
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.u
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.u
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ContactSyncJumpActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends com.tencent.mobileqq.app.ar {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactSyncJumpActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onGetOnlineInfoByUinOrMobile(boolean z16, long j3, String str, GetOnlineInfoResp getOnlineInfoResp) {
            String str2;
            boolean z17;
            int i3;
            short s16;
            long j16;
            long j17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), str, getOnlineInfoResp);
                return;
            }
            if (!str.equals(ContactSyncJumpActivity.this.f175473f0)) {
                if (!str.equals(ContactSyncJumpActivity.this.f175471d0 + ContactSyncJumpActivity.this.f175472e0)) {
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onGetOnlineInfo | isSuccess = ");
                sb5.append(z16);
                sb5.append(" | resp = ");
                if (getOnlineInfoResp != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb5.append(z17);
                sb5.append(" | resp.result = ");
                int i16 = -10000;
                if (getOnlineInfoResp != null) {
                    i3 = getOnlineInfoResp.result;
                } else {
                    i3 = -10000;
                }
                sb5.append(i3);
                sb5.append(" | resp.errorCode = ");
                if (getOnlineInfoResp != null) {
                    s16 = getOnlineInfoResp.errorCode;
                } else {
                    s16 = -10000;
                }
                sb5.append((int) s16);
                sb5.append(" | resp.iTermType = ");
                long j18 = -10000;
                if (getOnlineInfoResp != null) {
                    j16 = getOnlineInfoResp.iTermType;
                } else {
                    j16 = -10000;
                }
                sb5.append(j16);
                sb5.append(" | resp.status = ");
                if (getOnlineInfoResp != null) {
                    j17 = getOnlineInfoResp.dwStatus;
                } else {
                    j17 = -10000;
                }
                sb5.append(j17);
                sb5.append(" | resp.ability = ");
                if (getOnlineInfoResp != null) {
                    j18 = getOnlineInfoResp.uAbiFlag;
                }
                sb5.append(j18);
                sb5.append(" | resp.network = ");
                if (getOnlineInfoResp != null) {
                    i16 = getOnlineInfoResp.eNetworkType;
                }
                sb5.append(i16);
                QLog.d("ContactSync.JumpActivity", 2, sb5.toString());
            }
            if (z16 && getOnlineInfoResp != null) {
                if (getOnlineInfoResp.result == 1) {
                    short s17 = getOnlineInfoResp.errorCode;
                    if (s17 != 60001 && s17 != -5535) {
                        ContactSyncJumpActivity.this.finish();
                        return;
                    }
                    String format = String.format(ContactSyncJumpActivity.this.getResources().getString(R.string.fc6), ContactSyncJumpActivity.this.f175474g0);
                    ContactSyncJumpActivity.this.f175469b0.deleteSyncContact(ContactSyncJumpActivity.this.f175470c0);
                    ContactSyncJumpActivity.this.W2(1, format);
                    return;
                }
                ContactSyncJumpActivity contactSyncJumpActivity = ContactSyncJumpActivity.this;
                if (contactSyncJumpActivity.f175480m0 == null && contactSyncJumpActivity.f175481n0 != 2) {
                    return;
                }
                String statusDescription = contactSyncJumpActivity.f175469b0.getStatusDescription(getOnlineInfoResp);
                String networkDescription = ContactSyncJumpActivity.this.f175469b0.getNetworkDescription(getOnlineInfoResp);
                if (!TextUtils.isEmpty(statusDescription)) {
                    str2 = statusDescription;
                } else {
                    str2 = "";
                }
                if (!TextUtils.isEmpty(statusDescription) && !TextUtils.isEmpty(networkDescription)) {
                    str2 = (str2 + "\n") + networkDescription;
                }
                boolean z18 = !TextUtils.isEmpty(str2);
                if (!z18) {
                    str2 = ContactSyncJumpActivity.this.getResources().getString(R.string.fcf);
                }
                Dialog dialog = ContactSyncJumpActivity.this.f175480m0;
                if (dialog != null) {
                    TextView textView = (TextView) dialog.findViewById(R.id.bke);
                    textView.setText(str2);
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (z18) {
                    int i17 = getOnlineInfoResp.eNetworkType;
                    if (i17 == 4 || i17 == 5 || i17 == 1) {
                        Message message = new Message();
                        message.what = 1000;
                        message.arg1 = 4;
                        ContactSyncJumpActivity.this.f175479l0.sendMessage(message);
                        return;
                    }
                    return;
                }
                return;
            }
            ContactSyncJumpActivity contactSyncJumpActivity2 = ContactSyncJumpActivity.this;
            Dialog dialog2 = contactSyncJumpActivity2.f175480m0;
            if (dialog2 != null && contactSyncJumpActivity2.f175481n0 == 2) {
                TextView textView2 = (TextView) dialog2.findViewById(R.id.bke);
                textView2.setText(R.string.fcf);
                textView2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends Handler {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactSyncJumpActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (message.what == 1000) {
                if (!ContactSyncJumpActivity.this.V2()) {
                    int i3 = message.arg1 - 1;
                    if (i3 == 0) {
                        ContactSyncJumpActivity.this.Z2();
                        return;
                    }
                    ContactSyncJumpActivity contactSyncJumpActivity = ContactSyncJumpActivity.this;
                    if (contactSyncJumpActivity.f175480m0 != null && contactSyncJumpActivity.f175481n0 == 2) {
                        ((TextView) ContactSyncJumpActivity.this.f175480m0.findViewById(R.id.bka)).setText(String.format(ContactSyncJumpActivity.this.getResources().getString(R.string.fce), "(" + i3 + ")"));
                    }
                    Message obtainMessage = obtainMessage(1000);
                    obtainMessage.arg1 = i3;
                    sendMessageDelayed(obtainMessage, 1000L);
                    return;
                }
                ContactSyncJumpActivity contactSyncJumpActivity2 = ContactSyncJumpActivity.this;
                Dialog dialog = contactSyncJumpActivity2.f175480m0;
                if (dialog != null && contactSyncJumpActivity2.f175481n0 == 2) {
                    ((TextView) dialog.findViewById(R.id.bka)).setText(String.format(ContactSyncJumpActivity.this.getResources().getString(R.string.fce), ""));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactSyncJumpActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                ContactSyncJumpActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e extends com.tencent.mobileqq.phonecontact.observer.b {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactSyncJumpActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onQueryBindState(boolean z16, boolean z17, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3));
                return;
            }
            if (z16) {
                int selfBindState = ContactSyncJumpActivity.this.f175468a0.getSelfBindState();
                if (selfBindState == 1 || selfBindState == 5) {
                    ContactSyncJumpActivity.this.startActivity(new Intent(ContactSyncJumpActivity.this, (Class<?>) PhoneFrameActivity.class));
                    ContactSyncJumpActivity.this.finish();
                }
            }
        }
    }

    public ContactSyncJumpActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f175477j0 = new a();
        this.f175478k0 = new b();
        this.f175479l0 = new c();
        this.f175480m0 = null;
        this.f175482o0 = new d();
        this.f175483p0 = new e();
    }

    private Dialog Q2(int i3, String str, int i16, int i17) {
        ReportDialog reportDialog = new ReportDialog(this, R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.atf);
        TextView textView = (TextView) reportDialog.findViewById(R.id.bkh);
        TextView textView2 = (TextView) reportDialog.findViewById(R.id.bk8);
        TextView textView3 = (TextView) reportDialog.findViewById(R.id.bk5);
        TextView textView4 = (TextView) reportDialog.findViewById(R.id.bka);
        textView.setText(i3);
        textView2.setText(str);
        if (i16 == 0) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(i16);
        }
        textView4.setText(i17);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        return reportDialog;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Dialog R2() {
        FaceDrawable faceDrawable;
        ReportDialog reportDialog = new ReportDialog(this, R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.atg);
        ImageView imageView = (ImageView) reportDialog.findViewById(R.id.f164983bk1);
        if (this.f175473f0.equals("0")) {
            faceDrawable = FaceDrawable.getFaceDrawable(this.app, 11, this.f175471d0 + this.f175472e0);
        } else {
            faceDrawable = FaceDrawable.getFaceDrawable(this.app, 1, this.f175473f0);
        }
        imageView.setImageDrawable(faceDrawable);
        TextView textView = (TextView) reportDialog.findViewById(R.id.bk9);
        TextView textView2 = (TextView) reportDialog.findViewById(R.id.bke);
        TextView textView3 = (TextView) reportDialog.findViewById(R.id.bk5);
        TextView textView4 = (TextView) reportDialog.findViewById(R.id.bka);
        textView.setText(this.f175474g0);
        textView3.setText(R.string.fci);
        textView3.setOnClickListener(this);
        textView4.setText(String.format(getResources().getString(R.string.fce), ""));
        if (NetworkUtil.isNetSupport(this)) {
            Drawable drawable = getResources().getDrawable(R.drawable.common_loading6);
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            textView2.setCompoundDrawablePadding(10);
            ((Animatable) drawable).start();
            textView4.setOnClickListener(this);
        } else {
            textView2.setText(R.string.fcg);
            textView4.setTextColor(getResources().getColor(R.color.f157042i9));
            textView4.setEnabled(false);
        }
        return reportDialog;
    }

    private boolean S2() {
        PhoneContact phoneContact;
        boolean z16;
        this.app.registObserver(this.f175483p0);
        Uri data = getIntent().getData();
        if (!TextUtils.isEmpty(this.f175470c0)) {
            phoneContact = this.f175468a0.queryPhoneContactByMobile(this.f175470c0);
        } else {
            phoneContact = null;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("dealWithBindOK | getTargetPhoneContact | uri = ");
            sb5.append(data);
            sb5.append(" | mobileNo = ");
            sb5.append(com.tencent.mobileqq.phonecontact.util.b.a(this.f175470c0));
            sb5.append(" | pc = ");
            if (phoneContact != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("ContactSync.JumpActivity", 2, sb5.toString());
        }
        if (phoneContact != null) {
            this.f175473f0 = phoneContact.uin;
            this.f175471d0 = phoneContact.nationCode;
            this.f175472e0 = phoneContact.mobileCode;
            this.f175474g0 = phoneContact.name;
            this.f175475h0 = phoneContact.ability;
        } else {
            com.tencent.mobileqq.phonecontact.data.d simplePhoneContactByJumpUri = this.f175469b0.getSimplePhoneContactByJumpUri(data);
            if (QLog.isColorLevel()) {
                QLog.d("ContactSync.JumpActivity", 2, "dealWithBindOK | pc is null | simplePc = " + simplePhoneContactByJumpUri);
            }
            if (simplePhoneContactByJumpUri != null) {
                this.f175473f0 = "0";
                this.f175471d0 = simplePhoneContactByJumpUri.f258472b;
                this.f175472e0 = simplePhoneContactByJumpUri.f258473c;
                this.f175474g0 = simplePhoneContactByJumpUri.f258471a;
                this.f175475h0 = simplePhoneContactByJumpUri.f258474d;
            }
        }
        if ((!TextUtils.isEmpty(this.f175473f0) && !this.f175473f0.equals("0")) || !TextUtils.isEmpty(this.f175472e0)) {
            if (this.f175476i0.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.zchat")) {
                Y2();
                return false;
            }
            W2(2, null);
            if (NetworkUtil.isNetSupport(this)) {
                FriendListHandler friendListHandler = (FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                this.app.addObserver(this.f175478k0);
                friendListHandler.getOnlineInfo(this.f175471d0 + this.f175472e0, true);
            }
            return true;
        }
        String format = String.format(getResources().getString(R.string.fc6), this.f175474g0);
        this.f175469b0.deleteSyncContact(this.f175470c0);
        W2(1, format);
        return true;
    }

    private boolean T2(int i3) {
        String string;
        String syncAccountUin = this.f175469b0.getSyncAccountUin();
        String currentAccountUin = this.app.getCurrentAccountUin();
        if (QLog.isColorLevel()) {
            QLog.d("ContactSync.JumpActivity", 2, "dealWithUnbind | syncUin = " + com.tencent.mobileqq.phonecontact.util.b.b(syncAccountUin) + " | loginUin = " + com.tencent.mobileqq.phonecontact.util.b.b(currentAccountUin) + " | bindState = " + i3);
        }
        if (i3 != 5 && i3 != 1 && i3 != 0) {
            string = getResources().getString(R.string.fcn);
        } else {
            string = getResources().getString(R.string.fcm);
        }
        W2(0, String.format(string, com.tencent.mobileqq.phonecontact.util.b.c(currentAccountUin), com.tencent.mobileqq.phonecontact.util.b.c(syncAccountUin)));
        return true;
    }

    private boolean U2(boolean z16) {
        Intent intent = getIntent();
        if (QLog.isColorLevel()) {
            QLog.d("ContactSync.JumpActivity", 2, "doJump | intent = " + intent);
        }
        if (intent != null) {
            try {
                if (!TextUtils.isEmpty(intent.getAction()) || intent.getBooleanExtra("key_req_from_switch_account", false) || intent.getBooleanExtra("key_req_from_lock_screen", false)) {
                    if (intent.getBooleanExtra("key_req_from_switch_account", false)) {
                        if (!intent.getBooleanExtra("key_change", false)) {
                            finish();
                            return false;
                        }
                        Parcelable parcelableExtra = getIntent().getParcelableExtra("key_orginal_intent");
                        if (parcelableExtra != null && (parcelableExtra instanceof Intent)) {
                            setIntent((Intent) parcelableExtra);
                        }
                        finish();
                        return false;
                    }
                    if (intent.getBooleanExtra("key_req_from_lock_screen", false)) {
                        Parcelable parcelableExtra2 = getIntent().getParcelableExtra("key_orginal_intent");
                        if (parcelableExtra2 != null && (parcelableExtra2 instanceof Intent)) {
                            setIntent((Intent) parcelableExtra2);
                        }
                        finish();
                        return false;
                    }
                    if (z16 && !this.app.isLogin()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ContactSync.JumpActivity", 2, "doJump | check user is not login");
                        }
                        Intent intent2 = new Intent();
                        intent2.putExtra(GesturePWDUnlockActivity.KEY_GESTURE_FROM_SYSTEM_CONTACT, true);
                        intent2.putExtra("key_orginal_intent", getIntent());
                        intent2.addFlags(67108864);
                        intent2.addFlags(536870912);
                        RouteUtils.startActivity(this, intent2, RouterConstants.UI_ROUTER_LOGIN);
                        finish();
                        return false;
                    }
                    if (BaseGesturePWDUtil.getJumpLock(this, this.app.getCurrentAccountUin()) && !BaseGesturePWDUtil.getAppForground(this)) {
                        Intent intent3 = new Intent(this, (Class<?>) GesturePWDUnlockActivity.class);
                        intent3.putExtra(GesturePWDUnlockActivity.KEY_GESTURE_FROM_SYSTEM_CONTACT, true);
                        intent3.putExtra("key_orginal_intent", getIntent());
                        startActivity(intent3);
                        finish();
                        return false;
                    }
                    this.f175468a0 = (IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class);
                    IContactSyncService iContactSyncService = (IContactSyncService) this.app.getRuntimeService(IContactSyncService.class);
                    this.f175469b0 = iContactSyncService;
                    try {
                        this.f175476i0 = iContactSyncService.getMimeTypeByJumpUri(getIntent().getData());
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ContactSync.JumpActivity", 2, "doJump | e = ", e16);
                        }
                    }
                    String str = this.f175476i0;
                    if (str != null && (str.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.zchat") || this.f175476i0.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.voicecall.profile"))) {
                        this.f175470c0 = this.f175469b0.getMobileNoByJumpUri(getIntent().getData());
                        int selfBindState = this.f175468a0.getSelfBindState();
                        String syncAccountUin = this.f175469b0.getSyncAccountUin();
                        if (QLog.isColorLevel()) {
                            QLog.d("ContactSync.JumpActivity", 2, "doJump | check user is login | bind state is " + selfBindState + " | currentUin = " + com.tencent.mobileqq.phonecontact.util.b.b(this.app.getCurrentAccountUin()) + " | syncUin = " + com.tencent.mobileqq.phonecontact.util.b.b(syncAccountUin));
                        }
                        if (selfBindState == 0 && syncAccountUin.equals(this.app.getCurrentAccountUin())) {
                            return S2();
                        }
                        if (selfBindState != 5 && selfBindState != 1 && selfBindState != 0) {
                            if (!this.f175468a0.isBindContactOk() && !syncAccountUin.equals(this.app.getCurrentAccountUin())) {
                                return T2(selfBindState);
                            }
                            return S2();
                        }
                        return T2(selfBindState);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ContactSync.JumpActivity", 2, "doJump | error mimeType = " + this.f175476i0);
                    }
                    finish();
                    return false;
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("ContactSync.JumpActivity", 2, "doJump", e17);
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W2(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ContactSync.JumpActivity", 2, "showAlertDialog | type = " + i3 + " | current type = " + this.f175481n0);
        }
        Dialog dialog = this.f175480m0;
        if (dialog != null) {
            dialog.dismiss();
            this.f175480m0 = null;
        }
        this.f175481n0 = i3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.f175480m0 = R2();
                }
            } else {
                this.f175480m0 = Q2(R.string.fc8, str, 0, R.string.fc7);
            }
        } else {
            this.f175480m0 = Q2(R.string.fcl, str, R.string.fci, R.string.fck);
        }
        Dialog dialog2 = this.f175480m0;
        if (dialog2 != null) {
            dialog2.setOnCancelListener(this.f175482o0);
            this.f175480m0.show();
        }
    }

    private void Y2() {
        ReportController.o(this.app, "CliOper", "", "", "System_contact", "Contact_msg", 0, 0, "", "", "", "");
        if (!this.f175473f0.equals("0")) {
            Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), new int[]{2});
            m3.putExtra("uin", this.f175473f0);
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f175473f0);
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "ContactSync.JumpActivity");
            if (friendsSimpleInfoWithUid != null) {
                m3.putExtra(AppConstants.Key.CSPECIAL_FLAG, friendsSimpleInfoWithUid.e().byteValue());
                com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
                aVar.c(1);
                aVar.d(uidFromUin);
                m3.putExtra("uinname", ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar));
                if (CrmUtils.s(friendsSimpleInfoWithUid.e().byteValue()) || QidianManager.O(friendsSimpleInfoWithUid.e().byteValue())) {
                    m3.setComponent(SplashActivity.getAliasComponent(this));
                    m3.putExtra("chat_subType", 1);
                }
            }
            m3.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 0);
            m3.putExtra("uintype", 0);
            m3.putExtra(GesturePWDUnlockActivity.KEY_GESTURE_FROM_SYSTEM_CONTACT, true);
            startActivity(m3);
            finish();
            return;
        }
        Intent m16 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), new int[]{2});
        m16.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 0);
        m16.putExtra("uin", this.f175471d0 + this.f175472e0);
        m16.putExtra("uintype", 1006);
        m16.putExtra("uinname", this.f175474g0);
        AllInOne allInOne = new AllInOne(this.f175471d0 + this.f175472e0, 31);
        ArrayList<ProfileContactInfo> arrayList = new ArrayList<>();
        allInOne.contactArray = arrayList;
        allInOne.contactName = this.f175474g0;
        arrayList.add(new ProfileContactInfo(this.f175474g0, this.f175472e0, this.f175471d0));
        allInOne.chatAbility = this.f175475h0;
        allInOne.profileEntryType = 59;
        m16.putExtra(AppConstants.Key.AIO_INFO, allInOne);
        m16.putExtra(GesturePWDUnlockActivity.KEY_GESTURE_FROM_SYSTEM_CONTACT, true);
        startActivity(m16);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z2() {
        int i3;
        String str = "0";
        boolean z16 = !this.f175473f0.equals("0");
        QQAppInterface qQAppInterface = this.app;
        if (!z16) {
            str = "3";
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "16", str, "", "");
        if (z16) {
            i3 = 0;
        } else {
            i3 = 1006;
        }
        if (ChatActivityUtils.h0(this.app, this, i3, this.f175473f0, this.f175474g0, this.f175471d0 + this.f175472e0, true, null, true, true, this.f175477j0, "from_app_contact")) {
            finish();
        }
    }

    boolean V2() {
        return ((KeyguardManager) getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        return U2(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnDestroy();
        this.f175479l0.removeCallbacksAndMessages(null);
        this.app.removeObserver(this.f175478k0);
        this.app.unRegistObserver(this.f175483p0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        this.f175479l0.removeCallbacksAndMessages(null);
        this.app.unRegistObserver(this.f175483p0);
        setIntent(intent);
        U2(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.doOnStop();
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Dialog dialog = this.f175480m0;
        if (dialog != null && dialog.isShowing() && this.f175480m0.getWindow() != null) {
            this.f175480m0.dismiss();
        }
        super.finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.bk5) {
                int i3 = this.f175481n0;
                if (i3 == 0) {
                    this.f175480m0.dismiss();
                    finish();
                } else if (i3 == 2) {
                    finish();
                }
            } else if (id5 == R.id.bka) {
                int i16 = this.f175481n0;
                if (i16 == 0) {
                    this.f175480m0.dismiss();
                    Intent intent = new Intent();
                    intent.setPackage(getPackageName());
                    intent.putExtra("IS_ADD_ACCOUNT", true);
                    intent.putExtra(GesturePWDUnlockActivity.KEY_GESTURE_FROM_SYSTEM_CONTACT, true);
                    intent.putExtra("key_uin_to_login", this.f175469b0.getSyncAccountUin());
                    try {
                        intent.putExtra("key_orginal_intent", getIntent());
                    } catch (Exception unused) {
                    }
                    intent.addFlags(67108864);
                    intent.addFlags(536870912);
                    RouteUtils.startActivity(this, intent, RouterConstants.UI_ROUTER_LOGIN);
                    finish();
                } else if (i16 == 2) {
                    Z2();
                } else {
                    finish();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
        }
    }
}
