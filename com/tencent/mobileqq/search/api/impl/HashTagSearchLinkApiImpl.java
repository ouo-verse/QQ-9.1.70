package com.tencent.mobileqq.search.api.impl;

import android.content.Context;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.search.api.IHashTagSearchLinkApi;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.m;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.studymode.api.IStudyModeApi;
import com.tencent.robot.api.IRobotIdentityApi;
import com.tencent.util.QQToastUtil;
import java.util.regex.Pattern;
import kn2.HashTagSearchLinkUniteConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\b*\u0001\u0018\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/search/api/impl/HashTagSearchLinkApiImpl;", "Lcom/tencent/mobileqq/search/api/IHashTagSearchLinkApi;", "", "uin", "", "chatType", "", "switchOn", "Lkn2/a;", "uniteConfig", "Landroid/content/Context;", "context", "", "keywords", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "userSource", "", "routeSearchLinkPage", "", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "Lcom/tencent/mobileqq/text/m;", "grabHashTagLinkParams", "Ljava/util/regex/Pattern;", "hashtagLinkPattern", "com/tencent/mobileqq/search/api/impl/HashTagSearchLinkApiImpl$b", "configSupplier", "Lcom/tencent/mobileqq/search/api/impl/HashTagSearchLinkApiImpl$b;", "<init>", "()V", "Companion", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class HashTagSearchLinkApiImpl implements IHashTagSearchLinkApi {
    private static final char EMOJI_HEAD = 20;

    @NotNull
    private static final String HASHTAG_LINK_ILLEGAL_CHAR = "@\uff20\u3002\uff0c.,#\uff03*\uff0a\\[\\]\\s\u0014";
    private static final Pattern HASHTAG_LINK_PATTERN;

    @NotNull
    private static final String HASHTAG_LINK_REGEX;

    @NotNull
    private static final String TAG = "HashTagSearchLinkConfig";

    @NotNull
    private final b configSupplier = new b();

    static {
        String str = "(?<!\u0014)[" + IHashTagSearchLinkApi.GOOD_HASHTAG_CHAR + "][^@\uff20\u3002\uff0c.,#\uff03*\uff0a\\[\\]\\s\u0014]+";
        HASHTAG_LINK_REGEX = str;
        HASHTAG_LINK_PATTERN = Pattern.compile(str);
    }

    @Override // com.tencent.mobileqq.search.api.IHashTagSearchLinkApi
    @NotNull
    public m grabHashTagLinkParams(@Nullable Object any) {
        if (any instanceof m) {
            return (m) any;
        }
        if (any instanceof MsgRecord) {
            MsgRecord msgRecord = (MsgRecord) any;
            return m.INSTANCE.a(msgRecord.peerUin, msgRecord.chatType);
        }
        return m.f292688e;
    }

    @Override // com.tencent.mobileqq.search.api.IHashTagSearchLinkApi
    @NotNull
    public Pattern hashtagLinkPattern() {
        Pattern HASHTAG_LINK_PATTERN2 = HASHTAG_LINK_PATTERN;
        Intrinsics.checkNotNullExpressionValue(HASHTAG_LINK_PATTERN2, "HASHTAG_LINK_PATTERN");
        return HASHTAG_LINK_PATTERN2;
    }

    @Override // com.tencent.mobileqq.search.api.IHashTagSearchLinkApi
    public void routeSearchLinkPage(@NotNull Context context, @NotNull String keywords, int querySource, int userSource) {
        String drop;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        if (!((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isBanSearchNetInStudyMode()) {
            drop = StringsKt___StringsKt.drop(keywords, 1);
            SearchUtils.P0(null, context, drop, querySource, userSource);
        } else {
            QQToastUtil.showQQToast(0, R.string.f214315sk);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
    
        if (r6 == false) goto L24;
     */
    @Override // com.tencent.mobileqq.search.api.IHashTagSearchLinkApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean switchOn(long uin, int chatType) {
        boolean z16;
        IGProChannelInfo channelInfo;
        if (!uniteConfig().getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH java.lang.String()) {
            return false;
        }
        if ((chatType != 1 || ((IRobotIdentityApi) QRoute.api(IRobotIdentityApi.class)).isRobotUin(Long.valueOf(uin))) && (chatType != 2 || ((IRobotIdentityApi) QRoute.api(IRobotIdentityApi.class)).isRobotUin(Long.valueOf(uin)))) {
            if (chatType == 4) {
                IGPSService d16 = at.d();
                if (d16 != null && (channelInfo = d16.getChannelInfo(String.valueOf(uin))) != null && channelInfo.getType() == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            if (chatType != 100) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.search.api.IHashTagSearchLinkApi
    @NotNull
    public HashTagSearchLinkUniteConfig uniteConfig() {
        return this.configSupplier.getConfig();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\b\n*\u0003\u0000\u0004\n\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/search/api/impl/HashTagSearchLinkApiImpl$b", "", "Lkn2/a;", "d", "com/tencent/mobileqq/search/api/impl/HashTagSearchLinkApiImpl$b$b", "a", "Lcom/tencent/mobileqq/search/api/impl/HashTagSearchLinkApiImpl$b$b;", "b", "()Lcom/tencent/mobileqq/search/api/impl/HashTagSearchLinkApiImpl$b$b;", "CONFIG_KEYS", "com/tencent/mobileqq/search/api/impl/HashTagSearchLinkApiImpl$b$c", "Lcom/tencent/mobileqq/search/api/impl/HashTagSearchLinkApiImpl$b$c;", "rawUniteConfig", "c", "Lkn2/a;", "()Lkn2/a;", "e", "(Lkn2/a;)V", DownloadInfo.spKey_Config, "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final C8527b CONFIG_KEYS = new C8527b();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final c rawUniteConfig = new c();

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private volatile HashTagSearchLinkUniteConfig config = d();

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0006*\u0002\u0000\u0004\b\n\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0086\u0002R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/search/api/impl/HashTagSearchLinkApiImpl$b$b", "", "", "b", "com/tencent/mobileqq/search/api/impl/HashTagSearchLinkApiImpl$b$b$a", "a", "Lcom/tencent/mobileqq/search/api/impl/HashTagSearchLinkApiImpl$b$b$a;", "()Lcom/tencent/mobileqq/search/api/impl/HashTagSearchLinkApiImpl$b$b$a;", "ANDROID_SPECIFIC_KEY", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.search.api.impl.HashTagSearchLinkApiImpl$b$b, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public static final class C8527b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final a ANDROID_SPECIFIC_KEY = new a();

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0086\u0002R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/search/api/impl/HashTagSearchLinkApiImpl$b$b$a", "", "", "c", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "INPUT_SPAN_UPDATE_LEVEL_KEY", "b", "MTK_ENABLE", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.tencent.mobileqq.search.api.impl.HashTagSearchLinkApiImpl$b$b$a */
            /* loaded from: classes18.dex */
            public static final class a {

                /* renamed from: a, reason: collision with root package name and from kotlin metadata */
                @NotNull
                private final String INPUT_SPAN_UPDATE_LEVEL_KEY = "input_update_level";

                /* renamed from: b, reason: collision with root package name and from kotlin metadata */
                @NotNull
                private final String MTK_ENABLE = "mtk_enable";

                a() {
                }

                @NotNull
                /* renamed from: a, reason: from getter */
                public final String getINPUT_SPAN_UPDATE_LEVEL_KEY() {
                    return this.INPUT_SPAN_UPDATE_LEVEL_KEY;
                }

                @NotNull
                /* renamed from: b, reason: from getter */
                public final String getMTK_ENABLE() {
                    return this.MTK_ENABLE;
                }

                @NotNull
                public final String c() {
                    return "android_specific";
                }
            }

            C8527b() {
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final a getANDROID_SPECIFIC_KEY() {
                return this.ANDROID_SPECIFIC_KEY;
            }

            @NotNull
            public final String b() {
                return "grab_hash_tag_link_enable";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/search/api/impl/HashTagSearchLinkApiImpl$b$c", "", "", "c", "Lorg/json/JSONObject;", "b", "a", "Lcom/tencent/mobileqq/unitedconfig_android/api/IUnitedConfigManager;", "Lcom/tencent/mobileqq/unitedconfig_android/api/IUnitedConfigManager;", DTConstants.TAG.API, "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes18.dex */
        public static final class c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final IUnitedConfigManager api;

            c() {
                QRouteApi api = QRoute.api(IUnitedConfigManager.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
                this.api = (IUnitedConfigManager) api;
            }

            @NotNull
            public final JSONObject a() {
                Object m476constructorimpl;
                b bVar = b.this;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(b().getJSONObject(bVar.getCONFIG_KEYS().getANDROID_SPECIFIC_KEY().c()));
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m482isFailureimpl(m476constructorimpl)) {
                    m476constructorimpl = null;
                }
                JSONObject jSONObject = (JSONObject) m476constructorimpl;
                if (jSONObject == null) {
                    return new JSONObject();
                }
                return jSONObject;
            }

            @NotNull
            public final JSONObject b() {
                Object m476constructorimpl;
                b bVar = b.this;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(new JSONObject(this.api.loadAsString(bVar.getCONFIG_KEYS().b(), "{}")));
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m482isFailureimpl(m476constructorimpl)) {
                    m476constructorimpl = null;
                }
                JSONObject jSONObject = (JSONObject) m476constructorimpl;
                if (jSONObject == null) {
                    return new JSONObject();
                }
                return jSONObject;
            }

            public final boolean c() {
                boolean isSwitchOn = this.api.isSwitchOn(b.this.getCONFIG_KEYS().b(), HashTagSearchLinkUniteConfig.INSTANCE.a().getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH java.lang.String());
                if (QQText.IS_FXXKED_MTK) {
                    if (isSwitchOn && b().optBoolean(b.this.getCONFIG_KEYS().getANDROID_SPECIFIC_KEY().getMTK_ENABLE(), true)) {
                        return true;
                    }
                    return false;
                }
                return isSwitchOn;
            }
        }

        b() {
            MobileQQ.sMobileQQ.registerAccountCallback(new a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final HashTagSearchLinkUniteConfig d() {
            HashTagSearchLinkUniteConfig hashTagSearchLinkUniteConfig = new HashTagSearchLinkUniteConfig(this.rawUniteConfig.c(), this.rawUniteConfig.a().optInt(this.CONFIG_KEYS.getANDROID_SPECIFIC_KEY().getINPUT_SPAN_UPDATE_LEVEL_KEY(), HashTagSearchLinkUniteConfig.INSTANCE.a().getInputSpanUpdateLevel()));
            QLog.i(HashTagSearchLinkApiImpl.TAG, 1, "getConfigSync " + hashTagSearchLinkUniteConfig);
            return hashTagSearchLinkUniteConfig;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final C8527b getCONFIG_KEYS() {
            return this.CONFIG_KEYS;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final HashTagSearchLinkUniteConfig getConfig() {
            return this.config;
        }

        public final void e(@NotNull HashTagSearchLinkUniteConfig hashTagSearchLinkUniteConfig) {
            Intrinsics.checkNotNullParameter(hashTagSearchLinkUniteConfig, "<set-?>");
            this.config = hashTagSearchLinkUniteConfig;
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/search/api/impl/HashTagSearchLinkApiImpl$b$a", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes18.dex */
        public static final class a implements IAccountCallback {
            a() {
            }

            @Override // mqq.app.IAccountCallback
            public void onAccountChanged(@Nullable AppRuntime newRuntime) {
                b bVar = b.this;
                bVar.e(bVar.d());
            }

            @Override // mqq.app.IAccountCallback
            public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
            }

            @Override // mqq.app.IAccountCallback
            public void onLogout(@Nullable Constants.LogoutReason reason) {
            }
        }
    }
}
