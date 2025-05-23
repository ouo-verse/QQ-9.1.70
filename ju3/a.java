package ju3;

import com.tencent.qqmini.minigame.manager.EnginePackageUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\u0005BE\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\u0002H\u0016R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u001c\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lju3/a;", "", "", "appId", "", "a", "Ljava/io/File;", QzoneZipCacheHelper.DIR, "g", "d", "toString", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "downloadUrl", "c", "jsLibVersion", "f", "tritonVersion", "", "J", "e", "()J", "timestamp", "", "Ljava/util/List;", "verifyFileList", "grayAppIdList", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/util/List;)V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String downloadUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String jsLibVersion;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tritonVersion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long timestamp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<String> verifyFileList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<String> grayAppIdList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lju3/a$a;", "", "", "jsonString", "Lju3/a;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: ju3.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final a a(@Nullable String jsonString) {
            boolean z16;
            ArrayList arrayList;
            if (jsonString != null && jsonString.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(jsonString);
                String downloadUrl = jSONObject.getString("downloadUrl");
                String jsLibVersion = jSONObject.getString("jsLibVersion");
                String tritonVersion = jSONObject.getString("tritonVersion");
                long j3 = jSONObject.getLong("timestamp");
                JSONArray optJSONArray = jSONObject.optJSONArray("verifyFileList");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    ArrayList arrayList2 = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        arrayList2.add(optJSONArray.getString(i3));
                    }
                    if (arrayList2.isEmpty()) {
                        return null;
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("appIdList");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        ArrayList arrayList3 = new ArrayList(optJSONArray2.length());
                        int length2 = optJSONArray2.length();
                        for (int i16 = 0; i16 < length2; i16++) {
                            arrayList3.add(optJSONArray2.getString(i16));
                        }
                        arrayList = arrayList3;
                    } else {
                        arrayList = null;
                    }
                    Intrinsics.checkExpressionValueIsNotNull(downloadUrl, "downloadUrl");
                    Intrinsics.checkExpressionValueIsNotNull(jsLibVersion, "jsLibVersion");
                    Intrinsics.checkExpressionValueIsNotNull(tritonVersion, "tritonVersion");
                    return new a(downloadUrl, jsLibVersion, tritonVersion, j3, arrayList2, arrayList);
                }
                return null;
            } catch (JSONException e16) {
                QMLog.e("EnginePackageUpdateConfig", "createFromJsonString: failed, string=" + jsonString, e16);
                return null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(@NotNull String downloadUrl, @NotNull String jsLibVersion, @NotNull String tritonVersion, long j3, @NotNull List<String> verifyFileList, @Nullable List<String> list) {
        Intrinsics.checkParameterIsNotNull(downloadUrl, "downloadUrl");
        Intrinsics.checkParameterIsNotNull(jsLibVersion, "jsLibVersion");
        Intrinsics.checkParameterIsNotNull(tritonVersion, "tritonVersion");
        Intrinsics.checkParameterIsNotNull(verifyFileList, "verifyFileList");
        this.downloadUrl = downloadUrl;
        this.jsLibVersion = jsLibVersion;
        this.tritonVersion = tritonVersion;
        this.timestamp = j3;
        this.verifyFileList = verifyFileList;
        this.grayAppIdList = list;
    }

    public final boolean a(@Nullable String appId) {
        boolean z16;
        boolean z17;
        if (appId != null && appId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        List<String> list = this.grayAppIdList;
        if (list != null && !list.isEmpty()) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            return false;
        }
        Iterator<String> it = this.grayAppIdList.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(appId, it.next())) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getJsLibVersion() {
        return this.jsLibVersion;
    }

    @NotNull
    public final File d() {
        return new File(EnginePackageUtil.f346509e.d(), String.valueOf(this.timestamp));
    }

    /* renamed from: e, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTritonVersion() {
        return this.tritonVersion;
    }

    public final boolean g(@NotNull File dir) {
        File[] listFiles;
        Intrinsics.checkParameterIsNotNull(dir, "dir");
        if (!dir.exists() || this.verifyFileList.isEmpty() || (listFiles = dir.listFiles()) == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList(this.verifyFileList);
        for (File child : listFiles) {
            Intrinsics.checkExpressionValueIsNotNull(child, "child");
            arrayList.remove(child.getName());
        }
        return arrayList.isEmpty();
    }

    @NotNull
    public String toString() {
        return "EnginePackageUpdateConfig{jsLibVersion=" + this.jsLibVersion + ",tritonVersion=" + this.tritonVersion + ",timestamp=" + this.timestamp + '}';
    }
}
