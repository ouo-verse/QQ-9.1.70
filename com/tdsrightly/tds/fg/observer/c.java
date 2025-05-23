package com.tdsrightly.tds.fg.observer;

import android.app.Application;
import com.tdsrightly.tds.fg.FileLockNativeCore;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 &2\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0001H\u0016J,\u0010\u0012\u001a\u00020\u00062\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000fj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u0010H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tdsrightly/tds/fg/observer/c;", "Lcom/tdsrightly/tds/fg/observer/d;", "Landroid/app/Application;", "app", "Lop/e;", "listener", "", "d", "", "getName", "", "getAppState", "appState", "from", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "a", "Landroid/app/Application;", "Lcom/tdsrightly/tds/fg/FileLockNativeCore;", "e", "Lcom/tdsrightly/tds/fg/FileLockNativeCore;", "fileLock", "", "f", "Z", "isInitSuccess", h.F, "Ljava/lang/String;", "lastReason", "i", "I", "lastStatus", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "initCode", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "fg_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class c implements d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Application app;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FileLockNativeCore fileLock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isInitSuccess;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String lastReason = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int lastStatus;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int initCode;

    @Override // com.tdsrightly.tds.fg.observer.d
    public void a(@NotNull HashMap<String, String> map) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(map, "map");
        if (this.lastReason.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            map.put("Lock.From", this.lastReason);
            map.put("Lock.Status", String.valueOf(this.lastStatus));
        }
        if (!this.isInitSuccess) {
            map.put("Lock.So", String.valueOf(FileLockNativeCore.f61293b));
            map.put("Lock.SC", String.valueOf(this.initCode));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5.lastReason, r7.getName()) != false) goto L23;
     */
    @Override // com.tdsrightly.tds.fg.observer.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(int appState, @NotNull d from) {
        boolean z16;
        boolean z17;
        Intrinsics.checkParameterIsNotNull(from, "from");
        if (!Intrinsics.areEqual("FileLockObserver", from.getName()) && this.isInitSuccess && appState != 0) {
            boolean z18 = false;
            if (from instanceof a) {
                if (this.lastReason.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (this.lastReason.length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                    }
                }
                FileLockNativeCore fileLockNativeCore = this.fileLock;
                if (fileLockNativeCore == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileLock");
                }
                if (appState == 1) {
                    z18 = true;
                }
                fileLockNativeCore.c(z18);
            } else {
                FileLockNativeCore fileLockNativeCore2 = this.fileLock;
                if (fileLockNativeCore2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileLock");
                }
                if (appState == 1) {
                    z18 = true;
                }
                fileLockNativeCore2.c(z18);
            }
            this.lastReason = from.getName();
            this.lastStatus = appState;
        }
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    public void d(@NotNull Application app, @NotNull op.e listener) {
        Intrinsics.checkParameterIsNotNull(app, "app");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.app = app;
        FileLockNativeCore fileLockNativeCore = new FileLockNativeCore();
        this.fileLock = fileLockNativeCore;
        if (FileLockNativeCore.f61293b != 1) {
            op.d.f423287g.j().e("FileLockObserver", "init fileLockLib fail, so load fail");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        File filesDir = app.getFilesDir();
        Intrinsics.checkExpressionValueIsNotNull(filesDir, "app.filesDir");
        sb5.append(filesDir.getAbsolutePath());
        sb5.append(File.separator);
        sb5.append("Rightly.tds");
        int a16 = fileLockNativeCore.a(sb5.toString());
        this.initCode = a16;
        if (a16 <= 0) {
            op.d.f423287g.j().e("FileLockObserver", "init fileLockLib fail,code=" + this.initCode);
            return;
        }
        this.isInitSuccess = true;
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    /* renamed from: getAppState */
    public int getLastAppState() {
        if (this.isInitSuccess && FileLockNativeCore.f61293b == 1) {
            FileLockNativeCore fileLockNativeCore = this.fileLock;
            if (fileLockNativeCore == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileLock");
            }
            if (fileLockNativeCore.b()) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    @Override // com.tdsrightly.tds.fg.observer.d
    @NotNull
    public String getName() {
        return "FileLockObserver";
    }
}
