package com.tencent.luggage.wxa.l3;

import android.util.Log;
import com.tencent.luggage.wxa.tn.w;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends com.tencent.luggage.wxa.z4.e {

    /* renamed from: j, reason: collision with root package name */
    public static final a f132996j = new a(null);

    /* renamed from: h, reason: collision with root package name */
    public final Class f132997h;

    /* renamed from: i, reason: collision with root package name */
    public final Class f132998i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public g(Class uiClass, Class pluginUIClass) {
        Intrinsics.checkNotNullParameter(uiClass, "uiClass");
        Intrinsics.checkNotNullParameter(pluginUIClass, "pluginUIClass");
        this.f132997h = uiClass;
        this.f132998i = pluginUIClass;
    }

    @Override // com.tencent.luggage.wxa.z4.e
    public boolean a(com.tencent.luggage.wxa.z4.c type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (!j() || b().isEmpty()) {
            return false;
        }
        Iterator it = b().iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.z4.e.a(this, new f((String) it.next(), "", type.name(), false, 0, 24, null), (Function0) null, 2, (Object) null);
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.z4.e
    public void b(com.tencent.luggage.wxa.z4.g record) {
        Intrinsics.checkNotNullParameter(record, "record");
        w.d("MicroMsg.WxaMiniProgramProcess", "sendFinishMessage record:" + record + ", stack:" + Log.getStackTraceString(new Throwable()));
        com.tencent.luggage.wxa.z4.e.a(this, new f(record.a(), record.d(), null, false, 0, 20, null), (Function0) null, 2, (Object) null);
    }

    @Override // com.tencent.luggage.wxa.z4.e
    public Class d() {
        return this.f132998i;
    }

    @Override // com.tencent.luggage.wxa.z4.e
    public Class f() {
        return this.f132997h;
    }
}
