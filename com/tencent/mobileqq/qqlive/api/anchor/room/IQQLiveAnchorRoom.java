package com.tencent.mobileqq.qqlive.api.anchor.room;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallbackRegister;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.report.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveAnchorRoom extends ILiveRoom, IQQLiveAnchorRoomCallbackRegister {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class LinkMicType {
        private static final /* synthetic */ LinkMicType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final LinkMicType MultiAvChat;
        public static final LinkMicType Others;
        public String value;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32302);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            LinkMicType linkMicType = new LinkMicType("Others", 0, "0");
            Others = linkMicType;
            LinkMicType linkMicType2 = new LinkMicType("MultiAvChat", 1, "1");
            MultiAvChat = linkMicType2;
            $VALUES = new LinkMicType[]{linkMicType, linkMicType2};
        }

        LinkMicType(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
            } else {
                this.value = str2;
            }
        }

        public static LinkMicType valueOf(String str) {
            return (LinkMicType) Enum.valueOf(LinkMicType.class, str);
        }

        public static LinkMicType[] values() {
            return (LinkMicType[]) $VALUES.clone();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void clearReportCallback();

    QQLiveAnchorRoomState currentState();

    void enterRoom();

    void fastResume();

    QQLiveAnchorRoomInfo getAnchorRoomInfo();

    byte[] getAuthExt(String str);

    QQLiveAnchorRoomConfig getRoomConfig();

    void prepare(Activity activity, byte[] bArr);

    void recordRoomInfo();

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void registerReportCallback(a aVar);

    void setAnchorRoomConfig(QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig);

    void setAnchorRoomInfo(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo);

    void startPublishStream();

    void startSet(QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr, byte[] bArr);

    @Override // com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    /* synthetic */ void unRegisterReportCallback(a aVar);

    void updateLinkMicType(LinkMicType linkMicType);
}
