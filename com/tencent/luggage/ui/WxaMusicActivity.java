package com.tencent.luggage.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.ui.WxaMusicActivity;
import com.tencent.luggage.wxa.lo.m;
import com.tencent.luggage.wxa.p9.h;
import com.tencent.luggage.wxa.qm.k;
import com.tencent.luggage.wxa.rb.a;
import com.tencent.luggage.wxa.sm.d;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0019\u001d\b\u0016\u0018\u0000 \u00072\u00020\u0001:\u0005\u0016\u001a\u001e\t\u0007B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\u0004H\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014J\b\u0010\f\u001a\u00020\u0004H\u0014J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/luggage/ui/WxaMusicActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Lcom/tencent/luggage/ui/WxaMusicActivity$d;", "e", "Lcom/tencent/luggage/ui/WxaMusicActivity$e;", "d", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "f", h.F, "", "g", "j", "i", "a", "Lcom/tencent/luggage/ui/WxaMusicActivity$d;", "mMusicView", "com/tencent/luggage/ui/WxaMusicActivity$musicPlayerListener$1", "b", "Lcom/tencent/luggage/ui/WxaMusicActivity$musicPlayerListener$1;", "musicPlayerListener", "com/tencent/luggage/ui/WxaMusicActivity$g", "c", "Lcom/tencent/luggage/ui/WxaMusicActivity$g;", "updateMusicHandler", "Lcom/tencent/luggage/wxa/sm/d$a;", "Lcom/tencent/luggage/wxa/sm/d$a;", "playProgressListener", "<init>", "()V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public class WxaMusicActivity extends AppCompatActivity {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    public static final String f120317f = "Luggage.WxaMusicActivity";

    /* renamed from: g, reason: collision with root package name */
    public static final int f120318g = Color.parseColor("#FAFAFA");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public d mMusicView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final WxaMusicActivity$musicPlayerListener$1 musicPlayerListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final g updateMusicHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final d.a playProgressListener;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.ui.WxaMusicActivity$a, reason: from kotlin metadata */
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return WxaMusicActivity.f120318g;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b implements d {

        /* renamed from: a, reason: collision with root package name */
        public final Context f120323a;

        /* renamed from: b, reason: collision with root package name */
        public final e f120324b;

        /* renamed from: c, reason: collision with root package name */
        public View f120325c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f120326d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f120327e;

        /* renamed from: f, reason: collision with root package name */
        public TextView f120328f;

        /* renamed from: g, reason: collision with root package name */
        public LinearLayout f120329g;

        /* renamed from: h, reason: collision with root package name */
        public TextView f120330h;

        /* renamed from: i, reason: collision with root package name */
        public ImageView f120331i;

        /* renamed from: j, reason: collision with root package name */
        public LinearLayout f120332j;

        /* renamed from: k, reason: collision with root package name */
        public MusicSeekBar f120333k;

        /* renamed from: l, reason: collision with root package name */
        public ImageView f120334l;

        /* renamed from: m, reason: collision with root package name */
        public ImageView f120335m;

        /* renamed from: n, reason: collision with root package name */
        public ImageView f120336n;

        /* renamed from: o, reason: collision with root package name */
        public ImageView f120337o;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class a implements MusicSeekBar.c {
            public a() {
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar.c
            public final void a(int i3) {
                com.tencent.luggage.wxa.rb.a.a(i3);
                MusicSeekBar musicSeekBar = b.this.f120333k;
                MusicSeekBar musicSeekBar2 = null;
                if (musicSeekBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
                    musicSeekBar = null;
                }
                musicSeekBar.setProgress(i3);
                MusicSeekBar musicSeekBar3 = b.this.f120333k;
                if (musicSeekBar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
                } else {
                    musicSeekBar2 = musicSeekBar3;
                }
                musicSeekBar2.a(true);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.ui.WxaMusicActivity$b$b, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class ViewOnClickListenerC5974b implements View.OnClickListener {
            public ViewOnClickListenerC5974b() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                b.this.f120324b.d();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class c implements View.OnClickListener {
            public c() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                b.this.f120324b.d();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class d implements View.OnClickListener {
            public d() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                b.this.f120324b.close();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class e implements View.OnClickListener {
            public e() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ImageView imageView = b.this.f120336n;
                ImageView imageView2 = null;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStopIv");
                    imageView = null;
                }
                imageView.setVisibility(8);
                ImageView imageView3 = b.this.f120335m;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayIv");
                } else {
                    imageView2 = imageView3;
                }
                imageView2.setVisibility(0);
                b.this.f120324b.c();
                EventCollector.getInstance().onViewClicked(imageView2);
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class f implements View.OnClickListener {
            public f() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ImageView imageView = b.this.f120336n;
                ImageView imageView2 = null;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStopIv");
                    imageView = null;
                }
                imageView.setVisibility(8);
                ImageView imageView3 = b.this.f120335m;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayIv");
                } else {
                    imageView2 = imageView3;
                }
                imageView2.setVisibility(0);
                b.this.f120324b.stop();
                EventCollector.getInstance().onViewClicked(imageView2);
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class g implements View.OnClickListener {
            public g() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                b.this.f120324b.e();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class h implements View.OnClickListener {
            public h() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                b.this.f120324b.next();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public b(Context mContext, e mMusicLogic) {
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            Intrinsics.checkNotNullParameter(mMusicLogic, "mMusicLogic");
            this.f120323a = mContext;
            this.f120324b = mMusicLogic;
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.d
        public void e() {
            k();
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.d
        public void f() {
            a(20);
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.d
        public void g() {
            k();
            ImageView imageView = this.f120335m;
            ImageView imageView2 = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayIv");
                imageView = null;
            }
            imageView.setVisibility(0);
            ImageView imageView3 = this.f120336n;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStopIv");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setVisibility(8);
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.d
        public void h() {
            MusicSeekBar musicSeekBar = this.f120333k;
            if (musicSeekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
                musicSeekBar = null;
            }
            musicSeekBar.a(false);
        }

        public final void i() {
            View view = this.f120325c;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
                view = null;
            }
            View findViewById = view.findViewById(R.id.aze);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.close_iv)");
            this.f120326d = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.a38);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.avatar_iv)");
            this.f120331i = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.f5q);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.name_tv)");
            this.f120330h = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.f125607mi);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.wxa_info_ll)");
            this.f120329g = (LinearLayout) findViewById4;
            View findViewById5 = view.findViewById(R.id.zrp);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.no_content_tv)");
            this.f120327e = (TextView) findViewById5;
            View findViewById6 = view.findViewById(R.id.jq_);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.title_tv)");
            this.f120328f = (TextView) findViewById6;
            View findViewById7 = view.findViewById(R.id.f211700a);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.operation_ll)");
            this.f120332j = (LinearLayout) findViewById7;
            View findViewById8 = view.findViewById(R.id.zkd);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.music_seek_bar)");
            this.f120333k = (MusicSeekBar) findViewById8;
            View findViewById9 = view.findViewById(R.id.fuz);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.play_btn)");
            this.f120335m = (ImageView) findViewById9;
            View findViewById10 = view.findViewById(R.id.f88494x8);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.stop_btn)");
            this.f120336n = (ImageView) findViewById10;
            View findViewById11 = view.findViewById(R.id.f26720ea);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.pre_song)");
            this.f120334l = (ImageView) findViewById11;
            View findViewById12 = view.findViewById(R.id.zqs);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.next_song)");
            this.f120337o = (ImageView) findViewById12;
        }

        public final void j() {
            MusicSeekBar musicSeekBar = this.f120333k;
            ImageView imageView = null;
            if (musicSeekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
                musicSeekBar = null;
            }
            musicSeekBar.setOnSeekBarChange(new a());
            MusicSeekBar musicSeekBar2 = this.f120333k;
            if (musicSeekBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
                musicSeekBar2 = null;
            }
            musicSeekBar2.setColor(Color.parseColor("#AEAEAE"));
            TextView textView = this.f120330h;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNameTv");
                textView = null;
            }
            textView.setOnClickListener(new ViewOnClickListenerC5974b());
            ImageView imageView2 = this.f120331i;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatarIv");
                imageView2 = null;
            }
            imageView2.setOnClickListener(new c());
            ImageView imageView3 = this.f120326d;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCloseIv");
                imageView3 = null;
            }
            imageView3.setOnClickListener(new d());
            ImageView imageView4 = this.f120335m;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayIv");
                imageView4 = null;
            }
            imageView4.setOnClickListener(new e());
            ImageView imageView5 = this.f120336n;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStopIv");
                imageView5 = null;
            }
            imageView5.setOnClickListener(new f());
            ImageView imageView6 = this.f120334l;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPreIv");
                imageView6 = null;
            }
            imageView6.setOnClickListener(new g());
            ImageView imageView7 = this.f120337o;
            if (imageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNextIv");
            } else {
                imageView = imageView7;
            }
            imageView.setOnClickListener(new h());
        }

        public final void k() {
            TextView textView = this.f120327e;
            LinearLayout linearLayout = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNoContentTv");
                textView = null;
            }
            textView.setVisibility(4);
            TextView textView2 = this.f120330h;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNameTv");
                textView2 = null;
            }
            textView2.setVisibility(0);
            LinearLayout linearLayout2 = this.f120329g;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWxaInfoLl");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(0);
            LinearLayout linearLayout3 = this.f120332j;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOperationLl");
            } else {
                linearLayout = linearLayout3;
            }
            linearLayout.setVisibility(0);
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.d
        public View a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            View inflate = View.inflate(context, R.layout.dqz, null);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layout.activity_music, null)");
            this.f120325c = inflate;
            if (inflate != null) {
                return inflate;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            return null;
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.d
        public void b(String icon) {
            Intrinsics.checkNotNullParameter(icon, "icon");
            ImageView imageView = null;
            if (icon.length() == 0) {
                ImageView imageView2 = this.f120331i;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAvatarIv");
                } else {
                    imageView = imageView2;
                }
                imageView.setImageResource(R.drawable.ojy);
                return;
            }
            AppBrandSimpleImageLoader instance = AppBrandSimpleImageLoader.instance();
            ImageView imageView3 = this.f120331i;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatarIv");
            } else {
                imageView = imageView3;
            }
            instance.attach(imageView, icon, R.drawable.ojy, WxaIconTransformation.INSTANCE);
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.d
        public void c(String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            TextView textView = null;
            if (title.length() == 0) {
                TextView textView2 = this.f120327e;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNoContentTv");
                } else {
                    textView = textView2;
                }
                textView.setText(this.f120323a.getText(R.string.f170972mh));
                return;
            }
            TextView textView3 = this.f120328f;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleTv");
            } else {
                textView = textView3;
            }
            textView.setText(title);
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.d
        public void d() {
            k();
            ImageView imageView = this.f120335m;
            ImageView imageView2 = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayIv");
                imageView = null;
            }
            imageView.setVisibility(8);
            ImageView imageView3 = this.f120336n;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStopIv");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setVisibility(0);
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.d
        public void a() {
            i();
            j();
            View view = this.f120325c;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
                view = null;
            }
            com.tencent.luggage.wxa.po.a.a(view, WxaMusicActivity.INSTANCE.a(), !m.a(r1.a()));
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.d
        public void c() {
            TextView textView = this.f120327e;
            LinearLayout linearLayout = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNoContentTv");
                textView = null;
            }
            textView.setVisibility(0);
            TextView textView2 = this.f120330h;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNameTv");
                textView2 = null;
            }
            textView2.setVisibility(4);
            LinearLayout linearLayout2 = this.f120329g;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWxaInfoLl");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(8);
            LinearLayout linearLayout3 = this.f120332j;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOperationLl");
            } else {
                linearLayout = linearLayout3;
            }
            linearLayout.setVisibility(8);
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.d
        public void b() {
            a(8);
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.d
        public void a(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            TextView textView = this.f120330h;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNameTv");
                textView = null;
            }
            textView.setText(name);
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.d
        public void a(int i3, int i16) {
            MusicSeekBar musicSeekBar = this.f120333k;
            MusicSeekBar musicSeekBar2 = null;
            if (musicSeekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
                musicSeekBar = null;
            }
            musicSeekBar.setProgress(i3);
            MusicSeekBar musicSeekBar3 = this.f120333k;
            if (musicSeekBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            } else {
                musicSeekBar2 = musicSeekBar3;
            }
            musicSeekBar2.setMaxProgress(i16);
        }

        public final void a(int i3) {
            int i16 = this.f120323a.getResources().getDisplayMetrics().heightPixels / i3;
            LinearLayout linearLayout = this.f120329g;
            View view = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWxaInfoLl");
                linearLayout = null;
            }
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(0, 0, 0, i16);
            linearLayout.setLayoutParams(layoutParams2);
            LinearLayout linearLayout2 = this.f120332j;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOperationLl");
                linearLayout2 = null;
            }
            ViewGroup.LayoutParams layoutParams3 = linearLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            layoutParams4.setMargins(0, i16, 0, 0);
            linearLayout2.setLayoutParams(layoutParams4);
            MusicSeekBar musicSeekBar = this.f120333k;
            if (musicSeekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            } else {
                view = musicSeekBar;
            }
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) layoutParams5;
            layoutParams6.setMargins(0, 0, 0, i16 / 2);
            view.setLayoutParams(layoutParams6);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c implements e {

        /* renamed from: a, reason: collision with root package name */
        public final Activity f120346a;

        public c(Activity mContext) {
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            this.f120346a = mContext;
        }

        public final void a(int i3, boolean z16) {
            com.tencent.luggage.wxa.p9.h hVar = new com.tencent.luggage.wxa.p9.h();
            h.a aVar = hVar.f137468d;
            aVar.f137469a = i3;
            aVar.f137473e = "";
            aVar.f137470b = k.f().a();
            h.a aVar2 = hVar.f137468d;
            aVar2.f137476h = "not from app brand appid";
            aVar2.f137474f = z16;
            hVar.a(Looper.getMainLooper());
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.e
        public void c() {
            if (k.f().b().c()) {
                k.f().b().a();
            }
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.e
        public void close() {
            this.f120346a.finish();
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.e
        public void d() {
            Toast.makeText(this.f120346a, "not support", 0).show();
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.e
        public void e() {
            k.f().a(true);
            a(13, k.f().b().k());
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.e
        public void next() {
            k.f().a(true);
            a(14, k.f().b().k());
        }

        @Override // com.tencent.luggage.ui.WxaMusicActivity.e
        public void stop() {
            a.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface d {
        View a(Context context);

        void a();

        void a(int i3, int i16);

        void a(String str);

        void b();

        void b(String str);

        void c();

        void c(String str);

        void d();

        void e();

        void f();

        void g();

        void h();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface e {
        void c();

        void close();

        void d();

        void e();

        void next();

        void stop();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class f implements d.a {
        public f() {
        }

        @Override // com.tencent.luggage.wxa.sm.d.a
        public final void a(int i3, int i16) {
            Message message = new Message();
            message.what = 1;
            WxaMusicActivity.this.updateMusicHandler.a(message);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class g extends b0 {
        public g(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.luggage.wxa.tn.b0
        public void d(Message message) {
            Intrinsics.checkNotNullParameter(message, "message");
            if (message.what == 1) {
                WxaMusicActivity.this.i();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.luggage.ui.WxaMusicActivity$musicPlayerListener$1] */
    public WxaMusicActivity() {
        final com.tencent.luggage.wxa.z8.b bVar = com.tencent.luggage.wxa.z8.b.f146383a;
        this.musicPlayerListener = new IListener<com.tencent.luggage.wxa.p9.h>(bVar) { // from class: com.tencent.luggage.ui.WxaMusicActivity$musicPlayerListener$1
            @Override // com.tencent.mm.sdk.event.IListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean callback(com.tencent.luggage.wxa.p9.h event) {
                WxaMusicActivity.d f16;
                WxaMusicActivity.d f17;
                WxaMusicActivity.d f18;
                WxaMusicActivity.d f19;
                Intrinsics.checkNotNullParameter(event, "event");
                int i3 = event.f137468d.f137469a;
                if (i3 == 0 || i3 == 1) {
                    WxaMusicActivity.this.h();
                    f16 = WxaMusicActivity.this.f();
                    f16.d();
                    return false;
                }
                if (i3 == 2 || i3 == 3) {
                    WxaMusicActivity.this.h();
                    f17 = WxaMusicActivity.this.f();
                    f17.g();
                    return false;
                }
                if (i3 == 4 || i3 == 7) {
                    WxaMusicActivity.this.h();
                    f18 = WxaMusicActivity.this.f();
                    f18.e();
                    return false;
                }
                if (i3 == 8) {
                    f19 = WxaMusicActivity.this.f();
                    f19.h();
                    return false;
                }
                return false;
            }
        };
        this.updateMusicHandler = new g(Looper.getMainLooper());
        this.playProgressListener = new f();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public d e() {
        return new b(this, d());
    }

    public final d f() {
        if (this.mMusicView == null) {
            this.mMusicView = e();
        }
        d dVar = this.mMusicView;
        Intrinsics.checkNotNull(dVar);
        return dVar;
    }

    public final boolean g() {
        String str;
        com.tencent.luggage.wxa.sm.d b16;
        com.tencent.luggage.wxa.rb.c b17;
        k f16 = k.f();
        if (f16 != null && (b16 = f16.b()) != null && (b17 = b16.b()) != null) {
            str = b17.f139438f;
        } else {
            str = null;
        }
        if (str == null) {
            str = "stop";
        }
        return Intrinsics.areEqual(str, "stop");
    }

    public final void h() {
        String str;
        String str2 = "";
        if (g()) {
            f().c();
            f().c("");
            return;
        }
        com.tencent.luggage.wxa.rb.d a16 = k.f().a();
        d f16 = f();
        if (a16 != null) {
            str = a16.f139443e;
        } else {
            str = null;
        }
        if (str != null) {
            str2 = str;
        }
        f16.c(str2);
        if (a16 == null) {
            f().c();
        } else if (k.f().b().i()) {
            f().d();
        } else {
            f().g();
        }
    }

    public final void i() {
        int g16 = k.f().b().g();
        int duration = k.f().b().getDuration();
        if (g16 > 0 && duration > 0) {
            f().a(g16, duration);
        }
    }

    public final void j() {
        String str;
        boolean z16;
        com.tencent.luggage.wxa.pi.b b16 = com.tencent.luggage.wxa.pi.b.b();
        if (b16 != null) {
            str = b16.c();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !g()) {
            com.tencent.luggage.wxa.z4.g a16 = com.tencent.luggage.wxa.z4.f.a(com.tencent.luggage.wxa.z4.f.f146283b.a(), str, 0, 2, (Object) null);
            if (a16 != null) {
                d f16 = f();
                String str2 = a16.c().f125809b;
                Intrinsics.checkNotNullExpressionValue(str2, "initConfig.brandName");
                f16.a(str2);
                d f17 = f();
                String str3 = a16.c().f125810c;
                Intrinsics.checkNotNullExpressionValue(str3, "initConfig.iconUrl");
                f17.b(str3);
                return;
            }
            return;
        }
        f().b("");
        f().a("");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (getResources().getConfiguration().orientation == 2) {
            f().f();
        } else if (getResources().getConfiguration().orientation == 1) {
            f().b();
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, newConfig);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(f().a(this));
        f().a();
        int i3 = getResources().getConfiguration().orientation;
        if (2 == i3) {
            f().f();
        } else if (1 == i3) {
            f().b();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (!k.f().b().i()) {
            k.f().b().f();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        k.f().b().c(null);
        dead();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        k.f().b().c(this.playProgressListener);
        alive();
        i();
        h();
        j();
    }

    public e d() {
        return new c(this);
    }
}
