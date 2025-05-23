package com.tencent.mobileqq.minigame.va.util;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/minigame/va/util/MiniGameVAColorNote$initColorNoteController$3", "Lcom/tencent/mobileqq/colornote/g;", "Landroid/os/Bundle;", "colorNote", "", "result", "", "onAddColorNote", "Lcom/tencent/mobileqq/colornote/data/ColorNote;", "onUpdateColorNote", "", "serviceType", "", QCircleLpReportDc010001.KEY_SUBTYPE, "bundle", "onUpdateColorNoteState", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniGameVAColorNote$initColorNoteController$3 extends com.tencent.mobileqq.colornote.g {
    final /* synthetic */ MiniGameVAColorNote this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniGameVAColorNote$initColorNoteController$3(MiniGameVAColorNote miniGameVAColorNote) {
        this.this$0 = miniGameVAColorNote;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onUpdateColorNoteState$lambda$1$lambda$0(MiniGameVAColorNote this$0) {
        InitColorNoteCallback initColorNoteCallback;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        initColorNoteCallback = this$0.initCallback;
        if (initColorNoteCallback != null) {
            initColorNoteCallback.init();
        }
        this$0.initCallback = null;
    }

    @Override // com.tencent.mobileqq.colornote.g
    public void onAddColorNote(Bundle colorNote, boolean result) {
        Function1 function1;
        super.onAddColorNote(colorNote, result);
        QLog.i("MiniGameVAColorNote", 1, "onAddColorNote result: " + result);
        function1 = this.this$0.addCallback;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(result));
        }
        this.this$0.addCallback = null;
    }

    @Override // com.tencent.mobileqq.colornote.g
    public void onUpdateColorNote(ColorNote colorNote, boolean result) {
        Function1 function1;
        super.onUpdateColorNote(colorNote, result);
        function1 = this.this$0.updateCallback;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(result));
        }
        this.this$0.updateCallback = null;
    }

    @Override // com.tencent.mobileqq.colornote.g
    public void onUpdateColorNoteState(int serviceType, String subType, Bundle bundle) {
        InitColorNoteCallback initColorNoteCallback;
        super.onUpdateColorNoteState(serviceType, subType, bundle);
        initColorNoteCallback = this.this$0.initCallback;
        if (initColorNoteCallback != null) {
            final MiniGameVAColorNote miniGameVAColorNote = this.this$0;
            QLog.i("MiniGameVAColorNote", 1, "onUpdateColorNoteState");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.util.b
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGameVAColorNote$initColorNoteController$3.onUpdateColorNoteState$lambda$1$lambda$0(MiniGameVAColorNote.this);
                }
            });
        }
    }
}
