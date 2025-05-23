package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.guild.aio.util.ui.GuildChatPicDownloader;
import com.tencent.guild.aio.util.ui.PicSize;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.history.BatchSaveEmoFavTask;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.marketface.IMarketFaceTailConfigExt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOEmotionAddApi;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiMall;
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
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
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
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.MsgExtKt;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J0\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J+\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J)\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOEmotionAddApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOEmotionAddApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "handleFavEmoForPicMsg", "", "isSwitchOn", "", "path", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "downloadAndAddFavEmoticon", "handleFavEmoForMarketFaceMsg", "checkPicSourceExists", "sourcePath", "", "jumpId", "addFavEmoticonAndNotify", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;)V", "addEmotion", "", "getPicElementSourcePath", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOEmotionAddApiImpl implements IAIOEmotionAddApi {
    public static final String TAG = "AIOExpressionAddApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public final void addFavEmoticonAndNotify(Context context, String sourcePath, Integer jumpId) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        PicMessageExtraData picMessageExtraData = null;
        if (jumpId != null) {
            Integer num = jumpId.intValue() > 0 ? jumpId : null;
            if (num != null) {
                int intValue = num.intValue();
                PicMessageExtraData picMessageExtraData2 = new PicMessageExtraData();
                picMessageExtraData2.jumpId = intValue;
                picMessageExtraData = picMessageExtraData2;
            }
        }
        QLog.i(TAG, 1, "addFavEmoticonAndNotify() ----- jumpId:" + jumpId);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        com.tencent.mobileqq.activity.aio.photo.c.b(context, sourcePath, (QQAppInterface) peekAppRuntime, dimensionPixelSize, picMessageExtraData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkPicSourceExists(String path) {
        return new File(path).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadAndAddFavEmoticon$lambda$1(AIOMsgItem msgItem, MsgElement msgElement, AIOEmotionAddApiImpl this$0, String path, Context context, PicElement picElement) {
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(msgElement, "$msgElement");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(picElement, "$picElement");
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.addMsgListener(new b(msgItem, msgElement, this$0, path, context, picElement));
        }
        RichMediaElementGetReq richMediaElementGetReq = new RichMediaElementGetReq();
        richMediaElementGetReq.msgId = msgItem.getMsgRecord().msgId;
        richMediaElementGetReq.peerUid = msgItem.getMsgRecord().peerUid;
        richMediaElementGetReq.chatType = msgItem.getMsgRecord().chatType;
        richMediaElementGetReq.elementId = msgElement.elementId;
        richMediaElementGetReq.downloadType = 2;
        richMediaElementGetReq.thumbSize = 720;
        richMediaElementGetReq.downSourceType = 1;
        richMediaElementGetReq.triggerType = 0;
        com.tencent.qqnt.kernel.api.w e17 = com.tencent.qqnt.msg.f.e();
        if (e17 != null) {
            e17.getRichMediaElement(richMediaElementGetReq);
        }
    }

    private final void handleFavEmoForPicMsg(Context context, AIOMsgItem msgItem) {
        String picElementSourcePath = getPicElementSourcePath(msgItem);
        MsgElement firstTypeElement = msgItem.getFirstTypeElement(2);
        PicElement picElement = firstTypeElement != null ? firstTypeElement.picElement : null;
        if (picElement == null) {
            return;
        }
        QLog.i(TAG, 1, "handleFavEmoForPicMsg path=" + picElementSourcePath);
        if (checkPicSourceExists(picElementSourcePath)) {
            QLog.i(TAG, 1, "handleFavEmoForPicMsg thumb path, path:" + picElementSourcePath);
            EmojiMall emojiMall = picElement.emojiMall;
            addFavEmoticonAndNotify(context, picElementSourcePath, emojiMall != null ? Integer.valueOf(emojiMall.getPackageId()) : null);
            return;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("add_to_fav_122160503", true);
        QLog.d(TAG, 1, "add_to_fav_122160503:" + isSwitchOn);
        if (isSwitchOn) {
            picElementSourcePath = com.tencent.mobileqq.aio.utils.aj.a(picElement);
            if (picElementSourcePath == null) {
                picElementSourcePath = "";
            }
            if (checkPicSourceExists(picElementSourcePath)) {
                QLog.i(TAG, 1, "handleFavEmoForPicMsg origin path, path:" + picElementSourcePath);
                EmojiMall emojiMall2 = picElement.emojiMall;
                addFavEmoticonAndNotify(context, picElementSourcePath, emojiMall2 != null ? Integer.valueOf(emojiMall2.getPackageId()) : null);
                return;
            }
        }
        downloadAndAddFavEmoticon(isSwitchOn, msgItem, picElementSourcePath, context, picElement);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmotionAddApi
    public void addEmotion(Context context, AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (com.tencent.mobileqq.aio.utils.d.L(msgItem)) {
            handleFavEmoForPicMsg(context, msgItem);
            return;
        }
        if (msgItem.getMsgRecord().msgType == 17) {
            handleFavEmoForMarketFaceMsg(context, msgItem);
            return;
        }
        QLog.e(TAG, 1, "unknown type: " + msgItem.getMsgRecord().msgType);
    }

    public final String getPicElementSourcePath(AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!com.tencent.mobileqq.aio.utils.d.L(msgItem)) {
            QLog.i(TAG, 1, "getPicElementSourcePath msgItem isn't PicMsg");
            return "";
        }
        MsgElement firstTypeElement = msgItem.getFirstTypeElement(2);
        PicElement picElement = firstTypeElement != null ? firstTypeElement.picElement : null;
        if (picElement == null) {
            QLog.i(TAG, 1, "getPicElementSourcePath picElement is null!");
            return "";
        }
        if (MsgExtKt.u(picElement)) {
            String a16 = com.tencent.mobileqq.aio.utils.aj.a(picElement);
            return a16 == null ? "" : a16;
        }
        String b16 = com.tencent.mobileqq.aio.utils.aj.b(picElement, 720);
        return b16 == null ? "" : b16;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/AIOEmotionAddApiImpl$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "", "onRichMediaDownloadComplete", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements IKernelMsgListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AIOMsgItem f348531d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MsgElement f348532e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AIOEmotionAddApiImpl f348533f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f348534h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f348535i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ PicElement f348536m;

        b(AIOMsgItem aIOMsgItem, MsgElement msgElement, AIOEmotionAddApiImpl aIOEmotionAddApiImpl, String str, Context context, PicElement picElement) {
            this.f348531d = aIOMsgItem;
            this.f348532e = msgElement;
            this.f348533f = aIOEmotionAddApiImpl;
            this.f348534h = str;
            this.f348535i = context;
            this.f348536m = picElement;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
            com.tencent.qqnt.kernel.nativeinterface.ax.a(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onContactUnreadCntUpdate(HashMap hashMap) {
            com.tencent.qqnt.kernel.nativeinterface.ax.b(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig) {
            com.tencent.qqnt.kernel.nativeinterface.ax.c(this, customWithdrawConfig);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onDraftUpdate(Contact contact, ArrayList arrayList, long j3) {
            com.tencent.qqnt.kernel.nativeinterface.ax.d(this, contact, arrayList, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiDownloadComplete(EmojiNotifyInfo emojiNotifyInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.e(this, emojiNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.f(this, emojiResourceInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onFileMsgCome(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.g(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGrabPasswordRedBag(int i3, String str, int i16, RecvdOrder recvdOrder, MsgRecord msgRecord) {
            com.tencent.qqnt.kernel.nativeinterface.ax.h(this, i3, str, i16, recvdOrder, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoAdd(GroupItem groupItem) {
            com.tencent.qqnt.kernel.nativeinterface.ax.i(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoUpdate(GroupFileListResult groupFileListResult) {
            com.tencent.qqnt.kernel.nativeinterface.ax.j(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoAdd(GroupItem groupItem) {
            com.tencent.qqnt.kernel.nativeinterface.ax.k(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoUpdate(GroupFileListResult groupFileListResult) {
            com.tencent.qqnt.kernel.nativeinterface.ax.l(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitCsRelatedEmojiResult(DownloadRelateEmojiResultInfo downloadRelateEmojiResultInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.m(this, downloadRelateEmojiResultInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitEmojiKeywordResult(HitRelatedEmojiWordsResult hitRelatedEmojiWordsResult) {
            com.tencent.qqnt.kernel.nativeinterface.ax.n(this, hitRelatedEmojiWordsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitRelatedEmojiResult(RelatedWordEmojiInfo relatedWordEmojiInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.o(this, relatedWordEmojiInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onImportOldDbProgressUpdate(ImportOldDbMsgNotifyInfo importOldDbMsgNotifyInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.p(this, importOldDbMsgNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onInputStatusPush(InputStatusInfo inputStatusInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.q(this, inputStatusInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onKickedOffLine(KickedInfo kickedInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.r(this, kickedInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLineDev(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.s(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLogLevelChanged(long j3) {
            com.tencent.qqnt.kernel.nativeinterface.ax.t(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMiscDataChanged(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.u(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgBoxChanged(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.v(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgDelete(Contact contact, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.w(this, contact, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListAdd(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListUpdate(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.y(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgQRCodeStatusChanged(int i3) {
            com.tencent.qqnt.kernel.nativeinterface.ax.z(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgRecall(int i3, String str, long j3) {
            com.tencent.qqnt.kernel.nativeinterface.ax.A(this, i3, str, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSecurityNotify(MsgRecord msgRecord) {
            com.tencent.qqnt.kernel.nativeinterface.ax.B(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSettingUpdate(MsgSetting msgSetting) {
            com.tencent.qqnt.kernel.nativeinterface.ax.C(this, msgSetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgWithRichLinkInfoUpdate(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.D(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtFirstViewMsgSyncEnd() {
            com.tencent.qqnt.kernel.nativeinterface.ax.E(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncContactUnread() {
            com.tencent.qqnt.kernel.nativeinterface.ax.F(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncEnd() {
            com.tencent.qqnt.kernel.nativeinterface.ax.G(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncStart() {
            com.tencent.qqnt.kernel.nativeinterface.ax.H(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsg(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.I(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsgSvrRspTransInfo(long j3, Contact contact, int i3, int i16, String str, byte[] bArr) {
            com.tencent.qqnt.kernel.nativeinterface.ax.J(this, j3, contact, i3, i16, str, bArr);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.K(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvSysMsg(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.L(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRedTouchChanged() {
            com.tencent.qqnt.kernel.nativeinterface.ax.M(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaProgerssUpdate(FileTransNotifyInfo fileTransNotifyInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.O(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaUploadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.P(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
            com.tencent.qqnt.kernel.nativeinterface.ax.Q(this, searchGroupFileResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSendMsgError(long j3, Contact contact, int i3, String str) {
            com.tencent.qqnt.kernel.nativeinterface.ax.R(this, j3, contact, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSysMsgNotification(int i3, long j3, long j16, boolean z16, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.S(this, i3, j3, j16, z16, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onTempChatInfoUpdate(TempChatInfo tempChatInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.T(this, tempChatInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserChannelTabStatusChanged(boolean z16) {
            com.tencent.qqnt.kernel.nativeinterface.ax.U(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserOnlineStatusChanged(boolean z16) {
            com.tencent.qqnt.kernel.nativeinterface.ax.V(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserSecQualityChanged(QueryUserSecQualityRsp queryUserSecQualityRsp) {
            com.tencent.qqnt.kernel.nativeinterface.ax.W(this, queryUserSecQualityRsp);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserTabStatusChanged(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.X(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusBigIconDownloadPush(int i3, long j3, String str) {
            com.tencent.qqnt.kernel.nativeinterface.ax.Y(this, i3, j3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusSmallIconDownloadPush(int i3, long j3, String str) {
            com.tencent.qqnt.kernel.nativeinterface.ax.Z(this, i3, j3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaDownloadComplete(FileTransNotifyInfo notifyInfo) {
            if (notifyInfo != null && this.f348531d.getMsgId() == notifyInfo.msgId && this.f348532e.elementId == notifyInfo.msgElementId) {
                QLog.i(AIOEmotionAddApiImpl.TAG, 1, "downloadAndAddFavEmoticon result:" + notifyInfo.fileErrCode + " thumbSize:" + notifyInfo.thumbSize + " sourceExist=" + this.f348533f.checkPicSourceExists(this.f348534h));
                com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
                if (e16 != null) {
                    e16.removeMsgListener(this);
                }
                AIOEmotionAddApiImpl aIOEmotionAddApiImpl = this.f348533f;
                Context context = this.f348535i;
                String str = notifyInfo.filePath;
                Intrinsics.checkNotNullExpressionValue(str, "notifyInfo.filePath");
                EmojiMall emojiMall = this.f348536m.emojiMall;
                aIOEmotionAddApiImpl.addFavEmoticonAndNotify(context, str, emojiMall != null ? Integer.valueOf(emojiMall.getPackageId()) : null);
            }
        }
    }

    private final void downloadAndAddFavEmoticon(boolean isSwitchOn, final AIOMsgItem msgItem, final String path, final Context context, final PicElement picElement) {
        PicSize picSize;
        QLog.i(TAG, 1, "downloadAndAddFavEmoticon");
        final MsgElement firstTypeElement = msgItem.getFirstTypeElement(2);
        if (firstTypeElement == null) {
            return;
        }
        if (isSwitchOn) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.g
                @Override // java.lang.Runnable
                public final void run() {
                    AIOEmotionAddApiImpl.downloadAndAddFavEmoticon$lambda$1(AIOMsgItem.this, firstTypeElement, this, path, context, picElement);
                }
            }, 16, null, false);
            return;
        }
        if (MsgExtKt.u(picElement)) {
            picSize = PicSize.PIC_DOWNLOAD_ORI;
        } else {
            picSize = PicSize.PIC_DOWNLOAD_AIO;
        }
        GuildChatPicDownloader.f112420a.h(picSize, msgItem.getMsgRecord(), new Function1<FileTransNotifyInfo, Unit>() { // from class: com.tencent.qqnt.aio.adapter.api.impl.AIOEmotionAddApiImpl$downloadAndAddFavEmoticon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FileTransNotifyInfo fileTransNotifyInfo) {
                invoke2(fileTransNotifyInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FileTransNotifyInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                QLog.i(AIOEmotionAddApiImpl.TAG, 1, "downloadAndAddFavEmoticon result:" + it.fileErrCode + " thumbSize:" + it.thumbSize + " sourceExist=" + AIOEmotionAddApiImpl.this.checkPicSourceExists(path));
                if (it.thumbSize != 0) {
                    AIOEmotionAddApiImpl aIOEmotionAddApiImpl = AIOEmotionAddApiImpl.this;
                    Context context2 = context;
                    String str = it.filePath;
                    Intrinsics.checkNotNullExpressionValue(str, "it.filePath");
                    EmojiMall emojiMall = picElement.emojiMall;
                    aIOEmotionAddApiImpl.addFavEmoticonAndNotify(context2, str, emojiMall != null ? Integer.valueOf(emojiMall.getPackageId()) : null);
                }
            }
        });
    }

    private final void handleFavEmoForMarketFaceMsg(Context context, AIOMsgItem msgItem) {
        LifecycleCoroutineScope lifecycleScope;
        Job launch$default;
        MsgElement firstTypeElement = msgItem.getFirstTypeElement(11);
        MarketFaceElement marketFaceElement = firstTypeElement != null ? firstTypeElement.marketFaceElement : null;
        if (marketFaceElement == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("touin", msgItem.getMsgRecord().peerUin);
        jSONObject.put("emoji_id", marketFaceElement.emojiPackageId);
        ((IMarketFaceTailConfigExt) QRoute.api(IMarketFaceTailConfigExt.class)).reportAction(QCircleDaTongConstant.ElementParamValue.LONG_PRESS, "save", "4", 102, jSONObject.toString());
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(fragmentActivity)) != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new AIOEmotionAddApiImpl$handleFavEmoForMarketFaceMsg$1(context, marketFaceElement, null), 3, null);
            if (launch$default != null) {
                return;
            }
        }
        QLog.i(TAG, 1, "handleFavEmoForMarketFaceMsg error can't get lifecycleScope");
        Unit unit = Unit.INSTANCE;
    }

    static /* synthetic */ void addFavEmoticonAndNotify$default(AIOEmotionAddApiImpl aIOEmotionAddApiImpl, Context context, String str, Integer num, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        aIOEmotionAddApiImpl.addFavEmoticonAndNotify(context, str, num);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmotionAddApi
    public void addEmotion(Context context, String path, Integer jumpId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        QLog.i(TAG, 1, "handleFavEmoForPicMsg path=" + path + ", jumpId=" + jumpId);
        if (checkPicSourceExists(path)) {
            QLog.i(TAG, 1, "handleFavEmoForPicMsg====addFav");
            addFavEmoticonAndNotify(context, path, jumpId);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmotionAddApi
    public void addEmotion(Context context, List<? extends AIOMsgItem> msgItem) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        QLog.i(TAG, 1, "addEmotion size=" + msgItem.size());
        new BatchSaveEmoFavTask().j(context, msgItem);
    }
}
