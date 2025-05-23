package com.tencent.robot.scheme.api.impl.robotaio;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R<\u0010\f\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/scheme/api/impl/robotaio/c;", "", "", "actionName", "Lcom/tencent/robot/scheme/api/impl/robotaio/a;", "a", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lcom/tencent/robot/scheme/api/impl/robotaio/e;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "processClassMap", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f368310a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Class<e>> processClassMap;

    static {
        HashMap<String, Class<e>> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("open", e.class));
        processClassMap = hashMapOf;
    }

    c() {
    }

    @Nullable
    public final a a(@Nullable String actionName) {
        boolean z16;
        Class<e> cls;
        if (actionName != null && actionName.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || (cls = processClassMap.get(actionName)) == null) {
            return null;
        }
        return cls.newInstance();
    }
}
