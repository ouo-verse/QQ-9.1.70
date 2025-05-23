package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model;

import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/FileItem;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "()V", TagName.FILE_TYPE, "", "getFileType", "()I", "setFileType", "(I)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class FileItem extends BaseItem {
    static IPatchRedirector $redirector_;
    private int fileType;

    public FileItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.fileType = -1;
        }
    }

    public final int getFileType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.fileType;
    }

    public final void setFileType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.fileType = i3;
        }
    }
}
