package com.tencent.mobileqq.exportfile.fragment.filelist;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richmedialist.model.BaseItemInfo;
import com.tencent.mobileqq.richmedialist.model.DirectoryItemInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeNodeType;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/filelist/r;", "Lzm2/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "position", "", "onBindViewHolder", "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class r extends zm2.a {
    static IPatchRedirector $redirector_;

    public r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        DirectoryItemInfo directoryItemInfo;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder, position);
        BaseItemInfo baseItemInfo = getItems().get(position);
        FileBridgeNodeType fileBridgeNodeType = null;
        if (baseItemInfo instanceof DirectoryItemInfo) {
            directoryItemInfo = (DirectoryItemInfo) baseItemInfo;
        } else {
            directoryItemInfo = null;
        }
        if (directoryItemInfo != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("dt_eid", "em_bas_folder");
            linkedHashMap.put("dt_pgid", "pg_bas_computer_file");
            Object extra = directoryItemInfo.getExtra();
            if (extra instanceof FileBridgeNodeType) {
                fileBridgeNodeType = (FileBridgeNodeType) extra;
            }
            if (fileBridgeNodeType != null) {
                obj = Integer.valueOf(fileBridgeNodeType.ordinal());
            } else {
                obj = FileBridgeNodeType.KNULL;
            }
            linkedHashMap.put("folder_type", obj);
            VideoReport.reportEvent("imp", linkedHashMap);
        }
    }
}
