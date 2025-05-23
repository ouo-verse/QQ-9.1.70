package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.timi.game.component.chat.message.MessageLayout;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010X\u001a\u00020W\u00a2\u0006\u0004\bY\u0010ZB\u001b\b\u0016\u0012\u0006\u0010X\u001a\u00020W\u0012\b\u0010\\\u001a\u0004\u0018\u00010[\u00a2\u0006\u0004\bY\u0010]B#\b\u0016\u0012\u0006\u0010X\u001a\u00020W\u0012\b\u0010\\\u001a\u0004\u0018\u00010[\u0012\u0006\u0010^\u001a\u00020\r\u00a2\u0006\u0004\bY\u0010_J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\u0017\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001c\u001a\u00020\u001bH\u0004J$\u0010\u001f\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010 \u001a\u00020\u0005H\u0014R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010(R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b!\u00101\"\u0004\b2\u00103R$\u0010:\u001a\u0004\u0018\u00010\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b'\u0010=\"\u0004\b>\u0010?R\"\u0010E\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010(\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010LR\"\u0010V\u001a\u00020O8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U\u00a8\u0006`"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/CenterMessageView;", "Lcom/tencent/timi/game/component/chat/message/TouchPositionGetableRelativeLayout;", "Lcom/tencent/timi/game/component/chat/message/o;", "Lcom/tencent/timi/game/component/chat/message/n;", "listener", "", "setMessageListener", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "roomInfo", "setYoloRoomInfo", "Landroid/view/View;", "view", "setContentView", "", "layoutResID", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$a;", "iThemeConfig", "setThemeConfig", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "selfUserId", "k", "", "Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "g", "()[Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "", "i", "qqUserId", "preMsg", "a", NodeProps.ON_DETACHED_FROM_WINDOW, "f", "Lcom/tencent/timi/game/tim/api/message/a;", "getMsg", "()Lcom/tencent/timi/game/tim/api/message/a;", "setMsg", "(Lcom/tencent/timi/game/tim/api/message/a;)V", tl.h.F, "I", "lastPointerRawX", "lastPointerRawY", "Lcom/tencent/timi/game/component/chat/message/ac;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/timi/game/component/chat/message/ac;", "messageViewOperator", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/timi/game/component/chat/message/MessageLayout$a;", "()Lcom/tencent/timi/game/component/chat/message/MessageLayout$a;", "setIThemeConfig", "(Lcom/tencent/timi/game/component/chat/message/MessageLayout$a;)V", "D", "Lcom/tencent/timi/game/component/chat/message/n;", "e", "()Lcom/tencent/timi/game/component/chat/message/n;", "setIMessageListener", "(Lcom/tencent/timi/game/component/chat/message/n;)V", "iMessageListener", "E", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "()Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "setRoomInfo", "(Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;)V", UserInfo.SEX_FEMALE, "getPosition", "()I", "setPosition", "(I)V", "position", "Landroid/widget/FrameLayout;", "G", "Landroid/widget/FrameLayout;", "contentContainer", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "timeView", "revokeView", "Landroid/view/View$OnLongClickListener;", "J", "Landroid/view/View$OnLongClickListener;", "getOnLongClickListner", "()Landroid/view/View$OnLongClickListener;", "setOnLongClickListner", "(Landroid/view/View$OnLongClickListener;)V", "onLongClickListner", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class CenterMessageView extends TouchPositionGetableRelativeLayout implements o {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private MessageLayout.a iThemeConfig;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private n iMessageListener;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private YoloRoomOuterClass$YoloRoomInfo roomInfo;

    /* renamed from: F, reason: from kotlin metadata */
    private int position;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private FrameLayout contentContainer;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private TextView timeView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private TextView revokeView;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private View.OnLongClickListener onLongClickListner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.timi.game.tim.api.message.a msg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int lastPointerRawX;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int lastPointerRawY;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ac messageViewOperator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CenterMessageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.messageViewOperator = new ac();
        setClipChildren(false);
        setClipToPadding(false);
        View.inflate(getContext(), R.layout.hto, this);
        View findViewById = findViewById(R.id.b9n);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.contentContainer)");
        this.contentContainer = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.jlc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.timeView)");
        this.timeView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f73773ug);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.revokeView)");
        this.revokeView = (TextView) findViewById3;
        this.contentContainer.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.timi.game.component.chat.message.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean d16;
                d16 = CenterMessageView.d(CenterMessageView.this, view, motionEvent);
                return d16;
            }
        });
        this.onLongClickListner = new View.OnLongClickListener() { // from class: com.tencent.timi.game.component.chat.message.j
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean j3;
                j3 = CenterMessageView.j(CenterMessageView.this, view);
                return j3;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(CenterMessageView this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.lastPointerRawX = (int) motionEvent.getRawX();
        this$0.lastPointerRawY = (int) motionEvent.getRawY();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(CenterMessageView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.messageViewOperator.g(this$0.getContext(), this$0.msg, this$0.g(), this$0.lastPointerRawX, this$0.lastPointerRawY);
        return true;
    }

    @Override // com.tencent.timi.game.component.chat.message.o
    public void a(@Nullable CommonOuterClass$QQUserId qqUserId, @NotNull com.tencent.timi.game.tim.api.message.a msg2, @Nullable com.tencent.timi.game.tim.api.message.a preMsg) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.msg = msg2;
        MessageLayout.a aVar = this.iThemeConfig;
        if (aVar != null) {
            this.timeView.setTextColor(aVar.c());
            this.revokeView.setTextColor(aVar.c());
        }
        if (i() && (preMsg == null || Math.abs(msg2.time() - preMsg.time()) > 180000)) {
            fh4.g.o(this.timeView, true);
            this.timeView.setText(yn4.d.b(msg2.time()));
        } else {
            fh4.g.o(this.timeView, false);
        }
        if (msg2.h() == MsgStatus.REVOKE) {
            fh4.g.o(this.contentContainer, false);
            this.revokeView.setText("\u6d88\u606f\u5df2\u88ab\u64a4\u56de");
        } else {
            fh4.g.o(this.revokeView, false);
            fh4.g.o(this.contentContainer, true);
            k(msg2, qqUserId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: e, reason: from getter */
    public final n getIMessageListener() {
        return this.iMessageListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: f, reason: from getter */
    public final MessageLayout.a getIThemeConfig() {
        return this.iThemeConfig;
    }

    @Nullable
    protected LongClickOperOption[] g() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: h, reason: from getter */
    public final YoloRoomOuterClass$YoloRoomInfo getRoomInfo() {
        return this.roomInfo;
    }

    protected final boolean i() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(@NotNull com.tencent.timi.game.tim.api.message.a msg2, @Nullable CommonOuterClass$QQUserId selfUserId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        LongClickOperOption[] g16 = g();
        if (g16 != null) {
            if (g16.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                FrameLayout frameLayout = this.contentContainer;
                Intrinsics.checkNotNull(frameLayout);
                frameLayout.setOnLongClickListener(this.onLongClickListner);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.messageViewOperator.f();
    }

    public void setContentView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.contentContainer.addView(view);
    }

    public final void setMessageListener(@Nullable n listener) {
        this.iMessageListener = listener;
    }

    public final void setPosition(int i3) {
        this.position = i3;
    }

    public final void setThemeConfig(@Nullable MessageLayout.a iThemeConfig) {
        this.iThemeConfig = iThemeConfig;
    }

    public final void setYoloRoomInfo(@Nullable YoloRoomOuterClass$YoloRoomInfo roomInfo) {
        this.roomInfo = roomInfo;
    }

    public void setContentView(@LayoutRes int layoutResID) {
        this.contentContainer.addView(View.inflate(getContext(), layoutResID, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CenterMessageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.messageViewOperator = new ac();
        setClipChildren(false);
        setClipToPadding(false);
        View.inflate(getContext(), R.layout.hto, this);
        View findViewById = findViewById(R.id.b9n);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.contentContainer)");
        this.contentContainer = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.jlc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.timeView)");
        this.timeView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f73773ug);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.revokeView)");
        this.revokeView = (TextView) findViewById3;
        this.contentContainer.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.timi.game.component.chat.message.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean d16;
                d16 = CenterMessageView.d(CenterMessageView.this, view, motionEvent);
                return d16;
            }
        });
        this.onLongClickListner = new View.OnLongClickListener() { // from class: com.tencent.timi.game.component.chat.message.j
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean j3;
                j3 = CenterMessageView.j(CenterMessageView.this, view);
                return j3;
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CenterMessageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.messageViewOperator = new ac();
        setClipChildren(false);
        setClipToPadding(false);
        View.inflate(getContext(), R.layout.hto, this);
        View findViewById = findViewById(R.id.b9n);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.contentContainer)");
        this.contentContainer = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.jlc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.timeView)");
        this.timeView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f73773ug);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.revokeView)");
        this.revokeView = (TextView) findViewById3;
        this.contentContainer.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.timi.game.component.chat.message.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean d16;
                d16 = CenterMessageView.d(CenterMessageView.this, view, motionEvent);
                return d16;
            }
        });
        this.onLongClickListner = new View.OnLongClickListener() { // from class: com.tencent.timi.game.component.chat.message.j
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean j3;
                j3 = CenterMessageView.j(CenterMessageView.this, view);
                return j3;
            }
        };
    }
}
