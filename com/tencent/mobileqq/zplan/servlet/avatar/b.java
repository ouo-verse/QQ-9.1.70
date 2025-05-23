package com.tencent.mobileqq.zplan.servlet.avatar;

import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.zplan.model.ZPlanAvatar;
import com.tencent.mobileqq.zplan.model.c;
import com.tencent.mobileqq.zplan.servlet.ZPlanUserInfoRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nk3.d;
import nk3.p;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/avatar/b;", "", "", "uin", "", "appearanceKey", "Lnk3/d;", "callback", "", "b", "Lcom/tencent/mobileqq/zplan/model/f$a;", "dynamicAvatar", "Lnk3/a;", "d", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f335401a = new b();

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String appearanceKey, d callback, Map map) {
        ZPlanAvatar.ZPlanDynamicAvatar zPlanDynamicAvatar;
        Intrinsics.checkNotNullParameter(appearanceKey, "$appearanceKey");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        try {
            ZPlanAvatar.ZPlanStaticAvatar zPlanStaticAvatar = new ZPlanAvatar.ZPlanStaticAvatar(appearanceKey, (String) map.get(Integer.valueOf(ProfileContants.FIELD_ZPLAN_COVER_IMG)), (String) map.get(3));
            String str = (String) map.get(11);
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("url");
                Intrinsics.checkNotNullExpressionValue(string, "getString(\"url\")");
                long j3 = jSONObject.getLong("timestamp");
                String string2 = jSONObject.getString("appearanceKey");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(\"appearanceKey\")");
                String string3 = jSONObject.getString(Constants.Service.PROPERTIES);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(\"properties\")");
                zPlanDynamicAvatar = new ZPlanAvatar.ZPlanDynamicAvatar(string, j3, string2, string3);
            } else {
                zPlanDynamicAvatar = null;
            }
            callback.a(new ZPlanAvatar(zPlanStaticAvatar, zPlanDynamicAvatar));
        } catch (Throwable th5) {
            try {
                QLog.e("ZPlanAvatarAnimationRequest", 1, "parse ZPlanAvatarAnimation failed", th5);
            } finally {
                callback.a(null);
            }
        }
    }

    public final void b(long uin, final String appearanceKey, final d callback) {
        List<c> mutableListOf;
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZPlanUserInfoRequest zPlanUserInfoRequest = ZPlanUserInfoRequest.f335380a;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new c(11, 1), new c(ProfileContants.FIELD_ZPLAN_COVER_IMG, 1), new c(3, 1));
        zPlanUserInfoRequest.q(mutableListOf, uin, 5, new p() { // from class: com.tencent.mobileqq.zplan.servlet.avatar.a
            @Override // nk3.p
            public final void a(Map map) {
                b.c(appearanceKey, callback, map);
            }
        });
    }

    public final void d(long uin, ZPlanAvatar.ZPlanDynamicAvatar dynamicAvatar, nk3.a callback) {
        List mutableListOf;
        Intrinsics.checkNotNullParameter(dynamicAvatar, "dynamicAvatar");
        ZPlanUserInfoRequest zPlanUserInfoRequest = ZPlanUserInfoRequest.f335380a;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", dynamicAvatar.getZipUrl());
        jSONObject.put("timestamp", dynamicAvatar.getTimestamp());
        jSONObject.put("appearanceKey", dynamicAvatar.getAppearanceKey());
        jSONObject.put(Constants.Service.PROPERTIES, dynamicAvatar.getProperties());
        Unit unit = Unit.INSTANCE;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.mobileqq.zplan.model.b(11, 1, jSONObject.toString()));
        ZPlanUserInfoRequest.p(zPlanUserInfoRequest, 4451, 0, mutableListOf, Long.valueOf(uin), callback, 0L, 32, null);
    }
}
