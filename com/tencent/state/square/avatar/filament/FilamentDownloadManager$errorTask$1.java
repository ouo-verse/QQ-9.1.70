package com.tencent.state.square.avatar.filament;

import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.avatar.filament.FilamentDownloadManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FilamentDownloadManager$errorTask$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $errorCode;
    final /* synthetic */ String $errorMessage;
    final /* synthetic */ String $url;
    final /* synthetic */ FilamentDownloadManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentDownloadManager$errorTask$1(FilamentDownloadManager filamentDownloadManager, String str, int i3, String str2) {
        super(0);
        this.this$0 = filamentDownloadManager;
        this.$url = str;
        this.$errorCode = i3;
        this.$errorMessage = str2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Map map;
        Map map2;
        synchronized (this.this$0) {
            map = this.this$0.taskList;
            FilamentDownloadManager.DownTask downTask = (FilamentDownloadManager.DownTask) map.get(this.$url);
            if (downTask != null) {
                downTask.errorListener(new Function1<UnZipListener, Unit>() { // from class: com.tencent.state.square.avatar.filament.FilamentDownloadManager$errorTask$1$$special$$inlined$synchronized$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(UnZipListener unZipListener) {
                        invoke2(unZipListener);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final UnZipListener unZipListener) {
                        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.avatar.filament.FilamentDownloadManager$errorTask$1$$special$$inlined$synchronized$lambda$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                UnZipListener unZipListener2 = unZipListener;
                                if (unZipListener2 != null) {
                                    FilamentDownloadManager$errorTask$1 filamentDownloadManager$errorTask$1 = FilamentDownloadManager$errorTask$1.this;
                                    unZipListener2.onTaskFailed(filamentDownloadManager$errorTask$1.$errorCode, filamentDownloadManager$errorTask$1.$errorMessage);
                                }
                                SquareBaseKt.getSquareLog().i("FilamentDownloadManager", "errorTask doListener");
                            }
                        });
                    }
                });
            }
            map2 = this.this$0.taskList;
            map2.remove(this.$url);
            SquareBaseKt.getSquareLog().i("FilamentDownloadManager", "errorTask: " + this.$url);
            Unit unit = Unit.INSTANCE;
        }
    }
}
