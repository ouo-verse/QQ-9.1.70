package com.tencent.mobileqq.util.conversationtitlebutton;

import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.vas.entrance.VasZPlanSquareTitleButtonProcessor;
import com.tencent.mobileqq.zplan.aio.badge.p012new.ZPlanPortalTitleButtonProcessor;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R>\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/h;", "", "", "b", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/util/conversationtitlebutton/g;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "a", "()Ljava/util/HashMap;", "setProcessors", "(Ljava/util/HashMap;)V", "processors", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f306728a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/Chats/Inject_TitleButtonProcessor.yml", version = 1)
    @NotNull
    private static HashMap<String, g> processors;

    /* renamed from: c, reason: collision with root package name */
    private static HashMap f306730c;

    static {
        HashMap hashMap = new HashMap();
        f306730c = hashMap;
        hashMap.put("Adelie", z14.a.class);
        f306730c.put("ZPlanSquare", VasZPlanSquareTitleButtonProcessor.class);
        f306730c.put("ZPlanPortal", ZPlanPortalTitleButtonProcessor.class);
        f306730c.put("camera", e.class);
        f306730c.put("test", m.class);
        f306728a = new h();
        processors = new HashMap<>();
        b();
    }

    h() {
    }

    @JvmStatic
    @QAutoInitMethod
    public static final void b() {
        com.tencent.mobileqq.qroute.utils.b.b(f306730c, processors);
    }

    @NotNull
    public final HashMap<String, g> a() {
        return processors;
    }
}
