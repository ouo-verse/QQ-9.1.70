package com.tencent.android.androidbypass.config;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0096\u0001J!\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J/\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0001\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/android/androidbypass/config/BypassConfig;", "Lcom/tencent/android/androidbypass/config/g;", "Lcom/tencent/android/androidbypass/config/i;", "Lcom/tencent/android/androidbypass/config/h;", "", "tag", "msg", "", "d", "e", "i", "", "level", "onLog", "w", "", "a", "scene", "", Node.ATTRS_ATTR, "", "duration", "reportTimeCost", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class BypassConfig implements g, i, h {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final BypassConfig f72045d;

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ c f72046a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ e f72047b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ d f72048c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14243);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f72045d = new BypassConfig();
        }
    }

    BypassConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f72046a = new c(AnonymousClass1.INSTANCE);
        this.f72047b = new e(AnonymousClass2.INSTANCE);
        this.f72048c = new d(AnonymousClass3.INSTANCE);
    }

    @Override // com.tencent.android.androidbypass.config.i
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f72047b.a();
    }

    @Override // com.tencent.android.androidbypass.config.g
    public void d(@NotNull String tag, @NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tag, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.f72046a.d(tag, msg2);
    }

    @Override // com.tencent.android.androidbypass.config.g
    public void e(@NotNull String tag, @NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) tag, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.f72046a.e(tag, msg2);
    }

    @Override // com.tencent.android.androidbypass.config.g
    public void i(@NotNull String tag, @NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) tag, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.f72046a.i(tag, msg2);
    }

    @Override // com.tencent.android.androidbypass.config.f
    public void onLog(int level, @NotNull String tag, @NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(level), tag, msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.f72046a.onLog(level, tag, msg2);
    }

    @Override // com.tencent.android.androidbypass.config.h
    public void reportTimeCost(@NotNull String scene, @Nullable Map<String, String> attrs, double duration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, scene, attrs, Double.valueOf(duration));
        } else {
            Intrinsics.checkNotNullParameter(scene, "scene");
            this.f72048c.reportTimeCost(scene, attrs, duration);
        }
    }

    @Override // com.tencent.android.androidbypass.config.g
    public void w(@NotNull String tag, @NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) tag, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.f72046a.w(tag, msg2);
    }
}
