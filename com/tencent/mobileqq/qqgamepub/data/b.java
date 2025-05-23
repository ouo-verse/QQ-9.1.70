package com.tencent.mobileqq.qqgamepub.data;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f264501a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21851);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f264501a = true;
        }
    }

    public static StateListDrawable a(String str, String str2, Context context) {
        URLDrawable drawable = URLDrawable.getDrawable(str, context.getResources().getDrawable(R.drawable.skin_common_btn_disabled), context.getResources().getDrawable(R.drawable.skin_common_btn_disabled));
        URLDrawable drawable2 = URLDrawable.getDrawable(str2);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, drawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_focused}, drawable2);
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled}, drawable2);
        stateListDrawable.addState(new int[0], drawable2);
        return stateListDrawable;
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return e(new JSONObject(str).optString("oac_triggle")).getString("ad_id");
            } catch (Exception unused) {
                QLog.e("QQGamePub_", 2, "parseException error ");
            }
        }
        return "";
    }

    public static String c(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("pubAccountAppid")) {
            try {
                return Uri.parse(str).getQueryParameter("pubAccountAppid");
            } catch (Exception e16) {
                QLog.e("QQGamePub_", 1, "getappid error=" + e16.toString());
            }
        }
        return null;
    }

    public static StateListDrawable d(Drawable drawable, Drawable drawable2, String str, String str2) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        URLDrawable drawable3 = URLDrawable.getDrawable(str, obtain);
        URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
        obtain2.mLoadingDrawable = drawable2;
        obtain2.mFailedDrawable = drawable2;
        URLDrawable drawable4 = URLDrawable.getDrawable(str2, obtain2);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, drawable4);
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled}, drawable3);
        return stateListDrawable;
    }

    public static Bundle e(String str) {
        String[] split;
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            String[] split2 = str.split("\\?");
            if (split2.length == 2) {
                split = split2[1].split(ContainerUtils.FIELD_DELIMITER);
            } else {
                split = str.split(ContainerUtils.FIELD_DELIMITER);
            }
            for (String str2 : split) {
                String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split3.length == 2) {
                    try {
                        bundle.putString(split3[0], URLDecoder.decode(split3[1], "UTF-8"));
                    } catch (Exception e16) {
                        QLog.e("QQGamePub_", 1, e16, new Object[0]);
                    }
                }
            }
        }
        return bundle;
    }
}
