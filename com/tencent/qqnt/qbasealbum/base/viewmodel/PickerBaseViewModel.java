package com.tencent.qqnt.qbasealbum.base.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.customization.CustomizationFacade;
import com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic;
import com.tencent.qqnt.qbasealbum.filter.MediaFilter;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PageType;
import com.tencent.qqnt.qbasealbum.select.model.b;
import com.tencent.qqnt.qbasealbum.select.model.d;
import com.tencent.qqnt.qbasealbum.select.model.e;
import com.tencent.qqnt.qbasealbum.select.model.f;
import com.tencent.qqnt.qbasealbum.select.model.g;
import com.tencent.qqnt.qbasealbum.select.model.h;
import com.tencent.qqnt.qbasealbum.select.model.i;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b7\u00108J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0016\u0010\u0010\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\"\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00150\u00140\u00132\u0006\u0010\u0012\u001a\u00020\u0011H$J\"\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00150\u00140\u00172\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0016\u0010\u0019\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&J\u001c\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0017J<\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00150\u00142\u001e\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u001d\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00150\u00140\u001c2\u0006\u0010 \u001a\u00020\u001fH\u0004R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060\u00178\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020\u001d0&8\u0006\u00a2\u0006\f\n\u0004\b/\u0010(\u001a\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/base/viewmodel/PickerBaseViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/qqnt/qbasealbum/select/model/f;", "action", "", "d2", "Lcom/tencent/qqnt/qbasealbum/select/model/a;", "g2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "e2", "f2", "b2", "c2", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "selectedMedia", "updateIndexInSelectedMedia", "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "pageType", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "W1", "Landroidx/lifecycle/LiveData;", "U1", "onMediaInit", "selectedMediaChangedActionLiveData", "Z1", "", "", "albumIdToMediaUIStateData", "Lcom/tencent/qqnt/qbasealbum/base/repository/a;", "mediaRepoData", "X1", "", "i", "Z", "isSelectedMediaChangedActionLiveDataAdd", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_mediaChangedActionMutableLiveData", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "getMediaChangedActionLiveData", "()Landroidx/lifecycle/LiveData;", "mediaChangedActionLiveData", "D", "T1", "()Landroidx/lifecycle/MutableLiveData;", "curAlbumId", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "E", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "mediaFilter", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class PickerBaseViewModel extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<com.tencent.qqnt.qbasealbum.select.model.a> mediaChangedActionLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> curAlbumId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MediaFilter mediaFilter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isSelectedMediaChangedActionLiveDataAdd;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.qqnt.qbasealbum.select.model.a> _mediaChangedActionMutableLiveData;

    public PickerBaseViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<com.tencent.qqnt.qbasealbum.select.model.a> mutableLiveData = new MutableLiveData<>();
        this._mediaChangedActionMutableLiveData = mutableLiveData;
        this.mediaChangedActionLiveData = mutableLiveData;
        this.curAlbumId = new MutableLiveData<>();
        this.mediaFilter = QAlbumPickerContext.f361201a.e().q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a2(com.tencent.qqnt.qbasealbum.select.model.a action) {
        b bVar;
        if (action instanceof b) {
            bVar = (b) action;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.a().setSelectStatus(1);
            com.tencent.qqnt.qbasealbum.ktx.b.s(bVar.a(), bVar.b());
            this._mediaChangedActionMutableLiveData.setValue(new b(bVar.b(), bVar.a(), bVar.c()));
            AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = CustomizationFacade.f361084a.b();
            if (b16 != null) {
                b16.onMediaSelectEvent(((b) action).a(), true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b2(com.tencent.qqnt.qbasealbum.select.model.a action) {
        this._mediaChangedActionMutableLiveData.setValue(action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2(f action) {
        if (action != null) {
            int i3 = 0;
            for (Object obj : action.a()) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                LocalMediaInfo localMediaInfo = (LocalMediaInfo) obj;
                localMediaInfo.setSelectStatus(1);
                com.tencent.qqnt.qbasealbum.ktx.b.s(localMediaInfo, i3);
                i3 = i16;
            }
            onMediaInit(action.a());
            this._mediaChangedActionMutableLiveData.setValue(new f(action.a()));
            AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = CustomizationFacade.f361084a.b();
            if (b16 != null) {
                b16.onMediaInitEvent(action.a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2(com.tencent.qqnt.qbasealbum.select.model.a action) {
        g gVar;
        if (action instanceof g) {
            gVar = (g) action;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            updateIndexInSelectedMedia(gVar.c());
            this._mediaChangedActionMutableLiveData.setValue(action);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2(com.tencent.qqnt.qbasealbum.select.model.a action) {
        h hVar;
        if (action instanceof h) {
            hVar = (h) action;
        } else {
            hVar = null;
        }
        if (hVar != null) {
            hVar.b().setSelectStatus(2);
            updateIndexInSelectedMedia(hVar.c());
            this._mediaChangedActionMutableLiveData.setValue(action);
            AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = CustomizationFacade.f361084a.b();
            if (b16 != null) {
                b16.onMediaSelectEvent(((h) action).b(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2(com.tencent.qqnt.qbasealbum.select.model.a action) {
        i iVar;
        if (action instanceof i) {
            iVar = (i) action;
        } else {
            iVar = null;
        }
        if (iVar != null) {
            updateIndexInSelectedMedia(iVar.a());
            this._mediaChangedActionMutableLiveData.setValue(new i(iVar.a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeSelectedMediaChange$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void updateIndexInSelectedMedia(List<LocalMediaInfo> selectedMedia) {
        int i3 = 0;
        for (Object obj : selectedMedia) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.qqnt.qbasealbum.ktx.b.s((LocalMediaInfo) obj, i3);
            i3 = i16;
        }
    }

    @NotNull
    public final MutableLiveData<String> T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.curAlbumId;
    }

    @NotNull
    public abstract LiveData<UIStateData<List<LocalMediaInfo>>> U1(@NotNull PageType pageType);

    @NotNull
    protected abstract MediatorLiveData<UIStateData<List<LocalMediaInfo>>> W1(@NotNull PageType pageType);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final UIStateData<List<LocalMediaInfo>> X1(@NotNull Map<String, UIStateData<List<LocalMediaInfo>>> albumIdToMediaUIStateData, @NotNull com.tencent.qqnt.qbasealbum.base.repository.a mediaRepoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (UIStateData) iPatchRedirector.redirect((short) 5, (Object) this, (Object) albumIdToMediaUIStateData, (Object) mediaRepoData);
        }
        Intrinsics.checkNotNullParameter(albumIdToMediaUIStateData, "albumIdToMediaUIStateData");
        Intrinsics.checkNotNullParameter(mediaRepoData, "mediaRepoData");
        String a16 = mediaRepoData.a();
        UIStateData<List<LocalMediaInfo>> initData = albumIdToMediaUIStateData.get(a16);
        if (initData == null) {
            initData = UIStateData.obtainEmpty();
            initData.setDataList(new ArrayList());
            Intrinsics.checkNotNullExpressionValue(initData, "initData");
            albumIdToMediaUIStateData.put(a16, initData);
        }
        UIStateData<List<LocalMediaInfo>> uIStateData = initData;
        uIStateData.setState(3);
        uIStateData.setFinish(!mediaRepoData.b());
        return uIStateData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z1(@NotNull PageType pageType, @NotNull LiveData<com.tencent.qqnt.qbasealbum.select.model.a> selectedMediaChangedActionLiveData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) pageType, (Object) selectedMediaChangedActionLiveData);
            return;
        }
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(selectedMediaChangedActionLiveData, "selectedMediaChangedActionLiveData");
        if (this.isSelectedMediaChangedActionLiveDataAdd) {
            return;
        }
        this.isSelectedMediaChangedActionLiveDataAdd = true;
        W1(pageType).removeSource(selectedMediaChangedActionLiveData);
        MediatorLiveData<UIStateData<List<LocalMediaInfo>>> W1 = W1(pageType);
        final Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit> function1 = new Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit>() { // from class: com.tencent.qqnt.qbasealbum.base.viewmodel.PickerBaseViewModel$observeSelectedMediaChange$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PickerBaseViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.qbasealbum.select.model.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.qbasealbum.select.model.a it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                if (it instanceof f) {
                    PickerBaseViewModel.this.d2((f) it);
                    return;
                }
                if (it instanceof i) {
                    PickerBaseViewModel pickerBaseViewModel = PickerBaseViewModel.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    pickerBaseViewModel.g2(it);
                    return;
                }
                if (it instanceof b) {
                    PickerBaseViewModel pickerBaseViewModel2 = PickerBaseViewModel.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    pickerBaseViewModel2.a2(it);
                    return;
                }
                if (it instanceof g) {
                    PickerBaseViewModel pickerBaseViewModel3 = PickerBaseViewModel.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    pickerBaseViewModel3.e2(it);
                    return;
                }
                if (it instanceof h) {
                    PickerBaseViewModel pickerBaseViewModel4 = PickerBaseViewModel.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    pickerBaseViewModel4.f2(it);
                } else if (it instanceof d) {
                    PickerBaseViewModel pickerBaseViewModel5 = PickerBaseViewModel.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    pickerBaseViewModel5.b2(it);
                } else if (it instanceof e) {
                    PickerBaseViewModel pickerBaseViewModel6 = PickerBaseViewModel.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    pickerBaseViewModel6.c2(it);
                }
            }
        };
        W1.addSource(selectedMediaChangedActionLiveData, new Observer() { // from class: com.tencent.qqnt.qbasealbum.base.viewmodel.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PickerBaseViewModel.observeSelectedMediaChange$lambda$0(Function1.this, obj);
            }
        });
    }

    @NotNull
    public final LiveData<com.tencent.qqnt.qbasealbum.select.model.a> getMediaChangedActionLiveData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mediaChangedActionLiveData;
    }

    public abstract void onMediaInit(@NotNull List<LocalMediaInfo> selectedMedia);

    /* JADX INFO: Access modifiers changed from: private */
    public final void c2(com.tencent.qqnt.qbasealbum.select.model.a action) {
    }
}
