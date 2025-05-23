package com.tencent.mobileqq.wink.editor.subtitle.source;

import camera.MOBILE_QQ_MATERIAL_INTERFACE.MapTranslatedText;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.Text;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.TranslateTextRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\"\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\"\u0010\u0012\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/wink/editor/subtitle/source/DefaultSubtitleDataSource$updateTranslateResult$translateObserver$1", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/h;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/a;", "", "cancel", "", "type", "", "isSuccess", "", "data", "c", "e", "Z", "a", "()Z", "d", "(Z)V", "canceled", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class DefaultSubtitleDataSource$updateTranslateResult$translateObserver$1 extends h implements a {

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ c f322246d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean canceled;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function1<Integer, Unit> f322248f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ ArrayList<Subtitle> f322249h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public DefaultSubtitleDataSource$updateTranslateResult$translateObserver$1(c cVar, Function1<? super Integer, Unit> function1, ArrayList<Subtitle> arrayList) {
        this.f322248f = function1;
        this.f322249h = arrayList;
        this.f322246d = cVar;
        cVar.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.source.DefaultSubtitleDataSource$updateTranslateResult$translateObserver$1.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                w53.b.c("DefaultSubtitleDataSource", "translateResult cancel");
                com.tencent.mobileqq.wink.b.a().removeObserver(DefaultSubtitleDataSource$updateTranslateResult$translateObserver$1.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.a
    /* renamed from: a, reason: from getter */
    public boolean getCanceled() {
        return this.canceled;
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.h
    public void c(int type, boolean isSuccess, @Nullable Object data) {
        Pair pair;
        int resultCode;
        boolean z16;
        if (getCanceled()) {
            return;
        }
        FromServiceMsg fromServiceMsg = null;
        if (data instanceof Pair) {
            pair = (Pair) data;
        } else {
            pair = null;
        }
        if (pair != null) {
            fromServiceMsg = (FromServiceMsg) pair.getFirst();
        }
        if (fromServiceMsg == null) {
            w53.b.c("DefaultSubtitleDataSource", "translate result null");
            this.f322248f.invoke(1000011);
            return;
        }
        FromServiceMsg fromServiceMsg2 = (FromServiceMsg) pair.component1();
        TranslateTextRsp translateTextRsp = (TranslateTextRsp) pair.component2();
        Intrinsics.checkNotNull(fromServiceMsg2);
        if (fromServiceMsg2.isSuccess() && translateTextRsp != null && translateTextRsp.Code == 0) {
            w53.b.a("DefaultSubtitleDataSource", "translate success callback");
            for (Subtitle subtitle : this.f322249h) {
                MapTranslatedText[] mapTranslatedTextArr = translateTextRsp.TranslatedText;
                Intrinsics.checkNotNullExpressionValue(mapTranslatedTextArr, "rsp.TranslatedText");
                for (MapTranslatedText mapTranslatedText : mapTranslatedTextArr) {
                    Text[] textArr = mapTranslatedText.TranslatedText;
                    Intrinsics.checkNotNullExpressionValue(textArr, "translatedText.TranslatedText");
                    for (Text text : textArr) {
                        if (text != null && subtitle.getId() == text.Id) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            String str = text.Content;
                            Intrinsics.checkNotNullExpressionValue(str, "text.Content");
                            subtitle.setTranslate(str);
                            subtitle.setNeedUpdateTranslate(false);
                        }
                    }
                }
            }
            this.f322248f.invoke(0);
            return;
        }
        Function1<Integer, Unit> function1 = this.f322248f;
        if (translateTextRsp != null) {
            resultCode = translateTextRsp.Code;
        } else {
            resultCode = fromServiceMsg2.getResultCode();
        }
        function1.invoke(Integer.valueOf(resultCode));
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.a
    public void cancel() {
        d(true);
        this.f322248f.invoke(1000007);
    }

    public void d(boolean z16) {
        this.canceled = z16;
    }
}
