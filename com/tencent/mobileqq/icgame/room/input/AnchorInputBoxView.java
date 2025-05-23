package com.tencent.mobileqq.icgame.room.input;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
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
import com.tencent.icgame.game.liveroom.impl.room.anchor.GetSendMsgDataEvent;
import com.tencent.icgame.game.liveroom.impl.room.anchor.UserSelfSendMsgEvent;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$MsgContent;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$TextMsg;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$TimMsgBody;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.data.message.LiveMessageData;
import com.tencent.mobileqq.icgame.room.input.TimiBaseInputView;
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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qw0.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 %2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001TB'\b\u0007\u0012\u0006\u0010N\u001a\u00020M\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010O\u0012\b\b\u0002\u0010Q\u001a\u00020\u001a\u00a2\u0006\u0004\bR\u0010SJ\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J(\u0010\u000f\u001a\u001a\u0012\b\u0012\u00060\fR\u00020\r0\u000bj\f\u0012\b\u0012\u00060\fR\u00020\r`\u000e2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J(\u0010\u0013\u001a\u00020\t2\u001e\u0010\u0012\u001a\u001a\u0012\b\u0012\u00060\fR\u00020\r0\u000bj\f\u0012\b\u0012\u00060\fR\u00020\r`\u000eH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u000e\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010\"\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010#\u001a\u00020\tJ\b\u0010$\u001a\u00020\tH\u0016J\b\u0010%\u001a\u00020\tH\u0016J\b\u0010&\u001a\u00020\tH\u0014J\b\u0010'\u001a\u00020\tH\u0014J\u0012\u0010(\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010*\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030)0\u000bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030)`\u000eH\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010,\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0017H\u0014R\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R#\u0010E\u001a\n @*\u0004\u0018\u00010?0?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/input/AnchorInputBoxView;", "Lcom/tencent/mobileqq/icgame/room/input/TimiBaseInputView;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/icgame/room/input/h;", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$TimMsgBody;", "msgBody", "", "text", "", "o0", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/icgame/data/message/LiveMessageData$ExtData;", "Lcom/tencent/mobileqq/icgame/data/message/LiveMessageData;", "Lkotlin/collections/ArrayList;", "b0", "toastContent", "p0", "extDatas", "e0", "f0", "Landroid/widget/EditText;", "w", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "c0", "", HippyTKDListViewAdapter.X, "", MiniChatConstants.MINI_APP_LANDSCAPE, "m0", "", "roomId", "n0", "k0", "l0", "I", "a0", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "H", UserInfo.SEX_FEMALE, "view", "j", "N", "J", "P", "Landroid/widget/EditText;", "editText", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "sendView", BdhLogUtil.LogTag.Tag_Req, "emojiBtn", ExifInterface.LATITUDE_SOUTH, "Z", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "T", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "Lfu0/c;", "kotlin.jvm.PlatformType", "U", "Lkotlin/Lazy;", "d0", "()Lfu0/c;", "liveRoomService", "Lcom/tencent/mobileqq/widget/QQToast;", "V", "Lcom/tencent/mobileqq/widget/QQToast;", "qqToast", "W", "Ljava/lang/String;", "lastToastContent", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class AnchorInputBoxView extends TimiBaseInputView implements SimpleEventReceiver<SimpleBaseEvent>, h {

    /* renamed from: N, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private EditText editText;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private View sendView;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private View emojiBtn;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private IAegisLogApi mAegisLog;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy liveRoomService;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private QQToast qqToast;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private String lastToastContent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/icgame/room/input/AnchorInputBoxView$b", "Lcom/tencent/mobileqq/icgame/room/input/TimiBaseInputView$b;", "", "text", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$MsgContent;", "content", "Lcom/tencent/mobileqq/icgame/room/input/TimiBaseInputView;", "timiBaseInputView", "", "b", "a", "", "state", "onStateChanged", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements TimiBaseInputView.b {
        b() {
        }

        @Override // com.tencent.mobileqq.icgame.room.input.TimiBaseInputView.b
        public void a(@NotNull String text, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
        }

        @Override // com.tencent.mobileqq.icgame.room.input.TimiBaseInputView.b
        public void b(@NotNull String text, @NotNull MessageOuterClass$MsgContent content, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
        }

        @Override // com.tencent.mobileqq.icgame.room.input.TimiBaseInputView.b
        public void onStateChanged(int state) {
            if (AnchorInputBoxView.this.getPreState() == 1 || state != 1) {
                AnchorInputBoxView.this.getPreState();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J>\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/icgame/room/input/AnchorInputBoxView$c", "Landroid/text/InputFilter;", "", "source", "", "start", "end", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
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
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/icgame/room/input/AnchorInputBoxView$e", "Lcom/tencent/mobileqq/icgame/room/input/TimiBaseInputView$b;", "", "text", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$MsgContent;", "content", "Lcom/tencent/mobileqq/icgame/room/input/TimiBaseInputView;", "timiBaseInputView", "", "b", "a", "", "state", "onStateChanged", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class e implements TimiBaseInputView.b {
        e() {
        }

        @Override // com.tencent.mobileqq.icgame.room.input.TimiBaseInputView.b
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
            AnchorInputBoxView.this.o0(messageOuterClass$TimMsgBody, text);
            EditText editText = AnchorInputBoxView.this.editText;
            if (editText != null) {
                editText.setText("");
            }
            AnchorInputBoxView.this.setState(1);
        }

        @Override // com.tencent.mobileqq.icgame.room.input.TimiBaseInputView.b
        public void b(@NotNull String text, @NotNull MessageOuterClass$MsgContent content, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
            MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody();
            messageOuterClass$TimMsgBody.msg_type.set(70);
            messageOuterClass$TimMsgBody.content.set(content);
            AnchorInputBoxView.this.o0(messageOuterClass$TimMsgBody, text);
            EditText editText = AnchorInputBoxView.this.editText;
            if (editText != null) {
                editText.setText("");
            }
            AnchorInputBoxView.this.setState(1);
        }

        @Override // com.tencent.mobileqq.icgame.room.input.TimiBaseInputView.b
        public void onStateChanged(int state) {
            int i3;
            int i16;
            if (AnchorInputBoxView.this.isLandscape) {
                return;
            }
            AnchorInputBoxView anchorInputBoxView = AnchorInputBoxView.this;
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
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/icgame/room/input/AnchorInputBoxView$f", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQLiveMessageCallback;", "", "isLocal", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "onIllegalMsg", "msg", "onUserForbid", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class f implements IQQLiveMessageCallback {
        f() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            AnchorInputBoxView.this.mAegisLog.e("ICGameAnchorInputBoxView", "sendMessage onFail, errCode:" + errCode + ", errMsg:" + errMsg);
            AnchorInputBoxView anchorInputBoxView = AnchorInputBoxView.this;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u8bc4\u8bba\u53d1\u8868\u5931\u8d25\uff0c\u9519\u8bef\u7801");
            sb5.append(errCode);
            anchorInputBoxView.p0(sb5.toString());
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onIllegalMsg() {
            AnchorInputBoxView.this.mAegisLog.e("ICGameAnchorInputBoxView", "sendMessage onIllegalMsg");
            AnchorInputBoxView.this.p0("\u8bc4\u8bba\u53d1\u8868\u5931\u8d25\uff0c\u9519\u8bef\u780110003");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onSuccess(boolean isLocal) {
            AnchorInputBoxView.this.mAegisLog.i("ICGameAnchorInputBoxView", "sendMessage onSuccess, isLocal:" + isLocal);
            EditText editText = AnchorInputBoxView.this.editText;
            if (editText != null) {
                editText.setText("");
            }
            SimpleEventBus.getInstance().dispatchEvent(new UserSelfSendMsgEvent(AnchorInputBoxView.this.roomId));
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onUserForbid(@Nullable String msg2) {
            AnchorInputBoxView.this.mAegisLog.e("ICGameAnchorInputBoxView", "sendMessage onUserForbid, msg:" + msg2);
            AnchorInputBoxView.this.p0("\u8bc4\u8bba\u53d1\u8868\u5931\u8d25\uff0c\u9519\u8bef\u780110002");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorInputBoxView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final ArrayList<LiveMessageData.ExtData> b0(MessageOuterClass$TimMsgBody msgBody) {
        ArrayList<LiveMessageData.ExtData> arrayList = new ArrayList<>();
        LiveMessageData.ExtData extData = new LiveMessageData.ExtData();
        extData.mId = 100001;
        extData.mValue = PluginBaseInfoHelper.Base64Helper.encode(msgBody.toByteArray(), 2);
        arrayList.add(extData);
        e0(arrayList);
        return arrayList;
    }

    private final fu0.c d0() {
        return (fu0.c) this.liveRoomService.getValue();
    }

    private final void e0(ArrayList<LiveMessageData.ExtData> extDatas) {
        LiveUserInfo selfUserInfo = d0().getSelfUserInfo();
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

    private final void f0() {
        final LiveUserInfo selfUserInfo = d0().getSelfUserInfo();
        if (selfUserInfo != null) {
            qw0.k.n(selfUserInfo.uid, this.roomId, new k.e() { // from class: com.tencent.mobileqq.icgame.room.input.c
                @Override // qw0.k.e
                public final void onResult(boolean z16) {
                    AnchorInputBoxView.g0(AnchorInputBoxView.this, selfUserInfo, z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(AnchorInputBoxView this$0, LiveUserInfo this_run, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        if (z16) {
            h0(this$0, this_run);
        }
    }

    private static final void h0(AnchorInputBoxView anchorInputBoxView, LiveUserInfo liveUserInfo) {
        long j3 = anchorInputBoxView.roomId;
        String string = anchorInputBoxView.getContext().getString(R.string.f223686gw);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.room_admin_forbid)");
        Intrinsics.checkNotNullExpressionValue(liveUserInfo, "this");
        LiveLocalMsg liveLocalMsg = new LiveLocalMsg(j3, string, liveUserInfo);
        liveLocalMsg.setSendMsgAlienation(true);
        SimpleEventBus.getInstance().dispatchEvent(liveLocalMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(AnchorInputBoxView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getCurrentState() == 3) {
            this$0.O();
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
    public static final void j0(AnchorInputBoxView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.editText;
        if (editText != null) {
            editText.setEditableFactory(this$0.t());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(MessageOuterClass$TimMsgBody msgBody, String text) {
        this.mAegisLog.i("ICGameAnchorInputBoxView", "sendMsgReally:" + text);
        ArrayList<LiveMessageData.ExtData> b06 = b0(msgBody);
        f0();
        IAudienceRoom N = d0().N(this.roomId);
        if (N != null) {
            N.sendMessage(text, b06, new f());
        }
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

    @Override // com.tencent.mobileqq.icgame.room.input.h
    @Nullable
    public EditText H() {
        return getEditText();
    }

    @Override // com.tencent.mobileqq.icgame.room.input.TimiBaseInputView
    public void I() {
        this.editText = (EditText) findViewById(R.id.dmu);
        this.sendView = findViewById(R.id.f83174iv);
        this.emojiBtn = findViewById(R.id.usz);
        FrameLayout funcLayout = getFuncLayout();
        if (funcLayout != null) {
            funcLayout.setBackgroundColor(Color.parseColor("#0B0820"));
        }
        View view = this.emojiBtn;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.room.input.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AnchorInputBoxView.i0(AnchorInputBoxView.this, view2);
                }
            });
        }
        EditText editText = this.editText;
        if (editText != null) {
            editText.post(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.input.b
                @Override // java.lang.Runnable
                public final void run() {
                    AnchorInputBoxView.j0(AnchorInputBoxView.this);
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
        g(new e());
        a0();
        EditText editText4 = this.editText;
        Intrinsics.checkNotNull(editText4, "null cannot be cast to non-null type java.lang.Object");
        VideoReport.setElementId(editText4, "em_qqlive_inputpanel_box");
        VideoReport.setLogicParent(this.editText, this.sendView);
    }

    public void a0() {
        g(new b());
    }

    @Nullable
    /* renamed from: c0, reason: from getter */
    public View getEmojiBtn() {
        return this.emojiBtn;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(AnchorAtEvent.class);
        arrayList.add(GetSendMsgDataEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.icgame.room.input.TimiBaseInputView
    protected void j(@NotNull View view) {
        Map<String, String> mutableMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("clck", view, new LinkedHashMap());
        ru0.a aVar = (ru0.a) qx0.a.b(ru0.a.class);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(DTParamKey.REPORT_KEY_SUBMIT_WAY, "2"), TuplesKt.to(DTParamKey.REPORT_KEY_SUBMIT_TYPE, DTConstants.KeyBoardAction.ACTION_SEND));
        aVar.reportEvent(DTEventKey.SUBMIT, view, mutableMapOf);
    }

    public final void k0(long roomId) {
        this.roomId = roomId;
    }

    public final void l0() {
        this.roomId = 0L;
    }

    public final void m0(boolean isLandscape) {
        this.isLandscape = isLandscape;
    }

    public final void n0(long roomId) {
        this.roomId = roomId;
    }

    @Override // com.tencent.mobileqq.icgame.room.input.TimiBaseInputView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.mobileqq.icgame.room.input.TimiBaseInputView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent p06) {
        if (p06 instanceof AnchorAtEvent) {
            AnchorAtEvent anchorAtEvent = (AnchorAtEvent) p06;
            if (anchorAtEvent.getRoomId() != this.roomId) {
                return;
            }
            if (anchorAtEvent.getLiveUserInfo() == null) {
                this.mAegisLog.e("ICGameAnchorInputBoxView", "onReceiveEvent p0.liveUserInfo is null.");
                return;
            }
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
            commonOuterClass$QQUserId.uid.set(anchorAtEvent.getLiveUserInfo().uid);
            String str = anchorAtEvent.getLiveUserInfo().nick;
            if (!TextUtils.isEmpty(str)) {
                i iVar = i.f237649a;
                String str2 = anchorAtEvent.getLiveUserInfo().showNick;
                Intrinsics.checkNotNullExpressionValue(str2, "p0.liveUserInfo.showNick");
                String quickTip = anchorAtEvent.getQuickTip();
                String str3 = anchorAtEvent.getLiveUserInfo().headUrl;
                Intrinsics.checkNotNullExpressionValue(str3, "p0.liveUserInfo.headUrl");
                iVar.c(commonOuterClass$QQUserId, str, str2, this, quickTip, str3);
                return;
            }
            return;
        }
        if (p06 instanceof GetSendMsgDataEvent) {
            GetSendMsgDataEvent getSendMsgDataEvent = (GetSendMsgDataEvent) p06;
            MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody();
            messageOuterClass$TimMsgBody.msg_type.set(1);
            MessageOuterClass$MsgContent messageOuterClass$MsgContent = messageOuterClass$TimMsgBody.content;
            MessageOuterClass$MsgContent messageOuterClass$MsgContent2 = new MessageOuterClass$MsgContent();
            MessageOuterClass$TextMsg messageOuterClass$TextMsg = messageOuterClass$MsgContent2.text_msg;
            MessageOuterClass$TextMsg messageOuterClass$TextMsg2 = new MessageOuterClass$TextMsg();
            messageOuterClass$TextMsg2.text.set(getSendMsgDataEvent.getText());
            messageOuterClass$TextMsg.set(messageOuterClass$TextMsg2);
            messageOuterClass$MsgContent.set(messageOuterClass$MsgContent2);
            getSendMsgDataEvent.getExtDataList().addAll(b0(messageOuterClass$TimMsgBody));
        }
    }

    @Override // com.tencent.mobileqq.icgame.room.input.TimiBaseInputView
    @Nullable
    /* renamed from: w, reason: from getter */
    public EditText getEditText() {
        return this.editText;
    }

    @Override // com.tencent.mobileqq.icgame.room.input.TimiBaseInputView
    public int x() {
        return R.layout.fai;
    }

    @Override // com.tencent.mobileqq.icgame.room.input.TimiBaseInputView
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
        Lazy lazy;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<fu0.c>() { // from class: com.tencent.mobileqq.icgame.room.input.AnchorInputBoxView$liveRoomService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final fu0.c invoke() {
                return (fu0.c) qx0.a.b(fu0.c.class);
            }
        });
        this.liveRoomService = lazy;
        this.lastToastContent = "";
        setClickable(true);
    }

    @Override // com.tencent.mobileqq.icgame.room.input.h
    @Nullable
    public TimiBaseInputView F() {
        return this;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/icgame/room/input/AnchorInputBoxView$d", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
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
