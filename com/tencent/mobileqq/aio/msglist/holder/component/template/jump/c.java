package com.tencent.mobileqq.aio.msglist.holder.component.template.jump;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.android.androidbypass.richui.view.j;
import com.tencent.mobileqq.aio.msg.TemplateMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.template.common.TemplateMsgConfigManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001\u0004B\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b$\u0010%J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016R\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/jump/c;", "Lcom/tencent/android/androidbypass/richui/view/j;", "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/jump/b;", "a", "", "url", "", "c", "b", "Landroid/view/View;", "view", "viewId", ZPlanPublishSource.FROM_SCHEME, "", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "getMsgItem", "()Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "msgItem", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/report/c;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/report/c;", "getReporter", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/template/report/c;", "reporter", "Ljava/util/List;", "businessHandlers", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/jump/g;", "d", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/jump/g;", "urlVersionSolver", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/jump/f;", "e", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/jump/f;", "urlExtraParamsProcessor", "<init>", "(Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;Lcom/tencent/mobileqq/aio/msglist/holder/component/template/report/c;)V", "f", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c implements j {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TemplateMsgItem msgItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mobileqq.aio.msglist.holder.component.template.report.c reporter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<b> businessHandlers;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g urlVersionSolver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f urlExtraParamsProcessor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/jump/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.template.jump.c$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63478);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull TemplateMsgItem msgItem, @Nullable com.tencent.mobileqq.aio.msglist.holder.component.template.report.c cVar) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItem, (Object) cVar);
            return;
        }
        this.msgItem = msgItem;
        this.reporter = cVar;
        this.businessHandlers = a();
        this.urlVersionSolver = new g(msgItem);
        this.urlExtraParamsProcessor = new f(msgItem);
    }

    private final List<b> a() {
        String str;
        List<b> listOf;
        List<b> listOf2;
        List<b> listOf3;
        com.tencent.mobileqq.aio.msg.template.d n26 = this.msgItem.n2();
        String str2 = null;
        if (n26 != null) {
            str = n26.a();
        } else {
            str = null;
        }
        com.tencent.mobileqq.aio.msg.template.d n27 = this.msgItem.n2();
        if (n27 != null) {
            str2 = n27.f();
        }
        if (d.INSTANCE.a(str, str2)) {
            listOf3 = CollectionsKt__CollectionsJVMKt.listOf(new d(this.msgItem));
            return listOf3;
        }
        if (e.INSTANCE.a(str)) {
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(new e(this.msgItem));
            return listOf2;
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new a(this.msgItem));
        return listOf;
    }

    private final boolean b(String url) {
        String a16;
        String str;
        com.tencent.mobileqq.aio.msg.template.d n26 = this.msgItem.n2();
        if (n26 != null && (a16 = n26.a()) != null) {
            com.tencent.mobileqq.aio.msg.template.d n27 = this.msgItem.n2();
            if (n27 == null || (str = n27.b()) == null) {
                QLog.e("TemMsg.TemplateMsgClickHandler", 1, "checkUrlAllowed bizName got null, templateMsgInfo is " + this.msgItem.n2());
                str = "";
            }
            boolean h16 = TemplateMsgConfigManager.f191899a.h(a16, str, url);
            com.tencent.mobileqq.aio.msglist.holder.component.template.a.b(com.tencent.mobileqq.aio.msglist.holder.component.template.a.f191886a, "TemMsg.TemplateMsgClickHandler", "checkUrlAllowed:" + url + ", return " + h16, null, 4, null);
            return h16;
        }
        QLog.e("TemMsg.TemplateMsgClickHandler", 1, "checkUrlAllowed appName got null, templateMsgInfo is " + this.msgItem.n2());
        return false;
    }

    private final boolean c(String url) {
        for (b bVar : this.businessHandlers) {
            if (bVar.a(url)) {
                QLog.i("TemMsg.TemplateMsgClickHandler", 1, "onclick force allowed by " + bVar);
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.android.androidbypass.richui.view.j
    public void onClick(@NotNull View view, @NotNull String viewId, @NotNull String scheme) {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, viewId, scheme);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        String a16 = this.urlExtraParamsProcessor.a(this.urlVersionSolver.g(scheme));
        if (!c(a16) && !b(a16)) {
            QLog.i("TemMsg.TemplateMsgClickHandler", 1, "onclick not allowed:" + a16);
            return;
        }
        QLog.i("TemMsg.TemplateMsgClickHandler", 1, "onclick:" + a16);
        com.tencent.mobileqq.aio.msglist.holder.component.template.report.c cVar = this.reporter;
        if (cVar != null) {
            cVar.e();
        }
        for (b bVar : this.businessHandlers) {
            Context context = view.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (bVar.b(a16, activity)) {
                return;
            }
        }
    }
}
