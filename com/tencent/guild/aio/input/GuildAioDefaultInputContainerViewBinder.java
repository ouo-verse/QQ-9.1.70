package com.tencent.guild.aio.input;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.base.mvvm.a;
import com.tencent.guild.aio.component.slowmode.SlowModeAIOType;
import com.tencent.guild.aio.input.GuildAioDefaultInputContainerViewBinder;
import com.tencent.guild.aio.input.realinput.GuildAioDefaultInputViewBinder;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.mvi.base.mvi.MviUIState;
import fo0.c;
import g12.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mp0.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\rH\u0016J&\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0011\u0012\u0006\b\u0001\u0012\u00020\u00120\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputContainerViewBinder;", "Lcom/tencent/aio/base/mvvm/a;", "Lfo0/c;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Landroid/content/Context;", "context", "com/tencent/guild/aio/input/GuildAioDefaultInputContainerViewBinder$interceptTouchLinearLayout$1", "d1", "(Landroid/content/Context;)Lcom/tencent/guild/aio/input/GuildAioDefaultInputContainerViewBinder$interceptTouchLinearLayout$1;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "c1", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "", "bindViewAndData", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAioDefaultInputContainerViewBinder extends a<c, InputUIState> {
    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.guild.aio.input.GuildAioDefaultInputContainerViewBinder$interceptTouchLinearLayout$1] */
    private final GuildAioDefaultInputContainerViewBinder$interceptTouchLinearLayout$1 d1(final Context context) {
        return new LinearLayout(context) { // from class: com.tencent.guild.aio.input.GuildAioDefaultInputContainerViewBinder$interceptTouchLinearLayout$1
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                super.dispatchTouchEvent(ev5);
                return true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(GuildAioDefaultInputContainerViewBinder this$0, GuildAioDefaultInputContainerViewBinder$interceptTouchLinearLayout$1 root, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(root, "$root");
        this$0.sendIntent(new c.InputBarHeightChangeIntent(root.getHeight()));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        b bVar = b.f401087a;
        GuildHistogramScene guildHistogramScene = GuildHistogramScene.GUILD_AIO_BIND_INPUT_TIME_COST;
        bVar.h(guildHistogramScene, "");
        super.bindViewAndData();
        sendIntent(c.a.f400132d);
        bVar.a(guildHistogramScene, "");
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<c, InputUIState> createVM() {
        return new GuildAioDefaultInputContainerViewModel();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<a<? extends ol3.b, ? extends MviUIState>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        int i3 = 3;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new a[]{new mp0.c(null, 1, 0 == true ? 1 : 0), new g(), new rp0.a(0 == true ? 1 : 0, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0), new np0.a(0 == true ? 1 : 0, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0), new pp0.a(0, 0, 0, null, 15, null), new com.tencent.guild.aio.component.slowmode.c(SlowModeAIOType.DEFAULT), new com.tencent.guild.aio.component.publisher.c(), new GuildAioDefaultInputViewBinder()});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        final GuildAioDefaultInputContainerViewBinder$interceptTouchLinearLayout$1 d16 = d1(createViewParams.a());
        FrameLayout.LayoutParams a16 = com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, -2);
        a16.gravity = 80;
        d16.setLayoutParams(a16);
        d16.setOrientation(1);
        d16.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: fo0.d
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                GuildAioDefaultInputContainerViewBinder.e1(GuildAioDefaultInputContainerViewBinder.this, d16, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
        return d16;
    }
}
