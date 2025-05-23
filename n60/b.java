package n60;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.PartLifecycleCallbacks;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import cooperation.qqcircle.report.QCircleReportBean;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u00a2\u0006\u0004\b-\u0010.J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0004J#\u0010\u0007\u001a\u00028\u0000\"\n\b\u0000\u0010\u0004*\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH&J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u001a\u0010\u0019\u001a\u00020\u00158\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u00058DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\"R\u0014\u0010%\u001a\u00020\u00058DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010\"R\u0014\u0010)\u001a\u00020&8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010\u0011\u001a\u00020*8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\u00a8\u0006/"}, d2 = {"Ln60/b;", "Lcom/tencent/biz/richframework/part/PartLifecycleCallbacks;", "Landroid/view/View;", "i", "T", "", "id", "a", "(I)Landroid/view/View;", "Landroid/content/res/Configuration;", "newConfig", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", DomainData.DOMAIN_NAME, "o", "Lcom/tencent/biz/qqcircle/immersive/QFSBaseFragment;", "fragment", "j", "", "k", "Ln60/a;", "d", "Ln60/a;", "()Ln60/a;", "mParentView", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/t;", "e", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/t;", "mUserViewModel", "Landroid/content/Context;", "b", "()Landroid/content/Context;", "context", "()I", "pageId", "f", "parentPageId", "Lcooperation/qqcircle/report/QCircleReportBean;", "g", "()Lcooperation/qqcircle/report/QCircleReportBean;", "reportBean", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "c", "()Lcom/tencent/biz/richframework/part/BasePartFragment;", "<init>", "(Ln60/a;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public abstract class b implements PartLifecycleCallbacks {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mParentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    protected com.tencent.biz.qqcircle.immersive.personal.viewmodel.t mUserViewModel;

    public b(@NotNull a mParentView) {
        Intrinsics.checkNotNullParameter(mParentView, "mParentView");
        this.mParentView = mParentView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T extends View> T a(int id5) {
        return (T) this.mParentView.z().findViewById(id5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Context b() {
        Context context = this.mParentView.z().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mParentView.itemView.context");
        return context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final BasePartFragment c() {
        BasePartFragment fragment = this.mParentView.getFragment();
        Intrinsics.checkNotNullExpressionValue(fragment, "mParentView.fragment");
        return fragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: d, reason: from getter */
    public final a getMParentView() {
        return this.mParentView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int e() {
        return this.mParentView.F();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int f() {
        return this.mParentView.K();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final QCircleReportBean g() {
        QCircleReportBean m3 = this.mParentView.m();
        Intrinsics.checkNotNullExpressionValue(m3, "mParentView.viewReportBean");
        return m3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final View i() {
        return this.mParentView.z();
    }

    public abstract void j(@NotNull QFSBaseFragment fragment);

    public boolean k() {
        return true;
    }

    public abstract void o();

    @Override // com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public /* synthetic */ void onPartDestroy(Activity activity) {
        com.tencent.biz.richframework.part.b.b(this, activity);
    }

    public /* synthetic */ void p(Activity activity) {
        com.tencent.biz.richframework.part.b.c(this, activity);
    }

    public /* synthetic */ void q(Activity activity) {
        com.tencent.biz.richframework.part.b.d(this, activity);
    }

    public /* synthetic */ void r(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    public /* synthetic */ void s(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    public void l() {
    }

    public void n() {
    }

    public void m(@Nullable Configuration newConfig) {
    }
}
