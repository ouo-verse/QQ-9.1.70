package com.tencent.ecommerce.base.offline.api;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0002\u001d\u001eJ5\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022#\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004H&J\u001a\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H&J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H&J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J6\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u001c\u0010\u001a\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u0016j\u0002`\u0019H&J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager;", "", "", "bid", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager$OfflineDownloadState;", "Lkotlin/ParameterName;", "name", "downloadState", "", "resultBlock", "downloadOffline", "Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager$a;", "offlineStrongCallback", "filePath", "loadOffline", "Ljava/io/File;", "getOfflineFile", "", "offlineExist", "getBidVersion", "url", "Lkotlin/Function2;", "", "", "Lcom/tencent/ecommerce/base/offline/api/ECLoadUrlOfflineCallback;", "callback", "loadOfflineWithUrl", "deleteOffline", "OfflineDownloadState", "a", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECOfflineManager {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager$OfflineDownloadState;", "", "(Ljava/lang/String;I)V", "STATE_DOWNLOAD_SUCCESS", "STATE_DOWNLOAD_FAIL", "STATE_NO_UPDATE", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public enum OfflineDownloadState {
        STATE_DOWNLOAD_SUCCESS,
        STATE_DOWNLOAD_FAIL,
        STATE_NO_UPDATE
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B6\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u0012#\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR4\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\t\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Object;", "getOfflineCallbackStrongRef", "()Ljava/lang/Object;", "b", "(Ljava/lang/Object;)V", "offlineCallbackStrongRef", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager$OfflineDownloadState;", "Lkotlin/ParameterName;", "name", "downloadState", "", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "resultBlock", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.offline.api.IECOfflineManager$a, reason: from toString */
    /* loaded from: classes5.dex */
    public static final /* data */ class OfflineStrongCallback {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Object offlineCallbackStrongRef;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Function1<OfflineDownloadState, Unit> resultBlock;

        /* JADX WARN: Multi-variable type inference failed */
        public OfflineStrongCallback(@Nullable Object obj, @Nullable Function1<? super OfflineDownloadState, Unit> function1) {
            this.offlineCallbackStrongRef = obj;
            this.resultBlock = function1;
        }

        @Nullable
        public final Function1<OfflineDownloadState, Unit> a() {
            return this.resultBlock;
        }

        public final void b(@Nullable Object obj) {
            this.offlineCallbackStrongRef = obj;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof OfflineStrongCallback) {
                    OfflineStrongCallback offlineStrongCallback = (OfflineStrongCallback) other;
                    if (!Intrinsics.areEqual(this.offlineCallbackStrongRef, offlineStrongCallback.offlineCallbackStrongRef) || !Intrinsics.areEqual(this.resultBlock, offlineStrongCallback.resultBlock)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            Object obj = this.offlineCallbackStrongRef;
            int i16 = 0;
            if (obj != null) {
                i3 = obj.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = i3 * 31;
            Function1<OfflineDownloadState, Unit> function1 = this.resultBlock;
            if (function1 != null) {
                i16 = function1.hashCode();
            }
            return i17 + i16;
        }

        @NotNull
        public String toString() {
            return "OfflineStrongCallback(offlineCallbackStrongRef=" + this.offlineCallbackStrongRef + ", resultBlock=" + this.resultBlock + ")";
        }
    }

    void deleteOffline(@NotNull String bid);

    void downloadOffline(@NotNull String bid, @Nullable OfflineStrongCallback offlineStrongCallback);

    void downloadOffline(@NotNull String bid, @Nullable Function1<? super OfflineDownloadState, Unit> resultBlock);

    @NotNull
    String getBidVersion(@NotNull String bid);

    @Nullable
    File getOfflineFile(@NotNull String bid, @NotNull String filePath);

    @Nullable
    String loadOffline(@NotNull String bid, @NotNull String filePath);

    void loadOfflineWithUrl(@NotNull String bid, @NotNull String url, @NotNull Function2<? super Integer, ? super Long, Unit> callback);

    boolean offlineExist(@NotNull String bid);
}
