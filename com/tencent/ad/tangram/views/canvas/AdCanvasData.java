package com.tencent.ad.tangram.views.canvas;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentData;
import com.tencent.ad.tangram.views.canvas.components.fixedbutton.AdCanvasFixedButtonComponentData;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasPageData;
import com.tencent.biz.common.util.WebViewConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdCanvasData implements Serializable {
    private static final String TAG = "AdCanvasData";

    /* renamed from: ad, reason: collision with root package name */
    @Nullable
    public Ad f61337ad;
    public String appInfoRightUrl;
    private boolean autodownload;
    public String commonPageId;

    /* renamed from: id, reason: collision with root package name */
    public String f61338id;
    public String name;
    public String pageTitle;
    public String pageType;
    public String pageUrl;
    public List<AdCanvasPageData> pages;
    public String sourceId;
    public long pageId = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    public int basicWidth = Integer.MIN_VALUE;
    public String firstPictureComponentIdWithHotArea = "";
    public boolean hasFixedButtonData = false;
    public boolean hasMultiPictureData = false;

    @NonNull
    public ArrayList<AdCanvasFixedButtonComponentData> fixedButtonComponentDataList = new ArrayList<>();

    @NonNull
    public ArrayList<AdCanvasAppBtnComponentData> appFixedButtonComponentDataList = new ArrayList<>();

    public boolean getAutoDownLoad() {
        if (isValid() && this.autodownload) {
            return true;
        }
        return false;
    }

    @Nullable
    public AdCanvasPageData getPage(int i3) {
        if (isValid() && i3 >= 0 && i3 <= getSize()) {
            return this.pages.get(i3);
        }
        AdLog.e(TAG, "getPage error");
        return null;
    }

    public int getSize() {
        if (isValid()) {
            return this.pages.size();
        }
        return 0;
    }

    public int getSizeOfComponents() {
        int i3;
        if (!isValid()) {
            return 0;
        }
        int i16 = 0;
        for (AdCanvasPageData adCanvasPageData : this.pages) {
            if (adCanvasPageData != null) {
                i3 = adCanvasPageData.getSize();
            } else {
                i3 = 0;
            }
            i16 += i3;
        }
        return i16;
    }

    public int getToLoadIdsize() {
        int i3;
        if (!isValid()) {
            return 0;
        }
        int i16 = 0;
        for (AdCanvasPageData adCanvasPageData : this.pages) {
            if (adCanvasPageData != null) {
                i3 = adCanvasPageData.getToLoadIdSize();
            } else {
                i3 = 0;
            }
            i16 += i3;
        }
        return i16;
    }

    public boolean isPageWithoutButton() {
        if (this.fixedButtonComponentDataList.size() == 0 && this.appFixedButtonComponentDataList.size() == 0) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        if (this.f61337ad != null && this.basicWidth > 0 && this.pages != null) {
            return true;
        }
        return false;
    }

    public void setAutoDownload(boolean z16) {
        this.autodownload = z16;
    }
}
