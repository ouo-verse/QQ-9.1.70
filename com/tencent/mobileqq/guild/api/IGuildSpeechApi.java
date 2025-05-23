package com.tencent.mobileqq.guild.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildSpeechApi extends QRouteApi {
    public static final String KEY_AT_ALL_NUM = "key_at_all_num";
    public static final String KEY_AT_ONLINE_NUM = "key_at_online_num";
    public static final String KEY_AT_ROLE_NUM = "key_at_role_num";
    public static final String KEY_CHANNEL = "key_speech_channle_id";
    public static final String KEY_CONTENT = "key_content";
    public static final String KEY_GUILD = "key_speech_guild_id";
    public static final String KEY_NEED_INTERCEPT = "needIntercept";
    public static final String KEY_TYPE = "key_speech_type";

    boolean containLink(String str);

    boolean isNeedInterceptAds(String str, String str2);

    boolean isNeedInterceptHongbao(String str, String str2);

    boolean isNeedInterceptKeyword(@NonNull String str, @NonNull String str2, @NonNull CharSequence charSequence);

    boolean isNeedInterceptLink(String str, String str2);

    boolean isNeedInterceptOfAt(String str, int i3, int i16, int i17);

    boolean isNeedInterceptQrCode(String str, String str2);

    void preloadSpeakRule(String str, wh2.f fVar);

    void showInterceptAtSendToast();

    void showInterceptKeywordSendToast();

    void showInterceptLinkSendToast();

    void showInterceptQrCodeSendToast();

    void showInterceptRedEnvelopeSendToast();
}
