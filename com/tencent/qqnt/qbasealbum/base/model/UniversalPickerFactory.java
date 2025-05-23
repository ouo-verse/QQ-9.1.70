package com.tencent.qqnt.qbasealbum.base.model;

import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.select.view.UniversalMediaSelectionPanelPart;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u0010\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00118VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0005\u0010\u0014R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00168\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\t\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/base/model/UniversalPickerFactory;", "Lcom/tencent/qqnt/qbasealbum/base/model/d;", "Lcom/tencent/biz/richframework/part/Part;", "c", "", "a", "Z", "enableVideoTemplate", "", "b", "Ljava/lang/String;", "hint", "", "I", "getMediaViewHolderLayout", "()I", "mediaViewHolderLayout", "Lcom/tencent/qqnt/qbasealbum/base/model/a;", "d", "Lkotlin/Lazy;", "()Lcom/tencent/qqnt/qbasealbum/base/model/a;", "mediaItemClickListener", "Lcom/tencent/qqnt/qbasealbum/base/model/c;", "e", "Lcom/tencent/qqnt/qbasealbum/base/model/c;", "()Lcom/tencent/qqnt/qbasealbum/base/model/c;", "performanceMonitorCallback", "<init>", "(ZLjava/lang/String;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class UniversalPickerFactory implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean enableVideoTemplate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String hint;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int mediaViewHolderLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mediaItemClickListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final c performanceMonitorCallback;

    public UniversalPickerFactory(boolean z16, @NotNull String hint) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(hint, "hint");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), hint);
            return;
        }
        this.enableVideoTemplate = z16;
        this.hint = hint;
        this.mediaViewHolderLayout = R.layout.f168436ft0;
        lazy = LazyKt__LazyJVMKt.lazy(UniversalPickerFactory$mediaItemClickListener$2.INSTANCE);
        this.mediaItemClickListener = lazy;
    }

    @Override // com.tencent.qqnt.qbasealbum.base.model.d
    @NotNull
    public a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (a) this.mediaItemClickListener.getValue();
    }

    @Override // com.tencent.qqnt.qbasealbum.base.model.d
    @Nullable
    public c b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (c) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.performanceMonitorCallback;
    }

    @Override // com.tencent.qqnt.qbasealbum.base.model.d
    @NotNull
    public Part c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Part) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new UniversalMediaSelectionPanelPart(this.enableVideoTemplate, this.hint);
    }

    public /* synthetic */ UniversalPickerFactory(boolean z16, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? "" : str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
