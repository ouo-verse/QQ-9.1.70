package com.tencent.oscarcamera.particlesystem;

import android.text.TextUtils;
import android.util.Pair;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.ttpic.util.GsonUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes22.dex */
public class ParticleCloud {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    private static final HashMap<String, Object> s_params;
    private long[] mAttrExpressions;
    private double[] mAttrValue;
    public HashMap<String, Attribute> mAttrs;
    Particle mCopiedParticles;
    long mEmitRate;
    double mLastQuotaTime;
    long mMaxCount;
    public String mName;
    Particle mParticles;
    long mQuota;
    double[] mResultArray;
    DoubleBuffer mResultBuffer;
    public Sprite mSprite;
    private ParticleSystem mSystem;
    Attribute[] mVarAttributes;
    private long[] mVarExpressions;
    private int[] paramOffsets;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12860);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            TAG = ParticleCloud.class.getSimpleName();
            s_params = new HashMap<>();
        }
    }

    public ParticleCloud(ParticleSystem particleSystem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) particleSystem);
            return;
        }
        this.mAttrs = new HashMap<>();
        this.mParticles = new Particle();
        this.mCopiedParticles = new Particle();
        this.mSystem = particleSystem;
        this.mSprite = new Sprite();
    }

    private void advanceParticle(Particle particle, double d16) {
        Sprite sprite = this.mSprite;
        if (sprite.animated == 1) {
            long j3 = (int) ((d16 - particle.birth) / sprite.frameDuration);
            int i3 = sprite.frameCount;
            int i16 = (int) (j3 % i3);
            int i17 = sprite.looped;
            if (i17 == 1) {
                particle.currFrame = i16;
                return;
            }
            if (i17 == 2) {
                if (((j3 / i3) & 1) == 1) {
                    particle.currFrame = (i3 - 1) - i16;
                    return;
                } else {
                    particle.currFrame = i16;
                    return;
                }
            }
            if (j3 >= i3) {
                i16 = i3 - 1;
            }
            particle.currFrame = i16;
        }
    }

    private void computeQuota(double d16) {
        double d17 = this.mLastQuotaTime;
        if (d17 == 0.0d) {
            this.mLastQuotaTime = d16;
        } else {
            long j3 = this.mEmitRate;
            int i3 = (int) (j3 * (d16 - d17));
            if (i3 > 0) {
                this.mQuota += i3;
                this.mLastQuotaTime = d17 + (i3 / j3);
            }
        }
        long j16 = this.mQuota;
        long j17 = this.mMaxCount;
        int i16 = this.mParticles.total;
        if (j16 > j17 - i16) {
            this.mQuota = j17 - i16;
        }
    }

    private static Attribute createAttr(String str, Object obj) {
        int i3;
        Attribute attribute = new Attribute();
        attribute.mName = str;
        attribute.mValue = new Value(obj);
        Map<String, Integer> map = AttributeConst.ATTR_INDEX_MAP;
        if (map.containsKey(str)) {
            i3 = map.get(str).intValue();
        } else {
            i3 = -1;
        }
        attribute.mVarIndex = i3;
        return attribute;
    }

    private double doubleValue(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if ((jsonElement instanceof JsonPrimitive) && ((JsonPrimitive) jsonElement).isNumber()) {
            return jsonElement.getAsNumber().doubleValue();
        }
        return 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ParticleCloud fromJson(ParticleSystem particleSystem, JsonObject jsonObject) {
        ParticleCloud particleCloud = new ParticleCloud(particleSystem);
        try {
            particleCloud.mName = jsonObject.get("name").getAsString();
            for (String str : jsonObject.keySet()) {
                JsonElement jsonElement = jsonObject.get(str);
                if (!(jsonElement instanceof Number) && !(jsonElement instanceof String)) {
                    if ((jsonElement instanceof JsonObject) && TextUtils.equals(str, "sprite")) {
                        particleCloud.initSprite((JsonObject) jsonElement);
                    } else if ((jsonElement instanceof JsonObject) && TextUtils.equals(str, "audio")) {
                        particleCloud.mSprite.audioPath = GsonUtils.getStringUnsafe((JsonObject) jsonElement, "path");
                    }
                }
                Attribute createAttr = createAttr(str, jsonElement);
                particleCloud.mAttrs.put(createAttr.mName, createAttr);
            }
            particleCloud.optimized();
            return particleCloud;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private void initParticle(Particle particle, double d16) {
        particle.birth = d16;
        Sprite sprite = this.mSprite;
        particle.tex = sprite.path;
        particle.frameCount = sprite.frameCount;
        particle.musicPlayed = false;
        double[] dArr = particle.f341931a;
        double[] dArr2 = this.mAttrValue;
        dArr[2] = (long) dArr2[2];
        dArr[0] = dArr2[0];
        dArr[1] = dArr2[1];
        dArr[7] = dArr2[7];
        dArr[8] = dArr2[8];
        dArr[9] = dArr2[9];
        dArr[3] = dArr2[3];
        dArr[4] = dArr2[4];
        dArr[5] = dArr2[5];
        dArr[6] = dArr2[6];
        advanceParticle(particle, d16);
    }

    private void initSprite(JsonObject jsonObject) {
        this.mSprite.path = GsonUtils.optString(jsonObject, "path");
        this.mSprite.frameCount = (int) doubleValue(jsonObject, "frameCount");
        this.mSprite.width = (int) doubleValue(jsonObject, "width");
        this.mSprite.height = (int) doubleValue(jsonObject, "height");
        this.mSprite.blendMode = (int) doubleValue(jsonObject, c.W);
        this.mSprite.animated = (int) doubleValue(jsonObject, "animated");
        this.mSprite.looped = (int) doubleValue(jsonObject, "looped");
        this.mSprite.frameDuration = doubleValue(jsonObject, "frameDuration");
    }

    private void optimized() {
        this.mMaxCount = (long) this.mAttrs.get(AttributeConst.MAX_COUNT).value();
        this.mEmitRate = (long) this.mAttrs.get(AttributeConst.EMISSION_RATE).value();
        long[] jArr = new long[10];
        this.mAttrExpressions = jArr;
        jArr[2] = this.mAttrs.get(AttributeConst.LIFE).expression();
        this.mAttrExpressions[3] = this.mAttrs.get(AttributeConst.R).expression();
        this.mAttrExpressions[4] = this.mAttrs.get(AttributeConst.G).expression();
        this.mAttrExpressions[5] = this.mAttrs.get(AttributeConst.B).expression();
        this.mAttrExpressions[6] = this.mAttrs.get(AttributeConst.A).expression();
        this.mAttrExpressions[7] = this.mAttrs.get("positionX").expression();
        this.mAttrExpressions[8] = this.mAttrs.get("positionY").expression();
        this.mAttrExpressions[9] = this.mAttrs.get(AttributeConst.Z).expression();
        this.mAttrExpressions[0] = this.mAttrs.get("width").expression();
        this.mAttrExpressions[1] = this.mAttrs.get("height").expression();
        double[] dArr = new double[10];
        this.mAttrValue = dArr;
        dArr[2] = this.mAttrs.get(AttributeConst.LIFE).value();
        this.mAttrValue[3] = this.mAttrs.get(AttributeConst.R).value();
        this.mAttrValue[4] = this.mAttrs.get(AttributeConst.G).value();
        this.mAttrValue[5] = this.mAttrs.get(AttributeConst.B).value();
        this.mAttrValue[6] = this.mAttrs.get(AttributeConst.A).value();
        this.mAttrValue[7] = this.mAttrs.get("positionX").value();
        this.mAttrValue[8] = this.mAttrs.get("positionY").value();
        this.mAttrValue[9] = this.mAttrs.get(AttributeConst.Z).value();
        this.mAttrValue[0] = this.mAttrs.get("width").value();
        this.mAttrValue[1] = this.mAttrs.get("height").value();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.mAttrs.keySet().iterator();
        while (it.hasNext()) {
            Attribute attribute = this.mAttrs.get(it.next());
            if (attribute.expression() != -1) {
                arrayList.add(attribute);
            }
        }
        this.mVarExpressions = new long[arrayList.size()];
        this.mVarAttributes = new Attribute[arrayList.size()];
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mVarExpressions[i3] = ((Attribute) arrayList.get(i3)).expression();
            this.mVarAttributes[i3] = (Attribute) arrayList.get(i3);
        }
        this.paramOffsets = new int[((int) this.mAttrs.get(AttributeConst.MAX_COUNT).value()) * 11];
    }

    public void createCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.mResultBuffer = ByteBuffer.allocateDirect((int) (this.mMaxCount * this.mVarExpressions.length * 64)).order(ByteOrder.nativeOrder()).asDoubleBuffer();
        this.mResultArray = new double[(int) (this.mMaxCount * this.mVarExpressions.length)];
        Particle particle = new Particle();
        this.mCopiedParticles = particle;
        int i3 = 0;
        while (i3 < this.mMaxCount) {
            Particle particle2 = new Particle();
            particle.next = particle2;
            i3++;
            particle = particle2;
        }
    }

    public void emitImmediately(double d16, double d17, double d18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Double.valueOf(d16), Double.valueOf(d17), Double.valueOf(d18));
            return;
        }
        Particle advanceObtainUnlocked = this.mSystem.advanceObtainUnlocked();
        initParticle(advanceObtainUnlocked, System.currentTimeMillis() / 1000.0d);
        double[] dArr = advanceObtainUnlocked.touchedPosition;
        dArr[0] = d16;
        dArr[1] = d17;
        dArr[2] = d18;
        Particle particle = this.mParticles;
        advanceObtainUnlocked.next = particle.next;
        particle.next = advanceObtainUnlocked;
        particle.total++;
    }

    public Pair<Particle, ParticleExpressionBundle> getAdvanceExpression(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Pair) iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16));
        }
        ParticleExpressionBundle particleExpressionBundle = new ParticleExpressionBundle();
        Particle particle = this.mParticles;
        Particle particle2 = particle.next;
        loop0: while (true) {
            Particle particle3 = particle2;
            Particle particle4 = particle;
            particle = particle3;
            while (particle != null) {
                double d17 = particle.f341931a[2];
                if (d17 > 0.0d && d17 + particle.birth <= d16) {
                    particle4.next = particle.next;
                    Particle particle5 = particle.next;
                    this.mSystem.putUnlocked(particle);
                    this.mParticles.total--;
                    particle = particle5;
                } else {
                    advanceParticle(particle, d16);
                    this.mSystem.mParamsPool[particle.paramOffset + 10] = d16 - particle.birth;
                    particle2 = particle.next;
                }
            }
            break loop0;
        }
        computeQuota(d16);
        int i3 = this.mParticles.total;
        long j3 = i3;
        long j16 = this.mMaxCount;
        if (j3 < j16) {
            long j17 = this.mQuota;
            if (j17 > 0) {
                long min = Math.min(j16 - i3, j17);
                this.mQuota -= min;
                while (true) {
                    long j18 = min - 1;
                    if (min <= 0) {
                        break;
                    }
                    Particle advanceObtainUnlocked = this.mSystem.advanceObtainUnlocked();
                    initParticle(advanceObtainUnlocked, d16);
                    this.mSystem.mParamsPool[advanceObtainUnlocked.paramOffset + 10] = d16 - advanceObtainUnlocked.birth;
                    Particle particle6 = this.mParticles;
                    advanceObtainUnlocked.next = particle6.next;
                    particle6.next = advanceObtainUnlocked;
                    particle6.total++;
                    min = j18;
                }
            }
        }
        Particle particle7 = this.mParticles;
        Particle particle8 = particle7.next;
        int i16 = particle7.total;
        for (int i17 = 0; i17 < i16; i17++) {
            this.paramOffsets[i17] = particle8.paramOffset;
            particle8 = particle8.next;
        }
        particleExpressionBundle.expressions = this.mVarExpressions;
        particleExpressionBundle.paramLine = this.mParticles.total;
        particleExpressionBundle.paramOffsets = this.paramOffsets;
        return new Pair<>(this.mParticles, particleExpressionBundle);
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ParticleSystem.releaseExpression(this.mVarExpressions);
        }
    }
}
