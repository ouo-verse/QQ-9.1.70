package com.qzone.canvasui.widget;

import android.graphics.Canvas;
import android.widget.ImageView;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.util.g;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.ditto.area.DittoAreaGroup;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes39.dex */
public class CanvasFlexPicAreaGroup extends DittoAreaGroup {
    protected static final String TAG = "CanvasFlexPicAreaGroup";
    protected static final String TEMPLATE_1 = "template_1";
    protected static final String TEMPLATE_2 = "template_2";
    protected static final String TEMPLATE_3 = "template_3";
    private static final String example = "(1,0.75);(0,0,1,0.66);(0,0.66,0.33,1);(0.33,0.66,0.66,1);(0.66,0.66,1,1)";
    public int MAX_DISPLAY_PIC_NUM;
    LayoutAttrSet attrSet;
    private List<float[]> coordinateList;
    private List<float[]> coordinateList1;
    private List<float[]> coordinateList2;
    private List<float[]> coordinateList3;
    private List<CanvasGifArea> gifAreaList;
    private float heightFactorInTemplate1;
    private float heightFactorInTemplate2;
    private float heightFactorInTemplate3;
    DittoHost host;
    private int mHeight;
    public int mUPloadNum;
    private int mWidth;
    private int maxWidth;
    private float withFactorInTemplate1;
    private float withFactorInTemplate2;
    private float withFactorInTemplate3;

    public CanvasFlexPicAreaGroup(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.withFactorInTemplate1 = 0.0f;
        this.heightFactorInTemplate1 = 0.0f;
        this.withFactorInTemplate2 = 0.0f;
        this.heightFactorInTemplate2 = 0.0f;
        this.withFactorInTemplate3 = 0.0f;
        this.heightFactorInTemplate3 = 0.0f;
        this.maxWidth = FeedGlobalEnv.g().getScreenWidth() - (g.a(16.0f) * 2);
        this.coordinateList1 = new ArrayList();
        this.coordinateList2 = new ArrayList();
        this.coordinateList3 = new ArrayList();
        this.coordinateList = new ArrayList();
        this.gifAreaList = new ArrayList();
        this.MAX_DISPLAY_PIC_NUM = 3;
        this.host = dittoHost;
        this.attrSet = layoutAttrSet;
        if (layoutAttrSet != null) {
            try {
                if (layoutAttrSet.hasAttr(TEMPLATE_1)) {
                    String[] split = layoutAttrSet.getAttr(TEMPLATE_1, "").split(";");
                    String replace = split[0].replace("(", "").replace(")", "");
                    this.withFactorInTemplate1 = Float.parseFloat(replace.split(",")[0]);
                    this.heightFactorInTemplate1 = Float.parseFloat(replace.split(",")[1]);
                    this.coordinateList1 = parseCoordinate(split);
                }
                if (layoutAttrSet.hasAttr(TEMPLATE_2)) {
                    String[] split2 = layoutAttrSet.getAttr(TEMPLATE_2, "").split(";");
                    String replace2 = split2[0].replace("(", "").replace(")", "");
                    this.withFactorInTemplate2 = Float.parseFloat(replace2.split(",")[0]);
                    this.heightFactorInTemplate2 = Float.parseFloat(replace2.split(",")[1]);
                    this.coordinateList2 = parseCoordinate(split2);
                }
                if (layoutAttrSet.hasAttr(TEMPLATE_3)) {
                    String[] split3 = layoutAttrSet.getAttr(TEMPLATE_3, "").split(";");
                    String replace3 = split3[0].replace("(", "").replace(")", "");
                    this.withFactorInTemplate3 = Float.parseFloat(replace3.split(",")[0]);
                    this.heightFactorInTemplate3 = Float.parseFloat(replace3.split(",")[1]);
                    this.coordinateList3 = parseCoordinate(split3);
                }
            } catch (Exception e16) {
                b.c(TAG, e16.toString());
            }
        }
        init();
    }

