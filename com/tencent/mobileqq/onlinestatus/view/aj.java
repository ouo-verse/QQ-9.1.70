package com.tencent.mobileqq.onlinestatus.view;

import android.view.View;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0003\t\u0011\u0013J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\t\u001a\u00020\bH&J(\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\bH&J\b\u0010\u0014\u001a\u00020\u0006H&J\b\u0010\u0015\u001a\u00020\u0006H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/aj;", "", "Landroid/view/View;", "getView", "Lcom/tencent/mobileqq/onlinestatus/view/aj$a;", "listener", "", "setEventListener", "", "a", "", "uin", "", "onlineStatusId", "onlineStatusSubIndex", "Lcom/tencent/mobileqq/onlinestatus/view/aj$c;", "option", "b", DKWebViewController.DKHippyWebviewFunction.RELOAD, "c", "stopAnimation", "release", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface aj {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\n\u001a\u00020\u0004H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/aj$a;", "", "", "success", "", "onLoad", "a", "", "dressKey", "b", NodeProps.ON_CLICK, "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {
        void a();

        void b(@Nullable String dressKey);

        void onClick();

        void onLoad(boolean success);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/aj$b;", "", "Landroid/view/View;", "getView", "", "hide", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface b {
        @NotNull
        View getView();

        void hide();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B)\b\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/aj$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/onlinestatus/view/aj$b;", "a", "Lcom/tencent/mobileqq/onlinestatus/view/aj$b;", "b", "()Lcom/tencent/mobileqq/onlinestatus/view/aj$b;", "loadingView", "Z", "c", "()Z", "noUpdatePreview", "forceReload", "<init>", "(Lcom/tencent/mobileqq/onlinestatus/view/aj$b;ZZ)V", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.onlinestatus.view.aj$c, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class LoadOption {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final b loadingView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean noUpdatePreview;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean forceReload;

        @JvmOverloads
        public LoadOption() {
            this(null, false, false, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getForceReload() {
            return this.forceReload;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final b getLoadingView() {
            return this.loadingView;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getNoUpdatePreview() {
            return this.noUpdatePreview;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadOption)) {
                return false;
            }
            LoadOption loadOption = (LoadOption) other;
            if (Intrinsics.areEqual(this.loadingView, loadOption.loadingView) && this.noUpdatePreview == loadOption.noUpdatePreview && this.forceReload == loadOption.forceReload) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            b bVar = this.loadingView;
            if (bVar == null) {
                hashCode = 0;
            } else {
                hashCode = bVar.hashCode();
            }
            int i3 = hashCode * 31;
            boolean z16 = this.noUpdatePreview;
            int i16 = 1;
            int i17 = z16;
            if (z16 != 0) {
                i17 = 1;
            }
            int i18 = (i3 + i17) * 31;
            boolean z17 = this.forceReload;
            if (!z17) {
                i16 = z17 ? 1 : 0;
            }
            return i18 + i16;
        }

        @NotNull
        public String toString() {
            return "LoadOption(loadingView=" + this.loadingView + ", noUpdatePreview=" + this.noUpdatePreview + ", forceReload=" + this.forceReload + ')';
        }

        @JvmOverloads
        public LoadOption(@Nullable b bVar, boolean z16) {
            this(bVar, z16, false, 4, null);
        }

        @JvmOverloads
        public LoadOption(@Nullable b bVar, boolean z16, boolean z17) {
            this.loadingView = bVar;
            this.noUpdatePreview = z16;
            this.forceReload = z17;
        }

        public /* synthetic */ LoadOption(b bVar, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : bVar, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? false : z17);
        }
    }

    boolean a();

    boolean b(@NotNull String uin, int onlineStatusId, int onlineStatusSubIndex, @NotNull LoadOption option);

    void c(boolean reload);

    @NotNull
    View getView();

    void release();

    void setEventListener(@Nullable a listener);

    void stopAnimation();
}
