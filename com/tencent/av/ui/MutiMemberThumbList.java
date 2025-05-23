package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MutiMemberThumbList extends FrameLayout {
    private GradientDrawable C;
    private View D;
    private boolean E;
    private long F;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f74968d;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<com.tencent.av.e> f74969e;

    /* renamed from: f, reason: collision with root package name */
    private final String f74970f;

    /* renamed from: h, reason: collision with root package name */
    private long f74971h;

    /* renamed from: i, reason: collision with root package name */
    private int f74972i;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f74973m;

    public MutiMemberThumbList(Context context) {
        this(context, null);
    }

    private void i(final int i3, final ArrayList<com.tencent.av.e> arrayList) {
        QLog.d("MutiMemberThumbList", 1, "doDisplay " + i3);
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.av.ui.MutiMemberThumbList.1
            @Override // java.lang.Runnable
            public void run() {
                final boolean z16;
                final ArrayList arrayList2 = new ArrayList();
                if (i3 > MutiMemberThumbList.this.f74968d.length) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                for (int i16 = 0; i16 < arrayList.size() && i16 < MutiMemberThumbList.this.f74968d.length; i16++) {
                    com.tencent.av.e eVar = (com.tencent.av.e) arrayList.get(i16);
                    if (z16 && i16 == MutiMemberThumbList.this.f74968d.length - 1) {
                        break;
                    }
                    Bitmap S = com.tencent.av.r.h0().S(String.valueOf(eVar.f73701a), String.valueOf(MutiMemberThumbList.this.f74971h), MutiMemberThumbList.this.f74972i, true, true);
                    if (MutiMemberThumbList.this.E) {
                        S = ba.drawBitmapCoverLayer(S, "#4C000000", true);
                    }
                    arrayList2.add(S);
                }
                if (MutiMemberThumbList.this.f74973m) {
                    QLog.d("MutiMemberThumbList", 1, "doDisplay quit by destroyed in UI_Thread");
                } else {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.ui.MutiMemberThumbList.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MutiMemberThumbList.this.f74973m) {
                                QLog.d("MutiMemberThumbList", 1, "doDisplay quit by destroyed in UI_Thread");
                                return;
                            }
                            View findViewById = MutiMemberThumbList.this.findViewById(R.id.b2g);
                            if (i3 > 0) {
                                findViewById.setVisibility(0);
                                int i17 = 0;
                                while (true) {
                                    if (i17 >= MutiMemberThumbList.this.f74968d.length) {
                                        break;
                                    }
                                    MutiMemberThumbList mutiMemberThumbList = MutiMemberThumbList.this;
                                    View findViewById2 = mutiMemberThumbList.findViewById(mutiMemberThumbList.f74968d[i17]);
                                    ImageView imageView = (ImageView) findViewById2.findViewById(R.id.g8k);
                                    TextView textView = (TextView) findViewById2.findViewById(R.id.g8m);
                                    textView.setVisibility(8);
                                    imageView.setImageDrawable(null);
                                    if (z16 && i17 == MutiMemberThumbList.this.f74968d.length - 1) {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        textView.setText(String.format("%d+", Integer.valueOf((i3 - MutiMemberThumbList.this.f74968d.length) + 1)));
                                        textView.setVisibility(0);
                                        ((ImageView) findViewById2.findViewById(R.id.g8k)).setImageDrawable(MutiMemberThumbList.this.C);
                                        findViewById2.setVisibility(0);
                                        break;
                                    }
                                    if (i17 < i3 && i17 < arrayList2.size()) {
                                        imageView.setImageBitmap((Bitmap) arrayList2.get(i17));
                                        findViewById2.setVisibility(0);
                                    } else {
                                        findViewById2.setVisibility(8);
                                    }
                                    i17++;
                                }
                                MutiMemberThumbList.this.setVisibility(0);
                                if (MutiMemberThumbList.this.D != null) {
                                    MutiMemberThumbList.this.D.setVisibility(0);
                                    return;
                                }
                                return;
                            }
                            findViewById.setVisibility(4);
                            MutiMemberThumbList.this.setVisibility(4);
                        }
                    });
                }
            }
        });
    }

    private void j() {
        addView(LayoutInflater.from(getContext()).inflate(R.layout.f168503ye, (ViewGroup) null));
        this.f74973m = false;
    }

    public void h() {
        this.f74973m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        QLog.d("MutiMemberThumbList", 1, "onDetachedFromWindow ");
        super.onDetachedFromWindow();
        this.f74973m = true;
    }

    public void setDisPlayList(ArrayList<com.tencent.av.e> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            QLog.d("MutiMemberThumbList", 1, "setDisPlayList cost" + (System.currentTimeMillis() - this.F));
            this.f74969e.clear();
            this.f74969e.addAll(arrayList);
            i(this.f74969e.size(), (ArrayList) this.f74969e.clone());
            return;
        }
        setVisibility(4);
        this.F = System.currentTimeMillis();
        QLog.d("MutiMemberThumbList", 1, "setDisPlayList " + this.F);
    }

    public void setHeadImgMask(boolean z16) {
        this.E = z16;
    }

    public void setMoreInfoDrawableColor(String str) {
        int f16 = BaseAIOUtils.f(32.0f, getResources());
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.C = gradientDrawable;
        gradientDrawable.setShape(1);
        this.C.setColor(Color.parseColor(str));
        this.C.setSize(f16, f16);
    }

    public void setRelationShipInfo(long j3, int i3) {
        this.f74971h = j3;
        this.f74972i = i3;
    }

    public MutiMemberThumbList(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MutiMemberThumbList(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f74968d = new int[]{R.id.ga_, R.id.gaa, R.id.gab, R.id.gac, R.id.gad, R.id.gae, R.id.gaf};
        this.f74969e = new ArrayList<>();
        this.f74970f = "%d+";
        this.f74971h = 0L;
        this.f74972i = 0;
        this.f74973m = false;
        this.E = false;
        this.F = -1L;
        j();
    }
}
