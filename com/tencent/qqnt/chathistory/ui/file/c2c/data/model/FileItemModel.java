package com.tencent.qqnt.chathistory.ui.file.c2c.data.model;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ao;
import com.tencent.qqnt.chathistory.ui.base.d;
import com.tencent.qqnt.chathistory.ui.base.e;
import com.tencent.qqnt.chathistory.ui.base.item.b;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import com.tencent.qqnt.chathistory.util.PicSize;
import com.tencent.qqnt.chathistory.util.j;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import java.io.File;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0080\b\u0018\u0000 ?2\u00020\u0001:\u0001dB'\u0012\u0006\u0010(\u001a\u00020!\u0012\u0006\u0010-\u001a\u00020\u000e\u0012\u0006\u00101\u001a\u00020\u0003\u0012\u0006\u00107\u001a\u000202\u00a2\u0006\u0004\bf\u0010gJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0003H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0003J\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0007J\u0006\u0010\u0019\u001a\u00020\u0007J\u0006\u0010\u001a\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\u0007J\t\u0010\u001c\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010 \u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u00d6\u0003R\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0017\u0010-\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u00101\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b.\u0010\u0017\u001a\u0004\b/\u00100R\u0017\u00107\u001a\u0002028\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0017\u0010;\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u00108\u001a\u0004\b9\u0010:R\u0017\u0010=\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001b\u00108\u001a\u0004\b<\u0010:R\u0017\u0010A\u001a\u00020>8\u0006\u00a2\u0006\f\n\u0004\b/\u0010\u0006\u001a\u0004\b?\u0010@R\u0017\u0010D\u001a\u00020>8\u0006\u00a2\u0006\f\n\u0004\bB\u0010\u0006\u001a\u0004\bC\u0010@R\u0017\u0010I\u001a\u00020E8\u0006\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bF\u0010HR\u0014\u0010L\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010KR\u0017\u0010N\u001a\u00020>8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0006\u001a\u0004\bM\u0010@R\u001f\u0010S\u001a\n O*\u0004\u0018\u00010\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bM\u0010P\u001a\u0004\bQ\u0010RR$\u0010Z\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001b\u0010\\\u001a\u00020E8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010[\u001a\u0004\bB\u0010HR\u001f\u0010^\u001a\n O*\u0004\u0018\u00010\u000e0\u000e8\u0006\u00a2\u0006\f\n\u0004\b]\u0010*\u001a\u0004\b]\u0010,R\u0017\u0010c\u001a\u00020_8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010`\u001a\u0004\ba\u0010bR\u0014\u0010e\u001a\u00020>8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bd\u0010@\u00a8\u0006h"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel;", "Lcom/tencent/qqnt/chathistory/ui/base/item/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "", "v", "Lcom/tencent/qqnt/chathistory/ui/base/e;", "J", "", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "E", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/chathistory/util/PicSize;", "picDownloadThumb", "", HippyTKDListViewAdapter.X, "path", "", "G", "picSize", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "I", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "p", "i", "toString", "hashCode", "", "other", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "y", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "setRecord", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", QQPermissionConstants.Permission.AUIDO_GROUP, "e", "Ljava/lang/String;", "w", "()Ljava/lang/String;", "peerId", "f", "j", "()I", "chatType", "Lkotlinx/coroutines/CoroutineScope;", "g", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Z", "D", "()Z", "isSelfSend", "B", "isLocalSend", "", "t", "()J", "msgId", "k", "u", "msgSeq", "", "l", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "disPlayTime", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "typeElement", "o", "elementId", "kotlin.jvm.PlatformType", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "fileElement", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "getFileNotifyInfo", "()Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "H", "(Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;)V", "fileNotifyInfo", "Lkotlin/Lazy;", "disPlayFileSize", "r", WadlProxyConsts.PARAM_FILENAME, "Lcom/tencent/qqnt/chathistory/ui/base/d;", "Lcom/tencent/qqnt/chathistory/ui/base/d;", "getFileInvalidState", "()Lcom/tencent/qqnt/chathistory/ui/base/d;", "fileInvalidState", "a", "msgTime", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Ljava/lang/String;ILkotlinx/coroutines/CoroutineScope;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class FileItemModel extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    private static final a f353582t;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MsgRecord record;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int chatType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean isSelfSend;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean isLocalSend;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final long msgId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final long msgSeq;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence disPlayTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgElement typeElement;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final long elementId;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final FileElement fileElement;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FileTransNotifyInfo fileNotifyInfo;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy disPlayFileSize;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final String fileName;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d fileInvalidState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel$1", f = "FileItemModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FileTransNotifyInfo, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileItemModel.this, (Object) continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull FileTransNotifyInfo fileTransNotifyInfo, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(fileTransNotifyInfo, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) fileTransNotifyInfo, (Object) continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this, obj);
            }
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FileTransNotifyInfo fileTransNotifyInfo = (FileTransNotifyInfo) this.L$0;
                if (fileTransNotifyInfo.fileDownType == 1) {
                    com.tencent.qqnt.chathistory.util.d.f354054a.a("FileItemModel", "receive " + fileTransNotifyInfo);
                    if (fileTransNotifyInfo.msgId == FileItemModel.this.t() || fileTransNotifyInfo.fileModelId == FileItemModel.this.o()) {
                        FileItemModel.this.H(fileTransNotifyInfo);
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel$a;", "", "", "TAG", "Ljava/lang/String;", "", "VALID_STATE", "I", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45984);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 42)) {
            redirector.redirect((short) 42);
        } else {
            f353582t = new a(null);
        }
    }

    public FileItemModel(@NotNull MsgRecord record, @NotNull String peerId, int i3, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, record, peerId, Integer.valueOf(i3), scope);
            return;
        }
        this.record = record;
        this.peerId = peerId;
        this.chatType = i3;
        this.scope = scope;
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(com.tencent.qqnt.chathistory.service.d.f(), new AnonymousClass1(null)), Dispatchers.getMain()), scope);
        this.isSelfSend = MsgExtKt.S(this.record);
        this.isLocalSend = ExtensionsKt.u(this.record);
        MsgRecord msgRecord = this.record;
        this.msgId = msgRecord.msgId;
        this.msgSeq = msgRecord.msgSeq;
        String a16 = j.a(getMsgTime() * 1000);
        Intrinsics.checkNotNullExpressionValue(a16, "formatNewRefreshTime(msgTime * 1000)");
        this.disPlayTime = a16;
        MsgElement n3 = ExtensionsKt.n(this.record, 3);
        Intrinsics.checkNotNull(n3);
        this.typeElement = n3;
        this.elementId = n3.elementId;
        FileElement fileElement = n3.fileElement;
        this.fileElement = fileElement;
        this.disPlayFileSize = LazyKt.lazy(new Function0<String>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel$disPlayFileSize$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FileItemModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? ao.a(FileItemModel.this.q().fileSize) : (String) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.fileName = fileElement.fileName;
        Intrinsics.checkNotNullExpressionValue(fileElement, "fileElement");
        this.fileInvalidState = ExtensionsKt.k(fileElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e J(int i3) {
        switch (i3) {
            case 0:
                return e.C9522e.f353350a;
            case 1:
                return e.c.f353348a;
            case 2:
                return e.f.f353351a;
            case 3:
                return e.a.f353346a;
            case 4:
                return e.d.f353349a;
            case 5:
                return e.b.f353347a;
            case 6:
                return e.g.f353352a;
            default:
                return e.C9522e.f353350a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int v(FileElement fileElement) {
        int coerceAtMost;
        if (this.fileElement.fileSize != 0) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost((int) ((fileElement.progress.intValue() * 100) / this.fileElement.fileSize), 100);
            return coerceAtMost;
        }
        return 100;
    }

    public final boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        Integer num = this.fileElement.invalidState;
        if (num == null || num.intValue() != 0) {
            return true;
        }
        return false;
    }

    public final boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isLocalSend;
    }

    public final boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        Integer num = this.fileElement.subElementType;
        if (num != null && num.intValue() == 1) {
            return true;
        }
        Integer num2 = this.fileElement.subElementType;
        if (num2 == null || num2.intValue() != 2) {
            return false;
        }
        FileElement fileElement = this.fileElement;
        Intrinsics.checkNotNullExpressionValue(fileElement, "fileElement");
        if (com.tencent.qqnt.aio.element.file.util.a.d(fileElement) != 11) {
            return true;
        }
        return false;
    }

    public final boolean D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isSelfSend;
    }

    public final boolean E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        if (this.fileElement.fileSize < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
            return true;
        }
        return false;
    }

    public final boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        Integer num = this.fileElement.subElementType;
        if (num != null && num.intValue() == 2) {
            FileElement fileElement = this.fileElement;
            Intrinsics.checkNotNullExpressionValue(fileElement, "fileElement");
            if (com.tencent.qqnt.aio.element.file.util.a.d(fileElement) != 11) {
                return true;
            }
        }
        return false;
    }

    public final void G(@NotNull PicSize picDownloadThumb, @NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) picDownloadThumb, (Object) path);
            return;
        }
        Intrinsics.checkNotNullParameter(picDownloadThumb, "picDownloadThumb");
        Intrinsics.checkNotNullParameter(path, "path");
        FileElement fileElement = this.fileElement;
        Intrinsics.checkNotNullExpressionValue(fileElement, "fileElement");
        int g16 = com.tencent.qqnt.chathistory.util.a.g(fileElement, picDownloadThumb);
        HashMap<Integer, String> hashMap = this.fileElement.picThumbPath;
        Intrinsics.checkNotNullExpressionValue(hashMap, "fileElement.picThumbPath");
        hashMap.put(Integer.valueOf(g16), path);
        com.tencent.qqnt.chathistory.util.d.f354054a.a("FileItemModel", "savePicImagePath  ntThumbLevel " + g16 + "  path " + path);
    }

    public final void H(@Nullable FileTransNotifyInfo fileTransNotifyInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) fileTransNotifyInfo);
        } else {
            this.fileNotifyInfo = fileTransNotifyInfo;
        }
    }

    @NotNull
    public final e I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (e) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return (e) ExtensionsKt.c(this.fileNotifyInfo, new Function1<FileTransNotifyInfo, e>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel$transState$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FileItemModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final e invoke(@NotNull FileTransNotifyInfo checkNotNull) {
                e J;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (e) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) checkNotNull);
                }
                Intrinsics.checkNotNullParameter(checkNotNull, "$this$checkNotNull");
                J = FileItemModel.this.J(checkNotNull.trasferStatus);
                return J;
            }
        }, new Function0<e>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel$transState$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FileItemModel.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final e invoke() {
                e J;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (e) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                FileItemModel fileItemModel = FileItemModel.this;
                Integer num = fileItemModel.q().transferStatus;
                Intrinsics.checkNotNullExpressionValue(num, "fileElement.transferStatus");
                J = fileItemModel.J(num.intValue());
                return J;
            }
        });
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.i
    /* renamed from: a */
    public long getMsgTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this)).longValue();
        }
        return this.record.msgTime;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileItemModel)) {
            return false;
        }
        FileItemModel fileItemModel = (FileItemModel) other;
        if (Intrinsics.areEqual(this.record, fileItemModel.record) && Intrinsics.areEqual(this.peerId, fileItemModel.peerId) && this.chatType == fileItemModel.chatType && Intrinsics.areEqual(this.scope, fileItemModel.scope)) {
            return true;
        }
        return false;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        return ((Number) ExtensionsKt.c(this.fileNotifyInfo, new Function1<FileTransNotifyInfo, Integer>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel$disPlayProgress$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FileItemModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Integer invoke(@NotNull FileTransNotifyInfo checkNotNull) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) checkNotNull);
                }
                Intrinsics.checkNotNullParameter(checkNotNull, "$this$checkNotNull");
                FileElement fileElement = FileItemModel.this.q();
                Intrinsics.checkNotNullExpressionValue(fileElement, "fileElement");
                return Integer.valueOf(ExtensionsKt.o(fileElement, checkNotNull));
            }
        }, new Function0<Integer>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel$disPlayProgress$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FileItemModel.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                int v3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                FileItemModel fileItemModel = FileItemModel.this;
                FileElement fileElement = fileItemModel.q();
                Intrinsics.checkNotNullExpressionValue(fileElement, "fileElement");
                v3 = fileItemModel.v(fileElement);
                return Integer.valueOf(v3);
            }
        })).intValue();
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, (Object) this)).intValue();
        }
        return (((((this.record.hashCode() * 31) + this.peerId.hashCode()) * 31) + this.chatType) * 31) + this.scope.hashCode();
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        String str = this.fileElement.filePath;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intrinsics.checkNotNull(str);
        if (new File(str).length() <= 0) {
            return false;
        }
        return true;
    }

    public final int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.chatType;
    }

    @NotNull
    public final CharSequence k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (CharSequence) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        Object value = this.disPlayFileSize.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-disPlayFileSize>(...)");
        return (CharSequence) value;
    }

    @NotNull
    public final CharSequence l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (CharSequence) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.disPlayTime;
    }

    public final int m(@NotNull PicSize picSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this, (Object) picSize)).intValue();
        }
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        FileElement fileElement = this.fileElement;
        Intrinsics.checkNotNullExpressionValue(fileElement, "fileElement");
        return com.tencent.qqnt.chathistory.util.a.d(fileElement, picSize);
    }

    public final int n(@NotNull PicSize picSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this, (Object) picSize)).intValue();
        }
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        FileElement fileElement = this.fileElement;
        Intrinsics.checkNotNullExpressionValue(fileElement, "fileElement");
        return com.tencent.qqnt.chathistory.util.a.b(fileElement, picSize);
    }

    public final long o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.elementId;
    }

    @NotNull
    public final String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        Long l3 = this.fileElement.expireTime;
        if ((l3 == null || l3.longValue() != 0) && !i()) {
            if (z()) {
                String qqStr = HardCodeUtil.qqStr(R.string.yqs);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.qqnt.a\u2026string.aio_file_overtime)");
                return qqStr;
            }
            Long l16 = this.fileElement.expireTime;
            Intrinsics.checkNotNullExpressionValue(l16, "fileElement.expireTime");
            return ExtensionsKt.e(l16.longValue());
        }
        return "";
    }

    public final FileElement q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (FileElement) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.fileElement;
    }

    public final String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.fileName;
    }

    public final int s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        Integer num = this.fileElement.subElementType;
        if (num != null && num.intValue() == 0) {
            return R.drawable.mpj;
        }
        if (num != null && num.intValue() == 3) {
            return R.drawable.mp8;
        }
        if (num != null && num.intValue() == 4) {
            return R.drawable.mp9;
        }
        if (num != null && num.intValue() == 5) {
            return R.drawable.mpf;
        }
        if (num != null && num.intValue() == 6) {
            return R.drawable.mpl;
        }
        if (num != null && num.intValue() == 7) {
            return R.drawable.mpe;
        }
        if (num != null && num.intValue() == 8) {
            return R.drawable.mpi;
        }
        if (num != null && num.intValue() == 9) {
            return R.drawable.mpm;
        }
        if (num != null && num.intValue() == 10) {
            return R.drawable.mpb;
        }
        if (num != null && num.intValue() == 11) {
            return R.drawable.mp7;
        }
        if (num != null && num.intValue() == 12) {
            return R.drawable.mpg;
        }
        if (num != null && num.intValue() == 13) {
            return R.drawable.mpa;
        }
        if (num != null && num.intValue() == 14) {
            return R.drawable.mpd;
        }
        if (num == null || num.intValue() != 16) {
            return R.drawable.mpj;
        }
        return R.drawable.mp6;
    }

    public final long t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.msgId;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return "FileItemModel(record=" + this.record + ", peerId=" + this.peerId + ", chatType=" + this.chatType + ", scope=" + this.scope + ")";
    }

    public final long u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.msgSeq;
    }

    @NotNull
    public final String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.peerId;
    }

    @Nullable
    public final String x(@NotNull PicSize picDownloadThumb) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this, (Object) picDownloadThumb);
        }
        Intrinsics.checkNotNullParameter(picDownloadThumb, "picDownloadThumb");
        FileElement fileElement = this.fileElement;
        Intrinsics.checkNotNullExpressionValue(fileElement, "fileElement");
        return com.tencent.qqnt.chathistory.util.a.h(fileElement, picDownloadThumb);
    }

    @NotNull
    public final MsgRecord y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MsgRecord) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.record;
    }

    public final boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        Long l3 = this.fileElement.expireTime;
        if ((l3 == null || l3.longValue() != 0) && System.currentTimeMillis() > this.fileElement.expireTime.longValue() * 1000) {
            return true;
        }
        return false;
    }
}
