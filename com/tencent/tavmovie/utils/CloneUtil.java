package com.tencent.tavmovie.utils;

import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavmovie.sticker.TAVMovieStickerTextItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CloneUtil {
    public static List<Map<String, Object>> cloneMapDatas(List<Map<String, Object>> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map<String, Object> map : list) {
            if (map != null) {
                arrayList.add(new HashMap(map));
            }
        }
        return arrayList;
    }

    public static List<TAVMovieClip> cloneMovieClips(List<TAVMovieClip> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TAVMovieClip tAVMovieClip : list) {
            if (tAVMovieClip != null) {
                arrayList.add(tAVMovieClip.m275clone());
            }
        }
        return arrayList;
    }

    public static List<TAVMovieStickerTextItem> cloneMovieStickerTextItems(List<TAVMovieStickerTextItem> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TAVMovieStickerTextItem tAVMovieStickerTextItem : list) {
            if (tAVMovieStickerTextItem != null) {
                arrayList.add(tAVMovieStickerTextItem.m282clone());
            }
        }
        return arrayList;
    }

    public static List<TAVMovieTimeEffect> cloneMovieTimeEffects(List<TAVMovieTimeEffect> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TAVMovieTimeEffect tAVMovieTimeEffect : list) {
            if (tAVMovieTimeEffect != null) {
                arrayList.add(tAVMovieTimeEffect.m276clone());
            }
        }
        return arrayList;
    }

    public static List<TAVClip> cloneTAVClips(List<TAVClip> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TAVClip tAVClip : list) {
            if (tAVClip != null) {
                arrayList.add(tAVClip.m268clone());
            }
        }
        return arrayList;
    }

    public static List<TAVMovieSticker> cloneTemplateStickers(List<TAVMovieSticker> list) {
        if (list == null) {
            return null;
        }
        ArrayList<TAVMovieSticker> arrayList = new ArrayList();
        for (TAVMovieSticker tAVMovieSticker : arrayList) {
            if (tAVMovieSticker != null) {
                arrayList.add(tAVMovieSticker.m281clone());
            }
        }
        return arrayList;
    }
}
