package com.tencent.mobileqq.selectfriend.relationlist.vm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/relationlist/vm/ListType;", "", "(Ljava/lang/String;I)V", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, "GROUPED", "INDEXED", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class ListType {
    private static final /* synthetic */ ListType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ListType GROUPED;
    public static final ListType INDEXED;
    public static final ListType NORMAL;

    private static final /* synthetic */ ListType[] $values() {
        return new ListType[]{NORMAL, GROUPED, INDEXED};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23719);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NORMAL = new ListType(QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, 0);
        GROUPED = new ListType("GROUPED", 1);
        INDEXED = new ListType("INDEXED", 2);
        $VALUES = $values();
    }

    ListType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static ListType valueOf(String str) {
        return (ListType) Enum.valueOf(ListType.class, str);
    }

    public static ListType[] values() {
        return (ListType[]) $VALUES.clone();
    }
}
