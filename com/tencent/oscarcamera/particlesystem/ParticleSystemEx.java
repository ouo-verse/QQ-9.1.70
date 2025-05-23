package com.tencent.oscarcamera.particlesystem;

import android.content.Context;
import com.google.gson.JsonObject;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.GsonUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes22.dex */
public class ParticleSystemEx {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    private AdvanceRes[] mAdvanceRes;
    private List<ParticleTemplate> mClouds;
    final Context mContext;
    private long mNativeCtx;
    private FloatBuffer mParticleCenterBuffer;
    private FloatBuffer mParticleColorBuffer;
    private FloatBuffer mParticleSizeBuffer;
    private FloatBuffer mParticleTexCoord;
    private float[] mPositionIndex;
    private Map<Sprite, ParticleTemplate> mSpriteMap;

    /* loaded from: classes22.dex */
    private class TexCoord {
        static IPatchRedirector $redirector_;
        float[] texCoord;

        TexCoord() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ParticleSystemEx.this);
            } else {
                this.texCoord = new float[12];
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12913);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            TAG = ParticleSystemEx.class.getSimpleName();
        }
    }

    public ParticleSystemEx(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mClouds = new ArrayList();
        this.mSpriteMap = new HashMap();
        this.mContext = context;
        this.mNativeCtx = nativeInit();
    }

    private void createCache(int i3, int i16) {
        this.mPositionIndex = new float[i16 * 6];
        int i17 = 0;
        while (true) {
            float[] fArr = this.mPositionIndex;
            if (i17 < fArr.length) {
                fArr[i17] = (i17 % 6) + 0.5f;
                i17++;
            } else {
                int i18 = i3 * 6;
                this.mParticleCenterBuffer = ByteBuffer.allocateDirect(i18 * 3 * 32).order(ByteOrder.nativeOrder()).asFloatBuffer();
                int i19 = i18 * 2 * 32;
                this.mParticleSizeBuffer = ByteBuffer.allocateDirect(i19).order(ByteOrder.nativeOrder()).asFloatBuffer();
                this.mParticleTexCoord = ByteBuffer.allocateDirect(i19).order(ByteOrder.nativeOrder()).asFloatBuffer();
                this.mParticleColorBuffer = ByteBuffer.allocateDirect(i18 * 4 * 32).order(ByteOrder.nativeOrder()).asFloatBuffer();
                return;
            }
        }
    }

    private void loadFinish() {
        this.mAdvanceRes = new AdvanceRes[this.mClouds.size()];
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < this.mClouds.size(); i17++) {
            int i18 = this.mClouds.get(i17).mMaxCount;
            i3 += i18;
            if (i18 > i16) {
                i16 = i18;
            }
            this.mAdvanceRes[i17] = new AdvanceRes();
        }
        nativeRegisterTemplate(this.mNativeCtx, this.mClouds.toArray());
        createCache(i3, i16);
    }

    private void loadParticle(String str) {
        String str2;
        JsonObject jsonObject;
        try {
            if (str.startsWith("/")) {
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(str));
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 1024);
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else {
                        sb5.append(readLine);
                    }
                }
                str2 = sb5.toString();
                inputStreamReader.close();
            } else {
                InputStream open = this.mContext.getAssets().open(str);
                byte[] bArr = new byte[open.available()];
                open.read(bArr);
                String str3 = new String(bArr);
                open.close();
                str2 = str3;
            }
            try {
                jsonObject = GsonUtils.json2JsonObject(str2);
            } catch (Exception e16) {
                LogUtils.e(TAG, e16.getMessage());
                jsonObject = null;
            }
            ParticleTemplate fromJson = ParticleTemplate.fromJson(this, jsonObject, str.substring(0, str.lastIndexOf(47)));
            if (fromJson != null) {
                this.mClouds.add(fromJson);
                this.mSpriteMap.put(fromJson.mSprite, fromJson);
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    public static native void nativeAdvance(long j3, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, FloatBuffer floatBuffer3, FloatBuffer floatBuffer4, AdvanceRes[] advanceResArr);

    public static native void nativeEmitAt(long j3, double d16, double d17, double d18);

    public static native long nativeInit();

    public static native void nativeRegisterTemplate(long j3, Object[] objArr);

    public static native void nativeRelease(long j3);

    public List<FrameParticleData> advance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.mClouds.isEmpty()) {
            return null;
        }
        nativeAdvance(this.mNativeCtx, this.mParticleCenterBuffer, this.mParticleSizeBuffer, this.mParticleTexCoord, this.mParticleColorBuffer, this.mAdvanceRes);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.mAdvanceRes.length; i3++) {
            FrameParticleData frameParticleData = new FrameParticleData();
            arrayList.add(frameParticleData);
            AdvanceRes advanceRes = this.mAdvanceRes[i3];
            int i16 = advanceRes.particleCount;
            frameParticleData.particleCount = i16;
            frameParticleData.positionIndex = Arrays.copyOf(this.mPositionIndex, i16 * 6);
            frameParticleData.particleCenter = new float[advanceRes.particleCenterLen];
            this.mParticleCenterBuffer.position(advanceRes.particleCenterOffset);
            this.mParticleCenterBuffer.get(frameParticleData.particleCenter);
            frameParticleData.particleSize = new float[advanceRes.particleSizeLen];
            this.mParticleSizeBuffer.position(advanceRes.particleSizeOffset);
            this.mParticleSizeBuffer.get(frameParticleData.particleSize);
            frameParticleData.texCoords = new float[advanceRes.texCoordsLen];
            this.mParticleTexCoord.position(advanceRes.texCoordsOffset);
            this.mParticleTexCoord.get(frameParticleData.texCoords);
            frameParticleData.particleColor = new float[advanceRes.particleColorLen];
            this.mParticleColorBuffer.position(advanceRes.particleColorOffset);
            this.mParticleColorBuffer.get(frameParticleData.particleColor);
            frameParticleData.audioPath = this.mClouds.get(i3).mSprite.audioPath;
            frameParticleData.playAudio = advanceRes.playAudio;
            frameParticleData.blendMode = this.mClouds.get(i3).mSprite.blendMode;
        }
        return arrayList;
    }

    public void emitImmediately(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
        } else {
            nativeEmitAt(this.mNativeCtx, f16, f17, f18);
        }
    }

    protected void finalize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            release();
        }
    }

    public List<Sprite> getSprites() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ParticleTemplate> it = this.mClouds.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().mSprite);
        }
        return arrayList;
    }

    public void loadParticleData(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        if (list == null) {
            return;
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                loadParticle(it.next());
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        loadFinish();
    }

    public void loadTestData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("assets://flower1.json");
        loadParticleData(arrayList);
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        long j3 = this.mNativeCtx;
        if (j3 != -1) {
            nativeRelease(j3);
            this.mNativeCtx = -1L;
        }
    }
}
