package com.tencent.state.square.api;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.remote.ServiceConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&JG\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\f2)\u0010\u0011\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012H&JK\u0010\u0018\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0010\u001a\u00020\f2%\u0010\u0011\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012H&J\b\u0010\u001b\u001a\u00020\u0003H&J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\tH&J\u0018\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\fH&J\u007f\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020\u001a2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\t2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012H&J6\u0010)\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001a2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\tH&J*\u0010.\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH&J,\u00102\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\fH&J\u0012\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H&J\u0018\u00107\u001a\b\u0012\u0004\u0012\u0002040\u00132\b\u00105\u001a\u0004\u0018\u000106H&J\u0018\u00108\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u00109\u001a\u00020\u001aH&\u00a8\u0006:"}, d2 = {"Lcom/tencent/state/square/api/ISquareBaseMessageService;", "", "addUnreadMessageObserver", "", "observer", "Lcom/tencent/state/square/api/UnreadMessageObserver;", "deleteUnreadMessageObserver", "destroy", "getName", "", "uin", "messageRecordType", "Lcom/tencent/state/square/api/MessageRecordType;", "getRecentMsgListSyncAioTable", "limitNum", "", "type", "callback", "Lkotlin/Function1;", "", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "Lkotlin/ParameterName;", "name", "msg", "getSingleUnreadMsg", "includeUnNotifyMsg", "", "init", IProfileProtocolConst.PARAM_IS_FRIEND, "isInShieldList", "isReceiveNotify", "openMiniMsgAio", "fragment", "Landroidx/fragment/app/Fragment;", "scene", "needShowKeyboard", ServiceConst.EXTRA_NEEDCALLBACK, "message", "Lcom/tencent/state/square/api/PttMessage;", "nickname", "success", "openMiniSelectPage", QzoneIPCModule.RESULT_CODE, "multiSelect", "needTroop", "title", "openReportPage", "eviluin", "srv_Para", TPReportKeys.LiveExKeys.LIVE_EX_CONTENT_ID, "openSettingsPage", "pareSingleSelectUinInfo", "Lcom/tencent/state/square/api/SquareMiniAioMultiSelectedRecord;", "intent", "Landroid/content/Intent;", "parseMultiSelectedUinInfo", "setShieldList", "isShield", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ISquareBaseMessageService {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getRecentMsgListSyncAioTable$default(ISquareBaseMessageService iSquareBaseMessageService, int i3, MessageRecordType messageRecordType, Function1 function1, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 1) != 0) {
                    i3 = 40;
                }
                if ((i16 & 2) != 0) {
                    messageRecordType = MessageRecordType.RECORD_TYPE_FRIEND;
                }
                iSquareBaseMessageService.getRecentMsgListSyncAioTable(i3, messageRecordType, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRecentMsgListSyncAioTable");
        }

        public static /* synthetic */ void getSingleUnreadMsg$default(ISquareBaseMessageService iSquareBaseMessageService, String str, boolean z16, MessageRecordType messageRecordType, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                if ((i3 & 4) != 0) {
                    messageRecordType = MessageRecordType.RECORD_TYPE_FRIEND;
                }
                iSquareBaseMessageService.getSingleUnreadMsg(str, z16, messageRecordType, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSingleUnreadMsg");
        }

        public static /* synthetic */ void openMiniMsgAio$default(ISquareBaseMessageService iSquareBaseMessageService, Fragment fragment, int i3, String str, MessageRecordType messageRecordType, boolean z16, boolean z17, PttMessage pttMessage, String str2, Function1 function1, int i16, Object obj) {
            MessageRecordType messageRecordType2;
            boolean z18;
            boolean z19;
            PttMessage pttMessage2;
            String str3;
            Function1 function12;
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    messageRecordType2 = MessageRecordType.RECORD_TYPE_NONE;
                } else {
                    messageRecordType2 = messageRecordType;
                }
                if ((i16 & 16) != 0) {
                    z18 = false;
                } else {
                    z18 = z16;
                }
                if ((i16 & 32) != 0) {
                    z19 = false;
                } else {
                    z19 = z17;
                }
                if ((i16 & 64) != 0) {
                    pttMessage2 = null;
                } else {
                    pttMessage2 = pttMessage;
                }
                if ((i16 & 128) != 0) {
                    str3 = null;
                } else {
                    str3 = str2;
                }
                if ((i16 & 256) != 0) {
                    function12 = null;
                } else {
                    function12 = function1;
                }
                iSquareBaseMessageService.openMiniMsgAio(fragment, i3, str, messageRecordType2, z18, z19, pttMessage2, str3, function12);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openMiniMsgAio");
        }

        public static /* synthetic */ void openMiniSelectPage$default(ISquareBaseMessageService iSquareBaseMessageService, Fragment fragment, int i3, boolean z16, boolean z17, String str, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 16) != 0) {
                    str = null;
                }
                iSquareBaseMessageService.openMiniSelectPage(fragment, i3, z16, z17, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openMiniSelectPage");
        }

        public static /* synthetic */ void openSettingsPage$default(ISquareBaseMessageService iSquareBaseMessageService, Fragment fragment, int i3, String str, MessageRecordType messageRecordType, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    messageRecordType = MessageRecordType.RECORD_TYPE_NONE;
                }
                iSquareBaseMessageService.openSettingsPage(fragment, i3, str, messageRecordType);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openSettingsPage");
        }
    }

    void addUnreadMessageObserver(@NotNull UnreadMessageObserver observer);

    void deleteUnreadMessageObserver(@NotNull UnreadMessageObserver observer);

    void destroy();

    @NotNull
    String getName(@NotNull String uin, @NotNull MessageRecordType messageRecordType);

    void getRecentMsgListSyncAioTable(int limitNum, @NotNull MessageRecordType type, @Nullable Function1<? super List<? extends SquareBaseMessageRecord>, Unit> callback);

    void getSingleUnreadMsg(@NotNull String uin, boolean includeUnNotifyMsg, @NotNull MessageRecordType type, @Nullable Function1<? super SquareBaseMessageRecord, Unit> callback);

    void init();

    boolean isFriend(@NotNull String uin);

    boolean isInShieldList(@NotNull String uin);

    boolean isReceiveNotify(@NotNull String uin, @NotNull MessageRecordType type);

    void openMiniMsgAio(@Nullable Fragment fragment, int scene, @NotNull String uin, @NotNull MessageRecordType type, boolean needShowKeyboard, boolean needCallback, @Nullable PttMessage message, @Nullable String nickname, @Nullable Function1<? super Boolean, Unit> callback);

    void openMiniSelectPage(@Nullable Fragment fragment, int resultCode, boolean multiSelect, boolean needTroop, @Nullable String title);

    void openReportPage(@Nullable Fragment fragment, @NotNull String eviluin, @NotNull String srv_Para, @NotNull String contentid);

    void openSettingsPage(@Nullable Fragment fragment, int scene, @NotNull String uin, @NotNull MessageRecordType type);

    @NotNull
    SquareMiniAioMultiSelectedRecord pareSingleSelectUinInfo(@Nullable Intent intent);

    @NotNull
    List<SquareMiniAioMultiSelectedRecord> parseMultiSelectedUinInfo(@Nullable Intent intent);

    void setShieldList(@NotNull String uin, boolean isShield);
}
