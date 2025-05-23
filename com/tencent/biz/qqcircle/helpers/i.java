package com.tencent.biz.qqcircle.helpers;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/helpers/i;", "", "", "hashcode", "", "state", "", "c", "", "b", "a", "", "Ljava/util/Map;", "panelStateMap", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f84624a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Integer> panelStateMap = new LinkedHashMap();

    i() {
    }

    public final boolean a(@NotNull String hashcode) {
        int i3;
        Intrinsics.checkNotNullParameter(hashcode, "hashcode");
        Integer num = panelStateMap.get(hashcode);
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            return false;
        }
        return true;
    }

    public final boolean b(@NotNull String hashcode) {
        int i3;
        Intrinsics.checkNotNullParameter(hashcode, "hashcode");
        Integer num = panelStateMap.get(hashcode);
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        if (i3 != 2) {
            return false;
        }
        return true;
    }

    public final void c(@NotNull String hashcode, int state) {
        Intrinsics.checkNotNullParameter(hashcode, "hashcode");
        if (state != 0) {
            panelStateMap.put(hashcode, Integer.valueOf(state));
        } else {
            panelStateMap.remove(hashcode);
        }
    }
}
