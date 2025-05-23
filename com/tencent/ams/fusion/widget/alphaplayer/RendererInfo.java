package com.tencent.ams.fusion.widget.alphaplayer;

import com.tencent.ams.fusion.widget.alphaplayer.gl.FormatType;
import com.tencent.ams.fusion.widget.alphaplayer.gl.ScaleType;
import com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RendererInfo {
    static IPatchRedirector $redirector_;
    private IPlayer decoderPlayer;
    private int decoderType;
    private final FormatType formatType;
    private final int height;
    private final Executor renderExecutor;
    private final ScaleType scaleType;
    private final Object surface;
    private final int width;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    @interface DecoderType {
        public static final int MANUAL = 1;
        public static final int SYSTEM = 0;
    }

    public RendererInfo(Object obj, int i3, int i16) {
        this(obj, i3, i16, ScaleType.FIT_CENTER, FormatType.ALIGNED);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, obj, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public IPlayer getDecoderPlayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (IPlayer) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.decoderPlayer;
    }

    public int getDecoderType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.decoderType;
    }

    public FormatType getFormatType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (FormatType) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.formatType;
    }

    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.height;
    }

    public Executor getRenderExecutor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Executor) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.renderExecutor;
    }

    public ScaleType getScaleType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ScaleType) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.scaleType;
    }

    public Object getSurface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.surface;
    }

    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.width;
    }

    public void setDecoderPlayer(IPlayer iPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) iPlayer);
        } else {
            this.decoderPlayer = iPlayer;
        }
    }

    public void setDecoderType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.decoderType = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "RendererInfo{surfaceTexture=" + this.surface + ", width=" + this.width + ", height=" + this.height + ", scaleType=" + this.scaleType + ", renderExecutor=" + this.renderExecutor + '}';
    }

    public RendererInfo(Object obj, int i3, int i16, ScaleType scaleType, FormatType formatType) {
        this(obj, i3, i16, scaleType, formatType, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, obj, Integer.valueOf(i3), Integer.valueOf(i16), scaleType, formatType);
    }

    public RendererInfo(Object obj, int i3, int i16, ScaleType scaleType, FormatType formatType, Executor executor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, obj, Integer.valueOf(i3), Integer.valueOf(i16), scaleType, formatType, executor);
            return;
        }
        this.surface = obj;
        this.width = i3;
        this.height = i16;
        this.scaleType = scaleType;
        this.formatType = formatType;
        this.renderExecutor = executor;
    }
}
