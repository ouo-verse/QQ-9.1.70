package com.tencent.mobileqq.wink.editor.subtitle;

import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.subtitle.source.Subtitle;
import com.tencent.mobileqq.wink.editor.subtitle.source.SubtitleLine;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001JL\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u00022\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00022\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH&JB\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00022\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004H&J0\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\n\u001a\u00020\tH&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/n;", "", "", "Lcom/tencent/mobileqq/wink/editor/subtitle/SubtitlesMapKey;", "", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/SubtitleLine;", "linesMap", "Lcom/tencent/mobileqq/wink/editor/dr;", "tavCut", "", "isBilingual", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "winkStickerModel", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/Subtitle;", "b", "subtitle", "c", "referenceSticker", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface n {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ WinkStickerModel a(n nVar, Subtitle subtitle, dr drVar, WinkStickerModel winkStickerModel, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    winkStickerModel = null;
                }
                if ((i3 & 8) != 0) {
                    z16 = true;
                }
                return nVar.a(subtitle, drVar, winkStickerModel, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: genDefaultSubtitle");
        }

        public static /* synthetic */ Map b(n nVar, Map map, dr drVar, boolean z16, WinkStickerModel winkStickerModel, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                if ((i3 & 8) != 0) {
                    winkStickerModel = null;
                }
                return nVar.b(map, drVar, z16, winkStickerModel);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: genDefaultSubtitles");
        }
    }

    @Nullable
    WinkStickerModel a(@NotNull Subtitle subtitle, @NotNull dr tavCut, @Nullable WinkStickerModel referenceSticker, boolean isBilingual);

    @NotNull
    Map<Subtitle, WinkStickerModel> b(@NotNull Map<SubtitlesMapKey, ? extends List<SubtitleLine>> linesMap, @NotNull dr tavCut, boolean isBilingual, @Nullable WinkStickerModel winkStickerModel);

    @NotNull
    Map<SubtitlesMapKey, List<SubtitleLine>> c(@NotNull Map<SubtitlesMapKey, ? extends List<SubtitleLine>> linesMap, @NotNull List<Subtitle> subtitle);
}
