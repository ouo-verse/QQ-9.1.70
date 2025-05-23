package lf2;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.ecommerce.biz.guild.api.IECGuildApi;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.guild.api.IGuildUIApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J;\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\u0017"}, d2 = {"Llf2/b;", "Lcom/tencent/ecommerce/biz/guild/api/IECGuildApi;", "", "url", "Landroid/graphics/drawable/Drawable;", "getMixBackgroundDrawable", "Landroid/content/Context;", "context", "param", "", "openChannelPage", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "code", "callback", "joinChannel", "openSubChannelPage", "openArticlePage", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements IECGuildApi {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(0);
    }

    @Override // com.tencent.ecommerce.biz.guild.api.IECGuildApi
    public Drawable getMixBackgroundDrawable(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Drawable mixBackgroundDrawable = ((IGuildUIApi) QRoute.api(IGuildUIApi.class)).getMixBackgroundDrawable(url);
        Intrinsics.checkNotNullExpressionValue(mixBackgroundDrawable, "api(IGuildUIApi::class.j\u2026ixBackgroundDrawable(url)");
        return mixBackgroundDrawable;
    }

    @Override // com.tencent.ecommerce.biz.guild.api.IECGuildApi
    public void joinChannel(Context context, String param, final Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            JSONObject jSONObject = new JSONObject(param);
            String optString = jSONObject.optString("guildId");
            String optString2 = jSONObject.optString("joinGuildSig");
            String optString3 = jSONObject.optString("mainSource");
            String optString4 = jSONObject.optString("subSource");
            QLog.d("ECGuildApi", 1, "#joinChannel guildId=" + optString + ", mainSource=" + optString3 + ", subSource=" + optString4);
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).addGuildByParam(context, new JumpGuildParam(optString, "", optString2, optString3, optString4), "ECGuildApi", new Runnable() { // from class: lf2.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.b(Function1.this);
                }
            });
        } catch (JSONException e16) {
            QLog.w("ECGuildApi", 1, e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.ecommerce.biz.guild.api.IECGuildApi
    public void openArticlePage(Context context, String param) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        try {
            String optString = new JSONObject(param).optString("url");
            QLog.d("ECGuildApi", 1, "#openArticlePage: url=" + optString);
            Intent intent = new Intent(context, (Class<?>) QQBrowserDelegationActivity.class);
            intent.putExtra("url", optString);
            WebAccelerator.s(context, intent, optString);
        } catch (JSONException e16) {
            QLog.w("ECGuildApi", 1, e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.ecommerce.biz.guild.api.IECGuildApi
    public void openChannelPage(Context context, String param) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        try {
            JSONObject jSONObject = new JSONObject(param);
            String optString = jSONObject.optString("guildId");
            String optString2 = jSONObject.optString("joinGuildSig");
            String optString3 = jSONObject.optString("traceId");
            String optString4 = jSONObject.optString("mainSource");
            String optString5 = jSONObject.optString("subSource");
            String optString6 = jSONObject.optString("sgrp_stream_pgin_source_name", "functional_qq_search");
            QLog.d("ECGuildApi", 1, "#openChannelPage guildId=" + optString + ", traceId=" + optString3 + ", mainSource=" + optString4 + ", subSource=" + optString5);
            Bundle bundle = new Bundle();
            bundle.putString(JumpGuildParam.EXTRA_KEY_TRACE_ID, optString3);
            bundle.putString(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, jSONObject.optString("query"));
            bundle.putString("sgrp_stream_pgin_source", "20");
            bundle.putString(SearchGuildDaTongApiImpl.GUILD_SEARCH_TITLE_RECALL_QUERY, "1");
            bundle.putString("sgrp_search_source", "qq_search");
            if (jSONObject.optInt("joinedGuild") == 0) {
                bundle.putString("sgrp_join_channel_state", "0");
            } else {
                bundle.putString("sgrp_join_channel_state", "1");
            }
            bundle.putString("PGIN_SOURCE_REPORT_KEY", optString6);
            JumpGuildParam jumpGuildParam = new JumpGuildParam(optString, "");
            jumpGuildParam.setJoinInfoParam(new JumpGuildParam.JoinInfoParam(optString2, optString4, optString5));
            jumpGuildParam.extras = bundle;
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpGuildOnFullStandalone(context, jumpGuildParam);
        } catch (JSONException e16) {
            QLog.w("ECGuildApi", 1, e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.ecommerce.biz.guild.api.IECGuildApi
    public void openSubChannelPage(Context context, String param) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        try {
            JSONObject jSONObject = new JSONObject(param);
            String optString = jSONObject.optString("guildId");
            String optString2 = jSONObject.optString("channelId");
            String optString3 = jSONObject.optString("traceId");
            String optString4 = jSONObject.optString("mainSource");
            String optString5 = jSONObject.optString("subSource");
            QLog.d("ECGuildApi", 1, "#openSubChannelPage guildId=" + optString + ", channelId=" + optString2 + ", traceId=" + optString3 + ", mainSource=" + optString4 + ", subSource=" + optString5);
            JumpGuildParam jumpGuildParam = new JumpGuildParam(optString, optString2);
            jumpGuildParam.setJoinInfoParam(new JumpGuildParam.JoinInfoParam("", optString4, optString5));
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpGuildOnFullStandalone(context, jumpGuildParam);
        } catch (JSONException e16) {
            QLog.w("ECGuildApi", 1, e16.getMessage(), e16);
        }
    }
}
