package com.tencent.icgame.game.component.chat.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.LineHeightSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AtUser;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$YoloRoomActionMsg;
import com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YokoGameRoomSendNoticeAction;
import com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomAction;
import com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 92\u00020\u0001:\u0002:;B'\b\u0007\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00106\u001a\u000205\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017J\u0017\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0014\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010!\u001a\u00020\u00042\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eJ\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\b\u0010#\u001a\u00020\u0004H\u0014R\"\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u000fR\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u0006<"}, d2 = {"Lcom/tencent/icgame/game/component/chat/message/TextMessageItemView;", "Lcom/tencent/icgame/game/component/chat/message/BaseMessageView;", "Lcom/tencent/icgame/game/tim/api/message/a;", "msgId", "", "P", "msg", "N", "", "content", "M", "L", "", "isHost", "K", "J", "Lcom/tencent/icgame/trpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "it", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "G", "H", "O", "", "roomId", "setRoomId", "", "Lcom/tencent/icgame/game/component/chat/message/LongClickOperOption;", "l", "()[Lcom/tencent/icgame/game/component/chat/message/LongClickOperOption;", "", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$AtUser;", "data", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, NodeProps.ON_DETACHED_FROM_WINDOW, "", "c0", "Ljava/util/Map;", "atUserInfoMap", "Landroid/text/SpannableStringBuilder;", "d0", "Landroid/text/SpannableStringBuilder;", "spannable", "e0", "Landroid/widget/TextView;", "f0", "Landroid/widget/TextView;", "textView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "g0", "a", "b", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class TextMessageItemView extends BaseMessageView {

    /* renamed from: h0, reason: collision with root package name */
    private static final Bitmap f114960h0;

    /* renamed from: i0, reason: collision with root package name */
    @NotNull
    private static final by0.a f114961i0;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, CommonOuterClass$QQUserId> atUserInfoMap;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SpannableStringBuilder spannable;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView textView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ<\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/icgame/game/component/chat/message/TextMessageItemView$b;", "Landroid/text/style/LineHeightSpan;", "", "text", "", "start", "end", "spanstartv", NodeProps.LINE_HEIGHT, "Landroid/graphics/Paint$FontMetricsInt;", "fm", "", "chooseHeight", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements LineHeightSpan {
        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(@Nullable CharSequence text, int start, int end, int spanstartv, int lineHeight, @Nullable Paint.FontMetricsInt fm5) {
            int roundToInt;
            if (fm5 == null) {
                return;
            }
            if (start == 0) {
                fm5.descent += uu0.a.b(5);
                return;
            }
            int i3 = fm5.descent - fm5.ascent;
            if (i3 < 0) {
                return;
            }
            roundToInt = MathKt__MathJVMKt.roundToInt(fm5.descent * (uu0.a.d(14) / i3));
            fm5.descent = roundToInt;
            fm5.ascent = roundToInt - uu0.a.b(14);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/icgame/game/component/chat/message/TextMessageItemView$c", "Ldu0/a;", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "atUserId", "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements du0.a {
        c() {
        }

        @Override // du0.a
        public void a(@Nullable CommonOuterClass$QQUserId atUserId) {
            Long l3;
            QBaseActivity activity;
            PBUInt64Field pBUInt64Field;
            if (atUserId != null && (pBUInt64Field = atUserId.uid) != null) {
                l3 = Long.valueOf(pBUInt64Field.get());
            } else {
                l3 = null;
            }
            if (com.tencent.timi.game.utils.o.f("team_msg_click_" + l3, 300L)) {
                return;
            }
            TextMessageItemView.this.textView.performClick();
            if (atUserId != null && (activity = bu0.a.b()) != null) {
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/icgame/game/component/chat/message/TextMessageItemView$d", "Lcom/tencent/timi/game/ui/a;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class d extends com.tencent.timi.game.ui.a {
        d() {
        }

        @Override // com.tencent.timi.game.ui.a, android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
        }
    }

    static {
        Bitmap arrowBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.oaa), uu0.a.b(12), uu0.a.b(12), false);
        f114960h0 = arrowBitmap;
        Intrinsics.checkNotNullExpressionValue(arrowBitmap, "arrowBitmap");
        f114961i0 = new by0.a(arrowBitmap, uu0.a.b(1), uu0.a.b(1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextMessageItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void H(com.tencent.icgame.game.tim.api.message.a msg2) {
        int a16;
        Q(msg2.a().at_user_msg.user_list.get());
        String text = eu0.a.a(msg2.a().at_user_msg.text.get());
        this.spannable.clear();
        this.spannable.clearSpans();
        this.spannable.append((CharSequence) text);
        du0.e eVar = du0.e.f394864a;
        Intrinsics.checkNotNullExpressionValue(text, "text");
        Map<String, CommonOuterClass$QQUserId> map = this.atUserInfoMap;
        SpannableStringBuilder spannableStringBuilder = this.spannable;
        j();
        if (msg2.b()) {
            a16 = cy0.b.a(R.color.f158017al3);
        } else {
            a16 = cy0.b.a(R.color.f158017al3);
        }
        eVar.c(0, text, map, spannableStringBuilder, a16, false, new c());
        this.textView.setText(new QQText(this.spannable, 3, 20));
        this.textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.component.chat.message.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextMessageItemView.I(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.icgame.game.utils.g.h("TextMessageView", "em_yes_chat_at_msg click");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void J(com.tencent.icgame.game.tim.api.message.a msg2) {
        String str = msg2.a().text_msg.text.get();
        TextView textView = this.textView;
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new d(), str.length() - 4, str.length(), 33);
        j();
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#F5A300")), str.length() - 4, str.length() - 1, 33);
        j();
        spannableString.setSpan(f114961i0, str.length() - 1, str.length(), 33);
        textView.setText(spannableString);
    }

    private final void K(boolean isHost) {
        YoloRoomOuterClass$YoloRoomInfo roomInfo = getRoomInfo();
        if (roomInfo != null) {
            CommonOuterClass$QQUserId qqUserId = roomInfo.owner_user_id;
            Intrinsics.checkNotNullExpressionValue(qqUserId, "qqUserId");
            G(roomInfo, qqUserId, isHost);
        }
    }

    private final void M(String content) {
        String a16 = eu0.a.a("\u3010\u623f\u95f4\u516c\u544a\u3011\n" + content);
        TextView textView = this.textView;
        QQText qQText = new QQText(a16, 3, 20);
        qQText.setSpan(new b(), 0, qQText.length(), 33);
        textView.setText(qQText);
    }

    private final void N(com.tencent.icgame.game.tim.api.message.a msg2) {
        this.textView.setText(new QQText(eu0.a.a(msg2.a().text_msg.text.get()), 3, 20));
    }

    private final void O(com.tencent.icgame.game.tim.api.message.a msg2) {
        this.textView.setText(msg2.g());
        if (tu0.a.e()) {
            int i3 = msg2.a().yolo_room_action_msg.yolo_room_action.action_type.get();
            this.textView.setText("\u8c03\u8bd5\u5c55\u793a\uff1a\u4e0d\u652f\u6301\u6d88\u606f\u7c7b\u578btype[" + msg2.type() + "], actionType[" + i3 + "]");
        }
        com.tencent.icgame.game.utils.g.a("TextMessageViewDebug", "not support type " + msg2.type());
    }

    private final void P(com.tencent.icgame.game.tim.api.message.a msgId) {
        if (msgId != null) {
            du0.b.INSTANCE.a().b(String.valueOf(msgId.j()), msgId.id());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.icgame.game.component.chat.message.BaseMessageView
    public void A(@NotNull com.tencent.icgame.game.tim.api.message.a msg2) {
        String str;
        YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction;
        YoloRoomOuterClass$YokoGameRoomSendNoticeAction yoloRoomOuterClass$YokoGameRoomSendNoticeAction;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        super.A(msg2);
        j();
        int type = msg2.type();
        if (type == 49) {
            if (eu0.b.a(msg2) == 153) {
                MessageOuterClass$YoloRoomActionMsg messageOuterClass$YoloRoomActionMsg = msg2.a().yolo_room_action_msg;
                if (messageOuterClass$YoloRoomActionMsg != null && (yoloRoomOuterClass$YoloRoomAction = messageOuterClass$YoloRoomActionMsg.yolo_room_action) != null && (yoloRoomOuterClass$YokoGameRoomSendNoticeAction = yoloRoomOuterClass$YoloRoomAction.yolo_game_room_send_notice_action) != null && (pBStringField = yoloRoomOuterClass$YokoGameRoomSendNoticeAction.notice) != null) {
                    str = pBStringField.get();
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                M(str);
            }
        } else if (type == 1) {
            N(msg2);
        } else if (type == xx0.e.d()) {
            L(msg2);
        } else if (type == 70) {
            H(msg2);
        } else if (type == xx0.e.b()) {
            K(false);
        } else if (type == xx0.e.c()) {
            K(true);
        } else if (type == xx0.e.a()) {
            J(msg2);
        } else {
            O(msg2);
        }
        this.textView.setOnTouchListener(getPositionOnTouchListener());
        this.textView.setOnLongClickListener(getOnLongClickListner());
    }

    public final void Q(@Nullable List<MessageOuterClass$AtUser> data) {
        this.atUserInfoMap.clear();
        if (data != null) {
            for (MessageOuterClass$AtUser messageOuterClass$AtUser : data) {
                CommonOuterClass$QQUserId atUserId = messageOuterClass$AtUser.user_id.get();
                String atUserName = messageOuterClass$AtUser.nick_name.get();
                if (!TextUtils.isEmpty(atUserName)) {
                    Map<String, CommonOuterClass$QQUserId> map = this.atUserInfoMap;
                    Intrinsics.checkNotNullExpressionValue(atUserName, "atUserName");
                    Intrinsics.checkNotNullExpressionValue(atUserId, "atUserId");
                    map.put(atUserName, atUserId);
                }
            }
        }
        com.tencent.icgame.game.utils.g.h("TxtMsgView ", "atUserInfoMap =" + this.atUserInfoMap);
    }

    @Override // com.tencent.icgame.game.component.chat.message.BaseMessageView
    @Nullable
    protected LongClickOperOption[] l() {
        ArrayList arrayList = new ArrayList();
        com.tencent.icgame.game.tim.api.message.a msg2 = getMsg();
        if (msg2 != null) {
            if (msg2.type() == 1 || msg2.type() == 70) {
                arrayList.add(LongClickOperOption.COPY);
                if (!msg2.b()) {
                    arrayList.add(LongClickOperOption.REPORT);
                }
            }
            arrayList.add(LongClickOperOption.DELETE);
        }
        Object[] array = arrayList.toArray(new LongClickOperOption[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (LongClickOperOption[]) array;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.icgame.game.component.chat.message.BaseMessageView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.tencent.icgame.game.tim.api.message.a msg2 = getMsg();
        if (msg2 != null && msg2.i()) {
            P(msg2);
        }
    }

    public final void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextMessageItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TextMessageItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextMessageItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.atUserInfoMap = new LinkedHashMap();
        this.spannable = new SpannableStringBuilder();
        setContentView(R.layout.fc8);
        View findViewById = findViewById(R.id.jfo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.textView)");
        TextView textView = (TextView) findViewById;
        this.textView = textView;
        textView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final void L(com.tencent.icgame.game.tim.api.message.a msg2) {
    }

    private final void G(YoloRoomOuterClass$YoloRoomInfo it, CommonOuterClass$QQUserId qqUserId, boolean isHost) {
    }
}
