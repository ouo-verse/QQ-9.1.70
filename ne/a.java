package ne;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.widget.i;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import vg.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b`\u0010aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H$J\b\u0010\u0007\u001a\u00020\u0006H$J\b\u0010\t\u001a\u00020\bH$J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH$J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH$J\u0006\u0010\u0010\u001a\u00020\u0004J\u0010\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u0014\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u0006J\b\u0010\u0015\u001a\u00020\u0006H\u0004J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0004J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\bH\u0007J\u0010\u0010$\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"J\u0012\u0010'\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010%H\u0004J\u0012\u0010(\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J+\u0010-\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010**\u0004\u0018\u00010)2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010+\u00a2\u0006\u0004\b-\u0010.J#\u00101\u001a\u00028\u0000\"\u0004\b\u0000\u0010/2\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000+H\u0004\u00a2\u0006\u0004\b1\u00102J\u0010\u00105\u001a\u00020\u00022\b\u00104\u001a\u0004\u0018\u000103J\u0006\u00106\u001a\u00020\u0004R$\u0010=\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010A\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b>\u00108\u001a\u0004\b?\u0010:\"\u0004\b@\u0010<R\u0018\u0010C\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010BR$\u0010I\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010L\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010D\u001a\u0004\bJ\u0010F\"\u0004\bK\u0010HR\"\u0010R\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR.\u0010Y\u001a\u0004\u0018\u00010S2\b\u0010T\u001a\u0004\u0018\u00010S8\u0006@DX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010U\u001a\u0004\b>\u0010V\"\u0004\bW\u0010XR$\u0010_\u001a\u0004\u0018\u0001038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^\u00a8\u0006b"}, d2 = {"Lne/a;", "Lvg/c;", "", "b", "", h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "Landroid/view/View;", "containerView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", HippyTKDListViewAdapter.X, "o", MosaicConstants$JsProperty.PROP_ROOT_VIEW, ReportConstant.COSTREPORT_PREFIX, "position", "B", DomainData.DOMAIN_NAME, "t", "c", "onPaused", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "w", "y", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewHolderAttachedToWindow", "onViewHolderDetachedFromWindow", "v", "Lne/b;", "sectionManager", BdhLogUtil.LogTag.Tag_Conn, "Lcf/b;", "event", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "r", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "VM", "Ljava/lang/Class;", "viewModelClass", "p", "(Ljava/lang/Class;)Lcom/tencent/biz/richframework/part/BaseViewModel;", "T", "iocClass", "g", "(Ljava/lang/Class;)Ljava/lang/Object;", "Landroid/view/ViewGroup;", "parentView", "D", "f", "d", "Landroid/view/View;", "i", "()Landroid/view/View;", "setMContainerView", "(Landroid/view/View;)V", "mContainerView", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setMRootView", "mRootView", "Lne/b;", "mSectionManager", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "j", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "setMFeedData", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;)V", "mFeedData", "k", "setMForwardFeedData", "mForwardFeedData", "I", "l", "()I", "setMPosition", "(I)V", "mPosition", "Landroid/app/Activity;", "<set-?>", "Landroid/app/Activity;", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/ViewGroup;", "getMParentView", "()Landroid/view/ViewGroup;", "setMParentView", "(Landroid/view/ViewGroup;)V", "mParentView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class a implements c {

    /* renamed from: C, reason: from kotlin metadata */
    private Activity activity;

    /* renamed from: D, reason: from kotlin metadata */
    private ViewGroup mParentView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mContainerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private b mSectionManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private CommonFeed mFeedData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CommonFeed mForwardFeedData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mPosition;

    private final void b() {
        if (this.mRootView == null) {
            QLog.e(getTAG(), 1, "checkInitView  mRootView == null");
            return;
        }
        if (this.mContainerView != null) {
            return;
        }
        b bVar = this.mSectionManager;
        Intrinsics.checkNotNull(bVar);
        View g16 = bVar.g(q());
        if (g16 == null) {
            View view = this.mRootView;
            Intrinsics.checkNotNull(view);
            ViewStub viewStub = (ViewStub) view.findViewById(q());
            if (viewStub != null) {
                jo.h hVar = jo.h.f410717a;
                hVar.g("item_view_stub_inflate").h(getTAG() + "#view_stub_inflate");
                hVar.b(getTAG() + "#view_stub_inflate");
                View g17 = jm.b.f410600a.g(viewStub);
                hVar.d();
                hVar.g("item_view_stub_inflate").b(getTAG() + "#view_stub_inflate");
                g16 = g17;
            }
        }
        if (g16 == null) {
            QLog.e(getTAG(), 1, "checkInitView  viewStub == null");
            return;
        }
        b bVar2 = this.mSectionManager;
        Intrinsics.checkNotNull(bVar2);
        bVar2.a(q(), g16);
        this.mContainerView = g16;
        Intrinsics.checkNotNull(g16);
        z(g16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void A(cf.b event) {
        b bVar = this.mSectionManager;
        if (bVar == null) {
            return;
        }
        Intrinsics.checkNotNull(bVar);
        bVar.b(event);
    }

    public final void B(CommonFeed feedData, int position) {
        if (u() && t(feedData)) {
            this.mFeedData = CommonFeedExtKt.getCellOriginFeed(feedData);
            this.mForwardFeedData = feedData;
        } else {
            this.mFeedData = feedData;
        }
        this.mPosition = position;
        CommonFeed commonFeed = this.mFeedData;
        if (commonFeed != null) {
            x(commonFeed);
        }
    }

    public final void C(b sectionManager) {
        this.mSectionManager = sectionManager;
    }

    public final void D(ViewGroup parentView) {
        this.mParentView = parentView;
    }

    /* renamed from: e, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    public final String f() {
        Activity activity = this.activity;
        return String.valueOf(activity != null ? Integer.valueOf(activity.hashCode()) : null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T g(Class<T> iocClass) {
        Integer num;
        Intrinsics.checkNotNullParameter(iocClass, "iocClass");
        T t16 = (T) RFWIocAbilityProvider.g().getIocInterface(iocClass, this.mRootView, this.mParentView);
        String str = "qioc-" + getTAG();
        int i3 = RFWLog.USR;
        String simpleName = iocClass.getSimpleName();
        View view = this.mRootView;
        if (view != null) {
            num = Integer.valueOf(view != null ? view.hashCode() : 0);
        } else {
            num = null;
        }
        RFWLog.i(str, i3, "getIocInterface  | iocClass = " + simpleName + " | iocInterface = " + t16 + " | this = " + this + " | viewHash = " + num);
        return t16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public abstract String getTAG();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i, reason: from getter */
    public final View getMContainerView() {
        return this.mContainerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j, reason: from getter */
    public final CommonFeed getMFeedData() {
        return this.mFeedData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k, reason: from getter */
    public final CommonFeed getMForwardFeedData() {
        return this.mForwardFeedData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: l, reason: from getter */
    public final int getMPosition() {
        return this.mPosition;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: m, reason: from getter */
    public final View getMRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int n() {
        b bVar = this.mSectionManager;
        if (bVar != null) {
            return bVar.e();
        }
        return 0;
    }

    public final String o() {
        return getTAG();
    }

    @Override // vg.c
    public void onViewHolderAttachedToWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // vg.c
    public void onViewHolderDetachedFromWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    public final <VM extends BaseViewModel> VM p(Class<VM> viewModelClass) {
        View view = this.mRootView;
        if (!(view instanceof QZoneBaseWidgetView)) {
            return null;
        }
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qzone.reborn.widget.QZoneBaseWidgetView<*>");
        return (VM) ((QZoneBaseWidgetView) view).p(viewModelClass);
    }

    protected abstract int q();

    public final void s(View rootView) {
        this.mRootView = rootView;
        this.activity = i.c(rootView);
        b();
    }

    protected final boolean t(CommonFeed feedData) {
        return CommonFeedExtKt.isForwardFeed(feedData) || CommonFeedExtKt.isShareFeed(feedData);
    }

    protected abstract boolean u();

    public final boolean v() {
        return !lm.a.f414989a.g(this);
    }

    protected abstract void x(CommonFeed feedData);

    protected abstract void z(View containerView);

    @Override // vg.c
    public void c() {
    }

    @Override // vg.c
    public void onDestroy() {
    }

    @Override // vg.c
    public void onPaused() {
    }

    @Override // vg.c
    public void onStop() {
    }

    public void w() {
    }

    public void y() {
    }

    public void r(cf.b event) {
    }
}
