package k10;

import NS_KING_SOCIALIZE_META.stShareInfo;
import NS_KING_SOCIALIZE_META.stSqArk;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.util.QQCustomArkDialogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lk10/c;", "", "LUserGrowth/stSimpleMetaFeed;", "feed", "", "contentType", "Landroid/os/Bundle;", "a", "(LUserGrowth/stSimpleMetaFeed;Ljava/lang/Integer;)Landroid/os/Bundle;", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f411392a = new c();

    c() {
    }

    public final Bundle a(stSimpleMetaFeed feed, Integer contentType) {
        JSONObject jSONObject;
        String str;
        stShareInfo stshareinfo;
        stSqArk stsqark;
        String str2 = (feed == null || (stshareinfo = feed.share_info) == null || (stsqark = stshareinfo.sq_ark_info) == null) ? null : stsqark.arkData;
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str2);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("app");
        String optString2 = jSONObject.optString("view");
        String optString3 = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
        JSONObject optJSONObject = jSONObject.optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
        String str3 = "";
        if (optJSONObject == null || (str = optJSONObject.toString()) == null) {
            str = "";
        }
        Bundle bundle = new Bundle();
        bundle.putString("forward_ark_app_name", optString);
        bundle.putString("forward_ark_app_view", optString2);
        bundle.putString("forward_ark_biz_src", optString3);
        bundle.putString("forward_ark_app_meta", str);
        bundle.putString("appName", optString);
        bundle.putString(QQCustomArkDialogUtil.APP_VIEW, optString2);
        bundle.putString(QQCustomArkDialogUtil.BIZ_SRC, optString3);
        bundle.putString(QQCustomArkDialogUtil.META_DATA, str);
        bundle.putFloat("scale", ViewUtils.getDensity());
        bundle.putInt("shareContentType", contentType != null ? contentType.intValue() : 2);
        String str4 = feed.f25129id;
        if (str4 == null) {
            str4 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str4, "feed.id ?: \"\"");
        }
        bundle.putString("shareFeedId", str4);
        stSimpleMetaPerson stsimplemetaperson = feed.poster;
        String str5 = stsimplemetaperson != null ? stsimplemetaperson.f25130id : null;
        if (str5 != null) {
            Intrinsics.checkNotNullExpressionValue(str5, "feed.poster?.id ?: \"\"");
            str3 = str5;
        }
        bundle.putString("sharePid", str3);
        return bundle;
    }
}
