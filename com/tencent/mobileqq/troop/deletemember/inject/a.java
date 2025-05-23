package com.tencent.mobileqq.troop.deletemember.inject;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/deletemember/inject/a;", "Ljava/util/Comparator;", "Lcom/tencent/mobileqq/troop/selectmember/bean/a;", "Lkotlin/Comparator;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "info", "", "c", "a", "b", "", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a implements Comparator<com.tencent.mobileqq.troop.selectmember.bean.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f295019d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28539);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f295019d = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int a(char a16, char b16) {
        int i3;
        int i16 = 0;
        if (a16 == b16) {
            return 0;
        }
        if (Character.isLetter(a16)) {
            i3 = 0;
        } else if (Character.isDigit(a16)) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        if (!Character.isLetter(b16)) {
            if (Character.isDigit(b16)) {
                i16 = 1;
            } else {
                i16 = 2;
            }
        }
        if (i3 != i16) {
            return Intrinsics.compare(i3, i16);
        }
        return Intrinsics.compare((int) a16, (int) b16);
    }

    private final char c(TroopMemberInfo info) {
        boolean z16;
        char first;
        char first2;
        String str = info.displayedNamePinyinFirst;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            first2 = StringsKt___StringsKt.first("#");
            return first2;
        }
        String str2 = info.displayedNamePinyinFirst;
        Intrinsics.checkNotNullExpressionValue(str2, "info.displayedNamePinyinFirst");
        String substring = str2.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        first = StringsKt___StringsKt.first(substring);
        return first;
    }

    @Override // java.util.Comparator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compare(@NotNull com.tencent.mobileqq.troop.selectmember.bean.a a16, @NotNull com.tencent.mobileqq.troop.selectmember.bean.a b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) a16, (Object) b16)).intValue();
        }
        Intrinsics.checkNotNullParameter(a16, "a");
        Intrinsics.checkNotNullParameter(b16, "b");
        if ((a16.getItemData() instanceof TroopMemberInfo) && (b16.getItemData() instanceof TroopMemberInfo)) {
            Object itemData = a16.getItemData();
            Intrinsics.checkNotNull(itemData, "null cannot be cast to non-null type com.tencent.mobileqq.data.troop.TroopMemberInfo");
            char c16 = c((TroopMemberInfo) itemData);
            Object itemData2 = b16.getItemData();
            Intrinsics.checkNotNull(itemData2, "null cannot be cast to non-null type com.tencent.mobileqq.data.troop.TroopMemberInfo");
            return a(c16, c((TroopMemberInfo) itemData2));
        }
        return a16.hashCode() - b16.hashCode();
    }
}
