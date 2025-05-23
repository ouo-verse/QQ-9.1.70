package com.tencent.biz.pubaccount.weishi.teenmode;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.teenmode.WSTeenModeDialogReportHelper;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.studymode.JumpKidModeMgr;
import com.tencent.mobileqq.studymode.KidModeObserver;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/teenmode/e;", "Ll10/a;", "", "j", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "i", "o", "show", "dismiss", "cancel", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "e", "Ljava/lang/String;", "getSopName", "()Ljava/lang/String;", "sopName", "Lcom/tencent/mobileqq/studymode/KidModeObserver;", "f", "Lcom/tencent/mobileqq/studymode/KidModeObserver;", "needPhoneVerifyObserver", "<init>", "(Landroid/app/Activity;Ljava/lang/String;)V", h.F, "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class e extends l10.a {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String sopName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private KidModeObserver needPhoneVerifyObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/teenmode/e$a;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "sopName", "", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.pubaccount.weishi.teenmode.e$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(QBaseActivity activity, String sopName) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(sopName, "sopName");
            new e(activity, sopName).show();
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Activity activity, String sopName) {
        super(activity, R.style.f173282zr);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sopName, "sopName");
        this.activity = activity;
        this.sopName = sopName;
        j();
        this.needPhoneVerifyObserver = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(e this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        JumpKidModeMgr.b().t(this$0.activity, 10);
        this$0.dismiss();
        WSTeenModeDialogReportHelper.b(WSTeenModeDialogReportHelper.BtnType.ENTER, this$0.sopName);
        x.i("WSTeenModeDialog", "\u8fdb\u5165\u9752\u5c11\u5e74\u6a21\u5f0f");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(e this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        WSTeenModeDialogReportHelper.b(WSTeenModeDialogReportHelper.BtnType.KNOW, this$0.sopName);
        x.i("WSTeenModeDialog", "\u6211\u77e5\u9053");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(e this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        WSTeenModeDialogReportHelper.b(WSTeenModeDialogReportHelper.BtnType.CLOSE, this$0.sopName);
        x.i("WSTeenModeDialog", "\u53f3\u4e0a\u89d2\u5173\u95ed\u6309\u94ae");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(e this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WSTeenModeDialogReportHelper.b(WSTeenModeDialogReportHelper.BtnType.OTHER, this$0.sopName);
        x.i("WSTeenModeDialog", "\u9752\u5c11\u5e74\u6a21\u5f0f\u5f39\u7a97\u5916\u533a\u57df");
    }

    private final void o() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ((QQAppInterface) peekAppRuntime).unRegistObserver(this.needPhoneVerifyObserver);
        this.needPhoneVerifyObserver = null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        o();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        o();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (StudyModeManager.l() == 0) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            i(qQAppInterface);
            KidModeServlet.m(qQAppInterface);
        }
        WSTeenModeDialogReportHelper.c(this.sopName);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/pubaccount/weishi/teenmode/e$b", "Lcom/tencent/mobileqq/studymode/KidModeObserver;", "Lcom/tencent/mobileqq/studymode/KidModeObserver$QueryPasswordStateResult;", "result", "", "c", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b extends KidModeObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void c(KidModeObserver.QueryPasswordStateResult result) {
            if (result != null && result.errCode == 0) {
                StudyModeManager.N(result.passwordState, result.salt);
            }
        }
    }

    private final void i(QQAppInterface app) {
        if (app != null) {
            app.registObserver(this.needPhoneVerifyObserver);
        }
    }

    private final void j() {
        setContentView(R.layout.d29);
        findViewById(R.id.p5n).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.teenmode.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.k(e.this, view);
            }
        });
        findViewById(R.id.p5j).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.teenmode.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.l(e.this, view);
            }
        });
        findViewById(R.id.p5i).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.teenmode.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.m(e.this, view);
            }
        });
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.biz.pubaccount.weishi.teenmode.d
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                e.n(e.this, dialogInterface);
            }
        });
    }
}
