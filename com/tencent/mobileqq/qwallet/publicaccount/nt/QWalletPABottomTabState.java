package com.tencent.mobileqq.qwallet.publicaccount.nt;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/publicaccount/nt/QWalletPABottomTabState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "<init>", "()V", "ChangeTabVisibilityState", "HidePAMenuState", "Lcom/tencent/mobileqq/qwallet/publicaccount/nt/QWalletPABottomTabState$ChangeTabVisibilityState;", "Lcom/tencent/mobileqq/qwallet/publicaccount/nt/QWalletPABottomTabState$HidePAMenuState;", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class QWalletPABottomTabState implements MviUIState {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qwallet/publicaccount/nt/QWalletPABottomTabState$ChangeTabVisibilityState;", "Lcom/tencent/mobileqq/qwallet/publicaccount/nt/QWalletPABottomTabState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", NodeProps.VISIBLE, "<init>", "(Z)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final /* data */ class ChangeTabVisibilityState extends QWalletPABottomTabState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean visible;

        public ChangeTabVisibilityState(boolean z16) {
            super(null);
            this.visible = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getVisible() {
            return this.visible;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof ChangeTabVisibilityState) && this.visible == ((ChangeTabVisibilityState) other).visible) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.visible;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "ChangeTabVisibilityState(visible=" + this.visible + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/qwallet/publicaccount/nt/QWalletPABottomTabState$HidePAMenuState;", "Lcom/tencent/mobileqq/qwallet/publicaccount/nt/QWalletPABottomTabState;", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class HidePAMenuState extends QWalletPABottomTabState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final HidePAMenuState f279144d = new HidePAMenuState();

        HidePAMenuState() {
            super(null);
        }
    }

    public /* synthetic */ QWalletPABottomTabState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    QWalletPABottomTabState() {
    }
}
