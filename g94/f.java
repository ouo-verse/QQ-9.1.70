package g94;

import androidx.lifecycle.MutableLiveData;
import com.tencent.sqshow.zootopia.nativeui.data.reddot.DotTreeLevel;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager;
import kotlin.Metadata;
import uv4.h;
import v94.RedDotInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lg94/f;", "", "", "redDotId", "type", "level", "", "broadcast", "", "a", "Landroidx/lifecycle/MutableLiveData;", "Lv94/a;", "b", "Landroidx/lifecycle/MutableLiveData;", "getRedDotLiveData", "()Landroidx/lifecycle/MutableLiveData;", "redDotLiveData", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f401577a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<RedDotInfo> redDotLiveData = new MutableLiveData<>();

    f() {
    }

    public final void a(int redDotId, int type, @DotTreeLevel int level, boolean broadcast) {
        if (redDotId <= 0) {
            return;
        }
        h hVar = new h();
        hVar.f440424a = redDotId;
        hVar.f440425b = type;
        ZPlanRedDotManager.f373437a.g(new h[]{hVar});
        if (broadcast) {
            redDotLiveData.postValue(new RedDotInfo(redDotId, level));
        }
    }

    public static /* synthetic */ void b(f fVar, int i3, int i16, int i17, boolean z16, int i18, Object obj) {
        if ((i18 & 2) != 0) {
            i16 = 0;
        }
        if ((i18 & 4) != 0) {
            i17 = -1;
        }
        if ((i18 & 8) != 0) {
            z16 = false;
        }
        fVar.a(i3, i16, i17, z16);
    }
}
