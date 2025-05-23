package com.tencent.mobileqq.troop.troopsetting.share.troopsetting;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.sharepanel.j;
import com.tencent.mobileqq.sharepanel.m;
import com.tencent.mobileqq.sharepanel.n;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopmanager.api.impl.TroopManagerBizHandler;
import com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qidian.api.IQidianManagerApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.util.LoadingUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 <2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b:\u0010;J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\u000b\u001a\u00020\b*\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0014\u0010\f\u001a\u00020\b*\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u0015\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J8\u0010#\u001a\u00020\u00112&\u0010!\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001fj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001` 2\u0006\u0010\"\u001a\u00020\u0002H\u0002J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020\u0002H\u0002J\u0014\u0010(\u001a\u00020\b*\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010)\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0002H\u0002J \u0010*\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0013H\u0002J \u0010+\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0013H\u0002J\u000e\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0004J\u0016\u0010/\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0002R0\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004` 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/troopsetting/TroopSettingShareManager;", "", "", "type", "Lcom/tencent/mobileqq/troop/troopsetting/share/a;", DomainData.DOMAIN_NAME, "", "l", "Lcom/tencent/mobileqq/sharepanel/f;", "Lcom/tencent/mobileqq/troop/troopsetting/share/b;", "shareContext", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "D", "Lcom/tencent/mobileqq/sharepanel/m;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Function0;", "replayAction", HippyTKDListViewAdapter.X, "E", UIJsPlugin.EVENT_SHOW_TOAST, "k", "u", "t", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "troopInfo", "w", "B", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "data", "troopUin", "v", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "id", "", "G", "o", "p", "r", "H", "shareAction", "j", WadlProxyConsts.SCENE_ID, UserInfo.SEX_FEMALE, "a", "Ljava/util/HashMap;", "shareActions", "b", "Lcom/tencent/mobileqq/sharepanel/f;", "sharePanel", "Landroid/app/Dialog;", "c", "Landroid/app/Dialog;", "dialog", "<init>", "()V", "d", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSettingShareManager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, com.tencent.mobileqq.troop.troopsetting.share.a> shareActions;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.sharepanel.f sharePanel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog dialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/troopsetting/TroopSettingShareManager$a;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "iconType", "", "text", "", "b", "Lcom/tencent/mobileqq/troop/troopsetting/share/troopsetting/TroopSettingShareManager;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final TroopSettingShareManager a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TroopSettingShareManager) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            TroopSettingShareManager troopSettingShareManager = new TroopSettingShareManager();
            troopSettingShareManager.j(new e());
            troopSettingShareManager.j(new com.tencent.mobileqq.troop.troopsetting.share.troopsetting.c());
            troopSettingShareManager.j(new WeChatShareAction());
            troopSettingShareManager.j(new com.tencent.mobileqq.troop.troopsetting.share.troopsetting.d());
            troopSettingShareManager.j(new a());
            troopSettingShareManager.j(new com.tencent.mobileqq.troop.troopsetting.share.troopsetting.b());
            return troopSettingShareManager;
        }

        public final void b(@Nullable QBaseActivity activity, int iconType, @NotNull String text) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, activity, Integer.valueOf(iconType), text);
                return;
            }
            Intrinsics.checkNotNullParameter(text, "text");
            if (activity == null) {
                return;
            }
            QQToast.makeText(activity, iconType, text, 0).show(activity.getTitleBarHeight());
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/share/troopsetting/TroopSettingShareManager$b", "Lcom/tencent/mobileqq/sharepanel/j;", "", "channelId", "", "a", "actionId", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements j {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.troopsetting.share.b f301484b;

        b(com.tencent.mobileqq.troop.troopsetting.share.b bVar) {
            this.f301484b = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingShareManager.this, (Object) bVar);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void a(@NotNull String channelId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) channelId);
            } else {
                Intrinsics.checkNotNullParameter(channelId, "channelId");
                TroopSettingShareManager.this.p(this.f301484b, channelId);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void b(@NotNull String actionId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) actionId);
            } else {
                Intrinsics.checkNotNullParameter(actionId, "actionId");
                TroopSettingShareManager.this.p(this.f301484b, actionId);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/share/troopsetting/TroopSettingShareManager$c", "Lcom/tencent/mobileqq/sharepanel/a;", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "targetList", "", "l", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends com.tencent.mobileqq.sharepanel.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.troopsetting.share.b f301486b;

        c(com.tencent.mobileqq.troop.troopsetting.share.b bVar) {
            this.f301486b = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingShareManager.this, (Object) bVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(TroopSettingShareManager this$0, com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
            this$0.p(shareContext, "qqfriend");
            this$0.l();
        }

        @Override // com.tencent.mobileqq.sharepanel.a, com.tencent.mobileqq.sharepanel.d
        public boolean l(@NotNull List<? extends ResultRecord> targetList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) targetList)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            final TroopSettingShareManager troopSettingShareManager = TroopSettingShareManager.this;
            final com.tencent.mobileqq.troop.troopsetting.share.b bVar = this.f301486b;
            ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.share.troopsetting.h
                @Override // java.lang.Runnable
                public final void run() {
                    TroopSettingShareManager.c.b(TroopSettingShareManager.this, bVar);
                }
            });
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/share/troopsetting/TroopSettingShareManager$d", "Lcom/tencent/mobileqq/troop/troopmanager/api/b;", "", "isSuccess", "Lcom/tencent/mobileqq/troop/troopshare/a;", "data", "", "onTroopShareLink", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d extends com.tencent.mobileqq.troop.troopmanager.api.b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.troopsetting.share.b f301487d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TroopSettingShareManager f301488e;

        d(com.tencent.mobileqq.troop.troopsetting.share.b bVar, TroopSettingShareManager troopSettingShareManager) {
            this.f301487d = bVar;
            this.f301488e = troopSettingShareManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) troopSettingShareManager);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopmanager.api.b
        public void onTroopShareLink(boolean isSuccess, @Nullable com.tencent.mobileqq.troop.troopshare.a data) {
            AppInterface appInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), data);
                return;
            }
            AppRuntime appRuntime = this.f301487d.b().getAppRuntime();
            if (appRuntime instanceof AppInterface) {
                appInterface = (AppInterface) appRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface == null) {
                return;
            }
            appInterface.removeObserver(this);
            if (data != null && TextUtils.equals(this.f301487d.h().troopUin, data.f301553a)) {
                if (isSuccess) {
                    this.f301487d.k(data);
                } else {
                    Companion companion = TroopSettingShareManager.INSTANCE;
                    QBaseActivity b16 = this.f301487d.b();
                    String qqStr = HardCodeUtil.qqStr(R.string.bj6);
                    Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.get_trooplink_fail)");
                    companion.b(b16, 1, qqStr);
                    this.f301488e.l();
                }
                this.f301487d.d().setValue(Boolean.valueOf(isSuccess));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61082);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSettingShareManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.shareActions = new LinkedHashMap();
        }
    }

    private final void A(com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        AppInterface appInterface;
        shareContext.b().addObserver(new d(shareContext, this));
        AppRuntime appRuntime = shareContext.b().getAppRuntime();
        com.tencent.mobileqq.troop.troopmanager.api.a aVar = null;
        if (appRuntime instanceof AppInterface) {
            appInterface = (AppInterface) appRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        Object businessHandler = appInterface.getBusinessHandler(TroopManagerBizHandler.class.getName());
        if (businessHandler instanceof com.tencent.mobileqq.troop.troopmanager.api.a) {
            aVar = (com.tencent.mobileqq.troop.troopmanager.api.a) businessHandler;
        }
        if (aVar != null) {
            aVar.e(shareContext.h().troopUin, true, false, G(shareContext.a()));
        }
    }

    private final void B(final com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        AppInterface appInterface;
        final TroopInfoData h16 = shareContext.h();
        AppRuntime appRuntime = shareContext.b().getAppRuntime();
        if (appRuntime instanceof AppInterface) {
            appInterface = (AppInterface) appRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        IRuntimeService runtimeService = appInterface.getRuntimeService(IQidianManagerApi.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026va, ProcessConstant.MAIN)");
        ((IQidianManagerApi) runtimeService).requestQidianTroopShareInfo(appInterface, h16.troopUin, h16.troopowneruin, new IQidianManagerApi.a() { // from class: com.tencent.mobileqq.troop.troopsetting.share.troopsetting.g
            @Override // com.tencent.qidian.api.IQidianManagerApi.a
            public final void a(boolean z16, HashMap hashMap) {
                TroopSettingShareManager.C(TroopSettingShareManager.this, h16, shareContext, z16, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(TroopSettingShareManager this$0, TroopInfoData troopInfo, com.tencent.mobileqq.troop.troopsetting.share.b shareContext, boolean z16, HashMap hashMap) {
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopInfo, "$troopInfo");
        Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
        if (z16) {
            String str = troopInfo.troopUin;
            Intrinsics.checkNotNullExpressionValue(str, "troopInfo.troopUin");
            if (!this$0.v(hashMap, str)) {
                String str2 = null;
                if (hashMap != null) {
                    obj = hashMap.get("url");
                } else {
                    obj = null;
                }
                if (obj instanceof String) {
                    str2 = (String) obj;
                }
                if (str2 == null) {
                    return;
                }
                com.tencent.mobileqq.troop.troopshare.a aVar = new com.tencent.mobileqq.troop.troopshare.a();
                aVar.f301556d = str2;
                aVar.f301557e = "";
                shareContext.k(aVar);
                shareContext.d().setValue(Boolean.TRUE);
                return;
            }
        }
        shareContext.d().setValue(Boolean.valueOf(z16));
        Companion companion = INSTANCE;
        QBaseActivity b16 = shareContext.b();
        String qqStr = HardCodeUtil.qqStr(R.string.bj6);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.get_trooplink_fail)");
        companion.b(b16, 1, qqStr);
        this$0.l();
    }

    private final com.tencent.mobileqq.sharepanel.f D(com.tencent.mobileqq.sharepanel.f fVar, final com.tencent.mobileqq.troop.troopsetting.share.b bVar) {
        fVar.k0(new n(this) { // from class: com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager$setIntentProvider$1
            static IPatchRedirector $redirector_;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ TroopSettingShareManager f301490b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f301490b = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.troop.troopsetting.share.b.this, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.sharepanel.n
            public void a(@NotNull ArrayList<ResultRecord> targetList, @NotNull final m callback) {
                boolean r16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) targetList, (Object) callback);
                    return;
                }
                Intrinsics.checkNotNullParameter(targetList, "targetList");
                Intrinsics.checkNotNullParameter(callback, "callback");
                com.tencent.mobileqq.troop.troopsetting.share.b.this.i("SpecificFriendShareAction");
                final TroopSettingShareManager troopSettingShareManager = this.f301490b;
                final com.tencent.mobileqq.troop.troopsetting.share.b bVar2 = com.tencent.mobileqq.troop.troopsetting.share.b.this;
                r16 = troopSettingShareManager.r(bVar2, new Function0<Unit>(bVar2, callback) { // from class: com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager$setIntentProvider$1$prepareForwardData$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ m $callback;
                    final /* synthetic */ com.tencent.mobileqq.troop.troopsetting.share.b $shareContext;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$shareContext = bVar2;
                        this.$callback = callback;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, TroopSettingShareManager.this, bVar2, callback);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            TroopSettingShareManager.this.m(this.$shareContext, this.$callback);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
                if (!r16) {
                    this.f301490b.m(com.tencent.mobileqq.troop.troopsetting.share.b.this, callback);
                }
            }
        });
        return fVar;
    }

    private final void E(com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(shareContext.b(), HardCodeUtil.qqStr(R.string.cpr), false);
        this.dialog = showLoadingDialog;
        if (showLoadingDialog != null) {
            showLoadingDialog.show();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0060 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int G(String id5) {
        switch (id5.hashCode()) {
            case -791575966:
                if (id5.equals("weixin")) {
                    return 9;
                }
                return 0;
            case -393543490:
                if (id5.equals("qqfriend")) {
                    return 2;
                }
                break;
            case -304161157:
                if (id5.equals("qzoneshuoshuo")) {
                    return 3;
                }
                break;
            case 154627506:
                if (id5.equals("weixincircle")) {
                    return 10;
                }
                break;
            case 309034113:
                if (id5.equals("generate_qr_code")) {
                    return 23;
                }
                break;
            case 1505434244:
                if (id5.equals(WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK)) {
                    return 1;
                }
                break;
            case 2052490821:
                if (id5.equals("SpecificFriendShareAction")) {
                    return 72;
                }
                break;
        }
    }

    private final void H(com.tencent.mobileqq.troop.troopsetting.share.b shareContext, Function0<Unit> replayAction) {
        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            E(shareContext);
            x(shareContext, replayAction);
            return;
        }
        Companion companion = INSTANCE;
        QBaseActivity b16 = shareContext.b();
        String qqStr = HardCodeUtil.qqStr(R.string.cib);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.network_error)");
        companion.b(b16, 1, qqStr);
    }

    private final boolean k(com.tencent.mobileqq.troop.troopsetting.share.b shareContext, boolean showToast) {
        if (t(shareContext, showToast) || u(shareContext, showToast)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        com.tencent.mobileqq.sharepanel.f fVar = this.sharePanel;
        if (fVar != null) {
            fVar.dismiss();
        }
        this.sharePanel = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(com.tencent.mobileqq.troop.troopsetting.share.b shareContext, final m callback) {
        shareContext.j(new Function1<Intent, Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager$doPrepareIntent$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                invoke2(intent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Intent intent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
                } else if (intent != null) {
                    m.this.a(intent);
                } else {
                    m.this.onFail();
                }
            }
        });
        com.tencent.mobileqq.troop.troopsetting.share.a n3 = n("SpecificFriendShareAction");
        if (n3 != null) {
            n3.a(shareContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.troop.troopsetting.share.a n(String type) {
        return this.shareActions.get(type);
    }

    private final com.tencent.mobileqq.sharepanel.f o(com.tencent.mobileqq.sharepanel.f fVar, com.tencent.mobileqq.troop.troopsetting.share.b bVar) {
        fVar.t0(new b(bVar));
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(final com.tencent.mobileqq.troop.troopsetting.share.b shareContext, final String id5) {
        shareContext.i(id5);
        Function0<Unit> function0 = new Function0<Unit>(id5, shareContext) { // from class: com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager$handleItemClick$block$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $id;
            final /* synthetic */ com.tencent.mobileqq.troop.troopsetting.share.b $shareContext;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$id = id5;
                this.$shareContext = shareContext;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TroopSettingShareManager.this, id5, shareContext);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                com.tencent.mobileqq.troop.troopsetting.share.a n3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                n3 = TroopSettingShareManager.this.n(this.$id);
                if (n3 == null) {
                    return null;
                }
                n3.a(this.$shareContext);
                return Unit.INSTANCE;
            }
        };
        if (Intrinsics.areEqual(shareContext.a(), "generate_qr_code")) {
            function0.invoke();
        } else {
            if (r(shareContext, function0)) {
                return;
            }
            function0.invoke();
        }
    }

    private final com.tencent.mobileqq.sharepanel.f q(com.tencent.mobileqq.sharepanel.f fVar, com.tencent.mobileqq.troop.troopsetting.share.b bVar) {
        fVar.p0(new c(bVar));
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean r(com.tencent.mobileqq.troop.troopsetting.share.b shareContext, Function0<Unit> replayAction) {
        if (k(shareContext, true)) {
            if (Intrinsics.areEqual(shareContext.a(), "SpecificFriendShareAction")) {
                l();
            }
            return true;
        }
        if (!s(shareContext)) {
            z(shareContext);
            H(shareContext, replayAction);
            return true;
        }
        return false;
    }

    private final boolean s(com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        Boolean value = shareContext.d().getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        return value.booleanValue();
    }

    private final boolean t(com.tencent.mobileqq.troop.troopsetting.share.b shareContext, boolean showToast) {
        boolean z16;
        TroopInfoData h16 = shareContext.h();
        QBaseActivity b16 = shareContext.b();
        if (!w(h16) && h16.cGroupOption == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && showToast) {
            Companion companion = INSTANCE;
            String string = b16.getString(R.string.i7i);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.troop_join_forbbiden)");
            companion.b(b16, 0, string);
        }
        return z16;
    }

    private final boolean u(com.tencent.mobileqq.troop.troopsetting.share.b shareContext, boolean showToast) {
        boolean z16;
        TroopInfoData h16 = shareContext.h();
        QBaseActivity b16 = shareContext.b();
        if (!h16.isOwnerOrAdim() && h16.isMember && (h16.dwGroupFlagExt & 128) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && showToast) {
            Companion companion = INSTANCE;
            String string = b16.getString(R.string.f181203d5);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026re_not_allow_invite_tips)");
            companion.b(b16, 0, string);
        }
        return z16;
    }

    private final boolean v(HashMap<String, Object> data, String troopUin) {
        Object obj;
        String str = null;
        if (data != null) {
            obj = data.get("uin");
        } else {
            obj = null;
        }
        if (obj instanceof String) {
            str = (String) obj;
        }
        if (str == null) {
            return true;
        }
        return true ^ Intrinsics.areEqual(str, troopUin);
    }

    private final boolean w(TroopInfoData troopInfo) {
        long j3 = troopInfo.mTroopPrivilegeFlag;
        if (TroopInfo.hasPayPrivilege(j3, 128) && TroopInfo.hasPayPrivilege(j3, 512)) {
            return true;
        }
        return false;
    }

    private final void x(com.tencent.mobileqq.troop.troopsetting.share.b shareContext, final Function0<Unit> replayAction) {
        MutableLiveData<Boolean> d16 = shareContext.d();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>(replayAction, this) { // from class: com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager$observeReqFinish$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function0<Unit> $replayAction;
            final /* synthetic */ TroopSettingShareManager this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$replayAction = replayAction;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) replayAction, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                Dialog dialog;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    QLog.d("TroopSettingShareManager", 1, "wait req finish ");
                    this.$replayAction.invoke();
                }
                dialog = this.this$0.dialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                this.this$0.dialog = null;
            }
        };
        d16.observeForever(new Observer() { // from class: com.tencent.mobileqq.troop.troopsetting.share.troopsetting.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopSettingShareManager.y(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void z(com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        if (k(shareContext, false) || Intrinsics.areEqual(shareContext.d().getValue(), Boolean.TRUE)) {
            return;
        }
        if (shareContext.h().isQidianPrivateTroop) {
            B(shareContext);
        } else {
            A(shareContext);
        }
    }

    public final void F(@NotNull com.tencent.mobileqq.troop.troopsetting.share.b shareContext, @NotNull String sceneId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) shareContext, (Object) sceneId);
            return;
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        com.tencent.mobileqq.sharepanel.f c06 = q(o(D(((ISharePanelApi) QRoute.api(ISharePanelApi.class)).createSharePanel(shareContext.b(), sceneId), shareContext), shareContext), shareContext).c0("generate_qr_code", shareContext.h().isMember);
        this.sharePanel = c06;
        if (c06 != null) {
            c06.show();
        }
    }

    public final void j(@NotNull com.tencent.mobileqq.troop.troopsetting.share.a shareAction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) shareAction);
            return;
        }
        Intrinsics.checkNotNullParameter(shareAction, "shareAction");
        Iterator<T> it = shareAction.d().iterator();
        while (it.hasNext()) {
            this.shareActions.put((String) it.next(), shareAction);
        }
    }
}
