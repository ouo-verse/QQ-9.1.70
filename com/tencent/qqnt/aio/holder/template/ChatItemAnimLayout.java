package com.tencent.qqnt.aio.holder.template;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 ,2\u00020\u0001:\u0002abB\u0011\b\u0016\u0012\u0006\u0010Y\u001a\u00020X\u00a2\u0006\u0004\bZ\u0010[B\u001b\b\u0016\u0012\u0006\u0010Y\u001a\u00020X\u0012\b\u0010]\u001a\u0004\u0018\u00010\\\u00a2\u0006\u0004\bZ\u0010^B#\b\u0016\u0012\u0006\u0010Y\u001a\u00020X\u0012\b\u0010]\u001a\u0004\u0018\u00010\\\u0012\u0006\u0010_\u001a\u00020*\u00a2\u0006\u0004\bZ\u0010`J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J8\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0004R\"\u0010\u001d\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\"\u0010%\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\"\u0010)\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00105\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\"\u0010=\u001a\u0002068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010D\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010K\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010MR\"\u0010Q\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010V\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010P\u001a\u0004\bV\u0010R\"\u0004\bW\u0010T\u00a8\u0006c"}, d2 = {"Lcom/tencent/qqnt/aio/holder/template/ChatItemAnimLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msg", "", "E0", "", "fromX", "toX", "fromAlpha", "toAlpha", "Lcom/tencent/qqnt/aio/holder/template/ChatItemAnimLayout$b;", "listener", "", "F0", "z0", "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "inMiniAIO", "setIsShieldTouchForItem", "fromForward", "setFrom", "d", UserInfo.SEX_FEMALE, "B0", "()F", "setMAnimFactor", "(F)V", "mAnimFactor", "e", "getMAlphaFactor", "setMAlphaFactor", "mAlphaFactor", "f", "getMFromX", "setMFromX", "mFromX", h.F, "getMToX", "setMToX", "mToX", "", "i", "I", "getMFromAlpha", "()I", "setMFromAlpha", "(I)V", "mFromAlpha", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getMToAlpha", "setMToAlpha", "mToAlpha", "", BdhLogUtil.LogTag.Tag_Conn, "J", "C0", "()J", "setMAnimStartTime", "(J)V", "mAnimStartTime", "D", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "A0", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "setChatMsg", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)V", "chatMsg", "E", "Lcom/tencent/qqnt/aio/holder/template/ChatItemAnimLayout$b;", "D0", "()Lcom/tencent/qqnt/aio/holder/template/ChatItemAnimLayout$b;", "setSAnimListener", "(Lcom/tencent/qqnt/aio/holder/template/ChatItemAnimLayout$b;)V", "sAnimListener", "Landroid/os/Handler;", "Landroid/os/Handler;", "mHandler", "G", "Z", "isMiniAioShieldItemTouch", "()Z", "setMiniAioShieldItemTouch", "(Z)V", "H", "isFromForward", "setFromForward", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class ChatItemAnimLayout extends ConstraintLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private long mAnimStartTime;

    /* renamed from: D, reason: from kotlin metadata */
    public AIOMsgItem chatMsg;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private b sAnimListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Handler mHandler;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isMiniAioShieldItemTouch;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isFromForward;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float mAnimFactor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float mAlphaFactor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mFromX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mToX;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mFromAlpha;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mToAlpha;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/holder/template/ChatItemAnimLayout$a;", "", "", "ANIMATION_END", "I", "ANIMATION_START", "ANIMATION_UPDADE", "", "ANIM_DURATION", "J", "FRAME_DELAY", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.holder.template.ChatItemAnimLayout$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/aio/holder/template/ChatItemAnimLayout$b;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "chatMessage", "", "I", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface b {
        void I(@NotNull AIOMsgItem chatMessage);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/holder/template/ChatItemAnimLayout$c", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c extends Handler {
        static IPatchRedirector $redirector_;

        c(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatItemAnimLayout.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            int i3 = msg2.what;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ChatItemAnimLayout.this.setMAnimFactor(1.0f);
                        ChatItemAnimLayout.this.invalidate();
                        if (ChatItemAnimLayout.this.D0() != null) {
                            b D0 = ChatItemAnimLayout.this.D0();
                            Intrinsics.checkNotNull(D0);
                            D0.I(ChatItemAnimLayout.this.A0());
                            return;
                        }
                        return;
                    }
                    return;
                }
                ChatItemAnimLayout.this.A0().y1(System.currentTimeMillis());
                float O = ((float) (ChatItemAnimLayout.this.A0().O() - ChatItemAnimLayout.this.C0())) / 250.0f;
                if (O > 1.0f) {
                    O = 1.0f;
                }
                float f16 = 1;
                float f17 = f16 - O;
                ChatItemAnimLayout.this.setMAnimFactor(f16 - ((f17 * f17) * f17));
                ChatItemAnimLayout.this.setMAlphaFactor(O);
                if (ChatItemAnimLayout.this.B0() < 1.0f) {
                    Message obtainMessage = obtainMessage(1);
                    Intrinsics.checkNotNullExpressionValue(obtainMessage, "this.obtainMessage(ANIMATION_UPDADE)");
                    sendMessageDelayed(obtainMessage, 10L);
                } else {
                    ChatItemAnimLayout.this.setMAnimFactor(1.0f);
                    Message obtainMessage2 = obtainMessage(2);
                    Intrinsics.checkNotNullExpressionValue(obtainMessage2, "this.obtainMessage(ANIMATION_END)");
                    sendMessageDelayed(obtainMessage2, 0L);
                }
                ChatItemAnimLayout.this.invalidate();
                return;
            }
            ChatItemAnimLayout.this.A0().y1(System.currentTimeMillis());
            ChatItemAnimLayout.this.setMAnimFactor(0.0f);
            ChatItemAnimLayout.this.setMAlphaFactor(0.0f);
            Message obtainMessage3 = obtainMessage(1);
            Intrinsics.checkNotNullExpressionValue(obtainMessage3, "this.obtainMessage(ANIMATION_UPDADE)");
            sendMessageDelayed(obtainMessage3, 10L);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42502);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatItemAnimLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) context);
            return;
        }
        this.mAnimFactor = 1.0f;
        this.mAlphaFactor = 1.0f;
        this.mToAlpha = 255;
        this.mAnimStartTime = -1L;
        this.mHandler = new c(Looper.getMainLooper());
    }

    private final boolean E0(AIOMsgItem msg2) {
        if (this.chatMsg == null) {
            return false;
        }
        if (msg2 != null && !Intrinsics.areEqual(A0(), msg2) && (msg2.getMsgRecord().msgId == 0 || A0().getMsgRecord().msgId != msg2.getMsgRecord().msgId)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final AIOMsgItem A0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        AIOMsgItem aIOMsgItem = this.chatMsg;
        if (aIOMsgItem != null) {
            return aIOMsgItem;
        }
        Intrinsics.throwUninitializedPropertyAccessException("chatMsg");
        return null;
    }

    public final float B0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Float) iPatchRedirector.redirect((short) 1, (Object) this)).floatValue();
        }
        return this.mAnimFactor;
    }

    public final long C0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.mAnimStartTime;
    }

    @Nullable
    public final b D0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (b) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.sAnimListener;
    }

    public final void F0(@NotNull AIOMsgItem msg2, float fromX, float toX, float fromAlpha, float toAlpha, @Nullable b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, msg2, Float.valueOf(fromX), Float.valueOf(toX), Float.valueOf(fromAlpha), Float.valueOf(toAlpha), listener);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (E0(msg2)) {
            return;
        }
        setChatMsg(msg2);
        this.sAnimListener = listener;
        this.mAnimStartTime = System.currentTimeMillis();
        this.mFromX = fromX;
        this.mToX = toX;
        float f16 = 255;
        this.mFromAlpha = (int) (fromAlpha * f16);
        this.mToAlpha = (int) (toAlpha * f16);
        this.mAnimFactor = 0.0f;
        this.mAlphaFactor = 0.0f;
        Message obtainMessage = this.mHandler.obtainMessage(0);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "mHandler.obtainMessage(ANIMATION_START)");
        this.mHandler.sendMessageDelayed(obtainMessage, 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NotNull Canvas canvas) {
        String name;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float f16 = this.mToX;
        float f17 = this.mFromX;
        float f18 = ((f16 - f17) * this.mAnimFactor) + f17;
        int i3 = this.mToAlpha;
        setAlpha((((i3 - r2) * this.mAlphaFactor) + this.mFromAlpha) / 255.0f);
        canvas.translate(f18, 0.0f);
        try {
            super.dispatchDraw(canvas);
        } catch (Exception e16) {
            if (com.tencent.qqnt.util.b.f362976b.isGrayVersion()) {
                if (this.chatMsg != null && A0() != null) {
                    int i16 = A0().getMsgRecord().msgType;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(i16);
                    name = sb5.toString();
                } else {
                    name = getClass().getName();
                    Intrinsics.checkNotNullExpressionValue(name, "{\n                    th\u2026ss.name\n                }");
                }
                QLog.d("ChatItemAnimLayout", 1, "ChatItemAnimLayout dispatchDraw exception: " + name + " !!", e16);
                return;
            }
            if (!com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
            } else {
                throw new RuntimeException(e16);
            }
        }
    }

    public final void setChatMsg(@NotNull AIOMsgItem aIOMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) aIOMsgItem);
        } else {
            Intrinsics.checkNotNullParameter(aIOMsgItem, "<set-?>");
            this.chatMsg = aIOMsgItem;
        }
    }

    public final void setFrom(boolean fromForward) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, fromForward);
        } else {
            this.isFromForward = fromForward;
        }
    }

    public final void setIsShieldTouchForItem(boolean inMiniAIO) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, inMiniAIO);
        } else {
            this.isMiniAioShieldItemTouch = inMiniAIO;
        }
    }

    public final void setMAlphaFactor(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else {
            this.mAlphaFactor = f16;
        }
    }

    public final void setMAnimFactor(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
        } else {
            this.mAnimFactor = f16;
        }
    }

    public final void setMAnimStartTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
        } else {
            this.mAnimStartTime = j3;
        }
    }

    public final void setMFromAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.mFromAlpha = i3;
        }
    }

    public final void setMFromX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.mFromX = f16;
        }
    }

    public final void setMToAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.mToAlpha = i3;
        }
    }

    public final void setMToX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            this.mToX = f16;
        }
    }

    public final void setSAnimListener(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) bVar);
        } else {
            this.sAnimListener = bVar;
        }
    }

    public final void z0(@NotNull AIOMsgItem msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (this.chatMsg != null && A0() != null && A0() != msg2) {
            this.mToX = 0.0f;
            this.mToAlpha = 255;
            Message obtainMessage = this.mHandler.obtainMessage(2);
            Intrinsics.checkNotNullExpressionValue(obtainMessage, "mHandler.obtainMessage(ANIMATION_END)");
            this.mHandler.sendMessage(obtainMessage);
            setChatMsg(msg2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatItemAnimLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mAnimFactor = 1.0f;
        this.mAlphaFactor = 1.0f;
        this.mToAlpha = 255;
        this.mAnimStartTime = -1L;
        this.mHandler = new c(Looper.getMainLooper());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatItemAnimLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mAnimFactor = 1.0f;
        this.mAlphaFactor = 1.0f;
        this.mToAlpha = 255;
        this.mAnimStartTime = -1L;
        this.mHandler = new c(Looper.getMainLooper());
    }
}
