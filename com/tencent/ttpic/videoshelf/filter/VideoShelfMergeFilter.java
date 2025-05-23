package com.tencent.ttpic.videoshelf.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.template.FrameNodeItem;
import com.tencent.ttpic.videoshelf.model.template.MaskBlock;
import com.tencent.ttpic.videoshelf.model.template.MaskRectPoint;
import com.tencent.ttpic.videoshelf.model.template.NodeRectPoint;
import com.tencent.ttpic.videoshelf.model.template.VideoFrameItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VideoShelfMergeFilter extends VideoFilterBase {
    private static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec3 textureCoordinate2;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform int renderBackgroud;\nuniform int blendMode;\nhighp vec4 blendColor(in highp vec4 texColor, in highp vec4 canvasColor)\n{\n    highp vec3 vOne = vec3(1.0, 1.0, 1.0);\n    highp vec3 vZero = vec3(0.0, 0.0, 0.0);\n    highp vec3 resultFore = texColor.rgb;\n    if (blendMode <= 1 || blendMode > 14){ //default, since used most, put on top\n    } else if (blendMode == 2) {  //multiply\n        resultFore = canvasColor.rgb * texColor.rgb;\n    } else if (blendMode == 3){    //screen\n        resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n    } else if (blendMode == 4){    //overlay\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n        if (canvasColor.r >= 0.5) {\n            resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n        }\n        if (canvasColor.g >= 0.5) {\n            resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n        }\n        if (canvasColor.b >= 0.5) {\n            resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n        }\n    } else if (blendMode == 5){    //hardlight\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n        if (texColor.r >= 0.5) {\n            resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n        }\n        if (texColor.g >= 0.5) {\n            resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n        }\n        if (texColor.b >= 0.5) {\n            resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n        }\n    } else if (blendMode == 6){    //softlight\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n        if (texColor.r >= 0.5) {\n            resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n        }\n        if (texColor.g >= 0.5) {\n            resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n        }\n        if (texColor.b >= 0.5) {\n            resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n        }\n    } else if (blendMode == 7){    //divide\n        resultFore = vOne;\n        if (texColor.r > 0.0) {\n            resultFore.r = canvasColor.r / texColor.r;\n        }\n        if (texColor.g > 0.0) {\n            resultFore.g = canvasColor.g / texColor.g;\n        }\n        if (texColor.b > 0.0) {\n            resultFore.b = canvasColor.b / texColor.b;\n        }\n        resultFore = min(vOne, resultFore);\n    } else if (blendMode == 8){    //add\n        resultFore = canvasColor.rgb + texColor.rgb;\n        resultFore = min(vOne, resultFore);\n    } else if (blendMode == 9){    //substract\n        resultFore = canvasColor.rgb - texColor.rgb;\n        resultFore = max(vZero, resultFore);\n    } else if (blendMode == 10){   //diff\n        resultFore = abs(canvasColor.rgb - texColor.rgb);\n    } else if (blendMode == 11){   //darken\n        resultFore = min(canvasColor.rgb, texColor.rgb);\n    } else if (blendMode == 12){   //lighten\n        resultFore = max(canvasColor.rgb, texColor.rgb);\n    }\n    highp vec4 resultColor = mix(canvasColor.rgba, vec4(resultFore.rgb, texColor.a), texColor.a);\n    return resultColor;\n}\nvoid main()\n{\n    highp vec4 textureColor = texture2D(inputImageTexture2, textureCoordinate2.xy/textureCoordinate2.z);\n    highp vec4 outputColor = texture2D(inputImageTexture, textureCoordinate);\n    highp vec4 temp = vec4(1.0, 1.0, 1.0, 0.0);\n    if (renderBackgroud == 1) {\n        temp = blendColor(textureColor, outputColor);\n        outputColor = temp; // mix(temp, outputColor, outputColor.a);\n    } else {\n        temp = blendColor(outputColor, textureColor);\n        outputColor = temp; // mix(temp, outputColor, outputColor.a);\n    }\n    //if(outputColor.a != 1.0) {\n    //    outputColor = vec4(1.0, 0, 0, 1.0);\n    //}\n    gl_FragColor = outputColor;\n}\n";
    public static final int IMAGE_INDEX = 10000;
    private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nattribute vec3 inputTextureCoordinate2;\nvarying vec2 textureCoordinate;\nvarying vec3 textureCoordinate2;\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n    textureCoordinate2 = inputTextureCoordinate2;\n}\n";
    private int inBmpTexture;
    private float[] initFloats;
    private int mBlendMode;
    private BaseFilter mCopyFilter;
    private Frame[] mCopyFrame;
    private int mFrameCount;
    private VideoFrameItem mFrameItem;
    private List<FrameNodeItem> mFrameNodeItemList;
    List<NodeGroup> mNodeGroupList;
    private Frame mRenderFrame;
    private List<VideoFrameItem> mVideoFrameItemList;

    /* renamed from: q0, reason: collision with root package name */
    private float f381709q0;

    /* renamed from: q1, reason: collision with root package name */
    private float f381710q1;

    /* renamed from: q2, reason: collision with root package name */
    private float f381711q2;

    /* renamed from: q3, reason: collision with root package name */
    private float f381712q3;
    private boolean rendered;

    public VideoShelfMergeFilter(List<VideoFrameItem> list, List<NodeGroup> list2) {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        this.mFrameCount = 0;
        this.mFrameItem = new VideoFrameItem();
        this.mFrameNodeItemList = new ArrayList();
        this.mNodeGroupList = new ArrayList();
        this.mBlendMode = 1;
        this.mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        this.mCopyFrame = new Frame[2];
        this.mRenderFrame = new Frame();
        this.initFloats = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.rendered = false;
        this.mVideoFrameItemList = list;
        this.mNodeGroupList = list2;
        setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
        initParams();
    }

    private float[] convertMaskToTexCoord(MaskRectPoint[] maskRectPointArr) {
        float[] fArr = new float[12];
        if (maskRectPointArr.length >= 4) {
            MaskRectPoint maskRectPoint = maskRectPointArr[0];
            MaskRectPoint maskRectPoint2 = maskRectPointArr[1];
            MaskRectPoint maskRectPoint3 = maskRectPointArr[2];
            MaskRectPoint maskRectPoint4 = maskRectPointArr[3];
            fArr[0] = maskRectPoint4.f381714x;
            fArr[1] = maskRectPoint4.f381715y;
            float f16 = maskRectPoint3.f381714x;
            fArr[2] = f16;
            float f17 = maskRectPoint3.f381715y;
            fArr[3] = f17;
            float f18 = maskRectPoint.f381714x;
            fArr[4] = f18;
            float f19 = maskRectPoint.f381715y;
            fArr[5] = f19;
            fArr[6] = f16;
            fArr[7] = f17;
            fArr[8] = maskRectPoint2.f381714x;
            fArr[9] = maskRectPoint2.f381715y;
            fArr[10] = f18;
            fArr[11] = f19;
        }
        return fArr;
    }

    private float[] convertTexCoord(NodeRectPoint[] nodeRectPointArr) {
        float[] fArr = new float[12];
        if (nodeRectPointArr.length >= 4) {
            NodeRectPoint nodeRectPoint = nodeRectPointArr[0];
            NodeRectPoint nodeRectPoint2 = nodeRectPointArr[1];
            NodeRectPoint nodeRectPoint3 = nodeRectPointArr[2];
            NodeRectPoint nodeRectPoint4 = nodeRectPointArr[3];
            fArr[0] = nodeRectPoint4.f381714x;
            fArr[1] = nodeRectPoint4.f381715y;
            float f16 = nodeRectPoint3.f381714x;
            fArr[2] = f16;
            float f17 = nodeRectPoint3.f381715y;
            fArr[3] = f17;
            float f18 = nodeRectPoint.f381714x;
            fArr[4] = f18;
            float f19 = nodeRectPoint.f381715y;
            fArr[5] = f19;
            fArr[6] = f16;
            fArr[7] = f17;
            fArr[8] = nodeRectPoint2.f381714x;
            fArr[9] = nodeRectPoint2.f381715y;
            fArr[10] = f18;
            fArr[11] = f19;
        }
        return fArr;
    }

    private float[] convertTexCoordNoAffi(NodeRectPoint[] nodeRectPointArr) {
        float[] fArr = new float[18];
        if (nodeRectPointArr.length >= 4) {
            NodeRectPoint nodeRectPoint = nodeRectPointArr[0];
            NodeRectPoint nodeRectPoint2 = nodeRectPointArr[1];
            NodeRectPoint nodeRectPoint3 = nodeRectPointArr[2];
            NodeRectPoint nodeRectPoint4 = nodeRectPointArr[3];
            if (!this.rendered) {
                this.f381709q0 = 1.0f;
                this.f381711q2 = 1.0f;
                this.f381712q3 = 1.0f;
                this.f381710q1 = 1.0f;
            }
            float f16 = nodeRectPoint4.f381714x;
            float f17 = this.f381712q3;
            fArr[0] = f16 * f17;
            fArr[1] = nodeRectPoint4.f381715y * f17;
            fArr[2] = f17;
            float f18 = nodeRectPoint3.f381714x;
            float f19 = this.f381711q2;
            fArr[3] = f18 * f19;
            float f26 = nodeRectPoint3.f381715y;
            fArr[4] = f26 * f19;
            fArr[5] = f19;
            float f27 = nodeRectPoint.f381714x;
            float f28 = this.f381709q0;
            fArr[6] = f27 * f28;
            float f29 = nodeRectPoint.f381715y;
            fArr[7] = f29 * f28;
            fArr[8] = f28;
            fArr[9] = f18 * f19;
            fArr[10] = f26 * f19;
            fArr[11] = f19;
            float f36 = nodeRectPoint2.f381714x;
            float f37 = this.f381710q1;
            fArr[12] = f36 * f37;
            fArr[13] = nodeRectPoint2.f381715y * f37;
            fArr[14] = f37;
            fArr[15] = f27 * f28;
            fArr[16] = f29 * f28;
            fArr[17] = f28;
        }
        return fArr;
    }

    private float[] convertVertex(MaskRectPoint[] maskRectPointArr) {
        float[] fArr = new float[12];
        if (maskRectPointArr.length >= 4) {
            MaskRectPoint maskRectPoint = maskRectPointArr[0];
            MaskRectPoint maskRectPoint2 = maskRectPointArr[1];
            MaskRectPoint maskRectPoint3 = maskRectPointArr[2];
            MaskRectPoint maskRectPoint4 = maskRectPointArr[3];
            drawNonAffine(maskRectPoint.f381714x, maskRectPoint.f381715y, maskRectPoint2.f381714x, maskRectPoint2.f381715y, maskRectPoint3.f381714x, maskRectPoint3.f381715y, maskRectPoint4.f381714x, maskRectPoint4.f381715y);
            fArr[0] = (maskRectPoint4.f381714x * 2.0f) - 1.0f;
            fArr[1] = (maskRectPoint4.f381715y * 2.0f) - 1.0f;
            float f16 = maskRectPoint3.f381714x;
            fArr[2] = (f16 * 2.0f) - 1.0f;
            float f17 = maskRectPoint3.f381715y;
            fArr[3] = (f17 * 2.0f) - 1.0f;
            float f18 = maskRectPoint.f381714x;
            fArr[4] = (f18 * 2.0f) - 1.0f;
            float f19 = maskRectPoint.f381715y;
            fArr[5] = (f19 * 2.0f) - 1.0f;
            fArr[6] = (f16 * 2.0f) - 1.0f;
            fArr[7] = (f17 * 2.0f) - 1.0f;
            fArr[8] = (maskRectPoint2.f381714x * 2.0f) - 1.0f;
            fArr[9] = (maskRectPoint2.f381715y * 2.0f) - 1.0f;
            fArr[10] = (f18 * 2.0f) - 1.0f;
            fArr[11] = (f19 * 2.0f) - 1.0f;
        }
        return fArr;
    }

    private Bitmap getBitmapFromNodeGroupList(int i3) {
        for (int i16 = 0; i16 < this.mNodeGroupList.size(); i16++) {
            List<NodeItem> list = this.mNodeGroupList.get(i16).nodeItemList;
            for (int i17 = 0; i17 < list.size(); i17++) {
                if (list.get(i17).nodeID == i3) {
                    if (list.get(i17).cropBitmap != null) {
                        return list.get(i17).cropBitmap;
                    }
                    return list.get(i17).bitmap;
                }
            }
        }
        return null;
    }

    private Frame getSpaceFrame(int i3) {
        Frame frame = this.mCopyFrame[0];
        if (frame != null && i3 == frame.getTextureId()) {
            return this.mCopyFrame[1];
        }
        return this.mCopyFrame[0];
    }

    private void sortFrameNodeItem(List<FrameNodeItem> list) {
        if (list != null && list.size() > 1) {
            Collections.sort(list, new Comparator<FrameNodeItem>() { // from class: com.tencent.ttpic.videoshelf.filter.VideoShelfMergeFilter.1FrameNodeItemComparetor
                @Override // java.util.Comparator
                public int compare(FrameNodeItem frameNodeItem, FrameNodeItem frameNodeItem2) {
                    int zIndex;
                    int zIndex2;
                    if (frameNodeItem.getZIndex() > 10000 && frameNodeItem2.getZIndex() > 10000) {
                        zIndex = frameNodeItem.getZIndex();
                        zIndex2 = frameNodeItem2.getZIndex();
                    } else {
                        if (frameNodeItem.getZIndex() < 10000 && frameNodeItem2.getZIndex() < 10000) {
                            return frameNodeItem2.getZIndex() - frameNodeItem.getZIndex();
                        }
                        zIndex = frameNodeItem.getZIndex();
                        zIndex2 = frameNodeItem2.getZIndex();
                    }
                    return zIndex - zIndex2;
                }
            });
        }
    }

    private void sortMaskBlocksList(List<MaskBlock> list) {
        if (list != null && list.size() > 1) {
            Collections.sort(list, new Comparator<MaskBlock>() { // from class: com.tencent.ttpic.videoshelf.filter.VideoShelfMergeFilter.1MaskBlockComparetor
                @Override // java.util.Comparator
                public int compare(MaskBlock maskBlock, MaskBlock maskBlock2) {
                    return maskBlock2.getZIndex() - maskBlock.getZIndex();
                }
            });
        }
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void ApplyGLSLFilter() {
        super.ApplyGLSLFilter();
        int i3 = 0;
        while (true) {
            Frame[] frameArr = this.mCopyFrame;
            if (i3 < frameArr.length) {
                frameArr[i3] = new Frame();
                i3++;
            } else {
                int[] iArr = new int[1];
                GlUtil.glGenTextures(1, iArr, 0);
                this.inBmpTexture = iArr[0];
                return;
            }
        }
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void clearGLSLSelf() {
        super.clearGLSLSelf();
        this.mCopyFilter.clearGLSL();
        this.mRenderFrame.clear();
        int i3 = 0;
        while (true) {
            Frame[] frameArr = this.mCopyFrame;
            if (i3 < frameArr.length) {
                frameArr[i3].clear();
                i3++;
            } else {
                GLES20.glDeleteBuffers(1, new int[]{this.inBmpTexture}, 0);
                return;
            }
        }
    }

    public void drawNonAffine(float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29) {
        float f36 = f26 - f16;
        float f37 = f27 - f17;
        float f38 = f28 - f18;
        float f39 = f29 - f19;
        float f46 = (f36 * f39) - (f37 * f38);
        if (f46 != 0.0f) {
            float f47 = f17 - f19;
            float f48 = f16 - f18;
            float f49 = ((f36 * f47) - (f37 * f48)) / f46;
            if (f49 > 0.0f && f49 < 1.0f) {
                float f56 = ((f38 * f47) - (f39 * f48)) / f46;
                if (f56 > 0.0f && f56 < 1.0f) {
                    this.f381709q0 = 1.0f / (1.0f - f56);
                    this.f381710q1 = 1.0f / (1.0f - f49);
                    this.f381711q2 = 1.0f / f56;
                    this.f381712q3 = 1.0f / f49;
                    this.rendered = true;
                }
            }
        }
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void initAttribParams() {
        super.initAttribParams();
        addAttribParam("inputTextureCoordinate2", this.initFloats, false);
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void initParams() {
        addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
        addParam(new UniformParam.IntParam("renderBackgroud", 0));
        addParam(new UniformParam.IntParam(c.W, 0));
        this.mCopyFilter.apply();
    }

    public void update(int i3) {
        if (i3 >= this.mVideoFrameItemList.size()) {
            return;
        }
        this.mFrameCount = i3;
        int i16 = 0;
        while (true) {
            if (i16 >= this.mVideoFrameItemList.size()) {
                break;
            }
            if (this.mFrameCount == this.mVideoFrameItemList.get(i16).getFrameID()) {
                this.mFrameItem = this.mVideoFrameItemList.get(i16);
                break;
            }
            i16++;
        }
        List<FrameNodeItem> nodeList = this.mFrameItem.getNodeList();
        this.mFrameNodeItemList = nodeList;
        sortFrameNodeItem(nodeList);
    }

    public Frame updateAndRender(int i3, int i16, int i17) {
        Frame frame = null;
        int i18 = i3;
        for (int i19 = 0; i19 < this.mFrameNodeItemList.size(); i19++) {
            int nodeID = this.mFrameNodeItemList.get(i19).getNodeID();
            int zIndex = this.mFrameNodeItemList.get(i19).getZIndex();
            int blendMode = this.mFrameNodeItemList.get(i19).getBlendMode();
            List<MaskBlock> maskBlockList = this.mFrameNodeItemList.get(i19).getMaskBlockList();
            sortMaskBlocksList(maskBlockList);
            GlUtil.loadTexture(this.inBmpTexture, getBitmapFromNodeGroupList(nodeID));
            addParam(new UniformParam.TextureParam("inputImageTexture2", this.inBmpTexture, 33986));
            addParam(new UniformParam.IntParam(c.W, blendMode));
            if (zIndex >= 10000) {
                addParam(new UniformParam.IntParam("renderBackgroud", 1));
            } else {
                addParam(new UniformParam.IntParam("renderBackgroud", 0));
            }
            for (int i26 = 0; i26 < maskBlockList.size(); i26++) {
                MaskRectPoint[] maskRect = maskBlockList.get(i26).getMaskRect();
                NodeRectPoint[] nodeRect = maskBlockList.get(i26).getNodeRect();
                float[] convertVertex = convertVertex(maskRect);
                float[] convertTexCoordNoAffi = convertTexCoordNoAffi(nodeRect);
                float[] convertMaskToTexCoord = convertMaskToTexCoord(maskRect);
                setPositions(convertVertex);
                setCoordNum(6);
                setTexCords(convertMaskToTexCoord);
                addAttribParam(new AttributeParam("inputTextureCoordinate2", convertTexCoordNoAffi, 3, false));
                frame = getSpaceFrame(i18);
                this.mCopyFilter.RenderProcess(i18, i16 * 2, i17 * 2, -1, 0.0d, frame);
                OnDrawFrameGLSL();
                renderTexture(i18, i16, i17);
                i18 = frame.getTextureId();
            }
        }
        if (frame != null) {
            this.mCopyFilter.RenderProcess(frame.getTextureId(), i16, i17, -1, 0.0d, this.mRenderFrame);
        }
        return this.mRenderFrame;
    }
}
