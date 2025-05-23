package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Segmentation extends Component {
    private float strokeGap;
    private float strokeWidth;
    private String maskResource = "";
    private ArrayList<Integer> cutRange = new ArrayList<>();
    private boolean strokeEnable = false;
    private String strokeColor = "";
    private String bgColor = "";
    private String strokeBorderType = "";
    private String renderTarget = "";
    private float bgAlpha = 1.0f;
    private boolean segmentFollowFace = false;
    private String strokeTextureResource = "";
    private int strokeTextureRow = 1;
    private int strokeTextureColumn = 1;
    private int strokeTextureItemNum = 1;
    private float strokeSpeedLevel = 50.0f;
    private boolean isMaskInvert = false;
    private int strokeItemHeight = 30;
    private int strokeItemWidth = 30;
    private int strokeItemGap = 30;
    private int strokeItemOffset = 20;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Segmentation) {
            Segmentation segmentation = (Segmentation) componentBase;
            this.maskResource = segmentation.maskResource;
            this.cutRange = segmentation.cutRange;
            this.strokeEnable = segmentation.strokeEnable;
            this.strokeColor = segmentation.strokeColor;
            this.bgColor = segmentation.bgColor;
            this.strokeWidth = segmentation.strokeWidth;
            this.strokeGap = segmentation.strokeGap;
            this.strokeBorderType = segmentation.strokeBorderType;
            this.renderTarget = segmentation.renderTarget;
            this.bgAlpha = segmentation.bgAlpha;
            this.segmentFollowFace = segmentation.segmentFollowFace;
            this.strokeTextureResource = segmentation.strokeTextureResource;
            this.strokeTextureRow = segmentation.strokeTextureRow;
            this.strokeTextureColumn = segmentation.strokeTextureColumn;
            this.strokeTextureItemNum = segmentation.strokeTextureItemNum;
            this.strokeSpeedLevel = segmentation.strokeSpeedLevel;
            this.isMaskInvert = segmentation.isMaskInvert;
            this.strokeItemHeight = segmentation.strokeItemHeight;
            this.strokeItemWidth = segmentation.strokeItemWidth;
            this.strokeItemGap = segmentation.strokeItemGap;
            this.strokeItemOffset = segmentation.strokeItemOffset;
        }
        super.doUpdate(componentBase);
    }

    public float getBgAlpha() {
        return this.bgAlpha;
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public ArrayList<Integer> getCutRange() {
        return this.cutRange;
    }

    public boolean getIsMaskInvert() {
        return this.isMaskInvert;
    }

    public String getMaskResource() {
        return this.maskResource;
    }

    public String getRenderTarget() {
        return this.renderTarget;
    }

    public boolean getSegmentFollowFace() {
        return this.segmentFollowFace;
    }

    public String getStrokeBorderType() {
        return this.strokeBorderType;
    }

    public String getStrokeColor() {
        return this.strokeColor;
    }

    public boolean getStrokeEnable() {
        return this.strokeEnable;
    }

    public float getStrokeGap() {
        return this.strokeGap;
    }

    public int getStrokeItemGap() {
        return this.strokeItemGap;
    }

    public int getStrokeItemHeight() {
        return this.strokeItemHeight;
    }

    public int getStrokeItemOffset() {
        return this.strokeItemOffset;
    }

    public int getStrokeItemWidth() {
        return this.strokeItemWidth;
    }

    public float getStrokeSpeedLevel() {
        return this.strokeSpeedLevel;
    }

    public int getStrokeTextureColumn() {
        return this.strokeTextureColumn;
    }

    public int getStrokeTextureItemNum() {
        return this.strokeTextureItemNum;
    }

    public String getStrokeTextureResource() {
        return this.strokeTextureResource;
    }

    public int getStrokeTextureRow() {
        return this.strokeTextureRow;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public void setBgAlpha(float f16) {
        this.bgAlpha = f16;
        reportPropertyChange("bgAlpha", Float.valueOf(f16));
    }

    public void setBgColor(String str) {
        this.bgColor = str;
        reportPropertyChange("bgColor", str);
    }

    public void setCutRange(ArrayList<Integer> arrayList) {
        this.cutRange = arrayList;
        reportPropertyChange("cutRange", arrayList);
    }

    public void setIsMaskInvert(boolean z16) {
        this.isMaskInvert = z16;
        reportPropertyChange("isMaskInvert", Boolean.valueOf(z16));
    }

    public void setMaskResource(String str) {
        this.maskResource = str;
        reportPropertyChange("maskResource", str);
    }

    public void setRenderTarget(String str) {
        this.renderTarget = str;
        reportPropertyChange("renderTarget", str);
    }

    public void setSegmentFollowFace(boolean z16) {
        this.segmentFollowFace = z16;
        reportPropertyChange("segmentFollowFace", Boolean.valueOf(z16));
    }

    public void setStrokeBorderType(String str) {
        this.strokeBorderType = str;
        reportPropertyChange("strokeBorderType", str);
    }

    public void setStrokeColor(String str) {
        this.strokeColor = str;
        reportPropertyChange("strokeColor", str);
    }

    public void setStrokeEnable(boolean z16) {
        this.strokeEnable = z16;
        reportPropertyChange("strokeEnable", Boolean.valueOf(z16));
    }

    public void setStrokeGap(float f16) {
        this.strokeGap = f16;
        reportPropertyChange("strokeGap", Float.valueOf(f16));
    }

    public void setStrokeItemGap(int i3) {
        this.strokeItemGap = i3;
        reportPropertyChange("strokeItemGap", Integer.valueOf(i3));
    }

    public void setStrokeItemHeight(int i3) {
        this.strokeItemHeight = i3;
        reportPropertyChange("strokeItemHeight", Integer.valueOf(i3));
    }

    public void setStrokeItemOffset(int i3) {
        this.strokeItemOffset = i3;
        reportPropertyChange("strokeItemOffset", Integer.valueOf(i3));
    }

    public void setStrokeItemWidth(int i3) {
        this.strokeItemWidth = i3;
        reportPropertyChange("strokeItemWidth", Integer.valueOf(i3));
    }

    public void setStrokeSpeedLevel(float f16) {
        this.strokeSpeedLevel = f16;
        reportPropertyChange("strokeSpeedLevel", Float.valueOf(f16));
    }

    public void setStrokeTextureColumn(int i3) {
        this.strokeTextureColumn = i3;
        reportPropertyChange("strokeTextureColumn", Integer.valueOf(i3));
    }

    public void setStrokeTextureItemNum(int i3) {
        this.strokeTextureItemNum = i3;
        reportPropertyChange("strokeTextureItemNum", Integer.valueOf(i3));
    }

    public void setStrokeTextureResource(String str) {
        this.strokeTextureResource = str;
        reportPropertyChange("strokeTextureResource", str);
    }

    public void setStrokeTextureRow(int i3) {
        this.strokeTextureRow = i3;
        reportPropertyChange("strokeTextureRow", Integer.valueOf(i3));
    }

    public void setStrokeWidth(float f16) {
        this.strokeWidth = f16;
        reportPropertyChange("strokeWidth", Float.valueOf(f16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Segmentation";
    }
}
