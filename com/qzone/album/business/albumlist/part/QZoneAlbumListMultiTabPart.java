package com.qzone.album.business.albumlist.part;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.business.albumlist.fragment.AlbumListTabFragment;
import com.qzone.album.business.albumlist.fragment.AlbumMultiTabFragment;
import com.qzone.album.business.albumlist.fragment.d;
import com.qzone.album.business.albumlist.fragment.e;
import com.qzone.reborn.base.k;
import com.qzone.reborn.base.o;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.intimate.bean.QZoneAlbumInfoBean;
import com.qzone.reborn.intimate.fragment.QZoneAlbumIntimateTabFragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat;
import com.tencent.biz.qqcircle.richframework.widget.ViewPagerCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nk.r;
import tl.h;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001OB\u0007\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001e\u0010\t\u001a\u00020\u00032\u0014\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005H\u0002J\u001e\u0010\n\u001a\u00020\u00032\u0014\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u0006\u0010\u0017\u001a\u00020\u0003J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J \u0010!\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u0004\u0018\u00010\rJ\b\u0010#\u001a\u00020\u0003H\u0016R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001c\u00107\u001a\b\u0012\u0004\u0012\u0002040\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010H\u00a8\u0006P"}, d2 = {"Lcom/qzone/album/business/albumlist/part/QZoneAlbumListMultiTabPart;", "Lcom/qzone/reborn/base/k;", "Lcom/qzone/album/business/albumlist/fragment/d;", "", "initViewModel", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/intimate/bean/QZoneAlbumInfoBean;", "listUIStateData", "I9", "J9", "L9", "K9", "Landroidx/fragment/app/Fragment;", "G9", "Landroid/view/View;", "view", "O9", "M9", "R9", "Q9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "P9", "update", "", "counter", "", "I6", "fragment", "isSelected", "Lcom/qzone/album/business/albumlist/fragment/e;", "ioc", "Y4", "H9", "onWindowFocusChanged", "Lcom/qzone/reborn/base/o;", "d", "Lcom/qzone/reborn/base/o;", "mAdapter", "Lcom/tencent/biz/qqcircle/richframework/widget/ViewPagerCompat;", "e", "Lcom/tencent/biz/qqcircle/richframework/widget/ViewPagerCompat;", "mViewPager", "Lcom/tencent/biz/qqcircle/richframework/widget/TabLayoutCompat;", "f", "Lcom/tencent/biz/qqcircle/richframework/widget/TabLayoutCompat;", "mTabLayout", "Lnk/r;", h.F, "Lnk/r;", "mAlbumViewModel", "", "i", "Ljava/util/List;", "mTitles", "Lcom/qzone/album/business/albumlist/fragment/AlbumListTabFragment;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/album/business/albumlist/fragment/AlbumListTabFragment;", "mQZoneAlbumListTabFrag", "Lcom/qzone/reborn/intimate/fragment/QZoneAlbumIntimateTabFragment;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/intimate/fragment/QZoneAlbumIntimateTabFragment;", "mQZoneAlbumIntimateTabFrag", "D", "Lcom/qzone/album/business/albumlist/fragment/e;", "mAlbumTitleTabChangeIoc", "", "E", "I", "mCurShowTabIndex", UserInfo.SEX_FEMALE, "Z", "mCurFragVisible", "G", "mHasInit", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class QZoneAlbumListMultiTabPart extends k implements d {
    private static final String I = "QZoneAlbumListMultiTabPart";

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneAlbumIntimateTabFragment mQZoneAlbumIntimateTabFrag;

    /* renamed from: D, reason: from kotlin metadata */
    private e mAlbumTitleTabChangeIoc;

    /* renamed from: E, reason: from kotlin metadata */
    private int mCurShowTabIndex;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mCurFragVisible;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mHasInit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private o mAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewPagerCompat mViewPager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TabLayoutCompat mTabLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private r mAlbumViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private List<String> mTitles;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private AlbumListTabFragment mQZoneAlbumListTabFrag;

    public QZoneAlbumListMultiTabPart() {
        List<String> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("\u7a7a\u95f4\u76f8\u518c", "\u5bc6\u53cb\u76f8\u518c");
        this.mTitles = mutableListOf;
        this.mQZoneAlbumListTabFrag = new AlbumListTabFragment();
        this.mCurFragVisible = true;
    }

    private final List<Fragment> G9() {
        List<Fragment> mutableListOf;
        List<Fragment> mutableListOf2;
        QZoneAlbumIntimateTabFragment qZoneAlbumIntimateTabFragment = this.mQZoneAlbumIntimateTabFrag;
        if (qZoneAlbumIntimateTabFragment == null) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(this.mQZoneAlbumListTabFrag);
            return mutableListOf;
        }
        Intrinsics.checkNotNull(qZoneAlbumIntimateTabFragment);
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(this.mQZoneAlbumListTabFrag, qZoneAlbumIntimateTabFragment);
        return mutableListOf2;
    }

    private final void K9() {
        o oVar = this.mAdapter;
        r rVar = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            oVar = null;
        }
        oVar.f(G9(), this.mTitles);
        ViewPagerCompat viewPagerCompat = this.mViewPager;
        if (viewPagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPagerCompat = null;
        }
        viewPagerCompat.setCurrentItem(0, false);
        if (g.f53821a.h().l()) {
            r rVar2 = this.mAlbumViewModel;
            if (rVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            } else {
                rVar = rVar2;
            }
            rVar.U1();
        }
    }

    private final void L9() {
        if (this.mQZoneAlbumIntimateTabFrag == null) {
            this.mQZoneAlbumIntimateTabFrag = new QZoneAlbumIntimateTabFragment();
        }
    }

    private final void M9() {
        Activity activity = getActivity();
        if (activity != null) {
            View findViewById = getActivity().findViewById(R.id.f164269sl3);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
            TabLayoutCompat tabLayoutCompat = (TabLayoutCompat) ((ViewStub) findViewById).inflate().findViewById(R.id.xpr);
            if (tabLayoutCompat == null) {
                return;
            }
            this.mTabLayout = tabLayoutCompat;
            ViewPagerCompat viewPagerCompat = this.mViewPager;
            if (viewPagerCompat == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                viewPagerCompat = null;
            }
            tabLayoutCompat.setupWithViewPager(viewPagerCompat);
            TabLayoutCompat tabLayoutCompat2 = this.mTabLayout;
            if (tabLayoutCompat2 != null) {
                tabLayoutCompat2.setRequestedTabMinWidth(ef.d.b(120));
            }
            TabLayoutCompat tabLayoutCompat3 = this.mTabLayout;
            if (tabLayoutCompat3 != null) {
                tabLayoutCompat3.setTabMode(1);
            }
            TabLayoutCompat tabLayoutCompat4 = this.mTabLayout;
            if (tabLayoutCompat4 != null) {
                tabLayoutCompat4.setSelectedIndicatorNoShadowLayer();
            }
            TabLayoutCompat tabLayoutCompat5 = this.mTabLayout;
            if (tabLayoutCompat5 != null) {
                tabLayoutCompat5.setSelectedTabIndicatorHeight(ef.d.b(2));
            }
            TabLayoutCompat tabLayoutCompat6 = this.mTabLayout;
            if (tabLayoutCompat6 != null) {
                tabLayoutCompat6.setSelectedTabIndicatorWidth(ef.d.b(64));
            }
            TabLayoutCompat tabLayoutCompat7 = this.mTabLayout;
            if (tabLayoutCompat7 != null) {
                tabLayoutCompat7.setSelectedTabIndicatorPaddingBottom(ef.d.b(10));
            }
            TabLayoutCompat tabLayoutCompat8 = this.mTabLayout;
            if (tabLayoutCompat8 != null) {
                tabLayoutCompat8.setTabTextSize(ef.d.d(16));
            }
            TabLayoutCompat tabLayoutCompat9 = this.mTabLayout;
            if (tabLayoutCompat9 != null) {
                tabLayoutCompat9.setSelectedTabIndicatorColor(activity.getColor(R.color.qui_common_brand_standard));
            }
            TabLayoutCompat tabLayoutCompat10 = this.mTabLayout;
            if (tabLayoutCompat10 != null) {
                tabLayoutCompat10.setTabTextColors(activity.getColor(R.color.qui_common_text_primary), activity.getColor(R.color.qui_common_brand_standard));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void O9(View view) {
        FragmentManager childFragmentManager = getHostFragment().getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "hostFragment.childFragmentManager");
        this.mAdapter = new o(childFragmentManager);
        View findViewById = view.findViewById(R.id.mny);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.q\u2026ne_album_list_view_pager)");
        ViewPagerCompat viewPagerCompat = (ViewPagerCompat) findViewById;
        this.mViewPager = viewPagerCompat;
        o oVar = null;
        if (viewPagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPagerCompat = null;
        }
        viewPagerCompat.addOnPageChangeListener(new b());
        ViewPagerCompat viewPagerCompat2 = this.mViewPager;
        if (viewPagerCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPagerCompat2 = null;
        }
        o oVar2 = this.mAdapter;
        if (oVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            oVar = oVar2;
        }
        viewPagerCompat2.setAdapter(oVar);
    }

    private final void Q9() {
        Fragment H9 = H9();
        if (H9 != null) {
            if (Intrinsics.areEqual(H9, this.mQZoneAlbumListTabFrag)) {
                e eVar = this.mAlbumTitleTabChangeIoc;
                if (eVar != null) {
                    eVar.c(true);
                }
                e eVar2 = this.mAlbumTitleTabChangeIoc;
                if (eVar2 != null) {
                    eVar2.a(true);
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(H9, this.mQZoneAlbumIntimateTabFrag)) {
                e eVar3 = this.mAlbumTitleTabChangeIoc;
                if (eVar3 != null) {
                    eVar3.c(false);
                }
                e eVar4 = this.mAlbumTitleTabChangeIoc;
                if (eVar4 != null) {
                    eVar4.a(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9() {
        if (this.mHasInit) {
            if (this.mCurFragVisible) {
                o oVar = this.mAdapter;
                o oVar2 = null;
                if (oVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    oVar = null;
                }
                if (oVar.getF373114d() > 1) {
                    e eVar = this.mAlbumTitleTabChangeIoc;
                    if (eVar != null) {
                        eVar.d(false);
                    }
                    TabLayoutCompat tabLayoutCompat = this.mTabLayout;
                    if (tabLayoutCompat != null) {
                        tabLayoutCompat.setVisibility(0);
                    }
                    Q9();
                    return;
                }
                o oVar3 = this.mAdapter;
                if (oVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                } else {
                    oVar2 = oVar3;
                }
                if (oVar2.getF373114d() == 1) {
                    e eVar2 = this.mAlbumTitleTabChangeIoc;
                    if (eVar2 != null) {
                        eVar2.d(true);
                    }
                    TabLayoutCompat tabLayoutCompat2 = this.mTabLayout;
                    if (tabLayoutCompat2 == null) {
                        return;
                    }
                    tabLayoutCompat2.setVisibility(8);
                    return;
                }
                return;
            }
            e eVar3 = this.mAlbumTitleTabChangeIoc;
            if (eVar3 != null) {
                eVar3.d(true);
            }
            e eVar4 = this.mAlbumTitleTabChangeIoc;
            if (eVar4 != null) {
                eVar4.c(true);
            }
            e eVar5 = this.mAlbumTitleTabChangeIoc;
            if (eVar5 != null) {
                eVar5.a(true);
            }
            TabLayoutCompat tabLayoutCompat3 = this.mTabLayout;
            if (tabLayoutCompat3 == null) {
                return;
            }
            tabLayoutCompat3.setVisibility(8);
        }
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(r.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneAlbumI\u2026TabViewModel::class.java)");
        this.mAlbumViewModel = (r) viewModel;
        if (g.f53821a.h().l()) {
            r rVar = this.mAlbumViewModel;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                rVar = null;
            }
            MutableLiveData<UIStateData<List<QZoneAlbumInfoBean>>> O1 = rVar.O1();
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<UIStateData<List<QZoneAlbumInfoBean>>, Unit> function1 = new Function1<UIStateData<List<QZoneAlbumInfoBean>>, Unit>() { // from class: com.qzone.album.business.albumlist.part.QZoneAlbumListMultiTabPart$initViewModel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<QZoneAlbumInfoBean>> uIStateData) {
                    invoke2(uIStateData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(UIStateData<List<QZoneAlbumInfoBean>> uIStateData) {
                    QZoneAlbumListMultiTabPart.this.I9(uIStateData);
                }
            };
            O1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.album.business.albumlist.part.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZoneAlbumListMultiTabPart.N9(Function1.this, obj);
                }
            });
        }
    }

    public final Fragment H9() {
        int i3 = this.mCurShowTabIndex;
        o oVar = this.mAdapter;
        o oVar2 = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            oVar = null;
        }
        if (i3 >= oVar.getF373114d()) {
            return null;
        }
        o oVar3 = this.mAdapter;
        if (oVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            oVar2 = oVar3;
        }
        return oVar2.getItem(this.mCurShowTabIndex);
    }

    @Override // com.qzone.album.business.albumlist.fragment.d
    public boolean I6(long counter) {
        return false;
    }

    public final void P9() {
        Intent intent;
        Activity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        r rVar = this.mAlbumViewModel;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            rVar = null;
        }
        rVar.S1(intent);
    }

    @Override // com.qzone.album.business.albumlist.fragment.d
    public void Y4(Fragment fragment, boolean isSelected, e ioc) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(ioc, "ioc");
        this.mAlbumTitleTabChangeIoc = ioc;
        if (fragment instanceof AlbumMultiTabFragment) {
            this.mCurFragVisible = isSelected;
            R9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initViewModel();
        P9();
        O9(rootView);
        M9();
        this.mHasInit = true;
        K9();
    }

    private final void J9(UIStateData<List<QZoneAlbumInfoBean>> listUIStateData) {
        if (listUIStateData == null) {
            QLog.e(I, 1, "ui state data is null");
            return;
        }
        if (listUIStateData.getData() != null && listUIStateData.getData().size() > 0) {
            L9();
        }
        o oVar = this.mAdapter;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            oVar = null;
        }
        oVar.f(G9(), this.mTitles);
        R9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(UIStateData<List<QZoneAlbumInfoBean>> listUIStateData) {
        if (listUIStateData == null) {
            return;
        }
        int state = listUIStateData.getState();
        if (state != 2 && state != 3) {
            o oVar = this.mAdapter;
            if (oVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                oVar = null;
            }
            oVar.f(G9(), this.mTitles);
            R9();
            return;
        }
        J9(listUIStateData);
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/album/business/albumlist/part/QZoneAlbumListMultiTabPart$b", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            QZoneAlbumListMultiTabPart.this.mCurShowTabIndex = position;
            QZoneAlbumListMultiTabPart.this.R9();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.d
    public void onWindowFocusChanged() {
    }

    @Override // com.qzone.album.business.albumlist.fragment.d
    public void update() {
    }
}
