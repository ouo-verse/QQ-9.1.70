package com.tencent.mobileqq.wink.dailysign;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStoreOwner;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0014J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/ah;", "Lcom/tencent/mobileqq/wink/editor/music/ab;", "Lr53/a;", "", "Bb", "Landroid/os/Bundle;", "args", "L9", "Landroidx/lifecycle/ViewModelStoreOwner;", "Za", "Landroidx/lifecycle/MutableLiveData;", "", "J3", "Lcom/tencent/mobileqq/wink/editor/dr;", "H9", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "metaCategories", "", "Lb", "P3", "k0", "Landroidx/lifecycle/MutableLiveData;", "getCurrentPlayerTimeLiveData", "()Landroidx/lifecycle/MutableLiveData;", "currentPlayerTimeLiveData", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ah extends com.tencent.mobileqq.wink.editor.music.ab implements r53.a {

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> currentPlayerTimeLiveData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/dailysign/ah$a", "Landroidx/lifecycle/Observer;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "metaCategories", "", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements Observer<List<? extends MetaCategory>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable List<MetaCategory> metaCategories) {
            if (!ah.this.Lb(metaCategories).isEmpty()) {
                WinkEditorResourceManager.a1().K0().removeObserver(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kb(ah this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x9();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.wink.editor.music.ab
    protected void Bb() {
        if (H9() != null && this.X.getGetCategoryMusicListFail()) {
            Lb(WinkEditorResourceManager.a1().K0().getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d
    @Nullable
    public dr H9() {
        DailySignFragment dailySignFragment;
        Fragment hostFragment = getHostFragment();
        if (hostFragment instanceof DailySignFragment) {
            dailySignFragment = (DailySignFragment) hostFragment;
        } else {
            dailySignFragment = null;
        }
        if (dailySignFragment == null) {
            return null;
        }
        return dailySignFragment.zi();
    }

    @Override // com.tencent.mobileqq.wink.editor.music.ab, r53.a
    @NotNull
    public MutableLiveData<Long> J3() {
        return this.currentPlayerTimeLiveData;
    }

    @Override // com.tencent.mobileqq.wink.editor.music.ab, com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        super.L9(args);
        View partRootView = getPartRootView();
        if (partRootView != null) {
            partRootView.bringToFront();
        }
        View partRootView2 = getPartRootView();
        if (partRootView2 != null) {
            partRootView2.setClickable(true);
        }
        View partRootView3 = getPartRootView();
        if (partRootView3 != null) {
            partRootView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.dailysign.ag
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ah.Kb(ah.this, view);
                }
            });
        }
        Gb(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0060, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r1, new java.lang.String[]{","}, false, 0, 6, (java.lang.Object) null);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<String> Lb(@Nullable List<MetaCategory> metaCategories) {
        List emptyList;
        Object obj;
        ArrayList<MetaMaterial> arrayList;
        Object obj2;
        Map<String, String> map;
        String str = null;
        if (metaCategories != null) {
            Iterator<T> it = metaCategories.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((MetaCategory) obj).f30532id, "music")) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            MetaCategory metaCategory = (MetaCategory) obj;
            if (metaCategory != null && (arrayList = metaCategory.materials) != null) {
                Iterator<T> it5 = arrayList.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj2 = it5.next();
                        if (Intrinsics.areEqual(((MetaMaterial) obj2).f30533id, "daily_sign_in_recommend_music_list")) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                MetaMaterial metaMaterial = (MetaMaterial) obj2;
                if (metaMaterial != null && (map = metaMaterial.additionalFields) != null) {
                    str = map.get("musicList");
                }
            }
        }
        String str2 = str;
        if (str2 == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList<String> arrayList2 = new ArrayList<>(emptyList);
        this.X.M4(arrayList2);
        return arrayList2;
    }

    @Override // r53.a
    public void P3() {
        WinkEditorResourceManager.a1().K0().observe(getHostFragment(), new a());
        this.X.u4(true);
        this.X.p4(true);
        this.Y.I2(false);
        this.Y.H2(false);
        MusicVolumeControlViewModel mMusicVolumeControlViewModel = this.Y;
        Intrinsics.checkNotNullExpressionValue(mMusicVolumeControlViewModel, "mMusicVolumeControlViewModel");
        MusicVolumeControlViewModel.z2(mMusicVolumeControlViewModel, false, false, 2, null);
        this.Y.n2(true, true);
        this.Y.S1(this.Y.Z1(), MusicVolumeControlViewModel.VolumeType.BGM);
    }

    @Override // com.tencent.mobileqq.wink.editor.music.ab
    @NotNull
    protected ViewModelStoreOwner Za() {
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        return hostFragment;
    }
}
