package com.tencent.kuikly.core.base;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.event.Event;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005J!\u0010\n\u001a\u00020\u00072\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\b\bH&JA\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\b\bH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/kuikly/core/base/q;", "Lcom/tencent/kuikly/core/base/Attr;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/kuikly/core/base/event/Event;", "E", "", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "init", "attr", "Lcom/tencent/kuikly/core/base/b;", "animation", "", "completion", "attrBlock", "animateToAttr", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public interface q<A extends Attr, E extends Event> {
    void animateToAttr(b animation, Function1<? super Boolean, Unit> completion, Function1<? super Attr, Unit> attrBlock);

    void attr(Function1<? super A, Unit> init);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(q qVar, b bVar, Function1 function1, Function1 function12, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    function1 = null;
                }
                qVar.animateToAttr(bVar, function1, function12);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateToAttr");
        }
    }
}
