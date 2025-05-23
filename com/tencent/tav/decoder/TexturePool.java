package com.tencent.tav.decoder;

import com.tencent.filter.GLSLRender;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes26.dex */
public class TexturePool implements ITexturePool {
    private static final String TAG = "TexturePool";
    private List<TextureInfo> textureInfoList = new ArrayList();
    private long MaxCacheSize = 207360000;
    private int MaxCacheLength = 60;

    public TexturePool() {
        Logger.d(TAG, "TexturePool: create " + Thread.currentThread().getId());
    }

    private synchronized void adaptCacheSize() {
        while (this.textureInfoList.size() > 0 && this.textureInfoList.size() - this.MaxCacheLength > 0) {
            this.textureInfoList.get(0).release();
            this.textureInfoList.remove(0);
        }
    }

    private synchronized void adapterCacheMemorySize() {
        long j3 = 0;
        int i3 = 0;
        while (i3 < this.textureInfoList.size()) {
            TextureInfo textureInfo = this.textureInfoList.get(i3);
            j3 += textureInfo.width * textureInfo.height;
            if (j3 > this.MaxCacheSize) {
                Logger.v(TAG, "texture: release " + textureInfo + " - " + Thread.currentThread());
                textureInfo.release();
                this.textureInfoList.remove(i3);
                i3--;
            }
            i3++;
        }
    }

    @Override // com.tencent.tav.decoder.ITexturePool
    public synchronized TextureInfo popTexture(int i3, int i16, int i17) {
        for (int i18 = 0; i18 < this.textureInfoList.size(); i18++) {
            TextureInfo textureInfo = this.textureInfoList.get(i18);
            if (textureInfo.textureType == i3 && textureInfo.width == i16 && textureInfo.height == i17) {
                Logger.v(TAG, "popTexture: hint pool " + textureInfo.textureID);
                return this.textureInfoList.remove(i18);
            }
        }
        int createTexture = RenderContext.createTexture(i3);
        adaptCacheSize();
        adapterCacheMemorySize();
        return new TextureInfo(createTexture, GLSLRender.GL_TEXTURE_2D, i16, i17, null, 0);
    }

    @Override // com.tencent.tav.decoder.ITexturePool
    public synchronized void pushTexture(TextureInfo textureInfo) {
        for (int i3 = 0; i3 < this.textureInfoList.size(); i3++) {
            TextureInfo textureInfo2 = this.textureInfoList.get(i3);
            if (textureInfo2.textureType == textureInfo.textureType && textureInfo2.textureID == textureInfo.textureID) {
                Logger.v(TAG, "pushTexture: hint pool  " + textureInfo2.textureID);
                textureInfo.release();
                return;
            }
        }
        Logger.v(TAG, "pushTexture: push in " + textureInfo.textureID + " - " + Thread.currentThread());
        this.textureInfoList.add(textureInfo);
    }

    @Override // com.tencent.tav.decoder.ITexturePool
    public synchronized void release() {
        Logger.d(TAG, " release all " + Thread.currentThread().getId());
        for (int i3 = 0; i3 < this.textureInfoList.size(); i3++) {
            this.textureInfoList.get(i3).release();
        }
    }

    @Override // com.tencent.tav.decoder.ITexturePool
    public void setMaxCacheLength(int i3) {
        this.MaxCacheLength = i3;
        adapterCacheMemorySize();
    }

    @Override // com.tencent.tav.decoder.ITexturePool
    public void setMaxCacheSize(long j3) {
        this.MaxCacheSize = j3;
        adaptCacheSize();
    }
}
