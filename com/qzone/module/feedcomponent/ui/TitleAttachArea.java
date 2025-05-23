package com.qzone.module.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.qzone.module.feedcomponent.ui.common.AccessibleArea;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFunnyTreadSpace;
import com.qzone.proxy.feedcomponent.model.CellPermissionInfo;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TitleAttachArea extends SubArea implements AccessibleArea {
    public static final Drawable RECOMMM_DRAWBLE;
    public static final int dp14 = AreaConst.dp14;
    public static final int dp20;

    /* renamed from: dp3, reason: collision with root package name */
    public static final int f48761dp3;
    private static Paint paint;
    int mHeight;
    int mWidth;
    private String mText = null;
    private float mTextWidth = 0.0f;
    int virtualId = -1;

    static {
        Drawable g16 = com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.GET_MORE_JUMP_TIPS_BTN);
        RECOMMM_DRAWBLE = g16;
        dp20 = (int) (FeedGlobalEnv.g().getDensity() * 20.0f);
        f48761dp3 = (int) (FeedGlobalEnv.g().getDensity() * 3.0f);
        g16.setBounds(0, 0, (int) (FeedGlobalEnv.g().getDensity() * 43.0f), (int) (FeedGlobalEnv.g().getDensity() * 40.0f));
        Paint paint2 = new Paint();
        paint = paint2;
        paint2.setColor(-7829368);
        paint.setTextSize(FeedGlobalEnv.g().getSpValue(12.0f));
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint2) {
        int i3 = this.mType;
        if (i3 == 18) {
            int i16 = this.mHeight;
            int i17 = AreaConst.dp15;
            canvas.translate((this.mWidth - i17) / 2, (i16 - i17) / 2);
            AreaManager.DELETE_DRAWABLE.draw(canvas);
            return true;
        }
        if (i3 == 19) {
            int i18 = this.mHeight;
            int i19 = AreaConst.dp40;
            canvas.translate((this.mWidth - i19) / 2, (i18 - i19) / 2);
            AreaManager.RECOMMM_DRAWBLE.draw(canvas);
            return true;
        }
        if (i3 == 59 || i3 == 60) {
            int i26 = this.mHeight;
            int i27 = AreaConst.dp15;
            canvas.translate(((this.mWidth - i27) - this.mTextWidth) / 2.0f, (i26 - i27) / 2);
            if (this.mType == 60) {
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                canvas.drawText(this.mText, 0.0f, ((AreaConst.dp7_5 - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)) + AreaConst.f48747dp2, paint);
                canvas.translate(this.mTextWidth, 0.0f);
            }
            AreaManager.DROPDOWN_DRAWABLE.draw(canvas);
            return true;
        }
        if (i3 == 66) {
            int i28 = this.mHeight;
            int i29 = AreaConst.dp15;
            canvas.translate((this.mWidth - i29) / 2, i28 - i29);
            AreaManager.ADV_CLOSE_DRAWABLE.draw(canvas);
            return true;
        }
        if (i3 != 70) {
            switch (i3) {
                case 84:
                    canvas.translate((this.mWidth - AreaConst.dp40) / 2, (this.mHeight - AreaConst.dp30) / 2);
                    if (AreaManager.HIGH_FIVE_NORMAL_DRAWABLE == null) {
                        AreaManager.HIGH_FIVE_NORMAL_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(869);
                    }
                    AreaManager.HIGH_FIVE_NORMAL_DRAWABLE.draw(canvas);
                    return true;
                case 85:
                    canvas.translate((this.mWidth - AreaConst.dp40) / 2, (this.mHeight - AreaConst.dp30) / 2);
                    if (AreaManager.HIGH_FIVE_CLICKED_DRAWABLE == null) {
                        AreaManager.HIGH_FIVE_CLICKED_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(870);
                    }
                    AreaManager.HIGH_FIVE_CLICKED_DRAWABLE.draw(canvas);
                    return true;
                case 86:
                    canvas.translate((this.mWidth - AreaConst.dp18) / 2.0f, (this.mHeight - AreaConst.dp24) / 2.0f);
                    int color = paint.getColor();
                    float textSize = paint.getTextSize();
                    paint.setColor(com.qzone.adapter.feedcomponent.j.I());
                    paint.setTextSize(AreaConst.dp14);
                    Paint.FontMetrics fontMetrics2 = paint.getFontMetrics();
                    canvas.drawText(this.mText, 0.0f, (AreaConst.dp7_5 - (fontMetrics2.top / 2.0f)) - (fontMetrics2.bottom / 2.0f), paint);
                    paint.setColor(color);
                    paint.setTextSize(textSize);
                    return true;
                default:
                    return true;
            }
        }
        canvas.translate(0.0f, (this.mHeight - AreaConst.dp21) / 2);
        AreaManager.BIRTHDAY_CLOSE_DRAWABLE.draw(canvas);
        return true;
    }

    @Override // com.qzone.module.feedcomponent.ui.common.AccessibleArea
    public int getAreaId() {
        return this.virtualId;
    }

    @Override // com.qzone.module.feedcomponent.ui.common.AccessibleArea
    public String getContentDescription() {
        return "\u4e0b\u62c9\u83dc\u5355\u6309\u94ae";
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getHeight() {
        return this.mHeight;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getWidth() {
        return this.mWidth;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
        int i17 = this.mType;
        if (i17 == -1) {
            this.mHeight = 0;
            this.mWidth = 0;
            return;
        }
        if (i17 == 70) {
            int i18 = (AreaConst.FEED_INTERVAL * 2) + AreaConst.dp11;
            this.mHeight = i18;
            this.mWidth = i18;
            return;
        }
        if (i17 == 60 || i17 == 86) {
            int i19 = (AreaConst.FEED_INTERVAL * 2) + AreaConst.dp11;
            this.mHeight = i19;
            this.mWidth = i19 + ((int) this.mTextWidth);
        } else if (i17 != 84 && i17 != 85) {
            int i26 = (AreaConst.FEED_INTERVAL * 2) + AreaConst.dp11;
            this.mHeight = i26;
            this.mWidth = i26;
        } else {
            int i27 = (AreaConst.FEED_INTERVAL * 2) + dp14;
            this.mHeight = i27;
            this.mWidth = i27;
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean onTouchEvent(MotionEvent motionEvent, SubAreaShell subAreaShell, boolean z16) {
        if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
            if (motionEvent.getAction() == 1) {
                if (subAreaShell != null) {
                    subAreaShell.onAreaClicked(this, null);
                }
            } else if (motionEvent.getAction() != 3) {
                motionEvent.getAction();
            }
        }
        return true;
    }

    @Override // com.qzone.module.feedcomponent.ui.common.AccessibleArea
    public void setAreaId(int i3) {
        this.virtualId = i3;
    }

    public boolean showDropdownButton(BusinessFeedData businessFeedData) {
        if (businessFeedData.feedType == 2) {
            return false;
        }
        return com.qzone.adapter.feedcomponent.i.H().D2(businessFeedData);
    }

    public void setFeedData(BusinessFeedData businessFeedData, boolean z16) {
        this.mType = -1;
        if (businessFeedData.isGDTAdvFeed() && businessFeedData.feedType == 2) {
            return;
        }
        if (z16) {
            this.mType = 19;
            return;
        }
        if (!needHighlightHigh5Button(businessFeedData) && !businessFeedData.isFakeHighFive && (!showMultipleHighFiveIcon(businessFeedData) || canMultipleHighFive(businessFeedData))) {
            if (!showHigh5Button(businessFeedData) && (!showMultipleHighFiveIcon(businessFeedData) || !canMultipleHighFive(businessFeedData))) {
                if (businessFeedData.isFriendBirthdayGift()) {
                    this.mType = 70;
                    return;
                }
                if (showDropdownButtonAndText(businessFeedData)) {
                    this.mType = 60;
                    return;
                }
                if (showDropdownButton(businessFeedData)) {
                    this.mType = 59;
                    return;
                }
                if (showReturnVisitBtnAndText(businessFeedData)) {
                    this.mType = 86;
                    return;
                }
                if (businessFeedData.getSinglePicAdvStyle() == 4) {
                    this.mType = 66;
                }
                CellPermissionInfo permissionInfoV2 = businessFeedData.getPermissionInfoV2();
                if (permissionInfoV2 == null || (permissionInfoV2.permission_mask & 1) <= 0) {
                    return;
                }
                this.mType = 18;
                return;
            }
            this.mType = 84;
            return;
        }
        this.mType = 85;
    }

    public static boolean needHighlightHigh5Button(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.feedType != 4098 || businessFeedData.getOperationInfoV2() == null || businessFeedData.getOperationInfoV2().busiParam == null) {
            return false;
        }
        return "1".equals(businessFeedData.getOperationInfoV2().busiParam.get(156));
    }

    private boolean showDropdownButtonAndText(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.isGDTAdvFeed() && !TextUtils.isEmpty(businessFeedData.getUser().underNicknameDesc) && businessFeedData.feedType == 4097 && !QZoneAdFeedDataExtKt.isAdLittleIconStyle(businessFeedData) && showDropdownButton(businessFeedData)) {
            String str = businessFeedData.getUser().underNicknameDesc;
            this.mText = str;
            this.mTextWidth = paint.measureText(str) + AreaConst.dp6;
            return true;
        }
        this.mText = "";
        this.mTextWidth = 0.0f;
        return false;
    }

    public static boolean showHigh5Button(BusinessFeedData businessFeedData) {
        return businessFeedData != null && businessFeedData.feedType == 4098 && com.qzone.proxy.feedcomponent.util.i.h(businessFeedData);
    }

    private boolean showReturnVisitBtnAndText(BusinessFeedData businessFeedData) {
        CellFunnyTreadSpace cellFunnyTreadSpace;
        List<String> list;
        if (businessFeedData != null && (cellFunnyTreadSpace = businessFeedData.cellFunnyTreadSpace) != null && (list = cellFunnyTreadSpace.actions) != null && list.size() > 0) {
            this.mText = "\u56de\u8e29";
            this.mTextWidth = paint.measureText("\u56de\u8e29");
            return true;
        }
        this.mText = "";
        this.mTextWidth = 0.0f;
        return false;
    }

    public static boolean canMultipleHighFive(BusinessFeedData businessFeedData) {
        if (businessFeedData != null) {
            return businessFeedData.feedType == 4098 && com.qzone.proxy.feedcomponent.util.i.g(businessFeedData);
        }
        com.qzone.proxy.feedcomponent.b.a("TitleAttachArea", "[highFive].canMultipleHighFive, feedData = null");
        return false;
    }

    public static boolean showMultipleHighFiveIcon(BusinessFeedData businessFeedData) {
        if (businessFeedData != null) {
            return businessFeedData.feedType == 4098 && businessFeedData.getFeedCommInfo().isHighFiveAgain();
        }
        com.qzone.proxy.feedcomponent.b.a("TitleAttachArea", "[highFive].showMultipleHighFiveIcon, feedData = null");
        return false;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void clearTouchingEvent() {
    }
}
