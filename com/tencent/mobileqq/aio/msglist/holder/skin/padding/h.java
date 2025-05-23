package com.tencent.mobileqq.aio.msglist.holder.skin.padding;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.e;
import com.tencent.mobileqq.aio.utils.m;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\"\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\bR\"\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\b\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\b\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\"\u0010#\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\b\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\"\u0010%\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\b\u001a\u0004\b \u0010\u0014\"\u0004\b$\u0010\u0016\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/h;", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/j;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/a;", "a", "", "e", "I", "AIO_REPLY_INNER_MARGIN_OUTER_BUBBLE_EXCEPT_BOTTOM", "f", "AIO_REPLY_INNER_MARGIN_OUTER_BUBBLE_BOTTOM", "g", "AIO_REPLY_OUTER_TEXT_INNER_BUBBLE_BOTTOM", tl.h.F, "AIO_REPLY_MIX_TEXT_ITEM_INTERVAL_SPACE", "i", "AIO_REPLY_INNER_TEXT_INNER_BUBBLE_PADDING", "j", "k", "()I", "setInnerBubbleMarginLeft", "(I)V", "innerBubbleMarginLeft", "l", "setInnerBubbleMarginRight", "innerBubbleMarginRight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setInnerBubbleMarginTop", "innerBubbleMarginTop", "setInnerBubbleMarginBottom", "innerBubbleMarginBottom", DomainData.DOMAIN_NAME, "o", "setInnerTextItemIntervalSpace", "innerTextItemIntervalSpace", "setInnerTextInnerBubblePadding", "innerTextInnerBubblePadding", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class h extends j {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int AIO_REPLY_INNER_MARGIN_OUTER_BUBBLE_EXCEPT_BOTTOM;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int AIO_REPLY_INNER_MARGIN_OUTER_BUBBLE_BOTTOM;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int AIO_REPLY_OUTER_TEXT_INNER_BUBBLE_BOTTOM;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int AIO_REPLY_MIX_TEXT_ITEM_INTERVAL_SPACE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int AIO_REPLY_INNER_TEXT_INNER_BUBBLE_PADDING;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int innerBubbleMarginLeft;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int innerBubbleMarginRight;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int innerBubbleMarginTop;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int innerBubbleMarginBottom;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int innerTextItemIntervalSpace;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int innerTextInnerBubblePadding;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.AIO_REPLY_INNER_MARGIN_OUTER_BUBBLE_EXCEPT_BOTTOM = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.c0j);
        this.AIO_REPLY_INNER_MARGIN_OUTER_BUBBLE_BOTTOM = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.c0i);
        this.AIO_REPLY_OUTER_TEXT_INNER_BUBBLE_BOTTOM = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.c0m);
        this.AIO_REPLY_MIX_TEXT_ITEM_INTERVAL_SPACE = e.a.f192439a.a();
        this.AIO_REPLY_INNER_TEXT_INNER_BUBBLE_PADDING = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.c0k);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.skin.padding.j, com.tencent.mobileqq.aio.msglist.holder.skin.padding.a
    @NotNull
    public a a(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (a) iPatchRedirector.redirect((short) 14, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        super.a(msgItem);
        this.innerTextItemIntervalSpace = this.AIO_REPLY_MIX_TEXT_ITEM_INTERVAL_SPACE;
        this.innerTextInnerBubblePadding = this.AIO_REPLY_INNER_TEXT_INNER_BUBBLE_PADDING;
        if (m.f194167a.c(msgItem)) {
            a.c cVar = a.c.f192425a;
            int b16 = cVar.b() + this.AIO_REPLY_INNER_MARGIN_OUTER_BUBBLE_EXCEPT_BOTTOM;
            int a16 = cVar.a() + this.AIO_REPLY_INNER_MARGIN_OUTER_BUBBLE_EXCEPT_BOTTOM;
            int d16 = cVar.d() + this.AIO_REPLY_INNER_MARGIN_OUTER_BUBBLE_EXCEPT_BOTTOM;
            int i3 = this.AIO_REPLY_INNER_MARGIN_OUTER_BUBBLE_BOTTOM;
            if (msgItem.isSelf()) {
                this.innerBubbleMarginLeft = a16;
                this.innerBubbleMarginRight = b16;
                this.innerBubbleMarginTop = d16;
                this.innerBubbleMarginBottom = i3;
            } else {
                this.innerBubbleMarginLeft = b16;
                this.innerBubbleMarginRight = a16;
                this.innerBubbleMarginTop = d16;
                this.innerBubbleMarginBottom = i3;
            }
            i(this.AIO_REPLY_OUTER_TEXT_INNER_BUBBLE_BOTTOM);
        } else {
            a.b bVar = a.b.f192418a;
            int b17 = bVar.b() + this.AIO_REPLY_INNER_MARGIN_OUTER_BUBBLE_EXCEPT_BOTTOM;
            int a17 = bVar.a() + this.AIO_REPLY_INNER_MARGIN_OUTER_BUBBLE_EXCEPT_BOTTOM;
            int d17 = bVar.d() + this.AIO_REPLY_INNER_MARGIN_OUTER_BUBBLE_EXCEPT_BOTTOM;
            int i16 = this.AIO_REPLY_INNER_MARGIN_OUTER_BUBBLE_BOTTOM;
            if (msgItem.isSelf()) {
                this.innerBubbleMarginLeft = a17;
                this.innerBubbleMarginRight = b17;
                this.innerBubbleMarginTop = d17;
                this.innerBubbleMarginBottom = i16;
            } else {
                this.innerBubbleMarginLeft = b17;
                this.innerBubbleMarginRight = a17;
                this.innerBubbleMarginTop = d17;
                this.innerBubbleMarginBottom = i16;
            }
            i(this.AIO_REPLY_OUTER_TEXT_INNER_BUBBLE_BOTTOM);
        }
        return this;
    }

    public final int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.innerBubbleMarginBottom;
    }

    public final int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.innerBubbleMarginLeft;
    }

    public final int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.innerBubbleMarginRight;
    }

    public final int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.innerBubbleMarginTop;
    }

    public final int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.innerTextInnerBubblePadding;
    }

    public final int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.innerTextItemIntervalSpace;
    }
}
