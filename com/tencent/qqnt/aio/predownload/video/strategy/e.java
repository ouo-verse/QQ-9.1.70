package com.tencent.qqnt.aio.predownload.video.strategy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/predownload/video/strategy/e;", "", "Lorg/json/JSONObject;", "configJSONObject", "", "c", "", "toString", "Lcom/tencent/qqnt/aio/predownload/video/strategy/f;", "a", "Lcom/tencent/qqnt/aio/predownload/video/strategy/f;", "()Lcom/tencent/qqnt/aio/predownload/video/strategy/f;", "configSceneAIOView", "b", "configSceneMsgReceive", "<init>", "(Lcom/tencent/qqnt/aio/predownload/video/strategy/f;Lcom/tencent/qqnt/aio/predownload/video/strategy/f;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f configSceneAIOView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f configSceneMsgReceive;

    public e(@NotNull f configSceneAIOView, @NotNull f configSceneMsgReceive) {
        Intrinsics.checkNotNullParameter(configSceneAIOView, "configSceneAIOView");
        Intrinsics.checkNotNullParameter(configSceneMsgReceive, "configSceneMsgReceive");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) configSceneAIOView, (Object) configSceneMsgReceive);
        } else {
            this.configSceneAIOView = configSceneAIOView;
            this.configSceneMsgReceive = configSceneMsgReceive;
        }
    }

    @NotNull
    public final f a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (f) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.configSceneAIOView;
    }

    @NotNull
    public final f b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.configSceneMsgReceive;
    }

    public final void c(@NotNull JSONObject configJSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) configJSONObject);
            return;
        }
        Intrinsics.checkNotNullParameter(configJSONObject, "configJSONObject");
        JSONObject optJSONObject = configJSONObject.optJSONObject("scene_aio");
        if (optJSONObject != null) {
            this.configSceneAIOView.d(optJSONObject);
        }
        JSONObject optJSONObject2 = configJSONObject.optJSONObject("scene_msg_receive");
        if (optJSONObject2 != null) {
            this.configSceneMsgReceive.d(optJSONObject2);
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "(configSceneAIOView=" + this.configSceneAIOView + ", configSceneMsgReceive=" + this.configSceneMsgReceive + ")";
    }
}
