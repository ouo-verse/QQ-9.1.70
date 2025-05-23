package com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel;

import android.os.CountDownTimer;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.util.af;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/viewmodel/g;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "length", "", "i", "k", "l", h.F, "", "j", "", "appendStr", "g", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/viewmodel/b;", "a", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/viewmodel/b;", "animListener", "b", "Ljava/lang/String;", "remainingText", "Landroid/os/CountDownTimer;", "c", "Landroid/os/CountDownTimer;", "contentWriterEffectTimer", "d", "Z", "isPause", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/viewmodel/b;)V", "e", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.b animListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String remainingText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CountDownTimer contentWriterEffectTimer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isPause;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/template/ai/viewmodel/g$b", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", "a", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f284203a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j3, long j16, g gVar) {
            super(j3, j16);
            this.f284203a = gVar;
        }

        private final void a(long millisUntilFinished) {
            boolean z16;
            String take;
            String drop;
            String take2;
            if (this.f284203a.remainingText.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                af afVar = af.f284993a;
                g gVar = this.f284203a;
                if (QLog.isDebugVersion()) {
                    take2 = StringsKt___StringsKt.take(gVar.remainingText, 1);
                    QLog.d("QS.QQSearch.NetDetail.AI.StreamAnimImpl", 2, "onTick: millisUntilFinished\uff1a" + millisUntilFinished + " appendText:" + take2, (Throwable) null);
                }
                com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.b bVar = this.f284203a.animListener;
                take = StringsKt___StringsKt.take(this.f284203a.remainingText, 1);
                bVar.a(take);
                g gVar2 = this.f284203a;
                drop = StringsKt___StringsKt.drop(gVar2.remainingText, 1);
                gVar2.remainingText = drop;
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            a(0L);
            af afVar = af.f284993a;
            g gVar = this.f284203a;
            boolean z16 = false;
            QLog.i("QS.QQSearch.NetDetail.AI.StreamAnimImpl", 1, "onFinish isPause=" + gVar.isPause + " len=" + gVar.remainingText.length() + " text=" + af.b(gVar.remainingText, 0, 2, null), null);
            this.f284203a.contentWriterEffectTimer = null;
            if (this.f284203a.isPause) {
                return;
            }
            if (this.f284203a.remainingText.length() > 0) {
                z16 = true;
            }
            if (z16) {
                this.f284203a.m();
            } else {
                this.f284203a.animListener.onAnimationEnd();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            a(millisUntilFinished);
        }
    }

    public g(@NotNull com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.b animListener) {
        Intrinsics.checkNotNullParameter(animListener, "animListener");
        this.animListener = animListener;
        this.remainingText = "";
    }

    private final long i(int length) {
        if (length > 200) {
            return 10L;
        }
        if (length > 100) {
            return 20L;
        }
        return 30L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        long i3 = i(this.remainingText.length());
        long length = i3 * this.remainingText.length();
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.StreamAnimImpl", 1, "startNewTimer duration=" + length + " timeIntervalMillis=" + i3, null);
        b bVar = new b(length, i3, this);
        this.contentWriterEffectTimer = bVar;
        bVar.start();
    }

    public void g(@NotNull String appendStr) {
        boolean z16;
        Intrinsics.checkNotNullParameter(appendStr, "appendStr");
        if (appendStr.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.remainingText = this.remainingText + appendStr;
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.StreamAnimImpl", 1, "appendContentWithAnim: isPause=" + this.isPause + " len=" + this.remainingText.length() + " text=" + af.b(this.remainingText, 0, 2, null), null);
        if (!this.isPause && this.contentWriterEffectTimer == null) {
            m();
        }
    }

    public void h() {
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.StreamAnimImpl", 1, "cancel: len=" + this.remainingText.length() + " text=" + af.b(this.remainingText, 0, 2, null), null);
        CountDownTimer countDownTimer = this.contentWriterEffectTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.contentWriterEffectTimer = null;
        this.remainingText = "";
        this.animListener.onAnimationCancel();
    }

    public boolean j() {
        if (this.contentWriterEffectTimer != null) {
            return true;
        }
        return false;
    }

    public void k() {
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.StreamAnimImpl", 1, "onPause: len=" + this.remainingText.length() + " text=" + af.b(this.remainingText, 0, 2, null) + "}", null);
        this.isPause = true;
        CountDownTimer countDownTimer = this.contentWriterEffectTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.contentWriterEffectTimer = null;
    }

    public void l() {
        if (!this.isPause) {
            return;
        }
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.StreamAnimImpl", 1, "onResume: len=" + this.remainingText.length() + " text=" + af.b(this.remainingText, 0, 2, null) + "}", null);
        this.isPause = false;
        this.animListener.a(this.remainingText);
        this.remainingText = "";
    }
}
