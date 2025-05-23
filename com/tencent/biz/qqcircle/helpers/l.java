package com.tencent.biz.qqcircle.helpers;

import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.tencent.biz.qqcircle.events.QFSECommerceEvent;
import com.tencent.biz.qqcircle.events.QFSGoodsUpdateEvent;
import com.tencent.biz.qqcircle.utils.be;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.richframework.text.rich.parser.RichTextClickableImageSpanParser;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StCommentExtraInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static volatile l f84632a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Function1<JSONObject, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f84633d;

        a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f84633d = feedCloudMeta$StFeed;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(JSONObject jSONObject) {
            QFSECommerceEvent qFSECommerceEvent = new QFSECommerceEvent();
            qFSECommerceEvent.setFeedId(this.f84633d.f398449id.get());
            if (jSONObject.optInt("code") == 1) {
                qFSECommerceEvent.setType(QFSECommerceEvent.TYPE_CLOSE_ECOMMERCE_PAGE);
            } else {
                qFSECommerceEvent.setType(QFSECommerceEvent.TYPE_ADD_ECOMMERCE_GOODS);
                qFSECommerceEvent.setEcommerceBean((be) new Gson().fromJson(jSONObject.toString(), be.class));
                l.this.b(this.f84633d);
            }
            SimpleEventBus.getInstance().dispatchEvent(qFSECommerceEvent);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements Function1<JSONObject, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f84635d;

        b(boolean z16) {
            this.f84635d = z16;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(JSONObject jSONObject) {
            if (this.f84635d && jSONObject.optInt("code") == 1) {
                QFSECommerceEvent qFSECommerceEvent = new QFSECommerceEvent();
                qFSECommerceEvent.setType(QFSECommerceEvent.TYPE_CLOSE_ECOMMERCE_PAGE);
                SimpleEventBus.getInstance().dispatchEvent(qFSECommerceEvent);
            }
            return null;
        }
    }

    l() {
    }

    private boolean d(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, int i3) {
        FeedCloudMeta$StCommentExtraInfo feedCloudMeta$StCommentExtraInfo;
        if (feedCloudMeta$StComment != null || feedCloudMeta$StReply != null || (feedCloudMeta$StCommentExtraInfo = feedCloudMeta$StFeed.commentExtraInfo) == null) {
            return false;
        }
        List<Integer> list = feedCloudMeta$StCommentExtraInfo.privileges.get();
        if (RFSafeListUtils.isEmpty(list)) {
            return false;
        }
        return list.contains(Integer.valueOf(i3));
    }

    public static l e() {
        if (f84632a == null) {
            synchronized (l.class) {
                if (f84632a == null) {
                    f84632a = new l();
                }
            }
        }
        return f84632a;
    }

    public void a(@NonNull FeedCloudMeta$StComment feedCloudMeta$StComment, @NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StComment.goodsInfo.has()) {
            b(feedCloudMeta$StFeed);
        }
    }

    public void b(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed.commentExtraInfo == null) {
            FeedCloudMeta$StCommentExtraInfo feedCloudMeta$StCommentExtraInfo = new FeedCloudMeta$StCommentExtraInfo();
            feedCloudMeta$StFeed.commentExtraInfo = feedCloudMeta$StCommentExtraInfo;
            feedCloudMeta$StCommentExtraInfo.setHasFlag(true);
        }
        List<Integer> list = feedCloudMeta$StFeed.commentExtraInfo.privileges.get();
        if (!list.contains(5)) {
            list.add(5);
            SimpleEventBus.getInstance().dispatchEvent(new QFSGoodsUpdateEvent());
        }
    }

    public boolean c(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        return d(feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudMeta$StReply, 1);
    }

    public String f(String str) {
        return RichTextClickableImageSpanParser.generateContent(QCircleSkinHelper.getInstance().getUrl("qvideo_feed_comment_tag_productlink"), 66, 16, 0, str);
    }

    public void g(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleScheme("mqqapi://ecommerce/open?target=7&channel=2", new a(feedCloudMeta$StFeed));
    }

    public boolean h(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        if (d(feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudMeta$StReply, 1) && !d(feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudMeta$StReply, 5)) {
            return true;
        }
        return false;
    }

    public void i(String str) {
        j(str, false);
    }

    public void j(String str, boolean z16) {
        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleScheme(str, new b(z16));
    }

    public void k(@NonNull FeedCloudMeta$StComment feedCloudMeta$StComment, @NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StComment.goodsInfo.has()) {
            l(feedCloudMeta$StFeed);
        }
    }

    public void l(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StCommentExtraInfo feedCloudMeta$StCommentExtraInfo = feedCloudMeta$StFeed.commentExtraInfo;
        if (feedCloudMeta$StCommentExtraInfo == null) {
            return;
        }
        List<Integer> list = feedCloudMeta$StCommentExtraInfo.privileges.get();
        if (RFSafeListUtils.isEmpty(list)) {
            return;
        }
        list.remove((Object) 5);
        SimpleEventBus.getInstance().dispatchEvent(new QFSGoodsUpdateEvent());
    }

    public int m(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return i3;
                }
                return 6;
            }
            return 7;
        }
        return 5;
    }
}
