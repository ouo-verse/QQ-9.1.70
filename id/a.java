package id;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lid/a;", "Lid/b;", "Landroid/content/Context;", "context", "", "Lhd/b;", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f407464a = new a();

    a() {
    }

    @Override // id.b
    public List<hd.b> d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new hd.d("\u53d1\u8bf4\u8bf4\u9875\u5f3a\u5236\u5f39\u51fa\u5f15\u5bfc\u6d6e\u5c42", "KEY_FORCE_SHOW_QQVIDEO_GUIDE_PANEL", false, null, 8, null));
        arrayList.add(new hd.d("\u6253\u5f00\u4e0a\u4f20\u6d4b\u8bd5\u73af\u5883 106.53.137.23:14000", "KEY_FORCE_OPEN_UPLOAD_TEST_ENV", false, null, 8, null));
        arrayList.add(new hd.d("\u53d1\u8bf4\u8bf4\u9875\u9762\u663e\u793a\u8c03\u8bd5\u4fe1\u606f", "KEY_SHOW_QQVIDEO_DEBUG_INFO", false, null, 8, null));
        arrayList.add(new hd.d("\u5f3a\u5236\u547d\u4e2d\u5b9e\u9a8c", "KEY_FORCE_HIT_QQVIDEO_EXPERIMENT", false, null, 8, null));
        return arrayList;
    }
}
