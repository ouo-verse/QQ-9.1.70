package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.mp.mobileqq_mp$RetInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes19.dex */
public interface RichProto {

    /* loaded from: classes19.dex */
    public static class RichProtoReq {
        static IPatchRedirector $redirector_;
        public RichProtoProc.RichProtoCallback callback;
        public int commandId;
        public byte[] extention;
        public String protoKey;
        public ProtoReqManagerImpl.ProtoReq protoReq;
        public IProtoReqManager protoReqMgr;
        public List<ReqCommon> reqs;
        RichProtoResp resp;

        /* loaded from: classes19.dex */
        public static class C2CPicDownReq extends ReqCommon {
            static IPatchRedirector $redirector_;
            public int fileType;
            public boolean isContact;
            public int msgTime;
            public int protocolType;
            public String storageSource;
            public String uuid;

            public C2CPicDownReq() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        /* loaded from: classes19.dex */
        public static class C2CPttDownReq extends ReqCommon {
            static IPatchRedirector $redirector_;
            public int autoToText;
            public int busiType;
            public int downType;
            public boolean isSelfSend;
            public String storageSource;
            public String uuid;
            public int voiceType;

            public C2CPttDownReq() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return " uuid:" + this.uuid + " storageSource:" + this.storageSource + " isSelfSend:" + this.isSelfSend + " voiceType:" + this.voiceType + " busiType:" + this.busiType + " downType:" + this.downType;
            }
        }

        /* loaded from: classes19.dex */
        public static class GroupPicDownReq extends ReqCommon {
            static IPatchRedirector $redirector_;
            public int fileType;
            public long groupFileID;
            public byte[] md5;
            public int msgTime;
            public int protocolType;

            public GroupPicDownReq() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "GroupPicDownReq{groupFileID=" + this.groupFileID + ", md5=" + Arrays.toString(this.md5) + ", fileType=" + this.fileType + ", msgTime=" + this.msgTime + ", protocolType=" + this.protocolType + '}';
            }
        }

        /* loaded from: classes19.dex */
        public static class GroupPttDownReq extends ReqCommon {
            static IPatchRedirector $redirector_;
            public int downType;
            public long groupFileID;
            public String groupFileKey;
            public byte[] md5;
            public int voiceType;

