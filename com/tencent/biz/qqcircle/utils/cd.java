package com.tencent.biz.qqcircle.utils;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.winkpublish.publishconst.WinkHostConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

/* compiled from: P */
/* loaded from: classes5.dex */
public class cd {
    private static int a(String str) {
        try {
            if (str.startsWith("#")) {
                return Color.parseColor(str);
            }
            return QCircleSkinHelper.getInstance().getColor(str);
        } catch (Exception e16) {
            QLog.e("QFSResLoadUtils", 1, "getColorFromString error :" + e16);
            if (!WinkHostConstants.AppSetting.isDebugVersion()) {
                return -16777216;
            }
            throw new RuntimeException("getColorFromString error " + e16);
        }
    }

    public static void b(View view, String str) {
        if (view != null && !TextUtils.isEmpty(str)) {
            view.setBackgroundColor(a(str));
        }
    }

    public static void c(ImageView imageView, String str) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            if (QCirclePluginUtil.getUrlType(str) == 0) {
                Option obtain = Option.obtain();
                obtain.setUrl(str);
                obtain.setTargetView(imageView);
                obtain.setRequestWidth(imageView.getWidth());
                obtain.setRequestHeight(imageView.getHeight());
                QCircleFeedPicLoader.g().loadImage(obtain);
                return;
            }
            imageView.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(str));
        }
    }

    public static void d(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            textView.setTextColor(a(str));
        }
    }
}
