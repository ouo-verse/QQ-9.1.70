package cd0;

import android.os.Bundle;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a<REQ extends MessageMicro> extends com.tencent.biz.qqstory.channel.c<dd0.a> {

    /* renamed from: f, reason: collision with root package name */
    public final Bundle f30707f;

    /* renamed from: g, reason: collision with root package name */
    public final REQ f30708g;

    /* renamed from: h, reason: collision with root package name */
    public final String f30709h;

    public a(String str, REQ req, Bundle bundle) {
        this.f30709h = str;
        this.f30708g = req;
        this.f30707f = bundle;
    }

    @Override // com.tencent.biz.qqstory.channel.c
    public String a() {
        return this.f30709h;
    }

    @Override // com.tencent.biz.qqstory.channel.c
    public com.tencent.biz.qqstory.channel.a c(byte[] bArr) {
        return new dd0.a(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.channel.c
    public byte[] d() {
        return this.f30708g.toByteArray();
    }
}
