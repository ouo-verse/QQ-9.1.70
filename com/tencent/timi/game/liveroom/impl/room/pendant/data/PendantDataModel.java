package com.tencent.timi.game.liveroom.impl.room.pendant.data;

import android.os.Handler;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.b;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.callback.pendant.PendantInfoCallBack;
import com.tencent.mobileqq.qqlive.data.pendant.PendantViewData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cr4.g;
import cr4.i;
import cr4.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J*\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J \u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0016\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015J\u0010\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0002R\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010(R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/pendant/data/PendantDataModel;", "", "", "l", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "dataCmd", "Lcr4/i;", "rsp", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqlive/data/pendant/PendantViewData;", "Lkotlin/collections/ArrayList;", "p", "Lcr4/l;", "viewInfo", "pendantUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "originUrl", PublicAccountMessageUtilImpl.META_NAME, "j", "", "anchorUid", "roomId", "o", "Lcom/tencent/mobileqq/qqlive/callback/pendant/PendantInfoCallBack;", "pendantInfoCallBack", "i", DomainData.DOMAIN_NAME, "k", "a", "I", "MIN_SECOND", "b", "MILL_SECOND", "", "c", "Ljava/util/Set;", "fetchInfoListeners", "d", "J", "updateDuration", "e", "f", "Ljava/util/concurrent/atomic/AtomicBoolean;", "g", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isStartQuery", "Ljava/lang/Runnable;", h.F, "Ljava/lang/Runnable;", "fetchInfoRun", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class PendantDataModel {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long updateDuration;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long anchorUid;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int MIN_SECOND = 60;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int MILL_SECOND = 1000;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<PendantInfoCallBack> fetchInfoListeners = new HashSet();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isStartQuery = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable fetchInfoRun = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.pendant.data.PendantDataModel$fetchInfoRun$1
        @Override // java.lang.Runnable
        public void run() {
            Set set;
            long j3;
            long j16;
            int i3;
            int i16;
            set = PendantDataModel.this.fetchInfoListeners;
            if (!set.isEmpty()) {
                j3 = PendantDataModel.this.updateDuration;
                if (j3 < 1) {
                    PendantDataModel pendantDataModel = PendantDataModel.this;
                    i16 = pendantDataModel.MIN_SECOND;
                    pendantDataModel.updateDuration = i16;
                }
                PendantDataModel.this.l();
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                j16 = PendantDataModel.this.updateDuration;
                i3 = PendantDataModel.this.MILL_SECOND;
                uIHandlerV2.postDelayed(this, j16 * i3);
                return;
            }
            AegisLogger.INSTANCE.i("Pendant|PendantDataModel", "fetchInfoRun", "fetchInfoListeners is empty, stop run");
        }
    };

    private final String j(String originUrl, String meta) {
        boolean contains$default;
        if (TextUtils.isEmpty(originUrl)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder(originUrl);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) originUrl, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
        if (contains$default) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
        } else {
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        }
        sb5.append(meta);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "urlBuffer.toString()");
        if (this.roomId == 0) {
            AegisLogger.INSTANCE.i("Pendant|PendantDataModel", "buildWebDataUrl", "qqlivePendant buildWebDataUrl room id is 0!");
        }
        AegisLogger.INSTANCE.i("Pendant|PendantDataModel", "buildWebDataUrl", "room: " + this.roomId + " qqlive pendant url:" + sb6);
        return sb6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        AegisLogger.INSTANCE.i("Pendant|PendantDataModel", "doFetchPendantInfo", "roomId:" + this.roomId + ", duration=" + this.updateDuration);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new PendantRequest(this.roomId, m()), new Function1<QQLiveResponse<i>, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.pendant.data.PendantDataModel$doFetchPendantInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<i> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<i> it) {
                Set set;
                long j3;
                AtomicBoolean atomicBoolean;
                ArrayList<PendantViewData> p16;
                Set set2;
                Intrinsics.checkNotNullParameter(it, "it");
                AegisLogger.INSTANCE.i("Pendant|PendantDataModel", "doFetchPendantInfoResult", "isSuccess=" + it.isSuccess() + ", errCode=" + it.getRetCode() + ", errMsg=" + it.getErrMsg());
                if (it.isFailed() || it.getRsp() == null) {
                    return;
                }
                set = PendantDataModel.this.fetchInfoListeners;
                if (set == null || set.isEmpty()) {
                    return;
                }
                PendantDataModel pendantDataModel = PendantDataModel.this;
                i rsp = it.getRsp();
                pendantDataModel.updateDuration = rsp != null ? rsp.f391759b : 0L;
                j3 = PendantDataModel.this.updateDuration;
                QLog.i("Pendant|PendantDataModel", 1, "the update Duration " + j3);
                atomicBoolean = PendantDataModel.this.isStartQuery;
                atomicBoolean.compareAndSet(false, true);
                p16 = PendantDataModel.this.p("init", it.getRsp());
                set2 = PendantDataModel.this.fetchInfoListeners;
                Iterator it5 = set2.iterator();
                while (it5.hasNext()) {
                    ((PendantInfoCallBack) it5.next()).onRecv(p16);
                }
            }
        });
    }

    private final int m() {
        if (b.b(BaseApplication.getContext()) == DeviceType.TABLET) {
            return 3;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ArrayList<PendantViewData> p(String dataCmd, i rsp) {
        boolean z16;
        String pendantUrl;
        boolean isBlank;
        ArrayList<PendantViewData> arrayList = new ArrayList<>();
        if (rsp == null) {
            return arrayList;
        }
        l[] lVarArr = rsp.f391758a;
        Intrinsics.checkNotNullExpressionValue(lVarArr, "rsp.viewInfo");
        for (l lVar : lVarArr) {
            if (lVar != null) {
                String str = lVar.f391794e;
                if (str != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                    if (!isBlank) {
                        z16 = false;
                        if (!z16) {
                            pendantUrl = rsp.f391760c;
                        } else {
                            pendantUrl = lVar.f391794e;
                        }
                        Intrinsics.checkNotNullExpressionValue(pendantUrl, "pendantUrl");
                        arrayList.add(q(dataCmd, lVar, pendantUrl));
                    }
                }
                z16 = true;
                if (!z16) {
                }
                Intrinsics.checkNotNullExpressionValue(pendantUrl, "pendantUrl");
                arrayList.add(q(dataCmd, lVar, pendantUrl));
            }
        }
        return arrayList;
    }

    private final PendantViewData q(String dataCmd, l viewInfo, String pendantUrl) {
        PendantViewData pendantViewData = new PendantViewData();
        pendantViewData.dataCmd = dataCmd;
        pendantViewData.webData = viewInfo.f391793d;
        g[] gVarArr = viewInfo.f391791b;
        pendantViewData.pendantInfoArray = gVarArr;
        pendantViewData.viewPosition = viewInfo.f391790a;
        Intrinsics.checkNotNullExpressionValue(gVarArr, "viewInfo.pendantInfos");
        for (g gVar : gVarArr) {
            float f16 = pendantViewData.viewWidthDp;
            int i3 = gVar.f391749o;
            if (f16 < i3) {
                pendantViewData.viewWidthDp = i3;
            }
            float f17 = pendantViewData.viewHeightDp;
            int i16 = gVar.f391750p;
            if (f17 < i16) {
                pendantViewData.viewHeightDp = i16;
            }
        }
        String str = viewInfo.f391792c;
        Intrinsics.checkNotNullExpressionValue(str, "viewInfo.urlMeta");
        pendantViewData.pendantUrl = j(pendantUrl, str);
        return pendantViewData;
    }

    public final void i(@Nullable PendantInfoCallBack pendantInfoCallBack) {
        if (pendantInfoCallBack != null && !this.fetchInfoListeners.contains(pendantInfoCallBack)) {
            this.fetchInfoListeners.add(pendantInfoCallBack);
        }
    }

    public final void k() {
        AegisLogger.INSTANCE.i("Pendant|PendantDataModel", "destroy", "roomId:" + this.roomId);
        this.isStartQuery.set(false);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.fetchInfoRun);
        this.fetchInfoListeners.clear();
    }

    public final void n(@NotNull PendantInfoCallBack pendantInfoCallBack) {
        Intrinsics.checkNotNullParameter(pendantInfoCallBack, "pendantInfoCallBack");
        this.fetchInfoListeners.remove(pendantInfoCallBack);
    }

    public final void o(long anchorUid, long roomId) {
        if (this.isStartQuery.get()) {
            AegisLogger.INSTANCE.d("Pendant|PendantDataModel", "startFetchPendantInfo", "the pendant fetch looper is beginning ");
            return;
        }
        this.anchorUid = anchorUid;
        this.roomId = roomId;
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.fetchInfoRun);
        ThreadManagerV2.getUIHandlerV2().post(this.fetchInfoRun);
    }
}
