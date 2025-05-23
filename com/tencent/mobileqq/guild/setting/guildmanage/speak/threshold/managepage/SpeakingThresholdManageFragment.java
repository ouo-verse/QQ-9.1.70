package com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.view.FormSwitchWithWheelView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bs;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qqguildsdk.data.fc;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.mobileqq.widget.listitem.u;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.widget.AdapterView;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sz1.SpeakingThresholdStatus;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0002 #\u0018\u0000 O2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001PB\u0007\u00a2\u0006\u0004\bM\u0010NJ\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\f\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\nH\u0014J\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0002\u00a2\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0002\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010)\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020\bH\u0002J\b\u0010+\u001a\u00020\bH\u0002J\b\u0010,\u001a\u00020\bH\u0002J\b\u0010-\u001a\u00020\bH\u0002J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010/\u001a\u00020\bH\u0002R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R*\u0010>\u001a\u0016\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:\u0018\u000108j\u0004\u0018\u0001`;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R*\u0010E\u001a\u0016\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020A\u0018\u00010?j\u0004\u0018\u0001`B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR*\u0010G\u001a\u0016\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020A\u0018\u00010?j\u0004\u0018\u0001`B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010J\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010I\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/managepage/SpeakingThresholdManageFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getContentLayoutId", "qh", "ph", "initView", "initListener", "", "guildId", "gi", "Landroid/widget/CompoundButton;", "buttonView", "", "isChecked", "onCheckedChanged", "onBackEvent", "v", NodeProps.ON_CLICK, "ii", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Yh", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "com/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/managepage/SpeakingThresholdManageFragment$b", "Wh", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/managepage/SpeakingThresholdManageFragment$b;", "com/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/managepage/SpeakingThresholdManageFragment$c", "Xh", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/managepage/SpeakingThresholdManageFragment$c;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/view/FormSwitchWithWheelView;", "targetWheel", "anotherWheel", "pi", "qi", "ri", "oi", "li", "fi", "si", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/managepage/c;", "T", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/managepage/c;", "viewModel", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "U", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/widget/listitem/c;", "Lcom/tencent/mobileqq/widget/listitem/c$a$g;", "Lcom/tencent/mobileqq/widget/listitem/c$b$b;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/managepage/DoubleLineSwitchButtonConfig;", "V", "Lcom/tencent/mobileqq/widget/listitem/c;", "roleGroupChannelConfig", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/managepage/SingleLineSwitchButtonConfig;", "W", "Lcom/tencent/mobileqq/widget/listitem/x;", "faceVerifiedChannelConfig", "X", "faceVerifiedDirectMsgConfig", "Y", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/view/FormSwitchWithWheelView;", "joinTimeChannel", "Z", "joinTimeDirectMsg", "<init>", "()V", "a0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class SpeakingThresholdManageFragment extends QQGuildTokenTitleBarFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b0, reason: collision with root package name */
    private static final int f234330b0 = ViewUtils.dip2px(12.0f);

    /* renamed from: T, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c viewModel;

    /* renamed from: U, reason: from kotlin metadata */
    private QUIListItemAdapter adapter;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.widget.listitem.c<c.a.g, c.b.C8994b> roleGroupChannelConfig;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private x<x.b.d, x.c.f> faceVerifiedChannelConfig;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private x<x.b.d, x.c.f> faceVerifiedDirectMsgConfig;

    /* renamed from: Y, reason: from kotlin metadata */
    private FormSwitchWithWheelView joinTimeChannel;

    /* renamed from: Z, reason: from kotlin metadata */
    private FormSwitchWithWheelView joinTimeDirectMsg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/managepage/SpeakingThresholdManageFragment$a;", "", "Landroid/content/Context;", "context", "", "guildId", "", "isPrivateLetter", "", "a", "", "DEFAULT_JOIN_TIME", "J", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.SpeakingThresholdManageFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String guildId, boolean isPrivateLetter) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intent intent = new Intent();
            intent.putExtra("extra_guild_id", guildId);
            intent.putExtra("extra_key_is_private_letter", isPrivateLetter);
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, SpeakingThresholdManageFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/managepage/SpeakingThresholdManageFragment$b", "Lcom/tencent/mobileqq/widget/listitem/u;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/view/FormSwitchWithWheelView;", "J", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends u {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.listitem.w
        @NotNull
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public FormSwitchWithWheelView H(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            FormSwitchWithWheelView formSwitchWithWheelView = SpeakingThresholdManageFragment.this.joinTimeChannel;
            if (formSwitchWithWheelView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
                return null;
            }
            return formSwitchWithWheelView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/managepage/SpeakingThresholdManageFragment$c", "Lcom/tencent/mobileqq/widget/listitem/u;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/view/FormSwitchWithWheelView;", "J", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends u {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.listitem.w
        @NotNull
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public FormSwitchWithWheelView H(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            FormSwitchWithWheelView formSwitchWithWheelView = SpeakingThresholdManageFragment.this.joinTimeDirectMsg;
            if (formSwitchWithWheelView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
                return null;
            }
            return formSwitchWithWheelView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d<T> implements Observer {
        public d() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            x xVar;
            x xVar2;
            fc fcVar = (fc) t16;
            com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar = null;
            if (!bs.k()) {
                if (!fcVar.c() && (xVar2 = SpeakingThresholdManageFragment.this.faceVerifiedChannelConfig) != null) {
                    QUIListItemAdapter qUIListItemAdapter = SpeakingThresholdManageFragment.this.adapter;
                    if (qUIListItemAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        qUIListItemAdapter = null;
                    }
                    qUIListItemAdapter.m0(xVar2, false);
                }
                if (!fcVar.e() && (xVar = SpeakingThresholdManageFragment.this.faceVerifiedDirectMsgConfig) != null) {
                    QUIListItemAdapter qUIListItemAdapter2 = SpeakingThresholdManageFragment.this.adapter;
                    if (qUIListItemAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        qUIListItemAdapter2 = null;
                    }
                    qUIListItemAdapter2.m0(xVar, false);
                }
            }
            x xVar3 = SpeakingThresholdManageFragment.this.faceVerifiedChannelConfig;
            if (xVar3 != null) {
                ((x.c.f) xVar3.O()).f(fcVar.c());
            }
            x xVar4 = SpeakingThresholdManageFragment.this.faceVerifiedChannelConfig;
            if (xVar4 != null) {
                QUIListItemAdapter qUIListItemAdapter3 = SpeakingThresholdManageFragment.this.adapter;
                if (qUIListItemAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    qUIListItemAdapter3 = null;
                }
                qUIListItemAdapter3.l0(xVar4);
            }
            x xVar5 = SpeakingThresholdManageFragment.this.faceVerifiedDirectMsgConfig;
            if (xVar5 != null) {
                ((x.c.f) xVar5.O()).f(fcVar.e());
            }
            x xVar6 = SpeakingThresholdManageFragment.this.faceVerifiedDirectMsgConfig;
            if (xVar6 != null) {
                QUIListItemAdapter qUIListItemAdapter4 = SpeakingThresholdManageFragment.this.adapter;
                if (qUIListItemAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    qUIListItemAdapter4 = null;
                }
                qUIListItemAdapter4.l0(xVar6);
            }
            com.tencent.mobileqq.widget.listitem.c cVar2 = SpeakingThresholdManageFragment.this.roleGroupChannelConfig;
            if (cVar2 != null) {
                ((c.b.C8994b) cVar2.O()).e(fcVar.f());
            }
            com.tencent.mobileqq.widget.listitem.c cVar3 = SpeakingThresholdManageFragment.this.roleGroupChannelConfig;
            if (cVar3 != null) {
                QUIListItemAdapter qUIListItemAdapter5 = SpeakingThresholdManageFragment.this.adapter;
                if (qUIListItemAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    qUIListItemAdapter5 = null;
                }
                qUIListItemAdapter5.l0(cVar3);
            }
            FormSwitchWithWheelView formSwitchWithWheelView = SpeakingThresholdManageFragment.this.joinTimeChannel;
            if (formSwitchWithWheelView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
                formSwitchWithWheelView = null;
            }
            formSwitchWithWheelView.setJoinTime(fcVar.b());
            FormSwitchWithWheelView formSwitchWithWheelView2 = SpeakingThresholdManageFragment.this.joinTimeDirectMsg;
            if (formSwitchWithWheelView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
                formSwitchWithWheelView2 = null;
            }
            formSwitchWithWheelView2.setJoinTime(fcVar.d());
            com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar4 = SpeakingThresholdManageFragment.this.viewModel;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                cVar = cVar4;
            }
            cVar.T1().removeObservers(SpeakingThresholdManageFragment.this.getViewLifecycleOwner());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e<T> implements Observer {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            com.tencent.mobileqq.guild.profile.profilecard.main.l lVar = (com.tencent.mobileqq.guild.profile.profilecard.main.l) t16;
            if (lVar.d()) {
                QQToast.makeText(SpeakingThresholdManageFragment.this.getContext(), 2, SpeakingThresholdManageFragment.this.getString(R.string.f155101gl), 0).show();
            } else {
                SecurityTipHelperKt.F(SpeakingThresholdManageFragment.this.getContext(), lVar.a(), lVar.c(), lVar.b(), HardCodeUtil.qqStr(R.string.f155091gk), null, 32, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f<T> implements Observer {
        public f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            SpeakingThresholdManageFragment speakingThresholdManageFragment = SpeakingThresholdManageFragment.this;
            com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar = speakingThresholdManageFragment.viewModel;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar = null;
            }
            speakingThresholdManageFragment.setRightButtonEnable(cVar.W1());
        }
    }

    private final b Wh() {
        return new b();
    }

    private final c Xh() {
        return new c();
    }

    private final Group[] Yh() {
        if (ii()) {
            String string = getString(R.string.f15192190);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild\u2026ate_letter_threshold_des)");
            String string2 = getString(R.string.f157311mk);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.guild\u2026aking_threshold_has_auth)");
            x.b.d dVar = new x.b.d(string2);
            final x.c.f fVar = new x.c.f(false, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.l
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    SpeakingThresholdManageFragment.bi(SpeakingThresholdManageFragment.this, compoundButton, z16);
                }
            });
            fVar.b(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.m
                @Override // com.tencent.mobileqq.widget.listitem.g
                public final void M(View view) {
                    SpeakingThresholdManageFragment.ci(SpeakingThresholdManageFragment.this, fVar, view);
                }
            });
            Unit unit = Unit.INSTANCE;
            x<x.b.d, x.c.f> xVar = new x<>(dVar, fVar);
            this.faceVerifiedDirectMsgConfig = xVar;
            return new Group[]{new Group("", string, xVar, Xh())};
        }
        String string3 = getString(R.string.f157291mi);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.guild_speaking_threshold_des)");
        String string4 = getString(R.string.f157311mk);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.guild\u2026aking_threshold_has_auth)");
        x.b.d dVar2 = new x.b.d(string4);
        final x.c.f fVar2 = new x.c.f(false, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.n
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                SpeakingThresholdManageFragment.ei(SpeakingThresholdManageFragment.this, compoundButton, z16);
            }
        });
        fVar2.b(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.o
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                SpeakingThresholdManageFragment.Zh(SpeakingThresholdManageFragment.this, fVar2, view);
            }
        });
        Unit unit2 = Unit.INSTANCE;
        x<x.b.d, x.c.f> xVar2 = new x<>(dVar2, fVar2);
        this.faceVerifiedChannelConfig = xVar2;
        return new Group[]{new Group("", string3, xVar2, Wh())};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(final SpeakingThresholdManageFragment this$0, final x.c.f this_apply, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(it, "it");
        ch.X0(it, "em_sgrp_channel_certification_switch", new IDynamicParams() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.f
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map ai5;
                ai5 = SpeakingThresholdManageFragment.ai(SpeakingThresholdManageFragment.this, this_apply, str);
                return ai5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map ai(SpeakingThresholdManageFragment this$0, x.c.f this_apply, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_switch_type", this$0.fi(this_apply.getIsChecked())));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(SpeakingThresholdManageFragment this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar = this$0.viewModel;
        com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        cVar.getLocalStatus().d(z16);
        if (z16) {
            this$0.si();
        }
        com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar3 = this$0.viewModel;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cVar2 = cVar3;
        }
        this$0.setRightButtonEnable(cVar2.W1());
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(final SpeakingThresholdManageFragment this$0, final x.c.f this_apply, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(it, "it");
        ch.X0(it, "em_sgrp_c2c_certification_switch", new IDynamicParams() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.g
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map di5;
                di5 = SpeakingThresholdManageFragment.di(SpeakingThresholdManageFragment.this, this_apply, str);
                return di5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map di(SpeakingThresholdManageFragment this$0, x.c.f this_apply, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_switch_type", this$0.fi(this_apply.getIsChecked())));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(SpeakingThresholdManageFragment this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar = this$0.viewModel;
        com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        cVar.getLocalStatus().g(z16);
        if (z16) {
            this$0.si();
        }
        com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar3 = this$0.viewModel;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cVar2 = cVar3;
        }
        this$0.setRightButtonEnable(cVar2.W1());
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final String fi(boolean isChecked) {
        if (isChecked) {
            return "1";
        }
        return "2";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(SpeakingThresholdManageFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar = this$0.viewModel;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        cVar.X1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean ii() {
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.getBoolean("extra_key_is_private_letter", false)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(SpeakingThresholdManageFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar = this$0.viewModel;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        cVar.X1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(SpeakingThresholdManageFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void li() {
        FormSwitchWithWheelView formSwitchWithWheelView = this.joinTimeChannel;
        FormSwitchWithWheelView formSwitchWithWheelView2 = null;
        if (formSwitchWithWheelView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
            formSwitchWithWheelView = null;
        }
        ch.X0(formSwitchWithWheelView.f(), "em_sgrp_channel_jointime_switch", new IDynamicParams() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.j
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map mi5;
                mi5 = SpeakingThresholdManageFragment.mi(SpeakingThresholdManageFragment.this, str);
                return mi5;
            }
        });
        FormSwitchWithWheelView formSwitchWithWheelView3 = this.joinTimeDirectMsg;
        if (formSwitchWithWheelView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
        } else {
            formSwitchWithWheelView2 = formSwitchWithWheelView3;
        }
        ch.X0(formSwitchWithWheelView2.f(), "em_sgrp_c2c_jointime_switch", new IDynamicParams() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.k
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map ni5;
                ni5 = SpeakingThresholdManageFragment.ni(SpeakingThresholdManageFragment.this, str);
                return ni5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map mi(SpeakingThresholdManageFragment this$0, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Pair[] pairArr = new Pair[2];
        FormSwitchWithWheelView formSwitchWithWheelView = this$0.joinTimeChannel;
        FormSwitchWithWheelView formSwitchWithWheelView2 = null;
        if (formSwitchWithWheelView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
            formSwitchWithWheelView = null;
        }
        pairArr[0] = TuplesKt.to("sgrp_switch_type", this$0.fi(formSwitchWithWheelView.f().isChecked()));
        FormSwitchWithWheelView formSwitchWithWheelView3 = this$0.joinTimeChannel;
        if (formSwitchWithWheelView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
        } else {
            formSwitchWithWheelView2 = formSwitchWithWheelView3;
        }
        pairArr[1] = TuplesKt.to("sgrp_join_time", formSwitchWithWheelView2.d().getDesc());
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map ni(SpeakingThresholdManageFragment this$0, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Pair[] pairArr = new Pair[2];
        FormSwitchWithWheelView formSwitchWithWheelView = this$0.joinTimeDirectMsg;
        FormSwitchWithWheelView formSwitchWithWheelView2 = null;
        if (formSwitchWithWheelView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
            formSwitchWithWheelView = null;
        }
        pairArr[0] = TuplesKt.to("sgrp_switch_type", this$0.fi(formSwitchWithWheelView.f().isChecked()));
        FormSwitchWithWheelView formSwitchWithWheelView3 = this$0.joinTimeDirectMsg;
        if (formSwitchWithWheelView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
        } else {
            formSwitchWithWheelView2 = formSwitchWithWheelView3;
        }
        pairArr[1] = TuplesKt.to("sgrp_join_time", formSwitchWithWheelView2.d().getDesc());
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    private final void oi() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.N, "pg_sgrp_speak_threshold");
        HashMap hashMap = new HashMap();
        w.b(hashMap);
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        RelativeLayout relativeLayout = this.N;
        com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar = this.viewModel;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        iGuildDTReportApi.setGuildPageParams(relativeLayout, cVar.getGuildId(), hashMap);
    }

    private final void pi(FormSwitchWithWheelView targetWheel, FormSwitchWithWheelView anotherWheel) {
        if (targetWheel.j()) {
            targetWheel.g();
        } else {
            targetWheel.l();
            anotherWheel.g();
        }
    }

    private final void qi() {
        FormSwitchWithWheelView formSwitchWithWheelView = this.joinTimeChannel;
        FormSwitchWithWheelView formSwitchWithWheelView2 = null;
        if (formSwitchWithWheelView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
            formSwitchWithWheelView = null;
        }
        formSwitchWithWheelView.l();
        FormSwitchWithWheelView formSwitchWithWheelView3 = this.joinTimeDirectMsg;
        if (formSwitchWithWheelView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
        } else {
            formSwitchWithWheelView2 = formSwitchWithWheelView3;
        }
        formSwitchWithWheelView2.g();
    }

    private final void ri() {
        FormSwitchWithWheelView formSwitchWithWheelView = this.joinTimeDirectMsg;
        FormSwitchWithWheelView formSwitchWithWheelView2 = null;
        if (formSwitchWithWheelView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
            formSwitchWithWheelView = null;
        }
        formSwitchWithWheelView.l();
        FormSwitchWithWheelView formSwitchWithWheelView3 = this.joinTimeChannel;
        if (formSwitchWithWheelView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
        } else {
            formSwitchWithWheelView2 = formSwitchWithWheelView3;
        }
        formSwitchWithWheelView2.g();
    }

    private final void si() {
        DialogUtil.createCustomDialog(getActivity(), 230, (String) null, requireActivity().getString(R.string.f157301mj), (String) null, requireActivity().getString(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SpeakingThresholdManageFragment.ti(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ti(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168155f35;
    }

    public final void gi(@NotNull final String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar = (com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c) ef1.c.INSTANCE.c(this, com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c.class, new Function0<com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.SpeakingThresholdManageFragment$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                return new c(guildId);
            }
        });
        this.viewModel = cVar;
        com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        cVar.P1();
        com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar3 = this.viewModel;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar3 = null;
        }
        MutableLiveData<fc> T1 = cVar3.T1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        T1.observe(viewLifecycleOwner, new d());
        com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar4 = this.viewModel;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar4 = null;
        }
        MutableLiveData<com.tencent.mobileqq.guild.profile.profilecard.main.l> U1 = cVar4.U1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        U1.observe(viewLifecycleOwner2, new e());
        com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar5 = this.viewModel;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cVar2 = cVar5;
        }
        MutableLiveData<Boolean> S1 = cVar2.S1();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        S1.observe(viewLifecycleOwner3, new f());
    }

    public final void initListener() {
        FormSwitchWithWheelView formSwitchWithWheelView = this.joinTimeChannel;
        FormSwitchWithWheelView formSwitchWithWheelView2 = null;
        if (formSwitchWithWheelView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
            formSwitchWithWheelView = null;
        }
        formSwitchWithWheelView.setOnCheckedChangeListener(this);
        FormSwitchWithWheelView formSwitchWithWheelView3 = this.joinTimeDirectMsg;
        if (formSwitchWithWheelView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
            formSwitchWithWheelView3 = null;
        }
        formSwitchWithWheelView3.setOnCheckedChangeListener(this);
        FormSwitchWithWheelView formSwitchWithWheelView4 = this.joinTimeChannel;
        if (formSwitchWithWheelView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
            formSwitchWithWheelView4 = null;
        }
        formSwitchWithWheelView4.f().setOnClickListener(this);
        FormSwitchWithWheelView formSwitchWithWheelView5 = this.joinTimeDirectMsg;
        if (formSwitchWithWheelView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
            formSwitchWithWheelView5 = null;
        }
        formSwitchWithWheelView5.f().setOnClickListener(this);
        FormSwitchWithWheelView formSwitchWithWheelView6 = this.joinTimeChannel;
        if (formSwitchWithWheelView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
            formSwitchWithWheelView6 = null;
        }
        formSwitchWithWheelView6.setOnItemSelectedListener(new g());
        FormSwitchWithWheelView formSwitchWithWheelView7 = this.joinTimeDirectMsg;
        if (formSwitchWithWheelView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
        } else {
            formSwitchWithWheelView2 = formSwitchWithWheelView7;
        }
        formSwitchWithWheelView2.setOnItemSelectedListener(new h());
    }

    public final void initView() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        QUIListItemAdapter qUIListItemAdapter = null;
        this.joinTimeChannel = new FormSwitchWithWheelView(requireContext, null, 2, null);
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        this.joinTimeDirectMsg = new FormSwitchWithWheelView(requireContext2, null, 2, null);
        if (ii()) {
            setTitle(getString(R.string.f1490911c));
        } else {
            setTitle(getString(R.string.f157261mf));
        }
        setRightButton(R.string.f155081gj, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpeakingThresholdManageFragment.hi(SpeakingThresholdManageFragment.this, view);
            }
        });
        setRightButtonEnable(false);
        View findViewById = this.P.findViewById(R.id.i4m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.recycler_view)");
        QUIListItemAdapter qUIListItemAdapter2 = new QUIListItemAdapter(null, false, false, 7, null);
        this.adapter = qUIListItemAdapter2;
        ((QUISettingsRecyclerView) findViewById).setAdapter(qUIListItemAdapter2);
        QUIListItemAdapter qUIListItemAdapter3 = this.adapter;
        if (qUIListItemAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            qUIListItemAdapter = qUIListItemAdapter3;
        }
        Group[] Yh = Yh();
        qUIListItemAdapter.t0((Group[]) Arrays.copyOf(Yh, Yh.length));
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar = this.viewModel;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        if (cVar.W1()) {
            QQCustomDialog negativeButton = DialogUtil.createCustomDialog(getContext(), 230).setMessage(getString(R.string.f154621fa)).setPositiveButton(getString(R.string.f155081gj), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    SpeakingThresholdManageFragment.ji(SpeakingThresholdManageFragment.this, dialogInterface, i3);
                }
            }).setNegativeButton(getString(R.string.f1513017b), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    SpeakingThresholdManageFragment.ki(SpeakingThresholdManageFragment.this, dialogInterface, i3);
                }
            });
            Intrinsics.checkNotNullExpressionValue(negativeButton, "createCustomDialog(conte\u2026h()\n                    }");
            negativeButton.setCancelable(false);
            negativeButton.show();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(@NotNull CompoundButton buttonView, boolean isChecked) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, isChecked);
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        FormSwitchWithWheelView formSwitchWithWheelView = this.joinTimeChannel;
        com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar = null;
        if (formSwitchWithWheelView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
            formSwitchWithWheelView = null;
        }
        if (Intrinsics.areEqual(buttonView, formSwitchWithWheelView.f())) {
            com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar2 = this.viewModel;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar2 = null;
            }
            cVar2.getLocalStatus().e(isChecked);
            if (isChecked) {
                com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar3 = this.viewModel;
                if (cVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    cVar3 = null;
                }
                SpeakingThresholdStatus localStatus = cVar3.getLocalStatus();
                FormSwitchWithWheelView formSwitchWithWheelView2 = this.joinTimeChannel;
                if (formSwitchWithWheelView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
                    formSwitchWithWheelView2 = null;
                }
                localStatus.f(formSwitchWithWheelView2.d().getType());
                FormSwitchWithWheelView formSwitchWithWheelView3 = this.joinTimeChannel;
                if (formSwitchWithWheelView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
                    formSwitchWithWheelView3 = null;
                }
                formSwitchWithWheelView3.setEnabled(true);
                FormSwitchWithWheelView formSwitchWithWheelView4 = this.joinTimeChannel;
                if (formSwitchWithWheelView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
                    formSwitchWithWheelView4 = null;
                }
                formSwitchWithWheelView4.setOnClickListener(this);
            } else {
                com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar4 = this.viewModel;
                if (cVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    cVar4 = null;
                }
                cVar4.getLocalStatus().f(0L);
                FormSwitchWithWheelView formSwitchWithWheelView5 = this.joinTimeChannel;
                if (formSwitchWithWheelView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
                    formSwitchWithWheelView5 = null;
                }
                formSwitchWithWheelView5.g();
                FormSwitchWithWheelView formSwitchWithWheelView6 = this.joinTimeChannel;
                if (formSwitchWithWheelView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
                    formSwitchWithWheelView6 = null;
                }
                formSwitchWithWheelView6.setEnabled(false);
                FormSwitchWithWheelView formSwitchWithWheelView7 = this.joinTimeChannel;
                if (formSwitchWithWheelView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
                    formSwitchWithWheelView7 = null;
                }
                formSwitchWithWheelView7.setOnClickListener(null);
            }
        } else {
            FormSwitchWithWheelView formSwitchWithWheelView8 = this.joinTimeDirectMsg;
            if (formSwitchWithWheelView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
                formSwitchWithWheelView8 = null;
            }
            if (Intrinsics.areEqual(buttonView, formSwitchWithWheelView8.f())) {
                com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar5 = this.viewModel;
                if (cVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    cVar5 = null;
                }
                cVar5.getLocalStatus().b(isChecked);
                if (isChecked) {
                    com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar6 = this.viewModel;
                    if (cVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        cVar6 = null;
                    }
                    SpeakingThresholdStatus localStatus2 = cVar6.getLocalStatus();
                    FormSwitchWithWheelView formSwitchWithWheelView9 = this.joinTimeDirectMsg;
                    if (formSwitchWithWheelView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
                        formSwitchWithWheelView9 = null;
                    }
                    localStatus2.c(formSwitchWithWheelView9.d().getType());
                    FormSwitchWithWheelView formSwitchWithWheelView10 = this.joinTimeDirectMsg;
                    if (formSwitchWithWheelView10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
                        formSwitchWithWheelView10 = null;
                    }
                    formSwitchWithWheelView10.setEnabled(true);
                    FormSwitchWithWheelView formSwitchWithWheelView11 = this.joinTimeDirectMsg;
                    if (formSwitchWithWheelView11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
                        formSwitchWithWheelView11 = null;
                    }
                    formSwitchWithWheelView11.setOnClickListener(this);
                } else {
                    com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar7 = this.viewModel;
                    if (cVar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        cVar7 = null;
                    }
                    cVar7.getLocalStatus().c(0L);
                    FormSwitchWithWheelView formSwitchWithWheelView12 = this.joinTimeDirectMsg;
                    if (formSwitchWithWheelView12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
                        formSwitchWithWheelView12 = null;
                    }
                    formSwitchWithWheelView12.g();
                    FormSwitchWithWheelView formSwitchWithWheelView13 = this.joinTimeDirectMsg;
                    if (formSwitchWithWheelView13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
                        formSwitchWithWheelView13 = null;
                    }
                    formSwitchWithWheelView13.setEnabled(false);
                    FormSwitchWithWheelView formSwitchWithWheelView14 = this.joinTimeDirectMsg;
                    if (formSwitchWithWheelView14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
                        formSwitchWithWheelView14 = null;
                    }
                    formSwitchWithWheelView14.setOnClickListener(null);
                }
            }
        }
        com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar8 = this.viewModel;
        if (cVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cVar = cVar8;
        }
        setRightButtonEnable(cVar.W1());
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, isChecked);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        FormSwitchWithWheelView formSwitchWithWheelView = this.joinTimeChannel;
        FormSwitchWithWheelView formSwitchWithWheelView2 = null;
        if (formSwitchWithWheelView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
            formSwitchWithWheelView = null;
        }
        if (Intrinsics.areEqual(v3, formSwitchWithWheelView)) {
            FormSwitchWithWheelView formSwitchWithWheelView3 = this.joinTimeChannel;
            if (formSwitchWithWheelView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
                formSwitchWithWheelView3 = null;
            }
            FormSwitchWithWheelView formSwitchWithWheelView4 = this.joinTimeDirectMsg;
            if (formSwitchWithWheelView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
            } else {
                formSwitchWithWheelView2 = formSwitchWithWheelView4;
            }
            pi(formSwitchWithWheelView3, formSwitchWithWheelView2);
        } else {
            FormSwitchWithWheelView formSwitchWithWheelView5 = this.joinTimeDirectMsg;
            if (formSwitchWithWheelView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
                formSwitchWithWheelView5 = null;
            }
            if (Intrinsics.areEqual(v3, formSwitchWithWheelView5)) {
                FormSwitchWithWheelView formSwitchWithWheelView6 = this.joinTimeDirectMsg;
                if (formSwitchWithWheelView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
                    formSwitchWithWheelView6 = null;
                }
                FormSwitchWithWheelView formSwitchWithWheelView7 = this.joinTimeChannel;
                if (formSwitchWithWheelView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
                } else {
                    formSwitchWithWheelView2 = formSwitchWithWheelView7;
                }
                pi(formSwitchWithWheelView6, formSwitchWithWheelView2);
            } else {
                FormSwitchWithWheelView formSwitchWithWheelView8 = this.joinTimeChannel;
                if (formSwitchWithWheelView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
                    formSwitchWithWheelView8 = null;
                }
                if (Intrinsics.areEqual(v3, formSwitchWithWheelView8.f())) {
                    FormSwitchWithWheelView formSwitchWithWheelView9 = this.joinTimeChannel;
                    if (formSwitchWithWheelView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
                    } else {
                        formSwitchWithWheelView2 = formSwitchWithWheelView9;
                    }
                    if (formSwitchWithWheelView2.f().isChecked()) {
                        qi();
                    }
                } else {
                    FormSwitchWithWheelView formSwitchWithWheelView10 = this.joinTimeDirectMsg;
                    if (formSwitchWithWheelView10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
                        formSwitchWithWheelView10 = null;
                    }
                    if (Intrinsics.areEqual(v3, formSwitchWithWheelView10.f())) {
                        FormSwitchWithWheelView formSwitchWithWheelView11 = this.joinTimeDirectMsg;
                        if (formSwitchWithWheelView11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
                        } else {
                            formSwitchWithWheelView2 = formSwitchWithWheelView11;
                        }
                        if (formSwitchWithWheelView2.f().isChecked()) {
                            ri();
                        }
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        String str;
        boolean z16;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("extra_guild_id", "");
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("guildId is empty");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.sr.SpeakingThresholdManageFragment", 1, (String) it.next(), null);
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        gi(str);
        initView();
        initListener();
        oi();
        li();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return R.color.ajr;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int qh() {
        return R.drawable.lvj;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/managepage/SpeakingThresholdManageFragment$g", "Lcom/tencent/widget/AdapterView$OnItemSelectedListener;", "Lcom/tencent/widget/AdapterView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "view", "", "position", "", "id", "", "onItemSelected", "onNothingSelected", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements AdapterView.OnItemSelectedListener {
        g() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(@Nullable AdapterView<?> parent, @Nullable View view, int position, long id5) {
            com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar = SpeakingThresholdManageFragment.this.viewModel;
            com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar2 = null;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar = null;
            }
            SpeakingThresholdStatus localStatus = cVar.getLocalStatus();
            FormSwitchWithWheelView formSwitchWithWheelView = SpeakingThresholdManageFragment.this.joinTimeChannel;
            if (formSwitchWithWheelView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTimeChannel");
                formSwitchWithWheelView = null;
            }
            localStatus.f(formSwitchWithWheelView.e(position));
            SpeakingThresholdManageFragment speakingThresholdManageFragment = SpeakingThresholdManageFragment.this;
            com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar3 = speakingThresholdManageFragment.viewModel;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                cVar2 = cVar3;
            }
            speakingThresholdManageFragment.setRightButtonEnable(cVar2.W1());
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(@Nullable AdapterView<?> parent) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/managepage/SpeakingThresholdManageFragment$h", "Lcom/tencent/widget/AdapterView$OnItemSelectedListener;", "Lcom/tencent/widget/AdapterView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "view", "", "position", "", "id", "", "onItemSelected", "onNothingSelected", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h implements AdapterView.OnItemSelectedListener {
        h() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(@Nullable AdapterView<?> parent, @Nullable View view, int position, long id5) {
            com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar = SpeakingThresholdManageFragment.this.viewModel;
            com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar2 = null;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar = null;
            }
            SpeakingThresholdStatus localStatus = cVar.getLocalStatus();
            FormSwitchWithWheelView formSwitchWithWheelView = SpeakingThresholdManageFragment.this.joinTimeDirectMsg;
            if (formSwitchWithWheelView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTimeDirectMsg");
                formSwitchWithWheelView = null;
            }
            localStatus.c(formSwitchWithWheelView.e(position));
            SpeakingThresholdManageFragment speakingThresholdManageFragment = SpeakingThresholdManageFragment.this;
            com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.c cVar3 = speakingThresholdManageFragment.viewModel;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                cVar2 = cVar3;
            }
            speakingThresholdManageFragment.setRightButtonEnable(cVar2.W1());
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(@Nullable AdapterView<?> parent) {
        }
    }
}
