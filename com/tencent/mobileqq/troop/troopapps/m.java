package com.tencent.mobileqq.troop.troopapps;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.aivoicechat.api.ITroopAIVoiceChatApi;
import com.tencent.mobileqq.troop.utils.ay;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.AppCommonAction;
import com.tencent.qqnt.kernel.nativeinterface.AppCommonJump;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001+B)\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/troop/troopapps/m;", "Landroid/app/Dialog;", "Ldt2/c;", "", "initWindow", "initView", "onConfigurationChanged", "", ViewStickEventHelper.IS_SHOW, "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/AppDetail;", "D", "Lcom/tencent/qqnt/kernel/nativeinterface/AppDetail;", "appDetail", "E", "Z", "isOpenCapsuleSwitch", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "qusHalfScreenFloatingView", "Landroid/view/View;", "G", "Landroid/view/View;", "mContainer", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "ivIcon", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "tvName", "J", "tvDes", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/AppDetail;Z)V", "K", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class m extends ReportDialog implements dt2.c {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private final String troopUin;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final AppDetail appDetail;

    /* renamed from: E, reason: from kotlin metadata */
    private final boolean isOpenCapsuleSwitch;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final QUSHalfScreenFloatingView qusHalfScreenFloatingView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View mContainer;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ImageView ivIcon;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TextView tvName;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private TextView tvDes;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/troopapps/m$a", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "initState", "defaultHeight", NodeProps.MAX_HEIGHT, "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends com.tencent.mobileqq.widget.qus.e {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f299442e;

        a(Context context) {
            this.f299442e = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this, (Object) context);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF52508d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            if (m.this.mContainer == null) {
                m.this.mContainer = LayoutInflater.from(this.f299442e).inflate(R.layout.g0s, (ViewGroup) null, false);
            }
            View view = m.this.mContainer;
            if (view != null) {
                m mVar = m.this;
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                view.setBackgroundResource(R.drawable.qui_common_bg_top_light_bg);
                mVar.initView();
            }
            return m.this.mContainer;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int defaultHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return ViewUtils.dip2px(302.0f);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return ViewUtils.dip2px(302.0f);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopapps/m$b;", "", "", "AI_CHAT_APP_ID", "Ljava/lang/String;", "", "DIALOG_HEIGHT", UserInfo.SEX_FEMALE, "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopapps.m$b, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56529);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull Context context, @Nullable String str, @NotNull AppDetail appDetail, boolean z16) {
        super(context, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appDetail, "appDetail");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, appDetail, Boolean.valueOf(z16));
            return;
        }
        this.troopUin = str;
        this.appDetail = appDetail;
        this.isOpenCapsuleSwitch = z16;
        initWindow();
        setContentView(R.layout.e3i);
        View findViewById = findViewById(R.id.f66733bf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(com.tencent\u2026qus_floating_half_screen)");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById;
        this.qusHalfScreenFloatingView = qUSHalfScreenFloatingView;
        qUSHalfScreenFloatingView.setQUSDragFloatController(new a(context));
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.troop.troopapps.k
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                m.P(m.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(m this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(m this$0, View view) {
        String str;
        Long longOrNull;
        String str2;
        String str3;
        Long longOrNull2;
        AppCommonJump appCommonJump;
        String str4;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        boolean z16 = true;
        if (this$0.troopUin == null) {
            QLog.e("AIChatVoiceUseHintDialog", 1, "[initView] troopUin is null");
            com.tencent.qqnt.e.k(this$0.getContext(), 0, "\u7fa4\u53f7\u4e3a\u7a7a", 0, null, 26, null);
        } else {
            long j3 = 0;
            String str5 = null;
            if (Intrinsics.areEqual(this$0.appDetail.appId, "102438828")) {
                AppCommonAction appCommonAction = this$0.appDetail.action;
                if (appCommonAction != null && (appCommonJump = appCommonAction.jump) != null && (str4 = appCommonJump.url) != null) {
                    str2 = Uri.parse(str4).getQueryParameter(ITroopAIVoiceChatApi.AI_CHAT_TYPE);
                } else {
                    str2 = null;
                }
                QLog.i("AIChatVoiceUseHintDialog", 1, "onItemViewClick: " + this$0.troopUin + " type " + ((Object) str2) + " ");
                if (str2 != null && str2.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    str2 = "1";
                }
                IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
                Context context = this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                String str6 = this$0.troopUin;
                TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(this$0.troopUin);
                if (troopInfoFromCache != null) {
                    str5 = troopInfoFromCache.getTroopDisplayName();
                }
                if (str5 == null) {
                    str3 = "";
                } else {
                    str3 = str5;
                }
                longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(this$0.troopUin);
                if (longOrNull2 != null) {
                    j3 = longOrNull2.longValue();
                }
                Bundle bundle = new Bundle();
                bundle.putInt(ITroopAIVoiceChatApi.PARAM_KEY_OPEN_AI_CHAT_TYPE, Integer.parseInt(str2));
                Unit unit = Unit.INSTANCE;
                iAIOStarterApi.navigateToAIO(context, 2, str6, str3, j3, bundle);
            } else {
                IAIOStarterApi iAIOStarterApi2 = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
                Context context2 = this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                String str7 = this$0.troopUin;
                TroopInfo troopInfoFromCache2 = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(this$0.troopUin);
                if (troopInfoFromCache2 != null) {
                    str5 = troopInfoFromCache2.getTroopDisplayName();
                }
                if (str5 == null) {
                    str = "";
                } else {
                    str = str5;
                }
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this$0.troopUin);
                if (longOrNull != null) {
                    j3 = longOrNull.longValue();
                }
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("key_troop_apps_capsule", this$0.appDetail);
                bundle2.putBoolean("key_troop_apps_open_capsule_switch", this$0.isOpenCapsuleSwitch);
                Unit unit2 = Unit.INSTANCE;
                iAIOStarterApi2.navigateToAIO(context2, 2, str7, str, j3, bundle2);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initView() {
        View view = this.mContainer;
        if (view != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.sgk);
            this.ivIcon = imageView;
            String str = "";
            if (imageView != null) {
                ay ayVar = ay.f302095a;
                String str2 = this.appDetail.icon;
                if (str2 == null) {
                    str2 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str2, "appDetail.icon ?: \"\"");
                }
                ayVar.a(str2, imageView);
            }
            TextView textView = (TextView) view.findViewById(R.id.sgl);
            this.tvName = textView;
            if (textView != null) {
                String str3 = this.appDetail.name;
                if (str3 == null) {
                    str3 = "";
                }
                textView.setText(str3);
            }
            TextView textView2 = (TextView) view.findViewById(R.id.sgj);
            this.tvDes = textView2;
            if (textView2 != null) {
                String str4 = this.appDetail.desc;
                if (str4 != null) {
                    str = str4;
                }
                textView2.setText(str);
            }
            View findViewById = view.findViewById(R.id.tez);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopapps.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        m.U(m.this, view2);
                    }
                });
            }
        }
    }

    private final void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("AIChatVoiceUseHintDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    @Override // dt2.c
    public boolean isShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return isShowing();
    }

    @Override // dt2.c
    public void onConfigurationChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.qusHalfScreenFloatingView.L();
        }
    }
}
