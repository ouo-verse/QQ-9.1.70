package com.tencent.timi.game.liveroom.impl.room.playtogether.presenter;

import ag4.i;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.liveroom.impl.room.inscription.net.GetAnchorRoomInfoRequest;
import com.tencent.timi.game.liveroom.impl.room.playtogether.AnchorPlayTogetherDialog;
import com.tencent.timi.game.liveroom.impl.room.playtogether.t;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import hk4.a;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp;
import trpc.yes.common.PremadesTeamServerOuterClass$NewPlayTogetherInfo;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleInfo;
import trpc.yes.common.YoloRoomOuterClass$QQLiveRoomConfig;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloGameDataInfo;
import trpc.yes.common.YoloTeamOuterClass$YoloLiveTeamInfo;
import trpc.yes.common.YoloTeamOuterClass$YoloTeamEnterConditionRsp;
import ug4.a;

@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 k2\u00020\u0001:\u0002EIB1\u0012\u0010\u0010G\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010D\u0018\u00010C\u0012\u0006\u0010J\u001a\u00020H\u0012\u0006\u0010L\u001a\u00020H\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\bi\u0010jJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u001a\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0013J\u0006\u0010\u001f\u001a\u00020\u0013J\u0006\u0010 \u001a\u00020\u0013J\u0017\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010$J\u0016\u0010(\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u0013J\u000e\u0010)\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0015J\u000e\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0015J\u0006\u0010,\u001a\u00020\u0015J\u0006\u0010-\u001a\u00020\u0015J\u0006\u0010.\u001a\u00020\u0006J\u0006\u0010/\u001a\u00020\u0006J\u0006\u00100\u001a\u00020\u0006J \u00105\u001a\u00020\u00062\u0006\u00102\u001a\u0002012\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u000103J\u0018\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002080706J\f\u0010;\u001a\b\u0012\u0004\u0012\u00020:06J\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001306J\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001306J\u000e\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u000201J\u0016\u0010B\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u00132\u0006\u0010A\u001a\u00020\u0013R\u001e\u0010G\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010D\u0018\u00010C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010J\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010BR\u0014\u0010L\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010BR\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010%R\u0016\u0010O\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010%R\u0018\u0010R\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010U\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR&\u0010Y\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000208070V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020:0V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010XR\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00130V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010XR\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00130V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010XR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010bR\u0016\u0010c\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010%R\u0016\u0010d\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010%R\u001c\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010f0e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010g\u00a8\u0006l"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/AnchorPlayTogetherPresenter;", "", "Ltrpc/yes/common/YoloTeamOuterClass$YoloLiveTeamInfo;", "teamInfo", "Ltrpc/yes/common/PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp;", "anchorRoomInfo", "", "p", "B", BdhLogUtil.LogTag.Tag_Conn, "Lhk4/a$b;", DomainData.DOMAIN_NAME, "Ljg4/b;", "roomService", "Ltrpc/yes/common/YoloRoomOuterClass$QQLiveRoomConfig;", "o", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleInfo;", "role", "M", "", "D", "", VirtualAppProxy.KEY_GAME_ID, "Ltrpc/yes/common/YoloTeamOuterClass$YoloTeamEnterConditionRsp;", "result", "H", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/t;", "dialog", "K", BdhLogUtil.LogTag.Tag_Req, "E", UserInfo.SEX_FEMALE, "G", "flag", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Ljava/lang/Integer;)V", "Lcom/tencent/timi/game/liveroom/impl/room/inscription/net/GetAnchorRoomInfoRequest$a;", "I", "condition", "justUpdateUI", "O", "N", "mode", "P", HippyTKDListViewAdapter.X, "u", "l", "L", "v", "Landroid/content/Context;", "ctx", "Lkotlin/Function0;", "cb", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "Lkotlin/Pair;", "", "r", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/AnchorPlayTogetherPresenter$a;", ReportConstant.COSTREPORT_PREFIX, "t", "w", "context", "y", "actionToast", "actionLaunchGame", "J", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "a", "Lmqq/util/WeakReference;", "activityRef", "", "b", "roomId", "c", "anchorUid", "d", "e", "yesGameId", "f", "Ltrpc/yes/common/YoloTeamOuterClass$YoloLiveTeamInfo;", "mTeamInfo", "g", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleInfo;", "defaultRole", "Landroidx/lifecycle/MutableLiveData;", h.F, "Landroidx/lifecycle/MutableLiveData;", "accountInfoLiveData", "i", "Ltrpc/yes/common/PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp;", "mAnchorRoomInfo", "j", "actionBtnLiveData", "k", "anchorEntranceLiveData", "isTeamAvailableLiveData", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/t;", "mCurCondition", "mMode", "Landroidx/lifecycle/Observer;", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "Landroidx/lifecycle/Observer;", "defaultRoleObserver", "<init>", "(Lmqq/util/WeakReference;JJI)V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class AnchorPlayTogetherPresenter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final WeakReference<Activity> activityRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long anchorUid;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int gameId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private YoloTeamOuterClass$YoloLiveTeamInfo mTeamInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private YesGameInfoOuterClass$YesGameRoleInfo defaultRole;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp mAnchorRoomInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> anchorEntranceLiveData;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isTeamAvailableLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t dialog;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int mCurCondition;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int mMode;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> defaultRoleObserver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int yesGameId = 101;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<String, String>> accountInfoLiveData = new MutableLiveData<>();

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<a> actionBtnLiveData = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0003BA\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\r\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\b\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/AnchorPlayTogetherPresenter$a;", "", "", "a", "I", "f", "()I", "textColor", "b", "setBgDrawable", "(I)V", "bgDrawable", "", "c", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "text", "", "d", "Z", "()Z", "enable", "mode", "Lkotlin/Function0;", "", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "clickListener", "<init>", "(IILjava/lang/String;ZILkotlin/jvm/functions/Function0;)V", "g", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int textColor;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int bgDrawable;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String text;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean enable;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int mode;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function0<Unit> clickListener;

        public a(@ColorInt int i3, @DrawableRes int i16, @NotNull String text, boolean z16, int i17, @NotNull Function0<Unit> clickListener) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(clickListener, "clickListener");
            this.textColor = i3;
            this.bgDrawable = i16;
            this.text = text;
            this.enable = z16;
            this.mode = i17;
            this.clickListener = clickListener;
        }

        /* renamed from: a, reason: from getter */
        public final int getBgDrawable() {
            return this.bgDrawable;
        }

        @NotNull
        public final Function0<Unit> b() {
            return this.clickListener;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getEnable() {
            return this.enable;
        }

        /* renamed from: d, reason: from getter */
        public final int getMode() {
            return this.mode;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: f, reason: from getter */
        public final int getTextColor() {
            return this.textColor;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/playtogether/presenter/AnchorPlayTogetherPresenter$c", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloTeamOuterClass$YoloTeamEnterConditionRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements IResultListener<YoloTeamOuterClass$YoloTeamEnterConditionRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f378300a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f378301b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AnchorPlayTogetherPresenter f378302c;

        c(boolean z16, boolean z17, AnchorPlayTogetherPresenter anchorPlayTogetherPresenter) {
            this.f378300a = z16;
            this.f378301b = z17;
            this.f378302c = anchorPlayTogetherPresenter;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloTeamOuterClass$YoloTeamEnterConditionRsp result) {
            YoloTeamOuterClass$YoloLiveTeamInfo yoloTeamOuterClass$YoloLiveTeamInfo;
            PBInt32Field pBInt32Field;
            String str;
            PBStringField pBStringField;
            if (this.f378300a) {
                com.tencent.timi.game.ui.widget.f.c("\u4fee\u6539\u6210\u529f");
            }
            if (this.f378301b && (yoloTeamOuterClass$YoloLiveTeamInfo = this.f378302c.mTeamInfo) != null && (pBInt32Field = yoloTeamOuterClass$YoloLiveTeamInfo.game_id) != null) {
                int i3 = pBInt32Field.get();
                AnchorPlayTogetherPresenter anchorPlayTogetherPresenter = this.f378302c;
                Activity activity = null;
                if (result != null && (pBStringField = result.schema) != null) {
                    str = pBStringField.get();
                } else {
                    str = null;
                }
                l.i("AnchorPlayTogetherPresenter", "gameId == " + i3 + " , schemne == " + str);
                WeakReference weakReference = anchorPlayTogetherPresenter.activityRef;
                if (weakReference != null) {
                    activity = (Activity) weakReference.get();
                }
                if (activity != null) {
                    anchorPlayTogetherPresenter.H(i3, result);
                }
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.ui.widget.f.c(errorMessage);
        }
    }

    public AnchorPlayTogetherPresenter(@Nullable WeakReference<Activity> weakReference, long j3, long j16, int i3) {
        this.activityRef = weakReference;
        this.roomId = j3;
        this.anchorUid = j16;
        this.gameId = i3;
        Boolean bool = Boolean.FALSE;
        this.anchorEntranceLiveData = new MutableLiveData<>(bool);
        this.isTeamAvailableLiveData = new MutableLiveData<>(bool);
        this.mCurCondition = 5;
        this.mMode = 3;
        this.defaultRoleObserver = new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AnchorPlayTogetherPresenter.q(AnchorPlayTogetherPresenter.this, (YesGameInfoOuterClass$GetUserGameDefaultRoleRsp) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(com.tencent.timi.game.ui.widget.e this_apply, AnchorPlayTogetherPresenter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ug4.a aVar = (ug4.a) mm4.b.b(ug4.a.class);
        View view2 = this_apply.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String();
        Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type java.lang.Object");
        aVar.reportEvent("clck", view2, new LinkedHashMap());
        this_apply.dismiss();
        this$0.N(5);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void B() {
        boolean z16;
        MutableLiveData<a> mutableLiveData = this.actionBtnLiveData;
        int parseColor = Color.parseColor("#FFFFFF");
        if (this.mCurCondition != 5) {
            z16 = true;
        } else {
            z16 = false;
        }
        mutableLiveData.postValue(new a(parseColor, R.drawable.lqe, "\u5f00\u59cb\u6e38\u620f", z16, 1, new Function0<Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.AnchorPlayTogetherPresenter$handleCreateMode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean D;
                t tVar;
                D = AnchorPlayTogetherPresenter.this.D();
                if (D) {
                    com.tencent.timi.game.ui.widget.f.d(true, "\u8bf7\u5148\u9009\u62e9\u89c2\u4f17\u4e0a\u8f66\u6761\u4ef6");
                    return;
                }
                AnchorPlayTogetherPresenter.this.J(false, true);
                tVar = AnchorPlayTogetherPresenter.this.dialog;
                if (tVar != null) {
                    tVar.dismissDialog();
                }
            }
        }));
        P(3);
        this.isTeamAvailableLiveData.postValue(Boolean.FALSE);
    }

    private final void C() {
        boolean z16;
        MutableLiveData<a> mutableLiveData = this.actionBtnLiveData;
        int parseColor = Color.parseColor("#FFFFFF");
        if (this.mCurCondition != 5) {
            z16 = true;
        } else {
            z16 = false;
        }
        mutableLiveData.postValue(new a(parseColor, R.drawable.lqe, "\u5f00\u59cb\u6e38\u620f", z16, 2, new Function0<Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.AnchorPlayTogetherPresenter$handleModifyMode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                t tVar;
                t tVar2;
                AnchorPlayTogetherPresenter.this.J(false, true);
                tVar = AnchorPlayTogetherPresenter.this.dialog;
                if (tVar != null) {
                    tVar.dismissDialog();
                }
                tVar2 = AnchorPlayTogetherPresenter.this.dialog;
                if (tVar2 != null) {
                    tVar2.r();
                }
            }
        }));
        this.isTeamAvailableLiveData.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean D() {
        if (this.mCurCondition == 5) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(int gameId, YoloTeamOuterClass$YoloTeamEnterConditionRsp result) {
        String str;
        PBStringField pBStringField;
        Activity activity = null;
        if (result != null && (pBStringField = result.schema) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        WeakReference<Activity> weakReference = this.activityRef;
        if (weakReference != null) {
            activity = weakReference.get();
        }
        hg4.d.q(gameId, str, activity);
        YoloTeamOuterClass$YoloLiveTeamInfo yoloTeamOuterClass$YoloLiveTeamInfo = this.mTeamInfo;
        if (yoloTeamOuterClass$YoloLiveTeamInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("yes_game_is_anchor", "1");
            hashMap.put("yes_launch_id", String.valueOf(yoloTeamOuterClass$YoloLiveTeamInfo.game_route_info.common_game_route_info.base_info.yolo_battle_id.get()));
            hashMap.put("yes_game_id", String.valueOf(yoloTeamOuterClass$YoloLiveTeamInfo.game_id.get()));
            hashMap.put("yes_team_id", String.valueOf(yoloTeamOuterClass$YoloLiveTeamInfo.team_id.get()));
            hashMap.put("yes_team_rank", YoloRoomUtil.z(yoloTeamOuterClass$YoloLiveTeamInfo.game_data_info.common_game_data_info.grade_list.get()));
            hashMap.putAll(tk4.d.f436481a.d());
            ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("ev_yes_game_launch_success", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(YesGameInfoOuterClass$YesGameRoleInfo role) {
        String str;
        boolean z16;
        PBStringField pBStringField;
        if (role != null && (pBStringField = role.role_name) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.accountInfoLiveData.postValue(TuplesKt.to("", ""));
        } else {
            if (role == null) {
                return;
            }
            this.accountInfoLiveData.postValue(TuplesKt.to(role.role_name.get(), com.tencent.timi.game.liveroom.impl.room.playtogether.util.h.m(role)));
        }
    }

    private final a.b n() {
        String str;
        String str2;
        a.b bVar = new a.b();
        bVar.f405218c = this.gameId;
        mm4.a b16 = mm4.b.b(jg4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ITgLiveRoomService::class.java)");
        jg4.b bVar2 = (jg4.b) b16;
        bVar.f405216a = o(bVar2);
        LiveUserInfo selfUserInfo = bVar2.getSelfUserInfo();
        Integer num = null;
        if (selfUserInfo != null) {
            str = selfUserInfo.headUrl;
        } else {
            str = null;
        }
        bVar.f405220e = str;
        LiveUserInfo selfUserInfo2 = bVar2.getSelfUserInfo();
        if (selfUserInfo2 != null) {
            str2 = selfUserInfo2.nick;
        } else {
            str2 = null;
        }
        bVar.f405219d = str2;
        LiveUserInfo selfUserInfo3 = bVar2.getSelfUserInfo();
        if (selfUserInfo3 != null) {
            num = Integer.valueOf(selfUserInfo3.sex);
        }
        Intrinsics.checkNotNull(num);
        bVar.f405221f = num.intValue();
        bVar.f405222g = this.mMode;
        return bVar;
    }

    private final YoloRoomOuterClass$QQLiveRoomConfig o(jg4.b roomService) {
        QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType;
        boolean z16;
        QQLiveAnchorRoomConfig roomConfig;
        YoloRoomOuterClass$QQLiveRoomConfig yoloRoomOuterClass$QQLiveRoomConfig = new YoloRoomOuterClass$QQLiveRoomConfig();
        yoloRoomOuterClass$QQLiveRoomConfig.qq_live_room_id.set(String.valueOf(this.roomId));
        yoloRoomOuterClass$QQLiveRoomConfig.qq_live_uid.set(this.anchorUid);
        yoloRoomOuterClass$QQLiveRoomConfig.qq_live_user_id.set(((ll4.a) mm4.b.b(ll4.a.class)).E());
        PBInt64Field pBInt64Field = yoloRoomOuterClass$QQLiveRoomConfig.live_uid;
        Long K = roomService.K();
        Intrinsics.checkNotNullExpressionValue(K, "roomService.selfUserId");
        pBInt64Field.set(K.longValue());
        yoloRoomOuterClass$QQLiveRoomConfig.anchor_id.set(String.valueOf(this.anchorUid));
        yoloRoomOuterClass$QQLiveRoomConfig.enter_condition.set(this.mCurCondition);
        yoloRoomOuterClass$QQLiveRoomConfig.trtc_room_id.set(String.valueOf(this.roomId));
        IQQLiveAnchorRoom J3 = roomService.J3(0L);
        if (J3 != null && (roomConfig = J3.getRoomConfig()) != null) {
            qQLiveAnchorStreamRecordType = roomConfig.streamRecordType;
        } else {
            qQLiveAnchorStreamRecordType = null;
        }
        if (qQLiveAnchorStreamRecordType == QQLiveAnchorStreamRecordType.SCREEN) {
            z16 = true;
        } else {
            z16 = false;
        }
        yoloRoomOuterClass$QQLiveRoomConfig.is_screen_capture.set(z16);
        yoloRoomOuterClass$QQLiveRoomConfig.is_live_event_room.set(G());
        return yoloRoomOuterClass$QQLiveRoomConfig;
    }

    private final void p(YoloTeamOuterClass$YoloLiveTeamInfo teamInfo, PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp anchorRoomInfo) {
        this.mTeamInfo = teamInfo;
        this.mAnchorRoomInfo = anchorRoomInfo;
        this.yesGameId = anchorRoomInfo.yes_game_id.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(AnchorPlayTogetherPresenter this$0, YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp) {
        YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo2 = null;
        if (yesGameInfoOuterClass$GetUserGameDefaultRoleRsp != null) {
            yesGameInfoOuterClass$YesGameRoleInfo = yesGameInfoOuterClass$GetUserGameDefaultRoleRsp.role_info;
        } else {
            yesGameInfoOuterClass$YesGameRoleInfo = null;
        }
        this$0.defaultRole = yesGameInfoOuterClass$YesGameRoleInfo;
        if (yesGameInfoOuterClass$GetUserGameDefaultRoleRsp != null) {
            yesGameInfoOuterClass$YesGameRoleInfo2 = yesGameInfoOuterClass$GetUserGameDefaultRoleRsp.role_info;
        }
        this$0.M(yesGameInfoOuterClass$YesGameRoleInfo2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(com.tencent.timi.game.ui.widget.e this_apply, DialogInterface dialogInterface) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        ((ug4.a) mm4.b.b(ug4.a.class)).b(this_apply, IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID, tk4.d.f436481a.d());
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        View view = this_apply.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("qqlive_play_teamstatus", "1"), TuplesKt.to("zengzhi_moduleid", "em_qqlive_palysetting"));
        a.C11346a.b((ug4.a) b16, view, false, null, "em_qqlive_play_closesecond", mutableMapOf, 6, null);
    }

    public final boolean E() {
        Integer num;
        YoloTeamOuterClass$YoloLiveTeamInfo yoloTeamOuterClass$YoloLiveTeamInfo;
        PBInt32Field pBInt32Field;
        PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp premadesTeamServerOuterClass$GetAnchorRoomInfoRsp = this.mAnchorRoomInfo;
        if (premadesTeamServerOuterClass$GetAnchorRoomInfoRsp != null && (yoloTeamOuterClass$YoloLiveTeamInfo = premadesTeamServerOuterClass$GetAnchorRoomInfoRsp.live_team_info) != null && (pBInt32Field = yoloTeamOuterClass$YoloLiveTeamInfo.status) != null) {
            num = Integer.valueOf(pBInt32Field.get());
        } else {
            num = null;
        }
        if ((num == null || num.intValue() != 0) && (num == null || num.intValue() != 2)) {
            return false;
        }
        return true;
    }

    public final boolean F() {
        PBInt32Field pBInt32Field;
        YoloTeamOuterClass$YoloLiveTeamInfo yoloTeamOuterClass$YoloLiveTeamInfo = this.mTeamInfo;
        if (yoloTeamOuterClass$YoloLiveTeamInfo == null || (pBInt32Field = yoloTeamOuterClass$YoloLiveTeamInfo.status) == null || pBInt32Field.get() != 1) {
            return false;
        }
        return true;
    }

    public final boolean G() {
        PBInt32Field pBInt32Field;
        PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp premadesTeamServerOuterClass$GetAnchorRoomInfoRsp = this.mAnchorRoomInfo;
        if (premadesTeamServerOuterClass$GetAnchorRoomInfoRsp == null || (pBInt32Field = premadesTeamServerOuterClass$GetAnchorRoomInfoRsp.one_live_status) == null || pBInt32Field.get() != 1) {
            return false;
        }
        return true;
    }

    public final void I(@Nullable GetAnchorRoomInfoRequest.a result) {
        Integer num;
        PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp rsp;
        PremadesTeamServerOuterClass$NewPlayTogetherInfo premadesTeamServerOuterClass$NewPlayTogetherInfo;
        PBInt32Field pBInt32Field;
        if (result != null && (rsp = result.getRsp()) != null && (premadesTeamServerOuterClass$NewPlayTogetherInfo = rsp.new_play_together_info) != null && (pBInt32Field = premadesTeamServerOuterClass$NewPlayTogetherInfo.method_switch) != null) {
            num = Integer.valueOf(pBInt32Field.get());
        } else {
            num = null;
        }
        Q(num);
    }

    public final void J(boolean actionToast, boolean actionLaunchGame) {
        hk4.a.a(n(), new c(actionToast, actionLaunchGame, this));
    }

    public final void K(@Nullable t dialog) {
        this.dialog = dialog;
    }

    public final void L() {
        LiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> B2 = ((i) mm4.b.b(i.class)).B2(this.yesGameId);
        if (B2 != null) {
            B2.removeObserver(this.defaultRoleObserver);
        }
    }

    public final void N(int condition) {
        O(condition, false);
    }

    public final void O(int condition, boolean justUpdateUI) {
        if (condition == this.mCurCondition) {
            return;
        }
        this.mCurCondition = condition;
        PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp premadesTeamServerOuterClass$GetAnchorRoomInfoRsp = this.mAnchorRoomInfo;
        if (premadesTeamServerOuterClass$GetAnchorRoomInfoRsp != null) {
            R(premadesTeamServerOuterClass$GetAnchorRoomInfoRsp);
        }
        t tVar = this.dialog;
        if (tVar != null) {
            tVar.A(condition);
        }
        if (justUpdateUI) {
            return;
        }
        J(true, false);
    }

    public final void P(int mode) {
        this.mMode = mode;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r3.intValue() == 1) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q(@Nullable Integer flag) {
        boolean z16;
        MutableLiveData<Boolean> mutableLiveData = this.anchorEntranceLiveData;
        if (flag != null) {
            z16 = true;
        }
        z16 = false;
        mutableLiveData.postValue(Boolean.valueOf(z16));
    }

    public final void R(@NotNull PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp anchorRoomInfo) {
        Intrinsics.checkNotNullParameter(anchorRoomInfo, "anchorRoomInfo");
        p(anchorRoomInfo.live_team_info.get(), anchorRoomInfo);
        if (E()) {
            B();
        } else {
            C();
        }
    }

    public final void l() {
        LiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> B2 = ((i) mm4.b.b(i.class)).B2(this.yesGameId);
        if (B2 != null) {
            B2.observeForever(this.defaultRoleObserver);
        }
    }

    public final void m(@NotNull final Context ctx, @Nullable final Function0<Unit> cb5) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        com.tencent.timi.game.liveroom.impl.room.playtogether.util.a.a(this.gameId, this.roomId, new Function1<GetAnchorRoomInfoRequest.a, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.AnchorPlayTogetherPresenter$bindRole$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GetAnchorRoomInfoRequest.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable GetAnchorRoomInfoRequest.a aVar) {
                PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp rsp;
                if (AnchorPlayTogetherPresenter.this.F()) {
                    com.tencent.timi.game.ui.widget.f.c("\u5df2\u7ecf\u5728\u8f66\u961f\u4e0a\uff0c\u6682\u4e0d\u80fd\u4fee\u6539\u8d26\u53f7\u4fe1\u606f");
                    return;
                }
                if (aVar != null && (rsp = aVar.getRsp()) != null) {
                    AnchorPlayTogetherPresenter.this.R(rsp);
                }
                final AnchorPlayTogetherPresenter anchorPlayTogetherPresenter = AnchorPlayTogetherPresenter.this;
                final Context context = ctx;
                com.tencent.timi.game.liveroom.impl.room.playtogether.util.h.f(true, null, null, null, new Function2<YesGameInfoOuterClass$YesGameRoleInfo, Boolean, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.AnchorPlayTogetherPresenter$bindRole$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo, Boolean bool) {
                        invoke(yesGameInfoOuterClass$YesGameRoleInfo, bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo, boolean z16) {
                        YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo2;
                        if (!z16) {
                            AnchorPlayTogetherPresenter.this.defaultRole = yesGameInfoOuterClass$YesGameRoleInfo;
                        }
                        AnchorPlayTogetherPresenter anchorPlayTogetherPresenter2 = AnchorPlayTogetherPresenter.this;
                        yesGameInfoOuterClass$YesGameRoleInfo2 = anchorPlayTogetherPresenter2.defaultRole;
                        anchorPlayTogetherPresenter2.M(yesGameInfoOuterClass$YesGameRoleInfo2);
                        AnchorPlayTogetherDialog.f378243j0.a(context, AnchorPlayTogetherPresenter.this);
                    }
                }, 14, null);
                Function0<Unit> function0 = cb5;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
    }

    @NotNull
    public final LiveData<Pair<String, String>> r() {
        return this.accountInfoLiveData;
    }

    @NotNull
    public final LiveData<a> s() {
        return this.actionBtnLiveData;
    }

    @NotNull
    public final LiveData<Boolean> t() {
        return this.anchorEntranceLiveData;
    }

    /* renamed from: u, reason: from getter */
    public final int getMCurCondition() {
        return this.mCurCondition;
    }

    public final void v() {
        com.tencent.timi.game.liveroom.impl.room.playtogether.util.h.k(new Function1<YesGameInfoOuterClass$YesGameRoleInfo, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.AnchorPlayTogetherPresenter$getDefaultRole$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo) {
                invoke2(yesGameInfoOuterClass$YesGameRoleInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo) {
                YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo2;
                AnchorPlayTogetherPresenter.this.defaultRole = yesGameInfoOuterClass$YesGameRoleInfo;
                AnchorPlayTogetherPresenter anchorPlayTogetherPresenter = AnchorPlayTogetherPresenter.this;
                yesGameInfoOuterClass$YesGameRoleInfo2 = anchorPlayTogetherPresenter.defaultRole;
                anchorPlayTogetherPresenter.M(yesGameInfoOuterClass$YesGameRoleInfo2);
            }
        });
    }

    @NotNull
    public final LiveData<Boolean> w() {
        return this.isTeamAvailableLiveData;
    }

    public final int x() {
        YoloTeamOuterClass$YoloLiveTeamInfo yoloTeamOuterClass$YoloLiveTeamInfo;
        YoloRoomOuterClass$YoloGameDataInfo yoloRoomOuterClass$YoloGameDataInfo;
        YoloRoomOuterClass$YoloCommonGameDataInfo yoloRoomOuterClass$YoloCommonGameDataInfo;
        YoloRoomOuterClass$QQLiveRoomConfig yoloRoomOuterClass$QQLiveRoomConfig;
        PBInt32Field pBInt32Field;
        int i3 = 5;
        if (!E() && (yoloTeamOuterClass$YoloLiveTeamInfo = this.mTeamInfo) != null && (yoloRoomOuterClass$YoloGameDataInfo = yoloTeamOuterClass$YoloLiveTeamInfo.game_data_info) != null && (yoloRoomOuterClass$YoloCommonGameDataInfo = yoloRoomOuterClass$YoloGameDataInfo.common_game_data_info) != null && (yoloRoomOuterClass$QQLiveRoomConfig = yoloRoomOuterClass$YoloCommonGameDataInfo.qq_live_room_config) != null && (pBInt32Field = yoloRoomOuterClass$QQLiveRoomConfig.enter_condition) != null) {
            i3 = pBInt32Field.get();
        }
        l.i("AnchorPlayTogetherPresenter", "serverCondition is " + i3);
        return i3;
    }

    public final void y(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        final com.tencent.timi.game.ui.widget.e c16 = new e.a(context).j("\u5173\u95ed\u4e00\u8d77\u73a9\u540e\u89c2\u4f17\u5c06\u65e0\u6cd5\u52a0\u5165\u7ec4\u961f\uff0c\u786e\u5b9a\u5173\u95ed\u5417").k(1).n("\u53d6\u6d88").p("\u786e\u5b9a").c();
        c16.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.b
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                AnchorPlayTogetherPresenter.z(com.tencent.timi.game.ui.widget.e.this, dialogInterface);
            }
        });
        c16.getPositiveButton().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorPlayTogetherPresenter.A(com.tencent.timi.game.ui.widget.e.this, this, view);
            }
        });
        c16.show();
    }
}
