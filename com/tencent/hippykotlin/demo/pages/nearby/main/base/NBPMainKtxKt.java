package com.tencent.hippykotlin.demo.pages.nearby.main.base;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import defpackage.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPMainKtxKt {
    public static Boolean isBoxShadowInBlackSet;

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void boxShadowWithBlackSet$default(Attr attr, g gVar) {
        boolean z16;
        c cVar = c.f117352a;
        if (k.a(cVar)) {
            if (isBoxShadowInBlackSet == null) {
                isBoxShadowInBlackSet = Boolean.valueOf(NearbyConst.androidShadowBlackSet.contains(((QQKuiklyPlatformApi) cVar.g().acquireModule("QQKuiklyPlatformApi")).getDeviceInfo().model));
            }
            if (Intrinsics.areEqual(isBoxShadowInBlackSet, Boolean.TRUE)) {
                z16 = false;
                if (z16) {
                    return;
                }
                attr.boxShadow(gVar, false);
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    public static final String getJumpScheme(com.tencent.kuikly.core.pager.g gVar) {
        return Utils.INSTANCE.currentBridgeModule().urlDecode(gVar.n().p("key_scheme"));
    }

    public static final NBPViewModelStore getNbpVMStore(b bVar) {
        Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager");
        return ((NBPMainPager) bVar).getVmStore();
    }

    public static final com.tencent.kuikly.core.pager.g getPageData() {
        return c.f117352a.g().getPageData();
    }

    public static final String getPeerUid(com.tencent.kuikly.core.pager.g gVar) {
        String str;
        boolean isIOS = gVar.getIsIOS();
        e n3 = gVar.n();
        if (isIOS) {
            str = "key_peerid";
        } else {
            str = "key_peerId";
        }
        return n3.p(str);
    }

    public static final NBPViewModelStore getVmStore() {
        return getNbpVMStore(c.f117352a.g());
    }
}
