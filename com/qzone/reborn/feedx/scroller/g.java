package com.qzone.reborn.feedx.scroller;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.feedx.viewmodel.q;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QZoneConfigHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static volatile g f55684a;

    public static g f() {
        if (f55684a == null) {
            synchronized (g.class) {
                if (f55684a == null) {
                    f55684a = new g();
                }
            }
        }
        return f55684a;
    }

    public static void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(str).setPredecode(false).setPriority(1));
    }

    private void l(final BusinessFeedData businessFeedData) {
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.qzone.reborn.feedx.scroller.e
            @Override // java.lang.Runnable
            public final void run() {
                g.i(BusinessFeedData.this);
            }
        });
    }

    private void m(final BusinessFeedData businessFeedData) {
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.qzone.reborn.feedx.scroller.f
            @Override // java.lang.Runnable
            public final void run() {
                g.j(BusinessFeedData.this);
            }
        });
    }

    private static void n(final CommonGridItemData commonGridItemData) {
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.qzone.reborn.feedx.scroller.d
            @Override // java.lang.Runnable
            public final void run() {
                g.k(CommonGridItemData.this);
            }
        });
    }

    public void e(List<BusinessFeedData> list, UIStateData<List<BusinessFeedData>> uIStateData) {
        int startPosition;
        if (QZoneConfigHelper.u0()) {
            if (!bl.b(list) && q.T <= 5) {
                if (uIStateData != null && uIStateData.getLatestModifyRecord() != null && (startPosition = uIStateData.getLatestModifyRecord().getStartPosition()) > 0 && startPosition < list.size()) {
                    list = list.subList(startPosition, list.size());
                }
                for (BusinessFeedData businessFeedData : list) {
                    if ((h(businessFeedData) || businessFeedData.isCircleFriendLikeVideoRecomm() || businessFeedData.isVideo()) && !businessFeedData.isMixVideoPic()) {
                        m(businessFeedData);
                    } else if (businessFeedData.getPictureInfo() != null) {
                        l(businessFeedData);
                    }
                }
                return;
            }
            QLog.d("QZoneFeedPicPreloadManager", 1, "checkPreloadPicture  return , sLastFeedIndex = " + q.T);
        }
    }

    private boolean h(BusinessFeedData businessFeedData) {
        return businessFeedData != null && com.qzone.reborn.feedx.itemview.d.d(businessFeedData) && com.qzone.reborn.feedx.itemview.d.b(businessFeedData.getOriginalInfo()) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(BusinessFeedData businessFeedData) {
        String str;
        VideoInfo videoInfo;
        PictureUrl pictureUrl;
        if (businessFeedData == null || businessFeedData.getPictureInfo() == null || bl.b(businessFeedData.getPictureInfo().pics)) {
            return;
        }
        Iterator<PictureItem> it = businessFeedData.getPictureInfo().pics.iterator();
        while (it.hasNext()) {
            PictureItem next = it.next();
            if (next != null) {
                if (next.videoflag == 1 && (videoInfo = next.videodata) != null && (pictureUrl = videoInfo.coverUrl) != null) {
                    str = pictureUrl.url;
                } else {
                    PictureUrl pictureUrl2 = next.currentUrl;
                    str = pictureUrl2 != null ? pictureUrl2.url : null;
                }
                g(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getVideoInfo() == null || businessFeedData.getVideoInfo().coverUrl == null) {
            return;
        }
        g(businessFeedData.getVideoInfo().coverUrl.url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(CommonGridItemData commonGridItemData) {
        CommonStMedia commonStMedia;
        CommonStPicUrl c16;
        if (commonGridItemData == null || (commonStMedia = commonGridItemData.picMedia) == null || (c16 = aa.e.c(commonStMedia)) == null || TextUtils.isEmpty(c16.getUrl())) {
            return;
        }
        g(c16.getUrl());
    }

    public void d(int i3, List<CommonGridItemData> list, boolean z16) {
        if (list == null || bl.b(list)) {
            return;
        }
        int max = Math.max(i3 - 1, 0);
        if (z16) {
            if (max > 0 && max < list.size()) {
                list = new ArrayList(list.subList(0, list.size() - max));
            }
            Collections.reverse(list);
        } else if (max > 0 && max < list.size()) {
            list = new ArrayList(list.subList(max, list.size()));
        }
        for (CommonGridItemData commonGridItemData : list) {
            if (commonGridItemData.getItemType() == CommonGridItemData.ItemType.PIC_SECTION_ITEM) {
                n(commonGridItemData);
            }
        }
    }
}
