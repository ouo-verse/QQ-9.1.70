package com.tencent.qqnt.chats.core.ui.listener;

import com.tencent.hippy.qq.view.scroll.HippyHeaderScrollViewController;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q3.d;
import r3.f;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J:\u0010\u0011\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\"\u0010\u0012\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\"\u0010\u0013\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\tH\u0016J:\u0010\u0019\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\"\u0010\u001a\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\"\u0010\u001b\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u001a\u0010\u001c\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\tH\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/listener/c;", "Lr3/f;", "Lq3/f;", "refreshLayout", "", "e", "E6", "Lq3/d;", "header", "", "isDragging", "", "percent", "", "offset", HippyHeaderScrollViewController.HEADER_HEIGHT, "maxDragHeight", "B9", "Pe", "vf", "success", "Tf", "Lq3/c;", "footer", "footerHeight", "kb", "Z7", "k6", "cd", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class c implements f {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // r3.f
    public void B9(@Nullable d header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, header, Boolean.valueOf(isDragging), Float.valueOf(percent), Integer.valueOf(offset), Integer.valueOf(headerHeight), Integer.valueOf(maxDragHeight));
        }
    }

    @Override // r3.e
    public void E6(@NotNull q3.f refreshLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) refreshLayout);
        } else {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        }
    }

    @Override // r3.f
    public void Pe(@Nullable d header, int headerHeight, int maxDragHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, header, Integer.valueOf(headerHeight), Integer.valueOf(maxDragHeight));
        }
    }

    @Override // r3.f
    public void Tf(@Nullable d header, boolean success) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, header, Boolean.valueOf(success));
        }
    }

    @Override // r3.f
    public void Z7(@Nullable q3.c footer, int footerHeight, int maxDragHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, footer, Integer.valueOf(footerHeight), Integer.valueOf(maxDragHeight));
        }
    }

    @Override // r3.f
    public void cd(@Nullable q3.c footer, boolean success) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, footer, Boolean.valueOf(success));
        }
    }

    @Override // r3.h
    public void e(@NotNull q3.f refreshLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) refreshLayout);
        } else {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        }
    }

    @Override // r3.f
    public void k6(@Nullable q3.c footer, int footerHeight, int maxDragHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, footer, Integer.valueOf(footerHeight), Integer.valueOf(maxDragHeight));
        }
    }

    @Override // r3.f
    public void kb(@Nullable q3.c footer, boolean isDragging, float percent, int offset, int footerHeight, int maxDragHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, footer, Boolean.valueOf(isDragging), Float.valueOf(percent), Integer.valueOf(offset), Integer.valueOf(footerHeight), Integer.valueOf(maxDragHeight));
        }
    }

    @Override // r3.f
    public void vf(@Nullable d header, int headerHeight, int maxDragHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, header, Integer.valueOf(headerHeight), Integer.valueOf(maxDragHeight));
        }
    }
}
