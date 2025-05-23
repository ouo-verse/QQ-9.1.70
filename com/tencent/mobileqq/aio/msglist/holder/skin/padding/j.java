package com.tencent.mobileqq.aio.msglist.holder.skin.padding;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.utils.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\"\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\u0013\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/j;", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/a;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "a", "", "I", "c", "()I", "g", "(I)V", NodeProps.PADDING_LEFT, "b", "d", tl.h.F, NodeProps.PADDING_RIGHT, "e", "i", NodeProps.PADDING_TOP, "f", NodeProps.PADDING_BOTTOM, "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class j extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int paddingLeft;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int paddingRight;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int paddingTop;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int paddingBottom;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.skin.padding.a
    @NotNull
    public a a(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (a) iPatchRedirector.redirect((short) 10, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (m.f194167a.c(msgItem)) {
            a.c cVar = a.c.f192425a;
            int b16 = cVar.b() + cVar.e();
            int a16 = cVar.a() + cVar.e();
            int d16 = cVar.d() + cVar.e();
            int c16 = cVar.c() + cVar.e();
            if (msgItem.isSelf()) {
                this.paddingLeft = a16;
                this.paddingRight = b16;
                this.paddingTop = d16;
                this.paddingBottom = c16;
            } else {
                this.paddingLeft = b16;
                this.paddingRight = a16;
                this.paddingTop = d16;
                this.paddingBottom = c16;
            }
        } else {
            a.b bVar = a.b.f192418a;
            int b17 = bVar.b() + bVar.e();
            int a17 = bVar.a() + bVar.e();
            int d17 = bVar.d() + bVar.f();
            int c17 = bVar.c() + bVar.f();
            if (msgItem.isSelf()) {
                this.paddingLeft = a17;
                this.paddingRight = b17;
                this.paddingTop = d17;
                this.paddingBottom = c17;
            } else {
                this.paddingLeft = b17;
                this.paddingRight = a17;
                this.paddingTop = d17;
                this.paddingBottom = c17;
            }
        }
        return this;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.paddingBottom;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.paddingLeft;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.paddingRight;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.paddingTop;
    }

    public final void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.paddingBottom = i3;
        }
    }

    public final void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.paddingLeft = i3;
        }
    }

    public final void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.paddingRight = i3;
        }
    }

    public final void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.paddingTop = i3;
        }
    }
}
