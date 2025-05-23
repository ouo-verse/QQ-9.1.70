package com.qq.e.tg.splash.adapter;

import android.view.View;
import com.qq.e.comm.util.GDTLogger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class TGSplashInterPage {

    /* renamed from: a, reason: collision with root package name */
    private static volatile TGSplashInterPage f40829a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<TGSplashInterPageAdapter> f40830b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<ViewClickListener> f40831c;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface CallbackCode {
        public static final int CLICK = 1;
        public static final int SHOWN = 0;
        public static final int SKIP = 2;
        public static final int UNKNOWN = -1;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PageType {
        public static final int OLYMPIC_PAGE = 1;
        public static final int UNKNOWN = 0;
    }

    /* loaded from: classes3.dex */
    public interface ViewClickListener {
        void onClose(int i3);
    }

    TGSplashInterPage() {
    }

    public static TGSplashInterPage getInstance() {
        if (f40829a == null) {
            synchronized (TGSplashInterPage.class) {
                if (f40829a == null) {
                    f40829a = new TGSplashInterPage();
                }
            }
        }
        return f40829a;
    }

    public final void callBackClose(int i3) {
        ViewClickListener viewClickListener;
        WeakReference<ViewClickListener> weakReference = this.f40831c;
        if (weakReference != null) {
            viewClickListener = weakReference.get();
        } else {
            viewClickListener = null;
        }
        if (viewClickListener == null) {
            GDTLogger.e("TGSplashInterPage,[callBackClose] listener is null");
        } else {
            viewClickListener.onClose(i3);
        }
    }

    public final void setAdapter(WeakReference<TGSplashInterPageAdapter> weakReference) {
        this.f40830b = weakReference;
    }

    public final void setClickListener(WeakReference<ViewClickListener> weakReference) {
        this.f40831c = weakReference;
    }

    public final void startOlympicPage(View view) {
        TGSplashInterPageAdapter tGSplashInterPageAdapter;
        WeakReference<TGSplashInterPageAdapter> weakReference = this.f40830b;
        if (weakReference != null) {
            tGSplashInterPageAdapter = weakReference.get();
        } else {
            tGSplashInterPageAdapter = null;
        }
        if (tGSplashInterPageAdapter == null) {
            GDTLogger.e("TGSplashInterPage,[startOlympicPage]");
        } else {
            tGSplashInterPageAdapter.startOlympicPage(view);
        }
    }
}
