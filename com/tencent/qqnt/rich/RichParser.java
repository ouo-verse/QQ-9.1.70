package com.tencent.qqnt.rich;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J \u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J,\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005R$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R3\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00160\u0015j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0016`\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0012\u0010\u001aR7\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001c0\u0015j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001c`\u00178FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u0018\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/rich/RichParser;", "", "", "templateStr", "dataStr", "Lcom/tencent/android/androidbypass/richui/b;", "processInterface", "Lcom/tencent/qqnt/rich/c;", "d", "markdownStr", "Lcom/tencent/qqnt/markdown/data/d;", "parseOptions", "Lorg/json/JSONObject;", "dataJSONObject", "c", "Ljava/util/ArrayList;", "Lcom/tencent/android/androidbypass/viewgroup/b;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "elementGroupList", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/markdown/data/b;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "mkExtDataMap", "Lcom/tencent/qqnt/markdown/data/a;", "Lkotlin/Lazy;", "mkExtParserMap", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RichParser {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.android.androidbypass.viewgroup.b> elementGroupList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, com.tencent.qqnt.markdown.data.b> mkExtDataMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mkExtParserMap;

    public RichParser() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.elementGroupList = new ArrayList<>();
        this.mkExtDataMap = new HashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<String, com.tencent.qqnt.markdown.data.a>>() { // from class: com.tencent.qqnt.rich.RichParser$mkExtParserMap$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RichParser.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, com.tencent.qqnt.markdown.data.a> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (HashMap) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                HashMap<String, com.tencent.qqnt.markdown.data.a> hashMap = new HashMap<>();
                RichParser richParser = RichParser.this;
                hashMap.put("quoteArea", new com.tencent.qqnt.markdown.data.quote.h(richParser.a()));
                hashMap.put("multiPic", new com.tencent.qqnt.markdown.data.multipic.d(richParser.a()));
                return hashMap;
            }
        });
        this.mkExtParserMap = lazy;
    }

    @NotNull
    public final HashMap<String, com.tencent.qqnt.markdown.data.b> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mkExtDataMap;
    }

    @NotNull
    public final HashMap<String, com.tencent.qqnt.markdown.data.a> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (HashMap) this.mkExtParserMap.getValue();
    }

    @NotNull
    public final c c(@NotNull String markdownStr, @NotNull com.tencent.qqnt.markdown.data.d parseOptions, @NotNull JSONObject dataJSONObject, @Nullable com.tencent.android.androidbypass.richui.b processInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (c) iPatchRedirector.redirect((short) 5, this, markdownStr, parseOptions, dataJSONObject, processInterface);
        }
        Intrinsics.checkNotNullParameter(markdownStr, "markdownStr");
        Intrinsics.checkNotNullParameter(parseOptions, "parseOptions");
        Intrinsics.checkNotNullParameter(dataJSONObject, "dataJSONObject");
        this.elementGroupList.clear();
        com.tencent.android.androidbypass.viewgroup.e b16 = com.tencent.qqnt.markdown.c.f359326a.b(markdownStr, new HashMap<>(), dataJSONObject, processInterface);
        this.elementGroupList.addAll(b16.a());
        this.mkExtDataMap.clear();
        for (com.tencent.android.androidbypass.viewgroup.c cVar : b16.b()) {
            com.tencent.qqnt.markdown.data.a aVar = b().get(cVar.e());
            if (aVar != null) {
                aVar.b(cVar, parseOptions);
            }
        }
        return new c(this.elementGroupList, this.mkExtDataMap);
    }

    @Nullable
    public final c d(@NotNull String templateStr, @NotNull String dataStr, @NotNull com.tencent.android.androidbypass.richui.b processInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, this, templateStr, dataStr, processInterface);
        }
        Intrinsics.checkNotNullParameter(templateStr, "templateStr");
        Intrinsics.checkNotNullParameter(dataStr, "dataStr");
        Intrinsics.checkNotNullParameter(processInterface, "processInterface");
        ArrayList arrayList = null;
        byte b16 = 0;
        try {
            com.tencent.qqnt.markdown.c.f359326a.a();
            this.elementGroupList.clear();
            com.tencent.android.androidbypass.viewgroup.f fVar = new com.tencent.android.androidbypass.viewgroup.f(arrayList, i3, 1, b16 == true ? 1 : 0);
            fVar.h(com.tencent.android.androidbypass.richui.e.f72322a.a(new JSONObject(templateStr), new JSONObject(dataStr), processInterface));
            this.elementGroupList.add(fVar);
            return new c(this.elementGroupList, new HashMap());
        } catch (Exception unused) {
            return null;
        }
    }
}
