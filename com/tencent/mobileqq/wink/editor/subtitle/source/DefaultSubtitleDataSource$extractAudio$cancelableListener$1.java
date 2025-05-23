package com.tencent.mobileqq.wink.editor.subtitle.source;

import com.tencent.tavcut.core.render.audio.extractor.IAudioExtractorProcessor;
import com.tencent.tavcut.core.render.audio.extractor.OnAudioExtractorListener;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00128\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0019"}, d2 = {"com/tencent/mobileqq/wink/editor/subtitle/source/DefaultSubtitleDataSource$extractAudio$cancelableListener$1", "Lcom/tencent/tavcut/core/render/audio/extractor/OnAudioExtractorListener;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/b;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/a;", "child", "", "b", "cancel", "", "errCode", "", "errMsg", "onExtractError", "audioPath", "onExtractFinish", "onExtractStart", "progress", "onExtracting", "", "e", "Z", "called", "a", "()Z", "canceled", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class DefaultSubtitleDataSource$extractAudio$cancelableListener$1 implements OnAudioExtractorListener, b {

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ c f322236d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile boolean called;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f322238f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function4<b, Integer, String, String, Unit> f322239h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public DefaultSubtitleDataSource$extractAudio$cancelableListener$1(c cVar, final String str, Function4<? super b, ? super Integer, ? super String, ? super String, Unit> function4) {
        this.f322238f = str;
        this.f322239h = function4;
        this.f322236d = cVar;
        cVar.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.source.DefaultSubtitleDataSource$extractAudio$cancelableListener$1.1
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
                HashMap hashMap;
                IAudioExtractorProcessor iAudioExtractorProcessor;
                hashMap = DefaultSubtitleDataSource.extractTaskMap;
                String str2 = (String) hashMap.remove(str);
                if (str2 == null) {
                    return;
                }
                w53.b.c("DefaultSubtitleDataSource", str + " extract cancel: " + str2);
                iAudioExtractorProcessor = DefaultSubtitleDataSource.extractor;
                if (iAudioExtractorProcessor != null) {
                    iAudioExtractorProcessor.cancelExtractAudio(str2);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.a
    /* renamed from: a */
    public boolean getCanceled() {
        return this.f322236d.getCanceled();
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.b
    public void b(@Nullable a child) {
        this.f322236d.b(child);
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.a
    public void cancel() {
        this.f322236d.cancel();
    }

    @Override // com.tencent.tavcut.core.render.audio.extractor.OnAudioExtractorListener
    public void onExtractError(int errCode, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (!getCanceled() && !this.called) {
            this.called = true;
            w53.b.c("DefaultSubtitleDataSource", this.f322238f + " onExtractError: " + errCode + " " + errMsg);
            this.f322239h.invoke(this, Integer.valueOf(errCode), errMsg, null);
        }
    }

    @Override // com.tencent.tavcut.core.render.audio.extractor.OnAudioExtractorListener
    public void onExtractFinish(@NotNull String audioPath) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(audioPath, "audioPath");
        if (!getCanceled() && !this.called) {
            this.called = true;
            w53.b.a("DefaultSubtitleDataSource", this.f322238f + " onExtractFinish: " + audioPath);
            isBlank = StringsKt__StringsJVMKt.isBlank(audioPath);
            if (isBlank) {
                this.f322239h.invoke(this, 1000002, "output path empty", null);
                return;
            }
            File file = new File(audioPath);
            if (!file.exists()) {
                this.f322239h.invoke(this, 1000002, "output path do not exist " + file.getAbsolutePath(), null);
                return;
            }
            this.f322239h.invoke(this, 0, null, audioPath);
        }
    }

    @Override // com.tencent.tavcut.core.render.audio.extractor.OnAudioExtractorListener
    public void onExtractStart() {
        w53.b.a("DefaultSubtitleDataSource", this.f322238f + " onExtractStart");
    }

    @Override // com.tencent.tavcut.core.render.audio.extractor.OnAudioExtractorListener
    public void onExtracting(int progress) {
        w53.b.a("DefaultSubtitleDataSource", this.f322238f + " onExtracting: " + progress);
    }
}
