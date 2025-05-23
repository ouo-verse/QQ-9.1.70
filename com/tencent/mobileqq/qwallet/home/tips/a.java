package com.tencent.mobileqq.qwallet.home.tips;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\u0014\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/tips/a;", "", "", "a", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "b", "", "list", "", "c", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f278148a = new a();

    a() {
    }

    private final String a() {
        return "bluetips_home_" + com.tencent.mobileqq.base.a.c();
    }

    @NotNull
    public final ArrayList<Integer> b() {
        boolean z16;
        List split$default;
        String i3 = com.tencent.mobileqq.qwallet.utils.g.i(a());
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (i3.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) i3, new String[]{";"}, false, 0, 6, (Object) null);
            if (split$default.isEmpty()) {
                return arrayList;
            }
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                try {
                    int parseInt = Integer.parseInt((String) it.next());
                    if (parseInt != -1) {
                        arrayList.add(Integer.valueOf(parseInt));
                    }
                } catch (Exception e16) {
                    QLog.e("BlueTipsRecord", 1, "", e16);
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public final void c(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (list.isEmpty()) {
            com.tencent.mobileqq.qwallet.utils.g.q(a(), "");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(String.valueOf(it.next().intValue()));
            sb5.append(';');
        }
        String a16 = a();
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sBuilder.toString()");
        com.tencent.mobileqq.qwallet.utils.g.q(a16, sb6);
    }
}
