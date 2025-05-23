package com.qzone.reborn.intimate.part;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.widget.QZIntimateSpaceNormalMenuItemView;
import com.qzone.reborn.intimate.widget.QZIntimateSpaceSingleMenuItemView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;
import qzone.QZIntimateSpaceReader$MenuItem;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0016\u0010\u0011\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/qzone/reborn/intimate/part/QZIntimateSpaceMenuViewPart;", "Lcom/qzone/reborn/base/k;", "", "initViewModel", "", "Lqzone/QZIntimateSpaceReader$MenuItem;", "menuList", "Lij/e;", "K9", "Lorg/json/JSONObject;", "menuObject", "menuItem", "J9", "jsonObject", "bean", "M9", "entranceList", "H9", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lnk/at;", "d", "Lnk/at;", "mainTabViewModel", "Lnk/i;", "e", "Lnk/i;", "styleViewModel", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "menuItemContainer", tl.h.F, "Landroid/view/View;", "menuContentLayout", "<init>", "()V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateSpaceMenuViewPart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private nk.at mainTabViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private nk.i styleViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout menuItemContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View menuContentLayout;

    private final void I9(ij.e bean) {
        LinearLayout linearLayout = this.menuItemContainer;
        if (linearLayout != null) {
            ViewUtils viewUtils = ViewUtils.f352270a;
            linearLayout.setPadding(0, viewUtils.a(13.0f), 0, viewUtils.a(13.0f));
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QZIntimateSpaceSingleMenuItemView qZIntimateSpaceSingleMenuItemView = new QZIntimateSpaceSingleMenuItemView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        View view = this.menuContentLayout;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) view).addView(qZIntimateSpaceSingleMenuItemView, layoutParams);
        qZIntimateSpaceSingleMenuItemView.setData(bean);
    }

    private final ij.e J9(JSONObject menuObject, QZIntimateSpaceReader$MenuItem menuItem) {
        ij.e eVar = new ij.e();
        try {
            eVar.s(menuItem.menu_id.get());
            eVar.y(menuItem.menu_type.get());
            String str = menuItem.link.get();
            Intrinsics.checkNotNullExpressionValue(str, "menuItem.link.get()");
            eVar.t(str);
            String str2 = menuItem.notify.get();
            Intrinsics.checkNotNullExpressionValue(str2, "menuItem.notify.get()");
            eVar.v(str2);
            String str3 = menuItem.icon_url.get();
            Intrinsics.checkNotNullExpressionValue(str3, "menuItem.icon_url.get()");
            eVar.p(str3);
            JSONObject jsonObject = menuObject.getJSONObject(String.valueOf(menuItem.menu_id.get()));
            String string = jsonObject.getString("name");
            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(NAME)");
            eVar.u(string);
            String string2 = jsonObject.getString("icon_day");
            Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(ICON_DAY)");
            eVar.q(string2);
            String string3 = jsonObject.getString("icon_night");
            Intrinsics.checkNotNullExpressionValue(string3, "jsonObject.getString(ICON_NIGHT)");
            eVar.r(string3);
            String string4 = jsonObject.getString("icon_bg_day");
            Intrinsics.checkNotNullExpressionValue(string4, "jsonObject.getString(ICON_BG_DAY)");
            eVar.n(string4);
            String string5 = jsonObject.getString("icon_bg_night");
            Intrinsics.checkNotNullExpressionValue(string5, "jsonObject.getString(ICON_BG_NIGHT)");
            eVar.o(string5);
            Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
            M9(jsonObject, eVar);
            String string6 = jsonObject.getString("stroke_day");
            Intrinsics.checkNotNullExpressionValue(string6, "jsonObject.getString(STROKE_DAY)");
            eVar.w(string6);
            String string7 = jsonObject.getString("stroke_night");
            Intrinsics.checkNotNullExpressionValue(string7, "jsonObject.getString(STROKE_NIGHT)");
            eVar.x(string7);
            return eVar;
        } catch (Exception e16) {
            com.tencent.qqcamerakit.common.e.d("QZIntimateSpaceSuspendEntrancePart", 1, "exception is " + e16);
            LinearLayout linearLayout = this.menuItemContainer;
            if (linearLayout == null) {
                return null;
            }
            linearLayout.setVisibility(8);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ij.e> K9(List<QZIntimateSpaceReader$MenuItem> menuList) {
        ij.e J9;
        ArrayList arrayList = new ArrayList();
        nk.i iVar = this.styleViewModel;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("styleViewModel");
            iVar = null;
        }
        JSONObject menuSetting = iVar.getMenuSetting();
        if (menuSetting == null) {
            com.tencent.qqcamerakit.common.e.d("QZIntimateSpaceSuspendEntrancePart", 1, "menuSetting is still null");
            LinearLayout linearLayout = this.menuItemContainer;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            return arrayList;
        }
        if (ArrayUtils.isOutOfArrayIndex(0, menuList)) {
            com.tencent.qqcamerakit.common.e.d("QZIntimateSpaceSuspendEntrancePart", 1, "menuList is empty");
            LinearLayout linearLayout2 = this.menuItemContainer;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            return arrayList;
        }
        HashSet hashSet = new HashSet();
        int size = menuList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!hashSet.contains(Integer.valueOf(menuList.get(i3).menu_id.get())) && (J9 = J9(menuSetting, menuList.get(i3))) != null) {
                arrayList.add(J9);
                hashSet.add(Integer.valueOf(J9.getId()));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void M9(JSONObject jsonObject, ij.e bean) {
        JSONArray jSONArray = jsonObject.getJSONArray("background_day");
        JSONArray jSONArray2 = jsonObject.getJSONArray("background_night");
        if (jSONArray.length() >= 2 && jSONArray2.length() >= 2) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                List<String> a16 = bean.a();
                String string = jSONArray.getString(i3);
                Intrinsics.checkNotNullExpressionValue(string, "backgroundDayArray.getString(i)");
                a16.add(string);
            }
            int length2 = jSONArray2.length();
            for (int i16 = 0; i16 < length2; i16++) {
                List<String> b16 = bean.b();
                String string2 = jSONArray2.getString(i16);
                Intrinsics.checkNotNullExpressionValue(string2, "backgroundNightArray.getString(i)");
                b16.add(string2);
            }
            return;
        }
        com.tencent.qqcamerakit.common.e.d("QZIntimateSpaceSuspendEntrancePart", 1, "bg array size is less than 2");
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(nk.i.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZIntimateM\u2026yleViewModel::class.java)");
        this.styleViewModel = (nk.i) viewModel;
        ViewModel viewModel2 = getViewModel(nk.at.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneIntima\u2026TabViewModel::class.java)");
        nk.at atVar = (nk.at) viewModel2;
        this.mainTabViewModel = atVar;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            atVar = null;
        }
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1 = atVar.U1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<QZoneIntimateSpaceBean>, Unit> function1 = new Function1<UIStateData<QZoneIntimateSpaceBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimateSpaceMenuViewPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:29:0x0068, code lost:
            
                if (android.text.TextUtils.isEmpty(r1.getStyleResourcesString()) != false) goto L31;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                nk.i iVar;
                nk.i iVar2;
                List K9;
                LinearLayout linearLayout;
                nk.i iVar3;
                nk.i iVar4 = null;
                if ((uIStateData != null ? uIStateData.getData() : null) == null) {
                    return;
                }
                if (com.qzone.reborn.util.k.f59549a.g() && uIStateData.getData().isLoveSpace()) {
                    return;
                }
                if ((uIStateData.getState() == 2 || uIStateData.getState() == 3) && uIStateData.getData().isFromRefreshSpace()) {
                    iVar = QZIntimateSpaceMenuViewPart.this.styleViewModel;
                    if (iVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("styleViewModel");
                        iVar = null;
                    }
                    if (iVar.getMenuSetting() != null) {
                        iVar3 = QZIntimateSpaceMenuViewPart.this.styleViewModel;
                        if (iVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("styleViewModel");
                            iVar3 = null;
                        }
                    }
                    iVar2 = QZIntimateSpaceMenuViewPart.this.styleViewModel;
                    if (iVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("styleViewModel");
                    } else {
                        iVar4 = iVar2;
                    }
                    iVar4.S1(uIStateData.getData().getSpaceType());
                    K9 = QZIntimateSpaceMenuViewPart.this.K9(uIStateData.getData().getMenuList());
                    if (!ArrayUtils.isOutOfArrayIndex(0, K9)) {
                        QZIntimateSpaceMenuViewPart.this.H9(K9);
                        return;
                    }
                    com.tencent.qqcamerakit.common.e.d("QZIntimateSpaceSuspendEntrancePart", 1, "menu item bean list is empty");
                    linearLayout = QZIntimateSpaceMenuViewPart.this.menuItemContainer;
                    if (linearLayout == null) {
                        return;
                    }
                    linearLayout.setVisibility(8);
                }
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.aw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZIntimateSpaceMenuViewPart.L9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.ng7);
        this.menuItemContainer = linearLayout;
        this.menuContentLayout = linearLayout != null ? linearLayout.findViewById(R.id.ng5) : null;
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(List<ij.e> entranceList) {
        int coerceAtMost;
        if (ArrayUtils.isOutOfArrayIndex(0, entranceList)) {
            LinearLayout linearLayout = this.menuItemContainer;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = this.menuItemContainer;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        if (entranceList.size() == 1) {
            I9(entranceList.get(0));
            return;
        }
        LinearLayout linearLayout3 = this.menuItemContainer;
        if (linearLayout3 != null) {
            ViewUtils viewUtils = ViewUtils.f352270a;
            linearLayout3.setPadding(viewUtils.a(13.0f), viewUtils.a(13.0f), viewUtils.a(13.0f), viewUtils.a(13.0f));
        }
        int l3 = pl.a.f426446a.l(getContext());
        ViewUtils viewUtils2 = ViewUtils.f352270a;
        int a16 = ((l3 - viewUtils2.a(2.0f)) - (viewUtils2.a(8.0f) * 3)) / 4;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(entranceList.size(), 4);
        View view = this.menuContentLayout;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
        ((LinearLayout) view).removeAllViews();
        for (int i3 = 0; i3 < coerceAtMost; i3++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a16, -2);
            if (i3 != coerceAtMost - 1) {
                layoutParams.setMarginEnd(ViewUtils.f352270a.a(8.0f));
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            QZIntimateSpaceNormalMenuItemView qZIntimateSpaceNormalMenuItemView = new QZIntimateSpaceNormalMenuItemView(context);
            View view2 = this.menuContentLayout;
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) view2).addView(qZIntimateSpaceNormalMenuItemView);
            qZIntimateSpaceNormalMenuItemView.setLayoutParams(layoutParams);
            qZIntimateSpaceNormalMenuItemView.setData(entranceList.get(i3));
        }
    }
}
