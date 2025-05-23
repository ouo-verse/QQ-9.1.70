package cz1;

import android.app.Activity;
import android.graphics.Point;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.nt.misc.api.IGuildPhotoListApi;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {
    private static Point a(Activity activity, int i3) {
        if (i3 == 102) {
            int d16 = com.tencent.mobileqq.guild.util.bi.d();
            return new Point(d16, b(d16));
        }
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) - QQGuildUIUtil.e(65.0f, activity.getResources());
        return new Point(min, min);
    }

    private static int b(int i3) {
        return (int) (i3 * 0.46629214f);
    }

    public static void c(@NonNull Activity activity, int i3) {
        activity.startActivity(((IGuildPhotoListApi) QRoute.api(IGuildPhotoListApi.class)).newChooseCoverPhotoListIntent(activity, i3, a(activity, i3)));
    }
}
