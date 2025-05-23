package com.tencent.tavcut.core.operator;

import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH&J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH&J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&J&\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/tavcut/core/operator/IClipSourceOperator;", "", "Lcom/tencent/tavcut/core/operator/b;", "iStrategy", "", h.F, "", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "clipSources", "", "g", "", "index", "d", "fromIndex", "toIndex", "c", "a", "Lorg/light/lightAssetKit/Entity;", "entity", "addClipEffect", "updateSources", "e", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "setOriginVolumeForClip", "InvalidStatus", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public interface IClipSourceOperator {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/tavcut/core/operator/IClipSourceOperator$InvalidStatus;", "", "(Ljava/lang/String;I)V", "ADD_INVALID_INDEX", "REMOVE_INVALID_INDEX", "REPLACE_INVALID_INDEX", "SPLIT_INVALID_INDEX", "ADJUST_SPEED_INVALID_INDEX", "REORDER_INVALID_INDEX", "COPY_INVALID_INDEX", "ADJUST_TIMERANGE_INVALID_INDEX", "DELETE_LIMIT", "SPLIT_LIMIT", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public enum InvalidStatus {
        ADD_INVALID_INDEX,
        REMOVE_INVALID_INDEX,
        REPLACE_INVALID_INDEX,
        SPLIT_INVALID_INDEX,
        ADJUST_SPEED_INVALID_INDEX,
        REORDER_INVALID_INDEX,
        COPY_INVALID_INDEX,
        ADJUST_TIMERANGE_INVALID_INDEX,
        DELETE_LIMIT,
        SPLIT_LIMIT
    }

    @Nullable
    ClipSource a(int fromIndex, int toIndex);

    void addClipEffect(@NotNull Entity entity);

    void c(int fromIndex, int toIndex);

    boolean d(int index, @NotNull List<ClipSource> clipSources);

    @Nullable
    List<ClipSource> e(int index, @NotNull List<ClipSource> updateSources);

    boolean g(@NotNull List<ClipSource> clipSources);

    void h(@NotNull b iStrategy);

    void setOriginVolumeForClip(int index, float volume);
}
