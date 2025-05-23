package com.tencent.qcircle.tavcut.bean;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TextEditorData {
    public static final String BACKGROUND = "bgcolor";
    private String blurTextPath;
    private String blurTexturePath;
    private Map<String, Integer> colorList;
    private String content;
    private String fontPath;
    private String interactive;
    private String itemID;
    private String pagFilePath;
    private String stickerType;
    private int textColor;
    private int type;
    private String uniqueID;

    public TextEditorData() {
        this.colorList = new HashMap();
        this.interactive = "0";
    }

    public String getBlurTextPath() {
        return this.blurTextPath;
    }

    public String getBlurTexturePath() {
        return this.blurTexturePath;
    }

    public Map<String, Integer> getColorList() {
        return this.colorList;
    }

    public String getContent() {
        return this.content;
    }

    public String getFontPath() {
        return this.fontPath;
    }

    public String getInteractive() {
        return this.interactive;
    }

    public String getItemID() {
        return this.itemID;
    }

    public String getPagFilePath() {
        return this.pagFilePath;
    }

    public String getStickerType() {
        return this.stickerType;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public int getType() {
        return this.type;
    }

    public String getUniqueID() {
        return this.uniqueID;
    }

    public void setBackGroundColor(String str, int i3) {
        this.colorList.put(str, Integer.valueOf(i3));
    }

    public void setBlurTextPath(String str) {
        this.blurTextPath = str;
    }

    public void setBlurTexturePath(String str) {
        this.blurTexturePath = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFont(String str) {
        this.fontPath = str;
    }

    public void setInteractive(String str) {
        this.interactive = str;
    }

    public void setItemID(String str) {
        this.itemID = str;
    }

    public void setPagFilePath(String str) {
        this.pagFilePath = str;
    }

    public void setStickerType(String str) {
        this.stickerType = str;
    }

    public void setTextColor(int i3) {
        this.textColor = i3;
    }

    public void setType(int i3) {
        this.type = i3;
    }

    public void setUniqueID(String str) {
        this.uniqueID = str;
    }

    public TextEditorData(String str, String str2, int i3, String str3, String str4, String str5, int i16) {
        HashMap hashMap = new HashMap();
        this.colorList = hashMap;
        this.interactive = "0";
        this.uniqueID = str;
        this.itemID = str2;
        this.textColor = i3;
        this.content = str3;
        this.pagFilePath = str4;
        this.fontPath = str5;
        hashMap.put(BACKGROUND, Integer.valueOf(i16));
    }
}
