package com.tencent.state.square.api;

import com.tencent.upload.report.UploadQualityReportBuilder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\bH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000bH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/square/api/ISquareBatteryService;", "", "addObserver", "", "observer", "Lcom/tencent/state/square/api/ISquareBatteryServiceObserver;", "destroy", "getBatteryCapacity", "", "init", "mock", "", "isPowerConnect", "removeObserver", "setBatteryCapacity", "capacity", "setPowerConnect", UploadQualityReportBuilder.STATE_CONNECT, "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ISquareBatteryService {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void init$default(ISquareBatteryService iSquareBatteryService, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                iSquareBatteryService.init(z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
        }
    }

    void addObserver(@NotNull ISquareBatteryServiceObserver observer);

    void destroy();

    int getBatteryCapacity();

    void init(boolean mock);

    boolean isPowerConnect();

    void removeObserver(@NotNull ISquareBatteryServiceObserver observer);

    void setBatteryCapacity(int capacity);

    void setPowerConnect(boolean connect);
}
