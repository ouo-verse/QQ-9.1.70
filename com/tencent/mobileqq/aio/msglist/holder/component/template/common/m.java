package com.tencent.mobileqq.aio.msglist.holder.component.template.common;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.aio.msglist.holder.component.template.template.TemplateMsgTemplateManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.rich.RichParser;
import com.tencent.qqnt.rich.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ*\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/m;", "", "", "appName", "bizName", "viewName", "dataString", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/common/h;", "d", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/business/f;", "params", "c", "Landroid/content/Context;", "context", "Landroidx/constraintlayout/widget/ConstraintLayout;", "parentView", "Lcom/tencent/qqnt/rich/j;", "richData", "Lcom/tencent/android/androidbypass/richui/view/j;", "viewClickListener", "Lcom/tencent/qqnt/rich/n;", "a", "Lcom/tencent/mobileqq/aio/msg/template/d;", "templateMsgInfo", "e", "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/business/a;", "b", "Ljava/util/List;", "businessProcessors", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f191935a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<com.tencent.mobileqq.aio.msglist.holder.component.template.business.a> businessProcessors;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/template/common/m$a", "Lcom/tencent/android/androidbypass/richui/b;", "", "viewId", "key", "source", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements com.tencent.android.androidbypass.richui.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.aio.msglist.holder.component.template.business.f f191937a;

        a(com.tencent.mobileqq.aio.msglist.holder.component.template.business.f fVar) {
            this.f191937a = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
            }
        }

        @Override // com.tencent.android.androidbypass.richui.b
        @NotNull
        public String a(@NotNull String viewId, @NotNull String key, @NotNull String source) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, this, viewId, key, source);
            }
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(source, "source");
            com.tencent.mobileqq.aio.msglist.holder.component.template.a.b(com.tencent.mobileqq.aio.msglist.holder.component.template.a.f191886a, "TemMsg.TemplateMsgViewHelper", "processWhiteSource uri:" + source + ", for:" + this.f191937a.a() + "," + this.f191937a.b(), null, 4, null);
            boolean i3 = TemplateMsgConfigManager.f191899a.i(this.f191937a.a(), this.f191937a.b(), source);
            if (!i3) {
                QLog.d("TemMsg.TemplateMsgViewHelper", 1, "try to load url " + source + " not allowed");
            }
            if (!i3) {
                return "";
            }
            return source;
        }
    }

    static {
        List<com.tencent.mobileqq.aio.msglist.holder.component.template.business.a> listOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63433);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f191935a = new m();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.aio.msglist.holder.component.template.business.a[]{new com.tencent.mobileqq.aio.msglist.holder.component.template.business.e(), new com.tencent.mobileqq.aio.msglist.holder.component.template.business.d(), new com.tencent.mobileqq.aio.msglist.holder.component.template.business.g(), new com.tencent.mobileqq.aio.msglist.holder.component.template.business.c(), new com.tencent.mobileqq.aio.msglist.holder.component.template.business.b()});
        businessProcessors = listOf;
    }

    m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ n b(m mVar, Context context, ConstraintLayout constraintLayout, com.tencent.qqnt.rich.j jVar, com.tencent.android.androidbypass.richui.view.j jVar2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            jVar2 = null;
        }
        return mVar.a(context, constraintLayout, jVar, jVar2);
    }

    @NotNull
    public final n a(@NotNull Context context, @NotNull ConstraintLayout parentView, @NotNull com.tencent.qqnt.rich.j richData, @Nullable com.tencent.android.androidbypass.richui.view.j viewClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (n) iPatchRedirector.redirect((short) 4, this, context, parentView, richData, viewClickListener);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(richData, "richData");
        n nVar = new n(context, parentView, new com.tencent.qqnt.rich.l(), null, new com.tencent.qqnt.rich.k(null, new com.tencent.qqnt.rich.h(viewClickListener, null, 2, null), 1, null), 8, null);
        nVar.c(richData);
        return nVar;
    }

    @NotNull
    public final h c(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.template.business.f params) {
        boolean z16;
        Object firstOrNull;
        com.tencent.android.androidbypass.richui.viewdata.k kVar;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (h) iPatchRedirector.redirect((short) 3, (Object) this, (Object) params);
        }
        Intrinsics.checkNotNullParameter(params, "params");
        Iterator<com.tencent.mobileqq.aio.msglist.holder.component.template.business.a> it = businessProcessors.iterator();
        while (it.hasNext() && !it.next().a(params)) {
        }
        String g16 = TemplateMsgTemplateManager.f191966a.g(params.a(), params.f());
        String c16 = params.c();
        if (c16 != null) {
            g16 = c16;
        }
        com.tencent.qqnt.rich.c d16 = new RichParser().d(g16, params.d(), new a(params));
        boolean z17 = true;
        if (g16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "template_empty_for_" + params.a() + "_" + params.f() + "_" + params.b();
        } else {
            if (params.d().length() != 0) {
                z17 = false;
            }
            if (z17) {
                str = "data_empty_for_" + params.a() + "_" + params.f() + "_" + params.b();
            } else if (d16 == null) {
                str = "error_parse_for_" + params.a() + "_" + params.f() + "_" + params.b();
            } else {
                List<com.tencent.android.androidbypass.viewgroup.b> a16 = d16.a();
                ArrayList arrayList = new ArrayList();
                Iterator<T> it5 = a16.iterator();
                while (true) {
                    com.tencent.android.androidbypass.viewgroup.f fVar = null;
                    if (!it5.hasNext()) {
                        break;
                    }
                    com.tencent.android.androidbypass.viewgroup.b bVar = (com.tencent.android.androidbypass.viewgroup.b) it5.next();
                    if (bVar instanceof com.tencent.android.androidbypass.viewgroup.f) {
                        fVar = (com.tencent.android.androidbypass.viewgroup.f) bVar;
                    }
                    if (fVar != null) {
                        arrayList.add(fVar);
                    }
                }
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                com.tencent.android.androidbypass.viewgroup.f fVar2 = (com.tencent.android.androidbypass.viewgroup.f) firstOrNull;
                if (fVar2 != null) {
                    kVar = fVar2.e();
                } else {
                    kVar = null;
                }
                if (kVar == null) {
                    str = "error_view_node_for_" + params.a() + "_" + params.f() + "_" + params.b();
                } else {
                    str = null;
                }
            }
        }
        return new h(d16, str);
    }

    @NotNull
    public final h d(@NotNull String appName, @NotNull String bizName, @NotNull String viewName, @NotNull String dataString) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h) iPatchRedirector.redirect((short) 2, this, appName, bizName, viewName, dataString);
        }
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(bizName, "bizName");
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        Intrinsics.checkNotNullParameter(dataString, "dataString");
        return c(new com.tencent.mobileqq.aio.msglist.holder.component.template.business.f(appName, bizName, viewName, dataString, null, null, 48, null));
    }

    @NotNull
    public final String e(@Nullable com.tencent.mobileqq.aio.msg.template.d templateMsgInfo) {
        JSONObject d16;
        String jSONObject;
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) templateMsgInfo);
        }
        if (templateMsgInfo != null && (d16 = templateMsgInfo.d()) != null && (jSONObject = d16.toString()) != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObject);
                String f16 = templateMsgInfo.f();
                if (f16 == null) {
                    f16 = "";
                }
                if (jSONObject2.has(f16)) {
                    String f17 = templateMsgInfo.f();
                    if (f17 == null) {
                        f17 = "";
                    }
                    string = jSONObject2.getString(f17);
                    Intrinsics.checkNotNullExpressionValue(string, "metaJSONObject.getString\u2026teMsgInfo.viewName ?: \"\")");
                } else {
                    string = jSONObject2.getString((String) jSONObject2.keys().next());
                    Intrinsics.checkNotNullExpressionValue(string, "metaJSONObject.getString\u2026JSONObject.keys().next())");
                }
                return string;
            } catch (Exception e16) {
                QLog.e("TemMsg.TemplateMsgViewHelper", 1, "prepareViewNodes failed for json exception:" + e16);
                return "";
            }
        }
        QLog.e("TemMsg.TemplateMsgViewHelper", 1, "getMetaString failed for ark json info is null");
        return "";
    }
}
