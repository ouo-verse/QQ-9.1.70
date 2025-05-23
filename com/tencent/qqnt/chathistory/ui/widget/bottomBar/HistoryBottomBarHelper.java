package com.tencent.qqnt.chathistory.ui.widget.bottomBar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOGroupAlbumForwardApi;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.util.m;
import com.tencent.qqnt.chathistory.x2k.i;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b<\u0010=J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J(\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002JQ\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\n0\u0012J\u0006\u0010\u0019\u001a\u00020\nJ\u0016\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R1\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\n0\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010.\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010)R\u0016\u0010/\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010)R\u0016\u00101\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010)R\u0016\u00103\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010)R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010;\u001a\u0002068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\u00a8\u0006>"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/widget/bottomBar/HistoryBottomBarHelper;", "", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "chatType", "", "peerUid", "Lcom/tencent/qqnt/chathistory/ui/widget/bottomBar/BottomBarType;", "type", "", h.F, "", "p", "reportPage", ReportConstant.COSTREPORT_PREFIX, "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lcom/tencent/qqnt/chathistory/ui/widget/bottomBar/BottomBarOperationType;", "Lkotlin/ParameterName;", "name", "operationType", "callback", "r", DomainData.DOMAIN_NAME, "isEnabled", "isFavEnabled", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "a", "Landroid/content/Context;", "b", "Landroid/view/ViewGroup;", "c", "Z", ViewStickEventHelper.IS_SHOW, "d", "Lkotlin/jvm/functions/Function1;", "callBack", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "forwardBtn", "f", "downloadBtn", "g", "favoriteBtn", "save2WeiYunBtn", "i", "save2GroupAlbumBtn", "j", "deleteBtn", "k", "Ljava/lang/String;", "Landroid/view/View;", "l", "Lkotlin/Lazy;", "o", "()Landroid/view/View;", "bottomView", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class HistoryBottomBarHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ViewGroup container;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isShow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Function1<? super BottomBarOperationType, Unit> callBack;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView forwardBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView downloadBtn;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private ImageView favoriteBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView save2WeiYunBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView save2GroupAlbumBtn;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ImageView deleteBtn;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String peerUid;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy bottomView;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f354025a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51647);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[BottomBarType.values().length];
            try {
                iArr[BottomBarType.STICKER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BottomBarType.DOCUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BottomBarType.LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BottomBarType.MEDIA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BottomBarType.FILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f354025a = iArr;
        }
    }

    public HistoryBottomBarHelper() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.qqnt.chathistory.ui.widget.bottomBar.HistoryBottomBarHelper$bottomView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HistoryBottomBarHelper.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final View invoke() {
                    Context context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    context = HistoryBottomBarHelper.this.context;
                    if (context == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context = null;
                    }
                    return new i(context, null, 2, null).getMRv();
                }
            });
            this.bottomView = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void h(ViewGroup container, final int chatType, final String peerUid, BottomBarType type) {
        final String str;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        View findViewById = o().findViewById(R.id.brr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "bottomView.findViewById<\u2026iew>(R.id.editForwardBtn)");
        this.forwardBtn = (ImageView) findViewById;
        View findViewById2 = o().findViewById(R.id.brq);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "bottomView.findViewById<\u2026ew>(R.id.editDownloadBtn)");
        this.downloadBtn = (ImageView) findViewById2;
        View findViewById3 = o().findViewById(R.id.upm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "bottomView.findViewById<\u2026ageView>(R.id.editFavBtn)");
        this.favoriteBtn = (ImageView) findViewById3;
        View findViewById4 = o().findViewById(R.id.brw);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "bottomView.findViewById<\u2026(R.id.editSave2weiyunBtn)");
        this.save2WeiYunBtn = (ImageView) findViewById4;
        View findViewById5 = o().findViewById(R.id.upp);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "bottomView.findViewById<\u2026d.editSave2GroupAlbumBtn)");
        this.save2GroupAlbumBtn = (ImageView) findViewById5;
        View findViewById6 = o().findViewById(R.id.brp);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "bottomView.findViewById<\u2026View>(R.id.editDeleteBtn)");
        this.deleteBtn = (ImageView) findViewById6;
        this.peerUid = peerUid;
        int[] iArr = a.f354025a;
        int i3 = iArr[type.ordinal()];
        FrameLayout.LayoutParams layoutParams2 = null;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    ImageView imageView = this.downloadBtn;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("downloadBtn");
                        imageView = null;
                    }
                    imageView.setVisibility(8);
                    ImageView imageView2 = this.save2WeiYunBtn;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("save2WeiYunBtn");
                        imageView2 = null;
                    }
                    imageView2.setVisibility(8);
                }
            } else {
                ImageView imageView3 = this.downloadBtn;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadBtn");
                    imageView3 = null;
                }
                imageView3.setVisibility(8);
                ImageView imageView4 = this.save2WeiYunBtn;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("save2WeiYunBtn");
                    imageView4 = null;
                }
                imageView4.setVisibility(8);
            }
        } else {
            if (p()) {
                ImageView imageView5 = this.downloadBtn;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadBtn");
                    imageView5 = null;
                }
                imageView5.setVisibility(8);
            }
            ImageView imageView6 = this.save2WeiYunBtn;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("save2WeiYunBtn");
                imageView6 = null;
            }
            imageView6.setVisibility(8);
        }
        if (chatType == 4) {
            ImageView imageView7 = this.downloadBtn;
            if (imageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloadBtn");
                imageView7 = null;
            }
            imageView7.setVisibility(8);
            ImageView imageView8 = this.save2WeiYunBtn;
            if (imageView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("save2WeiYunBtn");
                imageView8 = null;
            }
            imageView8.setVisibility(8);
            ImageView imageView9 = this.deleteBtn;
            if (imageView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deleteBtn");
                imageView9 = null;
            }
            imageView9.setVisibility(8);
            ImageView imageView10 = this.favoriteBtn;
            if (imageView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteBtn");
                imageView10 = null;
            }
            imageView10.setImageResource(R.drawable.jhs);
        }
        int i16 = iArr[type.ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 != 4) {
                        if (i16 == 5) {
                            str = "pg_bas_file_tab";
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        str = "pg_bas_picvideo_tab";
                    }
                } else {
                    str = "pg_bas_link_tab";
                }
            } else {
                str = "pg_bas_online_document_tab";
            }
        } else {
            str = "pg_bas_emoticon_tab";
        }
        ImageView imageView11 = this.forwardBtn;
        if (imageView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forwardBtn");
            imageView11 = null;
        }
        imageView11.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.widget.bottomBar.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HistoryBottomBarHelper.i(HistoryBottomBarHelper.this, str, chatType, peerUid, view);
            }
        });
        ImageView imageView12 = this.downloadBtn;
        if (imageView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadBtn");
            imageView12 = null;
        }
        imageView12.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.widget.bottomBar.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HistoryBottomBarHelper.j(HistoryBottomBarHelper.this, str, chatType, peerUid, view);
            }
        });
        ImageView imageView13 = this.favoriteBtn;
        if (imageView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteBtn");
            imageView13 = null;
        }
        imageView13.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.widget.bottomBar.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HistoryBottomBarHelper.k(HistoryBottomBarHelper.this, str, chatType, peerUid, view);
            }
        });
        ImageView imageView14 = this.save2WeiYunBtn;
        if (imageView14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("save2WeiYunBtn");
            imageView14 = null;
        }
        imageView14.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.widget.bottomBar.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HistoryBottomBarHelper.l(HistoryBottomBarHelper.this, str, chatType, peerUid, view);
            }
        });
        ImageView imageView15 = this.deleteBtn;
        if (imageView15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteBtn");
            imageView15 = null;
        }
        imageView15.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.widget.bottomBar.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HistoryBottomBarHelper.m(HistoryBottomBarHelper.this, str, chatType, peerUid, view);
            }
        });
        s(chatType, peerUid, type, str);
        View childAt = container.getChildAt(0);
        if (childAt != null) {
            layoutParams = childAt.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = m.a(50);
        }
        container.addView(o());
        ViewGroup.LayoutParams layoutParams3 = o().getLayoutParams();
        if (layoutParams3 instanceof FrameLayout.LayoutParams) {
            layoutParams2 = (FrameLayout.LayoutParams) layoutParams3;
        }
        if (layoutParams2 != null) {
            layoutParams2.gravity = 80;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(HistoryBottomBarHelper this$0, String reportPage, int i3, String peerUid, View it) {
        Map mutableMapOf;
        Map<String, Object> mutableMapOf2;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportPage, "$reportPage");
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        Function1<? super BottomBarOperationType, Unit> function1 = this$0.callBack;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callBack");
            function1 = null;
        }
        function1.invoke(BottomBarOperationType.FORWARD);
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", reportPage), TuplesKt.to("touin", companion.a().e(i3, peerUid)), TuplesKt.to("aio_type", Integer.valueOf(i3)), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, peerUid));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("action_bar_operation_entry", Integer.valueOf(HistoryDtReportHelper.OperationBar.FORWARD.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
        a16.m(it, "em_bas_multiselect_the_bottom_action_bar", mutableMapOf2);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(HistoryBottomBarHelper this$0, String reportPage, int i3, String peerUid, View it) {
        Map mutableMapOf;
        Map<String, Object> mutableMapOf2;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportPage, "$reportPage");
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        Function1<? super BottomBarOperationType, Unit> function1 = this$0.callBack;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callBack");
            function1 = null;
        }
        function1.invoke(BottomBarOperationType.DOWNLOAD);
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", reportPage), TuplesKt.to("touin", companion.a().e(i3, peerUid)), TuplesKt.to("aio_type", Integer.valueOf(i3)), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, peerUid));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("action_bar_operation_entry", Integer.valueOf(HistoryDtReportHelper.OperationBar.DOWNLOAD.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
        a16.m(it, "em_bas_multiselect_the_bottom_action_bar", mutableMapOf2);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(HistoryBottomBarHelper this$0, String reportPage, int i3, String peerUid, View it) {
        Map mutableMapOf;
        Map<String, Object> mutableMapOf2;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportPage, "$reportPage");
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        Function1<? super BottomBarOperationType, Unit> function1 = this$0.callBack;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callBack");
            function1 = null;
        }
        function1.invoke(BottomBarOperationType.FAVORITE);
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", reportPage), TuplesKt.to("touin", companion.a().e(i3, peerUid)), TuplesKt.to("aio_type", Integer.valueOf(i3)), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, peerUid));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("action_bar_operation_entry", Integer.valueOf(HistoryDtReportHelper.OperationBar.FAVORITE.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
        a16.m(it, "em_bas_multiselect_the_bottom_action_bar", mutableMapOf2);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(HistoryBottomBarHelper this$0, String reportPage, int i3, String peerUid, View it) {
        Map mutableMapOf;
        Map<String, Object> mutableMapOf2;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportPage, "$reportPage");
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        Function1<? super BottomBarOperationType, Unit> function1 = this$0.callBack;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callBack");
            function1 = null;
        }
        function1.invoke(BottomBarOperationType.WEIYUN);
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", reportPage), TuplesKt.to("touin", companion.a().e(i3, peerUid)), TuplesKt.to("aio_type", Integer.valueOf(i3)), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, peerUid));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("action_bar_operation_entry", Integer.valueOf(HistoryDtReportHelper.OperationBar.WEIYUN.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
        a16.m(it, "em_bas_multiselect_the_bottom_action_bar", mutableMapOf2);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(HistoryBottomBarHelper this$0, String reportPage, int i3, String peerUid, View it) {
        Map mutableMapOf;
        Map<String, Object> mutableMapOf2;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportPage, "$reportPage");
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        Function1<? super BottomBarOperationType, Unit> function1 = this$0.callBack;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callBack");
            function1 = null;
        }
        function1.invoke(BottomBarOperationType.DELETE);
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", reportPage), TuplesKt.to("touin", companion.a().e(i3, peerUid)), TuplesKt.to("aio_type", Integer.valueOf(i3)), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, peerUid));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("action_bar_operation_entry", Integer.valueOf(HistoryDtReportHelper.OperationBar.DELETE.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
        a16.m(it, "em_bas_multiselect_the_bottom_action_bar", mutableMapOf2);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final boolean p() {
        return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("emotion_download_disable_8980_887036489", true);
    }

    private final void s(final int chatType, final String peerUid, BottomBarType type, final String reportPage) {
        ImageView imageView = null;
        if (type == BottomBarType.MEDIA && chatType == 2) {
            if (!((IAIOGroupAlbumForwardApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOGroupAlbumForwardApi.class)).needShowChatHistoryGroupAlbumEntry(peerUid)) {
                ImageView imageView2 = this.save2GroupAlbumBtn;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("save2GroupAlbumBtn");
                } else {
                    imageView = imageView2;
                }
                imageView.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.save2WeiYunBtn;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("save2WeiYunBtn");
                imageView3 = null;
            }
            if (imageView3.getVisibility() == 0) {
                ImageView imageView4 = this.save2WeiYunBtn;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("save2WeiYunBtn");
                    imageView4 = null;
                }
                imageView4.setVisibility(8);
            }
            ImageView imageView5 = this.save2GroupAlbumBtn;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("save2GroupAlbumBtn");
            } else {
                imageView = imageView5;
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.widget.bottomBar.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HistoryBottomBarHelper.t(HistoryBottomBarHelper.this, reportPage, chatType, peerUid, view);
                }
            });
            return;
        }
        ImageView imageView6 = this.save2GroupAlbumBtn;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("save2GroupAlbumBtn");
        } else {
            imageView = imageView6;
        }
        imageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(HistoryBottomBarHelper this$0, String reportPage, int i3, String peerUid, View it) {
        Map mutableMapOf;
        Map<String, Object> mutableMapOf2;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportPage, "$reportPage");
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        Function1<? super BottomBarOperationType, Unit> function1 = this$0.callBack;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callBack");
            function1 = null;
        }
        function1.invoke(BottomBarOperationType.GROUPALBUM);
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", reportPage), TuplesKt.to("touin", companion.a().e(i3, peerUid)), TuplesKt.to("aio_type", Integer.valueOf(i3)), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, peerUid));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("action_bar_operation_entry", Integer.valueOf(HistoryDtReportHelper.OperationBar.WEIYUN.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
        a16.m(it, "em_bas_multiselect_the_bottom_action_bar", mutableMapOf2);
        EventCollector.getInstance().onViewClicked(it);
    }

    public final void n() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!this.isShow) {
            return;
        }
        ViewGroup viewGroup = this.container;
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            viewGroup = null;
        }
        viewGroup.removeView(o());
        ViewGroup viewGroup2 = this.container;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            viewGroup2 = null;
        }
        View childAt = viewGroup2.getChildAt(0);
        if (childAt != null) {
            obj = childAt.getLayoutParams();
        } else {
            obj = null;
        }
        if (obj instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) obj;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = 0;
        }
        this.isShow = false;
    }

    @NotNull
    public final View o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (View) this.bottomView.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0091, code lost:
    
        if (r6.needShowChatHistoryGroupAlbumEntry(r3) != false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(boolean isEnabled, boolean isFavEnabled) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(isEnabled), Boolean.valueOf(isFavEnabled));
            return;
        }
        ImageView imageView = this.forwardBtn;
        String str = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forwardBtn");
            imageView = null;
        }
        imageView.setEnabled(isEnabled);
        ImageView imageView2 = this.downloadBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadBtn");
            imageView2 = null;
        }
        imageView2.setEnabled(isEnabled);
        ImageView imageView3 = this.favoriteBtn;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteBtn");
            imageView3 = null;
        }
        imageView3.setEnabled(isFavEnabled);
        ImageView imageView4 = this.save2WeiYunBtn;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("save2WeiYunBtn");
            imageView4 = null;
        }
        imageView4.setEnabled(isEnabled);
        ImageView imageView5 = this.deleteBtn;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteBtn");
            imageView5 = null;
        }
        imageView5.setEnabled(isEnabled);
        ImageView imageView6 = this.save2GroupAlbumBtn;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("save2GroupAlbumBtn");
            imageView6 = null;
        }
        if (isEnabled) {
            IAIOGroupAlbumForwardApi iAIOGroupAlbumForwardApi = (IAIOGroupAlbumForwardApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOGroupAlbumForwardApi.class);
            String str2 = this.peerUid;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peerUid");
            } else {
                str = str2;
            }
        }
        z16 = false;
        imageView6.setEnabled(z16);
    }

    public final void r(@NotNull Context context, @NotNull ViewGroup container, int chatType, @NotNull String peerUid, @NotNull BottomBarType type, @NotNull Function1<? super BottomBarOperationType, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, container, Integer.valueOf(chatType), peerUid, type, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.isShow) {
            return;
        }
        this.context = context;
        this.container = container;
        this.callBack = callback;
        h(container, chatType, peerUid, type);
        this.isShow = true;
    }
}
