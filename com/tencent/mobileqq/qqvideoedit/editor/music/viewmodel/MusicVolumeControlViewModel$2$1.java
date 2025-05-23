package com.tencent.mobileqq.qqvideoedit.editor.music.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqvideoedit.editor.music.viewmodel.MusicVolumeControlViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "type", "Lcom/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
final class MusicVolumeControlViewModel$2$1 extends Lambda implements Function1<MusicVolumeControlViewModel.VolumeType, Unit> {
    final /* synthetic */ MediatorLiveData<Float> $this_apply;
    final /* synthetic */ MusicVolumeControlViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicVolumeControlViewModel$2$1(MediatorLiveData<Float> mediatorLiveData, MusicVolumeControlViewModel musicVolumeControlViewModel) {
        super(1);
        this.$this_apply = mediatorLiveData;
        this.this$0 = musicVolumeControlViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MusicVolumeControlViewModel.VolumeType volumeType) {
        invoke2(volumeType);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MusicVolumeControlViewModel.VolumeType volumeType) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        if (volumeType != MusicVolumeControlViewModel.VolumeType.BGM && volumeType != MusicVolumeControlViewModel.VolumeType.TEMPLATE) {
            if (volumeType == MusicVolumeControlViewModel.VolumeType.NONE) {
                MediatorLiveData<Float> mediatorLiveData = this.$this_apply;
                mutableLiveData3 = this.this$0._bgmSliderLiveData;
                mediatorLiveData.removeSource(mutableLiveData3);
                return;
            }
            return;
        }
        MediatorLiveData<Float> mediatorLiveData2 = this.$this_apply;
        mutableLiveData = this.this$0._bgmSliderLiveData;
        mediatorLiveData2.removeSource(mutableLiveData);
        MediatorLiveData<Float> mediatorLiveData3 = this.$this_apply;
        mutableLiveData2 = this.this$0._bgmSliderLiveData;
        final MediatorLiveData<Float> mediatorLiveData4 = this.$this_apply;
        final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.music.viewmodel.MusicVolumeControlViewModel$2$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                mediatorLiveData4.postValue(f16);
            }
        };
        mediatorLiveData3.addSource(mutableLiveData2, new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.music.viewmodel.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicVolumeControlViewModel$2$1.b(Function1.this, obj);
            }
        });
    }
}
