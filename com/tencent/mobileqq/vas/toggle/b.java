package com.tencent.mobileqq.vas.toggle;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IUniteVasRes;
import com.tencent.mobileqq.vas.toggle.VasBaseConfigParser;
import com.tencent.mobileqq.vas.v;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011B6\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012#\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\n\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\tR1\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/toggle/b;", "Lcom/tencent/mobileqq/vas/v;", "Lcom/tencent/mobileqq/vas/toggle/VasBaseConfigParser$a;", "", "a", "", "success", "", "b", "Ljava/lang/String;", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function1;", "loadedCallback", "<init>", "(Ljava/lang/String;)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b implements v, VasBaseConfigParser.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String key;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function1<Boolean, Unit> loadedCallback;

    public b(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.loadedCallback = null;
    }

    @Override // com.tencent.mobileqq.vas.v
    @NotNull
    public String a() {
        return ((IUniteVasRes) QRoute.api(IUniteVasRes.class)).getResourcePath(this.key);
    }

    @Override // com.tencent.mobileqq.vas.toggle.VasBaseConfigParser.a
    public void b(boolean success) {
        Function1<Boolean, Unit> function1 = this.loadedCallback;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(success));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull String key, @Nullable Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.loadedCallback = function1;
        if (function1 != 0) {
            VasBaseConfigParser.INSTANCE.a(this);
        }
    }
}
