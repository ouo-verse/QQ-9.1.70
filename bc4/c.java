package bc4;

import android.content.Context;
import android.view.View;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskBlindBoxData;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskRewardInfo;
import com.tencent.sqshow.zootopia.taskcenter.action.RewardAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J(\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ&\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u0012J.\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015\u00a8\u0006\u001a"}, d2 = {"Lbc4/c;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "view", "", "data", "", "d", "", "offset", "e", "Lcom/tencent/sqshow/zootopia/data/s;", "blindBoxData", "c", "", "Lcom/tencent/sqshow/zootopia/data/w;", "", "type", "a", "", "index", "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f28271a = new c();

    c() {
    }

    public final void a(Context context, List<ZootopiaTaskRewardInfo> data, int type) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        b(context, data, type, 0L);
    }

    public final void b(Context context, List<ZootopiaTaskRewardInfo> data, int type, long index) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        new RewardAction(context, data, type, index).a();
    }

    public final void c(Context context, ZootopiaTaskBlindBoxData blindBoxData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(blindBoxData, "blindBoxData");
        new b(context, blindBoxData).a();
    }

    public final void d(Context context, View view, String data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        e(context, view, data, new int[]{0, 0});
    }

    public final void e(Context context, View view, String data, int[] offset) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(offset, "offset");
        a aVar = view != null ? new a(context, view, offset, data) : null;
        if (aVar != null) {
            aVar.a();
        }
    }
}
