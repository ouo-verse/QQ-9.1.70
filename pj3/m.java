package pj3;

import android.os.SystemClock;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.mobileqq.zplan.utils.am;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ6\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lpj3/m;", "Ldl0/l;", "", "url", "saveDirectoryPath", "", "header", "Lgl0/a;", "listener", "", "a", "Ljava/lang/String;", "tmpDir", "<init>", "()V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class m implements dl0.l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String tmpDir = am.f335779a.a() + "/tmp";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"pj3/m$b", "Lcom/tencent/mobileqq/zootopia/download/ah;", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "", "c", "", "code", tl.h.F, "", "b", "J", "beginEnqueue", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b extends ah {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long beginEnqueue;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f426339c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ gl0.a f426340d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, gl0.a aVar) {
            super(null, 1, null);
            this.f426339c = str;
            this.f426340d = aVar;
            this.beginEnqueue = SystemClock.uptimeMillis();
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void c(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            super.c(task);
            long uptimeMillis = SystemClock.uptimeMillis() - this.beginEnqueue;
            if (QLog.isDebugVersion()) {
                QLog.i("QQZPlanFilamentDownloadProxy", 1, "download onComplete " + task.m() + ", [timecost=" + uptimeMillis + "][url=" + this.f426339c + "]");
            }
            this.f426340d.a(task.m(), 200, task.getHttpRspHeaderMap());
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void h(int code, x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            super.h(code, task);
            QLog.e("QQZPlanFilamentDownloadProxy", 1, "download onFailed, url=" + this.f426339c + ", failCode=" + task.getDownloadFailCode() + ", failInfo=" + task.getDownloadFailInfo());
            if (code != 304 && code != 404) {
                this.f426340d.b("failInfo: " + task.getDownloadFailInfo() + ", failCode: " + task.getDownloadFailCode());
                return;
            }
            this.f426340d.a(null, code, task.getHttpRspHeaderMap());
        }
    }

    @Override // dl0.l
    public void a(String url, String saveDirectoryPath, Map<String, String> header, gl0.a listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(saveDirectoryPath, "saveDirectoryPath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (QLog.isDebugVersion()) {
            QLog.i("QQZPlanFilamentDownloadProxy", 1, "download start. url: " + url + ", header: " + header);
        }
        ZPlanFileDownloadUtil.f328039a.f(ZPlanFileCategory.FILAMENT.getValue(), url, this.tmpDir, com.tencent.zplan.common.utils.d.c(url), "", header, Boolean.TRUE, new b(url, listener));
    }
}
