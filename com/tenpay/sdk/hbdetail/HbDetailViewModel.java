package com.tenpay.sdk.hbdetail;

import androidx.annotation.MainThread;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.google.gson.JsonSyntaxException;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.hbdetail.HbDetailRsp;
import com.tenpay.sdk.util.HBUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001PB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J \u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u0001002\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0<H\u0002J\u0010\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020\u001eH\u0007J\u001c\u0010?\u001a\u00020:2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0AH\u0002J\u0016\u0010B\u001a\u00020:2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u001c\u0010C\u001a\u00020:2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0AH\u0007J\u0012\u0010E\u001a\u00020:2\b\u0010F\u001a\u0004\u0018\u00010GH\u0002J\u0010\u0010H\u001a\u00020:2\u0006\u0010F\u001a\u00020GH\u0002J\u001c\u0010I\u001a\u00020:2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0AH\u0007J'\u0010J\u001a\u00020:2\b\u00101\u001a\u0004\u0018\u0001002\u000e\u0010K\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010LH\u0002\u00a2\u0006\u0002\u0010MJ\u001d\u0010N\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010L2\u0006\u0010F\u001a\u00020GH\u0002\u00a2\u0006\u0002\u0010OJ\u0010\u0010N\u001a\u00020:2\u0006\u0010>\u001a\u00020\u001eH\u0007R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00198F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R'\u0010\"\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001e0#j\b\u0012\u0004\u0012\u00020\u001e`$0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010*R\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00198F\u00a2\u0006\u0006\u001a\u0004\b,\u0010\u001bR\"\u0010-\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\"\u00101\u001a\u0004\u0018\u0001002\b\u0010\u000e\u001a\u0004\u0018\u000100@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\r0\u00198F\u00a2\u0006\u0006\u001a\u0004\b5\u0010\u001bR\u0013\u00106\u001a\u0004\u0018\u00010\u001e8F\u00a2\u0006\u0006\u001a\u0004\b7\u00108R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006Q"}, d2 = {"Lcom/tenpay/sdk/hbdetail/HbDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "stateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Landroidx/lifecycle/SavedStateHandle;)V", "_hbOperationBubble", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbOperationBubble;", "_receivers", "", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbReceiver;", "_senderAndSelfChanged", "", "<set-?>", "", WadlProxyConsts.CHANNEL, "getChannel", "()I", "hasMore", "getHasMore", "()Z", "hasTinyId", "getHasTinyId", "hbOperationBubble", "Landroidx/lifecycle/LiveData;", "getHbOperationBubble", "()Landroidx/lifecycle/LiveData;", "idNameMapCache", "", "", "getIdNameMapCache", "()Ljava/util/Map;", "isInGuildAio", "newUserIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getNewUserIds", "()Landroidx/lifecycle/MutableLiveData;", "offset", "getOffset", "setOffset", "(I)V", "receivers", "getReceivers", "self", "getSelf", "()Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbReceiver;", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbSender;", "sender", "getSender", "()Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbSender;", "senderAndSelfChanged", "getSenderAndSelfChanged", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "getSenderUin", "()Ljava/lang/String;", "filterFace2Face", "", "hbSender", "", "initHbDetail", "hbData", "modifySenderName", "idNameMap", "", "replaceIllegalGuildNickName", "updateAvatars", "idAvatarMap", "updateHasMore", "hbDetailRsp", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp;", "updateLuckFlag", "updateNames", "updateNewUserId", "newReceivers", "", "(Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbSender;[Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbReceiver;)V", "updateReceivers", "(Lcom/tenpay/sdk/hbdetail/HbDetailRsp;)[Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbReceiver;", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class HbDetailViewModel extends ViewModel implements LifecycleObserver {

    @NotNull
    private static final String TAG = "HbDetailViewModel";

    @NotNull
    private final MutableLiveData<HbDetailRsp.HbOperationBubble> _hbOperationBubble;

    @NotNull
    private final MutableLiveData<List<HbDetailRsp.HbReceiver>> _receivers;

    @NotNull
    private final MutableLiveData<Boolean> _senderAndSelfChanged;
    private int channel;
    private boolean hasMore;
    private boolean hasTinyId;

    @NotNull
    private final Map<String, String> idNameMapCache;
    private final boolean isInGuildAio;

    @NotNull
    private final MutableLiveData<ArrayList<String>> newUserIds;
    private int offset;

    @Nullable
    private HbDetailRsp.HbReceiver self;

    @Nullable
    private HbDetailRsp.HbSender sender;

    @NotNull
    private final SavedStateHandle stateHandle;

    public HbDetailViewModel(@NotNull SavedStateHandle stateHandle) {
        Intrinsics.checkNotNullParameter(stateHandle, "stateHandle");
        this.stateHandle = stateHandle;
        this.newUserIds = new MutableLiveData<>();
        this._senderAndSelfChanged = new MutableLiveData<>();
        this.hasMore = true;
        this.isInGuildAio = Intrinsics.areEqual(String.valueOf(stateHandle.get("grouptype")), "11");
        this._receivers = new MutableLiveData<>();
        this._hbOperationBubble = new MutableLiveData<>(null);
        this.channel = -1;
        this.idNameMapCache = new LinkedHashMap();
    }

    private final void filterFace2Face(HbDetailRsp.HbSender hbSender, List<HbDetailRsp.HbReceiver> receivers) {
        if (hbSender != null && !Intrinsics.areEqual(hbSender.getSendUin(), com.tencent.mobileqq.base.a.c()) && HBUtil.isHbForFaceToFace(this.channel)) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) receivers, (Function1) new Function1<HbDetailRsp.HbReceiver, Boolean>() { // from class: com.tenpay.sdk.hbdetail.HbDetailViewModel$filterFace2Face$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull HbDetailRsp.HbReceiver it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(!Intrinsics.areEqual(it.getRecvUin(), com.tencent.mobileqq.base.a.c()));
                }
            });
        }
    }

    private final void modifySenderName(Map<String, String> idNameMap) {
        String sendUin;
        boolean z16;
        HbDetailRsp.HbSender hbSender = this.sender;
        if (hbSender != null) {
            if (this.isInGuildAio) {
                sendUin = hbSender.getSendTinyId();
            } else {
                sendUin = hbSender.getSendUin();
            }
            String str = idNameMap.get(sendUin);
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                hbSender.setSendName(str);
            }
        }
    }

    private final void replaceIllegalGuildNickName(List<HbDetailRsp.HbReceiver> receivers) {
        if (this.isInGuildAio) {
            for (HbDetailRsp.HbReceiver hbReceiver : receivers) {
                if (Intrinsics.areEqual(hbReceiver.getRecvUin(), hbReceiver.getRecvName())) {
                    hbReceiver.setRecvName(HardCodeUtil.qqStr(R.string.f143020ky));
                    QLog.d(TAG, 1, "modifyGuildNameIfIsQQUin: tinyId," + hbReceiver.getRecvTinyId() + "; recvUin," + hbReceiver.getRecvUin());
                }
            }
        }
    }

    private final void updateHasMore(HbDetailRsp hbDetailRsp) {
        HbDetailRsp.HbSender hbSender;
        int i3;
        Integer num;
        Integer num2 = null;
        if (hbDetailRsp != null) {
            hbSender = hbDetailRsp.getSender();
        } else {
            hbSender = null;
        }
        boolean z16 = false;
        if (hbSender == null) {
            this.hasMore = false;
            return;
        }
        HbDetailRsp.HbSender hbSender2 = this.sender;
        if (hbSender2 != null) {
            i3 = hbSender2.getRecvNum();
        } else {
            i3 = 0;
        }
        if (i3 > this.offset) {
            z16 = true;
        }
        this.hasMore = z16;
        HbDetailRsp.HbSender hbSender3 = this.sender;
        if (hbSender3 != null) {
            num = Integer.valueOf(hbSender3.getRecvNum());
        } else {
            num = null;
        }
        List<HbDetailRsp.HbReceiver> value = this._receivers.getValue();
        if (value != null) {
            num2 = Integer.valueOf(value.size());
        }
        QLog.i(TAG, 1, "hasMore=" + z16 + " recvNum=" + num + " receiverSize=" + num2 + " offset=" + this.offset);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateLuckFlag(HbDetailRsp hbDetailRsp) {
        boolean z16;
        boolean z17;
        boolean z18;
        String str;
        boolean z19;
        HbDetailRsp.HbSender sender = hbDetailRsp.getSender();
        if (sender != null && sender.getTotalNum() == sender.getRecvNum()) {
            z16 = true;
        } else {
            z16 = false;
        }
        HbDetailRsp.HbReceiver[] receivers = hbDetailRsp.getReceivers();
        if (receivers != null) {
            for (HbDetailRsp.HbReceiver hbReceiver : receivers) {
                if (z16) {
                    String recvUin = hbReceiver.getRecvUin();
                    if (recvUin != null) {
                        if (recvUin.length() > 0) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (z19) {
                            z18 = true;
                            if (z18) {
                                String recvUin2 = hbReceiver.getRecvUin();
                                HbDetailRsp.HbSender sender2 = hbDetailRsp.getSender();
                                if (sender2 != null) {
                                    str = sender2.getLuckyUin();
                                } else {
                                    str = null;
                                }
                                if (Intrinsics.areEqual(recvUin2, str)) {
                                    z17 = true;
                                    hbReceiver.setLuck(z17);
                                }
                            }
                        }
                    }
                    z18 = false;
                    if (z18) {
                    }
                }
                z17 = false;
                hbReceiver.setLuck(z17);
            }
        }
    }

    private final void updateNewUserId(HbDetailRsp.HbSender sender, HbDetailRsp.HbReceiver[] newReceivers) {
        String sendUin;
        String recvUin;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = null;
        if (this.isInGuildAio) {
            if (sender != null) {
                sendUin = sender.getSendTinyId();
            }
            sendUin = null;
        } else {
            if (sender != null) {
                sendUin = sender.getSendUin();
            }
            sendUin = null;
        }
        if (sendUin != null) {
            arrayList.add(sendUin);
        }
        if (newReceivers != null) {
            arrayList2 = new ArrayList();
            for (HbDetailRsp.HbReceiver hbReceiver : newReceivers) {
                if (this.isInGuildAio) {
                    recvUin = hbReceiver.getRecvTinyId();
                } else {
                    recvUin = hbReceiver.getRecvUin();
                }
                if (recvUin != null) {
                    arrayList2.add(recvUin);
                }
            }
        }
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        this.newUserIds.setValue(new ArrayList<>(arrayList));
    }

    public final int getChannel() {
        return this.channel;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final boolean getHasTinyId() {
        return this.hasTinyId;
    }

    @NotNull
    public final LiveData<HbDetailRsp.HbOperationBubble> getHbOperationBubble() {
        return this._hbOperationBubble;
    }

    @NotNull
    public final Map<String, String> getIdNameMapCache() {
        return this.idNameMapCache;
    }

    @NotNull
    public final MutableLiveData<ArrayList<String>> getNewUserIds() {
        return this.newUserIds;
    }

    public final int getOffset() {
        return this.offset;
    }

    @NotNull
    public final LiveData<List<HbDetailRsp.HbReceiver>> getReceivers() {
        return this._receivers;
    }

    @Nullable
    public final HbDetailRsp.HbReceiver getSelf() {
        return this.self;
    }

    @Nullable
    public final HbDetailRsp.HbSender getSender() {
        return this.sender;
    }

    @NotNull
    public final LiveData<Boolean> getSenderAndSelfChanged() {
        return this._senderAndSelfChanged;
    }

    @Nullable
    public final String getSenderUin() {
        HbDetailRsp.HbSender hbSender = this.sender;
        if (hbSender != null) {
            return hbSender.getSendUin();
        }
        return null;
    }

    @MainThread
    public final void initHbDetail(@NotNull String hbData) {
        HbDetailRsp hbDetailRsp;
        boolean z16;
        int i3;
        Intrinsics.checkNotNullParameter(hbData, "hbData");
        String str = null;
        try {
            hbDetailRsp = HbDetailRsp.INSTANCE.fromJson(hbData);
        } catch (JsonSyntaxException e16) {
            QLog.e(TAG, 1, "Error when parse HbDetailRsp from json: " + hbData, e16);
            hbDetailRsp = null;
        }
        if (hbDetailRsp == null) {
            return;
        }
        HbDetailRsp.HbSender sender = hbDetailRsp.getSender();
        if (sender != null) {
            str = sender.getSendTinyId();
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.hasTinyId = !z16;
        HbDetailRsp.HbSender sender2 = hbDetailRsp.getSender();
        if (sender2 != null) {
            i3 = sender2.getChannel();
        } else {
            i3 = -1;
        }
        this.channel = i3;
        HbDetailRsp.HbSender sender3 = hbDetailRsp.getSender();
        if (sender3 != null) {
            this.sender = sender3;
        }
        modifySenderName(this.idNameMapCache);
        HbDetailRsp.HbReceiver self = hbDetailRsp.getSelf();
        if (self != null) {
            this.self = self;
        }
        this._senderAndSelfChanged.setValue(Boolean.TRUE);
        HbDetailRsp.HbOperationBubble operationBubble = hbDetailRsp.getOperationBubble();
        if (operationBubble != null) {
            this._hbOperationBubble.setValue(operationBubble);
        }
        updateNewUserId(this.sender, updateReceivers(hbDetailRsp));
    }

    public final void setOffset(int i3) {
        this.offset = i3;
    }

    @MainThread
    public final void updateAvatars(@NotNull Map<String, String> idAvatarMap) {
        List<HbDetailRsp.HbReceiver> emptyList;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(idAvatarMap, "idAvatarMap");
        HbDetailRsp.HbSender hbSender = this.sender;
        if (hbSender != null) {
            if (this.isInGuildAio) {
                String str = idAvatarMap.get(hbSender.getSendTinyId());
                if (str == null) {
                    str = hbSender.getTinyIdAvatarUrl();
                }
                hbSender.setTinyIdAvatarUrl(str);
            } else {
                String str2 = idAvatarMap.get(hbSender.getSendUin());
                if (str2 == null) {
                    str2 = hbSender.getUinAvatarPath();
                }
                hbSender.setUinAvatarPath(str2);
            }
        }
        this._senderAndSelfChanged.setValue(Boolean.TRUE);
        List<HbDetailRsp.HbReceiver> value = this._receivers.getValue();
        if (value == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            List<HbDetailRsp.HbReceiver> list = value;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            emptyList = new ArrayList<>(collectionSizeOrDefault);
            for (HbDetailRsp.HbReceiver hbReceiver : list) {
                HbDetailRsp.HbReceiver copy$default = HbDetailRsp.HbReceiver.copy$default(hbReceiver, 0, null, null, null, null, null, null, null, 255, null);
                copy$default.setLuck(hbReceiver.getIsLuck());
                copy$default.setUinAvatarPath(hbReceiver.getUinAvatarPath());
                copy$default.setTinyAvatarUrl(hbReceiver.getTinyAvatarUrl());
                if (this.isInGuildAio) {
                    String str3 = idAvatarMap.get(hbReceiver.getRecvTinyId());
                    if (str3 == null) {
                        str3 = hbReceiver.getTinyAvatarUrl();
                    }
                    copy$default.setTinyAvatarUrl(str3);
                } else {
                    String str4 = idAvatarMap.get(hbReceiver.getRecvUin());
                    if (str4 == null) {
                        str4 = hbReceiver.getUinAvatarPath();
                    }
                    copy$default.setUinAvatarPath(str4);
                }
                emptyList.add(copy$default);
            }
        }
        this._receivers.setValue(emptyList);
    }

    @MainThread
    public final void updateNames(@NotNull Map<String, String> idNameMap) {
        List<HbDetailRsp.HbReceiver> emptyList;
        int collectionSizeOrDefault;
        String recvUin;
        boolean z16;
        Intrinsics.checkNotNullParameter(idNameMap, "idNameMap");
        modifySenderName(idNameMap);
        this.idNameMapCache.putAll(idNameMap);
        this._senderAndSelfChanged.setValue(Boolean.TRUE);
        List<HbDetailRsp.HbReceiver> value = this._receivers.getValue();
        if (value == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            List<HbDetailRsp.HbReceiver> list = value;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            emptyList = new ArrayList<>(collectionSizeOrDefault);
            for (HbDetailRsp.HbReceiver hbReceiver : list) {
                HbDetailRsp.HbReceiver copy$default = HbDetailRsp.HbReceiver.copy$default(hbReceiver, 0, null, null, null, null, null, null, null, 255, null);
                copy$default.setLuck(hbReceiver.getIsLuck());
                copy$default.setUinAvatarPath(hbReceiver.getUinAvatarPath());
                copy$default.setTinyAvatarUrl(hbReceiver.getTinyAvatarUrl());
                if (this.isInGuildAio) {
                    recvUin = hbReceiver.getRecvTinyId();
                } else {
                    recvUin = hbReceiver.getRecvUin();
                }
                String str = idNameMap.get(recvUin);
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    copy$default.setRecvName(str);
                }
                emptyList.add(copy$default);
            }
        }
        this._receivers.setValue(emptyList);
    }

    @MainThread
    public final void updateReceivers(@NotNull String hbData) {
        Intrinsics.checkNotNullParameter(hbData, "hbData");
        try {
            updateNewUserId(null, updateReceivers(HbDetailRsp.INSTANCE.fromJson(hbData)));
        } catch (JsonSyntaxException e16) {
            QLog.e(TAG, 1, "Error when get receiver array from hd data, " + hbData, e16);
        }
    }

    private final HbDetailRsp.HbReceiver[] updateReceivers(HbDetailRsp hbDetailRsp) {
        ArrayList arrayList;
        List list;
        List<HbDetailRsp.HbReceiver> mutableList;
        ArrayList arrayList2;
        int i3 = 0;
        if (this.isInGuildAio) {
            HbDetailRsp.HbReceiver[] receivers = hbDetailRsp.getReceivers();
            if (receivers != null) {
                arrayList2 = new ArrayList(receivers.length);
                int length = receivers.length;
                while (i3 < length) {
                    arrayList2.add(receivers[i3].getRecvTinyId());
                    i3++;
                }
            } else {
                arrayList2 = null;
            }
            QLog.i(TAG, 1, "updateReceivers: " + arrayList2);
        } else {
            HbDetailRsp.HbReceiver[] receivers2 = hbDetailRsp.getReceivers();
            if (receivers2 != null) {
                arrayList = new ArrayList(receivers2.length);
                int length2 = receivers2.length;
                while (i3 < length2) {
                    arrayList.add(receivers2[i3].getRecvUin());
                    i3++;
                }
            } else {
                arrayList = null;
            }
            QLog.i(TAG, 1, "updateReceivers: " + arrayList);
        }
        updateLuckFlag(hbDetailRsp);
        HbDetailRsp.HbReceiver[] receivers3 = hbDetailRsp.getReceivers();
        if (receivers3 == null) {
            return null;
        }
        List<HbDetailRsp.HbReceiver> value = this._receivers.getValue();
        if (value == null) {
            value = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList3 = new ArrayList(value);
        list = ArraysKt___ArraysKt.toList(receivers3);
        arrayList3.addAll(list);
        HashSet hashSet = new HashSet();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : arrayList3) {
            HbDetailRsp.HbReceiver hbReceiver = (HbDetailRsp.HbReceiver) obj;
            if (hashSet.add(this.isInGuildAio ? hbReceiver.getRecvTinyId() : hbReceiver.getRecvUin())) {
                arrayList4.add(obj);
            }
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList4);
        if (mutableList.size() != arrayList3.size()) {
            QLog.i(TAG, 1, "distinctSize: " + mutableList.size() + ", originalSize:" + arrayList3.size());
        }
        filterFace2Face(hbDetailRsp.getSender(), mutableList);
        replaceIllegalGuildNickName(mutableList);
        this.offset += receivers3.length;
        this._receivers.setValue(mutableList);
        updateHasMore(hbDetailRsp);
        return receivers3;
    }
}
