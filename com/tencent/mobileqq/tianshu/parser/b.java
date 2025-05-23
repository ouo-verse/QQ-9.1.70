package com.tencent.mobileqq.tianshu.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/tianshu/parser/b;", "Lcom/tencent/freesia/IConfigData;", "", "configStr", "", "b", "", "Lcom/tencent/mobileqq/tianshu/parser/a;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "setPageConfig", "(Ljava/util/List;)V", "pageConfig", "Lcom/google/gson/Gson;", "e", "Lcom/google/gson/Gson;", "gson", "<init>", "()V", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<com.tencent.mobileqq.tianshu.parser.a> pageConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Gson gson;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/tianshu/parser/b$a", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/tencent/mobileqq/tianshu/parser/a;", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a extends TypeToken<List<? extends com.tencent.mobileqq.tianshu.parser.a>> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.gson = new Gson();
        }
    }

    @Nullable
    public final List<com.tencent.mobileqq.tianshu.parser.a> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.pageConfig;
    }

    public final void b(@NotNull String configStr) {
        List<com.tencent.mobileqq.tianshu.parser.a> list;
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) configStr);
            return;
        }
        Intrinsics.checkNotNullParameter(configStr, "configStr");
        this.pageConfig = new ArrayList();
        Type type = new a().getType();
        Intrinsics.checkNotNullExpressionValue(type, "object : TypeToken<List<Page?>?>() {}.type");
        try {
            List<com.tencent.mobileqq.tianshu.parser.a> pages = (List) this.gson.fromJson(configStr, type);
            Intrinsics.checkNotNullExpressionValue(pages, "pages");
            for (com.tencent.mobileqq.tianshu.parser.a aVar : pages) {
                if (aVar != null && (list = this.pageConfig) != null) {
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(aVar);
                    list.addAll(listOf);
                }
            }
        } catch (Exception unused) {
        }
    }
}
