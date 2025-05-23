package com.qzone.canvasui.widget;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.module.feedcomponent.ui.NickNameArea;
import com.qzone.module.feedcomponent.ui.SubArea;
import com.qzone.module.feedcomponent.ui.ViewArea;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.area.MeasureCacheable;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.utils.DittoLog;
import com.tencent.mobileqq.vip.api.IVipColorName;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasNicknameArea extends DittoArea implements ViewArea.OnAreaClickedListener, SubArea.ViewHost {
    public static final String ACT_STYLE_TYPE = "4";
    public static final String DEFAULT_NICK_TYPE = "0";
    public static final String SWEET_VP_NICK_TYPE = "2";
    public static final String TEN_YELLOW_VPI_NICK_TYPE = "3";
    public static final String VPI_NICK_TYPE = "1";
    private Integer mCacheKey;
    private BusinessFeedData mFeedData;
    private User mKeyUser;
    private NickNameArea mNickname;
    private int oldHeightMeasureSpec;
    private int oldWidthMeasureSpec;

    public CanvasNicknameArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.oldWidthMeasureSpec = -1;
        this.oldHeightMeasureSpec = -1;
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea.ViewHost
    public View getAttachedView() {
        Object obj = this.mHost;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement, com.qzone.module.feedcomponent.ui.SubArea.ViewHost
    public void invalidateDelayed(long j3) {
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.qzone.canvasui.widget.CanvasNicknameArea.1
            @Override // java.lang.Runnable
            public void run() {
                CanvasNicknameArea.this.invalidate();
            }
        }, j3);
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea.OnAreaClickedListener
    public void onAreaClicked(ViewArea viewArea, TextCell textCell) {
        DittoArea.ClickListener clickListener = this.clickListener;
        if (clickListener != null) {
            clickListener.onClick(this, null, textCell);
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        NickNameArea nickNameArea = this.mNickname;
        if (nickNameArea != null) {
            nickNameArea.draw(canvas, null);
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        NickNameArea nickNameArea;
        Object obj;
        MeasureCacheable.TextMeasureCacheItem measureCache = getMeasureCache(this.mCacheKey, i3, i16);
        if ((measureCache == null || measureCache.measuredWidth <= 0 || measureCache.measureHeight <= 0) && (nickNameArea = this.mNickname) != null) {
            if (nickNameArea.oldWidthMeasureSpec != i3 || nickNameArea.oldHeightMeasureSpec != i16) {
                nickNameArea.measure(i3, i16);
            }
            measureCache = new MeasureCacheable.TextMeasureCacheItem();
            measureCache.keyWidthMeasureSpec = i3;
            measureCache.keyHeightMeasureSpec = i16;
            measureCache.measuredWidth = this.mNickname.getMeasuredWidth();
            measureCache.measureHeight = this.mNickname.getMeasuredHeight();
            addMeasureCache(this.mCacheKey, i3, i16, measureCache);
        }
        NickNameArea nickNameArea2 = this.mNickname;
        if (nickNameArea2 != null && (nickNameArea2.getMeasuredWidth() == 0 || this.mNickname.getmFontHeight() == 0)) {
            DittoLog.i(DittoLog.defaultTag, "NicknameArea does not measured! user:" + this.mCacheKey);
            this.mNickname.measure(i3, i16);
        }
        if (measureCache != null) {
            setMeasuredDimension(measureCache.measuredWidth, measureCache.measureHeight);
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("CanvasNicknameArea measure error! user:");
            User user = this.mKeyUser;
            if (user != null) {
                obj = Long.valueOf(user.uin);
            } else {
                obj = "-1";
            }
            sb5.append(obj);
            DittoLog.i(DittoLog.defaultTag, sb5.toString());
            setMeasuredDimension(0, 0);
        }
        this.oldWidthMeasureSpec = i3;
        this.oldHeightMeasureSpec = i16;
    }

    public void onStateIdle() {
        NickNameArea nickNameArea = this.mNickname;
        if (nickNameArea != null) {
            nickNameArea.onStateIdle();
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public boolean onTouchEvent(MotionEvent motionEvent) {
        NickNameArea nickNameArea = this.mNickname;
        if (nickNameArea != null) {
            return nickNameArea.onTouchEvent(motionEvent, this, this.longClickListener != null);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void recycle() {
        NickNameArea nickNameArea = this.mNickname;
        if (nickNameArea != null) {
            nickNameArea.reset();
            this.mNickname.setNickNameFlash(false);
        }
    }

    public void setAvatarRedPocketAnimState(boolean z16) {
        NickNameArea nickNameArea = this.mNickname;
        if (nickNameArea != null) {
            nickNameArea.setAvatarRedPocketAnimState(z16);
        }
    }

    public void setData(BusinessFeedData businessFeedData, boolean z16) {
        String str;
        this.mFeedData = businessFeedData;
        User user = businessFeedData.getUser();
        this.mKeyUser = user;
        if (user == null) {
            return;
        }
        Integer num = user.nickNameAreaCacheKey;
        if (num != null) {
            this.mCacheKey = num;
        } else {
            this.mCacheKey = generateCacheKey(user, businessFeedData);
        }
        if (businessFeedData.cellMallInfo == null) {
            str = "0";
        } else {
            str = "" + businessFeedData.cellMallInfo.nickTypeId;
        }
        NickNameArea nickNameArea = (NickNameArea) getAreaCache(this.mCacheKey, NickNameArea.class);
        this.mNickname = nickNameArea;
        if (nickNameArea == null) {
            NickNameArea nickNameArea2 = new NickNameArea(str);
            this.mNickname = nickNameArea2;
            addAreaCache(this.mCacheKey, nickNameArea2);
        }
        this.mNickname.setUser(user, str);
        this.mNickname.setTheme(businessFeedData.getCellTheme(), str);
        if (z16) {
            this.mNickname.setTextColor(j.I());
        }
        if (this.mNickname.getMeasuredWidth() <= 0) {
            this.mNickname.measure(this.oldWidthMeasureSpec, this.oldHeightMeasureSpec);
        }
        if (this.mNickname.getPaint() != null) {
            this.mNickname.getPaint().setShader(null);
            if (str.equals("3")) {
                this.mNickname.getPaint().setShader(IVipColorName.INSTANCE.getShader(this.mNickname.getMeasuredWidth(), this.mNickname.getMeasuredHeight()));
            }
        }
        this.mNickname.initShadow();
        this.mNickname.setNickNameFlash(!str.equals("0"));
        this.mNickname.setViewHost(this);
        setContentDescription(user.nickName);
    }

    public void setNickNameColor(int i3) {
        NickNameArea nickNameArea = this.mNickname;
        if (nickNameArea != null) {
            nickNameArea.setTextColor(i3);
        }
    }

    private Integer generateCacheKey(User user, BusinessFeedData businessFeedData) {
        if (user == null) {
            return null;
        }
        return Integer.valueOf((user.uin + "_" + user.nickName + "_" + ((int) user.isNickNameFlash) + "_" + businessFeedData.getFeedCommInfoV2().feedskey).hashCode());
    }
}
