package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.player;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.QAdBaseVideoView;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    public static QAdBaseVideoView.SkipCause a(int i3) {
        if (i3 != 1) {
            return QAdBaseVideoView.SkipCause.OTHER_REASON;
        }
        return QAdBaseVideoView.SkipCause.USER_RETURN;
    }
}
