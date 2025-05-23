package mn4;

import android.content.Context;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.v2.V2TIMAdvancedMsgListener;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMSDKConfig;
import com.tencent.imsdk.v2.V2TIMSDKListener;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.timi.game.env.ServerEnv;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.UStringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import trpc.yes.common.MessageOuterClass$TimMsgBody;
import trpc.yes.common.TcloudServerOuterClass$GetUserTCloudSignRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\b\b*\u0001F\u0018\u0000 L2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\bJ\u0010KJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001aH\u0016J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010#\u001a\u00020\bH\u0016J\u0012\u0010&\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016J\u0018\u0010*\u001a\u00020\u00042\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(H\u0016J\b\u0010+\u001a\u00020\u0004H\u0016R\u0016\u0010.\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\"\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0016028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\"\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0016028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001a088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020$0?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006M"}, d2 = {"Lmn4/b;", "Lkn4/b;", "Lcom/tencent/imsdk/v2/V2TIMSDKListener;", "listener", "", "V3", "U3", "c4", "", "Z3", "Y3", "X3", "b4", "", "errorCode", "", "errorMessage", ICustomDataEditor.STRING_ARRAY_PARAM_4, "Lln4/b;", "V1", "", "yesUid", "Lcom/tencent/timi/game/tim/api/message/c;", BdhLogUtil.LogTag.Tag_Conn, "groupId", "M", "Lcom/tencent/timi/game/tim/api/message/d;", "r0", "q2", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "timMsgBody", "q3", "Landroid/content/Context;", "context", "init", "isLoaded", "Lkn4/a;", "callback", "T1", "logout", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/TcloudServerOuterClass$GetUserTCloudSignRsp;", "O", "o2", "a", "Ljava/lang/String;", "imSdkSoPath", "b", "Lln4/b;", "groupManager", "", "c", "Ljava/util/Map;", "mapC2CMessageManager", "d", "mapGroupMessageManager", "Ljava/util/concurrent/CopyOnWriteArrayList;", "e", "Ljava/util/concurrent/CopyOnWriteArrayList;", "msgListeners", "f", "Z", "isLogining", "", "g", "Ljava/util/List;", "loginCallbacks", tl.h.F, "Ltrpc/yes/common/TcloudServerOuterClass$GetUserTCloudSignRsp;", "userSign", "mn4/b$g", "i", "Lmn4/b$g;", "msgListener", "<init>", "()V", "j", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b implements kn4.b {

    /* renamed from: k, reason: collision with root package name */
    private static boolean f417050k;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ln4.b groupManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isLogining;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String imSdkSoPath = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Long, com.tencent.timi.game.tim.api.message.c> mapC2CMessageManager = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Long, com.tencent.timi.game.tim.api.message.c> mapGroupMessageManager = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CopyOnWriteArrayList<com.tencent.timi.game.tim.api.message.d> msgListeners = new CopyOnWriteArrayList<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<kn4.a> loginCallbacks = new ArrayList();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TcloudServerOuterClass$GetUserTCloudSignRsp userSign = new TcloudServerOuterClass$GetUserTCloudSignRsp();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private g msgListener = new g();

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"mn4/b$b", "Lpl4/d;", "Ltrpc/yes/common/TcloudServerOuterClass$GetUserTCloudSignRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: mn4.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C10797b implements pl4.d<TcloudServerOuterClass$GetUserTCloudSignRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<TcloudServerOuterClass$GetUserTCloudSignRsp> f417060a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f417061b;

        C10797b(IResultListener<TcloudServerOuterClass$GetUserTCloudSignRsp> iResultListener, b bVar) {
            this.f417060a = iResultListener;
            this.f417061b = bVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable TcloudServerOuterClass$GetUserTCloudSignRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            IResultListener<TcloudServerOuterClass$GetUserTCloudSignRsp> iResultListener = this.f417060a;
            if (iResultListener != null) {
                iResultListener.onError(timiErrCode, timiErrMsg);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable TcloudServerOuterClass$GetUserTCloudSignRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            if (response != null) {
                this.f417061b.userSign = response;
            }
            IResultListener<TcloudServerOuterClass$GetUserTCloudSignRsp> iResultListener = this.f417060a;
            if (iResultListener != null) {
                iResultListener.onSuccess(response);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"mn4/b$c", "Lcom/tencent/imsdk/v2/V2TIMCallback;", "", "onSuccess", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements V2TIMCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f417062a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f417063b;

        c(String str, b bVar) {
            this.f417062a = str;
            this.f417063b = bVar;
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onError(int errorCode, @Nullable String errorMessage) {
            l.i("TimManager", "errorCode = [" + errorCode + "], p1 = [" + errorMessage + "]");
            this.f417063b.a4(errorCode, errorMessage);
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onSuccess() {
            l.i("TimManager", "login suc " + this.f417062a);
            this.f417063b.b4();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"mn4/b$d", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/TcloudServerOuterClass$GetUserTCloudSignRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements IResultListener<TcloudServerOuterClass$GetUserTCloudSignRsp> {
        d() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable TcloudServerOuterClass$GetUserTCloudSignRsp result) {
            l.i("TimManager", "internalLogin getUserSig suc");
            if (result != null) {
                b.this.userSign = result;
            }
            b.this.X3();
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            l.i("TimManager", "internalLogin getUserSig suc fail p0 = [" + errorCode + "], p1 = [" + errorMessage + "]");
            b.this.a4(errorCode, errorMessage);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"mn4/b$f", "Lcom/tencent/imsdk/v2/V2TIMCallback;", "", "onSuccess", "", "p0", "", "p1", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements V2TIMCallback {
        f() {
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onError(int p06, @Nullable String p16) {
            l.b("TimManager", "logout error, errorCode[" + p06 + "] errMsg[" + p16 + "]");
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onSuccess() {
            l.b("TimManager", "logout success");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"mn4/b$g", "Lcom/tencent/imsdk/v2/V2TIMAdvancedMsgListener;", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "msg", "", "onRecvNewMessage", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class g extends V2TIMAdvancedMsgListener {
        g() {
        }

        @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
        public void onRecvNewMessage(@NotNull V2TIMMessage msg2) {
            boolean isBlank;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            super.onRecvNewMessage(msg2);
            String groupID = msg2.getGroupID();
            Intrinsics.checkNotNullExpressionValue(groupID, "msg.groupID");
            isBlank = StringsKt__StringsJVMKt.isBlank(groupID);
            if (!isBlank) {
                String groupID2 = msg2.getGroupID();
                Intrinsics.checkNotNullExpressionValue(groupID2, "msg.groupID");
                if (UStringsKt.toULongOrNull(groupID2) == null) {
                    return;
                }
            }
            Iterator it = b.this.msgListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.timi.game.tim.api.message.d) it.next()).c(new pn4.g(msg2));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"mn4/b$h", "Lcom/tencent/imsdk/v2/V2TIMValueCallback;", "", "o", "", "onSuccess", "", "code", "", "desc", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class h implements V2TIMValueCallback<Object> {
        h() {
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onError(int code, @NotNull String desc) {
            Intrinsics.checkNotNullParameter(desc, "desc");
            l.i("TimManager", "setBuildInfo code:" + code + " desc:" + desc);
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onSuccess(@Nullable Object o16) {
            l.i("TimManager", "setBuildInfo success, " + o16);
        }
    }

    private final void U3(V2TIMSDKListener listener) {
        BaseManager.getInstance().setLibraryPath(this.imSdkSoPath);
        c4();
        V2TIMManager.getInstance().initSDK(BaseApplication.getContext(), ServerEnv.a().c(), new V2TIMSDKConfig(), listener);
    }

    private final void V3(final V2TIMSDKListener listener) {
        CharSequence trim;
        if (!BaseManager.getInstance().isInited()) {
            if (f417050k) {
                U3(listener);
                return;
            }
            String soVer = SoLoadManager.getInstance().getSoVer(SoLoadConstants.SONAME_IMSDK);
            if (soVer == null) {
                soVer = "";
            }
            boolean z16 = true;
            l.h("TimManager", 1, "load ImSDK so, version:" + soVer);
            if (soVer.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                trim = StringsKt__StringsKt.trim((CharSequence) soVer);
                if (nn4.b.a(trim.toString(), "5.7.1451") < 0) {
                    l.e("TimManager", "soVer:" + soVer + " too old, TARGET_IM_SDK_VERSION:5.7.1451");
                    if (listener != null) {
                        listener.onConnectFailed(-1, "load so failed");
                        return;
                    }
                    return;
                }
            }
            SoLoadManager.getInstance().load(SoLoadConstants.SONAME_IMSDK, new OnLoadListener() { // from class: mn4.a
                @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
                public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                    b.W3(b.this, listener, i3, loadExtResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W3(b this$0, V2TIMSDKListener v2TIMSDKListener, int i3, LoadExtResult loadExtResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l.h("TimManager", 1, "load so, code[" + i3 + "], result[" + loadExtResult + "]");
        if (i3 == 0 && loadExtResult.isSucc()) {
            String parent = new File(loadExtResult.getSoLoadPath()).getParent();
            Intrinsics.checkNotNullExpressionValue(parent, "File(result.soLoadPath).parent");
            this$0.imSdkSoPath = parent;
            f417050k = true;
            this$0.U3(v2TIMSDKListener);
            return;
        }
        if (v2TIMSDKListener != null) {
            v2TIMSDKListener.onConnectFailed(i3, "load so failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X3() {
        l.b("TimManager", "internalDirectLogin");
        String i3 = com.tencent.timi.game.utils.b.i(this.userSign.current_uid.get());
        if (V2TIMManager.getInstance().getLoginStatus() == 1 && Intrinsics.areEqual(V2TIMManager.getInstance().getLoginUser(), i3)) {
            l.b("TimManager", "internalDirectLogin direct suc");
            b4();
            return;
        }
        String str = this.userSign.im_sign.get();
        l.i("TimManager", "login yesUid[" + i3 + "], sig[" + str + "]");
        V2TIMManager.getInstance().login(i3, str, new c(i3, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y3() {
        if (!Z3()) {
            l.i("TimManager", "internalLogin getUserSig begin");
            O(new d());
        } else {
            X3();
        }
    }

    private final boolean Z3() {
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        boolean isBlank4;
        String str = this.userSign.im_sign.get();
        Intrinsics.checkNotNullExpressionValue(str, "userSign.im_sign.get()");
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (!isBlank) {
            String str2 = this.userSign.trtc_sign.get();
            Intrinsics.checkNotNullExpressionValue(str2, "userSign.trtc_sign.get()");
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
            if (!isBlank2) {
                String str3 = this.userSign.live_trtc_sign.get();
                Intrinsics.checkNotNullExpressionValue(str3, "userSign.live_trtc_sign.get()");
                isBlank3 = StringsKt__StringsJVMKt.isBlank(str3);
                if (!isBlank3) {
                    String str4 = this.userSign.user_id_im_sign.get();
                    Intrinsics.checkNotNullExpressionValue(str4, "userSign.user_id_im_sign.get()");
                    isBlank4 = StringsKt__StringsJVMKt.isBlank(str4);
                    if ((!isBlank4) && (this.userSign.expire_time.get() * 1000) - yn4.d.d() < 3600000) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a4(int errorCode, String errorMessage) {
        this.isLogining = false;
        Iterator<T> it = this.loginCallbacks.iterator();
        while (it.hasNext()) {
            ((kn4.a) it.next()).onError(errorCode, errorMessage);
        }
        this.loginCallbacks.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b4() {
        this.isLogining = false;
        Iterator<T> it = this.loginCallbacks.iterator();
        while (it.hasNext()) {
            ((kn4.a) it.next()).onSuccess();
        }
        this.loginCallbacks.clear();
    }

    private final void c4() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("buildModel", DeviceInfoMonitor.getModel());
            V2TIMManager.getInstance().callExperimentalAPI("setBuildInfo", jSONObject.toString(), new h());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // kn4.b
    @NotNull
    public com.tencent.timi.game.tim.api.message.c C(long yesUid) {
        if (this.mapC2CMessageManager.get(Long.valueOf(yesUid)) == null) {
            this.mapC2CMessageManager.put(Long.valueOf(yesUid), new pn4.c(nn4.a.a(yesUid)));
        }
        com.tencent.timi.game.tim.api.message.c cVar = this.mapC2CMessageManager.get(Long.valueOf(yesUid));
        Intrinsics.checkNotNull(cVar);
        return cVar;
    }

    @Override // kn4.b
    @NotNull
    public com.tencent.timi.game.tim.api.message.c M(long groupId) {
        if (this.mapGroupMessageManager.get(Long.valueOf(groupId)) == null) {
            this.mapGroupMessageManager.put(Long.valueOf(groupId), new pn4.d(nn4.a.a(groupId)));
        }
        com.tencent.timi.game.tim.api.message.c cVar = this.mapGroupMessageManager.get(Long.valueOf(groupId));
        Intrinsics.checkNotNull(cVar);
        return cVar;
    }

    @Override // kn4.b
    public void O(@Nullable IResultListener<TcloudServerOuterClass$GetUserTCloudSignRsp> callback) {
        if (Z3()) {
            if (callback != null) {
                callback.onSuccess(this.userSign);
                return;
            }
            return;
        }
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(n45.a.INSTANCE.a(), TcloudServerOuterClass$GetUserTCloudSignRsp.class, new C10797b(callback, this));
    }

    @Override // kn4.b
    public void T1(@Nullable kn4.a callback) {
        l.b("TimManager", "login");
        if (callback != null) {
            this.loginCallbacks.add(callback);
        }
        if (this.isLogining) {
            return;
        }
        this.isLogining = true;
        if (!BaseManager.getInstance().isInited()) {
            V3(new e());
        } else {
            Y3();
        }
    }

    @Override // kn4.b
    @NotNull
    public ln4.b V1() {
        if (this.groupManager == null) {
            this.groupManager = new on4.a();
        }
        ln4.b bVar = this.groupManager;
        Intrinsics.checkNotNull(bVar);
        return bVar;
    }

    @Override // mm4.a
    public void init(@Nullable Context context) {
        V1();
    }

    @Override // kn4.b
    public boolean isLoaded() {
        return f417050k;
    }

    @Override // kn4.b
    public void logout() {
        this.userSign = new TcloudServerOuterClass$GetUserTCloudSignRsp();
        V2TIMManager.getInstance().logout(new f());
    }

    @Override // kn4.b
    public void q2(@NotNull com.tencent.timi.game.tim.api.message.d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.msgListeners.remove(listener);
        if (this.msgListeners.isEmpty()) {
            V2TIMManager.getMessageManager().removeAdvancedMsgListener(this.msgListener);
        }
    }

    @Override // kn4.b
    public void q3(@NotNull String groupId, @NotNull MessageOuterClass$TimMsgBody timMsgBody) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(timMsgBody, "timMsgBody");
        if (UStringsKt.toULongOrNull(groupId) == null) {
            return;
        }
        Iterator<T> it = this.msgListeners.iterator();
        while (it.hasNext()) {
            ((com.tencent.timi.game.tim.api.message.d) it.next()).a(UStringsKt.toULong(groupId), timMsgBody);
        }
    }

    @Override // kn4.b
    public void r0(@NotNull com.tencent.timi.game.tim.api.message.d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.msgListeners.isEmpty()) {
            V2TIMManager.getMessageManager().addAdvancedMsgListener(this.msgListener);
        }
        if (!this.msgListeners.contains(listener)) {
            this.msgListeners.add(listener);
        }
    }

    @Override // mm4.a
    public void o2() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"mn4/b$e", "Lcom/tencent/imsdk/v2/V2TIMSDKListener;", "", "onConnectSuccess", "", "code", "", "error", "onConnectFailed", "onKickedOffline", "Lcom/tencent/imsdk/v2/V2TIMUserFullInfo;", "info", "onSelfInfoUpdated", "onUserSigExpired", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e extends V2TIMSDKListener {
        e() {
        }

        @Override // com.tencent.imsdk.v2.V2TIMSDKListener
        public void onConnectFailed(int code, @Nullable String error) {
            super.onConnectFailed(code, error);
            l.b("TimManager", "onConnectFailed");
            b.this.a4(code, error);
        }

        @Override // com.tencent.imsdk.v2.V2TIMSDKListener
        public void onConnectSuccess() {
            super.onConnectSuccess();
            l.b("TimManager", "onConnectSuccess");
            b.this.Y3();
        }

        @Override // com.tencent.imsdk.v2.V2TIMSDKListener
        public void onKickedOffline() {
            super.onKickedOffline();
            l.b("TimManager", "onKickedOffline");
        }

        @Override // com.tencent.imsdk.v2.V2TIMSDKListener
        public void onSelfInfoUpdated(@Nullable V2TIMUserFullInfo info) {
            super.onSelfInfoUpdated(info);
            l.b("TimManager", "onSelfInfoUpdated");
        }

        @Override // com.tencent.imsdk.v2.V2TIMSDKListener
        public void onUserSigExpired() {
            l.b("TimManager", "onUserSigExpired");
            b bVar = b.this;
            bVar.O(new a(bVar));
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"mn4/b$e$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/TcloudServerOuterClass$GetUserTCloudSignRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes26.dex */
        public static final class a implements IResultListener<TcloudServerOuterClass$GetUserTCloudSignRsp> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f417066a;

            a(b bVar) {
                this.f417066a = bVar;
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@Nullable TcloudServerOuterClass$GetUserTCloudSignRsp result) {
                if (result != null) {
                    this.f417066a.userSign = result;
                }
                this.f417066a.T1(null);
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int errorCode, @Nullable String errorMessage) {
            }
        }
    }
}
