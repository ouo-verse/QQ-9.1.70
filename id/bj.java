package id;

import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lid/bj;", "Lid/b;", "Landroid/content/Context;", "context", "", "Lhd/b;", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bj extends b {

    /* renamed from: a, reason: collision with root package name */
    public static final bj f407490a = new bj();

    bj() {
    }

    @Override // id.b
    public List<hd.b> d(Context context) {
        List<hd.b> mutableListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new hd.d("Mock\u597d\u53cb\u52a8\u6001\u5217\u8868", "KEY_MOCK_FRIEND_FEEDX_LIST", false, null, 8, null), new hd.d("\u6a21\u62df\u5929\u67a2\u53d1\u8868\u8bf4\u8bf4Banner", "KEY_MOCK_PUBLISH_MOOD_BANNER", false, null, 8, null));
        return mutableListOf;
    }
}
