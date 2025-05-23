package com.tencent.mobileqq.emosm.emosearch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper;
import com.tencent.mobileqq.emoticonview.IEmotionHotPicSearchAdapter;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;

/* compiled from: P */
/* loaded from: classes6.dex */
public class e extends EmoticonPanelHotPicSearchHelper implements d {

    /* renamed from: d, reason: collision with root package name */
    private QQEmoticonMainPanelApp f204293d;

    /* renamed from: e, reason: collision with root package name */
    private Context f204294e;

    /* renamed from: f, reason: collision with root package name */
    private String f204295f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.panel.d f204296h;

    public e(IPanelInteractionListener iPanelInteractionListener, Context context, com.tencent.mobileqq.panel.d dVar) {
        super(iPanelInteractionListener);
        this.f204293d = new QQEmoticonMainPanelApp();
        this.f204294e = context;
        this.f204296h = dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.emosm.emosearch.d
    public void a(ViewGroup viewGroup, IEmotionHotPicSearchAdapter iEmotionHotPicSearchAdapter) {
        ListView listView = (ListView) viewGroup;
        attach(listView, (BaseEmotionAdapter) iEmotionHotPicSearchAdapter);
        View footerView = getFooterView();
        if (footerView.getParent() == null) {
            listView.addFooterView(footerView);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper
    public void clearSearchWords() {
        this.f204295f = null;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper
    public Context getContext() {
        return this.f204294e;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper
    public int getPageType() {
        return 2;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper, com.tencent.mobileqq.emosm.emosearch.c
    public String getSearchWord() {
        return this.f204295f;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper, com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public String getTag() {
        return "RichTextPanelEmoticonSearchLayoutHelper";
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper, com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPullDown() {
        this.f204296h.onPullDown();
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper, com.tencent.mobileqq.emosm.emosearch.c
    public void setSearchWords(String str) {
        this.f204295f = str;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper
    public QQEmoticonMainPanelApp getApp() {
        return this.f204293d;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper, com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPullUp() {
    }
}
