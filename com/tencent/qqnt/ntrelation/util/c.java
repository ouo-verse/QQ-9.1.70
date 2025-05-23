package com.tencent.qqnt.ntrelation.util;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vaswebviewplugin.LocalDataJsPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.contacts.cache.FriendListInfoCache;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.BaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.CoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.OtherFlag;
import com.tencent.qqnt.kernel.nativeinterface.RelationFlag;
import com.tencent.qqnt.kernel.nativeinterface.StatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.StockLocalData;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserSimpleInfo;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$Action;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$Buddy;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$UpdateData;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$UpdateMsg;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$updateBaseInfo;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$updateCoreInfo;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$updateOtherFlags;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$updateRelationFlags;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J.\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\rH\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0016j\b\u0012\u0004\u0012\u00020\u0014`\u0017H\u0016J<\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u001bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b`\u001c2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0016j\b\u0012\u0004\u0012\u00020\u0014`\u0017H\u0016J*\u0010\u001f\u001a\u00020\u00102\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0016j\b\u0012\u0004\u0012\u00020\u0014`\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010%\u001a\u00020$2\u0006\u0010\b\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\"J,\u0010'\u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010&\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020$J\"\u0010)\u001a\u00020(2\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ<\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u001bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b`\u001c2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020(0\u0016j\b\u0012\u0004\u0012\u00020(`\u0017H\u0016J\"\u0010,\u001a\u0004\u0018\u00010\u00192\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020(0\u0016j\b\u0012\u0004\u0012\u00020(`\u0017H\u0016J\u000e\u0010-\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u0018\u0010/\u001a\u00020.2\u0006\u0010\b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\"\u00101\u001a\u0002002\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u00104\u001a\u0002032\u0006\u00102\u001a\u00020\"J\u000e\u00107\u001a\u0002062\u0006\u00105\u001a\u00020\u0006R\u0014\u00109\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001f\u00108R\"\u0010;\u001a\u0002068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0017\u0010?\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b,\u0010:\u001a\u0004\b?\u0010<R\u0014\u0010@\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010:\u00a8\u0006C"}, d2 = {"Lcom/tencent/qqnt/ntrelation/util/c;", "", "", "value", "", DomainData.DOMAIN_NAME, "", "trace", "uid", "Lcom/tencent/qqnt/kernel/nativeinterface/UserSimpleInfo;", "userSimpleInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/StockLocalData;", LocalDataJsPlugin.NAME_SPACE, "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "f", "result", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/kernel/nativeinterface/UserDetailInfo;", "userDetailInfo", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/c;", "e", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ntFriendDetailInfoList", "Lcom/tencent/qqnt/ntrelation/protocol/ProfileUpdateMsg$UpdateMsg;", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "detailInfoArrayList", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/OtherFlag;", "otherFlag", "Lcom/tencent/qqnt/kernel/nativeinterface/RelationFlag;", "relationFlag", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/c;", tl.h.F, "stockLocalData", "p", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", "g", "ntOtherDetailInfoList", "k", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/c;", "j", "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/a;", "i", "flag", "", "l", "str", "", "o", "Ljava/lang/String;", "TAG_RING_ID_UPDATE", "Z", "isLogOpen", "()Z", "setLogOpen", "(Z)V", "isNotifyRingIdOptSwitch", "logRingIdUpdate", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f360229a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG_RING_ID_UPDATE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isLogOpen;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final boolean isNotifyRingIdOptSwitch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final boolean logRingIdUpdate;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37571);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
            return;
        }
        f360229a = new c();
        TAG_RING_ID_UPDATE = "RingIdUpdate";
        isLogOpen = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen();
        isNotifyRingIdOptSwitch = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103122", true);
        logRingIdUpdate = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("log_ring_id_update_130495623", true);
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final byte[] n(int value) {
        return new byte[]{(byte) (value & 255), (byte) ((value >> 8) & 255), (byte) ((value >> 16) & 255), (byte) ((value >> 24) & 255)};
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x020c A[SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ProfileUpdateMsg$UpdateMsg a(@NotNull String trace, @NotNull ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> ntFriendDetailInfoList) {
        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> it;
        Boolean C;
        Boolean G;
        Boolean F;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ProfileUpdateMsg$UpdateMsg) iPatchRedirector.redirect((short) 9, (Object) this, (Object) trace, (Object) ntFriendDetailInfoList);
        }
        Intrinsics.checkNotNullParameter(trace, "trace");
        Intrinsics.checkNotNullParameter(ntFriendDetailInfoList, "ntFriendDetailInfoList");
        if (ntFriendDetailInfoList.isEmpty()) {
            return null;
        }
        ProfileUpdateMsg$UpdateMsg profileUpdateMsg$UpdateMsg = new ProfileUpdateMsg$UpdateMsg();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> it5 = ntFriendDetailInfoList.iterator();
        while (it5.hasNext()) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.c next = it5.next();
            if (next != null && !TextUtils.isEmpty(next.getUid()) && !TextUtils.isEmpty(next.x())) {
                ProfileUpdateMsg$UpdateData profileUpdateMsg$UpdateData = new ProfileUpdateMsg$UpdateData();
                profileUpdateMsg$UpdateData.uid.set(next.getUid());
                profileUpdateMsg$UpdateData.uin.set(Long.parseLong(next.x()));
                ProfileUpdateMsg$updateCoreInfo profileUpdateMsg$updateCoreInfo = new ProfileUpdateMsg$updateCoreInfo();
                String p16 = next.p();
                if (p16 != null) {
                    profileUpdateMsg$updateCoreInfo.nick.set(p16);
                }
                String r16 = next.r();
                if (r16 != null && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(next.getUid(), trace)) {
                    profileUpdateMsg$updateCoreInfo.remark.set(r16);
                }
                ProfileUpdateMsg$updateBaseInfo profileUpdateMsg$updateBaseInfo = new ProfileUpdateMsg$updateBaseInfo();
                if (next.f() != Integer.MIN_VALUE) {
                    ProfileUpdateMsg$Buddy profileUpdateMsg$Buddy = new ProfileUpdateMsg$Buddy();
                    profileUpdateMsg$Buddy.uid.set(next.getUid());
                    ProfileUpdateMsg$Action profileUpdateMsg$Action = new ProfileUpdateMsg$Action();
                    if (next.f() == -1) {
                        profileUpdateMsg$updateBaseInfo.categoryId.set(0);
                        profileUpdateMsg$Action.del_buddy.set(profileUpdateMsg$Buddy);
                        arrayList2.add(profileUpdateMsg$Action);
                    } else {
                        profileUpdateMsg$updateBaseInfo.categoryId.set(next.f());
                        profileUpdateMsg$Action.add_buddy.set(profileUpdateMsg$Buddy);
                        arrayList2.add(profileUpdateMsg$Action);
                    }
                }
                if (next.b() != Integer.MIN_VALUE) {
                    profileUpdateMsg$updateBaseInfo.age.set(next.b());
                }
                if (next.v() != Integer.MIN_VALUE) {
                    profileUpdateMsg$updateBaseInfo.gender.set(next.v());
                }
                ProfileUpdateMsg$updateRelationFlags profileUpdateMsg$updateRelationFlags = new ProfileUpdateMsg$updateRelationFlags();
                Boolean z16 = next.z();
                if (z16 != null) {
                    profileUpdateMsg$updateRelationFlags.isBlock.set(z16.booleanValue());
                }
                Boolean A = next.A();
                if (A != null) {
                    profileUpdateMsg$updateRelationFlags.isBlocked.set(A.booleanValue());
                }
                if (next.t() != Long.MIN_VALUE) {
                    profileUpdateMsg$updateBaseInfo.richTime.set((int) next.t());
                }
                byte[] s16 = next.s();
                if (s16 != null) {
                    profileUpdateMsg$updateBaseInfo.richBuffer.set(ByteStringMicro.copyFrom(s16));
                }
                String u16 = next.u();
                if (u16 != null) {
                    profileUpdateMsg$updateRelationFlags.ringId.set(u16);
                    if (logRingIdUpdate) {
                        String str = TAG_RING_ID_UPDATE;
                        PBStringField pBStringField = profileUpdateMsg$UpdateData.uid;
                        PBUInt64Field pBUInt64Field = profileUpdateMsg$UpdateData.uin;
                        StringBuilder sb5 = new StringBuilder();
                        it = it5;
                        sb5.append("[accurateConvertNTFriendDetailInfoToKernelData] trace=");
                        sb5.append(trace);
                        sb5.append(" uid=");
                        sb5.append(pBStringField);
                        sb5.append(" uin=");
                        sb5.append(pBUInt64Field);
                        sb5.append(" ringId=");
                        sb5.append(u16);
                        QLog.i(str, 1, sb5.toString());
                        C = next.C();
                        if (C != null) {
                            profileUpdateMsg$updateRelationFlags.isMsgDisturb.set(C.booleanValue());
                        }
                        G = next.G();
                        if (G != null) {
                            profileUpdateMsg$updateRelationFlags.isSpecialCareZone.set(G.booleanValue());
                        }
                        F = next.F();
                        if (F != null) {
                            profileUpdateMsg$updateRelationFlags.isSpecialCareOpen.set(F.booleanValue());
                        }
                        profileUpdateMsg$UpdateData.coreInfo.set(profileUpdateMsg$updateCoreInfo);
                        profileUpdateMsg$UpdateData.baseInfo.set(profileUpdateMsg$updateBaseInfo);
                        profileUpdateMsg$UpdateData.relationFalgs.set(profileUpdateMsg$updateRelationFlags);
                        arrayList.add(profileUpdateMsg$UpdateData);
                        if (!isLogOpen) {
                            QLog.i("KernelDataConvertUtil", 1, "trace " + trace + " NTFriendDetailInfoToKernelData " + next);
                        }
                    }
                }
                it = it5;
                C = next.C();
                if (C != null) {
                }
                G = next.G();
                if (G != null) {
                }
                F = next.F();
                if (F != null) {
                }
                profileUpdateMsg$UpdateData.coreInfo.set(profileUpdateMsg$updateCoreInfo);
                profileUpdateMsg$UpdateData.baseInfo.set(profileUpdateMsg$updateBaseInfo);
                profileUpdateMsg$UpdateData.relationFalgs.set(profileUpdateMsg$updateRelationFlags);
                arrayList.add(profileUpdateMsg$UpdateData);
                if (!isLogOpen) {
                }
            } else {
                it = it5;
            }
            it5 = it;
        }
        if (!arrayList2.isEmpty()) {
            profileUpdateMsg$UpdateMsg.action.set(arrayList2);
        }
        profileUpdateMsg$UpdateMsg.datas.set(arrayList);
        return profileUpdateMsg$UpdateMsg;
    }

    public void b(@NotNull ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> detailInfoArrayList, @Nullable String trace) {
        Object k3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) detailInfoArrayList, (Object) trace);
            return;
        }
        Intrinsics.checkNotNullParameter(detailInfoArrayList, "detailInfoArrayList");
        if (detailInfoArrayList.isEmpty()) {
            return;
        }
        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> it = detailInfoArrayList.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.c next = it.next();
            if (next != null && (k3 = FriendListInfoCache.INSTANCE.a().k(com.tencent.qqnt.contacts.cache.a.f355804a.a(), next.getUid(), trace)) != null) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) k3;
                Byte n3 = next.n();
                if (n3 != null) {
                    dVar.h0(Byte.valueOf(n3.byteValue()));
                }
                boolean z17 = true;
                if (next.j() != Integer.MIN_VALUE) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    dVar.e0(next.j());
                }
                String k16 = next.k();
                if (k16 != null) {
                    dVar.f0(k16);
                }
                if (next.o() == Integer.MIN_VALUE) {
                    z17 = false;
                }
                if (z17) {
                    dVar.j0(next.o());
                }
                Boolean y16 = next.y();
                if (y16 != null) {
                    dVar.N(Boolean.valueOf(y16.booleanValue()));
                }
            }
        }
    }

    @NotNull
    public HashMap<String, StockLocalData> c(@NotNull ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> ntFriendDetailInfoList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (HashMap) iPatchRedirector.redirect((short) 12, (Object) this, (Object) ntFriendDetailInfoList);
        }
        Intrinsics.checkNotNullParameter(ntFriendDetailInfoList, "ntFriendDetailInfoList");
        HashMap<String, StockLocalData> hashMap = new HashMap<>();
        if (ntFriendDetailInfoList.isEmpty()) {
            return hashMap;
        }
        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> it = ntFriendDetailInfoList.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.c next = it.next();
            if (next != null) {
                StockLocalData stockLocalData = new StockLocalData();
                if (next.l() != Long.MIN_VALUE) {
                    stockLocalData.datetime = Long.valueOf(next.l());
                }
                Byte n3 = next.n();
                if (n3 != null) {
                    stockLocalData.gathtertype = Integer.valueOf(n3.byteValue());
                }
                if (next.j() != Integer.MIN_VALUE) {
                    stockLocalData.comparePartInt = Integer.valueOf(next.j());
                }
                String k3 = next.k();
                if (k3 != null) {
                    stockLocalData.compareSpell = k3;
                }
                if (next.o() != Integer.MIN_VALUE) {
                    stockLocalData.multiFlags = Long.valueOf(next.o());
                }
                Boolean y16 = next.y();
                if (y16 != null) {
                    stockLocalData.isAddedC2C = Boolean.valueOf(y16.booleanValue());
                }
                hashMap.put(next.getUid(), stockLocalData);
            }
        }
        return hashMap;
    }

    @Nullable
    public ProfileUpdateMsg$UpdateMsg d(@NotNull ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.a> ntOtherDetailInfoList) {
        int i3;
        int i16;
        int i17;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ProfileUpdateMsg$UpdateMsg) iPatchRedirector.redirect((short) 18, (Object) this, (Object) ntOtherDetailInfoList);
        }
        Intrinsics.checkNotNullParameter(ntOtherDetailInfoList, "ntOtherDetailInfoList");
        if (ntOtherDetailInfoList.isEmpty()) {
            return null;
        }
        ProfileUpdateMsg$UpdateMsg profileUpdateMsg$UpdateMsg = new ProfileUpdateMsg$UpdateMsg();
        ArrayList arrayList = new ArrayList();
        Iterator<com.tencent.qqnt.ntrelation.otherinfo.bean.a> it = ntOtherDetailInfoList.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.otherinfo.bean.a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.getUid()) && !TextUtils.isEmpty(next.j())) {
                ProfileUpdateMsg$UpdateData profileUpdateMsg$UpdateData = new ProfileUpdateMsg$UpdateData();
                profileUpdateMsg$UpdateData.uid.set(next.getUid());
                profileUpdateMsg$UpdateData.uin.set(Long.parseLong(next.j()));
                ProfileUpdateMsg$updateOtherFlags profileUpdateMsg$updateOtherFlags = new ProfileUpdateMsg$updateOtherFlags();
                Boolean k3 = next.k();
                if (k3 != null) {
                    profileUpdateMsg$updateOtherFlags.isAioShortcutBarOpen.set(k3.booleanValue());
                }
                if (next.l() != Integer.MIN_VALUE) {
                    PBBoolField pBBoolField = profileUpdateMsg$updateOtherFlags.isSharingLocation;
                    if (next.l() == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    pBBoolField.set(z17);
                }
                if (next.b() != Long.MIN_VALUE) {
                    profileUpdateMsg$updateOtherFlags.colorRindId.set((int) next.b());
                }
                ProfileUpdateMsg$updateRelationFlags profileUpdateMsg$updateRelationFlags = new ProfileUpdateMsg$updateRelationFlags();
                if (next.y() != Integer.MIN_VALUE) {
                    PBBoolField pBBoolField2 = profileUpdateMsg$updateRelationFlags.isHideSession;
                    if (next.y() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    pBBoolField2.set(z16);
                }
                if (next.G() != Integer.MIN_VALUE && next.G() == 1) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (next.N() != Integer.MIN_VALUE && next.N() == 1) {
                    i16 = 2;
                } else {
                    i16 = 0;
                }
                if (next.M() != Integer.MIN_VALUE && next.M() == 1) {
                    i17 = 4;
                } else {
                    i17 = 0;
                }
                byte[] n3 = n(i17 | i3 | i16);
                profileUpdateMsg$updateRelationFlags.notifyFlag.set(ByteStringMicro.copyFrom(new byte[]{n3[1], n3[0]}));
                if (next.c() != Long.MIN_VALUE) {
                    profileUpdateMsg$updateRelationFlags.c2cRingId.set(String.valueOf(next.c()));
                }
                QLog.d("KernelDataConvertUtil", 1, "[accurateConvertNTOtherDetailInfoToKernelData] notiRingId=" + next.e() + " messageRingId=" + next.c() + " c2cRingId=" + profileUpdateMsg$updateRelationFlags.c2cRingId.get());
                profileUpdateMsg$UpdateData.relationFalgs.set(profileUpdateMsg$updateRelationFlags);
                profileUpdateMsg$UpdateData.otherFlags.set(profileUpdateMsg$updateOtherFlags);
                arrayList.add(profileUpdateMsg$UpdateData);
            }
        }
        if (isLogOpen) {
            QLog.i("KernelDataConvertUtil", 1, "UPDATE_DATA_NTOtherDetailInfo");
        }
        profileUpdateMsg$UpdateMsg.datas.set(arrayList);
        return profileUpdateMsg$UpdateMsg;
    }

    @Nullable
    public com.tencent.qqnt.ntrelation.friendsinfo.bean.c e(@NotNull String trace, @Nullable UserDetailInfo userDetailInfo, @Nullable StockLocalData localData) {
        String str;
        Long l3;
        byte b16;
        int intValue;
        UserSimpleInfo userSimpleInfo;
        RelationFlag relationFlag;
        UserSimpleInfo userSimpleInfo2;
        StatusInfo statusInfo;
        UserSimpleInfo userSimpleInfo3;
        BaseInfo baseInfo;
        UserSimpleInfo userSimpleInfo4;
        CoreInfo coreInfo;
        UserSimpleInfo userSimpleInfo5;
        CoreInfo coreInfo2;
        UserSimpleInfo userSimpleInfo6;
        CoreInfo coreInfo3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.qqnt.ntrelation.friendsinfo.bean.c) iPatchRedirector.redirect((short) 7, this, trace, userDetailInfo, localData);
        }
        Intrinsics.checkNotNullParameter(trace, "trace");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.c cVar = null;
        if (userDetailInfo != null && (userSimpleInfo6 = userDetailInfo.simpleInfo) != null && (coreInfo3 = userSimpleInfo6.coreInfo) != null) {
            str = coreInfo3.uid;
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (userDetailInfo != null && (userSimpleInfo5 = userDetailInfo.simpleInfo) != null && (coreInfo2 = userSimpleInfo5.coreInfo) != null) {
                l3 = Long.valueOf(coreInfo2.uin);
            } else {
                l3 = null;
            }
            if (l3 != null) {
                cVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.c();
                if (userDetailInfo != null && (userSimpleInfo4 = userDetailInfo.simpleInfo) != null && (coreInfo = userSimpleInfo4.coreInfo) != null) {
                    String str2 = coreInfo.uid;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.uid");
                    cVar.v0(str2);
                    cVar.w0(String.valueOf(coreInfo.uin));
                    cVar.k0(coreInfo.nick);
                    cVar.m0(coreInfo.remark);
                }
                if (userDetailInfo != null && (userSimpleInfo3 = userDetailInfo.simpleInfo) != null && (baseInfo = userSimpleInfo3.baseInfo) != null) {
                    if (!userDetailInfo.isBuddy) {
                        cVar.d0(-1);
                    } else {
                        cVar.d0(baseInfo.categoryId);
                    }
                    cVar.V(baseInfo.age);
                    cVar.q0(baseInfo.sex);
                    cVar.o0(baseInfo.richTime);
                    cVar.n0(baseInfo.richBuffer);
                }
                if (userDetailInfo != null && (userSimpleInfo2 = userDetailInfo.simpleInfo) != null && (statusInfo = userSimpleInfo2.status) != null) {
                    cVar.u0(statusInfo.status);
                }
                if (userDetailInfo != null && (userSimpleInfo = userDetailInfo.simpleInfo) != null && (relationFlag = userSimpleInfo.relationFlags) != null) {
                    cVar.p0(relationFlag.ringId);
                    cVar.i0(Boolean.valueOf(relationFlag.isMsgDisturb));
                    cVar.c0(Byte.valueOf(f360229a.l(relationFlag)));
                }
                if (localData != null) {
                    cVar.g0(System.currentTimeMillis());
                    Integer num = localData.gathtertype;
                    int i3 = 0;
                    if (num != null) {
                        b16 = Byte.valueOf((byte) num.intValue());
                    } else {
                        b16 = (byte) 0;
                    }
                    cVar.h0(b16);
                    Integer num2 = localData.comparePartInt;
                    if (num2 == null) {
                        intValue = 0;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(num2, "it.comparePartInt ?: 0");
                        intValue = num2.intValue();
                    }
                    cVar.e0(intValue);
                    String str3 = localData.compareSpell;
                    if (str3 == null) {
                        str3 = "";
                    }
                    cVar.f0(str3);
                    Long l16 = localData.multiFlags;
                    if (l16 != null) {
                        i3 = (int) l16.longValue();
                    }
                    cVar.j0(i3);
                    Boolean bool = localData.isAddedC2C;
                    if (bool == null) {
                        bool = Boolean.FALSE;
                    }
                    cVar.N(bool);
                }
                if (QLog.isColorLevel() && isLogOpen) {
                    QLog.i("KernelDataConvertUtil", 1, "trace " + trace + " KernelDataToNTFriendDetailInfo " + cVar);
                }
            }
        }
        return cVar;
    }

    @Nullable
    public com.tencent.qqnt.ntrelation.friendsinfo.bean.d f(@NotNull String trace, @NotNull String uid, @Nullable UserSimpleInfo userSimpleInfo, @Nullable StockLocalData localData) {
        byte b16;
        int intValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) iPatchRedirector.redirect((short) 5, this, trace, uid, userSimpleInfo, localData);
        }
        Intrinsics.checkNotNullParameter(trace, "trace");
        Intrinsics.checkNotNullParameter(uid, "uid");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(null, null, 3, null);
        q(trace, uid, userSimpleInfo, dVar);
        if (localData != null) {
            dVar.g0(System.currentTimeMillis());
            Integer num = localData.gathtertype;
            if (num != null) {
                b16 = Byte.valueOf((byte) num.intValue());
            } else {
                b16 = (byte) 0;
            }
            dVar.h0(b16);
            Integer num2 = localData.comparePartInt;
            if (num2 == null) {
                intValue = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(num2, "it.comparePartInt ?: 0");
                intValue = num2.intValue();
            }
            dVar.e0(intValue);
            dVar.f0(localData.compareSpell);
            Long l3 = localData.multiFlags;
            if (l3 != null) {
                i3 = (int) l3.longValue();
            }
            dVar.j0(i3);
            Boolean bool = localData.isAddedC2C;
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            dVar.N(bool);
        }
        if (QLog.isColorLevel() && isLogOpen) {
            QLog.i("KernelDataConvertUtil", 1, "trace " + trace + " KernelDataToNTFriendSimpleInfo " + dVar);
        }
        return dVar;
    }

    @NotNull
    public final com.tencent.qqnt.ntrelation.otherinfo.bean.a g(@NotNull String uid, @Nullable UserDetailInfo userDetailInfo, @Nullable StockLocalData localData) {
        UserSimpleInfo userSimpleInfo;
        RelationFlag relationFlag;
        int i3;
        int i16;
        UserSimpleInfo userSimpleInfo2;
        OtherFlag otherFlag;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.qqnt.ntrelation.otherinfo.bean.a) iPatchRedirector.redirect((short) 16, this, uid, userDetailInfo, localData);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.a(null, null, 3, null);
        aVar.t(uid);
        aVar.u(m(uid));
        if (userDetailInfo != null && (userSimpleInfo2 = userDetailInfo.simpleInfo) != null && (otherFlag = userSimpleInfo2.otherFlags) != null) {
            aVar.n(Boolean.valueOf(otherFlag.isAioShortcutBarOpen));
            aVar.r(otherFlag.isSharingLocation ? 1 : 0);
            aVar.o(otherFlag.colorRindId);
        }
        if (userDetailInfo != null && (userSimpleInfo = userDetailInfo.simpleInfo) != null && (relationFlag = userSimpleInfo.relationFlags) != null) {
            aVar.j0(!relationFlag.isHideSession ? 1 : 0);
            byte[] bArr = relationFlag.notifyFlag;
            if (bArr.length >= 2) {
                int i17 = bArr[1];
                int i18 = 0;
                if ((i17 & 1) == 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if ((i17 & 2) == 0) {
                    i16 = 1;
                } else {
                    i16 = 0;
                }
                if ((i17 & 4) == 0) {
                    i18 = 1;
                }
                aVar.q0(i3 ^ 1);
                aVar.s0(i16 ^ 1);
                aVar.r0(i18 ^ 1);
            }
        }
        if (localData != null) {
            Integer chatInputType = localData.chatInputType;
            if (chatInputType != null) {
                Intrinsics.checkNotNullExpressionValue(chatInputType, "chatInputType");
                aVar.g0(chatInputType.intValue());
            }
            Integer showC2CPanel = localData.showC2CPanel;
            if (showC2CPanel != null) {
                Intrinsics.checkNotNullExpressionValue(showC2CPanel, "showC2CPanel");
                aVar.u0(showC2CPanel.intValue());
            }
            Integer pttChangeVoiceType = localData.pttChangeVoiceType;
            if (pttChangeVoiceType != null) {
                Intrinsics.checkNotNullExpressionValue(pttChangeVoiceType, "pttChangeVoiceType");
                aVar.t0(pttChangeVoiceType.intValue());
            }
            Boolean isDataChanged = localData.isDataChanged;
            if (isDataChanged != null) {
                Intrinsics.checkNotNullExpressionValue(isDataChanged, "isDataChanged");
                aVar.i0(Boolean.valueOf(isDataChanged.booleanValue()));
            }
            Integer audioPanelType = localData.audioPanelType;
            if (audioPanelType != null) {
                Intrinsics.checkNotNullExpressionValue(audioPanelType, "audioPanelType");
                aVar.f0(audioPanelType.intValue());
            }
            Long lastIceBreakChatTs = localData.lastIceBreakChatTs;
            if (lastIceBreakChatTs != null) {
                Intrinsics.checkNotNullExpressionValue(lastIceBreakChatTs, "lastIceBreakChatTs");
                aVar.k0(lastIceBreakChatTs.longValue());
            }
            Long makeFrdsTs = localData.makeFrdsTs;
            if (makeFrdsTs != null) {
                Intrinsics.checkNotNullExpressionValue(makeFrdsTs, "makeFrdsTs");
                aVar.p0(makeFrdsTs.longValue());
            }
            Long topPositionTime = localData.topPositionTime;
            if (topPositionTime != null) {
                Intrinsics.checkNotNullExpressionValue(topPositionTime, "topPositionTime");
                aVar.y0(topPositionTime.longValue());
            }
            Long togetherBusinessFlag = localData.togetherBusinessFlag;
            if (togetherBusinessFlag != null) {
                Intrinsics.checkNotNullExpressionValue(togetherBusinessFlag, "togetherBusinessFlag");
                aVar.x0(togetherBusinessFlag.longValue());
            }
            Long comingRingId = localData.comingRingId;
            if (comingRingId != null) {
                Intrinsics.checkNotNullExpressionValue(comingRingId, "comingRingId");
                aVar.h0(comingRingId.longValue());
            }
            Long timestamp = localData.timestamp;
            if (timestamp != null) {
                Intrinsics.checkNotNullExpressionValue(timestamp, "timestamp");
                aVar.v0(timestamp.longValue());
            }
        }
        return aVar;
    }

    @NotNull
    public final com.tencent.qqnt.ntrelation.otherinfo.bean.c h(@NotNull String uid, @Nullable OtherFlag otherFlag, @Nullable RelationFlag relationFlag) {
        HashMap<String, StockLocalData> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.qqnt.ntrelation.otherinfo.bean.c) iPatchRedirector.redirect((short) 14, this, uid, otherFlag, relationFlag);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        StockLocalData stockLocalData = null;
        com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.c(null, null, 3, null);
        cVar.t(uid);
        cVar.u(m(uid));
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        y f16 = com.tencent.qqnt.msg.f.f();
        if (f16 != null) {
            hashMap = f16.getStockLocalData("KernelDataConvertUtil", arrayList);
        } else {
            hashMap = null;
        }
        if (hashMap != null) {
            stockLocalData = hashMap.get(uid);
        }
        p(otherFlag, relationFlag, stockLocalData, cVar);
        return cVar;
    }

    @NotNull
    public final com.tencent.qqnt.ntrelation.zoneinfo.bean.a i(@NotNull String uid, @Nullable UserDetailInfo userDetailInfo, @Nullable StockLocalData localData) {
        boolean booleanValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (com.tencent.qqnt.ntrelation.zoneinfo.bean.a) iPatchRedirector.redirect((short) 21, this, uid, userDetailInfo, localData);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        com.tencent.qqnt.ntrelation.zoneinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.zoneinfo.bean.a(null, null, 0, 0L, null, false, null, 127, null);
        aVar.m(uid);
        aVar.n(m(uid));
        if (localData != null) {
            String str = localData.feedContent;
            if (str == null) {
                str = "";
            }
            aVar.k(str);
            Boolean bool = localData.feedHasPhoto;
            if (bool == null) {
                booleanValue = false;
            } else {
                Intrinsics.checkNotNullExpressionValue(bool, "it.feedHasPhoto ?: false");
                booleanValue = bool.booleanValue();
            }
            aVar.l(booleanValue);
        }
        return aVar;
    }

    @NotNull
    public final com.tencent.qqnt.ntrelation.zoneinfo.bean.c j(@NotNull String uid, @Nullable StockLocalData localData) {
        boolean booleanValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (com.tencent.qqnt.ntrelation.zoneinfo.bean.c) iPatchRedirector.redirect((short) 20, (Object) this, (Object) uid, (Object) localData);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        com.tencent.qqnt.ntrelation.zoneinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.zoneinfo.bean.c(null, null, 3, null);
        cVar.m(uid);
        cVar.n(m(uid));
        if (localData != null) {
            String str = localData.feedContent;
            if (str == null) {
                str = "";
            }
            cVar.k(str);
            Boolean bool = localData.feedHasPhoto;
            if (bool == null) {
                booleanValue = false;
            } else {
                Intrinsics.checkNotNullExpressionValue(bool, "it.feedHasPhoto ?: false");
                booleanValue = bool.booleanValue();
            }
            cVar.l(booleanValue);
        }
        return cVar;
    }

    @NotNull
    public HashMap<String, StockLocalData> k(@NotNull ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.a> ntOtherDetailInfoList) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        boolean z37;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (HashMap) iPatchRedirector.redirect((short) 17, (Object) this, (Object) ntOtherDetailInfoList);
        }
        Intrinsics.checkNotNullParameter(ntOtherDetailInfoList, "ntOtherDetailInfoList");
        HashMap<String, StockLocalData> hashMap = new HashMap<>();
        if (ntOtherDetailInfoList.isEmpty()) {
            return hashMap;
        }
        Iterator<com.tencent.qqnt.ntrelation.otherinfo.bean.a> it = ntOtherDetailInfoList.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.otherinfo.bean.a next = it.next();
            if (next != null) {
                StockLocalData stockLocalData = new StockLocalData();
                boolean z38 = true;
                if (next.w() != Integer.MIN_VALUE) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    stockLocalData.chatInputType = Integer.valueOf(next.w());
                }
                if (next.Z() != Integer.MIN_VALUE) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    stockLocalData.showC2CPanel = Integer.valueOf(next.Z());
                }
                if (next.V() != Integer.MIN_VALUE) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    stockLocalData.pttChangeVoiceType = Integer.valueOf(next.V());
                }
                if (next.v() != Integer.MIN_VALUE) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z19) {
                    stockLocalData.audioPanelType = Integer.valueOf(next.v());
                }
                Boolean e06 = next.e0();
                if (e06 != null) {
                    e06.booleanValue();
                    stockLocalData.isDataChanged = next.e0();
                }
                if (next.z() != Long.MIN_VALUE) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (z26) {
                    stockLocalData.lastIceBreakChatTs = Long.valueOf(next.z());
                }
                if (next.F() != Long.MIN_VALUE) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                if (z27) {
                    stockLocalData.makeFrdsTs = Long.valueOf(next.F());
                }
                if (next.d0() != Long.MIN_VALUE) {
                    z28 = true;
                } else {
                    z28 = false;
                }
                if (z28) {
                    stockLocalData.topPositionTime = Long.valueOf(next.d0());
                }
                if (next.c0() != Long.MIN_VALUE) {
                    z29 = true;
                } else {
                    z29 = false;
                }
                if (z29) {
                    stockLocalData.togetherBusinessFlag = Long.valueOf(next.c0());
                }
                if (next.x() != Long.MIN_VALUE) {
                    z36 = true;
                } else {
                    z36 = false;
                }
                if (z36) {
                    stockLocalData.comingRingId = Long.valueOf(next.x());
                }
                if (next.b0() != Long.MIN_VALUE) {
                    z37 = true;
                } else {
                    z37 = false;
                }
                if (z37) {
                    stockLocalData.timestamp = Long.valueOf(next.b0());
                }
                if (next.f() == Long.MIN_VALUE) {
                    z38 = false;
                }
                if (z38) {
                    stockLocalData.specialCareDateTime = Long.valueOf(next.f());
                }
                hashMap.put(next.getUid(), stockLocalData);
            }
        }
        return hashMap;
    }

    public final byte l(@NotNull RelationFlag flag) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Byte) iPatchRedirector.redirect((short) 22, (Object) this, (Object) flag)).byteValue();
        }
        Intrinsics.checkNotNullParameter(flag, "flag");
        if (flag.qidianMasterFlag != 0) {
            i3 = 16;
        } else {
            i3 = 0;
        }
        if (flag.qidianCrewFlag != 0 || flag.qidianCrewFlag2 != 0) {
            i3 |= 4;
        }
        return (byte) i3;
    }

    @NotNull
    public final String m(@NotNull String uid) {
        Long z06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this, (Object) uid);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        ag j3 = com.tencent.qqnt.msg.f.j();
        if (j3 != null && (z06 = j3.z0(uid)) != null) {
            return String.valueOf(z06.longValue());
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("KernelDataConvertUtil", 1, "get uin faild ,uid = " + uid);
            return "";
        }
        return "";
    }

    public final boolean o(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(str, "str");
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!Character.isDigit(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:
    
        if (r6 != null) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p(@Nullable OtherFlag otherFlag, @Nullable RelationFlag relationFlag, @Nullable StockLocalData stockLocalData, @NotNull com.tencent.qqnt.ntrelation.otherinfo.bean.c result) {
        Long l3;
        Integer intOrNull;
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, otherFlag, relationFlag, stockLocalData, result);
            return;
        }
        Intrinsics.checkNotNullParameter(result, "result");
        if (otherFlag != null) {
            result.n(Boolean.valueOf(otherFlag.isAioShortcutBarOpen));
            result.r(otherFlag.isSharingLocation ? 1 : 0);
            result.o(otherFlag.colorRindId);
        }
        if (relationFlag != null) {
            boolean z16 = isNotifyRingIdOptSwitch;
            if (!z16 || !relationFlag.isSpecialCareOpen) {
                if (!z16) {
                    String str = relationFlag.ringId;
                    Intrinsics.checkNotNullExpressionValue(str, "it.ringId");
                    intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
                }
                result.q(0);
                String str2 = relationFlag.c2cRingId;
                Intrinsics.checkNotNullExpressionValue(str2, "it.c2cRingId");
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str2);
                if (longOrNull != null) {
                    result.p(longOrNull.longValue());
                }
            }
            result.q(1);
            String str22 = relationFlag.c2cRingId;
            Intrinsics.checkNotNullExpressionValue(str22, "it.c2cRingId");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str22);
            if (longOrNull != null) {
            }
        }
        if (stockLocalData != null && (l3 = stockLocalData.specialCareDateTime) != null) {
            result.s(l3.longValue());
        }
    }

    public void q(@NotNull String trace, @NotNull String uid, @Nullable UserSimpleInfo userSimpleInfo, @NotNull com.tencent.qqnt.ntrelation.friendsinfo.bean.d result) {
        RelationFlag relationFlag;
        StatusInfo statusInfo;
        BaseInfo baseInfo;
        CoreInfo coreInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, trace, uid, userSimpleInfo, result);
            return;
        }
        Intrinsics.checkNotNullParameter(trace, "trace");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(result, "result");
        result.v0(uid);
        result.w0(m(uid));
        if (userSimpleInfo != null && (coreInfo = userSimpleInfo.coreInfo) != null) {
            result.k0(coreInfo.nick);
            result.m0(coreInfo.remark);
        }
        if (userSimpleInfo != null && (baseInfo = userSimpleInfo.baseInfo) != null) {
            if (!userSimpleInfo.isBuddy) {
                result.d0(-1);
            } else {
                result.d0(baseInfo.categoryId);
            }
            result.V(baseInfo.age);
            result.q0(baseInfo.sex);
            result.o0(baseInfo.richTime);
            result.n0(baseInfo.richBuffer);
        }
        if (userSimpleInfo != null && (statusInfo = userSimpleInfo.status) != null) {
            result.u0(statusInfo.status);
        }
        if (userSimpleInfo != null && (relationFlag = userSimpleInfo.relationFlags) != null) {
            if (logRingIdUpdate && !Intrinsics.areEqual(result.u(), relationFlag.ringId)) {
                QLog.i(TAG_RING_ID_UPDATE, 1, "[userSimpleInfoUpdateNTSimpleInfo] trace=" + trace + " uid=" + uid + " uin=" + result.x() + " hash=" + result.hashCode() + " ringId=" + result.u() + "->" + relationFlag.ringId);
            }
            result.a0(Boolean.valueOf(relationFlag.isBlock));
            result.b0(Boolean.valueOf(relationFlag.isBlocked));
            result.p0(relationFlag.ringId);
            result.i0(Boolean.valueOf(relationFlag.isMsgDisturb));
            result.s0(Boolean.valueOf(relationFlag.isSpecialCareOpen));
            result.t0(Boolean.valueOf(relationFlag.isSpecialCareZone));
            result.c0(Byte.valueOf(f360229a.l(relationFlag)));
            result.a0(Boolean.valueOf(relationFlag.isBlock));
            result.b0(Boolean.valueOf(relationFlag.isBlocked));
        }
        if (QLog.isColorLevel() && isLogOpen) {
            QLog.i("KernelDataConvertUtil", 1, "trace " + trace + " userSimpleInfoUpdateNTSimpleInfo " + result);
        }
    }
}
