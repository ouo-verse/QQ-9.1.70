package com.tencent.mobileqq.guild.channel.create.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vp1.dt;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0002)\u000bB\u001d\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J!\u0010\u000e\u001a\u00020\u00062\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\f\"\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u000e\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0010R$\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0011j\b\u0012\u0004\u0012\u00020\b`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/create/widget/SubChannelIconView;", "Landroid/widget/ViewSwitcher;", "Lvp1/dt;", "c", "", "switchDuration", "", "e", "Lcom/tencent/mobileqq/guild/channel/create/widget/SubChannelIconView$b;", "iconRes", "binding", "b", "", "icons", "setIcons", "([Lcom/tencent/mobileqq/guild/channel/create/widget/SubChannelIconView$b;)V", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "subChannelIcons", "Lvp1/dt;", "childView1Binding", "f", "childView2Binding", "", h.F, "I", "nextIconIndex", "Ljava/lang/Runnable;", "i", "Ljava/lang/Runnable;", "delaySwitchIconRunnable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class SubChannelIconView extends ViewSwitcher {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<b> subChannelIcons;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private dt childView1Binding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private dt childView2Binding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int nextIconIndex;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable delaySwitchIconRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/create/widget/SubChannelIconView$b;", "", "", "a", "I", "()I", "backgroundResId", "b", "iconRes", "<init>", "(II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int backgroundResId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int iconRes;

        public b(int i3, int i16) {
            this.backgroundResId = i3;
            this.iconRes = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getBackgroundResId() {
            return this.backgroundResId;
        }

        /* renamed from: b, reason: from getter */
        public final int getIconRes() {
            return this.iconRes;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SubChannelIconView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b(b iconRes, dt binding) {
        binding.f442993c.setBackgroundResource(iconRes.getBackgroundResId());
        if (iconRes.getIconRes() != 0) {
            ImageView imageView = binding.f442992b;
            Context context = binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
            imageView.setImageDrawable(GuildUIUtils.y(context, iconRes.getIconRes(), QQGuildUIUtil.i(binding.f442992b.getContext(), R.color.qui_common_text_primary)));
        }
    }

    private final dt c() {
        View inflate = View.inflate(getContext(), R.layout.f9i, null);
        addView(inflate);
        dt e16 = dt.e(inflate);
        Intrinsics.checkNotNullExpressionValue(e16, "bind(view)");
        return e16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SubChannelIconView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e(2500L);
    }

    private final void e(long switchDuration) {
        dt dtVar = this.childView1Binding;
        dt dtVar2 = this.childView2Binding;
        if (this.subChannelIcons.size() == 1) {
            b bVar = this.subChannelIcons.get(0);
            Intrinsics.checkNotNullExpressionValue(bVar, "subChannelIcons[0]");
            Intrinsics.checkNotNull(dtVar);
            b(bVar, dtVar);
            return;
        }
        View nextView = getNextView();
        Intrinsics.checkNotNull(dtVar);
        if (nextView != dtVar.f442993c) {
            Intrinsics.checkNotNull(dtVar2);
            dtVar = dtVar2;
        }
        b bVar2 = this.subChannelIcons.get(this.nextIconIndex);
        Intrinsics.checkNotNullExpressionValue(bVar2, "subChannelIcons[nextIconIndex]");
        b(bVar2, dtVar);
        showNext();
        int i3 = this.nextIconIndex + 1;
        this.nextIconIndex = i3;
        if (i3 >= this.subChannelIcons.size()) {
            this.nextIconIndex = 0;
        }
    }

    static /* synthetic */ void f(SubChannelIconView subChannelIconView, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 1500;
        }
        subChannelIconView.e(j3);
    }

    public final void setIcons(@NotNull b... icons) {
        List<b> asList;
        Intrinsics.checkNotNullParameter(icons, "icons");
        asList = ArraysKt___ArraysJvmKt.asList(icons);
        setIcons(asList);
    }

    public /* synthetic */ SubChannelIconView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    public final void setIcons(@NotNull List<b> icons) {
        Intrinsics.checkNotNullParameter(icons, "icons");
        this.nextIconIndex = 0;
        this.subChannelIcons.clear();
        this.subChannelIcons.addAll(icons);
        if (icons.isEmpty()) {
            this.childView1Binding = null;
            this.childView2Binding = null;
            removeAllViews();
            return;
        }
        if (icons.size() == 1) {
            dt dtVar = this.childView2Binding;
            if (dtVar != null) {
                removeView(dtVar.f442993c);
                this.childView2Binding = null;
            }
            if (this.childView1Binding == null) {
                this.childView1Binding = c();
            }
        } else {
            if (this.childView1Binding == null) {
                this.childView1Binding = c();
            }
            if (this.childView2Binding == null) {
                this.childView2Binding = c();
            }
        }
        f(this, 0L, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SubChannelIconView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.subChannelIcons = new ArrayList<>();
        this.delaySwitchIconRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.channel.create.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                SubChannelIconView.d(SubChannelIconView.this);
            }
        };
    }
}
