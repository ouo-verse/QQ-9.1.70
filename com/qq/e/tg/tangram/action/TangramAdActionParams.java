package com.qq.e.tg.tangram.action;

import com.qq.e.comm.pi.TangramExposureCallback;
import com.qq.e.tg.cfg.VideoOption;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class TangramAdActionParams {
    public static final int CLICK_ACTION_TYPE_DOWNLOAD_WITHOUT_REPORT = 3;
    public static final int CLICK_ACTION_TYPE_DOWNLOAD_WITH_REPORT = 2;
    public static final int CLICK_ACTION_TYPE_NORMAL = 0;
    public static final int CLICK_ACTION_TYPE_ONLY_REPORT = 1;

    /* renamed from: b, reason: collision with root package name */
    private VideoOption f40863b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<com.qq.e.tg.cfg.VideoResultReceiver> f40864c;

    /* renamed from: j, reason: collision with root package name */
    private int f40871j;

    /* renamed from: a, reason: collision with root package name */
    private int f40862a = -1;

    /* renamed from: d, reason: collision with root package name */
    private boolean f40865d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f40866e = -1;

    /* renamed from: f, reason: collision with root package name */
    private int f40867f = -1;

    /* renamed from: g, reason: collision with root package name */
    private int f40868g = Integer.MIN_VALUE;

    /* renamed from: h, reason: collision with root package name */
    private TangramExposureCallback f40869h = null;

    /* renamed from: i, reason: collision with root package name */
    private boolean f40870i = false;

    public int getActionClickType() {
        return this.f40871j;
    }

    public int getCarouselIndex() {
        return this.f40868g;
    }

    public int getClickPos() {
        return this.f40862a;
    }

    public int getClickViewTag() {
        return this.f40866e;
    }

    public TangramExposureCallback getExposureCallback() {
        return this.f40869h;
    }

    public int getRenderPosition() {
        return this.f40867f;
    }

    public WeakReference<com.qq.e.tg.cfg.VideoResultReceiver> getResultReceiver() {
        return this.f40864c;
    }

    public VideoOption getVideoOption() {
        return this.f40863b;
    }

    public boolean isEnableExposure() {
        return this.f40865d;
    }

    public boolean isMarketAutoDownload() {
        return this.f40870i;
    }

    public void setActionClickType(int i3) {
        this.f40871j = i3;
    }

    public void setCarouselIndex(int i3) {
        this.f40868g = i3;
    }

    public void setClickPos(int i3) {
        this.f40862a = i3;
    }

    public void setClickViewTag(int i3) {
        this.f40866e = i3;
    }

    public void setEnableExposure(boolean z16) {
        this.f40865d = z16;
    }

    public void setExposureCallback(TangramExposureCallback tangramExposureCallback) {
        this.f40869h = tangramExposureCallback;
    }

    public void setMarketAutoDownload(boolean z16) {
        this.f40870i = z16;
    }

    public void setRenderPosition(int i3) {
        this.f40867f = i3;
    }

    public void setResultReceiver(WeakReference<com.qq.e.tg.cfg.VideoResultReceiver> weakReference) {
        this.f40864c = weakReference;
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f40863b = videoOption;
    }
}
