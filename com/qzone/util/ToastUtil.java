package com.qzone.util;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.widget.QZoneCustomToast;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ToastUtil {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<Toast> f59752a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f59753b = true;

    /* renamed from: c, reason: collision with root package name */
    private static int f59754c = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height);

    /* renamed from: d, reason: collision with root package name */
    private static int f59755d = QzoneConfig.getInstance().getConfig(QzoneConfig.QZONE_SPECIAL_FOLLOW_COTAINER_MAIN_KEY, QzoneConfig.SECONDARY_KEY_FEED_OPERATE_TIME, 1);

    /* renamed from: e, reason: collision with root package name */
    private static int f59756e = QzoneConfig.getInstance().getConfig(QzoneConfig.QZONE_SPECIAL_FOLLOW_COTAINER_MAIN_KEY, QzoneConfig.SECONDARY_KEY_OWNER_OPERATE_TIME, 3);

    public static void A(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        B(charSequence, 0, f59754c, 3);
    }

    public static void B(CharSequence charSequence, int i3, int i16, int i17) {
        w(charSequence, i3, i16, i17);
    }

    public static void i(boolean z16, long j3, long j16, String str) {
        try {
            if (aq.b(j3) || !z16 || BaseActivity.getTopActivity() == null || TextUtils.isEmpty(str) || j3 <= 0 || j16 < 0) {
                return;
            }
            QZoneCustomToast.g(str, j3, j16, true);
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.util.j.d("ToastUtil", "showFollowToast() catch an exception.", e16);
        }
    }

    public static void m(boolean z16, long j3, long j16, String str, boolean z17, boolean z18) {
        try {
            if (aq.b(j3) || !z16 || BaseActivity.getTopActivity() == null || TextUtils.isEmpty(str) || j3 <= 0 || j16 < 0) {
                return;
            }
            QZoneCustomToast.g(str, j3, j16, z18);
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.util.j.d("ToastUtil", "showFollowToast() catch an exception.", e16);
        }
    }

    public static void n(int i3) {
        p(i3, f59754c, 3);
    }

    public static void o(int i3, int i16) {
        p(i3, f59754c, i16);
    }

    public static void q(int i3, int i16, int i17, int i18) throws Resources.NotFoundException {
        v(BaseApplication.getContext().getText(i3), i16, i17, i18);
    }

    public static void r(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        t(charSequence, 0, f59754c, 3);
    }

    public static void s(CharSequence charSequence, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        t(charSequence, 0, f59754c, i3);
    }

    public static void t(CharSequence charSequence, int i3, int i16, int i17) {
        v(charSequence, i3, i16, i17);
    }

    public static void u(CharSequence charSequence, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        try {
            Toast create = QQToast.makeText(BaseApplication.getContext(), i3, charSequence, 0).create(f59754c);
            if (create != null) {
                create.show();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private static void v(final CharSequence charSequence, final int i3, final int i16, final int i17) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).getHandler().post(new Runnable() { // from class: com.qzone.util.ToastUtil.2
            @Override // java.lang.Runnable
            public void run() {
                Toast toast;
                Toast create = QQToast.makeText(BaseApplication.getContext(), i17, charSequence, i3).create(i16);
                if (create == null) {
                    return;
                }
                if (ToastUtil.f59753b) {
                    if (ToastUtil.f59752a != null && (toast = (Toast) ToastUtil.f59752a.get()) != null) {
                        toast.cancel();
                    }
                    ToastUtil.f59752a = new WeakReference(create);
                }
                try {
                    create.show();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    private static void w(final CharSequence charSequence, final int i3, final int i16, final int i17) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).getHandler().post(new Runnable() { // from class: com.qzone.util.ToastUtil.3
            @Override // java.lang.Runnable
            public void run() {
                Toast create = QQToast.makeText(BaseApplication.getContext(), i17, charSequence, i3).create(i16);
                if (create == null) {
                    return;
                }
                try {
                    create.show();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    public static void x(int i3) {
        y(i3, f59754c, 3);
    }

    public static void z(int i3, int i16, int i17, int i18) throws Resources.NotFoundException {
        w(BaseApplication.getContext().getText(i3), i16, i17, i18);
    }

    public static void p(int i3, int i16, int i17) {
        q(i3, 0, i16, i17);
    }

    public static void y(int i3, int i16, int i17) {
        z(i3, 0, i16, i17);
    }

    public static void f(final BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || !businessFeedData.getFeedCommInfo().isNeedShowSpecialFollowButton()) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.util.ToastUtil.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences M = u5.b.M("QZ_Feed_Follow_" + LoginData.getInstance().getUin());
                int i3 = M.getInt(BusinessFeedData.this.getFeedCommInfo().feedskey, 0);
                int i16 = M.getInt(String.valueOf(BusinessFeedData.this.getUser().uin), 0);
                if (i3 >= ToastUtil.f59755d || i16 >= ToastUtil.f59756e) {
                    return;
                }
                ToastUtil.l(true, BusinessFeedData.this.getUser().uin);
                SharedPreferences.Editor edit = M.edit();
                edit.putInt(BusinessFeedData.this.getFeedCommInfo().feedskey, i3 + 1);
                edit.putInt(String.valueOf(BusinessFeedData.this.getUser().uin), i16 + 1);
                edit.commit();
            }
        });
    }

    public static void h(boolean z16, long j3) {
        i(z16, j3, 5000L, QZoneCustomToast.f60455l);
    }

    public static void j(boolean z16, long j3, boolean z17) {
        i(z16, j3, 5000L, QZoneCustomToast.f60455l);
    }

    public static void l(boolean z16, long j3) {
        m(z16, j3, 5000L, QZoneCustomToast.f60456m, true, false);
    }

    public static void k(boolean z16, boolean z17) {
        o(z16 ? z17 ? R.string.f170063em : R.string.f173063h14 : z17 ? R.string.f170031di : R.string.h0z, 5);
    }

    public static void g(CharSequence charSequence, int i3) {
    }
}
