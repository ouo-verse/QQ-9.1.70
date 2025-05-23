package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0017J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/utils/QQSettingMeViewListConfigProccessor;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/utils/di;", "", "bytes", "d", "b", DownloadInfo.spKey_Config, "", "c", "", "success", "onCdnDownload", "<init>", "()V", "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QQSettingMeViewListConfigProccessor extends BaseConfigParser<QQSettingMeViewListBean> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Map<String, Integer> f307224e;

    static {
        Map<String, Integer> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("d_zplan", Integer.valueOf(R.drawable.qui_super_qq_show_vas)), TuplesKt.to("d_my_game", Integer.valueOf(R.drawable.qui_game)), TuplesKt.to("d_smallworld", Integer.valueOf(R.drawable.qui_small_world_vas)), TuplesKt.to("d_vip_identity", Integer.valueOf(R.drawable.qui_super_member_vas)), TuplesKt.to("d_qqwallet", Integer.valueOf(R.drawable.qui_wallet_vas)), TuplesKt.to("d_financial", Integer.valueOf(R.drawable.qui_littlebank_vas)), TuplesKt.to("d_decoration", Integer.valueOf(R.drawable.qui_skin_vas)), TuplesKt.to("d_intimate_space", Integer.valueOf(R.drawable.qui_intimates_space_vas)), TuplesKt.to("d_vip_card", Integer.valueOf(R.drawable.qui_free_cellular_data_vas)), TuplesKt.to("d_album", Integer.valueOf(R.drawable.qui_image_vas)), TuplesKt.to("d_favorite", Integer.valueOf(R.drawable.qui_collection_vas)), TuplesKt.to("d_document", Integer.valueOf(R.drawable.qui_floder_vas)), TuplesKt.to("d_video", Integer.valueOf(R.drawable.qui_video_on_vas)));
        f307224e = mapOf;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public QQSettingMeViewListBean defaultConfig() {
        return new QQSettingMeViewListBean();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable QQSettingMeViewListBean config) {
        super.doOnConfigUpdate(config);
        if (QLog.isColorLevel()) {
            QLog.i("QQSettingMeViewListConfigProccessor", 1, "[doOnConfigUpdate]: config is " + config);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @RequiresApi(24)
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public QQSettingMeViewListBean parse(@NotNull byte[] bytes) {
        ArrayList arrayList;
        Integer num;
        boolean z16;
        Object orDefault;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(bytes, UTF_8);
        if (TextUtils.isEmpty(str)) {
            QLog.i("QQSettingMeViewListConfigProccessor", 1, "[onParse]: content is null");
            return new QQSettingMeViewListBean();
        }
        QLog.i("QQSettingMeViewListConfigProccessor", 1, "[onParse]:--+ content is " + str + '}');
        JSONObject jSONObject = new JSONObject(str);
        boolean optBoolean = jSONObject.optBoolean("enableV3");
        int optInt = jSONObject.optInt("drawerUIForm");
        if (jSONObject.has("groups")) {
            JSONArray jSONArray = jSONObject.getJSONArray("groups");
            arrayList = new ArrayList();
            int length = jSONArray.length();
            int i3 = 0;
            while (i3 < length) {
                JSONArray jSONArray2 = new JSONArray(jSONArray.get(i3).toString());
                ArrayList arrayList2 = new ArrayList();
                int length2 = jSONArray2.length();
                int i16 = 0;
                while (i16 < length2) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i16);
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("title");
                    String optString = jSONObject3.optString("titleZh");
                    String optString2 = jSONObject3.optString("desc");
                    JSONObject jSONObject4 = jSONObject2.getJSONObject("action");
                    JSONArray jSONArray3 = jSONArray;
                    int i17 = length;
                    QQSettingMeBizBean qQSettingMeBizBean = new QQSettingMeBizBean(jSONObject2.optString("pluginID"), jSONObject2.optInt("order"), new QQSettingMeBizBean.b(optString, optString2), jSONObject2.optString("iconWebUrl"), jSONObject2.optString("iconDarkUrl"), new QQSettingMeBizBean.a(dk.a(jSONObject4.optString("actionType")), jSONObject4.optString("actionUrl")), jSONObject2.optString("redDotId"), jSONObject2.optString("dtElementId"), jSONObject2.optBoolean("enableNormal"), jSONObject2.optBoolean("enableConcise"), jSONObject2.optBoolean("enableStudy"), jSONObject2.optBoolean("enableGooglePlay"), jSONObject2.optBoolean("enableElderMode"));
                    qQSettingMeBizBean.L = Boolean.valueOf(jSONObject2.optBoolean("needIconColorFilter", false));
                    if (jSONObject2.optString("iconWebUrl").toString().length() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        Map<String, Integer> map = f307224e;
                        String n3 = qQSettingMeBizBean.n();
                        Intrinsics.checkNotNullExpressionValue(n3, "bean.pluginID");
                        orDefault = map.getOrDefault(n3, Integer.valueOf(R.drawable.qui_game));
                        qQSettingMeBizBean.f184985f = ((Number) orDefault).intValue();
                    }
                    arrayList2.add(qQSettingMeBizBean);
                    i16++;
                    jSONArray = jSONArray3;
                    length = i17;
                }
                JSONArray jSONArray4 = jSONArray;
                int i18 = length;
                if (!arrayList2.isEmpty()) {
                    arrayList.add(arrayList2);
                }
                i3++;
                jSONArray = jSONArray4;
                length = i18;
            }
        } else {
            arrayList = null;
        }
        QQSettingMeViewListBean qQSettingMeViewListBean = new QQSettingMeViewListBean();
        qQSettingMeViewListBean.e(arrayList);
        qQSettingMeViewListBean.d(Boolean.valueOf(optBoolean));
        qQSettingMeViewListBean.c(Integer.valueOf(optInt));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onParse]:--+ configBean is ");
        List<List<QQSettingMeBizBean>> b16 = qQSettingMeViewListBean.b();
        if (b16 != null) {
            num = Integer.valueOf(b16.size());
        } else {
            num = null;
        }
        sb5.append(num);
        QLog.i("QQSettingMeViewListConfigProccessor", 1, sb5.toString());
        return qQSettingMeViewListBean;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onCdnDownload(boolean success) {
        super.onCdnDownload(success);
        QLog.i("QQSettingMeViewListConfigProccessor", 1, "[onCdnDownload]: " + success);
        if (success) {
            dl.f307676a.d();
        }
    }
}
