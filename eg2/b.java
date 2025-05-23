package eg2;

import af2.d;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.c;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.pts.utils.PTSFileUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0006\u0010\u0014\u001a\u00020\u0004\u00a8\u0006\u0017"}, d2 = {"Leg2/b;", "", "", "bidPageDirPath", "", "i", "bid", "b", "e", "jsonContent", "currentVersion", "", "g", "version1", "version2", "", "d", "version", "", "f", h.F, "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f396245a = new b();

    b() {
    }

    private final void b(final String bid) {
        if (TextUtils.isEmpty(bid) || Intrinsics.areEqual("0", bid)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: eg2.a
            @Override // java.lang.Runnable
            public final void run() {
                b.c(bid);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String bid) {
        Intrinsics.checkNotNullParameter(bid, "$bid");
        HtmlOffline.k(bid, BaseApplicationImpl.getApplication().getRuntime(), new a(), true, 5, true);
    }

    private final int d(String version1, String version2) {
        int coerceAtMost;
        List<Integer> f16 = f(version1);
        List<Integer> f17 = f(version2);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(f16.size(), f17.size());
        for (int i3 = 0; i3 < coerceAtMost; i3++) {
            if (f16.get(i3).intValue() > f17.get(i3).intValue()) {
                return 1;
            }
            if (f16.get(i3).intValue() < f17.get(i3).intValue()) {
                return -1;
            }
        }
        return 0;
    }

    private final String e() {
        return "";
    }

    private final List<Integer> f(String version) {
        List split$default;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(version)) {
            return arrayList;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) version, new String[]{"."}, false, 0, 6, (Object) null);
        Object[] array = split$default.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        for (String str : (String[]) array) {
            try {
                arrayList.add(Integer.valueOf(Integer.parseInt(str)));
            } catch (Exception e16) {
                QLog.e("ECPtsOfflineStyleManager", 1, "[getVersionArray] e =" + e16);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(6:2|3|5|6|7|8)|(2:10|(7:12|13|14|(1:16)|22|18|19))|28|13|14|(0)|22|18|19|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        if (d(r10, r9) < 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        r7 = r4;
        r4 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:
    
        r1 = r7;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c A[Catch: JSONException -> 0x0045, TRY_LEAVE, TryCatch #1 {JSONException -> 0x0045, blocks: (B:14:0x0036, B:16:0x003c), top: B:13:0x0036 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean g(String jsonContent, String currentVersion) {
        String str;
        boolean z16;
        JSONException e16;
        String str2;
        boolean z17;
        try {
            JSONObject jSONObject = new JSONObject(jsonContent);
            str2 = jSONObject.optString("min_version", "");
            Intrinsics.checkNotNullExpressionValue(str2, "frameTreeJson.optString(\"min_version\", \"\")");
            try {
                str = jSONObject.optString("max_version", "");
                Intrinsics.checkNotNullExpressionValue(str, "frameTreeJson.optString(\"max_version\", \"\")");
            } catch (JSONException e17) {
                z16 = true;
                JSONException jSONException = e17;
                str = "";
            }
            try {
                z16 = false;
            } catch (JSONException e18) {
                e16 = e18;
                z16 = true;
                QLog.e("ECPtsOfflineStyleManager", 1, "[isJsonContentVersionValid] e = " + e16);
                QLog.i("ECPtsOfflineStyleManager", 1, "[isJsonContentVersionValid] currentVersion = " + currentVersion + ", minVersion = " + str2 + ", maxVersion = " + str + ", isValid = " + z16);
                return z16;
            }
        } catch (JSONException e19) {
            str = "";
            z16 = true;
            e16 = e19;
            str2 = str;
        }
        if (!TextUtils.isEmpty(str)) {
            if (d(currentVersion, str) > 0) {
                z17 = false;
                if (!TextUtils.isEmpty(str2)) {
                }
                z16 = z17;
                QLog.i("ECPtsOfflineStyleManager", 1, "[isJsonContentVersionValid] currentVersion = " + currentVersion + ", minVersion = " + str2 + ", maxVersion = " + str + ", isValid = " + z16);
                return z16;
            }
        }
        z17 = true;
        if (!TextUtils.isEmpty(str2)) {
        }
        z16 = z17;
        QLog.i("ECPtsOfflineStyleManager", 1, "[isJsonContentVersionValid] currentVersion = " + currentVersion + ", minVersion = " + str2 + ", maxVersion = " + str + ", isValid = " + z16);
        return z16;
    }

    private final void i(String bidPageDirPath) {
        HashMap hashMapOf;
        if (TextUtils.isEmpty(bidPageDirPath)) {
            QLog.i("ECPtsOfflineStyleManager", 1, "[loadPtsThemeJson] bidPageDirPath is empty.");
            return;
        }
        String str = bidPageDirPath + File.separator + "themes.json";
        try {
            if (new File(str).exists()) {
                String themeJson = PTSFileUtil.loadFile(str, null, false);
                QLog.i("ECPtsOfflineStyleManager", 1, "[loadPtsThemesJson] themeJson = " + themeJson);
                if (TextUtils.isEmpty(themeJson)) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(themeJson, "themeJson");
                String subVersion = AppSetting.f99551k;
                Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
                if (g(themeJson, subVersion)) {
                    d dVar = d.f26007a;
                    hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("PARAM_THEME_JSON", themeJson));
                    d.b(dVar, 112, hashMapOf, null, 4, null);
                }
            }
        } catch (IOException e16) {
            QLog.e("ECPtsOfflineStyleManager", 1, "[loadPtsThemeJson] e = " + e16);
        }
    }

    public final void h() {
        File[] listFiles;
        HashMap hashMapOf;
        String e16 = e();
        if (!TextUtils.isEmpty(e16) && !Intrinsics.areEqual("0", e16)) {
            b(e16);
            String str = c.c(e16) + e16 + File.separator + "pages";
            QLog.i("ECPtsOfflineStyleManager", 1, "[loadPtsOfflineStyles] bidDirPath = " + str);
            try {
                File file = new File(str);
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        String name = file2.getName();
                        String frameTreeJson = PTSFileUtil.loadFile(PTSFileUtil.getFilePath(name, str, PTSFileUtil.FRAME_TREE_FORMAT), null, false);
                        QLog.i("ECPtsOfflineStyleManager", 1, "[loadPtsOfflineStyles] pageName = " + name);
                        if (!TextUtils.isEmpty(frameTreeJson)) {
                            b bVar = f396245a;
                            Intrinsics.checkNotNullExpressionValue(frameTreeJson, "frameTreeJson");
                            String subVersion = AppSetting.f99551k;
                            Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
                            if (bVar.g(frameTreeJson, subVersion)) {
                                d dVar = d.f26007a;
                                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("PARAM_PAGE_NAME", name), TuplesKt.to("PARAM_FRAME_TREE", frameTreeJson));
                                d.b(dVar, 110, hashMapOf, null, 4, null);
                            }
                        }
                    }
                }
            } catch (IOException e17) {
                QLog.e("ECPtsOfflineStyleManager", 1, "[loadPtsOfflineStyles] e = " + e17);
            }
            i(str);
            return;
        }
        QLog.i("ECPtsOfflineStyleManager", 1, "[loadPtsOfflineStyles] bid is empty or 0.");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"eg2/b$a", "Lcom/tencent/biz/common/offline/a;", "", "param", "", "code", "", "loaded", "progress", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements com.tencent.biz.common.offline.a {
        a() {
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String param, int code) {
            QLog.i("ECPtsOfflineStyleManager", 1, "[checkUpdateOffline] param = " + param + ", code = " + code);
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int progress) {
        }
    }
}
