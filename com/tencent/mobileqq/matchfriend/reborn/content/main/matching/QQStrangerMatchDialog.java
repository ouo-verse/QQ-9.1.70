package com.tencent.mobileqq.matchfriend.reborn.content.main.matching;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchDialog;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$GetHomePageOfficeAnnouncementReq;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import com.tencent.trpcprotocol.kuolie.voice_match.voice_match.voiceMatch$DialogConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0002$)B\u000f\u0012\u0006\u0010&\u001a\u00020#\u00a2\u0006\u0004\b'\u0010(J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J$\u0010\u000e\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\"\u0010\u0010\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J8\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u001c\u0010\u001d\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u001e\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u001f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J(\u0010 \u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\"\u0010!\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fJ \u0010\"\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "code", "", "imsg", "", "isPreCheck", "", "v", "Lcom/tencent/trpcprotocol/kuolie/voice_match/voice_match/voiceMatch$DialogConfig;", "dialogConfig", "B", "p", "y", "l", "Landroid/content/Context;", "context", "msg", "r", "leftBtnTxt", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$b;", "leftAction", "rightBtnTxt", "rightAction", BdhLogUtil.LogTag.Tag_Conn, "url", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/a;", "a", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/a;", "matchManager", "<init>", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/a;)V", "b", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerMatchDialog {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a matchManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$b;", "", "", NodeProps.ON_CLICK, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public interface b {
        void onClick();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$c", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$b;", "", NodeProps.ON_CLICK, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements b {
        c() {
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchDialog.b
        public void onClick() {
            QQStrangerMatchDialog.this.matchManager.a();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$d", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$b;", "", NodeProps.ON_CLICK, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class d implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f244402b;

        d(Activity activity) {
            this.f244402b = activity;
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchDialog.b
        public void onClick() {
            QQStrangerMatchDialog.this.m(this.f244402b);
            QQStrangerMatchDialog.this.matchManager.b();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$e", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$b;", "", NodeProps.ON_CLICK, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class e implements b {
        e() {
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchDialog.b
        public void onClick() {
            QQStrangerMatchDialog.this.matchManager.a();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$f", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$b;", "", NodeProps.ON_CLICK, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class f implements b {
        f() {
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchDialog.b
        public void onClick() {
            QQStrangerMatchDialog.this.matchManager.start();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$g", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$b;", "", NodeProps.ON_CLICK, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class g implements b {
        g() {
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchDialog.b
        public void onClick() {
            QQStrangerMatchDialog.this.matchManager.a();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$h", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$b;", "", NodeProps.ON_CLICK, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class h implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f244407b;

        h(Activity activity) {
            this.f244407b = activity;
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchDialog.b
        public void onClick() {
            QQStrangerMatchDialog.this.n(this.f244407b);
            QQStrangerMatchDialog.this.matchManager.b();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$j", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$b;", "", NodeProps.ON_CLICK, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class j implements b {
        j() {
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchDialog.b
        public void onClick() {
            QQStrangerMatchDialog.this.matchManager.start();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$l", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$b;", "", NodeProps.ON_CLICK, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class l implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f244410b;

        l(Activity activity) {
            this.f244410b = activity;
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchDialog.b
        public void onClick() {
            QQStrangerMatchDialog.this.n(this.f244410b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$n", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$b;", "", NodeProps.ON_CLICK, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class n implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f244412b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ voiceMatch$DialogConfig f244413c;

        n(Activity activity, voiceMatch$DialogConfig voicematch_dialogconfig) {
            this.f244412b = activity;
            this.f244413c = voicematch_dialogconfig;
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchDialog.b
        public void onClick() {
            PBStringField pBStringField;
            QQStrangerMatchDialog qQStrangerMatchDialog = QQStrangerMatchDialog.this;
            Activity activity = this.f244412b;
            voiceMatch$DialogConfig voicematch_dialogconfig = this.f244413c;
            qQStrangerMatchDialog.o(activity, (voicematch_dialogconfig == null || (pBStringField = voicematch_dialogconfig.jump_url) == null) ? null : pBStringField.get());
        }
    }

    public QQStrangerMatchDialog(a matchManager) {
        Intrinsics.checkNotNullParameter(matchManager, "matchManager");
        this.matchManager = matchManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(QQStrangerMatchDialog this$0, Activity activity, int i3, voiceMatch$DialogConfig voicematch_dialogconfig) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B(activity, i3, voicematch_dialogconfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(b rightAction, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(rightAction, "$rightAction");
        rightAction.onClick();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(b leftAction, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(leftAction, "$leftAction");
        leftAction.onClick();
        dialogInterface.dismiss();
    }

    private final boolean l() {
        Object a16 = com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.a("loginUserInfoKey");
        userInfo$MiniInfo userinfo_miniinfo = a16 instanceof userInfo$MiniInfo ? (userInfo$MiniInfo) a16 : null;
        if (userinfo_miniinfo == null) {
            return true;
        }
        return !TextUtils.isEmpty(userinfo_miniinfo.avatar.get()) && !TextUtils.isEmpty(userinfo_miniinfo.nick.get()) && userinfo_miniinfo.age.get() > 0 && userinfo_miniinfo.gender.get() >= 0;
    }

    private final void p() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        Prompt$GetHomePageOfficeAnnouncementReq prompt$GetHomePageOfficeAnnouncementReq = new Prompt$GetHomePageOfficeAnnouncementReq();
        Object businessHandler = appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        ((com.tencent.relation.common.servlet.a) businessHandler).Z0("QQStranger.VoiceMatch.SsoSetReadVoiceMatchTip", prompt$GetHomePageOfficeAnnouncementReq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.o
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                QQStrangerMatchDialog.q(i3, z16, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(QQStrangerMatchDialog this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        this$0.matchManager.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(QQStrangerMatchDialog this$0, Activity activity, int i3, String imsg, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(imsg, "$imsg");
        this$0.v(activity, i3, imsg, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(QQStrangerMatchDialog this$0, Activity activity, int i3, String imsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(imsg, "$imsg");
        this$0.y(activity, i3, imsg);
    }

    public final void t(final Activity activity, final int code, final String imsg, final boolean isPreCheck) {
        Intrinsics.checkNotNullParameter(imsg, "imsg");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            v(activity, code, imsg, isPreCheck);
        } else if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.j
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerMatchDialog.u(QQStrangerMatchDialog.this, activity, code, imsg, isPreCheck);
                }
            });
        }
    }

    public final void w(final Activity activity, final int code, final String imsg) {
        Intrinsics.checkNotNullParameter(imsg, "imsg");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            y(activity, code, imsg);
        } else if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.p
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerMatchDialog.x(QQStrangerMatchDialog.this, activity, code, imsg);
                }
            });
        }
    }

    public final void z(final Activity activity, final int code, final voiceMatch$DialogConfig dialogConfig) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            B(activity, code, dialogConfig);
        } else if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.n
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerMatchDialog.A(QQStrangerMatchDialog.this, activity, code, dialogConfig);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(Activity activity, String url) {
        if (activity != null && !activity.isFinishing() && !TextUtils.isEmpty(url)) {
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", url);
            activity.startActivity(intent);
        } else {
            if (url == null) {
                url = "undefined";
            }
            QLog.e("QQStrangerMatchDialog", 1, "jumpWebUrl fail, url=" + url);
        }
    }

    private final void B(Activity activity, int code, voiceMatch$DialogConfig dialogConfig) {
        PBStringField pBStringField;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        PBStringField pBStringField4;
        PBStringField pBStringField5;
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        String str = null;
        QLog.i("QQStrangerMatchDialog", 1, "show,code=" + code + ",msg=" + ((dialogConfig == null || (pBStringField5 = dialogConfig.body) == null) ? null : pBStringField5.get()));
        String str2 = (dialogConfig == null || (pBStringField4 = dialogConfig.body) == null) ? null : pBStringField4.get();
        String str3 = "\u64cd\u4f5c\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002";
        String str4 = (TextUtils.isEmpty(str2) || str2 == null) ? "\u64cd\u4f5c\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002" : str2;
        if (code == 2) {
            C(activity, str4, "\u7a0d\u540e\u518d\u8bf4", new m(), "\u6388\u6743\u5b9e\u540d", new n(activity, dialogConfig));
            return;
        }
        if (code != 7) {
            if (dialogConfig != null && (pBStringField3 = dialogConfig.body) != null) {
                str = pBStringField3.get();
            }
            if (!TextUtils.isEmpty(str) && str != null) {
                str3 = str;
            }
            r(activity, str3);
            return;
        }
        w wVar = new w(activity);
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) wVar.findViewById(R.id.opa);
        if (roundRelativeLayout != null) {
            roundRelativeLayout.f316195e = activity.getResources().getDimensionPixelSize(R.dimen.f158726ng);
        }
        String str5 = (dialogConfig == null || (pBStringField2 = dialogConfig.title) == null) ? null : pBStringField2.get();
        if (str5 == null) {
            str5 = "\u8fde\u9ea6\u987b\u77e5";
        }
        wVar.h(str5);
        if (dialogConfig != null && (pBStringField = dialogConfig.body) != null) {
            str = pBStringField.get();
        }
        if (str == null) {
            str = "\u8bed\u97f3\u8fde\u9ea6\u9f13\u52b1\u6e29\u6696\u966a\u4f34\u3001\u6811\u6d1e\u503e\u8bc9\uff0c\u8bf7\u4fdd\u6301\u793e\u4ea4\u793c\u4eea\uff0c\u53cb\u5584\u804a\u5929\u3002\n\u5982\u6709\u4efb\u4f55\u8fdd\u89c4\u884c\u4e3a\uff0c\u817e\u8baf\u6709\u6743\u5c01\u53f7\u6216\u8ffd\u7a76\u6cd5\u5f8b\u8d23\u4efb\u3002";
        }
        wVar.g(str);
        wVar.e(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchDialog$showMatchVoicePreCheckFailDialogInner$3
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        wVar.show();
        p();
    }

    private final void C(Context context, String msg2, String leftBtnTxt, final b leftAction, String rightBtnTxt, final b rightAction) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, (String) null, msg2, leftBtnTxt, rightBtnTxt, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQStrangerMatchDialog.D(QQStrangerMatchDialog.b.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQStrangerMatchDialog.E(QQStrangerMatchDialog.b.this, dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026miss()\n                })");
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(Activity activity) {
        if (activity == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterChatSetting(activity, appInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(Activity activity) {
        PBStringField pBStringField;
        if (activity == null) {
            return;
        }
        Object a16 = com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.a("loginUserInfoKey");
        String str = null;
        userInfo$MiniInfo userinfo_miniinfo = a16 instanceof userInfo$MiniInfo ? (userInfo$MiniInfo) a16 : null;
        if (userinfo_miniinfo != null && (pBStringField = userinfo_miniinfo.open_id) != null) {
            str = pBStringField.get();
        }
        if (str == null || str.length() == 0) {
            QLog.i("QQStrangerMatchDialog", 1, "jumpEditProfilePage but openId is empty.");
        } else {
            ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterProfileEdit(activity, str);
        }
    }

    private final void v(Activity activity, int code, String imsg, boolean isPreCheck) {
        String str;
        if (activity == null) {
            return;
        }
        QLog.i("QQStrangerMatchDialog", 1, "show,code=" + code + ",msg=" + imsg + ",isPreCheck=" + isPreCheck);
        String str2 = TextUtils.isEmpty(imsg) ? "\u64cd\u4f5c\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002" : imsg;
        switch (code) {
            case 3000:
                r(activity, str2);
                return;
            case 3001:
                C(activity, str2, "\u4e0b\u6b21\u518d\u8bf4", new c(), "\u53bb\u4fee\u6539", new d(activity));
                return;
            case 3002:
                if (isPreCheck) {
                    str = "\u7a0d\u540e\u518d\u8bf4";
                } else {
                    str = "\u6682\u65f6\u9000\u51fa";
                }
                C(activity, str2, str, new g(), "\u5b8c\u5584\u8d44\u6599", new h(activity));
                return;
            case 3003:
            case 3005:
                C(activity, "\u6682\u65f6\u6ca1\u6709\u5339\u914d\u5230\u5408\u9002\u7684\u4eba\uff0c\u662f\u5426\u7ee7\u7eed\u7b49\u5f85\uff1f", "\u6682\u65f6\u9000\u51fa", new e(), "\u7ee7\u7eed\u7b49\u5f85", new f());
                return;
            case 3004:
                r(activity, str2);
                return;
            default:
                r(activity, "\u64cd\u4f5c\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002");
                return;
        }
    }

    private final void y(Activity activity, int code, String imsg) {
        if (activity == null) {
            return;
        }
        QLog.i("QQStrangerMatchDialog", 1, "show,code=" + code + ",msg=" + imsg);
        if (l()) {
            C(activity, "\u6682\u65f6\u6ca1\u6709\u5339\u914d\u5230\u5408\u9002\u7684\u4eba\uff0c\u662f\u5426\u7ee7\u7eed\u7b49\u5f85\uff1f", "\u6682\u65f6\u9000\u51fa", new i(), "\u7ee7\u7eed\u7b49\u5f85", new j());
        } else {
            C(activity, "\u6682\u65f6\u6ca1\u6709\u5339\u914d\u5230\u5408\u9002\u7684\u4eba\uff0c\u5b8c\u5584\u8d44\u6599\u4f1a\u5927\u5927\u63d0\u5347\u5339\u914d\u7387\u54e6\uff5e", "\u6682\u65f6\u9000\u51fa", new k(), "\u5b8c\u5584\u8d44\u6599", new l(activity));
        }
    }

    private final void r(Context context, String msg2) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, (String) null, msg2, (String) null, "\u77e5\u9053\u4e86", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQStrangerMatchDialog.s(QQStrangerMatchDialog.this, dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026\n                }, null)");
        createCustomDialog.show();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$i", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$b;", "", NodeProps.ON_CLICK, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class i implements b {
        i() {
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchDialog.b
        public void onClick() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$k", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$b;", "", NodeProps.ON_CLICK, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class k implements b {
        k() {
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchDialog.b
        public void onClick() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$m", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog$b;", "", NodeProps.ON_CLICK, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class m implements b {
        m() {
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchDialog.b
        public void onClick() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(int i3, boolean z16, Object obj) {
    }
}
