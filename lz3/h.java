package lz3;

import com.tencent.rdelivery.data.RDeliveryData;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/rdelivery/data/RDeliveryData;", "", "a", "Ljz3/e;", "b", "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class h {
    public static final boolean a(@Nullable RDeliveryData rDeliveryData) {
        boolean z16;
        if (rDeliveryData == null) {
            return true;
        }
        String configValue = rDeliveryData.getConfigValue();
        if (configValue != null && configValue.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        return false;
    }

    @Nullable
    public static final jz3.e b(@Nullable RDeliveryData rDeliveryData) {
        String configValue;
        boolean isBlank;
        Object m476constructorimpl;
        Object obj = null;
        if (rDeliveryData == null || (configValue = rDeliveryData.getConfigValue()) == null) {
            return null;
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(configValue);
        if (isBlank) {
            jz3.d.i("RDeliveryData", "Remote ResConfig Data Parse Empty");
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(nz3.b.a(new JSONObject(configValue)));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl == null) {
            obj = m476constructorimpl;
        } else {
            jz3.d.d("RDeliveryData", "Remote ResConfig Data Parse Exception", m479exceptionOrNullimpl);
        }
        return (jz3.e) obj;
    }
}
