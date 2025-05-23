package com.tencent.mobileqq.troop.homework.common.widget.mediaedit;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qs2.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0000H\u0002\u00a8\u0006\t"}, d2 = {"Landroid/view/View;", "Lqs2/a;", "c", "", "info", "", "d", "view", "b", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/troop/homework/common/widget/mediaedit/b$a", "Lqs2/a;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "y", "j", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "height", "w", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements qs2.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // qs2.a
        public void c(@Nullable Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            } else {
                a.C11097a.a(this, activity);
            }
        }

        @Override // qs2.a
        public void j(@NotNull BaseItem item) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) item);
                return;
            }
            Intrinsics.checkNotNullParameter(item, "item");
            b.d("reUploadItem:" + item);
        }

        @Override // qs2.a
        public void m(@NotNull BaseItem item, @Nullable Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) item, (Object) activity);
                return;
            }
            Intrinsics.checkNotNullParameter(item, "item");
            b.d("item:" + item);
        }

        @Override // qs2.a
        public void w(int height) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, height);
                return;
            }
            b.d("notifyRecyclerViewHeight:" + height);
        }

        @Override // qs2.a
        public void y(@NotNull BaseItem item) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
                return;
            }
            Intrinsics.checkNotNullParameter(item, "item");
            b.d("deleteItem:" + item);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final qs2.a b(View view) {
        View view2 = null;
        if (view == 0) {
            return null;
        }
        if (view instanceof qs2.a) {
            return (qs2.a) view;
        }
        Object parent = view.getParent();
        if (parent instanceof View) {
            view2 = (View) parent;
        }
        return b(view2);
    }

    @NotNull
    public static final qs2.a c(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        qs2.a b16 = b(view);
        if (b16 == null) {
            return new a();
        }
        return b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str) {
        QLog.e("HW.MediaEdit.", 1, str);
    }
}
