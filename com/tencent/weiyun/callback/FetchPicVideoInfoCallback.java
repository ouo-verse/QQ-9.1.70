package com.tencent.weiyun.callback;

import android.util.Pair;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.data.CBundleReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes27.dex */
public abstract class FetchPicVideoInfoCallback extends WeiyunCallback {
    static IPatchRedirector $redirector_;

    public FetchPicVideoInfoCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void onError(int i3, String str, boolean z16);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.weiyun.callback.WeiyunCallback
    public void onNativeCallback(long j3, int i3, int i16, String str, boolean z16) {
        int length;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), str, Boolean.valueOf(z16));
            return;
        }
        if (i16 == 0) {
            if (j3 == 0) {
                onSuccess(new ArrayList(0), z16);
                return;
            }
            long[] longArray = CBundleReader.getLongArray(j3, "info_list");
            CBundleReader.deleteBundle(j3);
            if (longArray == null) {
                length = 0;
            } else {
                length = longArray.length;
            }
            ArrayList arrayList = new ArrayList(length);
            if (longArray != null) {
                for (long j16 : longArray) {
                    if (j16 != 0) {
                        long j17 = CBundleReader.getLong(j16, "take_time", 0L);
                        long j18 = CBundleReader.getLong(j16, "org_file_size", 0L);
                        CBundleReader.deleteBundle(j16);
                        arrayList.add(new Pair<>(Long.valueOf(j17), Long.valueOf(j18)));
                    }
                }
            }
            onSuccess(arrayList, z16);
            return;
        }
        onError(i16, str, z16);
    }

    public abstract void onSuccess(List<Pair<Long, Long>> list, boolean z16);
}
