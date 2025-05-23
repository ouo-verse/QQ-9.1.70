package com.tencent.robot.adelie.homepage.utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.opr.helper.sr.SuperResolutionHelper;
import com.tencent.mobileqq.opr.helper.sr.model.SrStatus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.util.URLUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\t\u001a\u00020\b*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u001a8\u0010\u000b\u001a\u00020\b*\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u001an\u0010\u0013\u001a\u00020\b*\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062*\b\u0002\u0010\u0012\u001a$\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\b\u0018\u00010\u000ej\u0004\u0018\u0001`\u0011\u001a\u0012\u0010\u0017\u001a\u00020\b*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0015\u001a\u0012\u0010\u001a\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018\u001a&\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001cj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001`\u001d*\u00020\u001b*>\u0010\u001f\"\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\b0\u000e2\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\b0\u000e\u00a8\u0006 "}, d2 = {"Landroid/widget/ImageView;", "", "url", "Landroid/graphics/drawable/Drawable;", ToastView.ICON_LOADING, "failed", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "", "g", "localPath", "e", "Lcom/tencent/mobileqq/opr/helper/sr/SuperResolutionHelper;", "srHelper", "Lkotlin/Function3;", "", "", "Lcom/tencent/robot/adelie/homepage/utils/ISuperResolutionListener;", "superResolutionListener", "i", "Landroid/view/View;", "", "expendSize", "c", "", com.tencent.luggage.wxa.c8.c.f123400v, "l", "Lorg/json/JSONObject;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "ISuperResolutionListener", "robot-business-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class CommonExKt {
    public static final void c(@NotNull final View view, final int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        final View view2 = (View) parent;
        view2.post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.utils.m
            @Override // java.lang.Runnable
            public final void run() {
                CommonExKt.d(view, i3, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(View this_expendTouchArea, int i3, View parentView) {
        Intrinsics.checkNotNullParameter(this_expendTouchArea, "$this_expendTouchArea");
        Intrinsics.checkNotNullParameter(parentView, "$parentView");
        Rect rect = new Rect();
        this_expendTouchArea.getHitRect(rect);
        rect.top -= i3;
        rect.bottom += i3;
        rect.left -= i3;
        rect.right += i3;
        parentView.setTouchDelegate(new TouchDelegate(rect, this_expendTouchArea));
    }

    public static final void e(@NotNull ImageView imageView, @Nullable String str, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable IPicLoadStateListener iPicLoadStateListener) {
        boolean z16;
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Option option = Option.obtain().setTargetView(imageView).setLocalPath(str).setLoadingDrawable(drawable).setFailDrawable(drawable2);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, iPicLoadStateListener);
    }

    public static /* synthetic */ void f(ImageView imageView, String str, Drawable drawable, Drawable drawable2, IPicLoadStateListener iPicLoadStateListener, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        if ((i3 & 4) != 0) {
            drawable2 = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        if ((i3 & 8) != 0) {
            iPicLoadStateListener = null;
        }
        e(imageView, str, drawable, drawable2, iPicLoadStateListener);
    }

    public static final void g(@NotNull ImageView imageView, @Nullable String str, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable IPicLoadStateListener iPicLoadStateListener) {
        boolean z16;
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Option option = Option.obtain().setTargetView(imageView).setUrl(str).setLoadingDrawable(drawable).setFailDrawable(drawable2);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, iPicLoadStateListener);
    }

    public static /* synthetic */ void h(ImageView imageView, String str, Drawable drawable, Drawable drawable2, IPicLoadStateListener iPicLoadStateListener, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        if ((i3 & 4) != 0) {
            drawable2 = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        if ((i3 & 8) != 0) {
            iPicLoadStateListener = null;
        }
        g(imageView, str, drawable, drawable2, iPicLoadStateListener);
    }

    public static final void i(@NotNull ImageView imageView, @Nullable final SuperResolutionHelper superResolutionHelper, @Nullable final String str, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable IPicLoadStateListener iPicLoadStateListener, @Nullable Function3<? super Boolean, ? super Long, ? super String, Unit> function3) {
        String str2;
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (str == null) {
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            imageView.setImageDrawable(drawable2);
            return;
        }
        imageView.setTag(R.id.xix, str);
        final String str3 = "SuperResolution";
        if (superResolutionHelper != null) {
            str2 = superResolutionHelper.p(str, false);
        } else {
            str2 = null;
        }
        if (str2 != null) {
            QLog.i("SuperResolution", 1, "showImage success from cache:" + str2 + " for url:" + str);
            e(imageView, str2, drawable, drawable2, iPicLoadStateListener);
            if (function3 != null) {
                function3.invoke(Boolean.TRUE, Long.valueOf(SrStatus.Success.getErrorCode()), "");
                return;
            }
            return;
        }
        final WeakReference weakReference = new WeakReference(imageView);
        final WeakReference weakReference2 = new WeakReference(iPicLoadStateListener);
        final WeakReference weakReference3 = new WeakReference(function3);
        final boolean z16 = false;
        g(imageView, str, drawable, drawable2, new IPicLoadStateListener() { // from class: com.tencent.robot.adelie.homepage.utils.l
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                CommonExKt.k(weakReference2, superResolutionHelper, weakReference, str3, str, z16, weakReference3, loadState, option);
            }
        });
    }

    public static /* synthetic */ void j(ImageView imageView, SuperResolutionHelper superResolutionHelper, String str, Drawable drawable, Drawable drawable2, IPicLoadStateListener iPicLoadStateListener, Function3 function3, int i3, Object obj) {
        IPicLoadStateListener iPicLoadStateListener2;
        Function3 function32;
        if ((i3 & 4) != 0) {
            drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        Drawable drawable3 = drawable;
        if ((i3 & 8) != 0) {
            drawable2 = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        Drawable drawable4 = drawable2;
        if ((i3 & 16) != 0) {
            iPicLoadStateListener2 = null;
        } else {
            iPicLoadStateListener2 = iPicLoadStateListener;
        }
        if ((i3 & 32) != 0) {
            function32 = null;
        } else {
            function32 = function3;
        }
        i(imageView, superResolutionHelper, str, drawable3, drawable4, iPicLoadStateListener2, function32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(WeakReference listenerRef, SuperResolutionHelper superResolutionHelper, WeakReference imageViewRef, String logTag, String str, boolean z16, WeakReference superResolutionListenerRef, LoadState loadState, Option option) {
        boolean z17;
        ImageView imageView;
        CoroutineScope f16;
        Intrinsics.checkNotNullParameter(listenerRef, "$listenerRef");
        Intrinsics.checkNotNullParameter(imageViewRef, "$imageViewRef");
        Intrinsics.checkNotNullParameter(logTag, "$logTag");
        Intrinsics.checkNotNullParameter(superResolutionListenerRef, "$superResolutionListenerRef");
        IPicLoadStateListener iPicLoadStateListener = (IPicLoadStateListener) listenerRef.get();
        if (iPicLoadStateListener != null) {
            iPicLoadStateListener.onStateChange(loadState, option);
        }
        if (superResolutionHelper == null) {
            return;
        }
        String localPath = option.getLocalPath();
        if (loadState == LoadState.STATE_SUCCESS) {
            if (localPath != null && localPath.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17 || (imageView = (ImageView) imageViewRef.get()) == null) {
                return;
            }
            Bitmap resultBitMap = option.getResultBitMap();
            String url = option.getUrl();
            boolean areEqual = Intrinsics.areEqual((String) imageView.getTag(R.id.xix), url);
            QLog.i(logTag, 1, "showImage PicLoader finished, optionUrl:" + url + ", urlEqual:" + areEqual + ", localPath:" + localPath);
            if (areEqual && (f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.b.f261780e)) != null) {
                BuildersKt__Builders_commonKt.launch$default(f16, Dispatchers.getIO(), null, new CommonExKt$superResolutionSafely$1$1(superResolutionHelper, str, z16, localPath, resultBitMap, imageViewRef, logTag, url, option, superResolutionListenerRef, null), 2, null);
            }
        }
    }

    public static final int l(int i3, float f16) {
        return Color.argb((int) (255 * f16), Color.red(i3), Color.green(i3), Color.blue(i3));
    }

    @NotNull
    public static final HashMap<String, String> m(@NotNull JSONObject jSONObject) {
        String obj;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            Object opt = jSONObject.opt(key);
            Intrinsics.checkNotNullExpressionValue(key, "key");
            if (opt != null && (obj = opt.toString()) != null) {
                hashMap.put(key, obj);
            }
        }
        return hashMap;
    }
}
