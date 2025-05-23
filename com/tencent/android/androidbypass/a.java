package com.tencent.android.androidbypass;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\u0007\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J&\u0010\n\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0016R\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/android/androidbypass/a;", "Lcom/tencent/android/androidbypass/d;", "", "c", "", "", Node.ATTRS_ATTR, "b", "", "duration", "a", "", "J", "getTime", "()J", "setTime", "(J)V", "time", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "scene", "<init>", "(Ljava/lang/String;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
final class a implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long time;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String scene;

    public a(@NotNull String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) scene);
        } else {
            this.scene = scene;
        }
    }

    @Override // com.tencent.android.androidbypass.d
    public void a(@Nullable Map<String, String> attrs, double duration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, attrs, Double.valueOf(duration));
        } else {
            com.tencent.android.androidbypass.config.a.f72051c.reportTimeCost(this.scene, attrs, duration);
        }
    }

    @Override // com.tencent.android.androidbypass.d
    public void b(@Nullable Map<String, String> attrs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) attrs);
        } else {
            a(attrs, ((int) (((System.nanoTime() - this.time) / 1000000.0d) * 100)) / 100.0d);
        }
    }

    @Override // com.tencent.android.androidbypass.d
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.time = System.nanoTime();
        }
    }
}
