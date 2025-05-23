package com.tencent.mobileqq.guild.media.thirdapp.container.intent;

import android.os.Bundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;", "", "", "code", "", "msg", "Landroid/os/Bundle;", "extra", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface c {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class a {
        public static /* synthetic */ void a(c cVar, long j3, String str, Bundle bundle, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    j3 = 0;
                }
                if ((i3 & 2) != 0) {
                    str = "";
                }
                if ((i3 & 4) != 0) {
                    bundle = new Bundle();
                }
                cVar.a(j3, str, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResult");
        }
    }

    void a(long code, @Nullable String msg2, @NotNull Bundle extra);
}
