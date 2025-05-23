package com.tencent.mobileqq.aio.msglist.holder.skin.padding;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.utils.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\t\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/j;", "", "j", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/a;", "a", "e", "I", "structPaddingLeft", "f", "structPaddingRight", "g", "structLayoutMargin", tl.h.F, "k", "()I", "setStructMsgContentWidth", "(I)V", "structMsgContentWidth", "i", "getBubblePaddingAlignHead", "setBubblePaddingAlignHead", "bubblePaddingAlignHead", "getBubblePaddingAlignError", "setBubblePaddingAlignError", "bubblePaddingAlignError", "l", "setVideoBubbleMaxWidth", "videoBubbleMaxWidth", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b extends j {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int structPaddingLeft;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int structPaddingRight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int structLayoutMargin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int structMsgContentWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int bubblePaddingAlignHead;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int bubblePaddingAlignError;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int videoBubbleMaxWidth;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.structPaddingLeft = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.f158247b9);
        this.structPaddingRight = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.b_);
        this.structLayoutMargin = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.axw);
    }

    private final int j() {
        int coerceAtMost;
        int coerceAtMost2;
        int dimensionPixelSize = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.f159574ay1);
        a.C7329a c7329a = a.C7329a.f192417a;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost((c7329a.d() - c()) - d(), dimensionPixelSize);
        coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(((c7329a.d() - this.structPaddingLeft) - this.structPaddingRight) - (this.structLayoutMargin * 2), this.bubblePaddingAlignHead + this.bubblePaddingAlignError + coerceAtMost);
        return coerceAtMost2;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.skin.padding.j, com.tencent.mobileqq.aio.msglist.holder.skin.padding.a
    @NotNull
    public a a(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (a) iPatchRedirector.redirect((short) 10, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        super.a(msgItem);
        if (m.f194167a.c(msgItem)) {
            a.c cVar = a.c.f192425a;
            this.bubblePaddingAlignHead = cVar.b();
            this.bubblePaddingAlignError = cVar.a();
        } else {
            a.b bVar = a.b.f192418a;
            this.bubblePaddingAlignHead = bVar.b();
            this.bubblePaddingAlignError = bVar.a();
        }
        this.structMsgContentWidth = j();
        this.videoBubbleMaxWidth = (a.C7329a.f192417a.b() - c()) - d();
        return this;
    }

    public final int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.structMsgContentWidth;
    }

    public final int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.videoBubbleMaxWidth;
    }
}
