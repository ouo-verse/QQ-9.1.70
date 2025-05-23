package eu2;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\bR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Leu2/e;", "", "", "g", "f", h.F, "", "seq", "", "i", "c", "j", "d", "k", "e", "a", "b", "Ljava/lang/Integer;", "loginSeq", "logoutSeq", "refreshSeq", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile Integer loginSeq;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile Integer logoutSeq;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile Integer refreshSeq;

    public final void a() {
        Integer num = this.refreshSeq;
        if (num != null) {
            VSNetworkHelper.getInstance().cancelRequest(RFWApplication.getApplication(), num.intValue());
        }
        this.refreshSeq = null;
    }

    public final void b() {
        Integer num = this.refreshSeq;
        if (num != null) {
            VSNetworkHelper.getInstance().cancelRequest(RFWApplication.getApplication(), num.intValue());
        }
        Integer num2 = this.logoutSeq;
        if (num2 != null) {
            VSNetworkHelper.getInstance().cancelRequest(RFWApplication.getApplication(), num2.intValue());
        }
        Integer num3 = this.loginSeq;
        if (num3 != null) {
            VSNetworkHelper.getInstance().cancelRequest(RFWApplication.getApplication(), num3.intValue());
        }
        this.refreshSeq = null;
        this.loginSeq = null;
        this.logoutSeq = null;
    }

    public final void c() {
        this.loginSeq = null;
    }

    public final void d() {
        this.logoutSeq = null;
    }

    public final void e() {
        this.refreshSeq = null;
    }

    public final boolean f() {
        if (this.loginSeq == null && this.logoutSeq == null && this.refreshSeq == null) {
            return false;
        }
        return true;
    }

    public final boolean g() {
        if (this.loginSeq == null && this.logoutSeq == null) {
            return false;
        }
        return true;
    }

    public final boolean h() {
        if (this.refreshSeq != null) {
            return true;
        }
        return false;
    }

    public final void i(int seq) {
        this.loginSeq = Integer.valueOf(seq);
    }

    public final void j(int seq) {
        this.logoutSeq = Integer.valueOf(seq);
    }

    public final void k(int seq) {
        this.refreshSeq = Integer.valueOf(seq);
    }
}
