package gy;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.as;
import com.tencent.mobileqq.config.n;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements n<String> {

    /* renamed from: a, reason: collision with root package name */
    private String f403821a = "";

    /* renamed from: b, reason: collision with root package name */
    private String f403822b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f403823c = "";

    /* renamed from: d, reason: collision with root package name */
    private boolean f403824d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f403825e = false;

    private b a(b bVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("pacenter_url")) {
                this.f403821a = bVar.f403821a;
            }
            if (jSONObject.has("pacategory_url")) {
                this.f403822b = bVar.f403822b;
            }
            if (jSONObject.has("readinjoy_search_url")) {
                this.f403823c = bVar.f403823c;
            }
            if (jSONObject.has("image_collection_comment")) {
                this.f403824d = bVar.f403824d;
            }
            if (bVar.f403825e) {
                this.f403825e = true;
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PublicAccountCenterUrlConfProcessor", 2, "checkPublicAccountCenterUrlConfigData error", e16);
            }
            e16.printStackTrace();
        }
        return this;
    }

    public static b b() {
        b bVar = new b();
        bVar.f403821a = PublicAccountConfigUtilImpl.PUBLIC_ACCOUNT_CENTER_URL;
        bVar.f403822b = PublicAccountConfigUtilImpl.PUBLIC_ACCOUNT_CATEGORY_URL;
        bVar.f403823c = PublicAccountConfigUtilImpl.READINJOY_SEARCH_URL;
        bVar.f403824d = PublicAccountConfigUtilImpl.IMAGE_COLLECTION_COMMENT;
        return bVar;
    }

    public static b e(ai[] aiVarArr) {
        b bVar = new b();
        for (ai aiVar : aiVarArr) {
            String str = aiVar.f202268b;
            try {
                bVar = bVar.a((b) as.e(str, b.class), str);
            } catch (QStorageInstantiateException e16) {
                QLog.i("PublicAccountCenterUrlConfProcessor", 1, "loadConfig l :" + str, e16);
            }
        }
        return bVar;
    }

    public void c() {
        PublicAccountConfigUtilImpl.PUBLIC_ACCOUNT_CENTER_URL = this.f403821a;
        PublicAccountConfigUtilImpl.PUBLIC_ACCOUNT_CATEGORY_URL = this.f403822b;
        PublicAccountConfigUtilImpl.READINJOY_SEARCH_URL = this.f403823c;
        PublicAccountConfigUtilImpl.IMAGE_COLLECTION_COMMENT = this.f403824d;
    }

    @Override // com.tencent.mobileqq.config.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        boolean z16;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("pacenter_url");
            String string2 = jSONObject.getString("pacategory_url");
            boolean z17 = true;
            if (PublicAccountConfigUtilImpl.checkUrlFormat(string)) {
                this.f403821a = string;
                z16 = true;
            } else {
                z16 = false;
            }
            if (PublicAccountConfigUtilImpl.checkUrlFormat(string2)) {
                this.f403822b = string2;
                z16 = true;
            }
            if (jSONObject.has("readinjoy_search_url")) {
                String string3 = jSONObject.getString("readinjoy_search_url");
                if (PublicAccountConfigUtilImpl.checkUrlFormat(string3)) {
                    this.f403823c = string3;
                    z16 = true;
                }
            }
            if (jSONObject.has("image_collection_comment")) {
                this.f403824d = jSONObject.getBoolean("image_collection_comment");
            } else {
                z17 = z16;
            }
            this.f403825e = z17;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PublicAccountCenterUrlConfProcessor", 2, "checkPublicAccountCenterUrlConfigData error", e16);
            }
            e16.printStackTrace();
            this.f403825e = false;
        }
    }

    public void f() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).updatePublicAccountCenterUrlConfigData((QQAppInterface) runtime);
        }
    }
}
