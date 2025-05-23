package com.tencent.state.square;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.state.data.SquareJSConst;
import com.tencent.state.map.IMapLocator;
import com.tencent.state.map.IMapPlayManager;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemController;
import com.tencent.state.map.MapPlayableItem;
import com.tencent.state.map.MapViewUpdater;
import com.tencent.state.square.api.SongInfo;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareMessageRecord;
import com.tencent.state.square.api.SquareTroopMessageRecord;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.data.ChatLandTableItem;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.data.BuildingBubble;
import com.tencent.state.square.data.PlayState;
import com.tencent.state.square.data.QZoneFeedsInfo;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareBlindBoxEntranceInfo;
import com.tencent.state.square.data.SquareEntranceItem;
import com.tencent.state.square.data.SquareRecommendUserItem;
import com.tencent.state.square.data.SquareStyleInfo;
import com.tencent.state.square.data.SquareTroopItem;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.square.detail.StatusUpdateData;
import com.tencent.state.square.flower.data.MedalData;
import com.tencent.state.square.friendsetting.PlaceInfo;
import com.tencent.state.square.layout.IDynamicLayoutComponent;
import com.tencent.state.square.like.LikeListInfo;
import com.tencent.state.template.data.CommonFootLabel;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.push.BubbleMessage;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00fe\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ$\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0012H\u0016J\u0016\u0010\u0013\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u001c\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0002J\u001e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000fH\u0016J\"\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u000fH\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J\u001a\u0010'\u001a\u0004\u0018\u00010$2\u0006\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u001cH\u0016J\u0010\u0010*\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J\u0012\u0010+\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J\u000f\u0010,\u001a\u0004\u0018\u00010\u0017H\u0016\u00a2\u0006\u0002\u0010-J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u000fH\u0016J\u0010\u00100\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J \u00100\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\u0006\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u0017H\u0016J\u0010\u00103\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u00104\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u00105\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\u0006\u00106\u001a\u00020\u001cH\u0016J\u0018\u00107\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\u0006\u00101\u001a\u00020\u001cH\u0016J\u0010\u00108\u001a\u00020\r2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020\r2\u0006\u0010=\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010B\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010C\u001a\u00020\rH\u0016J\u0018\u0010D\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\u0006\u0010E\u001a\u00020\u0017H\u0016J\u0016\u0010F\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020/0\u000fH\u0016J\u0010\u0010G\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020&H\u0016J\u0018\u0010J\u001a\u00020\r2\u0006\u0010I\u001a\u00020&2\u0006\u0010K\u001a\u00020\u0017H\u0016J\u0010\u0010L\u001a\u00020\r2\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u00020\r2\u0006\u0010P\u001a\u00020QH\u0016J\u0018\u0010R\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\u0006\u0010S\u001a\u00020TH\u0016J\"\u0010U\u001a\u00020\r2\u0018\u0010V\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020X0\u00140WH\u0016J\u0018\u0010Y\u001a\u00020\r2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0016J\u001c\u0010^\u001a\u00020\r2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020X0WH\u0016J\u0018\u0010_\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\u0006\u0010`\u001a\u00020aH\u0016J\"\u0010b\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\u0006\u0010c\u001a\u00020\u001c2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\u0010\u0010f\u001a\u00020\r2\u0006\u0010g\u001a\u00020&H\u0016J\u0012\u0010h\u001a\u00020\r2\b\u0010Z\u001a\u0004\u0018\u00010iH\u0016J\u0010\u0010j\u001a\u00020\r2\u0006\u0010k\u001a\u00020lH\u0016J\u0010\u0010m\u001a\u00020\r2\u0006\u0010n\u001a\u00020&H\u0016J\u0018\u0010o\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\u0006\u0010p\u001a\u00020qH\u0016J\u0010\u0010r\u001a\u00020\r2\u0006\u0010s\u001a\u00020tH\u0016J\u0018\u0010u\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\u0006\u0010v\u001a\u00020wH\u0016J\u001a\u0010x\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\b\u0010y\u001a\u0004\u0018\u00010zH\u0016R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006{"}, d2 = {"Lcom/tencent/state/square/SquareViewUpdater;", "Lcom/tencent/state/map/MapViewUpdater;", "Lcom/tencent/state/square/ISquareViewUpdater;", "adapter", "Lcom/tencent/state/square/SquareBaseAdapter;", "logger", "Lcom/tencent/state/map/IMapLocator;", "rpm", "Lcom/tencent/state/map/IMapPlayManager;", "(Lcom/tencent/state/square/SquareBaseAdapter;Lcom/tencent/state/map/IMapLocator;Lcom/tencent/state/map/IMapPlayManager;)V", "getAdapter", "()Lcom/tencent/state/square/SquareBaseAdapter;", "appendOrUpdateChatLandUserItem", "", "list", "", "Lcom/tencent/state/map/MapItem;", "onDone", "Lkotlin/Function0;", "appendOrUpdateRecommendUserItem", "", "Lcom/tencent/state/square/data/SquareRecommendUserItem;", "checkSameChatLand", "", "srcItem", "dstItem", "clearNewInfo", "index", "", "targetTypes", "doAirborneLanding", "", "Lcom/tencent/state/square/MoveItem;", "Lcom/tencent/state/square/MoveResult;", VideoTemplateParser.ITEM_LIST, "doAvatarCloseToMe", "Lcom/tencent/state/square/friendsetting/PlaceInfo;", "uin", "", "doAvatarSetTop", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "unReadMsgCount", "foldTroopMessage", "getCloseToMePlace", "getCurAvatarGender", "()Ljava/lang/Boolean;", "getCurMeActions", "Lcom/tencent/state/square/data/AvatarAction;", "hide", "itemType", "skipAnim", "hideRingAnim", "hideSpeakBubble", "isNotInSquare", SquareJSConst.Params.PARAMS_UNIT_TYPE, "isNotInSquareUinItemType", "onFootLabelChangeNotify", "label", "Lcom/tencent/state/template/data/CommonFootLabel;", "onNewMessage", "onTroopUnreadMessageNotify", "message", "Lcom/tencent/state/square/api/SquareTroopMessageRecord;", "onUnreadMessageNotify", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "pauseAndEnsurePlay", "playRingAnim", "saveBuildingChange", "setAvatarFixed", "isFixed", "setMeActions", "showTroopMessage", "updateAvatarCover", "id", "updateAvatarImageVisible", "show", "updateAvatarLocationView", "locationInfo", "Lcom/tencent/state/square/data/AvatarLocationInfo;", "updateBlindBoxEntrance", "blindBoxEntranceInfo", "Lcom/tencent/state/square/data/SquareBlindBoxEntranceInfo;", "updateBubbleSkin", "bubbleInfo", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "updateBuildingBubble", "result", "", "Lcom/tencent/state/square/data/BuildingBubble;", "updateBuildingStyle", "data", "Lcom/tencent/state/square/data/SquareEntranceItem;", "styleInfo", "Lcom/tencent/state/square/data/SquareStyleInfo;", "updateExtraBuildingBubble", "updateFeedsBubble", "feedsInfo", "Lcom/tencent/state/square/data/QZoneFeedsInfo;", "updateFlowerInfo", "flowerCount", "flowerMedal", "Lcom/tencent/state/square/flower/data/MedalData;", "updateMeCustomText", "md5", "updateMeLikeUnReadNum", "Lcom/tencent/state/square/like/LikeListInfo;", "updateMeStatus", "newItem", "Lcom/tencent/state/square/detail/StatusUpdateData;", "updateMusicPlayState", "songMid", "updatePttPlayState", "state", "Lcom/tencent/state/square/data/PlayState;", "updateSpeakBubble", "bubble", "Lcom/tencent/state/template/push/BubbleMessage;", "updateStickers", c.B, "Lcom/tencent/state/square/data/Stickers;", "updateUserSongInfo", "songInfo", "Lcom/tencent/state/square/api/SongInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareViewUpdater extends MapViewUpdater implements ISquareViewUpdater {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareViewUpdater(SquareBaseAdapter squareBaseAdapter, IMapLocator logger, IMapPlayManager iMapPlayManager) {
        super(squareBaseAdapter, iMapPlayManager, logger);
        Intrinsics.checkNotNullParameter(logger, "logger");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
    
        if (r0 != null) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean checkSameChatLand(MapItem srcItem, MapItem dstItem) {
        Unit unit;
        ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) (!(srcItem instanceof ChatLandAvatarItem) ? null : srcItem);
        if (chatLandAvatarItem != null) {
            ChatLandAvatarItem chatLandAvatarItem2 = (ChatLandAvatarItem) (!(dstItem instanceof ChatLandAvatarItem) ? null : dstItem);
            if (chatLandAvatarItem2 != null) {
                r3 = chatLandAvatarItem.getAppId() == chatLandAvatarItem2.getAppId();
                unit = Unit.INSTANCE;
            } else {
                ChatLandTableItem chatLandTableItem = (ChatLandTableItem) (!(dstItem instanceof ChatLandTableItem) ? null : dstItem);
                if (chatLandTableItem != null) {
                    r3 = chatLandAvatarItem.getAppId() == chatLandTableItem.getAppId();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
            }
        }
        ChatLandTableItem chatLandTableItem2 = (ChatLandTableItem) (!(srcItem instanceof ChatLandTableItem) ? null : srcItem);
        if (chatLandTableItem2 != null) {
            ChatLandAvatarItem chatLandAvatarItem3 = (ChatLandAvatarItem) (!(dstItem instanceof ChatLandAvatarItem) ? null : dstItem);
            if (chatLandAvatarItem3 != null) {
                if (chatLandTableItem2.getAppId() == chatLandAvatarItem3.getAppId()) {
                    r3 = true;
                }
                Unit unit2 = Unit.INSTANCE;
            } else {
                ChatLandTableItem chatLandTableItem3 = (ChatLandTableItem) (!(dstItem instanceof ChatLandTableItem) ? null : dstItem);
                if (chatLandTableItem3 != null) {
                    if (chatLandTableItem2.getAppId() == chatLandTableItem3.getAppId()) {
                        r3 = true;
                    }
                    Unit unit3 = Unit.INSTANCE;
                }
            }
        }
        if (!(srcItem instanceof SquareEntranceItem)) {
            srcItem = null;
        }
        SquareEntranceItem squareEntranceItem = (SquareEntranceItem) srcItem;
        if (squareEntranceItem == null) {
            return r3;
        }
        if (!(dstItem instanceof SquareEntranceItem)) {
            dstItem = null;
        }
        SquareEntranceItem squareEntranceItem2 = (SquareEntranceItem) dstItem;
        if (squareEntranceItem2 != null) {
            return squareEntranceItem.getAppId() != squareEntranceItem2.getAppId() ? r3 : true;
        }
        return r3;
    }

    private final SquareBaseAdapter getAdapter() {
        MapAdapter mapAdapter = getMapAdapter();
        if (!(mapAdapter instanceof SquareBaseAdapter)) {
            mapAdapter = null;
        }
        return (SquareBaseAdapter) mapAdapter;
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void appendOrUpdateChatLandUserItem(List<? extends MapItem> list, Function0<Unit> onDone) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(onDone, "onDone");
        final MapAdapter mapAdapter = getMapAdapter();
        if (mapAdapter != null) {
            final ArrayList arrayList = new ArrayList();
            for (final MapItem mapItem : list) {
                int indexOf = mapAdapter.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareViewUpdater$appendOrUpdateChatLandUserItem$$inlined$forEach$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem2) {
                        return Boolean.valueOf(invoke2(mapItem2));
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final boolean invoke2(MapItem it) {
                        boolean checkSameChatLand;
                        SitDownInfo sitDown;
                        Intrinsics.checkNotNullParameter(it, "it");
                        checkSameChatLand = this.checkSameChatLand(it, MapItem.this);
                        if (!checkSameChatLand) {
                            return false;
                        }
                        boolean z16 = it instanceof ChatLandTableItem;
                        if (z16 && (MapItem.this instanceof ChatLandTableItem)) {
                            return ((ChatLandTableItem) it).getTable().getId() == ((ChatLandTableItem) MapItem.this).getTable().getId();
                        }
                        if (z16 && (MapItem.this instanceof ChatLandAvatarItem)) {
                            long id5 = ((ChatLandTableItem) it).getTable().getId();
                            SitDownInfo sitDown2 = ((ChatLandAvatarItem) MapItem.this).getUser().getSitDown();
                            return sitDown2 != null && id5 == sitDown2.getTableId();
                        }
                        boolean z17 = it instanceof ChatLandAvatarItem;
                        if (z17 && (MapItem.this instanceof ChatLandTableItem)) {
                            SitDownInfo sitDown3 = ((ChatLandAvatarItem) it).getUser().getSitDown();
                            return sitDown3 != null && sitDown3.getTableId() == ((ChatLandTableItem) MapItem.this).getTable().getId();
                        }
                        if (z17 && (MapItem.this instanceof ChatLandAvatarItem)) {
                            ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) it;
                            if (Intrinsics.areEqual(chatLandAvatarItem.getUser().getUin(), ((ChatLandAvatarItem) MapItem.this).getUser().getUin())) {
                                return true;
                            }
                            SitDownInfo sitDown4 = chatLandAvatarItem.getUser().getSitDown();
                            Long valueOf = sitDown4 != null ? Long.valueOf(sitDown4.getTableId()) : null;
                            SitDownInfo sitDown5 = ((ChatLandAvatarItem) MapItem.this).getUser().getSitDown();
                            if (Intrinsics.areEqual(valueOf, sitDown5 != null ? Long.valueOf(sitDown5.getTableId()) : null) && ((sitDown = chatLandAvatarItem.getUser().getSitDown()) == null || !sitDown.getIsFlexTable())) {
                                return true;
                            }
                        }
                        if ((it instanceof SquareEntranceItem) && (MapItem.this instanceof SquareEntranceItem)) {
                            return Intrinsics.areEqual(it.getUin(), MapItem.this.getUin());
                        }
                        return false;
                    }
                });
                if (indexOf >= 0) {
                    updateItem(indexOf, mapItem);
                } else {
                    arrayList.add(mapItem);
                }
            }
            appendItemList(arrayList);
            onDone.invoke();
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void appendOrUpdateRecommendUserItem(List<SquareRecommendUserItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        MapAdapter mapAdapter = getMapAdapter();
        if (mapAdapter != null) {
            for (final SquareRecommendUserItem squareRecommendUserItem : list) {
                int indexOf = mapAdapter.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareViewUpdater$appendOrUpdateRecommendUserItem$1$index$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem) {
                        return Boolean.valueOf(invoke2(mapItem));
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final boolean invoke2(MapItem it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.getLocation().getArea() == SquareRecommendUserItem.this.getLocation().getArea() && it.getLocation().getRank() == SquareRecommendUserItem.this.getLocation().getRank();
                    }
                });
                if (indexOf >= 0) {
                    updateItem(indexOf, squareRecommendUserItem);
                } else {
                    appendItem(squareRecommendUserItem);
                }
            }
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void clearNewInfo(int index, List<Integer> targetTypes) {
        Intrinsics.checkNotNullParameter(targetTypes, "targetTypes");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.clearNewInfo(index, targetTypes);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public Map<MoveItem, MoveResult> doAirborneLanding(List<MoveItem> itemList) {
        Map<MoveItem, MoveResult> emptyMap;
        SquareBaseAdapter adapter;
        MapItemController controller;
        IMapViewListener listener;
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        SquareBaseAdapter adapter2 = getAdapter();
        if (adapter2 == null || (emptyMap = adapter2.doAirborneLanding(itemList)) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<MoveItem, MoveResult> entry : emptyMap.entrySet()) {
            if (entry.getValue().getType() == MoveType.AddToSquare) {
                arrayList.add(entry.getKey());
            }
        }
        if ((!arrayList.isEmpty()) && (adapter = getAdapter()) != null && (controller = adapter.getController()) != null && (listener = controller.getListener()) != null) {
            listener.onRoleAdded(arrayList);
        }
        return emptyMap;
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public PlaceInfo doAvatarCloseToMe(String uin) {
        IDynamicLayoutComponent layoutManager;
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter == null || (layoutManager = adapter.getLayoutManager()) == null) {
            return null;
        }
        return layoutManager.doAvatarCloseToMe(uin);
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public PlaceInfo doAvatarSetTop(MoveItem item, int unReadMsgCount) {
        Intrinsics.checkNotNullParameter(item, "item");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.doAvatarSetTop(item, unReadMsgCount);
        }
        return null;
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void foldTroopMessage(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateTroopMessageHide(uin, true);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public PlaceInfo getCloseToMePlace(String uin) {
        IDynamicLayoutComponent layoutManager;
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter == null || (layoutManager = adapter.getLayoutManager()) == null) {
            return null;
        }
        return layoutManager.getCloseToMePlace(uin);
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public Boolean getCurAvatarGender() {
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            MapItem itemData = adapter.getItemData(adapter.getMeIndex());
            if (!(itemData instanceof SquareAvatarItem)) {
                itemData = null;
            }
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) itemData;
            if (squareAvatarItem != null) {
                return Boolean.valueOf(squareAvatarItem.getIsGenderMale());
            }
            return null;
        }
        return Boolean.FALSE;
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public List<AvatarAction> getCurMeActions() {
        List<AvatarAction> emptyList;
        List<AvatarAction> emptyList2;
        List<AvatarAction> actions;
        SquareBaseAdapter adapter = getAdapter();
        if (adapter == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        MapItem itemData = adapter.getItemData(adapter.getMeIndex());
        if (!(itemData instanceof SquareAvatarItem)) {
            itemData = null;
        }
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) itemData;
        if (squareAvatarItem != null && (actions = squareAvatarItem.getActions()) != null) {
            return actions;
        }
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        return emptyList2;
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void hide(String uin) {
        SquareBaseAdapter adapter;
        MapItemController controller;
        IMapViewListener listener;
        List<String> listOf;
        IDynamicLayoutComponent layoutManager;
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseAdapter adapter2 = getAdapter();
        if (!((adapter2 == null || (layoutManager = adapter2.getLayoutManager()) == null) ? false : layoutManager.hide(uin)) || (adapter = getAdapter()) == null || (controller = adapter.getController()) == null || (listener = controller.getListener()) == null) {
            return;
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(uin);
        listener.onRoleRemoved(listOf);
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void hideRingAnim(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.hideRingAnim(uin);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void hideSpeakBubble(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.hideSpeakBubble(uin);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public boolean isNotInSquare(String uin, int unitType) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseAdapter adapter = getAdapter();
        return adapter != null && adapter.indexOfUnitType(uin, unitType) == -1;
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public boolean isNotInSquareUinItemType(String uin, int itemType) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseAdapter adapter = getAdapter();
        return adapter != null && adapter.indexOf(uin, itemType) == -1;
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void onFootLabelChangeNotify(CommonFootLabel label) {
        Intrinsics.checkNotNullParameter(label, "label");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateFootLabel(label);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void onNewMessage(int index) {
        String str;
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            MapItem itemData = adapter.getItemData(index);
            if (!(itemData instanceof SquareAvatarItem)) {
                itemData = null;
            }
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) itemData;
            if (squareAvatarItem == null || (str = squareAvatarItem.getUin()) == null) {
                str = "";
            }
            SquareMessageRecord squareMessageRecord = new SquareMessageRecord(str, null, 2, null);
            squareMessageRecord.setNickName("xxxxxx");
            squareMessageRecord.setUnreadCount(1);
            squareMessageRecord.setLastTimeStamp(System.currentTimeMillis());
            Unit unit = Unit.INSTANCE;
            onUnreadMessageNotify(squareMessageRecord);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void onTroopUnreadMessageNotify(SquareTroopMessageRecord message) {
        Intrinsics.checkNotNullParameter(message, "message");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateTroopUnreadMessage(message);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void onUnreadMessageNotify(SquareBaseMessageRecord message) {
        Intrinsics.checkNotNullParameter(message, "message");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateUnreadMessage(message);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void pauseAndEnsurePlay(final String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            int indexOf = adapter.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareViewUpdater$pauseAndEnsurePlay$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem) {
                    return Boolean.valueOf(invoke2(mapItem));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(MapItem it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Intrinsics.areEqual(it.getUin(), uin);
                }
            });
            IMapPlayManager rpm = getRpm();
            if (rpm != null) {
                rpm.pauseAndEnsurePlay(indexOf);
            }
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void playRingAnim(final String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.playRingAnim(adapter.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareViewUpdater$playRingAnim$index$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem) {
                    return Boolean.valueOf(invoke2(mapItem));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(MapItem it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Intrinsics.areEqual(it.getUin(), uin) && ((it instanceof SquareAvatarItem) || (it instanceof SquareTroopItem));
                }
            }));
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void saveBuildingChange() {
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.saveBuildingChange();
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void setAvatarFixed(String uin, boolean isFixed) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.setAvatarPlaceInfo(uin, isFixed);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void setMeActions(List<AvatarAction> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            MapItem itemData = adapter.getItemData(adapter.getMeIndex());
            if (!(itemData instanceof SquareAvatarItem)) {
                itemData = null;
            }
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) itemData;
            if (squareAvatarItem != null) {
                squareAvatarItem.setActions(list);
            }
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void showTroopMessage(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateTroopMessageHide(uin, false);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void updateAvatarCover(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateAvatarCover(id5);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void updateAvatarImageVisible(String id5, boolean show) {
        Intrinsics.checkNotNullParameter(id5, "id");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateAvatarImageVisible(id5, show);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void updateAvatarLocationView(AvatarLocationInfo locationInfo) {
        Intrinsics.checkNotNullParameter(locationInfo, "locationInfo");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateAvatarLocationView(locationInfo);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void updateBlindBoxEntrance(SquareBlindBoxEntranceInfo blindBoxEntranceInfo) {
        Intrinsics.checkNotNullParameter(blindBoxEntranceInfo, "blindBoxEntranceInfo");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateBlindBoxEntrance(blindBoxEntranceInfo);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void updateBubbleSkin(String uin, SquareBubbleInfo bubbleInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateBubbleSkin(uin, bubbleInfo);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void updateBuildingBubble(Map<Integer, List<BuildingBubble>> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateBuildingBubble(result);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void updateBuildingStyle(SquareEntranceItem data, SquareStyleInfo styleInfo) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(styleInfo, "styleInfo");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateBuildingStyle(data, styleInfo);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void updateExtraBuildingBubble(Map<Integer, BuildingBubble> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateExtraBuildingBubble(result);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void updateFeedsBubble(String uin, QZoneFeedsInfo feedsInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(feedsInfo, "feedsInfo");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateFeedsBubble(uin, feedsInfo);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void updateFlowerInfo(String uin, int flowerCount, MedalData flowerMedal) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        MapAdapter mapAdapter = getMapAdapter();
        if (mapAdapter != null) {
            int indexOf = mapAdapter.indexOf(uin, 1);
            MapItem itemData = mapAdapter.getItemData(indexOf);
            if (!(itemData instanceof SquareAvatarItem)) {
                itemData = null;
            }
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) itemData;
            if (squareAvatarItem != null) {
                squareAvatarItem.getExtra().setFlowerCount(flowerCount);
                squareAvatarItem.getExtra().setFlowerMedal(flowerMedal);
                mapAdapter.notifyItemChanged(indexOf, 22);
            }
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void updateMeCustomText(String md5) {
        Intrinsics.checkNotNullParameter(md5, "md5");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateCustomText(md5);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void updateMeLikeUnReadNum(LikeListInfo data) {
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateMeLikeNum(data);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void updateMeStatus(final StatusUpdateData newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        final SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.square.SquareViewUpdater$updateMeStatus$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                    invoke(num.intValue(), mapItem);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, MapItem mapItem) {
                    if (!(mapItem instanceof MapPlayableItem)) {
                        mapItem = null;
                    }
                    MapPlayableItem mapPlayableItem = (MapPlayableItem) mapItem;
                    if (mapPlayableItem == null || !mapPlayableItem.isMe()) {
                        return;
                    }
                    SquareBaseAdapter.this.updateAvatarStatus(i3, newItem);
                }
            });
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void updateMusicPlayState(String songMid) {
        Intrinsics.checkNotNullParameter(songMid, "songMid");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateMusicPlayState(songMid);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void updatePttPlayState(String uin, PlayState state) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(state, "state");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updatePttPlayState(uin, state);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void updateSpeakBubble(BubbleMessage bubble) {
        Intrinsics.checkNotNullParameter(bubble, "bubble");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateSpeakBubble(bubble);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void updateStickers(String uin, Stickers stickers) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(stickers, "stickers");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateAvatarSticker(uin, stickers);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void updateUserSongInfo(String uin, SongInfo songInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.updateUserSongInfo(uin, songInfo);
        }
    }

    @Override // com.tencent.state.square.ISquareViewUpdater
    public void hide(String uin, int itemType, boolean skipAnim) {
        SquareBaseAdapter adapter;
        MapItemController controller;
        IMapViewListener listener;
        List<String> listOf;
        IDynamicLayoutComponent layoutManager;
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareBaseAdapter adapter2 = getAdapter();
        if (!((adapter2 == null || (layoutManager = adapter2.getLayoutManager()) == null) ? false : layoutManager.hide(uin, itemType, skipAnim)) || itemType != 1 || (adapter = getAdapter()) == null || (controller = adapter.getController()) == null || (listener = controller.getListener()) == null) {
            return;
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(uin);
        listener.onRoleRemoved(listOf);
    }
}
