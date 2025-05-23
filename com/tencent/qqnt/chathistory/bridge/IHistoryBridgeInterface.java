package com.tencent.qqnt.chathistory.bridge;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\t\bf\u0018\u0000 \f2\u00020\u0001:\u0004\r\u000e\u000f\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J-\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\"\u00020\u0001H&\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chathistory/bridge/IHistoryBridgeInterface;", "", "Lcom/tencent/qqnt/chathistory/bridge/IHistoryBridgeInterface$b;", "listener", "", "q8", "", "action", "", "args", "invoke", "(I[Ljava/lang/Object;)Ljava/lang/Object;", "v4", "BridgeAction", "a", "b", "TroopFileActionType", "chathistory_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface IHistoryBridgeInterface {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: v4, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chathistory/bridge/IHistoryBridgeInterface$BridgeAction;", "", "Companion", "a", "chathistory_api_release"}, k = 1, mv = {1, 7, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes23.dex */
    public @interface BridgeAction {
        public static final IPatchRedirector $redirector_ = null;
        public static final int C2C_HISTORY_SETTING_ACTION = 8;
        public static final int CANCEL_MULTI = 3;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final int ENABLE_RIGHT_CLICK = 7;
        public static final int ENTER_MULTI = 2;
        public static final int GROUP_FILE = 1;
        public static final int GROUP_MEMBER_CLICK_MEMBER = 0;
        public static final int REFRESH_TITLE_RIGHT = 4;
        public static final int TROOP_FILE_CLICKABLE = 6;
        public static final int TROOP_FILE_MULTI_ACTION = 5;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chathistory/bridge/IHistoryBridgeInterface$BridgeAction$a;", "", "<init>", "()V", "chathistory_api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.chathistory.bridge.IHistoryBridgeInterface$BridgeAction$a, reason: from kotlin metadata */
        /* loaded from: classes23.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f353307a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39134);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f353307a = new Companion();
                }
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(39136), (Class<?>) BridgeAction.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                INSTANCE = Companion.f353307a;
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chathistory/bridge/IHistoryBridgeInterface$TroopFileActionType;", "", "(Ljava/lang/String;I)V", "FORWARD", "DOWNLOAD", "FAVORITE", "WEIYUN", "DELETE", "chathistory_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class TroopFileActionType {
        private static final /* synthetic */ TroopFileActionType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TroopFileActionType DELETE;
        public static final TroopFileActionType DOWNLOAD;
        public static final TroopFileActionType FAVORITE;
        public static final TroopFileActionType FORWARD;
        public static final TroopFileActionType WEIYUN;

        private static final /* synthetic */ TroopFileActionType[] $values() {
            return new TroopFileActionType[]{FORWARD, DOWNLOAD, FAVORITE, WEIYUN, DELETE};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39146);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            FORWARD = new TroopFileActionType("FORWARD", 0);
            DOWNLOAD = new TroopFileActionType("DOWNLOAD", 1);
            FAVORITE = new TroopFileActionType("FAVORITE", 2);
            WEIYUN = new TroopFileActionType("WEIYUN", 3);
            DELETE = new TroopFileActionType("DELETE", 4);
            $VALUES = $values();
        }

        TroopFileActionType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static TroopFileActionType valueOf(String str) {
            return (TroopFileActionType) Enum.valueOf(TroopFileActionType.class, str);
        }

        public static TroopFileActionType[] values() {
            return (TroopFileActionType[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chathistory/bridge/IHistoryBridgeInterface$a;", "", "<init>", "()V", "chathistory_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.bridge.IHistoryBridgeInterface$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f353308a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39142);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f353308a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J-\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u0001H&\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chathistory/bridge/IHistoryBridgeInterface$b;", "", "", "action", "", "args", "invoke", "(I[Ljava/lang/Object;)Ljava/lang/Object;", "chathistory_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface b {
        @Nullable
        Object invoke(int action, @NotNull Object... args);
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(39151), (Class<?>) IHistoryBridgeInterface.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f353308a;
        }
    }

    @Nullable
    Object invoke(int action, @NotNull Object... args);

    void q8(@NotNull b listener);
}
