package com.tencent.mobileqq.persistence;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class CommonFunctionPublishConfigProcessor extends com.tencent.mobileqq.config.l<a> {

    /* loaded from: classes16.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f258281a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f258282b = true;

        /* renamed from: c, reason: collision with root package name */
        public boolean f258283c = true;

        /* renamed from: d, reason: collision with root package name */
        public boolean f258284d = true;

        /* renamed from: e, reason: collision with root package name */
        public boolean f258285e = true;

        /* renamed from: f, reason: collision with root package name */
        public boolean f258286f = false;

        /* renamed from: g, reason: collision with root package name */
        public boolean f258287g = false;

        /* renamed from: h, reason: collision with root package name */
        public boolean f258288h = true;

        /* renamed from: i, reason: collision with root package name */
        public boolean f258289i = true;

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            boolean z27;
            boolean z28;
            boolean z29;
            boolean z36;
            QLog.d("CommonFunctionPublishConfigProcessor", 1, "Config parse configText -> " + str);
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("is_localized", 0) == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.f258281a = z16;
                    if (jSONObject.optInt("is_wal", 1) == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    this.f258282b = z17;
                    if (jSONObject.optInt("is_new_unread_count", 1) == 1) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    this.f258283c = z18;
                    if (jSONObject.optInt("is_new_invalid_unread_mark_threshold", 1) == 1) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    this.f258284d = z19;
                    if (jSONObject.optInt("is_init_cache_parall", 1) == 1) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    this.f258285e = z26;
                    if (jSONObject.optInt("is_copy_db_command_enable", 0) == 1) {
                        z27 = true;
                    } else {
                        z27 = false;
                    }
                    this.f258286f = z27;
                    if (jSONObject.optInt("msg_refresh_delay", 0) == 1) {
                        z28 = true;
                    } else {
                        z28 = false;
                    }
                    this.f258287g = z28;
                    if (jSONObject.optInt("is_ignore_invalid_unread_mark", 1) == 1) {
                        z29 = true;
                    } else {
                        z29 = false;
                    }
                    this.f258288h = z29;
                    if (jSONObject.optInt("is_turing_risk_detect_enable_after_login", 1) == 1) {
                        z36 = true;
                    } else {
                        z36 = false;
                    }
                    this.f258289i = z36;
                } catch (JSONException e16) {
                    QLog.e("CommonFunctionPublishConfigProcessor", 1, e16, new Object[0]);
                }
            }
        }
    }

    public static a a() {
        a aVar = (a) am.s().x(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH);
        if (aVar != null) {
            SQLiteOpenHelper.WAL_ENABLE = aVar.f258282b;
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
    public a onParsed(ai[] aiVarArr) {
        ai aiVar;
        a aVar = new a();
        if (aiVarArr != null && aiVarArr.length > 0 && (aiVar = aiVarArr[0]) != null) {
            aVar.b(aiVar.f202268b);
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return false;
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
    public boolean isNeedUpgradeReset() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
