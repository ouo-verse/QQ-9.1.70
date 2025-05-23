package com.tencent.mobileqq.emosm.emocompat.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.guild.api.aio.panel.BaseEmoticonPanelProvider;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.EmosmEmoticonConstant;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.EmoticonCallbackWithShowPanel;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonDelApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00062\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010(\u001a\u00020&\u0012\u0006\u0010+\u001a\u00020)\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u001f\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010 \u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010!\u001a\u00020\u0013H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010$\u001a\u00020#H\u0016R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010*R\"\u00101\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R#\u00107\u001a\n 3*\u0004\u0018\u000102028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u00104\u001a\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u00108\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/emosm/emocompat/impl/GuildAioEmoticonPanelCallbackProcessor;", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallbackWithShowPanel;", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "emoInfo", "", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "l", "Lcom/tencent/mobileqq/emosm/emosearch/EmotionSearchItem;", "g", "", "e", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "a", "d", "f", "Lcom/tencent/mobileqq/qroute/route/ActivityURIRequest;", "b", "", h.F, "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "emoPanel", "j", "delete", "info", "send", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "", "panelType", "showEmoticonPanel", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/guild/api/aio/panel/BaseEmoticonPanelProvider;", "Lcom/tencent/guild/api/aio/panel/BaseEmoticonPanelProvider;", "provider", "I", "getDefaultPanelType", "()I", "setDefaultPanelType", "(I)V", "defaultPanelType", "Lmqq/app/AppRuntime;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "c", "()Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "mainPanel", "<init>", "(Landroid/content/Context;Lcom/tencent/guild/api/aio/panel/BaseEmoticonPanelProvider;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAioEmoticonPanelCallbackProcessor implements EmoticonCallbackWithShowPanel {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BaseEmoticonPanelProvider provider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int defaultPanelType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy appRuntime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private IEmoticonMainPanel mainPanel;

    public GuildAioEmoticonPanelCallbackProcessor(@NotNull Context context, @NotNull BaseEmoticonPanelProvider provider) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.context = context;
        this.provider = provider;
        this.defaultPanelType = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AppRuntime>() { // from class: com.tencent.mobileqq.emosm.emocompat.impl.GuildAioEmoticonPanelCallbackProcessor$appRuntime$2
            @Override // kotlin.jvm.functions.Function0
            public final AppRuntime invoke() {
                return MobileQQ.sMobileQQ.peekAppRuntime();
            }
        });
        this.appRuntime = lazy;
    }

    private final SessionInfo a() {
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = 10014;
        sessionInfo.f179559f = this.provider.getPanelParam().b().r().c().f();
        sessionInfo.f179557e = this.provider.getPanelParam().b().r().c().j();
        return sessionInfo;
    }

    private final ActivityURIRequest b() {
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        ActivityURIRequest activityURIRequest = new ActivityURIRequest((Activity) context, RouterConstants.UI_ROUTE_EMOSM_ACTIVITY);
        activityURIRequest.extra().putInt(EmosmEmoticonConstant.EXTRA_LAUNCH_SOURCE, 1);
        activityURIRequest.extra().putInt("extra_launch_mode", 2);
        return activityURIRequest;
    }

    private final AppRuntime c() {
        return (AppRuntime) this.appRuntime.getValue();
    }

    private final String d() {
        return com.tencent.guild.aio.util.a.a(this.provider.getPanelParam());
    }

    private final String e(EmoticonInfo emoInfo) {
        String favEmoPath = ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).getFavEmoPath(emoInfo);
        Intrinsics.checkNotNullExpressionValue(favEmoPath, "api(IEmoticonBusinessPro\u2026a).getFavEmoPath(emoInfo)");
        return favEmoPath;
    }

    private final String f() {
        return com.tencent.guild.aio.util.a.f(this.provider.getPanelParam());
    }

    private final EmotionSearchItem g(EmoticonInfo emoInfo) {
        EmotionSearchItem searchItem = ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).getSearchItem(emoInfo);
        Intrinsics.checkNotNullExpressionValue(searchItem, "api(IEmoticonBusinessPro\u2026a).getSearchItem(emoInfo)");
        return searchItem;
    }

    private final void h() {
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        EmojiHomeUiPlugin.openEmojiHomePage((Activity) context, c().getAccount(), 6);
        ReportController.o(null, "CliOper", "", "", "MbGuanli", "MbDianjiTianjia", 0, 0, "", "", "", "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean i(EmoticonInfo emoInfo) {
        IPicEmoticonInfo iPicEmoticonInfo;
        if (k(emoInfo)) {
            GuildPicSenderApi.c(this.provider.getPanelParam().a(), e(emoInfo), f(), d(), 1, false);
            return true;
        }
        if (l(emoInfo)) {
            c.c(this.provider.getPanelParam().a(), g(emoInfo), f(), d());
            return true;
        }
        if (m(emoInfo)) {
            if (emoInfo instanceof IPicEmoticonInfo) {
                iPicEmoticonInfo = (IPicEmoticonInfo) emoInfo;
            } else {
                iPicEmoticonInfo = null;
            }
            if (iPicEmoticonInfo != null) {
                iPicEmoticonInfo.sendFromGuild(c(), this.context, a());
                return true;
            }
            return true;
        }
        return false;
    }

    private final boolean k(EmoticonInfo emoInfo) {
        return ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).isFavoriteEmoticonType(emoInfo);
    }

    private final boolean l(EmoticonInfo emoInfo) {
        return ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).isHotPicType(emoInfo);
    }

    private final boolean m(EmoticonInfo emoInfo) {
        return ((IEmoticonBusinessProxyApi) QRoute.api(IEmoticonBusinessProxyApi.class)).isMarketFaceEmoticonType(emoInfo);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void delete() {
        QLog.i("EmoticonPanelCallbackImpl", 4, "onDelete");
        EditText h16 = this.provider.h();
        if (h16 != null) {
            ((IEmoticonDelApi) QRoute.api(IEmoticonDelApi.class)).delete(h16);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void emoticonMall() {
        QLog.i("EmoticonPanelCallbackImpl", 4, "emoticonMall");
        h();
    }

    public final void j(@NotNull IEmoticonMainPanel emoPanel) {
        Intrinsics.checkNotNullParameter(emoPanel, "emoPanel");
        this.mainPanel = emoPanel;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onHidePopup(@Nullable EmoticonInfo info) {
        String str;
        if (info != null) {
            str = info.toString();
        } else {
            str = null;
        }
        QLog.i("EmoticonPanelCallbackImpl", 4, "onHidePopup info=" + str);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public boolean onLongClick(@Nullable EmoticonInfo info) {
        QLog.i("EmoticonPanelCallbackImpl", 4, NodeProps.ON_LONG_CLICK);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onShowPopup(@Nullable EmoticonInfo oldInfo, @Nullable EmoticonInfo newInfo, @Nullable Drawable d16) {
        boolean z16;
        IPicEmoticonInfo iPicEmoticonInfo;
        boolean z17 = false;
        if (newInfo != 0 && newInfo.type == 6) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (newInfo instanceof IPicEmoticonInfo) {
                iPicEmoticonInfo = (IPicEmoticonInfo) newInfo;
            } else {
                iPicEmoticonInfo = null;
            }
            if (iPicEmoticonInfo != null && iPicEmoticonInfo.isSound()) {
                z17 = true;
            }
            if (z17) {
                MediaPlayerManager.q(c()).D(true);
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send(@Nullable EmoticonInfo info) {
        QLog.i("EmoticonPanelCallbackImpl", 4, "onSend clz=" + (info != null ? info.getClass().getSimpleName() : null) + " info=" + (info != null ? info.toString() : null));
        if (info == null) {
            QLog.i("EmoticonPanelCallbackImpl", 4, "info==null");
            return;
        }
        EditText h16 = this.provider.h();
        if (h16 != null) {
            QLog.i("EmoticonPanelCallbackImpl", 4, "send real");
            if (i(info)) {
                return;
            }
            info.send(c(), this.context, h16, a());
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void setting() {
        QLog.i("EmoticonPanelCallbackImpl", 4, "setting");
        QRoute.startUri(b());
        ReportController.o(null, "CliOper", "", "", "MbGuanli", "MbDianjiGuanli", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallbackWithShowPanel
    public void showEmoticonPanel(int panelType) {
        QLog.i("EmoticonPanelCallbackImpl", 4, "showEmoticonPanel panelType=" + panelType);
        if (this.mainPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
        }
        IEmoticonMainPanel iEmoticonMainPanel = this.mainPanel;
        IEmoticonMainPanel iEmoticonMainPanel2 = null;
        if (iEmoticonMainPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
            iEmoticonMainPanel = null;
        }
        if (iEmoticonMainPanel.getView().getVisibility() == 0) {
            IEmoticonMainPanel iEmoticonMainPanel3 = this.mainPanel;
            if (iEmoticonMainPanel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
            } else {
                iEmoticonMainPanel2 = iEmoticonMainPanel3;
            }
            iEmoticonMainPanel2.initEmoticonView(panelType);
        } else {
            if (this.mainPanel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
            }
            IEmoticonMainPanel iEmoticonMainPanel4 = this.mainPanel;
            if (iEmoticonMainPanel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
                iEmoticonMainPanel4 = null;
            }
            iEmoticonMainPanel4.initEmoticonView(panelType);
            IEmoticonMainPanel iEmoticonMainPanel5 = this.mainPanel;
            if (iEmoticonMainPanel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainPanel");
            } else {
                iEmoticonMainPanel2 = iEmoticonMainPanel5;
            }
            iEmoticonMainPanel2.preloadWebProcess();
        }
        this.provider.getPanelParam().a().e().h(new PanelMsg.ShowPanel("EmoticonPanelCallbackImpl", 1001, false, 4, null));
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send() {
        QLog.i("EmoticonPanelCallbackImpl", 4, "onSend");
    }
}
