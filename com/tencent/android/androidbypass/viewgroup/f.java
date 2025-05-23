package com.tencent.android.androidbypass.viewgroup;

import android.net.Uri;
import com.tencent.android.androidbypass.Element;
import com.tencent.android.androidbypass.richui.viewdata.k;
import com.tencent.ark.ark;
import com.tencent.bypass.nativeinterface.CustomElement;
import com.tencent.bypass.nativeinterface.CustomStyleElement;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\"B+\u0012\u0018\b\u0002\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006#"}, d2 = {"Lcom/tencent/android/androidbypass/viewgroup/f;", "Lcom/tencent/android/androidbypass/viewgroup/b;", "", "c", "Lcom/tencent/android/androidbypass/richui/viewdata/k;", "Lcom/tencent/android/androidbypass/richui/viewdata/k;", "e", "()Lcom/tencent/android/androidbypass/richui/viewdata/k;", h.F, "(Lcom/tencent/android/androidbypass/richui/viewdata/k;)V", "viewNode", "Lorg/json/JSONObject;", "d", "Lorg/json/JSONObject;", "getDataJSONObject", "()Lorg/json/JSONObject;", "f", "(Lorg/json/JSONObject;)V", "dataJSONObject", "Lcom/tencent/android/androidbypass/richui/b;", "Lcom/tencent/android/androidbypass/richui/b;", "getProcessSourceInterface", "()Lcom/tencent/android/androidbypass/richui/b;", "g", "(Lcom/tencent/android/androidbypass/richui/b;)V", "processSourceInterface", "Ljava/util/ArrayList;", "Lcom/tencent/android/androidbypass/Element;", "Lkotlin/collections/ArrayList;", "elementList", "", "type", "<init>", "(Ljava/util/ArrayList;I)V", "a", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class f extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private k viewNode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private JSONObject dataJSONObject;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.android.androidbypass.richui.b processSourceInterface;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/android/androidbypass/viewgroup/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.viewgroup.f$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19357);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f() {
        this(null, 0, 3, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this);
    }

    @Override // com.tencent.android.androidbypass.viewgroup.b
    public void c() {
        Object firstOrNull;
        CustomStyleElement styleElement;
        String link;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) a());
            Element element = (Element) firstOrNull;
            if (element != null) {
                try {
                    CustomElement customElement = element.getCustomElement();
                    if (customElement != null && (styleElement = customElement.getStyleElement()) != null && (link = styleElement.getLink()) != null) {
                        Intrinsics.checkNotNullExpressionValue(link, "element.getCustomElement\u2026leElement?.link ?: return");
                        String queryParameter = Uri.parse(link).getQueryParameter(ark.ARKMETADATA_JSON);
                        if (queryParameter != null) {
                            Intrinsics.checkNotNullExpressionValue(queryParameter, "uri.getQueryParameter(\"json\") ?: return");
                            this.viewNode = com.tencent.android.androidbypass.richui.e.f72322a.b(queryParameter, this.dataJSONObject, this.processSourceInterface);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    com.tencent.android.androidbypass.config.a.f72049a.i("RichElementGroup", "[renderMarkdown]: " + e16);
                    return;
                }
            }
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this);
    }

    @Nullable
    public final k e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (k) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.viewNode;
    }

    public final void f(@NotNull JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) jSONObject);
        } else {
            Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
            this.dataJSONObject = jSONObject;
        }
    }

    public final void g(@Nullable com.tencent.android.androidbypass.richui.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
        } else {
            this.processSourceInterface = bVar;
        }
    }

    public final void h(@Nullable k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) kVar);
        } else {
            this.viewNode = kVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull ArrayList<Element> elementList, int i3) {
        super(elementList, i3);
        Intrinsics.checkNotNullParameter(elementList, "elementList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            this.dataJSONObject = new JSONObject();
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) elementList, i3);
        }
    }

    public /* synthetic */ f(ArrayList arrayList, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? new ArrayList() : arrayList, (i16 & 2) != 0 ? 1 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, this, arrayList, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
