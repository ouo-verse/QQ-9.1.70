package com.tencent.mobileqq.channel.node;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.data.converter.c;
import com.tencent.qqnt.chats.data.converter.f;
import com.tencent.qqnt.chats.data.converter.g;
import com.tencent.qqnt.chats.data.converter.m;
import com.tencent.qqnt.kernel.nativeinterface.GuildContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCnt;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import ex3.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/channel/node/ChannelUnreadConvertProcessor;", "Lcom/tencent/qqnt/chats/data/converter/g;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "handleVoiceChannelUnread", "handleLiveChannelUnread", "handleDefaultChannelUnread", "", "channelUnreadType", "convertToRecentUnreadType", "Lcom/tencent/qqnt/chats/data/converter/f;", "payload", "", "matchPayload", "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "update", "<init>", "()V", "Companion", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ChannelUnreadConvertProcessor extends g {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final long LIVE_CHANNEL_UNREAD_CNT = 0;

    @NotNull
    public static final String TAG = "ChannelUnreadConvertProcessor";

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/channel/node/ChannelUnreadConvertProcessor$Companion;", "", "()V", "LIVE_CHANNEL_UNREAD_CNT", "", "TAG", "", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22631);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChannelUnreadConvertProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int convertToRecentUnreadType(int channelUnreadType) {
        if (channelUnreadType == 1) {
            return 1;
        }
        return 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleDefaultChannelUnread(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        UnreadCntInfo unreadCntInfo;
        int i3;
        UnreadCnt unreadCnt;
        boolean z16;
        UnreadCntInfo unreadCntInfo2;
        GuildContactInfo guildContactInfo = item.s().guildContactInfo;
        Integer num = null;
        if (guildContactInfo != null) {
            unreadCntInfo = guildContactInfo.unreadCntInfo;
        } else {
            unreadCntInfo = null;
        }
        int i16 = 0;
        if (unreadCntInfo != null) {
            UnreadCnt unreadCnt2 = unreadCntInfo.showUnreadCnt;
            if (unreadCnt2 != null && unreadCnt2.cnt > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                unreadCntInfo2 = unreadCntInfo;
            } else {
                unreadCntInfo2 = null;
            }
            if (unreadCntInfo2 != null) {
                UnreadCnt unreadCnt3 = unreadCntInfo2.showUnreadCnt;
                i3 = unreadCnt3.type;
                i16 = unreadCnt3.cnt;
                item.x().e(i3);
                item.x().d(i16);
                String b16 = a.b(item.s());
                if (unreadCntInfo == null) {
                    unreadCnt = unreadCntInfo.allUnreadCnt;
                } else {
                    unreadCnt = null;
                }
                if (unreadCntInfo != null) {
                    num = Integer.valueOf(unreadCntInfo.relatedToMeCnt);
                }
                QLog.i(TAG, 1, "handleDefaultChannelUnread channelId:" + b16 + " allUnreadCnt:" + unreadCnt + " relatedToMeCnt:" + num + " item.unreadInfo:" + item.x());
            }
        }
        i3 = 2;
        item.x().e(i3);
        item.x().d(i16);
        String b162 = a.b(item.s());
        if (unreadCntInfo == null) {
        }
        if (unreadCntInfo != null) {
        }
        QLog.i(TAG, 1, "handleDefaultChannelUnread channelId:" + b162 + " allUnreadCnt:" + unreadCnt + " relatedToMeCnt:" + num + " item.unreadInfo:" + item.x());
    }

    private final void handleLiveChannelUnread(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        item.x().e(2);
        item.x().d(0L);
    }

    private final void handleVoiceChannelUnread(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        item.x().e(2);
        item.x().d(0L);
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public boolean matchPayload(@NotNull f payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) payload)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(payload, "payload");
        return payload instanceof m;
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull c params) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        GuildContactInfo guildContactInfo = item.s().guildContactInfo;
        if (guildContactInfo != null) {
            i3 = guildContactInfo.channelType;
        } else {
            i3 = 1;
        }
        if (i3 != 2) {
            if (i3 != 5) {
                handleDefaultChannelUnread(item);
                return;
            } else {
                handleLiveChannelUnread(item);
                return;
            }
        }
        handleVoiceChannelUnread(item);
    }
}
