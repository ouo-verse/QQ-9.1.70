package com.tencent.mobileqq.guild.feed.util;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class al {
    public static String a(List<GuildMediaProgressState> list) {
        StringBuilder sb5 = new StringBuilder();
        if (com.tencent.mobileqq.utils.bl.b(list)) {
            return sb5.toString();
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (i3 != 0) {
                sb5.append("-");
            }
            sb5.append(list.get(i3).getState());
        }
        return sb5.toString();
    }

    public static String b(List<GuildMediaProgressState> list) {
        StringBuilder sb5 = new StringBuilder();
        if (com.tencent.mobileqq.utils.bl.b(list)) {
            return sb5.toString();
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (i3 != 0) {
                sb5.append("-");
            }
            sb5.append(list.get(i3).getTaskId());
        }
        return sb5.toString();
    }

    public static String c(List<GuildMediaProgressState> list) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        if (com.tencent.mobileqq.utils.bl.b(list)) {
            return sb5.toString();
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (i3 != 0) {
                sb5.append("-");
            }
            if (TextUtils.equals(list.get(i3).getType(), "video")) {
                str = "v";
            } else {
                str = "p";
            }
            sb5.append(str);
        }
        return sb5.toString();
    }
}
