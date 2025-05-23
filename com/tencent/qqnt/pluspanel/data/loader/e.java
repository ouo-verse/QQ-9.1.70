package com.tencent.qqnt.pluspanel.data.loader;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0015R$\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0017j\b\u0012\u0004\u0012\u00020\n`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019R&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u0017j\b\u0012\u0004\u0012\u00020\u001b`\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/loader/e;", "", "", "e", "", "uinType", "", "curFriendUin", "f", "", "Lcom/tencent/qqnt/pluspanel/data/appinfo/PlusPanelAppInfo;", "c", "appInfo", "b", "index", "a", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/pluspanel/data/a;", "d", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "mAppInfoListLock", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mAppInfoList", "Lmx3/a;", "mFilters", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public abstract class e {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReentrantReadWriteLock mAppInfoListLock;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<PlusPanelAppInfo> mAppInfoList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<mx3.a> mFilters;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/loader/e$a;", "", "", "SWITCH_USE_WHITE_BG", "Ljava/lang/String;", "TAG", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.pluspanel.data.loader.e$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40085);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mAppInfoListLock = new ReentrantReadWriteLock();
        this.mAppInfoList = new ArrayList<>();
        this.mFilters = new ArrayList<>();
    }

    public void a(int index, @Nullable PlusPanelAppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, index, (Object) appInfo);
            return;
        }
        this.mAppInfoListLock.writeLock().lock();
        if (appInfo != null) {
            try {
                if (appInfo.getAppID() > 0) {
                    if (index >= 0) {
                        this.mAppInfoList.add(index, appInfo);
                    } else {
                        this.mAppInfoList.add(appInfo);
                    }
                }
            } finally {
                this.mAppInfoListLock.writeLock().unlock();
            }
        }
    }

    public void b(@Nullable PlusPanelAppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) appInfo);
        } else {
            a(-1, appInfo);
        }
    }

    @NotNull
    public final List<PlusPanelAppInfo> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        this.mAppInfoListLock.readLock().lock();
        try {
            Object clone = this.mAppInfoList.clone();
            Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo>");
            return (List) clone;
        } finally {
            this.mAppInfoListLock.readLock().unlock();
        }
    }

    @Nullable
    public abstract com.tencent.qqnt.pluspanel.data.a d(@NotNull PlusPanelAppInfo appInfo, int index, @NotNull Context context);

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mAppInfoListLock.writeLock().lock();
        try {
            this.mAppInfoList.clear();
        } finally {
            this.mAppInfoListLock.writeLock().unlock();
        }
    }

    public void f(int uinType, @NotNull String curFriendUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, uinType, (Object) curFriendUin);
            return;
        }
        Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
        Iterator<mx3.a> it = this.mFilters.iterator();
        while (it.hasNext()) {
            it.next().a(this, uinType, curFriendUin);
        }
    }
}
