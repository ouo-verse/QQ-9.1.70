package com.tencent.aio.helper;

import com.tencent.aio.main.businesshelper.e;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0080\b\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0001\u0012\b\b\u0002\u0010 \u001a\u00020\u0010\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0097\u0001J\t\u0010\u000b\u001a\u00020\tH\u0097\u0001J\t\u0010\f\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003R\u001a\u0010\u0016\u001a\u00020\u00058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010 \u001a\u00020\u00108\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0012\u0010\u001e\"\u0004\b\u001c\u0010\u001fR\u0014\u0010#\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/aio/helper/b;", "Lcom/tencent/aio/main/businesshelper/e;", "Lcom/tencent/aio/helper/c;", "", "getId", "", "getTag", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getToken", "()Ljava/lang/String;", "token", "e", "Lcom/tencent/aio/main/businesshelper/e;", "getHelper", "()Lcom/tencent/aio/main/businesshelper/e;", "helper", "f", "Z", "()Z", "(Z)V", "resume", "l", "()I", "cacheLevel", "<init>", "(Ljava/lang/String;Lcom/tencent/aio/main/businesshelper/e;Z)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final /* data */ class b implements e, c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String token;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e helper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean resume;

    public b(@NotNull String token, @NotNull e helper, boolean z16) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(helper, "helper");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, token, helper, Boolean.valueOf(z16));
            return;
        }
        this.token = token;
        this.helper = helper;
        this.resume = z16;
    }

    @Override // com.tencent.aio.helper.c
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.resume;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof b) {
                b bVar = (b) other;
                if (!Intrinsics.areEqual(getToken(), bVar.getToken()) || !Intrinsics.areEqual(this.helper, bVar.helper) || d() != bVar.d()) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.tencent.aio.helper.c
    public void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.resume = z16;
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.helper.getId();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.helper.getTag();
    }

    @Override // com.tencent.aio.helper.c
    @NotNull
    public String getToken() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.token;
    }

    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        String token = getToken();
        int i16 = 0;
        if (token != null) {
            i3 = token.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        e eVar = this.helper;
        if (eVar != null) {
            i16 = eVar.hashCode();
        }
        int i18 = (i17 + i16) * 31;
        boolean d16 = d();
        int i19 = d16;
        if (d16) {
            i19 = 1;
        }
        return i18 + i19;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) param);
        } else {
            Intrinsics.checkNotNullParameter(param, "param");
            this.helper.onCreate(param);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.helper.onDestroy();
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return "CoreRecycleHelper(token=" + getToken() + ", helper=" + this.helper + ", resume=" + d() + ")";
    }

    public /* synthetic */ b(String str, e eVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, eVar, (i3 & 4) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, this, str, eVar, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
