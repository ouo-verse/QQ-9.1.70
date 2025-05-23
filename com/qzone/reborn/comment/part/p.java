package com.qzone.reborn.comment.part;

import android.app.Activity;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.common.friend.business.model.Friend;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.comment.bean.QZoneCommentCacheData;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.widget.QZoneCommentEditText;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u00010B\u000f\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J*\u0010\u0016\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J*\u0010\u0018\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0019H\u0016R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/qzone/reborn/comment/part/p;", "Lcom/qzone/reborn/base/k;", "Landroid/text/TextWatcher;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "H9", "G9", "D9", "", "contentInCache", "F9", "initialText", "E9", "I9", "onInitView", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "d", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "getInitParams", "()Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "e", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "mEtInput", "Ldd/b;", "f", "Ldd/b;", "mInputViewModel", "Lcd/a;", tl.h.F, "Lcd/a;", "mAtManager", "<init>", "(Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;)V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class p extends com.qzone.reborn.base.k implements TextWatcher {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZoneCommentPanelParams initParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneCommentEditText mEtInput;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private dd.b mInputViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private cd.a mAtManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/comment/part/p$b", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText$a;", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QZoneCommentEditText.a {
        b() {
        }

        @Override // com.qzone.reborn.comment.widget.QZoneCommentEditText.a
        public void onKeyDown(int keyCode, KeyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            dd.b bVar = p.this.mInputViewModel;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
                bVar = null;
            }
            bVar.e2(1);
            Activity activity = p.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public p(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        this.initParams = initParams;
    }

    private final void D9() {
        QZoneCommentEditText qZoneCommentEditText = null;
        if (!TextUtils.isEmpty(this.initParams.getHintText())) {
            QZoneCommentEditText qZoneCommentEditText2 = this.mEtInput;
            if (qZoneCommentEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
                qZoneCommentEditText2 = null;
            }
            qZoneCommentEditText2.setHint(com.qzone.util.g.a(this.initParams.getHintText()));
        } else {
            QZoneCommentEditText qZoneCommentEditText3 = this.mEtInput;
            if (qZoneCommentEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
                qZoneCommentEditText3 = null;
            }
            qZoneCommentEditText3.setHint(R.string.glb);
        }
        dd.b bVar = this.mInputViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
            bVar = null;
        }
        QZoneCommentCacheData S1 = bVar.S1();
        if (!TextUtils.isEmpty(this.initParams.getAutoFillText())) {
            QZoneCommentEditText qZoneCommentEditText4 = this.mEtInput;
            if (qZoneCommentEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
                qZoneCommentEditText4 = null;
            }
            qZoneCommentEditText4.setText(E9(this.initParams.getAutoFillText()));
        } else {
            if (!TextUtils.isEmpty(S1 != null ? S1.getInputContent() : null)) {
                QZoneCommentEditText qZoneCommentEditText5 = this.mEtInput;
                if (qZoneCommentEditText5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
                    qZoneCommentEditText5 = null;
                }
                String inputContent = S1 != null ? S1.getInputContent() : null;
                Intrinsics.checkNotNull(inputContent);
                qZoneCommentEditText5.setText(F9(inputContent));
            }
        }
        QZoneCommentEditText qZoneCommentEditText6 = this.mEtInput;
        if (qZoneCommentEditText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText6 = null;
        }
        QZoneCommentEditText qZoneCommentEditText7 = this.mEtInput;
        if (qZoneCommentEditText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
        } else {
            qZoneCommentEditText = qZoneCommentEditText7;
        }
        qZoneCommentEditText6.setSelection(qZoneCommentEditText.getText().length());
    }

    private final String E9(String initialText) {
        String I9 = I9(initialText);
        if (!com.qzone.reborn.configx.g.f53821a.a().k()) {
            return I9;
        }
        String c16 = cd.b.c(I9);
        return c16 == null ? "" : c16;
    }

    private final String F9(String contentInCache) {
        int lastIndexOf$default;
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) contentInCache, "<{@QzOnEaT@}>", 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return contentInCache;
        }
        String substring = contentInCache.substring(lastIndexOf$default + 13);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        if (lastIndexOf$default == 0) {
            return "";
        }
        String substring2 = contentInCache.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        I9(substring);
        return substring2;
    }

    private final void G9() {
        QZoneCommentEditText qZoneCommentEditText = this.mEtInput;
        QZoneCommentEditText qZoneCommentEditText2 = null;
        if (qZoneCommentEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText = null;
        }
        qZoneCommentEditText.setClickable(true);
        QZoneCommentEditText qZoneCommentEditText3 = this.mEtInput;
        if (qZoneCommentEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText3 = null;
        }
        qZoneCommentEditText3.setFocusable(true);
        QZoneCommentEditText qZoneCommentEditText4 = this.mEtInput;
        if (qZoneCommentEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText4 = null;
        }
        qZoneCommentEditText4.setFocusableInTouchMode(true);
        QZoneCommentEditText qZoneCommentEditText5 = this.mEtInput;
        if (qZoneCommentEditText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText5 = null;
        }
        qZoneCommentEditText5.setEditableFactory(com.tencent.mobileqq.text.o.f292704d);
        QZoneCommentEditText qZoneCommentEditText6 = this.mEtInput;
        if (qZoneCommentEditText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText6 = null;
        }
        qZoneCommentEditText6.setLayerType(1, null);
        QZoneCommentEditText qZoneCommentEditText7 = this.mEtInput;
        if (qZoneCommentEditText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
        } else {
            qZoneCommentEditText2 = qZoneCommentEditText7;
        }
        qZoneCommentEditText2.setHint(this.initParams.getHintText());
    }

    private final String I9(String initialText) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(initialText);
        ArrayList<User> n3 = com.qzone.widget.x.n(getContext(), spannableStringBuilder, -11184811, null);
        if (!bl.b(n3)) {
            int size = n3.size();
            for (int i3 = 0; i3 < size; i3++) {
                User user = n3.get(i3);
                try {
                    Friend friend = new Friend();
                    String str = user.nickName;
                    friend.mName = str;
                    friend.mNickName = str;
                    friend.mRemark = str;
                    friend.mUin = user.uin;
                    dd.b bVar = this.mInputViewModel;
                    if (bVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
                        bVar = null;
                    }
                    bVar.M1(friend);
                } catch (Exception e16) {
                    QLog.e("QZoneCommentPanelInputPart", 1, "stringToAtUsers e = " + e16.getMessage());
                }
            }
        }
        String spannableStringBuilder2 = spannableStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "spannableStringBuilder.toString()");
        return spannableStringBuilder2;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s16) {
        dd.b bVar = this.mInputViewModel;
        dd.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
            bVar = null;
        }
        bVar.U1().setValue(s16 != null ? s16.toString() : null);
        dd.b bVar3 = this.mInputViewModel;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
        } else {
            bVar2 = bVar3;
        }
        bVar2.e2(2);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
        dd.b bVar = this.mInputViewModel;
        QZoneCommentEditText qZoneCommentEditText = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
            bVar = null;
        }
        cd.a aVar = new cd.a(bVar.Q1(), this.initParams.getMaxInputLength());
        this.mAtManager = aVar;
        Intrinsics.checkNotNull(aVar);
        aVar.a(s16, start, count, after);
        QZoneCommentEditText qZoneCommentEditText2 = this.mEtInput;
        if (qZoneCommentEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText2 = null;
        }
        QZoneCommentEditText qZoneCommentEditText3 = this.mEtInput;
        if (qZoneCommentEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
        } else {
            qZoneCommentEditText = qZoneCommentEditText3;
        }
        qZoneCommentEditText2.setBeforeChangeLineCount(qZoneCommentEditText.getLineCount());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(dd.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneInputViewModel::class.java)");
        this.mInputViewModel = (dd.b) viewModel;
        H9(rootView);
        G9();
        D9();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s16, int start, int before, int count) {
        QZoneCommentEditText qZoneCommentEditText = null;
        if (this.initParams.getEnableAt() && count == 1 && before == 0) {
            String substring = String.valueOf(s16).substring(start, start + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            if (Intrinsics.areEqual(substring, "@")) {
                dd.b bVar = this.mInputViewModel;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
                    bVar = null;
                }
                bVar.d2(true);
                xc.a aVar = (xc.a) getIocInterface(xc.a.class);
                if (aVar != null) {
                    aVar.G1();
                }
            }
        }
        cd.a aVar2 = this.mAtManager;
        if (aVar2 != null) {
            Intrinsics.checkNotNull(aVar2);
            cd.a aVar3 = this.mAtManager;
            Intrinsics.checkNotNull(aVar3);
            if (aVar2.g(aVar3.getTmpAtCode(), false)) {
                QZoneCommentEditText qZoneCommentEditText2 = this.mEtInput;
                if (qZoneCommentEditText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
                } else {
                    qZoneCommentEditText = qZoneCommentEditText2;
                }
                Editable editableText = qZoneCommentEditText.getEditableText();
                cd.a aVar4 = this.mAtManager;
                Intrinsics.checkNotNull(aVar4);
                int atStart = aVar4.getAtStart();
                cd.a aVar5 = this.mAtManager;
                Intrinsics.checkNotNull(aVar5);
                editableText.delete(atStart, aVar5.getAtEnd());
            }
        }
        cd.a aVar6 = this.mAtManager;
        if (aVar6 != null) {
            aVar6.h();
        }
        xc.i iVar = (xc.i) getIocInterface(xc.i.class);
        if (iVar != null) {
            iVar.n3();
        }
    }

    private final void H9(View rootView) {
        View findViewById = rootView.findViewById(R.id.ms_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026zone_comment_panel_input)");
        QZoneCommentEditText qZoneCommentEditText = (QZoneCommentEditText) findViewById;
        this.mEtInput = qZoneCommentEditText;
        QZoneCommentEditText qZoneCommentEditText2 = null;
        if (qZoneCommentEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText = null;
        }
        qZoneCommentEditText.addTextChangedListener(this);
        QZoneCommentEditText qZoneCommentEditText3 = this.mEtInput;
        if (qZoneCommentEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
        } else {
            qZoneCommentEditText2 = qZoneCommentEditText3;
        }
        qZoneCommentEditText2.setOnKeyDownListener(new b());
    }
}
