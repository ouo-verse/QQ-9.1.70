package com.tencent.qqnt.aio.gallery.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgRevokeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.aio.MsgRevokeDialogHideEvent;
import com.tencent.qqnt.aio.MsgRevokeEvent;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.part.NTAIOLayerBasePart;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u000e\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00180\u0017j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0018`\u0019H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/u;", "Lcom/tencent/richframework/gallery/part/NTAIOLayerBasePart;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "peerId", "", "msgId", "", "A9", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "itemInfo", "", "E9", "D9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class u extends NTAIOLayerBasePart implements SimpleEventReceiver<SimpleBaseEvent> {
    private final void A9(final String peerId, final long msgId) {
        getMainHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.gallery.part.s
            @Override // java.lang.Runnable
            public final void run() {
                u.B9(u.this, msgId, peerId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(final u this$0, final long j3, final String peerId) {
        RFWLayerState data;
        List<RFWLayerItemMediaInfo> richMediaDataList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(peerId, "$peerId");
        RFWLog.i(this$0.getTAG(), RFWLog.USR, "MsgRevokeEvent msgId:" + j3 + " peerId:" + peerId);
        if (this$0.E9(this$0.mCurrentSelectedItem, peerId, j3)) {
            this$0.getPartRootView().setVisibility(8);
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this$0.getContext(), 230, (String) null, this$0.getActivity().getResources().getString(R.string.j9_), (String) null, this$0.getActivity().getResources().getString(R.string.ket), new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.gallery.part.t
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    u.C9(u.this, peerId, j3, dialogInterface, i3);
                }
            }, (DialogInterface.OnClickListener) null);
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026}, null\n                )");
            createCustomDialog.show();
            return;
        }
        ArrayList arrayList = new ArrayList();
        UIStateData<RFWLayerState> value = this$0.getMLayerViewModel().mRichMediaInfo.getValue();
        int i3 = 0;
        if (value != null && (data = value.getData()) != null && (richMediaDataList = data.getRichMediaDataList()) != null) {
            for (RFWLayerItemMediaInfo rFWLayerItemMediaInfo : richMediaDataList) {
                Object extraData = rFWLayerItemMediaInfo.getExtraData();
                AIOMsgItem aIOMsgItem = extraData instanceof AIOMsgItem ? (AIOMsgItem) extraData : null;
                if (aIOMsgItem != null && aIOMsgItem.q0() == j3) {
                    Object extraData2 = rFWLayerItemMediaInfo.getExtraData();
                    AIOMsgItem aIOMsgItem2 = extraData2 instanceof AIOMsgItem ? (AIOMsgItem) extraData2 : null;
                    if (Intrinsics.areEqual(aIOMsgItem2 != null ? aIOMsgItem2.r0() : null, peerId)) {
                        RFWLog.i(this$0.getTAG(), RFWLog.USR, "remove item: msgId:" + j3);
                    }
                }
                arrayList.add(rFWLayerItemMediaInfo);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (Intrinsics.areEqual((RFWLayerItemMediaInfo) it.next(), this$0.mCurrentSelectedItem)) {
                break;
            } else {
                i3++;
            }
        }
        MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData = this$0.getMLayerViewModel().mRichMediaInfo;
        UIStateData obtainDelete = UIStateData.obtainDelete();
        UIStateData<RFWLayerState> value2 = this$0.getMLayerViewModel().mRichMediaInfo.getValue();
        Intrinsics.checkNotNull(value2);
        RFWLayerState data2 = value2.getData();
        RFWLayerState rFWLayerState = data2;
        rFWLayerState.setRichMediaDataList(arrayList);
        rFWLayerState.setSelectedPosition(i3);
        Unit unit = Unit.INSTANCE;
        mutableLiveData.setValue(obtainDelete.setDataList(data2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(u this$0, String peerId, long j3, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(peerId, "$peerId");
        this$0.getActivity().finish();
        this$0.getActivity().overridePendingTransition(0, 0);
        SimpleEventBus.getInstance().dispatchEvent(new MsgRevokeDialogHideEvent(peerId, j3));
    }

    private final boolean E9(RFWLayerItemMediaInfo itemInfo, String peerId, long msgId) {
        if (D9(itemInfo, msgId)) {
            return true;
        }
        Object extraData = itemInfo != null ? itemInfo.getExtraData() : null;
        AIOMsgItem aIOMsgItem = extraData instanceof AIOMsgItem ? (AIOMsgItem) extraData : null;
        if (aIOMsgItem != null && aIOMsgItem.q0() == msgId) {
            Object extraData2 = itemInfo.getExtraData();
            AIOMsgItem aIOMsgItem2 = extraData2 instanceof AIOMsgItem ? (AIOMsgItem) extraData2 : null;
            if (Intrinsics.areEqual(aIOMsgItem2 != null ? aIOMsgItem2.r0() : null, peerId)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(MsgRevokeEvent.class);
        arrayList.add(GuildMsgRevokeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof MsgRevokeEvent) {
            MsgRevokeEvent msgRevokeEvent = (MsgRevokeEvent) event;
            A9(msgRevokeEvent.getPeerId(), msgRevokeEvent.getMsgId());
        } else if (event instanceof GuildMsgRevokeEvent) {
            GuildMsgRevokeEvent guildMsgRevokeEvent = (GuildMsgRevokeEvent) event;
            A9(guildMsgRevokeEvent.getPeerId(), guildMsgRevokeEvent.getMsgId());
        }
    }

    private final boolean D9(RFWLayerItemMediaInfo itemInfo, long msgId) {
        Object extraData = itemInfo != null ? itemInfo.getExtraData() : null;
        AIOMsgItem aIOMsgItem = extraData instanceof AIOMsgItem ? (AIOMsgItem) extraData : null;
        if ((aIOMsgItem != null ? aIOMsgItem.k0() : null) == null) {
            return false;
        }
        Object extraData2 = itemInfo != null ? itemInfo.getExtraData() : null;
        AIOMsgItem aIOMsgItem2 = extraData2 instanceof AIOMsgItem ? (AIOMsgItem) extraData2 : null;
        return aIOMsgItem2 != null && (msgId > aIOMsgItem2.m0() ? 1 : (msgId == aIOMsgItem2.m0() ? 0 : -1)) == 0;
    }
}
