package com.tencent.mobileqq.ar;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class v extends ObjectBaseData {
    private AnimatorSet A3;
    private ObjectAnimator A4;
    private ObjectAnimator B3;
    private AnimatorSet B4;
    private ObjectAnimator C3;
    private ObjectAnimator C4;
    private ObjectAnimator D3;
    private ObjectAnimator D4;
    private ObjectAnimator E3;
    private ObjectAnimator E4;
    private ObjectAnimator F3;
    private AnimatorSet F4;
    private ObjectAnimator G3;
    private ObjectAnimator G4;
    private AnimatorSet H3;
    private AnimatorSet H4;
    private ObjectAnimator I3;
    private ObjectAnimator I4;
    private ObjectAnimator J3;
    private AnimatorSet J4;
    private ObjectAnimator K3;
    private ObjectAnimator K4;
    private AnimatorSet L3;
    private AnimatorSet L4;
    private ObjectAnimator M3;
    private ObjectAnimator M4;
    private ObjectAnimator N3;
    private AnimatorSet N4;
    private ObjectAnimator O3;
    private ObjectAnimator O4;
    private ObjectAnimator P3;
    private AnimatorSet P4;
    private AnimatorSet Q3;
    private ObjectAnimator Q4;
    private ObjectAnimator R3;
    private AnimatorSet R4;
    private ObjectAnimator S3;
    private ObjectAnimator S4;
    private ObjectAnimator T3;
    private AnimatorSet T4;
    private ObjectAnimator U3;
    private ObjectAnimator V3;
    private ObjectAnimator W3;
    private AnimatorSet X3;
    private ObjectAnimator Y3;
    private ObjectAnimator Z3;

    /* renamed from: a4, reason: collision with root package name */
    private ObjectAnimator f198565a4;

    /* renamed from: b4, reason: collision with root package name */
    private AnimatorSet f198566b4;

    /* renamed from: c3, reason: collision with root package name */
    private ObjectAnimator f198567c3;

    /* renamed from: c4, reason: collision with root package name */
    private ObjectAnimator f198568c4;

    /* renamed from: d3, reason: collision with root package name */
    private ObjectAnimator f198569d3;

    /* renamed from: d4, reason: collision with root package name */
    private ObjectAnimator f198570d4;

    /* renamed from: e3, reason: collision with root package name */
    private ObjectAnimator f198571e3;

    /* renamed from: e4, reason: collision with root package name */
    private ObjectAnimator f198572e4;

    /* renamed from: f3, reason: collision with root package name */
    private ObjectAnimator f198573f3;

    /* renamed from: f4, reason: collision with root package name */
    private ObjectAnimator f198574f4;

    /* renamed from: g3, reason: collision with root package name */
    private ObjectAnimator f198575g3;

    /* renamed from: g4, reason: collision with root package name */
    private AnimatorSet f198576g4;

    /* renamed from: h3, reason: collision with root package name */
    private ObjectAnimator f198577h3;

    /* renamed from: h4, reason: collision with root package name */
    private ObjectAnimator f198578h4;
    private AnimatorSet i3;

    /* renamed from: i4, reason: collision with root package name */
    private ObjectAnimator f198579i4;
    private ObjectAnimator j3;

    /* renamed from: j4, reason: collision with root package name */
    private ObjectAnimator f198580j4;
    private ObjectAnimator k3;

    /* renamed from: k4, reason: collision with root package name */
    private AnimatorSet f198581k4;
    private ObjectAnimator l3;

    /* renamed from: l4, reason: collision with root package name */
    private ObjectAnimator f198582l4;
    private AnimatorSet m3;

    /* renamed from: m4, reason: collision with root package name */
    private ObjectAnimator f198583m4;
    private ObjectAnimator n3;

    /* renamed from: n4, reason: collision with root package name */
    private AnimatorSet f198584n4;

    /* renamed from: o3, reason: collision with root package name */
    private ObjectAnimator f198585o3;

    /* renamed from: o4, reason: collision with root package name */
    private ObjectAnimator f198586o4;

    /* renamed from: p3, reason: collision with root package name */
    private ObjectAnimator f198587p3;

    /* renamed from: p4, reason: collision with root package name */
    private ObjectAnimator f198588p4;

    /* renamed from: q3, reason: collision with root package name */
    private ObjectAnimator f198589q3;

    /* renamed from: q4, reason: collision with root package name */
    private ObjectAnimator f198590q4;

    /* renamed from: r3, reason: collision with root package name */
    private AnimatorSet f198591r3;

    /* renamed from: r4, reason: collision with root package name */
    private AnimatorSet f198592r4;

    /* renamed from: s3, reason: collision with root package name */
    private ObjectAnimator f198593s3;

    /* renamed from: s4, reason: collision with root package name */
    private ObjectAnimator f198594s4;

    /* renamed from: t3, reason: collision with root package name */
    private ObjectAnimator f198595t3;

    /* renamed from: t4, reason: collision with root package name */
    private ObjectAnimator f198596t4;

    /* renamed from: u3, reason: collision with root package name */
    private AnimatorSet f198597u3;

    /* renamed from: u4, reason: collision with root package name */
    private AnimatorSet f198598u4;
    private ObjectAnimator v3;

    /* renamed from: v4, reason: collision with root package name */
    private ObjectAnimator f198599v4;
    private AnimatorSet w3;

    /* renamed from: w4, reason: collision with root package name */
    private AnimatorSet f198600w4;

    /* renamed from: x3, reason: collision with root package name */
    private ObjectAnimator f198601x3;

    /* renamed from: x4, reason: collision with root package name */
    private ObjectAnimator f198602x4;

    /* renamed from: y3, reason: collision with root package name */
    private ObjectAnimator f198603y3;

    /* renamed from: y4, reason: collision with root package name */
    private AnimatorSet f198604y4;

    /* renamed from: z3, reason: collision with root package name */
    private ObjectAnimator f198605z3;

    /* renamed from: z4, reason: collision with root package name */
    private ObjectAnimator f198606z4;

    public v(Context context) {
        super(context);
        a();
        g();
    }

    private void a() {
        this.f197479c = true;
        this.f197483d = false;
    }

    @Override // com.tencent.mobileqq.ar.ObjectBaseData
    public void d() {
        super.d();
        if (!this.f197479c && !this.f197491f) {
            this.f197527o = ViewUtils.dip2px(1.5f);
        } else {
            this.f197527o = ViewUtils.dip2px(5.0f);
        }
    }

    @Override // com.tencent.mobileqq.ar.ObjectBaseData
    public void f(boolean z16) {
        this.T = true;
        q();
        v();
        u();
        y();
        w();
        x();
        s();
        r();
        t();
    }

    public void g() {
        h();
        m();
        l();
        p();
        n();
        o();
        j();
        i();
        k();
    }

    @TargetApi(11)
    public void h() {
        if (this.f198567c3 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "bCScale", 0.0f, 1.04f);
            this.f198567c3 = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.f198567c3.setDuration(200L);
        }
        if (this.f198569d3 == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "bCScale", 1.04f, 1.0f);
            this.f198569d3 = ofFloat2;
            ofFloat2.setInterpolator(new LinearInterpolator());
            this.f198569d3.setDuration(66L);
        }
        if (this.f198571e3 == null) {
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "bCScale", 1.0f, 1.02f);
            this.f198571e3 = ofFloat3;
            ofFloat3.setInterpolator(new LinearInterpolator());
            this.f198571e3.setDuration(66L);
        }
        if (this.f198573f3 == null) {
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, "bCScale", 1.02f, 1.0f);
            this.f198573f3 = ofFloat4;
            ofFloat4.setInterpolator(new LinearInterpolator());
            this.f198573f3.setDuration(66L);
        }
        if (this.f198575g3 == null) {
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this, "bCScale", 1.0f, 1.0f);
            this.f198575g3 = ofFloat5;
            ofFloat5.setInterpolator(new LinearInterpolator());
            this.f198575g3.setDuration(1268L);
        }
        if (this.f198577h3 == null) {
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this, "bCScale", 1.0f, 0.9f);
            this.f198577h3 = ofFloat6;
            ofFloat6.setInterpolator(new LinearInterpolator());
            this.f198577h3.setDuration(334L);
        }
        if (this.i3 == null) {
            this.i3 = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f198567c3);
            arrayList.add(this.f198569d3);
            arrayList.add(this.f198571e3);
            arrayList.add(this.f198573f3);
            arrayList.add(this.f198575g3);
            arrayList.add(this.f198577h3);
            this.i3.playSequentially(arrayList);
        }
        if (this.j3 == null) {
            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this, "bCAlpha", 0.0f, 1.0f);
            this.j3 = ofFloat7;
            ofFloat7.setInterpolator(new LinearInterpolator());
            this.j3.setDuration(200L);
        }
        if (this.k3 == null) {
            ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this, "bCAlpha", 1.0f, 1.0f);
            this.k3 = ofFloat8;
            ofFloat8.setInterpolator(new LinearInterpolator());
            this.k3.setDuration(2600L);
        }
        if (this.l3 == null) {
            ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this, "bCAlpha", 1.0f, 0.9f);
            this.l3 = ofFloat9;
            ofFloat9.setInterpolator(new LinearInterpolator());
            this.l3.setDuration(866L);
        }
        if (this.m3 == null) {
            this.m3 = new AnimatorSet();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.j3);
            arrayList2.add(this.k3);
            arrayList2.add(this.l3);
            this.m3.playSequentially(arrayList2);
        }
        if (this.n3 == null) {
            ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this, "bCRotate", 0.0f, 360.0f);
            this.n3 = ofFloat10;
            ofFloat10.setInterpolator(new LinearInterpolator());
            this.n3.setDuration(866L);
        }
        if (this.f198585o3 == null) {
            ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(this, "bCRotate", 360.0f, 720.0f);
            this.f198585o3 = ofFloat11;
            ofFloat11.setInterpolator(new LinearInterpolator());
            this.f198585o3.setDuration(334L);
        }
        if (this.f198587p3 == null) {
            ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(this, "bCRotate", 720.0f, 720.0f);
            this.f198587p3 = ofFloat12;
            ofFloat12.setInterpolator(new LinearInterpolator());
            this.f198587p3.setDuration(800L);
        }
        if (this.f198589q3 == null) {
            ObjectAnimator ofFloat13 = ObjectAnimator.ofFloat(this, "bCRotate", 720.0f, 360.0f);
            this.f198589q3 = ofFloat13;
            ofFloat13.setInterpolator(new LinearInterpolator());
            this.f198589q3.setDuration(12000L);
            this.f198589q3.setRepeatCount(-1);
        }
        if (this.f198591r3 == null) {
            this.f198591r3 = new AnimatorSet();
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(this.n3);
            arrayList3.add(this.f198585o3);
            arrayList3.add(this.f198587p3);
            arrayList3.add(this.f198589q3);
            this.f198591r3.playSequentially(arrayList3);
            this.f198591r3.setStartDelay(800L);
        }
        if (this.f198593s3 == null) {
            ObjectAnimator ofFloat14 = ObjectAnimator.ofFloat(this, "maskScale", 0.0f, 1.0f);
            this.f198593s3 = ofFloat14;
            ofFloat14.setInterpolator(new LinearInterpolator());
            this.f198593s3.setDuration(134L);
        }
        if (this.f198595t3 == null) {
            ObjectAnimator ofFloat15 = ObjectAnimator.ofFloat(this, "maskScale", 1.0f, 0.0f);
            this.f198595t3 = ofFloat15;
            ofFloat15.setInterpolator(new LinearInterpolator());
            this.f198595t3.setDuration(400L);
        }
        if (this.f198597u3 == null) {
            this.f198597u3 = new AnimatorSet();
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(this.f198593s3);
            arrayList4.add(this.f198595t3);
            this.f198597u3.playSequentially(arrayList4);
            this.f198597u3.setStartDelay(1866L);
        }
        if (this.v3 == null) {
            ObjectAnimator ofObject = ObjectAnimator.ofObject(this, "bCColor", new ArgbEvaluator(), Integer.valueOf(Color.argb(255, 30, 255, 236)), -1, -1);
            this.v3 = ofObject;
            ofObject.setInterpolator(new LinearInterpolator());
            this.v3.setDuration(334L);
        }
        if (this.w3 == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.w3 = animatorSet;
            animatorSet.play(this.v3);
            this.w3.setStartDelay(1666L);
        }
        if (this.f198601x3 == null) {
            ObjectAnimator ofFloat16 = ObjectAnimator.ofFloat(this, "bTAlpha", 0.0f, 1.0f);
            this.f198601x3 = ofFloat16;
            ofFloat16.setInterpolator(new LinearInterpolator());
            this.f198601x3.setDuration(200L);
        }
        if (this.f198603y3 == null) {
            ObjectAnimator ofFloat17 = ObjectAnimator.ofFloat(this, "bTAlpha", 1.0f, 1.0f);
            this.f198603y3 = ofFloat17;
            ofFloat17.setInterpolator(new LinearInterpolator());
            this.f198603y3.setDuration(2600L);
        }
        if (this.f198605z3 == null) {
            ObjectAnimator ofFloat18 = ObjectAnimator.ofFloat(this, "bTAlpha", 1.0f, 0.9f);
            this.f198605z3 = ofFloat18;
            ofFloat18.setInterpolator(new LinearInterpolator());
            this.f198605z3.setDuration(866L);
        }
        if (this.A3 == null) {
            this.A3 = new AnimatorSet();
            ArrayList arrayList5 = new ArrayList();
            arrayList5.add(this.f198601x3);
            arrayList5.add(this.f198603y3);
            arrayList5.add(this.f198605z3);
            this.A3.playSequentially(arrayList5);
        }
    }

    @TargetApi(11)
    public void i() {
        if (this.K4 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "fCPositionY", -ViewUtils.dip2px(25.0f), 0.0f);
            this.K4 = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.K4.setDuration(280L);
        }
        if (this.L4 == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.L4 = animatorSet;
            animatorSet.play(this.K4);
            this.L4.setStartDelay(2200L);
        }
        if (this.M4 == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "fCAlpha", 0.0f, 1.0f);
            this.M4 = ofFloat2;
            ofFloat2.setInterpolator(new LinearInterpolator());
            this.M4.setDuration(280L);
        }
        if (this.N4 == null) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.N4 = animatorSet2;
            animatorSet2.play(this.M4);
            this.N4.setStartDelay(2200L);
        }
    }

    @TargetApi(11)
    public void j() {
        if (this.G4 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "fNCHAlpha", 0.0f, 1.0f);
            this.G4 = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.G4.setDuration(320L);
        }
        if (this.H4 == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.H4 = animatorSet;
            animatorSet.play(this.G4);
            this.H4.setStartDelay(2000L);
        }
        if (this.I4 == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "fLAlpha", 0.0f, 1.0f);
            this.I4 = ofFloat2;
            ofFloat2.setInterpolator(new LinearInterpolator());
            this.I4.setDuration(200L);
        }
        if (this.J4 == null) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.J4 = animatorSet2;
            animatorSet2.play(this.I4);
            this.J4.setStartDelay(1900L);
        }
    }

    @TargetApi(11)
    public void k() {
        if (this.O4 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "fPAlpha", 0.0f, 1.0f);
            this.O4 = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.O4.setDuration(280L);
        }
        if (this.P4 == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.P4 = animatorSet;
            animatorSet.play(this.O4);
            this.P4.setStartDelay(2200L);
        }
        if (this.Q4 == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "fPOutCircleAlpha", 1.0f, 0.0f, 0.0f);
            this.Q4 = ofFloat2;
            ofFloat2.setInterpolator(new LinearInterpolator());
            this.Q4.setDuration(1500L);
            this.Q4.setRepeatCount(-1);
        }
        if (this.R4 == null) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.R4 = animatorSet2;
            animatorSet2.play(this.Q4);
            this.R4.setStartDelay(2200L);
        }
        if (this.S4 == null) {
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "fPOutCircleScale", 1.0f, 1.3f, 1.3f);
            this.S4 = ofFloat3;
            ofFloat3.setInterpolator(new LinearInterpolator());
            this.S4.setRepeatCount(-1);
            this.S4.setDuration(1500L);
        }
        if (this.T4 == null) {
            AnimatorSet animatorSet3 = new AnimatorSet();
            this.T4 = animatorSet3;
            animatorSet3.play(this.S4);
            this.T4.setStartDelay(2200L);
        }
    }

    @TargetApi(11)
    public void l() {
        if (this.R3 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "iBCScale", 0.0f, 1.04f);
            this.R3 = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.R3.setDuration(200L);
        }
        if (this.S3 == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "iBCScale", 1.04f, 1.0f);
            this.S3 = ofFloat2;
            ofFloat2.setInterpolator(new LinearInterpolator());
            this.S3.setDuration(66L);
        }
        if (this.T3 == null) {
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "iBCScale", 1.0f, 1.02f);
            this.T3 = ofFloat3;
            ofFloat3.setInterpolator(new LinearInterpolator());
            this.T3.setDuration(66L);
        }
        if (this.U3 == null) {
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, "iBCScale", 1.02f, 1.0f);
            this.U3 = ofFloat4;
            ofFloat4.setInterpolator(new LinearInterpolator());
            this.U3.setDuration(66L);
        }
        if (this.V3 == null) {
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this, "iBCScale", 1.0f, 1.0f);
            this.V3 = ofFloat5;
            ofFloat5.setInterpolator(new LinearInterpolator());
            this.V3.setDuration(1202L);
        }
        if (this.W3 == null) {
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this, "iBCScale", 1.0f, 0.9f);
            this.W3 = ofFloat6;
            ofFloat6.setInterpolator(new LinearInterpolator());
            this.W3.setDuration(334L);
        }
        if (this.X3 == null) {
            this.X3 = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.R3);
            arrayList.add(this.S3);
            arrayList.add(this.T3);
            arrayList.add(this.U3);
            arrayList.add(this.V3);
            arrayList.add(this.W3);
            this.X3.playSequentially(arrayList);
            this.X3.setStartDelay(66L);
        }
        if (this.Y3 == null) {
            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this, "iBCAlpha", 0.0f, 1.0f);
            this.Y3 = ofFloat7;
            ofFloat7.setInterpolator(new LinearInterpolator());
            this.Y3.setDuration(200L);
        }
        if (this.Z3 == null) {
            ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this, "iBCAlpha", 1.0f, 1.0f);
            this.Z3 = ofFloat8;
            ofFloat8.setInterpolator(new LinearInterpolator());
            this.Z3.setDuration(2534L);
        }
        if (this.f198565a4 == null) {
            ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this, "iBCAlpha", 1.0f, 0.8f);
            this.f198565a4 = ofFloat9;
            ofFloat9.setInterpolator(new LinearInterpolator());
            this.f198565a4.setDuration(866L);
        }
        if (this.f198566b4 == null) {
            this.f198566b4 = new AnimatorSet();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.Y3);
            arrayList2.add(this.Z3);
            arrayList2.add(this.f198565a4);
            this.f198566b4.playSequentially(arrayList2);
            this.f198566b4.setStartDelay(66L);
        }
        if (this.f198568c4 == null) {
            ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this, "iBCRotate", 0.0f, -90.0f);
            this.f198568c4 = ofFloat10;
            ofFloat10.setInterpolator(new LinearInterpolator());
            this.f198568c4.setDuration(866L);
        }
        if (this.f198570d4 == null) {
            ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(this, "iBCRotate", -90.0f, -450.0f);
            this.f198570d4 = ofFloat11;
            ofFloat11.setInterpolator(new LinearInterpolator());
            this.f198570d4.setDuration(334L);
        }
        if (this.f198572e4 == null) {
            ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(this, "iBCRotate", -450.0f, -450.0f);
            this.f198572e4 = ofFloat12;
            ofFloat12.setInterpolator(new LinearInterpolator());
            this.f198572e4.setDuration(800L);
        }
        if (this.f198574f4 == null) {
            ObjectAnimator ofFloat13 = ObjectAnimator.ofFloat(this, "iBCRotate", -450.0f, -90.0f);
            this.f198574f4 = ofFloat13;
            ofFloat13.setInterpolator(new LinearInterpolator());
            this.f198574f4.setDuration(6000L);
            this.f198574f4.setRepeatCount(-1);
        }
        if (this.f198576g4 == null) {
            this.f198576g4 = new AnimatorSet();
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(this.f198568c4);
            arrayList3.add(this.f198570d4);
            arrayList3.add(this.f198572e4);
            arrayList3.add(this.f198574f4);
            this.f198576g4.playSequentially(arrayList3);
            this.f198576g4.setStartDelay(800L);
        }
        if (this.f198578h4 == null) {
            ObjectAnimator ofFloat14 = ObjectAnimator.ofFloat(this, "iSCAlpha", 0.0f, 1.0f);
            this.f198578h4 = ofFloat14;
            ofFloat14.setInterpolator(new LinearInterpolator());
            this.f198578h4.setDuration(200L);
        }
        if (this.f198579i4 == null) {
            ObjectAnimator ofFloat15 = ObjectAnimator.ofFloat(this, "iSCAlpha", 1.0f, 1.0f);
            this.f198579i4 = ofFloat15;
            ofFloat15.setInterpolator(new LinearInterpolator());
            this.f198579i4.setDuration(2534L);
        }
        if (this.f198580j4 == null) {
            ObjectAnimator ofFloat16 = ObjectAnimator.ofFloat(this, "iSCAlpha", 1.0f, 0.8f);
            this.f198580j4 = ofFloat16;
            ofFloat16.setInterpolator(new LinearInterpolator());
            this.f198580j4.setDuration(866L);
        }
        if (this.f198581k4 == null) {
            this.f198581k4 = new AnimatorSet();
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(this.f198578h4);
            arrayList4.add(this.f198579i4);
            arrayList4.add(this.f198580j4);
            this.f198581k4.playSequentially(arrayList4);
            this.f198581k4.setStartDelay(66L);
        }
    }

    @TargetApi(11)
    public void m() {
        if (this.B3 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "oCScale", 0.0f, 1.04f);
            this.B3 = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.B3.setDuration(200L);
        }
        if (this.C3 == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "oCScale", 1.04f, 1.0f);
            this.C3 = ofFloat2;
            ofFloat2.setInterpolator(new LinearInterpolator());
            this.C3.setDuration(66L);
        }
        if (this.D3 == null) {
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "oCScale", 1.0f, 1.02f);
            this.D3 = ofFloat3;
            ofFloat3.setInterpolator(new LinearInterpolator());
            this.D3.setDuration(66L);
        }
        if (this.E3 == null) {
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, "oCScale", 1.02f, 1.0f);
            this.E3 = ofFloat4;
            ofFloat4.setInterpolator(new LinearInterpolator());
            this.E3.setDuration(66L);
        }
        if (this.F3 == null) {
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this, "oCScale", 1.0f, 1.0f);
            this.F3 = ofFloat5;
            ofFloat5.setInterpolator(new LinearInterpolator());
            this.F3.setDuration(1234L);
        }
        if (this.G3 == null) {
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this, "oCScale", 1.0f, 0.9f);
            this.G3 = ofFloat6;
            ofFloat6.setInterpolator(new LinearInterpolator());
            this.G3.setDuration(334L);
        }
        if (this.H3 == null) {
            this.H3 = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.B3);
            arrayList.add(this.C3);
            arrayList.add(this.D3);
            arrayList.add(this.E3);
            arrayList.add(this.F3);
            arrayList.add(this.G3);
            this.H3.playSequentially(arrayList);
            this.H3.setStartDelay(34L);
        }
        if (this.I3 == null) {
            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this, "oCAlpha", 0.0f, 1.0f);
            this.I3 = ofFloat7;
            ofFloat7.setInterpolator(new LinearInterpolator());
            this.I3.setDuration(200L);
        }
        if (this.J3 == null) {
            ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this, "oCAlpha", 1.0f, 1.0f);
            this.J3 = ofFloat8;
            ofFloat8.setInterpolator(new LinearInterpolator());
            this.J3.setDuration(2566L);
        }
        if (this.K3 == null) {
            ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this, "oCAlpha", 1.0f, 0.0f);
            this.K3 = ofFloat9;
            ofFloat9.setInterpolator(new LinearInterpolator());
            this.K3.setDuration(866L);
        }
        if (this.L3 == null) {
            this.L3 = new AnimatorSet();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.I3);
            arrayList2.add(this.J3);
            arrayList2.add(this.K3);
            this.L3.playSequentially(arrayList2);
            this.L3.setStartDelay(34L);
        }
        if (this.M3 == null) {
            ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this, "oCRotate", 0.0f, -180.0f);
            this.M3 = ofFloat10;
            ofFloat10.setInterpolator(new LinearInterpolator());
            this.M3.setDuration(866L);
        }
        if (this.N3 == null) {
            ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(this, "oCRotate", -180.0f, -540.0f);
            this.N3 = ofFloat11;
            ofFloat11.setInterpolator(new LinearInterpolator());
            this.N3.setDuration(334L);
        }
        if (this.O3 == null) {
            ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(this, "oCRotate", -540.0f, -540.0f);
            this.O3 = ofFloat12;
            ofFloat12.setInterpolator(new LinearInterpolator());
            this.O3.setDuration(800L);
        }
        if (this.P3 == null) {
            ObjectAnimator ofFloat13 = ObjectAnimator.ofFloat(this, "oCRotate", -540.0f, -180.0f);
            this.P3 = ofFloat13;
            ofFloat13.setInterpolator(new LinearInterpolator());
            this.P3.setDuration(6000L);
            this.P3.setRepeatCount(-1);
        }
        if (this.Q3 == null) {
            this.Q3 = new AnimatorSet();
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(this.M3);
            arrayList3.add(this.N3);
            arrayList3.add(this.O3);
            arrayList3.add(this.P3);
            this.Q3.playSequentially(arrayList3);
            this.Q3.setStartDelay(800L);
        }
    }

    @TargetApi(11)
    public void n() {
        if (this.f198594s4 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "sCScale", 1.0f, 1.0f);
            this.f198594s4 = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.f198594s4.setDuration(1666L);
        }
        if (this.f198596t4 == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "sCScale", 1.0f, 0.9f);
            this.f198596t4 = ofFloat2;
            ofFloat2.setInterpolator(new LinearInterpolator());
            this.f198596t4.setDuration(334L);
        }
        if (this.f198598u4 == null) {
            this.f198598u4 = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f198594s4);
            arrayList.add(this.f198596t4);
            this.f198598u4.playSequentially(arrayList);
        }
        if (this.f198599v4 == null) {
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "sCRotate", 0.0f, 45.0f);
            this.f198599v4 = ofFloat3;
            ofFloat3.setInterpolator(new LinearInterpolator());
            this.f198599v4.setDuration(8000L);
            this.f198599v4.setRepeatCount(-1);
        }
        if (this.f198600w4 == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f198600w4 = animatorSet;
            animatorSet.play(this.f198599v4);
        }
        if (this.f198602x4 == null) {
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, "sCAlpha", 0.0f, 1.0f);
            this.f198602x4 = ofFloat4;
            ofFloat4.setInterpolator(new LinearInterpolator());
            this.f198602x4.setDuration(200L);
        }
        if (this.f198604y4 == null) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.f198604y4 = animatorSet2;
            animatorSet2.play(this.f198602x4);
            this.f198604y4.setStartDelay(66L);
        }
    }

    @TargetApi(11)
    public void o() {
        if (this.f198606z4 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "sDScale", 1.0f, 1.0f);
            this.f198606z4 = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.f198606z4.setDuration(1666L);
        }
        if (this.A4 == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "sDScale", 1.0f, 0.9f);
            this.A4 = ofFloat2;
            ofFloat2.setInterpolator(new LinearInterpolator());
            this.A4.setDuration(334L);
        }
        if (this.B4 == null) {
            this.B4 = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f198606z4);
            arrayList.add(this.A4);
            this.B4.playSequentially(arrayList);
        }
        if (this.C4 == null) {
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "sDAlpha", 0.0f, 1.0f);
            this.C4 = ofFloat3;
            ofFloat3.setInterpolator(new LinearInterpolator());
            this.C4.setDuration(200L);
        }
        if (this.D4 == null) {
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, "sDAlpha", 1.0f, 1.0f);
            this.D4 = ofFloat4;
            ofFloat4.setInterpolator(new LinearInterpolator());
            this.D4.setDuration(1566L);
        }
        if (this.E4 == null) {
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this, "sDAlpha", 1.0f, 0.6f);
            this.E4 = ofFloat5;
            ofFloat5.setInterpolator(new LinearInterpolator());
            this.E4.setDuration(866L);
        }
        if (this.F4 == null) {
            this.F4 = new AnimatorSet();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.C4);
            arrayList2.add(this.D4);
            arrayList2.add(this.E4);
            this.F4.playSequentially(arrayList2);
            this.F4.setStartDelay(34L);
        }
    }

    @TargetApi(11)
    public void p() {
        if (this.f198582l4 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "tCScale", 1.0f, 1.0f);
            this.f198582l4 = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.f198582l4.setDuration(1666L);
        }
        if (this.f198583m4 == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "tCScale", 1.0f, 0.9f);
            this.f198583m4 = ofFloat2;
            ofFloat2.setInterpolator(new LinearInterpolator());
            this.f198583m4.setDuration(334L);
        }
        if (this.f198584n4 == null) {
            this.f198584n4 = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f198582l4);
            arrayList.add(this.f198583m4);
            this.f198584n4.playSequentially(arrayList);
        }
        if (this.f198586o4 == null) {
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "tCAlpha", 0.0f, 1.0f);
            this.f198586o4 = ofFloat3;
            ofFloat3.setInterpolator(new LinearInterpolator());
            this.f198586o4.setDuration(200L);
        }
        if (this.f198588p4 == null) {
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, "tCAlpha", 1.0f, 1.0f);
            this.f198588p4 = ofFloat4;
            ofFloat4.setInterpolator(new LinearInterpolator());
            this.f198588p4.setDuration(1566L);
        }
        if (this.f198590q4 == null) {
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this, "tCAlpha", 1.0f, 0.0f);
            this.f198590q4 = ofFloat5;
            ofFloat5.setInterpolator(new LinearInterpolator());
            this.f198590q4.setDuration(866L);
        }
        if (this.f198592r4 == null) {
            this.f198592r4 = new AnimatorSet();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.f198586o4);
            arrayList2.add(this.f198588p4);
            arrayList2.add(this.f198590q4);
            this.f198592r4.playSequentially(arrayList2);
            this.f198592r4.setStartDelay(34L);
        }
    }

    @TargetApi(11)
    public void q() {
        AnimatorSet animatorSet = this.i3;
        if (animatorSet != null) {
            animatorSet.start();
        }
        AnimatorSet animatorSet2 = this.m3;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
        AnimatorSet animatorSet3 = this.f198591r3;
        if (animatorSet3 != null) {
            animatorSet3.start();
        }
        AnimatorSet animatorSet4 = this.f198597u3;
        if (animatorSet4 != null) {
            animatorSet4.start();
        }
        AnimatorSet animatorSet5 = this.w3;
        if (animatorSet5 != null) {
            animatorSet5.start();
        }
        AnimatorSet animatorSet6 = this.A3;
        if (animatorSet6 != null) {
            animatorSet6.start();
        }
    }

    @TargetApi(11)
    public void r() {
        AnimatorSet animatorSet = this.L4;
        if (animatorSet != null) {
            animatorSet.start();
        }
        AnimatorSet animatorSet2 = this.N4;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
    }

    @TargetApi(11)
    public void s() {
        AnimatorSet animatorSet = this.H4;
        if (animatorSet != null) {
            animatorSet.start();
        }
        AnimatorSet animatorSet2 = this.J4;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
    }

    @TargetApi(11)
    public void t() {
        AnimatorSet animatorSet = this.P4;
        if (animatorSet != null) {
            animatorSet.start();
        }
        AnimatorSet animatorSet2 = this.R4;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
        AnimatorSet animatorSet3 = this.T4;
        if (animatorSet3 != null) {
            animatorSet3.start();
        }
    }

    @TargetApi(11)
    public void u() {
        AnimatorSet animatorSet = this.X3;
        if (animatorSet != null) {
            animatorSet.start();
        }
        AnimatorSet animatorSet2 = this.f198566b4;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
        AnimatorSet animatorSet3 = this.f198576g4;
        if (animatorSet3 != null) {
            animatorSet3.start();
        }
        AnimatorSet animatorSet4 = this.f198581k4;
        if (animatorSet4 != null) {
            animatorSet4.start();
        }
    }

    @TargetApi(11)
    public void v() {
        AnimatorSet animatorSet = this.H3;
        if (animatorSet != null) {
            animatorSet.start();
        }
        AnimatorSet animatorSet2 = this.L3;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
        AnimatorSet animatorSet3 = this.Q3;
        if (animatorSet3 != null) {
            animatorSet3.start();
        }
    }

    @TargetApi(11)
    public void w() {
        AnimatorSet animatorSet = this.f198598u4;
        if (animatorSet != null) {
            animatorSet.start();
        }
        AnimatorSet animatorSet2 = this.f198600w4;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
        AnimatorSet animatorSet3 = this.f198604y4;
        if (animatorSet3 != null) {
            animatorSet3.start();
        }
    }

    @TargetApi(11)
    public void x() {
        AnimatorSet animatorSet = this.B4;
        if (animatorSet != null) {
            animatorSet.start();
        }
        AnimatorSet animatorSet2 = this.F4;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
    }

    @TargetApi(11)
    public void y() {
        AnimatorSet animatorSet = this.f198584n4;
        if (animatorSet != null) {
            animatorSet.start();
        }
        AnimatorSet animatorSet2 = this.f198592r4;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
    }
}
