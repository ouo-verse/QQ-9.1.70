package com.tencent.qqnt.emotion.text.processor;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.IEmoticonSpanRefreshCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emoticon.api.IEmoticonApi;
import com.tencent.util.WeakReferenceHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001\u0011B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001c\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0016\u0010\u0016\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015R \u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0018R \u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/emotion/text/processor/a;", "Lov3/a;", "Landroid/os/Handler$Callback;", "", TtmlNode.TAG_SPAN, "", "e", "", "text", "Landroid/graphics/drawable/Drawable$Callback;", "callback", "c", "Landroid/graphics/drawable/Drawable;", "drawable", "d", "b", "", "a", "Landroid/os/Message;", "msg", "handleMessage", "Z", "mBlockRelayout", "", "[Landroid/graphics/drawable/Drawable;", "mHoldStaticDrawable", "f", "mHoldDynamicDrawable", h.F, "Ljava/lang/CharSequence;", "mText", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "mHandler", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements ov3.a, Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mBlockRelayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable[] mHoldStaticDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable[] mHoldDynamicDrawable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CharSequence mText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/emotion/text/processor/a$a;", "", "", "MSG_INVALIDATE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.text.processor.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes24.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31726);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mHandler = new WeakReferenceHandler(ThreadManager.getUIHandler().getLooper(), this);
        }
    }

    private final void e(Object span) {
        boolean z16;
        CharSequence charSequence = this.mText;
        if (charSequence instanceof Spannable) {
            Spannable spannable = (Spannable) charSequence;
            int spanStart = spannable.getSpanStart(span);
            int spanEnd = spannable.getSpanEnd(span);
            SpanWatcher[] spanWatcherArr = (SpanWatcher[]) spannable.getSpans(spanStart, spanEnd, SpanWatcher.class);
            if (spanWatcherArr != null) {
                if (spanWatcherArr.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    for (SpanWatcher spanWatcher : spanWatcherArr) {
                        try {
                            spanWatcher.onSpanChanged((Spannable) charSequence, span, spanStart, spanEnd, spanStart, spanEnd);
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e("EmoticonTextViewProcessor", 2, "Exception: " + e16.getMessage());
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // ov3.a
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.mBlockRelayout;
    }

    @Override // ov3.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mHandler.removeMessages(1);
        }
    }

    @Override // ov3.a
    public void c(@Nullable CharSequence text, @Nullable Drawable.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) text, (Object) callback);
            return;
        }
        this.mHoldStaticDrawable = null;
        this.mHoldDynamicDrawable = null;
        this.mText = text;
        if (text instanceof Spanned) {
            Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spanned");
            Spanned spanned = (Spanned) text;
            IEmoticonSpanRefreshCallback[] iEmoticonSpanRefreshCallbackArr = (IEmoticonSpanRefreshCallback[]) spanned.getSpans(0, spanned.length(), ((IEmoticonApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IEmoticonApi.class)).getEmoticonSpanClass());
            Drawable[] drawableArr = new Drawable[iEmoticonSpanRefreshCallbackArr.length];
            int length = iEmoticonSpanRefreshCallbackArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                IEmoticonSpanRefreshCallback iEmoticonSpanRefreshCallback = iEmoticonSpanRefreshCallbackArr[i3];
                Intrinsics.checkNotNullExpressionValue(iEmoticonSpanRefreshCallback, "images[i]");
                Drawable drawable = iEmoticonSpanRefreshCallback.getDrawable();
                drawableArr[i3] = drawable;
                if (drawable != null) {
                    Intrinsics.checkNotNull(drawable);
                    drawable.setCallback(callback);
                }
            }
            this.mHoldStaticDrawable = drawableArr;
            DynamicDrawableSpan[] dynamicDrawableSpanArr = (DynamicDrawableSpan[]) spanned.getSpans(0, spanned.length(), DynamicDrawableSpan.class);
            Drawable[] drawableArr2 = new Drawable[dynamicDrawableSpanArr.length];
            int length2 = dynamicDrawableSpanArr.length;
            for (int i16 = 0; i16 < length2; i16++) {
                Drawable drawable2 = dynamicDrawableSpanArr[i16].getDrawable();
                drawableArr2[i16] = drawable2;
                if (drawable2 != null) {
                    Intrinsics.checkNotNull(drawable2);
                    drawable2.setCallback(callback);
                }
            }
            this.mHoldDynamicDrawable = drawableArr2;
        }
    }

    @Override // ov3.a
    public void d(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable);
            return;
        }
        Message obtainMessage = this.mHandler.obtainMessage(1);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "mHandler.obtainMessage(MSG_INVALIDATE)");
        obtainMessage.obj = drawable;
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(obtainMessage, 100L);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 1) {
            CharSequence charSequence = this.mText;
            if (charSequence instanceof Spannable) {
                Spannable spannable = (Spannable) charSequence;
                IEmoticonSpanRefreshCallback[] iEmoticonSpanRefreshCallbackArr = (IEmoticonSpanRefreshCallback[]) spannable.getSpans(0, spannable.length(), ((IEmoticonApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IEmoticonApi.class)).getEmoticonSpanClass());
                if (iEmoticonSpanRefreshCallbackArr != null) {
                    if (iEmoticonSpanRefreshCallbackArr.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        this.mBlockRelayout = true;
                        for (IEmoticonSpanRefreshCallback imageSpan : iEmoticonSpanRefreshCallbackArr) {
                            if (imageSpan.getDrawable() == msg2.obj) {
                                Intrinsics.checkNotNullExpressionValue(imageSpan, "imageSpan");
                                e(imageSpan);
                            }
                        }
                        this.mBlockRelayout = false;
                    }
                }
            }
        }
        return true;
    }
}
