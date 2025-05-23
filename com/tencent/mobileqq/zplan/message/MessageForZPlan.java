package com.tencent.mobileqq.zplan.message;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.k;
import com.tencent.mobileqq.pic.t;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.zplan.message.MessageForZPlan;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.mobileqq.zplan.model.ZPlanActionType;
import com.tencent.mobileqq.zplan.utils.Constant;
import com.tencent.mobileqq.zplan.utils.FileCache;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.open.base.g;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype39;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b4\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0002abB\u0007\u00a2\u0006\u0004\b^\u0010_J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\u0006H\u0014J\b\u0010\u000f\u001a\u00020\u0006H\u0014J\u0006\u0010\u0010\u001a\u00020\u0006J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0016R\"\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010 \u001a\u0004\b7\u0010\"\"\u0004\b8\u0010$R$\u00109\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010 \u001a\u0004\b:\u0010\"\"\u0004\b;\u0010$R$\u0010<\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010 \u001a\u0004\b=\u0010\"\"\u0004\b>\u0010$R\"\u0010?\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010\u001a\u001a\u0004\b@\u0010\u001c\"\u0004\bA\u0010\u001eR\"\u0010B\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010\u001a\u001a\u0004\bC\u0010\u001c\"\u0004\bD\u0010\u001eR\"\u0010E\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010\u001a\u001a\u0004\bF\u0010\u001c\"\u0004\bG\u0010\u001eR$\u0010H\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010 \u001a\u0004\bI\u0010\"\"\u0004\bJ\u0010$R$\u0010K\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010 \u001a\u0004\bL\u0010\"\"\u0004\bM\u0010$R$\u0010N\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010 \u001a\u0004\bO\u0010\"\"\u0004\bP\u0010$R\"\u0010Q\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010\u001a\u001a\u0004\bR\u0010\u001c\"\u0004\bS\u0010\u001eR$\u0010T\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010 \u001a\u0004\bU\u0010\"\"\u0004\bV\u0010$R\"\u0010W\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010\u001a\u001a\u0004\bX\u0010\u001c\"\u0004\bY\u0010\u001eR\u0013\u0010[\u001a\u0004\u0018\u00010\u00038F\u00a2\u0006\u0006\u001a\u0004\bZ\u0010\"R\u0013\u0010]\u001a\u0004\u0018\u00010\u00038F\u00a2\u0006\u0006\u001a\u0004\b\\\u0010\"\u00a8\u0006c"}, d2 = {"Lcom/tencent/mobileqq/zplan/message/MessageForZPlan;", "Lcom/tencent/mobileqq/data/ChatMessage;", "Lcom/tencent/mobileqq/pic/t;", "", "toJsonString", "jsonString", "", "fromJsonString", "", "serializeMsgBody", "bytes", "", "businessType", "deserializeMsgBody", "doParse", "prewrite", SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL, "toString", "Lcom/tencent/mobileqq/pic/v;", "getPicUploadInfo", "Lcom/tencent/mobileqq/zplan/message/MessageForZPlan$ZPlanPicDownloadInfo;", "getPicDownloadInfo", "", "isDoubleUserAction", "isRectangleShape", "id", "I", "getId", "()I", "setId", "(I)V", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "playerNumber", "getPlayerNumber", "setPlayerNumber", "Lcom/tencent/mobileqq/zplan/model/ZPlanActionType;", "type", "Lcom/tencent/mobileqq/zplan/model/ZPlanActionType;", "getType", "()Lcom/tencent/mobileqq/zplan/model/ZPlanActionType;", "setType", "(Lcom/tencent/mobileqq/zplan/model/ZPlanActionType;)V", "", "peerUin", "J", "getPeerUin", "()J", "setPeerUin", "(J)V", "apngUrl", "getApngUrl", "setApngUrl", "sharpPUrl", "getSharpPUrl", "setSharpPUrl", "reverseInfo", "getReverseInfo", "setReverseInfo", "width", "getWidth", "setWidth", "height", "getHeight", "setHeight", "msgVia", "getMsgVia", "setMsgVia", "localCover", "getLocalCover", QZoneCoverStoreJsPlugin.SET_LOCAL_COVER, "localApng", "getLocalApng", "setLocalApng", "localSharpP", "getLocalSharpP", "setLocalSharpP", "uinType", "getUinType", "setUinType", "defaultCoverUrl", "getDefaultCoverUrl", "setDefaultCoverUrl", "playStatus", "getPlayStatus", "setPlayStatus", "getLocalPath", "localPath", "getPicUrl", "picUrl", "<init>", "()V", "Companion", "a", "ZPlanPicDownloadInfo", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MessageForZPlan extends ChatMessage implements t {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int PLAY_STATUS_NOT_PLAYED = 0;
    public static final int PLAY_STATUS_PLAYED = 1;
    public static final String TAG = "[zplan][MessageForZPlan]";
    private String apngUrl;
    private String defaultCoverUrl;
    private String localApng;
    private String localCover;
    private String localSharpP;
    private int msgVia;
    private String name;
    private long peerUin;
    private int playStatus;
    private String reverseInfo;
    private String sharpPUrl;
    private int id = -1;
    private int playerNumber = 1;
    private ZPlanActionType type = ZPlanActionType.MEME;
    private int width = 360;
    private int height = 360;
    private int uinType = -1;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u001d\u0010\t\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/message/MessageForZPlan$ZPlanPicDownloadInfo;", "Lcom/tencent/mobileqq/pic/k;", "", "l", "d", "g0", "Lkotlin/Lazy;", "getCacheKey", "()Ljava/lang/String;", "cacheKey", "<init>", "()V", "h0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class ZPlanPicDownloadInfo extends k {

        /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: i0, reason: collision with root package name */
        private static final String f334214i0 = Constant.f335714a.a() + "/chatImg";

        /* renamed from: j0, reason: collision with root package name */
        private static final long f334215j0 = ZPlanQQMC.INSTANCE.getMemeRecordFileCacheSize();

        /* renamed from: k0, reason: collision with root package name */
        private static final Lazy<FileCache> f334216k0;

        /* renamed from: l0, reason: collision with root package name */
        private static final Pattern f334217l0;

        /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
        private final Lazy cacheKey;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/message/MessageForZPlan$ZPlanPicDownloadInfo$a;", "", "", "md5", "b", "DIR", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "Ljava/util/regex/Pattern;", "LEGAL_KEY_PATTERN", "Ljava/util/regex/Pattern;", "", "MAX_SIZE", "J", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.message.MessageForZPlan$ZPlanPicDownloadInfo$a, reason: from kotlin metadata */
        /* loaded from: classes34.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final String b(String md5) {
                if (TextUtils.isEmpty(md5)) {
                    return null;
                }
                return ZPlanPicDownloadInfo.f334217l0.matcher(md5).matches() ? md5 : g.d(md5);
            }

            public final String c() {
                return ZPlanPicDownloadInfo.f334214i0;
            }

            Companion() {
            }
        }

        static {
            Lazy<FileCache> lazy;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<FileCache>() { // from class: com.tencent.mobileqq.zplan.message.MessageForZPlan$ZPlanPicDownloadInfo$Companion$diskCache$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final FileCache invoke() {
                    long j3;
                    String c16 = MessageForZPlan.ZPlanPicDownloadInfo.INSTANCE.c();
                    j3 = MessageForZPlan.ZPlanPicDownloadInfo.f334215j0;
                    return new FileCache(c16, j3);
                }
            });
            f334216k0 = lazy;
            Pattern compile = Pattern.compile("[a-z0-9_-]{1,64}");
            Intrinsics.checkNotNullExpressionValue(compile, "compile(\"[a-z0-9_-]{1,64}\")");
            f334217l0 = compile;
        }

        public ZPlanPicDownloadInfo() {
            Lazy lazy;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.zplan.message.MessageForZPlan$ZPlanPicDownloadInfo$cacheKey$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String b16;
                    b16 = MessageForZPlan.ZPlanPicDownloadInfo.INSTANCE.b(MessageForZPlan.ZPlanPicDownloadInfo.this.J);
                    return b16;
                }
            });
            this.cacheKey = lazy;
        }

        private final String l() {
            return Constant.f335714a.a() + "/chatImgTmp/" + this.J + "." + System.nanoTime();
        }

        @Override // com.tencent.mobileqq.pic.h
        public String d() {
            return l();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/message/MessageForZPlan$a;", "", "Lcom/tencent/mobileqq/zplan/model/e;", "info", "Lcom/tencent/mobileqq/zplan/message/MessageForZPlan;", "a", "Lcom/tencent/mobileqq/zplan/message/c;", SessionDbHelper.SESSION_ID, "b", "", "PLAY_STATUS_NOT_PLAYED", "I", "PLAY_STATUS_PLAYED", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.message.MessageForZPlan$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MessageForZPlan a(ZPlanActionInfo info) {
            String femaleDefaultUrl;
            Intrinsics.checkNotNullParameter(info, "info");
            MessageRecord d16 = q.d(MessageRecord.MSG_TYPE_ZPLAN);
            Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.message.MessageForZPlan");
            MessageForZPlan messageForZPlan = (MessageForZPlan) d16;
            messageForZPlan.setId(info.getId());
            messageForZPlan.setName(info.getName());
            messageForZPlan.setPlayerNumber(info.getPlayerNumber());
            messageForZPlan.setWidth(info.getWidth());
            messageForZPlan.setHeight(info.getHeight());
            messageForZPlan.setType(info.getRecordType());
            bb bbVar = bb.f335811a;
            AppRuntime d17 = bbVar.d();
            if (bbVar.o(d17 != null ? d17.getCurrentUin() : null) == 1) {
                femaleDefaultUrl = info.getMaleDefaultUrl();
            } else {
                femaleDefaultUrl = info.getFemaleDefaultUrl();
            }
            messageForZPlan.setDefaultCoverUrl(femaleDefaultUrl);
            return messageForZPlan;
        }

        public final MessageForZPlan b(ZPlanActionInfo info, ZPlanSessionInfo session) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(session, "session");
            MessageForZPlan a16 = a(info);
            AppInterface c16 = bb.f335811a.c();
            if (c16 != null) {
                q.I(c16, a16, session.getFriendUin(), session.getTroopUin(), session.getSessionType());
            }
            a16.setUinType(session.getSessionType());
            return a16;
        }

        Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f334219a;

        static {
            int[] iArr = new int[ZPlanActionType.values().length];
            try {
                iArr[ZPlanActionType.MEME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ZPlanActionType.ACTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ZPlanActionType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f334219a = iArr;
        }
    }

    public MessageForZPlan() {
        this.msgtype = MessageRecord.MSG_TYPE_ZPLAN;
    }

    private final String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.id);
        String str = this.name;
        if (str != null) {
            jSONObject.put("name", str);
        }
        jSONObject.put("playerNumber", this.playerNumber);
        jSONObject.put("width", this.width);
        jSONObject.put("height", this.height);
        jSONObject.put("type", ZPlanActionType.INSTANCE.a(this.type));
        jSONObject.put("peerUin", this.peerUin);
        jSONObject.put("playStatus", this.playStatus);
        String str2 = this.apngUrl;
        if (str2 != null) {
            jSONObject.put("apngUrl", str2);
        }
        String str3 = this.sharpPUrl;
        if (str3 != null) {
            jSONObject.put("sharpPUrl", str3);
        }
        String str4 = this.reverseInfo;
        if (str4 != null) {
            jSONObject.put("reverseInfo", str4);
        }
        String str5 = this.localCover;
        if (str5 != null) {
            jSONObject.put("localCover", str5);
        }
        String str6 = this.localApng;
        if (str6 != null) {
            jSONObject.put("localApng", str6);
        }
        String str7 = this.localSharpP;
        if (str7 != null) {
            jSONObject.put("localSharpP", str7);
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        synchronized (this) {
            byte[] msgData = this.msgData;
            if (msgData != null) {
                Intrinsics.checkNotNullExpressionValue(msgData, "msgData");
                fromJsonString(new String(msgData, Charsets.UTF_8));
            }
        }
    }

    public final String getApngUrl() {
        return this.apngUrl;
    }

    public final String getDefaultCoverUrl() {
        return this.defaultCoverUrl;
    }

    public final int getHeight() {
        return this.height;
    }

    @Override // com.tencent.mobileqq.persistence.Entity, com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public final int getId() {
        return this.id;
    }

    public final String getLocalApng() {
        return this.localApng;
    }

    public final String getLocalCover() {
        return this.localCover;
    }

    public final String getLocalPath() {
        String str = this.localSharpP;
        if (!(str == null || str.length() == 0)) {
            return this.localSharpP;
        }
        return this.localApng;
    }

    public final String getLocalSharpP() {
        return this.localSharpP;
    }

    public final int getMsgVia() {
        return this.msgVia;
    }

    public final String getName() {
        return this.name;
    }

    public final long getPeerUin() {
        return this.peerUin;
    }

    @Override // com.tencent.mobileqq.pic.t
    public v getPicUploadInfo() {
        v.a aVar = new v.a();
        aVar.v(getLocalPath());
        aVar.I(this.uinType);
        aVar.q(0);
        return aVar.l();
    }

    public final String getPicUrl() {
        String str = this.sharpPUrl;
        if (!(str == null || str.length() == 0)) {
            return this.sharpPUrl;
        }
        return this.apngUrl;
    }

    public final int getPlayStatus() {
        return this.playStatus;
    }

    public final int getPlayerNumber() {
        return this.playerNumber;
    }

    public final String getReverseInfo() {
        return this.reverseInfo;
    }

    public final String getSharpPUrl() {
        return this.sharpPUrl;
    }

    public final ZPlanActionType getType() {
        return this.type;
    }

    public final int getUinType() {
        return this.uinType;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isDoubleUserAction() {
        return this.playerNumber == 2;
    }

    public final boolean isRectangleShape() {
        return this.width != this.height;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        synchronized (this) {
            byte[] bytes = toJsonString().getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            this.msgData = bytes;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void serial() {
        prewrite();
    }

    public final byte[] serializeMsgBody() {
        hummer_commelem$MsgElemInfo_servtype39 hummer_commelem_msgeleminfo_servtype39 = new hummer_commelem$MsgElemInfo_servtype39();
        int i3 = 1;
        hummer_commelem_msgeleminfo_servtype39.setHasFlag(true);
        hummer_commelem_msgeleminfo_servtype39.uint32_action_id.set(this.id);
        PBBytesField pBBytesField = hummer_commelem_msgeleminfo_servtype39.bytes_action_name;
        String str = this.name;
        if (str == null) {
            str = "";
        }
        pBBytesField.set(ByteStringMicro.copyFromUtf8(str));
        hummer_commelem_msgeleminfo_servtype39.uint32_player_number.set(this.playerNumber);
        hummer_commelem_msgeleminfo_servtype39.uint32_meme_width.set(this.width);
        hummer_commelem_msgeleminfo_servtype39.uint32_meme_height.set(this.height);
        PBUInt32Field pBUInt32Field = hummer_commelem_msgeleminfo_servtype39.uint32_action_type;
        int i16 = b.f334219a[this.type.ordinal()];
        if (i16 != 1) {
            i3 = 2;
            if (i16 != 2) {
                if (i16 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                i3 = 0;
            }
        }
        pBUInt32Field.set(i3);
        hummer_commelem_msgeleminfo_servtype39.uint64_peer_uin.set(this.peerUin);
        PBBytesField pBBytesField2 = hummer_commelem_msgeleminfo_servtype39.bytes_pic_url;
        String str2 = this.sharpPUrl;
        if (str2 == null) {
            str2 = "";
        }
        pBBytesField2.set(ByteStringMicro.copyFromUtf8(str2));
        PBBytesField pBBytesField3 = hummer_commelem_msgeleminfo_servtype39.bytes_reserve_info;
        String str3 = this.reverseInfo;
        pBBytesField3.set(ByteStringMicro.copyFromUtf8(str3 != null ? str3 : ""));
        byte[] byteArray = hummer_commelem_msgeleminfo_servtype39.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "elemInfo.toByteArray()");
        return byteArray;
    }

    public final void setApngUrl(String str) {
        this.apngUrl = str;
    }

    public final void setDefaultCoverUrl(String str) {
        this.defaultCoverUrl = str;
    }

    public final void setHeight(int i3) {
        this.height = i3;
    }

    public final void setId(int i3) {
        this.id = i3;
    }

    public final void setLocalApng(String str) {
        this.localApng = str;
    }

    public final void setLocalCover(String str) {
        this.localCover = str;
    }

    public final void setLocalSharpP(String str) {
        this.localSharpP = str;
    }

    public final void setMsgVia(int i3) {
        this.msgVia = i3;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPeerUin(long j3) {
        this.peerUin = j3;
    }

    public final void setPlayStatus(int i3) {
        this.playStatus = i3;
    }

    public final void setPlayerNumber(int i3) {
        this.playerNumber = i3;
    }

    public final void setReverseInfo(String str) {
        this.reverseInfo = str;
    }

    public final void setSharpPUrl(String str) {
        this.sharpPUrl = str;
    }

    public final void setType(ZPlanActionType zPlanActionType) {
        Intrinsics.checkNotNullParameter(zPlanActionType, "<set-?>");
        this.type = zPlanActionType;
    }

    public final void setUinType(int i3) {
        this.uinType = i3;
    }

    public final void setWidth(int i3) {
        this.width = i3;
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("MessageForZPlan@" + Integer.toHexString(sb5.hashCode()));
        sb5.append("{");
        sb5.append("uniseq:" + this.uniseq + ", ");
        sb5.append("id:" + this.id + ", ");
        sb5.append("name:" + this.name + ", ");
        sb5.append("peerUin:" + this.peerUin + ", ");
        sb5.append("apngUrl:" + this.apngUrl + ", ");
        sb5.append("sharpPUrl:" + this.sharpPUrl + ", ");
        sb5.append("localApng:" + this.localApng + ", ");
        sb5.append("localSharpP:" + this.localSharpP + ", ");
        sb5.append("playerNumber:" + this.playerNumber + ", ");
        sb5.append("width:" + this.width + ", ");
        sb5.append("height:" + this.height + ", ");
        sb5.append("type:" + this.type + ", ");
        sb5.append("reverseInfo:" + this.reverseInfo);
        sb5.append("}");
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    private final void fromJsonString(String jsonString) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(jsonString);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "fromJsonString: " + jsonString + ", exception", e16);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        this.id = jSONObject.optInt("id", -1);
        this.name = jSONObject.optString("name");
        this.playerNumber = jSONObject.optInt("playerNumber", 1);
        this.width = jSONObject.optInt("width", 360);
        this.height = jSONObject.optInt("height", 360);
        ZPlanActionType.Companion companion = ZPlanActionType.INSTANCE;
        this.type = companion.b(jSONObject.optInt("type", companion.a(ZPlanActionType.UNKNOWN)));
        this.peerUin = jSONObject.optLong("peerUin", 0L);
        this.apngUrl = jSONObject.optString("apngUrl");
        this.sharpPUrl = jSONObject.optString("sharpPUrl");
        this.reverseInfo = jSONObject.optString("reverseInfo");
        this.localCover = jSONObject.optString("localCover");
        this.localApng = jSONObject.optString("localApng");
        this.localSharpP = jSONObject.optString("localSharpP");
        this.playStatus = jSONObject.optInt("playStatus", 0);
    }

    @Override // com.tencent.mobileqq.pic.t
    public ZPlanPicDownloadInfo getPicDownloadInfo() {
        ZPlanPicDownloadInfo zPlanPicDownloadInfo = new ZPlanPicDownloadInfo();
        zPlanPicDownloadInfo.T = this.issend;
        zPlanPicDownloadInfo.f258713h = this.uinType;
        zPlanPicDownloadInfo.D = this.uniseq;
        zPlanPicDownloadInfo.K = getPicUrl();
        zPlanPicDownloadInfo.J = getPicUrl();
        zPlanPicDownloadInfo.R = 1;
        zPlanPicDownloadInfo.f258712f = 1;
        zPlanPicDownloadInfo.I = ProtocolDownloaderConstants.PROTOCOL_CHAT_RAW;
        zPlanPicDownloadInfo.f258715m = this.frienduin;
        if (!TextUtils.isEmpty(this.reverseInfo)) {
            try {
                zPlanPicDownloadInfo.L = new JSONObject(this.reverseInfo).optLong("groupFileId");
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "getPicDownloadInfo parse reverseInfo groupFileId exception", e16);
            }
        }
        QQAppInterface l3 = bb.f335811a.l();
        if (l3 != null) {
            zPlanPicDownloadInfo.f258714i = l3.getCurrentUin();
        }
        return zPlanPicDownloadInfo;
    }

    public final void deserializeMsgBody(byte[] bytes, int businessType) {
        ZPlanActionType zPlanActionType;
        if (bytes != null) {
            if (bytes.length == 0) {
                return;
            }
            hummer_commelem$MsgElemInfo_servtype39 hummer_commelem_msgeleminfo_servtype39 = new hummer_commelem$MsgElemInfo_servtype39();
            try {
                hummer_commelem_msgeleminfo_servtype39.mergeFrom(bytes);
                this.id = hummer_commelem_msgeleminfo_servtype39.uint32_action_id.get();
                this.name = hummer_commelem_msgeleminfo_servtype39.bytes_action_name.get().toStringUtf8();
                this.playerNumber = hummer_commelem_msgeleminfo_servtype39.uint32_player_number.get();
                if (hummer_commelem_msgeleminfo_servtype39.uint32_meme_width.get() != 0) {
                    this.width = hummer_commelem_msgeleminfo_servtype39.uint32_meme_width.get();
                }
                if (hummer_commelem_msgeleminfo_servtype39.uint32_meme_height.get() != 0) {
                    this.height = hummer_commelem_msgeleminfo_servtype39.uint32_meme_height.get();
                }
                int i3 = hummer_commelem_msgeleminfo_servtype39.uint32_action_type.get();
                if (i3 == 1) {
                    zPlanActionType = ZPlanActionType.MEME;
                } else if (i3 != 2) {
                    zPlanActionType = ZPlanActionType.UNKNOWN;
                } else {
                    zPlanActionType = ZPlanActionType.ACTION;
                }
                this.type = zPlanActionType;
                this.peerUin = hummer_commelem_msgeleminfo_servtype39.uint64_peer_uin.get();
                this.sharpPUrl = hummer_commelem_msgeleminfo_servtype39.bytes_pic_url.get().toStringUtf8();
                this.reverseInfo = hummer_commelem_msgeleminfo_servtype39.bytes_reserve_info.get().toStringUtf8();
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(TAG, 1, "deserializeMsgBody exception", e16);
            }
        }
    }
}
