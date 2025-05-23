package ds1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.config.r;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.GuildChannelSwitchManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelState;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProStickyChannel;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserChannelStateInfo;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.mobileqq.qqguildsdk.data.cz;
import com.tencent.mobileqq.qqguildsdk.data.dt;
import com.tencent.mobileqq.qqguildsdk.data.fd;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {
    private static HashMap<String, cz> a(List<cz> list) {
        HashMap<String, cz> hashMap = new HashMap<>();
        for (cz czVar : list) {
            hashMap.put(czVar.getChannelId(), czVar);
        }
        return hashMap;
    }

    private static boolean b(dt dtVar, String str) {
        if (dtVar != null && !dtVar.getChannelStateList().isEmpty()) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Lt.GuildAvatarStateIconUtil", 2, "checkGuildState, guildId:", str, " no state");
        }
        return false;
    }

    private static r c(cz czVar, IGProUserChannelStateInfo iGProUserChannelStateInfo, StringBuilder sb5) {
        IAudioChannelState iAudioChannelState = (IAudioChannelState) czVar;
        sb5.append(iAudioChannelState);
        sb5.append("; ");
        boolean i3 = i(czVar, iGProUserChannelStateInfo);
        if (iAudioChannelState.getChannelState() == 6) {
            if (i3) {
                return r.e(7);
            }
            return r.e(8);
        }
        if (iAudioChannelState.getChannelState() == 4) {
            if (i3) {
                return r.e(2);
            }
            return r.e(6);
        }
        if (iAudioChannelState.getChannelState() == 9) {
            if (i3) {
                return r.e(11);
            }
            return r.e(12);
        }
        if (iAudioChannelState.getChannelState() == 18) {
            if (i3) {
                return r.e(13);
            }
            return r.e(14);
        }
        if (iAudioChannelState.getChannelState() == 17) {
            if (i3) {
                return r.e(16);
            }
            return r.e(15);
        }
        return new r();
    }

    private static r d(cz czVar, IGProUserChannelStateInfo iGProUserChannelStateInfo, StringBuilder sb5) {
        r rVar = new r();
        if (czVar.getChannelType() == 5) {
            return f(czVar, iGProUserChannelStateInfo, sb5);
        }
        if (czVar.getChannelType() == 2) {
            return c(czVar, iGProUserChannelStateInfo, sb5);
        }
        return rVar;
    }

    public static r e(String str) {
        dt guildState = ((IGPSService) ch.R0(IGPSService.class)).getGuildState(str);
        r rVar = new r();
        if (!b(guildState, str)) {
            return rVar;
        }
        IGProUserChannelStateInfo b16 = guildState.b();
        StringBuilder sb5 = new StringBuilder("getGuildStateIconInfo:");
        sb5.append("[");
        sb5.append(guildState.getGuildId());
        sb5.append("] ");
        sb5.append("enterState:");
        sb5.append(b16);
        sb5.append(" ");
        List<cz> g16 = g(str, a(guildState.getChannelStateList()));
        ArrayList<IGProStickyChannel> arrayList = new ArrayList();
        sb5.append("stickyChannels: size=");
        sb5.append(arrayList.size());
        for (IGProStickyChannel iGProStickyChannel : arrayList) {
            sb5.append(" [channelId=");
            sb5.append(iGProStickyChannel.getChannelId());
            sb5.append(" type=");
            sb5.append(iGProStickyChannel.getChannelType());
            sb5.append("] ");
        }
        r rVar2 = null;
        r rVar3 = null;
        r rVar4 = null;
        r rVar5 = null;
        for (cz czVar : g16) {
            if (b16.getUserState() == 1 && TextUtils.equals(czVar.getChannelId(), String.valueOf(b16.getChannelId()))) {
                r d16 = d(czVar, b16, sb5);
                if (l(d16)) {
                    sb5.append(" result: ");
                    sb5.append(d16);
                    if (QLog.isColorLevel()) {
                        QLog.d("Guild.MF.Lt.GuildAvatarStateIconUtil", 2, sb5);
                    }
                    return d16;
                }
            }
            r d17 = d(czVar, b16, sb5);
            if (d17.d() != 0) {
                if (j(czVar)) {
                    if (k(arrayList, czVar.getChannelId())) {
                        rVar2 = n(rVar2, d17);
                    } else {
                        rVar3 = n(rVar3, d17);
                    }
                } else if (k(arrayList, czVar.getChannelId())) {
                    rVar4 = n(rVar4, d17);
                } else {
                    rVar5 = n(rVar5, d17);
                }
            }
        }
        if (l(rVar2)) {
            rVar = rVar2;
        } else if (l(rVar3)) {
            rVar = rVar3;
        } else if (l(rVar4)) {
            rVar = rVar4;
        } else if (l(rVar5)) {
            rVar = rVar5;
        }
        sb5.append(" result: ");
        sb5.append(rVar);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Lt.GuildAvatarStateIconUtil", 2, sb5);
        }
        return rVar;
    }

    private static r f(cz czVar, IGProUserChannelStateInfo iGProUserChannelStateInfo, StringBuilder sb5) {
        r rVar = new r();
        fd fdVar = (fd) czVar;
        sb5.append(fdVar);
        sb5.append("; ");
        if (fdVar.getChannelState() != 1) {
            return rVar;
        }
        if (!i(czVar, iGProUserChannelStateInfo)) {
            return r.e(3);
        }
        if (!c.b(czVar.getGuildId(), czVar.getChannelId())) {
            return r.e(0);
        }
        return r.e(1);
    }

    private static List<cz> g(String str, HashMap<String, cz> hashMap) {
        List<String> h16 = h(str);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = h16.iterator();
        while (it.hasNext()) {
            cz czVar = hashMap.get(it.next());
            if (czVar != null) {
                arrayList.add(czVar);
            }
        }
        return arrayList;
    }

    @NonNull
    private static List<String> h(String str) {
        List<cy> channelCategoryList = ((IGPSService) ch.R0(IGPSService.class)).getChannelCategoryList(str);
        ArrayList arrayList = new ArrayList();
        Iterator<cy> it = channelCategoryList.iterator();
        while (it.hasNext()) {
            for (IGProChannelInfo iGProChannelInfo : it.next().getChannelList()) {
                if (m(str, iGProChannelInfo.getType())) {
                    arrayList.add(iGProChannelInfo.getChannelUin());
                }
            }
        }
        return arrayList;
    }

    private static boolean i(cz czVar, IGProUserChannelStateInfo iGProUserChannelStateInfo) {
        if (iGProUserChannelStateInfo.getUserState() == 1 && TextUtils.equals(czVar.getChannelId(), String.valueOf(iGProUserChannelStateInfo.getChannelId()))) {
            return true;
        }
        return false;
    }

    private static boolean j(cz czVar) {
        if (czVar.getChannelType() == 5 && ((fd) czVar).getChannelState() == 1) {
            return true;
        }
        if (czVar.getChannelType() == 8 && ((IAudioChannelState) czVar).getChannelState() == 8) {
            return true;
        }
        if (czVar.getChannelType() == 2) {
            IAudioChannelState iAudioChannelState = (IAudioChannelState) czVar;
            if (iAudioChannelState.getChannelState() == 6 || iAudioChannelState.getChannelState() == 18) {
                return true;
            }
            return false;
        }
        return false;
    }

    private static boolean k(List<IGProStickyChannel> list, String str) {
        Iterator<IGProStickyChannel> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().getChannelId(), str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean l(r rVar) {
        if (rVar != null && rVar.d() != 0) {
            return true;
        }
        return false;
    }

    private static boolean m(String str, int i3) {
        if (i3 == 8 && !GuildChannelSwitchManager.g(str)) {
            QLog.w("Guild.MF.Lt.GuildAvatarStateIconUtil", 1, "worldChannelNotEnable guildId:" + str);
            return false;
        }
        if (i3 != 2 || GuildChannelSwitchManager.f(str)) {
            return true;
        }
        QLog.w("Guild.MF.Lt.GuildAvatarStateIconUtil", 1, "voiceChannelNotEnable guildId:" + str);
        return false;
    }

    private static r n(r rVar, r rVar2) {
        if (rVar != null && rVar2 != null) {
            if (rVar2.c() < rVar.c()) {
                return rVar2;
            }
            return rVar;
        }
        return rVar2;
    }
}
