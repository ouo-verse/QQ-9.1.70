package com.tencent.mobileqq.vas.social;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.api.IVasZplanApi;
import com.tencent.mobileqq.vas.social.record.RecordCacheManager;
import com.tencent.mobileqq.vas.social.record.RecordState;
import com.tencent.mobileqq.vas.social.record.RecordStepNotifyUpload;
import com.tencent.mobileqq.vas.social.record.RecordStepProduct;
import com.tencent.mobileqq.vas.social.record.RecordStickerHelper;
import com.tencent.mobileqq.vas.social.record.c;
import com.tencent.mobileqq.zplan.model.ZPlanStickerInfo;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.RecordSuccessListener;
import com.tencent.state.square.data.RecordSource;
import com.tencent.state.square.media.SquarePlayerReportConst;
import com.tencent.state.square.media.extractor.MediaCoverExtractor;
import com.tencent.state.square.media.extractor.MediaCoverReportListener;
import com.tencent.state.square.record.CloudRecordResult;
import com.tencent.state.square.record.RecordIdentifier;
import com.tencent.state.square.record.RecordIdentifierKt;
import com.tencent.state.square.record.RecordType;
import com.tencent.state.square.record.UserIdentifier;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import com.tencent.zplan.meme.b;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.meme.model.MemeFrame;
import com.tencent.zplan.meme.model.MemeResult;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\bh\u0010iJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u000fJ\u0018\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010!\u001a\u00020#H\u0016J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010'\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\u0014H\u0002J\b\u0010(\u001a\u00020\u0005H\u0002J\u0010\u0010*\u001a\u00020)2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\bH\u0002J&\u0010/\u001a\u00020,2\u0006\u0010\t\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010.H\u0002J\u001c\u00100\u001a\u00020,2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010.H\u0002J&\u00101\u001a\u00020,2\u0006\u0010\t\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010.H\u0002J\u0010\u00102\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u00103\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0013\u001a\u00020)H\u0002J\u0010\u00104\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000bH\u0002J\u0018\u00106\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u000bH\u0002J \u00109\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000b2\u0006\u00108\u001a\u000207H\u0002J;\u0010?\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010:\u001a\u0002072!\u0010>\u001a\u001d\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00050;H\u0002J\u001c\u0010@\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002JF\u0010G\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00142\u0006\u0010B\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u000f2\b\u0010E\u001a\u0004\u0018\u00010D2\b\u0010\u001f\u001a\u0004\u0018\u00010D2\b\b\u0002\u0010F\u001a\u00020\u000f2\u0006\u00108\u001a\u000207H\u0002J2\u0010J\u001a\u0004\u0018\u00010\b2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010H\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020\u000f2\u0006\u00108\u001a\u000207H\u0002J,\u0010K\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u000f2\b\u0010E\u001a\u0004\u0018\u00010D2\b\u0010\u001f\u001a\u0004\u0018\u00010D2\u0006\u00108\u001a\u000207H\u0002R\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00030L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010MR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00030L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010MR\u0014\u0010R\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010QR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010UR$\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020X\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010^\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010]R\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020\b0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010`R\"\u0010g\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010f\u00a8\u0006j"}, d2 = {"Lcom/tencent/mobileqq/vas/social/SocialActionRecordHelper;", "Lcom/tencent/zplan/meme/b;", "Lb33/c;", "Lcom/tencent/state/square/api/RecordSuccessListener;", "listener", "", "d", "I", "Lcom/tencent/mobileqq/vas/data/b;", "taskInfo", UserInfo.SEX_FEMALE, "Lcom/tencent/zplan/meme/model/MemeResult;", "o", "y", "H", "", "encodeType", "i", "Lcom/tencent/zplan/meme/action/MemeAction;", "action", "", "useSticker", "E", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/zplan/meme/action/MODE;", "mode", "l", "type", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "success", "cover", "ad", "result", "l9", "Lcom/tencent/state/square/record/CloudRecordResult;", "a", "f", "needAddToHead", "L", "G", "Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "p", "K", "Lcom/tencent/mobileqq/vas/social/record/b;", "nextStep", "Lcom/tencent/mobileqq/vas/social/record/c;", ReportConstant.COSTREPORT_PREFIX, "u", "w", "k", DomainData.DOMAIN_NAME, tl.h.F, "path", "g", "Lcom/tencent/state/square/record/RecordIdentifier;", IECDtReport.ACTION_IDENTIFIER, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "recordIdentifier", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "callback", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "isRecordSuccess", "isLocal", "actionId", "Lcom/tencent/state/square/data/RecordSource;", "mp4", "status", "B", "width", "height", "j", "D", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "listenerSet", "markNeedRemoveListenerSet", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRecordCallbacking", "isUploadCallbacking", "Lb33/a;", "Lb33/a;", "cloudRecordManager", "Lkotlin/Pair;", "", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Pair;", "currentRecordAction", "Ljava/lang/Object;", "Ljava/lang/Object;", "recordSynchronizeObject", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "recordQueue", "Z", "r", "()Z", "J", "(Z)V", "mp4SoftEncoderPrepared", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SocialActionRecordHelper implements com.tencent.zplan.meme.b, b33.c {

    /* renamed from: C, reason: from kotlin metadata */
    private static Pair<com.tencent.mobileqq.vas.data.b, Long> currentRecordAction;

    /* renamed from: F, reason: from kotlin metadata */
    private static boolean mp4SoftEncoderPrepared;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static b33.a cloudRecordManager;

    /* renamed from: d, reason: collision with root package name */
    public static final SocialActionRecordHelper f310651d = new SocialActionRecordHelper();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArraySet<RecordSuccessListener> listenerSet = new CopyOnWriteArraySet<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArraySet<RecordSuccessListener> markNeedRemoveListenerSet = new CopyOnWriteArraySet<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean isRecordCallbacking = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean isUploadCallbacking = new AtomicBoolean(false);

    /* renamed from: D, reason: from kotlin metadata */
    private static final Object recordSynchronizeObject = new Object();

    /* renamed from: E, reason: from kotlin metadata */
    private static final ConcurrentLinkedDeque<com.tencent.mobileqq.vas.data.b> recordQueue = new ConcurrentLinkedDeque<>();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f310657a;

        static {
            int[] iArr = new int[MODE.values().length];
            try {
                iArr[MODE.MP4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MODE.FRAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f310657a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/vas/social/SocialActionRecordHelper$b", "Lcom/tencent/state/square/media/extractor/MediaCoverReportListener;", "Landroid/graphics/Bitmap;", "cover", "", "getCoverDone", "onExtractDone", "", "code", "", "msg", "onError", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends MediaCoverReportListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemeResult f310658a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f310659b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f310660c;

        /* JADX WARN: Multi-variable type inference failed */
        b(MemeResult memeResult, String str, Function1<? super Boolean, Unit> function1) {
            this.f310658a = memeResult;
            this.f310659b = str;
            this.f310660c = function1;
        }

        @Override // com.tencent.state.square.media.extractor.MediaCoverListener
        public void getCoverDone(Bitmap cover) {
            Intrinsics.checkNotNullParameter(cover, "cover");
        }

        @Override // com.tencent.state.square.media.extractor.MediaCoverReportListener, com.tencent.state.square.media.extractor.MediaCoverListener
        public void onError(int code, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            super.onError(code, msg2);
            QLog.w("SocialActionRecordHelper", 1, "onError code:" + code + ", msg:" + msg2);
            this.f310660c.invoke(Boolean.FALSE);
        }

        @Override // com.tencent.state.square.media.extractor.MediaCoverReportListener, com.tencent.state.square.media.extractor.MediaCoverListener
        public void onExtractDone() {
            super.onExtractDone();
            QLog.d("SocialActionRecordHelper", 2, "onExtractDone");
            MemeResult memeResult = this.f310658a;
            memeResult.l(new MemeResult.Cover(this.f310659b, Meme.f385754h.m(memeResult.getRecordKey())));
            this.f310660c.invoke(Boolean.TRUE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/vas/social/SocialActionRecordHelper$c", "Lcom/tencent/mobileqq/vas/social/record/c;", "Lcom/tencent/mobileqq/vas/social/record/RecordState;", "stepState", "Lcom/tencent/mobileqq/vas/social/record/g;", "product", "", "timeCost", "", "a", "", "code", "", "message", "onError", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.vas.social.record.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.vas.data.b f310661a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.vas.social.record.c f310662b;

        c(com.tencent.mobileqq.vas.data.b bVar, com.tencent.mobileqq.vas.social.record.c cVar) {
            this.f310661a = bVar;
            this.f310662b = cVar;
        }

        @Override // com.tencent.mobileqq.vas.social.record.c
        public void a(RecordState stepState, RecordStepProduct product, long timeCost) {
            Intrinsics.checkNotNullParameter(stepState, "stepState");
            Intrinsics.checkNotNullParameter(product, "product");
            SocialActionRecordHelper.f310651d.D(this.f310661a.getActionId(), product.getServiceMp4(), product.getServiceCover(), this.f310661a.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String());
            com.tencent.mobileqq.vas.social.record.c cVar = this.f310662b;
            if (cVar != null) {
                cVar.a(stepState, product, timeCost);
            }
        }

        @Override // com.tencent.mobileqq.vas.social.record.c
        public void onError(int code, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            com.tencent.mobileqq.vas.social.record.c cVar = this.f310662b;
            if (cVar != null) {
                cVar.onError(code, message);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u000f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"com/tencent/mobileqq/vas/social/SocialActionRecordHelper$d", "Lcom/tencent/mobileqq/vas/social/record/c;", "Lcom/tencent/mobileqq/vas/social/record/RecordState;", "stepState", "Lcom/tencent/mobileqq/vas/social/record/g;", "product", "", "timeCost", "", "a", "J", "getEngineRecordStepCost", "()J", "setEngineRecordStepCost", "(J)V", "engineRecordStepCost", "b", "getUploadStepCost", "setUploadStepCost", "uploadStepCost", "c", "getSetMotionStepCost", "setSetMotionStepCost", "setMotionStepCost", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements com.tencent.mobileqq.vas.social.record.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long engineRecordStepCost;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long uploadStepCost;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long setMotionStepCost;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<com.tencent.mobileqq.vas.social.record.b> f310666d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.vas.data.b f310667e;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f310668a;

            static {
                int[] iArr = new int[RecordState.values().length];
                try {
                    iArr[RecordState.RECORDED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RecordState.UPLOADED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RecordState.NOTIFIED_UPLOAD.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f310668a = iArr;
            }
        }

        d(Ref.ObjectRef<com.tencent.mobileqq.vas.social.record.b> objectRef, com.tencent.mobileqq.vas.data.b bVar) {
            this.f310666d = objectRef;
            this.f310667e = bVar;
        }

        @Override // com.tencent.mobileqq.vas.social.record.c
        public void a(RecordState stepState, RecordStepProduct product, long timeCost) {
            Map<String, Object> mutableMapOf;
            Intrinsics.checkNotNullParameter(stepState, "stepState");
            Intrinsics.checkNotNullParameter(product, "product");
            int i3 = a.f310668a[stepState.ordinal()];
            if (i3 == 1) {
                this.engineRecordStepCost = timeCost;
                return;
            }
            if (i3 == 2) {
                this.uploadStepCost = timeCost;
                return;
            }
            if (i3 != 3) {
                return;
            }
            long startTime = (this.f310666d.element.getStartTime() - this.f310667e.getInitTime()) / 1000000;
            this.setMotionStepCost = timeCost;
            id3.d dVar = new id3.d(null, 1, null);
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquarePlayerReportConst.PARAM_RECORD_KEY, 1), TuplesKt.to(SquarePlayerReportConst.PARAM_RECORD_USERS, Integer.valueOf(this.f310667e.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getAllUinList().size())), TuplesKt.to(SquarePlayerReportConst.PARAM_RECORD_ID, Integer.valueOf(this.f310667e.getActionId())), TuplesKt.to(SquarePlayerReportConst.PARAM_RECORD_WIDTH, Integer.valueOf(this.f310667e.getWidth())), TuplesKt.to(SquarePlayerReportConst.PARAM_RECORD_HEIGHT, Integer.valueOf(this.f310667e.getHeight())), TuplesKt.to(SquarePlayerReportConst.PARAM_RECORD_ENCODE_TYPE, this.f310667e.getMode()), TuplesKt.to(SquarePlayerReportConst.PARAM_RECORD_WAIT, Long.valueOf(startTime)), TuplesKt.to(SquarePlayerReportConst.PARAM_RECORD_ENGINE_COST, Long.valueOf(this.engineRecordStepCost)), TuplesKt.to(SquarePlayerReportConst.PARAM_RECORD_UPLOAD_COST, Long.valueOf(this.uploadStepCost)), TuplesKt.to(SquarePlayerReportConst.PARAM_RECORD_BIND_COST, Long.valueOf(this.setMotionStepCost)), TuplesKt.to(SquarePlayerReportConst.PARAM_RECORD_ALL_COST, Long.valueOf(startTime + this.engineRecordStepCost + this.uploadStepCost + this.setMotionStepCost)));
            dVar.d(SquarePlayerReportConst.EVENT_RECORD_TASK, mutableMapOf);
        }

        @Override // com.tencent.mobileqq.vas.social.record.c
        public void onError(int i3, String str) {
            c.a.a(this, i3, str);
        }
    }

    SocialActionRecordHelper() {
    }

    private final void A(final boolean success, final MemeResult result, final RecordIdentifier identifier) {
        QLog.d("SocialActionRecordHelper", 2, "[RECORD] notifyCommon");
        CopyOnWriteArraySet<RecordSuccessListener> copyOnWriteArraySet = listenerSet;
        synchronized (copyOnWriteArraySet) {
            isRecordCallbacking.set(true);
            CopyOnWriteArraySet<RecordSuccessListener> copyOnWriteArraySet2 = markNeedRemoveListenerSet;
            copyOnWriteArraySet.removeAll(copyOnWriteArraySet2);
            copyOnWriteArraySet2.clear();
            Iterator<RecordSuccessListener> it = copyOnWriteArraySet.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "listenerSet.iterator()");
            while (it.hasNext()) {
                final RecordSuccessListener next = it.next();
                SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.social.SocialActionRecordHelper$notifyCommon$1$1
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
                        RecordSuccessListener.this.onRecordDone(success, result, identifier);
                    }
                });
            }
            isRecordCallbacking.set(false);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(final boolean isRecordSuccess, final boolean isLocal, final int actionId, final RecordSource mp42, final RecordSource cover, final int status, final RecordIdentifier identifier) {
        QLog.d("SocialActionRecordHelper", 1, "[RECORD] 6.notifyRecordSuccess success:" + isRecordSuccess + ", actionId:" + actionId + ", mp4:" + mp42 + ", cover:" + cover);
        CopyOnWriteArraySet<RecordSuccessListener> copyOnWriteArraySet = listenerSet;
        synchronized (copyOnWriteArraySet) {
            isRecordCallbacking.set(true);
            CopyOnWriteArraySet<RecordSuccessListener> copyOnWriteArraySet2 = markNeedRemoveListenerSet;
            copyOnWriteArraySet.removeAll(copyOnWriteArraySet2);
            copyOnWriteArraySet2.clear();
            Iterator<RecordSuccessListener> it = copyOnWriteArraySet.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "listenerSet.iterator()");
            while (it.hasNext()) {
                final RecordSuccessListener next = it.next();
                SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.social.SocialActionRecordHelper$notifyRecordDone$1$1

                    /* compiled from: P */
                    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                    /* loaded from: classes35.dex */
                    public /* synthetic */ class a {

                        /* renamed from: a, reason: collision with root package name */
                        public static final /* synthetic */ int[] f310669a;

                        static {
                            int[] iArr = new int[RecordType.values().length];
                            try {
                                iArr[RecordType.MP4_SQUARE.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[RecordType.FILAMENT_SQUARE.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            try {
                                iArr[RecordType.FILAMENT_NEARBY.ordinal()] = 3;
                            } catch (NoSuchFieldError unused3) {
                            }
                            f310669a = iArr;
                        }
                    }

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
                        RecordSource recordSource;
                        RecordSource recordSource2;
                        RecordSource recordSource3;
                        int i3 = a.f310669a[RecordIdentifier.this.getType().ordinal()];
                        if (i3 == 1) {
                            if (isRecordSuccess && (recordSource = mp42) != null && (recordSource2 = cover) != null) {
                                if (isLocal) {
                                    next.onLocalRecordSuccess(actionId, RecordIdentifier.this, recordSource2, recordSource);
                                    return;
                                } else {
                                    next.onCloudRecordSuccess(actionId, RecordIdentifier.this, recordSource2, recordSource);
                                    return;
                                }
                            }
                            next.onRecordError(actionId, 0, status, RecordIdentifier.this);
                            return;
                        }
                        if (i3 == 2 || i3 == 3) {
                            if (isRecordSuccess && (recordSource3 = cover) != null) {
                                if (isLocal) {
                                    next.onLocalRecordSuccess(actionId, RecordIdentifier.this, recordSource3, null);
                                    return;
                                } else {
                                    next.onCloudRecordSuccess(actionId, RecordIdentifier.this, recordSource3, null);
                                    return;
                                }
                            }
                            next.onRecordError(actionId, 0, status, RecordIdentifier.this);
                        }
                    }
                });
                it = it;
            }
            isRecordCallbacking.set(false);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void G() {
        com.tencent.mobileqq.vas.data.b pollFirst;
        QLog.d("SocialActionRecordHelper", 2, "do recordNext");
        synchronized (recordSynchronizeObject) {
            currentRecordAction = null;
            Unit unit = Unit.INSTANCE;
        }
        ConcurrentLinkedDeque<com.tencent.mobileqq.vas.data.b> concurrentLinkedDeque = recordQueue;
        synchronized (concurrentLinkedDeque) {
            pollFirst = concurrentLinkedDeque.pollFirst();
        }
        if (pollFirst == null) {
            QLog.d("SocialActionRecordHelper", 2, "recordNext poll null");
        } else {
            L(pollFirst, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0071 A[Catch: all -> 0x0159, TryCatch #1 {, blocks: (B:4:0x0029, B:6:0x002e, B:10:0x0045, B:12:0x0071, B:14:0x0091, B:15:0x0152, B:19:0x009d, B:20:0x009f, B:41:0x0130, B:42:0x0131, B:47:0x0157, B:48:0x0158, B:22:0x00a0, B:24:0x00bc, B:26:0x00c4, B:30:0x00d3, B:32:0x00e3, B:34:0x00f3, B:40:0x010a, B:43:0x010e, B:44:0x0112), top: B:3:0x0029, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009d A[Catch: all -> 0x0159, TryCatch #1 {, blocks: (B:4:0x0029, B:6:0x002e, B:10:0x0045, B:12:0x0071, B:14:0x0091, B:15:0x0152, B:19:0x009d, B:20:0x009f, B:41:0x0130, B:42:0x0131, B:47:0x0157, B:48:0x0158, B:22:0x00a0, B:24:0x00bc, B:26:0x00c4, B:30:0x00d3, B:32:0x00e3, B:34:0x00f3, B:40:0x010a, B:43:0x010e, B:44:0x0112), top: B:3:0x0029, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void L(com.tencent.mobileqq.vas.data.b taskInfo, boolean needAddToHead) {
        boolean z16;
        com.tencent.mobileqq.vas.data.b first;
        long currentTimeMillis = System.currentTimeMillis();
        QLog.d("SocialActionRecordHelper", 1, "[RECORD] 3.tryStartRecord current:" + currentTimeMillis + ", info:" + taskInfo);
        synchronized (recordSynchronizeObject) {
            Pair<com.tencent.mobileqq.vas.data.b, Long> pair = currentRecordAction;
            boolean z17 = false;
            if (pair != null && currentTimeMillis - pair.getSecond().longValue() <= 60000) {
                z16 = false;
                QLog.d("SocialActionRecordHelper", 1, "[RECORD] 3.0 canStartNow current:" + currentTimeMillis + ", currentAction:" + pair + ", canStartNow:" + z16);
                if (!z16) {
                    QLog.d("SocialActionRecordHelper", 1, "[RECORD] 3.1 currentRecordAction is null, start record now, info:" + taskInfo);
                    if (!f310651d.K(taskInfo)) {
                        currentRecordAction = TuplesKt.to(taskInfo, Long.valueOf(currentTimeMillis));
                    }
                } else {
                    ConcurrentLinkedDeque<com.tencent.mobileqq.vas.data.b> concurrentLinkedDeque = recordQueue;
                    synchronized (concurrentLinkedDeque) {
                        com.tencent.mobileqq.vas.data.b j3 = f310651d.j(taskInfo.getActionId(), taskInfo.getMode(), taskInfo.getWidth(), taskInfo.getHeight(), taskInfo.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String());
                        if (((pair == null || (first = pair.getFirst()) == null || first.getActionId() != taskInfo.getActionId()) ? false : true) && pair.getFirst().getMode() == taskInfo.getMode() && pair.getFirst().getWidth() == taskInfo.getWidth() && pair.getFirst().getHeight() == taskInfo.getHeight()) {
                            z17 = true;
                        }
                        if (j3 != null || z17) {
                            QLog.d("SocialActionRecordHelper", 1, "[RECORD] 3.2-1 currentRecordAction is not null, but item is in queue, queueSize:" + concurrentLinkedDeque.size());
                            Unit unit = Unit.INSTANCE;
                        } else if (needAddToHead) {
                            concurrentLinkedDeque.offerFirst(taskInfo);
                        } else {
                            concurrentLinkedDeque.offer(taskInfo);
                        }
                    }
                    QLog.d("SocialActionRecordHelper", 1, "[RECORD] 3.2 currentRecordAction is not null, offer to queue, needAddToHead:" + needAddToHead + ", info:" + taskInfo);
                }
                Unit unit2 = Unit.INSTANCE;
            }
            z16 = true;
            QLog.d("SocialActionRecordHelper", 1, "[RECORD] 3.0 canStartNow current:" + currentTimeMillis + ", currentAction:" + pair + ", canStartNow:" + z16);
            if (!z16) {
            }
            Unit unit22 = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a3, code lost:
    
        if (r12 != false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e(MemeResult result, RecordIdentifier recordIdentifier, Function1<? super Boolean, Unit> callback) {
        boolean z16;
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        MemeResult.Cover cover = result.getCover();
        String path = cover != null ? cover.getPath() : null;
        String recordPath = result.getRecordPath();
        Meme meme = Meme.f385754h;
        String l3 = meme.l(result.getRecordKey());
        boolean z17 = false;
        if (recordPath != null) {
            isBlank3 = StringsKt__StringsJVMKt.isBlank(recordPath);
            if (!isBlank3) {
                z16 = false;
                boolean z18 = z16 && new File(recordPath).exists();
                QLog.d("SocialActionRecordHelper", 2, "checkAndExtractCover cover:" + path + ", videoPath:" + recordPath + ", videoValid:" + z18 + ", coverPath:" + l3 + ", type:" + recordIdentifier.getType());
                if (!recordIdentifier.getType().isFilamentFrame()) {
                    result.l(new MemeResult.Cover(result.getRecordPath(), meme.m(result.getRecordKey())));
                    callback.invoke(Boolean.TRUE);
                    return;
                }
                if (path != null) {
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(path);
                }
                z17 = true;
                if (!z17) {
                    Intrinsics.checkNotNull(path);
                    if (new File(path).exists()) {
                        callback.invoke(Boolean.TRUE);
                        return;
                    }
                }
                if (z18) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(l3);
                    if ((!isBlank) && new File(l3).exists()) {
                        QLog.d("SocialActionRecordHelper", 2, "coverPath exist");
                        callback.invoke(Boolean.TRUE);
                        return;
                    }
                    try {
                        MediaCoverExtractor mediaCoverExtractor = new MediaCoverExtractor();
                        Intrinsics.checkNotNull(recordPath);
                        mediaCoverExtractor.extract(recordPath, l3, new b(result, l3, callback));
                        return;
                    } catch (Throwable unused) {
                        QLog.e("SocialActionRecordHelper", 1, "extractCover path error: " + recordPath + ", " + l3);
                        return;
                    }
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
        QLog.d("SocialActionRecordHelper", 2, "checkAndExtractCover cover:" + path + ", videoPath:" + recordPath + ", videoValid:" + z18 + ", coverPath:" + l3 + ", type:" + recordIdentifier.getType());
        if (!recordIdentifier.getType().isFilamentFrame()) {
        }
    }

    private final boolean g(String path, MemeResult result) {
        String str;
        Map<String, Object> mutableMapOf;
        try {
            long d16 = ((IVasZplanApi) QRoute.api(IVasZplanApi.class)).getConfig().d().d();
            if (d16 > 0) {
                com.tencent.zplan.common.utils.c cVar = com.tencent.zplan.common.utils.c.f385288a;
                long i3 = cVar.i(path);
                boolean z16 = i3 > d16;
                if (!z16) {
                    QLog.d("SocialActionRecordHelper", 1, "checkMp4tFile fileSize invalid, delete file: " + cVar.g(path));
                    com.tencent.mobileqq.zplan.report.c cVar2 = com.tencent.mobileqq.zplan.report.c.f335070a;
                    Pair[] pairArr = new Pair[3];
                    pairArr[0] = TuplesKt.to("param_square_record_action_desc", result.getAction().getDesc());
                    pairArr[1] = TuplesKt.to("param_square_record_file_size", Boolean.valueOf(z16));
                    wx4.d i16 = result.i();
                    if (i16 == null || (str = i16.toString()) == null) {
                        str = "";
                    }
                    pairArr[2] = TuplesKt.to("param_square_record_action_statistic", str);
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                    cVar2.a("ev_square_record_check_mp4", mutableMapOf);
                }
                QLog.d("SocialActionRecordHelper", 1, "check mp4 path tempSize:" + i3 + ", mp4FileSizeLimit:" + d16);
                return z16;
            }
        } catch (Throwable th5) {
            QLog.e("SocialActionRecordHelper", 1, "check mp4 path size throw:", th5);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean h(MemeResult result) {
        boolean z16;
        boolean isBlank;
        String recordPath = result.getRecordPath();
        if (recordPath != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(recordPath);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    QLog.e("SocialActionRecordHelper", 1, "checkMp4File path invalid");
                    return false;
                }
                if (!new File(recordPath).exists()) {
                    QLog.e("SocialActionRecordHelper", 1, "checkMp4File file not exist");
                    return false;
                }
                if (result.getAction().getMode() == MODE.MP4) {
                    return g(recordPath, result);
                }
                return true;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    private final com.tencent.mobileqq.vas.data.b j(int actionId, MODE mode, int width, int height, RecordIdentifier identifier) {
        Object obj;
        Iterator<T> it = recordQueue.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            com.tencent.mobileqq.vas.data.b bVar = (com.tencent.mobileqq.vas.data.b) obj;
            if (bVar.getActionId() == actionId && bVar.getMode() == mode && bVar.getWidth() == width && bVar.getHeight() == height && RecordIdentifierKt.isSame(bVar.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String(), identifier)) {
                break;
            }
        }
        return (com.tencent.mobileqq.vas.data.b) obj;
    }

    private final void k(com.tencent.mobileqq.vas.data.b taskInfo) {
        MemeZPlanAction p16 = p(taskInfo);
        l9(true, new MemeResult(p16, p16.getKey(), n(p16)));
    }

    private final String n(MemeZPlanAction action) {
        File o16 = Meme.f385754h.o(action.getKey());
        if (o16 == null || !o16.exists()) {
            return null;
        }
        return o16.getAbsolutePath();
    }

    private final MemeZPlanAction p(com.tencent.mobileqq.vas.data.b taskInfo) {
        q03.e d16 = ((IVasZplanApi) QRoute.api(IVasZplanApi.class)).getConfig().d();
        int actionId = taskInfo.getParams().getActionId();
        int frameCount = taskInfo.getParams().getMode().toFrameCount();
        int width = taskInfo.getParams().getWidth();
        int height = taskInfo.getParams().getHeight();
        MODE mode = taskInfo.getParams().getMode();
        String uin = taskInfo.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getSender().getUin();
        UserIdentifier receiver = taskInfo.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getReceiver();
        String uin2 = receiver != null ? receiver.getUin() : null;
        String md5 = MD5Utils.toMD5(taskInfo.getParams().getActionId() + "_" + taskInfo.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getSender());
        Integer gender = taskInfo.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getSender().getGender();
        UserIdentifier receiver2 = taskInfo.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getReceiver();
        Integer gender2 = receiver2 != null ? receiver2.getGender() : null;
        String extraParams = taskInfo.getExtraParams();
        AvatarCharacterInfo senderAvatarCharacterInfo = taskInfo.getSenderAvatarCharacterInfo();
        AvatarCharacterInfo receiverAvatarCharacterInfo = taskInfo.getReceiverAvatarCharacterInfo();
        Intrinsics.checkNotNullExpressionValue(md5, "toMD5(\"${taskInfo.params\u2026Info.identifier.sender}\")");
        MemeZPlanAction memeZPlanAction = new MemeZPlanAction(actionId, frameCount, width, height, mode, uin, uin2, md5, null, gender, gender2, senderAvatarCharacterInfo, receiverAvatarCharacterInfo, extraParams, 256, null);
        memeZPlanAction.getConfig().v(Integer.valueOf(d16.c()));
        memeZPlanAction.getConfig().w(Integer.valueOf(d16.f()));
        memeZPlanAction.getConfig().D(500);
        memeZPlanAction.getConfig().getMp4Config().getCover().c(true);
        memeZPlanAction.getConfig().getMp4Config().m(d16.g());
        memeZPlanAction.getConfig().C(BusinessConfig.FrameType.PNG);
        memeZPlanAction.getConfig().x(taskInfo.getParams().getActionStyle());
        if (!taskInfo.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getReceivers().isEmpty()) {
            memeZPlanAction.getConfig().M(true);
        }
        if (taskInfo.getTargetEngine() != null) {
            memeZPlanAction.getConfig().G(taskInfo.getTargetEngine());
        }
        return memeZPlanAction;
    }

    private final com.tencent.mobileqq.vas.social.record.b s(com.tencent.mobileqq.vas.data.b taskInfo, com.tencent.mobileqq.vas.social.record.b nextStep, com.tencent.mobileqq.vas.social.record.c listener) {
        com.tencent.mobileqq.vas.social.record.f fVar = new com.tencent.mobileqq.vas.social.record.f(taskInfo, listener);
        if (nextStep != null) {
            fVar.a(nextStep);
        }
        return fVar;
    }

    private final com.tencent.mobileqq.vas.social.record.b u(com.tencent.mobileqq.vas.data.b taskInfo, com.tencent.mobileqq.vas.social.record.c listener) {
        return new RecordStepNotifyUpload(taskInfo, listener);
    }

    private final com.tencent.mobileqq.vas.social.record.b w(com.tencent.mobileqq.vas.data.b taskInfo, com.tencent.mobileqq.vas.social.record.b nextStep, com.tencent.mobileqq.vas.social.record.c listener) {
        com.tencent.mobileqq.vas.social.record.d dVar = new com.tencent.mobileqq.vas.social.record.d(taskInfo, new c(taskInfo, listener));
        if (nextStep != null) {
            dVar.a(nextStep);
        }
        return dVar;
    }

    public final void E(final MemeAction action, boolean useSticker) {
        Priority priority;
        Intrinsics.checkNotNullParameter(action, "action");
        final MODE mode = action.getMode();
        final int actionId = action.getActionId();
        if (!useSticker) {
            Meme meme = Meme.f385754h;
            if (mode == MODE.MP4) {
                priority = Priority.HIGH;
            } else {
                priority = Priority.MIDDLE;
            }
            meme.A(action, priority, this);
            QLog.d("SocialActionRecordHelper", 1, "[RECORD] 5-1.2-0 push action to ue record useSticker:" + useSticker + " action:" + action);
            return;
        }
        RecordStickerHelper.d(RecordStickerHelper.f310804a, new int[]{actionId}, new Function2<Boolean, ZPlanStickerInfo[], Unit>() { // from class: com.tencent.mobileqq.vas.social.SocialActionRecordHelper$recordAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, ZPlanStickerInfo[] zPlanStickerInfoArr) {
                invoke(bool.booleanValue(), zPlanStickerInfoArr);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, ZPlanStickerInfo[] result) {
                ZPlanStickerInfo zPlanStickerInfo;
                Intrinsics.checkNotNullParameter(result, "result");
                if (z16) {
                    int i3 = actionId;
                    int length = result.length;
                    int i16 = 0;
                    while (true) {
                        if (i16 >= length) {
                            zPlanStickerInfo = null;
                            break;
                        }
                        zPlanStickerInfo = result[i16];
                        if (zPlanStickerInfo.getStickerId() == i3) {
                            break;
                        } else {
                            i16++;
                        }
                    }
                    if (zPlanStickerInfo != null) {
                        BusinessConfig config = MemeAction.this.getConfig();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(String.valueOf(zPlanStickerInfo.getStickerId()), zPlanStickerInfo.getData());
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026             }.toString()");
                        config.F(jSONObject2);
                    }
                    Meme.f385754h.A(MemeAction.this, mode == MODE.MP4 ? Priority.HIGH : Priority.MIDDLE, this);
                    QLog.d("SocialActionRecordHelper", 1, "[RECORD] 5-1.2-1 push action to ue record: uin:" + MemeAction.this.getSenderUin() + "-" + MemeAction.this.getReceiverUin() + ", actionId:" + actionId + ", mode:" + mode.name() + ", taskId:" + MemeAction.this.getTaskId());
                    return;
                }
                Meme.f385754h.A(MemeAction.this, mode == MODE.MP4 ? Priority.HIGH : Priority.MIDDLE, this);
                QLog.d("SocialActionRecordHelper", 1, "[RECORD] 5-1.2-2 push action to ue record: uin:" + MemeAction.this.getSenderUin() + "-" + MemeAction.this.getReceiverUin() + ", actionId:" + actionId + ", mode:" + mode.name() + ", taskId:" + MemeAction.this.getTaskId());
            }
        }, 0L, 4, null);
    }

    public final void F(com.tencent.mobileqq.vas.data.b taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        QLog.d("SocialActionRecordHelper", 1, "[RECORD] 1.recordAvatarAction params:" + taskInfo);
        if (f(taskInfo)) {
            L(taskInfo, taskInfo.getNeedAddToHead());
        }
    }

    public final void H() {
        b33.a aVar = cloudRecordManager;
        if (aVar != null) {
            aVar.e();
            aVar.d();
        }
        cloudRecordManager = null;
        QLog.d("SocialActionRecordHelper", 4, "releasePushManager");
    }

    public final synchronized void I(RecordSuccessListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!isRecordCallbacking.get() && !isUploadCallbacking.get()) {
            CopyOnWriteArraySet<RecordSuccessListener> copyOnWriteArraySet = listenerSet;
            synchronized (copyOnWriteArraySet) {
                copyOnWriteArraySet.remove(listener);
            }
        }
        markNeedRemoveListenerSet.add(listener);
    }

    public final void J(boolean z16) {
        mp4SoftEncoderPrepared = z16;
    }

    @Override // com.tencent.zplan.meme.b
    public void Z1(MemeFrame memeFrame) {
        b.a.b(this, memeFrame);
    }

    @Override // com.tencent.zplan.meme.b
    public void ad(boolean success, MemeResult cover) {
        Intrinsics.checkNotNullParameter(cover, "cover");
    }

    public final synchronized void d(RecordSuccessListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArraySet<RecordSuccessListener> copyOnWriteArraySet = listenerSet;
        synchronized (copyOnWriteArraySet) {
            if (!copyOnWriteArraySet.contains(listener)) {
                copyOnWriteArraySet.add(listener);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.zplan.meme.a
    public void d3(MemeAction memeAction, float f16) {
        b.a.a(this, memeAction, f16);
    }

    public final int l(MODE mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        int i3 = a.f310657a[mode.ordinal()];
        if (i3 != 1) {
            return i3 != 2 ? 0 : 1;
        }
        return 2;
    }

    public final String m(com.tencent.mobileqq.vas.data.b taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        return n(p(taskInfo));
    }

    public final MemeResult o(com.tencent.mobileqq.vas.data.b taskInfo) {
        MemeAction.Cache cache;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        List<MemeAction.Cache> cachedFiles = p(taskInfo).getCachedFiles();
        if (cachedFiles != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) cachedFiles);
            cache = (MemeAction.Cache) firstOrNull;
        } else {
            cache = null;
        }
        if (cache != null) {
            return cache.getResult();
        }
        return null;
    }

    public final boolean r() {
        return mp4SoftEncoderPrepared;
    }

    public final void y() {
        b33.a aVar = new b33.a();
        aVar.c();
        aVar.f(this);
        cloudRecordManager = aVar;
        QLog.d("SocialActionRecordHelper", 4, "initPushManager");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean f(com.tencent.mobileqq.vas.data.b taskInfo) {
        MemeAction.Cache cache;
        boolean z16;
        CloudRecordResult b16;
        boolean z17;
        boolean isBlank;
        boolean isBlank2;
        MemeResult result;
        MemeResult.Cover cover;
        MemeResult result2;
        Object firstOrNull;
        QLog.d("SocialActionRecordHelper", 1, "[RECORD] 2.checkCacheAndCallback info:" + taskInfo);
        List<MemeAction.Cache> cachedFiles = p(taskInfo).getCachedFiles();
        if (cachedFiles != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) cachedFiles);
            cache = (MemeAction.Cache) firstOrNull;
        } else {
            cache = null;
        }
        String recordPath = (cache == null || (result2 = cache.getResult()) == null) ? null : result2.getRecordPath();
        String path = (cache == null || (result = cache.getResult()) == null || (cover = result.getCover()) == null) ? null : cover.getPath();
        if (recordPath != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(recordPath);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    if (path != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(path);
                        if (!isBlank) {
                            z17 = false;
                            if (!z17) {
                                G();
                                if (taskInfo.getForceCallback()) {
                                    try {
                                        String encodeFileHexStr = MD5Utils.encodeFileHexStr(recordPath);
                                        Intrinsics.checkNotNullExpressionValue(encodeFileHexStr, "encodeFileHexStr(localPath)");
                                        String lowerCase = encodeFileHexStr.toLowerCase();
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                                        RecordSource recordSource = new RecordSource(recordPath, lowerCase);
                                        String encodeFileHexStr2 = MD5Utils.encodeFileHexStr(path);
                                        Intrinsics.checkNotNullExpressionValue(encodeFileHexStr2, "encodeFileHexStr(coverPath)");
                                        String lowerCase2 = encodeFileHexStr2.toLowerCase();
                                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                                        C(this, true, true, taskInfo.getActionId(), recordSource, new RecordSource(path, lowerCase2), 0, taskInfo.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String(), 32, null);
                                    } catch (Exception e16) {
                                        QLog.e("SocialActionRecordHelper", 1, "checkCacheAndCallback throw e:", e16);
                                        return false;
                                    }
                                }
                                QLog.d("SocialActionRecordHelper", 1, "[RECORD] 2.1 check had local file, info:" + taskInfo);
                                K(taskInfo);
                                return false;
                            }
                        }
                    }
                    z17 = true;
                    if (!z17) {
                    }
                }
                b33.a aVar = cloudRecordManager;
                b16 = aVar != null ? aVar.b(taskInfo.getActionId(), taskInfo.getDressKeys().getOwner(), b33.b.c(taskInfo.getMode()), taskInfo.getWidth(), taskInfo.getHeight()) : null;
                if (b16 == null && b33.b.b(b16.getType()) != null) {
                    G();
                    if (taskInfo.getForceCallback()) {
                        C(this, true, false, b16.getActionId(), new RecordSource(b16.getUrl(), b16.getMd5()), null, 0, taskInfo.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String(), 32, null);
                    }
                    QLog.d("SocialActionRecordHelper", 1, "[RECORD] 2.2 check attach push cache, info:" + taskInfo);
                    return false;
                }
                QLog.d("SocialActionRecordHelper", 1, "[RECORD] 2.3 not attach any cache, info:" + taskInfo);
                return true;
            }
        }
        z16 = true;
        if (!z16) {
        }
        b33.a aVar2 = cloudRecordManager;
        if (aVar2 != null) {
        }
        if (b16 == null) {
        }
        QLog.d("SocialActionRecordHelper", 1, "[RECORD] 2.3 not attach any cache, info:" + taskInfo);
        return true;
    }

    @Override // b33.c
    public void a(CloudRecordResult result) {
        com.tencent.mobileqq.vas.data.b j3;
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.d("SocialActionRecordHelper", 1, "[RECORD] 6.onCloudRecordDone result:" + result);
        MODE b16 = b33.b.b(result.getType());
        if (b16 == null) {
            QLog.w("SocialActionRecordHelper", 2, "onCloudRecordDone formatRecordMode error " + result.getType());
            return;
        }
        C(this, true, false, result.getActionId(), new RecordSource(result.getUrl(), result.getMd5()), new RecordSource(result.getCoverUrl(), result.getCoverMd5()), 0, result.getIdentifier(), 32, null);
        ConcurrentLinkedDeque<com.tencent.mobileqq.vas.data.b> concurrentLinkedDeque = recordQueue;
        synchronized (concurrentLinkedDeque) {
            j3 = f310651d.j(result.getActionId(), b16, result.getRecordWidth(), result.getRecordHeight(), result.getIdentifier());
            if (j3 != null) {
                concurrentLinkedDeque.remove(j3);
            }
            QLog.d("SocialActionRecordHelper", 2, "[RECORD] 6.onCloudRecordDone queue remove info:" + j3 + ", result:" + result);
            Unit unit = Unit.INSTANCE;
        }
        if (j3 != null) {
            com.tencent.mobileqq.zplan.report.c cVar = com.tencent.mobileqq.zplan.report.c.f335070a;
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.to("zplan_operation_id", "em_zplan_operation_pop_record");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
            if (currentAccountUin == null) {
                currentAccountUin = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(currentAccountUin, "MobileQQ.sMobileQQ.peekA\u2026?.currentAccountUin ?: \"\"");
            }
            pairArr[1] = TuplesKt.to("zplan_touin", currentAccountUin);
            pairArr[2] = TuplesKt.to("zplan_operation_value", "1");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            cVar.a("ev_zplan_terminal_technology", mutableMapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(final int actionId, final RecordSource mp42, final RecordSource cover, final RecordIdentifier identifier) {
        if (cover == null) {
            QLog.w("SocialActionRecordHelper", 1, "notifyUpload but cover is null");
            return;
        }
        if (identifier.getType() == RecordType.MP4_SQUARE && mp42 == null) {
            QLog.w("SocialActionRecordHelper", 1, "notifyUpload but mp4 is null");
            return;
        }
        CopyOnWriteArraySet<RecordSuccessListener> copyOnWriteArraySet = listenerSet;
        synchronized (copyOnWriteArraySet) {
            isUploadCallbacking.set(true);
            CopyOnWriteArraySet<RecordSuccessListener> copyOnWriteArraySet2 = markNeedRemoveListenerSet;
            copyOnWriteArraySet.removeAll(copyOnWriteArraySet2);
            copyOnWriteArraySet2.clear();
            Iterator<RecordSuccessListener> it = copyOnWriteArraySet.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "listenerSet.iterator()");
            while (it.hasNext()) {
                final RecordSuccessListener next = it.next();
                SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.social.SocialActionRecordHelper$notifyUpload$1$1
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
                        RecordSuccessListener.this.onUploadSuccess(actionId, identifier, cover, mp42);
                    }
                });
            }
            isUploadCallbacking.set(false);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean K(com.tencent.mobileqq.vas.data.b taskInfo) {
        com.tencent.mobileqq.vas.social.record.b bVar;
        com.tencent.mobileqq.vas.social.record.b bVar2;
        String str;
        T t16;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        RecordCacheManager recordCacheManager = RecordCacheManager.f310795a;
        String f16 = recordCacheManager.f(taskInfo.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String(), taskInfo.getActionId(), taskInfo.getParams().getMode());
        RecordStepProduct e16 = recordCacheManager.e(taskInfo.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String(), taskInfo.getActionId(), taskInfo.getMode());
        boolean z16 = true;
        QLog.d("SocialActionRecordHelper", 1, "[RECORD] 4.startRecordStepLink info:" + taskInfo + ", state:" + f16 + ", product:" + e16);
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        com.tencent.mobileqq.vas.social.record.b v3 = v(this, taskInfo, null, 2, null);
        com.tencent.mobileqq.vas.social.record.b x16 = x(this, taskInfo, v3, null, 4, null);
        com.tencent.mobileqq.vas.social.record.b t17 = t(this, taskInfo, x16, null, 4, null);
        if (Intrinsics.areEqual(f16, "RECORDED")) {
            if (taskInfo.getForceCallback()) {
                k(taskInfo);
            }
            bVar = t17;
            bVar2 = v3;
            objectRef = objectRef3;
            str = "SocialActionRecordHelper";
            t16 = x16;
        } else if (!Intrinsics.areEqual(f16, "UPLOADED")) {
            bVar = t17;
            bVar2 = v3;
            str = "SocialActionRecordHelper";
            z16 = false;
            t16 = bVar;
            objectRef = objectRef3;
        } else {
            if (!taskInfo.getForceCallback()) {
                bVar = t17;
                bVar2 = v3;
                objectRef2 = objectRef3;
                str = "SocialActionRecordHelper";
            } else {
                G();
                bVar = t17;
                bVar2 = v3;
                objectRef2 = objectRef3;
                str = "SocialActionRecordHelper";
                C(this, true, true, taskInfo.getActionId(), e16.getLocalMp4(), e16.getLocalCover(), 0, taskInfo.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String(), 32, null);
                D(taskInfo.getActionId(), e16.getServiceMp4(), e16.getServiceCover(), taskInfo.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String());
            }
            t16 = bVar2;
            objectRef = objectRef2;
            z16 = true;
        }
        objectRef.element = t16;
        if (TextUtils.isEmpty(m(taskInfo))) {
            objectRef.element = bVar;
        }
        d dVar = new d(objectRef, taskInfo);
        ((com.tencent.mobileqq.vas.social.record.b) objectRef.element).o(dVar);
        x16.o(dVar);
        bVar2.o(dVar);
        ((com.tencent.mobileqq.vas.social.record.b) objectRef.element).l(com.tencent.mobileqq.vas.social.record.e.b(f16), e16);
        QLog.d(str, 1, "[RECORD] 4.1 handleStep info:" + taskInfo + ", rootStep:" + objectRef.element + ", state:" + f16 + ", product:" + e16 + ", alreadyDone:" + z16);
        return z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00db, code lost:
    
        if (r10 != false) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(com.tencent.mobileqq.vas.data.b taskInfo, int encodeType) {
        MemeAction.Cache cache;
        boolean z16;
        boolean isBlank;
        boolean isBlank2;
        MemeResult result;
        MemeResult.Cover cover;
        MemeResult result2;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        QLog.d("SocialActionRecordHelper", 1, "[RECORD] 5-1.1 doRecordAction info:" + taskInfo + ", encodeType:" + encodeType);
        MemeZPlanAction p16 = p(taskInfo);
        List<MemeAction.Cache> cachedFiles = p16.getCachedFiles();
        String str = null;
        if (cachedFiles != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) cachedFiles);
            cache = (MemeAction.Cache) firstOrNull;
        } else {
            cache = null;
        }
        String recordPath = (cache == null || (result2 = cache.getResult()) == null) ? null : result2.getRecordPath();
        if (cache != null && (result = cache.getResult()) != null && (cover = result.getCover()) != null) {
            str = cover.getPath();
        }
        boolean z17 = false;
        boolean z18 = !(taskInfo.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getType() == RecordType.FILAMENT_NEARBY) && ((IVasZplanApi) QRoute.api(IVasZplanApi.class)).getConfig().d().a();
        QLog.d("SocialActionRecordHelper", 2, "recordAction info:" + taskInfo + ", cache:" + cache + " localPath:" + recordPath + ", coverPath:" + str + ", useSticker:" + z18);
        if (recordPath != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(recordPath);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    if (str != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(str);
                    }
                    z17 = true;
                    if (!z17) {
                        if (taskInfo.getForceCallback()) {
                            G();
                            try {
                                String encodeFileHexStr = MD5Utils.encodeFileHexStr(recordPath);
                                Intrinsics.checkNotNullExpressionValue(encodeFileHexStr, "encodeFileHexStr(localPath)");
                                String lowerCase = encodeFileHexStr.toLowerCase();
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                                RecordSource recordSource = new RecordSource(recordPath, lowerCase);
                                String encodeFileHexStr2 = MD5Utils.encodeFileHexStr(str);
                                Intrinsics.checkNotNullExpressionValue(encodeFileHexStr2, "encodeFileHexStr(coverPath)");
                                String lowerCase2 = encodeFileHexStr2.toLowerCase();
                                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                                C(this, true, true, cache.getPortraitId(), recordSource, new RecordSource(str, lowerCase2), 0, taskInfo.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String(), 32, null);
                            } catch (Exception e16) {
                                QLog.e("SocialActionRecordHelper", 1, "doRecordAction throw e:", e16);
                            }
                        }
                        return;
                    }
                }
                QLog.d("SocialActionRecordHelper", 2, "doRecordAction portraitId:" + p16.getPortraitId() + ", mode:" + p16.getMode().name() + ", uin:" + p16.getSenderUin());
                p16.getConfig().getMp4Config().l(encodeType);
                E(p16, z18);
            }
        }
        z16 = true;
        if (!z16) {
        }
        QLog.d("SocialActionRecordHelper", 2, "doRecordAction portraitId:" + p16.getPortraitId() + ", mode:" + p16.getMode().name() + ", uin:" + p16.getSenderUin());
        p16.getConfig().getMp4Config().l(encodeType);
        E(p16, z18);
    }

    static /* synthetic */ com.tencent.mobileqq.vas.social.record.b t(SocialActionRecordHelper socialActionRecordHelper, com.tencent.mobileqq.vas.data.b bVar, com.tencent.mobileqq.vas.social.record.b bVar2, com.tencent.mobileqq.vas.social.record.c cVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            cVar = null;
        }
        return socialActionRecordHelper.s(bVar, bVar2, cVar);
    }

    static /* synthetic */ com.tencent.mobileqq.vas.social.record.b v(SocialActionRecordHelper socialActionRecordHelper, com.tencent.mobileqq.vas.data.b bVar, com.tencent.mobileqq.vas.social.record.c cVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            cVar = null;
        }
        return socialActionRecordHelper.u(bVar, cVar);
    }

    static /* synthetic */ com.tencent.mobileqq.vas.social.record.b x(SocialActionRecordHelper socialActionRecordHelper, com.tencent.mobileqq.vas.data.b bVar, com.tencent.mobileqq.vas.social.record.b bVar2, com.tencent.mobileqq.vas.social.record.c cVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            cVar = null;
        }
        return socialActionRecordHelper.w(bVar, bVar2, cVar);
    }

    @Override // com.tencent.zplan.meme.a
    public void l9(boolean success, final MemeResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Pair<com.tencent.mobileqq.vas.data.b, Long> pair = currentRecordAction;
        com.tencent.mobileqq.vas.data.b first = pair != null ? pair.getFirst() : null;
        G();
        final int actionId = result.getAction().getActionId();
        final String recordPath = result.getRecordPath();
        final MODE mode = result.getAction().getMode();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        QLog.d("SocialActionRecordHelper", 1, "onRecordDone success:" + success + ", actionId:" + actionId + ", recordPath:" + recordPath + ", mode:" + mode + ", actionStatus:" + result.getAction().getActionStatus().toInt());
        if (!success || !h(result)) {
            QLog.e("SocialActionRecordHelper", 1, "record done break actionId:" + actionId + " mode:" + mode + " success:" + success + " recordPath:" + recordPath);
            booleanRef.element = false;
        }
        RecordIdentifier recordIdentifier = (!z(first, result.getAction()) || first == null) ? null : first.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String();
        RecordIdentifier recordIdentifier2 = recordIdentifier == null ? new RecordIdentifier(new UserIdentifier("0", null, 2, null), null, 0, null, false, 30, null) : recordIdentifier;
        if (!booleanRef.element) {
            B(false, true, actionId, null, null, result.getAction().getActionStatus().toInt(), recordIdentifier2);
        }
        final RecordIdentifier recordIdentifier3 = recordIdentifier2;
        e(result, recordIdentifier2, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.vas.social.SocialActionRecordHelper$onRecordDone$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x007f  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x00dc  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(boolean z16) {
                boolean z17;
                RecordSource recordSource;
                RecordSource recordSource2;
                RecordSource recordSource3;
                boolean isBlank;
                QLog.d("SocialActionRecordHelper", 1, "checkAndExtractCover actionId:" + actionId + " mode:" + mode + " done " + z16);
                if (!z16) {
                    SocialActionRecordHelper.f310651d.B(false, true, actionId, null, null, result.getAction().getActionStatus().toInt(), recordIdentifier3);
                    return;
                }
                MemeResult.Cover cover = result.getCover();
                String path = cover != null ? cover.getPath() : null;
                Ref.BooleanRef booleanRef2 = booleanRef;
                MemeResult.Cover cover2 = result.getCover();
                String path2 = cover2 != null ? cover2.getPath() : null;
                boolean z18 = false;
                if (path2 != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(path2);
                    if (!isBlank) {
                        z17 = false;
                        if (!z17) {
                            Intrinsics.checkNotNull(path);
                            if (new File(path).exists()) {
                                z18 = true;
                            }
                        }
                        booleanRef2.element = z18;
                        if (booleanRef.element) {
                            recordSource3 = null;
                            recordSource2 = null;
                        } else {
                            try {
                                String str = recordPath;
                                Intrinsics.checkNotNull(str);
                                String encodeFileHexStr = MD5Utils.encodeFileHexStr(recordPath);
                                Intrinsics.checkNotNullExpressionValue(encodeFileHexStr, "encodeFileHexStr(recordPath)");
                                String lowerCase = encodeFileHexStr.toLowerCase();
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                                recordSource = new RecordSource(str, lowerCase);
                                try {
                                    Intrinsics.checkNotNull(path);
                                    String encodeFileHexStr2 = MD5Utils.encodeFileHexStr(path);
                                    Intrinsics.checkNotNullExpressionValue(encodeFileHexStr2, "encodeFileHexStr(coverPath)");
                                    String lowerCase2 = encodeFileHexStr2.toLowerCase();
                                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                                    recordSource3 = recordSource;
                                    recordSource2 = new RecordSource(path, lowerCase2);
                                } catch (Throwable th5) {
                                    th = th5;
                                    QLog.e("SocialActionRecordHelper", 1, "record done format source throw:", th);
                                    recordSource2 = null;
                                    recordSource3 = recordSource;
                                    SocialActionRecordHelper.f310651d.B(booleanRef.element, true, actionId, recordSource3, recordSource2, result.getAction().getActionStatus().toInt(), recordIdentifier3);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                recordSource = null;
                            }
                        }
                        SocialActionRecordHelper.f310651d.B(booleanRef.element, true, actionId, recordSource3, recordSource2, result.getAction().getActionStatus().toInt(), recordIdentifier3);
                    }
                }
                z17 = true;
                if (!z17) {
                }
                booleanRef2.element = z18;
                if (booleanRef.element) {
                }
                SocialActionRecordHelper.f310651d.B(booleanRef.element, true, actionId, recordSource3, recordSource2, result.getAction().getActionStatus().toInt(), recordIdentifier3);
            }
        });
        A(success, result, recordIdentifier2);
    }

    private final boolean z(com.tencent.mobileqq.vas.data.b taskInfo, MemeAction action) {
        if (taskInfo == null || action == null) {
            return false;
        }
        boolean areEqual = Intrinsics.areEqual(taskInfo.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getSender().getUin(), action.getSenderUin());
        UserIdentifier receiver = taskInfo.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getReceiver();
        boolean areEqual2 = Intrinsics.areEqual(receiver != null ? receiver.getUin() : null, action.getReceiverUin());
        QLog.d("SocialActionRecordHelper", 2, "isSameRecordTask, senderSame:" + areEqual + ", receiverSame:" + areEqual2 + ", taskInfo:" + taskInfo + ", action:" + action);
        return areEqual && areEqual2;
    }

    public final MODE q(int type) {
        if (type == 1) {
            return MODE.FRAME;
        }
        if (type != 2) {
            return null;
        }
        return MODE.MP4;
    }

    static /* synthetic */ void C(SocialActionRecordHelper socialActionRecordHelper, boolean z16, boolean z17, int i3, RecordSource recordSource, RecordSource recordSource2, int i16, RecordIdentifier recordIdentifier, int i17, Object obj) {
        socialActionRecordHelper.B(z16, z17, i3, recordSource, recordSource2, (i17 & 32) != 0 ? 0 : i16, recordIdentifier);
    }
}
