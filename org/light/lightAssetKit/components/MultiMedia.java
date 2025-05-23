package org.light.lightAssetKit.components;

import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.BackgroundFillMode;
import org.light.lightAssetKit.enums.PAGScaleMode;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MultiMedia extends Component {
    private float fillScale = 1.0f;
    private float volume = 1.0f;
    private float speed = 1.0f;
    private BackgroundFillMode backgroundFillMode = BackgroundFillMode.GaussianBlur;
    private String backgroundColor = "";
    private boolean fixedBackground = false;
    private int imageEffect = 0;
    private Size size = new Size();
    private ArrayList<VolumeEffect> volumeEffects = new ArrayList<>();
    private PAGScaleMode scaleMode = PAGScaleMode.LetterBox;
    private Matrix matrix = new Matrix();
    private String src = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof MultiMedia) {
            MultiMedia multiMedia = (MultiMedia) componentBase;
            this.fillScale = multiMedia.fillScale;
            this.volume = multiMedia.volume;
            this.speed = multiMedia.speed;
            this.backgroundFillMode = multiMedia.backgroundFillMode;
            this.backgroundColor = multiMedia.backgroundColor;
            this.fixedBackground = multiMedia.fixedBackground;
            this.imageEffect = multiMedia.imageEffect;
            this.size = multiMedia.size;
            this.volumeEffects = multiMedia.volumeEffects;
            this.scaleMode = multiMedia.scaleMode;
            this.matrix = multiMedia.matrix;
            this.src = multiMedia.src;
        }
        super.doUpdate(componentBase);
    }

    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    public BackgroundFillMode getBackgroundFillMode() {
        return this.backgroundFillMode;
    }

    public float getFillScale() {
        return this.fillScale;
    }

    public boolean getFixedBackground() {
        return this.fixedBackground;
    }

    public int getImageEffect() {
        return this.imageEffect;
    }

    public Matrix getMatrix() {
        return this.matrix;
    }

    public PAGScaleMode getScaleMode() {
        return this.scaleMode;
    }

    public Size getSize() {
        return this.size;
    }

    public float getSpeed() {
        return this.speed;
    }

    public String getSrc() {
        return this.src;
    }

    public float getVolume() {
        return this.volume;
    }

    public ArrayList<VolumeEffect> getVolumeEffects() {
        return this.volumeEffects;
    }

    public void setBackgroundColor(String str) {
        this.backgroundColor = str;
        reportPropertyChange("backgroundColor", str);
    }

    public void setBackgroundFillMode(BackgroundFillMode backgroundFillMode) {
        this.backgroundFillMode = backgroundFillMode;
        reportPropertyChange("backgroundFillMode", backgroundFillMode);
    }

    public void setFillScale(float f16) {
        this.fillScale = f16;
        reportPropertyChange("fillScale", Float.valueOf(f16));
    }

    public void setFixedBackground(boolean z16) {
        this.fixedBackground = z16;
        reportPropertyChange("fixedBackground", Boolean.valueOf(z16));
    }

    public void setImageEffect(int i3) {
        this.imageEffect = i3;
        reportPropertyChange("imageEffect", Integer.valueOf(i3));
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
        reportPropertyChange("matrix", matrix);
    }

    public void setScaleMode(PAGScaleMode pAGScaleMode) {
        this.scaleMode = pAGScaleMode;
        reportPropertyChange(HippyQQPagViewController.PropertyName.SCALE_MODE, pAGScaleMode);
    }

    public void setSize(Size size) {
        this.size = size;
        reportPropertyChange("size", size);
    }

    public void setSpeed(float f16) {
        this.speed = f16;
        reportPropertyChange("speed", Float.valueOf(f16));
    }

    public void setSrc(String str) {
        this.src = str;
        reportPropertyChange("src", str);
    }

    public void setVolume(float f16) {
        this.volume = f16;
        reportPropertyChange(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, Float.valueOf(f16));
    }

    public void setVolumeEffects(ArrayList<VolumeEffect> arrayList) {
        this.volumeEffects = arrayList;
        reportPropertyChange(JsonUtils.KEY_VOLUME_EFFECTS, arrayList);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "MultiMedia";
    }
}
