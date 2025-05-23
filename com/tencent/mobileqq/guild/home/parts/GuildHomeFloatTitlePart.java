package com.tencent.mobileqq.guild.home.parts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ar1.h;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.home.subhome.g;
import com.tencent.mobileqq.guild.home.viewmodels.header.CheckinEntryInfo;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.NoticeBubbleInfo;
import com.tencent.mobileqq.guild.home.views.GuildHomeCoverBelowList;
import com.tencent.mobileqq.guild.home.views.title.GuildHomeFloatTitleLayout;
import com.tencent.mobileqq.guild.util.GuildNoticeKtKt;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00100\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/GuildHomeFloatTitlePart;", "Lcom/tencent/mobileqq/guild/home/parts/a;", "Lar1/h;", "U9", "", "initData", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "ea", "ga", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "frameLayout", "Landroid/widget/Space;", "f", "Landroid/widget/Space;", "windowAnchor", "Landroidx/recyclerview/widget/RecyclerView;", tl.h.F, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/guild/home/views/title/GuildHomeFloatTitleLayout;", "i", "Lcom/tencent/mobileqq/guild/home/views/title/GuildHomeFloatTitleLayout;", "headTitleAboveList", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList;", "coverBelow", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "dragHost", "Lis1/e;", "D", "Lis1/e;", "redPointViewModel", "E", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "onStateUpdate", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeFloatTitlePart extends a {

    /* renamed from: C, reason: from kotlin metadata */
    private DragFrameLayout dragHost;

    /* renamed from: D, reason: from kotlin metadata */
    private is1.e redPointViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.home.subhome.g onStateUpdate = ea();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout frameLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Space windowAnchor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GuildHomeFloatTitleLayout headTitleAboveList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private GuildHomeCoverBelowList coverBelow;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f224931a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildHomeFloatTitlePart f224932b;

        public c(ViewModelStoreOwner viewModelStoreOwner, GuildHomeFloatTitlePart guildHomeFloatTitlePart) {
            this.f224931a = viewModelStoreOwner;
            this.f224932b = guildHomeFloatTitlePart;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new is1.e(this.f224932b.B9()), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/home/parts/GuildHomeFloatTitlePart$d", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "Lbp1/a;", "state", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements com.tencent.mobileqq.guild.home.subhome.g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f224933b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GuildHomeFloatTitlePart f224934c;

        public d(String str, GuildHomeFloatTitlePart guildHomeFloatTitlePart) {
            this.f224933b = str;
            this.f224934c = guildHomeFloatTitlePart;
        }

        @Override // com.tencent.mobileqq.guild.home.subhome.g
        public void a(@NotNull bp1.a state) {
            boolean z16;
            Intrinsics.checkNotNullParameter(state, "state");
            RecyclerView recyclerView = this.f224934c.recyclerView;
            GuildHomeFloatTitleLayout guildHomeFloatTitleLayout = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            if (((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                GuildHomeFloatTitleLayout guildHomeFloatTitleLayout2 = this.f224934c.headTitleAboveList;
                if (guildHomeFloatTitleLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headTitleAboveList");
                } else {
                    guildHomeFloatTitleLayout = guildHomeFloatTitleLayout2;
                }
                guildHomeFloatTitleLayout.setDefaultTitleAlpha(state.getFloatTitleAlpha(), "GuildHomeFragmentBehavior-floatTitleAlpha");
                return;
            }
            GuildHomeFloatTitleLayout guildHomeFloatTitleLayout3 = this.f224934c.headTitleAboveList;
            if (guildHomeFloatTitleLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headTitleAboveList");
            } else {
                guildHomeFloatTitleLayout = guildHomeFloatTitleLayout3;
            }
            guildHomeFloatTitleLayout.setDefaultTitleAlpha(1.0f, "offsetChange-headerInvisible");
        }
    }

    private final ar1.h U9() {
        return new ar1.h(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(GuildHomeFloatTitlePart this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().i("Guild.NewHome.GuildHomeFloatTitlePart", 1, "(" + i19 + ", " + i26 + ", " + i27 + ", " + i28 + ") -> (" + i3 + ", " + i16 + ", " + i17 + ", " + i18 + ")");
        if (i18 - i16 != i28 - i26) {
            GuildHomeFloatTitleLayout guildHomeFloatTitleLayout = this$0.headTitleAboveList;
            if (guildHomeFloatTitleLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headTitleAboveList");
                guildHomeFloatTitleLayout = null;
            }
            guildHomeFloatTitleLayout.w(this$0.E9().getHeaderColorsViewModel().R1().getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(GuildHomeFloatTitlePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Space space = this$0.windowAnchor;
        Space space2 = null;
        if (space == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowAnchor");
            space = null;
        }
        if (space.getTop() > 0) {
            GuildHomeFloatTitleLayout guildHomeFloatTitleLayout = this$0.headTitleAboveList;
            if (guildHomeFloatTitleLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headTitleAboveList");
                guildHomeFloatTitleLayout = null;
            }
            Space space3 = this$0.windowAnchor;
            if (space3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowAnchor");
            } else {
                space2 = space3;
            }
            guildHomeFloatTitleLayout.setTitleTopSpace(space2.getTop());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final com.tencent.mobileqq.guild.home.subhome.g ea() {
        g.Companion companion = com.tencent.mobileqq.guild.home.subhome.g.INSTANCE;
        return new d("Guild.NewHome.GuildHomeFloatTitlePart", this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ga() {
        if (E9().getGuildCheckinViewModel().i2()) {
            QBaseActivity x95 = x9();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("https://qun.qq.com/guild/h5/guild-member-sign/index.html#/?guildId=%s", Arrays.copyOf(new Object[]{z9().f227656e}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            com.tencent.mobileqq.guild.util.ch.i1(x95, format);
            return;
        }
        E9().getGuildCheckinViewModel().b2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets ha(View view, WindowInsets windowInsets) {
        WindowInsets consumeSystemWindowInsets = windowInsets.consumeSystemWindowInsets();
        Intrinsics.checkNotNullExpressionValue(consumeSystemWindowInsets, "insets.consumeSystemWindowInsets()");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.GuildHomeFloatTitlePart", "setOnApplyWindowInsetsListener " + consumeSystemWindowInsets);
        }
        return consumeSystemWindowInsets;
    }

    private final void initData() {
        c.Companion companion = ef1.c.INSTANCE;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
        ViewModel viewModel = new ViewModelProvider(partHost, new c(partHost, this)).get(is1.e.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        is1.e eVar = (is1.e) viewModel;
        this.redPointViewModel = eVar;
        GuildHomeFloatTitleLayout guildHomeFloatTitleLayout = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redPointViewModel");
            eVar = null;
        }
        GuildFacadeType B9 = B9();
        String str = z9().f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        eVar.S1(B9, str);
        is1.e eVar2 = this.redPointViewModel;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redPointViewModel");
            eVar2 = null;
        }
        cn<Boolean> O1 = eVar2.O1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeFloatTitlePart$initData$2
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
            public final void invoke2(Boolean show) {
                GuildHomeFloatTitleLayout guildHomeFloatTitleLayout2 = GuildHomeFloatTitlePart.this.headTitleAboveList;
                if (guildHomeFloatTitleLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headTitleAboveList");
                    guildHomeFloatTitleLayout2 = null;
                }
                Intrinsics.checkNotNullExpressionValue(show, "show");
                guildHomeFloatTitleLayout2.p(show.booleanValue());
                if (show.booleanValue()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("sgrp_channel_id", GuildHomeFloatTitlePart.this.z9().f227656e);
                    hashMap.put("page_id", GuildHomeFloatTitlePart.this.B9().getReportPageId());
                    VideoReport.reportEvent("ev_sgrp_channel_setting_red_dot_imp", hashMap);
                }
            }
        };
        O1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeFloatTitlePart.X9(Function1.this, obj);
            }
        });
        D9().l(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeFloatTitlePart$initData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                is1.e eVar3;
                eVar3 = GuildHomeFloatTitlePart.this.redPointViewModel;
                if (eVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("redPointViewModel");
                    eVar3 = null;
                }
                eVar3.R1();
            }
        });
        D9().k(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeFloatTitlePart$initData$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildHomeFloatTitlePart.this.ga();
            }
        });
        GuildHomeFloatTitleLayout guildHomeFloatTitleLayout2 = this.headTitleAboveList;
        if (guildHomeFloatTitleLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headTitleAboveList");
            guildHomeFloatTitleLayout2 = null;
        }
        guildHomeFloatTitleLayout2.m(D9().i());
        E9().getGuildHomeTitleViewModel().W1(z9(), B9());
        LiveData<GuildHomeCoverColors> T1 = E9().getHeaderColorsViewModel().T1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<GuildHomeCoverColors, Unit> function12 = new Function1<GuildHomeCoverColors, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeFloatTitlePart$initData$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildHomeCoverColors guildHomeCoverColors) {
                invoke2(guildHomeCoverColors);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildHomeCoverColors it) {
                GuildHomeFloatTitleLayout guildHomeFloatTitleLayout3 = GuildHomeFloatTitlePart.this.headTitleAboveList;
                if (guildHomeFloatTitleLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headTitleAboveList");
                    guildHomeFloatTitleLayout3 = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildHomeFloatTitleLayout3.q(it);
            }
        };
        T1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeFloatTitlePart.Y9(Function1.this, obj);
            }
        });
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        LiveData<IGProGuildInfo> e26 = E9().getGuildHomeTitleViewModel().e2();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<IGProGuildInfo, Unit> function13 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeFloatTitlePart$initData$6
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                GuildHomeFloatTitleLayout guildHomeFloatTitleLayout3 = null;
                if (iGProGuildInfo != null) {
                    GuildHomeFloatTitleLayout guildHomeFloatTitleLayout4 = GuildHomeFloatTitlePart.this.headTitleAboveList;
                    if (guildHomeFloatTitleLayout4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("headTitleAboveList");
                        guildHomeFloatTitleLayout4 = null;
                    }
                    guildHomeFloatTitleLayout4.A(iGProGuildInfo);
                }
                if (booleanRef.element) {
                    GuildHomeFloatTitleLayout guildHomeFloatTitleLayout5 = GuildHomeFloatTitlePart.this.headTitleAboveList;
                    if (guildHomeFloatTitleLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("headTitleAboveList");
                    } else {
                        guildHomeFloatTitleLayout3 = guildHomeFloatTitleLayout5;
                    }
                    guildHomeFloatTitleLayout3.setDefaultTitleAlpha(0.0f, "init");
                    booleanRef.element = false;
                }
            }
        };
        e26.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeFloatTitlePart.Z9(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> S1 = E9().getGuildNetViewModel().S1();
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeFloatTitlePart$initData$7
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
                IGProGuildInfo value = GuildHomeFloatTitlePart.this.E9().getGuildHomeTitleViewModel().e2().getValue();
                if (value != null) {
                    GuildHomeFloatTitleLayout guildHomeFloatTitleLayout3 = GuildHomeFloatTitlePart.this.headTitleAboveList;
                    if (guildHomeFloatTitleLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("headTitleAboveList");
                        guildHomeFloatTitleLayout3 = null;
                    }
                    guildHomeFloatTitleLayout3.A(value);
                }
            }
        };
        S1.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeFloatTitlePart.aa(Function1.this, obj);
            }
        });
        LiveData<NoticeBubbleInfo> g26 = E9().getGuildHomeTitleViewModel().g2();
        LifecycleOwner lifecycleOwner5 = getPartHost().getLifecycleOwner();
        final Function1<NoticeBubbleInfo, Unit> function15 = new Function1<NoticeBubbleInfo, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeFloatTitlePart$initData$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NoticeBubbleInfo noticeBubbleInfo) {
                invoke2(noticeBubbleInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NoticeBubbleInfo noticeMsgData) {
                GuildHomeFloatTitleLayout guildHomeFloatTitleLayout3 = GuildHomeFloatTitlePart.this.headTitleAboveList;
                if (guildHomeFloatTitleLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headTitleAboveList");
                    guildHomeFloatTitleLayout3 = null;
                }
                Intrinsics.checkNotNullExpressionValue(noticeMsgData, "noticeMsgData");
                guildHomeFloatTitleLayout3.E(noticeMsgData);
            }
        };
        g26.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeFloatTitlePart.ba(Function1.this, obj);
            }
        });
        Space space = this.windowAnchor;
        if (space == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowAnchor");
            space = null;
        }
        space.post(new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.z
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeFloatTitlePart.ca(GuildHomeFloatTitlePart.this);
            }
        });
        LiveData<Bitmap> R1 = E9().getHeaderColorsViewModel().R1();
        LifecycleOwner lifecycleOwner6 = getPartHost().getLifecycleOwner();
        final GuildHomeFloatTitlePart$initData$10 guildHomeFloatTitlePart$initData$10 = new GuildHomeFloatTitlePart$initData$10(this);
        R1.observe(lifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeFloatTitlePart.da(Function1.this, obj);
            }
        });
        GuildHomeFloatTitleLayout guildHomeFloatTitleLayout3 = this.headTitleAboveList;
        if (guildHomeFloatTitleLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headTitleAboveList");
        } else {
            guildHomeFloatTitleLayout = guildHomeFloatTitleLayout3;
        }
        guildHomeFloatTitleLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.home.parts.ab
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                GuildHomeFloatTitlePart.V9(GuildHomeFloatTitlePart.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
        LiveData<CheckinEntryInfo> e27 = E9().getGuildCheckinViewModel().e2();
        LifecycleOwner lifecycleOwner7 = getPartHost().getLifecycleOwner();
        final Function1<CheckinEntryInfo, Unit> function16 = new Function1<CheckinEntryInfo, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeFloatTitlePart$initData$12
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CheckinEntryInfo checkinEntryInfo) {
                invoke2(checkinEntryInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CheckinEntryInfo it) {
                GuildHomeFloatTitleLayout guildHomeFloatTitleLayout4 = GuildHomeFloatTitlePart.this.headTitleAboveList;
                if (guildHomeFloatTitleLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headTitleAboveList");
                    guildHomeFloatTitleLayout4 = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildHomeFloatTitleLayout4.u(it);
            }
        };
        e27.observe(lifecycleOwner7, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.ac
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeFloatTitlePart.W9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.vaz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.float_title_layout)");
        this.frameLayout = (FrameLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f98755ny);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.title_recyclerview)");
        this.recyclerView = (RecyclerView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f915155d);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.system_window_anchor)");
        this.windowAnchor = (Space) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.u_r);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.cover_below)");
        this.coverBelow = (GuildHomeCoverBelowList) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.ulf);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.drag_frame_layout)");
        this.dragHost = (DragFrameLayout) findViewById5;
        Context context = rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this.headTitleAboveList = new GuildHomeFloatTitleLayout(context);
        FrameLayout frameLayout = this.frameLayout;
        GuildHomeFloatTitleLayout guildHomeFloatTitleLayout = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
            frameLayout = null;
        }
        frameLayout.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.tencent.mobileqq.guild.home.parts.t
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsets ha5;
                ha5 = GuildHomeFloatTitlePart.ha(view, windowInsets);
                return ha5;
            }
        });
        GuildHomeFloatTitleLayout guildHomeFloatTitleLayout2 = this.headTitleAboveList;
        if (guildHomeFloatTitleLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headTitleAboveList");
            guildHomeFloatTitleLayout2 = null;
        }
        DragFrameLayout dragFrameLayout = this.dragHost;
        if (dragFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragHost");
            dragFrameLayout = null;
        }
        guildHomeFloatTitleLayout2.l(dragFrameLayout, U9());
        FrameLayout frameLayout2 = this.frameLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
            frameLayout2 = null;
        }
        GuildHomeFloatTitleLayout guildHomeFloatTitleLayout3 = this.headTitleAboveList;
        if (guildHomeFloatTitleLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headTitleAboveList");
        } else {
            guildHomeFloatTitleLayout = guildHomeFloatTitleLayout3;
        }
        frameLayout2.addView(guildHomeFloatTitleLayout);
        initData();
    }

    @Override // com.tencent.mobileqq.guild.home.parts.a, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        A9().h(this.onStateUpdate);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        A9().C(this.onStateUpdate);
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/home/parts/GuildHomeFloatTitlePart$b", "Lar1/h$b;", "", "b", "a", "Lzq1/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements h.b {
        b() {
        }

        @Override // ar1.h.b
        public void c(@NotNull zq1.e item) {
            Intrinsics.checkNotNullParameter(item, "item");
            String str = GuildHomeFloatTitlePart.this.z9().f227656e;
            Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
            GuildNoticeKtKt.b(str, 6, null);
            String str2 = GuildHomeFloatTitlePart.this.z9().f227656e;
            Intrinsics.checkNotNullExpressionValue(str2, "facadeArgsData.guildId");
            GuildNoticeKtKt.b(str2, 7, null);
        }

        @Override // ar1.h.b
        public void a() {
        }

        @Override // ar1.h.b
        public void b() {
        }
    }
}
