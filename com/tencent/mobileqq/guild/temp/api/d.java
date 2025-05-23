package com.tencent.mobileqq.guild.temp.api;

import android.util.Log;
import com.tencent.mobileqq.app.richtext.IRichTextAndMsgViaProvider;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d {
    public static Class a() {
        try {
            return ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getGuildAioNavigateBarManagerClass();
        } catch (Throwable th5) {
            Log.e("GuildManagerProvider", "[getGuildAioNavigateBarManagerClass]", th5);
            return null;
        }
    }

    public static Class<? extends IRichTextAndMsgViaProvider> b() {
        try {
            return ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getGuildMixMsgRichTextAndMsgViaProviderClass();
        } catch (Throwable th5) {
            Log.e("GuildManagerProvider", "[getGuildMixMsgRichTextAndMsgViaProviderClass]", th5);
            return null;
        }
    }

    public static Class c() {
        try {
            return ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getGuildNotificationProcessorClass();
        } catch (Throwable th5) {
            Log.e("GuildManagerProvider", "[getGuildNotificationProcessorClass]", th5);
            return null;
        }
    }

    public static Object d() {
        try {
            return ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildRoamMessageEventFlowProcessorCallback();
        } catch (Throwable th5) {
            Log.e("GuildManagerProvider", "[getNewGuildDispersionRoamMsgProcessorCallback]", th5);
            return null;
        }
    }

    public static Object e() {
        try {
            return ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildGuestMessageProcessorCallback();
        } catch (Throwable th5) {
            Log.e("GuildManagerProvider", "[getNewGuildGuestMessageProcessorCallback]", th5);
            return null;
        }
    }

    public static Object f() {
        try {
            return ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildMessageManagerCallback();
        } catch (Throwable th5) {
            Log.e("GuildManagerProvider", "[getNewGuildMessageManagerCallback]", th5);
            return null;
        }
    }

    public static Object g() {
        try {
            return ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildOfflineMessageProcessorCallback();
        } catch (Throwable th5) {
            Log.e("GuildManagerProvider", "[getNewGuildOfflineMessageProcessorCallback]", th5);
            return null;
        }
    }

    public static Object h() {
        try {
            return ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildPushMessageProcessorCallback();
        } catch (Throwable th5) {
            Log.e("GuildManagerProvider", "[getNewGuildPushMessageProcessorCallback]", th5);
            return null;
        }
    }

    public static Object i() {
        try {
            return ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildRoamMessageEventFlowProcessorCallback();
        } catch (Throwable th5) {
            Log.e("GuildManagerProvider", "[getNewGuildRoamMessageEventFlowProcessorCallback]", th5);
            return null;
        }
    }

    public static Object j() {
        try {
            return ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildRoamMessageProcessorCallback();
        } catch (Throwable th5) {
            Log.e("GuildManagerProvider", "[getNewGuildRoamMessageProcessorCallback]", th5);
            return null;
        }
    }

    public static Object k() {
        try {
            return ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildS2CMessageProcessorCallback();
        } catch (Throwable th5) {
            Log.e("GuildManagerProvider", "[getNewGuildSystemMessageProcessorCallback]", th5);
            return null;
        }
    }

    public static Object l() {
        try {
            return ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildSystemMessageProcessorCallback();
        } catch (Throwable th5) {
            Log.e("GuildManagerProvider", "[getNewGuildSystemMessageProcessorCallback]", th5);
            return null;
        }
    }
}
