package com.tencent.mobileqq.tianjige.ntkernel;

import android.text.TextUtils;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\n\u0006B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/tianjige/ntkernel/NtMetricParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/tianjige/ntkernel/NtMetricParser$b;", "", "content", "c", "b", "<init>", "()V", "d", "a", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NtMetricParser extends BaseConfigParser<b> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/tianjige/ntkernel/NtMetricParser$a;", "", "", "GROUP", "Ljava/lang/String;", "TAG", "<init>", "()V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tianjige.ntkernel.NtMetricParser$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0006\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/tianjige/ntkernel/NtMetricParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "", "d", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "sampleRate", "e", "D", "a", "()D", "defaultMetricRate", "<init>", "(Ljava/util/Map;D)V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final /* data */ class b implements IConfigData {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Map<String, Double> sampleRate;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final double defaultMetricRate;

        public b(@NotNull Map<String, Double> sampleRate, double d16) {
            Intrinsics.checkNotNullParameter(sampleRate, "sampleRate");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, sampleRate, Double.valueOf(d16));
            } else {
                this.sampleRate = sampleRate;
                this.defaultMetricRate = d16;
            }
        }

        public final double a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Double) iPatchRedirector.redirect((short) 4, (Object) this)).doubleValue();
            }
            return this.defaultMetricRate;
        }

        @NotNull
        public final Map<String, Double> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.sampleRate;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.sampleRate, bVar.sampleRate) && Double.compare(this.defaultMetricRate, bVar.defaultMetricRate) == 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return (this.sampleRate.hashCode() * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.defaultMetricRate);
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "MetricConfig(sampleRate=" + this.sampleRate + ", defaultMetricRate=" + this.defaultMetricRate + ")";
        }

        public /* synthetic */ b(Map map, double d16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(map, (i3 & 2) != 0 ? 1.0d : d16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, map, Double.valueOf(d16), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34623);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NtMetricParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        Map emptyMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return new b(emptyMap, 0.0d, 2, null);
        }
        return (b) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b parse(@NotNull byte[] content) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) content);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str2 = new String(content, UTF_8);
        if (TextUtils.isEmpty(str2)) {
            return defaultConfig();
        }
        try {
            HashMap hashMap = new HashMap();
            JSONObject optJSONObject = new JSONObject(str2).optJSONObject("Metrics");
            if (optJSONObject == null) {
                return defaultConfig();
            }
            Iterator keys = optJSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "metricJSONObject.keys()");
            double d16 = 1.0d;
            while (keys.hasNext()) {
                Object next = keys.next();
                if (next instanceof String) {
                    str = (String) next;
                } else {
                    str = null;
                }
                if (str != null) {
                    double d17 = optJSONObject.getDouble(str);
                    if (str.equals("default")) {
                        d16 = d17;
                    } else {
                        hashMap.put(str, Double.valueOf(d17));
                    }
                }
            }
            b bVar = new b(hashMap, d16);
            QLog.d("NtMsgFilterParser", 1, "parse success config=" + bVar);
            return bVar;
        } catch (Exception e16) {
            QLog.d("NtMsgFilterParser", 1, "parse error", e16);
            return defaultConfig();
        }
    }
}
