package lb1;

import android.text.TextUtils;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {
    public static String a(Map<String, VipComicFavorEmoStructMsgInfo> map, String str) {
        VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo;
        if (TextUtils.isEmpty(str) || map == null || map.size() == 0 || (vipComicFavorEmoStructMsgInfo = map.get(str.toUpperCase())) == null) {
            return null;
        }
        return vipComicFavorEmoStructMsgInfo.actionData;
    }
}
