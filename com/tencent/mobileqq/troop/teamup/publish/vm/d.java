package com.tencent.mobileqq.troop.teamup.publish.vm;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.StringUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GetTeamUpTemplateListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetTeamUpTemplateListRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetTeamUpTemplateListCallback;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTemplate;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\n8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/publish/vm/d;", "Landroidx/lifecycle/ViewModel;", "", "P1", "", "i", "Ljava/lang/String;", "N1", "()Ljava/lang/String;", "troopUin", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTemplate;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "M1", "()Landroidx/lifecycle/MutableLiveData;", DKConfiguration.Directory.TEMPLATES, "", BdhLogUtil.LogTag.Tag_Conn, "O1", "isLoadSucceed", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isLoadSucceed;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<TeamUpTemplate>> templates;

    public d(@NotNull Bundle bundle) {
        List emptyList;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
            return;
        }
        String string = bundle.getString("troop_uin", "");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(AppConstants.Key.TROOP_UIN, \"\")");
        this.troopUin = string;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.templates = new MutableLiveData<>(emptyList);
        this.isLoadSucceed = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(d this$0, int i3, String str, GetTeamUpTemplateListRsp getTeamUpTemplateListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0 && getTeamUpTemplateListRsp != null) {
            this$0.templates.postValue(getTeamUpTemplateListRsp.templates);
            this$0.isLoadSucceed.postValue(Boolean.TRUE);
            return;
        }
        QLog.e("TroopTeamUp.PublishTemplatesVM", 1, "errCode=" + i3 + ", errMsg=" + str);
        this$0.isLoadSucceed.postValue(Boolean.FALSE);
    }

    @NotNull
    public final MutableLiveData<List<TeamUpTemplate>> M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.templates;
    }

    @NotNull
    public final String N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    @NotNull
    public final MutableLiveData<Boolean> O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.isLoadSucceed;
    }

    public final void P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.isLoadSucceed.postValue(null);
        s i3 = bg.i(null, 1, null);
        if (i3 == null) {
            QLog.e("TroopTeamUp.PublishTemplatesVM", 1, "service == null");
            this.isLoadSucceed.postValue(Boolean.FALSE);
        } else {
            GetTeamUpTemplateListReq getTeamUpTemplateListReq = new GetTeamUpTemplateListReq();
            getTeamUpTemplateListReq.app = "team_up";
            getTeamUpTemplateListReq.groupCode = StringUtils.toLong(this.troopUin);
            i3.getTeamUpTemplateList(getTeamUpTemplateListReq, new IGetTeamUpTemplateListCallback() { // from class: com.tencent.mobileqq.troop.teamup.publish.vm.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTeamUpTemplateListCallback
                public final void onResult(int i16, String str, GetTeamUpTemplateListRsp getTeamUpTemplateListRsp) {
                    d.Q1(d.this, i16, str, getTeamUpTemplateListRsp);
                }
            });
        }
    }
}
