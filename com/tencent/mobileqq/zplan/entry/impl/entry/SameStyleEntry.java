package com.tencent.mobileqq.zplan.entry.impl.entry;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.utils.UEDownloadSource;
import com.tencent.mobileqq.zplan.utils.ab;
import com.tencent.sqshow.activity.ZplanHostActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/entry/impl/entry/SameStyleEntry;", "Lqh3/c;", "", "d", "", "getPageId", "", "c", "Landroid/content/Context;", "a", "Landroid/content/Context;", "f", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "b", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "e", "()Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Landroid/os/Bundle;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SameStyleEntry extends qh3.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Bundle bundle;

    public SameStyleEntry(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        this.context = context;
        this.source = source;
        this.bundle = bundle;
    }

    @Override // qh3.b
    public void c() {
        if (this.bundle == null) {
            return;
        }
        ab.a(this.context, UEDownloadSource.SameStyle, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.entry.impl.entry.SameStyleEntry$doJump$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ZplanHostActivity.a.c(ZplanHostActivity.f369810b0, SameStyleEntry.this.getContext(), com.tencent.sqshow.zootopia.samestyle.a.class, SameStyleEntry.this.getBundle(), 0, 8, null);
            }
        });
    }

    @Override // qh3.c, qh3.b
    public boolean d() {
        return true;
    }

    /* renamed from: e, reason: from getter */
    public final Bundle getBundle() {
        return this.bundle;
    }

    /* renamed from: f, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    @Override // qh3.c, qh3.b
    public int getPageId() {
        return 2;
    }
}
