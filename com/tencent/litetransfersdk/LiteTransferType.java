package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LiteTransferType {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class EChannelType {
        static IPatchRedirector $redirector_ = null;
        public static final int ChannelType_FTN = 2;
        public static final int ChannelType_MobilePhoto = 6;
        public static final int ChannelType_NFC = 1;
        public static final int ChannelType_RNFC = 3;
        public static final int ChannelType_WifiPhoto = 5;

        public EChannelType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiteTransferType.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class FileControlSubCmd {
        static IPatchRedirector $redirector_ = null;
        public static final int FileControl_Accept = 1;
        public static final int FileControl_Cancel = 3;
        public static final int FileControl_Continue = 5;
        public static final int FileControl_FileExist_Original = 7;
        public static final int FileControl_FileExist_Thumb = 6;
        public static final int FileControl_Pause = 4;
        public static final int FileControl_Refuse = 2;

        public FileControlSubCmd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiteTransferType.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class MsgBodyType {
        static IPatchRedirector $redirector_ = null;
        public static final int MsgType_0x211 = 529;
        public static final int MsgType_0x211_SubMsgType_0x7 = 7;
        public static final int MsgType_0x345 = 837;
        public static final int MsgType_0x345_SubMsgType_ApplyTransFile = 7;
        public static final int MsgType_0x346 = 838;
        public static final int MsgType_0x346_SubMsgType_0x7 = 7;
        public static final int MsgType_0x346_SubMsgType_0xe = 14;

        public MsgBodyType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiteTransferType.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class TaskStatus {
        static IPatchRedirector $redirector_ = null;
        public static final int TaskStatus_AccessError_Recv_16 = 16;
        public static final int TaskStatus_AccessError_Send_15 = 15;
        public static final int TaskStatus_CancelAccount_8 = 8;
        public static final int TaskStatus_CancelRemote_11 = 11;
        public static final int TaskStatus_Cancel_32 = 32;
        public static final int TaskStatus_Cancel_FTNComplete_30 = 30;
        public static final int TaskStatus_Cancel_NFCComplete_31 = 31;
        public static final int TaskStatus_Cancel_NFCTransfer_34 = 34;
        public static final int TaskStatus_ConnectFail_27 = 27;
        public static final int TaskStatus_File_NoExist_25 = 25;
        public static final int TaskStatus_MD5CheckFail_47 = 47;
        public static final int TaskStatus_NFC_NotConnect_26 = 26;
        public static final int TaskStatus_NetBroken_41 = 41;
        public static final int TaskStatus_NoSpace_Local_17 = 17;
        public static final int TaskStatus_Refuse_Sever_44 = 44;
        public static final int TaskStatus_RenameFail_46 = 46;
        public static final int TaskStatus_SendDataFail_FTNServerIP_39 = 39;
        public static final int TaskStatus_SendDataFail_FTN_36 = 36;
        public static final int TaskStatus_SendDataFail_NFC_35 = 35;
        public static final int TaskStatus_SizeTooBig_20 = 20;
        public static final int TaskStatus_Suc_2 = 2;
        public static final int TaskStatus_Unknown_0 = 0;
        public static final int TaskStatus_ZeroFile_19 = 19;

        public TaskStatus() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiteTransferType.this);
            }
        }
    }

    public LiteTransferType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
