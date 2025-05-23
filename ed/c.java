package ed;

import com.google.gson.Gson;
import com.qzone.reborn.util.QZoneGsonUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\tH\u0016J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000bH\u0016J \u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\rH\u0016J-\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\n\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Led/c;", "Led/a;", "", "mainKey", "secondKey", RemoteHandleConst.PARAM_DEFAULT_VALUE, "a", "", "b", "", "getConfig", "", "c", "", "d", "T", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c implements a {
    @Override // ed.a
    public String a(String mainKey, String secondKey, String defaultValue) {
        Intrinsics.checkNotNullParameter(mainKey, "mainKey");
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String config = QzoneConfig.getInstance().getConfig(mainKey, secondKey, defaultValue);
        Intrinsics.checkNotNullExpressionValue(config, "getInstance().getConfig(\u2026 secondKey, defaultValue)");
        return config;
    }

    @Override // ed.a
    public boolean b(String mainKey, String secondKey, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(mainKey, "mainKey");
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        return QzoneConfig.getInstance().getConfig(mainKey, secondKey, defaultValue);
    }

    @Override // ed.a
    public long c(String mainKey, String secondKey, long defaultValue) {
        Intrinsics.checkNotNullParameter(mainKey, "mainKey");
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        return QzoneConfig.getInstance().getConfig(mainKey, secondKey, defaultValue);
    }

    @Override // ed.a
    public float d(String mainKey, String secondKey, float defaultValue) {
        Intrinsics.checkNotNullParameter(mainKey, "mainKey");
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        return QzoneConfig.getInstance().getConfig(mainKey, secondKey, defaultValue);
    }

    @Override // ed.a
    public int getConfig(String mainKey, String secondKey, int defaultValue) {
        Intrinsics.checkNotNullParameter(mainKey, "mainKey");
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        return QzoneConfig.getInstance().getConfig(mainKey, secondKey, defaultValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ed.a
    public <T> T getConfig(String mainKey, String secondKey, T defaultValue) {
        String str;
        Object obj;
        Intrinsics.checkNotNullParameter(mainKey, "mainKey");
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        try {
            str = QzoneConfig.getInstance().getConfig(mainKey, secondKey, "");
        } catch (Throwable unused) {
            str = null;
        }
        if (str == null || str.length() == 0) {
            return defaultValue;
        }
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
