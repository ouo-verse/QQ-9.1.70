package com.tencent.android.androidbypass.parser;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.android.androidbypass.Bypass;
import com.tencent.android.androidbypass.Document;
import com.tencent.android.androidbypass.Element;
import com.tencent.android.androidbypass.parser.a;
import com.tencent.android.androidbypass.parser.d;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqmini.sdk.widget.ToastView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0010B\u0011\b\u0000\u0012\u0006\u00104\u001a\u000202\u00a2\u0006\u0004\b5\u00106J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016J$\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\"\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J4\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\b2\"\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0012`\u0013H\u0016JF\u0010\u001b\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\b2\"\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0012`\u00132\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016JF\u0010+\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010'\u001a\u00020&H\u0016R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/android/androidbypass/parser/e;", "Lcom/tencent/android/androidbypass/parser/a;", "Landroid/widget/TextView;", "textView", "", "documentParsedResult", "", h.F, "", "markdownText", "Lcom/tencent/android/androidbypass/Document;", "b", "document", "Lcom/tencent/android/androidbypass/parser/a$b;", "parseOption", "g", "a", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "switchMap", "Lcom/tencent/android/androidbypass/viewgroup/e;", "d", "Lorg/json/JSONObject;", "dataJSONObject", "Lcom/tencent/android/androidbypass/richui/b;", "processInterface", "f", "Lcom/tencent/android/androidbypass/Element;", DTConstants.TAG.ELEMENT, "c", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "Lcom/tencent/android/androidbypass/viewgroup/b;", "elementGroupList", "Lcom/tencent/android/androidbypass/viewgroup/d;", "markdownRender", "Ljava/util/ArrayList;", "Lcom/tencent/android/androidbypass/viewgroup/render/a;", "Lkotlin/collections/ArrayList;", "e", "Lcom/tencent/android/androidbypass/Bypass;", "Lcom/tencent/android/androidbypass/Bypass;", "mBypass", "Lcom/tencent/android/androidbypass/viewgroup/a;", "Lcom/tencent/android/androidbypass/viewgroup/a;", "mBypassViewGroup", "Lcom/tencent/android/androidbypass/parser/d$b;", "Lcom/tencent/android/androidbypass/parser/d$b;", "mOption", "<init>", "(Lcom/tencent/android/androidbypass/parser/d$b;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class e implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Bypass mBypass;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.tencent.android.androidbypass.viewgroup.a mBypassViewGroup;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final d.b mOption;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/android/androidbypass/parser/e$a;", "", "", "LOADING_TEXT", "Ljava/lang/String;", "TAG", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.parser.e$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18271);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e(@NotNull d.b mOption) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(mOption, "mOption");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) mOption);
            return;
        }
        this.mOption = mOption;
        try {
            Result.Companion companion = Result.INSTANCE;
            Bypass.f fVar = new Bypass.f();
            fVar.m(new com.tencent.android.androidbypass.parser.api.c(mOption.f()));
            fVar.h(false);
            fVar.j(mOption.b().a());
            fVar.k(mOption.g());
            fVar.i(mOption.c());
            fVar.l(mOption.h());
            Unit unit = Unit.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(new Bypass(fVar));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Bypass bypass = null;
        Bypass bypass2 = (Bypass) (Result.m482isFailureimpl(m476constructorimpl) ? null : m476constructorimpl);
        if (bypass2 != null) {
            this.mBypassViewGroup = new com.tencent.android.androidbypass.viewgroup.a(bypass2);
            Unit unit2 = Unit.INSTANCE;
            bypass = bypass2;
        }
        this.mBypass = bypass;
        com.tencent.android.androidbypass.config.a.f72050b.a();
        Bypass bypass3 = this.mBypass;
        if (bypass3 != null) {
            bypass3.setImageSpanClickListener(this.mOption.d());
        }
        Bypass bypass4 = this.mBypass;
        if (bypass4 != null) {
            bypass4.setUrlSpanClickListener(this.mOption.a());
        }
    }

    private final void h(TextView textView, CharSequence documentParsedResult) {
        boolean z16;
        if (textView != null) {
            textView.setMovementMethod(com.tencent.android.androidbypass.enhance.method.b.a());
            Integer valueOf = Integer.valueOf(this.mOption.i().a());
            if (valueOf.intValue() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            TextView textView2 = null;
            if (!z16) {
                valueOf = null;
            }
            if (valueOf != null) {
                textView.setLinkTextColor(ResourcesCompat.getColorStateList(textView.getResources(), valueOf.intValue(), null));
            }
            if (!(textView instanceof EditText)) {
                textView2 = textView;
            }
            if (textView2 != null) {
                textView2.setHighlightColor(0);
            }
            textView.setAutoLinkMask(0);
            textView.setText(documentParsedResult);
        }
    }

    @Override // com.tencent.android.androidbypass.parser.a
    @NotNull
    public CharSequence a(@NotNull String markdownText, @Nullable TextView textView, @NotNull a.b parseOption) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CharSequence) iPatchRedirector.redirect((short) 4, this, markdownText, textView, parseOption);
        }
        Intrinsics.checkNotNullParameter(markdownText, "markdownText");
        Intrinsics.checkNotNullParameter(parseOption, "parseOption");
        if (!com.tencent.android.androidbypass.config.a.f72050b.a()) {
            com.tencent.android.androidbypass.config.a.f72049a.e("MarkdownParserImpl", "load bypass.so failed");
            if (textView != null) {
                textView.setText(this.mOption.i().c());
                return ToastView.ICON_LOADING;
            }
            return ToastView.ICON_LOADING;
        }
        Bypass bypass = this.mBypass;
        if (bypass != null) {
            b a16 = c.a(markdownText);
            if (a16 == null || (str = a16.b()) == null) {
                str = markdownText;
            }
            CharSequence markdownParsedResult = bypass.markdownToSpannable(str, this.mOption.e(), textView, this.mOption.i().b(), parseOption);
            h(textView, markdownParsedResult);
            Intrinsics.checkNotNullExpressionValue(markdownParsedResult, "markdownParsedResult");
            return markdownParsedResult;
        }
        return markdownText;
    }

    @Override // com.tencent.android.androidbypass.parser.a
    @Nullable
    public Document b(@NotNull String markdownText) {
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Document) iPatchRedirector.redirect((short) 2, (Object) this, (Object) markdownText);
        }
        Intrinsics.checkNotNullParameter(markdownText, "markdownText");
        if (!com.tencent.android.androidbypass.config.a.f72050b.a()) {
            com.tencent.android.androidbypass.config.a.f72049a.e("MarkdownParserImpl", "load bypass.so failed");
            return null;
        }
        Bypass bypass = this.mBypass;
        if (bypass == null) {
            return null;
        }
        b a16 = c.a(markdownText);
        if (a16 != null && (b16 = a16.b()) != null) {
            markdownText = b16;
        }
        return bypass.markdownToDocumentAsync(markdownText);
    }

    @Override // com.tencent.android.androidbypass.parser.a
    @NotNull
    public CharSequence c(@NotNull Element element) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CharSequence) iPatchRedirector.redirect((short) 7, (Object) this, (Object) element);
        }
        Intrinsics.checkNotNullParameter(element, "element");
        com.tencent.android.androidbypass.viewgroup.a aVar = this.mBypassViewGroup;
        if (aVar != null) {
            return aVar.h(element, this.mOption, new a.b(0L, false, 3, null));
        }
        return "";
    }

    @Override // com.tencent.android.androidbypass.parser.a
    @NotNull
    public com.tencent.android.androidbypass.viewgroup.e d(@NotNull String markdownText, @NotNull HashMap<String, Boolean> switchMap) {
        List emptyList;
        List emptyList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.android.androidbypass.viewgroup.e) iPatchRedirector.redirect((short) 5, (Object) this, (Object) markdownText, (Object) switchMap);
        }
        Intrinsics.checkNotNullParameter(markdownText, "markdownText");
        Intrinsics.checkNotNullParameter(switchMap, "switchMap");
        com.tencent.android.androidbypass.viewgroup.a aVar = this.mBypassViewGroup;
        if (aVar == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return new com.tencent.android.androidbypass.viewgroup.e(emptyList, emptyList2);
        }
        return com.tencent.android.androidbypass.viewgroup.a.g(aVar, markdownText, switchMap, null, null, 12, null);
    }

    @Override // com.tencent.android.androidbypass.parser.a
    @NotNull
    public ArrayList<com.tencent.android.androidbypass.viewgroup.render.a> e(@NotNull Context context, @NotNull ViewGroup container, @NotNull List<? extends com.tencent.android.androidbypass.viewgroup.b> elementGroupList, @NotNull a.b parseOption, @NotNull com.tencent.android.androidbypass.viewgroup.d markdownRender) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, this, context, container, elementGroupList, parseOption, markdownRender);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(elementGroupList, "elementGroupList");
        Intrinsics.checkNotNullParameter(parseOption, "parseOption");
        Intrinsics.checkNotNullParameter(markdownRender, "markdownRender");
        com.tencent.android.androidbypass.viewgroup.a aVar = this.mBypassViewGroup;
        if (aVar != null) {
            return aVar.l(container, elementGroupList, this.mOption, parseOption, markdownRender);
        }
        return new ArrayList<>();
    }

    @Override // com.tencent.android.androidbypass.parser.a
    @NotNull
    public com.tencent.android.androidbypass.viewgroup.e f(@NotNull String markdownText, @NotNull HashMap<String, Boolean> switchMap, @NotNull JSONObject dataJSONObject, @Nullable com.tencent.android.androidbypass.richui.b processInterface) {
        List emptyList;
        List emptyList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.android.androidbypass.viewgroup.e) iPatchRedirector.redirect((short) 6, this, markdownText, switchMap, dataJSONObject, processInterface);
        }
        Intrinsics.checkNotNullParameter(markdownText, "markdownText");
        Intrinsics.checkNotNullParameter(switchMap, "switchMap");
        Intrinsics.checkNotNullParameter(dataJSONObject, "dataJSONObject");
        com.tencent.android.androidbypass.viewgroup.a aVar = this.mBypassViewGroup;
        if (aVar == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return new com.tencent.android.androidbypass.viewgroup.e(emptyList, emptyList2);
        }
        return aVar.f(markdownText, switchMap, dataJSONObject, processInterface);
    }

    @Override // com.tencent.android.androidbypass.parser.a
    @NotNull
    public CharSequence g(@Nullable Document document, @Nullable TextView textView, @NotNull a.b parseOption) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, this, document, textView, parseOption);
        }
        Intrinsics.checkNotNullParameter(parseOption, "parseOption");
        if (!com.tencent.android.androidbypass.config.a.f72050b.a()) {
            com.tencent.android.androidbypass.config.a.f72049a.e("MarkdownParserImpl", "load bypass.so failed");
            if (textView != null) {
                textView.setText(this.mOption.i().c());
                return ToastView.ICON_LOADING;
            }
            return ToastView.ICON_LOADING;
        }
        Bypass bypass = this.mBypass;
        if (bypass != null) {
            CharSequence documentParsedResult = bypass.documentToSpannable(document, textView, this.mOption.i().b(), parseOption);
            h(textView, documentParsedResult);
            Intrinsics.checkNotNullExpressionValue(documentParsedResult, "documentParsedResult");
            return documentParsedResult;
        }
        return "";
    }
}
