package ku3;

import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B5\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lku3/c;", "Lcom/tencent/qqmini/sdk/launcher/model/CrashRtInfoHolder;", "", "", "buildReportParams", "", "getRuntimeNativeLibs", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "a", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "appInfo", "b", "Ljava/lang/String;", "jsVersion", "c", "tritonVersion", "", "d", "Z", "launchResult", "e", "firstFrameResult", "<init>", "(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;Ljava/lang/String;Ljava/lang/String;ZZ)V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class c implements CrashRtInfoHolder {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MiniAppInfo appInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String jsVersion;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String tritonVersion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean launchResult;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean firstFrameResult;

    public c(@Nullable MiniAppInfo miniAppInfo, @Nullable String str, @Nullable String str2, boolean z16, boolean z17) {
        this.appInfo = miniAppInfo;
        this.jsVersion = str;
        this.tritonVersion = str2;
        this.launchResult = z16;
        this.firstFrameResult = z17;
    }

    @Override // com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder
    @NotNull
    public Map<String, String> buildReportParams() {
        Object obj;
        HashMap hashMap = new HashMap();
        MiniAppInfo miniAppInfo = this.appInfo;
        if (miniAppInfo != null) {
            hashMap.put("game_id", miniAppInfo.appId);
            hashMap.put(CrashRtInfoHolder.BeaconKey.GAME_NAME, this.appInfo.name);
        }
        String str = this.jsVersion;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        hashMap.put(CrashRtInfoHolder.BeaconKey.JS_VERSION, str);
        String str3 = this.tritonVersion;
        if (str3 != null) {
            str2 = str3;
        }
        hashMap.put("triton_version", str2);
        String str4 = "1";
        if (this.launchResult) {
            obj = "1";
        } else {
            obj = "-1";
        }
        hashMap.put("launch_result", obj);
        if (!this.firstFrameResult) {
            str4 = "-1";
        }
        hashMap.put(CrashRtInfoHolder.BeaconKey.FIRST_FRAME_RESULT, str4);
        return hashMap;
    }

    @Override // com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder
    @NotNull
    public List<String> getRuntimeNativeLibs() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("libv8jni.so", "libtriton.so", "libfreetypejni.so");
        return arrayListOf;
    }
}
