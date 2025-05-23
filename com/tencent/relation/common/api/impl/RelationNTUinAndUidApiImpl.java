package com.tencent.relation.common.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.msg.f;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.utils.h;
import com.tencent.relation.common.utils.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RelationNTUinAndUidApiImpl implements IRelationNTUinAndUidApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RelationNTUinAndUidApiImpl";
    private static final Pattern uidPattern;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21853);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            uidPattern = Pattern.compile("^[a-zA-Z0-9_-]*$");
        }
    }

    public RelationNTUinAndUidApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean isValidUid(String str) {
        if (!TextUtils.isEmpty(str) && (!str.startsWith("u_") || uidPattern.matcher(str).matches())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$fetchUid2UinMap$2(List list, HashMap hashMap, IRelationNTUinAndUidApi.a aVar, Boolean bool, Map map) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String str2 = (String) map.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = getUidFromUin(str);
            }
            if (TextUtils.isEmpty(str2)) {
                arrayList.add(str);
            } else {
                hashMap.put(str, str2);
            }
        }
        if (!arrayList.isEmpty()) {
            QLog.e(TAG, 2, "[fetchUid2UinMap]: error, cannot get uid, errUin=" + arrayList);
        }
        aVar.a(hashMap);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$fetchUidFromUin$1(List list, ArrayList arrayList, IRelationNTUinAndUidApi.b bVar, Boolean bool, Map map) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String str2 = (String) map.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = getUidFromUin(str);
            }
            if (TextUtils.isEmpty(str2)) {
                arrayList2.add(str);
            } else {
                arrayList.add(str2);
            }
        }
        if (!arrayList2.isEmpty()) {
            QLog.e(TAG, 2, "[fetchUidFromUin]: error, cannot get uid, errUin=" + arrayList2);
        }
        bVar.a(arrayList);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$fetchUin2UidMap$3(List list, HashMap hashMap, IRelationNTUinAndUidApi.c cVar, Boolean bool, Map map) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String str2 = (String) map.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = getUidFromUin(str);
            }
            if (TextUtils.isEmpty(str2)) {
                arrayList.add(str);
            } else {
                hashMap.put(str, str2);
            }
        }
        if (!arrayList.isEmpty()) {
            QLog.e(TAG, 2, "[fetchUin2UidMap]: error, cannot get uid, errUin=" + arrayList);
        }
        cVar.a(hashMap);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$getUidFromUin$0(String str, IRelationNTUinAndUidApi.d dVar, Boolean bool, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = getUidFromUin(str);
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.e(TAG, 2, "getUidFromUin: error, cannot get uid, uin=" + str);
        }
        dVar.a(str2);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$getUinFromUid$4(String str, IRelationNTUinAndUidApi.e eVar, Boolean bool, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = getUinFromUid(str);
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.e(TAG, 2, "getUinFromUid: error, cannot get uin, uid=" + str);
        }
        eVar.a(str2);
        return null;
    }

    @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi
    public void fetchUid2UinMap(List<String> list, boolean z16, boolean z17, final IRelationNTUinAndUidApi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, list, Boolean.valueOf(z16), Boolean.valueOf(z17), aVar);
            return;
        }
        final HashMap<String, String> hashMap = new HashMap<>();
        final ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (z16) {
                String friendUinFromUid = getFriendUinFromUid(str);
                if (!TextUtils.isEmpty(friendUinFromUid)) {
                    hashMap.put(str, friendUinFromUid);
                } else {
                    arrayList.add(str);
                }
            }
        }
        if (z17 && !arrayList.isEmpty()) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberUin(arrayList, new Function2(arrayList, hashMap, aVar) { // from class: com.tencent.relation.common.api.impl.b

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ List f364673e;

                /* renamed from: f, reason: collision with root package name */
                public final /* synthetic */ HashMap f364674f;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit lambda$fetchUid2UinMap$2;
                    lambda$fetchUid2UinMap$2 = RelationNTUinAndUidApiImpl.this.lambda$fetchUid2UinMap$2(this.f364673e, this.f364674f, null, (Boolean) obj, (Map) obj2);
                    return lambda$fetchUid2UinMap$2;
                }
            });
            return;
        }
        QLog.i(TAG, 1, "[fetchUid2UinMap] noFriends size:" + arrayList.size());
        aVar.a(hashMap);
    }

    @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi
    public void fetchUidFromUin(final List<String> list, boolean z16, boolean z17, final IRelationNTUinAndUidApi.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, list, Boolean.valueOf(z16), Boolean.valueOf(z17), bVar);
            return;
        }
        final ArrayList<String> arrayList = new ArrayList<>();
        if (z16) {
            ArrayList arrayList2 = new ArrayList();
            for (String str : list) {
                String friendUidFromUin = getFriendUidFromUin(str);
                if (!TextUtils.isEmpty(friendUidFromUin)) {
                    arrayList.add(friendUidFromUin);
                } else {
                    arrayList2.add(str);
                }
            }
            list = arrayList2;
        }
        if (z17 && !list.isEmpty()) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberUid(list, new Function2(list, arrayList, bVar) { // from class: com.tencent.relation.common.api.impl.d

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ List f364679e;

                /* renamed from: f, reason: collision with root package name */
                public final /* synthetic */ ArrayList f364680f;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit lambda$fetchUidFromUin$1;
                    lambda$fetchUidFromUin$1 = RelationNTUinAndUidApiImpl.this.lambda$fetchUidFromUin$1(this.f364679e, this.f364680f, null, (Boolean) obj, (Map) obj2);
                    return lambda$fetchUidFromUin$1;
                }
            });
            return;
        }
        QLog.i(TAG, 1, "[fetchUidFromUin] noFriends size:" + list.size());
        bVar.a(arrayList);
    }

    @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi
    public void fetchUin2UidMap(final List<String> list, boolean z16, boolean z17, final IRelationNTUinAndUidApi.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, list, Boolean.valueOf(z16), Boolean.valueOf(z17), cVar);
            return;
        }
        final HashMap hashMap = new HashMap();
        if (z16) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                String friendUidFromUin = getFriendUidFromUin(str);
                if (!TextUtils.isEmpty(friendUidFromUin)) {
                    hashMap.put(str, friendUidFromUin);
                } else {
                    arrayList.add(str);
                }
            }
            list = arrayList;
        }
        if ((!list.isEmpty()) & z17) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberUid(list, new Function2() { // from class: com.tencent.relation.common.api.impl.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit lambda$fetchUin2UidMap$3;
                    lambda$fetchUin2UidMap$3 = RelationNTUinAndUidApiImpl.this.lambda$fetchUin2UidMap$3(list, hashMap, cVar, (Boolean) obj, (Map) obj2);
                    return lambda$fetchUin2UidMap$3;
                }
            });
            return;
        }
        QLog.i(TAG, 1, "[fetchUin2UidMap] noFriends size:" + list.size());
        cVar.a(hashMap);
    }

    @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi
    public String getFriendUidFromUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        return getUidFromUin(str);
    }

    @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi
    public String getFriendUinFromUid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        return getUinFromUid(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a0  */
    @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getUidFromUin(String str) {
        Long valueOf;
        HashMap<Long, String> uidByUin;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (!isValidUin(str) && ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
            new Exception("getUidFromUin not valid uin:" + str);
        }
        y f16 = f.f();
        if (f16 != null) {
            try {
                valueOf = Long.valueOf(str);
                uidByUin = f16.getUidByUin(TAG, new ArrayList<>(Collections.singletonList(valueOf)));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "getUidFromUin local mmkv fail uin=  \uff1a" + str + " uid= e:" + e16);
                }
            }
            if (uidByUin != null && uidByUin.containsKey(valueOf)) {
                str2 = uidByUin.get(valueOf);
                if (!isValidUid(str2)) {
                    return str2;
                }
                String f17 = h.d().f(str);
                if (isValidUid(f17)) {
                    return f17;
                }
                if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
                    QLog.i(TAG, 1, "getUidFromUin local mmkv fail uin=  \uff1a" + str + " uid= " + f17);
                }
                h.d().h(str, f17);
                if (StringUtils.isNumeric(str) && TextUtils.isEmpty("") && ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
                    QLog.i(TAG, 1, "getUidFromUin fail uin is:" + str);
                }
                return "";
            }
        }
        str2 = "";
        if (!isValidUid(str2)) {
        }
    }

    @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi
    public String getUinFromUid(String str) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (!isValidUid(str) && ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
            new Exception(" getUinFromUid not valid uid:" + str);
        }
        String str2 = "";
        y f16 = f.f();
        if (f16 != null) {
            try {
                HashMap<String, Long> uinByUid = f16.getUinByUid(TAG, new ArrayList<>(Arrays.asList(str)));
                if (uinByUid != null && uinByUid.containsKey(str) && (l3 = uinByUid.get(str)) != null) {
                    str2 = l3.toString();
                    if (!TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "getUinFromUid local mmkv fail uin=  \uff1a" + str2 + " uid= " + str + "e:" + e16);
                }
            }
        }
        String g16 = h.d().g(str);
        TextUtils.isEmpty(g16);
        return g16;
    }

    @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi
    public boolean isValidUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str)).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && j.b(TAG, str) >= 10000) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi
    public void saveUidByUin(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (j.b(TAG, str) > 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !str.equals(str2) && isValidUid(str2)) {
            h.d().i(str, str2);
        } else if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "saveUidByUin is error! uin or uid is invalid! uid is " + str2);
        }
    }

    @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi
    public void getUinFromUid(final String str, boolean z16, boolean z17, final IRelationNTUinAndUidApi.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17), eVar);
            return;
        }
        if (z16) {
            String friendUinFromUid = getFriendUinFromUid(str);
            if (!TextUtils.isEmpty(friendUinFromUid)) {
                eVar.a(friendUinFromUid);
                return;
            }
        }
        if (z17) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberUin(str, new Function2() { // from class: com.tencent.relation.common.api.impl.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit lambda$getUinFromUid$4;
                    lambda$getUinFromUid$4 = RelationNTUinAndUidApiImpl.this.lambda$getUinFromUid$4(str, eVar, (Boolean) obj, (String) obj2);
                    return lambda$getUinFromUid$4;
                }
            });
            return;
        }
        String uinFromUid = getUinFromUid(str);
        if (TextUtils.isEmpty(uinFromUid)) {
            QLog.e(TAG, 2, "getUinFromUid: error, cannot get uin, uid=" + str);
        }
        eVar.a(uinFromUid);
    }

    @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi
    public void getUidFromUin(final String str, boolean z16, boolean z17, final IRelationNTUinAndUidApi.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17), dVar);
            return;
        }
        if (z16) {
            String friendUidFromUin = getFriendUidFromUin(str);
            if (!TextUtils.isEmpty(friendUidFromUin)) {
                dVar.a(friendUidFromUin);
                return;
            }
        }
        if (z17) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberUid(str, new Function2() { // from class: com.tencent.relation.common.api.impl.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit lambda$getUidFromUin$0;
                    lambda$getUidFromUin$0 = RelationNTUinAndUidApiImpl.this.lambda$getUidFromUin$0(str, dVar, (Boolean) obj, (String) obj2);
                    return lambda$getUidFromUin$0;
                }
            });
            return;
        }
        String uidFromUin = getUidFromUin(str);
        if (TextUtils.isEmpty(uidFromUin)) {
            QLog.e(TAG, 2, "getUidFromUin: error, cannot get uid, uin=" + str);
        }
        dVar.a(uidFromUin);
    }
}
