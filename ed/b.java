package ed;

import com.google.gson.Gson;
import com.qzone.reborn.util.QZoneGsonUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import ef.d;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\tH\u0016J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000bH\u0016J \u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\rH\u0016J-\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\n\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Led/b;", "Led/a;", "", "mainKey", "secondKey", RemoteHandleConst.PARAM_DEFAULT_VALUE, "a", "", "b", "", "getConfig", "", "c", "", "d", "T", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements a {
    @Override // ed.a
    public String a(String mainKey, String secondKey, String defaultValue) {
        Intrinsics.checkNotNullParameter(mainKey, "mainKey");
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(secondKey, defaultValue);
    }

    @Override // ed.a
    public boolean b(String mainKey, String secondKey, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(mainKey, "mainKey");
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(secondKey, defaultValue);
    }

    @Override // ed.a
    public long c(String mainKey, String secondKey, long defaultValue) {
        Intrinsics.checkNotNullParameter(mainKey, "mainKey");
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        return d.l(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(secondKey, ""), defaultValue);
    }

    @Override // ed.a
    public float d(String mainKey, String secondKey, float defaultValue) {
        Intrinsics.checkNotNullParameter(mainKey, "mainKey");
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        return d.h(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(secondKey, ""), defaultValue);
    }

    @Override // ed.a
    public int getConfig(String mainKey, String secondKey, int defaultValue) {
        Intrinsics.checkNotNullParameter(mainKey, "mainKey");
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        return d.j(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(secondKey, ""), defaultValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ed.a
    public <T> T getConfig(String mainKey, String secondKey, T defaultValue) {
        byte[] bArr;
        Object obj;
        Intrinsics.checkNotNullParameter(mainKey, "mainKey");
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        try {
            bArr = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(secondKey, new byte[0]);
        } catch (Throwable unused) {
            bArr = null;
        }
        if (bArr == null) {
            return defaultValue;
        }
        if (bArr.length == 0) {
            return defaultValue;
        }
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(bArr, UTF_8);
        try {
            if (defaultValue instanceof Integer) {
                obj = Integer.valueOf(Integer.parseInt(str));
            } else if (defaultValue instanceof Long) {
                obj = Long.valueOf(Long.parseLong(str));
            } else if (defaultValue instanceof Boolean) {
                obj = Boolean.valueOf(Boolean.parseBoolean(str));
            } else {
                Gson a16 = QZoneGsonUtil.f59533a.a();
                Intrinsics.checkNotNull(defaultValue);
                obj = a16.fromJson(str, (Class<Object>) defaultValue.getClass());
            }
            return obj;
        } catch (Throwable unused2) {
            return defaultValue;
        }
    }
}
