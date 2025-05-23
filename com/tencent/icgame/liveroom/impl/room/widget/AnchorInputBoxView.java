package com.tencent.icgame.liveroom.impl.room.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.app.event.AnchorAtEvent;
import com.tencent.icgame.game.component.chat.input.TimiBaseInputView;
import com.tencent.icgame.game.liveroom.impl.room.anchor.UserSelfSendMsgEvent;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$MsgContent;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$TextMsg;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$TimMsgBody;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomOperation;
import com.tencent.mobileqq.icgame.data.message.LiveMessageData;
import com.tencent.mobileqq.icgame.widget.chat.message.LiveLocalMsg;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.timi.game.app.event.AnchorInputEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qw0.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 R2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001SB'\b\u0007\u0012\u0006\u0010L\u001a\u00020K\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M\u0012\b\b\u0002\u0010O\u001a\u00020\u0019\u00a2\u0006\u0004\bP\u0010QJ\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J(\u0010\u0012\u001a\u00020\t2\u001e\u0010\u0011\u001a\u001a\u0012\b\u0012\u00060\u000eR\u00020\u000f0\rj\f\u0012\b\u0012\u00060\u000eR\u00020\u000f`\u0010H\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u000e\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\tH\u0014J\b\u0010\"\u001a\u00020\tH\u0014J\u0012\u0010#\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010%\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030$0\rj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030$`\u0010H\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010'\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0016H\u0014R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u001dR\u0018\u0010.\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0018\u00105\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00100R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\"\u0010@\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010;R\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006T"}, d2 = {"Lcom/tencent/icgame/liveroom/impl/room/widget/AnchorInputBoxView;", "Lcom/tencent/icgame/game/component/chat/input/TimiBaseInputView;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Ldu0/d;", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$TimMsgBody;", "msgBody", "", "text", "", "m0", "toastContent", "p0", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/icgame/data/message/LiveMessageData$ExtData;", "Lcom/tencent/mobileqq/icgame/data/message/LiveMessageData;", "Lkotlin/collections/ArrayList;", "extDatas", "g0", "h0", "Landroid/widget/EditText;", "w", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "f0", "", HippyTKDListViewAdapter.X, "view", "setClickDelegate", "J", "state", "setState", "e0", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "H", UserInfo.SEX_FEMALE, "j", "", "M", "roomId", "N", "Landroid/widget/EditText;", "editText", "P", "Landroid/view/View;", "sendView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "emojiBtn", BdhLogUtil.LogTag.Tag_Req, "clickDelegateView", "", ExifInterface.LATITUDE_SOUTH, "Z", MiniChatConstants.MINI_APP_LANDSCAPE, "T", "Ljava/lang/String;", "getQqLiveSendMessage", "()Ljava/lang/String;", "o0", "(Ljava/lang/String;)V", "qqLiveSendMessage", "Lcom/tencent/mobileqq/widget/QQToast;", "U", "Lcom/tencent/mobileqq/widget/QQToast;", "qqToast", "V", "lastToastContent", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "W", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "aegisLog", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a0", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public class AnchorInputBoxView extends TimiBaseInputView implements SimpleEventReceiver<SimpleBaseEvent>, du0.d {

    /* renamed from: M, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private EditText editText;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private View sendView;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private View emojiBtn;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private View clickDelegateView;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private String qqLiveSendMessage;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private QQToast qqToast;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private String lastToastContent;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/icgame/liveroom/impl/room/widget/AnchorInputBoxView$b", "Lcom/tencent/icgame/game/component/chat/input/TimiBaseInputView$b;", "", "text", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$MsgContent;", "content", "Lcom/tencent/icgame/game/component/chat/input/TimiBaseInputView;", "timiBaseInputView", "", "b", "a", "", "state", "onStateChanged", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements TimiBaseInputView.b {
        b() {
        }

        @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView.b
        public void a(@NotNull String text, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
        }

        @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView.b
        public void b(@NotNull String text, @NotNull MessageOuterClass$MsgContent content, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
        }

        @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView.b
        public void onStateChanged(int state) {
            if (state == 1) {
                AnchorInputBoxView.this.o0("0");
            }
            if (AnchorInputBoxView.this.getPreState() != 1 && state == 1) {
                ru0.a aVar = (ru0.a) qx0.a.b(ru0.a.class);
                View view = AnchorInputBoxView.this.sendView;
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type java.lang.Object");
                aVar.reportEvent("imp_end", view, new LinkedHashMap());
                ru0.a aVar2 = (ru0.a) qx0.a.b(ru0.a.class);
                View view2 = AnchorInputBoxView.this.emojiBtn;
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type java.lang.Object");
                aVar2.reportEvent("imp_end", view2, new LinkedHashMap());
                return;
            }
            if (AnchorInputBoxView.this.getPreState() == 1 && state != 1) {
                ru0.a aVar3 = (ru0.a) qx0.a.b(ru0.a.class);
                View view3 = AnchorInputBoxView.this.sendView;
                Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type java.lang.Object");
                aVar3.reportEvent("imp", view3, new LinkedHashMap());
                ru0.a aVar4 = (ru0.a) qx0.a.b(ru0.a.class);
                View view4 = AnchorInputBoxView.this.emojiBtn;
                Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type java.lang.Object");
                aVar4.reportEvent("imp", view4, new LinkedHashMap());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J>\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/icgame/liveroom/impl/room/widget/AnchorInputBoxView$c", "Landroid/text/InputFilter;", "", "source", "", "start", "end", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements InputFilter {
        c() {
        }

        @Override // android.text.InputFilter
        @Nullable
        public CharSequence filter(@Nullable CharSequence source, int start, int end, @Nullable Spanned dest, int dstart, int dend) {
            int i3;
            int i16;
            String replace$default;
            boolean contains$default;
            boolean z16 = false;
            if (source != null) {
                i3 = source.length();
            } else {
                i3 = 0;
            }
            if (dest != null) {
                i16 = dest.length();
            } else {
                i16 = 0;
            }
            if (i3 + i16 > 50) {
                return "";
            }
            if (source != null) {
                contains$default = StringsKt__StringsKt.contains$default(source, (CharSequence) "\n", false, 2, (Object) null);
                if (contains$default) {
                    z16 = true;
                }
            }
            if (z16) {
                replace$default = StringsKt__StringsJVMKt.replace$default(source.toString(), "\n", "", false, 4, (Object) null);
                return replace$default;
            }
            return null;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/icgame/liveroom/impl/room/widget/AnchorInputBoxView$e", "Lcom/tencent/icgame/game/component/chat/input/TimiBaseInputView$b;", "", "text", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$MsgContent;", "content", "Lcom/tencent/icgame/game/component/chat/input/TimiBaseInputView;", "timiBaseInputView", "", "b", "a", "", "state", "onStateChanged", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class e implements TimiBaseInputView.b {
        e() {
        }

        @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView.b
        public void a(@NotNull String text, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
            MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody();
            messageOuterClass$TimMsgBody.msg_type.set(1);
            MessageOuterClass$MsgContent messageOuterClass$MsgContent = messageOuterClass$TimMsgBody.content;
            MessageOuterClass$MsgContent messageOuterClass$MsgContent2 = new MessageOuterClass$MsgContent();
            MessageOuterClass$TextMsg messageOuterClass$TextMsg = messageOuterClass$MsgContent2.text_msg;
            MessageOuterClass$TextMsg messageOuterClass$TextMsg2 = new MessageOuterClass$TextMsg();
            messageOuterClass$TextMsg2.text.set(text);
            messageOuterClass$TextMsg.set(messageOuterClass$TextMsg2);
            messageOuterClass$MsgContent.set(messageOuterClass$MsgContent2);
            AnchorInputBoxView.this.m0(messageOuterClass$TimMsgBody, text);
            EditText editText = AnchorInputBoxView.this.editText;
            if (editText != null) {
                editText.setText("");
            }
            AnchorInputBoxView.this.setState(1);
        }

        @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView.b
        public void b(@NotNull String text, @NotNull MessageOuterClass$MsgContent content, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
            MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody();
            messageOuterClass$TimMsgBody.msg_type.set(70);
            messageOuterClass$TimMsgBody.content.set(content);
            AnchorInputBoxView.this.m0(messageOuterClass$TimMsgBody, text);
            EditText editText = AnchorInputBoxView.this.editText;
            if (editText != null) {
                editText.setText("");
            }
            AnchorInputBoxView.this.setState(1);
        }

        @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView.b
        public void onStateChanged(int state) {
            int i3;
            int i16;
            if (AnchorInputBoxView.this.isLandscape) {
                return;
            }
            AnchorInputBoxView anchorInputBoxView = AnchorInputBoxView.this;
            int i17 = 8;
            if (state == 1) {
                FrameLayout funcLayout = anchorInputBoxView.getFuncLayout();
                if (funcLayout != null) {
                    funcLayout.removeAllViews();
                }
                i3 = 8;
            } else {
                i3 = 0;
            }
            anchorInputBoxView.setVisibility(i3);
            View view = AnchorInputBoxView.this.emojiBtn;
            if (view != null) {
                if (state == 3) {
                    i16 = R.drawable.f162554o82;
                } else {
                    i16 = R.drawable.f162553o81;
                }
                view.setBackgroundResource(i16);
            }
            View view2 = AnchorInputBoxView.this.clickDelegateView;
            if (view2 != null) {
                if (state != 1 && !AnchorInputBoxView.this.isLandscape) {
                    i17 = 0;
                }
                view2.setVisibility(i17);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/icgame/liveroom/impl/room/widget/AnchorInputBoxView$f", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQLiveMessageCallback;", "", "isLocal", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "onIllegalMsg", "msg", "onUserForbid", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class f implements IQQLiveMessageCallback {
        f() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            AnchorInputBoxView.this.aegisLog.e("ICGameAnchorInputBoxView_TIMI", "sendMessage onFail, errCode:" + errCode + ", errMsg:" + errMsg);
            AnchorInputBoxView anchorInputBoxView = AnchorInputBoxView.this;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u8bc4\u8bba\u53d1\u8868\u5931\u8d25\uff0c\u9519\u8bef\u7801");
            sb5.append(errCode);
            anchorInputBoxView.p0(sb5.toString());
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onIllegalMsg() {
            AnchorInputBoxView.this.aegisLog.e("ICGameAnchorInputBoxView_TIMI", "sendMessage onIllegalMsg");
            AnchorInputBoxView.this.p0("\u8bc4\u8bba\u53d1\u8868\u5931\u8d25\uff0c\u9519\u8bef\u780110003");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onSuccess(boolean isLocal) {
            AnchorInputBoxView.this.aegisLog.i("ICGameAnchorInputBoxView_TIMI", "sendMessage onSuccess, isLocal:" + isLocal);
            EditText editText = AnchorInputBoxView.this.editText;
            if (editText != null) {
                editText.setText("");
            }
            if (isLocal || com.tencent.icgame.game.utils.a.c(AnchorInputBoxView.this) == null) {
                return;
            }
            SimpleEventBus.getInstance().dispatchEvent(new UserSelfSendMsgEvent(AnchorInputBoxView.this.roomId));
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onUserForbid(@Nullable String msg2) {
            AnchorInputBoxView.this.aegisLog.e("ICGameAnchorInputBoxView_TIMI", "sendMessage onUserForbid, msg:" + msg2);
            AnchorInputBoxView.this.p0("\u8bc4\u8bba\u53d1\u8868\u5931\u8d25\uff0c\u9519\u8bef\u780110002");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorInputBoxView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final void g0(ArrayList<LiveMessageData.ExtData> extDatas) {
        LiveUserInfo selfUserInfo = ((fu0.c) qx0.a.b(fu0.c.class)).getSelfUserInfo();
        if (selfUserInfo != null) {
            com.tencent.icgame.game.liveroom.impl.room.util.k kVar = com.tencent.icgame.game.liveroom.impl.room.util.k.f115699a;
            if (kVar.e(this.roomId, selfUserInfo.uid)) {
                String str = "TOP_THREE_CROWN_UIN_" + selfUserInfo.uid + "_" + this.roomId;
                if (!rx0.a.b(str, false)) {
                    rx0.a.h(str, true);
                }
                LiveMessageData.ExtData extData = new LiveMessageData.ExtData();
                extData.mId = 100010;
                byte[] bytes = String.valueOf(kVar.c(this.roomId, selfUserInfo.uid)).getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                extData.mValue = bytes;
                extDatas.add(extData);
            }
        }
    }

    private final void h0() {
        final LiveUserInfo selfUserInfo = ((fu0.c) qx0.a.b(fu0.c.class)).getSelfUserInfo();
        if (selfUserInfo != null) {
            qw0.k.n(selfUserInfo.uid, this.roomId, new k.e() { // from class: com.tencent.icgame.liveroom.impl.room.widget.d
                @Override // qw0.k.e
                public final void onResult(boolean z16) {
                    AnchorInputBoxView.i0(AnchorInputBoxView.this, selfUserInfo, z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(AnchorInputBoxView this$0, LiveUserInfo this_run, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        if (z16) {
            j0(this$0, this_run);
        }
    }

    private static final void j0(AnchorInputBoxView anchorInputBoxView, LiveUserInfo liveUserInfo) {
        long j3 = anchorInputBoxView.roomId;
        String string = anchorInputBoxView.getContext().getString(R.string.f223686gw);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.room_admin_forbid)");
        Intrinsics.checkNotNullExpressionValue(liveUserInfo, "this");
        LiveLocalMsg liveLocalMsg = new LiveLocalMsg(j3, string, liveUserInfo);
        liveLocalMsg.setSendMsgAlienation(true);
        SimpleEventBus.getInstance().dispatchEvent(liveLocalMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(AnchorInputBoxView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.s() == 3) {
            this$0.P();
        } else {
            this$0.setState(3);
            FrameLayout funcLayout = this$0.getFuncLayout();
            if (funcLayout != null) {
                funcLayout.removeAllViews();
            }
            View n3 = TimiBaseInputView.n(this$0, Integer.valueOf(Color.parseColor("#0B0820")), 0, 2, null);
            FrameLayout funcLayout2 = this$0.getFuncLayout();
            if (funcLayout2 != null) {
                funcLayout2.addView(n3, new FrameLayout.LayoutParams(uu0.a.e(this$0), uu0.a.e(this$0)));
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(AnchorInputBoxView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.editText;
        if (editText != null) {
            editText.setEditableFactory(this$0.t());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(MessageOuterClass$TimMsgBody msgBody, String text) {
        this.aegisLog.i("ICGameAnchorInputBoxView_TIMI", "sendMsgReally:" + text);
        ArrayList<LiveMessageData.ExtData> arrayList = new ArrayList<>();
        LiveMessageData.ExtData extData = new LiveMessageData.ExtData();
        extData.mId = 100001;
        extData.mValue = PluginBaseInfoHelper.Base64Helper.encode(msgBody.toByteArray(), 2);
        arrayList.add(extData);
        g0(arrayList);
        h0();
        ILiveRoomOperation A = ((fu0.c) qx0.a.b(fu0.c.class)).A(this.roomId);
        if (A != null) {
            A.sendMessage(text, arrayList, new f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(AnchorInputBoxView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setState(1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(String toastContent) {
        if (this.qqToast == null) {
            QQToast qQToast = new QQToast(getContext());
            qQToast.setToastIcon(QQToast.getIconRes(1));
            qQToast.setType(1);
            qQToast.setDuration(0);
            this.qqToast = qQToast;
        }
        QQToast qQToast2 = this.qqToast;
        if (qQToast2 != null) {
            if (!qQToast2.isShowing() || !Intrinsics.areEqual(toastContent, this.lastToastContent)) {
                this.lastToastContent = toastContent;
                qQToast2.setToastMsg(toastContent);
                qQToast2.show();
            }
        }
    }

    @Override // du0.d
    @Nullable
    public EditText H() {
        return getEditText();
    }

    @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView
    public void J() {
        this.editText = (EditText) findViewById(R.id.dmu);
        this.sendView = findViewById(R.id.f83174iv);
        this.emojiBtn = findViewById(R.id.usz);
        FrameLayout funcLayout = getFuncLayout();
        if (funcLayout != null) {
            funcLayout.setBackgroundColor(Color.parseColor("#0B0820"));
        }
        View view = this.emojiBtn;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.liveroom.impl.room.widget.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AnchorInputBoxView.k0(AnchorInputBoxView.this, view2);
                }
            });
        }
        EditText editText = this.editText;
        if (editText != null) {
            editText.post(new Runnable() { // from class: com.tencent.icgame.liveroom.impl.room.widget.c
                @Override // java.lang.Runnable
                public final void run() {
                    AnchorInputBoxView.l0(AnchorInputBoxView.this);
                }
            });
        }
        EditText editText2 = this.editText;
        if (editText2 != null) {
            editText2.setFilters(new c[]{new c()});
        }
        EditText editText3 = this.editText;
        if (editText3 != null) {
            editText3.addTextChangedListener(new d());
        }
        f(new e());
        e0();
        EditText editText4 = this.editText;
        Intrinsics.checkNotNull(editText4, "null cannot be cast to non-null type java.lang.Object");
        VideoReport.setElementId(editText4, "em_icgame_inputpanel_box");
        VideoReport.setLogicParent(this.editText, this.sendView);
    }

    public void e0() {
        f(new b());
    }

    @Nullable
    /* renamed from: f0, reason: from getter */
    public View getEmojiBtn() {
        return this.emojiBtn;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(AnchorAtEvent.class);
        arrayList.add(AnchorInputEvent.class);
        return arrayList;
    }

    @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView
    protected void j(@NotNull View view) {
        Map<String, String> mutableMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("clck", view, new LinkedHashMap());
        ru0.a aVar = (ru0.a) qx0.a.b(ru0.a.class);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(DTParamKey.REPORT_KEY_SUBMIT_WAY, "2"), TuplesKt.to(DTParamKey.REPORT_KEY_SUBMIT_TYPE, DTConstants.KeyBoardAction.ACTION_SEND));
        aVar.reportEvent(DTEventKey.SUBMIT, view, mutableMapOf);
    }

    protected final void o0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qqLiveSendMessage = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent p06) {
        boolean z16 = false;
        if (p06 instanceof AnchorAtEvent) {
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
            AnchorAtEvent anchorAtEvent = (AnchorAtEvent) p06;
            commonOuterClass$QQUserId.uid.set(anchorAtEvent.getLiveUserInfo().uid);
            String str = anchorAtEvent.getLiveUserInfo().nick;
            if (str == null || str.length() == 0) {
                z16 = true;
            }
            if (!z16) {
                du0.e eVar = du0.e.f394864a;
                String quickTip = anchorAtEvent.getQuickTip();
                String str2 = anchorAtEvent.getLiveUserInfo().headUrl;
                Intrinsics.checkNotNullExpressionValue(str2, "p0.liveUserInfo.headUrl");
                eVar.d(commonOuterClass$QQUserId, str, this, quickTip, str2, this.roomId);
            }
            if (anchorAtEvent.getFromPlayTogether()) {
                this.qqLiveSendMessage = "2";
                return;
            }
            return;
        }
        if (p06 instanceof AnchorInputEvent) {
            AnchorInputEvent anchorInputEvent = (AnchorInputEvent) p06;
            if (this.roomId != anchorInputEvent.getRoomId()) {
                return;
            }
            setVisibility(0);
            P();
            if (anchorInputEvent.getFromPlayTogether()) {
                this.qqLiveSendMessage = "1";
            }
        }
    }

    public final void setClickDelegate(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.clickDelegateView = view;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.liveroom.impl.room.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AnchorInputBoxView.n0(AnchorInputBoxView.this, view2);
            }
        });
    }

    @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView
    public void setState(int state) {
        getCurrentState();
        super.setState(state);
    }

    @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView
    @Nullable
    /* renamed from: w, reason: from getter */
    public EditText getEditText() {
        return this.editText;
    }

    @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView
    public int x() {
        return R.layout.fbk;
    }

    @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView
    @Nullable
    /* renamed from: z, reason: from getter */
    public View getSendView() {
        return this.sendView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorInputBoxView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ AnchorInputBoxView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorInputBoxView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.qqLiveSendMessage = "0";
        this.lastToastContent = "";
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLog = (IAegisLogApi) api;
        setClickable(true);
    }

    @Override // du0.d
    @Nullable
    public TimiBaseInputView F() {
        return this;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/icgame/liveroom/impl/room/widget/AnchorInputBoxView$d", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            boolean z16;
            View view = AnchorInputBoxView.this.sendView;
            if (view != null) {
                boolean z17 = false;
                if (s16 != null) {
                    if (s16.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        z17 = true;
                    }
                }
                view.setEnabled(z17);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        }
    }
}
