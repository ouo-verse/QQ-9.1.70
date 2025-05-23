package ff0;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.qrcode.util.h;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements ShareActionSheet.OnItemClickListener {
    static String D = "https://imgplat.store.qq.com/bqq_qfpic/520520/%s_%s_face/0";
    public static String E = "https://s.p.qq.com/pub/get_face?img_type=3&uin=";
    public static String F = "https://spqq.mp.qq.com/pub/get_face?img_type=3&uin=";
    public static String G = "https://spqq.mp.qq.com/pub/get_face_https?img_type=3&uin=";
    protected float C;

    /* renamed from: d, reason: collision with root package name */
    protected ShareActionSheet f398544d;

    /* renamed from: e, reason: collision with root package name */
    protected QQAppInterface f398545e;

    /* renamed from: f, reason: collision with root package name */
    protected BaseActivity f398546f;

    /* renamed from: h, reason: collision with root package name */
    protected int f398547h;

    /* renamed from: i, reason: collision with root package name */
    protected b f398548i;

    /* renamed from: m, reason: collision with root package name */
    protected String f398549m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ff0.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C10310a implements WXShareHelper.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f398550d;

        C10310a(String str) {
            this.f398550d = str;
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            if (!TextUtils.equals(this.f398550d, baseResp.transaction)) {
                return;
            }
            if (baseResp.errCode != 0) {
                h.T(1, R.string.hit);
            } else {
                h.T(2, R.string.hj9);
            }
            WXShareHelper.b0().q0(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: g, reason: collision with root package name */
        public static int f398551g = 0;

        /* renamed from: h, reason: collision with root package name */
        public static int f398552h = 1;

        /* renamed from: a, reason: collision with root package name */
        String f398553a;

        /* renamed from: b, reason: collision with root package name */
        String f398554b;

        /* renamed from: c, reason: collision with root package name */
        String f398555c;

        /* renamed from: d, reason: collision with root package name */
        public int f398556d = f398551g;

        /* renamed from: e, reason: collision with root package name */
        public boolean f398557e = false;

        /* renamed from: f, reason: collision with root package name */
        public int f398558f;

        public b(String str, String str2, String str3) {
            this.f398553a = str;
            this.f398554b = str2;
            this.f398555c = str3;
        }

        public String a() {
            return this.f398553a;
        }
    }

    public a(QQAppInterface qQAppInterface, BaseActivity baseActivity, b bVar, int i3, String str) {
        this.f398545e = qQAppInterface;
        this.f398546f = baseActivity;
        this.C = baseActivity.getResources().getDisplayMetrics().density;
        this.f398548i = bVar;
        this.f398547h = i3;
        this.f398549m = str;
    }

    public static String a(String str) {
        if (str.length() > 30) {
            str = str.substring(0, 30);
        }
        if (str.length() <= 30 && str.getBytes().length <= 100) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < str.length(); i3++) {
            sb5.append(str.charAt(i3));
            if (sb5.toString().getBytes().length > 100) {
                break;
            }
        }
        return sb5.toString() + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    @NotNull
    private static Intent c(Activity activity, b bVar, int i3, String str) {
        String str2;
        String str3;
        Intent intent = new Intent();
        if (QLog.isColorLevel()) {
            QLog.d("forward", 2, "ShareActionSheet getShareToFriendIntent");
        }
        intent.setClass(activity, ForwardRecentActivity.class);
        intent.putExtra("key_flag_from_plugin", true);
        intent.putExtra("category", activity.getString(R.string.d7f));
        intent.putExtra("forward_type", 1001);
        intent.putExtra("detail_url", str);
        intent.putExtra("title", bVar.f398554b);
        intent.putExtra("forward _key_nojump", true);
        intent.putExtra("desc", a(bVar.f398555c));
        intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 1);
        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION, "plugin");
        intent.putExtra(IPublicAccountJavascriptInterface.KEY_PUB_UIN, bVar.f398553a);
        intent.putExtra("pluginName", SearchConfig.ENGINE_PUBLIC_ACCOUNT);
        if (i3 == 1) {
            intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, E + bVar.f398553a);
            str2 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=" + bVar.f398553a;
            str3 = "mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=" + bVar.f398553a + "&version=1";
        } else if (i3 == 2) {
            try {
                long parseLong = Long.parseLong(bVar.f398553a);
                intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, String.format(D, Integer.valueOf((int) (parseLong % 256)), Long.valueOf(parseLong)));
                str2 = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=" + bVar.f398553a;
                str3 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + bVar.f398553a + "&version=1";
            } catch (Exception unused) {
                QLog.d("forward", 2, "ShareActionSheet getShareToFriendIntent Long.parseLong(accountDetail.uin) error");
                return null;
            }
        } else {
            str2 = "";
            str3 = "";
        }
        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_A_ACTION_DATA, str2);
        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_I_ACTION_DATA, str3);
        return intent;
    }

    public static void d(Activity activity, b bVar, int i3, String str) {
        Intent c16;
        AbsStructMsg e16;
        String str2;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ShareActionSheet shareToFriend | account_uin=");
            if (bVar == null) {
                str2 = "null";
            } else {
                str2 = bVar.f398553a;
            }
            sb5.append(str2);
            QLog.d("forward", 2, sb5.toString());
        }
        if (bVar != null && (c16 = c(activity, bVar, i3, str)) != null && (e16 = i.e(c16.getExtras())) != null) {
            c16.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, e16.getBytes());
            c16.putExtra(IPublicAccountDetailActivity.FROMADCARD, true);
            activity.startActivity(c16);
        }
    }

    public static void e(Activity activity, b bVar, int i3, String str) {
        String str2;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ShareActionSheet shareToQidian | account_uin=");
            if (bVar == null) {
                str2 = "null";
            } else {
                str2 = bVar.f398553a;
            }
            sb5.append(str2);
            QLog.d("forward", 2, sb5.toString());
        }
        if (bVar == null) {
            return;
        }
        QidianManager.i0(activity, 6, bVar.f398554b, bVar.f398555c, str, "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + bVar.f398553a, bVar.f398553a, i3, true);
    }

    public static void f(BaseActivity baseActivity, b bVar, int i3, String str) {
        String str2;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ShareActionSheet shareToQzone | account_uin=");
            if (bVar == null) {
                str2 = "null";
            } else {
                str2 = bVar.f398553a;
            }
            sb5.append(str2);
            QLog.d("forward", 2, sb5.toString());
        }
        if (bVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", bVar.f398554b);
        bundle.putString("desc", bVar.f398555c);
        bundle.putString("detail_url", str);
        ArrayList<String> arrayList = new ArrayList<>(1);
        if (i3 == 1) {
            arrayList.add(E + bVar.f398553a);
        } else if (i3 == 2) {
            try {
                long parseLong = Long.parseLong(bVar.f398553a);
                arrayList.add(String.format(D, Integer.valueOf((int) (parseLong % 256)), Long.valueOf(parseLong)));
            } catch (Exception unused) {
                QLog.d("forward", 2, "ShareActionSheet shareToQzone Long.parseLong(accountDetail.uin) error");
                return;
            }
        }
        bundle.putStringArrayList("image_url", arrayList);
        bundle.putLong("req_share_id", 0L);
        bundle.putString(IPublicAccountJavascriptInterface.KEY_PUB_UIN, bVar.f398553a);
        bundle.putBoolean(IPublicAccountDetailActivity.FROMADCARD, true);
        QZoneShareManager.jumpToQzoneShare(baseActivity.app, baseActivity, bundle, null);
    }

    public static void g(Activity activity, b bVar, int i3, String str, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        Intent c16;
        String str2;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ShareActionSheet shareToSpecifiedFriend | account_uin=");
            String str3 = "null";
            if (bVar == null) {
                str2 = "null";
            } else {
                str2 = bVar.f398553a;
            }
            sb5.append(str2);
            sb5.append(" | friend_uin=");
            if (actionSheetItem != null) {
                str3 = actionSheetItem.uin;
            }
            sb5.append(str3);
            QLog.d("forward", 2, sb5.toString());
        }
        if (bVar == null || actionSheetItem == null || (c16 = c(activity, bVar, i3, str)) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        bundle.putInt("key_direct_show_uin_type", actionSheetItem.uinType);
        bundle.putString("key_direct_show_uin", actionSheetItem.uin);
        c16.putExtras(bundle);
        AbsStructMsg e16 = i.e(c16.getExtras());
        if (e16 != null) {
            c16.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, e16.getBytes());
            c16.putExtra(IPublicAccountDetailActivity.FROMADCARD, true);
            ForwardBaseOption.startForwardActivityForResult(activity, c16, (Class<?>) ForwardRecentTranslucentActivity.class, 0, -1, "");
        }
    }

    public static void h(BaseActivity baseActivity, b bVar, int i3, String str, int i16) {
        int i17;
        String str2;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ShareActionSheet shareToWX | account_uin=");
            if (bVar == null) {
                str2 = "null";
            } else {
                str2 = bVar.f398553a;
            }
            sb5.append(str2);
            QLog.d("forward", 2, sb5.toString());
        }
        if (bVar == null) {
            return;
        }
        if (!WXShareHelper.b0().e0()) {
            h.T(0, R.string.f173257ih1);
            if (QLog.isColorLevel()) {
                QLog.d("forward", 2, "ShareActionSheet shareToWXfail: WX is not installed");
                return;
            }
            return;
        }
        if (!WXShareHelper.b0().f0()) {
            h.T(0, R.string.f173258ih2);
            if (QLog.isColorLevel()) {
                QLog.d("forward", 2, "ShareActionSheet shareToWX fail: WX version too low");
                return;
            }
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        WXShareHelper.b0().A(new C10310a(valueOf));
        Bitmap faceBitmap = baseActivity.app.getFaceBitmap(bVar.f398553a, (byte) 1, true);
        if (i16 == 9) {
            i17 = 0;
        } else {
            i17 = 1;
        }
        WXShareHelper.b0().L0(valueOf, bVar.f398554b, faceBitmap, bVar.f398555c, str, i17);
    }

    protected List<ShareActionSheetBuilder.ActionSheetItem>[] b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        QidianManager.g(this.f398546f, arrayList);
        return new ArrayList[]{arrayList};
    }

    public void i() {
        if (this.f398544d == null) {
            ShareActionSheet create = ShareActionSheetFactory.create(this.f398546f, false);
            this.f398544d = create;
            create.setActionSheetTitle(this.f398546f.getString(R.string.hja));
            this.f398544d.setActionSheetItems(b());
            this.f398544d.setItemClickListenerV2(this);
        }
        try {
            this.f398544d.show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        String str;
        String str2;
        String str3;
        this.f398544d.dismiss();
        int i3 = actionSheetItem.action;
        if (i3 != 2) {
            if (i3 != 3) {
                String str4 = null;
                if (i3 != 9 && i3 != 10) {
                    if (i3 == 19) {
                        e(this.f398546f, this.f398548i, this.f398547h, this.f398549m);
                    }
                } else {
                    h(this.f398546f, this.f398548i, this.f398547h, this.f398549m, i3);
                    IPublicAccountHandler iPublicAccountHandler = (IPublicAccountHandler) QRoute.api(IPublicAccountHandler.class);
                    QQAppInterface qQAppInterface = this.f398545e;
                    String str5 = this.f398548i.f398553a;
                    if (i3 == 9) {
                        str3 = "share_wechat";
                    } else {
                        str3 = "share_circle";
                    }
                    iPublicAccountHandler.reportClickPublicAccountEvent(qQAppInterface, str5, "Grp_tribe", "interest_data", str3);
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, this.f398548i.f398553a, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
                    if (9 == i3) {
                        str4 = "03";
                    }
                    if (10 == i3) {
                        str4 = "04";
                    }
                }
                str = str4;
            } else {
                f(this.f398546f, this.f398548i, this.f398547h, this.f398549m);
                ((IPublicAccountHandler) QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.f398545e, this.f398548i.f398553a, "Grp_tribe", "interest_data", "share_qzone");
                str = "02";
            }
        } else {
            d(this.f398546f, this.f398548i, this.f398547h, this.f398549m);
            ((IPublicAccountHandler) QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.f398545e, this.f398548i.f398553a, "Grp_tribe", "interest_data", "share_qq");
            str = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
        }
        if (this.f398548i.f398556d == b.f398552h && !TextUtils.isEmpty(str)) {
            QQAppInterface qQAppInterface2 = this.f398545e;
            b bVar = this.f398548i;
            String str6 = bVar.f398553a;
            if (bVar.f398557e) {
                str2 = "02";
            } else {
                str2 = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
            }
            ReportController.o(qQAppInterface2, "dc01160", IPublicAccountHandler.MAIN_ACTION, str6, "0X8007CA6", "0X8007CA6", 0, 0, str2, str, String.valueOf(bVar.f398558f), "");
        }
    }
}
