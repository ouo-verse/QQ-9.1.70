package if3;

import android.app.Activity;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import te3.b;
import ye3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lif3/a;", "Lye3/a;", "Lye3/a$b;", DomainData.DOMAIN_NAME, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "width", "height", "", "bSync", "", "o0", "b", "Lye3/a$b;", "mLastSize", "<init>", "()V", "c", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements ye3.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private a.Size mLastSize;

    @Override // ye3.a
    public synchronized a.Size n() {
        QLog.i("BackBufferSizeImpl_", 1, "getLastBackBufferSize mLastSize" + this.mLastSize);
        return this.mLastSize;
    }

    @Override // ye3.a
    public synchronized void o0(Activity activity, int width, int height, boolean bSync) {
        QLog.i("BackBufferSizeImpl_", 1, "setBackBufferSize activity" + activity + ", width:" + width + ", height:" + height);
        this.mLastSize = new a.Size(width, height);
        b.f435891a.a(activity, width, height, bSync);
    }
}
