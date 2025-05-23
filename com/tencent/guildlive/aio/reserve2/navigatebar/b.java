package com.tencent.guildlive.aio.reserve2.navigatebar;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.guild.aio.reserve2.busi.navigate.bar.holder.GuildAioNavigateBarUIState;
import com.tencent.guild.aio.reserve2.busi.navigate.bar.holder.GuildAioNavigateBarVB;
import com.tencent.guild.aio.reserve2.holder.GuildReserve2UIState;
import com.tencent.guildlive.aio.reserve2.navigatebar.GuildLiveNavigateBarUIState;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import er0.a;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import qq0.b;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001e\u00a8\u0006&"}, d2 = {"Lcom/tencent/guildlive/aio/reserve2/navigatebar/b;", "Lcom/tencent/aio/base/mvvm/a;", "Lqq0/b;", "Lcom/tencent/guild/aio/reserve2/holder/GuildReserve2UIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "", "c1", "h1", "Lcom/tencent/guild/aio/reserve2/busi/navigate/bar/holder/GuildAioNavigateBarUIState;", "state", "i1", "j1", "k1", "Ler0/a$a;", "info", "", "f1", "Lcom/tencent/aio/base/mvvm/b;", "e1", "Landroid/view/View;", "onCreateView", "bindViewAndData", "g1", "Lz12/h;", "d", "Lz12/h;", "mNavigationBarBinding", "", "e", "Z", "mShowState", "f", "mIsLandScreen", "<init>", "()V", h.F, "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends com.tencent.aio.base.mvvm.a<qq0.b, GuildReserve2UIState> {

    /* renamed from: i, reason: collision with root package name */
    private static final int f112944i = ViewUtils.dip2px(72.0f);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private z12.h mNavigationBarBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mShowState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLandScreen;

    private final void c1(com.tencent.mvi.api.help.a createViewParams) {
        FrameLayout.LayoutParams a16 = com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -2, -2);
        a16.gravity = 8388613;
        a16.topMargin = f112944i;
        z12.h hVar = this.mNavigationBarBinding;
        z12.h hVar2 = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBinding");
            hVar = null;
        }
        hVar.getRoot().setLayoutParams(a16);
        z12.h hVar3 = this.mNavigationBarBinding;
        if (hVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBinding");
        } else {
            hVar2 = hVar3;
        }
        hVar2.f451774b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildlive.aio.reserve2.navigatebar.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.d1(b.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h1();
        z12.h hVar = this$0.mNavigationBarBinding;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBinding");
            hVar = null;
        }
        yr0.a.o("clck", hVar.f451776d, null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String f1(a.C10261a info, GuildAioNavigateBarUIState state) {
        String valueOf;
        GuildLiveLogUtil.Companion companion = GuildLiveLogUtil.INSTANCE;
        companion.e("GLAioNavBarVB", "[getNavBarText] info.type = " + info.getType());
        int type = info.getType();
        if (type == GuildAioNavigateBarVB.Companion.GuildNavigateType.KATME.ordinal()) {
            String string = getMContext().getString(R.string.f15082161);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.string.guild_nav_at_me)");
            return string;
        }
        if (type == GuildAioNavigateBarVB.Companion.GuildNavigateType.KATALL.ordinal()) {
            String string2 = getMContext().getString(R.string.f15081160);
            Intrinsics.checkNotNullExpressionValue(string2, "mContext.getString(R.string.guild_nav_at_all)");
            return string2;
        }
        if (type == GuildAioNavigateBarVB.Companion.GuildNavigateType.KREDBAG.ordinal()) {
            String string3 = getMContext().getString(R.string.f1510416m);
            Intrinsics.checkNotNullExpressionValue(string3, "mContext.getString(R.string.guild_nav_red_packet)");
            return string3;
        }
        if (type == GuildAioNavigateBarVB.Companion.GuildNavigateType.KMYREDBAG.ordinal()) {
            String string4 = getMContext().getString(R.string.f1510316l);
            Intrinsics.checkNotNullExpressionValue(string4, "mContext.getString(R.str\u2026_nav_personal_red_packet)");
            return string4;
        }
        if (type == GuildAioNavigateBarVB.Companion.GuildNavigateType.KGIFT.ordinal()) {
            String string5 = getMContext().getString(R.string.f1510116j);
            Intrinsics.checkNotNullExpressionValue(string5, "mContext.getString(R.string.guild_nav_gift)");
            return string5;
        }
        if (type != GuildAioNavigateBarVB.Companion.GuildNavigateType.KUNREAD.ordinal()) {
            return "";
        }
        companion.e("GLAioNavBarVB", "getNavBarText, unread count = " + state.getUnreadCount());
        if (state.getUnreadCount() <= 0) {
            return "";
        }
        if (state.getUnreadCount() > 99) {
            valueOf = "99+";
        } else {
            valueOf = String.valueOf(state.getUnreadCount());
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string6 = getMContext().getString(R.string.f1510516n);
        Intrinsics.checkNotNullExpressionValue(string6, "mContext.getString(R.string.guild_nav_unread)");
        String format = String.format(string6, Arrays.copyOf(new Object[]{valueOf}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    private final void h1() {
        GuildLiveLogUtil.INSTANCE.e("GLAioNavBarVB", "[onNavBarClick] ");
        sendIntent(new b.a());
    }

    private final void i1(GuildAioNavigateBarUIState state) {
        this.mShowState = !state.a().isEmpty();
        j1();
        if (this.mShowState) {
            k1(state);
        }
    }

    private final void j1() {
        boolean z16;
        GuildLiveLogUtil.INSTANCE.e("GLAioNavBarVB", "[updateNavigationBarVisible] mShowState = " + this.mShowState + ", mIsLandScreen = " + this.mIsLandScreen);
        if (this.mShowState && !this.mIsLandScreen) {
            z16 = true;
        } else {
            z16 = false;
        }
        z12.h hVar = this.mNavigationBarBinding;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBinding");
            hVar = null;
        }
        yr0.a.s(hVar.f451774b, z16);
        if (z16) {
            z12.h hVar2 = this.mNavigationBarBinding;
            if (hVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBinding");
                hVar2 = null;
            }
            yr0.a.o("imp", hVar2.f451776d, null, 4, null);
        }
    }

    private final void k1(GuildAioNavigateBarUIState state) {
        List<a.C10261a> a16 = state.a();
        a16.isEmpty();
        String f16 = f1(a16.get(0), state);
        z12.h hVar = this.mNavigationBarBinding;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBinding");
            hVar = null;
        }
        hVar.f451776d.setText(f16);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        z12.h hVar = this.mNavigationBarBinding;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBinding");
            hVar = null;
        }
        yr0.a.q(hVar.f451776d, "em_aio_ear", null, 4, null);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<qq0.b, GuildReserve2UIState> createVM() {
        return new GuildLiveAioNavigateBarVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildReserve2UIState state) {
        boolean z16;
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildAioNavigateBarUIState) {
            i1((GuildAioNavigateBarUIState) state);
            return;
        }
        if (state instanceof GuildLiveNavigateBarUIState.VideoScreenChange) {
            if (((GuildLiveNavigateBarUIState.VideoScreenChange) state).getState() == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsLandScreen = z16;
            j1();
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        z12.h g16 = z12.h.g(LayoutInflater.from(getMContext()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026          false\n        )");
        this.mNavigationBarBinding = g16;
        c1(createViewParams);
        z12.h hVar = this.mNavigationBarBinding;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBinding");
            hVar = null;
        }
        LinearLayout root = hVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mNavigationBarBinding.root");
        return root;
    }
}
