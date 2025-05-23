package com.tencent.mobileqq.troop.homework.parser;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import com.tencent.qqnt.troopmemberlist.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u001b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J.\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/parser/b;", "Lcom/tencent/mobileqq/utils/ax;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "H", "", "b", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends ax {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/parser/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.parser.b$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54265);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable Context context) {
        super(baseQQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(b this$0, TroopInfo troopInfo, String str, Bundle extBundle, boolean z16, List troopMemberList) {
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(extBundle, "$extBundle");
        Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
        QLog.i("TeacherHistoryMsgJumpAction", 1, "[fetchTroopMemberInner] isSuccess = " + z16 + " size = " + troopMemberList.size());
        Intrinsics.checkNotNullExpressionValue(troopInfo, "troopInfo");
        ArrayList<String> H = this$0.H(troopInfo, troopMemberList);
        IHWTroopUIApi iHWTroopUIApi = (IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class);
        Context context = this$0.f307437b;
        if (context != null) {
            str2 = context.getString(R.string.f235737cg);
        } else {
            str2 = null;
        }
        iHWTroopUIApi.openTeacherHistoryMsgPage(str2, str, H, extBundle);
    }

    private final ArrayList<String> H(TroopInfo troopInfo, List<? extends TroopMemberInfo> troopMemberList) {
        int i3;
        ArrayList<String> arrayList = new ArrayList<>();
        for (TroopMemberInfo troopMemberInfo : troopMemberList) {
            MemberRole memberRole = troopMemberInfo.role;
            if (memberRole == MemberRole.OWNER || memberRole == MemberRole.ADMIN || (troopInfo.isHomeworkTroop() && ((i3 = troopMemberInfo.titleId) == 332 || i3 == 333))) {
                arrayList.add(troopMemberInfo.memberuin);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        QLog.i("TeacherHistoryMsgJumpAction", 1, "[doAction] attrs = " + this.f307441f);
        final String str = this.f307441f.get("troop_uin");
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        IRuntimeService runtimeService = e().getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "getApp().getRuntimeServi\u2026va, ProcessConstant.MAIN)");
        final TroopInfo findTroopInfo = ((ITroopInfoService) runtimeService).findTroopInfo(str);
        if (findTroopInfo == null) {
            QLog.i("TeacherHistoryMsgJumpAction", 1, "[doAction] troopInfo is null");
            return false;
        }
        final Bundle bundle = new Bundle();
        HashMap<String, String> attrs = this.f307441f;
        Intrinsics.checkNotNullExpressionValue(attrs, "attrs");
        for (Map.Entry<String, String> entry : attrs.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        TroopMemberListRepo.INSTANCE.fetchTroopMemberListWithExtInfo(str, null, true, "TeacherHistoryMsgJumpAction", new f() { // from class: com.tencent.mobileqq.troop.homework.parser.a
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z17, List list) {
                b.G(b.this, findTroopInfo, str, bundle, z17, list);
            }
        });
        return true;
    }
}
