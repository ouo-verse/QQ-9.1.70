package com.tencent.mobileqq.guild.widget.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0002!%B\u0019\u0012\u0006\u0010#\u001a\u00020 \u0012\b\b\u0002\u0010'\u001a\u00020$\u00a2\u0006\u0004\b5\u00106J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u001c\u0010\u000f\u001a\u00020\u000e*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\f\u0010\u0010\u001a\u00020\u000e*\u00020\u0007H\u0002J\f\u0010\u0011\u001a\u00020\u000e*\u00020\u0007H\u0002J+\u0010\u0017\u001a\u00020\u000e2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000e0\u0012H\u0002J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\u0014\u0010\u001a\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0016\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u000eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001c0,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/menu/GuildSwipeMenuItemHelper;", "", "Landroid/view/ViewGroup;", "viewGroup", "", "Lcom/tencent/mobileqq/guild/widget/menu/BaseMenuEntry;", "items", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "l", "hostItemView", "", "position", "", "o", "j", "k", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "block", "i", h.F, "menuEntries", DomainData.DOMAIN_NAME, "r", "Lcom/tencent/mobileqq/guild/widget/menu/GuildSwipeMenuItemHelper$b;", "listener", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/widget/SwipeMenuLayout;", "a", "Lcom/tencent/qqnt/widget/SwipeMenuLayout;", "swipeContainer", "Lcom/tencent/mobileqq/guild/widget/menu/c;", "b", "Lcom/tencent/mobileqq/guild/widget/menu/c;", "menuCreator", "Landroid/widget/LinearLayout;", "c", "Landroid/widget/LinearLayout;", "menuItemLayout", "Ljava/util/LinkedList;", "d", "Ljava/util/LinkedList;", "menuListeners", "e", "Landroid/view/View;", "f", "I", "hostItemPosition", "<init>", "(Lcom/tencent/qqnt/widget/SwipeMenuLayout;Lcom/tencent/mobileqq/guild/widget/menu/c;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSwipeMenuItemHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SwipeMenuLayout swipeContainer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c menuCreator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout menuItemLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinkedList<b> menuListeners;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View hostItemView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int hostItemPosition;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J \u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J \u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/menu/GuildSwipeMenuItemHelper$b;", "", "Lcom/tencent/mobileqq/guild/widget/menu/GuildSwipeMenuItemHelper;", "menuHelper", "Landroid/view/View;", "menuView", "Lcom/tencent/mobileqq/guild/widget/menu/BaseMenuEntry;", "menuEntry", "hostItemView", "", "position", "", "b", "a", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes14.dex */
        public static final class a {
            public static void a(@NotNull b bVar, @NotNull GuildSwipeMenuItemHelper menuHelper, @NotNull View hostItemView, int i3) {
                Intrinsics.checkNotNullParameter(menuHelper, "menuHelper");
                Intrinsics.checkNotNullParameter(hostItemView, "hostItemView");
            }

            public static void b(@NotNull b bVar, @NotNull GuildSwipeMenuItemHelper menuHelper, @NotNull View hostItemView, int i3) {
                Intrinsics.checkNotNullParameter(menuHelper, "menuHelper");
                Intrinsics.checkNotNullParameter(hostItemView, "hostItemView");
            }
        }

        void a(@NotNull GuildSwipeMenuItemHelper menuHelper, @NotNull View hostItemView, int position);

        void b(@NotNull GuildSwipeMenuItemHelper menuHelper, @NotNull View menuView, @NotNull BaseMenuEntry menuEntry, @NotNull View hostItemView, int position);

        void c(@NotNull GuildSwipeMenuItemHelper menuHelper, @NotNull View hostItemView, int position);
    }

    public GuildSwipeMenuItemHelper(@NotNull SwipeMenuLayout swipeContainer, @NotNull c menuCreator) {
        Intrinsics.checkNotNullParameter(swipeContainer, "swipeContainer");
        Intrinsics.checkNotNullParameter(menuCreator, "menuCreator");
        this.swipeContainer = swipeContainer;
        this.menuCreator = menuCreator;
        LinearLayout linearLayout = new LinearLayout(swipeContainer.getContext());
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -1));
        this.menuItemLayout = linearLayout;
        this.menuListeners = new LinkedList<>();
        this.hostItemPosition = -1;
        swipeContainer.addView(linearLayout);
        swipeContainer.setSwipeEnable(true);
        swipeContainer.k(true);
        swipeContainer.j(true);
    }

    private final void h(final View hostItemView, final int position) {
        this.swipeContainer.setSwipeListener(new SwipeMenuLayout.e() { // from class: com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper$bindListener$swipeListener$1
            @Override // com.tencent.qqnt.widget.SwipeMenuLayout.e
            public void a() {
                LinkedList linkedList;
                LinkedList linkedList2;
                Logger logger = Logger.f235387a;
                GuildSwipeMenuItemHelper guildSwipeMenuItemHelper = GuildSwipeMenuItemHelper.this;
                View view = hostItemView;
                int i3 = position;
                Logger.a d16 = logger.d();
                linkedList = guildSwipeMenuItemHelper.menuListeners;
                d16.d("GuildMenuItemHelper", 1, "[onMenuOpen]--menuListeners:" + linkedList.size() + ",hostItemView:" + view.hashCode() + ",pos:" + i3);
                linkedList2 = GuildSwipeMenuItemHelper.this.menuListeners;
                GuildSwipeMenuItemHelper guildSwipeMenuItemHelper2 = GuildSwipeMenuItemHelper.this;
                View view2 = hostItemView;
                int i16 = position;
                Iterator it = linkedList2.iterator();
                while (it.hasNext()) {
                    ((GuildSwipeMenuItemHelper.b) it.next()).a(guildSwipeMenuItemHelper2, view2, i16);
                }
                final GuildSwipeMenuItemHelper guildSwipeMenuItemHelper3 = GuildSwipeMenuItemHelper.this;
                guildSwipeMenuItemHelper3.i(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper$bindListener$swipeListener$1$openMenu$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view3) {
                        invoke2(view3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View it5) {
                        Intrinsics.checkNotNullParameter(it5, "it");
                        GuildSwipeMenuItemHelper.this.j(it5);
                    }
                });
            }

            @Override // com.tencent.qqnt.widget.SwipeMenuLayout.e
            public void b() {
                LinkedList linkedList;
                LinkedList linkedList2;
                Logger logger = Logger.f235387a;
                GuildSwipeMenuItemHelper guildSwipeMenuItemHelper = GuildSwipeMenuItemHelper.this;
                View view = hostItemView;
                int i3 = position;
                Logger.a d16 = logger.d();
                linkedList = guildSwipeMenuItemHelper.menuListeners;
                d16.d("GuildMenuItemHelper", 1, "[onMenuClose]--menuListeners:" + linkedList.size() + ",hostItemView:" + view.hashCode() + ",pos:" + i3);
                linkedList2 = GuildSwipeMenuItemHelper.this.menuListeners;
                GuildSwipeMenuItemHelper guildSwipeMenuItemHelper2 = GuildSwipeMenuItemHelper.this;
                View view2 = hostItemView;
                int i16 = position;
                Iterator it = linkedList2.iterator();
                while (it.hasNext()) {
                    ((GuildSwipeMenuItemHelper.b) it.next()).c(guildSwipeMenuItemHelper2, view2, i16);
                }
                final GuildSwipeMenuItemHelper guildSwipeMenuItemHelper3 = GuildSwipeMenuItemHelper.this;
                guildSwipeMenuItemHelper3.i(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper$bindListener$swipeListener$1$closeMenu$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view3) {
                        invoke2(view3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View it5) {
                        Intrinsics.checkNotNullParameter(it5, "it");
                        GuildSwipeMenuItemHelper.this.k(it5);
                    }
                });
            }
        });
        i(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper$bindListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildSwipeMenuItemHelper.this.o(it, hostItemView, position);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(Function1<? super View, Unit> block) {
        Iterator<View> it = ViewGroupKt.getChildren(this.menuItemLayout).iterator();
        while (it.hasNext()) {
            block.invoke(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(View view) {
        BaseMenuEntry baseMenuEntry;
        Object tag = view.getTag();
        if (tag instanceof BaseMenuEntry) {
            baseMenuEntry = (BaseMenuEntry) tag;
        } else {
            baseMenuEntry = null;
        }
        if (baseMenuEntry != null) {
            String reportElementId = baseMenuEntry.getReportElementId();
            Map<String, Object> g16 = baseMenuEntry.g();
            if (reportElementId != null) {
                VideoReport.setElementId(view, reportElementId);
            }
            VideoReport.reportEvent("dt_imp", view, g16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(View view) {
        BaseMenuEntry baseMenuEntry;
        Object tag = view.getTag();
        if (tag instanceof BaseMenuEntry) {
            baseMenuEntry = (BaseMenuEntry) tag;
        } else {
            baseMenuEntry = null;
        }
        if (baseMenuEntry != null) {
            String reportElementId = baseMenuEntry.getReportElementId();
            Map<String, Object> g16 = baseMenuEntry.g();
            if (reportElementId != null) {
                VideoReport.setElementId(view, reportElementId);
            }
            VideoReport.reportEvent("dt_imp_end", view, g16);
        }
    }

    private final View l(ViewGroup viewGroup, BaseMenuEntry item) {
        View a16 = this.menuCreator.a(viewGroup, item);
        if (a16 == null) {
            a16 = this.menuCreator.b(viewGroup, item);
        }
        View view = this.hostItemView;
        if (view != null) {
            o(a16, view, this.hostItemPosition);
        }
        return a16;
    }

    private final List<View> m(ViewGroup viewGroup, List<? extends BaseMenuEntry> items) {
        ArrayList arrayList = new ArrayList(items.size());
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(l(viewGroup, (BaseMenuEntry) it.next()));
        }
        viewGroup.removeAllViews();
        Object[] array = arrayList.toArray(new View[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        View[] viewArr = (View[]) array;
        com.tencent.mobileqq.guild.media.widget.audiofaceview.c.a(viewGroup, (View[]) Arrays.copyOf(viewArr, viewArr.length));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(final View view, final View view2, final int i3) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.widget.menu.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                GuildSwipeMenuItemHelper.p(view, this, view2, i3, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(View this_setMenuListener, GuildSwipeMenuItemHelper this$0, View hostItemView, int i3, View v3) {
        BaseMenuEntry baseMenuEntry;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this_setMenuListener, "$this_setMenuListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hostItemView, "$hostItemView");
        Object tag = this_setMenuListener.getTag();
        if (tag instanceof BaseMenuEntry) {
            baseMenuEntry = (BaseMenuEntry) tag;
        } else {
            baseMenuEntry = null;
        }
        if (baseMenuEntry != null) {
            String reportElementId = baseMenuEntry.getReportElementId();
            Map<String, Object> g16 = baseMenuEntry.g();
            if (reportElementId != null) {
                VideoReport.setElementId(v3, reportElementId);
            }
            VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_NONE);
            VideoReport.reportEvent("clck", v3, g16);
            for (b bVar : this$0.menuListeners) {
                Intrinsics.checkNotNullExpressionValue(v3, "v");
                bVar.b(this$0, v3, baseMenuEntry, hostItemView, i3);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void g(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.menuListeners.add(listener);
    }

    public final void n(@NotNull List<? extends BaseMenuEntry> menuEntries) {
        Intrinsics.checkNotNullParameter(menuEntries, "menuEntries");
        m(this.menuItemLayout, menuEntries);
    }

    public final void q() {
        this.swipeContainer.l();
    }

    public final void r(@NotNull View hostItemView, int position) {
        Intrinsics.checkNotNullParameter(hostItemView, "hostItemView");
        this.hostItemView = hostItemView;
        this.hostItemPosition = position;
        h(hostItemView, position);
    }

    public /* synthetic */ GuildSwipeMenuItemHelper(SwipeMenuLayout swipeMenuLayout, c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(swipeMenuLayout, (i3 & 2) != 0 ? new com.tencent.mobileqq.guild.widget.menu.b() : cVar);
    }
}
