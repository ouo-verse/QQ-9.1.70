package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Session {
    static IPatchRedirector $redirector_;
    public ActionInfo actionInfo;
    public boolean bSend;
    public int dwGroupID;
    public int dwGroupIndex;
    public int dwGroupSize;
    public int emFileFrom;
    public int emFileType;
    public int emTaskStatus;
    public boolean isFileAssist;
    public MsgHeader msgHeader;
    public byte[] pFileBuffer;
    public String strFileNameSrc;
    public String strFileNameThumb;
    public String strFilePathSrc;
    public String strFilePathThumb;
    public int uChannelType;
    public long uFileSizeSrc;
    public long uFileSizeThumb;
    public long uForwardSessionID;
    public int uMsgTime;
    public long uOwnerUin;
    public long uSessionID;
    public byte[] vFileMD5Src;
    public byte[] vFileMD5Thumb;
    public byte[] vFileSHASrc;
    public byte[] vFileSHAThumb;
    public byte[] vFileTriSHASrc;
    public byte[] vFileTriSHAThumb;
    public byte[] vOfflineFileUUID;

    public Session() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
