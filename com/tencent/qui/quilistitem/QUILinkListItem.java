package com.tencent.qui.quilistitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qui.quilistitem.QUIListItem;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qui/quilistitem/QUILinkListItem;", "Lcom/tencent/qui/quilistitem/QUIListItem;", "Lcom/tencent/qui/quilistitem/g;", DownloadInfo.spKey_Config, "", "setConfig", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final class QUILinkListItem extends QUIListItem<g> {
    static IPatchRedirector $redirector_;

    @JvmOverloads
    public QUILinkListItem(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
    }

    public final void setConfig(@NotNull g config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) config);
        } else {
            Intrinsics.checkNotNullParameter(config, "config");
            i().k();
            throw null;
        }
    }

    public /* synthetic */ QUILinkListItem(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUILinkListItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        TextView k3 = i().k();
        int e16 = e();
        ViewGroup.LayoutParams layoutParams = k3.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) (layoutParams instanceof ViewGroup.MarginLayoutParams ? layoutParams : null);
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = k3.getLayoutParams();
            int i3 = layoutParams2 != null ? layoutParams2.width : -2;
            ViewGroup.LayoutParams layoutParams3 = k3.getLayoutParams();
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, layoutParams3 != null ? layoutParams3.height : -2);
        }
        marginLayoutParams.leftMargin = e16;
        k3.setLayoutParams(marginLayoutParams);
        QUIListItem.d<TextView> c16 = i().c(i().k());
        if (c16 != null) {
            setTextColor$QUIListItem_debug(c16, i().k(), R.color.qui_common_text_link);
            c16.d(k());
        }
        c(i().k());
    }
}
