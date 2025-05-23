package com.tencent.icgame.game.component.chat.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.icgame.game.component.chat.message.MessageLayout;
import com.tencent.icgame.game.tim.api.message.MsgStatus;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010W\u001a\u00020V\u00a2\u0006\u0004\bX\u0010YB\u001b\b\u0016\u0012\u0006\u0010W\u001a\u00020V\u0012\b\u0010[\u001a\u0004\u0018\u00010Z\u00a2\u0006\u0004\bX\u0010\\B#\b\u0016\u0012\u0006\u0010W\u001a\u00020V\u0012\b\u0010[\u001a\u0004\u0018\u00010Z\u0012\u0006\u0010]\u001a\u00020\r\u00a2\u0006\u0004\bX\u0010^J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\u0017\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001c\u001a\u00020\u001bH\u0004J$\u0010\u001f\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010 \u001a\u00020\u0005H\u0014R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010'R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001a\u00103\u001a\u00020.8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001a\u00106\u001a\u00020.8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b4\u00100\u001a\u0004\b5\u00102R\u001a\u0010<\u001a\u0002078\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010H\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010'\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010P\u001a\u00020I8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U\u00a8\u0006_"}, d2 = {"Lcom/tencent/icgame/game/component/chat/message/CenterMessageView;", "Lcom/tencent/icgame/game/component/chat/message/TouchPositionGetableRelativeLayout;", "Lcom/tencent/icgame/game/component/chat/message/j;", "Lcom/tencent/icgame/game/component/chat/message/i;", "listener", "", "setMessageListener", "Lcom/tencent/icgame/trpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "roomInfo", "setYoloRoomInfo", "Landroid/view/View;", "view", "setContentView", "", "layoutResID", "Lcom/tencent/icgame/game/component/chat/message/MessageLayout$a;", "iThemeConfig", "setThemeConfig", "Lcom/tencent/icgame/game/tim/api/message/a;", "msg", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "selfUserId", "i", "", "Lcom/tencent/icgame/game/component/chat/message/LongClickOperOption;", "f", "()[Lcom/tencent/icgame/game/component/chat/message/LongClickOperOption;", "", "g", "qqUserId", "preMsg", "a", NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/icgame/game/tim/api/message/a;", "getMsg", "()Lcom/tencent/icgame/game/tim/api/message/a;", "setMsg", "(Lcom/tencent/icgame/game/tim/api/message/a;)V", tl.h.F, "I", "lastPointerRawX", "lastPointerRawY", "Lcom/tencent/icgame/game/component/chat/message/p;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/icgame/game/component/chat/message/p;", "messageViewOperator", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "getTimeView", "()Landroid/widget/TextView;", "timeView", "D", "getRevokeView", "revokeView", "Landroid/widget/FrameLayout;", "E", "Landroid/widget/FrameLayout;", "getContentContainer", "()Landroid/widget/FrameLayout;", "contentContainer", UserInfo.SEX_FEMALE, "Lcom/tencent/icgame/trpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "getRoomInfo", "()Lcom/tencent/icgame/trpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "setRoomInfo", "(Lcom/tencent/icgame/trpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;)V", "G", "getPosition", "()I", "setPosition", "(I)V", "position", "Landroid/view/View$OnLongClickListener;", "H", "Landroid/view/View$OnLongClickListener;", "getOnLongClickListner", "()Landroid/view/View$OnLongClickListener;", "setOnLongClickListner", "(Landroid/view/View$OnLongClickListener;)V", "onLongClickListner", "Lcom/tencent/icgame/game/component/chat/message/MessageLayout$a;", "e", "()Lcom/tencent/icgame/game/component/chat/message/MessageLayout$a;", "setIThemeConfig", "(Lcom/tencent/icgame/game/component/chat/message/MessageLayout$a;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public abstract class CenterMessageView extends TouchPositionGetableRelativeLayout implements j {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final TextView timeView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final TextView revokeView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final FrameLayout contentContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private YoloRoomOuterClass$YoloRoomInfo roomInfo;

    /* renamed from: G, reason: from kotlin metadata */
    private int position;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private View.OnLongClickListener onLongClickListner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.icgame.game.tim.api.message.a msg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int lastPointerRawX;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int lastPointerRawY;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private p messageViewOperator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CenterMessageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.messageViewOperator = new p();
        setClipChildren(false);
        setClipToPadding(false);
        View.inflate(getContext(), R.layout.fbg, this);
        View findViewById = findViewById(R.id.jlc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.timeView)");
        this.timeView = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.f73773ug);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.revokeView)");
        this.revokeView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.b9n);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.contentContainer)");
        FrameLayout frameLayout = (FrameLayout) findViewById3;
        this.contentContainer = frameLayout;
        frameLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.icgame.game.component.chat.message.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean d16;
                d16 = CenterMessageView.d(CenterMessageView.this, view, motionEvent);
                return d16;
            }
        });
        this.onLongClickListner = new View.OnLongClickListener() { // from class: com.tencent.icgame.game.component.chat.message.h
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean h16;
                h16 = CenterMessageView.h(CenterMessageView.this, view);
                return h16;
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
    public static final boolean h(CenterMessageView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.messageViewOperator.g(this$0.getContext(), this$0.msg, this$0.f(), this$0.lastPointerRawX, this$0.lastPointerRawY);
        return true;
    }

    @Override // com.tencent.icgame.game.component.chat.message.j
    public void a(@Nullable CommonOuterClass$QQUserId qqUserId, @NotNull com.tencent.icgame.game.tim.api.message.a msg2, @Nullable com.tencent.icgame.game.tim.api.message.a preMsg) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.msg = msg2;
        if (g() && (preMsg == null || Math.abs(msg2.time() - preMsg.time()) > 180000)) {
            uu0.b.i(this.timeView, true);
            this.timeView.setText(cy0.c.b(msg2.time()));
        } else {
            uu0.b.i(this.timeView, false);
        }
        if (msg2.h() == MsgStatus.REVOKE) {
            uu0.b.i(this.contentContainer, false);
            this.revokeView.setText("\u6d88\u606f\u5df2\u88ab\u64a4\u56de");
        } else {
            uu0.b.i(this.revokeView, false);
            uu0.b.i(this.contentContainer, true);
            i(msg2, qqUserId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final MessageLayout.a e() {
        return null;
    }

    @Nullable
    protected LongClickOperOption[] f() {
        return null;
    }

    protected final boolean g() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(@NotNull com.tencent.icgame.game.tim.api.message.a msg2, @Nullable CommonOuterClass$QQUserId selfUserId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        LongClickOperOption[] f16 = f();
        if (f16 != null) {
            if (f16.length == 0) {
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

    public final void setPosition(int i3) {
        this.position = i3;
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
        this.messageViewOperator = new p();
        setClipChildren(false);
        setClipToPadding(false);
        View.inflate(getContext(), R.layout.fbg, this);
        View findViewById = findViewById(R.id.jlc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.timeView)");
        this.timeView = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.f73773ug);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.revokeView)");
        this.revokeView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.b9n);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.contentContainer)");
        FrameLayout frameLayout = (FrameLayout) findViewById3;
        this.contentContainer = frameLayout;
        frameLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.icgame.game.component.chat.message.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean d16;
                d16 = CenterMessageView.d(CenterMessageView.this, view, motionEvent);
                return d16;
            }
        });
        this.onLongClickListner = new View.OnLongClickListener() { // from class: com.tencent.icgame.game.component.chat.message.h
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean h16;
                h16 = CenterMessageView.h(CenterMessageView.this, view);
                return h16;
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CenterMessageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.messageViewOperator = new p();
        setClipChildren(false);
        setClipToPadding(false);
        View.inflate(getContext(), R.layout.fbg, this);
        View findViewById = findViewById(R.id.jlc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.timeView)");
        this.timeView = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.f73773ug);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.revokeView)");
        this.revokeView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.b9n);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.contentContainer)");
        FrameLayout frameLayout = (FrameLayout) findViewById3;
        this.contentContainer = frameLayout;
        frameLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.icgame.game.component.chat.message.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean d16;
                d16 = CenterMessageView.d(CenterMessageView.this, view, motionEvent);
                return d16;
            }
        });
        this.onLongClickListner = new View.OnLongClickListener() { // from class: com.tencent.icgame.game.component.chat.message.h
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean h16;
                h16 = CenterMessageView.h(CenterMessageView.this, view);
                return h16;
            }
        };
    }

    public final void setMessageListener(@Nullable i listener) {
    }

    public final void setThemeConfig(@Nullable MessageLayout.a iThemeConfig) {
    }
}
