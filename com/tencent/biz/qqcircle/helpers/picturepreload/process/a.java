package com.tencent.biz.qqcircle.helpers.picturepreload.process;

import android.os.Message;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class a {
    /* JADX INFO: Access modifiers changed from: protected */
    public FeedCloudMeta$StFeed a(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Object[])) {
            return null;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr.length == 0) {
            return null;
        }
        Object obj2 = objArr[0];
        if (!(obj2 instanceof FeedCloudMeta$StFeed)) {
            QLog.e("PIC_LOAD_QFSPicturePreloadBaseMsgProcess", 2, "[getOptionFormMsg] current msg obj not feed type.");
            return null;
        }
        return (FeedCloudMeta$StFeed) obj2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return "null";
        }
        return feedCloudMeta$StFeed.f398449id.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LoadState c(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Object[])) {
            return null;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr.length < 2) {
            return null;
        }
        Object obj2 = objArr[1];
        if (!(obj2 instanceof LoadState)) {
            QLog.e("PIC_LOAD_QFSPicturePreloadBaseMsgProcess", 2, "[getOptionFormMsg] current msg obj not load state type.");
            return null;
        }
        return (LoadState) obj2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Option d(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Object[])) {
            return null;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr.length == 0) {
            return null;
        }
        Object obj2 = objArr[0];
        if (!(obj2 instanceof Option)) {
            QLog.e("PIC_LOAD_QFSPicturePreloadBaseMsgProcess", 2, "[getOptionFormMsg] current msg obj not option type.");
            return null;
        }
        return (Option) obj2;
    }

    public abstract boolean e(Message message);
}
