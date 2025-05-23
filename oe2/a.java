package oe2;

import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqecommerce.base.runtime.ECRuntimeManager;
import cooperation.qzone.panorama.util.PanoramaConfig;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J!\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016J/\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ)\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00172\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\u001f\u001a\u00020\t\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00028\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u001f\u0010 J)\u0010!\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b!\u0010\"J)\u0010#\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b#\u0010$J)\u0010%\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b%\u0010&J)\u0010'\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00172\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b'\u0010(J)\u0010)\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010,R\u0014\u00100\u001a\u00020\u00178BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Loe2/a;", "Lcom/tencent/ecommerce/base/config/api/IECLocalConfig;", "", "key", "a", "", "accountScoped", "contains", "(Ljava/lang/String;Ljava/lang/Boolean;)Z", "", HippyQQPagView.FunctionName.FLUSH, "T", RemoteHandleConst.PARAM_DEFAULT_VALUE, "get", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Boolean;)Ljava/lang/Object;", "getBoolean", "(Ljava/lang/String;ZLjava/lang/Boolean;)Z", "", "getFloat", "(Ljava/lang/String;FLjava/lang/Boolean;)F", "", "getInt", "(Ljava/lang/String;ILjava/lang/Boolean;)I", "", "getLong", "(Ljava/lang/String;JLjava/lang/Boolean;)J", "getString", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/String;", "remove", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "value", "set", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Boolean;)V", "setBoolean", "(Ljava/lang/String;ZLjava/lang/Boolean;)V", QZoneJsConstants.QZonePersonalizeJsConstants.FLOAT_METHOD_SETFLOAT, "(Ljava/lang/String;FLjava/lang/Boolean;)V", "setInt", "(Ljava/lang/String;ILjava/lang/Boolean;)V", "setLong", "(Ljava/lang/String;JLjava/lang/Boolean;)V", "setString", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "b", "()J", PanoramaConfig.KEY_CURRENT_UIN, "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements IECLocalConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MMKVOptionEntity entity;

    public a() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_KANDIAN);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_KANDIAN)");
        this.entity = from;
    }

    private final String a(String key) {
        return key + "_" + b();
    }

    private final long b() {
        return ECRuntimeManager.INSTANCE.e();
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public boolean contains(String key, Boolean accountScoped) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(accountScoped, Boolean.TRUE)) {
            key = a(key);
        }
        return this.entity.containsKey(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public <T> T get(String key, T defaultValue, Boolean accountScoped) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (defaultValue instanceof Long) {
            return (T) Long.valueOf(getLong(key, ((Number) defaultValue).longValue(), accountScoped));
        }
        if (defaultValue instanceof Float) {
            return (T) Float.valueOf(getFloat(key, ((Number) defaultValue).floatValue(), accountScoped));
        }
        if (defaultValue instanceof Integer) {
            return (T) Integer.valueOf(getInt(key, ((Number) defaultValue).intValue(), accountScoped));
        }
        if (defaultValue instanceof Boolean) {
            return (T) Boolean.valueOf(getBoolean(key, ((Boolean) defaultValue).booleanValue(), accountScoped));
        }
        if (defaultValue instanceof String) {
            return (T) getString(key, (String) defaultValue, accountScoped);
        }
        throw new IllegalArgumentException("\u53ea\u652f\u6301\u57fa\u7840\u7c7b\u578b");
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public boolean getBoolean(String key, boolean defaultValue, Boolean accountScoped) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(accountScoped, Boolean.TRUE)) {
            key = a(key);
        }
        return this.entity.decodeBool(key, defaultValue);
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public float getFloat(String key, float defaultValue, Boolean accountScoped) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(accountScoped, Boolean.TRUE)) {
            key = a(key);
        }
        return this.entity.decodeFloat(key, defaultValue);
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public int getInt(String key, int defaultValue, Boolean accountScoped) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(accountScoped, Boolean.TRUE)) {
            key = a(key);
        }
        return this.entity.decodeInt(key, defaultValue);
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public long getLong(String key, long defaultValue, Boolean accountScoped) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(accountScoped, Boolean.TRUE)) {
            key = a(key);
        }
        return this.entity.decodeLong(key, defaultValue);
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public String getString(String key, String defaultValue, Boolean accountScoped) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (Intrinsics.areEqual(accountScoped, Boolean.TRUE)) {
            key = a(key);
        }
        String decodeString = this.entity.decodeString(key, defaultValue);
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(finalKey, defaultValue)");
        return decodeString;
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public void remove(String key, Boolean accountScoped) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(accountScoped, Boolean.TRUE)) {
            key = a(key);
        }
        this.entity.removeKey(key);
        this.entity.commitAsync();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public <T> void set(String key, T value, Boolean accountScoped) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (value instanceof Long) {
            setLong(key, ((Number) value).longValue(), accountScoped);
            return;
        }
        if (value instanceof Float) {
            setFloat(key, ((Number) value).floatValue(), accountScoped);
            return;
        }
        if (value instanceof Integer) {
            setInt(key, ((Number) value).intValue(), accountScoped);
            return;
        }
        if (value instanceof Boolean) {
            setBoolean(key, ((Boolean) value).booleanValue(), accountScoped);
        } else {
            if (value instanceof String) {
                setString(key, (String) value, accountScoped);
                return;
            }
            throw new IllegalArgumentException("\u53ea\u652f\u6301\u57fa\u7840\u7c7b\u578b, value:" + value);
        }
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public void setBoolean(String key, boolean value, Boolean accountScoped) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(accountScoped, Boolean.TRUE)) {
            key = a(key);
        }
        this.entity.encodeBool(key, value);
        this.entity.commitAsync();
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public void setFloat(String key, float value, Boolean accountScoped) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(accountScoped, Boolean.TRUE)) {
            key = a(key);
        }
        this.entity.encodeFloat(key, value);
        this.entity.commitAsync();
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public void setInt(String key, int value, Boolean accountScoped) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(accountScoped, Boolean.TRUE)) {
            key = a(key);
        }
        this.entity.encodeInt(key, value);
        this.entity.commitAsync();
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public void setLong(String key, long value, Boolean accountScoped) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(accountScoped, Boolean.TRUE)) {
            key = a(key);
        }
        this.entity.encodeLong(key, value);
        this.entity.commitAsync();
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public void setString(String key, String value, Boolean accountScoped) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(accountScoped, Boolean.TRUE)) {
            key = a(key);
        }
        this.entity.encodeString(key, value);
        this.entity.commitAsync();
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public void flush() {
    }
}
