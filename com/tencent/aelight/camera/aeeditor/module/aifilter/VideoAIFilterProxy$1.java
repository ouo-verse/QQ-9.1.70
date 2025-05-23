package com.tencent.aelight.camera.aeeditor.module.aifilter;

import android.content.Context;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import cr.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes32.dex */
class VideoAIFilterProxy$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f66173d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Context f66174e;
    final /* synthetic */ e this$0;

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        if (this.this$0.f66183f != null) {
            str = e.f66182g;
            ms.a.a(str, "getVideoFrame start");
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < this.this$0.f66183f.getMediaModel().getMediaResourceModel().getVideos().size(); i3++) {
                MediaClipModel mediaClipModel = this.this$0.f66183f.getMediaModel().getMediaResourceModel().getVideos().get(i3);
                if (mediaClipModel.getResource().getPath() != null) {
                    arrayList.add(new a.C10136a(mediaClipModel.getResource().getPath(), mediaClipModel.getResource().getType(), mediaClipModel.getResource().getSourceTimeDuration()));
                }
            }
            this.this$0.f66169c = new cr.a().c(arrayList, this.f66173d, 250);
            str2 = e.f66182g;
            ms.a.a(str2, "getVideoFrame end");
            Logger.i("Cover", "get covers num =" + this.this$0.f66169c.size());
            e eVar = this.this$0;
            eVar.f66168b = eVar.f66169c.size();
            e eVar2 = this.this$0;
            eVar2.g(this.f66174e, eVar2.f66169c, null);
        }
    }
}
