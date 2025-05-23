package e23;

import com.tencent.mobileqq.vip.api.IVipPayApi;
import cooperation.qzone.QUA;
import java.net.URLEncoder;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001a\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\u0005"}, d2 = {"", "aid", "", "needCode", "b", "vas-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(String str, boolean z16) {
        String qua3;
        StringBuilder sb5;
        String str2;
        String str3 = IVipPayApi.PF_SUFFIX;
        if (z16) {
            qua3 = QUA.getQUA3();
            str3 = URLEncoder.encode(IVipPayApi.PF_SUFFIX);
            sb5 = new StringBuilder();
            str2 = "%2A";
        } else {
            qua3 = QUA.getQUA3();
            sb5 = new StringBuilder();
            str2 = "*";
        }
        sb5.append(str2);
        sb5.append(qua3);
        sb5.append(str3);
        return IVipPayApi.PF_PREFIX + str + sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String c(String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return b(str, z16);
    }
}
