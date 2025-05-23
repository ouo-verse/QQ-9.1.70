package com.tencent.sqshow.zootopia.player;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0002J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\nR&\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\n0\u000ej\b\u0012\u0004\u0012\u00020\n`\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010R$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u000ej\b\u0012\u0004\u0012\u00020\u0003`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010R$\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000ej\b\u0012\u0004\u0012\u00020\u0007`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/e;", "", "", "Lka4/b;", "e", "prePrepareListener", "b", "Lka4/a;", "d", "a", "Lma4/a;", "f", "sdkInitListener", "c", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "sDKInitListeners", "playerPrepareListeners", "errorPrepareListeners", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ArrayList<ma4.a> sDKInitListeners = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<ka4.b> playerPrepareListeners = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<ka4.a> errorPrepareListeners = new ArrayList<>();

    public final synchronized e a(ka4.a prePrepareListener) {
        if (prePrepareListener == null) {
            return this;
        }
        this.errorPrepareListeners.add(prePrepareListener);
        return this;
    }

    public final synchronized e b(ka4.b prePrepareListener) {
        if (prePrepareListener == null) {
            return this;
        }
        this.playerPrepareListeners.add(prePrepareListener);
        return this;
    }

    public final synchronized e c(ma4.a sdkInitListener) {
        if (sdkInitListener == null) {
            return this;
        }
        this.sDKInitListeners.add(sdkInitListener);
        return this;
    }

    public final List<ka4.a> d() {
        return this.errorPrepareListeners;
    }

    public final List<ka4.b> e() {
        return this.playerPrepareListeners;
    }

    public final List<ma4.a> f() {
        return this.sDKInitListeners;
    }
}
