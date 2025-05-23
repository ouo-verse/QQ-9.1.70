package com.tencent.mobileqq.addfriend.ui.fornt.verify.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001f\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/p;", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/v;", "Landroid/view/View$OnTouchListener;", "", "ba", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartStart", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/w;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/w;", "mRequestInfoTW", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/TextView;", "mRequestInfoTxt", "Landroid/widget/EditText;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/EditText;", "mRequestInfoEt", "Landroid/widget/LinearLayout;", "T", "Landroid/widget/LinearLayout;", "mAnswerCorrectLl", "U", "mAnswerCheckLl", "<init>", "()V", "V", "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class p extends v implements View.OnTouchListener {
    static IPatchRedirector $redirector_;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private w mRequestInfoTW;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private TextView mRequestInfoTxt;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private EditText mRequestInfoEt;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mAnswerCorrectLl;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mAnswerCheckLl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/p$a;", "", "", "MAX_REQUEST_INFO_BYTES", "I", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.p$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23682);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void ba() {
        EditText editText;
        TextView textView;
        LinearLayout linearLayout;
        View findViewById = getPartRootView().findViewById(R.id.f166785i82);
        LinearLayout linearLayout2 = null;
        if (findViewById instanceof EditText) {
            editText = (EditText) findViewById;
        } else {
            editText = null;
        }
        this.mRequestInfoEt = editText;
        View findViewById2 = getPartRootView().findViewById(R.id.f166786i83);
        if (findViewById2 instanceof TextView) {
            textView = (TextView) findViewById2;
        } else {
            textView = null;
        }
        this.mRequestInfoTxt = textView;
        EditText editText2 = this.mRequestInfoEt;
        if (editText2 == null) {
            editText2 = new EditText(getContext());
        }
        w wVar = new w(100, editText2);
        this.mRequestInfoTW = wVar;
        EditText editText3 = this.mRequestInfoEt;
        if (editText3 != null) {
            editText3.addTextChangedListener(wVar);
        }
        EditText editText4 = this.mRequestInfoEt;
        if (editText4 != null) {
            editText4.setOnTouchListener(this);
        }
        View findViewById3 = getPartRootView().findViewById(R.id.f6v);
        if (findViewById3 instanceof LinearLayout) {
            linearLayout = (LinearLayout) findViewById3;
        } else {
            linearLayout = null;
        }
        this.mAnswerCorrectLl = linearLayout;
        View findViewById4 = getPartRootView().findViewById(R.id.f164345si);
        if (findViewById4 instanceof LinearLayout) {
            linearLayout2 = (LinearLayout) findViewById4;
        }
        this.mAnswerCheckLl = linearLayout2;
    }

    @Override // com.tencent.mobileqq.addfriend.ui.fornt.verify.part.v, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            super.onPartCreate(activity, savedInstanceState);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.onPartStart(activity);
            ba();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
        boolean z16;
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3, (Object) event)).booleanValue();
        }
        boolean z17 = true;
        if (v3 != null && v3.getId() == R.id.dmu) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (event != null) {
                num = Integer.valueOf(event.getAction() & 255);
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 0) {
                v3.getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                if ((num == null || num.intValue() != 1) && (num == null || num.intValue() != 3)) {
                    z17 = false;
                }
                if (z17) {
                    v3.getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
        }
        return false;
    }
}
