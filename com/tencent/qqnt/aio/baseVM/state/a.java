package com.tencent.qqnt.aio.baseVM.state;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.mvi.MviUIState;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J$\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016RB\u0010\u0010\u001a.\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\r0\fj\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\r`\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000fRB\u0010\u0011\u001a.\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0018\u00010\r0\fj\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0018\u00010\r`\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/baseVM/state/a;", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "", "Landroidx/lifecycle/LiveData;", "stateLiveData", "Landroidx/lifecycle/Observer;", "observer", "", "b", "", "a", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "wLiveDataList", "wObserverList", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a<S extends MviUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<WeakReference<LiveData<S>>> wLiveDataList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<WeakReference<Observer<S>>> wObserverList;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.wLiveDataList = new ArrayList<>();
            this.wObserverList = new ArrayList<>();
        }
    }

    public void a() {
        LiveData<S> liveData;
        Observer<S> observer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        int size = this.wLiveDataList.size();
        for (int i3 = 0; i3 < size; i3++) {
            WeakReference<LiveData<S>> weakReference = this.wLiveDataList.get(i3);
            WeakReference<Observer<S>> weakReference2 = this.wObserverList.get(i3);
            if (weakReference != null && (liveData = weakReference.get()) != null && weakReference2 != null && (observer = weakReference2.get()) != null) {
                liveData.removeObserver(observer);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(@NotNull LiveData<S> stateLiveData, @NotNull Observer<S> observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) stateLiveData, (Object) observer)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(stateLiveData, "stateLiveData");
        Intrinsics.checkNotNullParameter(observer, "observer");
        stateLiveData.observeForever(observer);
        this.wLiveDataList.add(new WeakReference<>(stateLiveData));
        this.wObserverList.add(new WeakReference<>(observer));
        return true;
    }
}
