package lo2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.qzone.component.cache.database.table.photo.PhotoQualityInfo;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsLayoutContentCollections;
import ho2.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon$ResultItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class t extends m {

    /* renamed from: b0, reason: collision with root package name */
    private ho2.d f415275b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f415276c0;

    public t(String str, long j3, List<String> list, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem, int i3, boolean z16) {
        this(str, j3, list, unifySearchCommon$ResultItem, i3);
        this.f415276c0 = z16;
    }

    private ho2.e W(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("recallInfo");
        if (optJSONObject == null) {
            try {
                String optString = jSONObject.optString("recallInfo");
                if (!TextUtils.isEmpty(optString)) {
                    optJSONObject = new JSONObject(optString);
                }
            } catch (JSONException e16) {
                QLog.e("NetSearchTemplateGuildItem", 1, "convertToReCallInfo error!", e16);
            }
        }
        ho2.e eVar = new ho2.e();
        if (optJSONObject != null) {
            eVar.f405473a = optJSONObject.optString("query");
            eVar.f405474b = optJSONObject.optString("recall_name");
            eVar.f405475c = optJSONObject.optString("relevance_score");
            eVar.f405476d = optJSONObject.optString(PhotoQualityInfo.QUALITY_SCORE);
            eVar.f405477e = optJSONObject.optString(LocalPhotoFaceInfo.SCORE);
            eVar.f405478f = optJSONObject.optString("trace_id");
        }
        return eVar;
    }

    private List<ho2.a> Z(String str) {
        String str2;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String optString = jSONObject.optString("icon_url");
                String optString2 = jSONObject.optString("name");
                JSONObject optJSONObject = jSONObject.optJSONObject("official_medalInfo_ext");
                if (optJSONObject == null) {
                    str2 = "";
                    z16 = false;
                } else {
                    z16 = optJSONObject.optBoolean("is_offical");
                    str2 = optJSONObject.optString("icon_url");
                }
                arrayList.add(new ho2.a(optString, optString2, new a.C10457a(z16, str2)));
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.search.model.z
    public void F(int i3) {
        super.F(i3);
    }

    @Override // lo2.m
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            ho2.d dVar = new ho2.d(jSONObject.optInt("joined_guild"), jSONObject.optString("name"), jSONObject.optString("profile"), jSONObject.optString("cover_url"), jSONObject.optString("join_guild_sig"), jSONObject.optString("guild_id"), jSONObject.optString("head_url"));
            this.f415275b0 = dVar;
            dVar.f405464j = new ho2.c(jSONObject.optInt("guild_state"));
            this.f415275b0.f405462h = jSONObject.optInt("guild_friend_num");
            this.f415275b0.f405467m = jSONObject.optString("tag");
            this.f415275b0.f405468n = jSONObject.optString("tag_report_key");
            this.f415275b0.f405469o = jSONObject.optString("guild_number");
            this.f415275b0.f405470p = jSONObject.optInt("total_result_count");
            this.f415275b0.f405471q = W(jSONObject);
            this.f415275b0.f405472r = jSONObject.optInt("search_type", 0);
            this.f415275b0.f405466l = Z(jSONObject.optString("medals"));
            if (QLog.isColorLevel()) {
                QLog.d("NetSearchTemplateGuildItem", 1, "parseLayoutExtensions, content=" + jSONObject);
            }
            QLog.i("NetSearchTemplateGuildItem", 1, "parse entity: " + this.f415275b0);
        } catch (JSONException unused) {
            QLog.e("NetSearchTemplateGuildItem", 1, "parseLayoutExtensions, exception. " + str);
        }
    }

    public ho2.d X() {
        return this.f415275b0;
    }

    public boolean Y() {
        return this.f415276c0;
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        ho2.d dVar = this.f415275b0;
        if (dVar != null) {
            return dVar.f405456b;
        }
        return "";
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        ho2.d X = X();
        Bundle bundle = new Bundle();
        bundle.putString(JumpGuildParam.EXTRA_KEY_TRACE_ID, X.f405471q.f405478f);
        bundle.putString(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, X.f405471q.f405473a);
        bundle.putString("sgrp_stream_pgin_source", "20");
        bundle.putString("sgrp_stream_pgin_source_name", "functional_qq_search");
        bundle.putString(SearchGuildDaTongApiImpl.GUILD_SEARCH_TITLE_RECALL_QUERY, "1");
        bundle.putString("sgrp_search_source", "qq_search");
        if (X.f405455a == 1) {
            bundle.putString("sgrp_join_channel_state", "0");
        } else {
            bundle.putString("sgrp_join_channel_state", "1");
        }
        go2.d.a(true, X.f405460f, X.f405459e, bundle);
    }

    public t(String str, long j3, List<String> list, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem, int i3) {
        super(str, j3, list, unifySearchCommon$ResultItem, i3);
        this.f283549m = false;
    }
}
