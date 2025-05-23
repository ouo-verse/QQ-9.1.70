package com.tencent.mobileqq.onlinestatus.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R8\u0010\u0012\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\b0\u000ej\u0002`\u000f0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/observer/OnlineStatusCustomObserver;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "c", "b", "a", "", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/onlinestatus/observer/UpdateHandleFunc;", "d", "Ljava/util/Map;", "handleMap", "<init>", "()V", "e", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public class OnlineStatusCustomObserver implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, Function2<Boolean, Object, Unit>> handleMap;

    public OnlineStatusCustomObserver() {
        Map<Integer, Function2<Boolean, Object, Unit>> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(0, new OnlineStatusCustomObserver$handleMap$1(this)), TuplesKt.to(1, new OnlineStatusCustomObserver$handleMap$2(this)), TuplesKt.to(2, new OnlineStatusCustomObserver$handleMap$3(this)));
        this.handleMap = mapOf;
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
        Function2<Boolean, Object, Unit> function2 = this.handleMap.get(Integer.valueOf(type));
        if (function2 != null) {
            function2.invoke(Boolean.valueOf(isSuccess), data);
        }
    }

    public void a(boolean isSuccess, @Nullable Object data) {
    }

    public void b(boolean isSuccess, @Nullable Object data) {
    }

    public void c(boolean isSuccess, @Nullable Object data) {
    }
}
