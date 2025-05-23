package com.tencent.mobileqq.zplan.aio.graytips;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper;
import com.tencent.mobileqq.zplan.api.IZPlanAIOGrayTipApi;
import com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.qqnt.graytips.action.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/graytips/b;", "Lcom/tencent/qqnt/graytips/handler/b;", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/qqnt/graytips/action/f;", "a", "actionInfo", "b", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "Lgv3/a;", "aioAbility", "", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b implements com.tencent.qqnt.graytips.handler.b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.zplan.aio.graytips.b$b, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public /* synthetic */ class C9142b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f331027a;

        static {
            int[] iArr = new int[IZPlanAIOGrayTipApi.GrayTipType.values().length];
            try {
                iArr[IZPlanAIOGrayTipApi.GrayTipType.OPEN_GUIDE_DIALOG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IZPlanAIOGrayTipApi.GrayTipType.SWITCH_SCENE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f331027a = iArr;
        }
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    public f a(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String optString = jsonObject.optString("friend_uin", "");
        int optInt = jsonObject.optInt("gray_tip_type", 0);
        IZPlanAIOGrayTipApi.GrayTipType grayTipType = IZPlanAIOGrayTipApi.GrayTipType.OPEN_GUIDE_DIALOG;
        if (optInt != grayTipType.ordinal()) {
            grayTipType = IZPlanAIOGrayTipApi.GrayTipType.SWITCH_SCENE;
        }
        int optInt2 = jsonObject.optInt("scene_id", 50014);
        Intrinsics.checkNotNullExpressionValue(optString, "optString(KEY_UIN, \"\")");
        return new a(new IZPlanAIOGrayTipApi.GrayTipInfo(optString, "", optInt2, grayTipType));
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    public JSONObject b(f actionInfo) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        a aVar = actionInfo instanceof a ? (a) actionInfo : null;
        if (aVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("gray_tip_type", aVar.getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_ACTION_DATA java.lang.String().getType().ordinal());
        jSONObject.put("friend_uin", aVar.getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_ACTION_DATA java.lang.String().getFriendUin());
        jSONObject.put("scene_id", aVar.getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_ACTION_DATA java.lang.String().getSceneId());
        return jSONObject;
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    public void c(AppRuntime app, Context context, f actionInfo, gv3.a aioAbility) {
        com.tencent.aio.api.runtime.a onGetAIOContext;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        if (xh3.a.f448008a.a()) {
            return;
        }
        a aVar = actionInfo instanceof a ? (a) actionInfo : null;
        if (aVar == null) {
            return;
        }
        int i3 = C9142b.f331027a[aVar.getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_ACTION_DATA java.lang.String().getType().ordinal()];
        if (i3 != 1) {
            if (i3 == 2 && (onGetAIOContext = ((IZPlanShowGuideApi) QRoute.api(IZPlanShowGuideApi.class)).onGetAIOContext()) != null) {
                ((IZPlanAIOHelper) QRoute.api(IZPlanAIOHelper.class)).openPanel(onGetAIOContext, "\u573a\u666f");
            }
        } else if (!((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).getCoupleAvatarSwitchState(aVar.getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_ACTION_DATA java.lang.String().getFriendUin())) {
            ((IZPlanShowGuideApi) QRoute.api(IZPlanShowGuideApi.class)).onShowDialogFromAIOGrayTip(aVar.getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_ACTION_DATA java.lang.String().getFriendUin(), aVar.getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_ACTION_DATA java.lang.String().getSceneId());
        }
        e.f331031a.e(aVar.getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_ACTION_DATA java.lang.String().getType());
    }
}
