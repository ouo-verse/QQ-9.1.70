package fl;

import android.content.Context;
import com.qzone.reborn.message.fragment.QZonePassiveMessageTabFragment;
import ho.i;
import jo.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lfl/a;", "Lho/a;", "Landroid/content/Context;", "context", "", "refer", "", "mode", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements ho.a {
    public final void a(Context context, String refer, int mode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(refer, "refer");
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZonePassiveMessageTabFragment.class.getName()).withString("refer", refer).withInt("mode", mode).request();
        h.f410717a.h("page_launch_passive_message").t("LAUNCH_CLICK");
    }
}
