package com.tencent.qqnt.graytips.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J \u0010\t\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000fR'\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00138\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/graytips/util/a;", "", "", "text", "", "color", "a", "Lcom/tencent/qqnt/graytips/action/f;", "actionInfo", "b", "Lcom/tencent/qqnt/graytips/util/a$a;", "e", "Ljava/lang/StringBuilder;", "Ljava/lang/StringBuilder;", "getContent", "()Ljava/lang/StringBuilder;", "content", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/graytips/c;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getHighlightItems", "()Ljava/util/ArrayList;", "highlightItems", "<init>", "()V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final StringBuilder content;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.qqnt.graytips.c> highlightItems;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/graytips/util/a$a;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "content", "", "Lcom/tencent/qqnt/graytips/c;", "b", "Ljava/util/List;", "()Ljava/util/List;", "highlightItems", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.graytips.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static final class C9628a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String content;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<com.tencent.qqnt.graytips.c> highlightItems;

        public C9628a(@NotNull String content, @NotNull List<com.tencent.qqnt.graytips.c> highlightItems) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(highlightItems, "highlightItems");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) content, (Object) highlightItems);
            } else {
                this.content = content;
                this.highlightItems = highlightItems;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.content;
        }

        @NotNull
        public final List<com.tencent.qqnt.graytips.c> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.highlightItems;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.content = new StringBuilder();
            this.highlightItems = new ArrayList<>();
        }
    }

    public static /* synthetic */ a c(a aVar, String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return aVar.a(str, i3);
    }

    public static /* synthetic */ a d(a aVar, String str, com.tencent.qqnt.graytips.action.f fVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 3;
        }
        return aVar.b(str, fVar, i3);
    }

    @NotNull
    public final a a(@NotNull String text, int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) text, color);
        }
        Intrinsics.checkNotNullParameter(text, "text");
        int length = this.content.length();
        int length2 = length + text.length();
        this.content.append(text);
        if (color != 1) {
            this.highlightItems.add(new com.tencent.qqnt.graytips.c(length, length2, color, null, 8, null));
        }
        return this;
    }

    @NotNull
    public final a b(@NotNull String text, @NotNull com.tencent.qqnt.graytips.action.f actionInfo, int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (a) iPatchRedirector.redirect((short) 9, this, text, actionInfo, Integer.valueOf(color));
        }
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        int length = this.content.length();
        int length2 = text.length() + length;
        this.content.append(text);
        this.highlightItems.add(new com.tencent.qqnt.graytips.c(length, length2, color, actionInfo));
        return this;
    }

    @NotNull
    public final C9628a e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (C9628a) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        String sb5 = this.content.toString();
        Intrinsics.checkNotNullExpressionValue(sb5, "content.toString()");
        return new C9628a(sb5, this.highlightItems);
    }
}
