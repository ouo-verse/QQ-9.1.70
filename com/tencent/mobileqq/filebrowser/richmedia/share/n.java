package com.tencent.mobileqq.filebrowser.richmedia.share;

import com.tencent.mobileqq.filebrowser.richmedia.share.FileShareActionManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/filebrowser/richmedia/share/n;", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/o;", "", "", "c", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileShareActionManager$ShareLine;", "b", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class n extends o {
    @Override // com.tencent.mobileqq.filebrowser.richmedia.share.o, com.tencent.mobileqq.filebrowser.richmedia.share.FileAbsShareAction
    @NotNull
    public FileShareActionManager.ShareLine b() {
        return FileShareActionManager.ShareLine.NONE;
    }

    @Override // com.tencent.mobileqq.filebrowser.richmedia.share.o, com.tencent.mobileqq.filebrowser.richmedia.share.FileAbsShareAction
    @NotNull
    public List<Integer> c() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{73, 72});
        return listOf;
    }
}
