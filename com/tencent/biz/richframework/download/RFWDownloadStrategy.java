package com.tencent.biz.richframework.download;

import android.content.SharedPreferences;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class RFWDownloadStrategy {
    public boolean allowGeneratedNoMedia() {
        return true;
    }

    public abstract String getBusinessKey();

    public String getDownloadRootPath() {
        File externalFilesDir = RFWApplication.getApplication().getExternalFilesDir(null);
        StringBuilder sb5 = new StringBuilder();
        String str = File.separator;
        sb5.append(str);
        sb5.append(getBusinessKey());
        sb5.append(str);
        String sb6 = sb5.toString();
        if (externalFilesDir == null) {
            return RFWApplication.getApplication().getFilesDir().getAbsolutePath() + sb6;
        }
        return externalFilesDir.getAbsolutePath() + sb6;
    }

    @Deprecated
    public abstract SharedPreferences getSP();

    public boolean isSupplementFileExtensionName() {
        return false;
    }

    public abstract boolean supportBreakPointDownload();

    public abstract boolean supportUnZipFile();

    public boolean useSimpleFileName(String str) {
        return false;
    }
}
