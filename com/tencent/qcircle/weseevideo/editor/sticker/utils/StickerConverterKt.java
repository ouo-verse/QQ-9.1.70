package com.tencent.qcircle.weseevideo.editor.sticker.utils;

import com.tencent.qcircle.weseevideo.editor.sticker.music.WSLyricSticker;
import com.tencent.qcircle.weseevideo.model.constants.MusicConstants;
import com.tencent.qcircle.weseevideo.model.effect.SubtitleModel;
import com.tencent.tavsticker.model.TAVSticker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"convert2TavSticker", "Lcom/tencent/tavsticker/model/TAVSticker;", "Lcom/tencent/qcircle/weseevideo/model/effect/SubtitleModel;", "libtavcut_debug"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class StickerConverterKt {
    @Nullable
    public static final TAVSticker convert2TavSticker(@NotNull SubtitleModel convert2TavSticker) {
        Intrinsics.checkParameterIsNotNull(convert2TavSticker, "$this$convert2TavSticker");
        if (Intrinsics.areEqual(convert2TavSticker.getEffectId(), MusicConstants.NO_LYRIC_ID)) {
            return null;
        }
        WSLyricSticker wSLyricSticker = new WSLyricSticker();
        wSLyricSticker.reloadFromSubtitleModel(convert2TavSticker);
        return wSLyricSticker;
    }
}
