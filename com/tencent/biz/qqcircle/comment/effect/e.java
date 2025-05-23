package com.tencent.biz.qqcircle.comment.effect;

import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleEnvHub$CommentActivityInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private a f83580a;

    public static a a(@NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout, @NonNull String str, @NonNull String str2, boolean z16, @NonNull List<String> list) {
        QQCircleEnvHub$CommentActivityInfo g16 = QFSCommentEffectUtil.g(str2, z16, list);
        if (g16 == null) {
            RFWLog.d("QFSCommentEffectController", RFWLog.USR, "handleCommentOrReplyAdded false: commentActivityInfo = null");
            return null;
        }
        if (!QFSCommentEffectUtil.d(g16)) {
            RFWLog.d("QFSCommentEffectController", RFWLog.USR, "handleCommentOrReplyAdded false: checkPreloadSuccess false");
            return null;
        }
        int i3 = g16.activityStyle.get();
        if (i3 != 0) {
            if (i3 != 1) {
                return null;
            }
            return new QFSCommentFireworksEffect(g16, frameLayout, relativeLayout, str, str2);
        }
        return new QFSCommentRainEffect(g16, frameLayout, relativeLayout, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070 A[LOOP:0: B:25:0x006a->B:27:0x0070, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d b(@NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout, @Nullable FeedCloudMeta$StComment feedCloudMeta$StComment, @Nullable FeedCloudMeta$StReply feedCloudMeta$StReply, @NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String str;
        PBStringField pBStringField;
        String str2;
        PBStringField pBStringField2;
        String str3;
        String str4;
        boolean z16;
        boolean z17;
        boolean z18;
        Iterator<FeedCloudMeta$StTagInfo> it;
        a aVar;
        a a16;
        if (feedCloudMeta$StComment != null) {
            pBStringField = feedCloudMeta$StComment.f398447id;
        } else if (feedCloudMeta$StReply == null) {
            str = "";
            if (feedCloudMeta$StComment == null) {
                pBStringField2 = feedCloudMeta$StComment.content;
            } else {
                if (feedCloudMeta$StReply == null) {
                    str2 = "";
                    if (str == null) {
                        str3 = "";
                    } else {
                        str3 = str;
                    }
                    if (str2 == null) {
                        str4 = "";
                    } else {
                        str4 = str2;
                    }
                    if (feedCloudMeta$StComment == null && !TextUtils.isEmpty(feedCloudMeta$StComment.commentPic.picUrl.get())) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (feedCloudMeta$StReply == null && !TextUtils.isEmpty(feedCloudMeta$StReply.replyPic.picUrl.get())) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z16 && !z17) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    ArrayList arrayList = new ArrayList();
                    it = feedCloudMeta$StFeed.tagInfos.get().iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().tagId.get());
                    }
                    aVar = this.f83580a;
                    if (aVar != null) {
                        if (!aVar.isRunning()) {
                            this.f83580a.stop();
                        } else {
                            RFWLog.d("QFSCommentEffectController", RFWLog.USR, "handleCommentOrReplyAdded false: isRunning");
                            return null;
                        }
                    }
                    a16 = a(frameLayout, relativeLayout, str3, str4, z18, arrayList);
                    this.f83580a = a16;
                    if (a16 == null) {
                        RFWLog.d("QFSCommentEffectController", RFWLog.USR, "handleCommentOrReplyAdded false: mCommentEffect = null");
                        return null;
                    }
                    a16.start();
                    return new d(this.f83580a.b(), this.f83580a.getKeyword(), this.f83580a.a());
                }
                pBStringField2 = feedCloudMeta$StReply.content;
            }
            str2 = pBStringField2.get();
            if (str == null) {
            }
            if (str2 == null) {
            }
            if (feedCloudMeta$StComment == null) {
            }
            z16 = false;
            if (feedCloudMeta$StReply == null) {
            }
            z17 = false;
            if (z16) {
            }
            z18 = true;
            ArrayList arrayList2 = new ArrayList();
            it = feedCloudMeta$StFeed.tagInfos.get().iterator();
            while (it.hasNext()) {
            }
            aVar = this.f83580a;
            if (aVar != null) {
            }
            a16 = a(frameLayout, relativeLayout, str3, str4, z18, arrayList2);
            this.f83580a = a16;
            if (a16 == null) {
            }
        } else {
            pBStringField = feedCloudMeta$StReply.f398460id;
        }
        str = pBStringField.get();
        if (feedCloudMeta$StComment == null) {
        }
        str2 = pBStringField2.get();
        if (str == null) {
        }
        if (str2 == null) {
        }
        if (feedCloudMeta$StComment == null) {
        }
        z16 = false;
        if (feedCloudMeta$StReply == null) {
        }
        z17 = false;
        if (z16) {
        }
        z18 = true;
        ArrayList arrayList22 = new ArrayList();
        it = feedCloudMeta$StFeed.tagInfos.get().iterator();
        while (it.hasNext()) {
        }
        aVar = this.f83580a;
        if (aVar != null) {
        }
        a16 = a(frameLayout, relativeLayout, str3, str4, z18, arrayList22);
        this.f83580a = a16;
        if (a16 == null) {
        }
    }

    public void c() {
        a aVar = this.f83580a;
        if (aVar != null) {
            aVar.stop();
            this.f83580a = null;
        }
    }
}
