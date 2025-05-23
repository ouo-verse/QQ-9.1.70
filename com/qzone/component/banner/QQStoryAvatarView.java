package com.qzone.component.banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.processor.OvalProcessor;
import com.tencent.mobileqq.R;
import cooperation.qzone.util.QZLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QQStoryAvatarView extends View {
    private static String F = "QQStoryAvatarView";
    private static final int G = ar.d(62.0f);
    private static final int H = ar.d(62.0f);
    private static final int I = ar.d(31.0f);
    private static final int J = ar.d(31.0f);
    private static final int K = ar.d(52.0f);
    private static final int L = ar.d(11.0f);
    private static final int M = ar.d(26.5f);
    private static final int N = ar.d(29.0f);
    private static final int P = ar.d(10.0f);
    private static final int Q = ar.d(2.0f);
    private static final int R = ar.d(2.5f);
    private static final int S = ar.d(1.0f);
    private static final int T = ar.d(13.0f);
    Drawable C;
    Paint D;
    private ImageLoader.ImageLoadListener E;

    /* renamed from: d, reason: collision with root package name */
    private String f46460d;

    /* renamed from: e, reason: collision with root package name */
    private int f46461e;

    /* renamed from: f, reason: collision with root package name */
    private String f46462f;

    /* renamed from: h, reason: collision with root package name */
    private BusinessFeedData f46463h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f46464i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f46465m;

    public QQStoryAvatarView(Context context) {
        super(context);
        this.D = new Paint();
        this.E = new ImageLoader.ImageLoadListener() { // from class: com.qzone.component.banner.QQStoryAvatarView.1
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
                QZLog.d(QQStoryAvatarView.F, 2, "use async drawable :" + drawable + ",avatarUrl:" + QQStoryAvatarView.this.f46460d + "\uff0curl:" + str);
                if (TextUtils.isEmpty(str) || !str.equals(QQStoryAvatarView.this.f46460d)) {
                    return;
                }
                QQStoryAvatarView.this.post(new Runnable() { // from class: com.qzone.component.banner.QQStoryAvatarView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Drawable drawable2 = drawable;
                        if (drawable2 != null) {
                            QQStoryAvatarView qQStoryAvatarView = QQStoryAvatarView.this;
                            qQStoryAvatarView.C = drawable2;
                            qQStoryAvatarView.invalidate();
                        }
                    }
                });
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str, float f16, ImageLoader.Options options) {
            }
        };
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.D.setAntiAlias(true);
        if (this.f46463h == null) {
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            int i3 = I;
            int i16 = M;
            int i17 = J;
            drawable.setBounds(i3 - i16, i17 - i16, i3 + i16, i17 + i16);
            this.C.draw(canvas);
        }
        if (this.f46464i) {
            return;
        }
        this.D.setColor(getResources().getColor(R.color.qzone_skin_feed_background_color));
        this.D.setStyle(Paint.Style.STROKE);
        this.D.setStrokeWidth(R);
        int i18 = I;
        int i19 = J;
        canvas.drawCircle(i18, i19, M, this.D);
        this.D.setColor(getResources().getColor(R.color.qzone_skin_feed_qq_story_banner_item_decoration_color));
        this.D.setStrokeWidth(Q);
        canvas.drawCircle(i18, i19, N, this.D);
        if (this.f46461e == 0 || !this.f46465m) {
            return;
        }
        this.D.setColor(getResources().getColor(R.color.qzone_skin_feed_qq_story_banner_item_decoration_color));
        this.D.setStyle(Paint.Style.FILL);
        int i26 = K;
        int i27 = L;
        canvas.drawCircle(i26, i27, P, this.D);
        this.D.setStyle(Paint.Style.FILL);
        this.D.setColor(-1);
        this.D.setTextSize(T);
        this.D.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(String.valueOf(this.f46461e), i26, (i27 + ((r3 * 2) / 5.0f)) - ar.d(1.0f), this.D);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(G, H);
    }

    public QQStoryAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = new Paint();
        this.E = new ImageLoader.ImageLoadListener() { // from class: com.qzone.component.banner.QQStoryAvatarView.1
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
                QZLog.d(QQStoryAvatarView.F, 2, "use async drawable :" + drawable + ",avatarUrl:" + QQStoryAvatarView.this.f46460d + "\uff0curl:" + str);
                if (TextUtils.isEmpty(str) || !str.equals(QQStoryAvatarView.this.f46460d)) {
                    return;
                }
                QQStoryAvatarView.this.post(new Runnable() { // from class: com.qzone.component.banner.QQStoryAvatarView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Drawable drawable2 = drawable;
                        if (drawable2 != null) {
                            QQStoryAvatarView qQStoryAvatarView = QQStoryAvatarView.this;
                            qQStoryAvatarView.C = drawable2;
                            qQStoryAvatarView.invalidate();
                        }
                    }
                });
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str, float f16, ImageLoader.Options options) {
            }
        };
    }

    public void setData(BusinessFeedData businessFeedData, boolean z16) {
        String str = null;
        if (businessFeedData == null) {
            this.C = null;
            this.f46463h = null;
            QZLog.e(F, "setData() input data is empty!");
            return;
        }
        this.f46464i = z16;
        this.C = null;
        this.f46463h = businessFeedData;
        User user = businessFeedData.getUser();
        this.f46462f = user.nickName;
        if (user.uin > 0) {
            str = "avatar://" + user.uin;
        }
        this.f46460d = str;
        CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
        Map<String, String> map = feedCommInfo.extendInfo;
        if (map != null && map.containsKey("unread_video")) {
            try {
                String str2 = feedCommInfo.extendInfo.get("unread_video");
                if (!TextUtils.isEmpty(str2)) {
                    this.f46461e = Integer.valueOf(str2).intValue();
                } else {
                    this.f46461e = 0;
                }
            } catch (NumberFormatException unused) {
                this.f46461e = 0;
            }
        }
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        if (z16) {
            uo.a aVar = new uo.a(10);
            aVar.setPreProcessor(new OvalProcessor());
            obtain.extraProcessor = aVar;
        } else {
            obtain.extraProcessor = new OvalProcessor();
        }
        int i3 = M;
        obtain.clipHeight = i3;
        obtain.clipWidth = i3;
        obtain.useMainThread = false;
        obtain.preferQuality = false;
        QZLog.d(F, 2, "setData avaterUrl:" + this.f46460d);
        Drawable loadImage = ImageLoader.getInstance(getContext()).loadImage(this.f46460d, this.E, obtain);
        if (loadImage == null) {
            this.C = getContext().getResources().getDrawable(R.drawable.h2k);
            invalidate();
        } else {
            QZLog.d(F, 2, "direct use drawable :" + loadImage + ",avatarUrl:" + this.f46460d);
            this.C = loadImage;
            invalidate();
        }
        if (u5.a.e()) {
            setContentDescription(this.f46462f + l.a(R.string.r3w) + this.f46461e + l.a(R.string.f172481r41));
        }
    }

    public QQStoryAvatarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = new Paint();
        this.E = new ImageLoader.ImageLoadListener() { // from class: com.qzone.component.banner.QQStoryAvatarView.1
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
                QZLog.d(QQStoryAvatarView.F, 2, "use async drawable :" + drawable + ",avatarUrl:" + QQStoryAvatarView.this.f46460d + "\uff0curl:" + str);
                if (TextUtils.isEmpty(str) || !str.equals(QQStoryAvatarView.this.f46460d)) {
                    return;
                }
                QQStoryAvatarView.this.post(new Runnable() { // from class: com.qzone.component.banner.QQStoryAvatarView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Drawable drawable2 = drawable;
                        if (drawable2 != null) {
                            QQStoryAvatarView qQStoryAvatarView = QQStoryAvatarView.this;
                            qQStoryAvatarView.C = drawable2;
                            qQStoryAvatarView.invalidate();
                        }
                    }
                });
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str, float f16, ImageLoader.Options options) {
            }
        };
    }
}
