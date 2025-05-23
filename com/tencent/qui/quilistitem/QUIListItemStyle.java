package com.tencent.qui.quilistitem;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qui/quilistitem/QUIListItemStyle;", "", "(Ljava/lang/String;I)V", "Card", "FullWidth", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final class QUIListItemStyle {
    private static final /* synthetic */ QUIListItemStyle[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final QUIListItemStyle Card;
    public static final QUIListItemStyle FullWidth;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14701);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        QUIListItemStyle qUIListItemStyle = new QUIListItemStyle("Card", 0);
        Card = qUIListItemStyle;
        QUIListItemStyle qUIListItemStyle2 = new QUIListItemStyle("FullWidth", 1);
        FullWidth = qUIListItemStyle2;
        $VALUES = new QUIListItemStyle[]{qUIListItemStyle, qUIListItemStyle2};
    }

    QUIListItemStyle(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
    }

    public static QUIListItemStyle valueOf(String str) {
        return (QUIListItemStyle) Enum.valueOf(QUIListItemStyle.class, str);
    }

    public static QUIListItemStyle[] values() {
        return (QUIListItemStyle[]) $VALUES.clone();
    }
}
