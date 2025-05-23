package com.tencent.mobileqq.guild.homev2.live.part;

import android.animation.AnimatorInflater;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.QQGuildSubChannelCreateDialogFragment;
import com.tencent.mobileqq.guild.channel.manage.feedsquare.GuildChannelManageFragment;
import com.tencent.mobileqq.guild.homev2.live.viewmodel.GuildAVListContentViewModel;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00011B/\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010!\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/live/part/GuildAVPermissionEntrancePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "initView", "R9", "initData", "", "M9", "L9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "", "d", "Ljava/lang/String;", "mGuildId", "e", "mCategoryId", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mTitleBarRightIv", "", tl.h.F, "I", "mCategoryType", "i", "mSceneType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "mCreateBtnContainer", "Lcom/tencent/mobileqq/guild/homev2/live/viewmodel/d;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/homev2/live/viewmodel/d;", "mViewModel", "Lcom/tencent/mobileqq/guild/homev2/live/viewmodel/GuildAVListContentViewModel;", "D", "Lcom/tencent/mobileqq/guild/homev2/live/viewmodel/GuildAVListContentViewModel;", "guildAVListContentViewModel", "Landroidx/lifecycle/MediatorLiveData;", "E", "Landroidx/lifecycle/MediatorLiveData;", "isCanShowCreateIconButton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/widget/ImageView;II)V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildAVPermissionEntrancePart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.homev2.live.viewmodel.d mViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private GuildAVListContentViewModel guildAVListContentViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private MediatorLiveData<Boolean> isCanShowCreateIconButton;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mGuildId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mCategoryId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView mTitleBarRightIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int mCategoryType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int mSceneType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View mCreateBtnContainer;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f225825a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildAVPermissionEntrancePart f225826b;

        public b(ViewModelStoreOwner viewModelStoreOwner, GuildAVPermissionEntrancePart guildAVPermissionEntrancePart) {
            this.f225825a = viewModelStoreOwner;
            this.f225826b = guildAVPermissionEntrancePart;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new com.tencent.mobileqq.guild.homev2.live.viewmodel.d(this.f225826b.mGuildId, this.f225826b.mCategoryId, this.f225826b.mSceneType), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f225827a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildAVPermissionEntrancePart f225828b;

        public c(ViewModelStoreOwner viewModelStoreOwner, GuildAVPermissionEntrancePart guildAVPermissionEntrancePart) {
            this.f225827a = viewModelStoreOwner;
            this.f225828b = guildAVPermissionEntrancePart;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new GuildAVListContentViewModel(this.f225828b.mGuildId, this.f225828b.mCategoryType, this.f225828b.mSceneType), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f225829d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildAVPermissionEntrancePart f225830e;

        public d(View view, GuildAVPermissionEntrancePart guildAVPermissionEntrancePart) {
            this.f225829d = view;
            this.f225830e = guildAVPermissionEntrancePart;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                this.f225830e.R9();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f225831d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildAVPermissionEntrancePart f225832e;

        public e(View view, GuildAVPermissionEntrancePart guildAVPermissionEntrancePart) {
            this.f225831d = view;
            this.f225832e = guildAVPermissionEntrancePart;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                GuildChannelManageFragment.Companion companion = GuildChannelManageFragment.INSTANCE;
                Context context = this.f225832e.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                companion.a(context, this.f225832e.mGuildId, this.f225832e.mCategoryType);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public GuildAVPermissionEntrancePart(@NotNull String mGuildId, @NotNull String mCategoryId, @NotNull ImageView mTitleBarRightIv, int i3, int i16) {
        Intrinsics.checkNotNullParameter(mGuildId, "mGuildId");
        Intrinsics.checkNotNullParameter(mCategoryId, "mCategoryId");
        Intrinsics.checkNotNullParameter(mTitleBarRightIv, "mTitleBarRightIv");
        this.mGuildId = mGuildId;
        this.mCategoryId = mCategoryId;
        this.mTitleBarRightIv = mTitleBarRightIv;
        this.mCategoryType = i3;
        this.mSceneType = i16;
    }

    private final void L9() {
        String str;
        VideoReport.setElementId(this.mTitleBarRightIv, "em_sgrp_config");
        int i3 = this.mCategoryType;
        if (i3 != 3) {
            if (i3 != 9) {
                str = "";
            } else {
                str = "em_sgrp_create_new_voice";
            }
        } else {
            str = "em_sgrp_create_new_stream";
        }
        View view = this.mCreateBtnContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCreateBtnContainer");
            view = null;
        }
        VideoReport.setElementId(view, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean M9() {
        boolean z16;
        com.tencent.mobileqq.guild.homev2.live.viewmodel.d dVar = this.mViewModel;
        GuildAVListContentViewModel guildAVListContentViewModel = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            dVar = null;
        }
        boolean z17 = !Intrinsics.areEqual(dVar.Q1().getValue(), Boolean.FALSE);
        GuildAVListContentViewModel guildAVListContentViewModel2 = this.guildAVListContentViewModel;
        if (guildAVListContentViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildAVListContentViewModel");
        } else {
            guildAVListContentViewModel = guildAVListContentViewModel2;
        }
        List<pp1.g> value = guildAVListContentViewModel.Q1().getValue();
        if (value != null && !value.isEmpty()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!(!z16) && z17) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildLivePermissionEntrancePart", 1, "openCreateChannelPage, " + this.mGuildId);
        }
        Activity hostActivity = getPartHost().getHostActivity();
        if (!(hostActivity instanceof FragmentActivity)) {
            return;
        }
        CreateSubChannelInfo createSubChannelInfo = new CreateSubChannelInfo(this.mGuildId, MiscKt.l(this.mCategoryId), "list_setting");
        int i3 = this.mCategoryType;
        int i16 = 5;
        if (i3 != 3 && i3 == 9) {
            i16 = 2;
        }
        createSubChannelInfo.f214824h = i16;
        createSubChannelInfo.f214826m = "\u53d6\u6d88";
        QQGuildSubChannelCreateDialogFragment.Eh(createSubChannelInfo).show(((FragmentActivity) hostActivity).getSupportFragmentManager(), "GuildLivePermissionEntrancePart");
    }

    private final void initData() {
        c.Companion companion = ef1.c.INSTANCE;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
        ViewModel viewModel = new ViewModelProvider(partHost, new b(partHost, this)).get(com.tencent.mobileqq.guild.homev2.live.viewmodel.d.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.mViewModel = (com.tencent.mobileqq.guild.homev2.live.viewmodel.d) viewModel;
        IPartHost partHost2 = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost2, "partHost");
        ViewModel viewModel2 = new ViewModelProvider(partHost2, new c(partHost2, this)).get(GuildAVListContentViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.guildAVListContentViewModel = (GuildAVListContentViewModel) viewModel2;
        MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>();
        com.tencent.mobileqq.guild.homev2.live.viewmodel.d dVar = this.mViewModel;
        com.tencent.mobileqq.guild.homev2.live.viewmodel.d dVar2 = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            dVar = null;
        }
        LiveData Q1 = dVar.Q1();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.live.part.GuildAVPermissionEntrancePart$initData$3$1
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
                MediatorLiveData mediatorLiveData2;
                boolean M9;
                mediatorLiveData2 = GuildAVPermissionEntrancePart.this.isCanShowCreateIconButton;
                if (mediatorLiveData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("isCanShowCreateIconButton");
                    mediatorLiveData2 = null;
                }
                M9 = GuildAVPermissionEntrancePart.this.M9();
                mediatorLiveData2.setValue(Boolean.valueOf(M9));
            }
        };
        mediatorLiveData.addSource(Q1, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.live.part.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildAVPermissionEntrancePart.N9(Function1.this, obj);
            }
        });
        GuildAVListContentViewModel guildAVListContentViewModel = this.guildAVListContentViewModel;
        if (guildAVListContentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildAVListContentViewModel");
            guildAVListContentViewModel = null;
        }
        LiveData Q12 = guildAVListContentViewModel.Q1();
        final Function1<List<? extends pp1.g>, Unit> function12 = new Function1<List<? extends pp1.g>, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.live.part.GuildAVPermissionEntrancePart$initData$3$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends pp1.g> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends pp1.g> list) {
                MediatorLiveData mediatorLiveData2;
                boolean M9;
                mediatorLiveData2 = GuildAVPermissionEntrancePart.this.isCanShowCreateIconButton;
                if (mediatorLiveData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("isCanShowCreateIconButton");
                    mediatorLiveData2 = null;
                }
                M9 = GuildAVPermissionEntrancePart.this.M9();
                mediatorLiveData2.setValue(Boolean.valueOf(M9));
            }
        };
        mediatorLiveData.addSource(Q12, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.live.part.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildAVPermissionEntrancePart.O9(Function1.this, obj);
            }
        });
        this.isCanShowCreateIconButton = mediatorLiveData;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.live.part.GuildAVPermissionEntrancePart$initData$4
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
            public final void invoke2(Boolean canShow) {
                View view;
                view = GuildAVPermissionEntrancePart.this.mCreateBtnContainer;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCreateBtnContainer");
                    view = null;
                }
                Intrinsics.checkNotNullExpressionValue(canShow, "canShow");
                view.setVisibility(canShow.booleanValue() ? 0 : 8);
            }
        };
        mediatorLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.live.part.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildAVPermissionEntrancePart.P9(Function1.this, obj);
            }
        });
        com.tencent.mobileqq.guild.homev2.live.viewmodel.d dVar3 = this.mViewModel;
        if (dVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            dVar2 = dVar3;
        }
        LiveData<Boolean> R1 = dVar2.R1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.live.part.GuildAVPermissionEntrancePart$initData$5
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
            public final void invoke2(Boolean canManage) {
                ImageView imageView;
                imageView = GuildAVPermissionEntrancePart.this.mTitleBarRightIv;
                Intrinsics.checkNotNullExpressionValue(canManage, "canManage");
                imageView.setVisibility(canManage.booleanValue() ? 0 : 8);
            }
        };
        R1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.live.part.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildAVPermissionEntrancePart.Q9(Function1.this, obj);
            }
        });
    }

    private final void initView() {
        View findViewById = getPartRootView().findViewById(R.id.uap);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.create_channel)");
        this.mCreateBtnContainer = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCreateBtnContainer");
            findViewById = null;
        }
        findViewById.setOnClickListener(new d(findViewById, this));
        GuildUIUtils.d(this.mTitleBarRightIv, R.drawable.guild_icon_settings, Integer.valueOf(R.color.qui_common_icon_primary));
        ImageView imageView = this.mTitleBarRightIv;
        imageView.setStateListAnimator(AnimatorInflater.loadStateListAnimator(imageView.getContext(), R.animator.f155134n));
        ImageView imageView2 = this.mTitleBarRightIv;
        imageView2.setOnClickListener(new e(imageView2, this));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initView();
        initData();
        L9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        com.tencent.mobileqq.guild.homev2.live.viewmodel.d dVar = this.mViewModel;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            dVar = null;
        }
        dVar.S1("onPartResume");
    }
}
