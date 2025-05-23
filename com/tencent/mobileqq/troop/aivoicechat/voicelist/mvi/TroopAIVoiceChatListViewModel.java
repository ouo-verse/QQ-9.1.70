package com.tencent.mobileqq.troop.aivoicechat.voicelist.mvi;

import android.os.Looper;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.aivoicechat.voicelist.mvi.a;
import com.tencent.mobileqq.troop.aivoicechat.voicelist.mvi.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.AIVoiceChatType;
import com.tencent.qqnt.kernel.nativeinterface.IListAllVoiceCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISaveVoiceCallback;
import com.tencent.qqnt.kernel.nativeinterface.ListAllVoiceReq;
import com.tencent.qqnt.kernel.nativeinterface.ListAllVoiceRsp;
import com.tencent.qqnt.kernel.nativeinterface.SaveVoiceReq;
import com.tencent.qqnt.kernel.nativeinterface.SaveVoiceRsp;
import com.tencent.qqnt.kernel.nativeinterface.VoiceItem;
import com.tencent.qqnt.kernel.nativeinterface.VoicePair;
import com.tencent.qqnt.msg.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0003H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/mvi/TroopAIVoiceChatListViewModel;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/mvi/a;", "Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/mvi/b;", "", "R1", "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "voice", "P1", "userIntent", "U1", "", BdhLogUtil.LogTag.Tag_Conn, "J", "troopUin", "", "D", "I", "voiceType", "", "Lcom/tencent/qqnt/kernel/nativeinterface/VoicePair;", "E", "Ljava/util/List;", "dataList", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/mvi/b;", "T1", "()Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/mvi/b;", "mNoneValueIntent", "<init>", "(JI)V", "G", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopAIVoiceChatListViewModel extends BaseViewModel<a, b> {

    /* renamed from: C, reason: from kotlin metadata */
    private final long troopUin;

    /* renamed from: D, reason: from kotlin metadata */
    private final int voiceType;

    /* renamed from: E, reason: from kotlin metadata */
    private List<VoicePair> dataList = new ArrayList();

    /* renamed from: F, reason: from kotlin metadata */
    private final b mNoneValueIntent = b.c.f293914a;

    public TroopAIVoiceChatListViewModel(long j3, int i3) {
        this.troopUin = j3;
        this.voiceType = i3;
    }

    private final void P1(VoiceItem voice) {
        SaveVoiceReq saveVoiceReq = new SaveVoiceReq();
        saveVoiceReq.groupCode = this.troopUin;
        int i3 = this.voiceType;
        if (i3 == 0) {
            saveVoiceReq.chatType = AIVoiceChatType.KAIVOICECHATTYPEUNKNOWN;
        } else if (i3 == 1) {
            saveVoiceReq.chatType = AIVoiceChatType.KAIVOICECHATTYPESOUND;
        } else if (i3 == 2) {
            saveVoiceReq.chatType = AIVoiceChatType.KAIVOICECHATTYPESING;
        }
        saveVoiceReq.choosedVoiceId = voice.voiceId;
        s c16 = f.c();
        if (c16 != null) {
            c16.saveAIVoice(saveVoiceReq, new ISaveVoiceCallback() { // from class: com.tencent.mobileqq.troop.aivoicechat.voicelist.mvi.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISaveVoiceCallback
                public final void onResult(int i16, String str, SaveVoiceRsp saveVoiceRsp) {
                    TroopAIVoiceChatListViewModel.Q1(i16, str, saveVoiceRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(int i3, String str, SaveVoiceRsp saveVoiceRsp) {
        QLog.i("TroopAIVoiceChatListViewModel", 1, "[saveAIVoice] errCode: " + i3 + " errMsg: " + str);
        if (i3 == 0) {
            IBusManager iBusManager = (IBusManager) QRoute.api(IBusManager.class);
            ArrayList<VoiceItem> arrayList = saveVoiceRsp.voiceList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.voiceList");
            iBusManager.sendEvent(new bs2.a(arrayList));
        }
    }

    private final void R1() {
        ListAllVoiceReq listAllVoiceReq = new ListAllVoiceReq();
        listAllVoiceReq.groupCode = this.troopUin;
        int i3 = this.voiceType;
        if (i3 == 0) {
            listAllVoiceReq.chatType = AIVoiceChatType.KAIVOICECHATTYPEUNKNOWN;
        } else if (i3 == 1) {
            listAllVoiceReq.chatType = AIVoiceChatType.KAIVOICECHATTYPESOUND;
        } else if (i3 == 2) {
            listAllVoiceReq.chatType = AIVoiceChatType.KAIVOICECHATTYPESING;
        }
        s c16 = f.c();
        if (c16 != null) {
            c16.listAllAIVoice(listAllVoiceReq, new IListAllVoiceCallback() { // from class: com.tencent.mobileqq.troop.aivoicechat.voicelist.mvi.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IListAllVoiceCallback
                public final void onResult(int i16, String str, ListAllVoiceRsp listAllVoiceRsp) {
                    TroopAIVoiceChatListViewModel.S1(TroopAIVoiceChatListViewModel.this, i16, str, listAllVoiceRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(final TroopAIVoiceChatListViewModel this$0, int i3, String str, ListAllVoiceRsp listAllVoiceRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("TroopAIVoiceChatListViewModel", 1, "[listAllAIVoice] errCode: " + i3 + " errMsg: " + str + " list.size: " + listAllVoiceRsp.voiceMap.size());
        ArrayList<VoicePair> arrayList = listAllVoiceRsp.voiceMap;
        Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.voiceMap");
        this$0.dataList = arrayList;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            this$0.getMUiState().setValue(new a.NoticeListUpdate(this$0.dataList));
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.aivoicechat.voicelist.mvi.TroopAIVoiceChatListViewModel$fetchVoiceList$lambda$2$$inlined$runOnUiThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    TroopAIVoiceChatListViewModel.this.getMUiState().setValue(new a.NoticeListUpdate(TroopAIVoiceChatListViewModel.this.dataList));
                }
            });
        }
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: T1, reason: from getter */
    public b getMNoneValueIntent() {
        return this.mNoneValueIntent;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(b userIntent) {
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.C8672b) {
            R1();
        } else if (userIntent instanceof b.AddVoice) {
            P1(((b.AddVoice) userIntent).getVoice());
        }
    }
}
