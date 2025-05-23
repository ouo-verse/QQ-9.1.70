package com.tencent.mobileqq.guild.emoj;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback;
import com.tencent.mobileqq.emotionintegrate.EmotionGallery;
import com.tencent.mobileqq.emotionintegrate.aa;
import com.tencent.mobileqq.emotionintegrate.p;
import com.tencent.mobileqq.emotionintegrate.r;
import com.tencent.mobileqq.emotionintegrate.x;
import com.tencent.mobileqq.emotionintegrate.y;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0001'B'\b\u0016\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b$\u0010%J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0012\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016J0\u0010\u001c\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016R\u0014\u0010\u001f\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/emoj/GuildEmotionPreviewDateSource;", "Lcom/tencent/mobileqq/emotionintegrate/aa;", "", "Lcom/tencent/mobileqq/emotionintegrate/p;", "dataList", "", "r", "", "path", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "sessionInfo", "Lcom/tencent/aio/data/AIOContact;", "ntAIOContact", "Lcom/tencent/mobileqq/emotionintegrate/r;", h.F, "forceUpdate", "", "c", "data", "g", "Lcom/tencent/mobileqq/emotionintegrate/EmotionGallery;", "gallery", "Landroid/os/Handler;", "handler", "Lcom/tencent/mobileqq/emotionintegrate/EmotionDownGIFCallback$a;", "uiCallback", "o", UserInfo.SEX_FEMALE, "Landroid/os/Handler;", "mainThreadHandler", "Landroid/content/Intent;", "intent", "Lcom/tencent/mobileqq/emotionintegrate/y;", "curData", "<init>", "(Landroid/content/Intent;Lcom/tencent/mobileqq/emotionintegrate/y;Lcom/tencent/mobileqq/activity/aio/SessionInfo;)V", "G", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildEmotionPreviewDateSource extends aa {

    /* renamed from: F, reason: from kotlin metadata */
    private final Handler mainThreadHandler;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/emoj/GuildEmotionPreviewDateSource$b", "Lqr0/f;", "", "getMsgId", "b", "getMsgSeq", "a", "", "getSenderUin", "getPeerUin", "getGuildID", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "c", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements qr0.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MessageForPic f217861a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildEmotionPreviewDateSource f217862b;

        b(MessageForPic messageForPic, GuildEmotionPreviewDateSource guildEmotionPreviewDateSource) {
            this.f217861a = messageForPic;
            this.f217862b = guildEmotionPreviewDateSource;
        }

        @Override // qr0.f
        public long a() {
            return this.f217861a.time;
        }

        @Override // qr0.f
        public long b() {
            return this.f217861a.msgUid;
        }

        @Override // qr0.f
        public MsgElement c() {
            Object obj = this.f217861a.extObj;
            MsgElement msgElement = obj instanceof MsgElement ? (MsgElement) obj : null;
            return msgElement == null ? new MsgElement() : msgElement;
        }

        @Override // qr0.f
        public String getGuildID() {
            String str = this.f217862b.f205191f.f179559f;
            Intrinsics.checkNotNullExpressionValue(str, "mSessionInfo.troopUin");
            return str;
        }

        @Override // qr0.f
        public long getMsgId() {
            return this.f217861a.uniseq;
        }

        @Override // qr0.f
        public long getMsgSeq() {
            return this.f217861a.shmsgseq;
        }

        @Override // qr0.f
        public String getPeerUin() {
            String str = this.f217862b.f205191f.f179557e;
            Intrinsics.checkNotNullExpressionValue(str, "mSessionInfo.curFriendUin");
            return str;
        }

        @Override // qr0.f
        public String getSenderUin() {
            String str = this.f217861a.senderuin;
            Intrinsics.checkNotNullExpressionValue(str, "picMessage.senderuin");
            return str;
        }
    }

    public GuildEmotionPreviewDateSource(Intent intent, y yVar, SessionInfo sessionInfo) {
        super(intent, yVar, sessionInfo);
        this.mainThreadHandler = new Handler(Looper.getMainLooper());
    }

    private final void r(List<p> dataList) {
        int size = dataList.size() - 1;
        int i3 = 0;
        int i16 = 0;
        for (Object obj : dataList) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            p pVar = (p) obj;
            if (this.f205190e.uniseq > pVar.k()) {
                size = i16;
            } else if (this.f205190e.uniseq == pVar.k()) {
                QLog.i("GuildEmotionPreviewDateSource", 1, "checkAndAddClickedData==contain");
                return;
            }
            i16 = i17;
        }
        QLog.i("GuildEmotionPreviewDateSource", 1, "checkAndAddClickedData insertIndex=" + size);
        if (size >= 0) {
            i3 = size > dataList.size() ? dataList.size() : size;
        }
        dataList.add(i3, new e(this.f205190e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s(String path) {
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return new File(path).exists();
    }

    @Override // com.tencent.mobileqq.emotionintegrate.aa, com.tencent.mobileqq.emotionintegrate.EmotionDataSource
    public List<p> c(boolean forceUpdate) {
        r rVar = this.f205189d;
        Intrinsics.checkNotNull(rVar, "null cannot be cast to non-null type com.tencent.mobileqq.emotionintegrate.GuildEmotionDataManager");
        SessionInfo sessionInfo = this.f205191f;
        List<MessageRecord> dataList = ((x) rVar).g(sessionInfo.f179559f, sessionInfo.f179557e, sessionInfo.f179555d);
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
        Iterator<T> it = dataList.iterator();
        while (it.hasNext()) {
            arrayList.add(new e((MessageRecord) it.next()));
        }
        r(arrayList);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.aa
    public boolean g(p data) {
        if (!(data instanceof y)) {
            return true;
        }
        MessageRecord messageRecord = ((y) data).f205303a;
        if (!(messageRecord instanceof MessageForPic)) {
            return false;
        }
        String sourcePath = ((MessageForPic) messageRecord).path;
        QLog.i("GuildEmotionPreviewDateSource", 1, "checkMsgPicReady sourcePath=" + sourcePath);
        Intrinsics.checkNotNullExpressionValue(sourcePath, "sourcePath");
        return s(sourcePath);
    }

    @Override // com.tencent.mobileqq.emotionintegrate.aa
    protected r h(SessionInfo sessionInfo, AIOContact ntAIOContact) {
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        return new x(sessionInfo, sessionInfo.f179557e, sessionInfo.f179555d);
    }

    @Override // com.tencent.mobileqq.emotionintegrate.aa
    public void o(EmotionGallery gallery, Handler handler, p data, EmotionDownGIFCallback.a uiCallback) {
        e eVar = data instanceof e ? (e) data : null;
        MessageRecord messageRecord = eVar != null ? eVar.f205303a : null;
        MessageForPic messageForPic = messageRecord instanceof MessageForPic ? (MessageForPic) messageRecord : null;
        QLog.i("GuildEmotionPreviewDateSource", 1, "triggerDownloadPic info=" + (messageForPic != null ? messageForPic.toLogString() : null));
        if (messageForPic != null) {
            qr0.b.f429339a.c(new b(messageForPic, this), messageForPic.subTypeId, new GuildEmotionPreviewDateSource$triggerDownloadPic$1(this, messageForPic, uiCallback));
        }
    }
}
