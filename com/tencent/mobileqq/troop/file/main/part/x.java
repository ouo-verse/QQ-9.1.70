package com.tencent.mobileqq.troop.file.main.part;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.file.main.vm.TroopFileMainVM;
import com.tencent.mobileqq.util.bc;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/part/x;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "d", "Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "getViewModel", "()Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "viewModel", "", "A9", "()Ljava/lang/String;", "troopUinStr", "", "z9", "()J", "from", "x9", "folderId", "<init>", "(Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class x extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TroopFileMainVM viewModel;

    public x(TroopFileMainVM viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
    }

    private final String A9() {
        return this.viewModel.T1().troopUinStr;
    }

    private final String x9() {
        return this.viewModel.T1().folderId;
    }

    private final long z9() {
        return this.viewModel.T1().troopUinL;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        int i3;
        super.onPartCreate(activity, savedInstanceState);
        Manager manager = bc.a(this).getManager(QQManagerFactory.TROOP_MANAGER);
        TroopManager troopManager = manager instanceof TroopManager ? (TroopManager) manager : null;
        TroopInfo k3 = troopManager != null ? troopManager.k(A9()) : null;
        ReportController.o(bc.a(this), "P_CliOper", "Grp_files", "", "search", "exp_home", 0, 0, A9(), AppSetting.d(), "", "");
        if (((int) z9()) == 4000) {
            ReportController.o(bc.a(this), "P_CliOper", "Grp_files", "", "memberlist", "exp", 0, 0, A9(), "", "", "");
            if (k3 != null) {
                if (k3.isTroopOwner(bc.a(this).getCurrentAccountUin())) {
                    i3 = 1;
                } else if (k3.isTroopAdmin(bc.a(this).getCurrentAccountUin())) {
                    i3 = 2;
                }
                QQAppInterface a16 = bc.a(this);
                String A9 = A9();
                String valueOf = String.valueOf(1 ^ (Intrinsics.areEqual("/", x9()) ? 1 : 0));
                StringBuilder sb5 = new StringBuilder();
                sb5.append(i3);
                ReportController.o(a16, "P_CliOper", "Grp_files", "", "file", "exp", 0, 0, A9, valueOf, sb5.toString(), "");
                return;
            }
            i3 = 3;
            QQAppInterface a162 = bc.a(this);
            String A92 = A9();
            String valueOf2 = String.valueOf(1 ^ (Intrinsics.areEqual("/", x9()) ? 1 : 0));
            StringBuilder sb52 = new StringBuilder();
            sb52.append(i3);
            ReportController.o(a162, "P_CliOper", "Grp_files", "", "file", "exp", 0, 0, A92, valueOf2, sb52.toString(), "");
            return;
        }
        if (((int) z9()) == 5000) {
            ReportController.o(bc.a(this), "dc00899", "Grp_chatRecord", "", "chatRecor_file", "fil_exp", 0, 0, A9(), "", "", "");
        }
    }
}
