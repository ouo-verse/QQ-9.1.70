package com.tencent.sqshow.zootopia.aigc.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.widget.pag.ZPlanPAGLoader;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.ttpic.videoshelf.data.Constants;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.db;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.light.LightEngine;
import tl.h;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 d2\u00020\u0001:\u0001eB'\b\u0007\u0012\u0006\u0010^\u001a\u00020]\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010_\u0012\b\b\u0002\u0010a\u001a\u00020\u0004\u00a2\u0006\u0004\bb\u0010cJE\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J4\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0019j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u001a2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J\u0010\u0010\u001c\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0012\u0010\u001f\u001a\u00020\u000b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u0018\u0010#\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020!JA\u0010$\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b$\u0010\rJ \u0010%\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020!J\u0006\u0010&\u001a\u00020\u000bJ\b\u0010'\u001a\u00020\u000bH\u0014J\u0006\u0010(\u001a\u00020\u000bR\u0017\u0010-\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010*\u001a\u0004\b+\u0010,R$\u00103\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00107\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010.\u001a\u0004\b5\u00100\"\u0004\b6\u00102R$\u0010;\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010.\u001a\u0004\b9\u00100\"\u0004\b:\u00102R>\u0010B\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0019j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010I\u001a\u00020C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010O\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\b8\u0010L\"\u0004\bM\u0010NR$\u0010U\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\b<\u0010R\"\u0004\bS\u0010TR$\u0010\\\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[\u00a8\u0006f"}, d2 = {"Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", "Landroid/widget/FrameLayout;", "", Constants.PAG_FILE_PATH, "", "repeatCount", "imageIdex", "Landroid/graphics/Bitmap;", "image", "Lorg/libpag/PAGView$PAGViewListener;", "listener", "", "d", "(Ljava/lang/String;ILjava/lang/Integer;Landroid/graphics/Bitmap;Lorg/libpag/PAGView$PAGViewListener;)V", "pagFile0Path", "pagFile1Path", "e", "Lorg/libpag/PAGView;", "pagView", "Lorg/libpag/PAGFile;", "pag0", "pag1", "p", "enterPagUrl", "loopPagUrl", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "o", "setPagListener", "Landroid/view/View;", "outerPlaceHolderView", "setOuterPlaceHolderView", "pagUrl", "", "enablePlay", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "w", NodeProps.ON_DETACHED_FROM_WINDOW, HippyTKDListViewAdapter.X, "Ln74/db;", "Ln74/db;", "g", "()Ln74/db;", "mBinding", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "setMLocalPagUrl", "(Ljava/lang/String;)V", "mLocalPagUrl", "f", "j", "setMLocalEnterPagUrl", "mLocalEnterPagUrl", h.F, "k", "setMLocalLoopPagUrl", "mLocalLoopPagUrl", "i", "Ljava/util/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/util/HashMap;", "setMLocalPagUrlMap", "(Ljava/util/HashMap;)V", "mLocalPagUrlMap", "Lvk3/a;", "Lvk3/a;", "getMPagDownloadListener", "()Lvk3/a;", "setMPagDownloadListener", "(Lvk3/a;)V", "mPagDownloadListener", BdhLogUtil.LogTag.Tag_Conn, "Z", "()Z", "setMEnablePlay", "(Z)V", "mEnablePlay", "D", "Lorg/libpag/PAGView$PAGViewListener;", "()Lorg/libpag/PAGView$PAGViewListener;", "setMListener", "(Lorg/libpag/PAGView$PAGViewListener;)V", "mListener", "E", "Landroid/view/View;", DomainData.DOMAIN_NAME, "()Landroid/view/View;", "setMOuterPlaceholderView", "(Landroid/view/View;)V", "mOuterPlaceholderView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SuitPagView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mEnablePlay;

    /* renamed from: D, reason: from kotlin metadata */
    private PAGView.PAGViewListener mListener;

    /* renamed from: E, reason: from kotlin metadata */
    private View mOuterPlaceholderView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final db mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mLocalPagUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String mLocalEnterPagUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String mLocalLoopPagUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, String> mLocalPagUrlMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private vk3.a mPagDownloadListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SuitPagView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(String pagFilePath, int repeatCount, Integer imageIdex, Bitmap image, PAGView.PAGViewListener listener) {
        setPagListener(listener);
        this.mBinding.f419203c.api().postAction(new SuitPagView$doPlay$1(image, pagFilePath, repeatCount, imageIdex, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(String pagFile0Path, String pagFile1Path) {
        if (!TextUtils.isEmpty(pagFile0Path) && new File(pagFile0Path).exists()) {
            if (!TextUtils.isEmpty(pagFile1Path) && new File(pagFile1Path).exists()) {
                this.mBinding.f419203c.api().postAction(new SuitPagView$doPlay$2(pagFile0Path, pagFile1Path, this));
                return;
            }
            QLog.e("SuitPagView", 1, "pagFile0Path " + pagFile1Path + " is null or not exists");
            return;
        }
        QLog.e("SuitPagView", 1, "pagFile0Path " + pagFile0Path + " is null or not exists");
    }

    private final HashMap<String, String> o(String enterPagUrl, String loopPagUrl) {
        HashMap<String, String> hashMap = new HashMap<>();
        ZPlanPAGLoader zPlanPAGLoader = ZPlanPAGLoader.f369875a;
        String g16 = zPlanPAGLoader.g(enterPagUrl, false);
        String g17 = zPlanPAGLoader.g(loopPagUrl, false);
        if (!TextUtils.isEmpty(g16) && !new File(g16).exists()) {
            hashMap.put(enterPagUrl, "");
        } else {
            Intrinsics.checkNotNull(g16);
            hashMap.put(enterPagUrl, g16);
        }
        if (!TextUtils.isEmpty(g17) && !new File(g17).exists()) {
            hashMap.put(loopPagUrl, "");
        } else {
            Intrinsics.checkNotNull(g17);
            hashMap.put(loopPagUrl, g17);
        }
        QLog.i("SuitPagView", 1, "getNeedDownloadUrlList size " + hashMap);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(PAGView pagView, PAGFile pag0, PAGFile pag1) {
        QLog.i("SuitPagView", 1, "initPagView - start");
        int width = pag0.width();
        int height = pag0.height();
        int width2 = pag1.width();
        int height2 = pag1.height();
        QLog.i("SuitPagView", 1, "initPagView -pag0 width " + width + ", pag0 height: " + height + " -pag1 width " + width2 + ", pag1 height: " + height2);
        PAGComposition Make = PAGComposition.Make(width2, height2);
        if (Make == null) {
            return;
        }
        long duration = pag0.duration();
        long duration2 = pag1.duration();
        QLog.i("SuitPagView", 1, "initPagView -pag0 Duration " + duration + ", pag1 Duration: " + duration2);
        pag0.setStartTime(0L);
        pag1.setStartTime(duration);
        pag1.setTimeStretchMode(2);
        pag1.setDuration(duration2 * ((long) 2500));
        Make.addLayer(pag0);
        Make.addLayer(pag1);
        pagView.setComposition(Make);
        pagView.setVisibility(0);
        pagView.setScaleMode(1);
        pagView.setRepeatCount(0);
        QLog.i("SuitPagView", 1, "initPagView - end");
    }

    /* renamed from: g, reason: from getter */
    public final db getMBinding() {
        return this.mBinding;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getMEnablePlay() {
        return this.mEnablePlay;
    }

    /* renamed from: i, reason: from getter */
    public final PAGView.PAGViewListener getMListener() {
        return this.mListener;
    }

    /* renamed from: j, reason: from getter */
    public final String getMLocalEnterPagUrl() {
        return this.mLocalEnterPagUrl;
    }

    /* renamed from: k, reason: from getter */
    public final String getMLocalLoopPagUrl() {
        return this.mLocalLoopPagUrl;
    }

    /* renamed from: l, reason: from getter */
    public final String getMLocalPagUrl() {
        return this.mLocalPagUrl;
    }

    public final HashMap<String, String> m() {
        return this.mLocalPagUrlMap;
    }

    /* renamed from: n, reason: from getter */
    public final View getMOuterPlaceholderView() {
        return this.mOuterPlaceholderView;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ZPlanPAGLoader.f369875a.k(this.mPagDownloadListener);
    }

    public final void q(String pagUrl, final int repeatCount, final Integer imageIdex, final Bitmap image, final PAGView.PAGViewListener listener) {
        Intrinsics.checkNotNullParameter(pagUrl, "pagUrl");
        QLog.i("SuitPagView", 1, "play url:" + pagUrl);
        this.mEnablePlay = true;
        this.mLocalPagUrl = pagUrl;
        ZPlanPAGLoader zPlanPAGLoader = ZPlanPAGLoader.f369875a;
        final String h16 = ZPlanPAGLoader.h(zPlanPAGLoader, pagUrl, false, 2, null);
        if (!TextUtils.isEmpty(h16) && new File(h16).exists()) {
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.aigc.view.SuitPagView$play$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    SuitPagView suitPagView = SuitPagView.this;
                    String str = h16;
                    Intrinsics.checkNotNull(str);
                    suitPagView.d(str, repeatCount, imageIdex, image, listener);
                }
            });
        } else {
            zPlanPAGLoader.k(this.mPagDownloadListener);
            zPlanPAGLoader.c(this.mPagDownloadListener);
        }
    }

    public final void r(final String enterPagUrl, final String loopPagUrl, boolean enablePlay) {
        Intrinsics.checkNotNullParameter(enterPagUrl, "enterPagUrl");
        Intrinsics.checkNotNullParameter(loopPagUrl, "loopPagUrl");
        QLog.i("SuitPagView", 1, "play enterPagUrl:" + enterPagUrl + ", loopPagUrl:" + loopPagUrl);
        this.mEnablePlay = enablePlay;
        this.mLocalEnterPagUrl = enterPagUrl;
        this.mLocalLoopPagUrl = loopPagUrl;
        this.mLocalPagUrlMap.clear();
        HashMap<String, String> o16 = o(enterPagUrl, loopPagUrl);
        this.mLocalPagUrlMap = o16;
        if (o16.size() >= 2 && !this.mLocalPagUrlMap.values().contains("")) {
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.aigc.view.SuitPagView$play$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    SuitPagView suitPagView = SuitPagView.this;
                    String str = suitPagView.m().get(enterPagUrl);
                    Intrinsics.checkNotNull(str);
                    String str2 = SuitPagView.this.m().get(loopPagUrl);
                    Intrinsics.checkNotNull(str2);
                    suitPagView.e(str, str2);
                }
            });
            return;
        }
        ZPlanPAGLoader zPlanPAGLoader = ZPlanPAGLoader.f369875a;
        zPlanPAGLoader.k(this.mPagDownloadListener);
        zPlanPAGLoader.c(this.mPagDownloadListener);
        ZPlanPAGLoader.h(zPlanPAGLoader, enterPagUrl, false, 2, null);
        ZPlanPAGLoader.h(zPlanPAGLoader, loopPagUrl, false, 2, null);
    }

    public final void s(String pagUrl, boolean enablePlay) {
        Intrinsics.checkNotNullParameter(pagUrl, "pagUrl");
        QLog.i("SuitPagView", 1, "play url:" + pagUrl);
        this.mEnablePlay = enablePlay;
        this.mLocalPagUrl = pagUrl;
        ZPlanPAGLoader zPlanPAGLoader = ZPlanPAGLoader.f369875a;
        final String h16 = ZPlanPAGLoader.h(zPlanPAGLoader, pagUrl, false, 2, null);
        if (!TextUtils.isEmpty(h16) && new File(h16).exists()) {
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.aigc.view.SuitPagView$play$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    SuitPagView suitPagView = SuitPagView.this;
                    String str = h16;
                    Intrinsics.checkNotNull(str);
                    SuitPagView.f(suitPagView, str, 0, null, null, null, 30, null);
                }
            });
        } else {
            zPlanPAGLoader.k(this.mPagDownloadListener);
            zPlanPAGLoader.c(this.mPagDownloadListener);
        }
    }

    public final void setMEnablePlay(boolean z16) {
        this.mEnablePlay = z16;
    }

    public final void setMListener(PAGView.PAGViewListener pAGViewListener) {
        this.mListener = pAGViewListener;
    }

    public final void setMLocalEnterPagUrl(String str) {
        this.mLocalEnterPagUrl = str;
    }

    public final void setMLocalLoopPagUrl(String str) {
        this.mLocalLoopPagUrl = str;
    }

    public final void setMLocalPagUrl(String str) {
        this.mLocalPagUrl = str;
    }

    public final void setMLocalPagUrlMap(HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.mLocalPagUrlMap = hashMap;
    }

    public final void setMOuterPlaceholderView(View view) {
        this.mOuterPlaceholderView = view;
    }

    public final void setMPagDownloadListener(vk3.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mPagDownloadListener = aVar;
    }

    public final void setOuterPlaceHolderView(View outerPlaceHolderView) {
        this.mOuterPlaceholderView = outerPlaceHolderView;
    }

    public final void setPagListener(final PAGView.PAGViewListener listener) {
        this.mBinding.f419203c.api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.sqshow.zootopia.aigc.view.SuitPagView$setPagListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                invoke2(pAGView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PAGView pagView) {
                Intrinsics.checkNotNullParameter(pagView, "pagView");
                if (SuitPagView.this.getMListener() != null) {
                    pagView.removeListener(SuitPagView.this.getMListener());
                }
                SuitPagView.this.setMListener(listener);
                PAGView.PAGViewListener pAGViewListener = listener;
                if (pAGViewListener != null) {
                    pagView.addListener(pAGViewListener);
                }
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SuitPagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void w() {
        QLog.i("SuitPagView", 1, "stop");
        this.mEnablePlay = false;
        this.mBinding.f419203c.api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.sqshow.zootopia.aigc.view.SuitPagView$stop$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                invoke2(pAGView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PAGView pagView) {
                Intrinsics.checkNotNullParameter(pagView, "pagView");
                pagView.stop();
            }
        });
    }

    public final void x() {
        QLog.i("SuitPagView", 1, DeviceInfoMonitor.getModel());
        LightEngine.init();
    }

    public /* synthetic */ SuitPagView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitPagView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        db g16 = db.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.mBinding = g16;
        this.mLocalPagUrlMap = new HashMap<>();
        this.mEnablePlay = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m74.a.f416405r);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026 R.styleable.SuitPagView)");
        Drawable drawable = obtainStyledAttributes.getDrawable(m74.a.f416406s);
        if (drawable != null) {
            g16.f419202b.setImageDrawable(drawable);
        }
        obtainStyledAttributes.recycle();
        g16.f419203c.api().build();
        this.mPagDownloadListener = new vk3.a() { // from class: com.tencent.sqshow.zootopia.aigc.view.SuitPagView.2
            @Override // vk3.a
            public void a(String url, final String path) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(path, "path");
                if (Intrinsics.areEqual(url, SuitPagView.this.getMLocalPagUrl()) && !TextUtils.isEmpty(path)) {
                    QLog.i("SuitPagView", 1, "onPagDownloaded url:" + url + ", path:" + path);
                    ZPlanPAGLoader.f369875a.k(this);
                    final SuitPagView suitPagView = SuitPagView.this;
                    CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.aigc.view.SuitPagView$2$onPAGDownLoaded$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            SuitPagView.f(SuitPagView.this, path, 0, null, null, null, 30, null);
                        }
                    });
                }
                if (!SuitPagView.this.m().isEmpty()) {
                    QLog.i("SuitPagView", 1, "onPagDownloaded url:" + url + ", path:" + path);
                    SuitPagView.this.m().put(url, path);
                    if (SuitPagView.this.m().values().contains("") || SuitPagView.this.getMLocalEnterPagUrl() == null || SuitPagView.this.getMLocalLoopPagUrl() == null || !SuitPagView.this.m().containsKey(SuitPagView.this.getMLocalEnterPagUrl()) || !SuitPagView.this.m().containsKey(SuitPagView.this.getMLocalLoopPagUrl())) {
                        return;
                    }
                    final SuitPagView suitPagView2 = SuitPagView.this;
                    CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.aigc.view.SuitPagView$2$onPAGDownLoaded$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            SuitPagView suitPagView3 = SuitPagView.this;
                            String str = suitPagView3.m().get(SuitPagView.this.getMLocalEnterPagUrl());
                            Intrinsics.checkNotNull(str);
                            String str2 = SuitPagView.this.m().get(SuitPagView.this.getMLocalLoopPagUrl());
                            Intrinsics.checkNotNull(str2);
                            suitPagView3.e(str, str2);
                        }
                    });
                }
            }
        };
    }

    public static /* synthetic */ void setOuterPlaceHolderView$default(SuitPagView suitPagView, View view, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            view = null;
        }
        suitPagView.setOuterPlaceHolderView(view);
    }

    public static /* synthetic */ void u(SuitPagView suitPagView, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        suitPagView.r(str, str2, z16);
    }

    public static /* synthetic */ void v(SuitPagView suitPagView, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        suitPagView.s(str, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(SuitPagView suitPagView, String str, int i3, Integer num, Bitmap bitmap, PAGView.PAGViewListener pAGViewListener, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        suitPagView.d(str, i3, (i16 & 4) != 0 ? null : num, (i16 & 8) != 0 ? null : bitmap, (i16 & 16) != 0 ? null : pAGViewListener);
    }
}
