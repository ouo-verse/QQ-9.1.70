package com.tencent.mobileqq.zplan.entry.impl.entry;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager;
import com.tencent.mobileqq.zplan.cloudmod.api.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qh3.b;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0003B/\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/entry/impl/entry/f;", "Lqh3/b;", "Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$EntryType;", "a", "", "c", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "b", "I", "getModId", "()I", "modId", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Landroid/os/Bundle;", "d", "Landroid/os/Bundle;", "pageBundle", "e", "ueBundle", "<init>", "(Landroid/content/Context;ILcom/tencent/mobileqq/zootopia/ZootopiaSource;Landroid/os/Bundle;Landroid/os/Bundle;)V", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f implements qh3.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int modId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Bundle pageBundle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Bundle ueBundle;

    public f(Context context, int i3, ZootopiaSource source, Bundle pageBundle, Bundle ueBundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(pageBundle, "pageBundle");
        Intrinsics.checkNotNullParameter(ueBundle, "ueBundle");
        this.context = context;
        this.modId = i3;
        this.source = source;
        this.pageBundle = pageBundle;
        this.ueBundle = ueBundle;
    }

    @Override // qh3.b
    public CheckPhoneManager.EntryType a() {
        return CheckPhoneManager.EntryType.MOD;
    }

    @Override // qh3.b
    public int b() {
        return b.a.a(this);
    }

    @Override // qh3.b
    public void c() {
        a.C9161a.a((com.tencent.mobileqq.zplan.cloudmod.api.a) vb3.a.f441346a.a(com.tencent.mobileqq.zplan.cloudmod.api.a.class), this.modId, this.pageBundle.getBoolean("needServerFullCheck", true), this.source, xb4.b.f447772a.r(this.ueBundle), null, 16, null);
    }

    @Override // qh3.b
    public boolean d() {
        return b.a.e(this);
    }

    @Override // qh3.b
    public int getPageId() {
        return b.a.b(this);
    }

    @Override // qh3.b
    public int getSceneId() {
        return b.a.c(this);
    }

    @Override // qh3.b
    public int getSceneType() {
        return b.a.d(this);
    }
}
