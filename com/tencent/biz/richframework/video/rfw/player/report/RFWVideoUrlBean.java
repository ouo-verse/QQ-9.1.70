package com.tencent.biz.richframework.video.rfw.player.report;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qzone.publish.business.model.UploadVideoObject;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideoUrl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWVideoUrlBean implements Parcelable {
    public static final Parcelable.Creator<RFWVideoUrlBean> CREATOR;
    private static final HashMap<Integer, Integer> DEFAULT_RATE_MAP;
    public int mFormatId;
    public int mHeight;
    public String mHost;
    public int mLevelType;
    public int mLongSide;
    public int mPlayLevel;
    public int mRate;
    public int mResolutionLevel;
    public float mScore;
    public int mShortSide;
    public String mTraceId;
    public String mUrl;
    public int mVideoEncode;
    public int mWidth;
    public static final Pattern FORMAT_ID_PATTERN = Pattern.compile("(.*).f(\\d*)");
    private static final int[] RESOLUTION_SPLIT = {500, PlayerResources.ViewId.EXTENDED_VIEW_BTN_BUTTON_TEXT, 700, 1000, 1200};
    private static final int[] PLAY_SPLIT = {700, 1000};

    static {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        DEFAULT_RATE_MAP = hashMap;
        hashMap.put(8, 1100);
        hashMap.put(9, 1500);
        hashMap.put(10, 700);
        hashMap.put(18, 1000);
        hashMap.put(16, 600);
        hashMap.put(17, 900);
        hashMap.put(23, 600);
        hashMap.put(24, 500);
        hashMap.put(25, 400);
        CREATOR = new Parcelable.Creator<RFWVideoUrlBean>() { // from class: com.tencent.biz.richframework.video.rfw.player.report.RFWVideoUrlBean.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RFWVideoUrlBean createFromParcel(Parcel parcel) {
                return new RFWVideoUrlBean(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RFWVideoUrlBean[] newArray(int i3) {
                return new RFWVideoUrlBean[i3];
            }
        };
    }

    public RFWVideoUrlBean(RFWStVideoUrl rFWStVideoUrl) {
        Uri parse = Uri.parse(rFWStVideoUrl.getPlayUrl());
        this.mUrl = rFWStVideoUrl.getPlayUrl();
        this.mHost = parse.getHost();
        this.mTraceId = parse.getQueryParameter("traceid");
        this.mFormatId = getFormatIdFromUri(parse);
        this.mShortSide = Math.min(rFWStVideoUrl.getWidth(), rFWStVideoUrl.getHeight());
        this.mLongSide = Math.max(rFWStVideoUrl.getWidth(), rFWStVideoUrl.getHeight());
        this.mWidth = rFWStVideoUrl.getWidth();
        this.mHeight = rFWStVideoUrl.getHeight();
        this.mVideoEncode = rFWStVideoUrl.getVideoPrior();
        this.mRate = rFWStVideoUrl.getVideoRate() / 1024;
        this.mResolutionLevel = getLevelFromShortSlide(this.mShortSide, RESOLUTION_SPLIT);
        this.mPlayLevel = getLevelFromShortSlide(this.mShortSide, PLAY_SPLIT);
        this.mLevelType = rFWStVideoUrl.getLevelType();
        this.mScore = rFWStVideoUrl.getVideoClarityScore();
        tryToRefactorRate(this);
    }

    public static String getEncodeDesc(int i3) {
        if (i3 == 1) {
            return "h264";
        }
        if (i3 == 2) {
            return UploadVideoObject.VODEO_FORMAT_H265;
        }
        if (i3 == 4) {
            return "av1";
        }
        return "\u672a\u77e5";
    }

    public static int getFormatIdFromUri(Uri uri) {
        try {
            Matcher matcher = FORMAT_ID_PATTERN.matcher(uri.getPath());
            if (matcher.find()) {
                return Integer.parseInt(matcher.group(2));
            }
            return -1;
        } catch (Exception e16) {
            RFWLog.e("RFWVideoUrlBean", RFWLog.USR, e16.getMessage(), e16);
            return -1;
        }
    }

    private static int getLevelFromShortSlide(int i3, int[] iArr) {
        int length = iArr.length;
        int i16 = 0;
        for (int i17 = 0; i17 < length && i3 > iArr[i17]; i17++) {
            i16++;
        }
        return i16;
    }

    public static List<RFWVideoUrlBean> getUrlBeans(List<RFWStVideoUrl> list) {
        ArrayList arrayList = new ArrayList();
        for (RFWStVideoUrl rFWStVideoUrl : list) {
            if (!TextUtils.isEmpty(rFWStVideoUrl.getPlayUrl())) {
                arrayList.add(new RFWVideoUrlBean(rFWStVideoUrl));
            }
        }
        return arrayList;
    }

    public static void tryToRefactorRate(RFWVideoUrlBean rFWVideoUrlBean) {
        if (rFWVideoUrlBean != null && rFWVideoUrlBean.mRate == 0) {
            Integer num = DEFAULT_RATE_MAP.get(Integer.valueOf(rFWVideoUrlBean.mLevelType));
            if (num != null) {
                rFWVideoUrlBean.mRate = num.intValue();
            } else {
                rFWVideoUrlBean.mRate = 2000;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getVideoLevelString() {
        return " \u7801\u7387 " + this.mRate + "kb/s \u7f16\u7801 " + getEncodeDesc(this.mVideoEncode) + " \u5206\u8fa8\u7387 " + this.mShortSide + HippyTKDListViewAdapter.X + this.mLongSide + "\n \u57df\u540d " + this.mHost + "\n";
    }

    public String toString() {
        return " \u7801\u7387 " + this.mRate + "kb/s \u7f16\u7801 " + getEncodeDesc(this.mVideoEncode) + " \u6863\u4f4d " + this.mResolutionLevel + " \u5206\u8fa8\u7387 " + this.mShortSide + HippyTKDListViewAdapter.X + this.mLongSide + "\n \u57df\u540d " + this.mHost + "\n";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.mFormatId);
        parcel.writeString(this.mUrl);
        parcel.writeString(this.mHost);
        parcel.writeInt(this.mShortSide);
        parcel.writeInt(this.mLongSide);
        parcel.writeInt(this.mVideoEncode);
        parcel.writeInt(this.mRate);
        parcel.writeInt(this.mResolutionLevel);
        parcel.writeInt(this.mPlayLevel);
        parcel.writeInt(this.mLevelType);
        parcel.writeFloat(this.mScore);
    }

    public RFWVideoUrlBean(RFWStVideo rFWStVideo) {
        Uri parse = Uri.parse(rFWStVideo.getPlayUrl());
        this.mUrl = rFWStVideo.getPlayUrl();
        this.mFormatId = getFormatIdFromUri(parse);
        this.mHost = parse.getHost();
        this.mTraceId = parse.getQueryParameter("traceid");
        this.mShortSide = Math.min(rFWStVideo.getWidth(), rFWStVideo.getHeight());
        this.mLongSide = Math.max(rFWStVideo.getWidth(), rFWStVideo.getHeight());
        this.mWidth = rFWStVideo.getWidth();
        this.mHeight = rFWStVideo.getHeight();
        this.mVideoEncode = rFWStVideo.getVideoPrior();
        this.mRate = rFWStVideo.getVideoRate() / 1024;
        this.mResolutionLevel = getLevelFromShortSlide(this.mShortSide, RESOLUTION_SPLIT);
        this.mPlayLevel = getLevelFromShortSlide(this.mShortSide, PLAY_SPLIT);
        this.mLevelType = 8;
        this.mScore = rFWStVideo.getMediaQualityScore();
        tryToRefactorRate(this);
    }

    protected RFWVideoUrlBean(Parcel parcel) {
        this.mFormatId = parcel.readInt();
        this.mUrl = parcel.readString();
        this.mHost = parcel.readString();
        this.mShortSide = parcel.readInt();
        this.mLongSide = parcel.readInt();
        this.mVideoEncode = parcel.readInt();
        this.mRate = parcel.readInt();
        this.mResolutionLevel = parcel.readInt();
        this.mPlayLevel = parcel.readInt();
        this.mLevelType = parcel.readInt();
        this.mScore = parcel.readFloat();
    }
}
