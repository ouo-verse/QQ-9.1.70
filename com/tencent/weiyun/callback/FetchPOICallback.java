package com.tencent.weiyun.callback;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.data.CBundleReader;
import com.tencent.weiyun.data.PoiItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes27.dex */
public abstract class FetchPOICallback extends WeiyunCallback {
    static IPatchRedirector $redirector_;

    public FetchPOICallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void onError(int i3, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.weiyun.callback.WeiyunCallback
    public void onNativeCallback(long j3, int i3, int i16, String str, boolean z16) {
        int length;
        PoiItem newInstance;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), str, Boolean.valueOf(z16));
            return;
        }
        if (i16 == 0) {
            if (j3 == 0) {
                onSuccess(new ArrayList(0));
                return;
            }
            long[] longArray = CBundleReader.getLongArray(j3, "poi_list");
            CBundleReader.deleteBundle(j3);
            if (longArray == null) {
                length = 0;
            } else {
                length = longArray.length;
            }
            ArrayList arrayList = new ArrayList(length);
            if (longArray != null) {
                for (long j16 : longArray) {
                    if (j16 != 0 && (newInstance = PoiItem.newInstance(j16)) != null) {
                        arrayList.add(newInstance);
                    }
                }
            }
            onSuccess(arrayList);
            return;
        }
        onError(i16, str);
    }

    public abstract void onSuccess(List<PoiItem> list);
}
