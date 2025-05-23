package com.tencent.mobileqq.guild.homev2.parts.title;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.homev2.misc.GuildHomeV2FragmentBehavior;
import com.tencent.mobileqq.guild.homev2.parts.title.view.GuildHomeV2CoverLayout;
import com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.GuildHomeV2TitleCoverViewModel;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qp1.ScrollStateData;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u0014\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/title/GuildHomeV2CoverPart;", "Lcom/tencent/mobileqq/guild/homev2/parts/a;", "", "initData", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel$b;", "uiState", "R9", "Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior$c;", "O9", "P9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Lcom/tencent/mobileqq/guild/homev2/parts/title/view/GuildHomeV2CoverLayout;", "e", "Lcom/tencent/mobileqq/guild/homev2/parts/title/view/GuildHomeV2CoverLayout;", "mCoverLayout", "Landroid/widget/Space;", "f", "Landroid/widget/Space;", "mWindowAnchor", tl.h.F, "Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior$c;", "onStateUpdate", "", "i", "I", "mLoadingOffset", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mStatusBarHeight", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeV2CoverPart extends com.tencent.mobileqq.guild.homev2.parts.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildHomeV2CoverLayout mCoverLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Space mWindowAnchor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mLoadingOffset;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildHomeV2FragmentBehavior.c onStateUpdate = O9();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mStatusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext());

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/homev2/parts/title/GuildHomeV2CoverPart$b", "Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior$c;", "Lqp1/b;", "state", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements GuildHomeV2FragmentBehavior.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f225974b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GuildHomeV2CoverPart f225975c;

        public b(String str, GuildHomeV2CoverPart guildHomeV2CoverPart) {
            this.f225974b = str;
            this.f225975c = guildHomeV2CoverPart;
        }

        @Override // com.tencent.mobileqq.guild.homev2.misc.GuildHomeV2FragmentBehavior.c
        public void a(@NotNull ScrollStateData state) {
            int coerceAtLeast;
            Intrinsics.checkNotNullParameter(state, "state");
            GuildHomeV2CoverPart guildHomeV2CoverPart = this.f225975c;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(state.getOffset(), 0);
            guildHomeV2CoverPart.mLoadingOffset = coerceAtLeast;
            this.f225975c.C9().O1().a2(this.f225975c.mLoadingOffset);
            GuildHomeV2CoverLayout guildHomeV2CoverLayout = this.f225975c.mCoverLayout;
            if (guildHomeV2CoverLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCoverLayout");
                guildHomeV2CoverLayout = null;
            }
            guildHomeV2CoverLayout.g(this.f225975c.mStatusBarHeight, this.f225975c.mLoadingOffset, "LoadingOffset");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final GuildHomeV2FragmentBehavior.c O9() {
        GuildHomeV2FragmentBehavior.c.Companion companion = GuildHomeV2FragmentBehavior.c.INSTANCE;
        return new b("GuildHomeV2CoverPart", this);
    }

    private final void P9() {
        Space space = this.mWindowAnchor;
        if (space == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWindowAnchor");
            space = null;
        }
        space.post(new Runnable() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeV2CoverPart.Q9(GuildHomeV2CoverPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(GuildHomeV2CoverPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Space space = this$0.mWindowAnchor;
        GuildHomeV2CoverLayout guildHomeV2CoverLayout = null;
        if (space == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWindowAnchor");
            space = null;
        }
        if (space.getTop() <= 0) {
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(this$0.getContext());
            Logger.f235387a.d().w("GuildHomeV2CoverPart", 1, "windowAnchor.top is 0, reset to statusBarHeight:" + statusBarHeight);
            this$0.mStatusBarHeight = statusBarHeight;
            GuildHomeV2CoverLayout guildHomeV2CoverLayout2 = this$0.mCoverLayout;
            if (guildHomeV2CoverLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCoverLayout");
            } else {
                guildHomeV2CoverLayout = guildHomeV2CoverLayout2;
            }
            guildHomeV2CoverLayout.g(this$0.mStatusBarHeight, this$0.mLoadingOffset, "InvalidWindowAnchor");
            return;
        }
        Space space2 = this$0.mWindowAnchor;
        if (space2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWindowAnchor");
            space2 = null;
        }
        this$0.mStatusBarHeight = space2.getTop();
        GuildHomeV2CoverLayout guildHomeV2CoverLayout3 = this$0.mCoverLayout;
        if (guildHomeV2CoverLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverLayout");
        } else {
            guildHomeV2CoverLayout = guildHomeV2CoverLayout3;
        }
        guildHomeV2CoverLayout.g(this$0.mStatusBarHeight, this$0.mLoadingOffset, "WindowAnchor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(GuildHomeViewModel.GuildHomeUiState uiState) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildHomeV2CoverPart", "updateTitleUIVisible uiState:" + uiState);
        }
        IGProGuildInfo guildInfo = uiState.getGuildInfo();
        boolean z27 = true;
        int i3 = 0;
        if (!uiState.getIsLoading() && guildInfo != null) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && uiState.getIsBanedGuild()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z16 && !z17 && guildInfo != null && !guildInfo.isMember() && !guildInfo.isVisibleForVisitor()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z16 && !z17 && !z18 && guildInfo != null && !guildInfo.isMember()) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (!z16 && !z17 && guildInfo != null && guildInfo.isMember()) {
            z26 = true;
        } else {
            z26 = false;
        }
        GuildHomeV2CoverLayout guildHomeV2CoverLayout = this.mCoverLayout;
        if (guildHomeV2CoverLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverLayout");
            guildHomeV2CoverLayout = null;
        }
        FrameLayout frameLayout = guildHomeV2CoverLayout.getMBinding().f442503c;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mCoverLayout.binding.guildCoverContainer");
        if (!z19 && !z26) {
            z27 = false;
        }
        if (!z27) {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
    }

    private final void initData() {
        LiveData<IGProGuildInfo> P1 = C9().getGuildInfoViewModel().P1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<IGProGuildInfo, Unit> function1 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2CoverPart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                boolean isBlank;
                GuildHomeV2CoverLayout guildHomeV2CoverLayout = null;
                String canBeEmptyCoverUrl = iGProGuildInfo != null ? iGProGuildInfo.getCanBeEmptyCoverUrl(0, 0) : null;
                if (canBeEmptyCoverUrl == null) {
                    canBeEmptyCoverUrl = "";
                }
                GuildHomeV2CoverLayout guildHomeV2CoverLayout2 = GuildHomeV2CoverPart.this.mCoverLayout;
                if (guildHomeV2CoverLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCoverLayout");
                } else {
                    guildHomeV2CoverLayout = guildHomeV2CoverLayout2;
                }
                guildHomeV2CoverLayout.f(canBeEmptyCoverUrl);
                GuildHomeV2TitleCoverViewModel O1 = GuildHomeV2CoverPart.this.C9().O1();
                isBlank = StringsKt__StringsJVMKt.isBlank(canBeEmptyCoverUrl);
                O1.X1(!isBlank);
            }
        };
        P1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeV2CoverPart.M9(Function1.this, obj);
            }
        });
        LiveData<Boolean> U1 = C9().O1().U1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2CoverPart$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                GuildHomeV2CoverLayout guildHomeV2CoverLayout = GuildHomeV2CoverPart.this.mCoverLayout;
                if (guildHomeV2CoverLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCoverLayout");
                    guildHomeV2CoverLayout = null;
                }
                guildHomeV2CoverLayout.e();
            }
        };
        U1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeV2CoverPart.N9(Function1.this, obj);
            }
        });
        Flow onEach = FlowKt.onEach(C9().P1(), new GuildHomeV2CoverPart$initData$3(this, null));
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner3, "partHost.hostLifecycleOwner");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(lifecycleOwner3));
        Flow onEach2 = FlowKt.onEach(C9().a2(), new GuildHomeV2CoverPart$initData$4(this, null));
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner4, "partHost.hostLifecycleOwner");
        FlowKt.launchIn(onEach2, LifecycleOwnerKt.getLifecycleScope(lifecycleOwner4));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        P9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.u_y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.cover_layout)");
        this.mCoverLayout = (GuildHomeV2CoverLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f915155d);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.system_window_anchor)");
        this.mWindowAnchor = (Space) findViewById2;
        if (B9().a() == GuildFacadeType.GameCenter) {
            GuildHomeV2CoverLayout guildHomeV2CoverLayout = this.mCoverLayout;
            if (guildHomeV2CoverLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCoverLayout");
                guildHomeV2CoverLayout = null;
            }
            guildHomeV2CoverLayout.setVisibility(8);
        }
        initData();
    }

    @Override // com.tencent.mobileqq.guild.homev2.parts.a, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        z9().k(this.onStateUpdate);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        z9().A(this.onStateUpdate);
    }
}
