package com.tencent.mobileqq.addfriend.ui.fornt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.ui.fornt.check.AddFriendCheckFragmentForNT;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.pad.b;
import com.tencent.mobileqq.pad.e;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AddFriendForNtLauncher extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;
    private static String C;
    private static boolean D;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26420);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            C = "";
            D = false;
        }
    }

    public AddFriendForNtLauncher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String ph() {
        return C;
    }

    public static boolean qh(Context context, Intent intent) {
        boolean isInMultiWindowMode;
        boolean z16 = false;
        if (intent == null || intent.getIntExtra("param_return_profilecard_pa", -1) != 104 || Build.VERSION.SDK_INT < 24) {
            return false;
        }
        if (context instanceof Activity) {
            isInMultiWindowMode = ((Activity) context).isInMultiWindowMode();
            if (isInMultiWindowMode) {
                z16 = true;
            }
        }
        return !z16;
    }

    public static boolean rh() {
        return D;
    }

    public static void sh(Context context, Intent intent) {
        if (context != null && intent != null) {
            intent.putExtra(IPublicAccountBrowser.KEY_CALL_FROM, context.getClass().getName());
            intent.putExtra("startAddFriendCheckFragment", System.currentTimeMillis());
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("public_fragment_window_feature", 1);
            if (e.a() == SplitViewState.STATE_FLAT && !qh(context, intent)) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("add_friend_intent", intent);
                i.e(context, bundle, AddFriendCheckFragmentForNT.class, new b().e(false).g(false).h(LaunchMode.standard).a());
                return;
            }
            QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, AddFriendCheckFragmentForNT.class);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendForNtLauncher", 1, "context or intent is null");
        }
    }

    public static void th(Activity activity, Intent intent, int i3) {
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("startAddFriendCheckFragment", System.currentTimeMillis());
        intent.putExtra(IPublicAccountBrowser.KEY_CALL_FROM, activity.getClass().getName());
        QPublicFragmentActivity.b.e(activity, intent, QPublicTransFragmentActivity.class, AddFriendCheckFragmentForNT.class, i3);
    }

    public static void uh(boolean z16) {
        D = z16;
    }

    public static void vh(String str) {
        C = str;
    }

    public static Intent wh(Context context, int i3, String str, String str2, int i16, int i17, String str3, String str4, String str5, String str6, String str7) {
        return xh(context, i3, str, str2, i16, i17, null, str3, str4, str5, str6, str7, null);
    }

    public static Intent xh(Context context, int i3, String str, String str2, int i16, int i17, byte[] bArr, String str3, String str4, String str5, String str6, String str7, byte[] bArr2) {
        Intent intent;
        String str8 = str4;
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendForNtLauncher", 2, String.format(Locale.getDefault(), "AddFriendCheckFragmentForNT.startAddFriend [type:%s, uin: %s, extUin: %s, source:%s, subSource:%s]", Integer.valueOf(i3), Utils.U(str), str2, Integer.valueOf(i16), Integer.valueOf(i17)));
        }
        Intent intent2 = new Intent();
        intent2.putExtra("startAddFriendCheckFragment", System.currentTimeMillis());
        intent2.putExtra("uin", str);
        intent2.putExtra("k_uin_type", i3);
        intent2.putExtra("extra", str2);
        intent2.putExtra("source_id", i16);
        intent2.putExtra("sub_source_id", i17);
        if (bArr != null) {
            intent2.putExtra("third_source_id", bArr);
        }
        intent2.putExtra("is_from_game", ax.N);
        ax.N = null;
        intent2.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, !TextUtils.isEmpty(str3) ? ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).getRemark(str3) : str3);
        if (str8 != null && str4.length() > 30) {
            str8 = str8.substring(0, 28);
        }
        intent2.putExtra("msg", str8);
        intent2.putExtra("param_return_addr", str5);
        intent2.putExtra("last_activity", str6);
        intent2.putExtra("src_name", str7);
        if (bArr2 != null) {
            intent2.putExtra("flc_add_frd_token", bArr2);
        }
        if (i16 == 3999) {
            HashMap<String, String> hashMap = new HashMap<>(4);
            hashMap.put(EventKey.ACT, context.getClass().getSimpleName());
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            hashMap.put("top", qBaseActivity == null ? "null" : qBaseActivity.toString());
            if ((context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null) {
                hashMap.put("intent", intent.toString());
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    hashMap.put("extra", extras.toString());
                }
            }
            StatisticCollector.getInstance(context).collectPerformance(null, "addFriendSource", true, 0L, 0L, hashMap, null);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendForNtLauncher", 2, "startAddFriend Extras = " + intent2.getExtras().toString());
        }
        if (QLog.isDebugVersion()) {
            QLog.d("AddFriendForNtLauncher", 2, "source =  " + i16 + "subSource= " + i17);
        }
        intent2.putExtra(IPublicAccountBrowser.KEY_CALL_FROM, context.getClass().getName());
        return intent2;
    }
}
