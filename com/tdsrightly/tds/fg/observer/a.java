package com.tdsrightly.tds.fg.observer;

import android.app.Application;
import com.heytap.databaseengine.model.UserInfo;
import com.tdsrightly.tds.fg.FileLockNativeCore;
import com.tdsrightly.tds.fg.observer.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 -2\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bJ,\u0010\u0011\u001a\u00020\u00062\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000ej\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u000fH\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u001bR\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tdsrightly/tds/fg/observer/a;", "Lcom/tdsrightly/tds/fg/observer/d;", "Landroid/app/Application;", "app", "Lop/e;", "listener", "", "d", "", "getName", "", "getAppState", "reason", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "a", "Landroid/app/Application;", "e", "Lop/e;", "Lcom/tdsrightly/tds/fg/FileLockNativeCore;", "f", "Lcom/tdsrightly/tds/fg/FileLockNativeCore;", "processLock", "", h.F, "Z", "isInitSuccess", "i", "isFirstProcess", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "lastState", "", BdhLogUtil.LogTag.Tag_Conn, "J", "lastRefreshTime", "D", "disable", "E", "Ljava/lang/String;", "disableReason", "<init>", "()V", UserInfo.SEX_FEMALE, "fg_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class a implements d {

    /* renamed from: C, reason: from kotlin metadata */
    private long lastRefreshTime;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean disable;

    /* renamed from: E, reason: from kotlin metadata */
    private String disableReason = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Application app;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private op.e listener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FileLockNativeCore processLock;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isInitSuccess;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstProcess;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int lastState;

    @Override // com.tdsrightly.tds.fg.observer.d
    public void a(@NotNull HashMap<String, String> map) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(map, "map");
        map.put("App.disable", String.valueOf(this.disable));
        if (this.disableReason.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            map.put("firstComponent", this.disableReason);
        }
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    public void b(int i3, @NotNull d from) {
        Intrinsics.checkParameterIsNotNull(from, "from");
        d.a.c(this, i3, from);
    }

    public final void c(@NotNull String reason) {
        Intrinsics.checkParameterIsNotNull(reason, "reason");
        if (!this.disable) {
            this.disable = true;
            this.disableReason = reason;
            op.d.f423287g.k("FileLockObserver").b(2, this);
        }
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    public void d(@NotNull Application app, @NotNull op.e listener) {
        Intrinsics.checkParameterIsNotNull(app, "app");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.app = app;
        this.listener = listener;
        FileLockNativeCore fileLockNativeCore = new FileLockNativeCore();
        this.processLock = fileLockNativeCore;
        if (FileLockNativeCore.f61293b != 1) {
            op.d.f423287g.j().e("ApplicationLockObserver", "init processLock fail, so load fail");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        File filesDir = app.getFilesDir();
        Intrinsics.checkExpressionValueIsNotNull(filesDir, "app.filesDir");
        sb5.append(filesDir.getAbsolutePath());
        sb5.append(File.separator);
        sb5.append("App.Observer");
        int a16 = fileLockNativeCore.a(sb5.toString());
        if (a16 <= 0) {
            op.d.f423287g.j().e("ApplicationLockObserver", "init processLock fail,code=" + a16);
            return;
        }
        this.isInitSuccess = true;
        if (this.processLock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processLock");
        }
        this.isFirstProcess = !r5.b();
        FileLockNativeCore fileLockNativeCore2 = this.processLock;
        if (fileLockNativeCore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processLock");
        }
        fileLockNativeCore2.c(true);
        op.d.f423287g.k("FileLockObserver").b(getLastAppState(), this);
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    /* renamed from: getAppState */
    public int getLastAppState() {
        if (this.disable) {
            return 0;
        }
        if (System.nanoTime() - this.lastRefreshTime > 350000000) {
            this.lastRefreshTime = System.nanoTime();
            op.d dVar = op.d.f423287g;
            int lastAppState = dVar.k("ProcessObserver").getLastAppState();
            if (this.isFirstProcess && lastAppState == 0) {
                lastAppState = 1;
            }
            this.lastState = lastAppState;
            if (dVar.i().getIsDebug()) {
                dVar.j().d("ApplicationLockObserver", "refresh state, " + this.lastState);
            }
        }
        return this.lastState;
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    @NotNull
    public String getName() {
        return "ApplicationLockObserver";
    }
}
