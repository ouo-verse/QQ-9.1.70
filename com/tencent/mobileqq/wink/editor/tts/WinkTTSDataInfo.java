package com.tencent.mobileqq.wink.editor.tts;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkTTSDataInfo implements Serializable {
    public static final int TYPE_CONTENT = 1;
    public static final int TYPE_PLACEHOLDER = 0;
    private int category;
    private String displayName;
    private int downloadStatus;
    private int editorOrder;
    private String icon;

    /* renamed from: id, reason: collision with root package name */
    private String f322552id;
    private boolean isPlaying;
    private boolean isSelected;
    private int itemType;
    private String language;
    private String name;
    private int speed;
    private int templateType;
    private float volume;
    private int zShowOrder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WinkTTSDataInfo(int i3) {
        float f16;
        this.itemType = i3;
        if (i3 == 1) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        this.volume = f16;
    }

    public int getCategory() {
        return this.category;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getDownloadStatus() {
        return this.downloadStatus;
    }

    public int getEditorOrder() {
        return this.editorOrder;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.f322552id;
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getName() {
        return this.name;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getTemplateType() {
        return this.templateType;
    }

    public float getVolume() {
        return this.volume;
    }

    public int getzShowOrder() {
        return this.zShowOrder;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void resetStatusFiled() {
        float f16;
        setSelected(false);
        this.downloadStatus = 0;
        if (this.itemType == 1) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        this.volume = f16;
    }

    public void setCategory(int i3) {
        this.category = i3;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setDownloadStatus(int i3) {
        this.downloadStatus = i3;
    }

    public void setEditorOrder(int i3) {
        this.editorOrder = i3;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setId(String str) {
        this.f322552id = str;
    }

    public void setIsPlayingState(boolean z16) {
        this.isPlaying = z16;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPlaying(boolean z16) {
        this.isPlaying = z16;
    }

    public void setSelected(boolean z16) {
        this.isSelected = z16;
    }

    public void setSpeed(int i3) {
        this.speed = i3;
    }

    public void setTemplateType(int i3) {
        this.templateType = i3;
    }

    public void setVolume(float f16) {
        this.volume = f16;
    }

    public void setzShowOrder(int i3) {
        this.zShowOrder = i3;
    }
}
