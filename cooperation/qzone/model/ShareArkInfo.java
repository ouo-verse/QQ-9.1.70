package cooperation.qzone.model;

import NS_MOBILE_FEEDS.s_arkshare;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ShareArkInfo implements Serializable {
    public String mArkContent;
    public String mArkId;
    public String mViewId;

    public static ShareArkInfo convertFromArkShare(s_arkshare s_arkshareVar) {
        if (s_arkshareVar == null) {
            return null;
        }
        ShareArkInfo shareArkInfo = new ShareArkInfo();
        shareArkInfo.mArkContent = s_arkshareVar.ark_content;
        shareArkInfo.mArkId = s_arkshareVar.ark_id;
        shareArkInfo.mViewId = s_arkshareVar.view_id;
        return shareArkInfo;
    }
}
