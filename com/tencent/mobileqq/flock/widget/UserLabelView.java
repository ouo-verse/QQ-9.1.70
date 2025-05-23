package com.tencent.mobileqq.flock.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tenpay.proxy.dlg.location.QbAddrData;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y45.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\f\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/flock/widget/UserLabelView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Ly45/o;", QCircleAlphaUserReporter.KEY_USER, "", "a", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class UserLabelView extends AppCompatTextView {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserLabelView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0100 A[LOOP:0: B:38:0x00fe->B:39:0x0100, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011e A[LOOP:1: B:42:0x0118->B:44:0x011e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(@NotNull o user) {
        Drawable drawable;
        boolean z16;
        int indexOf$default;
        Iterator it;
        boolean isBlank;
        boolean z17;
        boolean isBlank2;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) user);
            return;
        }
        Intrinsics.checkNotNullParameter(user, "user");
        StringBuilder sb5 = new StringBuilder();
        if (com.tencent.mobileqq.flock.ktx.e.f(user)) {
            sb5.append("  \u5973");
            drawable = getContext().getDrawable(R.drawable.jmm);
        } else if (com.tencent.mobileqq.flock.ktx.e.i(user)) {
            sb5.append("  \u7537");
            drawable = getContext().getDrawable(R.drawable.jmt);
        } else {
            drawable = null;
        }
        if (user.f449453e > 0) {
            if (sb5.length() == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                sb5.append(user.f449453e + "\u5c81");
            } else {
                sb5.append(APLogFileUtil.SEPARATOR_LOG + user.f449453e + "\u5c81");
            }
        }
        String str = user.f449454f;
        if (str != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    if (sb5.length() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        sb5.append(String.valueOf(user.f449454f));
                    } else {
                        sb5.append(APLogFileUtil.SEPARATOR_LOG + user.f449454f);
                    }
                }
                SpannableString spannableString = new SpannableString(sb5.toString());
                if (drawable != null) {
                    drawable.setBounds(0, 0, com.tencent.mobileqq.flock.ktx.i.b(12), com.tencent.mobileqq.flock.ktx.i.b(12));
                    spannableString.setSpan(new ImageSpan(drawable, 2), 0, 1, 33);
                }
                ArrayList arrayList = new ArrayList();
                for (indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) spannableString, QbAddrData.DATA_SPLITER, 0, false, 6, (Object) null); indexOf$default >= 0; indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) spannableString, QbAddrData.DATA_SPLITER, indexOf$default + 1, false, 4, (Object) null)) {
                    arrayList.add(Integer.valueOf(indexOf$default));
                }
                it = arrayList.iterator();
                while (it.hasNext()) {
                    int intValue = ((Number) it.next()).intValue();
                    spannableString.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.qui_common_border_standard)), intValue, intValue + 1, 33);
                }
                isBlank = StringsKt__StringsJVMKt.isBlank(spannableString);
                if (!isBlank) {
                    setVisibility(8);
                    return;
                } else {
                    setText(spannableString);
                    setVisibility(0);
                    return;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
        SpannableString spannableString2 = new SpannableString(sb5.toString());
        if (drawable != null) {
        }
        ArrayList arrayList2 = new ArrayList();
        while (indexOf$default >= 0) {
        }
        it = arrayList2.iterator();
        while (it.hasNext()) {
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(spannableString2);
        if (!isBlank) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserLabelView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserLabelView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
    }
}
