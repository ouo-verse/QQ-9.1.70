package com.tencent.mobileqq.wink.editor.subtitle;

import com.tencent.mobileqq.wink.editor.subtitle.WinkSubtitleViewModel;
import com.tencent.mobileqq.wink.editor.subtitle.source.Subtitle;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/subtitle/WinkSubtitleViewModel$subtitles$1", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/Subtitle;", "Lkotlin/collections/ArrayList;", "addAll", "", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "", QCircleLpReportDc05507.KEY_CLEAR, "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkSubtitleViewModel$subtitles$1 extends ArrayList<Subtitle> {
    final /* synthetic */ WinkSubtitleViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WinkSubtitleViewModel$subtitles$1(WinkSubtitleViewModel winkSubtitleViewModel) {
        this.this$0 = winkSubtitleViewModel;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@NotNull Collection<? extends Subtitle> elements) {
        WinkSubtitleViewModel.c cVar;
        Intrinsics.checkNotNullParameter(elements, "elements");
        cVar = this.this$0._showBilingualLiveData;
        cVar.postValue(Boolean.valueOf(!elements.isEmpty()));
        return super.addAll(elements);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        WinkSubtitleViewModel.c cVar;
        cVar = this.this$0._showBilingualLiveData;
        cVar.postValue(Boolean.FALSE);
        super.clear();
    }

    public /* bridge */ boolean contains(Subtitle subtitle) {
        return super.contains((Object) subtitle);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ int indexOf(Subtitle subtitle) {
        return super.indexOf((Object) subtitle);
    }

    public /* bridge */ int lastIndexOf(Subtitle subtitle) {
        return super.lastIndexOf((Object) subtitle);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ Subtitle remove(int i3) {
        return removeAt(i3);
    }

    public /* bridge */ Subtitle removeAt(int i3) {
        return (Subtitle) super.remove(i3);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Subtitle) {
            return contains((Subtitle) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Subtitle) {
            return indexOf((Subtitle) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Subtitle) {
            return lastIndexOf((Subtitle) obj);
        }
        return -1;
    }

    public /* bridge */ boolean remove(Subtitle subtitle) {
        return super.remove((Object) subtitle);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Subtitle) {
            return remove((Subtitle) obj);
        }
        return false;
    }
}
