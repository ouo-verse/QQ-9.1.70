package com.tencent.mobileqq.troop.essence.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopCardEssenceMsg implements Serializable {
    static IPatchRedirector $redirector_;
    public String jumpUrl;
    public List<EssenceMsgContent> msgContent;
    public String troopUin;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class EssenceMsgContent implements Serializable {
        static IPatchRedirector $redirector_;
        public int faceIndext;
        public String faceText;
        public String fileName;
        public long fileSize;
        public String fileThumbnailUrl;
        public String imageThumbnailUrl;
        public String imageUrl;
        public String jumpUrlForMore;
        public int msgType;
        public String shareAction;
        public String shareBrief;
        public String shareImageUrl;
        public String shareSource;
        public String shareSummary;
        public String shareTitle;
        public String shareUrl;
        public String text;

        public EssenceMsgContent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopCardEssenceMsg.this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "EssenceMsgContent{msgType=" + this.msgType + ", text='" + this.text + "', faceIndext=" + this.faceIndext + ", faceText='" + this.faceText + "', imageUrl='" + this.imageUrl + "', imageThumbnailUrl='" + this.imageThumbnailUrl + "', shareTitle='" + this.shareTitle + "', shareSummary='" + this.shareSummary + "', shareBrief='" + this.shareBrief + "', shareUrl='" + this.shareUrl + "', shareAction='" + this.shareAction + "', shareSource='" + this.shareSource + "', shareImageUrl='" + this.shareImageUrl + "', fileName='" + this.fileName + "', fileSize=" + this.fileSize + ", fileThumbnailUrl='" + this.fileThumbnailUrl + "', jumpUrlForMore='" + this.jumpUrlForMore + "'}";
        }
    }

    public TroopCardEssenceMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TroopCardEssenceMsg{troopUin='" + this.troopUin + "', jumpUrl='" + this.jumpUrl + "', msgContent=" + this.msgContent + '}';
    }
}
