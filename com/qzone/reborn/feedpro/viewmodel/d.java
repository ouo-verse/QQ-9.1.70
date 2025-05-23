package com.qzone.reborn.feedpro.viewmodel;

import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellTitle;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedDetailManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.impl.ChatsRevealApiImpl;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR#\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/feedpro/viewmodel/d;", "Lcom/qzone/reborn/base/n;", "Landroid/content/Intent;", "intent", "", "O1", "P1", "", "getLogTag", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedDetailManager;", "i", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedDetailManager;", "feedDetailManager", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "N1", "()Landroidx/lifecycle/MutableLiveData;", "feedDetailData", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", CommonConstant.KEY_UNION_ID, "D", "Ljava/lang/String;", ZPlanPublishSource.FROM_SCHEME, "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d extends com.qzone.reborn.base.n {

    /* renamed from: C, reason: from kotlin metadata */
    private CommonUnionID unionId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QzoneFeedDetailManager feedDetailManager = new QzoneFeedDetailManager();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<UIStateData<CommonFeed>> feedDetailData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private String scheme = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/d$b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements DataCallback<CommonFeed> {
        b() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(CommonFeed commonFeed, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(commonFeed, "commonFeed");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            d dVar = d.this;
            CommonCellCommon cellCommon = commonFeed.getCellCommon();
            dVar.unionId = cellCommon != null ? cellCommon.getUnionId() : null;
            UIStateData<CommonFeed> obtainSuccess = UIStateData.obtainSuccess(false);
            obtainSuccess.setData(false, commonFeed);
            d.this.N1().setValue(obtainSuccess);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            UIStateData<CommonFeed> obtainError = UIStateData.obtainError(errorMsg);
            obtainError.setRetCode(errorCode);
            d.this.N1().setValue(obtainError);
        }
    }

    public final MutableLiveData<UIStateData<CommonFeed>> N1() {
        return this.feedDetailData;
    }

    public final void P1() {
        QzoneFeedDetailManager.fetchFeedDetail$default(this.feedDetailManager, this.unionId, this.scheme, null, new b(), 4, null);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFeedProBlogDetailViewModel";
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
    
        if ((r6.length() > 0) == true) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void O1(Intent intent) {
        boolean z16 = true;
        if (intent == null) {
            QLog.e("QzoneFeedProBlogDetailViewModel", 1, "parseIntent: intent is null");
            return;
        }
        String stringExtra = intent.getStringExtra("context_hash_code");
        com.qzone.reborn.feedpro.utils.b bVar = com.qzone.reborn.feedpro.utils.b.f54315a;
        this.unionId = (CommonUnionID) bVar.a("key_common_union_id", stringExtra, CommonUnionID.class);
        CommonFeed commonFeed = (CommonFeed) bVar.a("key_common_feed", stringExtra, CommonFeed.class);
        String stringExtra2 = intent.getStringExtra(ChatsRevealApiImpl.KEY_JUMP_SCHEME);
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.scheme = stringExtra2;
        if (commonFeed != null) {
            CommonCellTitle cellTitle = commonFeed.getCellTitle();
            if (cellTitle != null && (r6 = cellTitle.getTitleUrl()) != null) {
            }
            z16 = false;
            if (z16) {
                CommonCellCommon cellCommon = commonFeed.getCellCommon();
                this.unionId = cellCommon != null ? cellCommon.getUnionId() : null;
                UIStateData<CommonFeed> obtainSuccess = UIStateData.obtainSuccess(false);
                obtainSuccess.setData(false, commonFeed);
                this.feedDetailData.setValue(obtainSuccess);
                return;
            }
        }
        P1();
    }
}
