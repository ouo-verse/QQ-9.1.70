package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$EventKey;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.app.identity.jwt.JsonWebSignature;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKDefinitionUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVodVinfoDecryptor;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.QZoneHelper;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/* loaded from: classes23.dex */
public class TVKVodInfoParser {
    private static final long MAX_BITRATE_BPS = 100000000;
    private static final int SELECTED_DEFINITION = 1;
    private static final String TAG = "TVKPlayer[TVKVodInfoParser]";
    private final List<ITVKVodFeature> mFeatureList;

    @NonNull
    private final ITVKLogger mLogger;

    public TVKVodInfoParser(List<ITVKVodFeature> list, @NonNull ITVKLogger iTVKLogger) {
        this.mFeatureList = list;
        this.mLogger = iTVKLogger;
    }

    private String convertNodeToXmlString(Node node) {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        try {
            if (node.hasChildNodes() && node.getFirstChild().hasChildNodes()) {
                sb5.append("<");
                sb5.append(node.getNodeName());
                sb5.append(">");
                z16 = true;
            } else {
                z16 = false;
            }
            while (node.hasChildNodes()) {
                Node firstChild = node.getFirstChild();
                if (firstChild.hasChildNodes()) {
                    sb5.append(convertNodeToXmlString(firstChild));
                } else {
                    sb5.append("<");
                    sb5.append(firstChild.getParentNode().getNodeName());
                    sb5.append(">");
                    sb5.append(firstChild.getNodeValue());
                    sb5.append("</");
                    sb5.append(firstChild.getParentNode().getNodeName());
                    sb5.append(">");
                }
                node.removeChild(node.getFirstChild());
            }
            if (z16) {
                sb5.append("</");
                sb5.append(node.getNodeName());
                sb5.append(">");
            }
        } catch (Exception e16) {
            this.mLogger.error("convertNodeToXmlString has exception: " + e16.toString(), new Object[0]);
        }
        return sb5.toString();
    }

    private TVKGetVinfoData createErrorResult(int i3) {
        TVKGetVinfoData tVKGetVinfoData = new TVKGetVinfoData();
        tVKGetVinfoData.setParseResult(i3);
        return tVKGetVinfoData;
    }

    private void dealPreviewClipCount(TVKVodVideoInfo tVKVodVideoInfo) {
        int i3;
        if (tVKVodVideoInfo.getSt() == 8 && tVKVodVideoInfo.getSectionNum() != 0) {
            if (1 == tVKVodVideoInfo.getSectionNum()) {
                tVKVodVideoInfo.setPreviewClipCount(tVKVodVideoInfo.getSectionNum());
                return;
            }
            long previewDurationSec = tVKVodVideoInfo.getPreviewDurationSec();
            long j3 = TVKMediaPlayerConfig.PlayerConfig.preview_duration_threshold;
            Iterator<TVKVodVideoInfo.Section> it = tVKVodVideoInfo.getSectionList().iterator();
            while (true) {
                if (it.hasNext()) {
                    TVKVodVideoInfo.Section next = it.next();
                    j3 += (long) next.getDurationSec();
                    if (j3 >= previewDurationSec) {
                        i3 = next.getIdx();
                        break;
                    }
                } else {
                    i3 = 0;
                    break;
                }
            }
            tVKVodVideoInfo.setPreviewClipCount(i3);
        }
    }

    private Document getDoc(String str) {
        try {
            this.mLogger.info("getDoc newInstance start", new Object[0]);
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            this.mLogger.info("getDoc parse start", new Object[0]);
            Document parse = newDocumentBuilder.parse(new InputSource(new StringReader(str)));
            this.mLogger.info("getDoc parse done", new Object[0]);
            return parse;
        } catch (Exception e16) {
            this.mLogger.error("getDoc has exception: " + e16, new Object[0]);
            return null;
        }
    }

