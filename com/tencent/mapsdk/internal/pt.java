package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import com.tencent.map.lib.models.AccessibleTouchItem;
import com.tencent.map.lib.models.MapExploreByTouchHelper;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class pt extends MapExploreByTouchHelper implements fs {

    /* renamed from: a, reason: collision with root package name */
    public List<AccessibleTouchItem> f149660a;

    /* renamed from: b, reason: collision with root package name */
    public List<AccessibleTouchItem> f149661b;

    /* renamed from: c, reason: collision with root package name */
    public tr f149662c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f149663d;

    public pt(View view, tr trVar) {
        super(view);
        this.f149660a = new ArrayList();
        this.f149661b = new ArrayList();
        this.f149663d = new Handler();
        this.f149662c = trVar;
        ((VectorMap) trVar.e_).a(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        if (r2.getBounds().contains((int) r6, (int) r7) != false) goto L16;
     */
    @Override // com.tencent.map.lib.models.MapExploreByTouchHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getTargetPoiItemIdx(float f16, float f17) {
        int i3;
        List<AccessibleTouchItem> list = this.accessibleTouchItems;
        if (list != null && list.size() > 0) {
            List<AccessibleTouchItem> list2 = this.accessibleTouchItems;
            if (list2 != null && list2.size() > 0) {
                i3 = this.accessibleTouchItems.size() - 1;
                AccessibleTouchItem accessibleTouchItem = this.accessibleTouchItems.get(i3);
                if (accessibleTouchItem instanceof pu) {
                }
            }
            i3 = -1;
            if (i3 != -1) {
                return i3;
            }
            for (int i16 = 0; i16 < this.accessibleTouchItems.size(); i16++) {
                if (this.accessibleTouchItems.get(i16).getBounds().contains((int) f16, (int) f17)) {
                    return i16;
                }
            }
        }
        return -1;
    }

    @Override // com.tencent.map.lib.models.MapExploreByTouchHelper
    public final boolean onItemClicked(int i3) {
        AccessibleTouchItem accessibleTouchItem;
        if (i3 >= this.accessibleTouchItems.size() || (accessibleTouchItem = this.accessibleTouchItems.get(i3)) == null) {
            return false;
        }
        invalidateVirtualView(i3);
        sendEventForVirtualView(i3, 1);
        accessibleTouchItem.onClick();
        return true;
    }

    @Override // com.tencent.map.lib.models.MapExploreByTouchHelper
    public final void onTalkBackActivate(View view) {
        super.onTalkBackActivate(view);
        ((VectorMap) this.f149662c.e_).a(this);
        u();
    }

    @Override // com.tencent.map.lib.models.MapExploreByTouchHelper
    public final void onTalkBackDeActivate(View view) {
        super.onTalkBackDeActivate(view);
        ((VectorMap) this.f149662c.e_).b(this);
    }

    @Override // com.tencent.mapsdk.internal.fs
    public final void u() {
        this.f149663d.post(new Runnable() { // from class: com.tencent.mapsdk.internal.pt.1
            @Override // java.lang.Runnable
            public final void run() {
                ArrayList<MapPoi> N;
                pt.this.accessibleTouchItems.clear();
                pt.this.f149660a.clear();
                pt.this.f149661b.clear();
                if (pt.this.f149662c != null) {
                    List<ap> ah5 = pt.this.f149662c.ah();
                    tr trVar = pt.this.f149662c;
                    trVar.f151038ar.clear();
                    ne neVar = ((VectorMap) trVar.e_).f151351o;
                    ap apVar = null;
                    if (neVar == null) {
                        N = null;
                    } else {
                        N = neVar.N();
                    }
                    trVar.f151038ar = N;
                    if (ah5 != null) {
                        for (ap apVar2 : ah5) {
                            String contentDescription = apVar2.getContentDescription();
                            if (!hs.a(contentDescription)) {
                                if (contentDescription.startsWith(AccessibleTouchItem.MY_LOCATION_PREFIX)) {
                                    apVar = apVar2;
                                } else {
                                    pt.this.f149660a.add(new pu(pt.this.f149662c, apVar2));
                                }
                            }
                        }
                        Collections.sort(pt.this.f149660a);
                        pt.this.accessibleTouchItems.addAll(pt.this.f149660a);
                    }
                    if (N != null) {
                        for (MapPoi mapPoi : N) {
                            if (!hs.a(mapPoi.getName())) {
                                pt.this.f149661b.add(new pv(pt.this.f149662c, mapPoi));
                            }
                        }
                        Collections.sort(pt.this.f149661b);
                        pt.this.accessibleTouchItems.addAll(pt.this.f149661b);
                    }
                    if (apVar != null) {
                        pt.this.accessibleTouchItems.add(new pu(pt.this.f149662c, apVar));
                    }
                }
            }
        });
    }

    private int a(float f16, float f17) {
        List<AccessibleTouchItem> list = this.accessibleTouchItems;
        if (list == null || list.size() <= 0) {
            return -1;
        }
        int size = this.accessibleTouchItems.size() - 1;
        AccessibleTouchItem accessibleTouchItem = this.accessibleTouchItems.get(size);
        if ((accessibleTouchItem instanceof pu) && accessibleTouchItem.getBounds().contains((int) f16, (int) f17)) {
            return size;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
    
        if ((r7 instanceof com.tencent.mapsdk.internal.pu) != false) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(pp ppVar) {
        boolean z16;
        AccessibleTouchItem accessibleTouchItem;
        if (ppVar == null) {
            return;
        }
        String contentDescription = ppVar.getContentDescription();
        if (hs.a(contentDescription)) {
            return;
        }
        if (ppVar.F != null) {
            Rect j3 = ppVar.j();
            int ai5 = ppVar.F.ai();
            int aj5 = ppVar.F.aj();
            if (j3.left >= 0 && j3.top >= 0 && j3.right <= ai5 && j3.bottom <= aj5) {
                z16 = true;
                if (z16) {
                    return;
                }
                pu puVar = new pu(this.f149662c, ppVar);
                if (this.accessibleTouchItems.size() > 0) {
                    List<AccessibleTouchItem> list = this.accessibleTouchItems;
                    accessibleTouchItem = list.get(list.size() - 1);
                    if (accessibleTouchItem != null) {
                    }
                }
                accessibleTouchItem = null;
                if (contentDescription.startsWith(AccessibleTouchItem.MY_LOCATION_PREFIX)) {
                    this.accessibleTouchItems.add(puVar);
                    return;
                }
                this.accessibleTouchItems.clear();
                this.f149660a.add(puVar);
                Collections.sort(this.f149660a);
                this.accessibleTouchItems.addAll(this.f149660a);
                this.accessibleTouchItems.addAll(this.f149661b);
                if (accessibleTouchItem != null) {
                    this.accessibleTouchItems.add(accessibleTouchItem);
                    return;
                }
                return;
            }
        }
        z16 = false;
        if (z16) {
        }
    }

    private void a() {
        ((VectorMap) this.f149662c.e_).b(this);
        this.accessibleTouchItems.clear();
        this.f149660a.clear();
        this.f149661b.clear();
    }
}
