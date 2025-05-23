package com.tencent.hippykotlin.demo.pages.nearby.base.data;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import d45.a;
import defpackage.k;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import m25.c;
import r25.b;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class UserDataManager {
    public static final UserDataManager INSTANCE = new UserDataManager();
    public static NBPSsoLocation ssoLocation;
    public static final Lazy userSelfInfo$delegate;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<NBPUserSelfInfo>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager$userSelfInfo$2
            @Override // kotlin.jvm.functions.Function0
            public final NBPUserSelfInfo invoke() {
                return UserDataManager.INSTANCE.loadUserInfo();
            }
        });
        userSelfInfo$delegate = lazy;
        ssoLocation = new NBPSsoLocation();
    }

    public final c getCommonExtInfo() {
        return QQNearbyModule.Companion.getInstance().getCommonExtInfo();
    }

    public final NBPLatLng getSelfPosition() {
        return getUserSelfInfo().latLng;
    }

    public final NBPLatLng getSelfVaguePos() {
        NBPLatLng nBPLatLng = getUserSelfInfo().latLng;
        OffsetRandom offsetRandom = NBPLatLngExtKt.offsetRandom;
        return new NBPLatLng(offsetRandom.offsetLat + nBPLatLng.latitude, offsetRandom.offsetLng + nBPLatLng.longitude);
    }

    public final NBPUserSelfInfo getUserSelfInfo() {
        return (NBPUserSelfInfo) userSelfInfo$delegate.getValue();
    }

    public final NBPUserSelfInfo loadUserInfo() {
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        if (k.a(cVar)) {
            NBPUserSelfInfo.Companion companion = NBPUserSelfInfo.Companion;
            QQNearbyModule companion2 = QQNearbyModule.Companion.getInstance();
            companion2.getClass();
            return companion.fromJson(new e(companion2.syncToNativeMethod("getAndroidUserSelfInfo", (e) null, (Function1<? super e, Unit>) null)));
        }
        String item = ((CacheModule) cVar.g().acquireModule("HRCacheModule")).getItem("nbp_user_self_info");
        if (item.length() == 0) {
            item = "{}";
        }
        return NBPUserSelfInfo.Companion.fromJson(new e(item));
    }

    public final void saveUserSelfInfo() {
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        if (k.a(cVar)) {
            QQNearbyModule.Companion.getInstance().toNative(false, "saveAndroidUserSelfInfo", getUserSelfInfo().toJson(), null, false);
        } else {
            ((CacheModule) cVar.g().acquireModule("HRCacheModule")).setItem("nbp_user_self_info", getUserSelfInfo().toJson());
            QQNearbyModule.Companion.getInstance().toNative(false, "saveIOSUserSelfInfo", getUserSelfInfo().toJson(), null, false);
        }
    }

    public final void setSig(byte[] bArr) {
        String decodeToString;
        QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
        companion.getClass();
        decodeToString = StringsKt__StringsJVMKt.decodeToString(a.b(bArr));
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        if (k.a(cVar)) {
            e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("sigBase64", decodeToString);
            Unit unit = Unit.INSTANCE;
            companion.syncToNativeMethod("saveSig", m3, (Function1<? super e, Unit>) null);
        } else {
            e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("sigBase64", decodeToString);
            Unit unit2 = Unit.INSTANCE;
            companion.asyncToNativeMethod("saveSig", m16, (Function1<? super e, Unit>) null);
            ((CacheModule) cVar.g().acquireModule("HRCacheModule")).setItem("nearbypro_sig_str", decodeToString);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d0 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateAndSave(NBPLatLng nBPLatLng, String str, String str2, String str3, String str4, String str5, String str6) {
        double d16;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        NBPUserSelfInfo userSelfInfo = getUserSelfInfo();
        NBPLatLng nBPLatLng2 = userSelfInfo.latLng;
        double d17 = nBPLatLng2.latitude;
        double d18 = nBPLatLng.latitude;
        if (d17 == d18) {
            if (nBPLatLng2.longitude == nBPLatLng.longitude) {
                z16 = false;
                if (!Intrinsics.areEqual(userSelfInfo.locationAddress, str)) {
                    if (str.length() > 0) {
                        userSelfInfo.locationAddress = str;
                        z17 = true;
                        if (!Intrinsics.areEqual(userSelfInfo.locationName, str2)) {
                            if (str2.length() > 0) {
                                userSelfInfo.locationName = str2;
                                z18 = true;
                                if (!Intrinsics.areEqual(userSelfInfo.locationCountry, str3)) {
                                    if (str3.length() > 0) {
                                        userSelfInfo.locationCountry = str3;
                                        z19 = true;
                                        if (!Intrinsics.areEqual(userSelfInfo.locationProvince, str4)) {
                                            if (str4.length() > 0) {
                                                userSelfInfo.locationProvince = str4;
                                                z26 = true;
                                                if (!Intrinsics.areEqual(userSelfInfo.locationCity, str5)) {
                                                    if (str5.length() > 0) {
                                                        userSelfInfo.locationCity = str5;
                                                        z27 = true;
                                                        if (!Intrinsics.areEqual(userSelfInfo.locationDistrict, str6)) {
                                                            if (str6.length() > 0) {
                                                                userSelfInfo.locationDistrict = str6;
                                                                z28 = true;
                                                                if (!z16 || z17 || z18 || z19 || z26 || z27 || z28) {
                                                                    INSTANCE.saveUserSelfInfo();
                                                                }
                                                                return;
                                                            }
                                                        }
                                                        z28 = false;
                                                        if (z16) {
                                                        }
                                                        INSTANCE.saveUserSelfInfo();
                                                    }
                                                }
                                                z27 = false;
                                                if (!Intrinsics.areEqual(userSelfInfo.locationDistrict, str6)) {
                                                }
                                                z28 = false;
                                                if (z16) {
                                                }
                                                INSTANCE.saveUserSelfInfo();
                                            }
                                        }
                                        z26 = false;
                                        if (!Intrinsics.areEqual(userSelfInfo.locationCity, str5)) {
                                        }
                                        z27 = false;
                                        if (!Intrinsics.areEqual(userSelfInfo.locationDistrict, str6)) {
                                        }
                                        z28 = false;
                                        if (z16) {
                                        }
                                        INSTANCE.saveUserSelfInfo();
                                    }
                                }
                                z19 = false;
                                if (!Intrinsics.areEqual(userSelfInfo.locationProvince, str4)) {
                                }
                                z26 = false;
                                if (!Intrinsics.areEqual(userSelfInfo.locationCity, str5)) {
                                }
                                z27 = false;
                                if (!Intrinsics.areEqual(userSelfInfo.locationDistrict, str6)) {
                                }
                                z28 = false;
                                if (z16) {
                                }
                                INSTANCE.saveUserSelfInfo();
                            }
                        }
                        z18 = false;
                        if (!Intrinsics.areEqual(userSelfInfo.locationCountry, str3)) {
                        }
                        z19 = false;
                        if (!Intrinsics.areEqual(userSelfInfo.locationProvince, str4)) {
                        }
                        z26 = false;
                        if (!Intrinsics.areEqual(userSelfInfo.locationCity, str5)) {
                        }
                        z27 = false;
                        if (!Intrinsics.areEqual(userSelfInfo.locationDistrict, str6)) {
                        }
                        z28 = false;
                        if (z16) {
                        }
                        INSTANCE.saveUserSelfInfo();
                    }
                }
                z17 = false;
                if (!Intrinsics.areEqual(userSelfInfo.locationName, str2)) {
                }
                z18 = false;
                if (!Intrinsics.areEqual(userSelfInfo.locationCountry, str3)) {
                }
                z19 = false;
                if (!Intrinsics.areEqual(userSelfInfo.locationProvince, str4)) {
                }
                z26 = false;
                if (!Intrinsics.areEqual(userSelfInfo.locationCity, str5)) {
                }
                z27 = false;
                if (!Intrinsics.areEqual(userSelfInfo.locationDistrict, str6)) {
                }
                z28 = false;
                if (z16) {
                }
                INSTANCE.saveUserSelfInfo();
            }
            d16 = d18;
        } else {
            d16 = d18;
        }
        nBPLatLng2.latitude = d16;
        nBPLatLng2.longitude = nBPLatLng.longitude;
        z16 = true;
        if (!Intrinsics.areEqual(userSelfInfo.locationAddress, str)) {
        }
        z17 = false;
        if (!Intrinsics.areEqual(userSelfInfo.locationName, str2)) {
        }
        z18 = false;
        if (!Intrinsics.areEqual(userSelfInfo.locationCountry, str3)) {
        }
        z19 = false;
        if (!Intrinsics.areEqual(userSelfInfo.locationProvince, str4)) {
        }
        z26 = false;
        if (!Intrinsics.areEqual(userSelfInfo.locationCity, str5)) {
        }
        z27 = false;
        if (!Intrinsics.areEqual(userSelfInfo.locationDistrict, str6)) {
        }
        z28 = false;
        if (z16) {
        }
        INSTANCE.saveUserSelfInfo();
    }

    public final boolean isHostTid(Long l3) {
        return l3 != null && getUserSelfInfo().tid == l3.longValue();
    }

    public final void updateAndSave(r25.e eVar) {
        boolean z16;
        boolean z17;
        boolean z18;
        Object obj;
        String str;
        r25.c cVar;
        getUserSelfInfo().getClass();
        NBPUserSelfInfo userSelfInfo = getUserSelfInfo();
        long j3 = eVar.f430610d;
        boolean z19 = true;
        if (userSelfInfo.tid == j3 || j3 == 0) {
            z16 = false;
        } else {
            userSelfInfo.tid = j3;
            z16 = true;
        }
        boolean updateAvatar = userSelfInfo.updateAvatar(eVar.L);
        int i3 = eVar.K;
        if (userSelfInfo.gender != i3) {
            userSelfInfo.gender = i3;
            z17 = true;
        } else {
            z17 = false;
        }
        String str2 = eVar.J;
        if (Intrinsics.areEqual(userSelfInfo.nickName, str2)) {
            z18 = false;
        } else {
            userSelfInfo.nickName = str2;
            z18 = true;
        }
        Iterator<T> it = eVar.I.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((b) obj).f430598d == 1001) {
                    break;
                }
            }
        }
        b bVar = (b) obj;
        if (bVar == null || (cVar = bVar.f430600f) == null || (str = cVar.f430604h) == null) {
            str = "";
        }
        boolean updateAvatarDressBorderUrl = userSelfInfo.updateAvatarDressBorderUrl(str);
        boolean z26 = eVar.R;
        if (userSelfInfo.likesOnlySelf != z26) {
            userSelfInfo.likesOnlySelf = z26;
        } else {
            z19 = false;
        }
        if (z16 || updateAvatar || z17 || z18 || updateAvatarDressBorderUrl || z19) {
            INSTANCE.saveUserSelfInfo();
        }
    }
}
