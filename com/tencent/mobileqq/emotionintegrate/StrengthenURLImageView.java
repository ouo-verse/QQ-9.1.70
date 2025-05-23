package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForVideoEmoticon;
import com.tencent.mobileqq.emotionintegrate.w;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.aw;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes12.dex */
public class StrengthenURLImageView extends URLImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static Drawable f205175h;

    /* renamed from: d, reason: collision with root package name */
    private Object f205176d;

    /* renamed from: e, reason: collision with root package name */
    private int f205177e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f205178f;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class GetUrlProtoCallback implements RichProtoProc.RichProtoCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f205179d;

        /* renamed from: e, reason: collision with root package name */
        private s f205180e;

        public GetUrlProtoCallback(int i3, s sVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, StrengthenURLImageView.this, Integer.valueOf(i3), sVar);
            } else {
                this.f205179d = i3;
                this.f205180e = sVar;
            }
        }

        @Override // com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
        public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                synchronized (StrengthenURLImageView.this.f205176d) {
                    if (this.f205179d != StrengthenURLImageView.this.f205177e) {
                        QLog.d("StrengthenURLImageView", 1, "response seq is not equal current view seq, return");
                        return;
                    }
                    w.a aVar = new w.a();
                    if (richProtoResp != null) {
                        if (richProtoResp.resps.size() > 0) {
                            aVar.b((RichProto.RichProtoResp.ShortVideoDownResp) richProtoResp.resps.get(0));
                        } else {
                            aVar.f205298a = false;
                            aVar.f205299b = "Unknown error\uff01";
                        }
                    } else {
                        aVar.f205298a = false;
                        aVar.f205299b = "Unknown error\uff01";
                    }
                    StrengthenURLImageView.this.post(new Runnable(aVar) { // from class: com.tencent.mobileqq.emotionintegrate.StrengthenURLImageView.GetUrlProtoCallback.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ w.a f205182d;

                        {
                            this.f205182d = aVar;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GetUrlProtoCallback.this, (Object) aVar);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                GetUrlProtoCallback getUrlProtoCallback = GetUrlProtoCallback.this;
                                StrengthenURLImageView.this.h(this.f205182d, getUrlProtoCallback.f205180e);
                            }
                        }
                    });
                    return;
                }
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class SpecifyURLDrawableDownListener implements URLDrawableDownListener {
        static IPatchRedirector $redirector_;

        SpecifyURLDrawableDownListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StrengthenURLImageView.this);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) uRLDrawable);
                return;
            }
            QLog.e("StrengthenURLImageView", 1, "onLoadCancelled: " + toString());
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, view, uRLDrawable, th5);
                return;
            }
            QLog.e("StrengthenURLImageView", 1, "onLoadFailed: " + toString());
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, view, uRLDrawable, interruptedException);
                return;
            }
            QLog.e("StrengthenURLImageView", 1, "onLoadInterrupted: " + toString());
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, view, uRLDrawable, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                synchronized (StrengthenURLImageView.this.f205176d) {
                    QLog.i("StrengthenURLImageView", 1, "onLoadSuccessed: " + toString());
                    StrengthenURLImageView.this.post(new Runnable(uRLDrawable, view) { // from class: com.tencent.mobileqq.emotionintegrate.StrengthenURLImageView.SpecifyURLDrawableDownListener.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ URLDrawable f205185d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ View f205186e;

                        {
                            this.f205185d = uRLDrawable;
                            this.f205186e = view;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, SpecifyURLDrawableDownListener.this, uRLDrawable, view);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            int i3;
                            File fileInLocal;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            try {
                                fileInLocal = this.f205185d.getFileInLocal();
                            } catch (Exception e16) {
                                QLog.e("StrengthenURLImageView", 1, "onLoadSuccessed orientate exception:", e16);
                            }
                            if (fileInLocal != null) {
                                i3 = aw.h(fileInLocal.getAbsolutePath());
                                QLog.d("StrengthenURLImageView", 1, "onLoadSuccessed,orientation:", Integer.valueOf(i3));
                                com.tencent.mobileqq.pic.util.a.a(this.f205186e, this.f205185d, i3);
                            }
                            i3 = 0;
                            QLog.d("StrengthenURLImageView", 1, "onLoadSuccessed,orientation:", Integer.valueOf(i3));
                            com.tencent.mobileqq.pic.util.a.a(this.f205186e, this.f205185d, i3);
                        }
                    });
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) uRLDrawable);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71751);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f205175h = new ColorDrawable(DownloadCardView.COLOR_APP_NAME_DARK);
        }
    }

    public StrengthenURLImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f205176d = new Object();
            this.f205178f = false;
        }
    }

    private void g(String str) {
        setURLDrawableDownListener(null);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = f205175h;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        obtain.mPlayGifImage = true;
        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
        setURLDrawableDownListener(new SpecifyURLDrawableDownListener());
        setImageDrawable(drawable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(w.a aVar, s sVar) {
        if (aVar.f205298a) {
            String a16 = aVar.a();
            ((MessageForVideoEmoticon) sVar.f205289a).thumbOriginUrl = a16;
            g(a16);
        }
    }

    public void f(Drawable drawable, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, drawable, Boolean.valueOf(z16));
            return;
        }
        synchronized (this.f205176d) {
            this.f205177e = ((int) System.currentTimeMillis()) + new Random().nextInt(10000);
            this.f205178f = z16;
            setImageDrawable(drawable);
        }
    }

    public void i(QQAppInterface qQAppInterface, s sVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQAppInterface, (Object) sVar);
            return;
        }
        synchronized (this.f205176d) {
            this.f205177e = ((int) System.currentTimeMillis()) + new Random().nextInt(10000);
            if (sVar != null) {
                if (sVar.f205293e) {
                    this.f205178f = true;
                    String str = ((MessageForVideoEmoticon) sVar.f205289a).thumbOriginUrl;
                    if (!TextUtils.isEmpty(str)) {
                        g(str);
                        return;
                    }
                    setImageDrawable(f205175h);
                    MessageForVideoEmoticon messageForVideoEmoticon = (MessageForVideoEmoticon) sVar.f205289a;
                    String str2 = messageForVideoEmoticon.uuid;
                    String str3 = messageForVideoEmoticon.thumbMD5;
                    int i3 = this.f205177e;
                    w.b(qQAppInterface, str2, str3, 0, 1, "0", i3, new GetUrlProtoCallback(i3, sVar));
                } else {
                    this.f205178f = false;
                }
            }
        }
    }

    public StrengthenURLImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f205176d = new Object();
            this.f205178f = false;
        }
    }

    public StrengthenURLImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            this.f205176d = new Object();
            this.f205178f = false;
        }
    }
}
