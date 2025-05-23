package com.tencent.aegiskmm;

import com.tencent.aegiskmm.bean.AegisConfig;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0012\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/aegiskmm/a;", "", "Lcom/tencent/aegiskmm/bean/b;", DownloadInfo.spKey_Config, "", "d", "", "msg", "stackTrace", "a", "", "Z", "c", "()Z", "e", "(Z)V", "reportSwitchDefaultValue", "Lcom/tencent/aegiskmm/CoreApiImpl;", "b", "Lcom/tencent/aegiskmm/CoreApiImpl;", "coreApiImpl", "Lcom/tencent/aegiskmm/utils/a;", "Lcom/tencent/aegiskmm/utils/a;", "()Lcom/tencent/aegiskmm/utils/a;", "setLogInstance", "(Lcom/tencent/aegiskmm/utils/a;)V", "logInstance", "<init>", "()V", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes37.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static boolean reportSwitchDefaultValue;

    /* renamed from: d, reason: collision with root package name */
    public static final a f61726d = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static CoreApiImpl coreApiImpl = new CoreApiImpl();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static com.tencent.aegiskmm.utils.a logInstance = new C0527a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/aegiskmm/a$a", "Lcom/tencent/aegiskmm/utils/a;", "", "tag", "msg", "", "d", "e", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.aegiskmm.a$a, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public static final class C0527a implements com.tencent.aegiskmm.utils.a {
        C0527a() {
        }

        @Override // com.tencent.aegiskmm.utils.a
        public void d(String tag, String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            KLog.INSTANCE.d(tag, msg2);
        }

        @Override // com.tencent.aegiskmm.utils.a
        public void e(String tag, String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            KLog.INSTANCE.e(tag, msg2);
        }
    }

    a() {
    }

    public final void a(String msg2, String stackTrace) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        coreApiImpl.c(msg2, stackTrace);
    }

    public final com.tencent.aegiskmm.utils.a b() {
        return logInstance;
    }

    public final boolean c() {
        return reportSwitchDefaultValue;
    }

    public final void d(AegisConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        coreApiImpl.i(config);
    }

    public final void e(boolean z16) {
        reportSwitchDefaultValue = z16;
    }
}
