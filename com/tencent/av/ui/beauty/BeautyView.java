package com.tencent.av.ui.beauty;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.FadingHorizontalScrollView;
import com.tencent.av.ui.f;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.av;
import com.tencent.av.utils.aw;
import com.tencent.av.utils.ba;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BeautyView extends BeautyBaseView {
    public static final Object[][] H = {new Object[]{"BEAUTY_SKIN", Integer.valueOf(R.string.iw_), Integer.valueOf(R.drawable.hri)}, new Object[]{"FACE_SHAPE_4", Integer.valueOf(R.string.f171216iw0), Integer.valueOf(R.drawable.hr_)}, new Object[]{"COLOR_TONE", Integer.valueOf(R.string.iw9), Integer.valueOf(R.drawable.hrj)}, new Object[]{"FACE_V", Integer.valueOf(R.string.f171218iw3), Integer.valueOf(R.drawable.hrc)}, new Object[]{"FACE_THIN", Integer.valueOf(R.string.f171217iw2), Integer.valueOf(R.drawable.hra)}, new Object[]{"CHIN", Integer.valueOf(R.string.ivy), Integer.valueOf(R.drawable.hr9)}, new Object[]{"ENLARGE_EYE", Integer.valueOf(R.string.ivz), Integer.valueOf(R.drawable.hrd)}, new Object[]{"EYE_LIGHTEN", Integer.valueOf(R.string.f171219iw4), Integer.valueOf(R.drawable.hre)}, new Object[]{"NOSE_THIN", Integer.valueOf(R.string.iw7), Integer.valueOf(R.drawable.hrk)}, new Object[]{"MOUTH_SHAPE", Integer.valueOf(R.string.iw6), Integer.valueOf(R.drawable.hrg)}, new Object[]{"TOOTH_WHITEN", Integer.valueOf(R.string.iwa), Integer.valueOf(R.drawable.hrl)}};
    public static final Object[][] I = {new Object[]{"BEAUTY_SKIN", Integer.valueOf(R.string.f1776934n), Integer.valueOf(R.drawable.msp)}, new Object[]{"FACE", Integer.valueOf(R.string.f1776034e), Integer.valueOf(R.drawable.f160619msg)}, new Object[]{"EYES_MAGNIFY", Integer.valueOf(R.string.f1775934d), Integer.valueOf(R.drawable.f160618msf)}, new Object[]{"CONTRAST", Integer.valueOf(R.string.f1775834c), Integer.valueOf(R.drawable.mse)}, new Object[]{"BRIGHTEN", Integer.valueOf(R.string.f1775634a), Integer.valueOf(R.drawable.msd)}, new Object[]{"FACE_V", Integer.valueOf(R.string.f1777134p), Integer.valueOf(R.drawable.msr)}, new Object[]{"FACE_WIDTH", Integer.valueOf(R.string.f1776134f), Integer.valueOf(R.drawable.msh)}, new Object[]{"CHEEK_THIN", Integer.valueOf(R.string.f1775734b), Integer.valueOf(R.drawable.f160617oi0)}, new Object[]{"NOSE_SHRINK", Integer.valueOf(R.string.f1776634k), Integer.valueOf(R.drawable.msm)}, new Object[]{"MOUTH", Integer.valueOf(R.string.f1776334h), Integer.valueOf(R.drawable.msj)}, new Object[]{"FOREHEAD", Integer.valueOf(R.string.f1776234g), Integer.valueOf(R.drawable.msi)}, new Object[]{"MOUTH_LIPS", Integer.valueOf(R.string.f1776434i), Integer.valueOf(R.drawable.msk)}, new Object[]{"ROUGE", Integer.valueOf(R.string.f1776834m), Integer.valueOf(R.drawable.mso)}, new Object[]{"FACE_3D", Integer.valueOf(R.string.f1775534_), Integer.valueOf(R.drawable.msc)}, new Object[]{"TEETH_WHITEN", Integer.valueOf(R.string.f1777034o), Integer.valueOf(R.drawable.msq)}, new Object[]{"POUCH", Integer.valueOf(R.string.f1776734l), Integer.valueOf(R.drawable.msn)}, new Object[]{"NASOLABIAL", Integer.valueOf(R.string.f1776534j), Integer.valueOf(R.drawable.msl)}};
    final LinearLayout C;
    int D;
    private boolean E;
    private int F;
    final ArrayList<c> G;

    /* renamed from: f, reason: collision with root package name */
    VideoAppInterface f75434f;

    /* renamed from: h, reason: collision with root package name */
    final BeautySeekView f75435h;

    /* renamed from: i, reason: collision with root package name */
    final Button f75436i;

    /* renamed from: m, reason: collision with root package name */
    final FadingHorizontalScrollView f75437m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            BeautyView beautyView = BeautyView.this;
            beautyView.onClick(beautyView.f75436i);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f75440a;

        /* renamed from: b, reason: collision with root package name */
        public int f75441b;

        /* renamed from: c, reason: collision with root package name */
        public String f75442c;

        /* renamed from: d, reason: collision with root package name */
        public int f75443d;

        /* renamed from: e, reason: collision with root package name */
        public int f75444e;

        /* renamed from: f, reason: collision with root package name */
        public int f75445f;

        /* renamed from: g, reason: collision with root package name */
        public int f75446g;

        c() {
        }
    }

    public BeautyView(Context context) {
        this(context, null);
    }

    private void g(int i3, com.tencent.av.opengl.effects.c cVar) {
        Object[][] objArr;
        if (f.d()) {
            objArr = I;
        } else {
            objArr = H;
        }
        for (int i16 = 0; i16 < objArr.length; i16++) {
            c cVar2 = new c();
            Object[] objArr2 = objArr[i16];
            cVar2.f75442c = (String) objArr2[0];
            cVar2.f75440a = ((Integer) objArr2[1]).intValue();
            cVar2.f75441b = ((Integer) objArr[i16][2]).intValue();
            cVar2.f75443d = cVar.b(cVar2.f75442c);
            cVar2.f75446g = cVar.e(cVar2.f75442c);
            cVar2.f75445f = i16;
            this.G.add(cVar2);
            View i17 = i(cVar2);
            this.C.addView(i17, new LinearLayout.LayoutParams(Math.max(i3, cVar2.f75444e), -2));
            if (this.D == i16) {
                i17.setSelected(true);
            } else {
                i17.setSelected(false);
            }
        }
    }

    @Override // com.tencent.av.ui.beauty.BeautySeekView.c
    public void a(String str, int i3, int i16) {
        c cVar;
        int i17;
        if (str == null) {
            return;
        }
        Iterator<c> it = this.G.iterator();
        while (true) {
            if (it.hasNext()) {
                cVar = it.next();
                if (str.equals(cVar.f75442c)) {
                    break;
                }
            } else {
                cVar = null;
                break;
            }
        }
        if (cVar != null) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        cVar.f75443d = i16;
                        VideoAppInterface videoAppInterface = this.f75434f;
                        if (videoAppInterface != null) {
                            videoAppInterface.w0(str, i16, true);
                            String str2 = this.F + "";
                            String str3 = (i16 - this.F) + "";
                            if (f.d()) {
                                i17 = 7;
                            } else {
                                i17 = 5;
                            }
                            ReportController.o(null, "dc00898", "", "", "0X800A569", "0X800A569", 0, 0, str2, str3, j(str, i17), k());
                            return;
                        }
                        return;
                    }
                    return;
                }
                cVar.f75443d = i16;
                VideoAppInterface videoAppInterface2 = this.f75434f;
                if (videoAppInterface2 != null) {
                    videoAppInterface2.w0(str, i16, false);
                    return;
                }
                return;
            }
            this.F = i16;
        }
    }

    public Bitmap h(Drawable drawable, int i3) {
        int width;
        int i16;
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        int i17 = 0;
        if (bitmap.getWidth() > i3) {
            i16 = (bitmap.getWidth() - i3) / 2;
            width = i3;
        } else {
            width = bitmap.getWidth();
            i16 = 0;
        }
        if (bitmap.getHeight() > i3) {
            i17 = (bitmap.getHeight() - i3) / 2;
        } else {
            i3 = bitmap.getHeight();
        }
        return Bitmap.createBitmap(bitmap, i16, i17, width, i3);
    }

    View i(c cVar) {
        Button button = new Button(getContext());
        l(button, cVar.f75440a, cVar.f75441b, R.color.amo, cVar);
        cVar.f75444e = (int) Math.max(ba.getMeasureTextWidth(button), BaseAIOUtils.f(28.0f, getResources()));
        return button;
    }

    public String j(String str, int i3) {
        if (i3 == 5) {
            int i16 = 0;
            while (true) {
                Object[][] objArr = H;
                if (i16 >= objArr.length) {
                    return "";
                }
                if (str.equals(objArr[i16][0])) {
                    return BaseApplicationImpl.getApplication().getResources().getString(((Integer) objArr[i16][1]).intValue());
                }
                i16++;
            }
        } else {
            if (i3 == 7) {
                int i17 = 0;
                while (true) {
                    Object[][] objArr2 = I;
                    if (i17 >= objArr2.length) {
                        break;
                    }
                    if (str.equals(objArr2[i17][0])) {
                        return BaseApplicationImpl.getApplication().getResources().getString(((Integer) objArr2[i17][1]).intValue());
                    }
                    i17++;
                }
            }
            return "";
        }
    }

    public String k() {
        if (f.d()) {
            if (f.e()) {
                return "7-";
            }
            return "7";
        }
        return "5";
    }

    void l(Button button, int i3, int i16, int i17, Object obj) {
        aw b16;
        int f16 = BaseAIOUtils.f(28.0f, getResources());
        Resources resources = getResources();
        Drawable drawable = resources.getDrawable(i16);
        if (drawable.getIntrinsicHeight() <= f16 && drawable.getIntrinsicWidth() <= f16) {
            b16 = aw.a(resources, i16, i17);
        } else {
            b16 = aw.b(resources, h(drawable, f16), i17);
        }
        b16.setBounds(0, 0, Math.min(drawable.getIntrinsicWidth(), f16), Math.min(drawable.getIntrinsicHeight(), f16));
        button.setCompoundDrawables(null, b16, null, null);
        button.setTextColor(resources.getColorStateList(i17));
        button.setText(i3);
        button.setBackgroundDrawable(null);
        button.setOnClickListener(this);
        button.setTag(av.a.f77060a, obj);
        button.setTextSize(ViewUtils.pxTosp(BaseAIOUtils.f(12.0f, getResources())));
        button.setCompoundDrawablePadding(BaseAIOUtils.f(8.0f, getResources()));
    }

    void m() {
        c cVar;
        Resources resources = getResources();
        int i3 = this.D;
        if (i3 >= 0 && i3 < this.G.size()) {
            cVar = this.G.get(this.D);
        } else {
            cVar = null;
        }
        if (cVar != null) {
            this.f75435h.l(resources.getString(cVar.f75440a), cVar.f75442c, cVar.f75443d, cVar.f75446g);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f75436i) {
            if (this.E) {
                this.E = false;
                VideoAppInterface videoAppInterface = this.f75434f;
                if (videoAppInterface != null) {
                    f.i(videoAppInterface.getCurrentAccountUin(), 1);
                }
                DialogUtil.createNoTitleDialog((Activity) getContext(), getResources().getString(R.string.iw8), R.string.cancel, R.string.f171151ok, new a(), new b()).show();
            } else {
                VideoAppInterface videoAppInterface2 = this.f75434f;
                if (videoAppInterface2 != null) {
                    videoAppInterface2.t0();
                    Iterator<c> it = this.G.iterator();
                    while (it.hasNext()) {
                        c next = it.next();
                        next.f75443d = this.f75434f.z(next.f75442c);
                    }
                }
                m();
            }
        } else {
            Object tag = view.getTag(av.a.f77060a);
            if (tag instanceof c) {
                c cVar = (c) tag;
                int i3 = cVar.f75445f;
                int i16 = this.D;
                if (i3 != i16) {
                    if (i16 >= 0 && i16 < this.C.getChildCount()) {
                        this.C.getChildAt(this.D).setSelected(false);
                    }
                    view.setSelected(true);
                    this.D = cVar.f75445f;
                    m();
                }
                AVUtil.a("0X800A568", cVar.f75445f + 1);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.av.ui.d
    public void refreshUI() {
        this.D = 0;
        VideoAppInterface videoAppInterface = this.f75434f;
        if (videoAppInterface != null) {
            com.tencent.av.opengl.effects.c y16 = videoAppInterface.y();
            for (int i3 = 0; i3 < this.G.size(); i3++) {
                c cVar = this.G.get(i3);
                cVar.f75443d = y16.b(cVar.f75442c);
            }
        }
        int childCount = this.C.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = this.C.getChildAt(i16);
            if (childAt != null) {
                if (i16 == this.D) {
                    childAt.setSelected(true);
                } else {
                    childAt.setSelected(false);
                }
            }
        }
        m();
    }

    @Override // com.tencent.av.ui.beauty.BeautyBaseView
    public void setAppInterface(VideoAppInterface videoAppInterface) {
        boolean z16;
        super.setAppInterface(videoAppInterface);
        VideoAppInterface videoAppInterface2 = this.f75434f;
        if (videoAppInterface2 != null) {
            if (f.b(videoAppInterface2.getCurrentAccountUin()) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.E = z16;
            com.tencent.av.opengl.effects.c y16 = this.f75434f.y();
            Iterator<c> it = this.G.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    next.f75443d = y16.b(next.f75442c);
                }
            }
            m();
        }
    }

    public BeautyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BeautyView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        com.tencent.av.opengl.effects.c cVar;
        this.D = 0;
        this.E = true;
        this.G = new ArrayList<>();
        View.inflate(context, R.layout.api, this);
        BeautySeekView beautySeekView = (BeautySeekView) findViewById(R.id.a7n);
        this.f75435h = beautySeekView;
        Button button = (Button) findViewById(R.id.l_z);
        this.f75436i = button;
        FadingHorizontalScrollView fadingHorizontalScrollView = (FadingHorizontalScrollView) findViewById(R.id.f164592la3);
        this.f75437m = fadingHorizontalScrollView;
        this.C = (LinearLayout) findViewById(R.id.f164591la2);
        int screenWidth = (int) (ImmersiveUtils.getScreenWidth() / 5.6f);
        fadingHorizontalScrollView.setFadingMode(1);
        fadingHorizontalScrollView.setFadingEdgeLength(screenWidth / 2);
        fadingHorizontalScrollView.setOverScrollMode(2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) button.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(screenWidth, -2);
        } else {
            layoutParams.width = screenWidth;
            layoutParams.height = -2;
        }
        button.setLayoutParams(layoutParams);
        l(button, R.string.ivx, R.drawable.hrh, R.color.amp, Integer.valueOf(R.id.l_z));
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof VideoAppInterface) {
            VideoAppInterface videoAppInterface = (VideoAppInterface) runtime;
            this.f75434f = videoAppInterface;
            this.E = f.b(videoAppInterface.getCurrentAccountUin()) == 0;
            cVar = this.f75434f.y();
        } else {
            cVar = new com.tencent.av.opengl.effects.c();
        }
        g(screenWidth, cVar);
        m();
        beautySeekView.setBeautySeekActionListener(this);
    }
}
