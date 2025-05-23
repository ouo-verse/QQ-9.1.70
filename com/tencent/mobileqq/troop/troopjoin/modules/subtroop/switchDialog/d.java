package com.tencent.mobileqq.troop.troopjoin.modules.subtroop.switchDialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.qtroop.api.IECTroopApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.n;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.trpcprotocol.TroopJoinQunAutoSwitch$RetrieveSubGroupRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0001,B/\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0014\u0010 \u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0019R\u0014\u0010\"\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u0019R\u0014\u0010$\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u0015R\u0014\u0010&\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u0015\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/troop/troopjoin/modules/subtroop/switchDialog/d;", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "", "X", "", "subTroopId", "Y", "Lcom/tencent/mobileqq/troop/troopjoin/modules/subtroop/switchDialog/TroopJoinSubTroopSwitchDialogOption;", "option", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "", BdhLogUtil.LogTag.Tag_Req, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/content/Context;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "mContext", "D", "Ljava/lang/String;", "mainTroopId", "", "E", "I", "sourceId", UserInfo.SEX_FEMALE, "sourcePageDTId", "G", "H", "subTroopName", "memberNum", "J", "memberMaxNum", "K", "headerUrl", "L", "authSign", "Ltencent/trpcprotocol/TroopJoinQunAutoSwitch$RetrieveSubGroupRsp;", "subTroopInfo", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ltencent/trpcprotocol/TroopJoinQunAutoSwitch$RetrieveSubGroupRsp;ILjava/lang/String;)V", "M", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d extends QQCustomDialog {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String mainTroopId;

    /* renamed from: E, reason: from kotlin metadata */
    private final int sourceId;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final String sourcePageDTId;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final String subTroopId;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final String subTroopName;

    /* renamed from: I, reason: from kotlin metadata */
    private final int memberNum;

    /* renamed from: J, reason: from kotlin metadata */
    private final int memberMaxNum;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final String headerUrl;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final String authSign;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/troopjoin/modules/subtroop/switchDialog/d$a;", "", "", "DT_REPORT_PARAM_BTN_TYPE", "Ljava/lang/String;", "DT_REPORT_PARAM_MAIN_TROOP_ID", "DT_REPORT_PARAM_SOURCE_PAGE", "DT_REPORT_PARAM_SUB_TROOP_ID", "DT_REPORT_SWITCH_POP_CLICK", "DT_REPORT_SWITCH_POP_IMP", "LOG_TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopjoin.modules.subtroop.switchDialog.d$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57935);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Context mContext, @NotNull String mainTroopId, @NotNull TroopJoinQunAutoSwitch$RetrieveSubGroupRsp subTroopInfo, int i3, @NotNull String sourcePageDTId) {
        super(mContext, R.style.qZoneInputDialog);
        String str;
        String str2;
        int i16;
        String str3;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mainTroopId, "mainTroopId");
        Intrinsics.checkNotNullParameter(subTroopInfo, "subTroopInfo");
        Intrinsics.checkNotNullParameter(sourcePageDTId, "sourcePageDTId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mContext, mainTroopId, subTroopInfo, Integer.valueOf(i3), sourcePageDTId);
            return;
        }
        this.mContext = mContext;
        this.mainTroopId = mainTroopId;
        this.sourceId = i3;
        this.sourcePageDTId = sourcePageDTId;
        PBStringField pBStringField = subTroopInfo.group_id;
        if (pBStringField != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        this.subTroopId = str == null ? "" : str;
        PBStringField pBStringField2 = subTroopInfo.group_name;
        if (pBStringField2 != null) {
            str2 = pBStringField2.get();
        } else {
            str2 = null;
        }
        this.subTroopName = str2 == null ? "" : str2;
        PBUInt32Field pBUInt32Field = subTroopInfo.member_num;
        if (pBUInt32Field != null) {
            i16 = pBUInt32Field.get();
        } else {
            i16 = 0;
        }
        this.memberNum = i16;
        PBUInt32Field pBUInt32Field2 = subTroopInfo.member_max_num;
        this.memberMaxNum = pBUInt32Field2 != null ? pBUInt32Field2.get() : 0;
        PBStringField pBStringField3 = subTroopInfo.group_face;
        if (pBStringField3 != null) {
            str3 = pBStringField3.get();
        } else {
            str3 = null;
        }
        this.headerUrl = str3 == null ? "" : str3;
        PBStringField pBStringField4 = subTroopInfo.auth_sign;
        String str4 = pBStringField4 != null ? pBStringField4.get() : null;
        this.authSign = str4 != null ? str4 : "";
    }

    private final void Q(TroopJoinSubTroopSwitchDialogOption option) {
        Map<String, Object> R = R();
        R.put("btn_type", Integer.valueOf(option.getValue()));
        VideoReport.reportEvent("ev_group_switch_pop_clck", R);
    }

    private final Map<String, Object> R() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("now_page", this.sourcePageDTId);
        linkedHashMap.put("main_group_id", this.mainTroopId);
        linkedHashMap.put("option_group_id", this.subTroopId);
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Y(this$0.subTroopId);
        this$0.Q(TroopJoinSubTroopSwitchDialogOption.TROOP_INFO);
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(d this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q(TroopJoinSubTroopSwitchDialogOption.CANCEL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(d this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.X();
        this$0.Q(TroopJoinSubTroopSwitchDialogOption.JOIN);
    }

    private final void X() {
        ((IECTroopApi) QRoute.api(IECTroopApi.class)).joinTroop(this.mContext, this.subTroopId, this.subTroopName, this.authSign, this.sourceId, null);
        QLog.i("TroopJoinSubTroop", 1, "tap join sub troop, [subTroopId:" + this.subTroopId + "]");
    }

    private final void Y(String subTroopId) {
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).openTroopInfoActivity(this.mContext, aq.b(subTroopId, this.sourceId), 2);
        QLog.i("TroopJoinSubTroop", 1, "tap jump open sub troop info activity, [subTroopId:" + subTroopId + "]");
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.hzs);
        VideoReport.reportEvent("ev_group_switch_pop_imp", R());
        TextView textView = (TextView) findViewById(R.id.f102405xt);
        if (textView != null) {
            textView.setText(this.subTroopName);
        }
        TextView textView2 = (TextView) findViewById(R.id.f102395xs);
        if (textView2 != null) {
            textView2.setText(this.memberNum + "/" + this.memberMaxNum);
        }
        ImageView imageView = (ImageView) findViewById(R.id.f102385xr);
        if (imageView != null) {
            n.a(imageView, this.headerUrl);
        }
        View findViewById = findViewById(R.id.f102375xq);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopjoin.modules.subtroop.switchDialog.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.S(d.this, view);
                }
            });
        }
        setNegativeButton(R.string.f234597_d, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopjoin.modules.subtroop.switchDialog.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                d.U(d.this, dialogInterface, i3);
            }
        });
        setPositiveButton(R.string.f234607_e, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopjoin.modules.subtroop.switchDialog.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                d.W(d.this, dialogInterface, i3);
            }
        });
    }
}
