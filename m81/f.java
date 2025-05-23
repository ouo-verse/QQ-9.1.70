package m81;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.TitleTabEvent;
import com.tencent.mobileqq.aio.title.ab;
import com.tencent.mobileqq.aio.title.m;
import com.tencent.mobileqq.aio.title.troopguild.TroopGuildTitleTabUIState;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.aio.widget.AIOTitleRelativeLayout;
import com.tencent.mobileqq.aio.widget.AioTopGuildTab;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.aio.utils.j;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import m81.a;
import m81.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c9\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001e\u0018\u0000 o2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001pB3\u0012\u0006\u0010I\u001a\u00020F\u0012\u0006\u0010M\u001a\u00020J\u0012\u0006\u0010P\u001a\u00020\u0015\u0012\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0Q\u00a2\u0006\u0004\bm\u0010nJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J \u0010\"\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000fH\u0002J \u0010&\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0002J\u0018\u0010(\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0002J\u0018\u0010+\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0002J\b\u0010-\u001a\u00020,H\u0002J\u0010\u0010.\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010/\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0014\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001100H\u0002J\u0014\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001100H\u0002J\u0010\u00105\u001a\u00020#2\u0006\u00104\u001a\u000203H\u0016J\u0016\u00108\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030706H\u0016J\u001c\u0010;\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020:\u0018\u000109H\u0016J$\u0010=\u001a\u00020\r2\u001a\u0010<\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020:\u0018\u000109H\u0016J\b\u0010>\u001a\u00020\rH\u0016J\u0010\u0010@\u001a\u00020\r2\u0006\u0010?\u001a\u00020\u0003H\u0016J\u0012\u0010C\u001a\u0004\u0018\u00010,2\u0006\u0010B\u001a\u00020AH\u0016J\b\u0010D\u001a\u00020\rH\u0016J\b\u0010E\u001a\u00020\rH\u0016R\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010P\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR \u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010ZR\u0018\u0010`\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010h\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR&\u0010l\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020e0i068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010k\u00a8\u0006q"}, d2 = {"Lm81/f;", "Lcom/tencent/aio/base/mvvm/a;", "Lm81/a;", "Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState;", "Ln81/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "k1", "l1", "m1", "", NodeProps.VISIBLE, "", ICustomDataEditor.STRING_PARAM_1, "", "type", "", "data", Constants.APK_CERTIFICATE, "show", "", "headUrl", "F1", "cnt", "C1", "B1", "Lcom/tencent/mobileqq/aio/title/ab;", "y1", "isClick", "r1", "withAnim", "from", "entryMode", "q1", "Landroid/view/View;", "fromTab", "toTab", Constants.BASE_IN_PLUGIN_ID, "to", "w1", "isSelectMode", "isTroopGuild", "p1", "Landroid/os/Bundle;", ICustomDataEditor.NUMBER_PARAM_1, "u1", "v1", "", "j1", "i1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "", "Ljava/lang/Class;", "getObserverStates", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "mUIModel", "afterCreateVM", "bindViewAndData", "state", "o1", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "generateVBState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/aio/widget/AIOTitleRelativeLayout;", "d", "Lcom/tencent/mobileqq/aio/widget/AIOTitleRelativeLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewStub;", "e", "Landroid/view/ViewStub;", "tabViewStub", "f", "Ljava/lang/String;", "vbStr", "Lkotlin/Function1;", tl.h.F, "Lkotlin/jvm/functions/Function1;", "requestShow", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "tabView", "Lcom/tencent/mobileqq/aio/widget/AioTopGuildTab;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/widget/AioTopGuildTab;", "msgTab", BdhLogUtil.LogTag.Tag_Conn, "feedTab", "D", "Landroid/view/View;", "tabSlideView", "Landroid/animation/ValueAnimator;", "E", "Landroid/animation/ValueAnimator;", "tabSldieAnimator", "m81/f$b", UserInfo.SEX_FEMALE, "Lm81/f$b;", "mActionR", "Lkotlin/Pair;", "G", "Ljava/util/List;", "messageListR", "<init>", "(Lcom/tencent/mobileqq/aio/widget/AIOTitleRelativeLayout;Landroid/view/ViewStub;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "H", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f extends com.tencent.aio.base.mvvm.a<a, TroopGuildTitleTabUIState> implements n81.a {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private AioTopGuildTab feedTab;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View tabSlideView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator tabSldieAnimator;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final b mActionR;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> messageListR;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOTitleRelativeLayout parent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewStub tabViewStub;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String vbStr;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<String, Boolean> requestShow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup tabView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AioTopGuildTab msgTab;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"m81/f$b", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.b {
        b() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return f.this.k1(i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull AIOTitleRelativeLayout parent, @NotNull ViewStub tabViewStub, @NotNull String vbStr, @NotNull Function1<? super String, Boolean> requestShow) {
        List<Pair<String, b>> listOf;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(tabViewStub, "tabViewStub");
        Intrinsics.checkNotNullParameter(vbStr, "vbStr");
        Intrinsics.checkNotNullParameter(requestShow, "requestShow");
        this.parent = parent;
        this.tabViewStub = tabViewStub;
        this.vbStr = vbStr;
        this.requestShow = requestShow;
        b bVar = new b();
        this.mActionR = bVar;
        j jVar = j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(jVar.a(Reflection.getOrCreateKotlinClass(TitleTabEvent.GetFeedTabView.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(TitleTabEvent.GetReportDetail.class)), bVar)});
        this.messageListR = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q1(true, 0, 1);
        com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_top_feature_entry_right", this$0.i1());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void B1(boolean show) {
        if (show) {
            AioTopGuildTab aioTopGuildTab = this.feedTab;
            if (aioTopGuildTab != null) {
                aioTopGuildTab.A();
            }
            AioTopGuildTab aioTopGuildTab2 = this.feedTab;
            if (aioTopGuildTab2 != null) {
                aioTopGuildTab2.s();
                return;
            }
            return;
        }
        AioTopGuildTab aioTopGuildTab3 = this.feedTab;
        if (aioTopGuildTab3 != null) {
            aioTopGuildTab3.r();
        }
    }

    private final void C1(boolean show, String cnt) {
        if (show) {
            AioTopGuildTab aioTopGuildTab = this.feedTab;
            if (aioTopGuildTab != null) {
                aioTopGuildTab.B(cnt);
            }
            AioTopGuildTab aioTopGuildTab2 = this.feedTab;
            if (aioTopGuildTab2 != null) {
                aioTopGuildTab2.r();
                return;
            }
            return;
        }
        AioTopGuildTab aioTopGuildTab3 = this.feedTab;
        if (aioTopGuildTab3 != null) {
            aioTopGuildTab3.s();
        }
    }

    private final void D1(boolean withAnim, View fromTab, final View toTab) {
        if (withAnim) {
            w1(fromTab.getLeft(), toTab.getLeft());
        } else {
            toTab.postDelayed(new Runnable() { // from class: m81.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.E1(f.this, toTab);
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(f this$0, View toTab) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(toTab, "$toTab");
        View view = this$0.tabSlideView;
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            if (toTab.getMeasuredWidth() > 0) {
                layoutParams2.width = toTab.getMeasuredWidth();
                layoutParams2.leftMargin = toTab.getLeft();
            } else {
                layoutParams2.width = ViewUtils.f352270a.b(24);
            }
            View view2 = this$0.tabSlideView;
            if (view2 != null) {
                view2.requestLayout();
            }
            QLog.i("TroopGuildTitleTabVB", 1, "updateSlideView end delay");
        }
    }

    private final void F1(boolean show, String headUrl) {
        if (show) {
            AioTopGuildTab aioTopGuildTab = this.feedTab;
            if (aioTopGuildTab != null) {
                aioTopGuildTab.setHeadImg(headUrl);
                return;
            }
            return;
        }
        AioTopGuildTab aioTopGuildTab2 = this.feedTab;
        if (aioTopGuildTab2 != null) {
            aioTopGuildTab2.q();
        }
    }

    private final void G1(int type, Object data) {
        switch (type) {
            case 1:
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.String");
                F1(true, (String) data);
                return;
            case 2:
                F1(false, "");
                return;
            case 3:
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.String");
                C1(true, (String) data);
                return;
            case 4:
                C1(false, "");
                return;
            case 5:
                B1(true);
                return;
            case 6:
                B1(false);
                return;
            default:
                return;
        }
    }

    private final Map<String, Object> i1() {
        HashMap hashMap = new HashMap();
        hashMap.put("aio_right_business_type", "2");
        return hashMap;
    }

    private final Map<String, Object> j1() {
        HashMap hashMap = new HashMap();
        hashMap.put("aio_left_business_type", "1");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k k1(MsgIntent i3) {
        if (i3 instanceof TitleTabEvent.GetFeedTabView) {
            return l1();
        }
        if (i3 instanceof TitleTabEvent.GetReportDetail) {
            return m1();
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final k l1() {
        AioTopGuildTab aioTopGuildTab = this.feedTab;
        if (aioTopGuildTab != null) {
            return new m.a(aioTopGuildTab);
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final k m1() {
        AioTopGuildTab aioTopGuildTab = this.feedTab;
        if (aioTopGuildTab != null && this.msgTab != null) {
            Intrinsics.checkNotNull(aioTopGuildTab);
            AioTopGuildTab aioTopGuildTab2 = this.msgTab;
            Intrinsics.checkNotNull(aioTopGuildTab2);
            AioTopGuildTab aioTopGuildTab3 = this.feedTab;
            Intrinsics.checkNotNull(aioTopGuildTab3);
            return new m.c(aioTopGuildTab, aioTopGuildTab2, aioTopGuildTab3.n());
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final Bundle n1() {
        boolean z16;
        boolean z17;
        Bundle bundle = new Bundle();
        ViewGroup viewGroup = this.tabView;
        boolean z18 = false;
        if (viewGroup != null && viewGroup.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        bundle.putBoolean("KEY_TITLE_TAB_SHOW", z16);
        AioTopGuildTab aioTopGuildTab = this.feedTab;
        if (aioTopGuildTab != null) {
            z17 = aioTopGuildTab.o();
        } else {
            z17 = false;
        }
        bundle.putBoolean("KEY_FEED_TAB_SELECTED", z17);
        AioTopGuildTab aioTopGuildTab2 = this.msgTab;
        if (aioTopGuildTab2 != null) {
            z18 = aioTopGuildTab2.o();
        }
        bundle.putBoolean("KEY_MSG_TAB_SELECTED", z18);
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.view.View] */
    private final void p1(boolean isSelectMode, boolean isTroopGuild) {
        if (isSelectMode) {
            u1(false);
            v1(false);
            ViewGroup viewGroup = this.tabView;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                return;
            }
            return;
        }
        if (isTroopGuild) {
            ViewGroup viewGroup2 = this.tabView;
            if (viewGroup2 != null) {
                Boolean invoke = this.requestShow.invoke(this.vbStr);
                viewGroup2.setVisibility(0);
                ?? r56 = (View) au.a(invoke, viewGroup2);
                if (r56 == 0) {
                    viewGroup2.setVisibility(8);
                } else {
                    viewGroup2 = r56;
                }
            }
            u1(true);
            v1(true);
        }
    }

    private final void q1(boolean withAnim, int from, int entryMode) {
        boolean z16;
        AioTopGuildTab aioTopGuildTab = this.feedTab;
        if (aioTopGuildTab != null && this.msgTab != null) {
            Intrinsics.checkNotNull(aioTopGuildTab);
            QLog.i("TroopGuildTitleTabVB", 1, "onSelectFeedTab withAnim:" + withAnim + " from:" + from + " entryMode:" + entryMode + " feedTabIsSelect:" + aioTopGuildTab.o());
            AioTopGuildTab aioTopGuildTab2 = this.msgTab;
            Intrinsics.checkNotNull(aioTopGuildTab2);
            aioTopGuildTab2.E();
            AioTopGuildTab aioTopGuildTab3 = this.feedTab;
            Intrinsics.checkNotNull(aioTopGuildTab3);
            if (!aioTopGuildTab3.o()) {
                AioTopGuildTab aioTopGuildTab4 = this.feedTab;
                Intrinsics.checkNotNull(aioTopGuildTab4);
                aioTopGuildTab4.v(true);
                AioTopGuildTab aioTopGuildTab5 = this.msgTab;
                Intrinsics.checkNotNull(aioTopGuildTab5);
                AioTopGuildTab aioTopGuildTab6 = this.feedTab;
                Intrinsics.checkNotNull(aioTopGuildTab6);
                D1(withAnim, aioTopGuildTab5, aioTopGuildTab6);
                sendIntent(new a.FeedTabSelectEvent(from, entryMode));
                return;
            }
            return;
        }
        boolean z17 = false;
        if (aioTopGuildTab == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.msgTab == null) {
            z17 = true;
        }
        QLog.i("TroopGuildTitleTabVB", 1, "onSelectFeedTab withAnim:" + withAnim + " from:" + from + " entryMode:" + entryMode + " feedTab:" + z16 + " msgTab:" + z17);
    }

    private final void r1(boolean isClick) {
        boolean z16;
        AioTopGuildTab aioTopGuildTab;
        AioTopGuildTab aioTopGuildTab2 = this.feedTab;
        if (aioTopGuildTab2 != null && (aioTopGuildTab = this.msgTab) != null) {
            Intrinsics.checkNotNull(aioTopGuildTab);
            QLog.i("TroopGuildTitleTabVB", 1, "onSelectMsgTab isClick:" + isClick + " msgTabIsSelect:" + aioTopGuildTab.o());
            AioTopGuildTab aioTopGuildTab3 = this.feedTab;
            Intrinsics.checkNotNull(aioTopGuildTab3);
            aioTopGuildTab3.E();
            AioTopGuildTab aioTopGuildTab4 = this.msgTab;
            Intrinsics.checkNotNull(aioTopGuildTab4);
            if (!aioTopGuildTab4.o()) {
                AioTopGuildTab aioTopGuildTab5 = this.msgTab;
                Intrinsics.checkNotNull(aioTopGuildTab5);
                aioTopGuildTab5.v(true);
                AioTopGuildTab aioTopGuildTab6 = this.feedTab;
                Intrinsics.checkNotNull(aioTopGuildTab6);
                AioTopGuildTab aioTopGuildTab7 = this.msgTab;
                Intrinsics.checkNotNull(aioTopGuildTab7);
                D1(isClick, aioTopGuildTab6, aioTopGuildTab7);
                sendIntent(new a.MsgTabSelectEvent(isClick, isClick));
                return;
            }
            return;
        }
        boolean z17 = false;
        if (aioTopGuildTab2 == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.msgTab == null) {
            z17 = true;
        }
        QLog.i("TroopGuildTitleTabVB", 1, "onSelectMsgTab isClick:" + isClick + " feedTab:" + z16 + " msgTab:" + z17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.view.View] */
    private final void s1(boolean visible) {
        if (visible) {
            v1(true);
            ViewGroup viewGroup = this.tabView;
            if (viewGroup != null) {
                Boolean invoke = this.requestShow.invoke(this.vbStr);
                viewGroup.setVisibility(0);
                ?? r16 = (View) au.a(invoke, viewGroup);
                if (r16 == 0) {
                    viewGroup.setVisibility(8);
                } else {
                    viewGroup = r16;
                }
                return;
            }
            return;
        }
        v1(false);
        ViewGroup viewGroup2 = this.tabView;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
    }

    private final void u1(boolean visible) {
        AioTopGuildTab aioTopGuildTab = this.feedTab;
        if (aioTopGuildTab == null) {
            return;
        }
        if (visible) {
            com.tencent.mobileqq.aio.utils.b.q("em_bas_aio_top_feature_entry_right", i1());
            return;
        }
        boolean z16 = false;
        if (aioTopGuildTab != null && aioTopGuildTab.getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            com.tencent.mobileqq.aio.utils.b.t("em_bas_aio_top_feature_entry_right", i1());
        }
    }

    private final void v1(boolean visible) {
        AioTopGuildTab aioTopGuildTab = this.msgTab;
        if (aioTopGuildTab == null) {
            return;
        }
        if (visible) {
            com.tencent.mobileqq.aio.utils.b.q("em_bas_aio_top_feature_entry_left", j1());
            return;
        }
        boolean z16 = false;
        if (aioTopGuildTab != null && aioTopGuildTab.getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            com.tencent.mobileqq.aio.utils.b.t("em_bas_aio_top_feature_entry_left", j1());
        }
    }

    private final void w1(int from, int to5) {
        boolean z16;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.tabSldieAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (valueAnimator = this.tabSldieAnimator) != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(from, to5);
        ofInt.setDuration(420L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: m81.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                f.x1(f.this, valueAnimator3);
            }
        });
        ofInt.addListener(new c(to5, from));
        this.tabSldieAnimator = ofInt;
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(f this$0, ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        View view = this$0.tabSlideView;
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = intValue;
            View view2 = this$0.tabSlideView;
            if (view2 != null) {
                view2.requestLayout();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.view.View] */
    private final void y1(ab data) {
        AioTopGuildTab aioTopGuildTab;
        AioTopGuildTab aioTopGuildTab2;
        if (!data.e()) {
            ViewGroup viewGroup = this.tabView;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                return;
            }
            return;
        }
        if (this.tabView == null) {
            View inflate = this.tabViewStub.inflate();
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup2 = (ViewGroup) inflate;
            this.tabView = viewGroup2;
            View view = null;
            if (viewGroup2 != null) {
                aioTopGuildTab = (AioTopGuildTab) viewGroup2.findViewById(R.id.zgr);
            } else {
                aioTopGuildTab = null;
            }
            this.msgTab = aioTopGuildTab;
            ViewGroup viewGroup3 = this.tabView;
            if (viewGroup3 != null) {
                aioTopGuildTab2 = (AioTopGuildTab) viewGroup3.findViewById(R.id.v3k);
            } else {
                aioTopGuildTab2 = null;
            }
            this.feedTab = aioTopGuildTab2;
            ViewGroup viewGroup4 = this.tabView;
            if (viewGroup4 != null) {
                view = viewGroup4.findViewById(R.id.f101935wj);
            }
            this.tabSlideView = view;
            AioTopGuildTab aioTopGuildTab3 = this.msgTab;
            if (aioTopGuildTab3 != null) {
                aioTopGuildTab3.l(data.d(), data.c());
            }
            AioTopGuildTab aioTopGuildTab4 = this.msgTab;
            if (aioTopGuildTab4 != null) {
                aioTopGuildTab4.setOnClickListener(new View.OnClickListener() { // from class: m81.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        f.z1(f.this, view2);
                    }
                });
            }
            AioTopGuildTab aioTopGuildTab5 = this.feedTab;
            if (aioTopGuildTab5 != null) {
                aioTopGuildTab5.l(data.b(), data.a());
            }
            AioTopGuildTab aioTopGuildTab6 = this.feedTab;
            if (aioTopGuildTab6 != null) {
                aioTopGuildTab6.setOnClickListener(new View.OnClickListener() { // from class: m81.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        f.A1(f.this, view2);
                    }
                });
            }
        }
        ViewGroup viewGroup5 = this.tabView;
        if (viewGroup5 != null) {
            Boolean invoke = this.requestShow.invoke(this.vbStr);
            viewGroup5.setVisibility(0);
            ?? r26 = (View) au.a(invoke, viewGroup5);
            if (r26 == 0) {
                viewGroup5.setVisibility(8);
            } else {
                viewGroup5 = r26;
            }
        }
        r1(false);
        u1(true);
        v1(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r1(true);
        com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_top_feature_entry_left", this$0.j1());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aio.base.mvvm.a, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void afterCreateVM(@Nullable BaseVM<a, TroopGuildTitleTabUIState, com.tencent.aio.api.runtime.a> mUIModel) {
        com.tencent.aio.api.runtime.a mContext;
        super.afterCreateVM(mUIModel);
        if (mUIModel != null && (mContext = mUIModel.getMContext()) != null) {
            Iterator<T> it = this.messageListR.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                com.tencent.mvi.base.route.j e16 = mContext.e();
                String str = (String) pair.getFirst();
                com.tencent.mvi.base.route.b bVar = (com.tencent.mvi.base.route.b) pair.getSecond();
                LifecycleOwner d16 = mContext.d();
                Intrinsics.checkNotNullExpressionValue(d16, "aioContext.lifecycleOwner");
                e16.g(str, bVar, d16);
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        sendIntent(a.c.f416420d);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<a, TroopGuildTitleTabUIState, com.tencent.aio.api.runtime.a> createVM() {
        return new h();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof g.a) {
            return n1();
        }
        return new Bundle();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends TroopGuildTitleTabUIState>> getObserverStates() {
        List<Class<? extends TroopGuildTitleTabUIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(TroopGuildTitleTabUIState.UpdateGuildTroopState.class);
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull TroopGuildTitleTabUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof TroopGuildTitleTabUIState.UpdateGuildTroopState) {
            y1(((TroopGuildTitleTabUIState.UpdateGuildTroopState) state).getData());
            return;
        }
        if (state instanceof TroopGuildTitleTabUIState.UpdateTroopGuildTab) {
            TroopGuildTitleTabUIState.UpdateTroopGuildTab updateTroopGuildTab = (TroopGuildTitleTabUIState.UpdateTroopGuildTab) state;
            G1(updateTroopGuildTab.getType(), updateTroopGuildTab.getData());
            return;
        }
        if (state instanceof TroopGuildTitleTabUIState.SelectFeedTab) {
            TroopGuildTitleTabUIState.SelectFeedTab selectFeedTab = (TroopGuildTitleTabUIState.SelectFeedTab) state;
            q1(selectFeedTab.getWithAnim(), selectFeedTab.getFrom(), selectFeedTab.getEntryMode());
        } else {
            if (state instanceof TroopGuildTitleTabUIState.SelectMsgTab) {
                r1(true);
                return;
            }
            if (state instanceof TroopGuildTitleTabUIState.MultiSelectModeChangeState) {
                TroopGuildTitleTabUIState.MultiSelectModeChangeState multiSelectModeChangeState = (TroopGuildTitleTabUIState.MultiSelectModeChangeState) state;
                p1(multiSelectModeChangeState.getIsSelectMode(), multiSelectModeChangeState.getIsTroopGuild());
            } else if (state instanceof TroopGuildTitleTabUIState.SetVisibility) {
                s1(((TroopGuildTitleTabUIState.SetVisibility) state).getVisible());
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return this.tabViewStub;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        u1(false);
        v1(false);
    }

    @Override // n81.a
    public void x() {
        ViewGroup viewGroup = this.tabView;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"m81/f$c", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationRepeat", "onAnimationEnd", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c extends com.tencent.mobileqq.widget.f {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f416434e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f416435f;

        c(int i3, int i16) {
            this.f416434e = i3;
            this.f416435f = i16;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            ViewGroup.LayoutParams layoutParams;
            Integer num;
            View view = f.this.tabSlideView;
            if (view != null && (layoutParams = view.getLayoutParams()) != null) {
                int i3 = this.f416434e;
                f fVar = f.this;
                int i16 = this.f416435f;
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i3;
                AioTopGuildTab aioTopGuildTab = fVar.msgTab;
                if (aioTopGuildTab != null) {
                    num = Integer.valueOf(aioTopGuildTab.getMeasuredWidth());
                } else {
                    num = null;
                }
                if (num != null && num.intValue() > 0) {
                    layoutParams.width = num.intValue();
                }
                View view2 = fVar.tabSlideView;
                if (view2 != null) {
                    view2.requestLayout();
                }
                QLog.i("TroopGuildTitleTabVB", 1, "runSlideMoveAnim end from:" + i16 + " to:" + i3);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }
    }
}
