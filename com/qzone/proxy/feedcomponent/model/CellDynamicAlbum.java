package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_photo_layer;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellDynamicAlbum implements SmartParcelable {
    public static int FEED_PLAYED = 1;
    public static int OPMASK = 1;
    public static final int dp13;
    public static final int dp5;
    public static final int sBottom2ButtonDistance;
    public static final int sBtnBackgroundColor = 1275068416;
    public static final int sBtnHeight;
    public static final int sBtnText2IcDistance;
    public static final int sBtnTextFontColor = -1;
    public static final int sBtnTextFontSize;
    public static final int sBtnWidth = com.qzone.proxy.feedcomponent.util.g.a(133.0f);
    public static final int sButton2BottomDistance;
    public static final int sButton2DescDistance;
    public static final int sDesc2BottomDistance;
    public static final int sDesc2TitleDistance;
    public static final int sDescFonSize;
    public static final int sDescFontColor = -1;
    public static final int sDescMaxCnt = 18;
    public static final int sHazyLayerColor = -16777216;
    public static final float sHazyLayerToAlpha = 0.4f;
    public static final int sIc2BtnLeftDistance;
    public static final int sIc2BtnTopDistance;
    public static final int sIcHeight;
    public static final int sIcWidth;
    public static final int sNewBtnHeight;
    public static final int sNewBtnText2IcDistance;
    public static final int sNewBtnTextFontSize;
    public static final int sNewBtnWidth;
    public static final int sNewIc2BtnLeftDistance;
    public static final int sNewIc2BtnTopDistance;
    public static final int sPicStandardHeight;
    public static final int sPicStandardWidth;
    public static final int sTitle2BottomDistance;
    public static final int sTitle2TopDistance;
    public static final int sTitleFontColor = -1;
    public static final int sTitleFontSize;
    public static final int sTitleMaxCnt = 12;
    public int mButtonTextHeight;
    public int mButtonTop;
    public int mDescTextHeight;
    public int mDescTextTop;
    public int mNewButtonTop;
    public int mNewDescTextTop;
    public int mNewTitleTextTop;
    public int mPicHeight;
    public int mPicWidth;
    public int mTitleHeight;
    public int mTitleTop;
    public int mTitleWidth;

    @NeedParcel
    public int opmask;
    public int status;

    @NeedParcel
    public String layerTitle = "";

    @NeedParcel
    public String layerText = "";

    @NeedParcel
    public String buttonText = "";
    Rect mRect = new Rect();
    Paint mPaint = new Paint();
    public String mViewTitle = "";
    public String mViewDescText = "";

    public void calculateDynamicAlbum(int i3, int i16) {
        int i17;
        int textWidth;
        int i18;
        int i19 = this.mPicWidth;
        if (i19 == 0 || i19 != i3 || (i18 = this.mPicHeight) == 0 || i18 != i16) {
            this.mPicWidth = i3;
            this.mPicHeight = i16;
            String str = this.layerTitle;
            this.mViewTitle = str;
            if (str.length() > 12 && (textWidth = getTextWidth(sTitleFontSize, this.layerTitle)) > (i17 = (this.mPicWidth * 75) / 100)) {
                int length = (i17 / (textWidth / this.layerTitle.length())) - 3;
                this.mViewTitle = this.mViewTitle.substring(0, length >= 12 ? length : 12) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            String str2 = this.layerText;
            this.mViewDescText = str2;
            if (str2.length() > 18) {
                this.mViewDescText = this.mViewDescText.substring(0, 18) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            int i26 = sTitleFontSize;
            this.mTitleHeight = getTextHeight(i26, this.mViewTitle);
            this.mTitleWidth = getTextWidth(i26, this.mViewTitle);
            this.mDescTextHeight = getTextHeight(sDescFonSize, this.mViewDescText);
            this.mPaint.setTextSize(sBtnTextFontSize);
            Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
            this.mButtonTextHeight = (int) Math.abs(Math.ceil(fontMetrics.descent + fontMetrics.ascent + fontMetrics.leading));
            int title2TopDistance = getTitle2TopDistance(this.mPicHeight) + 0;
            this.mTitleTop = title2TopDistance;
            int i27 = this.mPicHeight;
            this.mNewTitleTextTop = ((i27 - this.mDescTextHeight) - sTitle2BottomDistance) + dp13;
            int desc2TitleDistance = title2TopDistance + this.mTitleHeight + getDesc2TitleDistance(i27);
            this.mDescTextTop = desc2TitleDistance;
            int i28 = this.mPicHeight;
            this.mNewDescTextTop = (i28 - sDesc2BottomDistance) - dp5;
            this.mButtonTop = desc2TitleDistance + this.mDescTextHeight + getButton2DescDistance(i28);
            this.mNewButtonTop = (this.mPicHeight - sBtnHeight) - sButton2BottomDistance;
        }
    }

    public boolean feedHasPlayed() {
        return (this.status & FEED_PLAYED) > 0;
    }

    int getBottom2ButtonDistance(int i3) {
        return (int) Math.ceil((getPiCalcuHeight(i3) * sBottom2ButtonDistance) / getPicStandardHeight());
    }

    int getButton2DescDistance(int i3) {
        return (int) Math.ceil((getPiCalcuHeight(i3) * sButton2DescDistance) / getPicStandardHeight());
    }

    int getDesc2TitleDistance(int i3) {
        return (int) Math.ceil((getPiCalcuHeight(i3) * sDesc2TitleDistance) / getPicStandardHeight());
    }

    int getPiCalcuHeight(int i3) {
        return ((i3 - this.mTitleHeight) - this.mDescTextHeight) - sBtnHeight;
    }

    int getPicStandardHeight() {
        return ((sPicStandardHeight - this.mTitleHeight) - this.mDescTextHeight) - sBtnHeight;
    }

    int getTextHeight(int i3, String str) {
        this.mRect.setEmpty();
        this.mPaint.setTextSize(i3);
        this.mPaint.getTextBounds(str, 0, str.length(), this.mRect);
        return this.mRect.height();
    }

    int getTextWidth(int i3, String str) {
        this.mRect.setEmpty();
        this.mPaint.setTextSize(i3);
        this.mPaint.getTextBounds(str, 0, str.length(), this.mRect);
        return this.mRect.width();
    }

    int getTitle2TopDistance(int i3) {
        return (int) Math.ceil((getPiCalcuHeight(i3) * sTitle2TopDistance) / getPicStandardHeight());
    }

    public void setFeedPlayed() {
        this.status |= FEED_PLAYED;
    }

    public String toString() {
        return "CellPhotoLayer {\nopmask: " + this.opmask + ", layerTitle: " + this.layerTitle + ", layerText: " + this.layerText + ", buttonText: " + this.buttonText + "}";
    }

    static {
        int a16 = com.qzone.proxy.feedcomponent.util.g.a(39.0f);
        sBtnHeight = a16;
        sNewBtnWidth = com.qzone.proxy.feedcomponent.util.g.a(99.0f);
        int a17 = com.qzone.proxy.feedcomponent.util.g.a(34.0f);
        sNewBtnHeight = a17;
        sIcWidth = com.qzone.proxy.feedcomponent.util.g.a(14.0f);
        int a18 = com.qzone.proxy.feedcomponent.util.g.a(16.0f);
        sIcHeight = a18;
        sIc2BtnLeftDistance = com.qzone.proxy.feedcomponent.util.g.a(18.0f);
        sIc2BtnTopDistance = (a16 - a18) / 2;
        sNewIc2BtnLeftDistance = com.qzone.proxy.feedcomponent.util.g.a(12.0f);
        sNewIc2BtnTopDistance = (a17 - a18) / 2;
        sDescFonSize = com.qzone.proxy.feedcomponent.util.g.a(14.0f);
        sTitleFontSize = com.qzone.proxy.feedcomponent.util.g.a(24.0f);
        sBtnTextFontSize = com.qzone.proxy.feedcomponent.util.g.a(16.0f);
        sNewBtnTextFontSize = com.qzone.proxy.feedcomponent.util.g.a(14.0f);
        sBtnText2IcDistance = com.qzone.proxy.feedcomponent.util.g.a(10.0f);
        sNewBtnText2IcDistance = com.qzone.proxy.feedcomponent.util.g.a(4.0f);
        sTitle2TopDistance = com.qzone.proxy.feedcomponent.util.g.a(66.0f);
        sDesc2TitleDistance = com.qzone.proxy.feedcomponent.util.g.a(12.0f);
        sDesc2BottomDistance = com.qzone.proxy.feedcomponent.util.g.a(12.0f);
        sTitle2BottomDistance = com.qzone.proxy.feedcomponent.util.g.a(41.0f);
        sButton2DescDistance = com.qzone.proxy.feedcomponent.util.g.a(30.0f);
        sBottom2ButtonDistance = com.qzone.proxy.feedcomponent.util.g.a(55.0f);
        sButton2BottomDistance = com.qzone.proxy.feedcomponent.util.g.a(17.0f);
        sPicStandardWidth = com.qzone.proxy.feedcomponent.util.g.a(375.0f);
        sPicStandardHeight = com.qzone.proxy.feedcomponent.util.g.a(240.0f);
        dp5 = com.qzone.proxy.feedcomponent.util.g.a(5.0f);
        dp13 = com.qzone.proxy.feedcomponent.util.g.a(13.0f);
    }

    public static CellDynamicAlbum create(l lVar) {
        if (lVar == null || lVar.N == null) {
            return null;
        }
        CellDynamicAlbum cellDynamicAlbum = new CellDynamicAlbum();
        cell_photo_layer cell_photo_layerVar = lVar.N;
        cellDynamicAlbum.opmask = cell_photo_layerVar.opmask;
        if (!TextUtils.isEmpty(cell_photo_layerVar.layer_title)) {
            cellDynamicAlbum.layerTitle = lVar.N.layer_title;
        }
        if (!TextUtils.isEmpty(lVar.N.layer_text)) {
            cellDynamicAlbum.layerText = lVar.N.layer_text;
        }
        if (!TextUtils.isEmpty(lVar.N.button_text)) {
            cellDynamicAlbum.buttonText = lVar.N.button_text;
        }
        return cellDynamicAlbum;
    }
}
