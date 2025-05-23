package com.tencent.qqnt.troopmemberlist;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.data.troop.TroopMemberSpecialTitleInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopmember.ITroopMemberSpecialCareApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/w;", "", "", TtmlNode.ATTR_TTS_ORIGIN, "c", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "ntMemberInfo", "troopUin", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "a", "memberUin", "b", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class w {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final w f362959a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63417);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f362959a = new w();
        }
    }

    w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String c(String origin) {
        int indexOf$default;
        if (TextUtils.isEmpty(origin)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        while (i3 < origin.length()) {
            if (origin.charAt(i3) == '<') {
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) origin, Typography.greater, i3, false, 4, (Object) null);
                if (indexOf$default > 0) {
                    i3 = indexOf$default;
                }
            } else {
                sb5.append(origin.charAt(i3));
            }
            i3++;
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    @NotNull
    public final TroopMemberInfo a(@NotNull MemberInfo ntMemberInfo, @NotNull String troopUin) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) ntMemberInfo, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(ntMemberInfo, "ntMemberInfo");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (QLog.isDebugVersion()) {
            QLog.d("TroopMemberInfoConverter", 4, "convert ntMemberInfo=" + ntMemberInfo);
        }
        bg.f302144a.d(ntMemberInfo.uin, ntMemberInfo);
        TroopMemberInfo troopMemberInfo = new TroopMemberInfo(troopUin, String.valueOf(ntMemberInfo.uin));
        troopMemberInfo.memberUid = ntMemberInfo.uid;
        String valueOf = String.valueOf(ntMemberInfo.uin);
        String uid = ntMemberInfo.uid;
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        String cardName = ntMemberInfo.cardName;
        Intrinsics.checkNotNullExpressionValue(cardName, "cardName");
        int i16 = ntMemberInfo.cardNameId;
        w wVar = f362959a;
        String cardName2 = ntMemberInfo.cardName;
        Intrinsics.checkNotNullExpressionValue(cardName2, "cardName");
        String c16 = wVar.c(cardName2);
        String autoRemark = ntMemberInfo.autoRemark;
        Intrinsics.checkNotNullExpressionValue(autoRemark, "autoRemark");
        String nick = ntMemberInfo.nick;
        Intrinsics.checkNotNullExpressionValue(nick, "nick");
        troopMemberInfo.nickInfo = new TroopMemberNickInfo(troopUin, valueOf, uid, cardName, i16, c16, autoRemark, nick, null, null, null, 1792, null);
        troopMemberInfo.friendnick = ntMemberInfo.nick;
        troopMemberInfo.autoremark = ntMemberInfo.autoRemark;
        troopMemberInfo.join_time = ntMemberInfo.joinTime;
        troopMemberInfo.last_active_time = ntMemberInfo.lastSpeakTime;
        troopMemberInfo.credit_level = ntMemberInfo.creditLevel;
        Boolean isSpecialCare = ((ITroopMemberSpecialCareApi) QRoute.api(ITroopMemberSpecialCareApi.class)).isSpecialCare(String.valueOf(ntMemberInfo.uin));
        if (isSpecialCare != null) {
            troopMemberInfo.isTroopFollowed = isSpecialCare.booleanValue();
        } else {
            troopMemberInfo.isTroopFollowed = ntMemberInfo.isSpecialConcerned;
        }
        troopMemberInfo.mIsShielded = ntMemberInfo.isSpecialShielded;
        long j3 = ntMemberInfo.specialTitleExpireTime;
        if (j3 == 4294967295L) {
            i3 = -1;
        } else {
            i3 = (int) j3;
        }
        String valueOf2 = String.valueOf(ntMemberInfo.uin);
        String nick2 = ntMemberInfo.nick;
        Intrinsics.checkNotNullExpressionValue(nick2, "nick");
        String memberSpecialTitle = ntMemberInfo.memberSpecialTitle;
        Intrinsics.checkNotNullExpressionValue(memberSpecialTitle, "memberSpecialTitle");
        TroopMemberSpecialTitleInfo troopMemberSpecialTitleInfo = new TroopMemberSpecialTitleInfo(troopUin, valueOf2, nick2, memberSpecialTitle, i3);
        if (!troopMemberSpecialTitleInfo.isExpired()) {
            troopMemberInfo.specialTitleInfo = troopMemberSpecialTitleInfo;
        }
        troopMemberInfo.mHonorRichFlag = (byte) ntMemberInfo.richFlag;
        troopMemberInfo.mVipType = ntMemberInfo.mssVipType;
        troopMemberInfo.mBigClubVipType = ntMemberInfo.bigClubFlag;
        troopMemberInfo.titleId = ntMemberInfo.memberTitleId;
        troopMemberInfo.realLevel = ntMemberInfo.memberRealLevel;
        byte[] groupHonor = ntMemberInfo.groupHonor;
        if (groupHonor != null) {
            Intrinsics.checkNotNullExpressionValue(groupHonor, "groupHonor");
            troopMemberInfo.honorList = com.tencent.mobileqq.troop.honor.util.a.i(groupHonor);
        }
        String str = ntMemberInfo.cardName;
        troopMemberInfo.troopColorNick = str;
        troopMemberInfo.troopColorNickId = ntMemberInfo.cardNameId;
        Intrinsics.checkNotNullExpressionValue(str, "it.troopColorNick");
        troopMemberInfo.troopnick = wVar.c(str);
        troopMemberInfo.gagTimeStamp = ntMemberInfo.shutUpTime;
        troopMemberInfo.role = ntMemberInfo.role;
        troopMemberInfo.flagEx = ntMemberInfo.memberFlagExt;
        return troopMemberInfo;
    }

    @NotNull
    public final TroopMemberInfo b(@NotNull String troopUin, @NotNull String memberUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin, (Object) memberUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        TroopMemberInfo troopMemberInfo = new TroopMemberInfo(troopUin, memberUin);
        troopMemberInfo.memberUid = "";
        troopMemberInfo.nickInfo = new TroopMemberNickInfo(troopUin, memberUin, "", "", 0, "", "", "", null, null, null, 1792, null);
        return troopMemberInfo;
    }
}
