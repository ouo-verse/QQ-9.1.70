package com.tencent.mobileqq.troop.homework.common.upload;

import android.annotation.SuppressLint;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.homework.common.upload.HWLocalPathUploader;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.im_msg_body$RichText;
import tl.h;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\t+\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010\"\u001a\u00020\u001d\u00a2\u0006\u0004\b5\u00106J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R0\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050#j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R0\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020(0#j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020(`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010&R\u0014\u0010.\u001a\u00020+8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/upload/HWLocalPathUploader;", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/g;", "", "seq", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "com/tencent/mobileqq/troop/homework/common/upload/HWLocalPathUploader$b", h.F, "(Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;)Lcom/tencent/mobileqq/troop/homework/common/upload/HWLocalPathUploader$b;", "filePath", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lmqq/app/AppRuntime;", "kotlin.jvm.PlatformType", "j", "", "o", "", "p", "i", "", "a", "I", "cmd", "b", "Ljava/lang/String;", "peerUin", "Lcom/tencent/mobileqq/troop/homework/common/upload/c;", "c", "Lcom/tencent/mobileqq/troop/homework/common/upload/c;", "k", "()Lcom/tencent/mobileqq/troop/homework/common/upload/c;", "callback", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "uploadSeqToLocalPath", "Lcom/tencent/mobileqq/transfile/TransferRequest;", "e", "uploadTaskMap", "com/tencent/mobileqq/troop/homework/common/upload/HWLocalPathUploader$c", "f", "Lcom/tencent/mobileqq/troop/homework/common/upload/HWLocalPathUploader$c;", "processor", "Lcom/tencent/mobileqq/transfile/api/ITransFileController;", "g", "Lkotlin/Lazy;", "l", "()Lcom/tencent/mobileqq/transfile/api/ITransFileController;", "ctrl", "<init>", "(ILjava/lang/String;Lcom/tencent/mobileqq/troop/homework/common/upload/c;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWLocalPathUploader {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int cmd;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.homework.common.upload.c callback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, String> uploadSeqToLocalPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, TransferRequest> uploadTaskMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @SuppressLint({"HandlerLeak"})
    @NotNull
    private final c processor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy ctrl;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/upload/HWLocalPathUploader$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.upload.HWLocalPathUploader$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/troop/homework/common/upload/HWLocalPathUploader$b", "Lcom/tencent/mobileqq/pic/ad;", "Ltencent/im/msg/im_msg_body$RichText;", "richText", "Lcom/tencent/mobileqq/data/MessageRecord;", "g", "Lcom/tencent/mobileqq/pic/ad$a;", "info", "", "r", "result", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements ad {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseItem f296658d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HWLocalPathUploader f296659e;

        b(BaseItem baseItem, HWLocalPathUploader hWLocalPathUploader) {
            this.f296658d = baseItem;
            this.f296659e = hWLocalPathUploader;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseItem, (Object) hWLocalPathUploader);
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        @Nullable
        public MessageRecord g(@Nullable im_msg_body$RichText richText) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MessageRecord) iPatchRedirector.redirect((short) 2, (Object) this, (Object) richText);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void q(@Nullable ad.a result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) result);
                return;
            }
            if (result == null) {
                QLog.d("HW.HWNoticeLocalPathUploader", 4, "onSend but got null result");
                return;
            }
            int i3 = result.f258598b;
            if (i3 != 0) {
                com.tencent.mobileqq.troop.homework.utils.a.f(i3, result.f258599c, SystemClock.elapsedRealtime() - this.f296658d.getStartMillis(), this.f296658d.getFileSize(), this.f296658d.getRawSize(), this.f296658d.getMediaType(), this.f296659e.peerUin, 0, 0, MsgConstant.KRMFILETHUMBSIZE384, null);
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(@Nullable ad.a info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) info);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/homework/common/upload/HWLocalPathUploader$c", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends TransProcessorHandler {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWLocalPathUploader.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            FileMsg fileMsg;
            float f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Object obj = msg2.obj;
            if (obj instanceof FileMsg) {
                fileMsg = (FileMsg) obj;
            } else {
                fileMsg = null;
            }
            if (fileMsg != null && fileMsg.fileType == 24 && fileMsg.commandId == HWLocalPathUploader.this.cmd && HWLocalPathUploader.this.uploadSeqToLocalPath.containsKey(Long.valueOf(fileMsg.uniseq))) {
                switch (msg2.what) {
                    case 1002:
                        try {
                            f16 = (((float) fileMsg.transferedSize) * 1.0f) / ((float) fileMsg.fileSize);
                        } catch (Exception e16) {
                            QLog.e("HW.HWNoticeLocalPathUploader", 1, "progress error, e: " + e16.getMessage());
                            f16 = 0.0f;
                        }
                        QLog.i("HW.HWNoticeLocalPathUploader", 4, "transferedSize: " + fileMsg.transferedSize + ", filesize: " + fileMsg.fileSize);
                        String n3 = HWLocalPathUploader.this.n(fileMsg.uniseq);
                        if (n3 != null) {
                            HWLocalPathUploader.this.k().onProgress(n3, f16);
                            return;
                        }
                        return;
                    case 1003:
                        Bdh_extinfo.UploadPicExtInfo uploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
                        byte[] bArr = fileMsg.bdhExtendInfo;
                        uploadPicExtInfo.mergeFrom(bArr, 0, bArr.length);
                        String fileUrl = uploadPicExtInfo.bytes_download_url.get().toStringUtf8();
                        QLog.i("HW.HWNoticeLocalPathUploader", 1, "send finish, fileUrl:" + fileUrl);
                        String str = (String) HWLocalPathUploader.this.uploadSeqToLocalPath.remove(Long.valueOf(fileMsg.uniseq));
                        if (str != null) {
                            HWLocalPathUploader hWLocalPathUploader = HWLocalPathUploader.this;
                            hWLocalPathUploader.uploadTaskMap.remove(str);
                            com.tencent.mobileqq.troop.homework.common.upload.c k3 = hWLocalPathUploader.k();
                            Intrinsics.checkNotNullExpressionValue(fileUrl, "fileUrl");
                            k3.onSuccess(str, fileUrl);
                            return;
                        }
                        return;
                    case 1004:
                        QLog.i("HW.HWNoticeLocalPathUploader", 1, "send cancel, seq:" + fileMsg.uniseq);
                        return;
                    case 1005:
                        QLog.i("HW.HWNoticeLocalPathUploader", 1, "send error:" + fileMsg.errorCode + "-" + fileMsg.errorMessage);
                        String str2 = (String) HWLocalPathUploader.this.uploadSeqToLocalPath.remove(Long.valueOf(fileMsg.uniseq));
                        if (str2 != null) {
                            HWLocalPathUploader hWLocalPathUploader2 = HWLocalPathUploader.this;
                            hWLocalPathUploader2.uploadTaskMap.remove(str2);
                            hWLocalPathUploader2.k().a(str2, fileMsg.errorCode, fileMsg.errorMessage);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46029);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWLocalPathUploader(int i3, @NotNull String peerUin, @NotNull com.tencent.mobileqq.troop.homework.common.upload.c callback) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), peerUin, callback);
            return;
        }
        this.cmd = i3;
        this.peerUin = peerUin;
        this.callback = callback;
        this.uploadSeqToLocalPath = new HashMap<>();
        this.uploadTaskMap = new HashMap<>();
        c cVar = new c();
        cVar.addFilter(BDHCommonUploadProcessor.class);
        this.processor = cVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ITransFileController>() { // from class: com.tencent.mobileqq.troop.homework.common.upload.HWLocalPathUploader$ctrl$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWLocalPathUploader.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ITransFileController invoke() {
                AppRuntime j3;
                HWLocalPathUploader.c cVar2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ITransFileController) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                j3 = HWLocalPathUploader.this.j();
                ITransFileController iTransFileController = (ITransFileController) j3.getRuntimeService(ITransFileController.class, "all");
                cVar2 = HWLocalPathUploader.this.processor;
                iTransFileController.addHandle(cVar2);
                return iTransFileController;
            }
        });
        this.ctrl = lazy;
    }

    private final b h(BaseItem item) {
        return new b(item, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppRuntime j() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private final ITransFileController l() {
        return (ITransFileController) this.ctrl.getValue();
    }

    private final String m(String filePath) {
        int lastIndexOf$default;
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) filePath, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default > 0) {
            String substring = filePath.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return "." + substring;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String n(long seq) {
        return this.uploadSeqToLocalPath.get(Long.valueOf(seq));
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.i("HW.HWNoticeLocalPathUploader", 1, "destroy,clear size:" + this.uploadSeqToLocalPath.size() + "-" + this.uploadTaskMap.size());
        l().removeHandle(this.processor);
        Collection<TransferRequest> values = this.uploadTaskMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "uploadTaskMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            l().stop((TransferRequest) it.next());
        }
        this.uploadSeqToLocalPath.clear();
        this.uploadTaskMap.clear();
    }

    @NotNull
    public final com.tencent.mobileqq.troop.homework.common.upload.c k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.homework.common.upload.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.callback;
    }

    public boolean o(@NotNull g item) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        String b16 = item.b();
        if (b16 != null && b16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        if (this.uploadTaskMap.containsKey(b16)) {
            QLog.i("HW.HWNoticeLocalPathUploader", 1, "startUpload ignore, containsKey:" + b16);
            return false;
        }
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mSelfUin = j().getAccount();
        transferRequest.mPeerUin = this.peerUin;
        transferRequest.mFileType = 24;
        transferRequest.mCommandId = this.cmd;
        transferRequest.mUniseq = System.nanoTime();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = b16;
        Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
        commFileExtReq.uint32_action_type.set(0);
        commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString() + m(b16)));
        transferRequest.mExtentionInfo = commFileExtReq.toByteArray();
        transferRequest.mUpCallBack = h(item.a());
        this.uploadSeqToLocalPath.put(Long.valueOf(transferRequest.mUniseq), b16);
        this.uploadTaskMap.put(b16, transferRequest);
        QLog.i("HW.HWNoticeLocalPathUploader", 1, "uploadItem,seq:" + transferRequest.mUniseq + ",path:" + b16);
        l().transferAsync(transferRequest);
        return true;
    }

    public void p(@NotNull g item) {
        TransferRequest remove;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        String b16 = item.b();
        if (b16 == null || (remove = this.uploadTaskMap.remove(b16)) == null) {
            return;
        }
        l().stop(remove);
        QLog.i("HW.HWNoticeLocalPathUploader", 1, "stopUpload:" + b16 + ", seq:" + this.uploadSeqToLocalPath.remove(Long.valueOf(remove.mUniseq)));
    }
}
