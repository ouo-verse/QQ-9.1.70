package com.tencent.mobileqq.troop.teamup.publish.vm;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.AudioItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseMediaItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ContentItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.FileItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ImageItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.MediaListItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.UploadOrDownloadState;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.VideoItem;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006J\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bJ\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/publish/vm/a;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/d;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "t", "", "items", "u", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpImage;", "Lkotlin/collections/ArrayList;", "v", "", "w", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.d {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t(@NotNull BaseItem item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        item.setSupportDelete(true);
        item.setLocalFile(false);
        item.setState(UploadOrDownloadState.UPLOAD_SUC);
        if (item instanceof ContentItem) {
            ContentItem k3 = k();
            k3.setContent(k3.getContent() + ((ContentItem) item).getContent());
            return;
        }
        if (item instanceof MediaListItem) {
            u(((MediaListItem) item).getData());
            return;
        }
        if (item instanceof ImageItem) {
            o().add(item);
            return;
        }
        if (item instanceof VideoItem) {
            o().add(item);
        } else if (item instanceof AudioItem) {
            j().add(item);
        } else if (item instanceof FileItem) {
            m().add(item);
        }
    }

    public final void u(@NotNull List<? extends BaseItem> items) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) items);
            return;
        }
        Intrinsics.checkNotNullParameter(items, "items");
        Iterator<? extends BaseItem> it = items.iterator();
        while (it.hasNext()) {
            t(it.next());
        }
    }

    @NotNull
    public final ArrayList<TeamUpImage> v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList<BaseMediaItem> o16 = o();
        ArrayList<ImageItem> arrayList = new ArrayList();
        for (Object obj : o16) {
            if (obj instanceof ImageItem) {
                arrayList.add(obj);
            }
        }
        ArrayList<TeamUpImage> arrayList2 = new ArrayList<>(n());
        for (ImageItem imageItem : arrayList) {
            TeamUpImage teamUpImage = new TeamUpImage();
            teamUpImage.width = imageItem.getWidth();
            teamUpImage.height = imageItem.getHeight();
            teamUpImage.picUrl = imageItem.getHttpUrl();
            teamUpImage.md5 = imageItem.getFileMd5();
            arrayList2.add(teamUpImage);
        }
        return arrayList2;
    }

    public final boolean w() {
        boolean isBlank;
        boolean isBlank2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            isBlank = StringsKt__StringsJVMKt.isBlank(r().getTitle());
            if (isBlank) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(k().getContent());
                if (isBlank2 && o().isEmpty() && j().isEmpty() && m().isEmpty()) {
                    return true;
                }
            }
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
    }
}
