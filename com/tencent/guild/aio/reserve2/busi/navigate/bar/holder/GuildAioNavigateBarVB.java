package com.tencent.guild.aio.reserve2.busi.navigate.bar.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import er0.a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pq0.NavBarStyle;
import qq0.b;
import vn0.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u0016\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/navigate/bar/holder/GuildAioNavigateBarVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lqq0/b;", "Lcom/tencent/guild/aio/reserve2/busi/navigate/bar/holder/GuildAioNavigateBarUIState;", "state", "", "i1", "j1", "", "type", "Lpq0/a;", "d1", "Ler0/a$a;", "info", "", "e1", "h1", "f1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "Lcom/tencent/aio/base/mvvm/b;", "c1", "Lvn0/i;", "d", "Lvn0/i;", "mNavigationBarBinding", "", "e", "J", "lastClickTime", "<init>", "()V", "f", "Companion", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAioNavigateBarVB extends com.tencent.aio.base.mvvm.a<b, GuildAioNavigateBarUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private i mNavigationBarBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    private final NavBarStyle d1(int type) {
        NavBarStyle navBarStyle = new NavBarStyle(null, null, 0, 7, null);
        int ordinal = Companion.GuildNavigateType.KATME.ordinal();
        Integer valueOf = Integer.valueOf(R.color.qui_common_brand_standard);
        Integer valueOf2 = Integer.valueOf(R.color.qui_common_bg_top_light);
        if (type != ordinal && type != Companion.GuildNavigateType.KATALL.ordinal() && type != Companion.GuildNavigateType.KMYREDBAG.ordinal() && type != Companion.GuildNavigateType.KGIFT.ordinal() && type != Companion.GuildNavigateType.KNEWFILE.ordinal()) {
            navBarStyle.e(GuildUIUtils.w(getMContext(), R.drawable.guild_aio_nav_arrow_blue, valueOf));
            navBarStyle.f(R.color.qui_common_brand_standard);
            navBarStyle.d(GuildUIUtils.w(getMContext(), R.drawable.guild_aio_nav_unread_bg_selector, valueOf2));
        } else {
            navBarStyle.e(GuildUIUtils.w(getMContext(), R.drawable.guild_aio_nav_arrow_white, valueOf2));
            navBarStyle.f(R.color.qui_common_bg_top_light);
            navBarStyle.d(GuildUIUtils.w(getMContext(), R.drawable.guild_aio_nav_at_me_bg_selector, valueOf));
        }
        if (QQTheme.isNowThemeIsNight()) {
            navBarStyle.f(R.color.qui_common_text_allwhite_primary);
            navBarStyle.e(GuildUIUtils.w(getMContext(), R.drawable.guild_aio_nav_arrow_white, Integer.valueOf(R.color.qui_common_text_allwhite_primary)));
        }
        return navBarStyle;
    }

    private final String e1(a.C10261a info, GuildAioNavigateBarUIState state) {
        String valueOf;
        int type = info.getType();
        if (type == Companion.GuildNavigateType.KATME.ordinal()) {
            String string = getMContext().getString(R.string.f15082161);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.string.guild_nav_at_me)");
            return string;
        }
        if (type == Companion.GuildNavigateType.KATALL.ordinal()) {
            String string2 = getMContext().getString(R.string.f15081160);
            Intrinsics.checkNotNullExpressionValue(string2, "mContext.getString(R.string.guild_nav_at_all)");
            return string2;
        }
        if (type == Companion.GuildNavigateType.KREDBAG.ordinal()) {
            String string3 = getMContext().getString(R.string.f1510416m);
            Intrinsics.checkNotNullExpressionValue(string3, "mContext.getString(R.string.guild_nav_red_packet)");
            return string3;
        }
        if (type == Companion.GuildNavigateType.KMYREDBAG.ordinal()) {
            String string4 = getMContext().getString(R.string.f1510316l);
            Intrinsics.checkNotNullExpressionValue(string4, "mContext.getString(R.str\u2026_nav_personal_red_packet)");
            return string4;
        }
        if (type == Companion.GuildNavigateType.KGIFT.ordinal()) {
            String string5 = getMContext().getString(R.string.f1510116j);
            Intrinsics.checkNotNullExpressionValue(string5, "mContext.getString(R.string.guild_nav_gift)");
            return string5;
        }
        if (type == Companion.GuildNavigateType.KNEWFILE.ordinal()) {
            String string6 = getMContext().getString(R.string.f1510216k);
            Intrinsics.checkNotNullExpressionValue(string6, "mContext.getString(R.string.guild_nav_new_file)");
            return string6;
        }
        if (type == Companion.GuildNavigateType.KUNREAD.ordinal()) {
            if (state.getUnreadCount() > 0) {
                if (state.getUnreadCount() > 99) {
                    valueOf = "99+";
                } else {
                    valueOf = String.valueOf(state.getUnreadCount());
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string7 = getMContext().getString(R.string.f1510516n);
                Intrinsics.checkNotNullExpressionValue(string7, "mContext.getString(R.string.guild_nav_unread)");
                String format = String.format(string7, Arrays.copyOf(new Object[]{valueOf}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                return format;
            }
            QLog.i("GuildAioNavigateBarVB", 1, "getNavBarText, unread count = 0");
            return "";
        }
        QLog.i("GuildAioNavigateBarVB", 1, "getNavBarText, unknown type");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(GuildAioNavigateBarVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this$0.lastClickTime > 1000) {
            QLog.i("GuildAioNavigateBarVB", 1, "onCreateView onclick navigate bar");
            this$0.lastClickTime = currentTimeMillis;
            this$0.h1();
        } else {
            QLog.i("GuildAioNavigateBarVB", 1, "onCreateView, onclick navigate so fast");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void h1() {
        QLog.i("GuildAioNavigateBarVB", 1, "onNavBarClick");
        sendIntent(new b.a());
    }

    private final void i1(GuildAioNavigateBarUIState state) {
        i iVar = null;
        if (state.a().isEmpty()) {
            QLog.i("GuildAioNavigateBarVB", 1, "updateNavigationBar, hide nav bar");
            i iVar2 = this.mNavigationBarBinding;
            if (iVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBinding");
            } else {
                iVar = iVar2;
            }
            iVar.f441960b.setVisibility(8);
            return;
        }
        QLog.i("GuildAioNavigateBarVB", 1, "updateNavigationBar, show nav bar");
        i iVar3 = this.mNavigationBarBinding;
        if (iVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBinding");
        } else {
            iVar = iVar3;
        }
        iVar.f441960b.setVisibility(0);
        j1(state);
    }

    private final void j1(GuildAioNavigateBarUIState state) {
        state.a().isEmpty();
        a.C10261a c10261a = state.a().get(0);
        QLog.i("GuildAioNavigateBarVB", 1, "updateNavigationItem, info = " + c10261a);
        NavBarStyle d16 = d1(c10261a.getType());
        i iVar = this.mNavigationBarBinding;
        i iVar2 = null;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBinding");
            iVar = null;
        }
        iVar.f441961c.setImageDrawable(d16.getIconDrawable());
        i iVar3 = this.mNavigationBarBinding;
        if (iVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBinding");
            iVar3 = null;
        }
        iVar3.f441962d.setTextColor(getMContext().getResources().getColor(d16.getTextColor()));
        i iVar4 = this.mNavigationBarBinding;
        if (iVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBinding");
            iVar4 = null;
        }
        iVar4.f441960b.setBackground(d16.getBgDrawable());
        String e16 = e1(c10261a, state);
        i iVar5 = this.mNavigationBarBinding;
        if (iVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBinding");
        } else {
            iVar2 = iVar5;
        }
        iVar2.f441962d.setText(e16);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<b, GuildAioNavigateBarUIState> createVM() {
        return new GuildAioNavigateBarVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildAioNavigateBarUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        i1(state);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        i g16 = i.g(LayoutInflater.from(getMContext()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026      false\n            )");
        this.mNavigationBarBinding = g16;
        FrameLayout.LayoutParams a16 = com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -2, -2);
        a16.gravity = 5;
        a16.topMargin = createViewParams.a().getResources().getDimensionPixelOffset(R.dimen.cho);
        i iVar = this.mNavigationBarBinding;
        i iVar2 = null;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBinding");
            iVar = null;
        }
        iVar.getRoot().setLayoutParams(a16);
        i iVar3 = this.mNavigationBarBinding;
        if (iVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBinding");
            iVar3 = null;
        }
        iVar3.f441960b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.reserve2.busi.navigate.bar.holder.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildAioNavigateBarVB.g1(GuildAioNavigateBarVB.this, view);
            }
        });
        i iVar4 = this.mNavigationBarBinding;
        if (iVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigationBarBinding");
        } else {
            iVar2 = iVar4;
        }
        LinearLayout root = iVar2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mNavigationBarBinding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
    }
}
