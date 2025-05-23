package com.tencent.qqnt.contacts.data.repository;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.contacts.data.datasource.c;
import com.tencent.qqnt.contacts.data.f;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002J\u0014\u0010\u0006\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/contacts/data/repository/b;", "", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/tencent/qqnt/contacts/data/f;", "a", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "operate", "", "c", "Lcom/tencent/qqnt/contacts/data/datasource/c;", "Lcom/tencent/qqnt/contacts/data/datasource/c;", "platformDataSource", "Lcom/tencent/qqnt/contacts/data/datasource/b;", "Lcom/tencent/qqnt/contacts/data/datasource/b;", "localCacheDataSource", "<init>", "(Lcom/tencent/qqnt/contacts/data/datasource/c;Lcom/tencent/qqnt/contacts/data/datasource/b;)V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c platformDataSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.contacts.data.datasource.b localCacheDataSource;

    public b(@NotNull c platformDataSource, @NotNull com.tencent.qqnt.contacts.data.datasource.b localCacheDataSource) {
        Intrinsics.checkNotNullParameter(platformDataSource, "platformDataSource");
        Intrinsics.checkNotNullParameter(localCacheDataSource, "localCacheDataSource");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) platformDataSource, (Object) localCacheDataSource);
        } else {
            this.platformDataSource = platformDataSource;
            this.localCacheDataSource = localCacheDataSource;
        }
    }

    @NotNull
    public final Flow<List<f>> a() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Flow) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        List<f> a16 = this.localCacheDataSource.a();
        List<f> list = a16;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.platformDataSource.a();
            a16 = CollectionsKt__CollectionsKt.emptyList();
        }
        return FlowKt.flowOf(a16);
    }

    @Nullable
    public final Flow<List<f>> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Flow) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    public final void c(@NotNull IOperateCallback operate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) operate);
        } else {
            Intrinsics.checkNotNullParameter(operate, "operate");
            this.platformDataSource.c(operate);
        }
    }
}