    @NonNull
    private String getElementsTagNameStringValue(@NonNull Node node, @NonNull String str) {
        NodeList elementsByTagName;
        if (node instanceof Document) {
            elementsByTagName = ((Document) node).getElementsByTagName(str);
        } else {
            elementsByTagName = ((Element) node).getElementsByTagName(str);
        }
        if (elementsByTagName != null && elementsByTagName.getLength() != 0) {
            if (elementsByTagName.getLength() > 1) {
                for (int i3 = 0; i3 < elementsByTagName.getLength(); i3++) {
                    if (elementsByTagName.item(i3).getParentNode() == node) {
                        return elementsByTagName.item(i3).getTextContent();
                    }
                }
            }
            return elementsByTagName.item(0).getTextContent();
        }
        return "";
    }

    private String getFirstChildNodeValue(Node node) {
        if (node != null && node.getFirstChild() != null) {
            return node.getFirstChild().getNodeValue();
        }
        return "";
    }

    private TVKVodRetryAndErrorInfo parseErrorInfo(@NonNull Document document) {
        TVKVodRetryAndErrorInfo tVKVodRetryAndErrorInfo = new TVKVodRetryAndErrorInfo();
        tVKVodRetryAndErrorInfo.setErrCode(TVKUtils.optInt(getElementsTagNameStringValue(document, "em"), 0));
        tVKVodRetryAndErrorInfo.setErrDetailCode(TVKUtils.optInt(getElementsTagNameStringValue(document, "exem"), 0));
        tVKVodRetryAndErrorInfo.setCurTime(TVKUtils.optLong(getElementsTagNameStringValue(document, "curTime"), 0L));
        tVKVodRetryAndErrorInfo.setRand(getElementsTagNameStringValue(document, "rand"));
        tVKVodRetryAndErrorInfo.setNeedRetry(TVKUtils.optInt(getElementsTagNameStringValue(document, TVKCommonParamEnum.REQ_PARAM_KEY_RETRY), 0));
        tVKVodRetryAndErrorInfo.setMessage(getElementsTagNameStringValue(document, "msg"));
        tVKVodRetryAndErrorInfo.setIpInfo(getElementsTagNameStringValue(document, "exinfo"));
        return tVKVodRetryAndErrorInfo;
    }

    private void parseIsAVS(@NonNull Node node, @NonNull TVKNetVideoInfo.DefnInfo defnInfo) {
        if (TVKUtils.optInt(getElementsTagNameStringValue(node, "isavs"), 0) == 1) {
            defnInfo.setIsAvsSeparate(true);
        } else {
            defnInfo.setIsAvsSeparate(false);
        }
    }

    private TVKGetVinfoData parseNormalVinfo(Document document) {
        if (document == null) {
            return createErrorResult(15);
        }
        TVKGetVinfoData tVKGetVinfoData = new TVKGetVinfoData();
        this.mLogger.info("parseVInfo, getDoc, end", new Object[0]);
        tVKGetVinfoData.setErrorInfo(parseErrorInfo(document));
        if (tVKGetVinfoData.getErrorInfo().getErrCode() != 0) {
            return tVKGetVinfoData;
        }
        TVKVodVideoInfo tVKVodVideoInfo = new TVKVodVideoInfo();
        try {
            parseVinfoRootNode(tVKVodVideoInfo, document);
            if (tVKVodVideoInfo.getSectionNum() > 0) {
                tVKVodVideoInfo.setDownloadType(4);
            }
            if (tVKVodVideoInfo.getSectionList().size() > 0) {
                tVKVodVideoInfo.getSectionList().get(0).setUrl(tVKVodVideoInfo.getUrlList().get(0).getUrl());
                tVKVodVideoInfo.getSectionList().get(0).setVbkey(tVKVodVideoInfo.getVKey());
            }
        } catch (Throwable th5) {
            this.mLogger.error("parseVinfo has exception: " + th5.toString(), new Object[0]);
        }
        dealPreviewClipCount(tVKVodVideoInfo);
        tVKGetVinfoData.setVodInfo(tVKVodVideoInfo);
        return tVKGetVinfoData;
    }

