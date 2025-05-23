package com.tencent.mobileqq.wink.editor.subtitle;

import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.subtitle.p;
import com.tencent.mobileqq.wink.editor.subtitle.source.Subtitle;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "code", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkSubtitleViewModel$translateSubtitleLineTextResult$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $callBack;
    final /* synthetic */ boolean $isAllTranslate;
    final /* synthetic */ ArrayList<Subtitle> $lines;
    final /* synthetic */ WinkSubtitleViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WinkSubtitleViewModel$translateSubtitleLineTextResult$2(WinkSubtitleViewModel winkSubtitleViewModel, Function1<? super Boolean, Unit> function1, boolean z16, ArrayList<Subtitle> arrayList) {
        super(1);
        this.this$0 = winkSubtitleViewModel;
        this.$callBack = function1;
        this.$isAllTranslate = z16;
        this.$lines = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WinkSubtitleViewModel this$0, boolean z16) {
        boolean z17;
        dr drVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        z17 = this$0.enterEditPlaying;
        if (z17 && z16) {
            drVar = this$0.tavcut;
            if (drVar != null) {
                drVar.play();
            }
            this$0.enterEditPlaying = false;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i3) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        MutableLiveData mutableLiveData4;
        MutableLiveData mutableLiveData5;
        MutableLiveData mutableLiveData6;
        MutableLiveData mutableLiveData7;
        this.this$0.translateCancelable = null;
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final WinkSubtitleViewModel winkSubtitleViewModel = this.this$0;
        final boolean z16 = this.$isAllTranslate;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.ax
            @Override // java.lang.Runnable
            public final void run() {
                WinkSubtitleViewModel$translateSubtitleLineTextResult$2.b(WinkSubtitleViewModel.this, z16);
            }
        });
        if (i3 == 0) {
            m.f322215a.l();
        } else if (i3 != 1000007) {
            m.f322215a.k();
        } else {
            m.f322215a.j();
        }
        if (i3 == 1000007) {
            Function1<Boolean, Unit> function1 = this.$callBack;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        boolean z17 = this.$isAllTranslate;
        if (z17 && i3 == 0) {
            mutableLiveData7 = this.this$0._translateEvent;
            t73.b.b(mutableLiveData7, p.c.f322218a);
            return;
        }
        if (z17 && i3 == 1000007) {
            mutableLiveData6 = this.this$0._translateEvent;
            t73.b.b(mutableLiveData6, p.c.f322218a);
            return;
        }
        if (z17 && i3 == 1000011) {
            mutableLiveData5 = this.this$0._translateEvent;
            t73.b.b(mutableLiveData5, p.c.f322218a);
            return;
        }
        if (z17) {
            mutableLiveData4 = this.this$0._translateEvent;
            t73.b.b(mutableLiveData4, p.a.f322216a);
            return;
        }
        if (i3 == 0) {
            mutableLiveData3 = this.this$0._translateEvent;
            t73.b.b(mutableLiveData3, new p.TranslateUpdateSuccess(this.$lines));
            Function1<Boolean, Unit> function12 = this.$callBack;
            if (function12 != null) {
                function12.invoke(Boolean.TRUE);
                return;
            }
            return;
        }
        if (i3 == 1000011) {
            mutableLiveData2 = this.this$0._translateEvent;
            t73.b.b(mutableLiveData2, new p.TranslateUpdateSuccess(this.$lines));
            Function1<Boolean, Unit> function13 = this.$callBack;
            if (function13 != null) {
                function13.invoke(Boolean.TRUE);
                return;
            }
            return;
        }
        mutableLiveData = this.this$0._translateEvent;
        t73.b.b(mutableLiveData, p.f.f322221a);
        Function1<Boolean, Unit> function14 = this.$callBack;
        if (function14 != null) {
            function14.invoke(Boolean.FALSE);
        }
    }
}
