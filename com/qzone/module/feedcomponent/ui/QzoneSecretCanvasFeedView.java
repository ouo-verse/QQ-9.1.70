package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.core.app.NotificationCompat;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellAttitude;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneSecretCanvasFeedView extends QzoneCanvasAreaView {
    private static final String URL_DISSED = "https://qzonestyle.gtimg.cn/aoi/sola/20190117200818_GuWVgT2YR3.png";
    private static final String URL_PRAISED = "https://qzonestyle.gtimg.cn/aoi/sola/20190117200818_Zae7aKrMAu.png";
    private static BitmapDrawable bgGradient;
    private static int mGradientBackgroundColor;

    @DittoField
    RichCanvasTextArea additional_infos;

    @DittoField
    DittoArea audio_container;

    @DittoField
    DittoTextArea audio_length;
    private Drawable dissDrawable;

    @DittoField
    AsyncCanvasImageArea down_button;

    @DittoField
    DittoTextArea friend_relationship;

    @DittoField
    AsyncCanvasImageArea image;
    private BusinessFeedData mFeedData;

    @DittoField
    DittoArea operation_divider;
    private Drawable praiseDrawable;

    @DittoField
    RichCanvasTextArea praise_count;

    @DittoField
    DittoImageArea right_planet;

    @DittoField
    DittoArea root_container;

    @DittoField
    RichCanvasTextArea secret_content;

    @DittoField
    DittoArea title_container;

    @DittoField
    AsyncCanvasImageArea up_button;
    private static int GRADIENT_WIDTH = ViewUtils.getScreenWidth() - AreaConst.dp24;
    private static final int GRADIENT_HEIGHT = AreaConst.dp96;

    public QzoneSecretCanvasFeedView(Context context) {
        super(context);
        this.praiseDrawable = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/secret/praise.zip", 20);
        this.dissDrawable = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/secret/diss.zip", 20);
        initUI();
    }

    private BitmapDrawable getBg() {
        if (bgGradient != null && mGradientBackgroundColor == com.qzone.adapter.feedcomponent.j.m()) {
            return bgGradient;
        }
        mGradientBackgroundColor = com.qzone.adapter.feedcomponent.j.m();
        int i3 = GRADIENT_WIDTH;
        int i16 = GRADIENT_HEIGHT;
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        int parseColor = Color.parseColor("#4BB9ACF7");
        int i17 = mGradientBackgroundColor;
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setShader(new LinearGradient(0.0f, 0.0f, GRADIENT_WIDTH, 0.0f, parseColor, i17, Shader.TileMode.CLAMP));
        canvas.drawPaint(paint);
        int parseColor2 = Color.parseColor("#00000000");
        int parseColor3 = Color.parseColor("#FF000000");
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        paint.setShader(new LinearGradient(0.0f, i16, 0.0f, 0.0f, parseColor2, parseColor3, Shader.TileMode.CLAMP));
        canvas.drawPaint(paint);
        Bitmap createBitmap2 = Bitmap.createBitmap(GRADIENT_WIDTH, i16, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap2);
        Paint paint2 = new Paint();
        paint2.setColor(mGradientBackgroundColor);
        paint2.setStyle(Paint.Style.FILL);
        canvas2.drawRect(0.0f, 0.0f, GRADIENT_WIDTH, i16, paint2);
        canvas2.drawBitmap(createBitmap, 0.0f, 0.0f, paint2);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap2);
        bgGradient = bitmapDrawable;
        return bitmapDrawable;
    }

    private void initUI() {
        GRADIENT_WIDTH = ViewUtils.getScreenWidth() - AreaConst.dp24;
        setContentAreaForJsonFile("qzone_canvas_ui_feed_secret_view.json");
        this.image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setPreloadNum(this.praiseDrawable, 5);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setPreloadNum(this.dissDrawable, 5);
        this.praiseDrawable.setCallback(this);
        this.dissDrawable.setCallback(this);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(this.praiseDrawable, true);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(this.dissDrawable, true);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(this.praiseDrawable, 1.0f);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(this.dissDrawable, 1.0f);
        this.secret_content.setEllipsisStr("... \u5168\u6587", DownloadCardView.COLOR_APP_VERSION, DittoUIEngine.g().getDensity() * 16.0f);
    }

    private void updateAdditionalInfo() {
        String str;
        int i3 = (this.mFeedData.getCommentInfoV2() == null || this.mFeedData.getCommentInfoV2().commentNum == 0) ? 0 : this.mFeedData.getCommentInfoV2().commentNum;
        int i16 = this.mFeedData.getAttitude().num;
        int i17 = this.mFeedData.getVisitorInfo() != null ? this.mFeedData.getVisitorInfo().viewCount : 0;
        ArrayList arrayList = new ArrayList(3);
        if (i17 != 0) {
            arrayList.add(getCountStr(i17) + " \u6d4f\u89c8");
        }
        String str2 = "";
        if (i16 != -1) {
            StringBuilder sb5 = new StringBuilder();
            if (i16 == 0) {
                str = "";
            } else {
                str = getCountStr(i16) + " ";
            }
            sb5.append(str);
            sb5.append("\u8868\u6001");
            arrayList.add(sb5.toString());
        }
        if (i3 != -1) {
            StringBuilder sb6 = new StringBuilder();
            if (i3 != 0) {
                str2 = getCountStr(i3) + " ";
            }
            sb6.append(str2);
            sb6.append("\u8bc4\u8bba");
            arrayList.add(sb6.toString());
        }
        this.additional_infos.setText(TextUtils.join(" \u00b7 ", arrayList));
    }

    private void updatePraiseCount() {
        if (this.mFeedData.getLikeInfoV2() != null && this.mFeedData.getLikeInfoV2().likeNum != 0) {
            this.praise_count.setVisibility(0);
            this.praise_count.setText(getCountStr(this.mFeedData.getLikeInfoV2().likeNum));
            if (this.mFeedData.getLikeInfoV2().isLiked) {
                this.praise_count.setTextColor(-19392);
                return;
            } else {
                this.praise_count.setTextColor(com.qzone.adapter.feedcomponent.j.F());
                return;
            }
        }
        this.praise_count.setVisibility(8);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"down_container"})
    public void onDissClicked(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        if (!this.mFeedData.getDissInfo().dissed && (!(obj instanceof Boolean) || !((Boolean) obj).booleanValue())) {
            this.dissDrawable.setCallback(this);
            this.down_button.setImageDrawable(this.dissDrawable);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).restartAnimation(this.dissDrawable);
            onPraiseClicked(dittoArea, motionEvent, Boolean.TRUE);
            this.mFeedData.getAttitude().num++;
            com.qzone.adapter.feedcomponent.i.H().f(302, 97, 0);
        } else {
            this.down_button.clearDrawable();
            this.down_button.setImageResource(com.qzone.adapter.feedcomponent.j.h(852));
            if (this.mFeedData.getDissInfo().dissed) {
                CellAttitude attitude = this.mFeedData.getAttitude();
                attitude.num--;
            }
            if (obj == null) {
                com.qzone.adapter.feedcomponent.i.H().f(302, 99, 0);
            }
        }
        this.onFeedElementClickListener.onClick(this, FeedElement.SECRET_DISS, getFeedPosition(), obj != null ? Boolean.FALSE : null);
        updateAdditionalInfo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.tencent.ditto.DittoAreaView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ditto.DittoAreaView, android.view.View
    public void onMeasure(int i3, int i16) {
        try {
            super.onMeasure(i3, i16);
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.b.d(NotificationCompat.CATEGORY_ERROR, "", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"up_container"})
    public void onPraiseClicked(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        if (!this.mFeedData.getLikeInfo().isLiked && (!(obj instanceof Boolean) || !((Boolean) obj).booleanValue())) {
            this.praiseDrawable.setCallback(this);
            this.up_button.setImageDrawable(this.praiseDrawable);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).restartAnimation(this.praiseDrawable);
            onDissClicked(this.down_button, motionEvent, Boolean.TRUE);
            this.mFeedData.getAttitude().num++;
            com.qzone.adapter.feedcomponent.i.H().f(302, 96, 0);
        } else {
            this.up_button.clearDrawable();
            this.up_button.setImageResource(com.qzone.adapter.feedcomponent.j.h(QCircleReportHelper.SCENE_PAGE_ID_NEW_POLYMERIZE_DETAIL_QZONE_PAGE));
            if (this.mFeedData.getLikeInfo().isLiked) {
                CellAttitude attitude = this.mFeedData.getAttitude();
                attitude.num--;
            }
            if (obj == null) {
                com.qzone.adapter.feedcomponent.i.H().f(302, 98, 0);
            }
        }
        this.onFeedElementClickListener.onClick((View) getParent().getParent().getParent(), FeedElement.SECRET_LIKE, getFeedPosition(), obj != null ? Boolean.FALSE : null);
        updatePraiseCount();
        updateAdditionalInfo();
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        String str;
        this.mFeedData = businessFeedData;
        DittoArea dittoArea = this.root_container;
        int i3 = AreaConst.dp5;
        int i16 = AreaConst.f48749dp4;
        dittoArea.setShadowSize(i3, i16, AreaConst.dp6, i16);
        this.root_container.setShadowDrawable(com.qzone.adapter.feedcomponent.j.G());
        this.title_container.setBackgroundDrawable(getBg());
        this.right_planet.setImageDrawable(com.qzone.adapter.feedcomponent.j.g(850));
        this.up_button.setImageResource(com.qzone.adapter.feedcomponent.j.h(QCircleReportHelper.SCENE_PAGE_ID_NEW_POLYMERIZE_DETAIL_QZONE_PAGE));
        this.down_button.setImageResource(com.qzone.adapter.feedcomponent.j.h(852));
        String str2 = "";
        if (businessFeedData.getCellSummaryV2() == null) {
            str = "";
        } else {
            str = businessFeedData.getCellSummaryV2().summary;
        }
        this.secret_content.setText(str);
        updateAdditionalInfo();
        if (businessFeedData.getTitleInfoV2() != null) {
            str2 = businessFeedData.getTitleInfoV2().relation_type;
        }
        DittoTextArea dittoTextArea = this.friend_relationship;
        if (TextUtils.isEmpty(str2)) {
            str2 = "\u670b\u53cb";
        }
        dittoTextArea.setText(str2);
        if (businessFeedData.getPictureInfo() != null && businessFeedData.getPictureInfo().pics != null && businessFeedData.getPictureInfo().pics.size() != 0) {
            this.image.setVisibility(0);
            AsyncCanvasImageArea asyncCanvasImageArea = this.image;
            String str3 = businessFeedData.getPictureInfo().pics.get(0).getCurrentUrl().url;
            int i17 = AreaConst.dp80;
            asyncCanvasImageArea.setAsyncImage(null, str3, null, null, i17, i17);
        } else {
            this.image.setVisibility(8);
            this.image.setAsyncImage(null, null, null, null);
        }
        if (businessFeedData.getAudioInfo() != null && businessFeedData.getAudioInfo().size() != 0) {
            this.audio_container.setVisibility(0);
            this.audio_length.setText(businessFeedData.getAudioInfo().get(0).audioTime + "\u201d");
        } else {
            this.audio_container.setVisibility(8);
        }
        Iterator<Integer> it = businessFeedData.getSecretFeedLpReserves().iterator();
        while (it.hasNext()) {
            com.qzone.adapter.feedcomponent.i.H().f(302, 89, it.next().intValue());
        }
        if (businessFeedData.getFeedCommInfo().showDiss()) {
            this.operation_divider.setVisibility(0);
            this.down_button.setVisibility(0);
            if (businessFeedData.getDissInfoV2() == null) {
                this.down_button.clearDrawable();
                this.down_button.setImageResource(com.qzone.adapter.feedcomponent.j.h(852));
            } else if (businessFeedData.getDissInfoV2().dissed) {
                this.up_button.setAsyncImage(null, URL_PRAISED, null, null);
            } else {
                this.up_button.clearDrawable();
                this.up_button.setImageResource(com.qzone.adapter.feedcomponent.j.h(852));
            }
        } else {
            this.operation_divider.setVisibility(8);
            this.down_button.setVisibility(8);
        }
        if (businessFeedData.getLikeInfoV2() == null) {
            this.up_button.clearDrawable();
            this.up_button.setImageResource(com.qzone.adapter.feedcomponent.j.h(QCircleReportHelper.SCENE_PAGE_ID_NEW_POLYMERIZE_DETAIL_QZONE_PAGE));
        } else if (businessFeedData.getLikeInfoV2().isLiked) {
            this.up_button.setAsyncImage(null, URL_PRAISED, null, null);
        } else {
            this.up_button.clearDrawable();
            this.up_button.setImageResource(com.qzone.adapter.feedcomponent.j.h(QCircleReportHelper.SCENE_PAGE_ID_NEW_POLYMERIZE_DETAIL_QZONE_PAGE));
        }
        updatePraiseCount();
    }

    public QzoneSecretCanvasFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.praiseDrawable = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/secret/praise.zip", 20);
        this.dissDrawable = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/secret/diss.zip", 20);
        initUI();
    }

    private static String getCountStr(int i3) {
        if (i3 > 100000000) {
            return (i3 / 100000000) + "\u4ebf";
        }
        if (i3 > 10000000) {
            return (i3 / 10000000) + "\u5343\u4e07";
        }
        if (i3 > 1000000) {
            return (i3 / 1000000) + "\u767e\u4e07";
        }
        if (i3 > 100000) {
            return (i3 / 10000) + "w";
        }
        if (i3 > 10000) {
            return (Math.round(i3 / 1000) / 10.0d) + "w";
        }
        return "" + i3;
    }
}
