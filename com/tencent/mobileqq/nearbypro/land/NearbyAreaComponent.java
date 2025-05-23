package com.tencent.mobileqq.nearbypro.land;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\u001fB'\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0002H\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/nearbypro/land/NearbyAreaComponent;", "Lcom/tencent/mobileqq/nearbypro/land/AbstractAreaComponentHost;", "Leb2/a;", "clickedData", "Landroid/view/MotionEvent;", "clickEvent", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", "y", "Lqp4/a;", "arenInfo", "D", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "Lcom/tencent/mobileqq/nearbypro/land/i;", "u", "v", "Lcom/tencent/mobileqq/nearbypro/part/a;", "host", HippyTKDListViewAdapter.X, "markerItemData", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/nearbypro/land/h;", "areaParam", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/nearbypro/land/h;Lcom/tencent/mobileqq/nearbypro/part/a;)V", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyAreaComponent extends AbstractAreaComponentHost {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyAreaComponent(@NotNull Context context, @NotNull LifecycleOwner lifecycleOwner, @NotNull AreaParam areaParam, @NotNull com.tencent.mobileqq.nearbypro.part.a host) {
        super(context, lifecycleOwner, areaParam, host);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(areaParam, "areaParam");
        Intrinsics.checkNotNullParameter(host, "host");
    }

    private final void A() {
        View findViewById = findViewById(R.id.sv5);
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        hashMap.put("nearby_square_type", NtFaceConstant.SMALL);
        VideoReport.setPageId(this, "pg_nearby_home_map");
        VideoReport.setPageParams(this, new PageParams(hashMap));
        VideoReport.setElementId(findViewById, "em_nearby_square_icon");
        VideoReport.reportEvent("dt_imp", findViewById, hashMap);
    }

    private final void B() {
        za2.c cVar = (za2.c) getViewModel(this, "", za2.c.class);
        cVar.X1();
        cVar.Z1(getAreaParam().getAreaInfo().f429197a, 0L);
    }

    private final void D(qp4.a arenInfo) {
        LandMode e16 = com.tencent.mobileqq.nearbypro.utils.i.e(getHost());
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (c16.isColorLevel()) {
            c16.e("NearbyAreaComponent", "updateParam zoomMode=" + e16);
        }
        getAreaParam().c(arenInfo);
        getAreaParam().d(e16);
        Iterator<T> it = o().iterator();
        while (it.hasNext()) {
            ((i) it.next()).C9(getAreaParam());
        }
    }

    private final void y() {
        for (i iVar : o()) {
            iVar.C9(getAreaParam());
            iVar.update();
        }
    }

    private final void z(eb2.a clickedData, MotionEvent clickEvent) {
        boolean z16;
        Object obj;
        boolean z17;
        boolean z18;
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.sv8);
        for (int childCount = viewGroup.getChildCount() - 1; -1 < childCount; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            Iterator<T> it = o().iterator();
            while (true) {
                z16 = false;
                if (it.hasNext()) {
                    obj = it.next();
                    if (((i) obj).getContainerId() == childAt.getId()) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            i iVar = (i) obj;
            MotionEvent transEvent = MotionEvent.obtain(clickEvent);
            transEvent.offsetLocation(-childAt.getLeft(), -childAt.getTop());
            if (com.tencent.mobileqq.nearbypro.utils.i.b(childAt, clickEvent.getX(), clickEvent.getY())) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (iVar != null) {
                    Intrinsics.checkNotNullExpressionValue(transEvent, "transEvent");
                    if (iVar.A9(clickedData, transEvent)) {
                        z16 = true;
                    }
                }
                if (z16) {
                    ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
                    if (c16.isColorLevel()) {
                        c16.e("NearbyAreaComponent", iVar.getClass().getSimpleName() + " consume click");
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // bb2.d
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void g(@NotNull eb2.a markerItemData) {
        Intrinsics.checkNotNullParameter(markerItemData, "markerItemData");
        boolean g16 = com.tencent.mobileqq.nearbypro.utils.i.g(markerItemData.getAreaInfo(), getAreaParam().getAreaInfo());
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (c16.isColorLevel()) {
            c16.e("NearbyAreaComponent", "update isSameArea=" + g16 + " hashCode=" + hashCode());
        }
        if (!g16) {
            D(markerItemData.getAreaInfo());
            y();
            B();
            A();
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.land.AbstractAreaComponentHost
    @NotNull
    public List<i> u() {
        List<i> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new d(), new b(), new PersonalComponent(), new k(), new AreaMsgBubbleComponent());
        return mutableListOf;
    }

    @Override // com.tencent.mobileqq.nearbypro.land.AbstractAreaComponentHost
    public void v() {
        super.v();
        B();
        A();
    }

    @Override // com.tencent.mobileqq.nearbypro.land.AbstractAreaComponentHost, bb2.d
    /* renamed from: x */
    public void e(@NotNull eb2.a clickedData, @NotNull com.tencent.mobileqq.nearbypro.part.a host, @NotNull MotionEvent clickEvent) {
        Intrinsics.checkNotNullParameter(clickedData, "clickedData");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(clickEvent, "clickEvent");
        super.e(clickedData, host, clickEvent);
        z(clickedData, clickEvent);
    }
}
