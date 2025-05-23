package com.tencent.qqnt.ntrelation.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqnt.kernel.nativeinterface.StockLocalData;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.VasInfo;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$UpdateData;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$UpdateMsg;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$updateVas;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b8\u00109J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002J$\u0010\u0012\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J9\u0010\u0017\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J,\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ \u0010 \u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\u000eJ*\u0010#\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ,\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001c0'2\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\b0$j\b\u0012\u0004\u0012\u00020\b`%H\u0016JD\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001c\u0018\u00010'2\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u000e0$j\b\u0012\u0004\u0012\u00020\u000e`%2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001c\u0018\u00010'H\u0016J\\\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001c\u0018\u00010'2\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\b0$j\b\u0012\u0004\u0012\u00020\b`%2\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\b0$j\b\u0012\u0004\u0012\u00020\b`%2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001c\u0018\u00010'H\u0016J*\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010\u001a\u001a\u00020\u00192\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\b0$j\b\u0012\u0004\u0012\u00020\b`%H\u0016JB\u00101\u001a\u0004\u0018\u00010/2\u0006\u0010\u001a\u001a\u00020\u00192\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\b0$j\b\u0012\u0004\u0012\u00020\b`%2\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\b0$j\b\u0012\u0004\u0012\u00020\b`%H\u0016J*\u00102\u001a\u0004\u0018\u00010/2\u0006\u0010\u001a\u001a\u00020\u00192\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u000e0$j\b\u0012\u0004\u0012\u00020\u000e`%H\u0016J\u0018\u00105\u001a\u0004\u0018\u00010\u00192\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000103J\u0016\u00107\u001a\b\u0012\u0004\u0012\u00020\u0004032\b\u00106\u001a\u0004\u0018\u00010\u0019\u00a8\u0006:"}, d2 = {"Lcom/tencent/qqnt/ntrelation/util/m;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/VasInfo;", "vasInfo", "", "type", "defaultVal", "p", "Lkx3/a;", "ntVasDetailInfo", "Lcom/tencent/qqnt/ntrelation/protocol/ProfileUpdateMsg$updateVas;", "updateVas", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "changedInfo", "l", "originInfo", DomainData.DOMAIN_NAME, "", "enable", "isYearVip", "level", "k", "(Ljava/lang/Integer;ZZILcom/tencent/qqnt/ntrelation/protocol/ProfileUpdateMsg$updateVas;)V", "", "trace", "uid", "Lcom/tencent/qqnt/kernel/nativeinterface/StockLocalData;", "stockLocalData", "b", "result", "o", "Lcom/tencent/qqnt/kernel/nativeinterface/UserDetailInfo;", "userDetailInfo", "a", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ntVasDetailInfoList", "Ljava/util/HashMap;", tl.h.F, "changedInfoList", "stockLocalDatas", "f", "originDetailInfoList", "changedDetialInfoList", "e", "Lcom/tencent/qqnt/ntrelation/protocol/ProfileUpdateMsg$UpdateMsg;", "g", "d", "c", "", "ids", "j", "str", "i", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f360286a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37602);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            f360286a = new m();
        }
    }

    m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void k(Integer type, boolean enable, boolean isYearVip, int level, ProfileUpdateMsg$updateVas updateVas) {
        if (type != null && type.intValue() == 1) {
            updateVas.vipFlag.set(enable);
            updateVas.yearVipFlag.set(isYearVip);
            updateVas.vipLevel.set(level);
            return;
        }
        if (type != null && type.intValue() == 2) {
            updateVas.svipFlag.set(enable);
            updateVas.yearVipFlag.set(isYearVip);
            updateVas.vipLevel.set(level);
        } else if (type != null && type.intValue() == 3) {
            updateVas.bigClub.set(enable);
            updateVas.yearVipFlag.set(isYearVip);
            updateVas.bigClubLevel.set(level);
        } else {
            updateVas.vipFlag.set(false);
            updateVas.svipFlag.set(false);
            updateVas.bigClub.set(false);
            updateVas.yearVipFlag.set(isYearVip);
            updateVas.vipLevel.set(level);
        }
    }

    private final void l(NTVasSimpleInfo changedInfo, ProfileUpdateMsg$updateVas updateVas) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        if (changedInfo == null || updateVas == null) {
            return;
        }
        if (changedInfo.qqVipInfo != Integer.MIN_VALUE) {
            int i3 = changedInfo.qqVipInfo;
            if ((i3 & (-16777216)) != 0) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (((i3 & ITVKAsset.VOD_ASSET_MASK_BIT) >>> 16) == 1) {
                z27 = true;
            } else {
                z27 = false;
            }
            k(1, z26, z27, i3 & 65535, updateVas);
        }
        if (changedInfo.superVipInfo != Integer.MIN_VALUE) {
            int i16 = changedInfo.superVipInfo;
            if ((i16 & (-16777216)) != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (((i16 & ITVKAsset.VOD_ASSET_MASK_BIT) >>> 16) == 1) {
                z19 = true;
            } else {
                z19 = false;
            }
            k(2, z18, z19, i16 & 65535, updateVas);
        }
        if (changedInfo.bigClubInfo != Integer.MIN_VALUE) {
            int i17 = changedInfo.bigClubInfo;
            if ((i17 & (-16777216)) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (((i17 & ITVKAsset.VOD_ASSET_MASK_BIT) >>> 16) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            k(3, z16, z17, i17 & 65535, updateVas);
        }
    }

    private final void m(kx3.a ntVasDetailInfo, ProfileUpdateMsg$updateVas updateVas) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        if (ntVasDetailInfo == null || updateVas == null) {
            return;
        }
        if ((ntVasDetailInfo.getQqVipInfo() & (-16777216)) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (((ntVasDetailInfo.getQqVipInfo() & ITVKAsset.VOD_ASSET_MASK_BIT) >>> 16) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        k(1, z16, z17, ntVasDetailInfo.getQqVipInfo() & 65535, updateVas);
        if ((ntVasDetailInfo.getSuperVipInfo() & (-16777216)) != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (((ntVasDetailInfo.getSuperVipInfo() & ITVKAsset.VOD_ASSET_MASK_BIT) >>> 16) == 1) {
            z19 = true;
        } else {
            z19 = false;
        }
        k(2, z18, z19, ntVasDetailInfo.getSuperVipInfo() & 65535, updateVas);
        if ((ntVasDetailInfo.getBigClubInfo() & (-16777216)) != 0) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (((ntVasDetailInfo.getBigClubInfo() & ITVKAsset.VOD_ASSET_MASK_BIT) >>> 16) == 1) {
            z27 = true;
        } else {
            z27 = false;
        }
        k(3, z26, z27, ntVasDetailInfo.getBigClubInfo() & 65535, updateVas);
    }

    private final void n(kx3.a originInfo, kx3.a changedInfo, ProfileUpdateMsg$updateVas updateVas) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        if (originInfo == null || changedInfo == null || updateVas == null) {
            return;
        }
        if (changedInfo.getQqVipInfo() != originInfo.getQqVipInfo()) {
            if ((changedInfo.getQqVipInfo() & (-16777216)) != 0) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (((changedInfo.getQqVipInfo() & ITVKAsset.VOD_ASSET_MASK_BIT) >>> 16) == 1) {
                z27 = true;
            } else {
                z27 = false;
            }
            k(1, z26, z27, changedInfo.getQqVipInfo() & 65535, updateVas);
        }
        if (changedInfo.getSuperVipInfo() != originInfo.getSuperVipInfo()) {
            if ((changedInfo.getSuperVipInfo() & (-16777216)) != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (((changedInfo.getSuperVipInfo() & ITVKAsset.VOD_ASSET_MASK_BIT) >>> 16) == 1) {
                z19 = true;
            } else {
                z19 = false;
            }
            k(2, z18, z19, changedInfo.getSuperVipInfo() & 65535, updateVas);
        }
        if (changedInfo.getBigClubInfo() != originInfo.getBigClubInfo()) {
            if ((changedInfo.getBigClubInfo() & (-16777216)) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (((changedInfo.getBigClubInfo() & ITVKAsset.VOD_ASSET_MASK_BIT) >>> 16) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            k(2, z16, z17, changedInfo.getBigClubInfo() & 65535, updateVas);
        }
    }

    private final int p(VasInfo vasInfo, int type, int defaultVal) {
        int i3;
        if (type <= 3) {
            int i16 = 1;
            if (type >= 1) {
                if (type == 1 ? !vasInfo.vipFlag : type == 2 ? !vasInfo.svipFlag : !vasInfo.bigClub) {
                    i16 = 0;
                }
                if (i16 == 0) {
                    return i16;
                }
                int i17 = ((i16 << 8) | (vasInfo.yearVipFlag ? 1 : 0)) << 16;
                if (type == 3) {
                    i3 = vasInfo.bigClubLevel;
                } else {
                    i3 = vasInfo.vipLevel;
                }
                return i3 | i17;
            }
        }
        return defaultVal;
    }

    @NotNull
    public final kx3.a a(@NotNull String trace, @NotNull String uid, @Nullable UserDetailInfo userDetailInfo, @Nullable StockLocalData stockLocalData) {
        long longValue;
        long longValue2;
        int i3;
        UserSimpleInfo userSimpleInfo;
        VasInfo vasInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (kx3.a) iPatchRedirector.redirect((short) 4, this, trace, uid, userDetailInfo, stockLocalData);
        }
        Intrinsics.checkNotNullParameter(trace, "trace");
        Intrinsics.checkNotNullParameter(uid, "uid");
        kx3.a aVar = new kx3.a(null, null, 0, 0, 0, 0, null, null, 0L, 0L, 0, false, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0L, 0, 0, 0L, 0L, 0L, 0, 0, 0L, 0, 0L, null, null, null, null, -1, 127, null);
        aVar.r0(uid);
        aVar.s0(c.f360229a.m(uid));
        if (userDetailInfo != null && (userSimpleInfo = userDetailInfo.simpleInfo) != null && (vasInfo = userSimpleInfo.vasInfo) != null) {
            aVar.i0(vasInfo.nameplateVipType);
            aVar.a0(vasInfo.grayNameplateFlag);
            m mVar = f360286a;
            aVar.l0(mVar.p(vasInfo, 1, aVar.getQqVipInfo()));
            aVar.n0(mVar.p(vasInfo, 2, aVar.getQqVipInfo()));
            aVar.O(mVar.p(vasInfo, 3, aVar.getBigClubInfo()));
            aVar.f0(vasInfo.gameNameplateId);
            aVar.g0(vasInfo.gameLastLoginTime);
            aVar.d0(vasInfo.gameRank);
            aVar.e0(vasInfo.gameIconShowFlag);
            aVar.Z((int) vasInfo.gameCardId);
            aVar.o0(vasInfo.superVipTemplateId);
            aVar.P(vasInfo.superVipTemplateId);
            aVar.N(vasInfo.extendNameplateId);
            aVar.S(vasInfo.diyFontId);
            aVar.w0(vasInfo.vipStartFlag);
            String j3 = mVar.j(vasInfo.diyNameplateIDs);
            if (j3 == null) {
                j3 = "";
            }
            aVar.v0(j3);
            aVar.t0(vasInfo.vipDataFlag);
            aVar.Q(vasInfo.newLoverDiamondFlag);
            aVar.k0(vasInfo.pendantId);
            aVar.j0(vasInfo.pendantDiyId);
            aVar.V(vasInfo.faceId);
            aVar.q0(vasInfo.vipFont);
            aVar.u0(vasInfo.vipFontType);
            aVar.b0(vasInfo.magicFont);
            aVar.X(vasInfo.fontEffect);
        }
        if (stockLocalData != null) {
            aVar.c0(stockLocalData.medalsInfo);
            aVar.h0(stockLocalData.nameplateCfgInfo);
            aVar.R(new ConcurrentHashMap<>());
            HashMap<Integer, String> hashMap = stockLocalData.diyFontConfigMap;
            Intrinsics.checkNotNullExpressionValue(hashMap, "it.diyFontConfigMap");
            for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
                ConcurrentHashMap<Integer, String> f16 = aVar.f();
                if (f16 != null) {
                    f16.put(entry.getKey(), entry.getValue());
                }
            }
            Long l3 = stockLocalData.faceIdUpdateTime;
            long j16 = 0;
            if (l3 == null) {
                longValue = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(l3, "it.faceIdUpdateTime ?: 0");
                longValue = l3.longValue();
            }
            aVar.W(longValue);
            Long l16 = stockLocalData.timestamp;
            if (l16 == null) {
                longValue2 = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(l16, "it.timestamp ?: 0");
                longValue2 = l16.longValue();
            }
            aVar.p0(longValue2);
            aVar.T(stockLocalData.diyFontTimestampBytes);
            Long l17 = stockLocalData.fontEffectLastUpdateTime;
            if (l17 != null) {
                Intrinsics.checkNotNullExpressionValue(l17, "it.fontEffectLastUpdateTime ?: 0");
                j16 = l17.longValue();
            }
            aVar.Y(j16);
            aVar.U(new ConcurrentHashMap<>());
            HashMap<Integer, Long> diyFontTimestampMap = stockLocalData.diyFontTimestampMap;
            if (diyFontTimestampMap != null) {
                Intrinsics.checkNotNullExpressionValue(diyFontTimestampMap, "diyFontTimestampMap");
                for (Map.Entry<Integer, Long> entry2 : diyFontTimestampMap.entrySet()) {
                    ConcurrentHashMap<Integer, Integer> i16 = aVar.i();
                    if (i16 != null) {
                        Integer key = entry2.getKey();
                        Long value = entry2.getValue();
                        if (value != null) {
                            i3 = (int) value.longValue();
                        } else {
                            i3 = 0;
                        }
                        i16.put(key, Integer.valueOf(i3));
                    }
                }
            }
        }
        if (QLog.isColorLevel() && ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
            QLog.e("VasDataConvertUtil", 1, "trace " + trace + " KernelDataToNTVasDetailInfo " + aVar);
        }
        return aVar;
    }

    @Nullable
    public final NTVasSimpleInfo b(@NotNull String trace, @NotNull String uid, @Nullable VasInfo vasInfo, @Nullable StockLocalData stockLocalData) {
        long longValue;
        long longValue2;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (NTVasSimpleInfo) iPatchRedirector.redirect((short) 2, this, trace, uid, vasInfo, stockLocalData);
        }
        Intrinsics.checkNotNullParameter(trace, "trace");
        Intrinsics.checkNotNullParameter(uid, "uid");
        if (vasInfo == null && (stockLocalData == null || (stockLocalData.medalsInfo == null && stockLocalData.nameplateCfgInfo == null && stockLocalData.diyFontConfigMap.size() == 0 && stockLocalData.faceIdUpdateTime == null && stockLocalData.timestamp == null && stockLocalData.diyFontTimestampBytes == null && stockLocalData.fontEffectLastUpdateTime == null))) {
            return null;
        }
        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(null, null, 3, null);
        nTVasSimpleInfo.e(uid);
        nTVasSimpleInfo.f(c.f360229a.m(uid));
        o(trace, vasInfo, nTVasSimpleInfo);
        if (stockLocalData != null) {
            nTVasSimpleInfo.medalsInfo = stockLocalData.medalsInfo;
            nTVasSimpleInfo.nameplateCfgInfo = stockLocalData.nameplateCfgInfo;
            nTVasSimpleInfo.diyFontConfigMap = new ConcurrentHashMap<>();
            HashMap<Integer, String> hashMap = stockLocalData.diyFontConfigMap;
            Intrinsics.checkNotNullExpressionValue(hashMap, "it.diyFontConfigMap");
            for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
                ConcurrentHashMap<Integer, String> concurrentHashMap = nTVasSimpleInfo.diyFontConfigMap;
                if (concurrentHashMap != null) {
                    concurrentHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Long l3 = stockLocalData.faceIdUpdateTime;
            long j3 = 0;
            if (l3 == null) {
                longValue = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(l3, "it.faceIdUpdateTime ?: 0");
                longValue = l3.longValue();
            }
            nTVasSimpleInfo.faceIdUpdateTime = longValue;
            Long l16 = stockLocalData.timestamp;
            if (l16 == null) {
                longValue2 = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(l16, "it.timestamp ?: 0");
                longValue2 = l16.longValue();
            }
            nTVasSimpleInfo.timestamp = longValue2;
            nTVasSimpleInfo.diyFontTimestampBytes = stockLocalData.diyFontTimestampBytes;
            Long l17 = stockLocalData.fontEffectLastUpdateTime;
            if (l17 != null) {
                Intrinsics.checkNotNullExpressionValue(l17, "it.fontEffectLastUpdateTime ?: 0");
                j3 = l17.longValue();
            }
            nTVasSimpleInfo.fontEffectLastUpdateTime = j3;
            nTVasSimpleInfo.diyFontTimestampMap = new ConcurrentHashMap<>();
            HashMap<Integer, Long> diyFontTimestampMap = stockLocalData.diyFontTimestampMap;
            if (diyFontTimestampMap != null) {
                Intrinsics.checkNotNullExpressionValue(diyFontTimestampMap, "diyFontTimestampMap");
                for (Map.Entry<Integer, Long> entry2 : diyFontTimestampMap.entrySet()) {
                    ConcurrentHashMap<Integer, Integer> concurrentHashMap2 = nTVasSimpleInfo.diyFontTimestampMap;
                    if (concurrentHashMap2 != null) {
                        Integer key = entry2.getKey();
                        Long value = entry2.getValue();
                        if (value != null) {
                            i3 = (int) value.longValue();
                        } else {
                            i3 = 0;
                        }
                        concurrentHashMap2.put(key, Integer.valueOf(i3));
                    }
                }
            }
        }
        if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
            QLog.e("VasDataConvertUtil", 1, "trace " + trace + " convertKernelDataToNTVasSimpleInfo " + nTVasSimpleInfo);
        }
        return nTVasSimpleInfo;
    }

    @Nullable
    public ProfileUpdateMsg$UpdateMsg c(@NotNull String trace, @NotNull ArrayList<NTVasSimpleInfo> changedInfoList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ProfileUpdateMsg$UpdateMsg) iPatchRedirector.redirect((short) 11, (Object) this, (Object) trace, (Object) changedInfoList);
        }
        Intrinsics.checkNotNullParameter(trace, "trace");
        Intrinsics.checkNotNullParameter(changedInfoList, "changedInfoList");
        ProfileUpdateMsg$UpdateMsg profileUpdateMsg$UpdateMsg = new ProfileUpdateMsg$UpdateMsg();
        ArrayList arrayList = new ArrayList();
        int size = changedInfoList.size();
        for (int i3 = 0; i3 < size; i3++) {
            NTVasSimpleInfo nTVasSimpleInfo = changedInfoList.get(i3);
            Intrinsics.checkNotNullExpressionValue(nTVasSimpleInfo, "changedInfoList[index]");
            NTVasSimpleInfo nTVasSimpleInfo2 = nTVasSimpleInfo;
            if (!TextUtils.isEmpty(nTVasSimpleInfo2.getUid()) && !TextUtils.isEmpty(nTVasSimpleInfo2.getUin()) && c.f360229a.o(nTVasSimpleInfo2.getUin())) {
                ProfileUpdateMsg$UpdateData profileUpdateMsg$UpdateData = new ProfileUpdateMsg$UpdateData();
                profileUpdateMsg$UpdateData.uid.set(nTVasSimpleInfo2.getUid());
                profileUpdateMsg$UpdateData.uin.set(Long.parseLong(nTVasSimpleInfo2.getUin()));
                ProfileUpdateMsg$updateVas profileUpdateMsg$updateVas = new ProfileUpdateMsg$updateVas();
                int i16 = nTVasSimpleInfo2.nameplateVipType;
                if (i16 != Integer.MIN_VALUE) {
                    profileUpdateMsg$updateVas.nameplateVipType.set(i16);
                }
                int i17 = nTVasSimpleInfo2.grayNameplateFlag;
                if (i17 != Integer.MIN_VALUE) {
                    profileUpdateMsg$updateVas.grayNameplateFlag.set(i17);
                }
                l(nTVasSimpleInfo2, profileUpdateMsg$updateVas);
                long j3 = nTVasSimpleInfo2.namePlateOfKingGameId;
                if (j3 != Long.MIN_VALUE) {
                    profileUpdateMsg$updateVas.gameNameplateId.set(j3);
                }
                long j16 = nTVasSimpleInfo2.namePlateOfKingLoginTime;
                if (j16 != Long.MIN_VALUE) {
                    profileUpdateMsg$updateVas.gameLastLoginTime.set(j16);
                }
                int i18 = nTVasSimpleInfo2.namePlateOfKingDan;
                if (i18 != Integer.MIN_VALUE) {
                    profileUpdateMsg$updateVas.gameRank.set(i18);
                }
                Boolean bool = nTVasSimpleInfo2.namePlateOfKingDanDisplatSwitch;
                if (bool != null) {
                    profileUpdateMsg$updateVas.gameIconShowFlag.set(bool.booleanValue());
                }
                int i19 = nTVasSimpleInfo2.gameCardId;
                if (i19 != Integer.MIN_VALUE) {
                    profileUpdateMsg$updateVas.gameCardId.set(i19);
                    nTVasSimpleInfo2 = nTVasSimpleInfo2;
                }
                int i26 = nTVasSimpleInfo2.superVipTemplateId;
                if (i26 != Integer.MIN_VALUE) {
                    profileUpdateMsg$updateVas.superVipTemplateId.set(i26);
                }
                int i27 = nTVasSimpleInfo2.bigClubExtTemplateId;
                if (i27 != Integer.MIN_VALUE) {
                    profileUpdateMsg$updateVas.extendNameplateId.set(i27);
                }
                int i28 = nTVasSimpleInfo2.diyFontId;
                if (i28 != Integer.MIN_VALUE) {
                    profileUpdateMsg$updateVas.diyFontId.set(i28);
                }
                int i29 = nTVasSimpleInfo2.vipStartFlag;
                if (i29 != Integer.MIN_VALUE) {
                    profileUpdateMsg$updateVas.vipStartFlag.set(i29);
                }
                String str = nTVasSimpleInfo2.vipIcons;
                if (str != null) {
                    profileUpdateMsg$updateVas.diyNameplateIDs.set(f360286a.i(str));
                }
                int i36 = nTVasSimpleInfo2.vipDataFlag;
                if (i36 != Integer.MIN_VALUE) {
                    profileUpdateMsg$updateVas.vipDataFlag.set(i36);
                }
                int i37 = nTVasSimpleInfo2.cNewLoverDiamondFlag;
                if (i37 != Integer.MIN_VALUE) {
                    profileUpdateMsg$updateVas.vipDataFlag.set(i37);
                }
                long j17 = nTVasSimpleInfo2.pendantId;
                if (j17 != Long.MIN_VALUE) {
                    profileUpdateMsg$updateVas.pendantId.set((int) j17);
                }
                int i38 = nTVasSimpleInfo2.pendantDiyId;
                if (i38 != Integer.MIN_VALUE) {
                    profileUpdateMsg$updateVas.pendantDiyId.set(i38);
                }
                int i39 = nTVasSimpleInfo2.faceId;
                if (i39 != Integer.MIN_VALUE) {
                    profileUpdateMsg$updateVas.faceId.set(i39);
                }
                long j18 = nTVasSimpleInfo2.uVipFont;
                if (j18 != Long.MIN_VALUE) {
                    profileUpdateMsg$updateVas.vipFont.set((int) j18);
                }
                int i46 = nTVasSimpleInfo2.vipFontType;
                if (i46 != Integer.MIN_VALUE) {
                    profileUpdateMsg$updateVas.vipFontType.set(i46);
                }
                int i47 = nTVasSimpleInfo2.magicFont;
                if (i47 != Integer.MIN_VALUE) {
                    profileUpdateMsg$updateVas.magicFont.set(i47);
                }
                int i48 = nTVasSimpleInfo2.fontEffect;
                if (i48 != Integer.MIN_VALUE) {
                    profileUpdateMsg$updateVas.fontEffect.set(i48);
                }
                profileUpdateMsg$UpdateData.vasInfo.set(profileUpdateMsg$updateVas);
                arrayList.add(profileUpdateMsg$UpdateData);
                QLog.i("VasDataConvertUtil", 1, "trace " + trace + " NTVasDetailInfoToKernelData " + nTVasSimpleInfo2);
            }
        }
        if (QLog.isColorLevel() && ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
            QLog.i("KernelDataConvertUtil", 1, "UPDATE_DATA_NTVasDetailInfo");
        }
        profileUpdateMsg$UpdateMsg.datas.set(arrayList);
        return profileUpdateMsg$UpdateMsg;
    }

    @Nullable
    public ProfileUpdateMsg$UpdateMsg d(@NotNull String trace, @NotNull ArrayList<kx3.a> originDetailInfoList, @NotNull ArrayList<kx3.a> changedDetialInfoList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ProfileUpdateMsg$UpdateMsg) iPatchRedirector.redirect((short) 10, this, trace, originDetailInfoList, changedDetialInfoList);
        }
        Intrinsics.checkNotNullParameter(trace, "trace");
        Intrinsics.checkNotNullParameter(originDetailInfoList, "originDetailInfoList");
        Intrinsics.checkNotNullParameter(changedDetialInfoList, "changedDetialInfoList");
        if (originDetailInfoList.size() == changedDetialInfoList.size() && !changedDetialInfoList.isEmpty()) {
            ProfileUpdateMsg$UpdateMsg profileUpdateMsg$UpdateMsg = new ProfileUpdateMsg$UpdateMsg();
            ArrayList arrayList = new ArrayList();
            int size = changedDetialInfoList.size();
            for (int i3 = 0; i3 < size; i3++) {
                kx3.a aVar = changedDetialInfoList.get(i3);
                Intrinsics.checkNotNullExpressionValue(aVar, "changedDetialInfoList[index]");
                kx3.a aVar2 = aVar;
                kx3.a aVar3 = originDetailInfoList.get(i3);
                Intrinsics.checkNotNullExpressionValue(aVar3, "originDetailInfoList[index]");
                kx3.a aVar4 = aVar3;
                if (!TextUtils.isEmpty(aVar2.getUid()) && !TextUtils.isEmpty(aVar2.getUin()) && c.f360229a.o(aVar2.getUin()) && Intrinsics.areEqual(aVar2.getUid(), aVar4.getUid())) {
                    ProfileUpdateMsg$UpdateData profileUpdateMsg$UpdateData = new ProfileUpdateMsg$UpdateData();
                    profileUpdateMsg$UpdateData.uid.set(aVar2.getUid());
                    profileUpdateMsg$UpdateData.uin.set(Long.parseLong(aVar2.getUin()));
                    ProfileUpdateMsg$updateVas profileUpdateMsg$updateVas = new ProfileUpdateMsg$updateVas();
                    if (aVar2.getNameplateVipType() != aVar4.getNameplateVipType()) {
                        profileUpdateMsg$updateVas.nameplateVipType.set(aVar2.getNameplateVipType());
                    }
                    if (aVar2.getGrayNameplateFlag() != aVar4.getGrayNameplateFlag()) {
                        profileUpdateMsg$updateVas.grayNameplateFlag.set(aVar4.getGrayNameplateFlag());
                    }
                    n(aVar4, aVar2, profileUpdateMsg$updateVas);
                    if (aVar2.getNamePlateOfKingGameId() != aVar4.getNamePlateOfKingGameId()) {
                        profileUpdateMsg$updateVas.gameNameplateId.set(aVar2.getNamePlateOfKingGameId());
                    }
                    if (aVar2.getNamePlateOfKingLoginTime() != aVar4.getNamePlateOfKingLoginTime()) {
                        profileUpdateMsg$updateVas.gameLastLoginTime.set(aVar4.getNamePlateOfKingLoginTime());
                    }
                    if (aVar2.getNamePlateOfKingDan() != aVar4.getNamePlateOfKingDan()) {
                        profileUpdateMsg$updateVas.gameRank.set(aVar2.getNamePlateOfKingDan());
                    }
                    if (aVar2.getNamePlateOfKingDanDisplatSwitch() != aVar4.getNamePlateOfKingDanDisplatSwitch()) {
                        profileUpdateMsg$updateVas.gameIconShowFlag.set(aVar2.getNamePlateOfKingDanDisplatSwitch());
                    }
                    if (aVar2.getGameCardId() != aVar4.getGameCardId()) {
                        profileUpdateMsg$updateVas.gameCardId.set(aVar2.getGameCardId());
                    }
                    if (aVar2.getSuperVipTemplateId() != aVar4.getSuperVipTemplateId()) {
                        profileUpdateMsg$updateVas.superVipTemplateId.set(aVar2.getSuperVipTemplateId());
                    }
                    if (aVar2.getBigClubExtTemplateId() != aVar4.getBigClubTemplateId()) {
                        profileUpdateMsg$updateVas.extendNameplateId.set(aVar2.getBigClubExtTemplateId());
                    }
                    if (aVar2.getDiyFontId() != aVar4.getDiyFontId()) {
                        profileUpdateMsg$updateVas.diyFontId.set(aVar2.getDiyFontId());
                    }
                    if (aVar2.getVipStartFlag() != aVar4.getVipStartFlag()) {
                        profileUpdateMsg$updateVas.vipStartFlag.set(aVar4.getVipStartFlag());
                    }
                    if (!a.f360228a.a(aVar2.getVipIcons(), aVar4.getVipIcons())) {
                        profileUpdateMsg$updateVas.diyNameplateIDs.set(i(aVar2.getVipIcons()));
                    }
                    if (aVar2.getVipDataFlag() != aVar4.getVipDataFlag()) {
                        profileUpdateMsg$updateVas.vipDataFlag.set(aVar2.getVipDataFlag());
                    }
                    if (aVar2.getCNewLoverDiamondFlag() != aVar4.getCNewLoverDiamondFlag()) {
                        profileUpdateMsg$updateVas.newLoverDiamondFlag.set(aVar2.getCNewLoverDiamondFlag());
                    }
                    if (aVar2.getPendantId() != aVar4.getPendantId()) {
                        profileUpdateMsg$updateVas.pendantId.set((int) aVar2.getPendantId());
                    }
                    if (aVar2.getPendantDiyId() != aVar4.getPendantDiyId()) {
                        profileUpdateMsg$updateVas.pendantDiyId.set(aVar2.getPendantDiyId());
                    }
                    if (aVar2.getFaceId() != aVar4.getFaceId()) {
                        profileUpdateMsg$updateVas.faceId.set(aVar2.getFaceId());
                    }
                    if (aVar2.getUVipFont() != aVar4.getUVipFont()) {
                        profileUpdateMsg$updateVas.vipFont.set((int) aVar2.getUVipFont());
                    }
                    if (aVar2.getVipFontType() != aVar4.getVipFontType()) {
                        profileUpdateMsg$updateVas.vipFontType.set(aVar2.getVipFontType());
                    }
                    if (aVar2.getMagicFont() != aVar4.getMagicFont()) {
                        profileUpdateMsg$updateVas.magicFont.set(aVar2.getMagicFont());
                    }
                    if (aVar2.getFontEffect() != aVar4.getFontEffect()) {
                        profileUpdateMsg$updateVas.fontEffect.set(aVar2.getFontEffect());
                    }
                    profileUpdateMsg$UpdateData.vasInfo.set(profileUpdateMsg$updateVas);
                    arrayList.add(profileUpdateMsg$UpdateData);
                }
            }
            if (QLog.isColorLevel() && ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
                QLog.i("KernelDataConvertUtil", 1, "UPDATE_DATA_NTVasDetailInfo");
            }
            profileUpdateMsg$UpdateMsg.datas.set(arrayList);
            return profileUpdateMsg$UpdateMsg;
        }
        return null;
    }

    @Nullable
    public HashMap<String, StockLocalData> e(@NotNull ArrayList<kx3.a> originDetailInfoList, @NotNull ArrayList<kx3.a> changedDetialInfoList, @Nullable HashMap<String, StockLocalData> stockLocalDatas) {
        StockLocalData stockLocalData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (HashMap) iPatchRedirector.redirect((short) 8, this, originDetailInfoList, changedDetialInfoList, stockLocalDatas);
        }
        Intrinsics.checkNotNullParameter(originDetailInfoList, "originDetailInfoList");
        Intrinsics.checkNotNullParameter(changedDetialInfoList, "changedDetialInfoList");
        HashMap<String, StockLocalData> hashMap = new HashMap<>();
        if (originDetailInfoList.size() == changedDetialInfoList.size() && !changedDetialInfoList.isEmpty()) {
            int size = changedDetialInfoList.size();
            for (int i3 = 0; i3 < size; i3++) {
                kx3.a aVar = changedDetialInfoList.get(i3);
                Intrinsics.checkNotNullExpressionValue(aVar, "changedDetialInfoList[index]");
                kx3.a aVar2 = aVar;
                kx3.a aVar3 = originDetailInfoList.get(i3);
                Intrinsics.checkNotNullExpressionValue(aVar3, "originDetailInfoList[index]");
                kx3.a aVar4 = aVar3;
                if (stockLocalDatas == null || (stockLocalData = stockLocalDatas.get(aVar2.getUid())) == null) {
                    stockLocalData = new StockLocalData();
                }
                a aVar5 = a.f360228a;
                if (!aVar5.a(aVar2.getMedalsInfo(), aVar4.getMedalsInfo())) {
                    stockLocalData.medalsInfo = aVar2.getMedalsInfo();
                }
                if (!aVar5.a(aVar2.getNameplateCfgInfo(), aVar4.getNameplateCfgInfo())) {
                    stockLocalData.nameplateCfgInfo = aVar2.getNameplateCfgInfo();
                }
                if (!aVar5.a(aVar2.f(), aVar4.f())) {
                    stockLocalData.diyFontConfigMap = new HashMap<>();
                    ConcurrentHashMap<Integer, String> f16 = aVar2.f();
                    if (f16 != null) {
                        for (Map.Entry<Integer, String> entry : f16.entrySet()) {
                            HashMap<Integer, String> hashMap2 = stockLocalData.diyFontConfigMap;
                            if (hashMap2 != null) {
                                hashMap2.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                }
                if (aVar2.getFaceIdUpdateTime() != aVar4.getFaceIdUpdateTime()) {
                    stockLocalData.faceIdUpdateTime = Long.valueOf(aVar2.getFaceIdUpdateTime());
                }
                if (aVar2.getTimestamp() != aVar4.getTimestamp()) {
                    stockLocalData.timestamp = Long.valueOf(aVar2.getTimestamp());
                }
                a aVar6 = a.f360228a;
                if (!aVar6.b(aVar2.getDiyFontTimestampBytes(), aVar4.getDiyFontTimestampBytes())) {
                    stockLocalData.diyFontTimestampBytes = aVar2.getDiyFontTimestampBytes();
                }
                if (aVar2.getFontEffectLastUpdateTime() != aVar4.getFontEffectLastUpdateTime()) {
                    stockLocalData.fontEffectLastUpdateTime = Long.valueOf(aVar2.getFontEffectLastUpdateTime());
                }
                if (!aVar6.a(aVar2.i(), aVar4.i())) {
                    stockLocalData.diyFontTimestampMap = new HashMap<>();
                    ConcurrentHashMap<Integer, Integer> i16 = aVar2.i();
                    if (i16 != null) {
                        for (Map.Entry<Integer, Integer> entry2 : i16.entrySet()) {
                            HashMap<Integer, Long> hashMap3 = stockLocalData.diyFontTimestampMap;
                            if (hashMap3 != null) {
                                hashMap3.put(entry2.getKey(), Long.valueOf(entry2.getValue().intValue()));
                            }
                        }
                    }
                }
                if (aVar2.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String() != aVar4.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String()) {
                    stockLocalData.lastUpdateTime = Long.valueOf(aVar2.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String());
                }
                hashMap.put(aVar2.getUid(), stockLocalData);
            }
            return hashMap;
        }
        return null;
    }

    @Nullable
    public HashMap<String, StockLocalData> f(@NotNull ArrayList<NTVasSimpleInfo> changedInfoList, @Nullable HashMap<String, StockLocalData> stockLocalDatas) {
        StockLocalData stockLocalData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (HashMap) iPatchRedirector.redirect((short) 7, (Object) this, (Object) changedInfoList, (Object) stockLocalDatas);
        }
        Intrinsics.checkNotNullParameter(changedInfoList, "changedInfoList");
        HashMap<String, StockLocalData> hashMap = new HashMap<>();
        if (changedInfoList.isEmpty()) {
            return null;
        }
        int size = changedInfoList.size();
        for (int i3 = 0; i3 < size; i3++) {
            NTVasSimpleInfo nTVasSimpleInfo = changedInfoList.get(i3);
            Intrinsics.checkNotNullExpressionValue(nTVasSimpleInfo, "changedInfoList[index]");
            NTVasSimpleInfo nTVasSimpleInfo2 = nTVasSimpleInfo;
            if (stockLocalDatas == null || (stockLocalData = stockLocalDatas.get(nTVasSimpleInfo2.getUid())) == null) {
                stockLocalData = new StockLocalData();
            }
            String str = nTVasSimpleInfo2.medalsInfo;
            if (str != null) {
                stockLocalData.medalsInfo = str;
            }
            if (str != null) {
                stockLocalData.medalsInfo = str;
            }
            String str2 = nTVasSimpleInfo2.nameplateCfgInfo;
            if (str2 != null) {
                stockLocalData.nameplateCfgInfo = str2;
            }
            if (nTVasSimpleInfo2.diyFontConfigMap != null) {
                stockLocalData.diyFontConfigMap = new HashMap<>();
                ConcurrentHashMap<Integer, String> concurrentHashMap = nTVasSimpleInfo2.diyFontConfigMap;
                if (concurrentHashMap != null) {
                    for (Map.Entry<Integer, String> entry : concurrentHashMap.entrySet()) {
                        HashMap<Integer, String> hashMap2 = stockLocalData.diyFontConfigMap;
                        if (hashMap2 != null) {
                            hashMap2.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
            }
            long j3 = nTVasSimpleInfo2.faceIdUpdateTime;
            if (j3 != Long.MIN_VALUE) {
                stockLocalData.faceIdUpdateTime = Long.valueOf(j3);
            }
            long j16 = nTVasSimpleInfo2.timestamp;
            if (j16 != Long.MIN_VALUE) {
                stockLocalData.timestamp = Long.valueOf(j16);
            }
            byte[] bArr = nTVasSimpleInfo2.diyFontTimestampBytes;
            if (bArr != null) {
                stockLocalData.diyFontTimestampBytes = bArr;
            }
            long j17 = nTVasSimpleInfo2.fontEffectLastUpdateTime;
            if (j17 != Long.MIN_VALUE) {
                stockLocalData.fontEffectLastUpdateTime = Long.valueOf(j17);
            }
            if (nTVasSimpleInfo2.diyFontTimestampMap != null) {
                stockLocalData.diyFontTimestampMap = new HashMap<>();
                ConcurrentHashMap<Integer, Integer> concurrentHashMap2 = nTVasSimpleInfo2.diyFontTimestampMap;
                if (concurrentHashMap2 != null) {
                    for (Map.Entry<Integer, Integer> entry2 : concurrentHashMap2.entrySet()) {
                        HashMap<Integer, Long> hashMap3 = stockLocalData.diyFontTimestampMap;
                        if (hashMap3 != null) {
                            hashMap3.put(entry2.getKey(), Long.valueOf(entry2.getValue().intValue()));
                        }
                    }
                }
            }
            long j18 = nTVasSimpleInfo2.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String;
            if (j18 != Long.MIN_VALUE) {
                stockLocalData.lastUpdateTime = Long.valueOf(j18);
            }
            hashMap.put(nTVasSimpleInfo2.getUid(), stockLocalData);
        }
        return hashMap;
    }

    @Nullable
    public ProfileUpdateMsg$UpdateMsg g(@NotNull String trace, @NotNull ArrayList<kx3.a> ntVasDetailInfoList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ProfileUpdateMsg$UpdateMsg) iPatchRedirector.redirect((short) 9, (Object) this, (Object) trace, (Object) ntVasDetailInfoList);
        }
        Intrinsics.checkNotNullParameter(trace, "trace");
        Intrinsics.checkNotNullParameter(ntVasDetailInfoList, "ntVasDetailInfoList");
        if (ntVasDetailInfoList.isEmpty()) {
            return null;
        }
        ProfileUpdateMsg$UpdateMsg profileUpdateMsg$UpdateMsg = new ProfileUpdateMsg$UpdateMsg();
        ArrayList arrayList = new ArrayList();
        Iterator<kx3.a> it = ntVasDetailInfoList.iterator();
        while (it.hasNext()) {
            kx3.a next = it.next();
            if (!TextUtils.isEmpty(next.getUid()) && !TextUtils.isEmpty(next.getUin()) && c.f360229a.o(next.getUin())) {
                ProfileUpdateMsg$UpdateData profileUpdateMsg$UpdateData = new ProfileUpdateMsg$UpdateData();
                profileUpdateMsg$UpdateData.uid.set(next.getUid());
                profileUpdateMsg$UpdateData.uin.set(Long.parseLong(next.getUin()));
                ProfileUpdateMsg$updateVas profileUpdateMsg$updateVas = new ProfileUpdateMsg$updateVas();
                profileUpdateMsg$updateVas.nameplateVipType.set(next.getNameplateVipType());
                profileUpdateMsg$updateVas.grayNameplateFlag.set(next.getGrayNameplateFlag());
                m(next, profileUpdateMsg$updateVas);
                profileUpdateMsg$updateVas.gameNameplateId.set(next.getNamePlateOfKingGameId());
                profileUpdateMsg$updateVas.gameLastLoginTime.set(next.getNamePlateOfKingLoginTime());
                profileUpdateMsg$updateVas.gameRank.set(next.getNamePlateOfKingDan());
                profileUpdateMsg$updateVas.gameIconShowFlag.set(next.getNamePlateOfKingDanDisplatSwitch());
                profileUpdateMsg$updateVas.gameCardId.set(next.getGameCardId());
                profileUpdateMsg$updateVas.gameCardId.set(next.getGameCardId());
                profileUpdateMsg$updateVas.superVipTemplateId.set(next.getSuperVipTemplateId());
                profileUpdateMsg$updateVas.extendNameplateId.set(next.getBigClubExtTemplateId());
                profileUpdateMsg$updateVas.diyFontId.set(next.getDiyFontId());
                profileUpdateMsg$updateVas.vipStartFlag.set(next.getVipStartFlag());
                profileUpdateMsg$updateVas.diyNameplateIDs.set(i(next.getVipIcons()));
                profileUpdateMsg$updateVas.vipDataFlag.set(next.getVipDataFlag());
                profileUpdateMsg$updateVas.newLoverDiamondFlag.set(next.getCNewLoverDiamondFlag());
                profileUpdateMsg$updateVas.pendantId.set((int) next.getPendantId());
                profileUpdateMsg$updateVas.pendantDiyId.set(next.getPendantDiyId());
                profileUpdateMsg$updateVas.faceId.set(next.getFaceId());
                profileUpdateMsg$updateVas.vipFont.set((int) next.getUVipFont());
                profileUpdateMsg$updateVas.vipFontType.set(next.getVipFontType());
                profileUpdateMsg$updateVas.magicFont.set(next.getMagicFont());
                profileUpdateMsg$updateVas.fontEffect.set(next.getFontEffect());
                profileUpdateMsg$UpdateData.vasInfo.set(profileUpdateMsg$updateVas);
                arrayList.add(profileUpdateMsg$UpdateData);
                if (QLog.isColorLevel() && ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
                    QLog.i("VasDataConvertUtil", 1, "trace " + trace + " NTVasDetailInfoToKernelData " + next);
                }
            }
        }
        if (QLog.isColorLevel() && ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
            QLog.i("KernelDataConvertUtil", 1, "UPDATE_DATA_NTVasDetailInfo");
        }
        profileUpdateMsg$UpdateMsg.datas.set(arrayList);
        return profileUpdateMsg$UpdateMsg;
    }

    @NotNull
    public HashMap<String, StockLocalData> h(@NotNull ArrayList<kx3.a> ntVasDetailInfoList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HashMap) iPatchRedirector.redirect((short) 6, (Object) this, (Object) ntVasDetailInfoList);
        }
        Intrinsics.checkNotNullParameter(ntVasDetailInfoList, "ntVasDetailInfoList");
        HashMap<String, StockLocalData> hashMap = new HashMap<>();
        if (ntVasDetailInfoList.isEmpty()) {
            return hashMap;
        }
        Iterator<kx3.a> it = ntVasDetailInfoList.iterator();
        while (it.hasNext()) {
            kx3.a next = it.next();
            if (next != null) {
                StockLocalData stockLocalData = new StockLocalData();
                stockLocalData.medalsInfo = next.getMedalsInfo();
                stockLocalData.nameplateCfgInfo = next.getNameplateCfgInfo();
                stockLocalData.diyFontConfigMap = new HashMap<>();
                ConcurrentHashMap<Integer, String> f16 = next.f();
                if (f16 != null) {
                    for (Map.Entry<Integer, String> entry : f16.entrySet()) {
                        HashMap<Integer, String> hashMap2 = stockLocalData.diyFontConfigMap;
                        if (hashMap2 != null) {
                            hashMap2.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                stockLocalData.faceIdUpdateTime = Long.valueOf(next.getFaceIdUpdateTime());
                stockLocalData.timestamp = Long.valueOf(next.getTimestamp());
                stockLocalData.diyFontTimestampBytes = next.getDiyFontTimestampBytes();
                stockLocalData.fontEffectLastUpdateTime = Long.valueOf(next.getFontEffectLastUpdateTime());
                stockLocalData.diyFontTimestampMap = new HashMap<>();
                ConcurrentHashMap<Integer, Integer> i3 = next.i();
                if (i3 != null) {
                    for (Map.Entry<Integer, Integer> entry2 : i3.entrySet()) {
                        HashMap<Integer, Long> hashMap3 = stockLocalData.diyFontTimestampMap;
                        if (hashMap3 != null) {
                            hashMap3.put(entry2.getKey(), Long.valueOf(entry2.getValue().intValue()));
                        }
                    }
                }
                stockLocalData.lastUpdateTime = Long.valueOf(next.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String());
                hashMap.put(next.getUid(), stockLocalData);
            }
        }
        return hashMap;
    }

    @NotNull
    public final List<Integer> i(@Nullable String str) {
        List listOf;
        List emptyList;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        if (str == null || TextUtils.isEmpty(str)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(-34643985);
            return new ArrayList(listOf);
        }
        List<String> split = new Regex(",").split(str, 0);
        boolean z17 = true;
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Object[] array = emptyList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        ArrayList arrayList = new ArrayList();
        if (strArr.length != 0) {
            z17 = false;
        }
        if (z17) {
            return arrayList;
        }
        for (String str2 : strArr) {
            arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
        }
        if (arrayList.isEmpty()) {
            arrayList.add(-34643985);
        }
        return arrayList;
    }

    @Nullable
    public final String j(@Nullable List<Integer> ids) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, (Object) ids);
        }
        if (ids == null || ids.size() == 0) {
            return "";
        }
        if (ids.get(0).intValue() == -34643985) {
            if (QLog.isColorLevel() && ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
                QLog.i("VasDataConvertUtil", 1, "\u62c9\u53d6\u5230\u975e\u6cd5\u503c " + ids.get(0));
            }
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(String.valueOf(ids.get(0).intValue()));
        int size = ids.size();
        for (int i3 = 1; i3 < size; i3++) {
            sb5.append(",");
            sb5.append(ids.get(i3).intValue());
        }
        return sb5.toString();
    }

    public final void o(@NotNull String trace, @Nullable VasInfo vasInfo, @NotNull NTVasSimpleInfo result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, trace, vasInfo, result);
            return;
        }
        Intrinsics.checkNotNullParameter(trace, "trace");
        Intrinsics.checkNotNullParameter(result, "result");
        if (vasInfo != null) {
            result.nameplateVipType = vasInfo.nameplateVipType;
            result.grayNameplateFlag = vasInfo.grayNameplateFlag;
            m mVar = f360286a;
            result.qqVipInfo = mVar.p(vasInfo, 1, result.qqVipInfo);
            result.superVipInfo = mVar.p(vasInfo, 2, result.superVipInfo);
            result.bigClubInfo = mVar.p(vasInfo, 3, result.bigClubInfo);
            result.namePlateOfKingGameId = vasInfo.gameNameplateId;
            result.namePlateOfKingLoginTime = vasInfo.gameLastLoginTime;
            result.namePlateOfKingDan = vasInfo.gameRank;
            result.namePlateOfKingDanDisplatSwitch = Boolean.valueOf(vasInfo.gameIconShowFlag);
            result.gameCardId = (int) vasInfo.gameCardId;
            int i3 = vasInfo.superVipTemplateId;
            result.superVipTemplateId = i3;
            result.bigClubTemplateId = i3;
            result.bigClubExtTemplateId = vasInfo.extendNameplateId;
            result.diyFontId = vasInfo.diyFontId;
            result.vipStartFlag = vasInfo.vipStartFlag;
            String j3 = mVar.j(vasInfo.diyNameplateIDs);
            if (j3 == null) {
                j3 = "";
            }
            result.vipIcons = j3;
            result.vipDataFlag = vasInfo.vipDataFlag;
            result.cNewLoverDiamondFlag = vasInfo.newLoverDiamondFlag;
            result.pendantId = vasInfo.pendantId;
            result.pendantDiyId = vasInfo.pendantDiyId;
            result.faceId = vasInfo.faceId;
            result.uVipFont = vasInfo.vipFont;
            result.vipFontType = vasInfo.vipFontType;
            result.magicFont = vasInfo.magicFont;
            result.fontEffect = vasInfo.fontEffect;
        }
        if (QLog.isColorLevel() && ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
            QLog.e("VasDataConvertUtil", 1, "trace " + trace + " userVasInfoUpdateNTVasSimpleInfo " + result);
        }
    }
}
