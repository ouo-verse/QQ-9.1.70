package com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method;

import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/x;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/o;", "", "url", "Lorg/json/JSONObject;", "args", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/c;", "callback", "", "c", "f", "b", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class x extends o {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/x$b", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;", "", "code", "", "msg", "Landroid/os/Bundle;", "extra", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.thirdapp.container.intent.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c f229357a;

        b(com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c cVar) {
            this.f229357a = cVar;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.c
        public void a(long code, @Nullable String msg2, @NotNull Bundle extra) {
            Intrinsics.checkNotNullParameter(extra, "extra");
            Logger.f235387a.d().d("ShowInputMethod", 1, "code " + code + ", msg " + msg2 + ", extra " + extra);
            com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c cVar = this.f229357a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("input_text", extra.getString("input_text", ""));
            jSONObject.put(QQBrowserActivity.KEY_IS_SEND, extra.getBoolean(QQBrowserActivity.KEY_IS_SEND, false));
            c.a.a(cVar, jSONObject, false, 2, null);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    @NotNull
    public String b() {
        return "showInputMethod";
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.o, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    public boolean c(@NotNull String url, @Nullable JSONObject args, @NotNull com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c callback) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger.f235387a.d().d("ShowInputMethod", 1, "[onInvoke]");
        String str3 = null;
        String str4 = "";
        if (args != null) {
            str = args.optString("hint_text", "");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (args != null) {
            str2 = args.optString("action_text", "");
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (args != null) {
            str3 = args.optString(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, "");
        }
        if (str3 != null) {
            str4 = str3;
        }
        g(new ToolProcessIntent.ShowInputIntent(str, str2, str4, new b(callback)));
        return super.c(url, args, callback);
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.o
    @NotNull
    public String f() {
        return "ShowInputMethod";
    }
}
