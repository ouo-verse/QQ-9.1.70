package com.tencent.mobileqq.zplan.meme.ipc;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.zplan.meme.api.impl.MemeHelper;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.mobileqq.zplan.push.ZPlanProfileProcessor;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.meme.Meme;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import pi3.a;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/ipc/ZPlanMemeIPCImpl;", "Lpi3/a;", "", "jsonParams", "", "appearanceKeyChangeFromEngine", "avatarSceneParams", "notifyEnterAvatarScene", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanMemeIPCImpl implements a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "[zplan][ZPlanMemeIPC]";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/ipc/ZPlanMemeIPCImpl$a;", "", "", "jsonParams", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.meme.ipc.ZPlanMemeIPCImpl$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(String jsonParams) {
            Set<String> of5;
            Intrinsics.checkNotNullParameter(jsonParams, "jsonParams");
            try {
                JSONObject jSONObject = new JSONObject(jsonParams);
                String optString = jSONObject.optString("appearanceKey");
                if (optString == null) {
                    return;
                }
                long optLong = jSONObject.optLong("timestamp");
                int optInt = jSONObject.optInt("gender", 0);
                AppInterface c16 = bb.f335811a.c();
                if (c16 == null) {
                    return;
                }
                String currentUin = c16.getCurrentAccountUin();
                ZPlanProfileProcessor zPlanProfileProcessor = (ZPlanProfileProcessor) com.tencent.mobileqq.profilecommon.utils.a.a(ZPlanProfileProcessor.class, c16);
                if (zPlanProfileProcessor != null) {
                    String str = currentUin.toString();
                    zPlanProfileProcessor.f(str, optLong);
                    zPlanProfileProcessor.c(str, optInt);
                    ZPlanProfileProcessor.e(zPlanProfileProcessor, str, optString, false, 4, null);
                    ZplanDataRepository.f334898a.r(str);
                }
                ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
                of5 = SetsKt__SetsJVMKt.setOf(currentUin);
                zPlanServiceHelper.o0(of5);
                Meme meme = Meme.f385754h;
                Meme.Type type = Meme.Type.ZPlan;
                Intrinsics.checkNotNullExpressionValue(currentUin, "currentUin");
                meme.w(type, currentUin, optString);
            } catch (JSONException e16) {
                QLog.e(ZPlanMemeIPCImpl.TAG, 1, "appearanceKeyChangeFromEngine exception, params:" + jsonParams, e16);
            }
        }

        Companion() {
        }
    }

    @Override // pi3.a
    public void appearanceKeyChangeFromEngine(String jsonParams) {
        Intrinsics.checkNotNullParameter(jsonParams, "jsonParams");
        INSTANCE.a(jsonParams);
    }

    @Override // pi3.a
    public void notifyEnterAvatarScene(String avatarSceneParams) {
        MemeHelper.INSTANCE.notifyEnterAvatarScene(avatarSceneParams);
    }
}