    private void parseVInfoAdPassNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, Node node) {
        String elementsTagNameStringValue = getElementsTagNameStringValue(node, TVKCommonParamEnum.REQ_PARAM_KEY_AD_PASS);
        if (TextUtils.isEmpty(elementsTagNameStringValue)) {
            return;
        }
        if (tVKVodVideoInfo.getAdInfo() == null) {
            tVKVodVideoInfo.setAdInfo(new TVKNetVideoInfo.AdInfo());
        }
        tVKVodVideoInfo.getAdInfo().setAdPass(elementsTagNameStringValue);
    }

    private void parseVinfoClipNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        this.mLogger.info("parseVinfoClipNode, start", new Object[0]);
        if (nodeList == null) {
            return;
        }
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1) {
                if (item.getNodeName().equalsIgnoreCase("fc")) {
                    tVKVodVideoInfo.setSectionNum(TVKUtils.optInt(getFirstChildNodeValue(item), 0));
                    this.mLogger.info("parseVinfoClipNode, Section size: " + tVKVodVideoInfo.getSectionNum(), new Object[0]);
                } else if (item.getNodeName().equalsIgnoreCase("ci")) {
                    TVKVodVideoInfo.Section section = new TVKVodVideoInfo.Section();
                    section.setIdx(TVKUtils.optInt(getElementsTagNameStringValue(item, "idx"), 0));
                    section.setCmd5(getElementsTagNameStringValue(item, "cmd5"));
                    section.setSize(TVKUtils.optInt(getElementsTagNameStringValue(item, "cs"), 0));
                    section.setDurationSec(TVKUtils.optFloat(getElementsTagNameStringValue(item, "cd"), 0.0f));
                    section.setVbkeyId(getElementsTagNameStringValue(item, TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_KEYID));
                    if (section.getIdx() > 0) {
                        tVKVodVideoInfo.addSectionItem(section);
                        this.mLogger.info("parseVinfoClipNode, addMp4ClipInfo, idx: " + section.getIdx(), new Object[0]);
                    }
                }
            }
        }
        this.mLogger.info("parseVinfoClipNode, end", new Object[0]);
    }

    private void parseVinfoFormatNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        boolean z16;
        this.mLogger.info("parseVinfoFormatNode, start", new Object[0]);
        if (nodeList == null) {
            return;
        }
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1) {
                if (item.getNodeName().equalsIgnoreCase("fi")) {
                    TVKNetVideoInfo.DefnInfo defnInfo = new TVKNetVideoInfo.DefnInfo();
                    defnInfo.setDefnId(TVKUtils.optInt(getElementsTagNameStringValue(item, "id"), 0));
                    defnInfo.setDefn(getElementsTagNameStringValue(item, "name"));
                    defnInfo.setFileSizeByte(TVKUtils.optLong(getElementsTagNameStringValue(item, "fs"), 0L));
                    defnInfo.setDefnName(getElementsTagNameStringValue(item, "cname"));
                    int optInt = TVKUtils.optInt(getElementsTagNameStringValue(item, "lmt"), 0);
                    if (optInt != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    defnInfo.setVipOnly(z16);
                    defnInfo.setLmt(optInt);
                    defnInfo.setDrm(TVKUtils.optInt(getElementsTagNameStringValue(item, TVKCommonParamEnum.REQ_PARAM_KEY_DRM), 0));
                    defnInfo.setSuperResolution(TVKUtils.optInt(getElementsTagNameStringValue(item, "super"), 0));
                    defnInfo.setVideoCodec(TVKUtils.optInt(getElementsTagNameStringValue(item, "video"), 0));
                    defnInfo.setAudioCodec(TVKUtils.optInt(getElementsTagNameStringValue(item, "audio"), 0));
                    defnInfo.setFnName(getElementsTagNameStringValue(item, "sname"));
                    defnInfo.setDefnRate(getElementsTagNameStringValue(item, "resolution"));
                    defnInfo.setHdr10EnHance(TVKUtils.optInt(getElementsTagNameStringValue(item, "hdr10enh"), 0));
                    defnInfo.setVideoSuperResolutionType(TVKUtils.optInt(getElementsTagNameStringValue(item, "tvmsr_v2"), 0));
                    defnInfo.setTVMSRReasonCode(TVKUtils.optInt(getElementsTagNameStringValue(item, "tvmsr_reason_code"), 0));
                    defnInfo.setSuperResolutionNeedVip(TVKUtils.optInt(getElementsTagNameStringValue(item, "tvmsrlmt"), 0));
                    defnInfo.setVfps(TVKUtils.optInt(getElementsTagNameStringValue(item, "vfps"), 0));
                    defnInfo.setRecommend(TVKUtils.optInt(getElementsTagNameStringValue(item, "recommend"), 0));
                    defnInfo.setVideoBandwidth(TVKUtils.optLong(getElementsTagNameStringValue(item, TVKLiveRequestBuilder.RequestParamKey.BANDWIDTH), 0L));
                    defnInfo.setAudioBandwidth(TVKUtils.optLong(getElementsTagNameStringValue(item, "audiobandwidth"), 0L));
                    defnInfo.setM3u8Resolution(getElementsTagNameStringValue(item, "m3u8resolution"));
                    defnInfo.setFeature(TVKUtils.optInt(getElementsTagNameStringValue(item, "feature"), 0));
                    defnInfo.setFormatDefn(getElementsTagNameStringValue(item, "formatdefn"));
                    defnInfo.setGroup(getElementsTagNameStringValue(item, VipFunCallConstants.KEY_GROUP));
                    parseIsAVS(item, defnInfo);
                    if (TextUtils.isEmpty(defnInfo.getDefnName())) {
                        defnInfo.setDefnName(TVKDefinitionUtils.getDefShowName(defnInfo.getDefn()));
                    } else {
                        defnInfo.setDefnName(TVKDefinitionUtils.convertDefnName(defnInfo.getDefnName()));
                    }
                    if (!TextUtils.isEmpty(defnInfo.getDefn())) {
                        tVKVodVideoInfo.addDefinition(defnInfo);
                    }
                    if (TVKUtils.optInt(getElementsTagNameStringValue(item, "sl"), 0) == 1) {
                        tVKVodVideoInfo.setCurDefinition(defnInfo);
                    }
                }
                if (item.getNodeName().equalsIgnoreCase("strategyparam")) {
                    tVKVodVideoInfo.setMaxBitrate(TVKUtils.optLong(getElementsTagNameStringValue(item, "maxbitrate"), 100000000L));
                    tVKVodVideoInfo.setBandwidthLevel(TVKUtils.optInt(getElementsTagNameStringValue(item, "bandwidthlevel"), 0));
                    tVKVodVideoInfo.setStrategyParamExtInfo(getElementsTagNameStringValue(item, QZoneHelper.INTENT_EXTINFO));
                }
            }
        }
        this.mLogger.info("parseVinfoFormatNode, end", new Object[0]);
    }

    private void parseVinfoMultiNetUrlNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        if (nodeList == null) {
            return;
        }
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1 && item.getNodeName().equalsIgnoreCase(SensorJsPlugin.SENSOR_INTERVAL_UI)) {
                TVKVodVideoInfo.TVKVideoMultiNetUrlInfo tVKVideoMultiNetUrlInfo = new TVKVodVideoInfo.TVKVideoMultiNetUrlInfo();
                tVKVideoMultiNetUrlInfo.setUrl(getElementsTagNameStringValue(item, "url"));
                tVKVideoMultiNetUrlInfo.setVt(TVKUtils.optInt(getElementsTagNameStringValue(item, TPReportKeys.PlayerStep.PLAYER_CDN_TYPE), 0));
                tVKVodVideoInfo.addMultiNetUrlInfos(tVKVideoMultiNetUrlInfo);
            }
        }
    }

    private void parseVinfoRootNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, @NonNull Document document) throws Exception {
        this.mLogger.info("parseVinfoRootNode, start", new Object[0]);
        tVKVodVideoInfo.setCgiCode(TVKUtils.optInt(getElementsTagNameStringValue(document, "em"), 0));
        tVKVodVideoInfo.setExem(TVKUtils.optInt(getElementsTagNameStringValue(document, "exem"), 0));
        tVKVodVideoInfo.setDownloadType(TVKUtils.optInt(getElementsTagNameStringValue(document, TPReportKeys.Common.COMMON_DL_TYPE), 0));
        tVKVodVideoInfo.setTm(TVKUtils.optLong(getElementsTagNameStringValue(document, TVKLiveRequestBuilder.RequestParamKey.CKEY_TIMESTAMP), 0L));
        tVKVodVideoInfo.setExpirationTimeSec(TVKUtils.optLong(getElementsTagNameStringValue(document, "ret_valid_tm"), 0L));
        tVKVodVideoInfo.setFp2p(TVKUtils.optInt(getElementsTagNameStringValue(document, "fp2p"), 1));
        tVKVodVideoInfo.setAbTestInfo(TVKUtils.convertRawAbTestInfoToMap(getElementsTagNameStringValue(document, "abtest")));
        tVKVodVideoInfo.setTestId(TVKUtils.optInt(getElementsTagNameStringValue(document, "tstid"), 0));
        tVKVodVideoInfo.setTestBucket(getElementsTagNameStringValue(document, "testbucket"));
        tVKVodVideoInfo.setWanIP(getElementsTagNameStringValue(document, "ip"));
        tVKVodVideoInfo.setReport(getElementsTagNameStringValue(document, "report"));
        tVKVodVideoInfo.setSignature(getElementsTagNameStringValue(document, "signature"));
        NodeList elementsByTagName = document.getElementsByTagName("fl");
        if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
            parseVinfoFormatNode(tVKVodVideoInfo, elementsByTagName.item(0).getChildNodes());
        }
        NodeList elementsByTagName2 = document.getElementsByTagName(LinkReportConstant$EventKey.VALUE);
        if (elementsByTagName2 != null && elementsByTagName2.getLength() > 0) {
            parseVinfoViNode(tVKVodVideoInfo, elementsByTagName2.item(0).getChildNodes());
        }
        List<ITVKVodFeature> list = this.mFeatureList;
        if (list != null) {
            Iterator<ITVKVodFeature> it = list.iterator();
            while (it.hasNext()) {
                it.next().parseVodCGIResponse(tVKVodVideoInfo, document.getFirstChild());
            }
        }
        this.mLogger.info("parseVinfoRootNode, end", new Object[0]);
    }

    private void parseVinfoUrlNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        if (nodeList == null) {
            return;
        }
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1) {
                if (item.getNodeName().equalsIgnoreCase(TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_M3U8)) {
                    tVKVodVideoInfo.setM3u8(getFirstChildNodeValue(item));
                } else if (item.getNodeName().equalsIgnoreCase(SensorJsPlugin.SENSOR_INTERVAL_UI)) {
                    TVKVodVideoInfo.ReferUrl referUrl = new TVKVodVideoInfo.ReferUrl();
                    referUrl.setUrl(getElementsTagNameStringValue(item, "url"));
                    referUrl.setVt(TVKUtils.optInt(getElementsTagNameStringValue(item, TPReportKeys.PlayerStep.PLAYER_CDN_TYPE), 0));
                    referUrl.setSpip(getElementsTagNameStringValue(item, "spip"));
                    referUrl.setSpport(getElementsTagNameStringValue(item, "spport"));
                    referUrl.setPath(getElementsTagNameStringValue(item, "path"));
                    NodeList elementsByTagName = ((Element) item).getElementsByTagName(TVKMediaPlayerConfig.PlayerConfig.FORMAT_ID_HLS);
                    if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                        Node item2 = elementsByTagName.item(0);
                        referUrl.setHk(getElementsTagNameStringValue(item2, "hk"));
                        referUrl.setPt(getElementsTagNameStringValue(item2, "pt"));
                    }
                    if (!referUrl.getUrl().isEmpty()) {
                        tVKVodVideoInfo.addReferUrlItem(tVKVodVideoInfo.getUrlList().size(), referUrl);
                    }
                }
            }
        }
    }

    private void parseVinfoViNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        this.mLogger.info("parseVinfoViNode, start", new Object[0]);
        if (nodeList == null) {
            return;
        }
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1 && item.getNodeName().equalsIgnoreCase("vi")) {
                tVKVodVideoInfo.setVid(getElementsTagNameStringValue(item, "vid"));
                tVKVodVideoInfo.setCid(getElementsTagNameStringValue(item, "cid"));
                tVKVodVideoInfo.setFileName(getElementsTagNameStringValue(item, "fn"));
                tVKVodVideoInfo.setSt(TVKUtils.optInt(getElementsTagNameStringValue(item, "st"), 0));
                tVKVodVideoInfo.setLnk(getElementsTagNameStringValue(item, "lnk"));
                tVKVodVideoInfo.setVKey(getElementsTagNameStringValue(item, "fvkey"));
                tVKVodVideoInfo.setBase(getElementsTagNameStringValue(item, PM.BASE));
                tVKVodVideoInfo.setPayCh(TVKUtils.optInt(getElementsTagNameStringValue(item, "ch"), 0));
                tVKVodVideoInfo.setEnc(TVKUtils.optInt(getElementsTagNameStringValue(item, JsonWebSignature.ENCRYPTION_METHOD), 0));
                tVKVodVideoInfo.setCt(TVKUtils.optInt(getElementsTagNameStringValue(item, LinkReportConstant$GlobalKey.CONNECT_TYPE), 0));
                tVKVodVideoInfo.setDanmuState(TVKUtils.optInt(getElementsTagNameStringValue(item, "dm"), 0));
                tVKVodVideoInfo.setFps(getElementsTagNameStringValue(item, "fps"));
                tVKVodVideoInfo.setKeyid(getElementsTagNameStringValue(item, TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_KEYID));
                tVKVodVideoInfo.setFileSizeByte(TVKUtils.optLong(getElementsTagNameStringValue(item, "fs"), 0L));
                tVKVodVideoInfo.setStartPositionSec(TVKUtils.optInt(getElementsTagNameStringValue(item, "head"), 0));
                tVKVodVideoInfo.setSkipEndPositionSec(TVKUtils.optInt(getElementsTagNameStringValue(item, TextNode.MODE_TAIL), 0));
                tVKVodVideoInfo.setIFlag(TVKUtils.optInt(getElementsTagNameStringValue(item, "iflag"), 0));
                tVKVodVideoInfo.setMediaVideoState(TVKUtils.optInt(getElementsTagNameStringValue(item, "mst"), 0));
                tVKVodVideoInfo.setTargetId(getElementsTagNameStringValue(item, "targetid"));
                tVKVodVideoInfo.setTitle(getElementsTagNameStringValue(item, "ti"));
                tVKVodVideoInfo.setDurationSec((int) TVKUtils.optFloat(getElementsTagNameStringValue(item, "td"), 0.0f));
                tVKVodVideoInfo.setTotalDurationMs(TVKUtils.optLong(getElementsTagNameStringValue(item, "totalduration"), 0L));
                tVKVodVideoInfo.setTie(TVKUtils.optInt(getElementsTagNameStringValue(item, "tie"), 0));
                tVKVodVideoInfo.setType(TVKUtils.optInt(getElementsTagNameStringValue(item, "type"), 0));
                tVKVodVideoInfo.setHeight(TVKUtils.optInt(getElementsTagNameStringValue(item, "vh"), 0));
                tVKVodVideoInfo.setWidth(TVKUtils.optInt(getElementsTagNameStringValue(item, "vw"), 0));
                tVKVodVideoInfo.setWHRadio(TVKUtils.optFloat(getElementsTagNameStringValue(item, "wh"), 0.0f));
                tVKVodVideoInfo.setVideoType(TVKUtils.optInt(getElementsTagNameStringValue(item, "videotype"), 0));
                tVKVodVideoInfo.setMediaVideoType(TVKUtils.optInt(getElementsTagNameStringValue(item, "vr"), 0));
                tVKVodVideoInfo.setVst(TVKUtils.optInt(getElementsTagNameStringValue(item, EventKey.VST), 0));
                tVKVodVideoInfo.setSwhdcp(TVKUtils.optInt(getElementsTagNameStringValue(item, "swhdcp"), 0));
                tVKVodVideoInfo.setBitrate(TVKUtils.optInt(getElementsTagNameStringValue(item, TtmlNode.TAG_BR), 0));
                tVKVodVideoInfo.setFvideo(TVKUtils.optInt(getElementsTagNameStringValue(item, "fvideo"), 0));
                tVKVodVideoInfo.setCached(TVKUtils.optInt(getElementsTagNameStringValue(item, "cached"), 0));
                tVKVodVideoInfo.setFreeNetFlowUrl(TVKUtils.optInt(getElementsTagNameStringValue(item, "freeul"), 0) != 0);
                tVKVodVideoInfo.setVodEncryption(getElementsTagNameStringValue(item, "encryption"));
                tVKVodVideoInfo.setPttn(TVKUtils.optInt(getElementsTagNameStringValue(item, "pttn"), 0));
                tVKVodVideoInfo.setSubtitleNadir(TVKUtils.optFloat(getElementsTagNameStringValue(item, "nadir"), 0.0f));
                tVKVodVideoInfo.setCastSet(getElementsTagNameStringValue(item, "castset"));
                tVKVodVideoInfo.setPlayExperienceLevel(getElementsTagNameStringValue(item, "play_experience_level"));
                tVKVodVideoInfo.setSeReport(getElementsTagNameStringValue(item, "sereport"));
                tVKVodVideoInfo.setSescy(getElementsTagNameStringValue(item, "sescy"));
                tVKVodVideoInfo.setPollingServiceUrl(getElementsTagNameStringValue(item, "pa"));
                tVKVodVideoInfo.setDotInfo(getElementsTagNameStringValue(item, "dotinfo"));
                parseVInfoAdPassNode(tVKVodVideoInfo, item);
                Element element = (Element) item;
                NodeList elementsByTagName = element.getElementsByTagName("cl");
                if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                    parseVinfoClipNode(tVKVodVideoInfo, elementsByTagName.item(0).getChildNodes());
                }
                NodeList elementsByTagName2 = element.getElementsByTagName("ul");
                if (elementsByTagName2 != null && elementsByTagName2.getLength() > 0) {
                    parseVinfoUrlNode(tVKVodVideoInfo, elementsByTagName2.item(0).getChildNodes());
                }
                NodeList elementsByTagName3 = element.getElementsByTagName("pl");
                if (elementsByTagName3 != null && elementsByTagName3.getLength() > 0) {
                    tVKVodVideoInfo.setPLType(2);
                    tVKVodVideoInfo.setPLString(convertNodeToXmlString(elementsByTagName3.item(0)));
                }
                NodeList elementsByTagName4 = element.getElementsByTagName("multi_net_ul");
                if (elementsByTagName4 != null && elementsByTagName4.getLength() > 0) {
                    parseVinfoMultiNetUrlNode(tVKVodVideoInfo, elementsByTagName4.item(0).getChildNodes());
                }
            }
        }
        this.mLogger.info("parseVinfoViNode, end", new Object[0]);
    }

    public TVKGetVinfoData parseVinfo(String str) {
        this.mLogger.info("parseVInfo, start", new Object[0]);
        try {
            String decryptVinfo = TVKVodVinfoDecryptor.decryptVinfo(str);
            if (!TextUtils.isEmpty(decryptVinfo) && decryptVinfo.contains("<?xml")) {
                Document doc = getDoc(decryptVinfo);
                if (doc == null) {
                    return createErrorResult(15);
                }
                TVKGetVinfoData parseNormalVinfo = parseNormalVinfo(doc);
                TVKVodVideoInfo vodInfo = parseNormalVinfo.getVodInfo();
                if (vodInfo != null) {
                    vodInfo.setXml(decryptVinfo);
                }
                return parseNormalVinfo;
            }
            return createErrorResult(13);
        } catch (TVKVodVinfoDecryptor.DecryptException e16) {
            this.mLogger.printException(e16);
            return createErrorResult(32);
        }
    }
}
