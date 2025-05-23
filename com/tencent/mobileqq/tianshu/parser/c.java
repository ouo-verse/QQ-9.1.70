package com.tencent.mobileqq.tianshu.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R2\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/tianshu/parser/c;", "Lcom/tencent/freesia/IConfigData;", "", "configStr", "", "b", "", "Lcom/tencent/mobileqq/tianshu/parser/d;", "d", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "setConfigs", "(Ljava/util/Map;)V", Constants.Configs.CONFIGS, "Lcom/google/gson/Gson;", "e", "Lcom/google/gson/Gson;", "gson", "<init>", "()V", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Map<String, d> configs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Gson gson;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/tianshu/parser/c$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a extends TypeToken<Map<String, String>> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.gson = new Gson();
        }
    }

    @Nullable
    public final Map<String, d> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.configs;
    }

    public final void b(@NotNull String configStr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) configStr);
            return;
        }
        Intrinsics.checkNotNullParameter(configStr, "configStr");
        this.configs = new LinkedHashMap();
        try {
            Type type = new a().getType();
            Intrinsics.checkNotNullExpressionValue(type, "object : TypeToken<Mutab\u2026tring, String>>() {}.type");
            Object fromJson = this.gson.fromJson(configStr, type);
            Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(configStr, outerMapType)");
            for (Map.Entry entry : ((Map) fromJson).entrySet()) {
                String str = (String) entry.getKey();
                try {
                    Object fromJson2 = this.gson.fromJson((String) entry.getValue(), (Class<Object>) d.class);
                    Intrinsics.checkNotNullExpressionValue(fromJson2, "gson.fromJson(value, TimeConfig::class.java)");
                    Map<String, d> map = this.configs;
                    Intrinsics.checkNotNull(map);
                    map.put(str, (d) fromJson2);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        } catch (Exception unused) {
        }
    }
}
