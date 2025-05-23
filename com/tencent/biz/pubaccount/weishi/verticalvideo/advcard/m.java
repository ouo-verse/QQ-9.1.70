package com.tencent.biz.pubaccount.weishi.verticalvideo.advcard;

import UserGrowth.stAcquisitionInfo;
import UserGrowth.stFeedIconOpConf;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.WSThreeSegmentDownloadHelper;
import com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.m;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006*\u0001>\u0018\u0000 \u00102\u00020\u0001:\u0001\u001cBb\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010)\u001a\u00020\t\u0012\u0006\u0010,\u001a\u00020\u0005\u0012\b\b\u0002\u0010/\u001a\u00020\u0011\u0012%\b\u0002\u00105\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0007\u0018\u000100\u00a2\u0006\u0004\bA\u0010BJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0003J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u001a\u001a\u00020\u0007R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R1\u00105\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010.R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010:R\u0014\u0010=\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u0014\u0010@\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010?\u00a8\u0006C"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/m;", "", "", "highLightType", "", "", "l", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSDownloadStatus;", "status", "v", "progress", "u", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "itemData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "p", "o", DomainData.DOMAIN_NAME, "j", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "i", "r", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "a", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "fragment", "Landroid/widget/FrameLayout;", "b", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/widget/ProgressButton;", "c", "Lcom/tencent/mobileqq/widget/ProgressButton;", "progressBtn", "d", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSDownloadStatus;", "initStatus", "e", "Ljava/lang/String;", "position", "f", "Z", "isFromBigCard", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "g", "Lkotlin/jvm/functions/Function1;", "onStateChangeCallback", tl.h.F, "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "isHighLightStatus", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "firstRunnable", "k", "secondRunnable", "com/tencent/biz/pubaccount/weishi/verticalvideo/advcard/m$c", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/m$c;", "onDownloadResult", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;Landroid/widget/FrameLayout;Lcom/tencent/mobileqq/widget/ProgressButton;Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSDownloadStatus;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final WSVerticalPageFragment fragment;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final FrameLayout container;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ProgressButton progressBtn;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final WSDownloadStatus initStatus;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String position;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isFromBigCard;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Function1<WSDownloadStatus, Unit> onStateChangeCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.biz.pubaccount.weishi.verticalvideo.data.j itemData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isHighLightStatus;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Runnable firstRunnable;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final Runnable secondRunnable;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final c onDownloadResult;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes32.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f81902a;

        static {
            int[] iArr = new int[WSDownloadStatus.values().length];
            try {
                iArr[WSDownloadStatus.Downloading.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WSDownloadStatus.Pause.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f81902a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/pubaccount/weishi/verticalvideo/advcard/m$c", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSThreeSegmentDownloadHelper$a;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSDownloadStatus;", "status", "", "a", "", "progress", "onProgress", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c implements WSThreeSegmentDownloadHelper.a {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(m this$0, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.u(i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(m this$0, WSDownloadStatus status) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(status, "$status");
            Function1 function1 = this$0.onStateChangeCallback;
            if (function1 != null) {
                function1.invoke(status);
            }
            this$0.v(status);
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.WSThreeSegmentDownloadHelper.a
        public void a(final WSDownloadStatus status) {
            Intrinsics.checkNotNullParameter(status, "status");
            FrameLayout frameLayout = m.this.container;
            final m mVar = m.this;
            frameLayout.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.n
                @Override // java.lang.Runnable
                public final void run() {
                    m.c.e(m.this, status);
                }
            });
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.WSThreeSegmentDownloadHelper.a
        public void onProgress(final int progress) {
            FrameLayout frameLayout = m.this.container;
            final m mVar = m.this;
            frameLayout.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.o
                @Override // java.lang.Runnable
                public final void run() {
                    m.c.d(m.this, progress);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(WSVerticalPageFragment wSVerticalPageFragment, FrameLayout container, ProgressButton progressBtn, WSDownloadStatus initStatus, String position, boolean z16, Function1<? super WSDownloadStatus, Unit> function1) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(progressBtn, "progressBtn");
        Intrinsics.checkNotNullParameter(initStatus, "initStatus");
        Intrinsics.checkNotNullParameter(position, "position");
        this.fragment = wSVerticalPageFragment;
        this.container = container;
        this.progressBtn = progressBtn;
        this.initStatus = initStatus;
        this.position = position;
        this.isFromBigCard = z16;
        this.onStateChangeCallback = function1;
        this.firstRunnable = new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.j
            @Override // java.lang.Runnable
            public final void run() {
                m.k(m.this);
            }
        };
        this.secondRunnable = new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.k
            @Override // java.lang.Runnable
            public final void run() {
                m.t(m.this);
            }
        };
        this.onDownloadResult = new c();
        progressBtn.setMacProgress(100);
        progressBtn.setProgressDrawable(progressBtn.a(r.g(R.color.f77655)));
        progressBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.d(m.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(m this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
    }

    private final Context i() {
        return this.container.getContext();
    }

    private final WSDownloadStatus j() {
        return WSThreeSegmentDownloadHelper.f81856a.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(m this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isHighLightStatus = false;
        this$0.container.setVisibility(0);
        this$0.progressBtn.setVisibility(0);
        WSVerticalPageFragment wSVerticalPageFragment = this$0.fragment;
        if (wSVerticalPageFragment != null) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.W(wSVerticalPageFragment.getFrom(), wSVerticalPageFragment.getPlayScene(), this$0.position, this$0.itemData, false, this$0.l(0));
        }
    }

    private final void m(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j itemData) {
        WSVerticalPageFragment wSVerticalPageFragment;
        if (o() && (wSVerticalPageFragment = this.fragment) != null) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.W(wSVerticalPageFragment.getFrom(), wSVerticalPageFragment.getPlayScene(), this.position, itemData, false, l(1));
        }
    }

    private final boolean o() {
        return this.initStatus == WSDownloadStatus.Init;
    }

    private final boolean p() {
        return this.initStatus == WSDownloadStatus.Init && j() == WSDownloadStatus.Download;
    }

    private final void q() {
        this.progressBtn.removeCallbacks(this.secondRunnable);
        WSVerticalPageFragment wSVerticalPageFragment = this.fragment;
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = this.itemData;
        String str = this.position;
        boolean z16 = this.isHighLightStatus;
        i.d(wSVerticalPageFragment, jVar, str, 2, z16 ? 1 : 0, this.isFromBigCard);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(m this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isHighLightStatus = true;
        this$0.v(WSDownloadStatus.Download);
        WSVerticalPageFragment wSVerticalPageFragment = this$0.fragment;
        if (wSVerticalPageFragment != null) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.W(wSVerticalPageFragment.getFrom(), wSVerticalPageFragment.getPlayScene(), this$0.position, this$0.itemData, false, this$0.l(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(int progress) {
        this.progressBtn.setProgress(progress);
        this.progressBtn.setText(progress + "%");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(WSDownloadStatus status) {
        if (status.getContainerBackgroundResId() == 0) {
            this.container.setBackground(null);
        } else {
            this.container.setBackgroundResource(status.getContainerBackgroundResId());
        }
        this.progressBtn.setBackgroundResource(status.getBtnResId());
        int i3 = b.f81902a[status.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                ProgressButton progressButton = this.progressBtn;
                DownloadInfo e16 = WSThreeSegmentDownloadHelper.f81856a.e();
                progressButton.setProgress(e16 != null ? e16.Q : 0);
            }
            if (status.getDesResId() == 0) {
                this.progressBtn.setText("");
            } else {
                this.progressBtn.setText(status.getDesResId());
            }
        }
    }

    public final void r(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j itemData) {
        WSDownloadStatus f16;
        this.itemData = itemData;
        WSThreeSegmentDownloadHelper wSThreeSegmentDownloadHelper = WSThreeSegmentDownloadHelper.f81856a;
        WSThreeSegmentDownloadHelper.m(wSThreeSegmentDownloadHelper, null, this.onDownloadResult, 1, null);
        if (com.tencent.biz.qqstory.utils.l.c(i())) {
            m(itemData);
            f16 = WSDownloadStatus.Installed;
        } else if (p()) {
            n(itemData);
            f16 = WSDownloadStatus.Init;
        } else {
            m(itemData);
            f16 = wSThreeSegmentDownloadHelper.f();
        }
        x.i("WSThreeSegmentDownloadViewController", "onPageSelected initStatus:" + this.initStatus + ", status:" + f16 + "    " + this);
        v(f16);
    }

    public final void s() {
        this.progressBtn.removeCallbacks(this.secondRunnable);
        WSThreeSegmentDownloadHelper.r(WSThreeSegmentDownloadHelper.f81856a, null, this.onDownloadResult, 1, null);
    }

    private final Map<String, String> l(int highLightType) {
        Map<String, String> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("download_btn_status", String.valueOf(highLightType)), TuplesKt.to("btn_status", String.valueOf(j().getType())));
        return mutableMapOf;
    }

    private final void n(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j itemData) {
        Number number;
        stSimpleMetaFeed e16;
        stAcquisitionInfo stacquisitioninfo;
        stFeedIconOpConf stfeediconopconf;
        stSimpleMetaFeed e17;
        stAcquisitionInfo stacquisitioninfo2;
        stFeedIconOpConf stfeediconopconf2;
        int i3 = (itemData == null || (e17 = itemData.e()) == null || (stacquisitioninfo2 = e17.acquisitionInfo) == null || (stfeediconopconf2 = stacquisitioninfo2.feedIconOpConf) == null) ? 0 : stfeediconopconf2.second;
        this.progressBtn.postDelayed(this.firstRunnable, i3);
        if (itemData != null && (e16 = itemData.e()) != null && (stacquisitioninfo = e16.acquisitionInfo) != null && (stfeediconopconf = stacquisitioninfo.feedIconOpConf) != null) {
            number = Integer.valueOf(stfeediconopconf.second);
        } else {
            number = 3000L;
        }
        this.progressBtn.postDelayed(this.secondRunnable, Math.max(number.longValue(), 3000L));
        x.i("WSThreeSegmentDownloadViewController", "handleThreeSegmentUI firstDelay:" + i3 + ", secondDelay:" + number + "    " + this);
    }

    public /* synthetic */ m(WSVerticalPageFragment wSVerticalPageFragment, FrameLayout frameLayout, ProgressButton progressButton, WSDownloadStatus wSDownloadStatus, String str, boolean z16, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(wSVerticalPageFragment, frameLayout, progressButton, wSDownloadStatus, str, (i3 & 32) != 0 ? false : z16, (i3 & 64) != 0 ? null : function1);
    }
}
