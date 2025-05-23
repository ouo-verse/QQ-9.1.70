package j94;

import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import r94.b;
import r94.c;
import uv4.am;
import uv4.at;
import uv4.av;
import uv4.aw;
import uv4.w;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004R0\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0014j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0016R$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0018j\b\u0012\u0004\u0012\u00020\t`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001f\u00a8\u0006#"}, d2 = {"Lj94/a;", "", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/m;", "Luv4/am;", "cameraCfgMap", "", "e", "", "Luv4/aw;", "cfg", "f", "Luv4/w;", "rsp", "d", "cameraKey", "b", "Lorg/json/JSONArray;", "c", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mCameraCfg", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mFaceEditorFaceControlCfg", "Lorg/json/JSONArray;", "mFaceEditorFaceControlCfgJson", "Luv4/at;", "Luv4/at;", "mCommConfig", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f409675a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<CameraKey, am> mCameraCfg = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<aw> mFaceEditorFaceControlCfg = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static JSONArray mFaceEditorFaceControlCfgJson = new JSONArray();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static at mCommConfig = new at();

    a() {
    }

    private final void e(Map<CameraKey, am> cameraCfgMap) {
        mCameraCfg.putAll(cameraCfgMap);
    }

    private final void f(List<aw> cfg) {
        ArrayList<aw> arrayList = mFaceEditorFaceControlCfg;
        arrayList.clear();
        arrayList.addAll(cfg);
        mFaceEditorFaceControlCfgJson = c.x(arrayList);
    }

    public final am a() {
        return b(new CameraKey(mCommConfig.f440230h, 0, 2, null));
    }

    public final am b(CameraKey cameraKey) {
        Intrinsics.checkNotNullParameter(cameraKey, "cameraKey");
        return mCameraCfg.get(cameraKey);
    }

    public final JSONArray c() {
        return mFaceEditorFaceControlCfgJson;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0027, code lost:
    
        r3 = kotlin.collections.ArraysKt___ArraysKt.toList(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(w rsp) {
        List<aw> list;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        at atVar = rsp.f440464e;
        Intrinsics.checkNotNullExpressionValue(atVar, "rsp.commonCfg");
        mCommConfig = atVar;
        am[] amVarArr = rsp.f440469j;
        Intrinsics.checkNotNullExpressionValue(amVarArr, "rsp.cameraCfgList");
        e(b.P(amVarArr));
        av avVar = rsp.f440468i;
        if (avVar == null || (r3 = avVar.f440238b) == null || list == null) {
            return;
        }
        f409675a.f(list);
    }
}
