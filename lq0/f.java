package lq0;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\n8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Llq0/f;", "", "Landroid/view/View;", "v", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "", "f", "", "toString", "", "a", "Z", "e", "()Z", "isShowNew", "b", "d", "isRobotService", "", "()I", "mDesc", "c", "mTitleId", "mDrawableId", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isShowNew;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isRobotService;

    public abstract int a();

    public abstract int b();

    public abstract int c();

    /* renamed from: d, reason: from getter */
    public boolean getIsRobotService() {
        return this.isRobotService;
    }

    /* renamed from: e, reason: from getter */
    public boolean getIsShowNew() {
        return this.isShowNew;
    }

    public abstract void f(@NotNull View v3, @NotNull com.tencent.aio.part.root.panel.mvx.config.c panelParam);

    @NotNull
    public String toString() {
        return "PluginData{drawable=" + b() + ", titleId='" + c() + "', desc='" + a() + "', isShowNew=" + getIsShowNew() + ", isRobotService='" + getIsRobotService() + "'}";
    }
}
