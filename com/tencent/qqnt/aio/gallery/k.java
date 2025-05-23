package com.tencent.qqnt.aio.gallery;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richframework.data.idata.IDataConverter;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/k;", "Lcom/tencent/richframework/data/idata/IDataConverter;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "fromObj", "", "b", "oldObj", "latestObj", "", "c", "preObj", "a", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class k implements IDataConverter<RFWLayerItemMediaInfo> {
    static IPatchRedirector $redirector_;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RFWLayerItemMediaInfo cloneConvertData(@NotNull RFWLayerItemMediaInfo preObj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RFWLayerItemMediaInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) preObj);
        }
        Intrinsics.checkNotNullParameter(preObj, "preObj");
        return preObj;
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getObserverKey(@NotNull RFWLayerItemMediaInfo fromObj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) fromObj);
        }
        Intrinsics.checkNotNullParameter(fromObj, "fromObj");
        String mediaId = fromObj.getMediaId();
        if (mediaId == null) {
            return "";
        }
        return mediaId;
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(@NotNull RFWLayerItemMediaInfo oldObj, @NotNull RFWLayerItemMediaInfo latestObj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) oldObj, (Object) latestObj);
        } else {
            Intrinsics.checkNotNullParameter(oldObj, "oldObj");
            Intrinsics.checkNotNullParameter(latestObj, "latestObj");
        }
    }
}
