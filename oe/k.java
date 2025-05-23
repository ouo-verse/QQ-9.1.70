package oe;

import android.content.DialogInterface;
import android.content.Intent;
import com.qzone.reborn.event.QZoneFeedxRefreshEvent;
import com.qzone.reborn.feedpro.utils.ao;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellUserInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.SetUncareRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneFeedOperateService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.sharepanel.model.ShareConfirmAction;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0017\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\"\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016\u00a8\u0006\""}, d2 = {"Loe/k;", "Lcom/qzone/reborn/share/a;", "Lre/b;", "w", "Lcom/qzone/reborn/share/e;", "shareContext", "", "uin", "", HippyTKDListViewAdapter.X, "", "j", "", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction;", "action", "Lcom/tencent/mobileqq/sharepanel/o;", "callback", "d", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "l", "<init>", "()V", "c", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class k extends com.qzone.reborn.share.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"oe/k$b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/SetUncareRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements DataCallback<SetUncareRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.share.e f422532b;

        b(com.qzone.reborn.share.e eVar) {
            this.f422532b = eVar;
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(SetUncareRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QQToastUtil.showQQToastInUiThread(5, "\u5c4f\u853d\u6210\u529f");
            re.b w3 = k.this.w();
            boolean z16 = false;
            if (w3 != null && w3.getIsFromDetail()) {
                z16 = true;
            }
            if (z16) {
                this.f422532b.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().finish();
            }
            QZoneFeedxRefreshEvent qZoneFeedxRefreshEvent = new QZoneFeedxRefreshEvent();
            qZoneFeedxRefreshEvent.setScrollToTop(true);
            SimpleEventBus.getInstance().dispatchEvent(qZoneFeedxRefreshEvent);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            boolean z16 = true;
            QLog.e("QzoneFeedProDetailShareHideHimAction", 1, "setUncare errorcode:" + errorCode + ", errorMsg:" + errorMsg);
            if (errorMsg != null && errorMsg.length() != 0) {
                z16 = false;
            }
            if (z16) {
                errorMsg = "\u5c4f\u853d\u5931\u8d25";
            }
            QQToastUtil.showQQToastInUiThread(4, errorMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(com.tencent.mobileqq.sharepanel.o callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(com.tencent.mobileqq.sharepanel.o callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final re.b w() {
        com.qzone.reborn.share.i viewModel = getViewModel();
        if (viewModel instanceof re.b) {
            return (re.b) viewModel;
        }
        return null;
    }

    @Override // com.qzone.reborn.share.a
    public void b(com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        String str;
        CommonFeed S1;
        CommonCellUserInfo cellUserInfo;
        CommonUser user;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("QzoneFeedProDetailShareHideHimAction", 2, "share clicked");
        re.b w3 = w();
        if (w3 == null || (S1 = w3.S1()) == null || (cellUserInfo = S1.getCellUserInfo()) == null || (user = cellUserInfo.getUser()) == null || (str = user.getUin()) == null) {
            str = "";
        }
        x(shareContext, str);
    }

    @Override // com.qzone.reborn.share.a
    public boolean d(com.qzone.reborn.share.e shareContext, ShareConfirmAction action, final com.tencent.mobileqq.sharepanel.o callback) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(action instanceof ShareConfirmAction.AppendAction) || !Intrinsics.areEqual(((ShareConfirmAction.AppendAction) action).a(), "block_feed")) {
            return false;
        }
        new com.qzone.component.e().f(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), 230, "\u4e0d\u770bTA\u7684\u52a8\u6001", "\u786e\u8ba4\u9690\u85cfTA\u6240\u6709\u52a8\u6001\u5417\uff1f", com.qzone.util.l.a(R.string.f170648xe), com.qzone.util.l.a(R.string.f170647xd), new DialogInterface.OnClickListener() { // from class: oe.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                k.u(com.tencent.mobileqq.sharepanel.o.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: oe.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                k.v(com.tencent.mobileqq.sharepanel.o.this, dialogInterface, i3);
            }
        });
        return true;
    }

    @Override // com.qzone.reborn.share.a
    public QQShareActionManagerV2.ShareLine f() {
        return QQShareActionManagerV2.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.share.a
    public List<String> g() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("block_feed");
        return arrayListOf;
    }

    @Override // com.qzone.reborn.share.a
    public boolean j(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        re.b w3 = w();
        if (w3 != null ? w3.U1() : false) {
            return false;
        }
        ao aoVar = ao.f54312a;
        re.b w16 = w();
        return aoVar.d(w16 != null ? w16.S1() : null, 8);
    }

    @Override // com.qzone.reborn.share.a
    public void l(int requestCode, int resultCode, Intent data) {
        super.l(requestCode, resultCode, data);
    }

    private final void x(com.qzone.reborn.share.e shareContext, String uin) {
        if (uin == null || uin.length() == 0) {
            QLog.e("QzoneFeedProDetailShareHideHimAction", 1, "uin is null");
            return;
        }
        QzoneFeedOperateService qzoneFeedOperateService = new QzoneFeedOperateService();
        CommonUser commonUser = new CommonUser();
        commonUser.setUin(uin);
        qzoneFeedOperateService.setUncare(commonUser, new b(shareContext));
    }
}
