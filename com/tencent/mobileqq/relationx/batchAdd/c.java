package com.tencent.mobileqq.relationx.batchAdd;

import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b,\u0010-J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010R\u0016\u0010\u0014\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0016\u0010\u001c\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0016\u0010\u001e\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0016\u0010 \u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0013R\u0016\u0010\"\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u0013R\u0016\u0010#\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0016\u0010%\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u0013R\u0016\u0010'\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u0013R\u0016\u0010*\u001a\u00020(8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010)R\u0016\u0010+\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u0013\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/relationx/batchAdd/c;", "Lcom/tencent/freesia/IConfigData;", "Lorg/json/JSONObject;", "jsonObject", "", "g", "e", "j", "f", "i", h.F, "c", "", "type", "a", "b", "", "content", "d", "I", "switchOn", "", UserInfo.SEX_FEMALE, "commonFrdPropLimit", "nonFrdPropLimit", "tipsTotalCountForUin", "au_switchOn", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "auRecomDayCycle", BdhLogUtil.LogTag.Tag_Conn, "nm_newMemberIndex", "D", "nm_commonFriends", "E", "nm_switchOn", "aor_maxMsgCount", "G", "aor_switchOn", "H", "cacheTimeCmnFrdCntData", "", "J", "mNewComerJoinTimeLimit", "mJoinTroopStrategy", "<init>", "()V", "K", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @JvmField
    public static final int L = 0;

    /* renamed from: C, reason: from kotlin metadata */
    @JvmField
    public int nm_newMemberIndex;

    /* renamed from: D, reason: from kotlin metadata */
    @JvmField
    public int nm_commonFriends;

    /* renamed from: E, reason: from kotlin metadata */
    @JvmField
    public int nm_switchOn;

    /* renamed from: F, reason: from kotlin metadata */
    @JvmField
    public int aor_maxMsgCount;

    /* renamed from: G, reason: from kotlin metadata */
    @JvmField
    public int aor_switchOn;

    /* renamed from: H, reason: from kotlin metadata */
    @JvmField
    public int cacheTimeCmnFrdCntData;

    /* renamed from: I, reason: from kotlin metadata */
    @JvmField
    public long mNewComerJoinTimeLimit;

    /* renamed from: J, reason: from kotlin metadata */
    @JvmField
    public int mJoinTroopStrategy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int switchOn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public float commonFrdPropLimit;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public float nonFrdPropLimit;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int tipsTotalCountForUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int au_switchOn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int auRecomDayCycle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087D\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/relationx/batchAdd/c$a;", "", "", "content", "Lcom/tencent/mobileqq/relationx/batchAdd/c;", "a", "", "AT_JOIN_SCENE_STRATEGY_A", "I", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.relationx.batchAdd.c$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        @NotNull
        public final c a(@NotNull String content) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) content);
            }
            Intrinsics.checkNotNullParameter(content, "content");
            c cVar = new c();
            cVar.d(content);
            return cVar;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60038);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.tipsTotalCountForUin = 3;
        this.au_switchOn = 1;
        this.nm_newMemberIndex = 1;
        this.nm_commonFriends = 5;
        this.nm_switchOn = 1;
        this.aor_maxMsgCount = 10;
        this.aor_switchOn = 1;
        this.cacheTimeCmnFrdCntData = 24;
        this.mNewComerJoinTimeLimit = 360L;
        this.mJoinTroopStrategy = L;
        this.switchOn = 0;
        this.commonFrdPropLimit = 0.01f;
        this.nonFrdPropLimit = 0.5f;
    }

    private final void c() {
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.getDefault(), "update {switchOn: %s, commonFriendProportionLimit:%s, nonFriendProportionLimit: %s}", Arrays.copyOf(new Object[]{Integer.valueOf(this.switchOn), Float.valueOf(this.commonFrdPropLimit), Float.valueOf(this.nonFrdPropLimit)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
            QLog.i("TroopBatchAddFriendConfigData", 2, format);
            QLog.d("TroopBatchAddFriendConfigData", 2, "update tipsTotalCountForUin = " + this.tipsTotalCountForUin + ",au_switchOn = " + this.au_switchOn + ",nm_newMemberIndex = " + this.nm_newMemberIndex + ",nm_commonFriends = " + this.nm_commonFriends + ",nm_switchOn = " + this.nm_switchOn + ",aor_maxMsgCount = " + this.aor_maxMsgCount + ",aor_switchOn = " + this.aor_switchOn + ",cacheTimeCmnFrdCntData = " + this.cacheTimeCmnFrdCntData);
        }
    }

    private final void e(JSONObject jsonObject) throws JSONException {
        JSONObject jSONObject;
        if (jsonObject == null || !jsonObject.has("activeUser") || (jSONObject = jsonObject.getJSONObject("activeUser")) == null) {
            return;
        }
        if (jSONObject.has("recomDayCycle")) {
            this.auRecomDayCycle = jSONObject.getInt("recomDayCycle");
        }
        if (jSONObject.has("switchOn")) {
            this.au_switchOn = jSONObject.getInt("switchOn");
        }
    }

    private final void f(JSONObject jsonObject) throws JSONException {
        JSONObject jSONObject;
        if (jsonObject == null || !jsonObject.has("atMeOrReplyMe") || (jSONObject = jsonObject.getJSONObject("atMeOrReplyMe")) == null) {
            return;
        }
        if (jSONObject.has("maxMsgCount")) {
            this.aor_maxMsgCount = jSONObject.getInt("maxMsgCount");
        }
        if (jSONObject.has("switchOn")) {
            this.aor_switchOn = jSONObject.getInt("switchOn");
        }
    }

    private final void g(JSONObject jsonObject) throws JSONException {
        if (jsonObject == null) {
            return;
        }
        if (jsonObject.has("switchOn")) {
            this.switchOn = jsonObject.getInt("switchOn");
        }
        if (jsonObject.has("commonFriendProportionLimit")) {
            this.commonFrdPropLimit = (float) jsonObject.getDouble("commonFriendProportionLimit");
        }
        if (jsonObject.has("nonFriendProportionLimit")) {
            this.nonFrdPropLimit = (float) jsonObject.getDouble("nonFriendProportionLimit");
        }
        if (jsonObject.has("tipsTotalCountForUin")) {
            this.tipsTotalCountForUin = jsonObject.getInt("tipsTotalCountForUin");
        }
    }

    private final void h(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null && jsonObject.has("cacheTimeCmnFrdCntData")) {
            this.cacheTimeCmnFrdCntData = jsonObject.getInt("cacheTimeCmnFrdCntData");
        }
    }

    private final void i(JSONObject jsonObject) throws JSONException {
        JSONObject jSONObject;
        if (jsonObject != null && jsonObject.has("joinTroop") && (jSONObject = jsonObject.getJSONObject("joinTroop")) != null && jSONObject.has(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY)) {
            this.mJoinTroopStrategy = jSONObject.getInt(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY);
        }
    }

    private final void j(JSONObject jsonObject) throws JSONException {
        JSONObject jSONObject;
        if (jsonObject == null || !jsonObject.has("newMember") || (jSONObject = jsonObject.getJSONObject("newMember")) == null) {
            return;
        }
        if (jSONObject.has("newMemberIndex")) {
            this.nm_newMemberIndex = jSONObject.getInt("newMemberIndex");
        }
        if (jSONObject.has("commonFriends")) {
            this.nm_commonFriends = jSONObject.getInt("commonFriends");
        }
        if (jSONObject.has("switchOn")) {
            this.nm_switchOn = jSONObject.getInt("switchOn");
        }
        if (jSONObject.has("joinLastMinute")) {
            this.mNewComerJoinTimeLimit = jSONObject.getInt("joinLastMinute");
        }
    }

    public final int a(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, type)).intValue();
        }
        if (type == 4) {
            return this.nm_commonFriends;
        }
        return 10;
    }

    public final int b(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, type)).intValue();
        }
        if (type == 2) {
            return this.auRecomDayCycle;
        }
        return 0;
    }

    public final void d(@NotNull String content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) content);
            return;
        }
        Intrinsics.checkNotNullParameter(content, "content");
        if (TextUtils.isEmpty(content)) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopBatchAddFriendConfigData", 2, "update content is null!");
                return;
            }
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(content);
            g(jSONObject);
            e(jSONObject);
            j(jSONObject);
            f(jSONObject);
            i(jSONObject);
            h(jSONObject);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
                QLog.i("TroopBatchAddFriendConfigData", 2, "update exception ", e16);
            }
        }
        c();
    }
}
