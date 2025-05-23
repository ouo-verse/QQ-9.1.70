package com.tencent.qqnt.aio.markdown.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.jump.model.GuildShareUrlParam;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\u0018\u0000 &2\u00020\u00012\u00020\u00022\u00020\u0002:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J#\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0096\u0001J\u0019\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001J\u0015\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\u001d\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0013H\u0096\u0001J+\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\t2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013H\u0096\u0001J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\tH\u0016J \u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J.\u0010#\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\t2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H\u0016\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/aio/markdown/api/impl/MarkdownFeatureCompatApiImpl;", "Lcom/tencent/qqnt/aio/markdown/api/IMarkdownFeatureCompatApi;", "", "Landroid/content/Context;", "context", "btnModel", "", "supportVas", "getInlineButtonStyleSheet", "", "markdownText", "", "parse", "", "limit", "parseExcludeExtData", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstractElement;", "elem", "tryParse", "", "elemList", "uid", "tryParseForChats", "url", "", "startUrl", "styleSheet", "isVasTheme", "applyMarkdownStyle", "shouldUseSimpleBreakStrategy", "scene", "", Node.ATTRS_ATTR, "", "duration", "reportTimeCost", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class MarkdownFeatureCompatApiImpl implements IMarkdownFeatureCompatApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "MarkdownFeatureCompatApiImpl";
    private final /* synthetic */ a $$delegate_0;
    private final /* synthetic */ MarkdownParseUtilsImpl $$delegate_1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/markdown/api/impl/MarkdownFeatureCompatApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.markdown.api.impl.MarkdownFeatureCompatApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63657);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MarkdownFeatureCompatApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.$$delegate_0 = new a();
            this.$$delegate_1 = new MarkdownParseUtilsImpl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startUrl$lambda$0(String url, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(url, "$url");
        QLog.i(TAG, 1, "openMini: " + url + ", isOk=" + z16);
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    public void applyMarkdownStyle(@NotNull Context context, @NotNull Object styleSheet, boolean isVasTheme) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, context, styleSheet, Boolean.valueOf(isVasTheme));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(styleSheet, "styleSheet");
        fq0.a.f400309a.c(context, styleSheet, isVasTheme);
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    @Nullable
    public Object getInlineButtonStyleSheet(@NotNull Context context, @NotNull Object btnModel, boolean supportVas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, context, btnModel, Boolean.valueOf(supportVas));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
        return this.$$delegate_0.a(context, btnModel, supportVas);
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    @NotNull
    public CharSequence parse(@NotNull String markdownText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this, (Object) markdownText);
        }
        Intrinsics.checkNotNullParameter(markdownText, "markdownText");
        return this.$$delegate_1.c(markdownText);
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    @NotNull
    public CharSequence parseExcludeExtData(@NotNull String markdownText, int limit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this, (Object) markdownText, limit);
        }
        Intrinsics.checkNotNullParameter(markdownText, "markdownText");
        return this.$$delegate_1.d(markdownText, limit);
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    public void reportTimeCost(@NotNull String scene, @Nullable Map<String, String> attrs, double duration) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, scene, attrs, Double.valueOf(duration));
            return;
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        GuildHistogramScene a16 = GuildHistogramScene.INSTANCE.a(scene);
        if (a16 != null) {
            ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportMetricTimeCost(a16, attrs, duration);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e(TAG, 1, "unknown scence " + scene);
        }
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    public boolean shouldUseSimpleBreakStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return fq0.a.f400309a.w();
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    public void startUrl(@NotNull Context context, @NotNull final String url) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e(TAG, 1, "url is empty");
        }
        QRouteApi api = QRoute.api(IMiniAppService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMiniAppService::class.java)");
        IMiniAppService iMiniAppService = (IMiniAppService) api;
        if (iMiniAppService.isMiniAppUrl(url)) {
            iMiniAppService.startMiniApp(context, url, 5006, new MiniAppLaunchListener() { // from class: com.tencent.qqnt.aio.markdown.api.impl.b
                @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
                public final void onLaunchResult(boolean z17, Bundle bundle) {
                    MarkdownFeatureCompatApiImpl.startUrl$lambda$0(url, z17, bundle);
                }
            });
            return;
        }
        if (((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isGuildShareUrl(url)) {
            IGuildMainFrameApi iGuildMainFrameApi = (IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class);
            GuildShareUrlParam guildShareUrlParam = new GuildShareUrlParam(url);
            Bundle bundle = new Bundle();
            bundle.putBoolean("open_channel_on_standalone_page", true);
            guildShareUrlParam.b(bundle);
            Unit unit = Unit.INSTANCE;
            iGuildMainFrameApi.gotoGuild(context, guildShareUrlParam);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    @Nullable
    public String tryParse(@Nullable MsgAbstractElement elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.$$delegate_1.e(elem) : (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) elem);
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    @Nullable
    public String tryParseForChats(@NotNull Context context, @NotNull String uid, @Nullable List<MsgAbstractElement> elemList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, this, context, uid, elemList);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        return this.$$delegate_1.g(context, uid, elemList);
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    @Nullable
    public String tryParse(@Nullable List<MsgAbstractElement> elemList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.$$delegate_1.f(elemList) : (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) elemList);
    }
}
