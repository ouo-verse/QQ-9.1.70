package com.tencent.state.square.media.extractor;

import com.tencent.mobileqq.msf.core.auth.k;
import java.io.Closeable;
import java.io.InputStream;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0019\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH&J*\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/square/media/extractor/IRandomAccessSource;", "T", "Ljava/io/Closeable;", "copyFrom", "", "input", "Ljava/io/InputStream;", "initialize", "data", "(Ljava/lang/Object;)V", "isInitialized", "", "length", "", k.f247491e, "", "position", "buffer", "", "offset", "size", k.f247492f, "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IRandomAccessSource<T> extends Closeable {
    void copyFrom(InputStream input);

    void initialize(T data);

    boolean isInitialized();

    long length();

    int read(long position, byte[] buffer, int offset, int size);

    void write(long position, byte[] buffer, int offset, int size);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void initialize$default(IRandomAccessSource iRandomAccessSource, Object obj, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 1) != 0) {
                    obj = null;
                }
                iRandomAccessSource.initialize(obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initialize");
        }
    }
}
