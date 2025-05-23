package com.tencent.mobileqq.zootopia.qav.guide.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.zootopia.qav.guide.fragment.GuideContainerDialogFragment;
import com.tencent.mobileqq.zootopia.utils.l;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.view.ZootopiaDragLayout;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002)*B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zootopia/qav/guide/fragment/GuideContainerDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/tencent/sqshow/zootopia/view/ZootopiaDragLayout$a;", "Lcom/tencent/sqshow/zootopia/c2c/a;", "Landroidx/fragment/app/Fragment;", "fragment", "", "vh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onActivityCreated", "onStart", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/sqshow/zootopia/view/ZootopiaDragLayout$State;", "state", "Qd", "", "isExpanded", "W0", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/fragment/app/Fragment;", "currentFragment", "Lfi3/a;", "D", "Lfi3/a;", "binding", "Lcom/tencent/mobileqq/zootopia/qav/guide/fragment/GuideContainerDialogFragment$Config;", "E", "Lcom/tencent/mobileqq/zootopia/qav/guide/fragment/GuideContainerDialogFragment$Config;", DownloadInfo.spKey_Config, "<init>", "()V", UserInfo.SEX_FEMALE, "a", "Config", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class GuideContainerDialogFragment extends DialogFragment implements ZootopiaDragLayout.a, com.tencent.sqshow.zootopia.c2c.a {

    /* renamed from: F, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private Fragment currentFragment;

    /* renamed from: D, reason: from kotlin metadata */
    private fi3.a binding;

    /* renamed from: E, reason: from kotlin metadata */
    private Config config = new Config(0, null, 3, 0 == true ? 1 : 0);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/qav/guide/fragment/GuideContainerDialogFragment$Config;", "Ljava/io/Serializable;", "panelHeight", "", "transitPageInfo", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "(ILcom/tencent/mobileqq/vas/transit/TransitPageInfo;)V", "getPanelHeight", "()I", "getTransitPageInfo", "()Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class Config implements Serializable {
        private final int panelHeight;
        private final TransitPageInfo transitPageInfo;

        public Config() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        public final int getPanelHeight() {
            return this.panelHeight;
        }

        public final TransitPageInfo getTransitPageInfo() {
            return this.transitPageInfo;
        }

        public Config(int i3, TransitPageInfo transitPageInfo) {
            this.panelHeight = i3;
            this.transitPageInfo = transitPageInfo;
        }

        public /* synthetic */ Config(int i3, TransitPageInfo transitPageInfo, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? null : transitPageInfo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zootopia/qav/guide/fragment/GuideContainerDialogFragment$a;", "", "Lcom/tencent/mobileqq/zootopia/qav/guide/fragment/GuideContainerDialogFragment$Config;", DownloadInfo.spKey_Config, "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/mobileqq/zootopia/qav/guide/fragment/GuideContainerDialogFragment;", "a", "", "KEY_CONFIG", "Ljava/lang/String;", "", "PANEL_RADIUS_DP", UserInfo.SEX_FEMALE, "TAG", "", "TRIGGER_DISTANCE", "I", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.qav.guide.fragment.GuideContainerDialogFragment$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GuideContainerDialogFragment a(Config config, Fragment fragment) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            GuideContainerDialogFragment guideContainerDialogFragment = new GuideContainerDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("key_guide_panel_config", config);
            guideContainerDialogFragment.setArguments(bundle);
            guideContainerDialogFragment.setStyle(0, R.style.f173287zw);
            guideContainerDialogFragment.currentFragment = fragment;
            return guideContainerDialogFragment;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f329004a;

        static {
            int[] iArr = new int[ZootopiaDragLayout.State.values().length];
            try {
                iArr[ZootopiaDragLayout.State.DISAPPEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ZootopiaDragLayout.State.SHORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ZootopiaDragLayout.State.TALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f329004a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(final GuideContainerDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.qav.guide.fragment.b
            @Override // java.lang.Runnable
            public final void run() {
                GuideContainerDialogFragment.uh(GuideContainerDialogFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(GuideContainerDialogFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final void vh(Fragment fragment) {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        Fragment fragment2 = this.currentFragment;
        if (fragment2 != null && !Intrinsics.areEqual(fragment2, fragment) && fragment2.isVisible()) {
            beginTransaction.hide(fragment2);
        }
        if (fragment.isAdded()) {
            beginTransaction.show(fragment);
        } else {
            beginTransaction.add(R.id.pm_, fragment);
        }
        this.currentFragment = fragment;
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.tencent.sqshow.zootopia.view.ZootopiaDragLayout.a
    public void Qd(ZootopiaDragLayout.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        int i3 = b.f329004a[state.ordinal()];
        if (i3 == 1) {
            dismiss();
        } else if (i3 == 2) {
            W0(false);
        } else {
            if (i3 != 3) {
                return;
            }
            W0(true);
        }
    }

    @Override // com.tencent.sqshow.zootopia.c2c.a
    public void W0(boolean isExpanded) {
        ActivityResultCaller activityResultCaller = this.currentFragment;
        com.tencent.sqshow.zootopia.c2c.a aVar = activityResultCaller instanceof com.tencent.sqshow.zootopia.c2c.a ? (com.tencent.sqshow.zootopia.c2c.a) activityResultCaller : null;
        if (aVar != null) {
            aVar.W0(isExpanded);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        Window window;
        super.onActivityCreated(savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setDimAmount(0.0f);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -1);
        window.getDecorView().setPadding(0, 0, 0, 0);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("key_guide_panel_config") : null;
        Config config = serializable instanceof Config ? (Config) serializable : null;
        if (config == null) {
            config = this.config;
        }
        this.config = config;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        fi3.a g16 = fi3.a.g(inflater, container, false);
        this.binding = g16;
        if (g16 != null) {
            return g16.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        Dialog dialog = getDialog();
        WindowManager.LayoutParams attributes = (dialog == null || (window = dialog.getWindow()) == null) ? null : window.getAttributes();
        if (attributes != null) {
            com.tencent.zplan.common.utils.b bVar = com.tencent.zplan.common.utils.b.f385287a;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            attributes.width = bVar.b(requireActivity);
        }
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        fi3.a aVar = this.binding;
        if (aVar == null) {
            return;
        }
        view.setFitsSystemWindows(true);
        ZootopiaDragLayout zootopiaDragLayout = aVar.f398770e;
        ZootopiaDragLayout.c cVar = new ZootopiaDragLayout.c(this.config.getPanelHeight(), this.config.getPanelHeight(), i.b(100), true);
        RelativeLayout relativeLayout = aVar.f398773h;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.rlDragContainer");
        RoundRelativeLayout roundRelativeLayout = aVar.f398772g;
        Intrinsics.checkNotNullExpressionValue(roundRelativeLayout, "binding.panelRoot");
        zootopiaDragLayout.t(relativeLayout, roundRelativeLayout, cVar, this);
        RoundRelativeLayout roundRelativeLayout2 = aVar.f398772g;
        Intrinsics.checkNotNullExpressionValue(roundRelativeLayout2, "binding.panelRoot");
        l.d(roundRelativeLayout2, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.mobileqq.zootopia.qav.guide.fragment.GuideContainerDialogFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RelativeLayout.LayoutParams updateLayoutParams) {
                GuideContainerDialogFragment.Config config;
                Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                config = GuideContainerDialogFragment.this.config;
                updateLayoutParams.height = config.getPanelHeight();
            }
        });
        RoundRelativeLayout roundRelativeLayout3 = aVar.f398772g;
        roundRelativeLayout3.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.f154347gb));
        roundRelativeLayout3.f316195e = i.a(8.32f);
        roundRelativeLayout3.f316197h = 3;
        aVar.f398767b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.qav.guide.fragment.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuideContainerDialogFragment.th(GuideContainerDialogFragment.this, view2);
            }
        });
        Fragment fragment = this.currentFragment;
        if (fragment != null) {
            vh(fragment);
        }
    }
}
