package com.tencent.mobileqq.guild.mainframe.startpanel.leftbar;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.helper.d;
import com.tencent.mobileqq.guild.mainframe.helper.jump.GuildMainFrameJumpParam;
import com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameRedDragManager;
import com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarListAdapter;
import com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.adapterdelegates.GuildJoinAdapterDelegate;
import com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.adapterdelegates.GuildNormalAdapterDelegate;
import com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.adapterdelegates.GuildPartingLineAdapterDelegate;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragTextView;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u000f\b\u0016\u0018\u0000 n2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0003:\u0002opB@\u0012\u0006\u0010i\u001a\u00020R\u0012!\u0010Q\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00070J\u0012\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00020j\u00a2\u0006\u0004\bl\u0010mJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0002J\u000f\u0010\u0010\u001a\u00020\u000fH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J \u0010\u0019\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\tH\u0016J(\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\t2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030 H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\tH\u0016J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150$H\u0016J\u000e\u0010&\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010'\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010(\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010+\u001a\u00020\r2\u0006\u0010*\u001a\u00020)J\b\u0010,\u001a\u0004\u0018\u00010)J(\u00102\u001a\u00020\r2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00020-j\b\u0012\u0004\u0012\u00020\u0002`.2\b\u00101\u001a\u0004\u0018\u000100J \u00105\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\b\u00104\u001a\u0004\u0018\u000103J\u000e\u00106\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u00109\u001a\u00020\r2\u0006\u00108\u001a\u000207J\u0016\u0010<\u001a\u00020\r2\u0006\u0010:\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u0007J\u0006\u0010=\u001a\u00020\rJ\u0006\u0010>\u001a\u00020\rJ\u000e\u0010A\u001a\u00020\r2\u0006\u0010@\u001a\u00020?J\u001e\u0010B\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0007J\u0006\u0010C\u001a\u00020\rJ\u000e\u0010D\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012J\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00120EJ \u0010I\u001a\u00020\r2\u0006\u0010G\u001a\u00020\u00022\b\u00104\u001a\u0004\u0018\u0001032\u0006\u0010H\u001a\u00020\u0007R2\u0010Q\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00070J8\u0006\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR&\u0010X\u001a\u0012\u0012\u0004\u0012\u00020\u00020-j\b\u0012\u0004\u0012\u00020\u0002`.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010[\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010^\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u001b\u0010h\u001a\u00020c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\u00a8\u0006q"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListAdapter;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lcs1/b;", "", "itemData", "Lcom/tencent/mobileqq/guild/mainframe/helper/jump/GuildMainFrameJumpParam;", "param", "", "C0", "", "type", "A0", com.tencent.luggage.wxa.c8.c.G, "", "K0", "com/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListAdapter$c", "H0", "()Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListAdapter$c;", "", "key", "w0", "Landroid/view/View;", "convertView", "n0", "doAnimation", "s0", "Q0", "R0", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "position", "onBindViewHolder", "", "payloads", "", "getItemId", "", "onGetVisibleDragView", "D0", "t0", "B0", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarViewModel;", "viewModel", "O0", "y0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "Ljava/lang/Runnable;", "block", "M0", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "sourceInfo", "F0", "E0", "Lcom/tencent/mobileqq/guild/mainframe/helper/d$a;", "oldSelItem", "q0", "uIData", "needAnimation", "r0", "z0", "J0", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListAdapter$b;", "delegateCallback", "N0", "S0", "o0", "p0", "", "u0", "data", IAELaunchRecorder.MILESTONE_CLICK, "I0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "I", "Lkotlin/jvm/functions/Function1;", "v0", "()Lkotlin/jvm/functions/Function1;", "longClickCallback", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController;", "J", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController;", "mListController", "K", "Ljava/util/ArrayList;", "mOriginItemList", "L", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarViewModel;", "mLeftBarViewModel", "M", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListAdapter$b;", "mDelegateCallback", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/b;", "N", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/b;", "mDragListener", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;", "P", "Lkotlin/Lazy;", "x0", "()Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;", "smoothScroller", "controller", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "differCallback", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController;Lkotlin/jvm/functions/Function1;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class GuildLeftBarListAdapter extends com.tencent.mobileqq.guild.widget.adapterdelegates.d<cs1.b> implements QUIBadgeDragLayout.IDragViewProvider {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Function1<Integer, Boolean> longClickCallback;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private GuildLeftBarListController mListController;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private ArrayList<cs1.b> mOriginItemList;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private GuildLeftBarViewModel mLeftBarViewModel;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private b mDelegateCallback;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.b mDragListener;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy smoothScroller;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListAdapter$b;", "", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
        void a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListAdapter$c", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "", "getVerticalSnapPreference", "Landroid/view/View;", "view", "snapPreference", "calculateDyToMakeVisible", "c", "I", "SPACE_FOR_MASK", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends LinearSmoothScroller {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int SPACE_FOR_MASK;

        c(Context context) {
            super(context);
            this.SPACE_FOR_MASK = QQGuildUIUtil.f(10.0f);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDyToMakeVisible(@Nullable View view, int snapPreference) {
            int calculateDyToMakeVisible = super.calculateDyToMakeVisible(view, snapPreference);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.MF.Lt.GuildLeftBarListAdapter", 1, "calculateDyToMakeVisible originDy:" + calculateDyToMakeVisible);
            }
            return calculateDyToMakeVisible + this.SPACE_FOR_MASK;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected int getVerticalSnapPreference() {
            return -1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildLeftBarListAdapter(@NotNull GuildLeftBarListController controller, @NotNull Function1<? super Integer, Boolean> longClickCallback, @NotNull DiffUtil.ItemCallback<cs1.b> differCallback) {
        super(differCallback);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(longClickCallback, "longClickCallback");
        Intrinsics.checkNotNullParameter(differCallback, "differCallback");
        this.longClickCallback = longClickCallback;
        this.mListController = controller;
        this.mOriginItemList = new ArrayList<>();
        this.mDragListener = new com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.b(this);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarListAdapter$smoothScroller$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildLeftBarListAdapter.c invoke() {
                GuildLeftBarListAdapter.c H0;
                H0 = GuildLeftBarListAdapter.this.H0();
                return H0;
            }
        });
        this.smoothScroller = lazy;
        this.f236209m.c(new GuildNormalAdapterDelegate(this));
        this.f236209m.c(new GuildPartingLineAdapterDelegate());
        this.f236209m.c(new GuildJoinAdapterDelegate(this));
    }

    private final boolean A0(int type) {
        if (type == 1 || type == 0) {
            return true;
        }
        return false;
    }

    private final boolean C0(cs1.b itemData, GuildMainFrameJumpParam param) {
        if (param.f227437a == itemData.f391795d && TextUtils.equals(param.f227438b, itemData.f391796e)) {
            return true;
        }
        if (A0(param.f227437a)) {
            return TextUtils.equals(param.f227438b, itemData.f391796e);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c H0() {
        return new c(this.mListController.L().getContext());
    }

    private final void K0(final int pos) {
        if (pos >= 0 && pos < getNUM_BACKGOURND_ICON()) {
            OverScrollRecyclerViewWithHeaderFooter L = this.mListController.L();
            RecyclerView.LayoutManager layoutManager = L.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            L.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.d
                @Override // java.lang.Runnable
                public final void run() {
                    GuildLeftBarListAdapter.L0(GuildLeftBarListAdapter.this, pos, linearLayoutManager);
                }
            }, 100L);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "scrollToDestPos error, pos " + pos + " is illegal";
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.MF.Lt.GuildLeftBarListAdapter", 1, (String) it.next(), null);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(com.tencent.luggage.wxa.c8.c.G, String.valueOf(pos));
        com.tencent.mobileqq.guild.performance.report.m.INSTANCE.a().e("Guild.MF.Lt.GuildLeftBarListAdapterscrollToDestPos error", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(GuildLeftBarListAdapter this$0, int i3, LinearLayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(layoutManager, "$layoutManager");
        this$0.x0().setTargetPosition(i3);
        layoutManager.startSmoothScroll(this$0.x0());
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Lt.GuildLeftBarListAdapter", 2, "scrollToDestPos pos:" + i3);
        }
    }

    private final boolean Q0() {
        GuildLeftBarViewModel guildLeftBarViewModel = this.mLeftBarViewModel;
        if (guildLeftBarViewModel == null) {
            return true;
        }
        Intrinsics.checkNotNull(guildLeftBarViewModel);
        return guildLeftBarViewModel.z2();
    }

    private final void R0(cs1.b itemData) {
        IGuildUnreadCntService.b bVar;
        if (itemData instanceof cs1.e) {
            bVar = ((cs1.e) itemData).E;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.f230840d = 0L;
            bVar.f230841e = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(GuildLeftBarListAdapter this$0, int i3, String key, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(key, "$key");
        this$0.s0(i3, key, z16);
    }

    private final void n0(View convertView) {
        GuildDragTextView guildDragTextView;
        if (convertView == null || (guildDragTextView = (GuildDragTextView) convertView.findViewById(R.id.kio)) == null) {
            return;
        }
        this.mListController.g().N().addGestureListener(guildDragTextView.g());
    }

    private final void s0(int type, String key, boolean doAnimation) {
        int w06 = w0(type, key);
        if (w06 >= 0) {
            cs1.b bVar = this.mOriginItemList.get(w06);
            Intrinsics.checkNotNullExpressionValue(bVar, "mOriginItemList[pos]");
            bVar.m();
        } else {
            Logger.f235387a.d().d("Guild.MF.Lt.GuildLeftBarListAdapter", 1, "updateItemView warning, type:" + type + " key:" + key + " pos:" + w06 + ", data is not found in mOriginItemList");
        }
        int size = getItems().size();
        boolean z16 = false;
        for (int i3 = 0; i3 < size; i3++) {
            if (getItems().get(i3).h() == type && TextUtils.equals(getItems().get(i3).f391796e, key)) {
                if (Q0() && doAnimation) {
                    z16 = true;
                }
                notifyItemChanged(i3, Boolean.valueOf(z16));
                Logger.f235387a.d().i("Guild.MF.Lt.GuildLeftBarListAdapter", 1, "updateItemView, type:" + type + " key:" + key + " and notifyItemChanged i:" + i3 + " pos:" + w06);
                return;
            }
        }
        Logger.f235387a.d().i("Guild.MF.Lt.GuildLeftBarListAdapter", 1, "updateItemView, type:" + type + " key:" + key + " can't find it in adapter list pos:" + w06);
    }

    private final int w0(int type, String key) {
        int size = this.mOriginItemList.size();
        for (int i3 = 0; i3 < size; i3++) {
            cs1.b bVar = this.mOriginItemList.get(i3);
            Intrinsics.checkNotNullExpressionValue(bVar, "mOriginItemList[i]");
            cs1.b bVar2 = bVar;
            if (bVar2.h() == type && Intrinsics.areEqual(bVar2.f391796e, key)) {
                return i3;
            }
        }
        return -1;
    }

    private final RecyclerView.SmoothScroller x0() {
        return (RecyclerView.SmoothScroller) this.smoothScroller.getValue();
    }

    public final boolean B0(int pos) {
        if (pos >= 0 && pos < this.mOriginItemList.size()) {
            return this.mOriginItemList.get(pos) instanceof cs1.e;
        }
        return false;
    }

    public final boolean D0(int pos) {
        if (pos < 0 || pos >= this.mOriginItemList.size() || !(this.mOriginItemList.get(pos) instanceof cs1.e)) {
            return false;
        }
        cs1.b bVar = this.mOriginItemList.get(pos);
        Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.itembuilder.GuildLeftBarNormalUIData");
        return ((cs1.e) bVar).H;
    }

    public final boolean E0(@NotNull GuildMainFrameJumpParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        int size = this.mOriginItemList.size();
        for (int i3 = 0; i3 < size; i3++) {
            cs1.b bVar = this.mOriginItemList.get(i3);
            Intrinsics.checkNotNullExpressionValue(bVar, "mOriginItemList[i]");
            cs1.b bVar2 = bVar;
            if (C0(bVar2, param)) {
                r0(bVar2, false);
                K0(i3);
                Bundle bundle = new Bundle();
                bundle.putParcelable("EXTRA_KEY_CENTER_PANEL_PARAM", param.f227440d);
                bVar2.f391799i = bundle;
                Bundle bundle2 = param.f227442f;
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                I0(bVar2, param.f227441e, false);
                Logger.f235387a.d().i("Guild.MF.Lt.GuildLeftBarListAdapter", 1, "openChatCenterPanel find guild:" + param.f227437a + " " + param.f227438b + " souceInfo=" + param.f227441e);
                return true;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("type", String.valueOf(param.f227437a));
        String str = param.f227438b;
        Intrinsics.checkNotNullExpressionValue(str, "param.itemKey");
        hashMap.put("key", str);
        com.tencent.mobileqq.guild.performance.report.m.INSTANCE.a().e("Guild.MF.Lt.GuildLeftBarListAdapterjump2Guild error", hashMap);
        return false;
    }

    public final boolean F0(int type, @NotNull String key, @Nullable GuildAppReportSourceInfo sourceInfo) {
        Intrinsics.checkNotNullParameter(key, "key");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Lt.GuildLeftBarListAdapter", 2, "jumpItemView type:" + type + " key:" + key + " sourceInfo=" + sourceInfo);
        }
        if (type == -1) {
            this.mListController.g().e1().n(4, null, null);
            return true;
        }
        int w06 = w0(type, key);
        if (w06 < 0) {
            Logger.b bVar = new Logger.b();
            String str = "jumpItemView error, type:" + type + " key:" + key + ", data is not found";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.Lt.GuildLeftBarListAdapter", 1, (String) it.next(), null);
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("type", String.valueOf(type));
            hashMap.put("key", key);
            com.tencent.mobileqq.guild.performance.report.m.INSTANCE.a().e("Guild.MF.Lt.GuildLeftBarListAdapterjumpItemView error", hashMap);
            return false;
        }
        cs1.b bVar2 = this.mOriginItemList.get(w06);
        Intrinsics.checkNotNullExpressionValue(bVar2, "mOriginItemList[pos]");
        cs1.b bVar3 = bVar2;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.MF.Lt.GuildLeftBarListAdapter", "jumpItemView itemData=" + bVar3);
        }
        r0(bVar3, false);
        I0(bVar3, sourceInfo, false);
        K0(w06);
        return true;
    }

    public final void I0(@NotNull cs1.b data, @Nullable GuildAppReportSourceInfo sourceInfo, boolean userClick) {
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.guild.mainframe.i g16 = this.mListController.g();
        if (data instanceof cs1.e) {
            g16.e1().n(1, data, sourceInfo);
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Lt.GuildLeftBarListAdapter", 2, "openTargetPage data:" + data + " ");
        }
    }

    public final void J0() {
        DragFrameLayout e16 = this.mListController.g().e();
        if (e16 != null) {
            e16.setOnDragListener((QUIBadgeDragLayout.OnDragListener) null);
        }
        if (e16 != null) {
            e16.removeOnDragModeChangeListener(this.mDragListener);
        }
        if (this.mListController.g().getActivity() != null) {
            DragFrameLayout dragFrameLayout = (DragFrameLayout) this.mListController.g().getActivity().findViewById(tp1.a.a());
            if (dragFrameLayout != null) {
                dragFrameLayout.removeOnDragModeChangeListenerByGroup(com.tencent.mobileqq.activity.home.impl.b.f183056s, this.mDragListener);
            }
            if (dragFrameLayout != null) {
                dragFrameLayout.removeDragViewProviderByGroup(com.tencent.mobileqq.activity.home.impl.b.f183056s, this);
            }
            if (dragFrameLayout != null) {
                dragFrameLayout.setOnDragListener((QUIBadgeDragLayout.OnDragListener) null);
            }
        }
    }

    public final void M0(@NotNull ArrayList<cs1.b> list, @Nullable Runnable block) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.mOriginItemList = list;
        setItems(list, block);
    }

    public final void N0(@NotNull b delegateCallback) {
        Intrinsics.checkNotNullParameter(delegateCallback, "delegateCallback");
        this.mDelegateCallback = delegateCallback;
    }

    public final void O0(@NotNull GuildLeftBarViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.mLeftBarViewModel = viewModel;
    }

    public final void S0(final int type, @NotNull final String key, final boolean doAnimation) {
        Intrinsics.checkNotNullParameter(key, "key");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildLeftBarListAdapter.T0(GuildLeftBarListAdapter.this, type, key, doAnimation);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    public final void o0() {
        int num_backgournd_icon = getNUM_BACKGOURND_ICON();
        for (int i3 = 0; i3 < num_backgournd_icon; i3++) {
            cs1.b bVar = this.mOriginItemList.get(i3);
            Intrinsics.checkNotNullExpressionValue(bVar, "mOriginItemList[i]");
            R0(bVar);
        }
    }

    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.d, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder, position);
        n0(holder.itemView);
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.IDragViewProvider
    @NotNull
    public List<View> onGetVisibleDragView() {
        DragTextView dragTextView;
        this.mDragListener.g();
        ArrayList arrayList = new ArrayList();
        int childCount = this.mListController.L().getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.mListController.L().getChildAt(i3);
            if (childAt != null) {
                View findViewById = childAt.findViewById(R.id.kio);
                if (findViewById instanceof DragTextView) {
                    dragTextView = (DragTextView) findViewById;
                } else {
                    dragTextView = null;
                }
                if (dragTextView != null && dragTextView.isShown() && dragTextView.c() != -1) {
                    arrayList.add(dragTextView);
                    this.mDragListener.h(dragTextView, false);
                }
            }
        }
        return arrayList;
    }

    public final void p0(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int num_backgournd_icon = getNUM_BACKGOURND_ICON();
        for (int i3 = 0; i3 < num_backgournd_icon; i3++) {
            cs1.b bVar = this.mOriginItemList.get(i3);
            Intrinsics.checkNotNullExpressionValue(bVar, "mOriginItemList[i]");
            cs1.b bVar2 = bVar;
            if (TextUtils.equals(bVar2.i(), key)) {
                R0(bVar2);
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("Guild.MF.Lt.GuildLeftBarListAdapter", "clearUnread tag, " + bVar2.hashCode() + ", " + bVar2);
                    return;
                }
                return;
            }
        }
    }

    public final void q0(@NotNull d.a oldSelItem) {
        Intrinsics.checkNotNullParameter(oldSelItem, "oldSelItem");
        int i3 = oldSelItem.f227428a;
        if (i3 != -1) {
            String str = oldSelItem.f227429b;
            Intrinsics.checkNotNullExpressionValue(str, "oldSelItem.selKey");
            S0(i3, str, false);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.MF.Lt.GuildLeftBarListAdapter", 2, "clearSelection oldSelItem type:" + oldSelItem.f227428a + " key:" + oldSelItem.f227429b);
            }
        }
    }

    public final void r0(@NotNull cs1.b uIData, boolean needAnimation) {
        boolean z16;
        Intrinsics.checkNotNullParameter(uIData, "uIData");
        if (needAnimation) {
            this.mListController.W(uIData);
        }
        com.tencent.mobileqq.guild.mainframe.helper.d f16 = com.tencent.mobileqq.guild.mainframe.helper.d.f();
        d.a b16 = f16.b();
        Intrinsics.checkNotNullExpressionValue(b16, "selHelper.curSelItem");
        boolean areEqual = Intrinsics.areEqual(b16, new d.a(uIData.f391795d, uIData.f391796e));
        if (!areEqual) {
            f16.k(new d.a(uIData.f391795d, uIData.f391796e), needAnimation);
            com.tencent.mobileqq.guild.mainframe.helper.d.f().i(uIData.f391796e);
            q0(b16);
        }
        if (needAnimation && !areEqual) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = uIData.f391795d;
        String str = uIData.f391796e;
        Intrinsics.checkNotNullExpressionValue(str, "uIData.guildId");
        S0(i3, str, z16);
        b bVar = this.mDelegateCallback;
        if (bVar != null) {
            bVar.a();
        }
        GuildMainFrameRedDragManager.i().f("Guild.MF.Lt.GuildLeftBarListAdapter");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Lt.GuildLeftBarListAdapter", 2, "doSelection baseItemData type:" + uIData.f391795d + " key:" + uIData.f391796e);
        }
    }

    @NotNull
    public final String t0(int pos) {
        if (pos >= 0 && pos < this.mOriginItemList.size()) {
            String str = this.mOriginItemList.get(pos).f391796e;
            Intrinsics.checkNotNullExpressionValue(str, "mOriginItemList[pos].guildId");
            return str;
        }
        return "";
    }

    @NotNull
    public final Set<String> u0() {
        int num_backgournd_icon = getNUM_BACKGOURND_ICON();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i3 = 0; i3 < num_backgournd_icon; i3++) {
            cs1.b bVar = this.mOriginItemList.get(i3);
            Intrinsics.checkNotNullExpressionValue(bVar, "mOriginItemList[i]");
            cs1.b bVar2 = bVar;
            if (bVar2 instanceof cs1.e) {
                String str = bVar2.f391796e;
                Intrinsics.checkNotNullExpressionValue(str, "itemData.guildId");
                linkedHashSet.add(str);
            }
        }
        return linkedHashSet;
    }

    @NotNull
    public final Function1<Integer, Boolean> v0() {
        return this.longClickCallback;
    }

    @Nullable
    /* renamed from: y0, reason: from getter */
    public final GuildLeftBarViewModel getMLeftBarViewModel() {
        return this.mLeftBarViewModel;
    }

    public final void z0() {
        DragFrameLayout e16 = this.mListController.g().e();
        if (e16 != null) {
            e16.removeOnDragModeChangeListener(this.mDragListener);
            e16.addOnDragModeChangeListener(this.mDragListener, true);
            e16.setOnDragListener(this.mDragListener);
        }
        View findViewById = this.mListController.g().getActivity().findViewById(tp1.a.a());
        Intrinsics.checkNotNullExpressionValue(findViewById, "mListController.mainView\u2026lper.getContentFrameId())");
        DragFrameLayout dragFrameLayout = (DragFrameLayout) findViewById;
        String str = com.tencent.mobileqq.activity.home.impl.b.f183056s;
        dragFrameLayout.removeOnDragModeChangeListenerByGroup(str, this.mDragListener);
        dragFrameLayout.addOnDragModeChangeListenerByGroup(str, this.mDragListener, true);
        dragFrameLayout.addDragViewProviderByGroup(str, this, true);
        dragFrameLayout.setOnDragListener(this.mDragListener);
    }

    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.d, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.onBindViewHolder(holder, position, payloads);
        n0(holder.itemView);
    }
}
