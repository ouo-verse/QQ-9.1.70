package com.qzone.reborn.layer.item.presenter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.widgets.multitouchimg.PhotoViewAttacher;
import com.tencent.biz.qqcircle.widgets.multitouchimg.o;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.libra.LoadState;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.LibraDownloadKey;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicLoadState;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.LoadingUtil;
import java.util.List;

/* loaded from: classes37.dex */
public class RFWLayerLongPicControlSection extends Section<RFWLayerItemMediaInfo> implements o {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f57764d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f57765e;

    /* renamed from: f, reason: collision with root package name */
    private PhotoViewAttacher f57766f;

    private void showLoadingView(final boolean z16) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.layer.item.presenter.RFWLayerLongPicControlSection.1
            @Override // java.lang.Runnable
            public void run() {
                if (!z16) {
                    RFWLayerLongPicControlSection.this.f57765e.setVisibility(8);
                    return;
                }
                if (RFWLayerLongPicControlSection.this.f57765e.getDrawable() == null) {
                    RFWLayerLongPicControlSection.this.f57765e.setImageDrawable(LoadingUtil.getLoadingDrawable(RFWLayerLongPicControlSection.this.f57765e.getContext(), 1));
                }
                RFWLayerLongPicControlSection.this.f57765e.setVisibility(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(Option option, RFWLayerItemMediaInfo rFWLayerItemMediaInfo, LoadState loadState, Option option2) {
        if (loadState.isFinish()) {
            showLoadingView(false);
        }
        if (loadState.isFinishSuccess()) {
            u(option.getResultBitMap(), rFWLayerItemMediaInfo);
        }
        if (TextUtils.isEmpty(rFWLayerItemMediaInfo.getLayerPicInfo().getPicId())) {
            return;
        }
        RFWLayerDataCenter.INSTANCE.initOrUpdateGlobalState((RFWLayerDataCenter) new RFWLayerPicLoadState(rFWLayerItemMediaInfo.getLayerPicInfo().getPicId(), rFWLayerItemMediaInfo.getLayerPicInfo().getCurrentPicInfo(), loadState), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ void onBindData(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, int i3, List list) {
        onBindData2(rFWLayerItemMediaInfo, i3, (List<Object>) list);
    }

    @Override // com.tencent.biz.qqcircle.widgets.multitouchimg.o
    public void onViewTap(View view, float f16, float f17) {
        if (view.getContext() instanceof Activity) {
            ((Activity) view.getContext()).onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* renamed from: onBindData, reason: avoid collision after fix types in other method */
    protected void onBindData2(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, int i3, List<Object> list) {
        if (rFWLayerItemMediaInfo != null && rFWLayerItemMediaInfo.getLayerPicInfo() != null) {
            if (existFile(rFWLayerItemMediaInfo.getLayerPicInfo().getCurrentPicInfo())) {
                RFWLog.i("RFWLayerPicControlSection", RFWLog.USR, "current url:" + rFWLayerItemMediaInfo.getLayerPicInfo().getCurrentPicInfo().getLocalPath() + " hash:" + hashCode());
                loadCurrentPic(rFWLayerItemMediaInfo);
                return;
            }
            showLoadingView(true);
            if (!existFile(rFWLayerItemMediaInfo.getLayerPicInfo().getSmallPicInfo())) {
                this.f57764d.setImageDrawable(null);
            }
            loadCurrentPic(rFWLayerItemMediaInfo);
            return;
        }
        RFWLog.e("RFWLayerPicControlSection", RFWLog.USR, "currentPicInfo is empty");
    }

    private boolean existFile(RFWLayerPicInfo.RFWPicInfo rFWPicInfo) {
        return rFWPicInfo != null && RFWFileUtils.fileExists(rFWPicInfo.getLocalPath());
    }

    private void loadCurrentPic(final RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
        if (rFWLayerItemMediaInfo == null || rFWLayerItemMediaInfo.getLayerPicInfo() == null || rFWLayerItemMediaInfo.getLayerPicInfo().getCurrentPicInfo() == null) {
            return;
        }
        final Option requestWidth = Option.obtain().setUrl(rFWLayerItemMediaInfo.getLayerPicInfo().getCurrentPicInfo().getUrl()).setLocalPath(rFWLayerItemMediaInfo.getLayerPicInfo().getCurrentPicInfo().getLocalPath()).setNeedShowLoadingDrawable(false).setTargetView(this.f57764d).setNeedShowLoadingDrawable(false).setRequestWidth(ImmersiveUtils.getScreenWidth());
        if (rFWLayerItemMediaInfo.getLayerPicInfo().getCurrentPicInfo().getWidth() > 0 && rFWLayerItemMediaInfo.getLayerPicInfo().getCurrentPicInfo().getHeight() > 0) {
            requestWidth.setRequestHeight((int) s(rFWLayerItemMediaInfo));
        }
        RFWLayerPicInfo.RFWPicInfo smallPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo().getSmallPicInfo();
        if (smallPicInfo != null && smallPicInfo != rFWLayerItemMediaInfo.getLayerPicInfo().getCurrentPicInfo()) {
            Option needShowFailedDrawable = Option.obtain().setUrl(smallPicInfo.getUrl()).setLocalPath(smallPicInfo.getLocalPath()).setNeedShowLoadingDrawable(false).setNeedShowFailedDrawable(false);
            if (smallPicInfo == rFWLayerItemMediaInfo.getLayerPicInfo().getSmallPicInfo()) {
                needShowFailedDrawable.setCacheKey(new LibraRequestKey.Builder(new LibraDownloadKey(smallPicInfo.getLocalPath())).build());
            }
            requestWidth.setThumbnailOption(needShowFailedDrawable);
        }
        c.a().i(requestWidth, new IPicLoadStateListener() { // from class: com.qzone.reborn.layer.item.presenter.a
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                RFWLayerLongPicControlSection.this.t(requestWidth, rFWLayerItemMediaInfo, loadState, option);
            }
        });
    }

    public static float s(RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
        if (rFWLayerItemMediaInfo == null || rFWLayerItemMediaInfo.getLayerPicInfo() == null) {
            return 0.0f;
        }
        int width = rFWLayerItemMediaInfo.getLayerPicInfo().getCurrentPicInfo().getWidth();
        int height = rFWLayerItemMediaInfo.getLayerPicInfo().getCurrentPicInfo().getHeight();
        if (width != 0 && height != 0) {
            return (height / width) * ImmersiveUtils.getScreenWidth();
        }
        return ImmersiveUtils.getScreenHeight();
    }

    private void u(Bitmap bitmap, RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
        if (bitmap == null) {
            return;
        }
        this.f57764d.setImageBitmap(bitmap);
        ViewGroup.LayoutParams layoutParams = this.f57764d.getLayoutParams();
        layoutParams.width = ImmersiveUtils.getScreenWidth();
        layoutParams.height = (int) r(bitmap);
        this.f57764d.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        this.f57764d = (ImageView) view.findViewById(R.id.nee);
        this.f57765e = (ImageView) view.findViewById(R.id.nef);
        this.f57764d.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f57765e.setVisibility(8);
        PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(this.f57764d);
        this.f57766f = photoViewAttacher;
        photoViewAttacher.l0(this);
    }

    public static float r(Bitmap bitmap) {
        if (bitmap == null) {
            return 0.0f;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width != 0 && height != 0) {
            return (height / width) * ImmersiveUtils.getScreenWidth();
        }
        return ImmersiveUtils.getScreenHeight();
    }
}
