package m72;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import com.tencent.qqnt.http.api.m;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lm72/b;", "Lm72/a;", "Lm72/c;", "Lm72/d;", "p", "", "b", "c", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class b implements a<c, d> {
    public boolean b(c p16) {
        Intrinsics.checkNotNullParameter(p16, "p");
        if (p16.getSaveFilePath().length() == 0) {
            return false;
        }
        File file = new File(p16.getSaveFilePath());
        return file.isFile() && file.exists();
    }

    @Override // m72.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d a(c p16) {
        Intrinsics.checkNotNullParameter(p16, "p");
        d dVar = new d(p16);
        if (!(p16.getSaveFilePath().length() == 0)) {
            if (b(p16)) {
                dVar.a(true, "");
            } else {
                m syncExecute = ((IHttpService) QRoute.api(IHttpService.class)).syncExecute(new b.a("relationship_pag_downloader", p16.getUrl(), new File(p16.getSaveFilePath())).c());
                boolean e16 = syncExecute.e();
                String b16 = syncExecute.b();
                dVar.a(e16, b16 != null ? b16 : "");
            }
        }
        return dVar;
    }
}
