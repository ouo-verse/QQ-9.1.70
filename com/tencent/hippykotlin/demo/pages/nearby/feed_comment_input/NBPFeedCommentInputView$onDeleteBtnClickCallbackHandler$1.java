package com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input;

import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.views.TextAreaView;
import com.tencent.kuikly.core.views.ak;
import com.tencent.kuikly.core.views.al;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes31.dex */
public final class NBPFeedCommentInputView$onDeleteBtnClickCallbackHandler$1 extends Lambda implements Function1<Object, Unit> {
    public final /* synthetic */ NBPFeedCommentInputView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NBPFeedCommentInputView$onDeleteBtnClickCallbackHandler$1(NBPFeedCommentInputView nBPFeedCommentInputView) {
        super(1);
        this.this$0 = nBPFeedCommentInputView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Object obj) {
        TextAreaView b16;
        aa<TextAreaView> aaVar = this.this$0.inputViewRef;
        if (aaVar != null && (b16 = aaVar.b()) != null) {
            final NBPFeedCommentInputView nBPFeedCommentInputView = this.this$0;
            b16.k(new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NBPFeedCommentInputView$onDeleteBtnClickCallbackHandler$1.1
                {
                    super(1);
                }

                /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
                /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
                /* JADX WARN: Removed duplicated region for block: B:39:0x0066 A[SYNTHETIC] */
                @Override // kotlin.jvm.functions.Function1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Unit invoke(Integer num) {
                    CharSequence removeRange;
                    TextAreaView b17;
                    boolean z16;
                    int i3;
                    int intValue = num.intValue();
                    if (intValue > 0) {
                        NBPFeedCommentInputView nBPFeedCommentInputView2 = NBPFeedCommentInputView.this;
                        KProperty<Object>[] kPropertyArr = NBPFeedCommentInputView.$$delegatedProperties;
                        boolean z17 = false;
                        String substring = nBPFeedCommentInputView2.getInputText().substring(0, intValue);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        int i16 = 0;
                        while (true) {
                            if (i16 >= substring.length()) {
                                break;
                            }
                            char charAt = substring.charAt(i16);
                            if (('\ud800' <= charAt && charAt < '\udc00') && (i3 = i16 + 1) < substring.length()) {
                                char charAt2 = substring.charAt(i3);
                                if ('\udc00' <= charAt2 && charAt2 < '\ue000') {
                                    z16 = true;
                                    if (charAt == 20) {
                                        z16 = true;
                                    }
                                    if (!z16 && i16 == substring.length() - 2) {
                                        z17 = true;
                                        break;
                                    }
                                    if (z16) {
                                        r4 = 1;
                                    }
                                    i16 += r4;
                                }
                            }
                            z16 = false;
                            if (charAt == 20) {
                            }
                            if (!z16) {
                            }
                            if (z16) {
                            }
                            i16 += r4;
                        }
                        int i17 = intValue - (z17 ? 2 : 1);
                        removeRange = StringsKt__StringsKt.removeRange((CharSequence) NBPFeedCommentInputView.this.getInputText(), i17, intValue);
                        String obj2 = removeRange.toString();
                        NBPFeedCommentInputView nBPFeedCommentInputView3 = NBPFeedCommentInputView.this;
                        al alVar = new al();
                        ak akVar = new ak();
                        akVar.e(obj2.toString());
                        akVar.b(Float.valueOf(16.0f));
                        alVar.a(akVar);
                        nBPFeedCommentInputView3.inputSpans$delegate.setValue(nBPFeedCommentInputView3, NBPFeedCommentInputView.$$delegatedProperties[7], alVar);
                        aa<TextAreaView> aaVar2 = NBPFeedCommentInputView.this.inputViewRef;
                        if (aaVar2 != null && (b17 = aaVar2.b()) != null) {
                            b17.n(i17);
                        }
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        return Unit.INSTANCE;
    }
}
