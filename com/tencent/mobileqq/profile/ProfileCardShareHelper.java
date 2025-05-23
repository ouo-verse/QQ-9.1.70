package com.tencent.mobileqq.profile;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.profile.util.b;
import com.tencent.mobileqq.profilecard.utils.ProfileCardShareBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.ag;
import com.tencent.mobileqq.structmsg.view.ap;
import com.tencent.mobileqq.structmsg.view.u;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.data.SquareJSConst;
import com.tencent.util.QQToastUtil;
import com.tenpay.sdk.util.QQFaceFileUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes16.dex */
public class ProfileCardShareHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ShareActionSheet f260021a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.sharepanel.f f260022b;

    /* renamed from: c, reason: collision with root package name */
    private QQProgressDialog f260023c;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f260024d;

    /* renamed from: e, reason: collision with root package name */
    private Activity f260025e;

    /* renamed from: f, reason: collision with root package name */
    private String f260026f;

    /* renamed from: g, reason: collision with root package name */
    private String f260027g;

    /* renamed from: h, reason: collision with root package name */
    private String f260028h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f260029i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f260030j;

    /* renamed from: k, reason: collision with root package name */
    private int f260031k;

    /* renamed from: l, reason: collision with root package name */
    private d f260032l;

    /* renamed from: m, reason: collision with root package name */
    private BroadcastReceiver f260033m;

    /* renamed from: n, reason: collision with root package name */
    private ShareActionSheet.OnItemClickListener f260034n;

    /* loaded from: classes16.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardShareHelper.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent != null && "com.tencent.qqhead.getheadresp".equals(intent.getAction())) {
                boolean z16 = true;
                if (intent.getIntExtra("faceType", -1) != 1) {
                    QLog.d("ProfileCardShareHelper", 1, "getHead onReceive FaceType not match!");
                    return;
                }
                if (TextUtils.isEmpty(ProfileCardShareHelper.this.f260026f)) {
                    QLog.d("ProfileCardShareHelper", 1, "getHead onReceive mUin is empty!");
                    return;
                }
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(SquareJSConst.Params.PARAMS_UIN_LIST);
                ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("headPathList");
                if (stringArrayListExtra != null && stringArrayListExtra2 != null && stringArrayListExtra.size() == stringArrayListExtra2.size()) {
                    for (int i3 = 0; i3 < stringArrayListExtra.size(); i3++) {
                        if (stringArrayListExtra.get(i3).equals(ProfileCardShareHelper.this.f260026f)) {
                            ProfileCardShareHelper.this.f260028h = stringArrayListExtra2.get(i3);
                            break;
                        }
                    }
                }
                z16 = false;
                if (z16 && ProfileCardShareHelper.this.f260030j) {
                    ProfileCardShareHelper profileCardShareHelper = ProfileCardShareHelper.this;
                    profileCardShareHelper.r(profileCardShareHelper.f260028h);
                }
            }
        }
    }

    /* loaded from: classes16.dex */
    class b implements com.tencent.mobileqq.sharepanel.j {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardShareHelper.this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void a(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ProfileCardShareHelper.this.x(str);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void b(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                ProfileCardShareHelper.this.x(str);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
        }
    }

    /* loaded from: classes16.dex */
    class c implements ShareActionSheet.OnItemClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardShareHelper.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) actionSheetItem, (Object) shareActionSheet);
                return;
            }
            if (ProfileCardShareHelper.this.f260021a.isShowing()) {
                ProfileCardShareHelper.this.f260021a.dismiss();
            }
            int i16 = actionSheetItem.action;
            if (i16 == 2) {
                ProfileCardShareHelper.this.C(false);
            } else {
                i3 = 9;
                if (i16 == 9) {
                    ProfileCardShareHelper.this.D();
                } else {
                    i3 = -1;
                }
            }
            if (ProfileCardShareHelper.this.f260032l != null) {
                ProfileCardShareHelper.this.f260032l.a(i3, ProfileCardShareHelper.this.f260026f);
            }
        }
    }

    /* loaded from: classes16.dex */
    public interface d {
        void a(int i3, String str);
    }

    public ProfileCardShareHelper(Activity activity, QQAppInterface qQAppInterface, int i3, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, qQAppInterface, Integer.valueOf(i3), dVar);
            return;
        }
        this.f260033m = new a();
        this.f260034n = new c();
        this.f260025e = activity;
        this.f260024d = qQAppInterface;
        this.f260031k = i3;
        this.f260032l = dVar;
        if (qQAppInterface == null) {
            z();
        }
    }

    private void B(boolean z16) {
        String str = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + this.f260026f;
        ProfileCardShareBean profileCardShareBean = new ProfileCardShareBean(Long.parseLong(this.f260026f), str, str, "AppCmd://OpenContactInfo/?uin=" + this.f260026f, false);
        profileCardShareBean.useBottomPreviewFS = z16;
        com.tencent.mobileqq.profile.util.b.o(this.f260024d, this.f260025e, profileCardShareBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z16) {
        if (!TextUtils.isEmpty(this.f260026f) && !TextUtils.isEmpty(this.f260027g)) {
            if (com.tencent.mobileqq.profile.util.b.m()) {
                B(z16);
                return;
            }
            AbsShareMsg.a aVar = new AbsShareMsg.a(StructMsgForGeneralShare.class);
            String str = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + this.f260026f;
            String str2 = "AppCmd://OpenContactInfo/?uin=" + this.f260026f;
            String qqStr = HardCodeUtil.qqStr(R.string.pdg);
            String str3 = HardCodeUtil.qqStr(R.string.pep) + this.f260026f;
            String string = this.f260025e.getResources().getString(R.string.gzb);
            AbsShareMsg a16 = aVar.g(14).d(HardCodeUtil.qqStr(R.string.pe9) + this.f260027g).f(2).f(1).b("plugin", "", str2, str, str).e(string).a();
            ag agVar = new ag();
            agVar.C(1);
            agVar.s(qqStr);
            u uVar = new u();
            uVar.C(1);
            uVar.m(new com.tencent.mobileqq.structmsg.view.c(str));
            uVar.m(new StructMsgItemTitle(this.f260027g));
            uVar.m(new ap(str3));
            a16.addItem(agVar);
            a16.addItem(uVar);
            Bundle bundle = new Bundle();
            bundle.putInt("forward_type", 20);
            bundle.putInt(AppConstants.Key.STRUCT_MSG_SERVICE_ID, 14);
            bundle.putByteArray(AppConstants.Key.STRUCT_MSG_BYTES, a16.getBytes());
            bundle.putBoolean("k_dataline", false);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            ForwardBaseOption.startForwardActivityForResult(this.f260025e, intent, 21);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder(300);
                sb5.append("recommentFriend [title: ");
                sb5.append(qqStr);
                sb5.append(", nickname: ");
                sb5.append(this.f260027g);
                sb5.append(", info: ");
                sb5.append(str3);
                sb5.append(", serviceId: ");
                sb5.append(14);
                sb5.append(", pActionData: ");
                sb5.append(str2);
                sb5.append(", aActionData: ");
                sb5.append(str);
                sb5.append(", iActionData: ");
                sb5.append(str);
                sb5.append(", compatibleText: ");
                sb5.append(string);
                sb5.append("]");
                QLog.i("ProfileCardShareHelper", 2, sb5.toString());
                return;
            }
            return;
        }
        QLog.d("ProfileCardShareHelper", 1, String.format("shareToFriend, uin or nickname is empty, uin: %s, nickname: %s", this.f260026f, this.f260027g));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        int i3;
        if (this.f260030j) {
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
            QQToast.makeText(this.f260025e, 1, i3, 1).show();
            QLog.d("ProfileCardShareHelper", 1, "shareToWXFriend, but wechat is not install or version is too low");
            return;
        }
        this.f260030j = true;
        Bitmap bitmap = this.f260029i;
        if (bitmap != null) {
            E(this.f260026f, this.f260027g, bitmap);
            return;
        }
        if (q.p(this.f260028h)) {
            r(this.f260028h);
        } else {
            QQAppInterface qQAppInterface = this.f260024d;
            if (qQAppInterface != null) {
                String customFaceFilePath = qQAppInterface.getCustomFaceFilePath(1, this.f260026f, 0);
                this.f260028h = customFaceFilePath;
                r(customFaceFilePath);
            } else {
                ArrayList<String> arrayList = new ArrayList<>(1);
                arrayList.add(this.f260026f);
                Intent intent = new Intent("com.tencent.qqhead.getheadreq");
                intent.putExtra("faceType", 1);
                intent.putStringArrayListExtra(SquareJSConst.Params.PARAMS_UIN_LIST, arrayList);
                this.f260025e.sendBroadcast(intent, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission);
            }
        }
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String str, String str2, Bitmap bitmap) {
        this.f260030j = false;
        WXShareHelper.b0().M0(String.valueOf(System.currentTimeMillis()), str2, bitmap, "\u6765\u81eaQQ\u7684\u63a8\u8350\u597d\u53cb", "https://ti.qq.com/open_qq/index2.html?url=mqqapi%3a%2f%2fuserprofile%2ffriend_profile_card%3fsrc_type%3dweb%26version%3d1.0%26source%3d2%26uin%3d" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCardShareHelper", 2, String.format("decodeFace: %s", str));
        }
        ThreadManager.getSubThreadHandler().post(new Runnable(str) { // from class: com.tencent.mobileqq.profile.ProfileCardShareHelper.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f260035d;

            {
                this.f260035d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileCardShareHelper.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (q.p(this.f260035d)) {
                        ProfileCardShareHelper profileCardShareHelper = ProfileCardShareHelper.this;
                        profileCardShareHelper.f260029i = BitmapFactory.decodeFile(profileCardShareHelper.f260028h);
                        bitmap = ProfileCardShareHelper.this.f260029i;
                    } else {
                        Bitmap h16 = com.tencent.mobileqq.util.j.h(BaseApplicationImpl.getApplication().getResources(), R.drawable.coo);
                        QLog.d("ProfileCardShareHelper", 2, String.format("decodeFace facePath: %s is not exist", this.f260035d));
                        bitmap = h16;
                    }
                    ThreadManager.getUIHandler().post(new Runnable(bitmap) { // from class: com.tencent.mobileqq.profile.ProfileCardShareHelper.4.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Bitmap f260036d;

                        {
                            this.f260036d = bitmap;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) bitmap);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            ProfileCardShareHelper.this.t();
                            if (this.f260036d != null) {
                                ProfileCardShareHelper profileCardShareHelper2 = ProfileCardShareHelper.this;
                                profileCardShareHelper2.E(profileCardShareHelper2.f260026f, ProfileCardShareHelper.this.f260027g, this.f260036d);
                            } else {
                                QQToast.makeText(ProfileCardShareHelper.this.f260025e, 1, R.string.hiu, 1).show();
                            }
                        }
                    });
                } catch (Exception e16) {
                    QLog.d("ProfileCardShareHelper", 1, "decode bitmap exception...", e16);
                } catch (OutOfMemoryError e17) {
                    QLog.d("ProfileCardShareHelper", 1, "decode bitmap oom...", e17);
                }
            }
        });
    }

    private List<ShareActionSheetBuilder.ActionSheetItem>[] u() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        return new ArrayList[]{arrayList};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(com.tencent.mobileqq.sharepanel.m mVar, Intent intent) {
        if (intent != null) {
            if (mVar != null) {
                mVar.a(intent);
            }
        } else {
            QQToastUtil.showQQToastInUiThread(1, "\u8bf7\u6c42\u6570\u636e\u5931\u8d25");
            if (mVar != null) {
                mVar.onFail();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str) {
        int i3;
        str.hashCode();
        if (!str.equals("weixin")) {
            if (!str.equals("qqfriend")) {
                i3 = -1;
            } else {
                C(true);
                i3 = 2;
            }
        } else {
            D();
            i3 = 9;
        }
        d dVar = this.f260032l;
        if (dVar != null) {
            dVar.a(i3, this.f260026f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(ArrayList<ResultRecord> arrayList, final com.tencent.mobileqq.sharepanel.m mVar) {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToastInUiThread(1, BaseApplication.context.getString(R.string.cib));
            mVar.onFail();
            return;
        }
        String str = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + this.f260026f;
        com.tencent.mobileqq.profile.util.b.b(this.f260025e, new ProfileCardShareBean(Long.parseLong(this.f260026f), str, str, "AppCmd://OpenContactInfo/?uin=" + this.f260026f, false), new b.d() { // from class: com.tencent.mobileqq.profile.f
            @Override // com.tencent.mobileqq.profile.util.b.d
            public final void a(Intent intent) {
                ProfileCardShareHelper.v(com.tencent.mobileqq.sharepanel.m.this, intent);
            }
        });
    }

    public void A(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCardShareHelper", 2, String.format("share, uin: %s, nickname: %s", str, str2));
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!str.equals(this.f260026f)) {
                this.f260029i = null;
            }
            this.f260026f = str;
            this.f260027g = str2;
            if (this.f260021a == null) {
                Intent intent = this.f260025e.getIntent();
                if (intent != null && TextUtils.isEmpty(intent.getStringExtra("big_brother_source_key"))) {
                    intent.putExtra("big_brother_source_key", "biz_src_unknown");
                }
                ShareActionSheet create = ShareActionSheetFactory.create(this.f260025e, false);
                this.f260021a = create;
                create.setActionSheetItems(u());
                this.f260021a.setItemClickListenerV2(this.f260034n);
            }
            if (!this.f260021a.isShowing()) {
                this.f260021a.show();
            }
        }
    }

    protected void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Activity activity = this.f260025e;
        if (activity != null && !activity.isFinishing()) {
            if (this.f260023c == null) {
                Activity activity2 = this.f260025e;
                QQProgressDialog qQProgressDialog = new QQProgressDialog(activity2, activity2.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                this.f260023c = qQProgressDialog;
                qQProgressDialog.setCancelable(false);
            }
            this.f260023c.setMessage(HardCodeUtil.qqStr(R.string.pe_));
            this.f260023c.show();
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        BroadcastReceiver broadcastReceiver = this.f260033m;
        if (broadcastReceiver != null) {
            this.f260025e.unregisterReceiver(broadcastReceiver);
        }
    }

    protected void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.f260023c;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f260023c.dismiss();
            this.f260023c = null;
        }
    }

    public void w(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!str.equals(this.f260026f)) {
                this.f260029i = null;
            }
            this.f260026f = str;
            this.f260027g = str2;
            com.tencent.mobileqq.sharepanel.f fVar = this.f260022b;
            if (fVar != null) {
                fVar.dismiss();
            }
            com.tencent.mobileqq.sharepanel.f t06 = ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).createSharePanel((FragmentActivity) this.f260025e, "relationship_recommend").k0(new com.tencent.mobileqq.sharepanel.n() { // from class: com.tencent.mobileqq.profile.e
                @Override // com.tencent.mobileqq.sharepanel.n
                public final void a(ArrayList arrayList, com.tencent.mobileqq.sharepanel.m mVar) {
                    ProfileCardShareHelper.this.y(arrayList, mVar);
                }
            }).t0(new b());
            this.f260022b = t06;
            t06.show();
        }
    }

    public void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.qqhead.getheadresp");
        this.f260025e.registerReceiver(this.f260033m, intentFilter, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission, null);
    }
}
