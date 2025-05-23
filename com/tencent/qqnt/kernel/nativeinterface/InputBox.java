package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class InputBox {
    public ArrayList<OptButton> aioButtons = new ArrayList<>();
    public ArrayList<ModelConfig> modelList = new ArrayList<>();
    public int supportCamera;
    public int supportFile;
    public int supportMenu;
    public int supportPanel;
    public int supportPhoto;
    public int supportStory;
    public int supportTelephone;

    public ArrayList<OptButton> getAioButtons() {
        return this.aioButtons;
    }

    public ArrayList<ModelConfig> getModelList() {
        return this.modelList;
    }

    public int getSupportCamera() {
        return this.supportCamera;
    }

    public int getSupportFile() {
        return this.supportFile;
    }

    public int getSupportMenu() {
        return this.supportMenu;
    }

    public int getSupportPanel() {
        return this.supportPanel;
    }

    public int getSupportPhoto() {
        return this.supportPhoto;
    }

    public int getSupportStory() {
        return this.supportStory;
    }

    public int getSupportTelephone() {
        return this.supportTelephone;
    }

    public String toString() {
        return "InputBox{supportPhoto=" + this.supportPhoto + ",supportCamera=" + this.supportCamera + ",supportFile=" + this.supportFile + ",supportMenu=" + this.supportMenu + ",supportPanel=" + this.supportPanel + ",supportTelephone=" + this.supportTelephone + ",supportStory=" + this.supportStory + ",aioButtons=" + this.aioButtons + ",modelList=" + this.modelList + ",}";
    }
}
