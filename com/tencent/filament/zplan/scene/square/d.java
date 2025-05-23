package com.tencent.filament.zplan.scene.square;

import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0001H&J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H&J&\u0010\u0018\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\u0014\u0010\u001b\u001a\u00020\n2\n\u0010\u001a\u001a\u00060\u0002j\u0002`\u0019H&J\b\u0010\u001c\u001a\u00020\u0005H&J\b\u0010\u001d\u001a\u00020\u0005H&J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0002H&\u00a8\u0006 "}, d2 = {"Lcom/tencent/filament/zplan/scene/square/d;", "", "", "Lcom/tencent/filament/zplan/scene/square/EngineTime;", "nowTime", "", "c", "play", "stop", "reset", "", NodeProps.VISIBLE, "setVisibility", "resource", "f", "Lcom/tencent/filament/zplan/scene/square/Location;", "location", "durationMs", "d", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarAnim;", "hostAnim", "guestAnim", "", "extraAnimGltf", "b", "Lcom/tencent/filament/zplan/engine/RenderObjectId;", "renderObjectId", "g", "e", "destroy", "frameId", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface d {
    void a(long frameId);

    void b(@Nullable SquareAvatarData.AvatarAnim hostAnim, @Nullable SquareAvatarData.AvatarAnim guestAnim, @Nullable String extraAnimGltf);

    void c(long nowTime);

    void d(@NotNull Location location, long durationMs);

    void destroy();

    void e();

    void f(@NotNull Object resource);

    boolean g(long renderObjectId);

    void play();

    void reset();

    void setVisibility(boolean visible);

    void stop();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a {
        public static void b(@NotNull d dVar) {
        }

        public static void c(@NotNull d dVar) {
        }

        public static void d(@NotNull d dVar) {
        }

        public static void a(@NotNull d dVar, long j3) {
        }
    }
}
