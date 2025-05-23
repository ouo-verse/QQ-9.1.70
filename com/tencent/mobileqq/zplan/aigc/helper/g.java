package com.tencent.mobileqq.zplan.aigc.helper;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentSuitRender;
import com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.view.history.PortalStoreHistoryControllerView;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import qu4.p;
import w74.UgcColorInfoData;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \r2\u00020\u0001:\u0002)\u0016B\u0007\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J,\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0006\u0010\u0017\u001a\u00020\tJ\u0016\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0002J\u001e\u0010\u001f\u001a\u00020\u00042\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u001cj\b\u0012\u0004\u0012\u00020\u0018`\u001dJ\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\"\u001a\u0004\u0018\u00010\u0006J\u0014\u0010%\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u0013J\u0006\u0010&\u001a\u00020\u0002R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010,R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010.R\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/g;", "", "", "targetIndex", "", tl.h.F, "Lw74/b;", "colorInfo", "k", "", "bUpdate", "Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentSuitRender;", "filamentRender", "e", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/tencent/sqshow/zootopia/nativeui/view/history/PortalStoreHistoryControllerView;", "view", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel;", "viewModel", "b", "g", "Lqu4/p;", "singeColor", "index", DomainData.DOMAIN_NAME, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "initColors", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "j", "c", "Lcom/tencent/mobileqq/zplan/aigc/helper/g$b;", "listener", "o", "d", "Landroidx/lifecycle/MutableLiveData;", "Lw74/a;", "a", "Landroidx/lifecycle/MutableLiveData;", "historyData", "Lmqq/util/WeakReference;", "vm", "Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentSuitRender;", "mListener", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<w74.a> historyData = new MutableLiveData<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private WeakReference<SuitCustomColorVewModel> vm;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ZplanFilamentSuitRender filamentRender;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WeakReference<b> mListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/g$b;", "", "Lw74/b;", "colorInfo", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void a(UgcColorInfoData colorInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(g this$0, int i3, boolean z16, UgcColorInfoData ugcColorInfoData, ZplanFilamentSuitRender filamentRender) {
        b bVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(filamentRender, "$filamentRender");
        WeakReference<SuitCustomColorVewModel> weakReference = null;
        l(this$0, i3, null, 2, null);
        if (z16 && ugcColorInfoData != null) {
            WeakReference<SuitCustomColorVewModel> weakReference2 = this$0.vm;
            if (weakReference2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
            } else {
                weakReference = weakReference2;
            }
            SuitCustomColorVewModel suitCustomColorVewModel = weakReference.get();
            if (suitCustomColorVewModel != null) {
                SuitCustomColorVewModel.A3(suitCustomColorVewModel, ugcColorInfoData.b(), filamentRender, null, 4, null);
            }
            WeakReference<b> weakReference3 = this$0.mListener;
            if (weakReference3 != null && (bVar = weakReference3.get()) != null) {
                bVar.a(ugcColorInfoData);
            }
        }
        QLog.i("UgcColorEditorHelper", 1, "handleUgcColorTask newHistoryData:" + ugcColorInfoData);
    }

    private final void h(int targetIndex) {
        w74.a value = this.historyData.getValue();
        ZplanFilamentSuitRender zplanFilamentSuitRender = null;
        Integer valueOf = value != null ? Integer.valueOf(value.getHistoryCursor()) : null;
        w74.a value2 = this.historyData.getValue();
        QLog.i("UgcColorEditorHelper", 1, "moveToHistory targetIndex:" + targetIndex + ", mHistoryCursor:" + valueOf + ", historySize:" + (value2 != null ? Integer.valueOf(value2.g()) : null));
        w74.a value3 = this.historyData.getValue();
        if ((value3 != null ? value3.g() : 0) == 0) {
            return;
        }
        if (targetIndex < -1) {
            return;
        }
        w74.a value4 = this.historyData.getValue();
        if (targetIndex >= (value4 != null ? value4.g() : -1)) {
            return;
        }
        ZplanFilamentSuitRender zplanFilamentSuitRender2 = this.filamentRender;
        if (zplanFilamentSuitRender2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filamentRender");
        } else {
            zplanFilamentSuitRender = zplanFilamentSuitRender2;
        }
        e(targetIndex, true, zplanFilamentSuitRender);
    }

    private final void k(int targetIndex, UgcColorInfoData colorInfo) {
        QLog.i("UgcColorEditorHelper", 1, "recordHistory targetIndex:" + targetIndex + ", colorInfo:" + colorInfo);
        w74.a value = this.historyData.getValue();
        if (colorInfo != null) {
            if (value != null) {
                value.i(targetIndex, colorInfo);
            }
        } else if (value != null) {
            value.h(targetIndex);
        }
        if (value != null) {
            this.historyData.postValue(value);
        }
        QLog.i("UgcColorEditorHelper", 1, "recordHistory newHistoryData:" + this.historyData.getValue());
    }

    public final void b(LifecycleOwner owner, PortalStoreHistoryControllerView view, ZplanFilamentSuitRender render, WeakReference<SuitCustomColorVewModel> viewModel) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(render, "render");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.filamentRender = render;
        this.vm = viewModel;
        this.historyData.setValue(new w74.a(null, 0, 3, null));
        view.n(owner, this.historyData);
    }

    public final UgcColorInfoData c() {
        UgcColorInfoData f16;
        w74.a value = this.historyData.getValue();
        if (value != null) {
            int historyCursor = value.getHistoryCursor();
            w74.a value2 = this.historyData.getValue();
            if (value2 != null && (f16 = value2.f(historyCursor)) != null) {
                ArrayList arrayList = new ArrayList();
                ArrayList<p> b16 = f16.b();
                if (b16 != null) {
                    for (p pVar : b16) {
                        p pVar2 = new p();
                        pVar2.f429636a = pVar.f429636a;
                        pVar2.f429637b = pVar.f429637b;
                        arrayList.add(pVar2);
                    }
                }
                return new UgcColorInfoData(new ArrayList(arrayList), f16.getColorPosition());
            }
        }
        return null;
    }

    public final int d() {
        w74.a value = this.historyData.getValue();
        if (value != null) {
            return value.getHistoryCursor();
        }
        return 0;
    }

    public final boolean g() {
        w74.a value = this.historyData.getValue();
        return (value != null ? value.g() : 0) > 1;
    }

    public final void i(ZplanFilamentSuitRender filamentRender) {
        Intrinsics.checkNotNullParameter(filamentRender, "filamentRender");
        h((this.historyData.getValue() != null ? r2.getHistoryCursor() : -1) - 1);
    }

    public final void j(ZplanFilamentSuitRender filamentRender) {
        Intrinsics.checkNotNullParameter(filamentRender, "filamentRender");
        w74.a value = this.historyData.getValue();
        h((value != null ? value.getHistoryCursor() : -1) + 1);
    }

    public final void m(ArrayList<p> initColors) {
        Intrinsics.checkNotNullParameter(initColors, "initColors");
        UgcColorInfoData ugcColorInfoData = new UgcColorInfoData(initColors, 0);
        w74.a value = this.historyData.getValue();
        if (value != null) {
            value.d();
        }
        w74.a value2 = this.historyData.getValue();
        k((value2 != null ? value2.getHistoryCursor() : 0) + 1, ugcColorInfoData);
    }

    public final boolean n(p singeColor, int index) {
        Intrinsics.checkNotNullParameter(singeColor, "singeColor");
        UgcColorInfoData c16 = c();
        if (c16 == null || c16.b().get(index).f429637b == singeColor.f429637b) {
            return false;
        }
        c16.b().set(index, singeColor);
        w74.a value = this.historyData.getValue();
        k((value != null ? value.getHistoryCursor() : 0) + 1, c16);
        return true;
    }

    public final void o(WeakReference<b> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListener = listener;
    }

    private final void e(final int targetIndex, final boolean bUpdate, final ZplanFilamentSuitRender filamentRender) {
        if (targetIndex < 0 || this.historyData.getValue() == null) {
            return;
        }
        w74.a value = this.historyData.getValue();
        Intrinsics.checkNotNull(value);
        if (targetIndex >= value.g()) {
            return;
        }
        w74.a value2 = this.historyData.getValue();
        final UgcColorInfoData f16 = value2 != null ? value2.f(targetIndex) : null;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.helper.f
            @Override // java.lang.Runnable
            public final void run() {
                g.f(g.this, targetIndex, bUpdate, f16, filamentRender);
            }
        });
    }

    static /* synthetic */ void l(g gVar, int i3, UgcColorInfoData ugcColorInfoData, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            ugcColorInfoData = null;
        }
        gVar.k(i3, ugcColorInfoData);
    }
}
