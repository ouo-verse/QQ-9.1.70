package com.tencent.weiyun.callback;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.data.CBundleReader;
import com.tencent.weiyun.data.FileItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class FetchFileListCallback extends WeiyunCallback {
    static IPatchRedirector $redirector_;

    public FetchFileListCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void onError(int i3, String str, int i16, boolean z16);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.weiyun.callback.WeiyunCallback
    public void onNativeCallback(long j3, int i3, int i16, String str, boolean z16) {
        long[] longArray;
        int length;
        int length2;
        FileItem newInstance;
        FileItem newInstance2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), str, Boolean.valueOf(z16));
            return;
        }
        if (i16 == 0) {
            if (j3 == 0) {
                onSuccess(new ArrayList(0), new ArrayList(0), i3, z16);
                return;
            }
            long j16 = CBundleReader.getLong(j3, "add_list", 0L);
            long j17 = CBundleReader.getLong(j3, "delete_list", 0L);
            CBundleReader.deleteBundle(j3);
            long[] jArr = null;
            if (j16 == 0) {
                longArray = null;
            } else {
                longArray = CBundleReader.getLongArray(j16, "file_list");
            }
            if (j17 != 0) {
                jArr = CBundleReader.getLongArray(j17, "file_list");
            }
            if (j16 != 0) {
                CBundleReader.deleteBundle(j16);
            }
            if (j17 != 0) {
                CBundleReader.deleteBundle(j17);
            }
            if (longArray == null) {
                length = 0;
            } else {
                length = longArray.length;
            }
            ArrayList arrayList = new ArrayList(length);
            if (jArr == null) {
                length2 = 0;
            } else {
                length2 = jArr.length;
            }
            ArrayList arrayList2 = new ArrayList(length2);
            if (longArray != null) {
                for (long j18 : longArray) {
                    if (j18 != 0 && (newInstance2 = FileItem.newInstance(j18)) != null) {
                        arrayList.add(newInstance2);
                    }
                }
            }
            if (jArr != null) {
                for (long j19 : jArr) {
                    if (j19 != 0 && (newInstance = FileItem.newInstance(j19)) != null) {
                        arrayList2.add(newInstance);
                    }
                }
            }
            onSuccess(arrayList, arrayList2, i3, z16);
            return;
        }
        onError(i16, str, i3, z16);
    }

    public abstract void onSuccess(List<FileItem> list, List<FileItem> list2, int i3, boolean z16);
}
