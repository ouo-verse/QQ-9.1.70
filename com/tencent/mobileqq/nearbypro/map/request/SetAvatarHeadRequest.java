package com.tencent.mobileqq.nearbypro.map.request;

import com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest;
import com.tencent.mobileqq.nearbypro.request.a;
import com.tencent.mobileqq.zplan.avatar.edit.BackgroundInfo;
import com.tencent.mobileqq.zplan.avatar.edit.ClipperInfo;
import com.tencent.mobileqq.zplan.avatar.edit.d;
import hq4.k;
import hq4.l;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import np4.c;
import op4.g;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/request/SetAvatarHeadRequest;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBasePBRequest;", "Lhq4/k;", "Lhq4/l;", "Lkotlin/Function0;", "pbRspConstructor", "Lkotlin/jvm/functions/Function0;", "getPbRspConstructor", "()Lkotlin/jvm/functions/Function0;", "", "cmd", "Ljava/lang/String;", "getCmd", "()Ljava/lang/String;", "pbReq", "Lhq4/k;", "getPbReq", "()Lhq4/k;", "Lop4/g;", "stImage", "Lcom/tencent/mobileqq/zplan/avatar/edit/d;", "editAvatarData", "<init>", "(Lop4/g;Lcom/tencent/mobileqq/zplan/avatar/edit/d;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class SetAvatarHeadRequest extends NearbyProBasePBRequest<k, l> {

    @NotNull
    private final String cmd;

    @NotNull
    private final k pbReq;

    @NotNull
    private final Function0<l> pbRspConstructor;

    public SetAvatarHeadRequest(@NotNull g stImage, @NotNull d editAvatarData) {
        Object obj;
        Object obj2;
        Object obj3;
        int i3;
        String url;
        Integer id5;
        Intrinsics.checkNotNullParameter(stImage, "stImage");
        Intrinsics.checkNotNullParameter(editAvatarData, "editAvatarData");
        this.pbRspConstructor = new Function0<l>() { // from class: com.tencent.mobileqq.nearbypro.map.request.SetAvatarHeadRequest$pbRspConstructor$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final l invoke() {
                return new l();
            }
        };
        this.cmd = "trpc.lplan.user_manager_svr.User.SsoSetAvatarHead";
        k kVar = new k();
        c cVar = new c();
        a.c(cVar);
        kVar.f405981a = cVar;
        kVar.f405982b = stImage;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("uin", editAvatarData.getUin());
        jSONObject2.put("actionId", editAvatarData.getActionId());
        jSONObject2.put("actionName", editAvatarData.getActionName());
        jSONObject2.put("defaultUrl", editAvatarData.getDefaultUrl());
        jSONObject2.put("avatarSize", editAvatarData.getAvatarSize());
        jSONObject2.put("appearanceKey", editAvatarData.getAppearanceKey());
        ClipperInfo inBoundsClipperInfo = editAvatarData.getInBoundsClipperInfo();
        Object valueOf = Float.valueOf(0.0f);
        if (inBoundsClipperInfo != null) {
            obj = Double.valueOf(inBoundsClipperInfo.getStartX());
        } else {
            obj = valueOf;
        }
        jSONObject2.put("boundsClipperInfo_x", obj);
        ClipperInfo inBoundsClipperInfo2 = editAvatarData.getInBoundsClipperInfo();
        if (inBoundsClipperInfo2 != null) {
            obj2 = Double.valueOf(inBoundsClipperInfo2.getStartY());
        } else {
            obj2 = valueOf;
        }
        jSONObject2.put("boundsClipperInfo_y", obj2);
        ClipperInfo inBoundsClipperInfo3 = editAvatarData.getInBoundsClipperInfo();
        if (inBoundsClipperInfo3 != null) {
            obj3 = Double.valueOf(inBoundsClipperInfo3.getClipWidth());
        } else {
            obj3 = valueOf;
        }
        jSONObject2.put("boundsClipperInfo_width", obj3);
        ClipperInfo inBoundsClipperInfo4 = editAvatarData.getInBoundsClipperInfo();
        jSONObject2.put("boundsClipperInfo_height", inBoundsClipperInfo4 != null ? Double.valueOf(inBoundsClipperInfo4.getClipHeight()) : valueOf);
        JSONArray jSONArray = new JSONArray();
        List<Integer> j3 = editAvatarData.j();
        if (j3 != null) {
            Iterator<T> it = j3.iterator();
            while (it.hasNext()) {
                jSONArray.put(((Number) it.next()).intValue());
            }
        }
        jSONObject2.put("eventTags", jSONArray);
        jSONObject2.put("eventInfo", editAvatarData.getEventInfo());
        Unit unit = Unit.INSTANCE;
        jSONObject.put("headActionData", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        BackgroundInfo backgroundInfo = editAvatarData.getBackgroundInfo();
        if (backgroundInfo != null && (id5 = backgroundInfo.getId()) != null) {
            i3 = id5.intValue();
        } else {
            i3 = -1;
        }
        jSONObject3.put("id", i3);
        BackgroundInfo backgroundInfo2 = editAvatarData.getBackgroundInfo();
        jSONObject3.put("url", (backgroundInfo2 == null || (url = backgroundInfo2.getUrl()) == null) ? "" : url);
        jSONObject.put("backgroudData", jSONObject3);
        kVar.f405983c = jSONObject.toString();
        this.pbReq = kVar;
    }

    @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
    @NotNull
    public String getCmd() {
        return this.cmd;
    }

    @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
    @NotNull
    public Function0<l> getPbRspConstructor() {
        return this.pbRspConstructor;
    }

    @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
    @NotNull
    public k getPbReq() {
        return this.pbReq;
    }
}
