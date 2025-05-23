package com.tencent.mobileqq.troop.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.MemberLevelName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/util/b;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberLevelName;", "levelMap", "", "a", "levelMapStr", "b", "<init>", "()V", "imcore-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f301848a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35564);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f301848a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a(@NotNull List<MemberLevelName> levelMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) levelMap);
        }
        Intrinsics.checkNotNullParameter(levelMap, "levelMap");
        StringBuilder sb5 = new StringBuilder();
        for (MemberLevelName memberLevelName : levelMap) {
            sb5.append(memberLevelName.level);
            sb5.append("\u0000");
            sb5.append(memberLevelName.strName);
            sb5.append("\u0001");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "builder.toString()");
        return sb6;
    }

    @Nullable
    public final List<MemberLevelName> b(@Nullable String levelMapStr) {
        boolean z16;
        List emptyList;
        List emptyList2;
        Integer intOrNull;
        int i3;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) levelMapStr);
        }
        if (levelMapStr != null && levelMapStr.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<String> split = new Regex("\u0001").split(levelMapStr, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18) {
                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Iterator it = emptyList.iterator();
        while (it.hasNext()) {
            List<String> split2 = new Regex("\u0000").split((String) it.next(), 0);
            if (!split2.isEmpty()) {
                ListIterator<String> listIterator2 = split2.listIterator(split2.size());
                while (listIterator2.hasPrevious()) {
                    if (listIterator2.previous().length() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        emptyList2 = CollectionsKt___CollectionsKt.take(split2, listIterator2.nextIndex() + 1);
                        break;
                    }
                }
            }
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            if (emptyList2.size() == 2) {
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) emptyList2.get(0));
                if (intOrNull != null) {
                    i3 = intOrNull.intValue();
                } else {
                    i3 = 0;
                }
                String str = (String) emptyList2.get(1);
                MemberLevelName memberLevelName = new MemberLevelName();
                memberLevelName.level = i3;
                memberLevelName.strName = str;
                arrayList.add(memberLevelName);
            }
        }
        return arrayList;
    }
}
