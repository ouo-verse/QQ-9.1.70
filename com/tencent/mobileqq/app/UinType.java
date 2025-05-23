package com.tencent.mobileqq.app;

import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class UinType {
    private static final /* synthetic */ UinType[] $VALUES;
    static IPatchRedirector $redirector_;
    private static final SparseArray<UinType> S_ID_INSTANCE_MAP;
    public static final UinType TEMP_GAME_MSG;

    /* renamed from: id, reason: collision with root package name */
    private final int f195164id;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38031);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        int i3 = 0;
        UinType uinType = new UinType("TEMP_GAME_MSG", i3, 10007) { // from class: com.tencent.mobileqq.app.UinType.1
            static IPatchRedirector $redirector_;

            {
                super(r5, i3, r7, null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, r5, Integer.valueOf(i3), Integer.valueOf(r7));
                }
            }

            @Override // com.tencent.mobileqq.app.UinType
            public boolean isC2CConversation() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                return true;
            }

            @Override // com.tencent.mobileqq.app.UinType
            public boolean isInvalidUinTypeWhenRefresh() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
                }
                return false;
            }
        };
        TEMP_GAME_MSG = uinType;
        $VALUES = new UinType[]{uinType};
        S_ID_INSTANCE_MAP = new SparseArray<>();
        UinType[] values = values();
        int length = values.length;
        while (i3 < length) {
            UinType uinType2 = values[i3];
            S_ID_INSTANCE_MAP.put(uinType2.f195164id, uinType2);
            i3++;
        }
    }

    /* synthetic */ UinType(String str, int i3, int i16, AnonymousClass1 anonymousClass1) {
        this(str, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), anonymousClass1);
    }

    public static UinType valueOf(String str) {
        return (UinType) Enum.valueOf(UinType.class, str);
    }

    public static UinType[] values() {
        return (UinType[]) $VALUES.clone();
    }

    public abstract boolean isC2CConversation();

    public abstract boolean isInvalidUinTypeWhenRefresh();

    UinType(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f195164id = i16;
        } else {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public static UinType valueOf(int i3) {
        return S_ID_INSTANCE_MAP.get(i3);
    }
}
