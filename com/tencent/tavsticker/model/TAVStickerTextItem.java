package com.tencent.tavsticker.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.tavsticker.TAVStickerHelper;
import com.tencent.tavsticker.core.TAVFontManager;
import org.libpag.PAGFont;
import org.libpag.PAGLayer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVStickerTextItem extends TAVStickerLayerItem implements Parcelable {
    public static final Parcelable.Creator<TAVStickerTextItem> CREATOR = new Parcelable.Creator<TAVStickerTextItem>() { // from class: com.tencent.tavsticker.model.TAVStickerTextItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TAVStickerTextItem createFromParcel(Parcel parcel) {
            return new TAVStickerTextItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TAVStickerTextItem[] newArray(int i3) {
            return new TAVStickerTextItem[i3];
        }
    };
    private static final String TAG = "TAVStickerTextItem";
    private String assetFontPath;
    private int defaultColor;
    private String defaultText;
    private String fontFamily;
    private String fontPath;
    private String fontStyle;
    private int maxLength;
    private String text;
    private int textColor;

    public TAVStickerTextItem() {
        this.text = "";
        this.defaultText = "";
        this.maxLength = -1;
        this.textColor = 0;
        this.defaultColor = -16777216;
        this.fontPath = "";
        this.assetFontPath = "";
        this.fontFamily = "";
        this.fontStyle = "";
        this.layerType = 3;
        init();
    }

    private PAGFont getPagFont() {
        if (!TextUtils.isEmpty(this.fontPath)) {
            return TAVFontManager.getInstance().fontWithPath(this.fontPath);
        }
        if (!TextUtils.isEmpty(this.assetFontPath)) {
            return TAVFontManager.getInstance().fontWithAssetPath(TAVStickerHelper.getContext(), this.assetFontPath);
        }
        return null;
    }

    private void init() {
        this.text = "";
        this.defaultText = "";
        this.maxLength = 0;
        this.defaultColor = -16777216;
        this.fontPath = "";
        this.fontFamily = "";
        this.fontStyle = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAssetFontPath() {
        return this.assetFontPath;
    }

    public int getDefaultColor() {
        return this.defaultColor;
    }

    public String getDefaultText() {
        return this.defaultText;
    }

    public String getFontFamily() {
        PAGFont pagFont = getPagFont();
        if (pagFont != null) {
            return pagFont.fontFamily;
        }
        return this.fontFamily;
    }

    public String getFontPath() {
        return this.fontPath;
    }

    public String getFontStyle() {
        PAGFont pagFont = getPagFont();
        if (pagFont != null) {
            return pagFont.fontStyle;
        }
        return this.fontStyle;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public String getText() {
        return this.text;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public void setAssetFontPath(String str) {
        this.assetFontPath = str;
    }

    public void setDefaultColor(int i3) {
        this.defaultColor = i3;
    }

    public void setDefaultText(String str) {
        this.defaultText = str;
    }

    public void setFontFamily(String str) {
        this.fontFamily = str;
    }

    public void setFontPath(String str) {
        this.fontPath = str;
    }

    public void setFontStyle(String str) {
        this.fontStyle = str;
    }

    public void setMaxLength(int i3) {
        this.maxLength = i3;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTextColor(int i3) {
        this.textColor = i3;
    }

    public String toString() {
        return "TAVStickerTextItem {layerIndex : " + this.layerIndex + ", layerName : " + this.layerName + ", layerType : " + this.layerType + ", text : " + this.text + ", defaultText : " + this.defaultText + ", maxLength : " + this.maxLength + ", textColor : " + this.textColor + ", defaultColor : " + this.defaultColor + ", fontPath : " + this.fontPath + ", assetFontPath : " + this.assetFontPath + ", fontFamily : " + this.fontFamily + ", fontStyle : " + this.fontStyle + "}";
    }

    public TAVStickerTextItem updateData(TAVStickerTextItem tAVStickerTextItem) {
        if (tAVStickerTextItem != null) {
            this.text = tAVStickerTextItem.text;
            this.defaultText = tAVStickerTextItem.defaultText;
            this.maxLength = tAVStickerTextItem.maxLength;
            this.textColor = tAVStickerTextItem.textColor;
            this.defaultColor = tAVStickerTextItem.defaultColor;
            this.fontPath = tAVStickerTextItem.fontPath;
            this.assetFontPath = tAVStickerTextItem.assetFontPath;
            this.fontFamily = tAVStickerTextItem.fontFamily;
            this.fontStyle = tAVStickerTextItem.fontStyle;
        }
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.layerIndex);
        String str = this.layerName;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        parcel.writeString(str);
        parcel.writeInt(this.layerType);
        String str3 = this.text;
        if (str3 == null) {
            str3 = "";
        }
        parcel.writeString(str3);
        String str4 = this.defaultText;
        if (str4 == null) {
            str4 = "";
        }
        parcel.writeString(str4);
        parcel.writeInt(this.maxLength);
        parcel.writeInt(this.textColor);
        parcel.writeInt(this.defaultColor);
        String str5 = this.fontPath;
        if (str5 == null) {
            str5 = "";
        }
        parcel.writeString(str5);
        String str6 = this.assetFontPath;
        if (str6 != null) {
            str2 = str6;
        }
        parcel.writeString(str2);
    }

    public TAVStickerTextItem(PAGLayer pAGLayer) {
        super(pAGLayer);
        this.text = "";
        this.defaultText = "";
        this.maxLength = -1;
        this.textColor = 0;
        this.defaultColor = -16777216;
        this.fontPath = "";
        this.assetFontPath = "";
        this.fontFamily = "";
        this.fontStyle = "";
        init();
    }

    protected TAVStickerTextItem(Parcel parcel) {
        this.text = "";
        this.defaultText = "";
        this.maxLength = -1;
        this.textColor = 0;
        this.defaultColor = -16777216;
        this.fontPath = "";
        this.assetFontPath = "";
        this.fontFamily = "";
        this.fontStyle = "";
        if (parcel != null) {
            this.layerIndex = parcel.readInt();
            this.layerName = parcel.readString();
            this.layerType = parcel.readInt();
            this.text = parcel.readString();
            this.defaultText = parcel.readString();
            this.maxLength = parcel.readInt();
            this.textColor = parcel.readInt();
            this.defaultColor = parcel.readInt();
            this.fontPath = parcel.readString();
            this.assetFontPath = parcel.readString();
        }
    }
}
