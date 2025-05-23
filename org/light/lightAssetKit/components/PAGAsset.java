package org.light.lightAssetKit.components;

import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.PAGScaleMode;

/* loaded from: classes29.dex */
public class PAGAsset extends Component {
    private ArrayList<ReplaceItem> replacement = new ArrayList<>();
    private ArrayList<LayerScaleMode> layerScaleModes = new ArrayList<>();
    private PAGScaleMode scaleMode = PAGScaleMode.LetterBox;
    private String musicID = "";
    private boolean ignoreInputAlpha = false;
    private String portraitSrc = "";
    private String landscapeSrc = "";
    private String src = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof PAGAsset) {
            PAGAsset pAGAsset = (PAGAsset) componentBase;
            this.replacement = pAGAsset.replacement;
            this.layerScaleModes = pAGAsset.layerScaleModes;
            this.scaleMode = pAGAsset.scaleMode;
            this.musicID = pAGAsset.musicID;
            this.ignoreInputAlpha = pAGAsset.ignoreInputAlpha;
            this.portraitSrc = pAGAsset.portraitSrc;
            this.landscapeSrc = pAGAsset.landscapeSrc;
            this.src = pAGAsset.src;
        }
        super.doUpdate(componentBase);
    }

    public boolean getIgnoreInputAlpha() {
        return this.ignoreInputAlpha;
    }

    public String getLandscapeSrc() {
        return this.landscapeSrc;
    }

    public ArrayList<LayerScaleMode> getLayerScaleModes() {
        return this.layerScaleModes;
    }

    public String getMusicID() {
        return this.musicID;
    }

    public String getPortraitSrc() {
        return this.portraitSrc;
    }

    public ArrayList<ReplaceItem> getReplacement() {
        return this.replacement;
    }

    public PAGScaleMode getScaleMode() {
        return this.scaleMode;
    }

    public String getSrc() {
        return this.src;
    }

    public void setIgnoreInputAlpha(boolean z16) {
        this.ignoreInputAlpha = z16;
        reportPropertyChange("ignoreInputAlpha", Boolean.valueOf(z16));
    }

    public void setLandscapeSrc(String str) {
        this.landscapeSrc = str;
        reportPropertyChange("landscapeSrc", str);
    }

    public void setLayerScaleModes(ArrayList<LayerScaleMode> arrayList) {
        this.layerScaleModes = arrayList;
        reportPropertyChange("layerScaleModes", arrayList);
    }

    public void setMusicID(String str) {
        this.musicID = str;
        reportPropertyChange("musicID", str);
    }

    public void setPortraitSrc(String str) {
        this.portraitSrc = str;
        reportPropertyChange("portraitSrc", str);
    }

    public void setReplacement(ArrayList<ReplaceItem> arrayList) {
        this.replacement = arrayList;
        reportPropertyChange("replacement", arrayList);
    }

    public void setScaleMode(PAGScaleMode pAGScaleMode) {
        this.scaleMode = pAGScaleMode;
        reportPropertyChange(HippyQQPagViewController.PropertyName.SCALE_MODE, pAGScaleMode);
    }

    public void setSrc(String str) {
        this.src = str;
        reportPropertyChange("src", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "PAGAsset";
    }
}
