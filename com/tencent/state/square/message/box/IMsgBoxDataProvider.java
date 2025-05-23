package com.tencent.state.square.message.box;

import com.tencent.state.data.SquareJSConst;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.data.SquareUserInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH&J\b\u0010\u000b\u001a\u00020\fH&J\u0012\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011j\b\u0012\u0004\u0012\u00020\t`\u0012H&JH\u0010\u0013\u001a\u00020\u00032\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0011j\b\u0012\u0004\u0012\u00020\u000f`\u00122&\u0010\u0015\u001a\"\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0012\u0012\u0004\u0012\u00020\u00030\bH&J*\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u0018H&J\b\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/square/message/box/IMsgBoxDataProvider;", "", "addMsgBoxDataObserver", "", "observer", "Lcom/tencent/state/square/message/box/IMsgBoxDataObserver;", "filterMsgRecord", "filter", "Lkotlin/Function1;", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "", "getMsgBoxSource", "Lcom/tencent/state/square/message/box/MsgBoxSource;", "getMsgRecord", "uin", "", "getMsgRecords", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getStrangerNickList", SquareJSConst.Params.PARAMS_UIN_LIST, "callback", "Lcom/tencent/state/square/data/SquareUserInfo;", "getStrangerNickName", "Lkotlin/Function2;", "getTotalUnReadCount", "", "removeMsgBoxDataObserver", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IMsgBoxDataProvider {
    void addMsgBoxDataObserver(IMsgBoxDataObserver observer);

    void filterMsgRecord(Function1<? super SquareBaseMessageRecord, Boolean> filter);

    MsgBoxSource getMsgBoxSource();

    SquareBaseMessageRecord getMsgRecord(String uin);

    ArrayList<SquareBaseMessageRecord> getMsgRecords();

    void getStrangerNickList(ArrayList<String> uinList, Function1<? super ArrayList<SquareUserInfo>, Unit> callback);

    void getStrangerNickName(String uin, Function2<? super String, ? super String, Unit> callback);

    int getTotalUnReadCount();

    void removeMsgBoxDataObserver(IMsgBoxDataObserver observer);
}
