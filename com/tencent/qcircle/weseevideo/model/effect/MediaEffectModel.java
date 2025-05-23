package com.tencent.qcircle.weseevideo.model.effect;

import com.tencent.qcircle.tavcut.aekit.AEKitModel;
import com.tencent.qcircle.tavcut.aekit.PreSegModel;
import com.tencent.qcircle.weseevideo.model.BaseMediaModel;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K\u00a8\u0006L"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/effect/MediaEffectModel;", "Lcom/tencent/qcircle/weseevideo/model/BaseMediaModel;", "()V", "aeKitModel", "Lcom/tencent/qcircle/tavcut/aekit/AEKitModel;", "getAeKitModel", "()Lcom/tencent/qcircle/tavcut/aekit/AEKitModel;", "setAeKitModel", "(Lcom/tencent/qcircle/tavcut/aekit/AEKitModel;)V", "beautyModel", "Lcom/tencent/qcircle/weseevideo/model/effect/BeautyModel;", "getBeautyModel", "()Lcom/tencent/qcircle/weseevideo/model/effect/BeautyModel;", "setBeautyModel", "(Lcom/tencent/qcircle/weseevideo/model/effect/BeautyModel;)V", "cropModel", "Lcom/tencent/qcircle/weseevideo/model/effect/CropModel;", "getCropModel", "()Lcom/tencent/qcircle/weseevideo/model/effect/CropModel;", "setCropModel", "(Lcom/tencent/qcircle/weseevideo/model/effect/CropModel;)V", "gestureModel", "Lcom/tencent/qcircle/weseevideo/model/effect/GestureModel;", "getGestureModel", "()Lcom/tencent/qcircle/weseevideo/model/effect/GestureModel;", "setGestureModel", "(Lcom/tencent/qcircle/weseevideo/model/effect/GestureModel;)V", "lutModel", "Lcom/tencent/qcircle/weseevideo/model/effect/LutModel;", "getLutModel", "()Lcom/tencent/qcircle/weseevideo/model/effect/LutModel;", "setLutModel", "(Lcom/tencent/qcircle/weseevideo/model/effect/LutModel;)V", "musicModel", "Lcom/tencent/qcircle/weseevideo/model/effect/MusicModel;", "getMusicModel", "()Lcom/tencent/qcircle/weseevideo/model/effect/MusicModel;", "setMusicModel", "(Lcom/tencent/qcircle/weseevideo/model/effect/MusicModel;)V", "preSegModel", "Lcom/tencent/qcircle/tavcut/aekit/PreSegModel;", "getPreSegModel", "()Lcom/tencent/qcircle/tavcut/aekit/PreSegModel;", "setPreSegModel", "(Lcom/tencent/qcircle/tavcut/aekit/PreSegModel;)V", "stickerModelList", "", "Lcom/tencent/qcircle/weseevideo/model/effect/StickerModel;", "getStickerModelList", "()Ljava/util/List;", "setStickerModelList", "(Ljava/util/List;)V", "subtitleModel", "Lcom/tencent/qcircle/weseevideo/model/effect/SubtitleModel;", "getSubtitleModel", "()Lcom/tencent/qcircle/weseevideo/model/effect/SubtitleModel;", "setSubtitleModel", "(Lcom/tencent/qcircle/weseevideo/model/effect/SubtitleModel;)V", "videoBeginModel", "Lcom/tencent/qcircle/weseevideo/model/effect/VideoBeginModel;", "getVideoBeginModel", "()Lcom/tencent/qcircle/weseevideo/model/effect/VideoBeginModel;", "setVideoBeginModel", "(Lcom/tencent/qcircle/weseevideo/model/effect/VideoBeginModel;)V", "videoEndModel", "Lcom/tencent/qcircle/weseevideo/model/effect/VideoEndModel;", "getVideoEndModel", "()Lcom/tencent/qcircle/weseevideo/model/effect/VideoEndModel;", "setVideoEndModel", "(Lcom/tencent/qcircle/weseevideo/model/effect/VideoEndModel;)V", "videoFenWeiModel", "Lcom/tencent/qcircle/weseevideo/model/effect/VideoFenWeiModel;", "getVideoFenWeiModel", "()Lcom/tencent/qcircle/weseevideo/model/effect/VideoFenWeiModel;", "setVideoFenWeiModel", "(Lcom/tencent/qcircle/weseevideo/model/effect/VideoFenWeiModel;)V", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class MediaEffectModel extends BaseMediaModel {

    @Nullable
    private AEKitModel aeKitModel;

    @Nullable
    private BeautyModel beautyModel;

    @Nullable
    private CropModel cropModel;

    @Nullable
    private LutModel lutModel;

    @Nullable
    private PreSegModel preSegModel;

    @Nullable
    private SubtitleModel subtitleModel;

    @Nullable
    private VideoBeginModel videoBeginModel;

    @Nullable
    private VideoEndModel videoEndModel;

    @Nullable
    private VideoFenWeiModel videoFenWeiModel;

    @NotNull
    private List<? extends StickerModel> stickerModelList = new CopyOnWriteArrayList();

    @NotNull
    private MusicModel musicModel = new MusicModel();

    @NotNull
    private GestureModel gestureModel = new GestureModel();

    @Nullable
    public final AEKitModel getAeKitModel() {
        return this.aeKitModel;
    }

    @Nullable
    public final BeautyModel getBeautyModel() {
        return this.beautyModel;
    }

    @Nullable
    public final CropModel getCropModel() {
        return this.cropModel;
    }

    @NotNull
    public final GestureModel getGestureModel() {
        return this.gestureModel;
    }

    @Nullable
    public final LutModel getLutModel() {
        return this.lutModel;
    }

    @NotNull
    public final MusicModel getMusicModel() {
        return this.musicModel;
    }

    @Nullable
    public final PreSegModel getPreSegModel() {
        return this.preSegModel;
    }

    @NotNull
    public final List<StickerModel> getStickerModelList() {
        return this.stickerModelList;
    }

    @Nullable
    public final SubtitleModel getSubtitleModel() {
        return this.subtitleModel;
    }

    @Nullable
    public final VideoBeginModel getVideoBeginModel() {
        return this.videoBeginModel;
    }

    @Nullable
    public final VideoEndModel getVideoEndModel() {
        return this.videoEndModel;
    }

    @Nullable
    public final VideoFenWeiModel getVideoFenWeiModel() {
        return this.videoFenWeiModel;
    }

    public final void setAeKitModel(@Nullable AEKitModel aEKitModel) {
        this.aeKitModel = aEKitModel;
    }

    public final void setBeautyModel(@Nullable BeautyModel beautyModel) {
        this.beautyModel = beautyModel;
    }

    public final void setCropModel(@Nullable CropModel cropModel) {
        this.cropModel = cropModel;
    }

    public final void setGestureModel(@NotNull GestureModel gestureModel) {
        Intrinsics.checkParameterIsNotNull(gestureModel, "<set-?>");
        this.gestureModel = gestureModel;
    }

    public final void setLutModel(@Nullable LutModel lutModel) {
        this.lutModel = lutModel;
    }

    public final void setMusicModel(@NotNull MusicModel musicModel) {
        Intrinsics.checkParameterIsNotNull(musicModel, "<set-?>");
        this.musicModel = musicModel;
    }

    public final void setPreSegModel(@Nullable PreSegModel preSegModel) {
        this.preSegModel = preSegModel;
    }

    public final void setStickerModelList(@NotNull List<? extends StickerModel> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.stickerModelList = list;
    }

    public final void setSubtitleModel(@Nullable SubtitleModel subtitleModel) {
        this.subtitleModel = subtitleModel;
    }

    public final void setVideoBeginModel(@Nullable VideoBeginModel videoBeginModel) {
        this.videoBeginModel = videoBeginModel;
    }

    public final void setVideoEndModel(@Nullable VideoEndModel videoEndModel) {
        this.videoEndModel = videoEndModel;
    }

    public final void setVideoFenWeiModel(@Nullable VideoFenWeiModel videoFenWeiModel) {
        this.videoFenWeiModel = videoFenWeiModel;
    }
}
