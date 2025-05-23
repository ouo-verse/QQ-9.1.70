package com.tencent.state.square.flower;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewbinding.ViewBinding;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.compat.f;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.service.ImageService;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.flower.data.FlowerDisplayData;
import com.tencent.state.square.flower.data.MedalData;
import com.tencent.state.square.flower.service.VasFlowerService;
import com.tencent.state.view.SquareImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import ne0.a;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 !*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004:\u0001!B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u0015\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u000bH\u0017J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/square/flower/FlowerBaseFragment;", "T", "Landroidx/viewbinding/ViewBinding;", "Lcom/tencent/state/square/flower/FloatPanelBaseFragment;", "Landroid/view/View$OnClickListener;", "()V", "bindHelperTips", "", "data", "Lcom/tencent/state/square/flower/data/FlowerDisplayData;", "createMedalHelpInfoView", "Landroid/view/View;", "medal", "Lcom/tencent/state/square/flower/data/MedalData;", "getExtraPageReportParams", "", "", "", "getPageId", "getPageInfo", "initFlowerRecordsEntry", "initReport", "root", "initSubView", "binding", "(Landroidx/viewbinding/ViewBinding;)V", NodeProps.ON_CLICK, "v", "onFlowerDataLoaded", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class FlowerBaseFragment<T extends ViewBinding> extends FloatPanelBaseFragment<T> implements View.OnClickListener {
    private static final String EM_ID_FLOWER_RECORDS = "em_zplan_flower_commemorate_book";
    public static final String FLOWER_RECORD_IMG_URL = "https://cdn.meta.qq.com/flower/record-button.webp";
    public static final String KEY_PAGE_SOURCE = "key_page_source_from";
    private static final String PAGE_ID = "pg_zplan_grow_flowers_half_screen";
    private static final String PAGE_PARAM_SOURCE = "zplan_flower_half_screen_source";
    public static final int PAGE_SOURCE_DETAIL_FLOWER = 3;
    public static final int PAGE_SOURCE_SQUARE_FLOWER = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindHelperTips(FlowerDisplayData data) {
        View mContainer;
        TableLayout tableLayout;
        List<List> chunked;
        T binding = getBinding();
        if (binding == null || (mContainer = binding.getMContainer()) == null || (tableLayout = (TableLayout) mContainer.findViewById(R.id.q8h)) == null) {
            return;
        }
        chunked = CollectionsKt___CollectionsKt.chunked(data.getMedalConfig(), 2);
        for (List list : chunked) {
            if (list.isEmpty()) {
                return;
            }
            TableRow tableRow = new TableRow(getContext());
            ArrayList<View> arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View createMedalHelpInfoView = createMedalHelpInfoView((MedalData) it.next());
                if (createMedalHelpInfoView != null) {
                    arrayList.add(createMedalHelpInfoView);
                }
            }
            for (View view : arrayList) {
                tableRow.addView(view);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(-2, -2);
                layoutParams.weight = 1.0f;
                layoutParams.bottomMargin = ViewExtensionsKt.dip(getContext(), 6);
                Unit unit = Unit.INSTANCE;
                view.setLayoutParams(layoutParams);
            }
            tableLayout.addView(tableRow);
            tableRow.setLayoutParams(new TableRow.LayoutParams(-1, -2));
        }
    }

    private final void getPageInfo() {
        VasFlowerService.INSTANCE.getFlowerDisplayInfo(new Function1<FlowerDisplayData, Unit>() { // from class: com.tencent.state.square.flower.FlowerBaseFragment$getPageInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FlowerDisplayData flowerDisplayData) {
                invoke2(flowerDisplayData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FlowerDisplayData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                FlowerBaseFragment.this.onFlowerDataLoaded(it);
                FlowerBaseFragment.this.bindHelperTips(it);
                FlowerBaseFragment.this.initFlowerRecordsEntry(it);
                SimpleEventBus.getInstance().dispatchEvent(new FlowerSyncEvent(SquareBaseKt.getSquareCommon().getCurrentAccountUin(), it.getFlowerTodayNum(), it.getMedal()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
    
        if ((!r1) != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void initFlowerRecordsEntry(final FlowerDisplayData data) {
        View mContainer;
        final SquareImageView squareImageView;
        boolean z16;
        boolean isBlank;
        T binding = getBinding();
        if (binding == null || (mContainer = binding.getMContainer()) == null || (squareImageView = (SquareImageView) mContainer.findViewById(R.id.f163388pv2)) == null) {
            return;
        }
        ImageService.Companion companion = ImageService.INSTANCE;
        ImageLoader loader = companion.getLoader();
        if (loader != null) {
            loader.displayImage(FLOWER_RECORD_IMG_URL, new ImageViewAware(squareImageView), companion.getUniqueImageOptions(FLOWER_RECORD_IMG_URL), null, null, null);
        }
        if (data.isShowFlowerRecordsEntry()) {
            isBlank = StringsKt__StringsJVMKt.isBlank(data.getFlowerRecordsEntryUrl());
            z16 = true;
        }
        z16 = false;
        com.tencent.state.ViewExtensionsKt.setVisibility(squareImageView, z16);
        if (z16) {
            SquareBaseKt.getSquareReporter().reportEvent("imp", squareImageView, new LinkedHashMap());
        }
        squareImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.flower.FlowerBaseFragment$initFlowerRecordsEntry$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    Fragment createHippyFragment = Square.INSTANCE.getConfig().getHippyEngine().createHippyFragment(new JSONObject(data.getFlowerRecordsEntryUrl()));
                    if (createHippyFragment != null) {
                        FlowerBaseFragment.this.getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.f154355jc, 0, R.anim.f154355jc, 0).add(R.id.pvw, createHippyFragment).commitAllowingStateLoss();
                    }
                } catch (Throwable th5) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), QBaseFragment.TAG, "open flower records page failed: " + th5.getMessage(), null, 4, null);
                }
                SquareBaseKt.getSquareReporter().reportEvent("clck", squareImageView, new LinkedHashMap());
            }
        });
    }

    private final void initReport(View root) {
        Map<String, Object> mutableMapOf;
        Bundle arguments = getArguments();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(PAGE_PARAM_SOURCE, Integer.valueOf(arguments != null ? arguments.getInt(KEY_PAGE_SOURCE) : 1)));
        mutableMapOf.putAll(getExtraPageReportParams());
        SquareBaseKt.getSquareReporter().setPageInfo(this, root, getPageId(), mutableMapOf);
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        View findViewById = root.findViewById(R.id.f163388pv2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.flower_records)");
        squareReporter.setElementInfo(findViewById, EM_ID_FLOWER_RECORDS, new LinkedHashMap(), false, false);
    }

    private final void initSubView(T binding) {
        View findViewById = binding.getMContainer().findViewById(R.id.puz);
        final View findViewById2 = binding.getMContainer().findViewById(R.id.pz9);
        final View findViewById3 = binding.getMContainer().findViewById(R.id.pz8);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.flower.FlowerBaseFragment$initSubView$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                View tips = findViewById2;
                Intrinsics.checkNotNullExpressionValue(tips, "tips");
                boolean z16 = !com.tencent.state.ViewExtensionsKt.isVisible(tips);
                View arrow = findViewById3;
                Intrinsics.checkNotNullExpressionValue(arrow, "arrow");
                com.tencent.state.ViewExtensionsKt.setVisibility(arrow, z16);
                View tips2 = findViewById2;
                Intrinsics.checkNotNullExpressionValue(tips2, "tips");
                com.tencent.state.ViewExtensionsKt.setVisibility(tips2, z16);
            }
        });
    }

    public Map<String, Object> getExtraPageReportParams() {
        return new LinkedHashMap();
    }

    @Override // com.tencent.state.VasBaseFragment
    public String getPageId() {
        return PAGE_ID;
    }

    @Override // com.tencent.state.square.flower.FloatPanelBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        View mContainer;
        View findViewById;
        View mContainer2;
        View findViewById2;
        Intrinsics.checkNotNullParameter(v3, "v");
        T binding = getBinding();
        if (binding != null && (mContainer2 = binding.getMContainer()) != null && (findViewById2 = mContainer2.findViewById(R.id.pz9)) != null) {
            com.tencent.state.ViewExtensionsKt.setVisibility(findViewById2, false);
        }
        T binding2 = getBinding();
        if (binding2 == null || (mContainer = binding2.getMContainer()) == null || (findViewById = mContainer.findViewById(R.id.pz8)) == null) {
            return;
        }
        com.tencent.state.ViewExtensionsKt.setVisibility(findViewById, false);
    }

    public abstract void onFlowerDataLoaded(FlowerDisplayData data);

    @Override // com.tencent.state.square.flower.FloatPanelBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.square.flower.FloatPanelBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.state.square.flower.FloatPanelBaseFragment, com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        getPageInfo();
        super.onViewCreated(view, savedInstanceState);
        T binding = getBinding();
        if (binding != null) {
            initSubView(binding);
            initReport(view);
        }
    }

    @Override // com.tencent.state.square.flower.FloatPanelBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.state.square.flower.FloatPanelBaseFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    private final View createMedalHelpInfoView(MedalData medal) {
        if (medal == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setGravity(16);
        SquareImageView squareImageView = new SquareImageView(linearLayout.getContext());
        squareImageView.setLayoutParams(new LinearLayout.LayoutParams(ViewExtensionsKt.dip(squareImageView.getContext(), 24), ViewExtensionsKt.dip(squareImageView.getContext(), 24)));
        ImageService.Companion companion = ImageService.INSTANCE;
        ImageLoader loader = companion.getLoader();
        if (loader != null) {
            loader.displayImage(medal.getImageUrl(), new ImageViewAware(squareImageView), companion.getUniqueImageOptions(medal.getImageUrl()), null, null, null);
        }
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(squareImageView);
        TextView textView = new TextView(linearLayout.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart(ViewExtensionsKt.dip(textView.getContext(), 4));
        textView.setLayoutParams(layoutParams);
        textView.setText("\u7d2f\u8ba1");
        textView.setTextSize(10.0f);
        int i3 = (int) 2583691263L;
        textView.setTextColor(i3);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(linearLayout.getContext());
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        StringBuilder sb5 = new StringBuilder();
        sb5.append(medal.getTarget());
        sb5.append('\u6735');
        textView2.setText(sb5.toString());
        textView2.setTextSize(10.0f);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        try {
            i3 = Color.parseColor(medal.getColor());
        } catch (Throwable unused) {
        }
        textView2.setTextColor(i3);
        Unit unit2 = Unit.INSTANCE;
        linearLayout.addView(textView2);
        return linearLayout;
    }
}
