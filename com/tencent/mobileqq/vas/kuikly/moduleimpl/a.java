package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IFontBubbleManagerExt;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J?\u0010\r\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0016J?\u0010\u000e\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0016J?\u0010\u000f\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/a;", "", "Lcom/tencent/mobileqq/vas/svip/api/ISVIPHandler;", "d", "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "c", "a", "b", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/kuikly/moduleimpl/a$b", "Lcom/tencent/mobileqq/vas/api/IFontBubbleManagerExt$a;", "", "result", "", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements IFontBubbleManagerExt.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f309758a;

        b(Function1<Object, Unit> function1) {
            this.f309758a = function1;
        }

        @Override // com.tencent.mobileqq.vas.api.IFontBubbleManagerExt.a
        public void a(boolean result) {
            Function1<Object, Unit> function1 = this.f309758a;
            if (function1 != null) {
                function1.invoke(new JSONObject().toString());
            }
        }
    }

    private final ISVIPHandler d() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        Object businessHandler = ((AppInterface) peekAppRuntime).getBusinessHandler(((ISVIPHandlerProxy) QRoute.api(ISVIPHandlerProxy.class)).getImplClassName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.vas.svip.api.ISVIPHandler");
        return (ISVIPHandler) businessHandler;
    }

    public void a(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        int i3;
        int i16;
        if (TextUtils.isEmpty(params)) {
            return;
        }
        Intrinsics.checkNotNull(params);
        int optInt = new JSONObject(params).optInt("type");
        if (optInt != 2) {
            if (optInt == 5 && callback != null) {
                JSONObject jSONObject = new JSONObject();
                String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
                IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                NTVasSimpleInfo vasSimpleInfoWithUid = iVasInfoService.getVasSimpleInfoWithUid(uid, "AioPanelSetFontBubbleImpl");
                if (vasSimpleInfoWithUid != null) {
                    i3 = (int) vasSimpleInfoWithUid.uVipFont;
                } else {
                    i3 = 0;
                }
                jSONObject.put(MessageForRichState.SIGN_MSG_FONT_ID, i3);
                if (vasSimpleInfoWithUid != null) {
                    i16 = vasSimpleInfoWithUid.vipFontType;
                } else {
                    i16 = 1;
                }
                jSONObject.put("realFontId", i16);
                callback.invoke(jSONObject.toString());
                return;
            }
            return;
        }
        if (callback != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("bubbleId", d().getSelfBubbleId());
            callback.invoke(jSONObject2.toString());
        }
    }

    public void b(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        ((IFontBubbleManagerExt) QRoute.api(IFontBubbleManagerExt.class)).sendMessage(new b(callback));
    }

    public void c(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        if (TextUtils.isEmpty(params)) {
            return;
        }
        Intrinsics.checkNotNull(params);
        JSONObject jSONObject = new JSONObject(params);
        int optInt = jSONObject.optInt("type");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            return;
        }
        if (optInt != 2) {
            if (optInt == 5) {
                d().setSelfFontInfo(optJSONObject.optInt(MessageForRichState.SIGN_MSG_FONT_ID), optJSONObject.optInt(MessageForRichState.SIGN_MSG_FONT_TYPE));
                return;
            }
            return;
        }
        d().setSelfBubbleId(optJSONObject.optInt("bubbleId"));
    }
}
