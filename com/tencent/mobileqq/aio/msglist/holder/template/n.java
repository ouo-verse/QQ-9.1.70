package com.tencent.mobileqq.aio.msglist.holder.template;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH&J\n\u0010\r\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\bH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH&J\n\u0010\u0013\u001a\u0004\u0018\u00010\bH&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH&J\n\u0010\u0019\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH&J\n\u0010\u001b\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\u001c\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH&J\n\u0010\u001d\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\u001e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\u001f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\bH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\bH&J\n\u0010#\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010%\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0006H\u0016\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/template/n;", "", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "isSelf", "Landroid/view/View;", "d", "view", "", "f", "a", "g", "b", "Landroid/view/ViewStub;", "o", "c", "e", "r", "Lcom/tencent/qqnt/aio/holder/template/d;", "intercepter", HippyTKDListViewAdapter.X, ReportConstant.COSTREPORT_PREFIX, "l", "t", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "p", "i", "v", "j", tl.h.F, DomainData.DOMAIN_NAME, "k", "w", "isWideScreen", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface n {
    @Nullable
    View a();

    @Nullable
    View b();

    void c(@Nullable View view);

    @NotNull
    View d(@NotNull Context context, @NotNull ViewGroup parent, boolean isSelf);

    @Nullable
    View e();

    void f(@Nullable View view);

    void g(@Nullable View view);

    @Nullable
    ViewStub h();

    @Nullable
    View i();

    @Nullable
    View j(@NotNull View view);

    @Nullable
    ViewStub k();

    @Nullable
    View l();

    void m(@Nullable View view);

    @Nullable
    ViewStub n();

    @Nullable
    ViewStub o();

    void p(@Nullable View view);

    void q(boolean isWideScreen);

    @Nullable
    ViewStub r();

    void s(@Nullable View view);

    void t(@Nullable View view);

    @Nullable
    View u();

    @Nullable
    View v();

    @Nullable
    ViewStub w();

    void x(@NotNull com.tencent.qqnt.aio.holder.template.d intercepter);

    @Nullable
    View y();

    void z(@Nullable View view);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class a {
        @Nullable
        public static ViewStub a(@NotNull n nVar) {
            return null;
        }

        @Nullable
        public static ViewStub b(@NotNull n nVar) {
            return null;
        }

        @Nullable
        public static ViewStub c(@NotNull n nVar) {
            return null;
        }

        @Nullable
        public static ViewStub d(@NotNull n nVar) {
            return null;
        }

        @Nullable
        public static ViewStub e(@NotNull n nVar) {
            return null;
        }

        @Nullable
        public static View f(@NotNull n nVar) {
            return null;
        }

        @Nullable
        public static ViewStub g(@NotNull n nVar) {
            return null;
        }

        public static void h(@NotNull n nVar, @Nullable View view) {
        }

        public static void i(@NotNull n nVar, boolean z16) {
        }
    }
}
