package com.tencent.qmethod.monitor.ext.traffic;

import com.tencent.qmethod.pandoraex.core.ext.netcap.m;
import com.tencent.qmethod.pandoraex.core.ext.netcap.n;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/traffic/h;", "", "", "buffer", "Lorg/json/JSONObject;", "a", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f343733a = new h();

    h() {
    }

    @NotNull
    public final JSONObject a(@Nullable byte[] buffer) {
        Object valueOf;
        m a16 = m.a(buffer);
        JSONObject jSONObject = new JSONObject();
        while (true) {
            try {
                int i3 = a16.i();
                if (i3 == 0) {
                    return jSONObject;
                }
                int a17 = n.a(i3);
                int b16 = n.b(i3);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(a17);
                sb5.append('-');
                sb5.append(b16);
                sb5.append('-');
                sb5.append(i3);
                String sb6 = sb5.toString();
                if (b16 != 0) {
                    if (b16 != 1) {
                        if (b16 != 2) {
                            if (b16 != 3) {
                                if (b16 == 5) {
                                    valueOf = String.valueOf(a16.d());
                                } else {
                                    valueOf = null;
                                }
                            } else {
                                valueOf = a16.g(a16.f()).toString();
                            }
                        } else {
                            int f16 = a16.f();
                            if (f16 > 0) {
                                byte[] value = a16.g(f16);
                                byte b17 = value[0];
                                int a18 = n.a(b17);
                                int b18 = n.b(b17);
                                if (a18 > 1 && b18 != 2) {
                                    Intrinsics.checkExpressionValueIsNotNull(value, "value");
                                    jSONObject.put(sb6, new String(value, Charsets.UTF_8));
                                } else {
                                    valueOf = a(value);
                                    if (valueOf == null) {
                                        valueOf = value.toString();
                                    }
                                }
                            }
                            valueOf = null;
                        }
                    } else {
                        valueOf = String.valueOf(a16.e());
                    }
                } else {
                    valueOf = Long.valueOf(a16.h());
                }
                if (valueOf != null) {
                    Object opt = jSONObject.opt(sb6);
                    if (opt == null) {
                        jSONObject.put(sb6, valueOf);
                    } else if (opt instanceof JSONArray) {
                        ((JSONArray) opt).mo162put(valueOf);
                    } else {
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.mo162put(valueOf);
                        jSONObject.put(sb6, jSONArray);
                    }
                }
            } catch (IOException e16) {
                throw new RuntimeException(e16);
            }
        }
    }
}
