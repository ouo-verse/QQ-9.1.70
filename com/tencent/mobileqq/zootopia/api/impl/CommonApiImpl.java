package com.tencent.mobileqq.zootopia.api.impl;

import android.content.DialogInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.zootopia.api.ICommonApi;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.api.f;
import com.tencent.mobileqq.zootopia.api.impl.CommonApiImpl;
import com.tencent.mobileqq.zootopia.lua.ar;
import com.tencent.mobileqq.zootopia.minors.util.LoadingDialogHelperFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import iw4.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pu4.o;
import pu4.p;
import rc3.TargetTask;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0016J\u001e\u0010\u000e\u001a\u00020\r2\u0014\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0018\u00010\u000bH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/impl/CommonApiImpl;", "Lcom/tencent/mobileqq/zootopia/api/ICommonApi;", "Lcom/tencent/mobileqq/zootopia/api/f;", "getDialogHandler", "", "getSelfGender", "", "Lpu4/o;", "getSelfClothesIdList", "Lpu4/p;", "getSelfClothesInfo", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "", "requestSelfClothesInfo", "refreshClothesCache", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "plugin", "registerZootopiaLuaPlugin", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CommonApiImpl implements ICommonApi {
    public static final String TAG = "CommonApiImpl";

    @Override // com.tencent.mobileqq.zootopia.api.ICommonApi
    public f getDialogHandler() {
        return new b();
    }

    @Override // com.tencent.mobileqq.zootopia.api.ICommonApi
    public List<o> getSelfClothesIdList() {
        return pg3.a.f426176a.d();
    }

    @Override // com.tencent.mobileqq.zootopia.api.ICommonApi
    public List<p> getSelfClothesInfo() {
        return pg3.a.f426176a.e();
    }

    @Override // com.tencent.mobileqq.zootopia.api.ICommonApi
    public int getSelfGender() {
        d f16 = pg3.a.f426176a.f();
        if (f16 != null) {
            return f16.f408881b;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.zootopia.api.ICommonApi
    public void refreshClothesCache() {
        pg3.a.f426176a.h();
    }

    @Override // com.tencent.mobileqq.zootopia.api.ICommonApi
    public void registerZootopiaLuaPlugin(LuaBasePlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        ar.f328509a.b(plugin);
    }

    @Override // com.tencent.mobileqq.zootopia.api.ICommonApi
    public void requestSelfClothesInfo(e<List<p>> callback) {
        pg3.a.f426176a.i(callback);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JV\u0010\u000f\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0016\u0010\u000e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH\u0016R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/zootopia/api/impl/CommonApiImpl$b", "Lcom/tencent/mobileqq/zootopia/api/f;", "", "title", "", "content", "leftBtnText", "rightBtnText", "Landroid/content/DialogInterface$OnClickListener;", "onConfirm", "onCancel", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "", "onDialogCreateCallback", "a", "Ljava/lang/String;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "b", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "dialog", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements f {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String taskId = LoadingDialogHelperFragment.INSTANCE.c();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private QQCustomDialog dialog;

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(b this$0, DialogInterface dialogInterface) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            LoadingDialogHelperFragment.INSTANCE.b(this$0.taskId);
        }

        @Override // com.tencent.mobileqq.zootopia.api.f
        public void a(final String title, final CharSequence content, final String leftBtnText, final String rightBtnText, final DialogInterface.OnClickListener onConfirm, final DialogInterface.OnClickListener onCancel, final Function1<? super QQCustomDialog, Unit> onDialogCreateCallback) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(leftBtnText, "leftBtnText");
            Intrinsics.checkNotNullParameter(rightBtnText, "rightBtnText");
            QLog.i(CommonApiImpl.TAG, 4, "showCommonDialog inject");
            LoadingDialogHelperFragment.Companion.e(LoadingDialogHelperFragment.INSTANCE, new TargetTask(new Runnable() { // from class: com.tencent.mobileqq.zootopia.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    CommonApiImpl.b.d(CommonApiImpl.b.this, title, content, leftBtnText, rightBtnText, onConfirm, onCancel, onDialogCreateCallback);
                }
            }, this.taskId), 0L, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(final b this$0, String str, CharSequence content, String leftBtnText, String rightBtnText, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, Function1 function1) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(content, "$content");
            Intrinsics.checkNotNullParameter(leftBtnText, "$leftBtnText");
            Intrinsics.checkNotNullParameter(rightBtnText, "$rightBtnText");
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity == null) {
                return;
            }
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 0, str, content, leftBtnText, rightBtnText, onClickListener, onClickListener2);
            this$0.dialog = createCustomDialog;
            if (function1 != null) {
                function1.invoke(createCustomDialog);
            }
            QQCustomDialog qQCustomDialog = this$0.dialog;
            if (qQCustomDialog != null) {
                qQCustomDialog.setCancelable(false);
            }
            QQCustomDialog qQCustomDialog2 = this$0.dialog;
            if (qQCustomDialog2 != null) {
                qQCustomDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.zootopia.api.impl.b
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        CommonApiImpl.b.e(CommonApiImpl.b.this, dialogInterface);
                    }
                });
            }
            QQCustomDialog qQCustomDialog3 = this$0.dialog;
            if (qQCustomDialog3 != null) {
                qQCustomDialog3.show();
            }
        }
    }
}
