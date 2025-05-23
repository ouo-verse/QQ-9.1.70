package com.tencent.biz.qqcircle.comment.recpic;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0002\u0005\u000fB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/al;", "Landroid/database/ContentObserver;", "Lcom/tencent/biz/qqcircle/comment/recpic/al$b;", "listener", "", "a", "", "selfChange", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "onChange", "", "J", "lastNotifyTime", "", "b", "Ljava/lang/String;", "uriPath", "c", "Lcom/tencent/biz/qqcircle/comment/recpic/al$b;", "Landroid/os/Handler;", "handler", "<init>", "(Landroid/os/Handler;)V", "d", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class al extends ContentObserver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long lastNotifyTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String uriPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/al$b;", "", "", "F3", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface b {
        void F3();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(@NotNull Handler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.uriPath = "";
    }

    public final void a(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange, @Nullable Uri uri) {
        String str;
        super.onChange(selfChange, uri);
        if (uri != null) {
            str = uri.getPath();
        } else {
            str = null;
        }
        if (System.currentTimeMillis() - this.lastNotifyTime >= 1000 && !Intrinsics.areEqual(str, this.uriPath)) {
            this.lastNotifyTime = System.currentTimeMillis();
            this.uriPath = str;
            QLog.d("QFSScreenShotContentObserver", 1, "screen shot, path: " + str + ", hashcode: " + hashCode());
            b bVar = this.listener;
            if (bVar != null) {
                bVar.F3();
                return;
            }
            return;
        }
        QLog.d("QFSScreenShotContentObserver", 1, "screen shot too fast, path: " + str + ", hashcode: " + hashCode());
    }
}
