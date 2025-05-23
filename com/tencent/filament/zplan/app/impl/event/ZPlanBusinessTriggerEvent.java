package com.tencent.filament.zplan.app.impl.event;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tk0.a;
import tk0.b;
import tk0.c;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J,\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tJ\u0018\u0010\r\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eRh\u0010\u0012\u001aV\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00070\u0004j*\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007`\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/filament/zplan/app/impl/event/ZPlanBusinessTriggerEvent;", "", "", QQBrowserActivity.KEY_MSG_TYPE, "Ljava/util/HashMap;", "", "Lcom/tencent/filament/zplan/app/impl/event/ZPlanBusinessTriggerEvent$InnerAction;", "Lkotlin/collections/HashMap;", "a", "Ltk0/a;", "action", "", "b", "d", "Ltk0/b;", "event", "c", "Ljava/util/HashMap;", "mActionMap", "<init>", "()V", "InnerAction", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanBusinessTriggerEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, HashMap<Integer, InnerAction>> mActionMap = new HashMap<>();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u000e\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/filament/zplan/app/impl/event/ZPlanBusinessTriggerEvent$InnerAction;", "Ltk0/a;", "", "toString", "Ltk0/b;", "i", "", "call", "", "other", "", "equals", "", "hashCode", "action", "Ltk0/a;", "getAction", "()Ltk0/a;", "<init>", "(Ltk0/a;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class InnerAction implements a {

        @NotNull
        private final a action;

        public InnerAction(@NotNull a action) {
            Intrinsics.checkNotNullParameter(action, "action");
            this.action = action;
        }

        @Override // tk0.a
        public void call(@NotNull b i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            this.action.call(i3);
        }

        public boolean equals(@Nullable Object other) {
            Class<?> cls;
            if (this == other) {
                return true;
            }
            if (other != null) {
                cls = other.getClass();
            } else {
                cls = null;
            }
            if (!Intrinsics.areEqual(InnerAction.class, cls)) {
                return false;
            }
            if (other != null) {
                if (!(!Intrinsics.areEqual(this.action, ((InnerAction) other).action))) {
                    return true;
                }
                return false;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.filament.zplan.app.impl.event.ZPlanBusinessTriggerEvent.InnerAction");
        }

        @NotNull
        public final a getAction() {
            return this.action;
        }

        public int hashCode() {
            return this.action.hashCode();
        }

        @NotNull
        public String toString() {
            return "InnerAction(" + this.action.getClass().getName() + ")";
        }
    }

    private final HashMap<Integer, InnerAction> a(String msgType) {
        if (!this.mActionMap.containsKey(msgType)) {
            HashMap<Integer, InnerAction> hashMap = new HashMap<>();
            this.mActionMap.put(msgType, hashMap);
            return hashMap;
        }
        HashMap<Integer, InnerAction> hashMap2 = this.mActionMap.get(msgType);
        Intrinsics.checkNotNull(hashMap2);
        Intrinsics.checkNotNullExpressionValue(hashMap2, "mActionMap[msgType]!!");
        return hashMap2;
    }

    public final void b(@Nullable String msgType, @NotNull a action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (msgType != null) {
            a(msgType).put(Integer.valueOf(action.hashCode()), new InnerAction(action));
        }
    }

    public final void c(@NotNull b event) {
        HashMap<Integer, InnerAction> hashMap;
        Intrinsics.checkNotNullParameter(event, "event");
        String a16 = c.f436439a.a(Reflection.getOrCreateKotlinClass(event.getClass()));
        if (this.mActionMap.containsKey(a16) && (hashMap = this.mActionMap.get(a16)) != null) {
            Intrinsics.checkNotNullExpressionValue(hashMap, "mActionMap[type] ?: return");
            for (Map.Entry<Integer, InnerAction> entry : hashMap.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().call(event);
                }
            }
        }
    }

    public final void d(@Nullable String msgType, @NotNull a action) {
        HashMap<Integer, InnerAction> hashMap;
        Intrinsics.checkNotNullParameter(action, "action");
        HashMap<String, HashMap<Integer, InnerAction>> hashMap2 = this.mActionMap;
        if (hashMap2 != null) {
            if (hashMap2.containsKey(msgType) && (hashMap = this.mActionMap.get(msgType)) != null) {
                hashMap.remove(Integer.valueOf(action.hashCode()));
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }
}
