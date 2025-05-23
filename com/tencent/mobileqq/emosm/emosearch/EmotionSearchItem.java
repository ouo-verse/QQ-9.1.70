package com.tencent.mobileqq.emosm.emosearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchTextComposeInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchTextMallEmojiInfo;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes6.dex */
public class EmotionSearchItem extends HotPicData implements Serializable {
    public static final Parcelable.Creator<EmotionSearchItem> CREATOR = new a();

    @notColumn
    public int emojiType;

    @notColumn
    public EmojiHotPicSearchTextMallEmojiInfo mallEmojiInfo;

    @notColumn
    public EmojiHotPicSearchTextComposeInfo textComposeInfo;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<EmotionSearchItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EmotionSearchItem createFromParcel(Parcel parcel) {
            return new EmotionSearchItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EmotionSearchItem[] newArray(int i3) {
            return new EmotionSearchItem[i3];
        }
    }

    public EmotionSearchItem() {
    }

    @Override // com.tencent.mobileqq.hotpic.HotPicData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getEmoMd5() {
        return this.md5;
    }

    public String getEmoURL() {
        return this.url;
    }

    public int getFileType() {
        return this.fileType;
    }

    public String getOriginEmoMd5() {
        return this.originalMD5;
    }

    public String getThumbImgFileId() {
        return this.thumbImgFileId;
    }

    public String getThumbImgMD5() {
        return this.thumbImgMD5;
    }

    @Override // com.tencent.mobileqq.hotpic.HotPicData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
    }

    protected EmotionSearchItem(Parcel parcel) {
        super(parcel);
    }
}
