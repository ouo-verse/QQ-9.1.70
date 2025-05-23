package ft2;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u0000 \u00112\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H&J\"\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0012"}, d2 = {"Lft2/a;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "type", "", "isSuccess", "", "data", "", "b", "", "troopUin", h.f248218g, "a", "onUpdate", "<init>", "()V", "d", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class a implements BusinessObserver {
    private final void b(int type, boolean isSuccess, Object data) {
        String str;
        if (type == 1 && (data instanceof Object[])) {
            Object[] objArr = (Object[]) data;
            if (objArr.length >= 2) {
                boolean z16 = false;
                Object obj = objArr[0];
                Boolean bool = null;
                if (obj instanceof String) {
                    str = (String) obj;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                Object obj2 = objArr[1];
                if (obj2 instanceof Boolean) {
                    bool = (Boolean) obj2;
                }
                if (bool != null) {
                    z16 = bool.booleanValue();
                }
                a(isSuccess, str, z16);
            }
        }
    }

    public abstract void a(boolean isSuccess, @NotNull String troopUin, boolean isOpen);

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
        b(type, isSuccess, data);
    }
}
