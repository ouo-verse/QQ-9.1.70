package com.tencent.richframework.gallery.part;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.adapter.RFWBaseLayerAdapter;
import com.tencent.richframework.gallery.adapter.RFWLayerGalleryAdapter;
import com.tencent.richframework.gallery.bean.RFWLayerInitBean;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.inner.IGalleryPageProvider;
import com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider;
import com.tencent.richframework.gallery.item.delegate.RFWLayerFallbackItemDelegate;
import com.tencent.richframework.gallery.item.delegate.RFWLayerPicItemDelegate;
import com.tencent.richframework.gallery.item.delegate.RFWLayerVideoItemDelegate;
import com.tencent.richframework.gallery.viewmodel.RFWLayerViewModel;
import com.tencent.richframework.gallery.widget.RFWGalleryViewPager;
import com.tencent.richframework.widget.drag.RFWDragLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u0012\u0010 \u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%H\u0016J\u001a\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0016\u0010+\u001a\u00020\u001e2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/tencent/richframework/gallery/part/RFWLayerPagePart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/richframework/gallery/delegate/inner/IGalleryPageProvider;", "()V", "dragLayout", "Lcom/tencent/richframework/widget/drag/RFWDragLayout;", "getDragLayout", "()Lcom/tencent/richframework/widget/drag/RFWDragLayout;", "galleryViewPager", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", "getGalleryViewPager", "()Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", "mBannerAdapter", "Lcom/tencent/richframework/gallery/adapter/RFWLayerGalleryAdapter;", "mCurrentSelectedPos", "", "mDataList", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mDragLayout", "mGalleryPage", "mLayerViewModel", "Lcom/tencent/richframework/gallery/viewmodel/RFWLayerViewModel;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getLogTag", "", "initBanner", "", "initPageBean", "onConfigurationChanged", "configuration", "Landroid/content/res/Configuration;", "onInitView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "onPartCreate", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "setAdapterDataAndPosition", "layerInfoUIStateData", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "Companion", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerPagePart extends Part implements IGalleryPageProvider {
    private RFWLayerGalleryAdapter mBannerAdapter;
    private int mCurrentSelectedPos = Integer.MIN_VALUE;
    private List<? extends RFWLayerItemMediaInfo> mDataList;
    private RFWDragLayout mDragLayout;
    private RFWGalleryViewPager mGalleryPage;
    private RFWLayerViewModel mLayerViewModel;
    private RecyclerView recyclerView;
    private ViewPager2 viewPager;

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(RFWLayerPagePart rFWLayerPagePart) {
        RecyclerView recyclerView = rFWLayerPagePart.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
    }

    public static final /* synthetic */ ViewPager2 access$getViewPager$p(RFWLayerPagePart rFWLayerPagePart) {
        ViewPager2 viewPager2 = rFWLayerPagePart.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        return viewPager2;
    }

    private final void initBanner() {
        List<Class<? extends Section<RFWLayerItemMediaInfo>>> list;
        List<AdapterDelegate<List<RFWLayerItemMediaInfo>>> extDelegates;
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        IDelegateAndSectionProvider sectionProvider = RFWLayerIOCUtil.getSectionProvider(rootView);
        AdapterDelegatesManager adapterDelegatesManager = new AdapterDelegatesManager();
        if (sectionProvider != null && (extDelegates = sectionProvider.getExtDelegates()) != null) {
            Iterator<T> it = extDelegates.iterator();
            while (it.hasNext()) {
                adapterDelegatesManager.addDelegate((AdapterDelegate) it.next());
            }
        }
        List<Class<? extends Section<RFWLayerItemMediaInfo>>> list2 = null;
        if (sectionProvider != null) {
            list = sectionProvider.getExtPicSections();
        } else {
            list = null;
        }
        adapterDelegatesManager.addDelegate(new RFWLayerPicItemDelegate(list));
        if (sectionProvider != null) {
            list2 = sectionProvider.getExtVideoSections();
        }
        adapterDelegatesManager.addDelegate(new RFWLayerVideoItemDelegate(list2));
        adapterDelegatesManager.addDelegate(new RFWLayerFallbackItemDelegate());
        RFWLayerGalleryAdapter rFWLayerGalleryAdapter = new RFWLayerGalleryAdapter(adapterDelegatesManager);
        this.mBannerAdapter = rFWLayerGalleryAdapter;
        rFWLayerGalleryAdapter.setHasStableIds(true);
        RFWLayerGalleryAdapter rFWLayerGalleryAdapter2 = this.mBannerAdapter;
        if (rFWLayerGalleryAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBannerAdapter");
        }
        rFWLayerGalleryAdapter2.setEnableLoop(false);
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[1];
        RFWLayerGalleryAdapter rFWLayerGalleryAdapter3 = this.mBannerAdapter;
        if (rFWLayerGalleryAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBannerAdapter");
        }
        adapterArr[0] = rFWLayerGalleryAdapter3;
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager2.setOffscreenPageLimit(2);
        ViewPager2 viewPager22 = this.viewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager22.setAdapter(rFWConcatAdapter);
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager23.setPageTransformer(new MarginPageTransformer(ImmersiveUtils.dpToPx(8.0f)));
        ViewPager2 viewPager24 = this.viewPager;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager24.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.tencent.richframework.gallery.part.RFWLayerPagePart$initBanner$2
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                List<RFWLayerItemMediaInfo> list3;
                super.onPageSelected(position);
                RFWLog.i("RFWLayerPagePart", RFWLog.USR, "pageChangePosition:" + position);
                if (position >= 0) {
                    RFWLayerPagePart.this.mCurrentSelectedPos = position;
                    UIStateData<RFWLayerState> value = ((RFWLayerViewModel) RFWLayerPagePart.this.getViewModel(RFWLayerViewModel.class)).mRichMediaInfo.getValue();
                    Intrinsics.checkNotNull(value);
                    Intrinsics.checkNotNullExpressionValue(value, "getViewModel(\n          \u2026 ).mRichMediaInfo.value!!");
                    UIStateData<RFWLayerState> uIStateData = value;
                    RFWLayerState data = uIStateData.getData();
                    if (data != null) {
                        list3 = data.getRichMediaDataList();
                    } else {
                        list3 = null;
                    }
                    if (list3 != null) {
                        data.setSelectedPosition(position);
                        uIStateData.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainSelectedPositionChanged(position));
                        ((RFWLayerViewModel) RFWLayerPagePart.this.getViewModel(RFWLayerViewModel.class)).mRichMediaInfo.setValue(uIStateData);
                        return;
                    }
                    return;
                }
                RFWLog.e("RFWLayerPagePart", RFWLog.USR, "onPageSelected position :" + position);
            }
        });
        RFWLayerViewModel rFWLayerViewModel = this.mLayerViewModel;
        if (rFWLayerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayerViewModel");
        }
        MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData = rFWLayerViewModel.mRichMediaInfo;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
        mutableLiveData.observe(partHost.getLifecycleOwner(), new Observer<UIStateData<RFWLayerState>>() { // from class: com.tencent.richframework.gallery.part.RFWLayerPagePart$initBanner$3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(@NotNull final UIStateData<RFWLayerState> layerInfoUIStateData) {
                RecyclerView recyclerView;
                Intrinsics.checkNotNullParameter(layerInfoUIStateData, "layerInfoUIStateData");
                if (layerInfoUIStateData.getLatestModifyRecord() != null) {
                    UIStateData.ModifyListRecord latestModifyRecord = layerInfoUIStateData.getLatestModifyRecord();
                    Intrinsics.checkNotNullExpressionValue(latestModifyRecord, "layerInfoUIStateData.latestModifyRecord");
                    if (latestModifyRecord.getModifyType() == 4) {
                        if (layerInfoUIStateData.getData().getSelectedPosition() < 0 || RFWLayerPagePart.access$getViewPager$p(RFWLayerPagePart.this).getCurrentItem() == layerInfoUIStateData.getData().getSelectedPosition()) {
                            return;
                        }
                        RFWLayerPagePart.access$getViewPager$p(RFWLayerPagePart.this).setCurrentItem(layerInfoUIStateData.getData().getSelectedPosition(), false);
                        return;
                    }
                }
                if (RFWLayerPagePart.access$getRecyclerView$p(RFWLayerPagePart.this).getScrollState() == 0) {
                    String tag = RFWLayerPagePart.this.getTAG();
                    int i3 = RFWLog.USR;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("update adapter ");
                    sb5.append(RFWLayerPagePart.access$getViewPager$p(RFWLayerPagePart.this).getAdapter());
                    sb5.append(" scrollState:");
                    RFWBaseLayerAdapter<?> adapter = RFWLayerPagePart.this.getGalleryViewPager().getAdapter();
                    sb5.append((adapter == null || (recyclerView = adapter.getRecyclerView()) == null) ? null : Integer.valueOf(recyclerView.getScrollState()));
                    RFWLog.i(tag, i3, sb5.toString());
                    RFWLayerPagePart.this.setAdapterDataAndPosition(layerInfoUIStateData);
                    return;
                }
                RFWLog.i(RFWLayerPagePart.this.getTAG(), RFWLog.USR, "update add scrollListener");
                RFWLayerPagePart.access$getRecyclerView$p(RFWLayerPagePart.this).addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.richframework.gallery.part.RFWLayerPagePart$initBanner$3.1
                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrollStateChanged(@NotNull RecyclerView recyclerView2, int newState) {
                        RecyclerView recyclerView3;
                        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                        super.onScrollStateChanged(recyclerView2, newState);
                        if (newState == 0) {
                            RFWLog.i(RFWLayerPagePart.this.getTAG(), RFWLog.USR, "update onScrollStateChanged idle setAdapterDataAndPosition");
                            RFWBaseLayerAdapter<?> adapter2 = RFWLayerPagePart.this.getGalleryViewPager().getAdapter();
                            if (adapter2 != null && (recyclerView3 = adapter2.getRecyclerView()) != null) {
                                recyclerView3.removeOnScrollListener(this);
                            }
                            RFWLog.i(RFWLayerPagePart.this.getTAG(), RFWLog.USR, "scroll is idle start setAdapterDataAndPosition");
                            RFWLayerPagePart.this.setAdapterDataAndPosition(layerInfoUIStateData);
                        }
                    }
                });
            }
        });
    }

    private final void initPageBean() {
        if (getActivity() == null) {
            RFWLog.e(getTAG(), RFWLog.USR, "getActivity is null");
            return;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Intent intent = activity.getIntent();
        if (intent == null) {
            RFWLog.e(getTAG(), RFWLog.USR, "intent is null");
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra(RFWLaunchKey.KEY_INIT_BEAN);
        if (!(parcelableExtra instanceof RFWLayerInitBean)) {
            parcelableExtra = null;
        }
        RFWLayerInitBean rFWLayerInitBean = (RFWLayerInitBean) parcelableExtra;
        if (rFWLayerInitBean != null) {
            this.mDataList = rFWLayerInitBean.getRichMediaDataList();
            this.mCurrentSelectedPos = rFWLayerInitBean.getEnterPos();
            RFWLayerState rFWLayerState = new RFWLayerState();
            rFWLayerState.setRichMediaDataList(this.mDataList);
            rFWLayerState.setSelectedPosition(this.mCurrentSelectedPos);
            UIStateData obtainSuccess = UIStateData.obtainSuccess(true);
            RFWLayerViewModel rFWLayerViewModel = this.mLayerViewModel;
            if (rFWLayerViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLayerViewModel");
            }
            rFWLayerViewModel.mRichMediaInfo.setValue(obtainSuccess.setDataList(rFWLayerState));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NotifyDataSetChanged"})
    public final void setAdapterDataAndPosition(UIStateData<RFWLayerState> layerInfoUIStateData) {
        if (layerInfoUIStateData.getData() == null) {
            RFWLog.e(getTAG(), RFWLog.USR, "error data");
            return;
        }
        RFWLayerState data = layerInfoUIStateData.getData();
        if (data != null) {
            RFWLayerGalleryAdapter rFWLayerGalleryAdapter = this.mBannerAdapter;
            if (rFWLayerGalleryAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBannerAdapter");
            }
            rFWLayerGalleryAdapter.setItems(data.getRichMediaDataList());
            RFWLayerGalleryAdapter rFWLayerGalleryAdapter2 = this.mBannerAdapter;
            if (rFWLayerGalleryAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBannerAdapter");
            }
            rFWLayerGalleryAdapter2.notifyDataSetChanged();
            RFWLog.e(getTAG(), RFWLog.USR, "notifyDataSetChanged");
            RFWLayerState data2 = layerInfoUIStateData.getData();
            Intrinsics.checkNotNull(data2);
            if (data2.getSelectedPosition() >= 0) {
                ViewPager2 viewPager2 = this.viewPager;
                if (viewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                }
                viewPager2.setCurrentItem(data.getSelectedPosition(), false);
                return;
            }
            RFWLog.e(getTAG(), RFWLog.USR, "error new position:");
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.inner.IGalleryPageProvider
    @NotNull
    public RFWDragLayout getDragLayout() {
        RFWDragLayout rFWDragLayout = this.mDragLayout;
        if (rFWDragLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
        }
        return rFWDragLayout;
    }

    @Override // com.tencent.richframework.gallery.delegate.inner.IGalleryPageProvider
    @NotNull
    public RFWGalleryViewPager getGalleryViewPager() {
        RFWGalleryViewPager rFWGalleryViewPager = this.mGalleryPage;
        if (rFWGalleryViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGalleryPage");
        }
        return rFWGalleryViewPager;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "RFWLayerPagePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i3 = this.mCurrentSelectedPos;
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        RecyclerView.Adapter adapter = viewPager2.getAdapter();
        ViewPager2 viewPager22 = this.viewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager22.setAdapter(adapter);
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager23.setCurrentItem(i3, false);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        rootView.setBackground(new ColorDrawable(-16777216));
        ViewGroup viewGroup = (ViewGroup) rootView;
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.hna, viewGroup, false);
        if (inflate != null) {
            RFWDragLayout rFWDragLayout = (RFWDragLayout) inflate;
            this.mDragLayout = rFWDragLayout;
            View findViewById = rFWDragLayout.findViewById(R.id.f73943ux);
            Intrinsics.checkNotNullExpressionValue(findViewById, "mDragLayout.findViewById(R.id.rfw_image_banner)");
            this.mGalleryPage = (RFWGalleryViewPager) findViewById;
            RFWDragLayout rFWDragLayout2 = this.mDragLayout;
            if (rFWDragLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
            }
            rFWDragLayout2.setEnableChangeWindowBg(false);
            RFWGalleryViewPager rFWGalleryViewPager = this.mGalleryPage;
            if (rFWGalleryViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGalleryPage");
            }
            ViewPager2 viewPager2 = rFWGalleryViewPager.getViewPager2();
            this.viewPager = viewPager2;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            }
            View childAt = viewPager2.getChildAt(0);
            if (childAt != null) {
                this.recyclerView = (RecyclerView) childAt;
                RFWDragLayout rFWDragLayout3 = this.mDragLayout;
                if (rFWDragLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
                }
                viewGroup.addView(rFWDragLayout3);
                RFWLayerIOCUtil.registerGalleryPageProvider(rootView, this);
                initBanner();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.richframework.widget.drag.RFWDragLayout");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        ViewModel viewModel = getViewModel(RFWLayerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(RFWLayerViewModel::class.java)");
        this.mLayerViewModel = (RFWLayerViewModel) viewModel;
        initPageBean();
    }
}
