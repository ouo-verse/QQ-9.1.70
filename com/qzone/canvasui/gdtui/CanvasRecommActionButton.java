package com.qzone.canvasui.gdtui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract;
import com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyPresenter;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.FeedTextAreaEx;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasRecommActionButton extends RichCanvasTextArea implements DownloadImmediatelyContract.View, IGdtCanvasUi {
    private BusinessFeedData businessFeedData;
    private int mProgressColor;
    private int mProgressPadding;
    private RectF percentRect;
    private DownloadImmediatelyContract.Presenter presenter;
    private Paint processPaint;

    public CanvasRecommActionButton(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.mProgressPadding = AreaConst.f48746dp1;
        this.percentRect = new RectF();
        this.mProgressColor = 65535;
        this.processPaint = new Paint(this.mProgressColor);
        new DownloadImmediatelyPresenter(this);
    }

    public void clearAreaCache() {
        synchronized (DittoArea.mAreaCache) {
            Integer num = this.mAreaCacheKey;
            if (num != null) {
                DittoArea.mAreaCache.remove(num);
            }
        }
    }

    @Override // com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract.View
    public DownloadImmediatelyContract.Presenter getPresenter() {
        return this.presenter;
    }

    public String getShowText(BusinessFeedData businessFeedData) {
        String str;
        String str2;
        String str3;
        String str4 = "";
        if (businessFeedData == null || businessFeedData.getRecommAction() == null) {
            return "";
        }
        HashSet<String> q06 = i.H().q0();
        if (TextUtils.isEmpty(businessFeedData.getRecommAction().buttonText)) {
            str = "";
        } else {
            str = businessFeedData.getRecommAction().buttonText;
        }
        if (businessFeedData.getRecommAction().extendInfo != null) {
            if (!businessFeedData.getRecommAction().extendInfo.containsKey(15) || !businessFeedData.getRecommAction().extendInfo.containsKey(14) || !businessFeedData.getRecommAction().extendInfo.containsKey(13)) {
                str2 = "";
                str3 = str2;
            } else {
                String str5 = businessFeedData.getRecommAction().extendInfo.get(13);
                str3 = businessFeedData.getRecommAction().extendInfo.get(14);
                str4 = businessFeedData.getRecommAction().extendInfo.get(15);
                str2 = str5;
            }
            if (!TextUtils.isEmpty(str4) && !"0".equals(str4)) {
                if ((q06 != null && q06.contains(str4)) || (!TextUtils.isEmpty(str3) && "true".equals(str3))) {
                    str = str2;
                }
            }
        }
        if (b.g()) {
            b.e("CanvasRecommActionButton", "@orderAdv text" + str);
        }
        return str;
    }

    @Override // com.qzone.canvasui.widget.RichCanvasTextArea, com.tencent.ditto.widget.DittoTextArea, com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        if (getTextArea() != null && getTextArea().getTextLayout() != null) {
            getTextArea().getTextLayout().setDrawBackground(false);
        }
        if (this.presenter.needDrawProgress()) {
            canvas.save();
            RectF rectF = this.percentRect;
            int i3 = this.mProgressPadding;
            rectF.set(i3, i3, (int) ((((getWidth() - (this.mProgressPadding * 2)) * this.presenter.getDownProgress()) / 100.0f) + this.mProgressPadding), getHeight() - this.mProgressPadding);
            canvas.drawRect(this.percentRect, this.processPaint);
            canvas.restore();
        }
        canvas.translate(-getPaddingLeft(), -getPaddingTop());
        FeedTextAreaEx feedTextAreaEx = this.mTextArea;
        if (feedTextAreaEx != null) {
            if (feedTextAreaEx.getTextLayout() != null) {
                this.mTextArea.getTextLayout().setPadding((getMeasuredWidth() - this.mTextArea.getMeasuredWidth()) / 2, (getMeasuredHeight() - this.mTextArea.getMeasuredHeight()) / 2, (getMeasuredWidth() - this.mTextArea.getMeasuredWidth()) / 2, (getMeasuredHeight() - this.mTextArea.getMeasuredHeight()) / 2);
            }
            this.mTextArea.draw(canvas, null);
        }
    }

    @Override // com.qzone.canvasui.widget.RichCanvasTextArea, com.tencent.ditto.widget.DittoTextArea, com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        obtainText();
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        this.mTextArea.getTextLayout().setPadding(0, 0, 0, 0);
        this.mTextArea.measure(i3, i16);
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(this.mTextArea.getMeasuredWidth(), size) : 0;
        }
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(this.mTextArea.getMeasuredHeight(), size2) : 0;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract.View
    public void refreshView() {
        invalidate();
    }

    @Override // com.qzone.canvasui.widget.RichCanvasTextArea, com.qzone.canvasui.gdtui.IGdtCanvasUi
    public void reset() {
        DownloadImmediatelyContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            presenter.reset();
        }
        this.businessFeedData = null;
        setVisibility(8);
    }

    @Override // com.qzone.canvasui.gdtui.IGdtCanvasUi
    public void setFeedData(BusinessFeedData businessFeedData) {
        this.businessFeedData = businessFeedData;
    }

    @Override // com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract.View
    public void setPresenter(DownloadImmediatelyContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override // com.qzone.canvasui.widget.RichCanvasTextArea, com.tencent.ditto.widget.DittoTextArea
    public void setText(final String str) {
        this.mMainHandler.post(new Runnable() { // from class: com.qzone.canvasui.gdtui.CanvasRecommActionButton.1
            @Override // java.lang.Runnable
            public void run() {
                CanvasRecommActionButton.this.clearAreaCache();
                CanvasRecommActionButton.super.setText(str);
            }
        });
    }

    @Override // com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract.View
    public void setViewText(String str) {
        setText(str);
    }

    @Override // com.qzone.canvasui.gdtui.IGdtCanvasUi
    public void update() {
        int i3;
        BusinessFeedData businessFeedData = this.businessFeedData;
        if (businessFeedData == null || businessFeedData.getRecommAction() == null) {
            return;
        }
        if (this.businessFeedData.getRecommAction().actionType == 20) {
            i3 = this.businessFeedData.getOperationInfo().actionType;
        } else {
            i3 = this.businessFeedData.getRecommAction().actionType;
        }
        setVisibility(0);
        if (i3 == 21) {
            if (this.businessFeedData.getFeedCommInfo().isFollowed) {
                setText("\u5df2\u5173\u6ce8");
                return;
            } else {
                setText("\u5173\u6ce8");
                return;
            }
        }
        if (this.businessFeedData.isAppAd()) {
            this.presenter.setupText(this.businessFeedData.getRecommAction().installed_buttontxt, this.businessFeedData.getRecommAction().buttonText);
            if (FeedGlobalEnv.g().checkHasInstallPackage(getContext(), this.businessFeedData.getOperationInfo().appid)) {
                this.presenter.updateDownloadStatus(5, 100);
                return;
            } else {
                this.presenter.updateDownloadStatus(0, 0);
                return;
            }
        }
        String showText = getShowText(this.businessFeedData);
        if (!TextUtils.isEmpty(showText)) {
            setText(showText);
        } else if (this.businessFeedData.isAppAd()) {
            setText("\u53bb\u4e0b\u8f7d");
        } else {
            setText("\u53bb\u770b\u770b");
        }
    }
}
