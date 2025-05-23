package com.tencent.mobileqq.guild.home.views.dialog;

import android.app.Dialog;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.CalendarEx;
import com.tencent.mobileqq.guild.base.extension.CalendarExKt;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi;
import com.tencent.mobileqq.guild.home.schedule.models.a;
import com.tencent.mobileqq.guild.home.schedule.viewmodels.GuildHomeScheduleViewModel;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import ef1.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 O2\u00020\u0001:\u0003PQRB\u0007\u00a2\u0006\u0004\bM\u0010NJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u000e\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010&R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020;0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001e\u0010I\u001a\n F*\u0004\u0018\u00010E0E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/dialog/ScheduleDateLocatorDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "newState", "", "Eh", "", "timeInMillis", "", "Ah", "Lcom/tencent/mobileqq/guild/home/schedule/models/a$b;", "calendarMonth", "Bh", "", "from", "Gh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/app/Dialog;", "onCreateDialog", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lcom/tencent/mobileqq/guild/home/views/dialog/ScheduleDateLocatorDialog$c;", "listener", "Fh", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroidx/recyclerview/widget/RecyclerView;", "D", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/GridLayoutManager;", "E", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildHomeScheduleViewModel;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildHomeScheduleViewModel;", "scheduleViewModel", "G", "weekdaysIndicator", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "yearIndicator", "", "Lcom/tencent/mobileqq/guild/home/schedule/models/a;", "I", "Ljava/util/List;", "calendarDays", "J", "Lcom/tencent/mobileqq/guild/home/views/dialog/ScheduleDateLocatorDialog$c;", "Lcom/tencent/mobileqq/guild/home/schedule/a;", "K", "Lcom/tencent/mobileqq/guild/home/schedule/a;", "adapter", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "L", "Ljava/util/Calendar;", "locateDate", "M", "Z", "isFirstRequest", "<init>", "()V", "N", "a", "b", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ScheduleDateLocatorDialog extends BottomSheetDialogFragment {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayout rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    private GridLayoutManager layoutManager;

    /* renamed from: F, reason: from kotlin metadata */
    private GuildHomeScheduleViewModel scheduleViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private LinearLayout weekdaysIndicator;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView yearIndicator;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private c listener;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.guild.home.schedule.models.a> calendarDays = new ArrayList();

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.home.schedule.a adapter = new com.tencent.mobileqq.guild.home.schedule.a(new ScheduleDateLocatorDialog$adapter$1(this), new ScheduleDateLocatorDialog$adapter$2(this));

    /* renamed from: L, reason: from kotlin metadata */
    private Calendar locateDate = Calendar.getInstance();

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isFirstRequest = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J>\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/dialog/ScheduleDateLocatorDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "manager", "", "guildId", "channelId", "", "year", "month", "day", "Lcom/tencent/mobileqq/guild/home/views/dialog/ScheduleDateLocatorDialog$c;", "listener", "", "a", IGuildFeedConfigAPi.PARAM_CHANNEL_ID, "Ljava/lang/String;", "PARAM_DATE", IGuildFeedConfigAPi.PARAM_GUILD_ID, "PARAM_LOCATE_DATE", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.views.dialog.ScheduleDateLocatorDialog$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager manager, @NotNull String guildId, @NotNull String channelId, int year, int month, int day, @NotNull c listener) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(listener, "listener");
            ScheduleDateLocatorDialog scheduleDateLocatorDialog = new ScheduleDateLocatorDialog();
            Bundle bundle = new Bundle();
            bundle.putString(IGuildFeedConfigAPi.PARAM_GUILD_ID, guildId);
            bundle.putString(IGuildFeedConfigAPi.PARAM_CHANNEL_ID, channelId);
            bundle.putSerializable("PARAM_LOCATE_DATE", CalendarEx.f214714a.c(year, month, day));
            bundle.putIntArray("PARAM_DATE", new int[]{year, month, day});
            scheduleDateLocatorDialog.setArguments(bundle);
            scheduleDateLocatorDialog.Fh(listener);
            com.tencent.mobileqq.guild.base.extension.d.a(scheduleDateLocatorDialog, manager, "ScheduleDateLocatorDialog");
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/dialog/ScheduleDateLocatorDialog$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "getItemWidth", "()I", "itemWidth", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int itemWidth;

        public b(int i3) {
            this.itemWidth = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            int roundToInt;
            int roundToInt2;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
            int spanIndex = ((GridLayoutManager.LayoutParams) layoutParams).getSpanIndex();
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
            int spanSize = ((GridLayoutManager.LayoutParams) layoutParams2).getSpanSize();
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
            int i3 = ((ViewGroup.MarginLayoutParams) ((GridLayoutManager.LayoutParams) layoutParams3)).width;
            RecyclerView.ViewHolder childViewHolder = parent.getChildViewHolder(view);
            if (spanSize == 1) {
                float measuredWidth = (((parent.getMeasuredWidth() - parent.getPaddingLeft()) - parent.getPaddingRight()) - (this.itemWidth * 7)) / 6.0f;
                roundToInt = MathKt__MathJVMKt.roundToInt((spanIndex * measuredWidth) / 7);
                outRect.left = roundToInt;
                roundToInt2 = MathKt__MathJVMKt.roundToInt(measuredWidth - (((spanIndex + 1) * measuredWidth) / 7.0f));
                outRect.right = roundToInt2;
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("ScheduleDateLocatorDialog", 1, "MyDecoration " + spanIndex + ", " + spanSize + ", " + childViewHolder + ", outRect = " + outRect + ", parentWidth=" + parent.getMeasuredWidth() + "/" + parent.getPaddingLeft() + "/" + parent.getPaddingRight() + ", myWidth=" + view.getMeasuredWidth() + "/" + view.getWidth() + "/" + i3);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/dialog/ScheduleDateLocatorDialog$c;", "", "", "timeInMillis", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface c {
        void a(long timeInMillis);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d<T> implements Observer {
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            Logger.f235387a.d().i("ScheduleDateLocatorDialog", 1, "liveList " + ((List) t16));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e<T> implements Observer {
        public e() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            ScheduleDateLocatorDialog.this.adapter.setItems((List) t16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/home/views/dialog/ScheduleDateLocatorDialog$f", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f extends GridLayoutManager.SpanSizeLookup {
        f() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            com.tencent.mobileqq.guild.home.schedule.models.a aVar = ScheduleDateLocatorDialog.this.adapter.getItems().get(position);
            if (aVar instanceof a.CalendarDay) {
                return 1;
            }
            if (aVar instanceof a.CalendarMonth) {
                return 7;
            }
            if (aVar instanceof a.PlaceHolder) {
                return ((a.PlaceHolder) aVar).getSpanSize();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/home/views/dialog/ScheduleDateLocatorDialog$g", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class g extends RecyclerView.OnScrollListener {
        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("ScheduleDateLocatorDialog", 1, "onScrollStateChanged " + newState);
            }
            if (newState == 0) {
                ScheduleDateLocatorDialog.this.Eh(newState);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            if (ScheduleDateLocatorDialog.this.isFirstRequest) {
                ScheduleDateLocatorDialog.this.isFirstRequest = !ScheduleDateLocatorDialog.this.Eh(-1);
            }
            GridLayoutManager gridLayoutManager = ScheduleDateLocatorDialog.this.layoutManager;
            TextView textView = null;
            if (gridLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
                gridLayoutManager = null;
            }
            int findFirstCompletelyVisibleItemPosition = gridLayoutManager.findFirstCompletelyVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition >= 0) {
                TextView textView2 = ScheduleDateLocatorDialog.this.yearIndicator;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("yearIndicator");
                } else {
                    textView = textView2;
                }
                textView.setText(String.valueOf(ScheduleDateLocatorDialog.this.adapter.getItems().get(findFirstCompletelyVisibleItemPosition).a().get(1)));
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("ScheduleDateLocatorDialog", 1, "onScrolled " + dy5);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/home/views/dialog/ScheduleDateLocatorDialog$h", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "positionStart", "itemCount", "", "onItemRangeChanged", "onItemRangeInserted", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class h extends RecyclerView.AdapterDataObserver {
        h() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int positionStart, int itemCount) {
            Logger.f235387a.d().i("ScheduleDateLocatorDialog", 1, "onItemRangeChanged: " + positionStart + ", " + itemCount);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0066 A[LOOP:0: B:4:0x0025->B:14:0x0066, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x006a A[EDGE_INSN: B:15:0x006a->B:16:0x006a BREAK  A[LOOP:0: B:4:0x0025->B:14:0x0066], SYNTHETIC] */
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemRangeInserted(int positionStart, int itemCount) {
            boolean z16;
            if (ScheduleDateLocatorDialog.this.isFirstRequest) {
                ScheduleDateLocatorDialog.this.isFirstRequest = false;
                List<com.tencent.mobileqq.guild.home.schedule.models.a> items = ScheduleDateLocatorDialog.this.adapter.getItems();
                Intrinsics.checkNotNullExpressionValue(items, "adapter.items");
                ScheduleDateLocatorDialog scheduleDateLocatorDialog = ScheduleDateLocatorDialog.this;
                Iterator<com.tencent.mobileqq.guild.home.schedule.models.a> it = items.iterator();
                int i3 = 0;
                while (true) {
                    if (it.hasNext()) {
                        com.tencent.mobileqq.guild.home.schedule.models.a next = it.next();
                        if (next instanceof a.CalendarMonth) {
                            a.CalendarMonth calendarMonth = (a.CalendarMonth) next;
                            int year = calendarMonth.getYear();
                            Calendar locateDate = scheduleDateLocatorDialog.locateDate;
                            Intrinsics.checkNotNullExpressionValue(locateDate, "locateDate");
                            if (year == locateDate.get(1)) {
                                int month = calendarMonth.getMonth();
                                Calendar locateDate2 = scheduleDateLocatorDialog.locateDate;
                                Intrinsics.checkNotNullExpressionValue(locateDate2, "locateDate");
                                if (month == locateDate2.get(2) + 1) {
                                    z16 = true;
                                    if (!z16) {
                                        break;
                                    } else {
                                        i3++;
                                    }
                                }
                            }
                        }
                        z16 = false;
                        if (!z16) {
                        }
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                Logger logger = Logger.f235387a;
                ScheduleDateLocatorDialog scheduleDateLocatorDialog2 = ScheduleDateLocatorDialog.this;
                if (QLog.isColorLevel()) {
                    Logger.a d16 = logger.d();
                    Calendar locateDate3 = scheduleDateLocatorDialog2.locateDate;
                    Intrinsics.checkNotNullExpressionValue(locateDate3, "locateDate");
                    d16.d("ScheduleDateLocatorDialog", 1, "onItemRangeInserted locate to month " + CalendarExKt.b(locateDate3));
                }
                if (!ScheduleDateLocatorDialog.this.Eh(-1)) {
                    ScheduleDateLocatorDialog.this.isFirstRequest = true;
                }
                ScheduleDateLocatorDialog scheduleDateLocatorDialog3 = ScheduleDateLocatorDialog.this;
                if (QLog.isColorLevel()) {
                    logger.d().d("ScheduleDateLocatorDialog", 1, "scrollToPositionWithOffset " + i3 + ", isFirstRequest = " + scheduleDateLocatorDialog3.isFirstRequest);
                }
                GridLayoutManager gridLayoutManager = ScheduleDateLocatorDialog.this.layoutManager;
                if (gridLayoutManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
                    gridLayoutManager = null;
                }
                gridLayoutManager.scrollToPositionWithOffset(i3, -ViewUtils.dpToPx(18.0f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ah(long timeInMillis) {
        c cVar = this.listener;
        if (cVar != null) {
            cVar.a(timeInMillis);
        }
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bh(a.CalendarMonth calendarMonth) {
        GuildHomeScheduleViewModel guildHomeScheduleViewModel = this.scheduleViewModel;
        if (guildHomeScheduleViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleViewModel");
            guildHomeScheduleViewModel = null;
        }
        guildHomeScheduleViewModel.u2(calendarMonth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(ScheduleDateLocatorDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(ScheduleDateLocatorDialog this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("ScheduleDateLocatorDialog", 1, "OnLayoutChangeListener " + (i27 - i19) + " -> " + (i17 - i3));
        }
        RecyclerView recyclerView = this$0.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.invalidateItemDecorations();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Eh(int newState) {
        GuildHomeScheduleViewModel guildHomeScheduleViewModel;
        GridLayoutManager gridLayoutManager = this.layoutManager;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            gridLayoutManager = null;
        }
        int findFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
        GridLayoutManager gridLayoutManager2 = this.layoutManager;
        if (gridLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            gridLayoutManager2 = null;
        }
        int findLastVisibleItemPosition = gridLayoutManager2.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition >= 0 && findLastVisibleItemPosition >= 0) {
            List<com.tencent.mobileqq.guild.home.schedule.models.a> items = this.adapter.getItems();
            if (items.size() <= findLastVisibleItemPosition) {
                s.e("ScheduleDateLocatorDialog", "findLastVisibleItemPosition " + findLastVisibleItemPosition + " >= items.size(" + items.size() + ")", new IllegalStateException());
            }
            Calendar a16 = items.get(findFirstVisibleItemPosition).a();
            a16.set(5, 1);
            Calendar a17 = items.get(findLastVisibleItemPosition).a();
            a17.set(5, a17.getActualMaximum(5));
            py1.a a18 = py1.a.a(a16.getTimeInMillis());
            py1.a a19 = py1.a.a(a17.getTimeInMillis());
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("ScheduleDateLocatorDialog", 1, "onScrollStateChanged " + newState + " " + a18 + " " + a19);
            }
            GuildHomeScheduleViewModel guildHomeScheduleViewModel2 = this.scheduleViewModel;
            if (guildHomeScheduleViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scheduleViewModel");
                guildHomeScheduleViewModel = null;
            } else {
                guildHomeScheduleViewModel = guildHomeScheduleViewModel2;
            }
            guildHomeScheduleViewModel.F2(a18.d(), a19.d(), findFirstVisibleItemPosition);
            return true;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("ScheduleDateLocatorDialog", 1, "onScrollStateChanged " + findFirstVisibleItemPosition + " / " + findLastVisibleItemPosition);
            return false;
        }
        return false;
    }

    private final void Gh(String from) {
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("ScheduleDateLocatorDialog", 1, "updateDialogViewHeight() from " + from);
        }
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) getDialog();
        int screenHeight = (int) (ViewUtils.getScreenHeight() * 0.7f);
        LinearLayout linearLayout = null;
        if (aVar != null) {
            bottomSheetBehavior = aVar.getBehavior();
        } else {
            bottomSheetBehavior = null;
        }
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setPeekHeight(screenHeight);
        }
        LinearLayout linearLayout2 = this.rootView;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            linearLayout2 = null;
        }
        ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "rootView.layoutParams");
        layoutParams.height = screenHeight;
        LinearLayout linearLayout3 = this.rootView;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.setLayoutParams(layoutParams);
    }

    public final void Fh(@NotNull c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.ViewModelStoreOwner
    @NotNull
    public ViewModelStore getViewModelStore() {
        ViewModelStore viewModelStore;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            viewModelStore = parentFragment.getViewModelStore();
        } else {
            viewModelStore = null;
        }
        if (viewModelStore == null) {
            ViewModelStore viewModelStore2 = super.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore2, "super.getViewModelStore()");
            return viewModelStore2;
        }
        return viewModelStore;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Gh("onConfigurationChanged");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!QQTheme.isNowThemeIsNight()) {
            setStyle(0, R.style.a66);
        }
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        return (com.google.android.material.bottomsheet.a) onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.ety, container);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) inflate;
        this.rootView = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            linearLayout = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, linearLayout);
        return linearLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Calendar calendar;
        IntRange until;
        IntProgression step;
        int roundToInt;
        GuildHomeScheduleViewModel guildHomeScheduleViewModel;
        Window window;
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(view, "view");
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null && (viewGroup = (ViewGroup) window.findViewById(R.id.ugk)) != null) {
            viewGroup.setBackgroundResource(17170445);
        }
        Gh(DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED);
        Logger.f235387a.d().i("ScheduleDateLocatorDialog", 1, "onViewCreated " + getArguments());
        Serializable serializable = requireArguments().getSerializable("PARAM_LOCATE_DATE");
        GuildHomeScheduleViewModel guildHomeScheduleViewModel2 = null;
        if (serializable instanceof Calendar) {
            calendar = (Calendar) serializable;
        } else {
            calendar = null;
        }
        if (calendar == null) {
            calendar = Calendar.getInstance();
        }
        this.locateDate = calendar;
        String string = requireArguments().getString(IGuildFeedConfigAPi.PARAM_GUILD_ID);
        String str = "";
        if (string == null) {
            string = "";
        }
        String string2 = requireArguments().getString(IGuildFeedConfigAPi.PARAM_CHANNEL_ID);
        if (string2 != null) {
            str = string2;
        }
        LinearLayout linearLayout = this.rootView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            linearLayout = null;
        }
        View findViewById = linearLayout.findViewById(R.id.eap);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.list)");
        this.recyclerView = (RecyclerView) findViewById;
        LinearLayout linearLayout2 = this.rootView;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            linearLayout2 = null;
        }
        View findViewById2 = linearLayout2.findViewById(R.id.f122177d9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.weekdays_indicator)");
        this.weekdaysIndicator = (LinearLayout) findViewById2;
        LinearLayout linearLayout3 = this.rootView;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            linearLayout3 = null;
        }
        View findViewById3 = linearLayout3.findViewById(R.id.f125817n3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.year_indicator)");
        this.yearIndicator = (TextView) findViewById3;
        LinearLayout linearLayout4 = this.rootView;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            linearLayout4 = null;
        }
        linearLayout4.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.views.dialog.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ScheduleDateLocatorDialog.Ch(ScheduleDateLocatorDialog.this, view2);
            }
        });
        List<String> f16 = CalendarEx.f214714a.f();
        LinearLayout linearLayout5 = this.weekdaysIndicator;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("weekdaysIndicator");
            linearLayout5 = null;
        }
        until = RangesKt___RangesKt.until(0, linearLayout5.getChildCount());
        step = RangesKt___RangesKt.step(until, 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                int i3 = first / 2;
                LinearLayout linearLayout6 = this.weekdaysIndicator;
                if (linearLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("weekdaysIndicator");
                    linearLayout6 = null;
                }
                View childAt = linearLayout6.getChildAt(first);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
                ((TextView) childAt).setText(f16.get(((i3 + 0) % 7) + 1));
                if (first == last) {
                    break;
                } else {
                    first += step2;
                }
            }
        }
        TextView textView = this.yearIndicator;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yearIndicator");
            textView = null;
        }
        Calendar locateDate = this.locateDate;
        Intrinsics.checkNotNullExpressionValue(locateDate, "locateDate");
        textView.setText(String.valueOf(locateDate.get(1)));
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setChangeDuration(0L);
        defaultItemAnimator.setMoveDuration(0L);
        defaultItemAnimator.setAddDuration(100L);
        defaultItemAnimator.setRemoveDuration(100L);
        recyclerView.setItemAnimator(defaultItemAnimator);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.home.views.dialog.e
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29) {
                ScheduleDateLocatorDialog.Dh(ScheduleDateLocatorDialog.this, view2, i16, i17, i18, i19, i26, i27, i28, i29);
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 7);
        this.layoutManager = gridLayoutManager;
        gridLayoutManager.setSpanSizeLookup(new f());
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        GridLayoutManager gridLayoutManager2 = this.layoutManager;
        if (gridLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            gridLayoutManager2 = null;
        }
        recyclerView3.setLayoutManager(gridLayoutManager2);
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        recyclerView4.setAdapter(this.adapter);
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView5 = null;
        }
        recyclerView5.addOnScrollListener(new g());
        this.adapter.registerAdapterDataObserver(new h());
        RecyclerView recyclerView6 = this.recyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView6 = null;
        }
        roundToInt = MathKt__MathJVMKt.roundToInt(cw.b(40));
        recyclerView6.addItemDecoration(new b(roundToInt));
        if (GuildSplitViewUtils.f235370a.n(getActivity())) {
            guildHomeScheduleViewModel = (GuildHomeScheduleViewModel) ef1.c.INSTANCE.b(this, GuildHomeScheduleViewModel.class, string, str);
        } else {
            c.Companion companion = ef1.c.INSTANCE;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            guildHomeScheduleViewModel = (GuildHomeScheduleViewModel) companion.b(requireActivity, GuildHomeScheduleViewModel.class, string, str);
        }
        this.scheduleViewModel = guildHomeScheduleViewModel;
        if (guildHomeScheduleViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleViewModel");
            guildHomeScheduleViewModel = null;
        }
        LiveData<List<com.tencent.mobileqq.guild.home.schedule.models.d>> o26 = guildHomeScheduleViewModel.o2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        o26.observe(viewLifecycleOwner, new d());
        GuildHomeScheduleViewModel guildHomeScheduleViewModel3 = this.scheduleViewModel;
        if (guildHomeScheduleViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleViewModel");
            guildHomeScheduleViewModel3 = null;
        }
        LiveData<List<com.tencent.mobileqq.guild.home.schedule.models.a>> l26 = guildHomeScheduleViewModel3.l2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        l26.observe(viewLifecycleOwner2, new e());
        GuildHomeScheduleViewModel guildHomeScheduleViewModel4 = this.scheduleViewModel;
        if (guildHomeScheduleViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleViewModel");
        } else {
            guildHomeScheduleViewModel2 = guildHomeScheduleViewModel4;
        }
        Calendar e16 = CalendarEx.f214714a.e();
        Calendar locateDate2 = this.locateDate;
        Intrinsics.checkNotNullExpressionValue(locateDate2, "locateDate");
        guildHomeScheduleViewModel2.A2(e16, locateDate2);
    }
}
