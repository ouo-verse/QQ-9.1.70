package com.tencent.luggage.wxa.lg;

import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.xd.p;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f133402a = new a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.lg.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6439a extends p {

        @Deprecated
        public static final int CTRL_INDEX = -2;

        @Deprecated
        @NotNull
        public static final String NAME = "onPluginUpdateStatusChange";

        /* renamed from: a, reason: collision with root package name */
        public static final C6440a f133403a = new C6440a(null);

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.lg.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6440a {
            public C6440a() {
            }

            public /* synthetic */ C6440a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    public static final void a(l lVar, b state, String pluginAppId, int i3, String str) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(pluginAppId, "pluginAppId");
        if (lVar == null) {
            return;
        }
        C6439a c6439a = new C6439a();
        c6439a.setData("pluginAppid", pluginAppId);
        c6439a.setData("state", state.f133409a);
        c6439a.setData("appVersion", Integer.valueOf(i3));
        c6439a.setData("customVersion", str);
        c6439a.setContext(lVar).dispatch();
    }
}
