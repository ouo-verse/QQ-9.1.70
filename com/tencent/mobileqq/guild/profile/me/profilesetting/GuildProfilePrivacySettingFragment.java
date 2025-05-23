package com.tencent.mobileqq.guild.profile.me.profilesetting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.util.QQToastUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J&\u0010\u0017\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/profilesetting/GuildProfilePrivacySettingFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "", "initView", "Lcom/tencent/mobileqq/widget/listitem/Group;", "gi", "Vh", "ni", "Landroid/view/View;", "view", "", "isChecked", "", "elementId", "pi", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "rh", "onBackEvent", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "T", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "U", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "quiListItemAdapter", "Lcom/tencent/mobileqq/guild/profile/me/profilesetting/x;", "V", "Lcom/tencent/mobileqq/guild/profile/me/profilesetting/x;", "viewModel", "<init>", "()V", "W", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfilePrivacySettingFragment extends QQGuildTokenTitleBarFragment {

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private QUISettingsRecyclerView recyclerView;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final QUIListItemAdapter quiListItemAdapter = new QUIListItemAdapter(QUIListItemStyle.Card, false, false, 6, null);

    /* renamed from: V, reason: from kotlin metadata */
    private x viewModel;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/profilesetting/GuildProfilePrivacySettingFragment$a;", "", "Landroid/content/Context;", "context", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.profile.me.profilesetting.GuildProfilePrivacySettingFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, new Intent(), GuildProfilePrivacySettingFragment.class, null, 8, null);
        }

        Companion() {
        }
    }

    private final Group Vh() {
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[4];
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.d("\u5141\u8bb8\u67e5\u770b\u6211\u7684QQ\u8d44\u6599"), new x.c.f(false, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.i
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildProfilePrivacySettingFragment.fi(GuildProfilePrivacySettingFragment.this, compoundButton, z16);
            }
        }, false));
        x xVar2 = this.viewModel;
        x xVar3 = null;
        if (xVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            xVar2 = null;
        }
        MutableLiveData<Boolean> f26 = xVar2.f2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.GuildProfilePrivacySettingFragment$createGuildPrivacyGroup$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                QUIListItemAdapter qUIListItemAdapter;
                if (Intrinsics.areEqual(Boolean.valueOf(xVar.O().getIsChecked()), it)) {
                    return;
                }
                x.c.f O = xVar.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.f(it.booleanValue());
                qUIListItemAdapter = this.quiListItemAdapter;
                qUIListItemAdapter.l0(xVar);
            }
        };
        f26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfilePrivacySettingFragment.Wh(Function1.this, obj);
            }
        });
        x xVar4 = this.viewModel;
        if (xVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            xVar4 = null;
        }
        MutableLiveData<Boolean> a26 = xVar4.a2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.GuildProfilePrivacySettingFragment$createGuildPrivacyGroup$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                QUIListItemAdapter qUIListItemAdapter;
                xVar.O().g(true);
                qUIListItemAdapter = this.quiListItemAdapter;
                qUIListItemAdapter.l0(xVar);
            }
        };
        a26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfilePrivacySettingFragment.Xh(Function1.this, obj);
            }
        });
        Unit unit = Unit.INSTANCE;
        aVarArr[0] = xVar;
        final com.tencent.mobileqq.widget.listitem.x xVar5 = new com.tencent.mobileqq.widget.listitem.x(new x.b.d("\u5141\u8bb8\u52a0\u6211\u4e3aQQ\u597d\u53cb"), new x.c.f(true, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.l
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildProfilePrivacySettingFragment.Yh(GuildProfilePrivacySettingFragment.this, compoundButton, z16);
            }
        }));
        x xVar6 = this.viewModel;
        if (xVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            xVar6 = null;
        }
        MutableLiveData<Pair<Boolean, Boolean>> Z1 = xVar6.Z1();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Pair<? extends Boolean, ? extends Boolean>, Unit> function13 = new Function1<Pair<? extends Boolean, ? extends Boolean>, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.GuildProfilePrivacySettingFragment$createGuildPrivacyGroup$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends Boolean> pair) {
                invoke2((Pair<Boolean, Boolean>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Boolean, Boolean> pair) {
                QUIListItemAdapter qUIListItemAdapter;
                xVar5.r(pair.getFirst().booleanValue());
                xVar5.O().g(pair.getFirst().booleanValue());
                if (xVar5.O().getIsChecked() != pair.getSecond().booleanValue()) {
                    xVar5.O().f(pair.getSecond().booleanValue());
                }
                qUIListItemAdapter = this.quiListItemAdapter;
                qUIListItemAdapter.l0(xVar5);
            }
        };
        Z1.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfilePrivacySettingFragment.Zh(Function1.this, obj);
            }
        });
        aVarArr[1] = xVar5;
        final com.tencent.mobileqq.widget.listitem.x xVar7 = new com.tencent.mobileqq.widget.listitem.x(new x.b.d("\u5141\u8bb8\u7ed9\u6211\u53d1\u79c1\u4fe1"), new x.c.f(true, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.n
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildProfilePrivacySettingFragment.ai(GuildProfilePrivacySettingFragment.this, compoundButton, z16);
            }
        }));
        x xVar8 = this.viewModel;
        if (xVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            xVar8 = null;
        }
        MutableLiveData<Boolean> h26 = xVar8.h2();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.GuildProfilePrivacySettingFragment$createGuildPrivacyGroup$6$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                QUIListItemAdapter qUIListItemAdapter;
                if (Intrinsics.areEqual(Boolean.valueOf(xVar7.O().getIsChecked()), it)) {
                    return;
                }
                x.c.f O = xVar7.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.f(it.booleanValue());
                qUIListItemAdapter = this.quiListItemAdapter;
                qUIListItemAdapter.l0(xVar7);
            }
        };
        h26.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfilePrivacySettingFragment.bi(Function1.this, obj);
            }
        });
        aVarArr[2] = xVar7;
        final com.tencent.mobileqq.widget.listitem.x xVar9 = new com.tencent.mobileqq.widget.listitem.x(new x.b.d("\u5141\u8bb8\u7ed9\u6211\u53d1\u8bc4\u8bba"), new x.c.f(true, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.p
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildProfilePrivacySettingFragment.ci(GuildProfilePrivacySettingFragment.this, compoundButton, z16);
            }
        }, false));
        x xVar10 = this.viewModel;
        if (xVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            xVar10 = null;
        }
        MutableLiveData<Boolean> g26 = xVar10.g2();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function15 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.GuildProfilePrivacySettingFragment$createGuildPrivacyGroup$8$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                QUIListItemAdapter qUIListItemAdapter;
                if (Intrinsics.areEqual(Boolean.valueOf(xVar9.O().getIsChecked()), it)) {
                    return;
                }
                x.c.f O = xVar9.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.f(it.booleanValue());
                qUIListItemAdapter = this.quiListItemAdapter;
                qUIListItemAdapter.l0(xVar9);
            }
        };
        g26.observe(viewLifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfilePrivacySettingFragment.di(Function1.this, obj);
            }
        });
        x xVar11 = this.viewModel;
        if (xVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            xVar3 = xVar11;
        }
        MutableLiveData<Boolean> d26 = xVar3.d2();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function16 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.GuildProfilePrivacySettingFragment$createGuildPrivacyGroup$8$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                QUIListItemAdapter qUIListItemAdapter;
                xVar9.O().g(true);
                qUIListItemAdapter = this.quiListItemAdapter;
                qUIListItemAdapter.l0(xVar9);
            }
        };
        d26.observe(viewLifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfilePrivacySettingFragment.ei(Function1.this, obj);
            }
        });
        aVarArr[3] = xVar9;
        return new Group("\u9891\u9053\u9690\u79c1\u8bbe\u7f6e", aVarArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(GuildProfilePrivacySettingFragment this$0, CompoundButton buttonView, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(buttonView, "buttonView");
        this$0.pi(buttonView, z16, "em_sgrp_mine_addqqfriend");
        x xVar = this$0.viewModel;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            xVar = null;
        }
        xVar.j2(z16);
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(GuildProfilePrivacySettingFragment this$0, CompoundButton buttonView, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(buttonView, "buttonView");
        this$0.pi(buttonView, z16, "em_sgrp_private_switch");
        x xVar = this$0.viewModel;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            xVar = null;
        }
        xVar.l2(z16);
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(GuildProfilePrivacySettingFragment this$0, CompoundButton buttonView, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(buttonView, "buttonView");
        this$0.pi(buttonView, z16, "em_sgrp_private_comment_switch");
        x xVar = this$0.viewModel;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            xVar = null;
        }
        xVar.s2(z16);
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(GuildProfilePrivacySettingFragment this$0, CompoundButton buttonView, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(buttonView, "buttonView");
        this$0.pi(buttonView, z16, "em_sgrp_qq_card_switch");
        x xVar = this$0.viewModel;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            xVar = null;
        }
        xVar.r2(z16);
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, z16);
    }

    private final Group gi() {
        String string = getString(R.string.f1522219t);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild\u2026ofile_visibility_setting)");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[2];
        String string2 = getString(R.string.f1520819f);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.guild_profile_feed_setting)");
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(string2), new x.c.f(true, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildProfilePrivacySettingFragment.hi(GuildProfilePrivacySettingFragment.this, compoundButton, z16);
            }
        }, false));
        x xVar2 = this.viewModel;
        x xVar3 = null;
        if (xVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            xVar2 = null;
        }
        MutableLiveData<Boolean> e26 = xVar2.e2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.GuildProfilePrivacySettingFragment$createProfileShowGroup$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                QUIListItemAdapter qUIListItemAdapter;
                if (Intrinsics.areEqual(Boolean.valueOf(xVar.O().getIsChecked()), it)) {
                    return;
                }
                x.c.f O = xVar.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.f(it.booleanValue());
                qUIListItemAdapter = this.quiListItemAdapter;
                qUIListItemAdapter.l0(xVar);
            }
        };
        e26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfilePrivacySettingFragment.ii(Function1.this, obj);
            }
        });
        x xVar4 = this.viewModel;
        if (xVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            xVar4 = null;
        }
        MutableLiveData<Boolean> a26 = xVar4.a2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.GuildProfilePrivacySettingFragment$createProfileShowGroup$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                QUIListItemAdapter qUIListItemAdapter;
                xVar.O().g(true);
                qUIListItemAdapter = this.quiListItemAdapter;
                qUIListItemAdapter.l0(xVar);
            }
        };
        a26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfilePrivacySettingFragment.ji(Function1.this, obj);
            }
        });
        Unit unit = Unit.INSTANCE;
        aVarArr[0] = xVar;
        String string3 = getString(R.string.f1521019h);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.guild_profile_joined_page)");
        final com.tencent.mobileqq.widget.listitem.x xVar5 = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(string3), new x.c.f(false, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildProfilePrivacySettingFragment.ki(GuildProfilePrivacySettingFragment.this, compoundButton, z16);
            }
        }, false));
        x xVar6 = this.viewModel;
        if (xVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            xVar6 = null;
        }
        MutableLiveData<Boolean> c26 = xVar6.c2();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.GuildProfilePrivacySettingFragment$createProfileShowGroup$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                QUIListItemAdapter qUIListItemAdapter;
                if (Intrinsics.areEqual(Boolean.valueOf(xVar5.O().getIsChecked()), it)) {
                    return;
                }
                x.c.f O = xVar5.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.f(it.booleanValue());
                qUIListItemAdapter = this.quiListItemAdapter;
                qUIListItemAdapter.l0(xVar5);
            }
        };
        c26.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfilePrivacySettingFragment.li(Function1.this, obj);
            }
        });
        x xVar7 = this.viewModel;
        if (xVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            xVar3 = xVar7;
        }
        MutableLiveData<Boolean> a27 = xVar3.a2();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.GuildProfilePrivacySettingFragment$createProfileShowGroup$4$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                QUIListItemAdapter qUIListItemAdapter;
                xVar5.O().g(true);
                qUIListItemAdapter = this.quiListItemAdapter;
                qUIListItemAdapter.l0(xVar5);
            }
        };
        a27.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfilePrivacySettingFragment.mi(Function1.this, obj);
            }
        });
        aVarArr[1] = xVar5;
        return new Group(string, aVarArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(GuildProfilePrivacySettingFragment this$0, CompoundButton buttonView, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(buttonView, "buttonView");
        this$0.pi(buttonView, z16, "em_sgrp_show_forum_switch");
        x xVar = this$0.viewModel;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            xVar = null;
        }
        xVar.q2(z16);
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initView() {
        setTitle("\u9690\u79c1\u8bbe\u7f6e");
        rh();
        View findViewById = this.P.findViewById(R.id.i4m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.recycler_view)");
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) findViewById;
        this.recyclerView = qUISettingsRecyclerView;
        x xVar = null;
        if (qUISettingsRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            qUISettingsRecyclerView = null;
        }
        qUISettingsRecyclerView.setAdapter(this.quiListItemAdapter);
        x a16 = x.INSTANCE.a(this);
        this.viewModel = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            xVar = a16;
        }
        MutableLiveData<ri1.a> b26 = xVar.b2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final GuildProfilePrivacySettingFragment$initView$1 guildProfilePrivacySettingFragment$initView$1 = new Function1<ri1.a, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.GuildProfilePrivacySettingFragment$initView$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ri1.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ri1.a aVar) {
                if (TextUtils.isEmpty(aVar.f431478b)) {
                    return;
                }
                QQToastUtil.showQQToast(1, aVar.f431478b);
            }
        };
        b26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfilePrivacySettingFragment.oi(Function1.this, obj);
            }
        });
        this.quiListItemAdapter.t0(gi(), Vh());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(GuildProfilePrivacySettingFragment this$0, CompoundButton buttonView, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(buttonView, "buttonView");
        this$0.pi(buttonView, z16, "em_sgrp_show_channel_switch");
        x xVar = this$0.viewModel;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            xVar = null;
        }
        xVar.p2(z16);
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ni() {
        Map mapOf;
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.P, "pg_sgrp_privacy_set_float");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE"));
        VideoReport.setPageParams(this.P, new PageParams((Map<String, ?>) mapOf));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void pi(View view, boolean isChecked, String elementId) {
        int i3;
        Map<String, ? extends Object> mapOf;
        if (isChecked) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        bt btVar = bt.f235484a;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_switch_condition", Integer.valueOf(i3)));
        btVar.g(view, elementId, "clck", mapOf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        initView();
        ni();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f2s;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        this.J.a();
        this.J.setBackgroundResource(R.drawable.lvj);
    }
}
