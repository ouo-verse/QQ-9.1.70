package com.tencent.mobileqq.guild.gift.impl.module;

import com.tencent.mobileqq.guild.util.Logger;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/gift/impl/module/e;", "Lqh2/h;", "", "totalCount", "successCount", "", "a", "", "success", "id", "", "msg", "b", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/guild/gift/impl/module/h;", "Ljava/lang/ref/WeakReference;", "c", "()Ljava/lang/ref/WeakReference;", "ref", "<init>", "(Ljava/lang/ref/WeakReference;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e implements qh2.h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<h> ref;

    public e(@NotNull WeakReference<h> ref) {
        Intrinsics.checkNotNullParameter(ref, "ref");
        this.ref = ref;
    }

    @Override // qh2.h
    public void a(int totalCount, int successCount) {
        Logger.f235387a.d().i("IGuildGiftEngine.", 1, "ResDownload onAllFinished total:" + totalCount + " suc:" + successCount);
    }

    @Override // qh2.h
    public void b(boolean success, int id5, @Nullable String msg2) {
        if (success) {
            h hVar = this.ref.get();
            if (hVar != null) {
                hVar.y(id5);
                return;
            }
            return;
        }
        Logger.f235387a.d().i("IGuildGiftEngine.", 1, "ResDownload onSingleFinished failed, id:" + id5 + " msg:" + msg2);
    }

    @NotNull
    public final WeakReference<h> c() {
        return this.ref;
    }
}
