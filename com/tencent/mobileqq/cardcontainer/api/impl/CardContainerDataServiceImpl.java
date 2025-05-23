package com.tencent.mobileqq.cardcontainer.api.impl;

import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.cardcontainer.api.ICardContainerDataService;
import com.tencent.mobileqq.cardcontainer.boxserver.BoxserverPB$OperationDesc;
import com.tencent.mobileqq.cardcontainer.boxserver.BoxserverPB$SyncStatus;
import com.tencent.mobileqq.cardcontainer.data.BusiName;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.cardcontainer.data.ContainerDataUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.ad.event.TianshuAdRequestEvent;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 92\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J8\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002J0\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002J(\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u001fH\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J@\u0010'\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0016J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020+H\u0016R*\u0010-\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R$\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u001a0/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/impl/CardContainerDataServiceImpl;", "Lcom/tencent/mobileqq/cardcontainer/api/ICardContainerDataService;", "", "needClearData", "", "failedDataCallback", "", "dataId", "", "itemId", "isAggregatedCard", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "Lkotlin/collections/ArrayList;", "containerDataList", "deleteCardData", "deleteCardItem", "deleteContainer", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "canReqContainerDataAd", "Lcooperation/vip/pb/TianShuAccess$AdPlacementInfo;", "cardAdPlacementInfo", "setNetAdPlacementInfo", "Lcom/tencent/mobileqq/cardcontainer/api/c;", "callback", "readDataFromNet", "Lcom/tencent/mobileqq/cardcontainer/api/b;", "readDataFromMMKV", "", "getDataFromCache", "busiName", "cardType", AdMetricTag.Report.TYPE, "customData", "itemReportData", "reportData", "reportCardData", "", "data", "parsePushData", "Lcom/tencent/mobileqq/cardcontainer/api/d;", "setUpdateDataCallback", "cardItemList", "Ljava/util/ArrayList;", "Ljava/util/concurrent/ConcurrentHashMap;", "callbackHashMap", "Ljava/util/concurrent/ConcurrentHashMap;", "updateCallback", "Lcom/tencent/mobileqq/cardcontainer/api/d;", "isReqData", "Z", "isParseNetData", "<init>", "()V", "Companion", "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class CardContainerDataServiceImpl implements ICardContainerDataService {
    static IPatchRedirector $redirector_ = null;
    public static final int CARD_CONTAINER_POS_ID = 1352;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "CardContainer.CardContainerDataServiceImpl";

    @NotNull
    private ConcurrentHashMap<Integer, com.tencent.mobileqq.cardcontainer.api.c> callbackHashMap;

    @Nullable
    private volatile ArrayList<com.tencent.mobileqq.cardcontainer.data.a> cardItemList;
    private volatile boolean isParseNetData;
    private volatile boolean isReqData;

    @Nullable
    private com.tencent.mobileqq.cardcontainer.api.d updateCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/impl/CardContainerDataServiceImpl$a;", "", "", "CARD_CONTAINER_POS_ID", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.api.impl.CardContainerDataServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39691);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CardContainerDataServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.callbackHashMap = new ConcurrentHashMap<>();
            this.isReqData = true;
        }
    }

    private final void deleteCardItem(int dataId, String itemId, ArrayList<com.tencent.mobileqq.cardcontainer.data.a> containerDataList) {
        Iterator<com.tencent.mobileqq.cardcontainer.data.a> it = containerDataList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "containerDataList.iterator()");
        while (it.hasNext()) {
            com.tencent.mobileqq.cardcontainer.data.a next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "cardIterator.next()");
            com.tencent.mobileqq.cardcontainer.data.a aVar = next;
            if (aVar instanceof ContainerData) {
                ContainerData containerData = (ContainerData) aVar;
                if (containerData.n() == dataId) {
                    ArrayList<com.tencent.mobileqq.cardcontainer.data.b> h16 = containerData.h();
                    boolean z16 = true;
                    if (h16 != null) {
                        Iterator<com.tencent.mobileqq.cardcontainer.data.b> it5 = h16.iterator();
                        Intrinsics.checkNotNullExpressionValue(it5, "it.iterator()");
                        while (it5.hasNext()) {
                            com.tencent.mobileqq.cardcontainer.data.b next2 = it5.next();
                            Intrinsics.checkNotNullExpressionValue(next2, "iterator.next()");
                            if (Intrinsics.areEqual(next2.c(), itemId)) {
                                it5.remove();
                                QLog.i(TAG, 1, "deleteCardItem dataId " + dataId + " itemId " + itemId + " remove true");
                            }
                        }
                    }
                    ArrayList<com.tencent.mobileqq.cardcontainer.data.b> h17 = containerData.h();
                    if (h17 != null && !h17.isEmpty()) {
                        z16 = false;
                    }
                    if (z16) {
                        it.remove();
                    }
                }
            }
        }
    }

    private final void deleteContainer(int dataId, ArrayList<com.tencent.mobileqq.cardcontainer.data.a> containerDataList) {
        ContainerData containerData;
        Iterator<com.tencent.mobileqq.cardcontainer.data.a> it = containerDataList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "containerDataList.iterator()");
        while (it.hasNext()) {
            com.tencent.mobileqq.cardcontainer.data.a next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            com.tencent.mobileqq.cardcontainer.data.a aVar = next;
            if (aVar instanceof ContainerData) {
                containerData = (ContainerData) aVar;
            } else {
                containerData = null;
            }
            if (containerData != null && containerData.n() == dataId) {
                it.remove();
                QLog.i(TAG, 1, "deleteContainer dataId " + dataId + " remove true");
            }
        }
    }

    private final void failedDataCallback(boolean needClearData) {
        if (this.callbackHashMap.isEmpty()) {
            com.tencent.mobileqq.cardcontainer.api.d dVar = this.updateCallback;
            if (dVar != null) {
                dVar.e();
            }
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.cardcontainer.api.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    CardContainerDataServiceImpl.failedDataCallback$lambda$1(CardContainerDataServiceImpl.this);
                }
            });
        }
        if (needClearData) {
            com.tencent.mobileqq.cardcontainer.data.mmkv.a aVar = com.tencent.mobileqq.cardcontainer.data.mmkv.a.f201087a;
            aVar.m(null);
            aVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void failedDataCallback$lambda$1(CardContainerDataServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<Map.Entry<Integer, com.tencent.mobileqq.cardcontainer.api.c>> it = this$0.callbackHashMap.entrySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.cardcontainer.api.c value = it.next().getValue();
            if (value != null) {
                value.a(false, null);
            }
            it.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void readDataFromMMKV$lambda$3(com.tencent.mobileqq.cardcontainer.api.b callback, CardContainerDataServiceImpl this$0) {
        Integer num;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            com.tencent.mobileqq.cardcontainer.data.mmkv.a aVar = com.tencent.mobileqq.cardcontainer.data.mmkv.a.f201087a;
            TianShuAccess.AdPlacementInfo g16 = aVar.g();
            if (g16 == null) {
                callback.a(false, null);
                return;
            }
            List<TianShuAccess.AdItem> list = g16.lst.get();
            if (list != null && !list.isEmpty()) {
                ArrayList<com.tencent.mobileqq.cardcontainer.data.a> e16 = ContainerDataUtil.e(list, "mmkv");
                ArrayList<com.tencent.mobileqq.cardcontainer.data.c> e17 = aVar.e();
                for (com.tencent.mobileqq.cardcontainer.data.c cVar : e17) {
                    this$0.deleteCardData(cVar.a(), cVar.b(), cVar.c(), e16);
                }
                QLog.i(TAG, 1, "getDeleteDataFromMMKV deleteDataList " + e17);
                if (this$0.cardItemList == null) {
                    this$0.cardItemList = e16;
                }
                callback.a(true, this$0.cardItemList);
                ArrayList<com.tencent.mobileqq.cardcontainer.data.a> arrayList = this$0.cardItemList;
                if (arrayList != null) {
                    num = Integer.valueOf(arrayList.size());
                } else {
                    num = null;
                }
                QLog.i(TAG, 1, "cardItemMMKVList " + num);
                return;
            }
            callback.a(false, null);
        } catch (Exception e18) {
            callback.a(false, null);
            QLog.e(TAG, 1, "readDataFromMMKV " + e18);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNetAdPlacementInfo$lambda$0(CardContainerDataServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.callbackHashMap.isEmpty()) {
            com.tencent.mobileqq.cardcontainer.api.d dVar = this$0.updateCallback;
            if (dVar != null) {
                dVar.e();
                return;
            }
            return;
        }
        Iterator<Map.Entry<Integer, com.tencent.mobileqq.cardcontainer.api.c>> it = this$0.callbackHashMap.entrySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.cardcontainer.api.c value = it.next().getValue();
            if (value != null) {
                value.a(true, this$0.cardItemList);
            }
            it.remove();
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataService
    public boolean canReqContainerDataAd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        boolean a16 = com.tencent.mobileqq.cardcontainer.data.mmkv.a.f201087a.a();
        this.isReqData = a16;
        if (!this.isReqData) {
            QLog.i(TAG, 1, "can not request Data");
            failedDataCallback(false);
        }
        return a16;
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataService
    public void deleteCardData(int dataId, @NotNull String itemId, boolean isAggregatedCard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(dataId), itemId, Boolean.valueOf(isAggregatedCard));
            return;
        }
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        if (dataId > 0) {
            if ((!TextUtils.isEmpty(itemId) || isAggregatedCard) && this.cardItemList != null) {
                QLog.i(TAG, 1, "deleteCardData dataId " + dataId + " itemId " + itemId + " isAggregatedCard " + isAggregatedCard);
                ArrayList<com.tencent.mobileqq.cardcontainer.data.a> arrayList = this.cardItemList;
                if (arrayList != null) {
                    deleteCardData(dataId, itemId, isAggregatedCard, arrayList);
                    if (arrayList.isEmpty()) {
                        com.tencent.mobileqq.cardcontainer.data.mmkv.a.f201087a.j(true);
                    }
                }
                com.tencent.mobileqq.cardcontainer.data.mmkv.a.f201087a.k(dataId, itemId, isAggregatedCard);
            }
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataService
    @Nullable
    public List<com.tencent.mobileqq.cardcontainer.data.a> getDataFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.cardItemList;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        com.tencent.mobileqq.cardcontainer.data.mmkv.a aVar = com.tencent.mobileqq.cardcontainer.data.mmkv.a.f201087a;
        if (appRuntime != null) {
            str = appRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        aVar.o(str);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.callbackHashMap.clear();
        this.isReqData = true;
        this.isParseNetData = false;
        this.cardItemList = null;
        this.updateCallback = null;
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataService
    public void parsePushData(@NotNull byte[] data) {
        ArrayList<com.tencent.mobileqq.cardcontainer.data.a> arrayList;
        ContainerData containerData;
        ArrayList<com.tencent.mobileqq.cardcontainer.data.b> h16;
        ContainerData containerData2;
        ArrayList<com.tencent.mobileqq.cardcontainer.data.b> h17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (!ContainerDataUtil.b()) {
            return;
        }
        int i3 = 1;
        try {
            QLog.i(TAG, 1, "parsePushData");
            BoxserverPB$SyncStatus boxserverPB$SyncStatus = new BoxserverPB$SyncStatus();
            boxserverPB$SyncStatus.mergeFrom(data);
            List<BoxserverPB$OperationDesc> list = boxserverPB$SyncStatus.op_desc.get();
            ArrayList<Triple<Integer, String, Boolean>> arrayList2 = new ArrayList<>();
            int size = list.size();
            int i16 = 0;
            while (true) {
                if (i16 < size) {
                    BoxserverPB$OperationDesc boxserverPB$OperationDesc = list.get(i16);
                    int i17 = boxserverPB$OperationDesc.op_type.get();
                    String str = boxserverPB$OperationDesc.biz_id.get();
                    String str2 = boxserverPB$OperationDesc.item_id.get();
                    QLog.i(TAG, i3, "parsePushData index " + i16 + " type " + i17 + " bizId " + str + " itemId " + str2);
                    if (i17 != 0) {
                        if (i17 == 2) {
                            break;
                        }
                        if (i17 == i3 && !Intrinsics.areEqual(str, BusiName.Birthday.getValue()) && !Intrinsics.areEqual(str, BusiName.SelfBirthday.getValue())) {
                            ArrayList<com.tencent.mobileqq.cardcontainer.data.a> arrayList3 = this.cardItemList;
                            if (arrayList3 != null) {
                                for (com.tencent.mobileqq.cardcontainer.data.a aVar : arrayList3) {
                                    if ((aVar instanceof ContainerData) && Intrinsics.areEqual(((ContainerData) aVar).g(), str)) {
                                        if (aVar instanceof ContainerData) {
                                            containerData2 = (ContainerData) aVar;
                                        } else {
                                            containerData2 = null;
                                        }
                                        if (containerData2 != null && (h17 = containerData2.h()) != null) {
                                            for (com.tencent.mobileqq.cardcontainer.data.b bVar : h17) {
                                                if (Intrinsics.areEqual(bVar.c(), str2)) {
                                                    arrayList2.add(new Triple<>(Integer.valueOf(((ContainerData) aVar).n()), bVar.c(), Boolean.valueOf(((ContainerData) aVar).s())));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (i17 == 3 && (arrayList = this.cardItemList) != null) {
                            for (com.tencent.mobileqq.cardcontainer.data.a aVar2 : arrayList) {
                                if ((aVar2 instanceof ContainerData) && Intrinsics.areEqual(((ContainerData) aVar2).g(), str)) {
                                    if (aVar2 instanceof ContainerData) {
                                        containerData = (ContainerData) aVar2;
                                    } else {
                                        containerData = null;
                                    }
                                    if (containerData != null && (h16 = containerData.h()) != null) {
                                        Iterator<T> it = h16.iterator();
                                        while (it.hasNext()) {
                                            arrayList2.add(new Triple<>(Integer.valueOf(((ContainerData) aVar2).n()), ((com.tencent.mobileqq.cardcontainer.data.b) it.next()).c(), Boolean.valueOf(((ContainerData) aVar2).s())));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i16++;
                    i3 = 1;
                } else {
                    i3 = 0;
                    break;
                }
            }
            if (i3 != 0) {
                com.tencent.mobileqq.cardcontainer.data.mmkv.a.f201087a.l(0);
                SimpleEventBus.getInstance().dispatchEvent(new TianshuAdRequestEvent(99));
            } else {
                com.tencent.mobileqq.cardcontainer.api.d dVar = this.updateCallback;
                if (dVar != null) {
                    dVar.f(arrayList2);
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parsePushData " + e16);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataService
    public void readDataFromMMKV(@NotNull final com.tencent.mobileqq.cardcontainer.api.b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.cardItemList != null) {
            callback.a(true, this.cardItemList);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.cardcontainer.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    CardContainerDataServiceImpl.readDataFromMMKV$lambda$3(com.tencent.mobileqq.cardcontainer.api.b.this, this);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataService
    public void readDataFromNet(@NotNull com.tencent.mobileqq.cardcontainer.api.c callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.cardItemList != null && this.isParseNetData) {
            callback.a(true, this.cardItemList);
        } else if (this.isReqData) {
            this.callbackHashMap.put(Integer.valueOf(callback.hashCode()), callback);
        } else {
            callback.a(false, null);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataService
    public void reportCardData(int dataId, @NotNull String busiName, @NotNull String cardType, int reportType, @NotNull String customData, @NotNull String itemReportData, @NotNull String reportData) {
        String str;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(dataId), busiName, cardType, Integer.valueOf(reportType), customData, itemReportData, reportData);
            return;
        }
        Intrinsics.checkNotNullParameter(busiName, "busiName");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(customData, "customData");
        Intrinsics.checkNotNullParameter(itemReportData, "itemReportData");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        TianShuReportData tianShuReportData = new TianShuReportData();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mTraceId = str + "_" + serverTimeMillis;
        tianShuReportData.mAppId = "vab_qboss";
        tianShuReportData.mPageId = "vab_qboss";
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mItemId = String.valueOf(dataId);
        tianShuReportData.mSubItemId = busiName;
        tianShuReportData.mOperTime = serverTimeMillis;
        if (reportType != 1) {
            if (reportType != 2) {
                if (reportType != 3) {
                    i3 = 999;
                } else {
                    i3 = 122;
                }
            } else {
                i3 = 101;
            }
        } else {
            i3 = 102;
        }
        tianShuReportData.mActionId = i3;
        tianShuReportData.mPositionId = "1352";
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionAttr = 1;
        tianShuReportData.mSubModuleId = cardType;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("customData", customData);
            jSONObject.put("cardReportData", reportData);
            jSONObject.put("itemReportData", itemReportData);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "triggerInfo " + e16);
        }
        tianShuReportData.mTriggerInfo = jSONObject.toString();
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0042 A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:11:0x0015, B:13:0x001f, B:15:0x0036, B:20:0x0042, B:22:0x004c, B:24:0x0076, B:25:0x0080), top: B:9:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004c A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:11:0x0015, B:13:0x001f, B:15:0x0036, B:20:0x0042, B:22:0x004c, B:24:0x0076, B:25:0x0080), top: B:9:0x0013 }] */
    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setNetAdPlacementInfo(@Nullable TianShuAccess.AdPlacementInfo cardAdPlacementInfo) {
        boolean z16;
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cardAdPlacementInfo);
            return;
        }
        try {
            if (cardAdPlacementInfo == null) {
                QLog.i(TAG, 1, "cardAdPlacementInfo == null");
                failedDataCallback(true);
                return;
            }
            int i3 = cardAdPlacementInfo.next_query_ts.get();
            com.tencent.mobileqq.cardcontainer.data.mmkv.a aVar = com.tencent.mobileqq.cardcontainer.data.mmkv.a.f201087a;
            aVar.l(i3);
            List<TianShuAccess.AdItem> cardList = cardAdPlacementInfo.lst.get();
            List<TianShuAccess.AdItem> list = cardList;
            if (list != null && !list.isEmpty()) {
                z16 = false;
                if (!z16) {
                    QLog.i(TAG, 1, "cardList == null");
                    failedDataCallback(true);
                    return;
                }
                aVar.m(cardAdPlacementInfo);
                aVar.j(false);
                aVar.c();
                Intrinsics.checkNotNullExpressionValue(cardList, "cardList");
                this.cardItemList = ContainerDataUtil.e(cardList, "net");
                this.isParseNetData = true;
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.cardcontainer.api.impl.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        CardContainerDataServiceImpl.setNetAdPlacementInfo$lambda$0(CardContainerDataServiceImpl.this);
                    }
                });
                ArrayList<com.tencent.mobileqq.cardcontainer.data.a> arrayList = this.cardItemList;
                if (arrayList != null) {
                    num = Integer.valueOf(arrayList.size());
                } else {
                    num = null;
                }
                QLog.i(TAG, 1, "cardItemNetList " + num);
                return;
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Exception e16) {
            failedDataCallback(true);
            QLog.e(TAG, 1, "requestAdv " + e16);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataService
    public void setUpdateDataCallback(@NotNull com.tencent.mobileqq.cardcontainer.api.d callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.updateCallback = callback;
        }
    }

    private final void deleteCardData(int dataId, String itemId, boolean isAggregatedCard, ArrayList<com.tencent.mobileqq.cardcontainer.data.a> containerDataList) {
        if (isAggregatedCard) {
            deleteContainer(dataId, containerDataList);
        } else {
            deleteCardItem(dataId, itemId, containerDataList);
        }
    }
}
