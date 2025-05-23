package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class UnifySearchTabContent implements ISSOReqModel, ISSORspModel<UnifySearchTabContent> {
    public final String extension;

    /* renamed from: id, reason: collision with root package name */
    public final String f114291id;
    public final String layoutContent;
    public int layoutId;
    public final String name;
    public ISearchItemModel searchItem;
    public final long tabContentMask;

    public UnifySearchTabContent() {
        this(null, null, 0L, 0, null, null, 63, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("id", this.f114291id);
        eVar.v("name", this.name);
        eVar.u("tab_content_mask", this.tabContentMask);
        eVar.t("layout_id", this.layoutId);
        eVar.v("layout_content", this.layoutContent);
        eVar.v(MimeTypeParser.ATTR_EXTENSION, this.extension);
        return eVar;
    }

    public UnifySearchTabContent(String str, String str2, long j3, int i3, String str3, String str4) {
        this.f114291id = str;
        this.name = str2;
        this.tabContentMask = j3;
        this.layoutId = i3;
        this.layoutContent = str3;
        this.extension = str4;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchTabContent decode(e eVar) {
        return new UnifySearchTabContent(eVar.q("id", ""), eVar.q("name", ""), eVar.o("tab_content_mask", 0L), eVar.k("layout_id", 0), eVar.q("layout_content", ""), eVar.q(MimeTypeParser.ATTR_EXTENSION, ""));
    }

    public /* synthetic */ UnifySearchTabContent(String str, String str2, long j3, int i3, String str3, String str4, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", 0L, 0, "", "");
    }
}
