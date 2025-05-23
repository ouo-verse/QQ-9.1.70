package com.tencent.mobileqq.wink.editor.template;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.event.StickerEditEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0004J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00110\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001bR\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110\u001d8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!R \u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateTextListViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "isShown", "", "U1", "", "getLogTag", "Lcom/tencent/mobileqq/wink/editor/dr;", "tavcut", "Q1", "L1", "", "Lcom/tencent/mobileqq/wink/editor/template/d;", "O1", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "T1", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "winkStickerModel", "R1", "W1", "S1", "P1", "i", "Lcom/tencent/mobileqq/wink/editor/dr;", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_onStickerClickLiveData", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "M1", "()Landroidx/lifecycle/LiveData;", "onStickerClickLiveData", "D", "_switchTemplateTextMenuPartLiveData", "E", "N1", "switchTemplateTextMenuPartLiveData", "", UserInfo.SEX_FEMALE, "Ljava/util/Map;", "backupAllStickers", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorTemplateTextListViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<WinkStickerModel> onStickerClickLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<WinkStickerModel> _switchTemplateTextMenuPartLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<WinkStickerModel> switchTemplateTextMenuPartLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Map<String, WinkStickerModel> backupAllStickers;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private dr tavcut;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<WinkStickerModel> _onStickerClickLiveData;

    public WinkEditorTemplateTextListViewModel() {
        MutableLiveData<WinkStickerModel> mutableLiveData = new MutableLiveData<>();
        this._onStickerClickLiveData = mutableLiveData;
        this.onStickerClickLiveData = mutableLiveData;
        MutableLiveData<WinkStickerModel> mutableLiveData2 = new MutableLiveData<>();
        this._switchTemplateTextMenuPartLiveData = mutableLiveData2;
        this.switchTemplateTextMenuPartLiveData = mutableLiveData2;
        this.backupAllStickers = new LinkedHashMap();
    }

    private final void U1(boolean isShown) {
        int i3;
        if (isShown) {
            i3 = 18;
        } else {
            i3 = 19;
        }
        SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(i3, 104));
    }

    public final void L1() {
        Map<String, WinkStickerModel> m3;
        this.backupAllStickers.clear();
        dr drVar = this.tavcut;
        if (drVar != null && (m3 = drVar.m()) != null) {
            for (Map.Entry<String, WinkStickerModel> entry : m3.entrySet()) {
                this.backupAllStickers.put(entry.getKey(), entry.getValue().copy());
            }
        }
    }

    @NotNull
    public final LiveData<WinkStickerModel> M1() {
        return this.onStickerClickLiveData;
    }

    @NotNull
    public final LiveData<WinkStickerModel> N1() {
        return this.switchTemplateTextMenuPartLiveData;
    }

    @NotNull
    public final List<d> O1() {
        Comparator compareBy;
        Map<String, WinkStickerModel> m3;
        Collection<WinkStickerModel> values;
        ArrayList arrayList = new ArrayList();
        dr drVar = this.tavcut;
        if (drVar != null && (m3 = drVar.m()) != null && (values = m3.values()) != null) {
            for (WinkStickerModel winkStickerModel : values) {
                if (winkStickerModel.isTemplateTextSticker()) {
                    long j3 = winkStickerModel.startTime;
                    dr drVar2 = this.tavcut;
                    Intrinsics.checkNotNull(drVar2);
                    if (j3 <= drVar2.getDurationUs()) {
                        arrayList.add(new d(winkStickerModel));
                    }
                }
            }
        }
        compareBy = ComparisonsKt__ComparisonsKt.compareBy(new Function1<d, Comparable<?>>() { // from class: com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateTextListViewModel$getTemplateTextItems$2
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Comparable<?> invoke(@NotNull d it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Long.valueOf(it.getStartTimeUs());
            }
        }, new Function1<d, Comparable<?>>() { // from class: com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateTextListViewModel$getTemplateTextItems$3
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Comparable<?> invoke(@NotNull d it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getDefaultTextContent();
            }
        });
        CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, compareBy);
        return arrayList;
    }

    public final void P1() {
        this.tavcut = null;
        U1(false);
    }

    public final void Q1(@NotNull dr tavcut) {
        Intrinsics.checkNotNullParameter(tavcut, "tavcut");
        this.tavcut = tavcut;
        U1(true);
    }

    public final void R1(@Nullable WinkStickerModel winkStickerModel) {
        this._onStickerClickLiveData.postValue(winkStickerModel);
    }

    public final void S1() {
        dr drVar = this.tavcut;
        if (drVar != null) {
            drVar.B(this.backupAllStickers);
        }
    }

    public final void T1(@Nullable d item) {
        dr drVar;
        long startTimeUs;
        if (item != null && (drVar = this.tavcut) != null) {
            drVar.pause();
            if (item.getStartTimeUs() + item.getDurationUs() > drVar.getDurationUs()) {
                startTimeUs = (item.getStartTimeUs() + drVar.getDurationUs()) / 2;
            } else {
                startTimeUs = item.getStartTimeUs() + (item.getDurationUs() / 2);
            }
            drVar.seek(startTimeUs);
        }
    }

    public final void W1(@NotNull d item) {
        Map<String, WinkStickerModel> m3;
        WinkStickerModel winkStickerModel;
        Intrinsics.checkNotNullParameter(item, "item");
        dr drVar = this.tavcut;
        if (drVar != null && (m3 = drVar.m()) != null && (winkStickerModel = m3.get(item.getStickerUid())) != null) {
            this._switchTemplateTextMenuPartLiveData.postValue(winkStickerModel);
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "WinkEditorTemplateTextListViewModel";
    }
}
