package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/search/util/p;", "", "Lbp2/a;", "b", "", "from", "", "d", "Lap2/b;", "a", "Lap2/g;", "c", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p f285069a = new p();

    p() {
    }

    private final bp2.a b() {
        bp2.a aVar = (bp2.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100521");
        if (aVar == null || !aVar.e()) {
            return (bp2.a) com.tencent.mobileqq.config.am.s().x(434);
        }
        return aVar;
    }

    @Nullable
    public final ap2.b a() {
        return (ap2.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("qq_search_audio_ai_config");
    }

    @Nullable
    public final ap2.g c() {
        ap2.b a16 = a();
        if (a16 != null) {
            return a16.getThirdAppConfig();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean d(int from) {
        boolean z16;
        bp2.a b16 = b();
        if (b16 != null) {
            if (from != 1) {
                if (from != 2) {
                    if (from == 21) {
                        z16 = b16.c();
                    }
                } else {
                    z16 = b16.b();
                }
            } else {
                z16 = b16.d();
            }
            if (QLog.isColorLevel()) {
                QLog.d("QSearchConfigUtil", 2, "isBusinessSwitchOn. " + z16);
            }
            return z16;
        }
        z16 = false;
        if (QLog.isColorLevel()) {
        }
        return z16;
    }
}
