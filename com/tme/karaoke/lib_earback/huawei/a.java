package com.tme.karaoke.lib_earback.huawei;

import com.tme.karaoke.lib_earback.EarBackModule;
import com.tme.karaoke.lib_earback.EarBackScene;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tme/karaoke/lib_earback/huawei/a;", "Lcom/tme/karaoke/lib_earback/d;", "", "on", "Lcom/tme/karaoke/lib_earback/EarBackScene;", "scene", "a", "", "d", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getHwapiAbove26EarBackAndForceAudioRecorder", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setHwapiAbove26EarBackAndForceAudioRecorder", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "hwapiAbove26EarBackAndForceAudioRecorder", "Lcom/tme/karaoke/lib_earback/EarBackModule;", "f", "Lcom/tme/karaoke/lib_earback/EarBackModule;", "getEarBackModule", "()Lcom/tme/karaoke/lib_earback/EarBackModule;", "earBackModule", "<init>", "(Lcom/tme/karaoke/lib_earback/EarBackModule;)V", "lib_earback_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes27.dex */
public final class a implements com.tme.karaoke.lib_earback.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean hwapiAbove26EarBackAndForceAudioRecorder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EarBackModule earBackModule;

    public a(@NotNull EarBackModule earBackModule) {
        Intrinsics.checkParameterIsNotNull(earBackModule, "earBackModule");
        this.earBackModule = earBackModule;
        this.TAG = "HWAPIAbove26EarBack";
        this.hwapiAbove26EarBackAndForceAudioRecorder = new AtomicBoolean(false);
    }

    @Override // com.tme.karaoke.lib_earback.d
    public boolean a(boolean on5, @NotNull EarBackScene scene) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        return false;
    }
}
