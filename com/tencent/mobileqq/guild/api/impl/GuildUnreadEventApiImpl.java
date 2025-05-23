package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildUnreadEventApi;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0016\u0010\u000b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildUnreadEventApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildUnreadEventApi;", "()V", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lmqq/util/WeakReference;", "Lkotlin/Function0;", "", "addEventListener", "listener", "notifyEvent", "removeEventListener", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GuildUnreadEventApiImpl implements IGuildUnreadEventApi {

    @NotNull
    private final CopyOnWriteArrayList<WeakReference<Function0<Unit>>> listeners = new CopyOnWriteArrayList<>();

    @Override // com.tencent.mobileqq.guild.api.IGuildUnreadEventApi
    public void addEventListener(@NotNull Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<WeakReference<Function0<Unit>>> copyOnWriteArrayList = this.listeners;
        boolean z16 = false;
        if (!(copyOnWriteArrayList instanceof Collection) || !copyOnWriteArrayList.isEmpty()) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual(((WeakReference) it.next()).get(), listener)) {
                    z16 = true;
                    break;
                }
            }
        }
        if (!z16) {
            this.listeners.add(new WeakReference<>(listener));
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildUnreadEventApi
    public void notifyEvent() {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            Function0 function0 = (Function0) ((WeakReference) it.next()).get();
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildUnreadEventApi
    public void removeEventListener(@NotNull final Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CollectionsKt__MutableCollectionsKt.removeAll((List) this.listeners, (Function1) new Function1<WeakReference<Function0<? extends Unit>>, Boolean>() { // from class: com.tencent.mobileqq.guild.api.impl.GuildUnreadEventApiImpl$removeEventListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Boolean invoke2(WeakReference<Function0<Unit>> weakReference) {
                return Boolean.valueOf(Intrinsics.areEqual(weakReference.get(), listener));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(WeakReference<Function0<? extends Unit>> weakReference) {
                return invoke2((WeakReference<Function0<Unit>>) weakReference);
            }
        });
    }
}
