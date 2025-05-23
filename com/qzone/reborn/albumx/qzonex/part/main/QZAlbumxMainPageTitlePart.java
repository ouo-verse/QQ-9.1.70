package com.qzone.reborn.albumx.qzonex.part.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxTopAndRefreshEvent;
import com.qzone.reborn.feedx.widget.homepage.QZoneCalendarIconView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.AlbumPageInfo;
import com.tencent.qqnt.kernel.nativeinterface.ToolBox;
import com.tencent.qzonehub.api.IQZoneMMKVApi;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.bn;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0016R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010.\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010%R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u0010%\u00a8\u00069"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/main/QZAlbumxMainPageTitlePart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "", "ca", "da", "V9", "", "tabIndex", "O9", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumPageInfo;", "albumPageInfo", "N9", "ba", "Q9", "P9", "Landroid/widget/ImageView;", "moreButton", "T9", "R9", "M9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "Lnc/bn;", "d", "Lnc/bn;", "mainTabViewModel", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "titleBar", "f", "Landroid/widget/ImageView;", "ivBack", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "tvTitle", "i", "tvDesc", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "ivMore", "Lcom/qzone/reborn/feedx/widget/homepage/QZoneCalendarIconView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/widget/homepage/QZoneCalendarIconView;", "flCalendar", "D", "ivQuestion", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxMainPageTitlePart extends com.qzone.reborn.base.k implements View.OnClickListener {
    private static final List<String> F;

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneCalendarIconView flCalendar;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView ivQuestion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private bn mainTabViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout titleBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView ivBack;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView tvTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView tvDesc;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView ivMore;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/albumx/qzonex/part/main/QZAlbumxMainPageTitlePart$b", "Lcom/tencent/mobileqq/widget/tip/a$b;", "", "onDismiss", "onShow", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f53222a;

        b(int i3) {
            this.f53222a = i3;
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onClick(View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            QLog.d("QZAlbumxMainPageTitlePart", 1, "initAIEliminateBubbleTip onClick");
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
            QLog.d("QZAlbumxMainPageTitlePart", 1, "initAIEliminateBubbleTip onShow");
            ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveLong(QQWinkConstants.KEY_SHOW_ELIMINATE_BUBBLE_TIME, System.currentTimeMillis());
            ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveInt(QQWinkConstants.KEY_SHOW_ELIMINATE_BUBBLE_COUNT, this.f53222a + 1);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onDismiss() {
            QLog.d("QZAlbumxMainPageTitlePart", 1, "initAIEliminateBubbleTip onDismiss");
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/albumx/qzonex/part/main/QZAlbumxMainPageTitlePart$c", "Lcom/tencent/mobileqq/widget/tip/a$b;", "", "onDismiss", "onShow", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.widget.tip.a f53223a;

        c(com.tencent.mobileqq.widget.tip.a aVar) {
            this.f53223a = aVar;
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onClick(View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            QLog.d("QZAlbumxMainPageTitlePart", 1, "initShowPhotoRepairBubbleTip onClick");
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onDismiss() {
            QLog.d("QZAlbumxMainPageTitlePart", 1, "initShowPhotoRepairBubbleTip onDismiss");
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
            QLog.d("QZAlbumxMainPageTitlePart", 1, "initShowPhotoRepairBubbleTip onShow");
            com.qzone.reborn.repair.utils.a.f59293a.e();
            HashMap hashMap = new HashMap();
            hashMap.put("bubbletips_type", "1");
            fo.c.g("em_qz_tool_box_remind_bubble", "pg_qz_space_album_list_new", this.f53223a.v(), hashMap);
        }
    }

    static {
        List<String> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(com.qzone.util.l.a(R.string.f169520jg2), com.qzone.util.l.a(R.string.jfz), com.qzone.util.l.a(R.string.f169519jg1), com.qzone.util.l.a(R.string.f169518jg0));
        F = mutableListOf;
    }

    private final void M9() {
        fo.b bVar = new fo.b();
        bVar.k(ExposurePolicy.REPORT_NONE);
        ImageView imageView = this.ivBack;
        QZoneCalendarIconView qZoneCalendarIconView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            imageView = null;
        }
        fo.c.o(imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_BACK, bVar);
        ImageView imageView2 = this.ivMore;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivMore");
            imageView2 = null;
        }
        fo.c.o(imageView2, "em_qz_more", bVar);
        QZoneCalendarIconView qZoneCalendarIconView2 = this.flCalendar;
        if (qZoneCalendarIconView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flCalendar");
        } else {
            qZoneCalendarIconView = qZoneCalendarIconView2;
        }
        fo.c.o(qZoneCalendarIconView, "em_qz_calendar", bVar);
    }

    private final void N9(AlbumPageInfo albumPageInfo) {
        ImageView imageView = null;
        if (albumPageInfo.tools.isEmpty()) {
            ImageView imageView2 = this.ivMore;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivMore");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(8);
            return;
        }
        bn bnVar = this.mainTabViewModel;
        if (bnVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            bnVar = null;
        }
        if (bnVar.getTabIndex() == 0) {
            ImageView imageView3 = this.ivMore;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivMore");
            } else {
                imageView = imageView3;
            }
            imageView.setVisibility(0);
        }
    }

    private final void O9(int tabIndex) {
        TextView textView = this.tvTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView = null;
        }
        textView.setText(F.get(tabIndex));
        ba(tabIndex);
        Q9();
    }

    private final void P9() {
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        bn bnVar = this.mainTabViewModel;
        if (bnVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            bnVar = null;
        }
        simpleEventBus.dispatchEvent(new QZAlbumxTopAndRefreshEvent("", bnVar.getTabIndex()));
    }

    private final void Q9() {
        String albumTabTitleDesc;
        bn bnVar = this.mainTabViewModel;
        TextView textView = null;
        if (bnVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            bnVar = null;
        }
        int tabIndex = bnVar.getTabIndex();
        if (tabIndex == 0) {
            bn bnVar2 = this.mainTabViewModel;
            if (bnVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
                bnVar2 = null;
            }
            albumTabTitleDesc = bnVar2.getAlbumTabTitleDesc();
        } else if (tabIndex == 1) {
            bn bnVar3 = this.mainTabViewModel;
            if (bnVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
                bnVar3 = null;
            }
            albumTabTitleDesc = bnVar3.getPicTabTitleDesc();
        } else if (tabIndex != 2) {
            albumTabTitleDesc = null;
        } else {
            bn bnVar4 = this.mainTabViewModel;
            if (bnVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
                bnVar4 = null;
            }
            albumTabTitleDesc = bnVar4.getVideoTabTitleDesc();
        }
        if (albumTabTitleDesc == null) {
            bn bnVar5 = this.mainTabViewModel;
            if (bnVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
                bnVar5 = null;
            }
            if (bnVar5.getTabIndex() != 3) {
                TextView textView2 = this.tvDesc;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvDesc");
                } else {
                    textView = textView2;
                }
                textView.setVisibility(0);
                return;
            }
        }
        if (TextUtils.isEmpty(albumTabTitleDesc)) {
            TextView textView3 = this.tvDesc;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvDesc");
            } else {
                textView = textView3;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView4 = this.tvDesc;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDesc");
            textView4 = null;
        }
        textView4.setVisibility(0);
        TextView textView5 = this.tvDesc;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDesc");
        } else {
            textView = textView5;
        }
        textView.setText(albumTabTitleDesc);
    }

    private final void R9(final ImageView moreButton) {
        if (dh.a.f393805d.h()) {
            QLog.w("QZ_QFS_QZAlbumxMainPageTitlePart", 1, "initAIEliminateBubbleTip, isShowQcircleEntranceGuideBubble");
            return;
        }
        if (com.qzone.reborn.repair.utils.a.f59293a.a()) {
            QLog.i("QZAlbumxMainPageTitlePart", 1, "photo repair bubble show");
            return;
        }
        final int intValue = ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getIntValue(QQWinkConstants.KEY_SHOW_ELIMINATE_BUBBLE_COUNT, 0);
        if (intValue < 3 && ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getLongValue(QQWinkConstants.KEY_SHOW_ELIMINATE_BUBBLE_TIME, -1L) + 604800000 < System.currentTimeMillis()) {
            RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.main.n
                @Override // java.lang.Runnable
                public final void run() {
                    QZAlbumxMainPageTitlePart.S9(moreButton, intValue);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(ImageView moreButton, int i3) {
        Intrinsics.checkNotNullParameter(moreButton, "$moreButton");
        com.tencent.mobileqq.widget.tip.a r16 = com.tencent.mobileqq.widget.tip.a.r(moreButton.getContext());
        r16.S(moreButton).k0(2).R(0).o0(com.qzone.util.l.a(R.string.f133877a)).j0(10.0f, 8.0f, 10.0f, 8.0f).W(moreButton.getResources().getColor(R.color.qui_common_bg_top_dark)).f(new b(i3));
        r16.s0();
    }

    private final void T9(final ImageView moreButton) {
        if (dh.a.f393805d.h()) {
            QLog.w("QZ_QFS_QZAlbumxMainPageTitlePart", 1, "initShowPhotoRepairBubbleTip, isShowQcircleEntranceGuideBubble");
        } else if (com.qzone.reborn.repair.utils.a.f59293a.a()) {
            RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.main.m
                @Override // java.lang.Runnable
                public final void run() {
                    QZAlbumxMainPageTitlePart.U9(moreButton);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(ImageView moreButton) {
        Intrinsics.checkNotNullParameter(moreButton, "$moreButton");
        com.tencent.mobileqq.widget.tip.a r16 = com.tencent.mobileqq.widget.tip.a.r(moreButton.getContext());
        r16.S(moreButton).k0(2).R(0).o0(com.qzone.util.l.a(R.string.f169561wa0)).j0(10.0f, 8.0f, 10.0f, 8.0f).W(moreButton.getResources().getColor(R.color.qui_common_bg_top_dark)).f(new c(r16));
        r16.s0();
    }

    private final void V9() {
        ViewModel viewModel = getViewModel(bn.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxMai\u2026TabViewModel::class.java)");
        bn bnVar = (bn) viewModel;
        this.mainTabViewModel = bnVar;
        bn bnVar2 = null;
        if (bnVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            bnVar = null;
        }
        bnVar.e2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.main.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxMainPageTitlePart.W9(QZAlbumxMainPageTitlePart.this, (Integer) obj);
            }
        });
        bn bnVar3 = this.mainTabViewModel;
        if (bnVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            bnVar3 = null;
        }
        bnVar3.f2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.main.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxMainPageTitlePart.X9(QZAlbumxMainPageTitlePart.this, (Unit) obj);
            }
        });
        bn bnVar4 = this.mainTabViewModel;
        if (bnVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            bnVar4 = null;
        }
        bnVar4.U1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.main.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxMainPageTitlePart.Y9(QZAlbumxMainPageTitlePart.this, (AlbumPageInfo) obj);
            }
        });
        bn bnVar5 = this.mainTabViewModel;
        if (bnVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            bnVar5 = null;
        }
        MutableLiveData<Boolean> j26 = bnVar5.j2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.main.QZAlbumxMainPageTitlePart$initViewModelListener$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                bn bnVar6;
                QZoneCalendarIconView qZoneCalendarIconView;
                ImageView imageView;
                bnVar6 = QZAlbumxMainPageTitlePart.this.mainTabViewModel;
                ImageView imageView2 = null;
                if (bnVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
                    bnVar6 = null;
                }
                Integer value = bnVar6.e2().getValue();
                if (value != null && value.intValue() == 1) {
                    qZoneCalendarIconView = QZAlbumxMainPageTitlePart.this.flCalendar;
                    if (qZoneCalendarIconView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("flCalendar");
                        qZoneCalendarIconView = null;
                    }
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    qZoneCalendarIconView.setVisibility(it.booleanValue() ? 0 : 8);
                    imageView = QZAlbumxMainPageTitlePart.this.ivMore;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ivMore");
                    } else {
                        imageView2 = imageView;
                    }
                    imageView2.setVisibility(it.booleanValue() ? 8 : 0);
                }
            }
        };
        j26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.main.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxMainPageTitlePart.Z9(Function1.this, obj);
            }
        });
        bn bnVar6 = this.mainTabViewModel;
        if (bnVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
        } else {
            bnVar2 = bnVar6;
        }
        MutableLiveData<Long> X1 = bnVar2.X1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Long, Unit> function12 = new Function1<Long, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.main.QZAlbumxMainPageTitlePart$initViewModelListener$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l3) {
                QZoneCalendarIconView qZoneCalendarIconView;
                qZoneCalendarIconView = QZAlbumxMainPageTitlePart.this.flCalendar;
                if (qZoneCalendarIconView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("flCalendar");
                    qZoneCalendarIconView = null;
                }
                qZoneCalendarIconView.m(l3.longValue() * 1000);
            }
        };
        X1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.main.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxMainPageTitlePart.aa(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(QZAlbumxMainPageTitlePart this$0, Integer tabIndex) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(tabIndex, "tabIndex");
        this$0.O9(tabIndex.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(QZAlbumxMainPageTitlePart this$0, Unit unit) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(QZAlbumxMainPageTitlePart this$0, AlbumPageInfo it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.N9(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v18, types: [com.qzone.reborn.feedx.widget.homepage.QZoneCalendarIconView] */
    /* JADX WARN: Type inference failed for: r9v22, types: [com.qzone.reborn.feedx.widget.homepage.QZoneCalendarIconView] */
    private final void ba(int tabIndex) {
        ArrayList<ToolBox> arrayList;
        ImageView imageView = this.ivMore;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivMore");
            imageView = null;
        }
        imageView.setVisibility(8);
        QZoneCalendarIconView qZoneCalendarIconView = this.flCalendar;
        if (qZoneCalendarIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flCalendar");
            qZoneCalendarIconView = null;
        }
        qZoneCalendarIconView.setVisibility(8);
        ImageView imageView3 = this.ivQuestion;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivQuestion");
            imageView3 = null;
        }
        imageView3.setVisibility(8);
        if (tabIndex != 0) {
            if (tabIndex == 1) {
                bn bnVar = this.mainTabViewModel;
                if (bnVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
                    bnVar = null;
                }
                if (Intrinsics.areEqual(bnVar.j2().getValue(), Boolean.TRUE)) {
                    ImageView imageView4 = this.ivMore;
                    if (imageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ivMore");
                        imageView4 = null;
                    }
                    imageView4.setVisibility(8);
                    ?? r95 = this.flCalendar;
                    if (r95 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("flCalendar");
                    } else {
                        imageView2 = r95;
                    }
                    imageView2.setVisibility(0);
                    return;
                }
                ImageView imageView5 = this.ivMore;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivMore");
                    imageView5 = null;
                }
                imageView5.setVisibility(0);
                ?? r96 = this.flCalendar;
                if (r96 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("flCalendar");
                } else {
                    imageView2 = r96;
                }
                imageView2.setVisibility(8);
                return;
            }
            if (tabIndex != 2) {
                if (tabIndex != 3) {
                    return;
                }
                ImageView imageView6 = this.ivQuestion;
                if (imageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivQuestion");
                } else {
                    imageView2 = imageView6;
                }
                imageView2.setVisibility(0);
                return;
            }
        }
        bn bnVar2 = this.mainTabViewModel;
        if (bnVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            bnVar2 = null;
        }
        AlbumPageInfo value = bnVar2.U1().getValue();
        if ((value == null || (arrayList = value.tools) == null || !(arrayList.isEmpty() ^ true)) ? false : true) {
            ImageView imageView7 = this.ivMore;
            if (imageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivMore");
            } else {
                imageView2 = imageView7;
            }
            imageView2.setVisibility(0);
        }
    }

    private final void ca() {
        ImageView imageView = this.ivMore;
        QZoneCalendarIconView qZoneCalendarIconView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivMore");
            imageView = null;
        }
        rn.h.a(imageView, "qui_profession", R.color.qui_common_icon_nav_secondary);
        ImageView imageView2 = this.ivQuestion;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivQuestion");
            imageView2 = null;
        }
        rn.h.a(imageView2, "qui_question_mark_circle", R.color.qui_common_icon_nav_secondary);
        QZoneCalendarIconView qZoneCalendarIconView2 = this.flCalendar;
        if (qZoneCalendarIconView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flCalendar");
        } else {
            qZoneCalendarIconView = qZoneCalendarIconView2;
        }
        qZoneCalendarIconView.a(getContext().getColor(R.color.qui_common_icon_nav_secondary));
    }

    private final void da() {
        QZoneCalendarIconView qZoneCalendarIconView = this.flCalendar;
        ImageView imageView = null;
        if (qZoneCalendarIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flCalendar");
            qZoneCalendarIconView = null;
        }
        qZoneCalendarIconView.setContentDescription(com.qzone.util.l.a(R.string.f1341582));
        ImageView imageView2 = this.ivBack;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            imageView2 = null;
        }
        imageView2.setContentDescription(com.qzone.util.l.a(R.string.f1338478));
        ImageView imageView3 = this.ivMore;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivMore");
            imageView3 = null;
        }
        imageView3.setContentDescription(com.qzone.util.l.a(R.string.jjd));
        ImageView imageView4 = this.ivQuestion;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivQuestion");
        } else {
            imageView = imageView4;
        }
        imageView.setContentDescription(com.qzone.util.l.a(R.string.f1341481));
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxMainPageTitlePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        bn bnVar = null;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.kua) {
            getActivity().onBackPressed();
        } else {
            boolean z16 = false;
            if (((valueOf != null && valueOf.intValue() == R.id.loy) || (valueOf != null && valueOf.intValue() == R.id.gq9)) || (valueOf != null && valueOf.intValue() == R.id.lip)) {
                z16 = true;
            }
            if (z16) {
                bn bnVar2 = this.mainTabViewModel;
                if (bnVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
                } else {
                    bnVar = bnVar2;
                }
                bnVar.T1();
            } else if (valueOf != null && valueOf.intValue() == R.id.nhd) {
                P9();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.nhd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.title_layout)");
        this.titleBar = (FrameLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.kua);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.iv_back_icon)");
        ImageView imageView = (ImageView) findViewById2;
        this.ivBack = imageView;
        QZoneCalendarIconView qZoneCalendarIconView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        View findViewById3 = rootView.findViewById(R.id.nkj);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_title_name)");
        this.tvTitle = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.nki);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.tv_title_desc)");
        this.tvDesc = (TextView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.lip);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.iv_more)");
        ImageView imageView2 = (ImageView) findViewById5;
        this.ivMore = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivMore");
            imageView2 = null;
        }
        imageView2.setOnClickListener(this);
        ImageView imageView3 = this.ivMore;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivMore");
            imageView3 = null;
        }
        R9(imageView3);
        ImageView imageView4 = this.ivMore;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivMore");
            imageView4 = null;
        }
        T9(imageView4);
        View findViewById6 = rootView.findViewById(R.id.gq9);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.fl_calendar)");
        this.flCalendar = (QZoneCalendarIconView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.loy);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.iv_question)");
        this.ivQuestion = (ImageView) findViewById7;
        V9();
        FrameLayout frameLayout = this.titleBar;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            frameLayout = null;
        }
        frameLayout.setOnClickListener(this);
        ImageView imageView5 = this.ivQuestion;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivQuestion");
            imageView5 = null;
        }
        imageView5.setOnClickListener(this);
        QZoneCalendarIconView qZoneCalendarIconView2 = this.flCalendar;
        if (qZoneCalendarIconView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flCalendar");
        } else {
            qZoneCalendarIconView = qZoneCalendarIconView2;
        }
        qZoneCalendarIconView.setOnClickListener(this);
        ca();
        da();
        M9();
    }
}
