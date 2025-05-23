package com.tencent.biz.pubaccount.weishi.teenmode;

import com.tencent.biz.pubaccount.weishi.teenmode.e;
import com.tencent.biz.pubaccount.weishi.util.ai;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.studymode.g;
import com.tencent.mobileqq.studymode.l;
import com.tencent.mobileqq.studymode.o;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import tl.h;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0005B\u0019\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016R\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/teenmode/WSTeenModePart;", "Lrz/a;", "", "d", "", "a", "f", h.F, "j", "e", "onPagePause", "k", "onPageDestroy", "Lcom/tencent/mobileqq/app/QBaseActivity;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "b", "()Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "Ljava/lang/String;", "getSopName", "()Ljava/lang/String;", "sopName", "Lcom/tencent/mobileqq/studymode/o;", "Lkotlin/Lazy;", "c", "()Lcom/tencent/mobileqq/studymode/o;", "onModeChangedCallBack", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Ljava/lang/String;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSTeenModePart implements rz.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QBaseActivity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String sopName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy onModeChangedCallBack;

    public WSTeenModePart(QBaseActivity activity, String str) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.sopName = str;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<o>() { // from class: com.tencent.biz.pubaccount.weishi.teenmode.WSTeenModePart$onModeChangedCallBack$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final o invoke() {
                final WSTeenModePart wSTeenModePart = WSTeenModePart.this;
                return new o(new Function0<Unit>() { // from class: com.tencent.biz.pubaccount.weishi.teenmode.WSTeenModePart$onModeChangedCallBack$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        x.f("WSTeenModePart", "mode change:" + g.a());
                        if (g.a() == 2) {
                            WSTeenModePart.this.getActivity().finish();
                        }
                    }
                });
            }
        });
        this.onModeChangedCallBack = lazy;
    }

    private final void a() {
        AppRuntime appRuntime = this.activity.getAppRuntime();
        Manager manager = appRuntime != null ? appRuntime.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER) : null;
        l lVar = manager instanceof l ? (l) manager : null;
        if (lVar != null) {
            lVar.d(c());
        }
    }

    private final o c() {
        return (o) this.onModeChangedCallBack.getValue();
    }

    private final boolean d() {
        long currentTimeMillis = System.currentTimeMillis();
        long g16 = ai.g("key_teem_mode_show_time", 0L);
        long a16 = f.a() * 86400000;
        x.i("WSTeenModePart", "isShowDialog isShow:" + f.c() + ", lastShowTime:" + g16 + ", intervalMils:" + a16 + ", currentTimeMillis:" + currentTimeMillis);
        if (!f.c() || g16 + a16 >= currentTimeMillis) {
            return false;
        }
        ai.o("key_teem_mode_show_time", currentTimeMillis);
        return true;
    }

    private final void f() {
        AppRuntime appRuntime = this.activity.getAppRuntime();
        Manager manager = appRuntime != null ? appRuntime.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER) : null;
        l lVar = manager instanceof l ? (l) manager : null;
        if (lVar != null) {
            lVar.v(c());
        }
    }

    /* renamed from: b, reason: from getter */
    public final QBaseActivity getActivity() {
        return this.activity;
    }

    @Override // rz.a
    public void e() {
        x.i("WSTeenModePart", "onPageResume");
        if (d()) {
            e.Companion companion = e.INSTANCE;
            QBaseActivity qBaseActivity = this.activity;
            String str = this.sopName;
            if (str == null) {
                str = "";
            }
            companion.a(qBaseActivity, str);
        }
    }

    @Override // rz.a
    public void h() {
        x.i("WSTeenModePart", "onPageCreate");
    }

    @Override // rz.a
    public void j() {
        x.i("WSTeenModePart", "onPageViewCreated");
        a();
    }

    @Override // rz.a
    public void k() {
        x.i("WSTeenModePart", "onPageDestroyView");
    }

    @Override // rz.a
    public void onPageDestroy() {
        x.i("WSTeenModePart", "onPageDestroy");
        f();
    }

    @Override // rz.a
    public void onPagePause() {
        x.i("WSTeenModePart", "onPagePause");
    }
}
