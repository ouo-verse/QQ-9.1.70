package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi;
import com.tencent.qqnt.aio.emoreply.AIOEmoReplySelectMsgEvent;
import com.tencent.qqnt.emotion.api.IAIOEmoticonApi;
import com.tencent.qqnt.emotion.emoreply.AIOEmoReplyDetailDialog;
import com.tencent.qqnt.emotion.emoreply.AIOEmoReplyDialog;
import com.tencent.qqnt.emotion.emoreply.EmoReplyUtils;
import com.tencent.qqnt.emotion.info.SystemAndEmojiEmotionInfo;
import com.tencent.qqnt.kernel.nativeinterface.ISetMsgEmojiLikesCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 12\u00020\u0001:\u000223B\u0007\u00a2\u0006\u0004\b/\u00100J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J2\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J*\u0010 \u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u000fH\u0016J\u0016\u0010\"\u001a\u00020\u00192\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J(\u0010%\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010$\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u000fH\u0016J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0006\u0010'\u001a\u00020\u0019R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOEmoReplyApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoReplyApi;", "", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", "filterSysData", "filterEmojiData", TtmlNode.ATTR_TTS_ORIGIN, "Lcom/tencent/mobileqq/emoticonview/SystemAndEmojiEmoticonInfo;", "convertNTEmotionInfo", "", "groupUin", "", "isEmoReplyOpen", "", "type", "", "localID", "isInEmoFilterList", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "emojiId", "emojiType", "bClicked", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetMsgEmojiLikesCallback;", "cb", "", "setEmojiLikes", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/aio/emoreply/j;", "callBack", "from", "showAIOEmoReplyPanel", "recentList", "updateRecentEmoticon", "Lcom/tencent/qqnt/aio/emoreply/f;", "detailData", "showAIOEmoReplyDetailPanel", "getEmoReplyFilterData", "dialogDismiss", "Lcom/tencent/qqnt/emotion/emoreply/AIOEmoReplyDialog;", "dialog", "Lcom/tencent/qqnt/emotion/emoreply/AIOEmoReplyDialog;", "getDialog", "()Lcom/tencent/qqnt/emotion/emoreply/AIOEmoReplyDialog;", "setDialog", "(Lcom/tencent/qqnt/emotion/emoreply/AIOEmoReplyDialog;)V", "<init>", "()V", "Companion", "a", "b", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOEmoReplyApiImpl implements IAIOEmoReplyApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String OPEN_SOURCE = "interact_tag_open_source";

    @NotNull
    public static final String TAG = "AIOEmoReplyApiImpl";

    @Nullable
    private AIOEmoReplyDialog dialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOEmoReplyApiImpl$a;", "", "", "OPEN_SOURCE", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.AIOEmoReplyApiImpl$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOEmoReplyApiImpl$b;", "Lcom/tencent/qqnt/aio/emoreply/j;", "", "emoticonType", EmojiManagerServiceConstant.PARAMS_EMOTICON_EID, "", "a", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(Lcom/tencent/qqnt/aio/adapter/api/impl/AIOEmoReplyApiImpl;Landroid/content/Context;Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public final class b implements com.tencent.qqnt.aio.emoreply.j {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MsgRecord msgRecord;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AIOEmoReplyApiImpl f348527c;

        public b(@NotNull AIOEmoReplyApiImpl aIOEmoReplyApiImpl, @NotNull Context context, MsgRecord msgRecord) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            this.f348527c = aIOEmoReplyApiImpl;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aIOEmoReplyApiImpl, context, msgRecord);
            } else {
                this.context = context;
                this.msgRecord = msgRecord;
            }
        }

        @Override // com.tencent.qqnt.aio.emoreply.j
        public void a(int emoticonType, int emoticonId) {
            FragmentActivity fragmentActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(emoticonType), Integer.valueOf(emoticonId));
                return;
            }
            int convertToLocal = ((IAIOEmoticonApi) QRoute.api(IAIOEmoticonApi.class)).convertToLocal(emoticonId, emoticonType);
            Context context = this.context;
            Unit unit = null;
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null) {
                com.tencent.qqnt.aio.utils.c.f352293a.a(fragmentActivity, new AIOEmoReplySelectMsgEvent(convertToLocal, emoticonType, this.msgRecord, null));
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                QLog.e(AIOEmoReplyApiImpl.TAG, 1, "context to FragmentActivity failed: " + this.context);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27965);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOEmoReplyApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final SystemAndEmojiEmoticonInfo convertNTEmotionInfo(EmotionPanelData origin) {
        if (origin instanceof SystemAndEmojiEmotionInfo) {
            SystemAndEmojiEmotionInfo systemAndEmojiEmotionInfo = (SystemAndEmojiEmotionInfo) origin;
            return new SystemAndEmojiEmoticonInfo(7, systemAndEmojiEmotionInfo.c(), systemAndEmojiEmotionInfo.getCode(), systemAndEmojiEmotionInfo.getTitle(), false);
        }
        return null;
    }

    private final List<EmotionPanelData> filterEmojiData() {
        ArrayList arrayList = new ArrayList();
        List<Integer> filterEmojiData = ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).getFilterEmojiData();
        if (filterEmojiData == null) {
            return arrayList;
        }
        for (Integer i3 : filterEmojiData) {
            Intrinsics.checkNotNullExpressionValue(i3, "i");
            arrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, i3.intValue(), "", false));
        }
        return arrayList;
    }

    private final List<EmotionPanelData> filterSysData() {
        ArrayList arrayList = new ArrayList();
        List<Integer> filterSysData = ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).getFilterSysData();
        if (filterSysData == null) {
            return arrayList;
        }
        for (Integer i3 : filterSysData) {
            Intrinsics.checkNotNullExpressionValue(i3, "i");
            arrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, i3.intValue(), "", false));
        }
        Iterator<Integer> it = EmoReplyUtils.f356241a.a().iterator();
        while (it.hasNext()) {
            Integer i16 = it.next();
            Intrinsics.checkNotNullExpressionValue(i16, "i");
            arrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, i16.intValue(), "", false));
        }
        return arrayList;
    }

    public final void dialogDismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "dialog dismiss");
        }
        this.dialog = null;
    }

    @Nullable
    public final AIOEmoReplyDialog getDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOEmoReplyDialog) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.dialog;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi
    @NotNull
    public List<EmotionPanelData> getEmoReplyFilterData() {
        List<EmotionPanelData> mutableList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) filterSysData());
            mutableList.addAll(filterEmojiData());
            return mutableList;
        }
        return (List) iPatchRedirector.redirect((short) 10, (Object) this);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi
    public boolean isEmoReplyOpen(long groupUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, groupUin)).booleanValue();
        }
        return com.tencent.qqnt.aio.emoReply.e.f349883a.b(groupUin);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi
    public boolean isInEmoFilterList(int type, @NotNull String localID) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, type, (Object) localID)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(localID, "localID");
        return ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).isInFilterList(type, localID);
    }

    public final void setDialog(@Nullable AIOEmoReplyDialog aIOEmoReplyDialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aIOEmoReplyDialog);
        } else {
            this.dialog = aIOEmoReplyDialog;
        }
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
        FragmentActivity fragmentActivity;
        FragmentTransaction beginTransaction;
        FragmentTransaction add;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, context, msgRecord, detailData, from);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(detailData, "detailData");
        Intrinsics.checkNotNullParameter(from, "from");
        QLog.d(TAG, 2, "showAIOEmoReplyDetailPanel msgRecord:" + msgRecord.msgSeq + " detailData:" + detailData);
        FragmentManager fragmentManager = null;
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            fragmentManager = fragmentActivity.getSupportFragmentManager();
        }
        AIOEmoReplyDetailDialog aIOEmoReplyDetailDialog = new AIOEmoReplyDetailDialog(context, msgRecord, detailData);
        if (fragmentManager != null && (beginTransaction = fragmentManager.beginTransaction()) != null && (add = beginTransaction.add(aIOEmoReplyDetailDialog, TAG)) != null) {
            add.commitAllowingStateLoss();
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi
    public void showAIOEmoReplyPanel(@NotNull Context context, @NotNull MsgRecord msgRecord, @Nullable com.tencent.qqnt.aio.emoreply.j callBack, @NotNull String from) {
        com.tencent.qqnt.aio.emoreply.j jVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, msgRecord, callBack, from);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(from, "from");
        QLog.d(TAG, 1, "showAIOEmoReplyPanel");
        int i3 = msgRecord.chatType;
        HashMap hashMap = new HashMap();
        hashMap.put(OPEN_SOURCE, from);
        hashMap.put("touin", Long.valueOf(msgRecord.senderUin));
        com.tencent.mobileqq.aio.utils.b.q("em_bas_aio_emoticon_response_panel", hashMap);
        List<SystemAndEmojiEmotionInfo> e16 = com.tencent.qqnt.aio.emoReply.c.f349875a.e(Integer.valueOf(i3));
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = e16.iterator();
        while (it.hasNext()) {
            SystemAndEmojiEmoticonInfo convertNTEmotionInfo = convertNTEmotionInfo((SystemAndEmojiEmotionInfo) it.next());
            if (convertNTEmotionInfo != null) {
                arrayList.add(convertNTEmotionInfo);
            }
        }
        QLog.d(TAG, 1, "convertedList size: " + arrayList.size());
        b bVar = new b(this, context, msgRecord);
        if (this.dialog == null) {
            if (callBack == null) {
                jVar = bVar;
            } else {
                jVar = callBack;
            }
            this.dialog = new AIOEmoReplyDialog(context, this, jVar, arrayList, hashMap);
            Unit unit = Unit.INSTANCE;
        }
        AIOEmoReplyDialog aIOEmoReplyDialog = this.dialog;
        if (aIOEmoReplyDialog != null) {
            aIOEmoReplyDialog.show();
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi
    public void updateRecentEmoticon(@NotNull List<? extends EmotionPanelData> recentList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) recentList);
            return;
        }
        Intrinsics.checkNotNullParameter(recentList, "recentList");
        AIOEmoReplyDialog aIOEmoReplyDialog = this.dialog;
        if (aIOEmoReplyDialog != null) {
            EmoReplyUtils emoReplyUtils = EmoReplyUtils.f356241a;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = recentList.iterator();
            while (it.hasNext()) {
                SystemAndEmojiEmoticonInfo convertNTEmotionInfo = convertNTEmotionInfo((EmotionPanelData) it.next());
                if (convertNTEmotionInfo != null) {
                    arrayList.add(convertNTEmotionInfo);
                }
            }
            aIOEmoReplyDialog.o0(emoReplyUtils.b(arrayList));
        }
    }
}
