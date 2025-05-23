package com.tencent.mobileqq.profile.vote;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.u;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.config.toggle.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    private static void a(Activity activity) {
        try {
            JSONObject c16 = c.f364696i.c();
            String str = "https://ti.qq.com/qcard/rank?_wv=16777219&_wwv=128";
            if (c16 != null && c16.has("url")) {
                str = c16.getString("url");
            }
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            activity.startActivity(intent);
        } catch (NullPointerException | JSONException e16) {
            QLog.e("LikeRankingUtil", 1, e16, new Object[0]);
            activity.startActivity(new Intent(activity, (Class<?>) LikeRankingListActivity.class));
        }
    }

    public static final void b(Activity activity, boolean z16) {
        QLog.d("LikeRankingUtil", 1, String.format("openLikeRankingList flutterPage=%b", Boolean.valueOf(z16)));
        if (u.a().b()) {
            return;
        }
        a(activity);
    }
}
