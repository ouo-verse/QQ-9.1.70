package com.tme.karaoke.lib_earback;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tme/karaoke/lib_earback/d;", "", "", "on", "Lcom/tme/karaoke/lib_earback/EarBackScene;", "scene", "a", "lib_earback_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes27.dex */
public interface d {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes27.dex */
    public static final class a {
        public static /* synthetic */ boolean a(d dVar, boolean z16, EarBackScene earBackScene, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    earBackScene = EarBackScene.NormalRecord;
                }
                return dVar.a(z16, earBackScene);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: turnEarbackSwitch");
        }
    }

    boolean a(boolean on5, @NotNull EarBackScene scene);
}
