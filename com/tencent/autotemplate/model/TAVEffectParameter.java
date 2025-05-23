package com.tencent.autotemplate.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class TAVEffectParameter {
    static IPatchRedirector $redirector_;

    @SerializedName("color")
    public String color;

    @SerializedName("content")
    public String content;

    @SerializedName("duration")
    public long duration;

    @SerializedName("filePath")
    public String filePath;

    @SerializedName(MessageForRichState.SIGN_MSG_FONT_ID)
    public String fontId;

    @SerializedName("fontName")
    public String fontName;

    @SerializedName("position")
    public StickerPosition position;

    @SerializedName("procMethod")
    public int procMethod;

    @SerializedName("rhythmOffset")
    public long rhythmOffset;

    @SerializedName("rhythmPosition")
    public long rhythmPosition;

    @SerializedName(BasicAnimation.KeyPath.ROTATION)
    public float rotation;

    @SerializedName("scale")
    public float scale;

    @SerializedName("speed")
    public float speed;

    @SerializedName("textType")
    public String textType;

    @SerializedName("type")
    public String type;

    public TAVEffectParameter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.rhythmPosition = 0L;
        this.rhythmOffset = 0L;
        this.rotation = 0.0f;
        this.scale = 1.0f;
        this.position = new StickerPosition();
    }
}
