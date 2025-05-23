package com.qzone.reborn.message.part;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.feed.ui.activity.QZoneMyFeedFragment;
import com.qzone.reborn.intimate.fragment.QZoneIntimateMessageFragment;
import com.qzone.reborn.intimate.request.QZoneIntimateClearRedDotRequest;
import com.qzone.reborn.message.fragment.QZoneIntimateMessageNewFragment;
import com.qzone.reborn.message.fragment.QZonePassiveMessageNewStyleFragment;
import com.qzone.reborn.message.fragment.QZonePassiveMessageOldStyleFragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat;
import com.tencent.biz.qqcircle.richframework.widget.ViewPagerCompat;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceReader$ClearReddotRsp;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \\2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001]B\u0007\u00a2\u0006\u0004\bZ\u0010[J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u001e\u001a\u00020\fH\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\fH\u0016J\b\u0010!\u001a\u00020\fH\u0016J\u0014\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"H\u0016R\u0016\u0010'\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u00106\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u00106\u001a\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR&\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020M0Lj\b\u0012\u0004\u0012\u00020M`N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010SR\u0016\u0010W\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010SR\u0016\u0010Y\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010S\u00a8\u0006^"}, d2 = {"Lcom/qzone/reborn/message/part/QZonePassiveMessageTabPart;", "Lcom/qzone/reborn/base/k;", "Lgf/p;", "Ldl/f;", "Landroid/content/Intent;", "intent", "", "aa", "V9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "T9", "", "S9", "initViewModel", "J9", "X9", "W9", "", "Landroidx/fragment/app/Fragment;", "H9", "", "I9", "view", "Z9", "Y9", "K9", "ba", "R9", "N9", "M9", "onInitView", "k1", "U5", "", "", "O1", "d", "Landroid/view/View;", "mTitleHost", "Lcom/qzone/reborn/base/o;", "e", "Lcom/qzone/reborn/base/o;", "mAdapter", "Lcom/tencent/biz/qqcircle/richframework/widget/ViewPagerCompat;", "f", "Lcom/tencent/biz/qqcircle/richframework/widget/ViewPagerCompat;", "mViewPager", "Lcom/tencent/biz/qqcircle/richframework/widget/TabLayoutCompat;", tl.h.F, "Lcom/tencent/biz/qqcircle/richframework/widget/TabLayoutCompat;", "mTabLayout", "Lcom/qzone/feed/ui/activity/QZoneMyFeedFragment;", "i", "Lkotlin/Lazy;", "O9", "()Lcom/qzone/feed/ui/activity/QZoneMyFeedFragment;", "mQZoneMsgFrag", "Lcom/qzone/reborn/message/fragment/QZonePassiveMessageOldStyleFragment;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Q9", "()Lcom/qzone/reborn/message/fragment/QZonePassiveMessageOldStyleFragment;", "mQZoneMsgOldFrag", "Lcom/qzone/reborn/message/fragment/QZonePassiveMessageNewStyleFragment;", BdhLogUtil.LogTag.Tag_Conn, "P9", "()Lcom/qzone/reborn/message/fragment/QZonePassiveMessageNewStyleFragment;", "mQZoneMsgNewFrag", "Lcom/qzone/reborn/intimate/fragment/QZoneIntimateMessageFragment;", "D", "Lcom/qzone/reborn/intimate/fragment/QZoneIntimateMessageFragment;", "mIntimateMsgFrag", "Lcom/qzone/reborn/message/fragment/QZoneIntimateMessageNewFragment;", "E", "Lcom/qzone/reborn/message/fragment/QZoneIntimateMessageNewFragment;", "mIntimateMsgNewFrag", "Ljava/util/ArrayList;", "Lzk/a;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "mTabViews", "G", "I", "intimateRedNum", "H", "qzoneRedNum", "mMode", "J", "mFirstShowIndex", "<init>", "()V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePassiveMessageTabPart extends com.qzone.reborn.base.k implements gf.p, dl.f {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy mQZoneMsgNewFrag;

    /* renamed from: D, reason: from kotlin metadata */
    private QZoneIntimateMessageFragment mIntimateMsgFrag;

    /* renamed from: E, reason: from kotlin metadata */
    private QZoneIntimateMessageNewFragment mIntimateMsgNewFrag;

    /* renamed from: F, reason: from kotlin metadata */
    private ArrayList<zk.a> mTabViews;

    /* renamed from: G, reason: from kotlin metadata */
    private int intimateRedNum;

    /* renamed from: H, reason: from kotlin metadata */
    private int qzoneRedNum;

    /* renamed from: I, reason: from kotlin metadata */
    private int mMode;

    /* renamed from: J, reason: from kotlin metadata */
    private int mFirstShowIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mTitleHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.base.o mAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewPagerCompat mViewPager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TabLayoutCompat mTabLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy mQZoneMsgFrag;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy mQZoneMsgOldFrag;

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/message/part/QZonePassiveMessageTabPart$b", "Lcom/tencent/biz/qqcircle/richframework/widget/TabLayoutCompat$j;", "Landroid/view/ViewGroup;", "tabView", "", "position", "Landroid/view/View;", "b", "Lcom/tencent/biz/qqcircle/richframework/widget/TabLayoutCompat$f;", "tab", "lastTab", "status", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements TabLayoutCompat.j {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.j
        public void a(TabLayoutCompat.f tab, TabLayoutCompat.f lastTab, int status) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            int d16 = tab.d();
            if (!ab0.a.a(d16, QZonePassiveMessageTabPart.this.mTabViews)) {
                ((zk.a) QZonePassiveMessageTabPart.this.mTabViews.get(d16)).b(0);
            }
            if (d16 == 0) {
                dh.d.f393812a.e();
            } else {
                if (d16 != 1) {
                    return;
                }
                dh.d.f393812a.a();
                QZonePassiveMessageTabPart.this.K9();
            }
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.j
        public View b(ViewGroup tabView, int position) {
            Intrinsics.checkNotNullParameter(tabView, "tabView");
            zk.a aVar = new zk.a(tabView);
            com.qzone.reborn.base.o oVar = QZonePassiveMessageTabPart.this.mAdapter;
            if (oVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                oVar = null;
            }
            if (oVar.d().size() > 1) {
                if (position == 0) {
                    aVar.b(dh.d.f393812a.z());
                } else if (position == 1) {
                    aVar.b(dh.d.f393812a.q());
                }
            }
            QZonePassiveMessageTabPart.this.mTabViews.add(aVar);
            return aVar.getMRootView();
        }
    }

    public QZonePassiveMessageTabPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QZoneMyFeedFragment>() { // from class: com.qzone.reborn.message.part.QZonePassiveMessageTabPart$mQZoneMsgFrag$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QZoneMyFeedFragment invoke() {
                return new QZoneMyFeedFragment();
            }
        });
        this.mQZoneMsgFrag = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QZonePassiveMessageOldStyleFragment>() { // from class: com.qzone.reborn.message.part.QZonePassiveMessageTabPart$mQZoneMsgOldFrag$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QZonePassiveMessageOldStyleFragment invoke() {
                return new QZonePassiveMessageOldStyleFragment();
            }
        });
        this.mQZoneMsgOldFrag = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<QZonePassiveMessageNewStyleFragment>() { // from class: com.qzone.reborn.message.part.QZonePassiveMessageTabPart$mQZoneMsgNewFrag$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QZonePassiveMessageNewStyleFragment invoke() {
                return new QZonePassiveMessageNewStyleFragment();
            }
        });
        this.mQZoneMsgNewFrag = lazy3;
        this.mTabViews = new ArrayList<>();
    }

    private final List<Fragment> H9() {
        List<Fragment> mutableListOf;
        List<Fragment> mutableListOf2;
        Fragment R9 = R9();
        Fragment N9 = N9();
        if (N9 != null) {
            mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(R9, N9);
            return mutableListOf2;
        }
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(R9);
        return mutableListOf;
    }

    private final List<String> I9() {
        List<String> mutableListOf;
        List<String> mutableListOf2;
        if (N9() != null) {
            mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf("\u7a7a\u95f4", "\u5bc6\u53cb");
            return mutableListOf2;
        }
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("\u7a7a\u95f4\u6d88\u606f");
        return mutableListOf;
    }

    private final void J9() {
        int i3 = this.mMode;
        int i16 = 0;
        if (i3 == 0) {
            this.mFirstShowIndex = 0;
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            this.mFirstShowIndex = 1;
            return;
        }
        dh.d dVar = dh.d.f393812a;
        this.qzoneRedNum = dVar.z();
        int q16 = dVar.q();
        this.intimateRedNum = q16;
        int i17 = this.qzoneRedNum;
        if ((i17 <= 0 || q16 <= 0) && ((i17 != 0 || q16 != 0) && q16 > 0)) {
            i16 = 1;
        }
        this.mFirstShowIndex = i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9() {
        VSNetworkHelper.getInstance().sendRequest(new QZoneIntimateClearRedDotRequest(1), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.message.part.u
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QZonePassiveMessageTabPart.L9(baseRequest, z16, j3, str, (QZIntimateSpaceReader$ClearReddotRsp) obj);
            }
        });
    }

    private final int M9() {
        Object orNull;
        com.qzone.reborn.base.o oVar = this.mAdapter;
        ViewPagerCompat viewPagerCompat = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            oVar = null;
        }
        List<Fragment> d16 = oVar.d();
        ViewPagerCompat viewPagerCompat2 = this.mViewPager;
        if (viewPagerCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        } else {
            viewPagerCompat = viewPagerCompat2;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(d16, viewPagerCompat.getCurrentItem());
        Fragment fragment = (Fragment) orNull;
        if (!(Intrinsics.areEqual(fragment, P9()) ? true : Intrinsics.areEqual(fragment, O9()) ? true : Intrinsics.areEqual(fragment, Q9()))) {
            if (Intrinsics.areEqual(fragment, this.mIntimateMsgNewFrag) ? true : Intrinsics.areEqual(fragment, this.mIntimateMsgFrag)) {
                return 1;
            }
        }
        return 0;
    }

    private final Fragment N9() {
        if (gl.c.f402376a.d()) {
            return this.mIntimateMsgNewFrag;
        }
        return this.mIntimateMsgFrag;
    }

    private final QZoneMyFeedFragment O9() {
        return (QZoneMyFeedFragment) this.mQZoneMsgFrag.getValue();
    }

    private final QZonePassiveMessageNewStyleFragment P9() {
        return (QZonePassiveMessageNewStyleFragment) this.mQZoneMsgNewFrag.getValue();
    }

    private final QZonePassiveMessageOldStyleFragment Q9() {
        return (QZonePassiveMessageOldStyleFragment) this.mQZoneMsgOldFrag.getValue();
    }

    private final Fragment R9() {
        gl.c cVar = gl.c.f402376a;
        if (cVar.e()) {
            return Q9();
        }
        if (cVar.d()) {
            return P9();
        }
        return O9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(QZonePassiveMessageTabPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void V9() {
        registerIoc(this, gf.p.class);
        registerIoc(this, dl.f.class);
    }

    private final void W9() {
        if (this.mFirstShowIndex == 0) {
            dh.d.f393812a.e();
        }
        com.qzone.reborn.base.o oVar = this.mAdapter;
        ViewPagerCompat viewPagerCompat = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            oVar = null;
        }
        oVar.f(H9(), I9());
        ViewPagerCompat viewPagerCompat2 = this.mViewPager;
        if (viewPagerCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        } else {
            viewPagerCompat = viewPagerCompat2;
        }
        viewPagerCompat.setCurrentItem(this.mFirstShowIndex, false);
    }

    private final void X9() {
        if (gl.c.f402376a.d()) {
            if (this.mIntimateMsgNewFrag == null) {
                this.mIntimateMsgNewFrag = new QZoneIntimateMessageNewFragment();
            }
        } else if (this.mIntimateMsgFrag == null) {
            this.mIntimateMsgFrag = new QZoneIntimateMessageFragment();
        }
    }

    private final void Z9(View view) {
        FragmentManager childFragmentManager = getHostFragment().getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "hostFragment.childFragmentManager");
        this.mAdapter = new com.qzone.reborn.base.o(childFragmentManager, 1);
        View findViewById = view.findViewById(R.id.n7y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.qzone_message_view_pager)");
        ViewPagerCompat viewPagerCompat = (ViewPagerCompat) findViewById;
        this.mViewPager = viewPagerCompat;
        com.qzone.reborn.base.o oVar = null;
        if (viewPagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPagerCompat = null;
        }
        com.qzone.reborn.base.o oVar2 = this.mAdapter;
        if (oVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            oVar = oVar2;
        }
        viewPagerCompat.setAdapter(oVar);
    }

    private final void aa(Intent intent) {
        this.mMode = intent.getIntExtra("mode", 0);
    }

    private final void ba() {
        Activity activity = getActivity();
        if (activity != null) {
            int color = activity.getColor(R.color.qui_common_brand_standard);
            int color2 = activity.getColor(R.color.qui_common_text_primary);
            TabLayoutCompat tabLayoutCompat = this.mTabLayout;
            if (tabLayoutCompat == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
                tabLayoutCompat = null;
            }
            Fragment N9 = N9();
            tabLayoutCompat.setCutomViewBeRelated(true);
            tabLayoutCompat.setSelectedTabIndicatorColor(N9 != null ? Integer.valueOf(color).intValue() : -1);
            tabLayoutCompat.setSelectedTabIndicatorHeight(N9 != null ? ef.d.b(2) : 0);
            if (N9 == null) {
                color = color2;
            }
            tabLayoutCompat.setTabTextColors(color2, color);
            tabLayoutCompat.setTabTextSize(ef.d.d(N9 != null ? 16 : 17));
        }
    }

    private final void initViewModel() {
        if (!com.qzone.reborn.configx.g.f53821a.h().F()) {
            RFWLog.i("QZonePassiveMessageTabPart", RFWLog.USR, "intimate entrance is closed, clear intimate passive redCount ifNeed");
            this.mFirstShowIndex = 0;
            dh.d.f393812a.a();
        } else {
            X9();
            J9();
        }
    }

    @Override // dl.f
    public Map<String, Object> O1() {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("ui_module", Integer.valueOf(gl.c.f402376a.d() ? 1 : 0)), TuplesKt.to("business_type", Integer.valueOf(M9())));
        return mutableMapOf;
    }

    @Override // gf.p
    /* renamed from: U5, reason: from getter */
    public int getQzoneRedNum() {
        return this.qzoneRedNum;
    }

    @Override // gf.p
    /* renamed from: k1, reason: from getter */
    public int getIntimateRedNum() {
        return this.intimateRedNum;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        if (getActivity() != null) {
            Activity activity = getActivity();
            Intrinsics.checkNotNull(activity);
            Intent intent = activity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            aa(intent);
        }
        V9();
        initViewModel();
        T9(rootView);
        Z9(rootView);
        Y9(rootView);
        W9();
        gl.c.f402376a.g();
    }

    private final int S9() {
        return ef.d.b(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(BaseRequest baseRequest, boolean z16, long j3, String str, QZIntimateSpaceReader$ClearReddotRsp qZIntimateSpaceReader$ClearReddotRsp) {
        QLog.i("QZonePassiveMessageTabPart", 1, "clearIntimateMsgRedDot,isSuccess = " + z16 + " | retCode = " + j3 + " | errMsg = " + str + " | cmdName = " + (baseRequest != null ? baseRequest.getCmd() : null) + " | traceId = " + (baseRequest != null ? baseRequest.getTraceId() : null));
    }

    private final void T9(View rootView) {
        View findViewById = rootView.findViewById(R.id.n7e);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026message_layout_container)");
        this.mTitleHost = findViewById;
        View view = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleHost");
            findViewById = null;
        }
        findViewById.getLayoutParams().height = ImmersiveUtils.getStatusBarHeight(getContext()) + S9();
        View view2 = this.mTitleHost;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleHost");
        } else {
            view = view2;
        }
        view.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        View findViewById2 = rootView.findViewById(R.id.n7v);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026qzone_message_title_back)");
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.message.part.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                QZonePassiveMessageTabPart.U9(QZonePassiveMessageTabPart.this, view3);
            }
        });
    }

    private final void Y9(View view) {
        View findViewById = view.findViewById(R.id.n7q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.qzone_message_tab_layout)");
        TabLayoutCompat tabLayoutCompat = (TabLayoutCompat) findViewById;
        this.mTabLayout = tabLayoutCompat;
        TabLayoutCompat tabLayoutCompat2 = null;
        if (tabLayoutCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat = null;
        }
        ViewPagerCompat viewPagerCompat = this.mViewPager;
        if (viewPagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPagerCompat = null;
        }
        tabLayoutCompat.setupWithViewPager(viewPagerCompat);
        TabLayoutCompat tabLayoutCompat3 = this.mTabLayout;
        if (tabLayoutCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat3 = null;
        }
        tabLayoutCompat3.setRequestedTabMinWidth(ef.d.b(120));
        TabLayoutCompat tabLayoutCompat4 = this.mTabLayout;
        if (tabLayoutCompat4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat4 = null;
        }
        tabLayoutCompat4.setTabMode(1);
        TabLayoutCompat tabLayoutCompat5 = this.mTabLayout;
        if (tabLayoutCompat5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat5 = null;
        }
        tabLayoutCompat5.setSelectedIndicatorNoShadowLayer();
        TabLayoutCompat tabLayoutCompat6 = this.mTabLayout;
        if (tabLayoutCompat6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat6 = null;
        }
        tabLayoutCompat6.setSelectedTabIndicatorWidth(ef.d.b(34));
        TabLayoutCompat tabLayoutCompat7 = this.mTabLayout;
        if (tabLayoutCompat7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat7 = null;
        }
        tabLayoutCompat7.setSelectedTabIndicatorPaddingBottom(ef.d.b(10));
        ba();
        TabLayoutCompat tabLayoutCompat8 = this.mTabLayout;
        if (tabLayoutCompat8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        } else {
            tabLayoutCompat2 = tabLayoutCompat8;
        }
        tabLayoutCompat2.setViewPagerTabEventListener(new b());
    }
}
