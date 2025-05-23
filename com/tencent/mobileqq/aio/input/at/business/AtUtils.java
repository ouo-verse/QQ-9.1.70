package com.tencent.mobileqq.aio.input.at.business;

import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J<\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002J\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0005J\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0012J4\u0010\u001e\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000b0\u001bJ4\u0010\u001f\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000b0\u001bJ:\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0 2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000b0\u001b\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/business/AtUtils;", "", "T", "Landroid/text/Spanned;", "inputText", "", "index", "searchStart", "searchEnd", "Ljava/lang/Class;", "spanClass", "", "j", "editable", "endIndex", "e", "selectionStart", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "memberInfo", "", tl.h.F, "", "d", "spanned", "start", "end", "Lkotlin/Function1;", "Lcom/tencent/qqnt/aio/at/c;", "matcher", "i", "f", "", "g", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AtUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AtUtils f189228a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53307);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f189228a = new AtUtils();
        }
    }

    AtUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    private final <T> boolean j(Spanned inputText, int index, int searchStart, int searchEnd, Class<T> spanClass) {
        Object[] spans;
        boolean z16;
        if (index < 0 || searchStart < 0 || searchEnd < 0 || (spans = inputText.getSpans(searchStart, searchEnd, spanClass)) == null) {
            return false;
        }
        for (Object obj : spans) {
            int spanStart = inputText.getSpanStart(obj);
            int spanEnd = inputText.getSpanEnd(obj);
            if (spanStart <= index && index < spanEnd) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public final int b(@NotNull final Spanned editable, int selectionStart) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) editable, selectionStart)).intValue();
        }
        Intrinsics.checkNotNullParameter(editable, "editable");
        boolean z16 = false;
        com.tencent.qqnt.aio.at.c[] cVarArr = (com.tencent.qqnt.aio.at.c[]) editable.getSpans(0, selectionStart, com.tencent.qqnt.aio.at.c.class);
        if (cVarArr != null) {
            if (cVarArr.length == 0) {
                z16 = true;
            }
            if (!z16) {
                final Function2<com.tencent.qqnt.aio.at.c, com.tencent.qqnt.aio.at.c, Integer> function2 = new Function2<com.tencent.qqnt.aio.at.c, com.tencent.qqnt.aio.at.c, Integer>(editable) { // from class: com.tencent.mobileqq.aio.input.at.business.AtUtils$getAtIndexInLastAtSpan$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Spanned $editable;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        this.$editable = editable;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) editable);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @NotNull
                    public final Integer invoke(com.tencent.qqnt.aio.at.c cVar, com.tencent.qqnt.aio.at.c cVar2) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? Integer.valueOf(this.$editable.getSpanStart(cVar) - this.$editable.getSpanStart(cVar2)) : (Integer) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) cVar, (Object) cVar2);
                    }
                };
                Arrays.sort(cVarArr, new Comparator() { // from class: com.tencent.mobileqq.aio.input.at.business.g
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int c16;
                        c16 = AtUtils.c(Function2.this, obj, obj2);
                        return c16;
                    }
                });
                return editable.getSpanStart(cVarArr[cVarArr.length - 1]);
            }
            return -1;
        }
        return -1;
    }

    @NotNull
    public final String d(@NotNull MemberInfo memberInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) memberInfo);
        }
        Intrinsics.checkNotNullParameter(memberInfo, "memberInfo");
        String nickName = memberInfo.cardName;
        if (TextUtils.isEmpty(nickName)) {
            nickName = memberInfo.nick;
        }
        if (TextUtils.isEmpty(nickName)) {
            nickName = String.valueOf(memberInfo.uin);
        }
        Intrinsics.checkNotNullExpressionValue(nickName, "nickName");
        return nickName;
    }

    public final int e(@NotNull Spanned editable, int endIndex) {
        boolean z16;
        int lastIndexOf$default;
        int lastIndexOf$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) editable, endIndex)).intValue();
        }
        Intrinsics.checkNotNullParameter(editable, "editable");
        String obj = editable.toString();
        int length = obj.length();
        if (endIndex > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = -1;
        int i16 = endIndex;
        int i17 = -1;
        int i18 = 0;
        while (z16 && i18 < length) {
            int i19 = i16 - 1;
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) obj, "@", i19, false, 4, (Object) null);
            int i26 = i18;
            int i27 = i3;
            int i28 = length;
            lastIndexOf$default2 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) obj, "\uff20", i19, false, 4, (Object) null);
            int max = Math.max(lastIndexOf$default, lastIndexOf$default2);
            int i29 = i16;
            boolean j3 = j(editable, max, max, i29, com.tencent.qqnt.aio.at.c.class);
            boolean j16 = j(editable, max, max, i29, ReplacementSpan.class);
            if (max != i27 && !j3 && j16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i16 = max;
            } else if (j3) {
                return i27;
            }
            i18 = i26 + 1;
            i17 = max;
            i3 = i27;
            length = i28;
        }
        return i17;
    }

    public final int f(@Nullable Spanned spanned, int start, int end, @NotNull Function1<? super com.tencent.qqnt.aio.at.c, Boolean> matcher) {
        com.tencent.qqnt.aio.at.c[] cVarArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, spanned, Integer.valueOf(start), Integer.valueOf(end), matcher)).intValue();
        }
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        if (spanned == null || (cVarArr = (com.tencent.qqnt.aio.at.c[]) spanned.getSpans(start, end, com.tencent.qqnt.aio.at.c.class)) == null) {
            return 0;
        }
        int i3 = 0;
        for (com.tencent.qqnt.aio.at.c cVar : cVarArr) {
            if (matcher.invoke(cVar).booleanValue()) {
                i3++;
            }
        }
        return i3;
    }

    @NotNull
    public final List<com.tencent.qqnt.aio.at.c> g(@Nullable Spanned spanned, int start, int end, @NotNull Function1<? super com.tencent.qqnt.aio.at.c, Boolean> matcher) {
        List<com.tencent.qqnt.aio.at.c> emptyList;
        com.tencent.qqnt.aio.at.c[] cVarArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, this, spanned, Integer.valueOf(start), Integer.valueOf(end), matcher);
        }
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        if (spanned == null || (cVarArr = (com.tencent.qqnt.aio.at.c[]) spanned.getSpans(start, end, com.tencent.qqnt.aio.at.c.class)) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (com.tencent.qqnt.aio.at.c cVar : cVarArr) {
            if (matcher.invoke(cVar).booleanValue()) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    @NotNull
    public final CharSequence h(@NotNull MemberInfo memberInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this, (Object) memberInfo);
        }
        Intrinsics.checkNotNullParameter(memberInfo, "memberInfo");
        String j3 = com.tencent.mobileqq.aio.utils.d.j(memberInfo, true);
        if (j3 == null) {
            j3 = String.valueOf(memberInfo.uin);
        }
        return IQQTextApi.a.c((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class), j3, 16, 16, null, null, 24, null);
    }

    public final boolean i(@Nullable Spanned spanned, int start, int end, @NotNull Function1<? super com.tencent.qqnt.aio.at.c, Boolean> matcher) {
        com.tencent.qqnt.aio.at.c[] cVarArr;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, spanned, Integer.valueOf(start), Integer.valueOf(end), matcher)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        if (spanned != null && (cVarArr = (com.tencent.qqnt.aio.at.c[]) spanned.getSpans(start, end, com.tencent.qqnt.aio.at.c.class)) != null) {
            int length = cVarArr.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    if (matcher.invoke(cVarArr[i3]).booleanValue()) {
                        z16 = true;
                        break;
                    }
                    i3++;
                } else {
                    z16 = false;
                    break;
                }
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }
}
