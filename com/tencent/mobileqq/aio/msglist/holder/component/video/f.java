package com.tencent.mobileqq.aio.msglist.holder.component.video;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.bs;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.widget.VideoProgressView;
import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/f;", "", "", "c", "", "d", "key", "b", tl.h.F, "", "progress", "k", "g", "l", "i", "j", "f", "Lcom/tencent/qqnt/aio/widget/VideoProgressView;", "a", "Lcom/tencent/qqnt/aio/widget/VideoProgressView;", "progressView", "Ljava/lang/String;", "", "Z", "isComplete", "<init>", "(Lcom/tencent/qqnt/aio/widget/VideoProgressView;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VideoProgressView progressView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String key;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isComplete;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/f$a;", "", "", "MAX_PROGRESS", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.video.f$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63870);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f(@NotNull VideoProgressView progressView) {
        Intrinsics.checkNotNullParameter(progressView, "progressView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) progressView);
            return;
        }
        this.progressView = progressView;
        progressView.setId(R.id.g2d);
        progressView.setDrawFinishResource(R.drawable.mye);
    }

    private final String c() {
        String str = this.key;
        if (str == null) {
            return "(empty)";
        }
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("key");
            return null;
        }
        return str;
    }

    private final void d() {
        VideoProgressView videoProgressView = this.progressView;
        String str = this.key;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("key");
            str = null;
        }
        if (!videoProgressView.o(str)) {
            this.progressView.setVisibility(8);
            return;
        }
        if (QLog.isColorLevel()) {
            String str3 = this.key;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("key");
            } else {
                str2 = str3;
            }
            QLog.i("AIOVideoProgressController", 1, "[hideAfterAnimation] set listener, key=" + str2);
        }
        this.progressView.setAnimRunnableListener(new MessageProgressView.a() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.e
            @Override // com.tencent.mobileqq.widget.MessageProgressView.a
            public final void a(String str4) {
                f.e(f.this, str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(f this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.i("AIOVideoProgressController", 1, "[hideAfterAnimation] on anim end, key=" + str);
        }
        if (!TextUtils.isEmpty(str)) {
            String str2 = this$0.key;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("key");
                str2 = null;
            }
            if (Intrinsics.areEqual(str, str2)) {
                this$0.progressView.setVisibility(8);
            }
        }
    }

    public final void b(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) key);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (!com.tencent.qqnt.util.b.f362976b.isPublicVersion() || QLog.isColorLevel()) {
            QLog.i("AIOVideoProgressController", 1, "[bind] key=" + c() + "->" + key + " isComplete=" + this.isComplete);
        }
        String str = this.key;
        if (str != null) {
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("key");
                str = null;
            }
            if (Intrinsics.areEqual(key, str)) {
                return;
            }
        }
        this.key = key;
        this.isComplete = false;
        bs.c().e(key);
    }

    public final void f() {
        Iterator it;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (!com.tencent.qqnt.util.b.f362976b.isPublicVersion() || QLog.isColorLevel()) {
            StringBuffer stringBuffer = new StringBuffer();
            Enumeration<String> keys = bs.c().f307498a.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "getInstance().mRefreshProgressRunnable.keys()");
            it = CollectionsKt__IteratorsJVMKt.iterator(keys);
            while (it.hasNext()) {
                String str = (String) it.next();
                stringBuffer.append("key:");
                stringBuffer.append(str);
                stringBuffer.append(" ");
            }
            QLog.i("AIOVideoProgressController", 1, "keys=" + ((Object) stringBuffer));
        }
        VideoProgressView videoProgressView = this.progressView;
        String str2 = this.key;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("key");
            str2 = null;
        }
        videoProgressView.q(str2);
        this.progressView.setVisibility(8);
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        String str = null;
        if (QLog.isColorLevel()) {
            String str2 = this.key;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("key");
                str2 = null;
            }
            QLog.i("AIOVideoProgressController", 2, "[onCompressFinish] key=" + str2);
        }
        this.progressView.setDrawStatus(1);
        VideoProgressView videoProgressView = this.progressView;
        String str3 = this.key;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("key");
            str3 = null;
        }
        videoProgressView.setAnimProgress(0, str3);
        VideoProgressView videoProgressView2 = this.progressView;
        String str4 = this.key;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("key");
        } else {
            str = str4;
        }
        videoProgressView2.t(str, 1.0f);
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        String str = null;
        if (QLog.isColorLevel()) {
            String str2 = this.key;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("key");
                str2 = null;
            }
            QLog.i("AIOVideoProgressController", 2, "[onStartCompress] key=" + str2);
        }
        this.progressView.setVideoCompressStatus(true);
        this.progressView.setVisibility(0);
        VideoProgressView videoProgressView = this.progressView;
        String str3 = this.key;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("key");
            str3 = null;
        }
        videoProgressView.setAnimProgress("\u538b\u7f29\u4e2d", str3);
        this.progressView.setDrawStatus(1);
        VideoProgressView videoProgressView2 = this.progressView;
        String str4 = this.key;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("key");
        } else {
            str = str4;
        }
        videoProgressView2.s(str);
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        String str = null;
        if (QLog.isColorLevel()) {
            String str2 = this.key;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("key");
                str2 = null;
            }
            QLog.i("AIOVideoProgressController", 2, "[onTransferComplete] key=" + str2 + " isComplete=" + this.isComplete);
        }
        if (this.isComplete) {
            return;
        }
        this.isComplete = true;
        this.progressView.setVisibility(0);
        this.progressView.setVideoCompressStatus(false);
        VideoProgressView videoProgressView = this.progressView;
        String str3 = this.key;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("key");
        } else {
            str = str3;
        }
        videoProgressView.setAnimProgress(100, str);
        d();
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        String str = null;
        if (QLog.isColorLevel()) {
            String str2 = this.key;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("key");
                str2 = null;
            }
            QLog.i("AIOVideoProgressController", 2, "[onTransferFail] key=" + str2);
        }
        this.progressView.setVisibility(8);
        VideoProgressView videoProgressView = this.progressView;
        String str3 = this.key;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("key");
        } else {
            str = str3;
        }
        videoProgressView.t(str, 0.0f);
        this.progressView.setVideoCompressStatus(false);
    }

    public final void k(int progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, progress);
            return;
        }
        this.progressView.setVideoCompressStatus(true);
        this.progressView.setVisibility(0);
        VideoProgressView videoProgressView = this.progressView;
        String str = this.key;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("key");
            str = null;
        }
        videoProgressView.setAnimProgress("\u538b\u7f29\u4e2d", str);
        this.progressView.setDrawStatus(1);
        VideoProgressView videoProgressView2 = this.progressView;
        String str3 = this.key;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("key");
        } else {
            str2 = str3;
        }
        videoProgressView2.t(str2, progress / 100.0f);
    }

    public final void l(int progress) {
        int coerceAtMost;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, progress);
            return;
        }
        String str = null;
        if (this.isComplete) {
            if (QLog.isColorLevel()) {
                String str2 = this.key;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("key");
                } else {
                    str = str2;
                }
                QLog.i("AIOVideoProgressController", 2, "[onUpdateTransferProgress] key=" + str + " isComplete=" + this.isComplete);
                return;
            }
            return;
        }
        this.progressView.setVisibility(0);
        this.progressView.setVideoCompressStatus(false);
        this.progressView.setDrawStatus(1);
        VideoProgressView videoProgressView = this.progressView;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(progress, 99);
        String str3 = this.key;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("key");
        } else {
            str = str3;
        }
        videoProgressView.setAnimProgress(coerceAtMost, str);
    }
}
