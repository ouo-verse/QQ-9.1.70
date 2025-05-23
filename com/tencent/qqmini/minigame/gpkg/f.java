package com.tencent.qqmini.minigame.gpkg;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005R0\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0011`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqmini/minigame/gpkg/f;", "", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "miniAppInfo", "", "", "Lcom/tencent/qqmini/minigame/gpkg/SubPkgInfoWrapper;", "pkgInfoMap", "", "b", "nameOrRoot", "Lcom/tencent/qqmini/minigame/gpkg/g;", "loadListener", "c", "name", "a", "Ljava/util/HashMap;", "Lcom/tencent/qqmini/minigame/gpkg/e;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "name2subPkgLoaderMap", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, e> name2subPkgLoaderMap = new HashMap<>();

    @NotNull
    public final String a(@Nullable String name) {
        boolean z16;
        e eVar;
        SubPkgInfoWrapper subPkgInfoWrapper;
        String root;
        if (name != null && name.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || (eVar = this.name2subPkgLoaderMap.get(name)) == null || (subPkgInfoWrapper = eVar.getSubPkgInfoWrapper()) == null || (root = subPkgInfoWrapper.getRoot()) == null) {
            return "";
        }
        return root;
    }

    public final void b(@NotNull MiniAppInfo miniAppInfo, @NotNull Map<String, SubPkgInfoWrapper> pkgInfoMap) {
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        Intrinsics.checkParameterIsNotNull(pkgInfoMap, "pkgInfoMap");
        this.name2subPkgLoaderMap.clear();
        for (Map.Entry<String, SubPkgInfoWrapper> entry : pkgInfoMap.entrySet()) {
            this.name2subPkgLoaderMap.put(entry.getKey(), new e(miniAppInfo, entry.getValue()));
        }
    }

    public final void c(@NotNull String nameOrRoot, @NotNull g loadListener) {
        Intrinsics.checkParameterIsNotNull(nameOrRoot, "nameOrRoot");
        Intrinsics.checkParameterIsNotNull(loadListener, "loadListener");
        QMLog.d("GameSubPkgManager", "loadSubPackage begin, name=" + nameOrRoot);
        e eVar = this.name2subPkgLoaderMap.get(nameOrRoot);
        if (eVar != null) {
            eVar.b(loadListener);
            return;
        }
        for (Map.Entry<String, e> entry : this.name2subPkgLoaderMap.entrySet()) {
            if (Intrinsics.areEqual(entry.getValue().getSubPkgInfoWrapper().getRoot(), nameOrRoot)) {
                entry.getValue().b(loadListener);
                return;
            }
        }
        loadListener.onFail("subPkg not exists, name=" + nameOrRoot);
        QMLog.e("GameSubPkgManager", "loadSubPackage: subPkg not exists, name=" + nameOrRoot);
    }
}
