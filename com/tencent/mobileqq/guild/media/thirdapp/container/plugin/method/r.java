package com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method;

import com.tencent.mobileqq.guild.media.core.notify.ba;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.EntryType;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/r;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/o;", "", "b", "url", "Lorg/json/JSONObject;", "args", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/c;", "callback", "", "c", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class r extends o {
    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    @NotNull
    public String b() {
        return "lifeNodeNotice";
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.o, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    public boolean c(@NotNull String url, @Nullable JSONObject args, @NotNull com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (args == null) {
            return true;
        }
        Logger.f235387a.d().d("PageLoadReportMethod", 1, "lifeNodeNotice [onInvoke], args: " + args);
        long optLong = args.optLong("webview_finish", 0L);
        long optLong2 = args.optLong("dom_ready", 0L);
        long optLong3 = args.optLong("loaded", 0L);
        if (e().getHostProvider().a() == EntryType.MINI_APP) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.guild.media.core.j.d().i(new ba(optLong, optLong2, optLong3, z16));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", 0);
        c.a.a(callback, jSONObject, false, 2, null);
        return super.c(url, args, callback);
    }
}
