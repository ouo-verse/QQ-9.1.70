package com.tencent.mobileqq.kandian.biz.pts.util;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.biz.pts.ui.PTSImageView;
import com.tencent.mobileqq.urldrawable.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Integer> f239402a = new HashMap<>();

    public static Drawable a(Context context, String str, int i3) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        if (d(str)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = context.getResources().getDrawable(R.drawable.d7y);
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
            if (i3 <= 0) {
                return drawable2;
            }
            drawable2.setDecodeHandler(new a.w(i3));
            return drawable2;
        }
        if (c(str)) {
            return context.getResources().getDrawable(b(context, "qb_public_account_readinjoy_" + str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf("."))));
        }
        QLog.e("PTSImageUtil", 1, "[getDrawable] null, imageUrl = " + str);
        return null;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("images");
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http") || str.startsWith("pubaccount");
    }

    private static int b(Context context, String str) {
        if (context == null || context.getResources() == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        Integer num = f239402a.get(str);
        if (num != null) {
            return num.intValue();
        }
        int identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName() + ".qqecommerce_impl");
        if (identifier == 0) {
            identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName() + ".kandian_feature_impl");
        }
        if (identifier == 0) {
            identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        }
        f239402a.put(str, Integer.valueOf(identifier));
        return identifier;
    }

    public static void e(PTSImageView pTSImageView, String str) {
        if (pTSImageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.i("PTSImageUtil", 2, "[setLocalImageDrawable], localPath = " + str);
        }
        try {
            int b16 = b(pTSImageView.getContext(), "qb_public_account_readinjoy_" + str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".")));
            if (b16 == 0) {
                QLog.e("PTSImageUtil", 1, "[setLocalImageDrawable], cannot find the resource, localPath = " + str);
                pTSImageView.setImageDrawable(new ColorDrawable(0));
                return;
            }
            pTSImageView.setImageDrawable(pTSImageView.getContext().getDrawable(b16).mutate());
        } catch (Exception e16) {
            QLog.e("PTSImageUtil", 1, "[setLocalImageDrawable] error, e = " + e16);
            pTSImageView.setImageDrawable(new ColorDrawable(0));
        }
    }
}
