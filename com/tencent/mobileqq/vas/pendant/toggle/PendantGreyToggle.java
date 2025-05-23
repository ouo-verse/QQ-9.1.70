package com.tencent.mobileqq.vas.pendant.toggle;

import android.os.Build;
import com.tencent.mobileqq.vas.ToggleProxy;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.qqnt.util.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/toggle/PendantGreyToggle;", "", "()V", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class PendantGreyToggle {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static boolean isSupportAvif = true;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/toggle/PendantGreyToggle$Companion;", "", "()V", "isSupportAvif", "", "()Z", "setSupportAvif", "(Z)V", "isSupportAvifImage", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isSupportAvif() {
            return PendantGreyToggle.isSupportAvif;
        }

        public final boolean isSupportAvifImage() {
            boolean z16;
            if (b.f362976b.isDebugVersion()) {
                return isSupportAvif();
            }
            ToggleProxy toggleProxy = VasNtToggle.FEATURE_AVIF;
            if (toggleProxy.isEnable(false)) {
                int i3 = Build.VERSION.SDK_INT;
                Integer valueOf = Integer.valueOf(toggleProxy.getStringData("0"));
                Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(VasNtToggle.FEAT\u2026_AVIF.getStringData(\"0\"))");
                if (i3 >= valueOf.intValue()) {
                    z16 = true;
                    boolean isEnable = VasNtToggle.INSTANCE.getFEATURE_PENDANT_SUPPORT_AVIF().isEnable(false);
                    if (!z16 && isEnable) {
                        return true;
                    }
                }
            }
            z16 = false;
            boolean isEnable2 = VasNtToggle.INSTANCE.getFEATURE_PENDANT_SUPPORT_AVIF().isEnable(false);
            return !z16 ? false : false;
        }

        public final void setSupportAvif(boolean z16) {
            PendantGreyToggle.isSupportAvif = z16;
        }

        Companion() {
        }
    }
}
