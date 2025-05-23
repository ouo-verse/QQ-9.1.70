package com.tencent.qqnt.biz.lightbusiness.lightinteraction.replace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/replace/c;", "", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/replace/d;", "extraInfo", "", "source", "a", "", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/replace/a;", "b", "Ljava/util/List;", "replaceProcessors", "<init>", "()V", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f353167a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<a> replaceProcessors;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29884);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f353167a = new c();
        ArrayList arrayList = new ArrayList();
        replaceProcessors = arrayList;
        arrayList.add(new b());
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a(@NotNull d extraInfo, @NotNull String source) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) extraInfo, (Object) source);
        }
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Intrinsics.checkNotNullParameter(source, "source");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (a aVar : replaceProcessors) {
            List<String> a16 = aVar.a(source);
            if (!a16.isEmpty()) {
                linkedHashMap.put(aVar, a16);
            }
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = source;
            for (String str2 : (Iterable) entry.getValue()) {
                str = StringsKt__StringsJVMKt.replace$default(str, str2, ((a) entry.getKey()).b(str2, extraInfo), false, 4, (Object) null);
            }
            source = str;
        }
        return source;
    }
}
