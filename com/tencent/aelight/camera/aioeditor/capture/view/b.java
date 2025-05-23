package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f67342c = {100, R.drawable.lkm, R.id.f58092p3};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f67343d = {101, R.drawable.lko, R.id.f58112p5};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f67344e = {102, R.drawable.lkn, R.id.f58102p4};

    /* renamed from: a, reason: collision with root package name */
    private int f67345a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<int[]> f67346b = new ArrayList<>();

    public b(int i3, List<Integer> list) {
        this.f67345a = i3;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (intValue == 100) {
                this.f67346b.add(f67342c);
            } else if (intValue == 101) {
                this.f67346b.add(f67343d);
            } else if (intValue == 102) {
                this.f67346b.add(f67344e);
            }
        }
    }

    public int b() {
        return this.f67346b.size();
    }

    public int c(int i3) {
        if (i3 < 0 || i3 > this.f67346b.size()) {
            return 0;
        }
        return this.f67346b.get(i3)[2];
    }

    public int d(int i3) {
        if (i3 < 0 || i3 > this.f67346b.size()) {
            return 0;
        }
        return this.f67346b.get(i3)[1];
    }

    public int e(int i3) {
        if (i3 < 0 || i3 > this.f67346b.size()) {
            return -1;
        }
        return this.f67346b.get(i3)[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ProviderView a(Context context, int i3) {
        ProviderView qIMFilterProviderView;
        ProviderView providerView;
        if (i3 == 100) {
            qIMFilterProviderView = new QIMFilterProviderView(context);
            qIMFilterProviderView.setId(R.id.apf);
        } else {
            if (i3 != 101) {
                if (QLog.isColorLevel()) {
                    QLog.d("ProviderViewBuilder", 2, "bad id=" + i3);
                }
                providerView = null;
                if (providerView != null) {
                    providerView.setCaptureScene(this.f67345a);
                    providerView.setTabBarPosition(2);
                    providerView.m(231);
                }
                return providerView;
            }
            qIMFilterProviderView = new StaticStickerProviderView(context);
            qIMFilterProviderView.setId(R.id.apo);
        }
        providerView = qIMFilterProviderView;
        if (providerView != null) {
        }
        return providerView;
    }
}
