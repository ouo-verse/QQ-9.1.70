package com.tencent.gdtad.impl;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.hippy.GdtTangramModule;
import com.tencent.gdtad.inject.IGdtThirdProcessor;
import com.tencent.gdtad.jsbridge.GdtAdPluginFactory;
import com.tencent.gdtad.jsbridge.GdtOpenMvPageHandler;
import com.tencent.gdtad.params.GetUserInfoCallback;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.component.TxchPage;
import com.tencent.raft.raftframework.RAApplicationContext;
import java.util.HashMap;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b implements IGdtThirdProcessor {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements ITroopMemberApiClientApi.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GetUserInfoCallback f109212d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.troop.b f109213e;

        a(GetUserInfoCallback getUserInfoCallback, com.tencent.biz.troop.b bVar) {
            this.f109212d = getUserInfoCallback;
            this.f109213e = bVar;
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            this.f109212d.callback(bundle);
            this.f109213e.q();
        }
    }

    private URLDrawable a(@NonNull Context context, String str, int i3, int i16) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Resources resources = context.getResources();
        obtain.mLoadingDrawable = resources.getDrawable(R.drawable.aee);
        obtain.mFailedDrawable = resources.getDrawable(R.drawable.aee);
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        drawable.setTag(com.tencent.mobileqq.urldrawable.a.c(i3, i3, i16));
        drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306324d);
        return drawable;
    }

    @Deprecated
    private void b(@Nullable GdtMotiveVideoPageData gdtMotiveVideoPageData, long j3, long j16, boolean z16) {
        if (gdtMotiveVideoPageData == null) {
            QLog.i("GdtThirdProcessorImpl", 1, "onHippyCallback data is null");
            return;
        }
        String asyncCallbackId = gdtMotiveVideoPageData.getAsyncCallbackId();
        if (TextUtils.isEmpty(asyncCallbackId)) {
            QLog.i("GdtThirdProcessorImpl", 1, "onHippyCallback id is null");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("elapsedTime", Long.valueOf(j3));
        hashMap.put("totalTime", Long.valueOf(j16));
        hashMap.put("isEnd", Boolean.valueOf(z16));
        GdtTangramModule.onHippyAsyncCallback(asyncCallbackId, hashMap);
    }

    @Override // com.tencent.gdtad.inject.IGdtThirdProcessor
    public void addReadInJoyCb(@NonNull Intent intent, String str) {
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("arg_callback", str);
        }
    }

    @Override // com.tencent.gdtad.inject.IGdtThirdProcessor
    public void c2sReportAsync(int i3, int i16, qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        com.tencent.gdtad.statistics.a.b(i3, i16, adInfo);
    }

    @Override // com.tencent.gdtad.inject.IGdtThirdProcessor
    @Deprecated
    public void doCallbackBeforeFinish(GdtMotiveVideoPageData gdtMotiveVideoPageData, long j3, long j16, boolean z16) {
        GdtOpenMvPageHandler gdtOpenMvPageHandler = (GdtOpenMvPageHandler) GdtAdPluginFactory.getInstance().findJsCallHandler(16);
        if (gdtOpenMvPageHandler != null) {
            gdtOpenMvPageHandler.sendResult2Web(gdtMotiveVideoPageData, String.valueOf(j3), String.valueOf(j16), String.valueOf(z16));
        }
        b(gdtMotiveVideoPageData, j3, j16, z16);
    }

    @Override // com.tencent.gdtad.inject.IGdtThirdProcessor
    @Nullable
    public Drawable gdtADBoxItemDrawable(@NonNull Context context, String str) {
        URLDrawable uRLDrawable;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = false;
        int dpToPx = ViewUtils.dpToPx(65.0f);
        obtain.mRequestHeight = dpToPx;
        obtain.mRequestWidth = dpToPx;
        obtain.mFailedDrawable = context.getResources().getDrawable(R.drawable.f161062ch3);
        obtain.mLoadingDrawable = context.getResources().getDrawable(R.drawable.f161062ch3);
        try {
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
        } catch (Exception e16) {
            e = e16;
            uRLDrawable = null;
        }
        try {
            uRLDrawable.setTag(com.tencent.mobileqq.urldrawable.a.c(dpToPx, dpToPx, ViewUtils.dpToPx(9.0f)));
            uRLDrawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
        } catch (Exception e17) {
            e = e17;
            QLog.e("GdtThirdProcessorImpl", 1, "gdtADBoxItemDrawable url=" + str, e);
            return uRLDrawable;
        }
        return uRLDrawable;
    }

    @Override // com.tencent.gdtad.inject.IGdtThirdProcessor
    public void gdtGetCurrentUserInfo(@NonNull GetUserInfoCallback getUserInfoCallback) {
        com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
        A.p();
        A.t(new a(getUserInfoCallback, A));
    }

    @Override // com.tencent.gdtad.inject.IGdtThirdProcessor
    public Drawable gdtMvIcon(@NonNull Context context, @Nullable GdtMotiveVideoPageData gdtMotiveVideoPageData, int i3, int i16) {
        if (gdtMotiveVideoPageData != null && !TextUtils.isEmpty(gdtMotiveVideoPageData.bannerLogo)) {
            return a(context, gdtMotiveVideoPageData.bannerLogo, i3, i16);
        }
        return context.getResources().getDrawable(R.drawable.aee);
    }

    @Override // com.tencent.gdtad.inject.IGdtThirdProcessor
    public Drawable getPreViewImage(@NonNull Context context, String str) {
        Drawable drawable = context.getResources().getDrawable(R.drawable.trans);
        if (TextUtils.isEmpty(str)) {
            return drawable;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        try {
            URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
            drawable2.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306334n);
            drawable2.setTag(new int[]{50});
            return drawable2;
        } catch (Exception e16) {
            QLog.e("GdtThirdProcessorImpl", 1, "getPreViewImage error:", e16);
            return drawable;
        }
    }

    @Override // com.tencent.gdtad.inject.IGdtThirdProcessor
    public String getProductId(Context context) {
        String str;
        RAApplicationContext globalContext = RAApplicationContext.getGlobalContext();
        if (!globalContext.hasStartUp()) {
            globalContext.startup(context);
        }
        TxchPage txchPage = (TxchPage) globalContext.getService(TxchPage.class);
        if (txchPage != null) {
            str = txchPage.productId;
        } else {
            str = "36028";
        }
        globalContext.shutdown();
        return str;
    }
}
