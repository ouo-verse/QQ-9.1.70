package com.tencent.mobileqq.leba.list;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.leba.entity.h;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.l;
import com.tencent.mobileqq.leba.list.LebaPluginListAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/leba/list/LebaPluginListAdapter$pluginClickListener$1", "Lcom/tencent/mobileqq/leba/entity/h;", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "a", "c", "b", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginListAdapter$pluginClickListener$1 implements h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LebaPluginListAdapter f240625a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LebaPluginListAdapter$pluginClickListener$1(LebaPluginListAdapter lebaPluginListAdapter) {
        this.f240625a = lebaPluginListAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lebaPluginListAdapter);
        }
    }

    public void a(@NotNull View v3, @Nullable n item, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, v3, item, Integer.valueOf(position));
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            this.f240625a.v().c(v3, item);
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.h
    public void b(@NotNull View v3, @NotNull n item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("LebaPluginListAdapter", 1, "onMoreClick from list");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ReportController.o(peekAppRuntime, "CliOper", "", "", "trends_tab", "click_tt_right", 0, 0, "", "", "", "");
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IR\u2026nstant.MAIN\n            )");
        ((IRedTouchManager) runtimeService).onRedTouchItemClick("150000");
        com.tencent.mobileqq.leba.core.e.a().f240377c = true;
        Context context = v3.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        com.tencent.mobileqq.leba.core.f.q((Activity) context, peekAppRuntime, false, 1);
    }

    @Override // com.tencent.mobileqq.leba.entity.h
    public void c(@NotNull View v3, @NotNull n item, final int position) {
        BusinessInfoCheckUpdate.AppInfo c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, v3, item, Integer.valueOf(position));
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(item, "item");
        com.tencent.mobileqq.leba.entity.f fVar = new com.tencent.mobileqq.leba.entity.f();
        fVar.f240480d = false;
        fVar.f240477a = item.f240504a;
        fVar.f240478b = position + 1;
        if (v3 instanceof RedTouch) {
            fVar.f240479c = l.b((RedTouch) v3);
        }
        if (TianshuRedTouch.INSTANCE.j() && (c16 = this.f240625a.lebaRedTouch.c(MobileQQ.sMobileQQ.peekAppRuntime(), String.valueOf(item.f240504a))) != null) {
            fVar.f240479c = com.tencent.mobileqq.tianshu.ui.a.b(c16);
            com.tencent.mobileqq.leba.report.d.g(v3, item, position, String.valueOf(item.f240504a));
        }
        this.f240625a.v().q(v3, item, fVar);
        final LebaPluginListAdapter lebaPluginListAdapter = this.f240625a;
        if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
            LebaPluginListAdapter.b w3 = lebaPluginListAdapter.w();
            if (w3 != null) {
                w3.P0(position);
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(position) { // from class: com.tencent.mobileqq.leba.list.LebaPluginListAdapter$pluginClickListener$1$onPluginClick$$inlined$runOnMainThread$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f240618d;

            {
                this.f240618d = position;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaPluginListAdapter.this, position);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                LebaPluginListAdapter.b w16 = LebaPluginListAdapter.this.w();
                if (w16 != null) {
                    w16.P0(this.f240618d);
                }
            }
        });
    }
}
