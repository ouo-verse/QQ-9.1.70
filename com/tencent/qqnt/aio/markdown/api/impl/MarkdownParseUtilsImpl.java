package com.tencent.qqnt.aio.markdown.api.impl;

import android.content.Context;
import com.tencent.mobileqq.guild.temp.api.IGuildMarkdownApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016J*\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/markdown/api/impl/MarkdownParseUtilsImpl;", "", "", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstractElement;", "elemList", "", "b", "", "markdownText", "", "c", "", "limit", "d", "elem", "e", "f", "Landroid/content/Context;", "context", "uid", "g", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class MarkdownParseUtilsImpl {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f351219b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/markdown/api/impl/MarkdownParseUtilsImpl$a;", "", "", "parseSwitch$delegate", "Lkotlin/Lazy;", "b", "()Z", "parseSwitch", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.markdown.api.impl.MarkdownParseUtilsImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) MarkdownParseUtilsImpl.f351219b.getValue()).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63663);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(MarkdownParseUtilsImpl$Companion$parseSwitch$2.INSTANCE);
        f351219b = lazy;
    }

    public MarkdownParseUtilsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b(List<MsgAbstractElement> elemList) {
        boolean z16;
        Object obj = null;
        if (elemList != null) {
            Iterator<T> it = elemList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((MsgAbstractElement) next).elementType == 14) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    obj = next;
                    break;
                }
            }
            obj = (MsgAbstractElement) obj;
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public CharSequence c(@NotNull String markdownText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this, (Object) markdownText);
        }
        Intrinsics.checkNotNullParameter(markdownText, "markdownText");
        CharSequence parseMarkdown = ((IGuildMarkdownApi) QRoute.api(IGuildMarkdownApi.class)).parseMarkdown(markdownText);
        Intrinsics.checkNotNullExpressionValue(parseMarkdown, "api(IGuildMarkdownApi::c\u2026rseMarkdown(markdownText)");
        return parseMarkdown;
    }

    @NotNull
    public CharSequence d(@NotNull String markdownText, int limit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this, (Object) markdownText, limit);
        }
        Intrinsics.checkNotNullParameter(markdownText, "markdownText");
        CharSequence parseExcludeExtData = ((IGuildMarkdownApi) QRoute.api(IGuildMarkdownApi.class)).parseExcludeExtData(markdownText, limit);
        Intrinsics.checkNotNullExpressionValue(parseExcludeExtData, "api(IGuildMarkdownApi::c\u2026Data(markdownText, limit)");
        return parseExcludeExtData;
    }

    @Nullable
    public String e(@Nullable MsgAbstractElement elem) {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) elem);
        }
        if (elem == null) {
            return null;
        }
        if (elem.elementType == 14) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            elem = null;
        }
        if (elem == null || (str = elem.customContent) == null) {
            return null;
        }
        return d(str, -1).toString();
    }

    @Nullable
    public String f(@Nullable List<MsgAbstractElement> elemList) {
        StringBuilder sb5;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) elemList);
        }
        if (elemList != null) {
            sb5 = null;
            for (MsgAbstractElement msgAbstractElement : elemList) {
                if (msgAbstractElement != null && msgAbstractElement.elementType == 14) {
                    String str = msgAbstractElement.mdSummary;
                    if (str != null && str.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        return msgAbstractElement.mdSummary;
                    }
                    if (sb5 == null) {
                        sb5 = new StringBuilder();
                    }
                    sb5.append(msgAbstractElement.customContent);
                    if (INSTANCE.b() && sb5.length() > 500) {
                        String sb6 = sb5.toString();
                        Intrinsics.checkNotNullExpressionValue(sb6, "toString()");
                        return c(sb6).toString();
                    }
                }
            }
        } else {
            sb5 = null;
        }
        if (sb5 == null) {
            return null;
        }
        if (INSTANCE.b()) {
            String sb7 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb7, "it.toString()");
            return c(sb7).toString();
        }
        String sb8 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb8, "it.toString()");
        return d(sb8, 30).toString();
    }

    @Nullable
    public String g(@NotNull Context context, @NotNull String uid, @Nullable List<MsgAbstractElement> elemList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, context, uid, elemList);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        if (!b(elemList)) {
            return null;
        }
        return f(elemList);
    }
}
