package com.tencent.qqnt.aio.audiopanel;

import com.tencent.aio.base.mvi.part.PanelUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/PttUIState;", "Lcom/tencent/aio/base/mvi/part/PanelUIState;", "()V", "OnBackStace", "OnHidePanel", "OnPauseState", "Lcom/tencent/qqnt/aio/audiopanel/PttUIState$OnBackStace;", "Lcom/tencent/qqnt/aio/audiopanel/PttUIState$OnHidePanel;", "Lcom/tencent/qqnt/aio/audiopanel/PttUIState$OnPauseState;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public abstract class PttUIState implements PanelUIState {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\b\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/PttUIState$OnBackStace;", "Lcom/tencent/qqnt/aio/audiopanel/PttUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "b", "(Z)V", "isIntercept", "<init>", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final /* data */ class OnBackStace extends PttUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isIntercept;

        /* renamed from: a, reason: from getter */
        public final boolean getIsIntercept() {
            return this.isIntercept;
        }

        public final void b(boolean z16) {
            this.isIntercept = z16;
        }

        public int hashCode() {
            boolean z16 = this.isIntercept;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public String toString() {
            return "OnBackStace(isIntercept=" + this.isIntercept + ")";
        }

        public OnBackStace(boolean z16) {
            super(null);
            this.isIntercept = z16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnBackStace) && this.isIntercept == ((OnBackStace) other).isIntercept;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/PttUIState$OnHidePanel;", "Lcom/tencent/qqnt/aio/audiopanel/PttUIState;", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class OnHidePanel extends PttUIState {

        /* renamed from: d, reason: collision with root package name */
        public static final OnHidePanel f349654d = new OnHidePanel();

        OnHidePanel() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/PttUIState$OnPauseState;", "Lcom/tencent/qqnt/aio/audiopanel/PttUIState;", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class OnPauseState extends PttUIState {

        /* renamed from: d, reason: collision with root package name */
        public static final OnPauseState f349655d = new OnPauseState();

        OnPauseState() {
            super(null);
        }
    }

    public /* synthetic */ PttUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    PttUIState() {
    }
}
