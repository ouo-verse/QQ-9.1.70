package com.tencent.mobileqq.aio.msglist.holder.component.template.template;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/template/a;", "", "", "", "b", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "BuiltInTemplateMap", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f191969a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, String> BuiltInTemplateMap;

    static {
        Map<String, String> mapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63525);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f191969a = new a();
        j jVar = j.f191985a;
        b bVar = b.f191971a;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("com.tencent.tuwen.lua;news", jVar.a()), TuplesKt.to("com.tencent.structmsg;news", jVar.a()), TuplesKt.to("com.tencent.miniapp.lua;miniapp", e.f191977a.a()), TuplesKt.to("com.tencent.miniapp_01;view_8C8E89B49BE609866298ADDFF2DBABA4", g.f191981a.a()), TuplesKt.to("com.tencent.contact.lua;contact", bVar.a()), TuplesKt.to("com.tencent.troopsharecard;contact", bVar.a()), TuplesKt.to("com.tencent.video.lua;video", k.f191987a.a()), TuplesKt.to("com.tencent.multimsg;contact", f.f191979a.a()), TuplesKt.to("com.tencent.feed.lua;feed", c.f191973a.a()), TuplesKt.to("com.tencent.plaintext.lua;feed", d.f191975a.a()), TuplesKt.to("com.tencent.picture.lua;pic", h.f191983a.a()));
        BuiltInTemplateMap = mapOf;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Map<String, String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return BuiltInTemplateMap;
    }
}
