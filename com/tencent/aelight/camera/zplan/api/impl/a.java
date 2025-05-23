package com.tencent.aelight.camera.zplan.api.impl;

import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tribe.async.reactive.StreamFunction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/aelight/camera/zplan/api/impl/a;", "Lcom/tribe/async/reactive/StreamFunction;", "Lfs/b;", "context", "", "a", "", "d", "Ljava/lang/String;", "textFilterText", "<init>", "(Ljava/lang/String;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class a extends StreamFunction<fs.b, fs.b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String textFilterText;

    public a(String str) {
        this.textFilterText = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.reactive.StreamFunction
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(fs.b context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = this.textFilterText;
        if (str != null) {
            if (!(str.length() == 0)) {
                PublishVideoEntry publishVideoEntry = context.f400387d;
                String videoDoodleDescription = publishVideoEntry.videoDoodleDescription;
                if (videoDoodleDescription != null) {
                    Intrinsics.checkNotNullExpressionValue(videoDoodleDescription, "videoDoodleDescription");
                    if (!(videoDoodleDescription.length() == 0)) {
                        publishVideoEntry.videoDoodleDescription = publishVideoEntry.videoDoodleDescription + this.textFilterText;
                        notifyResult(context);
                        return;
                    }
                }
                publishVideoEntry.videoDoodleDescription = this.textFilterText;
                notifyResult(context);
                return;
            }
        }
        notifyResult(context);
    }
}
