package com.tencent.mobileqq.wink.editor.music.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", NodeProps.ENABLED, "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
final class MusicVolumeControlViewModel$1$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ MusicVolumeControlViewModel.d $this_apply;
    final /* synthetic */ MusicVolumeControlViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicVolumeControlViewModel$1$1(MusicVolumeControlViewModel.d dVar, MusicVolumeControlViewModel musicVolumeControlViewModel) {
        super(1);
        this.$this_apply = dVar;
        this.this$0 = musicVolumeControlViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        if (!bool.booleanValue()) {
            MusicVolumeControlViewModel.d dVar = this.$this_apply;
            mutableLiveData2 = this.this$0._originSliderLiveData;
            dVar.removeSource(mutableLiveData2);
        } else {
            MusicVolumeControlViewModel.d dVar2 = this.$this_apply;
            mutableLiveData = this.this$0._originSliderLiveData;
            final MusicVolumeControlViewModel.d dVar3 = this.$this_apply;
            final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel$1$1.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                    invoke2(f16);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Float f16) {
                    MusicVolumeControlViewModel.d.this.postValue(f16);
                }
            };
            dVar2.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.aa
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MusicVolumeControlViewModel$1$1.b(Function1.this, obj);
                }
            });
        }
    }
}
