package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKVodPlayerFeature;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import java.util.Map;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes23.dex */
public abstract class TVKVodPlayerFeatureBase implements ITVKVodPlayerFeature {
    private static final String MODULE_NAME = "TVKVodPlayerFeatureBase";
    protected boolean mEnable = true;
    protected final ITVKLogger mLogger;

    public TVKVodPlayerFeatureBase(@NonNull TVKContext tVKContext) {
        this.mLogger = new TVKLogger(tVKContext, MODULE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getElementsTagNameStringValue(@NonNull Node node, @NonNull String str) {
        NodeList elementsByTagName = ((Element) node).getElementsByTagName(str);
        if (elementsByTagName != null && elementsByTagName.getLength() != 0) {
            return elementsByTagName.item(0).getTextContent();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addSpvideoCapability(@NonNull Map<String, String> map, int i3) {
        map.put(TVKCommonParamEnum.REQ_PARAM_KEY_SPVIDEO, String.valueOf(i3 | TVKUtils.optInt(map.get(TVKCommonParamEnum.REQ_PARAM_KEY_SPVIDEO), 0)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getFirstChildNodeValue(Node node) {
        if (node != null && node.getFirstChild() != null) {
            return node.getFirstChild().getNodeValue();
        }
        return "";
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase
    public boolean isEnable() {
        return this.mEnable;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase
    public void reset() {
        setEnable(true);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase
    public void setEnable(boolean z16) {
        this.mEnable = z16;
    }
}
