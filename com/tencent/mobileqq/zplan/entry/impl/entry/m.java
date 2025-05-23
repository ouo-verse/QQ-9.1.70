package com.tencent.mobileqq.zplan.entry.impl.entry;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/entry/impl/entry/m;", "Lqh3/c;", "", "c", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "b", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Landroid/os/Bundle;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class m extends qh3.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Bundle bundle;

    public m(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        this.context = context;
        this.source = source;
        this.bundle = bundle;
    }

    @Override // qh3.b
    public void c() {
        Bundle bundle = this.bundle;
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        bundle2.putBoolean("key_need_gesture_back", false);
        ZootopiaActivity.Companion.c(ZootopiaActivity.INSTANCE, this.context, FriendsDressUpFragment.class, this.source, bundle2, false, 16, null);
    }
}
