package com.tencent.qqnt.avatar.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.avatar.layer.d;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0014\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00030\u0002\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\u000f\u0010\u0010R%\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/avatar/core/c;", "", "", "Lcom/tencent/qqnt/avatar/layer/d;", "a", "Ljava/util/List;", "()Ljava/util/List;", "layerList", "", "", "b", "Ljava/util/Map;", "getLayerStateMap", "()Ljava/util/Map;", "layerStateMap", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<d<? extends Object>> layerList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, Integer> layerStateMap;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull List<? extends d<? extends Object>> layerList, @NotNull Map<Integer, Integer> layerStateMap) {
        Intrinsics.checkNotNullParameter(layerList, "layerList");
        Intrinsics.checkNotNullParameter(layerStateMap, "layerStateMap");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) layerList, (Object) layerStateMap);
        } else {
            this.layerList = layerList;
            this.layerStateMap = layerStateMap;
        }
    }

    @NotNull
    public final List<d<? extends Object>> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.layerList;
    }
}
