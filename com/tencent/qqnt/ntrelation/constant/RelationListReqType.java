package com.tencent.qqnt.ntrelation.constant;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/ntrelation/constant/RelationListReqType;", "", "(Ljava/lang/String;I)V", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, "LETTER", "contacts_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class RelationListReqType {
    private static final /* synthetic */ RelationListReqType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final RelationListReqType LETTER;
    public static final RelationListReqType NORMAL;

    private static final /* synthetic */ RelationListReqType[] $values() {
        return new RelationListReqType[]{NORMAL, LETTER};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37276);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NORMAL = new RelationListReqType(QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, 0);
        LETTER = new RelationListReqType("LETTER", 1);
        $VALUES = $values();
    }

    RelationListReqType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static RelationListReqType valueOf(String str) {
        return (RelationListReqType) Enum.valueOf(RelationListReqType.class, str);
    }

    public static RelationListReqType[] values() {
        return (RelationListReqType[]) $VALUES.clone();
    }
}
