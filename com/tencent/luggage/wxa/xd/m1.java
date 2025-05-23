package com.tencent.luggage.wxa.xd;

import android.os.Build;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class m1 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f144865a = new a(null);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(JSONObject obj, String key, Object obj2) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            Intrinsics.checkNotNullParameter(key, "key");
            try {
                obj.put(key, obj2);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.WASnapshotConfigProvider", e16, "put with key(" + key + ')', new Object[0]);
            }
        }
    }

    public void a(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        a aVar = f144865a;
        aVar.a(config, "platform", "android");
        aVar.a(config, "brand", Build.BRAND);
        aVar.a(config, "model", com.tencent.luggage.wxa.t9.l.g());
    }
}
