package oe;

import android.content.DialogInterface;
import com.qzone.reborn.feedpro.utils.ao;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedDeleteManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.DeleteFeedRsp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\n\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006\u001b"}, d2 = {"Loe/b;", "Lcom/qzone/reborn/share/a;", "Lre/b;", "v", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feed", "Lcom/qzone/reborn/share/e;", "shareContext", "", "w", "u", "commonFeed", "t", "", "j", "", "", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "<init>", "()V", "c", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends com.qzone.reborn.share.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"oe/b$b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/DeleteFeedRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: oe.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10903b implements DataCallback<DeleteFeedRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.share.e f422515b;

        C10903b(com.qzone.reborn.share.e eVar) {
            this.f422515b = eVar;
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(DeleteFeedRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QQToastUtil.showQQToastInUiThread(5, "\u5220\u9664\u6210\u529f");
            re.b v3 = b.this.v();
            boolean z16 = false;
            if (v3 != null && v3.getIsFromDetail()) {
                z16 = true;
            }
            if (z16) {
                this.f422515b.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().finish();
            }
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            boolean z16 = true;
            QLog.e("QzoneFeedProBlogDetailShareDeleteAction", 1, "deleteFeed errorcode:" + errorCode + ", errorMsg:" + errorMsg);
            if (errorMsg != null && errorMsg.length() != 0) {
                z16 = false;
            }
            if (z16) {
                errorMsg = "\u5220\u9664\u5931\u8d25";
            }
            QQToastUtil.showQQToastInUiThread(4, errorMsg);
        }
    }

    private final void t(CommonFeed commonFeed, com.qzone.reborn.share.e shareContext) {
        new QzoneFeedDeleteManager().deleteFeed(commonFeed, new ArrayList(), new C10903b(shareContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final re.b v() {
        com.qzone.reborn.share.i viewModel = getViewModel();
        if (viewModel instanceof re.b) {
            return (re.b) viewModel;
        }
        return null;
    }

    private final void w(final CommonFeed feed, final com.qzone.reborn.share.e shareContext) {
        if (shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().isFinishing()) {
            return;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.gdp);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qzone_delete_dialog_title)");
        String b16 = com.qzone.reborn.feedpro.utils.m.b(feed);
        String qqStr2 = HardCodeUtil.qqStr(R.string.f170822ak3);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.delete_btn)");
        int color = shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().getResources().getColor(R.color.f157028hz, null);
        String qqStr3 = HardCodeUtil.qqStr(R.string.f170647xd);
        Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.button_cancel)");
        new com.qzone.component.e().e(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), 230, qqStr, b16, qqStr2, color, qqStr3, new DialogInterface.OnClickListener() { // from class: oe.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                b.x(b.this, feed, shareContext, dialogInterface, i3);
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(b this$0, CommonFeed commonFeed, com.qzone.reborn.share.e shareContext, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
        this$0.u(commonFeed, shareContext);
    }

    @Override // com.qzone.reborn.share.a
    public void b(com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("QzoneFeedProBlogDetailShareDeleteAction", 2, "share clicked");
        re.b v3 = v();
        if ((v3 != null ? v3.S1() : null) == null) {
            QLog.e("QzoneFeedProBlogDetailShareDeleteAction", 1, "commonFeed is null");
        } else {
            re.b v16 = v();
            w(v16 != null ? v16.S1() : null, shareContext);
        }
    }

    @Override // com.qzone.reborn.share.a
    public QQShareActionManagerV2.ShareLine f() {
        return QQShareActionManagerV2.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.share.a
    public List<String> g() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("delete");
        return arrayListOf;
    }

    @Override // com.qzone.reborn.share.a
    public boolean j(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        re.b v3 = v();
        if (!(v3 != null ? v3.U1() : false)) {
            return false;
        }
        ao aoVar = ao.f54312a;
        re.b v16 = v();
        return aoVar.d(v16 != null ? v16.S1() : null, 4);
    }

    private final void u(CommonFeed feed, com.qzone.reborn.share.e shareContext) {
        CommonCellCommon cellCommon;
        if (((feed == null || (cellCommon = feed.getCellCommon()) == null) ? null : cellCommon.getUnionId()) != null) {
            Intrinsics.checkNotNull(feed);
            t(feed, shareContext);
        } else {
            QLog.e("QzoneFeedProBlogDetailShareDeleteAction", 1, "unionId is null");
        }
    }
}
