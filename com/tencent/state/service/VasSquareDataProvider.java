package com.tencent.state.service;

import android.util.SparseArray;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.state.data.Image;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemKt;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.ISquarePttMessageService;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareDataProvider;
import com.tencent.state.square.api.SquareTroopMessageRecord;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareTroopItem;
import com.tencent.state.square.resource.SquareResourceManagerKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 :2\u00020\u0001:\u0001:B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u008d\u0001\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192{\u0010\u001a\u001aw\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001c0\u000e\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00170\u001bH\u0002J\b\u0010%\u001a\u0004\u0018\u00010\nJ\b\u0010&\u001a\u0004\u0018\u00010\u0011J\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eJ\u0085\u0001\u0010(\u001a\u00020\u00172{\u0010\u001a\u001aw\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001c0\u000e\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b()\u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00170\u001bH\u0016J\u0006\u0010*\u001a\u00020\fJ?\u0010+\u001a\u00020\u00172\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000e2'\u0010\u001a\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001c0\u000e\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00170,H\u0002J\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000eJ\u0016\u0010.\u001a\u00020\u00172\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001700H\u0002J\b\u00101\u001a\u00020\u0019H\u0016J\b\u00102\u001a\u00020\u0019H\u0016J\u000e\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u0015J\u000e\u00108\u001a\u00020\u00172\u0006\u00107\u001a\u000209R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/tencent/state/service/VasSquareDataProvider;", "Lcom/tencent/state/square/api/SquareDataProvider;", GetAdInfoRequest.SOURCE_FROM, "", "messageService", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "pttMessageService", "Lcom/tencent/state/square/api/ISquarePttMessageService;", "(Ljava/lang/String;Lcom/tencent/state/square/api/ISquareBaseMessageService;Lcom/tencent/state/square/api/ISquarePttMessageService;)V", "backgroundInfo", "Lcom/tencent/state/service/SquarePageBackgroundInfo;", "currentPage", "", "recentUserList", "", "squarePageInfoArray", "Landroid/util/SparseArray;", "Lcom/tencent/state/service/SquarePageInfo;", "tipType", "totalPage", "unreadMsgList", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "doGetSquarePage", "", "isNext", "", "callback", "Lkotlin/Function5;", "Lcom/tencent/state/map/MapItem;", "Lkotlin/ParameterName;", "name", "list", "hasMore", "Lcom/tencent/state/data/Image;", "map", "useCache", "isForbid", "getBackgroundInfo", "getCurrentPageInfo", "getRecentUserList", "getSquareNextPage", "hasNext", "getTipType", "getTroopPreviewMessage", "Lkotlin/Function1;", "getUnreadMsgList", "initMsgListIfNeed", "onDone", "Lkotlin/Function0;", "isFirstPage", "isLastPage", "updatePageAvatarStatus", "data", "Lcom/tencent/state/square/data/SquareAvatarItem;", "updatePageAvatarUnreadCount", "message", "updatePageTroopUnreadCount", "Lcom/tencent/state/square/api/SquareTroopMessageRecord;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquareDataProvider implements SquareDataProvider {
    private static final int ForbidCode = 23080;
    private static final String TAG = "VasSquareDataProvider";
    private SquarePageBackgroundInfo backgroundInfo;
    private int currentPage;
    private final ISquareBaseMessageService messageService;
    private final ISquarePttMessageService pttMessageService;
    private List<String> recentUserList;
    private final String sourceFrom;
    private SparseArray<SquarePageInfo> squarePageInfoArray;
    private int tipType;
    private int totalPage;
    private List<? extends SquareBaseMessageRecord> unreadMsgList;

    public VasSquareDataProvider(String sourceFrom, ISquareBaseMessageService iSquareBaseMessageService, ISquarePttMessageService iSquarePttMessageService) {
        Intrinsics.checkNotNullParameter(sourceFrom, "sourceFrom");
        this.sourceFrom = sourceFrom;
        this.messageService = iSquareBaseMessageService;
        this.pttMessageService = iSquarePttMessageService;
        this.squarePageInfoArray = new SparseArray<>();
    }

    private final void doGetSquarePage(boolean isNext, Function5<? super List<? extends MapItem>, ? super Boolean, ? super Image, ? super Boolean, ? super Boolean, Unit> callback) {
        initMsgListIfNeed(new VasSquareDataProvider$doGetSquarePage$1(this, isNext, callback));
    }

    private final void initMsgListIfNeed(final Function0<Unit> onDone) {
        if (this.unreadMsgList == null && this.recentUserList == null) {
            ISquareBaseMessageService iSquareBaseMessageService = this.messageService;
            if (iSquareBaseMessageService != null) {
                ISquareBaseMessageService.DefaultImpls.getRecentMsgListSyncAioTable$default(iSquareBaseMessageService, 0, MessageRecordType.RECORD_TYPE_FRIEND, new Function1<List<? extends SquareBaseMessageRecord>, Unit>() { // from class: com.tencent.state.service.VasSquareDataProvider$initMsgListIfNeed$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends SquareBaseMessageRecord> list) {
                        invoke2(list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final List<? extends SquareBaseMessageRecord> recentFriendList) {
                        ISquareBaseMessageService iSquareBaseMessageService2;
                        Intrinsics.checkNotNullParameter(recentFriendList, "recentFriendList");
                        iSquareBaseMessageService2 = VasSquareDataProvider.this.messageService;
                        ISquareBaseMessageService.DefaultImpls.getRecentMsgListSyncAioTable$default(iSquareBaseMessageService2, 0, MessageRecordType.RECORD_TYPE_SQUARE_TEMP, new Function1<List<? extends SquareBaseMessageRecord>, Unit>() { // from class: com.tencent.state.service.VasSquareDataProvider$initMsgListIfNeed$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(List<? extends SquareBaseMessageRecord> list) {
                                invoke2(list);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(List<? extends SquareBaseMessageRecord> recentTempList) {
                                List sortedWith;
                                List<SquareBaseMessageRecord> list;
                                List list2;
                                List sortedWith2;
                                int collectionSizeOrDefault;
                                ISquarePttMessageService iSquarePttMessageService;
                                Intrinsics.checkNotNullParameter(recentTempList, "recentTempList");
                                ArrayList arrayList = new ArrayList();
                                arrayList.addAll(recentFriendList);
                                arrayList.addAll(recentTempList);
                                VasSquareDataProvider vasSquareDataProvider = VasSquareDataProvider.this;
                                List list3 = recentFriendList;
                                ArrayList arrayList2 = new ArrayList();
                                for (Object obj : list3) {
                                    SquareBaseMessageRecord squareBaseMessageRecord = (SquareBaseMessageRecord) obj;
                                    if (squareBaseMessageRecord.getUnreadCount() > 0 || squareBaseMessageRecord.getUnReadMark()) {
                                        arrayList2.add(obj);
                                    }
                                }
                                sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList2, new Comparator<T>() { // from class: com.tencent.state.service.VasSquareDataProvider$initMsgListIfNeed$1$1$$special$$inlined$sortedByDescending$1
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.util.Comparator
                                    public final int compare(T t16, T t17) {
                                        int compareValues;
                                        compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((SquareBaseMessageRecord) t17).getLastTimeStamp()), Long.valueOf(((SquareBaseMessageRecord) t16).getLastTimeStamp()));
                                        return compareValues;
                                    }
                                });
                                vasSquareDataProvider.unreadMsgList = sortedWith;
                                list = VasSquareDataProvider.this.unreadMsgList;
                                if (list != null) {
                                    for (SquareBaseMessageRecord squareBaseMessageRecord2 : list) {
                                        iSquarePttMessageService = VasSquareDataProvider.this.pttMessageService;
                                        if (iSquarePttMessageService != null) {
                                            iSquarePttMessageService.preLoadPttMessage(squareBaseMessageRecord2.getUin(), squareBaseMessageRecord2.getUnreadCount());
                                        }
                                    }
                                }
                                VasSquareDataProvider vasSquareDataProvider2 = VasSquareDataProvider.this;
                                list2 = CollectionsKt___CollectionsKt.toList(arrayList);
                                sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(list2, new Comparator<T>() { // from class: com.tencent.state.service.VasSquareDataProvider$initMsgListIfNeed$1$1$$special$$inlined$sortedByDescending$2
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.util.Comparator
                                    public final int compare(T t16, T t17) {
                                        int compareValues;
                                        compareValues = ComparisonsKt__ComparisonsKt.compareValues(((SquareBaseMessageRecord) t17).getLastMsg(), ((SquareBaseMessageRecord) t16).getLastMsg());
                                        return compareValues;
                                    }
                                });
                                List list4 = sortedWith2;
                                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                                Iterator it = list4.iterator();
                                while (it.hasNext()) {
                                    arrayList3.add(((SquareBaseMessageRecord) it.next()).getUin());
                                }
                                vasSquareDataProvider2.recentUserList = arrayList3;
                                onDone.invoke();
                            }
                        }, 1, null);
                    }
                }, 1, null);
                return;
            }
            return;
        }
        onDone.invoke();
    }

    public final SquarePageBackgroundInfo getBackgroundInfo() {
        return this.backgroundInfo;
    }

    public final SquarePageInfo getCurrentPageInfo() {
        return this.squarePageInfoArray.get(this.currentPage);
    }

    public final List<String> getRecentUserList() {
        List<String> emptyList;
        List<String> list = this.recentUserList;
        if (list != null) {
            return list;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // com.tencent.state.square.api.SquareDataProvider
    public void getSquareNextPage(Function5<? super List<? extends MapItem>, ? super Boolean, ? super Image, ? super Boolean, ? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        doGetSquarePage(true, callback);
    }

    public final int getTipType() {
        return this.tipType;
    }

    public final List<SquareBaseMessageRecord> getUnreadMsgList() {
        return this.unreadMsgList;
    }

    @Override // com.tencent.state.square.api.SquareDataProvider
    public boolean isFirstPage() {
        return this.currentPage == 1;
    }

    @Override // com.tencent.state.square.api.SquareDataProvider
    public boolean isLastPage() {
        return this.currentPage == this.totalPage;
    }

    public final void updatePageAvatarStatus(SquareAvatarItem data) {
        Object obj;
        Intrinsics.checkNotNullParameter(data, "data");
        int size = this.squarePageInfoArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            Iterator<T> it = this.squarePageInfoArray.valueAt(i3).getSquareItemList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                MapItem mapItem = (MapItem) obj;
                if (Intrinsics.areEqual(mapItem.getUin(), data.getUin()) && (mapItem instanceof SquareAvatarItem)) {
                    break;
                }
            }
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) (obj instanceof SquareAvatarItem ? obj : null);
            if (squareAvatarItem != null) {
                squareAvatarItem.setActions(data.getActions());
                squareAvatarItem.setStandActions(data.getStandActions());
                squareAvatarItem.getExtra().setOnlineStatus(data.getExtra().getOnlineStatus());
                Resource resource = SquareResourceManagerKt.getResource(data);
                if (resource != null) {
                    squareAvatarItem.setLocation(MapItemKt.relocation(squareAvatarItem.getLocation(), resource.getShowSize()));
                }
            }
        }
    }

    public final boolean updatePageAvatarUnreadCount(SquareBaseMessageRecord message) {
        Object obj;
        Intrinsics.checkNotNullParameter(message, "message");
        int size = this.squarePageInfoArray.size();
        boolean z16 = false;
        for (int i3 = 0; i3 < size; i3++) {
            Iterator<T> it = this.squarePageInfoArray.valueAt(i3).getSquareItemList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                MapItem mapItem = (MapItem) obj;
                if (Intrinsics.areEqual(mapItem.getUin(), message.getUin()) && (mapItem instanceof SquareAvatarItem)) {
                    break;
                }
            }
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) (obj instanceof SquareAvatarItem ? obj : null);
            if (squareAvatarItem != null) {
                boolean z17 = squareAvatarItem.getExtra().unReadCount() <= 0 && message.getUnreadCount() > 0;
                boolean z18 = squareAvatarItem.getExtra().unReadCount() > 0 && message.getUnreadCount() <= 0;
                if (z17 || z18) {
                    z16 = true;
                }
                squareAvatarItem.getExtra().setLastUnReadMsg(message);
            }
        }
        return z16;
    }

    public final void updatePageTroopUnreadCount(SquareTroopMessageRecord message) {
        Object obj;
        Intrinsics.checkNotNullParameter(message, "message");
        int size = this.squarePageInfoArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            Iterator<T> it = this.squarePageInfoArray.valueAt(i3).getSquareItemList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                MapItem mapItem = (MapItem) obj;
                if (Intrinsics.areEqual(mapItem.getUin(), message.getUin()) && (mapItem instanceof SquareTroopItem)) {
                    break;
                }
            }
            SquareTroopItem squareTroopItem = (SquareTroopItem) (obj instanceof SquareTroopItem ? obj : null);
            if (squareTroopItem != null) {
                squareTroopItem.setLastMsg(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getTroopPreviewMessage(final List<? extends MapItem> list, final Function1<? super List<? extends MapItem>, Unit> callback) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((MapItem) obj).getType() == 4) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            callback.invoke(list);
            return;
        }
        ISquareBaseMessageService iSquareBaseMessageService = this.messageService;
        if (iSquareBaseMessageService != null) {
            iSquareBaseMessageService.getRecentMsgListSyncAioTable(-1, MessageRecordType.RECORD_TYPE_TROOP, new Function1<List<? extends SquareBaseMessageRecord>, Unit>() { // from class: com.tencent.state.service.VasSquareDataProvider$getTroopPreviewMessage$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends SquareBaseMessageRecord> list2) {
                    invoke2(list2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends SquareBaseMessageRecord> msgList) {
                    Object obj2;
                    ISquareBaseMessageService iSquareBaseMessageService2;
                    Intrinsics.checkNotNullParameter(msgList, "msgList");
                    for (SquareBaseMessageRecord squareBaseMessageRecord : msgList) {
                        Iterator it = list.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                obj2 = it.next();
                                if (Intrinsics.areEqual(((MapItem) obj2).getUin(), squareBaseMessageRecord.getUin())) {
                                    break;
                                }
                            } else {
                                obj2 = null;
                                break;
                            }
                        }
                        if (!(obj2 instanceof SquareTroopItem)) {
                            obj2 = null;
                        }
                        SquareTroopItem squareTroopItem = (SquareTroopItem) obj2;
                        if (squareTroopItem != null) {
                            SquareTroopMessageRecord squareTroopMessageRecord = (SquareTroopMessageRecord) (squareBaseMessageRecord instanceof SquareTroopMessageRecord ? squareBaseMessageRecord : null);
                            if (squareTroopMessageRecord != null) {
                                iSquareBaseMessageService2 = VasSquareDataProvider.this.messageService;
                                boolean z16 = !iSquareBaseMessageService2.isReceiveNotify(squareBaseMessageRecord.getUin(), MessageRecordType.RECORD_TYPE_TROOP);
                                squareTroopItem.setLastMsg(squareTroopMessageRecord);
                                squareTroopItem.getExtra().setDisturb(z16);
                            }
                        }
                    }
                    callback.invoke(list);
                }
            });
        }
    }
}
