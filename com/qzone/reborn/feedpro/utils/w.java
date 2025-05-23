package com.qzone.reborn.feedpro.utils;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonVideo;
import com.tencent.libra.request.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J,\u0010\r\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t2\u0014\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0018\u00010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/w;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "", "d", "", "url", "c", "", "dataList", "Lcom/tencent/richframework/data/base/UIStateData;", "uiStateData", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public static final w f54369a = new w();

    w() {
    }

    private final void d(final CommonFeed feedData) {
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.qzone.reborn.feedpro.utils.v
            @Override // java.lang.Runnable
            public final void run() {
                w.e(CommonFeed.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(CommonFeed commonFeed) {
        CommonCellMedia cellMedia;
        List<CommonMedia> mediaItems;
        CommonImage image;
        CommonPicUrl e16;
        CommonImage cover;
        CommonPicUrl e17;
        if (commonFeed == null || (cellMedia = commonFeed.getCellMedia()) == null || (mediaItems = cellMedia.getMediaItems()) == null) {
            return;
        }
        for (CommonMedia commonMedia : mediaItems) {
            Integer type = commonMedia.getType();
            String str = null;
            if (type != null && type.intValue() == 1) {
                CommonVideo video = commonMedia.getVideo();
                if (video != null && (cover = video.getCover()) != null && (e17 = xd.d.e(cover)) != null) {
                    str = e17.getUrl();
                }
            } else if (type != null && type.intValue() == 0 && (image = commonMedia.getImage()) != null && (e16 = xd.d.e(image)) != null) {
                str = e16.getUrl();
            }
            f54369a.c(str);
        }
    }

    public final void b(List<CommonFeed> dataList, UIStateData<List<CommonFeed>> uiStateData) {
        List<CommonMedia> mediaItems;
        int startPosition;
        if (uiStateData != null && uiStateData.getLatestModifyRecord() != null && (startPosition = uiStateData.getLatestModifyRecord().getStartPosition()) > 0) {
            Intrinsics.checkNotNull(dataList);
            if (startPosition < dataList.size()) {
                dataList = dataList.subList(startPosition, dataList.size());
            }
        }
        Intrinsics.checkNotNull(dataList);
        for (CommonFeed commonFeed : dataList) {
            CommonCellMedia cellMedia = commonFeed.getCellMedia();
            boolean z16 = false;
            if (cellMedia != null && (mediaItems = cellMedia.getMediaItems()) != null && (!mediaItems.isEmpty())) {
                z16 = true;
            }
            if (z16) {
                d(commonFeed);
            }
        }
    }

    private final void c(String url) {
        String str = !(url == null || url.length() == 0) ? url : null;
        if (str != null) {
            Option obtain = Option.obtain();
            obtain.setUrl(str);
            obtain.setPredecode(false);
            obtain.setPriority(1);
            com.tencent.mobileqq.qzone.picload.c.a().h(obtain);
            QLog.d("QzoneFeedProPicPreloadManager", 1, "handlePreloadSinglePic  url = " + url);
        }
    }
}
