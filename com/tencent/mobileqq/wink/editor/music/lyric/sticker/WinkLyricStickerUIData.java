package com.tencent.mobileqq.wink.editor.music.lyric.sticker;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import d73.LyricSticker;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\n\u001a\u00020\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/WinkLyricStickerUIData;", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getMaterialFromDraft", "createEmptyMaterial", "", "updateInner", "Ld73/d;", "lyricSticker", "saveUIDraft", "getUIDraft", "Lcom/tencent/mobileqq/wink/editor/d;", "part", "<init>", "(Lcom/tencent/mobileqq/wink/editor/d;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkLyricStickerUIData extends WinkEditUIData {

    @NotNull
    private static final String LYRIC_MEDIA_DURATION = "LYRIC_MEDIA_DURATION";

    @NotNull
    private static final String LYRIC_STYLE_ID = "LYRIC_STYLE_ID";

    @NotNull
    private static final String MATERIAL_ID = "LYRIC_STICKER_MATERIAL_ID";

    @NotNull
    private static final String TAG = "WinkLyricStickerUIData";

    @NotNull
    private static final String TEMPLATE_PATH = "LYRIC_STICKER_TEMPLATE_PATH";
    private static final long serialVersionUID = 5751681975944653195L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkLyricStickerUIData(@NotNull com.tencent.mobileqq.wink.editor.d part) {
        super(part);
        Intrinsics.checkNotNullParameter(part, "part");
    }

    private final MetaMaterial createEmptyMaterial() {
        MetaMaterial metaMaterial = new MetaMaterial();
        metaMaterial.f30533id = "no_lyrics";
        metaMaterial.additionalFields = new HashMap();
        return metaMaterial;
    }

    private final MetaMaterial getMaterialFromDraft() {
        Serializable serializable = getSerializable(MATERIAL_ID, null);
        if (serializable != null && (serializable instanceof MetaMaterial)) {
            return (MetaMaterial) serializable;
        }
        return createEmptyMaterial();
    }

    @NotNull
    public final LyricSticker getUIDraft() {
        String str;
        LyricSticker lyricSticker = new LyricSticker(null, 0L, null, null, 0L, 0L, 0L, null, false, null, null, null, 4095, null);
        lyricSticker.p(getMaterialFromDraft());
        lyricSticker.x(getString(TEMPLATE_PATH, ""));
        lyricSticker.w(getString(LYRIC_STYLE_ID, ""));
        String mediaDurationUsString = getString(LYRIC_MEDIA_DURATION, "0");
        Intrinsics.checkNotNullExpressionValue(mediaDurationUsString, "mediaDurationUsString");
        lyricSticker.q(Long.parseLong(mediaDurationUsString));
        MetaMaterial material = lyricSticker.getMaterial();
        if (material != null) {
            str = material.f30533id;
        } else {
            str = null;
        }
        w53.b.a(TAG, "restore UIDraft materialId:" + str + " templatePath:" + lyricSticker.getTemplatePath() + ", templateLyricStyleId " + lyricSticker.getTemplateLyricStyleId());
        return lyricSticker;
    }

    public final void saveUIDraft(@Nullable LyricSticker lyricSticker) {
        String str;
        String str2;
        String str3;
        MetaMaterial createEmptyMaterial;
        String str4;
        Long l3;
        String templateLyricStyleId;
        MetaMaterial material;
        Long l16 = null;
        if (lyricSticker != null && (material = lyricSticker.getMaterial()) != null) {
            str = material.f30533id;
        } else {
            str = null;
        }
        if (lyricSticker != null) {
            str2 = lyricSticker.getTemplatePath();
        } else {
            str2 = null;
        }
        if (lyricSticker != null) {
            str3 = lyricSticker.getTemplateLyricStyleId();
        } else {
            str3 = null;
        }
        w53.b.a(TAG, "save UIDraft materialId:" + str + " templatePath:" + str2 + ", templateLyricStyleId " + str3);
        if (lyricSticker == null || (createEmptyMaterial = lyricSticker.getMaterial()) == null) {
            createEmptyMaterial = createEmptyMaterial();
        }
        putSerializable(MATERIAL_ID, createEmptyMaterial);
        String str5 = "";
        if (lyricSticker == null || (str4 = lyricSticker.getTemplatePath()) == null) {
            str4 = "";
        }
        putString(TEMPLATE_PATH, str4);
        if (lyricSticker != null && (templateLyricStyleId = lyricSticker.getTemplateLyricStyleId()) != null) {
            str5 = templateLyricStyleId;
        }
        putString(LYRIC_STYLE_ID, str5);
        if (lyricSticker != null) {
            l3 = Long.valueOf(lyricSticker.getMediaDurationUs());
        } else {
            l3 = null;
        }
        if (l3 != null) {
            if (lyricSticker != null) {
                l16 = Long.valueOf(lyricSticker.getMediaDurationUs());
            }
            putString(LYRIC_MEDIA_DURATION, String.valueOf(l16));
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.draft.WinkEditUIData
    protected void updateInner() {
    }
}
