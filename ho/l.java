package ho;

import android.content.Context;
import com.qzone.business.vip.QZoneVIPUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public class l implements a {
    public void a(Context context, int i3, int i16, String str) {
        String str2;
        if (context == null) {
            return;
        }
        boolean b16 = QZoneVIPUtils.b(i16);
        String string = context.getString(R.string.gpl);
        if (!QzoneCoverConst.CoverStringType.COVER_TYPE_NEW_VIDEO_COVER.equals(str)) {
            str2 = "jhan_shipincover";
        } else if (b16) {
            str2 = "jhan_shipincoverhh";
        } else {
            str2 = "jhan_shipincoversj";
        }
        ak.Q(context, ak.s(context, str2, string, false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip(), b16 ? 2 : 0), i3);
    }
}
