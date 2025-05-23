package com.tencent.mobileqq.zplan.entry.impl.entry;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.aigc.SuitParentFragment;
import com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0005B!\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/entry/impl/entry/b;", "Lqh3/c;", "", "c", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "b", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Landroid/os/Bundle;)V", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b extends qh3.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Bundle bundle;

    public b(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        this.context = context;
        this.source = source;
        this.bundle = bundle;
    }

    @Override // qh3.b
    public void c() {
        AIGCHelper.f330685a.h();
        Intent a16 = ZootopiaActivity.INSTANCE.a(this.context, ZootopiaActivity.class, SuitParentFragment.class, this.source, this.bundle);
        a16.setFlags(65536);
        if (!(this.context instanceof Activity)) {
            a16.addFlags(268435456);
        }
        int i3 = 0;
        a16.putExtra("key_need_gesture_back", false);
        Bundle bundle = this.bundle;
        if (bundle != null && bundle.containsKey("subPageId")) {
            i3 = this.bundle.getInt("subPageId");
        }
        a16.putExtra("subPageId", i3);
        this.context.startActivity(a16);
    }
}
