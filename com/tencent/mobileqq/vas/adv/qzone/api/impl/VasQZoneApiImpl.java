package com.tencent.mobileqq.vas.adv.qzone.api.impl;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.params.GdtSsoReportParam;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.app.c;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.adv.qzone.api.impl.VasQZoneApiImpl;
import com.tencent.mobileqq.vas.adv.qzone.callback.VasAdMetaCallback;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaParam;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaReportParam;
import com.tencent.mobileqq.vas.adv.qzone.logic.AdVideoViewController;
import com.tencent.mobileqq.vas.adv.qzone.logic.AlbumRecommendAdvController;
import com.tencent.mobileqq.vas.adv.qzone.logic.IAdVideoViewController;
import com.tencent.mobileqq.vas.adv.qzone.logic.IAlbumRecommendAdvController;
import com.tencent.mobileqq.vas.adv.qzone.logic.QZoneFeedxAdvAdaptUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import oz2.a;
import qz2.VasAdMetaReportParamNew;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J&\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0002J\u001e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00110\u0002H\u0002J\u001e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0002J\u001e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u001a2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0002H\u0002J\u001e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u001d2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0002H\u0002J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010!\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u001aH\u0016J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0015H\u0016J\u0010\u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020\u0015H\u0016J\u0018\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00150)j\b\u0012\u0004\u0012\u00020\u0015`*H\u0016J\u0010\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020,H\u0016J\u0018\u00103\u001a\u0002022\u0006\u0010-\u001a\u00020,2\u0006\u00101\u001a\u000200H\u0016R$\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u00150)j\b\u0012\u0004\u0012\u00020\u0015`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001e\u00107\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001e\u00109\u001a\n\u0012\u0004\u0012\u00020 \u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/qzone/api/impl/VasQZoneApiImpl;", "Lcom/tencent/mobileqq/vas/adv/qzone/api/IVasQZoneApi;", "Lbz2/a;", "Ltencent/gdt/access$FeedAdGetRsp;", "getRequestFeedAdvCallback", "Lcom/tencent/mobileqq/vas/adv/common/data/VasNewAdParams;", "param", "innerCallback", "Ljava/lang/Runnable;", "getRequestFeedAdvRunnable", "runnable", "", "executeRunnable", "Lcom/tencent/mobileqq/vas/adv/qzone/callback/VasAdMetaCallback;", "callback", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "getRequestAdvBizCallback", "Ltencent/gdt/access$AdGetRsp;", "getRequestAdvBizCallbackNew", "Lcom/tencent/mobileqq/vas/adv/qzone/data/VasAdMetaParam;", "getRequestAdvRunnable", "", "posId", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvReq;", "req", "requestAd", "Lcom/tencent/mobileqq/vas/adv/qzone/data/VasAdMetaReportParam;", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportRsp;", "getReportRunnable", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportReq;", "reportAd", "requestAdvAsync", "Loz2/a;", "requestFeedAdvAsync", "reportAdvAsync", "Lqz2/a;", "reportAdvAsyncNew", "id", "addReportId", "", "containsReportId", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getReportIdSet", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/vas/adv/qzone/logic/IAdVideoViewController;", "createAdVideoViewController", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/mobileqq/vas/adv/qzone/logic/IAlbumRecommendAdvController;", "createAlbumAdvViewController", "reportedCache", "Ljava/util/HashSet;", "Ljava/lang/ref/WeakReference;", "currentCallback", "Ljava/lang/ref/WeakReference;", "currentCallbackV2", "<init>", "()V", "Companion", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasQZoneApiImpl implements IVasQZoneApi {

    @NotNull
    private static final String TAG = "VasQZoneApiImpl";

    @Nullable
    private WeakReference<VasAdMetaCallback> currentCallback;

    @Nullable
    private WeakReference<a> currentCallbackV2;

    @NotNull
    private final HashSet<String> reportedCache = new HashSet<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/adv/qzone/api/impl/VasQZoneApiImpl$b", "Lbz2/a;", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "rsp", "", "c", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "", "e", "b", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements bz2.a<vac_adv_get.VacAdvRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ VasAdMetaCallback f308170b;

        b(VasAdMetaCallback vasAdMetaCallback) {
            this.f308170b = vasAdMetaCallback;
        }

        @Override // bz2.a
        public void b(@NotNull VasAdvServiceCode code, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f308170b.onGetAdInfoResponse(code, errMsg, null);
        }

        @Override // bz2.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull vac_adv_get.VacAdvRsp rsp) {
            VasAdMetaCallback vasAdMetaCallback;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            try {
                ArrayList arrayList = new ArrayList();
                List<vac_adv_get.VacAdvMetaMsg> list = rsp.vac_adv_msgs.get();
                Map<String, String> d16 = QZoneFeedxAdvAdaptUtil.d(rsp.extend_info.get());
                if (list != null && list.size() > 0) {
                    Iterator<vac_adv_get.VacAdvMetaMsg> it = list.iterator();
                    while (it.hasNext()) {
                        AlumBasicData createFromPb = AlumBasicData.createFromPb(it.next(), d16);
                        Intrinsics.checkNotNullExpressionValue(createFromPb, "createFromPb(sigleMsg, extendInfo)");
                        arrayList.add(createFromPb);
                    }
                    WeakReference weakReference = VasQZoneApiImpl.this.currentCallback;
                    Unit unit = null;
                    if (weakReference != null && (vasAdMetaCallback = (VasAdMetaCallback) weakReference.get()) != null) {
                        vasAdMetaCallback.onGetAdInfoResponse(VasAdvServiceCode.SUCCEED, null, (AlumBasicData) arrayList.get(0));
                        QZLog.i(VasQZoneApiImpl.TAG, "requestAdvASync success");
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        QZLog.i(VasQZoneApiImpl.TAG, "requestAdvASync fail, alumBasicDataList is null");
                        return;
                    }
                    return;
                }
                QZLog.i(VasQZoneApiImpl.TAG, "requestAdvASync fail, advMetaMsg is null");
            } catch (Exception e16) {
                QZLog.e(VasQZoneApiImpl.TAG, "requestAdvASync error", e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/adv/qzone/api/impl/VasQZoneApiImpl$c", "Lbz2/a;", "Ltencent/gdt/access$AdGetRsp;", "rsp", "", "c", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "", "e", "b", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements bz2.a<access.AdGetRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ VasAdMetaCallback f308172b;

        c(VasAdMetaCallback vasAdMetaCallback) {
            this.f308172b = vasAdMetaCallback;
        }

        @Override // bz2.a
        public void b(@NotNull VasAdvServiceCode code, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f308172b.onGetAdInfoResponse(code, errMsg, null);
        }

        @Override // bz2.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull access.AdGetRsp rsp) {
            VasAdMetaCallback vasAdMetaCallback;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            try {
                ArrayList arrayList = new ArrayList();
                List<qq_ad_get.QQAdGetRsp.PosAdInfo> list = rsp.qq_ad_get_rsp.pos_ads_info.get();
                Map<String, String> c16 = QZoneFeedxAdvAdaptUtil.c(rsp.ext.get());
                if (list != null && list.size() > 0) {
                    Iterator<qq_ad_get.QQAdGetRsp.PosAdInfo> it = list.iterator();
                    while (it.hasNext()) {
                        AlumBasicData createFromPb = AlumBasicData.createFromPb(it.next(), c16);
                        Intrinsics.checkNotNullExpressionValue(createFromPb, "createFromPb(posAdInfo, extendInfo)");
                        arrayList.add(createFromPb);
                    }
                    WeakReference weakReference = VasQZoneApiImpl.this.currentCallback;
                    Unit unit = null;
                    if (weakReference != null && (vasAdMetaCallback = (VasAdMetaCallback) weakReference.get()) != null) {
                        vasAdMetaCallback.onGetAdInfoResponse(VasAdvServiceCode.SUCCEED, null, (AlumBasicData) arrayList.get(0));
                        QZLog.i(VasQZoneApiImpl.TAG, "requestAdvASync success");
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        QZLog.i(VasQZoneApiImpl.TAG, "requestAdvASync fail, alumBasicDataList is null");
                        return;
                    }
                    return;
                }
                QZLog.i(VasQZoneApiImpl.TAG, "requestAdvASync fail, advMetaMsg is null");
            } catch (Exception e16) {
                QZLog.e(VasQZoneApiImpl.TAG, "requestAdvASync error", e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/vas/adv/qzone/api/impl/VasQZoneApiImpl$d", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "", "retCode", "Ltencent/gdt/access$AdGetRsp;", "adRsp", "", "msg", "", "onRsp", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements VasAdCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bz2.a<access.AdGetRsp> f308173a;

        d(bz2.a<access.AdGetRsp> aVar) {
            this.f308173a = aVar;
        }

        @Override // com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback
        public void onRsp(int retCode, @Nullable access.AdGetRsp adRsp, @NotNull String msg2) {
            boolean z16;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (retCode == 0 && adRsp != null) {
                QLog.d(VasQZoneApiImpl.TAG, 1, "onRsp onSucceed");
                this.f308173a.a(adRsp);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("retCode:");
            sb5.append(retCode);
            sb5.append(", adRsp is null:");
            if (adRsp == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            String sb6 = sb5.toString();
            QLog.d(VasQZoneApiImpl.TAG, 1, "onRsp error:", sb6);
            this.f308173a.b(VasAdvServiceCode.REQUEST_CMD_ERROR, sb6, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/adv/qzone/api/impl/VasQZoneApiImpl$e", "Lbz2/a;", "Ltencent/gdt/access$FeedAdGetRsp;", "rsp", "", "c", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "", "e", "b", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class e implements bz2.a<access.FeedAdGetRsp> {
        e() {
        }

        @Override // bz2.a
        public void b(@NotNull VasAdvServiceCode code, @NotNull String errMsg, @Nullable Throwable e16) {
            a aVar;
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            WeakReference weakReference = VasQZoneApiImpl.this.currentCallbackV2;
            if (weakReference != null && (aVar = (a) weakReference.get()) != null) {
                aVar.a(code, errMsg, -1, null);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0020 A[Catch: Exception -> 0x0061, TryCatch #0 {Exception -> 0x0061, blocks: (B:3:0x0009, B:5:0x000e, B:8:0x0015, B:10:0x0020, B:12:0x0043, B:14:0x004b, B:16:0x005a), top: B:2:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        @Override // bz2.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(@NotNull access.FeedAdGetRsp rsp) {
            access.AdvFeedPos advFeedPos;
            a aVar;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            try {
                PBRepeatMessageField<access.AdvFeedPos> pBRepeatMessageField = rsp.adv_feed_pos;
                Unit unit = null;
                if (pBRepeatMessageField != null && !pBRepeatMessageField.isEmpty()) {
                    advFeedPos = pBRepeatMessageField.get(0);
                    if (advFeedPos == null) {
                        int i3 = advFeedPos.index.get();
                        access.AdGetRsp mergeFrom = new access.AdGetRsp().mergeFrom(advFeedPos.feed_model.get().toByteArray());
                        WeakReference weakReference = VasQZoneApiImpl.this.currentCallbackV2;
                        if (weakReference != null && (aVar = (a) weakReference.get()) != null) {
                            aVar.a(VasAdvServiceCode.SUCCEED, null, i3, mergeFrom);
                            QZLog.i(VasQZoneApiImpl.TAG, "requestFeedAdvASync success");
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            QZLog.i(VasQZoneApiImpl.TAG, "requestFeedAdvASync fail");
                            return;
                        }
                        return;
                    }
                    return;
                }
                advFeedPos = null;
                if (advFeedPos == null) {
                }
            } catch (Exception e16) {
                QZLog.e(VasQZoneApiImpl.TAG, "requestFeedAdvASync error", e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/vas/adv/qzone/api/impl/VasQZoneApiImpl$f", "Lez2/b;", "Ltencent/gdt/access$FeedAdGetRsp;", "", "retCode", "adRsp", "", "msg", "", "b", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class f implements ez2.b<access.FeedAdGetRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bz2.a<access.FeedAdGetRsp> f308175a;

        f(bz2.a<access.FeedAdGetRsp> aVar) {
            this.f308175a = aVar;
        }

        @Override // ez2.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(int retCode, @Nullable access.FeedAdGetRsp adRsp, @NotNull String msg2) {
            boolean z16;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (retCode == 0 && adRsp != null) {
                QLog.d(VasQZoneApiImpl.TAG, 1, "onRsp onSucceed");
                this.f308175a.a(adRsp);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("retCode:");
            sb5.append(retCode);
            sb5.append(", adRsp is null:");
            if (adRsp == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            String sb6 = sb5.toString();
            QLog.d(VasQZoneApiImpl.TAG, 1, "onRsp error:", sb6);
            this.f308175a.b(VasAdvServiceCode.REQUEST_CMD_ERROR, sb6, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/adv/qzone/api/impl/VasQZoneApiImpl$g", "Lbz2/a;", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportRsp;", "rsp", "", "c", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "", "e", "b", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class g implements bz2.a<adv_report.MobileAdvReportRsp> {
        g() {
        }

        @Override // bz2.a
        public void b(@NotNull VasAdvServiceCode code, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.w(VasQZoneApiImpl.TAG, 1, "reportAdSync error, code=" + code + ", msg=" + errMsg, e16);
        }

        @Override // bz2.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull adv_report.MobileAdvReportRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            QLog.i(VasQZoneApiImpl.TAG, 1, "reportAdSync success");
        }
    }

    private final void executeRunnable(Runnable runnable) {
        c.a.a(VasAdvSupport.INSTANCE.a(), runnable, true, false, 4, null);
    }

    private final Runnable getReportRunnable(final VasAdMetaReportParam param, final bz2.a<adv_report.MobileAdvReportRsp> innerCallback) {
        return new Runnable() { // from class: nz2.a
            @Override // java.lang.Runnable
            public final void run() {
                VasQZoneApiImpl.getReportRunnable$lambda$13(VasQZoneApiImpl.this, innerCallback, param);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getReportRunnable$lambda$13(VasQZoneApiImpl this$0, bz2.a innerCallback, VasAdMetaReportParam param) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(innerCallback, "$innerCallback");
        Intrinsics.checkNotNullParameter(param, "$param");
        adv_report.MobileAdvReportReq mobileAdvReportReq = new adv_report.MobileAdvReportReq();
        mobileAdvReportReq.recomm_cookie.set(param.getRecommendCookie());
        mobileAdvReportReq.adv_pos.set(param.getAdvPos());
        mobileAdvReportReq.action_type.set(param.getActionType());
        mobileAdvReportReq.action_value.set(param.getActionValue());
        mobileAdvReportReq.feed_index.set(param.getFeedIndex());
        mobileAdvReportReq.f308016qq.set(param.getUin());
        qq_ad_get.QQAdGet.DeviceInfo deviceInfo = VasAdvSupport.INSTANCE.a().getDeviceInfo();
        if (deviceInfo != null) {
            mobileAdvReportReq.device_info.set(deviceInfo);
        }
        String subscribeId = param.getSubscribeId();
        if (subscribeId != null) {
            adv_report.SubscribeInfo subscribeInfo = mobileAdvReportReq.subscribe_info;
            adv_report.SubscribeInfo subscribeInfo2 = new adv_report.SubscribeInfo();
            subscribeInfo2.f308017id.set(subscribeId);
            subscribeInfo.set(subscribeInfo2);
        }
        adv_report.RewardReportInfo rewardReportInfo = param.getRewardReportInfo();
        if (rewardReportInfo != null) {
            mobileAdvReportReq.reward_report_info.set(rewardReportInfo);
        }
        this$0.reportAd(mobileAdvReportReq, innerCallback);
    }

    private final bz2.a<vac_adv_get.VacAdvRsp> getRequestAdvBizCallback(VasAdMetaCallback callback) {
        return new b(callback);
    }

    private final bz2.a<access.AdGetRsp> getRequestAdvBizCallbackNew(VasAdMetaCallback callback) {
        return new c(callback);
    }

    private final Runnable getRequestAdvRunnable(final VasAdMetaParam param, final VasAdMetaCallback callback, final bz2.a<vac_adv_get.VacAdvRsp> innerCallback) {
        return new Runnable() { // from class: nz2.b
            @Override // java.lang.Runnable
            public final void run() {
                VasQZoneApiImpl.getRequestAdvRunnable$lambda$4(VasAdMetaCallback.this, this, innerCallback, param);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRequestAdvRunnable$lambda$4(VasAdMetaCallback callback, VasQZoneApiImpl this$0, bz2.a innerCallback, VasAdMetaParam param) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(innerCallback, "$innerCallback");
        Intrinsics.checkNotNullParameter(param, "$param");
        vac_adv_get.VacAdvReq vacAdvReq = new vac_adv_get.VacAdvReq();
        vacAdvReq.f308018qq.set(param.getUin());
        vacAdvReq.adv_pos.set(param.getAdvPos());
        vacAdvReq.source_from.set(param.getRefer());
        vacAdvReq.client_mod.set(vz2.d.f443778a.a());
        QLog.d(TAG, 2, "getRequestAdvRunnable refer:", Integer.valueOf(param.getRefer()));
        vac_adv_get.QzoneBusiMsg qzoneBusiInfo = param.getQzoneBusiInfo();
        if (qzoneBusiInfo != null) {
            vacAdvReq.qzone_busi_info.set(qzoneBusiInfo);
        }
        qq_ad_get.QQAdGet.DeviceInfo deviceInfo = VasAdvSupport.INSTANCE.a().getDeviceInfo();
        if (deviceInfo != null) {
            vacAdvReq.device_info.set(deviceInfo);
        }
        if (vacAdvReq.device_info.get() == null) {
            callback.onGetAdInfoResponse(VasAdvServiceCode.CREATE_REQUEST_ERR, null, null);
        } else {
            this$0.requestAd(vacAdvReq, innerCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRequestAdvRunnable$lambda$6(String posId, bz2.a innerCallback) {
        Intrinsics.checkNotNullParameter(posId, "$posId");
        Intrinsics.checkNotNullParameter(innerCallback, "$innerCallback");
        VasNewAdParams build = new VasNewAdParams.Builder().build();
        build.getAdvPos().add(posId);
        build.setBusiType(Integer.valueOf(com.tencent.mobileqq.vas.adv.api.impl.b.b(com.tencent.mobileqq.vas.adv.api.impl.b.f307952a, posId, 0, 2, null)));
        new com.tencent.mobileqq.vas.adv.base.service.d(build, new d(innerCallback)).j();
    }

    private final bz2.a<access.FeedAdGetRsp> getRequestFeedAdvCallback() {
        return new e();
    }

    private final Runnable getRequestFeedAdvRunnable(final VasNewAdParams param, final bz2.a<access.FeedAdGetRsp> innerCallback) {
        return new Runnable() { // from class: nz2.d
            @Override // java.lang.Runnable
            public final void run() {
                VasQZoneApiImpl.getRequestFeedAdvRunnable$lambda$0(VasNewAdParams.this, innerCallback);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRequestFeedAdvRunnable$lambda$0(VasNewAdParams param, bz2.a innerCallback) {
        Intrinsics.checkNotNullParameter(param, "$param");
        Intrinsics.checkNotNullParameter(innerCallback, "$innerCallback");
        new com.tencent.mobileqq.vas.adv.base.service.a(param, new f(innerCallback)).j();
    }

    private final void reportAd(adv_report.MobileAdvReportReq req, bz2.a<adv_report.MobileAdvReportRsp> innerCallback) {
        com.tencent.mobileqq.vas.adv.base.service.e.f307985a.r(req, innerCallback);
    }

    private final void requestAd(vac_adv_get.VacAdvReq req, bz2.a<vac_adv_get.VacAdvRsp> innerCallback) {
        com.tencent.mobileqq.vas.adv.base.service.e.f307985a.u(req, innerCallback);
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi
    public void addReportId(@NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.reportedCache.add(id5);
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi
    public boolean containsReportId(@NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        return this.reportedCache.contains(id5);
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi
    @NotNull
    public IAdVideoViewController createAdVideoViewController(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new AdVideoViewController(context);
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi
    @NotNull
    public IAlbumRecommendAdvController createAlbumAdvViewController(@NotNull Context context, @NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        return new AlbumRecommendAdvController(context, viewGroup);
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi
    @NotNull
    public HashSet<String> getReportIdSet() {
        return this.reportedCache;
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi
    public void reportAdvAsync(@NotNull VasAdMetaReportParam param) {
        boolean contains;
        Intrinsics.checkNotNullParameter(param, "param");
        contains = CollectionsKt___CollectionsKt.contains(this.reportedCache, param.getSubscribeId());
        if (contains) {
            QLog.w(TAG, 1, "reportAdSync fail, " + param.getSubscribeId() + " has reported");
            return;
        }
        executeRunnable(getReportRunnable(param, new g()));
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi
    public void reportAdvAsyncNew(@NotNull VasAdMetaReportParamNew param) {
        Intrinsics.checkNotNullParameter(param, "param");
        GdtSsoReportParam build = new GdtSsoReportParam.Builder().build();
        build.setBusiType(param.getBusiType());
        build.setAid(String.valueOf(param.getAid()));
        build.setAdPosId(param.getPosId());
        build.setTraceId(param.getTraceId());
        build.setActionType(param.getActionType());
        build.setActionTime(System.currentTimeMillis() / 1000);
        build.setAttachment(param.getAttachment());
        QLog.d(TAG, 2, "reportAdvAsyncNew success:" + param.getBusiType() + ", aid:" + param.getAid() + ",action:" + param.getActionType() + ", attachment:" + param.getAttachment());
        ((IGdtAPI) QRoute.api(IGdtAPI.class)).reportAdEvent(build);
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi
    public void requestAdvAsync(@NotNull VasAdMetaParam param, @NotNull VasAdMetaCallback callback) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.currentCallback = new WeakReference<>(callback);
        executeRunnable(getRequestAdvRunnable(param, callback, getRequestAdvBizCallback(callback)));
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi
    public void requestFeedAdvAsync(@NotNull VasNewAdParams param, @NotNull a callback) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.currentCallbackV2 = new WeakReference<>(callback);
        executeRunnable(getRequestFeedAdvRunnable(param, getRequestFeedAdvCallback()));
    }

    private final Runnable getRequestAdvRunnable(final String posId, final bz2.a<access.AdGetRsp> innerCallback) {
        return new Runnable() { // from class: nz2.c
            @Override // java.lang.Runnable
            public final void run() {
                VasQZoneApiImpl.getRequestAdvRunnable$lambda$6(posId, innerCallback);
            }
        };
    }

    @Override // com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi
    public void requestAdvAsync(@NotNull String posId, @NotNull VasAdMetaCallback callback) {
        Intrinsics.checkNotNullParameter(posId, "posId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.currentCallback = new WeakReference<>(callback);
        executeRunnable(getRequestAdvRunnable(posId, getRequestAdvBizCallbackNew(callback)));
    }
}
