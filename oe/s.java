package oe;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.reborn.feedpro.event.QzoneFeedProUserHomeRefreshEvent;
import com.qzone.reborn.feedpro.utils.ao;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedTopManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.SetTopFeedRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.QzoneBitCheckUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.api.QZoneContant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004J\"\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016R\"\u0010#\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Loe/s;", "Lcom/qzone/reborn/share/a;", "Lre/b;", "t", "Lcom/qzone/reborn/share/e;", "shareContext", "", "v", HippyTKDListViewAdapter.X, "", ReportConstant.COSTREPORT_PREFIX, "j", "", "", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", CommonConstant.KEY_UNION_ID, "u", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "l", "c", "Z", "getMCanOpenVip", "()Z", "setMCanOpenVip", "(Z)V", "mCanOpenVip", "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class s extends com.qzone.reborn.share.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mCanOpenVip = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"oe/s$b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/SetTopFeedRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements DataCallback<SetTopFeedRsp> {
        b() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(SetTopFeedRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QQToastUtil.showQQToastInUiThread(5, "\u7f6e\u9876\u6210\u529f");
            SimpleEventBus.getInstance().dispatchEvent(new QzoneFeedProUserHomeRefreshEvent());
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            boolean z16 = true;
            QLog.e("QzoneFeedProDetailShareTopAction", 1, "setTop errorcode:" + errorCode + ", errorMsg:" + errorMsg);
            if (errorMsg != null && errorMsg.length() != 0) {
                z16 = false;
            }
            if (z16) {
                errorMsg = "\u7f6e\u9876\u5931\u8d25";
            }
            QQToastUtil.showQQToastInUiThread(4, errorMsg);
        }
    }

    private final boolean s() {
        CommonFeed S1;
        CommonCellCommon cellCommon;
        re.b t16 = t();
        if (t16 == null || (S1 = t16.S1()) == null || (cellCommon = S1.getCellCommon()) == null) {
            return false;
        }
        long featureFlag = cellCommon.getFeatureFlag();
        ao aoVar = ao.f54312a;
        re.b t17 = t();
        return aoVar.d(t17 != null ? t17.S1() : null, 1) && !QzoneBitCheckUtil.INSTANCE.checkBitEnabled(featureFlag, 1);
    }

    private final re.b t() {
        com.qzone.reborn.share.i viewModel = getViewModel();
        if (viewModel instanceof re.b) {
            return (re.b) viewModel;
        }
        return null;
    }

    private final void v(final com.qzone.reborn.share.e shareContext) {
        new com.qzone.component.e().f(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), 230, null, com.qzone.util.l.a(R.string.gg5), com.qzone.util.l.a(R.string.gi_), com.qzone.util.l.a(R.string.cancel), new DialogInterface.OnClickListener() { // from class: oe.r
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                s.w(s.this, shareContext, dialogInterface, i3);
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(s this$0, com.qzone.reborn.share.e shareContext, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
        this$0.x(shareContext);
    }

    private final void x(com.qzone.reborn.share.e shareContext) {
        if (this.mCanOpenVip) {
            this.mCanOpenVip = false;
            String a16 = com.qzone.util.l.a(R.string.gia);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(com.tencent.mobile\u2026g.qzone_open_vip_success)");
            shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().startActivityForResult(ak.r(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), "jhan_feedzhiding", a16, false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip()), QZoneContant.QZ_REQUEST_OPEN_VIP);
        }
    }

    @Override // com.qzone.reborn.share.a
    public void b(com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        CommonCellCommon cellCommon;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("QzoneFeedProDetailShareTopAction", 2, "share clicked");
        re.b t16 = t();
        CommonUnionID commonUnionID = null;
        CommonFeed S1 = t16 != null ? t16.S1() : null;
        if (!LoginData.getInstance().isQzoneVip()) {
            v(shareContext);
            return;
        }
        if (S1 != null && (cellCommon = S1.getCellCommon()) != null) {
            commonUnionID = cellCommon.getUnionId();
        }
        if (commonUnionID != null) {
            Intrinsics.checkNotNull(S1);
            CommonCellCommon cellCommon2 = S1.getCellCommon();
            Intrinsics.checkNotNull(cellCommon2);
            CommonUnionID unionId = cellCommon2.getUnionId();
            Intrinsics.checkNotNull(unionId);
            u(unionId, shareContext);
            return;
        }
        QLog.e("QzoneFeedProDetailShareTopAction", 1, "unionId is null");
    }

    @Override // com.qzone.reborn.share.a
    public QQShareActionManagerV2.ShareLine f() {
        return QQShareActionManagerV2.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.share.a
    public List<String> g() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("pin_to_top");
        return arrayListOf;
    }

    @Override // com.qzone.reborn.share.a
    public boolean j(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        re.b t16 = t();
        return (t16 != null ? t16.U1() : false) && s();
    }

    @Override // com.qzone.reborn.share.a
    public void l(int requestCode, int resultCode, Intent data) {
        super.l(requestCode, resultCode, data);
        if (requestCode == 9236) {
            if (TextUtils.isEmpty(data != null ? data.getStringExtra("contentIntentKey") : null)) {
                this.mCanOpenVip = true;
            }
        }
    }

    public final void u(CommonUnionID unionId, com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(unionId, "unionId");
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        new QzoneFeedTopManager().setFeedTop(unionId, new b());
    }
}
