package com.tencent.mobileqq.activity.emogroupstore;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.emogroupstore.ExtensionsKt;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
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
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.MsgExtKt;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\u0012\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u001e\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001\u001aG\u0010\u0015\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000fH\u0000\u001a8\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fH\u0000\u001a2\u0010&\u001a\u00020\r*\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$\u001a,\u0010(\u001a\u00020\r*\u00020 2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0002\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "Lcom/tencent/mobileqq/activity/emogroupstore/PicSize;", "b", "picSize", "", "g", tl.h.F, "size", "Lkotlin/Pair;", "i", "", "path", "Lkotlin/Function0;", "", "noExit", "Lkotlin/Function1;", "Ljava/io/File;", "Lkotlin/ParameterName;", "name", "file", "exit", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "cb", "d", "Lcom/tencent/mobileqq/data/EmoticonFromGroupEntity;", "Lcom/tencent/mobileqq/emosm/favroaming/l;", "manager", "Landroid/widget/ImageView;", "iv", "type", "width", "Lkotlinx/coroutines/CoroutineScope;", "scope", "c", "entity", "j", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ExtensionsKt {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f182063a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50562);
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
                iArr[PicSize.PIC_DOWNLOAD_THUMB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PicSize.PIC_DOWNLOAD_AIO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f182063a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/activity/emogroupstore/ExtensionsKt$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "", "onRichMediaDownloadComplete", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements IKernelMsgListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MsgElement f182064d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Pair<Integer, Integer> f182065e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<FileTransNotifyInfo, Unit> f182066f;

        /* JADX WARN: Multi-variable type inference failed */
        b(MsgElement msgElement, Pair<Integer, Integer> pair, Function1<? super FileTransNotifyInfo, Unit> function1) {
            this.f182064d = msgElement;
            this.f182065e = pair;
            this.f182066f = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, msgElement, pair, function1);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) notifyInfo);
                return;
            }
            if (notifyInfo != null && this.f182064d.elementId == notifyInfo.msgElementId && this.f182065e.getFirst().intValue() == notifyInfo.fileDownType) {
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                final Function1<FileTransNotifyInfo, Unit> function1 = this.f182066f;
                uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.emogroupstore.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        ExtensionsKt.b.b(Function1.this, notifyInfo, this);
                    }
                });
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

    private static final PicSize b(PicElement picElement) {
        if (MsgExtKt.x(picElement)) {
            return PicSize.PIC_DOWNLOAD_ORI;
        }
        return PicSize.PIC_DOWNLOAD_THUMB;
    }

    public static final void c(@NotNull final EmoticonFromGroupEntity emoticonFromGroupEntity, @NotNull final com.tencent.mobileqq.emosm.favroaming.l manager, @NotNull final ImageView iv5, final int i3, final int i16, @NotNull final CoroutineScope scope) {
        Pair pair;
        Intrinsics.checkNotNullParameter(emoticonFromGroupEntity, "<this>");
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(iv5, "iv");
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (i3 != 1) {
            if (i3 != 65537) {
                return;
            } else {
                pair = TuplesKt.to(emoticonFromGroupEntity.thumbURL, PicSize.PIC_DOWNLOAD_THUMB);
            }
        } else {
            pair = TuplesKt.to(emoticonFromGroupEntity.bigURL, PicSize.PIC_DOWNLOAD_ORI);
        }
        String str = (String) pair.component1();
        final PicSize picSize = (PicSize) pair.component2();
        e(str, new Function0<Unit>(i3, emoticonFromGroupEntity, picSize, iv5, manager, i16) { // from class: com.tencent.mobileqq.activity.emogroupstore.ExtensionsKt$applyView$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ImageView $iv;
            final /* synthetic */ com.tencent.mobileqq.emosm.favroaming.l $manager;
            final /* synthetic */ PicSize $picSize;
            final /* synthetic */ EmoticonFromGroupEntity $this_applyView;
            final /* synthetic */ int $type;
            final /* synthetic */ int $width;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.mobileqq.activity.emogroupstore.ExtensionsKt$applyView$1$1", f = "Extensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.mobileqq.activity.emogroupstore.ExtensionsKt$applyView$1$1, reason: invalid class name */
            /* loaded from: classes10.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                static IPatchRedirector $redirector_;
                final /* synthetic */ ImageView $iv;
                final /* synthetic */ com.tencent.mobileqq.emosm.favroaming.l $manager;
                final /* synthetic */ PicSize $picSize;
                final /* synthetic */ EmoticonFromGroupEntity $this_applyView;
                final /* synthetic */ int $type;
                final /* synthetic */ int $width;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(int i3, EmoticonFromGroupEntity emoticonFromGroupEntity, PicSize picSize, ImageView imageView, com.tencent.mobileqq.emosm.favroaming.l lVar, int i16, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$type = i3;
                    this.$this_applyView = emoticonFromGroupEntity;
                    this.$picSize = picSize;
                    this.$iv = imageView;
                    this.$manager = lVar;
                    this.$width = i16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), emoticonFromGroupEntity, picSize, imageView, lVar, Integer.valueOf(i16), continuation);
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                    }
                    return new AnonymousClass1(this.$type, this.$this_applyView, this.$picSize, this.$iv, this.$manager, this.$width, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                            ResultKt.throwOnFailure(obj);
                            if (this.$type == 1) {
                                EmoticonFromGroupEntity emoticonFromGroupEntity = this.$this_applyView;
                                ExtensionsKt.f(emoticonFromGroupEntity.thumbURL, null, new Function1<File, Unit>(this.$iv, this.$manager, emoticonFromGroupEntity, this.$width) { // from class: com.tencent.mobileqq.activity.emogroupstore.ExtensionsKt.applyView.1.1.1
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ ImageView $iv;
                                    final /* synthetic */ com.tencent.mobileqq.emosm.favroaming.l $manager;
                                    final /* synthetic */ EmoticonFromGroupEntity $this_applyView;
                                    final /* synthetic */ int $width;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                        this.$iv = r5;
                                        this.$manager = r6;
                                        this.$this_applyView = emoticonFromGroupEntity;
                                        this.$width = r8;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, this, r5, r6, emoticonFromGroupEntity, Integer.valueOf(r8));
                                        }
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(File file) {
                                        invoke2(file);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull File it) {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                                        } else {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            ExtensionsKt.j(this.$iv, this.$manager, this.$this_applyView, 65537, this.$width);
                                        }
                                    }
                                }, 2, null);
                            }
                            PicSize picSize = this.$picSize;
                            MsgRecord msgRecord = this.$this_applyView.msgRecord;
                            Intrinsics.checkNotNullExpressionValue(msgRecord, "msgRecord");
                            EmoticonFromGroupEntity emoticonFromGroupEntity2 = this.$this_applyView;
                            ExtensionsKt.d(picSize, msgRecord, emoticonFromGroupEntity2.msgElement, new Function1<FileTransNotifyInfo, Unit>(this.$type, emoticonFromGroupEntity2, this.$iv, this.$manager, this.$width) { // from class: com.tencent.mobileqq.activity.emogroupstore.ExtensionsKt.applyView.1.1.2
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ ImageView $iv;
                                final /* synthetic */ com.tencent.mobileqq.emosm.favroaming.l $manager;
                                final /* synthetic */ EmoticonFromGroupEntity $this_applyView;
                                final /* synthetic */ int $type;
                                final /* synthetic */ int $width;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                    this.$type = r5;
                                    this.$this_applyView = emoticonFromGroupEntity2;
                                    this.$iv = r7;
                                    this.$manager = r8;
                                    this.$width = r9;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, this, Integer.valueOf(r5), emoticonFromGroupEntity2, r7, r8, Integer.valueOf(r9));
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(FileTransNotifyInfo fileTransNotifyInfo) {
                                    invoke2(fileTransNotifyInfo);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull FileTransNotifyInfo it) {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                                        return;
                                    }
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    int i3 = this.$type;
                                    if (i3 == 1) {
                                        this.$this_applyView.bigURL = it.filePath;
                                    } else if (i3 == 65537) {
                                        this.$this_applyView.thumbURL = it.filePath;
                                    }
                                    ExtensionsKt.j(this.$iv, this.$manager, this.$this_applyView, i3, this.$width);
                                }
                            });
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$type = i3;
                this.$this_applyView = emoticonFromGroupEntity;
                this.$picSize = picSize;
                this.$iv = iv5;
                this.$manager = manager;
                this.$width = i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, CoroutineScope.this, Integer.valueOf(i3), emoticonFromGroupEntity, picSize, iv5, manager, Integer.valueOf(i16));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    CorountineFunKt.e(CoroutineScope.this, "EmoticonFromGroup_Fragment", null, null, null, new AnonymousClass1(this.$type, this.$this_applyView, this.$picSize, this.$iv, this.$manager, this.$width, null), 14, null);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, new Function1<File, Unit>(iv5, manager, emoticonFromGroupEntity, i3, i16) { // from class: com.tencent.mobileqq.activity.emogroupstore.ExtensionsKt$applyView$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ ImageView $iv;
            final /* synthetic */ com.tencent.mobileqq.emosm.favroaming.l $manager;
            final /* synthetic */ EmoticonFromGroupEntity $this_applyView;
            final /* synthetic */ int $type;
            final /* synthetic */ int $width;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$iv = iv5;
                this.$manager = manager;
                this.$this_applyView = emoticonFromGroupEntity;
                this.$type = i3;
                this.$width = i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, iv5, manager, emoticonFromGroupEntity, Integer.valueOf(i3), Integer.valueOf(i16));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(File file) {
                invoke2(file);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull File it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ExtensionsKt.j(this.$iv, this.$manager, this.$this_applyView, this.$type, this.$width);
                }
            }
        });
    }

    public static final void d(@NotNull PicSize size, @NotNull MsgRecord msgRecord, @Nullable MsgElement msgElement, @Nullable Function1<? super FileTransNotifyInfo, Unit> function1) {
        PicElement picElement;
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgElement != null && (picElement = msgElement.picElement) != null) {
            Intrinsics.checkNotNullExpressionValue(picElement, "msgElement.picElement");
            Pair<Integer, Integer> i3 = i(picElement, size);
            w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                RichMediaElementGetReq richMediaElementGetReq = new RichMediaElementGetReq();
                richMediaElementGetReq.msgId = msgRecord.msgId;
                richMediaElementGetReq.peerUid = msgRecord.peerUid;
                richMediaElementGetReq.chatType = msgRecord.chatType;
                richMediaElementGetReq.elementId = msgElement.elementId;
                richMediaElementGetReq.downloadType = i3.getFirst().intValue();
                richMediaElementGetReq.thumbSize = i3.getSecond().intValue();
                e16.getRichMediaElement(richMediaElementGetReq);
            }
            w e17 = com.tencent.qqnt.msg.f.e();
            if (e17 != null) {
                e17.addMsgListener(new b(msgElement, i3, function1));
            }
        }
    }

    public static final void e(@Nullable String str, @Nullable Function0<Unit> function0, @NotNull Function1<? super File, Unit> exit) {
        boolean z16;
        Intrinsics.checkNotNullParameter(exit, "exit");
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            exit.invoke(file);
        } else if (function0 != null) {
            function0.invoke();
        }
    }

    public static /* synthetic */ void f(String str, Function0 function0, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function0 = null;
        }
        e(str, function0, function1);
    }

    public static final int g(@NotNull PicElement picElement, @NotNull PicSize picSize) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        int i3 = a.f182063a[picSize.ordinal()];
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 == 3) {
            return g(picElement, b(picElement));
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int h(@NotNull PicElement picElement, @NotNull PicSize picSize) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        int i3 = a.f182063a[picSize.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return h(picElement, b(picElement));
                }
                throw new NoWhenBranchMatchedException();
            }
            return 198;
        }
        return 0;
    }

    @NotNull
    public static final Pair<Integer, Integer> i(@NotNull PicElement picElement, @NotNull PicSize size) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Intrinsics.checkNotNullParameter(size, "size");
        return new Pair<>(Integer.valueOf(g(picElement, size)), Integer.valueOf(h(picElement, size)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ImageView imageView, com.tencent.mobileqq.emosm.favroaming.l lVar, EmoticonFromGroupEntity emoticonFromGroupEntity, int i3, int i16) {
        Drawable j3 = lVar.j(emoticonFromGroupEntity, i3, i16, null);
        Intrinsics.checkNotNullExpressionValue(j3, "manager.getDrawableFromG\u2026ntity, type, width, null)");
        imageView.setImageDrawable(j3);
    }
}
