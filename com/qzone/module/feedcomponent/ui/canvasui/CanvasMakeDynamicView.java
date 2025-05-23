package com.qzone.module.feedcomponent.ui.canvasui;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.adapter.feedcomponent.FakeShuoShuoDataCacheHelper;
import com.qzone.adapter.feedcomponent.h;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.feed.utils.c;
import com.qzone.module.feedcomponent.ui.SmallTailReportUtil;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellAlbumEntrance;
import com.qzone.proxy.feedcomponent.model.e;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.g;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasMakeDynamicView extends MarginCanvasAreaView {
    private static final String TAG = "CanvasMakeDynamicView";
    private static final String buttonDisabledColor = h.c("QZoneSetting", "shareAreaBtnDisabledColor", "#BBBBBB");

    @DittoField
    AsyncCanvasImageArea big_small_tail_icon;

    @DittoField
    DittoAreaGroup big_small_tail_root;

    @DittoField
    RichCanvasTextArea big_small_tail_text;

    @DittoField
    DittoTextArea dynamic_hint;

    @DittoField
    AsyncCanvasImageArea dynamic_img;

    @DittoField
    DittoAreaGroup dynamic_root_container;
    private boolean hasReportExpore;
    private BusinessFeedData mFeedData;

    @DittoField
    DittoButtonArea make_dynamic_button;

    public CanvasMakeDynamicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentAreaForJsonFile("qzone_canvas_ui_make_dynamic.json");
    }

    private void handleBookClick() {
        CellAlbumEntrance cellAlbumEntrance = this.mFeedData.cellAlbumEntrance;
        if (cellAlbumEntrance.isPending) {
            return;
        }
        int i3 = cellAlbumEntrance.button_actiontype;
        if (i3 != 2) {
            if (i3 != 60) {
                return;
            }
            this.onFeedElementClickListener.onClick(this, FeedElement.BOOK, this.feedPosition, null);
        } else {
            g gVar = this.onFeedElementClickListener;
            FeedElement feedElement = FeedElement.URL;
            int i16 = this.feedPosition;
            gVar.onClick(this, feedElement, i16, new e(cellAlbumEntrance.guideUrl, "", i16));
        }
    }

    private void handlePublishQCircle() {
        try {
            String str = this.mFeedData.getFeedCommInfoV2().clientkey;
            FakeShuoShuoDataCacheHelper.a b16 = FakeShuoShuoDataCacheHelper.b(str);
            b.a(TAG, "handlePublishQCircle, clientKey: " + str + ", shuoShuoData: " + b16);
            this.onFeedElementClickListener.onClick(this, FeedElement.PUBLISH_QCIRCLE, this.feedPosition, b16);
            reportQCircleEntranceClick();
        } catch (Exception e16) {
            b.j(TAG, "handlePublishQCircle, error ", e16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    private void initData() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null) {
            return;
        }
        int i3 = businessFeedData.cellAlbumEntrance.iAttr;
        if (i3 == 0 || i3 == 2) {
            this.dynamic_root_container.setBackgroundDrawable(j.w());
        }
        CellAlbumEntrance cellAlbumEntrance = this.mFeedData.cellAlbumEntrance;
        String str = null;
        String str2 = cellAlbumEntrance == null ? null : cellAlbumEntrance.guideIcon;
        if (!TextUtils.isEmpty(str2)) {
            this.dynamic_img.setAsyncImage(null, str2, null, null);
        }
        String str3 = cellAlbumEntrance == null ? null : cellAlbumEntrance.guideTitle;
        if (!TextUtils.isEmpty(str3)) {
            this.dynamic_hint.setText(str3);
        }
        if (cellAlbumEntrance != null) {
            if (cellAlbumEntrance.isPending) {
                str = "\u9884\u7ea6\u4e2d...";
            } else {
                str = cellAlbumEntrance.guideButton;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            this.make_dynamic_button.setVisibility(0);
            this.make_dynamic_button.setText(str);
        } else {
            this.make_dynamic_button.setVisibility(8);
        }
        int o16 = j.o();
        if (cellAlbumEntrance != null && cellAlbumEntrance.iAttr == 1) {
            try {
                if (cellAlbumEntrance.button_actiontype == -1) {
                    ?? parseColor = Color.parseColor(buttonDisabledColor);
                    o16 = parseColor;
                    cellAlbumEntrance = parseColor;
                } else if (TextUtils.isEmpty(cellAlbumEntrance.buttonColor)) {
                    cellAlbumEntrance = cellAlbumEntrance;
                } else {
                    o16 = Color.parseColor(cellAlbumEntrance.buttonColor);
                    cellAlbumEntrance = cellAlbumEntrance;
                }
            } catch (IllegalArgumentException e16) {
                b.d("DYNAMIC ALBUM", "parse color err:" + cellAlbumEntrance.buttonColor, e16);
            }
        }
        this.make_dynamic_button.setTextColor(o16);
    }

    private void reportMakeDynamic() {
        BusinessFeedData businessFeedData;
        if (this.hasReportExpore || (businessFeedData = this.mFeedData) == null || businessFeedData.getFeedCommInfoV2() == null) {
            return;
        }
        if (this.mFeedData.getFeedCommInfoV2().appid == 311) {
            c.b();
            this.hasReportExpore = true;
        } else if (this.mFeedData.getFeedCommInfoV2().appid == 4) {
            c.a();
            this.hasReportExpore = true;
        }
    }

    private void reportQCircleEntranceClick() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null) {
            b.a(TAG, "reportQCircleEntranceClick, mFeedData is null ");
        } else {
            c.f(businessFeedData);
        }
    }

    private void reportQCircleEntranceExpose() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null) {
            b.a(TAG, "reportQCircleEntranceExpose, mFeedData is null ");
        } else {
            if (this.hasReportExpore) {
                return;
            }
            this.hasReportExpore = true;
            c.g(businessFeedData);
        }
    }

    private void reportQCircleEntranceExposeTianshu() {
        if (this.mFeedData == null) {
            b.i(TAG, "reportQCircleEntranceExposeTianshu, mFeedData is null ");
        } else {
            QZLog.i(TAG, 1, "reportQCircleEntranceExposeTianshu ");
            c.h(this.mFeedData);
        }
    }

    private void setBigTailView() {
        int i3 = this.mFeedData.cellAlbumEntrance.iAttr;
        QZLog.i(TAG, 1, "setBigTailView, iAttr: " + i3);
        if (i3 == 0 || i3 == 2) {
            setContentAreaForJsonFile("qzone_canvas_ui_make_dynamic.json");
        } else if (i3 == 1) {
            setContentAreaForJsonFile("qzone_canvas_ui_book_bar.json");
            this.make_dynamic_button.setTextBold(true);
        }
        initData();
        if (i3 == 2) {
            reportQCircleEntranceExpose();
            reportQCircleEntranceExposeTianshu();
        } else {
            reportMakeDynamic();
        }
        DittoTextArea dittoTextArea = this.dynamic_hint;
        if (dittoTextArea instanceof RichCanvasTextArea) {
            ((RichCanvasTextArea) dittoTextArea).setEllipsizeStr(MiniBoxNoticeInfo.APPNAME_SUFFIX);
        }
    }

    private void setSmallTailView() {
        RichCanvasTextArea richCanvasTextArea;
        AsyncCanvasImageArea asyncCanvasImageArea;
        DittoAreaGroup dittoAreaGroup;
        setContentAreaForJsonFile("qzone_canvas_ui_big_small_tail.json");
        CellAlbumEntrance cellAlbumEntrance = this.mFeedData.cellAlbumEntrance;
        if (cellAlbumEntrance != null && cellAlbumEntrance.iAttr == 0 && (dittoAreaGroup = this.big_small_tail_root) != null) {
            dittoAreaGroup.setBackgroundDrawable(j.w());
        }
        DittoAreaGroup dittoAreaGroup2 = this.big_small_tail_root;
        if (dittoAreaGroup2 != null) {
            dittoAreaGroup2.setMargin(com.qzone.proxy.feedcomponent.util.g.a(8.0f), com.qzone.proxy.feedcomponent.util.g.a(5.0f), com.qzone.proxy.feedcomponent.util.g.a(8.0f), 0);
        }
        CellAlbumEntrance cellAlbumEntrance2 = this.mFeedData.cellAlbumEntrance;
        String str = cellAlbumEntrance2 == null ? null : cellAlbumEntrance2.guideIcon;
        if (!TextUtils.isEmpty(str) && (asyncCanvasImageArea = this.big_small_tail_icon) != null) {
            asyncCanvasImageArea.setAsyncImage(null, str, null, null);
            this.big_small_tail_icon.setMargin(0, com.qzone.proxy.feedcomponent.util.g.a(2.5f), com.qzone.proxy.feedcomponent.util.g.a(4.0f), 0);
        }
        CellAlbumEntrance cellAlbumEntrance3 = this.mFeedData.cellAlbumEntrance;
        String str2 = cellAlbumEntrance3 != null ? cellAlbumEntrance3.guideTitle : null;
        if (TextUtils.isEmpty(str2) || (richCanvasTextArea = this.big_small_tail_text) == null) {
            return;
        }
        richCanvasTextArea.setText(str2);
        SmallTailReportUtil.reportBigSmallTailExpose();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"make_dynamic_button", "big_small_tail_root"})
    public void onJump(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        int i3 = this.mFeedData.cellAlbumEntrance.iAttr;
        if (i3 == 0) {
            this.onFeedElementClickListener.onClick(this, FeedElement.MAKE_DYNAMIC, this.feedPosition, null);
        } else if (i3 == 1) {
            handleBookClick();
        } else if (i3 == 2) {
            handlePublishQCircle();
        }
        SmallTailReportUtil.reportBigSmallTailClick(dittoArea);
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void setAlpha(int i3) {
        super.setAlpha(i3);
        DittoAreaGroup dittoAreaGroup = this.dynamic_root_container;
        if (dittoAreaGroup != null) {
            dittoAreaGroup.setAlpha(i3);
        }
        DittoAreaGroup dittoAreaGroup2 = this.big_small_tail_root;
        if (dittoAreaGroup2 != null) {
            dittoAreaGroup2.setAlpha(i3);
        }
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
        if (businessFeedData == null || businessFeedData.cellAlbumEntrance == null) {
            return;
        }
        setBigTailView();
    }
}
