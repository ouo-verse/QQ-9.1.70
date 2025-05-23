package com.qzone.album.ui.widget;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {

    /* renamed from: a0, reason: collision with root package name */
    public static final String f44291a0 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_ARCHIVE_MEMORY, QzoneConfig.SECONDARY_MEMOEY_COVER_URL, "https://qzonestyle.gtimg.cn/aoi/sola/20190329163959_MjiOsvgXQa.png");

    /* renamed from: b0, reason: collision with root package name */
    public static final String f44292b0 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_UGC_EMPTY_PAGE, QzoneConfig.SECONDARYUGC_EMPTY_DEFAULT_PAGE, "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png");

    /* renamed from: c0, reason: collision with root package name */
    public static final String f44293c0 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_UGC_EMPTY_PAGE, QzoneConfig.SECONDARYUGC_EMPTY_NO_NETWORK_PAGE, "https://qzonestyle.gtimg.cn/aoi/sola/20190329164139_M5hX693Wjo.png");

    /* renamed from: d0, reason: collision with root package name */
    private static final int f44294d0 = ar.e(157.0f);
    protected View S;
    protected AsyncImageView T;
    protected TextView U;
    protected TextView V;
    protected TextView W;
    protected RelativeLayout X;
    protected int Y;
    com.qzone.album.env.common.c Z;

    /* renamed from: a, reason: collision with root package name */
    String f44295a = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageNoAlbumTitle", "\u641c\u96c6\u6240\u6709\u7f8e\u597d\uff0c\u9001\u7ed9\u672a\u6765\u7684\u81ea\u5df1");

    /* renamed from: b, reason: collision with root package name */
    String f44296b = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageNoAlbumTitleGuest", "\u597d\u53cb\u6ca1\u6709\u521b\u5efa\u8fc7\u76f8\u518c\u54e6");

    /* renamed from: c, reason: collision with root package name */
    String f44297c = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageNoAlbumContentGuest", "\u521b\u5efa\u591a\u4eba\u76f8\u518c\uff0c\u9080 TA \u5171\u540c\u8bb0\u5f55\u65f6\u5149");

    /* renamed from: d, reason: collision with root package name */
    String f44298d = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumNewAlbumOpContent", "\u65b0\u5efa\u76f8\u518c");

    /* renamed from: e, reason: collision with root package name */
    String f44299e = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumRecentPhotoTitle", "\u7528\u7167\u7247\uff0c\u5b9a\u683c\u56de\u5fc6\u7559\u4f4f\u611f\u52a8");

    /* renamed from: f, reason: collision with root package name */
    String f44300f = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumRecentPhotoTitleGuest", "\u597d\u53cb\u6ca1\u6709\u4e0a\u4f20\u8fc7\u7167\u7247\u54e6");

    /* renamed from: g, reason: collision with root package name */
    String f44301g = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumRecentPhotoTitleContentGuest", "\u544a\u8bc9 TA \u7167\u7247\u548c\u771f\u4eba\u90fd\u5f88\u7f8e");

    /* renamed from: h, reason: collision with root package name */
    String f44302h = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumRecentVideoTitle", "\u7528\u89c6\u9891\uff0c\u8bb0\u5f55\u5149\u9634\u73cd\u85cf\u8fc7\u5f80");

    /* renamed from: i, reason: collision with root package name */
    String f44303i = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumRecentVideoTitleGuest", "\u7528\u89c6\u9891\uff0c\u8bb0\u5f55\u5149\u9634\u73cd\u85cf\u8fc7\u5f80");

    /* renamed from: j, reason: collision with root package name */
    String f44304j = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumRecentVideoTitleContentGuest", "\u4e0e TA \u4e00\u8d77\u62cd\u6bb5\u89c6\u9891\uff0c\u8bb0\u5f55\u751f\u6d3b\u7684\u5149\u5f71");

    /* renamed from: k, reason: collision with root package name */
    String f44305k = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageNoFaceTitle", "\u7167\u7247\u91cc\u7684\u8138\u6709\u70b9\u795e\u79d8");

    /* renamed from: l, reason: collision with root package name */
    String f44306l = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageNoFaceContent", "\u4e0a\u4f20\u66f4\u591a\u4eba\u50cf\u4e30\u5bcc\u4f60\u7684\u76f8\u518c");

    /* renamed from: m, reason: collision with root package name */
    String f44307m = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageNoAddressTitle", "\u4f60\u7684\u8db3\u8ff9\u7559\u5728\u4e86\u8352\u829c\u4e4b\u5730");

    /* renamed from: n, reason: collision with root package name */
    String f44308n = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageNoAddressContent", "\u8bf7\u5728\u8bbe\u5907\u4e2d\u5f00\u542f\u4f4d\u7f6e\u5b9a\u4f4d");

    /* renamed from: o, reason: collision with root package name */
    String f44309o = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageNoCategoryTitle", "\u6ca1\u6709\u627e\u5230\u4efb\u4f55\u5206\u7c7b");

    /* renamed from: p, reason: collision with root package name */
    String f44310p = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageNoCategoryContent", "\u4e0a\u4f20\u66f4\u591a\u7167\u7247\uff0c\u8bb0\u5f55\u751f\u6d3b\u8bb0\u5fc6");

    /* renamed from: q, reason: collision with root package name */
    String f44311q = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageNoPhotoTitle", "\u7528\u7167\u7247\uff0c\u5b9a\u683c\u56de\u5fc6\u7559\u4f4f\u611f\u52a8");

    /* renamed from: r, reason: collision with root package name */
    String f44312r = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageNoPhotoTitleGuest", "\u597d\u53cb\u6ca1\u6709\u4e0a\u4f20\u8fc7\u7167\u7247\u54e6");

    /* renamed from: s, reason: collision with root package name */
    String f44313s = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageNoPhotoContentGuest", "\u544a\u8bc9 TA \u7167\u7247\u548c\u771f\u4eba\u90fd\u5f88\u7f8e");

    /* renamed from: t, reason: collision with root package name */
    String f44314t = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageNoPhotoUploadPhotoAndVideoText", "\u4e0a\u4f20\u7167\u7247");

    /* renamed from: u, reason: collision with root package name */
    String f44315u = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageNoPhotoUploadVideoText", "\u4e0a\u4f20\u89c6\u9891");

    /* renamed from: v, reason: collision with root package name */
    String f44316v = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageNoNetworkTitle", "\u65e0\u6cd5\u8fde\u63a5\u5230\u4e92\u8054\u7f51");

    /* renamed from: w, reason: collision with root package name */
    String f44317w = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageNoNetworkContent", "\u8bf7\u5173\u95ed\u98de\u884c\u6a21\u5f0f\u6216\u68c0\u67e5\u8bbe\u5907\u7684\u7f51\u7edc\u8bbe\u7f6e");

    /* renamed from: x, reason: collision with root package name */
    String f44318x = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageErrorTitle", "\u6ca1\u6709\u627e\u5230\u4efb\u4f55\u5f71\u50cf\u54e6");

    /* renamed from: y, reason: collision with root package name */
    String f44319y = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageErrorContent", "\u8bf7\u518d\u6b21\u52a0\u8f7d\u9875\u9762\u8bd5\u8bd5\u5427");

    /* renamed from: z, reason: collision with root package name */
    String f44320z = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageUploadErrorText", "\u91cd\u65b0\u52a0\u8f7d");
    String A = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageFaceModeTitle", "\u6ca1\u6709\u88ab\u5708\u51fa\u7684\u7167\u7247");
    String B = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageJoinTilte", "\u76f8\u518c\u91cc\u6682\u65f6\u6ca1\u6709\u5f71\u50cf\u54e6");
    String C = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageJoinContent", "\u5feb\u548c\u597d\u53cb\u4e00\u8d77\u4e0a\u4f20\u7167\u7247/\u89c6\u9891\u5427");
    String D = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoPageJoinOpButton", "\u52a0\u5165\u76f8\u518c");
    String E = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoSearchNoDataTitle", "\u76f8\u518c\u65e0\u53ef\u4f9b\u68c0\u7d22\u7684\u5185\u5bb9");
    String F = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoSearchNoDataContent", "\u5230\u5176\u4ed6\u76f8\u518c\u8bd5\u8bd5\u4e5f\u8bb8\u6709\u610f\u5916\u6536\u83b7");
    String G = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoSearchResultNoDataTitle", "\u6ca1\u6709\u627e\u5230\u7b26\u5408\u7684\u5f71\u50cf");
    String H = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoSearchResultNoDataContent", "\u8bf7\u66f4\u6362\u5176\u4ed6\u6761\u4ef6\u8bd5\u8bd5");
    String I = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoGroupDetailNoPhotoTiltle", "\u6b64\u76f8\u518c\u6ca1\u6709\u7167\u7247");
    String J = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoGroupDetailNoPhotoContent", "\u67e5\u770b\u5e76\u9009\u62e9\u5176\u4ed6\u76f8\u518c\u5427");
    String K = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "albumChooseNoTitle", "\u641c\u96c6\u6240\u6709\u7f8e\u597d\uff0c\u9001\u7ed9\u672a\u6765\u7684\u81ea\u5df1");
    String L = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumLocalPhotoTitle", "\u6682\u65e0\u63a8\u8350\u7684\u7167\u7247\u96c6");
    String M = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumLocalPhotoContentTitle", "\u8fd1\u671f\u62cd\u7684\u7167\u7247\u592a\u5c11\uff0c\u591a\u62cd\u4e9b\u7167\u7247\u8bd5\u8bd5\u5427");
    String N = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumLocalPhotoSwitchTitle", "\u5f00\u542f\u624b\u673a\u7167\u7247\u63a2\u7d22\u4e4b\u65c5");
    String O = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumLocalPhotoSwitchContent", "\u5141\u8bb8\u7a7a\u95f4\u8bbf\u95ee\u4f60\u7684\u624b\u673a\u76f8\u518c\uff0c\u6839\u636e\u672c\u5730\u7167\u7247\u7684\n\u65f6\u95f4\u3001\u5730\u70b9\u7b49\u4fe1\u606f\u4e3a\u4f60\u6574\u7406\u7167\u7247\u96c6");
    String P = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumLocalPhotoSwitchButton", "\u7acb\u5373\u6253\u5f00");
    String Q = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "albumLoadingTitle", "\u6b63\u5728\u5237\u65b0\u4e2d");
    private int R = 0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements ViewStub.OnInflateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f44321d;

        /* compiled from: P */
        /* renamed from: com.qzone.album.ui.widget.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class ViewOnClickListenerC0353a implements View.OnClickListener {
            ViewOnClickListenerC0353a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                int i3 = c.this.R;
                if (i3 == 1 || i3 == 3) {
                    a.this.f44321d.a();
                } else if (i3 == 5) {
                    a.this.f44321d.refresh();
                } else if (i3 != 8) {
                    a.this.f44321d.a();
                } else {
                    a.this.f44321d.b();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        a(b bVar) {
            this.f44321d = bVar;
        }

        @Override // android.view.ViewStub.OnInflateListener
        public void onInflate(ViewStub viewStub, View view) {
            c.this.S = view;
            view.setClickable(true);
            c.this.T = (AsyncImageView) view.findViewById(R.id.bwf);
            c.this.X = (RelativeLayout) view.findViewById(R.id.uu9);
            ViewGroup.LayoutParams layoutParams = c.this.T.getLayoutParams();
            if (layoutParams.height > view.getResources().getDisplayMetrics().heightPixels / 2) {
                int i3 = view.getResources().getDisplayMetrics().heightPixels / 2;
                layoutParams.height = i3;
                layoutParams.width = i3;
            }
            c.this.U = (TextView) view.findViewById(R.id.bwu);
            c.this.V = (TextView) view.findViewById(R.id.bwd);
            c.this.W = (TextView) view.findViewById(R.id.k7p);
            c.this.W.setOnClickListener(new ViewOnClickListenerC0353a());
            if (!c.this.Z.Ta()) {
                c.this.l(0);
            } else {
                c.this.l(6);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void a();

        void b();

        void refresh();
    }

    public c(com.qzone.album.env.common.c cVar, b bVar) {
        ViewStub viewStub;
        this.Y = 0;
        if (cVar != null && ((cVar.getRootView() != null || cVar.getCurrentActivity() != null) && cVar.R3() != null)) {
            com.qzone.album.env.common.a.m().b("[PhotoAlbum]emptyViewController", "init EmptyViewController");
            this.Z = cVar;
            if (cVar.getRootView() != null) {
                viewStub = (ViewStub) cVar.getRootView().findViewById(R.id.flr);
            } else {
                viewStub = this.Z.getCurrentActivity() != null ? (ViewStub) cVar.getCurrentActivity().findViewById(R.id.flr) : null;
            }
            this.S = viewStub;
            if (this.Z.getCurrentActivity() != null) {
                this.Y = this.Z.getCurrentActivity().getResources().getDisplayMetrics().heightPixels;
            }
            if (viewStub != null) {
                viewStub.setOnInflateListener(new a(bVar));
                this.Z.R3().setEmptyView(this.S);
                return;
            }
            return;
        }
        com.qzone.album.env.common.a.m().b("[PhotoAlbum]emptyViewController", "controller == null Or others null");
    }

    private void c() {
        if (QQTheme.isNowSimpleUI()) {
            this.W.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0099FF")));
        }
    }

    private boolean f(int i3) {
        if (i3 != 14 && i3 != 1 && i3 != 6) {
            return true;
        }
        return false;
    }

    private void h() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.T.getLayoutParams();
        com.qzone.album.env.common.a.m().b("[PhotoAlbum]emptyViewController", "resetMarginTop=", Integer.valueOf(this.Y));
        int i3 = this.Y;
        if (i3 != 0) {
            layoutParams.topMargin = i3 / 4;
        } else if (this.V.getVisibility() == 8) {
            if (this.W.getVisibility() == 8) {
                layoutParams.topMargin = ar.e(215.0f);
            } else {
                layoutParams.topMargin = ar.e(179.0f);
            }
        } else if (this.W.getVisibility() == 8) {
            layoutParams.topMargin = ar.e(199.0f);
        } else {
            layoutParams.topMargin = f44294d0;
        }
        this.T.setLayoutParams(layoutParams);
    }

    public void b(RelativeLayout relativeLayout, View view, TextView textView) {
        s5.a.i(relativeLayout);
        s5.a.h(view);
        s5.a.m(textView);
    }

    public String d() {
        if (QQTheme.isNowThemeIsNightForQzone()) {
            return "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_night_icon.png";
        }
        return "https://downv6.qq.com/video_story/qzone/qzone_forbidden_page_icon.png";
    }

    public View e() {
        return this.S;
    }

    public void g() {
        if (this.V != null) {
            this.U.setTextColor(Color.rgb(0, 0, 0));
            this.U.setTypeface(Typeface.DEFAULT);
        }
        TextView textView = this.V;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void i(int i3) {
        this.V.setText(i3);
    }

    public void j(String str) {
        this.V.setText(str);
    }

    public void k(String str) {
        this.U.setText(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void l(int i3) {
        this.R = i3;
        g();
        this.T.setDecodeConfig(Bitmap.Config.ARGB_8888);
        this.T.setAsyncImageProcessor(new z4.a());
        switch (i3) {
            case 0:
                this.T.setAsyncImage(f44293c0);
                this.U.setText(this.f44316v);
                this.V.setText(this.f44317w);
                this.W.setVisibility(8);
                break;
            case 1:
                this.T.setAsyncImage(f44292b0);
                if (this.Z.P2()) {
                    this.U.setText(this.f44312r);
                    this.V.setText(this.f44313s);
                } else {
                    this.U.setText(this.f44311q);
                    this.V.setVisibility(8);
                }
                this.W.setText(this.f44314t);
                break;
            case 2:
                this.T.setAsyncImage(f44292b0);
                if (this.Z.P2()) {
                    this.U.setText(this.f44312r);
                    this.V.setText(this.f44313s);
                } else {
                    this.U.setText(this.f44311q);
                    this.V.setVisibility(8);
                }
                this.W.setVisibility(8);
                break;
            case 3:
                this.T.setAsyncImage(f44292b0);
                if (!this.Z.P2()) {
                    this.U.setText(this.f44302h);
                    this.V.setVisibility(8);
                    this.W.setText(this.f44315u);
                    break;
                } else {
                    this.U.setText(this.f44303i);
                    this.V.setText(this.f44304j);
                    this.W.setVisibility(8);
                    break;
                }
            case 4:
                this.T.setAsyncImage(f44292b0);
                if (!this.Z.P2()) {
                    this.U.setText(this.f44302h);
                    this.V.setVisibility(8);
                } else {
                    this.U.setText(this.f44303i);
                    this.V.setText(this.f44304j);
                }
                this.W.setVisibility(8);
                break;
            case 5:
                this.T.setAsyncImage(f44292b0);
                this.U.setText(this.f44318x);
                this.V.setText(this.f44319y);
                this.W.setText(this.f44320z);
                break;
            case 6:
                this.T.setAsyncImage(f44292b0);
                this.U.setText(this.Q);
                this.U.setTextColor(Color.rgb(102, 102, 102));
                this.U.setTypeface(Typeface.DEFAULT);
                this.V.setVisibility(8);
                this.W.setVisibility(8);
                break;
            case 7:
                this.T.setAsyncImage(f44292b0);
                this.U.setText(this.A);
                this.V.setVisibility(8);
                this.W.setVisibility(8);
                break;
            case 8:
                this.T.setAsyncImage(f44292b0);
                this.U.setText(this.B);
                this.V.setText(this.C);
                this.W.setText(this.D);
                break;
            case 9:
            case 13:
            default:
                com.qzone.album.env.common.a.m().b("[PhotoAlbum]emptyViewController", "setType=", Integer.valueOf(i3), " type is not defined");
                break;
            case 10:
                this.T.setAsyncImage(d());
                if (!this.Z.P2()) {
                    this.U.setText(this.f44295a);
                    this.V.setVisibility(8);
                    this.W.setText(this.f44298d);
                    this.W.setVisibility(0);
                    c();
                    break;
                } else {
                    this.U.setText(this.f44296b);
                    this.V.setText(this.f44297c);
                    this.W.setVisibility(8);
                    break;
                }
            case 11:
                this.T.setAsyncImage(d());
                if (!this.Z.P2()) {
                    this.U.setText(this.f44299e);
                    this.V.setVisibility(8);
                    this.W.setText(this.f44314t);
                    this.W.setVisibility(0);
                    c();
                    break;
                } else {
                    this.U.setText(this.f44300f);
                    this.V.setText(this.f44301g);
                    this.W.setVisibility(8);
                    break;
                }
            case 12:
                this.T.setAsyncImage(d());
                if (!this.Z.P2()) {
                    this.U.setText(this.f44302h);
                    this.V.setVisibility(8);
                    this.W.setVisibility(0);
                    this.W.setText(this.f44315u);
                    c();
                    break;
                } else {
                    this.U.setText(this.f44303i);
                    this.V.setText(this.f44304j);
                    this.W.setVisibility(8);
                    break;
                }
            case 14:
                this.T.setAsyncImage(f44292b0);
                this.U.setText(this.E);
                this.V.setText(this.F);
                this.W.setVisibility(8);
                break;
            case 15:
                this.T.setAsyncImage(f44292b0);
                this.U.setText(this.G);
                this.V.setText(this.H);
                this.W.setVisibility(8);
                break;
            case 16:
                this.T.setAsyncImage(f44292b0);
                this.U.setText(this.I);
                this.V.setText(this.J);
                this.W.setVisibility(8);
                break;
            case 17:
                if (this.Z.P2()) {
                    this.T.setAsyncImage(f44291a0);
                    this.U.setText(this.f44300f);
                    this.V.setText(this.f44301g);
                    this.W.setVisibility(8);
                    break;
                }
                break;
            case 18:
                if (this.Z.P2()) {
                    this.T.setAsyncImage(f44291a0);
                    this.U.setText(this.f44303i);
                    this.V.setText(this.f44304j);
                    this.W.setVisibility(8);
                    break;
                }
                break;
            case 19:
                this.T.setAsyncImage(f44292b0);
                this.U.setText(this.f44305k);
                this.V.setText(this.f44306l);
                this.W.setVisibility(8);
                break;
            case 20:
                this.T.setAsyncImage(f44292b0);
                this.U.setText(this.f44307m);
                this.V.setText(this.f44308n);
                this.W.setVisibility(8);
                break;
            case 21:
                this.T.setAsyncImage(f44292b0);
                this.U.setText(this.f44309o);
                this.V.setText(this.f44310p);
                this.W.setVisibility(8);
                break;
            case 22:
                this.T.setAsyncImage(f44292b0);
                this.U.setText(this.K);
                this.V.setVisibility(8);
                this.W.setVisibility(8);
                break;
            case 23:
                this.T.setAsyncImage(f44292b0);
                this.U.setText(this.L);
                this.V.setText(this.M);
                this.W.setVisibility(8);
                break;
            case 24:
                this.T.setAsyncImage(f44292b0);
                this.U.setText(this.N);
                this.V.setText(this.O);
                this.W.setText(this.P);
                com.qzone.album.env.common.a.m().b("[PhotoAlbum]emptyViewController", "setType=", Integer.valueOf(i3), " type is not defined");
                break;
            case 25:
                this.T.setAsyncImage(f44292b0);
                this.U.setText(this.f44303i);
                this.V.setText(this.f44304j);
                this.W.setVisibility(8);
                break;
        }
        if (f(i3)) {
            b(this.X, this.T, this.U);
        }
        h();
    }

    public void m(boolean z16) {
        View view = this.S;
        if (view != null) {
            view.setVisibility(z16 ? 0 : 8);
        }
    }

    public void n(boolean z16) {
        this.W.setVisibility(z16 ? 0 : 8);
    }
}
