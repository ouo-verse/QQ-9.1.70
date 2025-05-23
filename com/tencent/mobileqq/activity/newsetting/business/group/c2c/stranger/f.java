package com.tencent.mobileqq.activity.newsetting.business.group.c2c.stranger;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/activity/newsetting/business/group/c2c/stranger/f;", "Lcom/tencent/mobileqq/activity/newsetting/custom/group/a;", "Lcom/tencent/mobileqq/widget/listitem/Group;", "c", "Lcom/tencent/mobileqq/activity/newsetting/custom/config/b;", "j", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "e", "Lcom/tencent/mobileqq/activity/newsetting/custom/config/b;", "mStrangerSetTopConfig", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class f extends com.tencent.mobileqq.activity.newsetting.custom.group.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> mStrangerSetTopConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.group.a
    @NotNull
    protected Group c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar = null;
        this.mStrangerSetTopConfig = new com.tencent.mobileqq.activity.newsetting.custom.config.b<>(new x.b.d("\u7f6e\u9876"), new x.c.f(false, null), f());
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[1];
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar2 = this.mStrangerSetTopConfig;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStrangerSetTopConfig");
        } else {
            bVar = bVar2;
        }
        aVarArr[0] = bVar;
        return new Group(aVarArr);
    }

    @NotNull
    public final com.tencent.mobileqq.activity.newsetting.custom.config.b<?, ?> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar = this.mStrangerSetTopConfig;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStrangerSetTopConfig");
            return null;
        }
        return bVar;
    }
}
