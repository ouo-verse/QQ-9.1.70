package eg0;

import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\tR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\u000e"}, d2 = {"Leg0/a;", "", "", "", "a", "method", "", "b", "", "Ljava/util/List;", "blackCmdList", "defaultBlackCmdList", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final List<String> blackCmdList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static List<String> defaultBlackCmdList;

    /* renamed from: c, reason: collision with root package name */
    public static final a f396236c;

    static {
        List<String> mutableListOf;
        a aVar = new a();
        f396236c = aVar;
        ArrayList arrayList = new ArrayList();
        blackCmdList = arrayList;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("/trpc.ecom.report_server.ReportServer/Report", "/trpc.ecom.realtime_reportsvr.RealtimeReportsvr/Report", "/trpc.ecom.register_svr.RegisterSvr/IsRegistered");
        defaultBlackCmdList = mutableListOf;
        List<String> a16 = aVar.a();
        if (a16.isEmpty()) {
            arrayList.addAll(defaultBlackCmdList);
        } else {
            arrayList.addAll(a16);
        }
    }

    a() {
    }

    private final List<String> a() {
        ArrayList arrayList = new ArrayList();
        String str = (String) com.tencent.ecommerce.base.config.service.b.f100655b.a(TbsListener.ErrorCode.STATIC_TBS_INSTALL_HAS_INSTALLED_EXCEPTION, "black_list_api_method", "");
        if (TextUtils.isEmpty(str)) {
            cg0.a.a("ECNetworkBlackService", "getBlackListApiMethodConfig", "black_list_api_method config is empty!");
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            cg0.a.b("ECNetworkBlackService", "[getBlackListApiMethodConfig] blackMethodJsonArray=" + jSONArray);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(jSONArray.optJSONObject(i3).optString("method"));
            }
        } catch (Throwable th5) {
            cg0.a.a("ECNetworkBlackService", "getBlackListApiMethodConfig", "black_list_api_method convert config error=" + th5);
        }
        return arrayList;
    }

    public final boolean b(String method) {
        return blackCmdList.contains(method);
    }
}
