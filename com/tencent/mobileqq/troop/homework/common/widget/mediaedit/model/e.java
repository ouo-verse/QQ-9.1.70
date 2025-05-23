package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/e;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/d;", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "items", "", "t", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e extends d {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            k().setShowInputMethodOnce(false);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.d
    @NotNull
    public List<BaseItem> q() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(k());
            arrayListOf.add(p().resetData(o()));
            arrayListOf.addAll(j());
            arrayListOf.addAll(m());
            return arrayListOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t(@NotNull List<? extends BaseItem> items) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) items);
            return;
        }
        Intrinsics.checkNotNullParameter(items, "items");
        for (BaseItem baseItem : items) {
            baseItem.setSupportDelete(true);
            baseItem.setLocalFile(false);
            baseItem.setState(UploadOrDownloadState.UPLOAD_SUC);
            if (baseItem instanceof ContentItem) {
                k().setContent(((ContentItem) baseItem).getContent());
            } else if (baseItem instanceof MediaListItem) {
                t(((MediaListItem) baseItem).getData());
            } else if (baseItem instanceof ImageItem) {
                o().add(baseItem);
            } else if (baseItem instanceof VideoItem) {
                o().add(baseItem);
            } else if (baseItem instanceof AudioItem) {
                j().add(baseItem);
            } else if (baseItem instanceof FileItem) {
                m().add(baseItem);
            }
        }
    }
}
