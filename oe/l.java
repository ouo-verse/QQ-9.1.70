package oe;

import android.app.Activity;
import com.qzone.reborn.albumx.common.share.ShareApi;
import com.qzone.reborn.feedpro.utils.ao;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharepanel.api.IShareDataApi;
import com.tencent.mobileqq.sharepanel.model.ShareConfirmAction;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u001a2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b#\u0010$J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J \u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\"\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Loe/l;", "Lcom/qzone/reborn/share/a;", "Lre/b;", "r", "Lcom/qzone/reborn/share/e;", "shareContext", "Lcom/tencent/mobileqq/sharepanel/o;", "callback", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/sharepanel/model/a;", "arkData", "u", "", "", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "", "j", "i", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction;", "action", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "Lcom/tencent/mobileqq/sharepanel/model/a;", "getShareData", "()Lcom/tencent/mobileqq/sharepanel/model/a;", "t", "(Lcom/tencent/mobileqq/sharepanel/model/a;)V", "shareData", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class l extends com.qzone.reborn.share.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.sharepanel.model.a shareData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000e"}, d2 = {"oe/l$b", "Lcom/tencent/mobileqq/sharepanel/api/a;", "Lcom/tencent/mobileqq/sharepanel/model/a;", "", "isSuccess", "", "errCode", "", "errMsg", "shareData", "", "bizData", "", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements com.tencent.mobileqq.sharepanel.api.a<com.tencent.mobileqq.sharepanel.model.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.sharepanel.o f422535a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ l f422536b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.share.e f422537c;

        b(com.tencent.mobileqq.sharepanel.o oVar, l lVar, com.qzone.reborn.share.e eVar) {
            this.f422535a = oVar;
            this.f422536b = lVar;
            this.f422537c = eVar;
        }

        @Override // com.tencent.mobileqq.sharepanel.api.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(boolean isSuccess, int errCode, String errMsg, com.tencent.mobileqq.sharepanel.model.a shareData, byte[] bizData) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.i("QzoneFeedProDetailShareQQAction", 1, "requestData isSuccess:" + isSuccess + " errorCode: " + errCode + ", errorMsg: " + errMsg);
            if (!isSuccess) {
                if (errMsg.length() == 0) {
                    errMsg = "\u8bf7\u6c42\u5931\u8d25";
                }
                QQToastUtil.showQQToastInUiThread(4, errMsg);
                this.f422535a.a();
                return;
            }
            ao aoVar = ao.f54312a;
            Pair<Integer, String> c16 = aoVar.c(bizData);
            if (c16 != null && c16.getFirst().intValue() != 0) {
                String second = c16.getSecond();
                QQToastUtil.showQQToastInUiThread(4, second.length() == 0 ? "\u8bf7\u6c42\u5931\u8d25" : second);
                this.f422535a.a();
            } else {
                this.f422536b.t(shareData);
                aoVar.g(this.f422537c, this.f422535a, bizData);
            }
        }
    }

    private final re.b r() {
        com.qzone.reborn.share.i viewModel = getViewModel();
        if (viewModel instanceof re.b) {
            return (re.b) viewModel;
        }
        return null;
    }

    private final void s(com.qzone.reborn.share.e shareContext, com.tencent.mobileqq.sharepanel.o callback) {
        ao aoVar = ao.f54312a;
        re.b r16 = r();
        String j3 = aoVar.j(r16 != null ? r16.S1() : null);
        re.b r17 = r();
        com.tencent.mobileqq.sharepanel.model.c cVar = new com.tencent.mobileqq.sharepanel.model.c(1, j3, aoVar.m(r17 != null ? r17.S1() : null), "ark_busi_select");
        QLog.i("QzoneFeedProDetailShareQQAction", 1, "serviceType:" + cVar.c() + ", busid:" + cVar.a() + ", resourceId:" + cVar.b() + ", templateID:" + cVar.d());
        ((IShareDataApi) QRoute.api(IShareDataApi.class)).requestShareArkData(cVar, new byte[0], new b(callback, this, shareContext));
    }

    @Override // com.qzone.reborn.share.a
    public void b(com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("QzoneFeedProDetailShareQQAction", 2, "share clicked");
        com.tencent.mobileqq.sharepanel.model.a aVar = this.shareData;
        if (aVar == null) {
            QLog.e("QzoneFeedProDetailShareQQAction", 1, "shareData is null");
        } else {
            u(shareContext, aVar);
        }
    }

    @Override // com.qzone.reborn.share.a
    public boolean d(com.qzone.reborn.share.e shareContext, ShareConfirmAction action, com.tencent.mobileqq.sharepanel.o callback) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(action instanceof ShareConfirmAction.ShareChannel) || !Intrinsics.areEqual(((ShareConfirmAction.ShareChannel) action).a(), "qqfriend")) {
            return false;
        }
        this.shareData = null;
        s(shareContext, callback);
        return true;
    }

    @Override // com.qzone.reborn.share.a
    public QQShareActionManagerV2.ShareLine f() {
        return QQShareActionManagerV2.ShareLine.FIRST;
    }

    @Override // com.qzone.reborn.share.a
    public List<String> g() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("qqfriend");
        return arrayListOf;
    }

    @Override // com.qzone.reborn.share.a
    public boolean i(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        ao aoVar = ao.f54312a;
        return !aoVar.d(r() != null ? r0.S1() : null, 17);
    }

    @Override // com.qzone.reborn.share.a
    public boolean j(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        ao aoVar = ao.f54312a;
        return !aoVar.d(r() != null ? r0.S1() : null, 12);
    }

    @Override // com.qzone.reborn.share.a
    public void m(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        QLog.i("QzoneFeedProDetailShareQQAction", 2, "onDisableClick clicked");
        ao aoVar = ao.f54312a;
        re.b r16 = r();
        aoVar.q(r16 != null ? r16.S1() : null, "qqfriend");
    }

    public final void t(com.tencent.mobileqq.sharepanel.model.a aVar) {
        this.shareData = aVar;
    }

    private final void u(com.qzone.reborn.share.e shareContext, com.tencent.mobileqq.sharepanel.model.a arkData) {
        if (arkData == null) {
            QLog.i("QzoneFeedProDetailShareQQAction", 1, "arkData is null");
            return;
        }
        ShareApi shareApi = ShareApi.f52556a;
        Activity activity = shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
        ShareApi.ArkShareParams arkShareParams = new ShareApi.ArkShareParams();
        arkShareParams.setArkJson(arkData.a());
        arkShareParams.setArkId(arkData.c());
        arkShareParams.setArkAppName(arkData.d());
        arkShareParams.setReqType(1);
        arkShareParams.setForwardType(39);
        Unit unit = Unit.INSTANCE;
        shareApi.e(activity, arkShareParams, 1001, null, true, true);
    }
}
