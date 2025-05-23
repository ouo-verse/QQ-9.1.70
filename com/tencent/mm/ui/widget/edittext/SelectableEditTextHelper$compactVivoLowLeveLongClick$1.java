package com.tencent.mm.ui.widget.edittext;

import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class SelectableEditTextHelper$compactVivoLowLeveLongClick$1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SelectableEditTextHelper f153306a;

    public SelectableEditTextHelper$compactVivoLowLeveLongClick$1(SelectableEditTextHelper selectableEditTextHelper) {
        this.f153306a = selectableEditTextHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ReflectUtil.INSTANCE.stopSelectionMode(this.f153306a.getMTextView());
    }
}
