package com.tencent.mobileqq.zplan.couple.processor;

import com.tencent.mobileqq.qcall.g;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qcoroutine.framework.impl.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarSceneConfigManager;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.couple.config.ZPlanCoupleAvatarProfileInfo;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.OtherFlag;
import com.tencent.qqnt.msg.f;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000f\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u0016\u0010\u0014\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0002J\u001e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\tJ\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0002J\u0016\u0010\u001e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010#R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010#R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010#R\u0016\u0010'\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010 R\u0016\u0010(\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010 \u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zplan/couple/processor/ZPlanCoupleProfileDataProcessor;", "", "", h.F, PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "j", "", "friendUin", "", "status", DomainData.DOMAIN_NAME, "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "NTFriendSimpleInfoList", "b", "e", "", "", "sceneIds", "d", "k", "i", "c", "uin", "f", "sceneID", "needPush", "l", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "updateListDone", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "switchOnUinList", "allFriendUinList", "allFriendUinStringList", "hasRequestedAppearanceKey", "hasRequestedBothScene", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanCoupleProfileDataProcessor {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanCoupleProfileDataProcessor f332677a = new ZPlanCoupleProfileDataProcessor();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean updateListDone = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<String> switchOnUinList = new CopyOnWriteArrayList<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<Long> allFriendUinList = new CopyOnWriteArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<String> allFriendUinStringList = new CopyOnWriteArrayList<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean hasRequestedAppearanceKey = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean hasRequestedBothScene = new AtomicBoolean(false);

    ZPlanCoupleProfileDataProcessor() {
    }

    private final void d(Set<Integer> sceneIds) {
        int[] intArray;
        sceneIds.addAll(ZPlanQQMC.INSTANCE.getCoupleAvatarDefaultSceneIDList());
        CoupleAvatarSceneConfigManager coupleAvatarSceneConfigManager = CoupleAvatarSceneConfigManager.f330980a;
        intArray = CollectionsKt___CollectionsKt.toIntArray(sceneIds);
        CoupleAvatarSceneConfigManager.f(coupleAvatarSceneConfigManager, 0, intArray, null, 4, null);
    }

    private final void e() {
        long[] longArray;
        CoupleAvatarSceneConfigManager coupleAvatarSceneConfigManager = CoupleAvatarSceneConfigManager.f330980a;
        longArray = CollectionsKt___CollectionsKt.toLongArray(allFriendUinList);
        coupleAvatarSceneConfigManager.g(longArray);
    }

    private final long h() {
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getLong(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin() + "_key_fetch_nt_other_flag", 0L);
    }

    private final void j(long timeStamp) {
        QLog.i("ZPlanCoupleProfileDataProcessor", 1, "saveFetchNTOtherFlagTimestamp, timeStamp=" + timeStamp);
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setLong(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin() + "_key_fetch_nt_other_flag", timeStamp);
    }

    private final void k() {
        String joinToString$default;
        CopyOnWriteArrayList<String> copyOnWriteArrayList = switchOnUinList;
        QLog.i("ZPlanCoupleProfileDataProcessor", 1, "saveSwitchOnUinListToMMKV, listSize=" + copyOnWriteArrayList.size());
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        String str = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin() + "_key_switch_on_uin_list_mmkv";
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(copyOnWriteArrayList, ", ", "[", "]", 0, null, null, 56, null);
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(str, joinToString$default);
    }

    public final void c() {
        List<d> allFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getAllFriend("ZPlanCoupleProfileDataProcessor");
        CoroutineScope f16 = a.f261834a.f(i.c.f261781e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "ZPlanCoupleProfileDataProcessor_doOnGetAllFriendList", null, null, null, new ZPlanCoupleProfileDataProcessor$fetchZPlanCoupleProfileInfos$1(allFriend, null), 14, null);
        }
    }

    public final int f(long uin) {
        ZPlanCoupleAvatarProfileInfo g16 = ZplanDataRepository.f334898a.g(uin);
        if (g16 != null) {
            return g16.sceneId;
        }
        return 0;
    }

    public final boolean g(long uin) {
        boolean contains$default;
        boolean contains;
        if (ZPlanQQMC.INSTANCE.enableCoupleAvatarSwitchCache() && ((contains = switchOnUinList.contains(String.valueOf(uin))) || updateListDone.get())) {
            QLog.i("ZPlanCoupleProfileDataProcessor", 1, "getCoupleAvatarSwitchStatus, updateListDone true, uin: " + g.a(uin) + ", isSwitchOn: " + contains);
            return contains;
        }
        String i3 = i();
        if (i3.length() > 0) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) i3, (CharSequence) String.valueOf(uin), false, 2, (Object) null);
            if (contains$default) {
                QLog.i("ZPlanCoupleProfileDataProcessor", 1, "getCoupleAvatarSwitchStatus, updateListDone false, uin: " + g.a(uin) + ", MMKVSwitchOn.");
                return true;
            }
        }
        QLog.i("ZPlanCoupleProfileDataProcessor", 1, "getCoupleAvatarSwitchStatus, updateListDone false, uin: " + g.a(uin) + ", no cache data.");
        return false;
    }

    public final void l(long friendUin, int sceneID, boolean needPush) {
        ZplanDataRepository zplanDataRepository = ZplanDataRepository.f334898a;
        ZPlanCoupleAvatarProfileInfo g16 = zplanDataRepository.g(friendUin);
        if (g16 == null) {
            g16 = new ZPlanCoupleAvatarProfileInfo(String.valueOf(friendUin), false, 0, 6, null);
        }
        g16.sceneId = sceneID;
        zplanDataRepository.D(g16);
        CoroutineScope f16 = a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "ZPlanCoupleProfileDataProcessor_setCoupleAvatarSceneId", null, null, null, new ZPlanCoupleProfileDataProcessor$setCoupleAvatarSceneId$1(friendUin, sceneID, needPush, null), 14, null);
        }
    }

    public final void m(long friendUin, boolean status) {
        String valueOf = String.valueOf(friendUin);
        CopyOnWriteArrayList<String> copyOnWriteArrayList = switchOnUinList;
        QLog.i("ZPlanCoupleProfileDataProcessor", 1, "setCoupleAvatarSwitchStatus, friendUin: " + valueOf + ", status: " + status + ", switchOnUinList size: " + copyOnWriteArrayList.size());
        if (status && !copyOnWriteArrayList.contains(valueOf)) {
            copyOnWriteArrayList.add(valueOf);
        } else if (!status && copyOnWriteArrayList.contains(valueOf)) {
            copyOnWriteArrayList.remove(valueOf);
        }
        n(valueOf, status);
        ZplanDataRepository zplanDataRepository = ZplanDataRepository.f334898a;
        ZPlanCoupleAvatarProfileInfo g16 = zplanDataRepository.g(friendUin);
        if (g16 == null) {
            g16 = new ZPlanCoupleAvatarProfileInfo(String.valueOf(friendUin), false, 0, 6, null);
        }
        g16.switchStatus = status;
        zplanDataRepository.D(g16);
        CoroutineScope f16 = a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "ZPlanCoupleProfileDataProcessor_setCoupleAvatarSwitchState", null, null, null, new ZPlanCoupleProfileDataProcessor$setCoupleAvatarSwitchStatus$1(friendUin, status, null), 14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01cd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0170 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(List<? extends d> NTFriendSimpleInfoList) {
        HashMap<String, OtherFlag> otherFlag;
        String str;
        ArrayList<String> arrayListOf;
        Long l3;
        Long longOrNull;
        long longValue;
        ZPlanCoupleAvatarProfileInfo g16;
        String removePrefix;
        String removeSuffix;
        List split$default;
        Long longOrNull2;
        List<? extends d> list = NTFriendSimpleInfoList;
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (d dVar : NTFriendSimpleInfoList) {
            if (dVar != null) {
                arrayList.add(dVar.getUid());
                CopyOnWriteArrayList<String> copyOnWriteArrayList = allFriendUinStringList;
                if (!copyOnWriteArrayList.contains(dVar.x())) {
                    copyOnWriteArrayList.add(dVar.x());
                    longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(dVar.x());
                    if (longOrNull2 != null) {
                        allFriendUinList.add(Long.valueOf(longOrNull2.longValue()));
                    }
                }
            }
        }
        if (!hasRequestedBothScene.get() && ZPlanQQMC.INSTANCE.enableAIOSceneLinkage()) {
            hasRequestedBothScene.set(true);
            e();
        }
        if (!hasRequestedAppearanceKey.get() && ZPlanQQMC.INSTANCE.enableFetchAppearanceKeyWhenLaunch()) {
            hasRequestedAppearanceKey.set(true);
            ZplanDataRepository.x(ZplanDataRepository.f334898a, allFriendUinStringList, null, 2, null);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        long h16 = h();
        long currentTimeMillis = System.currentTimeMillis();
        if (h16 != 0 && currentTimeMillis - h16 <= 21600000) {
            String i3 = i();
            try {
                List arrayList2 = new ArrayList();
                if (i3.length() > 0) {
                    removePrefix = StringsKt__StringsKt.removePrefix(i3, (CharSequence) "[");
                    removeSuffix = StringsKt__StringsKt.removeSuffix(removePrefix, (CharSequence) "]");
                    split$default = StringsKt__StringsKt.split$default((CharSequence) removeSuffix, new String[]{", "}, false, 0, 6, (Object) null);
                    arrayList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) split$default);
                }
                CopyOnWriteArrayList<String> copyOnWriteArrayList2 = switchOnUinList;
                copyOnWriteArrayList2.clear();
                copyOnWriteArrayList2.addAll(arrayList2);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) it.next());
                    if (longOrNull == null || (g16 = ZplanDataRepository.f334898a.g((longValue = longOrNull.longValue()))) == null) {
                        return;
                    }
                    int i16 = g16.sceneId;
                    if (i16 != 0) {
                        linkedHashSet.add(Integer.valueOf(i16));
                    }
                    QLog.e("ZPlanCoupleProfileDataProcessor", 1, "get from mmkv uinLong:" + longValue + " isZPlanSwitchOn:true zplanSceneId:" + i16);
                }
            } catch (Throwable th5) {
                QLog.e("ZPlanCoupleProfileDataProcessor", 1, "get sceneIds failed, t:" + th5);
            }
        } else {
            y f16 = f.f();
            if (f16 == null || (otherFlag = f16.getOtherFlag("ZPlanCoupleProfileDataProcessor", arrayList)) == null) {
                return;
            }
            for (Map.Entry<String, OtherFlag> entry : otherFlag.entrySet()) {
                String key = entry.getKey();
                OtherFlag value = entry.getValue();
                if (value != null) {
                    if (!(key == null || key.length() == 0)) {
                        y f17 = f.f();
                        if (f17 != null) {
                            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(key);
                            HashMap<String, Long> uinByUid = f17.getUinByUid("", arrayListOf);
                            if (uinByUid != null && (l3 = uinByUid.get(key)) != null) {
                                str = String.valueOf(l3);
                                if (str != null || str.length() == 0) {
                                    boolean z16 = value.isZPlanCoupleOpen;
                                    int i17 = value.zplanCoupleSceneId;
                                    if (z16) {
                                        CopyOnWriteArrayList<String> copyOnWriteArrayList3 = switchOnUinList;
                                        if (!copyOnWriteArrayList3.contains(str)) {
                                            copyOnWriteArrayList3.add(str);
                                        }
                                    } else {
                                        CopyOnWriteArrayList<String> copyOnWriteArrayList4 = switchOnUinList;
                                        if (copyOnWriteArrayList4.contains(str)) {
                                            copyOnWriteArrayList4.remove(str);
                                        }
                                    }
                                    ZplanDataRepository.f334898a.D(new ZPlanCoupleAvatarProfileInfo(str, z16, i17));
                                    if (i17 != 0) {
                                        linkedHashSet.add(Integer.valueOf(i17));
                                    }
                                }
                            }
                        }
                        str = null;
                        if (str != null || str.length() == 0) {
                        }
                    }
                }
            }
            k();
            j(currentTimeMillis);
        }
        updateListDone.getAndSet(true);
        d(linkedHashSet);
    }

    private final String i() {
        QLog.i("ZPlanCoupleProfileDataProcessor", 1, "getSwitchOnUinListFromMMKV");
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin() + "_key_switch_on_uin_list_mmkv", "");
    }

    private final void n(String friendUin, boolean status) {
        String joinToString$default;
        String joinToString$default2;
        String removePrefix;
        String removeSuffix;
        List split$default;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        String str = peekAppRuntime.getCurrentUin() + "_key_switch_on_uin_list_mmkv";
        String i3 = i();
        try {
            List arrayList = new ArrayList();
            if (i3.length() > 0) {
                removePrefix = StringsKt__StringsKt.removePrefix(i3, (CharSequence) "[");
                removeSuffix = StringsKt__StringsKt.removeSuffix(removePrefix, (CharSequence) "]");
                split$default = StringsKt__StringsKt.split$default((CharSequence) removeSuffix, new String[]{", "}, false, 0, 6, (Object) null);
                arrayList = CollectionsKt___CollectionsKt.toMutableList((Collection) split$default);
            }
            if (status && !arrayList.contains(friendUin)) {
                arrayList.add(friendUin);
                joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "[", "]", 0, null, null, 56, null);
                ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(str, joinToString$default2);
            } else {
                if (status || !arrayList.contains(friendUin)) {
                    return;
                }
                arrayList.remove(friendUin);
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "[", "]", 0, null, null, 56, null);
                ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(str, joinToString$default);
            }
        } catch (Exception e16) {
            QLog.e("ZPlanCoupleProfileDataProcessor", 1, "updateSwitchStatusToMMKVImmediately failed.", e16);
        }
    }
}
