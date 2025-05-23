package com.tencent.mobileqq.setting.processor;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.setting.processor.f;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.listitem.Group;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u000b\u001a\u00020\nH&J\u0006\u0010\u0016\u001a\u00020\u0005J\u0014\u0010\u0019\u001a\u00020\u00052\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0016J\u001c\u0010\u001c\u001a\u00020\u00052\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005J \u0010)\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001d2\b\u0010(\u001a\u0004\u0018\u00010'R#\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0*8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010-\u001a\u0004\b.\u0010/R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u000f048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u00102R\u0014\u00108\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/setting/processor/SettingConfigProvider;", "Lcom/tencent/mobileqq/setting/processor/g;", "Lcom/tencent/mobileqq/setting/processor/f;", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "g", "Lcom/tencent/mobileqq/setting/processor/d;", "lifecycle", tl.h.F, "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "l", "Lcom/tencent/mobileqq/setting/processor/a;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "", "Lcom/tencent/mobileqq/setting/processor/b;", "f", "i", "Lcom/tencent/mobileqq/widget/listitem/a;", DownloadInfo.spKey_Config, "c", "", "isVisible", "a", "", "type", "Lcom/tencent/mobileqq/setting/processor/c;", "d", "k", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "o", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "groupListLiveData", "b", "Ljava/util/List;", "groupProcessors", "", "configChangedListeners", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "<init>", "()V", "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class SettingConfigProvider implements g, f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Group[]> groupListLiveData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends b> groupProcessors;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.setting.processor.a> configChangedListeners;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReentrantLock lock;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f286705a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34958);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f286705a = iArr;
        }
    }

    public SettingConfigProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.groupListLiveData = new MutableLiveData<>();
        this.configChangedListeners = new ArrayList();
        this.lock = new ReentrantLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(Lifecycle.Event event) {
        List<? extends b> list = this.groupProcessors;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                h((b) it.next(), event);
            }
        }
    }

    private final void h(d lifecycle, Lifecycle.Event event) {
        int i3 = a.f286705a[event.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        lifecycle.onDestroy();
                        return;
                    }
                    return;
                }
                lifecycle.onPause();
                return;
            }
            lifecycle.onResume();
            return;
        }
        lifecycle.onCreate();
    }

    @Override // com.tencent.mobileqq.setting.processor.g
    public void a(@NotNull com.tencent.mobileqq.widget.listitem.a<?> config, boolean isVisible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, config, Boolean.valueOf(isVisible));
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Iterator<com.tencent.mobileqq.setting.processor.a> it = this.configChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().na(config, isVisible);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Nullable
    public View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (View) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return f.a.a(this);
    }

    @Override // com.tencent.mobileqq.setting.processor.g
    public void c(@NotNull com.tencent.mobileqq.widget.listitem.a<?> config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) config);
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Iterator<com.tencent.mobileqq.setting.processor.a> it = this.configChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().vb(config);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.f
    @Nullable
    public c d(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (c) iPatchRedirector.redirect((short) 10, (Object) this, type);
        }
        List<? extends b> list = this.groupProcessors;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                for (c cVar : ((b) it.next()).b()) {
                    if (cVar.j() == type) {
                        return cVar;
                    }
                }
            }
            return null;
        }
        return null;
    }

    @NotNull
    public abstract List<b> f(@NotNull Context context);

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<? extends b> list = this.groupProcessors;
        if (list != null) {
            for (b bVar : list) {
                ArrayList arrayList2 = new ArrayList();
                for (c cVar : bVar.b()) {
                    com.tencent.mobileqq.widget.listitem.a<?> q16 = cVar.q();
                    cVar.s(q16);
                    arrayList2.add(q16);
                }
                if (!arrayList2.isEmpty()) {
                    CharSequence c16 = bVar.c();
                    CharSequence a16 = bVar.a();
                    Object[] array = arrayList2.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
                    arrayList.add(new Group(c16, a16, (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)));
                }
            }
        }
        LiveData liveData = this.groupListLiveData;
        Object[] array2 = arrayList.toArray(new Group[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        liveData.postValue(array2);
    }

    @NotNull
    public final MutableLiveData<Group[]> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.groupListLiveData;
    }

    @Nullable
    public final List<b> k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.groupProcessors;
    }

    public final void l(@NotNull Context context, @NotNull LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) lifecycleOwner);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        List<b> f16 = f(context);
        this.groupProcessors = f16;
        if (f16 != null) {
            Iterator<T> it = f16.iterator();
            while (it.hasNext()) {
                for (c cVar : ((b) it.next()).b()) {
                    cVar.u(this);
                    cVar.t(this);
                }
            }
        }
        lifecycleOwner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.setting.processor.SettingConfigProvider$initProcessors$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SettingConfigProvider.this);
                }
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) source, (Object) event);
                    return;
                }
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                SettingConfigProvider.this.g(event);
            }
        });
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        List<? extends b> list = this.groupProcessors;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((b) it.next()).d();
            }
        }
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        List<? extends b> list = this.groupProcessors;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((b) it.next()).e();
            }
        }
    }

    public final void o(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        List<? extends b> list = this.groupProcessors;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((b) it.next()).f(requestCode, resultCode, data);
            }
        }
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        List<? extends b> list = this.groupProcessors;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((b) it.next()).g();
            }
        }
    }

    public final void q(@NotNull com.tencent.mobileqq.setting.processor.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.configChangedListeners.add(listener);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void r(@NotNull com.tencent.mobileqq.setting.processor.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.configChangedListeners.remove(listener);
        } finally {
            reentrantLock.unlock();
        }
    }
}
