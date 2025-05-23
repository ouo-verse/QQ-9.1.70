package com.tencent.mobileqq.troop.selectmember.bean;

import com.tencent.mobileqq.troop.selectmember.bean.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "Lcom/tencent/mobileqq/troop/selectmember/bean/a;", "", "e", "", "select", h.F, "b", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface c extends com.tencent.mobileqq.troop.selectmember.bean.a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class a {
        public static boolean a(@NotNull c cVar, @NotNull com.tencent.mobileqq.troop.selectmember.bean.a bean) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            return a.C8764a.a(cVar, bean);
        }

        public static boolean b(@NotNull c cVar, @NotNull com.tencent.mobileqq.troop.selectmember.bean.a bean) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            return a.C8764a.b(cVar, bean);
        }

        public static boolean c(@NotNull c cVar, boolean z16) {
            return true;
        }
    }

    boolean b();

    @NotNull
    String e();

    boolean h(boolean select);
}
