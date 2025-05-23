package cooperation.vip.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.SsoElement;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes28.dex */
public class g {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f391288d;

        a(b bVar) {
            this.f391288d = bVar;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && i3 == 0 && obj != null) {
                this.f391288d.a(g.this.a(obj));
                return;
            }
            QLog.e("NovelRequestManager", 1, "getNovelSpeciesValue isSuccess = " + z16 + " type = " + i3 + " data " + obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface b {
        void a(c cVar);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public String f391290a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f391291b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f391292c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f391293d = "";

        /* renamed from: e, reason: collision with root package name */
        public int f391294e = 0;

        public c() {
        }

        public boolean a() {
            if (!TextUtils.isEmpty(this.f391290a) && !TextUtils.isEmpty(this.f391291b) && !TextUtils.isEmpty(this.f391292c) && !TextUtils.isEmpty(this.f391293d)) {
                return false;
            }
            return true;
        }
    }

    public c a(Object obj) {
        SsoElement.AIOEntraceRsp aIOEntraceRsp = new SsoElement.AIOEntraceRsp();
        c cVar = new c();
        try {
            aIOEntraceRsp.mergeFrom((byte[]) obj);
            cVar.f391290a = aIOEntraceRsp.content.get();
            cVar.f391291b = aIOEntraceRsp.element_pic.get();
            cVar.f391292c = aIOEntraceRsp.main_title.get();
            cVar.f391293d = aIOEntraceRsp.tag_pic.get();
            cVar.f391294e = aIOEntraceRsp.element_count.get();
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("NovelRequestManager", 1, "mergeFrom e " + e16);
        }
        return cVar;
    }

    public void b(long j3, int i3, b bVar) {
        SsoElement.AIOEntraceReq aIOEntraceReq = new SsoElement.AIOEntraceReq();
        aIOEntraceReq.co_adopter.set(j3);
        aIOEntraceReq.version.set(i3);
        try {
            VasUtil.getService().getPbRequest().request("trpc.qqva.freshelement.SsoElement.SsoGetAIOEntrance", new String(aIOEntraceReq.toByteArray(), "ISO8859_1"), new a(bVar));
        } catch (UnsupportedEncodingException e16) {
            QLog.e("NovelRequestManager", 1, "request e " + e16);
        }
    }
}
