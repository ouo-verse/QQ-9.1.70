package com.tencent.ttpic.gles;

import android.opengl.EGLContext;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GLSharedData {
    private EGLContext mSharedContext;
    public TextureDataPipe[] mTexturePile;

    public GLSharedData(EGLContext eGLContext) {
        this.mSharedContext = eGLContext;
        TextureDataPipe[] textureDataPipeArr = new TextureDataPipe[2];
        this.mTexturePile = textureDataPipeArr;
        textureDataPipeArr[0] = new TextureDataPipe();
        this.mTexturePile[1] = new TextureDataPipe();
    }

    public void clear() {
        for (TextureDataPipe textureDataPipe : this.mTexturePile) {
            textureDataPipe.release();
        }
    }

    public TextureDataPipe getCurrentTexturePile() {
        boolean z16;
        boolean z17;
        if (this.mTexturePile[0].getTexureCurrentStatus() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.mTexturePile[1].getTexureCurrentStatus() == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 && z17) {
            TextureDataPipe[] textureDataPipeArr = this.mTexturePile;
            TextureDataPipe textureDataPipe = textureDataPipeArr[0];
            long j3 = textureDataPipe.mTimestamp;
            TextureDataPipe textureDataPipe2 = textureDataPipeArr[1];
            if (j3 >= textureDataPipe2.mTimestamp) {
                return textureDataPipe2;
            }
            return textureDataPipe;
        }
        if (z16) {
            return this.mTexturePile[0];
        }
        if (z17) {
            return this.mTexturePile[1];
        }
        return null;
    }

    public TextureDataPipe getFreeTexturePileMakeBusy() {
        int i3 = 0;
        while (true) {
            TextureDataPipe[] textureDataPipeArr = this.mTexturePile;
            if (i3 < textureDataPipeArr.length) {
                if (textureDataPipeArr[i3].getTexureCurrentStatus() == 0) {
                    TextureDataPipe textureDataPipe = this.mTexturePile[i3];
                    textureDataPipe.makeBusy();
                    return textureDataPipe;
                }
                i3++;
            } else {
                return null;
            }
        }
    }

    public boolean judgeBrotherTextureIsReady(TextureDataPipe textureDataPipe) {
        TextureDataPipe[] textureDataPipeArr = this.mTexturePile;
        TextureDataPipe textureDataPipe2 = textureDataPipeArr[0];
        if (textureDataPipe2 == textureDataPipe) {
            textureDataPipe2 = textureDataPipeArr[1];
        }
        if (textureDataPipe2.getTexureCurrentStatus() != 2) {
            return false;
        }
        return true;
    }
}
