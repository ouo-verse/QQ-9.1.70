package com.qzone.common.activities.base;

import android.text.TextUtils;
import android.widget.ListAdapter;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
@Named("BaseFragmentVideoWindowPlayImp")
/* loaded from: classes39.dex */
public class af implements d5.af {
    @Inject
    public af() {
    }

    @Override // d5.af
    public void a(ListAdapter listAdapter, int i3) {
        VideoPlayInfo b16;
        boolean z16;
        ArrayList<VideoPlayInfo> arrayList = new ArrayList();
        if (listAdapter != null) {
            int count = listAdapter.getCount();
            int i16 = com.qzone.proxy.feedcomponent.model.r.f50426g;
            if (count <= i16) {
                i16 = listAdapter.getCount() - 1;
            }
            for (int i17 = 1; i17 < i16; i17++) {
                int i18 = i3 + i17;
                if (i18 >= listAdapter.getCount()) {
                    break;
                }
                try {
                    BusinessFeedData businessFeedData = (BusinessFeedData) listAdapter.getItem(i18);
                    if (businessFeedData != null && businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getVideoInfo() != null) {
                        b16 = com.qzone.proxy.feedcomponent.ui.c.b(businessFeedData, businessFeedData.getOriginalInfo().getVideoInfo());
                    } else {
                        b16 = (businessFeedData == null || businessFeedData.getVideoInfo() == null) ? null : com.qzone.proxy.feedcomponent.ui.c.b(businessFeedData, businessFeedData.getVideoInfo());
                    }
                    if (b16 != null && arrayList.size() > 0) {
                        for (VideoPlayInfo videoPlayInfo : arrayList) {
                            if (videoPlayInfo != null && !TextUtils.isEmpty(videoPlayInfo.videoId) && videoPlayInfo.videoId.equals(b16.videoId)) {
                                z16 = true;
                                break;
                            }
                        }
                    }
                    z16 = false;
                    if (b16 != null && !z16) {
                        arrayList.add(b16);
                    }
                    if (arrayList.size() >= com.qzone.proxy.feedcomponent.model.r.f50425f) {
                        break;
                    }
                } catch (Exception e16) {
                    QZLog.e("BaseFragmentVideoWindow", "onListViewScrollIdle exception: " + e16.toString());
                }
            }
        }
        if (arrayList.size() > 0) {
            com.qzone.proxy.feedcomponent.model.r.e().f(arrayList);
        }
    }

    @Override // d5.af
    public void onResume() {
    }
}
