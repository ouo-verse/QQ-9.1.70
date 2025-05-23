package com.tencent.mobileqq.winkreport.datong;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes21.dex */
public class WinkPublishMediaRecord implements Serializable, Parcelable {
    public static final Parcelable.Creator<WinkPublishMediaRecord> CREATOR = new a();
    public static final String QZONE_MAGIC_STUDIO_AGAIN_GENERATE = "xsj_again_generate";
    public static final String QZONE_MAGIC_STUDIO_GENERATE_EFFECT = "xsj_generate_effect";
    public static final String QZONE_MAGIC_STUDIO_GENERATE_EFFECT_SEPARATOR = "&&&";
    public static final String QZONE_MAGIC_STUDIO_TAB = "publish_material_tab";
    public static final String QZONE_PUBLISH_MATERIAL_ID = "publish_material_id";
    public static final String QZONE_PUBLISH_MATERIAL_NAME = "publish_material_name";
    public static final String QZONE_PUBLISH_STYLE_ID = "publish_style_id";
    public static final String QZONE_PUBLISH_TYPE = "publish_material_type";
    public static final String WINK_EDITOR_MAGIC_STUDIO = "editorMagicStudio";
    public static final String WINK_REPORT_TYPE_ACTIVITY = "activity";
    public static final String WINK_REPORT_TYPE_AI_AVATAR = "AIAvatar";
    public static final String WINK_REPORT_TYPE_DAILY_SIGN = "dailySign";
    public static final String WINK_REPORT_TYPE_FILTER = "filter";
    public static final String WINK_REPORT_TYPE_FILTER_SCOPE = "filter_scope";
    public static final String WINK_REPORT_TYPE_IMAGE_TEMPLATE = "imageTemplate";
    public static final String WINK_REPORT_TYPE_LIB_TEMPLATE = "libTemplate";
    public static final String WINK_REPORT_TYPE_MAGIC_STUDIO = "magicStudio";
    public static final String WINK_REPORT_TYPE_MATERIAL = "meterial";
    public static final String WINK_REPORT_TYPE_MUSIC = "music";
    public static final String WINK_REPORT_TYPE_SHARE_FROM = "share";
    public static final String WINK_REPORT_TYPE_STICKER = "sticker";
    public static final String WINK_REPORT_TYPE_TEMPLATE = "template";
    public static final String WINK_REPORT_TYPE_TEXT = "text";
    public static final String WINK_REPORT_TYPE_TTS_NAME = "tts_name";
    public static final String WINK_REPORT_TYPE_TTS_VOLUME = "tts_volume";
    public static final String WINK_REPORT_TYPE_ZSHOW = "zshow";
    public List<String> mediaId;
    public String mediaType;

    /* loaded from: classes21.dex */
    class a implements Parcelable.Creator<WinkPublishMediaRecord> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WinkPublishMediaRecord createFromParcel(Parcel parcel) {
            return new WinkPublishMediaRecord(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WinkPublishMediaRecord[] newArray(int i3) {
            return new WinkPublishMediaRecord[i3];
        }
    }

    public WinkPublishMediaRecord(String str, List<String> list) {
        this.mediaId = list;
        this.mediaType = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMediaIdStr() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        List<String> list = this.mediaId;
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < this.mediaId.size(); i3++) {
                if (i3 == 0) {
                    str = this.mediaId.get(i3);
                } else {
                    str = "," + this.mediaId.get(i3);
                }
                sb5.append(str);
            }
        }
        return sb5.toString();
    }

    public void readFromParcel(Parcel parcel) {
        this.mediaType = parcel.readString();
        this.mediaId = parcel.createStringArrayList();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mediaType);
        parcel.writeStringList(this.mediaId);
    }

    protected WinkPublishMediaRecord(Parcel parcel) {
        this.mediaType = parcel.readString();
        this.mediaId = parcel.createStringArrayList();
    }
}
