package com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method;

import com.tencent.mobileqq.guild.media.core.logic.trtc.TRTCAudioRoomLocalNew;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/y;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/o;", "", "f", "b", "url", "Lorg/json/JSONObject;", "args", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/c;", "callback", "", "c", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class y extends o {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/y$b", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/u;", "", "id", "errCode", "", "onStart", "", "currentProgress", "duration", "onPlayProgress", "onComplete", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.core.logic.trtc.u {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c f229359a;

        b(com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c cVar) {
            this.f229359a = cVar;
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.u
        public void onComplete(int id5, int errCode) {
            com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c cVar = this.f229359a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("callbackName", "onComplete");
            jSONObject.put("id", id5);
            jSONObject.put("errCode", errCode);
            cVar.a(jSONObject, true);
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.u
        public void onPlayProgress(int id5, long currentProgress, long duration) {
            com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c cVar = this.f229359a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("callbackName", "onPlayProgress");
            jSONObject.put("id", id5);
            jSONObject.put("currentProgress", currentProgress);
            jSONObject.put("duration", duration);
            cVar.a(jSONObject, true);
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.u
        public void onStart(int id5, int errCode) {
            com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c cVar = this.f229359a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("callbackName", "onStart");
            jSONObject.put("id", id5);
            jSONObject.put("errCode", errCode);
            cVar.a(jSONObject, true);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    @NotNull
    public String b() {
        return "playMusic";
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.o, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    public boolean c(@NotNull String url, @Nullable JSONObject args, @NotNull com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (args == null) {
            return true;
        }
        Logger.f235387a.d().d("StartPlayMusicMethod", 1, "playMusic [onInvoke], args: " + args);
        int optInt = args.optInt("id", 0);
        String path = args.optString("path", "");
        long optLong = args.optLong("startTime", 0L);
        int optInt2 = args.optInt("loopCount", 0);
        TRTCAudioRoomLocalNew a16 = TRTCAudioRoomLocalNew.INSTANCE.a();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        int v3 = a16.v(optInt, path, optInt2, optLong, new b(callback));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", optInt);
        jSONObject.put("errCode", v3);
        c.a.a(callback, jSONObject, false, 2, null);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.o
    @NotNull
    public String f() {
        return "StartPlayMusicMethod";
    }
}
