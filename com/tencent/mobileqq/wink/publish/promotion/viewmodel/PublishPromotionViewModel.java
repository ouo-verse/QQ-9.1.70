package com.tencent.mobileqq.wink.publish.promotion.viewmodel;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.update.qarchive.tools.zip.UnixStat;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.ECQQRemoteResponse;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.publish.promotion.viewmodel.PublishPromotionViewModel;
import com.tencent.mobileqq.winkpublish.model.PromotionParams;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import o93.PromotionChannelItem;
import o93.PromotionPartInfo;
import o93.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 B2\u00020\u0001:\u0002CDB\u0007\u00a2\u0006\u0004\b@\u0010AJ \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J2\u0010\u000b\u001a\u00020\u00062(\u0010\n\u001a$\u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\u0004\u0012\u00020\u00060\bH\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\f\u0010\u0010\u001a\u00020\t*\u00020\u000eH\u0002J\u001c\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004*\u00020\u000eH\u0002J\f\u0010\u0013\u001a\u00020\u0012*\u00020\u000eH\u0002J\u0018\u0010\u0018\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0016J\u001e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u000e\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"J\u0006\u0010%\u001a\u00020\u0006R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u001c0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010(R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u001c0*8\u0006\u00a2\u0006\f\n\u0004\b2\u0010,\u001a\u0004\b3\u0010.R(\u00107\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0016050&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010(R+\u0010:\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0016050*8\u0006\u00a2\u0006\f\n\u0004\b8\u0010,\u001a\u0004\b9\u0010.R\u0016\u0010=\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/promotion/viewmodel/PublishPromotionViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "jsBundleNameList", "", "e2", "Lkotlin/Function2;", "Lo93/b;", "callback", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "data", "Lorg/json/JSONObject;", "T1", "Z1", "d2", "Lo93/a;", "X1", "Lcom/tencent/mobileqq/winkpublish/model/PromotionParams;", "params", "Lcom/tencent/mobileqq/wink/publish/promotion/viewmodel/PublishPromotionViewModel$PromotionSource;", "source", "i2", "verifyId", "newName", "newCoverUrl", "", "j2", "getLogTag", "Lha3/b;", "winkPublishContent", "f2", "Landroid/content/Intent;", "schemaInfo", "g2", SemanticAttributes.DbSystemValues.H2, "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_partInfo", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "W1", "()Landroidx/lifecycle/LiveData;", "partInfo", BdhLogUtil.LogTag.Tag_Conn, "_enableShowPromotion", "D", "U1", "enableShowPromotion", "Lkotlin/Pair;", "E", "_selectedResult", UserInfo.SEX_FEMALE, "c2", "selectedResult", "G", "Z", "hasInputDefaultPromotionItem", "H", "forceShowSchoolPart", "<init>", "()V", "I", "a", "PromotionSource", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PublishPromotionViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _enableShowPromotion;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> enableShowPromotion;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<PromotionParams, PromotionSource>> _selectedResult;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Pair<PromotionParams, PromotionSource>> selectedResult;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean hasInputDefaultPromotionItem;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean forceShowSchoolPart;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<PromotionPartInfo> _partInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<PromotionPartInfo> partInfo;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/promotion/viewmodel/PublishPromotionViewModel$PromotionSource;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "SOURCE_OTHER", "SOURCE_DELETE", "SOURCE_MANUAL_SELECT", "SOURCE_FROM_DRAFT", "SOURCE_FROM_FRONT_END", "SOURCE_FROM_BACK_END", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum PromotionSource {
        SOURCE_OTHER(-1),
        SOURCE_DELETE(0),
        SOURCE_MANUAL_SELECT(1),
        SOURCE_FROM_DRAFT(2),
        SOURCE_FROM_FRONT_END(3),
        SOURCE_FROM_BACK_END(4);

        private final int value;

        PromotionSource(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/publish/promotion/viewmodel/PublishPromotionViewModel$b", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/a;", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/ECQQRemoteResponse;", "errorResponse", "", "b", "successResponse", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements com.tencent.mobileqq.qqecommerce.biz.sdk.api.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<PromotionPartInfo, ArrayList<String>, Unit> f325949a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PublishPromotionViewModel f325950b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super PromotionPartInfo, ? super ArrayList<String>, Unit> function2, PublishPromotionViewModel publishPromotionViewModel) {
            this.f325949a = function2;
            this.f325950b = publishPromotionViewModel;
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.a
        public void a(@NotNull ECQQRemoteResponse successResponse) {
            Intrinsics.checkNotNullParameter(successResponse, "successResponse");
            if (successResponse.getCode() == 0) {
                JSONObject T1 = this.f325950b.T1(successResponse.getData());
                if (T1 != null) {
                    this.f325949a.invoke(this.f325950b.Z1(T1), this.f325950b.d2(T1));
                    return;
                }
                QLog.e("PublishPromotionViewModel", 1, "getRemotePromotionPartInfo error data == null.");
                return;
            }
            QLog.e("PublishPromotionViewModel", 1, "getRemotePromotionPartInfo error retCode: " + successResponse.getCode() + ".");
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.a
        public void b(@NotNull ECQQRemoteResponse errorResponse) {
            Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
            QLog.e("PublishPromotionViewModel", 1, "getRemotePromotionPartInfo error.");
            this.f325949a.invoke(c.a(), new ArrayList<>());
        }
    }

    public PublishPromotionViewModel() {
        MutableLiveData<PromotionPartInfo> mutableLiveData = new MutableLiveData<>();
        this._partInfo = mutableLiveData;
        this.partInfo = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._enableShowPromotion = mutableLiveData2;
        this.enableShowPromotion = mutableLiveData2;
        MutableLiveData<Pair<PromotionParams, PromotionSource>> mutableLiveData3 = new MutableLiveData<>();
        this._selectedResult = mutableLiveData3;
        this.selectedResult = mutableLiveData3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject T1(byte[] data) {
        if (data == null) {
            return null;
        }
        try {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            return new JSONObject(new String(data, UTF_8));
        } catch (JSONException unused) {
            return null;
        }
    }

    private final PromotionChannelItem X1(JSONObject jSONObject) {
        String optString = jSONObject.optString("msg");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(\"msg\")");
        String optString2 = jSONObject.optString("url");
        Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"url\")");
        String optString3 = jSONObject.optString("img");
        Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"img\")");
        String optString4 = jSONObject.optString("night_img");
        Intrinsics.checkNotNullExpressionValue(optString4, "optString(\"night_img\")");
        return new PromotionChannelItem(optString, optString2, optString3, optString4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PromotionPartInfo Z1(JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2;
        JSONObject optJSONObject = jSONObject.optJSONObject("label_item");
        JSONArray optJSONArray = jSONObject.optJSONArray("promote_item");
        ArrayList arrayList = new ArrayList();
        String str2 = null;
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                Object obj = optJSONArray.get(i3);
                if (obj instanceof JSONObject) {
                    jSONObject2 = (JSONObject) obj;
                } else {
                    jSONObject2 = null;
                }
                if (jSONObject2 != null) {
                    arrayList.add(X1(jSONObject2));
                }
            }
        }
        boolean optBoolean = jSONObject.optBoolean("has_promote_item");
        if (optJSONObject != null) {
            str = optJSONObject.optString("label_name");
        } else {
            str = null;
        }
        if (str == null) {
            str = "\u6dfb\u52a0\u63a8\u5e7f";
        }
        if (optJSONObject != null) {
            str2 = optJSONObject.optString("label_msg");
        }
        if (str2 == null) {
            str2 = "";
        }
        return new PromotionPartInfo(optBoolean, str, str2, arrayList);
    }

    private final void a2(final Function2<? super PromotionPartInfo, ? super ArrayList<String>, Unit> callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.promotion.viewmodel.a
            @Override // java.lang.Runnable
            public final void run() {
                PublishPromotionViewModel.b2(Function2.this, this);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(Function2 callback, PublishPromotionViewModel this$0) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WadlProxyConsts.CHANNEL, 2);
        IQQECommerceSdk iQQECommerceSdk = (IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "reqParams.toString()");
        byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        iQQECommerceSdk.sendPackage("trpc.ecom.send_promotion_svr.SendPromotionSvr", "/trpc.ecom.send_promotion_svr.SendPromotionSvr/SendTaskInfoToXworld", bytes, null, new b(callback, this$0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<String> d2(JSONObject jSONObject) {
        boolean z16;
        ArrayList<String> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("promote_item");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    String hippyBundleKey = optJSONObject.optString("js_bundle_key");
                    Intrinsics.checkNotNullExpressionValue(hippyBundleKey, "hippyBundleKey");
                    if (hippyBundleKey.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList.add(hippyBundleKey);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2(ArrayList<String> jsBundleNameList) {
        if (jsBundleNameList.isEmpty()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(IQCircleIPCApi.BUNDLE_KEY_HIPPY_JS_BUNDLE_NAME, jsBundleNameList);
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), IQCircleIPCApi.MODULE_NAME, IQCircleIPCApi.ACTION_PRELOAD_HIPPY_JS_BUNDLE, bundle);
    }

    @NotNull
    public final LiveData<Boolean> U1() {
        return this.enableShowPromotion;
    }

    @NotNull
    public final LiveData<PromotionPartInfo> W1() {
        return this.partInfo;
    }

    @NotNull
    public final LiveData<Pair<PromotionParams, PromotionSource>> c2() {
        return this.selectedResult;
    }

    public final void f2(@NotNull ha3.b winkPublishContent) {
        Intrinsics.checkNotNullParameter(winkPublishContent, "winkPublishContent");
        HashMap<String, String> hashMap = winkPublishContent.f404635t;
        if (hashMap != null && hashMap.size() > 0) {
            String str = hashMap.get("isOpenSchool");
            boolean z16 = false;
            if (str != null && Boolean.parseBoolean(str)) {
                z16 = true;
            }
            if (z16) {
                this._enableShowPromotion.setValue(Boolean.FALSE);
                return;
            }
        }
        h2();
        PromotionParams promotionParams = winkPublishContent.f404632q;
        if (promotionParams != null && promotionParams.getEndTimeMs() > System.currentTimeMillis()) {
            this._enableShowPromotion.setValue(Boolean.TRUE);
            i2(promotionParams, PromotionSource.SOURCE_FROM_DRAFT);
            this.hasInputDefaultPromotionItem = true;
        }
    }

    public final void g2(@NotNull Intent schemaInfo) {
        HashMap<String, String> hashMap;
        Intrinsics.checkNotNullParameter(schemaInfo, "schemaInfo");
        if (this.hasInputDefaultPromotionItem) {
            QLog.d("PublishPromotionViewModel", 1, "hasInputDefaultPromotionItem! updateDataBySchemaInfo passed.");
            return;
        }
        Serializable serializableExtra = schemaInfo.getSerializableExtra("key_attrs");
        if (serializableExtra == null) {
            return;
        }
        if (serializableExtra instanceof HashMap) {
            hashMap = (HashMap) serializableExtra;
        } else {
            hashMap = null;
        }
        if (hashMap == null) {
            return;
        }
        if (((Map) serializableExtra).containsKey(QCircleScheme.AttrQQPublish.SHOULD_OPEN_SCHOOL)) {
            this.forceShowSchoolPart = true;
        }
        PromotionParams e16 = p93.a.f425806a.e(hashMap);
        if (e16 == null) {
            return;
        }
        this.hasInputDefaultPromotionItem = true;
        i2(e16, PromotionSource.SOURCE_FROM_FRONT_END);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "PublishPromotionViewModel";
    }

    public final void h2() {
        a2(new Function2<PromotionPartInfo, ArrayList<String>, Unit>() { // from class: com.tencent.mobileqq.wink.publish.promotion.viewmodel.PublishPromotionViewModel$updatePromotionInfoByNetwork$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PromotionPartInfo promotionPartInfo, ArrayList<String> arrayList) {
                invoke2(promotionPartInfo, arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PromotionPartInfo partInfo, @NotNull ArrayList<String> hippyBundleKeyList) {
                boolean z16;
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                Intrinsics.checkNotNullParameter(partInfo, "partInfo");
                Intrinsics.checkNotNullParameter(hippyBundleKeyList, "hippyBundleKeyList");
                boolean showPromotionPart = partInfo.getShowPromotionPart();
                QLog.d("PublishPromotionViewModel", 1, "enableShowPromotionPart: " + showPromotionPart);
                if (!showPromotionPart) {
                    mutableLiveData3 = PublishPromotionViewModel.this._enableShowPromotion;
                    mutableLiveData3.postValue(Boolean.FALSE);
                    PublishPromotionViewModel.this.i2(null, PublishPromotionViewModel.PromotionSource.SOURCE_OTHER);
                    return;
                }
                z16 = PublishPromotionViewModel.this.forceShowSchoolPart;
                if (!z16) {
                    mutableLiveData2 = PublishPromotionViewModel.this._enableShowPromotion;
                    mutableLiveData2.postValue(Boolean.TRUE);
                }
                mutableLiveData = PublishPromotionViewModel.this._partInfo;
                mutableLiveData.postValue(partInfo);
                if (!hippyBundleKeyList.isEmpty()) {
                    PublishPromotionViewModel.this.e2(hippyBundleKeyList);
                }
            }
        });
    }

    public final void i2(@Nullable PromotionParams params, @NotNull PromotionSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        QLog.d("PublishPromotionViewModel", 2, "params: " + params + ", source: " + source);
        this._selectedResult.postValue(new Pair<>(params, source));
    }

    public final boolean j2(@NotNull String verifyId, @NotNull String newName, @NotNull String newCoverUrl) {
        PromotionParams first;
        boolean z16;
        Intrinsics.checkNotNullParameter(verifyId, "verifyId");
        Intrinsics.checkNotNullParameter(newName, "newName");
        Intrinsics.checkNotNullParameter(newCoverUrl, "newCoverUrl");
        Pair<PromotionParams, PromotionSource> value = this.selectedResult.getValue();
        if (value == null || (first = value.getFirst()) == null) {
            return false;
        }
        PromotionSource second = value.getSecond();
        if (Intrinsics.areEqual(first.getId(), verifyId)) {
            if (newName.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                i2(PromotionParams.copy$default(first, null, newName, 0L, null, newCoverUrl, null, null, 0, 0, UnixStat.DEFAULT_DIR_PERM, null), second);
                return true;
            }
        }
        return false;
    }
}
