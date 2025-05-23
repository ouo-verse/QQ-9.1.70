package com.tencent.qqnt.qbasealbum.album.viewmodel;

import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.base.model.UniversalPickerFactory;
import com.tencent.qqnt.qbasealbum.model.PickerInitBean;
import com.tencent.qqnt.qbasealbum.select.view.UniversalMediaSelectionPanelPart;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u00020\b8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/viewmodel/PickerFactory;", "Lcom/tencent/qqnt/qbasealbum/base/model/UniversalPickerFactory;", "Lcom/tencent/biz/richframework/part/Part;", "c", "Lcom/tencent/qqnt/qbasealbum/model/PickerInitBean;", "f", "Lcom/tencent/qqnt/qbasealbum/model/PickerInitBean;", "initBean", "Lcom/tencent/qqnt/qbasealbum/performance/a;", "g", "Lkotlin/Lazy;", "d", "()Lcom/tencent/qqnt/qbasealbum/performance/a;", "performanceMonitorCallback", "Lcom/tencent/qqnt/qbasealbum/base/model/a;", h.F, "a", "()Lcom/tencent/qqnt/qbasealbum/base/model/a;", "mediaItemClickListener", "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/PickerInitBean;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PickerFactory extends UniversalPickerFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PickerInitBean initBean;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy performanceMonitorCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mediaItemClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickerFactory(@NotNull PickerInitBean initBean) {
        super(true, null, 2, null);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) initBean);
            return;
        }
        this.initBean = initBean;
        lazy = LazyKt__LazyJVMKt.lazy(PickerFactory$performanceMonitorCallback$2.INSTANCE);
        this.performanceMonitorCallback = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(PickerFactory$mediaItemClickListener$2.INSTANCE);
        this.mediaItemClickListener = lazy2;
    }

    @Override // com.tencent.qqnt.qbasealbum.base.model.UniversalPickerFactory, com.tencent.qqnt.qbasealbum.base.model.d
    @NotNull
    public com.tencent.qqnt.qbasealbum.base.model.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.qbasealbum.base.model.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (com.tencent.qqnt.qbasealbum.base.model.a) this.mediaItemClickListener.getValue();
    }

    @Override // com.tencent.qqnt.qbasealbum.base.model.UniversalPickerFactory, com.tencent.qqnt.qbasealbum.base.model.d
    @NotNull
    public Part c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Part) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new UniversalMediaSelectionPanelPart(this.initBean.c(), this.initBean.b());
    }

    @Override // com.tencent.qqnt.qbasealbum.base.model.UniversalPickerFactory, com.tencent.qqnt.qbasealbum.base.model.d
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public com.tencent.qqnt.qbasealbum.performance.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.qbasealbum.performance.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (com.tencent.qqnt.qbasealbum.performance.a) this.performanceMonitorCallback.getValue();
    }
}
