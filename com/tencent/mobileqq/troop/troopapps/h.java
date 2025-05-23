package com.tencent.mobileqq.troop.troopapps;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import java.util.Collection;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h {
    static IPatchRedirector $redirector_;

    public static String a(Collection<TroopAIOAppInfo> collection) {
        StringBuilder sb5 = new StringBuilder();
        if (g.d(collection)) {
            sb5.append("empty apps");
        } else {
            sb5.append("[gray+ red*]");
            for (TroopAIOAppInfo troopAIOAppInfo : collection) {
                if (troopAIOAppInfo.isGray) {
                    sb5.append(Marker.ANY_NON_NULL_MARKER);
                }
                if (troopAIOAppInfo.redPoint) {
                    sb5.append("*");
                }
                if (!TextUtils.isEmpty(troopAIOAppInfo.name)) {
                    sb5.append(troopAIOAppInfo.name);
                } else {
                    sb5.append("id:");
                    sb5.append(troopAIOAppInfo.appid);
                }
                sb5.append(" ");
            }
        }
        return sb5.toString();
    }
}
