package com.tencent.luggage.wxa.standalone_open_runtime.ui.patched;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.ui.WxaAppLibNotSupportTipsUI;
import com.tencent.luggage.wxa.bo.a;
import com.tencent.luggage.wxa.fa.b;
import com.tencent.luggage.wxa.q7.s;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\n"}, d2 = {"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/patched/PatchedWxaAppLibNotSupportTipsUI;", "Lcom/tencent/luggage/ui/WxaAppLibNotSupportTipsUI;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "<init>", "()V", "e", "Companion", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class PatchedWxaAppLibNotSupportTipsUI extends WxaAppLibNotSupportTipsUI {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/patched/PatchedWxaAppLibNotSupportTipsUI$Companion;", "", "()V", "showTips", "", "context", "Landroid/content/Context;", "appId", "", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void showTips(@Nullable Context context, @NotNull String appId) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Activity a16 = a.a(context);
            Intent intent = new Intent(z.c(), (Class<?>) PatchedWxaAppLibNotSupportTipsUI.class);
            intent.putExtra("KEY_APPID", appId);
            if (a16 != null) {
                b.a(a16, intent);
                a16.startActivity(intent);
            } else {
                intent.addFlags(268435456);
                Context c16 = z.c();
                b.a(c16, intent);
                c16.startActivity(intent);
            }
        }
    }

    static {
        new IListener<WxaAppLibNotSupportTipsUI.b>(com.tencent.luggage.wxa.z8.b.f146383a) { // from class: com.tencent.luggage.wxa.standalone_open_runtime.ui.patched.PatchedWxaAppLibNotSupportTipsUI.Companion.1
            @Override // com.tencent.mm.sdk.event.IListener
            public boolean callback(@NotNull WxaAppLibNotSupportTipsUI.b event) {
                IWXAPI e16;
                String replace$default;
                Intrinsics.checkNotNullParameter(event, "event");
                s d16 = s.d.f138074a.d();
                if (d16 == null || (e16 = d16.e()) == null) {
                    return true;
                }
                WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                replace$default = StringsKt__StringsJVMKt.replace$default(event.d(), "@app", "", false, 4, (Object) null);
                req.userName = replace$default;
                req.miniprogramType = 0;
                e16.sendReq(req);
                return true;
            }
        }.alive();
    }

    @JvmStatic
    public static final void showTips(@Nullable Context context, @NotNull String str) {
        INSTANCE.showTips(context, str);
    }

    @Override // com.tencent.luggage.ui.WxaAppLibNotSupportTipsUI, com.tencent.luggage.wxa.ga.a, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Context applicationContext = getApplicationContext();
        if (applicationContext != null) {
            com.tencent.luggage.wxa.q7.b.a(applicationContext);
        }
        super.onCreate(savedInstanceState);
    }
}
