package com.tencent.mobileqq.zplan.card.impl.view.smallhome.data;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.data.SmallHomePartyCardDataHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaPartyRoomData;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import pv4.r;
import qv4.ae;
import qv4.af;
import tl.h;
import zu4.i;
import zu4.j;
import zu4.s;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0002\r\u000eB\u0007\u00a2\u0006\u0004\b)\u0010*J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0013\u001a\u00020\u0005R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u001c\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/data/SmallHomePartyCardDataHelper;", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/data/a;", "", "Lpv4/h;", "roomList", "", "o", "partyRoomList", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/sqshow/zootopia/data/o;", "roomData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "a", "b", "l", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/data/SmallHomePartyCardDataHelper$b;", "roomDataRefreshCallback", "p", DomainData.DOMAIN_NAME, "", "c", "I", "moduleId", "d", "currentRoomIndex", "", "e", "Z", "hasMorePage", "f", "refreshInterval", "g", "Lcom/tencent/sqshow/zootopia/data/o;", "mCachePartyRoomData", "Lmqq/util/WeakReference;", h.F, "Lmqq/util/WeakReference;", "roomListRefreshCallback", "i", "isRefreshing", "<init>", "()V", "j", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SmallHomePartyCardDataHelper extends a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int moduleId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int currentRoomIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasMorePage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int refreshInterval;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private ZootopiaPartyRoomData mCachePartyRoomData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private WeakReference<b> roomListRefreshCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isRefreshing;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/data/SmallHomePartyCardDataHelper$b;", "", "Lcom/tencent/sqshow/zootopia/data/o;", "roomData", "", "b", "", "Lpv4/h;", "roomList", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void a(List<pv4.h> roomList);

        void b(ZootopiaPartyRoomData roomData);
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/smallhome/data/SmallHomePartyCardDataHelper$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzu4/j;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements e<j> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(j result) {
            List<pv4.h> list;
            b bVar;
            Intrinsics.checkNotNullParameter(result, "result");
            pv4.h[] hVarArr = result.f453444a;
            Intrinsics.checkNotNullExpressionValue(hVarArr, "result.roomList");
            list = ArraysKt___ArraysKt.toList(hVarArr);
            WeakReference weakReference = SmallHomePartyCardDataHelper.this.roomListRefreshCallback;
            if (weakReference != null && (bVar = (b) weakReference.get()) != null) {
                bVar.a(list);
            }
            SmallHomePartyCardDataHelper.this.q(list);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("SmallHomePartyCardDataHelper", 1, "refreshRoomsState onResultFailure");
        }
    }

    private final void o(List<pv4.h> roomList) {
        i iVar = new i();
        iVar.f453442a = new s[roomList.size()];
        int i3 = 0;
        for (Object obj : roomList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            pv4.h hVar = (pv4.h) obj;
            s sVar = new s();
            sVar.f453476a = hVar.f427604a;
            sVar.f453479d = this.currentRoomIndex;
            sVar.f453477b = hVar.f427611h.f427616c;
            sVar.f453478c = hVar.f427613j;
            iVar.f453442a[i3] = sVar;
            i3 = i16;
        }
        iVar.f453443b = this.currentRoomIndex;
        qf3.a.f(qf3.a.f428889a, iVar, new c(), 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(List<pv4.h> partyRoomList) {
        ZootopiaPartyRoomData zootopiaPartyRoomData = this.mCachePartyRoomData;
        if (zootopiaPartyRoomData != null) {
            this.mCachePartyRoomData = new ZootopiaPartyRoomData(zootopiaPartyRoomData.getModuleId(), zootopiaPartyRoomData.getCurrentPageIndex(), partyRoomList, zootopiaPartyRoomData.getHasMore(), zootopiaPartyRoomData.getRefreshInterval());
        }
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.smallhome.data.a
    public String a() {
        return "SmallHomePartyCardDataHelper";
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.smallhome.data.a
    public void b() {
        List<pv4.h> d16;
        ZootopiaPartyRoomData zootopiaPartyRoomData = this.mCachePartyRoomData;
        if (zootopiaPartyRoomData == null || (d16 = zootopiaPartyRoomData.d()) == null || this.isRefreshing) {
            return;
        }
        o(d16);
    }

    /* renamed from: l, reason: from getter */
    public final ZootopiaPartyRoomData getMCachePartyRoomData() {
        return this.mCachePartyRoomData;
    }

    public final void m(ZootopiaPartyRoomData roomData) {
        Intrinsics.checkNotNullParameter(roomData, "roomData");
        this.moduleId = roomData.getModuleId();
        this.currentRoomIndex = roomData.getCurrentPageIndex();
        this.hasMorePage = roomData.getHasMore();
        int refreshInterval = roomData.getRefreshInterval();
        this.refreshInterval = refreshInterval;
        this.mCachePartyRoomData = roomData;
        c(refreshInterval * 1000);
    }

    public final void n() {
        QLog.i("SmallHomePartyCardDataHelper", 1, "refreshRoomsList currentRoomIndex = " + this.currentRoomIndex + " hasMore = " + this.hasMorePage + " isRefreshing=" + this.isRefreshing);
        if (this.isRefreshing) {
            return;
        }
        e();
        ae aeVar = new ae();
        aeVar.f429904b = this.moduleId;
        aeVar.f429905c = this.hasMorePage ? this.currentRoomIndex + 1 : 0;
        com.tencent.sqshow.zootopia.recommend.main.e.f(com.tencent.sqshow.zootopia.recommend.main.e.f372619a, aeVar, new e<af>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.smallhome.data.SmallHomePartyCardDataHelper$refreshRoomsList$1
            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(af result) {
                List list;
                SmallHomePartyCardDataHelper.b bVar;
                Intrinsics.checkNotNullParameter(result, "result");
                QLog.i("SmallHomePartyCardDataHelper", 1, "refreshRoomsList onResultSuccess");
                SmallHomePartyCardDataHelper.this.currentRoomIndex = result.f429907a.f427667k;
                SmallHomePartyCardDataHelper.this.hasMorePage = result.f429907a.f427669m;
                r rVar = result.f429907a;
                int i3 = rVar.f427661e;
                int i16 = rVar.f427667k;
                pv4.h[] hVarArr = rVar.f427675s;
                Intrinsics.checkNotNullExpressionValue(hVarArr, "result.module.partyRoomList");
                list = ArraysKt___ArraysKt.toList(hVarArr);
                r rVar2 = result.f429907a;
                ZootopiaPartyRoomData zootopiaPartyRoomData = new ZootopiaPartyRoomData(i3, i16, list, rVar2.f427669m, rVar2.f427670n);
                SmallHomePartyCardDataHelper.this.mCachePartyRoomData = zootopiaPartyRoomData;
                WeakReference weakReference = SmallHomePartyCardDataHelper.this.roomListRefreshCallback;
                if (weakReference != null && (bVar = (SmallHomePartyCardDataHelper.b) weakReference.get()) != null) {
                    bVar.b(zootopiaPartyRoomData);
                }
                SmallHomePartyCardDataHelper.this.d();
                SmallHomePartyCardDataHelper.this.isRefreshing = false;
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, final String message) {
                QLog.i("SmallHomePartyCardDataHelper", 1, "refreshRoomsList onResultFailure error = " + error + ", message = " + message);
                if (error != 1002) {
                    final SmallHomePartyCardDataHelper smallHomePartyCardDataHelper = SmallHomePartyCardDataHelper.this;
                    CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.smallhome.data.SmallHomePartyCardDataHelper$refreshRoomsList$1$onResultFailure$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            BaseApplication context = BaseApplication.getContext();
                            String str = message;
                            if (str == null) {
                                str = "\u5237\u65b0\u5931\u8d25";
                            }
                            QQToast.makeText(context, 1, str, 0).show();
                            smallHomePartyCardDataHelper.d();
                        }
                    });
                }
                SmallHomePartyCardDataHelper.this.isRefreshing = false;
            }
        }, 0, 4, null);
        this.isRefreshing = true;
    }

    public final void p(b roomDataRefreshCallback) {
        this.roomListRefreshCallback = new WeakReference<>(roomDataRefreshCallback);
    }
}
