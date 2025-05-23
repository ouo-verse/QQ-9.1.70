package ea3;

import androidx.room.TypeConverter;
import com.tencent.mobileqq.winkpublish.model.PromotionParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lea3/d;", "", "Lcom/tencent/mobileqq/winkpublish/model/PromotionParams;", "params", "", "a", "str", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d {
    @TypeConverter
    @NotNull
    public final String a(@Nullable PromotionParams params) {
        String promotionParams;
        if (params == null || (promotionParams = params.toString()) == null) {
            return "";
        }
        return promotionParams;
    }

    @TypeConverter
    @Nullable
    public final PromotionParams b(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return PromotionParams.INSTANCE.revertFromString(str);
    }
}
