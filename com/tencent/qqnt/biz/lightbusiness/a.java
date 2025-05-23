package com.tencent.qqnt.biz.lightbusiness;

import androidx.annotation.UiThread;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessType;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H'\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/a;", "", "", "uid", "", "Lcom/tencent/qqnt/kernel/nativeinterface/LiteBusinessType;", "data", "", "a", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface a {
    @UiThread
    void a(@Nullable String uid, @NotNull Map<LiteBusinessType, ? extends Object> data);
}
