package com.tencent.ecommerce.base.config.api;

import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH&J/\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u0002H\u000b2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010\rJ)\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010\u000fJ)\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00112\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010\u0012J)\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00142\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010\u0015J)\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00172\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010\u0018J)\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010\u001aJ!\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010\u001cJ/\u0010\u001d\u001a\u00020\t\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u0002H\u000b2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010\u001fJ)\u0010 \u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010!J)\u0010\"\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00112\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010#J)\u0010$\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00142\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010%J)\u0010&\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00172\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010'J)\u0010(\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010)\u00a8\u0006*"}, d2 = {"Lcom/tencent/ecommerce/base/config/api/IECLocalConfig;", "", "contains", "", "key", "", "accountScoped", "(Ljava/lang/String;Ljava/lang/Boolean;)Z", HippyQQPagView.FunctionName.FLUSH, "", "get", "T", RemoteHandleConst.PARAM_DEFAULT_VALUE, "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Boolean;)Ljava/lang/Object;", "getBoolean", "(Ljava/lang/String;ZLjava/lang/Boolean;)Z", "getFloat", "", "(Ljava/lang/String;FLjava/lang/Boolean;)F", "getInt", "", "(Ljava/lang/String;ILjava/lang/Boolean;)I", "getLong", "", "(Ljava/lang/String;JLjava/lang/Boolean;)J", "getString", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/String;", "remove", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "set", "value", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Boolean;)V", "setBoolean", "(Ljava/lang/String;ZLjava/lang/Boolean;)V", QZoneJsConstants.QZonePersonalizeJsConstants.FLOAT_METHOD_SETFLOAT, "(Ljava/lang/String;FLjava/lang/Boolean;)V", "setInt", "(Ljava/lang/String;ILjava/lang/Boolean;)V", "setLong", "(Ljava/lang/String;JLjava/lang/Boolean;)V", "setString", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECLocalConfig {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ boolean a(IECLocalConfig iECLocalConfig, String str, Boolean bool, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    bool = null;
                }
                return iECLocalConfig.contains(str, bool);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: contains");
        }

        public static /* synthetic */ Object b(IECLocalConfig iECLocalConfig, String str, Object obj, Boolean bool, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 4) != 0) {
                    bool = null;
                }
                return iECLocalConfig.get(str, obj, bool);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
        }

        public static /* synthetic */ boolean c(IECLocalConfig iECLocalConfig, String str, boolean z16, Boolean bool, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bool = null;
                }
                return iECLocalConfig.getBoolean(str, z16, bool);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBoolean");
        }

        public static /* synthetic */ int d(IECLocalConfig iECLocalConfig, String str, int i3, Boolean bool, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    bool = null;
                }
                return iECLocalConfig.getInt(str, i3, bool);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInt");
        }

        public static /* synthetic */ long e(IECLocalConfig iECLocalConfig, String str, long j3, Boolean bool, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bool = null;
                }
                return iECLocalConfig.getLong(str, j3, bool);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLong");
        }

        public static /* synthetic */ String f(IECLocalConfig iECLocalConfig, String str, String str2, Boolean bool, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bool = null;
                }
                return iECLocalConfig.getString(str, str2, bool);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getString");
        }

        public static /* synthetic */ void g(IECLocalConfig iECLocalConfig, String str, Object obj, Boolean bool, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 4) != 0) {
                    bool = null;
                }
                iECLocalConfig.set(str, obj, bool);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: set");
        }

        public static /* synthetic */ void h(IECLocalConfig iECLocalConfig, String str, boolean z16, Boolean bool, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bool = null;
                }
                iECLocalConfig.setBoolean(str, z16, bool);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBoolean");
        }

        public static /* synthetic */ void i(IECLocalConfig iECLocalConfig, String str, long j3, Boolean bool, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bool = null;
                }
                iECLocalConfig.setLong(str, j3, bool);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLong");
        }

        public static /* synthetic */ void j(IECLocalConfig iECLocalConfig, String str, String str2, Boolean bool, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bool = null;
                }
                iECLocalConfig.setString(str, str2, bool);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setString");
        }
    }

    boolean contains(@NotNull String key, @Nullable Boolean accountScoped);

    void flush();

    <T> T get(@NotNull String key, T defaultValue, @Nullable Boolean accountScoped);

    boolean getBoolean(@NotNull String key, boolean defaultValue, @Nullable Boolean accountScoped);

    float getFloat(@NotNull String key, float defaultValue, @Nullable Boolean accountScoped);

    int getInt(@NotNull String key, int defaultValue, @Nullable Boolean accountScoped);

    long getLong(@NotNull String key, long defaultValue, @Nullable Boolean accountScoped);

    @NotNull
    String getString(@NotNull String key, @NotNull String defaultValue, @Nullable Boolean accountScoped);

    void remove(@NotNull String key, @Nullable Boolean accountScoped);

    <T> void set(@NotNull String key, T value, @Nullable Boolean accountScoped);

    void setBoolean(@NotNull String key, boolean value, @Nullable Boolean accountScoped);

    void setFloat(@NotNull String key, float value, @Nullable Boolean accountScoped);

    void setInt(@NotNull String key, int value, @Nullable Boolean accountScoped);

    void setLong(@NotNull String key, long value, @Nullable Boolean accountScoped);

    void setString(@NotNull String key, @NotNull String value, @Nullable Boolean accountScoped);
}
