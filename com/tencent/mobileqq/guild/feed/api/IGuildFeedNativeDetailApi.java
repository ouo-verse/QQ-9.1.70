package com.tencent.mobileqq.guild.feed.api;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\nH&J2\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010\u0014\u001a\u00020\n2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u0017\u001a\u00020\u0003H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J,\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH&JD\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010#\u001a\u00020\u0003H&\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedNativeDetailApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkCanPreload", "", "recommendFeed", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "stFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "checkNeedWebView", "feedId", "", "needWebView", "functionList", "", "", "loggable", "createGestureTextView", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "functionListToStr", "list", "hasThirdVideo", "isLongFeedNativeSwitchOpen", "needOpenNativeDetailPage", "openFeedNativeDetailPage", "", "feedData", "initBean", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "intent", "Landroid/content/Intent;", "guildId", "channelId", "businessType", "needActivityAnim", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes13.dex */
public interface IGuildFeedNativeDetailApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static /* synthetic */ boolean a(IGuildFeedNativeDetailApi iGuildFeedNativeDetailApi, String str, boolean z16, List list, boolean z17, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    z17 = true;
                }
                return iGuildFeedNativeDetailApi.checkNeedWebView(str, z16, list, z17);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkNeedWebView");
        }

        public static /* synthetic */ void b(IGuildFeedNativeDetailApi iGuildFeedNativeDetailApi, Context context, String str, String str2, String str3, int i3, Intent intent, boolean z16, int i16, Object obj) {
            Intent intent2;
            boolean z17;
            if (obj == null) {
                if ((i16 & 32) != 0) {
                    intent2 = new Intent();
                } else {
                    intent2 = intent;
                }
                if ((i16 & 64) != 0) {
                    z17 = true;
                } else {
                    z17 = z16;
                }
                iGuildFeedNativeDetailApi.openFeedNativeDetailPage(context, str, str2, str3, i3, intent2, z17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openFeedNativeDetailPage");
        }
    }

    boolean checkCanPreload(@NotNull IGProContentRecommendFeed recommendFeed);

    boolean checkCanPreload(@NotNull GProStFeed stFeed);

    boolean checkNeedWebView(@NotNull String feedId, boolean needWebView, @Nullable String functionList);

    boolean checkNeedWebView(@NotNull String feedId, boolean needWebView, @Nullable List<Integer> functionList, boolean loggable);

    @NotNull
    TextView createGestureTextView(@NotNull Context context);

    @NotNull
    String functionListToStr(@Nullable List<Integer> list);

    boolean hasThirdVideo(@NotNull GProStFeed stFeed);

    boolean isLongFeedNativeSwitchOpen();

    boolean needOpenNativeDetailPage(@NotNull IGProContentRecommendFeed recommendFeed);

    boolean needOpenNativeDetailPage(@NotNull GProStFeed stFeed);

    void openFeedNativeDetailPage(@NotNull Context context, @NotNull GProStFeed feedData, @Nullable GuildFeedBaseInitBean initBean, @NotNull Intent intent);

    void openFeedNativeDetailPage(@NotNull Context context, @NotNull String guildId, @NotNull String channelId, @NotNull String feedId, int businessType, @NotNull Intent intent, boolean needActivityAnim);
}
