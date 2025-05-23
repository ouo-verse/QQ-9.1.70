package com.tencent.state.square;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.map.IMapLocator;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemKt;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.service.VasSquareSceneService;
import com.tencent.state.square.api.SongInfo;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareTroopMessageRecord;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.chatland.data.ChatLandAvatarExtra;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder;
import com.tencent.state.square.chatland.viewholder.ChatLandTableViewHolder;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.data.BuildingBubble;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.PlayState;
import com.tencent.state.square.data.QZoneFeedsInfo;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SpecialStatus;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareAvatarItemKt;
import com.tencent.state.square.data.SquareBlindBoxEntranceInfo;
import com.tencent.state.square.data.SquareBuildingInfo;
import com.tencent.state.square.data.SquareEntranceItem;
import com.tencent.state.square.data.SquareStyleInfo;
import com.tencent.state.square.data.SquareTroopItem;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.square.databinding.VasSquareItemAvatarBinding;
import com.tencent.state.square.databinding.VasSquareItemChatLandAvatarBinding;
import com.tencent.state.square.databinding.VasSquareItemChatLandTableBinding;
import com.tencent.state.square.databinding.VasSquareItemEntranceBinding;
import com.tencent.state.square.databinding.VasSquareItemMayKnowBinding;
import com.tencent.state.square.databinding.VasSquareItemRecommendUserBinding;
import com.tencent.state.square.databinding.VasSquareItemTroopBinding;
import com.tencent.state.square.detail.StatusUpdateData;
import com.tencent.state.square.friendsetting.PlaceInfo;
import com.tencent.state.square.holder.AvatarViewHolder;
import com.tencent.state.square.holder.EmptyViewHolder;
import com.tencent.state.square.holder.MayKnowViewHolder;
import com.tencent.state.square.holder.RecommendUserViewHolder;
import com.tencent.state.square.holder.SquareCommonEntranceViewHolder;
import com.tencent.state.square.holder.TroopViewHolder;
import com.tencent.state.square.layout.IDynamicLayoutComponent;
import com.tencent.state.square.like.LikeListInfo;
import com.tencent.state.template.data.CommonFootLabel;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.push.BubbleMessage;
import com.tencent.state.utils.CacheFileUtils;
import com.tencent.state.utils.StringFormatUtils;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.zplan.common.utils.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00ec\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 b2\u00020\u0001:\u0001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eJ\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH\u0016J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\u0019H&J\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cJ \u0010\u001e\u001a\n\u0012\u0002\b\u00030\u001fj\u0002` 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\fH\u0016J\u000e\u0010$\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010%\u001a\u00020\nJ\u0016\u0010&\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u001cJ\u0016\u0010+\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020(J\u000e\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020/J\u0016\u00100\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00101\u001a\u000202J\u0016\u00103\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u00020\n2\u0006\u00107\u001a\u000208J\u0016\u00109\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020;J \u0010<\u001a\u00020\n2\u0018\u0010=\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0?0>J\u0016\u0010A\u001a\u00020\n2\u0006\u00101\u001a\u00020B2\u0006\u0010C\u001a\u00020DJ\u000e\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u001cJ\u001a\u0010G\u001a\u00020\n2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020@0>J\u0018\u0010H\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020MH\u0017J\u0010\u0010N\u001a\u00020\n2\b\u00101\u001a\u0004\u0018\u00010OJ\u000e\u0010P\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\u001cJ\u0016\u0010R\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020TJ\u000e\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020WJ\u0016\u0010X\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010Y\u001a\u00020(J\u0010\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\\H\u0017J\u0010\u0010]\u001a\u00020\n2\u0006\u0010[\u001a\u00020^H\u0017J\u0018\u0010_\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010`\u001a\u0004\u0018\u00010aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006c"}, d2 = {"Lcom/tencent/state/square/SquareBaseAdapter;", "Lcom/tencent/state/map/MapAdapter;", "context", "Landroid/content/Context;", "locator", "Lcom/tencent/state/map/IMapLocator;", "(Landroid/content/Context;Lcom/tencent/state/map/IMapLocator;)V", "getLocator", "()Lcom/tencent/state/map/IMapLocator;", "clearNewInfo", "", "index", "", "targetTypes", "", "doAirborneLanding", "", "Lcom/tencent/state/square/MoveItem;", "Lcom/tencent/state/square/MoveResult;", VideoTemplateParser.ITEM_LIST, "doAvatarSetTop", "Lcom/tencent/state/square/friendsetting/PlaceInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "unReadMsgCount", "getDynamicLayoutComponent", "Lcom/tencent/state/square/layout/IDynamicLayoutComponent;", "hideRingAnim", "uin", "", "hideSpeakBubble", "onCreateViewHolder", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "playRingAnim", "saveBuildingChange", "setAvatarPlaceInfo", "isFixed", "", "updateAvatarCover", "filamentId", "updateAvatarImageVisible", "show", "updateAvatarLocationView", "locationInfo", "Lcom/tencent/state/square/data/AvatarLocationInfo;", "updateAvatarStatus", "data", "Lcom/tencent/state/square/detail/StatusUpdateData;", "updateAvatarSticker", "newStickers", "Lcom/tencent/state/square/data/Stickers;", "updateBlindBoxEntrance", "blindBoxEntranceInfo", "Lcom/tencent/state/square/data/SquareBlindBoxEntranceInfo;", "updateBubbleSkin", "bubbleInfo", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "updateBuildingBubble", "result", "", "", "Lcom/tencent/state/square/data/BuildingBubble;", "updateBuildingStyle", "Lcom/tencent/state/square/data/SquareEntranceItem;", "styleInfo", "Lcom/tencent/state/square/data/SquareStyleInfo;", "updateCustomText", "customTextMd5", "updateExtraBuildingBubble", "updateFeedsBubble", "feedsInfo", "Lcom/tencent/state/square/data/QZoneFeedsInfo;", "updateFootLabel", "label", "Lcom/tencent/state/template/data/CommonFootLabel;", "updateMeLikeNum", "Lcom/tencent/state/square/like/LikeListInfo;", "updateMusicPlayState", "songMid", "updatePttPlayState", "state", "Lcom/tencent/state/square/data/PlayState;", "updateSpeakBubble", "bubble", "Lcom/tencent/state/template/push/BubbleMessage;", "updateTroopMessageHide", "isBaned", "updateTroopUnreadMessage", "message", "Lcom/tencent/state/square/api/SquareTroopMessageRecord;", "updateUnreadMessage", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "updateUserSongInfo", "songInfo", "Lcom/tencent/state/square/api/SongInfo;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class SquareBaseAdapter extends MapAdapter {
    private static final String TAG = "SquareBaseAdapter";
    private final Context context;
    private final IMapLocator locator;

    public SquareBaseAdapter(Context context, IMapLocator locator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(locator, "locator");
        this.context = context;
        this.locator = locator;
    }

    public final void clearNewInfo(int index, List<Integer> targetTypes) {
        Intrinsics.checkNotNullParameter(targetTypes, "targetTypes");
        MapItem itemData = getItemData(index);
        if (!(itemData instanceof SquareAvatarItem)) {
            itemData = null;
        }
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) itemData;
        if (squareAvatarItem != null) {
            Iterator<T> it = targetTypes.iterator();
            while (it.hasNext()) {
                squareAvatarItem.updateNewFlag(((Number) it.next()).intValue(), false);
            }
            notifyItemChanged(index, 13);
        }
    }

    public Map<MoveItem, MoveResult> doAirborneLanding(List<MoveItem> itemList) {
        Map<MoveItem, MoveResult> emptyMap;
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    public PlaceInfo doAvatarSetTop(MoveItem item, int unReadMsgCount) {
        Intrinsics.checkNotNullParameter(item, "item");
        return null;
    }

    /* renamed from: getDynamicLayoutComponent */
    public abstract IDynamicLayoutComponent getLayoutManager();

    /* JADX INFO: Access modifiers changed from: protected */
    public final IMapLocator getLocator() {
        return this.locator;
    }

    public final void hideRingAnim(final String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        int indexOf = indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareBaseAdapter$hideRingAnim$index$1
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
                return (it instanceof ChatLandAvatarItem) && Intrinsics.areEqual(it.getUin(), uin);
            }
        });
        notifyItemChanged(indexOf, 32);
        SquareBaseKt.getSquareLog().d(TAG, "hideRingAnim: " + indexOf + " __ " + uin);
    }

    public final void hideSpeakBubble(final String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        int indexOf = indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareBaseAdapter$hideSpeakBubble$index$1
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
                return (it instanceof ChatLandAvatarItem) && Intrinsics.areEqual(it.getUin(), uin);
            }
        });
        MapItem itemData = getItemData(indexOf);
        if (!(itemData instanceof ChatLandAvatarItem)) {
            itemData = null;
        }
        ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) itemData;
        if (chatLandAvatarItem != null) {
            Object extra = chatLandAvatarItem.getExtra();
            if (!(extra instanceof ChatLandAvatarExtra)) {
                extra = null;
            }
            ChatLandAvatarExtra chatLandAvatarExtra = (ChatLandAvatarExtra) extra;
            if (chatLandAvatarExtra != null) {
                chatLandAvatarExtra.setSpeakBubble(null);
            }
        }
        notifyItemChanged(indexOf, 31);
        SquareBaseKt.getSquareLog().i(TAG, "hideSpeakBubble: " + indexOf + " __ " + uin);
    }

    public final void playRingAnim(int index) {
        MapItem itemData = getItemData(index);
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) (!(itemData instanceof SquareAvatarItem) ? null : itemData);
        if (squareAvatarItem != null) {
            squareAvatarItem.getExtra().setNeedRingPagAnim(true);
            notifyItemChanged(index, 9);
            return;
        }
        if (!(itemData instanceof SquareTroopItem)) {
            itemData = null;
        }
        SquareTroopItem squareTroopItem = (SquareTroopItem) itemData;
        if (squareTroopItem != null) {
            squareTroopItem.getExtra().setNeedRingAnim(true);
            notifyItemChanged(index, 10);
        }
    }

    public final void saveBuildingChange() {
        final ArrayList<SquareBuildingInfo> arrayList = new ArrayList<>();
        forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.square.SquareBaseAdapter$saveBuildingChange$1
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
                if (mapItem instanceof SquareEntranceItem) {
                    SquareEntranceItem squareEntranceItem = (SquareEntranceItem) mapItem;
                    if (squareEntranceItem.getEntranceType() == 10) {
                        arrayList.add(new SquareBuildingInfo(squareEntranceItem.getEntranceId(), squareEntranceItem.getStyleId()));
                    }
                }
            }
        });
        VasSquareSceneService.INSTANCE.saveBuildingStyle(arrayList);
    }

    public final void setAvatarPlaceInfo(final String uin, boolean isFixed) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        int indexOf = indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareBaseAdapter$setAvatarPlaceInfo$index$1
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
                return (it instanceof SquareAvatarItem) && Intrinsics.areEqual(it.getUin(), uin);
            }
        });
        if (indexOf < 0) {
            SquareBaseKt.getSquareLog().w(TAG, "setAvatarPlaceInfo find " + uin + " index error");
            return;
        }
        MapItem itemData = getItemData(indexOf);
        if (itemData instanceof SquareAvatarItem) {
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) itemData;
            if (squareAvatarItem.getExtra().getIsFixed() != isFixed) {
                squareAvatarItem.getExtra().setFixed(isFixed);
                notifyItemChanged(indexOf, 8);
            }
        }
    }

    public final void updateAvatarCover(String filamentId) {
        List split$default;
        int indexOf;
        Intrinsics.checkNotNullParameter(filamentId, "filamentId");
        split$default = StringsKt__StringsKt.split$default((CharSequence) filamentId, new String[]{"_"}, false, 0, 6, (Object) null);
        String str = (String) split$default.get(0);
        String str2 = (String) split$default.get(1);
        int parseInt = Integer.parseInt(str);
        if ((parseInt == 1 || parseInt == 4 || parseInt == 10) && (indexOf = indexOf(str2, parseInt)) != -1) {
            SquareBaseKt.getSquareLog().i(TAG, "updateAvatarCover: " + indexOf);
            notifyItemChanged(indexOf, 30);
        }
    }

    public final void updateAvatarImageVisible(String filamentId, boolean show) {
        List split$default;
        Unit unit;
        Intrinsics.checkNotNullParameter(filamentId, "filamentId");
        split$default = StringsKt__StringsKt.split$default((CharSequence) filamentId, new String[]{"_"}, false, 0, 6, (Object) null);
        String str = (String) split$default.get(0);
        String str2 = (String) split$default.get(1);
        int parseInt = Integer.parseInt(str);
        int indexOf = indexOf(str2, parseInt);
        if (indexOf != -1) {
            SquareBaseKt.getSquareLog().i(TAG, "updateAvatarImageVisible: " + indexOf);
            MapItem itemData = getItemData(indexOf);
            if (parseInt == 1 || parseInt == 4 || parseInt == 10) {
                if (itemData instanceof SquareAvatarItem) {
                    ((SquareAvatarItem) itemData).getExtra().setChangeAvatarImageVisible(Boolean.valueOf(show));
                    unit = Unit.INSTANCE;
                } else {
                    if (itemData instanceof ChatLandAvatarItem) {
                        Object extra = ((ChatLandAvatarItem) itemData).getExtra();
                        ChatLandAvatarExtra chatLandAvatarExtra = (ChatLandAvatarExtra) (extra instanceof ChatLandAvatarExtra ? extra : null);
                        if (chatLandAvatarExtra != null) {
                            chatLandAvatarExtra.setChangeAvatarImageVisible(Boolean.valueOf(show));
                        }
                        unit = Unit.INSTANCE;
                    } else if (itemData instanceof SquareTroopItem) {
                        ((SquareTroopItem) itemData).getExtra().setChangeAvatarImageVisible(Boolean.valueOf(show));
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                }
                if (unit != null) {
                    notifyItemChanged(indexOf, 29);
                }
            }
        }
    }

    public final void updateAvatarLocationView(AvatarLocationInfo locationInfo) {
        Intrinsics.checkNotNullParameter(locationInfo, "locationInfo");
        MapItem itemData = getItemData(getMeIndex());
        if (!(itemData instanceof SquareAvatarItem)) {
            itemData = null;
        }
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) itemData;
        if (squareAvatarItem != null) {
            squareAvatarItem.setLocationInfo(locationInfo);
        }
        notifyItemChanged(getMeIndex(), 20);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        r4 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateAvatarStatus(int index, StatusUpdateData data) {
        Resource lookFront;
        SitDownInfo sitDown;
        List<AvatarAction> emptyList;
        Object firstOrNull;
        Resource lookFront2;
        Intrinsics.checkNotNullParameter(data, "data");
        MapItem itemData = getItemData(index);
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) (!(itemData instanceof SquareAvatarItem) ? null : itemData);
        if (squareAvatarItem != null) {
            AvatarAction action = data.getAction();
            if (action == null || emptyList == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            squareAvatarItem.setActions(emptyList);
            squareAvatarItem.setStandActions(squareAvatarItem.getActions());
            squareAvatarItem.getExtra().setOnlineStatus(data.getStatus());
            AvatarAction action2 = data.getAction();
            if (action2 != null && (lookFront2 = action2.getLookFront()) != null) {
                squareAvatarItem.setLocation(MapItemKt.relocation(squareAvatarItem.getLocation(), lookFront2.getShowSize()));
            }
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateAvatarStatus: resource=");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) squareAvatarItem.getActions());
            AvatarAction avatarAction = (AvatarAction) firstOrNull;
            sb5.append(avatarAction != null ? avatarAction.getLookFront() : null);
            squareLog.i(TAG, sb5.toString());
            notifyItemChanged(index, 2);
            CacheFileUtils.INSTANCE.doUpdateWhenExit();
        }
        if (!(itemData instanceof ChatLandAvatarItem)) {
            itemData = null;
        }
        ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) itemData;
        if (chatLandAvatarItem != null) {
            SitDownInfo sitDown2 = chatLandAvatarItem.getUser().getSitDown();
            if (sitDown2 != null) {
                sitDown2.setOnlineStatus(data.getStatus());
            }
            AvatarAction action3 = data.getAction();
            if (action3 != null && (lookFront = action3.getLookFront()) != null && (sitDown = chatLandAvatarItem.getUser().getSitDown()) != null) {
                sitDown.setResource(lookFront);
            }
            notifyItemChanged(index, 2);
        }
    }

    public final void updateAvatarSticker(final String uin, Stickers newStickers) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(newStickers, "newStickers");
        int indexOf = indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareBaseAdapter$updateAvatarSticker$index$1
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
                return (it instanceof SquareAvatarItem) && Intrinsics.areEqual(it.getUin(), uin);
            }
        });
        if (indexOf < 0) {
            SquareBaseKt.getSquareLog().w(TAG, "updateFeedsBubble find " + uin + " index error");
            return;
        }
        MapItem itemData = getItemData(indexOf);
        if (itemData == null || !(itemData instanceof SquareAvatarItem)) {
            return;
        }
        ((SquareAvatarItem) itemData).updateSticker(newStickers);
        notifyItemChanged(indexOf, 25);
    }

    public final void updateBlindBoxEntrance(SquareBlindBoxEntranceInfo blindBoxEntranceInfo) {
        SquareAvatarExtra extra;
        Intrinsics.checkNotNullParameter(blindBoxEntranceInfo, "blindBoxEntranceInfo");
        MapItem itemData = getItemData(getMeIndex());
        if (!(itemData instanceof SquareAvatarItem)) {
            itemData = null;
        }
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) itemData;
        if (squareAvatarItem != null && (extra = squareAvatarItem.getExtra()) != null) {
            extra.setBlindBoxEntranceInfo(blindBoxEntranceInfo);
        }
        notifyItemChanged(getMeIndex(), 23);
    }

    public final void updateBubbleSkin(final String uin, SquareBubbleInfo bubbleInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        int indexOf = indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareBaseAdapter$updateBubbleSkin$index$1
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
                return (it instanceof SquareAvatarItem) && Intrinsics.areEqual(it.getUin(), uin);
            }
        });
        if (indexOf < 0) {
            SquareBaseKt.getSquareLog().w(TAG, "updateBubbleSkin find " + uin + " index error");
            return;
        }
        MapItem itemData = getItemData(indexOf);
        if (itemData == null || !(itemData instanceof SquareAvatarItem)) {
            return;
        }
        ((SquareAvatarItem) itemData).getExtra().setBubbleInfo(bubbleInfo);
        notifyItemChanged(indexOf, 26);
    }

    public final void updateBuildingBubble(Map<Integer, List<BuildingBubble>> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Iterator<T> it = result.keySet().iterator();
        while (it.hasNext()) {
            final int intValue = ((Number) it.next()).intValue();
            int indexOf = indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareBaseAdapter$updateBuildingBubble$1$index$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem) {
                    return Boolean.valueOf(invoke2(mapItem));
                }

                /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
                
                    r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2.getUin());
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final boolean invoke2(MapItem it5) {
                    Integer intOrNull;
                    Intrinsics.checkNotNullParameter(it5, "it");
                    return (it5 instanceof SquareEntranceItem) && intOrNull != null && intOrNull.intValue() == intValue;
                }
            });
            MapItem itemData = getItemData(indexOf);
            if (!(itemData instanceof SquareEntranceItem)) {
                itemData = null;
            }
            SquareEntranceItem squareEntranceItem = (SquareEntranceItem) itemData;
            if (squareEntranceItem != null) {
                squareEntranceItem.setBubbles(result.get(Integer.valueOf(intValue)));
            }
            notifyItemChanged(indexOf, 17);
        }
    }

    public final void updateBuildingStyle(final SquareEntranceItem data, SquareStyleInfo styleInfo) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(styleInfo, "styleInfo");
        int indexOf = indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareBaseAdapter$updateBuildingStyle$index$1
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
                if (it instanceof SquareEntranceItem) {
                    SquareEntranceItem squareEntranceItem = (SquareEntranceItem) it;
                    if (squareEntranceItem.getEntranceType() == 10 && squareEntranceItem.getEntranceId() == SquareEntranceItem.this.getEntranceId()) {
                        return true;
                    }
                }
                return false;
            }
        });
        if (indexOf < 0) {
            SquareBaseKt.getSquareLog().w(TAG, "updateBuildingStyle find index error");
            return;
        }
        MapItem itemData = getItemData(indexOf);
        if (itemData instanceof SquareEntranceItem) {
            SquareEntranceItem squareEntranceItem = (SquareEntranceItem) itemData;
            squareEntranceItem.setShowUrl(styleInfo.getPicUrl());
            squareEntranceItem.setStyleId(styleInfo.getStyleId());
        }
        notifyItemChanged(indexOf, 18);
    }

    public final void updateCustomText(String customTextMd5) {
        Application application;
        Intrinsics.checkNotNullParameter(customTextMd5, "customTextMd5");
        Square square = Square.INSTANCE;
        final String currentAccountUin = square.getConfig().getCommonUtils().getCurrentAccountUin();
        int indexOf = indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareBaseAdapter$updateCustomText$index$1
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
                return (it instanceof SquareAvatarItem) && Intrinsics.areEqual(it.getUin(), currentAccountUin);
            }
        });
        if (indexOf < 0) {
            SquareBaseKt.getSquareLog().w(TAG, "[beatText] updateCustomText, find " + currentAccountUin + " index error");
            return;
        }
        MapItem itemData = getItemData(indexOf);
        if (itemData instanceof SquareAvatarItem) {
            StringFormatUtils stringFormatUtils = StringFormatUtils.INSTANCE;
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) itemData;
            OnlineStatus onlineStatus = squareAvatarItem.getExtra().getOnlineStatus();
            String formatString = stringFormatUtils.formatString(onlineStatus != null ? onlineStatus.getCustomText() : null);
            if (formatString == null || formatString.length() == 0) {
                SquareBaseKt.getSquareLog().w(TAG, "[beatText] updateCustomText, formatCustomText, nullOrEmpty");
                return;
            }
            String c16 = d.c(formatString);
            SquareBaseKt.getSquareLog().w(TAG, "[beatText] updateCustomText, text:" + formatString + ", md5:" + c16 + ", targetMd5:" + customTextMd5);
            if (Intrinsics.areEqual(customTextMd5, c16)) {
                if (squareAvatarItem.isMe() && (application = square.getApplication()) != null) {
                    square.getConfig().getCommonUtils().showToast(application, com.tencent.mobileqq.R.string.xed, 1);
                }
                OnlineStatus onlineStatus2 = squareAvatarItem.getExtra().getOnlineStatus();
                if (onlineStatus2 != null) {
                    onlineStatus2.setCustomText("");
                }
                notifyItemChanged(indexOf, 12);
                return;
            }
            return;
        }
        SquareBaseKt.getSquareLog().w(TAG, "[beatText] updateCustomText, find data error");
    }

    public final void updateExtraBuildingBubble(Map<Integer, BuildingBubble> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Iterator<T> it = result.keySet().iterator();
        while (it.hasNext()) {
            final int intValue = ((Number) it.next()).intValue();
            int indexOf = indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareBaseAdapter$updateExtraBuildingBubble$1$index$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem) {
                    return Boolean.valueOf(invoke2(mapItem));
                }

                /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
                
                    r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2.getUin());
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final boolean invoke2(MapItem it5) {
                    Integer intOrNull;
                    Intrinsics.checkNotNullParameter(it5, "it");
                    return (it5 instanceof SquareEntranceItem) && intOrNull != null && intOrNull.intValue() == intValue;
                }
            });
            MapItem itemData = getItemData(indexOf);
            if (!(itemData instanceof SquareEntranceItem)) {
                itemData = null;
            }
            SquareEntranceItem squareEntranceItem = (SquareEntranceItem) itemData;
            if (squareEntranceItem != null) {
                squareEntranceItem.setExtraBubble(result.get(Integer.valueOf(intValue)));
            }
            notifyItemChanged(indexOf, 17);
        }
    }

    public void updateFeedsBubble(final String uin, QZoneFeedsInfo feedsInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(feedsInfo, "feedsInfo");
        int indexOf = indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareBaseAdapter$updateFeedsBubble$index$1
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
                return (it instanceof SquareAvatarItem) && Intrinsics.areEqual(it.getUin(), uin);
            }
        });
        if (indexOf < 0) {
            SquareBaseKt.getSquareLog().w(TAG, "updateFeedsBubble find " + uin + " index error");
            return;
        }
        MapItem itemData = getItemData(indexOf);
        if (itemData instanceof SquareAvatarItem) {
            ((SquareAvatarItem) itemData).setFeedInfo(feedsInfo);
        }
        notifyItemChanged(indexOf, 16);
    }

    public void updateFootLabel(final CommonFootLabel label) {
        Intrinsics.checkNotNullParameter(label, "label");
        int indexOf = indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareBaseAdapter$updateFootLabel$index$1
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
                return (it instanceof SquareAvatarItem) && Intrinsics.areEqual(it.getUin(), CommonFootLabel.this.getUin());
            }
        });
        SquareBaseKt.getSquareLog().i(TAG, "updateFootLabel " + label);
        if (indexOf < 0) {
            SquareBaseKt.getSquareLog().w(TAG, "updateFootLabel find " + label.getUin() + " index error");
            return;
        }
        MapItem itemData = getItemData(indexOf);
        if (itemData instanceof SquareAvatarItem) {
            ((SquareAvatarItem) itemData).getExtra().setFootLabel(label);
        }
        notifyItemChanged(indexOf, 15);
    }

    public final void updateMeLikeNum(LikeListInfo data) {
        SquareAvatarExtra extra;
        MapItem itemData = getItemData(getMeIndex());
        if (!(itemData instanceof SquareAvatarItem)) {
            itemData = null;
        }
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) itemData;
        if (squareAvatarItem != null && (extra = squareAvatarItem.getExtra()) != null) {
            extra.setLikeUnReadInfo(data);
        }
        notifyItemChanged(getMeIndex(), 14);
    }

    public final void updateMusicPlayState(final String songMid) {
        Intrinsics.checkNotNullParameter(songMid, "songMid");
        notifyItemChanged(indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareBaseAdapter$updateMusicPlayState$index$1
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
                SquareAvatarExtra extra;
                OnlineStatus onlineStatus;
                SpecialStatus extraData;
                SongInfo songInfo;
                Intrinsics.checkNotNullParameter(it, "it");
                String str = null;
                if (!(it instanceof SquareAvatarItem)) {
                    it = null;
                }
                SquareAvatarItem squareAvatarItem = (SquareAvatarItem) it;
                if (squareAvatarItem != null && (extra = squareAvatarItem.getExtra()) != null && (onlineStatus = extra.getOnlineStatus()) != null && (extraData = onlineStatus.getExtraData()) != null && (songInfo = extraData.getSongInfo()) != null) {
                    str = songInfo.getSongId();
                }
                return Intrinsics.areEqual(str, songMid);
            }
        }), 11);
    }

    public final void updatePttPlayState(final String uin, PlayState state) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(state, "state");
        int indexOf = indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareBaseAdapter$updatePttPlayState$index$1
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
                return (it instanceof SquareAvatarItem) && Intrinsics.areEqual(it.getUin(), uin);
            }
        });
        if (indexOf < 0) {
            SquareBaseKt.getSquareLog().w(TAG, "updatePttPlayState find " + uin + " index error");
            return;
        }
        MapItem itemData = getItemData(indexOf);
        if (itemData instanceof SquareAvatarItem) {
            ((SquareAvatarItem) itemData).getExtra().setPlayingPtt(state);
        }
        notifyItemChanged(indexOf, 7);
    }

    public final void updateSpeakBubble(final BubbleMessage bubble) {
        Intrinsics.checkNotNullParameter(bubble, "bubble");
        int indexOf = indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareBaseAdapter$updateSpeakBubble$index$1
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
                return (it instanceof ChatLandAvatarItem) && Intrinsics.areEqual(it.getUin(), String.valueOf(BubbleMessage.this.getUin()));
            }
        });
        MapItem itemData = getItemData(indexOf);
        if (!(itemData instanceof ChatLandAvatarItem)) {
            itemData = null;
        }
        ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) itemData;
        if (chatLandAvatarItem != null) {
            Object extra = chatLandAvatarItem.getExtra();
            ChatLandAvatarExtra chatLandAvatarExtra = (ChatLandAvatarExtra) (extra instanceof ChatLandAvatarExtra ? extra : null);
            if (chatLandAvatarExtra != null) {
                chatLandAvatarExtra.setSpeakBubble(bubble);
            }
            notifyItemChanged(indexOf, 28);
            SquareBaseKt.getSquareLog().i(TAG, "updateSpeakBubble: " + indexOf + " __ " + bubble.getUin());
        }
    }

    public final void updateTroopMessageHide(final String uin, boolean isBaned) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        int indexOf = indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareBaseAdapter$updateTroopMessageHide$index$1
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
                return (it instanceof SquareTroopItem) && Intrinsics.areEqual(it.getUin(), uin);
            }
        });
        if (indexOf < 0) {
            SquareBaseKt.getSquareLog().w(TAG, "updateTroopMessageHide find " + uin + " index error");
            return;
        }
        MapItem itemData = getItemData(indexOf);
        if (itemData instanceof SquareTroopItem) {
            ((SquareTroopItem) itemData).setBaned(isBaned);
        }
        notifyItemChanged(indexOf, 5);
    }

    public void updateTroopUnreadMessage(final SquareTroopMessageRecord message) {
        Intrinsics.checkNotNullParameter(message, "message");
        int indexOf = indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareBaseAdapter$updateTroopUnreadMessage$index$1
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
                return (it instanceof SquareTroopItem) && Intrinsics.areEqual(it.getUin(), SquareTroopMessageRecord.this.getUin());
            }
        });
        if (indexOf < 0) {
            SquareBaseKt.getSquareLog().w(TAG, "updateTroopUnreadMessage find " + message.getUin() + " index error");
            return;
        }
        MapItem itemData = getItemData(indexOf);
        if (itemData instanceof SquareTroopItem) {
            SquareTroopItem squareTroopItem = (SquareTroopItem) itemData;
            squareTroopItem.setLastMsg(message);
            squareTroopItem.getExtra().setDisturb(message.getForbiddenNotify());
        }
        notifyItemChanged(indexOf, 4);
    }

    public void updateUnreadMessage(final SquareBaseMessageRecord message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Square square = Square.INSTANCE;
        if (square.getConfig().isDebug()) {
            SquareBaseKt.getSquareLog().d(TAG, "updateAvatarUnreadBubble, " + message.getUin() + ", " + message.getUnreadCount());
        }
        int indexOf = indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareBaseAdapter$updateUnreadMessage$index$1
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
                return (it instanceof SquareAvatarItem) && Intrinsics.areEqual(it.getUin(), SquareBaseMessageRecord.this.getUin());
            }
        });
        if (indexOf < 0) {
            if (square.getConfig().isDebug()) {
                SquareBaseKt.getSquareLog().w(TAG, "updateAvatarUnreadBubble find " + message.getUin() + " index error");
                return;
            }
            return;
        }
        MapItem itemData = getItemData(indexOf);
        if (itemData instanceof SquareAvatarItem) {
            ((SquareAvatarItem) itemData).getExtra().setLastUnReadMsg(message);
        } else if (square.getConfig().isDebug()) {
            SquareBaseKt.getSquareLog().d(TAG, "updateAvatarUnreadBubble isn't SquareAvatarItem, " + indexOf + ", " + message.getUin() + ", " + message.getUnreadCount());
        }
        notifyItemChanged(indexOf, 3);
    }

    public final void updateUserSongInfo(final String uin, SongInfo songInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        int indexOf = indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.SquareBaseAdapter$updateUserSongInfo$index$1
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
                return (it instanceof SquareAvatarItem) && Intrinsics.areEqual(it.getUin(), uin);
            }
        });
        if (indexOf < 0) {
            SquareBaseKt.getSquareLog().w(TAG, "updateUserSongInfo find " + uin + " index error");
            return;
        }
        SquareBaseKt.getSquareLog().d(TAG, "updateUserSongInfo " + uin + " songInfo:" + songInfo);
        MapItem itemData = getItemData(indexOf);
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) (!(itemData instanceof SquareAvatarItem) ? null : itemData);
        if (squareAvatarItem == null || !SquareAvatarItemKt.isMusicStatus(squareAvatarItem)) {
            return;
        }
        OnlineStatus onlineStatus = ((SquareAvatarItem) itemData).getExtra().getOnlineStatus();
        if (onlineStatus != null) {
            onlineStatus.setExtraData(new SpecialStatus(null, null, null, null, songInfo, 15, null));
        }
        notifyItemChanged(indexOf, 12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MapViewHolder<?> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater from = LayoutInflater.from(this.context);
        switch (viewType) {
            case 4:
                VasSquareItemTroopBinding inflate = VasSquareItemTroopBinding.inflate(from);
                Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareItemTroopBinding.inflate(inflater)");
                return new TroopViewHolder(inflate);
            case 5:
                return new EmptyViewHolder(this.context);
            case 6:
                VasSquareItemEntranceBinding inflate2 = VasSquareItemEntranceBinding.inflate(from);
                Intrinsics.checkNotNullExpressionValue(inflate2, "VasSquareItemEntranceBinding.inflate(inflater)");
                return new SquareCommonEntranceViewHolder(inflate2);
            case 7:
                VasSquareItemMayKnowBinding inflate3 = VasSquareItemMayKnowBinding.inflate(from);
                Intrinsics.checkNotNullExpressionValue(inflate3, "VasSquareItemMayKnowBind\u2026nflater\n                )");
                return new MayKnowViewHolder(inflate3);
            case 8:
                VasSquareItemRecommendUserBinding inflate4 = VasSquareItemRecommendUserBinding.inflate(from);
                Intrinsics.checkNotNullExpressionValue(inflate4, "VasSquareItemRecommendUs\u2026Binding.inflate(inflater)");
                return new RecommendUserViewHolder(inflate4);
            case 9:
                VasSquareItemChatLandTableBinding inflate5 = VasSquareItemChatLandTableBinding.inflate(LayoutInflater.from(parent.getContext()));
                Intrinsics.checkNotNullExpressionValue(inflate5, "VasSquareItemChatLandTab\u2026ter.from(parent.context))");
                return new ChatLandTableViewHolder(inflate5);
            case 10:
                VasSquareItemChatLandAvatarBinding inflate6 = VasSquareItemChatLandAvatarBinding.inflate(LayoutInflater.from(parent.getContext()));
                Intrinsics.checkNotNullExpressionValue(inflate6, "VasSquareItemChatLandAva\u2026ter.from(parent.context))");
                if (!(parent instanceof SquareView)) {
                    parent = null;
                }
                SquareView squareView = (SquareView) parent;
                return new ChatLandAvatarViewHolder(inflate6, new WeakReference(squareView != null ? squareView.getContainer() : null));
            default:
                VasSquareItemAvatarBinding inflate7 = VasSquareItemAvatarBinding.inflate(from);
                Intrinsics.checkNotNullExpressionValue(inflate7, "VasSquareItemAvatarBinding.inflate(inflater)");
                return new AvatarViewHolder(inflate7);
        }
    }

    public static /* synthetic */ PlaceInfo doAvatarSetTop$default(SquareBaseAdapter squareBaseAdapter, MoveItem moveItem, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                i3 = 0;
            }
            return squareBaseAdapter.doAvatarSetTop(moveItem, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doAvatarSetTop");
    }
}
