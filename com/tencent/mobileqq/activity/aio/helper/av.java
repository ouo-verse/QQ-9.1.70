package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import androidx.collection.LruCache;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\bH\u0016R\u0016\u0010\u0017\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/helper/av;", "Lcom/tencent/aio/main/businesshelper/h;", "", "g", "c", "i", "", "e", "", "switchValue", "b", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Ljava/lang/String;", "troopUin", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "<init>", "()V", "f", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class av implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final LruCache<String, String> f178813h = new LruCache<>(100);

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static String f178814i = "";

    /* renamed from: m, reason: collision with root package name */
    private static int f178815m = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    private final boolean b(int switchValue) {
        if (switchValue == 1) {
            return true;
        }
        return false;
    }

    private final void c() {
        if (e()) {
            QLog.w("TroopMemberNickIconHelper", 1, "[handleGetTroopMemberAioIconList] switch limit. stop request 0x787");
            return;
        }
        ITroopInfoService iTroopInfoService = (ITroopInfoService) TroopUtils.f().getRuntimeService(ITroopInfoService.class, "");
        String str = this.troopUin;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUin");
            str = null;
        }
        TroopInfo troopInfo = iTroopInfoService.getTroopInfo(str);
        long j3 = troopInfo.mMemberNickIconSeq;
        if (j3 <= troopInfo.extDBInfo.oldMemberNickIconSeq && j3 > 0) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopMemberNickIconHelper", 1, "[handleGetTroopMemberAioIconList] ignores. newSeq:" + troopInfo.mMemberNickIconSeq + ", oldSeq:" + troopInfo.extDBInfo.oldMemberNickIconSeq);
                return;
            }
            return;
        }
        LruCache<String, String> lruCache = f178813h;
        String str3 = this.troopUin;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUin");
            str3 = null;
        }
        lruCache.put(str3, "");
        ITroopMemberExtInfoRepoApi iTroopMemberExtInfoRepoApi = (ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class);
        String str4 = this.troopUin;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUin");
        } else {
            str2 = str4;
        }
        iTroopMemberExtInfoRepoApi.fetchTroopMemberNickIconInfo(str2, new ArrayList());
    }

    private final boolean e() {
        boolean z16;
        int i3;
        if (Intrinsics.areEqual(f178814i, TroopUtils.f().getCurrentUin()) && (i3 = f178815m) >= 0) {
            return b(i3);
        }
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("101976", new byte[0]);
        if (loadRawConfig.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(loadRawConfig, UTF_8);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            f178815m = new JSONObject(str).optInt("protocol_switch", 0);
            String currentUin = TroopUtils.f().getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "getAppInterface().currentUin");
            f178814i = currentUin;
            return b(f178815m);
        } catch (JSONException e16) {
            QLog.e("TroopMemberNickIconHelper", 1, "[isFreqLimit] exception: " + e16);
            return false;
        }
    }

    private final void g() {
        QLog.d("TroopMemberNickIconHelper", 4, "[onLifeCycleCreate] ");
        if (TroopUtils.f() == null) {
            QLog.w("TroopMemberNickIconHelper", 1, "[onLifeCycleCreate] appinterface is null. ignored");
            return;
        }
        LruCache<String, String> lruCache = f178813h;
        String str = this.troopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUin");
            str = null;
        }
        if (lruCache.get(str) != null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.au
            @Override // java.lang.Runnable
            public final void run() {
                av.h(av.this);
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(av this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c();
    }

    private final void i() {
        QLog.d("TroopMemberNickIconHelper", 4, "[onLifeCycleDestroy] ");
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350672s1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "TroopMemberNickIconHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.aioContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            a16 = null;
        }
        this.troopUin = a16.g().r().c().j();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 0) {
            if (state == 12) {
                i();
                return;
            }
            return;
        }
        g();
    }
}
