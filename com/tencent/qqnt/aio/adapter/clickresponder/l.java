package com.tencent.qqnt.aio.adapter.clickresponder;

import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002RJ\u0010\u0010\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b`\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/clickresponder/l;", "", "", "busiId", "Lcom/tencent/qqnt/aio/adapter/clickresponder/e;", "a", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "getResponderClassMap", "()Ljava/util/HashMap;", "setResponderClassMap", "(Ljava/util/HashMap;)V", "responderClassMap", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f348732a = new l();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/msg/Inject_Tofu_Click_Responder.yml", version = 1)
    private static HashMap<String, Class<e>> responderClassMap;

    static {
        HashMap<String, Class<e>> hashMap = new HashMap<>();
        responderClassMap = hashMap;
        hashMap.put("21", n.class);
        responderClassMap.put("20", m.class);
        responderClassMap.put("18", h.class);
        responderClassMap.put("10", g.class);
        responderClassMap.put("17", c.class);
        responderClassMap.put("16", h.class);
        responderClassMap.put("15", f.class);
        responderClassMap.put("14", k.class);
        responderClassMap.put("6", m.class);
        responderClassMap.put("3", d.class);
        responderClassMap.put("13", a.class);
        responderClassMap.put("12", i.class);
        responderClassMap.put("2", j.class);
        responderClassMap.put("1", GeQianResponder.class);
    }

    l() {
    }

    public final e a(long busiId) {
        if (responderClassMap.containsKey(String.valueOf(busiId))) {
            Class<e> cls = responderClassMap.get(String.valueOf(busiId));
            Intrinsics.checkNotNull(cls);
            e newInstance = cls.newInstance();
            Intrinsics.checkNotNullExpressionValue(newInstance, "responderClassMap.get(bu\u2026String())!!.newInstance()");
            return newInstance;
        }
        return new b();
    }
}
