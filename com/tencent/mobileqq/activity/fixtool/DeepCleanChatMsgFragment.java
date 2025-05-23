package com.tencent.mobileqq.activity.fixtool;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.persistence.g;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.persistence.transaction.DropTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IDataImportTableNamesCallback;
import com.tencent.util.LoadingUtil;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\u001a\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/activity/fixtool/DeepCleanChatMsgFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", OcrConfig.CHINESE, "Lmqq/app/AppRuntime;", "app", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "tableNames", "vh", "Lcom/tencent/mobileqq/persistence/g;", "yh", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/app/Dialog;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Dialog;", "mLoadingDialog", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "D", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "mDialog", "<init>", "()V", "E", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class DeepCleanChatMsgFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Dialog mLoadingDialog;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QQCustomDialog mDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/fixtool/DeepCleanChatMsgFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.fixtool.DeepCleanChatMsgFragment$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/activity/fixtool/DeepCleanChatMsgFragment$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IDataImportTableNamesCallback;", "", "result", "", "errMsg", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tableNames", "", "onResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements IDataImportTableNamesCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppRuntime f182219b;

        b(AppRuntime appRuntime) {
            this.f182219b = appRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DeepCleanChatMsgFragment.this, (Object) appRuntime);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IDataImportTableNamesCallback
        public void onResult(int result, @Nullable String errMsg, @Nullable ArrayList<String> tableNames) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(result), errMsg, tableNames);
                return;
            }
            if (result != 0) {
                QLog.d("DeepCleanChatMsgFragment", 1, "findDeleteTable result:" + result + ", errMsg:" + errMsg);
                return;
            }
            if (tableNames != null && !tableNames.isEmpty()) {
                z16 = true;
            }
            if (!z16) {
                QLog.d("DeepCleanChatMsgFragment", 1, "findDeleteTable tableNames empty");
                return;
            }
            DeepCleanChatMsgFragment deepCleanChatMsgFragment = DeepCleanChatMsgFragment.this;
            AppRuntime app = this.f182219b;
            Intrinsics.checkNotNullExpressionValue(app, "app");
            deepCleanChatMsgFragment.vh(app, tableNames);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50607);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public DeepCleanChatMsgFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(final DeepCleanChatMsgFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQCustomDialog qQCustomDialog = this$0.mDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        QQCustomDialog negativeButton = DialogUtil.createCustomDialog(this$0.getContext(), 230).setMessage(this$0.getString(R.string.f168272f7)).setPositiveButton(this$0.getString(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.fixtool.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DeepCleanChatMsgFragment.Bh(DeepCleanChatMsgFragment.this, dialogInterface, i3);
            }
        }).setNegativeButton(this$0.getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.fixtool.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DeepCleanChatMsgFragment.Ch(dialogInterface, i3);
            }
        });
        this$0.mDialog = negativeButton;
        if (negativeButton != null) {
            negativeButton.show();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(DeepCleanChatMsgFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.zh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void vh(AppRuntime app, ArrayList<String> tableNames) {
        int collectionSizeOrDefault;
        File databasePath = requireContext().getDatabasePath(app.getCurrentAccountUin() + DBBackupServiceImpl.DB_FILE_SUFFIX);
        File databasePath2 = requireContext().getDatabasePath("slowtable_" + app.getCurrentAccountUin() + DBBackupServiceImpl.DB_FILE_SUFFIX);
        QLog.d("DeepCleanChatMsgFragment", 1, "doClearMsg dbSize before drop table dbSize: " + databasePath.length() + ", slowDBSize: " + databasePath2.length());
        EntityManager createEntityManager = app.getEntityManagerFactory().createEntityManager();
        g yh5 = yh(app);
        try {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(tableNames, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (String str : tableNames) {
                QLog.d("DeepCleanChatMsgFragment", 1, "doClearMsg table to drop: " + str);
                arrayList.add(new DropTransaction(str));
            }
            createEntityManager.doMultiDBOperateByTransaction(arrayList);
            QLog.d("DeepCleanChatMsgFragment", 1, "doClearMsg quick db drop complete");
            if (yh5 != null) {
                yh5.doMultiDBOperateByTransaction(arrayList);
            }
            QLog.d("DeepCleanChatMsgFragment", 1, "doClearMsg slow db drop complete");
            ((QIphoneTitleBarFragment) this).mContentView.post(new Runnable() { // from class: com.tencent.mobileqq.activity.fixtool.d
                @Override // java.lang.Runnable
                public final void run() {
                    DeepCleanChatMsgFragment.wh(DeepCleanChatMsgFragment.this);
                }
            });
        } catch (Exception e16) {
            QLog.d("DeepCleanChatMsgFragment", 1, e16, new Object[0]);
            ((QIphoneTitleBarFragment) this).mContentView.post(new Runnable() { // from class: com.tencent.mobileqq.activity.fixtool.e
                @Override // java.lang.Runnable
                public final void run() {
                    DeepCleanChatMsgFragment.xh(DeepCleanChatMsgFragment.this);
                }
            });
        }
        QLog.d("DeepCleanChatMsgFragment", 1, "doClearMsg dbSize before VACUUM dbSize: " + databasePath.length() + ", slowDBSize: " + databasePath2.length());
        DBMethodProxy.execSQL(createEntityManager, "VACUUM");
        if (yh5 != null) {
            yh5.execSQL("VACUUM");
        }
        Dialog dialog = this.mLoadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        QLog.d("DeepCleanChatMsgFragment", 1, "doClearMsg dbSize after drop table dbSize: " + databasePath.length() + ", slowDBSize: " + databasePath2.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(DeepCleanChatMsgFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.getContext(), 2, this$0.getString(R.string.f168262f6), 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(DeepCleanChatMsgFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.getContext(), 1, this$0.getString(R.string.f168292f9), 1).show();
    }

    private final g yh(AppRuntime app) {
        QSlowTableManager qSlowTableManager;
        Manager manager = app.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
        if (manager instanceof QSlowTableManager) {
            qSlowTableManager = (QSlowTableManager) manager;
        } else {
            qSlowTableManager = null;
        }
        if (qSlowTableManager == null) {
            QLog.d("DeepCleanChatMsgFragment", 1, "getSlowEM qstMgr null");
            return null;
        }
        if (!qSlowTableManager.c().isOpen()) {
            QLog.d("DeepCleanChatMsgFragment", 1, "getSlowEM qstMgr close");
            return null;
        }
        return qSlowTableManager.e();
    }

    private final void zh() {
        IKernelService iKernelService;
        w msgService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null && (msgService = iKernelService.getMsgService()) != null) {
            Dialog dialog = this.mLoadingDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
            Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(getContext(), getString(R.string.f168302f_), false);
            this.mLoadingDialog = showLoadingDialog;
            Intrinsics.checkNotNull(showLoadingDialog);
            showLoadingDialog.show();
            msgService.getMqqDataImportTableNames(new b(peekAppRuntime));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.e_1;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        Dialog dialog = this.mLoadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.mLoadingDialog = null;
        QQCustomDialog qQCustomDialog = this.mDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        this.mDialog = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle(getString(R.string.f168282f8));
        ((Button) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.txf)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.fixtool.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeepCleanChatMsgFragment.Ah(DeepCleanChatMsgFragment.this, view2);
            }
        });
    }
}
