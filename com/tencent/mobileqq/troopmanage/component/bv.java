package com.tencent.mobileqq.troopmanage.component;

import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import androidx.annotation.StringRes;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 \u00072\u00020\u0001:\u0001-B/\u0012\u0006\u00101\u001a\u00020,\u0012\u0006\u00106\u001a\u000202\u0012\u0006\u0010;\u001a\u000207\u0012\u0006\u0010A\u001a\u00020<\u0012\u0006\u0010D\u001a\u00020\u0013\u00a2\u0006\u0004\bE\u0010FJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006JP\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\b2\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010JN\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\b\b\u0001\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010JL\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010Jh\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00190\f2\b\b\u0001\u0010\t\u001a\u00020\b2J\b\u0002\u0010 \u001aD\u0012\u001d\u0012\u001b\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00190\f\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0018j\u0004\u0018\u0001`\u001fJ \u0010\"\u001a\u00020\u001e2\u0010\u0010\u001c\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\u001d\u001a\u00020\u0002J&\u0010&\u001a\u00020\u001e2\u0010\u0010#\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00190\f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0$J&\u0010*\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u00132\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010(J&\u0010+\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u00132\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010(R\u0017\u00101\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0017\u00106\u001a\u0002028\u0006\u00a2\u0006\f\n\u0004\b/\u00103\u001a\u0004\b4\u00105R\u0017\u0010;\u001a\u0002078\u0006\u00a2\u0006\f\n\u0004\b4\u00108\u001a\u0004\b9\u0010:R\u0017\u0010A\u001a\u00020<8\u0006\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010D\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b9\u0010B\u001a\u0004\b=\u0010C\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/bv;", "", "", "i", "Lcom/tencent/mobileqq/troopmanage/repo/b;", "g", "Landroid/content/Intent;", "f", "", "leftStringRes", "rightStringRes", "Lcom/tencent/mobileqq/troopmanage/component/ah;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "initializer", "Landroid/view/View$OnClickListener;", "clickListener", "r", "", "rightString", ReportConstant.COSTREPORT_PREFIX, "leftString", "t", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "Lkotlin/ParameterName;", "name", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "isCheck", "", "Lcom/tencent/mobileqq/troopmanage/component/OnCheckChange;", "listener", "p", "j", DownloadInfo.spKey_Config, "Lkotlin/Function0;", "task", "o", "elementId", "", "params", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Lcom/tencent/mobileqq/app/QBaseActivity;", "a", "Lcom/tencent/mobileqq/app/QBaseActivity;", "b", "()Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "c", "()Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "e", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "d", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", tl.h.F, "()Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "Ljava/lang/String;", "()Ljava/lang/String;", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class bv {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QBaseActivity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUIListItemAdapter adapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopManageViewModel viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String dtReportPgId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ,\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/bv$a;", "", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troopmanage.component.bv$a, reason: from kotlin metadata */
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
        public final HashMap<String, Object> a(@Nullable TroopManageViewModel viewModel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 3;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewModel);
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            if (viewModel != null) {
                TroopInfoData i16 = viewModel.X1().m().i();
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, Integer.valueOf(viewModel.X1().m().k()));
                hashMap.put("page_status", Integer.valueOf(viewModel.X1().m().m()));
                String str = i16.troopCode;
                String str2 = "";
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "troopInfoData.troopCode ?: \"\"");
                }
                hashMap.put("group_id", str);
                if (i16.bOwner) {
                    i3 = 1;
                } else if (i16.bAdmin) {
                    i3 = 2;
                }
                hashMap.put("group_uin_type", Integer.valueOf(i3));
                if (i16.isTroopGuild) {
                    String str3 = i16.troopGuildId;
                    if (str3 == null) {
                        str3 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str3, "troopInfoData.troopGuildId ?: \"\"");
                    }
                    hashMap.put("sgrp_channel_id", str3);
                    String str4 = i16.troopGuildChannelId;
                    if (str4 == null) {
                        str4 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str4, "troopInfoData.troopGuildChannelId ?: \"\"");
                    }
                    hashMap.put("sgrp_sub_channel_id", str4);
                }
                String str5 = i16.troopowneruin;
                if (str5 != null) {
                    Intrinsics.checkNotNullExpressionValue(str5, "troopInfoData.troopowneruin ?: \"\"");
                    str2 = str5;
                }
                hashMap.put("group_owner_uin", str2);
            }
            return hashMap;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62901);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public bv(@NotNull QBaseActivity activity, @NotNull QUIListItemAdapter adapter, @NotNull LifecycleOwner lifecycleOwner, @NotNull TroopManageViewModel viewModel, @NotNull String dtReportPgId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
            return;
        }
        this.activity = activity;
        this.adapter = adapter;
        this.lifecycleOwner = lifecycleOwner;
        this.viewModel = viewModel;
        this.dtReportPgId = dtReportPgId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void l(bv bvVar, String str, Map map, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                map = null;
            }
            bvVar.k(str, map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportTroopManageEntryClick");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void n(bv bvVar, String str, Map map, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                map = null;
            }
            bvVar.m(str, map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportTroopManageEntryImp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function2 function2, com.tencent.mobileqq.widget.listitem.x xVar, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(xVar, "$switch");
        if (function2 != null) {
            function2.invoke(xVar, Boolean.valueOf(z16));
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ com.tencent.mobileqq.widget.listitem.x u(bv bvVar, int i3, int i16, ah ahVar, View.OnClickListener onClickListener, int i17, Object obj) {
        if (obj == null) {
            if ((i17 & 4) != 0) {
                ahVar = null;
            }
            if ((i17 & 8) != 0) {
                onClickListener = null;
            }
            return bvVar.r(i3, i16, ahVar, onClickListener);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: singleLineText");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ com.tencent.mobileqq.widget.listitem.x v(bv bvVar, int i3, String str, ah ahVar, View.OnClickListener onClickListener, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 4) != 0) {
                ahVar = null;
            }
            if ((i16 & 8) != 0) {
                onClickListener = null;
            }
            return bvVar.s(i3, str, ahVar, onClickListener);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: singleLineText");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ com.tencent.mobileqq.widget.listitem.x w(bv bvVar, String str, String str2, ah ahVar, View.OnClickListener onClickListener, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                ahVar = null;
            }
            if ((i3 & 8) != 0) {
                onClickListener = null;
            }
            return bvVar.t(str, str2, ahVar, onClickListener);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: singleLineText");
    }

    @NotNull
    public final QBaseActivity b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QBaseActivity) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.activity;
    }

    @NotNull
    public final QUIListItemAdapter c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QUIListItemAdapter) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.adapter;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.dtReportPgId;
    }

    @NotNull
    public final LifecycleOwner e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LifecycleOwner) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.lifecycleOwner;
    }

    @NotNull
    public final Intent f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Intent) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        Intent intent = new Intent();
        intent.putExtras(this.viewModel.X1().a());
        return intent;
    }

    @NotNull
    public final com.tencent.mobileqq.troopmanage.repo.b g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.troopmanage.repo.b) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.viewModel.X1().m();
    }

    @NotNull
    public final TroopManageViewModel h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopManageViewModel) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.viewModel;
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return g().i().bOwner;
    }

    public final void j(@NotNull com.tencent.mobileqq.widget.listitem.x<?, x.c.f> r56, boolean isCheck) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, r56, Boolean.valueOf(isCheck));
            return;
        }
        Intrinsics.checkNotNullParameter(r56, "switch");
        r56.O().f(isCheck);
        this.adapter.l0(r56);
    }

    public final void k(@NotNull String elementId, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) elementId, (Object) params);
        } else {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            com.tencent.mobileqq.troopmanage.report.a.f303239a.a(this.dtReportPgId, elementId, params, this.viewModel);
        }
    }

    public final void m(@NotNull String elementId, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) elementId, (Object) params);
        } else {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            com.tencent.mobileqq.troopmanage.report.a.f303239a.c(this.dtReportPgId, elementId, params, this.viewModel);
        }
    }

    public final void o(@NotNull com.tencent.mobileqq.widget.listitem.x<?, x.c.f> config, @NotNull Function0<Unit> task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) config, (Object) task);
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(task, "task");
        if (!this.viewModel.j2()) {
            j(config, !config.O().getIsChecked());
            com.tencent.mobileqq.troopmanage.base.g gVar = com.tencent.mobileqq.troopmanage.base.g.f303036a;
            String string = this.activity.getString(R.string.b3j);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(com.t\u2026.string.failedconnection)");
            gVar.d(string);
            return;
        }
        task.invoke();
    }

    @NotNull
    public final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> p(@StringRes int leftStringRes, @Nullable final Function2<? super com.tencent.mobileqq.widget.listitem.x<?, x.c.f>, ? super Boolean, Unit> listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.mobileqq.widget.listitem.x) iPatchRedirector.redirect((short) 16, (Object) this, leftStringRes, (Object) listener);
        }
        x.Companion companion = com.tencent.mobileqq.widget.listitem.x.INSTANCE;
        String string = this.activity.getString(leftStringRes);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(leftStringRes)");
        final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> c16 = companion.c(string, null);
        c16.O().h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troopmanage.component.bu
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                bv.q(Function2.this, c16, compoundButton, z16);
            }
        });
        return c16;
    }

    @NotNull
    public final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> r(@StringRes int leftStringRes, @StringRes int rightStringRes, @Nullable ah<com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g>> initializer, @Nullable View.OnClickListener clickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.mobileqq.widget.listitem.x) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(leftStringRes), Integer.valueOf(rightStringRes), initializer, clickListener);
        }
        x.Companion companion = com.tencent.mobileqq.widget.listitem.x.INSTANCE;
        String string = this.activity.getString(leftStringRes);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(leftStringRes)");
        String string2 = this.activity.getString(rightStringRes);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(rightStringRes)");
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> a16 = companion.a(string, string2);
        a16.x(clickListener);
        if (initializer != null) {
            initializer.init(a16);
        }
        return a16;
    }

    @NotNull
    public final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> s(@StringRes int leftStringRes, @NotNull String rightString, @Nullable ah<com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g>> initializer, @Nullable View.OnClickListener clickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.mobileqq.widget.listitem.x) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(leftStringRes), rightString, initializer, clickListener);
        }
        Intrinsics.checkNotNullParameter(rightString, "rightString");
        x.Companion companion = com.tencent.mobileqq.widget.listitem.x.INSTANCE;
        String string = this.activity.getString(leftStringRes);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(leftStringRes)");
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> a16 = companion.a(string, rightString);
        a16.x(clickListener);
        if (initializer != null) {
            initializer.init(a16);
        }
        return a16;
    }

    @NotNull
    public final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> t(@NotNull String leftString, @NotNull String rightString, @Nullable ah<com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g>> initializer, @Nullable View.OnClickListener clickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.mobileqq.widget.listitem.x) iPatchRedirector.redirect((short) 14, this, leftString, rightString, initializer, clickListener);
        }
        Intrinsics.checkNotNullParameter(leftString, "leftString");
        Intrinsics.checkNotNullParameter(rightString, "rightString");
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> a16 = com.tencent.mobileqq.widget.listitem.x.INSTANCE.a(leftString, rightString);
        a16.x(clickListener);
        if (initializer != null) {
            initializer.init(a16);
        }
        return a16;
    }
}
