package cooperation.plugin.patch;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import cooperation.plugin.PluginInfo;
import cooperation.plugin.d;
import cooperation.plugin.patch.f;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes28.dex */
public class PatchDownloadManager {

    /* renamed from: a, reason: collision with root package name */
    private final Context f390334a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, f> f390335b = new ConcurrentHashMap();

    @Keep
    /* loaded from: classes28.dex */
    public static class PatchInfo {
        public String length;
        public String md5;
        public String url;
        public String version;

        @NonNull
        public String toString() {
            return String.format("{version:%s,url:%s,md5:%s,length:%s}", this.version, this.url, this.md5, this.length);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class a implements f.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PluginInfo f390336a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f.b f390337b;

        a(PluginInfo pluginInfo, f.b bVar) {
            this.f390336a = pluginInfo;
            this.f390337b = bVar;
        }

        @Override // cooperation.plugin.patch.f.b
        public void a() {
            PatchDownloadManager.this.f390335b.remove(this.f390336a.mID);
            this.f390336a.mPatchDescription = null;
            f.b bVar = this.f390337b;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public PatchDownloadManager(Context context) {
        this.f390334a = context;
    }

    public synchronized f b(PluginInfo pluginInfo, String str, String str2, d.c cVar, f.b bVar) {
        f fVar;
        fVar = this.f390335b.get(pluginInfo.mID);
        if (fVar == null) {
            fVar = new f(this.f390334a, pluginInfo, str, str2, cVar, new a(pluginInfo, bVar));
            this.f390335b.put(pluginInfo.mID, fVar);
        } else {
            fVar.l(cVar);
        }
        return fVar;
    }
}
