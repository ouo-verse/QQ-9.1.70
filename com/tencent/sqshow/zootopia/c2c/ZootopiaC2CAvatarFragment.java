package com.tencent.sqshow.zootopia.c2c;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.view.ZootopiaDragLayout;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 (2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002)*B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006+"}, d2 = {"Lcom/tencent/sqshow/zootopia/c2c/ZootopiaC2CAvatarFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/tencent/sqshow/zootopia/view/ZootopiaDragLayout$a;", "Lcom/tencent/sqshow/zootopia/c2c/a;", "Landroidx/fragment/app/Fragment;", "fragment", "", "uh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onStart", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/sqshow/zootopia/view/ZootopiaDragLayout$State;", "state", "Qd", "", "isExpanded", "W0", "onResume", "Ln74/c;", BdhLogUtil.LogTag.Tag_Conn, "Ln74/c;", "binding", "Lcom/tencent/sqshow/zootopia/c2c/ZootopiaC2CAvatarFragment$Config;", "D", "Lcom/tencent/sqshow/zootopia/c2c/ZootopiaC2CAvatarFragment$Config;", DownloadInfo.spKey_Config, "E", "Landroidx/fragment/app/Fragment;", "currentFragment", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "Config", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaC2CAvatarFragment extends DialogFragment implements ZootopiaDragLayout.a, a {

    /* renamed from: F, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private n74.c binding;

    /* renamed from: D, reason: from kotlin metadata */
    private Config config = new Config(0, 0, false, false, false, 0, 63, null);

    /* renamed from: E, reason: from kotlin metadata */
    private Fragment currentFragment;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/sqshow/zootopia/c2c/ZootopiaC2CAvatarFragment$Config;", "Ljava/io/Serializable;", "initPanelHeight", "", "maxPanelHeight", "isHeightFixed", "", "isMaskBackground", "isDragViewTransparent", "dragHandleResource", "(IIZZZI)V", "getDragHandleResource", "()I", "getInitPanelHeight", "()Z", "getMaxPanelHeight", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class Config implements Serializable {
        private final int dragHandleResource;
        private final int initPanelHeight;
        private final boolean isDragViewTransparent;
        private final boolean isHeightFixed;
        private final boolean isMaskBackground;
        private final int maxPanelHeight;

        public Config() {
            this(0, 0, false, false, false, 0, 63, null);
        }

        public final int getDragHandleResource() {
            return this.dragHandleResource;
        }

        public final int getInitPanelHeight() {
            return this.initPanelHeight;
        }

        public final int getMaxPanelHeight() {
            return this.maxPanelHeight;
        }

        /* renamed from: isDragViewTransparent, reason: from getter */
        public final boolean getIsDragViewTransparent() {
            return this.isDragViewTransparent;
        }

        /* renamed from: isHeightFixed, reason: from getter */
        public final boolean getIsHeightFixed() {
            return this.isHeightFixed;
        }

        /* renamed from: isMaskBackground, reason: from getter */
        public final boolean getIsMaskBackground() {
            return this.isMaskBackground;
        }

        public Config(int i3, int i16, boolean z16, boolean z17, boolean z18, int i17) {
            this.initPanelHeight = i3;
            this.maxPanelHeight = i16;
            this.isHeightFixed = z16;
            this.isMaskBackground = z17;
            this.isDragViewTransparent = z18;
            this.dragHandleResource = i17;
        }

        public /* synthetic */ Config(int i3, int i16, boolean z16, boolean z17, boolean z18, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
            this((i18 & 1) != 0 ? 0 : i3, (i18 & 2) != 0 ? 0 : i16, (i18 & 4) != 0 ? false : z16, (i18 & 8) != 0 ? false : z17, (i18 & 16) == 0 ? z18 : false, (i18 & 32) != 0 ? R.drawable.ikd : i17);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/zootopia/c2c/ZootopiaC2CAvatarFragment$a;", "", "Lcom/tencent/sqshow/zootopia/c2c/ZootopiaC2CAvatarFragment$Config;", DownloadInfo.spKey_Config, "Lcom/tencent/sqshow/zootopia/c2c/ZootopiaC2CAvatarFragment;", "a", "Landroidx/fragment/app/Fragment;", "fragment", "b", "", "KEY_CONFIG", "Ljava/lang/String;", "", "PANEL_RADIUS_DP", UserInfo.SEX_FEMALE, "", "TRIGGER_DISTANCE", "I", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.c2c.ZootopiaC2CAvatarFragment$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaC2CAvatarFragment a(Config config) {
            Intrinsics.checkNotNullParameter(config, "config");
            ZootopiaC2CAvatarFragment zootopiaC2CAvatarFragment = new ZootopiaC2CAvatarFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("key_c2c_avatar_panel_config", config);
            zootopiaC2CAvatarFragment.setArguments(bundle);
            zootopiaC2CAvatarFragment.setStyle(0, R.style.f173287zw);
            return zootopiaC2CAvatarFragment;
        }

        public final ZootopiaC2CAvatarFragment b(Config config, Fragment fragment) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            ZootopiaC2CAvatarFragment a16 = a(config);
            a16.currentFragment = fragment;
            return a16;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f370135a;

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
            f370135a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(n74.c binding, final ZootopiaC2CAvatarFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        binding.f418960e.x();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.c2c.c
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaC2CAvatarFragment.th(ZootopiaC2CAvatarFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(ZootopiaC2CAvatarFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final void uh(Fragment fragment) {
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
        int i3 = b.f370135a[state.ordinal()];
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
        a aVar = activityResultCaller instanceof a ? (a) activityResultCaller : null;
        if (aVar != null) {
            aVar.W0(isExpanded);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("key_c2c_avatar_panel_config") : null;
        Config config = serializable instanceof Config ? (Config) serializable : null;
        if (config == null) {
            config = this.config;
        }
        this.config = config;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.requestFeature(1);
            window.setDimAmount(0.0f);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -1);
            window.getDecorView().setPadding(0, 0, 0, 0);
        }
        n74.c g16 = n74.c.g(inflater, container, false);
        this.binding = g16;
        if (g16 != null) {
            return g16.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FragmentActivity activity = getActivity();
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(activity instanceof QBaseActivity ? (QBaseActivity) activity : null);
        if (systemBarComp != null) {
            systemBarComp.setStatusBarColor(0);
        }
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
        final n74.c cVar = this.binding;
        if (cVar == null) {
            return;
        }
        view.setFitsSystemWindows(true);
        ZootopiaDragLayout zootopiaDragLayout = cVar.f418960e;
        if (this.config.getIsMaskBackground()) {
            zootopiaDragLayout.p();
        }
        ZootopiaDragLayout.c cVar2 = new ZootopiaDragLayout.c(this.config.getInitPanelHeight(), this.config.getMaxPanelHeight(), i.b(100), this.config.getIsHeightFixed());
        ImageView imageView = cVar.f418961f;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.dragHandle");
        RoundRelativeLayout roundRelativeLayout = cVar.f418962g;
        Intrinsics.checkNotNullExpressionValue(roundRelativeLayout, "binding.panelRoot");
        zootopiaDragLayout.t(imageView, roundRelativeLayout, cVar2, this);
        RoundRelativeLayout roundRelativeLayout2 = cVar.f418962g;
        roundRelativeLayout2.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.f154347gb));
        roundRelativeLayout2.f316195e = i.a(8.32f);
        roundRelativeLayout2.f316197h = 3;
        if (this.config.getIsDragViewTransparent()) {
            FrameLayout frameLayout = cVar.f418959d;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.contentLayout");
            aa.h(frameLayout, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.sqshow.zootopia.c2c.ZootopiaC2CAvatarFragment$onViewCreated$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(RelativeLayout.LayoutParams updateLayoutParams) {
                    Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                    updateLayoutParams.addRule(3, 0);
                }
            });
        }
        cVar.f418961f.setImageResource(this.config.getDragHandleResource());
        Fragment fragment = this.currentFragment;
        if (fragment != null) {
            uh(fragment);
        }
        cVar.f418957b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.c2c.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZootopiaC2CAvatarFragment.sh(n74.c.this, this, view2);
            }
        });
    }
}
