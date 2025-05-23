package j63;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0005H&J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lj63/d;", "", "", "timeUs", "a", "", "", "b", "scrollX", "perPx", "c", UserInfo.SEX_FEMALE, "d", "()F", "unitValue", "<init>", "(F)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float unitValue;

    public d(float f16) {
        this.unitValue = f16;
    }

    public abstract float a(float timeUs);

    @NotNull
    public abstract String b(long timeUs);

    public abstract float c(float scrollX, float perPx);

    /* renamed from: d, reason: from getter */
    public final float getUnitValue() {
        return this.unitValue;
    }
}
