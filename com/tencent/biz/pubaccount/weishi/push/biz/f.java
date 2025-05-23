package com.tencent.biz.pubaccount.weishi.push.biz;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.biz.pubaccount.weishi.WSOpenHomeThenVideoParams;
import com.tencent.biz.pubaccount.weishi.l;
import com.tencent.biz.pubaccount.weishi.main.a;
import com.tencent.biz.pubaccount.weishi.push.WSPushCommentModel;
import com.tencent.biz.pubaccount.weishi.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/push/biz/f;", "Lcom/tencent/biz/pubaccount/weishi/push/biz/a;", "Lcom/tencent/biz/pubaccount/weishi/push/WSRedDotPushMsg;", "Lcom/tencent/biz/pubaccount/weishi/push/WSPushStrategyInfo;", "Landroid/content/Context;", "context", "strategyInfo", "", "b", "pushInfo", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/push/WSRedDotPushMsg;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class f extends a<WSRedDotPushMsg, WSPushStrategyInfo> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(WSRedDotPushMsg pushInfo) {
        super(pushInfo);
        Intrinsics.checkNotNullParameter(pushInfo, "pushInfo");
    }

    @Override // com.tencent.biz.pubaccount.weishi.push.biz.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(Context context, WSPushStrategyInfo strategyInfo) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(strategyInfo, "strategyInfo");
        String str3 = ((WSRedDotPushMsg) this.f81348a).mFeedIds;
        if (str3 == null) {
            return false;
        }
        WSPushCommentModel wSPushCommentModel = strategyInfo.mWSPushCommentModel;
        boolean z16 = wSPushCommentModel != null ? wSPushCommentModel.getCom.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams.KEY_IS_SHOW_COMMENT_PANEL java.lang.String() : false;
        if (wSPushCommentModel == null || (str = wSPushCommentModel.getCom.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams.KEY_COMMENT_ID java.lang.String()) == null) {
            str = "";
        }
        if (wSPushCommentModel == null || (str2 = wSPushCommentModel.getCom.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams.KEY_REPLY_ID java.lang.String()) == null) {
            str2 = "";
        }
        a.C0826a.a(new l(context, 1, "from_open_home_then_video").l(new WSOpenHomeThenVideoParams(str3, "", new WSAutoShowCommentParams(z16, str, str2), "aio_pre_open_home")).j(str3));
        return true;
    }
}
