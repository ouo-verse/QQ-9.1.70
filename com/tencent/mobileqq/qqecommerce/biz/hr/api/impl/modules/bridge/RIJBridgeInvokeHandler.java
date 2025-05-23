package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge;

import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.ProcessConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/bridge/RIJBridgeInvokeHandler;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/bridge/a;", "Lorg/json/JSONObject;", "param", "", "callback", "", "r", "u", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", ReportConstant.COSTREPORT_PREFIX, "y", HippyTKDListViewAdapter.X, "", "retCode", "w", "g", "f", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/a;", "module", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/a;)V", "c", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class RIJBridgeInvokeHandler extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RIJBridgeInvokeHandler(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a module) {
        super(module);
        Intrinsics.checkNotNullParameter(module, "module");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(JSONObject param, String callback) {
        if (QLog.isColorLevel()) {
            QLog.i("BridgeModule", 2, "[clearChannelInsertCardInfo], param = " + param);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(JSONObject param, String callback) {
        if (QLog.isColorLevel()) {
            QLog.i("BridgeModule", 2, "clearXTabRedPoint, param=" + param);
        }
        if (param == null || !param.has("channelId")) {
            QLog.i("BridgeModule", 2, "illegal param, param=" + param);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(JSONObject param, String callback) {
        if (QLog.isColorLevel()) {
            QLog.i("BridgeModule", 2, "[getChannelInsertCardInfo], param = " + param);
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        boolean z16 = false;
        if (param != null && param.has("channelId")) {
            z16 = true;
        }
        if (z16) {
            param.optInt("channelId");
        }
        jSONObject.put("insertCardInfo", jSONObject2);
        if (QLog.isColorLevel()) {
            QLog.i("BridgeModule", 2, "[getChannelInsertCardInfo] result = " + jSONObject);
        }
        b(callback, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(JSONObject param, String callback) {
        if (QLog.isColorLevel()) {
            QLog.i("BridgeModule", 2, "getChannelRedPointInfo, param=" + param);
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        boolean z16 = false;
        if (param != null && param.has("channelId")) {
            z16 = true;
        }
        if (z16) {
            param.optInt("channelId");
        }
        jSONObject.put("redPointInfo", jSONObject2);
        b(callback, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(JSONObject param, String callback) {
        JSONObject jSONObject = new JSONObject();
        QLog.i("RIJBridgeInvokeHandler", 1, "[getPrivateChatRedCount] result = " + jSONObject);
        b(callback, jSONObject);
    }

    private final JSONObject w(int retCode) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("retCode", retCode);
        } catch (JSONException e16) {
            QLog.e("RIJBridgeInvokeHandler", 1, "[getResultJsonObject] error, e = " + e16);
        }
        return jSONObject;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.a
    public String f() {
        return ProcessConstant.READINJOY;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.a
    public void g() {
        h("openPrivateLetter", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().g0();
            }
        });
        h("openVideo", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().openVideo(jSONObject);
            }
        });
        h("selectAndInviteFriend", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().p0(jSONObject, str);
            }
        });
        h("showPicture", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().C0(jSONObject, str);
            }
        });
        h("openAccountPageMore", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().d0(jSONObject, str);
            }
        });
        h("socialize_feeds_update", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().G0(jSONObject, str);
            }
        });
        h("updateAccountCardFollowInfo", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().J0(jSONObject, str);
            }
        });
        h("updateTopicCardFollowInfo", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().K0(jSONObject, str);
            }
        });
        h("showVisibleUserList", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$9
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().F0(jSONObject, str);
            }
        });
        h("getBiuTriggerType", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$10
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().y(jSONObject, str);
            }
        });
        h("showUGCVideoRecordPage", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$11
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().E0(jSONObject, str);
            }
        });
        h("showCommentEditor", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$12
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().v0(jSONObject, str);
            }
        });
        h("showCommentEditorNative", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$13
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().w0(jSONObject, str);
            }
        });
        h("showMessageBoardEditorNative", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$14
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().z0(jSONObject, str);
            }
        });
        h("feeds_refresh_message", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$15
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().s(jSONObject);
            }
        });
        h("requestRedPacketContentShareToast", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$16
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().o0(str);
            }
        });
        h("clearMessageBoxData", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$17
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().j();
            }
        });
        h("showFollowAlertView", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$18
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().y0(jSONObject, str);
            }
        });
        h("hideFollowAlertView", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$19
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().S(jSONObject, str);
            }
        });
        h("getALDConfigParams", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$20
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().u(jSONObject, str);
            }
        });
        h("showLevelDialog", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$21
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().openLevelDialog(jSONObject, str);
            }
        });
        h("clearChannelRedPoint", new RIJBridgeInvokeHandler$register$22(this));
        h("getChannelRedPointInfo", new RIJBridgeInvokeHandler$register$23(this));
        h("getChannelInsertCardInfo", new RIJBridgeInvokeHandler$register$24(this));
        h("clearChannelInsertCardInfo", new RIJBridgeInvokeHandler$register$25(this));
        h("getPrivateChatRedCount", new RIJBridgeInvokeHandler$register$26(this));
        h("clearPrivateChatRedCount", new RIJBridgeInvokeHandler$register$27(this));
        h("openPrivateChatList", new RIJBridgeInvokeHandler$register$28(this));
        h("openPrivateChatAio", new RIJBridgeInvokeHandler$register$29(this));
        h("getYouthMode", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$30
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().Q(str);
            }
        });
        h("getFeedsStyleType", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$31
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().F(str);
            }
        });
        h("openTabSettingView", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$32
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().h0();
            }
        });
        h("isKanDianTabOpen", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$33
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().W(str);
            }
        });
        h("getMutedState", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$34
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().K(str);
            }
        });
        h("isWezoneJoyUser", new Function2<JSONObject, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge.RIJBridgeInvokeHandler$register$35
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, String str) {
                invoke2(jSONObject, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject jSONObject, String str) {
                RIJBridgeInvokeHandler.this.getBridgeModule().b0(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(JSONObject param, String callback) {
        JSONObject w3 = w(0);
        QLog.i("RIJBridgeInvokeHandler", 1, "[clearPrivateChatRedCount] result = " + w3);
        b(callback, w3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(JSONObject param, String callback) {
        JSONObject w3 = w(0);
        QLog.i("RIJBridgeInvokeHandler", 1, "[openPrivateChatList] result = " + w3);
        b(callback, w3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(JSONObject param, String callback) {
        long optLong = param != null ? param.optLong("uin", 0L) : 0L;
        String optString = param != null ? param.optString(VasLiveIPCModule.KEY_GET_ACCOUNT_NICK_NAME, "") : null;
        String str = optString != null ? optString : "";
        QLog.i("RIJBridgeInvokeHandler", 1, "[openPrivateChatAio], param = " + param);
        JSONObject w3 = w(0);
        if (optLong == 0 || TextUtils.isEmpty(str)) {
            w3 = w(1);
        }
        QLog.i("RIJBridgeInvokeHandler", 1, "[openPrivateChatAio] result = " + w3);
        b(callback, w3);
    }
}
