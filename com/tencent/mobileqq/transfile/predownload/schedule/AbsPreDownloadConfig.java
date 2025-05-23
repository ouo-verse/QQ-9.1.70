package com.tencent.mobileqq.transfile.predownload.schedule;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import java.util.Map;

/* loaded from: classes19.dex */
public abstract class AbsPreDownloadConfig {
    static IPatchRedirector $redirector_;

    public AbsPreDownloadConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NonNull
    public abstract List<String> cleanResOnVersionUpdate(int i3, int i16);

    public abstract Map<Integer, String> getBusinessEnglishName();

    public abstract Map<Integer, String> getBusinessName();

    public abstract Map<Integer, Integer> getBusinessPriority();

    public abstract int getVersion();

    public abstract List<Integer> getWhiteList();
}
