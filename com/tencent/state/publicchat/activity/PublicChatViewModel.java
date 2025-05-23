package com.tencent.state.publicchat.activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.event.Event;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.publicchat.view.MessageItemView;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.template.data.CommonDataKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\u0018\u0000 32\u00020\u0001:\u00013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0&2\u0006\u0010'\u001a\u00020\u0010J\u0006\u0010(\u001a\u00020$J\u0006\u0010)\u001a\u00020$J\u000e\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u0004J\u0018\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u0010H\u0002J\u0018\u0010/\u001a\u00020$2\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u0010H\u0002J\b\u00100\u001a\u00020$H\u0002J\u001c\u00101\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0&J\u000e\u00102\u001a\u00020$2\u0006\u0010%\u001a\u00020\bR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017\u00a8\u00064"}, d2 = {"Lcom/tencent/state/publicchat/activity/PublicChatViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_channelId", "", "Ljava/lang/Long;", "_config", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", "_msgChangeEventBus", "Lcom/tencent/state/event/Event;", "Lcom/tencent/state/publicchat/activity/MsgChangeEventData;", "_msgs", "", "Lcom/tencent/state/publicchat/data/MsgInfo;", "_unReadMsgCount", "", "channelId", "getChannelId", "()Ljava/lang/Long;", DownloadInfo.spKey_Config, "Landroidx/lifecycle/LiveData;", "getConfig", "()Landroidx/lifecycle/LiveData;", "isReady", "", "()Z", "msgChangeEventBus", "getMsgChangeEventBus", "msgIdSet", "", "msgs", "getMsgs", "unReadMsgCount", "getUnReadMsgCount", "addMsgs", "", "v", "", "maxShowCount", "clean", "markAllRead", "msgExist", "msgId", "notifyItemsAdded", "index", "count", "notifyItemsDeleted", "notifyItemsRefreshed", "setMsgs", "updateConfig", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PublicChatViewModel extends ViewModel {
    private static final String TAG = "PublicChatViewModel";
    private Long _channelId;
    private final MutableLiveData<PublicChatConfInfo> _config;
    private final MutableLiveData<Event<MsgChangeEventData>> _msgChangeEventBus;
    private final MutableLiveData<List<MsgInfo>> _msgs;
    private final MutableLiveData<Integer> _unReadMsgCount;
    private final LiveData<PublicChatConfInfo> config;
    private final LiveData<Event<MsgChangeEventData>> msgChangeEventBus;
    private final Set<Long> msgIdSet;
    private final LiveData<List<MsgInfo>> msgs;
    private final LiveData<Integer> unReadMsgCount;

    public PublicChatViewModel() {
        MutableLiveData<PublicChatConfInfo> mutableLiveData = new MutableLiveData<>(null);
        this._config = mutableLiveData;
        this.config = mutableLiveData;
        MutableLiveData<List<MsgInfo>> mutableLiveData2 = new MutableLiveData<>(new ArrayList());
        this._msgs = mutableLiveData2;
        this.msgs = mutableLiveData2;
        MutableLiveData<Integer> mutableLiveData3 = new MutableLiveData<>(0);
        this._unReadMsgCount = mutableLiveData3;
        this.unReadMsgCount = mutableLiveData3;
        this.msgIdSet = new LinkedHashSet();
        MutableLiveData<Event<MsgChangeEventData>> mutableLiveData4 = new MutableLiveData<>();
        this._msgChangeEventBus = mutableLiveData4;
        this.msgChangeEventBus = mutableLiveData4;
    }

    private final boolean isReady() {
        return this.config.getValue() != null;
    }

    private final void notifyItemsAdded(int index, int count) {
        int collectionSizeOrDefault;
        List<MsgInfo> value = this.msgs.getValue();
        if (value != null) {
            List<MsgInfo> list = value;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((MsgInfo) it.next());
            }
            this._msgChangeEventBus.setValue(new Event<>(new MsgChangeEventData(index, count, arrayList, true, false, 16, null)));
        }
    }

    private final void notifyItemsDeleted(int index, int count) {
        int collectionSizeOrDefault;
        List<MsgInfo> value = this.msgs.getValue();
        if (value != null) {
            List<MsgInfo> list = value;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((MsgInfo) it.next());
            }
            this._msgChangeEventBus.setValue(new Event<>(new MsgChangeEventData(index, count, arrayList, false, true, 8, null)));
        }
    }

    private final void notifyItemsRefreshed() {
        int collectionSizeOrDefault;
        List<MsgInfo> value = this.msgs.getValue();
        if (value != null) {
            List<MsgInfo> list = value;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((MsgInfo) it.next());
            }
            this._msgChangeEventBus.setValue(new Event<>(new MsgChangeEventData(0, 0, arrayList, false, false, 24, null)));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0071, code lost:
    
        if (r13.msgIdSet.contains(java.lang.Long.valueOf(r5.getHeader().getMsgId())) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void addMsgs(List<MsgInfo> v3, int maxShowCount) {
        List mutableList;
        MsgInfo msgInfo;
        Object removeFirstOrNull;
        Intrinsics.checkNotNullParameter(v3, "v");
        synchronized (this.msgs) {
            if (isReady()) {
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = v3.iterator();
                while (true) {
                    boolean z16 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    MsgInfo msgInfo2 = (MsgInfo) next;
                    if (!MessageItemView.INSTANCE.hasFactory(msgInfo2.getHeader().getTemplateId())) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "unknown public chat template id: " + msgInfo2.getHeader(), null, 4, null);
                    }
                    z16 = false;
                    if (z16) {
                        arrayList.add(next);
                    }
                }
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
                if (mutableList.isEmpty()) {
                    return;
                }
                if (mutableList.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(mutableList, new Comparator<T>() { // from class: com.tencent.state.publicchat.activity.PublicChatViewModel$$special$$inlined$sortBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t16, T t17) {
                            int compareValues;
                            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((MsgInfo) t16).getHeader().getAuditTs()), Long.valueOf(((MsgInfo) t17).getHeader().getAuditTs()));
                            return compareValues;
                        }
                    });
                }
                List<MsgInfo> value = this._msgs.getValue();
                int size = value != null ? value.size() : 0;
                List<MsgInfo> value2 = this._msgs.getValue();
                if (value2 != null) {
                    value2.addAll(mutableList);
                }
                Iterator it5 = mutableList.iterator();
                while (it5.hasNext()) {
                    this.msgIdSet.add(Long.valueOf(((MsgInfo) it5.next()).getHeader().getMsgId()));
                }
                notifyItemsAdded(size, mutableList.size());
                MutableLiveData<Integer> mutableLiveData = this._unReadMsgCount;
                Integer value3 = mutableLiveData.getValue();
                if (value3 == null) {
                    value3 = 0;
                }
                int intValue = value3.intValue();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : mutableList) {
                    if (!CommonDataKt.isMe(((MsgInfo) obj).getUser().getUin())) {
                        arrayList2.add(obj);
                    }
                }
                mutableLiveData.setValue(Integer.valueOf(intValue + arrayList2.size()));
                int size2 = (size + mutableList.size()) - maxShowCount;
                int i3 = size2;
                while (i3 > 0) {
                    i3--;
                    List<MsgInfo> value4 = this._msgs.getValue();
                    if (value4 != null) {
                        removeFirstOrNull = CollectionsKt__MutableCollectionsKt.removeFirstOrNull(value4);
                        msgInfo = (MsgInfo) removeFirstOrNull;
                    } else {
                        msgInfo = null;
                    }
                    if (msgInfo != null) {
                        this.msgIdSet.remove(Long.valueOf(msgInfo.getHeader().getMsgId()));
                    }
                }
                if (size2 > 0) {
                    notifyItemsDeleted(0, size2);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void clean() {
        this.msgIdSet.clear();
        this._unReadMsgCount.setValue(0);
        this._channelId = null;
        this._msgs.setValue(new ArrayList());
        this._config.setValue(null);
        notifyItemsRefreshed();
    }

    /* renamed from: getChannelId, reason: from getter */
    public final Long get_channelId() {
        return this._channelId;
    }

    public final LiveData<PublicChatConfInfo> getConfig() {
        return this.config;
    }

    public final LiveData<Event<MsgChangeEventData>> getMsgChangeEventBus() {
        return this.msgChangeEventBus;
    }

    public final LiveData<List<MsgInfo>> getMsgs() {
        return this.msgs;
    }

    public final LiveData<Integer> getUnReadMsgCount() {
        return this.unReadMsgCount;
    }

    public final void markAllRead() {
        if (isReady()) {
            this._unReadMsgCount.setValue(0);
        }
    }

    public final boolean msgExist(long msgId) {
        return this.msgIdSet.contains(Long.valueOf(msgId));
    }

    public final void setMsgs(long channelId, List<MsgInfo> v3) {
        List<MsgInfo> mutableList;
        boolean z16;
        Intrinsics.checkNotNullParameter(v3, "v");
        ArrayList arrayList = new ArrayList();
        for (Object obj : v3) {
            MsgInfo msgInfo = (MsgInfo) obj;
            if (MessageItemView.INSTANCE.hasFactory(msgInfo.getHeader().getTemplateId())) {
                z16 = true;
            } else {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "unknown public chat template id: " + msgInfo.getHeader(), null, 4, null);
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        synchronized (this.msgs) {
            if (isReady()) {
                this._channelId = Long.valueOf(channelId);
                if (arrayList.isEmpty()) {
                    return;
                }
                MutableLiveData<List<MsgInfo>> mutableLiveData = this._msgs;
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
                mutableLiveData.setValue(mutableList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.msgIdSet.add(Long.valueOf(((MsgInfo) it.next()).getHeader().getMsgId()));
                }
                notifyItemsRefreshed();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void updateConfig(PublicChatConfInfo v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        this._config.setValue(v3);
    }
}
