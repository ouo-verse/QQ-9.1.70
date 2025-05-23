package com.tencent.mobileqq.wink.qzone.templatelibrary.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b93.OutputData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.qui.quishimmer.view.QUIShimmerImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.image.f;
import com.tencent.mobileqq.vas.image.j;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.context.WinkExodus;
import com.tencent.mobileqq.wink.event.WinkQZoneMoodAppendEvent;
import com.tencent.mobileqq.wink.l;
import com.tencent.mobileqq.wink.pager.FragmentPager;
import com.tencent.mobileqq.wink.qzone.templatelibrary.fragment.WinkQZoneTemplateLibMainFragment;
import com.tencent.mobileqq.wink.qzone.templatelibrary.part.g;
import com.tencent.mobileqq.wink.qzone.templatelibrary.part.i;
import com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c;
import com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel.WinkQZoneTemplateLibViewModel;
import com.tencent.mobileqq.wink.report.e;
import com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.videocut.utils.LiveDataExtKt;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import za3.a;

/* compiled from: P */
@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_CIRCLE_PUBLISH, scene = QQPermissionConstants.Business.SCENE.CIRCLE_PUBLISH_TEMPLATE)
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 T2\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001UB\u0007\u00a2\u0006\u0004\bR\u0010SJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\nH\u0002J \u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u001a\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014J\u001a\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\bH\u0016J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016J\"\u0010*\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\b\u0010+\u001a\u00020\bH\u0016J\u0010\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020\nH\u0016J\b\u00100\u001a\u00020\u000fH\u0014J\u0010\u00102\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0005H\u0016J$\u00106\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050403j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000504`5H\u0016R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/fragment/WinkQZoneTemplateLibMainFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lcom/tencent/mobileqq/winkreport/crashreport/IWinkCrashReportCallback;", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$d;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", "view", "", "initView", "", "pageIn", "Gh", "show", "Jh", "", "resID", "Ih", OcrConfig.CHINESE, "initViewModel", "Ah", "quit", "Eh", "contentView", "Fh", "getContentLayoutId", "", "getLogTag", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedAfterPartInit", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "xc", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$b;", "callback", "P6", "onBackEvent", "getStatusBarColor", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", "templateViewModel", "Landroidx/core/widget/NestedScrollView;", "D", "Landroidx/core/widget/NestedScrollView;", "nestedScrollView", "E", "Landroid/view/View;", "skeletonView", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/i;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/i;", "templateCategoryPart", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/g;", "G", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/g;", "templateAiToolPart", "", "H", "J", "lastScrollUpdate", "Ljava/lang/Runnable;", "I", "Ljava/lang/Runnable;", "checkRunnable", "<init>", "()V", "K", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkQZoneTemplateLibMainFragment extends ImmersivePartFragment implements IWinkCrashReportCallback, FragmentPager.d, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private WinkQZoneTemplateLibViewModel templateViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private NestedScrollView nestedScrollView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View skeletonView;

    /* renamed from: F, reason: from kotlin metadata */
    private i templateCategoryPart;

    /* renamed from: G, reason: from kotlin metadata */
    private g templateAiToolPart;

    @NotNull
    public Map<Integer, View> J = new LinkedHashMap();

    /* renamed from: H, reason: from kotlin metadata */
    private long lastScrollUpdate = -1;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Runnable checkRunnable = new Runnable() { // from class: u93.d
        @Override // java.lang.Runnable
        public final void run() {
            WinkQZoneTemplateLibMainFragment.yh(WinkQZoneTemplateLibMainFragment.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/qzone/templatelibrary/fragment/WinkQZoneTemplateLibMainFragment$b", "Landroidx/core/widget/NestedScrollView$OnScrollChangeListener;", "Landroidx/core/widget/NestedScrollView;", "v", "", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "", "onScrollChange", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements NestedScrollView.OnScrollChangeListener {
        b() {
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(@Nullable NestedScrollView v3, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            if (scrollY == oldScrollY) {
                return;
            }
            if (WinkQZoneTemplateLibMainFragment.this.lastScrollUpdate == -1) {
                WinkQZoneTemplateLibMainFragment.this.lastScrollUpdate = System.currentTimeMillis();
                NestedScrollView nestedScrollView = WinkQZoneTemplateLibMainFragment.this.nestedScrollView;
                if (nestedScrollView != null) {
                    nestedScrollView.removeCallbacks(WinkQZoneTemplateLibMainFragment.this.checkRunnable);
                }
                NestedScrollView nestedScrollView2 = WinkQZoneTemplateLibMainFragment.this.nestedScrollView;
                if (nestedScrollView2 != null) {
                    nestedScrollView2.postDelayed(WinkQZoneTemplateLibMainFragment.this.checkRunnable, 100L);
                    return;
                }
                return;
            }
            WinkQZoneTemplateLibMainFragment.this.lastScrollUpdate = System.currentTimeMillis();
        }
    }

    private final void Ah() {
        if (!f.f309589a.isApngSoLoaded()) {
            f.f309589a.a(new j.a() { // from class: u93.f
                @Override // com.tencent.mobileqq.vas.image.j.a
                public final void onResult(boolean z16) {
                    WinkQZoneTemplateLibMainFragment.Bh(z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(boolean z16) {
        w53.b.f("WinkQZoneTemplateLibMainFragment", "requestLoadApngSo result: " + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(WinkQZoneTemplateLibMainFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        e eVar = e.f326265a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        e.m(eVar, it, WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_BACK, null, null, 12, null);
        this$0.quit();
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(WinkQZoneTemplateLibMainFragment this$0, WinkQZoneTemplateLibViewModel.CategoriesData categoriesData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View fragmentContentView = this$0.getFragmentContentView();
        Intrinsics.checkNotNullExpressionValue(fragmentContentView, "fragmentContentView");
        this$0.Jh(fragmentContentView, false);
    }

    private final void Eh() {
        if (this.templateCategoryPart != null) {
            e.f326265a.y();
        }
    }

    private final void Fh(View contentView) {
        if (getActivity() == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(contentView, WinkDaTongReportConstant.PageId.PG_QZ_INSPIRATION_LIBRARY_HOME);
        Object obj = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE);
        Intrinsics.checkNotNullExpressionValue(obj, "get(WinkDaTongReportCons\u2026J_IS_FROM_WHICH_ENTRANCE)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, obj);
        VideoReport.setPageParams(contentView, new WinkDTParamBuilder().buildPageParams(hashMap, WinkContext.INSTANCE.d().getDtParams().c()));
        VideoReport.setPageReportPolicy(contentView, PageReportPolicy.REPORT_NONE);
    }

    private final void Gh(boolean pageIn) {
        VideoReport.setEventDynamicParams(getFragmentContentView(), new IDynamicParams() { // from class: u93.e
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map Hh;
                Hh = WinkQZoneTemplateLibMainFragment.Hh(WinkQZoneTemplateLibMainFragment.this, str);
                return Hh;
            }
        });
        if (pageIn) {
            VideoReport.reportPgIn(getFragmentContentView());
        } else {
            VideoReport.reportPgOut(getFragmentContentView());
        }
        VideoReport.setEventDynamicParams(getFragmentContentView(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map Hh(WinkQZoneTemplateLibMainFragment this$0, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        g gVar = this$0.templateAiToolPart;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateAiToolPart");
            gVar = null;
        }
        if (gVar.getIsExpand()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.AI_TOOL_STATE, str2);
        return linkedHashMap;
    }

    private final void Ih(View view, int resID, boolean show) {
        int i3;
        int i16;
        Context context = getContext();
        if (context != null) {
            i3 = context.getColor(R.color.qui_common_fill_standard_extra);
        } else {
            i3 = 0;
        }
        Context context2 = getContext();
        if (context2 != null) {
            i16 = context2.getColor(R.color.qui_common_fill_light_secondary);
        } else {
            i16 = 0;
        }
        QUIShimmerImageView qUIShimmerImageView = (QUIShimmerImageView) view.findViewById(resID);
        if (qUIShimmerImageView != null) {
            qUIShimmerImageView.updateColors(0, i3, i16, 0);
            if (show) {
                qUIShimmerImageView.startShimming(null);
            } else {
                qUIShimmerImageView.stopShimming(null);
            }
        }
    }

    private final void Jh(View view, boolean show) {
        int i3;
        View view2 = this.skeletonView;
        if (view2 != null) {
            if (show) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
        Ih(view, R.id.dor, show);
        Ih(view, R.id.doy, show);
        Ih(view, R.id.f165845dp4, show);
        Ih(view, R.id.dp_, show);
        Ih(view, R.id.dpa, show);
        Ih(view, R.id.dpb, show);
        Ih(view, R.id.xs9, show);
        Ih(view, R.id.xs_, show);
        Ih(view, R.id.xsa, show);
        Ih(view, R.id.xs7, show);
        Ih(view, R.id.xs8, show);
    }

    private final void initView(View view) {
        ViewGroup.LayoutParams layoutParams;
        setStatusBarTextColor();
        this.skeletonView = view.findViewById(R.id.f124157il);
        boolean z16 = true;
        Jh(view, true);
        View findViewById = view.findViewById(R.id.f124257iv);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: u93.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WinkQZoneTemplateLibMainFragment.Ch(WinkQZoneTemplateLibMainFragment.this, view2);
                }
            });
        }
        NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.f124097if);
        this.nestedScrollView = nestedScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.setOnScrollChangeListener(new b());
        }
        Bundle arguments = getArguments();
        if (arguments == null || arguments.getBoolean("ARG_PADDING_BOTTOM", false)) {
            z16 = false;
        }
        if (z16) {
            NestedScrollView nestedScrollView2 = this.nestedScrollView;
            ViewGroup.LayoutParams layoutParams2 = null;
            if (nestedScrollView2 != null) {
                layoutParams = nestedScrollView2.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = 0;
            }
            View view2 = this.skeletonView;
            if (view2 != null) {
                layoutParams2 = view2.getLayoutParams();
            }
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = 0;
            }
        }
    }

    private final void initViewModel() {
        MutableLiveData<WinkQZoneTemplateLibViewModel.CategoriesData> N1;
        WinkQZoneTemplateLibViewModel winkQZoneTemplateLibViewModel = (WinkQZoneTemplateLibViewModel) getViewModel(WinkQZoneTemplateLibViewModel.class);
        this.templateViewModel = winkQZoneTemplateLibViewModel;
        if (winkQZoneTemplateLibViewModel != null && (N1 = winkQZoneTemplateLibViewModel.N1()) != null) {
            LiveDataExtKt.a(N1, this, new Observer() { // from class: u93.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkQZoneTemplateLibMainFragment.Dh(WinkQZoneTemplateLibMainFragment.this, (WinkQZoneTemplateLibViewModel.CategoriesData) obj);
                }
            });
        }
    }

    private final void quit() {
        Bundle bundle;
        Intent intent;
        Context context = getContext();
        if (context != null) {
            WinkExodus m3 = WinkContext.INSTANCE.d().m();
            FragmentActivity activity = getActivity();
            if (activity != null && (intent = activity.getIntent()) != null) {
                bundle = intent.getExtras();
            } else {
                bundle = null;
            }
            m3.j(context, bundle);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
            activity2.overridePendingTransition(0, R.anim.f155066i1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(WinkQZoneTemplateLibMainFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (System.currentTimeMillis() - this$0.lastScrollUpdate > 100) {
            this$0.lastScrollUpdate = -1L;
            this$0.Eh();
            return;
        }
        NestedScrollView nestedScrollView = this$0.nestedScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.removeCallbacks(this$0.checkRunnable);
        }
        NestedScrollView nestedScrollView2 = this$0.nestedScrollView;
        if (nestedScrollView2 != null) {
            nestedScrollView2.postDelayed(this$0.checkRunnable, 100L);
        }
    }

    private final void zh() {
        WinkQZoneTemplateLibViewModel winkQZoneTemplateLibViewModel = this.templateViewModel;
        if (winkQZoneTemplateLibViewModel != null) {
            winkQZoneTemplateLibViewModel.P1(true);
        }
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void P6(@NotNull FragmentPager.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void X9(@NotNull String str, boolean z16) {
        FragmentPager.d.a.a(this, str, z16);
    }

    public void _$_clearFindViewByIdCache() {
        this.J.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> listOf;
        this.templateCategoryPart = new i();
        this.templateAiToolPart = new g();
        Part[] partArr = new Part[2];
        i iVar = this.templateCategoryPart;
        g gVar = null;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateCategoryPart");
            iVar = null;
        }
        partArr[0] = iVar;
        g gVar2 = this.templateAiToolPart;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateAiToolPart");
        } else {
            gVar = gVar2;
        }
        partArr[1] = gVar;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) partArr);
        return listOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i7o;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WinkQZoneMoodAppendEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    public String getLogTag() {
        return "WinkQZoneTemplateLibMainFragment";
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Fragment findFragmentByTag;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 52130 && (findFragmentByTag = getParentFragmentManager().findFragmentByTag("WinkQZoneTemplateLibMoreTemplateFragment")) != null && (findFragmentByTag instanceof WinkQZoneTemplateLibMoreTemplateFragment)) {
            findFragmentByTag.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onAttachReport() {
        a.b(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        try {
            Fragment findFragmentByTag = getParentFragmentManager().findFragmentByTag("WinkQZoneTemplateLibMoreTemplateFragment");
            if (findFragmentByTag != null && (findFragmentByTag instanceof WinkQZoneTemplateLibMoreTemplateFragment)) {
                ((WinkQZoneTemplateLibMoreTemplateFragment) findFragmentByTag).quit();
                return true;
            }
        } catch (Throwable th5) {
            w53.b.c("WinkQZoneTemplateLibMainFragment", "onBackEvent: " + th5);
        }
        quit();
        return true;
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCreateReport() {
        a.c(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCreateViewReport() {
        a.d(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCustomReport(int i3) {
        a.e(this, i3);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyReport() {
        a.f(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        NestedScrollView nestedScrollView = this.nestedScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.clearAnimation();
            nestedScrollView.removeCallbacks(this.checkRunnable);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        c.p(c.f326233a, "onDestroyView", null, 2, null);
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyViewReport() {
        a.g(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onHiddenChangedReport(boolean z16) {
        a.h(this, z16);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Gh(false);
        c.p(c.f326233a, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, null, 2, null);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onPauseReport() {
        a.i(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
        List plus;
        Bundle bundle;
        List split$default;
        Object orNull;
        Bundle bundle2;
        Intent intent;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof WinkQZoneMoodAppendEvent) {
            WinkQZoneMoodAppendEvent winkQZoneMoodAppendEvent = (WinkQZoneMoodAppendEvent) event;
            plus = CollectionsKt___CollectionsKt.plus((Collection) winkQZoneMoodAppendEvent.getImagePathList(), (Iterable) winkQZoneMoodAppendEvent.getVideoPathList());
            ArrayList<LocalMediaInfo> mediaInfoList = ba3.a.b(plus);
            Intrinsics.checkNotNullExpressionValue(mediaInfoList, "mediaInfoList");
            Iterator<T> it = mediaInfoList.iterator();
            while (true) {
                bundle = null;
                Serializable serializable = null;
                bundle = null;
                if (!it.hasNext()) {
                    break;
                }
                LocalMediaInfo localMediaInfo = (LocalMediaInfo) it.next();
                HashMap<String, Serializable> extData = localMediaInfo.extData;
                if (extData != null) {
                    Intrinsics.checkNotNullExpressionValue(extData, "extData");
                    serializable = extData.put(AECameraConstants.MEDIA_FROM, AECameraConstants.MEDIA_FROM_EDIT);
                }
                if (serializable == null) {
                    HashMap<String, Serializable> hashMap = new HashMap<>();
                    hashMap.put(AECameraConstants.MEDIA_FROM, AECameraConstants.MEDIA_FROM_EDIT);
                    localMediaInfo.extData = hashMap;
                }
            }
            OutputData.Companion companion = OutputData.INSTANCE;
            Activity hostActivity = getHostActivity();
            if (hostActivity != null && (intent = hostActivity.getIntent()) != null) {
                bundle = intent.getExtras();
            }
            OutputData b16 = companion.b(1L, mediaInfoList, null, bundle);
            HashMap<String, String> publishEventTagParams = winkQZoneMoodAppendEvent.getPublishEventTagParams();
            if (publishEventTagParams != null) {
                Bundle bundle3 = b16.getBundle();
                if (bundle3 != null) {
                    bundle3.putString("tagtitle", publishEventTagParams.get("tagTitle"));
                }
                Bundle bundle4 = b16.getBundle();
                if (bundle4 != null) {
                    bundle4.putString("tagprotocol", publishEventTagParams.get("tagProtocol"));
                }
                Bundle bundle5 = b16.getBundle();
                if (bundle5 != null) {
                    bundle5.putString("adId", publishEventTagParams.get("adId"));
                }
                Bundle bundle6 = b16.getBundle();
                if (bundle6 != null) {
                    bundle6.putString(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, publishEventTagParams.get("thirdPartyAppId"));
                }
                String str = publishEventTagParams.get("tagProtocol");
                if (str != null) {
                    Intrinsics.checkNotNullExpressionValue(str, "it[\"tagProtocol\"]");
                    split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_102_"}, false, 0, 6, (Object) null);
                    if (split$default != null) {
                        orNull = CollectionsKt___CollectionsKt.getOrNull(split$default, 0);
                        String str2 = (String) orNull;
                        if (str2 != null && (bundle2 = b16.getBundle()) != null) {
                            bundle2.putString("taguin", str2);
                        }
                    }
                }
            }
            WinkContext.INSTANCE.d().m().k(getContext(), b16);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Eh();
        Gh(true);
        c.p(c.f326233a, "onResume", null, 2, null);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onResumeReport() {
        a.j(this);
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        l.f();
        if (uq3.c.f6()) {
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).preDownloadAllNonEssentialBundles();
        }
        Ah();
        initView(view);
        initViewModel();
        zh();
        SimpleEventBus.getInstance().registerReceiver(this);
        c.p(c.f326233a, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        Fh(contentView);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onViewCreatedReport() {
        a.k(this);
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void xc() {
    }
}
