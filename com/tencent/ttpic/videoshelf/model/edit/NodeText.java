package com.tencent.ttpic.videoshelf.model.edit;

import android.graphics.PointF;
import com.tencent.ttpic.videoshelf.model.template.NodeTextGroup;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NodeText {
    public String alignment;
    public float blurAmount;
    public String color;
    public int editType;
    public int emboss;
    public String fmtstr;
    public int fontBold;
    public int fontFit;
    public int fontItalics;
    public String fontName;
    public float fontSize;
    public int height;

    /* renamed from: id, reason: collision with root package name */
    public String f381713id;
    public int multiRow;
    public int offsetX;
    public int offsetY;
    public String outerStrokeColor;
    public float outerStrokeSize;
    public String relativeID;
    public String shadowColor;
    public float shadowDx;
    public float shadowDy;
    public String strokeColor;
    public float strokeSize;
    public int vertical;
    public int width;
    public int wmtype;
    public PointF relativeAnchor = new PointF();
    public PointF anchor = new PointF();

    public void copyFrom(NodeTextGroup nodeTextGroup) {
        this.f381713id = nodeTextGroup.f381716id;
        this.relativeID = nodeTextGroup.relativeID;
        float[] fArr = nodeTextGroup.relativeAnchor;
        if (fArr != null && fArr.length == 2) {
            PointF pointF = this.relativeAnchor;
            pointF.x = fArr[0];
            pointF.y = fArr[1];
        }
        float[] fArr2 = nodeTextGroup.anchor;
        if (fArr2 != null && fArr2.length == 2) {
            PointF pointF2 = this.anchor;
            pointF2.x = fArr2[0];
            pointF2.y = fArr2[1];
        }
        this.offsetX = nodeTextGroup.offsetX;
        this.offsetY = nodeTextGroup.offsetY;
        this.width = nodeTextGroup.width;
        this.height = nodeTextGroup.height;
        this.editType = nodeTextGroup.editType;
        this.fontSize = nodeTextGroup.fontSize;
        this.fontFit = nodeTextGroup.fontFit;
        this.wmtype = nodeTextGroup.wmtype;
        this.fmtstr = nodeTextGroup.fmtstr;
        this.fontName = nodeTextGroup.fontName;
        this.color = nodeTextGroup.color;
        this.alignment = nodeTextGroup.alignment;
        this.shadowColor = nodeTextGroup.shadowColor;
        this.shadowDx = nodeTextGroup.shadowDx;
        this.shadowDy = nodeTextGroup.shadowDy;
        this.blurAmount = nodeTextGroup.blurAmount;
        this.vertical = nodeTextGroup.vertical;
        this.fontBold = nodeTextGroup.fontBold;
        this.fontItalics = nodeTextGroup.fontItalics;
        this.strokeColor = nodeTextGroup.strokeColor;
        this.strokeSize = nodeTextGroup.strokeSize;
        this.emboss = nodeTextGroup.emboss;
        this.outerStrokeColor = nodeTextGroup.outerStrokeColor;
        this.outerStrokeSize = nodeTextGroup.outerStrokeSize;
        this.multiRow = nodeTextGroup.multiRow;
    }

    public void copyFrom(NodeText nodeText) {
        this.f381713id = nodeText.f381713id;
        this.relativeID = nodeText.relativeID;
        PointF pointF = nodeText.relativeAnchor;
        if (pointF != null) {
            this.relativeAnchor.set(pointF);
        }
        PointF pointF2 = nodeText.anchor;
        if (pointF2 != null) {
            this.anchor.set(pointF2);
        }
        this.offsetX = nodeText.offsetX;
        this.offsetY = nodeText.offsetY;
        this.width = nodeText.width;
        this.height = nodeText.height;
        this.editType = nodeText.editType;
        this.fontSize = nodeText.fontSize;
        this.fontFit = nodeText.fontFit;
        this.wmtype = nodeText.wmtype;
        this.fmtstr = nodeText.fmtstr;
        this.fontName = nodeText.fontName;
        this.color = nodeText.color;
        this.alignment = nodeText.alignment;
        this.shadowColor = nodeText.shadowColor;
        this.shadowDx = nodeText.shadowDx;
        this.shadowDy = nodeText.shadowDy;
        this.blurAmount = nodeText.blurAmount;
        this.vertical = nodeText.vertical;
        this.fontBold = nodeText.fontBold;
        this.fontItalics = nodeText.fontItalics;
        this.strokeColor = nodeText.strokeColor;
        this.strokeSize = nodeText.strokeSize;
        this.emboss = nodeText.emboss;
        this.outerStrokeColor = nodeText.outerStrokeColor;
        this.outerStrokeSize = nodeText.outerStrokeSize;
        this.multiRow = nodeText.multiRow;
    }
}
