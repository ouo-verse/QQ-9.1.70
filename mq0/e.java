package mq0;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lmq0/e;", "Llq0/f;", "", "g", tl.h.F, "Landroid/view/View;", "v", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "", "f", "c", "I", "mUinType", "b", "()I", "mDrawableId", "mTitleId", "a", "mDesc", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class e extends lq0.f {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int mUinType;

    public e(int i3) {
        this.mUinType = i3;
    }

    @Override // lq0.f
    public int a() {
        return h();
    }

    @Override // lq0.f
    public int b() {
        return g();
    }

    @Override // lq0.f
    public int c() {
        return h();
    }

    @Override // lq0.f
    public void f(@NotNull View v3, @NotNull com.tencent.aio.part.root.panel.mvx.config.c panelParam) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        QLog.d(PlusPanelAppInfo.TAG, 1, PlusPanelAppInfo.TAG, "onPlusPanelAppClick titleId=" + c());
    }

    public abstract int g();

    public abstract int h();
}
