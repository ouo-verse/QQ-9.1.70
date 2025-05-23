package com.tencent.mobileqq.wink.editor.music.viewmodel;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/c;", "", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "a", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "c", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "volumeType", "", "b", UserInfo.SEX_FEMALE, "()F", JsonUtils.KEY_BGM, "original", "<init>", "(Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;FF)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MusicVolumeControlViewModel.VolumeType volumeType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float bgm;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float original;

    public c(@NotNull MusicVolumeControlViewModel.VolumeType volumeType, float f16, float f17) {
        Intrinsics.checkNotNullParameter(volumeType, "volumeType");
        this.volumeType = volumeType;
        this.bgm = f16;
        this.original = f17;
    }

    /* renamed from: a, reason: from getter */
    public final float getBgm() {
        return this.bgm;
    }

    /* renamed from: b, reason: from getter */
    public final float getOriginal() {
        return this.original;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final MusicVolumeControlViewModel.VolumeType getVolumeType() {
        return this.volumeType;
    }
}
