package oe;

import android.content.Intent;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qzone.reborn.feedpro.event.QzoneFeedProUserHomeRefreshEvent;
import com.qzone.reborn.feedpro.utils.ao;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedTopManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.UnsetTopFeedRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.QzoneBitCheckUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\"\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016\u00a8\u0006\u001f"}, d2 = {"Loe/t;", "Lcom/qzone/reborn/share/a;", "Lre/b;", ReportConstant.COSTREPORT_PREFIX, "", "r", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", CommonConstant.KEY_UNION_ID, "Lcom/qzone/reborn/share/e;", "shareContext", "", "t", "", "", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "j", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "l", "<init>", "()V", "c", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class t extends com.qzone.reborn.share.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"oe/t$b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/UnsetTopFeedRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements DataCallback<UnsetTopFeedRsp> {
        b() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(UnsetTopFeedRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QQToastUtil.showQQToastInUiThread(5, "\u53d6\u6d88\u7f6e\u9876\u6210\u529f");
            SimpleEventBus.getInstance().dispatchEvent(new QzoneFeedProUserHomeRefreshEvent());
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            boolean z16 = true;
            QLog.e("QzoneFeedProDetailShareUnSetTopAction", 1, "setUnTop errorcode:" + errorCode + ", errorMsg:" + errorMsg);
            if (errorMsg != null && errorMsg.length() != 0) {
                z16 = false;
            }
            if (z16) {
                errorMsg = "\u53d6\u6d88\u7f6e\u9876\u5931\u8d25";
            }
            QQToastUtil.showQQToastInUiThread(4, errorMsg);
        }
    }

    private final boolean r() {
        CommonFeed S1;
        CommonCellCommon cellCommon;
        re.b s16 = s();
        if (s16 == null || (S1 = s16.S1()) == null || (cellCommon = S1.getCellCommon()) == null) {
            return false;
        }
        long featureFlag = cellCommon.getFeatureFlag();
        ao aoVar = ao.f54312a;
        re.b s17 = s();
        return aoVar.d(s17 != null ? s17.S1() : null, 1) && QzoneBitCheckUtil.INSTANCE.checkBitEnabled(featureFlag, 1);
    }

    private final re.b s() {
        com.qzone.reborn.share.i viewModel = getViewModel();
        if (viewModel instanceof re.b) {
            return (re.b) viewModel;
        }
        return null;
    }

    private final void t(CommonUnionID unionId, com.qzone.reborn.share.e shareContext) {
        new QzoneFeedTopManager().unsetTopFeedTop(unionId, new b());
    }

    @Override // com.qzone.reborn.share.a
    public void b(com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        CommonCellCommon cellCommon;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("QzoneFeedProDetailShareUnSetTopAction", 2, "share clicked");
        re.b s16 = s();
        CommonUnionID commonUnionID = null;
        CommonFeed S1 = s16 != null ? s16.S1() : null;
        if (S1 != null && (cellCommon = S1.getCellCommon()) != null) {
            commonUnionID = cellCommon.getUnionId();
        }
        if (commonUnionID != null) {
            Intrinsics.checkNotNull(S1);
            CommonCellCommon cellCommon2 = S1.getCellCommon();
            Intrinsics.checkNotNull(cellCommon2);
            CommonUnionID unionId = cellCommon2.getUnionId();
            Intrinsics.checkNotNull(unionId);
            t(unionId, shareContext);
            return;
        }
        QLog.e("QzoneFeedProDetailShareUnSetTopAction", 1, "unionId is null");
    }

    @Override // com.qzone.reborn.share.a
    public QQShareActionManagerV2.ShareLine f() {
        return QQShareActionManagerV2.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.share.a
    public List<String> g() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("unpin");
        return arrayListOf;
    }

    @Override // com.qzone.reborn.share.a
    public boolean j(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        re.b s16 = s();
        return (s16 != null ? s16.U1() : false) && r();
    }

    @Override // com.qzone.reborn.share.a
    public void l(int requestCode, int resultCode, Intent data) {
        super.l(requestCode, resultCode, data);
    }
}
