package com.tencent.biz.qqcircle.immersive.utils;

import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/am;", "", "Lcom/tencent/biz/qqcircle/immersive/personal/bean/QFSPersonalInfo;", "qfsPersonalInfo", "", "d", "b", "c", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class am {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final am f90129a = new am();

    am() {
    }

    public final boolean a(@NotNull QFSPersonalInfo qfsPersonalInfo) {
        Intrinsics.checkNotNullParameter(qfsPersonalInfo, "qfsPersonalInfo");
        if (qfsPersonalInfo.j() != null && qfsPersonalInfo.j().a().size() > 0) {
            return true;
        }
        return false;
    }

    public final boolean b(@NotNull QFSPersonalInfo qfsPersonalInfo) {
        Intrinsics.checkNotNullParameter(qfsPersonalInfo, "qfsPersonalInfo");
        if (a(qfsPersonalInfo) || qfsPersonalInfo.f88438y != 3) {
            return false;
        }
        if (uq3.k.a().c("has_show_material_guide_banner" + qfsPersonalInfo.E, false)) {
            return false;
        }
        return true;
    }

    public final boolean c(@NotNull QFSPersonalInfo qfsPersonalInfo) {
        Intrinsics.checkNotNullParameter(qfsPersonalInfo, "qfsPersonalInfo");
        if (qfsPersonalInfo.f88438y == 1) {
            return true;
        }
        return false;
    }

    public final boolean d(@NotNull QFSPersonalInfo qfsPersonalInfo) {
        Intrinsics.checkNotNullParameter(qfsPersonalInfo, "qfsPersonalInfo");
        if (!b(qfsPersonalInfo) && !c(qfsPersonalInfo)) {
            return true;
        }
        return false;
    }
}
