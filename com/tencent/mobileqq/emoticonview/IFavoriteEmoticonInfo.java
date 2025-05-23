package com.tencent.mobileqq.emoticonview;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface IFavoriteEmoticonInfo {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface FavoriteEmoticonType {
        public static final int Emo_Type_Camera = 2;
        public static final int Emo_Type_Lottie = 3;
        public static final int Emo_Type_Market_Face = 1;
        public static final int Emo_Type_Pic = 0;
    }

    String getAction();

    String getEid();

    int getEmoId();

    int getEmoType();

    String getPath();

    String getResID();

    String getRoamingType();

    int getType();

    String getUrl();

    boolean isChecked();

    void setIsChecked(boolean z16);

    void setPath(String str);
}
