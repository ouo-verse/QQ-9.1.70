package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.aio.data.AIOContact;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForVideoEmoticon;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emotionintegrate.r;
import com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
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
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class r {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected String f205267a;

    /* renamed from: b, reason: collision with root package name */
    protected int f205268b;

    /* renamed from: c, reason: collision with root package name */
    protected SessionInfo f205269c;

    /* renamed from: d, reason: collision with root package name */
    protected AIOContact f205270d;

    /* renamed from: e, reason: collision with root package name */
    private long f205271e;

    /* renamed from: f, reason: collision with root package name */
    private long f205272f;

    /* renamed from: g, reason: collision with root package name */
    private int f205273g;

    /* renamed from: h, reason: collision with root package name */
    private long f205274h;

    /* renamed from: i, reason: collision with root package name */
    private int f205275i;

    /* renamed from: j, reason: collision with root package name */
    protected QQAppInterface f205276j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a implements IKernelMsgListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private long f205277d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<URLDrawable> f205278e;

        public a(long j3, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), uRLDrawable);
            } else {
                this.f205277d = j3;
                this.f205278e = new WeakReference<>(uRLDrawable);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            URLDrawable uRLDrawable;
            WeakReference<URLDrawable> weakReference = this.f205278e;
            if (weakReference == null) {
                uRLDrawable = null;
            } else {
                uRLDrawable = weakReference.get();
            }
            if (uRLDrawable == null) {
                QLog.w("EmotionDataManager", 2, "[onRichMediaDownloadComplete] drawable is null.");
            } else {
                uRLDrawable.invalidateSelf();
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
        public void onRichMediaDownloadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) fileTransNotifyInfo);
                return;
            }
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[4];
                objArr[0] = "[onRichMediaDownloadComplete] msgId=";
                if (fileTransNotifyInfo != null) {
                    obj = Long.valueOf(fileTransNotifyInfo.getMsgId());
                } else {
                    obj = "null";
                }
                objArr[1] = obj;
                objArr[2] = ", rootMsgId=";
                objArr[3] = Long.valueOf(this.f205277d);
                QLog.d("EmotionDataManager", 2, objArr);
            }
            if (fileTransNotifyInfo != null && fileTransNotifyInfo.getMsgId() == this.f205277d) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emotionintegrate.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        r.a.this.b();
                    }
                });
                com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
                if (e16 == null) {
                    QLog.w("EmotionDataManager", 2, "[onRichMediaDownloadComplete] kernel msg service == null.");
                } else {
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

    public r(String str, int i3, AIOContact aIOContact) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), aIOContact);
            return;
        }
        this.f205271e = Long.MAX_VALUE;
        this.f205272f = Long.MAX_VALUE;
        this.f205273g = 3;
        this.f205274h = Long.MAX_VALUE;
        this.f205275i = 60;
        this.f205267a = str;
        this.f205268b = i3;
        this.f205270d = aIOContact;
        this.f205276j = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
    }

    public static Drawable a(Context context, s sVar) {
        URLDrawable fileDrawable;
        MessageRecord messageRecord = sVar.f205289a;
        URLDrawable uRLDrawable = null;
        if (messageRecord instanceof MessageForMarketFace) {
            IPicEmoticonInfo f16 = f((MessageForMarketFace) messageRecord);
            if (f16 != null) {
                uRLDrawable = f16.getLoadingDrawable(EmotionConstants.FROM_AIO, true);
            }
            sVar.f205292d = true;
            return uRLDrawable;
        }
        if (messageRecord instanceof MessageForPic) {
            MessageForPic messageForPic = (MessageForPic) messageRecord;
            String str = messageForPic.path;
            if (FileUtils.fileExists(str)) {
                int i3 = (int) messageForPic.width;
                int i16 = (int) messageForPic.height;
                if ((i3 == 0 || i16 == 0) && messageForPic.checkGif()) {
                    try {
                        com.tencent.mobileqq.activity.aio.stickerbubble.frame.c cVar = new com.tencent.mobileqq.activity.aio.stickerbubble.frame.c(new File(str), false);
                        int height = cVar.getHeight();
                        int width = cVar.getWidth();
                        i16 = height;
                        i3 = width;
                    } catch (IOException e16) {
                        QLog.e("EmotionDataManager", 1, "MessageForPic file: " + e16);
                        return null;
                    } catch (OutOfMemoryError e17) {
                        QLog.e("EmotionDataManager", 1, "MessageForPic file: " + e17);
                        return null;
                    }
                }
                fileDrawable = URLDrawable.getFileDrawable(str, b(context, messageForPic, i3, i16));
                sVar.f205292d = true;
            } else {
                if (messageRecord.istroop == 10014) {
                    fileDrawable = URLDrawable.getDrawable(com.tencent.mobileqq.activity.aio.item.i.c(messageForPic), b(context, messageForPic, ((IGuildPicAIO) QRoute.api(IGuildPicAIO.class)).getThumbMinDp(true)[0], ((IGuildPicAIO) QRoute.api(IGuildPicAIO.class)).getThumbMinDp(true)[1]));
                } else {
                    String b16 = aj.b(messageForPic.getPicElement(), 198);
                    if (TextUtils.isEmpty(b16)) {
                        QLog.e("EmotionDataManager", 1, "init view, empty thumb file path:", messageForPic.md5);
                        return null;
                    }
                    fileDrawable = URLDrawable.getFileDrawable(b16, b(context, messageForPic, messageForPic.thumbWidth, messageForPic.thumbHeight));
                    if (!FileUtils.fileExists(b16)) {
                        com.tencent.qqnt.kernel.api.w e18 = com.tencent.qqnt.msg.f.e();
                        if (e18 == null) {
                            QLog.e("EmotionDataManager", 1, "init view error, kernelMsgService is null!");
                            return null;
                        }
                        if (TextUtils.isEmpty(messageForPic.getNTRootPeerUid())) {
                            QLog.e("EmotionDataManager", 1, "init view error, getNTPeerUid is null!");
                            return null;
                        }
                        e18.addMsgListener(new a(messageForPic.getNTRootMsgId(), fileDrawable));
                        e18.getRichMediaElement(new RichMediaElementGetReq(messageForPic.getNTRootMsgId(), messageForPic.getNTRootPeerUid(), messageForPic.getNTRootChatType(), messageForPic.subTypeId, 1, 0, "", 0L, 2, 0));
                        if (QLog.isColorLevel()) {
                            QLog.d("EmotionDataManager", 2, "init view, thumb pic not exist:", b16);
                        }
                    }
                }
                sVar.f205292d = false;
                if (QLog.isColorLevel()) {
                    QLog.d("EmotionDataManager", 2, "init view,big pic not exist:", str);
                }
            }
            return fileDrawable;
        }
        if (!(messageRecord instanceof MessageForVideoEmoticon)) {
            return null;
        }
        String l3 = com.tencent.mobileqq.shortvideo.j.l(((MessageForVideoEmoticon) messageRecord).thumbMD5, "gif");
        if (!new File(l3).exists()) {
            l3 = com.tencent.mobileqq.shortvideo.j.l(((MessageForVideoEmoticon) sVar.f205289a).thumbMD5, "jpg");
            if (!new File(l3).exists()) {
                l3 = "";
            }
        }
        if (!TextUtils.isEmpty(l3)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mPlayGifImage = true;
            URLDrawable fileDrawable2 = URLDrawable.getFileDrawable(l3, obtain);
            sVar.f205294f = true;
            return fileDrawable2;
        }
        sVar.f205294f = false;
        if (!QLog.isColorLevel()) {
            return null;
        }
        QLog.d("EmotionDataManager", 2, "video emotion thumb is not exist:");
        return null;
    }

    private static URLDrawable.URLDrawableOptions b(Context context, MessageForPic messageForPic, int i3, int i16) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        obtain.mMemoryCacheKeySuffix = "AIOEmotionFragment";
        if (((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("emotion_preview_double_buffer")) {
            obtain.mRequestWidth = 512;
            obtain.mRequestHeight = 512;
        } else {
            obtain.mRequestWidth = context.getResources().getDisplayMetrics().widthPixels;
            obtain.mRequestHeight = context.getResources().getDisplayMetrics().heightPixels;
        }
        obtain.mLoadingDrawable = new com.tencent.mobileqq.drawable.b(i3, i16);
        obtain.mGifRefreshDelay = com.tencent.mobileqq.emosm.e.v();
        return obtain;
    }

    public static EmoticonPackage c(String str) {
        return ((IEmoticonManagerService) ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(str);
    }

    public static IPicEmoticonInfo f(MessageForMarketFace messageForMarketFace) {
        return (IPicEmoticonInfo) ((IEmoticonManagerService) ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getRuntimeService(IEmoticonManagerService.class)).syncGetEmoticonInfo(messageForMarketFace.mMarkFaceMessage);
    }

    public List<MessageRecord> d(String str, int i3, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3));
        }
        try {
            if (str.equals(this.f205267a) && this.f205268b == i3) {
                if (this.f205270d == null) {
                    QLog.e("EmotionDataManager", 1, "getEmotionDataIncremental failed, mNTAIOContact is null!");
                    return null;
                }
                return this.f205276j.getMessageProxy(i3).a0(str, i3, this.f205270d.j(), this.f205270d.e(), 60);
            }
            return null;
        } catch (OutOfMemoryError e16) {
            QLog.e("EmotionDataManager", 2, "out of memory", e16);
            return null;
        }
    }

    public List<MessageRecord> e(String str, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
        if (z17) {
            return new ArrayList();
        }
        return d(str, i3, z16, -1L);
    }

    public r(SessionInfo sessionInfo, String str, int i3, AIOContact aIOContact) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, sessionInfo, str, Integer.valueOf(i3), aIOContact);
            return;
        }
        this.f205271e = Long.MAX_VALUE;
        this.f205272f = Long.MAX_VALUE;
        this.f205273g = 3;
        this.f205274h = Long.MAX_VALUE;
        this.f205275i = 60;
        this.f205269c = sessionInfo;
        this.f205267a = str;
        this.f205268b = i3;
        this.f205270d = aIOContact;
        this.f205276j = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
    }
}
