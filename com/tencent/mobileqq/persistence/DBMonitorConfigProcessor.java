package com.tencent.mobileqq.persistence;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class DBMonitorConfigProcessor extends com.tencent.mobileqq.config.l<a> {

    /* loaded from: classes16.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f258290a = true;

        /* renamed from: b, reason: collision with root package name */
        public int f258291b = 20;

        /* renamed from: c, reason: collision with root package name */
        public int f258292c = 1000;

        /* renamed from: d, reason: collision with root package name */
        public int f258293d = 100000;

        /* renamed from: e, reason: collision with root package name */
        public boolean f258294e = true;

        /* renamed from: f, reason: collision with root package name */
        public int f258295f = 1000;

        /* renamed from: g, reason: collision with root package name */
        public boolean f258296g = true;

        /* renamed from: h, reason: collision with root package name */
        public int f258297h = 400000;

        /* renamed from: i, reason: collision with root package name */
        public int f258298i = ThemeConstants.ZIP_VERSION;

        /* renamed from: j, reason: collision with root package name */
        public int f258299j = 1000000;

        /* renamed from: k, reason: collision with root package name */
        public int f258300k = ThemeConstants.ZIP_VERSION;

        /* renamed from: l, reason: collision with root package name */
        public int f258301l = 1000000;

        /* renamed from: m, reason: collision with root package name */
        public int f258302m = 15000000;

        /* renamed from: n, reason: collision with root package name */
        public int f258303n = ThemeConstants.ZIP_VERSION;

        public void a(String str) {
            boolean z16;
            boolean z17;
            boolean z18 = false;
            QLog.d("DBMonitorConfigProcessor", 1, "Config parse configText -> ", str);
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("is_operate_cost_reported", 1) == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.f258290a = z16;
                    this.f258291b = jSONObject.optInt("operate_cost_reported_threshold", 20);
                    this.f258292c = jSONObject.optInt("operate_cost_reported_gray_sampling", 1000);
                    this.f258293d = jSONObject.optInt("operate_cost_reported_public_sampling", 100000);
                    if (jSONObject.optInt("is_db_size_reported", 1) == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    this.f258294e = z17;
                    this.f258295f = jSONObject.optInt("db_size_reported_sampling", 1000);
                    if (jSONObject.optInt("is_market_db_cost_reported", 1) == 1) {
                        z18 = true;
                    }
                    this.f258296g = z18;
                    this.f258297h = jSONObject.optInt("market_rawquery_cost_gray_sampling", 400000);
                    this.f258298i = jSONObject.optInt("market_replace_cost_gray_sampling", ThemeConstants.ZIP_VERSION);
                    this.f258299j = jSONObject.optInt("market_execsql_cost_gray_sampling", 1000000);
                    this.f258300k = jSONObject.optInt("market_query_cost_gray_sampling", ThemeConstants.ZIP_VERSION);
                    this.f258301l = jSONObject.optInt("market_insert_cost_gray_sampling", 1000000);
                    this.f258302m = jSONObject.optInt("market_delete_cost_gray_sampling", 15000000);
                    this.f258303n = jSONObject.optInt("market_update_cost_gray_sampling", ThemeConstants.ZIP_VERSION);
                } catch (JSONException e16) {
                    QLog.e("DBMonitorConfigProcessor", 1, "parse DBMonitorConfig error: ", e16);
                }
            }
        }
    }

    public static a a() {
        a aVar = (a) am.s().x(BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO);
        if (aVar != null) {
            return aVar;
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) throws QStorageInstantiateException {
        ai aiVar;
        a aVar = new a();
        if (aiVarArr != null && aiVarArr.length > 0 && (aiVar = aiVarArr[0]) != null) {
            aVar.a(aiVar.f202268b);
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
