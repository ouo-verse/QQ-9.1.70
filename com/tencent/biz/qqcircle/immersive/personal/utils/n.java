package com.tencent.biz.qqcircle.immersive.personal.utils;

import com.tencent.biz.qqcircle.events.QCircleShowSettingEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0003J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003J&\u0010\r\u001a\u00020\f2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/utils/n;", "", "", "", "opMask", "mask", "", "a", "b", "", "code", "show", "", "c", "Ljava/util/List;", "notShowOpMaskList", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f89104a = new n();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Integer> notShowOpMaskList;

    static {
        ArrayList arrayList = new ArrayList();
        notShowOpMaskList = arrayList;
        arrayList.add(9);
        arrayList.add(19);
        arrayList.add(6);
        arrayList.add(8);
        arrayList.add(10);
        arrayList.add(15);
    }

    n() {
    }

    public final boolean a(@NotNull List<Integer> opMask, int mask) {
        Intrinsics.checkNotNullParameter(opMask, "opMask");
        if (b(mask)) {
            if (!opMask.contains(Integer.valueOf(mask))) {
                return true;
            }
            return false;
        }
        return opMask.contains(Integer.valueOf(mask));
    }

    public final boolean b(int mask) {
        return notShowOpMaskList.contains(Integer.valueOf(mask));
    }

    public final void c(@Nullable List<Integer> opMask, int code, boolean show) {
        if (opMask == null) {
            SimpleEventBus.getInstance().dispatchEvent(new QCircleShowSettingEvent(code, show));
            return;
        }
        if (b(code)) {
            if (!show) {
                show = true;
            } else {
                show = false;
            }
        }
        if (show) {
            opMask.add(Integer.valueOf(code));
        } else {
            opMask.remove(Integer.valueOf(code));
        }
    }
}
