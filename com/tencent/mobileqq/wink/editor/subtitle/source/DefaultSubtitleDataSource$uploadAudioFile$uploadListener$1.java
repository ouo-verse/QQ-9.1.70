package com.tencent.mobileqq.wink.editor.subtitle.source;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdConfigDefine$APPID;
import com.tencent.mobileqq.wink.edit.manager.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/wink/editor/subtitle/source/DefaultSubtitleDataSource$uploadAudioFile$uploadListener$1", "Lcom/tencent/mobileqq/wink/edit/manager/g$b;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/b;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/a;", "child", "", "b", "cancel", "", "imageDownLoadUrl", "onSuccess", "onFail", "onCancel", "", "progress", "onProgress", "", "a", "()Z", "canceled", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class DefaultSubtitleDataSource$uploadAudioFile$uploadListener$1 implements g.b, b {

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ c f322250d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f322251e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function3<b, Integer, String, Unit> f322252f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public DefaultSubtitleDataSource$uploadAudioFile$uploadListener$1(c cVar, final String str, Function3<? super b, ? super Integer, ? super String, Unit> function3) {
        this.f322251e = str;
        this.f322252f = function3;
        this.f322250d = cVar;
        cVar.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.subtitle.source.DefaultSubtitleDataSource$uploadAudioFile$uploadListener$1.1
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
                w53.b.c("DefaultSubtitleDataSource", "uploadAudioFile cancel " + str);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.a
    /* renamed from: a */
    public boolean getCanceled() {
        return this.f322250d.getCanceled();
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.b
    public void b(@Nullable a child) {
        this.f322250d.b(child);
    }

    @Override // com.tencent.mobileqq.wink.editor.subtitle.source.a
    public void cancel() {
        this.f322250d.cancel();
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.g.b
    public void onCancel() {
        if (getCanceled()) {
            return;
        }
        w53.b.c("DefaultSubtitleDataSource", "upload audio cancel");
        this.f322252f.invoke(this, 1000007, null);
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.g.b
    public void onFail() {
        if (getCanceled()) {
            return;
        }
        w53.b.c("DefaultSubtitleDataSource", "upload audio fail");
        this.f322252f.invoke(this, 1000006, null);
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.g.b
    public void onProgress(int progress) {
        if (getCanceled()) {
            return;
        }
        w53.b.a("DefaultSubtitleDataSource", "upload audio progress " + progress);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    @Override // com.tencent.mobileqq.wink.edit.manager.g.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(@Nullable String imageDownLoadUrl) {
        boolean z16;
        boolean isBlank;
        if (getCanceled()) {
            return;
        }
        w53.b.a("DefaultSubtitleDataSource", "upload audio success: " + this.f322251e + " " + imageDownLoadUrl);
        if (imageDownLoadUrl != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(imageDownLoadUrl);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    this.f322252f.invoke(this, Integer.valueOf(QAdConfigDefine$APPID.QQLIVE), null);
                    return;
                } else {
                    this.f322252f.invoke(this, 0, imageDownLoadUrl);
                    return;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }
}
