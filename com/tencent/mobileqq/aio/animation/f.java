package com.tencent.mobileqq.aio.animation;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.aio.animation.business.EggsPlayStat;
import com.tencent.mobileqq.aio.config.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.core.EventListener;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\u0006\u0010,\u001a\u00020&\u0012\u0006\u00101\u001a\u00020-\u00a2\u0006\u0004\b5\u00106J0\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H&J'\u0010\f\u001a\u00020\u00022\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001H&\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u000fH&J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0004J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0004H\u0004J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0004J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019H\u0004J\u0012\u0010\u001c\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0004J\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dR\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010,\u001a\u00020&8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+R\u001a\u00101\u001a\u00020-8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b.\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/f;", "", "", "changed", "", "left", "top", "right", "bottom", "f", "", "args", DomainData.DOMAIN_NAME, "([Ljava/lang/Object;)Z", EventListener.KEY_DELTA, "", "i", "o", "type", "a", tl.h.F, "g", "Ljava/lang/Runnable;", "r", "j", "", "delayMillis", "k", "l", "Lcom/tencent/mobileqq/aio/animation/config/a;", TransferConfig.ExtendParamFloats.KEY_RULE, "e", "I", "d", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "priority", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", "b", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", "()Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", "setContainer", "(Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;)V", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/aio/animation/data/a;", "c", "Lcom/tencent/mobileqq/aio/animation/data/a;", "()Lcom/tencent/mobileqq/aio/animation/data/a;", "listview", "Landroid/os/Handler;", "Landroid/os/Handler;", "uiHandler", "<init>", "(ILcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;Lcom/tencent/mobileqq/aio/animation/data/a;)V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public abstract class f {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int priority;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AIOAnimationContainer container;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.aio.animation.data.a listview;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler uiHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.f$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29126);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f(int i3, @NotNull AIOAnimationContainer container, @NotNull com.tencent.mobileqq.aio.animation.data.a listview) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(listview, "listview");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), container, listview);
            return;
        }
        this.priority = i3;
        this.container = container;
        this.listview = listview;
        this.uiHandler = new Handler(Looper.getMainLooper());
    }

    public boolean a(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, type)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final AIOAnimationContainer b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AIOAnimationContainer) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.container;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.mobileqq.aio.animation.data.a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.aio.animation.data.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.listview;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.priority;
    }

    public final boolean e(@NotNull com.tencent.mobileqq.aio.animation.config.a rule) {
        Object obj;
        Pair<Long, Integer> c16;
        List split$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) rule)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(rule, "rule");
        if (rule.t()) {
            return false;
        }
        List<a.b> c17 = com.tencent.mobileqq.aio.config.a.INSTANCE.b().c();
        if (c17.isEmpty()) {
            return false;
        }
        Iterator<T> it = c17.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                split$default = StringsKt__StringsKt.split$default((CharSequence) ((a.b) obj).b(), new String[]{";"}, false, 0, 6, (Object) null);
                if (split$default.contains(String.valueOf(rule.h()))) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        a.b bVar = (a.b) obj;
        if (bVar != null && (c16 = EggsPlayStat.f187895a.c(rule.h())) != null) {
            if (System.currentTimeMillis() - c16.getFirst().longValue() < bVar.a() * 1000) {
                QLog.i("AIOAnimator", 1, "hitFreqLimit by gap  ts:" + c16.getFirst());
                return true;
            }
            if (bVar.c() >= 0 && c16.getSecond().intValue() >= bVar.c()) {
                QLog.i("AIOAnimator", 1, "hitFreqLimit by per day  count:" + c16.getSecond());
                return true;
            }
        }
        EggsPlayStat.f187895a.e(rule.h(), c17);
        return false;
    }

    public abstract boolean f(boolean changed, int left, int top, int right, int bottom);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, type);
        } else {
            this.container.p(type);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.container.i();
        }
    }

    public void i(int delta) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, delta);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j(@NotNull Runnable r16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) r16);
        } else {
            Intrinsics.checkNotNullParameter(r16, "r");
            this.uiHandler.post(r16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k(@NotNull Runnable r16, long delayMillis) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, r16, Long.valueOf(delayMillis));
        } else {
            Intrinsics.checkNotNullParameter(r16, "r");
            this.uiHandler.postDelayed(r16, delayMillis);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l(@Nullable Runnable r16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) r16);
        } else if (r16 != null) {
            this.uiHandler.removeCallbacks(r16);
        }
    }

    public final void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.priority = i3;
        }
    }

    public abstract boolean n(@NotNull Object... args);

    public abstract void o();
}
