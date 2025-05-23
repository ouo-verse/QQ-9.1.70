package com.tencent.state.library;

import com.tencent.state.library.data.LibraryAvatarItem;
import com.tencent.state.library.data.LibraryDecoratorItem;
import com.tencent.state.library.data.LibraryTableItem;
import com.tencent.state.map.MapItem;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/library/LibraryMapViewModel;", "Lcom/tencent/state/template/map/TemplateMapViewModel;", "()V", "getMapDataList", "", "Lcom/tencent/state/map/MapItem;", "roomInfo", "Lcom/tencent/state/template/data/CommonRoomInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryMapViewModel extends TemplateMapViewModel {
    @Override // com.tencent.state.template.map.TemplateMapViewModel
    public List<MapItem> getMapDataList(CommonRoomInfo roomInfo) {
        List<MapItem> emptyList;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List<MapItem> plus;
        Object obj;
        MapItem libraryAvatarItem;
        if (roomInfo == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<User> sitUsers = roomInfo.getSitUsers();
        List<Table> tables = roomInfo.getTables();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(tables, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Table table : tables) {
            Iterator<T> it = sitUsers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                SitDownInfo sitDown = ((User) obj).getSitDown();
                if (sitDown != null && sitDown.getTableId() == table.getId()) {
                    break;
                }
            }
            User user = (User) obj;
            if (user == null) {
                libraryAvatarItem = new LibraryTableItem(table);
            } else {
                libraryAvatarItem = new LibraryAvatarItem(user);
            }
            arrayList.add(libraryAvatarItem);
        }
        List<Decorator> roomDecorators = roomInfo.getConfig().getRoomDecorators();
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(roomDecorators, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = roomDecorators.iterator();
        while (it5.hasNext()) {
            arrayList2.add(new LibraryDecoratorItem((Decorator) it5.next()));
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
        return plus;
    }
}
