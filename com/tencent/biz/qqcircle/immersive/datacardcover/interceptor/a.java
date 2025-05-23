package com.tencent.biz.qqcircle.immersive.datacardcover.interceptor;

import com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.qphone.base.util.QLog;
import e30.b;
import e30.d;
import feedcloud.FeedCloudRead$StGetMainPageCommDataRsp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003H\u0014J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\u0014R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/interceptor/a;", "Lcom/tencent/biz/qqcircle/immersive/personal/interceptor/QFSUIStateBaseManager;", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/interceptor/QFSGetCoverFeedRequest;", "Lfeedcloud/FeedCloudRead$StGetMainPageCommDataRsp;", "", "g", "req", "", "r", "rsp", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QAdRewardDefine$VideoParams.ISCACHE, "", "Le30/b;", "p", "c", "Ljava/lang/String;", "attachInfo", "<init>", "()V", "d", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a extends QFSUIStateBaseManager<QFSGetCoverFeedRequest, FeedCloudRead$StGetMainPageCommDataRsp> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String attachInfo = "";

    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    @NotNull
    public String g() {
        return "QFSGetCoverFeedUIStateManager";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    @NotNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public List<b> l(@NotNull FeedCloudRead$StGetMainPageCommDataRsp rsp, boolean isCache) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        String str = rsp.feedAttchInfo.get();
        if (str == null) {
            str = "";
        }
        this.attachInfo = str;
        QLog.d("QFSGetCoverFeedUIStateManager", 1, "parseDataFromRsp, isCache: " + isCache + ", attachInfo: " + str);
        ArrayList<b> b16 = d.b(rsp.vecFeed.get());
        Intrinsics.checkNotNullExpressionValue(b16, "transFormFeedListToBlockList(feeds)");
        return b16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean m(@NotNull FeedCloudRead$StGetMainPageCommDataRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        if (rsp.isFinish.get() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void n(@NotNull QFSGetCoverFeedRequest req) {
        Intrinsics.checkNotNullParameter(req, "req");
        boolean z16 = true;
        QLog.d("QFSGetCoverFeedUIStateManager", 1, "wrapperLoadMoreParams, attachInfo: " + this.attachInfo);
        if (this.attachInfo.length() <= 0) {
            z16 = false;
        }
        if (z16) {
            req.setAttachInfo(this.attachInfo);
        }
    }
}
