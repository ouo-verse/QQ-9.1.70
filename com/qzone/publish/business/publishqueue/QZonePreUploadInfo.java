package com.qzone.publish.business.publishqueue;

import android.text.TextUtils;
import com.qzone.publish.business.protocol.QZoneUploadPicRequest;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes39.dex */
public class QZonePreUploadInfo implements SmartParcelable {
    public int preUploadType = 0;

    @NeedParcel
    public String[] preUploadedPaths;

    @NeedParcel
    public QZoneUploadPicRequest preUploadingRequest;

    public boolean isPreUploaded(String str) {
        if (TextUtils.isEmpty(str) || this.preUploadedPaths == null) {
            return false;
        }
        int i3 = 0;
        while (true) {
            String[] strArr = this.preUploadedPaths;
            if (i3 >= strArr.length) {
                return false;
            }
            if (str.equals(strArr[i3])) {
                QZLog.e("QZonePreUploadInfo", "\u547d\u4e2d\u9884\u4e0a\u4f20" + str);
                ArrayList arrayList = new ArrayList(Arrays.asList(this.preUploadedPaths));
                arrayList.remove(i3);
                if (arrayList.size() > 0) {
                    String[] strArr2 = new String[arrayList.size()];
                    this.preUploadedPaths = strArr2;
                    this.preUploadedPaths = (String[]) arrayList.toArray(strArr2);
                    return true;
                }
                this.preUploadedPaths = null;
                return true;
            }
            i3++;
        }
    }

    public boolean isNowPreLoading(String str) {
        String filePath;
        return str != null && TextUtils.getTrimmedLength(str) > 0 && (filePath = this.preUploadingRequest.getFilePath()) != null && filePath.equals(str);
    }
}
