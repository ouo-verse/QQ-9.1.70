package com.tencent.mobileqq.aio.msglist.holder.base;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader;
import com.tencent.mobileqq.aio.msglist.holder.base.util.PicContentViewUtil;
import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.ImportOldDbMsgNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002@9B\t\b\u0002\u00a2\u0006\u0004\b>\u0010?J(\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\r\u001a\u00020\u0007*\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0014\u0010\u000f\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0014\u0010\u0010\u001a\u00020\u0007*\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\f\u0010\u0014\u001a\u00020\n*\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0016\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\n*\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\n*\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\u001c\u001a\u00020\u0004*\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007J\u0012\u0010\u001d\u001a\u00020\u0007*\u00020\t2\u0006\u0010\f\u001a\u00020\u0004J\n\u0010\u001e\u001a\u00020\n*\u00020\u0004Ju\u0010/\u001a\u00020-2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&2+\b\u0002\u0010.\u001a%\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-\u0018\u00010(H\u0007JH\u00107\u001a\u00020-2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00101\u001a\u0002002\b\b\u0002\u00102\u001a\u00020\u00072\b\b\u0002\u00103\u001a\u00020\u00072\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020-\u0018\u000104R\u0017\u0010=\u001a\u0002088\u0006\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/base/AIOPicDownloader;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/mobileqq/aio/msglist/holder/base/PicSize;", "size", "Lkotlin/Pair;", "", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "", "o", "picSize", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", tl.h.F, "g", DTConstants.TAG.ELEMENT, "", HippyTKDListViewAdapter.X, "t", ReportConstant.COSTREPORT_PREFIX, "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "fileDownloadType", "thumbLevel", "i", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "targetView", "imageUrl", "imageWidth", "imageHeight", "Landroid/graphics/drawable/Drawable;", "loadingDrawable", "Lcom/tencent/mobileqq/aio/msg/w;", "msgItem", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", "Lcom/tencent/mobileqq/aio/msglist/holder/base/util/PicContentViewUtil$FailReason;", "", "onImageLoad", "u", "Lcom/tencent/mobileqq/aio/msglist/holder/base/AIOPicDownloader$b;", "paramsProvider", "downloadSourceType", "triggerType", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "cb", "e", "Ljava/util/concurrent/atomic/AtomicInteger;", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "r", "()Ljava/util/concurrent/atomic/AtomicInteger;", "sNextSeq", "<init>", "()V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOPicDownloader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIOPicDownloader f190570a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicInteger sNextSeq;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0004H\u0016J0\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/base/AIOPicDownloader$b;", "", "", "getSeq", "", "getMsgId", "getChatType", "", "getPeerUin", "getMsgSeq", "downloadType", "thumbLevel", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "downloadSourceType", "triggerType", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public interface b {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes11.dex */
        public static final class a {
            @NotNull
            public static RichMediaElementGetReq a(@NotNull b bVar, int i3, int i16, @NotNull MsgElement msgElement, int i17, int i18) {
                Intrinsics.checkNotNullParameter(msgElement, "msgElement");
                RichMediaElementGetReq richMediaElementGetReq = new RichMediaElementGetReq();
                richMediaElementGetReq.msgId = bVar.getMsgId();
                richMediaElementGetReq.peerUid = bVar.getPeerUin();
                richMediaElementGetReq.chatType = bVar.getChatType();
                richMediaElementGetReq.elementId = msgElement.elementId;
                richMediaElementGetReq.downloadType = i3;
                richMediaElementGetReq.thumbSize = i16;
                richMediaElementGetReq.downSourceType = i17;
                richMediaElementGetReq.triggerType = i18;
                return richMediaElementGetReq;
            }
        }

        @NotNull
        RichMediaElementGetReq a(int downloadType, int thumbLevel, @NotNull MsgElement msgElement, int downloadSourceType, int triggerType);

        int getChatType();

        long getMsgId();

        long getMsgSeq();

        @NotNull
        String getPeerUin();

        int getSeq();
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public /* synthetic */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f190575a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59710);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[PicSize.values().length];
            try {
                iArr[PicSize.PIC_DOWNLOAD_ORI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PicSize.PIC_LOCAL_HD_THUMB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PicSize.PIC_DOWNLOAD_THUMB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PicSize.PIC_DOWNLOAD_BIG_THUMB.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f190575a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/base/AIOPicDownloader$d", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "", "onRichMediaDownloadComplete", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d implements IKernelMsgListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f190576d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MsgElement f190577e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<FileTransNotifyInfo, Unit> f190578f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f190579h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Integer f190580i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Integer f190581m;

        d(b bVar, MsgElement msgElement, Function1<? super FileTransNotifyInfo, Unit> function1, long j3, Integer num, Integer num2) {
            this.f190576d = bVar;
            this.f190577e = msgElement;
            this.f190578f = function1;
            this.f190579h = j3;
            this.f190580i = num;
            this.f190581m = num2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bVar, msgElement, function1, Long.valueOf(j3), num, num2);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
            ax.a(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onContactUnreadCntUpdate(HashMap hashMap) {
            ax.b(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig) {
            ax.c(this, customWithdrawConfig);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onDraftUpdate(Contact contact, ArrayList arrayList, long j3) {
            ax.d(this, contact, arrayList, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiDownloadComplete(EmojiNotifyInfo emojiNotifyInfo) {
            ax.e(this, emojiNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo) {
            ax.f(this, emojiResourceInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onFileMsgCome(ArrayList arrayList) {
            ax.g(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGrabPasswordRedBag(int i3, String str, int i16, RecvdOrder recvdOrder, MsgRecord msgRecord) {
            ax.h(this, i3, str, i16, recvdOrder, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoAdd(GroupItem groupItem) {
            ax.i(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.j(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoAdd(GroupItem groupItem) {
            ax.k(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.l(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitCsRelatedEmojiResult(DownloadRelateEmojiResultInfo downloadRelateEmojiResultInfo) {
            ax.m(this, downloadRelateEmojiResultInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitEmojiKeywordResult(HitRelatedEmojiWordsResult hitRelatedEmojiWordsResult) {
            ax.n(this, hitRelatedEmojiWordsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitRelatedEmojiResult(RelatedWordEmojiInfo relatedWordEmojiInfo) {
            ax.o(this, relatedWordEmojiInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onImportOldDbProgressUpdate(ImportOldDbMsgNotifyInfo importOldDbMsgNotifyInfo) {
            ax.p(this, importOldDbMsgNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onInputStatusPush(InputStatusInfo inputStatusInfo) {
            ax.q(this, inputStatusInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onKickedOffLine(KickedInfo kickedInfo) {
            ax.r(this, kickedInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLineDev(ArrayList arrayList) {
            ax.s(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLogLevelChanged(long j3) {
            ax.t(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMiscDataChanged(ArrayList arrayList) {
            ax.u(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgBoxChanged(ArrayList arrayList) {
            ax.v(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgDelete(Contact contact, ArrayList arrayList) {
            ax.w(this, contact, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListAdd(ArrayList arrayList) {
            ax.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListUpdate(ArrayList arrayList) {
            ax.y(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgQRCodeStatusChanged(int i3) {
            ax.z(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgRecall(int i3, String str, long j3) {
            ax.A(this, i3, str, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSecurityNotify(MsgRecord msgRecord) {
            ax.B(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSettingUpdate(MsgSetting msgSetting) {
            ax.C(this, msgSetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgWithRichLinkInfoUpdate(ArrayList arrayList) {
            ax.D(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtFirstViewMsgSyncEnd() {
            ax.E(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncContactUnread() {
            ax.F(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncEnd() {
            ax.G(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncStart() {
            ax.H(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsg(ArrayList arrayList) {
            ax.I(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsgSvrRspTransInfo(long j3, Contact contact, int i3, int i16, String str, byte[] bArr) {
            ax.J(this, j3, contact, i3, i16, str, bArr);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
            ax.K(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvSysMsg(ArrayList arrayList) {
            ax.L(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRedTouchChanged() {
            ax.M(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaDownloadComplete(@Nullable FileTransNotifyInfo notifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) notifyInfo);
                return;
            }
            if (notifyInfo != null && this.f190576d.getMsgId() == notifyInfo.msgId && this.f190577e.elementId == notifyInfo.msgElementId) {
                Function1<FileTransNotifyInfo, Unit> function1 = this.f190578f;
                if (function1 != null) {
                    function1.invoke(notifyInfo);
                }
                long currentTimeMillis = System.currentTimeMillis() - this.f190579h;
                AIOPicDownloader aIOPicDownloader = AIOPicDownloader.f190570a;
                MsgElement msgElement = this.f190577e;
                b bVar = this.f190576d;
                Integer num = this.f190580i;
                Integer num2 = this.f190581m;
                QLog.i("AIOPicDownloader.Downloader", 1, ("downPic Finish, cost:" + currentTimeMillis + " ms element:") + " seq:" + bVar.getSeq() + " eleId:" + msgElement.elementId + " msgSeq:" + bVar.getMsgSeq() + " channelId:" + bVar.getPeerUin() + ((Object) (" downType:" + num + " thumbLevel:" + num2 + " info:" + notifyInfo + "}")));
                w e16 = com.tencent.qqnt.msg.f.e();
                if (e16 != null) {
                    e16.removeMsgListener(this);
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaProgerssUpdate(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.O(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaUploadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.P(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
            ax.Q(this, searchGroupFileResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSendMsgError(long j3, Contact contact, int i3, String str) {
            ax.R(this, j3, contact, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSysMsgNotification(int i3, long j3, long j16, boolean z16, ArrayList arrayList) {
            ax.S(this, i3, j3, j16, z16, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onTempChatInfoUpdate(TempChatInfo tempChatInfo) {
            ax.T(this, tempChatInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserChannelTabStatusChanged(boolean z16) {
            ax.U(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserOnlineStatusChanged(boolean z16) {
            ax.V(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserSecQualityChanged(QueryUserSecQualityRsp queryUserSecQualityRsp) {
            ax.W(this, queryUserSecQualityRsp);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserTabStatusChanged(ArrayList arrayList) {
            ax.X(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusBigIconDownloadPush(int i3, long j3, String str) {
            ax.Y(this, i3, j3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusSmallIconDownloadPush(int i3, long j3, String str) {
            ax.Z(this, i3, j3, str);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59736);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f190570a = new AIOPicDownloader();
            sNextSeq = new AtomicInteger(10000);
        }
    }

    AIOPicDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(b paramsProvider, Integer num, Integer num2, MsgElement msgElement, int i3, int i16, Function1 function1, long j3) {
        Intrinsics.checkNotNullParameter(paramsProvider, "$paramsProvider");
        Intrinsics.checkNotNullParameter(msgElement, "$msgElement");
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.addMsgListener(new d(paramsProvider, msgElement, function1, j3, num, num2));
        }
        w e17 = com.tencent.qqnt.msg.f.e();
        if (e17 != null) {
            e17.getRichMediaElement(paramsProvider.a(num.intValue(), num2.intValue(), msgElement, i3, i16));
        }
    }

    private final int g(FileElement fileElement, PicSize picSize) {
        int i3 = c.f190575a[picSize.ordinal()];
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2 && i3 != 3 && i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return i16;
    }

    private final int h(PicElement picElement, PicSize picSize) {
        int i3 = c.f190575a[picSize.ordinal()];
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2 && i3 != 3 && i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return i16;
    }

    private final Pair<Integer, Integer> k(MsgElement msgElement, PicSize size) {
        Pair<Integer, Integer> pair;
        int i3 = msgElement.elementType;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 5) {
                    return new Pair<>(null, null);
                }
                return new Pair<>(2, 0);
            }
            FileElement fileElement = msgElement.fileElement;
            Intrinsics.checkNotNullExpressionValue(fileElement, "msgElement.fileElement");
            Integer valueOf = Integer.valueOf(g(fileElement, size));
            FileElement fileElement2 = msgElement.fileElement;
            Intrinsics.checkNotNullExpressionValue(fileElement2, "msgElement.fileElement");
            pair = new Pair<>(valueOf, Integer.valueOf(j(fileElement2, size)));
        } else {
            PicElement picElement = msgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement, "msgElement.picElement");
            Integer valueOf2 = Integer.valueOf(h(picElement, size));
            PicElement picElement2 = msgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement2, "msgElement.picElement");
            pair = new Pair<>(valueOf2, Integer.valueOf(defpackage.g.b(picElement2, size)));
        }
        return pair;
    }

    private final int n(FileElement fileElement, PicSize picSize) {
        int i3 = c.f190575a[picSize.ordinal()];
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return 750;
    }

    private final String o(FileElement fileElement, PicSize picSize) {
        return fileElement.picThumbPath.get(Integer.valueOf(n(fileElement, picSize)));
    }

    private final byte[] s(String s16) {
        int length = s16.length();
        byte[] bArr = new byte[length / 2];
        for (int i3 = 0; i3 < length; i3 += 2) {
            bArr[i3 / 2] = (byte) ((Character.digit(s16.charAt(i3), 16) << 4) + Character.digit(s16.charAt(i3 + 1), 16));
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String t(PicElement picElement) {
        String str = picElement.downloadIndex;
        if (str != null) {
            return new String(f190570a.s(str), Charsets.UTF_8);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(final PicSize size, final MsgElement msgElement, final ImageView targetView, final com.tencent.mobileqq.aio.msg.w msgItem, final Drawable loadingDrawable, final a provider, final Function1 loadFun, final String imageUrl) {
        Intrinsics.checkNotNullParameter(size, "$size");
        Intrinsics.checkNotNullParameter(msgElement, "$msgElement");
        Intrinsics.checkNotNullParameter(targetView, "$targetView");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(loadingDrawable, "$loadingDrawable");
        Intrinsics.checkNotNullParameter(provider, "$provider");
        Intrinsics.checkNotNullParameter(loadFun, "$loadFun");
        Intrinsics.checkNotNullParameter(imageUrl, "$imageUrl");
        final boolean x16 = f190570a.x(size, msgElement);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.base.c
            @Override // java.lang.Runnable
            public final void run() {
                AIOPicDownloader.w(targetView, msgItem, x16, loadingDrawable, msgElement, size, provider, loadFun, imageUrl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(ImageView targetView, com.tencent.mobileqq.aio.msg.w msgItem, boolean z16, Drawable loadingDrawable, MsgElement msgElement, PicSize size, a provider, final Function1 loadFun, String imageUrl) {
        Intrinsics.checkNotNullParameter(targetView, "$targetView");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(loadingDrawable, "$loadingDrawable");
        Intrinsics.checkNotNullParameter(msgElement, "$msgElement");
        Intrinsics.checkNotNullParameter(size, "$size");
        Intrinsics.checkNotNullParameter(provider, "$provider");
        Intrinsics.checkNotNullParameter(loadFun, "$loadFun");
        Intrinsics.checkNotNullParameter(imageUrl, "$imageUrl");
        Object tag = targetView.getTag(R.id.f73263t3);
        if (!Intrinsics.areEqual(tag, Long.valueOf(msgItem.getMsgId()))) {
            QLog.w("AIOPicDownloader.Downloader", 1, "[loadImageView] tag not matched, " + tag + " != " + msgItem.getMsgId());
            return;
        }
        if (z16) {
            targetView.setImageDrawable(loadingDrawable);
            f190570a.e(msgElement, size, provider, 1, 1, new Function1<FileTransNotifyInfo, Unit>(loadFun) { // from class: com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader$loadImageView$2$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function1<String, Unit> $loadFun;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.$loadFun = loadFun;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) loadFun);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FileTransNotifyInfo fileTransNotifyInfo) {
                    invoke2(fileTransNotifyInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull FileTransNotifyInfo it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    Function1<String, Unit> function1 = this.$loadFun;
                    String str = it.filePath;
                    Intrinsics.checkNotNullExpressionValue(str, "it.filePath");
                    function1.invoke(str);
                }
            });
        } else {
            loadFun.invoke(imageUrl);
        }
    }

    private final boolean x(PicSize size, MsgElement element) {
        int i3 = element.elementType;
        if (i3 == 2 || i3 == 5 || i.b(element) || i.c(element)) {
            try {
                return !new File(p(element, size)).exists();
            } catch (Exception e16) {
                QLog.e("AIOPicDownloader.Downloader", 1, "needDownloadPicMsgElement e:" + e16);
                return false;
            }
        }
        return false;
    }

    public final void e(@NotNull final MsgElement msgElement, @NotNull PicSize size, @NotNull final b paramsProvider, final int downloadSourceType, final int triggerType, @Nullable final Function1<? super FileTransNotifyInfo, Unit> cb5) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, msgElement, size, paramsProvider, Integer.valueOf(downloadSourceType), Integer.valueOf(triggerType), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(paramsProvider, "paramsProvider");
        if (QLog.isDevelopLevel()) {
            QLog.d("AIOPicDownloader.Downloader", 4, "downloadPic " + QLog.getStackTraceString(new Throwable()));
        }
        Pair<Integer, Integer> k3 = k(msgElement, size);
        final Integer component1 = k3.component1();
        final Integer component2 = k3.component2();
        if (component1 != null && component2 != null) {
            int seq = paramsProvider.getSeq();
            long j3 = msgElement.elementId;
            long msgSeq = paramsProvider.getMsgSeq();
            String peerUin = paramsProvider.getPeerUin();
            PicElement picElement = msgElement.picElement;
            if (picElement != null) {
                AIOPicDownloader aIOPicDownloader = f190570a;
                Intrinsics.checkNotNullExpressionValue(picElement, "picElement");
                str = aIOPicDownloader.t(picElement);
            } else {
                str = null;
            }
            QLog.i("AIOPicDownloader.Downloader", 1, "downPic Begin  seq:" + seq + " eleId:" + j3 + " msgSeq:" + msgSeq + " channelId:" + peerUin + ((Object) (" downType:" + component1 + " thumbLevel:" + component2 + " index:" + str)));
            final long currentTimeMillis = System.currentTimeMillis();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.base.a
                @Override // java.lang.Runnable
                public final void run() {
                    AIOPicDownloader.f(AIOPicDownloader.b.this, component1, component2, msgElement, downloadSourceType, triggerType, cb5, currentTimeMillis);
                }
            }, 16, null, false);
            return;
        }
        QLog.i("AIOPicDownloader.Downloader", 1, "msgElement type ERR " + msgElement.elementType);
    }

    @NotNull
    public final PicSize i(@NotNull PicElement picElement, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (PicSize) iPatchRedirector.redirect((short) 6, this, picElement, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        if (i16 != 0) {
            if (i16 != 198) {
                if (i16 != 720) {
                    return PicSize.PIC_DOWNLOAD_THUMB;
                }
                return PicSize.PIC_DOWNLOAD_BIG_THUMB;
            }
            return PicSize.PIC_DOWNLOAD_THUMB;
        }
        if (i3 == 1) {
            return PicSize.PIC_DOWNLOAD_ORI;
        }
        return PicSize.PIC_LOCAL_HD_THUMB;
    }

    public final int j(@NotNull FileElement fileElement, @NotNull PicSize picSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) fileElement, (Object) picSize)).intValue();
        }
        Intrinsics.checkNotNullParameter(fileElement, "<this>");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        int i3 = c.f190575a[picSize.ordinal()];
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return 750;
    }

    @Nullable
    public final String l(@NotNull PicElement picElement, @NotNull PicSize size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) picElement, (Object) size);
        }
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Intrinsics.checkNotNullParameter(size, "size");
        int i3 = c.f190575a[size.ordinal()];
        if (i3 != 1) {
            if (i3 != 3) {
                return aj.b(picElement, 198);
            }
            return aj.b(picElement, 198);
        }
        return aj.a(picElement);
    }

    @NotNull
    public final String m(@NotNull PicSize picSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) picSize);
        }
        Intrinsics.checkNotNullParameter(picSize, "<this>");
        int i3 = c.f190575a[picSize.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return "LARGE";
            }
            if (i3 != 3) {
                if (i3 == 4) {
                    return "LARGE";
                }
                throw new NoWhenBranchMatchedException();
            }
            return "THUMB";
        }
        return "ORIGIN";
    }

    @NotNull
    public final String p(@NotNull MsgElement msgElement, @NotNull PicSize size) {
        String q16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgElement, (Object) size);
        }
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(size, "size");
        int i3 = msgElement.elementType;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 5) {
                    QLog.i("AIOPicDownloader.Downloader", 1, "getPicImagePath error type=" + i3);
                    q16 = "";
                } else {
                    VideoElement videoElement = msgElement.videoElement;
                    Intrinsics.checkNotNullExpressionValue(videoElement, "msgElement.videoElement");
                    q16 = aj.f(videoElement);
                }
            } else {
                FileElement fileElement = msgElement.fileElement;
                Intrinsics.checkNotNullExpressionValue(fileElement, "msgElement.fileElement");
                q16 = o(fileElement, size);
            }
        } else {
            PicElement picElement = msgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement, "msgElement.picElement");
            q16 = q(picElement, size);
        }
        if (q16 == null) {
            return "";
        }
        return q16;
    }

    @Nullable
    public final String q(@NotNull PicElement picElement, @NotNull PicSize size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) picElement, (Object) size);
        }
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Intrinsics.checkNotNullParameter(size, "size");
        int i3 = c.f190575a[size.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        return aj.b(picElement, 720);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return aj.b(picElement, 198);
            }
            return aj.b(picElement, 0);
        }
        return aj.a(picElement);
    }

    @NotNull
    public final AtomicInteger r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AtomicInteger) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return sNextSeq;
    }

    @MainThread
    public final void u(@NotNull final ImageView targetView, @NotNull final String imageUrl, final int imageWidth, final int imageHeight, @NotNull final Drawable loadingDrawable, @NotNull final PicSize size, @NotNull final MsgElement msgElement, @NotNull final com.tencent.mobileqq.aio.msg.w msgItem, @Nullable final Function2<? super Boolean, ? super PicContentViewUtil.FailReason, Unit> onImageLoad) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, targetView, imageUrl, Integer.valueOf(imageWidth), Integer.valueOf(imageHeight), loadingDrawable, size, msgElement, msgItem, onImageLoad);
            return;
        }
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(loadingDrawable, "loadingDrawable");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        targetView.setTag(R.id.f73263t3, Long.valueOf(msgItem.getMsgId()));
        final a aVar = new a(msgItem, i16, i3, null);
        final WeakReference weakReference = new WeakReference(targetView);
        final Function1<String, Unit> function1 = new Function1<String, Unit>(weakReference, size, imageWidth, imageHeight, msgElement, msgItem, onImageLoad) { // from class: com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader$loadImageView$loadFun$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $imageHeight;
            final /* synthetic */ int $imageWidth;
            final /* synthetic */ MsgElement $msgElement;
            final /* synthetic */ com.tencent.mobileqq.aio.msg.w $msgItem;
            final /* synthetic */ Function2<Boolean, PicContentViewUtil.FailReason, Unit> $onImageLoad;
            final /* synthetic */ PicSize $size;
            final /* synthetic */ WeakReference<ImageView> $weakPicView;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$weakPicView = weakReference;
                this.$size = size;
                this.$imageWidth = imageWidth;
                this.$imageHeight = imageHeight;
                this.$msgElement = msgElement;
                this.$msgItem = msgItem;
                this.$onImageLoad = onImageLoad;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, weakReference, size, Integer.valueOf(imageWidth), Integer.valueOf(imageHeight), msgElement, msgItem, onImageLoad);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String path) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) path);
                    return;
                }
                Intrinsics.checkNotNullParameter(path, "path");
                ImageView imageView = this.$weakPicView.get();
                if (imageView != null) {
                    PicContentViewUtil.f190621a.h(imageView, path, this.$size, this.$imageWidth, this.$imageHeight, this.$msgElement, this.$msgItem, PicContentViewUtil.LoadingImage.LoadingIcon, this.$onImageLoad);
                }
            }
        };
        int seq = aVar.getSeq();
        long j3 = msgElement.elementId;
        long msgSeq = aVar.getMsgSeq();
        String peerUin = aVar.getPeerUin();
        long msgId = msgItem.getMsgId();
        int hashCode = targetView.hashCode();
        PicElement picElement = msgElement.picElement;
        if (picElement != null) {
            str = picElement.md5HexStr;
        } else {
            str = null;
        }
        QLog.i("AIOPicDownloader.Downloader", 1, "loadPic Begin  seq:" + seq + " eleId:" + j3 + " msgSeq:" + msgSeq + " channelId:" + peerUin + ((Object) (" msgId: " + msgId + " view: " + hashCode + " md5: " + str)));
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.base.b
            @Override // java.lang.Runnable
            public final void run() {
                AIOPicDownloader.v(PicSize.this, msgElement, targetView, msgItem, loadingDrawable, aVar, function1, imageUrl);
            }
        }, 16, null, false);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/base/AIOPicDownloader$a;", "Lcom/tencent/mobileqq/aio/msglist/holder/base/AIOPicDownloader$b;", "", "getSeq", "", "getMsgId", "getMsgSeq", "getChatType", "", "getPeerUin", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "getMsgItem", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "b", "I", "seq", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "getMsgRecord", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;I)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOMsgItem msgItem;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int seq;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MsgRecord msgRecord;

        public a(@NotNull AIOMsgItem msgItem, int i3) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItem, i3);
                return;
            }
            this.msgItem = msgItem;
            this.seq = i3;
            this.msgRecord = msgItem.getMsgRecord();
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader.b
        @NotNull
        public RichMediaElementGetReq a(int i3, int i16, @NotNull MsgElement msgElement, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (RichMediaElementGetReq) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), msgElement, Integer.valueOf(i17), Integer.valueOf(i18));
            }
            return b.a.a(this, i3, i16, msgElement, i17, i18);
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader.b
        public int getChatType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return this.msgItem.p0();
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader.b
        public long getMsgId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
            }
            return this.msgItem.q0();
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader.b
        public long getMsgSeq() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
            }
            return this.msgRecord.msgSeq;
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader.b
        @NotNull
        public String getPeerUin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return this.msgItem.r0();
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader.b
        public int getSeq() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.seq;
        }

        public /* synthetic */ a(AIOMsgItem aIOMsgItem, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(aIOMsgItem, (i16 & 2) != 0 ? AIOPicDownloader.f190570a.r().getAndIncrement() : i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, aIOMsgItem, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
        }
    }
}
