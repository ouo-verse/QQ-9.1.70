package com.tencent.mobileqq.troop.appscenter.mvi;

import android.app.Dialog;
import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.appscenter.mvi.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import com.tencent.qqnt.kernel.nativeinterface.GetAppCenterRsp;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\n\u00a2\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "isSuccess", "", "errCode", "", "errMsg", "", "rsp", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAppCenterRsp;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopAppsViewModel$getAppCenter$1 extends Lambda implements Function4<Boolean, Integer, String, GetAppCenterRsp, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isOwnerOrAdmin;
    final /* synthetic */ ArrayList<AppDetail> $shortcutApps;
    final /* synthetic */ int $size;
    final /* synthetic */ TroopAppsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopAppsViewModel$getAppCenter$1(TroopAppsViewModel troopAppsViewModel, Context context, boolean z16, int i3, ArrayList<AppDetail> arrayList) {
        super(4);
        this.this$0 = troopAppsViewModel;
        this.$context = context;
        this.$isOwnerOrAdmin = z16;
        this.$size = i3;
        this.$shortcutApps = arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopAppsViewModel, context, Boolean.valueOf(z16), Integer.valueOf(i3), arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopAppsViewModel this$0, ArrayList currentInfoList) {
        MutableLiveData mUiState;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentInfoList, "$currentInfoList");
        mUiState = this$0.getMUiState();
        mUiState.postValue(new b.a(currentInfoList, null));
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str, GetAppCenterRsp getAppCenterRsp) {
        invoke(bool.booleanValue(), num.intValue(), str, getAppCenterRsp);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16, int i3, @Nullable String str, @Nullable GetAppCenterRsp getAppCenterRsp) {
        boolean z17;
        Dialog dialog;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, getAppCenterRsp);
            return;
        }
        if (z16 && getAppCenterRsp != null) {
            this.this$0.G2(this.$context, getAppCenterRsp, this.$isOwnerOrAdmin, this.$size, this.$shortcutApps);
        } else {
            QLog.e("TroopAppsCenter.TroopAppsViewModel", 1, "getAppCenter result " + i3 + " err: " + str + " troopUin:" + this.this$0.s2());
            final ArrayList arrayList = new ArrayList();
            z17 = this.this$0.isManageFlag;
            arrayList.add(new com.tencent.mobileqq.troop.appscenter.data.d("\u52a0\u8f7d\u5931\u8d25", z17));
            final TroopAppsViewModel troopAppsViewModel = this.this$0;
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.appscenter.mvi.k
                @Override // java.lang.Runnable
                public final void run() {
                    TroopAppsViewModel$getAppCenter$1.b(TroopAppsViewModel.this, arrayList);
                }
            });
        }
        dialog = this.this$0.loadDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        dialog.dismiss();
    }
}
