package oe;

import android.app.Activity;
import android.content.Intent;
import com.qzone.reborn.albumx.common.share.ShareApi;
import com.qzone.reborn.feedpro.utils.ao;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.api.IShareDataApi;
import com.tencent.mobileqq.sharepanel.model.ShareConfirmAction;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
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
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u000b\u0018\u0000 42\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J$\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J0\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00192\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J \u0010!\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010#\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0015H\u0016R$\u0010*\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u00101\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Loe/m;", "Lcom/qzone/reborn/share/a;", "Lre/b;", ReportConstant.COSTREPORT_PREFIX, "Lcom/qzone/reborn/share/e;", "shareContext", "Lcom/tencent/mobileqq/sharepanel/m;", "prepareForwardCallback", "Lcom/tencent/mobileqq/sharepanel/o;", "shareConfirmCallback", "", "t", "callback", "Lcom/tencent/mobileqq/sharepanel/model/a;", "rsp", "w", "", "", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "", "j", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "targetList", DomainData.DOMAIN_NAME, "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction;", "action", "d", NodeProps.VISIBLE, "k", "c", "Lcom/tencent/mobileqq/sharepanel/model/a;", "getShareData", "()Lcom/tencent/mobileqq/sharepanel/model/a;", "v", "(Lcom/tencent/mobileqq/sharepanel/model/a;)V", "shareData", "", "[B", "getBizData", "()[B", "u", "([B)V", "bizData", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class m extends com.qzone.reborn.share.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.sharepanel.model.a shareData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private byte[] bizData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000e"}, d2 = {"oe/m$b", "Lcom/tencent/mobileqq/sharepanel/api/a;", "Lcom/tencent/mobileqq/sharepanel/model/a;", "", "isSuccess", "", "errCode", "", "errMsg", "shareData", "", "bizData", "", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements com.tencent.mobileqq.sharepanel.api.a<com.tencent.mobileqq.sharepanel.model.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.sharepanel.m f422541a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.sharepanel.o f422542b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ m f422543c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.share.e f422544d;

        b(com.tencent.mobileqq.sharepanel.m mVar, com.tencent.mobileqq.sharepanel.o oVar, m mVar2, com.qzone.reborn.share.e eVar) {
            this.f422541a = mVar;
            this.f422542b = oVar;
            this.f422543c = mVar2;
            this.f422544d = eVar;
        }

        @Override // com.tencent.mobileqq.sharepanel.api.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(boolean isSuccess, int errCode, String errMsg, com.tencent.mobileqq.sharepanel.model.a shareData, byte[] bizData) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.i("QzoneFeedProDetailShareRecentAndMoreQQAction", 1, "requestData isSuccess:" + isSuccess + " errorCode: " + errCode + ", errorMsg: " + errMsg);
            if (!isSuccess) {
                if (errMsg.length() == 0) {
                    errMsg = "\u8bf7\u6c42\u5931\u8d25";
                }
                QQToastUtil.showQQToastInUiThread(4, errMsg);
                com.tencent.mobileqq.sharepanel.m mVar = this.f422541a;
                if (mVar != null) {
                    mVar.onFail();
                }
                com.tencent.mobileqq.sharepanel.o oVar = this.f422542b;
                if (oVar != null) {
                    oVar.a();
                    return;
                }
                return;
            }
            ao aoVar = ao.f54312a;
            Pair<Integer, String> c16 = aoVar.c(bizData);
            if (c16 != null && c16.getFirst().intValue() != 0) {
                String second = c16.getSecond();
                QQToastUtil.showQQToastInUiThread(4, second.length() == 0 ? "\u8bf7\u6c42\u5931\u8d25" : second);
                com.tencent.mobileqq.sharepanel.m mVar2 = this.f422541a;
                if (mVar2 != null) {
                    mVar2.onFail();
                }
                com.tencent.mobileqq.sharepanel.o oVar2 = this.f422542b;
                if (oVar2 != null) {
                    oVar2.a();
                    return;
                }
                return;
            }
            this.f422543c.v(shareData);
            this.f422543c.u(bizData);
            com.tencent.mobileqq.sharepanel.o oVar3 = this.f422542b;
            if (oVar3 == null) {
                this.f422543c.w(this.f422544d, this.f422541a, shareData);
            } else {
                aoVar.g(this.f422544d, oVar3, bizData);
            }
        }
    }

    private final re.b s() {
        com.qzone.reborn.share.i viewModel = getViewModel();
        if (viewModel instanceof re.b) {
            return (re.b) viewModel;
        }
        return null;
    }

    private final void t(com.qzone.reborn.share.e shareContext, com.tencent.mobileqq.sharepanel.m prepareForwardCallback, com.tencent.mobileqq.sharepanel.o shareConfirmCallback) {
        ao aoVar = ao.f54312a;
        re.b s16 = s();
        String j3 = aoVar.j(s16 != null ? s16.S1() : null);
        re.b s17 = s();
        com.tencent.mobileqq.sharepanel.model.c cVar = new com.tencent.mobileqq.sharepanel.model.c(1, j3, aoVar.m(s17 != null ? s17.S1() : null), "ark_busi_select");
        QLog.i("QzoneFeedProDetailShareRecentAndMoreQQAction", 1, "serviceType:" + cVar.c() + ", busid:" + cVar.a() + ", resourceId:" + cVar.b() + ", templateID:" + cVar.d());
        ((IShareDataApi) QRoute.api(IShareDataApi.class)).requestShareArkData(cVar, new byte[0], new b(prepareForwardCallback, shareConfirmCallback, this, shareContext));
    }

    @Override // com.qzone.reborn.share.a
    public void b(com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("QzoneFeedProDetailShareRecentAndMoreQQAction", 2, "share clicked");
    }

    @Override // com.qzone.reborn.share.a
    public boolean d(com.qzone.reborn.share.e shareContext, ShareConfirmAction action, com.tencent.mobileqq.sharepanel.o callback) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(action instanceof ShareConfirmAction.Forward) && !(action instanceof ShareConfirmAction.MoreFriend)) {
            return false;
        }
        if ((action instanceof ShareConfirmAction.MoreFriend) && (this.shareData == null || this.bizData == null)) {
            t(shareContext, null, callback);
            return true;
        }
        ao.f54312a.g(shareContext, callback, this.bizData);
        return true;
    }

    @Override // com.qzone.reborn.share.a
    public QQShareActionManagerV2.ShareLine f() {
        return QQShareActionManagerV2.ShareLine.SPECIFIED;
    }

    @Override // com.qzone.reborn.share.a
    public List<String> g() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(RecentUser.TABLE_NAME);
        return arrayListOf;
    }

    @Override // com.qzone.reborn.share.a
    public boolean j(com.qzone.reborn.share.e shareContext) {
        com.tencent.mobileqq.sharepanel.f sharePanel;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        ao aoVar = ao.f54312a;
        re.b s16 = s();
        boolean d16 = aoVar.d(s16 != null ? s16.S1() : null, 12);
        re.b s17 = s();
        boolean d17 = aoVar.d(s17 != null ? s17.S1() : null, 17);
        if ((d16 || d17) && (sharePanel = shareContext.getShareManger().getSharePanel()) != null) {
            sharePanel.s0();
        }
        return (d16 || d17) ? false : true;
    }

    @Override // com.qzone.reborn.share.a
    public void k(com.qzone.reborn.share.e shareContext, boolean visible) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        if (visible) {
            return;
        }
        this.shareData = null;
        this.bizData = null;
    }

    @Override // com.qzone.reborn.share.a
    public boolean n(com.qzone.reborn.share.e shareContext, ArrayList<ResultRecord> targetList, com.tencent.mobileqq.sharepanel.m callback) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(targetList, "targetList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (targetList.size() != 0) {
            t(shareContext, callback, null);
            return true;
        }
        w(shareContext, callback, this.shareData);
        return true;
    }

    public final void u(byte[] bArr) {
        this.bizData = bArr;
    }

    public final void v(com.tencent.mobileqq.sharepanel.model.a aVar) {
        this.shareData = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(com.qzone.reborn.share.e shareContext, com.tencent.mobileqq.sharepanel.m callback, com.tencent.mobileqq.sharepanel.model.a rsp) {
        if (rsp == null) {
            QLog.e("QzoneFeedProDetailShareRecentAndMoreQQAction", 1, "shareToRecentQQ ShareArkData is null");
            if (callback != null) {
                callback.onFail();
                return;
            }
            return;
        }
        ShareApi shareApi = ShareApi.f52556a;
        Activity activity = shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
        ShareApi.ArkShareParams arkShareParams = new ShareApi.ArkShareParams();
        arkShareParams.setArkJson(rsp.a());
        arkShareParams.setArkId(rsp.c());
        arkShareParams.setArkAppName(rsp.d());
        arkShareParams.setReqType(154);
        arkShareParams.setForwardType(39);
        Unit unit = Unit.INSTANCE;
        Intent c16 = shareApi.c(activity, arkShareParams);
        if (callback != null) {
            callback.a(c16);
        }
    }
}
