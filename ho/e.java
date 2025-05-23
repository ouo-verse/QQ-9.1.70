package ho;

import android.content.Context;
import android.content.Intent;
import com.qzone.reborn.feedx.bean.QZoneFeedEventTagInitBean;
import com.qzone.reborn.feedx.fragment.QZoneFeedXEventTagFragment;
import com.qzone.reborn.feedx.fragment.QZoneFeedXMoodListFragment;
import com.qzone.reborn.feedx.fragment.QZoneFriendFeedXFragment;
import com.qzone.reborn.route.QZoneMoodListInitBean;
import com.tencent.mobileqq.pad.LaunchMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\bJ\u001a\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u000f"}, d2 = {"Lho/e;", "Lho/a;", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/route/QZoneMoodListInitBean;", "initBean", "", "b", "Lcom/qzone/reborn/feedx/bean/QZoneFeedEventTagInitBean;", "c", "Landroid/content/Intent;", "intent", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e implements a {
    public final void a(Context context, Intent intent) {
        com.tencent.mobileqq.pad.b h16 = new com.tencent.mobileqq.pad.b().e(false).g(true).h(LaunchMode.singleTask);
        if (context != null) {
            com.tencent.mobileqq.pad.i.e(context, intent != null ? intent.getExtras() : null, QZoneFriendFeedXFragment.class, h16.a());
        }
    }

    public final void b(Context context, QZoneMoodListInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        if (context == null) {
            return;
        }
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneFeedXMoodListFragment.class.getName()).withLong("key_uin", initBean.getUin()).withString("key_nickname", initBean.getNickName()).withString("refer", initBean.getRefer()).withParcelable("qzone_route_bean", initBean).request();
        jo.h.f410717a.h("page_launch_mood_list").t("LAUNCH_CLICK");
    }

    public final void c(Context context, QZoneFeedEventTagInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        if (context == null) {
            return;
        }
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneFeedXEventTagFragment.class.getName()).withSerializable("qzone_route_bean", initBean).request();
    }
}
