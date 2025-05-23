package ih2;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import ih2.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000e\u0018\u0000 \u00032\u00020\u0001:\u000245B\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J;\u0010\u0012\u001a\u0004\u0018\u00010\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2%\u0010\u0011\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\fH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002JO\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182+\u0010\u0011\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\fj\u0004\u0018\u0001`\u001aH\u0002JI\u0010\u001d\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001c\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2+\u0010\u0011\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\fj\u0004\u0018\u0001`\u001aH\u0016J=\u0010\u001e\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2+\u0010\u0011\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\fj\u0004\u0018\u0001`\u001aJ\b\u0010\u001f\u001a\u00020\bH\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lih2/e;", "Li01/e;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqgamepub/data/QQGameMsgInfo;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "p", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "callback", "l", "", "g", "retCode", "", "nextRequestRawMsgId", "Lorg/json/JSONArray;", "jsonArray", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "o", "method", "call", "j", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/qqgamepub/api/IGamePubAccountMsgService;", "d", "Lcom/tencent/mobileqq/qqgamepub/api/IGamePubAccountMsgService;", "mMsgMgr", "Lih2/e$b;", "e", "Lih2/e$b;", "mGamePubAccountMsgObserver", "", "f", "Ljava/util/List;", "mMsgList", h.F, "J", "mLastRequestMsgListTime", "i", "I", "mCurrentRequestMsgListCount", "<init>", "()V", "a", "b", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e extends i01.e {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b mGamePubAccountMsgObserver;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long mLastRequestMsgListTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mCurrentRequestMsgListCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGamePubAccountMsgService mMsgMgr = (IGamePubAccountMsgService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGamePubAccountMsgService.class, "");

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<QQGameMsgInfo> mMsgList = ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).getCurrentMsgList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0007R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0007\u00a8\u0006\u0019"}, d2 = {"Lih2/e$a;", "", "", "cmd", "rawData", "a", "GET_GAME_PUBLIC_TOPIC", "Ljava/lang/String;", "GET_GAME_PUB_MSG_LIST", "KEY_SIMPLE_TOPIC_COLLECTION_DATA", "KEY_SIMPLE_TOPIC_COLLECTION_DATA_TIME", "", "MAX_REQUEST_MSG_LIST_FREQUENCY", "I", "MODULE_NAME", "ONE_SECOND_IN_MILLISECONDS", "RESULT_CODE_NO_PERMISSION", "RESULT_CODE_OK", "RESULT_CODE_PARAMS_ERROR", "RESULT_CODE_TOO_FAST", "TAG", "TRPC_GET_SIMPLE_TOPIC_COLLECTION_CMD", "TRPC_PROXY_CMD", "<init>", "()V", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ih2.e$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final String a(@NotNull String cmd, @NotNull String rawData) {
            String str;
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            Intrinsics.checkNotNullParameter(rawData, "rawData");
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("msg", new JSONObject().put("clientRPCName", cmd));
                jSONObject3.put("rawData", rawData);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("nameSpace", "");
                jSONObject4.put("serializationType", 2);
                jSONObject4.put("currentCompressType", 0);
                jSONObject4.put("compressType", 0);
                jSONObject4.put("requestType", 0);
                jSONObject4.put("connectionMode", false);
                jSONObject4.put(MosaicConstants$JsProperty.PROP_ENV, "");
                Unit unit = Unit.INSTANCE;
                jSONObject3.put("options", jSONObject4);
                jSONArray.mo162put(jSONObject3);
                jSONObject2.put("list", jSONArray);
                jSONObject.put("data", jSONObject2);
                jSONObject.put("cmd", "GDCTrpcProxy.down");
                str = jSONObject.toString();
            } catch (Exception e16) {
                QLog.e("QQPublicPlatMsgKuiklyModule", 1, "[createReqJson] error: " + e16);
                str = null;
            }
            if (QLog.isDebugVersion()) {
                QLog.i("QQPublicPlatMsgKuiklyModule", 1, "[createReqJson] ret: " + str);
            }
            return str;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\n\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0016R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lih2/e$b;", "Lhh2/a;", "Lih2/e;", "module", "", "d", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqgamepub/data/QQGameMsgInfo;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "a", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "mModuleRef", "<init>", "()V", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends hh2.a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private WeakReference<e> mModuleRef;

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(b this$0, ArrayList msgList) {
            e eVar;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(msgList, "$msgList");
            WeakReference<e> weakReference = this$0.mModuleRef;
            if (weakReference != null && (eVar = weakReference.get()) != null) {
                QLog.i("QQPublicPlatMsgKuiklyModule", 1, "[handleNewMsg] updateMessage, msgList size: " + msgList.size() + ".");
                eVar.p(msgList);
            }
        }

        @Override // hh2.a
        public void a(@NotNull final ArrayList<QQGameMsgInfo> msgList) {
            e eVar;
            Intrinsics.checkNotNullParameter(msgList, "msgList");
            super.a(msgList);
            try {
                WeakReference<e> weakReference = this.mModuleRef;
                if (weakReference != null) {
                    eVar = weakReference.get();
                } else {
                    eVar = null;
                }
                if (eVar != null) {
                    if (msgList.size() <= eVar.m()) {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ih2.f
                            @Override // java.lang.Runnable
                            public final void run() {
                                e.b.c(e.b.this, msgList);
                            }
                        });
                        return;
                    }
                    return;
                }
                QLog.e("QQPublicPlatMsgKuiklyModule", 1, "[handleNewMsg] mModuleRef or mModuleRef.get() is null.");
            } catch (Exception e16) {
                QLog.e("QQPublicPlatMsgKuiklyModule", 1, e16, new Object[0]);
            }
        }

        public final void d(@NotNull e module) {
            Intrinsics.checkNotNullParameter(module, "module");
            this.mModuleRef = new WeakReference<>(module);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016\u00a8\u0006\b"}, d2 = {"ih2/e$c", "Lcom/tencent/mobileqq/qqgamepub/nt/api/IQQGamePubMsgApi$a;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqgamepub/data/QQGameMsgInfo;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onSuccess", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements IQQGamePubMsgApi.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f407658a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f407659b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f407660c;

        c(String str, e eVar, Function1<Object, Unit> function1) {
            this.f407658a = str;
            this.f407659b = eVar;
            this.f407660c = function1;
        }

        @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi.a
        public void onSuccess(@NotNull ArrayList<QQGameMsgInfo> msgList) {
            long j3;
            Intrinsics.checkNotNullParameter(msgList, "msgList");
            if (msgList.size() > 0) {
                QQGameMsgInfo qQGameMsgInfo = msgList.get(msgList.size() - 1);
                Intrinsics.checkNotNullExpressionValue(qQGameMsgInfo, "msgList[msgList.size - 1]");
                j3 = qQGameMsgInfo.msgId;
            } else {
                j3 = 0;
            }
            this.f407659b.o(0, j3, GamePubAccountHelper.o(msgList, System.currentTimeMillis(), 0L, this.f407658a), this.f407660c);
        }
    }

    public e() {
        b bVar = new b();
        this.mGamePubAccountMsgObserver = bVar;
        bVar.d(this);
        IGamePubAccountMsgService iGamePubAccountMsgService = this.mMsgMgr;
        if (iGamePubAccountMsgService != null) {
            iGamePubAccountMsgService.addObserver(this.mGamePubAccountMsgObserver);
        }
    }

    private final boolean g() {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.mLastRequestMsgListTime;
        if (currentTimeMillis >= j3 && currentTimeMillis - j3 <= 1000) {
            int i3 = this.mCurrentRequestMsgListCount;
            if (i3 >= 5) {
                return false;
            }
            this.mCurrentRequestMsgListCount = i3 + 1;
            return true;
        }
        this.mCurrentRequestMsgListCount = 1;
        this.mLastRequestMsgListTime = System.currentTimeMillis();
        return true;
    }

    @JvmStatic
    @Nullable
    public static final String i(@NotNull String str, @NotNull String str2) {
        return INSTANCE.a(str, str2);
    }

    private final Object l(String params, Function1<Object, Unit> callback) {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(context, QMMKVFile.FILE_COMMON)");
        if (callback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("topic", fromV2.getString("key_simple_topic_data", ""));
            jSONObject.put("timestamp", fromV2.getLong("key_simple_topic_data_time", 0L));
            callback.invoke(jSONObject);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int m() {
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(int retCode, long nextRequestRawMsgId, JSONArray jsonArray, Function1<Object, Unit> callback) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", retCode);
            if (jsonArray != null) {
                jSONObject.put(TabPreloadItem.TAB_NAME_MESSAGE, jsonArray);
            }
            if (nextRequestRawMsgId != 0) {
                jSONObject.put("nextRequestRawMsgId", String.valueOf(nextRequestRawMsgId));
            }
            if (callback != null) {
                callback.invoke(jSONObject);
            }
        } catch (Throwable th5) {
            QLog.e("QQPublicPlatMsgKuiklyModule", 1, "onGetMsgList error,", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(ArrayList<QQGameMsgInfo> msgList) {
        com.tencent.kuikly.core.render.android.d O0;
        if (msgList != null && msgList.size() > 0) {
            List<QQGameMsgInfo> list = this.mMsgList;
            if (list != null) {
                list.addAll(0, msgList);
            }
            String jSONArray = GamePubAccountHelper.o(this.mMsgList, ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).getGamePubLastReadTime(), ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).getUnreadCount(), null).toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray, "getGameDataParamV2(\n    \u2026\n            ).toString()");
            HashMap hashMap = new HashMap();
            hashMap.put("gameData", jSONArray);
            hashMap.put("action", "2");
            QLog.i("GamePubAccountKuiklyModule", 1, "[mGamePubAccountMsgObserver] gameData:" + jSONArray);
            com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
            if (aVar != null && (O0 = aVar.O0()) != null) {
                O0.d("onGameFeedsEvent", hashMap);
            }
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "getGamePubMsgList")) {
            j(params, callback);
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(method, "getGamePublicTopic")) {
            return l(params, callback);
        }
        return super.call(method, params, callback);
    }

    public final void j(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        long j3;
        QLog.e("QQPublicPlatMsgKuiklyModule", 1, "Kuikly getGamePubMsgList start");
        if (TextUtils.isEmpty(params)) {
            o(-1, 0L, null, callback);
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            String rawMsgId = jSONObject.getString("rawMsgId");
            String string = jSONObject.getString("gameAppId");
            int i3 = jSONObject.getInt("count");
            if (i3 <= 0) {
                o(-1, 0L, null, callback);
                return;
            }
            if (!g()) {
                o(-3, 0L, null, callback);
                QLog.e("QQPublicPlatMsgKuiklyModule", 1, "call getGamePubMsgList two fast");
                return;
            }
            if (!TextUtils.isEmpty(rawMsgId)) {
                Intrinsics.checkNotNullExpressionValue(rawMsgId, "rawMsgId");
                j3 = Long.parseLong(rawMsgId);
            } else {
                j3 = 0;
            }
            try {
                ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).getBusinessMsgListByMsgId(j3, i3, i3 + 10, new c(string, this, callback), "kuikly");
            } catch (Exception e16) {
                e = e16;
                o(-1, 0L, null, callback);
                QLog.e("QQPublicPlatMsgKuiklyModule", 1, "getGamePubMsgList error:" + e);
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        IGamePubAccountMsgService iGamePubAccountMsgService = this.mMsgMgr;
        if (iGamePubAccountMsgService != null) {
            iGamePubAccountMsgService.deleteObserver(this.mGamePubAccountMsgObserver);
        }
    }
}
