package fj;

import com.tencent.qqnt.kernel.nativeinterface.StPicUrl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/StPicUrl;", "", "a", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class u {
    public static final boolean a(StPicUrl stPicUrl) {
        if (stPicUrl == null) {
            return false;
        }
        String str = stPicUrl.url;
        return !(str == null || str.length() == 0);
    }
}
