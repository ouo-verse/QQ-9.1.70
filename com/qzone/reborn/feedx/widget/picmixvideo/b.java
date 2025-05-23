package com.qzone.reborn.feedx.widget.picmixvideo;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import common.config.service.QZoneConfigHelper;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b {
    public static Pair<Integer, Integer> c(Context context, String str, PictureUrl pictureUrl, int i3) {
        if (!QZoneConfigHelper.S0()) {
            return d(context, pictureUrl, i3);
        }
        if (pictureUrl == null) {
            return new Pair<>(0, 0);
        }
        int i16 = pictureUrl.width;
        int i17 = pictureUrl.height;
        if (i3 <= 0) {
            i3 = pl.a.f426446a.l(context);
        }
        float f16 = i3;
        int i18 = (int) (0.42f * f16);
        if (i16 > 0 && i17 > 0) {
            float f17 = (i16 * 1.0f) / i17;
            if (i16 < 225 && i17 < 225) {
                i3 = i18;
            } else if (f17 < 3.0f) {
                if (f17 > 1.0f && f17 < 3.0f) {
                    i18 = (int) (f16 / f17);
                } else if (f17 == 1.0f) {
                    i18 = i3;
                } else if (f17 < 0.33333334f || f17 >= 1.0f) {
                    i18 = i3;
                    i3 = i18;
                } else {
                    i18 = i3;
                    i3 = (int) (f16 * f17);
                }
            }
            return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i18));
        }
        Pair<Integer, Integer> c16 = a.c(context, g(str, pictureUrl));
        if (c16 != null && ((Integer) c16.first).intValue() > 0 && ((Integer) c16.second).intValue() > 0) {
            pictureUrl.width = ((Integer) c16.first).intValue();
            pictureUrl.height = ((Integer) c16.second).intValue();
            return new Pair<>((Integer) c16.first, (Integer) c16.second);
        }
        return new Pair<>(Integer.valueOf(i18), Integer.valueOf(i18));
    }

    public static String g(String str, PictureUrl pictureUrl) {
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb5.append(str);
        }
        if (pictureUrl != null) {
            sb5.append("_");
            sb5.append(pictureUrl.url);
        }
        return sb5.toString();
    }

    public static Pair<Integer, Integer> d(Context context, PictureUrl pictureUrl, int i3) {
        int i16;
        if (pictureUrl == null) {
            return new Pair<>(0, 0);
        }
        int i17 = pictureUrl.width;
        int i18 = pictureUrl.height;
        if (i3 <= 0) {
            i3 = pl.a.f426446a.l(context);
        }
        float f16 = i3;
        int i19 = (int) (0.5f * f16);
        if (i17 > 0 && i18 > 0) {
            if (i17 >= i19 || i18 >= i19) {
                float f17 = i18;
                float f18 = i17;
                if (f17 / f18 > 1.1d) {
                    i3 = (int) (f16 * 0.58f);
                    i16 = (int) (i3 * 1.3333334f);
                } else {
                    i16 = ((double) (f18 / f17)) > 1.1d ? (int) (f16 * 0.75f) : i3;
                }
            } else {
                i16 = i19;
                i3 = i16;
            }
            return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
        }
        Pair<Integer, Integer> c16 = a.c(context, pictureUrl.url);
        if (c16 != null && ((Integer) c16.first).intValue() > 0 && ((Integer) c16.second).intValue() > 0) {
            pictureUrl.width = ((Integer) c16.first).intValue();
            pictureUrl.height = ((Integer) c16.second).intValue();
            return new Pair<>((Integer) c16.first, (Integer) c16.second);
        }
        return new Pair<>(Integer.valueOf(i19), Integer.valueOf(i19));
    }

    public static Pair<Integer, Integer> e(Context context, VideoInfo videoInfo) {
        int l3;
        float f16;
        float f17;
        if (videoInfo == null) {
            return new Pair<>(0, 0);
        }
        if (videoInfo.height / videoInfo.width > 1.1d) {
            l3 = (int) (pl.a.f426446a.l(context) * 0.58f);
            f16 = l3;
            f17 = 1.3333334f;
        } else {
            l3 = pl.a.f426446a.l(context);
            f16 = l3;
            f17 = 0.5625f;
        }
        return new Pair<>(Integer.valueOf(l3), Integer.valueOf((int) (f16 * f17)));
    }

    public static PictureUrl h(PictureItem pictureItem) {
        if (pictureItem == null) {
            return null;
        }
        PictureUrl pictureUrl = pictureItem.currentUrl;
        if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
            return pictureItem.currentUrl;
        }
        PictureUrl pictureUrl2 = pictureItem.bigUrl;
        if (pictureUrl2 != null && !TextUtils.isEmpty(pictureUrl2.url)) {
            return pictureItem.bigUrl;
        }
        PictureUrl pictureUrl3 = pictureItem.downloadUrl;
        if (pictureUrl3 != null && !TextUtils.isEmpty(pictureUrl3.url)) {
            return pictureItem.downloadUrl;
        }
        PictureUrl pictureUrl4 = pictureItem.originUrl;
        if (pictureUrl4 == null || TextUtils.isEmpty(pictureUrl4.url)) {
            return null;
        }
        return pictureItem.originUrl;
    }

    public static void a(Context context, BusinessFeedData businessFeedData, ViewGroup.LayoutParams layoutParams, PictureUrl pictureUrl, int i3) {
        if (layoutParams == null || pictureUrl == null) {
            return;
        }
        Pair<Integer, Integer> c16 = c(context, businessFeedData.getFeedCommInfo().feedskey, pictureUrl, i3);
        layoutParams.width = ((Integer) c16.first).intValue();
        layoutParams.height = ((Integer) c16.second).intValue();
    }

    public static void b(Context context, ViewGroup.LayoutParams layoutParams, VideoInfo videoInfo) {
        if (layoutParams == null || videoInfo == null) {
            return;
        }
        Pair<Integer, Integer> e16 = e(context, videoInfo);
        layoutParams.width = ((Integer) e16.first).intValue();
        layoutParams.height = ((Integer) e16.second).intValue();
    }

    public static Pair<Integer, Integer> f(int i3, int i16) {
        int i17;
        if (i16 != 2 && i16 != 4) {
            i17 = (i3 - (QZonePicMixVideoView.F * 2)) / 3;
        } else {
            i17 = (i3 - QZonePicMixVideoView.F) / 2;
        }
        return new Pair<>(Integer.valueOf(i17), Integer.valueOf(i17));
    }
}
