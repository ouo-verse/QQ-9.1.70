package com.tencent.ams.fusion.service.splash.model;

import android.util.Pair;
import com.tencent.ams.fusion.service.splash.b.a.a;
import com.tencent.ams.fusion.service.splash.data.c;
import com.tencent.ams.fusion.service.splash.data.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface SplashOrder {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface BrandType {
        public static final int FOLLOW_U = 4;
        public static final int ONE_SHOT = 1;
        public static final int TOP_VIEW = 2;
        public static final int WE_SHOT = 3;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface OrderType {
        public static final int BRAND = 0;
        public static final int EFFECT = 1;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PriceMode {
        public static final int CPD = 1;
        public static final int CPM = 0;
        public static final int SPA = 2;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ResourceType {
        public static final int MATERIAL_IMG = 1;
        public static final int MATERIAL_VIDEO = 2;
    }

    List<Pair<Integer, Integer>> F(String str);

    int G(String str);

    SplashOrder a(SplashOrder splashOrder);

    boolean aA();

    String aB();

    String aC();

    List<a> aD();

    List<a> aE();

    List<a> aF();

    List<a> aG();

    List<a> aL();

    List<a> aM();

    List<a> aN();

    List<a> aO();

    List<a> aP();

    d aQ();

    c aR();

    String au();

    int av();

    boolean aw();

    boolean ax();

    int az();

    long ba();

    int bd();

    int bf();

    int bh();

    boolean bk();

    boolean bl();

    boolean bm();

    String bn();

    boolean bp();

    String f();

    String y();
}
