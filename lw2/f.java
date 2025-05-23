package lw2;

import androidx.annotation.NonNull;
import com.squareup.wire.Message;
import com.tencent.tvideo.protocol.pb.AdAction;
import com.tencent.tvideo.protocol.pb.AdDownloadAction;
import com.tencent.tvideo.protocol.pb.AdReport;
import com.tencent.tvideo.protocol.pb.AdWebAction;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final g f415695a = new e();

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Object, g> f415696b;

    static {
        HashMap hashMap = new HashMap();
        f415696b = hashMap;
        hashMap.put(AdDownloadAction.class, new b());
        hashMap.put(AdWebAction.class, new c());
        hashMap.put(AdReport.class, new d());
        hashMap.put(AdAction.class, new a());
    }

    public static g a(@NonNull Message message) {
        g gVar = f415696b.get(message.getClass());
        if (gVar == null) {
            return f415695a;
        }
        return gVar;
    }
}
