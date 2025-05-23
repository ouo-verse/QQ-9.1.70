package com.tencent.mobileqq.vas.iceBreak;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.iceBreak.TroopIceBreakView;
import com.tencent.mobileqq.vas.troop.IceBreakHelper;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.f;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.vas.update.entity.UpdateListenerParams;
import cooperation.qzone.QZoneClickReport;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001\tB\u001f\b\u0007\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR#\u0010#\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/vas/iceBreak/TroopIceBreakView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mobileqq/vas/iceBreak/a;", "", h.F, "Landroid/view/View;", "getView", "Lcom/tencent/mobileqq/vas/iceBreak/b;", "iceBreakData", "a", "", "d", "I", "templateId", "", "e", "Ljava/lang/CharSequence;", "content", "", "f", "Z", "isSender", "Lcom/tencent/mobileqq/vas/iceBreak/c;", "Lcom/tencent/mobileqq/vas/iceBreak/c;", "listener", "Lz33/b;", "i", "Lz33/b;", "binding", "Lcom/tencent/mobileqq/vas/updatesystem/business/f;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "g", "()Lcom/tencent/mobileqq/vas/updatesystem/business/f;", "business", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdhLogUtil.LogTag.Tag_Conn, "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class TroopIceBreakView extends RelativeLayout implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int templateId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CharSequence content;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isSender;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c listener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private z33.b binding;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy business;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/vas/iceBreak/TroopIceBreakView$b", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadSuccess", "onLoadFail", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements IDownLoadListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(TroopIceBreakView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.h();
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            QLog.e("TroopIceBreakView", 1, "download error , bid: " + params.mBusinessUpdateParams.mBid + " , errorCode: " + params.mErrorCode);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final TroopIceBreakView troopIceBreakView = TroopIceBreakView.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vas.iceBreak.f
                @Override // java.lang.Runnable
                public final void run() {
                    TroopIceBreakView.b.b(TroopIceBreakView.this);
                }
            });
        }
    }

    @JvmOverloads
    public TroopIceBreakView(@Nullable Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IceBreakHelper.INSTANCE.gotoIceBreakWeb(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(TroopIceBreakView this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c cVar = this$0.listener;
        if (cVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            cVar.a(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final com.tencent.mobileqq.vas.updatesystem.business.f g() {
        return (com.tencent.mobileqq.vas.updatesystem.business.f) this.business.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        int i3;
        f.Config e16 = g().e(this.templateId);
        if (e16 == null) {
            return;
        }
        RelativeLayout relativeLayout = this.binding.f451865f;
        a.C1005a a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a();
        String absolutePath = e16.d().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "config.headImage.absolutePath");
        relativeLayout.setBackground(a16.d(absolutePath).i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO).a());
        ImageView imageView = this.binding.f451867h;
        a.C1005a a17 = com.tencent.cachedrawable.dynamicdrawable.api.a.a();
        String absolutePath2 = e16.i().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "config.tittleImage.absolutePath");
        imageView.setBackground(a17.d(absolutePath2).i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO).h(new Function1<k, Unit>() { // from class: com.tencent.mobileqq.vas.iceBreak.TroopIceBreakView$showView$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(k kVar) {
                invoke2(kVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull k it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.y(1);
                it.I(false);
            }
        }).a());
        ImageView imageView2 = this.binding.f451866g;
        a.C1005a a18 = com.tencent.cachedrawable.dynamicdrawable.api.a.a();
        String absolutePath3 = e16.e().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath3, "config.logoImage.absolutePath");
        imageView2.setBackground(a18.d(absolutePath3).i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO).h(new Function1<k, Unit>() { // from class: com.tencent.mobileqq.vas.iceBreak.TroopIceBreakView$showView$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(k kVar) {
                invoke2(kVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull k it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.y(1);
                it.I(false);
            }
        }).a());
        View view = this.binding.f451863d;
        a.C1005a a19 = com.tencent.cachedrawable.dynamicdrawable.api.a.a();
        String absolutePath4 = e16.f().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath4, "config.middleImage.absolutePath");
        view.setBackground(a19.d(absolutePath4).i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO).a());
        this.binding.f451862c.setTextColor(e16.h());
        TextView textView = this.binding.f451868i;
        if (this.isSender) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        textView.setVisibility(i3);
        textView.setTextColor(e16.b());
        a.C1005a a26 = com.tencent.cachedrawable.dynamicdrawable.api.a.a();
        String absolutePath5 = e16.c().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath5, "config.buttonImage.absolutePath");
        textView.setBackground(a26.d(absolutePath5).i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO).a());
        ImageView imageView3 = this.binding.f451861b;
        a.C1005a a27 = com.tencent.cachedrawable.dynamicdrawable.api.a.a();
        String absolutePath6 = e16.a().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath6, "config.bottomImage.absolutePath");
        imageView3.setBackground(a27.d(absolutePath6).i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO).a());
    }

    @Override // com.tencent.mobileqq.vas.iceBreak.a
    public void a(@NotNull IceBreakData iceBreakData) {
        Intrinsics.checkNotNullParameter(iceBreakData, "iceBreakData");
        this.isSender = iceBreakData.getIsSender();
        this.templateId = iceBreakData.getTemplateId();
        this.listener = iceBreakData.getListener();
        CharSequence content = iceBreakData.getContent();
        this.content = content;
        this.binding.f451862c.setText(content, TextView.BufferType.SPANNABLE);
        if (g().isFileExists(this.templateId)) {
            h();
        } else {
            g().addDownLoadListener(this.templateId, new b());
            g().startDownload(this.templateId);
        }
    }

    public /* synthetic */ TroopIceBreakView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    @JvmOverloads
    public TroopIceBreakView(@Nullable final Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        this.content = "";
        z33.b f16 = z33.b.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.vas.updatesystem.business.f>() { // from class: com.tencent.mobileqq.vas.iceBreak.TroopIceBreakView$business$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.vas.updatesystem.business.f invoke() {
                return (com.tencent.mobileqq.vas.updatesystem.business.f) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(com.tencent.mobileqq.vas.updatesystem.business.f.class);
            }
        });
        this.business = lazy;
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.iceBreak.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopIceBreakView.d(context, view);
            }
        });
        this.binding.f451868i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.iceBreak.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopIceBreakView.e(TroopIceBreakView.this, view);
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.iceBreak.a
    @NotNull
    public View getView() {
        return this;
    }
}
