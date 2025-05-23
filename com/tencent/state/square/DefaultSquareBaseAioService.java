package com.tencent.state.square;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.api.PttMessage;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareMiniAioMultiSelectedRecord;
import com.tencent.state.square.api.UnreadMessageObserver;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.remote.ServiceConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016JC\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2)\u0010\u0012\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013H\u0016JG\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\r2%\u0010\u0012\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\rH\u0016Js\u0010 \u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\n2#\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013H\u0016J4\u0010*\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001b2\b\u0010.\u001a\u0004\u0018\u00010\nH\u0016J*\u0010/\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\nH\u0016J*\u00103\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0018\u00108\u001a\b\u0012\u0004\u0012\u0002050\u00142\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0018\u00109\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u001bH\u0016\u00a8\u0006<"}, d2 = {"Lcom/tencent/state/square/DefaultSquareBaseAioService;", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "()V", "addUnreadMessageObserver", "", "observer", "Lcom/tencent/state/square/api/UnreadMessageObserver;", "deleteUnreadMessageObserver", "destroy", "getName", "", "uin", "messageRecordType", "Lcom/tencent/state/square/api/MessageRecordType;", "getRecentMsgListSyncAioTable", "limitNum", "", "type", "callback", "Lkotlin/Function1;", "", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "Lkotlin/ParameterName;", "name", "msg", "getSingleUnreadMsg", "includeUnNotifyMsg", "", "init", IProfileProtocolConst.PARAM_IS_FRIEND, "isInShieldList", "isReceiveNotify", "openMiniMsgAio", "fragment", "Landroidx/fragment/app/Fragment;", "scene", "needShowKeyboard", ServiceConst.EXTRA_NEEDCALLBACK, "message", "Lcom/tencent/state/square/api/PttMessage;", "nick", "success", "openMiniSelectPage", QzoneIPCModule.RESULT_CODE, "multiSelect", "needTroop", "title", "openReportPage", "eviluin", "srv_Para", TPReportKeys.LiveExKeys.LIVE_EX_CONTENT_ID, "openSettingsPage", "pareSingleSelectUinInfo", "Lcom/tencent/state/square/api/SquareMiniAioMultiSelectedRecord;", "intent", "Landroid/content/Intent;", "parseMultiSelectedUinInfo", "setShieldList", "isShield", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public class DefaultSquareBaseAioService implements ISquareBaseMessageService {
    private static final String TAG = "DefaultSquareBaseAioService";

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void addUnreadMessageObserver(@NotNull UnreadMessageObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void deleteUnreadMessageObserver(@NotNull UnreadMessageObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    @NotNull
    public String getName(@NotNull String uin, @NotNull MessageRecordType messageRecordType) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(messageRecordType, "messageRecordType");
        return "";
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void getRecentMsgListSyncAioTable(int limitNum, @NotNull MessageRecordType type, @Nullable Function1<? super List<? extends SquareBaseMessageRecord>, Unit> callback) {
        List emptyList;
        Intrinsics.checkNotNullParameter(type, "type");
        if (callback != null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            callback.invoke(emptyList);
        }
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void getSingleUnreadMsg(@NotNull String uin, boolean includeUnNotifyMsg, @NotNull MessageRecordType type, @Nullable Function1<? super SquareBaseMessageRecord, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
        if (callback != null) {
            callback.invoke(null);
        }
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public boolean isFriend(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return false;
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public boolean isInShieldList(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return false;
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public boolean isReceiveNotify(@NotNull String uin, @NotNull MessageRecordType type) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
        return false;
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void openMiniMsgAio(@Nullable Fragment fragment, int scene, @NotNull String uin, @NotNull MessageRecordType type, boolean needShowKeyboard, boolean needCallback, @Nullable PttMessage message, @Nullable String nick, @Nullable Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
        SquareBaseKt.getSquareLog().d(TAG, "openMiniMsgAio uin:" + uin);
        if (callback != null) {
            callback.invoke(Boolean.TRUE);
        }
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void openMiniSelectPage(@Nullable Fragment fragment, int resultCode, boolean multiSelect, boolean needTroop, @Nullable String title) {
        SquareBaseKt.getSquareLog().d(TAG, "openMiniSelectPage resultCode:" + resultCode);
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void openReportPage(@Nullable Fragment fragment, @NotNull String eviluin, @NotNull String srv_Para, @NotNull String contentid) {
        Intrinsics.checkNotNullParameter(eviluin, "eviluin");
        Intrinsics.checkNotNullParameter(srv_Para, "srv_Para");
        Intrinsics.checkNotNullParameter(contentid, "contentid");
        SquareBaseKt.getSquareLog().d(TAG, "openReportPage QQzhuangtaiguangchang groupconversation");
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void openSettingsPage(@Nullable Fragment fragment, int scene, @NotNull String uin, @NotNull MessageRecordType type) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    @NotNull
    public SquareMiniAioMultiSelectedRecord pareSingleSelectUinInfo(@Nullable Intent intent) {
        String str;
        if (intent == null || (str = intent.getStringExtra("uin")) == null) {
            str = "";
        }
        return new SquareMiniAioMultiSelectedRecord(str, 0);
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    @NotNull
    public List<SquareMiniAioMultiSelectedRecord> parseMultiSelectedUinInfo(@Nullable Intent intent) {
        List<SquareMiniAioMultiSelectedRecord> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void setShieldList(@NotNull String uin, boolean isShield) {
        Intrinsics.checkNotNullParameter(uin, "uin");
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void destroy() {
    }

    @Override // com.tencent.state.square.api.ISquareBaseMessageService
    public void init() {
    }
}
