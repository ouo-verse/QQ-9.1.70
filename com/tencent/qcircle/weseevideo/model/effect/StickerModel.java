package com.tencent.qcircle.weseevideo.model.effect;

import android.graphics.Bitmap;
import com.tencent.qcircle.tavcut.bean.SolidData;
import com.tencent.qcircle.tavcut.bean.TextItem;
import com.tencent.qcircle.weseevideo.composition.effectnode.VideoEffectType;
import com.tencent.tav.coremedia.TextureInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class StickerModel extends VideoPagModel {
    protected Bitmap bitmap;
    protected LimitArea limitArea;
    protected String textPngPath;
    protected TextureInfo textureInfo;
    protected String texturePngPath;
    protected long endTime = 0;
    protected int layerIndex = -1;
    boolean lockRatio = true;
    boolean enableRotate = true;
    protected float scale = 0.5f;
    private float scaleX = 0.5f;
    private float scaleY = 0.5f;
    private float xScaleMax = 0.0f;
    private float yScaleMax = 0.0f;
    private float xScaleMin = 0.0f;
    private float yScaleMin = 0.0f;
    protected float rotate = 0.0f;
    protected float centerX = 0.0f;
    protected float centerY = 0.0f;
    public boolean editable = true;
    protected int width = 0;
    protected int height = 0;
    protected float minScale = 0.0f;
    protected float maxScale = 0.0f;
    protected List<TextItem> textItems = new ArrayList();
    protected Map<String, SolidData> solidItems = new HashMap();
    protected String type = "";
    protected String materialId = "";
    protected String fontId = "";
    protected int interactive = 0;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class LimitArea {

        /* renamed from: x, reason: collision with root package name */
        public float f342456x = 0.0f;

        /* renamed from: y, reason: collision with root package name */
        public float f342457y = 0.0f;
        public float width = 1.0f;
        public float height = 1.0f;

        public LimitArea() {
        }
    }

    public StickerModel() {
        this.effectType = VideoEffectType.TYPE_STICKER.value;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public float getCenterX() {
        return this.centerX;
    }

    public float getCenterY() {
        return this.centerY;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getFontId() {
        return this.fontId;
    }

    public int getHeight() {
        return this.height;
    }

    public int getInteractive() {
        return this.interactive;
    }

    public int getLayerIndex() {
        return this.layerIndex;
    }

    public LimitArea getLimitArea() {
        return this.limitArea;
    }

    public String getMaterialId() {
        return this.materialId;
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public float getMinScale() {
        return this.minScale;
    }

    public float getRotate() {
        return this.rotate;
    }

    public float getScale() {
        return this.scale;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleXMax() {
        return this.xScaleMax;
    }

    public float getScaleXMin() {
        return this.xScaleMin;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public float getScaleYMax() {
        return this.yScaleMax;
    }

    public float getScaleYMin() {
        return this.yScaleMin;
    }

    public Map<String, SolidData> getSolidItems() {
        return this.solidItems;
    }

    public List<TextItem> getTextItems() {
        return this.textItems;
    }

    public String getTextPngPath() {
        return this.textPngPath;
    }

    public TextureInfo getTextureInfo() {
        return this.textureInfo;
    }

    public String getTexturePngPath() {
        return this.texturePngPath;
    }

    public String getType() {
        return this.type;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isEditable() {
        return this.editable;
    }

    public boolean isEnableRotate() {
        return this.enableRotate;
    }

    public boolean isLockRatio() {
        return this.lockRatio;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setCenterX(float f16) {
        this.centerX = f16;
    }

    public void setCenterY(float f16) {
        this.centerY = f16;
    }

    public void setEditable(boolean z16) {
        this.editable = z16;
    }

    public void setEnableRotate(boolean z16) {
        this.enableRotate = z16;
    }

    public void setEndTime(long j3) {
        this.endTime = j3;
    }

    public void setFontId(String str) {
        this.fontId = str;
    }

    public void setHeight(int i3) {
        this.height = i3;
    }

    public void setInteractive(int i3) {
        this.interactive = i3;
    }

    public void setLayerIndex(int i3) {
        this.layerIndex = i3;
    }

    public void setLimitArea(LimitArea limitArea) {
        this.limitArea = limitArea;
    }

    public void setLockRatio(boolean z16) {
        this.lockRatio = z16;
    }

    public void setMaterialId(String str) {
        this.materialId = str;
    }

    public void setMaxScale(float f16) {
        this.maxScale = f16;
    }

    public void setMinScale(float f16) {
        this.minScale = f16;
    }

    public void setRotate(float f16) {
        this.rotate = f16;
    }

    public void setScale(float f16) {
        this.scale = f16;
    }

    public void setScaleX(float f16) {
        this.scaleX = f16;
    }

    public void setScaleXMax(float f16) {
        this.xScaleMax = f16;
    }

    public void setScaleXMin(float f16) {
        this.xScaleMin = f16;
    }

    public void setScaleY(float f16) {
        this.scaleY = f16;
    }

    public void setScaleYMax(float f16) {
        this.yScaleMax = f16;
    }

    public void setScaleYMin(float f16) {
        this.yScaleMin = f16;
    }

    public void setSolidItems(Map<String, SolidData> map) {
        this.solidItems = map;
    }

    public void setTextItems(List<TextItem> list) {
        this.textItems = list;
    }

    public void setTextPngPath(String str) {
        this.textPngPath = str;
    }

    public void setTextureInfo(TextureInfo textureInfo) {
        this.textureInfo = textureInfo;
    }

    public void setTexturePngPath(String str) {
        this.texturePngPath = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setWidth(int i3) {
        this.width = i3;
    }
}
