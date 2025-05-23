package com.tencent.qqlive.superplayer.vinfo;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TVKVideoInfo extends TVKNetVideoInfo {
    public static final String DEFINITION_MP4 = "mp4";
    public static final int DOWNLOAD_TYPE_HLS = 3;
    public static final int EXEM_DEFN_LIMIT = 3;
    public static final int FORMAT_STANDARD_MP4 = 2;
    public static final int MODEL_CODE_VBKEY = 113;
    public static final int MODEL_CODE_VINFO = 111;
    public static final int MODEL_CODE_VKEY = 112;
    public static final int SUCCESS = 0;
    public static final String TAG = "TVKVideoInfo";
    public static final int TYPE_JSON = 1;
    public static final int TYPE_XML = 2;
    private static final long serialVersionUID = -1;
    private String actionUrl;
    private String adsid;
    private String[] backPlayUrl;
    private String bitrate;
    private String ckc;
    private String[] clipUrl;
    private int downloadType;
    private String errMsg;
    private String exInfo;
    private String exMsg;
    private String fileName;
    private int height;
    private int logHeight;
    private int logWidth;
    private int logX;
    private int logY;
    private boolean mIsLogShow;
    private String playUrl;
    private int type;
    private String vKeyXml;
    private String vid;
    private int videoType;
    private int width;
    private String xml;
    private int cgiCode = 0;
    private int fp2p = -1;
    private int modelCode = 0;
    private int moduleCode = 0;
    private ArrayList<ReferUrl> urlList = new ArrayList<>();
    private boolean mVideoEncryption = false;
    private String vKey = "";
    private String sha = "";
    private String level = "";

    /* renamed from: sp, reason: collision with root package name */
    private String f345549sp = "";
    private String drmToken = "";
    private String targetId = "";
    private int iFlag = 0;
    private int sectionNum = 0;
    private ArrayList<Section> sectionList = new ArrayList<>();
    private ArrayList<Object> formatList = new ArrayList<>();
    private int drmType = 0;
    private int enc = 0;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class HlsNode implements Serializable {
        private static final long serialVersionUID = -1;

        /* renamed from: et, reason: collision with root package name */
        private int f345550et;
        private int fbw;
        private int ftype;

        /* renamed from: hk, reason: collision with root package name */
        private String f345551hk;
        private String hvl;
        private String pname;

        /* renamed from: pt, reason: collision with root package name */
        private String f345552pt;

        /* renamed from: st, reason: collision with root package name */
        private int f345553st;
        private String stype;

        public int getEt() {
            return this.f345550et;
        }

        public int getFbw() {
            return this.fbw;
        }

        public int getFtype() {
            return this.ftype;
        }

        public String getHk() {
            return this.f345551hk;
        }

        public String getHvl() {
            return this.hvl;
        }

        public String getPname() {
            return this.pname;
        }

        public String getPt() {
            return this.f345552pt;
        }

        public int getSt() {
            return this.f345553st;
        }

        public String getStype() {
            return this.stype;
        }

        public void setEt(int i3) {
            this.f345550et = i3;
        }

        public void setFbw(int i3) {
            this.fbw = i3;
        }

        public void setFtype(int i3) {
            this.ftype = i3;
        }

        public void setHk(String str) {
            this.f345551hk = str;
        }

        public void setHvl(String str) {
            this.hvl = str;
        }

        public void setPname(String str) {
            this.pname = str;
        }

        public void setPt(String str) {
            this.f345552pt = str;
        }

        public void setSt(int i3) {
            this.f345553st = i3;
        }

        public void setStype(String str) {
            this.stype = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class ReferUrl implements Serializable {
        private static final long serialVersionUID = -1;

        /* renamed from: dt, reason: collision with root package name */
        private int f345554dt;
        private int dtc;
        private HlsNode hlsNode;
        private String path;
        private int spPort;
        private String spip;
        private String url;

        /* renamed from: vt, reason: collision with root package name */
        private int f345555vt;

        public int getDt() {
            return this.f345554dt;
        }

        public int getDtc() {
            return this.dtc;
        }

        public HlsNode getHlsNode() {
            return this.hlsNode;
        }

        public String getPath() {
            return this.path;
        }

        public int getSpPort() {
            return this.spPort;
        }

        public String getSpip() {
            return this.spip;
        }

        public String getUrl() {
            return this.url;
        }

        public int getVt() {
            return this.f345555vt;
        }

        public void setDt(int i3) {
            this.f345554dt = i3;
        }

        public void setDtc(int i3) {
            this.dtc = i3;
        }

        public void setHlsNode(HlsNode hlsNode) {
            this.hlsNode = hlsNode;
        }

        public void setPath(String str) {
            this.path = str;
        }

        public void setSpPort(int i3) {
            this.spPort = i3;
        }

        public void setSpip(String str) {
            this.spip = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setVt(int i3) {
            this.f345555vt = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Section implements Serializable {
        private static final long serialVersionUID = -1;
        private double duration;
        private int idx;
        private String indexName;
        private int size;
        private String url;
        private String vbkey;
        private String vbkeyId;

        public double getDuration() {
            return this.duration;
        }

        public int getIdx() {
            return this.idx;
        }

        public String getIndexName() {
            return this.indexName;
        }

        public int getSize() {
            return this.size;
        }

        public String getUrl() {
            return this.url;
        }

        public String getVbkey() {
            return this.vbkey;
        }

        public String getVbkeyId() {
            return this.vbkeyId;
        }

        public void setDuration(double d16) {
            this.duration = d16;
        }

        public void setIdx(int i3) {
            this.idx = i3;
        }

        public void setIndexName(String str) {
            this.indexName = str;
        }

        public void setSize(int i3) {
            this.size = i3;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setVbkey(String str) {
            this.vbkey = str;
        }

        public void setVbkeyId(String str) {
            this.vbkeyId = str;
        }

        public void setIndexName(String str, int i3) {
            this.indexName = str.replace(".mp4", "") + "." + i3 + ".mp4";
        }
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void addDefinition(TVKNetVideoInfo.DefnInfo defnInfo) {
        super.addDefinition(defnInfo);
    }

    public void addReferUrlItem(int i3, ReferUrl referUrl) {
        if (referUrl != null) {
            Pattern compile = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+");
            if (referUrl.getUrl() != null && !TextUtils.isEmpty(referUrl.getUrl())) {
                Matcher matcher = compile.matcher(referUrl.getUrl());
                if (matcher.find() && matcher.group() != null) {
                    addVideoDownloadHostItem(Integer.valueOf(i3), matcher.group());
                }
            }
        }
        this.urlList.add(referUrl);
    }

    public void addSectionItem(Section section) {
        this.sectionList.add(section);
    }

    public String getActionUrl() {
        return this.actionUrl;
    }

    public String getAdsid() {
        return this.adsid;
    }

    public String[] getBackPlayUrl() {
        return this.backPlayUrl;
    }

    public String getBitrate() {
        return this.bitrate;
    }

    public int getCgiCode() {
        return this.cgiCode;
    }

    public String getCkc() {
        return this.ckc;
    }

    public String[] getClipUrl() {
        return this.clipUrl;
    }

    public String getDRMToken() {
        return this.drmToken;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public int getDanmuState() {
        return super.getDanmuState();
    }

    public int getDownloadType() {
        return this.downloadType;
    }

    public int getDrm() {
        return this.drmType;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public int getDuration() {
        return super.getDuration();
    }

    public int getEnc() {
        return this.enc;
    }

    public boolean getEncryptionVideo() {
        return this.mVideoEncryption;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getExInfo() {
        return this.exInfo;
    }

    public String getExMsg() {
        return this.exMsg;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public int getExem() {
        return super.getExem();
    }

    public String getFileName() {
        return this.fileName;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public long getFileSize() {
        return super.getFileSize();
    }

    public String getFirstCdnHlsPlayUrl() {
        if (this.urlList.size() > 0) {
            ReferUrl referUrl = this.urlList.get(0);
            String url = referUrl.getUrl();
            if (referUrl.getHlsNode() != null) {
                return url + referUrl.getHlsNode().getPt();
            }
            return url;
        }
        return null;
    }

    public int getFirstCdnId() {
        if (this.urlList.size() <= 0) {
            return 0;
        }
        return getUrlList().get(0).getVt();
    }

    public String getFirstCdnServer() {
        if (this.urlList.size() > 0) {
            return getUrlList().get(0).getUrl();
        }
        return null;
    }

    public int getFp2p() {
        return this.fp2p;
    }

    public int getHeight() {
        return this.height;
    }

    public int getIFlag() {
        return this.iFlag;
    }

    public String getLevel() {
        return this.level;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public String getLnk() {
        return super.getLnk();
    }

    public int getLogHeight() {
        return this.logHeight;
    }

    public int getLogWidth() {
        return this.logWidth;
    }

    public int getLogX() {
        return this.logX;
    }

    public int getLogY() {
        return this.logY;
    }

    public int getModelCode() {
        return this.modelCode;
    }

    public int getModuleCode() {
        return this.moduleCode;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public String getPLString() {
        return super.getPLString();
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public int getPLType() {
        return super.getPLType();
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public int getPayCh() {
        return super.getPayCh();
    }

    public String getPlayUrl() {
        if (TextUtils.isEmpty(this.playUrl)) {
            return "";
        }
        return this.playUrl;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public long getPrePlayEndPos() {
        return super.getPrePlayEndPos();
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public long getPrePlayStartPos() {
        return super.getPrePlayStartPos();
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public long getPrePlayTime() {
        return super.getPrePlayTime();
    }

    public ArrayList<Section> getSectionList() {
        return this.sectionList;
    }

    public int getSectionNum() {
        return this.sectionNum;
    }

    public String getSha() {
        return this.sha;
    }

    public String getSp() {
        return this.f345549sp;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public int getSt() {
        return super.getSt();
    }

    public String getTargetId() {
        return this.targetId;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public String getTitle() {
        return super.getTitle();
    }

    public int getType() {
        return this.type;
    }

    public ArrayList<ReferUrl> getUrlList() {
        return this.urlList;
    }

    public String getVKey() {
        return this.vKey;
    }

    public String getVKeyXml() {
        return this.vKeyXml;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public String getVid() {
        return super.getVid();
    }

    public int getVideoType() {
        return this.videoType;
    }

    public String getVideoUrlWithoutVkey(String str) {
        ArrayList<ReferUrl> arrayList = this.urlList;
        if (arrayList != null && arrayList.size() != 0) {
            return this.urlList.get(0).getUrl() + this.fileName;
        }
        Log.e(TAG, "vinfo is not valiad!!");
        return null;
    }

    public int getWidth() {
        return this.width;
    }

    public String getXml() {
        return this.xml;
    }

    public boolean isHLSDownloadType() {
        if (this.downloadType == 3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public boolean isHevc() {
        return super.isHevc();
    }

    public boolean ismIsLogShow() {
        return this.mIsLogShow;
    }

    public void setActionUrl(String str) {
        this.actionUrl = str;
    }

    public void setAdsid(String str) {
        this.adsid = str;
    }

    public void setBackPlayUrl(String[] strArr) {
        this.backPlayUrl = strArr;
    }

    public void setBitrate(String str) {
        this.bitrate = str;
    }

    public void setCgiCode(int i3) {
        this.cgiCode = i3;
    }

    public void setCkc(String str) {
        this.ckc = str;
    }

    public void setClipUrl(String[] strArr) {
        this.clipUrl = strArr;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setCurDefinition(TVKNetVideoInfo.DefnInfo defnInfo) {
        super.setCurDefinition(defnInfo);
    }

    public void setDRMToken(String str) {
        this.drmToken = str;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setDanmuState(int i3) {
        super.setDanmuState(i3);
    }

    public void setDownloadType(int i3) {
        this.downloadType = i3;
    }

    public void setDrm(int i3) {
        this.drmType = i3;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setDuration(int i3) {
        super.setDuration(i3);
    }

    public void setEnc(int i3) {
        this.enc = i3;
    }

    public void setEncryptionVideo(boolean z16) {
        this.mVideoEncryption = z16;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setEndPos(int i3) {
        super.setEndPos(i3);
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setExInfo(String str) {
        this.exInfo = str;
    }

    public void setExMsg(String str) {
        this.exMsg = str;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setExem(int i3) {
        super.setExem(i3);
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setFileSize(long j3) {
        super.setFileSize(j3);
    }

    public void setFp2p(int i3) {
        this.fp2p = i3;
    }

    public void setHeight(int i3) {
        this.height = i3;
    }

    public void setIFlag(int i3) {
        this.iFlag = i3;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setIsHevc(boolean z16) {
        super.setIsHevc(z16);
    }

    public void setLevel(String str) {
        this.level = str;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setLnk(String str) {
        super.setLnk(str);
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setLocalVideo(boolean z16) {
        super.setLocalVideo(z16);
    }

    public void setLogHeight(int i3) {
        this.logHeight = i3;
    }

    public void setLogWidth(int i3) {
        this.logWidth = i3;
    }

    public void setLogX(int i3) {
        this.logX = i3;
    }

    public void setLogY(int i3) {
        this.logY = i3;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setMediaVideoState(int i3) {
        super.setMediaVideoState(i3);
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setMediaVideoType(int i3) {
        super.setMediaVideoType(i3);
    }

    public void setModelCode(int i3) {
        this.modelCode = i3;
    }

    public void setModuleCode(int i3) {
        this.moduleCode = i3;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setPLString(String str) {
        super.setPLString(str);
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setPLType(int i3) {
        super.setPLType(i3);
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setPayCh(int i3) {
        super.setPayCh(i3);
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setPictureList(Object obj) {
        super.setPictureList(obj);
    }

    public void setPlayUrl(String str) {
        this.playUrl = str;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setPrePlayEndPos(long j3) {
        super.setPrePlayEndPos(j3);
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setPrePlayStartPos(long j3) {
        super.setPrePlayStartPos(j3);
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setPrePlayTime(long j3) {
        super.setPrePlayTime(j3);
    }

    public void setSectionNum(int i3) {
        this.sectionNum = i3;
    }

    public void setSha(String str) {
        this.sha = str;
    }

    public void setSp(String str) {
        this.f345549sp = str;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setSt(int i3) {
        super.setSt(i3);
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setStartPos(int i3) {
        super.setStartPos(i3);
    }

    public void setTargetId(String str) {
        this.targetId = str;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setTitle(String str) {
        super.setTitle(str);
    }

    public void setType(int i3) {
        this.type = i3;
    }

    public void setVKey(String str) {
        this.vKey = str;
    }

    public void setVKeyXml(String str) {
        this.vKeyXml = str;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setVid(String str) {
        super.setVid(str);
    }

    public void setVideoType(int i3) {
        this.videoType = i3;
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setWHRadio(float f16) {
        super.setWHRadio(f16);
    }

    @Override // com.tencent.qqlive.superplayer.vinfo.TVKNetVideoInfo
    public void setWanIP(String str) {
        super.setWanIP(str);
    }

    public void setWidth(int i3) {
        this.width = i3;
    }

    public void setXml(String str) {
        this.xml = str;
    }

    public void setmIsLogShow(boolean z16) {
        this.mIsLogShow = z16;
    }
}
