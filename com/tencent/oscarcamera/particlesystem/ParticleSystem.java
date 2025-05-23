package com.tencent.oscarcamera.particlesystem;

import android.content.Context;
import android.util.Pair;
import com.google.gson.JsonObject;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.GsonUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* loaded from: classes22.dex */
public class ParticleSystem {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    private long mAdvanceIndex;
    private List<ParticleCloud> mClouds;
    private final Context mContext;
    private ArrayList<Particle> mCopiedParticles;
    double[] mParamsPool;
    final Particle mPool;
    private Random mRandom;
    private Map<Sprite, ParticleCloud> mSpriteMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12879);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            TAG = ParticleSystem.class.getSimpleName();
        }
    }

    public ParticleSystem(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mRandom = new Random();
        this.mClouds = new ArrayList();
        this.mSpriteMap = new HashMap();
        this.mPool = new Particle();
        this.mAdvanceIndex = 0L;
        this.mCopiedParticles = new ArrayList<>();
        this.mContext = context;
    }

    public static long compile(String str) {
        return nativeCompile(str);
    }

    private void createCache(int i3) {
        this.mParamsPool = new double[i3 * 11];
        for (int i16 = 0; i16 < i3; i16++) {
            Particle particle = new Particle();
            particle.paramOffset = i16 * 11;
            Particle particle2 = this.mPool;
            particle.next = particle2.next;
            particle2.next = particle;
            particle2.total++;
        }
        Iterator<ParticleCloud> it = this.mClouds.iterator();
        while (it.hasNext()) {
            it.next().createCache();
        }
    }

    private void loadFinish() {
        Iterator<ParticleCloud> it = this.mClouds.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 = (int) (i3 + it.next().mAttrs.get(AttributeConst.MAX_COUNT).value());
        }
        createCache(i3);
    }

    private void loadParticle(String str) {
        JsonObject jsonObject;
        try {
            jsonObject = GsonUtils.json2JsonObject(str);
        } catch (Exception e16) {
            LogUtils.e(TAG, e16.getMessage());
            jsonObject = null;
        }
        ParticleCloud fromJson = ParticleCloud.fromJson(this, jsonObject);
        this.mClouds.add(fromJson);
        this.mSpriteMap.put(fromJson.mSprite, fromJson);
    }

    public static native double[] nativeAdvance(long[] jArr, double[] dArr, int[] iArr, int i3);

    public static native void nativeAdvanceEx(long[] jArr, double[] dArr, int[] iArr, int i3, DoubleBuffer doubleBuffer);

    public static native long nativeCompile(String str);

    public static native void nativeReleaseExpression(long[] jArr);

    private Particle obtainUnlocked() {
        if (this.mPool.next == null) {
            int i3 = 100;
            while (true) {
                int i16 = i3 - 1;
                if (i3 <= 0) {
                    break;
                }
                Particle particle = new Particle();
                Particle particle2 = this.mPool;
                particle.next = particle2.next;
                particle2.next = particle;
                particle2.total++;
                i3 = i16;
            }
        }
        Particle particle3 = this.mPool;
        Particle particle4 = particle3.next;
        particle3.next = particle4.next;
        particle4.next = null;
        particle3.total--;
        return particle4;
    }

    public static void releaseExpression(long[] jArr) {
        nativeReleaseExpression(jArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArrayList<Particle> advance() {
        Pair<Particle, ParticleExpressionBundle> advanceExpression;
        ParticleSystem particleSystem = this;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) particleSystem);
        }
        ArrayList<Particle> arrayList = new ArrayList<>();
        double currentTimeMillis = System.currentTimeMillis() / 1000.0d;
        for (ParticleCloud particleCloud : particleSystem.mClouds) {
            synchronized (particleSystem.mPool) {
                advanceExpression = particleCloud.getAdvanceExpression(currentTimeMillis);
                Object obj = advanceExpression.second;
                nativeAdvanceEx(((ParticleExpressionBundle) obj).expressions, particleSystem.mParamsPool, ((ParticleExpressionBundle) obj).paramOffsets, ((ParticleExpressionBundle) obj).paramLine, particleCloud.mResultBuffer);
                particleCloud.mResultBuffer.rewind();
                particleCloud.mResultBuffer.get(particleCloud.mResultArray);
                int length = particleCloud.mVarAttributes.length;
                for (int i3 = 0; i3 < length; i3++) {
                    Attribute attribute = particleCloud.mVarAttributes[i3];
                    Object obj2 = advanceExpression.first;
                    int i16 = ((Particle) obj2).total;
                    Particle particle = ((Particle) obj2).next;
                    int i17 = 0;
                    while (particle != null) {
                        particle.f341931a[attribute.mVarIndex] = particleCloud.mResultArray[(i3 * i16) + i17];
                        particle = particle.next;
                        i17++;
                    }
                }
            }
            arrayList.add(advanceExpression.first);
            particleSystem = this;
        }
        return arrayList;
    }

    public ArrayList<Particle> advanceAsync() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        this.mCopiedParticles.clear();
        synchronized (this.mPool) {
            for (ParticleCloud particleCloud : this.mClouds) {
                this.mCopiedParticles.add(particleCloud.mCopiedParticles);
                Particle particle = particleCloud.mCopiedParticles;
                Particle particle2 = particleCloud.mParticles;
                particle.total = particle2.total;
                while (true) {
                    Particle particle3 = particle2.next;
                    if (particle3 != null) {
                        particle.next.copy(particle3);
                        particle = particle.next;
                        particle2 = particle2.next;
                    }
                }
            }
        }
        return this.mCopiedParticles;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Particle advanceObtainUnlocked() {
        Particle obtainUnlocked = obtainUnlocked();
        for (int i3 = 0; i3 < 11; i3++) {
            this.mParamsPool[obtainUnlocked.paramOffset + i3] = Math.abs(this.mRandom.nextInt());
        }
        return obtainUnlocked;
    }

    public void emitImmediately(double d16, double d17, double d18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Double.valueOf(d16), Double.valueOf(d17), Double.valueOf(d18));
            return;
        }
        for (ParticleCloud particleCloud : this.mClouds) {
            if (particleCloud.mEmitRate == 0) {
                long j3 = particleCloud.mParticles.total;
                long j16 = particleCloud.mMaxCount;
                if (j3 >= j16) {
                    LogUtils.e(TAG, String.format("max: %d, now %d, can't emit any more", Long.valueOf(j16), Integer.valueOf(particleCloud.mParticles.total)));
                    return;
                }
                particleCloud.emitImmediately(d16, d17, d18);
            }
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.finalize();
        Iterator<ParticleCloud> it = this.mClouds.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
    }

    public List<Sprite> getSprites() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ParticleCloud> it = this.mClouds.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().mSprite);
        }
        return arrayList;
    }

    public void loadParticleData(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : list) {
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
                    arrayList.add(sb5.toString());
                    inputStreamReader.close();
                } else {
                    InputStream open = this.mContext.getAssets().open(str);
                    byte[] bArr = new byte[open.available()];
                    open.read(bArr);
                    arrayList.add(new String(bArr));
                    open.close();
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (!arrayList.isEmpty()) {
            loadParticles(arrayList);
        }
    }

    public void loadParticles(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            loadParticle(it.next());
        }
        loadFinish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putUnlocked(Particle particle) {
        Particle particle2 = this.mPool;
        particle.next = particle2.next;
        particle2.next = particle;
        particle2.total++;
    }
}
