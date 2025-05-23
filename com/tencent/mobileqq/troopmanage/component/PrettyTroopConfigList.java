package com.tencent.mobileqq.troopmanage.component;

import GROUP.MessageRemindRsp;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.troopmanage.event.TroopManagePrettyEvent;
import com.tencent.mobileqq.troopmanage.pb.PrettyTroopEntry;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.utils.dr;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.config.business.qvip.QVIPPrettyTroopProcessor;
import com.tencent.mobileqq.vas.ipc.remote.IRedTouchIPC;
import com.tencent.mobileqq.vas.ipc.remote.RedTouchIPC;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/PrettyTroopConfigList;", "Lcom/tencent/mobileqq/troopmanage/component/bv;", "", "D", "Landroid/view/View$OnClickListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "E", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfo", "", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/listitem/Group;", "B", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PrettyTroopConfigList extends bv {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrettyTroopConfigList(QBaseActivity activity, QUIListItemAdapter adapter, LifecycleOwner lifecycleOwner, TroopManageViewModel viewModel, String dtReportPgId) {
        super(activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(PrettyTroopConfigList this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bv.l(this$0, "em_group_get_vip_number", null, 2, null);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        String url = PrettyTroopEntry.a(qQAppInterface, this$0.g().j());
        if (!TextUtils.isEmpty(url)) {
            IVipTraceDetailReport iVipTraceDetailReport = (IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class);
            Intrinsics.checkNotNullExpressionValue(url, "url");
            dr.g(iVipTraceDetailReport.buildTraceDetailUrl(url, IVipTraceDetailReport.FROM.TROOP_MANAGER_GET_BEAUTIFUL_NUMBER), qQAppInterface.getAccount(), this$0.b());
        } else {
            dr.c(this$0.g().h(), qQAppInterface.getAccount(), this$0.b());
        }
        this$0.E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final String D() {
        MessageRemindRsp W1;
        int i3;
        if (QVIPPrettyTroopProcessor.get().showCreateIcon || (W1 = h().W1()) == null || (i3 = W1.iLhGroupExpiredTime) <= 0) {
            return "";
        }
        if (i3 * 1000 > System.currentTimeMillis()) {
            String format = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(Long.valueOf(W1.iLhGroupExpiredTime * 1000));
            Intrinsics.checkNotNullExpressionValue(format, "{\n                val fo\u2026me * 1000L)\n            }");
            return format;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.uj6);
        Intrinsics.checkNotNullExpressionValue(qqStr, "{\n                HardCo\u2026n_3a7847f3)\n            }");
        return qqStr;
    }

    private final void E() {
        Object proxy = RemoteProxy.getProxy(RedTouchIPC.class);
        Intrinsics.checkNotNull(proxy, "null cannot be cast to non-null type com.tencent.mobileqq.vas.ipc.remote.IRedTouchIPC");
        IRedTouchIPC iRedTouchIPC = (IRedTouchIPC) proxy;
        String appInfo = iRedTouchIPC.getAppInfo("1303121");
        BusinessInfoCheckUpdate.AppInfo appInfo2 = new BusinessInfoCheckUpdate.AppInfo();
        try {
            appInfo2.mergeFrom(PluginBaseInfoHelper.Base64Helper.decode(appInfo, 0));
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        if (F(appInfo2)) {
            iRedTouchIPC.onRedTouchItemClick("1303121");
        }
    }

    private final boolean F(BusinessInfoCheckUpdate.AppInfo appInfo) {
        int i3;
        boolean contains$default;
        boolean contains$default2;
        if (g().i().bOwner) {
            i3 = 0;
        } else {
            i3 = g().i().bAdmin ? 1 : 3;
        }
        String str = appInfo.buffer.get();
        Intrinsics.checkNotNullExpressionValue(str, "appInfo.buffer.get()");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "{\\\"identity\\\":2}", false, 2, (Object) null);
        if (contains$default && (i3 == 0 || i3 == 1)) {
            return true;
        }
        String str2 = appInfo.buffer.get();
        Intrinsics.checkNotNullExpressionValue(str2, "appInfo.buffer.get()");
        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) ("{\\\"identity\\\":" + i3 + "}"), false, 2, (Object) null);
        return contains$default2;
    }

    private final View.OnClickListener z() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.ba
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrettyTroopConfigList.A(PrettyTroopConfigList.this, view);
            }
        };
    }

    public Group B() {
        ArrayList arrayList = new ArrayList();
        if (g().i().bOwner) {
            final com.tencent.mobileqq.widget.listitem.x v3 = bv.v(this, R.string.z8x, D(), null, null, 12, null);
            bv.n(this, "em_group_get_vip_number", null, 2, null);
            v3.x(z());
            v3.p(QVIPPrettyTroopProcessor.get().showCreateIcon);
            MutableLiveData<TroopManagePrettyEvent> i26 = h().i2();
            LifecycleOwner e16 = e();
            final Function1<TroopManagePrettyEvent, Unit> function1 = new Function1<TroopManagePrettyEvent, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.PrettyTroopConfigList$getComponentGroup$prettyTroopConfig$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopManagePrettyEvent troopManagePrettyEvent) {
                    invoke2(troopManagePrettyEvent);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TroopManagePrettyEvent troopManagePrettyEvent) {
                    v3.K().b(troopManagePrettyEvent.getReplyTextLeft());
                    v3.O().h(troopManagePrettyEvent.getReplyTextRight());
                }
            };
            i26.observe(e16, new Observer() { // from class: com.tencent.mobileqq.troopmanage.component.az
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    PrettyTroopConfigList.C(Function1.this, obj);
                }
            });
            arrayList.add(v3);
        }
        Object[] array = arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }
}
