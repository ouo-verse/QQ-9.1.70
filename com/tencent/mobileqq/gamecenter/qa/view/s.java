package com.tencent.mobileqq.gamecenter.qa.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.InputMethodUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0002MNB\u0017\u0012\u0006\u0010H\u001a\u00020G\u0012\u0006\u0010I\u001a\u00020\u0014\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J&\u0010\f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J$\u0010\u0012\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0013\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\tJ\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010,\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010#R\u0016\u0010.\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010#R\u0016\u00100\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010#R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010F\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010C\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/view/s;", "Landroid/app/Dialog;", "Landroid/view/View$OnClickListener;", "", "W", "Landroid/content/res/Resources;", "U", "Lcom/tencent/mobileqq/gamecenter/qa/view/ab;", TtmlNode.TAG_SPAN, "", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "title", "X", "Landroid/view/View;", "view", "Y", ExifInterface.LATITUDE_SOUTH, "a0", "e0", "setTitle", "", "layoutResID", "setContentView", "tips", "d0", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/gamecenter/qa/view/s$b;", "listener", "c0", "", "isNightTheme", "b0", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "tvTips", "Landroid/widget/EditText;", "D", "Landroid/widget/EditText;", "etLink", "E", "etTitle", UserInfo.SEX_FEMALE, "tvAdd", "G", "tvCancel", "H", "tvTitleCount", "Landroid/widget/RelativeLayout;", "I", "Landroid/widget/RelativeLayout;", "rlRoot", "J", "Landroid/view/View;", "vDivider", "K", "Lcom/tencent/mobileqq/gamecenter/qa/view/s$b;", "mListener", "L", "Lcom/tencent/mobileqq/gamecenter/qa/view/ab;", "mSpan", "M", "Z", "mIsNightTheme", "Landroid/text/TextWatcher;", "N", "Landroid/text/TextWatcher;", "mLinkWatcher", "P", "mTittleWatcher", "Landroid/content/Context;", "context", "themeResId", "<init>", "(Landroid/content/Context;I)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "b", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class s extends ReportDialog implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView tvTips;

    /* renamed from: D, reason: from kotlin metadata */
    private EditText etLink;

    /* renamed from: E, reason: from kotlin metadata */
    private EditText etTitle;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView tvAdd;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView tvCancel;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView tvTitleCount;

    /* renamed from: I, reason: from kotlin metadata */
    private RelativeLayout rlRoot;

    /* renamed from: J, reason: from kotlin metadata */
    private View vDivider;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private b mListener;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ab mSpan;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mIsNightTheme;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final TextWatcher mLinkWatcher;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final TextWatcher mTittleWatcher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J&\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/view/s$b;", "", "", "onCancel", "", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "title", "Lcom/tencent/mobileqq/gamecenter/qa/view/ab;", TtmlNode.TAG_SPAN, "a", "b", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface b {
        void a(@Nullable String link, @Nullable String title, @Nullable ab span);

        void b(@Nullable String link);

        void onCancel();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/view/s$c", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable s16) {
            int i3;
            boolean z16;
            Intrinsics.checkNotNullParameter(s16, "s");
            b bVar = s.this.mListener;
            if (bVar != null) {
                EditText editText = s.this.etLink;
                if (editText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("etLink");
                    editText = null;
                }
                String obj = editText.getText().toString();
                int length = obj.length() - 1;
                int i16 = 0;
                boolean z17 = false;
                while (i16 <= length) {
                    if (!z17) {
                        i3 = i16;
                    } else {
                        i3 = length;
                    }
                    if (Intrinsics.compare((int) obj.charAt(i3), 32) <= 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z17) {
                        if (!z16) {
                            z17 = true;
                        } else {
                            i16++;
                        }
                    } else if (!z16) {
                        break;
                    } else {
                        length--;
                    }
                }
                bVar.b(obj.subSequence(i16, length + 1).toString());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence s16, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence s16, int start, int before, int count) {
            Intrinsics.checkNotNullParameter(s16, "s");
            s.this.a0();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/view/s$d", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d implements TextWatcher {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f213190e;

        d(Context context) {
            this.f213190e = context;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable s16) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence s16, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence s16, int start, int before, int count) {
            Intrinsics.checkNotNullParameter(s16, "s");
            TextView textView = s.this.tvTitleCount;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTitleCount");
                textView = null;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = this.f213190e.getResources().getString(R.string.f1371105z);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026trategy_link_title_limit)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(s16.length()), 24}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(@NotNull Context context, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        W();
        this.mLinkWatcher = new c();
        this.mTittleWatcher = new d(context);
    }

    private final void S() {
        if (this.mIsNightTheme) {
            TextView textView = this.tvTips;
            View view = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTips");
                textView = null;
            }
            textView.setTextColor(U().getColor(R.color.f158017al3));
            EditText editText = this.etLink;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etLink");
                editText = null;
            }
            editText.setTextColor(U().getColor(R.color.f157839cg1));
            EditText editText2 = this.etLink;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etLink");
                editText2 = null;
            }
            editText2.setHintTextColor(U().getColor(R.color.cfx));
            EditText editText3 = this.etLink;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etLink");
                editText3 = null;
            }
            editText3.setBackground(U().getDrawable(R.drawable.jqd));
            EditText editText4 = this.etTitle;
            if (editText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etTitle");
                editText4 = null;
            }
            editText4.setTextColor(U().getColor(R.color.f157839cg1));
            EditText editText5 = this.etTitle;
            if (editText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etTitle");
                editText5 = null;
            }
            editText5.setHintTextColor(U().getColor(R.color.cfx));
            EditText editText6 = this.etTitle;
            if (editText6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etTitle");
                editText6 = null;
            }
            editText6.setBackground(U().getDrawable(R.drawable.jqd));
            TextView textView2 = this.tvAdd;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAdd");
                textView2 = null;
            }
            textView2.setTextColor(U().getColor(R.color.f158017al3));
            TextView textView3 = this.tvCancel;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvCancel");
                textView3 = null;
            }
            textView3.setTextColor(U().getColor(R.color.f158017al3));
            TextView textView4 = this.tvTitleCount;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTitleCount");
                textView4 = null;
            }
            textView4.setTextColor(U().getColor(R.color.cfx));
            RelativeLayout relativeLayout = this.rlRoot;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rlRoot");
                relativeLayout = null;
            }
            relativeLayout.setBackground(com.tencent.mobileqq.gamecenter.qa.util.k.h(0, cx.a(6.0f), -1, U().getColor(R.color.cfs)));
            View view2 = this.vDivider;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vDivider");
            } else {
                view = view2;
            }
            view.setBackgroundColor(U().getColor(R.color.cfu));
        }
    }

    private final Resources U() {
        Resources resources = BaseApplication.getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getContext().resources");
        return resources;
    }

    private final void W() {
        Window window = super.getWindow();
        Intrinsics.checkNotNull(window);
        window.setWindowAnimations(R.style.f173401cf);
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setDimAmount(0.5f);
    }

    private final void X(ab span, String link, String title) {
        this.mSpan = span;
        EditText editText = this.etLink;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etLink");
            editText = null;
        }
        editText.setText(link);
        EditText editText3 = this.etTitle;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etTitle");
            editText3 = null;
        }
        editText3.setText(title);
        EditText editText4 = this.etLink;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etLink");
            editText4 = null;
        }
        EditText editText5 = this.etLink;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etLink");
        } else {
            editText2 = editText5;
        }
        editText4.setSelection(0, editText2.getText().length());
    }

    private final void Y(final View view) {
        view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.r
            @Override // java.lang.Runnable
            public final void run() {
                s.Z(view);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(View view) {
        Intrinsics.checkNotNullParameter(view, "$view");
        InputMethodUtil.show(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0() {
        int i3;
        int i16;
        boolean z16;
        EditText editText = this.etLink;
        TextView textView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etLink");
            editText = null;
        }
        String obj = editText.getText().toString();
        int length = obj.length() - 1;
        int i17 = 0;
        boolean z17 = false;
        while (i17 <= length) {
            if (!z17) {
                i16 = i17;
            } else {
                i16 = length;
            }
            if (Intrinsics.compare((int) obj.charAt(i16), 32) <= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z17) {
                if (!z16) {
                    z17 = true;
                } else {
                    i17++;
                }
            } else if (!z16) {
                break;
            } else {
                length--;
            }
        }
        boolean z18 = !TextUtils.isEmpty(obj.subSequence(i17, length + 1).toString());
        TextView textView2 = this.tvAdd;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvAdd");
            textView2 = null;
        }
        textView2.setEnabled(z18);
        TextView textView3 = this.tvAdd;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvAdd");
        } else {
            textView = textView3;
        }
        Resources resources = getContext().getResources();
        if (z18) {
            if (this.mIsNightTheme) {
                i3 = R.color.f158017al3;
            } else {
                i3 = R.color.cf6;
            }
        } else {
            i3 = R.color.cf8;
        }
        textView.setTextColor(resources.getColor(i3));
    }

    public final void b0(boolean isNightTheme) {
        this.mIsNightTheme = isNightTheme;
    }

    public final void c0(@Nullable b listener) {
        this.mListener = listener;
    }

    public final void d0(@NotNull String tips) {
        Intrinsics.checkNotNullParameter(tips, "tips");
        TextView textView = this.tvTips;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTips");
            textView = null;
        }
        textView.setText(tips);
    }

    public final void e0(@Nullable String link, @Nullable String title, @Nullable ab span) {
        X(span, link, title);
        S();
        a0();
        show();
        EditText editText = this.etLink;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etLink");
            editText = null;
        }
        Y(editText);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        int i3;
        boolean z16;
        int i16;
        boolean z17;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        int id5 = v3.getId();
        if (id5 == R.id.f167033k60) {
            b bVar = this.mListener;
            if (bVar != null) {
                bVar.onCancel();
            }
        } else if (id5 == R.id.f10582672) {
            EditText editText = this.etLink;
            EditText editText2 = null;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etLink");
                editText = null;
            }
            String obj = editText.getText().toString();
            int length = obj.length() - 1;
            int i17 = 0;
            boolean z18 = false;
            while (i17 <= length) {
                if (!z18) {
                    i16 = i17;
                } else {
                    i16 = length;
                }
                if (Intrinsics.compare((int) obj.charAt(i16), 32) <= 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z18) {
                    if (!z17) {
                        z18 = true;
                    } else {
                        i17++;
                    }
                } else if (!z17) {
                    break;
                } else {
                    length--;
                }
            }
            String obj2 = obj.subSequence(i17, length + 1).toString();
            EditText editText3 = this.etTitle;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etTitle");
            } else {
                editText2 = editText3;
            }
            String obj3 = editText2.getText().toString();
            int length2 = obj3.length() - 1;
            int i18 = 0;
            boolean z19 = false;
            while (i18 <= length2) {
                if (!z19) {
                    i3 = i18;
                } else {
                    i3 = length2;
                }
                if (Intrinsics.compare((int) obj3.charAt(i3), 32) <= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z19) {
                    if (!z16) {
                        z19 = true;
                    } else {
                        i18++;
                    }
                } else if (!z16) {
                    break;
                } else {
                    length2--;
                }
            }
            String obj4 = obj3.subSequence(i18, length2 + 1).toString();
            b bVar2 = this.mListener;
            if (bVar2 != null) {
                bVar2.a(obj2, obj4, this.mSpan);
            }
            if (QLog.isColorLevel()) {
                QLog.i("GameStrategyAddLinkDialog", 1, "[onLinkAdd] link:" + obj2 + ",title:" + obj4);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.app.Dialog
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        View findViewById = findViewById(R.id.kbr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_tips)");
        this.tvTips = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.uxb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.et_link)");
        EditText editText = (EditText) findViewById2;
        this.etLink = editText;
        TextView textView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etLink");
            editText = null;
        }
        editText.addTextChangedListener(this.mLinkWatcher);
        View findViewById3 = findViewById(R.id.bzb);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.et_title)");
        EditText editText2 = (EditText) findViewById3;
        this.etTitle = editText2;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etTitle");
            editText2 = null;
        }
        editText2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(24)});
        EditText editText3 = this.etTitle;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etTitle");
            editText3 = null;
        }
        editText3.addTextChangedListener(this.mTittleWatcher);
        View findViewById4 = findViewById(R.id.f10582672);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_add)");
        TextView textView2 = (TextView) findViewById4;
        this.tvAdd = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvAdd");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        View findViewById5 = findViewById(R.id.f167033k60);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.tv_cancel)");
        TextView textView3 = (TextView) findViewById5;
        this.tvCancel = textView3;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvCancel");
        } else {
            textView = textView3;
        }
        textView.setOnClickListener(this);
        View findViewById6 = findViewById(R.id.f112006mr);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.tv_title_count)");
        this.tvTitleCount = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.idg);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.rl_root)");
        this.rlRoot = (RelativeLayout) findViewById7;
        View findViewById8 = findViewById(R.id.kmm);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.v_divider)");
        this.vDivider = findViewById8;
    }

    public final void setTitle(@Nullable String title) {
        EditText editText = this.etTitle;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etTitle");
            editText = null;
        }
        editText.setText(title);
    }
}
