package com.tencent.ttpic.openapi.extrastickerutil;

import java.util.HashMap;

/* loaded from: classes27.dex */
public class ExtraStickerParserAgent {
    private static ExtraStickerParserAgent sInstance;
    private IExtraParserFactoryListener mPagFactoryListener;
    private HashMap<Integer, IExtraParserFactoryListener> mParsersMap;

    public static ExtraStickerParserAgent getInstance() {
        if (sInstance == null) {
            sInstance = new ExtraStickerParserAgent();
        }
        return sInstance;
    }

    public void clear() {
        HashMap<Integer, IExtraParserFactoryListener> hashMap = this.mParsersMap;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.mPagFactoryListener = null;
    }

    public IExtraStickerParser creatExtraParser(int i3) {
        IExtraParserFactoryListener iExtraParserFactoryListener;
        HashMap<Integer, IExtraParserFactoryListener> hashMap = this.mParsersMap;
        if (hashMap != null && (iExtraParserFactoryListener = hashMap.get(Integer.valueOf(i3))) != null) {
            return iExtraParserFactoryListener.creatExtraStickerParser();
        }
        return null;
    }

    public IExtraStickerParser creatPagParser() {
        IExtraParserFactoryListener iExtraParserFactoryListener = this.mPagFactoryListener;
        if (iExtraParserFactoryListener != null) {
            return iExtraParserFactoryListener.creatExtraStickerParser();
        }
        return null;
    }

    public boolean isInExtraParser(int i3) {
        HashMap<Integer, IExtraParserFactoryListener> hashMap = this.mParsersMap;
        if (hashMap != null) {
            return hashMap.containsKey(Integer.valueOf(i3));
        }
        return false;
    }

    public void setExtraParserFactoryListener(int i3, IExtraParserFactoryListener iExtraParserFactoryListener) {
        if (this.mParsersMap == null) {
            this.mParsersMap = new HashMap<>();
        }
        this.mParsersMap.put(Integer.valueOf(i3), iExtraParserFactoryListener);
    }

    public void setPagFactoryListener(IExtraParserFactoryListener iExtraParserFactoryListener) {
        this.mPagFactoryListener = iExtraParserFactoryListener;
    }
}
