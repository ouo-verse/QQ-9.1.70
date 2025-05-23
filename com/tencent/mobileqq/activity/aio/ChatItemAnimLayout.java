package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ChatItemAnimLayout extends RelativeLayout {
    long C;
    ChatMessage D;
    private Handler E;
    protected boolean F;
    protected boolean G;

    /* renamed from: d, reason: collision with root package name */
    float f178065d;

    /* renamed from: e, reason: collision with root package name */
    float f178066e;

    /* renamed from: f, reason: collision with root package name */
    float f178067f;

    /* renamed from: h, reason: collision with root package name */
    float f178068h;

    /* renamed from: i, reason: collision with root package name */
    int f178069i;

    /* renamed from: m, reason: collision with root package name */
    int f178070m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ChatItemAnimLayout", 2, "ANIMATION_END");
                        }
                        ChatItemAnimLayout chatItemAnimLayout = ChatItemAnimLayout.this;
                        chatItemAnimLayout.f178065d = 1.0f;
                        chatItemAnimLayout.invalidate();
                        ChatItemAnimLayout.this.getClass();
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ChatItemAnimLayout", 2, "ANIMATION_UPDADE");
                }
                ChatItemAnimLayout.this.D.mMsgAnimTime = System.currentTimeMillis();
                ChatItemAnimLayout chatItemAnimLayout2 = ChatItemAnimLayout.this;
                float f16 = ((float) (chatItemAnimLayout2.D.mMsgAnimTime - chatItemAnimLayout2.C)) / 300.0f;
                if (f16 > 1.0f) {
                    f16 = 1.0f;
                }
                float f17 = 1.0f - f16;
                float f18 = 1.0f - ((f17 * f17) * f17);
                chatItemAnimLayout2.f178065d = f18;
                chatItemAnimLayout2.f178066e = f16;
                if (f18 < 1.0f) {
                    sendMessageDelayed(chatItemAnimLayout2.E.obtainMessage(1), 10L);
                } else {
                    chatItemAnimLayout2.f178065d = 1.0f;
                    sendMessageDelayed(chatItemAnimLayout2.E.obtainMessage(2), 0L);
                }
                ChatItemAnimLayout.this.invalidate();
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ChatItemAnimLayout", 2, "ANIMATION_START");
            }
            ChatItemAnimLayout.this.D.mMsgAnimTime = System.currentTimeMillis();
            ChatItemAnimLayout chatItemAnimLayout3 = ChatItemAnimLayout.this;
            chatItemAnimLayout3.f178065d = 0.0f;
            chatItemAnimLayout3.f178066e = 0.0f;
            sendMessageDelayed(chatItemAnimLayout3.E.obtainMessage(1), 10L);
        }
    }

    public ChatItemAnimLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f178065d = 1.0f;
        this.f178066e = 1.0f;
        this.f178067f = 0.0f;
        this.f178068h = 0.0f;
        this.f178070m = 255;
        this.C = -1L;
        this.E = new a(Looper.getMainLooper());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float f16 = this.f178068h;
        float f17 = this.f178067f;
        float f18 = ((f16 - f17) * this.f178065d) + f17;
        int i3 = this.f178070m;
        setAlpha((((i3 - r2) * this.f178066e) + this.f178069i) / 255.0f);
        canvas.translate(f18, 0.0f);
        try {
            super.dispatchDraw(canvas);
        } catch (Exception unused) {
        }
    }

    public void setFrom(boolean z16) {
        this.G = z16;
    }

    public void setIsShieldTouchForItem(boolean z16) {
        this.F = z16;
    }

    public ChatItemAnimLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f178065d = 1.0f;
        this.f178066e = 1.0f;
        this.f178067f = 0.0f;
        this.f178068h = 0.0f;
        this.f178070m = 255;
        this.C = -1L;
        this.E = new a(Looper.getMainLooper());
    }

    public ChatItemAnimLayout(Context context) {
        super(context);
        this.f178065d = 1.0f;
        this.f178066e = 1.0f;
        this.f178067f = 0.0f;
        this.f178068h = 0.0f;
        this.f178070m = 255;
        this.C = -1L;
        this.E = new a(Looper.getMainLooper());
    }
}
