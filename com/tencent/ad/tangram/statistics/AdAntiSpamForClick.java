package com.tencent.ad.tangram.statistics;

import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdAntiSpamForClick {
    private long actionDownTime = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    private long actionUpTime = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    private int downTouchX = 0;
    private int downTouchY = 0;
    private int upTouchX = 0;
    private int upTouchY = 0;
    private boolean hasShowCloseButton = false;
    private long videoPlayedDuration = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    private boolean hasBeenPaused = false;

    @Nullable
    public String onClick(@Nullable View view) {
        Object obj;
        if (view == null) {
            return null;
        }
        Rect rect = new Rect();
        JSONObject jSONObject = new JSONObject();
        try {
            long j3 = this.actionUpTime;
            if (j3 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                long j16 = this.actionDownTime;
                if (j16 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && j3 - j16 >= 0) {
                    jSONObject.put("g", String.valueOf((int) (j3 - j16)));
                }
            }
            int px2dp = AdUIUtils.px2dp(view.getContext(), this.downTouchX);
            if (px2dp != Integer.MIN_VALUE) {
                jSONObject.put("aa", String.valueOf(px2dp));
            }
            int px2dp2 = AdUIUtils.px2dp(view.getContext(), this.downTouchY);
            if (px2dp2 != Integer.MIN_VALUE) {
                jSONObject.put("ab", String.valueOf(px2dp2));
            }
            int px2dp3 = AdUIUtils.px2dp(view.getContext(), this.upTouchX);
            if (px2dp3 != Integer.MIN_VALUE) {
                jSONObject.put("ba", String.valueOf(px2dp3));
            }
            int px2dp4 = AdUIUtils.px2dp(view.getContext(), this.upTouchY);
            if (px2dp4 != Integer.MIN_VALUE) {
                jSONObject.put("bb", String.valueOf(px2dp4));
            }
            long j17 = this.videoPlayedDuration;
            if (j17 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                jSONObject.put("p", String.valueOf(j17));
            }
            String str = "1";
            if (this.hasBeenPaused) {
                obj = "1";
            } else {
                obj = "0";
            }
            jSONObject.put("f", obj);
            if (!this.hasShowCloseButton) {
                str = "0";
            }
            jSONObject.put(HippyTKDListViewAdapter.X, str);
            int px2dp5 = AdUIUtils.px2dp(view.getContext(), view.getWidth());
            if (px2dp5 != Integer.MIN_VALUE) {
                jSONObject.put("da", String.valueOf(px2dp5));
            }
            int px2dp6 = AdUIUtils.px2dp(view.getContext(), view.getHeight());
            if (px2dp6 != Integer.MIN_VALUE) {
                jSONObject.put(TVKNetVideoInfo.AUDIO_TRACK_DOLBY, String.valueOf(px2dp6));
            }
            if (view.getGlobalVisibleRect(rect)) {
                int px2dp7 = AdUIUtils.px2dp(view.getContext(), rect.left);
                if (px2dp7 != Integer.MIN_VALUE) {
                    jSONObject.put("px", String.valueOf(px2dp7));
                }
                int px2dp8 = AdUIUtils.px2dp(view.getContext(), rect.top);
                if (px2dp8 != Integer.MIN_VALUE) {
                    jSONObject.put("py", String.valueOf(px2dp8));
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (jSONObject.length() == 0) {
            return null;
        }
        return jSONObject.toString();
    }

    public void onTouch(@Nullable View view, @Nullable MotionEvent motionEvent) {
        if (view != null && motionEvent != null) {
            if (motionEvent.getAction() == 0) {
                this.actionDownTime = System.currentTimeMillis();
                this.downTouchX = (int) motionEvent.getX();
                this.downTouchY = (int) motionEvent.getY();
            } else if (motionEvent.getAction() == 1) {
                this.actionUpTime = System.currentTimeMillis();
                this.upTouchX = (int) motionEvent.getX();
                this.upTouchY = (int) motionEvent.getY();
            }
        }
    }

    public void setHasBeenPaused() {
        this.hasBeenPaused = true;
    }

    public void setHasShowCloseButton(boolean z16) {
        this.hasShowCloseButton = z16;
    }

    public void setVideoPlayedDuration(long j3) {
        this.videoPlayedDuration = j3;
    }
}
