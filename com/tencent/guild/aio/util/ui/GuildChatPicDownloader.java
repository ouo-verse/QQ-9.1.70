package com.tencent.guild.aio.util.ui;

import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.guild.aio.util.ui.GuildChatPicDownloader;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.pic.IGuildPicApi;
import com.tencent.guild.api.video.IGuildVideoApi;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.api.ab;
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
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.MsgExtKt;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b6\u00107J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\n\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\f\u001a\u0004\u0018\u00010\u0006*\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u000f\u001a\u00020\t*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0014\u0010\u0010\u001a\u00020\t*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0014\u0010\u0011\u001a\u00020\t*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0014\u0010\u0012\u001a\u00020\t*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\f\u0010\u0013\u001a\u00020\u0006*\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\f\u0010\u0016\u001a\u00020\u0004*\u00020\rH\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J>\u0010#\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\t2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!H\u0007J,\u0010'\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0018\u0018\u00010$J4\u0010(\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0018\u0018\u00010$J4\u0010+\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)2\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0018\u0018\u00010$J\u0016\u0010.\u001a\u00020-2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0002J\u0018\u0010/\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0017\u00105\u001a\u0002008\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/guild/aio/util/ui/GuildChatPicDownloader;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/guild/aio/util/ui/PicSize;", "size", "", "o", "Lkotlin/Pair;", "", "j", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "p", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picSize", "l", DomainData.DOMAIN_NAME, "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", ReportConstant.COSTREPORT_PREFIX, "", "d", "localPath", "", "e", "filePath", "i", "Lcom/tencent/libra/request/Option;", "option", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "retryCount", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "listener", "u", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "cb", h.F, "g", "Lcom/tencent/guild/aio/util/ui/e;", "paramsProvider", "f", DTConstants.TAG.ELEMENT, "", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/concurrent/atomic/AtomicInteger;", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "r", "()Ljava/util/concurrent/atomic/AtomicInteger;", "sNextSeq", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildChatPicDownloader {

    /* renamed from: a */
    @NotNull
    public static final GuildChatPicDownloader f112420a = new GuildChatPicDownloader();

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static final AtomicInteger sNextSeq = new AtomicInteger(10000);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f112422a;

        static {
            int[] iArr = new int[PicSize.values().length];
            try {
                iArr[PicSize.PIC_DOWNLOAD_ORI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PicSize.PIC_DOWNLOAD_THUMB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PicSize.PIC_DOWNLOAD_AIO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f112422a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/util/ui/GuildChatPicDownloader$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "", "onRichMediaDownloadComplete", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements IKernelMsgListener {

        /* renamed from: d */
        final /* synthetic */ e f112423d;

        /* renamed from: e */
        final /* synthetic */ MsgElement f112424e;

        /* renamed from: f */
        final /* synthetic */ Integer f112425f;

        /* renamed from: h */
        final /* synthetic */ Integer f112426h;

        /* renamed from: i */
        final /* synthetic */ Function1<FileTransNotifyInfo, Unit> f112427i;

        /* JADX WARN: Multi-variable type inference failed */
        b(e eVar, MsgElement msgElement, Integer num, Integer num2, Function1<? super FileTransNotifyInfo, Unit> function1) {
            this.f112423d = eVar;
            this.f112424e = msgElement;
            this.f112425f = num;
            this.f112426h = num2;
            this.f112427i = function1;
        }

        public static final void b(Function1 function1, FileTransNotifyInfo fileTransNotifyInfo, b this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (function1 != null) {
                function1.invoke(fileTransNotifyInfo);
            }
            w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                e16.removeMsgListener(this$0);
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
        public void onRichMediaDownloadComplete(@Nullable final FileTransNotifyInfo notifyInfo) {
            if (notifyInfo != null && this.f112423d.getMsgId() == notifyInfo.msgId) {
                MsgElement msgElement = this.f112424e;
                if (msgElement.elementId == notifyInfo.msgElementId) {
                    GuildChatPicDownloader guildChatPicDownloader = GuildChatPicDownloader.f112420a;
                    e eVar = this.f112423d;
                    Integer num = this.f112425f;
                    Integer num2 = this.f112426h;
                    if (QLog.isColorLevel()) {
                        QLog.i("GUILD_MSGPIC.Downloader", 1, "downPic Finish seq:" + eVar.getSeq() + " eleId:" + msgElement.elementId + " msgSeq:" + eVar.getMsgSeq() + " channelId:" + eVar.getPeerUin() + ((Object) (" downType:" + num + "  thumbLevel:" + num2 + " info:" + notifyInfo + "}")));
                    }
                    MqqHandler uIHandler = ThreadManager.getUIHandler();
                    final Function1<FileTransNotifyInfo, Unit> function1 = this.f112427i;
                    uIHandler.post(new Runnable() { // from class: com.tencent.guild.aio.util.ui.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildChatPicDownloader.b.b(Function1.this, notifyInfo, this);
                        }
                    });
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

    GuildChatPicDownloader() {
    }

    private final PicSize d(PicElement picElement) {
        if (MsgExtKt.x(picElement)) {
            return PicSize.PIC_DOWNLOAD_ORI;
        }
        return PicSize.PIC_DOWNLOAD_THUMB;
    }

    public final void e(String localPath) {
        try {
            new File(localPath).delete();
        } catch (Exception e16) {
            QLog.e("GUILD_MSGPIC.Downloader", 1, "deleteFile ERR " + e16);
        }
    }

    public final String i(String filePath) {
        try {
            File file = new File(filePath);
            Triple triple = new Triple(HexUtil.bytes2HexStr(MD5.getPartfileMd5(filePath, file.length())), Boolean.valueOf(file.canRead()), Boolean.valueOf(file.canWrite()));
            return " md5:" + ((String) triple.component1()) + " canRead:" + ((Boolean) triple.component2()).booleanValue() + " canWrite:" + ((Boolean) triple.component3()).booleanValue();
        } catch (Exception e16) {
            return e16.toString();
        }
    }

    private final Pair<Integer, Integer> j(MsgElement msgElement, PicSize size) {
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
            Integer valueOf = Integer.valueOf(k(fileElement, size));
            FileElement fileElement2 = msgElement.fileElement;
            Intrinsics.checkNotNullExpressionValue(fileElement2, "msgElement.fileElement");
            pair = new Pair<>(valueOf, Integer.valueOf(m(fileElement2, size)));
        } else {
            PicElement picElement = msgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement, "msgElement.picElement");
            Integer valueOf2 = Integer.valueOf(l(picElement, size));
            PicElement picElement2 = msgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement2, "msgElement.picElement");
            pair = new Pair<>(valueOf2, Integer.valueOf(n(picElement2, size)));
        }
        return pair;
    }

    private final int k(FileElement fileElement, PicSize picSize) {
        int i3 = a.f112422a[picSize.ordinal()];
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2 && i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return i16;
    }

    private final int l(PicElement picElement, PicSize picSize) {
        int i3 = a.f112422a[picSize.ordinal()];
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 == 3) {
            return l(picElement, d(picElement));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int m(FileElement fileElement, PicSize picSize) {
        int i3 = a.f112422a[picSize.ordinal()];
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return 750;
    }

    private final int n(PicElement picElement, PicSize picSize) {
        int i3 = a.f112422a[picSize.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return n(picElement, d(picElement));
                }
                throw new NoWhenBranchMatchedException();
            }
            return 720;
        }
        return 0;
    }

    private final String o(MsgElement msgElement, PicSize size) {
        int i3 = a.f112422a[size.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    PicElement picElement = msgElement.picElement;
                    Intrinsics.checkNotNullExpressionValue(picElement, "msgElement.picElement");
                    return o(msgElement, d(picElement));
                }
                throw new NoWhenBranchMatchedException();
            }
            IGuildPicApi iGuildPicApi = (IGuildPicApi) QRoute.api(IGuildPicApi.class);
            PicElement picElement2 = msgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement2, "msgElement.picElement");
            return iGuildPicApi.getPicPath(msgElement, 2, n(picElement2, size));
        }
        return ((IGuildPicApi) QRoute.api(IGuildPicApi.class)).getOriginImagePath(msgElement);
    }

    private final String p(FileElement fileElement, PicSize picSize) {
        return fileElement.picThumbPath.get(Integer.valueOf(m(fileElement, picSize)));
    }

    private final byte[] s(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i3 = 0; i3 < length; i3 += 2) {
            bArr[i3 / 2] = (byte) ((Character.digit(str.charAt(i3), 16) << 4) + Character.digit(str.charAt(i3 + 1), 16));
        }
        return bArr;
    }

    public final String t(PicElement picElement) {
        String str = picElement.downloadIndex;
        if (str != null) {
            return new String(f112420a.s(str), Charsets.UTF_8);
        }
        return "";
    }

    public static /* synthetic */ void v(GuildChatPicDownloader guildChatPicDownloader, Option option, PicSize picSize, MsgElement msgElement, MsgRecord msgRecord, int i3, GuildPicStateListener guildPicStateListener, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            i3 = 1;
        }
        int i17 = i3;
        if ((i16 & 32) != 0) {
            guildPicStateListener = null;
        }
        guildChatPicDownloader.u(option, picSize, msgElement, msgRecord, i17, guildPicStateListener);
    }

    public final void f(@NotNull MsgElement msgElement, @NotNull PicSize size, @NotNull e paramsProvider, @Nullable Function1<? super FileTransNotifyInfo, Unit> cb5) {
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(paramsProvider, "paramsProvider");
        boolean isSelfGuest = ((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isSelfGuest(paramsProvider.getPeerUin(), paramsProvider.getGuildID());
        Pair<Integer, Integer> j3 = j(msgElement, size);
        Integer component1 = j3.component1();
        Integer component2 = j3.component2();
        String str = null;
        if (component1 != null && component2 != null) {
            if (QLog.isColorLevel()) {
                int seq = paramsProvider.getSeq();
                long j16 = msgElement.elementId;
                long msgSeq = paramsProvider.getMsgSeq();
                String peerUin = paramsProvider.getPeerUin();
                PicElement picElement = msgElement.picElement;
                if (picElement != null) {
                    GuildChatPicDownloader guildChatPicDownloader = f112420a;
                    Intrinsics.checkNotNullExpressionValue(picElement, "picElement");
                    str = guildChatPicDownloader.t(picElement);
                }
                QLog.i("GUILD_MSGPIC.Downloader", 1, "downPic Begin  seq:" + seq + " eleId:" + j16 + " msgSeq:" + msgSeq + " channelId:" + peerUin + ((Object) (" downType:" + component1 + "  thumbLevel:" + component2 + " index:" + str)));
            }
            w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                e16.addMsgListener(new b(paramsProvider, msgElement, component1, component2, cb5));
            }
            if (isSelfGuest) {
                ab g16 = com.tencent.qqnt.msg.f.g();
                if (g16 != null) {
                    g16.downloadRichMediaInVisit(paramsProvider.d(component1.intValue(), component2.intValue(), msgElement));
                    return;
                }
                return;
            }
            w e17 = com.tencent.qqnt.msg.f.e();
            if (e17 != null) {
                e17.getRichMediaElement(paramsProvider.c(component1.intValue(), component2.intValue(), msgElement));
                return;
            }
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str2 = "msgElement type ERR " + msgElement.elementType;
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("GUILD_MSGPIC.Downloader", 1, (String) it.next(), null);
        }
    }

    public final void g(@NotNull MsgElement msgElement, @NotNull PicSize size, @NotNull MsgRecord msgRecord, @Nullable Function1<? super FileTransNotifyInfo, Unit> cb5) {
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        f(msgElement, size, new com.tencent.guild.aio.util.ui.b(msgRecord, 0, 2, null), cb5);
    }

    public final void h(@NotNull PicSize size, @NotNull MsgRecord msgRecord, @Nullable Function1<? super FileTransNotifyInfo, Unit> function1) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (!MsgExtKt.y(msgRecord) && !MsgExtKt.L(msgRecord)) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GUILD_MSGPIC.Downloader", "msgRecord type ERR " + msgRecord.msgType);
                return;
            }
            return;
        }
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        for (MsgElement it : arrayList) {
            GuildChatPicDownloader guildChatPicDownloader = f112420a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            guildChatPicDownloader.f(it, size, new com.tencent.guild.aio.util.ui.b(msgRecord, 0, 2, null), function1);
        }
    }

    @Deprecated(message = "\u6d88\u606f\u91cc\u7684\u8def\u5f84\u4e0d\u53ef\u4fe1\uff0c\u614e\u7528")
    @NotNull
    public final String q(@NotNull MsgElement msgElement, @NotNull PicSize size) {
        String o16;
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(size, "size");
        int i3 = msgElement.elementType;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 5) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str = "ERROR TYPE " + msgElement.elementType;
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("GUILD_MSGPIC.Downloader", 1, (String) it.next(), null);
                    }
                    o16 = "";
                } else {
                    QRouteApi api = QRoute.api(IGuildVideoApi.class);
                    Intrinsics.checkNotNullExpressionValue(api, "api(IGuildVideoApi::class.java)");
                    o16 = IGuildVideoApi.a.b((IGuildVideoApi) api, msgElement, false, 2, null);
                }
            } else {
                FileElement fileElement = msgElement.fileElement;
                Intrinsics.checkNotNullExpressionValue(fileElement, "msgElement.fileElement");
                o16 = p(fileElement, size);
            }
        } else {
            o16 = o(msgElement, size);
        }
        if (o16 == null) {
            return "";
        }
        return o16;
    }

    @NotNull
    public final AtomicInteger r() {
        return sNextSeq;
    }

    @MainThread
    public final void u(@NotNull final Option option, @NotNull final PicSize size, @NotNull final MsgElement msgElement, @NotNull final MsgRecord msgRecord, final int retryCount, @Nullable final GuildPicStateListener listener) {
        Integer num;
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ImageView targetView = option.getTargetView();
        if (targetView != null) {
            targetView.setTag(R.id.vxx, Long.valueOf(msgElement.elementId));
        }
        ImageView targetView2 = option.getTargetView();
        if (targetView2 != null) {
            targetView2.setTag(R.id.vxy, Boolean.FALSE);
        }
        String str = null;
        final com.tencent.guild.aio.util.ui.b bVar = new com.tencent.guild.aio.util.ui.b(msgRecord, 0, 2, null);
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.guild.aio.util.ui.GuildChatPicDownloader$loadImageView$loadFun$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String path) {
                Intrinsics.checkNotNullParameter(path, "path");
                ImageView targetView3 = Option.this.getTargetView();
                if ((targetView3 != null ? Intrinsics.areEqual(targetView3.getTag(R.id.vxx), Long.valueOf(msgElement.elementId)) : false) && cq.n(path)) {
                    Option.this.setUrl(path);
                    Option.this.setLocalPath(path);
                    com.tencent.mobileqq.guild.picload.e a16 = com.tencent.mobileqq.guild.picload.e.a();
                    final Option option2 = Option.this;
                    final MsgElement msgElement2 = msgElement;
                    final b bVar2 = bVar;
                    final int i3 = retryCount;
                    final GuildPicStateListener guildPicStateListener = listener;
                    final PicSize picSize = size;
                    final MsgRecord msgRecord2 = msgRecord;
                    a16.f(option2, new GuildPicStateListener() { // from class: com.tencent.guild.aio.util.ui.GuildChatPicDownloader$loadImageView$loadFun$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(false);
                        }

                        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
                        public void c(@NotNull LoadState state, @Nullable Option op5) {
                            String str2;
                            AnonymousClass1 anonymousClass1;
                            boolean z16;
                            Integer num2;
                            String i16;
                            Intrinsics.checkNotNullParameter(state, "state");
                            GuildChatPicDownloader guildChatPicDownloader = GuildChatPicDownloader.f112420a;
                            MsgElement msgElement3 = MsgElement.this;
                            b bVar3 = bVar2;
                            Option option3 = option2;
                            if (!QLog.isColorLevel()) {
                                str2 = "GUILD_MSGPIC.Downloader";
                            } else {
                                int seq = bVar3.getSeq();
                                long j3 = msgElement3.elementId;
                                long msgSeq = bVar3.getMsgSeq();
                                String peerUin = bVar3.getPeerUin();
                                ImageView targetView4 = option3.getTargetView();
                                if (targetView4 != null) {
                                    num2 = Integer.valueOf(targetView4.hashCode());
                                } else {
                                    num2 = null;
                                }
                                String str3 = " view: " + num2 + " state: " + state;
                                if (state.isFinishError()) {
                                    GuildChatPicDownloader guildChatPicDownloader2 = GuildChatPicDownloader.f112420a;
                                    String localPath = option3.getLocalPath();
                                    Intrinsics.checkNotNullExpressionValue(localPath, "option.localPath");
                                    i16 = guildChatPicDownloader2.i(localPath);
                                    str3 = str3 + i16;
                                }
                                str2 = "GUILD_MSGPIC.Downloader";
                                QLog.i(str2, 1, "loadPic Finish seq:" + seq + " eleId:" + j3 + " msgSeq:" + msgSeq + " channelId:" + peerUin + ((Object) str3));
                            }
                            if (state.isFinishError()) {
                                anonymousClass1 = this;
                                if (i3 > 0) {
                                    if (state == LoadState.STATE_DECODE_FAILED && FileUtils.isValidPathCanDelete(option2.getLocalPath())) {
                                        GuildChatPicDownloader guildChatPicDownloader3 = GuildChatPicDownloader.f112420a;
                                        String localPath2 = option2.getLocalPath();
                                        Intrinsics.checkNotNullExpressionValue(localPath2, "option.localPath");
                                        guildChatPicDownloader3.e(localPath2);
                                    }
                                    ImageView targetView5 = option2.getTargetView();
                                    if (targetView5 != null) {
                                        z16 = Intrinsics.areEqual(targetView5.getTag(R.id.vxx), Long.valueOf(MsgElement.this.elementId));
                                    } else {
                                        z16 = false;
                                    }
                                    if (z16) {
                                        MsgElement msgElement4 = MsgElement.this;
                                        b bVar4 = bVar2;
                                        int i17 = i3;
                                        if (QLog.isColorLevel()) {
                                            QLog.i(str2, 1, "loadPic Retry  seq:" + bVar4.getSeq() + " eleId:" + msgElement4.elementId + " msgSeq:" + bVar4.getMsgSeq() + " channelId:" + bVar4.getPeerUin() + ((Object) (" retryCount:" + i17)));
                                        }
                                        final Option option4 = option2;
                                        final PicSize picSize2 = picSize;
                                        final MsgElement msgElement5 = MsgElement.this;
                                        final MsgRecord msgRecord3 = msgRecord2;
                                        final int i18 = i3;
                                        final GuildPicStateListener guildPicStateListener2 = guildPicStateListener;
                                        PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.guild.aio.util.ui.GuildChatPicDownloader$loadImageView$loadFun$1$1$onStateChangeCallback$3
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
                                                GuildChatPicDownloader.f112420a.u(Option.this, picSize2, msgElement5, msgRecord3, i18 - 1, guildPicStateListener2);
                                            }
                                        });
                                    }
                                } else {
                                    MsgElement msgElement6 = MsgElement.this;
                                    b bVar5 = bVar2;
                                    if (QLog.isColorLevel()) {
                                        QLog.i(str2, 1, "loadPic Error  seq:" + bVar5.getSeq() + " eleId:" + msgElement6.elementId + " msgSeq:" + bVar5.getMsgSeq() + " channelId:" + bVar5.getPeerUin() + ((Object) "no retryCount"));
                                    }
                                }
                            } else {
                                anonymousClass1 = this;
                            }
                            GuildPicStateListener guildPicStateListener3 = guildPicStateListener;
                            if (guildPicStateListener3 != null) {
                                guildPicStateListener3.onStateChange(state, op5);
                            }
                        }
                    });
                    return;
                }
                ImageView targetView4 = Option.this.getTargetView();
                if (targetView4 != null) {
                    targetView4.setTag(R.id.vxy, Boolean.TRUE);
                }
                GuildChatPicDownloader guildChatPicDownloader = GuildChatPicDownloader.f112420a;
                MsgElement msgElement3 = msgElement;
                b bVar3 = bVar;
                Option option3 = Option.this;
                if (QLog.isColorLevel()) {
                    int seq = bVar3.getSeq();
                    long j3 = msgElement3.elementId;
                    long msgSeq = bVar3.getMsgSeq();
                    String peerUin = bVar3.getPeerUin();
                    ImageView targetView5 = option3.getTargetView();
                    QLog.i("GUILD_MSGPIC.Downloader", 1, "loadPic Illega seq:" + seq + " eleId:" + j3 + " msgSeq:" + msgSeq + " channelId:" + peerUin + ((Object) (" view: " + (targetView5 != null ? Integer.valueOf(targetView5.hashCode()) : null))));
                }
            }
        };
        if (QLog.isColorLevel()) {
            int seq = bVar.getSeq();
            long j3 = msgElement.elementId;
            long msgSeq = bVar.getMsgSeq();
            String peerUin = bVar.getPeerUin();
            ImageView targetView3 = option.getTargetView();
            if (targetView3 != null) {
                num = Integer.valueOf(targetView3.hashCode());
            } else {
                num = null;
            }
            PicElement picElement = msgElement.picElement;
            if (picElement != null) {
                str = picElement.md5HexStr;
            }
            QLog.i("GUILD_MSGPIC.Downloader", 1, "loadPic Begin  seq:" + seq + " eleId:" + j3 + " msgSeq:" + msgSeq + " channelId:" + peerUin + ((Object) (" view: " + num + " md5: " + str)));
        }
        if (w(size, msgElement)) {
            option.getTargetView().setImageDrawable(option.getLoadingDrawable());
            f(msgElement, size, bVar, new Function1<FileTransNotifyInfo, Unit>() { // from class: com.tencent.guild.aio.util.ui.GuildChatPicDownloader$loadImageView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FileTransNotifyInfo fileTransNotifyInfo) {
                    invoke2(fileTransNotifyInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull FileTransNotifyInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Function1<String, Unit> function12 = function1;
                    String str2 = it.filePath;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.filePath");
                    function12.invoke(str2);
                }
            });
        } else {
            String url = option.getUrl();
            Intrinsics.checkNotNullExpressionValue(url, "option.url");
            function1.invoke(url);
        }
    }

    public final boolean w(@NotNull PicSize size, @NotNull MsgElement r65) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(r65, "element");
        int i3 = r65.elementType;
        if (i3 == 2 || i3 == 5 || com.tencent.guild.aio.util.ex.e.f(r65) || com.tencent.guild.aio.util.ex.e.h(r65)) {
            try {
                return !new File(q(r65, size)).exists();
            } catch (Exception e16) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "needDownloadPicMsgElement e:" + e16;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GUILD_MSGPIC.Downloader", 1, (String) it.next(), null);
                }
                return false;
            }
        }
        return false;
    }
}
