package oe;

import android.content.Intent;
import com.qzone.reborn.feedpro.event.QzoneFeedProDetailRefreshEvent;
import com.qzone.reborn.feedpro.utils.ao;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellH5Jump;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonH5JumpUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedUpdateManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016\u00a8\u0006\u001c"}, d2 = {"Loe/h;", "Lcom/qzone/reborn/share/a;", "Lre/b;", "r", "Lcom/qzone/reborn/share/e;", "shareContext", "", ReportConstant.COSTREPORT_PREFIX, "", "j", "", "", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "l", "<init>", "()V", "c", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class h extends com.qzone.reborn.share.a {
    private final re.b r() {
        com.qzone.reborn.share.i viewModel = getViewModel();
        if (viewModel instanceof re.b) {
            return (re.b) viewModel;
        }
        return null;
    }

    private final void s(com.qzone.reborn.share.e shareContext) {
        CommonFeed S1;
        String str;
        List<CommonH5JumpUrl> h5JumpUrl;
        re.b r16 = r();
        if (r16 == null || (S1 = r16.S1()) == null) {
            return;
        }
        CommonCellH5Jump cellH5Jump = S1.getCellH5Jump();
        if (cellH5Jump == null || (h5JumpUrl = cellH5Jump.getH5JumpUrl()) == null) {
            str = "";
        } else {
            str = "";
            for (CommonH5JumpUrl commonH5JumpUrl : h5JumpUrl) {
                if (commonH5JumpUrl.getType() == 1) {
                    str = commonH5JumpUrl.getActionUrl();
                }
            }
        }
        if (str == null || str.length() == 0) {
            QLog.e("QzoneFeedProDetailShareXHSAction", 1, "startShuoshuoEditActivity url null");
        } else {
            yo.d.l(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), str, 21, "");
        }
    }

    @Override // com.qzone.reborn.share.a
    public void b(com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("QzoneFeedProDetailShareXHSAction", 2, "share clicked");
        if (shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String() == null) {
            QLog.e("QzoneFeedProDetailShareXHSAction", 1, "doAction activity null");
            return;
        }
        re.b r16 = r();
        CommonFeed S1 = r16 != null ? r16.S1() : null;
        if (CommonFeedExtKt.isShuoShuoFeed(S1) || CommonFeedExtKt.isShareFeed(S1)) {
            s(shareContext);
        }
    }

    @Override // com.qzone.reborn.share.a
    public QQShareActionManagerV2.ShareLine f() {
        return QQShareActionManagerV2.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.share.a
    public List<String> g() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("edit");
        return arrayListOf;
    }

    @Override // com.qzone.reborn.share.a
    public boolean j(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        re.b r16 = r();
        if (!(r16 != null ? r16.U1() : false)) {
            return false;
        }
        ao aoVar = ao.f54312a;
        re.b r17 = r();
        return aoVar.d(r17 != null ? r17.S1() : null, 3);
    }

    @Override // com.qzone.reborn.share.a
    public void l(int requestCode, int resultCode, Intent data) {
        CommonCellCommon cellCommon;
        super.l(requestCode, resultCode, data);
        if (requestCode == 21 && resultCode == -1) {
            QzoneFeedUpdateManager qzoneFeedUpdateManager = new QzoneFeedUpdateManager();
            re.b r16 = r();
            CommonUnionID commonUnionID = null;
            CommonFeed S1 = r16 != null ? r16.S1() : null;
            if (S1 != null && (cellCommon = S1.getCellCommon()) != null) {
                commonUnionID = cellCommon.getUnionId();
            }
            qzoneFeedUpdateManager.fetchUpdateFeed(commonUnionID);
            SimpleEventBus.getInstance().dispatchEvent(new QzoneFeedProDetailRefreshEvent());
        }
    }
}
