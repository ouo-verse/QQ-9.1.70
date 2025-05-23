package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneJumpUrlApi;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/app/parser/af;", "Lcom/tencent/mobileqq/utils/ax;", "", "b", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class af extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/app/parser/af$a;", "", "", "BGCOLOR", "Ljava/lang/String;", "FILTER_DEVICE", "HEIGHT", "ID", "TAG", Global.TRACKING_URL, "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.parser.af$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54641);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(@NotNull QQAppInterface app, @NotNull Context context) {
        super(app, context);
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            if (this.f307441f.containsKey("url") && this.f307441f.containsKey("height")) {
                String decode = URLDecoder.decode(this.f307441f.get("url"));
                String str = this.f307441f.get("height");
                String str2 = this.f307441f.get("bgColor");
                String str3 = this.f307441f.get("filterDevice");
                if (TextUtils.isEmpty(decode) || TextUtils.isEmpty(str)) {
                    return false;
                }
                float f16 = 0.0f;
                if (str != null) {
                    try {
                        f16 = Float.parseFloat(str);
                    } catch (Exception e16) {
                        QLog.e("HalfScreenWebViewJumpAction", 2, "JumpAction parse url throws an exception: " + e16);
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putString("webViewBgColor", str2);
                if (this.f307441f.containsKey("id")) {
                    String str4 = this.f307441f.get("id");
                    if (str4 != null) {
                        i3 = Integer.parseInt(str4);
                    } else {
                        i3 = -1;
                    }
                    bundle.putInt("businessId", i3);
                }
                com.tencent.mobileqq.webview.util.f fVar = com.tencent.mobileqq.webview.util.f.f314875a;
                if (str3 == null) {
                    str3 = "";
                }
                if (fVar.i(str3)) {
                    ((IQZoneJumpUrlApi) QRoute.api(IQZoneJumpUrlApi.class)).handleUrl(this.f307437b, decode);
                    return true;
                }
                Context context = this.f307437b;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Intrinsics.checkNotNull(decode);
                fVar.k(context, decode, bundle, f16);
                return true;
            }
        } catch (Exception e17) {
            QLog.e("HalfScreenWebViewJumpAction", 2, "JumpAction parse url throw an exception: " + e17);
        }
        return false;
    }
}
