package com.tencent.mobileqq.guild.setting.guildmanage.speak.rule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.config.subconfig.parser.GuildSpeakRuleParser;
import com.tencent.mobileqq.guild.ipc.methods.GuildSetSpeakRuleBlockWordRealMethod;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.BaseGuildRolePartUnlimitedView;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 _2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001`B\u0007\u00a2\u0006\u0004\b]\u0010^J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0019\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\u00020\nH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJF\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016*\u00020\n2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J6\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001e0\u0016*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00112\u0006\u0010\u0014\u001a\u00020\u001dH\u0002J>\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00112\u0006\u0010\u0014\u001a\u00020\u001dH\u0002J\b\u0010%\u001a\u00020\u0004H\u0002J\b\u0010&\u001a\u00020\u0004H\u0002J\b\u0010'\u001a\u00020\u0004H\u0002J\b\u0010(\u001a\u00020\u0004H\u0002J\b\u0010)\u001a\u00020\u0004H\u0002J \u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020*H\u0002J\b\u0010/\u001a\u00020\u000fH\u0014J$\u00106\u001a\u00020\u00042\u0006\u00101\u001a\u0002002\b\u00103\u001a\u0004\u0018\u0001022\b\u00105\u001a\u0004\u0018\u000104H\u0014J\u001a\u00107\u001a\u00020\u00042\u0006\u0010-\u001a\u00020*2\b\u00105\u001a\u0004\u0018\u000104H\u0016J\b\u00108\u001a\u00020\u0004H\u0016J\b\u00109\u001a\u00020\u0004H\u0016J\b\u0010:\u001a\u00020\u0004H\u0016J\u0012\u0010=\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010;H\u0016J$\u0010A\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030?0>j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030?`@H\u0016R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\"\u0010L\u001a\u00020\u00078\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010T\u001a\u00020M8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010\\\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/GuildSpeakRuleSettingFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/ipc/methods/GuildSetSpeakRuleBlockWordRealMethod$SetSpeakRuleBlockWordEvent;", "", "initView", "", "", "prohibiteWds", "oi", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Yh", "(Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;)[Lcom/tencent/mobileqq/widget/listitem/Group;", "", "left", "Landroidx/lifecycle/LiveData;", "prohibiteWords", "Landroid/view/View$OnClickListener;", "listener", "elementId", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "si", "textResId", "", "isChecked", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "Sh", "subTextId", "Lcom/tencent/mobileqq/widget/listitem/c;", "Lcom/tencent/mobileqq/widget/listitem/c$a$g;", "Lcom/tencent/mobileqq/widget/listitem/c$b$b;", "Uh", "ni", "initViewModel", WidgetCacheLunarData.JI, "Wh", "pi", "Landroid/view/View;", "reportView", "mi", "view", "ii", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/GuildRolePartUnlimitedView;", "T", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/GuildRolePartUnlimitedView;", "mRolePartVew", "U", "Ljava/lang/String;", "gi", "()Ljava/lang/String;", "qi", "(Ljava/lang/String;)V", "mGuildId", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/ad;", "V", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/ad;", "hi", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/ad;", "ri", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/ad;)V", "mViewModel", "Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildSpeakRuleParser$b;", "W", "Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildSpeakRuleParser$b;", "getConfig", "()Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildSpeakRuleParser$b;", "setConfig", "(Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildSpeakRuleParser$b;)V", DownloadInfo.spKey_Config, "<init>", "()V", "X", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSpeakRuleSettingFragment extends QQGuildTokenTitleBarFragment implements SimpleEventReceiver<GuildSetSpeakRuleBlockWordRealMethod.SetSpeakRuleBlockWordEvent> {

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private GuildRolePartUnlimitedView mRolePartVew;

    /* renamed from: U, reason: from kotlin metadata */
    public String mGuildId;

    /* renamed from: V, reason: from kotlin metadata */
    public ad mViewModel;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private GuildSpeakRuleParser.b config;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/GuildSpeakRuleSettingFragment$a;", "", "", "guildId", "Landroid/content/Intent;", "a", "FEED_RECOVERY_URL", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.GuildSpeakRuleSettingFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Intent a(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intent intent = new Intent();
            intent.putExtra("extra_guild_id", guildId);
            return intent;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/speak/rule/GuildSpeakRuleSettingFragment$b", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/BaseGuildRolePartUnlimitedView$b;", "Landroid/view/View;", "v", "", "elementId", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements BaseGuildRolePartUnlimitedView.b {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.BaseGuildRolePartUnlimitedView.b
        public void a(@NotNull View v3, @NotNull String elementId) {
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(v3, elementId, null);
        }
    }

    private final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> Sh(final QUIListItemAdapter qUIListItemAdapter, int i3, LiveData<Boolean> liveData, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        String string = getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "getString(textResId)");
        final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string), new x.c.f(false, onCheckedChangeListener));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.GuildSpeakRuleSettingFragment$check$1$1
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
                x.c.f O = xVar.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.f(it.booleanValue());
                qUIListItemAdapter.l0(xVar);
                this.Wh();
            }
        };
        liveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSpeakRuleSettingFragment.Th(Function1.this, obj);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final com.tencent.mobileqq.widget.listitem.c<c.a.g, c.b.C8994b> Uh(final QUIListItemAdapter qUIListItemAdapter, int i3, int i16, LiveData<Boolean> liveData, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        String string = getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "getString(textResId)");
        String string2 = getString(i16);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(subTextId)");
        final com.tencent.mobileqq.widget.listitem.c<c.a.g, c.b.C8994b> cVar = new com.tencent.mobileqq.widget.listitem.c<>(new c.a.g(string, string2), new c.b.C8994b(false, onCheckedChangeListener));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.GuildSpeakRuleSettingFragment$check2$1$1
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
                c.b.C8994b O = cVar.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.e(it.booleanValue());
                qUIListItemAdapter.l0(cVar);
                this.Wh();
            }
        };
        liveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSpeakRuleSettingFragment.Vh(Function1.this, obj);
            }
        });
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh() {
        boolean z16;
        Boolean value = hi().c2().getValue();
        Boolean bool = Boolean.TRUE;
        if (!Intrinsics.areEqual(value, bool) && !Intrinsics.areEqual(hi().a2().getValue(), bool) && !Intrinsics.areEqual(hi().X1().getValue(), bool) && bl.b(hi().S1().getValue()) && !Intrinsics.areEqual(hi().b2().getValue(), bool)) {
            z16 = false;
        } else {
            z16 = true;
        }
        GuildRolePartUnlimitedView guildRolePartUnlimitedView = null;
        if (z16) {
            GuildRolePartUnlimitedView guildRolePartUnlimitedView2 = this.mRolePartVew;
            if (guildRolePartUnlimitedView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRolePartVew");
                guildRolePartUnlimitedView2 = null;
            }
            if (guildRolePartUnlimitedView2.getVisibility() != 0) {
                GuildRolePartUnlimitedView guildRolePartUnlimitedView3 = this.mRolePartVew;
                if (guildRolePartUnlimitedView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRolePartVew");
                    guildRolePartUnlimitedView3 = null;
                }
                guildRolePartUnlimitedView3.setVisibility(0);
                GuildRolePartUnlimitedView guildRolePartUnlimitedView4 = this.mRolePartVew;
                if (guildRolePartUnlimitedView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRolePartVew");
                } else {
                    guildRolePartUnlimitedView = guildRolePartUnlimitedView4;
                }
                guildRolePartUnlimitedView.c0();
                return;
            }
            return;
        }
        GuildRolePartUnlimitedView guildRolePartUnlimitedView5 = this.mRolePartVew;
        if (guildRolePartUnlimitedView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRolePartVew");
        } else {
            guildRolePartUnlimitedView = guildRolePartUnlimitedView5;
        }
        guildRolePartUnlimitedView.setVisibility(8);
    }

    @JvmStatic
    @NotNull
    public static final Intent Xh(@NotNull String str) {
        return INSTANCE.a(str);
    }

    private final Group[] Yh(QUIListItemAdapter qUIListItemAdapter) {
        boolean z16;
        boolean z17;
        final ArrayList arrayList = new ArrayList();
        arrayList.add(Sh(qUIListItemAdapter, R.string.f157051lv, hi().a2(), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.t
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z18) {
                GuildSpeakRuleSettingFragment.ai(GuildSpeakRuleSettingFragment.this, compoundButton, z18);
            }
        }));
        arrayList.add(Sh(qUIListItemAdapter, R.string.f157081ly, hi().b2(), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.u
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z18) {
                GuildSpeakRuleSettingFragment.bi(GuildSpeakRuleSettingFragment.this, compoundButton, z18);
            }
        }));
        arrayList.add(Sh(qUIListItemAdapter, R.string.f157031lt, hi().Z1(), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.v
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z18) {
                GuildSpeakRuleSettingFragment.ci(GuildSpeakRuleSettingFragment.this, compoundButton, z18);
            }
        }));
        GuildSpeakRuleParser.b bVar = this.config;
        if (bVar != null && bVar.getShowAd()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            arrayList.add(Uh(qUIListItemAdapter, R.string.f157011lr, R.string.f157021ls, hi().X1(), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.w
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z18) {
                    GuildSpeakRuleSettingFragment.di(GuildSpeakRuleSettingFragment.this, compoundButton, z18);
                }
            }));
        }
        arrayList.add(Uh(qUIListItemAdapter, R.string.f157111m1, R.string.f1487810i, hi().d2(), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.x
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z18) {
                GuildSpeakRuleSettingFragment.ei(GuildSpeakRuleSettingFragment.this, compoundButton, z18);
            }
        }));
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> si5 = si(qUIListItemAdapter, R.string.f157121m2, hi().S1(), new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSpeakRuleSettingFragment.fi(arrayList, this, view);
            }
        }, "em_sgrp_no_qr_switch");
        GuildSpeakRuleParser.b bVar2 = this.config;
        if (bVar2 != null && bVar2.getShowBlockWords()) {
            z17 = true;
        } else {
            z17 = false;
        }
        qUIListItemAdapter.m0(si5, z17);
        arrayList.add(si5);
        Object[] array = arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.d("\u5e16\u5b50\u6062\u590d"), new x.c.g("", false, false, 6, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSpeakRuleSettingFragment.Zh(GuildSpeakRuleSettingFragment.this, view);
            }
        });
        Unit unit = Unit.INSTANCE;
        return new Group[]{new Group("\u9891\u9053\u6210\u5458\u53d1\u5e16\u547d\u4e2d\u4ee5\u4e0b\u7c7b\u578b\uff0c\u5c06\u81ea\u52a8\u88ab\u5c4f\u853d", (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)), new Group("\u5c4f\u853d\u7684\u5185\u5bb9\u53ef\u5728\u6b64\u67e5\u770b\u4e0e\u6062\u590d", xVar)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(GuildSpeakRuleSettingFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.ii(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(GuildSpeakRuleSettingFragment this$0, CompoundButton view, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(view, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ad.f2(this$0.hi(), this$0.gi(), null, Boolean.valueOf(z16), null, null, null, null, null, 250, null);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.mi(view, z16, "em_sgrp_no_link_switch");
        EventCollector.getInstance().onCompoundButtonChecked(view, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(GuildSpeakRuleSettingFragment this$0, CompoundButton view, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(view, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ad.f2(this$0.hi(), this$0.gi(), null, null, Boolean.valueOf(z16), null, null, null, null, 246, null);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.mi(view, z16, "em_sgrp_no_qr_switch");
        EventCollector.getInstance().onCompoundButtonChecked(view, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(GuildSpeakRuleSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ad.f2(this$0.hi(), this$0.gi(), null, null, null, null, Boolean.valueOf(z16), null, null, 222, null);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(GuildSpeakRuleSettingFragment this$0, CompoundButton view, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(view, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ad.f2(this$0.hi(), this$0.gi(), null, null, null, Boolean.valueOf(z16), null, null, null, 238, null);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.mi(view, z16, "em_sgrp_no_qr_switch");
        EventCollector.getInstance().onCompoundButtonChecked(view, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(GuildSpeakRuleSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ad.f2(this$0.hi(), this$0.gi(), null, null, null, null, null, Boolean.valueOf(z16), null, 190, null);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(ArrayList this_apply, GuildSpeakRuleSettingFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            cx.a(this$0.getContext(), "https://qun.qq.com/qunng/next/h5/banned-keywords?guildId=" + this$0.gi());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ii(View view) {
        ch.i1(getActivity(), "https://qun.qq.com/guild/h5/guild-feeds-manage/index.html#/feedsManage?guildid=" + gi());
    }

    private final void initView() {
        this.E.setText(getString(R.string.f1489110v));
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) this.P.findViewById(R.id.i4m);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(null, false, false, 7, null);
        qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
        Group[] Yh = Yh(qUIListItemAdapter);
        qUIListItemAdapter.t0((Group[]) Arrays.copyOf(Yh, Yh.length));
        Context context = this.P.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mContentView.context");
        GuildRolePartUnlimitedView guildRolePartUnlimitedView = new GuildRolePartUnlimitedView(context);
        this.mRolePartVew = guildRolePartUnlimitedView;
        guildRolePartUnlimitedView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    private final void initViewModel() {
        ViewModel viewModel = com.tencent.mobileqq.mvvm.h.b(this, ad.INSTANCE.a()).get(ad.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(this\u2026ingViewModel::class.java)");
        ri((ad) viewModel);
        hi().W1(gi());
        ji();
    }

    private final void ji() {
        hi().T1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSpeakRuleSettingFragment.ki(GuildSpeakRuleSettingFragment.this, (cf1.b) obj);
            }
        });
        hi().R1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSpeakRuleSettingFragment.li(GuildSpeakRuleSettingFragment.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(GuildSpeakRuleSettingFragment this$0, cf1.b bVar) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bVar != null) {
            if (bVar.f30775b != 0 || !ch.p(bVar.f30776c)) {
                if (TextUtils.isEmpty(bVar.f30774a)) {
                    str = HardCodeUtil.qqStr(R.string.f155831ik);
                } else {
                    str = bVar.f30774a;
                }
                SecurityTipHelperKt.N(bVar.f30776c, this$0.getContext(), bVar.f30775b, str, false, null, 48, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(GuildSpeakRuleSettingFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            HashMap hashMap = new HashMap();
            Boolean value = this$0.hi().c2().getValue();
            Boolean bool = Boolean.TRUE;
            hashMap.put("sgrp_no_redpacket_switch_type", Integer.valueOf(Intrinsics.areEqual(value, bool) ? 1 : 0));
            hashMap.put("sgrp_no_link_switch_type", Integer.valueOf(Intrinsics.areEqual(this$0.hi().a2().getValue(), bool) ? 1 : 0));
            hashMap.put("sgrp_no_qr_switch_type", Integer.valueOf(Intrinsics.areEqual(this$0.hi().b2().getValue(), bool) ? 1 : 0));
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this$0.P, this$0.gi(), hashMap);
        }
    }

    private final void mi(View reportView, boolean isChecked, String elementId) {
        String str;
        HashMap hashMap = new HashMap();
        if (isChecked) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("sgrp_switch_type", str);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(reportView, elementId, hashMap);
    }

    private final void ni() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            String stringExtra = intent.getStringExtra("extra_guild_id");
            if (stringExtra == null) {
                stringExtra = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(stringExtra, "getStringExtra(QQGuildCo\u2026EXTRA_KEY_GUILD_ID) ?: \"\"");
            }
            qi(stringExtra);
            if (QLog.isColorLevel()) {
                QLog.d("QQGuildCustomTitleBarFragment", 1, "resolveIntent guildId = " + gi());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String oi(List<String> prohibiteWds) {
        if (bl.b(prohibiteWds)) {
            String string = getString(R.string.f157131m3);
            Intrinsics.checkNotNullExpressionValue(string, "{\n            getString(\u2026it_words_empty)\n        }");
            return string;
        }
        return prohibiteWds.size() + getString(R.string.f15196194);
    }

    private final void pi() {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.P, "pg_sgrp_sgrp_batch_manage_auto");
    }

    private final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> si(final QUIListItemAdapter qUIListItemAdapter, @StringRes int i3, LiveData<List<String>> liveData, View.OnClickListener onClickListener, final String str) {
        x.Companion companion = com.tencent.mobileqq.widget.listitem.x.INSTANCE;
        String string = getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "getString(left)");
        final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> b16 = x.Companion.b(companion, string, null, 2, null);
        b16.x(onClickListener);
        b16.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.p
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildSpeakRuleSettingFragment.ti(str, view);
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends String>, Unit> function1 = new Function1<List<? extends String>, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.GuildSpeakRuleSettingFragment$singleLine$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> it) {
                String oi5;
                x.c.g O = b16.O();
                GuildSpeakRuleSettingFragment guildSpeakRuleSettingFragment = this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                oi5 = guildSpeakRuleSettingFragment.oi(it);
                O.h(oi5);
                qUIListItemAdapter.l0(b16);
                this.Wh();
            }
        };
        liveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSpeakRuleSettingFragment.ui(Function1.this, obj);
            }
        });
        return b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ti(String elementId, View view) {
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        VideoReport.setElementReuseIdentifier(view, elementId);
        ch.Y0(view, elementId, ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ui(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.doOnCreateView(inflater, container, savedInstanceState);
        this.config = (GuildSpeakRuleParser.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101212");
        ni();
        initViewModel();
        initView();
        pi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f36;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GuildSetSpeakRuleBlockWordRealMethod.SetSpeakRuleBlockWordEvent>> getEventClass() {
        ArrayList<Class<GuildSetSpeakRuleBlockWordRealMethod.SetSpeakRuleBlockWordEvent>> arrayList = new ArrayList<>();
        arrayList.add(GuildSetSpeakRuleBlockWordRealMethod.SetSpeakRuleBlockWordEvent.class);
        return arrayList;
    }

    @NotNull
    public final String gi() {
        String str = this.mGuildId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
        return null;
    }

    @NotNull
    public final ad hi() {
        ad adVar = this.mViewModel;
        if (adVar != null) {
            return adVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        return null;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        hi().removeObserver();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof GuildSetSpeakRuleBlockWordRealMethod.SetSpeakRuleBlockWordEvent) {
            GuildSetSpeakRuleBlockWordRealMethod.SetSpeakRuleBlockWordEvent setSpeakRuleBlockWordEvent = (GuildSetSpeakRuleBlockWordRealMethod.SetSpeakRuleBlockWordEvent) event;
            if (Intrinsics.areEqual(gi(), setSpeakRuleBlockWordEvent.getGuildId())) {
                hi().S1().postValue(setSpeakRuleBlockWordEvent.getWords());
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        hi().addObserver();
        GuildRolePartUnlimitedView guildRolePartUnlimitedView = this.mRolePartVew;
        GuildRolePartUnlimitedView guildRolePartUnlimitedView2 = null;
        if (guildRolePartUnlimitedView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRolePartVew");
            guildRolePartUnlimitedView = null;
        }
        guildRolePartUnlimitedView.Y();
        GuildRolePartUnlimitedView guildRolePartUnlimitedView3 = this.mRolePartVew;
        if (guildRolePartUnlimitedView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRolePartVew");
        } else {
            guildRolePartUnlimitedView2 = guildRolePartUnlimitedView3;
        }
        guildRolePartUnlimitedView2.a0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        GuildRolePartUnlimitedView guildRolePartUnlimitedView = this.mRolePartVew;
        if (guildRolePartUnlimitedView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRolePartVew");
            guildRolePartUnlimitedView = null;
        }
        guildRolePartUnlimitedView.setParams(this, gi(), "", new b());
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public final void qi(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGuildId = str;
    }

    public final void ri(@NotNull ad adVar) {
        Intrinsics.checkNotNullParameter(adVar, "<set-?>");
        this.mViewModel = adVar;
    }
}
