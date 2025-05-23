package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.capture.data.k;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import zr.c;

/* loaded from: classes32.dex */
public class ProviderViewEditContainer extends FrameLayout {
    private HashMap<Integer, ProviderView> C;
    private int[] D;

    /* renamed from: d, reason: collision with root package name */
    private k f67282d;

    /* renamed from: e, reason: collision with root package name */
    private ProviderView f67283e;

    /* renamed from: f, reason: collision with root package name */
    private ProviderView.a f67284f;

    /* renamed from: h, reason: collision with root package name */
    private int f67285h;

    /* renamed from: i, reason: collision with root package name */
    private int f67286i;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f67287m;

    public ProviderViewEditContainer(Context context) {
        super(context);
        this.f67285h = 100;
        this.f67286i = 0;
        this.C = new HashMap<>();
        this.D = new int[]{103, 107};
    }

    private boolean g(int i3, Object... objArr) {
        ProviderView a16;
        if (this.C.containsKey(Integer.valueOf(i3))) {
            a16 = this.C.get(Integer.valueOf(i3));
        } else {
            a16 = a(i3);
            if (a16 != null) {
                this.C.put(Integer.valueOf(i3), a16);
                addView(a16);
            }
        }
        if (a16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ProviderViewEditContainer", 2, "openContainerProviderView view not exsist, id:", Integer.valueOf(i3));
            }
            return false;
        }
        this.f67283e = a16;
        if (i3 == 103) {
            StaticStickerProviderView staticStickerProviderView = (StaticStickerProviderView) a16;
            if (!staticStickerProviderView.s()) {
                staticStickerProviderView.v(null);
                staticStickerProviderView.setOnFaceSelectedListener(this.f67282d);
            }
            staticStickerProviderView.setCaptureScene(this.f67286i);
            staticStickerProviderView.G();
            staticStickerProviderView.y();
            if (objArr != null && objArr.length == 1) {
                staticStickerProviderView.I((c.a) objArr[0]);
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            int b16 = UIUtils.b(getContext(), 250.0f);
            if (layoutParams.height != b16) {
                layoutParams.height = b16;
                setLayoutParams(layoutParams);
            }
            this.f67285h = 103;
        } else if (i3 == 107) {
            MusicFragmentProviderView musicFragmentProviderView = (MusicFragmentProviderView) a16;
            if (!musicFragmentProviderView.s()) {
                musicFragmentProviderView.m(250);
                musicFragmentProviderView.v(null);
                ProviderView.a aVar = this.f67284f;
                if (aVar != null) {
                    musicFragmentProviderView.setProviderViewListener(aVar);
                }
            }
            musicFragmentProviderView.setCaptureScene(this.f67286i);
            if (objArr != null && objArr.length == 1) {
                musicFragmentProviderView.setMusicProviderView((MusicItemInfo) objArr[0]);
            }
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            int b17 = UIUtils.b(getContext(), 250.0f);
            if (layoutParams2.height != b17) {
                layoutParams2.height = b17;
                setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = getLayoutParams();
            RelativeLayout relativeLayout = this.f67287m;
            if (relativeLayout != null) {
                layoutParams3.height += relativeLayout.getHeight();
                setLayoutParams(layoutParams3);
            }
            this.f67285h = 107;
        }
        return true;
    }

    public boolean b(MotionEvent motionEvent) {
        if (this.f67283e == null || getVisibility() != 0) {
            return false;
        }
        return this.f67283e.n(motionEvent);
    }

    public void d() {
        Iterator<ProviderView> it = this.C.values().iterator();
        while (it.hasNext()) {
            it.next().u();
        }
    }

    public boolean e() {
        HashMap<Integer, ProviderView> hashMap;
        ProviderView providerView;
        if (this.f67285h == 100 || getVisibility() != 0 || (hashMap = this.C) == null || (providerView = hashMap.get(Integer.valueOf(this.f67285h))) == null) {
            return false;
        }
        return providerView.B();
    }

    public void f(int i3, Object... objArr) {
        ProviderView providerView;
        if (g(i3, objArr) && (providerView = this.f67283e) != null) {
            providerView.setVisibility(0);
            setVisibility(0);
        }
    }

    public void h(int i3) {
        this.f67286i = i3;
    }

    public void setLiuHaiParentView(RelativeLayout relativeLayout) {
        this.f67287m = relativeLayout;
    }

    public void setProviderViewListener(ProviderView.a aVar) {
        this.f67284f = aVar;
    }

    public void setStickerListener(k kVar) {
        this.f67282d = kVar;
    }

    public void c() {
        setVisibility(8);
        ProviderView providerView = this.f67283e;
        if (providerView != null) {
            providerView.x();
            this.f67283e.setVisibility(8);
            this.f67283e = null;
        }
        this.f67285h = 100;
    }

    public ProviderViewEditContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f67285h = 100;
        this.f67286i = 0;
        this.C = new HashMap<>();
        this.D = new int[]{103, 107};
    }

    public ProviderViewEditContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f67285h = 100;
        this.f67286i = 0;
        this.C = new HashMap<>();
        this.D = new int[]{103, 107};
    }

    private ProviderView a(int i3) {
        if (i3 == 103) {
            return new StaticStickerProviderView(getContext());
        }
        if (i3 != 107) {
            return null;
        }
        MusicFragmentProviderView musicFragmentProviderView = new MusicFragmentProviderView(getContext());
        musicFragmentProviderView.setNeedTabBar(false);
        return musicFragmentProviderView;
    }
}
