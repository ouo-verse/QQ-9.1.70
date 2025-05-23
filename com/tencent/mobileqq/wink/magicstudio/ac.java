package com.tencent.mobileqq.wink.magicstudio;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/ac;", "T", "", "Ljava/util/LinkedList;", "a", "Ljava/util/LinkedList;", "()Ljava/util/LinkedList;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "list", "<init>", "(Ljava/util/List;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ac<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<T> q;

    public ac(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.q = new LinkedList<>();
        Iterator<? extends T> it = list.iterator();
        while (it.hasNext()) {
            this.q.addLast(it.next());
        }
    }

    @NotNull
    public final LinkedList<T> a() {
        return this.q;
    }
}
