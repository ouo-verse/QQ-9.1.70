package com.tencent.sqshow.zootopia.nativeui.view.page;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.nativeui.data.title.PortalStorePanelCategoryData;
import com.tencent.sqshow.zootopia.nativeui.data.title.PortalStorePanelSectionData;
import com.tencent.sqshow.zootopia.nativeui.view.page.a;
import com.tencent.sqshow.zootopia.nativeui.view.title.PortalStorePanelCategoryView;
import com.tencent.sqshow.zootopia.widget.tab.BaseZPlanTabTitleData;
import ha4.a;
import java.util.Iterator;
import java.util.List;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import n74.cc;
import org.json.JSONObject;
import uv4.ao;
import uv4.as;
import uv4.az;
import uv4.bj;
import uv4.bk;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \\2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u00052\u00020\u00062\u00020\u0007:\u0001-B/\b\u0007\u0012\u0006\u0010V\u001a\u00020U\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010W\u0012\b\b\u0002\u0010Y\u001a\u00020\u000b\u0012\u0006\u00106\u001a\u000204\u00a2\u0006\u0004\bZ\u0010[J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\u0016\u0010\u0015\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\u0010\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u000bH\u0016J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u000bH\u0016J\b\u0010$\u001a\u00020\bH\u0016J \u0010(\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u000bH\u0016J\u0010\u0010)\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u000bH\u0016J\u0010\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u000bH\u0016J\b\u0010,\u001a\u00020\bH\u0016J\b\u0010-\u001a\u00020\bH\u0016J\b\u0010.\u001a\u00020\bH\u0016J\b\u0010/\u001a\u00020\bH\u0016J\b\u00100\u001a\u00020\bH\u0016J\u000e\u00102\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0003J\b\u00103\u001a\u00020\bH\u0016R\u0016\u00106\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u00105R\u0016\u00108\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010:R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010CR\u0016\u0010F\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010CR\u0016\u0010I\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR \u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00130M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR(\u0010T\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010R0Q0M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010O\u00a8\u0006]"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/page/PortalStoreSectionPanelPage;", "Landroid/widget/FrameLayout;", "Lcom/tencent/sqshow/zootopia/nativeui/view/page/a;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelSectionData;", "Lha4/a;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lcom/tencent/sqshow/zootopia/nativeui/view/page/b;", "", "p", "y", "", "selectedIndex", "v", HippyTKDListViewAdapter.X, "w", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "", "it", "u", "Luv4/bj;", DomainData.DOMAIN_NAME, "Luv4/as;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "getView", "data", "setData", "o", "getPosition", "position", "setPosition", "itemIndex", "b", "e", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "c", "a", "d", "f", tl.h.F, "typeId", "r", "onDataChanged", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelSectionData;", "mData", "Ln74/cc;", "Ln74/cc;", "mBinding", "Ld94/d;", "Ld94/d;", "mAdapter", "Lha4/b;", "i", "Lha4/b;", "mEntranceController", "I", "mPosition", BdhLogUtil.LogTag.Tag_Conn, "mCurrentSelectedPos", "D", "Ljava/lang/String;", "mCurrentSelectedId", "E", "Z", "mPageIsShowing", "Landroidx/lifecycle/Observer;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/Observer;", "mDressIdChangeObserver", "Lkotlin/Pair;", "Lorg/json/JSONObject;", "G", "mAutoOpenColorPickObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "H", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreSectionPanelPage extends FrameLayout implements a<String, PortalStorePanelSectionData>, ha4.a, ViewPager.OnPageChangeListener, com.tencent.sqshow.zootopia.nativeui.view.page.b {

    /* renamed from: H, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ReadWriteProperty<Object, Boolean> I;

    /* renamed from: C, reason: from kotlin metadata */
    private int mCurrentSelectedPos;

    /* renamed from: D, reason: from kotlin metadata */
    private String mCurrentSelectedId;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mPageIsShowing;

    /* renamed from: F, reason: from kotlin metadata */
    private final Observer<List<String>> mDressIdChangeObserver;

    /* renamed from: G, reason: from kotlin metadata */
    private final Observer<Pair<Integer, JSONObject>> mAutoOpenColorPickObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private PortalStorePanelSectionData mData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final cc mBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final d94.d mAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ha4.b mEntranceController;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mPosition;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR+\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/page/PortalStoreSectionPanelPage$a;", "", "", "<set-?>", "isMyBagDyeingShowed$delegate", "Lkotlin/properties/ReadWriteProperty;", "a", "()Z", "b", "(Z)V", "isMyBagDyeingShowed", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.page.PortalStoreSectionPanelPage$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f371945a = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Companion.class, "isMyBagDyeingShowed", "isMyBagDyeingShowed()Z", 0))};

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return ((Boolean) PortalStoreSectionPanelPage.I.getValue(this, f371945a[0])).booleanValue();
        }

        public final void b(boolean z16) {
            PortalStoreSectionPanelPage.I.setValue(this, f371945a[0], Boolean.valueOf(z16));
        }

        Companion() {
        }
    }

    static {
        QRouteApi api = QRoute.api(IZPlanMMKVApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanMMKVApi::class.java)");
        I = t74.i.b((IZPlanMMKVApi) api, "ZPLAN_PortalStoreSectionPanelPage__isMyBagDyeingShowed_" + ((IZPlanApi) QRoute.api(IZPlanApi.class)).getCurrentUin(), false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStoreSectionPanelPage(final Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j mChannel) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mChannel, "mChannel");
        this.mChannel = mChannel;
        this.mData = new PortalStorePanelSectionData(0, 0, null, null, null, 31, null);
        this.mAdapter = new d94.d(context, this.mChannel, this);
        this.mEntranceController = new ha4.b(this.mChannel, context);
        this.mPosition = -1;
        this.mCurrentSelectedPos = -1;
        this.mCurrentSelectedId = "";
        this.mDressIdChangeObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.page.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStoreSectionPanelPage.t(PortalStoreSectionPanelPage.this, (List) obj);
            }
        };
        this.mAutoOpenColorPickObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.page.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStoreSectionPanelPage.s(PortalStoreSectionPanelPage.this, context, (Pair) obj);
            }
        };
        cc f16 = cc.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        setMotionEventSplittingEnabled(false);
        f16.f418975c.N(this.mChannel);
        f16.f418976d.e(this.mChannel);
    }

    private final void l() {
        this.mChannel.l().removeObserver(this.mDressIdChangeObserver);
        this.mChannel.c().removeObserver(this.mAutoOpenColorPickObserver);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0081 A[EDGE_INSN: B:29:0x0081->B:30:0x0081 BREAK  A[LOOP:0: B:13:0x003b->B:47:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[LOOP:0: B:13:0x003b->B:47:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final as m() {
        List<com.tencent.sqshow.zootopia.nativeui.data.repo.g> emptyList;
        Object obj;
        az azVar;
        String str;
        boolean z16;
        String str2;
        boolean contains;
        az storeItem;
        List<String> value = this.mChannel.l().getValue();
        if (value == null) {
            value = CollectionsKt__CollectionsKt.emptyList();
        }
        PortalStorePanelCategoryPage g16 = this.mAdapter.g();
        if (g16 == null || (emptyList = g16.P()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        if (!emptyList.isEmpty() && !value.isEmpty()) {
            Iterator<T> it = emptyList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                com.tencent.sqshow.zootopia.nativeui.data.repo.g gVar = (com.tencent.sqshow.zootopia.nativeui.data.repo.g) obj;
                bk storeTypeItem = gVar.getStoreTypeItem();
                if (storeTypeItem == null || (storeItem = storeTypeItem.f440366b) == null) {
                    str = null;
                } else {
                    Intrinsics.checkNotNullExpressionValue(storeItem, "storeItem");
                    str = r94.b.a(storeItem);
                }
                if (str != null) {
                    List<String> list = value;
                    az storeItem2 = gVar.getStoreTypeItem().f440366b;
                    if (storeItem2 != null) {
                        Intrinsics.checkNotNullExpressionValue(storeItem2, "storeItem");
                        str2 = r94.b.a(storeItem2);
                    } else {
                        str2 = null;
                    }
                    contains = CollectionsKt___CollectionsKt.contains(list, str2);
                    if (contains) {
                        z16 = true;
                        if (!z16) {
                            break;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            com.tencent.sqshow.zootopia.nativeui.data.repo.g gVar2 = (com.tencent.sqshow.zootopia.nativeui.data.repo.g) obj;
            if (gVar2 != null) {
                bk storeTypeItem2 = gVar2.getStoreTypeItem();
                if (((storeTypeItem2 == null || (azVar = storeTypeItem2.f440366b) == null) ? null : azVar.C) != null) {
                    return gVar2.getStoreTypeItem().f440366b.C;
                }
            }
            bj n3 = n();
            if (n3 != null) {
                return n3.f440357i;
            }
            return null;
        }
        bj n16 = n();
        if (n16 != null) {
            return n16.f440357i;
        }
        return null;
    }

    private final bj n() {
        Object orNull;
        ao categoryCfg;
        bj[] bjVarArr;
        Object orNull2;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mData.getCategoryList(), this.mCurrentSelectedPos);
        PortalStorePanelCategoryData portalStorePanelCategoryData = (PortalStorePanelCategoryData) orNull;
        if (portalStorePanelCategoryData == null || (categoryCfg = portalStorePanelCategoryData.getCategoryCfg()) == null || (bjVarArr = categoryCfg.f440189g) == null) {
            return null;
        }
        orNull2 = ArraysKt___ArraysKt.getOrNull(bjVarArr, this.mChannel.getCurrentSelectedTypePos());
        return (bj) orNull2;
    }

    private final void p() {
        LifecycleOwner lifecycleOwner = this.mChannel.getLifecycleOwner();
        if (lifecycleOwner == null) {
            return;
        }
        this.mChannel.l().observe(lifecycleOwner, this.mDressIdChangeObserver);
    }

    private final boolean q() {
        Object obj;
        PortalStorePanelCategoryData f16 = this.mAdapter.f();
        if (f16 == null || this.mData.getCategoryList().isEmpty()) {
            return false;
        }
        Iterator<T> it = this.mData.getCategoryList().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((PortalStorePanelCategoryData) obj).getId(), f16.getId())) {
                break;
            }
        }
        return obj == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void t(PortalStoreSectionPanelPage this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        this$0.u(list);
    }

    private final void u(List<String> it) {
        w();
    }

    private final void v(int selectedIndex) {
        if (this.mData.getSectionCfgV1().f440340j) {
            this.mBinding.f418977e.setVisibility(8);
            this.mBinding.f418976d.setVisibility(8);
        } else {
            this.mBinding.f418977e.setVisibility(0);
            this.mBinding.f418976d.setVisibility(0);
        }
        this.mBinding.f418975c.j(this.mChannel.getLifecycleOwner());
        this.mBinding.f418975c.setTitleData(this.mData.getCategoryList(), selectedIndex);
        cc ccVar = this.mBinding;
        PortalStorePanelCategoryView portalStorePanelCategoryView = ccVar.f418975c;
        HorizontalScrollView horizontalScrollView = ccVar.f418977e;
        Intrinsics.checkNotNullExpressionValue(horizontalScrollView, "mBinding.subTitleScrollview");
        portalStorePanelCategoryView.k(horizontalScrollView, 0);
        cc ccVar2 = this.mBinding;
        PortalStorePanelCategoryView portalStorePanelCategoryView2 = ccVar2.f418975c;
        ViewPager viewPager = ccVar2.f418974b;
        Intrinsics.checkNotNullExpressionValue(viewPager, "mBinding.btmViewPager");
        portalStorePanelCategoryView2.b(viewPager);
    }

    private final void w() {
        boolean z16;
        String str;
        Object m476constructorimpl;
        bj n3 = n();
        if (n3 != null && (str = n3.f440363o) != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(new JSONObject(str));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = null;
            }
            JSONObject jSONObject = (JSONObject) m476constructorimpl;
            if (jSONObject != null && jSONObject.optInt("open_dyeing") == 1) {
                z16 = true;
                boolean z17 = (z16 || this.mChannel.getEngineApi().getType() == AvatarEngineType.UE_SMALL_HOME) ? false : true;
                if ((!this.mEntranceController.b(m()) && !this.mData.getSectionCfgV1().f440340j) || z17) {
                    this.mBinding.f418976d.h();
                    if (z17) {
                        Companion companion3 = INSTANCE;
                        if (!companion3.a()) {
                            companion3.b(true);
                            QUIDefaultBubbleTip.r(this.mBinding.f418976d.getContext()).S(this.mBinding.f418976d.getMColorEntranceView()).o0("\u4e3a\u5df2\u62e5\u6709\u7684\u670d\u88c5\u67d3\u8272").k0(1).R(0).m0(3).s0();
                        }
                        this.mBinding.f418976d.setClickListener(new b());
                        this.mBinding.f418976d.setColorEntranceReportId("em_zplan_clothing_dyeing_entrance");
                        return;
                    }
                    this.mBinding.f418976d.setClickListener(this);
                    this.mBinding.f418976d.setColorEntranceReportId("em_zplan_makeup_dye_entrance");
                    return;
                }
                this.mBinding.f418976d.d();
            }
        }
        z16 = false;
        if (z16) {
        }
        if (!this.mEntranceController.b(m())) {
        }
        this.mBinding.f418976d.d();
    }

    private final void x() {
        Object orNull;
        ao categoryCfg;
        Object obj;
        this.mData.getSectionCfgV1();
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mData.getCategoryList(), this.mCurrentSelectedPos);
        PortalStorePanelCategoryData portalStorePanelCategoryData = (PortalStorePanelCategoryData) orNull;
        if (portalStorePanelCategoryData == null || (categoryCfg = portalStorePanelCategoryData.getCategoryCfg()) == null) {
            return;
        }
        if (categoryCfg.f440192j) {
            this.mBinding.f418976d.setVisibility(8);
            return;
        }
        bj[] bjVarArr = categoryCfg.f440189g;
        Intrinsics.checkNotNullExpressionValue(bjVarArr, "categoryCfg.types");
        int length = bjVarArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            bj bjVar = bjVarArr[i3];
            if (Intrinsics.areEqual(bjVar != null ? bjVar.f440349a : null, categoryCfg.f440190h)) {
                obj = bjVar;
                break;
            }
            i3++;
        }
        if (obj == null) {
            return;
        }
        w();
    }

    private final void y() {
        Object obj;
        Object obj2;
        int indexOf;
        String str = this.mData.getSectionCfgV1().f440338h;
        Iterator<T> it = this.mData.getCategoryList().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            } else {
                obj2 = it.next();
                if (Intrinsics.areEqual(((PortalStorePanelCategoryData) obj2).getCategoryCfg().f440183a, str)) {
                    break;
                }
            }
        }
        PortalStorePanelCategoryData portalStorePanelCategoryData = (PortalStorePanelCategoryData) obj2;
        Iterator<T> it5 = this.mData.getCategoryList().iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            if (Intrinsics.areEqual(((PortalStorePanelCategoryData) next).getCategoryCfg().f440183a, this.mCurrentSelectedId)) {
                obj = next;
                break;
            }
        }
        PortalStorePanelCategoryData portalStorePanelCategoryData2 = (PortalStorePanelCategoryData) obj;
        if (portalStorePanelCategoryData2 != null) {
            indexOf = this.mData.getCategoryList().indexOf(portalStorePanelCategoryData2);
        } else {
            indexOf = portalStorePanelCategoryData == null ? 0 : this.mData.getCategoryList().indexOf(portalStorePanelCategoryData);
        }
        this.mCurrentSelectedPos = indexOf;
        this.mBinding.f418976d.setClickListener(this);
        v(indexOf);
        this.mBinding.f418974b.setAdapter(this.mAdapter);
        this.mAdapter.k(this.mData.getCategoryList());
        cc ccVar = this.mBinding;
        PortalStorePanelCategoryView portalStorePanelCategoryView = ccVar.f418975c;
        ViewPager viewPager = ccVar.f418974b;
        Intrinsics.checkNotNullExpressionValue(viewPager, "mBinding.btmViewPager");
        portalStorePanelCategoryView.b(viewPager);
        this.mBinding.f418974b.removeOnPageChangeListener(this);
        this.mBinding.f418974b.addOnPageChangeListener(this);
        this.mBinding.f418974b.setCurrentItem(indexOf);
        this.mCurrentSelectedPos = indexOf;
        x();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void a() {
        this.mAdapter.i();
    }

    @Override // ha4.a
    public void b(int itemIndex) {
        QLog.d("PortalStoreSectionPanelPage_", 1, "onColorEntranceClick mSelectedPosition:" + this.mCurrentSelectedPos);
        this.mEntranceController.d(m(), itemIndex, true);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void c() {
        Object orNull;
        String str = "parentIndex:" + this.mData.getParentIndex() + ", selfIndex:" + this.mData.getSelfIndex();
        boolean q16 = q();
        if (this.mPageIsShowing && !q16) {
            QLog.w("PortalStoreSectionPanelPage_", 1, "pageShow " + str + " filtered!");
            return;
        }
        QLog.i("PortalStoreSectionPanelPage_", 1, "pageShow " + str + ", isCurrentDataDirty=" + q16);
        this.mPageIsShowing = true;
        d94.d dVar = this.mAdapter;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mData.getCategoryList(), this.mBinding.f418974b.getCurrentItem());
        dVar.j((BaseZPlanTabTitleData) orNull);
        LifecycleOwner lifecycleOwner = this.mChannel.getLifecycleOwner();
        if (lifecycleOwner != null) {
            this.mChannel.c().observe(lifecycleOwner, this.mAutoOpenColorPickObserver);
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void d() {
        this.mBinding.f418975c.V();
        this.mAdapter.h();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void f() {
        QLog.i("PortalStoreSectionPanelPage_", 1, "pageHide " + ("parentIndex:" + this.mData.getParentIndex() + ", selfIndex:" + this.mData.getSelfIndex()));
        if (this.mPageIsShowing) {
            this.mBinding.f418975c.V();
        }
        this.mPageIsShowing = false;
        this.mAdapter.j(null);
        LifecycleOwner lifecycleOwner = this.mChannel.getLifecycleOwner();
        if (lifecycleOwner != null) {
            this.mChannel.c().removeObservers(lifecycleOwner);
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void g() {
        a.C9831a.a(this);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    /* renamed from: getPosition, reason: from getter */
    public int getMPosition() {
        return this.mPosition;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void h() {
        this.mBinding.f418975c.U();
        this.mAdapter.destroy();
        l();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    /* renamed from: o, reason: from getter */
    public PortalStorePanelSectionData getMData() {
        return this.mData;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.b
    public void onDataChanged() {
        w();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int position) {
        Object orNull;
        ao categoryCfg;
        this.mCurrentSelectedPos = position;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mData.getCategoryList(), position);
        PortalStorePanelCategoryData portalStorePanelCategoryData = (PortalStorePanelCategoryData) orNull;
        String str = (portalStorePanelCategoryData == null || (categoryCfg = portalStorePanelCategoryData.getCategoryCfg()) == null) ? null : categoryCfg.f440183a;
        if (str == null) {
            str = "";
        }
        this.mCurrentSelectedId = str;
        if (this.mPageIsShowing) {
            this.mAdapter.j(portalStorePanelCategoryData);
            VideoReport.traversePage(this.mBinding.getMRv());
        } else {
            this.mAdapter.j(null);
        }
        x();
    }

    public final void r(String typeId) {
        Object obj;
        int indexOf;
        Intrinsics.checkNotNullParameter(typeId, "typeId");
        QLog.i("PortalStoreSectionPanelPage_", 1, "jumpToTargetPage typeId:" + typeId);
        Iterator<T> it = this.mData.getCategoryList().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((PortalStorePanelCategoryData) obj).getCategoryCfg().f440183a, typeId)) {
                    break;
                }
            }
        }
        indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends PortalStorePanelCategoryData>) ((List<? extends Object>) this.mData.getCategoryList()), (PortalStorePanelCategoryData) obj);
        if (indexOf < 0) {
            return;
        }
        this.mBinding.f418974b.setCurrentItem(indexOf);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void setPosition(int position) {
        this.mPosition = position;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public void setData(PortalStorePanelSectionData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual(this.mData, data)) {
            return;
        }
        this.mData = data;
        p();
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(PortalStoreSectionPanelPage this$0, Context context, Pair pair) {
        ga4.g a16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        QLog.d("PortalStoreSectionPanelPage_", 1, "scheme tigger " + pair);
        int intValue = ((Number) pair.getFirst()).intValue();
        if (intValue != 0) {
            if (intValue == 1) {
                a.C10428a.a(this$0, 0, 1, null);
            } else if (intValue == 2) {
                JSONObject jSONObject = (JSONObject) pair.getSecond();
                int optInt = jSONObject != null ? jSONObject.optInt("item_id", -1) : -1;
                this$0.b(1);
                a16 = ga4.j.f401682a.a(8, this$0.mChannel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : new DialogCustomData(null, null, null, null, null, optInt, 31, null), (r22 & 16) != 0 ? false : false);
                a16.show();
            }
            this$0.mChannel.c().postValue(new Pair<>(0, null));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/page/PortalStoreSectionPanelPage$b", "Lha4/a;", "", "itemIndex", "", "b", "e", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements ha4.a {
        b() {
        }

        @Override // ha4.a
        public void b(int itemIndex) {
            PortalStoreSectionPanelPage.this.getContext().startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("mqqapi://zplan/openPage?src_type=app&version=1.0&pageID=21&pageData=%7B%22from%22%3A1%7D")));
        }

        @Override // ha4.a
        public void e() {
        }
    }

    @Override // ha4.a
    public void e() {
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.page.a
    public View getView() {
        return this;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }
}
