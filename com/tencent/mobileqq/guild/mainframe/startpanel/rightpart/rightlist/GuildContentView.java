package com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.rightlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.main.GuildPageStateManager;
import com.tencent.mobileqq.guild.main.view.c;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kv1.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vp1.as;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"B\u001d\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0002H\u0014J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/rightlist/GuildContentView;", "Lcom/tencent/mobileqq/guild/widget/RadiusFrameLayout;", "", h.F, NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/view/View;", "changedView", "", "visibility", "onVisibilityChanged", "Lvp1/as;", BdhLogUtil.LogTag.Tag_Conn, "Lvp1/as;", "binding", "Lcom/tencent/mobileqq/guild/main/GuildPageStateManager;", "D", "Lcom/tencent/mobileqq/guild/main/GuildPageStateManager;", "guildPageStateManager", "Lar1/h;", "E", "Lar1/h;", "dragHandler", "", UserInfo.SEX_FEMALE, "Z", "channelListDataPrepared", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildContentView extends RadiusFrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final as binding;

    /* renamed from: D, reason: from kotlin metadata */
    private GuildPageStateManager guildPageStateManager;

    /* renamed from: E, reason: from kotlin metadata */
    private ar1.h dragHandler;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean channelListDataPrepared;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/mainframe/startpanel/rightpart/rightlist/GuildContentView$b", "Lkv1/a;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements a {
        b() {
        }

        @Override // kv1.a
        public void a() {
            if (GuildContentView.this.channelListDataPrepared) {
                Logger.f235387a.d().i("Guild.MF.Rt.GuildContentView", 1, "Guild cost, focus channel list load completed!");
                GuildContentView.this.binding.f442285c.O();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildContentView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void h() {
        this.binding.f442285c.setDrawListener(new b());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        ar1.h hVar;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        while (true) {
            hVar = null;
            if (parent != null) {
                if (parent instanceof DragFrameLayout) {
                    break;
                } else {
                    parent = parent.getParent();
                }
            } else {
                parent = null;
                break;
            }
        }
        DragFrameLayout dragFrameLayout = (DragFrameLayout) parent;
        if (dragFrameLayout == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("onAttachedToWindow: can not find DragFrameLayout");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.Rt.GuildContentView", 1, (String) it.next(), null);
            }
            return;
        }
        ar1.h hVar2 = this.dragHandler;
        if (hVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragHandler");
        } else {
            hVar = hVar2;
        }
        hVar.a(dragFrameLayout);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ar1.h hVar;
        super.onDetachedFromWindow();
        ViewParent parent = getParent();
        while (true) {
            hVar = null;
            if (parent != null) {
                if (parent instanceof DragFrameLayout) {
                    break;
                } else {
                    parent = parent.getParent();
                }
            } else {
                parent = null;
                break;
            }
        }
        DragFrameLayout dragFrameLayout = (DragFrameLayout) parent;
        if (dragFrameLayout == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("onAttachedToWindow: can not find DragFrameLayout");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.Rt.GuildContentView", 1, (String) it.next(), null);
            }
            return;
        }
        ar1.h hVar2 = this.dragHandler;
        if (hVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragHandler");
        } else {
            hVar = hVar2;
        }
        hVar.b(dragFrameLayout);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NotNull View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        GuildPageStateManager guildPageStateManager = this.guildPageStateManager;
        if (guildPageStateManager != null) {
            if (guildPageStateManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildPageStateManager");
                guildPageStateManager = null;
            }
            guildPageStateManager.h(isShown());
        }
    }

    public /* synthetic */ GuildContentView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildContentView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        as f16 = as.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        f16.f442285c.setVerticalScrollBarEnabled(false);
        f16.f442285c.setHasFixedSize(true);
        c cVar = new c(context);
        cVar.a(true);
        f16.f442285c.setLayoutManager(cVar);
        h();
    }
}
