package com.tencent.mobileqq.zplan.cloudmod.api;

import android.content.Context;
import com.tencent.mobileqq.z1.cloudmod.api.ZPlanCloudGameInfo;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001Ja\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2%\b\u0002\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fH&J0\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH&\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/cloudmod/api/a;", "Lvb3/b;", "", "modId", "", "needServerFullCheck", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "", "", "ueParams", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "Lkotlin/ParameterName;", "name", "checkResult", "", "callback", "T", "Lcom/tencent/mobileqq/z1/cloudmod/api/ZPlanCloudGameInfo;", "cloudGameInfo", "mapId", "modStatus", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zplan/cloudmod/api/b;", "listener", "S0", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface a extends vb3.b {
    void S0(ZPlanCloudGameInfo cloudGameInfo, int mapId, int modStatus, Context context, b listener);

    void T(int modId, boolean needServerFullCheck, ZootopiaSource source, Map<String, ? extends Object> ueParams, Function1<? super EnterModCheckResult, Unit> callback);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.zplan.cloudmod.api.a$a, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C9161a {
        public static /* synthetic */ void a(a aVar, int i3, boolean z16, ZootopiaSource zootopiaSource, Map map, Function1 function1, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    z16 = true;
                }
                aVar.T(i3, z16, zootopiaSource, (i16 & 8) != 0 ? null : map, (i16 & 16) != 0 ? null : function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startCloudMod");
        }
    }
}
