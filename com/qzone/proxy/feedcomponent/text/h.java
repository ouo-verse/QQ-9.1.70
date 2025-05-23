package com.qzone.proxy.feedcomponent.text;

import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final int f50745a = (int) (ViewUtils.getDensity() * 20.0f);

    /* renamed from: b, reason: collision with root package name */
    private static final LinkedList<a> f50746b;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f50747a = true;

        /* renamed from: b, reason: collision with root package name */
        public int f50748b = h.f50745a;

        /* renamed from: c, reason: collision with root package name */
        public ImageLoader.ImageLoadListener f50749c = null;

        /* renamed from: d, reason: collision with root package name */
        public Object f50750d = null;

        a() {
        }
    }

    static {
        LinkedList<a> linkedList = new LinkedList<>();
        f50746b = linkedList;
        for (int size = 10 - linkedList.size(); size > 0; size--) {
            f50746b.add(new a());
        }
    }
}
