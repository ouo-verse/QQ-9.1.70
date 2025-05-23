package com.tencent.mobileqq.aio.msglist.holder.component.markdown.view;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.j;
import com.tencent.mobileqq.aio.utils.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElement;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/view/a;", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/j;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/a;", "a", "<init>", "()V", "e", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a extends j {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    private static final int f191129f;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/view/a$a;", "", "", "MARKDOWN_TEXT_PADDING", "I", "a", "()I", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.view.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return a.f191129f;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61616);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
            f191129f = ViewUtils.dpToPx(12.0f);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.skin.padding.j, com.tencent.mobileqq.aio.msglist.holder.skin.padding.a
    @NotNull
    public com.tencent.mobileqq.aio.msglist.holder.skin.padding.a a(@NotNull AIOMsgItem msgItem) {
        MarkdownMsgItem markdownMsgItem;
        int i3;
        MarkdownElement r26;
        MarkdownStyle markdownStyle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.msglist.holder.skin.padding.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof MarkdownMsgItem) {
            markdownMsgItem = (MarkdownMsgItem) msgItem;
        } else {
            markdownMsgItem = null;
        }
        int i16 = 0;
        if (markdownMsgItem != null && (r26 = markdownMsgItem.r2()) != null && (markdownStyle = r26.style) != null) {
            i3 = markdownStyle.bubbleType;
        } else {
            i3 = 0;
        }
        if (i3 != 1) {
            i16 = f191129f;
        }
        if (m.f194167a.c(msgItem)) {
            if (msgItem.isSelf()) {
                a.c cVar = a.c.f192425a;
                g(cVar.a() + i16);
                h(cVar.b() + i16);
            } else {
                a.c cVar2 = a.c.f192425a;
                g(cVar2.b() + i16);
                h(cVar2.a() + i16);
            }
            a.c cVar3 = a.c.f192425a;
            i(cVar3.d() + i16);
            f(cVar3.c() + i16);
        } else {
            if (msgItem.isSelf()) {
                a.b bVar = a.b.f192418a;
                g(bVar.a() + i16);
                h(bVar.b() + i16);
            } else {
                a.b bVar2 = a.b.f192418a;
                g(bVar2.b() + i16);
                h(bVar2.a() + i16);
            }
            a.b bVar3 = a.b.f192418a;
            i(bVar3.d() + i16);
            f(bVar3.c() + i16);
        }
        return this;
    }
}
