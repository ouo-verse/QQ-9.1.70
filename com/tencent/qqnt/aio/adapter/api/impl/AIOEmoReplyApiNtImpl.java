package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi;
import com.tencent.qqnt.kernel.nativeinterface.ISetMsgEmojiLikesCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J*\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0016\u0010\u0017\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J2\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J(\u0010 \u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOEmoReplyApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoReplyApi;", "", "type", "", "localID", "", "isInEmoFilterList", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/aio/emoreply/j;", "callBack", "from", "", "showAIOEmoReplyPanel", "", "groupUin", "isEmoReplyOpen", "", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", "recentList", "updateRecentEmoticon", "emojiId", "emojiType", "bClicked", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetMsgEmojiLikesCallback;", "cb", "setEmojiLikes", "Lcom/tencent/qqnt/aio/emoreply/f;", "detailData", "showAIOEmoReplyDetailPanel", "getEmoReplyFilterData", "<init>", "()V", "Companion", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOEmoReplyApiNtImpl implements IAIOEmoReplyApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "AIOEmoReplyApiNtImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOEmoReplyApiNtImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.AIOEmoReplyApiNtImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30586);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOEmoReplyApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi
    @NotNull
    public List<EmotionPanelData> getEmoReplyFilterData() {
        List<EmotionPanelData> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi
    public boolean isEmoReplyOpen(long groupUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, groupUin)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi
    public boolean isInEmoFilterList(int type, @NotNull String localID) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, type, (Object) localID)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(localID, "localID");
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi
    public void setEmojiLikes(@NotNull MsgRecord msgRecord, @NotNull String emojiId, int emojiType, boolean bClicked, @Nullable ISetMsgEmojiLikesCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, msgRecord, emojiId, Integer.valueOf(emojiType), Boolean.valueOf(bClicked), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(emojiId, "emojiId");
        ((IMsgService) QRoute.api(IMsgService.class)).setMsgEmojiLikes(new Contact(msgRecord.chatType, msgRecord.peerUid, ""), msgRecord.msgSeq, emojiId, emojiType, bClicked, cb5);
        QLog.d(TAG, 2, "setEmojiLikes: msg:" + msgRecord.msgSeq + " emojiId:" + emojiId + " emojiType:" + emojiType + " clicked:" + bClicked);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi
    public void showAIOEmoReplyDetailPanel(@NotNull Context context, @NotNull MsgRecord msgRecord, @NotNull com.tencent.qqnt.aio.emoreply.f detailData, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, msgRecord, detailData, from);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(detailData, "detailData");
        Intrinsics.checkNotNullParameter(from, "from");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi
    public void showAIOEmoReplyPanel(@NotNull Context context, @NotNull MsgRecord msgRecord, @Nullable com.tencent.qqnt.aio.emoreply.j callBack, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, msgRecord, callBack, from);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(from, "from");
        Toast.makeText(context, "\u6253\u5f00\u8868\u60c5\u8868\u6001\u9762\u677f", 0).show();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi
    public void updateRecentEmoticon(@NotNull List<? extends EmotionPanelData> recentList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) recentList);
        } else {
            Intrinsics.checkNotNullParameter(recentList, "recentList");
        }
    }
}
