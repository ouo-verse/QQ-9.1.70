package com.tencent.mobileqq.guild.setting.guildsetting.part;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.dm;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/setting/guildsetting/part/GuildSettingItemPart$createOwnerConfig$1", "Lcom/tencent/mobileqq/widget/listitem/u;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "H", "view", "", "position", "", "", "payloads", "", UserInfo.SEX_FEMALE, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSettingItemPart$createOwnerConfig$1 extends com.tencent.mobileqq.widget.listitem.u {

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ GuildSettingItemPart f234459k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildSettingItemPart$createOwnerConfig$1(GuildSettingItemPart guildSettingItemPart) {
        this.f234459k = guildSettingItemPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(GuildSettingItemPart this$0, View v3) {
        com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.l lVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        lVar = this$0.viewModel;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            lVar = null;
        }
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        lVar.c2(v3);
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(GuildSettingItemPart this$0, View v3) {
        com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.l lVar;
        String str;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        lVar = this$0.viewModel;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            lVar = null;
        }
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        str = this$0.mOperationHelperUrl;
        lVar.f2(v3, str);
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    public void F(@NotNull View view, int position, @NotNull List<? extends Object> payloads) {
        dm dmVar;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.F(view, position, payloads);
        dmVar = this.f234459k.mManagerLayoutBinding;
        if (dmVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
            dmVar = null;
        }
        ch.Y0(dmVar.f442942b, "em_sgrp_set_channel_mange", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL);
    }

    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    protected View H(@NotNull ViewGroup parent) {
        dm dmVar;
        dm dmVar2;
        dm dmVar3;
        Intrinsics.checkNotNullParameter(parent, "parent");
        GuildSettingItemPart guildSettingItemPart = this.f234459k;
        dm g16 = dm.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        guildSettingItemPart.mManagerLayoutBinding = g16;
        dmVar = this.f234459k.mManagerLayoutBinding;
        dm dmVar4 = null;
        if (dmVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
            dmVar = null;
        }
        RelativeLayout relativeLayout = dmVar.f442942b;
        final GuildSettingItemPart guildSettingItemPart2 = this.f234459k;
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSettingItemPart$createOwnerConfig$1.O(GuildSettingItemPart.this, view);
            }
        });
        dmVar2 = this.f234459k.mManagerLayoutBinding;
        if (dmVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
            dmVar2 = null;
        }
        RelativeLayout relativeLayout2 = dmVar2.f442947g;
        final GuildSettingItemPart guildSettingItemPart3 = this.f234459k;
        relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSettingItemPart$createOwnerConfig$1.P(GuildSettingItemPart.this, view);
            }
        });
        LiveData<ev> s26 = this.f234459k.B9().s2();
        LifecycleOwner lifecycleOwner = this.f234459k.getPartHost().getLifecycleOwner();
        final GuildSettingItemPart guildSettingItemPart4 = this.f234459k;
        final Function1<ev, Unit> function1 = new Function1<ev, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingItemPart$createOwnerConfig$1$onCreateView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ev evVar) {
                invoke2(evVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ev evVar) {
                if (GuildSettingItemPart.this.isNeedVerify && evVar.a() == 2) {
                    GuildSettingItemPart.this.qa();
                    GuildSettingItemPart.this.isNeedVerify = false;
                }
            }
        };
        s26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingItemPart$createOwnerConfig$1.Q(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> noticeAuthorityEnd = this.f234459k.B9().getGuildSettingPermissionViewModel().getNoticeAuthorityEnd();
        LifecycleOwner lifecycleOwner2 = this.f234459k.getPartHost().getLifecycleOwner();
        final GuildSettingItemPart guildSettingItemPart5 = this.f234459k;
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingItemPart$createOwnerConfig$1$onCreateView$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x0082  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0086  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(Boolean bool) {
                dm dmVar5;
                dm dmVar6;
                dm dmVar7;
                dm dmVar8;
                dm dmVar9;
                dm dmVar10;
                dm dmVar11;
                dmVar5 = GuildSettingItemPart.this.mManagerLayoutBinding;
                dm dmVar12 = null;
                if (dmVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
                    dmVar5 = null;
                }
                if (dmVar5.f442942b.getVisibility() == 0) {
                    dmVar9 = GuildSettingItemPart.this.mManagerLayoutBinding;
                    if (dmVar9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
                        dmVar9 = null;
                    }
                    if (dmVar9.f442947g.getVisibility() == 8) {
                        dmVar10 = GuildSettingItemPart.this.mManagerLayoutBinding;
                        if (dmVar10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
                            dmVar10 = null;
                        }
                        dmVar10.f442952l.setVisibility(8);
                        dmVar11 = GuildSettingItemPart.this.mManagerLayoutBinding;
                        if (dmVar11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
                            dmVar11 = null;
                        }
                        dmVar11.f442942b.setBackgroundResource(R.drawable.qui_common_fill_light_secondary_round_8_bg_selector);
                        dmVar8 = GuildSettingItemPart.this.mManagerLayoutBinding;
                        if (dmVar8 != null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
                        } else {
                            dmVar12 = dmVar8;
                        }
                        QQGuildUIUtil.O(dmVar12.f442949i);
                    }
                }
                dmVar6 = GuildSettingItemPart.this.mManagerLayoutBinding;
                if (dmVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
                    dmVar6 = null;
                }
                dmVar6.f442952l.setVisibility(0);
                dmVar7 = GuildSettingItemPart.this.mManagerLayoutBinding;
                if (dmVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
                    dmVar7 = null;
                }
                dmVar7.f442942b.setBackgroundResource(R.drawable.guild_qui_common_fill_light_secondary_bg_top_round_8_selector);
                dmVar8 = GuildSettingItemPart.this.mManagerLayoutBinding;
                if (dmVar8 != null) {
                }
                QQGuildUIUtil.O(dmVar12.f442949i);
            }
        };
        noticeAuthorityEnd.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingItemPart$createOwnerConfig$1.R(Function1.this, obj);
            }
        });
        LiveData<IGProGuildInfo> j26 = this.f234459k.B9().j2();
        LifecycleOwner lifecycleOwner3 = this.f234459k.getPartHost().getLifecycleOwner();
        final GuildSettingItemPart guildSettingItemPart6 = this.f234459k;
        final Function1<IGProGuildInfo, Unit> function13 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingItemPart$createOwnerConfig$1$onCreateView$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                if (iGProGuildInfo == null) {
                    return;
                }
                GuildSettingItemPart.this.ha(iGProGuildInfo);
                GuildSettingItemPart.this.Ma(iGProGuildInfo);
            }
        };
        j26.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingItemPart$createOwnerConfig$1.S(Function1.this, obj);
            }
        });
        dmVar3 = this.f234459k.mManagerLayoutBinding;
        if (dmVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mManagerLayoutBinding");
        } else {
            dmVar4 = dmVar3;
        }
        ConstraintLayout mContainer = dmVar4.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "mManagerLayoutBinding.root");
        return mContainer;
    }
}
