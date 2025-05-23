package com.tencent.biz.qqcircle.helpers.picturepreload.process;

import android.os.Message;
import android.util.Pair;
import android.util.Size;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.utils.ab;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.libra.request.Option;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import u30.e;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends a {
    private Option f(String str, boolean z16, int i3, Size size) {
        return Option.obtain().setUrl(str).setFromPreLoad(true).setPredecode(z16).setRequestWidth(size.getWidth()).setRequestHeight(size.getHeight()).setPriority(i3);
    }

    private Size g(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, int i16) {
        Pair<Integer, Integer> a16 = ab.a(feedCloudMeta$StFeed, i3, i16);
        return new Size(((Integer) a16.first).intValue(), ((Integer) a16.second).intValue());
    }

    private void h(List<Option> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            return;
        }
        u30.d d16 = u30.d.d();
        Iterator<Option> it = list.iterator();
        while (it.hasNext()) {
            d16.j(it.next());
        }
    }

    private void i(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        List<FeedCloudMeta$StImage> list = feedCloudMeta$StFeed.images.get();
        if (RFSafeListUtils.isEmpty(list)) {
            return;
        }
        e g16 = u30.d.d().g();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            FeedCloudMeta$StImage feedCloudMeta$StImage = list.get(i3);
            if (feedCloudMeta$StImage != null) {
                arrayList.add(f(feedCloudMeta$StImage.picUrl.get(), false, g16.a(), g(feedCloudMeta$StFeed, feedCloudMeta$StImage.width.get(), feedCloudMeta$StImage.height.get())));
            }
        }
        QLog.d("PIC_LOAD_QFSPicturePreloadCreateProcess", 1, "[preloadVideoFeed] feed id: " + b(feedCloudMeta$StFeed) + " | create preload video pic size: " + arrayList.size());
        h(arrayList);
    }

    private void j(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Option f16 = f(feedCloudMeta$StFeed.cover.picUrl.get(), true, 1, g(feedCloudMeta$StFeed, feedCloudMeta$StFeed.video.width.get(), feedCloudMeta$StFeed.video.height.get()));
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(f16);
        h(arrayList);
    }

    @Override // com.tencent.biz.qqcircle.helpers.picturepreload.process.a
    public boolean e(Message message) {
        FeedCloudMeta$StFeed a16 = a(message);
        if (a16 == null) {
            QLog.d("PIC_LOAD_QFSPicturePreloadCreateProcess", 1, "[handlerMessage] current feed should not be null.");
            return false;
        }
        if (a16.type.get() == 2) {
            i(a16);
        } else if (a16.type.get() == 3) {
            j(a16);
        }
        return true;
    }
}
