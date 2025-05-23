package com.tencent.mobileqq.zplan.aio.badge.p012new;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.conversationtitlebutton.ConversationTitleBtnConfig;
import com.tencent.mobileqq.util.conversationtitlebutton.TitleButtonState;
import com.tencent.mobileqq.util.conversationtitlebutton.g;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.aio.badge.p012new.ZPlanPortalTitleButtonProcessor;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.common.utils.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import nk3.n;
import rj3.b;
import t74.l;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J(\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0014\u0010\u000e\u001a\u00020\u000b2\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J+\u0010\u0015\u001a\u00020\u000b2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000b0\u0011H\u0016J\u0014\u0010\u0017\u001a\u00020\u000b2\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016J \u0010\u0018\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001e\u0010\u0019\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001d\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/badge/new/ZPlanPortalTitleButtonProcessor;", "Lcom/tencent/mobileqq/util/conversationtitlebutton/g;", "Landroid/content/Context;", "context", "", WadlProxyConsts.KEY_JUMP_URL, "Lcom/tencent/mobileqq/util/conversationtitlebutton/a;", "Lcom/tencent/mobileqq/zplan/aio/badge/new/Config;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/util/conversationtitlebutton/l;", "buttonState", "", "jumpBySchemaUrl", "jumpPortalActivity", "updateRedTouchInfo", "reportEntranceExpose", "reportEntranceClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSupport", "callback", "onButtonDidShow", "handleIconClick", "buttonConfig", "Lcom/tencent/mobileqq/util/conversationtitlebutton/a;", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "Lcom/tencent/mobileqq/zplan/aio/badge/new/RedTouchAppInfo;", "redTouchAppInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "isStudyMode", "()Z", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanPortalTitleButtonProcessor implements g {

    @Deprecated
    public static final String TAG = "ZPlanPortalTitleButtonProcessor";
    private ConversationTitleBtnConfig buttonConfig;
    private BusinessInfoCheckUpdate.AppInfo redTouchAppInfo;
    private static final a Companion = new a(null);

    @Deprecated
    private static final AtomicBoolean hasPreload = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/badge/new/ZPlanPortalTitleButtonProcessor$a;", "", "", "b", "", "appSet", "appId", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "Lcom/tencent/mobileqq/zplan/aio/badge/new/RedTouchAppInfo;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasPreload", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c() {
            if (ZPlanPortalTitleButtonProcessor.Companion.d().getAndSet(true)) {
                return;
            }
            ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).preLoadCoreDatas();
        }

        public final void b() {
            l.f435563a.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.badge.new.a
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanPortalTitleButtonProcessor.a.c();
                }
            });
        }

        public final AtomicBoolean d() {
            return ZPlanPortalTitleButtonProcessor.hasPreload;
        }

        a() {
        }

        public final BusinessInfoCheckUpdate.AppInfo e(int appSet, int appId) {
            AppRuntime d16;
            if (appSet == -1 || appId == -1 || (d16 = bb.f335811a.d()) == null) {
                return null;
            }
            IRuntimeService runtimeService = d16.getRuntimeService(IRedTouchManager.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026anager::class.java, MAIN)");
            return ((IRedTouchManager) runtimeService).getAppInfo(appSet, String.valueOf(appId));
        }
    }

    private final boolean isStudyMode() {
        return ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isSupport$lambda$0(Long l3, Function1 callback, AccessibleDetail accessibleDetail) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        boolean z16 = false;
        if (accessibleDetail != null && accessibleDetail.isAccessible()) {
            z16 = true;
        }
        QLog.i(TAG, 1, "isSupport, accessible:" + z16 + ", uin:" + i.a(l3.toString()));
        callback.invoke(Boolean.valueOf(z16));
        if (z16) {
            Companion.b();
        }
    }

    private final void jumpBySchemaUrl(Context context, String jumpUrl, ConversationTitleBtnConfig config, TitleButtonState buttonState) {
        String str = null;
        if (buttonState.getHasRedTouch()) {
            str = String.valueOf(config != null ? Integer.valueOf(config.getRedDotAppId()) : null);
        }
        boolean z16 = true;
        QLog.i(TAG, 1, "jumpBySchemaUrl:" + jumpUrl + ", redTouchAppId:" + str);
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            Bundle bundle = new Bundle();
            bundle.putString("tianshuID", str);
            jumpUrl = ((ISchemeApi) QRoute.api(ISchemeApi.class)).appendPageDataToScheme(jumpUrl, bundle);
        }
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchScheme(context, jumpUrl);
    }

    private final void jumpPortalActivity(Context context, ConversationTitleBtnConfig config, TitleButtonState buttonState) {
        boolean z16 = true;
        QLog.i(TAG, 1, "jumpPortalActivity");
        Bundle bundle = new Bundle();
        bundle.putBoolean("needShowGuide", true);
        String str = null;
        if (buttonState.getHasRedTouch()) {
            str = String.valueOf(config != null ? Integer.valueOf(config.getRedDotAppId()) : null);
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            bundle.putString("tianshuID", str);
        }
        ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startPortalActivity(context, ZootopiaSource.INSTANCE.a(Source.Conversation), bundle);
    }

    private final void reportEntranceClick(TitleButtonState buttonState) {
        b.f431586a.a(this.redTouchAppInfo, buttonState.getHasRedTouch(), false, buttonState.getIsTipsShowing());
    }

    private final void reportEntranceExpose() {
        b.f431586a.b(this.redTouchAppInfo, false, false, false);
    }

    private final void updateRedTouchInfo(ConversationTitleBtnConfig config) {
        this.redTouchAppInfo = Companion.e(config.getRedDotSet(), config.getRedDotAppId());
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void getAvatarDrawableList(Context context, BusinessInfoCheckUpdate.AppInfo appInfo, Function1<? super Drawable[], Unit> function1) {
        g.a.a(this, context, appInfo, function1);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void getCustomTips(Context context, Function2<? super String, ? super List<? extends Drawable>, Unit> function2) {
        g.a.b(this, context, function2);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public boolean handleIconClick(TitleButtonState buttonState, Context context, String jumpUrl) {
        Intrinsics.checkNotNullParameter(buttonState, "buttonState");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        ConversationTitleBtnConfig conversationTitleBtnConfig = this.buttonConfig;
        if (jumpUrl.length() == 0) {
            jumpBySchemaUrl(context, jumpUrl, conversationTitleBtnConfig, buttonState);
        } else {
            jumpPortalActivity(context, conversationTitleBtnConfig, buttonState);
        }
        reportEntranceClick(buttonState);
        return true;
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void isSupport(final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime d16 = bb.f335811a.d();
        final Long valueOf = d16 != null ? Long.valueOf(d16.getLongAccountUin()) : null;
        if (valueOf == null) {
            QLog.w(TAG, 1, "isSupport, invalid uin!");
            callback.invoke(Boolean.FALSE);
        } else {
            if (isStudyMode()) {
                QLog.w(TAG, 1, "isSupport, callback false for studyMode:" + isStudyMode());
                callback.invoke(Boolean.FALSE);
                return;
            }
            uk3.g.f439121a.e(1001L, valueOf.longValue(), new n() { // from class: fe3.a
                @Override // nk3.n
                public final void a(AccessibleDetail accessibleDetail) {
                    ZPlanPortalTitleButtonProcessor.isSupport$lambda$0(valueOf, callback, accessibleDetail);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public boolean needCustomizeRedDot() {
        return g.a.d(this);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public boolean needCustomizeTips() {
        return g.a.e(this);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void onButtonDidShow(ConversationTitleBtnConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        QLog.i(TAG, 1, "onButtonDidShow, config:" + config);
        this.buttonConfig = config;
        updateRedTouchInfo(config);
        reportEntranceExpose();
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void refreshRedDot(RedTouch redTouch, BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        g.a.g(this, redTouch, appInfo, z16);
    }
}
