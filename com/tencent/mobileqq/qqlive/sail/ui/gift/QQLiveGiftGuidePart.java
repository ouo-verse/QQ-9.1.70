package com.tencent.mobileqq.qqlive.sail.ui.gift;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.report.QQLiveDaTongParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
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

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u001f\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00112\u0006\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u001c\u0010\u0018\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R\u0016\u00107\u001a\u0004\u0018\u0001048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/gift/QQLiveGiftGuidePart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "", "Lc55/a;", "confs", "", "wa", "([Lc55/a;)V", "conf", "", "qa", "Lkotlinx/coroutines/Job;", "sa", "", "pa", "na", "", "oa", "ra", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Lfp4/c;", "msgInfo", "onPush", "U9", "V9", "", "e", "Ljava/util/List;", "normalShowJobList", "f", "giftShowJobList", "Lck4/a;", tl.h.F, "Lck4/a;", "showDialogHelper", "Lcom/tencent/mobileqq/qqlive/sail/ui/gift/GiftViewModel;", "i", "Lkotlin/Lazy;", "ua", "()Lcom/tencent/mobileqq/qqlive/sail/ui/gift/GiftViewModel;", "giftViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/clearscreen/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "ta", "()Lcom/tencent/mobileqq/qqlive/sail/ui/clearscreen/a;", "clearScreenViewModel", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "va", "()Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveGiftGuidePart extends com.tencent.mobileqq.qqlive.sail.base.c implements com.tencent.mobileqq.qqlive.sail.room.g {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Job> normalShowJobList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Job> giftShowJobList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ck4.a showDialogHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy giftViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy clearScreenViewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/gift/QQLiveGiftGuidePart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveGiftGuidePart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52046);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveGiftGuidePart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.normalShowJobList = new ArrayList();
        this.giftShowJobList = new ArrayList();
        this.showDialogHelper = new ck4.a();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GiftViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveGiftGuidePart$giftViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveGiftGuidePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GiftViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (GiftViewModel) QQLiveGiftGuidePart.this.getViewModel(GiftViewModel.class) : (GiftViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.giftViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveGiftGuidePart$clearScreenViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveGiftGuidePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a) QQLiveGiftGuidePart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a.class) : (com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.clearScreenViewModel = lazy2;
    }

    private final void na() {
        com.tencent.mobileqq.qqlive.sail.room.e va5 = va();
        if (va5 != null) {
            va5.p(167, this);
        }
        com.tencent.mobileqq.qqlive.sail.room.e va6 = va();
        if (va6 != null) {
            va6.p(235, this);
        }
    }

    private final Map<String, String> oa(c55.a conf) {
        String str;
        QQLiveDaTongParams f16 = com.tencent.mobileqq.qqlive.sail.report.a.f272382a.f(H9());
        f16.M(String.valueOf(conf.f30379a));
        if (conf.f30380b > 0) {
            str = "1";
        } else {
            str = "0";
        }
        f16.L(str);
        f16.N(String.valueOf(conf.f30380b));
        return f16.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String pa(c55.a conf) {
        String str = conf.f30382d;
        if (str != null) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            for (Map.Entry<String, String> entry : oa(conf).entrySet()) {
                buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
            }
            String uri = buildUpon.build().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "builder.build().toString()");
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isDevelopLevel()) {
                companion.d("Audience|QQLiveGiftGuidePart", "buildUrl", "roomId=" + H9() + ", url=" + uri);
            }
            return uri;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean qa(c55.a conf) {
        boolean z16;
        boolean e16 = bk4.a.e(H9(), conf.f30379a, conf.f30384f, conf.f30383e);
        boolean areEqual = Intrinsics.areEqual(ta().L1().getValue(), Boolean.TRUE);
        if (e16 && !areEqual && conf.f30380b > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        AegisLogger.INSTANCE.i("Audience|QQLiveGiftGuidePart", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "roomId=" + H9() + ", show=" + z16);
        return z16;
    }

    private final void ra() {
        com.tencent.mobileqq.qqlive.sail.room.e va5 = va();
        if (va5 != null) {
            va5.e(this);
        }
        Iterator<T> it = this.normalShowJobList.iterator();
        while (it.hasNext()) {
            Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
        }
        Iterator<T> it5 = this.giftShowJobList.iterator();
        while (it5.hasNext()) {
            Job.DefaultImpls.cancel$default((Job) it5.next(), (CancellationException) null, 1, (Object) null);
        }
        this.showDialogHelper.a();
    }

    private final Job sa(c55.a conf) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), null, null, new QQLiveGiftGuidePart$createShowJob$1(this, conf, null), 3, null);
        return launch$default;
    }

    private final com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a ta() {
        Object value = this.clearScreenViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-clearScreenViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a) value;
    }

    private final GiftViewModel ua() {
        Object value = this.giftViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-giftViewModel>(...)");
        return (GiftViewModel) value;
    }

    private final com.tencent.mobileqq.qqlive.sail.room.e va() {
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 instanceof com.tencent.mobileqq.qqlive.sail.room.e) {
            return (com.tencent.mobileqq.qqlive.sail.room.e) F9;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wa(c55.a[] confs) {
        List<c55.a> filterNotNull;
        boolean z16;
        int length = confs.length;
        boolean z17 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            c55.a aVar = confs[i3];
            if (aVar != null && aVar.f30381c) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
                break;
            }
            i3++;
        }
        if (z17) {
            na();
        }
        filterNotNull = ArraysKt___ArraysKt.filterNotNull(confs);
        for (c55.a aVar2 : filterNotNull) {
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isDevelopLevel()) {
                companion.d("Audience|QQLiveGiftGuidePart", "handleConfigChanged", aVar2.f30381c + ", " + aVar2.f30380b + ", " + aVar2.f30384f + ", " + aVar2.f30383e + ", " + aVar2.f30382d);
            }
            if (aVar2.f30381c) {
                this.giftShowJobList.add(sa(aVar2));
            } else {
                this.normalShowJobList.add(sa(aVar2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.U9();
            this.showDialogHelper.b();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.V9();
            ra();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        LiveData<c55.a[]> i26 = ua().i2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<c55.a[], Unit> function1 = new Function1<c55.a[], Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveGiftGuidePart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveGiftGuidePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(c55.a[] aVarArr) {
                invoke2(aVarArr);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(c55.a[] aVarArr) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVarArr);
                    return;
                }
                AegisLogger.INSTANCE.i("Audience|QQLiveGiftGuidePart", "giftGuideChanged", "roomId=" + QQLiveGiftGuidePart.this.H9() + ", size=" + (aVarArr != null ? Integer.valueOf(aVarArr.length) : null));
                if (aVarArr != null) {
                    QQLiveGiftGuidePart.this.wa(aVarArr);
                }
            }
        };
        i26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveGiftGuidePart.xa(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            ra();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        mt3.e m3 = com.tencent.mobileqq.qqlive.sail.push.a.m(msgInfo);
        if (m3 != null && m3.f417554e == M9()) {
            Iterator<T> it = this.giftShowJobList.iterator();
            while (it.hasNext()) {
                Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
            }
            com.tencent.mobileqq.qqlive.sail.room.e va5 = va();
            if (va5 != null) {
                va5.e(this);
            }
        }
    }
}
