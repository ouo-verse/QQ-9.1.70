package com.tencent.qqnt.search.impl;

import android.net.Uri;
import androidx.annotation.Keep;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qqnt.search.ISearchPageApi;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/search/impl/SearchPageApiImpl;", "Lcom/tencent/qqnt/search/ISearchPageApi;", "", "searchKey", "hint", "buildFromGuildDiscovery", "buildFromAio", "buildFromUnknown", "Landroid/net/Uri$Builder;", "kotlin.jvm.PlatformType", "buildBaseSearchUri", "Lcom/tencent/qqnt/search/ISearchPageApi$b;", "param", "", "openSearchPageApi", "<init>", "()V", "Companion", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class SearchPageApiImpl implements ISearchPageApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "SearchPageApiImpl";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/search/impl/SearchPageApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.search.impl.SearchPageApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56031);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SearchPageApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Uri.Builder buildBaseSearchUri(String searchKey, String hint) {
        return new Uri.Builder().scheme(SchemaUtils.SCHEMA_MQQAPI).authority("kuikly").path("open").appendQueryParameter(ISchemeApi.KEY_IOS_SRC_TYPE, "internal").appendQueryParameter("version", "1").appendQueryParameter("source", "1").appendQueryParameter("target", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE).appendQueryParameter(WadlProxyConsts.CHANNEL, "2").appendQueryParameter("page_name", "qsearch_detail").appendQueryParameter("keyword", searchKey).appendQueryParameter("hint", hint);
    }

    private final String buildFromAio(String searchKey, String hint) {
        String uri = buildBaseSearchUri(searchKey, hint).appendQueryParameter(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "19").appendQueryParameter("user_source", "10").build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "buildBaseSearchUri(searc\u2026)\n            .toString()");
        return uri;
    }

    private final String buildFromGuildDiscovery(String searchKey, String hint) {
        String uri = buildBaseSearchUri(searchKey, hint).appendQueryParameter("hide_tab", "1").appendQueryParameter("tab_mask", "3").appendQueryParameter(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "21").appendQueryParameter("user_source", "12").build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "buildBaseSearchUri(searc\u2026)\n            .toString()");
        return uri;
    }

    private final String buildFromUnknown(String searchKey, String hint) {
        String uri = buildBaseSearchUri(searchKey, hint).appendQueryParameter(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "12").appendQueryParameter("user_source", "0").build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "buildBaseSearchUri(searc\u2026)\n            .toString()");
        return uri;
    }

    @Override // com.tencent.qqnt.search.ISearchPageApi
    public void openSearchPageApi(@NotNull ISearchPageApi.b param) {
        String buildFromGuildDiscovery;
        BaseQQAppInterface baseQQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Logger logger = Logger.f235387a;
        logger.d().i(TAG, 1, "[startSearch] " + param);
        String c16 = param.c();
        String b16 = param.b();
        int a16 = param.a();
        if (a16 != 0) {
            if (a16 != 1) {
                buildFromGuildDiscovery = buildFromUnknown(c16, b16);
            } else {
                buildFromGuildDiscovery = buildFromAio(c16, b16);
            }
        } else {
            buildFromGuildDiscovery = buildFromGuildDiscovery(c16, b16);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        bi.c(baseQQAppInterface, peekAppRuntime.getApplicationContext(), buildFromGuildDiscovery).b();
        logger.d().i(TAG, 1, "jump to url: " + buildFromGuildDiscovery);
    }
}
