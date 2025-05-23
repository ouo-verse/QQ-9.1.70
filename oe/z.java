package oe;

import androidx.core.util.Consumer;
import com.qzone.reborn.feedpro.utils.ag;
import com.qzone.reborn.feedpro.utils.ao;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharepanel.api.IShareDataApi;
import com.tencent.mobileqq.sharepanel.model.ShareConfirmAction;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J2\u0010\u000e\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0002J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J \u0010\u001d\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006#"}, d2 = {"Loe/z;", "Lcom/qzone/reborn/share/a;", "Lre/b;", "u", "", "url", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "Lcom/qzone/reborn/share/e;", "shareContext", "Landroidx/core/util/Consumer;", "", "result", "", "w", "Lcom/tencent/mobileqq/sharepanel/o;", "callback", "v", "j", "i", "", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction;", "action", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "c", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class z extends com.qzone.reborn.share.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000e"}, d2 = {"oe/z$b", "Lcom/tencent/mobileqq/sharepanel/api/a;", "Lcom/tencent/mobileqq/sharepanel/model/e;", "", "isSuccess", "", "errCode", "", "errMsg", "shareData", "", "bizData", "", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements com.tencent.mobileqq.sharepanel.api.a<com.tencent.mobileqq.sharepanel.model.e> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.sharepanel.o f422569a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.share.e f422570b;

        b(com.tencent.mobileqq.sharepanel.o oVar, com.qzone.reborn.share.e eVar) {
            this.f422569a = oVar;
            this.f422570b = eVar;
        }

        @Override // com.tencent.mobileqq.sharepanel.api.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(boolean isSuccess, int errCode, String errMsg, com.tencent.mobileqq.sharepanel.model.e shareData, byte[] bizData) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.i("QzoneFeedProDetailShareXHSAction", 1, "requestData isSuccess:" + isSuccess + " errorCode: " + errCode + ", errorMsg: " + errMsg);
            if (!isSuccess) {
                if (errMsg.length() == 0) {
                    errMsg = "\u8bf7\u6c42\u5931\u8d25";
                }
                QQToastUtil.showQQToastInUiThread(4, errMsg);
                this.f422569a.a();
                return;
            }
            ao aoVar = ao.f54312a;
            Pair<Integer, String> c16 = aoVar.c(bizData);
            if (c16 != null && c16.getFirst().intValue() != 0) {
                String second = c16.getSecond();
                QQToastUtil.showQQToastInUiThread(4, second.length() == 0 ? "\u8bf7\u6c42\u5931\u8d25" : second);
                this.f422569a.a();
                return;
            }
            aoVar.g(this.f422570b, this.f422569a, bizData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Boolean bool) {
        QLog.d("QzoneFeedProDetailShareXHSAction", 1, "shareToXHS result: " + bool);
        Intrinsics.areEqual(bool, Boolean.TRUE);
    }

    private final re.b u() {
        com.qzone.reborn.share.i viewModel = getViewModel();
        if (viewModel instanceof re.b) {
            return (re.b) viewModel;
        }
        return null;
    }

    private final void v(com.qzone.reborn.share.e shareContext, com.tencent.mobileqq.sharepanel.o callback) {
        ao aoVar = ao.f54312a;
        re.b u16 = u();
        String j3 = aoVar.j(u16 != null ? u16.S1() : null);
        re.b u17 = u();
        com.tencent.mobileqq.sharepanel.model.c cVar = new com.tencent.mobileqq.sharepanel.model.c(1, j3, aoVar.m(u17 != null ? u17.S1() : null), "h5_busi_select");
        QLog.i("QzoneFeedProDetailShareXHSAction", 1, "serviceType:" + cVar.c() + ", busid:" + cVar.a() + ", resourceId:" + cVar.b() + ", templateID:" + cVar.d());
        ((IShareDataApi) QRoute.api(IShareDataApi.class)).requestShareURL4XHS(cVar, new byte[0], new b(callback, shareContext));
    }

    private final void w(String url, CommonFeed commonFeed, final com.qzone.reborn.share.e shareContext, final Consumer<Boolean> result) {
        ag agVar = new ag();
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        agVar.j(context, commonFeed, url, new Consumer() { // from class: oe.y
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                z.x(com.qzone.reborn.share.e.this, result, (ag.QZoneQrcodeResult) obj);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(com.qzone.reborn.share.e shareContext, Consumer result, ag.QZoneQrcodeResult qZoneQrcodeResult) {
        Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(qZoneQrcodeResult, "qZoneQrcodeResult");
        if (qZoneQrcodeResult.getIsSuccess()) {
            com.qzone.business.share.d.f44790a.h(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), qZoneQrcodeResult.getFilePath());
        }
        result.accept(Boolean.valueOf(qZoneQrcodeResult.getIsSuccess()));
    }

    @Override // com.qzone.reborn.share.a
    public void b(com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        CommonFeed S1;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        re.b u16 = u();
        if (u16 == null || (S1 = u16.S1()) == null) {
            return;
        }
        w("", S1, shareContext, new Consumer() { // from class: oe.x
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                z.t((Boolean) obj);
            }
        });
    }

    @Override // com.qzone.reborn.share.a
    public boolean d(com.qzone.reborn.share.e shareContext, ShareConfirmAction action, com.tencent.mobileqq.sharepanel.o callback) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(action instanceof ShareConfirmAction.ShareChannel) || !Intrinsics.areEqual(((ShareConfirmAction.ShareChannel) action).a(), "redbook")) {
            return false;
        }
        v(shareContext, callback);
        return true;
    }

    @Override // com.qzone.reborn.share.a
    public QQShareActionManagerV2.ShareLine f() {
        return QQShareActionManagerV2.ShareLine.FIRST;
    }

    @Override // com.qzone.reborn.share.a
    public List<String> g() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("redbook");
        return arrayListOf;
    }

    @Override // com.qzone.reborn.share.a
    public boolean i(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        ao aoVar = ao.f54312a;
        return !aoVar.d(u() != null ? r0.S1() : null, 18);
    }

    @Override // com.qzone.reborn.share.a
    public boolean j(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        ao aoVar = ao.f54312a;
        return !aoVar.d(u() != null ? r0.S1() : null, 13);
    }

    @Override // com.qzone.reborn.share.a
    public void m(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        QLog.i("QzoneFeedProDetailShareXHSAction", 2, "onDisableClick clicked");
        ao aoVar = ao.f54312a;
        re.b u16 = u();
        aoVar.q(u16 != null ? u16.S1() : null, "redbook");
    }
}
