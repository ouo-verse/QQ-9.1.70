package com.tencent.biz.qqcircle.publish.plusentry.composer.operationpos;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.utils.ao;
import com.tencent.biz.qqcircle.immersive.viewmodel.wink.QFSPublishFeedViewModel;
import com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer;
import com.tencent.biz.qqcircle.publish.plusentry.helper.PlusEntryExp;
import com.tencent.biz.qqcircle.wink.DTButtonInfo;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import e40.QFSPublishFeedVariantInfo;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ma0.VariantUIData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00102\u001a\u00020\u000f\u00a2\u0006\u0004\b3\u00104J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0017J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bH\u0016R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R$\u0010(\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0004\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020*8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020\b8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010)\u00a8\u00065"}, d2 = {"Lcom/tencent/biz/qqcircle/publish/plusentry/composer/operationpos/BasePlusEntryOperationPosComposer;", "Lcom/tencent/biz/qqcircle/publish/plusentry/composer/BasePlusEntryComposer;", "Lcom/tencent/biz/qqcircle/publish/plusentry/helper/PlusEntryExp;", "exp", "j", "", "b", "a", "", "o", "Le40/d;", "feedVariantInfo", "p", "needAnima", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "f", "Landroid/view/View;", "l", "()Landroid/view/View;", "normalView", "Landroid/widget/ImageView;", "g", "Landroid/widget/ImageView;", "k", "()Landroid/widget/ImageView;", "ivOperation", h.F, "Le40/d;", "getFeedVariantInfo", "()Le40/d;", "setFeedVariantInfo", "(Le40/d;)V", "Landroidx/lifecycle/Observer;", "Lma0/d;", "i", "Landroidx/lifecycle/Observer;", "ptkObserver", "<set-?>", "Z", "isShowingOperationView", "()Z", "", "d", "()Ljava/lang/String;", "logTag", DomainData.DOMAIN_NAME, "isEnable", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "partHost", "plusEntryLayout", "<init>", "(Lcom/tencent/biz/richframework/part/interfaces/IPartHost;Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public class BasePlusEntryOperationPosComposer extends BasePlusEntryComposer {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View normalView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ImageView ivOperation;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSPublishFeedVariantInfo feedVariantInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Observer<VariantUIData> ptkObserver;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isShowingOperationView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasePlusEntryOperationPosComposer(@NotNull IPartHost partHost, @NotNull View plusEntryLayout) {
        super(partHost, plusEntryLayout);
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        Intrinsics.checkNotNullParameter(plusEntryLayout, "plusEntryLayout");
        this.ivOperation = (ImageView) plusEntryLayout.findViewById(R.id.f5034255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(BasePlusEntryOperationPosComposer this$0, VariantUIData variantUIData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.d(), 1, "ptkBtnLiveData data changed, it:" + variantUIData);
        if (variantUIData.getShow()) {
            this$0.p(variantUIData.getVariantInfo());
        } else {
            this$0.m(variantUIData.getNeedAnima());
        }
    }

    @Override // com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer, com.tencent.biz.qqcircle.publish.plusentry.composer.a
    @CallSuper
    public void a() {
        if (!n()) {
            QLog.d(d(), 1, "deInit, is not enable ");
            return;
        }
        super.a();
        Observer<VariantUIData> observer = this.ptkObserver;
        if (observer != null) {
            g().d2().removeObserver(observer);
        }
        m(false);
    }

    @Override // com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer, com.tencent.biz.qqcircle.publish.plusentry.composer.a
    public void b() {
        if (!n()) {
            QLog.d(d(), 1, "startInit, is not enable ");
            return;
        }
        super.b();
        LiveData<VariantUIData> d26 = g().d2();
        LifecycleOwner hostLifecycleOwner = getPartHost().getHostLifecycleOwner();
        Observer<VariantUIData> observer = new Observer() { // from class: com.tencent.biz.qqcircle.publish.plusentry.composer.operationpos.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BasePlusEntryOperationPosComposer.q(BasePlusEntryOperationPosComposer.this, (VariantUIData) obj);
            }
        };
        this.ptkObserver = observer;
        Unit unit = Unit.INSTANCE;
        d26.observe(hostLifecycleOwner, observer);
    }

    @Override // com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer
    @NotNull
    public String d() {
        return "PlusEntry-BasePlusEntryOperationPosComposer";
    }

    @NotNull
    public final BasePlusEntryOperationPosComposer j(@NotNull PlusEntryExp exp) {
        Intrinsics.checkNotNullParameter(exp, "exp");
        if (!g().x2() && !g().v2()) {
            if (exp == PlusEntryExp.DEFAULT) {
                return new c(getPartHost(), getPlusEntryLayout());
            }
            if (exp == PlusEntryExp.EXP_B) {
                return new d(getPartHost(), getPlusEntryLayout());
            }
            if (exp == PlusEntryExp.EXP_C) {
                return new e(getPartHost(), getPlusEntryLayout());
            }
            if (exp == PlusEntryExp.EXP_D) {
                return new f(getPartHost(), getPlusEntryLayout());
            }
            if (exp == PlusEntryExp.EXP_E) {
                return new g(getPartHost(), getPlusEntryLayout());
            }
            return new BasePlusEntryOperationPosComposer(getPartHost(), getPlusEntryLayout());
        }
        return new b(getPartHost(), getPlusEntryLayout());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: k, reason: from getter */
    public final ImageView getIvOperation() {
        return this.ivOperation;
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public View getNormalView() {
        return this.normalView;
    }

    public void m(boolean needAnima) {
        if (!n()) {
            QLog.d(d(), 1, "hideOperationView, is not enable ");
            return;
        }
        if (!this.isShowingOperationView) {
            QLog.d(d(), 1, "hideOperationView, is not showing ");
            return;
        }
        QLog.d(d(), 1, "hideOperationView ");
        this.feedVariantInfo = null;
        this.isShowingOperationView = false;
        ao.a(getNormalView(), this.ivOperation, needAnima, null);
    }

    protected final boolean n() {
        if (getNormalView() != null && this.ivOperation != null) {
            return true;
        }
        return false;
    }

    public boolean o() {
        if (!n()) {
            QLog.d(d(), 1, "onInterceptClick, is not enable ");
            return false;
        }
        QLog.d(d(), 1, "onInterceptClick ");
        QFSPublishFeedVariantInfo qFSPublishFeedVariantInfo = this.feedVariantInfo;
        if (qFSPublishFeedVariantInfo == null) {
            return false;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("xsj_resource_type", "1");
        linkedHashMap.put("xsj_tianshu_task_id", qFSPublishFeedVariantInfo.getBtnAdId());
        QFSPublishFeedViewModel g16 = g();
        Context context = c();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        g16.h2(context, qFSPublishFeedVariantInfo.getBtnJumpUrl(), g().getFromType(), linkedHashMap);
        com.tencent.biz.qqcircle.wink.e eVar = com.tencent.biz.qqcircle.wink.e.f93946a;
        eVar.B(102, qFSPublishFeedVariantInfo.getBtnAdId(), qFSPublishFeedVariantInfo.getBtnTraceInfo());
        eVar.l(new DTButtonInfo(qFSPublishFeedVariantInfo.getBtnAdId(), ""));
        return true;
    }

    public void p(@NotNull QFSPublishFeedVariantInfo feedVariantInfo) {
        Intrinsics.checkNotNullParameter(feedVariantInfo, "feedVariantInfo");
        if (!n()) {
            QLog.d(d(), 1, "showOperationView, is not enable ");
            return;
        }
        QLog.d(d(), 1, "showOperationView ");
        this.feedVariantInfo = feedVariantInfo;
        this.isShowingOperationView = true;
        Option obtain = Option.obtain();
        obtain.setUrl(feedVariantInfo.getBtnIcon()).setPredecode(true).setTargetView(this.ivOperation);
        QCircleFeedPicLoader.g().loadImage(obtain, new QCirclePicStateListener() { // from class: com.tencent.biz.qqcircle.publish.plusentry.composer.operationpos.BasePlusEntryOperationPosComposer$showOperationView$1
            @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
            public void onStateChange(@NotNull LoadState state, @NotNull Option option) {
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(option, "option");
                if (state == LoadState.STATE_SUCCESS) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new BasePlusEntryOperationPosComposer$showOperationView$1$onStateChange$1(BasePlusEntryOperationPosComposer.this, null), 3, null);
                }
            }
        });
        com.tencent.biz.qqcircle.wink.e.f93946a.B(101, feedVariantInfo.getBtnAdId(), feedVariantInfo.getBtnTraceInfo());
    }
}
