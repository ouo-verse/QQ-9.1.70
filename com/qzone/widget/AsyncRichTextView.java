package com.qzone.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.ClipboardManager;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.qzone.feed.ui.comment.UserNameSapn;
import com.tencent.component.media.image.ImageLoader;
import w6.a;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AsyncRichTextView extends TextView implements Handler.Callback {
    private static final int WHAT_RELOAD = 1;
    private int atColorRes;
    private Drawable.Callback callback;
    private int[][] clickableRect;
    private int clickableSize;
    private ClipboardManager clipboardManager;
    private CharSequence currentText;
    private Handler handler;
    private boolean isOlderCopyApi;
    private ImageLoader.ImageLoadListener listener;
    private Context mContext;
    private Toast mToast;
    private int nickNameColorRes;
    private View.OnClickListener onClickListener;
    private a.InterfaceC11463a onCustomUrlClickListener;
    private UserNameSapn.OnUserNameClickListener onUserNameClickListener;
    private boolean parseUrl;
    private int urlColorRes;

    public AsyncRichTextView(Context context) {
        super(context);
        this.isOlderCopyApi = false;
        this.urlColorRes = Integer.MIN_VALUE;
        this.handler = new Handler(Looper.getMainLooper(), this);
        this.clickableRect = null;
        this.listener = new a();
        this.mContext = context;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        CharSequence charSequence;
        if (message.what != 1 || (charSequence = (CharSequence) message.obj) == null || !charSequence.equals(this.currentText)) {
            return false;
        }
        setRichText(charSequence, this.nickNameColorRes, this.atColorRes, this.onUserNameClickListener, this.callback);
        return false;
    }

    public void setBoldText(boolean z16) {
        TextPaint paint = getPaint();
        if (paint != null) {
            paint.setFakeBoldText(z16);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        super.setOnClickListener(onClickListener);
    }

    public void setParseUrl(boolean z16) {
        this.parseUrl = z16;
    }

    public void setUrlColorRes(int i3) {
        this.urlColorRes = i3;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        setFocusable(false);
        return super.onTouchEvent(motionEvent);
    }

    protected void setRichText(CharSequence charSequence, int i3, int i16, UserNameSapn.OnUserNameClickListener onUserNameClickListener, Drawable.Callback callback) {
        this.currentText = charSequence;
        this.nickNameColorRes = i3;
        this.atColorRes = i16;
        this.onUserNameClickListener = onUserNameClickListener;
        this.callback = callback;
        x.j(this, getContext(), charSequence, i3, i16, this.urlColorRes, onUserNameClickListener, null, this.listener, callback, this.parseUrl);
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements ImageLoader.ImageLoadListener {
        a() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            Object obj = options == null ? null : options.obj;
            if (obj == null || !(obj instanceof CharSequence)) {
                return;
            }
            CharSequence charSequence = (CharSequence) obj;
            if (charSequence.equals(AsyncRichTextView.this.currentText)) {
                AsyncRichTextView.this.handler.removeMessages(1);
                AsyncRichTextView.this.handler.sendMessageDelayed(AsyncRichTextView.this.handler.obtainMessage(1, charSequence), 700L);
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

    public AsyncRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isOlderCopyApi = false;
        this.urlColorRes = Integer.MIN_VALUE;
        this.handler = new Handler(Looper.getMainLooper(), this);
        this.clickableRect = null;
        this.listener = new a();
        this.mContext = context;
    }

    public AsyncRichTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.isOlderCopyApi = false;
        this.urlColorRes = Integer.MIN_VALUE;
        this.handler = new Handler(Looper.getMainLooper(), this);
        this.clickableRect = null;
        this.listener = new a();
        this.mContext = context;
    }

    public void setOnCustomUrlClickListener(a.InterfaceC11463a interfaceC11463a) {
    }
}
