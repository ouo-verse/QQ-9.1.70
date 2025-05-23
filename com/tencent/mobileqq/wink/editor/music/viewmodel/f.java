package com.tencent.mobileqq.wink.editor.music.viewmodel;

import android.media.AudioManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.security.InvalidParameterException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J)\u0010\b\u001a\u00028\u0000\"\n\b\u0000\u0010\u0005*\u0004\u0018\u00010\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/f;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/a;", "a", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Landroid/media/AudioManager;", "Landroid/media/AudioManager;", "getAm", "()Landroid/media/AudioManager;", "am", "Lcom/tencent/mobileqq/wink/editor/music/vo/Scene;", "b", "Lcom/tencent/mobileqq/wink/editor/music/vo/Scene;", "getScene", "()Lcom/tencent/mobileqq/wink/editor/music/vo/Scene;", "scene", "<init>", "(Landroid/media/AudioManager;Lcom/tencent/mobileqq/wink/editor/music/vo/Scene;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class f implements ViewModelProvider.Factory {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AudioManager am;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Scene scene;

    public f(@NotNull AudioManager am5, @NotNull Scene scene) {
        Intrinsics.checkNotNullParameter(am5, "am");
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.am = am5;
        this.scene = scene;
    }

    private final a a() {
        Scene scene = this.scene;
        if (scene == Scene.CAMERA) {
            return new MusicPlayerViewModel(this.am);
        }
        if (scene == Scene.EDIT) {
            return new d();
        }
        throw new InvalidParameterException("Invalid scene");
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (a.class.isAssignableFrom(modelClass)) {
            return a();
        }
        throw new InvalidParameterException("Can not found " + modelClass);
    }
}
