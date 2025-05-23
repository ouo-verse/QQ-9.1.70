package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.content.Context;
import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h implements f {

    /* renamed from: a, reason: collision with root package name */
    private Context f94209a;

    /* renamed from: b, reason: collision with root package name */
    private Uri f94210b;

    /* renamed from: c, reason: collision with root package name */
    private Uri f94211c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, String> f94212d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f94213e;

    public h(Context context, Uri uri, Map<String, String> map) {
        this.f94209a = context;
        this.f94210b = uri;
        this.f94212d = map;
    }

    @Override // com.tencent.biz.qqstory.playvideo.player.mediaplayer.f
    public e a() throws IOException {
        e eVar = new e();
        eVar.n(this.f94209a, this.f94210b, this.f94212d);
        return eVar;
    }

    @Override // com.tencent.biz.qqstory.playvideo.player.mediaplayer.f
    public e b() throws IOException {
        if (this.f94211c != null) {
            e eVar = new e();
            eVar.n(this.f94209a, this.f94211c, this.f94213e);
            return eVar;
        }
        return null;
    }
}
