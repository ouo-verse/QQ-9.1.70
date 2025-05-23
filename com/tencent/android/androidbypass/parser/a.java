package com.tencent.android.androidbypass.parser;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.android.androidbypass.Document;
import com.tencent.android.androidbypass.Element;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002H&J(\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&J6\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022$\b\u0002\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f`\u0010H&JL\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022$\b\u0002\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f`\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H&JH\u0010(\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H&\u00a8\u0006)"}, d2 = {"Lcom/tencent/android/androidbypass/parser/a;", "", "", "markdownText", "Landroid/widget/TextView;", "textView", "Lcom/tencent/android/androidbypass/parser/a$b;", "parseOption", "", "a", "Lcom/tencent/android/androidbypass/Document;", "b", "document", "g", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "switchMap", "Lcom/tencent/android/androidbypass/viewgroup/e;", "d", "Lorg/json/JSONObject;", "dataJSONObject", "Lcom/tencent/android/androidbypass/richui/b;", "processInterface", "f", "Lcom/tencent/android/androidbypass/Element;", DTConstants.TAG.ELEMENT, "c", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "Lcom/tencent/android/androidbypass/viewgroup/b;", "elementGroupList", "Lcom/tencent/android/androidbypass/viewgroup/d;", "markdownRender", "Ljava/util/ArrayList;", "Lcom/tencent/android/androidbypass/viewgroup/render/a;", "Lkotlin/collections/ArrayList;", "e", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface a {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.parser.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0724a {
        public static /* synthetic */ CharSequence a(a aVar, String str, TextView textView, b bVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    textView = null;
                }
                if ((i3 & 4) != 0) {
                    bVar = new b(0L, false, 3, null);
                }
                return aVar.a(str, textView, bVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: parseIntoTextView");
        }

        public static /* synthetic */ CharSequence b(a aVar, Document document, TextView textView, b bVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    textView = null;
                }
                if ((i3 & 4) != 0) {
                    bVar = new b(0L, false, 3, null);
                }
                return aVar.g(document, textView, bVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: parseIntoTextViewSync");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ com.tencent.android.androidbypass.viewgroup.e c(a aVar, String str, HashMap hashMap, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    hashMap = new HashMap();
                }
                return aVar.d(str, hashMap);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: parseMarkdownNode");
        }

        public static /* synthetic */ ArrayList d(a aVar, Context context, ViewGroup viewGroup, List list, b bVar, com.tencent.android.androidbypass.viewgroup.d dVar, int i3, Object obj) {
            b bVar2;
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    bVar2 = new b(0L, false, 3, null);
                } else {
                    bVar2 = bVar;
                }
                return aVar.e(context, viewGroup, list, bVar2, dVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderMarkdownView");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/android/androidbypass/parser/a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "traceId", "b", "Z", "()Z", "isAppendCompatibleText", "<init>", "(JZ)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long traceId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final boolean isAppendCompatibleText;

        public b() {
            this(0L, false, 3, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this);
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Long) iPatchRedirector.redirect((short) 1, (Object) this)).longValue();
            }
            return this.traceId;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.isAppendCompatibleText;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this != other) {
                if (other instanceof b) {
                    b bVar = (b) other;
                    if (this.traceId != bVar.traceId || this.isAppendCompatibleText != bVar.isAppendCompatibleText) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            int a16 = androidx.fragment.app.a.a(this.traceId) * 31;
            boolean z16 = this.isAppendCompatibleText;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return a16 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "ParseOption(traceId=" + this.traceId + ", isAppendCompatibleText=" + this.isAppendCompatibleText + ")";
        }

        public b(long j3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Boolean.valueOf(z16));
            } else {
                this.traceId = j3;
                this.isAppendCompatibleText = z16;
            }
        }

        public /* synthetic */ b(long j3, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? true : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    @NotNull
    CharSequence a(@NotNull String markdownText, @Nullable TextView textView, @NotNull b parseOption);

    @Nullable
    Document b(@NotNull String markdownText);

    @NotNull
    CharSequence c(@NotNull Element element);

    @NotNull
    com.tencent.android.androidbypass.viewgroup.e d(@NotNull String markdownText, @NotNull HashMap<String, Boolean> switchMap);

    @NotNull
    ArrayList<com.tencent.android.androidbypass.viewgroup.render.a> e(@NotNull Context context, @NotNull ViewGroup container, @NotNull List<? extends com.tencent.android.androidbypass.viewgroup.b> elementGroupList, @NotNull b parseOption, @NotNull com.tencent.android.androidbypass.viewgroup.d markdownRender);

    @NotNull
    com.tencent.android.androidbypass.viewgroup.e f(@NotNull String markdownText, @NotNull HashMap<String, Boolean> switchMap, @NotNull JSONObject dataJSONObject, @Nullable com.tencent.android.androidbypass.richui.b processInterface);

    @NotNull
    CharSequence g(@Nullable Document document, @Nullable TextView textView, @NotNull b parseOption);
}
