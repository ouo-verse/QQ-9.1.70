package com.tencent.state.publicchat.plugin;

import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bC\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001a\u0010,\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\u001a\u0010/\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR\u001a\u00102\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\u001a\u00105\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR\u001a\u00108\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR\u001a\u0010;\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0006\"\u0004\b=\u0010\bR\u001a\u0010>\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\bR\u001a\u0010A\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u0010\bR\u001a\u0010D\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0006\"\u0004\bF\u0010\b\u00a8\u0006G"}, d2 = {"Lcom/tencent/state/publicchat/plugin/EvilReportParams;", "", "()V", "appid", "", "getAppid", "()Ljava/lang/String;", "setAppid", "(Ljava/lang/String;)V", "appname", "getAppname", "setAppname", "audioEvidence", "getAudioEvidence", "setAudioEvidence", "buddyflag", "getBuddyflag", "setBuddyflag", TPReportKeys.LiveExKeys.LIVE_EX_CONTENT_ID, "getContentid", "setContentid", "cryptoVersion", "getCryptoVersion", "setCryptoVersion", "cryptograph", "getCryptograph", "setCryptograph", "eviluin", "getEviluin", "setEviluin", "eviluinType", "getEviluinType", "setEviluinType", "fileEvidence", "getFileEvidence", "setFileEvidence", FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, "getGroupid", "setGroupid", "imgEvidence", "getImgEvidence", "setImgEvidence", "isAnonymous", "setAnonymous", "scene", "getScene", "setScene", "srvPara", "getSrvPara", "setSrvPara", "subapp", "getSubapp", "setSubapp", TVKPlayerMsg.PLAYER_CHOICE_SYSTEM, "getSystem", "setSystem", "textEvidence", "getTextEvidence", "setTextEvidence", "uintype", "getUintype", "setUintype", "urlEvidence", "getUrlEvidence", "setUrlEvidence", "version", "getVersion", "setVersion", "videoEvidence", "getVideoEvidence", "setVideoEvidence", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class EvilReportParams {
    private String system = "android";
    private String version = SquareBaseKt.getSquareCommon().getAppReportVersionName();
    private String uintype = "1";
    private String eviluin = "";
    private String eviluinType = "2";
    private String appname = "KQQ";
    private String appid = "2400002";
    private String subapp = "QQzhuangtaiguangchang_groupconversation_51820004";
    private String scene = "51820004";
    private String isAnonymous = "0";
    private String buddyflag = "0";
    private String groupid = "";
    private String contentid = "";
    private String srvPara = "chatmsg:";
    private String textEvidence = "";
    private String imgEvidence = "";
    private String urlEvidence = "";
    private String videoEvidence = "";
    private String fileEvidence = "";
    private String audioEvidence = "";
    private String cryptoVersion = "4";
    private String cryptograph = "";

    public final String getAppid() {
        return this.appid;
    }

    public final String getAppname() {
        return this.appname;
    }

    public final String getAudioEvidence() {
        return this.audioEvidence;
    }

    public final String getBuddyflag() {
        return this.buddyflag;
    }

    public final String getContentid() {
        return this.contentid;
    }

    public final String getCryptoVersion() {
        return this.cryptoVersion;
    }

    public final String getCryptograph() {
        return this.cryptograph;
    }

    public final String getEviluin() {
        return this.eviluin;
    }

    public final String getEviluinType() {
        return this.eviluinType;
    }

    public final String getFileEvidence() {
        return this.fileEvidence;
    }

    public final String getGroupid() {
        return this.groupid;
    }

    public final String getImgEvidence() {
        return this.imgEvidence;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getSrvPara() {
        return this.srvPara;
    }

    public final String getSubapp() {
        return this.subapp;
    }

    public final String getSystem() {
        return this.system;
    }

    public final String getTextEvidence() {
        return this.textEvidence;
    }

    public final String getUintype() {
        return this.uintype;
    }

    public final String getUrlEvidence() {
        return this.urlEvidence;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getVideoEvidence() {
        return this.videoEvidence;
    }

    /* renamed from: isAnonymous, reason: from getter */
    public final String getIsAnonymous() {
        return this.isAnonymous;
    }

    public final void setAnonymous(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isAnonymous = str;
    }

    public final void setAppid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appid = str;
    }

    public final void setAppname(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appname = str;
    }

    public final void setAudioEvidence(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.audioEvidence = str;
    }

    public final void setBuddyflag(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.buddyflag = str;
    }

    public final void setContentid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.contentid = str;
    }

    public final void setCryptoVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cryptoVersion = str;
    }

    public final void setCryptograph(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cryptograph = str;
    }

    public final void setEviluin(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.eviluin = str;
    }

    public final void setEviluinType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.eviluinType = str;
    }

    public final void setFileEvidence(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fileEvidence = str;
    }

    public final void setGroupid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupid = str;
    }

    public final void setImgEvidence(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imgEvidence = str;
    }

    public final void setScene(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scene = str;
    }

    public final void setSrvPara(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.srvPara = str;
    }

    public final void setSubapp(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subapp = str;
    }

    public final void setSystem(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.system = str;
    }

    public final void setTextEvidence(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.textEvidence = str;
    }

    public final void setUintype(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uintype = str;
    }

    public final void setUrlEvidence(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.urlEvidence = str;
    }

    public final void setVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    public final void setVideoEvidence(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoEvidence = str;
    }
}
