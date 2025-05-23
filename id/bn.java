package id;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lid/bn;", "Lid/b;", "Landroid/content/Context;", "context", "", "Lhd/b;", "a", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bn extends b {

    /* renamed from: a, reason: collision with root package name */
    public static final bn f407494a = new bn();

    bn() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        im.c.f407941a.g((Activity) context);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // id.b
    public List<hd.b> a(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new hd.a("\u5305\u6708\u652f\u4ed8", new View.OnClickListener() { // from class: id.bm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bn.g(context, view);
            }
        }));
        return arrayList;
    }

    @Override // id.b
    public List<hd.b> d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ArrayList();
    }
}
