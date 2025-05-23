package com.tencent.qqnt.markdown;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014JJ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005`\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/markdown/c;", "", "", "markdownText", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "switchMap", "Lorg/json/JSONObject;", "dataJSONObject", "Lcom/tencent/android/androidbypass/richui/b;", "processInterface", "Lcom/tencent/android/androidbypass/viewgroup/e;", "b", "", "a", "Lcom/tencent/android/androidbypass/parser/a;", "Lcom/tencent/android/androidbypass/parser/a;", "parser", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f359326a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.android.androidbypass.parser.a parser;

    static {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31333);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f359326a = new c();
        parser = g.f359430a.g().b();
        com.tencent.android.androidbypass.richui.g gVar = com.tencent.android.androidbypass.richui.g.f72342b;
        com.tencent.qqnt.rich.config.a aVar = (com.tencent.qqnt.rich.config.a) ((IUnitedConfigManager) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IUnitedConfigManager.class)).loadConfig("rich_ui_template_id_black");
        if (aVar != null) {
            copyOnWriteArrayList = aVar.a();
        } else {
            copyOnWriteArrayList = null;
        }
        gVar.b(copyOnWriteArrayList);
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @NotNull
    public final com.tencent.android.androidbypass.viewgroup.e b(@NotNull String markdownText, @NotNull HashMap<String, Boolean> switchMap, @NotNull JSONObject dataJSONObject, @Nullable com.tencent.android.androidbypass.richui.b processInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.android.androidbypass.viewgroup.e) iPatchRedirector.redirect((short) 2, this, markdownText, switchMap, dataJSONObject, processInterface);
        }
        Intrinsics.checkNotNullParameter(markdownText, "markdownText");
        Intrinsics.checkNotNullParameter(switchMap, "switchMap");
        Intrinsics.checkNotNullParameter(dataJSONObject, "dataJSONObject");
        return parser.f(markdownText, switchMap, dataJSONObject, processInterface);
    }
}
