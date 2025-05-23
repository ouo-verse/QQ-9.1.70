package okhttp3.internal.http2;

import com.heytap.databaseengine.type.DeviceType;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0011\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0086\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0000J\u0019\u0010\t\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0086\u0002J\u0006\u0010\u001a\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lokhttp3/internal/http2/Settings;", "", "()V", "headerTableSize", "", "getHeaderTableSize", "()I", "initialWindowSize", "getInitialWindowSize", "set", "values", "", QCircleLpReportDc05507.KEY_CLEAR, "", "get", "id", "getEnablePush", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getMaxConcurrentStreams", "getMaxFrameSize", "getMaxHeaderListSize", "isSet", DeviceType.DeviceCategory.MERGER, "other", "value", "size", "Companion", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class Settings {
    public static final int COUNT = 10;
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    public static final int ENABLE_PUSH = 2;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    public final void clear() {
        this.set = 0;
        ArraysKt___ArraysJvmKt.fill$default(this.values, 0, 0, 0, 6, (Object) null);
    }

    public final int get(int id5) {
        return this.values[id5];
    }

    public final boolean getEnablePush(boolean defaultValue) {
        if ((this.set & 4) != 0) {
            if (this.values[2] == 1) {
                return true;
            }
            return false;
        }
        return defaultValue;
    }

    public final int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    public final int getInitialWindowSize() {
        if ((this.set & 128) != 0) {
            return this.values[7];
        }
        return 65535;
    }

    public final int getMaxConcurrentStreams() {
        if ((this.set & 16) != 0) {
            return this.values[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int getMaxFrameSize(int defaultValue) {
        if ((this.set & 32) != 0) {
            return this.values[5];
        }
        return defaultValue;
    }

    public final int getMaxHeaderListSize(int defaultValue) {
        if ((this.set & 64) != 0) {
            return this.values[6];
        }
        return defaultValue;
    }

    public final boolean isSet(int id5) {
        if (((1 << id5) & this.set) != 0) {
            return true;
        }
        return false;
    }

    public final void merge(@NotNull Settings other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i3 = 0; i3 < 10; i3++) {
            if (other.isSet(i3)) {
                set(i3, other.get(i3));
            }
        }
    }

    @NotNull
    public final Settings set(int id5, int value) {
        if (id5 >= 0) {
            int[] iArr = this.values;
            if (id5 < iArr.length) {
                this.set = (1 << id5) | this.set;
                iArr[id5] = value;
            }
        }
        return this;
    }

    public final int size() {
        return Integer.bitCount(this.set);
    }
}
