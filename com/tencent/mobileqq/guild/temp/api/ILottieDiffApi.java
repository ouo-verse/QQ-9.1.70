package com.tencent.mobileqq.guild.temp.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface ILottieDiffApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f235230a;

        /* renamed from: b, reason: collision with root package name */
        public String f235231b;

        /* renamed from: c, reason: collision with root package name */
        public String f235232c;

        /* renamed from: d, reason: collision with root package name */
        public int f235233d;

        /* renamed from: e, reason: collision with root package name */
        public int f235234e;

        /* renamed from: f, reason: collision with root package name */
        public String f235235f;

        /* renamed from: g, reason: collision with root package name */
        public String f235236g;
    }

    void addToCustomEmotion(Context context, Drawable drawable);

    void addToCustomEmotion(Context context, String str);

    boolean checkSaveToEmoMenuItemEnable();

    View createLottieAnimView(Context context, FaceElement faceElement, int i3, ViewGroup.LayoutParams layoutParams);

    View createLottieAnimViewForMedia(Context context, ViewGroup viewGroup, int i3, FrameLayout.LayoutParams layoutParams, Runnable runnable);

    a getLottieEmoInfo(int i3);

    boolean isSupportLottie(int i3);

    void pauseLottie(ViewGroup viewGroup);

    void recyclerLottieViewDrawable(View view);

    void resumeLottie(ViewGroup viewGroup);
}
