package jd1;

import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.gamecenter.data.GameGlobalData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pv3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Ljd1/c;", "Lpv3/a;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "b", "<init>", "()V", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c implements pv3.a {
    @Override // pv3.a
    @NotNull
    public CharSequence a(@NotNull CharSequence charSequence) {
        return a.C11043a.a(this, charSequence);
    }

    @Override // pv3.a
    @Nullable
    public CharSequence b(@Nullable com.tencent.aio.api.runtime.a context) {
        Integer num;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        if (context != null && (g16 = context.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            num = Integer.valueOf(c16.e());
        } else {
            num = null;
        }
        if (num == null || num.intValue() != 105) {
            return "";
        }
        return GameGlobalData.INSTANCE.a().getMMainTitle();
    }
}