            public GroupPttDownReq() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return " groupFileID:" + this.groupFileID + " groupFileKey:" + this.groupFileKey + " md5:" + this.md5 + " voiceType:" + this.voiceType + " downType:" + this.downType;
            }
        }

        /* loaded from: classes19.dex */
        public static class GuildPicDownReq extends ReqCommon {
            static IPatchRedirector $redirector_;
            public int fileType;
            public long groupFileID;
            public byte[] index;
            public byte[] md5;
            public int msgTime;
            public int protocolType;

            public GuildPicDownReq() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "GuildPicDownReq{groupFileID=" + this.groupFileID + ", md5=" + Arrays.toString(this.md5) + ", index=" + Arrays.toString(this.index) + ", fileType=" + this.fileType + ", msgTime=" + this.msgTime + ", protocolType=" + this.protocolType + '}';
            }
        }

        /* loaded from: classes19.dex */
        public static class LongStructMessageDownReq extends ReqCommon {
            static IPatchRedirector $redirector_;
            public String strFileid;

            public LongStructMessageDownReq() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.strFileid;
            }
        }

        /* loaded from: classes19.dex */
        public static class MultiMsgDownReq extends ReqCommon {
            static IPatchRedirector $redirector_;
            public byte[] msgResId;
            public int multiMsgType;

            public MultiMsgDownReq() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return " msgResId:" + this.msgResId;
            }
        }

        /* loaded from: classes19.dex */
        public static class MultiMsgUpReq extends ReqCommon {
            static IPatchRedirector $redirector_;
            public byte[] md5;
            public int multiMsgType;
            public long size;

            public MultiMsgUpReq() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return " size:" + this.size + " storeType:";
            }
        }

        /* loaded from: classes19.dex */
        public static class NearbyPeoplePicUpReq extends ReqCommon {
            static IPatchRedirector $redirector_;
            public String uin;

            public NearbyPeoplePicUpReq() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.uin;
            }
        }

        /* loaded from: classes19.dex */
        public static class PicUpReq extends ReqCommon {
            static IPatchRedirector $redirector_;
            public int busiType;
            public String fileName;
            public long fileSize;
            public int height;
            public boolean isContact;
            public boolean isRaw;
            public boolean isSnapChat;
            public byte[] md5;
            public int picType;
            public String transferUrl;
            public int typeHotPic;
            public int width;

            public PicUpReq() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return " name:" + this.fileName + " width:" + this.width + " height:" + this.height + " size:" + this.fileSize + " isRaw:" + this.isRaw + " isContant:" + this.isContact + " md5:" + HexUtil.bytes2HexStr(this.md5) + " picType:" + this.picType + " busiType:" + this.busiType + "typeHotPic:" + this.typeHotPic + "transferUrl:" + this.transferUrl;
            }
        }

        /* loaded from: classes19.dex */
        public static class PttUpReq extends ReqCommon {
            static IPatchRedirector $redirector_;
            public int audioPanelType;
            public int autoToText;
            public String fileName;
            public int fileSize;
            public boolean forceViaOffline;
            public byte[] md5;
            public int voiceLength;
            public int voiceType;

            public PttUpReq() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    this.forceViaOffline = false;
                }
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return " name:" + this.fileName + " size:" + this.fileSize + " voiceLength:" + this.voiceLength + " autoToText:" + this.autoToText + " type:" + this.voiceType + " audioPanel:" + this.audioPanelType;
            }
        }

        /* loaded from: classes19.dex */
        public static class ReqCommon {
            static IPatchRedirector $redirector_;
            public String peerUin;
            public String secondUin;
            public String selfUin;
            public int uinType;

            public ReqCommon() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        /* loaded from: classes19.dex */
        public static class ShortVideoDownReq extends ReqCommon {
            static IPatchRedirector $redirector_;
            public int agentType;
            public int busiType;
            public int chatType;
            public int clientType;
            public int downType;
            public String fileId;
            public int fileType;
            public byte[] md5;
            public int sceneType;
            public int seq;
            public int sourceVideoCodecFormat;
            public int subBusiType;
            public int targetVideoCodecFormat;
            public String troopUin;

            public ShortVideoDownReq() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return " chatType:" + this.chatType + " clientType:" + this.clientType + " seq:" + this.seq + " fileId:" + this.fileId + " troopUin:" + this.troopUin + " agentType:" + this.agentType + " md5:" + HexUtil.bytes2HexStr(this.md5) + " busiType:" + this.busiType + " fileType:" + this.fileType + " downType:" + this.downType + " sceneType:" + this.sceneType + " subBusiType:" + this.subBusiType + " targetVideoCodecFormat:" + this.targetVideoCodecFormat + " sourceVideoCodecFormat:" + this.sourceVideoCodecFormat;
            }
        }

        /* loaded from: classes19.dex */
        public static class ShortVideoForwardReq extends ReqCommon {
            static IPatchRedirector $redirector_;
            public int agentType;
            public int bitrateInKilo;
            public int clientType;
            public String fileName;
            public int fileResLength;
            public int fileResWidth;
            public long fileSize;
            public int fileTime;
            public int format;
            public int fromBusiType;
            public int fromChatType;
            public String fromUin;
            public byte[] md5;
            public int seq;
            public int sourceVideoCodecFormat;
            public byte[] thumbFileMd5;
            public long thumbFileSize;
            public int toBusiType;
            public int toChatType;
            public String troopUin;
            public String uuid;

            public ShortVideoForwardReq() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    this.sourceVideoCodecFormat = -1;
                }
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return " fromChatType:" + this.fromChatType + " toChatType:" + this.toChatType + " fromBusiType:" + this.fromBusiType + " toBusiType:" + this.toBusiType + " md5:" + HexUtil.bytes2HexStr(this.md5) + " format:" + this.format + " str_file_name:" + this.fileName + " uint64_file_size:" + this.fileSize + " fileTime:" + this.fileTime + " uuid:" + this.uuid + " fromUin:" + this.fromUin + " sourceVideoCodecFormat:" + this.sourceVideoCodecFormat + " bitrate:" + this.bitrateInKilo;
            }
        }

        /* loaded from: classes19.dex */
        public static class ShortVideoUpReq extends ReqCommon {
            static IPatchRedirector $redirector_;
            public int agentType;
            public int bitrateInKilo;
            public int busiType;
            public int chatType;
            public int clientType;
            public String fileName;
            public int fileResLength;
            public int fileResWidth;
            public long fileSize;
            public int fileTime;
            public int format;
            public byte[] md5;
            public int seq;
            public int sourceVideoCodecFormat;
            public int subBusiType;
            public byte[] thumbFileMd5;
            public long thumbFileSize;
            public String troopUin;
            public int userCnt;

            public ShortVideoUpReq() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return " chatType:" + this.chatType + " md5:" + this.md5 + " format:" + this.format + " str_file_name:" + this.fileName + " uint64_file_size:" + this.fileSize + " fileTime:" + this.fileTime + " busiType:" + this.busiType + " subBusiType:" + this.subBusiType + " userCnt:" + this.userCnt + " sourceVideoCodecFormat:" + this.sourceVideoCodecFormat + " bitrate:" + this.bitrateInKilo;
            }
        }

        public RichProtoReq() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.reqs = new ArrayList();
                this.resp = new RichProtoResp();
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < this.reqs.size(); i3++) {
                sb5.append("index:");
                sb5.append(i3);
                sb5.append(" ");
                sb5.append(this.reqs.get(i3).toString());
            }
            return sb5.toString();
        }
    }

    /* loaded from: classes19.dex */
    public static class RichProtoResp {
        static IPatchRedirector $redirector_;
        public List<RespCommon> resps;

        /* loaded from: classes19.dex */
        public static class BDHCommonUpResp extends RespCommon {
            static IPatchRedirector $redirector_;
            public String bigDownUrl;
            public int blockSize;
            public String downDomain;
            public long groupFileID;
            public boolean isExist;
            public boolean isUseBdh;
            public ArrayList<ServerAddr> mIpList;
            public String mUkey;
            public boolean networkChange;
            public String orgiDownUrl;
            public String resid;
            public long startOffset;
            public String thumbDownUrl;
            public int transferedSize;

            public BDHCommonUpResp() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                this.mIpList = new ArrayList<>();
                this.networkChange = false;
                this.isUseBdh = false;
                this.startOffset = 0L;
                this.downDomain = "";
                this.thumbDownUrl = "";
                this.bigDownUrl = "";
                this.orgiDownUrl = "";
                this.resid = "";
            }

            @Override // com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return super.toString() + " fileID:" + this.groupFileID + " isExist:" + this.isExist + " blockSize:" + this.blockSize + " netChg:" + this.networkChange + " downDomain:" + this.downDomain + " thumbDownUrl" + this.thumbDownUrl + " bigDownUrl:" + this.bigDownUrl + " orgiDownUrl:" + this.orgiDownUrl;
            }
        }

        /* loaded from: classes19.dex */
        public static class C2CPicUpResp extends RespCommon {
            static IPatchRedirector $redirector_;
            public int blockSize;
            public boolean isExist;
            public String mOriginalDownPara;
            public String mResid;
            public String mUkey;
            public String mUuid;
            public boolean networkChange;
            public long startOffset;

            public C2CPicUpResp() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                this.isExist = false;
                this.networkChange = false;
                this.startOffset = 0L;
            }

            @Override // com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return super.toString() + " mResid:" + this.mResid + " isExist:" + this.isExist + " blockSize:" + this.blockSize + " netChg:" + this.networkChange + " startOffset:" + this.startOffset;
            }
        }

        /* loaded from: classes19.dex */
        public static class C2CPttDownResp extends RespCommon {
            static IPatchRedirector $redirector_;
            public String domainV4V6;
            public String downloadUrl;
            public ArrayList<ServerAddr> mIpList;
            public ArrayList<ServerAddr> mIpv6List;

            public C2CPttDownResp() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    this.mIpList = new ArrayList<>();
                    this.mIpv6List = new ArrayList<>();
                }
            }
        }

        /* loaded from: classes19.dex */
        public static class C2CPttUpResp extends RespCommon {
            static IPatchRedirector $redirector_;
            public int blockSize;
            public ArrayList<ServerAddr> ipList;
            public boolean isExist;
            public String mUkey;
            public String uuid;

            public C2CPttUpResp() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    this.ipList = new ArrayList<>();
                }
            }
        }

        /* loaded from: classes19.dex */
        public static class GroupPicUpResp extends RespCommon {
            static IPatchRedirector $redirector_;
            public int blockSize;
            public long groupFileID;
            public boolean isExist;
            public boolean isUseBdh;
            public ArrayList<ServerAddr> mIpList;
            public String mUkey;
            public boolean networkChange;
            public long startOffset;
            public int transferedSize;

            public GroupPicUpResp() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                this.mIpList = new ArrayList<>();
                this.networkChange = false;
                this.isUseBdh = false;
                this.startOffset = 0L;
            }

            @Override // com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return super.toString() + " fileID:" + this.groupFileID + " isExist:" + this.isExist + " blockSize:" + this.blockSize + " netChg:" + this.networkChange;
            }
        }

        /* loaded from: classes19.dex */
        public static class GroupPttDownResp extends RespCommon {
            static IPatchRedirector $redirector_;
            public String domainV4V6;
            public ArrayList<ServerAddr> mIpList;
            public ArrayList<ServerAddr> mIpv6List;
            public boolean mIsHttps;
            public String urlPath;

            public GroupPttDownResp() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    this.mIpList = new ArrayList<>();
                    this.mIpv6List = new ArrayList<>();
                }
            }
        }

        /* loaded from: classes19.dex */
        public static class GroupPttUpResp extends RespCommon {
            static IPatchRedirector $redirector_;
            public int blockSize;
            public long groupFileID;
            public byte[] groupFileKey;
            public ArrayList<ServerAddr> ipList;
            public boolean isExist;
            public String mUkey;
            public int transferedSize;

            public GroupPttUpResp() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    this.ipList = new ArrayList<>();
                }
            }

            @Override // com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return super.toString() + " fileID:" + this.groupFileID;
            }
        }

        /* loaded from: classes19.dex */
        public static class GuildPicUpResp extends RespCommon {
            static IPatchRedirector $redirector_;
            public int blockSize;
            public long groupFileID;
            public boolean isExist;
            public boolean isUseBdh;
            public byte[] mDownLoadIndex;
            public ArrayList<ServerAddr> mIpList;
            public String mUkey;
            public boolean networkChange;
            public long startOffset;
            public int transferedSize;

            public GuildPicUpResp() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                this.mIpList = new ArrayList<>();
                this.networkChange = false;
                this.isUseBdh = false;
                this.startOffset = 0L;
            }

            @Override // com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("GuildPicUpResp{");
                sb5.append(super.toString());
                sb5.append("isExist");
                sb5.append(this.isExist);
                sb5.append(", mIpList=");
                sb5.append(this.mIpList);
                sb5.append(", groupFileID=");
                sb5.append(this.groupFileID);
                sb5.append(", mUkey='");
                sb5.append(this.mUkey);
                sb5.append(", blockSize=");
                sb5.append(this.blockSize);
                sb5.append(", transferedSize=");
                sb5.append(this.transferedSize);
                sb5.append(", networkChange=");
                sb5.append(this.networkChange);
                sb5.append(", isUseBdh=");
                sb5.append(this.isUseBdh);
                sb5.append(", startOffset=");
                sb5.append(this.startOffset);
                sb5.append(", mDownLoadIndex=");
                try {
                    byte[] bArr = this.mDownLoadIndex;
                    if (bArr == null) {
                        sb5.append("null");
                        if (QLog.isColorLevel()) {
                            QLog.i("GuildPicUpResp", 1, "mDownLoadIndex" + ((Object) null));
                        }
                    } else {
                        sb5.append(new String(bArr, "utf8"));
                    }
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                }
                return sb5.toString();
            }
        }

        /* loaded from: classes19.dex */
        public static class LongStructMessageDownResp extends RespCommon {
            static IPatchRedirector $redirector_;
            public mobileqq_mp$RetInfo retInfo;
            public String strFileMd5;
            public String strUrl;

            public LongStructMessageDownResp() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        /* loaded from: classes19.dex */
        public static class MultiMsgDownResp extends RespCommon {
            static IPatchRedirector $redirector_;
            public ArrayList<ServerAddr> ipList;
            public int mChannelType;
            public ArrayList<ServerAddr> mIpv6List;
            public byte[] msgkey;
            public byte[] resId;
            public String urlParam;

            public MultiMsgDownResp() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    this.ipList = new ArrayList<>();
                    this.mIpv6List = new ArrayList<>();
                }
            }

            @Override // com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return super.toString() + " urlParam:" + this.urlParam + " msgUkey:" + this.msgkey + " ipList:" + this.ipList + " mIpv6List:" + this.mIpv6List + " resId:" + this.resId;
            }
        }

        /* loaded from: classes19.dex */
        public static class MultiMsgUpResp extends RespCommon {
            static IPatchRedirector $redirector_;
            public int blockSize;
            public ArrayList<ServerAddr> ipList;
            public byte[] msgKey;
            public byte[] msgSig;
            public byte[] resId;
            public int transferedSize;
            public byte[] ukey;

            public MultiMsgUpResp() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    this.ipList = new ArrayList<>();
                }
            }
        }

        /* loaded from: classes19.dex */
        public static class NearbyPeoplePicUpResp extends RespCommon {
            static IPatchRedirector $redirector_;
            public byte[] sessionKey;

            public NearbyPeoplePicUpResp() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        /* loaded from: classes19.dex */
        public static class PicDownResp extends RespCommon {
            static IPatchRedirector $redirector_;
            public String domain;
            public ArrayList<ServerAddr> mIpList;
            public ArrayList<ServerAddr> mIpv6List;
            public int protocolType;
            public String urlPath;

            public PicDownResp() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    this.mIpList = new ArrayList<>();
                    this.mIpv6List = new ArrayList<>();
                }
            }
        }

        /* loaded from: classes19.dex */
        public static class RespCommon {
            static IPatchRedirector $redirector_;
            public int errCode;
            public String errStr;
            public int failCount;
            public boolean isAllowRetry;
            public boolean isSendByQuickHttp;
            public RichProtoReq originReq;
            public String reason;
            public int result;
            public int successCount;

            public RespCommon() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                this.result = -1;
                this.isSendByQuickHttp = false;
                this.isAllowRetry = true;
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "result:" + this.result + " errCode:" + this.errCode + " errStr:" + this.errStr + " reason:" + this.reason + " succCnt:" + this.successCount + " failCnt" + this.failCount + " isSendByQuickHttp" + this.isSendByQuickHttp + " isAllowRetry" + this.isAllowRetry;
            }
        }

        /* loaded from: classes19.dex */
        public static class ShortVideoDownResp extends RespCommon {
            static IPatchRedirector $redirector_;
            public String mDomain;
            public int mHostType;
            public ArrayList<ServerAddr> mIpList;
            public ArrayList<ServerAddr> mIpv6List;
            public boolean mIsHttps;
            public boolean mIsQuicEncryption;
            public boolean mIsSupportQuic;
            public int mQuicFec;
            public String mUkey;
            public String mUrl;
            public int mVideoCodecFormat;
            public byte[] md5;

            public ShortVideoDownResp() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    this.mIpList = new ArrayList<>();
                    this.mIpv6List = new ArrayList<>();
                }
            }

            @Override // com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return super.toString() + " mUkey:" + this.mUkey + " mIpList:" + this.mIpList.toString() + " mIpv6List:" + this.mIpv6List.toString() + " md5:" + HexUtil.bytes2HexStr(this.md5) + " mIsSupportQuic:" + this.mIsSupportQuic + " mIsQuicEncryption:" + this.mIsQuicEncryption + " mQuicFec:" + this.mQuicFec + " mVideoCodecFormat:" + this.mVideoCodecFormat;
            }
        }

        /* loaded from: classes19.dex */
        public static class ShortVideoForwardResp extends RespCommon {
            static IPatchRedirector $redirector_;
            public String fileId;
            public boolean isExist;
            public long startOffset;
            public int videoAttr;
            public int videoKandianType;

            public ShortVideoForwardResp() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                this.startOffset = 0L;
                this.videoAttr = 0;
                this.videoKandianType = 0;
            }

            @Override // com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return super.toString() + " isExist:" + this.isExist + " fileId:" + this.fileId + " startOffset:" + this.startOffset + " videoAttr:" + this.videoAttr + " videoKandianType:" + this.videoKandianType;
            }
        }

        /* loaded from: classes19.dex */
        public static class ShortVideoUpResp extends RespCommon {
            static IPatchRedirector $redirector_;
            public String fileId;
            public boolean isExist;
            public long startOffset;
            public int videoAttr;
            public int videoKandianType;

            public ShortVideoUpResp() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                this.startOffset = 0L;
                this.videoAttr = 0;
                this.videoKandianType = 0;
            }

            @Override // com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return super.toString() + " isExist:" + this.isExist + " fileId:" + this.fileId + " startOffset:" + this.startOffset + " videoAttr:" + this.videoAttr + " videoKandianType:" + this.videoKandianType;
            }
        }

        public RichProtoResp() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.resps = new ArrayList();
            }
        }
    }
}
