package com.tencent.mobileqq.webview.util;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0017B\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u00a2\u0006\u0004\b \u0010!J%\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J'\u0010\t\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\f\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J(\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rH\u0016J \u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0000H\u0016J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0000H\u0016J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/webview/util/t;", "Lcom/tencent/biz/j;", "T", "", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "b", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "value", "o", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mobileqq/webview/util/t;", "c", "p", "", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "f", "l", tl.h.F, "g", "", "i", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "a", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "getEntity", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "Ljava/lang/String;", "getBusiness", "()Ljava/lang/String;", "business", "<init>", "(Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;Ljava/lang/String;)V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class t implements com.tencent.biz.j {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MMKVOptionEntity entity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String business;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/webview/util/t$a;", "", "", "file", "business", "Lcom/tencent/mobileqq/webview/util/t;", "c", "b", "a", "", "LOG_SWITCH", "Z", "TAG", "Ljava/lang/String;", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.webview.util.t$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        @NotNull
        public final t a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (t) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_WEB);
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ,\u2026ewConstant.WEB_MMKV_FILE)");
            return new t(from, null, 2, 0 == true ? 1 : 0);
        }

        @JvmStatic
        @NotNull
        public final t b(@NotNull String business) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (t) iPatchRedirector.redirect((short) 3, (Object) this, (Object) business);
            }
            Intrinsics.checkNotNullParameter(business, "business");
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_WEB);
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ,\u2026ewConstant.WEB_MMKV_FILE)");
            return new t(from, business);
        }

        @JvmStatic
        @NotNull
        public final t c(@NotNull String file, @NotNull String business) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (t) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) business);
            }
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(business, "business");
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, file);
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, file)");
            return new t(from, business);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46186);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public t(@NotNull MMKVOptionEntity entity, @NotNull String business) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(business, "business");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) entity, (Object) business);
        } else {
            this.entity = entity;
            this.business = business;
        }
    }

    @JvmStatic
    @NotNull
    public static final t j() {
        return INSTANCE.a();
    }

    @JvmStatic
    @NotNull
    public static final t m(@NotNull String str) {
        return INSTANCE.b(str);
    }

    @JvmStatic
    @NotNull
    public static final t n(@NotNull String str, @NotNull String str2) {
        return INSTANCE.c(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.j
    public <T> T b(@NotNull String key, T defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, (Object) this, (Object) key, (Object) defaultValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        String str = this.business + key;
        if (defaultValue instanceof Boolean) {
            return (T) Boolean.valueOf(this.entity.decodeBool(str, ((Boolean) defaultValue).booleanValue()));
        }
        if (defaultValue instanceof Long) {
            return (T) Long.valueOf(this.entity.decodeLong(str, ((Number) defaultValue).longValue()));
        }
        if (defaultValue instanceof Integer) {
            return (T) Integer.valueOf(this.entity.decodeInt(str, ((Number) defaultValue).intValue()));
        }
        if (defaultValue instanceof Float) {
            return (T) Float.valueOf(this.entity.decodeFloat(str, ((Number) defaultValue).floatValue()));
        }
        if (defaultValue instanceof Double) {
            return (T) Double.valueOf(this.entity.decodeDouble(str, ((Number) defaultValue).doubleValue()));
        }
        QLog.w("WebPref", 1, "read key {" + str + "} error: unsupported valueType {" + defaultValue + "} !!!");
        return defaultValue;
    }

    @Override // com.tencent.biz.j
    @Nullable
    public String c(@NotNull String key, @Nullable String defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) key, (Object) defaultValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.entity.decodeString(this.business + key, defaultValue);
    }

    @NotNull
    public t f() {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (t) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        String[] allKeyArr = this.entity.allKeyArr();
        if (allKeyArr != null) {
            for (String str : allKeyArr) {
                if (str != null) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, this.business, false, 2, null);
                    if (startsWith$default) {
                        this.entity.removeKey(str);
                    }
                }
            }
        }
        return this;
    }

    @NotNull
    public t g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (t) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        this.entity.commitAsync();
        return this;
    }

    @Override // com.tencent.biz.j
    @NotNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public t a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (t) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        this.entity.commitSync();
        return this;
    }

    public boolean i(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) key)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.entity.containsKey(this.business + key);
    }

    @Nullable
    public Set<String> k(@NotNull String key, @Nullable Set<String> defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Set) iPatchRedirector.redirect((short) 9, (Object) this, (Object) key, (Object) defaultValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.entity.decodeStringSet(this.business + key, defaultValue);
    }

    @NotNull
    public t l(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (t) iPatchRedirector.redirect((short) 12, (Object) this, (Object) key);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        this.entity.removeKey(this.business + key);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.j
    @NotNull
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public <T> t d(@NotNull String key, @Nullable T value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (t) iPatchRedirector.redirect((short) 6, (Object) this, (Object) key, (Object) value);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        String str = this.business + key;
        if (value == 0) {
            this.entity.removeKey(str);
        }
        if (value instanceof Boolean) {
            this.entity.encodeBool(str, ((Boolean) value).booleanValue());
        } else if (value instanceof Long) {
            this.entity.encodeLong(str, ((Number) value).longValue());
        } else if (value instanceof Integer) {
            this.entity.encodeInt(str, ((Number) value).intValue());
        } else if (value instanceof Float) {
            this.entity.encodeFloat(str, ((Number) value).floatValue());
        } else if (value instanceof Double) {
            this.entity.encodeDouble(str, ((Number) value).doubleValue());
        } else {
            QLog.w("WebPref", 1, "write key {" + str + "} error: unsupported valueType {" + value + "} !!!");
        }
        return this;
    }

    @Override // com.tencent.biz.j
    @NotNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public t e(@NotNull String key, @Nullable String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (t) iPatchRedirector.redirect((short) 8, (Object) this, (Object) key, (Object) value);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        String str = this.business + key;
        if (value != null) {
            this.entity.encodeString(str, value);
        } else {
            this.entity.removeKey(str);
        }
        return this;
    }

    @NotNull
    public t q(@NotNull String key, @Nullable Set<String> value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (t) iPatchRedirector.redirect((short) 10, (Object) this, (Object) key, (Object) value);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        String str = this.business + key;
        if (value != null) {
            this.entity.encodeStringSet(str, value);
        } else {
            this.entity.removeKey(str);
        }
        return this;
    }

    public /* synthetic */ t(MMKVOptionEntity mMKVOptionEntity, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(mMKVOptionEntity, (i3 & 2) != 0 ? "busi_default_" : str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, mMKVOptionEntity, str, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
