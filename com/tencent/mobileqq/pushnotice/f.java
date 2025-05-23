package com.tencent.mobileqq.pushnotice;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pushnotice.ThirdPushNotifyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/pushnotice/f;", "Lcom/tencent/mobileqq/pushnotice/b;", "Landroid/content/Intent;", "intent", "", "a", "Lcom/tencent/mobileqq/pushnotice/ThirdPushNotifyManager$PushNotificationData;", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/pushnotice/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.pushnotice.f$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59895);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.b
    public boolean a(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        return c.d(intent);
    }

    @Override // com.tencent.mobileqq.pushnotice.b
    @Nullable
    public ThirdPushNotifyManager.PushNotificationData b(@NotNull Intent intent) {
        Serializable serializable;
        int parseInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ThirdPushNotifyManager.PushNotificationData) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                serializable = extras.getSerializable("key_message");
            } else {
                serializable = null;
            }
            MiPushMessage miPushMessage = (MiPushMessage) serializable;
            if (miPushMessage == null || !miPushMessage.getExtra().containsKey("client_data")) {
                return null;
            }
            String str = miPushMessage.getExtra().get("client_data");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Intrinsics.checkNotNull(str);
            JSONObject jSONObject = new JSONObject(str);
            String thirdIdStr = jSONObject.optString("third_id");
            String typeStr = jSONObject.optString("type");
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("report_data");
            String optString3 = jSONObject.optString("token");
            String optString4 = jSONObject.optString("to_uin");
            if (TextUtils.isEmpty(thirdIdStr)) {
                QLog.i("XiaomiPushDataHandler", 1, "handlePushJumpIntent: thirdId is empty.");
                return null;
            }
            try {
                Intrinsics.checkNotNullExpressionValue(thirdIdStr, "thirdIdStr");
                int parseInt2 = Integer.parseInt(thirdIdStr);
                if (TextUtils.isEmpty(typeStr)) {
                    parseInt = -1;
                } else {
                    Intrinsics.checkNotNullExpressionValue(typeStr, "typeStr");
                    parseInt = Integer.parseInt(typeStr);
                }
                return new ThirdPushNotifyManager.PushNotificationData(parseInt2, parseInt, optString, optString2, optString3, optString4);
            } catch (NumberFormatException e16) {
                QLog.e("XiaomiPushDataHandler", 1, "handlePushJumpIntent: exception.", e16);
                return null;
            }
        } catch (Throwable th5) {
            QLog.e("XiaomiPushDataHandler", 1, "parse: exception.", th5);
            return null;
        }
    }
}
