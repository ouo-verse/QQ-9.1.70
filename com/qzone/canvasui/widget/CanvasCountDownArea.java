package com.qzone.canvasui.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.canvasui.gdtui.IGdtCanvasUi;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommAction;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.LinearAreaLayout;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasCountDownArea extends LinearAreaLayout implements IGdtCanvasUi {
    private Runnable countDownRunnable;
    private DittoButtonArea dayTv;
    private DittoButtonArea dayUnitTv;
    private DittoButtonArea hourTv;
    private DittoButtonArea hourUnitTv;
    private int mCountDownSeconds;
    private Drawable mDrawableCache;
    private BusinessFeedData mFeedData;
    private DittoButtonArea minTv;
    private DittoButtonArea secTv;
    private DittoButtonArea splitHourTv;
    private DittoButtonArea splitMinTv;
    private static final long REFRESHTIME = i.H().S("QZoneSetting", "QzoneMoodDeleteRefreshTime", 1);
    private static int CAL_HOUR_UINT = 3600;
    private static int CAL_DAY_UINT = 86400;

    public CanvasCountDownArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.mDrawableCache = null;
        this.countDownRunnable = new Runnable() { // from class: com.qzone.canvasui.widget.CanvasCountDownArea.1
            @Override // java.lang.Runnable
            public void run() {
                CanvasCountDownArea canvasCountDownArea = CanvasCountDownArea.this;
                canvasCountDownArea.mCountDownSeconds--;
                CanvasCountDownArea.this.updateText();
                CanvasCountDownArea.this.startCountDown();
            }
        };
        setOrientation(0);
        initView(dittoHost, layoutAttrSet);
    }

    private int getTimeTextColor() {
        try {
            String str = (String) new JSONObject("{color:f33f20}").get("color");
            if (str.charAt(0) != '#') {
                str = "#" + str;
            }
            return Color.parseColor(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    private void setTextData(long j3) {
        long countDownTimeFromCurrencyPassField = getCountDownTimeFromCurrencyPassField(this.mFeedData);
        if (countDownTimeFromCurrencyPassField <= 0) {
            this.mCountDownSeconds = this.mFeedData.getRecommAction().countDownTimer - (((int) (SystemClock.elapsedRealtime() - j3)) / 1000);
        } else {
            this.mCountDownSeconds = (int) countDownTimeFromCurrencyPassField;
        }
        startCountDown();
        updateView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCountDown() {
        this.mMainHandler.removeCallbacks(this.countDownRunnable);
        if (this.mCountDownSeconds < 0) {
            return;
        }
        this.mMainHandler.postDelayed(this.countDownRunnable, REFRESHTIME * 1000);
    }

    public void addDayFormatView(int i3) {
        int i16 = (i3 / CAL_HOUR_UINT) % 24;
        int i17 = i3 / CAL_DAY_UINT;
        removeAllChildren();
        LayoutAttrSet layoutAttrSet = new LayoutAttrSet();
        layoutAttrSet.addLayoutAttr("width", "24.5dp");
        layoutAttrSet.addLayoutAttr("height", "18dp");
        layoutAttrSet.addLayoutAttr("margin", "9dp,0,2dp,0");
        this.dayTv.setTextSize(12.0f);
        this.dayTv.setText(formatNumStr(i17));
        addChild(this.dayTv, layoutAttrSet);
        LayoutAttrSet layoutAttrSet2 = new LayoutAttrSet();
        this.dayUnitTv.setText("\u5929");
        this.dayUnitTv.setTextSize(12.0f);
        addChild(this.dayUnitTv, layoutAttrSet2);
        LayoutAttrSet layoutAttrSet3 = new LayoutAttrSet();
        layoutAttrSet3.addLayoutAttr("width", "24.5dp");
        layoutAttrSet3.addLayoutAttr("height", "18dp");
        layoutAttrSet3.addLayoutAttr("margin", "2dp,0,2dp,0");
        this.hourTv.setTextSize(12.0f);
        this.hourTv.setText(formatNumStr(i16));
        addChild(this.hourTv, layoutAttrSet3);
        LayoutAttrSet layoutAttrSet4 = new LayoutAttrSet();
        layoutAttrSet4.addLayoutAttr(LayoutAttrDefine.Gravity.Layout_Gravity, "center_vertical");
        this.splitHourTv.setText(":");
        this.splitHourTv.setTextSize(12.0f);
        addChild(this.splitHourTv, layoutAttrSet4);
        LayoutAttrSet layoutAttrSet5 = new LayoutAttrSet();
        layoutAttrSet5.addLayoutAttr("width", "24.5dp");
        layoutAttrSet5.addLayoutAttr("height", "18dp");
        layoutAttrSet5.addLayoutAttr("margin", "2dp,0,2dp,0");
        this.minTv.setTextSize(12.0f);
        this.minTv.setText(formatNumStr((i3 / 60) % 60));
        addChild(this.minTv, layoutAttrSet5);
    }

    public void addHourFormatView(int i3) {
        int i16 = i3 % 60;
        int i17 = (i3 / 60) % 60;
        int i18 = (i3 / CAL_HOUR_UINT) % 24;
        removeAllChildren();
        LayoutAttrSet layoutAttrSet = new LayoutAttrSet();
        layoutAttrSet.addLayoutAttr("width", "24.5dp");
        layoutAttrSet.addLayoutAttr("height", "18dp");
        layoutAttrSet.addLayoutAttr("margin", "9dp,0,2dp,0");
        this.hourTv.setText(formatNumStr(i18));
        this.hourTv.setTextSize(12.0f);
        addChild(this.hourTv, layoutAttrSet);
        LayoutAttrSet layoutAttrSet2 = new LayoutAttrSet();
        layoutAttrSet2.addLayoutAttr(LayoutAttrDefine.Gravity.Layout_Gravity, "center_vertical");
        this.splitHourTv.setText(":");
        this.splitHourTv.setTextSize(12.0f);
        addChild(this.splitHourTv, layoutAttrSet2);
        LayoutAttrSet layoutAttrSet3 = new LayoutAttrSet();
        layoutAttrSet3.addLayoutAttr("width", "24.5dp");
        layoutAttrSet3.addLayoutAttr("height", "18dp");
        layoutAttrSet3.addLayoutAttr("margin", "2dp,0,2dp,0");
        this.minTv.setText(formatNumStr(i17));
        this.minTv.setTextSize(12.0f);
        addChild(this.minTv, layoutAttrSet3);
        LayoutAttrSet layoutAttrSet4 = new LayoutAttrSet();
        layoutAttrSet4.addLayoutAttr(LayoutAttrDefine.Gravity.Layout_Gravity, "center_vertical");
        this.splitMinTv.setText(":");
        this.splitMinTv.setTextSize(12.0f);
        addChild(this.splitMinTv, layoutAttrSet4);
        LayoutAttrSet layoutAttrSet5 = new LayoutAttrSet();
        layoutAttrSet5.addLayoutAttr("margin", "2dp,0,2dp,0");
        layoutAttrSet5.addLayoutAttr("width", "24.5dp");
        layoutAttrSet5.addLayoutAttr("height", "18dp");
        this.secTv.setTextSize(12.0f);
        this.secTv.setText(formatNumStr(i16));
        addChild(this.secTv, layoutAttrSet5);
    }

    public void initView(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        this.dayTv = new DittoButtonArea(dittoHost, layoutAttrSet);
        this.hourTv = new DittoButtonArea(dittoHost, layoutAttrSet);
        this.minTv = new DittoButtonArea(dittoHost, layoutAttrSet);
        this.secTv = new DittoButtonArea(dittoHost, layoutAttrSet);
        this.dayUnitTv = new DittoButtonArea(dittoHost, layoutAttrSet);
        this.hourUnitTv = new DittoButtonArea(dittoHost, layoutAttrSet);
        this.splitHourTv = new DittoButtonArea(dittoHost, layoutAttrSet);
        this.splitMinTv = new DittoButtonArea(dittoHost, layoutAttrSet);
    }

    @Override // com.tencent.ditto.area.DittoAreaGroup, com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void recycle() {
        this.mMainHandler.removeCallbacks(this.countDownRunnable);
    }

    public void restoreTimeTextColor() {
        setTimeTextColor(getTimeTextColor());
    }

    @Override // com.qzone.canvasui.gdtui.IGdtCanvasUi
    public void setFeedData(BusinessFeedData businessFeedData) {
        String str;
        this.mFeedData = businessFeedData;
        if (!checkDataValid(businessFeedData)) {
            setVisibility(8);
            return;
        }
        if (i.H().p1()) {
            str = "https://public.gdtimg.com/ams-web/public/client/adIcon/ad_countdown_bg_image.png";
        } else {
            str = "https://public.gdtimg.com/aoi/sola/20180316181711_5zwOyguzy7.png";
        }
        this.mDrawableCache = ImageLoader.getInstance().loadImage(str, new ImageLoader.ImageLoadListener() { // from class: com.qzone.canvasui.widget.CanvasCountDownArea.2
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options) {
                if (drawable != null) {
                    CanvasCountDownArea.this.mDrawableCache = drawable;
                }
                CanvasCountDownArea canvasCountDownArea = CanvasCountDownArea.this;
                canvasCountDownArea.setNumberBackground(canvasCountDownArea.mDrawableCache);
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str2, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str2, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str2, float f16, ImageLoader.Options options) {
            }
        });
        setTextData(this.mFeedData.adPullTimeForCountDown);
    }

    public void setNumberBackground(Drawable drawable) {
        this.dayTv.setBackgroundDrawable(drawable);
        this.hourTv.setBackgroundDrawable(drawable);
        this.minTv.setBackgroundDrawable(drawable);
        this.secTv.setBackgroundDrawable(drawable);
    }

    @Override // com.qzone.canvasui.gdtui.IGdtCanvasUi
    public void update() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || businessFeedData.getRecommAction() == null || !checkDataValid(this.mFeedData)) {
            return;
        }
        setVisibility(0);
        Drawable drawable = this.mDrawableCache;
        if (drawable != null) {
            setNumberBackground(drawable);
        }
        setTimeTextColor(getTimeTextColor());
        setTextData(this.mFeedData.adPullTimeForCountDown);
    }

    public void updateText() {
        String l3;
        String l16;
        String l17;
        int i3 = this.mCountDownSeconds;
        int i16 = CAL_DAY_UINT;
        int i17 = i3 / i16;
        int i18 = (i3 / CAL_HOUR_UINT) % 24;
        int i19 = (i3 / 60) % 60;
        if (i3 == i16 - 1) {
            addHourFormatView(i3);
        }
        if (i17 > 0) {
            String formatNumStr = formatNumStr(i17);
            String formatNumStr2 = formatNumStr(i18);
            String formatNumStr3 = formatNumStr(i19);
            this.dayTv.setText(formatNumStr);
            this.dayUnitTv.setText("\u5929");
            this.hourTv.setText(formatNumStr2);
            this.hourUnitTv.setText(":");
            this.minTv.setText(formatNumStr3);
            return;
        }
        long j3 = i3 % 60;
        if (i18 <= 9) {
            l3 = "0" + Long.toString(i18);
        } else {
            l3 = Long.toString(i18);
        }
        if (i19 <= 9) {
            l16 = "0" + Long.toString(i19);
        } else {
            l16 = Long.toString(i19);
        }
        if (j3 <= 9) {
            l17 = "0" + Long.toString(j3);
        } else {
            l17 = Long.toString(j3);
        }
        this.hourTv.setText(l3);
        this.minTv.setText(l16);
        this.secTv.setText(l17);
        this.splitHourTv.setText(":");
        this.splitMinTv.setText(":");
        if (i3 < 0) {
            updateParentRecommAtion();
        }
    }

    public void updateView() {
        int i3 = this.mCountDownSeconds;
        if (i3 < 0) {
            updateParentRecommAtion();
            return;
        }
        if (i3 / CAL_DAY_UINT > 0) {
            addDayFormatView(i3);
        } else {
            addHourFormatView(i3);
        }
        setNumberBackground(this.mDrawableCache);
    }

    @Override // com.qzone.canvasui.gdtui.IGdtCanvasUi
    public void reset() {
        this.mFeedData = null;
        setVisibility(8);
    }

    public static boolean checkDataValid(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || businessFeedData.getRecommAction() == null || (businessFeedData.getRecommAction().countDownTimer <= 0 && getCountDownTimeFromCurrencyPassField(businessFeedData) <= 0)) ? false : true;
    }

    private static long getCountDownTimeFromCurrencyPassField(BusinessFeedData businessFeedData) {
        long j3 = 0;
        try {
            j3 = Long.parseLong(GdtAdFeedUtil.getValueFromSdkPassData(businessFeedData, "countdown_end_time"));
            return j3 - (System.currentTimeMillis() / 1000);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return j3;
        }
    }

    private void updateParentRecommAtion() {
        setVisibility(8);
        if (getHost() == null || !(getHost() instanceof CanvasRecommAction)) {
            return;
        }
        ((CanvasRecommAction) getHost()).setCountDownTimeViewGone();
    }

    public void setTimeTextColor(int i3) {
        if (i3 != -1) {
            this.dayTv.setTextColor(i3);
            this.hourTv.setTextColor(i3);
            this.minTv.setTextColor(i3);
            this.secTv.setTextColor(i3);
            this.dayUnitTv.setTextColor(i3);
            this.hourUnitTv.setTextColor(i3);
            this.splitHourTv.setTextColor(i3);
            this.splitMinTv.setTextColor(i3);
        }
    }

    private String formatNumStr(int i3) {
        if (i3 <= 9) {
            return "0" + Long.toString(i3);
        }
        return Long.toString(i3);
    }
}
