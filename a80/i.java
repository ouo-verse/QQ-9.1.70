package a80;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.views.x;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.libpag.PAGFile;
import org.libpag.PAGImage;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private final List<Object> f25652a;

    /* renamed from: b, reason: collision with root package name */
    private final List<PAGFile> f25653b;

    /* renamed from: c, reason: collision with root package name */
    public final MutableLiveData<Boolean> f25654c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f25655d;

    /* renamed from: e, reason: collision with root package name */
    private Function0<Unit> f25656e;

    public i(List<Object> list) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f25652a = copyOnWriteArrayList;
        this.f25653b = new CopyOnWriteArrayList();
        this.f25654c = new MutableLiveData<>(null);
        this.f25655d = new AtomicBoolean(false);
        if (list != null) {
            copyOnWriteArrayList.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Context context) {
        if (!x.c()) {
            QLog.w("QFSPagAnimationV.PAGResPackage", 1, "init file checkPagSoRead return false");
            this.f25654c.postValue(Boolean.FALSE);
            this.f25655d.set(false);
            return;
        }
        ArrayList arrayList = new ArrayList(this.f25652a);
        if (arrayList.isEmpty()) {
            this.f25654c.postValue(Boolean.TRUE);
        }
        this.f25653b.clear();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            Object obj = arrayList.get(i3);
            PAGFile e16 = x.e(context, obj);
            if (e16 != null) {
                this.f25653b.add(e16);
            } else {
                RFWLog.d("QFSPagAnimationV.PAGResPackage", RFWLog.USR, "[tryLoadPagFile] load file error:" + obj);
                this.f25654c.postValue(Boolean.FALSE);
                this.f25655d.set(false);
                return;
            }
        }
        this.f25654c.postValue(Boolean.TRUE);
        this.f25655d.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit g(final Context context) {
        QLog.d("QFSPagAnimationV.PAGResPackage", 2, "[tryLoadPagFile] run mInitPagListener");
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: a80.h
            @Override // java.lang.Runnable
            public final void run() {
                i.this.f(context);
            }
        });
        return null;
    }

    @NonNull
    public List<Object> c() {
        return this.f25652a;
    }

    @NonNull
    public List<PAGFile> d() {
        return this.f25653b;
    }

    public boolean e() {
        Boolean value = this.f25654c.getValue();
        if (value != null && value.booleanValue()) {
            return true;
        }
        return false;
    }

    public void h(int i3, PAGImage pAGImage, QFSPagAnimView.d dVar) {
        if (!e()) {
            QLog.e("QFSPagAnimationV.PAGResPackage", 1, "replacePagImage isFileLoadSucceed false");
            return;
        }
        ArrayList arrayList = new ArrayList(this.f25653b);
        if (arrayList.size() > i3 && arrayList.get(i3) != null) {
            ((PAGFile) arrayList.get(i3)).replaceImage(i3, pAGImage);
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    public void i(final Context context) {
        if (!this.f25655d.compareAndSet(false, true)) {
            QLog.d("QFSPagAnimationV.PAGResPackage", 2, "[tryLoadPagFile] is load ing");
        } else {
            if (e()) {
                return;
            }
            this.f25656e = new Function0() { // from class: a80.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit g16;
                    g16 = i.this.g(context);
                    return g16;
                }
            };
            x.g(new WeakReference(this.f25656e));
        }
    }
}
