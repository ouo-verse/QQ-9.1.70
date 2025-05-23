package com.tencent.qqnt.chathistory.ui.widget.loadMore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.util.m;
import com.tencent.qqnt.chathistory.x2k.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q3.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0005\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/widget/loadMore/HistoryLoadMoreFooter;", "Lcom/qqnt/widget/smartrefreshlayout/layout/simple/SimpleComponent;", "Lq3/c;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class HistoryLoadMoreFooter extends SimpleComponent implements c {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HistoryLoadMoreFooter(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryLoadMoreFooter(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(new z(context, null, 2, null).getRoot());
        addView(frameLayout, new ViewGroup.LayoutParams(-1, m.a(50)));
    }
}
