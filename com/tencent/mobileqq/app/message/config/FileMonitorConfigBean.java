package com.tencent.mobileqq.app.message.config;

import android.text.TextUtils;
import com.tencent.mobileqq.app.message.filescan.d;
import com.tencent.mobileqq.app.message.messageclean.StorageCacheManager;
import com.tencent.mobileqq.app.message.messageclean.x;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00052\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\tJ\b\u0010\u000e\u001a\u00020\tH\u0016R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R*\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0014j\b\u0012\u0004\u0012\u00020\t`\u00158\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001b8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001c\u001a\u0004\b\u0016\u0010\u001dR\"\u0010%\u001a\u00020\u001f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010(\u001a\u00020\u001f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/app/message/config/FileMonitorConfigBean;", "", "Lorg/json/JSONObject;", "configJson", "", "f", "g", h.F, "j", "", "originDir", "a", DownloadInfo.spKey_Config, "i", "toString", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "d", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "reportWhitePathSet", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "fullReportPathList", "", "Lkotlin/Lazy;", "()Ljava/util/Set;", "cacheClearPathSet", "", "I", "e", "()I", "setSamplingRate$storage_impl_release", "(I)V", "samplingRate", "getMaxReportCount$storage_impl_release", "setMaxReportCount$storage_impl_release", "maxReportCount", "<init>", "()V", "storage-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class FileMonitorConfigBean {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArraySet<String> reportWhitePathSet;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> fullReportPathList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy cacheClearPathSet;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int samplingRate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int maxReportCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00078\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/app/message/config/FileMonitorConfigBean$a;", "", "", "CONFIG_PLACE_HOLDER_DATA_PATH", "Ljava/lang/String;", "CONFIG_PLACE_HOLDER_EXTERNAL_PATH", "CONFIG_PLACE_HOLDER_STORAGE_PATH", "", "DEFAULT_SAMPLING_RATE", "I", "KEY_CONFIG_CACHE", "KEY_CONFIG_FULL_REPORT_PATH_LIST", "KEY_CONFIG_MAX_REPORT_COUNT", "KEY_CONFIG_REPORT_WHITE_LIST", "KEY_CONFIG_SAMPLING_RATE", "KEY_CONFIG_WHITE_LIST", "MAX_REPORT_NUM", "TAG", "<init>", "()V", "storage-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.message.config.FileMonitorConfigBean$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18907);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FileMonitorConfigBean() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.reportWhitePathSet = new CopyOnWriteArraySet<>();
        this.fullReportPathList = new ArrayList<>();
        lazy = LazyKt__LazyJVMKt.lazy(FileMonitorConfigBean$cacheClearPathSet$2.INSTANCE);
        this.cacheClearPathSet = lazy;
        this.samplingRate = 100;
        this.maxReportCount = 1000;
    }

    private final String a(String originDir) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        String replace$default;
        String replace$default2;
        String replace$default3;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) originDir, (CharSequence) "$dataPath", false, 2, (Object) null);
        if (contains$default) {
            replace$default3 = StringsKt__StringsJVMKt.replace$default(originDir, "$dataPath", d.f195978a.a(), false, 4, (Object) null);
            return replace$default3;
        }
        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) originDir, (CharSequence) "$externalPath", false, 2, (Object) null);
        if (contains$default2) {
            replace$default2 = StringsKt__StringsJVMKt.replace$default(originDir, "$externalPath", d.f195978a.d(), false, 4, (Object) null);
            return replace$default2;
        }
        contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) originDir, (CharSequence) "$storagePath", false, 2, (Object) null);
        if (contains$default3) {
            replace$default = StringsKt__StringsJVMKt.replace$default(originDir, "$storagePath", d.f195978a.k(), false, 4, (Object) null);
            return replace$default;
        }
        return originDir;
    }

    private final void f(JSONObject configJson) {
        x xVar;
        JSONObject optJSONObject = configJson.optJSONObject("cache");
        if (optJSONObject != null) {
            Iterator keys = optJSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys()");
            while (keys.hasNext()) {
                String str = (String) keys.next();
                JSONArray optJSONArray = optJSONObject.optJSONArray(str);
                if (optJSONArray != null && optJSONArray.length() > 0 && (xVar = StorageCacheManager.f196111a.d().get(str)) != null) {
                    Intrinsics.checkNotNullExpressionValue(xVar, "StorageCacheManager.cach\u2026ap[key] ?: return@forEach");
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        String string = optJSONArray.getString(i3);
                        Intrinsics.checkNotNullExpressionValue(string, "configDirList.getString(index)");
                        String a16 = a(string);
                        if (!TextUtils.isEmpty(a16) && !xVar.a().contains(a16)) {
                            xVar.a().add(a16);
                        }
                    }
                }
            }
        }
    }

    private final void g(JSONObject configJson) {
        JSONObject optJSONObject = configJson.optJSONObject("report_white_list");
        if (optJSONObject != null) {
            Iterator keys = optJSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys()");
            while (keys.hasNext()) {
                JSONArray optJSONArray = optJSONObject.optJSONArray((String) keys.next());
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        String string = optJSONArray.getString(i3);
                        Intrinsics.checkNotNullExpressionValue(string, "configDirList.getString(index)");
                        String a16 = a(string);
                        if (!TextUtils.isEmpty(a16) && !this.reportWhitePathSet.contains(a16)) {
                            this.reportWhitePathSet.add(a16);
                        }
                    }
                }
            }
        }
    }

    private final void h(JSONObject configJson) {
        CopyOnWriteArrayList<String> a16;
        JSONObject optJSONObject = configJson.optJSONObject(MobileQQ.PREF_WHITE_LIST_KEY);
        if (optJSONObject != null) {
            Iterator keys = optJSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys()");
            while (keys.hasNext()) {
                String str = (String) keys.next();
                JSONArray optJSONArray = optJSONObject.optJSONArray(str);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    x xVar = StorageCacheManager.f196111a.d().get(str);
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        String string = optJSONArray.getString(i3);
                        Intrinsics.checkNotNullExpressionValue(string, "configDirList.getString(index)");
                        String a17 = a(string);
                        if (!TextUtils.isEmpty(a17)) {
                            if (xVar != null && (a16 = xVar.a()) != null) {
                                a16.remove(a17);
                            }
                            this.reportWhitePathSet.add(a17);
                        }
                    }
                }
            }
        }
    }

    private final void j(JSONObject configJson) {
        this.fullReportPathList.clear();
        JSONObject optJSONObject = configJson.optJSONObject("full_report_path_list");
        if (optJSONObject != null) {
            Iterator keys = optJSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys()");
            while (keys.hasNext()) {
                JSONArray optJSONArray = optJSONObject.optJSONArray((String) keys.next());
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        String string = optJSONArray.getString(i3);
                        Intrinsics.checkNotNullExpressionValue(string, "configDirList.getString(index)");
                        String a16 = a(string);
                        if (!TextUtils.isEmpty(a16)) {
                            this.fullReportPathList.add(a16);
                        }
                    }
                }
            }
        }
    }

    @NotNull
    public final Set<String> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (Set) this.cacheClearPathSet.getValue();
    }

    @NotNull
    public final ArrayList<String> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.fullReportPathList;
    }

    @NotNull
    public final CopyOnWriteArraySet<String> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CopyOnWriteArraySet) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.reportWhitePathSet;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.samplingRate;
    }

    public final void i(@NotNull String config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) config);
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        QLog.d("FileMonitorConfigBean", 1, "parseConfig config:" + config);
        if (TextUtils.isEmpty(config)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(config);
            f(jSONObject);
            g(jSONObject);
            h(jSONObject);
            j(jSONObject);
            this.samplingRate = jSONObject.optInt("sampling_rate", 10);
            this.maxReportCount = jSONObject.optInt("max_report_count", 100);
        } catch (JSONException e16) {
            QLog.d("FileMonitorConfigBean", 1, e16, new Object[0]);
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "FileMonitorConfigBean(reportWhitePathSet=" + this.reportWhitePathSet + ", cacheClearPathSet=" + b() + ", samplingRate=" + this.samplingRate + ", maxReportCount=" + this.maxReportCount + ')';
    }
}
