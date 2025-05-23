package com.tencent.luggage.wxa.vm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements IMediaHTTPService {

    /* renamed from: b, reason: collision with root package name */
    private static final String f143714b = "MicroMsg.MMMediaHTTPService";

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f143715a = new ConcurrentHashMap();

    public void a(@NonNull String str, @Nullable String str2) {
        Logger.d(f143714b, "setReferrer, originUrl: " + str + ", referrer: " + str2);
        if (str2 == null) {
            str2 = "";
        }
        this.f143715a.put(str, str2);
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService
    public IMediaHTTPConnection makeHTTPConnection() {
        Logger.i(f143714b, "makeHTTPConnection");
        return new a(Collections.unmodifiableMap(this.f143715a));
    }
}
