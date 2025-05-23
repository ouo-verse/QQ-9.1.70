package com.tencent.aelight.camera.ae.flashshow.autotest;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u001b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001cB\t\b\u0002\u00a2\u0006\u0004\b4\u00105J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004J\u001e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\bJ\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015J\u0014\u0010\u0019\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\bR \u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00170\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010&\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010%R\u0016\u0010(\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010%R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010*R\"\u00100\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010*\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00103\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010*\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/\u00a8\u00066"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/autotest/f;", "", "Lcom/tencent/aelight/camera/ae/flashshow/autotest/g;", "g", "", "nodes", "", "isAllImage", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", tl.h.F, "node", "o", "f", "", "renderId", "width", "height", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/Observer;", "observer", "e", "k", "", "a", "Ljava/util/List;", "observers", "b", "Landroidx/lifecycle/MutableLiveData;", "mCurrentNodeLiveData", "c", "mLoadingLiveData", "d", "I", "mFrameCount", "recordNodeSize", "currentPos", "mCurrentNodeList", "Z", "isAllImageMode", "j", "()Z", "p", "(Z)V", "isImageLoaded", "getNeedRecord", "setNeedRecord", "needRecord", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class f {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: collision with root package name */
    private static f f64162l;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<Observer<g>> observers;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<g> mCurrentNodeLiveData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> mLoadingLiveData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mFrameCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int recordNodeSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int currentPos;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private List<g> mCurrentNodeList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isAllImageMode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isImageLoaded;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean needRecord;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00028B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/autotest/f$a;", "", "Lcom/tencent/aelight/camera/ae/flashshow/autotest/f;", "a", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/aelight/camera/ae/flashshow/autotest/f;", "b", "()Lcom/tencent/aelight/camera/ae/flashshow/autotest/f;", "", "MAX_FRAME_COUNT_PER_PHOTO", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.ae.flashshow.autotest.f$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final f b() {
            if (f.f64162l == null) {
                f.f64162l = new f(null);
            }
            return f.f64162l;
        }

        public final synchronized f a() {
            f b16;
            b16 = b();
            Intrinsics.checkNotNull(b16);
            return b16;
        }

        Companion() {
        }
    }

    public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final g g() {
        return this.mCurrentNodeLiveData.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = this$0.observers.iterator();
        while (it.hasNext()) {
            this$0.mCurrentNodeLiveData.removeObserver((Observer) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(f this$0, g gVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b.f64141g = true;
        b.f64150p = true;
        this$0.isImageLoaded = false;
    }

    public final void e(Observer<g> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.add(observer);
        this.mCurrentNodeLiveData.observeForever(observer);
    }

    public final List<g> f() {
        return this.mCurrentNodeList;
    }

    public final String h() {
        String e16;
        g g16 = g();
        return (g16 == null || (e16 = g16.e()) == null) ? "" : e16;
    }

    public final MutableLiveData<Boolean> i() {
        return this.mLoadingLiveData;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsImageLoaded() {
        return this.isImageLoaded;
    }

    public final void k() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.autotest.e
            @Override // java.lang.Runnable
            public final void run() {
                f.l(f.this);
            }
        });
    }

    public final void m(List<g> nodes, boolean isAllImage) {
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        this.mCurrentNodeList = nodes;
        this.isAllImageMode = isAllImage;
        if (isAllImage) {
            e(new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.autotest.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    f.n(f.this, (g) obj);
                }
            });
            q();
        }
    }

    public final void o(g node) {
        g g16;
        Intrinsics.checkNotNullParameter(node, "node");
        ms.a.f("VideoCameraProxy", " node = " + node.e());
        if (b.f64152r && (g16 = g()) != null) {
            if (g16.getEncodeConfig() != null) {
                g16.i();
            } else {
                this.needRecord = true;
            }
            List<g> f16 = f();
            if (f16 != null && this.recordNodeSize == f16.size()) {
                this.needRecord = false;
                i().postValue(Boolean.FALSE);
                b.f64152r = false;
                this.recordNodeSize = 0;
            }
            this.recordNodeSize++;
        }
        this.mCurrentNodeLiveData.postValue(node);
    }

    public final void p(boolean z16) {
        this.isImageLoaded = z16;
    }

    public final void q() {
        int i3;
        List<g> list = this.mCurrentNodeList;
        if (list != null) {
            int size = (this.currentPos + 1) % list.size();
            this.currentPos = size;
            ms.a.f("VideoCameraProxy", "currentPos = " + size + " node = " + list.get(size).e());
            if (this.currentPos >= list.size() || (i3 = this.currentPos) < 0) {
                return;
            }
            o(list.get(i3));
        }
    }

    public final void r(int renderId, int width, int height) {
        g g16;
        if (this.isAllImageMode) {
            int i3 = this.mFrameCount + 1;
            this.mFrameCount = i3;
            if (i3 == 30) {
                this.mFrameCount = 0;
                q();
            }
        }
        if (!this.needRecord || (g16 = g()) == null) {
            return;
        }
        g16.g(renderId, width, height);
    }

    f() {
        this.observers = new ArrayList();
        this.mCurrentNodeLiveData = new MutableLiveData<>();
        this.mLoadingLiveData = new MutableLiveData<>();
        this.currentPos = -1;
    }
}
