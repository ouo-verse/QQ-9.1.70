package com.tencent.luggage.wxa.um;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qb.f;
import com.tencent.qqmusic.mediaplayer.upstream.DataSourceException;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements IDataSourceFactory {

    /* renamed from: a, reason: collision with root package name */
    public f f142828a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f142829b;

    /* renamed from: c, reason: collision with root package name */
    public String f142830c;

    public c(f fVar) {
        this.f142828a = fVar;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory
    public IDataSource createDataSource() throws DataSourceException {
        ByteBuffer byteBuffer = this.f142829b;
        if (byteBuffer != null) {
            return new a(byteBuffer, this.f142830c);
        }
        return new b(this.f142828a);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory
    @Nullable
    public INativeDataSource createNativeDataSource() throws DataSourceException {
        return null;
    }

    public c(ByteBuffer byteBuffer, String str) {
        this.f142829b = byteBuffer;
        this.f142830c = str;
    }
}
