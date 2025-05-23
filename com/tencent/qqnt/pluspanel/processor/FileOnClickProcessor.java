package com.tencent.qqnt.pluspanel.processor;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J0\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\fH\u0002J2\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/FileOnClickProcessor;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "", "uin", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/aio/api/runtime/a;", "context", "", "f", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "", "oldChatType", "peerUid", "e", "d", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FileOnClickProcessor implements com.tencent.qqnt.pluspanel.logic.b {

    /* renamed from: a, reason: collision with root package name */
    private static final a f360465a = new a(null);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/FileOnClickProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/pluspanel/processor/FileOnClickProcessor$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f360467b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AppRuntime f360468c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f360469d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f360470e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f360471f;

        b(FragmentActivity fragmentActivity, AppRuntime appRuntime, long j3, int i3, String str) {
            this.f360467b = fragmentActivity;
            this.f360468c = appRuntime;
            this.f360469d = j3;
            this.f360470e = i3;
            this.f360471f = str;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            FileOnClickProcessor.this.e(this.f360467b, this.f360468c, String.valueOf(this.f360469d), this.f360470e, this.f360471f);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(results, "results");
            FileOnClickProcessor.this.e(this.f360467b, this.f360468c, String.valueOf(this.f360469d), this.f360470e, this.f360471f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(long uin, AppRuntime app, com.tencent.aio.api.runtime.a context) {
        FragmentActivity requireActivity = context.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
        int c16 = com.tencent.nt.adapter.session.c.c(context.g().r().c().e());
        String j3 = context.g().r().c().j();
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(requireActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_FILE, QQPermissionConstants.Business.SCENE.QQ_FILE_AIO_FILE_PANEL));
        Intrinsics.checkNotNullExpressionValue(qQPermission, "getQQPermission(\n       \u2026AIO_FILE_PANEL)\n        )");
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b(requireActivity, app, uin, c16, j3));
        } else {
            e(requireActivity, app, String.valueOf(uin), c16, j3);
        }
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, final com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        context.e().h(PlusPanelEvent.UpdatePlusPanel.f360444d);
        com.tencent.qqnt.pluspanel.processor.util.a.f360544a.a(context, new Function2<Long, QQAppInterface, Unit>() { // from class: com.tencent.qqnt.pluspanel.processor.FileOnClickProcessor$onClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l3, QQAppInterface qQAppInterface) {
                invoke(l3.longValue(), qQAppInterface);
                return Unit.INSTANCE;
            }

            public final void invoke(long j3, QQAppInterface app) {
                Intrinsics.checkNotNullParameter(app, "app");
                FileOnClickProcessor.this.f(j3, app, context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(Activity activity, AppRuntime app, String uin, int oldChatType, String peerUid) {
        if (oldChatType == 1) {
            ReportController.o(app, "CliOper", "", "", "0X800407E", "0X800407E", 0, 0, "", "", "", "");
            d(activity, app, uin, oldChatType, peerUid);
            return;
        }
        Intrinsics.checkNotNull(app, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) app;
        l61.a.b(qQAppInterface, "0X800407C", oldChatType);
        FileManagerReporter.a aVar = new FileManagerReporter.a();
        aVar.f209157b = "send_file";
        aVar.f209158c = 1;
        FileManagerReporter.addData(qQAppInterface.getCurrentAccountUin(), aVar);
        d(activity, app, uin, oldChatType, peerUid);
    }

    private final void d(Activity activity, AppRuntime app, String uin, int oldChatType, String peerUid) {
        ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).openFileSelectorByAIO(activity, oldChatType, uin, peerUid, app.getCurrentAccountUin(), oldChatType != 0 ? oldChatType != 1 ? oldChatType != 3000 ? -1 : 5 : 3 : 1);
        activity.overridePendingTransition(R.anim.f154424l, R.anim.f154425m);
    }
}
