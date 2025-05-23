package com.qzone.module.feedcomponent.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.media.image.processor.OvalProcessor;
import com.tencent.ditto.area.DittoArea;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AvatarArea extends SubArea {
    public static final Drawable DEFAULT_AVATAR;
    public static final OvalProcessor DEFAULT_OVAL_PROCESSOR;
    public static final int DEFAULT_SIZE;
    static String avatarRedPocketIconUrl = null;
    static int globalUniNum = 1;
    long iKey;
    boolean isNeedDoRedPocketAnim;
    Drawable mAvatarDrawable;
    public Drawable mAvatarRedPocketDrawable;
    private DittoArea mParent;
    float mRedPocketAnimParams;
    boolean mRedPocketAnimchangedDirect;
    User mUser;
    int mAvatarSize = DEFAULT_SIZE;
    PicListener downloadListener = new PicListener();

    static {
        OvalProcessor ovalProcessor = new OvalProcessor();
        DEFAULT_OVAL_PROCESSOR = ovalProcessor;
        DEFAULT_SIZE = com.qzone.adapter.feedcomponent.b.f41867n;
        DEFAULT_AVATAR = ovalProcessor.process(com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.CURRUNT_TIME));
        avatarRedPocketIconUrl = com.qzone.adapter.feedcomponent.i.H().N();
    }

    public AvatarArea() {
        this.mType = 17;
    }

    static int getUniNum() {
        int i3 = globalUniNum + 1;
        globalUniNum = i3;
        return i3;
    }

    private boolean isDrawableRecycle(Drawable drawable) {
        Bitmap bitmap;
        if (!(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null) {
            return true;
        }
        return bitmap.isRecycled();
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        if (this.isNeedDoRedPocketAnim) {
            try {
                drawRedPocketAnim(canvas, paint);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        Drawable drawable = this.mAvatarDrawable;
        if (drawable != null) {
            this.mRedPocketAnimParams = 0.0f;
            this.mRedPocketAnimchangedDirect = false;
            drawable.setAlpha(255);
            Drawable drawable2 = this.mAvatarRedPocketDrawable;
            if (drawable2 != null) {
                drawable2.setAlpha(0);
            }
            try {
                Drawable drawable3 = this.mAvatarDrawable;
                int i3 = this.mAvatarSize;
                drawable3.setBounds(0, 0, i3, i3);
                this.mAvatarDrawable.draw(canvas);
            } catch (Exception e16) {
                com.qzone.proxy.feedcomponent.b.d("AvatarArea", "Feed Avatar draw exception.", e16);
                return false;
            }
        }
        return true;
    }

    public void drawRedPocketAnim(Canvas canvas, Paint paint) {
        Drawable drawable = this.mAvatarDrawable;
        if (drawable == null || this.mAvatarRedPocketDrawable == null || isDrawableRecycle(drawable) || isDrawableRecycle(this.mAvatarRedPocketDrawable)) {
            return;
        }
        if (!this.mRedPocketAnimchangedDirect) {
            canvas.save();
            canvas.translate(0.0f, (0.0f - this.mRedPocketAnimParams) * this.mAvatarSize);
            float f16 = this.mRedPocketAnimParams;
            int i3 = this.mAvatarSize;
            canvas.clipRect(0, (int) (f16 * i3), i3, i3);
            Drawable drawable2 = this.mAvatarDrawable;
            int i16 = this.mAvatarSize;
            drawable2.setBounds(0, 0, i16, i16);
            this.mAvatarDrawable.draw(canvas);
            this.mAvatarDrawable.setAlpha((int) ((1.0f - this.mRedPocketAnimParams) * 255.0d));
            canvas.restore();
            canvas.save();
            canvas.translate(0.0f, (1.0f - this.mRedPocketAnimParams) * this.mAvatarSize);
            int i17 = this.mAvatarSize;
            canvas.clipRect(0, 0, i17, (int) (this.mRedPocketAnimParams * i17));
            Drawable drawable3 = this.mAvatarRedPocketDrawable;
            int i18 = this.mAvatarSize;
            drawable3.setBounds(0, 0, i18, i18);
            this.mAvatarRedPocketDrawable.setAlpha(255);
            this.mAvatarRedPocketDrawable.draw(canvas);
            canvas.restore();
        } else {
            canvas.save();
            canvas.translate(0.0f, (0.0f - this.mRedPocketAnimParams) * this.mAvatarSize);
            float f17 = this.mRedPocketAnimParams;
            int i19 = this.mAvatarSize;
            canvas.clipRect(0, (int) (f17 * i19), i19, i19);
            Drawable drawable4 = this.mAvatarRedPocketDrawable;
            int i26 = this.mAvatarSize;
            drawable4.setBounds(0, 0, i26, i26);
            this.mAvatarRedPocketDrawable.setAlpha((int) ((1.0f - this.mRedPocketAnimParams) * 255.0d));
            this.mAvatarRedPocketDrawable.draw(canvas);
            canvas.restore();
            canvas.save();
            canvas.translate(0.0f, (1.0f - this.mRedPocketAnimParams) * this.mAvatarSize);
            int i27 = this.mAvatarSize;
            canvas.clipRect(0, 0, i27, (int) (this.mRedPocketAnimParams * i27));
            this.mAvatarDrawable.setAlpha(255);
            Drawable drawable5 = this.mAvatarDrawable;
            int i28 = this.mAvatarSize;
            drawable5.setBounds(0, 0, i28, i28);
            this.mAvatarDrawable.draw(canvas);
            canvas.restore();
        }
        if (this.mRedPocketAnimParams >= 1.0f) {
            this.mRedPocketAnimchangedDirect = !this.mRedPocketAnimchangedDirect;
            this.mRedPocketAnimParams = 0.0f;
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getHeight() {
        return this.mAvatarSize;
    }

    public float getRedPocketAnimParams() {
        return this.mRedPocketAnimParams;
    }

    public User getUser() {
        return this.mUser;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getWidth() {
        return this.mAvatarSize;
    }

    Drawable loadAvatar(long j3, User user) {
        return loadAvatar(j3, user, false);
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean onTouchEvent(MotionEvent motionEvent, SubAreaShell subAreaShell, boolean z16) {
        if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
            if (motionEvent.getAction() == 1) {
                if (subAreaShell != null) {
                    subAreaShell.onAreaClicked(this, null);
                }
            } else if (motionEvent.getAction() != 3) {
                motionEvent.getAction();
            }
        }
        return true;
    }

    public void setAvatarSize(int i3) {
        this.mAvatarSize = i3;
    }

    public void setIsNeedDoRedPocketAnim(boolean z16) {
        this.isNeedDoRedPocketAnim = z16;
    }

    public void setRedPocketAnimParams(float f16) {
        this.mRedPocketAnimParams = f16;
    }

    public void setUser(User user, boolean z16) {
        setUser(user, z16, false);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class PicListener implements ImageLoader.ImageLoadListener {
        public PicListener() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            Object obj;
            if (options == null || (obj = options.obj) == null || !(obj instanceof Long) || AvatarArea.this.iKey != ((Long) obj).longValue()) {
                return;
            }
            AvatarArea avatarArea = AvatarArea.this;
            avatarArea.mAvatarDrawable = drawable;
            AreaManager.mainHanlder.obtainMessage(1, avatarArea).sendToTarget();
            AvatarArea avatarArea2 = AvatarArea.this;
            avatarArea2.iKey = 0L;
            if (avatarArea2.mParent != null) {
                AvatarArea.this.mParent.invalidate();
            }
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
    }

    Drawable loadAvatar(long j3, User user, boolean z16) {
        String P = com.qzone.adapter.feedcomponent.i.H().P(Long.valueOf(j3));
        return loadAvatar(PictureUrl.calculateAvaterImageUrl(P), P, j3, user != null ? user.avatarRedPocketIconImageUrl : null, z16);
    }

    public void reset() {
        this.isNeedDoRedPocketAnim = false;
        this.mRedPocketAnimParams = 0.0f;
        this.mRedPocketAnimchangedDirect = false;
        if (com.qzone.adapter.feedcomponent.i.H().o0()) {
            this.mAvatarRedPocketDrawable = null;
            this.mAvatarDrawable = null;
        }
    }

    public void setUser(User user, boolean z16, boolean z17) {
        if (user == null) {
            return;
        }
        if (this.mUser != user || this.mAvatarDrawable == DEFAULT_AVATAR) {
            long j3 = user.uin;
            this.mUser = user;
            if (z16) {
                int i3 = user.from;
                if (i3 == 0 || i3 == 1) {
                    if (j3 > 0) {
                        this.mAvatarDrawable = loadAvatar(j3, user, z17);
                    } else {
                        this.mAvatarDrawable = DEFAULT_AVATAR;
                    }
                } else if (i3 == 2) {
                    ImageUrl imageUrl = user.logoImageUrl;
                    String str = user.logo;
                    if (j3 == 0) {
                        j3 = getUniNum();
                    }
                    this.mAvatarDrawable = loadAvatar(imageUrl, str, j3, user.avatarRedPocketIconImageUrl);
                } else if (i3 == 4) {
                    ImageUrl imageUrl2 = user.logoImageUrl;
                    String str2 = user.logo;
                    if (j3 == 0) {
                        j3 = getUniNum();
                    }
                    this.mAvatarDrawable = loadAvatar(imageUrl2, str2, j3, user.avatarRedPocketIconImageUrl);
                } else if (i3 == 5) {
                    if (com.qzone.adapter.feedcomponent.i.H().X0()) {
                        com.qzone.proxy.feedcomponent.b.c("FRIENDVIDEO", "user.descicon= " + user.descicon);
                    }
                    String str3 = user.descicon;
                    if (str3 != null) {
                        this.mAvatarDrawable = loadAvatar(user.desciconImageUrl, str3, str3.hashCode(), user.avatarRedPocketIconImageUrl);
                    }
                } else if (i3 == 8) {
                    if (user.logoImageUrl != null || !TextUtils.isEmpty(user.logo)) {
                        ImageUrl imageUrl3 = user.logoImageUrl;
                        String str4 = user.logo;
                        if (j3 == 0) {
                            j3 = getUniNum();
                        }
                        this.mAvatarDrawable = loadAvatar(imageUrl3, str4, j3, user.avatarRedPocketIconImageUrl);
                    } else if (j3 > 0) {
                        this.mAvatarDrawable = loadAvatar(j3, user, z17);
                    } else {
                        this.mAvatarDrawable = DEFAULT_AVATAR;
                    }
                }
            }
            if (this.mAvatarDrawable == null) {
                this.mAvatarDrawable = DEFAULT_AVATAR;
            }
        }
    }

    Drawable loadAvatar(ImageUrl imageUrl, String str, long j3, ImageUrl imageUrl2) {
        return loadAvatar(imageUrl, str, j3, imageUrl2, false);
    }

    public AvatarArea(DittoArea dittoArea) {
        this.mType = 17;
        this.mParent = dittoArea;
    }

    Drawable loadAvatar(ImageUrl imageUrl, String str, long j3, ImageUrl imageUrl2, boolean z16) {
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        this.iKey = j3;
        obtain.obj = Long.valueOf(j3);
        if (!z16) {
            obtain.extraProcessor = DEFAULT_OVAL_PROCESSOR;
        }
        int i3 = DEFAULT_SIZE;
        obtain.clipHeight = i3;
        obtain.clipWidth = i3;
        this.mAvatarRedPocketDrawable = ImageLoader.getInstance(FeedGlobalEnv.getApplication()).loadImage(imageUrl2, avatarRedPocketIconUrl, new ImageLoader.ImageLoadListener() { // from class: com.qzone.module.feedcomponent.ui.AvatarArea.1
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options) {
                AvatarArea.this.mAvatarRedPocketDrawable = drawable;
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str2, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str2, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str2, float f16, ImageLoader.Options options) {
            }
        }, null);
        return ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(imageUrl, str, this.downloadListener, obtain);
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void clearTouchingEvent() {
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
    }
}
