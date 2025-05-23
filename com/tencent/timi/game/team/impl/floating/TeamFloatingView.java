package com.tencent.timi.game.team.impl.floating;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.timi.game.app.event.TGDialogHelpCloseEvent;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.ui.TGDialogHelperFragment;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import com.tencent.timi.game.utils.w;
import fm4.k;
import fm4.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import nr2.av;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomLeaveRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;
import uh4.c;
import uh4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0003TWZ\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0001 B'\b\u0007\u0012\u0006\u0010k\u001a\u00020j\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010l\u0012\b\b\u0002\u0010n\u001a\u00020\u0005\u00a2\u0006\u0004\bo\u0010pJ\u001c\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0010H\u0002J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u001bJ\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\b\u0010'\u001a\u00020\u0007H\u0016J\b\u0010(\u001a\u00020\u0007H\u0016J\u0006\u0010)\u001a\u00020\u0007R\"\u0010/\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00105\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00109\u001a\u00020\u00168\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\"\u00106\u001a\u0004\b7\u00108R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u00106\u001a\u0004\b;\u00108\"\u0004\b<\u0010=R\"\u0010D\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0017\u0010G\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\bE\u0010?\u001a\u0004\bF\u0010AR\u0014\u0010H\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010?R\u0017\u0010J\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010?\u001a\u0004\bI\u0010AR\u0014\u0010L\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010NR\u0016\u0010P\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00100R\u0014\u0010S\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010RR\u0016\u0010V\u001a\u00020T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010UR\u0016\u0010Y\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010XR\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\"\u0010e\u001a\u00020^8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010h\u00a8\u0006q"}, d2 = {"Lcom/tencent/timi/game/team/impl/floating/TeamFloatingView;", "Landroid/widget/FrameLayout;", "Luh4/d;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "memberMicLevelList", "", BdhLogUtil.LogTag.Tag_Conn, "msg", "", "shake", HippyTKDListViewAdapter.X, "N", "D", "H", "Lcom/tencent/timi/game/tim/api/message/a;", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.LATITUDE_SOUTH, "E", BdhLogUtil.LogTag.Tag_Req, "", "roomId", UserInfo.SEX_FEMALE, "Lcom/tencent/timi/game/team/impl/floating/WaveAvatarRoundView;", "y", "Lcom/tencent/timi/game/team/impl/floating/TeamFloatingStateView;", "B", "Landroid/view/View;", "getView", "Luh4/b;", "a", "Luh4/c;", "f", "onShow", "onHide", "b", "e", "onBackground", "d", "w", "Ljava/lang/String;", "getCurrentRemindStatus", "()Ljava/lang/String;", "setCurrentRemindStatus", "(Ljava/lang/String;)V", "currentRemindStatus", "Z", "getDialogShowing", "()Z", "setDialogShowing", "(Z)V", "dialogShowing", "J", "getToastDuration", "()J", "toastDuration", tl.h.F, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setRoomId", "(J)V", "i", "I", "getMVoiceIndex", "()I", "setMVoiceIndex", "(I)V", "mVoiceIndex", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getGamingColor", "gamingColor", "teamingColor", "getReadyColor", "readyColor", "Luh4/b;", "floatingAnimateInfo", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "selfUserId", "forgroundStatus", "Lnr2/av;", "Lnr2/av;", "binding", "com/tencent/timi/game/team/impl/floating/TeamFloatingView$remindingStatusRestor$1", "Lcom/tencent/timi/game/team/impl/floating/TeamFloatingView$remindingStatusRestor$1;", "remindingStatusRestor", "com/tencent/timi/game/team/impl/floating/TeamFloatingView$backgroundHeartBeat$1", "Lcom/tencent/timi/game/team/impl/floating/TeamFloatingView$backgroundHeartBeat$1;", "backgroundHeartBeat", "com/tencent/timi/game/team/impl/floating/TeamFloatingView$d", "K", "Lcom/tencent/timi/game/team/impl/floating/TeamFloatingView$d;", "msgListener", "Lfm4/k;", "L", "Lfm4/k;", "getCommonListener", "()Lfm4/k;", "setCommonListener", "(Lfm4/k;)V", "commonListener", "Lfm4/p;", "M", "Lfm4/p;", "mMicDataListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TeamFloatingView extends FrameLayout implements uh4.d {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static boolean P;
    private static boolean Q;

    /* renamed from: C, reason: from kotlin metadata */
    private final int teamingColor;

    /* renamed from: D, reason: from kotlin metadata */
    private final int readyColor;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final uh4.b floatingAnimateInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private CommonOuterClass$QQUserId selfUserId;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean forgroundStatus;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final av binding;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private TeamFloatingView$remindingStatusRestor$1 remindingStatusRestor;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private TeamFloatingView$backgroundHeartBeat$1 backgroundHeartBeat;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final d msgListener;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private k commonListener;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private p mMicDataListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String currentRemindStatus;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean dialogShowing;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long toastDuration;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mVoiceIndex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int gamingColor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/timi/game/team/impl/floating/TeamFloatingView$a;", "", "", "teamPageShowing", "Z", "a", "()Z", "d", "(Z)V", "isRemindingStatus", "b", "c", "", "HONER_PAG_URL", "Ljava/lang/String;", "STATE_AT", "STATE_IN_GAME", "STATE_IN_TEAM", "STATE_REMIND", "TAG", "WAVE_PAG_URL", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.team.impl.floating.TeamFloatingView$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return TeamFloatingView.P;
        }

        public final boolean b() {
            return TeamFloatingView.Q;
        }

        public final void c(boolean z16) {
            TeamFloatingView.Q = z16;
        }

        public final void d(boolean z16) {
            TeamFloatingView.P = z16;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/timi/game/team/impl/floating/TeamFloatingView$b", "Lfm4/k;", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "speakingPosInfoList", "", "o", "", "isRemindOwner", "c", "isStatusChanged", "", "gameStatus", "Ltrpc/yes/common/YoloRoomOuterClass$YoloGameRouteInfo;", "gameRouteInfo", ReportConstant.COSTREPORT_PREFIX, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends k {
        b() {
        }

        @Override // fm4.k, fm4.q
        public void c(boolean isRemindOwner) {
            super.c(isRemindOwner);
            TeamFloatingView.this.x("\u6c42\u53d1\u8f66", true);
        }

        @Override // fm4.k, fm4.q
        public void o(@Nullable List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> speakingPosInfoList) {
            super.o(speakingPosInfoList);
            TeamFloatingView.this.N();
        }

        @Override // fm4.k, fm4.q
        public void s(boolean isStatusChanged, int gameStatus, @Nullable YoloRoomOuterClass$YoloGameRouteInfo gameRouteInfo) {
            super.s(isStatusChanged, gameStatus, gameRouteInfo);
            TeamFloatingView.this.N();
            TeamFloatingView.this.w();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0016\u0010\u0013\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/timi/game/team/impl/floating/TeamFloatingView$d", "Lcom/tencent/timi/game/tim/api/message/b;", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "", "e", tl.h.F, "d", "b", "", "code", "", "desc", "f", "c", "msgId", "a", "", "historyMessages", "g", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements com.tencent.timi.game.tim.api.message.b {
        d() {
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void a(@NotNull String msgId) {
            Intrinsics.checkNotNullParameter(msgId, "msgId");
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void b(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void c(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (!TeamFloatingView.INSTANCE.a() && TeamFloatingView.this.G(msg2)) {
                TeamFloatingView.this.x("@\u6211", true);
            }
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void d(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void e(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void f(@NotNull com.tencent.timi.game.tim.api.message.a msg2, int code, @Nullable String desc) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void g(@NotNull List<? extends com.tencent.timi.game.tim.api.message.a> historyMessages) {
            Intrinsics.checkNotNullParameter(historyMessages, "historyMessages");
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void h(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TeamFloatingView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(ConcurrentHashMap<String, Integer> memberMicLevelList) {
        boolean z16;
        gm4.c K0;
        List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> n3;
        String str;
        boolean z17;
        PBInt32Field pBInt32Field;
        CommonOuterClass$QQUserId commonOuterClass$QQUserId;
        PBUInt64Field pBUInt64Field;
        if (memberMicLevelList.size() <= 0) {
            return;
        }
        for (Map.Entry<String, Integer> entry : memberMicLevelList.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().intValue() >= 10) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.mVoiceIndex % 5 == 0) {
                if (this.binding.f420921i == null) {
                    return;
                }
                if (z16 && (K0 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId)) != null && (n3 = K0.n()) != null) {
                    for (YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo : n3) {
                        if (yoloRoomOuterClass$YoloRoomSpeakingPosInfo != null && (commonOuterClass$QQUserId = yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id) != null && (pBUInt64Field = commonOuterClass$QQUserId.yes_uid) != null) {
                            str = Long.valueOf(pBUInt64Field.get()).toString();
                        } else {
                            str = null;
                        }
                        if (TextUtils.equals(str, key)) {
                            if (yoloRoomOuterClass$YoloRoomSpeakingPosInfo != null && (pBInt32Field = yoloRoomOuterClass$YoloRoomSpeakingPosInfo.voice_switch) != null && pBInt32Field.get() == 1) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (!z17) {
                                z16 = false;
                            }
                        }
                    }
                }
                if (z16) {
                    this.binding.f420921i.p();
                } else {
                    this.binding.f420921i.s();
                }
            }
            this.mVoiceIndex++;
        }
    }

    private final void D() {
        int i3;
        S();
        if (!this.dialogShowing) {
            ConcurrentHashMap<String, String> z16 = z();
            if (Intrinsics.areEqual(this.currentRemindStatus, "\u6e38\u620f\u4e2d")) {
                i3 = 3;
            } else if (Intrinsics.areEqual(this.currentRemindStatus, "@\u6211")) {
                i3 = 2;
            } else if (!Intrinsics.areEqual(this.currentRemindStatus, "\u7ec4\u961f\u4e2d") && Intrinsics.areEqual(this.currentRemindStatus, "\u6c42\u53d1\u8f66")) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            boolean z17 = Q;
            z16.put("yes_floating_status", String.valueOf(i3));
            z16.put("yes_is_redpoint", String.valueOf(z17 ? 1 : 0));
            Q = false;
            this.currentRemindStatus = "";
            ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            bVar.reportEvent("clck", this, z16);
            if (QBaseActivity.mAppForground) {
                ((sm4.a) mm4.b.b(sm4.a.class)).q0(BaseApplication.getContext(), ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId).getRoomInfo(), 4);
            } else {
                ((sm4.a) mm4.b.b(sm4.a.class)).q0(BaseApplication.getContext(), ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId).getRoomInfo(), 5);
            }
            N();
        }
    }

    private final void E() {
        this.binding.f420915c.setVisibility(8);
        uh4.a.INSTANCE.a().i(String.valueOf(this.roomId), com.tencent.timi.game.utils.b.a(1), com.tencent.timi.game.utils.b.a(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean G(com.tencent.timi.game.tim.api.message.a msg2) {
        if (msg2.a().at_user_msg.user_list.size() > 0 && SpecialMsgUtil.f376345a.c(msg2, this.selfUserId)) {
            return true;
        }
        return false;
    }

    private final void H() {
        if (this.dialogShowing || o.c("TEAM_FLOAT_BALL")) {
            return;
        }
        ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
        ImageView imageView = this.binding.f420914b;
        Intrinsics.checkNotNull(imageView, "null cannot be cast to non-null type java.lang.Object");
        bVar.reportEvent("clck", imageView, z());
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        QPublicFragmentActivity.b.b(BaseApplication.getContext(), intent, QPublicTransFragmentActivity.class, TGDialogHelperFragment.class);
        w.d(new Runnable() { // from class: com.tencent.timi.game.team.impl.floating.d
            @Override // java.lang.Runnable
            public final void run() {
                TeamFloatingView.I(TeamFloatingView.this);
            }
        }, 550L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.tencent.mobileqq.app.QBaseActivity] */
    public static final void I(final TeamFloatingView this$0) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? b16 = vf4.a.b();
        objectRef.element = b16;
        if (b16 != 0) {
            if (((sm4.a) mm4.b.b(sm4.a.class)).n1()) {
                if (((sm4.a) mm4.b.b(sm4.a.class)).a2(this$0.roomId)) {
                    str = "\u786e\u5b9a\u8981\u79bb\u5f00\u8f66\u961f\u5417\uff1f\u79bb\u5f00\u540e\u5c06\u89e3\u6563\u8f66\u961f\uff0c\u4e0a\u8f66\u7528\u6237\u9884\u4ed8\u7684\u91d1\u5e01\u5c06\u9000\u8fd8";
                } else {
                    str = "\u786e\u8ba4\u8981\u4e0b\u8f66\u5417\uff1f\u4e0b\u8f66\u540e\u9884\u4ed8\u7684\u91d1\u5e01\u5c06\u4f1a\u9000\u56de\u5e10\u6237";
                }
            } else if (((sm4.a) mm4.b.b(sm4.a.class)).y3() && ((sm4.a) mm4.b.b(sm4.a.class)).a2(this$0.roomId)) {
                str = "\u9000\u51fa\u540e\u8f66\u961f\u81ea\u52a8\u89e3\u6563\uff0c\u5e76\u5173\u95ed\u6e38\u620f\u7ec4\u961f\u529f\u80fd\uff0c\u65e0\u6cd5\u5e26\u7c89\u4e0a\u8f66";
            } else {
                str = "\u786e\u5b9a\u79bb\u5f00\u8f66\u961f\u5417\uff1f";
            }
            T activity = objectRef.element;
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            com.tencent.timi.game.ui.widget.e c16 = new e.a((Context) activity).j(str).k(17).o(new DialogInterface.OnClickListener() { // from class: com.tencent.timi.game.team.impl.floating.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    TeamFloatingView.L(TeamFloatingView.this, objectRef, dialogInterface, i3);
                }
            }).n("\u53d6\u6d88").m(new DialogInterface.OnClickListener() { // from class: com.tencent.timi.game.team.impl.floating.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    TeamFloatingView.M(dialogInterface, i3);
                }
            }).c();
            ((ug4.b) mm4.b.b(ug4.b.class)).G2(c16, "pg_yes_smoba_team");
            c16.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.timi.game.team.impl.floating.g
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    TeamFloatingView.J(TeamFloatingView.this, dialogInterface);
                }
            });
            c16.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.timi.game.team.impl.floating.h
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    TeamFloatingView.K(TeamFloatingView.this, dialogInterface);
                }
            });
            c16.show();
            return;
        }
        l.e("Timi_Float", "close team when activity is null");
        this$0.E();
        com.tencent.timi.game.team.impl.main.f.c(this$0.roomId, (Activity) objectRef.element, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(TeamFloatingView this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dialogShowing = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(TeamFloatingView this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dialogShowing = false;
        SimpleEventBus.getInstance().dispatchEvent(new TGDialogHelpCloseEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void L(TeamFloatingView this$0, Ref.ObjectRef activity, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        this$0.setVisibility(4);
        com.tencent.timi.game.team.impl.main.f.c(this$0.roomId, (Activity) activity.element, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N() {
        int i3;
        int i16;
        List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> n3;
        boolean z16;
        List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> n16;
        boolean z17;
        List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> n17;
        int M = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId).M();
        int o16 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId).o1();
        gm4.c K0 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId);
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = null;
        if (K0 != null && (n17 = K0.n()) != null) {
            for (YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo : n17) {
                if (ll4.b.a(((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId).R(), yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id)) {
                    commonOuterClass$QQUserId = yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id;
                }
                if (ll4.b.a(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id, ((ll4.a) mm4.b.b(ll4.a.class)).E())) {
                    this.selfUserId = yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id;
                }
            }
        }
        this.binding.f420921i.r(commonOuterClass$QQUserId);
        this.binding.f420920h.setGameId(o16);
        if (3 == M) {
            Q = false;
            this.currentRemindStatus = "";
            this.binding.f420917e.setVisibility(8);
            if (!this.binding.f420920h.h().equals("\u6e38\u620f\u4e2d")) {
                this.binding.f420920h.setTeamStateWithAnim("\u6e38\u620f\u4e2d");
            }
            this.binding.f420920h.setRedPointVisible(4);
            this.binding.f420920h.w();
            this.binding.f420921i.setTeamCountVisible(8);
            this.binding.f420916d.setImageResource(R.drawable.o7f);
        } else {
            if (!Q) {
                if (!this.binding.f420920h.h().equals("\u7ec4\u961f\u4e2d")) {
                    this.binding.f420920h.setTeamStateWithAnim("\u7ec4\u961f\u4e2d");
                }
                this.binding.f420920h.setRedPointVisible(4);
                this.binding.f420920h.w();
                this.binding.f420917e.setVisibility(4);
            }
            gm4.c K02 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId);
            if (K02 != null && (n16 = K02.n()) != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : n16) {
                    YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo2 = (YoloRoomOuterClass$YoloRoomSpeakingPosInfo) obj;
                    if (yoloRoomOuterClass$YoloRoomSpeakingPosInfo2.status.get() != 2 && yoloRoomOuterClass$YoloRoomSpeakingPosInfo2.status.get() != 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        arrayList.add(obj);
                    }
                }
                i3 = arrayList.size();
            } else {
                i3 = 1;
            }
            gm4.c K03 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId);
            if (K03 != null && (n3 = K03.n()) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : n3) {
                    if (((YoloRoomOuterClass$YoloRoomSpeakingPosInfo) obj2).user_id.yes_uid.get() != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList2.add(obj2);
                    }
                }
                i16 = arrayList2.size();
            } else {
                i16 = 1;
            }
            SpannableString spannableString = new SpannableString(i16 + "/" + i3);
            spannableString.setSpan(new ForegroundColorSpan(this.teamingColor), 0, 1, 33);
            this.binding.f420921i.setTeamCountVisible(0);
            this.binding.f420921i.setTeamCountText(spannableString);
            this.binding.f420916d.setImageResource(R.drawable.o7g);
        }
        this.binding.f420921i.setAvatarClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.team.impl.floating.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeamFloatingView.O(TeamFloatingView.this, view);
            }
        });
        this.binding.f420915c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.team.impl.floating.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeamFloatingView.P(TeamFloatingView.this, view);
            }
        });
        this.binding.f420914b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.team.impl.floating.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeamFloatingView.Q(TeamFloatingView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(TeamFloatingView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(TeamFloatingView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(TeamFloatingView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void R() {
        this.binding.f420915c.setVisibility(0);
        uh4.a.INSTANCE.a().i(String.valueOf(this.roomId), com.tencent.timi.game.utils.b.a(78), com.tencent.timi.game.utils.b.a(91));
    }

    private final void S() {
        uh4.b bVar = this.floatingAnimateInfo;
        Intrinsics.checkNotNullExpressionValue(this.binding.f420921i, "binding.waveAvatar");
        bVar.g(fh4.g.h(r1) + (this.binding.f420921i.getWidth() * 0.5f));
        uh4.b bVar2 = this.floatingAnimateInfo;
        Intrinsics.checkNotNullExpressionValue(this.binding.f420921i, "binding.waveAvatar");
        bVar2.h(fh4.g.j(r1) + (this.binding.f420921i.getHeight() * 0.5f));
        this.floatingAnimateInfo.j(com.tencent.timi.game.utils.b.c(46));
        this.floatingAnimateInfo.i(uh4.b.INSTANCE.b().getPreDrawBitmap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(String msg2, boolean shake) {
        if (!P) {
            Q = true;
            this.binding.f420920h.setTeamStateWithAnim(msg2);
            this.binding.f420920h.setRedPointVisible(0);
            this.binding.f420920h.s();
            this.binding.f420917e.setVisibility(0);
            if (shake && !TextUtils.equals(this.currentRemindStatus, msg2)) {
                this.currentRemindStatus = msg2;
                this.binding.f420921i.o();
            }
            N();
            removeCallbacks(this.remindingStatusRestor);
            postDelayed(this.remindingStatusRestor, 3000L);
        }
    }

    private final ConcurrentHashMap<String, String> z() {
        ConcurrentHashMap<String, String> map = com.tencent.timi.game.team.impl.main.f.d(this.roomId);
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("pgid", "pg_yes_smoba_team");
        return map;
    }

    /* renamed from: A, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    @NotNull
    public final TeamFloatingStateView B() {
        TeamFloatingStateView teamFloatingStateView = this.binding.f420920h;
        Intrinsics.checkNotNullExpressionValue(teamFloatingStateView, "binding.stateView");
        return teamFloatingStateView;
    }

    @NotNull
    public uh4.d F(long roomId) {
        this.roomId = roomId;
        ((fm4.g) mm4.b.b(fm4.g.class)).k(roomId).l(this.mMicDataListener);
        return this;
    }

    @Override // uh4.d
    @NotNull
    /* renamed from: a, reason: from getter */
    public uh4.b getFloatingAnimateInfo() {
        return this.floatingAnimateInfo;
    }

    @Override // uh4.d
    public void b() {
        ConcurrentHashMap<String, String> z16 = z();
        ViewParent parent = getParent();
        if (parent != null) {
            ((ug4.b) mm4.b.b(ug4.b.class)).G2(parent, "pg_yes_smoba_team");
            ((ug4.b) mm4.b.b(ug4.b.class)).a(this, false, "", "em_yes_smoba_team_floating", z16);
            ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
            ImageView imageView = this.binding.f420914b;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.closeIv");
            bVar.a(imageView, false, "", "em_yes_smoba_team_floating_close", z16);
        }
        ((fm4.g) mm4.b.b(fm4.g.class)).k(this.roomId).y(this.commonListener);
        ((kn4.b) mm4.b.b(kn4.b.class)).M(this.roomId).b(this.msgListener);
        N();
    }

    @Override // uh4.d
    public void d() {
        this.binding.f420915c.setVisibility(0);
        this.binding.f420918f.setVisibility(8);
        uh4.a.INSTANCE.a().i(String.valueOf(this.roomId), com.tencent.timi.game.utils.b.a(78), com.tencent.timi.game.utils.b.a(91));
        this.forgroundStatus = true;
    }

    @Override // uh4.d
    public void e() {
        uh4.b.INSTANCE.b().i(null);
        ((fm4.g) mm4.b.b(fm4.g.class)).k(this.roomId).Q(this.commonListener);
        ((kn4.b) mm4.b.b(kn4.b.class)).M(this.roomId);
        ((fm4.g) mm4.b.b(fm4.g.class)).k(this.roomId).V(this.mMicDataListener);
        removeCallbacks(this.remindingStatusRestor);
        removeCallbacks(this.backgroundHeartBeat);
    }

    @Override // uh4.d
    @NotNull
    public uh4.c f() {
        return new c.a().e(com.tencent.timi.game.utils.b.a(78), com.tencent.timi.game.utils.b.a(91)).a();
    }

    @Override // uh4.d
    public void onBackground() {
        this.binding.f420918f.setVisibility(8);
        if (((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId).M() == 3) {
            E();
        } else {
            R();
        }
        this.forgroundStatus = false;
    }

    @Override // uh4.d
    public void onHide() {
        ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        bVar.reportEvent("imp_end", this, z());
        S();
        removeCallbacks(this.remindingStatusRestor);
        removeCallbacks(this.backgroundHeartBeat);
    }

    @Override // uh4.d
    public void onShow() {
        ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        bVar.reportEvent("imp", this, z());
        N();
        this.binding.f420920h.e();
        this.binding.f420921i.d();
        removeCallbacks(this.backgroundHeartBeat);
        postDelayed(this.backgroundHeartBeat, 3000L);
        if (!QBaseActivity.mAppForground) {
            onBackground();
        }
    }

    public final void setCommonListener(@NotNull k kVar) {
        Intrinsics.checkNotNullParameter(kVar, "<set-?>");
        this.commonListener = kVar;
    }

    public final void setCurrentRemindStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentRemindStatus = str;
    }

    public final void setDialogShowing(boolean z16) {
        this.dialogShowing = z16;
    }

    @Override // uh4.d
    public void setLaunchParam(@Nullable Object obj) {
        d.a.b(this, obj);
    }

    public final void setMVoiceIndex(int i3) {
        this.mVoiceIndex = i3;
    }

    public final void setRoomId(long j3) {
        this.roomId = j3;
    }

    public final void w() {
        if (!this.forgroundStatus) {
            if (((fm4.g) mm4.b.b(fm4.g.class)).K0(this.roomId).M() == 3) {
                uh4.a.INSTANCE.a().i(String.valueOf(this.roomId), com.tencent.timi.game.utils.b.a(1), com.tencent.timi.game.utils.b.a(1));
                this.binding.f420915c.setVisibility(8);
                return;
            } else {
                R();
                return;
            }
        }
        this.binding.f420915c.setVisibility(0);
        this.binding.f420918f.setVisibility(8);
        uh4.a.INSTANCE.a().i(String.valueOf(this.roomId), com.tencent.timi.game.utils.b.a(78), com.tencent.timi.game.utils.b.a(91));
    }

    @NotNull
    public final WaveAvatarRoundView y() {
        WaveAvatarRoundView waveAvatarRoundView = this.binding.f420921i;
        Intrinsics.checkNotNullExpressionValue(waveAvatarRoundView, "binding.waveAvatar");
        return waveAvatarRoundView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TeamFloatingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TeamFloatingView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.tencent.timi.game.team.impl.floating.TeamFloatingView$remindingStatusRestor$1] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.tencent.timi.game.team.impl.floating.TeamFloatingView$backgroundHeartBeat$1] */
    @JvmOverloads
    public TeamFloatingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.currentRemindStatus = "";
        this.toastDuration = 3000L;
        this.gamingColor = Color.parseColor("#00CC8F");
        this.teamingColor = Color.parseColor(TipsElementData.DEFAULT_COLOR);
        this.readyColor = Color.parseColor("#F5B534");
        this.floatingAnimateInfo = new uh4.b();
        this.forgroundStatus = true;
        av g16 = av.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        this.remindingStatusRestor = new Runnable() { // from class: com.tencent.timi.game.team.impl.floating.TeamFloatingView$remindingStatusRestor$1
            @Override // java.lang.Runnable
            public void run() {
                if (TeamFloatingView.INSTANCE.b()) {
                    if (3 == ((fm4.g) mm4.b.b(fm4.g.class)).K0(TeamFloatingView.this.getRoomId()).M()) {
                        TeamFloatingView.this.x("\u6e38\u620f\u4e2d", false);
                    } else {
                        TeamFloatingView.this.x("\u7ec4\u961f\u4e2d", false);
                    }
                }
                TeamFloatingView.this.removeCallbacks(this);
            }
        };
        this.backgroundHeartBeat = new Runnable() { // from class: com.tencent.timi.game.team.impl.floating.TeamFloatingView$backgroundHeartBeat$1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                boolean z17;
                GuardManager guardManager = GuardManager.sInstance;
                if (guardManager != null) {
                    if (guardManager.isApplicationForeground() || QBaseActivity.mAppForground) {
                        z16 = TeamFloatingView.this.forgroundStatus;
                        if (!z16) {
                            l.e("Timi_Float", "onForground by HeartBeat!!!");
                            TeamFloatingView.this.d();
                        }
                    } else {
                        z17 = TeamFloatingView.this.forgroundStatus;
                        if (z17) {
                            l.e("Timi_Float", "onBackground by HeartBeat!!!");
                            TeamFloatingView.this.onBackground();
                        }
                    }
                    TeamFloatingView.this.removeCallbacks(this);
                }
                TeamFloatingView.this.postDelayed(this, 3000L);
            }
        };
        this.msgListener = new d();
        this.commonListener = new b();
        this.mMicDataListener = new c();
    }

    @Override // uh4.d
    @NotNull
    public View getView() {
        return this;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/team/impl/floating/TeamFloatingView$c", "Lfm4/p;", "Lsn4/a;", "roomState", "", tl.h.F, "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "memberMicLevelList", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements p {
        c() {
        }

        @Override // fm4.p
        public void a(@NotNull ConcurrentHashMap<String, Integer> memberMicLevelList) {
            Intrinsics.checkNotNullParameter(memberMicLevelList, "memberMicLevelList");
            TeamFloatingView.this.C(memberMicLevelList);
        }

        @Override // fm4.p
        public void h(@Nullable sn4.a roomState) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/team/impl/floating/TeamFloatingView$e", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomLeaveRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements IResultListener<YoloRoomOuterClass$YoloRoomLeaveRsp> {
        e() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomLeaveRsp result) {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/team/impl/floating/TeamFloatingView$f", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomLeaveRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements IResultListener<YoloRoomOuterClass$YoloRoomLeaveRsp> {
        f() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            TeamFloatingView.this.setVisibility(0);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomLeaveRsp result) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(DialogInterface dialogInterface, int i3) {
    }
}
