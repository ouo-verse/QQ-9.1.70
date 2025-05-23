package com.tencent.mobileqq.guild.setting.group;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingFragment;
import com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.troopbindguild.api.ITroopBindGuildApi;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\r*\u0001\u001b\u0018\u0000 M2\u00020\u0001:\u0002NOB\u0007\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\u000f\u0010\u001c\u001a\u00020\u001bH\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u0002H\u0002J\b\u0010\"\u001a\u00020!H\u0014J\u001a\u0010%\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\b\u0010&\u001a\u00020\bH\u0016J\b\u0010'\u001a\u00020\bH\u0016J\b\u0010(\u001a\u00020\bH\u0016J\b\u0010)\u001a\u00020\u0002H\u0016R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010+R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010?\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010B\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010@R\u0016\u0010H\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010@\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initData", "Landroid/view/View;", "view", "initView", "Kh", "", "enable", "Rh", "Jh", "Lcom/tencent/mobileqq/guild/setting/group/p;", "groupChatData", "Wh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "it", "Vh", "Lcom/tencent/mobileqq/guild/setting/group/GroupType;", "type", "Qh", "Ph", "data", "Oh", "Nh", "Gh", "Sh", "com/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$e", "Ih", "()Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$e;", "Landroidx/recyclerview/widget/ItemTouchHelper;", "Hh", "initDtReport", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onBackEvent", "needStatusTrans", "needImmersive", "onResume", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "immersiveBar", "D", "saveButton", "E", "cancelButton", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/guild/setting/group/q;", "G", "Lcom/tencent/mobileqq/guild/setting/group/q;", "adapter", "Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingViewModel;", "H", "Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingViewModel;", "viewModel", "I", "Landroidx/recyclerview/widget/ItemTouchHelper;", "itemTouchHelper", "J", "Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$e;", "scrollListener", "", "K", "guildId", "L", "Z", "isEdited", "M", "createGroupCode", "<init>", "()V", "N", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildBindGroupSettingFragment extends QPublicBaseFragment {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static WeakReference<fp1.a> P;

    /* renamed from: C, reason: from kotlin metadata */
    private View immersiveBar;

    /* renamed from: D, reason: from kotlin metadata */
    private View saveButton;

    /* renamed from: E, reason: from kotlin metadata */
    private View cancelButton;

    /* renamed from: F, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: G, reason: from kotlin metadata */
    private q adapter;

    /* renamed from: H, reason: from kotlin metadata */
    private GuildBindGroupSettingViewModel viewModel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ItemTouchHelper itemTouchHelper = Hh();

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final e scrollListener = Ih();

    /* renamed from: K, reason: from kotlin metadata */
    private long guildId;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isEdited;

    /* renamed from: M, reason: from kotlin metadata */
    private long createGroupCode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u00e7\u0001\u0012!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002\u0012!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\u0002\u0012!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00070\u0002\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015\u0012!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00070\u0002\u0012!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00070\u0002\u0012!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00070\u0002\u00a2\u0006\u0004\b#\u0010$R2\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR2\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000bR2\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00070\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018R2\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00070\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\b\u0010\u000bR2\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00070\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u001c\u0010\u000bR2\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00070\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\t\u001a\u0004\b\u0016\u0010\u000b\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$a;", "", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/setting/group/p;", "Lkotlin/ParameterName;", "name", "groupId", "", "a", "Lkotlin/jvm/functions/Function1;", "g", "()Lkotlin/jvm/functions/Function1;", "updateGroupBindState", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "b", "f", "startDragViewHolder", "data", "c", "jumpToGroupAIO", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "jumpToCreateGroup", "Landroid/view/View;", "view", "e", "changeSortState", "Lcom/tencent/mobileqq/guild/setting/group/GroupType;", "type", "onToggleGroupState", NotifyMsgApiImpl.KEY_GROUP_TYPE, "onShowMore", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<GroupChatData, Unit> updateGroupBindState;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<RecyclerView.ViewHolder, Unit> startDragViewHolder;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<GroupChatData, Unit> jumpToGroupAIO;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function0<Unit> jumpToCreateGroup;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<View, Unit> changeSortState;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<GroupType, Unit> onToggleGroupState;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<GroupType, Unit> onShowMore;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull Function1<? super GroupChatData, Unit> updateGroupBindState, @NotNull Function1<? super RecyclerView.ViewHolder, Unit> startDragViewHolder, @NotNull Function1<? super GroupChatData, Unit> jumpToGroupAIO, @NotNull Function0<Unit> jumpToCreateGroup, @NotNull Function1<? super View, Unit> changeSortState, @NotNull Function1<? super GroupType, Unit> onToggleGroupState, @NotNull Function1<? super GroupType, Unit> onShowMore) {
            Intrinsics.checkNotNullParameter(updateGroupBindState, "updateGroupBindState");
            Intrinsics.checkNotNullParameter(startDragViewHolder, "startDragViewHolder");
            Intrinsics.checkNotNullParameter(jumpToGroupAIO, "jumpToGroupAIO");
            Intrinsics.checkNotNullParameter(jumpToCreateGroup, "jumpToCreateGroup");
            Intrinsics.checkNotNullParameter(changeSortState, "changeSortState");
            Intrinsics.checkNotNullParameter(onToggleGroupState, "onToggleGroupState");
            Intrinsics.checkNotNullParameter(onShowMore, "onShowMore");
            this.updateGroupBindState = updateGroupBindState;
            this.startDragViewHolder = startDragViewHolder;
            this.jumpToGroupAIO = jumpToGroupAIO;
            this.jumpToCreateGroup = jumpToCreateGroup;
            this.changeSortState = changeSortState;
            this.onToggleGroupState = onToggleGroupState;
            this.onShowMore = onShowMore;
        }

        @NotNull
        public final Function1<View, Unit> a() {
            return this.changeSortState;
        }

        @NotNull
        public final Function0<Unit> b() {
            return this.jumpToCreateGroup;
        }

        @NotNull
        public final Function1<GroupChatData, Unit> c() {
            return this.jumpToGroupAIO;
        }

        @NotNull
        public final Function1<GroupType, Unit> d() {
            return this.onShowMore;
        }

        @NotNull
        public final Function1<GroupType, Unit> e() {
            return this.onToggleGroupState;
        }

        @NotNull
        public final Function1<RecyclerView.ViewHolder, Unit> f() {
            return this.startDragViewHolder;
        }

        @NotNull
        public final Function1<GroupChatData, Unit> g() {
            return this.updateGroupBindState;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fR\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$b;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "data", "", "d", "", "guildId", "Landroid/content/Context;", "context", "b", "", "groupCodeLongArray", "Lfp1/a;", "callback", "c", "PARAM_GROUP_CODE_LIST", "Ljava/lang/String;", "Ljava/lang/ref/WeakReference;", "dataCallback", "Ljava/lang/ref/WeakReference;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingFragment$b, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(ArrayList<Long> data) {
            fp1.a aVar;
            WeakReference weakReference = GuildBindGroupSettingFragment.P;
            if (weakReference != null && (aVar = (fp1.a) weakReference.get()) != null) {
                aVar.a(data);
            }
        }

        public final void b(@NotNull String guildId, @NotNull Context context) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("extra_guild_id", guildId);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            QPublicFragmentActivity.start(context, intent, GuildBindGroupSettingFragment.class);
        }

        public final void c(@NotNull long[] groupCodeLongArray, @NotNull fp1.a callback) {
            Intrinsics.checkNotNullParameter(groupCodeLongArray, "groupCodeLongArray");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intent intent = new Intent();
            intent.putExtra("param_group_code_list", groupCodeLongArray);
            GuildBindGroupSettingFragment.P = new WeakReference(callback);
            QPublicFragmentActivity.b.d(intent, QPublicFragmentActivity.class, GuildBindGroupSettingFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            GuildBindGroupSettingFragment guildBindGroupSettingFragment = GuildBindGroupSettingFragment.this;
            GuildBindGroupSettingViewModel guildBindGroupSettingViewModel = guildBindGroupSettingFragment.viewModel;
            if (guildBindGroupSettingViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildBindGroupSettingViewModel = null;
            }
            guildBindGroupSettingFragment.Rh(!guildBindGroupSettingViewModel.get_isSorting());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$d", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "isDragStart", "", "a", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "getMovementFlags", "target", "onMove", "direction", "onSwiped", "actionState", "onSelectedChanged", "clearView", "isLongPressDragEnabled", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends ItemTouchHelper.Callback {
        d() {
        }

        private final void a(RecyclerView.ViewHolder viewHolder, boolean isDragStart) {
            View view;
            float f16;
            if (viewHolder != null) {
                view = viewHolder.itemView;
            } else {
                view = null;
            }
            if (view != null) {
                try {
                    viewHolder.itemView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
                    View view2 = viewHolder.itemView;
                    if (isDragStart) {
                        f16 = 20.0f;
                    } else {
                        f16 = 0.0f;
                    }
                    view2.setTranslationZ(f16);
                } catch (Exception e16) {
                    Logger.f235387a.d().w(QPublicBaseFragment.TAG, 1, "setItemShadow " + e16);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            super.clearView(recyclerView, viewHolder);
            a(viewHolder, false);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
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
            Object tag = viewHolder.itemView.getTag();
            Object tag2 = target.itemView.getTag();
            if ((tag instanceof GroupChatData) && (tag2 instanceof GroupChatData)) {
                GuildBindGroupSettingViewModel guildBindGroupSettingViewModel = GuildBindGroupSettingFragment.this.viewModel;
                if (guildBindGroupSettingViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    guildBindGroupSettingViewModel = null;
                }
                guildBindGroupSettingViewModel.s2((GroupChatData) tag, (GroupChatData) tag2);
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
            super.onSelectedChanged(viewHolder, actionState);
            if (actionState == 2) {
                a(viewHolder, true);
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$e", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e extends RecyclerView.OnScrollListener {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState != 0) {
                return;
            }
            boolean z16 = recyclerView.getLayoutManager() instanceof LinearLayoutManager;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f<T> implements Observer {
        public f() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            List<T> list = (List) t16;
            q qVar = GuildBindGroupSettingFragment.this.adapter;
            if (qVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                qVar = null;
            }
            qVar.setItems(list);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g<T> implements Observer {
        public g() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            ((Boolean) t16).booleanValue();
            FragmentActivity activity = GuildBindGroupSettingFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$h", "Lcom/tencent/mobileqq/troop/troopcreate/api/ITroopCreatePage$a;", "", "troopUin", "", "isReuse", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h implements ITroopCreatePage.a {
        h() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(GuildBindGroupSettingFragment this$0, String troopUin) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
            this$0.createGroupCode = MiscKt.l(troopUin);
        }

        @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage.a
        public void a(@NotNull final String troopUin, boolean isReuse) {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            com.tencent.mobileqq.troop.troopcreate.a.i(GuildBindGroupSettingFragment.this.requireContext(), troopUin, null);
            final GuildBindGroupSettingFragment guildBindGroupSettingFragment = GuildBindGroupSettingFragment.this;
            kotlin.Function0.b(300, new Runnable() { // from class: com.tencent.mobileqq.guild.setting.group.v
                @Override // java.lang.Runnable
                public final void run() {
                    GuildBindGroupSettingFragment.h.c(GuildBindGroupSettingFragment.this, troopUin);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh(View view) {
        float f16;
        Map mapOf;
        if (com.tencent.mobileqq.guild.util.o.c("changeSortState")) {
            return;
        }
        boolean z16 = true;
        this.isEdited = true;
        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel = this.viewModel;
        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel2 = null;
        if (guildBindGroupSettingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildBindGroupSettingViewModel = null;
        }
        guildBindGroupSettingViewModel.e2();
        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel3 = this.viewModel;
        if (guildBindGroupSettingViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildBindGroupSettingViewModel3 = null;
        }
        if (guildBindGroupSettingViewModel3.get_isSorting()) {
            f16 = 0.3f;
        } else {
            f16 = 1.0f;
        }
        View view2 = this.saveButton;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
            view2 = null;
        }
        if (view2.getAlpha() != f16) {
            z16 = false;
        }
        if (!z16) {
            View view3 = this.saveButton;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("saveButton");
                view3 = null;
            }
            view3.animate().alpha(f16).setDuration(150L).setListener(new c()).start();
        }
        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel4 = this.viewModel;
        if (guildBindGroupSettingViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildBindGroupSettingViewModel2 = guildBindGroupSettingViewModel4;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_show_group_num", Integer.valueOf(guildBindGroupSettingViewModel2.j2().size())));
        VideoReport.reportEvent("clck", view, mapOf);
    }

    private final ItemTouchHelper Hh() {
        return new ItemTouchHelper(new d());
    }

    private final e Ih() {
        return new e();
    }

    private final void Jh() {
        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel = this.viewModel;
        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel2 = null;
        if (guildBindGroupSettingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildBindGroupSettingViewModel = null;
        }
        if (guildBindGroupSettingViewModel.w2()) {
            Companion companion = INSTANCE;
            GuildBindGroupSettingViewModel guildBindGroupSettingViewModel3 = this.viewModel;
            if (guildBindGroupSettingViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                guildBindGroupSettingViewModel2 = guildBindGroupSettingViewModel3;
            }
            companion.d(new ArrayList(guildBindGroupSettingViewModel2.j2()));
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel4 = this.viewModel;
        if (guildBindGroupSettingViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildBindGroupSettingViewModel2 = guildBindGroupSettingViewModel4;
        }
        guildBindGroupSettingViewModel2.x2();
    }

    private final void Kh(View view) {
        Window window;
        View findViewById = view.findViewById(R.id.xl7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.immersive_bar)");
        this.immersiveBar = findViewById;
        View view2 = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("immersiveBar");
            findViewById = null;
        }
        findViewById.getLayoutParams().height = ImmersiveUtils.statusHeight;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            window = activity.getWindow();
        } else {
            window = null;
        }
        ImmersiveUtils.clearCoverForStatus(window, true);
        View findViewById2 = view.findViewById(R.id.tlh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.cancel_button)");
        this.cancelButton = findViewById2;
        View findViewById3 = view.findViewById(R.id.ifv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.save_button)");
        this.saveButton = findViewById3;
        View view3 = this.cancelButton;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
            view3 = null;
        }
        view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.group.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                GuildBindGroupSettingFragment.Lh(GuildBindGroupSettingFragment.this, view4);
            }
        });
        View view4 = this.saveButton;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        } else {
            view2 = view4;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.group.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                GuildBindGroupSettingFragment.Mh(GuildBindGroupSettingFragment.this, view5);
            }
        });
        Rh(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(GuildBindGroupSettingFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(GuildBindGroupSettingFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Jh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nh() {
        String valueOf;
        if (getActivity() == null) {
            return;
        }
        ITroopCreatePage iTroopCreatePage = (ITroopCreatePage) QRoute.api(ITroopCreatePage.class);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        long j3 = this.guildId;
        if (j3 == 0) {
            valueOf = null;
        } else {
            valueOf = String.valueOf(j3);
        }
        iTroopCreatePage.launchCreatePageFromGuild(requireActivity, valueOf, new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oh(GroupChatData data) {
        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel = this.viewModel;
        if (guildBindGroupSettingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildBindGroupSettingViewModel = null;
        }
        if (guildBindGroupSettingViewModel.get_isSorting()) {
            return;
        }
        if (data.getGroupData().getIsGroupMember()) {
            com.tencent.mobileqq.troop.troopcreate.a.i(requireContext(), String.valueOf(data.getGroupData().getGroupCode()), data.getGroupData().getGroupName());
        } else {
            ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).openTroopInfoActivity(getContext(), aq.e(String.valueOf(data.getGroupData().getGroupCode()), data.getGroupData().getSignature().toString(), 1016, String.valueOf(this.guildId)), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph(GroupType type) {
        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel = this.viewModel;
        if (guildBindGroupSettingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildBindGroupSettingViewModel = null;
        }
        guildBindGroupSettingViewModel.u2(type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh(GroupType type) {
        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel = this.viewModel;
        if (guildBindGroupSettingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildBindGroupSettingViewModel = null;
        }
        guildBindGroupSettingViewModel.v2(type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rh(boolean enable) {
        float f16;
        View view = this.saveButton;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
            view = null;
        }
        view.setEnabled(enable);
        View view3 = this.saveButton;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        } else {
            view2 = view3;
        }
        if (enable) {
            f16 = 1.0f;
        } else {
            f16 = 0.3f;
        }
        view2.setAlpha(f16);
    }

    private final void Sh() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(requireActivity(), 230, (String) null, getString(R.string.f140760eu), getString(R.string.f1513017b), getString(R.string.f155081gj), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.group.r
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildBindGroupSettingFragment.Th(GuildBindGroupSettingFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.group.s
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildBindGroupSettingFragment.Uh(GuildBindGroupSettingFragment.this, dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026ity?.finish() }\n        )");
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(GuildBindGroupSettingFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Jh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(GuildBindGroupSettingFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(RecyclerView.ViewHolder it) {
        this.itemTouchHelper.startDrag(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh(GroupChatData groupChatData) {
        boolean z16;
        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel = null;
        if (!groupChatData.getIsBindGroup()) {
            ITroopBindGuildApi.TroopBindGuildInfo bindGuildInfoFromExtInfo = ((ITroopBindGuildApi) QRoute.api(ITroopBindGuildApi.class)).getBindGuildInfoFromExtInfo(String.valueOf(groupChatData.getId()));
            if (bindGuildInfoFromExtInfo != null && !bindGuildInfoFromExtInfo.getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH java.lang.String()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QQToastUtil.showQQToast(0, getString(R.string.f140830f1));
                return;
            }
            if (groupChatData.getIsBindLimited()) {
                Object[] objArr = new Object[1];
                GuildBindGroupSettingViewModel guildBindGroupSettingViewModel2 = this.viewModel;
                if (guildBindGroupSettingViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    guildBindGroupSettingViewModel = guildBindGroupSettingViewModel2;
                }
                objArr[0] = Integer.valueOf(guildBindGroupSettingViewModel.get_bindGroupLimit());
                QQToastUtil.showQQToast(0, getString(R.string.f140770ev, objArr));
                return;
            }
        }
        this.isEdited = true;
        Rh(true);
        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel3 = this.viewModel;
        if (guildBindGroupSettingViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildBindGroupSettingViewModel = guildBindGroupSettingViewModel3;
        }
        guildBindGroupSettingViewModel.z2(groupChatData);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initData() {
        long j3;
        List<Long> list;
        Intent intent;
        long[] longArrayExtra;
        Intent intent2;
        Long longOrNull;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent2 = activity.getIntent()) != null && (r0 = intent2.getStringExtra("extra_guild_id")) != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        this.guildId = j3;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null && (longArrayExtra = intent.getLongArrayExtra("param_group_code_list")) != null) {
            list = ArraysKt___ArraysKt.toList(longArrayExtra);
        } else {
            list = null;
        }
        GuildBindGroupSettingViewModel.Companion companion = GuildBindGroupSettingViewModel.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        this.viewModel = companion.a(requireActivity, this.guildId, list);
        this.adapter = new q(new a(new GuildBindGroupSettingFragment$initData$1(this), new GuildBindGroupSettingFragment$initData$2(this), new GuildBindGroupSettingFragment$initData$3(this), new GuildBindGroupSettingFragment$initData$4(this), new GuildBindGroupSettingFragment$initData$5(this), new GuildBindGroupSettingFragment$initData$6(this), new GuildBindGroupSettingFragment$initData$7(this)));
    }

    private final void initDtReport() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(getView(), "pg_sgrp_show_group_set");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_channel_id", Long.valueOf(this.guildId));
        hashMap.put("sgrp_user_type", "1");
        com.tencent.mobileqq.guild.data.w.c(hashMap);
        VideoReport.setPageParams(getView(), new PageParams(hashMap));
    }

    private final void initView(View view) {
        Kh(view);
        View findViewById = view.findViewById(R.id.b9y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.content_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.recyclerView = recyclerView;
        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        q qVar = this.adapter;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            qVar = null;
        }
        recyclerView2.setAdapter(qVar);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setItemAnimator(new o());
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        recyclerView4.addOnScrollListener(this.scrollListener);
        ItemTouchHelper itemTouchHelper = this.itemTouchHelper;
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView5 = null;
        }
        itemTouchHelper.attachToRecyclerView(recyclerView5);
        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel2 = this.viewModel;
        if (guildBindGroupSettingViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildBindGroupSettingViewModel2 = null;
        }
        guildBindGroupSettingViewModel2.n2().observe(this, new f());
        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel3 = this.viewModel;
        if (guildBindGroupSettingViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildBindGroupSettingViewModel = guildBindGroupSettingViewModel3;
        }
        guildBindGroupSettingViewModel.q2().observe(this, new g());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.egx;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (this.isEdited) {
            Sh();
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.createGroupCode != 0) {
            GuildBindGroupSettingViewModel guildBindGroupSettingViewModel = this.viewModel;
            if (guildBindGroupSettingViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildBindGroupSettingViewModel = null;
            }
            guildBindGroupSettingViewModel.p2(this.createGroupCode);
            this.createGroupCode = 0L;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView(view);
        initDtReport();
    }
}
