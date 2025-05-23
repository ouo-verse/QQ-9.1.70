package com.tencent.sqshow.zootopia.nativeui.view.title;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.sqshow.zootopia.nativeui.data.title.PortalStorePanelCategoryData;
import com.tencent.sqshow.zootopia.nativeui.data.title.PortalStorePanelTypeData;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import uv4.ao;
import uv4.bj;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001:\u0001KB'\b\u0007\u0012\u0006\u0010E\u001a\u00020D\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010F\u0012\b\b\u0002\u0010H\u001a\u00020\u000f\u00a2\u0006\u0004\bI\u0010JJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\u0003H\u0014J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0014J\u001e\u0010\u0011\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J(\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J0\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J \u0010\u001e\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\bH\u0016J\u0016\u0010\"\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0002J\b\u0010#\u001a\u00020\u001aH\u0002J\b\u0010$\u001a\u00020\bH\u0002J\u0010\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H\u0002J\u0010\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020%H\u0002J,\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020+0*j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020+`,2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u00101\u001a\u00020\u000f2\u0006\u00100\u001a\u00020/H\u0002J\u0010\u00102\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J\u0010\u00103\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u00104\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J\u0010\u00105\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0002H\u0002R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00107R\u001c\u0010:\u001a\n 9*\u0004\u0018\u000106068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u00107R\u001c\u0010;\u001a\n 9*\u0004\u0018\u000106068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00107R\u0018\u0010=\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010>R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001a0@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006L"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/title/PortalStorePanelCategoryView;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle;", "Lcom/tencent/sqshow/zootopia/nativeui/view/title/j;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelCategoryData;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$c;", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "", "N", "G", "data", "L", "", "titleList", "", "selectedPos", "setTitleData", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "index", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "holder", BdhLogUtil.LogTag.Tag_Req, "", "selected", "clearLastRedDot", "Y", ExifInterface.LATITUDE_SOUTH, "T", "V", "U", "c0", "P", "Z", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "X", "iconView", "W", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "I", "O", "Luv4/ao;", "categoryCfg", "M", "K", "J", "a0", "b0", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "kotlin.jvm.PlatformType", "arrowDownDrawable", "arrowUpDrawable", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "Lcom/tencent/sqshow/zootopia/nativeui/view/title/j;", "currentViewHolder", "Landroidx/lifecycle/Observer;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroidx/lifecycle/Observer;", "mShowTypeTitleViewObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStorePanelCategoryView extends BaseViewPagerTitle<j, String, PortalStorePanelCategoryData, BaseViewPagerTitle.c> {
    private static final int S = -2;
    private static int T;
    private static final int U;
    private static int V;
    private static final int W;

    /* renamed from: a0, reason: collision with root package name */
    private static final int f372067a0;

    /* renamed from: K, reason: from kotlin metadata */
    private Drawable defaultDrawable;

    /* renamed from: L, reason: from kotlin metadata */
    private final Drawable arrowDownDrawable;

    /* renamed from: M, reason: from kotlin metadata */
    private final Drawable arrowUpDrawable;

    /* renamed from: N, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: P, reason: from kotlin metadata */
    private j currentViewHolder;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Observer<Boolean> mShowTypeTitleViewObserver;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f372068a;

        static {
            int[] iArr = new int[DropdownStatus.values().length];
            try {
                iArr[DropdownStatus.FOLD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DropdownStatus.UNFOLD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f372068a = iArr;
        }
    }

    static {
        int roundToInt;
        int roundToInt2;
        int dpToPx = ViewUtils.dpToPx(25.0f);
        T = dpToPx;
        U = -2;
        roundToInt = MathKt__MathJVMKt.roundToInt(dpToPx * 0.8f);
        V = roundToInt;
        int dpToPx2 = ViewUtils.dpToPx(30.0f);
        W = dpToPx2;
        roundToInt2 = MathKt__MathJVMKt.roundToInt(dpToPx2 * 0.8f);
        f372067a0 = roundToInt2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStorePanelCategoryView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final HashMap<String, Object> I(PortalStorePanelCategoryData data) {
        Object orNull;
        bj storeTypeCfg;
        HashMap<String, Object> hashMap = new HashMap<>();
        String str = data.getCategoryCfg().f440183a;
        Intrinsics.checkNotNullExpressionValue(str, "data.categoryCfg.id");
        hashMap.put("zplan_tab_id", str);
        String str2 = data.getCategoryCfg().f440185c;
        Intrinsics.checkNotNullExpressionValue(str2, "data.categoryCfg.name");
        hashMap.put("zplan_tab_name", str2);
        hashMap.put("zplan_tab_type", "category");
        int i3 = 0;
        orNull = CollectionsKt___CollectionsKt.getOrNull(data.getTypeList(), 0);
        PortalStorePanelTypeData portalStorePanelTypeData = (PortalStorePanelTypeData) orNull;
        if (portalStorePanelTypeData != null && (storeTypeCfg = portalStorePanelTypeData.getStoreTypeCfg()) != null && storeTypeCfg.f440362n == 1) {
            i3 = 1;
        }
        hashMap.put("zplan_is_bigcard_show", Integer.valueOf(i3));
        return hashMap;
    }

    private final boolean J(PortalStorePanelCategoryData data) {
        bj[] bjVarArr = data.getCategoryCfg().f440189g;
        Intrinsics.checkNotNullExpressionValue(bjVarArr, "data.categoryCfg.types");
        return ((bjVarArr.length == 0) ^ true) && !data.getCategoryCfg().f440192j;
    }

    private final void K(j holder) {
        MutableLiveData<Boolean> G;
        MutableLiveData<Boolean> G2;
        int i3 = b.f372068a[holder.getDropdownStatus().ordinal()];
        if (i3 == 1) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
            if (jVar != null && (G = jVar.G()) != null) {
                G.postValue(Boolean.TRUE);
            }
            b0(holder);
            return;
        }
        if (i3 != 2) {
            return;
        }
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
        if (jVar2 != null && (G2 = jVar2.G()) != null) {
            G2.postValue(Boolean.FALSE);
        }
        a0(holder);
    }

    private final int M(ao categoryCfg) {
        return categoryCfg.f440197o;
    }

    private final boolean O(PortalStorePanelCategoryData data) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(data.getItemId(), "brand:", false, 2, null);
        return startsWith$default;
    }

    private final boolean P() {
        Configuration configuration;
        Resources resources = getContext().getResources();
        return (resources == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(PortalStorePanelCategoryView this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.currentViewHolder == null || bool.booleanValue()) {
            return;
        }
        j jVar = this$0.currentViewHolder;
        Intrinsics.checkNotNull(jVar);
        this$0.a0(jVar);
    }

    private final void W(View iconView) {
        ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (P()) {
            int i3 = f372067a0;
            layoutParams.width = i3;
            layoutParams.height = i3;
        } else {
            int i16 = W;
            layoutParams.width = i16;
            layoutParams.height = i16;
        }
        iconView.setLayoutParams(layoutParams);
    }

    private final void X(View rootView) {
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (P()) {
            layoutParams.width = U;
            layoutParams.height = V;
        } else {
            layoutParams.width = S;
            layoutParams.height = T;
        }
        rootView.setLayoutParams(layoutParams);
    }

    private final void Z() {
        int childCount = getMTitleContainer().getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getMTitleContainer().getChildAt(i3);
            View findViewById = childAt != null ? childAt.findViewById(R.id.qrb) : null;
            if (childAt != null) {
                X(childAt);
            }
            if (findViewById != null) {
                W(findViewById);
            }
        }
    }

    private final void a0(j holder) {
        holder.getDropdownIcon().setImageDrawable(this.arrowDownDrawable);
        holder.l(DropdownStatus.FOLD);
    }

    private final void b0(j holder) {
        holder.getDropdownIcon().setImageDrawable(this.arrowUpDrawable);
        holder.l(DropdownStatus.UNFOLD);
    }

    private final void c0(List<PortalStorePanelCategoryData> titleList) {
        for (PortalStorePanelCategoryData portalStorePanelCategoryData : titleList) {
            String icon = portalStorePanelCategoryData.getCategoryCfg().f440186d;
            if (icon != null) {
                Intrinsics.checkNotNullExpressionValue(icon, "icon");
                CommonExKt.o(icon, null, null, 3, null);
            }
            String activeIcon = portalStorePanelCategoryData.getCategoryCfg().f440187e;
            if (activeIcon != null) {
                Intrinsics.checkNotNullExpressionValue(activeIcon, "activeIcon");
                CommonExKt.o(activeIcon, null, null, 3, null);
            }
        }
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    protected String G() {
        return "PortalStorePanelCategoryView_";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public j l(PortalStorePanelCategoryData data) {
        LifecycleOwner lifecycleOwner;
        Intrinsics.checkNotNullParameter(data, "data");
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.de9, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        j jVar = new j(itemView);
        jVar.getTitleIconIgv().setImageDrawable(this.defaultDrawable);
        jVar.getDropdownIcon().setVisibility(0);
        a0(jVar);
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
        if (jVar2 != null && (lifecycleOwner = jVar2.getLifecycleOwner()) != null) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar3 = this.mChannel;
            Intrinsics.checkNotNull(jVar3);
            jVar3.G().observe(lifecycleOwner, this.mShowTypeTitleViewObserver);
        }
        return jVar;
    }

    public final void N(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.mChannel = channel;
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void u(int index, PortalStorePanelCategoryData data, LinearLayout container, j holder) {
        int roundToInt;
        int b16;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(holder, "holder");
        int b17 = com.tencent.sqshow.zootopia.utils.i.b(25);
        holder.b(data.getCategoryCfg().f440191i);
        boolean z16 = M(data.getCategoryCfg()) == 0;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, b17);
        if (index == 0) {
            if (z16) {
                b16 = com.tencent.sqshow.zootopia.utils.i.b(12);
            } else {
                b16 = com.tencent.sqshow.zootopia.utils.i.b(16);
            }
            layoutParams.leftMargin = b16;
        }
        if (index == p().size() - 1) {
            layoutParams.rightMargin = com.tencent.sqshow.zootopia.utils.i.b(4);
        }
        layoutParams.gravity = 16;
        container.addView(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), layoutParams);
        int b18 = com.tencent.sqshow.zootopia.utils.i.b(z16 ? 35 : 33);
        T = b18;
        roundToInt = MathKt__MathJVMKt.roundToInt(b18 * 0.8f);
        V = roundToInt;
        URLImageView titleIconIgv = holder.getTitleIconIgv();
        Intrinsics.checkNotNullExpressionValue(titleIconIgv, "holder.titleIconIgv");
        W(titleIconIgv);
        X(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String());
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null) {
            return;
        }
        jVar.getReporter().getMReporter().g(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), "em_zplan_tab_btn", (r16 & 4) != 0 ? null : I(data), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        VideoReport.setElementEndExposePolicy(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), EndExposurePolicy.REPORT_ALL);
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public void v(j holder, int index, PortalStorePanelCategoryData data) {
        MutableLiveData<Boolean> G;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        j jVar = this.currentViewHolder;
        if (jVar != null) {
            jVar.c();
        }
        holder.d(data.getCategoryCfg().f440191i);
        this.currentViewHolder = holder;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
        if (jVar2 == null) {
            return;
        }
        jVar2.getReporter().getMReporter().e(holder.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), "em_zplan_tab_btn", I(data));
        bj[] bjVarArr = data.getCategoryCfg().f440189g;
        Intrinsics.checkNotNullExpressionValue(bjVarArr, "data.categoryCfg.types");
        if (!(bjVarArr.length == 0)) {
            if (data.getCategoryCfg().f440192j) {
                com.tencent.sqshow.zootopia.nativeui.data.j jVar3 = this.mChannel;
                if (jVar3 != null && (G = jVar3.G()) != null) {
                    G.postValue(Boolean.FALSE);
                }
                holder.getDropdownIcon().setVisibility(4);
                return;
            }
            K(holder);
        }
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public void w(j holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.w(holder);
        QLog.d(G(), 1, "onItemViewSelected, holder: " + holder);
        j jVar = this.currentViewHolder;
        if (jVar != null) {
            jVar.c();
        }
        holder.c();
    }

    public void U() {
        MutableLiveData<Boolean> G;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null || (G = jVar.G()) == null) {
            return;
        }
        G.removeObserver(this.mShowTypeTitleViewObserver);
    }

    public void V() {
        String G = G();
        j jVar = this.currentViewHolder;
        QLog.d(G, 1, "clear current title holder red dot, when view hide, id: " + (jVar != null ? Integer.valueOf(jVar.getRedDotId()) : null));
        j jVar2 = this.currentViewHolder;
        if (jVar2 != null) {
            Intrinsics.checkNotNull(jVar2);
            jVar2.c();
            j jVar3 = this.currentViewHolder;
            Intrinsics.checkNotNull(jVar3);
            a0(jVar3);
            this.currentViewHolder = null;
        }
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public void C(j holder, boolean selected, int index, PortalStorePanelCategoryData data, boolean clearLastRedDot) {
        MutableLiveData<Boolean> G;
        MutableLiveData<Boolean> G2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        ViewGroup.LayoutParams layoutParams = holder.getDropdownIcon().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        ViewGroup.LayoutParams layoutParams3 = holder.getRedDot().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        int M = M(data.getCategoryCfg());
        if (M == 0) {
            holder.getTitleIconIgv().setVisibility(0);
            holder.getTitleImage().setVisibility(8);
            holder.getTitleTxv().setVisibility(8);
            if (selected) {
                this.currentViewHolder = holder;
                holder.getTitleIconIgv().setURLDrawableDownListener(null);
                URLImageView titleIconIgv = holder.getTitleIconIgv();
                Intrinsics.checkNotNullExpressionValue(titleIconIgv, "holder.titleIconIgv");
                String str = data.getCategoryCfg().f440187e;
                Intrinsics.checkNotNullExpressionValue(str, "data.categoryCfg.activeIcon");
                CommonExKt.w(titleIconIgv, str, this.defaultDrawable, null, 4, null);
            } else if (O(data)) {
                URLImageView titleIconIgv2 = holder.getTitleIconIgv();
                Intrinsics.checkNotNullExpressionValue(titleIconIgv2, "holder.titleIconIgv");
                String str2 = data.getCategoryCfg().f440186d;
                Intrinsics.checkNotNullExpressionValue(str2, "data.categoryCfg.icon");
                CommonExKt.w(titleIconIgv2, str2, this.defaultDrawable, null, 4, null);
            } else {
                URLImageView titleIconIgv3 = holder.getTitleIconIgv();
                Intrinsics.checkNotNullExpressionValue(titleIconIgv3, "holder.titleIconIgv");
                Context context = holder.getTitleIconIgv().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "holder.titleIconIgv.context");
                String str3 = data.getCategoryCfg().f440186d;
                Intrinsics.checkNotNullExpressionValue(str3, "data.categoryCfg.icon");
                CommonExKt.y(titleIconIgv3, context, str3, R.color.qui_common_icon_primary, this.defaultDrawable);
            }
            layoutParams2.addRule(1, R.id.qrb);
            layoutParams2.leftMargin = com.tencent.sqshow.zootopia.utils.i.b(2);
            holder.getDropdownIcon().setLayoutParams(layoutParams2);
            layoutParams4.addRule(6, R.id.qrb);
            layoutParams4.addRule(1, R.id.qrb);
            layoutParams4.leftMargin = com.tencent.sqshow.zootopia.utils.i.b(-4);
            layoutParams4.topMargin = com.tencent.sqshow.zootopia.utils.i.b(2);
            holder.getRedDot().setLayoutParams(layoutParams4);
        } else if (M == 1) {
            holder.getTitleImage().setVisibility(0);
            holder.getTitleIconIgv().setVisibility(8);
            holder.getTitleTxv().setVisibility(8);
            holder.getTitleImage().setDefaultDrawable(this.defaultDrawable);
            holder.getTitleImage().setAdjustViewBounds(true);
            holder.getTitleImage().setScaleType(ImageView.ScaleType.FIT_CENTER);
            ZPlanMediaView titleImage = holder.getTitleImage();
            pu4.g gVar = data.getCategoryCfg().f440196n;
            Intrinsics.checkNotNullExpressionValue(gVar, "data.categoryCfg.tabPic");
            titleImage.e(gVar);
            holder.getTitleImage().setAlpha(selected ? 1.0f : 0.3f);
            if (data.getCategoryCfg().f440196n.f427439f > 0 && data.getCategoryCfg().f440196n.f427440g > 0) {
                ViewGroup.LayoutParams layoutParams5 = holder.getTitleImage().getLayoutParams();
                Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
                layoutParams6.width = (int) ((com.tencent.sqshow.zootopia.utils.i.b(14) / data.getCategoryCfg().f440196n.f427440g) * data.getCategoryCfg().f440196n.f427439f);
                layoutParams6.height = com.tencent.sqshow.zootopia.utils.i.b(14);
                holder.getTitleImage().setLayoutParams(layoutParams6);
            }
            layoutParams2.addRule(1, R.id.qrc);
            layoutParams4.addRule(6, R.id.qrc);
            layoutParams4.addRule(1, R.id.qrc);
        } else if (M == 2) {
            holder.getTitleTxv().setVisibility(0);
            holder.getTitleImage().setVisibility(8);
            holder.getTitleIconIgv().setVisibility(8);
            holder.getTitleTxv().setText(data.getCategoryCfg().f440185c);
            if (selected) {
                holder.getTitleTxv().setTextColor(getResources().getColor(R.color.qui_common_brand_standard));
                holder.getTitleTxv().setBackgroundResource(R.drawable.f159919i54);
            } else {
                holder.getTitleTxv().setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
                holder.getTitleTxv().setBackgroundResource(R.drawable.f159920i55);
            }
            layoutParams2.addRule(1, R.id.qrj);
            layoutParams4.addRule(6, R.id.qrj);
            layoutParams4.addRule(1, R.id.qrj);
        }
        holder.getDropdownIcon().setLayoutParams(layoutParams2);
        holder.getRedDot().setLayoutParams(layoutParams4);
        if (!J(data)) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
            if (jVar != null && (G2 = jVar.G()) != null) {
                G2.postValue(Boolean.FALSE);
            }
            holder.getDropdownIcon().setVisibility(4);
            return;
        }
        if (!selected) {
            holder.getDropdownIcon().setVisibility(4);
            return;
        }
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
        if (jVar2 != null && (G = jVar2.G()) != null) {
            G.postValue(Boolean.FALSE);
        }
        holder.getDropdownIcon().setVisibility(0);
    }

    @Override // com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle, vc4.i
    public void setTitleData(List<PortalStorePanelCategoryData> titleList, int selectedPos) {
        Intrinsics.checkNotNullParameter(titleList, "titleList");
        c0(titleList);
        super.setTitleData(titleList, selectedPos);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStorePanelCategoryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PortalStorePanelCategoryView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        QLog.i("PortalStorePanelCategoryView_", 1, "onConfigurationChanged, orientation=" + (newConfig != null ? Integer.valueOf(newConfig.orientation) : null) + ", " + this);
        Z();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStorePanelCategoryView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable b16 = q.b(R.drawable.h4b);
        Intrinsics.checkNotNullExpressionValue(b16, "getDrawable(R.drawable.z\u2026r_panel_icon_default_8dp)");
        this.defaultDrawable = b16;
        this.arrowDownDrawable = ie0.a.f().o(context, R.drawable.im7, R.color.qui_common_icon_secondary, 1000);
        this.arrowUpDrawable = ie0.a.f().o(context, R.drawable.im8, R.color.qui_common_icon_secondary, 1000);
        this.mShowTypeTitleViewObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.title.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStorePanelCategoryView.Q(PortalStorePanelCategoryView.this, (Boolean) obj);
            }
        };
    }
}
