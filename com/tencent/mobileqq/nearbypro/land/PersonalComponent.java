package com.tencent.mobileqq.nearbypro.land;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.nearbypro.map.marker.personal.AreaUserView;
import com.tencent.mobileqq.nearbypro.utils.ToStringExKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u001c\u0010\u001c\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R$\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00130$j\b\u0012\u0004\u0012\u00020\u0013`%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/land/PersonalComponent;", "Lcom/tencent/mobileqq/nearbypro/land/i;", "Lcq4/b;", "data", "", "L9", "newData", "M9", "", "Lcq4/d;", "J9", "Landroid/graphics/Point;", "posPoint", "Landroid/view/ViewGroup$MarginLayoutParams;", "H9", "", "tableId", "G9", ITVKPlayerEventListener.KEY_USER_INFO, "Landroid/view/View;", "I9", "Lcom/tencent/mobileqq/nearbypro/land/LandMode;", "mode", "N9", "", "action", "", "args", "handleBroadcastMessage", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "update", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", tl.h.F, "Ljava/util/ArrayList;", "userViewList", "i", "Lcq4/b;", "roomData", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class PersonalComponent extends i {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup container;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<View> userViewList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private cq4.b roomData;

    public PersonalComponent() {
        super(R.id.eb_);
        this.userViewList = new ArrayList<>();
        this.roomData = new cq4.b();
    }

    private final Point G9(long tableId) {
        cq4.c cVar;
        Object firstOrNull;
        boolean z16;
        cq4.c[] cVarArr = this.roomData.f391671d;
        Intrinsics.checkNotNullExpressionValue(cVarArr, "roomData.tableList");
        int length = cVarArr.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                cVar = cVarArr[i3];
                if (cVar.f391674a == tableId) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
                i3++;
            } else {
                cVar = null;
                break;
            }
        }
        qp4.c[] cVarArr2 = x9().getAreaInfo().f429199c;
        Intrinsics.checkNotNullExpressionValue(cVarArr2, "areaParam.areaInfo.background");
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(cVarArr2);
        qp4.c cVar2 = (qp4.c) firstOrNull;
        if (cVar != null && cVar2 != null) {
            com.tencent.mobileqq.nearbypro.utils.a aVar = com.tencent.mobileqq.nearbypro.utils.a.f253947a;
            cq4.a aVar2 = cVar.f391675b;
            Intrinsics.checkNotNullExpressionValue(aVar2, "tableInfo.loc");
            Point a16 = aVar.a(cVar2, aVar2);
            if (a16.x >= 0 && a16.y >= 0) {
                return a16;
            }
            com.tencent.mobileqq.nearbypro.base.j.c().d("PersonalComponent", "calculateCoordinateByTableId error");
            return null;
        }
        com.tencent.mobileqq.nearbypro.base.j.c().d("PersonalComponent", "calculateCoordinateByTableId tableInfo==null or bigModelAreaBg==null");
        return null;
    }

    private final ViewGroup.MarginLayoutParams H9(Point posPoint) {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int c16 = com.tencent.mobileqq.nearbypro.utils.d.c(14, context);
        marginLayoutParams.leftMargin = posPoint.x - c16;
        marginLayoutParams.topMargin = posPoint.y - c16;
        return marginLayoutParams;
    }

    private final View I9(cq4.d userInfo) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        AreaUserView areaUserView = new AreaUserView(context);
        areaUserView.setAvatar(userInfo.f391677a.f391680b);
        return areaUserView;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[LOOP:1: B:4:0x001a->B:31:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<cq4.d> J9(cq4.b newData) {
        Object obj;
        cq4.d dVar;
        Long l3;
        Long l16;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        cq4.d[] dVarArr = newData.f391670c;
        Intrinsics.checkNotNullExpressionValue(dVarArr, "newData.userInfo");
        for (cq4.d dVar2 : dVarArr) {
            Iterator<T> it = this.userViewList.iterator();
            while (true) {
                obj = null;
                cq4.e eVar = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Object tag = ((View) next).getTag();
                if (tag instanceof cq4.d) {
                    dVar = (cq4.d) tag;
                } else {
                    dVar = null;
                }
                if (dVar != null) {
                    l3 = Long.valueOf(dVar.f391678b);
                } else {
                    l3 = null;
                }
                if (dVar2 != null) {
                    l16 = Long.valueOf(dVar2.f391678b);
                } else {
                    l16 = null;
                }
                if (Intrinsics.areEqual(l3, l16)) {
                    cq4.e eVar2 = dVar2.f391677a;
                    if (dVar != null) {
                        eVar = dVar.f391677a;
                    }
                    if (ToStringExKt.a(eVar2, eVar)) {
                        z16 = true;
                        if (!z16) {
                            obj = next;
                            break;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            if (((View) obj) == null) {
                arrayList.add(dVar2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(cq4.b data) {
        boolean z16;
        M9(data);
        for (cq4.d dVar : J9(data)) {
            cq4.e eVar = dVar.f391677a;
            if (eVar != null) {
                String str = eVar.f391680b;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    Point G9 = G9(dVar.f391678b);
                    if (G9 == null) {
                        com.tencent.mobileqq.nearbypro.base.j.c().d("PersonalComponent", "avatarPos invalid");
                    } else {
                        View I9 = I9(dVar);
                        ViewGroup.MarginLayoutParams H9 = H9(G9);
                        ViewGroup viewGroup = this.container;
                        if (viewGroup != null) {
                            viewGroup.addView(I9, H9);
                        }
                        this.userViewList.add(I9);
                        I9.setTag(dVar);
                    }
                }
            }
            com.tencent.mobileqq.nearbypro.base.j.c().d("PersonalComponent", "userInfo.profile invalid");
        }
    }

    private final void M9(cq4.b newData) {
        cq4.d dVar;
        cq4.d dVar2;
        boolean z16;
        Iterator<View> it = this.userViewList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "userViewList.iterator()");
        while (it.hasNext()) {
            View userView = it.next();
            Object tag = userView.getTag();
            String str = null;
            if (tag instanceof cq4.d) {
                dVar = (cq4.d) tag;
            } else {
                dVar = null;
            }
            cq4.d[] dVarArr = newData.f391670c;
            Intrinsics.checkNotNullExpressionValue(dVarArr, "newData.userInfo");
            int length = dVarArr.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    dVar2 = dVarArr[i3];
                    boolean z17 = true;
                    if (dVar != null && dVar2.f391678b == dVar.f391678b) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16 || !ToStringExKt.a(dVar2.f391677a, dVar.f391677a)) {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    dVar2 = null;
                    break;
                }
            }
            if (dVar2 == null) {
                ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
                if (c16.isColorLevel()) {
                    if (dVar != null) {
                        str = ToStringExKt.d(dVar);
                    }
                    c16.e("PersonalComponent", "removeOldData=" + str);
                }
                Intrinsics.checkNotNullExpressionValue(userView, "userView");
                ab.c(userView);
                it.remove();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.view.View] */
    public void N9(@NotNull LandMode mode) {
        boolean z16;
        Intrinsics.checkNotNullParameter(mode, "mode");
        ViewGroup viewGroup = this.container;
        if (viewGroup != null) {
            if (mode == LandMode.SMALL) {
                z16 = true;
            } else {
                z16 = false;
            }
            Boolean valueOf = Boolean.valueOf(z16);
            viewGroup.setVisibility(4);
            ?? r46 = (View) au.a(valueOf, viewGroup);
            if (r46 == 0) {
                viewGroup.setVisibility(0);
            } else {
                viewGroup = r46;
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "MSG_ON_CAMERA_ZOOM_UPDATE") && (args instanceof CameraPosition)) {
            if (((CameraPosition) args).zoom > ab2.a.f25767a.p()) {
                N9(LandMode.BIG);
            } else {
                N9(LandMode.SMALL);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        super.onInitView(rootView);
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.eb_);
        } else {
            viewGroup = null;
        }
        this.container = viewGroup;
        LiveData<cq4.b> Q1 = ((za2.c) getViewModel(za2.c.class)).Q1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<cq4.b, Unit> function1 = new Function1<cq4.b, Unit>() { // from class: com.tencent.mobileqq.nearbypro.land.PersonalComponent$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(cq4.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(cq4.b it) {
                PersonalComponent personalComponent = PersonalComponent.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                personalComponent.roomData = it;
                PersonalComponent.this.broadcastMessage("msg_update_user_count_event", Integer.valueOf(it.f391672e));
                PersonalComponent.this.L9(it);
            }
        };
        Q1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.nearbypro.land.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PersonalComponent.K9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.nearbypro.land.i
    public void update() {
        super.update();
        ViewGroup viewGroup = this.container;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        this.userViewList.clear();
    }
}
