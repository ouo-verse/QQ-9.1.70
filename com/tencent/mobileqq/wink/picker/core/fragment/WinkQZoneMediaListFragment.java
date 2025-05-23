package com.tencent.mobileqq.wink.picker.core.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.google.android.material.appbar.AppBarLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaListPart;
import com.tencent.mobileqq.wink.picker.core.part.aj;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.p;
import com.tencent.mobileqq.wink.picker.core.viewmodel.q;
import com.tencent.mobileqq.wink.picker.core.viewmodel.v;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import e93.QZoneAlbumInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 62\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001d\u0010'\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b%\u0010&R\u001d\u0010+\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010*R\u001d\u00100\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010\u001d\u001a\u0004\b.\u0010/R\u001d\u00103\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010\u001d\u001a\u0004\b2\u0010*\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/fragment/WinkQZoneMediaListFragment;", "Lcom/tencent/mobileqq/wink/picker/core/fragment/WinkMediaPickerChildFragment;", "", "initView", "Ch", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "", "getLogTag", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/v;", "E", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/v;", "qZoneMediaViewModel", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "G", "Lkotlin/Lazy;", OcrConfig.CHINESE, "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "mediaPickerUIStateViewModel", "H", "I", "skeletonViewMarginTop", "Landroid/widget/TextView;", "Bh", "()Landroid/widget/TextView;", "titleText", "J", "yh", "()Landroid/view/View;", "backBtn", "Lcom/google/android/material/appbar/AppBarLayout;", "K", "xh", "()Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "L", "Ah", "skeletonView", "<init>", "()V", "N", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkQZoneMediaListFragment extends WinkMediaPickerChildFragment {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private v qZoneMediaViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private WinkSelectedMediaViewModel selectedMediaViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy mediaPickerUIStateViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    private int skeletonViewMarginTop;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy titleText;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy backBtn;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy appBarLayout;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy skeletonView;

    @NotNull
    public Map<Integer, View> M = new LinkedHashMap();

    public WinkQZoneMediaListFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<p>() { // from class: com.tencent.mobileqq.wink.picker.core.fragment.WinkQZoneMediaListFragment$mediaPickerUIStateViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final p invoke() {
                FragmentActivity requireActivity = WinkQZoneMediaListFragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                return q.a(requireActivity);
            }
        });
        this.mediaPickerUIStateViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.picker.core.fragment.WinkQZoneMediaListFragment$titleText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final TextView invoke() {
                View view = WinkQZoneMediaListFragment.this.getView();
                if (view != null) {
                    return (TextView) view.findViewById(R.id.f166986jo4);
                }
                return null;
            }
        });
        this.titleText = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.picker.core.fragment.WinkQZoneMediaListFragment$backBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                View view = WinkQZoneMediaListFragment.this.getView();
                if (view != null) {
                    return view.findViewById(R.id.t2c);
                }
                return null;
            }
        });
        this.backBtn = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<AppBarLayout>() { // from class: com.tencent.mobileqq.wink.picker.core.fragment.WinkQZoneMediaListFragment$appBarLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final AppBarLayout invoke() {
                View view = WinkQZoneMediaListFragment.this.getView();
                if (view != null) {
                    return (AppBarLayout) view.findViewById(R.id.sqc);
                }
                return null;
            }
        });
        this.appBarLayout = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.picker.core.fragment.WinkQZoneMediaListFragment$skeletonView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                View view = WinkQZoneMediaListFragment.this.getView();
                if (view != null) {
                    return view.findViewById(R.id.f85774pv);
                }
                return null;
            }
        });
        this.skeletonView = lazy5;
    }

    private final View Ah() {
        return (View) this.skeletonView.getValue();
    }

    private final TextView Bh() {
        return (TextView) this.titleText.getValue();
    }

    private final void Ch() {
        LiveData<UIStateData<List<LocalMediaInfo>>> P1;
        AppBarLayout xh5 = xh();
        if (xh5 != null) {
            xh5.e(new AppBarLayout.g() { // from class: com.tencent.mobileqq.wink.picker.core.fragment.e
                @Override // com.google.android.material.appbar.AppBarLayout.c
                public final void onOffsetChanged(AppBarLayout appBarLayout, int i3) {
                    WinkQZoneMediaListFragment.Dh(WinkQZoneMediaListFragment.this, appBarLayout, i3);
                }
            });
        }
        v vVar = this.qZoneMediaViewModel;
        if (vVar != null && (P1 = vVar.P1()) != null) {
            P1.observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.fragment.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkQZoneMediaListFragment.Eh(WinkQZoneMediaListFragment.this, (UIStateData) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(WinkQZoneMediaListFragment this$0, AppBarLayout appBarLayout, int i3) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View Ah = this$0.Ah();
        if (Ah != null) {
            layoutParams = Ah.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams)).topMargin = this$0.skeletonViewMarginTop + i3;
        View Ah2 = this$0.Ah();
        if (Ah2 != null) {
            Ah2.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(WinkQZoneMediaListFragment this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (uIStateData.getState() == 0) {
            View Ah = this$0.Ah();
            if (Ah != null) {
                Ah.setVisibility(0);
                return;
            }
            return;
        }
        View Ah2 = this$0.Ah();
        if (Ah2 != null) {
            Ah2.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(WinkQZoneMediaListFragment this$0, QZoneAlbumInfo qZoneAlbumInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        v vVar = this$0.qZoneMediaViewModel;
        if (vVar != null) {
            vVar.fetchFirstPageMedia();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(WinkQZoneMediaListFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackEvent();
        WinkSelectedMediaViewModel winkSelectedMediaViewModel = this$0.selectedMediaViewModel;
        if (winkSelectedMediaViewModel != null) {
            Map<String, Object> l3 = com.tencent.mobileqq.wink.picker.report.a.l("em_xsj_return_button", true, winkSelectedMediaViewModel.getSelectedMedia());
            Intrinsics.checkNotNullExpressionValue(it, "it");
            com.tencent.mobileqq.wink.picker.report.a.p(it, l3);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void initView() {
        requireView().findViewById(R.id.root).setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        ((ImageView) requireView().findViewById(R.id.t2d)).setImageResource(R.drawable.qui_close);
        AppBarLayout xh5 = xh();
        if (xh5 != null) {
            xh5.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        }
        TextView Bh = Bh();
        if (Bh != null) {
            Bh.setTextColor(requireContext().getColor(R.color.qui_common_text_primary));
        }
    }

    private final AppBarLayout xh() {
        return (AppBarLayout) this.appBarLayout.getValue();
    }

    private final View yh() {
        return (View) this.backBtn.getValue();
    }

    private final p zh() {
        return (p) this.mediaPickerUIStateViewModel.getValue();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment
    public void _$_clearFindViewByIdCache() {
        this.M.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new aj());
        v vVar = this.qZoneMediaViewModel;
        if (vVar != null) {
            arrayList.add(new WinkMediaListPart(MediaType.QZONE_ALL, vVar));
        }
        arrayList.addAll(com.tencent.mobileqq.wink.picker.core.c.f324480a.e().g());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        if (Intrinsics.areEqual(com.tencent.mobileqq.wink.picker.core.c.f324480a.a(), "QZONE")) {
            return R.layout.i7f;
        }
        return R.layout.i7e;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkQZoneMediaListFragment";
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        WinkMediaPickerMainBaseFragment winkMediaPickerMainBaseFragment;
        LiveData<QZoneAlbumInfo> R1;
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof WinkMediaPickerMainBaseFragment) {
            winkMediaPickerMainBaseFragment = (WinkMediaPickerMainBaseFragment) parentFragment;
        } else {
            winkMediaPickerMainBaseFragment = null;
        }
        if (winkMediaPickerMainBaseFragment != null) {
            v i3 = q.i(winkMediaPickerMainBaseFragment);
            this.qZoneMediaViewModel = i3;
            if (i3 != null && (R1 = i3.R1()) != null) {
                R1.observe(winkMediaPickerMainBaseFragment, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.fragment.c
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WinkQZoneMediaListFragment.Fh(WinkQZoneMediaListFragment.this, (QZoneAlbumInfo) obj);
                    }
                });
            }
            this.selectedMediaViewModel = q.j(winkMediaPickerMainBaseFragment);
        }
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setStatusBarTextColor();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.skeletonViewMarginTop = requireContext().getResources().getDimensionPixelSize(R.dimen.cxx);
        TextView Bh = Bh();
        if (Bh != null) {
            Bh.setText(R.string.f216325y0);
        }
        View yh5 = yh();
        if (yh5 != null) {
            yh5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.fragment.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WinkQZoneMediaListFragment.Gh(WinkQZoneMediaListFragment.this, view2);
                }
            });
        }
        zh().W1(false);
        initView();
        Ch();
        com.tencent.mobileqq.wink.picker.report.a.o(view, requireActivity(), "pg_xsj_choose_media_new_page", true, null, 0, false, true, null, g.CTRL_INDEX, null);
    }
}
