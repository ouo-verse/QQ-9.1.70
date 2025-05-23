package com.tencent.timi.game.team.impl.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.timi.game.component.chat.TimiBaseInputViewV2;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.component.chat.message.MessageLayout;
import com.tencent.timi.game.component.chat.message.MessageLayoutImpl;
import com.tencent.timi.game.component.chat.message.n;
import com.tencent.timi.game.gift.impl.timi.TimiGiftController;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.team.impl.chat.TeamChatView;
import com.tencent.timi.game.team.impl.input.TeamOperateView;
import com.tencent.timi.game.tim.api.message.c;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import fm4.k;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import nr2.at;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;
import ug4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0003X[`\u0018\u0000 u2\u00020\u00012\u00020\u0002:\u0001vB'\b\u0007\u0012\u0006\u0010o\u001a\u00020n\u0012\n\b\u0002\u0010q\u001a\u0004\u0018\u00010p\u0012\b\b\u0002\u0010r\u001a\u00020\t\u00a2\u0006\u0004\bs\u0010tJ\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013J\u001e\u0010\u0018\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u0019\u001a\u00020\rH\u0014J\b\u0010\u001a\u001a\u00020\rH\u0015J\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010\u001f\u001a\u00020\rJ\u0006\u0010 \u001a\u00020\rJ\u0006\u0010!\u001a\u00020\rJ\u0006\u0010#\u001a\u00020\"J\n\u0010%\u001a\u0004\u0018\u00010$H\u0016J\n\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u001e\u0010,\u001a\u00020\r2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(2\u0006\u0010+\u001a\u00020\tJ\u0006\u0010-\u001a\u00020\u0005J\u0006\u0010.\u001a\u00020\rR\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020)0/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010\u000fR\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010ER\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010FR$\u0010M\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010NR\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010PR\"\u0010W\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0016\u0010Z\u001a\u00020X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010YR\u0014\u0010]\u001a\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\\R\u0014\u0010\u001c\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010_R\u0014\u0010c\u001a\u00020`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR'\u0010j\u001a\u0012\u0012\u0004\u0012\u00020\u00030dj\b\u0012\u0004\u0012\u00020\u0003`e8\u0006\u00a2\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\u0014\u0010m\u001a\u00020A8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bk\u0010l\u00a8\u0006w"}, d2 = {"Lcom/tencent/timi/game/team/impl/chat/TeamChatView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/timi/game/component/chat/at/d;", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "", "onNewMsg", "B", BdhLogUtil.LogTag.Tag_Conn, "", JumpGuildParam.EXTRA_KEY_OPEN_FROM, "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "roomInfo", "", "K", "J", ReportConstant.COSTREPORT_PREFIX, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "t", "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftController;", "giftController", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/timi/game/component/chat/message/n;", "listener", "setMessageListener", "G", "E", "L", "M", "Lcom/tencent/timi/game/team/impl/input/TeamOperateView;", "w", "Landroid/widget/EditText;", "H", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", UserInfo.SEX_FEMALE, "", "", "chatBgColorList", SkinConstants.TintConstant.KEY_DEFAULT_COLOR, "setChatViewBackground", "D", "I", "", "d", "Ljava/util/List;", "historyMsgIdList", "e", "Lcom/tencent/timi/game/tim/api/message/a;", "lastMsg", "Lcom/tencent/timi/game/component/chat/message/MessageLayoutImpl;", "f", "Lcom/tencent/timi/game/component/chat/message/MessageLayoutImpl;", "messageLayout", "Lcom/tencent/timi/game/team/impl/chat/TeamInputView;", tl.h.F, "Lcom/tencent/timi/game/team/impl/chat/TeamInputView;", "inputBoxView", "i", "Lcom/tencent/timi/game/team/impl/input/TeamOperateView;", "teamOperationView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "chatId", "roomId", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "Lcom/tencent/timi/game/tim/api/message/c;", "Lcom/tencent/timi/game/tim/api/message/c;", "v", "()Lcom/tencent/timi/game/tim/api/message/c;", "setIMsgManager", "(Lcom/tencent/timi/game/tim/api/message/c;)V", "iMsgManager", "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftController;", "Lnr2/at;", "Lnr2/at;", "binding", "Z", HippyTKDListViewAdapter.X, "()Z", "setRetryGetHistory", "(Z)V", "retryGetHistory", "com/tencent/timi/game/team/impl/chat/TeamChatView$g", "Lcom/tencent/timi/game/team/impl/chat/TeamChatView$g;", "historyHandler", "com/tencent/timi/game/team/impl/chat/TeamChatView$i", "Lcom/tencent/timi/game/team/impl/chat/TeamChatView$i;", "mEmoSendListener", "Lfm4/k;", "Lfm4/k;", "com/tencent/timi/game/team/impl/chat/TeamChatView$j", "N", "Lcom/tencent/timi/game/team/impl/chat/TeamChatView$j;", "msgListener", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "P", "Ljava/util/Comparator;", "u", "()Ljava/util/Comparator;", "comparator", "y", "()J", "sendMsgIntervalTime", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TeamChatView extends RelativeLayout implements com.tencent.timi.game.component.chat.at.d {

    /* renamed from: C, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: D, reason: from kotlin metadata */
    private int openFrom;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private YoloRoomOuterClass$YoloRoomInfo roomInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private CommonOuterClass$QQUserId qqUserId;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private c iMsgManager;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TimiGiftController giftController;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final at binding;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean retryGetHistory;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private g historyHandler;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final i mEmoSendListener;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final k listener;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final j msgListener;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Comparator<com.tencent.timi.game.tim.api.message.a> comparator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> historyMsgIdList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.timi.game.tim.api.message.a lastMsg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MessageLayoutImpl messageLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TeamInputView inputBoxView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TeamOperateView teamOperationView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long chatId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/timi/game/team/impl/chat/TeamChatView$a", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$c;", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements MessageLayout.c {
        a() {
        }

        @Override // com.tencent.timi.game.component.chat.message.MessageLayout.c
        public void a() {
            TeamChatView.this.inputBoxView.setState(1);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/timi/game/team/impl/chat/TeamChatView$b", "Lcom/tencent/timi/game/team/impl/input/TeamOperateView$a;", "Landroid/view/View;", "view", "", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements TeamOperateView.a {
        b() {
        }

        @Override // com.tencent.timi.game.team.impl.input.TeamOperateView.a
        public void a(@Nullable View view) {
            TeamChatView.this.M();
        }

        @Override // com.tencent.timi.game.team.impl.input.TeamOperateView.a
        public void b(@Nullable View view) {
            TeamChatView.this.L();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/team/impl/chat/TeamChatView$d", "Lcom/tencent/timi/game/component/chat/message/n;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "uid", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements n {
        d() {
        }

        @Override // com.tencent.timi.game.component.chat.message.n
        public void a(@NotNull CommonOuterClass$QQUserId uid) {
            Intrinsics.checkNotNullParameter(uid, "uid");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/team/impl/chat/TeamChatView$e", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$d;", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "", "position", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements MessageLayout.d {
        e() {
        }

        @Override // com.tencent.timi.game.component.chat.message.MessageLayout.d
        public void a(@NotNull com.tencent.timi.game.tim.api.message.a msg2, int position) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (position < 6) {
                TeamChatView.this.historyHandler.removeMessages(1);
                TeamChatView.this.historyHandler.sendEmptyMessageDelayed(1, 500L);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/timi/game/team/impl/chat/TeamChatView$f", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$b;", "", "text", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "content", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "timiBaseInputView", "", "a", "b", "", "state", "onStateChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements TimiBaseInputView.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f379415b;

        f(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
            this.f379415b = commonOuterClass$QQUserId;
        }

        @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView.b
        public void a(@NotNull String text, @NotNull MessageOuterClass$MsgContent content, @NotNull TimiBaseInputView timiBaseInputView) {
            boolean z16;
            com.tencent.timi.game.tim.api.message.a aVar;
            EditText inputEditText;
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
            if (o.f("tag_suspend_send_msg", TeamChatView.this.y())) {
                com.tencent.timi.game.ui.widget.f.c("\u8bf4\u8bdd\u592a\u5feb\u4e86\uff0c\u4f11\u606f\u4e00\u4e0b\u5427\u3002");
                return;
            }
            if (text.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                c iMsgManager = TeamChatView.this.getIMsgManager();
                if (iMsgManager != null) {
                    aVar = iMsgManager.h(this.f379415b, text, content);
                } else {
                    aVar = null;
                }
                if (aVar != null && (inputEditText = TeamChatView.this.inputBoxView.getInputEditText()) != null) {
                    inputEditText.setText("");
                }
            }
        }

        @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView.b
        public void b(@NotNull String text, @NotNull TimiBaseInputView timiBaseInputView) {
            boolean z16;
            com.tencent.timi.game.tim.api.message.a aVar;
            EditText inputEditText;
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
            if (o.f("tag_suspend_send_msg", TeamChatView.this.y())) {
                com.tencent.timi.game.ui.widget.f.c("\u8bf4\u8bdd\u592a\u5feb\u4e86\uff0c\u4f11\u606f\u4e00\u4e0b\u5427\u3002");
                return;
            }
            if (text.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                c iMsgManager = TeamChatView.this.getIMsgManager();
                if (iMsgManager != null) {
                    aVar = iMsgManager.j(this.f379415b, text);
                } else {
                    aVar = null;
                }
                if (aVar != null && (inputEditText = TeamChatView.this.inputBoxView.getInputEditText()) != null) {
                    inputEditText.setText("");
                }
            }
        }

        @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView.b
        public void onStateChanged(int state) {
            if (state != 1) {
                if (state == 2) {
                    TeamChatView.this.inputBoxView.setVisibility(0);
                }
            } else {
                TeamChatView.this.inputBoxView.setVisibility(8);
            }
            ViewGroup.LayoutParams layoutParams = TeamChatView.this.messageLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (state == 1) {
                layoutParams2.addRule(2, R.id.f93365_d);
            } else {
                layoutParams2.addRule(2, R.id.xob);
            }
            TeamChatView.this.messageLayout.setLayoutParams(layoutParams2);
            if (state != 1) {
                TeamChatView.this.messageLayout.R();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/team/impl/chat/TeamChatView$g", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class g extends Handler {
        g() {
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            super.handleMessage(msg2);
            c iMsgManager = TeamChatView.this.getIMsgManager();
            if (iMsgManager != null) {
                iMsgManager.i(TeamChatView.this.lastMsg);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/timi/game/team/impl/chat/TeamChatView$h", "Lfm4/k;", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "speakingPosInfoList", "", "o", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class h extends k {
        h() {
        }

        @Override // fm4.k, fm4.q
        public void o(@NotNull List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> speakingPosInfoList) {
            Intrinsics.checkNotNullParameter(speakingPosInfoList, "speakingPosInfoList");
            super.o(speakingPosInfoList);
            TimiGiftController timiGiftController = TeamChatView.this.giftController;
            if (timiGiftController != null) {
                timiGiftController.C(speakingPosInfoList);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/team/impl/chat/TeamChatView$i", "Lcom/tencent/timi/game/component/chat/TimiBaseInputViewV2$b;", "Lxg4/k;", "timiEmoInfo", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class i implements TimiBaseInputViewV2.b {
        i() {
        }

        @Override // com.tencent.timi.game.component.chat.TimiBaseInputViewV2.b
        public void a(@NotNull xg4.k timiEmoInfo) {
            CommonOuterClass$QQUserId commonOuterClass$QQUserId;
            c iMsgManager;
            Intrinsics.checkNotNullParameter(timiEmoInfo, "timiEmoInfo");
            l.i("TeamChatView", "onSend " + timiEmoInfo + " qqUserId:" + TeamChatView.this.qqUserId);
            if (!(timiEmoInfo.getQqEmoInfo() instanceof SystemAndEmojiEmoticonInfo) && (commonOuterClass$QQUserId = TeamChatView.this.qqUserId) != null && (iMsgManager = TeamChatView.this.getIMsgManager()) != null) {
                iMsgManager.d(commonOuterClass$QQUserId, xg4.c.a(timiEmoInfo));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0016\u0010\u0013\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/timi/game/team/impl/chat/TeamChatView$j", "Lcom/tencent/timi/game/tim/api/message/b;", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "", "e", tl.h.F, "d", "b", "", "code", "", "desc", "f", "c", "msgId", "a", "", "historyMessages", "g", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class j implements com.tencent.timi.game.tim.api.message.b {
        j() {
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void a(@NotNull String msgId) {
            Intrinsics.checkNotNullParameter(msgId, "msgId");
            TeamChatView.this.messageLayout.O(msgId);
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void b(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            TeamChatView.this.messageLayout.b0(msg2.id());
            ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
            ConcurrentHashMap<String, String> L = YoloRoomUtil.L(TeamChatView.this.roomInfo);
            L.put("yes_msg_type", String.valueOf(msg2.type()));
            L.put("yes_emo_type", String.valueOf(msg2.o()));
            Unit unit = Unit.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(L, "getCommonRoomInfoReportP\u2026}\")\n                    }");
            bVar.reportEvent("ev_yes_msg_send", L);
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void c(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            MessageLayoutImpl messageLayoutImpl;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (TeamChatView.this.B(msg2, true) && !TeamChatView.this.C(msg2, true) && (messageLayoutImpl = TeamChatView.this.messageLayout) != null) {
                messageLayoutImpl.P(msg2);
            }
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void d(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            TeamChatView.this.messageLayout.b0(msg2.id());
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void e(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (!TeamChatView.this.historyMsgIdList.contains(msg2.id())) {
                TeamChatView.this.historyMsgIdList.add(msg2.id());
            }
            TeamChatView.this.messageLayout.y(msg2);
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void f(@NotNull com.tencent.timi.game.tim.api.message.a msg2, int code, @Nullable String desc) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            TeamChatView.this.messageLayout.b0(msg2.id());
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void g(@NotNull List<? extends com.tencent.timi.game.tim.api.message.a> historyMessages) {
            boolean z16;
            Intrinsics.checkNotNullParameter(historyMessages, "historyMessages");
            if (!TeamChatView.this.getRetryGetHistory() && historyMessages.isEmpty()) {
                TeamChatView.this.setRetryGetHistory(true);
                TeamChatView.this.historyHandler.sendEmptyMessageDelayed(1, 1000L);
                return;
            }
            if (!historyMessages.isEmpty()) {
                TeamChatView.this.lastMsg = historyMessages.get(0);
            }
            ArrayList arrayList = new ArrayList();
            TeamChatView teamChatView = TeamChatView.this;
            for (com.tencent.timi.game.tim.api.message.a aVar : historyMessages) {
                if (teamChatView.B(aVar, false) && !teamChatView.C(aVar, false)) {
                    if (aVar.type() == pn4.e.e() && (teamChatView.openFrom == 1 || teamChatView.openFrom == 2)) {
                        int m3 = aVar.m();
                        if (1 <= m3 && m3 < 10) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            aVar.n(aVar.m() + 10);
                        } else if (aVar.m() == -1) {
                            aVar.n(10);
                        }
                    }
                    arrayList.add(aVar);
                }
            }
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, TeamChatView.this.u());
            MessageLayoutImpl messageLayoutImpl = TeamChatView.this.messageLayout;
            if (messageLayoutImpl != null) {
                messageLayoutImpl.v(arrayList);
            }
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void h(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            TeamChatView.this.messageLayout.D(msg2.id());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TeamChatView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean B(com.tencent.timi.game.tim.api.message.a msg2, boolean onNewMsg) {
        int i3;
        boolean isBlank;
        if (msg2.type() != 49 || !msg2.a().yolo_room_action_msg.has() || (i3 = msg2.a().yolo_room_action_msg.yolo_room_action.action_type.get()) == 252 || i3 == 111 || i3 == 103 || i3 == 102 || i3 == 251 || i3 == 151) {
            return true;
        }
        if (i3 == 108) {
            String str = msg2.a().yolo_room_action_msg.yolo_room_action.yolo_room_update_game_route_info_action.status_change_text.get();
            Intrinsics.checkNotNullExpressionValue(str, "msg.content()\n          \u2026xt\n                .get()");
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean C(com.tencent.timi.game.tim.api.message.a msg2, boolean onNewMsg) {
        if (this.historyMsgIdList.contains(msg2.id())) {
            l.b("TeamChatView", "messageIsExist " + onNewMsg + ",id=" + msg2.id() + "," + msg2.type());
            return true;
        }
        this.historyMsgIdList.add(msg2.id());
        return false;
    }

    private final void J(int openFrom, YoloRoomOuterClass$YoloRoomInfo roomInfo) {
        if (openFrom == 2 && ((sm4.a) mm4.b.b(sm4.a.class)).n1()) {
            com.tencent.timi.game.room.impl.util.g.f379335a.d(roomInfo.tim_group_id.get(), roomInfo.room_id.get());
        }
    }

    private final void K(int openFrom, YoloRoomOuterClass$YoloRoomInfo roomInfo) {
        CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        if (openFrom == 1 && ll4.b.a(roomInfo.create_user_id, E) && roomInfo.room_data_info.sub_create_from.get() != 2) {
            com.tencent.timi.game.room.impl.util.g.f379335a.f(roomInfo.tim_group_id.get(), roomInfo.room_id.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(com.tencent.timi.game.tim.api.message.a aVar, com.tencent.timi.game.tim.api.message.a aVar2) {
        boolean z16;
        String p16 = aVar.p();
        String p17 = aVar2.p();
        if (aVar2.l() == aVar.l()) {
            int type = aVar.type();
            boolean z17 = true;
            if (2000 <= type && type < 2002) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                int type2 = aVar2.type();
                if (2000 > type2 || type2 >= 2002) {
                    z17 = false;
                }
                if (z17 && p16 != null && p17 != null) {
                    return (int) (Long.parseLong(p16) - Long.parseLong(p17));
                }
            }
        }
        return (int) (aVar.l() - aVar2.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(TeamChatView this$0, int i3, YoloRoomOuterClass$YoloRoomInfo roomInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(roomInfo, "$roomInfo");
        this$0.messageLayout.setOnScrollMsgListener(new e());
        if (i3 == 1 || i3 == 2) {
            this$0.K(i3, roomInfo);
            this$0.J(i3, roomInfo);
            if (((fm4.g) mm4.b.b(fm4.g.class)).t2(roomInfo) == 101) {
                com.tencent.timi.game.room.impl.util.g.f379335a.g(roomInfo.tim_group_id.get(), roomInfo.room_id.get());
            }
        }
    }

    private final void s() {
        this.inputBoxView.h0(this.mEmoSendListener);
        com.tencent.timi.game.component.chat.at.b.INSTANCE.a().b(String.valueOf(this.chatId));
        ((kn4.b) mm4.b.b(kn4.b.class)).M(this.chatId).k(this.msgListener);
        ((fm4.g) mm4.b.b(fm4.g.class)).k(this.roomId).Q(this.listener);
        TimiGiftController timiGiftController = this.giftController;
        if (timiGiftController != null) {
            timiGiftController.s(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long y() {
        return ((fm4.g) mm4.b.b(fm4.g.class)).S2().a() * 1000;
    }

    public final boolean A() {
        TimiGiftController timiGiftController = this.giftController;
        if (timiGiftController == null || !timiGiftController.getIsGiftPanelVisible()) {
            return false;
        }
        return true;
    }

    public final boolean D() {
        return this.inputBoxView.v0();
    }

    public final void E() {
        TimiGiftController timiGiftController = this.giftController;
        if (timiGiftController != null) {
            timiGiftController.t();
        }
        this.inputBoxView.setState(1);
        s();
    }

    @Override // com.tencent.timi.game.component.chat.at.d
    @Nullable
    public TimiBaseInputView F() {
        return this.inputBoxView;
    }

    public final void G() {
        l.e("ROOM_ENTER_TEST", "onPageShow");
    }

    @Override // com.tencent.timi.game.component.chat.at.d
    @Nullable
    public EditText H() {
        return this.inputBoxView.getInputEditText();
    }

    public final void I() {
        this.inputBoxView.w0();
    }

    public final void L() {
        TimiGiftController timiGiftController = this.giftController;
        if (timiGiftController != null) {
            timiGiftController.K();
        }
    }

    public final void M() {
        this.inputBoxView.setVisibility(0);
        this.inputBoxView.U();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        View b16 = this.teamOperationView.b();
        if (b16 != null) {
            ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
            ConcurrentHashMap<String, String> d16 = com.tencent.timi.game.team.impl.main.f.d(this.roomId);
            Intrinsics.checkNotNullExpressionValue(d16, "getCommonRoomInfoReportParam(roomId)");
            bVar.reportEvent("imp", b16, d16);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"MissingSuperCall"})
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        View b16 = this.teamOperationView.b();
        if (b16 != null) {
            ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
            ConcurrentHashMap<String, String> d16 = com.tencent.timi.game.team.impl.main.f.d(this.roomId);
            Intrinsics.checkNotNullExpressionValue(d16, "getCommonRoomInfoReportParam(roomId)");
            bVar.reportEvent("imp_end", b16, d16);
        }
    }

    public final void q(@NotNull final YoloRoomOuterClass$YoloRoomInfo roomInfo, @NotNull CommonOuterClass$QQUserId qqUserId, final int openFrom) {
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        this.roomInfo = roomInfo;
        this.chatId = roomInfo.tim_group_id.get();
        this.roomId = roomInfo.room_id.get();
        this.qqUserId = qqUserId;
        this.openFrom = openFrom;
        this.messageLayout.setMessageListener(new d());
        com.tencent.timi.game.component.chat.at.b.INSTANCE.a().e(String.valueOf(this.chatId), qqUserId);
        c M = ((kn4.b) mm4.b.b(kn4.b.class)).M(this.chatId);
        this.iMsgManager = M;
        if (M != null) {
            M.k(this.msgListener);
        }
        c cVar = this.iMsgManager;
        if (cVar != null) {
            cVar.b(this.msgListener);
        }
        this.messageLayout.setRoomInfo(roomInfo);
        this.messageLayout.setViewProvider(new com.tencent.timi.game.component.chat.a(roomInfo));
        this.messageLayout.setChatId(this.chatId);
        this.messageLayout.setQQUserId(qqUserId);
        c cVar2 = this.iMsgManager;
        if (cVar2 != null) {
            cVar2.i(this.lastMsg);
        }
        postDelayed(new Runnable() { // from class: tm4.b
            @Override // java.lang.Runnable
            public final void run() {
                TeamChatView.r(TeamChatView.this, openFrom, roomInfo);
            }
        }, 500L);
        ((fm4.g) mm4.b.b(fm4.g.class)).k(this.roomId).y(this.listener);
        this.inputBoxView.i(new f(qqUserId));
        ImageView emojiIv = this.inputBoxView.getEmojiIv();
        if (emojiIv != null) {
            mm4.a b16 = mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
            ConcurrentHashMap<String, String> L = YoloRoomUtil.L(roomInfo);
            Intrinsics.checkNotNullExpressionValue(L, "getCommonRoomInfoReportParam(roomInfo)");
            b.a.a((ug4.b) b16, emojiIv, false, null, "em_yes_emoji", L, 6, null);
        }
        this.inputBoxView.b0(this.mEmoSendListener);
        this.inputBoxView.l0(roomInfo.room_data_info.game_id.get());
        View b17 = this.teamOperationView.b();
        if (b17 != null) {
            ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
            ConcurrentHashMap<String, String> d16 = com.tencent.timi.game.team.impl.main.f.d(this.roomId);
            Intrinsics.checkNotNullExpressionValue(d16, "getCommonRoomInfoReportParam(roomId)");
            bVar.a(b17, false, "\u793c\u7269\u5165\u53e3\u6309\u94ae", "em_yes_gift", d16);
        }
    }

    public final void setChatViewBackground(@Nullable List<String> chatBgColorList, int defaultColor) {
        com.tencent.timi.game.team.impl.b.d(this.binding.f420895c, chatBgColorList, defaultColor);
    }

    public final void setIMsgManager(@Nullable c cVar) {
        this.iMsgManager = cVar;
    }

    public final void setMessageListener(@NotNull n listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.messageLayout.setMessageListener(listener);
    }

    public final void setRetryGetHistory(boolean z16) {
        this.retryGetHistory = z16;
    }

    public final void t() {
        TimiGiftController timiGiftController = this.giftController;
        if (timiGiftController != null) {
            timiGiftController.t();
        }
    }

    @NotNull
    public final Comparator<com.tencent.timi.game.tim.api.message.a> u() {
        return this.comparator;
    }

    @Nullable
    /* renamed from: v, reason: from getter */
    public final c getIMsgManager() {
        return this.iMsgManager;
    }

    @NotNull
    /* renamed from: w, reason: from getter */
    public final TeamOperateView getTeamOperationView() {
        return this.teamOperationView;
    }

    /* renamed from: x, reason: from getter */
    public final boolean getRetryGetHistory() {
        return this.retryGetHistory;
    }

    public final void z(@NotNull TimiGiftController giftController) {
        Intrinsics.checkNotNullParameter(giftController, "giftController");
        this.giftController = giftController;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TeamChatView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ TeamChatView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TeamChatView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.historyMsgIdList = new ArrayList();
        at f16 = at.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.historyHandler = new g();
        this.mEmoSendListener = new i();
        View findViewById = findViewById(R.id.z59);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.messageLayout)");
        this.messageLayout = (MessageLayoutImpl) findViewById;
        View findViewById2 = findViewById(R.id.xob);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.inputBoxView)");
        this.inputBoxView = (TeamInputView) findViewById2;
        setClipChildren(false);
        View findViewById3 = findViewById(R.id.f93365_d);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.team_operate_layout)");
        this.teamOperationView = (TeamOperateView) findViewById3;
        this.messageLayout.setLayoutClickListener(new a());
        this.teamOperationView.setOnActionClickListener(new b());
        this.listener = new h();
        this.msgListener = new j();
        this.comparator = new Comparator() { // from class: tm4.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int p16;
                p16 = TeamChatView.p((com.tencent.timi.game.tim.api.message.a) obj, (com.tencent.timi.game.tim.api.message.a) obj2);
                return p16;
            }
        };
    }
}
