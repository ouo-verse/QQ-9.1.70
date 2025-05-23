package com.tencent.mobileqq.qwallet.hb.send.model;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qk2.HbRecommendConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/send/model/c;", "", "", "Lqk2/f$a;", "b", "confItem", "", WadlProxyConsts.CHANNEL, "", "a", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f277775a = new c();

    c() {
    }

    @JvmStatic
    public static final boolean a(@NotNull HbRecommendConfig.RecommendItem confItem, int channel) {
        boolean z16;
        Intrinsics.checkNotNullParameter(confItem, "confItem");
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        long k3 = com.tencent.mobileqq.qwallet.impl.d.k(confItem.getBeginTime(), -1L);
        long k16 = com.tencent.mobileqq.qwallet.impl.d.k(confItem.getEndTime(), Long.MAX_VALUE);
        if (serverTimeMillis >= k3 && serverTimeMillis <= k16) {
            String text = confItem.getText();
            if (text != null && text.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && text.length() <= 16) {
                if (channel == 32 && (confItem.getFlag() & 1) == 0) {
                    return false;
                }
                if (channel == 65536 && (confItem.getFlag() & 2) == 0) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x001e, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r0);
     */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<HbRecommendConfig.RecommendItem> b() {
        List<HbRecommendConfig.RecommendItem> filterNotNull;
        ArrayList<HbRecommendConfig.RecommendItem> a16 = ((HbRecommendConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig("qwallet_hb_recommend_config", new HbRecommendConfig(null, 1, null))).a();
        if (a16 == null || filterNotNull == null) {
            return new ArrayList();
        }
        return filterNotNull;
    }
}
