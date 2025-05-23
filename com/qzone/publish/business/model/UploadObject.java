package com.qzone.publish.business.model;

import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.mobileqq.pluginsdk.PluginStatic;

/* compiled from: P */
/* loaded from: classes39.dex */
public class UploadObject implements SmartParcelable {

    @NeedParcel
    private String mFileMd5;

    @NeedParcel
    private String mFilePath;

    public UploadObject() {
    }

    private String createFileMD5(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return PluginStatic.encodeFile(str);
    }

    public String getFileMd5() {
        return this.mFileMd5;
    }

    public String getFilePath() {
        String str = this.mFilePath;
        return str == null ? "" : str;
    }

    public void setFilePath(String str) {
        this.mFilePath = str;
        this.mFileMd5 = createFileMD5(str);
    }

    public UploadObject(String str) {
        setFilePath(str);
    }
}
