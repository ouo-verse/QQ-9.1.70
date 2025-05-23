package com.tencent.mobileqq.wink.editor;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicOptimizeManager;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.publish.api.IWinkDraft;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.os.MqqHandler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkEditorFragment$initNextBtn$clickSendAction$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ WinkEditorFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorFragment$initNextBtn$clickSendAction$1(WinkEditorFragment winkEditorFragment) {
        super(0);
        this.this$0 = winkEditorFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Fn(false);
        IWinkDraft iWinkDraft = (IWinkDraft) QRoute.api(IWinkDraft.class);
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        Intrinsics.checkNotNullExpressionValue(account, "api(IAccountRuntime::class.java).account");
        iWinkDraft.updateUploadStatus(Long.parseLong(account), this$0.Tk().getMissionId(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(WinkEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Fn(false);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean ao5;
        ao5 = this.this$0.ao(0L);
        if (ao5) {
            return;
        }
        if (this.this$0.Tk().getIsLoadFromDraft()) {
            MqqHandler fileThreadHandler = ThreadManager.getFileThreadHandler();
            final WinkEditorFragment winkEditorFragment = this.this$0;
            fileThreadHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.cf
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment$initNextBtn$clickSendAction$1.c(WinkEditorFragment.this);
                }
            });
        } else if (r93.h.f430993a.g()) {
            MqqHandler fileThreadHandler2 = ThreadManager.getFileThreadHandler();
            final WinkEditorFragment winkEditorFragment2 = this.this$0;
            fileThreadHandler2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.cg
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment$initNextBtn$clickSendAction$1.d(WinkEditorFragment.this);
                }
            });
        }
        this.this$0.jo();
        if (this.this$0.Tk().s4()) {
            WinkEditorFragment winkEditorFragment3 = this.this$0;
            try {
                Result.Companion companion = Result.INSTANCE;
                WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId("E_EDITOR_NEXT_STEP");
                WinkContext.Companion companion2 = WinkContext.INSTANCE;
                WinkPublishQualityReportData.Builder ext1 = eventId.traceId(companion2.d().getTraceId()).ext1(String.valueOf(winkEditorFragment3.Tk().getMFrom()));
                WinkEditorMusicInfo currentMusic = winkEditorFragment3.xk().getCurrentMusic();
                Unit unit = null;
                WinkPublishQualityReportData reportData = ext1.ext2(currentMusic != null ? currentMusic.p() : null).ext3(winkEditorFragment3.xk().getIsVideoClearMusic() ? "hasClear" : "noClear").ext4(MusicOptimizeManager.f321154a.a() ? "disableAutoMusic" : "enableAutoMusic").getReportData();
                z93.c f16 = Wink.INSTANCE.f();
                if (f16 != null) {
                    f16.a(reportData, companion2.d().k().b());
                    unit = Unit.INSTANCE;
                }
                Result.m476constructorimpl(unit);
            } catch (Throwable th5) {
                Result.Companion companion3 = Result.INSTANCE;
                Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
        }
    }
}
