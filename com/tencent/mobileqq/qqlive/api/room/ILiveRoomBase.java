package com.tencent.mobileqq.qqlive.api.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface ILiveRoomBase extends IQQLiveModule {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class ServiceType {
        private static final /* synthetic */ ServiceType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ServiceType DATA;
        public static final ServiceType PUSH;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50015);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ServiceType serviceType = new ServiceType("PUSH", 0);
            PUSH = serviceType;
            ServiceType serviceType2 = new ServiceType("DATA", 1);
            DATA = serviceType2;
            $VALUES = new ServiceType[]{serviceType, serviceType2};
        }

        ServiceType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ServiceType valueOf(String str) {
            return (ServiceType) Enum.valueOf(ServiceType.class, str);
        }

        public static ServiceType[] values() {
            return (ServiceType[]) $VALUES.clone();
        }
    }

    void exitRoom(ExitRoomCallback exitRoomCallback);

    BaseAnchorInfo getAnchorInfo();

    BaseRoomInfo getRoomInfo();

    boolean isDestroyed();

    boolean isExitRoom();

    boolean isInited();
}
