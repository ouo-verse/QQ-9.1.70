package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render;

import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H&J)\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\u0004H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/r;", "V", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/j;", "data", "", "b", "(Ljava/lang/Object;)I", TemplateParser.KEY_ENTITY_ID, "", "a", "originalEntityId", "oldData", "newData", "e", "(ILjava/lang/Object;Ljava/lang/Object;)V", "", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface r<V> extends j {
    void a(int entityId);

    int b(V data);

    @Nullable
    Object d(int entityId);

    void e(int originalEntityId, @Nullable V oldData, V newData);
}
