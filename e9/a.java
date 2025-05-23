package e9;

import android.content.Context;
import android.graphics.Rect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.activities.base.BaseFeedFragmentFeedImp;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.reborn.widget.QZonePublishSquareImageView;
import com.qzone.reborn.widget.QZoneRoundCorneredLayout;
import com.qzone.util.ToastUtil;
import com.qzone.util.ag;
import com.qzone.util.am;
import com.qzone.util.l;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AsyncImageable;
import com.qzone.widget.AsyncMarkGifImageView;
import com.qzone.widget.AsyncMarkImageView;
import com.qzone.widget.ExtendGridView;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.qzone.widget.dynamicgridview.DynamicGridView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.component.animation.rebound.Spring;
import com.tencent.component.animation.rebound.SpringConfig;
import com.tencent.component.animation.rebound.SpringListener;
import com.tencent.component.animation.rebound.SpringSystem;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.processor.NewGifDrawableSpecifiedRegionProcessor;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.GridView;
import common.config.service.QzoneConfig;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends com.qzone.widget.dynamicgridview.b<String> implements AbsListView.RecyclerListener, AbsListView.OnScrollListener {

    /* renamed from: u0, reason: collision with root package name */
    private static final SpringConfig f395888u0 = SpringConfig.fromOrigamiTensionAndFriction(60.0d, 8.0d);

    /* renamed from: v0, reason: collision with root package name */
    private static String f395889v0 = null;

    /* renamed from: w0, reason: collision with root package name */
    private static int f395890w0;
    private Context H;
    private LayoutInflater I;
    protected DynamicGridView J;
    protected i K;
    private DynamicArrayList<String> L;
    private boolean M;
    private boolean N;
    protected boolean P;
    protected int Q;
    private int R;
    private Rect S;
    private int T;
    protected f U;
    private ArrayList<f> V;
    private String W;
    private int X;
    private int Y;
    private float Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f395891a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f395892b0;

    /* renamed from: c0, reason: collision with root package name */
    protected HashMap<String, LocalMediaInfo> f395893c0;

    /* renamed from: d0, reason: collision with root package name */
    private HashMap<String, Integer> f395894d0;

    /* renamed from: e0, reason: collision with root package name */
    private HashMap<String, ShuoshuoVideoInfo> f395895e0;

    /* renamed from: f0, reason: collision with root package name */
    private HashMap<String, ShuoshuoVideoInfo> f395896f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f395897g0;

    /* renamed from: h0, reason: collision with root package name */
    private ConcurrentHashMap<String, float[]> f395898h0;

    /* renamed from: i0, reason: collision with root package name */
    private ConcurrentHashMap<String, ArrayList<String>> f395899i0;

    /* renamed from: j0, reason: collision with root package name */
    private HashMap<String, String> f395900j0;

    /* renamed from: k0, reason: collision with root package name */
    private ArrayList<Integer> f395901k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f395902l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f395903m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f395904n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f395905o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f395906p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f395907q0;

    /* renamed from: r0, reason: collision with root package name */
    protected View.OnClickListener f395908r0;

    /* renamed from: s0, reason: collision with root package name */
    private String f395909s0;

    /* renamed from: t0, reason: collision with root package name */
    private String f395910t0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            f fVar = (f) view.getTag();
            if (fVar != null && (iVar = a.this.K) != null) {
                iVar.c(fVar.f395931p);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (a.this.J != null) {
                f fVar = (f) view.getTag();
                if (!a.E() ? !(fVar == null || fVar.f395920e.getVisibility() != 0) : !(fVar == null || fVar.f395918c.getVisibility() != 0)) {
                    if (a.this.M && (iVar = a.this.K) != null) {
                        iVar.b();
                    } else {
                        a aVar = a.this;
                        DynamicGridView dynamicGridView = aVar.J;
                        View view2 = fVar.f395916a;
                        int i3 = fVar.f395931p;
                        dynamicGridView.performItemClick(view2, i3, aVar.getItemId(i3));
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f395915a;

        static {
            int[] iArr = new int[LoadState.values().length];
            f395915a = iArr;
            try {
                iArr[LoadState.STATE_DOWNLOAD_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f395915a[LoadState.STATE_DECODE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f395915a[LoadState.STATE_DOWNLOAD_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public View f395916a;

        /* renamed from: b, reason: collision with root package name */
        public QZoneRoundCorneredLayout f395917b;

        /* renamed from: c, reason: collision with root package name */
        public QZonePublishSquareImageView f395918c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f395919d;

        /* renamed from: e, reason: collision with root package name */
        public AsyncMarkGifImageView f395920e;

        /* renamed from: f, reason: collision with root package name */
        public ViewGroup f395921f;

        /* renamed from: g, reason: collision with root package name */
        public ImageView f395922g;

        /* renamed from: h, reason: collision with root package name */
        public ViewGroup f395923h;

        /* renamed from: i, reason: collision with root package name */
        public TextView f395924i;

        /* renamed from: j, reason: collision with root package name */
        public ImageView f395925j;

        /* renamed from: k, reason: collision with root package name */
        TextView f395926k;

        /* renamed from: l, reason: collision with root package name */
        TextView f395927l;

        /* renamed from: m, reason: collision with root package name */
        public LinearLayout f395928m;

        /* renamed from: n, reason: collision with root package name */
        public ProgressBar f395929n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f395930o;

        /* renamed from: p, reason: collision with root package name */
        public int f395931p;

        /* renamed from: q, reason: collision with root package name */
        public AsyncImageView f395932q;

        /* renamed from: r, reason: collision with root package name */
        public View f395933r;

        /* renamed from: s, reason: collision with root package name */
        public ImageView f395934s;

        /* renamed from: t, reason: collision with root package name */
        public RelativeLayout f395935t;

        /* renamed from: u, reason: collision with root package name */
        public RoundCorneredFrameLayout f395936u;

        /* renamed from: v, reason: collision with root package name */
        public TextView f395937v;

        public f(View view, Context context, boolean z16, boolean z17, boolean z18) {
            this.f395916a = view;
            this.f395920e = (AsyncMarkGifImageView) view.findViewById(R.id.f69973k7);
            this.f395918c = (QZonePublishSquareImageView) view.findViewById(R.id.f69963k6);
            this.f395917b = (QZoneRoundCorneredLayout) view.findViewById(R.id.f69943k4);
            this.f395919d = (ImageView) view.findViewById(R.id.f69953k5);
            this.f395934s = (ImageView) view.findViewById(R.id.f166509fp4);
            this.f395921f = (ViewGroup) view.findViewById(R.id.hta);
            this.f395922g = (ImageView) view.findViewById(R.id.ht_);
            this.f395923h = (ViewGroup) view.findViewById(R.id.ht8);
            this.f395924i = (TextView) view.findViewById(R.id.ht9);
            this.f395925j = (ImageView) view.findViewById(R.id.hth);
            this.f395926k = (TextView) view.findViewById(R.id.htg);
            this.f395927l = (TextView) view.findViewById(R.id.htd);
            this.f395929n = (ProgressBar) view.findViewById(R.id.hte);
            this.f395932q = (AsyncImageView) view.findViewById(R.id.ht7);
            this.f395928m = (LinearLayout) view.findViewById(R.id.f166110ee2);
            if (a.f395890w0 == 0 && !TextUtils.isEmpty(a.f395889v0)) {
                this.f395932q.setAsyncImage(a.f395889v0);
                this.f395932q.setDefaultImage(R.drawable.g7_);
            }
            a(z18);
            rn.h.a(this.f395932q, "qui_image", R.color.qui_common_icon_secondary);
            this.f395932q.applyDefaultImage();
            this.f395933r = view.findViewById(R.id.htf);
            this.f395935t = (RelativeLayout) view.findViewById(R.id.f69933k3);
            this.f395936u = (RoundCorneredFrameLayout) view.findViewById(R.id.f68793h0);
            this.f395937v = (TextView) view.findViewById(R.id.f68783gz);
            if (a.E()) {
                this.f395918c.setVisibility(0);
                this.f395920e.setVisibility(8);
            } else {
                this.f395918c.setVisibility(8);
                this.f395920e.setVisibility(0);
            }
        }

        private void a(boolean z16) {
            QZonePublishSquareImageView qZonePublishSquareImageView;
            if (this.f395920e == null || (qZonePublishSquareImageView = this.f395918c) == null || this.f395923h == null || !z16) {
                return;
            }
            int i3 = fd.a.f398303b;
            qZonePublishSquareImageView.setRoundRect(i3);
            this.f395920e.setCornerRadius(i3);
            ViewGroup viewGroup = this.f395923h;
            if (viewGroup instanceof QZoneRoundCorneredLayout) {
                ((QZoneRoundCorneredLayout) viewGroup).setRadius(i3, i3, i3, i3);
            }
            this.f395917b.setRadius(i3, i3, i3, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    private class h implements IPicLoadStateListener {
        h() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            String url = option.getUrl();
            int i3 = e.f395915a[loadState.ordinal()];
            if (i3 != 1) {
                if (i3 == 2 || i3 == 3) {
                    a.i0("load image failed, url:" + option.getUrl());
                    if (url != null && url.equals(a.this.W) && a.this.L.contains(a.this.W)) {
                        a.this.L.remove(a.this.W);
                        a.this.notifyDataSetChanged();
                        ToastUtil.r(BaseApplication.getContext().getResources().getText(R.string.f171171cu3));
                    }
                }
            } else if (url != null && url.equals(a.this.W) && a.this.L.contains(a.this.W)) {
                a.this.L.remove(a.this.W);
                String d16 = com.tencent.mobileqq.qzone.picload.c.a().d(option);
                if (!TextUtils.isEmpty(d16)) {
                    a.this.L.add(d16);
                }
            }
            if (loadState.isFinishSuccess() && option.getAnimatable() != null && BaseFeedFragmentFeedImp.w()) {
                option.getAnimatable().start();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static abstract class i {
        public abstract boolean a();

        public abstract boolean b();

        public abstract boolean c(int i3);

        public abstract void d();

        public abstract void e();

        public boolean f(View view) {
            return true;
        }
    }

    public a(Context context, DynamicGridView dynamicGridView, int i3, float f16, int i16) {
        super(context);
        this.M = false;
        this.N = true;
        this.P = true;
        this.Q = 0;
        this.R = -1;
        this.T = 0;
        this.V = new ArrayList<>();
        this.W = "";
        this.X = -1;
        this.Y = -1;
        this.Z = -1.0f;
        this.f395891a0 = false;
        this.f395892b0 = false;
        this.f395897g0 = true;
        this.f395898h0 = new ConcurrentHashMap<>();
        this.f395899i0 = new ConcurrentHashMap<>();
        this.f395901k0 = new ArrayList<>();
        this.f395905o0 = true;
        this.f395907q0 = 0;
        this.f395908r0 = new c();
        this.f395909s0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewPhotoOrVideo", "\u7167\u7247/\u89c6\u9891");
        this.f395910t0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewPhoto", "\u9009\u62e9\u7167\u7247");
        this.H = context;
        this.I = LayoutInflater.from(context);
        this.J = dynamicGridView;
        dynamicGridView.setRecyclerListener(this);
        this.J.setOnScrollListener(this);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.apm);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.apn);
        this.J.setHoverCellPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        this.J.setHorizontalSpacing(ViewUtils.dpToPx(2.0f));
        this.J.setVerticalSpacing(ViewUtils.dpToPx(2.0f));
        this.Q = this.J.R();
        this.S = QzoneConfig.getInstance().getGifDisplayConfig();
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_SHUOSHUO_CAMERA_ICON, "");
        f395889v0 = config;
        if (!TextUtils.isEmpty(config)) {
            LpReportInfo_pf00064.allReport(586, 33, 4);
        }
        this.Y = i3;
        this.Z = f16;
        this.f395891a0 = false;
        f395890w0 = i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(View view, float f16, float f17) {
        view.setPivotX(f16);
        view.setPivotY(f17);
    }

    static /* bridge */ /* synthetic */ boolean E() {
        return K();
    }

    private void E0(View view, float f16, float f17) {
        view.setScaleX(f16);
        view.setScaleY(f17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(View view) {
        i iVar = this.K;
        if (iVar == null || this.M || !this.f395892b0) {
            return;
        }
        this.f395892b0 = false;
        iVar.f(view);
    }

    private static boolean K() {
        if (!RFWApplication.isPublicVersion()) {
            return gd.a.f401926a.c("KEY_ENABLE_NEW_PUBLISH_GRID_VIEW_PIC", true);
        }
        return com.qzone.reborn.configx.g.f53821a.b().W();
    }

    private String O(String str) {
        ShuoshuoVideoInfo shuoshuoVideoInfo;
        HashMap<String, ShuoshuoVideoInfo> hashMap = this.f395895e0;
        return (hashMap == null || !hashMap.containsKey(str) || (shuoshuoVideoInfo = this.f395895e0.get(str)) == null || TextUtils.isEmpty(shuoshuoVideoInfo.mCoverUrl)) ? str : shuoshuoVideoInfo.mCoverUrl;
    }

    private String P(String str) {
        ShuoshuoVideoInfo shuoshuoVideoInfo;
        HashMap<String, ShuoshuoVideoInfo> hashMap = this.f395895e0;
        if (hashMap != null && hashMap.containsKey(str) && (shuoshuoVideoInfo = this.f395895e0.get(str)) != null && !TextUtils.isEmpty(shuoshuoVideoInfo.mCoverUrl)) {
            return shuoshuoVideoInfo.mCoverUrl;
        }
        return "";
    }

    private int S(ExtendGridView extendGridView) {
        if (this.R <= 0) {
            int width = extendGridView.getWidth();
            if (width <= 0) {
                width = ((WindowManager) this.H.getSystemService("window")).getDefaultDisplay().getWidth();
            }
            int numColumns = width / extendGridView.getNumColumns();
            int U = U();
            if (U <= 0) {
                this.R = numColumns;
            } else {
                int sqrt = (int) Math.sqrt((ImageManager.getInstance(this.H.getApplicationContext()).capacity() / U) / 4.0d);
                if (sqrt < numColumns) {
                    numColumns = sqrt;
                }
                this.R = numColumns;
            }
        }
        return this.R;
    }

    private int T() {
        if (this.Q <= 0 || this.Y <= 0) {
            return -1;
        }
        return Math.min((ViewUtils.getScreenHeight() - ViewUtils.dpToPx(80.0f)) / this.Q, this.Y);
    }

    private long X(String str) {
        ShuoshuoVideoInfo shuoshuoVideoInfo;
        HashMap<String, ShuoshuoVideoInfo> hashMap = this.f395895e0;
        if (hashMap == null || !hashMap.containsKey(str) || (shuoshuoVideoInfo = this.f395895e0.get(str)) == null) {
            return 0L;
        }
        return shuoshuoVideoInfo.mDuration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i0(String str) {
        QZLog.i("DynamicPhotoAdapter", 2, str);
    }

    private View k0(int i3, ViewGroup viewGroup) {
        View inflate = this.I.inflate(R.layout.bsi, (ViewGroup) null);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (this.f395905o0) {
            this.Q = this.J.S();
        }
        if (layoutParams != null && (layoutParams instanceof AbsListView.LayoutParams)) {
            int i16 = this.Q;
            layoutParams.width = i16;
            layoutParams.height = i16;
        } else {
            int i17 = this.Q;
            layoutParams = new AbsListView.LayoutParams(i17, i17);
        }
        inflate.setLayoutParams(layoutParams);
        f fVar = new f(inflate, this.H, this.D, this.f395904n0, this.f395905o0);
        this.U = fVar;
        inflate.setTag(fVar);
        this.U.f395922g.setContentDescription(l.a(R.string.f171915lu3));
        int itemViewType = getItemViewType(i3);
        if (itemViewType == 0 || 2 == itemViewType) {
            f fVar2 = this.U;
            fVar2.f395930o = false;
            fVar2.f395921f.setTag(fVar2);
            this.U.f395921f.setVisibility(4);
            this.U.f395921f.setOnClickListener(new b());
            int S = S(this.J) - 10;
            int i18 = S > 0 ? S : 100;
            if (S <= 0) {
                S = 100;
            }
            if (K()) {
                this.U.f395918c.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.U.f395918c.setAdjustViewBounds(false);
                this.U.f395918c.setRequestWidth(i18);
                this.U.f395918c.setRequestHeight(S);
            } else {
                this.U.f395920e.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.U.f395920e.setAdjustViewBounds(false);
                this.U.f395920e.setDefaultImage(R.drawable.asd);
                this.U.f395920e.setAsyncClipSize(i18, S);
            }
            if (!this.V.contains(this.U)) {
                this.V.add(this.U);
            }
        } else if (1 == itemViewType) {
            this.U.f395930o = true;
            i iVar = this.K;
            boolean z16 = (iVar == null || iVar.a()) ? false : true;
            this.U.f395923h.setVisibility(z16 ? 8 : 0);
            this.U.f395921f.setVisibility(8);
            if (K()) {
                this.U.f395918c.setScaleType(ImageView.ScaleType.FIT_XY);
                this.U.f395918c.setImageDrawable(null);
                this.U.f395918c.setContentDescription(BaseApplication.getContext().getText(R.string.gq_));
                this.U.f395918c.setFocusable(true);
                this.U.f395918c.setVisibility(z16 ? 8 : 0);
                f fVar3 = this.U;
                fVar3.f395918c.setTag(fVar3);
                this.U.f395918c.setOnClickListener(this.f395908r0);
            } else {
                this.U.f395920e.setScaleType(ImageView.ScaleType.FIT_XY);
                this.U.f395920e.setImageDrawable(null);
                this.U.f395920e.setContentDescription(BaseApplication.getContext().getText(R.string.gq_));
                this.U.f395920e.setFocusable(true);
                if (j0()) {
                    this.U.f395920e.setAsyncImageProcessor(new RoundCornerProcessor(ViewUtils.dpToPx(4.0f)));
                }
                this.U.f395920e.setVisibility(z16 ? 8 : 0);
                f fVar4 = this.U;
                fVar4.f395920e.setTag(fVar4);
                this.U.f395920e.setOnClickListener(this.f395908r0);
            }
            this.U.f395933r.setVisibility(this.f395902l0 ? 0 : 8);
            c0();
        }
        return inflate;
    }

    private void l0() {
        if (!this.J.T() || Math.abs(this.V.size() - U()) > 5) {
            this.V.clear();
            int childCount = this.J.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.J.getChildAt(i3);
                if (childAt != null && (childAt.getTag() instanceof f)) {
                    f fVar = (f) childAt.getTag();
                    if (!fVar.f395930o) {
                        this.V.add(fVar);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(int i3) {
        if (this.N && this.f395891a0 && i3 > 1) {
            this.f395891a0 = false;
            this.f395892b0 = true;
        }
    }

    public void A0(HashMap<String, Integer> hashMap) {
        this.f395894d0 = hashMap;
    }

    public void B0(HashMap<String, ShuoshuoVideoInfo> hashMap) {
        this.f395896f0 = hashMap;
    }

    public void C0(HashMap<String, ShuoshuoVideoInfo> hashMap) {
        this.f395895e0 = hashMap;
    }

    public void G0(boolean z16) {
        this.f395902l0 = z16;
        notifyDataSetChanged();
    }

    public void H0(int i3) {
        this.f395901k0.add(Integer.valueOf(i3));
        DynamicGridView dynamicGridView = this.J;
        View a16 = dynamicGridView.a1(dynamicGridView.getItemIdAtPosition(i3));
        if (a16 != null) {
            Object tag = a16.getTag();
            if (tag instanceof f) {
                ((f) tag).f395929n.setVisibility(0);
            }
        }
    }

    public void I() {
        ConcurrentHashMap<String, float[]> concurrentHashMap = this.f395898h0;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    protected boolean I0() {
        return true;
    }

    public int J(DynamicGridView dynamicGridView, int i3) {
        int verticalSpacing;
        int paddingBottom;
        int numColumns = dynamicGridView.getNumColumns();
        if (numColumns != 0 && i3 >= numColumns) {
            int i16 = i3 / numColumns;
            if (i3 % numColumns != 0) {
                i16++;
            }
            int T = T();
            if (T <= 0 || i16 <= T) {
                T = i16;
            }
            if (T < i16) {
                float f16 = this.Z;
                if (f16 > 1.0f) {
                    verticalSpacing = ((int) (f16 * this.Q * T)) + (dynamicGridView.getVerticalSpacing() * T) + dynamicGridView.getPaddingTop();
                    paddingBottom = dynamicGridView.getPaddingBottom();
                    return verticalSpacing + paddingBottom;
                }
            }
            if (T < i16) {
                float f17 = this.Z;
                if (f17 > 0.0f) {
                    verticalSpacing = ((int) (f17 * this.Q * T)) + (dynamicGridView.getVerticalSpacing() * (T - 1)) + dynamicGridView.getPaddingTop();
                    paddingBottom = dynamicGridView.getPaddingBottom();
                    return verticalSpacing + paddingBottom;
                }
            }
            verticalSpacing = (this.Q * T) + (dynamicGridView.getVerticalSpacing() * (T - 1)) + dynamicGridView.getPaddingTop();
            paddingBottom = dynamicGridView.getPaddingBottom();
            return verticalSpacing + paddingBottom;
        }
        return this.Q + dynamicGridView.getPaddingTop() + dynamicGridView.getPaddingBottom();
    }

    protected void K0(int i3) {
        f fVar;
        String Z = Z(i3);
        if (!this.f395906p0 || (fVar = this.U) == null) {
            return;
        }
        if (fVar.f395936u != null && fVar.f395937v != null) {
            if (i3 == U() - 1 && this.f395907q0 > 0) {
                this.U.f395936u.setVisibility(0);
                this.U.f395936u.setRadius(fd.a.f398303b);
                this.U.f395936u.setOnClickListener(new d());
                this.U.f395937v.setText(Marker.ANY_NON_NULL_MARKER + this.f395907q0);
            } else {
                this.U.f395936u.setVisibility(8);
            }
        }
        String P = P(Z);
        f fVar2 = this.U;
        if (fVar2.f395925j == null || fVar2.f395926k == null || fVar2.f395920e == null || fVar2.f395918c == null) {
            return;
        }
        if (TextUtils.isEmpty(P)) {
            this.U.f395925j.setVisibility(8);
            this.U.f395926k.setVisibility(8);
            return;
        }
        long X = X(Z);
        if (K()) {
            this.U.f395918c.d(W(P));
        } else {
            this.U.f395920e.setAsyncImage(W(P));
        }
        this.U.f395925j.setVisibility(0);
        this.U.f395926k.setVisibility(0);
        this.U.f395926k.setText(ag.i(X));
    }

    public void L(boolean z16) {
        if (this.M) {
            return;
        }
        this.M = true;
        this.J.setAllowHorizontalMoveStartDrag(true);
        this.J.setNeedUpdateHoverCellAfterZoomOut(true);
        if (z16) {
            ((Vibrator) k().getSystemService("vibrator")).vibrate(300L);
        }
        i iVar = this.K;
        if (iVar != null) {
            iVar.d();
        }
        if (U() <= 0) {
            return;
        }
        l0();
        Spring addListener = SpringSystem.create().createSpring().setSpringConfig(f395888u0).addListener(new C10223a());
        addListener.setCurrentValue(0.0d);
        addListener.setEndValue(1.0d);
    }

    public HashMap<String, String> N() {
        return this.f395900j0;
    }

    public int Q() {
        return this.P ? 1 : 0;
    }

    @Override // com.qzone.widget.dynamicgridview.b, android.widget.Adapter
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public String getItem(int i3) {
        if (f0(i3)) {
            return (String) super.getItem(i3);
        }
        return null;
    }

    public int U() {
        int count = getCount() - Q();
        if (count >= 0) {
            return count;
        }
        return 0;
    }

    public ArrayList<String> V() {
        return (ArrayList) n();
    }

    public String W(String str) {
        HashMap<String, String> hashMap = this.f395900j0;
        if (hashMap != null && hashMap.containsKey(str) && this.f395900j0.get(str) != null) {
            String str2 = this.f395900j0.get(str);
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return str;
    }

    protected int Y() {
        return R.drawable.nyb;
    }

    public String Z(int i3) {
        return getItem(i3);
    }

    public ArrayList<Integer> a0() {
        return this.f395901k0;
    }

    public void b0(int i3) {
        this.f395901k0.remove(Integer.valueOf(i3));
        DynamicGridView dynamicGridView = this.J;
        View a16 = dynamicGridView.a1(dynamicGridView.getItemIdAtPosition(i3));
        if (a16 != null) {
            Object tag = a16.getTag();
            if (tag instanceof f) {
                ((f) tag).f395929n.setVisibility(8);
            }
        }
    }

    @Override // com.qzone.widget.dynamicgridview.b, com.qzone.widget.dynamicgridview.d
    public boolean c(int i3) {
        return !d0(i3);
    }

    public boolean d0(int i3) {
        if (!this.P) {
            return false;
        }
        if (this.D) {
            return i3 == 0;
        }
        int U = U();
        int count = getCount();
        return U > 0 ? i3 == count - 1 : i3 == count + (-1) || i3 == count + (-2);
    }

    public boolean e0() {
        return this.M;
    }

    public boolean f0(int i3) {
        return this.D ? i3 > 0 && i3 < getCount() : i3 >= 0 && i3 < U();
    }

    public boolean g0(int i3) {
        return this.f395901k0.contains(Integer.valueOf(i3));
    }

    @Override // com.qzone.widget.dynamicgridview.b, android.widget.Adapter
    public int getCount() {
        return super.getCount() + Q();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        if (d0(i3)) {
            return 1;
        }
        String Z = Z(i3);
        int i16 = (this.D && Z != null && Z.endsWith(".mp4")) ? 2 : 0;
        HashMap<String, LocalMediaInfo> hashMap = this.f395893c0;
        if (hashMap != null && hashMap.size() > 0 && this.f395893c0.containsKey(Z)) {
            LocalMediaInfo localMediaInfo = this.f395893c0.get(Z);
            if (QAlbumUtil.getMediaType(localMediaInfo) == 1 || (localMediaInfo != null && localMediaInfo.mMediaType == 1)) {
                i16 = 2;
            }
        }
        HashMap<String, ShuoshuoVideoInfo> hashMap2 = this.f395896f0;
        if (hashMap2 == null || hashMap2.size() <= 0 || !this.f395896f0.containsKey(Z)) {
            return i16;
        }
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        boolean z16;
        LocalMediaInfo localMediaInfo;
        boolean z17;
        LocalMediaInfo localMediaInfo2;
        ImageProcessor specifiedSizeCropByPivotProcessor;
        String d16;
        if (this.f60840m && view != null && j(i3)) {
            f fVar = (f) view.getTag();
            this.U = fVar;
            if (fVar.f395931p == i3) {
                if (K()) {
                    d16 = this.U.f395918c.getOption().getUrl();
                } else {
                    d16 = this.U.f395920e.d();
                }
                String str = "";
                if (d16 == null) {
                    d16 = "";
                }
                if (!ArrayUtils.isOutOfArrayIndex(i3, this.L)) {
                    str = this.L.get(i3);
                }
                String P = P(str);
                if ((!am.h(d16) && !am.h(str) && d16.equals(str)) || (!am.h(d16) && !am.h(P) && d16.equals(P))) {
                    return view;
                }
                i0("cur url: " + d16 + " not equals to actual url:" + str + ", need rebind data");
            }
        }
        if (view != null && view.getTag() == this.U) {
            this.U = (f) view.getTag();
            z16 = false;
        } else {
            view = k0(i3, viewGroup);
            z16 = true;
        }
        if ((viewGroup instanceof GridView) && ((GridView) viewGroup).mIsOnMeasure) {
            return view;
        }
        this.U.f395931p = i3;
        int itemViewType = getItemViewType(i3);
        if (itemViewType == 0) {
            E0(this.U.f395922g, 1.0f, 1.0f);
            this.U.f395921f.setVisibility(this.M ? 0 : 4);
            String Z = Z(i3);
            HashMap<String, Integer> hashMap = this.f395894d0;
            if (hashMap != null && hashMap.get(Z) != null) {
                Integer num = this.f395894d0.get(Z);
                if (num != null) {
                    int intValue = num.intValue();
                    if (intValue != 2 && intValue != 1) {
                        this.U.f395934s.setVisibility(8);
                    } else {
                        this.U.f395934s.setVisibility(0);
                    }
                }
            } else {
                this.U.f395934s.setVisibility(8);
            }
            if (!TextUtils.isEmpty(Z)) {
                boolean b16 = o7.b.b(Z);
                if (K()) {
                    this.U.f395918c.setDefaultLoadListener(new h());
                    this.U.f395918c.d(W(Z));
                    if (b16 && !BaseFeedFragmentFeedImp.w()) {
                        this.U.f395919d.setVisibility(0);
                    } else {
                        this.U.f395919d.setVisibility(8);
                    }
                } else {
                    if (b16) {
                        this.U.f395920e.setNeedGifStream(BaseFeedFragmentFeedImp.w());
                        int i16 = this.Q;
                        specifiedSizeCropByPivotProcessor = new NewGifDrawableSpecifiedRegionProcessor(i16, i16, this.S);
                    } else {
                        this.U.f395920e.setNeedGifStream(false);
                        int i17 = this.Q;
                        specifiedSizeCropByPivotProcessor = new SpecifiedSizeCropByPivotProcessor(i17, i17, 0.5f, 0.5f);
                    }
                    if (j0()) {
                        RoundCornerProcessor roundCornerProcessor = new RoundCornerProcessor(ViewUtils.dpToPx(4.0f));
                        roundCornerProcessor.setPreProcessor(specifiedSizeCropByPivotProcessor);
                        specifiedSizeCropByPivotProcessor = roundCornerProcessor;
                    }
                    this.U.f395920e.setAsyncImageProcessor(specifiedSizeCropByPivotProcessor);
                    if (!this.f60840m && z16) {
                        this.U.f395920e.setDefaultImage(R.drawable.asd);
                    }
                    if (this.T != 2) {
                        if (this.f395903m0) {
                            ImageLoader.getInstance().clear(Z);
                        }
                        this.U.f395920e.setAsyncImage(W(Z));
                    } else {
                        this.U.f395920e.setAsyncImage(null);
                    }
                    if (b16 && !BaseFeedFragmentFeedImp.w()) {
                        this.U.f395920e.setMarker(R.drawable.f162226g25);
                        this.U.f395920e.setMarkerPosition(4);
                        this.U.f395920e.setMarkerVisible(true);
                    } else {
                        this.U.f395920e.setMarkerVisible(false);
                    }
                    this.U.f395920e.setTag(Z);
                    this.U.f395920e.setAsyncImageListener(new g());
                }
                this.U.f395927l.setVisibility(8);
            }
            this.U.f395925j.setVisibility(8);
            this.U.f395926k.setVisibility(8);
        } else if (1 == itemViewType) {
            i iVar = this.K;
            boolean z18 = (iVar == null || iVar.a()) ? false : true;
            this.U.f395923h.setVisibility(z18 ? 8 : 0);
            if (K()) {
                this.U.f395918c.setVisibility(z18 ? 8 : 0);
            } else {
                this.U.f395920e.setVisibility(z18 ? 8 : 0);
            }
            this.U.f395933r.setVisibility(this.f395902l0 ? 0 : 8);
            if (!this.D) {
                if (this.f395897g0) {
                    this.U.f395924i.setText(this.f395909s0);
                } else {
                    this.U.f395924i.setText(this.f395910t0);
                }
            }
            this.U.f395925j.setVisibility(8);
            this.U.f395926k.setVisibility(8);
            this.U.f395927l.setVisibility(8);
        } else if (2 == itemViewType) {
            this.U.f395921f.setVisibility(this.M ? 0 : 4);
            String Z2 = Z(i3);
            if (j0()) {
                this.U.f395920e.setAsyncImageProcessor(new RoundCornerProcessor(ViewUtils.dpToPx(4.0f)));
            }
            if (K()) {
                this.U.f395918c.setDefaultLoadListener(new h());
            }
            HashMap<String, ShuoshuoVideoInfo> hashMap2 = this.f395896f0;
            if (hashMap2 != null && hashMap2.containsKey(Z2)) {
                ShuoshuoVideoInfo shuoshuoVideoInfo = this.f395896f0.get(Z2);
                if (shuoshuoVideoInfo != null) {
                    this.U.f395926k.setText(ag.i(shuoshuoVideoInfo.mDuration));
                    String str2 = shuoshuoVideoInfo.mCoverUrl;
                    if (K()) {
                        this.U.f395918c.d(str2);
                    } else {
                        this.U.f395920e.setAsyncImage(str2);
                    }
                    z17 = true;
                }
                z17 = false;
            } else {
                HashMap<String, ShuoshuoVideoInfo> hashMap3 = this.f395895e0;
                if (hashMap3 != null && hashMap3.containsKey(Z2)) {
                    ShuoshuoVideoInfo shuoshuoVideoInfo2 = this.f395895e0.get(Z2);
                    if (shuoshuoVideoInfo2 != null) {
                        this.U.f395926k.setText(ag.i(shuoshuoVideoInfo2.mDuration));
                        if (!TextUtils.isEmpty(shuoshuoVideoInfo2.mCoverUrl)) {
                            if (K()) {
                                this.U.f395918c.d(shuoshuoVideoInfo2.mCoverUrl);
                            } else {
                                this.U.f395920e.setAsyncImage(shuoshuoVideoInfo2.mCoverUrl);
                            }
                            z17 = true;
                        }
                    }
                } else if (this.D) {
                    this.U.f395926k.setText(ag.i(ShortVideoUtils.getDurationOfVideo(Z2)));
                } else {
                    HashMap<String, LocalMediaInfo> hashMap4 = this.f395893c0;
                    if (hashMap4 != null && hashMap4.containsKey(Z2) && (localMediaInfo = this.f395893c0.get(Z2)) != null) {
                        this.U.f395926k.setText(ag.i(localMediaInfo.mDuration));
                    }
                }
                z17 = false;
            }
            if (!z17) {
                if (K()) {
                    this.U.f395918c.e(Z2, true);
                } else {
                    this.U.f395920e.setAsyncImage(Z2);
                }
                i0("pos:" + i3 + ", cover not set! load video path:" + Z2);
            }
            this.U.f395925j.setImageResource(Y());
            this.U.f395925j.setVisibility(0);
            this.U.f395926k.setVisibility(I0() ? 0 : 8);
            this.U.f395927l.setVisibility(8);
            J0(Z2, this.f395893c0);
        }
        if (g0(i3)) {
            this.U.f395929n.setVisibility(0);
        } else {
            this.U.f395929n.setVisibility(8);
        }
        if (i3 == 1 && this.N) {
            if (K()) {
                F0(this.U.f395918c);
            } else {
                F0(this.U.f395920e);
            }
        }
        if (u5.a.e() && 1 != itemViewType) {
            String Z3 = Z(i3);
            HashMap<String, LocalMediaInfo> hashMap5 = this.f395893c0;
            if (hashMap5 != null && hashMap5.containsKey(Z3) && (localMediaInfo2 = this.f395893c0.get(Z3)) != null) {
                String createContentDescription = PhotoUtils.createContentDescription(QAlbumUtil.getMediaType(localMediaInfo2), localMediaInfo2, i3);
                if (K()) {
                    this.U.f395918c.setContentDescription(createContentDescription);
                } else {
                    this.U.f395920e.setContentDescription(createContentDescription);
                }
            }
        }
        K0(i3);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public boolean h0(int i3) {
        return getItemViewType(i3) == 2;
    }

    protected boolean j0() {
        return false;
    }

    public void n0(HashMap<String, String> hashMap) {
        this.f395900j0 = hashMap;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        int U = U();
        if (this.Y > 0 && !this.J.T()) {
            int count = getCount();
            int numColumns = this.Y * this.J.getNumColumns();
            int i3 = this.X;
            if (count != i3 && (i3 <= numColumns || count <= numColumns)) {
                ViewGroup.LayoutParams layoutParams = this.J.getLayoutParams();
                layoutParams.height = J(this.J, count);
                this.J.setLayoutParams(layoutParams);
            }
            this.X = count;
        }
        i iVar = this.K;
        if (iVar != null) {
            iVar.e();
        }
        p0(U);
        this.R = -1;
    }

    public void o0(boolean z16, boolean z17) {
        this.P = z16;
        if (z17) {
            notifyDataSetChanged();
        }
    }

    @Override // com.tencent.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        f fVar = (f) view.getTag();
        if (K() || fVar == null || fVar.f395930o || fVar.f395931p == 0) {
            return;
        }
        fVar.f395920e.cancelAsyncLoadImageWithoutListener();
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        this.T = i3;
        if (i3 == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            for (int i16 = 0; i16 < absListView.getChildCount(); i16++) {
                f fVar = (f) absListView.getChildAt(i16).getTag();
                if (fVar != null && !fVar.f395930o) {
                    String Z = Z(firstVisiblePosition + i16);
                    if (this.f395906p0) {
                        return;
                    }
                    HashMap<String, ShuoshuoVideoInfo> hashMap = this.f395896f0;
                    if (hashMap != null && hashMap.containsKey(Z)) {
                        Z = this.f395896f0.get(Z).mCoverUrl;
                    }
                    String O = O(Z);
                    if (!TextUtils.isEmpty(Z)) {
                        Z = O;
                    }
                    if (!TextUtils.isEmpty(Z)) {
                        if (K()) {
                            fVar.f395918c.d(W(Z));
                        } else {
                            fVar.f395920e.setAsyncImage(W(Z));
                        }
                    }
                }
            }
        }
    }

    public void q0(boolean z16) {
        this.f395903m0 = z16;
    }

    public void r0(boolean z16) {
        this.f395906p0 = z16;
    }

    public void s0(boolean z16) {
        this.f395905o0 = z16;
    }

    public void u0(HashMap<String, LocalMediaInfo> hashMap, HashMap<String, ShuoshuoVideoInfo> hashMap2, HashMap<String, Integer> hashMap3, boolean z16) {
        this.f395893c0 = hashMap;
        this.f395895e0 = hashMap2;
        this.f395894d0 = hashMap3;
        this.f395897g0 = z16;
    }

    public void w0(String str) {
        this.W = str;
    }

    public void x0(boolean z16) {
        this.f395904n0 = z16;
    }

    public void y0(i iVar) {
        this.K = iVar;
    }

    public void z0(int i3) {
        this.f395907q0 = i3;
    }

    /* compiled from: P */
    /* renamed from: e9.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10223a implements SpringListener {
        C10223a() {
        }

        @Override // com.tencent.component.animation.rebound.SpringListener
        public void onSpringAtRest(Spring spring) {
            if (((com.qzone.widget.dynamicgridview.b) a.this).f60840m) {
                if (a.this.N) {
                    a aVar = a.this;
                    aVar.p0(aVar.U());
                    if (a.this.V.size() > 1) {
                        if (a.E()) {
                            a aVar2 = a.this;
                            aVar2.F0(((f) aVar2.V.get(1)).f395918c);
                        } else {
                            a aVar3 = a.this;
                            aVar3.F0(((f) aVar3.V.get(1)).f395920e);
                        }
                    }
                }
                a.this.J.invalidate();
                return;
            }
            a.this.notifyDataSetChanged();
        }

        @Override // com.tencent.component.animation.rebound.SpringListener
        public void onSpringUpdate(Spring spring) {
            a.this.m0(spring);
        }

        @Override // com.tencent.component.animation.rebound.SpringListener
        public void onSpringActivate(Spring spring) {
            for (int i3 = 0; i3 < a.this.V.size(); i3++) {
                f fVar = (f) a.this.V.get(i3);
                if (fVar.f395930o) {
                    a.i0("add button is in,this should not happen, something wrong!");
                } else {
                    if (fVar.f395921f.getVisibility() != 0) {
                        fVar.f395921f.setVisibility(0);
                    }
                    a.this.D0(fVar.f395922g, r3.getRight(), fVar.f395922g.getTop());
                }
            }
        }

        @Override // com.tencent.component.animation.rebound.SpringListener
        public void onSpringEndStateChange(Spring spring) {
        }
    }

    private void M(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(it.next())) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(Spring spring) {
        if (spring == null) {
            return;
        }
        float currentValue = (float) spring.getCurrentValue();
        for (int i3 = 0; i3 < this.V.size(); i3++) {
            f fVar = this.V.get(i3);
            if (fVar.f395930o) {
                i0("add button is in,this should not happen, something wrong!");
            } else {
                if (fVar.f395921f.getVisibility() != 0) {
                    fVar.f395921f.setVisibility(0);
                }
                E0(fVar.f395922g, currentValue, currentValue);
            }
        }
    }

    public void t0(DynamicArrayList<String> dynamicArrayList) {
        if (dynamicArrayList == null) {
            return;
        }
        M(dynamicArrayList);
        this.L = dynamicArrayList;
        dynamicArrayList.setOnListWriteListener(this);
        q(dynamicArrayList);
    }

    public void v0(HashMap<String, LocalMediaInfo> hashMap) {
        if (hashMap == null) {
            return;
        }
        this.f395893c0 = hashMap;
    }

    public boolean H(View view) {
        if (view == null || !(view.getTag() instanceof f)) {
            return false;
        }
        f fVar = (f) view.getTag();
        return K() ? fVar.f395918c.getVisibility() == 0 : fVar.f395920e.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    private class g implements AsyncImageable.AsyncImageListener {
        g() {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageFailed(AsyncImageable asyncImageable) {
            String c16;
            if ((asyncImageable instanceof AsyncMarkImageView) && (c16 = ((AsyncMarkImageView) asyncImageable).c()) != null && c16.equals(a.this.W) && a.this.L.contains(a.this.W)) {
                a.this.L.remove(a.this.W);
                a.this.notifyDataSetChanged();
                ToastUtil.r(BaseApplication.getContext().getResources().getText(R.string.f171171cu3));
            }
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageLoaded(AsyncImageable asyncImageable) {
            String d16;
            if ((asyncImageable instanceof AsyncMarkImageView) && (d16 = ((AsyncMarkImageView) asyncImageable).d()) != null && d16.equals(a.this.W) && a.this.L.contains(a.this.W)) {
                a.this.L.remove(a.this.W);
                String imageFilePath = CacheManager.getImageFilePath(a.this.H, a.this.W);
                if (TextUtils.isEmpty(imageFilePath)) {
                    return;
                }
                a.this.L.add(imageFilePath);
            }
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageStarted(AsyncImageable asyncImageable) {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageProgress(AsyncImageable asyncImageable, float f16) {
        }
    }

    protected void c0() {
    }

    public a(Context context, DynamicGridView dynamicGridView, int i3, float f16, int i16, boolean z16) {
        super(context);
        this.M = false;
        this.N = true;
        this.P = true;
        this.Q = 0;
        this.R = -1;
        this.T = 0;
        this.V = new ArrayList<>();
        this.W = "";
        this.X = -1;
        this.Y = -1;
        this.Z = -1.0f;
        this.f395891a0 = false;
        this.f395892b0 = false;
        this.f395897g0 = true;
        this.f395898h0 = new ConcurrentHashMap<>();
        this.f395899i0 = new ConcurrentHashMap<>();
        this.f395901k0 = new ArrayList<>();
        this.f395905o0 = true;
        this.f395907q0 = 0;
        this.f395908r0 = new c();
        this.f395909s0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewPhotoOrVideo", "\u7167\u7247/\u89c6\u9891");
        this.f395910t0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewPhoto", "\u9009\u62e9\u7167\u7247");
        this.H = context;
        this.I = LayoutInflater.from(context);
        this.J = dynamicGridView;
        dynamicGridView.setRecyclerListener(this);
        this.J.setOnScrollListener(this);
        this.D = z16;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.apm);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.apn);
        this.J.setHoverCellPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        this.J.setHorizontalSpacing(ViewUtils.dpToPx(2.0f));
        this.J.setVerticalSpacing(ViewUtils.dpToPx(2.0f));
        this.Q = this.J.R();
        this.S = QzoneConfig.getInstance().getGifDisplayConfig();
        f395889v0 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_SHUOSHUO_CAMERA_ICON, "");
        this.Y = i3;
        this.Z = f16;
        this.f395891a0 = false;
        f395890w0 = i16;
    }

    protected void J0(String str, HashMap<String, LocalMediaInfo> hashMap) {
    }

    public a(Context context, DynamicGridView dynamicGridView, int i3, float f16, int i16, boolean z16, boolean z17) {
        this(context, dynamicGridView, i3, f16, i16, z16);
        this.f395905o0 = z17;
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
    }
}
