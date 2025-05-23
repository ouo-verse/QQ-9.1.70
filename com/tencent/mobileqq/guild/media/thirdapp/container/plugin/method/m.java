package com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method;

import android.os.Bundle;
import com.tencent.mobileqq.guild.media.thirdapp.ScreenMode;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/m;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/o;", "", "f", "b", "url", "Lorg/json/JSONObject;", "args", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/c;", "callback", "", "c", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class m extends o {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final HashMap<ScreenMode, String> f229341e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR3\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/m$a;", "", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/guild/media/thirdapp/ScreenMode;", "", "Lkotlin/collections/HashMap;", "SCREEN_MODE_REPORT", "Ljava/util/HashMap;", "a", "()Ljava/util/HashMap;", "BUNDLE_KEY", "Ljava/lang/String;", "METHOD_TAG", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.m$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HashMap<ScreenMode, String> a() {
            return m.f229341e;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/m$b", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;", "", "code", "", "msg", "Landroid/os/Bundle;", "extra", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.thirdapp.container.intent.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c f229342a;

        b(com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c cVar) {
            this.f229342a = cVar;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.c
        public void a(long code, @Nullable String msg2, @NotNull Bundle extra) {
            Intrinsics.checkNotNullParameter(extra, "extra");
            String string = extra.getString("ScreenModeInfo");
            if (string == null) {
                string = "";
            }
            Logger.f235387a.d().d("GetScreenModeInfoMethod", 1, "[onInvoke] contentObject " + string);
            c.a.a(this.f229342a, new JSONObject(string), false, 2, null);
        }
    }

    static {
        HashMap<ScreenMode, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(ScreenMode.UNKNOWN, "-1"), TuplesKt.to(ScreenMode.NORMAL, "0"), TuplesKt.to(ScreenMode.LAND, "1"), TuplesKt.to(ScreenMode.FULL_PORTRAIT, "2"));
        f229341e = hashMapOf;
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    @NotNull
    public String b() {
        return "getScreenModeInfo";
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.o, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    public boolean c(@NotNull String url, @Nullable JSONObject args, @NotNull com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (args == null) {
            return true;
        }
        Logger.f235387a.d().d("GetScreenModeInfoMethod", 1, "getScreenModeInfo [onInvoke], args: " + args);
        g(new ToolProcessIntent.GetScreenContentSizeIntent(new b(callback)));
        return true;
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.o
    @NotNull
    public String f() {
        return "GetScreenModeInfoMethod";
    }
}
