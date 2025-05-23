package com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u001a\u0010\u0016\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\bH\u0016R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/stream/anomator/c;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/stream/anomator/a;", "Landroid/animation/ValueAnimator;", "animator", "", h.F, "Landroid/widget/TextView;", "textView", "", "content", "f", "", "length", "", "i", "start", "pause", "cancel", "end", "b", "", "isStarted", "c", "showedLength", "newContent", "a", "Lcom/tencent/mobileqq/aio/msglist/holder/component/stream/anomator/d;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/stream/anomator/d;", "streamAnimatorListener", "Landroid/animation/ValueAnimator;", "mStreamAnimator", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/stream/anomator/d;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d streamAnimatorListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator mStreamAnimator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/stream/anomator/c$a;", "", "", "DURATION_FAST", "J", "DURATION_MID", "DURATION_PER_CHAR", "", "LENGTH_LONG", "I", "LENGTH_MID", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.c$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/stream/anomator/c$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                c.this.streamAnimatorListener.onAnimationCancel(animation);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                c.this.streamAnimatorListener.onAnimationEnd(animation);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                c.this.streamAnimatorListener.onAnimationStart(animation);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63223);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull d streamAnimatorListener) {
        Intrinsics.checkNotNullParameter(streamAnimatorListener, "streamAnimatorListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) streamAnimatorListener);
        } else {
            this.streamAnimatorListener = streamAnimatorListener;
        }
    }

    private final void f(ValueAnimator animator, final TextView textView, final CharSequence content) {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = Integer.MIN_VALUE;
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.g(content, intRef, this, textView, valueAnimator);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(CharSequence content, Ref.IntRef notifiedIndex, c this$0, TextView textView, ValueAnimator valueAnimator) {
        CharSequence subSequence;
        Intrinsics.checkNotNullParameter(content, "$content");
        Intrinsics.checkNotNullParameter(notifiedIndex, "$notifiedIndex");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int min = Math.min(((Integer) animatedValue).intValue(), content.length());
        if (min == notifiedIndex.element && min != content.length()) {
            return;
        }
        notifiedIndex.element = min;
        if (content instanceof QQText) {
            subSequence = ((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class)).createNewQQTextForStreamMsg(content, 0, min);
        } else {
            subSequence = content.subSequence(0, min);
        }
        CharSequence charSequence = subSequence;
        if (QLog.isDevelopLevel()) {
            QLog.i("StreamAnimatorAdornImpl", 4, " onAnimationUpdate endIndex = " + min);
        }
        this$0.streamAnimatorListener.a(textView, valueAnimator, content, charSequence, min);
    }

    private final void h(ValueAnimator animator) {
        animator.addListener(new b());
    }

    private final long i(int length) {
        long j3;
        long j16;
        if (length > 200) {
            j3 = length;
            j16 = 10;
        } else if (length > 100) {
            j3 = length;
            j16 = 20;
        } else {
            j3 = length;
            j16 = 30;
        }
        return j3 * j16;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a
    public void a(int showedLength, @Nullable TextView textView, @NotNull CharSequence newContent) {
        Object obj;
        int i3;
        CharSequence subSequence;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(showedLength), textView, newContent);
            return;
        }
        Intrinsics.checkNotNullParameter(newContent, "newContent");
        if (QLog.isColorLevel()) {
            QLog.i("StreamAnimatorAdornImpl", 2, "updateStreamAnimator showedLength = " + showedLength + " newContentLength = " + newContent.length());
        }
        ValueAnimator valueAnimator = this.mStreamAnimator;
        Integer num = null;
        if (valueAnimator != null) {
            obj = valueAnimator.getAnimatedValue();
        } else {
            obj = null;
        }
        if (obj instanceof Integer) {
            num = (Integer) obj;
        }
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        if (this.mStreamAnimator == null) {
            c(textView, newContent);
        } else {
            showedLength = i3;
        }
        if (newContent instanceof QQText) {
            subSequence = ((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class)).createNewQQTextForStreamMsg(newContent, 0, newContent.length());
        } else {
            subSequence = newContent.subSequence(0, newContent.length());
        }
        ValueAnimator valueAnimator2 = this.mStreamAnimator;
        Intrinsics.checkNotNull(valueAnimator2);
        if (showedLength > subSequence.length()) {
            showedLength = subSequence.length();
        }
        valueAnimator2.setDuration(i(subSequence.length() - showedLength));
        valueAnimator2.removeAllUpdateListeners();
        f(valueAnimator2, textView, subSequence);
        valueAnimator2.setIntValues(showedLength, subSequence.length());
        valueAnimator2.setCurrentFraction(0.0f);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mStreamAnimator = null;
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a
    public void c(@Nullable TextView textView, @NotNull CharSequence content) {
        boolean z16;
        CharSequence subSequence;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) textView, (Object) content);
            return;
        }
        Intrinsics.checkNotNullParameter(content, "content");
        ValueAnimator valueAnimator = this.mStreamAnimator;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("StreamAnimatorAdornImpl", 1, "initStreamAnimator mStreamAnimator isStarted");
            ValueAnimator valueAnimator2 = this.mStreamAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            this.mStreamAnimator = null;
        }
        if (content instanceof QQText) {
            subSequence = ((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class)).createNewQQTextForStreamMsg(content, 0, content.length());
        } else {
            subSequence = content.subSequence(0, content.length());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(1, subSequence.length());
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(i(subSequence.length()));
        Intrinsics.checkNotNullExpressionValue(ofInt, "this");
        h(ofInt);
        f(ofInt, textView, subSequence);
        this.mStreamAnimator = ofInt;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a
    public void cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ValueAnimator valueAnimator = this.mStreamAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a
    public void end() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ValueAnimator valueAnimator = this.mStreamAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a
    public boolean isStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        ValueAnimator valueAnimator = this.mStreamAnimator;
        if (valueAnimator != null) {
            return valueAnimator.isStarted();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        ValueAnimator valueAnimator = this.mStreamAnimator;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ValueAnimator valueAnimator = this.mStreamAnimator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }
}
