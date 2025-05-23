package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/emoticon/f;", "Lcom/tencent/mobileqq/emoticon/a;", "Lorg/json/JSONObject;", "a", "Lorg/json/JSONObject;", "b", "()Lorg/json/JSONObject;", "faceConfigJson", "extAniStickerConfigJson", "<init>", "(Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class f implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final JSONObject faceConfigJson;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final JSONObject extAniStickerConfigJson;

    public f(@Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jSONObject, (Object) jSONObject2);
        } else {
            this.faceConfigJson = jSONObject;
            this.extAniStickerConfigJson = jSONObject2;
        }
    }

    @Nullable
    public final JSONObject a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JSONObject) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.extAniStickerConfigJson;
    }

    @Nullable
    public final JSONObject b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.faceConfigJson;
    }
}
