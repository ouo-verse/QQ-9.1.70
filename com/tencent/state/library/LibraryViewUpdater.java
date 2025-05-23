package com.tencent.state.library;

import com.tencent.state.library.data.LibraryAvatarItem;
import com.tencent.state.library.data.LibraryTableItem;
import com.tencent.state.map.IMapPlayManager;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import com.tencent.state.template.item.TemplateAvatarItem;
import com.tencent.state.template.item.TemplateTableItem;
import com.tencent.state.template.map.TemplateMapViewUpdater;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/library/LibraryViewUpdater;", "Lcom/tencent/state/template/map/TemplateMapViewUpdater;", "adapter", "Lcom/tencent/state/map/MapAdapter;", "rpm", "Lcom/tencent/state/map/IMapPlayManager;", "(Lcom/tencent/state/map/MapAdapter;Lcom/tencent/state/map/IMapPlayManager;)V", "createAvatarItem", "Lcom/tencent/state/template/item/TemplateAvatarItem;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "createTableItem", "Lcom/tencent/state/template/item/TemplateTableItem;", "table", "Lcom/tencent/state/template/data/Table;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryViewUpdater extends TemplateMapViewUpdater {
    public LibraryViewUpdater(MapAdapter mapAdapter, IMapPlayManager iMapPlayManager) {
        super(mapAdapter, iMapPlayManager);
    }

    @Override // com.tencent.state.template.map.TemplateMapViewUpdater
    public TemplateAvatarItem createAvatarItem(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        return new LibraryAvatarItem(user);
    }

    @Override // com.tencent.state.template.map.TemplateMapViewUpdater
    public TemplateTableItem createTableItem(Table table) {
        Intrinsics.checkNotNullParameter(table, "table");
        return new LibraryTableItem(table);
    }
}
