package com.tencent.richframework.gallery.part;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.tencent.richframework.gallery.adapter.RFWLayerGalleryAdapter;
import com.tencent.richframework.gallery.bean.RFWLayerInitBean;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider;
import com.tencent.richframework.gallery.item.delegate.RFWLayerCardItemDelegate;
import com.tencent.richframework.gallery.item.delegate.RFWLayerFallbackItemDelegate;
import com.tencent.richframework.gallery.viewmodel.RFWLayerViewModel;
import com.tencent.richframework.gallery.widget.OffsetPageSnapHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0016\u0010\u001e\u001a\u00020\u00112\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/richframework/gallery/part/RFWCardPagePart;", "Lcom/tencent/biz/richframework/part/Part;", "()V", "adapter", "Lcom/tencent/richframework/gallery/adapter/RFWLayerGalleryAdapter;", "mCurrentSelectedPos", "", "mDataList", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mLayerViewModel", "Lcom/tencent/richframework/gallery/viewmodel/RFWLayerViewModel;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getLogTag", "", "initBanner", "", "initPageBean", "onConfigurationChanged", "configuration", "Landroid/content/res/Configuration;", "onInitView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "onPartCreate", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "setAdapterDataAndPosition", "layerInfoUIStateData", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "Companion", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWCardPagePart extends Part {
    private RFWLayerGalleryAdapter adapter;
    private int mCurrentSelectedPos = Integer.MIN_VALUE;
    private List<? extends RFWLayerItemMediaInfo> mDataList;
    private RFWLayerViewModel mLayerViewModel;
    private RecyclerView recyclerView;

    public static final /* synthetic */ RFWLayerGalleryAdapter access$getAdapter$p(RFWCardPagePart rFWCardPagePart) {
        RFWLayerGalleryAdapter rFWLayerGalleryAdapter = rFWCardPagePart.adapter;
        if (rFWLayerGalleryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return rFWLayerGalleryAdapter;
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
        if (sectionProvider != null) {
            list = sectionProvider.getExtPicSections();
        } else {
            list = null;
        }
        adapterDelegatesManager.addDelegate(new RFWLayerCardItemDelegate(list));
        adapterDelegatesManager.addDelegate(new RFWLayerFallbackItemDelegate());
        RFWLayerGalleryAdapter rFWLayerGalleryAdapter = new RFWLayerGalleryAdapter(adapterDelegatesManager);
        this.adapter = rFWLayerGalleryAdapter;
        rFWLayerGalleryAdapter.setHasStableIds(true);
        RFWLayerGalleryAdapter rFWLayerGalleryAdapter2 = this.adapter;
        if (rFWLayerGalleryAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        rFWLayerGalleryAdapter2.setEnableLoop(false);
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[1];
        RFWLayerGalleryAdapter rFWLayerGalleryAdapter3 = this.adapter;
        if (rFWLayerGalleryAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        adapterArr[0] = rFWLayerGalleryAdapter3;
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        linearLayoutManager.setInitialPrefetchItemCount(2);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        final OffsetPageSnapHelper offsetPageSnapHelper = new OffsetPageSnapHelper((int) ((ImmersiveUtils.getScreenWidth() * 0.157f) / 4));
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        offsetPageSnapHelper.attachToRecyclerView(recyclerView2);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView3.setAdapter(rFWConcatAdapter);
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView4.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.tencent.richframework.gallery.part.RFWCardPagePart$initBanner$2
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect outRect, int itemPosition, @NotNull RecyclerView parent) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(parent, "parent");
                if (itemPosition == 0) {
                    outRect.left = (int) (ImmersiveUtils.getScreenWidth() * 0.157f);
                } else {
                    outRect.left = (int) ((ImmersiveUtils.getScreenWidth() * 0.157f) / 2);
                }
                if (itemPosition == RFWCardPagePart.access$getAdapter$p(RFWCardPagePart.this).getNUM_BACKGOURND_ICON() - 1) {
                    outRect.right = (int) (ImmersiveUtils.getScreenWidth() * 0.157f);
                }
            }
        });
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView5.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.richframework.gallery.part.RFWCardPagePart$initBanner$3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull @NotNull RecyclerView recyclerView6, int newState) {
                View findSnapView;
                int i3;
                List<RFWLayerItemMediaInfo> list2;
                int i16;
                Intrinsics.checkNotNullParameter(recyclerView6, "recyclerView");
                super.onScrollStateChanged(recyclerView6, newState);
                if (newState == 0 && (findSnapView = offsetPageSnapHelper.findSnapView(linearLayoutManager)) != null) {
                    Intrinsics.checkNotNullExpressionValue(findSnapView, "snapHelper.findSnapView(layoutManager) ?: return");
                    int position = linearLayoutManager.getPosition(findSnapView);
                    RFWLog.i("RFWCardPagePart", RFWLog.USR, "pageChangePosition:" + position);
                    if (position >= 0) {
                        i3 = RFWCardPagePart.this.mCurrentSelectedPos;
                        if (i3 != position) {
                            RFWCardPagePart.this.mCurrentSelectedPos = position;
                            UIStateData<RFWLayerState> value = ((RFWLayerViewModel) RFWCardPagePart.this.getViewModel(RFWLayerViewModel.class)).mRichMediaInfo.getValue();
                            Intrinsics.checkNotNull(value);
                            Intrinsics.checkNotNullExpressionValue(value, "getViewModel(\n          \u2026 ).mRichMediaInfo.value!!");
                            UIStateData<RFWLayerState> uIStateData = value;
                            RFWLayerState data = uIStateData.getData();
                            if (data != null) {
                                list2 = data.getRichMediaDataList();
                            } else {
                                list2 = null;
                            }
                            if (list2 != null) {
                                data.setSelectedPosition(position);
                                uIStateData.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainSelectedPositionChanged(position));
                                ((RFWLayerViewModel) RFWCardPagePart.this.getViewModel(RFWLayerViewModel.class)).mRichMediaInfo.setValue(uIStateData);
                                return;
                            }
                            return;
                        }
                        int i17 = RFWLog.USR;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("is same position :");
                        i16 = RFWCardPagePart.this.mCurrentSelectedPos;
                        sb5.append(i16);
                        sb5.append(TokenParser.SP);
                        RFWLog.e("RFWCardPagePart", i17, sb5.toString());
                        return;
                    }
                    RFWLog.e("RFWCardPagePart", RFWLog.USR, "onPageSelected error position :" + position);
                }
            }
        });
        RFWLayerViewModel rFWLayerViewModel = this.mLayerViewModel;
        Intrinsics.checkNotNull(rFWLayerViewModel);
        MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData = rFWLayerViewModel.mRichMediaInfo;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
        mutableLiveData.observe(partHost.getLifecycleOwner(), new Observer<UIStateData<RFWLayerState>>() { // from class: com.tencent.richframework.gallery.part.RFWCardPagePart$initBanner$4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(@NotNull UIStateData<RFWLayerState> layerInfoUIStateData) {
                Intrinsics.checkNotNullParameter(layerInfoUIStateData, "layerInfoUIStateData");
                if (layerInfoUIStateData.getLatestModifyRecord() != null) {
                    UIStateData.ModifyListRecord latestModifyRecord = layerInfoUIStateData.getLatestModifyRecord();
                    Intrinsics.checkNotNullExpressionValue(latestModifyRecord, "layerInfoUIStateData.latestModifyRecord");
                    if (latestModifyRecord.getModifyType() == 4) {
                        return;
                    }
                }
                RFWCardPagePart.this.setAdapterDataAndPosition(layerInfoUIStateData);
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
            Intrinsics.checkNotNull(rFWLayerViewModel);
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
            RFWLayerGalleryAdapter rFWLayerGalleryAdapter = this.adapter;
            if (rFWLayerGalleryAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            rFWLayerGalleryAdapter.setItems(data.getRichMediaDataList());
            RFWLayerGalleryAdapter rFWLayerGalleryAdapter2 = this.adapter;
            if (rFWLayerGalleryAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            rFWLayerGalleryAdapter2.notifyDataSetChanged();
            RFWLog.e(getTAG(), RFWLog.USR, "notifyDataSetChanged");
            RFWLayerState data2 = layerInfoUIStateData.getData();
            Intrinsics.checkNotNull(data2);
            if (data2.getSelectedPosition() < 0) {
                RFWLog.e(getTAG(), RFWLog.USR, "error new position:");
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "RFWCardPagePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        RecyclerView recyclerView = new RecyclerView(getContext());
        this.recyclerView = recyclerView;
        recyclerView.setId(R.id.vh_);
        ViewGroup viewGroup = (ViewGroup) rootView;
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        viewGroup.addView(recyclerView2);
        initBanner();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        this.mLayerViewModel = (RFWLayerViewModel) getViewModel(RFWLayerViewModel.class);
        initPageBean();
    }
}
