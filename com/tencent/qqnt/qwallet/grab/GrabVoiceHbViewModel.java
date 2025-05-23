package com.tencent.qqnt.qwallet.grab;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.temp.IQQAppInterfaceTemp;
import com.qwallet.temp.IQwTemp;
import com.tencent.ark.ark;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.IMessageForPttInnerApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.streamtransfile.IStreamDataManager;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.msg.f;
import com.tencent.qqnt.qwallet.bigdata.BigDataUploader;
import com.tencent.qqnt.qwallet.grab.GrabVoiceHbFragment;
import com.tencent.qqnt.qwallet.grab.GrabVoiceHbViewModel;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.UiThreadUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007*\u0002Yq\u0018\u0000 42\u00020\u0001:\u0002\u0082\u0001B\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\u0004H\u0014J\"\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nR\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010&\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010)\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u001e\u001a\u0004\b(\u0010 R\u0017\u0010,\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b*\u0010\u001e\u001a\u0004\b+\u0010 R\u0017\u0010/\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b-\u0010\u001e\u001a\u0004\b.\u0010 R\u0017\u00102\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010 R\u0017\u00107\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0017\u00109\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b8\u0010 R\u0017\u0010<\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b:\u0010#\u001a\u0004\b;\u0010%R\u0017\u0010?\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b=\u0010\u001e\u001a\u0004\b>\u0010 R\u001b\u0010E\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR#\u0010K\u001a\n G*\u0004\u0018\u00010F0F8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010B\u001a\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u001b\u0010X\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010B\u001a\u0004\bV\u0010WR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u001d\u0010b\u001a\b\u0012\u0004\u0012\u00020\n0]8\u0006\u00a2\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u001d\u0010e\u001a\b\u0012\u0004\u0012\u00020\n0]8\u0006\u00a2\u0006\f\n\u0004\bc\u0010_\u001a\u0004\bd\u0010aR\u001d\u0010i\u001a\b\u0012\u0004\u0012\u00020f0]8\u0006\u00a2\u0006\f\n\u0004\bg\u0010_\u001a\u0004\bh\u0010aR(\u0010p\u001a\u0004\u0018\u00010j2\b\u0010k\u001a\u0004\u0018\u00010j8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010oR\u0014\u0010t\u001a\u00020q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0014\u0010x\u001a\u00020u8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010wR$\u0010{\u001a\u00020\u00022\u0006\u0010k\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\by\u0010\u001e\u001a\u0004\bz\u0010 R\u0014\u0010\u007f\u001a\u00020|8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b}\u0010~\u00a8\u0006\u0083\u0001"}, d2 = {"Lcom/tencent/qqnt/qwallet/grab/GrabVoiceHbViewModel;", "Landroidx/lifecycle/ViewModel;", "", "path", "", "q2", "l2", "T1", "Lkotlin/Pair;", "", "", "S1", "Landroid/content/Context;", "context", "m2", ICustomDataEditor.NUMBER_PARAM_2, "Landroid/content/Intent;", "X1", "onCleared", "", com.tencent.luggage.wxa.c8.c.E, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "p2", "Landroidx/lifecycle/SavedStateHandle;", "i", "Landroidx/lifecycle/SavedStateHandle;", "stateHandle", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "getListId", "()Ljava/lang/String;", "listId", BdhLogUtil.LogTag.Tag_Conn, "I", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()I", NotifyMsgApiImpl.KEY_GROUP_TYPE, "D", "getSenderUin", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "E", "getPeerUin", "peerUin", UserInfo.SEX_FEMALE, "Z1", "groupId", "G", "getAuthKey", "authKey", "H", "Z", "k2", "()Z", "isSelfSend", "U1", "command", "J", "c2", "recordDurationMillis", "K", "i2", "toDetailJson", "Lcom/tencent/mobileqq/ptt/IQQRecorderUtils;", "L", "Lkotlin/Lazy;", "f2", "()Lcom/tencent/mobileqq/ptt/IQQRecorderUtils;", "recorderUtils", "Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "kotlin.jvm.PlatformType", "M", "e2", "()Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "recorderParam", "Lcom/tencent/mobileqq/ptt/d;", "N", "Lcom/tencent/mobileqq/ptt/d;", "audioRecord", "Lcom/tencent/mobileqq/qqaudio/audioprocessor/c;", "P", "Lcom/tencent/mobileqq/qqaudio/audioprocessor/c;", "audioProcessor", "Lcom/tencent/qqnt/qwallet/bigdata/BigDataUploader;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "j2", "()Lcom/tencent/qqnt/qwallet/bigdata/BigDataUploader;", "voiceUploader", "com/tencent/qqnt/qwallet/grab/GrabVoiceHbViewModel$c", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/qqnt/qwallet/grab/GrabVoiceHbViewModel$c;", "uploadCallback", "Landroidx/lifecycle/MutableLiveData;", ExifInterface.LATITUDE_SOUTH, "Landroidx/lifecycle/MutableLiveData;", "W1", "()Landroidx/lifecycle/MutableLiveData;", "errMsg", "T", "b2", "recognizeStatus", "Lcom/tencent/qqnt/qwallet/grab/GrabVoiceHbFragment$EnumRecordStatus;", "U", "d2", "recordStatus", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$PttSendEvent;", "<set-?>", "V", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$PttSendEvent;", "g2", "()Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$PttSendEvent;", "sendVoiceIntent", "com/tencent/qqnt/qwallet/grab/GrabVoiceHbViewModel$b", "W", "Lcom/tencent/qqnt/qwallet/grab/GrabVoiceHbViewModel$b;", "recordListener", "Ljava/lang/Runnable;", "X", "Ljava/lang/Runnable;", "timeoutAction", "Y", "getRecognizeDegree", "recognizeDegree", "", SemanticAttributes.DbSystemValues.H2, "()J", "senderUinLong", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class GrabVoiceHbViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final int groupType;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String senderUin;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String peerUin;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final String groupId;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final String authKey;

    /* renamed from: H, reason: from kotlin metadata */
    private final boolean isSelfSend;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final String command;

    /* renamed from: J, reason: from kotlin metadata */
    private final int recordDurationMillis;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final String toDetailJson;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy recorderUtils;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy recorderParam;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.ptt.d audioRecord;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqaudio.audioprocessor.c audioProcessor;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy voiceUploader;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final c uploadCallback;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> errMsg;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> recognizeStatus;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<GrabVoiceHbFragment.EnumRecordStatus> recordStatus;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private AIOMsgSendEvent.PttSendEvent sendVoiceIntent;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final b recordListener;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Runnable timeoutAction;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private String recognizeDegree;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SavedStateHandle stateHandle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String listId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/qwallet/grab/GrabVoiceHbViewModel$c", "Lcom/tencent/qqnt/qwallet/bigdata/BigDataUploader$a;", "", "rspExtendInfo", "", "a", "", "errCode", "", "errMsg", "onError", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements BigDataUploader.a {
        c() {
        }

        @Override // com.tencent.qqnt.qwallet.bigdata.BigDataUploader.a
        public void a(@NotNull byte[] rspExtendInfo) {
            Intrinsics.checkNotNullParameter(rspExtendInfo, "rspExtendInfo");
            try {
                JSONObject jSONObject = new JSONObject(new String(rspExtendInfo, Charsets.UTF_8));
                GrabVoiceHbViewModel.this.b2().postValue(Integer.valueOf(jSONObject.getInt("status")));
                GrabVoiceHbViewModel grabVoiceHbViewModel = GrabVoiceHbViewModel.this;
                String string = jSONObject.getString("degree");
                Intrinsics.checkNotNullExpressionValue(string, "extendObj.getString(\"degree\")");
                grabVoiceHbViewModel.recognizeDegree = string;
            } catch (JSONException e16) {
                QLog.e("GrabVoiceHbViewModel", 1, "onFinish: error ", e16);
                GrabVoiceHbViewModel.this.l2();
            }
            UiThreadUtil.remove(GrabVoiceHbViewModel.this.timeoutAction);
        }

        @Override // com.tencent.qqnt.qwallet.bigdata.BigDataUploader.a
        public void onError(int errCode, @Nullable String errMsg) {
            QLog.d("GrabVoiceHbViewModel", 1, "onFail: errCode " + errCode + ", errMsg " + errMsg);
            GrabVoiceHbViewModel.this.l2();
            UiThreadUtil.remove(GrabVoiceHbViewModel.this.timeoutAction);
        }
    }

    public GrabVoiceHbViewModel(@NotNull SavedStateHandle stateHandle) {
        int intValue;
        int intValue2;
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(stateHandle, "stateHandle");
        this.stateHandle = stateHandle;
        String str = (String) stateHandle.get("voice_list_id");
        this.listId = str == null ? "" : str;
        Integer num = (Integer) stateHandle.get("voice_group_type");
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        this.groupType = intValue;
        String str2 = (String) stateHandle.get("voice_sender_uin");
        this.senderUin = str2 == null ? "" : str2;
        String str3 = (String) stateHandle.get("voice_peer_uin");
        this.peerUin = str3 == null ? "" : str3;
        String str4 = (String) stateHandle.get("voice_group_id");
        this.groupId = str4 == null ? "" : str4;
        String str5 = (String) stateHandle.get("voice_auth_key");
        this.authKey = str5 == null ? "" : str5;
        Boolean bool = (Boolean) stateHandle.get("voice_is_self_send");
        this.isSelfSend = bool != null ? bool.booleanValue() : false;
        String str6 = (String) stateHandle.get("voice_command");
        this.command = str6 == null ? "" : str6;
        Integer num2 = (Integer) stateHandle.get("voice_record_duration_millis");
        if (num2 == null) {
            intValue2 = 12000000;
        } else {
            intValue2 = num2.intValue();
        }
        this.recordDurationMillis = intValue2;
        String str7 = (String) stateHandle.get("voice_to_detail_json");
        this.toDetailJson = str7 == null ? "" : str7;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IQQRecorderUtils>() { // from class: com.tencent.qqnt.qwallet.grab.GrabVoiceHbViewModel$recorderUtils$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IQQRecorderUtils invoke() {
                return (IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class);
            }
        });
        this.recorderUtils = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RecordParams.RecorderParam>() { // from class: com.tencent.qqnt.qwallet.grab.GrabVoiceHbViewModel$recorderParam$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecordParams.RecorderParam invoke() {
                return RecordParams.c(MobileQQ.sMobileQQ.peekAppRuntime(), false);
            }
        });
        this.recorderParam = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<BigDataUploader>() { // from class: com.tencent.qqnt.qwallet.grab.GrabVoiceHbViewModel$voiceUploader$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BigDataUploader invoke() {
                GrabVoiceHbViewModel.c cVar;
                cVar = GrabVoiceHbViewModel.this.uploadCallback;
                return new BigDataUploader(cVar);
            }
        });
        this.voiceUploader = lazy3;
        this.uploadCallback = new c();
        this.errMsg = new MutableLiveData<>();
        this.recognizeStatus = new MutableLiveData<>();
        this.recordStatus = new MutableLiveData<>();
        this.recordListener = new b();
        this.timeoutAction = new Runnable() { // from class: com.tencent.qqnt.qwallet.grab.e
            @Override // java.lang.Runnable
            public final void run() {
                GrabVoiceHbViewModel.o2(GrabVoiceHbViewModel.this);
            }
        };
        this.recognizeDegree = "";
    }

    private final String T1() {
        String audioPath = TransFileUtil.getTransferFilePath(com.tencent.mobileqq.base.a.c(), null, 2, null, false);
        String localFilePath = ((IMessageForPttInnerApi) QRoute.api(IMessageForPttInnerApi.class)).getLocalFilePath(e2().f307257f, audioPath);
        if (!Intrinsics.areEqual(audioPath, localFilePath)) {
            Intrinsics.checkNotNull(audioPath);
            new File(audioPath).deleteOnExit();
            audioPath = localFilePath;
        }
        Intrinsics.checkNotNullExpressionValue(audioPath, "audioPath");
        return audioPath;
    }

    private final RecordParams.RecorderParam e2() {
        return (RecordParams.RecorderParam) this.recorderParam.getValue();
    }

    private final IQQRecorderUtils f2() {
        return (IQQRecorderUtils) this.recorderUtils.getValue();
    }

    private final long h2() {
        try {
            return Long.parseLong(this.senderUin);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    private final BigDataUploader j2() {
        return (BigDataUploader) this.voiceUploader.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l2() {
        this.errMsg.postValue(Integer.valueOf(R.string.d8a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(GrabVoiceHbViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.errMsg.postValue(Integer.valueOf(R.string.d86));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void q2(String path) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bill_no", this.listId);
        jSONObject.put("voice_text", this.command);
        jSONObject.put("make_uin", h2());
        jSONObject.put("platform", 0);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026\u5b89\u5353\u4e3a0\n        }.toString()");
        byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        j2().e(path, bytes);
        UiThreadUtil.runOnUiThread(this.timeoutAction, 20000L);
    }

    @NotNull
    public final Pair<Boolean, Integer> S1() {
        if (!f2().checkExternalStorageForRecord()) {
            return new Pair<>(Boolean.FALSE, Integer.valueOf(R.string.h_0));
        }
        if (!f2().checkIntenalStorageForRecord(e2().f307257f)) {
            return new Pair<>(Boolean.FALSE, Integer.valueOf(R.string.by8));
        }
        if (((IQQAppInterfaceTemp) QRoute.api(IQQAppInterfaceTemp.class)).isVideoChatting(MobileQQ.sMobileQQ.peekAppRuntime())) {
            return new Pair<>(Boolean.FALSE, Integer.valueOf(R.string.f171206d52));
        }
        return new Pair<>(Boolean.TRUE, 0);
    }

    @NotNull
    /* renamed from: U1, reason: from getter */
    public final String getCommand() {
        return this.command;
    }

    @NotNull
    public final MutableLiveData<Integer> W1() {
        return this.errMsg;
    }

    @NotNull
    public final Intent X1() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("listid", this.listId);
        jSONObject.put("senderuin", this.senderUin);
        jSONObject.put("name", com.tencent.mobileqq.base.a.b());
        jSONObject.put("grouptype", this.groupType);
        jSONObject.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, this.groupId);
        jSONObject.put(WadlProxyConsts.CHANNEL, 65536);
        jSONObject.put("groupuin", this.peerUin);
        jSONObject.put("authkey", this.authKey);
        jSONObject.put("voice_rate_id", this.recognizeDegree);
        jSONObject.put("curFriendUin", this.peerUin);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("userId", com.tencent.mobileqq.base.a.c());
        jSONObject2.put(HippyHeaderListViewController.VIEW_TAG, "graphb");
        jSONObject2.put(j.T0, "appid#1344242394|bargainor_id#1000030201|channel#msg");
        jSONObject2.put("come_from", 2);
        jSONObject2.put("extra_data", jSONObject.toString());
        Intent intent = new Intent();
        intent.putExtra(ark.ARKMETADATA_JSON, jSONObject2.toString());
        intent.putExtra("callbackSn", "0");
        intent.putExtra("pay_requestcode", 5);
        return intent;
    }

    @NotNull
    /* renamed from: Z1, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: a2, reason: from getter */
    public final int getGroupType() {
        return this.groupType;
    }

    @NotNull
    public final MutableLiveData<Integer> b2() {
        return this.recognizeStatus;
    }

    /* renamed from: c2, reason: from getter */
    public final int getRecordDurationMillis() {
        return this.recordDurationMillis;
    }

    @NotNull
    public final MutableLiveData<GrabVoiceHbFragment.EnumRecordStatus> d2() {
        return this.recordStatus;
    }

    @Nullable
    /* renamed from: g2, reason: from getter */
    public final AIOMsgSendEvent.PttSendEvent getSendVoiceIntent() {
        return this.sendVoiceIntent;
    }

    @NotNull
    public final String getSenderUin() {
        return this.senderUin;
    }

    @NotNull
    /* renamed from: i2, reason: from getter */
    public final String getToDetailJson() {
        return this.toDetailJson;
    }

    /* renamed from: k2, reason: from getter */
    public final boolean getIsSelfSend() {
        return this.isSelfSend;
    }

    public final void m2(@NotNull Context context) {
        com.tencent.mobileqq.qqaudio.audioprocessor.c silkCodecWrapper;
        Intrinsics.checkNotNullParameter(context, "context");
        ((IQwTemp) QRoute.api(IQwTemp.class)).mediaPlayer_doStop(true, MobileQQ.sMobileQQ.peekAppRuntime());
        this.recordStatus.setValue(GrabVoiceHbFragment.EnumRecordStatus.STATUS_INIT);
        com.tencent.mobileqq.qqaudio.audioprocessor.b bVar = new com.tencent.mobileqq.qqaudio.audioprocessor.b();
        if (e2().f307257f == 0) {
            silkCodecWrapper = new AmrInputStreamWrapper(context);
        } else {
            silkCodecWrapper = new SilkCodecWrapper(context);
        }
        bVar.c(silkCodecWrapper);
        bVar.b(e2().f307255d, e2().f307256e, e2().f307257f);
        this.audioProcessor = bVar;
        if (this.audioRecord == null) {
            this.audioRecord = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).createQQRecorder(context);
        }
        com.tencent.mobileqq.ptt.d dVar = this.audioRecord;
        if (dVar != null) {
            dVar.e(e2());
            dVar.b(this.recordListener);
            dVar.start(T1());
        }
    }

    public final void n2() {
        com.tencent.mobileqq.ptt.d dVar = this.audioRecord;
        if (dVar != null) {
            dVar.stop();
        }
        com.tencent.mobileqq.qqaudio.audioprocessor.c cVar = this.audioProcessor;
        if (cVar != null) {
            cVar.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        j2().b();
    }

    @NotNull
    public final ArrayList<Byte> p2(@NotNull int[] iArr, int i3) {
        List slice;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        slice = ArraysKt___ArraysKt.slice(iArr, new IntRange(0, i3));
        List list = slice;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf((byte) ((Number) it.next()).intValue()));
        }
        return new ArrayList<>(arrayList);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bJ&\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u001c\u0010\u0013\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u0014\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\bH\u0016J>\u0010\u001c\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u001d"}, d2 = {"com/tencent/qqnt/qwallet/grab/GrabVoiceHbViewModel$b", "Lcom/tencent/mobileqq/ptt/d$a;", "", "path", "Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "p", "", "onRecorderPrepare", "", "onRecorderStart", "onBeginReceiveData", "", "totalTime", "onRecorderEnd", NotifyMsgApiImpl.KEY_GROUP_TYPE, "a", "throwable", "onRecorderError", "onInitSuccess", "onInitFailed", "onRecorderAbnormal", "state", "onRecorderVolumeStateChanged", "", "sliceData", "size", "maxAmplitude", "time", "onRecorderSilceEnd", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements d.a {
        b() {
        }

        public final int a(int groupType) {
            if (groupType == 0) {
                return 1;
            }
            if (groupType == 1 || groupType != 11) {
                return 2;
            }
            return 4;
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public int onBeginReceiveData(@Nullable String path, @Nullable RecordParams.RecorderParam p16) {
            return 30000;
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onInitFailed(@Nullable String path, @Nullable RecordParams.RecorderParam p16) {
            QLog.w("GrabVoiceHbViewModel", 1, "onInitFailed");
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderAbnormal(@Nullable String path, @Nullable RecordParams.RecorderParam p16) {
            QLog.i("GrabVoiceHbViewModel", 1, "onRecorderAbnormal");
            GrabVoiceHbViewModel.this.W1().postValue(Integer.valueOf(R.string.d8a));
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderEnd(@Nullable String path, @Nullable RecordParams.RecorderParam p16, double totalTime) {
            boolean z16;
            long j3;
            int i3;
            ArrayList<Byte> arrayList;
            int[] iArr;
            Long j06;
            if (GrabVoiceHbViewModel.this.d2().getValue() == GrabVoiceHbFragment.EnumRecordStatus.STATUS_CANCEL) {
                ((IPttBuffer) QRoute.api(IPttBuffer.class)).cancelBufferTask(path);
                return;
            }
            ((IPttBuffer) QRoute.api(IPttBuffer.class)).flush(path);
            ((IStreamDataManager) QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool(path);
            if (totalTime < 500.0d) {
                GrabVoiceHbViewModel.this.W1().postValue(Integer.valueOf(R.string.f170312ly));
                return;
            }
            if (path != null && path.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                GrabVoiceHbViewModel.this.W1().postValue(Integer.valueOf(R.string.d8a));
                return;
            }
            w e16 = f.e();
            if (e16 != null && (j06 = e16.j0(a(GrabVoiceHbViewModel.this.getGroupType()))) != null) {
                j3 = j06.longValue();
            } else {
                j3 = 0;
            }
            long j16 = j3;
            GrabVoiceHbViewModel grabVoiceHbViewModel = GrabVoiceHbViewModel.this;
            float f16 = (float) totalTime;
            if (p16 != null) {
                i3 = p16.f307257f;
            } else {
                i3 = 1;
            }
            if (p16 == null || (iArr = p16.D) == null || (arrayList = grabVoiceHbViewModel.p2(iArr, p16.C)) == null) {
                arrayList = new ArrayList<>();
            }
            grabVoiceHbViewModel.sendVoiceIntent = new AIOMsgSendEvent.PttSendEvent(path, f16, i3, arrayList, false, false, 0, Long.valueOf(j16), 112, null);
            QLog.d("GrabVoiceHbViewModel", 1, "onRecorderEnd: sendMsgId = " + j16 + " path " + path + " totalTime " + totalTime);
            GrabVoiceHbViewModel.this.q2(path);
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderError(@Nullable String path, @Nullable RecordParams.RecorderParam p16, @Nullable String throwable) {
            QLog.w("GrabVoiceHbViewModel", 1, "onRecorderError: throwable " + throwable);
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderPrepare(@Nullable String path, @Nullable RecordParams.RecorderParam p16) {
            if (p16 == null) {
                return;
            }
            byte[] a16 = RecordParams.a(p16.f307257f, p16.f307255d);
            ((IPttBuffer) QRoute.api(IPttBuffer.class)).createBufferTask(path);
            ((IPttBuffer) QRoute.api(IPttBuffer.class)).appendBuffer(path, a16, a16.length);
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderSilceEnd(@Nullable String path, @Nullable byte[] sliceData, int size, int maxAmplitude, double time, @Nullable RecordParams.RecorderParam p16) {
            ((IPttBuffer) QRoute.api(IPttBuffer.class)).appendBuffer(path, sliceData, size);
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public int onRecorderStart() {
            QLog.d("GrabVoiceHbViewModel", 1, "onRecorderStart");
            UiThreadUtil.remove(GrabVoiceHbViewModel.this.timeoutAction);
            return 250;
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderVolumeStateChanged(int state) {
            QLog.d("GrabVoiceHbViewModel", 1, "onRecorderVolumeStateChanged: state " + state);
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onInitSuccess() {
        }
    }
}
