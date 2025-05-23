package com.tencent.luggage.wxa.yi;

import android.net.Network;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class v implements y {

    /* renamed from: a, reason: collision with root package name */
    public static final v f145966a = new v();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f145967b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f145968a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Field invoke() {
            try {
                Field declaredField = FileDescriptor.class.getDeclaredField("descriptor");
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.BindSocketToNetworkApi23Ability", "reflect descriptorField fail since " + e16);
                return null;
            }
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f145968a);
        f145967b = lazy;
    }

    public final Field a() {
        return (Field) f145967b.getValue();
    }

    @Override // com.tencent.luggage.wxa.yi.y
    public boolean a(int i3, Network network) {
        FileDescriptor a16;
        Intrinsics.checkNotNullParameter(network, "network");
        Field a17 = a();
        if (a17 == null || (a16 = a(i3, a17)) == null) {
            return false;
        }
        try {
            network.bindSocket(a16);
            return true;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.BindSocketToNetworkApi23Ability", "bindSocket fail since " + e16);
            return false;
        }
    }

    public final FileDescriptor a(int i3, Field field) {
        try {
            FileDescriptor fileDescriptor = new FileDescriptor();
            field.setInt(fileDescriptor, i3);
            return fileDescriptor;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.BindSocketToNetworkApi23Ability", "set descriptorField fail since " + e16);
            return null;
        }
    }
}
