package com.tencent.mobileqq.emoticon.kernel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.BasePanelResult;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\n\u0010\u0005R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/emoticon/kernel/c;", "Lcom/tencent/mobileqq/emoticon/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/BasePanelResult;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/BasePanelResult;", "()Lcom/tencent/qqnt/kernel/nativeinterface/BasePanelResult;", "normalPanelResult", "b", "d", "superPanelResult", "c", "redHeartPanelResult", "otherPanelResult", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/BasePanelResult;Lcom/tencent/qqnt/kernel/nativeinterface/BasePanelResult;Lcom/tencent/qqnt/kernel/nativeinterface/BasePanelResult;Lcom/tencent/qqnt/kernel/nativeinterface/BasePanelResult;)V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c implements com.tencent.mobileqq.emoticon.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final BasePanelResult normalPanelResult;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final BasePanelResult superPanelResult;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final BasePanelResult redHeartPanelResult;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final BasePanelResult otherPanelResult;

    public c(@Nullable BasePanelResult basePanelResult, @Nullable BasePanelResult basePanelResult2, @Nullable BasePanelResult basePanelResult3, @Nullable BasePanelResult basePanelResult4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, basePanelResult, basePanelResult2, basePanelResult3, basePanelResult4);
            return;
        }
        this.normalPanelResult = basePanelResult;
        this.superPanelResult = basePanelResult2;
        this.redHeartPanelResult = basePanelResult3;
        this.otherPanelResult = basePanelResult4;
    }

    @Nullable
    public final BasePanelResult a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BasePanelResult) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.normalPanelResult;
    }

    @Nullable
    public final BasePanelResult b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BasePanelResult) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.otherPanelResult;
    }

    @Nullable
    public final BasePanelResult c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BasePanelResult) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.redHeartPanelResult;
    }

    @Nullable
    public final BasePanelResult d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BasePanelResult) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.superPanelResult;
    }
}
