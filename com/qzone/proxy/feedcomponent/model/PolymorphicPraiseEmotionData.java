package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.s_PolyPraise;
import NS_QMALL_COVER.EmotionPraise;
import com.qzone.proxy.feedcomponent.model.CellDecorateInfo;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.ImageUrl;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes39.dex */
public class PolymorphicPraiseEmotionData implements SmartParcelable {
    private static final String TAG = "PolymorphicPraiseEmotionData";

    @NeedParcel
    public int pokeCombo;

    @NeedParcel
    public String strEmotion;

    @NeedParcel
    public ImageUrl strPraiseImageUrl;

    @NeedParcel
    public ImageUrl strPraiseListImageUrl;

    @NeedParcel
    public int iItemId = -1;

    @NeedParcel
    public String strName = "";

    @NeedParcel
    public String strItemSummary = "";

    @NeedParcel
    public String strPraisePic = "";

    @NeedParcel
    public String strPraiseListPic = "";

    @NeedParcel
    public String strPraiseZip = "";

    public CellDecorateInfo.CellPolymorphicPraise toCellPolymorphicPraise() {
        CellDecorateInfo.CellPolymorphicPraise cellPolymorphicPraise = new CellDecorateInfo.CellPolymorphicPraise();
        cellPolymorphicPraise.iItemId = this.iItemId;
        cellPolymorphicPraise.strPraisePic = this.strPraisePic;
        cellPolymorphicPraise.combo = this.pokeCombo;
        return cellPolymorphicPraise;
    }

    public static ArrayList<PolymorphicPraiseEmotionData> createEmotionDataFromJce(ArrayList<EmotionPraise> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<PolymorphicPraiseEmotionData> arrayList2 = new ArrayList<>();
        Iterator<EmotionPraise> it = arrayList.iterator();
        while (it.hasNext()) {
            EmotionPraise next = it.next();
            PolymorphicPraiseEmotionData polymorphicPraiseEmotionData = new PolymorphicPraiseEmotionData();
            polymorphicPraiseEmotionData.iItemId = next.iItemId;
            polymorphicPraiseEmotionData.strName = next.strName;
            polymorphicPraiseEmotionData.strItemSummary = next.strItemSummary;
            String str = next.strPraisePic;
            polymorphicPraiseEmotionData.strPraisePic = str;
            polymorphicPraiseEmotionData.strPraiseImageUrl = PictureUrl.calculateImageUrl(str);
            String str2 = next.strPraiseListPic;
            polymorphicPraiseEmotionData.strPraiseListPic = str2;
            polymorphicPraiseEmotionData.strPraiseListImageUrl = PictureUrl.calculateImageUrl(str2);
            polymorphicPraiseEmotionData.strPraiseZip = next.strPraiseZip;
            polymorphicPraiseEmotionData.strEmotion = next.strEmotion;
            arrayList2.add(polymorphicPraiseEmotionData);
        }
        return arrayList2;
    }

    public static PolymorphicPraiseEmotionData createFromJce(EmotionPraise emotionPraise) {
        if (emotionPraise == null || emotionPraise.iItemId < 0) {
            return null;
        }
        PolymorphicPraiseEmotionData polymorphicPraiseEmotionData = new PolymorphicPraiseEmotionData();
        polymorphicPraiseEmotionData.iItemId = emotionPraise.iItemId;
        polymorphicPraiseEmotionData.strName = emotionPraise.strName;
        polymorphicPraiseEmotionData.strItemSummary = emotionPraise.strItemSummary;
        String str = emotionPraise.strPraisePic;
        polymorphicPraiseEmotionData.strPraisePic = str;
        polymorphicPraiseEmotionData.strPraiseImageUrl = PictureUrl.calculateImageUrl(str);
        String str2 = emotionPraise.strPraiseListPic;
        polymorphicPraiseEmotionData.strPraiseListPic = str2;
        polymorphicPraiseEmotionData.strPraiseListImageUrl = PictureUrl.calculateImageUrl(str2);
        polymorphicPraiseEmotionData.strPraiseZip = emotionPraise.strPraiseZip;
        polymorphicPraiseEmotionData.strEmotion = emotionPraise.strEmotion;
        return polymorphicPraiseEmotionData;
    }

    public static PolymorphicPraiseEmotionData createFrom(s_PolyPraise s_polypraise) {
        if (s_polypraise == null) {
            return null;
        }
        PolymorphicPraiseEmotionData polymorphicPraiseEmotionData = new PolymorphicPraiseEmotionData();
        polymorphicPraiseEmotionData.iItemId = s_polypraise.iItemId;
        polymorphicPraiseEmotionData.strPraiseListPic = s_polypraise.strPicUrl;
        polymorphicPraiseEmotionData.pokeCombo = s_polypraise.pokeLikeCombo;
        return polymorphicPraiseEmotionData;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PolymorphicPraiseEmotionData)) {
            return false;
        }
        PolymorphicPraiseEmotionData polymorphicPraiseEmotionData = (PolymorphicPraiseEmotionData) obj;
        return polymorphicPraiseEmotionData.iItemId == this.iItemId && (str = polymorphicPraiseEmotionData.strPraiseZip) != null && str.equals(this.strPraiseZip);
    }
}
