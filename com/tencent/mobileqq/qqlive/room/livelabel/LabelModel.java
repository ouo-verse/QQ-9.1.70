package com.tencent.mobileqq.qqlive.room.livelabel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LabelModel implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int TYPE_LABEL_ENTERTAINMENT = 1;
    public static final int TYPE_LABEL_GAME = 2;
    public int gameId;
    public String iconUrl;
    public boolean isGame;
    public boolean isSelected;
    public boolean isShowIcon;
    public int secondId;
    public long thirdLabelId;
    public String title;

    public LabelModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LabelModel labelModel = (LabelModel) obj;
        if (this.secondId == labelModel.secondId && this.gameId == labelModel.gameId && this.thirdLabelId == labelModel.thirdLabelId) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return Objects.hash(Integer.valueOf(this.secondId), Integer.valueOf(this.gameId), Long.valueOf(this.thirdLabelId));
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "LabelModel{secondId=" + this.secondId + ", gameId=" + this.gameId + ", thirdLabelId=" + this.thirdLabelId + ", title='" + this.title + "', iconUrl='" + this.iconUrl + "', isShowIcon=" + this.isShowIcon + ", isSelected=" + this.isSelected + '}';
    }
}
