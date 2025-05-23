package com.tencent.mobileqq.guild.feed.presenter;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.util.GuildFeedTencentDocUI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextURLContent;
import qj1.w;

/* compiled from: P */
/* loaded from: classes13.dex */
public class i extends GuildBaseFeedChildPresenter<ij1.g> {
    private View F;
    private GuildFeedTencentDocUI G;

    public i(GuildFeedDefaultInitBean guildFeedDefaultInitBean) {
        super(guildFeedDefaultInitBean);
    }

    private void t(ij1.g gVar, int i3) {
        GProStRichTextContent u16 = u(gVar);
        if (u16 == null) {
            QLog.i("GuildFeedChildTencentDocPresenter", 1, "data is empty");
            this.G.e();
        } else {
            this.G.c(new w(u16), null);
        }
    }

    private GProStRichTextContent u(ij1.g gVar) {
        if (gVar != null && gVar.b() != null) {
            for (GProStRichTextContent gProStRichTextContent : gVar.b().contents.contents) {
                if (gProStRichTextContent.type == 3) {
                    GProStRichTextURLContent gProStRichTextURLContent = gProStRichTextContent.urlContent;
                    if (gProStRichTextURLContent.type == 3 && gProStRichTextURLContent.tencentDocsContent != null) {
                        return gProStRichTextContent;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void o(@NonNull View view) {
        super.o(view);
        gj1.a.a().d().requestPreloadViewForViewStub((ViewStub) view.findViewById(R.id.wbc), this);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter, com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader.RequestPreloadViewListener
    public void onPreloadResult(View view) {
        super.onPreloadResult(view);
        this.F = view;
        this.G = new GuildFeedTencentDocUI(this.F);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void k(ij1.g gVar, int i3) {
        super.k(gVar, i3);
        if (this.F != null) {
            t(gVar, i3);
        }
    }
}
