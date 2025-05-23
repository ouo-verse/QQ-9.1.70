package com.qzone.reborn.groupalbum.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumTaskDetailInitBean;
import com.qzone.reborn.groupalbum.fragment.GroupAlbumDownloadQueueFragment;
import com.qzone.reborn.groupalbum.fragment.GroupAlbumPublishQueueFragment;
import com.qzone.reborn.groupalbum.fragment.GroupAlbumReshipQueueFragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\u0010\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0007H\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/x;", "Lcom/qzone/reborn/base/k;", "", "G9", "", "Landroidx/fragment/app/Fragment;", "D9", "Landroid/view/View;", "view", "I9", "H9", "E9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/qzone/reborn/base/o;", "d", "Lcom/qzone/reborn/base/o;", "mAdapter", "Lcom/tencent/mobileqq/widget/ViewPagerCompat;", "e", "Lcom/tencent/mobileqq/widget/ViewPagerCompat;", "mViewPager", "Lcom/tencent/mobileqq/widget/TabLayoutCompat;", "f", "Lcom/tencent/mobileqq/widget/TabLayoutCompat;", "mTabLayout", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "mIvBack", "", "i", "Ljava/util/List;", "mTitles", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumTaskDetailInitBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumTaskDetailInitBean;", "mInitBean", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class x extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.base.o mAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewPagerCompat mViewPager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TabLayoutCompat mTabLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mIvBack;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private List<String> mTitles;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private GroupAlbumTaskDetailInitBean mInitBean;

    public x() {
        List<String> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("\u4e0a\u4f20", "\u4e0b\u8f7d", "\u8f6c\u8f7d");
        this.mTitles = mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(x this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void G9() {
        Integer tabId;
        List<Fragment> D9 = D9();
        com.qzone.reborn.base.o oVar = this.mAdapter;
        ViewPagerCompat viewPagerCompat = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            oVar = null;
        }
        oVar.f(D9, this.mTitles);
        GroupAlbumTaskDetailInitBean groupAlbumTaskDetailInitBean = this.mInitBean;
        int intValue = (groupAlbumTaskDetailInitBean == null || (tabId = groupAlbumTaskDetailInitBean.getTabId()) == null) ? 0 : tabId.intValue();
        ViewPagerCompat viewPagerCompat2 = this.mViewPager;
        if (viewPagerCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        } else {
            viewPagerCompat = viewPagerCompat2;
        }
        if (intValue < 0 || intValue >= D9.size()) {
            intValue = 0;
        }
        viewPagerCompat.setCurrentItem(intValue, false);
    }

    private final void I9(View view) {
        FragmentManager parentFragmentManager = getHostFragment().getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "hostFragment.parentFragmentManager");
        this.mAdapter = new com.qzone.reborn.base.o(parentFragmentManager);
        View findViewById = view.findViewById(R.id.f162891n61);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.q\u2026e_task_detail_view_pager)");
        ViewPagerCompat viewPagerCompat = (ViewPagerCompat) findViewById;
        this.mViewPager = viewPagerCompat;
        com.qzone.reborn.base.o oVar = null;
        if (viewPagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPagerCompat = null;
        }
        viewPagerCompat.setScrollable(false);
        ViewPagerCompat viewPagerCompat2 = this.mViewPager;
        if (viewPagerCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPagerCompat2 = null;
        }
        com.qzone.reborn.base.o oVar2 = this.mAdapter;
        if (oVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            oVar = oVar2;
        }
        viewPagerCompat2.setAdapter(oVar);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        E9(rootView);
        I9(rootView);
        H9(rootView);
        G9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        super.onPartCreate(activity, savedInstanceState);
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
        this.mInitBean = serializableExtra instanceof GroupAlbumTaskDetailInitBean ? (GroupAlbumTaskDetailInitBean) serializableExtra : null;
    }

    private final List<Fragment> D9() {
        List<Fragment> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new GroupAlbumPublishQueueFragment(), new GroupAlbumDownloadQueueFragment(), new GroupAlbumReshipQueueFragment());
        return mutableListOf;
    }

    private final void E9(View view) {
        View findViewById = view.findViewById(R.id.f162890n60);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.q\u2026e_task_detail_title_back)");
        ImageView imageView = (ImageView) findViewById;
        this.mIvBack = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvBack");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                x.F9(x.this, view2);
            }
        });
    }

    private final void H9(View view) {
        View findViewById = view.findViewById(R.id.n5z);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.q\u2026e_task_detail_tab_layout)");
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
        tabLayoutCompat3.setRequestedTabMinWidth(ef.d.b(80));
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
        tabLayoutCompat5.setSelectedTabIndicatorHeight(ef.d.b(3));
        TabLayoutCompat tabLayoutCompat6 = this.mTabLayout;
        if (tabLayoutCompat6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat6 = null;
        }
        tabLayoutCompat6.setSelectedTabIndicatorPaddingLeft(ef.d.b(20));
        TabLayoutCompat tabLayoutCompat7 = this.mTabLayout;
        if (tabLayoutCompat7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat7 = null;
        }
        tabLayoutCompat7.setSelectedTabIndicatorPaddingRight(ef.d.b(20));
        TabLayoutCompat tabLayoutCompat8 = this.mTabLayout;
        if (tabLayoutCompat8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat8 = null;
        }
        tabLayoutCompat8.setSelectedTabIndicatorPaddingBottom(ef.d.b(10));
        TabLayoutCompat tabLayoutCompat9 = this.mTabLayout;
        if (tabLayoutCompat9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat9 = null;
        }
        tabLayoutCompat9.setTabTextSize(ef.d.d(16));
        Activity activity = getActivity();
        if (activity != null) {
            TabLayoutCompat tabLayoutCompat10 = this.mTabLayout;
            if (tabLayoutCompat10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
                tabLayoutCompat10 = null;
            }
            tabLayoutCompat10.setSelectedTabIndicatorColor(activity.getColor(R.color.qui_common_brand_standard));
            TabLayoutCompat tabLayoutCompat11 = this.mTabLayout;
            if (tabLayoutCompat11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            } else {
                tabLayoutCompat2 = tabLayoutCompat11;
            }
            tabLayoutCompat2.setTabTextColors(activity.getColor(R.color.qui_common_text_primary), activity.getColor(R.color.qui_common_brand_standard));
        }
    }
}
