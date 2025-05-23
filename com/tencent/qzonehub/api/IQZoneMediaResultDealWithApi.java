package com.tencent.qzonehub.api;

import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.model.PublishEventTag;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneMediaResultDealWithApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class CommitMediaConfig {
        static IPatchRedirector $redirector_;
        public Intent dataBundle;
        public String destPageName;
        public PublishEventTag eventTag;
        public HashMap<String, PicInfo> qzonePicList;
        public int requestCode;
        public List<LocalMediaInfo> selectedMediaList;

        public CommitMediaConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    void commitMediaToDestPage(Activity activity, CommitMediaConfig commitMediaConfig);
}
