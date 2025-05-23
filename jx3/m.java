package jx3;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\r"}, d2 = {"Ljx3/m;", "", "Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "changedInfo", "Lcom/tencent/mobileqq/data/Friends;", GuildMsgItem.NICK_FRIEND, "", "b", "Lcom/tencent/mobileqq/data/ExtensionInfo;", "extensionInfo", "a", "<init>", "()V", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f411114a = new m();

    m() {
    }

    public final boolean a(NTVasSimpleInfo changedInfo, ExtensionInfo extensionInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(changedInfo, "changedInfo");
        Intrinsics.checkNotNullParameter(extensionInfo, "extensionInfo");
        long j3 = changedInfo.pendantId;
        if (j3 != Long.MIN_VALUE) {
            extensionInfo.pendantId = j3;
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = changedInfo.pendantDiyId;
        if (i3 != Integer.MIN_VALUE) {
            extensionInfo.pendantDiyId = i3;
            z16 = true;
        }
        int i16 = changedInfo.faceId;
        if (i16 != Integer.MIN_VALUE) {
            extensionInfo.faceId = i16;
            z16 = true;
        }
        long j16 = changedInfo.faceIdUpdateTime;
        if (j16 != Long.MIN_VALUE) {
            extensionInfo.faceIdUpdateTime = j16;
            z16 = true;
        }
        long j17 = changedInfo.timestamp;
        if (j17 != Long.MIN_VALUE) {
            extensionInfo.timestamp = j17;
            z16 = true;
        }
        long j18 = changedInfo.uVipFont;
        if (j18 != Long.MIN_VALUE) {
            extensionInfo.uVipFont = j18;
            z16 = true;
        }
        int i17 = changedInfo.vipFontType;
        if (i17 != Integer.MIN_VALUE) {
            extensionInfo.vipFontType = i17;
            z16 = true;
        }
        int i18 = changedInfo.magicFont;
        if (i18 != Integer.MIN_VALUE) {
            extensionInfo.magicFont = i18;
            z16 = true;
        }
        long j19 = changedInfo.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String;
        if (j19 != Long.MIN_VALUE) {
            extensionInfo.lastUpdateTime = j19;
            z16 = true;
        }
        int i19 = changedInfo.fontEffect;
        if (i19 != Integer.MIN_VALUE) {
            extensionInfo.fontEffect = i19;
            z16 = true;
        }
        long j26 = changedInfo.fontEffectLastUpdateTime;
        if (j26 != Long.MIN_VALUE) {
            extensionInfo.fontEffectLastUpdateTime = j26;
            z16 = true;
        }
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = changedInfo.diyFontTimestampMap;
        if (concurrentHashMap != null) {
            extensionInfo.diyFontTimestampMap = concurrentHashMap;
            z16 = true;
        }
        byte[] bArr = changedInfo.diyFontConfigBytes;
        if (bArr != null) {
            extensionInfo.diyFontConfigBytes = bArr;
            z16 = true;
        }
        ConcurrentHashMap<Integer, String> concurrentHashMap2 = changedInfo.diyFontConfigMap;
        if (concurrentHashMap2 == null) {
            return z16;
        }
        extensionInfo.diyFontConfigMap = concurrentHashMap2;
        return true;
    }

    public final boolean b(NTVasSimpleInfo changedInfo, Friends friend) {
        boolean z16;
        Intrinsics.checkNotNullParameter(changedInfo, "changedInfo");
        Intrinsics.checkNotNullParameter(friend, "friend");
        int i3 = changedInfo.qqVipInfo;
        if (i3 != Integer.MIN_VALUE) {
            friend.qqVipInfo = i3;
            z16 = true;
        } else {
            z16 = false;
        }
        int i16 = changedInfo.superQqInfo;
        if (i16 != Integer.MIN_VALUE) {
            friend.superQqInfo = i16;
            z16 = true;
        }
        int i17 = changedInfo.superVipInfo;
        if (i17 != Integer.MIN_VALUE) {
            friend.superVipInfo = i17;
            z16 = true;
        }
        String str = changedInfo.medalsInfo;
        if (str != null) {
            friend.medalsInfo = str;
            z16 = true;
        }
        String str2 = changedInfo.nameplateCfgInfo;
        if (str2 != null) {
            friend.nameplateCfgInfo = str2;
            z16 = true;
        }
        long j3 = changedInfo.namePlateOfKingGameId;
        if (j3 != Long.MIN_VALUE) {
            friend.namePlateOfKingGameId = j3;
            z16 = true;
        }
        long j16 = changedInfo.namePlateOfKingLoginTime;
        if (j16 != Long.MIN_VALUE) {
            friend.namePlateOfKingLoginTime = j16;
            z16 = true;
        }
        int i18 = changedInfo.namePlateOfKingDan;
        if (i18 != Integer.MIN_VALUE) {
            friend.namePlateOfKingDan = i18;
            z16 = true;
        }
        Boolean bool = changedInfo.namePlateOfKingDanDisplatSwitch;
        if (bool != null) {
            friend.namePlateOfKingDanDisplatSwitch = bool.booleanValue();
            z16 = true;
        }
        int i19 = changedInfo.bigClubInfo;
        if (i19 != Integer.MIN_VALUE) {
            friend.bigClubInfo = i19;
            z16 = true;
        }
        int i26 = changedInfo.superVipTemplateId;
        if (i26 != Integer.MIN_VALUE) {
            friend.superVipTemplateId = i26;
            z16 = true;
        }
        int i27 = changedInfo.bigClubTemplateId;
        if (i27 != Integer.MIN_VALUE) {
            friend.bigClubTemplateId = i27;
            z16 = true;
        }
        int i28 = changedInfo.bigClubExtTemplateId;
        if (i28 != Integer.MIN_VALUE) {
            friend.bigClubExtTemplateId = i28;
            z16 = true;
        }
        int i29 = changedInfo.diyFontId;
        if (i29 != Integer.MIN_VALUE) {
            friend.diyFontId = i29;
            z16 = true;
        }
        int i36 = changedInfo.vipStartFlag;
        if (i36 != Integer.MIN_VALUE) {
            friend.vipStartFlag = i36;
            z16 = true;
        }
        String str3 = changedInfo.vipIcons;
        if (str3 != null) {
            friend.vipIcons = str3;
            z16 = true;
        }
        int i37 = changedInfo.vipDataFlag;
        if (i37 != Integer.MIN_VALUE) {
            friend.vipDataFlag = i37;
            z16 = true;
        }
        int i38 = changedInfo.gameCardId;
        if (i38 != Integer.MIN_VALUE) {
            friend.gameCardId = i38;
            z16 = true;
        }
        int i39 = changedInfo.nameplateVipType;
        if (i39 != Integer.MIN_VALUE) {
            friend.nameplateVipType = i39;
            z16 = true;
        }
        int i46 = changedInfo.grayNameplateFlag;
        if (i46 != Integer.MIN_VALUE) {
            friend.grayNameplateFlag = i46;
            z16 = true;
        }
        int i47 = changedInfo.cNewLoverDiamondFlag;
        if (i47 == Integer.MIN_VALUE) {
            return z16;
        }
        friend.cNewLoverDiamondFlag = i47;
        return true;
    }
}
