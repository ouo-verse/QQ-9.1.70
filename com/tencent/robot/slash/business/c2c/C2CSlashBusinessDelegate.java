package com.tencent.robot.slash.business.c2c;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import b54.FunctionReportArgs;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureType;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFilter;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotScene;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.action.api.IRobotActionApi;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import com.tencent.robot.slash.businessapi.ConvertSearchTools;
import com.tencent.robot.slash.businessapi.SearchSessionParams;
import com.tencent.robot.slash.businessapi.c;
import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import h44.OpenRobotProfileCardArgs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import n14.d;
import n64.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w64.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u00101\u001a\u00020/\u0012\u0006\u00103\u001a\u00020\u0014\u00a2\u0006\u0004\b4\u00105J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J,\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0014H\u0016J\u0010\u0010'\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0014H\u0016J\b\u0010(\u001a\u00020\bH\u0016J\u0010\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u0010,\u001a\u00020\b2\u0006\u0010*\u001a\u00020)H\u0016J\u0018\u0010.\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u0002H\u0016R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u00100R\u0014\u00103\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/robot/slash/business/c2c/C2CSlashBusinessDelegate;", "Lcom/tencent/robot/slash/businessapi/c;", "", "keyword", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "robotInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "commandInfo", "", "p", ZPlanPublishSource.FROM_SCHEME, "", "o", "(Ljava/lang/String;)Ljava/lang/Integer;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "robotUin", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", DomainData.DOMAIN_NAME, "Landroid/view/View;", "l", "Lcom/tencent/mvi/api/runtime/b;", "mviContext", "Lw64/n;", "Lu54/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "args", "Lcom/tencent/robot/slash/businessapi/d;", "k", "searchResponse", "Lcom/tencent/robot/slash/businessapi/a;", "j", "Lb74/a;", "itemData", "a", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "d", "f", "c", "Lb54/a;", "itemArgs", "g", "e", "robotTinyId", "b", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Landroid/view/View;", "mAnchorView", "<init>", "(Lcom/tencent/aio/api/runtime/a;Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class C2CSlashBusinessDelegate implements c {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final a f368417c = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mAnchorView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/slash/business/c2c/C2CSlashBusinessDelegate$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public C2CSlashBusinessDelegate(@NotNull com.tencent.aio.api.runtime.a mAIOContext, @NotNull View mAnchorView) {
        Intrinsics.checkNotNullParameter(mAIOContext, "mAIOContext");
        Intrinsics.checkNotNullParameter(mAnchorView, "mAnchorView");
        this.mAIOContext = mAIOContext;
        this.mAnchorView = mAnchorView;
    }

    private final HashMap<String, Object> n(String robotUin) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.PG_ID, "pg_sgrp_robot_slash_halfscreen");
        hashMap.put("c2c_id", robotUin);
        hashMap.put("invoke_scene", 1);
        return hashMap;
    }

    private final Integer o(String scheme) {
        String queryParameter;
        Integer intOrNull;
        if (scheme == null) {
            return null;
        }
        d match = ((IRobotActionApi) QRoute.api(IRobotActionApi.class)).match(scheme);
        boolean z16 = false;
        if (match != null && match.getType() == 1) {
            z16 = true;
        }
        if (!z16 || (queryParameter = Uri.parse(scheme).getQueryParameter("anchor")) == null) {
            return null;
        }
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(queryParameter);
        return intOrNull;
    }

    private final void p(String keyword, CommonBotInfo robotInfo, CommonBotFeatureInfo commandInfo) {
        if (h34.a.f(robotInfo)) {
            Context context = this.mAIOContext.c().getContext();
            if (context == null) {
                return;
            }
            QQToast.makeText(context, context.getString(R.string.f222486dn), 1).show();
            return;
        }
        this.mAIOContext.e().h(new InputEditTextMsgIntent.SetTextToEditText(commandInfo.name + " ", false));
        Integer o16 = o(commandInfo.schemaUrl);
        if (o16 != null) {
            ((IRobotActionApi) QRoute.api(IRobotActionApi.class)).showAnchor("C2CSlashBusinessDelegate", this.mAIOContext, o16.intValue(), new Function2<Boolean, String, Unit>() { // from class: com.tencent.robot.slash.business.c2c.C2CSlashBusinessDelegate$handleCommandItemClick$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                    invoke(bool.booleanValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @NotNull String errorMsg) {
                    Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                    if (z16) {
                        return;
                    }
                    QLog.e("C2CSlashBusinessDelegate", 1, "[showAnchor]: errMsg=" + errorMsg);
                }
            });
        } else {
            this.mAIOContext.e().h(new PanelContainerMsgIntent.ShowKeyboardMsgIntent("C2CSlashBusinessDelegate"));
        }
    }

    private final void q(CommonBotInfo robotInfo, CommonBotFeatureInfo commandInfo) {
        Context context = this.mAIOContext.c().getContext();
        if (context == null) {
            return;
        }
        if (h34.a.f(robotInfo)) {
            QQToast.makeText(context, context.getString(R.string.f222486dn), 1).show();
            return;
        }
        int i3 = commandInfo.type;
        if (i3 == CommonBotFeatureType.H5.ordinal()) {
            String str = commandInfo.url;
            Intrinsics.checkNotNullExpressionValue(str, "commandInfo.url");
            b.c(context, str);
        } else if (i3 == CommonBotFeatureType.MINIAPP.ordinal()) {
            String str2 = commandInfo.url;
            Intrinsics.checkNotNullExpressionValue(str2, "commandInfo.url");
            b.a(context, str2, 0);
        }
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void a(@NotNull b74.a itemData, @Nullable String keyword) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        if (itemData instanceof x54.b) {
            x54.b bVar = (x54.b) itemData;
            p(keyword, bVar.getRobotInfo(), bVar.getCommandInfo());
        } else if (itemData instanceof d64.b) {
            d64.b bVar2 = (d64.b) itemData;
            q(bVar2.getRobotInfo(), bVar2.getServiceInfo());
        }
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void b(@NotNull String robotUin, @NotNull String robotTinyId) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(robotTinyId, "robotTinyId");
        Context context = this.mAIOContext.c().getContext();
        if (context == null) {
            return;
        }
        ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(context, robotUin, "", 3, 0, null, 48, null));
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void c() {
        this.mAIOContext.e().h(SlashDialogMsgIntent.OnSlashDismissAnimStart.f368545e);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void d(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mAIOContext.e().h(new SlashDialogMsgIntent.OnSlashDialogChanged(true));
        String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(this.mAIOContext.g().r().c().j());
        if (uinFromUid == null) {
            uinFromUid = "";
        }
        HashMap<String, Object> n3 = n(uinFromUid);
        VideoReport.setPageId(rootView, "pg_sgrp_robot_slash_halfscreen");
        VideoReport.setPageParams(rootView, new PageParams(n3));
        VideoReport.reportEvent("dt_pgin", rootView, n3);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void e(@NotNull FunctionReportArgs itemArgs) {
        Intrinsics.checkNotNullParameter(itemArgs, "itemArgs");
        if (itemArgs.getFunctionType() == 1) {
            b54.c.f27957a.a(itemArgs);
        } else if (itemArgs.getFunctionType() == 2) {
            b54.c.f27957a.c(itemArgs);
        }
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void f(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mAIOContext.e().h(new SlashDialogMsgIntent.OnSlashDialogChanged(false));
        String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(this.mAIOContext.g().r().c().j());
        if (uinFromUid == null) {
            uinFromUid = "";
        }
        HashMap<String, Object> n3 = n(uinFromUid);
        VideoReport.setPageId(rootView, "pg_sgrp_robot_slash_halfscreen");
        VideoReport.setPageParams(rootView, new PageParams(n3));
        VideoReport.reportEvent("dt_pgout", rootView, n3);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void g(@NotNull FunctionReportArgs itemArgs) {
        Intrinsics.checkNotNullParameter(itemArgs, "itemArgs");
        if (itemArgs.getFunctionType() == 1) {
            b54.c.f27957a.b(itemArgs);
        } else if (itemArgs.getFunctionType() == 2) {
            b54.c.f27957a.d(itemArgs);
        }
    }

    @Override // com.tencent.robot.slash.businessapi.b
    @NotNull
    public u54.c h() {
        AIOContact c16 = this.mAIOContext.g().r().c();
        return new u54.c(c16.j(), c16.e());
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public boolean hideKeyboard() {
        return c.a.b(this);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void i(@NotNull CommonBotInfo commonBotInfo, @NotNull CommonBotFeatureInfo commonBotFeatureInfo, int i3) {
        c.a.g(this, commonBotInfo, commonBotFeatureInfo, i3);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    @Nullable
    public com.tencent.robot.slash.businessapi.a j(@Nullable Object searchResponse, @NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        if (!(searchResponse instanceof List)) {
            return null;
        }
        ArrayList<b74.a> f16 = ConvertSearchTools.f368422a.f((List) searchResponse, keyword);
        CollectionsKt__MutableCollectionsKt.removeFirstOrNull(f16);
        return new com.tencent.robot.slash.businessapi.a(f16, null, 3);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    @Nullable
    public SearchSessionParams k(@Nullable Object args) {
        Long longOrNull;
        ArrayList arrayListOf;
        String j3 = this.mAIOContext.g().r().c().j();
        int e16 = this.mAIOContext.g().r().c().e();
        String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(j3);
        Intrinsics.checkNotNullExpressionValue(uinFromUid, "api(IRelationNTUinAndUid\u2026a).getUinFromUid(peerUid)");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uinFromUid);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            Contact contact = new Contact(e16, j3, "");
            String str = j3 + "_" + e16;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(longValue));
            return new SearchSessionParams(contact, arrayListOf, new ArrayList(), CommonBotScene.C2C, CommonBotFilter.KNONE, str);
        }
        return null;
    }

    @Override // com.tencent.robot.slash.businessapi.b
    @NotNull
    /* renamed from: l, reason: from getter */
    public View getMAnchorView() {
        return this.mAnchorView;
    }

    @Override // com.tencent.robot.slash.businessapi.c
    @NotNull
    public n<u54.c> m(@NotNull com.tencent.mvi.api.runtime.b mviContext) {
        Intrinsics.checkNotNullParameter(mviContext, "mviContext");
        return new k54.a(this.mAIOContext, this);
    }
}
