package com.tencent.biz.pubaccount.accountdetail.model;

import android.widget.CompoundButton;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J4\u0010\n\u001a\u00020\t2\u001a\u0010\u0006\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002H\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\f\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/biz/pubaccount/accountdetail/model/c;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "itemConfig", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "", "d", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "title", "", "b", "Z", "()Z", "f", "(Z)V", "switchDefaultValue", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "()Landroid/widget/CompoundButton$OnCheckedChangeListener;", "e", "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "checkedChangeListener", "<init>", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String title = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean switchDefaultValue;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private CompoundButton.OnCheckedChangeListener checkedChangeListener;

    /* renamed from: a, reason: from getter */
    public final CompoundButton.OnCheckedChangeListener getCheckedChangeListener() {
        return this.checkedChangeListener;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getSwitchDefaultValue() {
        return this.switchDefaultValue;
    }

    /* renamed from: c, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final void e(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.checkedChangeListener = onCheckedChangeListener;
    }

    public final void f(boolean z16) {
        this.switchDefaultValue = z16;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public void d(WeakReference<x<x.b.d, x.c.f>> itemConfig, WeakReference<QUIListItemAdapter> adapter) {
    }
}
