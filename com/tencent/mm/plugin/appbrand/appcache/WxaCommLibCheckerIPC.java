package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Bundle;
import com.tencent.luggage.wxa.hn.i6;
import com.tencent.luggage.wxa.hn.z7;
import com.tencent.luggage.wxa.i3.i;
import com.tencent.luggage.wxa.ka.e;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.z8.b;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibCheckerIPC;", "", "", "a", "", "b", "Ljava/lang/String;", WxaCommLibCheckerIPC.KEY_LAUNCH_WXA_RESPONSE, "c", WxaCommLibCheckerIPC.KEY_PUB_VERSION, "<init>", "()V", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class WxaCommLibCheckerIPC {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WxaCommLibCheckerIPC f151841a = new WxaCommLibCheckerIPC();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String KEY_LAUNCH_WXA_RESPONSE = "KEY_LAUNCH_WXA_RESPONSE";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String KEY_PUB_VERSION = "KEY_PUB_VERSION";

    static {
        new IListener<i>(b.f146383a) { // from class: com.tencent.mm.plugin.appbrand.appcache.WxaCommLibCheckerIPC.1

            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "data", "Lcom/tencent/luggage/wxa/ka/i;", "Landroid/os/Parcelable;", "callback", "", "a", "(Landroid/os/Bundle;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
            /* renamed from: com.tencent.mm.plugin.appbrand.appcache.WxaCommLibCheckerIPC$1$a */
            /* loaded from: classes9.dex */
            public static final class a<InputType, ResultType> implements e {

                /* renamed from: a, reason: collision with root package name */
                public static final a f151844a = new a();

                @Override // com.tencent.luggage.wxa.ka.f
                public final void a(Bundle bundle, com.tencent.luggage.wxa.ka.i iVar) {
                    i6 i6Var;
                    try {
                        i6Var = new i6();
                        i6Var.a(bundle.getByteArray(WxaCommLibCheckerIPC.KEY_LAUNCH_WXA_RESPONSE));
                    } catch (Throwable unused) {
                        i6Var = null;
                    }
                    int i3 = bundle.getInt(WxaCommLibCheckerIPC.KEY_PUB_VERSION, -1);
                    if (i6Var != null) {
                        WxaCommLibVersionChecker.f151845e.a(i3, i6Var.f127861h);
                    }
                    if (iVar != null) {
                        iVar.a(com.tencent.luggage.wxa.va.e.f143316a);
                    }
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
            
                if (r0.f129135d == true) goto L8;
             */
            @Override // com.tencent.mm.sdk.event.IListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean callback(i event) {
                boolean z16;
                Intrinsics.checkNotNullParameter(event, "event");
                z7 z7Var = event.e().f127861h;
                if (z7Var != null) {
                    z16 = true;
                }
                z16 = false;
                if (z16) {
                    String g16 = z.g();
                    Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
                    Bundle bundle = new Bundle();
                    bundle.putByteArray(WxaCommLibCheckerIPC.KEY_LAUNCH_WXA_RESPONSE, event.e().b());
                    bundle.putInt(WxaCommLibCheckerIPC.KEY_PUB_VERSION, event.d().f127765i.f129038d);
                    com.tencent.luggage.wxa.ka.b.a(g16, bundle, a.f151844a, null, 8, null);
                }
                return false;
            }
        }.alive();
    }

    WxaCommLibCheckerIPC() {
    }

    public final void a() {
    }
}
