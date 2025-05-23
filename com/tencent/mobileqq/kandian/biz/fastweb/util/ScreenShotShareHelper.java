package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qrcode.util.h;
import com.tencent.biz.troop.b;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.share.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ScreenShotShareHelper implements ShareActionSheet.OnItemClickListener, Handler.Callback, e62.a {
    private String F;
    private int G;
    private int M;
    private ShareActionSheet.OnItemClickListener P;

    /* renamed from: d, reason: collision with root package name */
    private QQProgressDialog f239374d;

    /* renamed from: i, reason: collision with root package name */
    private Activity f239378i;

    /* renamed from: m, reason: collision with root package name */
    private b f239379m;

    /* renamed from: e, reason: collision with root package name */
    private String f239375e = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f239376f = false;

    /* renamed from: h, reason: collision with root package name */
    private int f239377h = 0;
    private Bitmap C = null;
    private String D = null;
    private ShareActionSheet E = null;
    private int H = 0;
    private String I = "";
    private String J = "";
    private String K = "";
    private JSONArray L = null;
    private Handler N = new WeakReferenceHandler(Looper.getMainLooper(), this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements ITroopMemberApiClientApi.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f239380d;

        a(boolean z16) {
            this.f239380d = z16;
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            int i3 = bundle.getInt("readinjoy_to_wx_config");
            boolean z16 = this.f239380d;
            if (QLog.isColorLevel()) {
                QLog.d("", 2, "config = " + i3 + ", scene" + (z16 ? 1 : 0));
            }
            ScreenShotShareHelper.this.r(i3, z16 ? 1 : 0);
        }
    }

    public ScreenShotShareHelper(Activity activity) {
        this.f239379m = null;
        this.G = 0;
        this.M = 0;
        this.f239378i = activity;
        if (this.f239379m == null) {
            b A = b.A();
            this.f239379m = A;
            A.p();
        }
        this.G = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        this.F = "";
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f239378i.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.M = displayMetrics.widthPixels;
    }

    private void u(boolean z16) {
        if (QLog.isDevelopLevel()) {
            QLog.d("", 2, "shareScreenShotToWechatCircle!");
        }
        int q16 = q();
        if (q16 != -1) {
            h.T(0, q16);
            return;
        }
        try {
            if (!TextUtils.isEmpty(this.f239375e)) {
                x(this.f239379m, this.f239376f, z16);
            } else {
                QLog.e("", 1, "shareScreenShotToWeChat, mScreenshotWithQRPath is Empty");
            }
        } catch (Exception e16) {
            QLog.e("", 1, "shareScreenShotToWeChat, isTimeline=" + z16 + "e=" + e16.toString());
        }
    }

    @Override // e62.a
    public void a(String str) {
        this.J = str;
    }

    @Override // e62.a
    public int b() {
        return this.H;
    }

    @Override // e62.a
    public QQProgressDialog c() {
        if (this.f239374d == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this.f239378i, this.G);
            this.f239374d = qQProgressDialog;
            qQProgressDialog.setMessage(R.string.c7z);
        }
        return this.f239374d;
    }

    @Override // e62.a
    public void d(String str) {
        this.I = str;
    }

    @Override // e62.a
    public String e() {
        String string = BaseApplicationImpl.getApplication().getString(R.string.wmx);
        try {
            JSONArray jSONArray = this.L;
            if (jSONArray == null) {
                return string;
            }
            return this.L.getString(new Random().nextInt(jSONArray.length()));
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return string;
            }
            QLog.d("", 2, "actionSheet.show exception=" + e16);
            return string;
        }
    }

    @Override // e62.a
    public void f(String str, String str2, int i3) {
        this.D = str;
        if (!TextUtils.isEmpty(str2) && !str2.contains("ShotCache_")) {
            this.H = 3;
        }
        if (this.H == 0 && i3 > 0) {
            this.H = i3;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("", 2, "doOnPhotoPlusActivityEditResult->mScreenshotFromType:" + this.H + ", mEditScreenshotPath:" + this.D + ", originImagePath:" + str2);
        }
        if (this.H == 3) {
            k(this.D);
        } else {
            y();
        }
    }

    @Override // e62.a
    public void g(ShareActionSheet.OnItemClickListener onItemClickListener) {
        this.P = onItemClickListener;
    }

    @Override // e62.a
    public String getUrl() {
        String str = this.F;
        return str != null ? str : "";
    }

    @Override // e62.a
    public String h() {
        return this.K;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // e62.a
    public void i(int i3) {
        this.H = i3;
    }

    @Override // e62.a
    public void j(String str) {
        this.K = str;
    }

    @Override // e62.a
    public void k(String str) {
        String str2;
        String str3;
        String concat;
        if (QLog.isDevelopLevel()) {
            QLog.d("", 2, "shareScreenShotToQQ->imgPath:" + str);
        }
        Intent intent = new Intent(this.f239378i, (Class<?>) ForwardRecentActivity.class);
        intent.putExtra("req_share_id", 1478164480L);
        intent.putExtra("image_url", str);
        intent.putExtra("forward_type", -3);
        if (TextUtils.isEmpty(this.I)) {
            str2 = this.F;
        } else {
            str2 = this.I;
        }
        if (TextUtils.isEmpty(this.K)) {
            str3 = BaseApplication.getContext().getResources().getString(R.string.d6t);
        } else {
            str3 = this.K;
        }
        String str4 = "ScreenShotShare|" + str2 + "|" + str3;
        if (this.H == 3) {
            concat = str4.concat("|1");
        } else {
            concat = str4.concat("|0");
        }
        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION_DATA, concat);
        intent.putExtra("pkg_name", "com.tencent.mobileqq");
        intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 5);
        intent.putExtra(AppConstants.Key.SHARE_BRIEF, HardCodeUtil.qqStr(R.string.t5f));
        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME, "QQ\u770b\u70b9");
        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, "plugin");
        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION_DATA, "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
        intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, i.e(intent.getExtras()).getBytes());
        this.f239378i.startActivityForResult(intent, 1);
    }

    @Override // e62.a
    public void l(JSONArray jSONArray) {
        this.L = jSONArray;
    }

    public Bitmap o(String str) {
        int i3;
        Pair<String, Bitmap> a16 = com.tencent.mobileqq.kandian.biz.fastweb.util.a.a(str, this.M, this.F, "QRCode_");
        this.f239375e = a16.first;
        Bitmap bitmap = a16.second;
        if (QLog.isDevelopLevel()) {
            QLog.d("", 2, "generateScreenShotImageWithQRCode->end time:" + System.currentTimeMillis());
        }
        this.f239376f = false;
        if (!TextUtils.isEmpty(this.f239375e) && (i3 = this.f239377h) > 0) {
            if (i3 == 1) {
                s();
            } else if (i3 == 2) {
                this.N.post(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.fastweb.util.ScreenShotShareHelper.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ScreenShotShareHelper.this.v();
                    }
                });
            } else if (i3 == 3) {
                this.N.post(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.fastweb.util.ScreenShotShareHelper.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ScreenShotShareHelper.this.w();
                    }
                });
            }
        }
        return bitmap;
    }

    @Override // e62.a
    public void onConfigurationChanged() {
        ShareActionSheet shareActionSheet = this.E;
        if (shareActionSheet != null) {
            shareActionSheet.onConfigurationChanged();
        }
    }

    @Override // e62.a
    public void onDestroy() {
        b bVar = this.f239379m;
        if (bVar != null) {
            bVar.q();
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        if (QLog.isColorLevel()) {
            QLog.d("", 2, "onScreenShotItemClick->begin!");
        }
        if (actionSheetItem == null) {
            if (QLog.isColorLevel()) {
                QLog.d("", 2, "onScreenShotItemClick->tag null!");
                return;
            }
            return;
        }
        this.E.dismiss();
        int i3 = actionSheetItem.action;
        if (i3 == 2) {
            k(this.D);
        } else if (i3 == 3) {
            s();
        } else if (i3 == 9) {
            v();
        } else if (i3 == 10) {
            w();
        } else if (i3 == 12) {
            t();
        }
        ShareActionSheet.OnItemClickListener onItemClickListener = this.P;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(actionSheetItem, shareActionSheet);
        }
    }

    public List<ShareActionSheetBuilder.ActionSheetItem>[] p() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(12));
        return new ArrayList[]{arrayList};
    }

    protected int q() {
        if (!WXShareHelper.b0().e0()) {
            return R.string.f173257ih1;
        }
        if (WXShareHelper.b0().f0()) {
            return -1;
        }
        return R.string.f173258ih2;
    }

    public void s() {
        if (QLog.isDevelopLevel()) {
            QLog.d("", 2, "shareScreenShotToQZone!");
        }
        if (!this.f239376f && !TextUtils.isEmpty(this.f239375e)) {
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            userInfo.qzone_uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            QZoneHelper.forwardToPublishMood(this.f239378i, userInfo, this.f239375e, BaseApplication.getContext().getString(R.string.igz), "", -1);
        } else {
            this.f239377h = 1;
            QQToast.makeText(BaseApplication.getContext(), 0, R.string.d6v, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
    }

    @Override // e62.a
    public void setUrl(String str) {
        this.F = str;
    }

    public void t() {
        String str;
        String str2;
        if (QLog.isColorLevel()) {
            QLog.d("", 2, "shareMsgToSina start!");
        }
        if (this.f239374d == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this.f239378i, this.G);
            this.f239374d = qQProgressDialog;
            qQProgressDialog.setMessage(R.string.c7z);
        }
        this.f239374d.show();
        try {
            ApplicationInfo applicationInfo = BaseApplication.getContext().getPackageManager().getApplicationInfo("com.sina.weibo", 8192);
            if (QLog.isColorLevel()) {
                QLog.d("", 2, "shareMsgToSina installSinaWeibo:true");
            }
            if (TextUtils.isEmpty(this.K)) {
                str = BaseApplication.getContext().getResources().getString(R.string.d6t);
            } else {
                str = this.K;
            }
            this.J = str;
            if (TextUtils.isEmpty(this.I)) {
                str2 = this.F;
            } else {
                str2 = this.I;
            }
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setFlags(268435456);
            intent.setType("image/*");
            intent.putExtra("android.intent.extra.TEXT", this.J + str2);
            if (!TextUtils.isEmpty(this.D)) {
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.D)));
            }
            intent.setPackage(applicationInfo.packageName);
            this.f239378i.startActivity(intent);
            QQProgressDialog qQProgressDialog2 = this.f239374d;
            if (qQProgressDialog2 != null && qQProgressDialog2.isShowing()) {
                this.f239374d.dismiss();
            }
            if (QLog.isColorLevel()) {
                QLog.d("", 2, "shareMsgToSina start weibo!");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("", 2, "shareMsgToSina installSinaWeibo:false");
            }
            QQProgressDialog qQProgressDialog3 = this.f239374d;
            if (qQProgressDialog3 != null && qQProgressDialog3.isShowing()) {
                this.f239374d.dismiss();
            }
            QQToast.makeText(BaseApplication.getContext(), 0, R.string.f171211d73, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
        if (QLog.isColorLevel()) {
            QLog.d("", 2, "shareMsgToSina end!");
        }
    }

    public void y() {
        if (QLog.isDevelopLevel()) {
            QLog.d("", 2, "showShareActionSheet->mEditScreenshotPath:" + this.D);
        }
        Activity activity = this.f239378i;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (this.E == null) {
            this.E = ShareActionSheetFactory.create(this.f239378i, false);
        }
        if (((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isPublicAccountUrl(this.F) && !TextUtils.isEmpty(e())) {
            this.E.setActionSheetTitle(e());
        } else {
            this.E.setActionSheetTitle(BaseApplication.getContext().getString(R.string.hja));
        }
        this.E.setActionSheetItems(p());
        this.E.setItemClickListenerV2(this);
        try {
            this.E.show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("", 2, "actionSheet.show exception=" + e16);
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("", 2, "showShareActionSheet->post runnable generate screenshot with QRcode! time:" + System.currentTimeMillis());
        }
        this.f239376f = true;
        this.f239375e = null;
        this.f239377h = 0;
        Bitmap bitmap = this.C;
        if (bitmap != null) {
            bitmap.recycle();
            this.C = null;
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.fastweb.util.ScreenShotShareHelper.1
            @Override // java.lang.Runnable
            public void run() {
                ScreenShotShareHelper screenShotShareHelper = ScreenShotShareHelper.this;
                screenShotShareHelper.C = screenShotShareHelper.o(screenShotShareHelper.D);
            }
        });
    }

    protected void z() {
        QQToast.makeText(BaseApplication.getContext(), 0, R.string.d6v, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    public void v() {
        u(false);
    }

    public void w() {
        u(true);
    }

    protected void x(b bVar, boolean z16, boolean z17) {
        if (!z16) {
            bVar.F(new a(z17));
        } else {
            this.f239377h = z17 ? 3 : 2;
            z();
        }
    }

    protected void r(int i3, int i16) {
        if (i3 == 0) {
            WxShareHelperFromReadInjoy.getInstance().shareImageToWX(this.f239375e, this.C, i16, false);
        } else {
            WXShareHelper.b0().w0(this.f239375e, this.C, i16, false);
        }
        this.C.recycle();
        this.C = null;
    }
}
