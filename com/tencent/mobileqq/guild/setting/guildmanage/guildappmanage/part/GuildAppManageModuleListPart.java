package com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.guild.channel.manage.feedsquare.GuildChannelManageFragment;
import com.tencent.mobileqq.guild.home.schedule.list.GuildHomeScheduleListFragment;
import com.tencent.mobileqq.guild.homev2.parts.GuildNavigatorPart;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.viewmodel.GuildApplicationManageViewModel;
import com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.ConfigIconItem;
import com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigAddConfigFragment;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kz1.n;
import mz1.AdditionAppItem;
import mz1.NavigatorItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pr1.VisitorColorPicker;

@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t*\u00013\u0018\u0000 I2\u00020\u0001:\u0001JB\u0017\u0012\u0006\u0010$\u001a\u00020\u001f\u0012\u0006\u0010*\u001a\u00020%\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\"\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016R\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010*\u001a\u00020%8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u00109\u001a\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u00109\u001a\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/part/GuildAppManageModuleListPart;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/part/a;", "", "R9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "V9", "Z9", "", "categoryType", "W9", "Lmz1/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "X9", "S9", "Y9", "Q9", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "M9", "Lmz1/i;", "navigatorItem", "P9", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/app/QBaseFragment;", "e", "Lcom/tencent/mobileqq/app/QBaseFragment;", "L9", "()Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", "Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/viewmodel/GuildApplicationManageViewModel;", "f", "Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/viewmodel/GuildApplicationManageViewModel;", "O9", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/viewmodel/GuildApplicationManageViewModel;", "viewModel", "", tl.h.F, "Z", "isBackgroundColorLight", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "modelListRv", "com/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/part/GuildAppManageModuleListPart$modelClickIoc$1", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/part/GuildAppManageModuleListPart$modelClickIoc$1;", "modelClickIoc", "Lkz1/n;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "J9", "()Lkz1/n;", "adapter", "Landroidx/recyclerview/widget/ItemTouchHelper;", "D", "N9", "()Landroidx/recyclerview/widget/ItemTouchHelper;", "touchHelper", "Lcom/google/android/flexbox/FlexboxLayoutManager;", "E", "K9", "()Lcom/google/android/flexbox/FlexboxLayoutManager;", "flexboxLayoutManager", "<init>", "(Lcom/tencent/mobileqq/app/QBaseFragment;Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/viewmodel/GuildApplicationManageViewModel;)V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildAppManageModuleListPart extends a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy touchHelper;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy flexboxLayoutManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QBaseFragment fragment;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildApplicationManageViewModel viewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isBackgroundColorLight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView modelListRv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildAppManageModuleListPart$modelClickIoc$1 modelClickIoc;

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/part/GuildAppManageModuleListPart$b", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "getMovementFlags", "target", "", "onMove", "direction", "", "onSwiped", "isLongPressDragEnabled", "actionState", "onSelectedChanged", "clearView", "a", "I", "getHolderMoveStart", "()I", "setHolderMoveStart", "(I)V", "holderMoveStart", "b", "getHolderMoveEnd", "setHolderMoveEnd", "holderMoveEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends ItemTouchHelper.Callback {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int holderMoveStart = -1;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int holderMoveEnd = -1;

        b() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            super.clearView(recyclerView, viewHolder);
            if (viewHolder instanceof kz1.f) {
                ((kz1.f) viewHolder).J(false);
            }
            GuildAppManageModuleListPart.this.getViewModel().p2(this.holderMoveStart, this.holderMoveEnd);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            return ItemTouchHelper.Callback.makeFlag(2, 15) | ItemTouchHelper.Callback.makeFlag(0, 15);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(target, "target");
            int adapterPosition = viewHolder.getAdapterPosition();
            int adapterPosition2 = target.getAdapterPosition();
            Object tag = viewHolder.itemView.getTag();
            Object tag2 = target.itemView.getTag();
            if ((tag instanceof mz1.c) && (tag2 instanceof mz1.c) && GuildAppManageModuleListPart.this.getViewModel().l2((mz1.c) tag, (mz1.c) tag2)) {
                this.holderMoveEnd = adapterPosition2;
                GuildAppManageModuleListPart.this.J9().notifyItemMoved(adapterPosition, adapterPosition2);
                return true;
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
            int i3;
            super.onSelectedChanged(viewHolder, actionState);
            if (actionState == 2) {
                if (viewHolder != null) {
                    i3 = viewHolder.getAdapterPosition();
                } else {
                    i3 = -1;
                }
                this.holderMoveStart = i3;
                this.holderMoveEnd = i3;
                if (viewHolder instanceof kz1.f) {
                    ((kz1.f) viewHolder).J(true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.GuildAppManageModuleListPart$modelClickIoc$1] */
    public GuildAppManageModuleListPart(@NotNull QBaseFragment fragment, @NotNull GuildApplicationManageViewModel viewModel) {
        super(viewModel);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.fragment = fragment;
        this.viewModel = viewModel;
        this.isBackgroundColorLight = true;
        this.modelClickIoc = new lz1.a() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.GuildAppManageModuleListPart$modelClickIoc$1
            @Override // lz1.a
            public void a() {
                GuildAppManageModuleListPart.this.getViewModel().S1(1);
            }

            @Override // lz1.a
            public void b(@NotNull kz1.f viewHolder) {
                ItemTouchHelper N9;
                Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
                N9 = GuildAppManageModuleListPart.this.N9();
                N9.startDrag(viewHolder);
            }

            @Override // lz1.a
            public void c(@NotNull AdditionAppItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                GuildApplicationManageViewModel viewModel2 = GuildAppManageModuleListPart.this.getViewModel();
                final GuildAppManageModuleListPart guildAppManageModuleListPart = GuildAppManageModuleListPart.this;
                viewModel2.Q1(item, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.GuildAppManageModuleListPart$modelClickIoc$1$clickToShowAdditionAppItem$1
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
                        GuildAppManageModuleListPart.this.Z9();
                    }
                });
            }

            @Override // lz1.a
            @Nullable
            public Integer d() {
                return GuildAppManageModuleListPart.this.getViewModel().f2().getValue();
            }

            @Override // lz1.a
            public void e(@NotNull AdditionAppItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                int jumpType = item.getJumpType();
                if (jumpType != 2 && jumpType != 3) {
                    if (jumpType != 7) {
                        switch (jumpType) {
                            case 9:
                                break;
                            case 10:
                                GuildAppManageModuleListPart.this.Q9();
                                return;
                            case 11:
                                GuildAppManageModuleListPart.this.getViewModel().r2(item);
                                GuildAppManageModuleListPart.this.P9(item.getNavigation());
                                return;
                            default:
                                return;
                        }
                    } else {
                        GuildAppManageModuleListPart.this.X9(item);
                        return;
                    }
                }
                GuildAppManageModuleListPart.this.W9(item.getJumpType());
            }

            @Override // lz1.a
            public void f(@NotNull View view, @NotNull mz1.d item) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(item, "item");
                if (!item.getIsOverServiceNumber()) {
                    GuildAppManageModuleListPart.this.getViewModel().r2(item);
                    GuildAppManageModuleListPart.this.P9(null);
                } else {
                    VideoReport.reportEvent("imp", view, null);
                    QQToastUtil.showQQToast(1, "\u81ea\u5b9a\u4e49\u5e94\u7528\u5df2\u8fbe\u4e0a\u9650");
                }
            }

            @Override // lz1.a
            public void g(@NotNull AdditionAppItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                GuildApplicationManageViewModel viewModel2 = GuildAppManageModuleListPart.this.getViewModel();
                final GuildAppManageModuleListPart guildAppManageModuleListPart = GuildAppManageModuleListPart.this;
                viewModel2.q2(item, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.GuildAppManageModuleListPart$modelClickIoc$1$clickToRemoveShowAdditionAppItem$1
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
                        GuildAppManageModuleListPart.this.Z9();
                    }
                });
            }
        };
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<n>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.GuildAppManageModuleListPart$adapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final n invoke() {
                GuildAppManageModuleListPart$modelClickIoc$1 guildAppManageModuleListPart$modelClickIoc$1;
                guildAppManageModuleListPart$modelClickIoc$1 = GuildAppManageModuleListPart.this.modelClickIoc;
                return new n(guildAppManageModuleListPart$modelClickIoc$1);
            }
        });
        this.adapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ItemTouchHelper>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.GuildAppManageModuleListPart$touchHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ItemTouchHelper invoke() {
                ItemTouchHelper.Callback M9;
                M9 = GuildAppManageModuleListPart.this.M9();
                return new ItemTouchHelper(M9);
            }
        });
        this.touchHelper = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<FlexboxLayoutManager>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.GuildAppManageModuleListPart$flexboxLayoutManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FlexboxLayoutManager invoke() {
                FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(GuildAppManageModuleListPart.this.getContext());
                flexboxLayoutManager.Z(0);
                flexboxLayoutManager.b0(0);
                return flexboxLayoutManager;
            }
        });
        this.flexboxLayoutManager = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n J9() {
        return (n) this.adapter.getValue();
    }

    private final FlexboxLayoutManager K9() {
        return (FlexboxLayoutManager) this.flexboxLayoutManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ItemTouchHelper.Callback M9() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ItemTouchHelper N9() {
        return (ItemTouchHelper) this.touchHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(final NavigatorItem navigatorItem) {
        getViewModel().a2(new Function3<Boolean, String, List<? extends IGProGuildNavIconTheme>, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.GuildAppManageModuleListPart$goToAddNavigatorConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str, List<? extends IGProGuildNavIconTheme> list) {
                invoke(bool.booleanValue(), str, list);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull String errMsg, @Nullable List<? extends IGProGuildNavIconTheme> list) {
                Object obj;
                List list2;
                ArrayList<IGProGuildNavIconInfo> icons;
                int collectionSizeOrDefault;
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                if (z16) {
                    List<? extends IGProGuildNavIconTheme> list3 = list;
                    if (!(list3 == null || list3.isEmpty())) {
                        Iterator<T> it = list.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                obj = it.next();
                                if (Intrinsics.areEqual(((IGProGuildNavIconTheme) obj).getIconSelectorColor(), "black")) {
                                    break;
                                }
                            } else {
                                obj = null;
                                break;
                            }
                        }
                        IGProGuildNavIconTheme iGProGuildNavIconTheme = (IGProGuildNavIconTheme) obj;
                        if (iGProGuildNavIconTheme == null || (icons = iGProGuildNavIconTheme.getIcons()) == null) {
                            list2 = null;
                        } else {
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(icons, 10);
                            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                            for (IGProGuildNavIconInfo it5 : icons) {
                                ConfigIconItem.Companion companion = ConfigIconItem.INSTANCE;
                                Intrinsics.checkNotNullExpressionValue(it5, "it");
                                arrayList.add(companion.a(it5));
                            }
                            list2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
                        }
                        ArrayList<ConfigIconItem> arrayList2 = list2 instanceof ArrayList ? (ArrayList) list2 : null;
                        QQGuildNavigatorConfigAddConfigFragment.a aVar = QQGuildNavigatorConfigAddConfigFragment.f234006e0;
                        QBaseFragment fragment = GuildAppManageModuleListPart.this.getFragment();
                        ArrayList<ConfigIconItem> arrayList3 = arrayList2 == null ? new ArrayList<>() : arrayList2;
                        String guildId = GuildAppManageModuleListPart.this.getViewModel().getGuildId();
                        NavigatorItem navigatorItem2 = navigatorItem;
                        Long valueOf = navigatorItem2 != null ? Long.valueOf(navigatorItem2.getIconId()) : null;
                        NavigatorItem navigatorItem3 = navigatorItem;
                        String iconUri = navigatorItem3 != null ? navigatorItem3.getIconUri() : null;
                        NavigatorItem navigatorItem4 = navigatorItem;
                        String configName = navigatorItem4 != null ? navigatorItem4.getConfigName() : null;
                        NavigatorItem navigatorItem5 = navigatorItem;
                        String magnet = navigatorItem5 != null ? navigatorItem5.getMagnet() : null;
                        NavigatorItem navigatorItem6 = navigatorItem;
                        aVar.a(fragment, arrayList3, arrayList2, guildId, valueOf, iconUri, configName, magnet, true, navigatorItem6 != null ? Long.valueOf(navigatorItem6.getCategoryId()) : null, 101);
                        return;
                    }
                }
                QQToastUtil.showQQToast(0, "\u83b7\u53d6\u5bfc\u822a\u680f\u56fe\u6807\u5931\u8d25\uff01(" + errMsg + ")");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9() {
        if (!getViewModel().getIsAllowCheckInCheck()) {
            Y9();
            return;
        }
        if (!TextUtils.isEmpty(getViewModel().getGuildId())) {
            String n3 = ch.n(GuildNavigatorPart.INSTANCE.c(), "guildId", getViewModel().getGuildId());
            if (QLog.isColorLevel()) {
                QLog.i("ModuleListPart", 2, "handleGuildSignInManageEnterClick:" + n3);
            }
            ch.i1(getActivity(), n3);
        }
    }

    private final void R9() {
        this.isBackgroundColorLight = VisitorColorPicker.INSTANCE.b(getContext().getResources().getColor(R.color.qui_common_bg_bottom_light));
    }

    private final void S9() {
        LiveData<Integer> f26 = getViewModel().f2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.GuildAppManageModuleListPart$initObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                GuildAppManageModuleListPart.this.Z9();
            }
        };
        f26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildAppManageModuleListPart.T9(Function1.this, obj);
            }
        });
        MutableLiveData<List<mz1.c>> e26 = getViewModel().e2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<List<? extends mz1.c>, Unit> function12 = new Function1<List<? extends mz1.c>, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.GuildAppManageModuleListPart$initObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends mz1.c> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends mz1.c> list) {
                GuildAppManageModuleListPart.this.J9().submitList(list);
            }
        };
        e26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildAppManageModuleListPart.U9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void V9(View rootView) {
        RecyclerView recyclerView;
        if (rootView != null) {
            recyclerView = (RecyclerView) rootView.findViewById(R.id.zd9);
        } else {
            recyclerView = null;
        }
        this.modelListRv = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(K9());
            recyclerView.setAdapter(J9());
            N9().attachToRecyclerView(recyclerView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9(int categoryType) {
        Activity activity = getActivity();
        if (activity != null) {
            GuildChannelManageFragment.INSTANCE.a(activity, getViewModel().getGuildId(), categoryType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(AdditionAppItem item) {
        String scheduleChannelId;
        Activity activity = getActivity();
        if (activity != null) {
            GuildHomeScheduleListFragment.Companion companion = GuildHomeScheduleListFragment.INSTANCE;
            String str = "";
            JumpGuildParam jumpGuildParam = new JumpGuildParam(getViewModel().getGuildId(), "");
            NavigatorItem navigation = item.getNavigation();
            if (navigation != null && (scheduleChannelId = navigation.getScheduleChannelId()) != null) {
                str = scheduleChannelId;
            }
            companion.a(activity, jumpGuildParam, str);
        }
    }

    private final void Y9() {
        ch.f1(HardCodeUtil.qqStr(R.string.f140840f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9() {
        RecyclerView recyclerView = this.modelListRv;
        if (recyclerView != null) {
            recyclerView.removeAllViews();
        }
        J9().notifyDataSetChanged();
    }

    @NotNull
    /* renamed from: L9, reason: from getter */
    public final QBaseFragment getFragment() {
        return this.fragment;
    }

    @NotNull
    /* renamed from: O9, reason: from getter */
    public GuildApplicationManageViewModel getViewModel() {
        return this.viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        long j3;
        String str;
        String str2;
        String str3;
        Integer num;
        String stringExtra;
        String stringExtra2;
        String stringExtra3;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == -1) {
            long j16 = -99;
            if (data != null) {
                j3 = data.getLongExtra("resIconId", -99L);
            } else {
                j3 = -99;
            }
            if (data == null || (stringExtra3 = data.getStringExtra("resIconUri")) == null) {
                str = "";
            } else {
                str = stringExtra3;
            }
            if (data == null || (stringExtra2 = data.getStringExtra("resConfigName")) == null) {
                str2 = "";
            } else {
                str2 = stringExtra2;
            }
            if (data == null || (stringExtra = data.getStringExtra("resMagnet")) == null) {
                str3 = "";
            } else {
                str3 = stringExtra;
            }
            if (data != null) {
                j16 = data.getLongExtra("resCategoryId", -99L);
            }
            long j17 = j16;
            if (data != null) {
                num = Integer.valueOf(data.getIntExtra("resAction", 0));
            } else {
                num = null;
            }
            NavigatorItem navigatorItem = new NavigatorItem(j3, str, str2, str3, j17, null, 32, null);
            if (num != null && num.intValue() == 3) {
                getViewModel().T1();
            } else {
                getViewModel().R1(navigatorItem);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        R9();
        V9(rootView);
        S9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
    }
}
