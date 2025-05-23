package ou2;

import com.tencent.tvideo.protocol.pb.DynamicAdProxyRequest;
import com.tencent.tvideo.protocol.pb.DynamicAdProxyResponse;
import ev2.i;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a implements pv2.a<DynamicAdProxyRequest, DynamicAdProxyResponse> {

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC10960a f424095a;

    /* compiled from: P */
    /* renamed from: ou2.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC10960a {
        void b(int i3, boolean z16, DynamicAdProxyRequest dynamicAdProxyRequest, DynamicAdProxyResponse dynamicAdProxyResponse);
    }

    @Override // pv2.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(DynamicAdProxyRequest dynamicAdProxyRequest, DynamicAdProxyResponse dynamicAdProxyResponse, int i3) {
        InterfaceC10960a interfaceC10960a = this.f424095a;
        if (interfaceC10960a != null) {
            interfaceC10960a.b(i3, false, dynamicAdProxyRequest, dynamicAdProxyResponse);
        }
    }

    @Override // pv2.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(DynamicAdProxyRequest dynamicAdProxyRequest, DynamicAdProxyResponse dynamicAdProxyResponse) {
        InterfaceC10960a interfaceC10960a = this.f424095a;
        if (interfaceC10960a != null) {
            interfaceC10960a.b(0, false, dynamicAdProxyRequest, dynamicAdProxyResponse);
        }
    }

    public int e(DynamicAdProxyRequest dynamicAdProxyRequest, InterfaceC10960a interfaceC10960a) {
        if (dynamicAdProxyRequest != null && interfaceC10960a != null) {
            this.f424095a = interfaceC10960a;
            return i.b(dynamicAdProxyRequest, this);
        }
        return 0;
    }
}
