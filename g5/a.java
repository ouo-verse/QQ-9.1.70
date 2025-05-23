package g5;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.util.QZLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* compiled from: P */
    /* renamed from: g5.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    private static class BinderC10352a extends QfavHelper.AsyncFavoritesProvider {

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<b> f401255e;

        public BinderC10352a(b bVar, Bundle bundle) {
            super(bundle);
            this.f401255e = new WeakReference<>(bVar);
        }

        @Override // cooperation.qqfav.QfavHelper.AsyncFavoritesProvider
        public void x(boolean z16, Bundle bundle) {
            WeakReference<b> weakReference = this.f401255e;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f401255e.get().onResult(z16, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface b {
        void onResult(boolean z16, Bundle bundle);
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneFavorStateUtil", 2, "ugcKey=" + str + ",delete");
        }
        Bundle bundle = new Bundle();
        bundle.putLong("req_opt_type", 2L);
        bundle.putLong("req_biz_type", 2L);
        bundle.putString("req_biz_key", str);
        bundle.putString("req_fav_uin", LoginData.getInstance().getUinString());
        new BinderC10352a(null, bundle).v();
    }

    public static void b(b bVar, String str) {
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneFavorStateUtil", 2, "ugcKey=" + str + ",query");
        }
        Bundle bundle = new Bundle();
        bundle.putLong("req_opt_type", 1L);
        bundle.putLong("req_biz_type", 2L);
        bundle.putString("req_biz_key", str);
        bundle.putString("req_fav_uin", LoginData.getInstance().getUinString());
        new BinderC10352a(bVar, bundle).v();
    }

    public static void c(ContentObserver contentObserver) {
        ContentResolver contentResolver = BaseApplication.getContext().getContentResolver();
        if (contentResolver == null || contentObserver == null) {
            return;
        }
        try {
            contentResolver.registerContentObserver(cooperation.qqfav.content.a.A4, true, contentObserver);
        } catch (Exception e16) {
            QZLog.w(QZLog.TO_DEVICE_TAG, "exception=" + QZLog.getStackTraceString(e16));
        }
    }

    public static void d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneFavorStateUtil", 2, "ugcKey=" + str + ",favorID=" + str2 + ",update");
        }
        Bundle bundle = new Bundle();
        bundle.putLong("req_opt_type", 3L);
        bundle.putLong("req_biz_type", 2L);
        bundle.putString("req_biz_key", str);
        bundle.putString("req_fav_uin", LoginData.getInstance().getUinString());
        bundle.putString("req_fav_id", str2);
        new BinderC10352a(null, bundle).v();
    }
}
