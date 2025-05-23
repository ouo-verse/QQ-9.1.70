package com.tencent.guild.aio.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.util.ex.FromScene;
import com.tencent.guild.api.msglist.IGuildAIOMultiActionApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.anim.b;
import com.tencent.mobileqq.guild.api.IDirectMessageNodeRepoApi;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.api.IRecentGuildApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;
import us.a;
import zp0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 02\u00020\u0001:\u00031'2B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0002J \u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001c2\u0006\u0010\u0003\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\fJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\fJ \u0010$\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\b\u0010#\u001a\u0004\u0018\u00010\u0016J\u0006\u0010%\u001a\u00020\u0006R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u00063"}, d2 = {"Lcom/tencent/guild/aio/activity/GuildChatActivityAbility;", "", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "r", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "Landroid/os/Bundle;", "extData", "u", "Landroid/app/Activity;", "j", "i", "", "keyCode", "Landroid/view/KeyEvent;", "event", DomainData.DOMAIN_NAME, "k", "l", "Landroid/content/Intent;", "intent", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "Lzp0/b$a;", "Lkotlin/collections/ArrayList;", "g", "f", "", h.F, "requestCode", QzoneIPCModule.RESULT_CODE, "data", "c", "p", "Lus/a;", "a", "Lus/a;", "e", "()Lus/a;", ReportConstant.COSTREPORT_PREFIX, "(Lus/a;)V", "chatFragmentProvider", "<init>", "()V", "b", "ActivityResultIntent", "PostThemeChangedIntent", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildChatActivityAbility {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static boolean f109801c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private static AIOContact f109802d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public a chatFragmentProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/guild/aio/activity/GuildChatActivityAbility$ActivityResultIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "", "d", "I", "b", "()I", "requestCode", "e", "c", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "f", "Landroid/content/Intent;", "a", "()Landroid/content/Intent;", "data", "<init>", "(IILandroid/content/Intent;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class ActivityResultIntent implements MsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int requestCode;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int resultCode;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Intent data;

        public ActivityResultIntent(int i3, int i16, @Nullable Intent intent) {
            this.requestCode = i3;
            this.resultCode = i16;
            this.data = intent;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Intent getData() {
            return this.data;
        }

        /* renamed from: b, reason: from getter */
        public final int getRequestCode() {
            return this.requestCode;
        }

        /* renamed from: c, reason: from getter */
        public final int getResultCode() {
            return this.resultCode;
        }

        @Override // com.tencent.mvi.base.route.i
        public /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        @Override // com.tencent.mvi.base.route.MsgIntent
        public boolean isSticky() {
            return MsgIntent.a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/activity/GuildChatActivityAbility$PostThemeChangedIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class PostThemeChangedIntent implements MsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final PostThemeChangedIntent f109807d = new PostThemeChangedIntent();

        PostThemeChangedIntent() {
        }

        @Override // com.tencent.mvi.base.route.i
        public /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        @Override // com.tencent.mvi.base.route.MsgIntent
        public boolean isSticky() {
            return MsgIntent.a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0007\u0010\b\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0011R\u0014\u0010\u0019\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guild/aio/activity/GuildChatActivityAbility$a;", "", "", "exist", "", "b", "Lcom/tencent/aio/data/AIOContact;", "aioContact", "Lcom/tencent/aio/data/AIOContact;", "a", "()Lcom/tencent/aio/data/AIOContact;", "setAioContact", "(Lcom/tencent/aio/data/AIOContact;)V", "getAioContact$annotations", "()V", "", "CHANNEL_ID", "Ljava/lang/String;", "ENTRANCE_FROM_JUBAO", "EXT_DATA", "FACTORY_NAME", IGuildMessageUtilsApi.GUILD_ID_EXT_STR, "JUBAO_RESULT_OK", "KEY_CHAT_MSG_LIST", "KEY_PENETRATE_TO_CHAT_ACTIVITY", "TAG", "isActivityExist", "Z", "<init>", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.activity.GuildChatActivityAbility$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final AIOContact a() {
            return GuildChatActivityAbility.f109802d;
        }

        public final void b(boolean exist) {
            GuildChatActivityAbility.f109801c = exist;
        }

        Companion() {
        }
    }

    @Nullable
    public static final AIOContact d() {
        return INSTANCE.a();
    }

    private final boolean i(Activity activity) {
        Bundle bundleExtra = activity.getIntent().getBundleExtra(AppConstants.Key.GUILD_EXTRA);
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        return bundleExtra.getBoolean("entrance_from_jubao");
    }

    private final boolean j(Activity activity) {
        Bundle bundleExtra = activity.getIntent().getBundleExtra(AppConstants.Key.GUILD_EXTRA);
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        return bundleExtra.getBoolean("From_SplashActivity");
    }

    private final void q(FragmentActivity activity) {
        boolean z16;
        Bundle bundleExtra;
        Intent intent = activity.getIntent();
        if (intent != null && (bundleExtra = intent.getBundleExtra(AppConstants.Key.GUILD_EXTRA)) != null) {
            z16 = bundleExtra.getBoolean("jumpGuildFromLoadingPage");
        } else {
            z16 = false;
        }
        if (z16) {
            activity.overridePendingTransition(R.anim.l_, R.anim.l_);
        } else {
            activity.overridePendingTransition(R.anim.f154619or, R.anim.f154425m);
        }
    }

    private final boolean r(FragmentActivity activity) {
        AppInterface appInterface;
        boolean z16;
        IGProChannelInfo channelInfo;
        try {
            String stringExtra = activity.getIntent().getStringExtra("channel_id");
            if (stringExtra == null) {
                stringExtra = "";
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IRuntimeService iRuntimeService = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
            }
            IGPSService iGPSService = (IGPSService) iRuntimeService;
            if (iGPSService != null && (channelInfo = iGPSService.getChannelInfo(stringExtra)) != null && channelInfo.getType() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                b.c("aio", activity);
                return true;
            }
        } catch (Exception e16) {
            QLog.i("GuildChatActivityAbility", 1, "setAIOAnimation exception: " + e16.getMessage());
        }
        return false;
    }

    private final void t(FragmentActivity activity) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        IGProChannelInfo channelInfo;
        String stringExtra = activity.getIntent().getStringExtra("channel_id");
        String str = "";
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = activity.getIntent().getStringExtra("guild_id");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        boolean z26 = false;
        if (stringExtra2.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String str2 = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
            } else {
                iRuntimeService = null;
            }
            IGPSService iGPSService = (IGPSService) iRuntimeService;
            if (iGPSService != null && (channelInfo = iGPSService.getChannelInfo(stringExtra)) != null) {
                str2 = channelInfo.getGuildId();
            }
            if (str2 == null) {
                stringExtra2 = "";
            } else {
                stringExtra2 = str2;
            }
        }
        String str3 = stringExtra2;
        String stringExtra3 = activity.getIntent().getStringExtra("factory_name");
        if (stringExtra3 != null) {
            str = stringExtra3;
        }
        Bundle bundleExtra = activity.getIntent().getBundleExtra(AppConstants.Key.GUILD_EXTRA);
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        Bundle bundle = bundleExtra;
        u(bundle);
        if (str3.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            if (stringExtra.length() == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                if (str.length() == 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (!z19) {
                    f109802d = new AIOContact(4, stringExtra, str3, null, 8, null);
                    QLog.i("GuildChatActivityAbility", 1, "startAIOFragment channelId: " + stringExtra + ", guildId: " + str3);
                    AIOParam.a e16 = new AIOParam.a().e(str);
                    AIOContact aIOContact = f109802d;
                    Intrinsics.checkNotNull(aIOContact);
                    AIOParam.a a16 = e16.h(new AIOSession(aIOContact)).i(true).d(0).a(bundle);
                    String name = com.tencent.guild.aio.factory.b.class.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "GuildFirstScreenHelper::class.java.name");
                    AIOParam c16 = a16.g(name).c();
                    com.tencent.guild.aio.factory.b.INSTANCE.b(activity, c16);
                    try {
                        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
                        s(com.tencent.guild.aio.util.ex.b.c(c16, supportFragmentManager, android.R.id.content, null, null, 24, null));
                        if (i(activity)) {
                            GuildMultiMsgManager.d dVar = new GuildMultiMsgManager.d(stringExtra, f(activity));
                            GuildMultiMsgManager.Companion companion = GuildMultiMsgManager.INSTANCE;
                            companion.a().n(dVar, true);
                            ArrayList<b.a> g16 = g(activity);
                            if (g16 != null && g16.size() > 0 && Intrinsics.areEqual(((IGuildAIOMultiActionApi) QRoute.api(IGuildAIOMultiActionApi.class)).newReportPluginEncrypt(stringExtra), g16.get(0).getChannelUin())) {
                                companion.a().m(dVar, g16);
                                QLog.i("GuildChatActivityAbility", 1, "startAIOFragment isFromJubao initSelectMsg: " + g16);
                            }
                            activity.getIntent().putExtra("penetrate_to_chat_activity", h(activity));
                        }
                        if (bundle.getByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG) == 1) {
                            z26 = true;
                        }
                        if (z26) {
                            str3 = ((IDirectMessageNodeRepoApi) QRoute.api(IDirectMessageNodeRepoApi.class)).findNodeByGuildId(str3);
                        }
                        ((IRecentGuildApi) QRoute.api(IRecentGuildApi.class)).addRecentVisitGuildsListSync(str3, "GuildChatActivityAbility");
                        return;
                    } catch (IllegalStateException e17) {
                        QLog.e("GuildChatActivityAbility", 1, "startAIOFragment e:" + e17);
                        activity.finish();
                        return;
                    }
                }
            }
        }
        QLog.e("GuildChatActivityAbility", 1, "startAIOFragment dataLegal guildId:" + str3 + " channelId:" + stringExtra + " factoryName:" + str);
        activity.finish();
    }

    private final void u(Bundle extData) {
        if (extData.containsKey(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_SEQ_ID_TO_JUMP)) {
            extData.putLong("navigate_msg_seq", extData.getLong(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_SEQ_ID_TO_JUMP));
        }
    }

    public final void c(int requestCode, int resultCode, @Nullable Intent data) {
        e().a(new ActivityResultIntent(requestCode, resultCode, data));
    }

    @NotNull
    public final a e() {
        a aVar = this.chatFragmentProvider;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("chatFragmentProvider");
        return null;
    }

    public final int f(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Bundle bundleExtra = activity.getIntent().getBundleExtra(AppConstants.Key.GUILD_EXTRA);
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        return bundleExtra.getInt("AIOParam_FromScene", FromScene.DEFAULT.ordinal());
    }

    @Nullable
    public final ArrayList<b.a> g(@NotNull Activity activity) {
        boolean z16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Bundle bundleExtra = activity.getIntent().getBundleExtra(AppConstants.Key.GUILD_EXTRA);
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        String string = bundleExtra.getString("msgs");
        if (string != null && string.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        ArrayList<b.a> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    b.a aVar = new b.a();
                    aVar.a(optJSONObject);
                    arrayList.add(aVar);
                }
            }
        } catch (JSONException unused) {
        }
        return arrayList;
    }

    @NotNull
    public final String h(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Bundle bundleExtra = activity.getIntent().getBundleExtra(AppConstants.Key.GUILD_EXTRA);
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        String string = bundleExtra.getString("penetrate_to_chat_activity", "");
        Intrinsics.checkNotNullExpressionValue(string, "extData.getString(KEY_PE\u2026ATE_TO_CHAT_ACTIVITY, \"\")");
        return string;
    }

    public final boolean k(@NotNull FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity.getSupportFragmentManager().getBackStackEntryCount() == 0) {
            if (i(activity)) {
                if (!activity.getIntent().getBooleanExtra("jubao_result_ok", false)) {
                    activity.setResult(0, activity.getIntent());
                }
                return false;
            }
            if (!e().onBackPressed()) {
                return false;
            }
            return true;
        }
        activity.getSupportFragmentManager().popBackStack();
        return true;
    }

    public final void l(@NotNull FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), activity.getWindow());
        if (!r(activity)) {
            q(activity);
        }
        t(activity);
        if (j(activity)) {
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).setChannelPageSourceType("aio", 3);
        }
        INSTANCE.b(true);
    }

    public final void m(@NotNull FragmentActivity activity) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        AIOContact aIOContact = f109802d;
        if (aIOContact != null) {
            str = aIOContact.j();
        } else {
            str = null;
        }
        AIOContact aIOContact2 = f109802d;
        if (aIOContact2 != null) {
            str2 = aIOContact2.f();
        } else {
            str2 = null;
        }
        QLog.i("GuildChatActivityAbility", 1, "onDestroy channelId: " + str + ", guildId: " + str2);
        f109802d = null;
        INSTANCE.b(false);
        if (j(activity)) {
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).unSetChannelPageSourceType("aio");
        }
        if (i(activity)) {
            String stringExtra = activity.getIntent().getStringExtra("channel_id");
            if (stringExtra == null) {
                stringExtra = "";
            }
            GuildMultiMsgManager.d dVar = new GuildMultiMsgManager.d(stringExtra, f(activity));
            GuildMultiMsgManager.Companion companion = GuildMultiMsgManager.INSTANCE;
            companion.a().n(dVar, false);
            companion.a().q(dVar);
        }
    }

    public final boolean n(int keyCode, @Nullable KeyEvent event, @NotNull FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (keyCode == 4) {
            activity.onBackPressed();
            return true;
        }
        return false;
    }

    public final void o(@Nullable Intent intent, @NotNull FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.setIntent(intent);
        t(activity);
    }

    public final void p() {
        if (this.chatFragmentProvider != null) {
            e().a(PostThemeChangedIntent.f109807d);
        }
    }

    public final void s(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.chatFragmentProvider = aVar;
    }
}
