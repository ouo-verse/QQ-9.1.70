package com.tencent.timi.game.liveroom.impl.room.notice;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001BB\u001f\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u0016\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J)\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001e\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010&\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0016\u0010(\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010!R\u0016\u0010*\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010!R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010-R\u0016\u00105\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010-R+\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u001f06j\b\u0012\u0004\u0012\u00020\u001f`78BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\u00a8\u0006C"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/notice/TimiMessagePushDialog;", "Lcom/tencent/timi/game/ui/widget/BaseSlideUpDialog;", "Landroid/view/View$OnClickListener;", "", "initViews", "H0", "y0", "B0", "I0", "", "eventId", "", "isExpose", "isSwitchOn", "w0", "(Ljava/lang/String;ZLjava/lang/Boolean;)V", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "", "T", "J", "getRoomId", "()J", "roomId", "U", "getAnchorId", "anchorId", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "V", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "messagePushSwitchBtn", "W", "messageCommentSwitchBtn", "X", "messageGiftSwitchBtn", "Y", "messageEnterRoomSwitchBtn", "Z", "messageFollowSwitchBtn", "Landroid/widget/RelativeLayout;", "a0", "Landroid/widget/RelativeLayout;", "messagePushContainer", "b0", "Landroid/view/View;", "pushMessageDialogShadow", "c0", "pushMessageDialogPart", "d0", "tgLiveSubSwitch", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e0", "Lkotlin/Lazy;", "x0", "()Ljava/util/ArrayList;", "btnList", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;JJ)V", "f0", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TimiMessagePushDialog extends BaseSlideUpDialog implements View.OnClickListener {

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private final long roomId;

    /* renamed from: U, reason: from kotlin metadata */
    private final long anchorId;

    /* renamed from: V, reason: from kotlin metadata */
    private FormSwitchItem messagePushSwitchBtn;

    /* renamed from: W, reason: from kotlin metadata */
    private FormSwitchItem messageCommentSwitchBtn;

    /* renamed from: X, reason: from kotlin metadata */
    private FormSwitchItem messageGiftSwitchBtn;

    /* renamed from: Y, reason: from kotlin metadata */
    private FormSwitchItem messageEnterRoomSwitchBtn;

    /* renamed from: Z, reason: from kotlin metadata */
    private FormSwitchItem messageFollowSwitchBtn;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout messagePushContainer;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private View pushMessageDialogShadow;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout pushMessageDialogPart;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout tgLiveSubSwitch;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy btnList;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\tR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/notice/TimiMessagePushDialog$a;", "", "Landroid/content/Context;", "context", "", "roomId", "anchorId", "", "f", "", "a", "b", "e", "c", "d", "", "BTN_BACKGROUND_COLOR", "Ljava/lang/String;", "TAG", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.notice.TimiMessagePushDialog$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            boolean c16 = ct3.a.c("MMKV_KEY_PUSH_MESSAGE_STATUS");
            QLog.d("TimiMessagePushDialog", 1, "hasOpenPushMessage: " + c16);
            return c16;
        }

        public final boolean b() {
            boolean c16 = ct3.a.c("MMKV_KEY_COMMENT_MESSAGE_STATUS");
            QLog.d("TimiMessagePushDialog", 1, "needShowCommentMessage: " + c16);
            return c16;
        }

        public final boolean c() {
            boolean c16 = ct3.a.c("MMKV_KEY_ENTER_ROOM_MESSAGE_STATUS");
            QLog.d("TimiMessagePushDialog", 1, "needShowEnterRoomMessage: " + c16);
            return c16;
        }

        public final boolean d() {
            QLog.d("TimiMessagePushDialog", 1, "needShowFollowMessage: " + ct3.a.c("MMKV_KEY_FOLLOW_MESSAGE_STATUS"));
            return ct3.a.c("MMKV_KEY_FOLLOW_MESSAGE_STATUS");
        }

        public final boolean e() {
            boolean c16 = ct3.a.c("MMKV_KEY_GIFT_MESSAGE_STATUS");
            QLog.d("TimiMessagePushDialog", 1, "needShowGiftMessage: " + c16);
            return c16;
        }

        public final void f(@NotNull Context context, long roomId, long anchorId) {
            Intrinsics.checkNotNullParameter(context, "context");
            new TimiMessagePushDialog(context, roomId, anchorId).show();
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimiMessagePushDialog(@NotNull Context context, long j3, long j16) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.roomId = j3;
        this.anchorId = j16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<FormSwitchItem>>() { // from class: com.tencent.timi.game.liveroom.impl.room.notice.TimiMessagePushDialog$btnList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<FormSwitchItem> invoke() {
                FormSwitchItem formSwitchItem;
                FormSwitchItem formSwitchItem2;
                FormSwitchItem formSwitchItem3;
                FormSwitchItem formSwitchItem4;
                FormSwitchItem formSwitchItem5;
                ArrayList<FormSwitchItem> arrayList = new ArrayList<>();
                TimiMessagePushDialog timiMessagePushDialog = TimiMessagePushDialog.this;
                formSwitchItem = timiMessagePushDialog.messagePushSwitchBtn;
                FormSwitchItem formSwitchItem6 = null;
                if (formSwitchItem == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("messagePushSwitchBtn");
                    formSwitchItem = null;
                }
                arrayList.add(formSwitchItem);
                formSwitchItem2 = timiMessagePushDialog.messageCommentSwitchBtn;
                if (formSwitchItem2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("messageCommentSwitchBtn");
                    formSwitchItem2 = null;
                }
                arrayList.add(formSwitchItem2);
                formSwitchItem3 = timiMessagePushDialog.messageGiftSwitchBtn;
                if (formSwitchItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("messageGiftSwitchBtn");
                    formSwitchItem3 = null;
                }
                arrayList.add(formSwitchItem3);
                formSwitchItem4 = timiMessagePushDialog.messageEnterRoomSwitchBtn;
                if (formSwitchItem4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("messageEnterRoomSwitchBtn");
                    formSwitchItem4 = null;
                }
                arrayList.add(formSwitchItem4);
                formSwitchItem5 = timiMessagePushDialog.messageFollowSwitchBtn;
                if (formSwitchItem5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("messageFollowSwitchBtn");
                } else {
                    formSwitchItem6 = formSwitchItem5;
                }
                arrayList.add(formSwitchItem6);
                return arrayList;
            }
        });
        this.btnList = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(TimiMessagePushDialog this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = 0;
        this$0.w0("ev_qqlive_pushmessage_main", false, Boolean.valueOf(z16));
        Iterator<T> it = this$0.x0().iterator();
        while (it.hasNext()) {
            ((FormSwitchItem) it.next()).setChecked(z16);
        }
        RelativeLayout relativeLayout = this$0.tgLiveSubSwitch;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tgLiveSubSwitch");
            relativeLayout = null;
        }
        if (!z16) {
            i3 = 8;
        }
        relativeLayout.setVisibility(i3);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void B0() {
        int i3;
        FormSwitchItem formSwitchItem = this.messageCommentSwitchBtn;
        FormSwitchItem formSwitchItem2 = null;
        if (formSwitchItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageCommentSwitchBtn");
            formSwitchItem = null;
        }
        formSwitchItem.setChecked(ct3.a.c("MMKV_KEY_COMMENT_MESSAGE_STATUS"));
        FormSwitchItem formSwitchItem3 = this.messageGiftSwitchBtn;
        if (formSwitchItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageGiftSwitchBtn");
            formSwitchItem3 = null;
        }
        formSwitchItem3.setChecked(ct3.a.c("MMKV_KEY_GIFT_MESSAGE_STATUS"));
        FormSwitchItem formSwitchItem4 = this.messageEnterRoomSwitchBtn;
        if (formSwitchItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageEnterRoomSwitchBtn");
            formSwitchItem4 = null;
        }
        formSwitchItem4.setChecked(ct3.a.c("MMKV_KEY_ENTER_ROOM_MESSAGE_STATUS"));
        FormSwitchItem formSwitchItem5 = this.messageFollowSwitchBtn;
        if (formSwitchItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageFollowSwitchBtn");
            formSwitchItem5 = null;
        }
        formSwitchItem5.setChecked(ct3.a.c("MMKV_KEY_FOLLOW_MESSAGE_STATUS"));
        FormSwitchItem formSwitchItem6 = this.messagePushSwitchBtn;
        if (formSwitchItem6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messagePushSwitchBtn");
            formSwitchItem6 = null;
        }
        formSwitchItem6.setChecked(ct3.a.c("MMKV_KEY_PUSH_MESSAGE_STATUS"));
        RelativeLayout relativeLayout = this.tgLiveSubSwitch;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tgLiveSubSwitch");
            relativeLayout = null;
        }
        FormSwitchItem formSwitchItem7 = this.messagePushSwitchBtn;
        if (formSwitchItem7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messagePushSwitchBtn");
            formSwitchItem7 = null;
        }
        if (formSwitchItem7.isChecked()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        relativeLayout.setVisibility(i3);
        FormSwitchItem formSwitchItem8 = this.messagePushSwitchBtn;
        if (formSwitchItem8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messagePushSwitchBtn");
            formSwitchItem8 = null;
        }
        w0("ev_qqlive_pushmessage_main", true, Boolean.valueOf(formSwitchItem8.isChecked()));
        FormSwitchItem formSwitchItem9 = this.messageCommentSwitchBtn;
        if (formSwitchItem9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageCommentSwitchBtn");
            formSwitchItem9 = null;
        }
        w0("ev_qqlive_pushmessage_note", true, Boolean.valueOf(formSwitchItem9.isChecked()));
        FormSwitchItem formSwitchItem10 = this.messageGiftSwitchBtn;
        if (formSwitchItem10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageGiftSwitchBtn");
            formSwitchItem10 = null;
        }
        w0("ev_qqlive_pushmessage_gift", true, Boolean.valueOf(formSwitchItem10.isChecked()));
        FormSwitchItem formSwitchItem11 = this.messageEnterRoomSwitchBtn;
        if (formSwitchItem11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageEnterRoomSwitchBtn");
            formSwitchItem11 = null;
        }
        w0("ev_qqlive_pushmessage_joinroom", true, Boolean.valueOf(formSwitchItem11.isChecked()));
        FormSwitchItem formSwitchItem12 = this.messageFollowSwitchBtn;
        if (formSwitchItem12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageFollowSwitchBtn");
            formSwitchItem12 = null;
        }
        w0("ev_qqlive_pushmessage_follow", true, Boolean.valueOf(formSwitchItem12.isChecked()));
        FormSwitchItem formSwitchItem13 = this.messageCommentSwitchBtn;
        if (formSwitchItem13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageCommentSwitchBtn");
            formSwitchItem13 = null;
        }
        formSwitchItem13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.timi.game.liveroom.impl.room.notice.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                TimiMessagePushDialog.C0(TimiMessagePushDialog.this, compoundButton, z16);
            }
        });
        FormSwitchItem formSwitchItem14 = this.messageGiftSwitchBtn;
        if (formSwitchItem14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageGiftSwitchBtn");
            formSwitchItem14 = null;
        }
        formSwitchItem14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.timi.game.liveroom.impl.room.notice.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                TimiMessagePushDialog.D0(TimiMessagePushDialog.this, compoundButton, z16);
            }
        });
        FormSwitchItem formSwitchItem15 = this.messageEnterRoomSwitchBtn;
        if (formSwitchItem15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageEnterRoomSwitchBtn");
            formSwitchItem15 = null;
        }
        formSwitchItem15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.timi.game.liveroom.impl.room.notice.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                TimiMessagePushDialog.E0(TimiMessagePushDialog.this, compoundButton, z16);
            }
        });
        FormSwitchItem formSwitchItem16 = this.messageFollowSwitchBtn;
        if (formSwitchItem16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageFollowSwitchBtn");
        } else {
            formSwitchItem2 = formSwitchItem16;
        }
        formSwitchItem2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.timi.game.liveroom.impl.room.notice.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                TimiMessagePushDialog.F0(TimiMessagePushDialog.this, compoundButton, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(TimiMessagePushDialog this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w0("ev_qqlive_pushmessage_note", false, Boolean.valueOf(z16));
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(TimiMessagePushDialog this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w0("ev_qqlive_pushmessage_gift", false, Boolean.valueOf(z16));
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(TimiMessagePushDialog this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w0("ev_qqlive_pushmessage_joinroom", false, Boolean.valueOf(z16));
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(TimiMessagePushDialog this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w0("ev_qqlive_pushmessage_follow", false, Boolean.valueOf(z16));
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void H0() {
        Iterator<T> it = x0().iterator();
        while (it.hasNext()) {
            ((FormSwitchItem) it.next()).setBackgroundColor(Color.parseColor("#05001F"));
        }
        Drawable drawable = ContextCompat.getDrawable(this.G, R.drawable.not);
        for (FormSwitchItem formSwitchItem : x0()) {
            formSwitchItem.getSwitch().setThumbDrawable(drawable);
            formSwitchItem.getSwitch().setTrackDrawable(ContextCompat.getDrawable(this.G, R.drawable.l3t));
        }
    }

    private final void I0() {
        FormSwitchItem formSwitchItem = this.messagePushSwitchBtn;
        FormSwitchItem formSwitchItem2 = null;
        if (formSwitchItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messagePushSwitchBtn");
            formSwitchItem = null;
        }
        ct3.a.o("MMKV_KEY_PUSH_MESSAGE_STATUS", formSwitchItem.isChecked());
        FormSwitchItem formSwitchItem3 = this.messageCommentSwitchBtn;
        if (formSwitchItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageCommentSwitchBtn");
            formSwitchItem3 = null;
        }
        ct3.a.o("MMKV_KEY_COMMENT_MESSAGE_STATUS", formSwitchItem3.isChecked());
        FormSwitchItem formSwitchItem4 = this.messageGiftSwitchBtn;
        if (formSwitchItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageGiftSwitchBtn");
            formSwitchItem4 = null;
        }
        ct3.a.o("MMKV_KEY_GIFT_MESSAGE_STATUS", formSwitchItem4.isChecked());
        FormSwitchItem formSwitchItem5 = this.messageEnterRoomSwitchBtn;
        if (formSwitchItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageEnterRoomSwitchBtn");
            formSwitchItem5 = null;
        }
        ct3.a.o("MMKV_KEY_ENTER_ROOM_MESSAGE_STATUS", formSwitchItem5.isChecked());
        FormSwitchItem formSwitchItem6 = this.messageFollowSwitchBtn;
        if (formSwitchItem6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageFollowSwitchBtn");
            formSwitchItem6 = null;
        }
        ct3.a.o("MMKV_KEY_FOLLOW_MESSAGE_STATUS", formSwitchItem6.isChecked());
        FormSwitchItem formSwitchItem7 = this.messagePushSwitchBtn;
        if (formSwitchItem7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messagePushSwitchBtn");
            formSwitchItem7 = null;
        }
        boolean isChecked = formSwitchItem7.isChecked();
        FormSwitchItem formSwitchItem8 = this.messageCommentSwitchBtn;
        if (formSwitchItem8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageCommentSwitchBtn");
            formSwitchItem8 = null;
        }
        boolean isChecked2 = formSwitchItem8.isChecked();
        FormSwitchItem formSwitchItem9 = this.messageGiftSwitchBtn;
        if (formSwitchItem9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageGiftSwitchBtn");
            formSwitchItem9 = null;
        }
        boolean isChecked3 = formSwitchItem9.isChecked();
        FormSwitchItem formSwitchItem10 = this.messageEnterRoomSwitchBtn;
        if (formSwitchItem10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageEnterRoomSwitchBtn");
            formSwitchItem10 = null;
        }
        boolean isChecked4 = formSwitchItem10.isChecked();
        FormSwitchItem formSwitchItem11 = this.messageFollowSwitchBtn;
        if (formSwitchItem11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageFollowSwitchBtn");
        } else {
            formSwitchItem2 = formSwitchItem11;
        }
        QLog.d("TimiMessagePushDialog", 1, "btn status: messagePushSwitchBtn" + isChecked + ", messageCommentSwitchBtn" + isChecked2 + "messageGiftSwitchBtn" + isChecked3 + "messageEnterRoomSwitchBtn" + isChecked4 + "messageFollowSwitchBtn" + formSwitchItem2.isChecked());
    }

    private final void initViews() {
        RelativeLayout relativeLayout = this.messagePushContainer;
        View view = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messagePushContainer");
            relativeLayout = null;
        }
        e0(relativeLayout);
        View view2 = this.pushMessageDialogShadow;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pushMessageDialogShadow");
        } else {
            view = view2;
        }
        g0(view);
        H0();
    }

    private final void w0(String eventId, boolean isExpose, Boolean isSwitchOn) {
        Object obj;
        ug4.a aVar = (ug4.a) mm4.b.b(ug4.a.class);
        HashMap hashMap = new HashMap();
        String str = "0";
        if (isExpose) {
            obj = "0";
        } else {
            obj = "1";
        }
        hashMap.put("qqlive_action_type", obj);
        hashMap.put("qqlive_anchor_id", String.valueOf(this.anchorId));
        hashMap.put("qqlive_room_id", String.valueOf(this.roomId));
        if (isSwitchOn != null) {
            if (isSwitchOn.booleanValue()) {
                str = "1";
            }
            hashMap.put("qqlive_switch_status", str);
        }
        Unit unit = Unit.INSTANCE;
        aVar.reportEvent(eventId, hashMap);
    }

    private final ArrayList<FormSwitchItem> x0() {
        return (ArrayList) this.btnList.getValue();
    }

    private final void y0() {
        View view = this.pushMessageDialogShadow;
        FormSwitchItem formSwitchItem = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pushMessageDialogShadow");
            view = null;
        }
        view.setOnClickListener(this);
        RelativeLayout relativeLayout = this.pushMessageDialogPart;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pushMessageDialogPart");
            relativeLayout = null;
        }
        relativeLayout.setOnClickListener(this);
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.timi.game.liveroom.impl.room.notice.f
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                TimiMessagePushDialog.z0(TimiMessagePushDialog.this, dialogInterface);
            }
        });
        FormSwitchItem formSwitchItem2 = this.messagePushSwitchBtn;
        if (formSwitchItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messagePushSwitchBtn");
        } else {
            formSwitchItem = formSwitchItem2;
        }
        formSwitchItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.timi.game.liveroom.impl.room.notice.g
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                TimiMessagePushDialog.A0(TimiMessagePushDialog.this, compoundButton, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(TimiMessagePushDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        boolean z16 = false;
        if (v3 != null && v3.getId() == R.id.f29360lf) {
            z16 = true;
        }
        if (z16) {
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hux);
        View findViewById = findViewById(R.id.z5a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.messagePushSwitchBtn)");
        this.messagePushSwitchBtn = (FormSwitchItem) findViewById;
        View findViewById2 = findViewById(R.id.z55);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.messageCommentSwitchBtn)");
        this.messageCommentSwitchBtn = (FormSwitchItem) findViewById2;
        View findViewById3 = findViewById(R.id.z58);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.messageGiftSwitchBtn)");
        this.messageGiftSwitchBtn = (FormSwitchItem) findViewById3;
        View findViewById4 = findViewById(R.id.z56);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.messageEnterRoomSwitchBtn)");
        this.messageEnterRoomSwitchBtn = (FormSwitchItem) findViewById4;
        View findViewById5 = findViewById(R.id.z57);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.messageFollowSwitchBtn)");
        this.messageFollowSwitchBtn = (FormSwitchItem) findViewById5;
        View findViewById6 = findViewById(R.id.z5_);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.messagePushContainer)");
        this.messagePushContainer = (RelativeLayout) findViewById6;
        View findViewById7 = findViewById(R.id.f29360lf);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.pushMessageDialogShadow)");
        this.pushMessageDialogShadow = findViewById7;
        View findViewById8 = findViewById(R.id.f29350le);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.pushMessageDialogPart)");
        this.pushMessageDialogPart = (RelativeLayout) findViewById8;
        View findViewById9 = findViewById(R.id.f96025gk);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.tgLiveSubSwitch)");
        this.tgLiveSubSwitch = (RelativeLayout) findViewById9;
        initViews();
        y0();
        B0();
        w0("ev_qqlive_pushmessage", true, null);
    }
}
