package com.tencent.mobileqq.forward;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pic.api.IPicAIO;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqui.widget.RoundBubbleImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.BaseURLDrawableHelper;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.adapter.api.IMarketFaceApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* compiled from: P */
/* loaded from: classes12.dex */
public class n extends m {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private int f211037h;

    /* renamed from: i, reason: collision with root package name */
    protected LinearLayout f211038i;

    /* renamed from: j, reason: collision with root package name */
    protected QQAppInterface f211039j;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) n.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                n.this.f211038i.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                n.this.n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements Continuation<com.tencent.qqnt.msg.api.c<com.tencent.qqnt.emotion.adapter.api.a>> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLImageView f211041d;

        b(URLImageView uRLImageView) {
            this.f211041d = uRLImageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) n.this, (Object) uRLImageView);
            }
        }

        @Override // kotlin.coroutines.Continuation
        @NonNull
        /* renamed from: getContext */
        public CoroutineContext get$context() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CoroutineContext) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return EmptyCoroutineContext.INSTANCE;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(@NonNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
                return;
            }
            if (!(obj instanceof com.tencent.qqnt.msg.api.c)) {
                return;
            }
            com.tencent.qqnt.emotion.adapter.api.a aVar = (com.tencent.qqnt.emotion.adapter.api.a) ((com.tencent.qqnt.msg.api.c) obj).a();
            if (aVar != null && aVar.a() != null) {
                URLDrawable loadingDrawable = aVar.a().getLoadingDrawable(EmotionConstants.FROM_AIO, true);
                if (loadingDrawable != null) {
                    this.f211041d.setImageDrawable(loadingDrawable);
                    return;
                }
                return;
            }
            QLog.e("ForwardPreviewMixedMsgController", 1, "[resumeWith] emotionInfo is null!");
        }
    }

    public n(QQCustomDialog qQCustomDialog, QQAppInterface qQAppInterface) {
        super(qQCustomDialog);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQCustomDialog, (Object) qQAppInterface);
        } else {
            this.f211039j = qQAppInterface;
        }
    }

    private void k(StringBuilder sb5) {
        if (sb5.length() != 0 && this.f211038i != null) {
            int dip2px = ViewUtils.dip2px(4.0f);
            AnimationTextView animationTextView = new AnimationTextView(this.f211030b);
            animationTextView.setTextSize(17.0f);
            if (SimpleModeHelper.A()) {
                animationTextView.setTextColor(-1);
            } else {
                animationTextView.setTextColor(this.f211030b.getResources().getColor(R.color.forward_dialog_new_black));
            }
            animationTextView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
            animationTextView.setText(new QQText(sb5.toString(), 5, 20));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 3;
            layoutParams.setMargins(0, dip2px, 0, dip2px);
            this.f211038i.addView(animationTextView, layoutParams);
        }
    }

    private void m(MsgElement msgElement, int i3) {
        URLImageView uRLImageView = new URLImageView(this.f211030b);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, i3, 0, i3);
        uRLImageView.setImageResource(R.drawable.c0i);
        this.f211038i.addView(uRLImageView, layoutParams);
        ((IMarketFaceApi) QRoute.api(IMarketFaceApi.class)).fetchMarketFaceInfoSuspend(msgElement.getMarketFaceElement(), new b(uRLImageView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.f211038i.getHeight() >= ViewUtils.dip2px(this.f211037h + 1)) {
            this.f211033e.setMaxHeight(ViewUtils.dip2px(450.0f));
            this.f211033e.requestLayout();
            if (QLog.isColorLevel()) {
                QLog.d("ForwardPreviewMixedMsgController", 2, " reset height ");
            }
        }
    }

    private int p(PicElement picElement) {
        return Math.max(picElement.getPicWidth(), picElement.getPicHeight());
    }

    private boolean q(PicElement picElement) {
        if (picElement.getPicType().intValue() < 2000 && picElement.getPicType().intValue() != 2) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.forward.m
    protected View a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ScrollView scrollView = new ScrollView(this.f211030b);
        scrollView.setOverScrollMode(2);
        scrollView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f211038i = new LinearLayout(this.f211030b);
        int dip2px = ViewUtils.dip2px(15.0f);
        int dip2px2 = ViewUtils.dip2px(8.0f);
        this.f211038i.setPadding(dip2px, dip2px2, dip2px, dip2px2);
        this.f211038i.setOrientation(1);
        scrollView.addView(this.f211038i, new ViewGroup.LayoutParams(-1, -2));
        return scrollView;
    }

    @Override // com.tencent.mobileqq.forward.m
    protected int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (this.f211037h == 0) {
            this.f211037h = (int) ((this.f211035g.getRootViewHeight() - this.f211030b.getResources().getDimensionPixelSize(R.dimen.f158884rk)) / ViewUtils.mDensity);
        }
        return this.f211037h;
    }

    public void l(String str, AIOMsgItem aIOMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) aIOMsgItem);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardPreviewMixedMsgController", 2, " bindData ");
        }
        if (str != null) {
            h(str);
        }
        if (aIOMsgItem != null && this.f211038i != null) {
            int dip2px = ViewUtils.dip2px(4.0f);
            StringBuilder sb5 = new StringBuilder();
            Iterator<MsgElement> it = aIOMsgItem.getMsgRecord().getElements().iterator();
            while (it.hasNext()) {
                MsgElement next = it.next();
                if (next.getElementType() == 1) {
                    sb5.append(next.getTextElement().getContent());
                } else if (next.getElementType() == 6) {
                    sb5.append(QQSysFaceUtil.getFaceString(QQSysFaceUtil.convertToLocal(next.getFaceElement().getFaceIndex())));
                } else if (next.getElementType() == 2) {
                    k(sb5);
                    sb5 = new StringBuilder();
                    RoundBubbleImageView roundBubbleImageView = new RoundBubbleImageView(this.f211030b);
                    roundBubbleImageView.setAdjustViewBounds(true);
                    roundBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    roundBubbleImageView.setRadiusDP(4.0f);
                    PicElement picElement = next.getPicElement();
                    int p16 = p(picElement);
                    boolean q16 = q(picElement);
                    boolean u16 = MsgExtKt.u(picElement);
                    int thumbMaxPx = ((IPicAIO) QRoute.api(IPicAIO.class)).getThumbMaxPx(q16, u16, p16);
                    int thumbMinPx = ((IPicAIO) QRoute.api(IPicAIO.class)).getThumbMinPx(q16, u16, p16);
                    com.tencent.qqnt.aio.forward.k kVar = com.tencent.qqnt.aio.forward.k.f349976a;
                    Pair<Integer, Integer> c16 = com.tencent.qqnt.aio.forward.k.c(picElement.getPicWidth(), picElement.getPicHeight(), thumbMaxPx, thumbMinPx, false);
                    roundBubbleImageView.setImageDrawable(o(picElement, c16));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c16.getFirst().intValue(), c16.getSecond().intValue());
                    layoutParams.gravity = 3;
                    layoutParams.setMargins(0, dip2px, 0, dip2px);
                    this.f211038i.addView(roundBubbleImageView, layoutParams);
                } else if (next.getElementType() == 11) {
                    k(sb5);
                    sb5 = new StringBuilder();
                    m(next, dip2px);
                }
            }
            k(sb5);
            this.f211038i.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        }
    }

    public Drawable o(PicElement picElement, Pair<Integer, Integer> pair) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) picElement, (Object) pair);
        }
        String d16 = com.tencent.qqnt.aio.forward.k.d(picElement);
        if (!TextUtils.isEmpty(d16)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable loadingDrawable = URLDrawableHelper.getLoadingDrawable();
            int intValue = pair.getFirst().intValue();
            int intValue2 = pair.getSecond().intValue();
            obtain.mLoadingDrawable = loadingDrawable;
            obtain.mFailedDrawable = BaseURLDrawableHelper.getFailedDrawable();
            obtain.mRequestWidth = intValue;
            obtain.mRequestHeight = intValue2;
            obtain.mPlayGifImage = false;
            return URLDrawable.getFileDrawable(d16, obtain);
        }
        return null;
    }
}
