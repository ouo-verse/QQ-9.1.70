package com.tencent.biz.qqcircle.helpers;

import java.util.HashSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R&\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/helpers/v;", "", "", "hashcode", "", "isShowing", "", "b", "a", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "panelShowingSet", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final v f84667a = new v();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashSet<Integer> panelShowingSet = new HashSet<>();

    v() {
    }

    public final boolean a(int hashcode) {
        return panelShowingSet.contains(Integer.valueOf(hashcode));
    }

    public final void b(int hashcode, boolean isShowing) {
        if (isShowing) {
            panelShowingSet.add(Integer.valueOf(hashcode));
        } else {
            panelShowingSet.remove(Integer.valueOf(hashcode));
        }
    }
}
