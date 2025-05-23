package com.tencent.mobileqq.guild.guildtab.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.logic.a;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.GuildMsgAbFlag;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.ImportOldDbMsgNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0017H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\u000f\u0010\u001d\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u001f\u0010\u001eJ\u000e\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\bJ\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\bR\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00130)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010+R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/guildtab/impl/GuildUserServiceImpl;", "Lcom/tencent/mobileqq/logic/a;", "Lcom/tencent/mobileqq/guild/guildtab/IGuildUserService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "Lcom/tencent/mobileqq/guild/guildtab/IGuildUserService$GuildUser;", "refreshAndGetGuildUser", "", "notifyListeners", "", "type", "", "isSuccess", "", "data", "onReceive", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/guildtab/IGuildUserService$c;", "listener", "addListener", "removeListener", "Lcom/tencent/mobileqq/guild/guildtab/IGuildUserService$b;", "isGuildTabSetting", "Lcom/tencent/qqnt/kernel/nativeinterface/GuildMsgAbFlag;", "guildMode", "guildUser", "guildUserCached", "getGuildUDCFlag", "()Ljava/lang/Integer;", "getGroupGuildFlag", "flag", "setGuildUDCFlag", "setGroupGuildFlag", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mEntity", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lcom/tencent/common/app/AppInterface;", "mApp", "Lcom/tencent/common/app/AppInterface;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mGuildTabListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mGuildModeListeners", "mGuildUser", "Lcom/tencent/mobileqq/guild/guildtab/IGuildUserService$GuildUser;", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildUserServiceImpl extends a implements IGuildUserService, IKernelMsgListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "Guild.tab.GuildTabServiceImpl";
    private AppInterface mApp;

    @NotNull
    private final MMKVOptionEntity mEntity;

    @NotNull
    private final CopyOnWriteArraySet<IGuildUserService.b> mGuildModeListeners;

    @NotNull
    private final CopyOnWriteArraySet<IGuildUserService.c> mGuildTabListeners;

    @NotNull
    private IGuildUserService.GuildUser mGuildUser;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/guildtab/impl/GuildUserServiceImpl$a;", "", "", "d", "()Ljava/lang/String;", "GUILD_UDC_KEY_WITH_UIN", "c", "GROUP_GUILD_UDC_KEY_WITH_UIN", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.guildtab.impl.GuildUserServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String c() {
            String keyWithUin = QMMKVFile.getKeyWithUin(QMMKVFile.FILE_GUILD, "GROUP_GUILD_UDC_FLAG");
            Intrinsics.checkNotNullExpressionValue(keyWithUin, "getKeyWithUin(FILE_GUILD, \"GROUP_GUILD_UDC_FLAG\")");
            return keyWithUin;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String d() {
            String keyWithUin = QMMKVFile.getKeyWithUin(QMMKVFile.FILE_GUILD, "GUILD_UDC_FLAG");
            Intrinsics.checkNotNullExpressionValue(keyWithUin, "getKeyWithUin(FILE_GUILD, \"GUILD_UDC_FLAG\")");
            return keyWithUin;
        }

        Companion() {
        }
    }

    public GuildUserServiceImpl() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, FILE_GUILD)");
        this.mEntity = from;
        this.mGuildTabListeners = new CopyOnWriteArraySet<>();
        this.mGuildModeListeners = new CopyOnWriteArraySet<>();
        this.mGuildUser = IGuildUserService.GuildUser.UNDEFINED;
    }

    private final void notifyListeners() {
        boolean isGuildUser = isGuildUser();
        QLog.i(TAG, 1, "notifyListeners, value=" + isGuildUser);
        Iterator<T> it = this.mGuildTabListeners.iterator();
        while (it.hasNext()) {
            ((IGuildUserService.c) it.next()).b(isGuildUser);
        }
    }

    private final IGuildUserService.GuildUser refreshAndGetGuildUser() {
        boolean z16;
        IGuildUserService.GuildUser guildUser;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        AppInterface appInterface = this.mApp;
        Integer num = null;
        if (appInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            appInterface = null;
        }
        Map<String, Integer> tabSwitch = TabDataHelper.getTabSwitch(mobileQQ, appInterface.getCurrentUin(), TabDataHelper.SCENE_GUILD_USER);
        if (tabSwitch != null) {
            num = tabSwitch.get("GUILD");
        }
        if (num == null) {
            Logger.f235387a.d().i(TAG, 1, "isGuildUser, tabValue is null");
            return IGuildUserService.GuildUser.UNDEFINED;
        }
        if (num.intValue() != 2 && num.intValue() != 3) {
            z16 = false;
        } else {
            z16 = true;
        }
        int intValue = getGuildUDCFlag().intValue();
        if (!z16 && intValue == -1) {
            guildUser = IGuildUserService.GuildUser.UNDEFINED;
        } else if (!z16 && intValue != 1) {
            guildUser = IGuildUserService.GuildUser.FALSE;
        } else {
            guildUser = IGuildUserService.GuildUser.TRUE;
        }
        this.mGuildUser = guildUser;
        return guildUser;
    }

    @Override // com.tencent.mobileqq.guild.guildtab.IGuildUserService
    public boolean addListener(@NotNull IGuildUserService.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.mGuildTabListeners.add(listener);
    }

    @Override // com.tencent.mobileqq.guild.guildtab.IGuildUserService
    @NotNull
    public Integer getGroupGuildFlag() {
        return Integer.valueOf(this.mEntity.decodeInt(INSTANCE.c(), -1));
    }

    @Override // com.tencent.mobileqq.guild.guildtab.IGuildUserService
    @NotNull
    public Integer getGuildUDCFlag() {
        return Integer.valueOf(this.mEntity.decodeInt(INSTANCE.d(), -1));
    }

    @Override // com.tencent.mobileqq.guild.guildtab.IGuildUserService
    @NotNull
    public GuildMsgAbFlag guildMode() {
        return GuildMsgAbFlag.KSIMPLEMODEL;
    }

    @Override // com.tencent.mobileqq.guild.guildtab.IGuildUserService
    @NotNull
    public IGuildUserService.GuildUser guildUser() {
        return refreshAndGetGuildUser();
    }

    @Override // com.tencent.mobileqq.guild.guildtab.IGuildUserService
    @NotNull
    public IGuildUserService.GuildUser guildUserCached() {
        IGuildUserService.GuildUser guildUser = this.mGuildUser;
        if (guildUser == IGuildUserService.GuildUser.UNDEFINED) {
            return guildUser();
        }
        return guildUser;
    }

    @Override // com.tencent.mobileqq.guild.guildtab.IGuildUserService
    public boolean isGuildTabSetting() {
        Integer num;
        boolean contains$default;
        boolean z16;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            appInterface = null;
        }
        Map<String, Integer> tabSwitch = TabDataHelper.getTabSwitch(mobileQQ, appInterface.getCurrentUin(), TabDataHelper.SCENE_BOTTOM_TAB_SETTING);
        if (tabSwitch != null) {
            num = tabSwitch.get("GUILD");
        } else {
            num = null;
        }
        MobileQQ mobileQQ2 = MobileQQ.sMobileQQ;
        AppInterface appInterface2 = this.mApp;
        if (appInterface2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            appInterface2 = null;
        }
        String allTabListCacheString = TabDataHelper.getTabRuleList(mobileQQ2, appInterface2.getCurrentUin(), TabDataHelper.getModelType());
        Intrinsics.checkNotNullExpressionValue(allTabListCacheString, "allTabListCacheString");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) allTabListCacheString, (CharSequence) "GUILD", false, 2, (Object) null);
        if (contains$default && num != null && (num.intValue() == 2 || num.intValue() == 3)) {
            if (num.intValue() == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            int intValue = getGuildUDCFlag().intValue();
            if (!z16 && intValue != 1) {
                return false;
            }
            return true;
        }
        Logger.f235387a.d().i(TAG, 1, "isGuildUser, tabValue isSwitchHide is null");
        return false;
    }

    @Override // com.tencent.mobileqq.guild.guildtab.IGuildUserService
    public boolean isGuildUser() {
        return IGuildUserService.a.a(this);
    }

    @Override // com.tencent.mobileqq.guild.guildtab.IGuildUserService
    public boolean isGuildUserCached() {
        return IGuildUserService.a.b(this);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
        ax.a(this, msgRecord);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onContactUnreadCntUpdate(HashMap hashMap) {
        ax.b(this, hashMap);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        AppInterface appInterface = (AppInterface) appRuntime;
        this.mApp = appInterface;
        if (appInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            appInterface = null;
        }
        appInterface.addObserver(this);
        refreshAndGetGuildUser();
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig) {
        ax.c(this, customWithdrawConfig);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            appInterface = null;
        }
        appInterface.removeObserver(this);
        this.mGuildTabListeners.clear();
        this.mGuildModeListeners.clear();
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onDraftUpdate(Contact contact, ArrayList arrayList, long j3) {
        ax.d(this, contact, arrayList, j3);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onEmojiDownloadComplete(EmojiNotifyInfo emojiNotifyInfo) {
        ax.e(this, emojiNotifyInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo) {
        ax.f(this, emojiResourceInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onFileMsgCome(ArrayList arrayList) {
        ax.g(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onGrabPasswordRedBag(int i3, String str, int i16, RecvdOrder recvdOrder, MsgRecord msgRecord) {
        ax.h(this, i3, str, i16, recvdOrder, msgRecord);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onGroupFileInfoAdd(GroupItem groupItem) {
        ax.i(this, groupItem);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onGroupFileInfoUpdate(GroupFileListResult groupFileListResult) {
        ax.j(this, groupFileListResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onGroupTransferInfoAdd(GroupItem groupItem) {
        ax.k(this, groupItem);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onGroupTransferInfoUpdate(GroupFileListResult groupFileListResult) {
        ax.l(this, groupFileListResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onHitCsRelatedEmojiResult(DownloadRelateEmojiResultInfo downloadRelateEmojiResultInfo) {
        ax.m(this, downloadRelateEmojiResultInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onHitEmojiKeywordResult(HitRelatedEmojiWordsResult hitRelatedEmojiWordsResult) {
        ax.n(this, hitRelatedEmojiWordsResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onHitRelatedEmojiResult(RelatedWordEmojiInfo relatedWordEmojiInfo) {
        ax.o(this, relatedWordEmojiInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onImportOldDbProgressUpdate(ImportOldDbMsgNotifyInfo importOldDbMsgNotifyInfo) {
        ax.p(this, importOldDbMsgNotifyInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onInputStatusPush(InputStatusInfo inputStatusInfo) {
        ax.q(this, inputStatusInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onKickedOffLine(KickedInfo kickedInfo) {
        ax.r(this, kickedInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onLineDev(ArrayList arrayList) {
        ax.s(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onLogLevelChanged(long j3) {
        ax.t(this, j3);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMiscDataChanged(ArrayList arrayList) {
        ax.u(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMsgBoxChanged(ArrayList arrayList) {
        ax.v(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMsgDelete(Contact contact, ArrayList arrayList) {
        ax.w(this, contact, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMsgInfoListAdd(ArrayList arrayList) {
        ax.x(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMsgInfoListUpdate(ArrayList arrayList) {
        ax.y(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMsgQRCodeStatusChanged(int i3) {
        ax.z(this, i3);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMsgRecall(int i3, String str, long j3) {
        ax.A(this, i3, str, j3);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMsgSecurityNotify(MsgRecord msgRecord) {
        ax.B(this, msgRecord);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMsgSettingUpdate(MsgSetting msgSetting) {
        ax.C(this, msgSetting);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onMsgWithRichLinkInfoUpdate(ArrayList arrayList) {
        ax.D(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onNtFirstViewMsgSyncEnd() {
        ax.E(this);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onNtMsgSyncContactUnread() {
        ax.F(this);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onNtMsgSyncEnd() {
        ax.G(this);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onNtMsgSyncStart() {
        ax.H(this);
    }

    @Override // com.tencent.mobileqq.logic.a
    public void onReceive(int type, boolean isSuccess, @Nullable Object data) {
        if (!isSuccess) {
            Logger.f235387a.d().i(TAG, 1, "onReceive ERROR");
        } else {
            refreshAndGetGuildUser();
            notifyListeners();
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onRecvMsg(ArrayList arrayList) {
        ax.I(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onRecvMsgSvrRspTransInfo(long j3, Contact contact, int i3, int i16, String str, byte[] bArr) {
        ax.J(this, j3, contact, i3, i16, str, bArr);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
        ax.K(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onRecvSysMsg(ArrayList arrayList) {
        ax.L(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onRedTouchChanged() {
        ax.M(this);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onRichMediaDownloadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
        ax.N(this, fileTransNotifyInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onRichMediaProgerssUpdate(FileTransNotifyInfo fileTransNotifyInfo) {
        ax.O(this, fileTransNotifyInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onRichMediaUploadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
        ax.P(this, fileTransNotifyInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
        ax.Q(this, searchGroupFileResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onSendMsgError(long j3, Contact contact, int i3, String str) {
        ax.R(this, j3, contact, i3, str);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onSysMsgNotification(int i3, long j3, long j16, boolean z16, ArrayList arrayList) {
        ax.S(this, i3, j3, j16, z16, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onTempChatInfoUpdate(TempChatInfo tempChatInfo) {
        ax.T(this, tempChatInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onUserChannelTabStatusChanged(boolean z16) {
        ax.U(this, z16);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onUserOnlineStatusChanged(boolean z16) {
        ax.V(this, z16);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onUserSecQualityChanged(QueryUserSecQualityRsp queryUserSecQualityRsp) {
        ax.W(this, queryUserSecQualityRsp);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onUserTabStatusChanged(ArrayList arrayList) {
        ax.X(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onlineStatusBigIconDownloadPush(int i3, long j3, String str) {
        ax.Y(this, i3, j3, str);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
    public /* synthetic */ void onlineStatusSmallIconDownloadPush(int i3, long j3, String str) {
        ax.Z(this, i3, j3, str);
    }

    @Override // com.tencent.mobileqq.guild.guildtab.IGuildUserService
    public boolean removeListener(@NotNull IGuildUserService.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.mGuildTabListeners.remove(listener);
    }

    public final void setGroupGuildFlag(int flag) {
        this.mEntity.encodeInt(INSTANCE.c(), flag);
    }

    public final void setGuildUDCFlag(int flag) {
        this.mEntity.encodeInt(INSTANCE.d(), flag);
    }

    @Override // com.tencent.mobileqq.guild.guildtab.IGuildUserService
    public boolean addListener(@NotNull IGuildUserService.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.mGuildModeListeners.add(listener);
    }

    @Override // com.tencent.mobileqq.guild.guildtab.IGuildUserService
    public boolean removeListener(@NotNull IGuildUserService.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.mGuildModeListeners.remove(listener);
    }
}
