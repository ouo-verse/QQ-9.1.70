package com.tencent.state.square.chatland.viewmodel;

import com.tencent.state.map.MapItem;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.data.ChatLandAvatarItemKt;
import com.tencent.state.square.chatland.data.ChatLandDecoratorItem;
import com.tencent.state.square.chatland.data.ChatLandTableItem;
import com.tencent.state.square.data.EntranceBubble;
import com.tencent.state.square.data.SquareEntranceItem;
import com.tencent.state.template.data.BuildingDecorator;
import com.tencent.state.template.data.CommonRoomInfo;
import com.tencent.state.template.data.Decorator;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import com.tencent.state.template.map.TemplateMapViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/square/chatland/viewmodel/ChatLandMapViewModel;", "Lcom/tencent/state/template/map/TemplateMapViewModel;", "()V", "getMapDataList", "", "Lcom/tencent/state/map/MapItem;", "roomInfo", "Lcom/tencent/state/template/data/CommonRoomInfo;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandMapViewModel extends TemplateMapViewModel {
    private static final String TAG = "ChatLandMapViewModel";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.tencent.state.square.chatland.data.ChatLandAvatarItem] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7, types: [com.tencent.state.square.chatland.data.ChatLandTableItem] */
    @Override // com.tencent.state.template.map.TemplateMapViewModel
    public List<MapItem> getMapDataList(CommonRoomInfo roomInfo) {
        List<MapItem> emptyList;
        int collectionSizeOrDefault;
        int i3;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        int collectionSizeOrDefault4;
        List plus;
        List plus2;
        List<MapItem> plus3;
        Object obj;
        ?? chatLandAvatarItem;
        if (roomInfo == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        int appId = roomInfo.getAppId();
        List<User> sitUsers = roomInfo.getSitUsers();
        List<Table> tables = roomInfo.getTables();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(tables, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = tables.iterator();
        while (true) {
            i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            Table table = (Table) it.next();
            Iterator it5 = sitUsers.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it5.next();
                SitDownInfo sitDown = ((User) obj).getSitDown();
                if (sitDown != null && sitDown.getTableId() == table.getId()) {
                    break;
                }
            }
            User user = (User) obj;
            if (user == null) {
                chatLandAvatarItem = new ChatLandTableItem(table, appId);
            } else {
                chatLandAvatarItem = new ChatLandAvatarItem(user, appId);
                ChatLandAvatarItemKt.setupPKOption(chatLandAvatarItem, roomInfo);
            }
            arrayList.add(chatLandAvatarItem);
        }
        List<User> users = roomInfo.getUsers();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : users) {
            SitDownInfo sitDown2 = ((User) obj2).getSitDown();
            if (sitDown2 != null && sitDown2.getIsFlexTable()) {
                arrayList2.add(obj2);
            }
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
        Iterator it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            ChatLandAvatarItem chatLandAvatarItem2 = new ChatLandAvatarItem((User) it6.next(), appId);
            ChatLandAvatarItemKt.setupPKOption(chatLandAvatarItem2, roomInfo);
            arrayList3.add(chatLandAvatarItem2);
        }
        List<Decorator> roomDecorators = roomInfo.getConfig().getRoomDecorators();
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(roomDecorators, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault3);
        Iterator it7 = roomDecorators.iterator();
        while (it7.hasNext()) {
            arrayList4.add(new ChatLandDecoratorItem((Decorator) it7.next()));
        }
        List<BuildingDecorator> buildings = roomInfo.getConfig().getBuildings();
        collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(buildings, 10);
        ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault4);
        for (Object obj3 : buildings) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            BuildingDecorator buildingDecorator = (BuildingDecorator) obj3;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(appId);
            sb5.append('-');
            sb5.append(i3);
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(appId);
            sb7.append('-');
            sb7.append(i3);
            String sb8 = sb7.toString();
            String url = buildingDecorator.getImage().getUrl();
            String jumpUrl = buildingDecorator.getJumpUrl();
            if (jumpUrl == null) {
                jumpUrl = "";
            }
            arrayList5.add(new SquareEntranceItem(sb6, sb8, url, new EntranceLink(jumpUrl, buildingDecorator.getJumpType()), buildingDecorator.getLocation(), new EntranceBubble("", ""), 0, 0, 0, null, null, null, null, null, 15872, null));
            i3 = i16;
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList4, (Iterable) arrayList5);
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) plus);
        plus3 = CollectionsKt___CollectionsKt.plus((Collection) plus2, (Iterable) arrayList3);
        return plus3;
    }
}
