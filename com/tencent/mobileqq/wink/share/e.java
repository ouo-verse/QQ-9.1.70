package com.tencent.mobileqq.wink.share;

import android.app.Application;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.wink.request.QQWinkShareAIAvatarArkRequest;
import com.tencent.mobileqq.wink.share.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import qshadow.ShadowShareArkMessage$DisplayInfo;
import qshadow.ShadowShareArkMessage$JumpInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/wink/share/e;", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u0014\u0010\u0012\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/share/e$a;", "", "Lorg/json/JSONObject;", "mateJsonData", "Lqshadow/ShadowShareArkMessage$DisplayInfo;", "b", "Lqshadow/ShadowShareArkMessage$JumpInfo;", "c", "", "type", "", IProfileProtocolConst.PARAM_TARGET_UIN, "", "mateData", "Li83/g;", "listener", "", "d", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.share.e$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ShadowShareArkMessage$DisplayInfo b(JSONObject mateJsonData) {
            ShadowShareArkMessage$DisplayInfo shadowShareArkMessage$DisplayInfo = new ShadowShareArkMessage$DisplayInfo();
            shadowShareArkMessage$DisplayInfo.title.set(mateJsonData.getString("title"));
            shadowShareArkMessage$DisplayInfo.desc.set(mateJsonData.getString("desc"));
            shadowShareArkMessage$DisplayInfo.imageUrl.set(mateJsonData.getString("preview"));
            shadowShareArkMessage$DisplayInfo.iconName.set(mateJsonData.getString("tag"));
            shadowShareArkMessage$DisplayInfo.iconUrl.set(mateJsonData.getString("tagIcon"));
            return shadowShareArkMessage$DisplayInfo;
        }

        private final ShadowShareArkMessage$JumpInfo c(JSONObject mateJsonData) {
            ShadowShareArkMessage$JumpInfo shadowShareArkMessage$JumpInfo = new ShadowShareArkMessage$JumpInfo();
            com.tencent.mobileqq.wink.schema.d dVar = com.tencent.mobileqq.wink.schema.d.f326305a;
            String string = mateJsonData.getString(WadlProxyConsts.KEY_JUMP_URL);
            Intrinsics.checkNotNullExpressionValue(string, "mateJsonData.getString(KEY_JUMP_URL)");
            shadowShareArkMessage$JumpInfo.schemaExtra.set(dVar.i(string));
            return shadowShareArkMessage$JumpInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(i83.g gVar, BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            w53.b.f("WinkAIAvatarShareUtils", "requestQQWinkShareAIAvatarArk requestArk onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            if (z16) {
                if (gVar != null) {
                    gVar.onSuccess();
                }
            } else if (gVar != null) {
                gVar.onFailed();
            }
        }

        public final void d(int type, long targetUin, @NotNull String mateData, @Nullable final i83.g listener) {
            Intrinsics.checkNotNullParameter(mateData, "mateData");
            try {
                JSONObject jSONObject = new JSONObject(mateData);
                ShadowShareArkMessage$DisplayInfo b16 = b(jSONObject);
                String businessId = jSONObject.getString("material_id");
                ShadowShareArkMessage$JumpInfo c16 = c(jSONObject);
                w53.b.f("WinkAIAvatarShareUtils", "business Id: " + businessId + ",  " + c16);
                VSNetworkHelper vSNetworkHelper = VSNetworkHelper.getInstance();
                Application application = RFWApplication.getApplication();
                Intrinsics.checkNotNullExpressionValue(businessId, "businessId");
                vSNetworkHelper.sendRequest(application, new QQWinkShareAIAvatarArkRequest(businessId, type, String.valueOf(targetUin), c16, b16), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.share.d
                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                        e.Companion.e(i83.g.this, baseRequest, z16, j3, str, obj);
                    }
                });
            } catch (Exception e16) {
                w53.b.d("WinkAIAvatarShareUtils", "requestArk error", e16);
            }
        }

        Companion() {
        }
    }
}
