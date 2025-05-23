package com.tencent.mobileqq.aio.helper;

import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J:\u0010\n\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005H\u0002J$\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/bg;", "Lcom/tencent/aio/main/businesshelper/h;", "", "c", "", "Landroid/view/View;", "emptyViews", "visibleViews", "viewStubViews", "view", "b", "g", "v", "", "e", "Landroid/content/res/Resources;", "r", "", "id", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "out", "a", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "getTag", "getId", "state", "onMoveToState", "", "interestedIn", "Landroidx/fragment/app/Fragment;", "d", "Landroidx/fragment/app/Fragment;", "mFragment", "", "Z", "mSimple", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class bg implements com.tencent.aio.main.businesshelper.h {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Fragment mFragment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean mSimple;

    public bg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mSimple = true;
        }
    }

    private final void a(Resources r16, int id5, StringBuilder out) {
        String str;
        int i3 = (-16777216) & id5;
        if (i3 != 16777216) {
            if (i3 != 2130706432) {
                try {
                    str = r16.getResourcePackageName(id5);
                    Intrinsics.checkNotNullExpressionValue(str, "r.getResourcePackageName(id)");
                } catch (Resources.NotFoundException e16) {
                    out.append(id5);
                    QLog.d(getTag(), 1, "Resources.NotFoundException", e16);
                    return;
                }
            } else {
                str = "app";
            }
        } else {
            str = "android";
        }
        String resourceTypeName = r16.getResourceTypeName(id5);
        String resourceEntryName = r16.getResourceEntryName(id5);
        out.append(str);
        out.append(":");
        out.append(resourceTypeName);
        out.append("/");
        out.append(resourceEntryName);
    }

    private final void b(List<View> emptyViews, List<View> visibleViews, List<View> viewStubViews, View view) {
        boolean z16;
        if (view.getClass().getSimpleName().equals("ViewStub")) {
            viewStubViews.add(view);
        } else {
            if (view.getMeasuredHeight() != 0 && view.getMeasuredWidth() != 0) {
                if (view.getVisibility() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    visibleViews.add(view);
                }
            }
            emptyViews.add(view);
        }
        if (view instanceof ViewGroup) {
            Iterator<View> it = ViewGroupKt.getChildren((ViewGroup) view).iterator();
            while (it.hasNext()) {
                b(emptyViews, visibleViews, viewStubViews, it.next());
            }
        }
    }

    private final void c() {
        QLog.d(getTag(), 1, "delayLoad");
        if (!com.tencent.qqnt.aio.d.INSTANCE.b()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Fragment fragment = this.mFragment;
        if (fragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFragment");
            fragment = null;
        }
        View view = fragment.getView();
        if (view != null) {
            b(arrayList, arrayList2, arrayList3, view);
        }
        Iterator<View> it = arrayList2.iterator();
        while (it.hasNext()) {
            g(it.next());
        }
        QLog.d(getTag(), 1, "------------------------------------------------------------------------------------");
        Iterator<View> it5 = arrayList3.iterator();
        while (it5.hasNext()) {
            g(it5.next());
        }
        QLog.d(getTag(), 1, "------------------------------------------------------------------------------------");
        Iterator<View> it6 = arrayList.iterator();
        while (it6.hasNext()) {
            g(it6.next());
        }
    }

    private final String e(View v3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("id=");
        int id5 = v3.getId();
        if (id5 == -1) {
            sb5.append("#NO_ID");
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "out.toString()");
            return sb6;
        }
        if (id5 > 0 && (id5 >>> 24) != 0) {
            Resources resources = v3.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "v.resources");
            a(resources, id5, sb5);
            String sb7 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb7, "out.toString()");
            return sb7;
        }
        sb5.append(id5);
        String sb8 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb8, "out.toString()");
        return sb8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0024, code lost:
    
        if (r1 != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void g(View view) {
        boolean startsWith$default;
        boolean startsWith$default2;
        String name = view.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(name, "android.view.", false, 2, null);
        if (!startsWith$default) {
            Intrinsics.checkNotNullExpressionValue(name, "name");
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(name, "android.widget.", false, 2, null);
        }
        name = view.getClass().getSimpleName();
        if (this.mSimple) {
            Log.d(getTag(), name + "{" + e(view) + ", w=" + view.getMeasuredWidth() + ", h=" + view.getMeasuredHeight() + "}");
            return;
        }
        String tag = getTag();
        String e16 = e(view);
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        String hexString = Integer.toHexString(view.getId());
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        Log.d(tag, name + "{" + e16 + ", w=" + measuredWidth + ", h=" + measuredHeight + ", id=#" + hexString + ", pid=#" + Integer.toHexString(((View) parent).getId()) + "}");
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 20;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "ViewMonitorHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (int[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new int[]{4};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Fragment c16 = param.a().c();
        Intrinsics.checkNotNullExpressionValue(c16, "param.aioContext.fragment");
        this.mFragment = c16;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            h.a.b(this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, state);
        } else if (state == 4) {
            c();
        }
    }
}
