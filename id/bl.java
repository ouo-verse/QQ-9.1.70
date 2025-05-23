package id;

import android.content.Context;
import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000e"}, d2 = {"Lid/bl;", "Lid/b;", "Lhd/b;", "i", tl.h.F, "j", "k", "Landroid/content/Context;", "context", "", "a", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bl extends b {

    /* renamed from: a, reason: collision with root package name */
    public static final bl f407492a = new bl();

    bl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        context.startActivity(com.qzone.common.activities.base.ak.l(context, "FRAGMENT_DEBUG_NT_UPLOADER"));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final hd.b h() {
        return new hd.d("\u7981\u6b62\u5927\u6570\u636e\u901a\u9053\u4e0a\u4f20", "KEY_NT_UPLOAD_DISABLE_BDH", false, null, 8, null);
    }

    private final hd.b i() {
        return new hd.d("\u7981\u6b62quic\u901a\u9053\u4e0a\u4f20", "KEY_NT_UPLOAD_DISABLE_QUIC", false, null, 8, null);
    }

    private final hd.b j() {
        return new hd.d("\u7a7a\u95f4\u56fe\u7247\u8bc4\u8bba\u4f7f\u7528\u65b0\u4e0a\u4f20\u94fe\u8def", "KEY_ENABLE_USE_NEW_NT_UPLOAD_PIC_COMMENT", false, null, 8, null);
    }

    private final hd.b k() {
        return new hd.d("\u7a7a\u95f4\u56fe\u7247\u8bc4\u8bba\u65b0\u4e0a\u4f20\u5f3a\u5236\u4f7f\u7528http\u901a\u9053", "KEY_ENABLE_USE_NEW_NT_UPLOAD_PIC_COMMENT_ONLY_HTTP", false, null, 8, null);
    }

    @Override // id.b
    public List<hd.b> a(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new hd.a("Debug Demo", new View.OnClickListener() { // from class: id.bk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bl.g(context, view);
            }
        }));
        return arrayList;
    }

    @Override // id.b
    public List<hd.b> d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.add(i());
        arrayList.add(h());
        arrayList.add(j());
        arrayList.add(k());
        return arrayList;
    }
}
