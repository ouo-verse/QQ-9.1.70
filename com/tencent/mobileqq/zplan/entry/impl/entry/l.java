package com.tencent.mobileqq.zplan.entry.impl.entry;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.sqshow.zootopia.usercenter.friend.ui.ZPlanFriendListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/zplan/entry/impl/entry/l;", "Lqh3/c;", "", "d", "", "getPageId", "", "c", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "b", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "uin", "I", "getTabType", "()I", "tabType", "Landroid/os/Bundle;", "e", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Ljava/lang/String;ILandroid/os/Bundle;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class l extends qh3.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String uin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int tabType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Bundle bundle;

    public l(Context context, ZootopiaSource source, String uin, int i3, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.context = context;
        this.source = source;
        this.uin = uin;
        this.tabType = i3;
        this.bundle = bundle;
    }

    @Override // qh3.b
    public void c() {
        ZPlanFriendListFragment.INSTANCE.a(this.context, this.source, this.uin, this.tabType, this.bundle);
    }

    @Override // qh3.c, qh3.b
    public boolean d() {
        return false;
    }

    @Override // qh3.c, qh3.b
    public int getPageId() {
        return 0;
    }
}
