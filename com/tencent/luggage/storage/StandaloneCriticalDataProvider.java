package com.tencent.luggage.storage;

import android.content.Context;
import com.tencent.luggage.wxa.o7.c;
import com.tencent.luggage.wxa.q7.a;
import com.tencent.luggage.wxa.xn.b;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0017\u00a8\u0006\n"}, d2 = {"Lcom/tencent/luggage/storage/StandaloneCriticalDataProvider;", "Lcom/tencent/luggage/wxa/o7/c;", "Lcom/tencent/luggage/wxa/xn/b;", "b", "", "onCreate", "<init>", "()V", "e", "a", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class StandaloneCriticalDataProvider extends c {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    public static StandaloneCriticalDataProvider f120268f;

    /* renamed from: com.tencent.luggage.storage.StandaloneCriticalDataProvider$a, reason: from kotlin metadata */
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StandaloneCriticalDataProvider a() {
            return StandaloneCriticalDataProvider.f120268f;
        }
    }

    @Override // com.tencent.luggage.wxa.o7.c
    public b b() {
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        if (!com.tencent.luggage.wxa.q7.b.a(context)) {
            return null;
        }
        b a16 = com.tencent.luggage.wxa.c6.b.a();
        Iterator c16 = com.tencent.luggage.wxa.c6.b.c();
        Intrinsics.checkNotNullExpressionValue(c16, "traverseAllStorages()");
        while (c16.hasNext()) {
            Map.Entry entry = (Map.Entry) c16.next();
            a((Class) entry.getKey(), entry.getValue());
        }
        return a16;
    }

    @Override // com.tencent.luggage.wxa.o7.c, android.content.ContentProvider
    public boolean onCreate() {
        boolean onCreate = super.onCreate();
        f120268f = this;
        a.f137866a.a(getContext());
        return onCreate;
    }
}
