package gh0;

import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012JD\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J.\u0010\u000e\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bJ8\u0010\u000f\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ8\u0010\u0010\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u0013"}, d2 = {"Lgh0/d;", "", "", "pageName", "frameTreeString", "jsonData", "", "containerWidth", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "liteEventListener", "Lcom/tencent/pts/core/PTSComposer$IPTSUpdateDataListener;", "updateDataListener", "Lcom/tencent/pts/core/PTSComposer;", "d", "b", "a", "c", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f402041a = new d();

    d() {
    }

    private final PTSComposer d(String pageName, String frameTreeString, String jsonData, float containerWidth, IPTSLiteEventListener liteEventListener, PTSComposer.IPTSUpdateDataListener updateDataListener) {
        PTSComposer buildComposer;
        synchronized (this) {
            if (containerWidth > 0.0f) {
                buildComposer = PTSComposer.buildComposer(pageName, frameTreeString, jsonData, containerWidth, liteEventListener);
            } else {
                buildComposer = PTSComposer.buildComposer(pageName, frameTreeString, jsonData, liteEventListener, updateDataListener);
            }
        }
        return buildComposer;
    }

    public final PTSComposer a(String pageName, String frameTreeString, String jsonData, float containerWidth, IPTSLiteEventListener liteEventListener) {
        return d(pageName, frameTreeString, jsonData, containerWidth, liteEventListener, null);
    }

    public final PTSComposer b(String pageName, String frameTreeString, String jsonData, IPTSLiteEventListener liteEventListener) {
        return d(pageName, frameTreeString, jsonData, 0.0f, liteEventListener, null);
    }

    public final PTSComposer c(String pageName, String frameTreeString, String jsonData, IPTSLiteEventListener liteEventListener, PTSComposer.IPTSUpdateDataListener updateDataListener) {
        return d(pageName, frameTreeString, jsonData, 0.0f, liteEventListener, updateDataListener);
    }
}
