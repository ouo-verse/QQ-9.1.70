package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$EventKey;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodDrmFeatureUtils {
    private static void parseVinfoViNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        if (nodeList == null) {
            return;
        }
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1 && "vi".equalsIgnoreCase(item.getNodeName())) {
                tVKVodVideoInfo.setCkc(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "ckc"));
                tVKVodVideoInfo.setDrm(TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, TVKCommonParamEnum.REQ_PARAM_KEY_DRM), 0));
                return;
            }
        }
    }

    public static void parseVodCGIResponse(@NonNull TVKVodVideoInfo tVKVodVideoInfo, @NonNull Node node) throws Exception {
        NodeList elementsByTagName;
        if (TextUtils.isEmpty(tVKVodVideoInfo.getCkc()) && (elementsByTagName = ((Element) node).getElementsByTagName(LinkReportConstant$EventKey.VALUE)) != null && elementsByTagName.getLength() > 0) {
            parseVinfoViNode(tVKVodVideoInfo, elementsByTagName.item(0).getChildNodes());
        }
    }
}
