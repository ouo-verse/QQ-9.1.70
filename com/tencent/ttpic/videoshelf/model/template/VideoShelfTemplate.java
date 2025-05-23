package com.tencent.ttpic.videoshelf.model.template;

import com.google.gson.annotations.Expose;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VideoShelfTemplate {

    @Expose
    private String audioName;

    @Expose
    private List<String> crazyFaceList;

    @Expose
    private String desc;

    @Expose
    private String filterLutName;

    @Expose
    private List<VideoFrameItem> frameList;

    @Expose
    private int frameSize;

    @Expose
    private int itemID;
    private String materialPath;

    @Expose
    private String name;

    @Expose
    private int needWatermark;

    @Expose
    private List<MaskNodeGroup> nodeGroupList;

    @Expose
    private String pagFileName;

    @Expose
    private String previewVideoName;

    @Expose
    private int previewVideoType;

    @Expose
    private String tip;

    @Expose
    private int[] tipTemplate;

    @Expose
    private int version;

    @Expose
    private int videoHeight;

    @Expose
    private String videoName;

    @Expose
    private int videoTemplateType;

    @Expose
    private int videoWidth;

    @Expose
    private float[] watermarkRect;
    private boolean isFromAssets = false;
    private List<String> fullpathCrazyFaceFileName = new ArrayList();

    public String getAudioPath() {
        String str = getMaterialPath() + File.separator + this.audioName;
        if (this.isFromAssets) {
            return str.replace("assets://", "");
        }
        return str;
    }

    public List<String> getCrazyFaceList() {
        List<String> list = this.fullpathCrazyFaceFileName;
        if (list != null && list.size() > 0) {
            return this.fullpathCrazyFaceFileName;
        }
        List<String> list2 = this.crazyFaceList;
        if (list2 != null && list2.size() > 0) {
            Iterator<String> it = this.crazyFaceList.iterator();
            while (it.hasNext()) {
                String str = getMaterialPath() + File.separator + it.next();
                if (this.isFromAssets) {
                    str.replace("assets://", "");
                }
                this.fullpathCrazyFaceFileName.add(str);
            }
        }
        return this.fullpathCrazyFaceFileName;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getFilterLutName() {
        return this.filterLutName;
    }

    public String getFilterLutPath() {
        return getMaterialPath() + File.separator + this.filterLutName;
    }

    public List<VideoFrameItem> getFrameList() {
        return this.frameList;
    }

    public int getFrameSize() {
        return this.frameSize;
    }

    public int getItemID() {
        return this.itemID;
    }

    public String getMaterialPath() {
        return this.materialPath;
    }

    public String getName() {
        return this.name;
    }

    public int getNeedWatermark() {
        return this.needWatermark;
    }

    public List<MaskNodeGroup> getNodeGroupList() {
        return this.nodeGroupList;
    }

    public String getPagFileName() {
        return this.pagFileName;
    }

    public String getPagFilePath() {
        String str = getMaterialPath() + File.separator + getPagFileName();
        if (this.isFromAssets) {
            return str.replace("assets://", "");
        }
        return str;
    }

    public String getPreviewVideoName() {
        return this.previewVideoName;
    }

    public String getPreviewVideoPath() {
        String str = getMaterialPath() + File.separator + getPreviewVideoName();
        if (this.isFromAssets) {
            return str.replace("assets://", "");
        }
        return str;
    }

    public int getPreviewVideoType() {
        return this.previewVideoType;
    }

    public String getTip() {
        return this.tip;
    }

    public int[] getTipTemplate() {
        return this.tipTemplate;
    }

    public int getVersion() {
        return this.version;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public String getVideoName() {
        String str = this.videoName;
        if (str == null) {
            return "Video_Pag.mp4";
        }
        return str;
    }

    public String getVideoPath() {
        String str = getMaterialPath() + File.separator + getVideoName();
        if (this.isFromAssets) {
            return str.replace("assets://", "");
        }
        return str;
    }

    public int getVideoTemplateType() {
        return this.videoTemplateType;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public float[] getWatermarkRect() {
        return this.watermarkRect;
    }

    public boolean isFromAssets() {
        return this.isFromAssets;
    }

    public void setFromAssets(boolean z16) {
        this.isFromAssets = z16;
    }

    public void setMaterialPath(String str) {
        this.materialPath = str;
    }
}
