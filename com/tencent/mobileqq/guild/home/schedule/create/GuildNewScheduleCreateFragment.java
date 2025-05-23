package com.tencent.mobileqq.guild.home.schedule.create;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.input.at.trooptag.dialogui.bean.HashTagPageType;
import com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.home.schedule.viewmodels.GuildNewScheduleViewModel;
import com.tencent.mobileqq.guild.util.GuildChannelIconUtil;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.dp;
import com.tencent.mobileqq.qqguildsdk.data.genc.eb;
import com.tencent.mobileqq.qqguildsdk.data.type.IChannelType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.InputMethodUtil;
import cooperation.qzone.QzoneIPCModule;
import cp0.HashTagChannelData;
import ef1.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u0085\u00012\u00020\u00012\u00020\u0002:\u0002\u0086\u0001B\t\u00a2\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u001a\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0005J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0003J\"\u0010!\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0012H\u0014J\b\u0010$\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00101\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010,R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0016\u0010M\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010,R\u0016\u0010O\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010@R\u0016\u0010Q\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010,R\u0016\u0010T\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\"\u0010c\u001a\u00020\\8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u0010i\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010Z\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010m\u001a\u00020\\8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bj\u0010^\u001a\u0004\bk\u0010`\"\u0004\bl\u0010bR\"\u0010u\u001a\u00020n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\"\u0010}\u001a\u00020v8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0016\u0010\u007f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010ZR\u0015\u0010\u001b\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010ZR\u0018\u0010\u0082\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010Z\u00a8\u0006\u0087\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/create/GuildNewScheduleCreateFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "Lcom/tencent/mobileqq/pad/d;", "", "info", "", "Ri", "", "Ki", "Pi", "oi", "Ti", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "initView", "", "drawableRes", "Si", "Oi", "ni", "Li", "onCancel", "onBackEvent", "initViewModel", "error", "Qi", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "rh", "getContentLayoutId", "shouldDispatchActivityResult", "shouldDispatchPostThemeChanged", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "T", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "scheduleName", "Landroid/widget/TextView;", "U", "Landroid/widget/TextView;", "scheduleStartTime", "V", "scheduleEndTime", "W", "scheduleChannel", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "X", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "selectChannel", "Y", "selectUrl", "Landroid/widget/RelativeLayout;", "Z", "Landroid/widget/RelativeLayout;", "scheduleUrlRly", "a0", "scheduleDescCount", "Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText;", "b0", "Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText;", "scheduleDesc", "Landroid/widget/ImageView;", "c0", "Landroid/widget/ImageView;", "scheduleChannelIcon", "Landroidx/constraintlayout/widget/ConstraintLayout;", "d0", "Landroidx/constraintlayout/widget/ConstraintLayout;", "inputUrlCly", "e0", "addressCly", "f0", "addressTip", "g0", "inputUrl", "h0", "checkUrlResult", "i0", "Landroid/view/View;", "anchorView", "Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildNewScheduleViewModel;", "j0", "Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildNewScheduleViewModel;", "viewModel", "k0", "Ljava/lang/String;", "guildId", "", "l0", "J", "getSelectChannelId", "()J", "Xi", "(J)V", "selectChannelId", "m0", "getScheduleChannelId", "()Ljava/lang/String;", "setScheduleChannelId", "(Ljava/lang/String;)V", "scheduleChannelId", "n0", "getDefaultTime", "setDefaultTime", "defaultTime", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/eb;", "o0", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/eb;", "pi", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/eb;", "Vi", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/eb;)V", "guildScheduleChannelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/dp;", "p0", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/dp;", "qi", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/dp;", "Wi", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/dp;)V", "jumpAddress", "q0", "abstractInfo", "r0", "s0", "feedUrl", "<init>", "()V", "t0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildNewScheduleCreateFragment extends QQGuildTokenTitleBarFragment implements com.tencent.mobileqq.pad.d {

    /* renamed from: t0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private QUISingleLineInputView scheduleName;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView scheduleStartTime;

    /* renamed from: V, reason: from kotlin metadata */
    private TextView scheduleEndTime;

    /* renamed from: W, reason: from kotlin metadata */
    private TextView scheduleChannel;

    /* renamed from: X, reason: from kotlin metadata */
    private QUICheckBox selectChannel;

    /* renamed from: Y, reason: from kotlin metadata */
    private QUICheckBox selectUrl;

    /* renamed from: Z, reason: from kotlin metadata */
    private RelativeLayout scheduleUrlRly;

    /* renamed from: a0, reason: from kotlin metadata */
    private TextView scheduleDescCount;

    /* renamed from: b0, reason: from kotlin metadata */
    private CharacterCountEditText scheduleDesc;

    /* renamed from: c0, reason: from kotlin metadata */
    private ImageView scheduleChannelIcon;

    /* renamed from: d0, reason: from kotlin metadata */
    private ConstraintLayout inputUrlCly;

    /* renamed from: e0, reason: from kotlin metadata */
    private ConstraintLayout addressCly;

    /* renamed from: f0, reason: from kotlin metadata */
    private TextView addressTip;

    /* renamed from: g0, reason: from kotlin metadata */
    private CharacterCountEditText inputUrl;

    /* renamed from: h0, reason: from kotlin metadata */
    private TextView checkUrlResult;

    /* renamed from: i0, reason: from kotlin metadata */
    private View anchorView;

    /* renamed from: j0, reason: from kotlin metadata */
    private GuildNewScheduleViewModel viewModel;

    /* renamed from: k0, reason: from kotlin metadata */
    private String guildId;

    /* renamed from: l0, reason: from kotlin metadata */
    private long selectChannelId;

    /* renamed from: m0, reason: from kotlin metadata */
    @NotNull
    private String scheduleChannelId = "";

    /* renamed from: n0, reason: from kotlin metadata */
    private long defaultTime = NetConnInfoCenter.getServerTimeMillis();

    /* renamed from: o0, reason: from kotlin metadata */
    @NotNull
    private eb guildScheduleChannelInfo = new eb();

    /* renamed from: p0, reason: from kotlin metadata */
    @NotNull
    private dp jumpAddress = new dp();

    /* renamed from: q0, reason: from kotlin metadata */
    @NotNull
    private String abstractInfo = "";

    /* renamed from: r0, reason: from kotlin metadata */
    @NotNull
    private final String error = "\u7ebf\u4e0b\u5730\u5740\u4e0d\u80fd\u8d85\u8fc720\u4e2a\u5b57\u7b26";

    /* renamed from: s0, reason: from kotlin metadata */
    @NotNull
    private String feedUrl = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0007R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/create/GuildNewScheduleCreateFragment$a;", "", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "fragment", "", "guildId", "channelId", "", "requestCode", "", "time", "", "a", "CREATE_SCHEDULE_TIME", "Ljava/lang/String;", "MAX_DESC_COUNT", "I", "MAX_OFFLINE_ADDRESS_LIMIT", "SELECTED_ROLE_IDS", "SELECTED_ROLE_IDS_REQ_CODE", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.schedule.create.GuildNewScheduleCreateFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, QPublicBaseFragment qPublicBaseFragment, String str, String str2, int i3, long j3, int i16, Object obj) {
            if ((i16 & 16) != 0) {
                j3 = NetConnInfoCenter.getServerTimeMillis();
            }
            companion.a(qPublicBaseFragment, str, str2, i3, j3);
        }

        @JvmStatic
        public final void a(@NotNull QPublicBaseFragment fragment, @NotNull String guildId, @NotNull String channelId, int requestCode, long time) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intent intent = new Intent();
            intent.putExtra("extra_guild_id", guildId);
            intent.putExtra("extra_channel_id", channelId);
            intent.putExtra("create_schedule_time", time);
            GuildSplitViewUtils.f235370a.q(fragment.getContext(), fragment, intent, GuildNewScheduleCreateFragment.class, requestCode);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/home/schedule/create/GuildNewScheduleCreateFragment$e", "Lip0/d;", "Lcp0/a;", "selectedTroopTagData", "", "c", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements ip0.d {
        e() {
        }

        @Override // ip0.d
        public void c(@Nullable cp0.a selectedTroopTagData) {
            HashTagChannelData hashTagChannelData;
            QLog.d("Guild.sch.GuildNewScheduleCreateFragment", 2, "onPanelDismiss selectedData " + selectedTroopTagData);
            String str = null;
            if (selectedTroopTagData instanceof HashTagChannelData) {
                hashTagChannelData = (HashTagChannelData) selectedTroopTagData;
            } else {
                hashTagChannelData = null;
            }
            if (hashTagChannelData != null) {
                GuildNewScheduleCreateFragment guildNewScheduleCreateFragment = GuildNewScheduleCreateFragment.this;
                QLog.d("Guild.sch.GuildNewScheduleCreateFragment", 2, String.valueOf(hashTagChannelData.getChannelUin()), hashTagChannelData.getChannelName(), Integer.valueOf(hashTagChannelData.getChannelType()), hashTagChannelData.getAioHashViewType());
                if (hashTagChannelData.getChannelUin() == 0) {
                    guildNewScheduleCreateFragment.Si(GuildChannelIconUtil.j(7, 0, 0, 6, null));
                } else {
                    guildNewScheduleCreateFragment.Si(yo1.c.f450725a.b(hashTagChannelData.getChannelUin(), hashTagChannelData.getChannelType()));
                }
                guildNewScheduleCreateFragment.Xi(hashTagChannelData.getChannelUin());
                TextView textView = guildNewScheduleCreateFragment.scheduleChannel;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scheduleChannel");
                    textView = null;
                }
                textView.setText(hashTagChannelData.getChannelName());
                guildNewScheduleCreateFragment.Vi(new eb());
                guildNewScheduleCreateFragment.getGuildScheduleChannelInfo().g(hashTagChannelData.getChannelUin());
                guildNewScheduleCreateFragment.getGuildScheduleChannelInfo().l(hashTagChannelData.getChannelType());
                eb guildScheduleChannelInfo = guildNewScheduleCreateFragment.getGuildScheduleChannelInfo();
                String str2 = guildNewScheduleCreateFragment.guildId;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildId");
                } else {
                    str = str2;
                }
                guildScheduleChannelInfo.i(Long.parseLong(str));
                guildNewScheduleCreateFragment.getGuildScheduleChannelInfo().h(hashTagChannelData.getChannelName());
            }
        }

        @Override // ye1.b
        public void f() {
            QLog.d("Guild.sch.GuildNewScheduleCreateFragment", 2, "mNewHashTagPanel onPanelShow");
        }
    }

    public static final void Ai(GuildNewScheduleCreateFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildNewScheduleViewModel guildNewScheduleViewModel = this$0.viewModel;
        if (guildNewScheduleViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildNewScheduleViewModel = null;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        guildNewScheduleViewModel.v2(context, this$0.defaultTime);
        EventCollector.getInstance().onViewClicked(view);
    }

    public static final void Bi(GuildNewScheduleCreateFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildNewScheduleViewModel guildNewScheduleViewModel = this$0.viewModel;
        if (guildNewScheduleViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildNewScheduleViewModel = null;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        guildNewScheduleViewModel.s2(context, this$0.defaultTime);
        EventCollector.getInstance().onViewClicked(view);
    }

    public static final void Ci(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Di(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Ei(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Fi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Gi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Hi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Ii(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Ji(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean Ki() {
        if (this.F.getAlpha() <= 0.5f) {
            CharacterCountEditText characterCountEditText = this.scheduleDesc;
            if (characterCountEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scheduleDesc");
                characterCountEditText = null;
            }
            if (TextUtils.isEmpty(characterCountEditText.getText())) {
                return false;
            }
        }
        return true;
    }

    public static final void Mi(GuildNewScheduleCreateFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildSplitViewUtils.f235370a.t(this$0.getActivity(), true);
    }

    private final void Pi() {
        ArrayList arrayListOf;
        String str;
        HashTagPageType hashTagPageType = HashTagPageType.Channel_Page;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(hashTagPageType);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        Context context = this.P.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mContentView.context");
        String str2 = this.guildId;
        View view = null;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str = null;
        } else {
            str = str2;
        }
        ip0.c cVar = (ip0.c) com.tencent.guild.aio.input.at.utils.j.a(new a.C1192a(appInterface, context, str, String.valueOf(this.selectChannelId), IChannelType.APP_SUB_CHANNEL_TYPE_SCHEDULE).d(1).c(arrayListOf).b(yo1.c.f450725a.a()).a());
        if (cVar != null) {
            cVar.k(new e());
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            InputMethodUtil.hide(activity);
        }
        View view2 = this.anchorView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorView");
        } else {
            view = view2;
        }
        cVar.g(view, hashTagPageType);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.replaceBeforeLast$default(r4, "http", "", (java.lang.String) null, 4, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Ri(String info) {
        String str;
        boolean contains$default;
        String replaceBeforeLast$default;
        CharSequence trim;
        dp dpVar = new dp();
        this.jumpAddress = dpVar;
        dpVar.e(1);
        CharacterCountEditText characterCountEditText = this.inputUrl;
        CharacterCountEditText characterCountEditText2 = null;
        if (characterCountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
            characterCountEditText = null;
        }
        Editable text = characterCountEditText.getText();
        if (text != null && (r4 = text.toString()) != null && replaceBeforeLast$default != null) {
            trim = StringsKt__StringsKt.trim((CharSequence) replaceBeforeLast$default);
            str = trim.toString();
        } else {
            str = null;
        }
        boolean z16 = false;
        if (str != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "://pd.qq.com/s", false, 2, (Object) null);
            if (contains$default) {
                z16 = true;
            }
        }
        if (z16) {
            this.jumpAddress.d(str);
        } else {
            this.jumpAddress.d(this.feedUrl);
        }
        Logger.a d16 = Logger.f235387a.d();
        String a16 = getJumpAddress().a();
        CharacterCountEditText characterCountEditText3 = this.inputUrl;
        if (characterCountEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
        } else {
            characterCountEditText2 = characterCountEditText3;
        }
        d16.w("Guild.sch.GuildNewScheduleCreateFragment", 1, "address is " + a16 + " inputUrl.text " + ((Object) characterCountEditText2.getText()));
        this.jumpAddress.f(info);
    }

    private final void Ti() {
        VideoReport.setElementId(this.F, "em_sgrp_auditset_done");
        VideoReport.setEventDynamicParams(this.F, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.home.schedule.create.n
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map Ui;
                Ui = GuildNewScheduleCreateFragment.Ui(GuildNewScheduleCreateFragment.this, str);
                return Ui;
            }
        });
        VideoReport.setElementClickPolicy(this.F, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(this.F, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this.F, EndExposurePolicy.REPORT_ALL);
    }

    public static final Map Ui(GuildNewScheduleCreateFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_subchannel_type", 11);
        hashMap.put("sgrp_sub_appchannel_appid", this$0.scheduleChannelId);
        return hashMap;
    }

    private final void oi() {
        VideoReport.addToDetectionWhitelist(getActivity());
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_sub_channel_id", this.scheduleChannelId);
        VideoReport.setPageId(this.P, "pg_sgrp_create_event");
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        View view = this.P;
        String str = this.guildId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str = null;
        }
        iGuildDTReportApi.setGuildPageParams(view, str, hashMap);
    }

    public static final void ri(GuildNewScheduleCreateFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!QQGuildUIUtil.v()) {
            this$0.Oi();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public static final void si(GuildNewScheduleCreateFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onCancel();
        EventCollector.getInstance().onViewClicked(view);
    }

    public static final void ti(GuildNewScheduleCreateFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Pi();
        QUICheckBox qUICheckBox = this$0.selectChannel;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectChannel");
            qUICheckBox = null;
        }
        qUICheckBox.setChecked(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    public static final void ui(GuildNewScheduleCreateFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUICheckBox qUICheckBox = this$0.selectUrl;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectUrl");
            qUICheckBox = null;
        }
        qUICheckBox.setChecked(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    public static final void vi(GuildNewScheduleCreateFragment this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = null;
        if (z16) {
            TextView textView2 = this$0.scheduleDescCount;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scheduleDescCount");
            } else {
                textView = textView2;
            }
            textView.setVisibility(0);
            return;
        }
        TextView textView3 = this$0.scheduleDescCount;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleDescCount");
        } else {
            textView = textView3;
        }
        textView.setVisibility(4);
    }

    public static final void wi(GuildNewScheduleCreateFragment this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z16 && this$0.ni()) {
            CharacterCountEditText characterCountEditText = this$0.inputUrl;
            if (characterCountEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
                characterCountEditText = null;
            }
            this$0.feedUrl = characterCountEditText.getText().toString();
            GuildNewScheduleViewModel guildNewScheduleViewModel = this$0.viewModel;
            if (guildNewScheduleViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildNewScheduleViewModel = null;
            }
            CharacterCountEditText characterCountEditText2 = this$0.inputUrl;
            if (characterCountEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
                characterCountEditText2 = null;
            }
            GuildNewScheduleViewModel.Z1(guildNewScheduleViewModel, characterCountEditText2.getText().toString(), false, 2, null);
        }
    }

    public static final void xi(GuildNewScheduleCreateFragment this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            QUICheckBox qUICheckBox = this$0.selectChannel;
            RelativeLayout relativeLayout = null;
            if (qUICheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectChannel");
                qUICheckBox = null;
            }
            qUICheckBox.setChecked(true);
            QUICheckBox qUICheckBox2 = this$0.selectChannel;
            if (qUICheckBox2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectChannel");
                qUICheckBox2 = null;
            }
            qUICheckBox2.setClickable(false);
            QUICheckBox qUICheckBox3 = this$0.selectUrl;
            if (qUICheckBox3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectUrl");
                qUICheckBox3 = null;
            }
            qUICheckBox3.setChecked(false);
            QUICheckBox qUICheckBox4 = this$0.selectUrl;
            if (qUICheckBox4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectUrl");
                qUICheckBox4 = null;
            }
            qUICheckBox4.setClickable(true);
            ConstraintLayout constraintLayout = this$0.inputUrlCly;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputUrlCly");
                constraintLayout = null;
            }
            constraintLayout.setVisibility(8);
            RelativeLayout relativeLayout2 = this$0.scheduleUrlRly;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scheduleUrlRly");
            } else {
                relativeLayout = relativeLayout2;
            }
            relativeLayout.setBackgroundResource(R.drawable.guild_token_setting_bottom_round_rect_8_normal_white);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    public static final void yi(GuildNewScheduleCreateFragment this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            QUICheckBox qUICheckBox = this$0.selectChannel;
            RelativeLayout relativeLayout = null;
            if (qUICheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectChannel");
                qUICheckBox = null;
            }
            qUICheckBox.setChecked(false);
            QUICheckBox qUICheckBox2 = this$0.selectChannel;
            if (qUICheckBox2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectChannel");
                qUICheckBox2 = null;
            }
            qUICheckBox2.setClickable(true);
            QUICheckBox qUICheckBox3 = this$0.selectUrl;
            if (qUICheckBox3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectUrl");
                qUICheckBox3 = null;
            }
            qUICheckBox3.setChecked(true);
            QUICheckBox qUICheckBox4 = this$0.selectUrl;
            if (qUICheckBox4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectUrl");
                qUICheckBox4 = null;
            }
            qUICheckBox4.setClickable(false);
            ConstraintLayout constraintLayout = this$0.inputUrlCly;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputUrlCly");
                constraintLayout = null;
            }
            constraintLayout.setVisibility(0);
            RelativeLayout relativeLayout2 = this$0.scheduleUrlRly;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scheduleUrlRly");
            } else {
                relativeLayout = relativeLayout2;
            }
            relativeLayout.setBackgroundResource(R.drawable.qui_common_fill_light_secondary_bg_selector);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
    
        if (r1.canScrollVertically(-1) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean zi(GuildNewScheduleCreateFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CharacterCountEditText characterCountEditText = this$0.scheduleDesc;
        CharacterCountEditText characterCountEditText2 = null;
        if (characterCountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleDesc");
            characterCountEditText = null;
        }
        if (!characterCountEditText.canScrollVertically(1)) {
            CharacterCountEditText characterCountEditText3 = this$0.scheduleDesc;
            if (characterCountEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scheduleDesc");
            } else {
                characterCountEditText2 = characterCountEditText3;
            }
        }
        view.getParent().requestDisallowInterceptTouchEvent(true);
        if (motionEvent.getAction() == 1) {
            view.getParent().requestDisallowInterceptTouchEvent(false);
        }
        return false;
    }

    public final boolean Li() {
        GuildNewScheduleViewModel guildNewScheduleViewModel = this.viewModel;
        CharacterCountEditText characterCountEditText = null;
        if (guildNewScheduleViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildNewScheduleViewModel = null;
        }
        if (Intrinsics.areEqual(guildNewScheduleViewModel.k2().getValue(), Boolean.TRUE)) {
            CharacterCountEditText characterCountEditText2 = this.inputUrl;
            if (characterCountEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
            } else {
                characterCountEditText = characterCountEditText2;
            }
            if (Intrinsics.areEqual(characterCountEditText.getText().toString(), this.abstractInfo)) {
                return true;
            }
        }
        return false;
    }

    public final void Oi() {
        GuildNewScheduleViewModel guildNewScheduleViewModel;
        String replaceBeforeLast$default;
        CharSequence trim;
        QUISingleLineInputView qUISingleLineInputView = this.scheduleName;
        QUICheckBox qUICheckBox = null;
        CharacterCountEditText characterCountEditText = null;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleName");
            qUISingleLineInputView = null;
        }
        if (TextUtils.isEmpty(qUISingleLineInputView.d())) {
            ch.f1("\u5185\u5bb9\u5c1a\u672a\u586b\u5199\u5b8c\u6bd5");
            return;
        }
        GuildNewScheduleViewModel guildNewScheduleViewModel2 = this.viewModel;
        if (guildNewScheduleViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildNewScheduleViewModel2 = null;
        }
        if (guildNewScheduleViewModel2.n2().getValue() == null) {
            ch.f1("\u5185\u5bb9\u5c1a\u672a\u586b\u5199\u5b8c\u6bd5");
            return;
        }
        QUICheckBox qUICheckBox2 = this.selectUrl;
        if (qUICheckBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectUrl");
            qUICheckBox2 = null;
        }
        if (qUICheckBox2.isChecked()) {
            CharacterCountEditText characterCountEditText2 = this.inputUrl;
            if (characterCountEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
                characterCountEditText2 = null;
            }
            if (TextUtils.isEmpty(characterCountEditText2.getText())) {
                ch.f1("\u5185\u5bb9\u5c1a\u672a\u586b\u5199\u5b8c\u6bd5");
                return;
            }
        }
        QUICheckBox qUICheckBox3 = this.selectUrl;
        if (qUICheckBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectUrl");
            qUICheckBox3 = null;
        }
        if (qUICheckBox3.isChecked() && ni()) {
            GuildNewScheduleViewModel guildNewScheduleViewModel3 = this.viewModel;
            if (guildNewScheduleViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildNewScheduleViewModel3 = null;
            }
            if (guildNewScheduleViewModel3.k2().getValue() == null || !Li()) {
                CharacterCountEditText characterCountEditText3 = this.inputUrl;
                if (characterCountEditText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
                    characterCountEditText3 = null;
                }
                replaceBeforeLast$default = StringsKt__StringsKt.replaceBeforeLast$default(characterCountEditText3.getText().toString(), "http", "", (String) null, 4, (Object) null);
                trim = StringsKt__StringsKt.trim((CharSequence) replaceBeforeLast$default);
                this.feedUrl = trim.toString();
                GuildNewScheduleViewModel guildNewScheduleViewModel4 = this.viewModel;
                if (guildNewScheduleViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    guildNewScheduleViewModel4 = null;
                }
                CharacterCountEditText characterCountEditText4 = this.inputUrl;
                if (characterCountEditText4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
                } else {
                    characterCountEditText = characterCountEditText4;
                }
                guildNewScheduleViewModel4.X1(characterCountEditText.getText().toString(), true);
                return;
            }
        }
        QUICheckBox qUICheckBox4 = this.selectUrl;
        if (qUICheckBox4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectUrl");
            qUICheckBox4 = null;
        }
        if (qUICheckBox4.isChecked() && ni()) {
            GuildNewScheduleViewModel guildNewScheduleViewModel5 = this.viewModel;
            if (guildNewScheduleViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildNewScheduleViewModel5 = null;
            }
            if (Intrinsics.areEqual(guildNewScheduleViewModel5.k2().getValue(), Boolean.FALSE)) {
                ch.f1("\u8bf7\u68c0\u67e5\u5e16\u5b50\u94fe\u63a5\u6216\u8005\u7ebf\u4e0b\u5730\u5740");
                return;
            }
        }
        QUICheckBox qUICheckBox5 = this.selectUrl;
        if (qUICheckBox5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectUrl");
            qUICheckBox5 = null;
        }
        if (qUICheckBox5.isChecked() && this.jumpAddress.b() != 1) {
            dp dpVar = new dp();
            this.jumpAddress = dpVar;
            dpVar.e(2);
            dp dpVar2 = this.jumpAddress;
            CharacterCountEditText characterCountEditText5 = this.inputUrl;
            if (characterCountEditText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
                characterCountEditText5 = null;
            }
            dpVar2.d(characterCountEditText5.getText().toString());
        }
        GuildNewScheduleViewModel guildNewScheduleViewModel6 = this.viewModel;
        if (guildNewScheduleViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildNewScheduleViewModel = null;
        } else {
            guildNewScheduleViewModel = guildNewScheduleViewModel6;
        }
        QUISingleLineInputView qUISingleLineInputView2 = this.scheduleName;
        if (qUISingleLineInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleName");
            qUISingleLineInputView2 = null;
        }
        String valueOf = String.valueOf(qUISingleLineInputView2.d());
        CharacterCountEditText characterCountEditText6 = this.scheduleDesc;
        if (characterCountEditText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleDesc");
            characterCountEditText6 = null;
        }
        String obj = characterCountEditText6.getText().toString();
        eb ebVar = this.guildScheduleChannelInfo;
        dp dpVar3 = this.jumpAddress;
        long j3 = this.selectChannelId;
        QUICheckBox qUICheckBox6 = this.selectChannel;
        if (qUICheckBox6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectChannel");
        } else {
            qUICheckBox = qUICheckBox6;
        }
        guildNewScheduleViewModel.b2(valueOf, obj, ebVar, dpVar3, j3, qUICheckBox.isChecked(), this.scheduleChannelId);
    }

    public final void Qi(@NotNull String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        TextView textView = this.checkUrlResult;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkUrlResult");
            textView = null;
        }
        textView.setVisibility(0);
        TextView textView3 = this.checkUrlResult;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkUrlResult");
            textView3 = null;
        }
        TextView textView4 = this.checkUrlResult;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkUrlResult");
            textView4 = null;
        }
        textView3.setTextColor(AppCompatResources.getColorStateList(textView4.getContext(), R.color.qui_common_feedback_error));
        TextView textView5 = this.checkUrlResult;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkUrlResult");
            textView5 = null;
        }
        TextView textView6 = this.checkUrlResult;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkUrlResult");
            textView6 = null;
        }
        Context context = textView6.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "checkUrlResult.context");
        TextView textView7 = this.checkUrlResult;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkUrlResult");
            textView7 = null;
        }
        textView5.setCompoundDrawablesWithIntrinsicBounds(GuildUIUtils.y(context, R.drawable.qui_caution_circle, QQGuildUIUtil.i(textView7.getContext(), R.color.qui_common_feedback_error)), (Drawable) null, (Drawable) null, (Drawable) null);
        TextView textView8 = this.checkUrlResult;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkUrlResult");
            textView8 = null;
        }
        textView8.setTextSize(2, 14.0f);
        TextView textView9 = this.checkUrlResult;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkUrlResult");
        } else {
            textView2 = textView9;
        }
        textView2.setText(error);
    }

    public final void Si(int drawableRes) {
        ImageView imageView = this.scheduleChannelIcon;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleChannelIcon");
            imageView = null;
        }
        ImageView imageView3 = this.scheduleChannelIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleChannelIcon");
        } else {
            imageView2 = imageView3;
        }
        Context context = imageView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "scheduleChannelIcon.context");
        imageView.setImageDrawable(GuildUIUtils.w(context, drawableRes, Integer.valueOf(R.color.qui_common_text_secondary)));
    }

    public final void Vi(@NotNull eb ebVar) {
        Intrinsics.checkNotNullParameter(ebVar, "<set-?>");
        this.guildScheduleChannelInfo = ebVar;
    }

    public final void Wi(@NotNull dp dpVar) {
        Intrinsics.checkNotNullParameter(dpVar, "<set-?>");
        this.jumpAddress = dpVar;
    }

    public final void Xi(long j3) {
        this.selectChannelId = j3;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f7n;
    }

    public final void initView() {
        setTitle("\u521b\u5efa\u65e5\u7a0b");
        vh("\u5b8c\u6210", new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.schedule.create.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNewScheduleCreateFragment.ri(GuildNewScheduleCreateFragment.this, view);
            }
        });
        this.F.setAlpha(0.5f);
        setLeftButton(getResources().getString(R.string.f140850f3), new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.schedule.create.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNewScheduleCreateFragment.si(GuildNewScheduleCreateFragment.this, view);
            }
        });
        rh();
        View findViewById = this.P.findViewById(R.id.f80014ab);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.schedule_name)");
        this.scheduleName = (QUISingleLineInputView) findViewById;
        View findViewById2 = this.P.findViewById(R.id.f80044ae);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewByI\u2026R.id.schedule_start_time)");
        this.scheduleStartTime = (TextView) findViewById2;
        View findViewById3 = this.P.findViewById(R.id.f79984a9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mContentView.findViewById(R.id.schedule_end_time)");
        this.scheduleEndTime = (TextView) findViewById3;
        View findViewById4 = this.P.findViewById(R.id.t_3);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mContentView.findViewById(R.id.bottom_anchor_view)");
        this.anchorView = findViewById4;
        View findViewById5 = this.P.findViewById(R.id.f79864_x);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mContentView.findViewById(R.id.schedule_channel)");
        this.scheduleChannel = (TextView) findViewById5;
        View findViewById6 = this.P.findViewById(R.id.f82064fv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mContentView.findViewById(R.id.select_channel)");
        this.selectChannel = (QUICheckBox) findViewById6;
        View findViewById7 = this.P.findViewById(R.id.f82484h0);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mContentView.findViewById(R.id.select_url)");
        this.selectUrl = (QUICheckBox) findViewById7;
        View findViewById8 = this.P.findViewById(R.id.f80114al);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mContentView.findViewById(R.id.schedule_url_rly)");
        this.scheduleUrlRly = (RelativeLayout) findViewById8;
        View findViewById9 = this.P.findViewById(R.id.f79894a0);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mContentView.findViewByI\u2026R.id.schedule_desc_count)");
        this.scheduleDescCount = (TextView) findViewById9;
        View findViewById10 = this.P.findViewById(R.id.f79884_z);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "mContentView.findViewById(R.id.schedule_desc)");
        this.scheduleDesc = (CharacterCountEditText) findViewById10;
        View findViewById11 = this.P.findViewById(R.id.f79874_y);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "mContentView.findViewByI\u2026id.schedule_channel_icon)");
        this.scheduleChannelIcon = (ImageView) findViewById11;
        View findViewById12 = this.P.findViewById(R.id.xox);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "mContentView.findViewById(R.id.input_url_cly)");
        this.inputUrlCly = (ConstraintLayout) findViewById12;
        View findViewById13 = this.P.findViewById(R.id.xow);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "mContentView.findViewById(R.id.input_url)");
        this.inputUrl = (CharacterCountEditText) findViewById13;
        View findViewById14 = this.P.findViewById(R.id.sdx);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "mContentView.findViewById(R.id.address_tip)");
        this.addressTip = (TextView) findViewById14;
        View findViewById15 = this.P.findViewById(R.id.sdu);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "mContentView.findViewById(R.id.address_cly)");
        this.addressCly = (ConstraintLayout) findViewById15;
        View findViewById16 = this.P.findViewById(R.id.tvi);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "mContentView.findViewById(R.id.check_url_result)");
        this.checkUrlResult = (TextView) findViewById16;
        ((LinearLayout) this.P.findViewById(R.id.f80004aa)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.schedule.create.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNewScheduleCreateFragment.ti(GuildNewScheduleCreateFragment.this, view);
            }
        });
        RelativeLayout relativeLayout = this.scheduleUrlRly;
        QUISingleLineInputView qUISingleLineInputView = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleUrlRly");
            relativeLayout = null;
        }
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.schedule.create.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNewScheduleCreateFragment.ui(GuildNewScheduleCreateFragment.this, view);
            }
        });
        CharacterCountEditText characterCountEditText = this.scheduleDesc;
        if (characterCountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleDesc");
            characterCountEditText = null;
        }
        characterCountEditText.setLimitCount(500);
        CharacterCountEditText characterCountEditText2 = this.scheduleDesc;
        if (characterCountEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleDesc");
            characterCountEditText2 = null;
        }
        characterCountEditText2.setCountChangeListener(new b());
        CharacterCountEditText characterCountEditText3 = this.scheduleDesc;
        if (characterCountEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleDesc");
            characterCountEditText3 = null;
        }
        characterCountEditText3.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.guild.home.schedule.create.q
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                GuildNewScheduleCreateFragment.vi(GuildNewScheduleCreateFragment.this, view, z16);
            }
        });
        CharacterCountEditText characterCountEditText4 = this.inputUrl;
        if (characterCountEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
            characterCountEditText4 = null;
        }
        characterCountEditText4.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.guild.home.schedule.create.r
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                GuildNewScheduleCreateFragment.wi(GuildNewScheduleCreateFragment.this, view, z16);
            }
        });
        CharacterCountEditText characterCountEditText5 = this.inputUrl;
        if (characterCountEditText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
            characterCountEditText5 = null;
        }
        characterCountEditText5.setCountChangeListener(new c());
        QUISingleLineInputView qUISingleLineInputView2 = this.scheduleName;
        if (qUISingleLineInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleName");
            qUISingleLineInputView2 = null;
        }
        qUISingleLineInputView2.setInputViewWatcher(new d());
        QUICheckBox qUICheckBox = this.selectChannel;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectChannel");
            qUICheckBox = null;
        }
        qUICheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.home.schedule.create.s
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildNewScheduleCreateFragment.xi(GuildNewScheduleCreateFragment.this, compoundButton, z16);
            }
        });
        QUICheckBox qUICheckBox2 = this.selectUrl;
        if (qUICheckBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectUrl");
            qUICheckBox2 = null;
        }
        qUICheckBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.home.schedule.create.t
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildNewScheduleCreateFragment.yi(GuildNewScheduleCreateFragment.this, compoundButton, z16);
            }
        });
        Si(GuildChannelIconUtil.j(7, 0, 0, 6, null));
        CharacterCountEditText characterCountEditText6 = this.scheduleDesc;
        if (characterCountEditText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleDesc");
            characterCountEditText6 = null;
        }
        characterCountEditText6.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.home.schedule.create.u
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean zi5;
                zi5 = GuildNewScheduleCreateFragment.zi(GuildNewScheduleCreateFragment.this, view, motionEvent);
                return zi5;
            }
        });
        QUISingleLineInputView qUISingleLineInputView3 = this.scheduleName;
        if (qUISingleLineInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleName");
            qUISingleLineInputView3 = null;
        }
        qUISingleLineInputView3.a();
        QUISingleLineInputView qUISingleLineInputView4 = this.scheduleName;
        if (qUISingleLineInputView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleName");
        } else {
            qUISingleLineInputView = qUISingleLineInputView4;
        }
        qUISingleLineInputView.p();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        Object systemService = activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        View peekDecorView = activity.getWindow().peekDecorView();
        if (peekDecorView != null && peekDecorView.getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(peekDecorView.getWindowToken(), 0);
        }
    }

    public final void initViewModel() {
        GuildNewScheduleViewModel guildNewScheduleViewModel;
        GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
        String string = guildSplitViewUtils.g(this).getString("extra_guild_id");
        String str = "";
        if (string == null) {
            string = "";
        }
        this.guildId = string;
        String string2 = guildSplitViewUtils.g(this).getString("extra_channel_id");
        if (string2 != null) {
            str = string2;
        }
        this.scheduleChannelId = str;
        this.defaultTime = guildSplitViewUtils.g(this).getLong("create_schedule_time", NetConnInfoCenter.getServerTimeMillis());
        String str2 = this.guildId;
        GuildNewScheduleViewModel guildNewScheduleViewModel2 = null;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            Logger.f235387a.d().w("Guild.sch.GuildNewScheduleCreateFragment", 1, "guildId is null, finish");
            GuildSplitViewUtils.u(guildSplitViewUtils, getActivity(), false, 2, null);
        }
        if (guildSplitViewUtils.n(getActivity())) {
            c.Companion companion = ef1.c.INSTANCE;
            String str3 = this.guildId;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str3 = null;
            }
            guildNewScheduleViewModel = (GuildNewScheduleViewModel) companion.a(this, GuildNewScheduleViewModel.class, str3);
        } else {
            c.Companion companion2 = ef1.c.INSTANCE;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            String str4 = this.guildId;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str4 = null;
            }
            guildNewScheduleViewModel = (GuildNewScheduleViewModel) companion2.a(requireActivity, GuildNewScheduleViewModel.class, str4);
        }
        this.viewModel = guildNewScheduleViewModel;
        Ti();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            GuildNewScheduleViewModel guildNewScheduleViewModel3 = this.viewModel;
            if (guildNewScheduleViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildNewScheduleViewModel3 = null;
            }
            guildNewScheduleViewModel3.q2(activity, this.defaultTime);
        }
        ((RelativeLayout) this.P.findViewById(R.id.f80054af)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.schedule.create.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNewScheduleCreateFragment.Ai(GuildNewScheduleCreateFragment.this, view);
            }
        });
        ((RelativeLayout) this.P.findViewById(R.id.f79994a_)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.schedule.create.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNewScheduleCreateFragment.Bi(GuildNewScheduleCreateFragment.this, view);
            }
        });
        GuildNewScheduleViewModel guildNewScheduleViewModel4 = this.viewModel;
        if (guildNewScheduleViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildNewScheduleViewModel4 = null;
        }
        MutableLiveData<Long> o26 = guildNewScheduleViewModel4.o2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.guild.home.schedule.create.GuildNewScheduleCreateFragment$initViewModel$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long it) {
                TextView textView;
                textView = GuildNewScheduleCreateFragment.this.scheduleStartTime;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scheduleStartTime");
                    textView = null;
                }
                yo1.c cVar = yo1.c.f450725a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                textView.setText(cVar.d(it.longValue()));
            }
        };
        o26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.home.schedule.create.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildNewScheduleCreateFragment.Ci(Function1.this, obj);
            }
        });
        GuildNewScheduleViewModel guildNewScheduleViewModel5 = this.viewModel;
        if (guildNewScheduleViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildNewScheduleViewModel5 = null;
        }
        MutableLiveData<Long> n26 = guildNewScheduleViewModel5.n2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Long, Unit> function12 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.guild.home.schedule.create.GuildNewScheduleCreateFragment$initViewModel$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long it) {
                TextView textView;
                textView = GuildNewScheduleCreateFragment.this.scheduleEndTime;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scheduleEndTime");
                    textView = null;
                }
                yo1.c cVar = yo1.c.f450725a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                textView.setText(cVar.d(it.longValue()));
            }
        };
        n26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.home.schedule.create.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildNewScheduleCreateFragment.Di(Function1.this, obj);
            }
        });
        GuildNewScheduleViewModel guildNewScheduleViewModel6 = this.viewModel;
        if (guildNewScheduleViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildNewScheduleViewModel6 = null;
        }
        MutableLiveData<IGProScheduleInfo> r26 = guildNewScheduleViewModel6.r2();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<IGProScheduleInfo, Unit> function13 = new Function1<IGProScheduleInfo, Unit>() { // from class: com.tencent.mobileqq.guild.home.schedule.create.GuildNewScheduleCreateFragment$initViewModel$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProScheduleInfo iGProScheduleInfo) {
                invoke2(iGProScheduleInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IGProScheduleInfo iGProScheduleInfo) {
                FragmentActivity activity2;
                FragmentManager supportFragmentManager;
                if (iGProScheduleInfo != null) {
                    Intent intent = new Intent();
                    intent.putExtra("success_schedule_info_create_time", iGProScheduleInfo.getCreateTimeMs());
                    intent.putExtra("success_schedule_info_schedule_id", iGProScheduleInfo.getScheduleId());
                    intent.putExtra("success_schedule_info_start_time", iGProScheduleInfo.getStartTimeMs());
                    GuildSplitViewUtils guildSplitViewUtils2 = GuildSplitViewUtils.f235370a;
                    if (!guildSplitViewUtils2.n(GuildNewScheduleCreateFragment.this.getActivity())) {
                        FragmentActivity activity3 = GuildNewScheduleCreateFragment.this.getActivity();
                        if (activity3 != null) {
                            activity3.setResult(-1, intent);
                        }
                    } else {
                        Bundle extras = intent.getExtras();
                        if (extras != null && (activity2 = GuildNewScheduleCreateFragment.this.getActivity()) != null && (supportFragmentManager = activity2.getSupportFragmentManager()) != null) {
                            supportFragmentManager.setFragmentResult("100", extras);
                        }
                    }
                    guildSplitViewUtils2.t(GuildNewScheduleCreateFragment.this.getActivity(), true);
                }
            }
        };
        r26.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.home.schedule.create.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildNewScheduleCreateFragment.Ei(Function1.this, obj);
            }
        });
        GuildNewScheduleViewModel guildNewScheduleViewModel7 = this.viewModel;
        if (guildNewScheduleViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildNewScheduleViewModel7 = null;
        }
        MutableLiveData<String> g26 = guildNewScheduleViewModel7.g2();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<String, Unit> function14 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.home.schedule.create.GuildNewScheduleCreateFragment$initViewModel$9
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str5) {
                invoke2(str5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                String str5;
                CharacterCountEditText characterCountEditText = GuildNewScheduleCreateFragment.this.inputUrl;
                TextView textView = null;
                if (characterCountEditText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
                    characterCountEditText = null;
                }
                characterCountEditText.setLimitCount(Integer.MAX_VALUE);
                String str6 = "\u5e16\u5b50: " + it;
                GuildNewScheduleCreateFragment guildNewScheduleCreateFragment = GuildNewScheduleCreateFragment.this;
                if (str6.length() > 20) {
                    str6 = str6.substring(0, 20);
                    Intrinsics.checkNotNullExpressionValue(str6, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                }
                guildNewScheduleCreateFragment.abstractInfo = str6;
                GuildNewScheduleCreateFragment guildNewScheduleCreateFragment2 = GuildNewScheduleCreateFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildNewScheduleCreateFragment2.Ri(it);
                CharacterCountEditText characterCountEditText2 = GuildNewScheduleCreateFragment.this.inputUrl;
                if (characterCountEditText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
                    characterCountEditText2 = null;
                }
                characterCountEditText2.setText("");
                CharacterCountEditText characterCountEditText3 = GuildNewScheduleCreateFragment.this.inputUrl;
                if (characterCountEditText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
                    characterCountEditText3 = null;
                }
                str5 = GuildNewScheduleCreateFragment.this.abstractInfo;
                characterCountEditText3.setText(str5);
                TextView textView2 = GuildNewScheduleCreateFragment.this.checkUrlResult;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("checkUrlResult");
                } else {
                    textView = textView2;
                }
                textView.setVisibility(8);
            }
        };
        g26.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.guild.home.schedule.create.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildNewScheduleCreateFragment.Fi(Function1.this, obj);
            }
        });
        GuildNewScheduleViewModel guildNewScheduleViewModel8 = this.viewModel;
        if (guildNewScheduleViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildNewScheduleViewModel8 = null;
        }
        MutableLiveData<String> f26 = guildNewScheduleViewModel8.f2();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        final Function1<String, Unit> function15 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.home.schedule.create.GuildNewScheduleCreateFragment$initViewModel$10
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str5) {
                invoke2(str5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                GuildNewScheduleCreateFragment guildNewScheduleCreateFragment = GuildNewScheduleCreateFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildNewScheduleCreateFragment.Qi(it);
            }
        };
        f26.observe(viewLifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.guild.home.schedule.create.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildNewScheduleCreateFragment.Gi(Function1.this, obj);
            }
        });
        GuildNewScheduleViewModel guildNewScheduleViewModel9 = this.viewModel;
        if (guildNewScheduleViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildNewScheduleViewModel9 = null;
        }
        MutableLiveData<Boolean> l26 = guildNewScheduleViewModel9.l2();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function16 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.home.schedule.create.GuildNewScheduleCreateFragment$initViewModel$11
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    GuildNewScheduleCreateFragment.this.Oi();
                }
            }
        };
        l26.observe(viewLifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.guild.home.schedule.create.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildNewScheduleCreateFragment.Hi(Function1.this, obj);
            }
        });
        GuildNewScheduleViewModel guildNewScheduleViewModel10 = this.viewModel;
        if (guildNewScheduleViewModel10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildNewScheduleViewModel10 = null;
        }
        MutableLiveData<Boolean> h26 = guildNewScheduleViewModel10.h2();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function17 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.home.schedule.create.GuildNewScheduleCreateFragment$initViewModel$12
            /* JADX INFO: Access modifiers changed from: package-private */
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
                TextView textView;
                ConstraintLayout constraintLayout;
                TextView textView2;
                ConstraintLayout constraintLayout2;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                ConstraintLayout constraintLayout3 = null;
                if (it.booleanValue()) {
                    textView2 = GuildNewScheduleCreateFragment.this.addressTip;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("addressTip");
                        textView2 = null;
                    }
                    textView2.setVisibility(0);
                    constraintLayout2 = GuildNewScheduleCreateFragment.this.addressCly;
                    if (constraintLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("addressCly");
                    } else {
                        constraintLayout3 = constraintLayout2;
                    }
                    constraintLayout3.setVisibility(0);
                    return;
                }
                textView = GuildNewScheduleCreateFragment.this.addressTip;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addressTip");
                    textView = null;
                }
                textView.setVisibility(8);
                constraintLayout = GuildNewScheduleCreateFragment.this.addressCly;
                if (constraintLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addressCly");
                } else {
                    constraintLayout3 = constraintLayout;
                }
                constraintLayout3.setVisibility(8);
            }
        };
        h26.observe(viewLifecycleOwner7, new Observer() { // from class: com.tencent.mobileqq.guild.home.schedule.create.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildNewScheduleCreateFragment.Ii(Function1.this, obj);
            }
        });
        GuildNewScheduleViewModel guildNewScheduleViewModel11 = this.viewModel;
        if (guildNewScheduleViewModel11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildNewScheduleViewModel2 = guildNewScheduleViewModel11;
        }
        MutableLiveData<eb> m26 = guildNewScheduleViewModel2.m2();
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        final Function1<eb, Unit> function18 = new Function1<eb, Unit>() { // from class: com.tencent.mobileqq.guild.home.schedule.create.GuildNewScheduleCreateFragment$initViewModel$13
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(eb ebVar) {
                invoke2(ebVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(eb it) {
                GuildNewScheduleCreateFragment.this.Xi(it.a());
                GuildNewScheduleCreateFragment guildNewScheduleCreateFragment = GuildNewScheduleCreateFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildNewScheduleCreateFragment.Vi(it);
            }
        };
        m26.observe(viewLifecycleOwner8, new Observer() { // from class: com.tencent.mobileqq.guild.home.schedule.create.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildNewScheduleCreateFragment.Ji(Function1.this, obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean ni() {
        boolean z16;
        boolean startsWith$default;
        boolean z17;
        boolean contains$default;
        CharacterCountEditText characterCountEditText = this.inputUrl;
        if (characterCountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
            characterCountEditText = null;
        }
        if (!TextUtils.isEmpty(characterCountEditText.getText())) {
            CharacterCountEditText characterCountEditText2 = this.inputUrl;
            if (characterCountEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
                characterCountEditText2 = null;
            }
            Editable text = characterCountEditText2.getText();
            if (text != null) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) "://pd.qq.com/s", false, 2, (Object) null);
                if (contains$default) {
                    z17 = true;
                    if (z17) {
                        return true;
                    }
                }
            }
            z17 = false;
            if (z17) {
            }
        }
        CharacterCountEditText characterCountEditText3 = this.inputUrl;
        if (characterCountEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
            characterCountEditText3 = null;
        }
        Editable text2 = characterCountEditText3.getText();
        if (text2 != null) {
            startsWith$default = StringsKt__StringsKt.startsWith$default((CharSequence) text2, (CharSequence) "http", false, 2, (Object) null);
            if (startsWith$default) {
                z16 = true;
                if (!z16) {
                    return true;
                }
                return false;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int r26, @Nullable Intent data) {
        super.onActivityResult(requestCode, r26, data);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        onCancel();
        return true;
    }

    public final void onCancel() {
        if (Ki()) {
            DialogUtil.createCustomDialog(getContext(), 230, (String) null, "\u786e\u5b9a\u653e\u5f03\u7f16\u8f91\u65e5\u7a0b\uff1f\n(\u9000\u51fa\u540e\u4e0d\u4fdd\u7559\u8349\u7a3f)", "\u7ee7\u7eed\u7f16\u8f91", "\u9000\u51fa", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.schedule.create.k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildNewScheduleCreateFragment.Mi(GuildNewScheduleCreateFragment.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.schedule.create.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildNewScheduleCreateFragment.Ni(dialogInterface, i3);
                }
            }).show();
        } else {
            GuildSplitViewUtils.f235370a.t(getActivity(), true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(18);
        }
        initView();
        initViewModel();
        oi();
    }

    @NotNull
    /* renamed from: pi, reason: from getter */
    public final eb getGuildScheduleChannelInfo() {
        return this.guildScheduleChannelInfo;
    }

    @NotNull
    /* renamed from: qi, reason: from getter */
    public final dp getJumpAddress() {
        return this.jumpAddress;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        this.J.a();
        this.J.setBackgroundResource(R.drawable.lvj);
    }

    @Override // com.tencent.mobileqq.pad.d
    public boolean shouldDispatchActivityResult() {
        return true;
    }

    @Override // com.tencent.mobileqq.pad.d
    public boolean shouldDispatchPostThemeChanged() {
        return true;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/home/schedule/create/GuildNewScheduleCreateFragment$b", "Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText$c;", "Lcom/tencent/mobileqq/guild/util/cb$b;", "countInfo", "", ICustomDataEditor.STRING_PARAM_7, "Bf", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements CharacterCountEditText.c {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.widget.CharacterCountEditText.c
        public void s7(@NotNull cb.b countInfo) {
            Intrinsics.checkNotNullParameter(countInfo, "countInfo");
            int a16 = countInfo.a();
            TextView textView = GuildNewScheduleCreateFragment.this.scheduleDescCount;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scheduleDescCount");
                textView = null;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%s/%s", Arrays.copyOf(new Object[]{Integer.valueOf(a16), 500}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
        }

        @Override // com.tencent.mobileqq.guild.widget.CharacterCountEditText.c
        public void Bf(@Nullable cb.b countInfo) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/home/schedule/create/GuildNewScheduleCreateFragment$c", "Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText$c;", "Lcom/tencent/mobileqq/guild/util/cb$b;", "countInfo", "", ICustomDataEditor.STRING_PARAM_7, "Bf", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements CharacterCountEditText.c {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.widget.CharacterCountEditText.c
        public void s7(@NotNull cb.b countInfo) {
            Intrinsics.checkNotNullParameter(countInfo, "countInfo");
            int a16 = countInfo.a();
            if (a16 > 0 && GuildNewScheduleCreateFragment.this.getJumpAddress().b() != 0 && !GuildNewScheduleCreateFragment.this.Li()) {
                GuildNewScheduleCreateFragment.this.Wi(new dp());
            }
            TextView textView = null;
            if (a16 <= 20 || GuildNewScheduleCreateFragment.this.ni()) {
                CharacterCountEditText characterCountEditText = GuildNewScheduleCreateFragment.this.inputUrl;
                if (characterCountEditText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
                    characterCountEditText = null;
                }
                characterCountEditText.setLimitCount(Integer.MAX_VALUE);
                TextView textView2 = GuildNewScheduleCreateFragment.this.checkUrlResult;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("checkUrlResult");
                    textView2 = null;
                }
                if (Intrinsics.areEqual(textView2.getText(), GuildNewScheduleCreateFragment.this.error)) {
                    TextView textView3 = GuildNewScheduleCreateFragment.this.checkUrlResult;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("checkUrlResult");
                        textView3 = null;
                    }
                    textView3.setVisibility(8);
                }
            } else {
                CharacterCountEditText characterCountEditText2 = GuildNewScheduleCreateFragment.this.inputUrl;
                if (characterCountEditText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputUrl");
                    characterCountEditText2 = null;
                }
                characterCountEditText2.setLimitCount(20);
                aa.e(GuildNewScheduleCreateFragment.this.error);
                GuildNewScheduleCreateFragment guildNewScheduleCreateFragment = GuildNewScheduleCreateFragment.this;
                guildNewScheduleCreateFragment.Qi(guildNewScheduleCreateFragment.error);
            }
            if (a16 == 0) {
                TextView textView4 = GuildNewScheduleCreateFragment.this.checkUrlResult;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("checkUrlResult");
                } else {
                    textView = textView4;
                }
                textView.setVisibility(8);
            }
        }

        @Override // com.tencent.mobileqq.guild.widget.CharacterCountEditText.c
        public void Bf(@Nullable cb.b countInfo) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010\u000f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J*\u0010\u0011\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/guild/home/schedule/create/GuildNewScheduleCreateFragment$d", "Lh53/q;", "", "hasFocus", "", "f8", "", "title", "A4", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements h53.q {
        d() {
        }

        @Override // h53.k
        public void afterTextChanged(@Nullable Editable r56) {
            float f16;
            CharSequence trim;
            QUISingleLineInputView qUISingleLineInputView = GuildNewScheduleCreateFragment.this.scheduleName;
            QUISingleLineInputView qUISingleLineInputView2 = null;
            if (qUISingleLineInputView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scheduleName");
                qUISingleLineInputView = null;
            }
            String valueOf = String.valueOf(qUISingleLineInputView.d());
            if (!TextUtils.isEmpty(valueOf)) {
                trim = StringsKt__StringsKt.trim((CharSequence) valueOf);
                if (TextUtils.isEmpty(trim.toString())) {
                    QUISingleLineInputView qUISingleLineInputView3 = GuildNewScheduleCreateFragment.this.scheduleName;
                    if (qUISingleLineInputView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("scheduleName");
                    } else {
                        qUISingleLineInputView2 = qUISingleLineInputView3;
                    }
                    qUISingleLineInputView2.setContentText("");
                    return;
                }
            }
            String replace = new Regex("[\\s]+").replace(valueOf, " ");
            if (!Intrinsics.areEqual(replace, valueOf)) {
                QUISingleLineInputView qUISingleLineInputView4 = GuildNewScheduleCreateFragment.this.scheduleName;
                if (qUISingleLineInputView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scheduleName");
                } else {
                    qUISingleLineInputView2 = qUISingleLineInputView4;
                }
                qUISingleLineInputView2.setContentText(replace);
                return;
            }
            QUISingleLineInputView qUISingleLineInputView5 = GuildNewScheduleCreateFragment.this.scheduleName;
            if (qUISingleLineInputView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scheduleName");
            } else {
                qUISingleLineInputView2 = qUISingleLineInputView5;
            }
            cb.b b16 = cb.b(qUISingleLineInputView2.d());
            TextView textView = GuildNewScheduleCreateFragment.this.F;
            if (b16.a() >= 1) {
                f16 = 1.0f;
            } else {
                f16 = 0.5f;
            }
            textView.setAlpha(f16);
        }

        @Override // h53.q
        public void A4(@Nullable String title) {
        }

        @Override // h53.k
        public void f8(boolean hasFocus) {
        }

        @Override // h53.k
        public void beforeTextChanged(@Nullable CharSequence r16, int start, int count, int after) {
        }

        @Override // h53.k
        public void onTextChanged(@Nullable CharSequence r16, int start, int before, int count) {
        }
    }

    public static final void Ni(DialogInterface dialogInterface, int i3) {
    }
}
