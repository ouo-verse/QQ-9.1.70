package com.tencent.mobileqq.zootopia.redpacket;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.image.URLDrawable;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u0002J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0002J1\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/redpacket/j;", "", "", "usrId", "", "redPacketId", "", "avatarId", "b", "a", "c", "uin", "d", "Landroid/view/View;", "view", "color", "", tl.h.F, "Landroid/widget/TextView;", "g", "Landroid/widget/ImageView;", "imgView", "url", "width", "height", "e", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "resId", "f", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f329071a = new j();

    j() {
    }

    public final String a(String usrId, int redPacketId, long avatarId) {
        Intrinsics.checkNotNullParameter(usrId, "usrId");
        return usrId + "/" + redPacketId + "/" + avatarId + ".apng";
    }

    public final String b(String usrId, int redPacketId, long avatarId) {
        Intrinsics.checkNotNullParameter(usrId, "usrId");
        return usrId + "/" + redPacketId + "/" + avatarId + ".shp";
    }

    public final String c(String usrId, int redPacketId, long avatarId) {
        Intrinsics.checkNotNullParameter(usrId, "usrId");
        return usrId + "/" + redPacketId + "/" + avatarId + "_01.png";
    }

    public final String d(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        String encodeHexStr = MD5Utils.encodeHexStr(uin + AEMaterialMetaData.ZPLAN_SUBFIX);
        if (encodeHexStr == null) {
            return null;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = encodeHexStr.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public final void e(ImageView imgView, String url, Integer width, Integer height) {
        Intrinsics.checkNotNullParameter(imgView, "imgView");
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url)) {
            QLog.e("RedPacketUtil", 1, "loadPic url is empty");
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        if (width != null && height != null) {
            obtain.mRequestWidth = width.intValue();
            obtain.mRequestHeight = height.intValue();
        }
        imgView.setImageDrawable(URLDrawable.getDrawable(url, obtain));
    }

    public final void f(ImageView view, int resId, String color) {
        Integer num;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(color, "color");
        Drawable drawable = view.getContext().getResources().getDrawable(resId);
        try {
            num = Integer.valueOf(Color.parseColor(color));
        } catch (Exception e16) {
            QLog.e("RedPacketUtil", 1, "setColorDrawable failed", e16);
            num = null;
        }
        if (num != null) {
            int intValue = num.intValue();
            Drawable mutate = DrawableCompat.wrap(DrawableCompat.unwrap(drawable)).mutate();
            Intrinsics.checkNotNullExpressionValue(mutate, "wrap(DrawableCompat.unwrap(drawable)).mutate()");
            DrawableCompat.setTint(mutate, intValue);
            view.setImageDrawable(mutate);
            return;
        }
        view.setImageDrawable(drawable);
    }

    public final void g(TextView view, String color) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(color, "color");
        try {
            view.setTextColor(Color.parseColor(color));
        } catch (Exception e16) {
            QLog.e("RedPacketUtil", 1, "setTextViewColor error", e16);
        }
    }

    public final void h(View view, String color) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(color, "color");
        try {
            view.setBackgroundColor(Color.parseColor(color));
        } catch (Exception e16) {
            QLog.e("RedPacketUtil", 1, "setViewBgColor error", e16);
        }
    }
}
