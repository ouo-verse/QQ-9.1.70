package com.qwallet.temp.impl;

import android.content.Context;
import android.view.View;
import com.qwallet.temp.ISpriteVideoViewTemp;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SpriteVideoViewTempImpl implements ISpriteVideoViewTemp {
    private final SpriteVideoView mSpriteVideoView;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements FrameSprite.a {
        a(ISpriteVideoViewTemp.a aVar) {
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.a
        public void a() {
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements FrameSprite.a {
        b(ISpriteVideoViewTemp.a aVar) {
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.a
        public void a() {
            throw null;
        }
    }

    public SpriteVideoViewTempImpl(Context context, boolean z16) {
        this.mSpriteVideoView = new SpriteVideoView(context, z16);
    }

    @Override // com.qwallet.temp.ISpriteVideoViewTemp
    public View getView() {
        return this.mSpriteVideoView;
    }

    @Override // com.qwallet.temp.ISpriteVideoViewTemp
    public void play(String str, int i3, ISpriteVideoViewTemp.a aVar) {
        this.mSpriteVideoView.w(str, i3, new a(aVar));
    }

    @Override // com.qwallet.temp.ISpriteVideoViewTemp
    public void setCenterCrop(boolean z16) {
        this.mSpriteVideoView.setCenterCrop(z16);
    }

    @Override // com.qwallet.temp.ISpriteVideoViewTemp
    public void setFilePath(String str) {
        this.mSpriteVideoView.setFilePath(str);
    }

    @Override // com.qwallet.temp.ISpriteVideoViewTemp
    public void setId(int i3) {
        this.mSpriteVideoView.setId(i3);
    }

    @Override // com.qwallet.temp.ISpriteVideoViewTemp
    public void setLooping(boolean z16) {
        this.mSpriteVideoView.setLooping(z16);
    }

    @Override // com.qwallet.temp.ISpriteVideoViewTemp
    public void setPivotX(float f16) {
        this.mSpriteVideoView.setPivotX(f16);
    }

    @Override // com.qwallet.temp.ISpriteVideoViewTemp
    public void setPivotY(float f16) {
        this.mSpriteVideoView.setPivotY(f16);
    }

    @Override // com.qwallet.temp.ISpriteVideoViewTemp
    public void stop() {
        this.mSpriteVideoView.y();
    }

    @Override // com.qwallet.temp.ISpriteVideoViewTemp
    public void play(String str, ISpriteVideoViewTemp.a aVar) {
        this.mSpriteVideoView.x(str, new b(aVar));
    }
}
