package com.tencent.mobileqq.wink.editor.music;

import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0017\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0004J\u0017\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0010\u001a\u00020\u00022\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fJ\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fJ\u0017\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u000eJ\u001c\u0010\u0017\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016J\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/WinkMusicUIData;", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "", "updateInner", "", "enable", "saveOriginalVolumeSwitch", "(Ljava/lang/Boolean;)V", "getIsChangedManually", "saveIsChangedManually", "getOriginalVolumeSwitch", "()Ljava/lang/Boolean;", "", "", "", "mediaClipVolumes", "saveMediaClipVolumes", "getMediaClipVolumes", "float", "saveBGMVolume", "(Ljava/lang/Float;)V", "getBGMVolume", "Lkotlin/Pair;", "saveOriginalVolumeEnable", "getOriginalVolumeEnable", "Lcom/tencent/mobileqq/wink/editor/d;", "part", "<init>", "(Lcom/tencent/mobileqq/wink/editor/d;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMusicUIData extends WinkEditUIData {

    @NotNull
    private static final String BGM_VOLUME = "BGM_VOLUME";

    @NotNull
    private static final String IS_CHANGE_MANUALLY = "IS_CHANGE_MANUALLY";

    @NotNull
    public static final String IS_MUSIC_CLEARED = "IS_MUSIC_CLEARED";

    @NotNull
    private static final String MEDIA_CLIP_VOLUMES = "MEDIA_CLIP_VOLUMES";

    @NotNull
    private static final String ORIGINAL_VOLUME_SWITCH = "ORIGINAL_VOLUME_SWITCH";

    @NotNull
    private static final String ORIGINAL_VOLUME_SWITCH_ENABLE = "ORIGINAL_VOLUME_SWITCH_ENABLE";
    private static final long serialVersionUID = 4207946822293670365L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMusicUIData(@NotNull com.tencent.mobileqq.wink.editor.d part) {
        super(part);
        Intrinsics.checkNotNullParameter(part, "part");
    }

    public final float getBGMVolume() {
        float f16 = getInt(BGM_VOLUME, -1);
        if (f16 > 0.0f) {
            return f16 / 100;
        }
        return f16;
    }

    public final boolean getIsChangedManually() {
        if (getInt(IS_CHANGE_MANUALLY, 1) == 1) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Map<Integer, Float> getMediaClipVolumes() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Serializable serializable = getSerializable(MEDIA_CLIP_VOLUMES, new HashMap());
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type java.util.HashMap<*, *>{ kotlin.collections.TypeAliasesKt.HashMap<*, *> }");
        for (Map.Entry entry : ((HashMap) serializable).entrySet()) {
            Object key = entry.getKey();
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type kotlin.Int");
            Object value = entry.getValue();
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Float");
            linkedHashMap.put((Integer) key, (Float) value);
        }
        return linkedHashMap;
    }

    @Nullable
    public final Pair<Boolean, Boolean> getOriginalVolumeEnable() {
        return (Pair) getSerializable(ORIGINAL_VOLUME_SWITCH_ENABLE, null);
    }

    @Nullable
    public final Boolean getOriginalVolumeSwitch() {
        int i3 = getInt(IS_CHANGE_MANUALLY, -1);
        if (i3 == 1) {
            return Boolean.TRUE;
        }
        if (i3 == 0) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final void saveBGMVolume(@Nullable Float r26) {
        if (r26 != null) {
            r26.floatValue();
            putInt(BGM_VOLUME, (int) (r26.floatValue() * 100));
        }
    }

    public final void saveIsChangedManually(@Nullable Boolean enable) {
        putInt(IS_CHANGE_MANUALLY, Intrinsics.areEqual(enable, Boolean.TRUE) ? 1 : 0);
    }

    public final void saveMediaClipVolumes(@NotNull Map<Integer, Float> mediaClipVolumes) {
        Intrinsics.checkNotNullParameter(mediaClipVolumes, "mediaClipVolumes");
        putSerializable(MEDIA_CLIP_VOLUMES, new HashMap(mediaClipVolumes));
    }

    public final void saveOriginalVolumeEnable(@Nullable Pair<Boolean, Boolean> enable) {
        putSerializable(ORIGINAL_VOLUME_SWITCH_ENABLE, enable);
    }

    public final void saveOriginalVolumeSwitch(@Nullable Boolean enable) {
        putInt(ORIGINAL_VOLUME_SWITCH, Intrinsics.areEqual(enable, Boolean.TRUE) ? 1 : 0);
    }

    @Override // com.tencent.mobileqq.wink.editor.draft.WinkEditUIData
    protected void updateInner() {
    }
}
