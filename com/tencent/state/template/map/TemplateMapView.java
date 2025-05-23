package com.tencent.state.template.map;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Size;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.state.map.AvatarLocationConfig;
import com.tencent.state.map.BaseMapView;
import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.map.IMapLocator;
import com.tencent.state.map.IMapPlayManager;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemController;
import com.tencent.state.map.MapViewDataObserver;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import com.tencent.state.template.item.TemplateAvatarItem;
import com.tencent.state.template.item.TemplateTableItem;
import com.tencent.state.template.map.TemplateMapAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u0000 %*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001%B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\u0004\u0018\u00010\t2\u000e\u0010\f\u001a\n\u0012\u0002\b\u00030\rj\u0002`\u000eH\u0002\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0002\b\u00030\rj\u0002`\u000eH\u0014J(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0018\u0010$\u001a\u00020\u00142\u000e\u0010\u0012\u001a\n\u0012\u0002\b\u00030\rj\u0002`\u000eH\u0014\u00a8\u0006&"}, d2 = {"Lcom/tencent/state/template/map/TemplateMapView;", "T", "Lcom/tencent/state/template/map/TemplateMapAdapter;", "Lcom/tencent/state/map/BaseMapView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getNeighborIndex", "holder", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "(Lcom/tencent/state/map/MapViewHolder;)Ljava/lang/Integer;", "getScreenCenterOffset", "Landroid/graphics/Point;", "viewHolder", "onInitMapAdapter", "", "locator", "Lcom/tencent/state/map/IMapLocator;", "rmp", "Lcom/tencent/state/map/IMapPlayManager;", "observer", "Lcom/tencent/state/map/IMapItemViewManager;", "manipulator", "Lcom/tencent/state/map/IMapViewManipulator;", "scaleToDetail", "", "uin", "", "scaleToMeDetail", "extra", "", "startViewAlpha", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateMapView<T extends TemplateMapAdapter> extends BaseMapView<T> {
    private static final String TAG = "TemplateMapView";

    public TemplateMapView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final Integer getNeighborIndex(MapViewHolder<?> holder) {
        Table table;
        Integer valueOf;
        User user;
        SitDownInfo sitDown;
        Object data = holder.getData();
        TemplateAvatarItem templateAvatarItem = (TemplateAvatarItem) (!(data instanceof TemplateAvatarItem) ? null : data);
        if (templateAvatarItem == null || (user = templateAvatarItem.getUser()) == null || (sitDown = user.getSitDown()) == null || (table = sitDown.getTable()) == null) {
            TemplateTableItem templateTableItem = (TemplateTableItem) (!(data instanceof TemplateTableItem) ? null : data);
            table = templateTableItem != null ? templateTableItem.getTable() : null;
        }
        final Table neighbor = table != null ? table.getNeighbor() : null;
        if (neighbor == null) {
            SquareBaseKt.getSquareLog().i(TAG, "getNeighborIndex: neighbor is null, data=" + data + ", table=" + table);
            return null;
        }
        final User user2 = neighbor.getUser();
        if (user2 == null) {
            MapViewDataObserver observer = getObserver();
            if (observer != null) {
                valueOf = Integer.valueOf(observer.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.template.map.TemplateMapView$getNeighborIndex$result$1
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
                        return (it instanceof TemplateTableItem) && ((TemplateTableItem) it).getTable().getId() == Table.this.getId();
                    }
                }));
            }
            valueOf = null;
        } else {
            MapViewDataObserver observer2 = getObserver();
            if (observer2 != null) {
                valueOf = Integer.valueOf(observer2.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.template.map.TemplateMapView$getNeighborIndex$result$2
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
                        return (it instanceof TemplateAvatarItem) && Intrinsics.areEqual(((TemplateAvatarItem) it).getUser().getUin(), User.this.getUin());
                    }
                }));
            }
            valueOf = null;
        }
        if (valueOf == null || valueOf.intValue() < 0) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getNeighborIndex failed: result=");
            sb5.append(valueOf);
            sb5.append(", deskMate=");
            sb5.append(user2 != null ? user2.getInfo() : null);
            sb5.append(", neighbor=");
            sb5.append(neighbor);
            SquareLogger.DefaultImpls.e$default(squareLog, TAG, sb5.toString(), null, 4, null);
        }
        return valueOf;
    }

    @Override // com.tencent.state.map.BaseMapView
    protected Point getScreenCenterOffset(MapViewHolder<?> viewHolder) {
        Table table;
        int x16;
        int y16;
        Location location;
        Location location2;
        User user;
        SitDownInfo sitDown;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Object data = viewHolder.getData();
        if (!(data instanceof TemplateAvatarItem)) {
            data = null;
        }
        TemplateAvatarItem templateAvatarItem = (TemplateAvatarItem) data;
        if (templateAvatarItem == null || (user = templateAvatarItem.getUser()) == null || (sitDown = user.getSitDown()) == null || (table = sitDown.getTable()) == null) {
            Object data2 = viewHolder.getData();
            if (!(data2 instanceof TemplateTableItem)) {
                data2 = null;
            }
            TemplateTableItem templateTableItem = (TemplateTableItem) data2;
            table = templateTableItem != null ? templateTableItem.getTable() : null;
        }
        AvatarLocationConfig avatarConfig = getConfig().getAvatarConfig();
        if ((table != null ? table.getNeighbor() : null) == null) {
            return new Point(0, ((getHeight() - avatarConfig.getAvatarHeight()) / 2) - avatarConfig.getSingleBottomMargin());
        }
        float avatarWidth = avatarConfig.getAvatarWidth() / table.getLocation().getWidth();
        int x17 = table.getLocation().getX();
        Table neighbor = table.getNeighbor();
        if (neighbor != null && (location2 = neighbor.getLocation()) != null) {
            x16 = location2.getX();
        } else {
            x16 = table.getLocation().getX();
        }
        int abs = (int) (Math.abs(x17 - x16) * avatarWidth);
        int y17 = table.getLocation().getY();
        Table neighbor2 = table.getNeighbor();
        if (neighbor2 != null && (location = neighbor2.getLocation()) != null) {
            y16 = location.getY();
        } else {
            y16 = table.getLocation().getY();
        }
        Size size = new Size(abs, (int) (Math.abs(y17 - y16) * avatarWidth));
        int height = ((getHeight() - avatarConfig.getAvatarHeight()) / 2) - avatarConfig.getGroupBottomMargin();
        int width = size.getWidth() / 2;
        if (table.isLeft()) {
            return new Point(-width, height - size.getHeight());
        }
        return new Point(width, height);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.map.BaseMapView
    protected void onInitMapAdapter(IMapLocator locator, IMapPlayManager rmp, IMapItemViewManager observer, IMapViewManipulator manipulator) {
        Intrinsics.checkNotNullParameter(locator, "locator");
        Intrinsics.checkNotNullParameter(rmp, "rmp");
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(manipulator, "manipulator");
        TemplateMapAdapter templateMapAdapter = (TemplateMapAdapter) getAdapter();
        if (templateMapAdapter != null) {
            templateMapAdapter.initialize(new MapItemController(rmp, locator, manipulator, observer, getListener(), null, null, 96, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.map.BaseMapView
    public boolean scaleToDetail(String uin) {
        TemplateMapAdapter templateMapAdapter = (TemplateMapAdapter) getAdapter();
        if (templateMapAdapter == null) {
            return false;
        }
        if (uin == null) {
            uin = "";
        }
        final int indexOf = templateMapAdapter.indexOf(uin, 1);
        MapViewHolder<?> viewHolder = getViewHolder(indexOf);
        if (viewHolder != null) {
            viewHolder.doScaleToDetail(1, "");
        } else {
            getManipulator().locateTo(indexOf, new Function1<Boolean, Unit>() { // from class: com.tencent.state.template.map.TemplateMapView$$special$$inlined$run$lambda$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    MapViewHolder<?> viewHolder2;
                    if (!z16 || (viewHolder2 = TemplateMapView.this.getViewHolder(indexOf)) == null) {
                        return;
                    }
                    viewHolder2.doScaleToDetail(1, "");
                }
            });
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.state.map.BaseMapView
    public boolean scaleToMeDetail(final Object extra) {
        TemplateMapAdapter templateMapAdapter = (TemplateMapAdapter) getAdapter();
        if (templateMapAdapter == null) {
            return false;
        }
        final int meIndex = templateMapAdapter.getMeIndex();
        SquareBaseKt.getSquareLog().i(TAG, "scaleToMeDetail");
        MapViewHolder<?> viewHolder = getViewHolder(meIndex);
        if (viewHolder != null) {
            if (!(viewHolder.getViewType() == 1)) {
                viewHolder = null;
            }
            if (viewHolder != null) {
                if (extra == null) {
                    extra = "";
                }
                viewHolder.doScaleToDetail(1, extra);
                return true;
            }
        }
        IMapViewManipulator.DefaultImpls.locateToMe$default(getManipulator(), 0, new Function1<Boolean, Unit>() { // from class: com.tencent.state.template.map.TemplateMapView$scaleToMeDetail$$inlined$let$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                MapViewHolder<?> viewHolder2;
                if (!z16 || (viewHolder2 = TemplateMapView.this.getViewHolder(meIndex)) == null) {
                    return;
                }
                if (!(viewHolder2.getViewType() == 1)) {
                    viewHolder2 = null;
                }
                if (viewHolder2 != null) {
                    Object obj = extra;
                    if (obj == null) {
                        obj = "";
                    }
                    viewHolder2.doScaleToDetail(1, obj);
                }
            }
        }, 1, null);
        return true;
    }

    @Override // com.tencent.state.map.BaseMapView
    protected void startViewAlpha(MapViewHolder<?> viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(viewHolder.getIndex()));
        Integer neighborIndex = getNeighborIndex(viewHolder);
        if (neighborIndex != null) {
            arrayList.add(Integer.valueOf(neighborIndex.intValue()));
        }
        SquareBaseKt.getSquareLog().i(TAG, "startViewAlpha: filterList=" + arrayList);
        getAnimateState().startOtherViewAlpha(arrayList);
    }

    public TemplateMapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ TemplateMapView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateMapView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
