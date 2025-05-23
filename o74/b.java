package o74;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lo74/b;", "", "Lcom/tencent/common/app/AppInterface;", "a", "Lcom/tencent/common/app/AppInterface;", "appInterface", "Landroid/content/Intent;", "b", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "c", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "", "d", "[B", "data", "Lcom/tencent/sqshow/servlet/ZPlanRequestHandler;", "e", "Lcom/tencent/sqshow/servlet/ZPlanRequestHandler;", "handler", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public AppInterface appInterface;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Intent request;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public FromServiceMsg response;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public byte[] data = new byte[0];

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public ZPlanRequestHandler handler;
}
