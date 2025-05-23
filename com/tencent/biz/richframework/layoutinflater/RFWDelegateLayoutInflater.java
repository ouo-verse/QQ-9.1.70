package com.tencent.biz.richframework.layoutinflater;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b&\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007J\"\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0014\u0010 \u001a\u00020\u00122\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070!R\u0011\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010\u00a8\u0006\""}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RFWDelegateLayoutInflater;", "Landroid/view/LayoutInflater;", PM.BASE, "context", "Landroid/content/Context;", "delegates", "", "Lcom/tencent/biz/richframework/layoutinflater/LayoutInflateDelegate;", "(Landroid/view/LayoutInflater;Landroid/content/Context;Ljava/util/List;)V", "getBase", "()Landroid/view/LayoutInflater;", "getDelegates", "()Ljava/util/List;", "sClassPrefixList", "", "", "[Ljava/lang/String;", "addDelegate", "", "delegate", "inflate", "Landroid/view/View;", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "root", "Landroid/view/ViewGroup;", "attachToRoot", "", "onCreateView", "name", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "resetDelegates", "", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public abstract class RFWDelegateLayoutInflater extends LayoutInflater {

    @NotNull
    private final LayoutInflater base;

    @NotNull
    private final List<LayoutInflateDelegate> delegates;
    private final String[] sClassPrefixList;

    public /* synthetic */ RFWDelegateLayoutInflater(LayoutInflater layoutInflater, Context context, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutInflater, context, (i3 & 4) != 0 ? new ArrayList() : list);
    }

    public final void addDelegate(@NotNull LayoutInflateDelegate delegate) {
        Object obj;
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Iterator<T> it = this.delegates.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((LayoutInflateDelegate) obj).getClass(), delegate.getClass())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((LayoutInflateDelegate) obj) == null) {
            this.delegates.add(delegate);
        }
    }

    @NotNull
    public final LayoutInflater getBase() {
        return this.base;
    }

    @NotNull
    public final List<LayoutInflateDelegate> getDelegates() {
        return this.delegates;
    }

    @Override // android.view.LayoutInflater
    @NotNull
    public View inflate(@NotNull XmlPullParser parser, @Nullable ViewGroup root, boolean attachToRoot) {
        Intrinsics.checkNotNullParameter(parser, "parser");
        View inflate = super.inflate(parser, root, attachToRoot);
        for (LayoutInflateDelegate layoutInflateDelegate : this.delegates) {
            Intrinsics.checkNotNullExpressionValue(inflate, "this");
            layoutInflateDelegate.afterInflate(parser, root, attachToRoot, inflate);
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "super.inflate(parser, ro\u2026ToRoot, this) }\n        }");
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.LayoutInflater
    @Nullable
    public View onCreateView(@NotNull String name, @NotNull AttributeSet attrs) throws ClassNotFoundException {
        View createView;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        for (String str : this.sClassPrefixList) {
            try {
                createView = createView(name, str, attrs);
            } catch (ClassNotFoundException unused) {
            }
            if (createView != null) {
                return createView;
            }
        }
        return super.onCreateView(name, attrs);
    }

    public final void resetDelegates(@NotNull List<? extends LayoutInflateDelegate> resetDelegates) {
        Intrinsics.checkNotNullParameter(resetDelegates, "resetDelegates");
        this.delegates.clear();
        this.delegates.addAll(resetDelegates);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWDelegateLayoutInflater(@NotNull LayoutInflater base, @NotNull Context context, @NotNull List<LayoutInflateDelegate> delegates) {
        super(base, context);
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(delegates, "delegates");
        this.base = base;
        this.delegates = delegates;
        this.sClassPrefixList = new String[]{"android.widget.", "android.webkit.", "android.app."};
    }
}
