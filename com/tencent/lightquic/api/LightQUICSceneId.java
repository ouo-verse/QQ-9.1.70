package com.tencent.lightquic.api;

import com.tencent.component.media.MtpConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/lightquic/api/LightQUICSceneId;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "SCENE_ID_SHORT_VIDEO_PHOTO", "SCENE_ID_QCIRCLE_SHORT_VIDEO", "LightQUIC_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class LightQUICSceneId {
    private static final /* synthetic */ LightQUICSceneId[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final LightQUICSceneId SCENE_ID_QCIRCLE_SHORT_VIDEO;
    public static final LightQUICSceneId SCENE_ID_SHORT_VIDEO_PHOTO;
    private final int id;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        LightQUICSceneId lightQUICSceneId = new LightQUICSceneId("SCENE_ID_SHORT_VIDEO_PHOTO", 0, 1);
        SCENE_ID_SHORT_VIDEO_PHOTO = lightQUICSceneId;
        LightQUICSceneId lightQUICSceneId2 = new LightQUICSceneId("SCENE_ID_QCIRCLE_SHORT_VIDEO", 1, 2);
        SCENE_ID_QCIRCLE_SHORT_VIDEO = lightQUICSceneId2;
        $VALUES = new LightQUICSceneId[]{lightQUICSceneId, lightQUICSceneId2};
    }

    LightQUICSceneId(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.id = i16;
        }
    }

    public static LightQUICSceneId valueOf(String str) {
        return (LightQUICSceneId) Enum.valueOf(LightQUICSceneId.class, str);
    }

    public static LightQUICSceneId[] values() {
        return (LightQUICSceneId[]) $VALUES.clone();
    }

    public final int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.id;
    }
}
