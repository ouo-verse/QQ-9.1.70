package com.tencent.biz.subscribe;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StVideo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.ServiceAccountFolderListFragment;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;
import com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment;
import com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static long f96053a;

    public static CertifiedAccountMeta$StFeed a(String str, String str2, int i3, int i16, int i17, long j3) {
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = new CertifiedAccountMeta$StFeed();
        if (str != null) {
            certifiedAccountMeta$StFeed.f24925id.set(str);
        }
        certifiedAccountMeta$StFeed.type.set(i3);
        certifiedAccountMeta$StFeed.createTime.set(j3);
        CertifiedAccountMeta$StUser certifiedAccountMeta$StUser = new CertifiedAccountMeta$StUser();
        if (str2 != null) {
            certifiedAccountMeta$StUser.f24929id.set(str2);
        }
        certifiedAccountMeta$StFeed.poster.set(certifiedAccountMeta$StUser);
        if (h(i3)) {
            CertifiedAccountMeta$StVideo certifiedAccountMeta$StVideo = new CertifiedAccountMeta$StVideo();
            certifiedAccountMeta$StVideo.height.set(i17);
            certifiedAccountMeta$StVideo.width.set(i16);
            certifiedAccountMeta$StFeed.video.set(certifiedAccountMeta$StVideo);
        }
        return certifiedAccountMeta$StFeed;
    }

    private static String b(String str) {
        if (str != null && str.length() != 0) {
            return str;
        }
        return "0";
    }

    private static String c(String str) {
        if (str == null) {
            return "0";
        }
        return str;
    }

    public static int d(int i3) {
        switch (i3) {
            case 0:
            case 3:
            case 5:
            case 6:
                return 7000;
            case 1:
            case 8:
                return 8001;
            case 2:
            case 7:
                return 7001;
            case 4:
            default:
                return 0;
        }
    }

    public static boolean e(int i3) {
        if (i3 != 2 && i3 != 7) {
            return false;
        }
        return true;
    }

    public static boolean f(int i3) {
        if (i3 == 1 || i3 == 8) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0024. Please report as an issue. */
    private static boolean g(Context context, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, ExtraTypeInfo extraTypeInfo, Intent intent) {
        boolean j3;
        boolean z16;
        boolean z17;
        if (extraTypeInfo == null) {
            extraTypeInfo = new ExtraTypeInfo();
        }
        if (extraTypeInfo.pageType == 0 && certifiedAccountMeta$StFeed != null) {
            extraTypeInfo.pageType = d(certifiedAccountMeta$StFeed.type.get());
        }
        switch (extraTypeInfo.pageType) {
            case 7000:
                intent.setClass(context, PublicFragmentActivity.class);
                intent.putExtra("public_fragment_class", SubscribeVideoDetailFragment.class.getName());
                intent.addFlags(268435456);
                j3 = af0.b.j();
                z16 = true;
                z17 = z16;
                break;
            case 7001:
                intent.setClass(context, PublicFragmentActivity.class);
                intent.putExtra("public_fragment_class", SubscribeMultiPicFragment.class.getName());
                intent.addFlags(268435456);
                j3 = af0.b.j();
                z16 = true;
                z17 = z16;
                break;
            case 7002:
                intent.setClass(context, PublicFragmentActivity.class);
                intent.putExtra("public_fragment_class", SubscribePersonalDetailFragment.class.getName());
                intent.addFlags(268435456);
                j3 = false;
                z16 = false;
                z17 = true;
                break;
            case 7003:
            case 7004:
                intent.setClass(context, ServiceAccountFolderActivityNew.class);
                intent.setFlags(67108864);
                j3 = false;
                z16 = false;
                z17 = true;
                break;
            default:
                j3 = false;
                z16 = false;
                z17 = z16;
                break;
        }
        intent.putExtra(ExtraTypeInfo.KEY_SUBSCRIBE_INTENT_EXTRA_TYPE_INFO, extraTypeInfo);
        if (z16 && certifiedAccountMeta$StFeed != null) {
            PreLoader.remove("1002" + certifiedAccountMeta$StFeed.f24925id.get());
            PreLoader.preLoad("1002" + certifiedAccountMeta$StFeed.f24925id.get(), new ye0.a(certifiedAccountMeta$StFeed));
        }
        if (z17) {
            ServiceAccountFolderListFragment.Companion companion = ServiceAccountFolderListFragment.INSTANCE;
            if (companion.a()) {
                companion.b(context);
                return true;
            }
            if (j3 && (context instanceof Activity)) {
                Activity activity = (Activity) context;
                activity.startActivity(intent, af0.b.l());
                activity.overridePendingTransition(0, 0);
                return z17;
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
        return z17;
    }

    public static boolean h(int i3) {
        if (i3 != 0 && i3 != 3 && i3 != 5 && i3 != 6) {
            return false;
        }
        return true;
    }

    public static void i(Context context, int i3, int i16, Intent intent) {
        s(context, null, null, new ExtraTypeInfo(i16, i3), intent);
    }

    public static void j(Context context, int i3, Intent intent) {
        i(context, i3, 7004, intent);
    }

    public static void k(Context context, String str, HashMap<String, String> hashMap) {
        if (str != null) {
            if (str.startsWith(QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_CONTENT_DETAIL)) {
                QLog.i("SubscribeLauncher", 2, "launchSubscribeBySchema detail");
                CertifiedAccountMeta$StFeed a16 = a(c(hashMap.get("feedid")), c(hashMap.get("uin")), Integer.parseInt(b(hashMap.get("type"))), Integer.parseInt(b(hashMap.get("width"))), Integer.parseInt(b(hashMap.get("height"))), Long.parseLong(b(hashMap.get("createtime"))));
                String str2 = hashMap.get(QCircleSchemeAttr.Detail.COMMENT_ID);
                if (TextUtils.isEmpty(str2)) {
                    o(null, a16);
                    return;
                }
                ExtraTypeInfo extraTypeInfo = new ExtraTypeInfo(0, 0);
                extraTypeInfo.setReplyId(hashMap.get(QCircleSchemeAttr.Detail.REPLY_ID));
                extraTypeInfo.setCommentId(str2);
                r(null, a16, extraTypeInfo);
                return;
            }
            if (str.startsWith("openhomepage")) {
                QLog.i("SubscribeLauncher", 2, "launchSubscribeBySchema personal page");
                u(context, c(hashMap.get("uid")));
                return;
            } else {
                if (str.startsWith("opendiscoverpage")) {
                    QLog.i("SubscribeLauncher", 2, "launchSubscribeBySchema ServiceAccountFolder page");
                    i(context, 0, 7004, null);
                    return;
                }
                return;
            }
        }
        QLog.e("SubscribeLauncher", 2, "launchSubscribeBySchema failed");
    }

    public static void l(String str) {
        m(str, 8000);
    }

    public static void m(String str, int i3) {
        n(str, i3, 0);
    }

    public static void n(String str, int i3, int i16) {
        s(null, str, new CertifiedAccountMeta$StFeed(), new ExtraTypeInfo(i3, i16), null);
    }

    public static void o(Context context, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        p(context, certifiedAccountMeta$StFeed, 0);
    }

    public static void p(Context context, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, int i3) {
        q(context, certifiedAccountMeta$StFeed, i3, null);
    }

    public static void q(Context context, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, int i3, Intent intent) {
        s(context, "", certifiedAccountMeta$StFeed, new ExtraTypeInfo(0, i3), intent);
    }

    public static void r(Context context, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, ExtraTypeInfo extraTypeInfo) {
        s(context, "", certifiedAccountMeta$StFeed, extraTypeInfo, null);
    }

    public static void s(Context context, String str, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, ExtraTypeInfo extraTypeInfo, Intent intent) {
        Context context2;
        if (Math.abs(System.currentTimeMillis() - f96053a) < 500) {
            QLog.i("SubscribeLauncher", 2, "prevent SubscribeLaucher from doubleClick");
            return;
        }
        y();
        if (intent == null) {
            intent = new Intent();
        }
        if (str != null) {
            intent.putExtra("url", str);
        }
        if (certifiedAccountMeta$StFeed != null) {
            certifiedAccountMeta$StFeed.poster.get().setHasFlag(true);
            certifiedAccountMeta$StFeed.cover.get().setHasFlag(true);
            certifiedAccountMeta$StFeed.video.get().setHasFlag(true);
            intent.putExtra("bundle_key_subscribe_feed_bytes_array", certifiedAccountMeta$StFeed.toByteArray());
            intent.putExtra("bundle_key_feed_type", certifiedAccountMeta$StFeed.type.get());
        }
        f96053a = System.currentTimeMillis();
        intent.putExtra("PERF_OPEN_PAGE_TIME", System.currentTimeMillis());
        if (context == null) {
            context2 = BaseApplication.getContext();
        } else {
            context2 = context;
        }
        if (g(context2, certifiedAccountMeta$StFeed, extraTypeInfo, intent)) {
            return;
        }
        intent.setClass(BaseApplication.getContext(), QQBrowserActivity.class);
        intent.putExtra("fragment_class", SubscribeHybirdFragment.class.getCanonicalName());
        if (context instanceof Activity) {
            context.startActivity(intent);
        } else {
            intent.addFlags(268435456);
            BaseApplication.getContext().startActivity(intent);
        }
    }

    public static void t(Context context, CertifiedAccountMeta$StUser certifiedAccountMeta$StUser) {
        w(context, certifiedAccountMeta$StUser.f24929id.get(), certifiedAccountMeta$StUser, 0, null);
    }

    public static void u(Context context, String str) {
        v(context, str, 0);
    }

    public static void v(Context context, String str, int i3) {
        w(context, str, null, i3, null);
    }

    public static void w(Context context, String str, CertifiedAccountMeta$StUser certifiedAccountMeta$StUser, int i3, Intent intent) {
        PreLoader.remove("1001" + str);
        PreLoader.preLoad("1001" + str, new ye0.b(str));
        ExtraTypeInfo extraTypeInfo = new ExtraTypeInfo(7002, i3);
        CertifiedAccountMeta$StFeed a16 = a("", str, -1, 0, 0, 0L);
        if (certifiedAccountMeta$StUser != null) {
            a16.poster.set(certifiedAccountMeta$StUser);
        }
        s(context, null, a16, extraTypeInfo, intent);
    }

    public static void x(Context context, String str, Intent intent) {
        w(context, str, null, 0, intent);
    }

    private static void y() {
        c.c();
    }
}
