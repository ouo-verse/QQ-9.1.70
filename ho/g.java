package ho;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J&\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ.\u0010\u000f\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ&\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ.\u0010\u0011\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0016"}, d2 = {"Lho/g;", "Lho/a;", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/route/QZonePublishMoodInitBean;", "bean", "", "c", "Landroid/content/Intent;", "intent", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "b", tl.h.F, "g", "a", "f", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g implements a {
    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        i.q(context, "mqqapi://arouse/openqqpublish/mood?target=2");
    }

    public final void f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        i.q(context, com.qzone.business.plusunion.plusoperation.c.a());
    }

    public static /* synthetic */ void e(g gVar, Activity activity, QZonePublishMoodInitBean qZonePublishMoodInitBean, int i3, Intent intent, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            intent = new Intent();
        }
        gVar.b(activity, qZonePublishMoodInitBean, i3, intent);
    }

    public final void c(Context context, QZonePublishMoodInitBean bean) {
        if (context == null || bean == null) {
            return;
        }
        i.d(context, lc.b.a()).withParcelable("qzone_route_bean", bean).withAll(bean.getExtraBundleInfo()).request();
    }

    public final void d(Context context, QZonePublishMoodInitBean bean, Intent intent) {
        if (context == null || bean == null) {
            return;
        }
        i.d(context, lc.b.a()).withParcelable("qzone_route_bean", bean).withAll(intent != null ? intent.getExtras() : null).withFlags(intent != null ? intent.getFlags() : 0).request();
    }

    public final void g(Activity activity, QZonePublishMoodInitBean bean, int requestCode, Intent intent) {
        if (activity == null || bean == null) {
            return;
        }
        Navigator.withRequestCode$default(i.d(activity, lc.b.c()).withParcelable("qzone_route_bean", bean).withAll(intent != null ? intent.getExtras() : null).withFlags(intent != null ? intent.getFlags() : 0), activity, requestCode, (Bundle) null, 4, (Object) null).request();
    }

    public final void h(Context context, QZonePublishMoodInitBean bean, Intent intent) {
        if (context == null || bean == null) {
            return;
        }
        i.d(context, lc.b.c()).withParcelable("qzone_route_bean", bean).withAll(intent != null ? intent.getExtras() : null).withFlags(intent != null ? intent.getFlags() : 0).request();
    }

    public final void b(Activity activity, QZonePublishMoodInitBean bean, int requestCode, Intent intent) {
        Bundle extras;
        if (activity == null || bean == null) {
            return;
        }
        if ((intent != null ? intent.getExtras() : null) == null) {
            extras = new Bundle();
        } else {
            extras = intent.getExtras();
        }
        Navigator.withRequestCode$default(i.d(activity, lc.b.a()).withParcelable("qzone_route_bean", bean).withAll(extras).withFlags(intent != null ? intent.getFlags() : 0), activity, requestCode, (Bundle) null, 4, (Object) null).request();
    }
}
