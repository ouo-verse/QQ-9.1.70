package com.tencent.mobileqq.troop.troopsetting.modules.memberface;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/memberface/TroopMemberFaceUpdateSource;", "", "(Ljava/lang/String;I)V", "NETWORK_REQUEST_0X899", "UPDATE_TROOP_INFO", "DELETE_MEMBER_HOST", "DELETE_MEMBER_BROADCAST", "BATCH_FETCH_TROOP_INFO", "HW_TROOP_MODIFY", "RESULT_CODE_MEMBER_LIST", "RESULT_CODE_TROOP_MANAGE", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopMemberFaceUpdateSource {
    private static final /* synthetic */ TroopMemberFaceUpdateSource[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TroopMemberFaceUpdateSource BATCH_FETCH_TROOP_INFO;
    public static final TroopMemberFaceUpdateSource DELETE_MEMBER_BROADCAST;
    public static final TroopMemberFaceUpdateSource DELETE_MEMBER_HOST;
    public static final TroopMemberFaceUpdateSource HW_TROOP_MODIFY;
    public static final TroopMemberFaceUpdateSource NETWORK_REQUEST_0X899;
    public static final TroopMemberFaceUpdateSource RESULT_CODE_MEMBER_LIST;
    public static final TroopMemberFaceUpdateSource RESULT_CODE_TROOP_MANAGE;
    public static final TroopMemberFaceUpdateSource UPDATE_TROOP_INFO;

    private static final /* synthetic */ TroopMemberFaceUpdateSource[] $values() {
        return new TroopMemberFaceUpdateSource[]{NETWORK_REQUEST_0X899, UPDATE_TROOP_INFO, DELETE_MEMBER_HOST, DELETE_MEMBER_BROADCAST, BATCH_FETCH_TROOP_INFO, HW_TROOP_MODIFY, RESULT_CODE_MEMBER_LIST, RESULT_CODE_TROOP_MANAGE};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60248);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NETWORK_REQUEST_0X899 = new TroopMemberFaceUpdateSource("NETWORK_REQUEST_0X899", 0);
        UPDATE_TROOP_INFO = new TroopMemberFaceUpdateSource("UPDATE_TROOP_INFO", 1);
        DELETE_MEMBER_HOST = new TroopMemberFaceUpdateSource("DELETE_MEMBER_HOST", 2);
        DELETE_MEMBER_BROADCAST = new TroopMemberFaceUpdateSource("DELETE_MEMBER_BROADCAST", 3);
        BATCH_FETCH_TROOP_INFO = new TroopMemberFaceUpdateSource("BATCH_FETCH_TROOP_INFO", 4);
        HW_TROOP_MODIFY = new TroopMemberFaceUpdateSource("HW_TROOP_MODIFY", 5);
        RESULT_CODE_MEMBER_LIST = new TroopMemberFaceUpdateSource("RESULT_CODE_MEMBER_LIST", 6);
        RESULT_CODE_TROOP_MANAGE = new TroopMemberFaceUpdateSource("RESULT_CODE_TROOP_MANAGE", 7);
        $VALUES = $values();
    }

    TroopMemberFaceUpdateSource(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static TroopMemberFaceUpdateSource valueOf(String str) {
        return (TroopMemberFaceUpdateSource) Enum.valueOf(TroopMemberFaceUpdateSource.class, str);
    }

    public static TroopMemberFaceUpdateSource[] values() {
        return (TroopMemberFaceUpdateSource[]) $VALUES.clone();
    }
}
