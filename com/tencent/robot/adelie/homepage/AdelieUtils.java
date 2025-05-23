package com.tencent.robot.adelie.homepage;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.AiAvatarInfo;
import com.tencent.qqnt.kernel.nativeinterface.AiGenAvatarReq;
import com.tencent.qqnt.kernel.nativeinterface.AiGenBotInfoOperationType;
import com.tencent.qqnt.kernel.nativeinterface.AiGenBotInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.ChangeMyBotOperationType;
import com.tencent.qqnt.kernel.nativeinterface.ChangeMyBotReq;
import com.tencent.qqnt.kernel.nativeinterface.FetchUgcSettingReq;
import com.tencent.qqnt.kernel.nativeinterface.IAiGenAvatarCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchMyRobotListsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchRobotRecommendCardsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchUgcSettingCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMyBotInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MyBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.MyRobotsListReq;
import com.tencent.qqnt.kernel.nativeinterface.MyRobotsListRsp;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardsReq;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardsRsp;
import com.tencent.qqnt.kernel.nativeinterface.UgcSettingInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.robot.adelie.homepage.AdelieUtils;
import com.tencent.widget.immersive.SystemBarTintManager;
import java.util.ArrayList;
import java.util.Map;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x14.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001WB\t\b\u0002\u00a2\u0006\u0004\bU\u0010VJS\u0010\r\u001a\u00020\u000b2K\u0010\f\u001aG\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0002J{\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122K\u0010\f\u001aG\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000b0\u0002JB\u0010\u001a\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00122 \u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u000b0\u0002J\u0006\u0010\u001b\u001a\u00020\u000bJ>\u0010\u001e\u001a\u00020\u000b26\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000b0\u001cJc\u0010#\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2K\u0010\f\u001aG\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u000b0\u0002Jk\u0010&\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!2\u0006\u0010%\u001a\u00020\u00072K\u0010\f\u001aG\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u000b0\u0002J,\u0010+\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010\u00072\b\u0010)\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010*J*\u0010.\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010-\u001a\u00020,Jc\u00101\u001a\u00020\u000b2\u0006\u00100\u001a\u00020/2\u0006\u0010 \u001a\u00020\u001f2K\u0010\f\u001aG\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u000b0\u0002J[\u00104\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u00072K\u0010\f\u001aG\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u000b0\u0002J\u001b\u00107\u001a\u0002062\u0006\u00105\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b7\u00108J\u000e\u0010;\u001a\u00020\u00122\u0006\u0010:\u001a\u000209J\u0016\u0010?\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020\u0003J\b\u0010A\u001a\u0004\u0018\u00010@J\u000e\u0010D\u001a\u00020\u00032\u0006\u0010C\u001a\u00020BJ\u000e\u0010E\u001a\u00020\u00122\u0006\u0010C\u001a\u00020BJE\u0010K\u001a\u00020\u000b2\u0016\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\u000e0Fj\b\u0012\u0004\u0012\u00020\u000e`G2%\u0010J\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010IJ*\u0010Q\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u00032\b\u0010M\u001a\u0004\u0018\u00010\u00072\b\u0010O\u001a\u0004\u0018\u00010N2\u0006\u0010P\u001a\u00020\u0012J\u000e\u0010T\u001a\u00020\u00122\u0006\u0010S\u001a\u00020R\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006X"}, d2 = {"Lcom/tencent/robot/adelie/homepage/AdelieUtils;", "", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/UgcSettingInfo;", "ugcSetting", "", "cb", "K", "", "pagingCookie", "dataVersion", "tabId", "", "queryTab", "isLocal", "success", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotRecommendCardsRsp;", "rsp", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/MyRobotsListRsp;", "U", "X", "Lkotlin/Function2;", "errCode", "E", "Lcom/tencent/qqnt/kernel/nativeinterface/MyBotInfo;", "botInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/AiGenBotInfoOperationType;", "genType", "b0", "botName", "templateId", "c0", "myBotInfo", "page", "source", "Lcom/tencent/qqnt/kernel/nativeinterface/IAiGenAvatarCallback;", "v", "", "loadPicStartTime", "a0", "Lcom/tencent/qqnt/kernel/nativeinterface/ChangeMyBotOperationType;", "type", "B", "path", "url", "j0", "imagePath", "Lcom/tencent/robot/adelie/homepage/AdelieUtils$a;", "i0", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "c", BdhLogUtil.LogTag.Tag_Req, "", "src", "maxLengthFullwidth", "h0", "Lcom/tencent/qqnt/kernel/api/ac;", "O", "Landroid/view/View;", "view", "N", ExifInterface.LATITUDE_SOUTH, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "byteArrayList", "Lkotlin/Function1;", "callback", "y", "chatType", "peerUid", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "front", "P", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "T", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AdelieUtils f365929a = new AdelieUtils();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/robot/adelie/homepage/AdelieUtils$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "url", "I", "()I", "errCode", "c", "getErrMsg", "errMsg", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.AdelieUtils$a, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class UploadResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String url;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int errCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String errMsg;

        public UploadResult(@NotNull String url, int i3, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.url = url;
            this.errCode = i3;
            this.errMsg = errMsg;
        }

        /* renamed from: a, reason: from getter */
        public final int getErrCode() {
            return this.errCode;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UploadResult)) {
                return false;
            }
            UploadResult uploadResult = (UploadResult) other;
            if (Intrinsics.areEqual(this.url, uploadResult.url) && this.errCode == uploadResult.errCode && Intrinsics.areEqual(this.errMsg, uploadResult.errMsg)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.url.hashCode() * 31) + this.errCode) * 31) + this.errMsg.hashCode();
        }

        @NotNull
        public String toString() {
            return "UploadResult(url=" + this.url + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/robot/adelie/homepage/AdelieUtils$b", "Lx14/a;", "", "data", "", "a", "", "errCode", "errMsg", "onFail", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements x14.a<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<Integer, String, String, Unit> f365933a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function3<? super Integer, ? super String, ? super String, Unit> function3) {
            this.f365933a = function3;
        }

        @Override // x14.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull String data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.f365933a.invoke(0, "", data);
        }

        @Override // x14.a
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f365933a.invoke(Integer.valueOf(errCode), errMsg, "");
        }
    }

    AdelieUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(final Function1 function1, final int i3, String str) {
        QLog.i("AdelieUtils-RobotStory", 1, "backFlowRobotCoreInfos callback result:" + i3 + ", errMsg:" + str);
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.AdelieUtils$backFlowRobotCoreInfos$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function1<Object, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(Integer.valueOf(i3));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(ChangeMyBotOperationType type, MyBotInfo botInfo, final Function3 cb5) {
        Intrinsics.checkNotNullParameter(type, "$type");
        Intrinsics.checkNotNullParameter(botInfo, "$botInfo");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("AdelieUtils-RobotStory", 1, "changeMyBot start type:" + type);
        ChangeMyBotReq changeMyBotReq = new ChangeMyBotReq();
        changeMyBotReq.myBotInfo = botInfo;
        changeMyBotReq.operationType = type;
        ac O = f365929a.O();
        if (O != null) {
            O.changeMyBot(changeMyBotReq, new IMyBotInfoCallback() { // from class: com.tencent.robot.adelie.homepage.j
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMyBotInfoCallback
                public final void onResult(int i3, String str, MyBotInfo myBotInfo) {
                    AdelieUtils.D(Function3.this, i3, str, myBotInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(final Function3 cb5, final int i3, final String str, final MyBotInfo myBotInfo) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("AdelieUtils-RobotStory", 1, "changeMyBot callback result:" + i3 + ", errMsg:" + str);
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.AdelieUtils$changeMyBot$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function3<Integer, String, MyBotInfo, Unit> function3 = cb5;
                Integer valueOf = Integer.valueOf(i3);
                String errMsg = str;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                MyBotInfo myBotInfo2 = myBotInfo;
                Intrinsics.checkNotNullExpressionValue(myBotInfo2, "myBotInfo");
                function3.invoke(valueOf, errMsg, myBotInfo2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(final Function2 cb5) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        ac O = f365929a.O();
        if (O != null) {
            O.checkMyBotNum(new IOperateCallback() { // from class: com.tencent.robot.adelie.homepage.q
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    AdelieUtils.G(Function2.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(final Function2 cb5, final int i3, final String str) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("AdelieUtils-RobotStory", 1, "checkMyBotNum callback result:" + i3 + ", errMsg:" + str);
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.AdelieUtils$checkMyBotNum$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function2<Integer, String, Unit> function2 = cb5;
                Integer valueOf = Integer.valueOf(i3);
                String errMsg = str;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                function2.invoke(valueOf, errMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(boolean z16, String tabId, RobotRecommendCardsReq req, final Function3 cb5) {
        Intrinsics.checkNotNullParameter(tabId, "$tabId");
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("AdelieUtils-RobotStory", 1, "fetchRobotRecommendCards start isLocal:" + z16 + " tabId:" + tabId);
        ac O = f365929a.O();
        if (O != null) {
            O.fetchMobileRobotRecommendCards(req, new IFetchRobotRecommendCardsCallback() { // from class: com.tencent.robot.adelie.homepage.o
                @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchRobotRecommendCardsCallback
                public final void onResult(int i3, String str, RobotRecommendCardsRsp robotRecommendCardsRsp) {
                    AdelieUtils.J(Function3.this, i3, str, robotRecommendCardsRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(final Function3 cb5, final int i3, final String str, final RobotRecommendCardsRsp robotRecommendCardsRsp) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("AdelieUtils-RobotStory", 1, "fetchMobileRobotRecommendCards callback result:" + i3 + ", errMsg:" + str);
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.AdelieUtils$fetchMobileRobotRecommendCards$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function3<Boolean, String, RobotRecommendCardsRsp, Unit> function3 = cb5;
                Boolean valueOf = Boolean.valueOf(i3 == 0);
                String errMsg = str;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                RobotRecommendCardsRsp robotCardRsp = robotRecommendCardsRsp;
                Intrinsics.checkNotNullExpressionValue(robotCardRsp, "robotCardRsp");
                function3.invoke(valueOf, errMsg, robotCardRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(FetchUgcSettingReq req, final Function3 cb5) {
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("AdelieUtils-RobotStory", 1, "fetchUgcSetting start");
        ac O = f365929a.O();
        if (O != null) {
            O.fetchUgcSetting(req, new IFetchUgcSettingCallback() { // from class: com.tencent.robot.adelie.homepage.t
                @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchUgcSettingCallback
                public final void onResult(int i3, String str, UgcSettingInfo ugcSettingInfo) {
                    AdelieUtils.M(Function3.this, i3, str, ugcSettingInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Function3 cb5, int i3, String errMsg, UgcSettingInfo ugcSettingInfo) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Integer valueOf = Integer.valueOf(i3);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        Intrinsics.checkNotNullExpressionValue(ugcSettingInfo, "ugcSettingInfo");
        cb5.invoke(valueOf, errMsg, ugcSettingInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(int i3, String str) {
        QLog.i("AdelieUtils-RobotStory", 1, "[insertNtLocalRecordMsg] result " + i3 + " errMsg " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(byte[] bArr, String dataVersion, boolean z16, final Function3 cb5) {
        boolean z17;
        Intrinsics.checkNotNullParameter(dataVersion, "$dataVersion");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        if (bArr == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.i("AdelieUtils-RobotStory", 1, "queryMyBots isFirstPage:" + z17);
        MyRobotsListReq myRobotsListReq = new MyRobotsListReq();
        myRobotsListReq.pagingCookie = bArr;
        myRobotsListReq.dataVersion = dataVersion;
        myRobotsListReq.isLocal = z16;
        ac O = f365929a.O();
        if (O != null) {
            O.fetchMyRobotLists(myRobotsListReq, new IFetchMyRobotListsCallback() { // from class: com.tencent.robot.adelie.homepage.y
                @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchMyRobotListsCallback
                public final void onResult(int i3, String str, MyRobotsListRsp myRobotsListRsp) {
                    AdelieUtils.W(Function3.this, i3, str, myRobotsListRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(final Function3 cb5, final int i3, final String str, final MyRobotsListRsp myRobotsListRsp) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.AdelieUtils$queryMyBots$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function3<Integer, String, MyRobotsListRsp, Unit> function3 = cb5;
                Integer valueOf = Integer.valueOf(i3);
                String errMsg = str;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                function3.invoke(valueOf, errMsg, myRobotsListRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y() {
        QLog.i("AdelieUtils-RobotStory", 1, "removeAllRecommendCache start");
        ac O = f365929a.O();
        if (O != null) {
            O.removeAllRecommendCache(new IOperateCallback() { // from class: com.tencent.robot.adelie.homepage.v
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    AdelieUtils.Z(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(int i3, String str) {
        QLog.i("AdelieUtils-RobotStory", 1, "removeAllRecommendCache callback result:" + i3 + ", errMsg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(MyBotInfo botInfo, AiGenBotInfoOperationType genType, final Function3 cb5) {
        Intrinsics.checkNotNullParameter(botInfo, "$botInfo");
        Intrinsics.checkNotNullParameter(genType, "$genType");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("AdelieUtils-RobotStory", 1, "requestAIGenerateBotInfo start");
        AiGenBotInfoReq aiGenBotInfoReq = new AiGenBotInfoReq();
        aiGenBotInfoReq.myBotInfo = botInfo;
        aiGenBotInfoReq.genType = genType;
        ac O = f365929a.O();
        if (O != null) {
            O.aiGenBotInfo(aiGenBotInfoReq, new IMyBotInfoCallback() { // from class: com.tencent.robot.adelie.homepage.r
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMyBotInfoCallback
                public final void onResult(int i3, String str, MyBotInfo myBotInfo) {
                    AdelieUtils.e0(Function3.this, i3, str, myBotInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(final Function3 cb5, final int i3, final String str, final MyBotInfo myBotInfo) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("AdelieUtils-RobotStory", 1, "requestAIGenerateBotInfo callback result:" + i3 + ", errMsg:" + str);
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.AdelieUtils$requestAIGenerateBotInfo$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function3<Integer, String, MyBotInfo, Unit> function3 = cb5;
                Integer valueOf = Integer.valueOf(i3);
                String errMsg = str;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                MyBotInfo myBotInfo2 = myBotInfo;
                Intrinsics.checkNotNullExpressionValue(myBotInfo2, "myBotInfo");
                function3.invoke(valueOf, errMsg, myBotInfo2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(AiGenBotInfoOperationType genType, String templateId, String botName, final Function3 cb5) {
        Intrinsics.checkNotNullParameter(genType, "$genType");
        Intrinsics.checkNotNullParameter(templateId, "$templateId");
        Intrinsics.checkNotNullParameter(botName, "$botName");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("AdelieUtils-RobotStory", 1, "requestAIGenerateBotInfo start");
        AiGenBotInfoReq aiGenBotInfoReq = new AiGenBotInfoReq();
        MyBotInfo myBotInfo = new MyBotInfo();
        myBotInfo.botName = botName;
        aiGenBotInfoReq.myBotInfo = myBotInfo;
        aiGenBotInfoReq.genType = genType;
        aiGenBotInfoReq.botTemplate = templateId;
        ac O = f365929a.O();
        if (O != null) {
            O.aiGenBotInfo(aiGenBotInfoReq, new IMyBotInfoCallback() { // from class: com.tencent.robot.adelie.homepage.ab
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMyBotInfoCallback
                public final void onResult(int i3, String str, MyBotInfo myBotInfo2) {
                    AdelieUtils.g0(Function3.this, i3, str, myBotInfo2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(final Function3 cb5, final int i3, final String str, final MyBotInfo myBotInfo) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("AdelieUtils-RobotStory", 1, "requestAIGenerateBotInfo callback result:" + i3 + ", errMsg:" + str);
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.AdelieUtils$requestAIGenerateBotInfo$2$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function3<Integer, String, MyBotInfo, Unit> function3 = cb5;
                Integer valueOf = Integer.valueOf(i3);
                String errMsg = str;
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                MyBotInfo myBotInfo2 = myBotInfo;
                Intrinsics.checkNotNullExpressionValue(myBotInfo2, "myBotInfo");
                function3.invoke(valueOf, errMsg, myBotInfo2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(MyBotInfo myBotInfo, final String str, final String str2, final IAiGenAvatarCallback iAiGenAvatarCallback) {
        Intrinsics.checkNotNullParameter(myBotInfo, "$myBotInfo");
        QLog.i("AdelieUtils-RobotStory", 1, "aiGenAvatar");
        final long currentTimeMillis = System.currentTimeMillis();
        AiGenAvatarReq aiGenAvatarReq = new AiGenAvatarReq();
        aiGenAvatarReq.avatarNum = 1;
        aiGenAvatarReq.myBotInfo = myBotInfo;
        ac O = f365929a.O();
        if (O != null) {
            O.aiGenAvatar(aiGenAvatarReq, new IAiGenAvatarCallback() { // from class: com.tencent.robot.adelie.homepage.k
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAiGenAvatarCallback
                public final void onResult(int i3, String str3, AiAvatarInfo aiAvatarInfo) {
                    AdelieUtils.x(currentTimeMillis, str, str2, iAiGenAvatarCallback, i3, str3, aiAvatarInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(long j3, String str, String str2, final IAiGenAvatarCallback iAiGenAvatarCallback, final int i3, final String str3, final AiAvatarInfo aiAvatarInfo) {
        Map mapOf;
        long currentTimeMillis = System.currentTimeMillis() - j3;
        QLog.i("AdelieUtils-RobotStory", 1, "aiGenAvatar callback result:" + i3 + ", errMsg:" + str3 + ", cost=" + currentTimeMillis);
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.AdelieUtils$aiGenAvatar$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IAiGenAvatarCallback iAiGenAvatarCallback2 = IAiGenAvatarCallback.this;
                if (iAiGenAvatarCallback2 != null) {
                    iAiGenAvatarCallback2.onResult(i3, str3, aiAvatarInfo);
                }
            }
        });
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("error_code", String.valueOf(i3)), TuplesKt.to("error_msg", str3), TuplesKt.to("cost_time", String.valueOf(currentTimeMillis)), TuplesKt.to("page_id", String.valueOf(str)), TuplesKt.to("source", String.valueOf(str2)));
        com.tencent.robot.adelie.homepage.utils.d.c(null, "adelie_creation_ai_generate_avatar", mapOf, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ArrayList byteArrayList, final Function1 function1) {
        Intrinsics.checkNotNullParameter(byteArrayList, "$byteArrayList");
        QLog.i("AdelieUtils-RobotStory", 1, "backFlowRobotCoreInfos start");
        ac O = f365929a.O();
        if (O != null) {
            O.backFlowRobotCoreInfos(byteArrayList, new IOperateCallback() { // from class: com.tencent.robot.adelie.homepage.u
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    AdelieUtils.A(Function1.this, i3, str);
                }
            });
        }
    }

    public final void B(@NotNull final ChangeMyBotOperationType type, @NotNull final MyBotInfo botInfo, @NotNull final Function3<? super Integer, ? super String, ? super MyBotInfo, Unit> cb5) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(botInfo, "botInfo");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.x
            @Override // java.lang.Runnable
            public final void run() {
                AdelieUtils.C(ChangeMyBotOperationType.this, botInfo, cb5);
            }
        }, 128, null, true);
    }

    public final void E(@NotNull final Function2<? super Integer, ? super String, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.p
            @Override // java.lang.Runnable
            public final void run() {
                AdelieUtils.F(Function2.this);
            }
        }, 128, null, true);
    }

    public final void H(@NotNull byte[] pagingCookie, @NotNull String dataVersion, @NotNull final String tabId, boolean queryTab, final boolean isLocal, @NotNull final Function3<? super Boolean, ? super String, ? super RobotRecommendCardsRsp, Unit> cb5) {
        Intrinsics.checkNotNullParameter(pagingCookie, "pagingCookie");
        Intrinsics.checkNotNullParameter(dataVersion, "dataVersion");
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        final RobotRecommendCardsReq robotRecommendCardsReq = new RobotRecommendCardsReq();
        robotRecommendCardsReq.pagingCookie = pagingCookie;
        robotRecommendCardsReq.dataVersion = dataVersion;
        robotRecommendCardsReq.tabId = tabId;
        robotRecommendCardsReq.queryTab = queryTab;
        robotRecommendCardsReq.isLocal = isLocal;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.i
            @Override // java.lang.Runnable
            public final void run() {
                AdelieUtils.I(isLocal, tabId, robotRecommendCardsReq, cb5);
            }
        }, 128, null, true);
    }

    public final void K(@NotNull final Function3<? super Integer, ? super String, ? super UgcSettingInfo, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        final FetchUgcSettingReq fetchUgcSettingReq = new FetchUgcSettingReq();
        fetchUgcSettingReq.FilterTtsList = 1;
        fetchUgcSettingReq.FilterLabels = 1;
        fetchUgcSettingReq.FilterPromptMaxLength = 1;
        fetchUgcSettingReq.FilterRecycle = 1;
        fetchUgcSettingReq.FilterConversation = 1;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.l
            @Override // java.lang.Runnable
            public final void run() {
                AdelieUtils.L(FetchUgcSettingReq.this, cb5);
            }
        }, 128, null, true);
    }

    public final int N(@NotNull View view) {
        int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        if (SystemBarTintManager.hasNavBar(view.getContext())) {
            i3 = SystemBarTintManager.getNavigationBarHeight(view.getContext());
        } else {
            i3 = 0;
        }
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        if (rootWindowInsets == null) {
            return 0;
        }
        return rootWindowInsets.getInsets(WindowInsetsCompat.Type.ime()).bottom - i3;
    }

    @Nullable
    public final ac O() {
        ac robotService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getRobotService();
        if (robotService == null) {
            QLog.e("AdelieUtils-RobotStory", 1, "getRobotService service is null");
        }
        return robotService;
    }

    public final void P(int chatType, @Nullable String peerUid, @Nullable MsgElement msgElement, boolean front) {
        com.tencent.qqnt.kernel.api.w wVar;
        IKernelService iKernelService;
        if (!TextUtils.isEmpty(peerUid) && msgElement != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")) != null) {
                wVar = iKernelService.getMsgService();
            } else {
                wVar = null;
            }
            com.tencent.qqnt.kernel.api.w wVar2 = wVar;
            if (wVar2 != null) {
                wVar2.w(new Contact(chatType, peerUid, ""), 2L, msgElement, front, new IOperateCallback() { // from class: com.tencent.robot.adelie.homepage.n
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        AdelieUtils.Q(i3, str);
                    }
                });
                return;
            }
            return;
        }
        QLog.e("AdelieUtils-RobotStory", 1, "[insertNtLocalRecordMsg] params is invalid,msgElement:" + msgElement);
    }

    public final boolean R(char c16) {
        if (' ' > c16 || c16 >= '\u007f') {
            return false;
        }
        return true;
    }

    public final boolean S(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        if (rootWindowInsets == null) {
            return false;
        }
        return rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime());
    }

    public final boolean T(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        if (aioContext.g().l().getLong("key_robot_story_id", 0L) != 0) {
            return true;
        }
        return false;
    }

    public final void U(@Nullable final byte[] pagingCookie, @NotNull final String dataVersion, final boolean isLocal, @NotNull final Function3<? super Integer, ? super String, ? super MyRobotsListRsp, Unit> cb5) {
        Intrinsics.checkNotNullParameter(dataVersion, "dataVersion");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.w
            @Override // java.lang.Runnable
            public final void run() {
                AdelieUtils.V(pagingCookie, dataVersion, isLocal, cb5);
            }
        }, 128, null, true);
    }

    public final void X() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.s
            @Override // java.lang.Runnable
            public final void run() {
                AdelieUtils.Y();
            }
        }, 128, null, true);
    }

    public final void a0(@Nullable String page, int errCode, @Nullable String errMsg, long loadPicStartTime) {
        Map mapOf;
        long currentTimeMillis = System.currentTimeMillis() - loadPicStartTime;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("error_code", String.valueOf(errCode)), TuplesKt.to("error_msg", String.valueOf(errMsg)), TuplesKt.to("cost_time", String.valueOf(currentTimeMillis)));
        com.tencent.robot.adelie.homepage.utils.d.c(null, "adelie_creation_ai_load_avatar", mapOf, 1, null);
        QLog.i("AdelieUtils-RobotStory", 1, "reportLoadPic page=" + page + ", errCode=" + errCode + ", errMsg=" + errMsg + ", loadPicCostTime=" + currentTimeMillis);
    }

    public final void b0(@NotNull final MyBotInfo botInfo, @NotNull final AiGenBotInfoOperationType genType, @NotNull final Function3<? super Integer, ? super String, ? super MyBotInfo, Unit> cb5) {
        Intrinsics.checkNotNullParameter(botInfo, "botInfo");
        Intrinsics.checkNotNullParameter(genType, "genType");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.m
            @Override // java.lang.Runnable
            public final void run() {
                AdelieUtils.d0(MyBotInfo.this, genType, cb5);
            }
        }, 128, null, true);
    }

    public final void c0(@NotNull final String botName, @NotNull final AiGenBotInfoOperationType genType, @NotNull final String templateId, @NotNull final Function3<? super Integer, ? super String, ? super MyBotInfo, Unit> cb5) {
        Intrinsics.checkNotNullParameter(botName, "botName");
        Intrinsics.checkNotNullParameter(genType, "genType");
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.z
            @Override // java.lang.Runnable
            public final void run() {
                AdelieUtils.f0(AiGenBotInfoOperationType.this, templateId, botName, cb5);
            }
        }, 128, null, true);
    }

    @NotNull
    public final CharSequence h0(@NotNull CharSequence src, int maxLengthFullwidth) {
        int i3;
        Intrinsics.checkNotNullParameter(src, "src");
        int i16 = maxLengthFullwidth * 2;
        int i17 = 0;
        for (int i18 = 0; i18 < src.length(); i18++) {
            if (R(src.charAt(i18))) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            i17 += i3;
            if (i17 > i16) {
                return src.subSequence(0, i18).toString();
            }
        }
        return src;
    }

    @Nullable
    public final Object i0(@NotNull String str, @NotNull Continuation<? super UploadResult> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        f365929a.j0(str, new Function3<Integer, String, String, Unit>() { // from class: com.tencent.robot.adelie.homepage.AdelieUtils$uploadAvatarAndGetUrl$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2, String str3) {
                invoke(num.intValue(), str2, str3);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String errMsg, @NotNull String url) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(url, "url");
                cancellableContinuationImpl.resume(new AdelieUtils.UploadResult(url, i3, errMsg), null);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final void j0(@NotNull String path, @NotNull Function3<? super Integer, ? super String, ? super String, Unit> cb5) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        new x14.c(new c.TaskParam(path, 0, null, null, 14, null), new b(cb5)).c();
    }

    public final void v(@NotNull final MyBotInfo myBotInfo, @Nullable final String page, @Nullable final String source, @Nullable final IAiGenAvatarCallback cb5) {
        Intrinsics.checkNotNullParameter(myBotInfo, "myBotInfo");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.aa
            @Override // java.lang.Runnable
            public final void run() {
                AdelieUtils.w(MyBotInfo.this, page, source, cb5);
            }
        }, 128, null, true);
    }

    public final void y(@NotNull final ArrayList<byte[]> byteArrayList, @Nullable final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(byteArrayList, "byteArrayList");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.h
            @Override // java.lang.Runnable
            public final void run() {
                AdelieUtils.z(byteArrayList, callback);
            }
        }, 32, null, true);
    }
}
