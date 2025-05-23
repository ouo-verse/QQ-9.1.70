package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.search.searchdetail.content.SearchGroupFilterConditionLocal;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.panorama.util.PanoramaConfig;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\fJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0010J\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0004J\u0016\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0016J\u0016\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0018J\u0016\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006J\u0016\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0004J\u0016\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0016J\u0016\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0018J\u0016\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006R\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010!R\u001c\u0010&\u001a\n #*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/search/util/ah;", "", "", DomainData.DOMAIN_NAME, "", "j", "", "key", "a", "appId", "k", "i", "Lcom/tencent/mobileqq/search/searchdetail/content/SearchGroupFilterConditionLocal;", "f", "filter", "p", "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$Tabs;", "g", "tablist", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, RemoteHandleConst.PARAM_DEFAULT_VALUE, "b", "", "d", "", "e", tl.h.F, "value", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "r", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "entity", "kotlin.jvm.PlatformType", "c", "()Ljava/lang/String;", PanoramaConfig.KEY_CURRENT_UIN, "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ah {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ah f284994a = new ah();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MMKVOptionEntityV2 entity;

    static {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_SEARCH);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_SEARCH)");
        entity = fromV2;
    }

    ah() {
    }

    private final String a(String key) {
        return key + "_" + c();
    }

    private final String c() {
        return MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
    }

    @JvmStatic
    public static final boolean j() {
        return entity.decodeBool(f284994a.a("MMKV_KEY_SHOW_LBS_PERMISSION_DIALOG"), false);
    }

    @JvmStatic
    public static final void n() {
        entity.encodeBool(f284994a.a("MMKV_KEY_SHOW_LBS_PERMISSION_DIALOG"), true);
    }

    public final boolean b(@NotNull String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return entity.decodeBool(a(key), defaultValue);
    }

    public final int d(@NotNull String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return entity.decodeInt(a(key), defaultValue);
    }

    public final long e(@NotNull String key, long defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return entity.decodeLong(a(key), defaultValue);
    }

    @Nullable
    public final SearchGroupFilterConditionLocal f() {
        return (SearchGroupFilterConditionLocal) entity.getParcelable("SEARCH_GROUP_FILTER", SearchGroupFilterConditionLocal.class, null, false);
    }

    @Nullable
    public final SearchDetailTabListViewModel.Tabs g() {
        return (SearchDetailTabListViewModel.Tabs) entity.getParcelable("search_tab_list", SearchDetailTabListViewModel.Tabs.class, null, false);
    }

    @NotNull
    public final String h(@NotNull String key, @NotNull String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String decodeString = entity.decodeString(a(key), defaultValue);
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(finalKey, defaultValue)");
        return decodeString;
    }

    public final boolean i(@NotNull String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        try {
            JSONArray jSONArray = new JSONArray(h("search_open_app_list", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                if (Intrinsics.areEqual(jSONArray.optJSONObject(i3).optString("appid"), appId)) {
                    return true;
                }
            }
        } catch (Exception e16) {
            QLog.i("SearchMMKV", 1, "isContainOpenedAppId exception:" + e16);
        }
        return false;
    }

    public final void k(@NotNull String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        try {
            JSONArray jSONArray = new JSONArray(h("search_open_app_list", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                if (Intrinsics.areEqual(jSONArray.optJSONObject(i3).optString("appid"), appId)) {
                    return;
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", appId);
            jSONArray.mo162put(jSONObject);
            String jSONArray2 = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray2, "arr.toString()");
            r("search_open_app_list", jSONArray2);
        } catch (Exception e16) {
            QLog.i("SearchMMKV", 1, "saveOpenedAppId exception:" + e16);
        }
    }

    public final void l(@NotNull String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        String a16 = a(key);
        MMKVOptionEntityV2 mMKVOptionEntityV2 = entity;
        mMKVOptionEntityV2.encodeBool(a16, value);
        mMKVOptionEntityV2.commitAsync();
    }

    public final void m(@NotNull String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        String a16 = a(key);
        MMKVOptionEntityV2 mMKVOptionEntityV2 = entity;
        mMKVOptionEntityV2.encodeInt(a16, value);
        mMKVOptionEntityV2.commitAsync();
    }

    public final void o(@NotNull String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        String a16 = a(key);
        MMKVOptionEntityV2 mMKVOptionEntityV2 = entity;
        mMKVOptionEntityV2.encodeLong(a16, value);
        mMKVOptionEntityV2.commitAsync();
    }

    public final void p(@NotNull SearchGroupFilterConditionLocal filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        MMKVOptionEntityV2 mMKVOptionEntityV2 = entity;
        mMKVOptionEntityV2.putParcelable("SEARCH_GROUP_FILTER", filter);
        mMKVOptionEntityV2.commit(false);
    }

    public final void q(@NotNull SearchDetailTabListViewModel.Tabs tablist) {
        Intrinsics.checkNotNullParameter(tablist, "tablist");
        MMKVOptionEntityV2 mMKVOptionEntityV2 = entity;
        mMKVOptionEntityV2.putParcelable("search_tab_list", tablist);
        mMKVOptionEntityV2.commit(false);
    }

    public final void r(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        String a16 = a(key);
        MMKVOptionEntityV2 mMKVOptionEntityV2 = entity;
        mMKVOptionEntityV2.encodeString(a16, value);
        mMKVOptionEntityV2.commitAsync();
    }
}
