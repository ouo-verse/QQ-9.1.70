package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0016J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H&J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0013H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository;", "", "", "a", "e", "", "beginMsgSeq", "endMsgSeq", "f", "", "source", "i", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "k", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/l;", "msgListWithOpType", DomainData.DOMAIN_NAME, "", "list", "b", "MsgListRepoOpType", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface IMsgListRepository {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository$MsgListRepoOpType;", "", "(Ljava/lang/String;I)V", "LoadFirst", "LoadFirstPageFail", "LoadPrePage", "LoadPrePageFail", "LoadNextPage", "LoadNextPageFail", "LoadRangePage", "LoadRangePageFail", "LoadSendMessage", "LoadSendMessageFail", "LoadMessageUpdate", "LoadMessageReceive", "UpdateFocusIndex", "OtherOperation", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class MsgListRepoOpType {
        private static final /* synthetic */ MsgListRepoOpType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final MsgListRepoOpType LoadFirst;
        public static final MsgListRepoOpType LoadFirstPageFail;
        public static final MsgListRepoOpType LoadMessageReceive;
        public static final MsgListRepoOpType LoadMessageUpdate;
        public static final MsgListRepoOpType LoadNextPage;
        public static final MsgListRepoOpType LoadNextPageFail;
        public static final MsgListRepoOpType LoadPrePage;
        public static final MsgListRepoOpType LoadPrePageFail;
        public static final MsgListRepoOpType LoadRangePage;
        public static final MsgListRepoOpType LoadRangePageFail;
        public static final MsgListRepoOpType LoadSendMessage;
        public static final MsgListRepoOpType LoadSendMessageFail;
        public static final MsgListRepoOpType OtherOperation;

        @Deprecated(message = "\u5e9f\u5f03\uff0c\u7981\u6b62\u4f7f\u7528")
        public static final MsgListRepoOpType UpdateFocusIndex;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46429);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            MsgListRepoOpType msgListRepoOpType = new MsgListRepoOpType("LoadFirst", 0);
            LoadFirst = msgListRepoOpType;
            MsgListRepoOpType msgListRepoOpType2 = new MsgListRepoOpType("LoadFirstPageFail", 1);
            LoadFirstPageFail = msgListRepoOpType2;
            MsgListRepoOpType msgListRepoOpType3 = new MsgListRepoOpType("LoadPrePage", 2);
            LoadPrePage = msgListRepoOpType3;
            MsgListRepoOpType msgListRepoOpType4 = new MsgListRepoOpType("LoadPrePageFail", 3);
            LoadPrePageFail = msgListRepoOpType4;
            MsgListRepoOpType msgListRepoOpType5 = new MsgListRepoOpType("LoadNextPage", 4);
            LoadNextPage = msgListRepoOpType5;
            MsgListRepoOpType msgListRepoOpType6 = new MsgListRepoOpType("LoadNextPageFail", 5);
            LoadNextPageFail = msgListRepoOpType6;
            MsgListRepoOpType msgListRepoOpType7 = new MsgListRepoOpType("LoadRangePage", 6);
            LoadRangePage = msgListRepoOpType7;
            MsgListRepoOpType msgListRepoOpType8 = new MsgListRepoOpType("LoadRangePageFail", 7);
            LoadRangePageFail = msgListRepoOpType8;
            MsgListRepoOpType msgListRepoOpType9 = new MsgListRepoOpType("LoadSendMessage", 8);
            LoadSendMessage = msgListRepoOpType9;
            MsgListRepoOpType msgListRepoOpType10 = new MsgListRepoOpType("LoadSendMessageFail", 9);
            LoadSendMessageFail = msgListRepoOpType10;
            MsgListRepoOpType msgListRepoOpType11 = new MsgListRepoOpType("LoadMessageUpdate", 10);
            LoadMessageUpdate = msgListRepoOpType11;
            MsgListRepoOpType msgListRepoOpType12 = new MsgListRepoOpType("LoadMessageReceive", 11);
            LoadMessageReceive = msgListRepoOpType12;
            MsgListRepoOpType msgListRepoOpType13 = new MsgListRepoOpType("UpdateFocusIndex", 12);
            UpdateFocusIndex = msgListRepoOpType13;
            MsgListRepoOpType msgListRepoOpType14 = new MsgListRepoOpType("OtherOperation", 13);
            OtherOperation = msgListRepoOpType14;
            $VALUES = new MsgListRepoOpType[]{msgListRepoOpType, msgListRepoOpType2, msgListRepoOpType3, msgListRepoOpType4, msgListRepoOpType5, msgListRepoOpType6, msgListRepoOpType7, msgListRepoOpType8, msgListRepoOpType9, msgListRepoOpType10, msgListRepoOpType11, msgListRepoOpType12, msgListRepoOpType13, msgListRepoOpType14};
        }

        MsgListRepoOpType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            }
        }

        public static MsgListRepoOpType valueOf(String str) {
            return (MsgListRepoOpType) Enum.valueOf(MsgListRepoOpType.class, str);
        }

        public static MsgListRepoOpType[] values() {
            return (MsgListRepoOpType[]) $VALUES.clone();
        }
    }

    void a();

    @NotNull
    Collection<com.tencent.aio.data.msglist.a> b(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> list);

    void e();

    void f(long beginMsgSeq, long endMsgSeq);

    void i(@NotNull String source);

    @NotNull
    List<com.tencent.aio.data.msglist.a> k(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList);

    @NotNull
    l n(@NotNull l msgListWithOpType);
}