    private void layoutChildren() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            List<float[]> list = this.coordinateList;
            if (list == null || list.size() < childCount) {
                return;
            }
            getChildAt(i3).layout((int) (this.mWidth * this.coordinateList.get(i3)[0]), (int) (this.mHeight * this.coordinateList.get(i3)[1]), (int) (this.mWidth * this.coordinateList.get(i3)[2]), (int) (this.mHeight * this.coordinateList.get(i3)[3]));
        }
    }

    private List<float[]> parseCoordinate(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 1; i3 < strArr.length; i3++) {
            String[] split = strArr[i3].replace("(", "").replace(")", "").split(",");
            arrayList.add(new float[]{Float.parseFloat(split[0]), Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3])});
        }
        return arrayList;
    }

    @Override // com.tencent.ditto.area.DittoArea
    public int getType() {
        return 9;
    }

    @Override // com.tencent.ditto.area.DittoAreaGroup, com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onLayout(int i3, int i16, int i17, int i18) {
        super.onLayout(i3, i16, i17, i18);
        layoutChildren();
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    public void onStateScrolling() {
        stopGif();
    }

    public void setPicUploadNum(int i3, int i16) {
        this.mUPloadNum = i3;
        this.MAX_DISPLAY_PIC_NUM = Math.min(i16, 3);
    }

    public void playGIF() {
        int i3 = 0;
        while (true) {
            List<CanvasGifArea> list = this.gifAreaList;
            if (list == null || i3 >= list.size()) {
                break;
            }
            this.gifAreaList.get(i3).playGif();
            i3++;
        }
        i.H().J1(2);
    }

    public void stopGif() {
        int i3 = 0;
        while (true) {
            List<CanvasGifArea> list = this.gifAreaList;
            if (list == null || i3 >= list.size()) {
                return;
            }
            this.gifAreaList.get(i3).stopGif();
            i3++;
        }
    }

    public void setPicInfos(FeedPictureInfo[] feedPictureInfoArr, boolean z16, boolean z17) {
        if (feedPictureInfoArr == null) {
            return;
        }
        try {
            if (feedPictureInfoArr.length == 1) {
                int i3 = this.maxWidth;
                this.mWidth = (int) (i3 * this.withFactorInTemplate1);
                this.mHeight = (int) (i3 * this.heightFactorInTemplate1);
                addImageArea(feedPictureInfoArr, this.coordinateList1);
                this.coordinateList = this.coordinateList1;
            } else if (feedPictureInfoArr.length == 2) {
                int i16 = this.maxWidth;
                this.mWidth = (int) (i16 * this.withFactorInTemplate2);
                this.mHeight = (int) (i16 * this.heightFactorInTemplate2);
                addImageArea(feedPictureInfoArr, this.coordinateList2);
                this.coordinateList = this.coordinateList2;
            } else if (feedPictureInfoArr.length == 3) {
                int i17 = this.maxWidth;
                this.mWidth = (int) (i17 * this.withFactorInTemplate3);
                this.mHeight = (int) (i17 * this.heightFactorInTemplate3);
                addImageArea(feedPictureInfoArr, this.coordinateList3);
                this.coordinateList = this.coordinateList3;
            }
        } catch (Exception e16) {
            b.c(TAG, e16.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addImageArea(FeedPictureInfo[] feedPictureInfoArr, List<float[]> list) {
        TagImageArea tagImageArea;
        removeAllChildren();
        for (int i3 = 0; i3 < feedPictureInfoArr.length && i3 < 3; i3++) {
            int i16 = (int) (this.mWidth * list.get(i3)[0]);
            int i17 = (int) (this.mHeight * list.get(i3)[1]);
            int i18 = (int) (this.mWidth * list.get(i3)[2]);
            int i19 = (int) (this.mHeight * list.get(i3)[3]);
            if (feedPictureInfoArr[i3].d() == FeedPictureInfo.ImageType.IMAGE_GIF) {
                CanvasGifArea canvasGifArea = new CanvasGifArea(this.host, this.attrSet);
                canvasGifArea.setGifImage(feedPictureInfoArr[i3].b().imageUrl, feedPictureInfoArr[i3].b().url, i18 - i16, i19 - i17);
                this.gifAreaList.add(canvasGifArea);
                tagImageArea = canvasGifArea;
            } else {
                TagImageArea tagImageArea2 = new TagImageArea(this.host, this.attrSet);
                tagImageArea2.setIfShowPlayButton(true);
                if (feedPictureInfoArr[i3].h() != null) {
                    String str = feedPictureInfoArr[i3].h().url;
                    ImageLoader.Options obtain = ImageLoader.Options.obtain();
                    tagImageArea2.setDimens(i18 - i16, i19 - this.height);
                    tagImageArea2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    tagImageArea2.setImage(feedPictureInfoArr[i3], 0L, null, AreaManager.DEFAULT_BACKGROUND, obtain);
                    tagImageArea = tagImageArea2;
                } else {
                    b.c(TAG, "infos[i].getUrl() is null");
                    tagImageArea = tagImageArea2;
                }
            }
            int i26 = this.mUPloadNum;
            int i27 = this.MAX_DISPLAY_PIC_NUM;
            if (i26 > i27 && i3 == i27 - 1) {
                if (tagImageArea instanceof CanvasGifArea) {
                    ((CanvasGifArea) tagImageArea).setMongLayer(i26 - i27, true);
                } else if (tagImageArea instanceof TagImageArea) {
                    TagImageArea tagImageArea3 = tagImageArea;
                    tagImageArea3.setMongLayer(i26 - i27, true);
                    tagImageArea3.setIfShowPlayButton(false);
                }
            }
            LayoutAttrSet layoutAttrSet = new LayoutAttrSet();
            layoutAttrSet.addLayoutAttr("visibility", NodeProps.VISIBLE);
            addChild(tagImageArea, layoutAttrSet);
        }
    }

    private void init() {
    }
}
