package gu2;

import android.content.SharedPreferences;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.qmmkv.QMMKV;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes19.dex */
public class l extends hv2.k {
    @Override // hv2.k
    public String[] a(SharedPreferences sharedPreferences) {
        Map<String, ?> all = sharedPreferences.getAll();
        if (all != null) {
            Set<String> keySet = all.keySet();
            return (String[]) keySet.toArray(new String[keySet.size()]);
        }
        return new String[0];
    }

    @Override // hv2.k
    public SharedPreferences b(String str) {
        return QMMKV.fromSpAdapter(RFWApplication.getApplication(), str, str);
    }
}
