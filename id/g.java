package id;

import android.content.Context;
import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import hd.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lid/g;", "Lid/b;", "Landroid/content/Context;", "context", "", "Lhd/b;", "a", "c", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g extends id.b {

    /* renamed from: a, reason: collision with root package name */
    public static final g f407506a = new g();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"id/g$a", "Lhd/c$a;", "", "input", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements c.a {
        a() {
        }

        @Override // hd.c.a
        public void a(String input) {
            Intrinsics.checkNotNullParameter(input, "input");
            if (ef.d.i(input) > 0) {
                gd.a.f401926a.d("KEY_FEED_REFRESH_INTERVAL_HAS_PASSIVE", ef.d.i(input));
                com.qzone.reborn.util.o.f59556a.a("\u4fee\u6539\u6210\u529f");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"id/g$b", "Lhd/c$a;", "", "input", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements c.a {
        b() {
        }

        @Override // hd.c.a
        public void a(String input) {
            Intrinsics.checkNotNullParameter(input, "input");
            if (ef.d.i(input) > 0) {
                gd.a.f401926a.d("KEY_FEED_REFRESH_INTERVAL_NO_PASSIVE", ef.d.i(input));
                com.qzone.reborn.util.o.f59556a.a("\u4fee\u6539\u6210\u529f");
            }
        }
    }

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        gd.a aVar = gd.a.f401926a;
        aVar.d("KEY_FEED_REFRESH_INTERVAL_HAS_PASSIVE", 0);
        aVar.d("KEY_FEED_REFRESH_INTERVAL_NO_PASSIVE", 0);
        com.qzone.reborn.util.o.f59556a.a("\u91cd\u7f6e\u6210\u529f");
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // id.b
    public List<hd.b> a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new hd.a("\u91cd\u7f6e\u6240\u6709\u914d\u7f6e", new View.OnClickListener() { // from class: id.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.g(view);
            }
        }));
        return arrayList;
    }

    @Override // id.b
    public List<hd.b> c(Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        gd.a aVar = gd.a.f401926a;
        int a16 = aVar.a("KEY_FEED_REFRESH_INTERVAL_HAS_PASSIVE", 0);
        String str2 = "\u8bf7\u8f93\u5165\u65f6\u95f4\u95f4\u9694";
        if (a16 <= 0) {
            str = "\u8bf7\u8f93\u5165\u65f6\u95f4\u95f4\u9694";
        } else {
            str = "\u5f53\u524d\u95f4\u9694" + a16 + "\u79d2";
        }
        arrayList.add(new hd.c("\u6709\u88ab\u52a8\u7ea2\u70b9\u65f6\u7684\u5237\u65b0\u95f4\u9694(\u5355\u4f4d:\u79d2)", str, new a()));
        int a17 = aVar.a("KEY_FEED_REFRESH_INTERVAL_NO_PASSIVE", 0);
        if (a17 > 0) {
            str2 = "\u5f53\u524d\u95f4\u9694" + a17 + "\u79d2";
        }
        arrayList.add(new hd.c("\u65e0\u88ab\u52a8\u7ea2\u70b9\u65f6\u7684\u5237\u65b0\u95f4\u9694(\u5355\u4f4d:\u79d2)", str2, new b()));
        return arrayList;
    }
}
