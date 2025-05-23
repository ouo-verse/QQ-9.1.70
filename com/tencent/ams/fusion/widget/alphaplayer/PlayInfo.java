package com.tencent.ams.fusion.widget.alphaplayer;

import com.tencent.ams.fusion.widget.alphaplayer.gl.FormatType;
import com.tencent.ams.fusion.widget.alphaplayer.gl.ScaleType;
import com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class PlayInfo {
    static IPatchRedirector $redirector_;
    private IPlayer decoderPlayer;
    private int decoderType;
    private FormatType formatType;
    private boolean isLoopPlay;
    private boolean isOutputMute;
    private boolean isSurfaceViewMediaOverlay;
    private ScaleType scaleType;
    private String videoPath;
    private boolean zOrderOnTop;

    public PlayInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.zOrderOnTop = true;
            this.decoderType = 0;
        }
    }

    public IPlayer getDecoderPlayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (IPlayer) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.decoderPlayer;
    }

    public int getDecoderType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.decoderType;
    }

    public FormatType getFormatType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (FormatType) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.formatType;
    }

    public ScaleType getScaleType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ScaleType) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.scaleType;
    }

    public String getVideoPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.videoPath;
    }

    public boolean isLoopPlay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isLoopPlay;
    }

    public boolean isOutputMute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isOutputMute;
    }

    public boolean isSurfaceViewMediaOverlay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.isSurfaceViewMediaOverlay;
    }

    public boolean isZOrderOnTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.zOrderOnTop;
    }

    public void setDecoderPlayer(IPlayer iPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) iPlayer);
        } else {
            this.decoderPlayer = iPlayer;
        }
    }

    public void setDecoderType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.decoderType = i3;
        }
    }

    public void setFormatType(FormatType formatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) formatType);
        } else {
            this.formatType = formatType;
        }
    }

    public void setLoopPlay(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.isLoopPlay = z16;
        }
    }

    public void setOutputMute(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.isOutputMute = z16;
        }
    }

    public void setScaleType(ScaleType scaleType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) scaleType);
        } else {
            this.scaleType = scaleType;
        }
    }

    public void setSurfaceViewMediaOverlay(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.isSurfaceViewMediaOverlay = z16;
        }
    }

    public void setVideoPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.videoPath = str;
        }
    }

    public void setZOrderOnTop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        } else {
            this.zOrderOnTop = z16;
        }
    }
}
