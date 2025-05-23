package com.tencent.qqmini.sdk.manager;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class a extends ClickableSpan {
        View.OnClickListener D;
        boolean E;

        /* renamed from: d, reason: collision with root package name */
        private int f348145d;

        /* renamed from: e, reason: collision with root package name */
        private int f348146e;

        /* renamed from: f, reason: collision with root package name */
        private int f348147f;

        /* renamed from: h, reason: collision with root package name */
        String f348148h;

        /* renamed from: i, reason: collision with root package name */
        Context f348149i;

        /* renamed from: m, reason: collision with root package name */
        boolean f348150m;
        boolean C = false;
        long F = 0;

        public a(Context context, c cVar, boolean z16, d dVar) {
            this.f348148h = cVar.f348154b;
            this.f348149i = context;
            this.f348150m = z16;
            this.D = cVar.f348155c;
            this.E = cVar.f348156d;
            a(context);
        }

        private void a(Context context) {
            this.f348145d = context.getResources().getColor(R.color.mini_sdk_color_hei);
            Resources resources = context.getResources();
            int i3 = R.color.mini_sdk_action_sheet_button_blue_bold;
            this.f348146e = resources.getColor(i3);
            this.f348147f = context.getResources().getColor(i3);
        }

        public void b(View view, boolean z16) {
            if (this.C != z16) {
                this.C = z16;
                view.invalidate();
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.F + 500 >= currentTimeMillis) {
                return;
            }
            this.F = currentTimeMillis;
            View.OnClickListener onClickListener = this.D;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            if (!TextUtils.isEmpty(this.f348148h)) {
                if (this.f348150m) {
                    try {
                        this.f348149i.startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(this.f348148h)));
                    } catch (ActivityNotFoundException unused) {
                    }
                } else {
                    ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
                    new Intent().putExtra("url", this.f348148h);
                    channelProxy.startTransparentBrowserActivityForResult((Activity) this.f348149i, this.f348148h, null, 100);
                }
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            int i3;
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            if (this.E) {
                if (this.C) {
                    i3 = this.f348147f;
                } else {
                    i3 = this.f348146e;
                }
                textPaint.setColor(i3);
                return;
            }
            textPaint.setColor(this.f348145d);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.qqmini.sdk.manager.b$b, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private static class C9418b extends LinkMovementMethod {

        /* renamed from: b, reason: collision with root package name */
        private static final C9418b f348151b = new C9418b();

        /* renamed from: a, reason: collision with root package name */
        private a f348152a;

        C9418b() {
        }

        private a[] b(Spannable spannable, int i3, int i16, Layout layout) {
            if (i3 > -20 && i3 < layout.getWidth() + 20 && i16 > -20 && i16 < layout.getHeight() + 20) {
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(i16), i3);
                return (a[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, a.class);
            }
            return new a[0];
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            a aVar;
            int action = motionEvent.getAction();
            if (action == 1 || action == 0 || action == 3) {
                a[] b16 = b(spannable, (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX(), (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY(), textView.getLayout());
                if (b16.length != 0) {
                    if (action != 0) {
                        if (action != 1) {
                            if (action == 3 && (aVar = this.f348152a) != null) {
                                aVar.b(textView, false);
                                this.f348152a = null;
                            }
                        } else {
                            a aVar2 = this.f348152a;
                            if (aVar2 != null) {
                                aVar2.b(textView, false);
                                a aVar3 = this.f348152a;
                                if (aVar3 == b16[0]) {
                                    aVar3.onClick(textView);
                                }
                                this.f348152a = null;
                            }
                        }
                    } else {
                        b16[0].b(textView, true);
                        this.f348152a = b16[0];
                    }
                    return true;
                }
                a aVar4 = this.f348152a;
                if (aVar4 != null) {
                    aVar4.b(textView, false);
                    this.f348152a = null;
                    return true;
                }
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        String f348153a;

        /* renamed from: b, reason: collision with root package name */
        String f348154b;

        /* renamed from: c, reason: collision with root package name */
        View.OnClickListener f348155c = null;

        /* renamed from: d, reason: collision with root package name */
        boolean f348156d;

        public c(String str, String str2) {
            this.f348156d = false;
            this.f348153a = str;
            this.f348154b = str2;
            this.f348156d = !TextUtils.isEmpty(str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class d {
    }

    public static SpannableString a(String str, Context context, boolean z16, List<c> list) {
        return b(str, context, z16, list, null);
    }

    public static SpannableString b(String str, Context context, boolean z16, List<c> list, d dVar) {
        SpannableString spannableString = new SpannableString(str);
        for (c cVar : list) {
            int indexOf = str.indexOf(cVar.f348153a);
            while (indexOf >= 0 && indexOf < str.length()) {
                spannableString.setSpan(new a(context, cVar, z16, dVar), indexOf, cVar.f348153a.length() + indexOf, 17);
                indexOf = str.indexOf(cVar.f348153a, indexOf + 1);
            }
        }
        return spannableString;
    }

    public static MovementMethod c() {
        return C9418b.f348151b;
    }
}
