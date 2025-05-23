package com.tencent.mobileqq.filebrowser.richmedia;

import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.filebrowser.richmedia.part.FileLayerMorePart;
import com.tencent.mobileqq.filebrowser.richmedia.share.FileShareActionManager;
import com.tencent.mobileqq.filebrowser.richmedia.share.a;
import com.tencent.mobileqq.filebrowser.richmedia.share.c;
import com.tencent.mobileqq.filebrowser.richmedia.share.h;
import com.tencent.mobileqq.filebrowser.richmedia.share.l;
import com.tencent.mobileqq.filebrowser.richmedia.share.n;
import com.tencent.mobileqq.filebrowser.richmedia.share.o;
import com.tencent.mobileqq.filebrowser.richmedia.share.p;
import com.tencent.mobileqq.filebrowser.richmedia.share.r;
import com.tencent.mobileqq.richmedia.part.CommonLayerBottomPart;
import com.tencent.mobileqq.richmedia.part.b;
import com.tencent.mobileqq.richmedia.part.e;
import com.tencent.mobileqq.richmedia.part.f;
import com.tencent.mobileqq.richmedia.part.i;
import com.tencent.mobileqq.richmedia.part.j;
import com.tencent.richframework.gallery.QQLayerFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/filebrowser/richmedia/TroopFilePreviewLayerFragment;", "Lcom/tencent/richframework/gallery/QQLayerFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "getPlayScene", "", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class TroopFilePreviewLayerFragment extends QQLayerFragment {
    @Override // com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new f());
        arrayList.addAll(super.assembleParts());
        arrayList.add(new e());
        arrayList.add(new CommonLayerBottomPart());
        arrayList.add(new i());
        arrayList.add(new b());
        arrayList.add(new j());
        FileShareActionManager fileShareActionManager = new FileShareActionManager();
        fileShareActionManager.a(new n());
        fileShareActionManager.a(new o());
        fileShareActionManager.a(new p());
        fileShareActionManager.a(new com.tencent.mobileqq.filebrowser.richmedia.share.e());
        fileShareActionManager.a(new h());
        fileShareActionManager.a(new l());
        fileShareActionManager.a(new c());
        fileShareActionManager.a(new a());
        fileShareActionManager.a(new r());
        fileShareActionManager.a(new com.tencent.mobileqq.filebrowser.richmedia.share.b(false));
        fileShareActionManager.a(new com.tencent.mobileqq.filebrowser.richmedia.share.b(true));
        fileShareActionManager.a(new com.tencent.mobileqq.filebrowser.richmedia.share.f());
        fileShareActionManager.a(new com.tencent.mobileqq.filebrowser.richmedia.share.i());
        arrayList.add(new FileLayerMorePart(fileShareActionManager));
        return arrayList;
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment
    public int getPlayScene() {
        return 175;
    }
}
