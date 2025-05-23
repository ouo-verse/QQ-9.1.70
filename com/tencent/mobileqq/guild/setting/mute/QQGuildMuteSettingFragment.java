package com.tencent.mobileqq.guild.setting.mute;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.data.GuildSpeakParamsInfo;
import com.tencent.mobileqq.guild.guide.GuildSpeakManageGuide;
import com.tencent.mobileqq.guild.setting.mute.QQGuildMuteSettingFragment;
import com.tencent.mobileqq.guild.setting.mute.e;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.cc;
import vh2.cd;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0016\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0002RSB\u0007\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J#\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ,\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J,\u0010!\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J\"\u0010&\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J\"\u0010'\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0002J\b\u0010)\u001a\u00020\u0005H\u0002J(\u0010*\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0002J\b\u0010+\u001a\u00020\fH\u0014J$\u00102\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00101\u001a\u0004\u0018\u000100H\u0014J\u0010\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0019H\u0016R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u00106R\u0016\u0010:\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00109R\u0018\u0010A\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\"\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\"\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010CR\"\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010CR\"\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010CR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020$0K8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bL\u0010M\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/mute/QQGuildMuteSettingFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "Landroid/view/View$OnClickListener;", "", "hi", "", "initView", "T", "Lcom/tencent/mobileqq/guild/setting/mute/QQGuildMuteSettingFragment$b;", "executable", "bi", "(Lcom/tencent/mobileqq/guild/setting/mute/QQGuildMuteSettingFragment$b;)Ljava/lang/Object;", "", "textResId", "Lcom/tencent/mobileqq/widget/listitem/h;", "listener", "", "elementId", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "vi", "com/tencent/mobileqq/guild/setting/mute/QQGuildMuteSettingFragment$muteHint$1", "ii", "()Lcom/tencent/mobileqq/guild/setting/mute/QQGuildMuteSettingFragment$muteHint$1;", "Landroid/view/View;", "view", WidgetCacheLunarData.JI, "day", WidgetCacheWeatherData.HOUR, "minute", "Lvh2/cc;", "callback", "si", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gpsService", "", "time", "oi", "qi", SensorJsPlugin.SENSOR_INTERVAL_UI, "ni", "mi", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/setting/mute/e;", "Lcom/tencent/mobileqq/guild/setting/mute/e;", "mGuildMuteTimePickerDialog", "U", "Ljava/lang/String;", "mGuildId", "V", "mTinyId", "W", "mChannelId", "X", "Ljava/lang/Integer;", "mSceneType", "Y", "Lcom/tencent/mobileqq/widget/listitem/x;", "tenMiniConfig", "Z", "oneHourConfig", "a0", "twelveHoursConfig", "b0", "oneDayConfig", "Le12/a;", "ci", "()Le12/a;", "muteLiveData", "<init>", "()V", "c0", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QQGuildMuteSettingFragment extends QQGuildTitleBarFragment implements View.OnClickListener {

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.setting.mute.e mGuildMuteTimePickerDialog;

    /* renamed from: U, reason: from kotlin metadata */
    private String mGuildId;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private String mTinyId;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private String mChannelId;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private Integer mSceneType;

    /* renamed from: Y, reason: from kotlin metadata */
    private x<x.b.d, x.c> tenMiniConfig;

    /* renamed from: Z, reason: from kotlin metadata */
    private x<x.b.d, x.c> oneHourConfig;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private x<x.b.d, x.c> twelveHoursConfig;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private x<x.b.d, x.c> oneDayConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0007J0\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0007R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/mute/QQGuildMuteSettingFragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", "bundle", "", "c", "", "guildId", "a", "channelId", "tinyId", "", "sceneType", "b", "ACTIVITY_REQUEST_CODE_MUTE_SETTING", "I", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.mute.QQGuildMuteSettingFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void c(Activity activity, Bundle bundle) {
            Intent intent = new Intent();
            intent.putExtras(bundle);
            QPublicFragmentActivity.b.e(activity, intent, QPublicFragmentActivity.class, QQGuildMuteSettingFragment.class, 8225);
        }

        @JvmStatic
        public final void a(@NotNull Activity activity, @NotNull String guildId) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Bundle bundle = new Bundle();
            bundle.putSerializable("extra_key_mute_guild_id", guildId);
            c(activity, bundle);
        }

        @JvmStatic
        public final void b(@NotNull Activity activity, @NotNull String guildId, @NotNull String channelId, @NotNull String tinyId, int sceneType) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            Bundle bundle = new Bundle();
            bundle.putString("extra_key_mute_guild_id", guildId);
            bundle.putString("extra_key_mute_tiny_id", tinyId);
            bundle.putString("extra_key_mute_channel_id", channelId);
            bundle.putInt("extra_key_mute_scene_type", sceneType);
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            ((IGPSService) S0).refreshGuildUserProfileInfo(guildId, tinyId);
            c(activity, bundle);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u000f\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/mute/QQGuildMuteSettingFragment$b;", "T", "", "execute", "()Ljava/lang/Object;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b<T> {
        T execute();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/mute/QQGuildMuteSettingFragment$c", "Lcom/tencent/mobileqq/guild/setting/mute/QQGuildMuteSettingFragment$b;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements b<x<x.b.d, x.c>> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QUIListItemAdapter f234804b;

        c(QUIListItemAdapter qUIListItemAdapter) {
            this.f234804b = qUIListItemAdapter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(final QQGuildMuteSettingFragment this$0, final QUIListItemAdapter adapter, View view, boolean z16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(adapter, "$adapter");
            Intrinsics.checkNotNullParameter(view, "view");
            if (z16) {
                this$0.si(0, 0, 10, new cc() { // from class: com.tencent.mobileqq.guild.setting.mute.n
                    @Override // vh2.cc
                    public final void onResult(int i3, String str) {
                        QQGuildMuteSettingFragment.c.e(QQGuildMuteSettingFragment.this, adapter, i3, str);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(QQGuildMuteSettingFragment this$0, QUIListItemAdapter adapter, int i3, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(adapter, "$adapter");
            if (i3 != 0) {
                x xVar = this$0.tenMiniConfig;
                x xVar2 = null;
                if (xVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tenMiniConfig");
                    xVar = null;
                }
                if (xVar.O() instanceof x.c.i) {
                    x xVar3 = this$0.tenMiniConfig;
                    if (xVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tenMiniConfig");
                        xVar3 = null;
                    }
                    x.c O = xVar3.O();
                    Intrinsics.checkNotNull(O, "null cannot be cast to non-null type com.tencent.mobileqq.widget.listitem.SingleLineConfig.Right.Tick");
                    ((x.c.i) O).f(false);
                    x xVar4 = this$0.tenMiniConfig;
                    if (xVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tenMiniConfig");
                    } else {
                        xVar2 = xVar4;
                    }
                    adapter.l0(xVar2);
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.setting.mute.QQGuildMuteSettingFragment.b
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public x<x.b.d, x.c> execute() {
            final QQGuildMuteSettingFragment qQGuildMuteSettingFragment = QQGuildMuteSettingFragment.this;
            final QUIListItemAdapter qUIListItemAdapter = this.f234804b;
            qQGuildMuteSettingFragment.tenMiniConfig = qQGuildMuteSettingFragment.vi(R.string.f156251jp, new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.guild.setting.mute.m
                @Override // com.tencent.mobileqq.widget.listitem.h
                public final void a(View view, boolean z16) {
                    QQGuildMuteSettingFragment.c.d(QQGuildMuteSettingFragment.this, qUIListItemAdapter, view, z16);
                }
            }, "em_sgrp_mute_tenminite");
            x<x.b.d, x.c> xVar = QQGuildMuteSettingFragment.this.tenMiniConfig;
            if (xVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tenMiniConfig");
                return null;
            }
            return xVar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/mute/QQGuildMuteSettingFragment$d", "Lcom/tencent/mobileqq/guild/setting/mute/QQGuildMuteSettingFragment$b;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements b<x<x.b.d, x.c>> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QUIListItemAdapter f234806b;

        d(QUIListItemAdapter qUIListItemAdapter) {
            this.f234806b = qUIListItemAdapter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(final QQGuildMuteSettingFragment this$0, final QUIListItemAdapter adapter, View view, boolean z16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(adapter, "$adapter");
            Intrinsics.checkNotNullParameter(view, "view");
            if (z16) {
                this$0.si(0, 1, 0, new cc() { // from class: com.tencent.mobileqq.guild.setting.mute.p
                    @Override // vh2.cc
                    public final void onResult(int i3, String str) {
                        QQGuildMuteSettingFragment.d.e(QQGuildMuteSettingFragment.this, adapter, i3, str);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(QQGuildMuteSettingFragment this$0, QUIListItemAdapter adapter, int i3, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(adapter, "$adapter");
            if (i3 != 0) {
                x xVar = this$0.oneHourConfig;
                x xVar2 = null;
                if (xVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("oneHourConfig");
                    xVar = null;
                }
                if (xVar.O() instanceof x.c.i) {
                    x xVar3 = this$0.oneHourConfig;
                    if (xVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("oneHourConfig");
                        xVar3 = null;
                    }
                    x.c O = xVar3.O();
                    Intrinsics.checkNotNull(O, "null cannot be cast to non-null type com.tencent.mobileqq.widget.listitem.SingleLineConfig.Right.Tick");
                    ((x.c.i) O).f(false);
                    x xVar4 = this$0.oneHourConfig;
                    if (xVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("oneHourConfig");
                    } else {
                        xVar2 = xVar4;
                    }
                    adapter.l0(xVar2);
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.setting.mute.QQGuildMuteSettingFragment.b
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public x<x.b.d, x.c> execute() {
            final QQGuildMuteSettingFragment qQGuildMuteSettingFragment = QQGuildMuteSettingFragment.this;
            final QUIListItemAdapter qUIListItemAdapter = this.f234806b;
            qQGuildMuteSettingFragment.oneHourConfig = qQGuildMuteSettingFragment.vi(R.string.f156241jo, new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.guild.setting.mute.o
                @Override // com.tencent.mobileqq.widget.listitem.h
                public final void a(View view, boolean z16) {
                    QQGuildMuteSettingFragment.d.d(QQGuildMuteSettingFragment.this, qUIListItemAdapter, view, z16);
                }
            }, "em_sgrp_mute_onehour");
            x<x.b.d, x.c> xVar = QQGuildMuteSettingFragment.this.oneHourConfig;
            if (xVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("oneHourConfig");
                return null;
            }
            return xVar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/mute/QQGuildMuteSettingFragment$e", "Lcom/tencent/mobileqq/guild/setting/mute/QQGuildMuteSettingFragment$b;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements b<x<x.b.d, x.c>> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QUIListItemAdapter f234808b;

        e(QUIListItemAdapter qUIListItemAdapter) {
            this.f234808b = qUIListItemAdapter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(final QQGuildMuteSettingFragment this$0, final QUIListItemAdapter adapter, View view, boolean z16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(adapter, "$adapter");
            Intrinsics.checkNotNullParameter(view, "view");
            if (z16) {
                this$0.si(0, 12, 0, new cc() { // from class: com.tencent.mobileqq.guild.setting.mute.r
                    @Override // vh2.cc
                    public final void onResult(int i3, String str) {
                        QQGuildMuteSettingFragment.e.e(QQGuildMuteSettingFragment.this, adapter, i3, str);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(QQGuildMuteSettingFragment this$0, QUIListItemAdapter adapter, int i3, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(adapter, "$adapter");
            if (i3 != 0) {
                x xVar = this$0.twelveHoursConfig;
                x xVar2 = null;
                if (xVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("twelveHoursConfig");
                    xVar = null;
                }
                if (xVar.O() instanceof x.c.i) {
                    x xVar3 = this$0.twelveHoursConfig;
                    if (xVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("twelveHoursConfig");
                        xVar3 = null;
                    }
                    x.c O = xVar3.O();
                    Intrinsics.checkNotNull(O, "null cannot be cast to non-null type com.tencent.mobileqq.widget.listitem.SingleLineConfig.Right.Tick");
                    ((x.c.i) O).f(false);
                    x xVar4 = this$0.twelveHoursConfig;
                    if (xVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("twelveHoursConfig");
                    } else {
                        xVar2 = xVar4;
                    }
                    adapter.l0(xVar2);
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.setting.mute.QQGuildMuteSettingFragment.b
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public x<x.b.d, x.c> execute() {
            final QQGuildMuteSettingFragment qQGuildMuteSettingFragment = QQGuildMuteSettingFragment.this;
            final QUIListItemAdapter qUIListItemAdapter = this.f234808b;
            qQGuildMuteSettingFragment.twelveHoursConfig = qQGuildMuteSettingFragment.vi(R.string.f156221jm, new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.guild.setting.mute.q
                @Override // com.tencent.mobileqq.widget.listitem.h
                public final void a(View view, boolean z16) {
                    QQGuildMuteSettingFragment.e.d(QQGuildMuteSettingFragment.this, qUIListItemAdapter, view, z16);
                }
            }, "em_sgrp_mute_twelvehour");
            x<x.b.d, x.c> xVar = QQGuildMuteSettingFragment.this.twelveHoursConfig;
            if (xVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("twelveHoursConfig");
                return null;
            }
            return xVar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/mute/QQGuildMuteSettingFragment$f", "Lcom/tencent/mobileqq/guild/setting/mute/QQGuildMuteSettingFragment$b;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements b<x<x.b.d, x.c>> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QUIListItemAdapter f234810b;

        f(QUIListItemAdapter qUIListItemAdapter) {
            this.f234810b = qUIListItemAdapter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(final QQGuildMuteSettingFragment this$0, final QUIListItemAdapter adapter, View view, boolean z16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(adapter, "$adapter");
            Intrinsics.checkNotNullParameter(view, "view");
            if (z16) {
                this$0.si(1, 0, 0, new cc() { // from class: com.tencent.mobileqq.guild.setting.mute.t
                    @Override // vh2.cc
                    public final void onResult(int i3, String str) {
                        QQGuildMuteSettingFragment.f.e(QQGuildMuteSettingFragment.this, adapter, i3, str);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(QQGuildMuteSettingFragment this$0, QUIListItemAdapter adapter, int i3, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(adapter, "$adapter");
            if (i3 != 0) {
                x xVar = this$0.oneDayConfig;
                x xVar2 = null;
                if (xVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("oneDayConfig");
                    xVar = null;
                }
                if (xVar.O() instanceof x.c.i) {
                    x xVar3 = this$0.oneDayConfig;
                    if (xVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("oneDayConfig");
                        xVar3 = null;
                    }
                    x.c O = xVar3.O();
                    Intrinsics.checkNotNull(O, "null cannot be cast to non-null type com.tencent.mobileqq.widget.listitem.SingleLineConfig.Right.Tick");
                    ((x.c.i) O).f(false);
                    x xVar4 = this$0.oneDayConfig;
                    if (xVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("oneDayConfig");
                    } else {
                        xVar2 = xVar4;
                    }
                    adapter.l0(xVar2);
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.setting.mute.QQGuildMuteSettingFragment.b
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public x<x.b.d, x.c> execute() {
            final QQGuildMuteSettingFragment qQGuildMuteSettingFragment = QQGuildMuteSettingFragment.this;
            final QUIListItemAdapter qUIListItemAdapter = this.f234810b;
            qQGuildMuteSettingFragment.oneDayConfig = qQGuildMuteSettingFragment.vi(R.string.f156231jn, new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.guild.setting.mute.s
                @Override // com.tencent.mobileqq.widget.listitem.h
                public final void a(View view, boolean z16) {
                    QQGuildMuteSettingFragment.f.d(QQGuildMuteSettingFragment.this, qUIListItemAdapter, view, z16);
                }
            }, "em_sgrp_mute_oneday");
            x<x.b.d, x.c> xVar = QQGuildMuteSettingFragment.this.oneDayConfig;
            if (xVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("oneDayConfig");
                return null;
            }
            return xVar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/mute/QQGuildMuteSettingFragment$g", "Lcom/tencent/mobileqq/guild/setting/mute/e$b;", "", "day", WidgetCacheWeatherData.HOUR, "minute", "", "onConfirm", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements e.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f234812b;

        g(View view) {
            this.f234812b = view;
        }

        @Override // com.tencent.mobileqq.guild.setting.mute.e.b
        public void onConfirm(int day, int hour, int minute) {
            QQGuildMuteSettingFragment.ti(QQGuildMuteSettingFragment.this, day, hour, minute, null, 8, null);
            QQGuildMuteSettingFragment.this.mi(this.f234812b, day, hour, minute);
        }
    }

    private final <T> T bi(b<T> executable) {
        return executable.execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e12.a<Long> ci() {
        String str = null;
        if (hi()) {
            String str2 = this.mGuildId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
            } else {
                str = str2;
            }
            return com.tencent.mobileqq.guild.setting.mute.c.J(str, this.mTinyId);
        }
        String str3 = this.mGuildId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
        } else {
            str = str3;
        }
        return com.tencent.mobileqq.guild.setting.mute.c.s(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(QQGuildMuteSettingFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ti(this$0, 0, 0, 0, null, 8, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ch.Y0(view, "em_sgrp_mute_recover", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(QQGuildMuteSettingFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.ji(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(QQGuildMuteSettingFragment this$0, View view) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        if (this$0.hi()) {
            str = "em_sgrp_mute_define";
        } else {
            str = "em_sgrp_mute_all_custom";
        }
        ch.Y0(view, str, ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hi() {
        return !TextUtils.isEmpty(this.mTinyId);
    }

    private final QQGuildMuteSettingFragment$muteHint$1 ii() {
        return new QQGuildMuteSettingFragment$muteHint$1(this, R.layout.ev7);
    }

    private final void initView() {
        int i3;
        this.C.setOnClickListener(this);
        if (hi()) {
            i3 = R.string.f158141ot;
        } else {
            i3 = R.string.f156261jq;
        }
        setTitle(getString(i3));
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) this.P.findViewById(R.id.i4m);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(null, false, false, 7, null);
        qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
        ArrayList arrayList = new ArrayList();
        String str = "";
        if (hi()) {
            Group.Companion companion = Group.INSTANCE;
            QQGuildMuteSettingFragment$muteHint$1 ii5 = ii();
            String string = getString(R.string.f156201jk);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild\u2026g_mute_all_setting_close)");
            com.tencent.mobileqq.widget.listitem.a w3 = new com.tencent.mobileqq.widget.listitem.d(string).x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.mute.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QQGuildMuteSettingFragment.di(QQGuildMuteSettingFragment.this, view);
                }
            }).w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.mute.g
                @Override // com.tencent.mobileqq.widget.listitem.g
                public final void M(View view) {
                    QQGuildMuteSettingFragment.ei(view);
                }
            });
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            arrayList.add(companion.a(ii5, "", w3.l(viewLifecycleOwner, qUIListItemAdapter).f(ci(), new Function1<Long, Boolean>() { // from class: com.tencent.mobileqq.guild.setting.mute.QQGuildMuteSettingFragment$initView$groupList$1$3
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(Long l3) {
                    return Boolean.valueOf(c.O(l3));
                }
            }).d()));
        }
        String string2 = getString(R.string.f156281js);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.guild\u2026tting_mute_set_mute_time)");
        if (!hi()) {
            str = getString(R.string.f156191jj);
            Intrinsics.checkNotNullExpressionValue(str, "getString(R.string.guild_setting_mute_all_hint)");
        }
        String string3 = getString(R.string.f156211jl);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.guild\u2026_mute_all_setting_custom)");
        arrayList.add(new Group(string2, str, (com.tencent.mobileqq.widget.listitem.a) bi(new c(qUIListItemAdapter)), (com.tencent.mobileqq.widget.listitem.a) bi(new d(qUIListItemAdapter)), (com.tencent.mobileqq.widget.listitem.a) bi(new e(qUIListItemAdapter)), (com.tencent.mobileqq.widget.listitem.a) bi(new f(qUIListItemAdapter)), new x(new x.b.d(string3), new x.c.g("", false, false, 6, null)).x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.mute.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildMuteSettingFragment.fi(QQGuildMuteSettingFragment.this, view);
            }
        }).w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.mute.i
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                QQGuildMuteSettingFragment.gi(QQGuildMuteSettingFragment.this, view);
            }
        })));
        Object[] array = arrayList.toArray(new Group[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Group[] groupArr = (Group[]) array;
        qUIListItemAdapter.t0((Group[]) Arrays.copyOf(groupArr, groupArr.length));
    }

    private final void ji(View view) {
        com.tencent.mobileqq.guild.setting.mute.e eVar = null;
        if (this.mGuildMuteTimePickerDialog == null) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            com.tencent.mobileqq.guild.setting.mute.e eVar2 = new com.tencent.mobileqq.guild.setting.mute.e(requireContext, 0, 2, null);
            this.mGuildMuteTimePickerDialog = eVar2;
            eVar2.a0(new g(view));
        }
        com.tencent.mobileqq.guild.setting.mute.e eVar3 = this.mGuildMuteTimePickerDialog;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildMuteTimePickerDialog");
            eVar3 = null;
        }
        eVar3.Y(2, 0, 0);
        com.tencent.mobileqq.guild.setting.mute.e eVar4 = this.mGuildMuteTimePickerDialog;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildMuteTimePickerDialog");
        } else {
            eVar = eVar4;
        }
        eVar.show();
    }

    @JvmStatic
    public static final void ki(@NotNull Activity activity, @NotNull String str) {
        INSTANCE.a(activity, str);
    }

    @JvmStatic
    public static final void li(@NotNull Activity activity, @NotNull String str, @NotNull String str2, @NotNull String str3, int i3) {
        INSTANCE.b(activity, str, str2, str3, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mi(View view, int day, int hour, int minute) {
        String str;
        long minutes = TimeUnit.DAYS.toMinutes(day) + TimeUnit.HOURS.toMinutes(hour) + minute;
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_mute_duration", String.valueOf(minutes));
        if (hi()) {
            str = "em_sgrp_mute_define";
        } else {
            str = "em_sgrp_mute_all_custom";
        }
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(view, str, hashMap);
    }

    private final void ni() {
        VideoReport.addToDetectionWhitelist(getActivity());
        if (hi()) {
            VideoReport.setPageId(this.P, "pg_sgrp_mute_member");
        } else {
            VideoReport.setPageId(this.P, "pg_sgrp_mute_all");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_duration_flag", 1);
        if (hi()) {
            String str = this.mTinyId;
            if (str == null) {
                str = "";
            }
            hashMap.put("sgrp_to_user_id", str);
        }
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        View view = this.P;
        String str2 = this.mGuildId;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
            str2 = null;
        }
        iGuildDTReportApi.setGuildPageParams(view, str2, hashMap);
    }

    private final void oi(IGPSService gpsService, final long time, final cc callback) {
        String str = this.mGuildId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
            str = null;
        }
        gpsService.setGuildShutUp(str, time, new cd() { // from class: com.tencent.mobileqq.guild.setting.mute.j
            @Override // vh2.cd
            public final void a(int i3, String str2, IGProSecurityResult iGProSecurityResult) {
                QQGuildMuteSettingFragment.pi(QQGuildMuteSettingFragment.this, time, callback, i3, str2, iGProSecurityResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pi(QQGuildMuteSettingFragment this$0, long j3, cc ccVar, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ri1.a e16 = ri1.a.e(i3, str, iGProSecurityResult);
        String str2 = null;
        if (!e16.d()) {
            if (e16.f431477a != -200) {
                ch.d1(1, R.string.f155831ik);
            } else {
                ch.e1(1, e16.f431478b);
            }
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str3 = "[setGuildShutUp] error, failed result: " + i3 + ", errMsg: " + str + ", security = " + iGProSecurityResult + ", muteTime = " + j3;
            if (str3 instanceof String) {
                bVar.a().add(str3);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Q_G_MUTE.QQGuildMuteSettingFragm", 1, (String) it.next(), null);
            }
        } else {
            this$0.ui(j3);
            String str4 = this$0.mGuildId;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
            } else {
                str2 = str4;
            }
            com.tencent.mobileqq.guild.setting.mute.c.X(str2, j3, "setGuildShutUp");
            TextView leftView = this$0.C;
            Intrinsics.checkNotNullExpressionValue(leftView, "leftView");
            this$0.onClick(leftView);
            QLog.i("Q_G_MUTE.QQGuildMuteSettingFragm", 1, "[setGuildShutUp] success, muteTime = " + j3);
        }
        if (ccVar != null) {
            ccVar.onResult(i3, str);
        }
    }

    private final void qi(IGPSService gpsService, final long time, final cc callback) {
        String str = this.mGuildId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
            str = null;
        }
        gpsService.setMemberShutUp(str, this.mTinyId, time, new cd() { // from class: com.tencent.mobileqq.guild.setting.mute.k
            @Override // vh2.cd
            public final void a(int i3, String str2, IGProSecurityResult iGProSecurityResult) {
                QQGuildMuteSettingFragment.ri(time, this, callback, i3, str2, iGProSecurityResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ri(long j3, QQGuildMuteSettingFragment this$0, cc ccVar, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0 && ch.p(iGProSecurityResult)) {
            this$0.ui(j3);
            String str2 = this$0.mGuildId;
            String str3 = null;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
                str2 = null;
            }
            com.tencent.mobileqq.guild.setting.mute.c.Z(str2, this$0.mTinyId, j3, "setGuildUserShutUp");
            com.tencent.mobileqq.guild.setting.mute.c.K().postValue(this$0.mTinyId);
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            IGPSService iGPSService = (IGPSService) S0;
            String str4 = this$0.mGuildId;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
            } else {
                str3 = str4;
            }
            iGPSService.refreshGuildUserProfileInfo(str3, this$0.mTinyId);
            if (!this$0.isDetached()) {
                TextView leftView = this$0.C;
                Intrinsics.checkNotNullExpressionValue(leftView, "leftView");
                this$0.onClick(leftView);
            }
            QLog.i("Q_G_MUTE.QQGuildMuteSettingFragm", 1, "[setGuildUserShutUp] success, muteTime = " + j3);
        } else {
            ch.d1(1, R.string.f1506015f);
            QLog.e("Q_G_MUTE.QQGuildMuteSettingFragm", 1, "[setGuildUserShutUp] error, failed result: " + i3 + ",  errMsg: " + str + ", security = " + iGProSecurityResult + ", muteTime = " + j3);
        }
        if (ccVar != null) {
            ccVar.onResult(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void si(int day, int hour, int minute, cc callback) {
        long A = com.tencent.mobileqq.guild.setting.mute.c.A(day, hour, minute);
        IRuntimeService runtimeService = getAppInterface().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface.getRuntimeS\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        if (TextUtils.isEmpty(this.mTinyId)) {
            oi(iGPSService, A, callback);
        } else {
            qi(iGPSService, A, callback);
        }
    }

    static /* synthetic */ void ti(QQGuildMuteSettingFragment qQGuildMuteSettingFragment, int i3, int i16, int i17, cc ccVar, int i18, Object obj) {
        if ((i18 & 8) != 0) {
            ccVar = null;
        }
        qQGuildMuteSettingFragment.si(i3, i16, i17, ccVar);
    }

    private final void ui(final long time) {
        int i3;
        if (hi()) {
            GuildSpeakManageGuide guildSpeakManageGuide = GuildSpeakManageGuide.f224623a;
            String str = this.mGuildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
                str = null;
            }
            guildSpeakManageGuide.f(str, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.setting.mute.QQGuildMuteSettingFragment$showSetMuteSuccessToast$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    String str2;
                    String str3;
                    String str4;
                    Integer num;
                    if (z16 && time > 0) {
                        GuildSpeakManageGuide guildSpeakManageGuide2 = GuildSpeakManageGuide.f224623a;
                        str2 = this.mGuildId;
                        String str5 = null;
                        if (str2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
                            str2 = null;
                        }
                        str3 = this.mGuildId;
                        if (str3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
                        } else {
                            str5 = str3;
                        }
                        str4 = this.mChannelId;
                        num = this.mSceneType;
                        guildSpeakManageGuide2.h(str2, R.string.f155851im, new GuildSpeakParamsInfo(str5, str4, num, 3));
                        return;
                    }
                    QQToast.makeText(BaseApplication.getContext(), 2, time == 0 ? R.string.f142490ji : R.string.f155841il, 0).show();
                }
            });
            return;
        }
        if (time == 0) {
            i3 = R.string.f142490ji;
        } else {
            i3 = R.string.f155841il;
        }
        QQToast.makeText(BaseApplication.getContext(), 2, i3, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final x<x.b.d, x.c> vi(int textResId, com.tencent.mobileqq.widget.listitem.h listener, final String elementId) {
        String string = getString(textResId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(textResId)");
        return new x<>(new x.b.d(string), new x.c.i(false, listener).b(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.mute.l
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                QQGuildMuteSettingFragment.wi(elementId, view);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wi(String elementId, View view) {
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        Intrinsics.checkNotNullParameter(view, "view");
        ch.Y0(view, elementId, ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String str;
        String str2;
        Integer num;
        Intent intent;
        Intent intent2;
        Intent intent3;
        String stringExtra;
        Intent intent4;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.doOnCreateView(inflater, container, savedInstanceState);
        FragmentActivity activity = getActivity();
        String str3 = null;
        if (activity != null && (intent4 = activity.getIntent()) != null) {
            str = intent4.getStringExtra("extra_key_mute_guild_id");
        } else {
            str = null;
        }
        String str4 = "";
        if (str == null) {
            str = "";
        }
        this.mGuildId = str;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent3 = activity2.getIntent()) != null && (stringExtra = intent3.getStringExtra("extra_key_mute_tiny_id")) != null) {
            str4 = stringExtra;
        }
        this.mTinyId = str4;
        FragmentActivity activity3 = getActivity();
        if (activity3 != null && (intent2 = activity3.getIntent()) != null) {
            str2 = intent2.getStringExtra("extra_key_mute_channel_id");
        } else {
            str2 = null;
        }
        this.mChannelId = str2;
        FragmentActivity activity4 = getActivity();
        if (activity4 != null && (intent = activity4.getIntent()) != null) {
            num = Integer.valueOf(intent.getIntExtra("extra_key_mute_scene_type", -1));
        } else {
            num = null;
        }
        this.mSceneType = num;
        if (num != null && num.intValue() == -1) {
            this.mSceneType = null;
        }
        String str5 = this.mGuildId;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
        } else {
            str3 = str5;
        }
        if (TextUtils.isEmpty(str3)) {
            FragmentActivity activity5 = getActivity();
            if (activity5 != null) {
                activity5.finish();
                return;
            }
            return;
        }
        initView();
        ni();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168155f35;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        FragmentActivity activity;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3 == this.C && (activity = getActivity()) != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
