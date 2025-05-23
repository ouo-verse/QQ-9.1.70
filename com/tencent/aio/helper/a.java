package com.tencent.aio.helper;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0001\u0012\b\b\u0002\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0003H\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001J\u0011\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0097\u0001J\t\u0010\u000e\u001a\u00020\fH\u0097\u0001J\u0011\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001R\u001a\u0010\u0015\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010 \u001a\u00020\u001b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0011\u0010\u001e\"\u0004\b\u001c\u0010\u001fR\u0014\u0010#\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/aio/helper/a;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/helper/c;", "", "toString", "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "onMoveToState", "d", "Ljava/lang/String;", "getToken", "()Ljava/lang/String;", "token", "e", "Lcom/tencent/aio/main/businesshelper/h;", "getHelper", "()Lcom/tencent/aio/main/businesshelper/h;", "helper", "", "f", "Z", "()Z", "(Z)V", "resume", "l", "()I", "cacheLevel", "<init>", "(Ljava/lang/String;Lcom/tencent/aio/main/businesshelper/h;Z)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public class a implements h, c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String token;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h helper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean resume;

    public a(@NotNull String token, @NotNull h helper, boolean z16) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(helper, "helper");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, token, helper, Boolean.valueOf(z16));
            return;
        }
        this.token = token;
        this.helper = helper;
        this.resume = z16;
    }

    @Override // com.tencent.aio.helper.c
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.resume;
    }

    @Override // com.tencent.aio.helper.c
    public void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.resume = z16;
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.helper.getId();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.helper.getTag();
    }

    @Override // com.tencent.aio.helper.c
    @NotNull
    public String getToken() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.token;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (int[]) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.helper.interestedIn();
    }

    @Override // com.tencent.aio.helper.c
    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return com.tencent.aio.base.mvvm.recycler.d.a(this.helper.getClass());
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) param);
        } else {
            Intrinsics.checkNotNullParameter(param, "param");
            this.helper.onCreate(param);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.helper.onDestroy();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, state);
        } else {
            this.helper.onMoveToState(state);
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return String.valueOf(this.helper);
    }

    public /* synthetic */ a(String str, h hVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, hVar, (i3 & 4) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, this, str, hVar, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
