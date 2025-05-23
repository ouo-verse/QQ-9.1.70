package nk;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0016J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rR(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010*\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R$\u0010.\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010!\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u0019\u001a\u0004\b0\u0010\u001b\"\u0004\b1\u0010\u001d\u00a8\u00067"}, d2 = {"Lnk/i;", "Lcom/qzone/reborn/base/n;", "", "menuSettingStr", "", "W1", "coverSettingStr", "U1", "checkInSettingStr", "T1", "authUrl", "X1", "getLogTag", "", "intimateType", "S1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "Q1", "()Landroidx/lifecycle/MutableLiveData;", "setResourceData", "(Landroidx/lifecycle/MutableLiveData;)V", "resourceData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "R1", "()Ljava/lang/String;", "setStyleResourcesString", "(Ljava/lang/String;)V", "styleResourcesString", "Lorg/json/JSONObject;", BdhLogUtil.LogTag.Tag_Conn, "Lorg/json/JSONObject;", "O1", "()Lorg/json/JSONObject;", "setMenuSetting", "(Lorg/json/JSONObject;)V", "menuSetting", "D", "N1", "setCoverSetting", "coverSetting", "E", "M1", "setCheckInSetting", "checkInSetting", UserInfo.SEX_FEMALE, "P1", "setMigrateAuthUrl", "migrateAuthUrl", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class i extends com.qzone.reborn.base.n {

    /* renamed from: C, reason: from kotlin metadata */
    private JSONObject menuSetting;

    /* renamed from: D, reason: from kotlin metadata */
    private JSONObject coverSetting;

    /* renamed from: E, reason: from kotlin metadata */
    private JSONObject checkInSetting;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<String> resourceData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String styleResourcesString = "";

    /* renamed from: F, reason: from kotlin metadata */
    private String migrateAuthUrl = "";

    private final void T1(String checkInSettingStr) {
        if (TextUtils.isEmpty(checkInSettingStr)) {
            QLog.e("QZIntimateMainPageStyleViewModel", 1, "check in setting is empty");
            return;
        }
        QLog.i("QZIntimateMainPageStyleViewModel", 1, "checkInSetting is " + checkInSettingStr);
        try {
            Intrinsics.checkNotNull(checkInSettingStr);
            this.checkInSetting = new JSONObject(checkInSettingStr);
        } catch (Exception e16) {
            QLog.e("QZIntimateMainPageStyleViewModel", 1, "exception is " + e16);
        }
    }

    private final void U1(String coverSettingStr) {
        if (TextUtils.isEmpty(coverSettingStr)) {
            QLog.e("QZIntimateMainPageStyleViewModel", 1, "cover setting is empty");
            return;
        }
        QLog.i("QZIntimateMainPageStyleViewModel", 1, "coverSettingStr is " + coverSettingStr);
        try {
            Intrinsics.checkNotNull(coverSettingStr);
            this.coverSetting = new JSONObject(coverSettingStr);
        } catch (Exception e16) {
            QLog.e("QZIntimateMainPageStyleViewModel", 1, "exception is " + e16);
        }
    }

    private final void W1(String menuSettingStr) {
        if (TextUtils.isEmpty(menuSettingStr)) {
            QLog.e("QZIntimateMainPageStyleViewModel", 1, "menu setting is empty");
            return;
        }
        QLog.i("QZIntimateMainPageStyleViewModel", 1, "menuSettingStr is " + menuSettingStr);
        try {
            Intrinsics.checkNotNull(menuSettingStr);
            this.menuSetting = new JSONObject(menuSettingStr);
        } catch (Exception e16) {
            QLog.e("QZIntimateMainPageStyleViewModel", 1, "exception is " + e16);
        }
    }

    private final void X1(String authUrl) {
        if (TextUtils.isEmpty(authUrl)) {
            QLog.e("QZIntimateMainPageStyleViewModel", 1, "authUrl is empty");
            return;
        }
        QLog.i("QZIntimateMainPageStyleViewModel", 1, "authUrl is " + authUrl);
        Intrinsics.checkNotNull(authUrl);
        this.migrateAuthUrl = authUrl;
    }

    /* renamed from: M1, reason: from getter */
    public final JSONObject getCheckInSetting() {
        return this.checkInSetting;
    }

    /* renamed from: N1, reason: from getter */
    public final JSONObject getCoverSetting() {
        return this.coverSetting;
    }

    /* renamed from: O1, reason: from getter */
    public final JSONObject getMenuSetting() {
        return this.menuSetting;
    }

    /* renamed from: P1, reason: from getter */
    public final String getMigrateAuthUrl() {
        return this.migrateAuthUrl;
    }

    public final MutableLiveData<String> Q1() {
        return this.resourceData;
    }

    /* renamed from: R1, reason: from getter */
    public final String getStyleResourcesString() {
        return this.styleResourcesString;
    }

    public final void S1(int intimateType) {
        String trimIndent;
        int a16 = mk.d.f416875a.a(intimateType);
        trimIndent = StringsKt__IndentKt.trimIndent(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qzone_intimate_space_main_page_style_" + a16, ""));
        this.styleResourcesString = trimIndent;
        this.resourceData.postValue(trimIndent);
        QLog.i("QZIntimateMainPageStyleViewModel", 1, "styleResourcesString is " + this.styleResourcesString);
        try {
            JSONObject jSONObject = new JSONObject(this.styleResourcesString);
            JSONObject optJSONObject = jSONObject.optJSONObject("menu");
            W1(optJSONObject != null ? optJSONObject.toString() : null);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("cover");
            U1(optJSONObject2 != null ? optJSONObject2.toString() : null);
            JSONObject optJSONObject3 = jSONObject.optJSONObject(QZoneJsConstants.PKGNAME_QZONE_CHECKIN);
            T1(optJSONObject3 != null ? optJSONObject3.toString() : null);
            X1(jSONObject.optString("migrate_auth_url"));
        } catch (Exception e16) {
            QLog.e("QZIntimateMainPageStyleViewModel", 1, "exception is " + e16);
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZIntimateMainPageStyleViewModel";
    }
}
