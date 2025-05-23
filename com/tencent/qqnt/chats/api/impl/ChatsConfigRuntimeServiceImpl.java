package com.tencent.qqnt.chats.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsConfigRuntimeService;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/ChatsConfigRuntimeServiceImpl;", "Lcom/tencent/qqnt/chats/api/IChatsConfigRuntimeService;", "", "nickUseNTOrder", "isUse", "", "updateNickUseNTOrder", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "curUin", "Ljava/lang/String;", "", "nickNameUseSwitch", "I", "<init>", "()V", "Companion", "a", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatsConfigRuntimeServiceImpl implements IChatsConfigRuntimeService {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final String CHAT_ITEM_MMKV_FILE = "q_chat_item_mmkv_file";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String NICK_USE_NT_ORDER = "nick_use_nt_order_key";

    @NotNull
    public static final String TAG = "ChatsConfigRuntimeServiceImpl";
    private static final boolean USE_NT_DEFAULT_VALUE = false;

    @NotNull
    private String curUin;
    private int nickNameUseSwitch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/ChatsConfigRuntimeServiceImpl$a;", "", "", "CHAT_ITEM_MMKV_FILE", "Ljava/lang/String;", "NICK_USE_NT_ORDER", "TAG", "", "USE_NT_DEFAULT_VALUE", "Z", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.api.impl.ChatsConfigRuntimeServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30945);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatsConfigRuntimeServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.curUin = "";
            this.nickNameUseSwitch = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void nickUseNTOrder$lambda$1$lambda$0(ChatsConfigRuntimeServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateNickUseNTOrder(FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("100838", false));
    }

    @Override // com.tencent.qqnt.chats.api.IChatsConfigRuntimeService
    public boolean nickUseNTOrder() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.nickNameUseSwitch == -1) {
            synchronized (this) {
                if (this.nickNameUseSwitch == -1) {
                    MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "q_chat_item_mmkv_file_" + this.curUin);
                    Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ,\u2026ITEM_MMKV_FILE}_$curUin\")");
                    boolean decodeBool = from.decodeBool(NICK_USE_NT_ORDER, false);
                    QLog.d(TAG, 1, "nickUseNTOrder: " + decodeBool);
                    if (decodeBool) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    this.nickNameUseSwitch = i3;
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.chats.api.impl.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            ChatsConfigRuntimeServiceImpl.nickUseNTOrder$lambda$1$lambda$0(ChatsConfigRuntimeServiceImpl.this);
                        }
                    }, 16, null, false);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        if (this.nickNameUseSwitch != 1) {
            return false;
        }
        return true;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
            return;
        }
        String str2 = null;
        if (appRuntime != null) {
            str = appRuntime.getCurrentUin();
        } else {
            str = null;
        }
        QLog.d(TAG, 1, "onCreate: " + LogUtil.wrapLogUin(str));
        if (appRuntime != null) {
            str2 = appRuntime.getCurrentUin();
        }
        if (str2 == null) {
            str2 = "";
        }
        this.curUin = str2;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            QLog.d(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IChatsConfigRuntimeService
    public void updateNickUseNTOrder(boolean isUse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, isUse);
            return;
        }
        QLog.d(TAG, 1, "updateNickUseNTOrder: " + isUse);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "q_chat_item_mmkv_file_" + this.curUin);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ,\u2026ITEM_MMKV_FILE}_$curUin\")");
        from.encodeBool(NICK_USE_NT_ORDER, isUse);
        from.commitAsync();
    }
}
