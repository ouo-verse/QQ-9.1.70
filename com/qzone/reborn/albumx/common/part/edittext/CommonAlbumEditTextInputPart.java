package com.qzone.reborn.albumx.common.part.edittext;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.viewmodel.d;
import com.qzone.reborn.base.k;
import com.qzone.reborn.util.e;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.inputview.QUIBaseInputView;
import com.tencent.mobileqq.widget.inputview.QUIMultiLineInputView;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.util.QQToastUtil;
import h53.CharacterCountInfo;
import h53.QUIInputCountCalculateStrategy;
import h53.n;
import h53.q;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import tl.h;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 M2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001NB9\u0012\u0006\u0010,\u001a\u00020\u000f\u0012\u0006\u0010/\u001a\u00020\u001c\u0012\u0006\u00101\u001a\u00020\u000f\u0012\u0006\u00104\u001a\u00020\r\u0012\u0006\u00106\u001a\u00020\r\u0012\b\b\u0002\u00108\u001a\u00020\r\u00a2\u0006\u0004\bK\u0010LJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\rH\u0016J*\u0010 \u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J*\u0010\"\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0012\u0010$\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010#H\u0016J\b\u0010%\u001a\u00020\rH\u0016J\u001c\u0010)\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010\u000f2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016R\u0014\u0010,\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00101\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010+R\u0014\u00104\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00106\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0014\u00108\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00103R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR#\u0010J\u001a\n E*\u0004\u0018\u00010D0D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\u00a8\u0006O"}, d2 = {"Lcom/qzone/reborn/albumx/common/part/edittext/CommonAlbumEditTextInputPart;", "Lcom/qzone/reborn/base/k;", "Lh53/q;", "Lh53/n;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "H9", "Lcom/tencent/mobileqq/widget/inputview/QUIBaseInputView;", "E9", "initData", "Lh53/d;", "countInfo", "", "J9", "", "newText", "I9", "F9", "L9", "K9", "onInitView", "title", "A4", "hasFocus", "f8", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "onBackEvent", "action", "", "args", "handleBroadcastMessage", "d", "Ljava/lang/String;", "initText", "e", "I", "maxInputLength", "f", "hint", h.F, "Z", "canOutputBlankString", "i", "isMultiLineInput", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isNeedCheckEmpty", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/FrameLayout;", "inputContainerView", "D", "Lcom/tencent/mobileqq/widget/inputview/QUIBaseInputView;", "quiInputView", "Lh53/e;", "E", "Lh53/e;", "calculateStrategy", "Lcom/qzone/reborn/albumx/common/viewmodel/d;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "G9", "()Lcom/qzone/reborn/albumx/common/viewmodel/d;", "editVM", "<init>", "(Ljava/lang/String;ILjava/lang/String;ZZZ)V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonAlbumEditTextInputPart extends k implements q, n {
    private static final int H = ar.d(200.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private FrameLayout inputContainerView;

    /* renamed from: D, reason: from kotlin metadata */
    private QUIBaseInputView quiInputView;

    /* renamed from: E, reason: from kotlin metadata */
    private final QUIInputCountCalculateStrategy calculateStrategy;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy editVM;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String initText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int maxInputLength;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String hint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean canOutputBlankString;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean isMultiLineInput;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean isNeedCheckEmpty;

    public /* synthetic */ CommonAlbumEditTextInputPart(String str, int i3, String str2, boolean z16, boolean z17, boolean z18, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, str2, z16, z17, (i16 & 32) != 0 ? false : z18);
    }

    private final QUIBaseInputView E9(View rootView) {
        if (this.isMultiLineInput) {
            Context context = rootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            QUIMultiLineInputView qUIMultiLineInputView = new QUIMultiLineInputView(context, null, 0, 6, null);
            qUIMultiLineInputView.setInputViewWatcher(this);
            qUIMultiLineInputView.setLayoutParams(new FrameLayout.LayoutParams(-1, H));
            return qUIMultiLineInputView;
        }
        Context context2 = rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "rootView.context");
        QUISingleLineInputView qUISingleLineInputView = new QUISingleLineInputView(context2, null, 0, 6, null);
        qUISingleLineInputView.setShowBottomLine(false);
        qUISingleLineInputView.setInputViewWatcher(this);
        qUISingleLineInputView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return qUISingleLineInputView;
    }

    private final boolean F9(String newText) {
        if (this.isNeedCheckEmpty) {
            return newText == null || newText.length() == 0;
        }
        return false;
    }

    private final d G9() {
        return (d) this.editVM.getValue();
    }

    private final boolean I9(String newText) {
        return !Intrinsics.areEqual(newText, this.initText);
    }

    private final boolean J9(CharacterCountInfo countInfo) {
        return countInfo.c(this.calculateStrategy) > this.maxInputLength;
    }

    private final void K9() {
        boolean isBlank;
        if (Intrinsics.areEqual(G9().M1().getValue(), Boolean.FALSE)) {
            QQToastUtil.showQQToastInUiThread(1, l.a(R.string.f169550v91));
            return;
        }
        Activity activity = getActivity();
        QUIBaseInputView qUIBaseInputView = this.quiInputView;
        CharSequence d16 = qUIBaseInputView != null ? qUIBaseInputView.d() : null;
        if (d16 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(d16);
            if (isBlank && !this.canOutputBlankString) {
                activity.setResult(0);
                activity.finish();
            }
        }
        Intent intent = new Intent();
        intent.putExtra("OUTPUT_TEXT", d16 != null ? d16.toString() : null);
        Unit unit = Unit.INSTANCE;
        activity.setResult(-1, intent);
        activity.finish();
    }

    private final void L9() {
        QUIBaseInputView qUIBaseInputView = this.quiInputView;
        if (!TextUtils.equals(qUIBaseInputView != null ? qUIBaseInputView.d() : null, this.initText)) {
            QUIBaseInputView qUIBaseInputView2 = this.quiInputView;
            if (!F9(String.valueOf(qUIBaseInputView2 != null ? qUIBaseInputView2.d() : null))) {
                DialogUtil.createCustomDialog(getContext(), 230, (String) null, l.a(R.string.wbi), l.a(R.string.w_j), l.a(R.string.wbh), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.albumx.common.part.edittext.a
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        CommonAlbumEditTextInputPart.M9(CommonAlbumEditTextInputPart.this, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.albumx.common.part.edittext.b
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        CommonAlbumEditTextInputPart.N9(CommonAlbumEditTextInputPart.this, dialogInterface, i3);
                    }
                }).show();
                return;
            }
        }
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(CommonAlbumEditTextInputPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        this$0.K9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(CommonAlbumEditTextInputPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void initData() {
        QUIBaseInputView qUIBaseInputView = this.quiInputView;
        if (qUIBaseInputView == null) {
            return;
        }
        qUIBaseInputView.setHint(this.hint);
        qUIBaseInputView.setContentText(this.initText);
        qUIBaseInputView.setMaxWordCount(this.maxInputLength);
        qUIBaseInputView.setCalculateStrategy(this.calculateStrategy);
    }

    @Override // h53.k
    public void afterTextChanged(Editable s16) {
        RFWLog.d("CommonAlbumEditTextInputPart", RFWLog.CLR, "afterTextChanged, s:" + ((Object) s16));
        G9().N1((J9(h53.c.a(s16 != null ? s16.toString() : null, this.calculateStrategy)) || !I9(String.valueOf(s16)) || F9(String.valueOf(s16))) ? false : true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        if (Intrinsics.areEqual(action, "ACTION_BACK_CLICK")) {
            L9();
        } else if (Intrinsics.areEqual(action, "ACTION_DONE")) {
            K9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        L9();
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Window window;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Activity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(16);
        }
        H9(rootView);
        initData();
    }

    @Override // h53.k
    public void onTextChanged(CharSequence s16, int start, int before, int count) {
        RFWLog.d("CommonAlbumEditTextInputPart", RFWLog.CLR, "onTextChanged, start:" + start + " before:" + before + " count:" + count + " s:" + ((Object) s16));
        boolean b16 = e.b("CommonAlbumEditTextInputPart", 1000L);
        CharacterCountInfo a16 = h53.c.a(s16, this.calculateStrategy);
        if (a16.getEmoticonCount() <= 0 && a16.getEmojiCount() <= 0) {
            if (J9(a16) && I9(String.valueOf(s16))) {
                boolean z16 = before < count;
                if (b16 || !z16) {
                    return;
                }
                QQToastUtil.showQQToastInUiThread(1, l.a(R.string.f169550v91));
                return;
            }
            return;
        }
        if (b16 || !I9(String.valueOf(s16))) {
            return;
        }
        QQToastUtil.showQQToastInUiThread(1, l.a(R.string.f134057s));
    }

    public CommonAlbumEditTextInputPart(String initText, int i3, String hint, boolean z16, boolean z17, boolean z18) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(initText, "initText");
        Intrinsics.checkNotNullParameter(hint, "hint");
        this.initText = initText;
        this.maxInputLength = i3;
        this.hint = hint;
        this.canOutputBlankString = z16;
        this.isMultiLineInput = z17;
        this.isNeedCheckEmpty = z18;
        this.calculateStrategy = new QUIInputCountCalculateStrategy(Double.MAX_VALUE, Double.MAX_VALUE, 0.5d, 1.0d);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.qzone.reborn.albumx.common.part.edittext.CommonAlbumEditTextInputPart$editVM$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d invoke() {
                return (d) CommonAlbumEditTextInputPart.this.getViewModel(d.class);
            }
        });
        this.editVM = lazy;
    }

    private final void H9(View rootView) {
        View findViewById = rootView.findViewById(R.id.mne);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_album_input_view)");
        this.inputContainerView = (FrameLayout) findViewById;
        QUIBaseInputView E9 = E9(rootView);
        E9.setStyle(1);
        this.quiInputView = E9;
        FrameLayout frameLayout = this.inputContainerView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputContainerView");
            frameLayout = null;
        }
        frameLayout.addView(E9);
    }

    @Override // h53.q
    public void A4(String title) {
    }

    @Override // h53.k
    public void f8(boolean hasFocus) {
    }

    @Override // h53.k
    public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
    }
}
