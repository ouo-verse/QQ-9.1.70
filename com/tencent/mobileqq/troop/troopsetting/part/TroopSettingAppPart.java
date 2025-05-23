package com.tencent.mobileqq.troop.troopsetting.part;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.guild.jump.model.GuildShareUrlParam;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.appscenter.api.ITroopAppsApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.troopapps.event.TroopAppsListUpdateEvent;
import com.tencent.mobileqq.troop.troopsetting.part.TroopSettingAppPart$updateAppsListEventReceiver$2;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.AppCommonAction;
import com.tencent.qqnt.kernel.nativeinterface.AppCommonJump;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xe83.oidb_0xe83$AppInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83$RspBody;

@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001E\b\u0016\u0018\u0000 O2\u00020\u0001:\u0001PB\u0007\u00a2\u0006\u0004\bM\u0010NJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J.\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH\u0003J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\nH\u0002J2\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0002J\u001a\u0010\"\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0019\u001a\u00020!H\u0002J\u001a\u0010&\u001a\u00020%2\u0006\u0010\u0019\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#H\u0002J\u0018\u0010)\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u000eH\u0002J\u001c\u0010.\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010/\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0015\u00102\u001a\b\u0012\u0004\u0012\u00020100H\u0016\u00a2\u0006\u0004\b2\u00103J\u0012\u00105\u001a\u00020\u00022\b\u00104\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u00106\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0006\u00107\u001a\u00020\u0002R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\b088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001b\u0010A\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001b\u0010H\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010>\u001a\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingAppPart;", "Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "", "U9", "T9", "Ltencent/im/oidb/cmd0xe83/oidb_0xe83$RspBody;", "respBody", "aa", "Landroid/view/View;", "appContainer", "", "layoutPos", "appIndex", "", "Ltencent/im/oidb/cmd0xe83/oidb_0xe83$AppInfo;", "appList", "M9", "itemView", "W9", "size", "Y9", "R9", "i", "P9", "", "appId", "appName", "appIconUrl", "actionUrl", "Lcom/tencent/qqnt/kernel/nativeinterface/AppDetail;", "ba", "Landroid/content/Intent;", "intent", "", "Z9", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "N9", "childItem", "appInfo", "V9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "G9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartResume", "S9", "Lcom/tencent/mobileqq/troop/troopsetting/customconfig/b;", "e", "Lcom/tencent/mobileqq/troop/troopsetting/customconfig/b;", "troopAppContainerConfig", "Lcom/tencent/mobileqq/troop/troopsetting/part/TroopRobotConfigPart;", "f", "Lkotlin/Lazy;", "O9", "()Lcom/tencent/mobileqq/troop/troopsetting/part/TroopRobotConfigPart;", "mTroopRobotConfigPart", tl.h.F, "Landroid/view/View;", "troopAppContainerView", "com/tencent/mobileqq/troop/troopsetting/part/TroopSettingAppPart$updateAppsListEventReceiver$2$a", "Q9", "()Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingAppPart$updateAppsListEventReceiver$2$a;", "updateAppsListEventReceiver", "Landroid/view/View$OnClickListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View$OnClickListener;", "mAppOnClickListener", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class TroopSettingAppPart extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> troopAppContainerConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTroopRobotConfigPart;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View troopAppContainerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy updateAppsListEventReceiver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View.OnClickListener mAppOnClickListener;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingAppPart$a;", "", "", "CONFIG_ID", "Ljava/lang/String;", "", IGuildMessageUtilsApi.GUILD_ID_EXT_STR, "J", "", "MAX_APP_COUNT", "I", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingAppPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/part/TroopSettingAppPart$b", "Landroid/view/View$OnClickListener;", "", "appId", "", "a", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingAppPart.this);
            }
        }

        private final int a(String appId) {
            List<oidb_0xe83$AppInfo> R2 = TroopSettingAppPart.this.B9().R2();
            if (R2 != null && (!R2.isEmpty())) {
                int size = R2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (Intrinsics.areEqual(appId, R2.get(i3).appid.toString())) {
                        return i3;
                    }
                }
            }
            return 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:71:0x0255, code lost:
        
            if (r2 != false) goto L64;
         */
        /* JADX WARN: Removed duplicated region for block: B:53:0x035f  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(@NotNull View v3) {
            long j3;
            String url;
            boolean z16;
            char c16;
            boolean startsWith$default;
            boolean startsWith$default2;
            boolean startsWith$default3;
            boolean startsWith$default4;
            String str;
            String str2;
            EventCollector.getInstance().onViewClickedBefore(v3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
            } else {
                Intrinsics.checkNotNullParameter(v3, "v");
                TroopInfoData T2 = TroopSettingAppPart.this.B9().T2();
                TroopInfo S2 = TroopSettingAppPart.this.B9().S2();
                View rootView = TroopSettingAppPart.this.getPartHost().getRootView();
                Object tag = v3.getTag();
                if (tag instanceof oidb_0xe83$AppInfo) {
                    oidb_0xe83$AppInfo oidb_0xe83_appinfo = (oidb_0xe83$AppInfo) tag;
                    String str3 = oidb_0xe83_appinfo.url.get();
                    long j16 = oidb_0xe83_appinfo.appid.get();
                    if (((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).isGroupAlbumEntry(oidb_0xe83_appinfo.name.get()) && ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).isNewAIOGroupAlbumEnable()) {
                        str3 = "mqzone://arouse/groupalbum/homealbum?groupid=" + T2.troopUin + "&from=1";
                    }
                    String str4 = str3;
                    IRuntimeService runtimeService = TroopSettingAppPart.this.z9().getRuntimeService(ITroopInfoService.class, "");
                    Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
                    TroopInfo troopInfo = ((ITroopInfoService) runtimeService).getTroopInfo(T2.troopUin);
                    if (troopInfo != null) {
                        j3 = troopInfo.dwGroupClassExt;
                    } else {
                        j3 = 0;
                    }
                    int a16 = a(oidb_0xe83_appinfo.appid.toString());
                    com.tencent.mobileqq.troop.troopsetting.report.c cVar = com.tencent.mobileqq.troop.troopsetting.report.c.f301449a;
                    Activity activity = TroopSettingAppPart.this.getActivity();
                    String str5 = oidb_0xe83_appinfo.name.get();
                    Intrinsics.checkNotNullExpressionValue(str5, "obj.name.get()");
                    cVar.s(activity, rootView, v3, true, str5, a16, j16, T2);
                    cVar.k(v3, T2, String.valueOf(j3), String.valueOf(j16));
                    if (!TextUtils.isEmpty(str4) && !TroopSettingAppPart.this.N9(j16, troopInfo)) {
                        if (j16 == 102438828) {
                            url = str4;
                            AppDetail ba5 = TroopSettingAppPart.this.ba(String.valueOf(j16), oidb_0xe83_appinfo.name.get(), oidb_0xe83_appinfo.icon.get(), url);
                            if (ba5 != null) {
                                TroopSettingAppPart troopSettingAppPart = TroopSettingAppPart.this;
                                ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).createAndShowCapsuleDialog(troopSettingAppPart.getActivity(), troopSettingAppPart.B9().T2().troopUin, ba5, Boolean.FALSE);
                            }
                        } else {
                            url = str4;
                        }
                        if (j16 == 102148883 || j16 == 102060897) {
                            if (troopInfo != null && !troopInfo.isHomeworkTroop()) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                QQToastUtil.showQQToastInUiThread(1, "\u8bf7\u4fee\u6539\u7fa4\u5206\u7c7b\u4e3a\u8001\u5e08\u5bb6\u957f\u540e\u4f7f\u7528");
                            }
                        }
                        if (j16 == 1101236949) {
                            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).handleAppClick1101236949(T2, TroopSettingAppPart.this.getActivity());
                        }
                        if (j16 == 101914115) {
                            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).reportClockTroopAppShowOrClick(S2, false);
                        }
                        if (j16 == 10000) {
                            ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoGuild(TroopSettingAppPart.this.getContext(), new GuildShareUrlParam(url));
                        }
                        int i3 = oidb_0xe83_appinfo.push_red_point.get();
                        if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(url)) {
                            c16 = 1;
                            try {
                                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(TroopSettingAppPart.this.getActivity(), ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).replaceSpecialTag(url, j16, i3, T2, TroopSettingAppPart.this.z9(), true), 2010, ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).createEntryModel(S2, T2.troopUin), null);
                            } catch (Exception e16) {
                                QLog.e("TroopSettingAppPart", 1, "[mAppOnClickListener] exception = " + e16);
                            }
                            ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).reportQunMiniApp(oidb_0xe83_appinfo, "click", T2.troopUin);
                        } else {
                            c16 = 1;
                            if (j16 != 10000) {
                                Intrinsics.checkNotNullExpressionValue(url, "url");
                                startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
                                if (!startsWith$default3) {
                                    Intrinsics.checkNotNullExpressionValue(url, "url");
                                    startsWith$default4 = StringsKt__StringsJVMKt.startsWith$default(url, "https", false, 2, null);
                                }
                                Intent intent = new Intent();
                                intent.putExtra("url", ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).replaceSpecialTag(url, j16, i3, T2, TroopSettingAppPart.this.z9(), true));
                                intent.putExtra("webStyle", "noBottomBar");
                                intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                                TroopSettingAppPart.this.Z9(intent, j16);
                                QRoute.createNavigator(TroopSettingAppPart.this.getActivity(), RouterConstants.UI_ROUTE_BROWSER).withAll(intent.getExtras()).withFlags(intent.getFlags()).request();
                            }
                            Intrinsics.checkNotNullExpressionValue(url, "url");
                            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, SchemaUtils.SCHEMA_MQQAPI, false, 2, null);
                            if (startsWith$default) {
                                String replaceSpecialTag = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).replaceSpecialTag(url, j16, i3, T2, TroopSettingAppPart.this.z9(), true);
                                Intent jumpActionIntent = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getJumpActionIntent(TroopSettingAppPart.this.getActivity());
                                jumpActionIntent.setData(Uri.parse(replaceSpecialTag));
                                TroopSettingAppPart.this.getActivity().startActivity(jumpActionIntent);
                            } else {
                                Intrinsics.checkNotNullExpressionValue(url, "url");
                                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "mqzone", false, 2, null);
                                if (startsWith$default2) {
                                    ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchQZoneScheme(TroopSettingAppPart.this.getActivity(), url);
                                }
                            }
                        }
                        String[] strArr = new String[3];
                        strArr[0] = T2.troopUin;
                        strArr[c16] = eu.c(T2);
                        strArr[2] = String.valueOf(j16);
                        eu.g("Grp_app_new", "grpData_admin", "app_clk", 0, 0, strArr);
                        if (j16 == 0) {
                            str2 = "app_clk";
                        } else if (j16 == 1) {
                            str2 = "clk_file";
                        } else if (j16 == 2) {
                            str2 = "clk_album";
                        } else if (j16 != 1101236949) {
                            str = "";
                            if (!TextUtils.isEmpty(str)) {
                                String[] strArr2 = new String[2];
                                strArr2[0] = T2.troopUin;
                                strArr2[c16] = eu.c(T2);
                                eu.g("Grp_app_new", "grpData_admin", str, 0, 0, strArr2);
                            }
                        } else {
                            str2 = "clk_notice";
                        }
                        str = str2;
                        if (!TextUtils.isEmpty(str)) {
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60547);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSettingAppPart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopRobotConfigPart>() { // from class: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingAppPart$mTroopRobotConfigPart$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSettingAppPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TroopRobotConfigPart invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new TroopRobotConfigPart(TroopSettingAppPart.this) : (TroopRobotConfigPart) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.mTroopRobotConfigPart = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TroopSettingAppPart$updateAppsListEventReceiver$2.a>() { // from class: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingAppPart$updateAppsListEventReceiver$2
                static IPatchRedirector $redirector_;

                @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/part/TroopSettingAppPart$updateAppsListEventReceiver$2$a", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/troop/troopapps/event/TroopAppsListUpdateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes19.dex */
                public static final class a implements SimpleEventReceiver<TroopAppsListUpdateEvent> {
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ TroopSettingAppPart f301248d;

                    a(TroopSettingAppPart troopSettingAppPart) {
                        this.f301248d = troopSettingAppPart;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSettingAppPart);
                        }
                    }

                    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
                    @NotNull
                    public ArrayList<Class<TroopAppsListUpdateEvent>> getEventClass() {
                        ArrayList<Class<TroopAppsListUpdateEvent>> arrayListOf;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TroopAppsListUpdateEvent.class);
                            return arrayListOf;
                        }
                        return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
                    }

                    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
                    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                        } else if (event instanceof TroopAppsListUpdateEvent) {
                            this.f301248d.B9().X3(this.f301248d.z9());
                        }
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSettingAppPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(TroopSettingAppPart.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.updateAppsListEventReceiver = lazy2;
            this.mAppOnClickListener = new b();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void M9(View appContainer, int layoutPos, int appIndex, List<oidb_0xe83$AppInfo> appList) {
        View rootView = getPartHost().getRootView();
        View P9 = P9(appContainer, layoutPos);
        if (P9 != null && appList.size() > appIndex) {
            P9.setVisibility(0);
            oidb_0xe83$AppInfo oidb_0xe83_appinfo = appList.get(appIndex);
            String e16 = com.tencent.mobileqq.troop.troopsetting.activity.a.e(oidb_0xe83_appinfo);
            if (TextUtils.isEmpty(e16)) {
                return;
            }
            TextView textView = (TextView) P9.findViewById(R.id.f164398w7);
            textView.setText(e16);
            textView.setTextColor(ResourcesCompat.getColorStateList(getContext().getResources(), R.color.qui_common_text_primary, null));
            long j3 = oidb_0xe83_appinfo.appid.get();
            V9(P9, oidb_0xe83_appinfo);
            com.tencent.mobileqq.troop.troopsetting.report.c cVar = com.tencent.mobileqq.troop.troopsetting.report.c.f301449a;
            String str = B9().T2().troopUin;
            Intrinsics.checkNotNullExpressionValue(str, "viewModel.troopInfoData.troopUin");
            cVar.f(oidb_0xe83_appinfo, j3, str, B9().S2());
            cVar.s(getActivity(), rootView, appContainer, false, e16, appIndex, j3, B9().T2());
            P9.setTag(oidb_0xe83_appinfo);
            P9.setTag(-1, Integer.valueOf(appIndex + 1));
            P9.setOnClickListener(this.mAppOnClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean N9(long appId, TroopInfo troopInfo) {
        return ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).appOnClick_Special(z9(), getActivity(), appId, troopInfo, B9().T2());
    }

    private final TroopRobotConfigPart O9() {
        return (TroopRobotConfigPart) this.mTroopRobotConfigPart.getValue();
    }

    private final View P9(View itemView, int i3) {
        switch (i3) {
            case 0:
                return itemView.findViewById(R.id.jwx);
            case 1:
                return itemView.findViewById(R.id.jwy);
            case 2:
                return itemView.findViewById(R.id.jwz);
            case 3:
                return itemView.findViewById(R.id.f167010jx0);
            case 4:
                return itemView.findViewById(R.id.f167011jx1);
            case 5:
                return itemView.findViewById(R.id.f167012jx2);
            case 6:
                return itemView.findViewById(R.id.f167013jx3);
            case 7:
                return itemView.findViewById(R.id.f167014jx4);
            case 8:
                return itemView.findViewById(R.id.mbl);
            case 9:
                return itemView.findViewById(R.id.mbm);
            default:
                return null;
        }
    }

    private final TroopSettingAppPart$updateAppsListEventReceiver$2.a Q9() {
        return (TroopSettingAppPart$updateAppsListEventReceiver$2.a) this.updateAppsListEventReceiver.getValue();
    }

    private final void R9(View appContainer, int layoutPos) {
        View P9 = P9(appContainer, layoutPos);
        if (P9 != null) {
            P9.setVisibility(4);
        }
    }

    private final void T9() {
        if (B9().S2().isNeedInterceptOnBlockTroop()) {
            return;
        }
        O9().g();
    }

    private final void U9() {
        View inflate = View.inflate(getActivity(), R.layout.a1a, null);
        com.tencent.mobileqq.widget.o.m(inflate, 0, true);
        inflate.getBackground().setAlpha(255);
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar = new com.tencent.mobileqq.troop.troopsetting.customconfig.b<>(inflate);
        bVar.p(false);
        this.troopAppContainerConfig = bVar;
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(activity, R.layo\u2026\u3002\n            }\n        }");
        this.troopAppContainerView = inflate;
    }

    private final void V9(View childItem, oidb_0xe83$AppInfo appInfo) {
        String str;
        boolean z16;
        View findViewById = childItem.findViewById(R.id.f164379vi);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById;
        if (appInfo.icon.has()) {
            str = appInfo.icon.get();
        } else {
            str = "";
        }
        String str2 = str;
        IChatSettingForTroopApi iChatSettingForTroopApi = (IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class);
        Context context = imageView.getContext();
        if (appInfo.show_frame.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        iChatSettingForTroopApi.setAppIcon(context, imageView, str2, 40.0f, z16);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void W9(View itemView) {
        final TroopInfo S2 = B9().S2();
        final TroopInfoData T2 = B9().T2();
        View findViewById = itemView.findViewById(R.id.mbp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.troop_info_app_manage)");
        TextView textView = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.f164472yw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.arrow)");
        textView.setText(getContext().getResources().getString(R.string.zvv));
        textView.setVisibility(0);
        ((ImageView) findViewById2).setVisibility(0);
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar = this.troopAppContainerConfig;
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopAppContainerConfig");
            bVar = null;
        }
        bVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingAppPart.X9(TroopInfo.this, this, T2, view);
            }
        });
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar3 = this.troopAppContainerConfig;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopAppContainerConfig");
        } else {
            bVar2 = bVar3;
        }
        D9(bVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(TroopInfo mTroopInfo, TroopSettingAppPart this$0, TroopInfoData mTroopInfoData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(mTroopInfo, "$mTroopInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mTroopInfoData, "$mTroopInfoData");
        if (mTroopInfo.troopuin == null) {
            QLog.e("TroopSettingAppPart", 1, "app layout click with invalid params.");
        } else {
            ITroopAppsApi iTroopAppsApi = (ITroopAppsApi) QRoute.api(ITroopAppsApi.class);
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String str = mTroopInfoData.troopUin;
            Intrinsics.checkNotNullExpressionValue(str, "mTroopInfoData.troopUin");
            iTroopAppsApi.openNewPage(context, str, 3);
            IRuntimeService runtimeService = this$0.z9().getRuntimeService(ITroopAppService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026ava, ProcessConstant.ALL)");
            ((ITroopAppService) runtimeService).setProfileAppListChangedFromWebOperate(true, mTroopInfoData.troopUin);
            ReportController.o(null, "dc00898", "", "", "0X800AFC5", "0X800AFC5", 0, 0, String.valueOf(mTroopInfo.dwGroupClassExt), "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Y9(View itemView, int size) {
        View findViewById = itemView.findViewById(R.id.jx6);
        if (size <= 5) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9(Intent intent, long appId) {
        String str;
        if (intent == null) {
            return;
        }
        if (appId == 101914115) {
            str = "biz_src_zf_games";
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("big_brother_source_key", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aa(oidb_0xe83$RspBody respBody) {
        boolean z16;
        boolean z17;
        int i3 = 0;
        if (QLog.isColorLevel()) {
            if (respBody == null) {
                z17 = true;
            } else {
                z17 = false;
            }
            QLog.d("TroopSettingAppPart", 2, "showGetAppListResult: respBody isNull=" + z17);
        }
        if (respBody == null) {
            return;
        }
        List<oidb_0xe83$AppInfo> appList = respBody.infos.get();
        B9().Q3(new ArrayList(appList));
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar = null;
        if (appList.size() == 0) {
            com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar2 = this.troopAppContainerConfig;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopAppContainerConfig");
            } else {
                bVar = bVar2;
            }
            E9(bVar, false);
            if (QLog.isColorLevel()) {
                QLog.w("TroopSettingAppPart", 2, "showGetAppListResult: appList == null || appList.size() == 0");
                return;
            }
            return;
        }
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar3 = this.troopAppContainerConfig;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopAppContainerConfig");
            bVar3 = null;
        }
        E9(bVar3, true);
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102812", true)) {
            Intrinsics.checkNotNullExpressionValue(appList, "appList");
            ArrayList arrayList = new ArrayList();
            for (Object obj : appList) {
                if (((oidb_0xe83$AppInfo) obj).appid.get() != 10000) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
        }
        View view = this.troopAppContainerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopAppContainerView");
            view = null;
        }
        W9(view);
        int size = appList.size();
        View view2 = this.troopAppContainerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopAppContainerView");
            view2 = null;
        }
        Y9(view2, 5);
        int min = Math.min(size - 1, 4);
        if (min >= 0) {
            while (true) {
                View view3 = this.troopAppContainerView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopAppContainerView");
                    view3 = null;
                }
                Intrinsics.checkNotNullExpressionValue(appList, "appList");
                M9(view3, i3, i3, appList);
                if (i3 == min) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        for (int i16 = min + 1; i16 < 5; i16++) {
            View view4 = this.troopAppContainerView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopAppContainerView");
                view4 = null;
            }
            R9(view4, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppDetail ba(String appId, String appName, String appIconUrl, String actionUrl) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (appId != null && appId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (appName != null && appName.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                if (appIconUrl != null && appIconUrl.length() != 0) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (!z18) {
                    if (actionUrl != null && actionUrl.length() != 0) {
                        z19 = false;
                    } else {
                        z19 = true;
                    }
                    if (!z19) {
                        AppDetail appDetail = new AppDetail();
                        appDetail.appId = appId;
                        appDetail.name = appName;
                        appDetail.icon = appIconUrl;
                        appDetail.type = 0;
                        appDetail.removable = true;
                        appDetail.desc = "\u8f93\u5165\u6587\u5b57\uff0c\u901a\u8fc7AI\u5408\u6210\u8bed\u97f3\u7684\u65b9\u5f0f\uff0c\u4e0e\u597d\u53cb\u7545\u804a\u3002";
                        appDetail.added = 0;
                        appDetail.addTs = 0L;
                        appDetail.adId = "";
                        AppCommonAction appCommonAction = new AppCommonAction();
                        appCommonAction.type = 1;
                        appCommonAction.needJumpAio = true;
                        AppCommonJump appCommonJump = new AppCommonJump();
                        appCommonJump.url = actionUrl;
                        appCommonAction.jump = appCommonJump;
                        appCommonAction.msgList = new ArrayList<>();
                        appCommonAction.menuList = new ArrayList<>();
                        appCommonAction.associatedId = "";
                        appDetail.action = appCommonAction;
                        return appDetail;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.part.h
    @NotNull
    public Group[] G9() {
        Group[] groupArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Group[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar = null;
        if (B9().S2().isNeedInterceptOnBlockTroop()) {
            groupArr = new Group[1];
            com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[1];
            com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar2 = this.troopAppContainerConfig;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopAppContainerConfig");
            } else {
                bVar = bVar2;
            }
            aVarArr[0] = bVar;
            groupArr[0] = new Group(aVarArr);
        } else {
            groupArr = new Group[2];
            com.tencent.mobileqq.widget.listitem.a[] aVarArr2 = new com.tencent.mobileqq.widget.listitem.a[1];
            com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar3 = this.troopAppContainerConfig;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopAppContainerConfig");
            } else {
                bVar = bVar3;
            }
            aVarArr2[0] = bVar;
            groupArr[0] = new Group(aVarArr2);
            groupArr[1] = new Group(O9().f());
        }
        return groupArr;
    }

    public final void S9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new TroopSettingAppPart$initObserver$1(this, null), 3, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        U9();
        T9();
        S9();
        B9().S3();
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.part.h, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
            SimpleEventBus.getInstance().registerReceiver(Q9());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            SimpleEventBus.getInstance().unRegisterReceiver(Q9());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        B9().K0(z9());
        B9().v2(z9());
    }
}
