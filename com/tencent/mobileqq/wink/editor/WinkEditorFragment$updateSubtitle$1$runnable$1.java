package com.tencent.mobileqq.wink.editor;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/editor/WinkEditorFragment$updateSubtitle$1$runnable$1", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "d", "Z", "getExecute", "()Z", "setExecute", "(Z)V", "execute", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorFragment$updateSubtitle$1$runnable$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean execute;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef<WinkStickerModel> f318588e;
    final /* synthetic */ WinkEditorFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WinkEditorFragment$updateSubtitle$1$runnable$1(WinkEditorFragment winkEditorFragment, Ref.ObjectRef<WinkStickerModel> objectRef) {
        this.this$0 = winkEditorFragment;
        this.f318588e = objectRef;
    }

    @Override // java.lang.Runnable
    public void run() {
        WinkSubtitleViewModel Gk;
        if (this.execute) {
            return;
        }
        this.execute = true;
        w53.b.f("WinkEditorFragment", "check subtitle refresh");
        if (this.this$0.curTavCut != null) {
            Gk = this.this$0.Gk();
            dr drVar = this.this$0.curTavCut;
            Intrinsics.checkNotNull(drVar);
            WinkSubtitleViewModel.f3(Gk, drVar, false, false, this.f318588e.element, 4, null);
        }
    }
}
