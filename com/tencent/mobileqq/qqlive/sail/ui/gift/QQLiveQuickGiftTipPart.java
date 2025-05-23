package com.tencent.mobileqq.qqlive.sail.ui.gift;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u001c\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/gift/QQLiveQuickGiftTipPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "", "sa", "oa", "", "na", "isPartEnable", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "data", "Z9", "V9", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "tipContainer", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvNickname", "Landroid/widget/PopupWindow;", tl.h.F, "Landroid/widget/PopupWindow;", "popupTip", "Lkotlinx/coroutines/Job;", "i", "Lkotlinx/coroutines/Job;", "showTipJob", "Lcom/tencent/mobileqq/qqlive/sail/ui/gift/GiftViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "qa", "()Lcom/tencent/mobileqq/qqlive/sail/ui/gift/GiftViewModel;", "giftViewModel", "ra", "()Z", MiniChatConstants.MINI_APP_LANDSCAPE, "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveQuickGiftTipPart extends com.tencent.mobileqq.qqlive.sail.base.c {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup tipContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tvNickname;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PopupWindow popupTip;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job showTipJob;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy giftViewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/gift/QQLiveQuickGiftTipPart$a;", "", "", "QUICK_GIFT_TIP_KEY", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveQuickGiftTipPart$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52155);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveQuickGiftTipPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<GiftViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveQuickGiftTipPart$giftViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveQuickGiftTipPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final GiftViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (GiftViewModel) QQLiveQuickGiftTipPart.this.getViewModel(GiftViewModel.class) : (GiftViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.giftViewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (ct3.a.e("quick_gift_tips_can_show_key", true) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean na() {
        boolean z16;
        if (!ra()) {
            z16 = true;
        }
        z16 = false;
        AegisLogger.INSTANCE.i("Audience|QQLiveQuickGiftTipPart", "canShowTip", "roomId=" + H9() + ", show=" + z16 + ", isLand=" + ra());
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oa() {
        ViewGroup viewGroup;
        TextView textView;
        AegisLogger.INSTANCE.i("Audience|QQLiveQuickGiftTipPart", "doShowTip", "roomId=" + H9());
        if (this.popupTip == null) {
            LayoutInflater from = LayoutInflater.from(getContext());
            View partRootView = getPartRootView();
            ViewGroup viewGroup2 = null;
            if (partRootView instanceof ViewGroup) {
                viewGroup = (ViewGroup) partRootView;
            } else {
                viewGroup = null;
            }
            View inflate = from.inflate(R.layout.hbb, viewGroup, false);
            this.popupTip = new PopupWindow(inflate, -2, -2);
            if (inflate != null) {
                textView = (TextView) inflate.findViewById(R.id.f61472y8);
            } else {
                textView = null;
            }
            this.tvNickname = textView;
            if (inflate != null) {
                viewGroup2 = (ViewGroup) inflate.findViewById(R.id.f61462y7);
            }
            this.tipContainer = viewGroup2;
            if (viewGroup2 != null) {
                viewGroup2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QQLiveQuickGiftTipPart.pa(QQLiveQuickGiftTipPart.this, view);
                    }
                });
            }
        }
        TextView textView2 = this.tvNickname;
        if (textView2 != null) {
            textView2.setText("Hi, " + L9());
        }
        ct3.a.o("quick_gift_tips_can_show_key", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(QQLiveQuickGiftTipPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupTip;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final GiftViewModel qa() {
        Object value = this.giftViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-giftViewModel>(...)");
        return (GiftViewModel) value;
    }

    private final boolean ra() {
        Resources resources;
        Configuration configuration;
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sa() {
        Job launch$default;
        Job job = this.showTipJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), null, null, new QQLiveQuickGiftTipPart$launchShowTipJob$1(this, null), 3, null);
        this.showTipJob = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.V9();
        PopupWindow popupWindow = this.popupTip;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        Job job = this.showTipJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void Z9(@Nullable com.tencent.mobileqq.qqgift.data.service.d data) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) data);
            return;
        }
        super.Z9(data);
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        long H9 = H9();
        if (data != null) {
            num = Integer.valueOf(data.f264874d);
        } else {
            num = null;
        }
        companion.i("Audience|QQLiveQuickGiftTipPart", "onSendGift", "roomId=" + H9 + ", giftId=" + num);
        PopupWindow popupWindow = this.popupTip;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        Job job = this.showTipJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        LiveData<c55.d> f26 = qa().f2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<c55.d, Unit> function1 = new Function1<c55.d, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveQuickGiftTipPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveQuickGiftTipPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(c55.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable c55.d dVar) {
                boolean na5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dVar);
                    return;
                }
                AegisLogger.INSTANCE.i("Audience|QQLiveQuickGiftTipPart", "configChanged", "roomId=" + QQLiveQuickGiftTipPart.this.H9() + ", conf=" + (dVar != null ? Integer.valueOf(dVar.hashCode()) : null));
                if (dVar != null) {
                    QQLiveQuickGiftTipPart qQLiveQuickGiftTipPart = QQLiveQuickGiftTipPart.this;
                    na5 = qQLiveQuickGiftTipPart.na();
                    if (na5) {
                        qQLiveQuickGiftTipPart.sa();
                    }
                }
            }
        };
        f26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveQuickGiftTipPart.ta(Function1.this, obj);
            }
        });
    }
}
